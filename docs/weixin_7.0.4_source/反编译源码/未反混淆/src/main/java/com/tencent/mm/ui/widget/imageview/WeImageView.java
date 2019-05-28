package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.a.a;

public class WeImageView extends AppCompatImageView {
    private int yDb;
    private boolean zQS = true;

    public WeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112705);
        init(context, attributeSet);
        AppMethodBeat.o(112705);
    }

    public WeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112706);
        init(context, attributeSet);
        AppMethodBeat.o(112706);
    }

    public void setIconColor(int i) {
        AppMethodBeat.i(112707);
        this.yDb = i;
        this.zQS = true;
        invalidate();
        AppMethodBeat.o(112707);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(112708);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.WeImageView);
        this.yDb = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(112708);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(112709);
        super.onDraw(canvas);
        if (getDrawable() != null && this.zQS) {
            getDrawable().setColorFilter(new PorterDuffColorFilter(this.yDb, Mode.SRC_ATOP));
            this.zQS = false;
        }
        AppMethodBeat.o(112709);
    }
}
