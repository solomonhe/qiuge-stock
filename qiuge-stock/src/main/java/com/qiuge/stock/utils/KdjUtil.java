package com.qiuge.stock.utils;//package com.qiuge.stock.util;
//
//import java.util.ArrayList;
//
///**
// * KdjUtil
// *
// * @author Solomon
// * @date 2021/12/08
// */
//
//public class KdjUtil {
//    /**
//     * kdj 9,3,3
//     * N:=9; P1:=3; P2:=3;
//     * RSV:=(CLOSE-L(LOW,N))/(H(HIGH,N)-L(LOW,N))*100;
//     * K:SMA(RSV,P1,1);
//     * D:SMA(K,P2,1);
//     * J:3*K-2*D;
//     * @param entries 数据集合
//     * @param n 指标周期 9
//     * @param m 权重 1
//     * @param P1 参数值为3
//     * @param P2 参数值为3
//     * @return
//     */
//    public static List[] getKDJ(List<CandleEntry> entries, int n, int P1, int P2, int m) {
//        List<Entry> kValue = new ArrayList();
//        List<Entry> dValue = new ArrayList();
//        List<Entry> jValue = new ArrayList();
//
//        List<Entry> maxs = getPeriodHighest(entries, n);
//        List<Entry> mins = getPeriodLowest(entries, n);
//        //确保和 传入的list size一致，
//        int size = entries.size() - maxs.size();
//        for (int i = 0; i < size; i++) {
//            maxs.add(0, new Entry());
//            mins.add(0, new Entry());
//        }
//        float rsv = 0;
//        float lastK = 50;
//        float lastD = 50;
//
//        for (int i = n - 1; i < entries.size(); i++) {
//            float x = entries.get(i).getX();
//            if (i >= maxs.size())
//                break;
//            if (i >= mins.size())
//                break;
//            float div = maxs.get(i).getY() - mins.get(i).getY();
//            if (div == 0) {
//                //使用上一次的
//            } else {
//                rsv = ((entries.get(i).getClose() - mins.get(i).getY())
//                        / (div)) * 100;
//            }
//
//            float k = countSMA(rsv, P1, m, lastK);
//            float d = countSMA(k, P2, m, lastD);
//            float j = 3 * k - 2 * d;
//            lastK = k;
//            lastD = d;
//            kValue.add(new Entry(x, k));
//            dValue.add(new Entry(x, d));
//            jValue.add(new Entry(x, j));
//        }
//
//        return new List[]{kValue, dValue, jValue};
//    }
//
//    /**
//     * SMA(C,N,M) = (M*C+(N-M)*Y')/N
//     * C=今天收盘价－昨天收盘价    N＝就是周期比如 6或者12或者24， M＝权重，一般取1
//     *
//     * @param c   今天收盘价－昨天收盘价
//     * @param n   周期
//     * @param m   1
//     * @param sma 上一个周期的sma
//     * @return
//     */
//    private static float countSMA(float c, float n, float m, float sma) {
//        return (m * c + (n - m) * sma) / n;
//    }
//
//    /**
//     * n周期内最低值集合
//     * @param entries
//     * @param n
//     * @return
//     */
//    private static List<Entry> getPeriodLowest(List<CandleEntry> entries, int n) {
//        List<Entry> result = new ArrayList<>();
//        float minValue = 0;
//        for (int i = n - 1; i < entries.size(); i++) {
//            float x = entries.get(i).getX();
//            for (int j = i - n + 1; j <= i; j++) {
//                if (j == i - n + 1) {
//                    minValue = entries.get(j).getLow();
//                } else {
//                    minValue = Math.min(minValue, entries.get(j).getLow());
//                }
//            }
//            result.add(new Entry(x, minValue));
//        }
//        return result;
//    }
//
//    /**
//     *  N周期内最高值集合
//     * @param entries
//     * @param n
//     * @return
//     */
//    private static List<Entry> getPeriodHighest(List<CandleEntry> entries, int n) {
//        List<Entry> result = new ArrayList<>();
//        float maxValue = entries.get(0).getHigh();
//        for (int i = n - 1; i < entries.size(); i++) {
//            float x = entries.get(i).getX();
//            for (int j = i - n + 1; j <= i; j++) {
//                if (j == i - n + 1) {
//                    maxValue = entries.get(j).getHigh();
//                } else {
//                    maxValue = Math.max(maxValue, entries.get(j).getHigh());
//                }
//            }
//            result.add(new Entry(x, maxValue));
//        }
//        return result;
//    }
//}
