package com.tencent.p177mm.p612ui.websearch;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.statusbar.C5540a;
import com.tencent.p177mm.p612ui.statusbar.C7355b;

/* renamed from: com.tencent.mm.ui.websearch.CustomStatusBarMMActivity */
public abstract class CustomStatusBarMMActivity extends MMActivity {
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
        C5540a.m8360d(this.mController.contentView, getStatusBarColor(), true);
    }

    public boolean initNavigationSwipeBack() {
        boolean initNavigationSwipeBack = super.initNavigationSwipeBack();
        if (!isSupportNavigationSwipeBack()) {
            C5540a.m8360d(this.mController.contentView, getStatusBarColor(), true);
        }
        return initNavigationSwipeBack;
    }

    /* Access modifiers changed, original: protected */
    public int getStatusBarColor() {
        return getResources().getColor(C25738R.color.a1f);
    }
}
