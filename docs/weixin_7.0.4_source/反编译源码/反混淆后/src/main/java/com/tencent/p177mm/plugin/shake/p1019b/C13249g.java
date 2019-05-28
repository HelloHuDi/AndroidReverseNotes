package com.tencent.p177mm.plugin.shake.p1019b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.shake.b.g */
public final class C13249g extends C7563j<C13248f> {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )"};
    public static final String[] fnj = new String[]{C7563j.m13217a(C13248f.ccO, "shakemessage")};
    public C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(24459);
        boolean a = mo25317a((C13248f) c4925c);
        AppMethodBeat.m2505o(24459);
        return a;
    }

    static {
        AppMethodBeat.m2504i(24460);
        AppMethodBeat.m2505o(24460);
    }

    public C13249g(C4927e c4927e) {
        super(c4927e, C13248f.ccO, "shakemessage", diI);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final boolean mo25317a(C13248f c13248f) {
        AppMethodBeat.m2504i(24454);
        if (c13248f == null) {
            C4990ab.m7412e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
            AppMethodBeat.m2505o(24454);
            return false;
        } else if (super.mo10101b((C4925c) c13248f)) {
            anF(c13248f.xDa);
            AppMethodBeat.m2505o(24454);
            return true;
        } else {
            AppMethodBeat.m2505o(24454);
            return false;
        }
    }

    /* renamed from: Cv */
    public final Cursor mo25316Cv(int i) {
        AppMethodBeat.m2504i(24455);
        Cursor rawQuery = this.bSd.rawQuery("SELECT * FROM " + getTableName() + " ORDER BY rowid DESC LIMIT " + i, null);
        AppMethodBeat.m2505o(24455);
        return rawQuery;
    }

    public final int baS() {
        int i;
        AppMethodBeat.m2504i(24456);
        Cursor a = this.bSd.mo10104a("select count(*) from " + getTableName() + " where status != 1", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        if (i > 0) {
            AppMethodBeat.m2505o(24456);
            return i;
        }
        AppMethodBeat.m2505o(24456);
        return 0;
    }

    public final C13248f cjJ() {
        C13248f c13248f = null;
        AppMethodBeat.m2504i(24457);
        Cursor a = this.bSd.mo10104a("SELECT * FROM " + getTableName() + " where status != 1 ORDER BY rowid DESC LIMIT 1", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(24457);
        } else {
            if (a.moveToFirst()) {
                c13248f = new C13248f();
                c13248f.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(24457);
        }
        return c13248f;
    }

    public final List<C13248f> cjK() {
        AppMethodBeat.m2504i(24458);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a("SELECT * FROM " + getTableName() + " where status != 1", null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                C13248f c13248f = new C13248f();
                c13248f.mo8995d(a);
                arrayList.add(c13248f);
            }
            a.close();
        }
        AppMethodBeat.m2505o(24458);
        return arrayList;
    }
}
