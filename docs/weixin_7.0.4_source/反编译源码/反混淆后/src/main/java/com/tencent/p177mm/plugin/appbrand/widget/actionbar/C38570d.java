package com.tencent.p177mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.statusbar.C7355b;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.d */
public final class C38570d extends C7355b {
    private int iUG = 0;
    private boolean iUU = false;
    private int iUV;
    private boolean iUW = false;
    private Integer iUX = null;
    private boolean irI = true;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.d$a */
    final class C10939a extends ColorDrawable {
        C10939a() {
            super(0);
        }

        public final void setColor(int i) {
            AppMethodBeat.m2504i(87484);
            super.setColor(i);
            aOP();
            AppMethodBeat.m2505o(87484);
        }

        public final void setAlpha(int i) {
            AppMethodBeat.m2504i(87485);
            super.setAlpha(i);
            aOP();
            AppMethodBeat.m2505o(87485);
        }

        private void aOP() {
            AppMethodBeat.m2504i(87486);
            C38570d.this.setStatusBarColor(getColor());
            AppMethodBeat.m2505o(87486);
        }
    }

    public C38570d(Context context) {
        super(context);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.m2504i(87487);
        super.onViewAdded(view);
        if (view instanceof C10933b) {
            view.setBackground(new C10939a());
            AppMethodBeat.m2505o(87487);
            return;
        }
        IllegalAccessError illegalAccessError = new IllegalAccessError("Cant add non ActionBar instance here");
        AppMethodBeat.m2505o(87487);
        throw illegalAccessError;
    }

    private C10933b getActionBar() {
        AppMethodBeat.m2504i(87488);
        if (getChildCount() <= 0) {
            AppMethodBeat.m2505o(87488);
            return null;
        }
        C10933b c10933b = (C10933b) getChildAt(0);
        AppMethodBeat.m2505o(87488);
        return c10933b;
    }

    public final boolean hasOverlappingRendering() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean canAnimate() {
        return false;
    }

    public final void setStatusBarForegroundStyle(boolean z) {
        AppMethodBeat.m2504i(87489);
        if (getActionBar() == null) {
            AppMethodBeat.m2505o(87489);
            return;
        }
        mo15851K(getActionBar().getBackgroundColor(), z);
        AppMethodBeat.m2505o(87489);
    }

    public final void setStatusBarColor(int i) {
        AppMethodBeat.m2504i(87490);
        mo15851K(i, this.iUU);
        AppMethodBeat.m2505o(87490);
    }

    /* renamed from: K */
    public final void mo15851K(int i, boolean z) {
        AppMethodBeat.m2504i(87491);
        this.iUG = i;
        this.iUU = z;
        if (this.irI) {
            super.mo15852a(i, z, true);
            AppMethodBeat.m2505o(87491);
            return;
        }
        if (!this.iUW) {
            super.mo15852a(i, z, false);
        }
        AppMethodBeat.m2505o(87491);
    }

    public final void aOO() {
        AppMethodBeat.m2504i(87492);
        mo15851K(this.iUG, this.iUU);
        AppMethodBeat.m2505o(87492);
    }

    public final void setActuallyVisible(boolean z) {
        AppMethodBeat.m2504i(87493);
        boolean z2 = z != this.irI;
        this.irI = z;
        if (z2 && z) {
            aOO();
            setDeferStatusBarHeightChange(false);
            setWillNotDraw(false);
        }
        if (z2 && !z) {
            setDeferStatusBarHeightChange(true);
        }
        AppMethodBeat.m2505o(87493);
    }

    public final void setDeferStatusBarHeightChange(boolean z) {
        AppMethodBeat.m2504i(87494);
        Object obj = z != this.iUW ? 1 : null;
        this.iUW = z;
        if (!(obj == null || z)) {
            super.mo11252pO(this.iUV);
        }
        AppMethodBeat.m2505o(87494);
    }

    /* renamed from: pO */
    public final void mo11252pO(int i) {
        AppMethodBeat.m2504i(87495);
        if (this.iUX != null) {
            int intValue = this.iUX.intValue();
            this.iUV = intValue;
            super.mo11252pO(intValue);
            AppMethodBeat.m2505o(87495);
            return;
        }
        this.iUV = i;
        if (this.iUW) {
            AppMethodBeat.m2505o(87495);
            return;
        }
        super.mo11252pO(i);
        AppMethodBeat.m2505o(87495);
    }

    public final void setForceTopInsetsHeight(int i) {
        AppMethodBeat.m2504i(87496);
        this.iUX = Integer.valueOf(i);
        AppMethodBeat.m2505o(87496);
    }
}
