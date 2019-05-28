package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.fjX, "WePkgDiffPackage")};
    private static final Object lock = new Object();
    private static b uVJ;
    private e gTC;

    static {
        AppMethodBeat.i(63390);
        AppMethodBeat.o(63390);
    }

    public static b dgn() {
        AppMethodBeat.i(63387);
        if (uVJ == null) {
            synchronized (lock) {
                try {
                    if (uVJ == null || !uVJ.ayG()) {
                        uVJ = new b(g.RP().eJN);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(63387);
                    }
                }
            }
        }
        b bVar = uVJ;
        AppMethodBeat.o(63387);
        return bVar;
    }

    private b(e eVar) {
        super(eVar, a.fjX, "WePkgDiffPackage", a.diI);
        this.gTC = eVar;
    }

    private boolean ayG() {
        return this.gTC != null;
    }

    public final a ahC(String str) {
        AppMethodBeat.i(63388);
        if (!ayG() || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63388);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=%s", new Object[]{"WePkgDiffPackage", "pkgId", "'" + str + "'"}), new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(63388);
            return null;
        } else if (rawQuery.moveToFirst()) {
            a aVar = new a();
            aVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(63388);
            return aVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(63388);
            return null;
        }
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(63389);
        if (!ayG() || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63389);
            return false;
        }
        boolean hY = hY("WePkgDiffPackage", String.format("delete from %s where %s=%s", new Object[]{"WePkgDiffPackage", "pkgId", "'" + str + "'"}));
        AppMethodBeat.o(63389);
        return hY;
    }
}
