package android.support.p069v7.widget;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C17480i.C17481a;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.support.p069v7.widget.RecyclerView.C37139r.C37140b;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.List;

/* renamed from: android.support.v7.widget.LinearLayoutManager */
public class LinearLayoutManager extends C17480i implements C37140b {
    C17487am alA;
    private boolean alB;
    private boolean alC;
    boolean alD;
    private boolean alE;
    private boolean alF;
    int alG;
    int alH;
    private boolean alI;
    SavedState alJ;
    final C0655a alK;
    private final C0656b alL;
    public int alM;
    private C0654c alz;
    int mOrientation;

    /* renamed from: android.support.v7.widget.LinearLayoutManager$c */
    static class C0654c {
        /* renamed from: Lp */
        int f999Lp;
        int alS;
        int alT = 0;
        boolean alU = false;
        int alV;
        List<C41531v> alW = null;
        boolean alf = true;
        int alg;
        int alh;
        int ali;
        boolean alm;
        /* renamed from: sE */
        int f1000sE;

        C0654c() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final boolean mo1790b(C31880s c31880s) {
            return this.alh >= 0 && this.alh < c31880s.getItemCount();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final View mo1789a(C25374o c25374o) {
            if (this.alW != null) {
                return m1462iV();
            }
            View cr = c25374o.mo42373cr(this.alh);
            this.alh += this.ali;
            return cr;
        }

        /* renamed from: iV */
        private View m1462iV() {
            int size = this.alW.size();
            int i = 0;
            while (i < size) {
                View view = ((C41531v) this.alW.get(i)).apJ;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.aoM.isRemoved() || this.alh != layoutParams.aoM.mo66453ki()) {
                    i++;
                } else {
                    mo1791bd(view);
                    return view;
                }
            }
            return null;
        }

        /* renamed from: bd */
        public final void mo1791bd(View view) {
            View be = m1461be(view);
            if (be == null) {
                this.alh = -1;
            } else {
                this.alh = ((LayoutParams) be.getLayoutParams()).aoM.mo66453ki();
            }
        }

        /* renamed from: be */
        private View m1461be(View view) {
            int size = this.alW.size();
            View view2 = null;
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < size) {
                int ki;
                View view3 = ((C41531v) this.alW.get(i2)).apJ;
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                if (!(view3 == view || layoutParams.aoM.isRemoved())) {
                    ki = (layoutParams.aoM.mo66453ki() - this.alh) * this.ali;
                    if (ki >= 0 && ki < i) {
                        if (ki == 0) {
                            return view3;
                        }
                        i2++;
                        i = ki;
                        view2 = view3;
                    }
                }
                ki = i;
                view3 = view2;
                i2++;
                i = ki;
                view2 = view3;
            }
            return view2;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$a */
    static class C0655a {
        C17487am alA;
        int alN;
        boolean alO;
        boolean alP;
        int mPosition;

