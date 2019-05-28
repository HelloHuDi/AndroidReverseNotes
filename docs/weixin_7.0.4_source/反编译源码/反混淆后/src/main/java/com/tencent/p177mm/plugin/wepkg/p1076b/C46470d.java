package com.tencent.p177mm.plugin.wepkg.p1076b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.wepkg.model.WepkgPreloadFile;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wepkg.b.d */
public class C46470d extends C7563j<C14798c> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C14798c.fjX, "WepkgPreloadFiles")};
    private static volatile C46470d uVK = null;
    private final C7480h fni;
    public final boolean hrm;

    static {
        AppMethodBeat.m2504i(63398);
        AppMethodBeat.m2505o(63398);
    }

    public static C46470d dgo() {
        AppMethodBeat.m2504i(63392);
        C46470d c46470d;
        if (C1720g.m3531RK()) {
            if (uVK == null) {
                synchronized (C46470d.class) {
                    try {
                        if (uVK == null || !uVK.hrm) {
                            uVK = new C46470d(C1720g.m3536RP().eJN);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(63392);
                        }
                    }
                }
            }
            c46470d = uVK;
            AppMethodBeat.m2505o(63392);
            return c46470d;
        }
        c46470d = new C46470d(null);
        AppMethodBeat.m2505o(63392);
        return c46470d;
    }

    private C46470d(C7480h c7480h) {
        super(c7480h, C14798c.fjX, "WepkgPreloadFiles", C14798c.diI);
        AppMethodBeat.m2504i(63393);
        this.fni = c7480h;
        this.hrm = c7480h != null;
        if (!this.hrm) {
            C4990ab.m7412e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
        }
        AppMethodBeat.m2505o(63393);
    }

    /* renamed from: hu */
    public final C14798c mo74693hu(String str, String str2) {
        AppMethodBeat.m2504i(63394);
        if (!this.hrm || C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(63394);
            return null;
        }
        String hA = C30022d.m47519hA(str, str2);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "key"}), hA);
        if (rawQuery.moveToFirst()) {
            C14798c c14798c = new C14798c();
            c14798c.mo8995d(rawQuery);
            rawQuery.close();
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", c14798c.field_pkgId, c14798c.field_rid, c14798c.field_version);
            AppMethodBeat.m2505o(63394);
            return c14798c;
        }
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", str, str2);
        rawQuery.close();
        AppMethodBeat.m2505o(63394);
        return null;
    }

    public final List<WepkgPreloadFile> ahD(String str) {
        List<WepkgPreloadFile> list = null;
        AppMethodBeat.m2504i(63395);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63395);
        } else {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "pkgId"}), str);
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", r1);
            if (rawQuery == null) {
                C4990ab.m7416i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
                AppMethodBeat.m2505o(63395);
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                    C14798c c14798c = new C14798c();
                    c14798c.mo8995d(rawQuery);
                    wepkgPreloadFile.mo69721a(c14798c);
                    list.add(wepkgPreloadFile);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", Integer.valueOf(list.size()));
                AppMethodBeat.m2505o(63395);
            } else {
                rawQuery.close();
                C4990ab.m7416i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
                AppMethodBeat.m2505o(63395);
            }
        }
        return list;
    }

    public final boolean ahE(String str) {
        AppMethodBeat.m2504i(63396);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63396);
            return false;
        }
        C4925c c14798c = new C14798c();
        c14798c.field_pkgId = str;
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", str, Boolean.valueOf(super.mo16760a(c14798c, "pkgId")));
        AppMethodBeat.m2505o(63396);
        return super.mo16760a(c14798c, "pkgId");
    }

    /* renamed from: h */
    public final boolean mo74692h(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(63397);
        if (!this.hrm || C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(63397);
            return false;
        }
        C14798c hu = mo74693hu(str, str2);
        if (hu == null) {
            AppMethodBeat.m2505o(63397);
            return false;
        }
        hu.field_completeDownload = z;
        hu.field_filePath = str3;
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", str, str2, Boolean.valueOf(z), str3, Boolean.valueOf(super.mo10103c(hu, new String[0])));
        AppMethodBeat.m2505o(63397);
        return super.mo10103c(hu, new String[0]);
    }
}
