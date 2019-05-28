package com.tencent.mm.ui.chatting.l;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

public final class a implements e<bi> {
    private Cursor PI;
    private int emW;
    private String emo;
    private int mCount;
    private long yNB;

    public a(String str, long j, int i, int i2) {
        this.emo = str;
        this.yNB = j;
        this.emW = i2;
        this.mCount = i;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(32684);
        long QQ = ((j) g.K(j.class)).Yo().QQ(this.emo);
        ab.d("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", this.emo, Long.valueOf(this.yNB), Integer.valueOf(this.mCount), Integer.valueOf(this.emW), Long.valueOf(QQ));
        aw.ZK();
        this.PI = c.XP().p(this.emo, this.yNB, this.mCount);
        bVar.dY();
        AppMethodBeat.o(32684);
    }

    public final int dCP() {
        return this.emW;
    }

    public final void fk(List<bi> list) {
        AppMethodBeat.i(32685);
        this.PI.moveToFirst();
        while (!this.PI.isAfterLast()) {
            bi biVar = new bi();
            biVar.d(this.PI);
            list.add(biVar);
            this.PI.moveToNext();
        }
        AppMethodBeat.o(32685);
    }

    public final void close() {
        AppMethodBeat.i(32686);
        this.PI.close();
        AppMethodBeat.o(32686);
    }
}
