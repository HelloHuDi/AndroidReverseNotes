package com.tencent.p177mm.plugin.backup.p920g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.backup.p921i.C19990m;
import com.tencent.p177mm.plugin.backup.p921i.C19991n;
import com.tencent.p177mm.plugin.backup.p921i.C19992o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.backup.g.k */
public final class C38655k extends C19978b {
    private C19991n jyf = new C19991n();
    public C19992o jyg = new C19992o();

    public C38655k(String str) {
        AppMethodBeat.m2504i(17679);
        C4990ab.m7417i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", str);
        this.jyf.f4366ID = str;
        AppMethodBeat.m2505o(17679);
    }

    public final int getType() {
        return 3;
    }

    public final C1331a aTT() {
        return this.jyf;
    }

    /* renamed from: a */
    public final void mo61494a(long j, C19990m c19990m, int i) {
        this.jyf.jBL = 0;
        this.jyf.jBM = j;
        this.jyf.jBN = 0;
        this.jyf.jBO = c19990m;
        this.jyf.jBP = 0;
        this.jyf.jBQ = i;
    }

    /* renamed from: rw */
    public final void mo6711rw(int i) {
        AppMethodBeat.m2504i(17680);
        C4990ab.m7416i("MicroMsg.BackupStartScene", "onSceneEnd.");
        if (this.jyg.jBT != 0) {
            mo35227l(4, this.jyg.jBT, "BackupStartScene onSceneEnd failed");
            AppMethodBeat.m2505o(17680);
            return;
        }
        mo35227l(0, this.jyg.jBT, "BackupStartScene onSceneEnd success");
        AppMethodBeat.m2505o(17680);
    }

    public final /* bridge */ /* synthetic */ C1331a aTS() {
        return this.jyg;
    }
}
