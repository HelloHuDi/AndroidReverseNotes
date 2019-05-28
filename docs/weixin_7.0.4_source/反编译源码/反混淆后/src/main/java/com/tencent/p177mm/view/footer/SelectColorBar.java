package com.tencent.p177mm.view.footer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.view.footer.SelectColorBar */
public class SelectColorBar extends View {
    public static final int[] AcD = new int[]{-1, WebView.NIGHT_MODE_COLOR, -707825, -17592, -16535286, -15172610, -7054596, -449092};
    private Paint Aat = new Paint(1);
    private boolean AcG = true;
    private final float Acn = getResources().getDimension(C25738R.dimen.a23);
    private Rect[] Acz;
    private C36375a Ade;
    private int Adf = -1;
    private Paint eHe;

    /* renamed from: com.tencent.mm.view.footer.SelectColorBar$a */
    public interface C36375a {
        /* renamed from: Qy */
        void mo28443Qy(int i);
    }

    public SelectColorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(116439);
        this.Aat.setColor(-16711936);
        this.Acz = new Rect[AcD.length];
        this.eHe = new Paint(1);
        this.eHe.setStyle(Style.FILL);
        this.eHe.setStrokeCap(Cap.ROUND);
        AppMethodBeat.m2505o(116439);
    }

    public void setSelectColorListener(C36375a c36375a) {
        this.Ade = c36375a;
    }

    public void setSelectColor(int i) {
        AppMethodBeat.m2504i(116440);
        for (int i2 = 0; i2 < AcD.length; i2++) {
            if (AcD[i2] == i) {
                this.Adf = i2;
                break;
            }
        }
        this.AcG = false;
        postInvalidate();
        AppMethodBeat.m2505o(116440);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(116441);
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec((int) getResources().getDimension(C25738R.dimen.f10304xe), ErrorDialogData.SUPPRESSED));
        if (this.Acz == null) {
            this.Acz = new Rect[AcD.length];
        }
        float dimension = getResources().getDimension(C25738R.dimen.f10371zf);
        float measuredWidth = (((float) (getMeasuredWidth() - getPaddingLeftAndRight())) - ((2.0f * dimension) * ((float) AcD.length))) / ((float) (AcD.length - 1));
        int i3 = (int) (2.0f * dimension);
        int paddingLeftAndRight = (int) ((((float) (getPaddingLeftAndRight() / 2)) + dimension) + 5.0f);
        int detailHeight = getDetailHeight() / 2;
        for (size = 0; size < AcD.length; size++) {
            this.Acz[size] = new Rect(paddingLeftAndRight - i3, detailHeight - i3, paddingLeftAndRight + i3, detailHeight + i3);
            paddingLeftAndRight = (int) (((float) paddingLeftAndRight) + ((2.0f * dimension) + measuredWidth));
        }
        AppMethodBeat.m2505o(116441);
    }

    /* JADX WARNING: Missing block: B:22:0x0057, code skipped:
            requestLayout();
            postInvalidate();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.m2504i(116442);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                while (i < this.Acz.length) {
                    if (this.Acz[i].contains(x, y)) {
                        this.Adf = i;
                        break;
                    }
                    i++;
                }
                break;
            case 1:
            case 3:
                while (this.Acz != null && i < this.Acz.length) {
                    if (this.Acz[i].contains(x, y) && i == this.Adf && this.Ade != null) {
                        this.Ade.mo28443Qy(AcD[i]);
                        break;
                    }
                    i++;
                }
                break;
        }
        AppMethodBeat.m2505o(116442);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116443);
        super.onDraw(canvas);
        canvas.drawColor(0);
        float dimension = getResources().getDimension(C25738R.dimen.f10371zf);
        float measuredWidth = (((float) (getMeasuredWidth() - getPaddingLeftAndRight())) - ((2.0f * dimension) * ((float) AcD.length))) / ((float) (AcD.length - 1));
        float paddingLeftAndRight = (((float) (getPaddingLeftAndRight() / 2)) + dimension) + 5.0f;
        float detailHeight = (1.0f * ((float) getDetailHeight())) / 2.0f;
        int i = 0;
        while (i < AcD.length) {
            float f = 0.0f;
            if (this.Adf == i) {
                this.AcG = false;
                f = 6.0f;
            } else if (this.AcG && i == 2) {
                f = 6.0f;
            }
            this.eHe.setColor(-1);
            canvas.drawCircle(paddingLeftAndRight, detailHeight, (dimension + 5.0f) + f, this.eHe);
            this.eHe.setColor(AcD[i]);
            canvas.drawCircle(paddingLeftAndRight, detailHeight, f + dimension, this.eHe);
            paddingLeftAndRight += (2.0f * dimension) + measuredWidth;
            i++;
        }
        AppMethodBeat.m2505o(116443);
    }

    /* Access modifiers changed, original: protected */
    public int getDetailHeight() {
        AppMethodBeat.m2504i(116444);
        int dimension = (int) getResources().getDimension(C25738R.dimen.f10304xe);
        AppMethodBeat.m2505o(116444);
        return dimension;
    }

    public int getPaddingLeftAndRight() {
        return (int) (2.0f * this.Acn);
    }

    public int getCurColor() {
        if (this.Adf == -1) {
            return AcD[2];
        }
        return AcD[this.Adf];
    }
}
