package com.tencent.p177mm.plugin.wepkg.downloader;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.C45406d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.model.C14807c;
import com.tencent.p177mm.plugin.wepkg.model.C40404h;
import com.tencent.p177mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.p177mm.plugin.wepkg.p1076b.C23198a;
import com.tencent.p177mm.plugin.wepkg.p1076b.C35753b;
import com.tencent.p177mm.plugin.wepkg.p589c.C4693a.C4695a;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.plugin.wepkg.utils.C35765a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.rtmp.TXLiveConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader */
public class WePkgDownloader {
    private static volatile WePkgDownloader uVZ = null;
    private Map<String, IWepkgUpdateCallback> uWa;
    private C40395a uWb = new C46972();

    /* renamed from: com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader$2 */
    class C46972 implements C40395a {
        C46972() {
        }

        /* renamed from: a */
        public final synchronized void mo9817a(C35756g c35756g) {
            String str;
            Object obj;
            AppMethodBeat.m2504i(63432);
            C35755d.dgw().ahO(c35756g.uVO.uWo);
            RetCode obj2;
            if (c35756g.mStatus == 1) {
                C7060h.pYm.mo8378a(859, 2, 1, false);
                str = c35756g.uVO.mFilePath;
                RetCode retCode;
                if (C5046bo.isNullOrNil(str) || !new File(str).exists()) {
                    C4990ab.m7412e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
                    retCode = RetCode.LOCAL_FILE_NOT_FOUND;
                    C7060h.pYm.mo8378a(859, 4, 1, false);
                    obj2 = retCode;
                } else {
                    if (C5046bo.nullAsNil(C1178g.m2587cz(str)).equalsIgnoreCase(c35756g.uVO.hxH)) {
                        retCode = RetCode.OK;
                        C7060h.pYm.mo8378a(859, 5, 1, false);
                        obj2 = retCode;
                    } else {
                        C4990ab.m7413e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", C1178g.m2587cz(str), c35756g.uVO.hxH);
                        C1173e.deleteFile(str);
                        retCode = RetCode.PKG_INTEGRITY_FAILED;
                        c35756g.lqz = 1012;
                        C7060h.pYm.mo8378a(859, 3, 1, false);
                        obj2 = retCode;
                    }
                }
            } else {
                C7060h.pYm.mo8378a(859, 1, 1, false);
                obj2 = RetCode.FAILED;
            }
            C4990ab.m7416i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:".concat(String.valueOf(obj2)));
            IWepkgUpdateCallback iWepkgUpdateCallback = (IWepkgUpdateCallback) WePkgDownloader.this.uWa.remove(c35756g.uVO.uWo);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.mo9816a(c35756g.uVO.uWp, c35756g.uVO.mFilePath, obj2);
            } else {
                C4990ab.m7416i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
                C35765a.m58633b("CallbackInvalid", c35756g.uVO.mUrl, c35756g.uVO.uWp, null, -1, 0, null);
            }
            if (c35756g.uVO.kNb == 1) {
                str = c35756g.uVO.uWp;
                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.f2968Cn = 3008;
                wepkgCrossProcessTask.uWY.eBS = str;
                if (C4996ah.bqo()) {
                    wepkgCrossProcessTask.asP();
                } else {
                    WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
                }
            } else {
                str = c35756g.uVO.uWp;
                String str2 = c35756g.uVO.uWq;
                WepkgCrossProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                wepkgCrossProcessTask2.f2968Cn = WearableStatusCodes.ASSET_UNAVAILABLE;
                wepkgCrossProcessTask2.uXb.eBS = str;
                wepkgCrossProcessTask2.uXb.uXe = str2;
                if (C4996ah.bqo()) {
                    wepkgCrossProcessTask2.asP();
                } else {
                    WepkgMainProcessService.m87660b(wepkgCrossProcessTask2);
                }
            }
            WePkgDownloader.m58614b(c35756g);
            AppMethodBeat.m2505o(63432);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader$IWepkgUpdateCallback */
    public interface IWepkgUpdateCallback {

