package com.tencent.p177mm.plugin.backup.p920g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.backup.p346f.C45745h.C19972a;
import com.tencent.p177mm.plugin.backup.p921i.C11152ag;
import com.tencent.p177mm.plugin.backup.p921i.C27492af;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.g.l */
public final class C45746l extends C19978b {
    private C27492af jyh = new C27492af();
    private C11152ag jyi = new C11152ag();
    private C33706a jyj;

    /* renamed from: com.tencent.mm.plugin.backup.g.l$a */
    public interface C33706a {
        /* renamed from: D */
        void mo22841D(LinkedList<Long> linkedList);
    }

    public C45746l(String str, HashMap<Long, C19972a> hashMap, C33706a c33706a) {
        AppMethodBeat.m2504i(17681);
        this.jyj = c33706a;
        this.jyh.jBt = str;
        C4990ab.m7417i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", str);
        this.jyh.jCP = new LinkedList();
        this.jyh.jCQ = new LinkedList();
        this.jyh.jCR = new LinkedList();
        for (Long l : hashMap.keySet()) {
            C19972a c19972a = (C19972a) hashMap.get(l);
            this.jyh.jCP.add(Long.valueOf(c19972a.jvz));
            this.jyh.jCQ.add(c19972a.jvA);
            this.jyh.jCR.add(c19972a.cvZ);
        }
        AppMethodBeat.m2505o(17681);
    }

    public final int getType() {
        return 13;
    }

    public final C1331a aTS() {
        return this.jyi;
    }

    public final C1331a aTT() {
        return this.jyh;
    }

    /* renamed from: rw */
    public final void mo6711rw(int i) {
        AppMethodBeat.m2504i(17682);
        C4990ab.m7416i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
        mo35227l(0, 0, "success");
        this.jyj.mo22841D(this.jyi.jCP);
        AppMethodBeat.m2505o(17682);
    }
}
