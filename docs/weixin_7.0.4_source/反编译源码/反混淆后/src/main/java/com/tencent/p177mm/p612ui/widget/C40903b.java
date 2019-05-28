package com.tencent.p177mm.p612ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.widget.b */
public final class C40903b {
    private Rect eAp = new Rect();
    private int maxHeight;
    private int sjj;
    private View view;
    private C36360a zLV;
    private boolean zLW = false;
    private int zLX;
    private int zLY;
    private int zLZ;
    Runnable zMa;
    Runnable zMb;

    /* renamed from: com.tencent.mm.ui.widget.b$1 */
    class C159961 implements Runnable {
        C159961() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107851);
            if (C40903b.this.zMa != null) {
                C4990ab.m7420w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
                C40903b.this.zMa.run();
                C40903b.this.zMa = null;
            }
            AppMethodBeat.m2505o(107851);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.b$2 */
    class C159972 implements Runnable {
        C159972() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107852);
            if (C40903b.this.zMb != null) {
                C4990ab.m7420w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
                C40903b.this.zMb.run();
                C40903b.this.zMb = null;
            }
            AppMethodBeat.m2505o(107852);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.b$a */
    public interface C36360a {
        /* renamed from: m */
        void mo39878m(boolean z, int i);
    }

    public C40903b(View view, C36360a c36360a) {
        AppMethodBeat.m2504i(107853);
        this.view = view;
        this.zLV = c36360a;
        this.zLZ = C5222ae.m7944fr(view.getContext());
        this.sjj = C40619x.m70071gq(view.getContext());
        AppMethodBeat.m2505o(107853);
    }

    /* renamed from: PR */
    public final void mo64516PR(int i) {
        AppMethodBeat.m2504i(107854);
        if (!dKz() || isInMultiWindowMode()) {
            C4990ab.m7416i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
            AppMethodBeat.m2505o(107854);
            return;
        }
        boolean z;
        int i2 = this.zLX;
        int height = this.eAp.height();
        this.zLX = MeasureSpec.getSize(i);
        this.view.getWindowVisibleDisplayFrame(this.eAp);
        if (!this.zLW) {
            this.zLW = height != this.eAp.bottom;
        }
        this.zLY = this.eAp.bottom;
        if (this.zLY > this.maxHeight - this.zLZ) {
            this.maxHeight = this.zLY;
        }
        height = this.maxHeight - this.zLY;
        if (height > this.zLZ) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.sjj = height;
        }
        if (height == this.zLZ) {
            this.zLV.mo39878m(false, this.sjj - height);
        } else {
            this.zLV.mo39878m(height > this.zLZ, this.sjj);
        }
        if ((this.zLW && i2 > this.zLX + this.zLZ) || i2 < this.zLX - this.zLZ) {
            C4990ab.m7417i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", Boolean.valueOf(z));
            this.zLW = false;
            if (z) {
                if (this.zMa != null) {
                    this.zMa.run();
                    this.zMa = null;
                    AppMethodBeat.m2505o(107854);
                    return;
                }
            } else if (this.zMb != null) {
                this.zMb.run();
                this.zMb = null;
            }
        }
        AppMethodBeat.m2505o(107854);
    }

    /* renamed from: az */
    public final void mo64518az(Runnable runnable) {
        AppMethodBeat.m2504i(107855);
        this.zMa = runnable;
        this.zMb = null;
        this.view.postDelayed(new C159961(), 200);
        AppMethodBeat.m2505o(107855);
    }

    /* renamed from: aA */
    public final void mo64517aA(Runnable runnable) {
        AppMethodBeat.m2504i(107856);
        this.zMb = runnable;
        this.zMa = null;
        this.view.postDelayed(new C159972(), 200);
        AppMethodBeat.m2505o(107856);
    }

    private boolean dKz() {
        AppMethodBeat.m2504i(107857);
        boolean gu = C40619x.m70075gu(this.view.getContext());
        AppMethodBeat.m2505o(107857);
        return gu;
    }

    private boolean isInMultiWindowMode() {
        AppMethodBeat.m2504i(107858);
        if (C1443d.m3068iW(24) && (this.view.getContext() instanceof Activity)) {
            boolean isInMultiWindowMode = ((Activity) this.view.getContext()).isInMultiWindowMode();
            AppMethodBeat.m2505o(107858);
            return isInMultiWindowMode;
        }
        AppMethodBeat.m2505o(107858);
        return false;
    }
}