        /* renamed from: com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader$IWepkgUpdateCallback$RetCode */
        public enum RetCode implements Parcelable {
            OK,
            LOCAL_FILE_NOT_FOUND,
            PKG_INTEGRITY_FAILED,
            PKG_INVALID,
            FAILED,
            CANCEL;
            
            public static final Creator<RetCode> CREATOR = null;

            /* renamed from: com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader$IWepkgUpdateCallback$RetCode$1 */
            static class C357541 implements Creator<RetCode> {
                C357541() {
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new RetCode[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.m2504i(63433);
                    Object obj = RetCode.values()[parcel.readInt()];
                    AppMethodBeat.m2505o(63433);
                    return obj;
                }
            }

            static {
                CREATOR = new C357541();
                AppMethodBeat.m2505o(63437);
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.m2504i(63436);
                parcel.writeInt(ordinal());
                AppMethodBeat.m2505o(63436);
            }
        }

        /* renamed from: a */
        void mo9816a(String str, String str2, RetCode retCode);
    }

    /* renamed from: f */
    static /* synthetic */ boolean m58616f(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(63446);
        boolean e = WePkgDownloader.m58615e(str, str2, str3, str4, str5);
        AppMethodBeat.m2505o(63446);
        return e;
    }

    /* renamed from: hw */
    static /* synthetic */ String m58618hw(String str, String str2) {
        AppMethodBeat.m2504i(63445);
        String hv = WePkgDownloader.m58617hv(str, str2);
        AppMethodBeat.m2505o(63445);
        return hv;
    }

    public static WePkgDownloader dgx() {
        AppMethodBeat.m2504i(63438);
        if (uVZ == null) {
            synchronized (WePkgDownloader.class) {
                try {
                    if (uVZ == null) {
                        uVZ = new WePkgDownloader();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(63438);
                    }
                }
            }
        }
        WePkgDownloader wePkgDownloader = uVZ;
        AppMethodBeat.m2505o(63438);
        return wePkgDownloader;
    }

    public WePkgDownloader() {
        AppMethodBeat.m2504i(63439);
        if (this.uWa == null) {
            this.uWa = new ConcurrentHashMap();
        }
        AppMethodBeat.m2505o(63439);
    }

