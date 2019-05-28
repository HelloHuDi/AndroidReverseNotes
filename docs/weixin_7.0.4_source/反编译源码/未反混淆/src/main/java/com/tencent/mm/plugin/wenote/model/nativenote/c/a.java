package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends View {
    private int eno;
    private Paint mPaint;
    private int mType = 2;
    private int shT;
    private int tWp;
    private RectF uQN;
    private RectF uQO;
    private RectF uQP;
    private RectF uQQ;
    private int uQR;
    private int uQS;
    private a uQT;

    public interface a {
        void a(int i, MotionEvent motionEvent);
    }

    public a(Context context, int i, int i2, int i3, int i4, a aVar) {
        super(context);
        AppMethodBeat.i(26851);
        this.mType = i;
        this.uQS = i2;
        this.tWp = i3;
        this.uQR = (this.uQS * 2) / 5;
        this.eno = this.uQR;
        this.shT = (this.uQR * 3) / 4;
        this.mPaint = new Paint(1);
        this.mPaint.setColor(i4);
        this.uQT = aVar;
        this.uQN = new RectF((float) this.eno, (float) this.uQS, (float) (this.eno + (this.uQR * 2)), (float) (this.uQS + (this.uQR * 2)));
        this.uQO = new RectF((float) (this.shT - this.uQR), (float) this.uQS, (float) (this.shT + this.uQR), (float) (this.uQS + (this.uQR * 2)));
        this.uQP = new RectF((float) this.eno, (float) this.uQS, (float) (this.eno + (this.uQR * 2)), (float) (this.uQS + (this.uQR * 2)));
        this.uQQ = new RectF((float) (this.eno + this.tWp), (float) this.uQS, (float) ((this.eno + this.tWp) + (this.uQR * 2)), (float) (this.uQS + (this.uQR * 2)));
        AppMethodBeat.o(26851);
    }

    public final int getType() {
        return this.mType;
    }

    public final int getViewHeight() {
        return (this.uQS + (this.uQR * 2)) + this.eno;
    }

    public final int getViewWidth() {
        if (this.mType == 3 || this.mType == 4) {
            return (this.eno + this.uQR) + this.shT;
        }
        return this.tWp + ((this.eno + this.uQR) * 2);
    }

    public final int getOffsetForCursorMid() {
        return (this.eno + this.uQR) + 1;
    }

    public final int getViewPadding() {
        return this.eno;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(26852);
        switch (this.mType) {
            case 2:
                canvas.drawRect((float) (this.eno + this.uQR), 0.0f, (float) ((this.eno + this.uQR) + this.tWp), (float) (this.uQS + (this.uQR * 2)), this.mPaint);
                canvas.drawArc(this.uQP, 90.0f, 180.0f, true, this.mPaint);
                canvas.drawArc(this.uQQ, 270.0f, 180.0f, true, this.mPaint);
                AppMethodBeat.o(26852);
                return;
            case 3:
                canvas.drawRect((float) (((this.eno + this.uQR) + this.shT) - this.tWp), 0.0f, (float) ((this.eno + this.uQR) + this.shT), (float) this.uQS, this.mPaint);
                canvas.drawArc(this.uQN, 90.0f, 180.0f, true, this.mPaint);
                canvas.drawRect((float) (this.eno + this.uQR), (float) this.uQS, (float) ((this.eno + this.uQR) + this.shT), (float) (this.uQS + (this.uQR * 2)), this.mPaint);
                AppMethodBeat.o(26852);
                return;
            case 4:
                canvas.drawRect(0.0f, 0.0f, (float) this.tWp, (float) this.uQS, this.mPaint);
                canvas.drawRect(0.0f, (float) this.uQS, (float) this.shT, (float) (this.uQS + (this.uQR * 2)), this.mPaint);
                canvas.drawArc(this.uQO, 270.0f, 180.0f, true, this.mPaint);
                break;
        }
        AppMethodBeat.o(26852);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(26853);
        if (this.uQT != null) {
            this.uQT.a(this.mType, motionEvent);
        }
        AppMethodBeat.o(26853);
        return true;
    }
}
