package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6980m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6980m.C3466a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.storage.bw */
public final class C7621bw extends C7563j<C7575bv> implements C6980m {
    public static final String[] fnj = new String[]{C7563j.m13217a(C7575bv.ccO, "Stranger")};
    private C4927e bSd;
    private final C4934l<C3466a, C7575bv> xHV = new C73121();

    /* renamed from: com.tencent.mm.storage.bw$1 */
    class C73121 extends C4934l<C3466a, C7575bv> {
        C73121() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(1473);
            ((C3466a) obj).mo7925a((C7575bv) obj2);
            AppMethodBeat.m2505o(1473);
        }
    }

    static {
        AppMethodBeat.m2504i(1482);
        AppMethodBeat.m2505o(1482);
    }

    /* renamed from: b */
    private void m13574b(C7575bv c7575bv) {
        AppMethodBeat.m2504i(1474);
        if (this.xHV.mo10126cF(c7575bv)) {
            this.xHV.doNotify();
        }
        AppMethodBeat.m2505o(1474);
    }

    /* renamed from: a */
    public final void mo15366a(C3466a c3466a) {
        AppMethodBeat.m2504i(1475);
        this.xHV.mo10125a(c3466a, null);
        AppMethodBeat.m2505o(1475);
    }

    /* renamed from: b */
    public final void mo15367b(C3466a c3466a) {
        AppMethodBeat.m2504i(1476);
        this.xHV.remove(c3466a);
        AppMethodBeat.m2505o(1476);
    }

    public C7621bw(C4927e c4927e) {
        super(c4927e, C7575bv.ccO, "Stranger", null);
        AppMethodBeat.m2504i(1477);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(1477);
    }

    /* renamed from: RB */
    public final C7575bv mo15364RB(String str) {
        AppMethodBeat.m2504i(1478);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(1478);
            return null;
        }
        C7575bv c7575bv = new C7575bv();
        Cursor a = this.bSd.mo10105a("Stranger", null, "encryptUsername = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            c7575bv.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1478);
        return c7575bv;
    }

    /* renamed from: RC */
    public final int mo15365RC(String str) {
        AppMethodBeat.m2504i(1479);
        int delete = this.bSd.delete("Stranger", "(encryptUsername=?)", new String[]{String.valueOf(str)});
        if (delete > 0) {
            doNotify();
        }
        C4990ab.m7416i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + str + " result:" + delete);
        AppMethodBeat.m2505o(1479);
        return delete;
    }
}
