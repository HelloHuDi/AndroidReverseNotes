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
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class c extends b {
    private final String filePath;
    private boolean rdN = true;
    private int rdO;
    private final String rdP;
    private final String rdQ;
    private final a rdR;
    private final int rdS;
    private int scene;

    public interface a {
        void BD(String str);

        void de(String str, int i);

        void lW(String str);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.i(37685);
        String cqh = cqh();
        AppMethodBeat.o(37685);
        return cqh;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(37684);
        String str = (String) obj;
        if (str != null) {
            this.rdR.BD(str);
            AppMethodBeat.o(37684);
            return;
        }
        this.rdR.lW(this.filePath);
        AppMethodBeat.o(37684);
    }

    public c(String str, String str2, int i, a aVar) {
        AppMethodBeat.i(37682);
        e.tf(str);
        this.filePath = str + "/" + str2;
        this.rdO = i;
        this.scene = 0;
        this.rdQ = "temp_".concat(String.valueOf(str2));
        this.rdP = str + "/" + this.rdQ;
        this.rdS = Downloads.SPLIT_RANGE_SIZE_WAP;
        this.rdR = aVar;
        AppMethodBeat.o(37682);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x02fa A:{SYNTHETIC, Splitter:B:52:0x02fa} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x02ff A:{Catch:{ IOException -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x041d A:{SYNTHETIC, Splitter:B:66:0x041d} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0422 A:{Catch:{ IOException -> 0x054a }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0427  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0547  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0427  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0547  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x055e A:{Splitter:B:9:0x0040, ExcHandler: Exception (e java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x041d A:{SYNTHETIC, Splitter:B:66:0x041d} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0422 A:{Catch:{ IOException -> 0x054a }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0427  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0547  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x047e  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:67:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:69:0x0422, code skipped:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:71:0x0427, code skipped:
            r2.disconnect();
     */
    /* JADX WARNING: Missing block: B:74:0x047e, code skipped:
            r0 = 1;
     */
    /* JADX WARNING: Missing block: B:77:0x0547, code skipped:
            r0 = 0;
     */
    /* JADX WARNING: Missing block: B:81:0x0552, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:82:0x0553, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:86:0x055e, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:87:0x055f, code skipped:
            r2 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private String cqh() {
        Exception e;
        Throwable th;
        String str;
        StringBuilder stringBuilder;
        AppMethodBeat.i(37683);
        if (e.ct(this.filePath)) {
            this.rdR.lW(this.filePath);
            AppMethodBeat.o(37683);
            return null;
        }
        long anU = bo.anU();
        int i = 0;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        HttpURLConnection httpURLConnection = null;
        String str2;
        String ck;
        int cos;
        int gb;
        d dVar;
        try {
            if (e.ct(this.rdP)) {
                e.deleteFile(this.rdP);
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.url).openConnection();
            int responseCode;
            try {
                httpURLConnection2.connect();
                responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    str2 = "Server returned HTTP " + httpURLConnection2.getResponseCode() + " " + httpURLConnection2.getResponseMessage();
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
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
                    dVar.l("26Size", "0,");
                    dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                    ab.i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                    h.pYm.e(13572, dVar);
                    AppMethodBeat.o(37683);
                    return str2;
                }
                int i2;
                httpURLConnection2.getContentLength();
                inputStream = httpURLConnection2.getInputStream();
                outputStream = e.L(this.rdP, false);
                byte[] bArr = new byte[4096];
                cos = 0;
                int i3 = 0;
                while (true) {
                    i2 = cos;
                    cos = inputStream.read(bArr);
                    if (cos != -1) {
                        outputStream.write(bArr, 0, cos);
                        cos += i2;
                        if (this.rdS != 0 && cos - i3 >= this.rdS) {
                            this.rdR.de(this.rdP, cos);
                            i3 = cos;
                        }
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            e = e2;
                            httpURLConnection = httpURLConnection2;
                            i = i2;
                            try {
                                str2 = e.getMessage();
                                if (outputStream != null) {
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
                                dVar.l("24RetCode", "-1,");
                                dVar.l("25Scene", this.scene + ",");
                                dVar.l("26Size", i + ",");
                                dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                                ab.i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                                h.pYm.e(13572, dVar);
                                AppMethodBeat.o(37683);
                                return str2;
                            } catch (Throwable th2) {
                                th = th2;
                                responseCode = -1;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection = httpURLConnection2;
                            i = i2;
                            if (outputStream != null) {
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
                            str = "22IsPreload";
                            stringBuilder = new StringBuilder();
                            if (this.rdN) {
                            }
                            dVar.l(str, stringBuilder.append(r0).append(",").toString());
                            dVar.l("23CostTime", gb + ",");
                            dVar.l("24RetCode", responseCode + ",");
                            dVar.l("25Scene", this.scene + ",");
                            dVar.l("26Size", i + ",");
                            dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                            ab.i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                            h.pYm.e(13572, dVar);
                            AppMethodBeat.o(37683);
                            throw th;
                        }
                    }
                }
                e.aQ(this.rdP, this.filePath);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                ck = ag.ck(this.url);
                i3 = cos();
                cos = (int) bo.gb(anU);
                d dVar2 = new d();
                dVar2.l("20UrlMd5", ck + ",");
                dVar2.l("21MediaType", i3 + ",");
                dVar2.l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                dVar2.l("23CostTime", cos + ",");
                dVar2.l("24RetCode", responseCode + ",");
                dVar2.l("25Scene", this.scene + ",");
                dVar2.l("26Size", i2 + ",");
                dVar2.l("27StartDownloadTime", (anU / 1000) + ",");
                ab.i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar2.Fk());
                h.pYm.e(13572, dVar2);
                AppMethodBeat.o(37683);
                return null;
            } catch (Exception e4) {
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                responseCode = 0;
                if (outputStream != null) {
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
                str = "22IsPreload";
                stringBuilder = new StringBuilder();
                if (this.rdN) {
                }
                dVar.l(str, stringBuilder.append(r0).append(",").toString());
                dVar.l("23CostTime", gb + ",");
                dVar.l("24RetCode", responseCode + ",");
                dVar.l("25Scene", this.scene + ",");
                dVar.l("26Size", i + ",");
                dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                ab.i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                h.pYm.e(13572, dVar);
                AppMethodBeat.o(37683);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            str2 = e.getMessage();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e6) {
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
                    dVar.l("24RetCode", "-1,");
                    dVar.l("25Scene", this.scene + ",");
                    dVar.l("26Size", i + ",");
                    dVar.l("27StartDownloadTime", (anU / 1000) + ",");
                    ab.i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
                    h.pYm.e(13572, dVar);
                    AppMethodBeat.o(37683);
                    return str2;
                }
            }
            if (inputStream != null) {
                inputStream.close();
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
            dVar.l("24RetCode", "-1,");
            dVar.l("25Scene", this.scene + ",");
            dVar.l("26Size", i + ",");
            dVar.l("27StartDownloadTime", (anU / 1000) + ",");
            ab.i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Fk());
            h.pYm.e(13572, dVar);
            AppMethodBeat.o(37683);
            return str2;
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
