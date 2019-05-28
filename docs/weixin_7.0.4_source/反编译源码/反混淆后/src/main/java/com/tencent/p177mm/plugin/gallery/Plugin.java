package com.tencent.p177mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.pluginsdk.C23244m;
import com.tencent.p177mm.pluginsdk.C23255n;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.gallery.Plugin */
public class Plugin implements C40415c {

    /* renamed from: com.tencent.mm.plugin.gallery.Plugin$1 */
    class C32041 implements C23256o {
        C32041() {
        }

        /* renamed from: a */
        public final void mo7223a(C23255n c23255n) {
        }

        /* renamed from: a */
        public final void mo7222a(C23244m c23244m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.Plugin$2 */
    class C32052 implements C1816at {
        C32052() {
        }

        /* renamed from: Jx */
        public final HashMap<Integer, C1366d> mo5391Jx() {
            return null;
        }

        /* renamed from: iy */
        public final void mo5394iy(int i) {
        }

        /* renamed from: bz */
        public final void mo5393bz(boolean z) {
        }

        /* renamed from: bA */
        public final void mo5392bA(boolean z) {
        }

        public final void onAccountRelease() {
        }
    }

    public C23256o createApplication() {
        AppMethodBeat.m2504i(21216);
        C32041 c32041 = new C32041();
        AppMethodBeat.m2505o(21216);
        return c32041;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(21217);
        C32052 c32052 = new C32052();
        AppMethodBeat.m2505o(21217);
        return c32052;
    }
}
