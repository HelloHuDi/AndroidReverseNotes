package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.CompoundButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMPinProgressBtn extends CompoundButton {
    private int EV;
    private Paint Pk;
    private RectF anj = new RectF();
    private int style;
    private final float zMA = 4.0f;
    private Runnable zMB = new Runnable() {
        public final void run() {
            AppMethodBeat.i(107898);
            if (MMPinProgressBtn.this.getVisibility() != 0) {
                ab.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
                AppMethodBeat.o(107898);
                return;
            }
            MMPinProgressBtn.this.EV = MMPinProgressBtn.this.EV + 1;
            if (MMPinProgressBtn.this.EV >= MMPinProgressBtn.this.zMx) {
                MMPinProgressBtn.this.EV = MMPinProgressBtn.this.EV - 1;
                ab.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
                AppMethodBeat.o(107898);
                return;
            }
            MMPinProgressBtn.this.invalidate();
            MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.this.zMB, 200);
            AppMethodBeat.o(107898);
        }
    };
    private int zMx;
    private Paint zMy;
    private int zMz;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(107899);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(107899);
                return savedState;
            }
        };
        private int EV;
        private int zMx;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(107900);
            this.EV = parcel.readInt();
            this.zMx = parcel.readInt();
            AppMethodBeat.o(107900);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(107901);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.EV);
            parcel.writeInt(this.zMx);
            AppMethodBeat.o(107901);
        }

        static {
            AppMethodBeat.i(107902);
            AppMethodBeat.o(107902);
        }
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107903);
        b(context, attributeSet, 0);
        AppMethodBeat.o(107903);
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107904);
        b(context, attributeSet, i);
        AppMethodBeat.o(107904);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(Context context, AttributeSet attributeSet, int i) {
        Throwable th;
        TypedArray typedArray;
        AppMethodBeat.i(107905);
        this.zMx = 100;
        this.EV = 0;
        Resources resources = getResources();
        int color = resources.getColor(R.color.wn);
        int color2 = resources.getColor(R.color.wo);
        if (attributeSet != null) {
            TypedArray typedArray2 = null;
            try {
                typedArray2 = context.obtainStyledAttributes(attributeSet, a.MMPinProgressBtn, i, 0);
                try {
                    this.zMx = typedArray2.getInteger(2, this.zMx);
                    this.EV = typedArray2.getInteger(1, this.EV);
                    color = typedArray2.getColor(3, color);
                    color2 = typedArray2.getColor(4, color2);
                    this.style = typedArray2.getInteger(6, 0);
                    this.zMz = typedArray2.getDimensionPixelSize(5, resources.getDimensionPixelSize(R.dimen.a7a));
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    typedArray = typedArray2;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    AppMethodBeat.o(107905);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                typedArray = typedArray2;
                if (typedArray != null) {
                }
                AppMethodBeat.o(107905);
                throw th;
            }
        }
        this.Pk = new Paint();
        this.Pk.setColor(color);
        this.Pk.setStyle(Style.STROKE);
        this.Pk.setStrokeWidth(4.0f);
        this.Pk.setAntiAlias(true);
        this.zMy = new Paint();
        this.zMy.setColor(color2);
        this.zMy.setAntiAlias(true);
        setClickable(false);
        AppMethodBeat.o(107905);
    }

    public int getMax() {
        return this.zMx;
    }

    public void setMax(int i) {
        AppMethodBeat.i(107906);
        this.zMx = Math.max(0, i);
        invalidate();
        AppMethodBeat.o(107906);
    }

    public int getProgress() {
        return this.EV;
    }

    public void setProgress(int i) {
        AppMethodBeat.i(107907);
        this.EV = Math.max(0, i);
        this.EV = Math.min(i, this.zMx);
        invalidate();
        AppMethodBeat.o(107907);
    }

    public final void dKB() {
        AppMethodBeat.i(107908);
        removeCallbacks(this.zMB);
        post(this.zMB);
        AppMethodBeat.o(107908);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107909);
        setMeasuredDimension(resolveSize(this.zMz, i), resolveSize(this.zMz, i2));
        AppMethodBeat.o(107909);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(107910);
        super.onDraw(canvas);
        this.anj.set(2.0f, 2.0f, ((float) this.zMz) - 2.0f, ((float) this.zMz) - 2.0f);
        this.anj.offset((float) ((getWidth() - this.zMz) / 2), (float) ((getHeight() - this.zMz) / 2));
        canvas.drawArc(this.anj, 0.0f, 360.0f, true, this.Pk);
        switch (this.style) {
            case 0:
                this.anj.set(8.0f, 8.0f, ((float) this.zMz) - 8.0f, ((float) this.zMz) - 8.0f);
                this.anj.offset((float) ((getWidth() - this.zMz) / 2), (float) ((getHeight() - this.zMz) / 2));
                canvas.drawArc(this.anj, -90.0f, 360.0f * ((((float) this.EV) * 1.0f) / ((float) this.zMx)), true, this.zMy);
                AppMethodBeat.o(107910);
                return;
            case 1:
                this.anj.set(2.0f, 2.0f, ((float) this.zMz) - 2.0f, ((float) this.zMz) - 2.0f);
                this.anj.offset((float) ((getWidth() - this.zMz) / 2), (float) ((getHeight() - this.zMz) / 2));
                canvas.drawArc(this.anj, 270.0f, (((((float) this.EV) * 1.0f) / ((float) this.zMx)) * 360.0f) - 360.0f, true, this.zMy);
                break;
        }
        AppMethodBeat.o(107910);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(107911);
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isSaveEnabled()) {
            SavedState savedState = new SavedState(onSaveInstanceState);
            savedState.zMx = this.zMx;
            savedState.EV = this.EV;
            AppMethodBeat.o(107911);
            return savedState;
        }
        AppMethodBeat.o(107911);
        return onSaveInstanceState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(107912);
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.zMx = savedState.zMx;
            this.EV = savedState.EV;
            AppMethodBeat.o(107912);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.o(107912);
    }
}
