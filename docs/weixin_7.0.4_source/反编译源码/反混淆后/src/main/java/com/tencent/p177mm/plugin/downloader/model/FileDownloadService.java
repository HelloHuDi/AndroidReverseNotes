package com.tencent.p177mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p376d.C11506c;
import com.tencent.p177mm.plugin.downloader.p376d.C42910e;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.service.MMIntentService;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.downloader.model.FileDownloadService */
public class FileDownloadService extends MMIntentService {
    public static final String EXTRA_ID = (kNm + "id");
    public static final String EXTRA_PACKAGE_NAME = (kNm + "package_name");
    private static final String kNm = (FileDownloadService.class.getSimpleName() + "_extra_");
    public static final String kNn = (kNm + ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
    public static final String kNo = (kNm + "file_path");
    public static final String kNp = (kNm + "md5");
    public static final String kNq = (kNm + "change_url");

    static {
        AppMethodBeat.m2504i(2445);
        AppMethodBeat.m2505o(2445);
    }

    public FileDownloadService() {
        super("FileDownloadService");
    }

    public final void onHandleIntent(Intent intent) {
        AppMethodBeat.m2504i(2442);
        if (intent == null) {
            AppMethodBeat.m2505o(2442);
            return;
        }
        C4990ab.m7417i("MicroMsg.FileDownloadService", "handle intent type : %d", Integer.valueOf(intent.getIntExtra(kNn, 0)));
        long currentTimeMillis;
        String absolutePath;
        C42911a hv;
        switch (intent.getIntExtra(kNn, 0)) {
            case 1:
                long longExtra = intent.getLongExtra(EXTRA_ID, -1);
                if (longExtra < 0) {
                    C4990ab.m7412e("MicroMsg.FileDownloadService", "Invalid id");
                    AppMethodBeat.m2505o(2442);
                    return;
                }
                if (C1720g.m3534RN().mo5161QY()) {
                    C1720g.m3534RN();
                    if (!C1668a.m3393QT()) {
                        C42911a hv2 = C2895c.m5147hv(longExtra);
                        if (hv2 != null) {
                            boolean z;
                            if (intent.getBooleanExtra(kNq, false) || hv2.field_isSecondDownload) {
                                z = true;
                            } else {
                                z = false;
                            }
                            C4990ab.m7416i("MicroMsg.FileDownloadService", "filePath = " + hv2.field_filePath);
                            C2896d bij;
                            if (C5046bo.isNullOrNil(hv2.field_filePath) || !C5730e.m8628ct(hv2.field_filePath)) {
                                C7060h.pYm.mo8378a(710, 5, 1, false);
                                hv2.field_status = 4;
                                hv2.field_errCode = C11498a.kKa;
                                C2895c.m5146e(hv2);
                                bij = C2896d.bij();
                                C4990ab.m7417i("MicroMsg.FileDownloadManager", "onDownloadFailed, id = %d, errCode = %d", Long.valueOf(longExtra), Integer.valueOf(C11498a.kKa));
                                if (bij.kMT != null) {
                                    bij.kMT.mo7025d(longExtra, r3, z);
                                }
                                C4990ab.m7416i("MicroMsg.FileDownloadService", "file not exists, appid = " + hv2.field_appId);
                                AppMethodBeat.m2505o(2442);
                                return;
                            } else if (C5046bo.isNullOrNil(hv2.field_md5)) {
                                C4990ab.m7416i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
                                hv2.field_status = 3;
                                C2895c.m5146e(hv2);
                                C2896d.bij().mo7052o(longExtra, z);
                                AppMethodBeat.m2505o(2442);
                                return;
                            } else {
                                long j;
                                String str;
                                boolean z2;
                                String str2;
                                C45405b c45405b;
                                long j2;
                                int i;
                                String str3 = "";
                                if (C5046bo.isNullOrNil(hv2.field_appId)) {
                                    j = 0;
                                    str = str3;
                                } else {
                                    currentTimeMillis = System.currentTimeMillis();
                                    try {
                                        File file = new File(hv2.field_filePath);
                                        absolutePath = file.getAbsolutePath();
                                        boolean Il = C11506c.m19303Il(absolutePath);
                                        String str4 = "MicroMsg.Channel.GameChannelUtil";
                                        String str5 = "apkPath:%s, this is %s signature";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = absolutePath;
                                        objArr[1] = Il ? "v2" : "v1";
                                        C4990ab.m7417i(str4, str5, objArr);
                                        absolutePath = null;
                                        if (Il) {
                                            absolutePath = C11506c.m19305L(file);
                                        }
                                        if (absolutePath == null) {
                                            absolutePath = C11506c.m19304K(file);
                                            if (Il && absolutePath != null) {
                                                C4990ab.m7416i("MicroMsg.Channel.GameChannelUtil", "you are use v2 signature but use v1 channel modle, this apk will can't install in 7.0system");
                                            }
                                        }
                                        C4990ab.m7417i("MicroMsg.Channel.GameChannelUtil", "readChannel, channelId = %s", absolutePath);
                                    } catch (Exception e) {
                                        C4990ab.m7412e("MicroMsg.FileDownloadService", "readChannelId exception : " + e.getMessage());
                                        absolutePath = str3;
                                    }
                                    currentTimeMillis = 0 + (System.currentTimeMillis() - currentTimeMillis);
                                    C4990ab.m7417i("MicroMsg.FileDownloadService", "readChannelId, channelId:%s, cost time: %d", absolutePath, Long.valueOf(r6));
                                    j = currentTimeMillis;
                                    str = absolutePath;
                                }
                                boolean J = FileDownloadService.m31431J(hv2.field_filePath, hv2.field_md5, hv2.field_appId);
                                if (z) {
                                    if (J) {
                                        C45405b.eBF.mo60571j(hv2.field_appId, 21);
                                        C45405b.eBF.mo73201a(hv2.field_appId, 108, hv2.field_downloadId, str, 0, hv2.field_reserveInWifi ? 1 : 0);
                                    } else {
                                        C45405b.eBF.mo60571j(hv2.field_appId, 22);
                                        C45405b.eBF.mo73201a(hv2.field_appId, 109, hv2.field_downloadId, str, 0, hv2.field_reserveInWifi ? 1 : 0);
                                    }
                                }
                                if (!J) {
                                    if (hv2.field_downloadUrl.startsWith("https")) {
                                        C45405b.eBF.mo60571j(hv2.field_appId, 32);
                                    } else {
                                        C45405b.eBF.mo60571j(hv2.field_appId, 31);
                                    }
                                }
                                if (J || C5046bo.isNullOrNil(hv2.field_appId)) {
                                    z2 = J;
                                    str2 = str;
                                } else {
                                    int i2;
                                    boolean z3 = false;
                                    currentTimeMillis = System.currentTimeMillis();
                                    try {
                                        z3 = C42910e.m76185e(new File(hv2.field_filePath), "10000145");
                                    } catch (Exception e2) {
                                        C4990ab.m7412e("MicroMsg.FileDownloadService", "writeChannelId exception : " + e2.getMessage());
                                    }
                                    long currentTimeMillis2 = j + (System.currentTimeMillis() - currentTimeMillis);
                                    C4990ab.m7417i("MicroMsg.FileDownloadService", "writeChannelId result:%b, cost time: %d", Boolean.valueOf(z3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    C4990ab.m7417i("MicroMsg.FileDownloadService", "channel opration cost time: %d", Long.valueOf(currentTimeMillis2));
                                    if (z3) {
                                        z3 = FileDownloadService.m31431J(hv2.field_filePath, hv2.field_md5, hv2.field_appId);
                                        C4990ab.m7417i("MicroMsg.FileDownloadService", "after modify channel, ret:%b", Boolean.valueOf(z3));
                                        if (z3) {
                                            str = "10000145";
                                            i2 = 102;
                                            C45405b.eBF.mo60571j(hv2.field_appId, 24);
                                            z2 = z3;
                                        } else {
                                            i2 = 103;
                                            C45405b.eBF.mo60571j(hv2.field_appId, 25);
                                            z2 = z3;
                                        }
                                    } else {
                                        i2 = 101;
                                        C45405b.eBF.mo60571j(hv2.field_appId, 23);
                                        z2 = J;
                                    }
                                    C45405b.eBF.mo73201a(hv2.field_appId, i2, hv2.field_downloadId, str, currentTimeMillis2, hv2.field_reserveInWifi ? 1 : 0);
                                    if (!z) {
                                        switch (i2) {
                                            case 101:
                                                i2 = 104;
                                                C45405b.eBF.mo60571j(hv2.field_appId, 26);
                                                break;
                                            case 102:
                                                i2 = 105;
                                                C45405b.eBF.mo60571j(hv2.field_appId, 27);
                                                break;
                                            case 103:
                                                i2 = 106;
                                                C45405b.eBF.mo60571j(hv2.field_appId, 28);
                                                break;
                                            default:
                                                i2 = 0;
                                                break;
                                        }
                                        C45405b.eBF.mo73201a(hv2.field_appId, i2, hv2.field_downloadId, str, 0, hv2.field_reserveInWifi ? 1 : 0);
                                    }
                                    if (z2 && !FileDownloadService.m31432j(z, hv2.field_secondaryUrl)) {
                                        c45405b = C45405b.eBF;
                                        str3 = hv2.field_appId;
                                        j2 = hv2.field_downloadId;
                                        if (hv2.field_reserveInWifi) {
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        c45405b.mo73201a(str3, 107, j2, str, 0, i);
                                        C45405b.eBF.mo60571j(hv2.field_appId, 29);
                                    }
                                    str2 = str;
                                }
                                if (z2) {
                                    hv2.field_status = 3;
                                    hv2.field_channelId = str2;
                                    C2895c.m5146e(hv2);
                                    C2896d.bij().mo7052o(longExtra, z);
                                    AppMethodBeat.m2505o(2442);
                                    return;
                                }
                                if (hv2.field_downloaderType == 3) {
                                    if (hv2.field_downloadUrl.startsWith("https")) {
                                        C7060h.pYm.mo8378a(710, 10, 1, false);
                                    } else {
                                        C7060h.pYm.mo8378a(710, 9, 1, false);
                                    }
                                } else if (hv2.field_downloadUrl.startsWith("https")) {
                                    C7060h.pYm.mo8378a(710, 7, 1, false);
                                } else {
                                    C7060h.pYm.mo8378a(710, 6, 1, false);
                                }
                                hv2.field_status = 4;
                                hv2.field_channelId = str2;
                                hv2.field_errCode = C11498a.kJW;
                                hv2.field_downloadedSize = C5730e.asZ(hv2.field_filePath);
                                C2895c.m5146e(hv2);
                                C4990ab.m7417i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", str2, Long.valueOf(hv2.field_downloadedSize), Long.valueOf(C5730e.asZ(hv2.field_filePath)));
                                C4990ab.m7417i("MicroMsg.FileDownloadService", "delete file: %s", hv2.field_filePath);
                                C5730e.deleteFile(hv2.field_filePath);
                                str3 = "MicroMsg.FileDownloadService";
                                String str6 = "checkMd5, isWifi: %b, hasChangeUrl: %b, hasHttpsUrl: %b";
                                Object[] objArr2 = new Object[3];
                                objArr2[0] = Boolean.valueOf(C5023at.isWifi(C4996ah.getContext()));
                                objArr2[1] = Boolean.valueOf(z);
                                objArr2[2] = Boolean.valueOf(!C5046bo.isNullOrNil(hv2.field_secondaryUrl));
                                C4990ab.m7417i(str3, str6, objArr2);
                                if (FileDownloadService.m31432j(z, hv2.field_secondaryUrl)) {
                                    long j3;
                                    C2901a c2901a = new C2901a();
                                    c2901a.mo7055It(hv2.field_secondaryUrl);
                                    c2901a.mo7066hA(hv2.field_fileSize);
                                    c2901a.mo7057Iv(hv2.field_fileName);
                                    c2901a.setAppId(hv2.field_appId);
                                    c2901a.mo7058Iw(hv2.field_md5);
                                    c2901a.setScene(hv2.field_scene);
                                    c2901a.mo7059Ix(hv2.field_extInfo);
                                    c2901a.kNl.kNg = true;
                                    c2901a.mo7063ga(true);
                                    c2901a.mo7069tN(1);
                                    c2901a.mo7062cY(hv2.field_packageName);
                                    c2901a.kNl.kNi = true;
                                    if (hv2.field_downloaderType != 3) {
                                        j = C2896d.bij().mo7042a(c2901a.kNl);
                                        C7060h.pYm.mo8378a(710, 8, 1, false);
                                        j3 = j;
                                    } else {
                                        j = C2896d.bij().mo7043b(c2901a.kNl);
                                        C7060h.pYm.mo8378a(710, 11, 1, false);
                                        j3 = j;
                                    }
                                    C4990ab.m7416i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = ".concat(String.valueOf(j3)));
                                    c45405b = C45405b.eBF;
                                    str3 = hv2.field_appId;
                                    j2 = hv2.field_downloadId;
                                    if (hv2.field_reserveInWifi) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    c45405b.mo73201a(str3, 110, j2, str2, 0, i);
                                    C45405b.eBF.mo60571j(hv2.field_appId, 30);
                                    AppMethodBeat.m2505o(2442);
                                    return;
                                }
                                bij = C2896d.bij();
                                hv = C2895c.m5147hv(longExtra);
                                if (hv != null) {
                                    Context context = C4996ah.getContext();
                                    if (hv.field_showNotification && C5046bo.isNullOrNil(hv.field_fileName)) {
                                        C2896d.m5154a(hv.field_appId, context.getString(C25738R.string.bsq), "", null);
                                    } else if (hv.field_showNotification && !C5046bo.isNullOrNil(hv.field_fileName)) {
                                        C2896d.m5154a(hv.field_appId, hv.field_fileName, context.getString(C25738R.string.bsq), null);
                                    }
                                    bij.kMT.mo7025d(longExtra, C11498a.kJW, z);
                                }
                            }
                        }
                        AppMethodBeat.m2505o(2442);
                        return;
                    }
                }
                C4990ab.m7410d("MicroMsg.FileDownloadService", "no user login");
                AppMethodBeat.m2505o(2442);
                return;
            case 3:
                absolutePath = intent.getStringExtra(kNo);
                currentTimeMillis = intent.getLongExtra("downloadId", -1);
                if (!C5046bo.isNullOrNil(absolutePath) && C5730e.m8628ct(absolutePath)) {
                    hv = C2895c.m5147hv(currentTimeMillis);
                    if (hv == null) {
                        C33913a.m55501a(absolutePath, null);
                        break;
                    }
                    C33913a.m55499a(hv.field_downloadId, false, null);
                    AppMethodBeat.m2505o(2442);
                    return;
                }
                C4990ab.m7416i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
                AppMethodBeat.m2505o(2442);
                return;
        }
        AppMethodBeat.m2505o(2442);
    }

    /* renamed from: j */
    private static boolean m31432j(boolean z, String str) {
        AppMethodBeat.m2504i(2443);
        if (!C5023at.isWifi(C4996ah.getContext()) || z || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(2443);
            return false;
        }
        AppMethodBeat.m2505o(2443);
        return true;
    }

    /* renamed from: J */
    private static boolean m31431J(String str, String str2, String str3) {
        int i = 1;
        AppMethodBeat.m2504i(2444);
        C5728b c5728b = new C5728b(str);
        C4990ab.m7417i("MicroMsg.FileDownloadService", "MD5 Check: %s, File Exists: %b", str, Boolean.valueOf(c5728b.exists()));
        long currentTimeMillis = System.currentTimeMillis();
        String atg = C5730e.atg(C5736j.m8649w(c5728b.mUri));
        C4990ab.m7417i("MicroMsg.FileDownloadService", "MD5 Check Time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        C4990ab.m7417i("MicroMsg.FileDownloadService", "Original MD5: %s, Calculated MD5: %s", str2, atg);
        if (!C5046bo.isNullOrNil(str3)) {
            C42911a In = C2895c.m5140In(str3);
            if (In != null) {
                C45405b c45405b = C45405b.eBF;
                long j = In.field_downloadId;
                String str4 = "";
                if (!In.field_reserveInWifi) {
                    i = 0;
                }
                c45405b.mo73201a(str3, 111, j, str4, r6, i);
            }
        }
        boolean exists;
        if (C5046bo.isNullOrNil(str2)) {
            exists = c5728b.exists();
            AppMethodBeat.m2505o(2444);
            return exists;
        } else if (C5046bo.isNullOrNil(atg)) {
            C4990ab.m7416i("MicroMsg.FileDownloadService", "check from file failed, may caused by low memory while checking md5");
            exists = c5728b.exists();
            AppMethodBeat.m2505o(2444);
            return exists;
        } else {
            exists = str2.trim().equalsIgnoreCase(atg.trim());
            AppMethodBeat.m2505o(2444);
            return exists;
        }
    }

    public final String getTag() {
        return "MicroMsg.FileDownloadService";
    }
}
