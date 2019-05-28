package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;

public final class l extends b {
    private af jyh = new af();
    private ag jyi = new ag();
    private a jyj;

    public interface a {
        void D(LinkedList<Long> linkedList);
    }

    public l(String str, HashMap<Long, com.tencent.mm.plugin.backup.f.h.a> hashMap, a aVar) {
        AppMethodBeat.i(17681);
        this.jyj = aVar;
        this.jyh.jBt = str;
        ab.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", str);
        this.jyh.jCP = new LinkedList();
        this.jyh.jCQ = new LinkedList();
        this.jyh.jCR = new LinkedList();
        for (Long l : hashMap.keySet()) {
            com.tencent.mm.plugin.backup.f.h.a aVar2 = (com.tencent.mm.plugin.backup.f.h.a) hashMap.get(l);
            this.jyh.jCP.add(Long.valueOf(aVar2.jvz));
            this.jyh.jCQ.add(aVar2.jvA);
            this.jyh.jCR.add(aVar2.cvZ);
        }
        AppMethodBeat.o(17681);
    }

    public final int getType() {
        return 13;
    }

    public final com.tencent.mm.bt.a aTS() {
        return this.jyi;
    }

    public final com.tencent.mm.bt.a aTT() {
        return this.jyh;
    }

    public final void rw(int i) {
        AppMethodBeat.i(17682);
        ab.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
        l(0, 0, "success");
        this.jyj.D(this.jyi.jCP);
        AppMethodBeat.o(17682);
    }
}
