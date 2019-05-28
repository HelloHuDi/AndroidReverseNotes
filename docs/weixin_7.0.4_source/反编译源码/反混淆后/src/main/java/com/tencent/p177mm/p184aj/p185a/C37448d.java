package com.tencent.p177mm.p184aj.p185a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32680aa;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.tencent.mm.aj.a.d */
public final class C37448d extends C7563j<C32680aa> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C45142c.ccO, "BizChatInfo")};
    public C4927e bSd;
    final C4934l<C25753a, C8924b> fuL = new C322341();
    private AtomicLong fxu = new AtomicLong(-1);

    /* renamed from: com.tencent.mm.aj.a.d$a */
    public interface C25753a {

        /* renamed from: com.tencent.mm.aj.a.d$a$a */
        public enum C8923a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.m2505o(11517);
            }
        }

        /* renamed from: com.tencent.mm.aj.a.d$a$b */
        public static class C8924b {
            public String cwz;
            public C8923a fxA;
            public C45142c fxB;
            public long fxq;
        }

        /* renamed from: a */
        void mo15833a(C8924b c8924b);
    }

    /* renamed from: com.tencent.mm.aj.a.d$1 */
    class C322341 extends C4934l<C25753a, C8924b> {
        C322341() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(11514);
            ((C25753a) obj).mo15833a((C8924b) obj2);
            AppMethodBeat.m2505o(11514);
        }
    }

    static {
        AppMethodBeat.m2504i(11527);
        AppMethodBeat.m2505o(11527);
    }

    public C37448d(C4927e c4927e) {
        super(c4927e, C45142c.ccO, "BizChatInfo", null);
        AppMethodBeat.m2504i(11518);
        this.bSd = c4927e;
        c4927e.mo10108hY("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
        c4927e.mo10108hY("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
        c4927e.mo10108hY("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
        synchronized (this.fxu) {
            try {
                Cursor a = this.bSd.mo10104a("select max(bizChatLocalId) from BizChatInfo", null, 2);
                long j = 0;
                if (a.moveToFirst()) {
                    j = (long) a.getInt(0);
                    if (j > this.fxu.get()) {
                        this.fxu.set(j);
                    }
                }
                a.close();
                C4990ab.m7416i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:".concat(String.valueOf(j)));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(11518);
            }
        }
    }

    /* renamed from: a */
    public final void mo60347a(C25753a c25753a, Looper looper) {
        AppMethodBeat.m2504i(11519);
        this.fuL.mo10125a(c25753a, looper);
        AppMethodBeat.m2505o(11519);
    }

    /* renamed from: a */
    public final void mo60346a(C25753a c25753a) {
        AppMethodBeat.m2504i(11520);
        if (this.fuL != null) {
            this.fuL.remove(c25753a);
        }
        AppMethodBeat.m2505o(11520);
    }

    /* renamed from: aK */
    public final C45142c mo60349aK(long j) {
        AppMethodBeat.m2504i(11521);
        C4925c c45142c = new C45142c();
        c45142c.field_bizChatLocalId = j;
        super.mo10102b(c45142c, new String[0]);
        AppMethodBeat.m2505o(11521);
        return c45142c;
    }

    /* renamed from: rq */
    public final C45142c mo60352rq(String str) {
        AppMethodBeat.m2504i(11522);
        C45142c c45142c = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * ");
        stringBuilder.append(" from BizChatInfo");
        stringBuilder.append(" where bizChatServId = '").append(str).append("' ");
        stringBuilder.append(" limit 1");
        C4990ab.m7411d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", stringBuilder.toString());
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                c45142c = new C45142c();
                c45142c.mo8995d(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.m2505o(11522);
        return c45142c;
    }

    /* renamed from: fw */
    public final boolean mo60351fw(long j) {
        AppMethodBeat.m2504i(11523);
        C4925c aK = mo60349aK(j);
        boolean a = super.mo16760a(aK, "bizChatLocalId");
        if (a) {
            C8924b c8924b = new C8924b();
            c8924b.fxq = aK.field_bizChatLocalId;
            c8924b.cwz = aK.field_brandUserName;
            c8924b.fxA = C8923a.DELETE;
            c8924b.fxB = aK;
            this.fuL.mo10126cF(c8924b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11523);
        return a;
    }

    /* renamed from: a */
    public final boolean mo60348a(C45142c c45142c) {
        AppMethodBeat.m2504i(11524);
        if (c45142c == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
            AppMethodBeat.m2505o(11524);
            return false;
        } else if (C5046bo.isNullOrNil(c45142c.field_bizChatServId)) {
            C4990ab.m7412e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
            AppMethodBeat.m2505o(11524);
            return false;
        } else {
            C45142c rq = mo60352rq(c45142c.field_bizChatServId);
            if (rq != null) {
                c45142c.field_bizChatLocalId = rq.field_bizChatLocalId;
                C4990ab.m7412e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
                AppMethodBeat.m2505o(11524);
                return true;
            }
            c45142c.field_bizChatLocalId = afi();
            boolean b = super.mo10101b((C4925c) c45142c);
            if (b) {
                C8924b c8924b = new C8924b();
                c8924b.fxq = c45142c.field_bizChatLocalId;
                c8924b.cwz = c45142c.field_brandUserName;
                c8924b.fxA = C8923a.INSTERT;
                c8924b.fxB = c45142c;
                this.fuL.mo10126cF(c8924b);
                this.fuL.doNotify();
            }
            AppMethodBeat.m2505o(11524);
            return b;
        }
    }

    /* renamed from: b */
    public final boolean mo60350b(C45142c c45142c) {
        boolean z = false;
        AppMethodBeat.m2504i(11525);
        if (c45142c == null) {
            C4990ab.m7420w("MicroMsg.BizChatInfoStorage", "update wrong argument");
            AppMethodBeat.m2505o(11525);
        } else if (c45142c.field_bizChatLocalId < 0) {
            C4990ab.m7412e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
            AppMethodBeat.m2505o(11525);
        } else {
            C45142c aK = mo60349aK(c45142c.field_bizChatLocalId);
            if (C5046bo.isNullOrNil(aK.field_bizChatServId) || aK.field_bizChatServId.equals(c45142c.field_bizChatServId)) {
                if (c45142c == null || C5046bo.isNullOrNil(c45142c.field_chatName)) {
                    C4990ab.m7416i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
                } else {
                    c45142c.field_chatNamePY = C9790g.m17432vo(c45142c.field_chatName);
                }
                z = super.mo10099a(c45142c);
                if (z) {
                    C25754e.m40901g(c45142c);
                    C8924b c8924b = new C8924b();
                    c8924b.fxq = c45142c.field_bizChatLocalId;
                    c8924b.cwz = c45142c.field_brandUserName;
                    c8924b.fxA = C8923a.UPDATE;
                    c8924b.fxB = c45142c;
                    this.fuL.mo10126cF(c8924b);
                    this.fuL.doNotify();
                }
                AppMethodBeat.m2505o(11525);
            } else {
                C4990ab.m7412e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
                AppMethodBeat.m2505o(11525);
            }
        }
        return z;
    }

    private long afi() {
        AppMethodBeat.m2504i(11526);
        synchronized (this.fxu) {
            try {
                C4990ab.m7417i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", Long.valueOf(this.fxu.incrementAndGet()));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(11526);
            }
        }
        return r2;
    }
}
