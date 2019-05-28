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

/* renamed from: com.tencent.mm.ui.chatting.l.a */
public final class C46663a implements C30549e<C7620bi> {
    /* renamed from: PI */
    private Cursor f17919PI;
    private int emW;
    private String emo;
    private int mCount;
    private long yNB;

    public C46663a(String str, long j, int i, int i2) {
        this.emo = str;
        this.yNB = j;
        this.emW = i2;
        this.mCount = i;
    }

    /* renamed from: a */
    public final void mo48956a(C40750b c40750b) {
        AppMethodBeat.m2504i(32684);
        long QQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7908QQ(this.emo);
        C4990ab.m7411d("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", this.emo, Long.valueOf(this.yNB), Integer.valueOf(this.mCount), Integer.valueOf(this.emW), Long.valueOf(QQ));
        C9638aw.m17190ZK();
        this.f17919PI = C18628c.m29081XP().mo74803p(this.emo, this.yNB, this.mCount);
        c40750b.mo15847dY();
        AppMethodBeat.m2505o(32684);
    }

    public final int dCP() {
        return this.emW;
    }

    /* renamed from: fk */
    public final void mo48959fk(List<C7620bi> list) {
        AppMethodBeat.m2504i(32685);
        this.f17919PI.moveToFirst();
        while (!this.f17919PI.isAfterLast()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(this.f17919PI);
            list.add(c7620bi);
            this.f17919PI.moveToNext();
        }
        AppMethodBeat.m2505o(32685);
    }

    public final void close() {
        AppMethodBeat.m2504i(32686);
        this.f17919PI.close();
        AppMethodBeat.m2505o(32686);
    }
}
