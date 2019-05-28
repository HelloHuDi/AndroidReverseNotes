package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView extends View {
    private static Bitmap tWw = null;
    private static Bitmap tWx = null;
    private static Bitmap tWy = null;
    private static Bitmap tWz = null;
    private int HB;
    private int HC;
    private int lDV;
    private float tWA;
    private float tWB;
    private boolean tWC;
    private long tWD;
    private float tWE;
    private float tWF;
    private a tWG;
    private Paint tWg = new Paint();
    private Paint tWh = new Paint();
    private Path tWi = new Path();
    private Matrix tWj = new Matrix();
    private Rect tWk = new Rect();
    private Rect tWl = new Rect();
    private ArrayList<f> tWm = new ArrayList(9);
    private boolean[][] tWn = ((boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{3, 3}));
    private c tWo = c.Square;
    private int tWp = 6;
    private int tWq = 200;
    private float tWr = 0.66f;
    private boolean tWs = false;
    private boolean tWt = true;
    private boolean tWu = false;
    private b tWv;

    public interface a {
        void a(PatternLockView patternLockView);

        void a(PatternLockView patternLockView, List<f> list);
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(51653);
                SavedState savedState = new SavedState(parcel);
                AppMethodBeat.o(51653);
                return savedState;
            }
        };
        String tWM;
        int tWN;
        boolean tWs;
        boolean tWt;
        boolean tWu;

        public SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(51654);
            this.tWM = parcel.readString();
            this.tWN = parcel.readInt();
            this.tWt = ((Boolean) parcel.readValue(null)).booleanValue();
            this.tWu = ((Boolean) parcel.readValue(null)).booleanValue();
            this.tWs = ((Boolean) parcel.readValue(null)).booleanValue();
            AppMethodBeat.o(51654);
        }

        public SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.tWM = str;
            this.tWN = i;
            this.tWt = z;
            this.tWu = z2;
            this.tWs = z3;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(51655);
            super.writeToParcel(parcel, i);
            parcel.writeString(this.tWM);
            parcel.writeInt(this.tWN);
            parcel.writeValue(Boolean.valueOf(this.tWt));
            parcel.writeValue(Boolean.valueOf(this.tWu));
            parcel.writeValue(Boolean.valueOf(this.tWs));
            AppMethodBeat.o(51655);
        }

        static {
            AppMethodBeat.i(51656);
            AppMethodBeat.o(51656);
        }
    }

    public enum b {
        Correct,
        Wrong,
        Animate;

        static {
            AppMethodBeat.o(51652);
        }
    }

    public enum c {
        Square,
        Rectangle;

        static {
            AppMethodBeat.o(51659);
        }
    }

    public PatternLockView(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        AppMethodBeat.i(51660);
        if (isInEditMode()) {
            i = -1;
        } else {
            i = getResources().getColor(R.color.r4);
        }
        this.lDV = i;
        this.tWv = b.Correct;
        this.tWA = -1.0f;
        this.tWB = -1.0f;
        this.tWC = false;
        this.tWD = 0;
        this.HB = 0;
        this.HC = 0;
        this.tWE = 0.0f;
        this.tWF = 0.0f;
        this.tWG = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.plugin.walletlock.a.a.mm_patternlock_view);
        this.tWt = obtainStyledAttributes.getBoolean(4, this.tWt);
        this.tWq = obtainStyledAttributes.getInt(1, this.tWq);
        this.tWp = obtainStyledAttributes.getInt(2, this.tWp);
        this.tWs = obtainStyledAttributes.getBoolean(3, this.tWs);
        switch (obtainStyledAttributes.getInt(0, this.tWo.ordinal())) {
            case 0:
                this.tWo = c.Square;
                break;
            case 1:
                this.tWo = c.Rectangle;
                break;
            default:
                this.tWo = c.Square;
                break;
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        this.tWh.setStyle(Style.STROKE);
        this.tWh.setStrokeJoin(Join.ROUND);
        this.tWh.setStrokeCap(Cap.ROUND);
        this.tWh.setAntiAlias(true);
        this.tWh.setDither(false);
        this.tWh.setAlpha(this.tWq);
        this.tWg.setAntiAlias(true);
        this.tWg.setDither(true);
        if (!isInEditMode()) {
            if (tWw == null) {
                tWw = u(com.tencent.mm.bz.a.g(getContext(), R.drawable.pn));
                Bitmap u = u(com.tencent.mm.bz.a.g(getContext(), R.drawable.po));
                tWx = u;
                tWy = u;
                tWz = u(com.tencent.mm.bz.a.g(getContext(), R.drawable.pp));
            }
            this.tWp = (int) (((float) this.tWp) * d.anS().density);
            Bitmap[] bitmapArr = new Bitmap[]{tWw, tWx, tWy, tWz};
            for (i = 0; i < 4; i++) {
                Bitmap bitmap = bitmapArr[i];
                this.HB = Math.max(bitmap.getWidth(), this.HB);
                this.HC = Math.max(bitmap.getHeight(), this.HC);
            }
        }
        AppMethodBeat.o(51660);
    }

    private static Bitmap u(Drawable drawable) {
        AppMethodBeat.i(51661);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        AppMethodBeat.o(51661);
        return createBitmap;
    }

    private static String dY(List<f> list) {
        AppMethodBeat.i(51662);
        if (list == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("pattern is null");
            AppMethodBeat.o(51662);
            throw illegalArgumentException;
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            f fVar = (f) list.get(i);
            bArr[i] = (byte) (fVar.tVB + (fVar.tVA * 3));
        }
        String str = new String(bArr);
        AppMethodBeat.o(51662);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(51663);
        SavedState savedState = new SavedState(super.onSaveInstanceState(), dY(this.tWm), this.tWv.ordinal(), this.tWt, this.tWu, this.tWs);
        AppMethodBeat.o(51663);
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(51664);
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b bVar = b.Correct;
        String str = savedState.tWM;
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Serialized pattern is null");
            AppMethodBeat.o(51664);
            throw illegalArgumentException;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            arrayList.add(f.gk(b / 3, b % 3));
        }
        a(bVar, arrayList);
        this.tWv = b.values()[savedState.tWN];
        this.tWt = savedState.tWt;
        this.tWu = savedState.tWu;
        this.tWs = savedState.tWs;
        AppMethodBeat.o(51664);
    }

    /* Access modifiers changed, original: protected */
    public int getSuggestedMinimumWidth() {
        AppMethodBeat.i(51665);
        int i = (int) ((3.0d * ((double) ((float) this.HB))) / ((double) getResources().getDisplayMetrics().density));
        AppMethodBeat.o(51665);
        return i;
    }

    /* Access modifiers changed, original: protected */
    public int getSuggestedMinimumHeight() {
        AppMethodBeat.i(51666);
        int i = (int) ((3.0d * ((double) ((float) this.HC))) / ((double) getResources().getDisplayMetrics().density));
        AppMethodBeat.o(51666);
        return i;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(51667);
        this.tWE = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.tWF = ((float) ((i2 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
        AppMethodBeat.o(51667);
    }

    private static int gl(int i, int i2) {
        AppMethodBeat.i(51668);
        int size = MeasureSpec.getSize(i);
        switch (MeasureSpec.getMode(i)) {
            case j.INVALID_ID /*-2147483648*/:
                i2 = Math.max(size, i2);
                break;
            case 0:
                break;
            default:
                i2 = size;
                break;
        }
        AppMethodBeat.o(51668);
        return i2;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(51669);
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int gl = gl(i, suggestedMinimumWidth);
        suggestedMinimumWidth = gl(i2, suggestedMinimumHeight);
        if (this.tWo == c.Square) {
            gl = Math.min(gl, suggestedMinimumWidth);
            suggestedMinimumWidth = gl;
            suggestedMinimumHeight = gl;
        } else {
            suggestedMinimumHeight = gl;
        }
        setMeasuredDimension(suggestedMinimumHeight, suggestedMinimumWidth);
        AppMethodBeat.o(51669);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        int elapsedRealtime;
        int i;
        f fVar;
        Object obj;
        float HE;
        float HF;
        float f;
        AppMethodBeat.i(51670);
        ArrayList arrayList = this.tWm;
        int size = arrayList.size();
        boolean[][] zArr = this.tWn;
        if (this.tWv == b.Animate) {
            elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.tWD)) % ((size + 1) * 700);
            i = elapsedRealtime / 700;
            cTR();
            for (int i2 = 0; i2 < i; i2++) {
                fVar = (f) arrayList.get(i2);
                zArr[fVar.tVA][fVar.tVB] = true;
            }
            obj = (i <= 0 || i >= size) ? null : 1;
            if (obj != null) {
                float f2 = ((float) (elapsedRealtime % 700)) / 700.0f;
                fVar = (f) arrayList.get(i - 1);
                float HE2 = HE(fVar.tVB);
                float HF2 = HF(fVar.tVA);
                fVar = (f) arrayList.get(i);
                HE = (HE(fVar.tVB) - HE2) * f2;
                HF = (HF(fVar.tVA) - HF2) * f2;
                this.tWA = HE2 + HE;
                this.tWB = HF + HF2;
            }
            invalidate();
        }
        this.tWh.setColor(this.lDV);
        this.tWh.setStrokeWidth((float) this.tWp);
        Path path = this.tWi;
        path.rewind();
        obj = (this.tWt || this.tWv == b.Wrong) ? 1 : null;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        float f3 = this.tWE;
        float f4 = this.tWF;
        boolean z = (this.tWg.getFlags() & 2) != 0;
        this.tWg.setFilterBitmap(true);
        elapsedRealtime = 0;
        while (true) {
            i = elapsedRealtime;
            if (i >= 3) {
                break;
            }
            f = (((float) i) * f4) + ((float) paddingTop);
            for (elapsedRealtime = 0; elapsedRealtime < 3; elapsedRealtime++) {
                float f5 = ((float) paddingLeft) + (((float) elapsedRealtime) * f3);
                if (!zArr[i][elapsedRealtime]) {
                    a(canvas, (int) f5, (int) f, zArr[i][elapsedRealtime]);
                }
            }
            elapsedRealtime = i + 1;
        }
        if (obj != null) {
            Object obj2 = null;
            for (elapsedRealtime = 0; elapsedRealtime < size; elapsedRealtime++) {
                fVar = (f) arrayList.get(elapsedRealtime);
                if (!zArr[fVar.tVA][fVar.tVB]) {
                    break;
                }
                obj2 = 1;
                f = HE(fVar.tVB);
                HF = HF(fVar.tVA);
                if (elapsedRealtime == 0) {
                    path.moveTo(f, HF);
                } else {
                    path.lineTo(f, HF);
                }
            }
            if ((this.tWC || this.tWv == b.Animate) && obj2 != null) {
                path.lineTo(this.tWA, this.tWB);
            }
            canvas.drawPath(path, this.tWh);
        }
        int i3 = 0;
        while (true) {
            elapsedRealtime = i3;
            if (elapsedRealtime < 3) {
                HE = (((float) elapsedRealtime) * f4) + ((float) paddingTop);
                for (i3 = 0; i3 < 3; i3++) {
                    float f6 = ((float) paddingLeft) + (((float) i3) * f3);
                    if (zArr[elapsedRealtime][i3]) {
                        a(canvas, (int) f6, (int) HE, zArr[elapsedRealtime][i3]);
                    }
                }
                i3 = elapsedRealtime + 1;
            } else {
                this.tWg.setFilterBitmap(z);
                AppMethodBeat.o(51670);
                return;
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, boolean z) {
        Bitmap bitmap;
        AppMethodBeat.i(51671);
        if (!z || (!this.tWt && this.tWv != b.Wrong)) {
            bitmap = tWw;
        } else if (this.tWC) {
            bitmap = tWx;
        } else if (this.tWv == b.Wrong) {
            bitmap = tWz;
        } else if (this.tWv == b.Correct || this.tWv == b.Animate) {
            bitmap = tWy;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("unknown display mode " + this.tWv);
            AppMethodBeat.o(51671);
            throw illegalStateException;
        }
        int i3 = this.HB;
        int i4 = this.HC;
        i3 = (int) ((this.tWE - ((float) i3)) * 0.5f);
        i4 = (int) ((this.tWF - ((float) i4)) * 0.5f);
        float f = getResources().getDisplayMetrics().density;
        float min = Math.min((this.tWE - (33.0f * f)) / ((float) this.HB), 1.0f);
        f = Math.min((this.tWF - (f * 33.0f)) / ((float) this.HC), 1.0f);
        this.tWj.setTranslate((float) (i3 + i), (float) (i4 + i2));
        this.tWj.preTranslate((float) (this.HB / 2), (float) (this.HC / 2));
        this.tWj.preScale(min, f);
        this.tWj.preTranslate((float) ((-this.HB) / 2), (float) ((-this.HC) / 2));
        if (!isInEditMode()) {
            canvas.drawBitmap(bitmap, this.tWj, this.tWg);
        }
        AppMethodBeat.o(51671);
    }

    private f ae(float f, float f2) {
        float f3;
        int i = 0;
        AppMethodBeat.i(51672);
        f fVar = null;
        float f4 = this.tWF;
        float f5 = f4 * this.tWr;
        float paddingTop = ((f4 - f5) / 2.0f) + ((float) getPaddingTop());
        int i2 = 0;
        while (i2 < 3) {
            f3 = (((float) i2) * f4) + paddingTop;
            if (f2 >= f3 && f2 <= f3 + f5) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
            f4 = this.tWE;
            f5 = this.tWr * f4;
            paddingTop = ((float) getPaddingLeft()) + ((f4 - f5) / 2.0f);
            while (i < 3) {
                f3 = (((float) i) * f4) + paddingTop;
                if (f >= f3 && f <= f3 + f5) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i >= 0 && !this.tWn[i2][i]) {
                fVar = f.gk(i2, i);
            }
        }
        if (fVar != null) {
            this.tWn[fVar.tVA][fVar.tVB] = true;
            this.tWm.add(fVar);
            if (this.tWG != null) {
                ArrayList arrayList = new ArrayList(this.tWm);
            }
            if (this.tWs) {
                performHapticFeedback(1, 3);
            }
            AppMethodBeat.o(51672);
            return fVar;
        }
        AppMethodBeat.o(51672);
        return null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(51673);
        if (this.tWu && isEnabled()) {
            float x;
            float y;
            float HE;
            float f;
            float f2;
            switch (motionEvent.getAction()) {
                case 0:
                    cTS();
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    f ae = ae(x, y);
                    if (ae != null) {
                        this.tWC = true;
                        this.tWv = b.Correct;
                        if (this.tWG != null) {
                        }
                    } else {
                        this.tWC = false;
                    }
                    if (ae != null) {
                        HE = HE(ae.tVB);
                        float HF = HF(ae.tVA);
                        f = this.tWE * 0.5f;
                        f2 = this.tWF * 0.5f;
                        invalidate((int) (HE - f), (int) (HF - f2), (int) (HE + f), (int) (HF + f2));
                    }
                    this.tWA = x;
                    this.tWB = y;
                    AppMethodBeat.o(51673);
                    return true;
                case 1:
                    if (!this.tWm.isEmpty()) {
                        this.tWC = false;
                        if (this.tWG != null) {
                            this.tWG.a(this, new ArrayList(this.tWm));
                        }
                        invalidate();
                    }
                    AppMethodBeat.o(51673);
                    return true;
                case 2:
                    float f3 = (float) this.tWp;
                    int historySize = motionEvent.getHistorySize();
                    this.tWk.setEmpty();
                    Object obj = null;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < historySize + 1) {
                            HE = i2 < historySize ? motionEvent.getHistoricalX(i2) : motionEvent.getX();
                            y = i2 < historySize ? motionEvent.getHistoricalY(i2) : motionEvent.getY();
                            f ae2 = ae(HE, y);
                            int size = this.tWm.size();
                            if (ae2 != null && size == 1) {
                                this.tWC = true;
                            }
                            x = Math.abs(HE - this.tWA);
                            f2 = Math.abs(y - this.tWB);
                            if (x > 0.0f || f2 > 0.0f) {
                                obj = 1;
                            }
                            if (this.tWC && size > 0) {
                                f fVar = (f) this.tWm.get(size - 1);
                                f = HE(fVar.tVB);
                                float HF2 = HF(fVar.tVA);
                                x = Math.min(f, HE) - f3;
                                f2 = Math.max(f, HE) + f3;
                                HE = Math.min(HF2, y) - f3;
                                f = Math.max(HF2, y) + f3;
                                if (ae2 != null) {
                                    y = this.tWE * 0.5f;
                                    HF2 = this.tWF * 0.5f;
                                    float HE2 = HE(ae2.tVB);
                                    float HF3 = HF(ae2.tVA);
                                    x = Math.min(HE2 - y, x);
                                    f2 = Math.max(y + HE2, f2);
                                    y = Math.min(HF3 - HF2, HE);
                                    f = Math.max(HF3 + HF2, f);
                                } else {
                                    y = HE;
                                }
                                this.tWk.union(Math.round(x), Math.round(y), Math.round(f2), Math.round(f));
                            }
                            i = i2 + 1;
                        } else {
                            this.tWA = motionEvent.getX();
                            if (this.tWA < ((float) (getPaddingLeft() + this.tWp))) {
                                this.tWA = (float) (getPaddingLeft() + this.tWp);
                            } else if (this.tWA > ((float) (((getPaddingLeft() + getWidth()) - getPaddingRight()) - this.tWp))) {
                                this.tWA = (float) (((getPaddingLeft() + getWidth()) - getPaddingRight()) - this.tWp);
                            }
                            this.tWB = motionEvent.getY();
                            if (this.tWB < ((float) (getPaddingTop() + this.tWp))) {
                                this.tWB = (float) (getPaddingTop() + this.tWp);
                            } else if (this.tWB > ((float) (((getPaddingTop() + getHeight()) - getPaddingRight()) - this.tWp))) {
                                this.tWB = (float) (((getPaddingTop() + getHeight()) - getPaddingBottom()) - this.tWp);
                            }
                            if (obj != null) {
                                this.tWl.union(this.tWk);
                                invalidate(this.tWl);
                                this.tWl.set(this.tWk);
                            }
                            AppMethodBeat.o(51673);
                            return true;
                        }
                    }
                case 3:
                    if (this.tWC) {
                        this.tWC = false;
                        cTS();
                        if (this.tWG != null) {
                            this.tWG.a(this);
                        }
                    }
                    AppMethodBeat.o(51673);
                    return true;
                default:
                    AppMethodBeat.o(51673);
                    return false;
            }
        }
        AppMethodBeat.o(51673);
        return false;
    }

    public boolean getEnableHapticFeedback() {
        return this.tWs;
    }

    public void setEnableHapticFeedback(boolean z) {
        this.tWs = z;
    }

    public boolean getDisplayLine() {
        return this.tWt;
    }

    public void setDisplayLine(boolean z) {
        AppMethodBeat.i(51674);
        this.tWt = z;
        invalidate();
        AppMethodBeat.o(51674);
    }

    public boolean getEnableInput() {
        return this.tWu;
    }

    public void setEnableInput(boolean z) {
        this.tWu = z;
    }

    public void setOnPatternListener(a aVar) {
        this.tWG = aVar;
    }

    private void cTR() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.tWn[i][i2] = false;
            }
        }
    }

    private float HE(int i) {
        AppMethodBeat.i(51675);
        float paddingLeft = (((float) getPaddingLeft()) + (((float) i) * this.tWE)) + (this.tWE * 0.5f);
        AppMethodBeat.o(51675);
        return paddingLeft;
    }

    private float HF(int i) {
        AppMethodBeat.i(51676);
        float paddingTop = (((float) getPaddingTop()) + (((float) i) * this.tWF)) + (this.tWF * 0.5f);
        AppMethodBeat.o(51676);
        return paddingTop;
    }

    public List<f> getPattern() {
        AppMethodBeat.i(51677);
        ArrayList arrayList = new ArrayList(this.tWm);
        AppMethodBeat.o(51677);
        return arrayList;
    }

    private void a(b bVar, List<f> list) {
        AppMethodBeat.i(51678);
        this.tWm.clear();
        cTR();
        this.tWm.addAll(list);
        Iterator it = this.tWm.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            this.tWn[fVar.tVA][fVar.tVB] = true;
        }
        setDisplayMode(bVar);
        AppMethodBeat.o(51678);
    }

    private void cTS() {
        AppMethodBeat.i(51679);
        this.tWm.clear();
        cTR();
        this.tWv = b.Correct;
        invalidate();
        AppMethodBeat.o(51679);
    }

    public final void cTT() {
        AppMethodBeat.i(51680);
        cTS();
        if (this.tWG != null) {
            this.tWG.a(this);
        }
        AppMethodBeat.o(51680);
    }

    public void setDisplayMode(b bVar) {
        AppMethodBeat.i(51681);
        switch (bVar) {
            case Correct:
                this.lDV = getResources().getColor(R.color.r4);
                break;
            case Wrong:
                this.lDV = getResources().getColor(R.color.r7);
                break;
            case Animate:
                if (this.tWm.size() != 0) {
                    this.tWu = false;
                    this.lDV = getResources().getColor(R.color.r4);
                    f fVar = (f) this.tWm.get(0);
                    this.tWA = HE(fVar.tVB);
                    this.tWB = HF(fVar.tVA);
                    cTR();
                    this.tWD = SystemClock.elapsedRealtime();
                    break;
                }
                IllegalStateException illegalStateException = new IllegalStateException("You should set a pattern before animating.");
                AppMethodBeat.o(51681);
                throw illegalStateException;
        }
        this.tWv = bVar;
        invalidate();
        AppMethodBeat.o(51681);
    }
}
