package com.tencent.p177mm.plugin.freewifi.p1549a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C45955h.C39112b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/* renamed from: com.tencent.mm.plugin.freewifi.a.a */
public final class C45949a {
    private static final int muZ = C39112b.mtY.byh();
    private static final int mva = C39112b.mtY.byi();

    /* renamed from: com.tencent.mm.plugin.freewifi.a.a$a */
    public interface C39099a {
        /* renamed from: g */
        void mo7408g(HttpURLConnection httpURLConnection);

        /* renamed from: j */
        void mo7409j(Exception exception);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.a.a$b */
    static class C45948b {
        private static C45949a mvb = new C45949a();

        static {
            AppMethodBeat.m2504i(20656);
            AppMethodBeat.m2505o(20656);
        }
    }

    /* synthetic */ C45949a(byte b) {
        this();
    }

    private C45949a() {
    }

    public static C45949a byw() {
        AppMethodBeat.m2504i(20657);
        C45949a byx = C45948b.mvb;
        AppMethodBeat.m2505o(20657);
        return byx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070 A:{Splitter:B:7:0x002c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070 A:{Splitter:B:7:0x002c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:13:0x0058, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:15:?, code skipped:
            r6.mo7409j(r1);
     */
    /* JADX WARNING: Missing block: B:22:0x006b, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            r6.mo7409j(r1);
     */
    /* JADX WARNING: Missing block: B:25:0x0070, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:26:0x0071, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:28:0x0074, code skipped:
            r2.disconnect();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m85337a(String str, C39099a c39099a) {
        Exception e;
        AppMethodBeat.m2504i(20658);
        C4990ab.m7417i("MicroMsg.FreeWifi.HttpTemplate", "method=request, desc=it starts a http GET request. url=%s.", str);
        if (C34189m.isEmpty(str)) {
            AppMethodBeat.m2505o(20658);
            return;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(muZ);
                    httpURLConnection2.setReadTimeout(mva);
                    httpURLConnection2.setRequestProperty("User-Agent", C39112b.mtY.getUserAgent());
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    c39099a.mo7408g(httpURLConnection2);
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th) {
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
                AppMethodBeat.m2505o(20658);
                return;
            }
        } catch (Exception e3) {
            e = e3;
            try {
                c39099a.mo7409j(e);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    AppMethodBeat.m2505o(20658);
                    return;
                }
                AppMethodBeat.m2505o(20658);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(20658);
                throw th3;
            }
        }
        AppMethodBeat.m2505o(20658);
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a0 A:{Splitter:B:13:0x0058, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a0 A:{Splitter:B:13:0x0058, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:46:0x0189, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:47:0x018a, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:55:0x01a0, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:56:0x01a1, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:58:0x01a4, code skipped:
            r2.disconnect();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m85338a(String str, String str2, C39099a c39099a) {
        Exception e;
        AppMethodBeat.m2504i(20659);
        C4990ab.m7417i("MicroMsg.FreeWifi.HttpTemplate", "method=requestPost, desc=it starts a http POST request. url=%s, postParams=%s.", str, str2);
        if (C34189m.isEmpty(str) || C34189m.isEmpty(str2)) {
            AppMethodBeat.m2505o(20659);
            return;
        }
        String str3;
        if (str2 == null || "".equalsIgnoreCase(str2)) {
            str3 = "";
        } else {
            String str4 = "";
            String[] split = str2.split("&");
            int i = 1;
            while (i <= 10) {
                String concat = "key".concat(String.valueOf(i));
                String concat2 = "value".concat(String.valueOf(i));
                str3 = null;
                String str5 = null;
                for (String str6 : split) {
                    if (str6.indexOf(concat) >= 0 && str6.split("=").length == 2) {
                        str3 = str6.split("=")[1];
                    } else if (str6.indexOf(concat2) >= 0 && str6.split("=").length == 2) {
                        str5 = str6.split("=")[1];
                    }
                }
                if (str3 == null || str5 == null) {
                    break;
                }
                if (i == 1) {
                    str5 = str4 + str3 + "=" + str5;
                } else {
                    str5 = str4 + "&" + str3 + "=" + str5;
                }
                i++;
                str4 = str5;
            }
            str3 = str4;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.HttpTemplate", "method=requestPost, desc=it extracts PostParams. url=%s, postParams=%s", str, str3);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(muZ);
                    httpURLConnection2.setReadTimeout(mva);
                    httpURLConnection2.setRequestProperty("User-Agent", C39112b.mtY.getUserAgent());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection2.setRequestProperty("charset", ProtocolPackage.ServerEncoding);
                    httpURLConnection2.setUseCaches(false);
                    byte[] bytes = str3.getBytes(Charset.forName("UTF-8"));
                    httpURLConnection2.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    c39099a.mo7408g(httpURLConnection2);
                } catch (IOException e2) {
                    c39099a.mo7409j(e2);
                } catch (Exception e3) {
                    c39099a.mo7409j(e3);
                } catch (Throwable th) {
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
                AppMethodBeat.m2505o(20659);
                return;
            }
        } catch (Exception e4) {
            e3 = e4;
            try {
                c39099a.mo7409j(e3);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    AppMethodBeat.m2505o(20659);
                    return;
                }
                AppMethodBeat.m2505o(20659);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(20659);
                throw th3;
            }
        }
        AppMethodBeat.m2505o(20659);
    }

    static {
        AppMethodBeat.m2504i(20660);
        AppMethodBeat.m2505o(20660);
    }
}
