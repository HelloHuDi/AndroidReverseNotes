package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f extends b {
    private a reg;

    public interface a {
        void YJ(String str);

        void cmD();

        void cpu();
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.i(37719);
        String cqh = cqh();
        AppMethodBeat.o(37719);
        return cqh;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(37718);
        if (((String) obj) == null) {
            this.reg.YJ(this.filePath);
            AppMethodBeat.o(37718);
            return;
        }
        this.reg.cmD();
        AppMethodBeat.o(37718);
    }

    public f(String str, String str2, boolean z, int i, int i2, a aVar) {
        this.url = str;
        this.filePath = str2;
        this.rdN = z;
        this.rdO = i;
        this.scene = 0;
        this.reg = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0538 A:{SYNTHETIC, Splitter:B:80:0x0538} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x053d A:{Catch:{ IOException -> 0x065e }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x065b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0418 A:{SYNTHETIC, Splitter:B:66:0x0418} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x041d A:{Catch:{ IOException -> 0x0685 }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0538 A:{SYNTHETIC, Splitter:B:80:0x0538} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x053d A:{Catch:{ IOException -> 0x065e }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x065b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0418 A:{SYNTHETIC, Splitter:B:66:0x0418} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x041d A:{Catch:{ IOException -> 0x0685 }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0538 A:{SYNTHETIC, Splitter:B:80:0x0538} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x053d A:{Catch:{ IOException -> 0x065e }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x065b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0418 A:{SYNTHETIC, Splitter:B:66:0x0418} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x041d A:{Catch:{ IOException -> 0x0685 }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0538 A:{SYNTHETIC, Splitter:B:80:0x0538} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x053d A:{Catch:{ IOException -> 0x065e }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x065b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0418 A:{SYNTHETIC, Splitter:B:66:0x0418} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x041d A:{Catch:{ IOException -> 0x0685 }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0538 A:{SYNTHETIC, Splitter:B:80:0x0538} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x053d A:{Catch:{ IOException -> 0x065e }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x065b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x065b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private String cqh() {
        Exception e;
        HttpURLConnection httpURLConnection;
        Object obj;
        Object obj2;
        int i;
        Throwable th;
        OutputStream L;
        InputStream inputStream;
        int cos;
        String str = null;
        AppMethodBeat.i(37717);
        if (e.ct(this.filePath)) {
            AppMethodBeat.o(37717);
            return str;
        }
        long anU = bo.anU();
        e.tf(this.filePath.substring(0, this.filePath.lastIndexOf("/")));
        this.reg.cpu();
        int responseCode;
        String ck;
        int cos2;
        int gb;
        d dVar;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.url).openConnection();
            try {
                httpURLConnection2.connect();
                responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    try {
                        this.reg.cmD();
                        str = "Server returned HTTP " + httpURLConnection2.getResponseCode() + " " + httpURLConnection2.getResponseMessage();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        ck = ag.ck(this.url);
                        cos2 = cos();
                        gb = (int) bo.gb(anU);
                        dVar = new d();
                        dVar.l("20UrlMd5", ck + ",");
                        dVar.l("21MediaType", cos2 + ",");
                        dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                        dVar.l("23CostTime", gb + ",");
                        dVar.l("24RetCode", responseCode + ",");
                        dVar.l("25Scene", this.scene + ",");
                        dVar.l("26Size", "0,");
                        dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                        ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                        h.pYm.e(13572, dVar);
                        AppMethodBeat.o(37717);
                        return str;
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        obj = str;
                        obj2 = str;
                        i = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        obj = str;
                        obj2 = str;
                        i = 0;
                        if (L != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        ck = ag.ck(this.url);
                        cos = cos();
                        gb = (int) bo.gb(anU);
                        dVar = new d();
                        dVar.l("20UrlMd5", ck + ",");
                        dVar.l("21MediaType", cos + ",");
                        if (this.rdN) {
                        }
                        dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                        dVar.l("23CostTime", gb + ",");
                        dVar.l("24RetCode", responseCode + ",");
                        dVar.l("25Scene", this.scene + ",");
                        dVar.l("26Size", i + ",");
                        dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                        ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                        h.pYm.e(13572, dVar);
                        AppMethodBeat.o(37717);
                        throw th;
                    }
                }
                httpURLConnection2.getContentLength();
                inputStream = httpURLConnection2.getInputStream();
                try {
                    L = e.L(this.filePath, false);
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = httpURLConnection2;
                    obj = str;
                    i = 0;
                    try {
                        this.reg.cmD();
                        e.deleteFile(this.filePath);
                        responseCode = -1;
                        str = e.toString();
                        if (L != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        ck = ag.ck(this.url);
                        cos2 = cos();
                        gb = (int) bo.gb(anU);
                        dVar = new d();
                        dVar.l("20UrlMd5", ck + ",");
                        dVar.l("21MediaType", cos2 + ",");
                        if (this.rdN) {
                        }
                        dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                        dVar.l("23CostTime", gb + ",");
                        dVar.l("24RetCode", "-1,");
                        dVar.l("25Scene", this.scene + ",");
                        dVar.l("26Size", i + ",");
                        dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                        ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                        h.pYm.e(13572, dVar);
                        AppMethodBeat.o(37717);
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = httpURLConnection2;
                    obj = str;
                    i = 0;
                    if (L != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    ck = ag.ck(this.url);
                    cos = cos();
                    gb = (int) bo.gb(anU);
                    dVar = new d();
                    dVar.l("20UrlMd5", ck + ",");
                    dVar.l("21MediaType", cos + ",");
                    if (this.rdN) {
                    }
                    dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                    dVar.l("23CostTime", gb + ",");
                    dVar.l("24RetCode", responseCode + ",");
                    dVar.l("25Scene", this.scene + ",");
                    dVar.l("26Size", i + ",");
                    dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                    ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                    h.pYm.e(13572, dVar);
                    AppMethodBeat.o(37717);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[4096];
                    i = 0;
                    while (true) {
                        try {
                            gb = inputStream.read(bArr);
                            if (gb == -1) {
                                if (L != null) {
                                    try {
                                        L.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                ck = ag.ck(this.url);
                                cos2 = cos();
                                gb = (int) bo.gb(anU);
                                dVar = new d();
                                dVar.l("20UrlMd5", ck + ",");
                                dVar.l("21MediaType", cos2 + ",");
                                dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                                dVar.l("23CostTime", gb + ",");
                                dVar.l("24RetCode", responseCode + ",");
                                dVar.l("25Scene", this.scene + ",");
                                dVar.l("26Size", i + ",");
                                dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                                ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                                h.pYm.e(13572, dVar);
                                AppMethodBeat.o(37717);
                                return str;
                            } else if (isCancelled()) {
                                inputStream.close();
                                if (L != null) {
                                    try {
                                        L.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                ck = ag.ck(this.url);
                                cos2 = cos();
                                gb = (int) bo.gb(anU);
                                dVar = new d();
                                dVar.l("20UrlMd5", ck + ",");
                                dVar.l("21MediaType", cos2 + ",");
                                dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                                dVar.l("23CostTime", gb + ",");
                                dVar.l("24RetCode", responseCode + ",");
                                dVar.l("25Scene", this.scene + ",");
                                dVar.l("26Size", i + ",");
                                dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                                ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                                h.pYm.e(13572, dVar);
                                AppMethodBeat.o(37717);
                                return str;
                            } else {
                                L.write(bArr, 0, gb);
                                i += gb;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            httpURLConnection = httpURLConnection2;
                            this.reg.cmD();
                            e.deleteFile(this.filePath);
                            responseCode = -1;
                            str = e.toString();
                            if (L != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            ck = ag.ck(this.url);
                            cos2 = cos();
                            gb = (int) bo.gb(anU);
                            dVar = new d();
                            dVar.l("20UrlMd5", ck + ",");
                            dVar.l("21MediaType", cos2 + ",");
                            if (this.rdN) {
                            }
                            dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                            dVar.l("23CostTime", gb + ",");
                            dVar.l("24RetCode", "-1,");
                            dVar.l("25Scene", this.scene + ",");
                            dVar.l("26Size", i + ",");
                            dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                            ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                            h.pYm.e(13572, dVar);
                            AppMethodBeat.o(37717);
                            return str;
                        } catch (Throwable th5) {
                            th = th5;
                            httpURLConnection = httpURLConnection2;
                            if (L != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            ck = ag.ck(this.url);
                            cos = cos();
                            gb = (int) bo.gb(anU);
                            dVar = new d();
                            dVar.l("20UrlMd5", ck + ",");
                            dVar.l("21MediaType", cos + ",");
                            if (this.rdN) {
                            }
                            dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                            dVar.l("23CostTime", gb + ",");
                            dVar.l("24RetCode", responseCode + ",");
                            dVar.l("25Scene", this.scene + ",");
                            dVar.l("26Size", i + ",");
                            dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                            ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                            h.pYm.e(13572, dVar);
                            AppMethodBeat.o(37717);
                            throw th;
                        }
                    }
                } catch (Exception e62) {
                    e = e62;
                    httpURLConnection = httpURLConnection2;
                    i = 0;
                    this.reg.cmD();
                    e.deleteFile(this.filePath);
                    responseCode = -1;
                    str = e.toString();
                    if (L != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    ck = ag.ck(this.url);
                    cos2 = cos();
                    gb = (int) bo.gb(anU);
                    dVar = new d();
                    dVar.l("20UrlMd5", ck + ",");
                    dVar.l("21MediaType", cos2 + ",");
                    if (this.rdN) {
                    }
                    dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                    dVar.l("23CostTime", gb + ",");
                    dVar.l("24RetCode", "-1,");
                    dVar.l("25Scene", this.scene + ",");
                    dVar.l("26Size", i + ",");
                    dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                    ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                    h.pYm.e(13572, dVar);
                    AppMethodBeat.o(37717);
                    return str;
                } catch (Throwable th52) {
                    th = th52;
                    httpURLConnection = httpURLConnection2;
                    i = 0;
                    if (L != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    ck = ag.ck(this.url);
                    cos = cos();
                    gb = (int) bo.gb(anU);
                    dVar = new d();
                    dVar.l("20UrlMd5", ck + ",");
                    dVar.l("21MediaType", cos + ",");
                    if (this.rdN) {
                    }
                    dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                    dVar.l("23CostTime", gb + ",");
                    dVar.l("24RetCode", responseCode + ",");
                    dVar.l("25Scene", this.scene + ",");
                    dVar.l("26Size", i + ",");
                    dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                    ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                    h.pYm.e(13572, dVar);
                    AppMethodBeat.o(37717);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                httpURLConnection = httpURLConnection2;
                obj = str;
                obj2 = str;
                i = 0;
                responseCode = 0;
                this.reg.cmD();
                e.deleteFile(this.filePath);
                responseCode = -1;
                str = e.toString();
                if (L != null) {
                    try {
                        L.close();
                    } catch (IOException e8) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        ck = ag.ck(this.url);
                        cos2 = cos();
                        gb = (int) bo.gb(anU);
                        dVar = new d();
                        dVar.l("20UrlMd5", ck + ",");
                        dVar.l("21MediaType", cos2 + ",");
                        dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                        dVar.l("23CostTime", gb + ",");
                        dVar.l("24RetCode", "-1,");
                        dVar.l("25Scene", this.scene + ",");
                        dVar.l("26Size", i + ",");
                        dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                        ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                        h.pYm.e(13572, dVar);
                        AppMethodBeat.o(37717);
                        return str;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                }
                ck = ag.ck(this.url);
                cos2 = cos();
                gb = (int) bo.gb(anU);
                dVar = new d();
                dVar.l("20UrlMd5", ck + ",");
                dVar.l("21MediaType", cos2 + ",");
                if (this.rdN) {
                }
                dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                dVar.l("23CostTime", gb + ",");
                dVar.l("24RetCode", "-1,");
                dVar.l("25Scene", this.scene + ",");
                dVar.l("26Size", i + ",");
                dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                h.pYm.e(13572, dVar);
                AppMethodBeat.o(37717);
                return str;
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = httpURLConnection2;
                obj = str;
                obj2 = str;
                i = 0;
                responseCode = 0;
                if (L != null) {
                    try {
                        L.close();
                    } catch (IOException e9) {
                        if (httpURLConnection != null) {
                        }
                        ck = ag.ck(this.url);
                        cos = cos();
                        gb = (int) bo.gb(anU);
                        dVar = new d();
                        dVar.l("20UrlMd5", ck + ",");
                        dVar.l("21MediaType", cos + ",");
                        if (this.rdN) {
                        }
                        dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                        dVar.l("23CostTime", gb + ",");
                        dVar.l("24RetCode", responseCode + ",");
                        dVar.l("25Scene", this.scene + ",");
                        dVar.l("26Size", i + ",");
                        dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                        ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                        h.pYm.e(13572, dVar);
                        AppMethodBeat.o(37717);
                        throw th;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                ck = ag.ck(this.url);
                cos = cos();
                gb = (int) bo.gb(anU);
                dVar = new d();
                dVar.l("20UrlMd5", ck + ",");
                dVar.l("21MediaType", cos + ",");
                dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                dVar.l("23CostTime", gb + ",");
                dVar.l("24RetCode", responseCode + ",");
                dVar.l("25Scene", this.scene + ",");
                dVar.l("26Size", i + ",");
                dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                h.pYm.e(13572, dVar);
                AppMethodBeat.o(37717);
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            httpURLConnection = str;
            L = str;
            inputStream = str;
            i = 0;
            responseCode = 0;
            this.reg.cmD();
            e.deleteFile(this.filePath);
            responseCode = -1;
            str = e.toString();
            if (L != null) {
            }
            if (inputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            ck = ag.ck(this.url);
            cos2 = cos();
            gb = (int) bo.gb(anU);
            dVar = new d();
            dVar.l("20UrlMd5", ck + ",");
            dVar.l("21MediaType", cos2 + ",");
            if (this.rdN) {
            }
            dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
            dVar.l("23CostTime", gb + ",");
            dVar.l("24RetCode", "-1,");
            dVar.l("25Scene", this.scene + ",");
            dVar.l("26Size", i + ",");
            dVar.l("27StartDownloadTime", (anU / 1000) + ",");
            ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
            h.pYm.e(13572, dVar);
            AppMethodBeat.o(37717);
            return str;
        } catch (Throwable th32) {
            th = th32;
            httpURLConnection = str;
            L = str;
            inputStream = str;
            i = 0;
            responseCode = 0;
            if (L != null) {
            }
            if (inputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            ck = ag.ck(this.url);
            cos = cos();
            gb = (int) bo.gb(anU);
            dVar = new d();
            dVar.l("20UrlMd5", ck + ",");
            dVar.l("21MediaType", cos + ",");
            if (this.rdN) {
            }
            dVar.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
            dVar.l("23CostTime", gb + ",");
            dVar.l("24RetCode", responseCode + ",");
            dVar.l("25Scene", this.scene + ",");
            dVar.l("26Size", i + ",");
            dVar.l("27StartDownloadTime", (anU / 1000) + ",");
            ab.i("MicroMsg.AdLandingPageDownloadSmallFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
            h.pYm.e(13572, dVar);
            AppMethodBeat.o(37717);
            throw th;
        }
    }

    private int cos() {
        switch (this.rdO) {
            case 41:
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
            case 1000000001:
                return 1;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                return 2;
            case 62:
                return 3;
            default:
                return 0;
        }
    }
}
