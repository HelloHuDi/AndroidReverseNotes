package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.b.a;

public class BorderNumView extends View {
    private static int yfA = 100;
    private static int yfy = 22;
    private static int yfz = 105;
    private Context context = null;
    private Paint mPaint;
    private int yfx = 100;

    public BorderNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29137);
        this.context = context;
        init();
        AppMethodBeat.o(29137);
    }

    public BorderNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(29138);
        this.context = context;
        init();
        AppMethodBeat.o(29138);
    }

    private void init() {
        AppMethodBeat.i(29139);
        this.mPaint = new Paint();
        AppMethodBeat.o(29139);
    }

    public void setPaintNum(int i) {
        this.yfx = i;
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(29140);
        super.onDraw(canvas);
        if (this.yfx < 100) {
            yfy += 15;
        }
        if (this.yfx >= 1000) {
            yfA -= 20;
        }
        float b = (float) a.b(this.context, (float) yfy);
        float b2 = (float) a.b(this.context, (float) yfz);
        String str = this.yfx;
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize((float) yfA);
        this.mPaint.setColor(-11491572);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeWidth(8.0f);
        canvas.drawText(str, b, b2, this.mPaint);
        this.mPaint.setTextSize((float) yfA);
        this.mPaint.setColor(-1770573);
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setStrokeWidth(8.0f);
        canvas.drawText(str, b, b2, this.mPaint);
        AppMethodBeat.o(29140);
    }
}
