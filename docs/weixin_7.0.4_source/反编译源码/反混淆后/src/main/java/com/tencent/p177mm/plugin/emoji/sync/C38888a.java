package com.tencent.p177mm.plugin.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p1592e.C41760a;
import com.tencent.p177mm.plugin.emoji.sync.C27743b.C11562a;
import com.tencent.p177mm.plugin.emoji.sync.C27743b.C27744b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.emoji.sync.a */
public final class C38888a<T extends C27745c> {
    public BKGLoaderManager kXj;

    public C38888a() {
        AppMethodBeat.m2504i(53171);
        C11562a c11562a = new C11562a();
        c11562a.kXl = new C27744b(c11562a.kXk, c11562a.kXk, new C41760a());
        m65964a(new C27743b(c11562a));
        AppMethodBeat.m2505o(53171);
    }

    /* renamed from: a */
    private synchronized void m65964a(C27743b c27743b) {
        AppMethodBeat.m2504i(53172);
        if (this.kXj == null) {
            this.kXj = new BKGLoaderManager(c27743b);
            AppMethodBeat.m2505o(53172);
        } else {
            C4990ab.m7416i("MicroMsg.BKGLoader.BKGLoader", "[cpan] BKGLoader had init.");
            AppMethodBeat.m2505o(53172);
        }
    }

    /* renamed from: z */
    public final void mo61755z(ArrayList<C27745c> arrayList) {
        AppMethodBeat.m2504i(53173);
        this.kXj.mo7138bu(arrayList);
        AppMethodBeat.m2505o(53173);
    }
}
