package com.tencent.p177mm.plugin.luggage.natives.component.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathDashPathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.luggage.natives.p990a.C39346a.C21260a;
import com.tencent.p177mm.plugin.luggage.natives.p990a.C39346a.C39345f;
import com.tencent.p177mm.plugin.luggage.natives.p990a.C39346a.C39347g;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.a */
public final class C3431a extends Drawable {
    /* renamed from: HD */
    private int f1269HD = 0;
    private int iUG = 0;
    private int mColor = C8415j.INVALID_ID;
    private Paint mPaint;
    private C21260a oiB;
    public C21260a[] oiC;
    public C39347g[] oiD;
    public int[] oiE;
    public C39347g[] oiF;
    private int oiG = 0;
    private int oiH = 0;
    float[] oiI;
    private HashMap<int[], Integer> oiJ = new HashMap();
    private HashMap<int[], Integer> oiK = new HashMap();
    private ColorStateList oiL;
    private ColorStateList oiM;
    /* renamed from: uW */
    private float f1270uW = 0.0f;

    public C3431a() {
        AppMethodBeat.m2504i(116828);
        AppMethodBeat.m2505o(116828);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bMR() {
        AppMethodBeat.m2504i(116829);
        if (this.oiD == null || this.oiC == null || this.oiE == null) {
            AppMethodBeat.m2505o(116829);
            return;
        }
        this.mPaint = new Paint();
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setAntiAlias(true);
        int i = 0;
        while (i < 4) {
            if (this.oiD[i] == null || this.oiC[i] == C21260a.NONE) {
                i++;
            } else {
                this.f1270uW = this.oiD[i].value;
                this.mPaint.setStrokeWidth(this.oiD[i].value);
                if (this.oiE[i] != Integer.MIN_VALUE) {
                    this.mColor = this.oiE[i];
                    this.mPaint.setColor(this.oiE[i]);
                }
                this.oiB = this.oiC[i];
                if (this.oiB != C21260a.DASHED) {
                    this.mPaint.setPathEffect(new DashPathEffect(new float[]{15.0f, 15.0f}, 0.0f));
                    AppMethodBeat.m2505o(116829);
                    return;
                }
                if (this.oiB == C21260a.DOTTED) {
                    Path path = new Path();
                    path.addCircle(0.0f, 0.0f, 4.0f, Direction.CW);
                    this.mPaint.setPathEffect(new PathDashPathEffect(path, 15.0f, 0.0f, PathDashPathEffect.Style.ROTATE));
                }
                AppMethodBeat.m2505o(116829);
                return;
            }
        }
        if (this.oiB != C21260a.DASHED) {
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -1;
    }

    public final void draw(Canvas canvas) {
        Path path;
        AppMethodBeat.m2504i(116830);
        this.oiI = bMS();
        if (this.oiI == null) {
            path = null;
        } else {
            path = mo7868j(this.oiI);
        }
        if (path != null) {
            canvas.clipPath(path);
        }
        if (this.f1269HD != 0) {
            float[] fArr = this.oiI;
            path = new Path();
            Rect bounds = getBounds();
            RectF rectF = new RectF(this.f1270uW, this.f1270uW, ((float) bounds.width()) - this.f1270uW, ((float) bounds.height()) - this.f1270uW);
            if (this.oiF != null) {
                path.addRoundRect(rectF, fArr, Direction.CW);
            } else {
                path.addRect(rectF, Direction.CW);
            }
            Paint paint = new Paint();
            paint.setColor(this.f1269HD);
            paint.setStrokeWidth(0.0f);
            paint.setStyle(Style.FILL);
            canvas.drawPath(path, paint);
        }
        if (this.mPaint == null) {
            bMR();
        }
        m5703a(canvas, this.oiI);
        AppMethodBeat.m2505o(116830);
    }

    /* renamed from: a */
    private void m5703a(Canvas canvas, float[] fArr) {
        AppMethodBeat.m2504i(116831);
        if (this.oiC == null || this.oiE == null || this.oiD == null) {
            AppMethodBeat.m2505o(116831);
            return;
        }
        int[] iArr = new int[4];
        for (int i = 0; i < 4; i++) {
            iArr[i] = this.oiE[i];
            if (iArr[i] == Integer.MIN_VALUE) {
                iArr[i] = this.oiH;
            }
        }
        if (fArr == null) {
            fArr = new float[8];
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        Path path = null;
        float f = this.f1270uW / 2.0f;
        RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                break;
            }
            if (!(this.oiC[i3] == C21260a.NONE || this.oiD[i3] == null)) {
                Path path2;
                float f2;
                float f3;
                float f4;
                float f5;
                if (!(iArr[i3] == this.mColor || iArr[i3] == Integer.MIN_VALUE)) {
                    if (path != null) {
                        canvas.drawPath(path, this.mPaint);
                        path = null;
                    }
                    this.mColor = iArr[i3];
                    this.mPaint.setColor(this.mColor);
                }
                if (((double) Math.abs(this.f1270uW - this.oiD[i3].value)) > 1.0E-4d) {
                    if (path != null) {
                        canvas.drawPath(path, this.mPaint);
                        path = null;
                    }
                    this.f1270uW = this.oiD[i3].value;
                    f = this.f1270uW / 2.0f;
                    this.mPaint.setStrokeWidth(this.f1270uW);
                }
                if (this.oiC[i3] != this.oiB) {
                    if (path != null) {
                        canvas.drawPath(path, this.mPaint);
                        path = null;
                    }
                    this.oiB = this.oiC[i3];
                    if (this.oiB == C21260a.DASHED) {
                        this.mPaint.setPathEffect(new DashPathEffect(new float[]{15.0f, 15.0f}, 0.0f));
                    } else if (this.oiB == C21260a.DOTTED) {
                        Path path3 = new Path();
                        path3.addCircle(0.0f, 0.0f, 4.0f, Direction.CW);
                        this.mPaint.setPathEffect(new PathDashPathEffect(path3, 15.0f, 0.0f, PathDashPathEffect.Style.ROTATE));
                    } else {
                        this.mPaint.setPathEffect(null);
                    }
                }
                if (path == null) {
                    path2 = new Path();
                } else {
                    path2 = path;
                }
                float f6;
                if (i3 == 0) {
                    f6 = fArr[1];
                    f2 = ((float) width) - fArr[2];
                    if (fArr[1] > 0.0f) {
                        rectF.left = f;
                        rectF.top = f;
                        rectF.right = (fArr[1] * 2.0f) + (2.0f * f);
                        rectF.bottom = (fArr[0] * 2.0f) + (2.0f * f);
                        path2.arcTo(rectF, 180.0f, 90.0f);
                        f3 = f;
                        f4 = f;
                        f5 = f6;
                    } else {
                        f3 = f;
                        f4 = f;
                        f5 = f6;
                    }
                } else if (i3 == 1) {
                    f6 = ((float) width) - f;
                    f3 = fArr[3];
                    f4 = ((float) height) - fArr[4];
                    if (fArr[3] > 0.0f) {
                        rectF.left = (((float) width) - (fArr[2] * 2.0f)) - (2.0f * f);
                        rectF.top = f;
                        rectF.right = ((float) width) - f;
                        rectF.bottom = (fArr[3] * 2.0f) + (2.0f * f);
                        path2.arcTo(rectF, 270.0f, 90.0f);
                        f2 = f6;
                        f5 = f6;
                    } else {
                        f2 = f6;
                        f5 = f6;
                    }
                } else if (i3 == 2) {
                    f5 = ((float) width) - fArr[5];
                    f6 = ((float) height) - f;
                    f2 = fArr[6];
                    if (fArr[5] > 0.0f) {
                        rectF.left = (((float) width) - (fArr[5] * 2.0f)) - (2.0f * f);
                        rectF.top = (((float) height) - (fArr[4] * 2.0f)) - (2.0f * f);
                        rectF.right = ((float) width) - f;
                        rectF.bottom = ((float) height) - f;
                        path2.arcTo(rectF, 0.0f, 90.0f);
                        f3 = f6;
                        f4 = f6;
                    } else {
                        f3 = f6;
                        f4 = f6;
                    }
                } else {
                    f6 = ((float) height) - fArr[7];
                    f4 = fArr[0];
                    if (fArr[7] > 0.0f) {
                        rectF.left = f;
                        rectF.top = (((float) height) - (fArr[7] * 2.0f)) - (2.0f * f);
                        rectF.right = (fArr[6] * 2.0f) + (2.0f * f);
                        rectF.bottom = ((float) height) - f;
                        path2.arcTo(rectF, 90.0f, 90.0f);
                    }
                    f2 = f;
                    f3 = f6;
                    f5 = f;
                }
                path2.moveTo(f5, f3);
                path2.lineTo(f2, f4);
                path = path2;
            }
            i2 = i3 + 1;
        }
        if (path != null) {
            canvas.drawPath(path, this.mPaint);
        }
        AppMethodBeat.m2505o(116831);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: j */
    public final Path mo7868j(float[] fArr) {
        AppMethodBeat.m2504i(116832);
        if (this.oiF != null) {
            Path path = new Path();
            Rect bounds = getBounds();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) bounds.width(), (float) bounds.height()), fArr, Direction.CW);
            AppMethodBeat.m2505o(116832);
            return path;
        }
        AppMethodBeat.m2505o(116832);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final float[] bMS() {
        AppMethodBeat.m2504i(116833);
        if (this.oiF == null) {
            AppMethodBeat.m2505o(116833);
            return null;
        }
        int i;
        for (i = 0; i < 4; i++) {
            if (this.oiF[i] != null) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            AppMethodBeat.m2505o(116833);
            return null;
        }
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        i = 0;
        while (i < 4) {
            if (this.oiF[i] != null) {
                if (this.oiF[i].okI != C39345f.PERCENT) {
                    int i2 = i * 2;
                    int i3 = (i * 2) + 1;
                    float f = this.oiF[i].value;
                    fArr[i3] = f;
                    fArr[i2] = f;
                } else if (i == 0 || i == 2) {
                    fArr[i * 2] = (this.oiF[i].value * ((float) height)) / 100.0f;
                    fArr[(i * 2) + 1] = (this.oiF[i].value * ((float) width)) / 100.0f;
                } else {
                    fArr[i * 2] = (this.oiF[i].value * ((float) width)) / 100.0f;
                    fArr[(i * 2) + 1] = (this.oiF[i].value * ((float) height)) / 100.0f;
                }
            }
            i++;
        }
        float T = C3431a.m5702T(fArr[1] + fArr[2], ((float) width) - (this.f1270uW * 2.0f));
        if (T <= 0.0f || T >= 1.0f) {
            T = 1.0f;
        }
        float T2 = C3431a.m5702T(fArr[5] + fArr[6], ((float) width) - (this.f1270uW * 2.0f));
        if (T2 > 0.0f && T2 < r0) {
            T = T2;
        }
        T2 = C3431a.m5702T(fArr[0] + fArr[7], ((float) height) - (this.f1270uW * 2.0f));
        if (T2 > 0.0f && T2 < r0) {
            T = T2;
        }
        T2 = C3431a.m5702T(fArr[3] + fArr[4], ((float) height) - (this.f1270uW * 2.0f));
        if (T2 <= 0.0f || T2 >= T) {
            T2 = T;
        }
        if (((double) (1.0f - T2)) > 1.0E-6d) {
            for (i = 0; i < 8; i++) {
                fArr[i] = fArr[i] * T2;
            }
        }
        AppMethodBeat.m2505o(116833);
        return fArr;
    }

    /* renamed from: T */
    private static float m5702T(float f, float f2) {
        return f > 0.0f ? f2 / f : 0.0f;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        AppMethodBeat.m2504i(116834);
        boolean z = false;
        if (this.oiL != null) {
            colorForState = this.oiL.getColorForState(iArr, this.iUG);
            if (colorForState != this.f1269HD) {
                this.f1269HD = colorForState;
                z = true;
            }
        }
        if (this.oiM != null) {
            colorForState = this.oiM.getColorForState(iArr, this.oiG);
            if (colorForState != this.oiH) {
                this.oiH = colorForState;
                this.mColor = colorForState;
                if (this.mPaint != null) {
                    this.mPaint.setColor(colorForState);
                }
                z = true;
            }
        }
        AppMethodBeat.m2505o(116834);
        return z;
    }

    public final boolean isStateful() {
        AppMethodBeat.m2504i(116835);
        if ((this.oiL == null || this.oiJ.size() == 0) && (this.oiM == null || this.oiK.size() == 0)) {
            AppMethodBeat.m2505o(116835);
            return false;
        }
        AppMethodBeat.m2505o(116835);
        return true;
    }
}
