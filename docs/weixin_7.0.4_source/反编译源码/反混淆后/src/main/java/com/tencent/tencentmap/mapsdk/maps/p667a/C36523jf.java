package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C16193dt;
import com.tencent.tencentmap.mapsdk.p666a.C31006ds;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
import com.tencent.tencentmap.mapsdk.p666a.C36458bf;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jf */
public class C36523jf extends C24386hf {
    /* renamed from: a */
    private Context f15425a;
    /* renamed from: b */
    private C36458bf f15426b = new C36458bf();
    /* renamed from: c */
    private byte[] f15427c = null;
    /* renamed from: d */
    private String f15428d = "UNKNOW";
    /* renamed from: e */
    private String f15429e = "";
    /* renamed from: f */
    private C8889f f15430f;

    public C36523jf(C31061iz c31061iz) {
        AppMethodBeat.m2504i(100030);
        this.f15425a = c31061iz.mo65138i();
        this.f15428d = this.f15425a.getClass().getSimpleName();
        this.f15425a = this.f15425a.getApplicationContext();
        this.f15430f = c31061iz.mo75386b();
        AppMethodBeat.m2505o(100030);
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public byte[] mo40646a(String str) {
        Closeable closeable;
        Throwable th;
        HttpURLConnection httpURLConnection;
        AppMethodBeat.m2504i(100031);
        if (this.f15425a == null || str == null || str.trim().length() == 0) {
            AppMethodBeat.m2505o(100031);
            return null;
        }
        if (!(this.f15430f == null || !StringUtil.isEmpty(this.f15429e) || StringUtil.isEmpty(this.f15430f.mo20144G()))) {
            this.f15429e = "&eng_ver=" + this.f15430f.mo20144G();
        }
        if (this.f15426b.mo57657a(str)) {
            if (str != null) {
                str = str.replace("http://", "https://").replace("/mvd_map", C46790hs.m88920b()).replace("/mobile_newmap", C46790hs.m88920b());
            }
            String a = C46790hs.m88919a(str);
            int i = (a.contains("styleid") && a.contains("scene") && a.contains("version")) ? 1 : 0;
            if (i == 0) {
                String str2;
                if (a.endsWith(FileUtils.PIC_POSTFIX_JPEG) || a.startsWith("https://closedroadvector.map.qq.com/closed_road_v2?") || a.startsWith("https://p0.map.gtimg.com/scenic/")) {
                    str2 = a;
                } else {
                    str2 = a + this.f15429e + C36520ic.m60490c(this.f15428d);
                }
                try {
                    C16193dt a2 = C31006ds.m49791a().mo50282a(str2, "androidsdk");
                    if (a2 == null) {
                        AppMethodBeat.m2505o(100031);
                        return null;
                    }
                    if (!a.contains("qt=rtt")) {
                        this.f15426b.mo57658b(a);
                    }
                    if (a.startsWith("https://p0.map.gtimg.com/scenic/") && a2.f3096a != null && a2.f3096a.length == 0) {
                        if (this.f15427c == null) {
                            Bitmap createBitmap = Bitmap.createBitmap(256, 256, Config.ARGB_8888);
                            new Canvas(createBitmap).drawARGB(0, 255, 255, 255);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            createBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                            this.f15427c = byteArrayOutputStream.toByteArray();
                        }
                        a2.f3096a = this.f15427c;
                    }
                    byte[] bArr = a2.f3096a;
                    AppMethodBeat.m2505o(100031);
                    return bArr;
                } catch (Exception e) {
                    AppMethodBeat.m2505o(100031);
                    return null;
                }
            }
            HttpURLConnection httpURLConnection2;
            Closeable inputStream;
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(a).openConnection();
                try {
                    httpURLConnection2.addRequestProperty("User-Agent", "androidsdk");
                    httpURLConnection2.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                    if (httpURLConnection2.getResponseCode() == 200) {
                        inputStream = httpURLConnection2.getInputStream();
                        try {
                            byte[] a3 = C31015v.m49803a((InputStream) inputStream);
                            if (!a.contains("qt=rtt")) {
                                this.f15426b.mo57658b(a);
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (inputStream != null) {
                                C31015v.m49801a(inputStream);
                            }
                            AppMethodBeat.m2505o(100031);
                            return a3;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                            }
                            if (inputStream != null) {
                            }
                            AppMethodBeat.m2505o(100031);
                            throw th;
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(100031);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    AppMethodBeat.m2505o(100031);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                httpURLConnection = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    C31015v.m49801a(inputStream);
                }
                AppMethodBeat.m2505o(100031);
                throw th;
            }
        }
        AppMethodBeat.m2505o(100031);
        return null;
    }
}
