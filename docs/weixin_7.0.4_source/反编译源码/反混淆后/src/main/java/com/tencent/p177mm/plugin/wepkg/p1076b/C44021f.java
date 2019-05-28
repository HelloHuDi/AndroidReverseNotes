package com.tencent.p177mm.plugin.wepkg.p1076b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.wepkg.model.WePkgDiffInfo;
import com.tencent.p177mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wepkg.b.f */
public class C44021f extends C7563j<C41334e> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C41334e.fjX, "WepkgVersion")};
    private static volatile C44021f uVL = null;
    private final C7480h fni;
    public final boolean hrm;

    static {
        AppMethodBeat.m2504i(63417);
        AppMethodBeat.m2505o(63417);
    }

    public static C44021f dgp() {
        AppMethodBeat.m2504i(63400);
        C44021f c44021f;
        if (C1720g.m3531RK()) {
            if (uVL == null) {
                synchronized (C44021f.class) {
                    try {
                        if (uVL == null || !uVL.hrm) {
                            uVL = new C44021f(C1720g.m3536RP().eJN);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(63400);
                        }
                    }
                }
            }
            c44021f = uVL;
            AppMethodBeat.m2505o(63400);
            return c44021f;
        }
        c44021f = new C44021f(null);
        AppMethodBeat.m2505o(63400);
        return c44021f;
    }

    private C44021f(C7480h c7480h) {
        super(c7480h, C41334e.fjX, "WepkgVersion", C41334e.diI);
        AppMethodBeat.m2504i(63401);
        this.fni = c7480h;
        this.hrm = c7480h != null;
        if (!this.hrm) {
            C4990ab.m7412e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
        }
        AppMethodBeat.m2505o(63401);
    }

    public final C41334e ahF(String str) {
        AppMethodBeat.m2504i(63402);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63402);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgVersion", "pkgId"}), str);
        if (rawQuery.moveToFirst()) {
            C41334e c41334e = new C41334e();
            c41334e.mo8995d(rawQuery);
            rawQuery.close();
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", c41334e.field_pkgId, c41334e.field_version);
            AppMethodBeat.m2505o(63402);
            return c41334e;
        }
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", str);
        rawQuery.close();
        AppMethodBeat.m2505o(63402);
        return null;
    }

    public final C41334e ahG(String str) {
        AppMethodBeat.m2504i(63403);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63403);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[]{"WepkgVersion", "pkgId", "disable"}), str);
        if (rawQuery.moveToFirst()) {
            C41334e c41334e = new C41334e();
            c41334e.mo8995d(rawQuery);
            rawQuery.close();
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", c41334e.field_pkgId, c41334e.field_version, Boolean.valueOf(c41334e.field_disableWvCache), Long.valueOf(c41334e.field_clearPkgTime), Long.valueOf(c41334e.field_checkIntervalTime), c41334e.field_domain, Boolean.valueOf(c41334e.field_bigPackageReady), Boolean.valueOf(c41334e.field_preloadFilesReady), Boolean.valueOf(c41334e.field_preloadFilesAtomic), Boolean.valueOf(c41334e.field_disable));
            c41334e.field_accessTime = C30022d.aNY();
            super.mo10103c(c41334e, new String[0]);
            AppMethodBeat.m2505o(63403);
            return c41334e;
        }
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", str);
        rawQuery.close();
        AppMethodBeat.m2505o(63403);
        return null;
    }

    public final List<String> dgq() {
        AppMethodBeat.m2504i(63404);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select %s from %s where %s < ?", new Object[]{"pkgId", "WepkgVersion", "nextCheckTime"}), String.valueOf(C30022d.aNY()));
            List<String> arrayList = new ArrayList();
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        String string = rawQuery.getString(0);
                        if (!C5046bo.isNullOrNil(string)) {
                            arrayList.add(string);
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            AppMethodBeat.m2505o(63404);
            return arrayList;
        }
        AppMethodBeat.m2505o(63404);
        return null;
    }

    public final List<String> dgr() {
        AppMethodBeat.m2504i(63405);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select %s from %s order by %s asc", new Object[]{"pkgId", "WepkgVersion", "accessTime"}), new String[0]);
            List<String> arrayList = new ArrayList();
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        String string = rawQuery.getString(0);
                        if (!C5046bo.isNullOrNil(string)) {
                            arrayList.add(string);
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            AppMethodBeat.m2505o(63405);
            return arrayList;
        }
        AppMethodBeat.m2505o(63405);
        return null;
    }

    public final List<WepkgVersion> dgs() {
        List<WepkgVersion> list = null;
        AppMethodBeat.m2504i(63406);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s < ? - %s", new Object[]{"WepkgVersion", "accessTime", "clearPkgTime"}), String.valueOf(C30022d.aNY()));
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", r1);
            if (rawQuery == null) {
                C4990ab.m7416i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
                AppMethodBeat.m2505o(63406);
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgVersion wepkgVersion = new WepkgVersion();
                    C41334e c41334e = new C41334e();
                    c41334e.mo8995d(rawQuery);
                    wepkgVersion.mo63810a(c41334e);
                    list.add(wepkgVersion);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", Integer.valueOf(list.size()));
                AppMethodBeat.m2505o(63406);
            } else {
                rawQuery.close();
                C4990ab.m7416i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
                AppMethodBeat.m2505o(63406);
            }
        } else {
            AppMethodBeat.m2505o(63406);
        }
        return list;
    }

    public final boolean ahE(String str) {
        AppMethodBeat.m2504i(63407);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63407);
            return false;
        }
        C4925c c41334e = new C41334e();
        c41334e.field_pkgId = str;
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", str, Boolean.valueOf(super.mo16760a(c41334e, new String[0])));
        AppMethodBeat.m2505o(63407);
        return super.mo16760a(c41334e, new String[0]);
    }

    public final boolean ahH(String str) {
        AppMethodBeat.m2504i(63408);
        if (this.hrm) {
            C41334e ahF = ahF(str);
            if (ahF == null) {
                AppMethodBeat.m2505o(63408);
                return false;
            }
            ahF.field_nextCheckTime = C30022d.aNY() + ahF.field_checkIntervalTime;
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", str, Boolean.valueOf(super.mo10103c(ahF, new String[0])));
            AppMethodBeat.m2505o(63408);
            return super.mo10103c(ahF, new String[0]);
        }
        AppMethodBeat.m2505o(63408);
        return false;
    }

    /* renamed from: a */
    public final boolean mo69702a(String str, boolean z, long j, long j2) {
        AppMethodBeat.m2504i(63409);
        if (this.hrm) {
            C41334e ahF = ahF(str);
            if (ahF == null) {
                AppMethodBeat.m2505o(63409);
                return false;
            }
            ahF.field_disableWvCache = z;
            ahF.field_clearPkgTime = j;
            ahF.field_nextCheckTime = (ahF.field_nextCheckTime - ahF.field_checkIntervalTime) + j2;
            ahF.field_checkIntervalTime = j2;
            ahF.field_disable = false;
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(super.mo10103c(ahF, new String[0])));
            AppMethodBeat.m2505o(63409);
            return super.mo10103c(ahF, new String[0]);
        }
        AppMethodBeat.m2505o(63409);
        return false;
    }

    /* renamed from: a */
    public final boolean mo69701a(C41334e c41334e, WePkgDiffInfo wePkgDiffInfo) {
        AppMethodBeat.m2504i(63410);
        if (!this.hrm || C5046bo.isNullOrNil(c41334e.field_pkgId)) {
            AppMethodBeat.m2505o(63410);
            return false;
        }
        long aNY;
        C41334e ahF = ahF(c41334e.field_pkgId);
        if (ahF == null) {
            aNY = C30022d.aNY();
        } else {
            aNY = ahF.field_accessTime;
        }
        if (!(wePkgDiffInfo == null || C5046bo.isNullOrNil(wePkgDiffInfo.downloadUrl))) {
            ahF = C44021f.dgp().ahF(c41334e.field_pkgId);
            if (ahF != null && C5730e.m8628ct(ahF.field_pkgPath)) {
                wePkgDiffInfo.eBS = ahF.field_pkgId;
                wePkgDiffInfo.uWO = ahF.field_version;
                wePkgDiffInfo.uWP = ahF.field_pkgPath;
                C35753b.dgn().mo56531pI(wePkgDiffInfo.eBS);
                C35753b dgn = C35753b.dgn();
                C23198a c23198a = new C23198a();
                c23198a.field_pkgId = wePkgDiffInfo.eBS;
                c23198a.field_oldVersion = wePkgDiffInfo.uWO;
                c23198a.field_oldPath = wePkgDiffInfo.uWP;
                c23198a.field_version = wePkgDiffInfo.version;
                c23198a.field_downloadUrl = wePkgDiffInfo.downloadUrl;
                c23198a.field_md5 = wePkgDiffInfo.cvZ;
                c23198a.field_pkgSize = wePkgDiffInfo.fileSize;
                c23198a.field_downloadNetType = wePkgDiffInfo.uWQ;
                dgn.mo10101b((C4925c) c23198a);
                C4990ab.m7416i("MicroMsg.Wepkg.WepkgVersionStorage", "insertDiffPkg");
            }
        }
        C44021f.dgp().ahE(c41334e.field_pkgId);
        C46470d.dgo().ahE(c41334e.field_pkgId);
        c41334e.field_nextCheckTime = C30022d.aNY() + c41334e.field_checkIntervalTime;
        c41334e.field_createTime = C30022d.aNY();
        c41334e.field_accessTime = aNY;
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "insertPkgVersion pkgid:%s, version:%s, ret:%s", c41334e.field_pkgId, c41334e.field_version, Boolean.valueOf(mo10101b((C4925c) c41334e)));
        AppMethodBeat.m2505o(63410);
        return mo10101b((C4925c) c41334e);
    }

    /* renamed from: B */
    public final boolean mo69700B(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(63411);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63411);
            return false;
        }
        C41334e ahF = ahF(str);
        if (ahF == null) {
            AppMethodBeat.m2505o(63411);
            return false;
        }
        ahF.field_bigPackageReady = z;
        ahF.field_pkgPath = str2;
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", str, str2, Boolean.valueOf(z), Boolean.valueOf(super.mo10103c(ahF, new String[0])));
        AppMethodBeat.m2505o(63411);
        return super.mo10103c(ahF, new String[0]);
    }

    /* renamed from: bP */
    public final boolean mo69710bP(String str, boolean z) {
        AppMethodBeat.m2504i(63412);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63412);
            return false;
        }
        C41334e ahF = ahF(str);
        if (ahF == null) {
            AppMethodBeat.m2505o(63412);
            return false;
        }
        ahF.field_preloadFilesReady = z;
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", str, Boolean.valueOf(z), Boolean.valueOf(super.mo10103c(ahF, new String[0])));
        AppMethodBeat.m2505o(63412);
        return super.mo10103c(ahF, new String[0]);
    }

    public final boolean ahI(String str) {
        AppMethodBeat.m2504i(63413);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63413);
            return false;
        }
        boolean hY = mo16768hY("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", str}));
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", Boolean.valueOf(hY));
        AppMethodBeat.m2505o(63413);
        return true;
    }

    public final boolean ahJ(String str) {
        AppMethodBeat.m2504i(63414);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63414);
            return false;
        }
        C41334e ahF = ahF(str);
        if (ahF == null) {
            AppMethodBeat.m2505o(63414);
            return true;
        }
        ahF.field_disable = true;
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", str, Boolean.valueOf(super.mo10103c(ahF, new String[0])));
        AppMethodBeat.m2505o(63414);
        return super.mo10103c(ahF, new String[0]);
    }

    public final boolean ahK(String str) {
        AppMethodBeat.m2504i(63415);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63415);
            return false;
        }
        C41334e ahF = ahF(str);
        if (ahF == null) {
            AppMethodBeat.m2505o(63415);
            return false;
        }
        ahF.field_createTime = 0;
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", str, Boolean.valueOf(super.mo10103c(ahF, new String[0])));
        AppMethodBeat.m2505o(63415);
        return super.mo10103c(ahF, new String[0]);
    }

    public final boolean dgt() {
        AppMethodBeat.m2504i(63416);
        if (this.hrm) {
            boolean hY = mo16768hY("WepkgVersion", String.format("delete from %s", new Object[]{"WepkgVersion"}));
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord clearWepkg ret:%s", Boolean.valueOf(hY));
            hY = mo16768hY("WepkgPreloadFiles", String.format("delete from %s", new Object[]{"WepkgPreloadFiles"}));
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord clearWepkg ret:%s", Boolean.valueOf(hY));
            AppMethodBeat.m2505o(63416);
            return true;
        }
        AppMethodBeat.m2505o(63416);
        return false;
    }
}
