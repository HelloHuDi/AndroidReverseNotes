package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.flexbox.C25566d.C25567a;
import com.google.android.flexbox.C37287c.C17696a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlexboxLayout extends ViewGroup implements C45055a {
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
    private C37287c btO;
    private C17696a btP;
    private List<C41633b> bty;

    public static class LayoutParams extends MarginLayoutParams implements FlexItem {
        public static final Creator<LayoutParams> CREATOR = new C87211();
        private int btQ = 1;
        private float btR = 0.0f;
        private float btS = 1.0f;
        private int btT = -1;
        private float btU = -1.0f;
        private boolean btV;
        /* renamed from: dg */
        private int f2436dg;
        /* renamed from: dh */
        private int f2437dh;
        /* renamed from: di */
        private int f2438di = 16777215;
        /* renamed from: dj */
        private int f2439dj = 16777215;

        /* renamed from: com.google.android.flexbox.FlexboxLayout$LayoutParams$1 */
        static class C87211 implements Creator<LayoutParams> {
            C87211() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LayoutParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(54728);
                LayoutParams layoutParams = new LayoutParams(parcel);
                AppMethodBeat.m2505o(54728);
                return layoutParams;
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.m2504i(54729);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25567a.FlexboxLayout_Layout);
            this.btQ = obtainStyledAttributes.getInt(0, 1);
            this.btR = obtainStyledAttributes.getFloat(1, 0.0f);
            this.btS = obtainStyledAttributes.getFloat(2, 1.0f);
            this.btT = obtainStyledAttributes.getInt(4, -1);
            this.btU = obtainStyledAttributes.getFraction(3, 1, 1, -1.0f);
            this.f2436dg = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.f2437dh = obtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.f2438di = obtainStyledAttributes.getDimensionPixelSize(7, 16777215);
            this.f2439dj = obtainStyledAttributes.getDimensionPixelSize(8, 16777215);
            this.btV = obtainStyledAttributes.getBoolean(9, false);
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(54729);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.btQ = layoutParams.btQ;
            this.btR = layoutParams.btR;
            this.btS = layoutParams.btS;
            this.btT = layoutParams.btT;
            this.btU = layoutParams.btU;
            this.f2436dg = layoutParams.f2436dg;
            this.f2437dh = layoutParams.f2437dh;
            this.f2438di = layoutParams.f2438di;
            this.f2439dj = layoutParams.f2439dj;
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

        /* renamed from: ub */
        public final float mo19313ub() {
            return this.btR;
        }

        /* renamed from: uc */
        public final float mo19314uc() {
            return this.btS;
        }

        /* renamed from: ud */
        public final int mo19315ud() {
            return this.btT;
        }

        public final int getMinWidth() {
            return this.f2436dg;
        }

        public final int getMinHeight() {
            return this.f2437dh;
        }

        public final int getMaxWidth() {
            return this.f2438di;
        }

        public final int getMaxHeight() {
            return this.f2439dj;
        }

        /* renamed from: ue */
        public final boolean mo19316ue() {
            return this.btV;
        }

        /* renamed from: uf */
        public final float mo19317uf() {
            return this.btU;
        }

        /* renamed from: ug */
        public final int mo19318ug() {
            return this.leftMargin;
        }

        /* renamed from: uh */
        public final int mo19319uh() {
            return this.topMargin;
        }

        /* renamed from: ui */
        public final int mo19320ui() {
            return this.rightMargin;
        }

        /* renamed from: uj */
        public final int mo19321uj() {
            return this.bottomMargin;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(54730);
            parcel.writeInt(this.btQ);
            parcel.writeFloat(this.btR);
            parcel.writeFloat(this.btS);
            parcel.writeInt(this.btT);
            parcel.writeFloat(this.btU);
            parcel.writeInt(this.f2436dg);
            parcel.writeInt(this.f2437dh);
            parcel.writeInt(this.f2438di);
            parcel.writeInt(this.f2439dj);
            parcel.writeByte(this.btV ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
            AppMethodBeat.m2505o(54730);
        }

        protected LayoutParams(Parcel parcel) {
            boolean z = true;
            super(0, 0);
            AppMethodBeat.m2504i(54731);
            this.btQ = parcel.readInt();
            this.btR = parcel.readFloat();
            this.btS = parcel.readFloat();
            this.btT = parcel.readInt();
            this.btU = parcel.readFloat();
            this.f2436dg = parcel.readInt();
            this.f2437dh = parcel.readInt();
            this.f2438di = parcel.readInt();
            this.f2439dj = parcel.readInt();
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
            AppMethodBeat.m2505o(54731);
        }

        static {
            AppMethodBeat.m2504i(54732);
            AppMethodBeat.m2505o(54732);
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(54733);
        this.btF = -1;
        this.btO = new C37287c(this);
        this.bty = new ArrayList();
        this.btP = new C17696a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25567a.FlexboxLayout, i, 0);
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
        AppMethodBeat.m2505o(54733);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(54734);
        if (this.btN == null) {
            this.btN = new SparseIntArray(getChildCount());
        }
        if (this.btO.mo59563b(this.btN)) {
            this.btM = this.btO.mo59560a(this.btN);
        }
        switch (this.btA) {
            case 0:
            case 1:
                m15499ae(i, i2);
                AppMethodBeat.m2505o(54734);
                return;
            case 2:
            case 3:
                this.bty.clear();
                this.btP.reset();
                this.btO.mo59557a(this.btP, i, i2);
                this.bty = this.btP.bty;
                this.btO.mo59564bk(i, i2);
                this.btO.mo59574y(i, i2, getPaddingLeft() + getPaddingRight());
                this.btO.mo59572ul();
                m15509o(this.btA, i, i2, this.btP.btz);
                AppMethodBeat.m2505o(54734);
                return;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.btA);
                AppMethodBeat.m2505o(54734);
                throw illegalStateException;
        }
    }

    public int getFlexItemCount() {
        AppMethodBeat.m2504i(54735);
        int childCount = getChildCount();
        AppMethodBeat.m2505o(54735);
        return childCount;
    }

    /* renamed from: eU */
    public final View mo19330eU(int i) {
        AppMethodBeat.m2504i(54736);
        View childAt = getChildAt(i);
        AppMethodBeat.m2505o(54736);
        return childAt;
    }

    /* renamed from: fc */
    private View m15505fc(int i) {
        AppMethodBeat.m2504i(54737);
        if (i < 0 || i >= this.btM.length) {
            AppMethodBeat.m2505o(54737);
            return null;
        }
        View childAt = getChildAt(this.btM[i]);
        AppMethodBeat.m2505o(54737);
        return childAt;
    }

    /* renamed from: eV */
    public final View mo19331eV(int i) {
        AppMethodBeat.m2504i(54738);
        View fc = m15505fc(i);
        AppMethodBeat.m2505o(54738);
        return fc;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(54739);
        if (this.btN == null) {
            this.btN = new SparseIntArray(getChildCount());
        }
        this.btM = this.btO.mo59561a(view, i, layoutParams, this.btN);
        super.addView(view, i, layoutParams);
        AppMethodBeat.m2505o(54739);
    }

    /* renamed from: ae */
    private void m15499ae(int i, int i2) {
        AppMethodBeat.m2504i(54740);
        this.bty.clear();
        this.btP.reset();
        this.btO.mo59558a(this.btP, i, i2, (int) BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, null);
        this.bty = this.btP.bty;
        this.btO.mo59573x(i, i2, 0);
        if (this.btD == 3) {
            for (C41633b c41633b : this.bty) {
                int i3 = C8415j.INVALID_ID;
                for (int i4 = 0; i4 < c41633b.apt; i4++) {
                    View fc = m15505fc(c41633b.btr + i4);
                    if (!(fc == null || fc.getVisibility() == 8)) {
                        LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                        if (this.btB != 2) {
                            i3 = Math.max(i3, layoutParams.bottomMargin + (fc.getMeasuredHeight() + Math.max(c41633b.bto - fc.getBaseline(), layoutParams.topMargin)));
                        } else {
                            i3 = Math.max(i3, (layoutParams.topMargin + fc.getMeasuredHeight()) + Math.max((c41633b.bto - fc.getMeasuredHeight()) + fc.getBaseline(), layoutParams.bottomMargin));
                        }
                    }
                }
                c41633b.btk = i3;
            }
        }
        this.btO.mo59574y(i, i2, getPaddingTop() + getPaddingBottom());
        this.btO.mo59568eY(0);
        m15509o(this.btA, i, i2, this.btP.btz);
        AppMethodBeat.m2505o(54740);
    }

    /* renamed from: o */
    private void m15509o(int i, int i2, int i3, int i4) {
        int paddingBottom;
        int largestMainSize;
        IllegalStateException illegalStateException;
        AppMethodBeat.m2504i(54741);
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
                AppMethodBeat.m2505o(54741);
                throw illegalArgumentException;
        }
        switch (mode) {
            case C8415j.INVALID_ID /*-2147483648*/:
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
                AppMethodBeat.m2505o(54741);
                throw illegalStateException;
        }
        switch (mode2) {
            case C8415j.INVALID_ID /*-2147483648*/:
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
                AppMethodBeat.m2505o(54741);
                throw illegalStateException;
        }
        setMeasuredDimension(mode, size);
        AppMethodBeat.m2505o(54741);
    }

    public int getLargestMainSize() {
        AppMethodBeat.m2504i(54742);
        int i = C8415j.INVALID_ID;
        Iterator it = this.bty.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = Math.max(i2, ((C41633b) it.next()).bti);
            } else {
                AppMethodBeat.m2505o(54742);
                return i2;
            }
        }
    }

    public int getSumOfCrossSize() {
        AppMethodBeat.m2504i(54743);
        int size = this.bty.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C41633b c41633b = (C41633b) this.bty.get(i2);
            if (m15506fd(i2)) {
                if (mo19366ua()) {
                    i += this.btK;
                } else {
                    i += this.btL;
                }
            }
            if (m15508ff(i2)) {
                if (mo19366ua()) {
                    i += this.btK;
                } else {
                    i += this.btL;
                }
            }
            i += c41633b.btk;
        }
        AppMethodBeat.m2505o(54743);
        return i;
    }

    /* renamed from: ua */
    public final boolean mo19366ua() {
        return this.btA == 0 || this.btA == 1;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = false;
        boolean z3 = true;
        AppMethodBeat.m2504i(54744);
        int T = C0477s.m893T(this);
        boolean z4;
        boolean z5;
        switch (this.btA) {
            case 0:
                m15502b(T == 1, i, i2, i3, i4);
                AppMethodBeat.m2505o(54744);
                return;
            case 1:
                if (T != 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                m15502b(z4, i, i2, i3, i4);
                AppMethodBeat.m2505o(54744);
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
                m15498a(z4, false, i, i2, i3, i4);
                AppMethodBeat.m2505o(54744);
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
                m15498a(z4, true, i, i2, i3, i4);
                AppMethodBeat.m2505o(54744);
                return;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.btA);
                AppMethodBeat.m2505o(54744);
                throw illegalStateException;
        }
    }

    /* renamed from: b */
    private void m15502b(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(54745);
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
                C41633b c41633b = (C41633b) this.bty.get(i7);
                if (m15506fd(i7)) {
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
                        f = (float) ((i5 - c41633b.bti) + paddingRight);
                        f2 = (float) (c41633b.bti - paddingLeft);
                        break;
                    case 2:
                        f = (((float) (i5 - c41633b.bti)) / 2.0f) + ((float) paddingLeft);
                        f2 = ((float) (i5 - paddingRight)) - (((float) (i5 - c41633b.bti)) / 2.0f);
                        break;
                    case 3:
                        f = (float) paddingLeft;
                        i6 = c41633b.mo66770uk();
                        f3 = ((float) (i5 - c41633b.bti)) / (i6 != 1 ? (float) (i6 - 1) : 1.0f);
                        f2 = (float) (i5 - paddingRight);
                        break;
                    case 4:
                        i6 = c41633b.mo66770uk();
                        if (i6 != 0) {
                            f3 = ((float) (i5 - c41633b.bti)) / ((float) i6);
                        }
                        f = (f3 / 2.0f) + ((float) paddingLeft);
                        f2 = ((float) (i5 - paddingRight)) - (f3 / 2.0f);
                        break;
                    case 5:
                        i6 = c41633b.mo66770uk();
                        if (i6 != 0) {
                            f3 = ((float) (i5 - c41633b.bti)) / ((float) (i6 + 1));
                        }
                        f = ((float) paddingLeft) + f3;
                        f2 = ((float) (i5 - paddingRight)) - f3;
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.btC);
                        AppMethodBeat.m2505o(54745);
                        throw illegalStateException;
                }
                float max = Math.max(f3, 0.0f);
                int i8 = 0;
                float f4 = f2;
                while (i8 < c41633b.apt) {
                    int i9 = c41633b.btr + i8;
                    View fc = m15505fc(i9);
                    if (!(fc == null || fc.getVisibility() == 8)) {
                        float f5;
                        float f6;
                        LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                        f += (float) layoutParams.leftMargin;
                        f2 = f4 - ((float) layoutParams.rightMargin);
                        int i10 = 0;
                        int i11 = 0;
                        if (m15503bm(i9, i8)) {
                            i10 = this.btL;
                            f5 = f2 - ((float) i10);
                            f6 = f + ((float) i10);
                        } else {
                            f5 = f2;
                            f6 = f;
                        }
                        if (i8 == c41633b.apt - 1 && (this.btJ & 4) > 0) {
                            i11 = this.btL;
                        }
                        if (this.btB == 2) {
                            if (z) {
                                this.btO.mo59555a(fc, c41633b, Math.round(f5) - fc.getMeasuredWidth(), paddingBottom - fc.getMeasuredHeight(), Math.round(f5), paddingBottom);
                            } else {
                                this.btO.mo59555a(fc, c41633b, Math.round(f6), paddingBottom - fc.getMeasuredHeight(), Math.round(f6) + fc.getMeasuredWidth(), paddingBottom);
                            }
                        } else if (z) {
                            this.btO.mo59555a(fc, c41633b, Math.round(f5) - fc.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + fc.getMeasuredHeight());
                        } else {
                            this.btO.mo59555a(fc, c41633b, Math.round(f6), paddingTop, Math.round(f6) + fc.getMeasuredWidth(), paddingTop + fc.getMeasuredHeight());
                        }
                        f = f6 + ((((float) fc.getMeasuredWidth()) + max) + ((float) layoutParams.rightMargin));
                        f4 = f5 - ((((float) fc.getMeasuredWidth()) + max) + ((float) layoutParams.leftMargin));
                        if (z) {
                            c41633b.mo66769m(fc, i11, 0, i10, 0);
                        } else {
                            c41633b.mo66769m(fc, i10, 0, i11, 0);
                        }
                    }
                    i8++;
                    f4 = f4;
                }
                paddingTop += c41633b.btk;
                paddingBottom -= c41633b.btk;
                i6 = i7 + 1;
            } else {
                AppMethodBeat.m2505o(54745);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m15498a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(54746);
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
                C41633b c41633b = (C41633b) this.bty.get(i7);
                if (m15506fd(i7)) {
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
                        f = (float) ((i5 - c41633b.bti) + paddingBottom);
                        f2 = (float) (c41633b.bti - paddingTop);
                        break;
                    case 2:
                        f = (((float) (i5 - c41633b.bti)) / 2.0f) + ((float) paddingTop);
                        f2 = ((float) (i5 - paddingBottom)) - (((float) (i5 - c41633b.bti)) / 2.0f);
                        break;
                    case 3:
                        f = (float) paddingTop;
                        paddingRight = c41633b.mo66770uk();
                        f3 = ((float) (i5 - c41633b.bti)) / (paddingRight != 1 ? (float) (paddingRight - 1) : 1.0f);
                        f2 = (float) (i5 - paddingBottom);
                        break;
                    case 4:
                        uk = c41633b.mo66770uk();
                        if (uk != 0) {
                            f3 = ((float) (i5 - c41633b.bti)) / ((float) uk);
                        }
                        f = (f3 / 2.0f) + ((float) paddingTop);
                        f2 = ((float) (i5 - paddingBottom)) - (f3 / 2.0f);
                        break;
                    case 5:
                        uk = c41633b.mo66770uk();
                        if (uk != 0) {
                            f3 = ((float) (i5 - c41633b.bti)) / ((float) (uk + 1));
                        }
                        f = ((float) paddingTop) + f3;
                        f2 = ((float) (i5 - paddingBottom)) - f3;
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.btC);
                        AppMethodBeat.m2505o(54746);
                        throw illegalStateException;
                }
                float max = Math.max(f3, 0.0f);
                paddingRight = 0;
                while (true) {
                    int i8 = paddingRight;
                    float f4 = f2;
                    if (i8 < c41633b.apt) {
                        int i9 = c41633b.btr + i8;
                        View fc = m15505fc(i9);
                        if (!(fc == null || fc.getVisibility() == 8)) {
                            float f5;
                            float f6;
                            LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                            f += (float) layoutParams.topMargin;
                            f3 = f4 - ((float) layoutParams.bottomMargin);
                            int i10 = 0;
                            int i11 = 0;
                            if (m15503bm(i9, i8)) {
                                i10 = this.btK;
                                f5 = f3 - ((float) i10);
                                f6 = f + ((float) i10);
                            } else {
                                f5 = f3;
                                f6 = f;
                            }
                            if (i8 == c41633b.apt - 1 && (this.btI & 4) > 0) {
                                i11 = this.btK;
                            }
                            if (z) {
                                if (z2) {
                                    this.btO.mo59556a(fc, c41633b, true, i6 - fc.getMeasuredWidth(), Math.round(f5) - fc.getMeasuredHeight(), i6, Math.round(f5));
                                } else {
                                    this.btO.mo59556a(fc, c41633b, true, i6 - fc.getMeasuredWidth(), Math.round(f6), i6, Math.round(f6) + fc.getMeasuredHeight());
                                }
                            } else if (z2) {
                                this.btO.mo59556a(fc, c41633b, false, paddingLeft, Math.round(f5) - fc.getMeasuredHeight(), paddingLeft + fc.getMeasuredWidth(), Math.round(f5));
                            } else {
                                this.btO.mo59556a(fc, c41633b, false, paddingLeft, Math.round(f6), paddingLeft + fc.getMeasuredWidth(), Math.round(f6) + fc.getMeasuredHeight());
                            }
                            f = f6 + ((((float) fc.getMeasuredHeight()) + max) + ((float) layoutParams.bottomMargin));
                            f4 = f5 - ((((float) fc.getMeasuredHeight()) + max) + ((float) layoutParams.topMargin));
                            if (z2) {
                                c41633b.mo66769m(fc, 0, i11, 0, i10);
                            } else {
                                c41633b.mo66769m(fc, 0, i10, 0, i11);
                            }
                        }
                        f2 = f4;
                        paddingRight = i8 + 1;
                    } else {
                        paddingLeft += c41633b.btk;
                        i6 -= c41633b.btk;
                        paddingRight = i7 + 1;
                    }
                }
            } else {
                AppMethodBeat.m2505o(54746);
                return;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.m2504i(54747);
        if (this.btH == null && this.btG == null) {
            AppMethodBeat.m2505o(54747);
        } else if (this.btI == 0 && this.btJ == 0) {
            AppMethodBeat.m2505o(54747);
        } else {
            int T = C0477s.m893T(this);
            boolean z3;
            switch (this.btA) {
                case 0:
                    z3 = T == 1;
                    if (this.btB != 2) {
                        z2 = false;
                    }
                    m15497a(canvas, z3, z2);
                    AppMethodBeat.m2505o(54747);
                    return;
                case 1:
                    z3 = T != 1;
                    if (this.btB != 2) {
                        z2 = false;
                    }
                    m15497a(canvas, z3, z2);
                    AppMethodBeat.m2505o(54747);
                    return;
                case 2:
                    z3 = T == 1;
                    if (this.btB != 2) {
                        z2 = z3;
                    } else if (z3) {
                        z2 = false;
                    }
                    m15501b(canvas, z2, false);
                    AppMethodBeat.m2505o(54747);
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
                    m15501b(canvas, z, true);
                    break;
            }
            AppMethodBeat.m2505o(54747);
        }
    }

    /* renamed from: a */
    private void m15497a(Canvas canvas, boolean z, boolean z2) {
        AppMethodBeat.m2504i(54748);
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.bty.size();
        for (int i = 0; i < size; i++) {
            C41633b c41633b = (C41633b) this.bty.get(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= c41633b.apt) {
                    break;
                }
                int i4 = c41633b.btr + i3;
                View fc = m15505fc(i4);
                if (!(fc == null || fc.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                    if (m15503bm(i4, i3)) {
                        if (z) {
                            i4 = fc.getRight() + layoutParams.rightMargin;
                        } else {
                            i4 = (fc.getLeft() - layoutParams.leftMargin) - this.btL;
                        }
                        m15496a(canvas, i4, c41633b.f16874xL, c41633b.btk);
                    }
                    if (i3 == c41633b.apt - 1 && (this.btJ & 4) > 0) {
                        if (z) {
                            i2 = (fc.getLeft() - layoutParams.leftMargin) - this.btL;
                        } else {
                            i2 = layoutParams.rightMargin + fc.getRight();
                        }
                        m15496a(canvas, i2, c41633b.f16874xL, c41633b.btk);
                    }
                }
                i2 = i3 + 1;
            }
            if (m15506fd(i)) {
                if (z2) {
                    i2 = c41633b.f16876xN;
                } else {
                    i2 = c41633b.f16874xL - this.btK;
                }
                m15500b(canvas, paddingLeft, i2, max);
            }
            if (m15508ff(i) && (this.btI & 4) > 0) {
                int i5;
                if (z2) {
                    i5 = c41633b.f16874xL - this.btK;
                } else {
                    i5 = c41633b.f16876xN;
                }
                m15500b(canvas, paddingLeft, i5, max);
            }
        }
        AppMethodBeat.m2505o(54748);
    }

    /* renamed from: b */
    private void m15501b(Canvas canvas, boolean z, boolean z2) {
        AppMethodBeat.m2504i(54749);
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.bty.size();
        for (int i = 0; i < size; i++) {
            C41633b c41633b = (C41633b) this.bty.get(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= c41633b.apt) {
                    break;
                }
                int i4 = c41633b.btr + i3;
                View fc = m15505fc(i4);
                if (!(fc == null || fc.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) fc.getLayoutParams();
                    if (m15503bm(i4, i3)) {
                        if (z2) {
                            i4 = fc.getBottom() + layoutParams.bottomMargin;
                        } else {
                            i4 = (fc.getTop() - layoutParams.topMargin) - this.btK;
                        }
                        m15500b(canvas, c41633b.f16873xJ, i4, c41633b.btk);
                    }
                    if (i3 == c41633b.apt - 1 && (this.btI & 4) > 0) {
                        if (z2) {
                            i2 = (fc.getTop() - layoutParams.topMargin) - this.btK;
                        } else {
                            i2 = layoutParams.bottomMargin + fc.getBottom();
                        }
                        m15500b(canvas, c41633b.f16873xJ, i2, c41633b.btk);
                    }
                }
                i2 = i3 + 1;
            }
            if (m15506fd(i)) {
                if (z) {
                    i2 = c41633b.f16875xM;
                } else {
                    i2 = c41633b.f16873xJ - this.btL;
                }
                m15496a(canvas, i2, paddingTop, max);
            }
            if (m15508ff(i) && (this.btJ & 4) > 0) {
                int i5;
                if (z) {
                    i5 = c41633b.f16873xJ - this.btL;
                } else {
                    i5 = c41633b.f16875xM;
                }
                m15496a(canvas, i5, paddingTop, max);
            }
        }
        AppMethodBeat.m2505o(54749);
    }

    /* renamed from: a */
    private void m15496a(Canvas canvas, int i, int i2, int i3) {
        AppMethodBeat.m2504i(54750);
        if (this.btH == null) {
            AppMethodBeat.m2505o(54750);
            return;
        }
        this.btH.setBounds(i, i2, this.btL + i, i2 + i3);
        this.btH.draw(canvas);
        AppMethodBeat.m2505o(54750);
    }

    /* renamed from: b */
    private void m15500b(Canvas canvas, int i, int i2, int i3) {
        AppMethodBeat.m2504i(54751);
        if (this.btG == null) {
            AppMethodBeat.m2505o(54751);
            return;
        }
        this.btG.setBounds(i, i2, i + i3, this.btK + i2);
        this.btG.draw(canvas);
        AppMethodBeat.m2505o(54751);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(54752);
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams3 = new LayoutParams((LayoutParams) layoutParams);
            AppMethodBeat.m2505o(54752);
            return layoutParams3;
        } else if (layoutParams instanceof MarginLayoutParams) {
            layoutParams2 = new LayoutParams((MarginLayoutParams) layoutParams);
            AppMethodBeat.m2505o(54752);
            return layoutParams2;
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
            AppMethodBeat.m2505o(54752);
            return layoutParams2;
        }
    }

    public int getFlexDirection() {
        return this.btA;
    }

    public void setFlexDirection(int i) {
        AppMethodBeat.m2504i(54753);
        if (this.btA != i) {
            this.btA = i;
            requestLayout();
        }
        AppMethodBeat.m2505o(54753);
    }

    public int getFlexWrap() {
        return this.btB;
    }

    public void setFlexWrap(int i) {
        AppMethodBeat.m2504i(54754);
        if (this.btB != i) {
            this.btB = i;
            requestLayout();
        }
        AppMethodBeat.m2505o(54754);
    }

    public int getJustifyContent() {
        return this.btC;
    }

    public void setJustifyContent(int i) {
        AppMethodBeat.m2504i(54755);
        if (this.btC != i) {
            this.btC = i;
            requestLayout();
        }
        AppMethodBeat.m2505o(54755);
    }

    public int getAlignItems() {
        return this.btD;
    }

    public void setAlignItems(int i) {
        AppMethodBeat.m2504i(54756);
        if (this.btD != i) {
            this.btD = i;
            requestLayout();
        }
        AppMethodBeat.m2505o(54756);
    }

    public int getAlignContent() {
        return this.btE;
    }

    public void setAlignContent(int i) {
        AppMethodBeat.m2504i(54757);
        if (this.btE != i) {
            this.btE = i;
            requestLayout();
        }
        AppMethodBeat.m2505o(54757);
    }

    public int getMaxLine() {
        return this.btF;
    }

    public void setMaxLine(int i) {
        AppMethodBeat.m2504i(54758);
        if (this.btF != i) {
            this.btF = i;
            requestLayout();
        }
        AppMethodBeat.m2505o(54758);
    }

    public List<C41633b> getFlexLines() {
        AppMethodBeat.m2504i(54759);
        ArrayList arrayList = new ArrayList(this.bty.size());
        for (C41633b c41633b : this.bty) {
            if (c41633b.mo66770uk() != 0) {
                arrayList.add(c41633b);
            }
        }
        AppMethodBeat.m2505o(54759);
        return arrayList;
    }

    /* renamed from: m */
    public final int mo19349m(View view, int i, int i2) {
        AppMethodBeat.m2504i(54760);
        int i3 = 0;
        if (mo19366ua()) {
            if (m15503bm(i, i2)) {
                i3 = this.btL + 0;
            }
            if ((this.btJ & 4) > 0) {
                i3 += this.btL;
            }
        } else {
            if (m15503bm(i, i2)) {
                i3 = this.btK + 0;
            }
            if ((this.btI & 4) > 0) {
                i3 += this.btK;
            }
        }
        AppMethodBeat.m2505o(54760);
        return i3;
    }

    /* renamed from: ca */
    public final int mo19328ca(View view) {
        return 0;
    }

    /* renamed from: a */
    public final void mo19326a(C41633b c41633b) {
        AppMethodBeat.m2504i(54761);
        if (mo19366ua()) {
            if ((this.btJ & 4) > 0) {
                c41633b.bti += this.btL;
                c41633b.btj += this.btL;
                AppMethodBeat.m2505o(54761);
                return;
            }
        } else if ((this.btI & 4) > 0) {
            c41633b.bti += this.btK;
            c41633b.btj += this.btK;
        }
        AppMethodBeat.m2505o(54761);
    }

    /* renamed from: v */
    public final int mo19367v(int i, int i2, int i3) {
        AppMethodBeat.m2504i(54762);
        int childMeasureSpec = getChildMeasureSpec(i, i2, i3);
        AppMethodBeat.m2505o(54762);
        return childMeasureSpec;
    }

    /* renamed from: w */
    public final int mo19368w(int i, int i2, int i3) {
        AppMethodBeat.m2504i(54763);
        int childMeasureSpec = getChildMeasureSpec(i, i2, i3);
        AppMethodBeat.m2505o(54763);
        return childMeasureSpec;
    }

    /* renamed from: a */
    public final void mo19325a(View view, int i, int i2, C41633b c41633b) {
        AppMethodBeat.m2504i(54764);
        if (m15503bm(i, i2)) {
            if (mo19366ua()) {
                c41633b.bti += this.btL;
                c41633b.btj += this.btL;
                AppMethodBeat.m2505o(54764);
                return;
            }
            c41633b.bti += this.btK;
            c41633b.btj += this.btK;
        }
        AppMethodBeat.m2505o(54764);
    }

    public void setFlexLines(List<C41633b> list) {
        this.bty = list;
    }

    public List<C41633b> getFlexLinesInternal() {
        return this.bty;
    }

    /* renamed from: a */
    public final void mo19324a(int i, View view) {
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.btG;
    }

    public Drawable getDividerDrawableVertical() {
        return this.btH;
    }

    public void setDividerDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(54765);
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
        AppMethodBeat.m2505o(54765);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        AppMethodBeat.m2504i(54766);
        if (drawable == this.btG) {
            AppMethodBeat.m2505o(54766);
            return;
        }
        this.btG = drawable;
        if (drawable != null) {
            this.btK = drawable.getIntrinsicHeight();
        } else {
            this.btK = 0;
        }
        m15510um();
        requestLayout();
        AppMethodBeat.m2505o(54766);
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        AppMethodBeat.m2504i(54767);
        if (drawable == this.btH) {
            AppMethodBeat.m2505o(54767);
            return;
        }
        this.btH = drawable;
        if (drawable != null) {
            this.btL = drawable.getIntrinsicWidth();
        } else {
            this.btL = 0;
        }
        m15510um();
        requestLayout();
        AppMethodBeat.m2505o(54767);
    }

    public int getShowDividerVertical() {
        return this.btJ;
    }

    public int getShowDividerHorizontal() {
        return this.btI;
    }

    public void setShowDivider(int i) {
        AppMethodBeat.m2504i(54768);
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
        AppMethodBeat.m2505o(54768);
    }

    public void setShowDividerVertical(int i) {
        AppMethodBeat.m2504i(54769);
        if (i != this.btJ) {
            this.btJ = i;
            requestLayout();
        }
        AppMethodBeat.m2505o(54769);
    }

    public void setShowDividerHorizontal(int i) {
        AppMethodBeat.m2504i(54770);
        if (i != this.btI) {
            this.btI = i;
            requestLayout();
        }
        AppMethodBeat.m2505o(54770);
    }

    /* renamed from: um */
    private void m15510um() {
        AppMethodBeat.m2504i(54771);
        if (this.btG == null && this.btH == null) {
            setWillNotDraw(true);
            AppMethodBeat.m2505o(54771);
            return;
        }
        setWillNotDraw(false);
        AppMethodBeat.m2505o(54771);
    }

    /* renamed from: bm */
    private boolean m15503bm(int i, int i2) {
        AppMethodBeat.m2504i(54772);
        if (m15504bn(i, i2)) {
            if (mo19366ua()) {
                if ((this.btJ & 1) != 0) {
                    AppMethodBeat.m2505o(54772);
                    return true;
                }
                AppMethodBeat.m2505o(54772);
                return false;
            } else if ((this.btI & 1) != 0) {
                AppMethodBeat.m2505o(54772);
                return true;
            } else {
                AppMethodBeat.m2505o(54772);
                return false;
            }
        } else if (mo19366ua()) {
            if ((this.btJ & 2) != 0) {
                AppMethodBeat.m2505o(54772);
                return true;
            }
            AppMethodBeat.m2505o(54772);
            return false;
        } else if ((this.btI & 2) != 0) {
            AppMethodBeat.m2505o(54772);
            return true;
        } else {
            AppMethodBeat.m2505o(54772);
            return false;
        }
    }

    /* renamed from: bn */
    private boolean m15504bn(int i, int i2) {
        AppMethodBeat.m2504i(54773);
        int i3 = 1;
        while (i3 <= i2) {
            View fc = m15505fc(i - i3);
            if (fc == null || fc.getVisibility() == 8) {
                i3++;
            } else {
                AppMethodBeat.m2505o(54773);
                return false;
            }
        }
        AppMethodBeat.m2505o(54773);
        return true;
    }

    /* renamed from: fd */
    private boolean m15506fd(int i) {
        AppMethodBeat.m2504i(54774);
        if (i < 0 || i >= this.bty.size()) {
            AppMethodBeat.m2505o(54774);
            return false;
        } else if (m15507fe(i)) {
            if (mo19366ua()) {
                if ((this.btI & 1) != 0) {
                    AppMethodBeat.m2505o(54774);
                    return true;
                }
                AppMethodBeat.m2505o(54774);
                return false;
            } else if ((this.btJ & 1) != 0) {
                AppMethodBeat.m2505o(54774);
                return true;
            } else {
                AppMethodBeat.m2505o(54774);
                return false;
            }
        } else if (mo19366ua()) {
            if ((this.btI & 2) != 0) {
                AppMethodBeat.m2505o(54774);
                return true;
            }
            AppMethodBeat.m2505o(54774);
            return false;
        } else if ((this.btJ & 2) != 0) {
            AppMethodBeat.m2505o(54774);
            return true;
        } else {
            AppMethodBeat.m2505o(54774);
            return false;
        }
    }

    /* renamed from: fe */
    private boolean m15507fe(int i) {
        AppMethodBeat.m2504i(54775);
        for (int i2 = 0; i2 < i; i2++) {
            if (((C41633b) this.bty.get(i2)).mo66770uk() > 0) {
                AppMethodBeat.m2505o(54775);
                return false;
            }
        }
        AppMethodBeat.m2505o(54775);
        return true;
    }

    /* renamed from: ff */
    private boolean m15508ff(int i) {
        AppMethodBeat.m2504i(54776);
        if (i < 0 || i >= this.bty.size()) {
            AppMethodBeat.m2505o(54776);
            return false;
        }
        int i2 = i + 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.bty.size()) {
                if (((C41633b) this.bty.get(i3)).mo66770uk() > 0) {
                    AppMethodBeat.m2505o(54776);
                    return false;
                }
                i2 = i3 + 1;
            } else if (mo19366ua()) {
                if ((this.btI & 4) != 0) {
                    AppMethodBeat.m2505o(54776);
                    return true;
                }
                AppMethodBeat.m2505o(54776);
                return false;
            } else if ((this.btJ & 4) != 0) {
                AppMethodBeat.m2505o(54776);
                return true;
            } else {
                AppMethodBeat.m2505o(54776);
                return false;
            }
        }
    }
}
