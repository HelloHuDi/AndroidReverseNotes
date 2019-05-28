package com.tencent.p177mm.plugin.appbrand.widget.p1235e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.e.a */
public final class C42723a extends Drawable {
    private Paint aFY = new Paint(1);
    private Paint borderPaint;
    float borderRadius = 0.0f;
    private int borderWidth = 0;
    private Path jjV;
    private Path jjW;
    private int jjX = C1338a.fromDPToPix(C4996ah.getContext(), 3);
    private int jjY = this.jjX;
    private final RectF rect = new RectF();

    public C42723a() {
        AppMethodBeat.m2504i(51244);
        this.aFY.setStyle(Style.FILL);
        this.borderPaint = new Paint(1);
        this.borderPaint.setStyle(Style.FILL);
        this.jjV = new Path();
        this.jjW = new Path();
        AppMethodBeat.m2505o(51244);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(51245);
        float width = this.rect.width();
        float height = this.rect.height();
        float f = this.rect.left;
        float f2 = this.rect.top;
        float f3 = this.rect.right;
        float f4 = this.rect.bottom;
        width = Math.min(this.borderRadius, Math.min(width, height) * 0.5f);
        canvas.drawRoundRect(new RectF(((float) this.jjY) + f, ((float) this.jjY) + f2, f3 - ((float) this.jjY), f4 - ((float) this.jjY)), width, width, this.borderPaint);
        canvas.drawPath(this.jjW, this.borderPaint);
        canvas.drawRoundRect(new RectF((f + ((float) this.jjY)) + ((float) this.borderWidth), (f2 + ((float) this.jjY)) + ((float) this.borderWidth), (f3 - ((float) this.jjY)) - ((float) this.borderWidth), (f4 - ((float) this.jjY)) - ((float) this.borderWidth)), width, width, this.aFY);
        canvas.drawPath(this.jjV, this.aFY);
        AppMethodBeat.m2505o(51245);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(51246);
        super.setBounds(i, i2, i3, i4);
        this.rect.set((float) i, (float) i2, (float) i3, (float) i4);
        float f = ((float) (i + i3)) / 2.0f;
        this.jjW.moveTo(f, (float) i4);
        this.jjW.lineTo(f - ((float) this.jjY), (float) (i4 - this.jjY));
        this.jjW.lineTo(((float) this.jjY) + f, (float) (i4 - this.jjY));
        this.jjW.close();
        this.jjV.moveTo(f, (float) (i4 - this.borderWidth));
        this.jjV.lineTo(f - ((float) this.jjY), (float) ((i4 - this.jjY) - this.borderWidth));
        this.jjV.lineTo(f + ((float) this.jjY), (float) ((i4 - this.jjY) - this.borderWidth));
        this.jjV.close();
        AppMethodBeat.m2505o(51246);
    }

    public final void setAlpha(int i) {
        AppMethodBeat.m2504i(51247);
        this.aFY.setAlpha(i);
        this.borderPaint.setAlpha(i);
        AppMethodBeat.m2505o(51247);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.m2504i(51248);
        this.aFY.setColorFilter(colorFilter);
        this.borderPaint.setColorFilter(colorFilter);
        AppMethodBeat.m2505o(51248);
    }

    public final void setColor(int i) {
        AppMethodBeat.m2504i(51249);
        this.aFY.setColor(i);
        AppMethodBeat.m2505o(51249);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setStroke(int i, int i2) {
        AppMethodBeat.m2504i(51250);
        this.borderWidth = i;
        this.jjY = (i / 3) + this.jjX;
        this.borderPaint.setColor(i2);
        AppMethodBeat.m2505o(51250);
    }
}
