package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.p1026a.C13431a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.p1026a.C29063b;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer */
public class RadarDataLayer extends DataLayerView {
    public static final Point qYx = new Point(0, 0);
    private C29063b qYA = new C29063b();
    private ValueAnimator qYB;
    private boolean qYC = true;
    private int qYD = 80;
    private Point qYE = qYx;
    private int qYs = 4;
    private float qYv = 1.0f;
    private C13431a qYy;
    private C13431a qYz;
    /* renamed from: vr */
    private Path f18291vr = new Path();

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer$1 */
    class C134321 implements AnimatorUpdateListener {
        C134321() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(36965);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (Entry entry : RadarDataLayer.this.qYy.entrySet()) {
                RadarDataLayer.this.qYz.put(entry.getKey(), Float.valueOf(((Float) entry.getValue()).floatValue() * floatValue));
                RadarDataLayer.this.invalidate();
            }
            AppMethodBeat.m2505o(36965);
        }
    }

    static {
        AppMethodBeat.m2504i(36979);
        AppMethodBeat.m2505o(36979);
    }

    public RadarDataLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(36966);
        cpj();
        AppMethodBeat.m2505o(36966);
    }

    public RadarDataLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(36967);
        cpj();
        AppMethodBeat.m2505o(36967);
    }

    public RadarDataLayer(Context context, float f, C13431a c13431a) {
        super(context);
        AppMethodBeat.m2504i(36968);
        this.qYv = f;
        this.qYA = c13431a.qXF;
        this.qYs = c13431a.size();
        this.qYy = c13431a;
        Interpolator interpolator = c13431a.qXG;
        long j = c13431a.duration;
        if (j > 0) {
            this.qYB = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.qYz = new C13431a();
            this.qYB.setDuration(j);
            this.qYB.setInterpolator(interpolator);
            this.qYB.addUpdateListener(new C134321());
        }
        AppMethodBeat.m2505o(36968);
    }

    private void cpj() {
        AppMethodBeat.m2504i(36969);
        setMinimumHeight(160);
        setMinimumWidth(160);
        AppMethodBeat.m2505o(36969);
    }

    public final int cpg() {
        return this.qYD * 2;
    }

    public final int cph() {
        return this.qYD * 2;
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(36970);
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.qYD = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.qYE.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.qYy == null) {
            RuntimeException runtimeException = new RuntimeException("Error: NullPointerException at data.");
            AppMethodBeat.m2505o(36970);
            throw runtimeException;
        }
        if (this.qYy != null) {
            Set entrySet;
            if (this.qYz == null) {
                entrySet = this.qYy.entrySet();
            } else {
                entrySet = this.qYz.entrySet();
            }
            int i = 0;
            for (Entry entry : entrySet) {
                float floatValue = (float) (((double) this.qYE.x) - (((double) ((((Float) entry.getValue()).floatValue() / this.qYv) * ((float) this.qYD))) * Math.sin(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.qYs)))));
                float floatValue2 = (float) (((double) this.qYE.y) - (((double) ((((Float) entry.getValue()).floatValue() / this.qYv) * ((float) this.qYD))) * Math.cos(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.qYs)))));
                if (i == 0) {
                    this.f18291vr.moveTo(floatValue, floatValue2);
                } else {
                    this.f18291vr.lineTo(floatValue, floatValue2);
                }
                if (this.qYC) {
                    canvas.drawCircle(floatValue, floatValue2, (float) this.qYA.qXN, getPaintLayerDotPoint());
                }
                i++;
            }
            this.f18291vr.close();
            canvas.drawPath(this.f18291vr, getPaintLayerFilling());
            canvas.drawPath(this.f18291vr, getPaintLayerBorder());
            this.f18291vr.reset();
        }
        AppMethodBeat.m2505o(36970);
    }

    private Paint getPaintLayerFilling() {
        int i;
        AppMethodBeat.m2504i(36971);
        Paint paint = new Paint();
        C29063b c29063b = this.qYA;
        if (c29063b.qXK == -1) {
            i = c29063b.qXI;
        } else {
            i = c29063b.qXK;
        }
        paint.setColor(i);
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        paint.setAlpha(this.qYA.qXL);
        AppMethodBeat.m2505o(36971);
        return paint;
    }

    private Paint getPaintLayerBorder() {
        AppMethodBeat.m2504i(36972);
        Paint paint = new Paint();
        paint.setColor(this.qYA.qXI);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(this.qYA.qXJ);
        paint.setAntiAlias(true);
        AppMethodBeat.m2505o(36972);
        return paint;
    }

    private Paint getPaintLayerPoint() {
        AppMethodBeat.m2504i(36973);
        Paint paint = new Paint();
        paint.setColor(this.qYA.qXI);
        paint.setStrokeWidth(this.qYA.qXJ);
        AppMethodBeat.m2505o(36973);
        return paint;
    }

    private Paint getPaintLayerDotPoint() {
        AppMethodBeat.m2504i(36974);
        Paint paint = new Paint();
        paint.setColor(this.qYA.qXM);
        AppMethodBeat.m2505o(36974);
        return paint;
    }

    public void setGlobalMax(float f) {
        AppMethodBeat.m2504i(36975);
        this.qYv = f;
        invalidate();
        AppMethodBeat.m2505o(36975);
    }

    public void setData(C13431a c13431a) {
        AppMethodBeat.m2504i(36976);
        this.qYy = c13431a;
        invalidate();
        AppMethodBeat.m2505o(36976);
    }

    public void setLayerStyle(C29063b c29063b) {
        AppMethodBeat.m2504i(36977);
        this.qYA = c29063b;
        invalidate();
        AppMethodBeat.m2505o(36977);
    }

    public void setMaxValue(float f) {
        AppMethodBeat.m2504i(36978);
        this.qYv = f;
        invalidate();
        AppMethodBeat.m2505o(36978);
    }
}
