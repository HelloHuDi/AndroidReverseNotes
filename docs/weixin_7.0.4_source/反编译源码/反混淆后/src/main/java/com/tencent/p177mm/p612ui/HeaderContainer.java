package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.HeaderContainer */
public class HeaderContainer extends FrameLayout {
    private Rect iWy = new Rect();
    private C36307i yis;
    private C44407y yit;

    public HeaderContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(29334);
        init(context);
        AppMethodBeat.m2505o(29334);
    }

    public HeaderContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(29335);
        init(context);
        AppMethodBeat.m2505o(29335);
    }

    public void setAnimController(C36307i c36307i) {
        AppMethodBeat.m2504i(29336);
        this.yis = c36307i;
        if (!(this.yit == null || this.yis == null)) {
            this.yis.mo57177a(this.yit);
        }
        AppMethodBeat.m2505o(29336);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(29337);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(29337);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(29338);
        this.yit = new C44407y(context);
        this.yit.setHeaderContainer(this);
        this.yit.setId(2131820646);
        addView(this.yit, new LayoutParams(-1, -2));
        AppMethodBeat.m2505o(29338);
    }

    public Rect getBackUpFooterRect() {
        return this.iWy;
    }

    public C44407y getHeaderView() {
        return this.yit;
    }
}
