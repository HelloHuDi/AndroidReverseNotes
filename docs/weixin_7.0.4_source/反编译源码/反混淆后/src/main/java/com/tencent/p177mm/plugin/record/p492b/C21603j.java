package com.tencent.p177mm.plugin.record.p492b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p1016a.C43427d;
import com.tencent.p177mm.plugin.record.p1016a.C43428e;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.record.b.j */
public final class C21603j extends C7563j<C34792i> implements C43428e {
    private C4927e bSd;
    private Vector<C43427d> pJJ = new Vector();

    /* renamed from: c */
    public final /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(135690);
        boolean b = mo37085b((C34792i) c4925c, strArr);
        AppMethodBeat.m2505o(135690);
        return b;
    }

    public C21603j(C4927e c4927e) {
        super(c4927e, C34792i.ccO, "RecordCDNInfo", null);
        AppMethodBeat.m2504i(135678);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(135678);
    }

    /* renamed from: a */
    public final void mo37080a(final C43427d c43427d) {
        AppMethodBeat.m2504i(135679);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(135675);
                if (!C21603j.this.pJJ.contains(c43427d)) {
                    C21603j.this.pJJ.add(c43427d);
                }
                AppMethodBeat.m2505o(135675);
            }
        });
        AppMethodBeat.m2505o(135679);
    }

    /* renamed from: b */
    public final void mo37083b(final C43427d c43427d) {
        AppMethodBeat.m2504i(135680);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(135676);
                C21603j.this.pJJ.remove(c43427d);
                AppMethodBeat.m2505o(135676);
            }
        });
        AppMethodBeat.m2505o(135680);
    }

    /* renamed from: b */
    private void m33082b(final int i, final C34792i c34792i) {
        AppMethodBeat.m2504i(135681);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(135677);
                Iterator it = C21603j.this.pJJ.iterator();
                while (it.hasNext()) {
                    ((C43427d) it.next()).mo25051a(i, c34792i);
                }
                AppMethodBeat.m2505o(135677);
            }
        });
        AppMethodBeat.m2505o(135681);
    }

    public final List<C34792i> ceA() {
        AppMethodBeat.m2504i(135682);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.mo10104a("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2 AND status != -1", null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                C34792i c34792i = new C34792i();
                c34792i.mo8995d(a);
                linkedList.add(c34792i);
            }
            a.close();
        }
        C4990ab.m7411d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(135682);
        return linkedList;
    }

    /* renamed from: BE */
    public final List<C34792i> mo37078BE(int i) {
        AppMethodBeat.m2504i(135683);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.mo10104a("SELECT * FROM RecordCDNInfo WHERE recordLocalId = ".concat(String.valueOf(i)), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                C34792i c34792i = new C34792i();
                c34792i.mo8995d(a);
                linkedList.add(c34792i);
            }
            a.close();
        }
        C4990ab.m7411d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(135683);
        return linkedList;
    }

    /* renamed from: VH */
    public final C34792i mo37079VH(String str) {
        C34792i c34792i = null;
        AppMethodBeat.m2504i(135684);
        Cursor a = this.bSd.mo10104a("SELECT * FROM RecordCDNInfo WHERE mediaId='" + str + "'", null, 2);
        if (a != null && a.moveToFirst()) {
            c34792i = new C34792i();
            c34792i.mo8995d(a);
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.m2505o(135684);
        return c34792i;
    }

    /* renamed from: a */
    public final boolean mo37082a(C34792i c34792i, String... strArr) {
        AppMethodBeat.m2504i(135685);
        if (super.mo16760a((C4925c) c34792i, strArr)) {
            m33082b(0, c34792i);
            AppMethodBeat.m2505o(135685);
            return true;
        }
        AppMethodBeat.m2505o(135685);
        return false;
    }

    /* renamed from: b */
    public final boolean mo37085b(C34792i c34792i, String... strArr) {
        AppMethodBeat.m2504i(135686);
        if (super.mo10103c(c34792i, strArr)) {
            m33082b(1, c34792i);
            AppMethodBeat.m2505o(135686);
            return true;
        }
        AppMethodBeat.m2505o(135686);
        return false;
    }

    /* renamed from: a */
    public final boolean mo37081a(C34792i c34792i) {
        AppMethodBeat.m2504i(135687);
        if (super.mo10099a(c34792i)) {
            m33082b(1, c34792i);
            AppMethodBeat.m2505o(135687);
            return true;
        }
        AppMethodBeat.m2505o(135687);
        return false;
    }

    /* renamed from: b */
    public final boolean mo37084b(C34792i c34792i) {
        AppMethodBeat.m2504i(135688);
        if (c34792i != null) {
            C4990ab.m7419v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", c34792i);
            if (super.mo10101b((C4925c) c34792i)) {
                m33082b(2, c34792i);
                AppMethodBeat.m2505o(135688);
                return true;
            }
            AppMethodBeat.m2505o(135688);
            return false;
        }
        C4990ab.m7412e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
        AppMethodBeat.m2505o(135688);
        return false;
    }
}
