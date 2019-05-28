package com.tencent.mm.aj.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aa;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.atomic.AtomicLong;

public final class d extends j<aa> {
    public static final String[] fnj = new String[]{j.a(c.ccO, "BizChatInfo")};
    public e bSd;
    final l<a, b> fuL = new l<a, b>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(11514);
            ((a) obj).a((b) obj2);
            AppMethodBeat.o(11514);
        }
    };
    private AtomicLong fxu = new AtomicLong(-1);

    public interface a {

        public enum a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.o(11517);
            }
        }

        public static class b {
            public String cwz;
            public a fxA;
            public c fxB;
            public long fxq;
        }

        void a(b bVar);
    }

    static {
        AppMethodBeat.i(11527);
        AppMethodBeat.o(11527);
    }

    public d(e eVar) {
        super(eVar, c.ccO, "BizChatInfo", null);
        AppMethodBeat.i(11518);
        this.bSd = eVar;
        eVar.hY("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
        eVar.hY("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
        eVar.hY("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
        synchronized (this.fxu) {
            try {
                Cursor a = this.bSd.a("select max(bizChatLocalId) from BizChatInfo", null, 2);
                long j = 0;
                if (a.moveToFirst()) {
                    j = (long) a.getInt(0);
                    if (j > this.fxu.get()) {
                        this.fxu.set(j);
                    }
                }
                a.close();
                ab.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:".concat(String.valueOf(j)));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(11518);
            }
        }
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(11519);
        this.fuL.a(aVar, looper);
        AppMethodBeat.o(11519);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(11520);
        if (this.fuL != null) {
            this.fuL.remove(aVar);
        }
        AppMethodBeat.o(11520);
    }

    public final c aK(long j) {
        AppMethodBeat.i(11521);
        c cVar = new c();
        cVar.field_bizChatLocalId = j;
        super.b(cVar, new String[0]);
        AppMethodBeat.o(11521);
        return cVar;
    }

    public final c rq(String str) {
        AppMethodBeat.i(11522);
        c cVar = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * ");
        stringBuilder.append(" from BizChatInfo");
        stringBuilder.append(" where bizChatServId = '").append(str).append("' ");
        stringBuilder.append(" limit 1");
        ab.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", stringBuilder.toString());
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.d(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(11522);
        return cVar;
    }

    public final boolean fw(long j) {
        AppMethodBeat.i(11523);
        c aK = aK(j);
        boolean a = super.a(aK, "bizChatLocalId");
        if (a) {
            b bVar = new b();
            bVar.fxq = aK.field_bizChatLocalId;
            bVar.cwz = aK.field_brandUserName;
            bVar.fxA = a.DELETE;
            bVar.fxB = aK;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11523);
        return a;
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(11524);
        if (cVar == null) {
            ab.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
            AppMethodBeat.o(11524);
            return false;
        } else if (bo.isNullOrNil(cVar.field_bizChatServId)) {
            ab.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
            AppMethodBeat.o(11524);
            return false;
        } else {
            c rq = rq(cVar.field_bizChatServId);
            if (rq != null) {
                cVar.field_bizChatLocalId = rq.field_bizChatLocalId;
                ab.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
                AppMethodBeat.o(11524);
                return true;
            }
            cVar.field_bizChatLocalId = afi();
            boolean b = super.b((c) cVar);
            if (b) {
                b bVar = new b();
                bVar.fxq = cVar.field_bizChatLocalId;
                bVar.cwz = cVar.field_brandUserName;
                bVar.fxA = a.INSTERT;
                bVar.fxB = cVar;
                this.fuL.cF(bVar);
                this.fuL.doNotify();
            }
            AppMethodBeat.o(11524);
            return b;
        }
    }

    public final boolean b(c cVar) {
        boolean z = false;
        AppMethodBeat.i(11525);
        if (cVar == null) {
            ab.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
            AppMethodBeat.o(11525);
        } else if (cVar.field_bizChatLocalId < 0) {
            ab.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
            AppMethodBeat.o(11525);
        } else {
            c aK = aK(cVar.field_bizChatLocalId);
            if (bo.isNullOrNil(aK.field_bizChatServId) || aK.field_bizChatServId.equals(cVar.field_bizChatServId)) {
                if (cVar == null || bo.isNullOrNil(cVar.field_chatName)) {
                    ab.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
                } else {
                    cVar.field_chatNamePY = g.vo(cVar.field_chatName);
                }
                z = super.a(cVar);
                if (z) {
                    e.g(cVar);
                    b bVar = new b();
                    bVar.fxq = cVar.field_bizChatLocalId;
                    bVar.cwz = cVar.field_brandUserName;
                    bVar.fxA = a.UPDATE;
                    bVar.fxB = cVar;
                    this.fuL.cF(bVar);
                    this.fuL.doNotify();
                }
                AppMethodBeat.o(11525);
            } else {
                ab.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
                AppMethodBeat.o(11525);
            }
        }
        return z;
    }

    private long afi() {
        AppMethodBeat.i(11526);
        synchronized (this.fxu) {
            try {
                ab.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", Long.valueOf(this.fxu.incrementAndGet()));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(11526);
            }
        }
        return r2;
    }
}
