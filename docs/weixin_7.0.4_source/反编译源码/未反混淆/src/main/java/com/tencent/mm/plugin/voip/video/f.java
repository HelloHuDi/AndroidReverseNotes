package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends View {
    private Matrix mMatrix;
    private Paint mPaint = new Paint();
    private int mRotateAngle;
    public int np;
    public int sZY;
    public int sZZ;
    public int taa;
    private int tab;
    private int tac;
    private int tad;
    private int tae;
    private RectF taf;
    private boolean tah;

    public f(Context context) {
        super(context);
        AppMethodBeat.i(5061);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setColor(-65536);
        this.mPaint.setStrokeWidth((float) a.fromDPToPix(getContext(), 3));
        this.mMatrix = new Matrix();
        AppMethodBeat.o(5061);
    }

    public final void setFaceLocation(int[] iArr) {
        AppMethodBeat.i(5062);
        if (iArr != null) {
            this.tab = iArr[0];
            this.tac = iArr[1];
            this.tad = iArr[2];
            this.tae = iArr[3];
            if (!(this.sZZ == 0 || this.taa == 0 || this.np == 0 || this.sZY == 0)) {
                int i;
                int i2;
                float f;
                float f2;
                int i3 = this.tad - this.tab;
                int i4 = this.tae - this.tac;
                ab.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", Integer.valueOf(this.tab), Integer.valueOf(this.tac), Integer.valueOf(this.tad), Integer.valueOf(this.tad));
                ab.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", Integer.valueOf(this.sZZ), Integer.valueOf(this.taa), Boolean.valueOf(this.tah), Integer.valueOf(this.mRotateAngle));
                int i5 = (this.tad + this.tab) / 2;
                int i6 = (this.tae + this.tac) / 2;
                if (this.mRotateAngle == 90 || this.mRotateAngle == 270) {
                    i = i5;
                    i2 = i6;
                } else {
                    i = i6;
                    i2 = i5;
                }
                ab.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", Integer.valueOf(i2), Integer.valueOf(i));
                if (this.mRotateAngle == 90 || this.mRotateAngle == 270) {
                    f = (float) (this.np / this.sZZ);
                    f2 = (float) (this.sZY / this.taa);
                } else {
                    f = (float) (this.sZY / this.sZZ);
                    f2 = (float) (this.np / this.taa);
                }
                f2 = Math.max(f, f2);
                f = (float) ((int) (((float) i3) * f2));
                float f3 = (float) ((int) (((float) i4) * f2));
                i2 = (int) (((float) i2) * f2);
                i = (int) (((float) i) * f2);
                this.tab = dW((int) (((float) i2) - (f / 2.0f)), this.sZY);
                this.tac = dW((int) (((float) i) - (f3 / 2.0f)), this.np);
                this.tad = dW((int) (((float) i2) + (f / 2.0f)), this.sZY);
                this.tae = dW((int) (((float) i) + (f3 / 2.0f)), this.np);
                this.taf = new RectF((float) this.tab, (float) this.tac, (float) this.tad, (float) this.tae);
                ab.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", Float.valueOf(this.taf.left), Float.valueOf(this.taf.top), Float.valueOf(this.taf.right), Float.valueOf(this.taf.bottom));
            }
        }
        AppMethodBeat.o(5062);
    }

    private static int dW(int i, int i2) {
        int i3;
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        return i3 > i2 ? i2 : i3;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(5063);
        if (this.taf != null) {
            canvas.save();
            canvas.rotate(0.0f);
            canvas.drawRect(this.taf, this.mPaint);
            canvas.restore();
        }
        AppMethodBeat.o(5063);
    }

    public final void setMirror(boolean z) {
        this.tah = z;
    }

    public final void setRotateAngle(int i) {
        this.mRotateAngle = i;
    }
}
