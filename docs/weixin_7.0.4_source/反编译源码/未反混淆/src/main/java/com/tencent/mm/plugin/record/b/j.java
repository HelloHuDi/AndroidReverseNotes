package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class j extends com.tencent.mm.sdk.e.j<i> implements e {
    private com.tencent.mm.sdk.e.e bSd;
    private Vector<d> pJJ = new Vector();

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        AppMethodBeat.i(135690);
        boolean b = b((i) cVar, strArr);
        AppMethodBeat.o(135690);
        return b;
    }

    public j(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, i.ccO, "RecordCDNInfo", null);
        AppMethodBeat.i(135678);
        this.bSd = eVar;
        AppMethodBeat.o(135678);
    }

    public final void a(final d dVar) {
        AppMethodBeat.i(135679);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135675);
                if (!j.this.pJJ.contains(dVar)) {
                    j.this.pJJ.add(dVar);
                }
                AppMethodBeat.o(135675);
            }
        });
        AppMethodBeat.o(135679);
    }

    public final void b(final d dVar) {
        AppMethodBeat.i(135680);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135676);
                j.this.pJJ.remove(dVar);
                AppMethodBeat.o(135676);
            }
        });
        AppMethodBeat.o(135680);
    }

    private void b(final int i, final i iVar) {
        AppMethodBeat.i(135681);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135677);
                Iterator it = j.this.pJJ.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(i, iVar);
                }
                AppMethodBeat.o(135677);
            }
        });
        AppMethodBeat.o(135681);
    }

    public final List<i> ceA() {
        AppMethodBeat.i(135682);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.a("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2 AND status != -1", null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                i iVar = new i();
                iVar.d(a);
                linkedList.add(iVar);
            }
            a.close();
        }
        ab.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(135682);
        return linkedList;
    }

    public final List<i> BE(int i) {
        AppMethodBeat.i(135683);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.a("SELECT * FROM RecordCDNInfo WHERE recordLocalId = ".concat(String.valueOf(i)), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                i iVar = new i();
                iVar.d(a);
                linkedList.add(iVar);
            }
            a.close();
        }
        ab.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(135683);
        return linkedList;
    }

    public final i VH(String str) {
        i iVar = null;
        AppMethodBeat.i(135684);
        Cursor a = this.bSd.a("SELECT * FROM RecordCDNInfo WHERE mediaId='" + str + "'", null, 2);
        if (a != null && a.moveToFirst()) {
            iVar = new i();
            iVar.d(a);
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.o(135684);
        return iVar;
    }

    public final boolean a(i iVar, String... strArr) {
        AppMethodBeat.i(135685);
        if (super.a((c) iVar, strArr)) {
            b(0, iVar);
            AppMethodBeat.o(135685);
            return true;
        }
        AppMethodBeat.o(135685);
        return false;
    }

    public final boolean b(i iVar, String... strArr) {
        AppMethodBeat.i(135686);
        if (super.c(iVar, strArr)) {
            b(1, iVar);
            AppMethodBeat.o(135686);
            return true;
        }
        AppMethodBeat.o(135686);
        return false;
    }

    public final boolean a(i iVar) {
        AppMethodBeat.i(135687);
        if (super.a(iVar)) {
            b(1, iVar);
            AppMethodBeat.o(135687);
            return true;
        }
        AppMethodBeat.o(135687);
        return false;
    }

    public final boolean b(i iVar) {
        AppMethodBeat.i(135688);
        if (iVar != null) {
            ab.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", iVar);
            if (super.b((c) iVar)) {
                b(2, iVar);
                AppMethodBeat.o(135688);
                return true;
            }
            AppMethodBeat.o(135688);
            return false;
        }
        ab.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
        AppMethodBeat.o(135688);
        return false;
    }
}
