package com.tencent.p177mm.p612ui.statusbar;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.ui.statusbar.DrawStatusBarPreference */
public class DrawStatusBarPreference extends MMPreference {
    private C7355b iFI = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void initSwipeBack() {
        AppMethodBeat.m2504i(107548);
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.iFI = new C7355b(this);
            this.iFI.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.iFI);
            getSwipeBackLayout().setContentView(this.iFI);
        }
        AppMethodBeat.m2505o(107548);
    }

    /* renamed from: JC */
    public int mo8452JC() {
        return 0;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        return false;
    }
}