    /* renamed from: a */
    public final void mo56537a(String str, IWepkgUpdateCallback iWepkgUpdateCallback) {
        AppMethodBeat.m2504i(63440);
        final WepkgVersion ahW = C40404h.ahW(str);
        if (ahW == null) {
            C4990ab.m7412e("MicroMsg.Wepkg.WepkgDownloader", "downloadWepkg, wepkgVersion is null");
            AppMethodBeat.m2505o(63440);
            return;
        }
        String hv = WePkgDownloader.m58617hv(str, ahW.version);
        if (C5730e.m8628ct(hv) && C5046bo.nullAsNil(C1178g.m2587cz(hv)).equals(ahW.cvZ)) {
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", ahW.version, hv);
            C4695a.uXR.mo9815n(str, ahW.downloadUrl, 0);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.mo9816a(str, hv, RetCode.OK);
            }
            AppMethodBeat.m2505o(63440);
            return;
        }
        final C23198a ahC = C35753b.dgn().ahC(str);
        boolean z = false;
        if (ahC != null) {
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "diff is not null, pkgId: %s", str);
            if (!C5046bo.nullAsNil(ahC.field_version).equals(ahW.version)) {
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "diff version is not equal to package version, pkgId: %s, diffVersion: %s, packageVersion: %s", str, ahC.field_version, ahW.version);
                C35753b.dgn().mo56531pI(str);
            } else if (C5046bo.isNullOrNil(ahC.field_downloadUrl)) {
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "diff downloadurl is null, pkgId: %s, diffVersion: %s", str, ahC.field_version);
                C35753b.dgn().mo56531pI(str);
            } else if (C5730e.m8628ct(ahC.field_oldPath)) {
                z = true;
            } else {
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "old package is not exists, pkgId: %s, oldPath: %s", str, ahC.field_oldPath);
                C35753b.dgn().mo56531pI(str);
            }
        }
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "downloadBigPackage, downloadDiff = %b", Boolean.valueOf(z));
        if (z) {
            C7060h.pYm.mo15419k(859, 22, 1);
            final IWepkgUpdateCallback iWepkgUpdateCallback2 = iWepkgUpdateCallback;
            C46961 c46961 = new IWepkgUpdateCallback() {
                /* renamed from: a */
                public final void mo9816a(String str, String str2, RetCode retCode) {
                    AppMethodBeat.m2504i(63431);
                    String hw = WePkgDownloader.m58618hw(str, ahW.version);
                    if (retCode == RetCode.OK) {
                        C7060h.pYm.mo15419k(859, 24, 1);
                        boolean f = WePkgDownloader.m58616f(str, hw, ahC.field_oldPath, str2, ahW.cvZ);
                        C5730e.deleteFile(str2);
                        C35753b.dgn().mo56531pI(str);
                        if (f) {
                            iWepkgUpdateCallback2.mo9816a(str, hw, RetCode.OK);
                            AppMethodBeat.m2505o(63431);
                            return;
                        }
                        WePkgDownloader.this.mo56537a(str, iWepkgUpdateCallback2);
                        AppMethodBeat.m2505o(63431);
                    } else if (retCode == RetCode.CANCEL) {
                        iWepkgUpdateCallback2.mo9816a(str, hw, retCode);
                        AppMethodBeat.m2505o(63431);
                    } else {
                        if (retCode == RetCode.FAILED) {
                            C7060h.pYm.mo15419k(859, 23, 1);
                        } else if (retCode == RetCode.PKG_INTEGRITY_FAILED) {
                            C7060h.pYm.mo15419k(859, 25, 1);
                        } else if (retCode == RetCode.LOCAL_FILE_NOT_FOUND) {
                            C7060h.pYm.mo15419k(859, 26, 1);
                        }
                        C5730e.deleteFile(str2);
                        C35753b.dgn().mo56531pI(str);
                        WePkgDownloader.this.mo56537a(str, iWepkgUpdateCallback2);
                        AppMethodBeat.m2505o(63431);
                    }
                }
            };
            String hx = C14807c.m23034hx(ahC.field_pkgId, ahC.field_version);
            C30022d.aih(hx);
            hv = hx + "/diff";
            mo56536a(3, ahC.field_pkgId, hv, "", ahC.field_downloadUrl, (long) ahC.field_pkgSize, ahC.field_version, ahC.field_oldVersion, ahC.field_md5, ahC.field_downloadNetType, c46961);
            AppMethodBeat.m2505o(63440);
            return;
        }
        mo56536a(1, ahW.eBS, hv, "", ahW.downloadUrl, (long) ahW.uXK, ahW.version, "", ahW.cvZ, ahW.uWQ, iWepkgUpdateCallback);
        AppMethodBeat.m2505o(63440);
    }

    /* renamed from: e */
    private static boolean m58615e(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(63441);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            int bspatch = ((IBSPatchJNIService) C1720g.m3528K(IBSPatchJNIService.class)).bspatch(str3, str2, str4);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPackage, result: %d, cost: %d", Integer.valueOf(bspatch), Long.valueOf(currentTimeMillis2));
            if (bspatch == 0) {
                boolean z;
                C7060h.pYm.mo15419k(859, 34, 1);
                if (C5046bo.isNullOrNil(str5)) {
                    z = true;
                } else {
                    String atg = C5730e.atg(str2);
                    if (C5046bo.isNullOrNil(atg)) {
                        z = false;
                    } else {
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "matchMd5, fileMd5: %s, md5: %s", atg, str5);
                        z = str5.trim().equalsIgnoreCase(atg.trim());
                    }
                }
                if (z) {
                    C35765a.m58634c(str, 0, "", currentTimeMillis2);
                    AppMethodBeat.m2505o(63441);
                    return true;
                }
                C7060h.pYm.mo15419k(859, 35, 1);
                C35765a.m58634c(str, TXLiveConstants.PLAY_EVT_PLAY_LOADING, "", currentTimeMillis2);
                AppMethodBeat.m2505o(63441);
                return false;
            }
            C7060h.pYm.mo15419k(859, 27, 1);
            C7060h.pYm.mo15419k(859, (long) (25 - bspatch), 1);
            C35765a.m58634c(str, 1998 - bspatch, "", currentTimeMillis2);
            AppMethodBeat.m2505o(63441);
            return false;
        } catch (Exception e) {
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            C4990ab.m7413e("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", e, str3, str2, str4);
            C4990ab.printErrStackTrace("MicroMsg.Wepkg.WepkgDownloader", e, "", new Object[0]);
            C7060h.pYm.mo15419k(859, 33, 1);
            C35765a.m58634c(str, TXLiveConstants.PLAY_EVT_PLAY_END, "", currentTimeMillis);
        }
    }

    /* renamed from: hv */
    private static String m58617hv(String str, String str2) {
        AppMethodBeat.m2504i(63442);
        String hx = C14807c.m23034hx(str, str2);
        C30022d.aih(hx);
        hx = hx + "/package";
        AppMethodBeat.m2505o(63442);
        return hx;
    }

    /* renamed from: a */
    public final void mo56536a(int i, String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, int i2, IWepkgUpdateCallback iWepkgUpdateCallback) {
        String str8;
        String str9;
        AppMethodBeat.m2504i(63443);
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", Integer.valueOf(i), str, str4, Long.valueOf(j), str5, str7, Integer.valueOf(i2));
        if (i == 2) {
            str8 = C14807c.m23034hx(str, str5) + "/preload_files";
            C30022d.aih(str8);
            str9 = str8 + "/" + str7;
        } else {
            str9 = str2;
        }
        if (C5046bo.isNullOrNil(str9)) {
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", str9);
            C4695a.uXR.mo9815n(str, str4, 0);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.mo9816a(str, "", RetCode.FAILED);
            }
            AppMethodBeat.m2505o(63443);
            return;
        }
        if (!C40433a.m69345ct(str9)) {
            str8 = C14807c.ahQ(str);
            if (!C5046bo.isNullOrNil(str8)) {
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
                m58613a(file, str8, arrayList);
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", Integer.valueOf(arrayList.size()));
                for (String str82 : arrayList) {
                    File file2 = new File(str82);
                    if (file2.isFile() && file2.length() == j && C5046bo.nullAsNil(C1178g.m2589v(file2)).equalsIgnoreCase(str7)) {
                        C1173e.m2577y(file2.getAbsolutePath(), str9);
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", file2.getAbsolutePath(), str9);
                        C4695a.uXR.mo9815n(str, str4, 0);
                        if (iWepkgUpdateCallback != null) {
                            iWepkgUpdateCallback.mo9816a(str, str9, RetCode.OK);
                        }
                        AppMethodBeat.m2505o(63443);
                        return;
                    }
                }
            }
        } else if (C5046bo.nullAsNil(C1178g.m2587cz(str9)).equals(str7)) {
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", str5, str9);
            C4695a.uXR.mo9815n(str, str4, 0);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.mo9816a(str, str9, RetCode.OK);
            }
            AppMethodBeat.m2505o(63443);
            return;
        }
        Object obj = null;
        boolean z = false;
        boolean z2 = false;
        switch (i2) {
            case 1:
                if (C5023at.isWifi(C4996ah.getContext())) {
                    z = true;
                    z2 = true;
                    break;
                }
                break;
            case 3:
                if (C5023at.m7477gH(C4996ah.getContext()) || C5023at.is3G(C4996ah.getContext())) {
                    z = true;
                }
                obj = 1;
                break;
            case 4:
                z = true;
                break;
            case 9:
                if (!C5023at.isWifi(C4996ah.getContext())) {
                    if ((C5023at.m7477gH(C4996ah.getContext()) || C5023at.is3G(C4996ah.getContext())) && C30022d.dgH()) {
                        z = true;
                        break;
                    }
                }
                z = true;
                break;
        }
        obj = 1;
        if (obj != null) {
            C4695a.uXR.mo9815n(str, str4, j);
        } else {
            C4695a.uXR.mo9815n(str, str4, 0);
        }
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", Boolean.valueOf(z));
        if (z) {
            Object obj2;
            C14800c c14800c = new C14800c(new C30006f(C1178g.m2591x(str4.getBytes()), i, str, str3, str5, str6, str4, str9, j, str7, z2, this.uWb));
            C35755d dgw = C35755d.dgw();
            if (dgw.uVY.containsKey(c14800c.uVO.uWo)) {
                obj2 = null;
            } else {
                c14800c.uVP = C44022b.dgu().uVN.submit(c14800c);
                dgw.uVY.put(c14800c.uVO.uWo, c14800c);
                obj2 = 1;
            }
            if (obj2 != null) {
                this.uWa.put(C1178g.m2591x(str4.getBytes()), iWepkgUpdateCallback);
                C7060h.pYm.mo8378a(859, 0, 1, false);
                AppMethodBeat.m2505o(63443);
                return;
            }
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.mo9816a(str, "", RetCode.CANCEL);
            }
            AppMethodBeat.m2505o(63443);
            return;
        }
        C4990ab.m7416i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
        if (iWepkgUpdateCallback != null) {
            iWepkgUpdateCallback.mo9816a(str, "", RetCode.CANCEL);
        }
        AppMethodBeat.m2505o(63443);
    }

    /* renamed from: a */
    private void m58613a(File file, String str, List<String> list) {
        AppMethodBeat.m2504i(63444);
        if (file == null || !file.exists()) {
            AppMethodBeat.m2505o(63444);
        } else if (file.isFile() && file.getName().equals(str)) {
            List list2;
            if (list2 == null) {
                list2 = new ArrayList();
            }
            list2.add(file.getAbsolutePath());
            AppMethodBeat.m2505o(63444);
        } else {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File a : listFiles) {
                        m58613a(a, str, list2);
                    }
                }
            }
            AppMethodBeat.m2505o(63444);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m58614b(C35756g c35756g) {
        AppMethodBeat.m2504i(63447);
        C30006f c30006f = c35756g.uVO;
        if (c30006f != null) {
            int i;
            String str = c30006f.uWp;
            String str2 = c30006f.uWr;
            int i2 = c35756g.uWz;
            int i3 = c35756g.lqz;
            int i4 = c35756g.mRetryTimes;
            Context context = C4996ah.getContext();
            if (!C5023at.isNetworkConnected(context)) {
                i = -1;
            } else if (C5023at.is2G(context)) {
                i = 2;
            } else if (C5023at.is3G(context)) {
                i = 3;
            } else if (C5023at.is4G(context)) {
                i = 4;
            } else if (C5023at.isWifi(context)) {
                i = 1;
            } else {
                i = 0;
            }
            String aic = C35765a.aic(c30006f.mUrl);
            int i5 = c30006f.kNb;
            long j = c30006f.mStartTime;
            if (j > 0) {
                j = System.currentTimeMillis() - j;
            } else {
                j = 0;
            }
            String str3 = c30006f.uWy;
            long j2 = c30006f.uWs;
            C4990ab.m7417i("MicroMsg.WePkgReport", "pkgId = %s, version = %s, isRange = %d, errCode=%d, retryTimes = %d, netType = %d,costTime = %d, fileSize = %d", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2));
            C37860c.eBG.mo60578a(new C45406d(14229, C35765a.m58635q(str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), aic, "", str3, Integer.valueOf(i5), Long.valueOf(j), Long.valueOf(j2))));
        }
        AppMethodBeat.m2505o(63447);
    }
}
