package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.r.c;
import java.util.LinkedList;
import java.util.List;

public final class t extends j<q> {
    public static final String[] diI = new String[]{"CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) "};
    public static final String[] fnj = new String[]{j.a(q.ccO, "BizTimeLineSingleMsgInfo")};
    public final h fni;
    private final l<c, a> xHV = new l<c, a>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(11903);
            ((c) obj).a(t.this, (a) obj2);
            AppMethodBeat.o(11903);
        }
    };

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        AppMethodBeat.i(11916);
        boolean g = g((q) cVar);
        AppMethodBeat.o(11916);
        return g;
    }

    static {
        AppMethodBeat.i(11917);
        AppMethodBeat.o(11917);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(11904);
        if (this.xHV.cF(aVar)) {
            this.xHV.doNotify();
        }
        AppMethodBeat.o(11904);
    }

    public final void a(c cVar, Looper looper) {
        AppMethodBeat.i(11905);
        this.xHV.a(cVar, looper);
        AppMethodBeat.o(11905);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(11906);
        this.xHV.remove(cVar);
        AppMethodBeat.o(11906);
    }

    public t(h hVar) {
        super(hVar, q.ccO, "BizTimeLineSingleMsgInfo", diI);
        AppMethodBeat.i(11907);
        this.fni = hVar;
        AppMethodBeat.o(11907);
    }

    public final boolean g(q qVar) {
        AppMethodBeat.i(11908);
        boolean a = super.a((com.tencent.mm.sdk.e.c) qVar, false);
        a aVar = new a();
        aVar.talker = qVar.field_talker;
        aVar.jOa = qVar;
        aVar.xId = b.INSERT;
        a(aVar);
        AppMethodBeat.o(11908);
        return a;
    }

    public final boolean h(q qVar) {
        AppMethodBeat.i(11909);
        boolean b = super.b(qVar, false, "msgSvrId");
        a aVar = new a();
        aVar.talker = qVar.field_talker;
        aVar.jOa = qVar;
        aVar.xId = b.UPDATE;
        a(aVar);
        AppMethodBeat.o(11909);
        return b;
    }

    public static List<q> p(Cursor cursor) {
        AppMethodBeat.i(11910);
        LinkedList linkedList = new LinkedList();
        while (cursor.moveToNext()) {
            q qVar = new q();
            qVar.d(cursor);
            linkedList.add(qVar);
        }
        cursor.close();
        AppMethodBeat.o(11910);
        return linkedList;
    }

    public final q drQ() {
        q qVar = null;
        AppMethodBeat.i(11911);
        Cursor a = this.fni.a("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null, 0);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.d(a);
        }
        a.close();
        AppMethodBeat.o(11911);
        return qVar;
    }

    public final int baS() {
        int i = 0;
        AppMethodBeat.i(11912);
        Cursor a = this.fni.a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null, 0);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(11912);
        return i;
    }

    public final int mN(long j) {
        int i = 0;
        AppMethodBeat.i(11913);
        Cursor a = this.fni.a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + j + " ", null, 0);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(11913);
        return i;
    }

    public final boolean QS(String str) {
        AppMethodBeat.i(11914);
        com.tencent.mm.sdk.e.c qVar = new q();
        qVar.field_talker = str;
        boolean a = super.a(qVar, false, "talker");
        a aVar = new a();
        aVar.talker = qVar.field_talker;
        aVar.jOa = qVar;
        aVar.xId = b.DELETE;
        a(aVar);
        AppMethodBeat.o(11914);
        return a;
    }

    public final void mJ(long j) {
        AppMethodBeat.i(11915);
        com.tencent.mm.sdk.e.c qVar = new q();
        qVar.field_msgId = j;
        super.a(qVar, false, "msgId");
        a aVar = new a();
        aVar.xId = b.DELETE;
        a(aVar);
        AppMethodBeat.o(11915);
    }
}
