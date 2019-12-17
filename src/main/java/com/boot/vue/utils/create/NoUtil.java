package com.boot.vue.utils.create;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class NoUtil {

    public static String getFileName(String suffix) {
        String file = "FILE" + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN);
        return CreateNo.getInstance().GenerateNo(file, 5) + suffix;
    }

    /**
     * 获取用户code
     */
    public static String getUserCode() {
        String file = "USER" + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN);
        return CreateNo.getInstance().GenerateNo(file, 5);
    }

    /**
     * 获取房子code
     */
    public static String getHouseCode() {
        String file = "HOUSE" + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN);
        return CreateNo.getInstance().GenerateNo(file, 5);
    }

    /**
     * 获取订单code
     */
    public static String getOrderCode() {
        String file = "ORDER" + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN);
        return CreateNo.getInstance().GenerateNo(file, 5);
    }

    /**
     * 获取随机数
     */
    public static String getRandom(Integer num) {
        Random random = new Random();
        StringBuilder fourRandom = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            fourRandom.append(random.nextInt(9));
        }
        return fourRandom.toString();
    }


    public static String getHouseImg() {
        return imgs.get(new Random().nextInt(imgs.size()));
    }

    public static String getUserImg() {
        return userImgs.get(new Random().nextInt(userImgs.size()));
    }


    private static List<String> imgs = Arrays.asList(
            "https://dss2.bdstatic.com/8_V1bjqh_Q23odCf/pacific/1938931936.jpg",
            "https://dss2.bdstatic.com/8_V1bjqh_Q23odCf/pacific/1938931937.jpg",
            "https://dss2.bdstatic.com/8_V1bjqh_Q23odCf/pacific/1938931938.jpg",
            "https://dss2.bdstatic.com/8_V1bjqh_Q23odCf/pacific/1938931939.jpg",
            "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2650997126,1968471698&fm=26&gp=0.jpg",
            "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2196472719,4224358363&fm=26&gp=0.jpg",
            "https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3828163524,132023956&fm=26&gp=0.jpg",
            "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2868765074,2126036385&fm=26&gp=0.jpg",
            "https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1939781107,104904841&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3065840876,3990315061&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1108489442,226740095&fm=26&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=457367346,1392389240&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4190700178,1321529957&fm=26&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3177736957,2653474769&fm=26&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4056462483,191990063&fm=26&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4229955965,3924657074&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2785190797,2260800949&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=471984450,3728187156&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2485690123,2839565906&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2517456173,563370150&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1532066823,4128005420&fm=26&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1818769040,862628173&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3767021539,1856694811&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1506222994,2020971813&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=123235028,837570269&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2611887578,2801165671&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3440890456,3443906298&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4147226325,1577853668&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1863586026,3369883718&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=12613419,203765012&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1953089493,4080586715&fm=26&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4242596142,4229712901&fm=26&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3511191854,3755052586&fm=26&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3240739607,3763406474&fm=26&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1634712674,2165304666&fm=26&gp=0.jpg"
    );

    private static List<String> userImgs = Arrays.asList(
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3169807314,712464218&fm=26&gp=0.jpg",
            "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1138161326,660784661&fm=26&gp=0.jpg",
            "https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1275450516,1235270513&fm=26&gp=0.jpg",
            "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1145626845,869921922&fm=26&gp=0.jpg"
    );

}
