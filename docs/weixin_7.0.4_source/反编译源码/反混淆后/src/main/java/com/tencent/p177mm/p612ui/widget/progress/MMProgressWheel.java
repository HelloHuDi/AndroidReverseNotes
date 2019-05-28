package com.tencent.p177mm.p612ui.widget.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1594cg.C41922a.C41921a;

/* renamed from: com.tencent.mm.ui.widget.progress.MMProgressWheel */
public class MMProgressWheel extends View {
    private static final String TAG = MMProgressWheel.class.getSimpleName();
    /* renamed from: Yn */
    private float f15097Yn = 0.0f;
    /* renamed from: dL */
    private int f15098dL = 28;
    private final int zTc = 16;
    private final int zTd = 270;
    private final long zTe = 200;
    private int zTf = 4;
    private int zTg = 4;
    private boolean zTh = false;
    private double zTi = 0.0d;
    private double zTj = 460.0d;
    private float zTk = 0.0f;
    private boolean zTl = true;
    private long zTm = 0;
    private int zTn = -1442840576;
    private int zTo = 16777215;
    private Paint zTp = new Paint();
    private Paint zTq = new Paint();
    private RectF zTr = new RectF();
    private float zTs = 230.0f;
    private long zTt = 0;
    private boolean zTu;
    private float zTv = 0.0f;
    private boolean zTw = false;
    private C24107a zTx;
    private boolean zTy;

    /* renamed from: com.tencent.mm.ui.widget.progress.MMProgressWheel$a */
    public interface C24107a {
    }

    /* renamed from: com.tencent.mm.ui.widget.progress.MMProgressWheel$WheelSavedState */
    static class WheelSavedState extends BaseSavedState {
        public static final Creator<WheelSavedState> CREATOR = new C363621();
        /* renamed from: Yn */
        float f15099Yn;
        /* renamed from: dL */
        int f15100dL;
        int zTf;
        int zTg;
        boolean zTh;
        int zTn;
        int zTo;
        float zTs;
        boolean zTu;
        float zTv;
        boolean zTw;

        /* renamed from: com.tencent.mm.ui.widget.progress.MMProgressWheel$WheelSavedState$1 */
        static class C363621 implements Creator<WheelSavedState> {
            C363621() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WheelSavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(112936);
                WheelSavedState wheelSavedState = new WheelSavedState(parcel, (byte) 0);
                AppMethodBeat.m2505o(112936);
                return wheelSavedState;
            }
        }

