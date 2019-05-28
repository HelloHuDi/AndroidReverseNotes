package com.tencent.mm.ui.widget.progress;

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
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMProgressWheel extends View {
    private static final String TAG = MMProgressWheel.class.getSimpleName();
    private float Yn = 0.0f;
    private int dL = 28;
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
    private a zTx;
    private boolean zTy;

    public interface a {
    }

    static class WheelSavedState extends BaseSavedState {
        public static final Creator<WheelSavedState> CREATOR = new Creator<WheelSavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WheelSavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(112936);
                WheelSavedState wheelSavedState = new WheelSavedState(parcel, (byte) 0);
                AppMethodBeat.o(112936);
                return wheelSavedState;
            }
        };
        float Yn;
        int dL;
        int zTf;
        int zTg;
        boolean zTh;
        int zTn;
        int zTo;
        float zTs;
        boolean zTu;
        float zTv;
        boolean zTw;

        /* synthetic */ WheelSavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        static {
            AppMethodBeat.i(112939);
            AppMethodBeat.o(112939);
        }

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            super(parcel);
            AppMethodBeat.i(112937);
            this.Yn = parcel.readFloat();
            this.zTv = parcel.readFloat();
            this.zTw = parcel.readByte() != (byte) 0;
            this.zTs = parcel.readFloat();
            this.zTf = parcel.readInt();
            this.zTn = parcel.readInt();
            this.zTg = parcel.readInt();
            this.zTo = parcel.readInt();
            this.dL = parcel.readInt();
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
            AppMethodBeat.o(112937);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(112938);
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.Yn);
            parcel.writeFloat(this.zTv);
            parcel.writeByte((byte) (this.zTw ? 1 : 0));
            parcel.writeFloat(this.zTs);
            parcel.writeInt(this.zTf);
            parcel.writeInt(this.zTn);
            parcel.writeInt(this.zTg);
            parcel.writeInt(this.zTo);
            parcel.writeInt(this.dL);
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
            AppMethodBeat.o(112938);
        }
    }

    static {
        AppMethodBeat.i(112958);
        AppMethodBeat.o(112958);
    }

    public MMProgressWheel(Context context, AttributeSet attributeSet) {
        float f;
        boolean z = true;
        super(context, attributeSet);
        AppMethodBeat.i(112940);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.cg.a.a.MMProgressWheel);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.zTf = (int) TypedValue.applyDimension(1, (float) this.zTf, displayMetrics);
        this.zTg = (int) TypedValue.applyDimension(1, (float) this.zTg, displayMetrics);
        this.dL = (int) TypedValue.applyDimension(1, (float) this.dL, displayMetrics);
        this.dL = (int) obtainStyledAttributes.getDimension(6, (float) this.dL);
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
        AppMethodBeat.o(112940);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(112941);
        super.onMeasure(i, i2);
        int paddingLeft = (this.dL + getPaddingLeft()) + getPaddingRight();
        int paddingTop = (this.dL + getPaddingTop()) + getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == ErrorDialogData.SUPPRESSED) {
            paddingLeft = size;
        } else if (mode == j.INVALID_ID) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == ErrorDialogData.SUPPRESSED || mode == ErrorDialogData.SUPPRESSED) {
            paddingTop = size2;
        } else if (mode2 == j.INVALID_ID) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
        AppMethodBeat.o(112941);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(112942);
        super.onSizeChanged(i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.zTh) {
            this.zTr = new RectF((float) (paddingLeft + this.zTf), (float) (paddingTop + this.zTf), (float) ((i - paddingRight) - this.zTf), (float) ((i2 - paddingBottom) - this.zTf));
        } else {
            int min = Math.min(Math.min((i - paddingLeft) - paddingRight, (i2 - paddingBottom) - paddingTop), (this.dL * 2) - (this.zTf * 2));
            paddingLeft += (((i - paddingLeft) - paddingRight) - min) / 2;
            paddingTop += (((i2 - paddingTop) - paddingBottom) - min) / 2;
            this.zTr = new RectF((float) (this.zTf + paddingLeft), (float) (this.zTf + paddingTop), (float) ((paddingLeft + min) - this.zTf), (float) ((paddingTop + min) - this.zTf));
        }
        dLu();
        invalidate();
        AppMethodBeat.o(112942);
    }

    private void dLu() {
        AppMethodBeat.i(112943);
        this.zTp.setColor(this.zTn);
        this.zTp.setAntiAlias(true);
        this.zTp.setStyle(Style.STROKE);
        this.zTp.setStrokeWidth((float) this.zTf);
        this.zTq.setColor(this.zTo);
        this.zTq.setAntiAlias(true);
        this.zTq.setStyle(Style.STROKE);
        this.zTq.setStrokeWidth((float) this.zTg);
        AppMethodBeat.o(112943);
    }

    public void setCallback(a aVar) {
        AppMethodBeat.i(112944);
        this.zTx = aVar;
        if (!this.zTw) {
            dLv();
        }
        AppMethodBeat.o(112944);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        boolean z = true;
        AppMethodBeat.i(112945);
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
                        this.Yn += this.zTk - cos;
                        this.zTk = cos;
                    }
                } else {
                    this.zTm = uptimeMillis + this.zTm;
                }
                this.Yn += f;
                if (this.Yn > 360.0f) {
                    this.Yn -= 360.0f;
                }
                this.zTt = SystemClock.uptimeMillis();
                float f2 = this.Yn - 90.0f;
                f = 16.0f + this.zTk;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f = 135.0f;
                }
                canvas.drawArc(this.zTr, f2, f, false, this.zTp);
            } else {
                cos = this.Yn;
                if (this.Yn != this.zTv) {
                    this.Yn = Math.min(((((float) (SystemClock.uptimeMillis() - this.zTt)) / 1000.0f) * this.zTs) + this.Yn, this.zTv);
                    this.zTt = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (cos != this.Yn) {
                    dLv();
                }
                cos = 0.0f;
                float f3 = this.Yn;
                if (!this.zTu) {
                    cos = ((float) (1.0d - Math.pow((double) (1.0f - (this.Yn / 360.0f)), 4.0d))) * 360.0f;
                    f3 = ((float) (1.0d - Math.pow((double) (1.0f - (this.Yn / 360.0f)), 2.0d))) * 360.0f;
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
            AppMethodBeat.o(112945);
            return;
        }
        AppMethodBeat.o(112945);
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.i(112946);
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.zTt = SystemClock.uptimeMillis();
        }
        AppMethodBeat.o(112946);
    }

    private void dLv() {
        AppMethodBeat.i(112947);
        if (this.zTx != null) {
            Math.round((this.Yn * 100.0f) / 360.0f);
        }
        AppMethodBeat.o(112947);
    }

    public void setInstantProgress(float f) {
        AppMethodBeat.i(112948);
        if (this.zTw) {
            this.Yn = 0.0f;
            this.zTw = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (Math.abs(f - this.zTv) <= 0.0f) {
            AppMethodBeat.o(112948);
            return;
        }
        this.zTv = Math.min(f * 360.0f, 360.0f);
        this.Yn = this.zTv;
        this.zTt = SystemClock.uptimeMillis();
        invalidate();
        AppMethodBeat.o(112948);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(112949);
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.Yn = this.Yn;
        wheelSavedState.zTv = this.zTv;
        wheelSavedState.zTw = this.zTw;
        wheelSavedState.zTs = this.zTs;
        wheelSavedState.zTf = this.zTf;
        wheelSavedState.zTn = this.zTn;
        wheelSavedState.zTg = this.zTg;
        wheelSavedState.zTo = this.zTo;
        wheelSavedState.dL = this.dL;
        wheelSavedState.zTu = this.zTu;
        wheelSavedState.zTh = this.zTh;
        AppMethodBeat.o(112949);
        return wheelSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(112950);
        if (parcelable instanceof WheelSavedState) {
            WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
            super.onRestoreInstanceState(wheelSavedState.getSuperState());
            this.Yn = wheelSavedState.Yn;
            this.zTv = wheelSavedState.zTv;
            this.zTw = wheelSavedState.zTw;
            this.zTs = wheelSavedState.zTs;
            this.zTf = wheelSavedState.zTf;
            this.zTn = wheelSavedState.zTn;
            this.zTg = wheelSavedState.zTg;
            this.zTo = wheelSavedState.zTo;
            this.dL = wheelSavedState.dL;
            this.zTu = wheelSavedState.zTu;
            this.zTh = wheelSavedState.zTh;
            this.zTt = SystemClock.uptimeMillis();
            AppMethodBeat.o(112950);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.o(112950);
    }

    public float getProgress() {
        return this.zTw ? -1.0f : this.Yn / 360.0f;
    }

    public void setProgress(float f) {
        AppMethodBeat.i(112951);
        if (this.zTw) {
            this.Yn = 0.0f;
            this.zTw = false;
            dLv();
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (Math.abs(f - this.zTv) <= 0.0f) {
            AppMethodBeat.o(112951);
            return;
        }
        if (this.Yn == this.zTv) {
            this.zTt = SystemClock.uptimeMillis();
        }
        this.zTv = Math.min(f * 360.0f, 360.0f);
        invalidate();
        AppMethodBeat.o(112951);
    }

    public void setLinearProgress(boolean z) {
        AppMethodBeat.i(112952);
        this.zTu = z;
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.o(112952);
    }

    public int getCircleRadius() {
        return this.dL;
    }

    public void setCircleRadius(int i) {
        AppMethodBeat.i(112953);
        this.dL = i;
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.o(112953);
    }

    public int getBarWidth() {
        return this.zTf;
    }

    public void setBarWidth(int i) {
        AppMethodBeat.i(112954);
        this.zTf = i;
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.o(112954);
    }

    public int getBarColor() {
        return this.zTn;
    }

    public void setBarColor(int i) {
        AppMethodBeat.i(112955);
        this.zTn = i;
        dLu();
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.o(112955);
    }

    public int getRimColor() {
        return this.zTo;
    }

    public void setRimColor(int i) {
        AppMethodBeat.i(112956);
        this.zTo = i;
        dLu();
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.o(112956);
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
        AppMethodBeat.i(112957);
        this.zTg = i;
        if (!this.zTw) {
            invalidate();
        }
        AppMethodBeat.o(112957);
    }
}
