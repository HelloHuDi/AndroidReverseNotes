package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.widget.C17487am;
import android.support.p069v7.widget.C41189ah;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.support.p069v7.widget.RecyclerView.C37139r.C37140b;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.flexbox.C37287c.C17696a;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class FlexboxLayoutManager extends C17480i implements C37140b, C45055a {
    static final /* synthetic */ boolean $assertionsDisabled = (!FlexboxLayoutManager.class.desiredAssertionStatus());
    private static final Rect btW = new Rect();
    private C17487am alA;
    private int alG;
    private int alH;
    private boolean alI;
    private C31880s anY;
    private C25374o anc;
    private int btA;
    private int btB;
    private int btC;
    private int btD;
    private int btF;
    private final C37287c btO;
    private C17696a btP;
    private boolean btX;
    private C25565b btY;
    private C25564a btZ;
    private List<C41633b> bty;
    private C17487am bua;
    private SavedState bub;
    private int buc;
    private int bud;
    private SparseArray<View> bue;
    private View bug;
    private int buh;
    /* renamed from: hq */
    private boolean f5222hq;
    private final Context mContext;

    public static class LayoutParams extends android.support.p069v7.widget.RecyclerView.LayoutParams implements FlexItem {
        public static final Creator<LayoutParams> CREATOR = new C165141();
        private float btR = 0.0f;
        private float btS = 1.0f;
        private int btT = -1;
        private float btU = -1.0f;
        private boolean btV;
        /* renamed from: dg */
        private int f3511dg;
        /* renamed from: dh */
        private int f3512dh;
        /* renamed from: di */
        private int f3513di = 16777215;
        /* renamed from: dj */
        private int f3514dj = 16777215;

        /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$LayoutParams$1 */
        static class C165141 implements Creator<LayoutParams> {
            C165141() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LayoutParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(54783);
                LayoutParams layoutParams = new LayoutParams(parcel);
                AppMethodBeat.m2505o(54783);
                return layoutParams;
            }
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
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
            return this.f3511dg;
        }

        public final int getMinHeight() {
            return this.f3512dh;
        }

        public final int getMaxWidth() {
            return this.f3513di;
        }

        public final int getMaxHeight() {
            return this.f3514dj;
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
            AppMethodBeat.m2504i(54784);
            parcel.writeFloat(this.btR);
            parcel.writeFloat(this.btS);
            parcel.writeInt(this.btT);
            parcel.writeFloat(this.btU);
            parcel.writeInt(this.f3511dg);
            parcel.writeInt(this.f3512dh);
            parcel.writeInt(this.f3513di);
            parcel.writeInt(this.f3514dj);
            parcel.writeByte(this.btV ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
            AppMethodBeat.m2505o(54784);
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            AppMethodBeat.m2504i(54785);
            this.btR = parcel.readFloat();
            this.btS = parcel.readFloat();
            this.btT = parcel.readInt();
            this.btU = parcel.readFloat();
            this.f3511dg = parcel.readInt();
            this.f3512dh = parcel.readInt();
            this.f3513di = parcel.readInt();
            this.f3514dj = parcel.readInt();
            this.btV = parcel.readByte() != (byte) 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
            AppMethodBeat.m2505o(54785);
        }

        static {
            AppMethodBeat.m2504i(54786);
            AppMethodBeat.m2505o(54786);
        }
    }

    /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$a */
    class C25564a {
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
            AppMethodBeat.m2504i(54782);
            AppMethodBeat.m2505o(54782);
        }

        public final String toString() {
            AppMethodBeat.m2504i(54778);
            String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.bui + ", mCoordinate=" + this.alN + ", mPerpendicularCoordinate=" + this.buj + ", mLayoutFromEnd=" + this.alO + ", mValid=" + this.alP + ", mAssignedFromSavedState=" + this.buk + '}';
            AppMethodBeat.m2505o(54778);
            return str;
        }

        /* renamed from: b */
        static /* synthetic */ void m40519b(C25564a c25564a) {
            boolean z = true;
            AppMethodBeat.m2504i(54779);
            c25564a.mPosition = -1;
            c25564a.bui = -1;
            c25564a.alN = C8415j.INVALID_ID;
            c25564a.alP = false;
            c25564a.buk = false;
            if (c25564a.bul.mo19366ua()) {
                if (c25564a.bul.btB == 0) {
                    if (c25564a.bul.btA != 1) {
                        z = false;
                    }
                    c25564a.alO = z;
                    AppMethodBeat.m2505o(54779);
                    return;
                }
                if (c25564a.bul.btB != 2) {
                    z = false;
                }
                c25564a.alO = z;
                AppMethodBeat.m2505o(54779);
            } else if (c25564a.bul.btB == 0) {
                if (c25564a.bul.btA != 3) {
                    z = false;
                }
                c25564a.alO = z;
                AppMethodBeat.m2505o(54779);
            } else {
                if (c25564a.bul.btB != 2) {
                    z = false;
                }
                c25564a.alO = z;
                AppMethodBeat.m2505o(54779);
            }
        }

        /* renamed from: g */
        static /* synthetic */ void m40526g(C25564a c25564a) {
            AppMethodBeat.m2504i(54780);
            int jf;
            if (c25564a.bul.mo19366ua() || !c25564a.bul.f5222hq) {
                if (c25564a.alO) {
                    jf = c25564a.bul.alA.mo31906jf();
                } else {
                    jf = c25564a.bul.alA.mo31905je();
                }
                c25564a.alN = jf;
                AppMethodBeat.m2505o(54780);
                return;
            }
            if (c25564a.alO) {
                jf = c25564a.bul.alA.mo31906jf();
            } else {
                jf = c25564a.bul.mWidth - c25564a.bul.alA.mo31905je();
            }
            c25564a.alN = jf;
            AppMethodBeat.m2505o(54780);
        }
    }

    /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$b */
    static class C25565b {
        /* renamed from: Lp */
        int f5223Lp;
        int alS;
        int alV;
        int alg;
        int ali;
        boolean alm;
        int bui;
        boolean bum;
        int mPosition;
        /* renamed from: sE */
        int f5224sE;

        private C25565b() {
            this.ali = 1;
            this.f5224sE = 1;
        }

        /* synthetic */ C25565b(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(54787);
            String str = "LayoutState{mAvailable=" + this.alg + ", mFlexLinePosition=" + this.bui + ", mPosition=" + this.mPosition + ", mOffset=" + this.f5223Lp + ", mScrollingOffset=" + this.alS + ", mLastScrollDelta=" + this.alV + ", mItemDirection=" + this.ali + ", mLayoutDirection=" + this.f5224sE + '}';
            AppMethodBeat.m2505o(54787);
            return str;
        }
    }

    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C255631();
        private int alX;
        private int alY;

        /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$SavedState$1 */
        static class C255631 implements Creator<SavedState> {
            C255631() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(54788);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.m2505o(54788);
                return savedState;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(54789);
            parcel.writeInt(this.alX);
            parcel.writeInt(this.alY);
            AppMethodBeat.m2505o(54789);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            AppMethodBeat.m2504i(54790);
            this.alX = parcel.readInt();
            this.alY = parcel.readInt();
            AppMethodBeat.m2505o(54790);
        }

        private SavedState(SavedState savedState) {
            this.alX = savedState.alX;
            this.alY = savedState.alY;
        }

        static {
            AppMethodBeat.m2504i(54792);
            AppMethodBeat.m2505o(54792);
        }

        public String toString() {
            AppMethodBeat.m2504i(54791);
            String str = "SavedState{mAnchorPosition=" + this.alX + ", mAnchorOffset=" + this.alY + '}';
            AppMethodBeat.m2505o(54791);
            return str;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m40537c(SavedState savedState, int i) {
            return savedState.alX >= 0 && savedState.alX < i;
        }
    }

    static {
        AppMethodBeat.m2504i(54865);
        AppMethodBeat.m2505o(54865);
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

    /* renamed from: m */
    public final int mo19349m(View view, int i, int i2) {
        AppMethodBeat.m2504i(54793);
        int bD;
        if (mo19366ua()) {
            bD = C17480i.m27146bD(view) + C17480i.m27147bE(view);
            AppMethodBeat.m2505o(54793);
            return bD;
        }
        bD = C17480i.m27144bB(view) + C17480i.m27145bC(view);
        AppMethodBeat.m2505o(54793);
        return bD;
    }

    /* renamed from: ca */
    public final int mo19328ca(View view) {
        AppMethodBeat.m2504i(54794);
        int bB;
        if (mo19366ua()) {
            bB = C17480i.m27144bB(view) + C17480i.m27145bC(view);
            AppMethodBeat.m2505o(54794);
            return bB;
        }
        bB = C17480i.m27146bD(view) + C17480i.m27147bE(view);
        AppMethodBeat.m2505o(54794);
        return bB;
    }

    /* renamed from: a */
    public final void mo19325a(View view, int i, int i2, C41633b c41633b) {
        AppMethodBeat.m2504i(54795);
        mo31859g(view, btW);
        int bD;
        if (mo19366ua()) {
            bD = C17480i.m27146bD(view) + C17480i.m27147bE(view);
            c41633b.bti += bD;
            c41633b.btj = bD + c41633b.btj;
            AppMethodBeat.m2505o(54795);
            return;
        }
        bD = C17480i.m27144bB(view) + C17480i.m27145bC(view);
        c41633b.bti += bD;
        c41633b.btj = bD + c41633b.btj;
        AppMethodBeat.m2505o(54795);
    }

    public int getFlexItemCount() {
        AppMethodBeat.m2504i(54796);
        int itemCount = this.anY.getItemCount();
        AppMethodBeat.m2505o(54796);
        return itemCount;
    }

    /* renamed from: eU */
    public final View mo19330eU(int i) {
        AppMethodBeat.m2504i(54797);
        View view = (View) this.bue.get(i);
        if (view != null) {
            AppMethodBeat.m2505o(54797);
            return view;
        }
        view = this.anc.mo42372cq(i);
        AppMethodBeat.m2505o(54797);
        return view;
    }

    /* renamed from: eV */
    public final View mo19331eV(int i) {
        AppMethodBeat.m2504i(54798);
        View eU = mo19330eU(i);
        AppMethodBeat.m2505o(54798);
        return eU;
    }

    /* renamed from: a */
    public final void mo19326a(C41633b c41633b) {
    }

    public int getLargestMainSize() {
        AppMethodBeat.m2504i(54801);
        if (this.bty.size() == 0) {
            AppMethodBeat.m2505o(54801);
            return 0;
        }
        int i = C8415j.INVALID_ID;
        int size = this.bty.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, ((C41633b) this.bty.get(i2)).bti);
        }
        AppMethodBeat.m2505o(54801);
        return i;
    }

    public int getSumOfCrossSize() {
        AppMethodBeat.m2504i(54802);
        int i = 0;
        for (int i2 = 0; i2 < this.bty.size(); i2++) {
            i += ((C41633b) this.bty.get(i2)).btk;
        }
        AppMethodBeat.m2505o(54802);
        return i;
    }

    public void setFlexLines(List<C41633b> list) {
        this.bty = list;
    }

    public List<C41633b> getFlexLinesInternal() {
        return this.bty;
    }

    /* renamed from: a */
    public final void mo19324a(int i, View view) {
        AppMethodBeat.m2504i(54803);
        this.bue.put(i, view);
        AppMethodBeat.m2505o(54803);
    }

    /* renamed from: bX */
    public final PointF mo1761bX(int i) {
        AppMethodBeat.m2504i(54804);
        if (getChildCount() == 0) {
            AppMethodBeat.m2505o(54804);
            return null;
        }
        int i2 = i < C17480i.m27148bt(getChildAt(0)) ? -1 : 1;
        PointF pointF;
        if (mo19366ua()) {
            pointF = new PointF(0.0f, (float) i2);
            AppMethodBeat.m2505o(54804);
            return pointF;
        }
        pointF = new PointF((float) i2, 0.0f);
        AppMethodBeat.m2505o(54804);
        return pointF;
    }

    /* renamed from: iA */
    public final android.support.p069v7.widget.RecyclerView.LayoutParams mo1773iA() {
        AppMethodBeat.m2504i(54805);
        LayoutParams layoutParams = new LayoutParams();
        AppMethodBeat.m2505o(54805);
        return layoutParams;
    }

    /* renamed from: a */
    public final android.support.p069v7.widget.RecyclerView.LayoutParams mo31825a(Context context, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(54806);
        LayoutParams layoutParams = new LayoutParams(context, attributeSet);
        AppMethodBeat.m2505o(54806);
        return layoutParams;
    }

    /* renamed from: a */
    public final boolean mo31834a(android.support.p069v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: jW */
    public final void mo31875jW() {
        AppMethodBeat.m2504i(54807);
        removeAllViews();
        AppMethodBeat.m2505o(54807);
    }

    public final Parcelable onSaveInstanceState() {
        AppMethodBeat.m2504i(54808);
        if (this.bub != null) {
            SavedState savedState = new SavedState(this.bub, (byte) 0);
            AppMethodBeat.m2505o(54808);
            return savedState;
        }
        Parcelable savedState2 = new SavedState();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            savedState2.alX = C17480i.m27148bt(childAt);
            savedState2.alY = this.alA.mo31893bf(childAt) - this.alA.mo31905je();
        } else {
            savedState2.alX = -1;
        }
        AppMethodBeat.m2505o(54808);
        return savedState2;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.m2504i(54809);
        if (parcelable instanceof SavedState) {
            this.bub = (SavedState) parcelable;
            requestLayout();
        }
        AppMethodBeat.m2505o(54809);
    }

    /* renamed from: c */
    public final void mo15123c(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(54810);
        super.mo15123c(recyclerView, i, i2);
        m40463fg(i);
        AppMethodBeat.m2505o(54810);
    }

    /* renamed from: a */
    public final void mo31831a(RecyclerView recyclerView, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(54811);
        super.mo31831a(recyclerView, i, i2, obj);
        m40463fg(i);
        AppMethodBeat.m2505o(54811);
    }

    /* renamed from: g */
    public final void mo15126g(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(54812);
        super.mo15126g(recyclerView, i, i2);
        m40463fg(i);
        AppMethodBeat.m2505o(54812);
    }

    /* renamed from: d */
    public final void mo15125d(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(54813);
        super.mo15125d(recyclerView, i, i2);
        m40463fg(i);
        AppMethodBeat.m2505o(54813);
    }

    /* renamed from: a */
    public final void mo31830a(RecyclerView recyclerView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(54814);
        super.mo31830a(recyclerView, i, i2, i3);
        m40463fg(Math.min(i, i2));
        AppMethodBeat.m2505o(54814);
    }

    /* renamed from: fg */
    private void m40463fg(int i) {
        AppMethodBeat.m2504i(54815);
        int iQ = m40469iQ();
        int iS = m40470iS();
        if (i >= iS) {
            AppMethodBeat.m2505o(54815);
            return;
        }
        int childCount = getChildCount();
        this.btO.mo59570fa(childCount);
        this.btO.mo59569eZ(childCount);
        this.btO.mo59571fb(childCount);
        if (!$assertionsDisabled && this.btO.btv == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(54815);
            throw assertionError;
        } else if (i >= this.btO.btv.length) {
            AppMethodBeat.m2505o(54815);
        } else {
            this.buh = i;
            View iM = m40468iM();
            if (iM == null) {
                AppMethodBeat.m2505o(54815);
            } else if (iQ > i || i > iS) {
                this.alG = C17480i.m27148bt(iM);
                if (mo19366ua() || !this.f5222hq) {
                    this.alH = this.alA.mo31893bf(iM) - this.alA.mo31905je();
                    AppMethodBeat.m2505o(54815);
                    return;
                }
                this.alH = this.alA.mo31894bg(iM) + this.alA.getEndPadding();
                AppMethodBeat.m2505o(54815);
            } else {
                AppMethodBeat.m2505o(54815);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:95:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public final void mo1765c(C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(54816);
        this.anc = c25374o;
        this.anY = c31880s;
        int itemCount = c31880s.getItemCount();
        if (itemCount == 0 && c31880s.apv) {
            AppMethodBeat.m2505o(54816);
            return;
        }
        Object obj;
        AssertionError assertionError;
        int i;
        int i2;
        int T = C0477s.m893T(this.aiB);
        switch (this.btA) {
            case 0:
                this.f5222hq = T == 1;
                this.btX = this.btB == 2;
                break;
            case 1:
                this.f5222hq = T != 1;
                this.btX = this.btB == 2;
                break;
            case 2:
                this.f5222hq = T == 1;
                if (this.btB == 2) {
                    this.f5222hq = !this.f5222hq;
                }
                this.btX = false;
                break;
            case 3:
                this.f5222hq = T == 1;
                if (this.btB == 2) {
                    this.f5222hq = !this.f5222hq;
                }
                this.btX = true;
                break;
            default:
                this.f5222hq = false;
                this.btX = false;
                break;
        }
        m40476uo();
        m40467iJ();
        this.btO.mo59570fa(itemCount);
        this.btO.mo59569eZ(itemCount);
        this.btO.mo59571fb(itemCount);
        this.btY.bum = false;
        if (this.bub != null && SavedState.m40537c(this.bub, itemCount)) {
            this.alG = this.bub.alX;
        }
        if (!(this.btZ.alP && this.alG == -1 && this.bub == null)) {
            C25564a.m40519b(this.btZ);
            C25564a c25564a = this.btZ;
            SavedState savedState = this.bub;
            if ($assertionsDisabled || this.btO.btv != null) {
                View bW;
                if (c31880s.apv || this.alG == -1) {
                    obj = null;
                } else if (this.alG < 0 || this.alG >= c31880s.getItemCount()) {
                    this.alG = -1;
                    this.alH = C8415j.INVALID_ID;
                    obj = null;
                } else {
                    c25564a.mPosition = this.alG;
                    c25564a.bui = this.btO.btv[c25564a.mPosition];
                    if (this.bub != null && SavedState.m40537c(this.bub, c31880s.getItemCount())) {
                        c25564a.alN = savedState.alY + this.alA.mo31905je();
                        c25564a.buk = true;
                        c25564a.bui = -1;
                    } else if (this.alH == C8415j.INVALID_ID) {
                        bW = mo1760bW(this.alG);
                        if (bW == null) {
                            if (getChildCount() > 0) {
                                c25564a.alO = this.alG < C17480i.m27148bt(getChildAt(0));
                            }
                            C25564a.m40526g(c25564a);
                        } else if (this.alA.mo31897bj(bW) > this.alA.mo31907jg()) {
                            C25564a.m40526g(c25564a);
                        } else if (this.alA.mo31893bf(bW) - this.alA.mo31905je() < 0) {
                            c25564a.alN = this.alA.mo31905je();
                            c25564a.alO = false;
                        } else if (this.alA.mo31906jf() - this.alA.mo31894bg(bW) < 0) {
                            c25564a.alN = this.alA.mo31906jf();
                            c25564a.alO = true;
                        } else {
                            if (c25564a.alO) {
                                T = this.alA.mo31894bg(bW) + this.alA.mo31904jd();
                            } else {
                                T = this.alA.mo31893bf(bW);
                            }
                            c25564a.alN = T;
                        }
                        obj = 1;
                    } else if (mo19366ua() || !this.f5222hq) {
                        c25564a.alN = this.alA.mo31905je() + this.alH;
                    } else {
                        c25564a.alN = this.alH - this.alA.getEndPadding();
                    }
                    obj = 1;
                }
                if (obj == null) {
                    if (getChildCount() != 0) {
                        if (c25564a.alO) {
                            bW = m40465fi(c31880s.getItemCount());
                        } else {
                            bW = m40464fh(c31880s.getItemCount());
                        }
                        if (bW != null) {
                            C25564a.m40515a(c25564a, bW);
                            if (!c31880s.apv && mo1774iE()) {
                                obj = (this.alA.mo31893bf(bW) >= this.alA.mo31906jf() || this.alA.mo31894bg(bW) < this.alA.mo31905je()) ? 1 : null;
                                if (obj != null) {
                                    if (c25564a.alO) {
                                        T = this.alA.mo31906jf();
                                    } else {
                                        T = this.alA.mo31905je();
                                    }
                                    c25564a.alN = T;
                                }
                            }
                            obj = 1;
                            if (obj == null) {
                                C25564a.m40526g(c25564a);
                                c25564a.mPosition = 0;
                                c25564a.bui = 0;
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
                AppMethodBeat.m2505o(54816);
                throw assertionError;
            }
        }
        mo31845b(c25374o);
        if (this.btZ.alO) {
            m40452b(this.btZ, false, true);
        } else {
            m40447a(this.btZ, false, true);
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mWidth, this.aoJ);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.mHeight, this.aoK);
        int i3 = this.mWidth;
        int i4 = this.mHeight;
        if (mo19366ua()) {
            obj = (this.buc == C8415j.INVALID_ID || this.buc == i3) ? null : 1;
            if (this.btY.alm) {
                i = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i = this.btY.alg;
            }
            i2 = i;
        } else {
            obj = (this.bud == C8415j.INVALID_ID || this.bud == i4) ? null : 1;
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
            if (mo19366ua()) {
                if (this.bty.size() > 0) {
                    this.btO.mo59567d(this.bty, i3);
                    this.btO.mo59558a(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, i3, this.btZ.mPosition, this.bty);
                } else {
                    this.btO.mo59571fb(itemCount);
                    this.btO.mo59559a(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, 0, this.bty);
                }
            } else if (this.bty.size() > 0) {
                this.btO.mo59567d(this.bty, i3);
                this.btO.mo59558a(this.btP, makeMeasureSpec2, makeMeasureSpec, i2, i3, this.btZ.mPosition, this.bty);
            } else {
                this.btO.mo59571fb(itemCount);
                this.btO.mo59565c(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, 0, this.bty);
            }
            this.bty = this.btP.bty;
            this.btO.mo59573x(makeMeasureSpec, makeMeasureSpec2, i3);
            this.btO.mo59568eY(i3);
        } else if (!this.btZ.alO) {
            this.bty.clear();
            if ($assertionsDisabled || this.btO.btv != null) {
                this.btP.reset();
                if (mo19366ua()) {
                    this.btO.mo59562b(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, this.btZ.mPosition, this.bty);
                } else {
                    this.btO.mo59566d(this.btP, makeMeasureSpec, makeMeasureSpec2, i2, this.btZ.mPosition, this.bty);
                }
                this.bty = this.btP.bty;
                this.btO.mo59564bk(makeMeasureSpec, makeMeasureSpec2);
                this.btO.mo59572ul();
                this.btZ.bui = this.btO.btv[this.btZ.mPosition];
                this.btY.bui = this.btZ.bui;
            } else {
                assertionError = new AssertionError();
                AppMethodBeat.m2505o(54816);
                throw assertionError;
            }
        }
        if (this.btZ.alO) {
            m40441a(c25374o, c31880s, this.btY);
            i = this.btY.f5223Lp;
            m40447a(this.btZ, true, false);
            m40441a(c25374o, c31880s, this.btY);
            T = this.btY.f5223Lp;
        } else {
            m40441a(c25374o, c31880s, this.btY);
            T = this.btY.f5223Lp;
            m40452b(this.btZ, true, false);
            m40441a(c25374o, c31880s, this.btY);
            i = this.btY.f5223Lp;
        }
        if (getChildCount() > 0) {
            if (this.btZ.alO) {
                m40448b(m40440a(T, c25374o, c31880s, true) + i, c25374o, c31880s, false);
                AppMethodBeat.m2505o(54816);
                return;
            }
            m40440a(T + m40448b(i, c25374o, c31880s, true), c25374o, c31880s, false);
        }
        AppMethodBeat.m2505o(54816);
    }

    /* renamed from: b */
    private int m40448b(int i, C25374o c25374o, C31880s c31880s, boolean z) {
        int je;
        int i2;
        AppMethodBeat.m2504i(54817);
        if (mo19366ua() || !this.f5222hq) {
            je = i - this.alA.mo31905je();
            if (je > 0) {
                i2 = -m40459d(je, c25374o, c31880s);
            } else {
                AppMethodBeat.m2505o(54817);
                return 0;
            }
        }
        je = this.alA.mo31906jf() - i;
        if (je > 0) {
            i2 = m40459d(-je, c25374o, c31880s);
        } else {
            AppMethodBeat.m2505o(54817);
            return 0;
        }
        je = i + i2;
        if (z) {
            je -= this.alA.mo31905je();
            if (je > 0) {
                this.alA.mo31899cc(-je);
                i2 -= je;
                AppMethodBeat.m2505o(54817);
                return i2;
            }
        }
        AppMethodBeat.m2505o(54817);
        return i2;
    }

    /* renamed from: a */
    private int m40440a(int i, C25374o c25374o, C31880s c31880s, boolean z) {
        int d;
        AppMethodBeat.m2504i(54818);
        int i2 = (mo19366ua() || !this.f5222hq) ? 0 : 1;
        if (i2 != 0) {
            i2 = i - this.alA.mo31905je();
            if (i2 > 0) {
                d = m40459d(i2, c25374o, c31880s);
            } else {
                AppMethodBeat.m2505o(54818);
                return 0;
            }
        }
        i2 = this.alA.mo31906jf() - i;
        if (i2 > 0) {
            d = -m40459d(-i2, c25374o, c31880s);
        } else {
            AppMethodBeat.m2505o(54818);
            return 0;
        }
        i2 = i + d;
        if (z) {
            i2 = this.alA.mo31906jf() - i2;
            if (i2 > 0) {
                this.alA.mo31899cc(i2);
                d += i2;
                AppMethodBeat.m2505o(54818);
                return d;
            }
        }
        AppMethodBeat.m2505o(54818);
        return d;
    }

    /* renamed from: a */
    public final void mo1753a(C31880s c31880s) {
        AppMethodBeat.m2504i(54819);
        super.mo1753a(c31880s);
        this.bub = null;
        this.alG = -1;
        this.alH = C8415j.INVALID_ID;
        this.buh = -1;
        C25564a.m40519b(this.btZ);
        this.bue.clear();
        AppMethodBeat.m2505o(54819);
    }

    /* renamed from: fh */
    private View m40464fh(int i) {
        AppMethodBeat.m2504i(54820);
        if ($assertionsDisabled || this.btO.btv != null) {
            View z = m40477z(0, getChildCount(), i);
            if (z == null) {
                AppMethodBeat.m2505o(54820);
                return null;
            }
            int i2 = this.btO.btv[C17480i.m27148bt(z)];
            if (i2 == -1) {
                AppMethodBeat.m2505o(54820);
                return null;
            }
            View a = m40444a(z, (C41633b) this.bty.get(i2));
            AppMethodBeat.m2505o(54820);
            return a;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(54820);
        throw assertionError;
    }

    /* renamed from: fi */
    private View m40465fi(int i) {
        AppMethodBeat.m2504i(54821);
        if ($assertionsDisabled || this.btO.btv != null) {
            View z = m40477z(getChildCount() - 1, -1, i);
            if (z == null) {
                AppMethodBeat.m2505o(54821);
                return null;
            }
            View b = m40450b(z, (C41633b) this.bty.get(this.btO.btv[C17480i.m27148bt(z)]));
            AppMethodBeat.m2505o(54821);
            return b;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(54821);
        throw assertionError;
    }

    /* renamed from: z */
    private View m40477z(int i, int i2, int i3) {
        AppMethodBeat.m2504i(54822);
        m40476uo();
        m40467iJ();
        int je = this.alA.mo31905je();
        int jf = this.alA.mo31906jf();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int bt = C17480i.m27148bt(childAt);
            if (bt >= 0 && bt < i3) {
                if (((android.support.p069v7.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).aoM.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        view2 = childAt;
                        i += i4;
                        view = view3;
                    }
                } else if (this.alA.mo31893bf(childAt) >= je && this.alA.mo31894bg(childAt) <= jf) {
                    AppMethodBeat.m2505o(54822);
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
            AppMethodBeat.m2505o(54822);
            return view;
        }
        AppMethodBeat.m2505o(54822);
        return view2;
    }

    /* renamed from: iM */
    private View m40468iM() {
        AppMethodBeat.m2504i(138959);
        View childAt = getChildAt(0);
        AppMethodBeat.m2505o(138959);
        return childAt;
    }

    /* renamed from: D */
    private boolean m40438D(View view, int i) {
        AppMethodBeat.m2504i(54827);
        if (mo19366ua() || !this.f5222hq) {
            if (this.alA.mo31894bg(view) <= i) {
                AppMethodBeat.m2505o(54827);
                return true;
            }
            AppMethodBeat.m2505o(54827);
            return false;
        } else if (this.alA.getEnd() - this.alA.mo31893bf(view) <= i) {
            AppMethodBeat.m2505o(54827);
            return true;
        } else {
            AppMethodBeat.m2505o(54827);
            return false;
        }
    }

    /* renamed from: E */
    private boolean m40439E(View view, int i) {
        AppMethodBeat.m2504i(54829);
        if (mo19366ua() || !this.f5222hq) {
            if (this.alA.mo31893bf(view) >= this.alA.getEnd() - i) {
                AppMethodBeat.m2505o(54829);
                return true;
            }
            AppMethodBeat.m2505o(54829);
            return false;
        } else if (this.alA.mo31894bg(view) <= i) {
            AppMethodBeat.m2505o(54829);
            return true;
        } else {
            AppMethodBeat.m2505o(54829);
            return false;
        }
    }

    /* renamed from: a */
    private void m40445a(C25374o c25374o, int i, int i2) {
        AppMethodBeat.m2504i(54830);
        while (i2 >= i) {
            mo31826a(i2, c25374o);
            i2--;
        }
        AppMethodBeat.m2505o(54830);
    }

    /* renamed from: a */
    private int m40443a(C41633b c41633b, C25565b c25565b) {
        AppMethodBeat.m2504i(54831);
        if ($assertionsDisabled || this.btO.btw != null) {
            int i;
            int i2;
            float f;
            float f2;
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i3 = this.mHeight;
            int i4 = c25565b.f5223Lp;
            int i5 = c25565b.f5223Lp;
            if (c25565b.f5224sE == -1) {
                i = i5 + c41633b.btk;
                i2 = i4 - c41633b.btk;
            } else {
                i = i5;
                i2 = i4;
            }
            int i6 = c25565b.mPosition;
            float f3 = 0.0f;
            switch (this.btC) {
                case 0:
                    f = (float) paddingTop;
                    f2 = (float) (i3 - paddingBottom);
                    break;
                case 1:
                    f = (float) ((i3 - c41633b.bti) + paddingBottom);
                    f2 = (float) (c41633b.bti - paddingTop);
                    break;
                case 2:
                    f = ((float) paddingTop) + (((float) (i3 - c41633b.bti)) / 2.0f);
                    f2 = ((float) (i3 - paddingBottom)) - (((float) (i3 - c41633b.bti)) / 2.0f);
                    break;
                case 3:
                    f = (float) paddingTop;
                    f3 = ((float) (i3 - c41633b.bti)) / (c41633b.apt != 1 ? (float) (c41633b.apt - 1) : 1.0f);
                    f2 = (float) (i3 - paddingBottom);
                    break;
                case 4:
                    if (c41633b.apt != 0) {
                        f3 = ((float) (i3 - c41633b.bti)) / ((float) c41633b.apt);
                    }
                    f = ((float) paddingTop) + (f3 / 2.0f);
                    f2 = ((float) (i3 - paddingBottom)) - (f3 / 2.0f);
                    break;
                case 5:
                    if (c41633b.apt != 0) {
                        f3 = ((float) (i3 - c41633b.bti)) / ((float) (c41633b.apt + 1));
                    }
                    f = ((float) paddingTop) + f3;
                    f2 = ((float) (i3 - paddingBottom)) - f3;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.btC);
                    AppMethodBeat.m2505o(54831);
                    throw illegalStateException;
            }
            float i7 = f - ((float) this.btZ.buj);
            float i8 = f2 - ((float) this.btZ.buj);
            float max = Math.max(f3, 0.0f);
            paddingTop = 0;
            int i9 = c41633b.apt;
            int i10 = i6;
            while (i10 < i6 + i9) {
                int i11;
                View eU = mo19330eU(i10);
                if (eU != null) {
                    long j = this.btO.btw[i10];
                    int at = C37287c.m62639at(j);
                    int au = C37287c.m62640au(j);
                    android.support.p069v7.widget.RecyclerView.LayoutParams layoutParams = (LayoutParams) eU.getLayoutParams();
                    if (m40453b(eU, at, au, layoutParams)) {
                        eU.measure(at, au);
                    }
                    float bB = i7 + ((float) (layoutParams.topMargin + C17480i.m27144bB(eU)));
                    float bC = i8 - ((float) (layoutParams.rightMargin + C17480i.m27145bC(eU)));
                    if (c25565b.f5224sE == 1) {
                        mo31859g(eU, btW);
                        addView(eU);
                        i11 = paddingTop;
                    } else {
                        mo31859g(eU, btW);
                        addView(eU, paddingTop);
                        i11 = paddingTop + 1;
                    }
                    i3 = i2 + C17480i.m27146bD(eU);
                    au = i - C17480i.m27147bE(eU);
                    if (this.f5222hq) {
                        if (this.btX) {
                            this.btO.mo59556a(eU, c41633b, this.f5222hq, au - eU.getMeasuredWidth(), Math.round(bC) - eU.getMeasuredHeight(), au, Math.round(bC));
                        } else {
                            this.btO.mo59556a(eU, c41633b, this.f5222hq, au - eU.getMeasuredWidth(), Math.round(bB), au, eU.getMeasuredHeight() + Math.round(bB));
                        }
                    } else if (this.btX) {
                        this.btO.mo59556a(eU, c41633b, this.f5222hq, i3, Math.round(bC) - eU.getMeasuredHeight(), i3 + eU.getMeasuredWidth(), Math.round(bC));
                    } else {
                        this.btO.mo59556a(eU, c41633b, this.f5222hq, i3, Math.round(bB), i3 + eU.getMeasuredWidth(), eU.getMeasuredHeight() + Math.round(bB));
                    }
                    f3 = (((float) ((eU.getMeasuredHeight() + layoutParams.topMargin) + C17480i.m27145bC(eU))) + max) + bB;
                    f = bC - (((float) (C17480i.m27144bB(eU) + (eU.getMeasuredHeight() + layoutParams.bottomMargin))) + max);
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
            c25565b.bui += this.btY.f5224sE;
            i5 = c41633b.btk;
            AppMethodBeat.m2505o(54831);
            return i5;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(54831);
        throw assertionError;
    }

    /* renamed from: ua */
    public final boolean mo19366ua() {
        return this.btA == 0 || this.btA == 1;
    }

    /* renamed from: a */
    private void m40447a(C25564a c25564a, boolean z, boolean z2) {
        AppMethodBeat.m2504i(54832);
        if (z2) {
            m40475un();
        } else {
            this.btY.alm = false;
        }
        if (mo19366ua() || !this.f5222hq) {
            this.btY.alg = this.alA.mo31906jf() - c25564a.alN;
        } else {
            this.btY.alg = c25564a.alN - getPaddingRight();
        }
        this.btY.mPosition = c25564a.mPosition;
        this.btY.ali = 1;
        this.btY.f5224sE = 1;
        this.btY.f5223Lp = c25564a.alN;
        this.btY.alS = C8415j.INVALID_ID;
        this.btY.bui = c25564a.bui;
        if (z && this.bty.size() > 1 && c25564a.bui >= 0 && c25564a.bui < this.bty.size() - 1) {
            C41633b c41633b = (C41633b) this.bty.get(c25564a.bui);
            this.btY.bui = this.btY.bui + 1;
            C25565b c25565b = this.btY;
            c25565b.mPosition = c41633b.apt + c25565b.mPosition;
        }
        AppMethodBeat.m2505o(54832);
    }

    /* renamed from: b */
    private void m40452b(C25564a c25564a, boolean z, boolean z2) {
        AppMethodBeat.m2504i(54833);
        if (z2) {
            m40475un();
        } else {
            this.btY.alm = false;
        }
        if (mo19366ua() || !this.f5222hq) {
            this.btY.alg = c25564a.alN - this.alA.mo31905je();
        } else {
            this.btY.alg = (this.bug.getWidth() - c25564a.alN) - this.alA.mo31905je();
        }
        this.btY.mPosition = c25564a.mPosition;
        this.btY.ali = 1;
        this.btY.f5224sE = -1;
        this.btY.f5223Lp = c25564a.alN;
        this.btY.alS = C8415j.INVALID_ID;
        this.btY.bui = c25564a.bui;
        if (z && c25564a.bui > 0 && this.bty.size() > c25564a.bui) {
            C41633b c41633b = (C41633b) this.bty.get(c25564a.bui);
            this.btY.bui = this.btY.bui - 1;
            C25565b c25565b = this.btY;
            c25565b.mPosition -= c41633b.apt;
        }
        AppMethodBeat.m2505o(54833);
    }

    /* renamed from: un */
    private void m40475un() {
        int i;
        boolean z;
        AppMethodBeat.m2504i(54834);
        if (mo19366ua()) {
            i = this.aoK;
        } else {
            i = this.aoJ;
        }
        C25565b c25565b = this.btY;
        if (i == 0 || i == C8415j.INVALID_ID) {
            z = true;
        } else {
            z = false;
        }
        c25565b.alm = z;
        AppMethodBeat.m2505o(54834);
    }

    /* renamed from: uo */
    private void m40476uo() {
        AppMethodBeat.m2504i(54835);
        if (this.alA != null) {
            AppMethodBeat.m2505o(54835);
            return;
        }
        if (mo19366ua()) {
            if (this.btB != 0) {
                this.alA = C17487am.m27242e(this);
                this.bua = C17487am.m27241d(this);
                AppMethodBeat.m2505o(54835);
                return;
            }
        } else if (this.btB == 0) {
            this.alA = C17487am.m27242e(this);
            this.bua = C17487am.m27241d(this);
            AppMethodBeat.m2505o(54835);
            return;
        }
        this.alA = C17487am.m27241d(this);
        this.bua = C17487am.m27242e(this);
        AppMethodBeat.m2505o(54835);
    }

    /* renamed from: iJ */
    private void m40467iJ() {
        AppMethodBeat.m2504i(54836);
        if (this.btY == null) {
            this.btY = new C25565b();
        }
        AppMethodBeat.m2505o(54836);
    }

    /* renamed from: bY */
    public final void mo1762bY(int i) {
        AppMethodBeat.m2504i(54837);
        this.alG = i;
        this.alH = C8415j.INVALID_ID;
        if (this.bub != null) {
            this.bub.alX = -1;
        }
        requestLayout();
        AppMethodBeat.m2505o(54837);
    }

    /* renamed from: a */
    public final void mo1755a(RecyclerView recyclerView, int i) {
        AppMethodBeat.m2504i(54838);
        C41189ah c41189ah = new C41189ah(recyclerView.getContext());
        c41189ah.ape = i;
        mo31829a((C37139r) c41189ah);
        AppMethodBeat.m2505o(54838);
    }

    /* renamed from: f */
    public final void mo31856f(RecyclerView recyclerView) {
        AppMethodBeat.m2504i(54839);
        super.mo31856f(recyclerView);
        this.bug = (View) recyclerView.getParent();
        AppMethodBeat.m2505o(54839);
    }

    /* renamed from: a */
    public final void mo1756a(RecyclerView recyclerView, C25374o c25374o) {
        AppMethodBeat.m2504i(54840);
        super.mo1756a(recyclerView, c25374o);
        if (this.alI) {
            mo31854d(c25374o);
            c25374o.clear();
        }
        AppMethodBeat.m2505o(54840);
    }

    /* renamed from: iG */
    public final boolean mo1776iG() {
        AppMethodBeat.m2504i(54841);
        if (!mo19366ua() || this.mWidth > this.bug.getWidth()) {
            AppMethodBeat.m2505o(54841);
            return true;
        }
        AppMethodBeat.m2505o(54841);
        return false;
    }

    /* renamed from: iH */
    public final boolean mo1777iH() {
        AppMethodBeat.m2504i(54842);
        if (mo19366ua() || this.mHeight > this.bug.getHeight()) {
            AppMethodBeat.m2505o(54842);
            return true;
        }
        AppMethodBeat.m2505o(54842);
        return false;
    }

    /* renamed from: a */
    public final int mo1746a(int i, C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(54843);
        int fj;
        if (mo19366ua()) {
            fj = m40466fj(i);
            C25564a c25564a = this.btZ;
            c25564a.buj = c25564a.buj + fj;
            this.bua.mo31899cc(-fj);
            AppMethodBeat.m2505o(54843);
            return fj;
        }
        fj = m40459d(i, c25374o, c31880s);
        this.bue.clear();
        AppMethodBeat.m2505o(54843);
        return fj;
    }

    /* renamed from: b */
    public final int mo1759b(int i, C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(54844);
        int d;
        if (mo19366ua()) {
            d = m40459d(i, c25374o, c31880s);
            this.bue.clear();
            AppMethodBeat.m2505o(54844);
            return d;
        }
        d = m40466fj(i);
        C25564a c25564a = this.btZ;
        c25564a.buj = c25564a.buj + d;
        this.bua.mo31899cc(-d);
        AppMethodBeat.m2505o(54844);
        return d;
    }

    /* renamed from: d */
    private int m40459d(int i, C25374o c25374o, C31880s c31880s) {
        int i2 = 1;
        AppMethodBeat.m2504i(54845);
        if (getChildCount() == 0 || i == 0) {
            AppMethodBeat.m2505o(54845);
            return 0;
        }
        m40476uo();
        this.btY.bum = true;
        int i3 = (mo19366ua() || !this.f5222hq) ? 0 : 1;
        if (i3 != 0) {
            if (i >= 0) {
                i2 = -1;
            }
        } else if (i <= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        m40454bo(i2, abs);
        int a = this.btY.alS + m40441a(c25374o, c31880s, this.btY);
        if (a < 0) {
            AppMethodBeat.m2505o(54845);
            return 0;
        }
        if (i3 != 0) {
            if (abs > a) {
                i = (-i2) * a;
            }
        } else if (abs > a) {
            i = i2 * a;
        }
        this.alA.mo31899cc(-i);
        this.btY.alV = i;
        AppMethodBeat.m2505o(54845);
        return i;
    }

    /* renamed from: fj */
    private int m40466fj(int i) {
        Object obj = null;
        AppMethodBeat.m2504i(54846);
        if (getChildCount() == 0 || i == 0) {
            AppMethodBeat.m2505o(54846);
            return 0;
        }
        int width;
        int i2;
        m40476uo();
        boolean ua = mo19366ua();
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
        if (C0477s.m893T(this.aiB) == 1) {
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
        AppMethodBeat.m2505o(54846);
        return i;
    }

    /* renamed from: bo */
    private void m40454bo(int i, int i2) {
        int i3 = 0;
        AppMethodBeat.m2504i(54847);
        if ($assertionsDisabled || this.btO.btv != null) {
            C25565b c25565b;
            this.btY.f5224sE = i;
            boolean ua = mo19366ua();
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mWidth, this.aoJ);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.mHeight, this.aoK);
            int i4 = (ua || !this.f5222hq) ? 0 : 1;
            int i5;
            if (i == 1) {
                View childAt = getChildAt(getChildCount() - 1);
                this.btY.f5223Lp = this.alA.mo31894bg(childAt);
                int bt = C17480i.m27148bt(childAt);
                View b = m40450b(childAt, (C41633b) this.bty.get(this.btO.btv[bt]));
                this.btY.ali = 1;
                C25565b c25565b2 = this.btY;
                c25565b2.mPosition = c25565b2.ali + bt;
                if (this.btO.btv.length <= this.btY.mPosition) {
                    this.btY.bui = -1;
                } else {
                    this.btY.bui = this.btO.btv[this.btY.mPosition];
                }
                if (i4 != 0) {
                    this.btY.f5223Lp = this.alA.mo31893bf(b);
                    this.btY.alS = (-this.alA.mo31893bf(b)) + this.alA.mo31905je();
                    C25565b c25565b3 = this.btY;
                    if (this.btY.alS >= 0) {
                        i5 = this.btY.alS;
                    } else {
                        i5 = 0;
                    }
                    c25565b3.alS = i5;
                } else {
                    this.btY.f5223Lp = this.alA.mo31894bg(b);
                    this.btY.alS = this.alA.mo31894bg(b) - this.alA.mo31906jf();
                }
                if ((this.btY.bui == -1 || this.btY.bui > this.bty.size() - 1) && this.btY.mPosition <= getFlexItemCount()) {
                    i4 = i2 - this.btY.alS;
                    this.btP.reset();
                    if (i4 > 0) {
                        if (ua) {
                            this.btO.mo59559a(this.btP, makeMeasureSpec, makeMeasureSpec2, i4, this.btY.mPosition, this.bty);
                        } else {
                            this.btO.mo59565c(this.btP, makeMeasureSpec, makeMeasureSpec2, i4, this.btY.mPosition, this.bty);
                        }
                        this.btO.mo59573x(makeMeasureSpec, makeMeasureSpec2, this.btY.mPosition);
                        this.btO.mo59568eY(this.btY.mPosition);
                    }
                }
            } else {
                View childAt2 = getChildAt(0);
                this.btY.f5223Lp = this.alA.mo31893bf(childAt2);
                makeMeasureSpec2 = C17480i.m27148bt(childAt2);
                View a = m40444a(childAt2, (C41633b) this.bty.get(this.btO.btv[makeMeasureSpec2]));
                this.btY.ali = 1;
                i5 = this.btO.btv[makeMeasureSpec2];
                if (i5 == -1) {
                    makeMeasureSpec = 0;
                } else {
                    makeMeasureSpec = i5;
                }
                if (makeMeasureSpec > 0) {
                    this.btY.mPosition = makeMeasureSpec2 - ((C41633b) this.bty.get(makeMeasureSpec - 1)).apt;
                } else {
                    this.btY.mPosition = -1;
                }
                C25565b c25565b4 = this.btY;
                if (makeMeasureSpec > 0) {
                    i5 = makeMeasureSpec - 1;
                } else {
                    i5 = 0;
                }
                c25565b4.bui = i5;
                if (i4 != 0) {
                    this.btY.f5223Lp = this.alA.mo31894bg(a);
                    this.btY.alS = this.alA.mo31894bg(a) - this.alA.mo31906jf();
                    c25565b = this.btY;
                    if (this.btY.alS >= 0) {
                        i3 = this.btY.alS;
                    }
                    c25565b.alS = i3;
                } else {
                    this.btY.f5223Lp = this.alA.mo31893bf(a);
                    this.btY.alS = (-this.alA.mo31893bf(a)) + this.alA.mo31905je();
                }
            }
            c25565b = this.btY;
            c25565b.alg = i2 - c25565b.alS;
            AppMethodBeat.m2505o(54847);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(54847);
        throw assertionError;
    }

    /* renamed from: a */
    private View m40444a(View view, C41633b c41633b) {
        AppMethodBeat.m2504i(54848);
        boolean ua = mo19366ua();
        int i = c41633b.apt;
        int i2 = 1;
        View view2 = view;
        while (i2 < i) {
            View childAt = getChildAt(i2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.f5222hq || ua) {
                    if (this.alA.mo31893bf(view2) > this.alA.mo31893bf(childAt)) {
                        i2++;
                        view2 = childAt;
                    }
                } else if (this.alA.mo31894bg(view2) < this.alA.mo31894bg(childAt)) {
                    i2++;
                    view2 = childAt;
                }
            }
            childAt = view2;
            i2++;
            view2 = childAt;
        }
        AppMethodBeat.m2505o(54848);
        return view2;
    }

    /* renamed from: b */
    private View m40450b(View view, C41633b c41633b) {
        AppMethodBeat.m2504i(54849);
        boolean ua = mo19366ua();
        int childCount = (getChildCount() - c41633b.apt) - 1;
        int childCount2 = getChildCount() - 2;
        View view2 = view;
        while (childCount2 > childCount) {
            View childAt = getChildAt(childCount2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.f5222hq || ua) {
                    if (this.alA.mo31894bg(view2) < this.alA.mo31894bg(childAt)) {
                        childCount2--;
                        view2 = childAt;
                    }
                } else if (this.alA.mo31893bf(view2) > this.alA.mo31893bf(childAt)) {
                    childCount2--;
                    view2 = childAt;
                }
            }
            childAt = view2;
            childCount2--;
            view2 = childAt;
        }
        AppMethodBeat.m2505o(54849);
        return view2;
    }

    /* renamed from: f */
    public final int mo1768f(C31880s c31880s) {
        AppMethodBeat.m2504i(54850);
        int k = m40472k(c31880s);
        AppMethodBeat.m2505o(54850);
        return k;
    }

    /* renamed from: g */
    public final int mo1769g(C31880s c31880s) {
        AppMethodBeat.m2504i(54851);
        int k = m40472k(c31880s);
        AppMethodBeat.m2505o(54851);
        return k;
    }

    /* renamed from: k */
    private int m40472k(C31880s c31880s) {
        AppMethodBeat.m2504i(54852);
        if (getChildCount() == 0) {
            AppMethodBeat.m2505o(54852);
            return 0;
        }
        int itemCount = c31880s.getItemCount();
        m40476uo();
        View fh = m40464fh(itemCount);
        View fi = m40465fi(itemCount);
        if (c31880s.getItemCount() == 0 || fh == null || fi == null) {
            AppMethodBeat.m2505o(54852);
            return 0;
        }
        int min = Math.min(this.alA.mo31907jg(), this.alA.mo31894bg(fi) - this.alA.mo31893bf(fh));
        AppMethodBeat.m2505o(54852);
        return min;
    }

    /* renamed from: d */
    public final int mo1766d(C31880s c31880s) {
        AppMethodBeat.m2504i(54853);
        m40471j(c31880s);
        int j = m40471j(c31880s);
        AppMethodBeat.m2505o(54853);
        return j;
    }

    /* renamed from: e */
    public final int mo1767e(C31880s c31880s) {
        AppMethodBeat.m2504i(54854);
        int j = m40471j(c31880s);
        AppMethodBeat.m2505o(54854);
        return j;
    }

    /* renamed from: j */
    private int m40471j(C31880s c31880s) {
        AppMethodBeat.m2504i(54855);
        if (getChildCount() == 0) {
            AppMethodBeat.m2505o(54855);
            return 0;
        }
        int itemCount = c31880s.getItemCount();
        View fh = m40464fh(itemCount);
        View fi = m40465fi(itemCount);
        if (c31880s.getItemCount() == 0 || fh == null || fi == null) {
            AppMethodBeat.m2505o(54855);
            return 0;
        } else if ($assertionsDisabled || this.btO.btv != null) {
            int bt = C17480i.m27148bt(fh);
            int bt2 = C17480i.m27148bt(fi);
            itemCount = Math.abs(this.alA.mo31894bg(fi) - this.alA.mo31893bf(fh));
            bt = this.btO.btv[bt];
            if (bt == 0 || bt == -1) {
                AppMethodBeat.m2505o(54855);
                return 0;
            }
            int round = Math.round(((((float) itemCount) / ((float) ((this.btO.btv[bt2] - bt) + 1))) * ((float) bt)) + ((float) (this.alA.mo31905je() - this.alA.mo31893bf(fh))));
            AppMethodBeat.m2505o(54855);
            return round;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(54855);
            throw assertionError;
        }
    }

    /* renamed from: h */
    public final int mo1771h(C31880s c31880s) {
        AppMethodBeat.m2504i(54856);
        int l = m40473l(c31880s);
        AppMethodBeat.m2505o(54856);
        return l;
    }

    /* renamed from: i */
    public final int mo1772i(C31880s c31880s) {
        AppMethodBeat.m2504i(54857);
        int l = m40473l(c31880s);
        AppMethodBeat.m2505o(54857);
        return l;
    }

    /* renamed from: l */
    private int m40473l(C31880s c31880s) {
        AppMethodBeat.m2504i(54858);
        if (getChildCount() == 0) {
            AppMethodBeat.m2505o(54858);
            return 0;
        }
        int itemCount = c31880s.getItemCount();
        View fh = m40464fh(itemCount);
        View fi = m40465fi(itemCount);
        if (c31880s.getItemCount() == 0 || fh == null || fi == null) {
            AppMethodBeat.m2505o(54858);
            return 0;
        } else if ($assertionsDisabled || this.btO.btv != null) {
            int iQ = m40469iQ();
            iQ = (int) ((((float) Math.abs(this.alA.mo31894bg(fi) - this.alA.mo31893bf(fh))) / ((float) ((m40470iS() - iQ) + 1))) * ((float) c31880s.getItemCount()));
            AppMethodBeat.m2505o(54858);
            return iQ;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(54858);
            throw assertionError;
        }
    }

    /* renamed from: b */
    private boolean m40453b(View view, int i, int i2, android.support.p069v7.widget.RecyclerView.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(54859);
        if (!view.isLayoutRequested() && this.aoF && m40474m(view.getWidth(), i, layoutParams.width) && m40474m(view.getHeight(), i2, layoutParams.height)) {
            AppMethodBeat.m2505o(54859);
            return false;
        }
        AppMethodBeat.m2505o(54859);
        return true;
    }

    /* renamed from: m */
    private static boolean m40474m(int i, int i2, int i3) {
        AppMethodBeat.m2504i(54860);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (i3 <= 0 || i == i3) {
            switch (mode) {
                case C8415j.INVALID_ID /*-2147483648*/:
                    if (size >= i) {
                        AppMethodBeat.m2505o(54860);
                        return true;
                    }
                    AppMethodBeat.m2505o(54860);
                    return false;
                case 0:
                    AppMethodBeat.m2505o(54860);
                    return true;
                case ErrorDialogData.SUPPRESSED /*1073741824*/:
                    if (size == i) {
                        AppMethodBeat.m2505o(54860);
                        return true;
                    }
                    AppMethodBeat.m2505o(54860);
                    return false;
                default:
                    AppMethodBeat.m2505o(54860);
                    return false;
            }
        }
        AppMethodBeat.m2505o(54860);
        return false;
    }

    /* renamed from: cb */
    private boolean m40458cb(View view) {
        Object obj;
        AppMethodBeat.m2504i(54861);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingBottom = this.mHeight - getPaddingBottom();
        int by = C17480i.m27152by(view) - ((android.support.p069v7.widget.RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        int bz = C17480i.m27153bz(view) + ((android.support.p069v7.widget.RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
        android.support.p069v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.p069v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        int bA = layoutParams.bottomMargin + C17480i.m27143bA(view);
        if (C17480i.m27151bx(view) - ((android.support.p069v7.widget.RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin >= this.mWidth - getPaddingRight() || bz >= paddingLeft) {
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
            AppMethodBeat.m2505o(54861);
            return false;
        }
        AppMethodBeat.m2505o(54861);
        return true;
    }

    /* renamed from: iQ */
    private int m40469iQ() {
        AppMethodBeat.m2504i(54862);
        View bp = m40455bp(0, getChildCount());
        if (bp == null) {
            AppMethodBeat.m2505o(54862);
            return -1;
        }
        int bt = C17480i.m27148bt(bp);
        AppMethodBeat.m2505o(54862);
        return bt;
    }

    /* renamed from: iS */
    private int m40470iS() {
        AppMethodBeat.m2504i(54863);
        View bp = m40455bp(getChildCount() - 1, -1);
        if (bp == null) {
            AppMethodBeat.m2505o(54863);
            return -1;
        }
        int bt = C17480i.m27148bt(bp);
        AppMethodBeat.m2505o(54863);
        return bt;
    }

    /* renamed from: bp */
    private View m40455bp(int i, int i2) {
        AppMethodBeat.m2504i(54864);
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = getChildAt(i);
            if (m40458cb(childAt)) {
                AppMethodBeat.m2505o(54864);
                return childAt;
            }
            i += i3;
        }
        AppMethodBeat.m2505o(54864);
        return null;
    }

    /* renamed from: v */
    public final int mo19367v(int i, int i2, int i3) {
        AppMethodBeat.m2504i(54799);
        int c = C17480i.m27154c(this.mWidth, this.aoJ, i2, i3, mo1776iG());
        AppMethodBeat.m2505o(54799);
        return c;
    }

    /* renamed from: w */
    public final int mo19368w(int i, int i2, int i3) {
        AppMethodBeat.m2504i(54800);
        int c = C17480i.m27154c(this.mHeight, this.aoK, i2, i3, mo1777iH());
        AppMethodBeat.m2505o(54800);
        return c;
    }

    /* renamed from: a */
    private int m40441a(C25374o c25374o, C31880s c31880s, C25565b c25565b) {
        int a;
        AppMethodBeat.m2504i(54824);
        if (c25565b.alS != C8415j.INVALID_ID) {
            if (c25565b.alg < 0) {
                c25565b.alS += c25565b.alg;
            }
            m40446a(c25374o, c25565b);
        }
        int i = c25565b.alg;
        int i2 = c25565b.alg;
        boolean ua = mo19366ua();
        int i3 = 0;
        int i4 = i2;
        while (true) {
            if (i4 > 0 || this.btY.alm) {
                Object obj;
                List list = this.bty;
                if (c25565b.mPosition < 0 || c25565b.mPosition >= c31880s.getItemCount() || c25565b.bui < 0 || c25565b.bui >= list.size()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    C41633b c41633b = (C41633b) this.bty.get(c25565b.bui);
                    c25565b.mPosition = c41633b.btr;
                    if (!mo19366ua()) {
                        a = m40443a(c41633b, c25565b);
                    } else if ($assertionsDisabled || this.btO.btw != null) {
                        int i5;
                        float f;
                        float f2;
                        int paddingLeft = getPaddingLeft();
                        int paddingRight = getPaddingRight();
                        int i6 = this.mWidth;
                        a = c25565b.f5223Lp;
                        if (c25565b.f5224sE == -1) {
                            i5 = a - c41633b.btk;
                        } else {
                            i5 = a;
                        }
                        int i7 = c25565b.mPosition;
                        float f3 = 0.0f;
                        switch (this.btC) {
                            case 0:
                                f = (float) paddingLeft;
                                f2 = (float) (i6 - paddingRight);
                                break;
                            case 1:
                                f = (float) ((i6 - c41633b.bti) + paddingRight);
                                f2 = (float) (c41633b.bti - paddingLeft);
                                break;
                            case 2:
                                f = ((float) paddingLeft) + (((float) (i6 - c41633b.bti)) / 2.0f);
                                f2 = ((float) (i6 - paddingRight)) - (((float) (i6 - c41633b.bti)) / 2.0f);
                                break;
                            case 3:
                                f = (float) paddingLeft;
                                f3 = ((float) (i6 - c41633b.bti)) / (c41633b.apt != 1 ? (float) (c41633b.apt - 1) : 1.0f);
                                f2 = (float) (i6 - paddingRight);
                                break;
                            case 4:
                                if (c41633b.apt != 0) {
                                    f3 = ((float) (i6 - c41633b.bti)) / ((float) c41633b.apt);
                                }
                                f = ((float) paddingLeft) + (f3 / 2.0f);
                                f2 = ((float) (i6 - paddingRight)) - (f3 / 2.0f);
                                break;
                            case 5:
                                if (c41633b.apt != 0) {
                                    f3 = ((float) (i6 - c41633b.bti)) / ((float) (c41633b.apt + 1));
                                }
                                f = ((float) paddingLeft) + f3;
                                f2 = ((float) (i6 - paddingRight)) - f3;
                                break;
                            default:
                                IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.btC);
                                AppMethodBeat.m2505o(54824);
                                throw illegalStateException;
                        }
                        f -= (float) this.btZ.buj;
                        float i8 = f2 - ((float) this.btZ.buj);
                        float max = Math.max(f3, 0.0f);
                        a = 0;
                        int i9 = c41633b.apt;
                        f2 = f;
                        for (int i10 = i7; i10 < i7 + i9; i10++) {
                            int i11;
                            View eU = mo19330eU(i10);
                            if (eU != null) {
                                if (c25565b.f5224sE == 1) {
                                    mo31859g(eU, btW);
                                    addView(eU);
                                    i11 = a;
                                } else {
                                    mo31859g(eU, btW);
                                    addView(eU, a);
                                    i11 = a + 1;
                                }
                                long j = this.btO.btw[i10];
                                i6 = C37287c.m62639at(j);
                                int au = C37287c.m62640au(j);
                                android.support.p069v7.widget.RecyclerView.LayoutParams layoutParams = (LayoutParams) eU.getLayoutParams();
                                if (m40453b(eU, i6, au, layoutParams)) {
                                    eU.measure(i6, au);
                                }
                                float bD = f2 + ((float) (layoutParams.leftMargin + C17480i.m27146bD(eU)));
                                float bE = i8 - ((float) (layoutParams.rightMargin + C17480i.m27147bE(eU)));
                                paddingRight = i5 + C17480i.m27144bB(eU);
                                if (this.f5222hq) {
                                    this.btO.mo59555a(eU, c41633b, Math.round(bE) - eU.getMeasuredWidth(), paddingRight, Math.round(bE), eU.getMeasuredHeight() + paddingRight);
                                } else {
                                    this.btO.mo59555a(eU, c41633b, Math.round(bD), paddingRight, Math.round(bD) + eU.getMeasuredWidth(), eU.getMeasuredHeight() + paddingRight);
                                }
                                f2 = bE - (((float) (C17480i.m27146bD(eU) + (eU.getMeasuredWidth() + layoutParams.leftMargin))) + max);
                                f = (((float) ((eU.getMeasuredWidth() + layoutParams.rightMargin) + C17480i.m27147bE(eU))) + max) + bD;
                                i8 = f2;
                            } else {
                                i11 = a;
                                f = f2;
                            }
                            a = i11;
                            f2 = f;
                        }
                        c25565b.bui += this.btY.f5224sE;
                        a = c41633b.btk;
                    } else {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.m2505o(54824);
                        throw assertionError;
                    }
                    a += i3;
                    if (ua || !this.f5222hq) {
                        c25565b.f5223Lp += c41633b.btk * c25565b.f5224sE;
                    } else {
                        c25565b.f5223Lp -= c41633b.btk * c25565b.f5224sE;
                    }
                    i3 = a;
                    i4 -= c41633b.btk;
                }
            }
        }
        c25565b.alg -= i3;
        if (c25565b.alS != C8415j.INVALID_ID) {
            c25565b.alS += i3;
            if (c25565b.alg < 0) {
                c25565b.alS += c25565b.alg;
            }
            m40446a(c25374o, c25565b);
        }
        a = i - c25565b.alg;
        AppMethodBeat.m2505o(54824);
        return a;
    }

    /* renamed from: a */
    private void m40446a(C25374o c25374o, C25565b c25565b) {
        AppMethodBeat.m2504i(54825);
        if (!c25565b.bum) {
            AppMethodBeat.m2505o(54825);
        } else if (c25565b.f5224sE == -1) {
            m40456c(c25374o, c25565b);
            AppMethodBeat.m2505o(54825);
        } else {
            m40451b(c25374o, c25565b);
            AppMethodBeat.m2505o(54825);
        }
    }

    /* renamed from: b */
    private void m40451b(C25374o c25374o, C25565b c25565b) {
        int i = -1;
        AppMethodBeat.m2504i(54826);
        if (c25565b.alS < 0) {
            AppMethodBeat.m2505o(54826);
        } else if ($assertionsDisabled || this.btO.btv != null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                AppMethodBeat.m2505o(54826);
                return;
            }
            int i2 = this.btO.btv[C17480i.m27148bt(getChildAt(0))];
            if (i2 == -1) {
                AppMethodBeat.m2505o(54826);
                return;
            }
            C41633b c41633b = (C41633b) this.bty.get(i2);
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!m40438D(childAt, c25565b.alS)) {
                    break;
                }
                if (c41633b.bts == C17480i.m27148bt(childAt)) {
                    if (i2 >= this.bty.size() - 1) {
                        i = i3;
                        break;
                    }
                    i2 += c25565b.f5224sE;
                    c41633b = (C41633b) this.bty.get(i2);
                    i = i3;
                }
            }
            m40445a(c25374o, 0, i);
            AppMethodBeat.m2505o(54826);
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(54826);
            throw assertionError;
        }
    }

    /* renamed from: c */
    private void m40456c(C25374o c25374o, C25565b c25565b) {
        AppMethodBeat.m2504i(54828);
        if (c25565b.alS < 0) {
            AppMethodBeat.m2505o(54828);
        } else if ($assertionsDisabled || this.btO.btv != null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                AppMethodBeat.m2505o(54828);
                return;
            }
            int i = this.btO.btv[C17480i.m27148bt(getChildAt(childCount - 1))];
            if (i == -1) {
                AppMethodBeat.m2505o(54828);
                return;
            }
            int i2 = childCount - 1;
            C41633b c41633b = (C41633b) this.bty.get(i);
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                if (!m40439E(childAt, c25565b.alS)) {
                    break;
                }
                if (c41633b.btr == C17480i.m27148bt(childAt)) {
                    if (i <= 0) {
                        childCount = i3;
                        break;
                    }
                    i += c25565b.f5224sE;
                    c41633b = (C41633b) this.bty.get(i);
                    childCount = i3;
                }
            }
            m40445a(c25374o, childCount, i2);
            AppMethodBeat.m2505o(54828);
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(54828);
            throw assertionError;
        }
    }
}
