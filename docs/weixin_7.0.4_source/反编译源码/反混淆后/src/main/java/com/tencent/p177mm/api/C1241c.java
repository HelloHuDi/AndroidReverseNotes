package com.tencent.p177mm.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.api.c */
public abstract class C1241c extends FrameLayout {
    C8956r ccE = new C12421();

    /* renamed from: com.tencent.mm.api.c$1 */
    class C12421 implements C8956r {
        C12421() {
        }

        /* renamed from: a */
        public final void mo4525a(C32247e c32247e) {
            AppMethodBeat.m2504i(73797);
            C4990ab.m7417i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", c32247e.name());
            AppMethodBeat.m2505o(73797);
        }

        /* renamed from: a */
        public final void mo4526a(C32247e c32247e, int i) {
            AppMethodBeat.m2504i(73798);
            C4990ab.m7417i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", c32247e.name(), Integer.valueOf(i));
            AppMethodBeat.m2505o(73798);
        }

        /* renamed from: bd */
        public final void mo4527bd(boolean z) {
        }
    }

    public abstract void setActionBarCallback(C32249g c32249g);

    public abstract void setActionBarVisible(boolean z);

    public abstract void setAutoShowFooterAndBar(boolean z);

    public abstract void setFooterVisible(boolean z);

    public C1241c(Context context) {
        super(context);
    }

    public void setSelectedFeatureListener(C8956r c8956r) {
        this.ccE = c8956r;
    }

    public C8956r getSelectedFeatureListener() {
        return this.ccE;
    }
}
