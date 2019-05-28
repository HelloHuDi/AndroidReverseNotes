package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends b {
    private com.tencent.mm.plugin.backup.i.i jxT = new com.tencent.mm.plugin.backup.i.i();
    public j jxU = new j();

    public i(LinkedList<String> linkedList, long j, long j2) {
        AppMethodBeat.i(17674);
        ab.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", Integer.valueOf(linkedList.size()), Long.valueOf(j), Long.valueOf(j2));
        this.jxT.jBx = linkedList;
        this.jxT.jBy = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            it.next();
            this.jxT.jBy.add(Long.valueOf(j));
            this.jxT.jBy.add(Long.valueOf(j2));
        }
        AppMethodBeat.o(17674);
    }

    public final int getType() {
        return 11;
    }

    public final a aTS() {
        return this.jxU;
    }

    public final a aTT() {
        return this.jxT;
    }

    public final void rw(int i) {
        AppMethodBeat.i(17675);
        if (this.jxU.jBx == null || this.jxU.jBy == null || this.jxU.jBx.isEmpty() || this.jxU.jBx.size() * 2 != this.jxU.jBy.size()) {
            if (!(this.jxU.jBx == null || this.jxU.jBy == null)) {
                ab.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", Integer.valueOf(this.jxU.jBx.size()), Integer.valueOf(this.jxU.jBy.size()));
            }
            l(4, -1, "BackupRequestSession failed");
            AppMethodBeat.o(17675);
            return;
        }
        ab.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", Integer.valueOf(this.jxU.jBx.size()), this.jxU.jBx.toString());
        ab.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", this.jxU.jBy.toString());
        l(0, 0, "BackupRequestSession success");
        AppMethodBeat.o(17675);
    }
}
