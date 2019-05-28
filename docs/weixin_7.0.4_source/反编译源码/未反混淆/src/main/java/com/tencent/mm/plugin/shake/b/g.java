package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class g extends j<f> {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )"};
    public static final String[] fnj = new String[]{j.a(f.ccO, "shakemessage")};
    public e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(24459);
        boolean a = a((f) cVar);
        AppMethodBeat.o(24459);
        return a;
    }

    static {
        AppMethodBeat.i(24460);
        AppMethodBeat.o(24460);
    }

    public g(e eVar) {
        super(eVar, f.ccO, "shakemessage", diI);
        this.bSd = eVar;
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(24454);
        if (fVar == null) {
            ab.e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
            AppMethodBeat.o(24454);
            return false;
        } else if (super.b((c) fVar)) {
            anF(fVar.xDa);
            AppMethodBeat.o(24454);
            return true;
        } else {
            AppMethodBeat.o(24454);
            return false;
        }
    }

    public final Cursor Cv(int i) {
        AppMethodBeat.i(24455);
        Cursor rawQuery = this.bSd.rawQuery("SELECT * FROM " + getTableName() + " ORDER BY rowid DESC LIMIT " + i, null);
        AppMethodBeat.o(24455);
        return rawQuery;
    }

    public final int baS() {
        int i;
        AppMethodBeat.i(24456);
        Cursor a = this.bSd.a("select count(*) from " + getTableName() + " where status != 1", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        if (i > 0) {
            AppMethodBeat.o(24456);
            return i;
        }
        AppMethodBeat.o(24456);
        return 0;
    }

    public final f cjJ() {
        f fVar = null;
        AppMethodBeat.i(24457);
        Cursor a = this.bSd.a("SELECT * FROM " + getTableName() + " where status != 1 ORDER BY rowid DESC LIMIT 1", null, 2);
        if (a == null) {
            AppMethodBeat.o(24457);
        } else {
            if (a.moveToFirst()) {
                fVar = new f();
                fVar.d(a);
            }
            a.close();
            AppMethodBeat.o(24457);
        }
        return fVar;
    }

    public final List<f> cjK() {
        AppMethodBeat.i(24458);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a("SELECT * FROM " + getTableName() + " where status != 1", null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                f fVar = new f();
                fVar.d(a);
                arrayList.add(fVar);
            }
            a.close();
        }
        AppMethodBeat.o(24458);
        return arrayList;
    }
}
