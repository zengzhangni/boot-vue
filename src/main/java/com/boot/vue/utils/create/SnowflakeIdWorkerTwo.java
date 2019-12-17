package com.boot.vue.utils.create;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class SnowflakeIdWorkerTwo {
    // 开始时间截 (从2018-08-18 05:11:07起)
    private static final long START_TIME = 1534540267000L;
    // 机器ID所占位数
    private static final long ID_BITS = 10L;
    // 机器ID最大值1023 (此移位算法可很快计算出n位二进制数所能表示的最大十进制数)
    public static final long MAX_ID = ~(-1L << ID_BITS);
    // Sequence所占位数
    public static final long SEQUENCE_BITS = 12L;
    // 机器ID偏移量12
    public static final long ID_SHIFT_BITS = SEQUENCE_BITS;
    // 时间戳的偏移量12+10=22
    public static final long TIMESTAMP_LEFT_SHIFT_BITS = SEQUENCE_BITS + ID_BITS;
    // Sequence掩码4095
    public static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);
    // 机器ID掩码1023
    public static final long ID_MASK = ~(-1L << ID_BITS);
    // 时间戳掩码2的41次方减1
    public static final long TIMESTAMP_MASK = ~(-1L << 41L);
    // 上一毫秒数
    private static long lastTimestamp = -1L;
    // 毫秒内Sequence(0~4095)
    private static long sequence = 0L;
    // 机器ID(0-1023)
    private final long workerId;

    public SnowflakeIdWorkerTwo(long workerId) {
        if (workerId > MAX_ID || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", MAX_ID));
        }
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        // 如果是同一时间生成的，则进行毫秒内sequence生成
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            // 溢出处理
            if (sequence == 0) { // 阻塞到下一毫秒,获得新时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else { // 时间戳改变，毫秒内sequence重置
            sequence = 0L;
        }
        // 上次生成ID时间截
        lastTimestamp = timestamp;

        // 移位并通过或运算组成64位ID
        return ((timestamp - START_TIME) << TIMESTAMP_LEFT_SHIFT_BITS) | (workerId << ID_SHIFT_BITS) | sequence;
    }

    /**
     * 阻塞到下一毫秒,获得新时间戳
     *
     * @param lastTimestamp 上次生成ID时间截
     * @return 当前时间戳
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 获取以毫秒为单位的当前时间
     *
     * @return 当前时间(毫秒)
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 对id进行解析
     *
     * @param id 生成的ID
     * @return sequence, worker, timeStamp
     */
    public long[] expId(long id) {
        long[] strings = {(id & SEQUENCE_MASK), ((id >>> SEQUENCE_BITS) & ID_MASK),
                ((id >>> TIMESTAMP_LEFT_SHIFT_BITS) & TIMESTAMP_MASK)};
        return strings;
    }

    /**
     * 对时间戳单独进行解析
     *
     * @param time 时间戳
     * @return 生成的Date时间
     */
    public Date transTime(long time) {
        return new Date(time + START_TIME);
    }

    public String transTimeToFormat(long time) {
        return DateUtil.format(transTime(time), "yyyy-MM-dd HH:mm:ss");
    }
}
