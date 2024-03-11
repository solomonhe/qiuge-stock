package com.qiuge.stock.openapi.bean;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.qiuge.stock.domain.SwTradeInfo;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * 新浪财经
 * SinaUtil
 *
 * @author Solomon
 * @date 2021/09/08
 */
@Service
@Slf4j
public class SwUtil {
    /**
     * 申万官网基础URL
     */
    private final static String SW_BASE_URL = "http://www.swsindex.com/handler.aspx";

    public static final MediaType form = MediaType.get("application/x-www-form-urlencoded");

    /**
     * 全部Url
     * @param page
     * @param pageCount
     * @return
     */
    public static String allUrl(int page,long pageCount) {

        String startDate = "2017-09-29";
        String endDate = "2021-09-29";
        StringBuilder builder = new StringBuilder();
        return builder.append(SW_BASE_URL)
                .append("?tablename=V_Report&")
                .append("key=id&")
                .append("p=")
                .append(page)
                .append("&where= swindexcode in ('801011','801012','801013','801014','801015','801016','801021','801022','801023','801032','801033','801034','801035','801036','801037','801041','801051','801072','801073','801074','801075','801081','801082','801083','801084','801092','801093','801094','801101','801102','801111','801112','801123','801131','801132','801141','801142','801143','801151','801152','801153','801154','801155','801156','801161','801162','801163','801164','801171','801172','801173','801174','801175','801176','801177','801178','801181','801182','801191','801192','801193','801194','801202','801211','801212','801213','801214','801222','801223','801231','801053','801054','801055','801076','801203','801204','801205','801711','801712','801713','801721','801722','801723','801724','801725','801731','801732','801733','801734','801741','801742','801743','801744','801751','801752','801761','801881','801017','801018') and  BargainDate>='"+startDate+"' and  BargainDate<='"+endDate+"' and type='Day'&")
                .append("orderby=swindexcode asc,BargainDate_1&")
                .append("fieldlist=SwIndexCode,SwIndexName,BargainDate,CloseIndex,BargainAmount,Markup,TurnoverRate,PE,PB,MeanPrice,BargainSumRate,NegotiablesShareSum,NegotiablesShareSum2,DP&")
                .append("pagecount=")
                .append(pageCount)
                .append("&timed=")
                .append(System.currentTimeMillis()).toString();
    }


    /**
     * 昨天URl
     * @param page
     * @return
     */
    public static String dayUrl(int page,long pageCount) {
        StringBuilder builder = new StringBuilder();
        return builder.append(SW_BASE_URL)
                .append("?tablename=V_Report&")
                .append("key=id&")
                .append("p=")
                .append(page)
                .append("&where=BargainDate = (select max(bargaindate) from SwIndexQuotation  where   swindexcode='801003' )  and   type='day'  and swindexcode in ('801011','801012','801013','801014','801015','801016','801021','801022','801023','801032','801033','801034','801035','801036','801037','801041','801051','801072','801073','801074','801075','801081','801082','801083','801084','801092','801093','801094','801101','801102','801111','801112','801123','801131','801132','801141','801142','801143','801151','801152','801153','801154','801155','801156','801161','801162','801163','801164','801171','801172','801173','801174','801175','801176','801177','801178','801181','801182','801191','801192','801193','801194','801202','801211','801212','801213','801214','801222','801223','801231','801053','801054','801055','801076','801203','801204','801205','801711','801712','801713','801721','801722','801723','801724','801725','801731','801732','801733','801734','801741','801742','801743','801744','801751','801752','801761','801881','801017','801018')&")
                .append("orderby=swindexcode asc,BargainDate_1&")
                .append("fieldlist=SwIndexCode,SwIndexName,BargainDate,CloseIndex,BargainAmount,Markup,TurnoverRate,PE,PB,MeanPrice,BargainSumRate,NegotiablesShareSum,NegotiablesShareSum2,DP&")
                .append("pagecount=")
                .append(pageCount)
                .append("&timed=")
                .append(System.currentTimeMillis()).toString();
    }

    /**
     * 获取申王二级昨天行业数据
     *
     * @return
     */
    public synchronized List<SwTradeInfo> getDaySwTradeTwo(int page, long pageCount) {
        String url = this.dayUrl(page, pageCount);
        return this.send(url);
    }


    /**
     * 获取申王二级历史行业数据
     *
     * @return
     */
    public synchronized List<SwTradeInfo> getAllSwTradeTwo(int page, long pageCount) {
        String url = this.allUrl(page, pageCount);
        return this.send(url);
    }

    private List<SwTradeInfo> send(String url){
        String post = this.get(url);
        Object root = JSONObject.parseObject(post).get("root");
        return JSONArray.parseArray(JSONObject.toJSONString(root), SwTradeInfo.class);
    }



    private String post(String url, String json) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(form, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    private String get(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
