package com.tencent.p177mm.p612ui.chatting.p622l;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40750b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.l.d */
public final class C40800d implements C30549e<C7620bi> {
    /* renamed from: PI */
    private Cursor f16213PI;
    private String emo;
    private long zac;
    private long zad;

    public C40800d(String str, long j, long j2) {
        this.emo = str;
        this.zac = j;
        this.zad = j2;
    }

    /* renamed from: a */
    public final void mo48956a(C40750b c40750b) {
        AppMethodBeat.m2504i(32709);
        C9638aw.m17190ZK();
        this.f16213PI = C18628c.m29080XO().mo15351t(this.emo, this.zac, this.zad);
        c40750b.mo15847dY();
        AppMethodBeat.m2505o(32709);
    }

    public final int dCP() {
        AppMethodBeat.m2504i(32710);
        C9638aw.m17190ZK();
        int Rp = C18628c.m29080XO().mo15262Rp(this.emo);
        AppMethodBeat.m2505o(32710);
        return Rp;
    }

    /* renamed from: fk */
    public final void mo48959fk(List<C7620bi> list) {
        AppMethodBeat.m2504i(32711);
        try {
            this.f16213PI.moveToFirst();
            while (!this.f16213PI.isAfterLast()) {
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(this.f16213PI);
                list.add(c7620bi);
                this.f16213PI.moveToNext();
            }
            AppMethodBeat.m2505o(32711);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSearchDataSource", e, "", new Object[0]);
            AppMethodBeat.m2505o(32711);
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(32712);
        this.f16213PI.close();
        AppMethodBeat.m2505o(32712);
    }
}
