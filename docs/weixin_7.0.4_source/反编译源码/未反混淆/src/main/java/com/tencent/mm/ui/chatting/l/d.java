package com.tencent.mm.ui.chatting.l;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

public final class d implements e<bi> {
    private Cursor PI;
    private String emo;
    private long zac;
    private long zad;

    public d(String str, long j, long j2) {
        this.emo = str;
        this.zac = j;
        this.zad = j2;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(32709);
        aw.ZK();
        this.PI = c.XO().t(this.emo, this.zac, this.zad);
        bVar.dY();
        AppMethodBeat.o(32709);
    }

    public final int dCP() {
        AppMethodBeat.i(32710);
        aw.ZK();
        int Rp = c.XO().Rp(this.emo);
        AppMethodBeat.o(32710);
        return Rp;
    }

    public final void fk(List<bi> list) {
        AppMethodBeat.i(32711);
        try {
            this.PI.moveToFirst();
            while (!this.PI.isAfterLast()) {
                bi biVar = new bi();
                biVar.d(this.PI);
                list.add(biVar);
                this.PI.moveToNext();
            }
            AppMethodBeat.o(32711);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSearchDataSource", e, "", new Object[0]);
            AppMethodBeat.o(32711);
        }
    }

    public final void close() {
        AppMethodBeat.i(32712);
        this.PI.close();
        AppMethodBeat.o(32712);
    }
}
