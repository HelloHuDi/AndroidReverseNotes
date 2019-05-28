package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.d.c;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMIntentService;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.File;

public class FileDownloadService extends MMIntentService {
    public static final String EXTRA_ID = (kNm + "id");
    public static final String EXTRA_PACKAGE_NAME = (kNm + "package_name");
    private static final String kNm = (FileDownloadService.class.getSimpleName() + "_extra_");
    public static final String kNn = (kNm + ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
    public static final String kNo = (kNm + "file_path");
    public static final String kNp = (kNm + "md5");
    public static final String kNq = (kNm + "change_url");

    static {
        AppMethodBeat.i(2445);
        AppMethodBeat.o(2445);
    }

    public FileDownloadService() {
        super("FileDownloadService");
    }

    public final void onHandleIntent(Intent intent) {
        AppMethodBeat.i(2442);
        if (intent == null) {
            AppMethodBeat.o(2442);
            return;
        }
        ab.i("MicroMsg.FileDownloadService", "handle intent type : %d", Integer.valueOf(intent.getIntExtra(kNn, 0)));
        long currentTimeMillis;
        String absolutePath;
        a hv;
        switch (intent.getIntExtra(kNn, 0)) {
            case 1:
                long longExtra = intent.getLongExtra(EXTRA_ID, -1);
                if (longExtra < 0) {
                    ab.e("MicroMsg.FileDownloadService", "Invalid id");
                    AppMethodBeat.o(2442);
                    return;
                }
                if (g.RN().QY()) {
                    g.RN();
                    if (!com.tencent.mm.kernel.a.QT()) {
                        a hv2 = c.hv(longExtra);
                        if (hv2 != null) {
                            boolean z;
                            if (intent.getBooleanExtra(kNq, false) || hv2.field_isSecondDownload) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ab.i("MicroMsg.FileDownloadService", "filePath = " + hv2.field_filePath);
                            d bij;
                            if (bo.isNullOrNil(hv2.field_filePath) || !e.ct(hv2.field_filePath)) {
                                h.pYm.a(710, 5, 1, false);
                                hv2.field_status = 4;
                                hv2.field_errCode = com.tencent.mm.plugin.downloader.a.a.kKa;
                                c.e(hv2);
                                bij = d.bij();
                                ab.i("MicroMsg.FileDownloadManager", "onDownloadFailed, id = %d, errCode = %d", Long.valueOf(longExtra), Integer.valueOf(com.tencent.mm.plugin.downloader.a.a.kKa));
                                if (bij.kMT != null) {
                                    bij.kMT.d(longExtra, r3, z);
                                }
                                ab.i("MicroMsg.FileDownloadService", "file not exists, appid = " + hv2.field_appId);
                                AppMethodBeat.o(2442);
                                return;
                            } else if (bo.isNullOrNil(hv2.field_md5)) {
                                ab.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
                                hv2.field_status = 3;
                                c.e(hv2);
                                d.bij().o(longExtra, z);
                                AppMethodBeat.o(2442);
                                return;
                            } else {
                                long j;
                                String str;
                                boolean z2;
                                String str2;
                                b bVar;
                                long j2;
                                int i;
                                String str3 = "";
                                if (bo.isNullOrNil(hv2.field_appId)) {
                                    j = 0;
                                    str = str3;
                                } else {
                                    currentTimeMillis = System.currentTimeMillis();
                                    try {
                                        File file = new File(hv2.field_filePath);
                                        absolutePath = file.getAbsolutePath();
                                        boolean Il = c.Il(absolutePath);
                                        String str4 = "MicroMsg.Channel.GameChannelUtil";
                                        String str5 = "apkPath:%s, this is %s signature";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = absolutePath;
                                        objArr[1] = Il ? "v2" : "v1";
                                        ab.i(str4, str5, objArr);
                                        absolutePath = null;
                                        if (Il) {
                                            absolutePath = c.L(file);
                                        }
                                        if (absolutePath == null) {
                                            absolutePath = c.K(file);
                                            if (Il && absolutePath != null) {
                                                ab.i("MicroMsg.Channel.GameChannelUtil", "you are use v2 signature but use v1 channel modle, this apk will can't install in 7.0system");
                                            }
                                        }
                                        ab.i("MicroMsg.Channel.GameChannelUtil", "readChannel, channelId = %s", absolutePath);
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.FileDownloadService", "readChannelId exception : " + e.getMessage());
                                        absolutePath = str3;
                                    }
                                    currentTimeMillis = 0 + (System.currentTimeMillis() - currentTimeMillis);
                                    ab.i("MicroMsg.FileDownloadService", "readChannelId, channelId:%s, cost time: %d", absolutePath, Long.valueOf(r6));
                                    j = currentTimeMillis;
                                    str = absolutePath;
                                }
                                boolean J = J(hv2.field_filePath, hv2.field_md5, hv2.field_appId);
                                if (z) {
                                    if (J) {
                                        b.eBF.j(hv2.field_appId, 21);
                                        b.eBF.a(hv2.field_appId, 108, hv2.field_downloadId, str, 0, hv2.field_reserveInWifi ? 1 : 0);
                                    } else {
                                        b.eBF.j(hv2.field_appId, 22);
                                        b.eBF.a(hv2.field_appId, 109, hv2.field_downloadId, str, 0, hv2.field_reserveInWifi ? 1 : 0);
                                    }
                                }
                                if (!J) {
                                    if (hv2.field_downloadUrl.startsWith("https")) {
                                        b.eBF.j(hv2.field_appId, 32);
                                    } else {
                                        b.eBF.j(hv2.field_appId, 31);
                                    }
                                }
                                if (J || bo.isNullOrNil(hv2.field_appId)) {
                                    z2 = J;
                                    str2 = str;
                                } else {
                                    int i2;
                                    boolean z3 = false;
                                    currentTimeMillis = System.currentTimeMillis();
                                    try {
                                        z3 = com.tencent.mm.plugin.downloader.d.e.e(new File(hv2.field_filePath), "10000145");
                                    } catch (Exception e2) {
                                        ab.e("MicroMsg.FileDownloadService", "writeChannelId exception : " + e2.getMessage());
                                    }
                                    long currentTimeMillis2 = j + (System.currentTimeMillis() - currentTimeMillis);
                                    ab.i("MicroMsg.FileDownloadService", "writeChannelId result:%b, cost time: %d", Boolean.valueOf(z3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    ab.i("MicroMsg.FileDownloadService", "channel opration cost time: %d", Long.valueOf(currentTimeMillis2));
                                    if (z3) {
                                        z3 = J(hv2.field_filePath, hv2.field_md5, hv2.field_appId);
                                        ab.i("MicroMsg.FileDownloadService", "after modify channel, ret:%b", Boolean.valueOf(z3));
                                        if (z3) {
                                            str = "10000145";
                                            i2 = 102;
                                            b.eBF.j(hv2.field_appId, 24);
                                            z2 = z3;
                                        } else {
                                            i2 = 103;
                                            b.eBF.j(hv2.field_appId, 25);
                                            z2 = z3;
                                        }
                                    } else {
                                        i2 = 101;
                                        b.eBF.j(hv2.field_appId, 23);
                                        z2 = J;
                                    }
                                    b.eBF.a(hv2.field_appId, i2, hv2.field_downloadId, str, currentTimeMillis2, hv2.field_reserveInWifi ? 1 : 0);
                                    if (!z) {
                                        switch (i2) {
                                            case 101:
                                                i2 = 104;
                                                b.eBF.j(hv2.field_appId, 26);
                                                break;
                                            case 102:
                                                i2 = 105;
                                                b.eBF.j(hv2.field_appId, 27);
                                                break;
                                            case 103:
                                                i2 = 106;
                                                b.eBF.j(hv2.field_appId, 28);
                                                break;
                                            default:
                                                i2 = 0;
                                                break;
                                        }
                                        b.eBF.a(hv2.field_appId, i2, hv2.field_downloadId, str, 0, hv2.field_reserveInWifi ? 1 : 0);
                                    }
                                    if (z2 && !j(z, hv2.field_secondaryUrl)) {
                                        bVar = b.eBF;
                                        str3 = hv2.field_appId;
                                        j2 = hv2.field_downloadId;
                                        if (hv2.field_reserveInWifi) {
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        bVar.a(str3, 107, j2, str, 0, i);
                                        b.eBF.j(hv2.field_appId, 29);
                                    }
                                    str2 = str;
                                }
                                if (z2) {
                                    hv2.field_status = 3;
                                    hv2.field_channelId = str2;
                                    c.e(hv2);
                                    d.bij().o(longExtra, z);
                                    AppMethodBeat.o(2442);
                                    return;
                                }
                                if (hv2.field_downloaderType == 3) {
                                    if (hv2.field_downloadUrl.startsWith("https")) {
                                        h.pYm.a(710, 10, 1, false);
                                    } else {
                                        h.pYm.a(710, 9, 1, false);
                                    }
                                } else if (hv2.field_downloadUrl.startsWith("https")) {
                                    h.pYm.a(710, 7, 1, false);
                                } else {
                                    h.pYm.a(710, 6, 1, false);
                                }
                                hv2.field_status = 4;
                                hv2.field_channelId = str2;
                                hv2.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJW;
                                hv2.field_downloadedSize = e.asZ(hv2.field_filePath);
                                c.e(hv2);
                                ab.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", str2, Long.valueOf(hv2.field_downloadedSize), Long.valueOf(e.asZ(hv2.field_filePath)));
                                ab.i("MicroMsg.FileDownloadService", "delete file: %s", hv2.field_filePath);
                                e.deleteFile(hv2.field_filePath);
                                str3 = "MicroMsg.FileDownloadService";
                                String str6 = "checkMd5, isWifi: %b, hasChangeUrl: %b, hasHttpsUrl: %b";
                                Object[] objArr2 = new Object[3];
                                objArr2[0] = Boolean.valueOf(at.isWifi(ah.getContext()));
                                objArr2[1] = Boolean.valueOf(z);
                                objArr2[2] = Boolean.valueOf(!bo.isNullOrNil(hv2.field_secondaryUrl));
                                ab.i(str3, str6, objArr2);
                                if (j(z, hv2.field_secondaryUrl)) {
                                    long j3;
                                    e.a aVar = new e.a();
                                    aVar.It(hv2.field_secondaryUrl);
                                    aVar.hA(hv2.field_fileSize);
                                    aVar.Iv(hv2.field_fileName);
                                    aVar.setAppId(hv2.field_appId);
                                    aVar.Iw(hv2.field_md5);
                                    aVar.setScene(hv2.field_scene);
                                    aVar.Ix(hv2.field_extInfo);
                                    aVar.kNl.kNg = true;
                                    aVar.ga(true);
                                    aVar.tN(1);
                                    aVar.cY(hv2.field_packageName);
                                    aVar.kNl.kNi = true;
                                    if (hv2.field_downloaderType != 3) {
                                        j = d.bij().a(aVar.kNl);
                                        h.pYm.a(710, 8, 1, false);
                                        j3 = j;
                                    } else {
                                        j = d.bij().b(aVar.kNl);
                                        h.pYm.a(710, 11, 1, false);
                                        j3 = j;
                                    }
                                    ab.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = ".concat(String.valueOf(j3)));
                                    bVar = b.eBF;
                                    str3 = hv2.field_appId;
                                    j2 = hv2.field_downloadId;
                                    if (hv2.field_reserveInWifi) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    bVar.a(str3, 110, j2, str2, 0, i);
                                    b.eBF.j(hv2.field_appId, 30);
                                    AppMethodBeat.o(2442);
                                    return;
                                }
                                bij = d.bij();
                                hv = c.hv(longExtra);
                                if (hv != null) {
                                    Context context = ah.getContext();
                                    if (hv.field_showNotification && bo.isNullOrNil(hv.field_fileName)) {
                                        d.a(hv.field_appId, context.getString(R.string.bsq), "", null);
                                    } else if (hv.field_showNotification && !bo.isNullOrNil(hv.field_fileName)) {
                                        d.a(hv.field_appId, hv.field_fileName, context.getString(R.string.bsq), null);
                                    }
                                    bij.kMT.d(longExtra, com.tencent.mm.plugin.downloader.a.a.kJW, z);
                                }
                            }
                        }
                        AppMethodBeat.o(2442);
                        return;
                    }
                }
                ab.d("MicroMsg.FileDownloadService", "no user login");
                AppMethodBeat.o(2442);
                return;
            case 3:
                absolutePath = intent.getStringExtra(kNo);
                currentTimeMillis = intent.getLongExtra("downloadId", -1);
                if (!bo.isNullOrNil(absolutePath) && e.ct(absolutePath)) {
                    hv = c.hv(currentTimeMillis);
                    if (hv == null) {
                        com.tencent.mm.plugin.downloader.h.a.a(absolutePath, null);
                        break;
                    }
                    com.tencent.mm.plugin.downloader.h.a.a(hv.field_downloadId, false, null);
                    AppMethodBeat.o(2442);
                    return;
                }
                ab.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
                AppMethodBeat.o(2442);
                return;
        }
        AppMethodBeat.o(2442);
    }

    private static boolean j(boolean z, String str) {
        AppMethodBeat.i(2443);
        if (!at.isWifi(ah.getContext()) || z || bo.isNullOrNil(str)) {
            AppMethodBeat.o(2443);
            return false;
        }
        AppMethodBeat.o(2443);
        return true;
    }

    private static boolean J(String str, String str2, String str3) {
        int i = 1;
        AppMethodBeat.i(2444);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        ab.i("MicroMsg.FileDownloadService", "MD5 Check: %s, File Exists: %b", str, Boolean.valueOf(bVar.exists()));
        long currentTimeMillis = System.currentTimeMillis();
        String atg = e.atg(j.w(bVar.mUri));
        ab.i("MicroMsg.FileDownloadService", "MD5 Check Time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        ab.i("MicroMsg.FileDownloadService", "Original MD5: %s, Calculated MD5: %s", str2, atg);
        if (!bo.isNullOrNil(str3)) {
            a In = c.In(str3);
            if (In != null) {
                b bVar2 = b.eBF;
                long j = In.field_downloadId;
                String str4 = "";
                if (!In.field_reserveInWifi) {
                    i = 0;
                }
                bVar2.a(str3, 111, j, str4, r6, i);
            }
        }
        boolean exists;
        if (bo.isNullOrNil(str2)) {
            exists = bVar.exists();
            AppMethodBeat.o(2444);
            return exists;
        } else if (bo.isNullOrNil(atg)) {
            ab.i("MicroMsg.FileDownloadService", "check from file failed, may caused by low memory while checking md5");
            exists = bVar.exists();
            AppMethodBeat.o(2444);
            return exists;
        } else {
            exists = str2.trim().equalsIgnoreCase(atg.trim());
            AppMethodBeat.o(2444);
            return exists;
        }
    }

    public final String getTag() {
        return "MicroMsg.FileDownloadService";
    }
}
