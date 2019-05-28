package com.tencent.mm.plugin.music.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class c extends Drawable {
    private Paint aFY;
    private RectF kPM;
    private Drawable oPm;
    float oPn;
    private int oPo = a.am(ah.getContext(), R.dimen.g7);

    public c(Drawable drawable) {
        AppMethodBeat.i(105133);
        this.oPm = drawable;
        this.aFY = new Paint(1);
        this.aFY.setColor(ah.getResources().getColor(R.color.sx));
        AppMethodBeat.o(105133);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(105134);
        Drawable drawable = this.oPm;
        Rect bounds = drawable.getBounds();
        float f = ((float) (bounds.right - bounds.left)) * 0.5f;
        float f2 = ((float) (bounds.bottom - bounds.top)) * 0.5f;
        int save = canvas.save();
        canvas.rotate(this.oPn, f + ((float) bounds.left), ((float) bounds.top) + f2);
        canvas.drawOval(this.kPM, this.aFY);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
        AppMethodBeat.o(105134);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(105135);
        if (this.oPm != null) {
            this.oPm.setBounds(i, i2, i3, i4);
        }
        this.kPM = new RectF((float) i, (float) i2, (float) i3, (float) i4);
        AppMethodBeat.o(105135);
    }

    public final int getIntrinsicWidth() {
        return this.oPo;
    }

    public final int getIntrinsicHeight() {
        return this.oPo;
    }

    public final void setAlpha(int i) {
        AppMethodBeat.i(105136);
        if (this.oPm != null) {
            this.oPm.setAlpha(i);
        }
        this.aFY.setAlpha(i);
        AppMethodBeat.o(105136);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(105137);
        this.aFY.setColorFilter(colorFilter);
        AppMethodBeat.o(105137);
    }

    public final int getOpacity() {
        AppMethodBeat.i(105138);
        if (this.oPm != null) {
            int opacity = this.oPm.getOpacity();
            AppMethodBeat.o(105138);
            return opacity;
        }
        AppMethodBeat.o(105138);
        return -2;
    }
}
