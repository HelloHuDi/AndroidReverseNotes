package com.tencent.p177mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.downloader.model.f */
public final class C33922f {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Iy */
    public static String m55521Iy(String str) {
        Exception e;
        String str2;
        Throwable th;
        AppMethodBeat.m2504i(2450);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(1000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    C4990ab.m7417i("MicroMsg.FileDownloadUtil", "code : %d, md5 : %s", Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Weixin-File-MD5"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(2450);
                    return r1;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        C4990ab.m7413e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        str2 = "";
                        AppMethodBeat.m2505o(2450);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.m2505o(2450);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(2450);
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            str2 = "";
            AppMethodBeat.m2505o(2450);
            return str2;
        } catch (Exception e3) {
            e = e3;
            C4990ab.m7413e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", e.getMessage());
            if (httpURLConnection != null) {
            }
            str2 = "";
            AppMethodBeat.m2505o(2450);
            return str2;
        }
    }

    /* renamed from: c */
    public static C42911a m55522c(C2900e c2900e) {
        AppMethodBeat.m2504i(2451);
        C42911a c42911a = new C42911a();
        c42911a.field_downloadUrl = c2900e.gUx;
        c42911a.field_secondaryUrl = c2900e.kMZ;
        c42911a.field_fileSize = c2900e.mFileSize;
        c42911a.field_downloadUrlHashCode = c2900e.gUx.hashCode();
        c42911a.field_fileName = c2900e.mFileName;
        c42911a.field_fileType = c2900e.kNb;
        c42911a.field_md5 = c2900e.kNa;
        c42911a.field_appId = c2900e.mAppId;
        c42911a.field_autoInstall = c2900e.kNc;
        c42911a.field_showNotification = c2900e.hzG;
        c42911a.field_packageName = c2900e.mPackageName;
        c42911a.field_autoDownload = c2900e.kNe;
        c42911a.field_scene = c2900e.gOW;
        c42911a.field_downloadInWifi = c2900e.hyG;
        c42911a.field_fromWeApp = c2900e.kNh;
        c42911a.field_extInfo = c2900e.hxK;
        c42911a.field_isSecondDownload = c2900e.kNi;
        c42911a.field_fromDownloadApp = c2900e.kNj;
        c42911a.field_reserveInWifi = c2900e.hyG;
        AppMethodBeat.m2505o(2451);
        return c42911a;
    }
}