        /* synthetic */ WheelSavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        static {
            AppMethodBeat.m2504i(112939);
            AppMethodBeat.m2505o(112939);
        }

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            super(parcel);
            AppMethodBeat.m2504i(112937);
            this.f15099Yn = parcel.readFloat();
            this.zTv = parcel.readFloat();
            this.zTw = parcel.readByte() != (byte) 0;
            this.zTs = parcel.readFloat();
            this.zTf = parcel.readInt();
            this.zTn = parcel.readInt();
            this.zTg = parcel.readInt();
            this.zTo = parcel.readInt();
            this.f15100dL = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.zTu = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.zTh = z2;
            AppMethodBeat.m2505o(112937);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            AppMethodBeat.m2504i(112938);
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f15099Yn);
            parcel.writeFloat(this.zTv);
            parcel.writeByte((byte) (this.zTw ? 1 : 0));
            parcel.writeFloat(this.zTs);
            parcel.writeInt(this.zTf);
            parcel.writeInt(this.zTn);
            parcel.writeInt(this.zTg);
            parcel.writeInt(this.zTo);
            parcel.writeInt(this.f15100dL);
            if (this.zTu) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            if (!this.zTh) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            AppMethodBeat.m2505o(112938);
        }
    }

    static {
        AppMethodBeat.m2504i(112958);
        AppMethodBeat.m2505o(112958);
    }

    public MMProgressWheel(Context context, AttributeSet attributeSet) {
        float f;
        boolean z = true;
        super(context, attributeSet);
        AppMethodBeat.m2504i(112940);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C41921a.MMProgressWheel);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.zTf = (int) TypedValue.applyDimension(1, (float) this.zTf, displayMetrics);
        this.zTg = (int) TypedValue.applyDimension(1, (float) this.zTg, displayMetrics);
        this.f15098dL = (int) TypedValue.applyDimension(1, (float) this.f15098dL, displayMetrics);
        this.f15098dL = (int) obtainStyledAttributes.getDimension(6, (float) this.f15098dL);
        this.zTh = obtainStyledAttributes.getBoolean(7, false);
        this.zTf = (int) obtainStyledAttributes.getDimension(8, (float) this.zTf);
        this.zTg = (int) obtainStyledAttributes.getDimension(3, (float) this.zTg);
        this.zTs = obtainStyledAttributes.getFloat(4, this.zTs / 360.0f) * 360.0f;
        this.zTj = (double) obtainStyledAttributes.getInt(5, (int) this.zTj);
        this.zTn = obtainStyledAttributes.getColor(1, this.zTn);
        this.zTo = obtainStyledAttributes.getColor(2, this.zTo);
        this.zTu = obtainStyledAttributes.getBoolean(9, false);
        if (obtainStyledAttributes.getBoolean(0, false)) {
            this.zTt = SystemClock.uptimeMillis();
            this.zTw = true;
            invalidate();
        }
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 17) {
            f = Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        } else {
            f = System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        }
        if (f == 0.0f) {
            z = false;
        }
        this.zTy = z;
        AppMethodBeat.m2505o(112940);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(112941);
        super.onMeasure(i, i2);
        int paddingLeft = (this.f15098dL + getPaddingLeft()) + getPaddingRight();
        int paddingTop = (this.f15098dL + getPaddingTop()) + getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == ErrorDialogData.SUPPRESSED) {
            paddingLeft = size;
        } else if (mode == C8415j.INVALID_ID) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == ErrorDialogData.SUPPRESSED || mode == ErrorDialogData.SUPPRESSED) {
            paddingTop = size2;
        } else if (mode2 == C8415j.INVALID_ID) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
        AppMethodBeat.m2505o(112941);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(112942);
        super.onSizeChanged(i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.zTh) {
            this.zTr = new RectF((float) (paddingLeft + this.zTf), (float) (paddingTop + this.zTf), (float) ((i - paddingRight) - this.zTf), (float) ((i2 - paddingBottom) - this.zTf));
        } else {
            int min = Math.min(Math.min((i - paddingLeft) - paddingRight, (i2 - paddingBottom) - paddingTop), (this.f15098dL * 2) - (this.zTf * 2));
            paddingLeft += (((i - paddingLeft) - paddingRight) - min) / 2;
            paddingTop += (((i2 - paddingTop) - paddingBottom) - min) / 2;
            this.zTr = new RectF((float) (this.zTf + paddingLeft), (float) (this.zTf + paddingTop), (float) ((paddingLeft + min) - this.zTf), (float) ((paddingTop + min) - this.zTf));
        }
        dLu();
        invalidate();
        AppMethodBeat.m2505o(112942);
    }

    private void dLu() {
        AppMethodBeat.m2504i(112943);
        this.zTp.setColor(this.zTn);
        this.zTp.setAntiAlias(true);
        this.zTp.setStyle(Style.STROKE);
        this.zTp.setStrokeWidth((float) this.zTf);
        this.zTq.setColor(this.zTo);
        this.zTq.setAntiAlias(true);
        this.zTq.setStyle(Style.STROKE);
        this.zTq.setStrokeWidth((float) this.zTg);
        AppMethodBeat.m2505o(112943);
    }

    public void setCallback(C24107a c24107a) {
        AppMethodBeat.m2504i(112944);
        this.zTx = c24107a;
        if (!this.zTw) {
            dLv();
        }
        AppMethodBeat.m2505o(112944);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        boolean z = true;
        AppMethodBeat.m2504i(112945);
        super.onDraw(canvas);
        canvas.drawArc(this.zTr, 360.0f, 360.0f, false, this.zTq);
        if (this.zTy) {
            float f;
            float cos;
            if (this.zTw) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.zTt;
                f = (((float) uptimeMillis) * this.zTs) / 1000.0f;
                if (this.zTm >= 200) {
                    this.zTi = ((double) uptimeMillis) + this.zTi;
                    if (this.zTi > this.zTj) {
                        this.zTi -= this.zTj;
                        this.zTm = 0;
                        this.zTl = !this.zTl;
                    }
                    cos = (((float) Math.cos(((this.zTi / this.zTj) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
                    if (this.zTl) {
                        this.zTk = cos * 254.0f;
                    } else {
                        cos = (1.0f - cos) * 254.0f;
                        this.f15097Yn += this.zTk - cos;
                        this.zTk = cos;
                    }
                } else {
                    this.zTm = uptimeMillis + this.zTm;
                }
                this.f15097Yn += f;
                if (this.f15097Yn > 360.0f) {
                    this.f15097Yn -= 360.0f;
                }
                this.zTt = SystemClock.uptimeMillis();
                float f2 = this.f15097Yn - 90.0f;
                f = 16.0f + this.zTk;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f = 135.0f;
                }
                canvas.drawArc(this.zTr, f2, f, false, this.zTp);
            } else {
                cos = this.f15097Yn;
                if (this.f15097Yn != this.zTv) {
                    this.f15097Yn = Math.min(((((float) (SystemClock.uptimeMillis() - this.zTt)) / 1000.0f) * this.zTs) + this.f15097Yn, this.zTv);
                    this.zTt = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (cos != this.f15097Yn) {
                    dLv();
                }
                cos = 0.0f;
                float f3 = this.f15097Yn;
                if (!this.zTu) {
                    cos = ((float) (1.0d - Math.pow((double) (1.0f - (this.f15097Yn / 360.0f)), 4.0d))) * 360.0f;
                    f3 = ((float) (1.0d - Math.pow((double) (1.0f - (this.f15097Yn / 360.0f)), 2.0d))) * 360.0f;
                }
                if (isInEditMode()) {
                    f = 360.0f;
                } else {
                    f = f3;
                }
                canvas.drawArc(this.zTr, cos - 90.0f, f, false, this.zTp);
            }
            if (z) {
                invalidate();
            }
            AppMethodBeat.m2505o(112945);
            return;
        }
        AppMethodBeat.m2505o(112945);
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.m2504i(112946);
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.zTt = SystemClock.uptimeMillis();
        }
        AppMethodBeat.m2505o(112946);
    }

    private void dLv() {
        AppMethodBeat.m2504i(112947);
        if (this.zTx != null) {
            Math.round((this.f15097Yn * 100.0f) / 360.0f);
        }
        AppMethodBeat.m2505o(112947);
    }

    public void setInstantProgress(float f) {
        AppMethodBeat.m2504i(112948);
        if (this.zTw) {
            this.f15097Yn = 0.0f;
            this.zTw = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (Math.abs(f - this.zTv) <= 0.0f) {
            AppMethodBeat.m2505o(112948);
            return;
        }
        this.zTv = Math.min(f * 360.0f, 360.0f);
        this.f15097Yn = this.zTv;
        this.zTt = SystemClock.uptimeMillis();
        invalidate();
        AppMethodBeat.m2505o(112948);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.m2504i(112949);
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f15099Yn = this.f15097Yn;
        wheelSavedState.zTv = this.zTv;
        wheelSavedState.zTw = this.zTw;
        wheelSavedState.zTs = this.zTs;
        wheelSavedState.zTf = this.zTf;
        wheelSavedState.zTn = this.zTn;
        wheelSavedState.zTg = this.zTg;
        wheelSavedState.zTo = this.zTo;
        wheelSavedState.f15100dL = this.f15098dL;
        wheelSavedState.zTu = this.zTu;
        wheelSavedState.zTh = this.zTh;
        AppMethodBeat.m2505o(112949);
        return wheelSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.m2504i(112950);
        if (parcelable instanceof WheelSavedState) {
            WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
            super.onRestoreInstanceState(wheelSavedState.getSuperState());
            this.f15097Yn = wheelSavedState.f15099Yn;
            this.zTv = wheelSavedState.zTv;
            this.zTw = wheelSavedState.zTw;
            this.zTs = wheelSavedState.zTs;
            this.zTf = wheelSavedState.zTf;
            this.zTn = wheelSavedState.zTn;
            this.zTg = wheelSavedState.zTg;
            this.zTo = wheelSavedState.zTo;
            this.f15098dL = wheelSavedState.f15100dL;
            this.zTu = wheelSavedState.zTu;
            this.zTh = wheelSavedState.zTh;
            this.zTt = SystemClock.uptimeMillis();
            AppMethodBeat.m2505o(112950);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.m2505o(112950);
    }

    public float getProgress() {
        return this.zTw ? -1.0f : this.f15097Yn / 360.0f;
    }

    public void setProgress(float f) {
        AppMethodBeat.m2504i(112951);
        if (this.zTw) {
            this.f15097Yn = 0.0f;
            this.zTw = false;
            dLv();
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (Math.abs(f - this.zTv) <= 0.0f) {
            AppMethodBeat.m2505o(112951);
            return;
        }
        if (this.f15097Yn == this.zTv) {
            this.zTt = SystemClock.uptimeMillis();
        }
        this.zTv = Math.min(f * 360.0f, 360.0f);
        invalidate();
        AppMethodBeat.m2505o(112951);
    }

    public void setLinearProgress(boolean z) {
        AppMethodBeat.m2504i(112952);
        this.zTu = z;
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.m2505o(112952);
    }

    public int getCircleRadius() {
        return this.f15098dL;
    }

    public void setCircleRadius(int i) {
        AppMethodBeat.m2504i(112953);
        this.f15098dL = i;
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.m2505o(112953);
    }

    public int getBarWidth() {
        return this.zTf;
    }

    public void setBarWidth(int i) {
        AppMethodBeat.m2504i(112954);
        this.zTf = i;
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.m2505o(112954);
    }

    public int getBarColor() {
        return this.zTn;
    }

    public void setBarColor(int i) {
        AppMethodBeat.m2504i(112955);
        this.zTn = i;
        dLu();
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.m2505o(112955);
    }

    public int getRimColor() {
        return this.zTo;
    }

    public void setRimColor(int i) {
        AppMethodBeat.m2504i(112956);
        this.zTo = i;
        dLu();
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.m2505o(112956);
    }

    public float getSpinSpeed() {
        return this.zTs / 360.0f;
    }

    public void setSpinSpeed(float f) {
        this.zTs = 360.0f * f;
    }

    public int getRimWidth() {
        return this.zTg;
    }

    public void setRimWidth(int i) {
        AppMethodBeat.m2504i(112957);
        this.zTg = i;
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.m2505o(112957);
    }
}
