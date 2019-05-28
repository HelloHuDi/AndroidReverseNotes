package com.tencent.p177mm.p612ui.chatting.p622l;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40750b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.l.c */
public final class C46664c implements C30549e<C7620bi> {
    /* renamed from: PI */
    private Cursor f17920PI;
    private int emW;
    private String emo;
    private int mCount;

    public C46664c(String str, int i, int i2) {
        this.emo = str;
        this.mCount = i;
        this.emW = i2;
    }

    /* renamed from: a */
    public final void mo48956a(C40750b c40750b) {
        AppMethodBeat.m2504i(32706);
        C4990ab.m7411d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", this.emo, Integer.valueOf(this.mCount), Integer.valueOf(this.emW), Long.valueOf(((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7908QQ(this.emo)));
        C9638aw.m17190ZK();
        this.f17920PI = C18628c.m29080XO().mo15339i(this.emo, this.mCount, r0);
        c40750b.mo15847dY();
        AppMethodBeat.m2505o(32706);
    }

    public final int dCP() {
        return this.emW;
    }

    /* renamed from: fk */
    public final void mo48959fk(List<C7620bi> list) {
        AppMethodBeat.m2504i(32707);
        try {
            this.f17920PI.moveToFirst();
            while (!this.f17920PI.isAfterLast()) {
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(this.f17920PI);
                list.add(c7620bi);
                this.f17920PI.moveToNext();
            }
            AppMethodBeat.m2505o(32707);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ChattingLoader.ChattingNormalDataSource", e, "", new Object[0]);
            AppMethodBeat.m2505o(32707);
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(32708);
        this.f17920PI.close();
        AppMethodBeat.m2505o(32708);
    }
}
