package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d extends b {
    private f fur;
    private z jxx = new z();
    public aa jxy = new aa();

    public d(String str, long j, long j2, String str2, String str3, LinkedList<String> linkedList, f fVar) {
        AppMethodBeat.i(17655);
        ab.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(linkedList.size()));
        this.jxx.jBt = str;
        this.jxx.jCE = j;
        this.jxx.jCF = j2;
        this.jxx.jCG = str2;
        this.jxx.jCH = str3;
        this.jxx.jCl = linkedList;
        this.fur = fVar;
        AppMethodBeat.o(17655);
    }

    public final boolean aUc() {
        AppMethodBeat.i(17656);
        boolean aUd = super.aUd();
        if (!aUd) {
            this.fur.onSceneEnd(1, -2, "doScene failed", this);
        }
        AppMethodBeat.o(17656);
        return aUd;
    }

    public final int getType() {
        return 15;
    }

    public final a aTS() {
        return this.jxy;
    }

    public final a aTT() {
        return this.jxx;
    }

    public final void rw(int i) {
        AppMethodBeat.i(17657);
        ab.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
        l(0, 0, "success");
        this.fur.onSceneEnd(0, 0, "", this);
        AppMethodBeat.o(17657);
    }
}
