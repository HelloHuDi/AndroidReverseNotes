package com.tencent.mm.ui.chatting.l;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

public final class c implements e<bi> {
    private Cursor PI;
    private int emW;
    private String emo;
    private int mCount;

    public c(String str, int i, int i2) {
        this.emo = str;
        this.mCount = i;
        this.emW = i2;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(32706);
        ab.d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", this.emo, Integer.valueOf(this.mCount), Integer.valueOf(this.emW), Long.valueOf(((j) g.K(j.class)).Yo().QQ(this.emo)));
        aw.ZK();
        this.PI = com.tencent.mm.model.c.XO().i(this.emo, this.mCount, r0);
        bVar.dY();
        AppMethodBeat.o(32706);
    }

    public final int dCP() {
        return this.emW;
    }

    public final void fk(List<bi> list) {
        AppMethodBeat.i(32707);
        try {
            this.PI.moveToFirst();
            while (!this.PI.isAfterLast()) {
                bi biVar = new bi();
                biVar.d(this.PI);
                list.add(biVar);
                this.PI.moveToNext();
            }
            AppMethodBeat.o(32707);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ChattingLoader.ChattingNormalDataSource", e, "", new Object[0]);
            AppMethodBeat.o(32707);
        }
    }

    public final void close() {
        AppMethodBeat.i(32708);
        this.PI.close();
        AppMethodBeat.o(32708);
    }
}
