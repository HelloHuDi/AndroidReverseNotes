package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.sdk.platformtools.ab;

public class FaceDetectDecorView extends View {
    public boolean mau;
    public boolean mav;
    public boolean maw;
    public RectF may;
    private Paint maz;

    public FaceDetectDecorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectDecorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(c.CTRL_INDEX);
        this.mau = false;
        this.mav = false;
        this.maw = false;
        this.may = null;
        this.maz = null;
        this.maz = new Paint();
        this.maz.setColor(getResources().getColor(R.color.h4));
        this.maz.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        setLayerType(1, null);
        AppMethodBeat.o(c.CTRL_INDEX);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(bd.CTRL_INDEX);
        super.onDraw(canvas);
        ab.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", Boolean.valueOf(this.mav), Boolean.valueOf(this.mau), this.may);
        if (this.mav != this.mau || this.maw) {
            if (this.mav) {
                canvas.drawColor(getResources().getColor(R.color.nv));
                canvas.drawRect(this.may, this.maz);
            } else {
                canvas.drawColor(getResources().getColor(R.color.a3p));
            }
        }
        this.mau = this.mav;
        AppMethodBeat.o(bd.CTRL_INDEX);
    }
}
