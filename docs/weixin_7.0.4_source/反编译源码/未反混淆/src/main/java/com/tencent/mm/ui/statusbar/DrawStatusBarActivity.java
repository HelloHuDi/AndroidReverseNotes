package com.tencent.mm.ui.statusbar;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public abstract class DrawStatusBarActivity extends MMActivity {
    private b iFI = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.iFI = new b(this);
            this.iFI.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.iFI);
            getSwipeBackLayout().setContentView(this.iFI);
        }
    }
}
