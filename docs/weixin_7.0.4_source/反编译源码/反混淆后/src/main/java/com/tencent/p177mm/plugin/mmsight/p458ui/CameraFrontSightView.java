package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView */
public class CameraFrontSightView extends View {
    private int bRV;
    public int mHeight;
    private Paint mPaint = new Paint();
    public int mWidth;
    private long oAA = 0;
    private int oAB;
    private int oAC;
    private LayoutParams oAD;
    private boolean oAw = false;
    private boolean oAx = false;
    private boolean oAy = false;
    private boolean oAz = false;

    public CameraFrontSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(55067);
        AppMethodBeat.m2505o(55067);
    }

    public CameraFrontSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(55068);
        AppMethodBeat.m2505o(55068);
    }

    /* renamed from: ez */
    public final void mo36728ez(int i, int i2) {
        AppMethodBeat.m2504i(55069);
        this.oAD = getLayoutParams();
        if (this.oAD != null) {
            this.oAD.width = i;
            this.oAD.height = i2;
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.oAB = this.mWidth / 2;
        this.oAC = this.mHeight / 2;
        this.bRV = C1338a.fromDPToPix(getContext(), 1);
        this.mPaint.setColor(-12206054);
        this.mPaint.setStrokeWidth((float) this.bRV);
        AppMethodBeat.m2505o(55069);
    }

    public final void bQr() {
        AppMethodBeat.m2504i(55070);
        setVisibility(0);
        this.oAw = true;
        this.oAx = false;
        this.oAy = false;
        this.oAz = false;
        this.oAA = System.currentTimeMillis();
        invalidate();
        AppMethodBeat.m2505o(55070);
    }

    /* renamed from: X */
    public final void mo36725X(float f, float f2) {
        AppMethodBeat.m2504i(55071);
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ((int) f) - (this.mWidth / 2);
            marginLayoutParams.topMargin = ((int) f2) - (this.mHeight / 2);
            setLayoutParams(marginLayoutParams);
            bQr();
            AppMethodBeat.m2505o(55071);
            return;
        }
        Log.m81046e("MicroMsg.CameraFrontSightView", "LayoutParams is not MarginLayoutParams! use doAimation()");
        AppMethodBeat.m2505o(55071);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.m2504i(55072);
        canvas.translate((float) (this.oAB / 2), (float) (this.oAC / 2));
        long currentTimeMillis = System.currentTimeMillis() - this.oAA;
        if (currentTimeMillis > 200) {
            this.oAw = false;
            this.oAx = true;
        }
        if (currentTimeMillis > 800) {
            this.oAx = false;
            this.oAy = true;
        }
        if (currentTimeMillis > 1100) {
            this.oAy = false;
            this.oAz = true;
        }
        if (currentTimeMillis > 1300) {
            this.oAz = false;
            setVisibility(8);
            AppMethodBeat.m2505o(55072);
            return;
        }
        float f;
        if (this.oAw) {
            f = (((float) (200 - currentTimeMillis)) / 200.0f) + 1.0f;
            canvas.scale(f, f, (float) (this.oAB / 2), (float) (this.oAC / 2));
            this.mPaint.setAlpha((int) ((2.0f - f) * 255.0f));
        } else {
            canvas.scale(1.0f, 1.0f);
        }
        if (this.oAx) {
            f = (((float) ((currentTimeMillis - 200) % 200)) / 200.0f) * 2.0f;
            this.mPaint.setAlpha((int) (((f > 1.0f ? f - 1.0f : 1.0f - f) * 128.0f) + 127.0f));
        } else {
            this.mPaint.setAlpha(255);
        }
        if (this.oAz) {
            this.mPaint.setAlpha((int) ((1.0f - (((float) (currentTimeMillis - 1100)) / 200.0f)) * 255.0f));
        }
        canvas.drawLine(0.0f, 0.0f, (float) this.oAB, 0.0f, this.mPaint);
        canvas.drawLine(0.0f, 0.0f, 0.0f, (float) this.oAC, this.mPaint);
        canvas.drawLine((float) this.oAB, 0.0f, (float) this.oAB, (float) this.oAC, this.mPaint);
        canvas.drawLine(0.0f, (float) this.oAC, (float) this.oAB, (float) this.oAC, this.mPaint);
        canvas.drawLine(0.0f, (float) (this.oAC / 2), (float) (this.oAB / 10), (float) (this.oAC / 2), this.mPaint);
        canvas.drawLine((float) this.oAB, (float) (this.oAC / 2), (float) ((this.oAB * 9) / 10), (float) (this.oAC / 2), this.mPaint);
        canvas.drawLine((float) (this.oAB / 2), 0.0f, (float) (this.oAB / 2), (float) (this.oAC / 10), this.mPaint);
        canvas.drawLine((float) (this.oAB / 2), (float) this.oAC, (float) (this.oAB / 2), (float) ((this.oAC * 9) / 10), this.mPaint);
        invalidate();
        AppMethodBeat.m2505o(55072);
    }
}
