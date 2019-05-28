package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public final class e {
    public static byte[] a(String str) {
        byte[] bArr = null;
        AppMethodBeat.i(128045);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
            AppMethodBeat.o(128045);
        } else {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(str);
            try {
                HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), 60000);
                HttpResponse execute = defaultHttpClient.execute(httpGet);
                if (execute.getStatusLine().getStatusCode() != 200) {
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
                    AppMethodBeat.o(128045);
                } else {
                    bArr = EntityUtils.toByteArray(execute.getEntity());
                    AppMethodBeat.o(128045);
                }
            } catch (Exception e) {
                Log.e("MicroMsg.SDK.NetUtil", "httpGet, Exception ex = " + e.getMessage());
                AppMethodBeat.o(128045);
            } catch (IncompatibleClassChangeError e2) {
                Log.e("MicroMsg.SDK.NetUtil", "httpGet, IncompatibleClassChangeError ex = " + e2.getMessage());
                AppMethodBeat.o(128045);
            } catch (Throwable th) {
                Log.e("MicroMsg.SDK.NetUtil", "httpGet, Throwable ex = " + th.getMessage());
                AppMethodBeat.o(128045);
            }
        }
        return bArr;
    }
}
