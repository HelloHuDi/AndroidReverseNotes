package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends b {
    private n jyf = new n();
    public o jyg = new o();

    public k(String str) {
        AppMethodBeat.i(17679);
        ab.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", str);
        this.jyf.ID = str;
        AppMethodBeat.o(17679);
    }

    public final int getType() {
        return 3;
    }

    public final a aTT() {
        return this.jyf;
    }

    public final void a(long j, m mVar, int i) {
        this.jyf.jBL = 0;
        this.jyf.jBM = j;
        this.jyf.jBN = 0;
        this.jyf.jBO = mVar;
        this.jyf.jBP = 0;
        this.jyf.jBQ = i;
    }

    public final void rw(int i) {
        AppMethodBeat.i(17680);
        ab.i("MicroMsg.BackupStartScene", "onSceneEnd.");
        if (this.jyg.jBT != 0) {
            l(4, this.jyg.jBT, "BackupStartScene onSceneEnd failed");
            AppMethodBeat.o(17680);
            return;
        }
        l(0, this.jyg.jBT, "BackupStartScene onSceneEnd success");
        AppMethodBeat.o(17680);
    }

    public final /* bridge */ /* synthetic */ a aTS() {
        return this.jyg;
    }
}
