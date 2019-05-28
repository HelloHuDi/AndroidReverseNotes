package com.tencent.p177mm.p184aj.p185a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6558ab;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.aj.a.g */
public final class C25757g extends C7563j<C6558ab> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C8925f.ccO, "BizChatMyUserInfo")};
    private C4927e bSd;
    private final C4934l<C25758a, C17899b> fuL = new C178971();

    /* renamed from: com.tencent.mm.aj.a.g$1 */
    class C178971 extends C4934l<C25758a, C17899b> {
        C178971() {
        }

        /* renamed from: w */
        public final /* bridge */ /* synthetic */ void mo10134w(Object obj, Object obj2) {
        }
    }

    /* renamed from: com.tencent.mm.aj.a.g$a */
    public interface C25758a {

        /* renamed from: com.tencent.mm.aj.a.g$a$a */
        public enum C17898a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.m2505o(11559);
            }
        }

        /* renamed from: com.tencent.mm.aj.a.g$a$b */
        public static class C17899b {
            public String cwz;
            public C17898a fxN;
            public C8925f fxO;
        }
    }

    static {
        AppMethodBeat.m2504i(11566);
        AppMethodBeat.m2505o(11566);
    }

    public C25757g(C4927e c4927e) {
        super(c4927e, C8925f.ccO, "BizChatMyUserInfo", null);
        AppMethodBeat.m2504i(11560);
        this.bSd = c4927e;
        c4927e.mo10108hY("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
        AppMethodBeat.m2505o(11560);
    }

    /* renamed from: rA */
    public final C8925f mo43711rA(String str) {
        AppMethodBeat.m2504i(11561);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
            AppMethodBeat.m2505o(11561);
            return null;
        }
        C4925c c8925f = new C8925f();
        c8925f.field_brandUserName = str;
        super.mo10102b(c8925f, new String[0]);
        AppMethodBeat.m2505o(11561);
        return c8925f;
    }

    /* renamed from: rB */
    public final boolean mo43712rB(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(11562);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
            AppMethodBeat.m2505o(11562);
        } else {
            C4925c c8925f = new C8925f();
            c8925f.field_brandUserName = str;
            z = super.mo16760a(c8925f, "brandUserName");
            if (z) {
                C17899b c17899b = new C17899b();
                c17899b.cwz = c8925f.field_brandUserName;
                c17899b.fxN = C17898a.DELETE;
                c17899b.fxO = c8925f;
                this.fuL.mo10126cF(c17899b);
                this.fuL.doNotify();
            }
            AppMethodBeat.m2505o(11562);
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo43709a(C8925f c8925f) {
        AppMethodBeat.m2504i(11563);
        C4990ab.m7410d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
        boolean b = super.mo10101b((C4925c) c8925f);
        if (b) {
            C17899b c17899b = new C17899b();
            c17899b.cwz = c8925f.field_brandUserName;
            c17899b.fxN = C17898a.INSTERT;
            c17899b.fxO = c8925f;
            this.fuL.mo10126cF(c17899b);
            this.fuL.doNotify();
        } else {
            C4990ab.m7420w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
        }
        AppMethodBeat.m2505o(11563);
        return b;
    }

    /* renamed from: b */
    public final boolean mo43710b(C8925f c8925f) {
        AppMethodBeat.m2504i(11564);
        C4990ab.m7410d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
        if (c8925f == null) {
            C4990ab.m7420w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
            AppMethodBeat.m2505o(11564);
            return false;
        }
        boolean a = super.mo10099a(c8925f);
        if (a) {
            C17899b c17899b = new C17899b();
            c17899b.cwz = c8925f.field_brandUserName;
            c17899b.fxN = C17898a.UPDATE;
            c17899b.fxO = c8925f;
            this.fuL.mo10126cF(c17899b);
            this.fuL.doNotify();
        } else {
            C4990ab.m7420w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
        }
        AppMethodBeat.m2505o(11564);
        return a;
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.m2504i(11565);
        C4990ab.m7410d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
        Cursor a = this.bSd.mo10104a("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(11565);
        return i;
    }
}
