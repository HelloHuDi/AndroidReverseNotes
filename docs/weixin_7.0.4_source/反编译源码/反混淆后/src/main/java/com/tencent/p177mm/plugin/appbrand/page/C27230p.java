package com.tencent.p177mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.menu.C42636n;
import com.tencent.p177mm.plugin.appbrand.weishi.C33572e;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.page.p */
public final class C27230p extends C19643o {
    C27230p(C27242w c27242w, List<C42636n> list) {
        super(c27242w, list);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo34880a(C36356d c36356d) {
        boolean z = false;
        AppMethodBeat.m2504i(132338);
        super.mo34880a(c36356d);
        final C27242w c27242w = (C27242w) this.hTn;
        if (C33572e.m54822E(c27242w.getRuntime())) {
            c36356d.uEO = true;
            c36356d.uEP = true;
        } else if (c27242w.getRuntime().mo65903xy()) {
            boolean z2;
            if (c27242w.isFullScreen() || c27242w.aJQ()) {
                z2 = true;
            } else {
                z2 = false;
            }
            c36356d.uEO = z2;
            if (c27242w.isFullScreen() || c27242w.aJQ()) {
                z = true;
            }
            c36356d.uEP = z;
        } else {
            c36356d.uEO = c27242w.isFullScreen();
            c36356d.uEP = c27242w.isFullScreen();
        }
        c27242w.mo53827a((C10379b) new C10379b() {
            /* renamed from: wW */
            public final void mo21857wW() {
                AppMethodBeat.m2504i(132336);
                c27242w.mo53832b((C10379b) this);
                C27230p.this.aJn();
                AppMethodBeat.m2505o(132336);
            }
        });
        c27242w.mo53828a((C10380c) new C10380c() {
            public final void onDestroy() {
                AppMethodBeat.m2504i(132337);
                c27242w.mo53833b((C10380c) this);
                C27230p.this.aJn();
                AppMethodBeat.m2505o(132337);
            }
        });
        AppMethodBeat.m2505o(132338);
    }
}
