package com.tencent.p177mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.storage.C40635r.C40633a;
import com.tencent.p177mm.storage.C40635r.C40634c;
import com.tencent.p177mm.storage.C40635r.C40639b;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.storage.t */
public final class C23522t extends C7563j<C46627q> {
    public static final String[] diI = new String[]{"CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) "};
    public static final String[] fnj = new String[]{C7563j.m13217a(C46627q.ccO, "BizTimeLineSingleMsgInfo")};
    public final C7480h fni;
    private final C4934l<C40634c, C40633a> xHV = new C235231();

    /* renamed from: com.tencent.mm.storage.t$1 */
    class C235231 extends C4934l<C40634c, C40633a> {
        C235231() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(11903);
            ((C40634c) obj).mo22929a(C23522t.this, (C40633a) obj2);
            AppMethodBeat.m2505o(11903);
        }
    }

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(11916);
        boolean g = mo39194g((C46627q) c4925c);
        AppMethodBeat.m2505o(11916);
        return g;
    }

    static {
        AppMethodBeat.m2504i(11917);
        AppMethodBeat.m2505o(11917);
    }

    /* renamed from: a */
    public final void mo39189a(C40633a c40633a) {
        AppMethodBeat.m2504i(11904);
        if (this.xHV.mo10126cF(c40633a)) {
            this.xHV.doNotify();
        }
        AppMethodBeat.m2505o(11904);
    }

    /* renamed from: a */
    public final void mo39191a(C40634c c40634c, Looper looper) {
        AppMethodBeat.m2504i(11905);
        this.xHV.mo10125a(c40634c, looper);
        AppMethodBeat.m2505o(11905);
    }

    /* renamed from: a */
    public final void mo39190a(C40634c c40634c) {
        AppMethodBeat.m2504i(11906);
        this.xHV.remove(c40634c);
        AppMethodBeat.m2505o(11906);
    }

    public C23522t(C7480h c7480h) {
        super(c7480h, C46627q.ccO, "BizTimeLineSingleMsgInfo", diI);
        AppMethodBeat.m2504i(11907);
        this.fni = c7480h;
        AppMethodBeat.m2505o(11907);
    }

    /* renamed from: g */
    public final boolean mo39194g(C46627q c46627q) {
        AppMethodBeat.m2504i(11908);
        boolean a = super.mo16759a((C4925c) c46627q, false);
        C40633a c40633a = new C40633a();
        c40633a.talker = c46627q.field_talker;
        c40633a.jOa = c46627q;
        c40633a.xId = C40639b.INSERT;
        mo39189a(c40633a);
        AppMethodBeat.m2505o(11908);
        return a;
    }

    /* renamed from: h */
    public final boolean mo39195h(C46627q c46627q) {
        AppMethodBeat.m2504i(11909);
        boolean b = super.mo16762b(c46627q, false, "msgSvrId");
        C40633a c40633a = new C40633a();
        c40633a.talker = c46627q.field_talker;
        c40633a.jOa = c46627q;
        c40633a.xId = C40639b.UPDATE;
        mo39189a(c40633a);
        AppMethodBeat.m2505o(11909);
        return b;
    }

    /* renamed from: p */
    public static List<C46627q> m36351p(Cursor cursor) {
        AppMethodBeat.m2504i(11910);
        LinkedList linkedList = new LinkedList();
        while (cursor.moveToNext()) {
            C46627q c46627q = new C46627q();
            c46627q.mo8995d(cursor);
            linkedList.add(c46627q);
        }
        cursor.close();
        AppMethodBeat.m2505o(11910);
        return linkedList;
    }

    public final C46627q drQ() {
        C46627q c46627q = null;
        AppMethodBeat.m2504i(11911);
        Cursor a = this.fni.mo10104a("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null, 0);
        if (a.moveToFirst()) {
            c46627q = new C46627q();
            c46627q.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(11911);
        return c46627q;
    }

    public final int baS() {
        int i = 0;
        AppMethodBeat.m2504i(11912);
        Cursor a = this.fni.mo10104a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null, 0);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(11912);
        return i;
    }

    /* renamed from: mN */
    public final int mo39197mN(long j) {
        int i = 0;
        AppMethodBeat.m2504i(11913);
        Cursor a = this.fni.mo10104a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + j + " ", null, 0);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(11913);
        return i;
    }

    /* renamed from: QS */
    public final boolean mo39188QS(String str) {
        AppMethodBeat.m2504i(11914);
        C4925c c46627q = new C46627q();
        c46627q.field_talker = str;
        boolean a = super.mo10100a(c46627q, false, "talker");
        C40633a c40633a = new C40633a();
        c40633a.talker = c46627q.field_talker;
        c40633a.jOa = c46627q;
        c40633a.xId = C40639b.DELETE;
        mo39189a(c40633a);
        AppMethodBeat.m2505o(11914);
        return a;
    }

    /* renamed from: mJ */
    public final void mo39196mJ(long j) {
        AppMethodBeat.m2504i(11915);
        C4925c c46627q = new C46627q();
        c46627q.field_msgId = j;
        super.mo10100a(c46627q, false, "msgId");
        C40633a c40633a = new C40633a();
        c40633a.xId = C40639b.DELETE;
        mo39189a(c40633a);
        AppMethodBeat.m2505o(11915);
    }
}
