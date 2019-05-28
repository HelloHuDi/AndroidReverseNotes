package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String Iy(String str) {
        Exception e;
        String str2;
        Throwable th;
        AppMethodBeat.i(2450);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(1000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    ab.i("MicroMsg.FileDownloadUtil", "code : %d, md5 : %s", Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Weixin-File-MD5"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.o(2450);
                    return r1;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        ab.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        str2 = "";
                        AppMethodBeat.o(2450);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.o(2450);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.o(2450);
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            str2 = "";
            AppMethodBeat.o(2450);
            return str2;
        } catch (Exception e3) {
            e = e3;
            ab.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", e.getMessage());
            if (httpURLConnection != null) {
            }
            str2 = "";
            AppMethodBeat.o(2450);
            return str2;
        }
    }

    public static a c(e eVar) {
        AppMethodBeat.i(2451);
        a aVar = new a();
        aVar.field_downloadUrl = eVar.gUx;
        aVar.field_secondaryUrl = eVar.kMZ;
        aVar.field_fileSize = eVar.mFileSize;
        aVar.field_downloadUrlHashCode = eVar.gUx.hashCode();
        aVar.field_fileName = eVar.mFileName;
        aVar.field_fileType = eVar.kNb;
        aVar.field_md5 = eVar.kNa;
        aVar.field_appId = eVar.mAppId;
        aVar.field_autoInstall = eVar.kNc;
        aVar.field_showNotification = eVar.hzG;
        aVar.field_packageName = eVar.mPackageName;
        aVar.field_autoDownload = eVar.kNe;
        aVar.field_scene = eVar.gOW;
        aVar.field_downloadInWifi = eVar.hyG;
        aVar.field_fromWeApp = eVar.kNh;
        aVar.field_extInfo = eVar.hxK;
        aVar.field_isSecondDownload = eVar.kNi;
        aVar.field_fromDownloadApp = eVar.kNj;
        aVar.field_reserveInWifi = eVar.hyG;
        AppMethodBeat.o(2451);
        return aVar;
    }
}
