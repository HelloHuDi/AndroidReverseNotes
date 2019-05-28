package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.j;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ah;
import android.support.v7.widget.am;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class FlexboxLayoutManager extends i implements android.support.v7.widget.RecyclerView.r.b, a {
    static final /* synthetic */ boolean $assertionsDisabled = (!FlexboxLayoutManager.class.desiredAssertionStatus());
    private static final Rect btW = new Rect();
    private am alA;
    private int alG;
    private int alH;
    private boolean alI;
    private s anY;
    private o anc;
    private int btA;
    private int btB;
    private int btC;
    private int btD;
    private int btF;
    private final c btO;
    private a btP;
    private boolean btX;
    private b btY;
    private a btZ;
    private List<b> bty;
    private am bua;
    private SavedState bub;
    private int buc;
    private int bud;
    private SparseArray<View> bue;
    private View bug;
    private int buh;
    private boolean hq;
    private final Context mContext;

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams implements FlexItem {
        public static final Creator<LayoutParams> CREATOR = new Creator<LayoutParams>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LayoutParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(54783);
                LayoutParams layoutParams = new LayoutParams(parcel);
                AppMethodBeat.o(54783);
                return layoutParams;
            }
        };
        private float btR = 0.0f;
        private float btS = 1.0f;
        private int btT = -1;
        private float btU = -1.0f;
        private boolean btV;
        private int dg;
        private int dh;
        private int di = 16777215;
        private int dj = 16777215;

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
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

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-2, -2);
        }

        public final int getOrder() {
            return 1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(54784);
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
            AppMethodBeat.o(54784);
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            AppMethodBeat.i(54785);
            this.btR = parcel.readFloat();
            this.btS = parcel.readFloat();
            this.btT = parcel.readInt();
            this.btU = parcel.readFloat();
            this.dg = parcel.readInt();
            this.dh = parcel.readInt();
            this.di = parcel.readInt();
            this.dj = parcel.readInt();
            this.btV = parcel.readByte() != (byte) 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
            AppMethodBeat.o(54785);
        }

        static {
            AppMethodBeat.i(54786);
            AppMethodBeat.o(54786);
        }
    }

    class a {
        static final /* synthetic */ boolean $assertionsDisabled = (!FlexboxLayoutManager.class.desiredAssertionStatus());
        private int alN;
        private boolean alO;
        private boolean alP;
        private int bui;
        private int buj;
        private boolean buk;
        final /* synthetic */ FlexboxLayoutManager bul;
        private int mPosition;

        static {
            AppMethodBeat.i(54782);
            AppMethodBeat.o(54782);
        }

        public final String toString() {
            AppMethodBeat.i(54778);
            String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.bui + ", mCoordinate=" + this.alN + ", mPerpendicularCoordinate=" + this.buj + ", mLayoutFromEnd=" + this.alO + ", mValid=" + this.alP + ", mAssignedFromSavedState=" + this.buk + '}';
            AppMethodBeat.o(54778);
            return str;
        }

        static /* synthetic */ void b(a aVar) {
            boolean z = true;
            AppMethodBeat.i(54779);
            aVar.mPosition = -1;
            aVar.bui = -1;
            aVar.alN = j.INVALID_ID;
            aVar.alP = false;
            aVar.buk = false;
            if (aVar.bul.ua()) {
                if (aVar.bul.btB == 0) {
                    if (aVar.bul.btA != 1) {
                        z = false;
                    }
                    aVar.alO = z;
                    AppMethodBeat.o(54779);
                    return;
                }
                if (aVar.bul.btB != 2) {
                    z = false;
                }
                aVar.alO = z;
                AppMethodBeat.o(54779);
            } else if (aVar.bul.btB == 0) {
                if (aVar.bul.btA != 3) {
                    z = false;
                }
                aVar.alO = z;
                AppMethodBeat.o(54779);
            } else {
                if (aVar.bul.btB != 2) {
                    z = false;
                }
                aVar.alO = z;
                AppMethodBeat.o(54779);
            }
        }

        static /* synthetic */ void g(a aVar) {
            AppMethodBeat.i(54780);
            int jf;
            if (aVar.bul.ua() || !aVar.bul.hq) {
                if (aVar.alO) {
                    jf = aVar.bul.alA.jf();
                } else {
                    jf = aVar.bul.alA.je();
                }
                aVar.alN = jf;
                AppMethodBeat.o(54780);
                return;
            }
            if (aVar.alO) {
                jf = aVar.bul.alA.jf();
            } else {
                jf = aVar.bul.mWidth - aVar.bul.alA.je();
            }
            aVar.alN = jf;
            AppMethodBeat.o(54780);
        }
    }

    static class b {
        int Lp;
        int alS;
        int alV;
        int alg;
        int ali;
        boolean alm;
        int bui;
        boolean bum;
        int mPosition;
        int sE;

        private b() {
            this.ali = 1;
            this.sE = 1;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(54787);
            String str = "LayoutState{mAvailable=" + this.alg + ", mFlexLinePosition=" + this.bui + ", mPosition=" + this.mPosition + ", mOffset=" + this.Lp + ", mScrollingOffset=" + this.alS + ", mLastScrollDelta=" + this.alV + ", mItemDirection=" + this.ali + ", mLayoutDirection=" + this.sE + '}';
            AppMethodBeat.o(54787);
            return str;
        }
    }

    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(54788);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(54788);
                return savedState;
            }
        };
        private int alX;
        private int alY;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(54789);
            parcel.writeInt(this.alX);
            parcel.writeInt(this.alY);
            AppMethodBeat.o(54789);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            AppMethodBeat.i(54790);
            this.alX = parcel.readInt();
            this.alY = parcel.readInt();
            AppMethodBeat.o(54790);
        }

        private SavedState(SavedState savedState) {
            this.alX = savedState.alX;
            this.alY = savedState.alY;
        }

        static {
            AppMethodBeat.i(54792);
            AppMethodBeat.o(54792);
        }

        public String toString() {
            AppMethodBeat.i(54791);
            String str = "SavedState{mAnchorPosition=" + this.alX + ", mAnchorOffset=" + this.alY + '}';
            AppMethodBeat.o(54791);
            return str;
        }

        static /* synthetic */ boolean c(SavedState savedState, int i) {
            return savedState.alX >= 0 && savedState.alX < i;
        }
    }

    static {
        AppMethodBeat.i(54865);
        AppMethodBeat.o(54865);
    }

    public int getFlexDirection() {
        return this.btA;
    }

    public int getFlexWrap() {
        return this.btB;
    }

    public int getAlignItems() {
        return this.btD;
    }

    public int getAlignContent() {
        return 5;
    }

    public int getMaxLine() {
        return this.btF;
    }

    public final int m(View view, int i, int i2) {
        AppMethodBeat.i(54793);
        int bD;
        if (ua()) {
            bD = i.bD(view) + i.bE(view);
            AppMethodBeat.o(54793);
            return bD;
        }
        bD = i.bB(view) + i.bC(view);
        AppMethodBeat.o(54793);
        return bD;
    }

    public final int ca(View view) {
        AppMethodBeat.i(54794);
        int bB;
        if (ua()) {
            bB = i.bB(view) + i.bC(view);
            AppMethodBeat.o(54794);
            return bB;
        }
        bB = i.bD(view) + i.bE(view);
        AppMethodBeat.o(54794);
        return bB;
    }

    public final void a(View view, int i, int i2, b bVar) {
        AppMethodBeat.i(54795);
        g(view, btW);
        int bD;
        if (ua()) {
            bD = i.bD(view) + i.bE(view);
            bVar.bti += bD;
            bVar.btj = bD + bVar.btj;
            AppMethodBeat.o(54795);
            return;
        }
        bD = i.bB(view) + i.bC(view);
        bVar.bti += bD;
        bVar.btj = bD + bVar.btj;
        AppMethodBeat.o(54795);
    }

    public int getFlexItemCount() {
        AppMethodBeat.i(54796);
        int itemCount = this.anY.getItemCount();
        AppMethodBeat.o(54796);
        return itemCount;
    }

    public final View eU(int i) {
        AppMethodBeat.i(54797);
        View view = (View) this.bue.get(i);
        if (view != null) {
            AppMethodBeat.o(54797);
            return view;
        }
        view = this.anc.cq(i);
        AppMethodBeat.o(54797);
        return view;
    }

    public final View eV(int i) {
        AppMethodBeat.i(54798);
        View eU = eU(i);
        AppMethodBeat.o(54798);
        return eU;
    }

    public final void a(b bVar) {
    }

    public int getLargestMainSize() {
        AppMethodBeat.i(54801);
        if (this.bty.size() == 0) {
            AppMethodBeat.o(54801);
            return 0;
        }
        int i = j.INVALID_ID;
        int size = this.bty.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, ((b) this.bty.get(i2)).bti);
        }
        AppMethodBeat.o(54801);
        return i;
    }

    public int getSumOfCrossSize() {
        AppMethodBeat.i(54802);
        int i = 0;
        for (int i2 = 0; i2 < this.bty.size(); i2++) {
            i += ((b) this.bty.get(i2)).btk;
        }
        AppMethodBeat.o(54802);
        return i;
    }

    public void setFlexLines(List<b> list) {
        this.bty = list;
    }

    public List<b> getFlexLinesInternal() {
        return this.bty;
    }

    public final void a(int i, View view) {
        AppMethodBeat.i(54803);
        this.bue.put(i, view);
        AppMethodBeat.o(54803);
    }

    public final PointF bX(int i) {
        AppMethodBeat.i(54804);
        if (getChildCount() == 0) {
            AppMethodBeat.o(54804);
            return null;
        }
        int i2 = i < i.bt(getChildAt(0)) ? -1 : 1;
        PointF pointF;
        if (ua()) {
            pointF = new PointF(0.0f, (float) i2);
            AppMethodBeat.o(54804);
            return pointF;
        }
        pointF = new PointF((float) i2, 0.0f);
        AppMethodBeat.o(54804);
        return pointF;
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams iA() {
        AppMethodBeat.i(54805);
        LayoutParams layoutParams = new LayoutParams();
        AppMethodBeat.o(54805);
        return layoutParams;
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(54806);
        LayoutParams layoutParams = new LayoutParams(context, attributeSet);
        AppMethodBeat.o(54806);
        return layoutParams;
    }

    public final boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void jW() {
        AppMethodBeat.i(54807);
        removeAllViews();
        AppMethodBeat.o(54807);
    }

    public final Parcelable onSaveInstanceState() {
        AppMethodBeat.i(54808);
        if (this.bub != null) {
            SavedState savedState = new SavedState(this.bub, (byte) 0);
            AppMethodBeat.o(54808);
            return savedState;
        }
        Parcelable savedState2 = new SavedState();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            savedState2.alX = i.bt(childAt);
            savedState2.alY = this.alA.bf(childAt) - this.alA.je();
        } else {
            savedState2.alX = -1;
        }
        AppMethodBeat.o(54808);
        return savedState2;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(54809);
        if (parcelable instanceof SavedState) {
            this.bub = (SavedState) parcelable;
            requestLayout();
        }
        AppMethodBeat.o(54809);
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(54810);
        super.c(recyclerView, i, i2);
        fg(i);
        AppMethodBeat.o(54810);
    }

    public final void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        AppMethodBeat.i(54811);
        super.a(recyclerView, i, i2, obj);
        fg(i);
        AppMethodBeat.o(54811);
    }

    public final void g(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(54812);
        super.g(recyclerView, i, i2);
        fg(i);
        AppMethodBeat.o(54812);
    }

    public final void d(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(54813);
        super.d(recyclerView, i, i2);
        fg(i);
        AppMethodBeat.o(54813);
    }

    public final void a(RecyclerView recyclerView, int i, int i2, int i3) {
        AppMethodBeat.i(54814);
        super.a(recyclerView, i, i2, i3);
        fg(Math.min(i, i2));
        AppMethodBeat.o(54814);
    }

    private void fg(int i) {
        AppMethodBeat.i(54815);
        int iQ = iQ();
        int iS = iS();
        if (i >= iS) {
            AppMethodBeat.o(54815);
            return;
        }
        int childCount = getChildCount();
        this.btO.fa(childCount);
        this.btO.eZ(childCount);
        this.btO.fb(childCount);
        if (!$assertionsDisabled && this.btO.btv == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(54815);
            throw assertionError;
        } else if (i >= this.btO.btv.length) {
            AppMethodBeat.o(54815);
        } else {
            this.buh = i;
            View iM = iM();
            if (iM == null) {
                AppMethodBeat.o(54815);
            } else if (iQ > i || i > iS) {
                this.alG = i.bt(iM);
                if (ua() || !this.hq) {
                    this.alH = this.alA.bf(iM) - this.alA.je();
                    AppMethodBeat.o(54815);
                    return;
                }
                this.alH = this.alA.bg(iM) + this.alA.getEndPadding();
                AppMethodBeat.o(54815);
            } else {
                AppMethodBeat.o(54815);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:95:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(o oVar, s sVar) {
        AppMethodBeat.i(54816);
        this.anc = oVar;
        this.anY = sVar;
        int itemCount = sVar.getItemCount();
        if (itemCount == 0 && sVar.apv) {
            AppMethodBeat.o(54816);
            return;
        }
        Object obj;
        AssertionError assertionError;
        int i;
        int i2;
        int T = android.support.v4.view.s.T(this.aiB);
        switch (this.btA) {
            case 0:
                this.hq = T == 1;
                this.btX = this.btB == 2;
                break;
            case 1:
                this.hq = T != 1;
                this.btX = this.btB == 2;
                break;
            case 2:
                this.hq = T == 1;
                if (this.btB == 2) {
                    this.hq = !this.hq;
                }
                this.btX = false;
                break;
            case 3:
                this.hq = T == 1;
                if (this.btB == 2) {
                    this.hq = !this.hq;
                }
                this.btX = true;
                break;
            default:
                this.hq = false;
                this.btX = false;
                break;
        }
        uo();
        iJ();
        this.btO.fa(itemCount);
        this.btO.eZ(itemCount);
        this.btO.fb(itemCount);
        this.btY.bum = false;
        if (this.bub != null && SavedState.c(this.bub, itemCount)) {
            this.alG = this.bub.alX;
        }
        if (!(this.btZ.alP && this.alG == -1 && this.bub == null)) {
            a.b(this.btZ);
            a aVar = this.btZ;
            SavedState savedState = this.bub;
            if ($assertionsDisabled || this.btO.btv != null) {
                View bW;
                if (sVar.apv || this.alG == -1) {
                    obj = null;
                } else if (this.alG < 0 || this.alG >= sVar.getItemCount()) {
                    this.alG = -1;
                    this.alH = j.INVALID_ID;
                    obj = null;
                } else {
                    aVar.mPosition = this.alG;
                    aVar.bui = this.btO.btv[aVar.mPosition];
                    if (this.bub != null && SavedState.c(this.bub, sVar.getItemCount())) {
                        aVar.alN = savedState.alY + this.alA.je();
                        aVar.buk = true;
                        aVar.bui = -1;
                    } else if (this.alH == j.INVALID_ID) {
                        bW = bW(this.alG);
                        if (bW == null) {
                            if (getChildCount() > 0) {
                                aVar.alO = this.alG < i.bt(getChildAt(0));
                            }
                            a.g(aVar);
                        } else if (this.alA.bj(bW) > this.alA.jg()) {
                            a.g(aVar);
                        } else if (this.alA.bf(bW) - this.alA.je() < 0) {
                            aVar.alN = this.alA.je();
                            aVar.alO = false;
                        } else if (this.alA.jf() - this.alA.bg(bW) < 0) {
                            aVar.alN = this.alA.jf();
                            aVar.alO = true;
                        } else {
                            if (aVar.alO) {
                                T = this.alA.bg(bW) + this.alA.jd();
                            } else {
                                T = this.alA.bf(bW);
                            }
                            aVar.alN = T;
                        }
                        obj = 1;
                    } else if (ua() || !this.hq) {
                        aVar.alN = this.alA.je() + this.alH;
                    } else {
                        aVar.alN = this.alH - this.alA.getEndPadding();
                    }
                    obj = 1;
                }
                if (obj == null) {
                    if (getChildCount() != 0) {
                        if (aVar.alO) {
                            bW = fi(sVar.getItemCount());
                        } else {
                            bW = fh(sVar.getItemCount());
                        }
                        if (bW != null) {
                            a.a(aVar, bW);
                            if (!sVar.apv && iE()) {
                                obj = (this.alA.bf(bW) >= this.alA.jf() || this.alA.bg(bW) < this.alA.je()) ? 1 : null;
                                if (obj != null) {
                                    if (aVar.alO) {
                                        T = this.alA.jf();
                                    } else {
                                        T = this.alA.je();
                                    }
                                    aVar.alN = T;
                                }
                            }
                            obj = 1;
                            if (obj == null) {
                                a.g(aVar);
                                aVar.mPosition = 0;
                                aVar.bui = 0;
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                    }
                }
                this.btZ.alP = true;
            } else {
                assertionError = new AssertionError();
                AppMethodBeat.o(54816);
                throw assertionError;
            }
        }
        b(oVar);
        if (this.btZ.alO) {
            b(this.btZ, false, true);
        } else {
            a(this.btZ, false, true);
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mWidth, this.aoJ);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.mHeight, this.aoK);
        int i3 = this.mWidth;
        int i4 = this.mHeight;
        if (ua()) {
            obj = (this.buc == j.INVALID_ID || this.buc == i3) ? null : 1;
            if (this.btY.alm) {
                i = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i = this.btY.alg;
            }
            i2 = i;
        } else {
            obj = (this.bud == j.INVALID_ID || this.bud == i4) ? null : 1;
            if (this.btY.alm) {
                i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i = this.btY.alg;
            }
            i2 = i;
        }
        this.buc = i3;
        this.bud = i4;
        if (this.buh != -1 || (this.alG == -1 && r3 == null)) {
            if (this.buh != -1) {
                i3 = Math.min(this.buh, this.btZ.mPosition);
            } else {
                i3 = this.btZ.mPosition;
            }
            this.btP.reset();
            if (ua()) {
                if (this.bty.size() > 0) {
                    this.btO.d(this.bty, i3);
                    this.btO.a(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, i3, this.btZ.mPosition, this.bty);
                } else {
                    this.btO.fb(itemCount);
                    this.btO.a(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, 0, this.bty);
                }
            } else if (this.bty.size() > 0) {
                this.btO.d(this.bty, i3);
                this.btO.a(this.btP, makeMeasureSpec2, makeMeasureSpec, i2, i3, this.btZ.mPosition, this.bty);
            } else {
                this.btO.fb(itemCount);
                this.btO.c(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, 0, this.bty);
            }
            this.bty = this.btP.bty;
            this.btO.x(makeMeasureSpec, makeMeasureSpec2, i3);
            this.btO.eY(i3);
        } else if (!this.btZ.alO) {
            this.bty.clear();
            if ($assertionsDisabled || this.btO.btv != null) {
                this.btP.reset();
                if (ua()) {
                    this.btO.b(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, this.btZ.mPosition, this.bty);
                } else {
                    this.btO.d(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, this.btZ.mPosition, this.bty);
                }
                this.bty = this.btP.bty;
                this.btO.bk(makeMeasureSpec, makeMeasureSpec2);
                this.btO.ul();
                this.btZ.bui = this.btO.btv[this.btZ.mPosition];
                this.btY.bui = this.btZ.bui;
            } else {
                assertionError = new AssertionError();
                AppMethodBeat.o(54816);
                throw assertionError;
            }
        }
        if (this.btZ.alO) {
            a(oVar, sVar, this.btY);
            i = this.btY.Lp;
            a(this.btZ, true, false);
            a(oVar, sVar, this.btY);
            T = this.btY.Lp;
        } else {
            a(oVar, sVar, this.btY);
            T = this.btY.Lp;
            b(this.btZ, true, false);
            a(oVar, sVar, this.btY);
            i = this.btY.Lp;
        }
        if (getChildCount() > 0) {
            if (this.btZ.alO) {
                b(a(T, oVar, sVar, true) + i, oVar, sVar, false);
                AppMethodBeat.o(54816);
                return;
            }
            a(T + b(i, oVar, sVar, true), oVar, sVar, false);
        }
        AppMethodBeat.o(54816);
    }

    private int b(int i, o oVar, s sVar, boolean z) {
        int je;
        int i2;
        AppMethodBeat.i(54817);
        if (ua() || !this.hq) {
            je = i - this.alA.je();
            if (je > 0) {
                i2 = -d(je, oVar, sVar);
            } else {
                AppMethodBeat.o(54817);
                return 0;
            }
        }
        je = this.alA.jf() - i;
        if (je > 0) {
            i2 = d(-je, oVar, sVar);
        } else {
            AppMethodBeat.o(54817);
            return 0;
        }
        je = i + i2;
        if (z) {
            je -= this.alA.je();
            if (je > 0) {
                this.alA.cc(-je);
                i2 -= je;
                AppMethodBeat.o(54817);
                return i2;
            }
        }
        AppMethodBeat.o(54817);
        return i2;
    }

    private int a(int i, o oVar, s sVar, boolean z) {
        int d;
        AppMethodBeat.i(54818);
        int i2 = (ua() || !this.hq) ? 0 : 1;
        if (i2 != 0) {
            i2 = i - this.alA.je();
            if (i2 > 0) {
                d = d(i2, oVar, sVar);
            } else {
                AppMethodBeat.o(54818);
                return 0;
            }
        }
        i2 = this.alA.jf() - i;
        if (i2 > 0) {
            d = -d(-i2, oVar, sVar);
        } else {
            AppMethodBeat.o(54818);
            return 0;
        }
        i2 = i + d;
        if (z) {
            i2 = this.alA.jf() - i2;
            if (i2 > 0) {
                this.alA.cc(i2);
                d += i2;
                AppMethodBeat.o(54818);
                return d;
            }
        }
        AppMethodBeat.o(54818);
        return d;
    }

    public final void a(s sVar) {
        AppMethodBeat.i(54819);
        super.a(sVar);
        this.bub = null;
        this.alG = -1;
        this.alH = j.INVALID_ID;
        this.buh = -1;
        a.b(this.btZ);
        this.bue.clear();
        AppMethodBeat.o(54819);
    }

    private View fh(int i) {
        AppMethodBeat.i(54820);
        if ($assertionsDisabled || this.btO.btv != null) {
            View z = z(0, getChildCount(), i);
            if (z == null) {
                AppMethodBeat.o(54820);
                return null;
            }
            int i2 = this.btO.btv[i.bt(z)];
            if (i2 == -1) {
                AppMethodBeat.o(54820);
                return null;
            }
            View a = a(z, (b) this.bty.get(i2));
            AppMethodBeat.o(54820);
            return a;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(54820);
        throw assertionError;
    }

    private View fi(int i) {
        AppMethodBeat.i(54821);
        if ($assertionsDisabled || this.btO.btv != null) {
            View z = z(getChildCount() - 1, -1, i);
            if (z == null) {
                AppMethodBeat.o(54821);
                return null;
            }
            View b = b(z, (b) this.bty.get(this.btO.btv[i.bt(z)]));
            AppMethodBeat.o(54821);
            return b;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(54821);
        throw assertionError;
    }

    private View z(int i, int i2, int i3) {
        AppMethodBeat.i(54822);
        uo();
        iJ();
        int je = this.alA.je();
        int jf = this.alA.jf();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int bt = i.bt(childAt);
            if (bt >= 0 && bt < i3) {
                if (((android.support.v7.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).aoM.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        view2 = childAt;
                        i += i4;
                        view = view3;
                    }
                } else if (this.alA.bf(childAt) >= je && this.alA.bg(childAt) <= jf) {
                    AppMethodBeat.o(54822);
                    return childAt;
                } else if (view == null) {
                    view3 = childAt;
                    i += i4;
                    view = view3;
                }
            }
            view3 = view;
            i += i4;
            view = view3;
        }
        if (view != null) {
            AppMethodBeat.o(54822);
            return view;
        }
        AppMethodBeat.o(54822);
        return view2;
    }

    private View iM() {
        AppMethodBeat.i(138959);
        View childAt = getChildAt(0);
        AppMethodBeat.o(138959);
        return childAt;
    }

    private boolean D(View view, int i) {
        AppMethodBeat.i(54827);
        if (ua() || !this.hq) {
            if (this.alA.bg(view) <= i) {
                AppMethodBeat.o(54827);
                return true;
            }
            AppMethodBeat.o(54827);
            return false;
        } else if (this.alA.getEnd() - this.alA.bf(view) <= i) {
            AppMethodBeat.o(54827);
            return true;
        } else {
            AppMethodBeat.o(54827);
            return false;
        }
    }

    private boolean E(View view, int i) {
        AppMethodBeat.i(54829);
        if (ua() || !this.hq) {
            if (this.alA.bf(view) >= this.alA.getEnd() - i) {
                AppMethodBeat.o(54829);
                return true;
            }
            AppMethodBeat.o(54829);
            return false;
        } else if (this.alA.bg(view) <= i) {
            AppMethodBeat.o(54829);
            return true;
        } else {
            AppMethodBeat.o(54829);
            return false;
        }
    }

    private void a(o oVar, int i, int i2) {
        AppMethodBeat.i(54830);
        while (i2 >= i) {
            a(i2, oVar);
            i2--;
        }
        AppMethodBeat.o(54830);
    }

    private int a(b bVar, b bVar2) {
        AppMethodBeat.i(54831);
        if ($assertionsDisabled || this.btO.btw != null) {
            int i;
            int i2;
            float f;
            float f2;
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i3 = this.mHeight;
            int i4 = bVar2.Lp;
            int i5 = bVar2.Lp;
            if (bVar2.sE == -1) {
                i = i5 + bVar.btk;
                i2 = i4 - bVar.btk;
            } else {
                i = i5;
                i2 = i4;
            }
            int i6 = bVar2.mPosition;
            float f3 = 0.0f;
            switch (this.btC) {
                case 0:
                    f = (float) paddingTop;
                    f2 = (float) (i3 - paddingBottom);
                    break;
                case 1:
                    f = (float) ((i3 - bVar.bti) + paddingBottom);
                    f2 = (float) (bVar.bti - paddingTop);
                    break;
                case 2:
                    f = ((float) paddingTop) + (((float) (i3 - bVar.bti)) / 2.0f);
                    f2 = ((float) (i3 - paddingBottom)) - (((float) (i3 - bVar.bti)) / 2.0f);
                    break;
                case 3:
                    f = (float) paddingTop;
                    f3 = ((float) (i3 - bVar.bti)) / (bVar.apt != 1 ? (float) (bVar.apt - 1) : 1.0f);
                    f2 = (float) (i3 - paddingBottom);
                    break;
                case 4:
                    if (bVar.apt != 0) {
                        f3 = ((float) (i3 - bVar.bti)) / ((float) bVar.apt);
                    }
                    f = ((float) paddingTop) + (f3 / 2.0f);
                    f2 = ((float) (i3 - paddingBottom)) - (f3 / 2.0f);
                    break;
                case 5:
                    if (bVar.apt != 0) {
                        f3 = ((float) (i3 - bVar.bti)) / ((float) (bVar.apt + 1));
                    }
                    f = ((float) paddingTop) + f3;
                    f2 = ((float) (i3 - paddingBottom)) - f3;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.btC);
                    AppMethodBeat.o(54831);
                    throw illegalStateException;
            }
            float i7 = f - ((float) this.btZ.buj);
            float i8 = f2 - ((float) this.btZ.buj);
            float max = Math.max(f3, 0.0f);
            paddingTop = 0;
            int i9 = bVar.apt;
            int i10 = i6;
            while (i10 < i6 + i9) {
                int i11;
                View eU = eU(i10);
                if (eU != null) {
                    long j = this.btO.btw[i10];
                    int at = c.at(j);
                    int au = c.au(j);
                    android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (LayoutParams) eU.getLayoutParams();
                    if (b(eU, at, au, layoutParams)) {
                        eU.measure(at, au);
                    }
                    float bB = i7 + ((float) (layoutParams.topMargin + i.bB(eU)));
                    float bC = i8 - ((float) (layoutParams.rightMargin + i.bC(eU)));
                    if (bVar2.sE == 1) {
                        g(eU, btW);
                        addView(eU);
                        i11 = paddingTop;
                    } else {
                        g(eU, btW);
                        addView(eU, paddingTop);
                        i11 = paddingTop + 1;
                    }
                    i3 = i2 + i.bD(eU);
                    au = i - i.bE(eU);
                    if (this.hq) {
                        if (this.btX) {
                            this.btO.a(eU, bVar, this.hq, au - eU.getMeasuredWidth(), Math.round(bC) - eU.getMeasuredHeight(), au, Math.round(bC));
                        } else {
                            this.btO.a(eU, bVar, this.hq, au - eU.getMeasuredWidth(), Math.round(bB), au, eU.getMeasuredHeight() + Math.round(bB));
                        }
                    } else if (this.btX) {
                        this.btO.a(eU, bVar, this.hq, i3, Math.round(bC) - eU.getMeasuredHeight(), i3 + eU.getMeasuredWidth(), Math.round(bC));
                    } else {
                        this.btO.a(eU, bVar, this.hq, i3, Math.round(bB), i3 + eU.getMeasuredWidth(), eU.getMeasuredHeight() + Math.round(bB));
                    }
                    f3 = (((float) ((eU.getMeasuredHeight() + layoutParams.topMargin) + i.bC(eU))) + max) + bB;
                    f = bC - (((float) (i.bB(eU) + (eU.getMeasuredHeight() + layoutParams.bottomMargin))) + max);
                } else {
                    i11 = paddingTop;
                    f3 = i7;
                    f = i8;
                }
                paddingTop = i11;
                i7 = f3;
                i10++;
                i8 = f;
            }
            bVar2.bui += this.btY.sE;
            i5 = bVar.btk;
            AppMethodBeat.o(54831);
            return i5;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(54831);
        throw assertionError;
    }

    public final boolean ua() {
        return this.btA == 0 || this.btA == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        AppMethodBeat.i(54832);
        if (z2) {
            un();
        } else {
            this.btY.alm = false;
        }
        if (ua() || !this.hq) {
            this.btY.alg = this.alA.jf() - aVar.alN;
        } else {
            this.btY.alg = aVar.alN - getPaddingRight();
        }
        this.btY.mPosition = aVar.mPosition;
        this.btY.ali = 1;
        this.btY.sE = 1;
        this.btY.Lp = aVar.alN;
        this.btY.alS = j.INVALID_ID;
        this.btY.bui = aVar.bui;
        if (z && this.bty.size() > 1 && aVar.bui >= 0 && aVar.bui < this.bty.size() - 1) {
            b bVar = (b) this.bty.get(aVar.bui);
            this.btY.bui = this.btY.bui + 1;
            b bVar2 = this.btY;
            bVar2.mPosition = bVar.apt + bVar2.mPosition;
        }
        AppMethodBeat.o(54832);
    }

    private void b(a aVar, boolean z, boolean z2) {
        AppMethodBeat.i(54833);
        if (z2) {
            un();
        } else {
            this.btY.alm = false;
        }
        if (ua() || !this.hq) {
            this.btY.alg = aVar.alN - this.alA.je();
        } else {
            this.btY.alg = (this.bug.getWidth() - aVar.alN) - this.alA.je();
        }
        this.btY.mPosition = aVar.mPosition;
        this.btY.ali = 1;
        this.btY.sE = -1;
        this.btY.Lp = aVar.alN;
        this.btY.alS = j.INVALID_ID;
        this.btY.bui = aVar.bui;
        if (z && aVar.bui > 0 && this.bty.size() > aVar.bui) {
            b bVar = (b) this.bty.get(aVar.bui);
            this.btY.bui = this.btY.bui - 1;
            b bVar2 = this.btY;
            bVar2.mPosition -= bVar.apt;
        }
        AppMethodBeat.o(54833);
    }

    private void un() {
        int i;
        boolean z;
        AppMethodBeat.i(54834);
        if (ua()) {
            i = this.aoK;
        } else {
            i = this.aoJ;
        }
        b bVar = this.btY;
        if (i == 0 || i == j.INVALID_ID) {
            z = true;
        } else {
            z = false;
        }
        bVar.alm = z;
        AppMethodBeat.o(54834);
    }

    private void uo() {
        AppMethodBeat.i(54835);
        if (this.alA != null) {
            AppMethodBeat.o(54835);
            return;
        }
        if (ua()) {
            if (this.btB != 0) {
                this.alA = am.e(this);
                this.bua = am.d(this);
                AppMethodBeat.o(54835);
                return;
            }
        } else if (this.btB == 0) {
            this.alA = am.e(this);
            this.bua = am.d(this);
            AppMethodBeat.o(54835);
            return;
        }
        this.alA = am.d(this);
        this.bua = am.e(this);
        AppMethodBeat.o(54835);
    }

    private void iJ() {
        AppMethodBeat.i(54836);
        if (this.btY == null) {
            this.btY = new b();
        }
        AppMethodBeat.o(54836);
    }

    public final void bY(int i) {
        AppMethodBeat.i(54837);
        this.alG = i;
        this.alH = j.INVALID_ID;
        if (this.bub != null) {
            this.bub.alX = -1;
        }
        requestLayout();
        AppMethodBeat.o(54837);
    }

    public final void a(RecyclerView recyclerView, int i) {
        AppMethodBeat.i(54838);
        ah ahVar = new ah(recyclerView.getContext());
        ahVar.ape = i;
        a((r) ahVar);
        AppMethodBeat.o(54838);
    }

    public final void f(RecyclerView recyclerView) {
        AppMethodBeat.i(54839);
        super.f(recyclerView);
        this.bug = (View) recyclerView.getParent();
        AppMethodBeat.o(54839);
    }

    public final void a(RecyclerView recyclerView, o oVar) {
        AppMethodBeat.i(54840);
        super.a(recyclerView, oVar);
        if (this.alI) {
            d(oVar);
            oVar.clear();
        }
        AppMethodBeat.o(54840);
    }

    public final boolean iG() {
        AppMethodBeat.i(54841);
        if (!ua() || this.mWidth > this.bug.getWidth()) {
            AppMethodBeat.o(54841);
            return true;
        }
        AppMethodBeat.o(54841);
        return false;
    }

    public final boolean iH() {
        AppMethodBeat.i(54842);
        if (ua() || this.mHeight > this.bug.getHeight()) {
            AppMethodBeat.o(54842);
            return true;
        }
        AppMethodBeat.o(54842);
        return false;
    }

    public final int a(int i, o oVar, s sVar) {
        AppMethodBeat.i(54843);
        int fj;
        if (ua()) {
            fj = fj(i);
            a aVar = this.btZ;
            aVar.buj = aVar.buj + fj;
            this.bua.cc(-fj);
            AppMethodBeat.o(54843);
            return fj;
        }
        fj = d(i, oVar, sVar);
        this.bue.clear();
        AppMethodBeat.o(54843);
        return fj;
    }

    public final int b(int i, o oVar, s sVar) {
        AppMethodBeat.i(54844);
        int d;
        if (ua()) {
            d = d(i, oVar, sVar);
            this.bue.clear();
            AppMethodBeat.o(54844);
            return d;
        }
        d = fj(i);
        a aVar = this.btZ;
        aVar.buj = aVar.buj + d;
        this.bua.cc(-d);
        AppMethodBeat.o(54844);
        return d;
    }

    private int d(int i, o oVar, s sVar) {
        int i2 = 1;
        AppMethodBeat.i(54845);
        if (getChildCount() == 0 || i == 0) {
            AppMethodBeat.o(54845);
            return 0;
        }
        uo();
        this.btY.bum = true;
        int i3 = (ua() || !this.hq) ? 0 : 1;
        if (i3 != 0) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        bo(i2, abs);
        int a = this.btY.alS + a(oVar, sVar, this.btY);
        if (a < 0) {
            AppMethodBeat.o(54845);
            return 0;
        }
        if (i3 != 0) {
            if (abs > a) {
                i = (-i2) * a;
            }
        } else if (abs > a) {
            i = i2 * a;
        }
        this.alA.cc(-i);
        this.btY.alV = i;
        AppMethodBeat.o(54845);
        return i;
    }

    private int fj(int i) {
        Object obj = null;
        AppMethodBeat.i(54846);
        if (getChildCount() == 0 || i == 0) {
            AppMethodBeat.o(54846);
            return 0;
        }
        int width;
        int i2;
        uo();
        boolean ua = ua();
        if (ua) {
            width = this.bug.getWidth();
        } else {
            width = this.bug.getHeight();
        }
        if (ua) {
            i2 = this.mWidth;
        } else {
            i2 = this.mHeight;
        }
        if (android.support.v4.view.s.T(this.aiB) == 1) {
            obj = 1;
        }
        if (obj != null) {
            int abs = Math.abs(i);
            if (i < 0) {
                i = -Math.min((i2 + this.btZ.buj) - width, abs);
            } else if (this.btZ.buj + i > 0) {
                i = -this.btZ.buj;
            }
        } else if (i > 0) {
            i = Math.min((i2 - this.btZ.buj) - width, i);
        } else if (this.btZ.buj + i < 0) {
            i = -this.btZ.buj;
        }
        AppMethodBeat.o(54846);
        return i;
    }

    private void bo(int i, int i2) {
        int i3 = 0;
        AppMethodBeat.i(54847);
        if ($assertionsDisabled || this.btO.btv != null) {
            b bVar;
            this.btY.sE = i;
            boolean ua = ua();
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mWidth, this.aoJ);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.mHeight, this.aoK);
            int i4 = (ua || !this.hq) ? 0 : 1;
            int i5;
            if (i == 1) {
                View childAt = getChildAt(getChildCount() - 1);
                this.btY.Lp = this.alA.bg(childAt);
                int bt = i.bt(childAt);
                View b = b(childAt, (b) this.bty.get(this.btO.btv[bt]));
                this.btY.ali = 1;
                b bVar2 = this.btY;
                bVar2.mPosition = bVar2.ali + bt;
                if (this.btO.btv.length <= this.btY.mPosition) {
                    this.btY.bui = -1;
                } else {
                    this.btY.bui = this.btO.btv[this.btY.mPosition];
                }
                if (i4 != 0) {
                    this.btY.Lp = this.alA.bf(b);
                    this.btY.alS = (-this.alA.bf(b)) + this.alA.je();
                    b bVar3 = this.btY;
                    if (this.btY.alS >= 0) {
                        i5 = this.btY.alS;
                    } else {
                        i5 = 0;
                    }
                    bVar3.alS = i5;
                } else {
                    this.btY.Lp = this.alA.bg(b);
                    this.btY.alS = this.alA.bg(b) - this.alA.jf();
                }
                if ((this.btY.bui == -1 || this.btY.bui > this.bty.size() - 1) && this.btY.mPosition <= getFlexItemCount()) {
                    i4 = i2 - this.btY.alS;
                    this.btP.reset();
                    if (i4 > 0) {
                        if (ua) {
                            this.btO.a(this.btP, makeMeasureSpec, makeMeasureSpec2, i4, this.btY.mPosition, this.bty);
                        } else {
                            this.btO.c(this.btP, makeMeasureSpec, makeMeasureSpec2, i4, this.btY.mPosition, this.bty);
                        }
                        this.btO.x(makeMeasureSpec, makeMeasureSpec2, this.btY.mPosition);
                        this.btO.eY(this.btY.mPosition);
                    }
                }
            } else {
                View childAt2 = getChildAt(0);
                this.btY.Lp = this.alA.bf(childAt2);
                makeMeasureSpec2 = i.bt(childAt2);
                View a = a(childAt2, (b) this.bty.get(this.btO.btv[makeMeasureSpec2]));
                this.btY.ali = 1;
                i5 = this.btO.btv[makeMeasureSpec2];
                if (i5 == -1) {
                    makeMeasureSpec = 0;
                } else {
                    makeMeasureSpec = i5;
                }
                if (makeMeasureSpec > 0) {
                    this.btY.mPosition = makeMeasureSpec2 - ((b) this.bty.get(makeMeasureSpec - 1)).apt;
                } else {
                    this.btY.mPosition = -1;
                }
                b bVar4 = this.btY;
                if (makeMeasureSpec > 0) {
                    i5 = makeMeasureSpec - 1;
                } else {
                    i5 = 0;
                }
                bVar4.bui = i5;
                if (i4 != 0) {
                    this.btY.Lp = this.alA.bg(a);
                    this.btY.alS = this.alA.bg(a) - this.alA.jf();
                    bVar = this.btY;
                    if (this.btY.alS >= 0) {
                        i3 = this.btY.alS;
                    }
                    bVar.alS = i3;
                } else {
                    this.btY.Lp = this.alA.bf(a);
                    this.btY.alS = (-this.alA.bf(a)) + this.alA.je();
                }
            }
            bVar = this.btY;
            bVar.alg = i2 - bVar.alS;
            AppMethodBeat.o(54847);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(54847);
        throw assertionError;
    }

    private View a(View view, b bVar) {
        AppMethodBeat.i(54848);
        boolean ua = ua();
        int i = bVar.apt;
        int i2 = 1;
        View view2 = view;
        while (i2 < i) {
            View childAt = getChildAt(i2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.hq || ua) {
                    if (this.alA.bf(view2) > this.alA.bf(childAt)) {
                        i2++;
                        view2 = childAt;
                    }
                } else if (this.alA.bg(view2) < this.alA.bg(childAt)) {
                    i2++;
                    view2 = childAt;
                }
            }
            childAt = view2;
            i2++;
            view2 = childAt;
        }
        AppMethodBeat.o(54848);
        return view2;
    }

    private View b(View view, b bVar) {
        AppMethodBeat.i(54849);
        boolean ua = ua();
        int childCount = (getChildCount() - bVar.apt) - 1;
        int childCount2 = getChildCount() - 2;
        View view2 = view;
        while (childCount2 > childCount) {
            View childAt = getChildAt(childCount2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.hq || ua) {
                    if (this.alA.bg(view2) < this.alA.bg(childAt)) {
                        childCount2--;
                        view2 = childAt;
                    }
                } else if (this.alA.bf(view2) > this.alA.bf(childAt)) {
                    childCount2--;
                    view2 = childAt;
                }
            }
            childAt = view2;
            childCount2--;
            view2 = childAt;
        }
        AppMethodBeat.o(54849);
        return view2;
    }

    public final int f(s sVar) {
        AppMethodBeat.i(54850);
        int k = k(sVar);
        AppMethodBeat.o(54850);
        return k;
    }

    public final int g(s sVar) {
        AppMethodBeat.i(54851);
        int k = k(sVar);
        AppMethodBeat.o(54851);
        return k;
    }

    private int k(s sVar) {
        AppMethodBeat.i(54852);
        if (getChildCount() == 0) {
            AppMethodBeat.o(54852);
            return 0;
        }
        int itemCount = sVar.getItemCount();
        uo();
        View fh = fh(itemCount);
        View fi = fi(itemCount);
        if (sVar.getItemCount() == 0 || fh == null || fi == null) {
            AppMethodBeat.o(54852);
            return 0;
        }
        int min = Math.min(this.alA.jg(), this.alA.bg(fi) - this.alA.bf(fh));
        AppMethodBeat.o(54852);
        return min;
    }

    public final int d(s sVar) {
        AppMethodBeat.i(54853);
        j(sVar);
        int j = j(sVar);
        AppMethodBeat.o(54853);
        return j;
    }

    public final int e(s sVar) {
        AppMethodBeat.i(54854);
        int j = j(sVar);
        AppMethodBeat.o(54854);
        return j;
    }

    private int j(s sVar) {
        AppMethodBeat.i(54855);
        if (getChildCount() == 0) {
            AppMethodBeat.o(54855);
            return 0;
        }
        int itemCount = sVar.getItemCount();
        View fh = fh(itemCount);
        View fi = fi(itemCount);
        if (sVar.getItemCount() == 0 || fh == null || fi == null) {
            AppMethodBeat.o(54855);
            return 0;
        } else if ($assertionsDisabled || this.btO.btv != null) {
            int bt = i.bt(fh);
            int bt2 = i.bt(fi);
            itemCount = Math.abs(this.alA.bg(fi) - this.alA.bf(fh));
            bt = this.btO.btv[bt];
            if (bt == 0 || bt == -1) {
                AppMethodBeat.o(54855);
                return 0;
            }
            int round = Math.round(((((float) itemCount) / ((float) ((this.btO.btv[bt2] - bt) + 1))) * ((float) bt)) + ((float) (this.alA.je() - this.alA.bf(fh))));
            AppMethodBeat.o(54855);
            return round;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(54855);
            throw assertionError;
        }
    }

    public final int h(s sVar) {
        AppMethodBeat.i(54856);
        int l = l(sVar);
        AppMethodBeat.o(54856);
        return l;
    }

    public final int i(s sVar) {
        AppMethodBeat.i(54857);
        int l = l(sVar);
        AppMethodBeat.o(54857);
        return l;
    }

    private int l(s sVar) {
        AppMethodBeat.i(54858);
        if (getChildCount() == 0) {
            AppMethodBeat.o(54858);
            return 0;
        }
        int itemCount = sVar.getItemCount();
        View fh = fh(itemCount);
        View fi = fi(itemCount);
        if (sVar.getItemCount() == 0 || fh == null || fi == null) {
            AppMethodBeat.o(54858);
            return 0;
        } else if ($assertionsDisabled || this.btO.btv != null) {
            int iQ = iQ();
            iQ = (int) ((((float) Math.abs(this.alA.bg(fi) - this.alA.bf(fh))) / ((float) ((iS() - iQ) + 1))) * ((float) sVar.getItemCount()));
            AppMethodBeat.o(54858);
            return iQ;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(54858);
            throw assertionError;
        }
    }

    private boolean b(View view, int i, int i2, android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        AppMethodBeat.i(54859);
        if (!view.isLayoutRequested() && this.aoF && m(view.getWidth(), i, layoutParams.width) && m(view.getHeight(), i2, layoutParams.height)) {
            AppMethodBeat.o(54859);
            return false;
        }
        AppMethodBeat.o(54859);
        return true;
    }

    private static boolean m(int i, int i2, int i3) {
        AppMethodBeat.i(54860);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (i3 <= 0 || i == i3) {
            switch (mode) {
                case j.INVALID_ID /*-2147483648*/:
                    if (size >= i) {
                        AppMethodBeat.o(54860);
                        return true;
                    }
                    AppMethodBeat.o(54860);
                    return false;
                case 0:
                    AppMethodBeat.o(54860);
                    return true;
                case ErrorDialogData.SUPPRESSED /*1073741824*/:
                    if (size == i) {
                        AppMethodBeat.o(54860);
                        return true;
                    }
                    AppMethodBeat.o(54860);
                    return false;
                default:
                    AppMethodBeat.o(54860);
                    return false;
            }
        }
        AppMethodBeat.o(54860);
        return false;
    }

    private boolean cb(View view) {
        Object obj;
        AppMethodBeat.i(54861);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingBottom = this.mHeight - getPaddingBottom();
        int by = i.by(view) - ((android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        int bz = i.bz(view) + ((android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        int bA = layoutParams.bottomMargin + i.bA(view);
        if (i.bx(view) - ((android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin >= this.mWidth - getPaddingRight() || bz >= paddingLeft) {
            obj = 1;
        } else {
            obj = null;
        }
        Object obj2;
        if (by >= paddingBottom || bA >= paddingTop) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj == null || obj2 == null) {
            AppMethodBeat.o(54861);
            return false;
        }
        AppMethodBeat.o(54861);
        return true;
    }

    private int iQ() {
        AppMethodBeat.i(54862);
        View bp = bp(0, getChildCount());
        if (bp == null) {
            AppMethodBeat.o(54862);
            return -1;
        }
        int bt = i.bt(bp);
        AppMethodBeat.o(54862);
        return bt;
    }

    private int iS() {
        AppMethodBeat.i(54863);
        View bp = bp(getChildCount() - 1, -1);
        if (bp == null) {
            AppMethodBeat.o(54863);
            return -1;
        }
        int bt = i.bt(bp);
        AppMethodBeat.o(54863);
        return bt;
    }

    private View bp(int i, int i2) {
        AppMethodBeat.i(54864);
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = getChildAt(i);
            if (cb(childAt)) {
                AppMethodBeat.o(54864);
                return childAt;
            }
            i += i3;
        }
        AppMethodBeat.o(54864);
        return null;
    }

    public final int v(int i, int i2, int i3) {
        AppMethodBeat.i(54799);
        int c = i.c(this.mWidth, this.aoJ, i2, i3, iG());
        AppMethodBeat.o(54799);
        return c;
    }

    public final int w(int i, int i2, int i3) {
        AppMethodBeat.i(54800);
        int c = i.c(this.mHeight, this.aoK, i2, i3, iH());
        AppMethodBeat.o(54800);
        return c;
    }

    private int a(o oVar, s sVar, b bVar) {
        int a;
        AppMethodBeat.i(54824);
        if (bVar.alS != j.INVALID_ID) {
            if (bVar.alg < 0) {
                bVar.alS += bVar.alg;
            }
            a(oVar, bVar);
        }
        int i = bVar.alg;
        int i2 = bVar.alg;
        boolean ua = ua();
        int i3 = 0;
        int i4 = i2;
        while (true) {
            if (i4 > 0 || this.btY.alm) {
                Object obj;
                List list = this.bty;
                if (bVar.mPosition < 0 || bVar.mPosition >= sVar.getItemCount() || bVar.bui < 0 || bVar.bui >= list.size()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    b bVar2 = (b) this.bty.get(bVar.bui);
                    bVar.mPosition = bVar2.btr;
                    if (!ua()) {
                        a = a(bVar2, bVar);
                    } else if ($assertionsDisabled || this.btO.btw != null) {
                        int i5;
                        float f;
                        float f2;
                        int paddingLeft = getPaddingLeft();
                        int paddingRight = getPaddingRight();
                        int i6 = this.mWidth;
                        a = bVar.Lp;
                        if (bVar.sE == -1) {
                            i5 = a - bVar2.btk;
                        } else {
                            i5 = a;
                        }
                        int i7 = bVar.mPosition;
                        float f3 = 0.0f;
                        switch (this.btC) {
                            case 0:
                                f = (float) paddingLeft;
                                f2 = (float) (i6 - paddingRight);
                                break;
                            case 1:
                                f = (float) ((i6 - bVar2.bti) + paddingRight);
                                f2 = (float) (bVar2.bti - paddingLeft);
                                break;
                            case 2:
                                f = ((float) paddingLeft) + (((float) (i6 - bVar2.bti)) / 2.0f);
                                f2 = ((float) (i6 - paddingRight)) - (((float) (i6 - bVar2.bti)) / 2.0f);
                                break;
                            case 3:
                                f = (float) paddingLeft;
                                f3 = ((float) (i6 - bVar2.bti)) / (bVar2.apt != 1 ? (float) (bVar2.apt - 1) : 1.0f);
                                f2 = (float) (i6 - paddingRight);
                                break;
                            case 4:
                                if (bVar2.apt != 0) {
                                    f3 = ((float) (i6 - bVar2.bti)) / ((float) bVar2.apt);
                                }
                                f = ((float) paddingLeft) + (f3 / 2.0f);
                                f2 = ((float) (i6 - paddingRight)) - (f3 / 2.0f);
                                break;
                            case 5:
                                if (bVar2.apt != 0) {
                                    f3 = ((float) (i6 - bVar2.bti)) / ((float) (bVar2.apt + 1));
                                }
                                f = ((float) paddingLeft) + f3;
                                f2 = ((float) (i6 - paddingRight)) - f3;
                                break;
                            default:
                                IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.btC);
                                AppMethodBeat.o(54824);
                                throw illegalStateException;
                        }
                        f -= (float) this.btZ.buj;
                        float i8 = f2 - ((float) this.btZ.buj);
                        float max = Math.max(f3, 0.0f);
                        a = 0;
                        int i9 = bVar2.apt;
                        f2 = f;
                        for (int i10 = i7; i10 < i7 + i9; i10++) {
                            int i11;
                            View eU = eU(i10);
                            if (eU != null) {
                                if (bVar.sE == 1) {
                                    g(eU, btW);
                                    addView(eU);
                                    i11 = a;
                                } else {
                                    g(eU, btW);
                                    addView(eU, a);
                                    i11 = a + 1;
                                }
                                long j = this.btO.btw[i10];
                                i6 = c.at(j);
                                int au = c.au(j);
                                android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (LayoutParams) eU.getLayoutParams();
                                if (b(eU, i6, au, layoutParams)) {
                                    eU.measure(i6, au);
                                }
                                float bD = f2 + ((float) (layoutParams.leftMargin + i.bD(eU)));
                                float bE = i8 - ((float) (layoutParams.rightMargin + i.bE(eU)));
                                paddingRight = i5 + i.bB(eU);
                                if (this.hq) {
                                    this.btO.a(eU, bVar2, Math.round(bE) - eU.getMeasuredWidth(), paddingRight, Math.round(bE), eU.getMeasuredHeight() + paddingRight);
                                } else {
                                    this.btO.a(eU, bVar2, Math.round(bD), paddingRight, Math.round(bD) + eU.getMeasuredWidth(), eU.getMeasuredHeight() + paddingRight);
                                }
                                f2 = bE - (((float) (i.bD(eU) + (eU.getMeasuredWidth() + layoutParams.leftMargin))) + max);
                                f = (((float) ((eU.getMeasuredWidth() + layoutParams.rightMargin) + i.bE(eU))) + max) + bD;
                                i8 = f2;
                            } else {
                                i11 = a;
                                f = f2;
                            }
                            a = i11;
                            f2 = f;
                        }
                        bVar.bui += this.btY.sE;
                        a = bVar2.btk;
                    } else {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.o(54824);
                        throw assertionError;
                    }
                    a += i3;
                    if (ua || !this.hq) {
                        bVar.Lp += bVar2.btk * bVar.sE;
                    } else {
                        bVar.Lp -= bVar2.btk * bVar.sE;
                    }
                    i3 = a;
                    i4 -= bVar2.btk;
                }
            }
        }
        bVar.alg -= i3;
        if (bVar.alS != j.INVALID_ID) {
            bVar.alS += i3;
            if (bVar.alg < 0) {
                bVar.alS += bVar.alg;
            }
            a(oVar, bVar);
        }
        a = i - bVar.alg;
        AppMethodBeat.o(54824);
        return a;
    }

    private void a(o oVar, b bVar) {
        AppMethodBeat.i(54825);
        if (!bVar.bum) {
            AppMethodBeat.o(54825);
        } else if (bVar.sE == -1) {
            c(oVar, bVar);
            AppMethodBeat.o(54825);
        } else {
            b(oVar, bVar);
            AppMethodBeat.o(54825);
        }
    }

    private void b(o oVar, b bVar) {
        int i = -1;
        AppMethodBeat.i(54826);
        if (bVar.alS < 0) {
            AppMethodBeat.o(54826);
        } else if ($assertionsDisabled || this.btO.btv != null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                AppMethodBeat.o(54826);
                return;
            }
            int i2 = this.btO.btv[i.bt(getChildAt(0))];
            if (i2 == -1) {
                AppMethodBeat.o(54826);
                return;
            }
            b bVar2 = (b) this.bty.get(i2);
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!D(childAt, bVar.alS)) {
                    break;
                }
                if (bVar2.bts == i.bt(childAt)) {
                    if (i2 >= this.bty.size() - 1) {
                        i = i3;
                        break;
                    }
                    i2 += bVar.sE;
                    bVar2 = (b) this.bty.get(i2);
                    i = i3;
                }
            }
            a(oVar, 0, i);
            AppMethodBeat.o(54826);
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(54826);
            throw assertionError;
        }
    }

    private void c(o oVar, b bVar) {
        AppMethodBeat.i(54828);
        if (bVar.alS < 0) {
            AppMethodBeat.o(54828);
        } else if ($assertionsDisabled || this.btO.btv != null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                AppMethodBeat.o(54828);
                return;
            }
            int i = this.btO.btv[i.bt(getChildAt(childCount - 1))];
            if (i == -1) {
                AppMethodBeat.o(54828);
                return;
            }
            int i2 = childCount - 1;
            b bVar2 = (b) this.bty.get(i);
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                if (!E(childAt, bVar.alS)) {
                    break;
                }
                if (bVar2.btr == i.bt(childAt)) {
                    if (i <= 0) {
                        childCount = i3;
                        break;
                    }
                    i += bVar.sE;
                    bVar2 = (b) this.bty.get(i);
                    childCount = i3;
                }
            }
            a(oVar, childCount, i2);
            AppMethodBeat.o(54828);
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(54828);
            throw assertionError;
        }
    }
}
