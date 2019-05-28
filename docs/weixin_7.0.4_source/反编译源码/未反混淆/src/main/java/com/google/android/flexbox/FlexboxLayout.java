package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.flexbox.d.a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlexboxLayout extends ViewGroup implements a {
    private int btA;
    private int btB;
    private int btC;
    private int btD;
    private int btE;
    private int btF;
    private Drawable btG;
    private Drawable btH;
    private int btI;
    private int btJ;
    private int btK;
    private int btL;
    private int[] btM;
    private SparseIntArray btN;
    private c btO;
    private a btP;
    private List<b> bty;

    public static class LayoutParams extends MarginLayoutParams implements FlexItem {
        public static final Creator<LayoutParams> CREATOR = new Creator<LayoutParams>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LayoutParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(54728);
                LayoutParams layoutParams = new LayoutParams(parcel);
                AppMethodBeat.o(54728);
                return layoutParams;
            }
        };
        private int btQ = 1;
        private float btR = 0.0f;
        private float btS = 1.0f;
        private int btT = -1;
        private float btU = -1.0f;
        private boolean btV;
        private int dg;
        private int dh;
        private int di = 16777215;
        private int dj = 16777215;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.i(54729);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.FlexboxLayout_Layout);
            this.btQ = obtainStyledAttributes.getInt(0, 1);
            this.btR = obtainStyledAttributes.getFloat(1, 0.0f);
            this.btS = obtainStyledAttributes.getFloat(2, 1.0f);
            this.btT = obtainStyledAttributes.getInt(4, -1);
            this.btU = obtainStyledAttributes.getFraction(3, 1, 1, -1.0f);
            this.dg = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.dh = obtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.di = obtainStyledAttributes.getDimensionPixelSize(7, 16777215);
            this.dj = obtainStyledAttributes.getDimensionPixelSize(8, 16777215);
            this.btV = obtainStyledAttributes.getBoolean(9, false);
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(54729);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.btQ = layoutParams.btQ;
            this.btR = layoutParams.btR;
            this.btS = layoutParams.btS;
            this.btT = layoutParams.btT;
            this.btU = layoutParams.btU;
            this.dg = layoutParams.dg;
            this.dh = layoutParams.dh;
            this.di = layoutParams.di;
            this.dj = layoutParams.dj;
            this.btV = layoutParams.btV;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getOrder() {
            return this.btQ;
        }

        public final float ub() {
            return this.btR;
        }

        public final float uc() {
            return this.btS;
        }

        public final int ud() {
            return this.btT;
        }

        public final int getMinWidth() {
            return this.dg;
        }

        public final int getMinHeight() {
            return this.dh;
        }

        public final int getMaxWidth() {
            return this.di;
        }

        public final int getMaxHeight() {
            return this.dj;
        }

        public final boolean ue() {
            return this.btV;
        }

        public final float uf() {
            return this.btU;
        }

        public final int ug() {
            return this.leftMargin;
        }

        public final int uh() {
            return this.topMargin;
        }

        public final int ui() {
            return this.rightMargin;
        }

        public final int uj() {
            return this.bottomMargin;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(54730);
            parcel.writeInt(this.btQ);
            parcel.writeFloat(this.btR);
            parcel.writeFloat(this.btS);
            parcel.writeInt(this.btT);
            parcel.writeFloat(this.btU);
            parcel.writeInt(this.dg);
            parcel.writeInt(this.dh);
            parcel.writeInt(this.di);
            parcel.writeInt(this.dj);
            parcel.writeByte(this.btV ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
            AppMethodBeat.o(54730);
        }

        protected LayoutParams(Parcel parcel) {
            boolean z = true;
            super(0, 0);
            AppMethodBeat.i(54731);
            this.btQ = parcel.readInt();
            this.btR = parcel.readFloat();
            this.btS = parcel.readFloat();
            this.btT = parcel.readInt();
            this.btU = parcel.readFloat();
            this.dg = parcel.readInt();
            this.dh = parcel.readInt();
            this.di = parcel.readInt();
            this.dj = parcel.readInt();
            if (parcel.readByte() == (byte) 0) {
                z = false;
            }
            this.btV = z;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
            AppMethodBeat.o(54731);
        }

        static {
            AppMethodBeat.i(54732);
            AppMethodBeat.o(54732);
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(54733);
        this.btF = -1;
        this.btO = new c(this);
        this.bty = new ArrayList();
        this.btP = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.FlexboxLayout, i, 0);
        this.btA = obtainStyledAttributes.getInt(0, 0);
        this.btB = obtainStyledAttributes.getInt(1, 0);
        this.btC = obtainStyledAttributes.getInt(2, 0);
        this.btD = obtainStyledAttributes.getInt(3, 4);
        this.btE = obtainStyledAttributes.getInt(4, 5);
        this.btF = obtainStyledAttributes.getInt(11, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(5);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        drawable = obtainStyledAttributes.getDrawable(6);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
        }
        drawable = obtainStyledAttributes.getDrawable(7);
        if (drawable != null) {
            setDividerDrawableVertical(drawable);
        }
        int i2 = obtainStyledAttributes.getInt(8, 0);
        if (i2 != 0) {
            this.btJ = i2;
            this.btI = i2;
        }
        i2 = obtainStyledAttributes.getInt(10, 0);
        if (i2 != 0) {
            this.btJ = i2;
        }
        i2 = obtainStyledAttributes.getInt(9, 0);
        if (i2 != 0) {
            this.btI = i2;
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(54733);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(54734);
        if (this.btN == null) {
            this.btN = new SparseIntArray(getChildCount());
        }
        if (this.btO.b(this.btN)) {
            this.btM = this.btO.a(this.btN);
        }
        switch (this.btA) {
            case 0:
            case 1:
                ae(i, i2);
                AppMethodBeat.o(54734);
                return;
            case 2:
            case 3:
                this.bty.clear();
                this.btP.reset();
                this.btO.a(this.btP, i, i2);
                this.bty = this.btP.bty;
                this.btO.bk(i, i2);
                this.btO.y(i, i2, getPaddingLeft() + getPaddingRight());
                this.btO.ul();
                o(this.btA, i, i2, this.btP.btz);
                AppMethodBeat.o(54734);
                return;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.btA);
                AppMethodBeat.o(54734);
                throw illegalStateException;
        }
    }

    public int getFlexItemCount() {
        AppMethodBeat.i(54735);
        int childCount = getChildCount();
        AppMethodBeat.o(54735);
        return childCount;
    }

    public final View eU(int i) {
        AppMethodBeat.i(54736);
        View childAt = getChildAt(i);
        AppMethodBeat.o(54736);
        return childAt;
    }

    private View fc(int i) {
        AppMethodBeat.i(54737);
        if (i < 0 || i >= this.btM.length) {
            AppMethodBeat.o(54737);
            return null;
        }
        View childAt = getChildAt(this.btM[i]);
        AppMethodBeat.o(54737);
        return childAt;
    }

    public final View eV(int i) {
        AppMethodBeat.i(54738);
        View fc = fc(i);
        AppMethodBeat.o(54738);
        return fc;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(54739);
        if (this.btN == null) {
            this.btN = new SparseIntArray(getChildCount());
        }
        this.btM = this.btO.a(view, i, layoutParams, this.btN);
        super.addView(view, i, layoutParams);
        AppMethodBeat.o(54739);
    }

    private void ae(int i, int i2) {
        AppMethodBeat.i(54740);
        this.bty.clear();
        this.btP.reset();
        this.btO.a(this.btP, i, i2, (int) BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, null);
        this.bty = this.btP.bty;
        this.btO.x(i, i2, 0);
        if (this.btD == 3) {
            for (b bVar : this.bty) {
                int i3 = j.INVALID_ID;
                for (int i4 = 0; i4 < bVar.apt; i4++) {
                    View fc = fc(bVar.btr + i4);
                    if (!(fc == null || fc.getVisibility() == 8)) {
                        LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                        if (this.btB != 2) {
                            i3 = Math.max(i3, layoutParams.bottomMargin + (fc.getMeasuredHeight() + Math.max(bVar.bto - fc.getBaseline(), layoutParams.topMargin)));
                        } else {
                            i3 = Math.max(i3, (layoutParams.topMargin + fc.getMeasuredHeight()) + Math.max((bVar.bto - fc.getMeasuredHeight()) + fc.getBaseline(), layoutParams.bottomMargin));
                        }
                    }
                }
                bVar.btk = i3;
            }
        }
        this.btO.y(i, i2, getPaddingTop() + getPaddingBottom());
        this.btO.eY(0);
        o(this.btA, i, i2, this.btP.btz);
        AppMethodBeat.o(54740);
    }

    private void o(int i, int i2, int i3, int i4) {
        int paddingBottom;
        int largestMainSize;
        IllegalStateException illegalStateException;
        AppMethodBeat.i(54741);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i3);
        int size2 = MeasureSpec.getSize(i3);
        switch (i) {
            case 0:
            case 1:
                paddingBottom = getPaddingBottom() + (getSumOfCrossSize() + getPaddingTop());
                largestMainSize = getLargestMainSize();
                break;
            case 2:
            case 3:
                paddingBottom = getLargestMainSize();
                largestMainSize = (getSumOfCrossSize() + getPaddingLeft()) + getPaddingRight();
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
                AppMethodBeat.o(54741);
                throw illegalArgumentException;
        }
        switch (mode) {
            case j.INVALID_ID /*-2147483648*/:
                if (size < largestMainSize) {
                    i4 = View.combineMeasuredStates(i4, 16777216);
                } else {
                    size = largestMainSize;
                }
                largestMainSize = View.resolveSizeAndState(size, i2, i4);
                size = i4;
                mode = largestMainSize;
                break;
            case 0:
                size = i4;
                mode = View.resolveSizeAndState(largestMainSize, i2, i4);
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                if (size < largestMainSize) {
                    i4 = View.combineMeasuredStates(i4, 16777216);
                }
                largestMainSize = View.resolveSizeAndState(size, i2, i4);
                size = i4;
                mode = largestMainSize;
                break;
            default:
                illegalStateException = new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
                AppMethodBeat.o(54741);
                throw illegalStateException;
        }
        switch (mode2) {
            case j.INVALID_ID /*-2147483648*/:
                if (size2 < paddingBottom) {
                    size = View.combineMeasuredStates(size, 256);
                    largestMainSize = size2;
                } else {
                    largestMainSize = paddingBottom;
                }
                size = View.resolveSizeAndState(largestMainSize, i3, size);
                break;
            case 0:
                size = View.resolveSizeAndState(paddingBottom, i3, size);
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                if (size2 < paddingBottom) {
                    size = View.combineMeasuredStates(size, 256);
                }
                size = View.resolveSizeAndState(size2, i3, size);
                break;
            default:
                illegalStateException = new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
                AppMethodBeat.o(54741);
                throw illegalStateException;
        }
        setMeasuredDimension(mode, size);
        AppMethodBeat.o(54741);
    }

    public int getLargestMainSize() {
        AppMethodBeat.i(54742);
        int i = j.INVALID_ID;
        Iterator it = this.bty.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, ((b) it.next()).bti);
            } else {
                AppMethodBeat.o(54742);
                return i2;
            }
        }
    }

    public int getSumOfCrossSize() {
        AppMethodBeat.i(54743);
        int size = this.bty.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.bty.get(i2);
            if (fd(i2)) {
                if (ua()) {
                    i += this.btK;
                } else {
                    i += this.btL;
                }
            }
            if (ff(i2)) {
                if (ua()) {
                    i += this.btK;
                } else {
                    i += this.btL;
                }
            }
            i += bVar.btk;
        }
        AppMethodBeat.o(54743);
        return i;
    }

    public final boolean ua() {
        return this.btA == 0 || this.btA == 1;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = false;
        boolean z3 = true;
        AppMethodBeat.i(54744);
        int T = s.T(this);
        boolean z4;
        boolean z5;
        switch (this.btA) {
            case 0:
                b(T == 1, i, i2, i3, i4);
                AppMethodBeat.o(54744);
                return;
            case 1:
                if (T != 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                b(z4, i, i2, i3, i4);
                AppMethodBeat.o(54744);
                return;
            case 2:
                z5 = T == 1;
                if (this.btB == 2) {
                    if (z5) {
                        z3 = false;
                    }
                    z4 = z3;
                } else {
                    z4 = z5;
                }
                a(z4, false, i, i2, i3, i4);
                AppMethodBeat.o(54744);
                return;
            case 3:
                z5 = T == 1;
                if (this.btB == 2) {
                    if (!z5) {
                        z2 = true;
                    }
                    z4 = z2;
                } else {
                    z4 = z5;
                }
                a(z4, true, i, i2, i3, i4);
                AppMethodBeat.o(54744);
                return;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.btA);
                AppMethodBeat.o(54744);
                throw illegalStateException;
        }
    }

    private void b(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(54745);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int size = this.bty.size();
        while (true) {
            int i7 = i6;
            if (i7 < size) {
                float f;
                float f2;
                b bVar = (b) this.bty.get(i7);
                if (fd(i7)) {
                    paddingBottom -= this.btK;
                    paddingTop += this.btK;
                }
                float f3 = 0.0f;
                switch (this.btC) {
                    case 0:
                        f = (float) paddingLeft;
                        f2 = (float) (i5 - paddingRight);
                        break;
                    case 1:
                        f = (float) ((i5 - bVar.bti) + paddingRight);
                        f2 = (float) (bVar.bti - paddingLeft);
                        break;
                    case 2:
                        f = (((float) (i5 - bVar.bti)) / 2.0f) + ((float) paddingLeft);
                        f2 = ((float) (i5 - paddingRight)) - (((float) (i5 - bVar.bti)) / 2.0f);
                        break;
                    case 3:
                        f = (float) paddingLeft;
                        i6 = bVar.uk();
                        f3 = ((float) (i5 - bVar.bti)) / (i6 != 1 ? (float) (i6 - 1) : 1.0f);
                        f2 = (float) (i5 - paddingRight);
                        break;
                    case 4:
                        i6 = bVar.uk();
                        if (i6 != 0) {
                            f3 = ((float) (i5 - bVar.bti)) / ((float) i6);
                        }
                        f = (f3 / 2.0f) + ((float) paddingLeft);
                        f2 = ((float) (i5 - paddingRight)) - (f3 / 2.0f);
                        break;
                    case 5:
                        i6 = bVar.uk();
                        if (i6 != 0) {
                            f3 = ((float) (i5 - bVar.bti)) / ((float) (i6 + 1));
                        }
                        f = ((float) paddingLeft) + f3;
                        f2 = ((float) (i5 - paddingRight)) - f3;
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.btC);
                        AppMethodBeat.o(54745);
                        throw illegalStateException;
                }
                float max = Math.max(f3, 0.0f);
                int i8 = 0;
                float f4 = f2;
                while (i8 < bVar.apt) {
                    int i9 = bVar.btr + i8;
                    View fc = fc(i9);
                    if (!(fc == null || fc.getVisibility() == 8)) {
                        float f5;
                        float f6;
                        LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                        f += (float) layoutParams.leftMargin;
                        f2 = f4 - ((float) layoutParams.rightMargin);
                        int i10 = 0;
                        int i11 = 0;
                        if (bm(i9, i8)) {
                            i10 = this.btL;
                            f5 = f2 - ((float) i10);
                            f6 = f + ((float) i10);
                        } else {
                            f5 = f2;
                            f6 = f;
                        }
                        if (i8 == bVar.apt - 1 && (this.btJ & 4) > 0) {
                            i11 = this.btL;
                        }
                        if (this.btB == 2) {
                            if (z) {
                                this.btO.a(fc, bVar, Math.round(f5) - fc.getMeasuredWidth(), paddingBottom - fc.getMeasuredHeight(), Math.round(f5), paddingBottom);
                            } else {
                                this.btO.a(fc, bVar, Math.round(f6), paddingBottom - fc.getMeasuredHeight(), Math.round(f6) + fc.getMeasuredWidth(), paddingBottom);
                            }
                        } else if (z) {
                            this.btO.a(fc, bVar, Math.round(f5) - fc.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + fc.getMeasuredHeight());
                        } else {
                            this.btO.a(fc, bVar, Math.round(f6), paddingTop, Math.round(f6) + fc.getMeasuredWidth(), paddingTop + fc.getMeasuredHeight());
                        }
                        f = f6 + ((((float) fc.getMeasuredWidth()) + max) + ((float) layoutParams.rightMargin));
                        f4 = f5 - ((((float) fc.getMeasuredWidth()) + max) + ((float) layoutParams.leftMargin));
                        if (z) {
                            bVar.m(fc, i11, 0, i10, 0);
                        } else {
                            bVar.m(fc, i10, 0, i11, 0);
                        }
                    }
                    i8++;
                    f4 = f4;
                }
                paddingTop += bVar.btk;
                paddingBottom -= bVar.btk;
                i6 = i7 + 1;
            } else {
                AppMethodBeat.o(54745);
                return;
            }
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(54746);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        paddingRight = 0;
        int size = this.bty.size();
        while (true) {
            int i7 = paddingRight;
            if (i7 < size) {
                float f;
                float f2;
                b bVar = (b) this.bty.get(i7);
                if (fd(i7)) {
                    paddingLeft += this.btL;
                    i6 -= this.btL;
                }
                float f3 = 0.0f;
                int uk;
                switch (this.btC) {
                    case 0:
                        f = (float) paddingTop;
                        f2 = (float) (i5 - paddingBottom);
                        break;
                    case 1:
                        f = (float) ((i5 - bVar.bti) + paddingBottom);
                        f2 = (float) (bVar.bti - paddingTop);
                        break;
                    case 2:
                        f = (((float) (i5 - bVar.bti)) / 2.0f) + ((float) paddingTop);
                        f2 = ((float) (i5 - paddingBottom)) - (((float) (i5 - bVar.bti)) / 2.0f);
                        break;
                    case 3:
                        f = (float) paddingTop;
                        paddingRight = bVar.uk();
                        f3 = ((float) (i5 - bVar.bti)) / (paddingRight != 1 ? (float) (paddingRight - 1) : 1.0f);
                        f2 = (float) (i5 - paddingBottom);
                        break;
                    case 4:
                        uk = bVar.uk();
                        if (uk != 0) {
                            f3 = ((float) (i5 - bVar.bti)) / ((float) uk);
                        }
                        f = (f3 / 2.0f) + ((float) paddingTop);
                        f2 = ((float) (i5 - paddingBottom)) - (f3 / 2.0f);
                        break;
                    case 5:
                        uk = bVar.uk();
                        if (uk != 0) {
                            f3 = ((float) (i5 - bVar.bti)) / ((float) (uk + 1));
                        }
                        f = ((float) paddingTop) + f3;
                        f2 = ((float) (i5 - paddingBottom)) - f3;
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.btC);
                        AppMethodBeat.o(54746);
                        throw illegalStateException;
                }
                float max = Math.max(f3, 0.0f);
                paddingRight = 0;
                while (true) {
                    int i8 = paddingRight;
                    float f4 = f2;
                    if (i8 < bVar.apt) {
                        int i9 = bVar.btr + i8;
                        View fc = fc(i9);
                        if (!(fc == null || fc.getVisibility() == 8)) {
                            float f5;
                            float f6;
                            LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                            f += (float) layoutParams.topMargin;
                            f3 = f4 - ((float) layoutParams.bottomMargin);
                            int i10 = 0;
                            int i11 = 0;
                            if (bm(i9, i8)) {
                                i10 = this.btK;
                                f5 = f3 - ((float) i10);
                                f6 = f + ((float) i10);
                            } else {
                                f5 = f3;
                                f6 = f;
                            }
                            if (i8 == bVar.apt - 1 && (this.btI & 4) > 0) {
                                i11 = this.btK;
                            }
                            if (z) {
                                if (z2) {
                                    this.btO.a(fc, bVar, true, i6 - fc.getMeasuredWidth(), Math.round(f5) - fc.getMeasuredHeight(), i6, Math.round(f5));
                                } else {
                                    this.btO.a(fc, bVar, true, i6 - fc.getMeasuredWidth(), Math.round(f6), i6, Math.round(f6) + fc.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.btO.a(fc, bVar, false, paddingLeft, Math.round(f5) - fc.getMeasuredHeight(), paddingLeft + fc.getMeasuredWidth(), Math.round(f5));
                            } else {
                                this.btO.a(fc, bVar, false, paddingLeft, Math.round(f6), paddingLeft + fc.getMeasuredWidth(), Math.round(f6) + fc.getMeasuredHeight());
                            }
                            f = f6 + ((((float) fc.getMeasuredHeight()) + max) + ((float) layoutParams.bottomMargin));
                            f4 = f5 - ((((float) fc.getMeasuredHeight()) + max) + ((float) layoutParams.topMargin));
                            if (z2) {
                                bVar.m(fc, 0, i11, 0, i10);
                            } else {
                                bVar.m(fc, 0, i10, 0, i11);
                            }
                        }
                        f2 = f4;
                        paddingRight = i8 + 1;
                    } else {
                        paddingLeft += bVar.btk;
                        i6 -= bVar.btk;
                        paddingRight = i7 + 1;
                    }
                }
            } else {
                AppMethodBeat.o(54746);
                return;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(54747);
        if (this.btH == null && this.btG == null) {
            AppMethodBeat.o(54747);
        } else if (this.btI == 0 && this.btJ == 0) {
            AppMethodBeat.o(54747);
        } else {
            int T = s.T(this);
            boolean z3;
            switch (this.btA) {
                case 0:
                    z3 = T == 1;
                    if (this.btB != 2) {
                        z2 = false;
                    }
                    a(canvas, z3, z2);
                    AppMethodBeat.o(54747);
                    return;
                case 1:
                    z3 = T != 1;
                    if (this.btB != 2) {
                        z2 = false;
                    }
                    a(canvas, z3, z2);
                    AppMethodBeat.o(54747);
                    return;
                case 2:
                    z3 = T == 1;
                    if (this.btB != 2) {
                        z2 = z3;
                    } else if (z3) {
                        z2 = false;
                    }
                    b(canvas, z2, false);
                    AppMethodBeat.o(54747);
                    return;
                case 3:
                    if (T == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (this.btB != 2) {
                        z = z3;
                    } else if (!z3) {
                        z = true;
                    }
                    b(canvas, z, true);
                    break;
            }
            AppMethodBeat.o(54747);
        }
    }

    private void a(Canvas canvas, boolean z, boolean z2) {
        AppMethodBeat.i(54748);
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.bty.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.bty.get(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bVar.apt) {
                    break;
                }
                int i4 = bVar.btr + i3;
                View fc = fc(i4);
                if (!(fc == null || fc.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                    if (bm(i4, i3)) {
                        if (z) {
                            i4 = fc.getRight() + layoutParams.rightMargin;
                        } else {
                            i4 = (fc.getLeft() - layoutParams.leftMargin) - this.btL;
                        }
                        a(canvas, i4, bVar.xL, bVar.btk);
                    }
                    if (i3 == bVar.apt - 1 && (this.btJ & 4) > 0) {
                        if (z) {
                            i2 = (fc.getLeft() - layoutParams.leftMargin) - this.btL;
                        } else {
                            i2 = layoutParams.rightMargin + fc.getRight();
                        }
                        a(canvas, i2, bVar.xL, bVar.btk);
                    }
                }
                i2 = i3 + 1;
            }
            if (fd(i)) {
                if (z2) {
                    i2 = bVar.xN;
                } else {
                    i2 = bVar.xL - this.btK;
                }
                b(canvas, paddingLeft, i2, max);
            }
            if (ff(i) && (this.btI & 4) > 0) {
                int i5;
                if (z2) {
                    i5 = bVar.xL - this.btK;
                } else {
                    i5 = bVar.xN;
                }
                b(canvas, paddingLeft, i5, max);
            }
        }
        AppMethodBeat.o(54748);
    }

    private void b(Canvas canvas, boolean z, boolean z2) {
        AppMethodBeat.i(54749);
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.bty.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.bty.get(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bVar.apt) {
                    break;
                }
                int i4 = bVar.btr + i3;
                View fc = fc(i4);
                if (!(fc == null || fc.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                    if (bm(i4, i3)) {
                        if (z2) {
                            i4 = fc.getBottom() + layoutParams.bottomMargin;
                        } else {
                            i4 = (fc.getTop() - layoutParams.topMargin) - this.btK;
                        }
                        b(canvas, bVar.xJ, i4, bVar.btk);
                    }
                    if (i3 == bVar.apt - 1 && (this.btI & 4) > 0) {
                        if (z2) {
                            i2 = (fc.getTop() - layoutParams.topMargin) - this.btK;
                        } else {
                            i2 = layoutParams.bottomMargin + fc.getBottom();
                        }
                        b(canvas, bVar.xJ, i2, bVar.btk);
                    }
                }
                i2 = i3 + 1;
            }
            if (fd(i)) {
                if (z) {
                    i2 = bVar.xM;
                } else {
                    i2 = bVar.xJ - this.btL;
                }
                a(canvas, i2, paddingTop, max);
            }
            if (ff(i) && (this.btJ & 4) > 0) {
                int i5;
                if (z) {
                    i5 = bVar.xJ - this.btL;
                } else {
                    i5 = bVar.xM;
                }
                a(canvas, i5, paddingTop, max);
            }
        }
        AppMethodBeat.o(54749);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        AppMethodBeat.i(54750);
        if (this.btH == null) {
            AppMethodBeat.o(54750);
            return;
        }
        this.btH.setBounds(i, i2, this.btL + i, i2 + i3);
        this.btH.draw(canvas);
        AppMethodBeat.o(54750);
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        AppMethodBeat.i(54751);
        if (this.btG == null) {
            AppMethodBeat.o(54751);
            return;
        }
        this.btG.setBounds(i, i2, i + i3, this.btK + i2);
        this.btG.draw(canvas);
        AppMethodBeat.o(54751);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(54752);
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams3 = new LayoutParams((LayoutParams) layoutParams);
            AppMethodBeat.o(54752);
            return layoutParams3;
        } else if (layoutParams instanceof MarginLayoutParams) {
            layoutParams2 = new LayoutParams((MarginLayoutParams) layoutParams);
            AppMethodBeat.o(54752);
            return layoutParams2;
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
            AppMethodBeat.o(54752);
            return layoutParams2;
        }
    }

    public int getFlexDirection() {
        return this.btA;
    }

    public void setFlexDirection(int i) {
        AppMethodBeat.i(54753);
        if (this.btA != i) {
            this.btA = i;
            requestLayout();
        }
        AppMethodBeat.o(54753);
    }

    public int getFlexWrap() {
        return this.btB;
    }

    public void setFlexWrap(int i) {
        AppMethodBeat.i(54754);
        if (this.btB != i) {
            this.btB = i;
            requestLayout();
        }
        AppMethodBeat.o(54754);
    }

    public int getJustifyContent() {
        return this.btC;
    }

    public void setJustifyContent(int i) {
        AppMethodBeat.i(54755);
        if (this.btC != i) {
            this.btC = i;
            requestLayout();
        }
        AppMethodBeat.o(54755);
    }

    public int getAlignItems() {
        return this.btD;
    }

    public void setAlignItems(int i) {
        AppMethodBeat.i(54756);
        if (this.btD != i) {
            this.btD = i;
            requestLayout();
        }
        AppMethodBeat.o(54756);
    }

    public int getAlignContent() {
        return this.btE;
    }

    public void setAlignContent(int i) {
        AppMethodBeat.i(54757);
        if (this.btE != i) {
            this.btE = i;
            requestLayout();
        }
        AppMethodBeat.o(54757);
    }

    public int getMaxLine() {
        return this.btF;
    }

    public void setMaxLine(int i) {
        AppMethodBeat.i(54758);
        if (this.btF != i) {
            this.btF = i;
            requestLayout();
        }
        AppMethodBeat.o(54758);
    }

    public List<b> getFlexLines() {
        AppMethodBeat.i(54759);
        ArrayList arrayList = new ArrayList(this.bty.size());
        for (b bVar : this.bty) {
            if (bVar.uk() != 0) {
                arrayList.add(bVar);
            }
        }
        AppMethodBeat.o(54759);
        return arrayList;
    }

    public final int m(View view, int i, int i2) {
        AppMethodBeat.i(54760);
        int i3 = 0;
        if (ua()) {
            if (bm(i, i2)) {
                i3 = this.btL + 0;
            }
            if ((this.btJ & 4) > 0) {
                i3 += this.btL;
            }
        } else {
            if (bm(i, i2)) {
                i3 = this.btK + 0;
            }
            if ((this.btI & 4) > 0) {
                i3 += this.btK;
            }
        }
        AppMethodBeat.o(54760);
        return i3;
    }

    public final int ca(View view) {
        return 0;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(54761);
        if (ua()) {
            if ((this.btJ & 4) > 0) {
                bVar.bti += this.btL;
                bVar.btj += this.btL;
                AppMethodBeat.o(54761);
                return;
            }
        } else if ((this.btI & 4) > 0) {
            bVar.bti += this.btK;
            bVar.btj += this.btK;
        }
        AppMethodBeat.o(54761);
    }

    public final int v(int i, int i2, int i3) {
        AppMethodBeat.i(54762);
        int childMeasureSpec = getChildMeasureSpec(i, i2, i3);
        AppMethodBeat.o(54762);
        return childMeasureSpec;
    }

    public final int w(int i, int i2, int i3) {
        AppMethodBeat.i(54763);
        int childMeasureSpec = getChildMeasureSpec(i, i2, i3);
        AppMethodBeat.o(54763);
        return childMeasureSpec;
    }

    public final void a(View view, int i, int i2, b bVar) {
        AppMethodBeat.i(54764);
        if (bm(i, i2)) {
            if (ua()) {
                bVar.bti += this.btL;
                bVar.btj += this.btL;
                AppMethodBeat.o(54764);
                return;
            }
            bVar.bti += this.btK;
            bVar.btj += this.btK;
        }
        AppMethodBeat.o(54764);
    }

    public void setFlexLines(List<b> list) {
        this.bty = list;
    }

    public List<b> getFlexLinesInternal() {
        return this.bty;
    }

    public final void a(int i, View view) {
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.btG;
    }

    public Drawable getDividerDrawableVertical() {
        return this.btH;
    }

    public void setDividerDrawable(Drawable drawable) {
        AppMethodBeat.i(54765);
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
        AppMethodBeat.o(54765);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        AppMethodBeat.i(54766);
        if (drawable == this.btG) {
            AppMethodBeat.o(54766);
            return;
        }
        this.btG = drawable;
        if (drawable != null) {
            this.btK = drawable.getIntrinsicHeight();
        } else {
            this.btK = 0;
        }
        um();
        requestLayout();
        AppMethodBeat.o(54766);
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        AppMethodBeat.i(54767);
        if (drawable == this.btH) {
            AppMethodBeat.o(54767);
            return;
        }
        this.btH = drawable;
        if (drawable != null) {
            this.btL = drawable.getIntrinsicWidth();
        } else {
            this.btL = 0;
        }
        um();
        requestLayout();
        AppMethodBeat.o(54767);
    }

    public int getShowDividerVertical() {
        return this.btJ;
    }

    public int getShowDividerHorizontal() {
        return this.btI;
    }

    public void setShowDivider(int i) {
        AppMethodBeat.i(54768);
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
        AppMethodBeat.o(54768);
    }

    public void setShowDividerVertical(int i) {
        AppMethodBeat.i(54769);
        if (i != this.btJ) {
            this.btJ = i;
            requestLayout();
        }
        AppMethodBeat.o(54769);
    }

    public void setShowDividerHorizontal(int i) {
        AppMethodBeat.i(54770);
        if (i != this.btI) {
            this.btI = i;
            requestLayout();
        }
        AppMethodBeat.o(54770);
    }

    private void um() {
        AppMethodBeat.i(54771);
        if (this.btG == null && this.btH == null) {
            setWillNotDraw(true);
            AppMethodBeat.o(54771);
            return;
        }
        setWillNotDraw(false);
        AppMethodBeat.o(54771);
    }

    private boolean bm(int i, int i2) {
        AppMethodBeat.i(54772);
        if (bn(i, i2)) {
            if (ua()) {
                if ((this.btJ & 1) != 0) {
                    AppMethodBeat.o(54772);
                    return true;
                }
                AppMethodBeat.o(54772);
                return false;
            } else if ((this.btI & 1) != 0) {
                AppMethodBeat.o(54772);
                return true;
            } else {
                AppMethodBeat.o(54772);
                return false;
            }
        } else if (ua()) {
            if ((this.btJ & 2) != 0) {
                AppMethodBeat.o(54772);
                return true;
            }
            AppMethodBeat.o(54772);
            return false;
        } else if ((this.btI & 2) != 0) {
            AppMethodBeat.o(54772);
            return true;
        } else {
            AppMethodBeat.o(54772);
            return false;
        }
    }

    private boolean bn(int i, int i2) {
        AppMethodBeat.i(54773);
        int i3 = 1;
        while (i3 <= i2) {
            View fc = fc(i - i3);
            if (fc == null || fc.getVisibility() == 8) {
                i3++;
            } else {
                AppMethodBeat.o(54773);
                return false;
            }
        }
        AppMethodBeat.o(54773);
        return true;
    }

    private boolean fd(int i) {
        AppMethodBeat.i(54774);
        if (i < 0 || i >= this.bty.size()) {
            AppMethodBeat.o(54774);
            return false;
        } else if (fe(i)) {
            if (ua()) {
                if ((this.btI & 1) != 0) {
                    AppMethodBeat.o(54774);
                    return true;
                }
                AppMethodBeat.o(54774);
                return false;
            } else if ((this.btJ & 1) != 0) {
                AppMethodBeat.o(54774);
                return true;
            } else {
                AppMethodBeat.o(54774);
                return false;
            }
        } else if (ua()) {
            if ((this.btI & 2) != 0) {
                AppMethodBeat.o(54774);
                return true;
            }
            AppMethodBeat.o(54774);
            return false;
        } else if ((this.btJ & 2) != 0) {
            AppMethodBeat.o(54774);
            return true;
        } else {
            AppMethodBeat.o(54774);
            return false;
        }
    }

    private boolean fe(int i) {
        AppMethodBeat.i(54775);
        for (int i2 = 0; i2 < i; i2++) {
            if (((b) this.bty.get(i2)).uk() > 0) {
                AppMethodBeat.o(54775);
                return false;
            }
        }
        AppMethodBeat.o(54775);
        return true;
    }

    private boolean ff(int i) {
        AppMethodBeat.i(54776);
        if (i < 0 || i >= this.bty.size()) {
            AppMethodBeat.o(54776);
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.bty.size()) {
                if (((b) this.bty.get(i3)).uk() > 0) {
                    AppMethodBeat.o(54776);
                    return false;
                }
                i2 = i3 + 1;
            } else if (ua()) {
                if ((this.btI & 4) != 0) {
                    AppMethodBeat.o(54776);
                    return true;
                }
                AppMethodBeat.o(54776);
                return false;
            } else if ((this.btJ & 4) != 0) {
                AppMethodBeat.o(54776);
                return true;
            } else {
                AppMethodBeat.o(54776);
                return false;
            }
        }
    }
}
