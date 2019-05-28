package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.wepkg.b.c;
import com.tencent.mm.plugin.wepkg.b.d;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.List;

public class WepkgCrossProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgCrossProcessTask> CREATOR = new Creator<WepkgCrossProcessTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgCrossProcessTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(63530);
            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask(parcel, (byte) 0);
            AppMethodBeat.o(63530);
            return wepkgCrossProcessTask;
        }
    };
    public int Cn;
    public Runnable hww;
    public WepkgVersion uWY;
    public List<WepkgVersion> uWZ;
    public WePkgDiffInfo uXa;
    public WepkgPreloadFile uXb;
    public List<WepkgPreloadFile> uXc;
    public String uXd;

    /* synthetic */ WepkgCrossProcessTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public WepkgCrossProcessTask() {
        AppMethodBeat.i(63531);
        this.Cn = -1;
        this.uWY = new WepkgVersion();
        this.uWZ = new ArrayList();
        this.uXa = new WePkgDiffInfo();
        this.uXb = new WepkgPreloadFile();
        this.uXc = new ArrayList();
        AppMethodBeat.o(63531);
    }

    private WepkgCrossProcessTask(Parcel parcel) {
        AppMethodBeat.i(63532);
        g(parcel);
        AppMethodBeat.o(63532);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void asP() {
        WepkgCrossProcessTask wepkgCrossProcessTask;
        String str = null;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(63533);
        f dgp;
        c cVar;
        boolean b;
        String str2;
        e eVar;
        d dgo;
        String str3;
        String str4;
        d dgo2;
        switch (this.Cn) {
            case 1001:
                wepkgCrossProcessTask = this;
            case 1002:
                z2 = g.Nv().Ni();
                wepkgCrossProcessTask = this;
            case 2002:
                if (!(this.uWY == null || bo.isNullOrNil(this.uWY.eBS))) {
                    dgp = f.dgp();
                    WepkgVersion wepkgVersion = this.uWY;
                    e eVar2 = new e();
                    eVar2.field_pkgId = wepkgVersion.eBS;
                    eVar2.field_appId = wepkgVersion.appId;
                    eVar2.field_version = wepkgVersion.version;
                    eVar2.field_pkgPath = wepkgVersion.gSP;
                    eVar2.field_disableWvCache = wepkgVersion.uXG;
                    eVar2.field_clearPkgTime = wepkgVersion.uXH;
                    eVar2.field_checkIntervalTime = wepkgVersion.uXI;
                    eVar2.field_packMethod = wepkgVersion.uXJ;
                    eVar2.field_domain = wepkgVersion.cSx;
                    eVar2.field_md5 = wepkgVersion.cvZ;
                    eVar2.field_downloadUrl = wepkgVersion.downloadUrl;
                    eVar2.field_pkgSize = wepkgVersion.uXK;
                    eVar2.field_downloadNetType = wepkgVersion.uWQ;
                    eVar2.field_nextCheckTime = wepkgVersion.uXL;
                    eVar2.field_createTime = wepkgVersion.createTime;
                    eVar2.field_charset = wepkgVersion.charset;
                    eVar2.field_bigPackageReady = wepkgVersion.uXM;
                    eVar2.field_preloadFilesReady = wepkgVersion.uXN;
                    eVar2.field_preloadFilesAtomic = wepkgVersion.uXO;
                    eVar2.field_totalDownloadCount = wepkgVersion.uXP;
                    eVar2.field_downloadTriggerType = wepkgVersion.cTb;
                    dgp.a(eVar2, this.uXa);
                    if (!bo.ek(this.uXc)) {
                        for (WepkgPreloadFile wepkgPreloadFile : this.uXc) {
                            if (wepkgPreloadFile != null) {
                                d dgo3 = d.dgo();
                                cVar = new c();
                                cVar.field_key = wepkgPreloadFile.key;
                                cVar.field_pkgId = wepkgPreloadFile.eBS;
                                cVar.field_version = wepkgPreloadFile.version;
                                cVar.field_filePath = wepkgPreloadFile.filePath;
                                cVar.field_rid = wepkgPreloadFile.uXe;
                                cVar.field_mimeType = wepkgPreloadFile.mimeType;
                                cVar.field_md5 = wepkgPreloadFile.cvZ;
                                cVar.field_downloadUrl = wepkgPreloadFile.downloadUrl;
                                cVar.field_size = wepkgPreloadFile.size;
                                cVar.field_downloadNetType = wepkgPreloadFile.uWQ;
                                cVar.field_completeDownload = wepkgPreloadFile.uXr;
                                cVar.field_createTime = wepkgPreloadFile.createTime;
                                if (dgo3.hrm) {
                                    if (dgo3.hu(cVar.field_pkgId, cVar.field_rid) == null) {
                                        cVar.field_createTime = com.tencent.mm.plugin.wepkg.utils.d.aNY();
                                        b = dgo3.b((com.tencent.mm.sdk.e.c) cVar);
                                        ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", cVar.field_pkgId, cVar.field_version, cVar.field_rid, Boolean.valueOf(b));
                                    } else {
                                        b = dgo3.a(cVar);
                                        ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", cVar.field_pkgId, cVar.field_version, cVar.field_rid, Boolean.valueOf(b));
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
                    f dgp2 = f.dgp();
                    if (dgp2.hrm) {
                        Cursor rawQuery = dgp2.rawQuery(String.format("select * from %s where %s=0 and %s=1 and %s<1 and %s<?", new Object[]{"WepkgVersion", "bigPackageReady", "preloadFilesAtomic", "autoDownloadCount", "packageDownloadCount"}), TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                        int count;
                        if (rawQuery == null) {
                            str2 = null;
                        } else if (rawQuery.moveToFirst()) {
                            count = rawQuery.getCount();
                            if (count > 1) {
                                count = bo.gV(count - 1, 0);
                            } else {
                                count = 0;
                            }
                            rawQuery.move(count);
                            eVar = new e();
                            eVar.d(rawQuery);
                            rawQuery.close();
                            dgp2.ahI(eVar.field_pkgId);
                            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", eVar.field_pkgId, eVar.field_version);
                            str2 = eVar.field_pkgId;
                        } else {
                            rawQuery.close();
                            rawQuery = dgp2.rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[]{"WepkgVersion", "bigPackageReady", "autoDownloadCount", "packageDownloadCount"}), TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                            if (rawQuery == null) {
                                str2 = null;
                            } else if (rawQuery.moveToFirst()) {
                                count = rawQuery.getCount();
                                if (count > 1) {
                                    count = bo.gV(count - 1, 0);
                                } else {
                                    count = 0;
                                }
                                rawQuery.move(count);
                                eVar = new e();
                                eVar.d(rawQuery);
                                rawQuery.close();
                                dgp2.ahI(eVar.field_pkgId);
                                ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", eVar.field_pkgId, eVar.field_version);
                                str2 = eVar.field_pkgId;
                            } else {
                                rawQuery.close();
                                ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
                                str2 = null;
                            }
                        }
                    } else {
                        str2 = null;
                    }
                    if (bo.isNullOrNil(str2)) {
                        dgo = d.dgo();
                        if (dgo.hrm) {
                            Cursor rawQuery2 = dgo.rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[]{"WepkgPreloadFiles", "completeDownload", "autoDownloadCount", "fileDownloadCount"}), TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                            if (rawQuery2 != null) {
                                if (rawQuery2.moveToFirst()) {
                                    int count2 = rawQuery2.getCount();
                                    if (count2 > 1) {
                                        count2 = bo.gV(count2 - 1, 0);
                                    } else {
                                        count2 = 0;
                                    }
                                    rawQuery2.move(count2);
                                    c cVar2 = new c();
                                    cVar2.d(rawQuery2);
                                    rawQuery2.close();
                                    str3 = cVar2.field_pkgId;
                                    str4 = cVar2.field_rid;
                                    if (!(!dgo.hrm || bo.isNullOrNil(str3) || bo.isNullOrNil(str4))) {
                                        Object[] objArr = new Object[]{"WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", str3, "rid", str4};
                                        hY = dgo.hY("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", objArr));
                                        ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", Boolean.valueOf(hY));
                                    }
                                    ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", cVar2.field_pkgId, cVar2.field_version, cVar2.field_rid);
                                    str = cVar2.field_pkgId;
                                } else {
                                    rawQuery2.close();
                                    ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
                                }
                            }
                        }
                    } else {
                        str = str2;
                    }
                    if (bo.isNullOrNil(str)) {
                        f dgp3 = f.dgp();
                        if (dgp3.hrm) {
                            boolean hY2 = dgp3.hY("WepkgVersion", String.format("update %s set %s=0", new Object[]{"WepkgVersion", "autoDownloadCount"}));
                            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", Boolean.valueOf(hY2));
                            hY = dgp3.hY("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[]{"WepkgPreloadFiles", "autoDownloadCount"}));
                            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", Boolean.valueOf(hY));
                        }
                    }
                    this.uWY.eBS = str;
                    break;
                }
                break;
            case 2004:
                if (this.uWY != null) {
                    z2 = f.dgp().ahJ(this.uWY.eBS);
                    wepkgCrossProcessTask = this;
                }
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                this.uWZ = f.dgp().dgs();
                wepkgCrossProcessTask = this;
                wepkgCrossProcessTask.csN = z2;
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                if (this.uWY != null) {
                    dgp = f.dgp();
                    str2 = this.uWY.eBS;
                    if (dgp.hrm && !bo.isNullOrNil(str2)) {
                        b = dgp.hY("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", str2}));
                        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", Boolean.valueOf(b));
                        z = true;
                    }
                    this.csN = z;
                    break;
                }
                break;
            case 3001:
                if (this.uWY != null) {
                    eVar = f.dgp().ahF(this.uWY.eBS);
                    if (eVar == null) {
                        this.uWY = null;
                        break;
                    } else {
                        this.uWY.a(eVar);
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
            case 3002:
                if (this.uWY != null) {
                    eVar = f.dgp().ahG(this.uWY.eBS);
                    if (eVar == null) {
                        this.uWY = null;
                        break;
                    } else {
                        this.uWY.a(eVar);
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
            case 3003:
                if (this.uWY != null) {
                    z2 = f.dgp().ahH(this.uWY.eBS);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3004:
                if (this.uWY != null) {
                    z2 = f.dgp().a(this.uWY.eBS, this.uWY.uXG, this.uWY.uXH, this.uWY.uXI);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3005:
                if (this.uWY != null) {
                    z2 = f.dgp().B(this.uWY.eBS, this.uWY.gSP, this.uWY.uXM);
                    wepkgCrossProcessTask = this;
                }
                break;
            case AuthApiStatusCodes.AUTH_APP_CERT_ERROR /*3006*/:
                if (this.uWY != null) {
                    z2 = f.dgp().bP(this.uWY.eBS, this.uWY.uXN);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3007:
                if (this.uWY != null) {
                    z2 = f.dgp().ahK(this.uWY.eBS);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3008:
                if (this.uWY != null) {
                    dgp = f.dgp();
                    str2 = this.uWY.eBS;
                    if (!dgp.hrm || bo.isNullOrNil(str2)) {
                        z2 = false;
                    } else {
                        b = dgp.hY("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", str2}));
                        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", Boolean.valueOf(b));
                    }
                    this.csN = z2;
                    break;
                }
                break;
            case 3009:
                if (this.uWY != null) {
                    dgp = f.dgp();
                    str2 = this.uWY.eBS;
                    if (!dgp.hrm || bo.isNullOrNil(str2)) {
                        z2 = false;
                    } else {
                        b = dgp.hY("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[]{"WepkgVersion", "packageDownloadCount", "pkgId", str2}));
                        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", Boolean.valueOf(b));
                    }
                    this.csN = z2;
                    break;
                }
                break;
            case WearableStatusCodes.DUPLICATE_LISTENER /*4001*/:
                if (!(this.uWY == null || bo.isNullOrNil(this.uWY.eBS))) {
                    List arrayList;
                    dgo = d.dgo();
                    str3 = this.uWY.eBS;
                    if (dgo.hrm || !bo.isNullOrNil(str3)) {
                        Cursor rawQuery3 = dgo.rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[]{"WepkgPreloadFiles", "pkgId", "completeDownload"}), str3);
                        ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", str4);
                        if (rawQuery3 == null) {
                            ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
                        } else if (rawQuery3.moveToFirst()) {
                            arrayList = new ArrayList();
                            do {
                                WepkgPreloadFile wepkgPreloadFile2 = new WepkgPreloadFile();
                                cVar = new c();
                                cVar.d(rawQuery3);
                                wepkgPreloadFile2.a(cVar);
                                arrayList.add(wepkgPreloadFile2);
                            } while (rawQuery3.moveToNext());
                            rawQuery3.close();
                            ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", Integer.valueOf(arrayList.size()));
                        } else {
                            rawQuery3.close();
                            ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
                        }
                    }
                    this.uXc = arrayList;
                    wepkgCrossProcessTask = this;
                }
            case WearableStatusCodes.UNKNOWN_LISTENER /*4002*/:
                if (this.uXb != null) {
                    z2 = d.dgo().h(this.uXb.eBS, this.uXb.uXe, this.uXb.filePath, this.uXb.uXr);
                    wepkgCrossProcessTask = this;
                }
                break;
            case WearableStatusCodes.DATA_ITEM_TOO_LARGE /*4003*/:
                if (this.uWY != null) {
                    this.uXc = d.dgo().ahD(this.uWY.eBS);
                    wepkgCrossProcessTask = this;
                }
                break;
            case WearableStatusCodes.INVALID_TARGET_NODE /*4004*/:
                if (this.uXb != null) {
                    c hu = d.dgo().hu(this.uXb.eBS, this.uXb.uXe);
                    if (hu == null) {
                        this.uXb = null;
                        break;
                    } else {
                        this.uXb.a(hu);
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
            case WearableStatusCodes.ASSET_UNAVAILABLE /*4005*/:
                if (this.uXb != null) {
                    dgo2 = d.dgo();
                    str2 = this.uXb.eBS;
                    str3 = this.uXb.uXe;
                    if (!dgo2.hrm || bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
                        z2 = false;
                    } else {
                        Object[] objArr2 = new Object[]{"WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", str2, "rid", str3};
                        b = dgo2.hY("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", objArr2));
                        ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", Boolean.valueOf(b));
                    }
                    this.csN = z2;
                    break;
                }
                break;
            case WearableStatusCodes.DUPLICATE_CAPABILITY /*4006*/:
                if (this.uXb != null) {
                    dgo2 = d.dgo();
                    str2 = this.uXb.eBS;
                    if (!dgo2.hrm || bo.isNullOrNil(str2)) {
                        z2 = false;
                        wepkgCrossProcessTask = this;
                    } else {
                        b = dgo2.hY("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", new Object[]{"WepkgPreloadFiles", "fileDownloadCount", "pkgId", str2}));
                        ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", Boolean.valueOf(b));
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
        }
        wepkgCrossProcessTask.csN = z2;
        wM();
        AppMethodBeat.o(63533);
    }

    public final void asQ() {
        AppMethodBeat.i(63534);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(63534);
    }

    public final void m(Parcel parcel) {
        AppMethodBeat.i(63535);
        this.Cn = parcel.readInt();
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
        AppMethodBeat.o(63535);
    }

    public final void a(Parcel parcel, int i) {
        AppMethodBeat.i(63536);
        parcel.writeInt(this.Cn);
        parcel.writeParcelable(this.uWY, i);
        parcel.writeList(this.uWZ);
        parcel.writeParcelable(this.uXb, i);
        parcel.writeList(this.uXc);
        parcel.writeString(this.uXd);
        AppMethodBeat.o(63536);
    }

    static {
        AppMethodBeat.i(63537);
        AppMethodBeat.o(63537);
    }
}
