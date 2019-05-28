package com.tencent.p177mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.wepkg.p1076b.C14798c;
import com.tencent.p177mm.plugin.wepkg.p1076b.C41334e;
import com.tencent.p177mm.plugin.wepkg.p1076b.C44021f;
import com.tencent.p177mm.plugin.wepkg.p1076b.C46470d;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask */
public class WepkgCrossProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgCrossProcessTask> CREATOR = new C148021();
    /* renamed from: Cn */
    public int f2968Cn;
    public Runnable hww;
    public WepkgVersion uWY;
    public List<WepkgVersion> uWZ;
    public WePkgDiffInfo uXa;
    public WepkgPreloadFile uXb;
    public List<WepkgPreloadFile> uXc;
    public String uXd;

    /* renamed from: com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask$1 */
    static class C148021 implements Creator<WepkgCrossProcessTask> {
        C148021() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgCrossProcessTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(63530);
            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask(parcel, (byte) 0);
            AppMethodBeat.m2505o(63530);
            return wepkgCrossProcessTask;
        }
    }

    /* synthetic */ WepkgCrossProcessTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public WepkgCrossProcessTask() {
        AppMethodBeat.m2504i(63531);
        this.f2968Cn = -1;
        this.uWY = new WepkgVersion();
        this.uWZ = new ArrayList();
        this.uXa = new WePkgDiffInfo();
        this.uXb = new WepkgPreloadFile();
        this.uXc = new ArrayList();
        AppMethodBeat.m2505o(63531);
    }

    private WepkgCrossProcessTask(Parcel parcel) {
        AppMethodBeat.m2504i(63532);
        mo48259g(parcel);
        AppMethodBeat.m2505o(63532);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void asP() {
        WepkgCrossProcessTask wepkgCrossProcessTask;
        String str = null;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.m2504i(63533);
        C44021f dgp;
        C14798c c14798c;
        boolean b;
        String str2;
        C41334e c41334e;
        C46470d dgo;
        String str3;
        String str4;
        C46470d dgo2;
        switch (this.f2968Cn) {
            case 1001:
                wepkgCrossProcessTask = this;
            case 1002:
                z2 = C26373g.m41965Nv().mo5296Ni();
                wepkgCrossProcessTask = this;
            case 2002:
                if (!(this.uWY == null || C5046bo.isNullOrNil(this.uWY.eBS))) {
                    dgp = C44021f.dgp();
                    WepkgVersion wepkgVersion = this.uWY;
                    C41334e c41334e2 = new C41334e();
                    c41334e2.field_pkgId = wepkgVersion.eBS;
                    c41334e2.field_appId = wepkgVersion.appId;
                    c41334e2.field_version = wepkgVersion.version;
                    c41334e2.field_pkgPath = wepkgVersion.gSP;
                    c41334e2.field_disableWvCache = wepkgVersion.uXG;
                    c41334e2.field_clearPkgTime = wepkgVersion.uXH;
                    c41334e2.field_checkIntervalTime = wepkgVersion.uXI;
                    c41334e2.field_packMethod = wepkgVersion.uXJ;
                    c41334e2.field_domain = wepkgVersion.cSx;
                    c41334e2.field_md5 = wepkgVersion.cvZ;
                    c41334e2.field_downloadUrl = wepkgVersion.downloadUrl;
                    c41334e2.field_pkgSize = wepkgVersion.uXK;
                    c41334e2.field_downloadNetType = wepkgVersion.uWQ;
                    c41334e2.field_nextCheckTime = wepkgVersion.uXL;
                    c41334e2.field_createTime = wepkgVersion.createTime;
                    c41334e2.field_charset = wepkgVersion.charset;
                    c41334e2.field_bigPackageReady = wepkgVersion.uXM;
                    c41334e2.field_preloadFilesReady = wepkgVersion.uXN;
                    c41334e2.field_preloadFilesAtomic = wepkgVersion.uXO;
                    c41334e2.field_totalDownloadCount = wepkgVersion.uXP;
                    c41334e2.field_downloadTriggerType = wepkgVersion.cTb;
                    dgp.mo69701a(c41334e2, this.uXa);
                    if (!C5046bo.m7548ek(this.uXc)) {
                        for (WepkgPreloadFile wepkgPreloadFile : this.uXc) {
                            if (wepkgPreloadFile != null) {
                                C46470d dgo3 = C46470d.dgo();
                                c14798c = new C14798c();
                                c14798c.field_key = wepkgPreloadFile.key;
                                c14798c.field_pkgId = wepkgPreloadFile.eBS;
                                c14798c.field_version = wepkgPreloadFile.version;
                                c14798c.field_filePath = wepkgPreloadFile.filePath;
                                c14798c.field_rid = wepkgPreloadFile.uXe;
                                c14798c.field_mimeType = wepkgPreloadFile.mimeType;
                                c14798c.field_md5 = wepkgPreloadFile.cvZ;
                                c14798c.field_downloadUrl = wepkgPreloadFile.downloadUrl;
                                c14798c.field_size = wepkgPreloadFile.size;
                                c14798c.field_downloadNetType = wepkgPreloadFile.uWQ;
                                c14798c.field_completeDownload = wepkgPreloadFile.uXr;
                                c14798c.field_createTime = wepkgPreloadFile.createTime;
                                if (dgo3.hrm) {
                                    if (dgo3.mo74693hu(c14798c.field_pkgId, c14798c.field_rid) == null) {
                                        c14798c.field_createTime = C30022d.aNY();
                                        b = dgo3.mo10101b((C4925c) c14798c);
                                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", c14798c.field_pkgId, c14798c.field_version, c14798c.field_rid, Boolean.valueOf(b));
                                    } else {
                                        b = dgo3.mo10099a(c14798c);
                                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", c14798c.field_pkgId, c14798c.field_version, c14798c.field_rid, Boolean.valueOf(b));
                                    }
                                }
                            }
                        }
                    }
                    wepkgCrossProcessTask = this;
                }
            case 2003:
                if (this.uWY != null) {
                    boolean hY;
                    C44021f dgp2 = C44021f.dgp();
                    if (dgp2.hrm) {
                        Cursor rawQuery = dgp2.rawQuery(String.format("select * from %s where %s=0 and %s=1 and %s<1 and %s<?", new Object[]{"WepkgVersion", "bigPackageReady", "preloadFilesAtomic", "autoDownloadCount", "packageDownloadCount"}), TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                        int count;
                        if (rawQuery == null) {
                            str2 = null;
                        } else if (rawQuery.moveToFirst()) {
                            count = rawQuery.getCount();
                            if (count > 1) {
                                count = C5046bo.m7560gV(count - 1, 0);
                            } else {
                                count = 0;
                            }
                            rawQuery.move(count);
                            c41334e = new C41334e();
                            c41334e.mo8995d(rawQuery);
                            rawQuery.close();
                            dgp2.ahI(c41334e.field_pkgId);
                            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", c41334e.field_pkgId, c41334e.field_version);
                            str2 = c41334e.field_pkgId;
                        } else {
                            rawQuery.close();
                            rawQuery = dgp2.rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[]{"WepkgVersion", "bigPackageReady", "autoDownloadCount", "packageDownloadCount"}), TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                            if (rawQuery == null) {
                                str2 = null;
                            } else if (rawQuery.moveToFirst()) {
                                count = rawQuery.getCount();
                                if (count > 1) {
                                    count = C5046bo.m7560gV(count - 1, 0);
                                } else {
                                    count = 0;
                                }
                                rawQuery.move(count);
                                c41334e = new C41334e();
                                c41334e.mo8995d(rawQuery);
                                rawQuery.close();
                                dgp2.ahI(c41334e.field_pkgId);
                                C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", c41334e.field_pkgId, c41334e.field_version);
                                str2 = c41334e.field_pkgId;
                            } else {
                                rawQuery.close();
                                C4990ab.m7416i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
                                str2 = null;
                            }
                        }
                    } else {
                        str2 = null;
                    }
                    if (C5046bo.isNullOrNil(str2)) {
                        dgo = C46470d.dgo();
                        if (dgo.hrm) {
                            Cursor rawQuery2 = dgo.rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[]{"WepkgPreloadFiles", "completeDownload", "autoDownloadCount", "fileDownloadCount"}), TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                            if (rawQuery2 != null) {
                                if (rawQuery2.moveToFirst()) {
                                    int count2 = rawQuery2.getCount();
                                    if (count2 > 1) {
                                        count2 = C5046bo.m7560gV(count2 - 1, 0);
                                    } else {
                                        count2 = 0;
                                    }
                                    rawQuery2.move(count2);
                                    C14798c c14798c2 = new C14798c();
                                    c14798c2.mo8995d(rawQuery2);
                                    rawQuery2.close();
                                    str3 = c14798c2.field_pkgId;
                                    str4 = c14798c2.field_rid;
                                    if (!(!dgo.hrm || C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4))) {
                                        Object[] objArr = new Object[]{"WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", str3, "rid", str4};
                                        hY = dgo.mo16768hY("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", objArr));
                                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", Boolean.valueOf(hY));
                                    }
                                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", c14798c2.field_pkgId, c14798c2.field_version, c14798c2.field_rid);
                                    str = c14798c2.field_pkgId;
                                } else {
                                    rawQuery2.close();
                                    C4990ab.m7416i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
                                }
                            }
                        }
                    } else {
                        str = str2;
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        C44021f dgp3 = C44021f.dgp();
                        if (dgp3.hrm) {
                            boolean hY2 = dgp3.mo16768hY("WepkgVersion", String.format("update %s set %s=0", new Object[]{"WepkgVersion", "autoDownloadCount"}));
                            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", Boolean.valueOf(hY2));
                            hY = dgp3.mo16768hY("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[]{"WepkgPreloadFiles", "autoDownloadCount"}));
                            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", Boolean.valueOf(hY));
                        }
                    }
                    this.uWY.eBS = str;
                    break;
                }
                break;
            case 2004:
                if (this.uWY != null) {
                    z2 = C44021f.dgp().ahJ(this.uWY.eBS);
                    wepkgCrossProcessTask = this;
                }
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                this.uWZ = C44021f.dgp().dgs();
                wepkgCrossProcessTask = this;
                wepkgCrossProcessTask.csN = z2;
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                if (this.uWY != null) {
                    dgp = C44021f.dgp();
                    str2 = this.uWY.eBS;
                    if (dgp.hrm && !C5046bo.isNullOrNil(str2)) {
                        b = dgp.mo16768hY("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", str2}));
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", Boolean.valueOf(b));
                        z = true;
                    }
                    this.csN = z;
                    break;
                }
                break;
            case 3001:
                if (this.uWY != null) {
                    c41334e = C44021f.dgp().ahF(this.uWY.eBS);
                    if (c41334e == null) {
                        this.uWY = null;
                        break;
                    } else {
                        this.uWY.mo63810a(c41334e);
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
            case 3002:
                if (this.uWY != null) {
                    c41334e = C44021f.dgp().ahG(this.uWY.eBS);
                    if (c41334e == null) {
                        this.uWY = null;
                        break;
                    } else {
                        this.uWY.mo63810a(c41334e);
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
            case 3003:
                if (this.uWY != null) {
                    z2 = C44021f.dgp().ahH(this.uWY.eBS);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3004:
                if (this.uWY != null) {
                    z2 = C44021f.dgp().mo69702a(this.uWY.eBS, this.uWY.uXG, this.uWY.uXH, this.uWY.uXI);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3005:
                if (this.uWY != null) {
                    z2 = C44021f.dgp().mo69700B(this.uWY.eBS, this.uWY.gSP, this.uWY.uXM);
                    wepkgCrossProcessTask = this;
                }
                break;
            case AuthApiStatusCodes.AUTH_APP_CERT_ERROR /*3006*/:
                if (this.uWY != null) {
                    z2 = C44021f.dgp().mo69710bP(this.uWY.eBS, this.uWY.uXN);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3007:
                if (this.uWY != null) {
                    z2 = C44021f.dgp().ahK(this.uWY.eBS);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3008:
                if (this.uWY != null) {
                    dgp = C44021f.dgp();
                    str2 = this.uWY.eBS;
                    if (!dgp.hrm || C5046bo.isNullOrNil(str2)) {
                        z2 = false;
                    } else {
                        b = dgp.mo16768hY("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", str2}));
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", Boolean.valueOf(b));
                    }
                    this.csN = z2;
                    break;
                }
                break;
            case 3009:
                if (this.uWY != null) {
                    dgp = C44021f.dgp();
                    str2 = this.uWY.eBS;
                    if (!dgp.hrm || C5046bo.isNullOrNil(str2)) {
                        z2 = false;
                    } else {
                        b = dgp.mo16768hY("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[]{"WepkgVersion", "packageDownloadCount", "pkgId", str2}));
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", Boolean.valueOf(b));
                    }
                    this.csN = z2;
                    break;
                }
                break;
            case WearableStatusCodes.DUPLICATE_LISTENER /*4001*/:
                if (!(this.uWY == null || C5046bo.isNullOrNil(this.uWY.eBS))) {
                    List arrayList;
                    dgo = C46470d.dgo();
                    str3 = this.uWY.eBS;
                    if (dgo.hrm || !C5046bo.isNullOrNil(str3)) {
                        Cursor rawQuery3 = dgo.rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[]{"WepkgPreloadFiles", "pkgId", "completeDownload"}), str3);
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", str4);
                        if (rawQuery3 == null) {
                            C4990ab.m7416i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
                        } else if (rawQuery3.moveToFirst()) {
                            arrayList = new ArrayList();
                            do {
                                WepkgPreloadFile wepkgPreloadFile2 = new WepkgPreloadFile();
                                c14798c = new C14798c();
                                c14798c.mo8995d(rawQuery3);
                                wepkgPreloadFile2.mo69721a(c14798c);
                                arrayList.add(wepkgPreloadFile2);
                            } while (rawQuery3.moveToNext());
                            rawQuery3.close();
                            C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", Integer.valueOf(arrayList.size()));
                        } else {
                            rawQuery3.close();
                            C4990ab.m7416i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
                        }
                    }
                    this.uXc = arrayList;
                    wepkgCrossProcessTask = this;
                }
            case WearableStatusCodes.UNKNOWN_LISTENER /*4002*/:
                if (this.uXb != null) {
                    z2 = C46470d.dgo().mo74692h(this.uXb.eBS, this.uXb.uXe, this.uXb.filePath, this.uXb.uXr);
                    wepkgCrossProcessTask = this;
                }
                break;
            case WearableStatusCodes.DATA_ITEM_TOO_LARGE /*4003*/:
                if (this.uWY != null) {
                    this.uXc = C46470d.dgo().ahD(this.uWY.eBS);
                    wepkgCrossProcessTask = this;
                }
                break;
            case WearableStatusCodes.INVALID_TARGET_NODE /*4004*/:
                if (this.uXb != null) {
                    C14798c hu = C46470d.dgo().mo74693hu(this.uXb.eBS, this.uXb.uXe);
                    if (hu == null) {
                        this.uXb = null;
                        break;
                    } else {
                        this.uXb.mo69721a(hu);
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
            case WearableStatusCodes.ASSET_UNAVAILABLE /*4005*/:
                if (this.uXb != null) {
                    dgo2 = C46470d.dgo();
                    str2 = this.uXb.eBS;
                    str3 = this.uXb.uXe;
                    if (!dgo2.hrm || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
                        z2 = false;
                    } else {
                        Object[] objArr2 = new Object[]{"WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", str2, "rid", str3};
                        b = dgo2.mo16768hY("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", objArr2));
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", Boolean.valueOf(b));
                    }
                    this.csN = z2;
                    break;
                }
                break;
            case WearableStatusCodes.DUPLICATE_CAPABILITY /*4006*/:
                if (this.uXb != null) {
                    dgo2 = C46470d.dgo();
                    str2 = this.uXb.eBS;
                    if (!dgo2.hrm || C5046bo.isNullOrNil(str2)) {
                        z2 = false;
                        wepkgCrossProcessTask = this;
                    } else {
                        b = dgo2.mo16768hY("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", new Object[]{"WepkgPreloadFiles", "fileDownloadCount", "pkgId", str2}));
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", Boolean.valueOf(b));
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
        }
        wepkgCrossProcessTask.csN = z2;
        mo63809wM();
        AppMethodBeat.m2505o(63533);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(63534);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(63534);
    }

    /* renamed from: m */
    public final void mo27112m(Parcel parcel) {
        AppMethodBeat.m2504i(63535);
        this.f2968Cn = parcel.readInt();
        this.uWY = (WepkgVersion) parcel.readParcelable(WepkgVersion.class.getClassLoader());
        if (this.uWZ == null) {
            this.uWZ = new ArrayList();
        }
        parcel.readList(this.uWZ, WepkgVersion.class.getClassLoader());
        this.uXb = (WepkgPreloadFile) parcel.readParcelable(WepkgPreloadFile.class.getClassLoader());
        if (this.uXc == null) {
            this.uXc = new ArrayList();
        }
        parcel.readList(this.uXc, WepkgPreloadFile.class.getClassLoader());
        this.uXd = parcel.readString();
        AppMethodBeat.m2505o(63535);
    }

    /* renamed from: a */
    public final void mo27109a(Parcel parcel, int i) {
        AppMethodBeat.m2504i(63536);
        parcel.writeInt(this.f2968Cn);
        parcel.writeParcelable(this.uWY, i);
        parcel.writeList(this.uWZ);
        parcel.writeParcelable(this.uXb, i);
        parcel.writeList(this.uXc);
        parcel.writeString(this.uXd);
        AppMethodBeat.m2505o(63536);
    }

    static {
        AppMethodBeat.m2504i(63537);
        AppMethodBeat.m2505o(63537);
    }
}