        C0655a() {
            reset();
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.mPosition = -1;
            this.alN = C8415j.INVALID_ID;
            this.alO = false;
            this.alP = false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: iU */
        public final void mo1792iU() {
            int jf;
            if (this.alO) {
                jf = this.alA.mo31906jf();
            } else {
                jf = this.alA.mo31905je();
            }
            this.alN = jf;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.alN + ", mLayoutFromEnd=" + this.alO + ", mValid=" + this.alP + '}';
        }

        /* renamed from: x */
        public final void mo1795x(View view, int i) {
            int jd = this.alA.mo31904jd();
            if (jd >= 0) {
                mo1796y(view, i);
                return;
            }
            this.mPosition = i;
            int bj;
            int je;
            if (this.alO) {
                jd = (this.alA.mo31906jf() - jd) - this.alA.mo31894bg(view);
                this.alN = this.alA.mo31906jf() - jd;
                if (jd > 0) {
                    bj = this.alN - this.alA.mo31897bj(view);
                    je = this.alA.mo31905je();
                    bj -= je + Math.min(this.alA.mo31893bf(view) - je, 0);
                    if (bj < 0) {
                        this.alN = Math.min(jd, -bj) + this.alN;
                        return;
                    }
                    return;
                }
                return;
            }
            bj = this.alA.mo31893bf(view);
            je = bj - this.alA.mo31905je();
            this.alN = bj;
            if (je > 0) {
                jd = (this.alA.mo31906jf() - Math.min(0, (this.alA.mo31906jf() - jd) - this.alA.mo31894bg(view))) - (bj + this.alA.mo31897bj(view));
                if (jd < 0) {
                    this.alN -= Math.min(je, -jd);
                }
            }
        }

        /* renamed from: y */
        public final void mo1796y(View view, int i) {
            if (this.alO) {
                this.alN = this.alA.mo31894bg(view) + this.alA.mo31904jd();
            } else {
                this.alN = this.alA.mo31893bf(view);
            }
            this.mPosition = i;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$b */
    protected static class C0656b {
        /* renamed from: YP */
        public boolean f1001YP;
        public int alQ;
        public boolean alR;
        public boolean mFinished;

        protected C0656b() {
        }

        /* Access modifiers changed, original: final */
        public final void resetInternal() {
            this.alQ = 0;
            this.mFinished = false;
            this.alR = false;
            this.f1001YP = false;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$SavedState */
    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C06571();
        int alX;
        int alY;
        boolean alZ;

        /* renamed from: android.support.v7.widget.LinearLayoutManager$SavedState$1 */
        static class C06571 implements Creator<SavedState> {
            C06571() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.alX = parcel.readInt();
            this.alY = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.alZ = z;
        }

        public SavedState(SavedState savedState) {
            this.alX = savedState.alX;
            this.alY = savedState.alY;
            this.alZ = savedState.alZ;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: iW */
        public final boolean mo1799iW() {
            return this.alX >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.alX);
            parcel.writeInt(this.alY);
            parcel.writeInt(this.alZ ? 1 : 0);
        }
    }

    public LinearLayoutManager() {
        this(1);
    }

    public LinearLayoutManager(int i) {
        this.mOrientation = 1;
        this.alC = false;
        this.alD = false;
        this.alE = false;
        this.alF = true;
        this.alG = -1;
        this.alH = C8415j.INVALID_ID;
        this.alJ = null;
        this.alK = new C0655a();
        this.alL = new C0656b();
        this.alM = 2;
        setOrientation(i);
        mo1758ah(false);
    }

    /* renamed from: iF */
    public final boolean mo1775iF() {
        return true;
    }

    /* renamed from: iA */
    public LayoutParams mo1773iA() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: a */
    public void mo1756a(RecyclerView recyclerView, C25374o c25374o) {
        super.mo1756a(recyclerView, c25374o);
        if (this.alI) {
            mo31854d(c25374o);
            c25374o.clear();
        }
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(mo1780iQ());
            accessibilityEvent.setToIndex(mo1782iS());
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.alJ != null) {
            return new SavedState(this.alJ);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            mo1778iJ();
            int i = this.alB ^ this.alD;
            savedState.alZ = i;
            View iN;
            if (i != 0) {
                iN = m1416iN();
                savedState.alY = this.alA.mo31906jf() - this.alA.mo31894bg(iN);
                savedState.alX = C17480i.m27148bt(iN);
                return savedState;
            }
            iN = m1415iM();
            savedState.alX = C17480i.m27148bt(iN);
            savedState.alY = this.alA.mo31893bf(iN) - this.alA.mo31905je();
            return savedState;
        }
        savedState.alX = -1;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.alJ = (SavedState) parcelable;
            requestLayout();
        }
    }

    /* renamed from: iG */
    public boolean mo1776iG() {
        return this.mOrientation == 0;
    }

    /* renamed from: iH */
    public boolean mo1777iH() {
        return this.mOrientation == 1;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            mo1745T(null);
            if (i != this.mOrientation || this.alA == null) {
                C17487am d;
                switch (i) {
                    case 0:
                        d = C17487am.m27241d(this);
                        break;
                    case 1:
                        d = C17487am.m27242e(this);
                        break;
                    default:
                        throw new IllegalArgumentException("invalid orientation");
                }
                this.alA = d;
                this.alK.alA = this.alA;
                this.mOrientation = i;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
    }

    /* renamed from: iI */
    private void m1413iI() {
        boolean z = true;
        if (this.mOrientation == 1 || !mo1784ib()) {
            z = this.alC;
        } else if (this.alC) {
            z = false;
        }
        this.alD = z;
    }

    /* renamed from: ah */
    public void mo1758ah(boolean z) {
        mo1745T(null);
        if (z != this.alC) {
            this.alC = z;
            requestLayout();
        }
    }

    /* renamed from: bW */
    public View mo1760bW(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int bt = i - C17480i.m27148bt(getChildAt(0));
        if (bt >= 0 && bt < childCount) {
            View childAt = getChildAt(bt);
            if (C17480i.m27148bt(childAt) == i) {
                return childAt;
            }
        }
        return super.mo1760bW(i);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public int mo1764c(C31880s c31880s) {
        int i;
        if (c31880s.ape != -1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.alA.mo31907jg();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo1755a(RecyclerView recyclerView, int i) {
        C41189ah c41189ah = new C41189ah(recyclerView.getContext());
        c41189ah.ape = i;
        mo31829a((C37139r) c41189ah);
    }

    /* renamed from: bX */
    public final PointF mo1761bX(int i) {
        int i2 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < C17480i.m27148bt(getChildAt(0))) {
            z = true;
        }
        if (z != this.alD) {
            i2 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public void mo1765c(C25374o c25374o, C31880s c31880s) {
        if (!(this.alJ == null && this.alG == -1) && c31880s.getItemCount() == 0) {
            mo31854d(c25374o);
            return;
        }
        int bg;
        int i;
        int i2;
        if (this.alJ != null && this.alJ.mo1799iW()) {
            this.alG = this.alJ.alX;
        }
        mo1778iJ();
        this.alz.alf = false;
        m1413iI();
        View focusedChild = getFocusedChild();
        if (!this.alK.alP || this.alG != -1 || this.alJ != null) {
            Object obj;
            this.alK.reset();
            this.alK.alO = this.alD ^ this.alE;
            C0655a c0655a = this.alK;
            if (c31880s.apv || this.alG == -1) {
                obj = null;
            } else if (this.alG < 0 || this.alG >= c31880s.getItemCount()) {
                this.alG = -1;
                this.alH = C8415j.INVALID_ID;
                obj = null;
            } else {
                c0655a.mPosition = this.alG;
                if (this.alJ == null || !this.alJ.mo1799iW()) {
                    if (this.alH == C8415j.INVALID_ID) {
                        focusedChild = mo1760bW(this.alG);
                        if (focusedChild == null) {
                            if (getChildCount() > 0) {
                                c0655a.alO = (this.alG < C17480i.m27148bt(getChildAt(0))) == this.alD;
                            }
                            c0655a.mo1792iU();
                        } else if (this.alA.mo31897bj(focusedChild) > this.alA.mo31907jg()) {
                            c0655a.mo1792iU();
                        } else if (this.alA.mo31893bf(focusedChild) - this.alA.mo31905je() < 0) {
                            c0655a.alN = this.alA.mo31905je();
                            c0655a.alO = false;
                        } else if (this.alA.mo31906jf() - this.alA.mo31894bg(focusedChild) < 0) {
                            c0655a.alN = this.alA.mo31906jf();
                            c0655a.alO = true;
                        } else {
                            if (c0655a.alO) {
                                bg = this.alA.mo31894bg(focusedChild) + this.alA.mo31904jd();
                            } else {
                                bg = this.alA.mo31893bf(focusedChild);
                            }
                            c0655a.alN = bg;
                        }
                        obj = 1;
                    } else {
                        c0655a.alO = this.alD;
                        if (this.alD) {
                            c0655a.alN = this.alA.mo31906jf() - this.alH;
                        } else {
                            c0655a.alN = this.alA.mo31905je() + this.alH;
                        }
                    }
                    obj = 1;
                } else {
                    c0655a.alO = this.alJ.alZ;
                    if (c0655a.alO) {
                        c0655a.alN = this.alA.mo31906jf() - this.alJ.alY;
                    } else {
                        c0655a.alN = this.alA.mo31905je() + this.alJ.alY;
                    }
                    obj = 1;
                }
            }
            if (obj == null) {
                if (getChildCount() != 0) {
                    View focusedChild2 = getFocusedChild();
                    if (focusedChild2 != null) {
                        LayoutParams layoutParams = (LayoutParams) focusedChild2.getLayoutParams();
                        if (layoutParams.aoM.isRemoved() || layoutParams.aoM.mo66453ki() < 0 || layoutParams.aoM.mo66453ki() >= c31880s.getItemCount()) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            c0655a.mo1795x(focusedChild2, C17480i.m27148bt(focusedChild2));
                            obj = 1;
                            if (obj == null) {
                                c0655a.mo1792iU();
                                if (this.alE) {
                                    bg = c31880s.getItemCount() - 1;
                                } else {
                                    bg = 0;
                                }
                                c0655a.mPosition = bg;
                            }
                        }
                    }
                    if (this.alB == this.alE) {
                        C31880s c31880s2;
                        if (c0655a.alO) {
                            if (!this.alD) {
                                focusedChild = m1412d(c25374o, c31880s);
                            }
                            c31880s2 = c31880s;
                            focusedChild = mo1747a(c25374o, c31880s2, 0, getChildCount(), c31880s2.getItemCount());
                        } else {
                            if (this.alD) {
                                focusedChild = m1412d(c25374o, c31880s);
                            }
                            c31880s2 = c31880s;
                            focusedChild = mo1747a(c25374o, c31880s2, 0, getChildCount(), c31880s2.getItemCount());
                        }
                        if (focusedChild != null) {
                            c0655a.mo1796y(focusedChild, C17480i.m27148bt(focusedChild));
                            if (!c31880s.apv && mo1774iE()) {
                                obj = (this.alA.mo31893bf(focusedChild) >= this.alA.mo31906jf() || this.alA.mo31894bg(focusedChild) < this.alA.mo31905je()) ? 1 : null;
                                if (obj != null) {
                                    if (c0655a.alO) {
                                        bg = this.alA.mo31906jf();
                                    } else {
                                        bg = this.alA.mo31905je();
                                    }
                                    c0655a.alN = bg;
                                }
                            }
                            obj = 1;
                            if (obj == null) {
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                }
            }
            this.alK.alP = true;
        } else if (focusedChild != null && (this.alA.mo31893bf(focusedChild) >= this.alA.mo31906jf() || this.alA.mo31894bg(focusedChild) <= this.alA.mo31905je())) {
            this.alK.mo1795x(focusedChild, C17480i.m27148bt(focusedChild));
        }
        int c = mo1764c(c31880s);
        if (this.alz.alV >= 0) {
            i = 0;
            bg = c;
        } else {
            bg = 0;
            i = c;
        }
        c = this.alA.mo31905je() + i;
        bg += this.alA.getEndPadding();
        if (!(!c31880s.apv || this.alG == -1 || this.alH == C8415j.INVALID_ID)) {
            View bW = mo1760bW(this.alG);
            if (bW != null) {
                if (this.alD) {
                    i = (this.alA.mo31906jf() - this.alA.mo31894bg(bW)) - this.alH;
                } else {
                    i = this.alH - (this.alA.mo31893bf(bW) - this.alA.mo31905je());
                }
                if (i > 0) {
                    c += i;
                } else {
                    bg -= i;
                }
            }
        }
        i = this.alK.alO ? this.alD ? 1 : -1 : this.alD ? -1 : 1;
        mo1751a(c25374o, c31880s, this.alK, i);
        mo31845b(c25374o);
        this.alz.alm = m1414iK();
        this.alz.alU = c31880s.apv;
        C0654c c0654c;
        if (this.alK.alO) {
            m1409b(this.alK);
            this.alz.alT = c;
            m1398a(c25374o, this.alz, c31880s, false);
            c = this.alz.f999Lp;
            i2 = this.alz.alh;
            if (this.alz.alg > 0) {
                bg += this.alz.alg;
            }
            m1400a(this.alK);
            this.alz.alT = bg;
            c0654c = this.alz;
            c0654c.alh += this.alz.ali;
            m1398a(c25374o, this.alz, c31880s, false);
            i = this.alz.f999Lp;
            if (this.alz.alg > 0) {
                bg = this.alz.alg;
                m1404ag(i2, c);
                this.alz.alT = bg;
                m1398a(c25374o, this.alz, c31880s, false);
                bg = this.alz.f999Lp;
            } else {
                bg = c;
            }
            c = i;
        } else {
            m1400a(this.alK);
            this.alz.alT = bg;
            m1398a(c25374o, this.alz, c31880s, false);
            i = this.alz.f999Lp;
            i2 = this.alz.alh;
            if (this.alz.alg > 0) {
                c += this.alz.alg;
            }
            m1409b(this.alK);
            this.alz.alT = c;
            c0654c = this.alz;
            c0654c.alh += this.alz.ali;
            m1398a(c25374o, this.alz, c31880s, false);
            bg = this.alz.f999Lp;
            if (this.alz.alg > 0) {
                c = this.alz.alg;
                m1403af(i2, i);
                this.alz.alT = c;
                m1398a(c25374o, this.alz, c31880s, false);
                c = this.alz.f999Lp;
            } else {
                c = i;
            }
        }
        if (getChildCount() <= 0) {
            i = bg;
        } else if ((this.alD ^ this.alE) != 0) {
            i = m1397a(c, c25374o, c31880s, true);
            bg += i;
            c += i;
            i = m1408b(bg, c25374o, c31880s, false);
            c += i;
            i = bg + i;
        } else {
            i = m1408b(bg, c25374o, c31880s, true);
            bg += i;
            c += i;
            i = m1397a(c, c25374o, c31880s, false);
            c += i;
            i = bg + i;
        }
        if (c31880s.apz && getChildCount() != 0 && !c31880s.apv && mo1774iE()) {
            int i3 = 0;
            int i4 = 0;
            List list = c25374o.aoY;
            int size = list.size();
            int bt = C17480i.m27148bt(getChildAt(0));
            int i5 = 0;
            while (i5 < size) {
                C41531v c41531v = (C41531v) list.get(i5);
                if (c41531v.isRemoved()) {
                    bg = i3;
                    i2 = i4;
                } else {
                    if (((c41531v.mo66453ki() < bt) != this.alD ? -1 : 1) == -1) {
                        bg = this.alA.mo31897bj(c41531v.apJ) + i3;
                        i2 = i4;
                    } else {
                        i2 = i4 + this.alA.mo31897bj(c41531v.apJ);
                        bg = i3;
                    }
                }
                i5++;
                i3 = bg;
                i4 = i2;
            }
            this.alz.alW = list;
            if (i3 > 0) {
                m1404ag(C17480i.m27148bt(m1415iM()), i);
                this.alz.alT = i3;
                this.alz.alg = 0;
                this.alz.mo1791bd(null);
                m1398a(c25374o, this.alz, c31880s, false);
            }
            if (i4 > 0) {
                m1403af(C17480i.m27148bt(m1416iN()), c);
                this.alz.alT = i4;
                this.alz.alg = 0;
                this.alz.mo1791bd(null);
                m1398a(c25374o, this.alz, c31880s, false);
            }
            this.alz.alW = null;
        }
        if (c31880s.apv) {
            this.alK.reset();
        } else {
            C17487am c17487am = this.alA;
            c17487am.amQ = c17487am.mo31907jg();
        }
        this.alB = this.alE;
    }

    /* renamed from: a */
    public void mo1753a(C31880s c31880s) {
        super.mo1753a(c31880s);
        this.alJ = null;
        this.alG = -1;
        this.alH = C8415j.INVALID_ID;
        this.alK.reset();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo1751a(C25374o c25374o, C31880s c31880s, C0655a c0655a, int i) {
    }

    /* renamed from: a */
    private int m1397a(int i, C25374o c25374o, C31880s c31880s, boolean z) {
        int jf = this.alA.mo31906jf() - i;
        if (jf <= 0) {
            return 0;
        }
        jf = -m1410c(-jf, c25374o, c31880s);
        int i2 = i + jf;
        if (!z) {
            return jf;
        }
        i2 = this.alA.mo31906jf() - i2;
        if (i2 <= 0) {
            return jf;
        }
        this.alA.mo31899cc(i2);
        return jf + i2;
    }

    /* renamed from: b */
    private int m1408b(int i, C25374o c25374o, C31880s c31880s, boolean z) {
        int je = i - this.alA.mo31905je();
        if (je <= 0) {
            return 0;
        }
        je = -m1410c(je, c25374o, c31880s);
        int i2 = i + je;
        if (!z) {
            return je;
        }
        i2 -= this.alA.mo31905je();
        if (i2 <= 0) {
            return je;
        }
        this.alA.mo31899cc(-i2);
        return je - i2;
    }

    /* renamed from: a */
    private void m1400a(C0655a c0655a) {
        m1403af(c0655a.mPosition, c0655a.alN);
    }

    /* renamed from: af */
    private void m1403af(int i, int i2) {
        this.alz.alg = this.alA.mo31906jf() - i2;
        this.alz.ali = this.alD ? -1 : 1;
        this.alz.alh = i;
        this.alz.f1000sE = 1;
        this.alz.f999Lp = i2;
        this.alz.alS = C8415j.INVALID_ID;
    }

    /* renamed from: b */
    private void m1409b(C0655a c0655a) {
        m1404ag(c0655a.mPosition, c0655a.alN);
    }

    /* renamed from: ag */
    private void m1404ag(int i, int i2) {
        this.alz.alg = i2 - this.alA.mo31905je();
        this.alz.alh = i;
        this.alz.ali = this.alD ? 1 : -1;
        this.alz.f1000sE = -1;
        this.alz.f999Lp = i2;
        this.alz.alS = C8415j.INVALID_ID;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ib */
    public final boolean mo1784ib() {
        return C0477s.m893T(this.aiB) == 1;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: iJ */
    public void mo1778iJ() {
        if (this.alz == null) {
            this.alz = new C0654c();
        }
    }

    /* renamed from: bY */
    public void mo1762bY(int i) {
        this.alG = i;
        this.alH = C8415j.INVALID_ID;
        if (this.alJ != null) {
            this.alJ.alX = -1;
        }
        requestLayout();
    }

    /* renamed from: ah */
    public void mo1757ah(int i, int i2) {
        this.alG = i;
        this.alH = i2;
        if (this.alJ != null) {
            this.alJ.alX = -1;
        }
        requestLayout();
    }

    /* renamed from: a */
    public int mo1746a(int i, C25374o c25374o, C31880s c31880s) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return m1410c(i, c25374o, c31880s);
    }

    /* renamed from: b */
    public int mo1759b(int i, C25374o c25374o, C31880s c31880s) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return m1410c(i, c25374o, c31880s);
    }

    /* renamed from: d */
    public int mo1766d(C31880s c31880s) {
        return m1419j(c31880s);
    }

    /* renamed from: e */
    public int mo1767e(C31880s c31880s) {
        return m1419j(c31880s);
    }

    /* renamed from: f */
    public int mo1768f(C31880s c31880s) {
        return m1420k(c31880s);
    }

    /* renamed from: g */
    public int mo1769g(C31880s c31880s) {
        return m1420k(c31880s);
    }

    /* renamed from: h */
    public int mo1771h(C31880s c31880s) {
        return m1421l(c31880s);
    }

    /* renamed from: i */
    public int mo1772i(C31880s c31880s) {
        return m1421l(c31880s);
    }

    /* renamed from: j */
    private int m1419j(C31880s c31880s) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        mo1778iJ();
        C17487am c17487am = this.alA;
        View ai = m1406ai(!this.alF);
        if (this.alF) {
            z = false;
        }
        return C17494at.m27290a(c31880s, c17487am, ai, m1407aj(z), this, this.alF, this.alD);
    }

    /* renamed from: k */
    private int m1420k(C31880s c31880s) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        mo1778iJ();
        C17487am c17487am = this.alA;
        View ai = m1406ai(!this.alF);
        if (this.alF) {
            z = false;
        }
        return C17494at.m27289a(c31880s, c17487am, ai, m1407aj(z), this, this.alF);
    }

    /* renamed from: l */
    private int m1421l(C31880s c31880s) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        mo1778iJ();
        C17487am c17487am = this.alA;
        View ai = m1406ai(!this.alF);
        if (this.alF) {
            z = false;
        }
        return C17494at.m27291b(c31880s, c17487am, ai, m1407aj(z), this, this.alF);
    }

    /* renamed from: a */
    private void m1399a(int i, int i2, boolean z, C31880s c31880s) {
        int i3 = -1;
        int i4 = 1;
        this.alz.alm = m1414iK();
        this.alz.alT = mo1764c(c31880s);
        this.alz.f1000sE = i;
        View iN;
        C0654c c0654c;
        if (i == 1) {
            C0654c c0654c2 = this.alz;
            c0654c2.alT += this.alA.getEndPadding();
            iN = m1416iN();
            c0654c = this.alz;
            if (!this.alD) {
                i3 = 1;
            }
            c0654c.ali = i3;
            this.alz.alh = C17480i.m27148bt(iN) + this.alz.ali;
            this.alz.f999Lp = this.alA.mo31894bg(iN);
            i3 = this.alA.mo31894bg(iN) - this.alA.mo31906jf();
        } else {
            iN = m1415iM();
            c0654c = this.alz;
            c0654c.alT += this.alA.mo31905je();
            c0654c = this.alz;
            if (!this.alD) {
                i4 = -1;
            }
            c0654c.ali = i4;
            this.alz.alh = C17480i.m27148bt(iN) + this.alz.ali;
            this.alz.f999Lp = this.alA.mo31893bf(iN);
            i3 = (-this.alA.mo31893bf(iN)) + this.alA.mo31905je();
        }
        this.alz.alg = i2;
        if (z) {
            C0654c c0654c3 = this.alz;
            c0654c3.alg -= i3;
        }
        this.alz.alS = i3;
    }

    /* renamed from: iK */
    private boolean m1414iK() {
        return this.alA.getMode() == 0 && this.alA.getEnd() == 0;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo1754a(C31880s c31880s, C0654c c0654c, C17481a c17481a) {
        int i = c0654c.alh;
        if (i >= 0 && i < c31880s.getItemCount()) {
            c17481a.mo18521T(i, Math.max(0, c0654c.alS));
        }
    }

    /* renamed from: a */
    public final void mo1750a(int i, C17481a c17481a) {
        boolean z;
        int i2;
        if (this.alJ == null || !this.alJ.mo1799iW()) {
            m1413iI();
            z = this.alD;
            if (this.alG == -1) {
                i2 = z ? i - 1 : 0;
            } else {
                i2 = this.alG;
            }
        } else {
            boolean z2 = this.alJ.alZ;
            i2 = this.alJ.alX;
            z = z2;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.alM && i2 >= 0 && i2 < i; i4++) {
            c17481a.mo18521T(i2, 0);
            i2 += i3;
        }
    }

    /* renamed from: a */
    public final void mo1749a(int i, int i2, C31880s c31880s, C17481a c17481a) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            mo1778iJ();
            m1399a(i > 0 ? 1 : -1, Math.abs(i), true, c31880s);
            mo1754a(c31880s, this.alz, c17481a);
        }
    }

    /* renamed from: c */
    private int m1410c(int i, C25374o c25374o, C31880s c31880s) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.alz.alf = true;
        mo1778iJ();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m1399a(i2, abs, true, c31880s);
        int a = this.alz.alS + m1398a(c25374o, this.alz, c31880s, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.alA.mo31899cc(-i);
        this.alz.alV = i;
        return i;
    }

    /* renamed from: T */
    public final void mo1745T(String str) {
        if (this.alJ == null) {
            super.mo1745T(str);
        }
    }

    /* renamed from: a */
    private void m1401a(C25374o c25374o, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    mo31826a(i3, c25374o);
                }
                return;
            }
            while (i > i2) {
                mo31826a(i, c25374o);
                i--;
            }
        }
    }

    /* renamed from: a */
    private void m1402a(C25374o c25374o, C0654c c0654c) {
        if (c0654c.alf && !c0654c.alm) {
            int i;
            int childCount;
            int end;
            View childAt;
            View childAt2;
            if (c0654c.f1000sE == -1) {
                i = c0654c.alS;
                childCount = getChildCount();
                if (i >= 0) {
                    end = this.alA.getEnd() - i;
                    if (this.alD) {
                        for (i = 0; i < childCount; i++) {
                            childAt = getChildAt(i);
                            if (this.alA.mo31893bf(childAt) < end || this.alA.mo31896bi(childAt) < end) {
                                m1401a(c25374o, 0, i);
                                return;
                            }
                        }
                        return;
                    }
                    for (i = childCount - 1; i >= 0; i--) {
                        childAt2 = getChildAt(i);
                        if (this.alA.mo31893bf(childAt2) < end || this.alA.mo31896bi(childAt2) < end) {
                            m1401a(c25374o, childCount - 1, i);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            childCount = c0654c.alS;
            if (childCount >= 0) {
                end = getChildCount();
                if (this.alD) {
                    for (i = end - 1; i >= 0; i--) {
                        childAt2 = getChildAt(i);
                        if (this.alA.mo31894bg(childAt2) > childCount || this.alA.mo31895bh(childAt2) > childCount) {
                            m1401a(c25374o, end - 1, i);
                            return;
                        }
                    }
                    return;
                }
                for (i = 0; i < end; i++) {
                    childAt = getChildAt(i);
                    if (this.alA.mo31894bg(childAt) > childCount || this.alA.mo31895bh(childAt) > childCount) {
                        m1401a(c25374o, 0, i);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private int m1398a(C25374o c25374o, C0654c c0654c, C31880s c31880s, boolean z) {
        int i = c0654c.alg;
        if (c0654c.alS != C8415j.INVALID_ID) {
            if (c0654c.alg < 0) {
                c0654c.alS += c0654c.alg;
            }
            m1402a(c25374o, c0654c);
        }
        int i2 = c0654c.alg + c0654c.alT;
        C0656b c0656b = this.alL;
        while (true) {
            if ((!c0654c.alm && i2 <= 0) || !c0654c.mo1790b(c31880s)) {
                break;
            }
            c0656b.resetInternal();
            mo1752a(c25374o, c31880s, c0654c, c0656b);
            if (!c0656b.mFinished) {
                c0654c.f999Lp += c0656b.alQ * c0654c.f1000sE;
                if (!(c0656b.alR && this.alz.alW == null && c31880s.apv)) {
                    c0654c.alg -= c0656b.alQ;
                    i2 -= c0656b.alQ;
                }
                if (c0654c.alS != C8415j.INVALID_ID) {
                    c0654c.alS += c0656b.alQ;
                    if (c0654c.alg < 0) {
                        c0654c.alS += c0654c.alg;
                    }
                    m1402a(c25374o, c0654c);
                }
                if (z && c0656b.f1001YP) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0654c.alg;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo1752a(C25374o c25374o, C31880s c31880s, C0654c c0654c, C0656b c0656b) {
        View a = c0654c.mo1789a(c25374o);
        if (a == null) {
            c0656b.mFinished = true;
            return;
        }
        int i;
        int i2;
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        boolean z;
        boolean z2;
        if (c0654c.alW == null) {
            z = this.alD;
            if (c0654c.f1000sE == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z == z2) {
                addView(a, -1);
            } else {
                addView(a, 0);
            }
        } else {
            z = this.alD;
            if (c0654c.f1000sE == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z == z2) {
                mo31882z(a, -1);
            } else {
                mo31882z(a, 0);
            }
        }
        mo31849bu(a);
        c0656b.alQ = this.alA.mo31897bj(a);
        int paddingRight;
        int bk;
        if (this.mOrientation == 1) {
            if (mo1784ib()) {
                paddingRight = this.mWidth - getPaddingRight();
                bk = paddingRight - this.alA.mo31898bk(a);
            } else {
                bk = getPaddingLeft();
                paddingRight = this.alA.mo31898bk(a) + bk;
            }
            if (c0654c.f1000sE == -1) {
                i = c0654c.f999Lp;
                i2 = c0654c.f999Lp - c0656b.alQ;
                i3 = bk;
                i4 = paddingRight;
            } else {
                i2 = c0654c.f999Lp;
                i = c0654c.f999Lp + c0656b.alQ;
                i3 = bk;
                i4 = paddingRight;
            }
        } else {
            bk = getPaddingTop();
            paddingRight = this.alA.mo31898bk(a) + bk;
            if (c0654c.f1000sE == -1) {
                i4 = c0654c.f999Lp;
                i3 = c0654c.f999Lp - c0656b.alQ;
                i2 = bk;
                i = paddingRight;
            } else {
                i3 = c0654c.f999Lp;
                i4 = c0654c.f999Lp + c0656b.alQ;
                i2 = bk;
                i = paddingRight;
            }
        }
        C17480i.m27161k(a, i3, i2, i4, i);
        if (layoutParams.aoM.isRemoved() || layoutParams.aoM.mo66467kx()) {
            c0656b.alR = true;
        }
        c0656b.f1001YP = a.hasFocusable();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: iL */
    public final boolean mo1779iL() {
        if (!(this.aoK == ErrorDialogData.SUPPRESSED || this.aoJ == ErrorDialogData.SUPPRESSED)) {
            boolean z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bZ */
    public final int mo1763bZ(int i) {
        switch (i) {
            case 1:
                if (this.mOrientation == 1 || !mo1784ib()) {
                    return -1;
                }
                return 1;
            case 2:
                if (this.mOrientation == 1) {
                    return 1;
                }
                if (mo1784ib()) {
                    return -1;
                }
                return 1;
            case 17:
                return this.mOrientation != 0 ? C8415j.INVALID_ID : -1;
            case 33:
                return this.mOrientation != 1 ? C8415j.INVALID_ID : -1;
            case 66:
                return this.mOrientation == 0 ? 1 : C8415j.INVALID_ID;
            case 130:
                return this.mOrientation == 1 ? 1 : C8415j.INVALID_ID;
            default:
                return C8415j.INVALID_ID;
        }
    }

    /* renamed from: iM */
    private View m1415iM() {
        return getChildAt(this.alD ? getChildCount() - 1 : 0);
    }

    /* renamed from: iN */
    private View m1416iN() {
        return getChildAt(this.alD ? 0 : getChildCount() - 1);
    }

    /* renamed from: ai */
    private View m1406ai(boolean z) {
        if (this.alD) {
            return m1411c(getChildCount() - 1, -1, z, true);
        }
        return m1411c(0, getChildCount(), z, true);
    }

    /* renamed from: aj */
    private View m1407aj(boolean z) {
        if (this.alD) {
            return m1411c(0, getChildCount(), z, true);
        }
        return m1411c(getChildCount() - 1, -1, z, true);
    }

    /* renamed from: d */
    private View m1412d(C25374o c25374o, C31880s c31880s) {
        return mo1747a(c25374o, c31880s, getChildCount() - 1, -1, c31880s.getItemCount());
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public View mo1747a(C25374o c25374o, C31880s c31880s, int i, int i2, int i3) {
        mo1778iJ();
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
                if (((LayoutParams) childAt.getLayoutParams()).aoM.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        view2 = childAt;
                        i += i4;
                        view = view3;
                    }
                } else if (this.alA.mo31893bf(childAt) < jf && this.alA.mo31894bg(childAt) >= je) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        i += i4;
                        view = view3;
                    }
                }
            }
            view3 = view;
            i += i4;
            view = view3;
        }
        return view != null ? view : view2;
    }

    /* renamed from: iO */
    private View m1417iO() {
        return m1405ai(0, getChildCount());
    }

    /* renamed from: iP */
    private View m1418iP() {
        return m1405ai(getChildCount() - 1, -1);
    }

    /* renamed from: iQ */
    public final int mo1780iQ() {
        View c = m1411c(0, getChildCount(), false, true);
        return c == null ? -1 : C17480i.m27148bt(c);
    }

    /* renamed from: iR */
    public final int mo1781iR() {
        View c = m1411c(0, getChildCount(), true, false);
        return c == null ? -1 : C17480i.m27148bt(c);
    }

    /* renamed from: iS */
    public final int mo1782iS() {
        View c = m1411c(getChildCount() - 1, -1, false, true);
        if (c == null) {
            return -1;
        }
        return C17480i.m27148bt(c);
    }

    /* renamed from: iT */
    public final int mo1783iT() {
        View c = m1411c(getChildCount() - 1, -1, true, false);
        if (c == null) {
            return -1;
        }
        return C17480i.m27148bt(c);
    }

    /* renamed from: c */
    private View m1411c(int i, int i2, boolean z, boolean z2) {
        int i3;
        int i4 = 320;
        mo1778iJ();
        if (z) {
            i3 = 24579;
        } else {
            i3 = 320;
        }
        if (!z2) {
            i4 = 0;
        }
        if (this.mOrientation == 0) {
            return this.aoA.mo31924k(i, i2, i3, i4);
        }
        return this.aoB.mo31924k(i, i2, i3, i4);
    }

    /* renamed from: ai */
    private View m1405ai(int i, int i2) {
        mo1778iJ();
        Object obj = i2 > i ? 1 : i2 < i ? -1 : null;
        if (obj == null) {
            return getChildAt(i);
        }
        int i3;
        int i4;
        if (this.alA.mo31893bf(getChildAt(i)) < this.alA.mo31905je()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.aoA.mo31924k(i, i2, i3, i4);
        }
        return this.aoB.mo31924k(i, i2, i3, i4);
    }

    /* renamed from: a */
    public View mo1748a(View view, int i, C25374o c25374o, C31880s c31880s) {
        m1413iI();
        if (getChildCount() == 0) {
            return null;
        }
        int bZ = mo1763bZ(i);
        if (bZ == C8415j.INVALID_ID) {
            return null;
        }
        View iP;
        View view2;
        mo1778iJ();
        mo1778iJ();
        m1399a(bZ, (int) (0.33333334f * ((float) this.alA.mo31907jg())), false, c31880s);
        this.alz.alS = C8415j.INVALID_ID;
        this.alz.alf = false;
        m1398a(c25374o, this.alz, c31880s, true);
        if (bZ == -1) {
            if (this.alD) {
                iP = m1418iP();
            } else {
                iP = m1417iO();
            }
            view2 = iP;
        } else {
            if (this.alD) {
                iP = m1417iO();
            } else {
                iP = m1418iP();
            }
            view2 = iP;
        }
        if (bZ == -1) {
            iP = m1415iM();
        } else {
            iP = m1416iN();
        }
        if (!iP.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return iP;
    }

    /* renamed from: iE */
    public boolean mo1774iE() {
        return this.alJ == null && this.alB == this.alE;
    }
}
