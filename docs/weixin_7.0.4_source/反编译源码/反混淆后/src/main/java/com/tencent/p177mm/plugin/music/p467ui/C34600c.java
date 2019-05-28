package com.tencent.p177mm.plugin.music.p467ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.music.ui.c */
public final class C34600c extends Drawable {
    private Paint aFY;
    private RectF kPM;
    private Drawable oPm;
    float oPn;
    private int oPo = C1338a.m2857am(C4996ah.getContext(), C25738R.dimen.f9804g7);

    public C34600c(Drawable drawable) {
        AppMethodBeat.m2504i(105133);
        this.oPm = drawable;
        this.aFY = new Paint(1);
        this.aFY.setColor(C4996ah.getResources().getColor(C25738R.color.f12115sx));
        AppMethodBeat.m2505o(105133);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(105134);
        Drawable drawable = this.oPm;
        Rect bounds = drawable.getBounds();
        float f = ((float) (bounds.right - bounds.left)) * 0.5f;
        float f2 = ((float) (bounds.bottom - bounds.top)) * 0.5f;
        int save = canvas.save();
        canvas.rotate(this.oPn, f + ((float) bounds.left), ((float) bounds.top) + f2);
        canvas.drawOval(this.kPM, this.aFY);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
        AppMethodBeat.m2505o(105134);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(105135);
        if (this.oPm != null) {
            this.oPm.setBounds(i, i2, i3, i4);
        }
        this.kPM = new RectF((float) i, (float) i2, (float) i3, (float) i4);
        AppMethodBeat.m2505o(105135);
    }

    public final int getIntrinsicWidth() {
        return this.oPo;
    }

    public final int getIntrinsicHeight() {
        return this.oPo;
    }

    public final void setAlpha(int i) {
        AppMethodBeat.m2504i(105136);
        if (this.oPm != null) {
            this.oPm.setAlpha(i);
        }
        this.aFY.setAlpha(i);
        AppMethodBeat.m2505o(105136);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.m2504i(105137);
        this.aFY.setColorFilter(colorFilter);
        AppMethodBeat.m2505o(105137);
    }

    public final int getOpacity() {
        AppMethodBeat.m2504i(105138);
        if (this.oPm != null) {
            int opacity = this.oPm.getOpacity();
            AppMethodBeat.m2505o(105138);
            return opacity;
        }
        AppMethodBeat.m2505o(105138);
        return -2;
    }
}
