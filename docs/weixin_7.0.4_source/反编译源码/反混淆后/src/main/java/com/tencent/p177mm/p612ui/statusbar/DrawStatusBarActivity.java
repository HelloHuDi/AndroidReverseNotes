package com.tencent.p177mm.p612ui.statusbar;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.ui.statusbar.DrawStatusBarActivity */
public abstract class DrawStatusBarActivity extends MMActivity {
    private C7355b iFI = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.iFI = new C7355b(this);
            this.iFI.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.iFI);
            getSwipeBackLayout().setContentView(this.iFI);
        }
    }
}
