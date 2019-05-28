package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c */
public final class C36810c extends C34987b {
    private final String filePath;
    private boolean rdN = true;
    private int rdO;
    private final String rdP;
    private final String rdQ;
    private final C3948a rdR;
    private final int rdS;
    private int scene;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c$a */
    public interface C3948a {
        /* renamed from: BD */
        void mo8717BD(String str);

        /* renamed from: de */
        void mo8718de(String str, int i);

        /* renamed from: lW */
        void mo8719lW(String str);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.m2504i(37685);
        String cqh = cqh();
        AppMethodBeat.m2505o(37685);
        return cqh;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.m2504i(37684);
        String str = (String) obj;
        if (str != null) {
            this.rdR.mo8717BD(str);
            AppMethodBeat.m2505o(37684);
            return;
        }
        this.rdR.mo8719lW(this.filePath);
        AppMethodBeat.m2505o(37684);
    }

    public C36810c(String str, String str2, int i, C3948a c3948a) {
        AppMethodBeat.m2504i(37682);
        C5730e.m8643tf(str);
        this.filePath = str + "/" + str2;
        this.rdO = i;
        this.scene = 0;
        this.rdQ = "temp_".concat(String.valueOf(str2));
        this.rdP = str + "/" + this.rdQ;
        this.rdS = Downloads.SPLIT_RANGE_SIZE_WAP;
        this.rdR = c3948a;
        AppMethodBeat.m2505o(37682);
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
        AppMethodBeat.m2504i(37683);
        if (C5730e.m8628ct(this.filePath)) {
            this.rdR.mo8719lW(this.filePath);
            AppMethodBeat.m2505o(37683);
            return null;
        }
        long anU = C5046bo.anU();
        int i = 0;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        HttpURLConnection httpURLConnection = null;
        String str2;
        String ck;
        int cos;
        int gb;
        C32831d c32831d;
        try {
            if (C5730e.m8628ct(this.rdP)) {
                C5730e.deleteFile(this.rdP);
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
                    ck = C4995ag.m7428ck(this.url);
                    cos = cos();
                    gb = (int) C5046bo.m7566gb(anU);
                    c32831d = new C32831d();
                    c32831d.mo53400l("20UrlMd5", ck + ",");
                    c32831d.mo53400l("21MediaType", cos + ",");
                    c32831d.mo53400l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                    c32831d.mo53400l("23CostTime", gb + ",");
                    c32831d.mo53400l("24RetCode", responseCode + ",");
                    c32831d.mo53400l("25Scene", this.scene + ",");
                    c32831d.mo53400l("26Size", "0,");
                    c32831d.mo53400l("27StartDownloadTime", (anU / 1000) + ",");
                    C4990ab.m7416i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + c32831d.mo53398Fk());
                    C7060h.pYm.mo8381e(13572, c32831d);
                    AppMethodBeat.m2505o(37683);
                    return str2;
                }
                int i2;
                httpURLConnection2.getContentLength();
                inputStream = httpURLConnection2.getInputStream();
                outputStream = C5730e.m8617L(this.rdP, false);
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
                            this.rdR.mo8718de(this.rdP, cos);
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
                                ck = C4995ag.m7428ck(this.url);
                                cos = cos();
                                gb = (int) C5046bo.m7566gb(anU);
                                c32831d = new C32831d();
                                c32831d.mo53400l("20UrlMd5", ck + ",");
                                c32831d.mo53400l("21MediaType", cos + ",");
                                if (this.rdN) {
                                }
                                c32831d.mo53400l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                                c32831d.mo53400l("23CostTime", gb + ",");
                                c32831d.mo53400l("24RetCode", "-1,");
                                c32831d.mo53400l("25Scene", this.scene + ",");
                                c32831d.mo53400l("26Size", i + ",");
                                c32831d.mo53400l("27StartDownloadTime", (anU / 1000) + ",");
                                C4990ab.m7416i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + c32831d.mo53398Fk());
                                C7060h.pYm.mo8381e(13572, c32831d);
                                AppMethodBeat.m2505o(37683);
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
                            ck = C4995ag.m7428ck(this.url);
                            cos = cos();
                            gb = (int) C5046bo.m7566gb(anU);
                            c32831d = new C32831d();
                            c32831d.mo53400l("20UrlMd5", ck + ",");
                            c32831d.mo53400l("21MediaType", cos + ",");
                            str = "22IsPreload";
                            stringBuilder = new StringBuilder();
                            if (this.rdN) {
                            }
                            c32831d.mo53400l(str, stringBuilder.append(r0).append(",").toString());
                            c32831d.mo53400l("23CostTime", gb + ",");
                            c32831d.mo53400l("24RetCode", responseCode + ",");
                            c32831d.mo53400l("25Scene", this.scene + ",");
                            c32831d.mo53400l("26Size", i + ",");
                            c32831d.mo53400l("27StartDownloadTime", (anU / 1000) + ",");
                            C4990ab.m7416i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + c32831d.mo53398Fk());
                            C7060h.pYm.mo8381e(13572, c32831d);
                            AppMethodBeat.m2505o(37683);
                            throw th;
                        }
                    }
                }
                C5730e.m8623aQ(this.rdP, this.filePath);
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
                ck = C4995ag.m7428ck(this.url);
                i3 = cos();
                cos = (int) C5046bo.m7566gb(anU);
                C32831d c32831d2 = new C32831d();
                c32831d2.mo53400l("20UrlMd5", ck + ",");
                c32831d2.mo53400l("21MediaType", i3 + ",");
                c32831d2.mo53400l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                c32831d2.mo53400l("23CostTime", cos + ",");
                c32831d2.mo53400l("24RetCode", responseCode + ",");
                c32831d2.mo53400l("25Scene", this.scene + ",");
                c32831d2.mo53400l("26Size", i2 + ",");
                c32831d2.mo53400l("27StartDownloadTime", (anU / 1000) + ",");
                C4990ab.m7416i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + c32831d2.mo53398Fk());
                C7060h.pYm.mo8381e(13572, c32831d2);
                AppMethodBeat.m2505o(37683);
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
                ck = C4995ag.m7428ck(this.url);
                cos = cos();
                gb = (int) C5046bo.m7566gb(anU);
                c32831d = new C32831d();
                c32831d.mo53400l("20UrlMd5", ck + ",");
                c32831d.mo53400l("21MediaType", cos + ",");
                str = "22IsPreload";
                stringBuilder = new StringBuilder();
                if (this.rdN) {
                }
                c32831d.mo53400l(str, stringBuilder.append(r0).append(",").toString());
                c32831d.mo53400l("23CostTime", gb + ",");
                c32831d.mo53400l("24RetCode", responseCode + ",");
                c32831d.mo53400l("25Scene", this.scene + ",");
                c32831d.mo53400l("26Size", i + ",");
                c32831d.mo53400l("27StartDownloadTime", (anU / 1000) + ",");
                C4990ab.m7416i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + c32831d.mo53398Fk());
                C7060h.pYm.mo8381e(13572, c32831d);
                AppMethodBeat.m2505o(37683);
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
                    ck = C4995ag.m7428ck(this.url);
                    cos = cos();
                    gb = (int) C5046bo.m7566gb(anU);
                    c32831d = new C32831d();
                    c32831d.mo53400l("20UrlMd5", ck + ",");
                    c32831d.mo53400l("21MediaType", cos + ",");
                    c32831d.mo53400l("22IsPreload", (this.rdN ? 1 : 0) + ",");
                    c32831d.mo53400l("23CostTime", gb + ",");
                    c32831d.mo53400l("24RetCode", "-1,");
                    c32831d.mo53400l("25Scene", this.scene + ",");
                    c32831d.mo53400l("26Size", i + ",");
                    c32831d.mo53400l("27StartDownloadTime", (anU / 1000) + ",");
                    C4990ab.m7416i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + c32831d.mo53398Fk());
                    C7060h.pYm.mo8381e(13572, c32831d);
                    AppMethodBeat.m2505o(37683);
                    return str2;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
            }
            ck = C4995ag.m7428ck(this.url);
            cos = cos();
            gb = (int) C5046bo.m7566gb(anU);
            c32831d = new C32831d();
            c32831d.mo53400l("20UrlMd5", ck + ",");
            c32831d.mo53400l("21MediaType", cos + ",");
            if (this.rdN) {
            }
            c32831d.mo53400l("22IsPreload", (this.rdN ? 1 : 0) + ",");
            c32831d.mo53400l("23CostTime", gb + ",");
            c32831d.mo53400l("24RetCode", "-1,");
            c32831d.mo53400l("25Scene", this.scene + ",");
            c32831d.mo53400l("26Size", i + ",");
            c32831d.mo53400l("27StartDownloadTime", (anU / 1000) + ",");
            C4990ab.m7416i("MicroMsg.AdLandingPageDownloadBigFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + c32831d.mo53398Fk());
            C7060h.pYm.mo8381e(13572, c32831d);
            AppMethodBeat.m2505o(37683);
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
