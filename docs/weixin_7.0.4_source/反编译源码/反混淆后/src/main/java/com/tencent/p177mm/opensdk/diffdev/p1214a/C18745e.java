package com.tencent.p177mm.opensdk.diffdev.p1214a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.utils.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.e */
public final class C18745e {
    /* renamed from: a */
    public static byte[] m29298a(String str) {
        byte[] bArr = null;
        AppMethodBeat.m2504i(128045);
        if (str == null || str.length() == 0) {
            Log.m4140e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
            AppMethodBeat.m2505o(128045);
        } else {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(str);
            try {
                HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), 60000);
                HttpResponse execute = defaultHttpClient.execute(httpGet);
                if (execute.getStatusLine().getStatusCode() != 200) {
                    Log.m4140e("MicroMsg.SDK.NetUtil", "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
                    AppMethodBeat.m2505o(128045);
                } else {
                    bArr = EntityUtils.toByteArray(execute.getEntity());
                    AppMethodBeat.m2505o(128045);
                }
            } catch (Exception e) {
                Log.m4140e("MicroMsg.SDK.NetUtil", "httpGet, Exception ex = " + e.getMessage());
                AppMethodBeat.m2505o(128045);
            } catch (IncompatibleClassChangeError e2) {
                Log.m4140e("MicroMsg.SDK.NetUtil", "httpGet, IncompatibleClassChangeError ex = " + e2.getMessage());
                AppMethodBeat.m2505o(128045);
            } catch (Throwable th) {
                Log.m4140e("MicroMsg.SDK.NetUtil", "httpGet, Throwable ex = " + th.getMessage());
                AppMethodBeat.m2505o(128045);
            }
        }
        return bArr;
    }
}
