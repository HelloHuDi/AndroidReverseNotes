package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bf;
import com.tencent.tencentmap.mapsdk.a.ds;
import com.tencent.tencentmap.mapsdk.a.dt;
import com.tencent.tencentmap.mapsdk.a.v;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class jf extends hf {
    private Context a;
    private bf b = new bf();
    private byte[] c = null;
    private String d = "UNKNOW";
    private String e = "";
    private f f;

    public jf(iz izVar) {
        AppMethodBeat.i(100030);
        this.a = izVar.i();
        this.d = this.a.getClass().getSimpleName();
        this.a = this.a.getApplicationContext();
        this.f = izVar.b();
        AppMethodBeat.o(100030);
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
    public byte[] a(String str) {
        Closeable closeable;
        Throwable th;
        HttpURLConnection httpURLConnection;
        AppMethodBeat.i(100031);
        if (this.a == null || str == null || str.trim().length() == 0) {
            AppMethodBeat.o(100031);
            return null;
        }
        if (!(this.f == null || !StringUtil.isEmpty(this.e) || StringUtil.isEmpty(this.f.G()))) {
            this.e = "&eng_ver=" + this.f.G();
        }
        if (this.b.a(str)) {
            if (str != null) {
                str = str.replace("http://", "https://").replace("/mvd_map", hs.b()).replace("/mobile_newmap", hs.b());
            }
            String a = hs.a(str);
            int i = (a.contains("styleid") && a.contains("scene") && a.contains("version")) ? 1 : 0;
            if (i == 0) {
                String str2;
                if (a.endsWith(FileUtils.PIC_POSTFIX_JPEG) || a.startsWith("https://closedroadvector.map.qq.com/closed_road_v2?") || a.startsWith("https://p0.map.gtimg.com/scenic/")) {
                    str2 = a;
                } else {
                    str2 = a + this.e + ic.c(this.d);
                }
                try {
                    dt a2 = ds.a().a(str2, "androidsdk");
                    if (a2 == null) {
                        AppMethodBeat.o(100031);
                        return null;
                    }
                    if (!a.contains("qt=rtt")) {
                        this.b.b(a);
                    }
                    if (a.startsWith("https://p0.map.gtimg.com/scenic/") && a2.a != null && a2.a.length == 0) {
                        if (this.c == null) {
                            Bitmap createBitmap = Bitmap.createBitmap(256, 256, Config.ARGB_8888);
                            new Canvas(createBitmap).drawARGB(0, 255, 255, 255);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            createBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                            this.c = byteArrayOutputStream.toByteArray();
                        }
                        a2.a = this.c;
                    }
                    byte[] bArr = a2.a;
                    AppMethodBeat.o(100031);
                    return bArr;
                } catch (Exception e) {
                    AppMethodBeat.o(100031);
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
                            byte[] a3 = v.a((InputStream) inputStream);
                            if (!a.contains("qt=rtt")) {
                                this.b.b(a);
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (inputStream != null) {
                                v.a(inputStream);
                            }
                            AppMethodBeat.o(100031);
                            return a3;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                            }
                            if (inputStream != null) {
                            }
                            AppMethodBeat.o(100031);
                            throw th;
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.o(100031);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    AppMethodBeat.o(100031);
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
                    v.a(inputStream);
                }
                AppMethodBeat.o(100031);
                throw th;
            }
        }
        AppMethodBeat.o(100031);
        return null;
    }
}
