package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class HeaderContainer extends FrameLayout {
    private Rect iWy = new Rect();
    private i yis;
    private y yit;

    public HeaderContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29334);
        init(context);
        AppMethodBeat.o(29334);
    }

    public HeaderContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(29335);
        init(context);
        AppMethodBeat.o(29335);
    }

    public void setAnimController(i iVar) {
        AppMethodBeat.i(29336);
        this.yis = iVar;
        if (!(this.yit == null || this.yis == null)) {
            this.yis.a(this.yit);
        }
        AppMethodBeat.o(29336);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(29337);
        super.onMeasure(i, i2);
        AppMethodBeat.o(29337);
    }

    private void init(Context context) {
        AppMethodBeat.i(29338);
        this.yit = new y(context);
        this.yit.setHeaderContainer(this);
        this.yit.setId(R.id.c2);
        addView(this.yit, new LayoutParams(-1, -2));
        AppMethodBeat.o(29338);
    }

    public Rect getBackUpFooterRect() {
        return this.iWy;
    }

    public y getHeaderView() {
        return this.yit;
    }
}
