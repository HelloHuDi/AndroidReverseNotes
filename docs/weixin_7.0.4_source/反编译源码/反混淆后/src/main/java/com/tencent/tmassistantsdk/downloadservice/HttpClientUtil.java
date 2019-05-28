package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpClientUtil {
    public static void setProxy(HttpClient httpClient) {
        AppMethodBeat.m2504i(75768);
        String netStatus = DownloadHelper.getNetStatus();
        if (!TextUtils.isEmpty(netStatus)) {
            if (netStatus.equalsIgnoreCase("cmwap") || netStatus.equalsIgnoreCase("3gwap") || netStatus.equalsIgnoreCase("uniwap")) {
                httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost("10.0.0.172", 80));
                AppMethodBeat.m2505o(75768);
                return;
            } else if (netStatus.equalsIgnoreCase("ctwap")) {
                httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost("10.0.0.200", 80));
            }
        }
        AppMethodBeat.m2505o(75768);
    }

    public static HttpClient createHttpClient() {
        AppMethodBeat.m2504i(75769);
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 4096);
        HttpClientParams.setRedirecting(basicHttpParams, false);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        AppMethodBeat.m2505o(75769);
        return defaultHttpClient;
    }
}
