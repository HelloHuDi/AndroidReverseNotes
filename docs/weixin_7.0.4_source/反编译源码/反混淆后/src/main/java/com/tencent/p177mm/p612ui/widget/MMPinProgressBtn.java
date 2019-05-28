package com.tencent.p177mm.p612ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.widget.MMPinProgressBtn */
public class MMPinProgressBtn extends CompoundButton {
    /* renamed from: EV */
    private int f15091EV;
    /* renamed from: Pk */
    private Paint f15092Pk;
    private RectF anj = new RectF();
    private int style;
    private final float zMA = 4.0f;
    private Runnable zMB = new C363551();
    private int zMx;
    private Paint zMy;
    private int zMz;

    /* renamed from: com.tencent.mm.ui.widget.MMPinProgressBtn$1 */
    class C363551 implements Runnable {
        C363551() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107898);
            if (MMPinProgressBtn.this.getVisibility() != 0) {
                C4990ab.m7416i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
                AppMethodBeat.m2505o(107898);
                return;
            }
            MMPinProgressBtn.this.f15091EV = MMPinProgressBtn.this.f15091EV + 1;
            if (MMPinProgressBtn.this.f15091EV >= MMPinProgressBtn.this.zMx) {
                MMPinProgressBtn.this.f15091EV = MMPinProgressBtn.this.f15091EV - 1;
                C4990ab.m7416i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
                AppMethodBeat.m2505o(107898);
                return;
            }
            MMPinProgressBtn.this.invalidate();
            MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.this.zMB, 200);
            AppMethodBeat.m2505o(107898);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.MMPinProgressBtn$SavedState */
    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C56271();
        /* renamed from: EV */
        private int f15093EV;
        private int zMx;

        /* renamed from: com.tencent.mm.ui.widget.MMPinProgressBtn$SavedState$1 */
        static class C56271 implements Creator<SavedState> {
            C56271() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(107899);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.m2505o(107899);
                return savedState;
            }
        }

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.m2504i(107900);
            this.f15093EV = parcel.readInt();
            this.zMx = parcel.readInt();
            AppMethodBeat.m2505o(107900);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(107901);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f15093EV);
            parcel.writeInt(this.zMx);
            AppMethodBeat.m2505o(107901);
        }

        static {
            AppMethodBeat.m2504i(107902);
            AppMethodBeat.m2505o(107902);
        }
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107903);
        m59867b(context, attributeSet, 0);
        AppMethodBeat.m2505o(107903);
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107904);
        m59867b(context, attributeSet, i);
        AppMethodBeat.m2505o(107904);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m59867b(Context context, AttributeSet attributeSet, int i) {
        Throwable th;
        TypedArray typedArray;
        AppMethodBeat.m2504i(107905);
        this.zMx = 100;
        this.f15091EV = 0;
        Resources resources = getResources();
        int color = resources.getColor(C25738R.color.f12222wn);
        int color2 = resources.getColor(C25738R.color.f12223wo);
        if (attributeSet != null) {
            TypedArray typedArray2 = null;
            try {
                typedArray2 = context.obtainStyledAttributes(attributeSet, C1190a.MMPinProgressBtn, i, 0);
                try {
                    this.zMx = typedArray2.getInteger(2, this.zMx);
                    this.f15091EV = typedArray2.getInteger(1, this.f15091EV);
                    color = typedArray2.getColor(3, color);
                    color2 = typedArray2.getColor(4, color2);
                    this.style = typedArray2.getInteger(6, 0);
                    this.zMz = typedArray2.getDimensionPixelSize(5, resources.getDimensionPixelSize(C25738R.dimen.a7a));
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    typedArray = typedArray2;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    AppMethodBeat.m2505o(107905);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                typedArray = typedArray2;
                if (typedArray != null) {
                }
                AppMethodBeat.m2505o(107905);
                throw th;
            }
        }
        this.f15092Pk = new Paint();
        this.f15092Pk.setColor(color);
        this.f15092Pk.setStyle(Style.STROKE);
        this.f15092Pk.setStrokeWidth(4.0f);
        this.f15092Pk.setAntiAlias(true);
        this.zMy = new Paint();
        this.zMy.setColor(color2);
        this.zMy.setAntiAlias(true);
        setClickable(false);
        AppMethodBeat.m2505o(107905);
    }

    public int getMax() {
        return this.zMx;
    }

    public void setMax(int i) {
        AppMethodBeat.m2504i(107906);
        this.zMx = Math.max(0, i);
        invalidate();
        AppMethodBeat.m2505o(107906);
    }

    public int getProgress() {
        return this.f15091EV;
    }

    public void setProgress(int i) {
        AppMethodBeat.m2504i(107907);
        this.f15091EV = Math.max(0, i);
        this.f15091EV = Math.min(i, this.zMx);
        invalidate();
        AppMethodBeat.m2505o(107907);
    }

    public final void dKB() {
        AppMethodBeat.m2504i(107908);
        removeCallbacks(this.zMB);
        post(this.zMB);
        AppMethodBeat.m2505o(107908);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(107909);
        setMeasuredDimension(MMPinProgressBtn.resolveSize(this.zMz, i), MMPinProgressBtn.resolveSize(this.zMz, i2));
        AppMethodBeat.m2505o(107909);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107910);
        super.onDraw(canvas);
        this.anj.set(2.0f, 2.0f, ((float) this.zMz) - 2.0f, ((float) this.zMz) - 2.0f);
        this.anj.offset((float) ((getWidth() - this.zMz) / 2), (float) ((getHeight() - this.zMz) / 2));
        canvas.drawArc(this.anj, 0.0f, 360.0f, true, this.f15092Pk);
        switch (this.style) {
            case 0:
                this.anj.set(8.0f, 8.0f, ((float) this.zMz) - 8.0f, ((float) this.zMz) - 8.0f);
                this.anj.offset((float) ((getWidth() - this.zMz) / 2), (float) ((getHeight() - this.zMz) / 2));
                canvas.drawArc(this.anj, -90.0f, 360.0f * ((((float) this.f15091EV) * 1.0f) / ((float) this.zMx)), true, this.zMy);
                AppMethodBeat.m2505o(107910);
                return;
            case 1:
                this.anj.set(2.0f, 2.0f, ((float) this.zMz) - 2.0f, ((float) this.zMz) - 2.0f);
                this.anj.offset((float) ((getWidth() - this.zMz) / 2), (float) ((getHeight() - this.zMz) / 2));
                canvas.drawArc(this.anj, 270.0f, (((((float) this.f15091EV) * 1.0f) / ((float) this.zMx)) * 360.0f) - 360.0f, true, this.zMy);
                break;
        }
        AppMethodBeat.m2505o(107910);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.m2504i(107911);
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isSaveEnabled()) {
            SavedState savedState = new SavedState(onSaveInstanceState);
            savedState.zMx = this.zMx;
            savedState.f15093EV = this.f15091EV;
            AppMethodBeat.m2505o(107911);
            return savedState;
        }
        AppMethodBeat.m2505o(107911);
        return onSaveInstanceState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.m2504i(107912);
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.zMx = savedState.zMx;
            this.f15091EV = savedState.f15093EV;
            AppMethodBeat.m2505o(107912);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.m2505o(107912);
    }
}
