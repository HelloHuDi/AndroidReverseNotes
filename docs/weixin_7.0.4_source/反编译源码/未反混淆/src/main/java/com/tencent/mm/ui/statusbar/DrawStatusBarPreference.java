package com.tencent.mm.ui.statusbar;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class DrawStatusBarPreference extends MMPreference {
    private b iFI = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void initSwipeBack() {
        AppMethodBeat.i(107548);
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.iFI = new b(this);
            this.iFI.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.iFI);
            getSwipeBackLayout().setContentView(this.iFI);
        }
        AppMethodBeat.o(107548);
    }

    public int JC() {
        return 0;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }
}
