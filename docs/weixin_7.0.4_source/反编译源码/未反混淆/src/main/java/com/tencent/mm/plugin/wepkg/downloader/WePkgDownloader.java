package com.tencent.mm.plugin.wepkg.downloader;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.c;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WePkgDownloader {
    private static volatile WePkgDownloader uVZ = null;
    private Map<String, IWepkgUpdateCallback> uWa;
    private a uWb = new a() {
        public final synchronized void a(g gVar) {
            String str;
            Object obj;
            AppMethodBeat.i(63432);
            d.dgw().ahO(gVar.uVO.uWo);
            RetCode obj2;
            if (gVar.mStatus == 1) {
                h.pYm.a(859, 2, 1, false);
                str = gVar.uVO.mFilePath;
                RetCode retCode;
                if (bo.isNullOrNil(str) || !new File(str).exists()) {
                    ab.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
                    retCode = RetCode.LOCAL_FILE_NOT_FOUND;
                    h.pYm.a(859, 4, 1, false);
                    obj2 = retCode;
                } else {
                    if (bo.nullAsNil(g.cz(str)).equalsIgnoreCase(gVar.uVO.hxH)) {
                        retCode = RetCode.OK;
                        h.pYm.a(859, 5, 1, false);
                        obj2 = retCode;
                    } else {
                        ab.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", g.cz(str), gVar.uVO.hxH);
                        e.deleteFile(str);
                        retCode = RetCode.PKG_INTEGRITY_FAILED;
                        gVar.lqz = 1012;
                        h.pYm.a(859, 3, 1, false);
                        obj2 = retCode;
                    }
                }
            } else {
                h.pYm.a(859, 1, 1, false);
                obj2 = RetCode.FAILED;
            }
            ab.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:".concat(String.valueOf(obj2)));
            IWepkgUpdateCallback iWepkgUpdateCallback = (IWepkgUpdateCallback) WePkgDownloader.this.uWa.remove(gVar.uVO.uWo);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(gVar.uVO.uWp, gVar.uVO.mFilePath, obj2);
            } else {
                ab.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
                a.b("CallbackInvalid", gVar.uVO.mUrl, gVar.uVO.uWp, null, -1, 0, null);
            }
            if (gVar.uVO.kNb == 1) {
                str = gVar.uVO.uWp;
                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.Cn = 3008;
                wepkgCrossProcessTask.uWY.eBS = str;
                if (ah.bqo()) {
                    wepkgCrossProcessTask.asP();
                } else {
                    WepkgMainProcessService.b(wepkgCrossProcessTask);
                }
            } else {
                str = gVar.uVO.uWp;
                String str2 = gVar.uVO.uWq;
                WepkgCrossProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                wepkgCrossProcessTask2.Cn = WearableStatusCodes.ASSET_UNAVAILABLE;
                wepkgCrossProcessTask2.uXb.eBS = str;
                wepkgCrossProcessTask2.uXb.uXe = str2;
                if (ah.bqo()) {
                    wepkgCrossProcessTask2.asP();
                } else {
                    WepkgMainProcessService.b(wepkgCrossProcessTask2);
                }
            }
            WePkgDownloader.b(gVar);
            AppMethodBeat.o(63432);
        }
    };

    public interface IWepkgUpdateCallback {

        public enum RetCode implements Parcelable {
            OK,
            LOCAL_FILE_NOT_FOUND,
            PKG_INTEGRITY_FAILED,
            PKG_INVALID,
            FAILED,
            CANCEL;
            
            public static final Creator<RetCode> CREATOR = null;

            static {
                CREATOR = new Creator<RetCode>() {
                    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                        return new RetCode[i];
                    }

                    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                        AppMethodBeat.i(63433);
                        Object obj = RetCode.values()[parcel.readInt()];
                        AppMethodBeat.o(63433);
                        return obj;
                    }
                };
                AppMethodBeat.o(63437);
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.i(63436);
                parcel.writeInt(ordinal());
                AppMethodBeat.o(63436);
            }
        }

        void a(String str, String str2, RetCode retCode);
    }

    static /* synthetic */ boolean f(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(63446);
        boolean e = e(str, str2, str3, str4, str5);
        AppMethodBeat.o(63446);
        return e;
    }

    static /* synthetic */ String hw(String str, String str2) {
        AppMethodBeat.i(63445);
        String hv = hv(str, str2);
        AppMethodBeat.o(63445);
        return hv;
    }

    public static WePkgDownloader dgx() {
        AppMethodBeat.i(63438);
        if (uVZ == null) {
            synchronized (WePkgDownloader.class) {
                try {
                    if (uVZ == null) {
                        uVZ = new WePkgDownloader();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(63438);
                    }
                }
            }
        }
        WePkgDownloader wePkgDownloader = uVZ;
        AppMethodBeat.o(63438);
        return wePkgDownloader;
    }

    public WePkgDownloader() {
        AppMethodBeat.i(63439);
        if (this.uWa == null) {
            this.uWa = new ConcurrentHashMap();
        }
        AppMethodBeat.o(63439);
    }

    public final void a(String str, IWepkgUpdateCallback iWepkgUpdateCallback) {
        AppMethodBeat.i(63440);
        final WepkgVersion ahW = com.tencent.mm.plugin.wepkg.model.h.ahW(str);
        if (ahW == null) {
            ab.e("MicroMsg.Wepkg.WepkgDownloader", "downloadWepkg, wepkgVersion is null");
            AppMethodBeat.o(63440);
            return;
        }
        String hv = hv(str, ahW.version);
        if (com.tencent.mm.vfs.e.ct(hv) && bo.nullAsNil(g.cz(hv)).equals(ahW.cvZ)) {
            ab.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", ahW.version, hv);
            com.tencent.mm.plugin.wepkg.c.a.a.uXR.n(str, ahW.downloadUrl, 0);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(str, hv, RetCode.OK);
            }
            AppMethodBeat.o(63440);
            return;
        }
        final com.tencent.mm.plugin.wepkg.b.a ahC = b.dgn().ahC(str);
        boolean z = false;
        if (ahC != null) {
            ab.i("MicroMsg.Wepkg.WepkgDownloader", "diff is not null, pkgId: %s", str);
            if (!bo.nullAsNil(ahC.field_version).equals(ahW.version)) {
                ab.i("MicroMsg.Wepkg.WepkgDownloader", "diff version is not equal to package version, pkgId: %s, diffVersion: %s, packageVersion: %s", str, ahC.field_version, ahW.version);
                b.dgn().pI(str);
            } else if (bo.isNullOrNil(ahC.field_downloadUrl)) {
                ab.i("MicroMsg.Wepkg.WepkgDownloader", "diff downloadurl is null, pkgId: %s, diffVersion: %s", str, ahC.field_version);
                b.dgn().pI(str);
            } else if (com.tencent.mm.vfs.e.ct(ahC.field_oldPath)) {
                z = true;
            } else {
                ab.i("MicroMsg.Wepkg.WepkgDownloader", "old package is not exists, pkgId: %s, oldPath: %s", str, ahC.field_oldPath);
                b.dgn().pI(str);
            }
        }
        ab.i("MicroMsg.Wepkg.WepkgDownloader", "downloadBigPackage, downloadDiff = %b", Boolean.valueOf(z));
        if (z) {
            h.pYm.k(859, 22, 1);
            final IWepkgUpdateCallback iWepkgUpdateCallback2 = iWepkgUpdateCallback;
            AnonymousClass1 anonymousClass1 = new IWepkgUpdateCallback() {
                public final void a(String str, String str2, RetCode retCode) {
                    AppMethodBeat.i(63431);
                    String hw = WePkgDownloader.hw(str, ahW.version);
                    if (retCode == RetCode.OK) {
                        h.pYm.k(859, 24, 1);
                        boolean f = WePkgDownloader.f(str, hw, ahC.field_oldPath, str2, ahW.cvZ);
                        com.tencent.mm.vfs.e.deleteFile(str2);
                        b.dgn().pI(str);
                        if (f) {
                            iWepkgUpdateCallback2.a(str, hw, RetCode.OK);
                            AppMethodBeat.o(63431);
                            return;
                        }
                        WePkgDownloader.this.a(str, iWepkgUpdateCallback2);
                        AppMethodBeat.o(63431);
                    } else if (retCode == RetCode.CANCEL) {
                        iWepkgUpdateCallback2.a(str, hw, retCode);
                        AppMethodBeat.o(63431);
                    } else {
                        if (retCode == RetCode.FAILED) {
                            h.pYm.k(859, 23, 1);
                        } else if (retCode == RetCode.PKG_INTEGRITY_FAILED) {
                            h.pYm.k(859, 25, 1);
                        } else if (retCode == RetCode.LOCAL_FILE_NOT_FOUND) {
                            h.pYm.k(859, 26, 1);
                        }
                        com.tencent.mm.vfs.e.deleteFile(str2);
                        b.dgn().pI(str);
                        WePkgDownloader.this.a(str, iWepkgUpdateCallback2);
                        AppMethodBeat.o(63431);
                    }
                }
            };
            String hx = c.hx(ahC.field_pkgId, ahC.field_version);
            d.aih(hx);
            hv = hx + "/diff";
            a(3, ahC.field_pkgId, hv, "", ahC.field_downloadUrl, (long) ahC.field_pkgSize, ahC.field_version, ahC.field_oldVersion, ahC.field_md5, ahC.field_downloadNetType, anonymousClass1);
            AppMethodBeat.o(63440);
            return;
        }
        a(1, ahW.eBS, hv, "", ahW.downloadUrl, (long) ahW.uXK, ahW.version, "", ahW.cvZ, ahW.uWQ, iWepkgUpdateCallback);
        AppMethodBeat.o(63440);
    }

    private static boolean e(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(63441);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            int bspatch = ((IBSPatchJNIService) com.tencent.mm.kernel.g.K(IBSPatchJNIService.class)).bspatch(str3, str2, str4);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            ab.i("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPackage, result: %d, cost: %d", Integer.valueOf(bspatch), Long.valueOf(currentTimeMillis2));
            if (bspatch == 0) {
                boolean z;
                h.pYm.k(859, 34, 1);
                if (bo.isNullOrNil(str5)) {
                    z = true;
                } else {
                    String atg = com.tencent.mm.vfs.e.atg(str2);
                    if (bo.isNullOrNil(atg)) {
                        z = false;
                    } else {
                        ab.i("MicroMsg.Wepkg.WepkgDownloader", "matchMd5, fileMd5: %s, md5: %s", atg, str5);
                        z = str5.trim().equalsIgnoreCase(atg.trim());
                    }
                }
                if (z) {
                    a.c(str, 0, "", currentTimeMillis2);
                    AppMethodBeat.o(63441);
                    return true;
                }
                h.pYm.k(859, 35, 1);
                a.c(str, TXLiveConstants.PLAY_EVT_PLAY_LOADING, "", currentTimeMillis2);
                AppMethodBeat.o(63441);
                return false;
            }
            h.pYm.k(859, 27, 1);
            h.pYm.k(859, (long) (25 - bspatch), 1);
            a.c(str, 1998 - bspatch, "", currentTimeMillis2);
            AppMethodBeat.o(63441);
            return false;
        } catch (Exception e) {
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            ab.e("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", e, str3, str2, str4);
            ab.printErrStackTrace("MicroMsg.Wepkg.WepkgDownloader", e, "", new Object[0]);
            h.pYm.k(859, 33, 1);
            a.c(str, TXLiveConstants.PLAY_EVT_PLAY_END, "", currentTimeMillis);
        }
    }

    private static String hv(String str, String str2) {
        AppMethodBeat.i(63442);
        String hx = c.hx(str, str2);
        d.aih(hx);
        hx = hx + "/package";
        AppMethodBeat.o(63442);
        return hx;
    }

    public final void a(int i, String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, int i2, IWepkgUpdateCallback iWepkgUpdateCallback) {
        String str8;
        String str9;
        AppMethodBeat.i(63443);
        ab.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", Integer.valueOf(i), str, str4, Long.valueOf(j), str5, str7, Integer.valueOf(i2));
        if (i == 2) {
            str8 = c.hx(str, str5) + "/preload_files";
            d.aih(str8);
            str9 = str8 + "/" + str7;
        } else {
            str9 = str2;
        }
        if (bo.isNullOrNil(str9)) {
            ab.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", str9);
            com.tencent.mm.plugin.wepkg.c.a.a.uXR.n(str, str4, 0);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(str, "", RetCode.FAILED);
            }
            AppMethodBeat.o(63443);
            return;
        }
        if (!com.tencent.mm.pluginsdk.g.a.d.a.ct(str9)) {
            str8 = c.ahQ(str);
            if (!bo.isNullOrNil(str8)) {
                File file = new File(str8);
                ArrayList<String> arrayList = new ArrayList();
                if (str9 == null || str9.length() <= 0) {
                    str8 = "";
                } else {
                    str8 = new File(str9).getName();
                    int lastIndexOf = str8.lastIndexOf(46);
                    if (lastIndexOf >= 0) {
                        if (lastIndexOf == 0) {
                            str8 = "";
                        } else {
                            str8 = str8.substring(0, lastIndexOf);
                        }
                    }
                }
                a(file, str8, arrayList);
                ab.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", Integer.valueOf(arrayList.size()));
                for (String str82 : arrayList) {
                    File file2 = new File(str82);
                    if (file2.isFile() && file2.length() == j && bo.nullAsNil(g.v(file2)).equalsIgnoreCase(str7)) {
                        e.y(file2.getAbsolutePath(), str9);
                        ab.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", file2.getAbsolutePath(), str9);
                        com.tencent.mm.plugin.wepkg.c.a.a.uXR.n(str, str4, 0);
                        if (iWepkgUpdateCallback != null) {
                            iWepkgUpdateCallback.a(str, str9, RetCode.OK);
                        }
                        AppMethodBeat.o(63443);
                        return;
                    }
                }
            }
        } else if (bo.nullAsNil(g.cz(str9)).equals(str7)) {
            ab.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", str5, str9);
            com.tencent.mm.plugin.wepkg.c.a.a.uXR.n(str, str4, 0);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(str, str9, RetCode.OK);
            }
            AppMethodBeat.o(63443);
            return;
        }
        Object obj = null;
        boolean z = false;
        boolean z2 = false;
        switch (i2) {
            case 1:
                if (at.isWifi(ah.getContext())) {
                    z = true;
                    z2 = true;
                    break;
                }
                break;
            case 3:
                if (at.gH(ah.getContext()) || at.is3G(ah.getContext())) {
                    z = true;
                }
                obj = 1;
                break;
            case 4:
                z = true;
                break;
            case 9:
                if (!at.isWifi(ah.getContext())) {
                    if ((at.gH(ah.getContext()) || at.is3G(ah.getContext())) && d.dgH()) {
                        z = true;
                        break;
                    }
                }
                z = true;
                break;
        }
        obj = 1;
        if (obj != null) {
            com.tencent.mm.plugin.wepkg.c.a.a.uXR.n(str, str4, j);
        } else {
            com.tencent.mm.plugin.wepkg.c.a.a.uXR.n(str, str4, 0);
        }
        ab.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", Boolean.valueOf(z));
        if (z) {
            Object obj2;
            c cVar = new c(new f(g.x(str4.getBytes()), i, str, str3, str5, str6, str4, str9, j, str7, z2, this.uWb));
            d dgw = d.dgw();
            if (dgw.uVY.containsKey(cVar.uVO.uWo)) {
                obj2 = null;
            } else {
                cVar.uVP = b.dgu().uVN.submit(cVar);
                dgw.uVY.put(cVar.uVO.uWo, cVar);
                obj2 = 1;
            }
            if (obj2 != null) {
                this.uWa.put(g.x(str4.getBytes()), iWepkgUpdateCallback);
                h.pYm.a(859, 0, 1, false);
                AppMethodBeat.o(63443);
                return;
            }
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(str, "", RetCode.CANCEL);
            }
            AppMethodBeat.o(63443);
            return;
        }
        ab.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
        if (iWepkgUpdateCallback != null) {
            iWepkgUpdateCallback.a(str, "", RetCode.CANCEL);
        }
        AppMethodBeat.o(63443);
    }

    private void a(File file, String str, List<String> list) {
        AppMethodBeat.i(63444);
        if (file == null || !file.exists()) {
            AppMethodBeat.o(63444);
        } else if (file.isFile() && file.getName().equals(str)) {
            List list2;
            if (list2 == null) {
                list2 = new ArrayList();
            }
            list2.add(file.getAbsolutePath());
            AppMethodBeat.o(63444);
        } else {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File a : listFiles) {
                        a(a, str, list2);
                    }
                }
            }
            AppMethodBeat.o(63444);
        }
    }

    static /* synthetic */ void b(g gVar) {
        AppMethodBeat.i(63447);
        f fVar = gVar.uVO;
        if (fVar != null) {
            int i;
            String str = fVar.uWp;
            String str2 = fVar.uWr;
            int i2 = gVar.uWz;
            int i3 = gVar.lqz;
            int i4 = gVar.mRetryTimes;
            Context context = ah.getContext();
            if (!at.isNetworkConnected(context)) {
                i = -1;
            } else if (at.is2G(context)) {
                i = 2;
            } else if (at.is3G(context)) {
                i = 3;
            } else if (at.is4G(context)) {
                i = 4;
            } else if (at.isWifi(context)) {
                i = 1;
            } else {
                i = 0;
            }
            String aic = a.aic(fVar.mUrl);
            int i5 = fVar.kNb;
            long j = fVar.mStartTime;
            if (j > 0) {
                j = System.currentTimeMillis() - j;
            } else {
                j = 0;
            }
            String str3 = fVar.uWy;
            long j2 = fVar.uWs;
            ab.i("MicroMsg.WePkgReport", "pkgId = %s, version = %s, isRange = %d, errCode=%d, retryTimes = %d, netType = %d,costTime = %d, fileSize = %d", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2));
            com.tencent.mm.game.report.api.c.eBG.a(new com.tencent.mm.game.report.api.d(14229, a.q(str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), aic, "", str3, Integer.valueOf(i5), Long.valueOf(j), Long.valueOf(j2))));
        }
        AppMethodBeat.o(63447);
    }
}
