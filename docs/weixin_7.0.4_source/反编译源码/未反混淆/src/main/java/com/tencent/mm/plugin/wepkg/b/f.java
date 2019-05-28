package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public class f extends j<e> {
    public static final String[] fnj = new String[]{j.a(e.fjX, "WepkgVersion")};
    private static volatile f uVL = null;
    private final h fni;
    public final boolean hrm;

    static {
        AppMethodBeat.i(63417);
        AppMethodBeat.o(63417);
    }

    public static f dgp() {
        AppMethodBeat.i(63400);
        f fVar;
        if (g.RK()) {
            if (uVL == null) {
                synchronized (f.class) {
                    try {
                        if (uVL == null || !uVL.hrm) {
                            uVL = new f(g.RP().eJN);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(63400);
                        }
                    }
                }
            }
            fVar = uVL;
            AppMethodBeat.o(63400);
            return fVar;
        }
        fVar = new f(null);
        AppMethodBeat.o(63400);
        return fVar;
    }

    private f(h hVar) {
        super(hVar, e.fjX, "WepkgVersion", e.diI);
        AppMethodBeat.i(63401);
        this.fni = hVar;
        this.hrm = hVar != null;
        if (!this.hrm) {
            ab.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
        }
        AppMethodBeat.o(63401);
    }

    public final e ahF(String str) {
        AppMethodBeat.i(63402);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63402);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgVersion", "pkgId"}), str);
        if (rawQuery.moveToFirst()) {
            e eVar = new e();
            eVar.d(rawQuery);
            rawQuery.close();
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", eVar.field_pkgId, eVar.field_version);
            AppMethodBeat.o(63402);
            return eVar;
        }
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", str);
        rawQuery.close();
        AppMethodBeat.o(63402);
        return null;
    }

    public final e ahG(String str) {
        AppMethodBeat.i(63403);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63403);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[]{"WepkgVersion", "pkgId", "disable"}), str);
        if (rawQuery.moveToFirst()) {
            e eVar = new e();
            eVar.d(rawQuery);
            rawQuery.close();
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", eVar.field_pkgId, eVar.field_version, Boolean.valueOf(eVar.field_disableWvCache), Long.valueOf(eVar.field_clearPkgTime), Long.valueOf(eVar.field_checkIntervalTime), eVar.field_domain, Boolean.valueOf(eVar.field_bigPackageReady), Boolean.valueOf(eVar.field_preloadFilesReady), Boolean.valueOf(eVar.field_preloadFilesAtomic), Boolean.valueOf(eVar.field_disable));
            eVar.field_accessTime = d.aNY();
            super.c(eVar, new String[0]);
            AppMethodBeat.o(63403);
            return eVar;
        }
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", str);
        rawQuery.close();
        AppMethodBeat.o(63403);
        return null;
    }

    public final List<String> dgq() {
        AppMethodBeat.i(63404);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select %s from %s where %s < ?", new Object[]{"pkgId", "WepkgVersion", "nextCheckTime"}), String.valueOf(d.aNY()));
            List<String> arrayList = new ArrayList();
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        String string = rawQuery.getString(0);
                        if (!bo.isNullOrNil(string)) {
                            arrayList.add(string);
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            AppMethodBeat.o(63404);
            return arrayList;
        }
        AppMethodBeat.o(63404);
        return null;
    }

    public final List<String> dgr() {
        AppMethodBeat.i(63405);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select %s from %s order by %s asc", new Object[]{"pkgId", "WepkgVersion", "accessTime"}), new String[0]);
            List<String> arrayList = new ArrayList();
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        String string = rawQuery.getString(0);
                        if (!bo.isNullOrNil(string)) {
                            arrayList.add(string);
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            AppMethodBeat.o(63405);
            return arrayList;
        }
        AppMethodBeat.o(63405);
        return null;
    }

    public final List<WepkgVersion> dgs() {
        List<WepkgVersion> list = null;
        AppMethodBeat.i(63406);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s < ? - %s", new Object[]{"WepkgVersion", "accessTime", "clearPkgTime"}), String.valueOf(d.aNY()));
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", r1);
            if (rawQuery == null) {
                ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
                AppMethodBeat.o(63406);
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgVersion wepkgVersion = new WepkgVersion();
                    e eVar = new e();
                    eVar.d(rawQuery);
                    wepkgVersion.a(eVar);
                    list.add(wepkgVersion);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", Integer.valueOf(list.size()));
                AppMethodBeat.o(63406);
            } else {
                rawQuery.close();
                ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
                AppMethodBeat.o(63406);
            }
        } else {
            AppMethodBeat.o(63406);
        }
        return list;
    }

    public final boolean ahE(String str) {
        AppMethodBeat.i(63407);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63407);
            return false;
        }
        c eVar = new e();
        eVar.field_pkgId = str;
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", str, Boolean.valueOf(super.a(eVar, new String[0])));
        AppMethodBeat.o(63407);
        return super.a(eVar, new String[0]);
    }

    public final boolean ahH(String str) {
        AppMethodBeat.i(63408);
        if (this.hrm) {
            e ahF = ahF(str);
            if (ahF == null) {
                AppMethodBeat.o(63408);
                return false;
            }
            ahF.field_nextCheckTime = d.aNY() + ahF.field_checkIntervalTime;
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", str, Boolean.valueOf(super.c(ahF, new String[0])));
            AppMethodBeat.o(63408);
            return super.c(ahF, new String[0]);
        }
        AppMethodBeat.o(63408);
        return false;
    }

    public final boolean a(String str, boolean z, long j, long j2) {
        AppMethodBeat.i(63409);
        if (this.hrm) {
            e ahF = ahF(str);
            if (ahF == null) {
                AppMethodBeat.o(63409);
                return false;
            }
            ahF.field_disableWvCache = z;
            ahF.field_clearPkgTime = j;
            ahF.field_nextCheckTime = (ahF.field_nextCheckTime - ahF.field_checkIntervalTime) + j2;
            ahF.field_checkIntervalTime = j2;
            ahF.field_disable = false;
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(super.c(ahF, new String[0])));
            AppMethodBeat.o(63409);
            return super.c(ahF, new String[0]);
        }
        AppMethodBeat.o(63409);
        return false;
    }

    public final boolean a(e eVar, WePkgDiffInfo wePkgDiffInfo) {
        AppMethodBeat.i(63410);
        if (!this.hrm || bo.isNullOrNil(eVar.field_pkgId)) {
            AppMethodBeat.o(63410);
            return false;
        }
        long aNY;
        e ahF = ahF(eVar.field_pkgId);
        if (ahF == null) {
            aNY = d.aNY();
        } else {
            aNY = ahF.field_accessTime;
        }
        if (!(wePkgDiffInfo == null || bo.isNullOrNil(wePkgDiffInfo.downloadUrl))) {
            ahF = dgp().ahF(eVar.field_pkgId);
            if (ahF != null && e.ct(ahF.field_pkgPath)) {
                wePkgDiffInfo.eBS = ahF.field_pkgId;
                wePkgDiffInfo.uWO = ahF.field_version;
                wePkgDiffInfo.uWP = ahF.field_pkgPath;
                b.dgn().pI(wePkgDiffInfo.eBS);
                b dgn = b.dgn();
                a aVar = new a();
                aVar.field_pkgId = wePkgDiffInfo.eBS;
                aVar.field_oldVersion = wePkgDiffInfo.uWO;
                aVar.field_oldPath = wePkgDiffInfo.uWP;
                aVar.field_version = wePkgDiffInfo.version;
                aVar.field_downloadUrl = wePkgDiffInfo.downloadUrl;
                aVar.field_md5 = wePkgDiffInfo.cvZ;
                aVar.field_pkgSize = wePkgDiffInfo.fileSize;
                aVar.field_downloadNetType = wePkgDiffInfo.uWQ;
                dgn.b((c) aVar);
                ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertDiffPkg");
            }
        }
        dgp().ahE(eVar.field_pkgId);
        d.dgo().ahE(eVar.field_pkgId);
        eVar.field_nextCheckTime = d.aNY() + eVar.field_checkIntervalTime;
        eVar.field_createTime = d.aNY();
        eVar.field_accessTime = aNY;
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertPkgVersion pkgid:%s, version:%s, ret:%s", eVar.field_pkgId, eVar.field_version, Boolean.valueOf(b((c) eVar)));
        AppMethodBeat.o(63410);
        return b((c) eVar);
    }

    public final boolean B(String str, String str2, boolean z) {
        AppMethodBeat.i(63411);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63411);
            return false;
        }
        e ahF = ahF(str);
        if (ahF == null) {
            AppMethodBeat.o(63411);
            return false;
        }
        ahF.field_bigPackageReady = z;
        ahF.field_pkgPath = str2;
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", str, str2, Boolean.valueOf(z), Boolean.valueOf(super.c(ahF, new String[0])));
        AppMethodBeat.o(63411);
        return super.c(ahF, new String[0]);
    }

    public final boolean bP(String str, boolean z) {
        AppMethodBeat.i(63412);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63412);
            return false;
        }
        e ahF = ahF(str);
        if (ahF == null) {
            AppMethodBeat.o(63412);
            return false;
        }
        ahF.field_preloadFilesReady = z;
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", str, Boolean.valueOf(z), Boolean.valueOf(super.c(ahF, new String[0])));
        AppMethodBeat.o(63412);
        return super.c(ahF, new String[0]);
    }

    public final boolean ahI(String str) {
        AppMethodBeat.i(63413);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63413);
            return false;
        }
        boolean hY = hY("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", str}));
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", Boolean.valueOf(hY));
        AppMethodBeat.o(63413);
        return true;
    }

    public final boolean ahJ(String str) {
        AppMethodBeat.i(63414);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63414);
            return false;
        }
        e ahF = ahF(str);
        if (ahF == null) {
            AppMethodBeat.o(63414);
            return true;
        }
        ahF.field_disable = true;
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", str, Boolean.valueOf(super.c(ahF, new String[0])));
        AppMethodBeat.o(63414);
        return super.c(ahF, new String[0]);
    }

    public final boolean ahK(String str) {
        AppMethodBeat.i(63415);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63415);
            return false;
        }
        e ahF = ahF(str);
        if (ahF == null) {
            AppMethodBeat.o(63415);
            return false;
        }
        ahF.field_createTime = 0;
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", str, Boolean.valueOf(super.c(ahF, new String[0])));
        AppMethodBeat.o(63415);
        return super.c(ahF, new String[0]);
    }

    public final boolean dgt() {
        AppMethodBeat.i(63416);
        if (this.hrm) {
            boolean hY = hY("WepkgVersion", String.format("delete from %s", new Object[]{"WepkgVersion"}));
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord clearWepkg ret:%s", Boolean.valueOf(hY));
            hY = hY("WepkgPreloadFiles", String.format("delete from %s", new Object[]{"WepkgPreloadFiles"}));
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord clearWepkg ret:%s", Boolean.valueOf(hY));
            AppMethodBeat.o(63416);
            return true;
        }
        AppMethodBeat.o(63416);
        return false;
    }
}
