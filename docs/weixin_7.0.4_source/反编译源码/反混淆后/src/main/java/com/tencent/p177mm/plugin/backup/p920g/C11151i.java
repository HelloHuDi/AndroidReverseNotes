package com.tencent.p177mm.plugin.backup.p920g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.backup.p921i.C38662i;
import com.tencent.p177mm.plugin.backup.p921i.C45752j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.g.i */
public final class C11151i extends C19978b {
    private C38662i jxT = new C38662i();
    public C45752j jxU = new C45752j();

    public C11151i(LinkedList<String> linkedList, long j, long j2) {
        AppMethodBeat.m2504i(17674);
        C4990ab.m7417i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", Integer.valueOf(linkedList.size()), Long.valueOf(j), Long.valueOf(j2));
        this.jxT.jBx = linkedList;
        this.jxT.jBy = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            it.next();
            this.jxT.jBy.add(Long.valueOf(j));
            this.jxT.jBy.add(Long.valueOf(j2));
        }
        AppMethodBeat.m2505o(17674);
    }

    public final int getType() {
        return 11;
    }

    public final C1331a aTS() {
        return this.jxU;
    }

    public final C1331a aTT() {
        return this.jxT;
    }

    /* renamed from: rw */
    public final void mo6711rw(int i) {
        AppMethodBeat.m2504i(17675);
        if (this.jxU.jBx == null || this.jxU.jBy == null || this.jxU.jBx.isEmpty() || this.jxU.jBx.size() * 2 != this.jxU.jBy.size()) {
            if (!(this.jxU.jBx == null || this.jxU.jBy == null)) {
                C4990ab.m7413e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", Integer.valueOf(this.jxU.jBx.size()), Integer.valueOf(this.jxU.jBy.size()));
            }
            mo35227l(4, -1, "BackupRequestSession failed");
            AppMethodBeat.m2505o(17675);
            return;
        }
        C4990ab.m7417i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", Integer.valueOf(this.jxU.jBx.size()), this.jxU.jBx.toString());
        C4990ab.m7417i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", this.jxU.jBy.toString());
        mo35227l(0, 0, "BackupRequestSession success");
        AppMethodBeat.m2505o(17675);
    }
}
