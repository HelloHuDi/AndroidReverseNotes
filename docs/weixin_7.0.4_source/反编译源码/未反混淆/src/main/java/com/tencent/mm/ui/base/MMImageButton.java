package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;

public class MMImageButton extends FrameLayout {
    private ImageView cDh;
    private TextView piD;

    public MMImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106676);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.cDh = new ImageView(context);
        this.cDh.setLayoutParams(layoutParams);
        addView(this.cDh);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.piD = new TextView(context);
        this.piD.setLayoutParams(layoutParams);
        this.piD.setClickable(false);
        this.piD.setFocusable(false);
        this.piD.setFocusableInTouchMode(false);
        this.piD.setTextColor(a.h(context, (int) R.color.a83));
        addView(this.piD);
        AppMethodBeat.o(106676);
    }

    public void setImageRsource(int i) {
        AppMethodBeat.i(106677);
        setImageDrawable(a.g(getContext(), i));
        AppMethodBeat.o(106677);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(106678);
        this.cDh.setImageDrawable(drawable);
        this.cDh.setVisibility(0);
        this.piD.setVisibility(8);
        AppMethodBeat.o(106678);
    }

    public void setText(String str) {
        AppMethodBeat.i(106679);
        this.piD.setText(str);
        this.piD.setVisibility(0);
        this.cDh.setVisibility(8);
        AppMethodBeat.o(106679);
    }

    public void setText(int i) {
        AppMethodBeat.i(106680);
        this.piD.setText(i);
        this.piD.setVisibility(0);
        this.cDh.setVisibility(8);
        AppMethodBeat.o(106680);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(106681);
        super.setEnabled(z);
        this.piD.setEnabled(z);
        this.cDh.setEnabled(z);
        AppMethodBeat.o(106681);
    }
}
