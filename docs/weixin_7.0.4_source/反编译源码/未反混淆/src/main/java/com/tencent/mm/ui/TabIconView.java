package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.d;

public class TabIconView extends ImageView {
    private Paint aFY;
    private Paint bmE;
    private Context mContext;
    private float scale = 1.1666666f;
    private Bitmap yqC;
    private Bitmap yqD;
    private Bitmap yqE;
    private Rect yqF;
    private Rect yqG;
    private Rect yqH;
    private int yqI = 0;

    public TabIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public TabIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public final void h(int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(29922);
        if (z) {
            this.scale *= 1.25f;
        }
        this.yqC = d.o(i, this.scale);
        this.yqD = d.o(i3, this.scale);
        this.yqE = d.o(i2, this.scale);
        this.yqF = new Rect(0, 0, this.yqC.getWidth(), this.yqC.getHeight());
        this.yqG = new Rect(0, 0, this.yqD.getWidth(), this.yqD.getHeight());
        this.yqH = new Rect(0, 0, this.yqE.getWidth(), this.yqE.getHeight());
        this.aFY = new Paint(1);
        this.bmE = new Paint(1);
        this.bmE.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.color.h7), Mode.SRC_ATOP));
        this.aFY.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.color.a61), Mode.SRC_ATOP));
        AppMethodBeat.o(29922);
    }

    public void setFocusAlpha(int i) {
        AppMethodBeat.i(29923);
        this.yqI = i;
        invalidate();
        AppMethodBeat.o(29923);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(29924);
        super.onDraw(canvas);
        if (this.aFY == null) {
            AppMethodBeat.o(29924);
        } else if (this.yqI < 128) {
            this.aFY.setAlpha(255 - (this.yqI * 2));
            this.bmE.setAlpha(255 - (this.yqI * 2));
            canvas.drawBitmap(this.yqD, null, this.yqG, this.bmE);
            this.aFY.setAlpha(this.yqI * 2);
            canvas.drawBitmap(this.yqE, null, this.yqH, this.aFY);
            AppMethodBeat.o(29924);
        } else {
            this.aFY.setAlpha(255 - (this.yqI * 2));
            canvas.drawBitmap(this.yqE, null, this.yqH, this.aFY);
            this.aFY.setAlpha(this.yqI * 2);
            canvas.drawBitmap(this.yqC, null, this.yqF, this.aFY);
            AppMethodBeat.o(29924);
        }
    }
}
