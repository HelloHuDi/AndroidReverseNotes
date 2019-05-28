package com.tencent.p177mm.plugin.wepkg.p1076b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wepkg.b.b */
public final class C35753b extends C7563j<C23198a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C23198a.fjX, "WePkgDiffPackage")};
    private static final Object lock = new Object();
    private static C35753b uVJ;
    private C4927e gTC;

    static {
        AppMethodBeat.m2504i(63390);
        AppMethodBeat.m2505o(63390);
    }

    public static C35753b dgn() {
        AppMethodBeat.m2504i(63387);
        if (uVJ == null) {
            synchronized (lock) {
                try {
                    if (uVJ == null || !uVJ.ayG()) {
                        uVJ = new C35753b(C1720g.m3536RP().eJN);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(63387);
                    }
                }
            }
        }
        C35753b c35753b = uVJ;
        AppMethodBeat.m2505o(63387);
        return c35753b;
    }

    private C35753b(C4927e c4927e) {
        super(c4927e, C23198a.fjX, "WePkgDiffPackage", C23198a.diI);
        this.gTC = c4927e;
    }

    private boolean ayG() {
        return this.gTC != null;
    }

    public final C23198a ahC(String str) {
        AppMethodBeat.m2504i(63388);
        if (!ayG() || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63388);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=%s", new Object[]{"WePkgDiffPackage", "pkgId", "'" + str + "'"}), new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.m2505o(63388);
            return null;
        } else if (rawQuery.moveToFirst()) {
            C23198a c23198a = new C23198a();
            c23198a.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(63388);
            return c23198a;
        } else {
            rawQuery.close();
            AppMethodBeat.m2505o(63388);
            return null;
        }
    }

    /* renamed from: pI */
    public final boolean mo56531pI(String str) {
        AppMethodBeat.m2504i(63389);
        if (!ayG() || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63389);
            return false;
        }
        boolean hY = mo16768hY("WePkgDiffPackage", String.format("delete from %s where %s=%s", new Object[]{"WePkgDiffPackage", "pkgId", "'" + str + "'"}));
        AppMethodBeat.m2505o(63389);
        return hY;
    }
}
