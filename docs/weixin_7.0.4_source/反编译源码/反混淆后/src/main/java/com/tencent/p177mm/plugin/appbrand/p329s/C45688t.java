package com.tencent.p177mm.plugin.appbrand.p329s;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wxmm.v2helper;

@TargetApi(3)
/* renamed from: com.tencent.mm.plugin.appbrand.s.t */
public final class C45688t extends OrientationEventListener {
    private int gfQ = 45;
    private C45687a iRL = C45687a.NONE;
    private C10731b iRM;

    /* renamed from: com.tencent.mm.plugin.appbrand.s.t$b */
    public interface C10731b {
        /* renamed from: a */
        void mo22009a(C45687a c45687a, C45687a c45687a2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s.t$a */
    public enum C45687a {
        NONE,
        PORTRAIT,
        LANDSCAPE,
        REVERSE_PORTRAIT,
        REVERSE_LANDSCAPE;

        static {
            AppMethodBeat.m2505o(126640);
        }
    }

    public C45688t(Context context, C10731b c10731b) {
        super(context);
        this.iRM = c10731b;
    }

    public final void enable() {
        AppMethodBeat.m2504i(126641);
        super.enable();
        AppMethodBeat.m2505o(126641);
    }

    public final void disable() {
        AppMethodBeat.m2504i(126642);
        super.disable();
        this.iRL = C45687a.NONE;
        AppMethodBeat.m2505o(126642);
    }

    public final void onOrientationChanged(int i) {
        AppMethodBeat.m2504i(126643);
        if (i == -1) {
            AppMethodBeat.m2505o(126643);
            return;
        }
        C45687a c45687a = this.iRL;
        if ((i >= 360 - this.gfQ && i < v2helper.VOIP_ENC_HEIGHT_LV1) || (i >= 0 && i <= this.gfQ + 0)) {
            c45687a = C45687a.PORTRAIT;
        } else if (i >= 270 - this.gfQ && i <= this.gfQ + 270) {
            c45687a = C45687a.LANDSCAPE;
        } else if (i >= 180 - this.gfQ && i <= this.gfQ + 180) {
            c45687a = C45687a.REVERSE_PORTRAIT;
        } else if (i >= 90 - this.gfQ && i <= this.gfQ + 90) {
            c45687a = C45687a.REVERSE_LANDSCAPE;
        }
        if (c45687a != this.iRL) {
            if (!(this.iRM == null || this.iRL == C45687a.NONE)) {
                this.iRM.mo22009a(this.iRL, c45687a);
            }
            this.iRL = c45687a;
        }
        C4990ab.m7416i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(126643);
    }
}
