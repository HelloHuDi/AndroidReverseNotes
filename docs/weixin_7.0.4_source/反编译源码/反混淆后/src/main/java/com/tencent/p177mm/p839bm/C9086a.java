package com.tencent.p177mm.p839bm;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wxmm.v2helper;

@TargetApi(3)
/* renamed from: com.tencent.mm.bm.a */
public final class C9086a extends OrientationEventListener {
    private C9088a gfP = C9088a.NONE;
    private int gfQ = 45;
    private C9087b gfR;

    /* renamed from: com.tencent.mm.bm.a$b */
    public interface C9087b {
        /* renamed from: a */
        void mo20572a(C9088a c9088a, C9088a c9088a2);
    }

    /* renamed from: com.tencent.mm.bm.a$a */
    public enum C9088a {
        NONE,
        PORTRAIT,
        LANDSCAPE,
        REVERSE_PORTRAIT,
        REVERSE_LANDSCAPE;

        static {
            AppMethodBeat.m2505o(78997);
        }
    }

    public C9086a(Context context, C9087b c9087b) {
        super(context);
        this.gfR = c9087b;
    }

    public final void enable() {
        AppMethodBeat.m2504i(78998);
        super.enable();
        AppMethodBeat.m2505o(78998);
    }

    public final void disable() {
        AppMethodBeat.m2504i(78999);
        super.disable();
        this.gfP = C9088a.NONE;
        AppMethodBeat.m2505o(78999);
    }

    public final void onOrientationChanged(int i) {
        AppMethodBeat.m2504i(79000);
        if (i == -1) {
            AppMethodBeat.m2505o(79000);
            return;
        }
        C9088a c9088a = this.gfP;
        if ((i >= 360 - this.gfQ && i < v2helper.VOIP_ENC_HEIGHT_LV1) || (i >= 0 && i <= this.gfQ + 0)) {
            c9088a = C9088a.PORTRAIT;
        } else if (i >= 270 - this.gfQ && i <= this.gfQ + 270) {
            c9088a = C9088a.LANDSCAPE;
        } else if (i >= 180 - this.gfQ && i <= this.gfQ + 180) {
            c9088a = C9088a.REVERSE_PORTRAIT;
        } else if (i >= 90 - this.gfQ && i <= this.gfQ + 90) {
            c9088a = C9088a.REVERSE_LANDSCAPE;
        }
        if (c9088a != this.gfP) {
            if (!(this.gfR == null || this.gfP == C9088a.NONE)) {
                this.gfR.mo20572a(this.gfP, c9088a);
            }
            this.gfP = c9088a;
        }
        C4990ab.m7416i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(79000);
    }
}
