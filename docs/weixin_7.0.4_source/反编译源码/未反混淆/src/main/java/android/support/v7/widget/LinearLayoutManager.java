package android.support.v7.widget;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.j;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.List;

public class LinearLayoutManager extends i implements android.support.v7.widget.RecyclerView.r.b {
    am alA;
    private boolean alB;
    private boolean alC;
    boolean alD;
    private boolean alE;
    private boolean alF;
    int alG;
    int alH;
    private boolean alI;
    SavedState alJ;
    final a alK;
    private final b alL;
    public int alM;
    private c alz;
    int mOrientation;

    static class c {
        int Lp;
        int alS;
        int alT = 0;
        boolean alU = false;
        int alV;
        List<v> alW = null;
        boolean alf = true;
        int alg;
        int alh;
        int ali;
        boolean alm;
        int sE;

        c() {
        }

        /* Access modifiers changed, original: final */
        public final boolean b(s sVar) {
            return this.alh >= 0 && this.alh < sVar.getItemCount();
        }

        /* Access modifiers changed, original: final */
        public final View a(o oVar) {
            if (this.alW != null) {
                return iV();
            }
            View cr = oVar.cr(this.alh);
            this.alh += this.ali;
            return cr;
        }

        private View iV() {
            int size = this.alW.size();
            int i = 0;
            while (i < size) {
                View view = ((v) this.alW.get(i)).apJ;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.aoM.isRemoved() || this.alh != layoutParams.aoM.ki()) {
                    i++;
                } else {
                    bd(view);
                    return view;
                }
            }
            return null;
        }

        public final void bd(View view) {
            View be = be(view);
            if (be == null) {
                this.alh = -1;
            } else {
                this.alh = ((LayoutParams) be.getLayoutParams()).aoM.ki();
            }
        }

        private View be(View view) {
            int size = this.alW.size();
            View view2 = null;
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < size) {
                int ki;
                View view3 = ((v) this.alW.get(i2)).apJ;
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                if (!(view3 == view || layoutParams.aoM.isRemoved())) {
                    ki = (layoutParams.aoM.ki() - this.alh) * this.ali;
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

    static class a {
        am alA;
        int alN;
        boolean alO;
        boolean alP;
        int mPosition;

        a() {
            reset();
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.mPosition = -1;
            this.alN = j.INVALID_ID;
            this.alO = false;
            this.alP = false;
        }

        /* Access modifiers changed, original: final */
        public final void iU() {
            int jf;
            if (this.alO) {
                jf = this.alA.jf();
            } else {
                jf = this.alA.je();
            }
            this.alN = jf;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.alN + ", mLayoutFromEnd=" + this.alO + ", mValid=" + this.alP + '}';
        }

        public final void x(View view, int i) {
            int jd = this.alA.jd();
            if (jd >= 0) {
                y(view, i);
                return;
            }
            this.mPosition = i;
            int bj;
            int je;
            if (this.alO) {
                jd = (this.alA.jf() - jd) - this.alA.bg(view);
                this.alN = this.alA.jf() - jd;
                if (jd > 0) {
                    bj = this.alN - this.alA.bj(view);
                    je = this.alA.je();
                    bj -= je + Math.min(this.alA.bf(view) - je, 0);
                    if (bj < 0) {
                        this.alN = Math.min(jd, -bj) + this.alN;
                        return;
                    }
                    return;
                }
                return;
            }
            bj = this.alA.bf(view);
            je = bj - this.alA.je();
            this.alN = bj;
            if (je > 0) {
                jd = (this.alA.jf() - Math.min(0, (this.alA.jf() - jd) - this.alA.bg(view))) - (bj + this.alA.bj(view));
                if (jd < 0) {
                    this.alN -= Math.min(je, -jd);
                }
            }
        }

        public final void y(View view, int i) {
            if (this.alO) {
                this.alN = this.alA.bg(view) + this.alA.jd();
            } else {
                this.alN = this.alA.bf(view);
            }
            this.mPosition = i;
        }
    }

    protected static class b {
        public boolean YP;
        public int alQ;
        public boolean alR;
        public boolean mFinished;

        protected b() {
        }

        /* Access modifiers changed, original: final */
        public final void resetInternal() {
            this.alQ = 0;
            this.mFinished = false;
            this.alR = false;
            this.YP = false;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        int alX;
        int alY;
        boolean alZ;

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
        public final boolean iW() {
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
        this.alH = j.INVALID_ID;
        this.alJ = null;
        this.alK = new a();
        this.alL = new b();
        this.alM = 2;
        setOrientation(i);
        ah(false);
    }

    public final boolean iF() {
        return true;
    }

    public LayoutParams iA() {
        return new LayoutParams(-2, -2);
    }

    public void a(RecyclerView recyclerView, o oVar) {
        super.a(recyclerView, oVar);
        if (this.alI) {
            d(oVar);
            oVar.clear();
        }
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(iQ());
            accessibilityEvent.setToIndex(iS());
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.alJ != null) {
            return new SavedState(this.alJ);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            iJ();
            int i = this.alB ^ this.alD;
            savedState.alZ = i;
            View iN;
            if (i != 0) {
                iN = iN();
                savedState.alY = this.alA.jf() - this.alA.bg(iN);
                savedState.alX = i.bt(iN);
                return savedState;
            }
            iN = iM();
            savedState.alX = i.bt(iN);
            savedState.alY = this.alA.bf(iN) - this.alA.je();
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

    public boolean iG() {
        return this.mOrientation == 0;
    }

    public boolean iH() {
        return this.mOrientation == 1;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            T(null);
            if (i != this.mOrientation || this.alA == null) {
                am d;
                switch (i) {
                    case 0:
                        d = am.d(this);
                        break;
                    case 1:
                        d = am.e(this);
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

    private void iI() {
        boolean z = true;
        if (this.mOrientation == 1 || !ib()) {
            z = this.alC;
        } else if (this.alC) {
            z = false;
        }
        this.alD = z;
    }

    public void ah(boolean z) {
        T(null);
        if (z != this.alC) {
            this.alC = z;
            requestLayout();
        }
    }

    public View bW(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int bt = i - i.bt(getChildAt(0));
        if (bt >= 0 && bt < childCount) {
            View childAt = getChildAt(bt);
            if (i.bt(childAt) == i) {
                return childAt;
            }
        }
        return super.bW(i);
    }

    /* Access modifiers changed, original: protected */
    public int c(s sVar) {
        int i;
        if (sVar.ape != -1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.alA.jg();
        }
        return 0;
    }

    public void a(RecyclerView recyclerView, int i) {
        ah ahVar = new ah(recyclerView.getContext());
        ahVar.ape = i;
        a((r) ahVar);
    }

    public final PointF bX(int i) {
        int i2 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < i.bt(getChildAt(0))) {
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
    public void c(o oVar, s sVar) {
        if (!(this.alJ == null && this.alG == -1) && sVar.getItemCount() == 0) {
            d(oVar);
            return;
        }
        int bg;
        int i;
        int i2;
        if (this.alJ != null && this.alJ.iW()) {
            this.alG = this.alJ.alX;
        }
        iJ();
        this.alz.alf = false;
        iI();
        View focusedChild = getFocusedChild();
        if (!this.alK.alP || this.alG != -1 || this.alJ != null) {
            Object obj;
            this.alK.reset();
            this.alK.alO = this.alD ^ this.alE;
            a aVar = this.alK;
            if (sVar.apv || this.alG == -1) {
                obj = null;
            } else if (this.alG < 0 || this.alG >= sVar.getItemCount()) {
                this.alG = -1;
                this.alH = j.INVALID_ID;
                obj = null;
            } else {
                aVar.mPosition = this.alG;
                if (this.alJ == null || !this.alJ.iW()) {
                    if (this.alH == j.INVALID_ID) {
                        focusedChild = bW(this.alG);
                        if (focusedChild == null) {
                            if (getChildCount() > 0) {
                                aVar.alO = (this.alG < i.bt(getChildAt(0))) == this.alD;
                            }
                            aVar.iU();
                        } else if (this.alA.bj(focusedChild) > this.alA.jg()) {
                            aVar.iU();
                        } else if (this.alA.bf(focusedChild) - this.alA.je() < 0) {
                            aVar.alN = this.alA.je();
                            aVar.alO = false;
                        } else if (this.alA.jf() - this.alA.bg(focusedChild) < 0) {
                            aVar.alN = this.alA.jf();
                            aVar.alO = true;
                        } else {
                            if (aVar.alO) {
                                bg = this.alA.bg(focusedChild) + this.alA.jd();
                            } else {
                                bg = this.alA.bf(focusedChild);
                            }
                            aVar.alN = bg;
                        }
                        obj = 1;
                    } else {
                        aVar.alO = this.alD;
                        if (this.alD) {
                            aVar.alN = this.alA.jf() - this.alH;
                        } else {
                            aVar.alN = this.alA.je() + this.alH;
                        }
                    }
                    obj = 1;
                } else {
                    aVar.alO = this.alJ.alZ;
                    if (aVar.alO) {
                        aVar.alN = this.alA.jf() - this.alJ.alY;
                    } else {
                        aVar.alN = this.alA.je() + this.alJ.alY;
                    }
                    obj = 1;
                }
            }
            if (obj == null) {
                if (getChildCount() != 0) {
                    View focusedChild2 = getFocusedChild();
                    if (focusedChild2 != null) {
                        LayoutParams layoutParams = (LayoutParams) focusedChild2.getLayoutParams();
                        if (layoutParams.aoM.isRemoved() || layoutParams.aoM.ki() < 0 || layoutParams.aoM.ki() >= sVar.getItemCount()) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            aVar.x(focusedChild2, i.bt(focusedChild2));
                            obj = 1;
                            if (obj == null) {
                                aVar.iU();
                                if (this.alE) {
                                    bg = sVar.getItemCount() - 1;
                                } else {
                                    bg = 0;
                                }
                                aVar.mPosition = bg;
                            }
                        }
                    }
                    if (this.alB == this.alE) {
                        s sVar2;
                        if (aVar.alO) {
                            if (!this.alD) {
                                focusedChild = d(oVar, sVar);
                            }
                            sVar2 = sVar;
                            focusedChild = a(oVar, sVar2, 0, getChildCount(), sVar2.getItemCount());
                        } else {
                            if (this.alD) {
                                focusedChild = d(oVar, sVar);
                            }
                            sVar2 = sVar;
                            focusedChild = a(oVar, sVar2, 0, getChildCount(), sVar2.getItemCount());
                        }
                        if (focusedChild != null) {
                            aVar.y(focusedChild, i.bt(focusedChild));
                            if (!sVar.apv && iE()) {
                                obj = (this.alA.bf(focusedChild) >= this.alA.jf() || this.alA.bg(focusedChild) < this.alA.je()) ? 1 : null;
                                if (obj != null) {
                                    if (aVar.alO) {
                                        bg = this.alA.jf();
                                    } else {
                                        bg = this.alA.je();
                                    }
                                    aVar.alN = bg;
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
        } else if (focusedChild != null && (this.alA.bf(focusedChild) >= this.alA.jf() || this.alA.bg(focusedChild) <= this.alA.je())) {
            this.alK.x(focusedChild, i.bt(focusedChild));
        }
        int c = c(sVar);
        if (this.alz.alV >= 0) {
            i = 0;
            bg = c;
        } else {
            bg = 0;
            i = c;
        }
        c = this.alA.je() + i;
        bg += this.alA.getEndPadding();
        if (!(!sVar.apv || this.alG == -1 || this.alH == j.INVALID_ID)) {
            View bW = bW(this.alG);
            if (bW != null) {
                if (this.alD) {
                    i = (this.alA.jf() - this.alA.bg(bW)) - this.alH;
                } else {
                    i = this.alH - (this.alA.bf(bW) - this.alA.je());
                }
                if (i > 0) {
                    c += i;
                } else {
                    bg -= i;
                }
            }
        }
        i = this.alK.alO ? this.alD ? 1 : -1 : this.alD ? -1 : 1;
        a(oVar, sVar, this.alK, i);
        b(oVar);
        this.alz.alm = iK();
        this.alz.alU = sVar.apv;
        c cVar;
        if (this.alK.alO) {
            b(this.alK);
            this.alz.alT = c;
            a(oVar, this.alz, sVar, false);
            c = this.alz.Lp;
            i2 = this.alz.alh;
            if (this.alz.alg > 0) {
                bg += this.alz.alg;
            }
            a(this.alK);
            this.alz.alT = bg;
            cVar = this.alz;
            cVar.alh += this.alz.ali;
            a(oVar, this.alz, sVar, false);
            i = this.alz.Lp;
            if (this.alz.alg > 0) {
                bg = this.alz.alg;
                ag(i2, c);
                this.alz.alT = bg;
                a(oVar, this.alz, sVar, false);
                bg = this.alz.Lp;
            } else {
                bg = c;
            }
            c = i;
        } else {
            a(this.alK);
            this.alz.alT = bg;
            a(oVar, this.alz, sVar, false);
            i = this.alz.Lp;
            i2 = this.alz.alh;
            if (this.alz.alg > 0) {
                c += this.alz.alg;
            }
            b(this.alK);
            this.alz.alT = c;
            cVar = this.alz;
            cVar.alh += this.alz.ali;
            a(oVar, this.alz, sVar, false);
            bg = this.alz.Lp;
            if (this.alz.alg > 0) {
                c = this.alz.alg;
                af(i2, i);
                this.alz.alT = c;
                a(oVar, this.alz, sVar, false);
                c = this.alz.Lp;
            } else {
                c = i;
            }
        }
        if (getChildCount() <= 0) {
            i = bg;
        } else if ((this.alD ^ this.alE) != 0) {
            i = a(c, oVar, sVar, true);
            bg += i;
            c += i;
            i = b(bg, oVar, sVar, false);
            c += i;
            i = bg + i;
        } else {
            i = b(bg, oVar, sVar, true);
            bg += i;
            c += i;
            i = a(c, oVar, sVar, false);
            c += i;
            i = bg + i;
        }
        if (sVar.apz && getChildCount() != 0 && !sVar.apv && iE()) {
            int i3 = 0;
            int i4 = 0;
            List list = oVar.aoY;
            int size = list.size();
            int bt = i.bt(getChildAt(0));
            int i5 = 0;
            while (i5 < size) {
                v vVar = (v) list.get(i5);
                if (vVar.isRemoved()) {
                    bg = i3;
                    i2 = i4;
                } else {
                    if (((vVar.ki() < bt) != this.alD ? -1 : 1) == -1) {
                        bg = this.alA.bj(vVar.apJ) + i3;
                        i2 = i4;
                    } else {
                        i2 = i4 + this.alA.bj(vVar.apJ);
                        bg = i3;
                    }
                }
                i5++;
                i3 = bg;
                i4 = i2;
            }
            this.alz.alW = list;
            if (i3 > 0) {
                ag(i.bt(iM()), i);
                this.alz.alT = i3;
                this.alz.alg = 0;
                this.alz.bd(null);
                a(oVar, this.alz, sVar, false);
            }
            if (i4 > 0) {
                af(i.bt(iN()), c);
                this.alz.alT = i4;
                this.alz.alg = 0;
                this.alz.bd(null);
                a(oVar, this.alz, sVar, false);
            }
            this.alz.alW = null;
        }
        if (sVar.apv) {
            this.alK.reset();
        } else {
            am amVar = this.alA;
            amVar.amQ = amVar.jg();
        }
        this.alB = this.alE;
    }

    public void a(s sVar) {
        super.a(sVar);
        this.alJ = null;
        this.alG = -1;
        this.alH = j.INVALID_ID;
        this.alK.reset();
    }

    /* Access modifiers changed, original: 0000 */
    public void a(o oVar, s sVar, a aVar, int i) {
    }

    private int a(int i, o oVar, s sVar, boolean z) {
        int jf = this.alA.jf() - i;
        if (jf <= 0) {
            return 0;
        }
        jf = -c(-jf, oVar, sVar);
        int i2 = i + jf;
        if (!z) {
            return jf;
        }
        i2 = this.alA.jf() - i2;
        if (i2 <= 0) {
            return jf;
        }
        this.alA.cc(i2);
        return jf + i2;
    }

    private int b(int i, o oVar, s sVar, boolean z) {
        int je = i - this.alA.je();
        if (je <= 0) {
            return 0;
        }
        je = -c(je, oVar, sVar);
        int i2 = i + je;
        if (!z) {
            return je;
        }
        i2 -= this.alA.je();
        if (i2 <= 0) {
            return je;
        }
        this.alA.cc(-i2);
        return je - i2;
    }

    private void a(a aVar) {
        af(aVar.mPosition, aVar.alN);
    }

    private void af(int i, int i2) {
        this.alz.alg = this.alA.jf() - i2;
        this.alz.ali = this.alD ? -1 : 1;
        this.alz.alh = i;
        this.alz.sE = 1;
        this.alz.Lp = i2;
        this.alz.alS = j.INVALID_ID;
    }

    private void b(a aVar) {
        ag(aVar.mPosition, aVar.alN);
    }

    private void ag(int i, int i2) {
        this.alz.alg = i2 - this.alA.je();
        this.alz.alh = i;
        this.alz.ali = this.alD ? 1 : -1;
        this.alz.sE = -1;
        this.alz.Lp = i2;
        this.alz.alS = j.INVALID_ID;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean ib() {
        return android.support.v4.view.s.T(this.aiB) == 1;
    }

    /* Access modifiers changed, original: protected */
    public void iJ() {
        if (this.alz == null) {
            this.alz = new c();
        }
    }

    public void bY(int i) {
        this.alG = i;
        this.alH = j.INVALID_ID;
        if (this.alJ != null) {
            this.alJ.alX = -1;
        }
        requestLayout();
    }

    public void ah(int i, int i2) {
        this.alG = i;
        this.alH = i2;
        if (this.alJ != null) {
            this.alJ.alX = -1;
        }
        requestLayout();
    }

    public int a(int i, o oVar, s sVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return c(i, oVar, sVar);
    }

    public int b(int i, o oVar, s sVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return c(i, oVar, sVar);
    }

    public int d(s sVar) {
        return j(sVar);
    }

    public int e(s sVar) {
        return j(sVar);
    }

    public int f(s sVar) {
        return k(sVar);
    }

    public int g(s sVar) {
        return k(sVar);
    }

    public int h(s sVar) {
        return l(sVar);
    }

    public int i(s sVar) {
        return l(sVar);
    }

    private int j(s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        iJ();
        am amVar = this.alA;
        View ai = ai(!this.alF);
        if (this.alF) {
            z = false;
        }
        return at.a(sVar, amVar, ai, aj(z), this, this.alF, this.alD);
    }

    private int k(s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        iJ();
        am amVar = this.alA;
        View ai = ai(!this.alF);
        if (this.alF) {
            z = false;
        }
        return at.a(sVar, amVar, ai, aj(z), this, this.alF);
    }

    private int l(s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        iJ();
        am amVar = this.alA;
        View ai = ai(!this.alF);
        if (this.alF) {
            z = false;
        }
        return at.b(sVar, amVar, ai, aj(z), this, this.alF);
    }

    private void a(int i, int i2, boolean z, s sVar) {
        int i3 = -1;
        int i4 = 1;
        this.alz.alm = iK();
        this.alz.alT = c(sVar);
        this.alz.sE = i;
        View iN;
        c cVar;
        if (i == 1) {
            c cVar2 = this.alz;
            cVar2.alT += this.alA.getEndPadding();
            iN = iN();
            cVar = this.alz;
            if (!this.alD) {
                i3 = 1;
            }
            cVar.ali = i3;
            this.alz.alh = i.bt(iN) + this.alz.ali;
            this.alz.Lp = this.alA.bg(iN);
            i3 = this.alA.bg(iN) - this.alA.jf();
        } else {
            iN = iM();
            cVar = this.alz;
            cVar.alT += this.alA.je();
            cVar = this.alz;
            if (!this.alD) {
                i4 = -1;
            }
            cVar.ali = i4;
            this.alz.alh = i.bt(iN) + this.alz.ali;
            this.alz.Lp = this.alA.bf(iN);
            i3 = (-this.alA.bf(iN)) + this.alA.je();
        }
        this.alz.alg = i2;
        if (z) {
            c cVar3 = this.alz;
            cVar3.alg -= i3;
        }
        this.alz.alS = i3;
    }

    private boolean iK() {
        return this.alA.getMode() == 0 && this.alA.getEnd() == 0;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(s sVar, c cVar, android.support.v7.widget.RecyclerView.i.a aVar) {
        int i = cVar.alh;
        if (i >= 0 && i < sVar.getItemCount()) {
            aVar.T(i, Math.max(0, cVar.alS));
        }
    }

    public final void a(int i, android.support.v7.widget.RecyclerView.i.a aVar) {
        boolean z;
        int i2;
        if (this.alJ == null || !this.alJ.iW()) {
            iI();
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
            aVar.T(i2, 0);
            i2 += i3;
        }
    }

    public final void a(int i, int i2, s sVar, android.support.v7.widget.RecyclerView.i.a aVar) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            iJ();
            a(i > 0 ? 1 : -1, Math.abs(i), true, sVar);
            a(sVar, this.alz, aVar);
        }
    }

    private int c(int i, o oVar, s sVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.alz.alf = true;
        iJ();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, sVar);
        int a = this.alz.alS + a(oVar, this.alz, sVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.alA.cc(-i);
        this.alz.alV = i;
        return i;
    }

    public final void T(String str) {
        if (this.alJ == null) {
            super.T(str);
        }
    }

    private void a(o oVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, oVar);
                }
                return;
            }
            while (i > i2) {
                a(i, oVar);
                i--;
            }
        }
    }

    private void a(o oVar, c cVar) {
        if (cVar.alf && !cVar.alm) {
            int i;
            int childCount;
            int end;
            View childAt;
            View childAt2;
            if (cVar.sE == -1) {
                i = cVar.alS;
                childCount = getChildCount();
                if (i >= 0) {
                    end = this.alA.getEnd() - i;
                    if (this.alD) {
                        for (i = 0; i < childCount; i++) {
                            childAt = getChildAt(i);
                            if (this.alA.bf(childAt) < end || this.alA.bi(childAt) < end) {
                                a(oVar, 0, i);
                                return;
                            }
                        }
                        return;
                    }
                    for (i = childCount - 1; i >= 0; i--) {
                        childAt2 = getChildAt(i);
                        if (this.alA.bf(childAt2) < end || this.alA.bi(childAt2) < end) {
                            a(oVar, childCount - 1, i);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            childCount = cVar.alS;
            if (childCount >= 0) {
                end = getChildCount();
                if (this.alD) {
                    for (i = end - 1; i >= 0; i--) {
                        childAt2 = getChildAt(i);
                        if (this.alA.bg(childAt2) > childCount || this.alA.bh(childAt2) > childCount) {
                            a(oVar, end - 1, i);
                            return;
                        }
                    }
                    return;
                }
                for (i = 0; i < end; i++) {
                    childAt = getChildAt(i);
                    if (this.alA.bg(childAt) > childCount || this.alA.bh(childAt) > childCount) {
                        a(oVar, 0, i);
                        return;
                    }
                }
            }
        }
    }

    private int a(o oVar, c cVar, s sVar, boolean z) {
        int i = cVar.alg;
        if (cVar.alS != j.INVALID_ID) {
            if (cVar.alg < 0) {
                cVar.alS += cVar.alg;
            }
            a(oVar, cVar);
        }
        int i2 = cVar.alg + cVar.alT;
        b bVar = this.alL;
        while (true) {
            if ((!cVar.alm && i2 <= 0) || !cVar.b(sVar)) {
                break;
            }
            bVar.resetInternal();
            a(oVar, sVar, cVar, bVar);
            if (!bVar.mFinished) {
                cVar.Lp += bVar.alQ * cVar.sE;
                if (!(bVar.alR && this.alz.alW == null && sVar.apv)) {
                    cVar.alg -= bVar.alQ;
                    i2 -= bVar.alQ;
                }
                if (cVar.alS != j.INVALID_ID) {
                    cVar.alS += bVar.alQ;
                    if (cVar.alg < 0) {
                        cVar.alS += cVar.alg;
                    }
                    a(oVar, cVar);
                }
                if (z && bVar.YP) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.alg;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(o oVar, s sVar, c cVar, b bVar) {
        View a = cVar.a(oVar);
        if (a == null) {
            bVar.mFinished = true;
            return;
        }
        int i;
        int i2;
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        boolean z;
        boolean z2;
        if (cVar.alW == null) {
            z = this.alD;
            if (cVar.sE == -1) {
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
            if (cVar.sE == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z == z2) {
                z(a, -1);
            } else {
                z(a, 0);
            }
        }
        bu(a);
        bVar.alQ = this.alA.bj(a);
        int paddingRight;
        int bk;
        if (this.mOrientation == 1) {
            if (ib()) {
                paddingRight = this.mWidth - getPaddingRight();
                bk = paddingRight - this.alA.bk(a);
            } else {
                bk = getPaddingLeft();
                paddingRight = this.alA.bk(a) + bk;
            }
            if (cVar.sE == -1) {
                i = cVar.Lp;
                i2 = cVar.Lp - bVar.alQ;
                i3 = bk;
                i4 = paddingRight;
            } else {
                i2 = cVar.Lp;
                i = cVar.Lp + bVar.alQ;
                i3 = bk;
                i4 = paddingRight;
            }
        } else {
            bk = getPaddingTop();
            paddingRight = this.alA.bk(a) + bk;
            if (cVar.sE == -1) {
                i4 = cVar.Lp;
                i3 = cVar.Lp - bVar.alQ;
                i2 = bk;
                i = paddingRight;
            } else {
                i3 = cVar.Lp;
                i4 = cVar.Lp + bVar.alQ;
                i2 = bk;
                i = paddingRight;
            }
        }
        i.k(a, i3, i2, i4, i);
        if (layoutParams.aoM.isRemoved() || layoutParams.aoM.kx()) {
            bVar.alR = true;
        }
        bVar.YP = a.hasFocusable();
    }

    /* Access modifiers changed, original: final */
    public final boolean iL() {
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
    public final int bZ(int i) {
        switch (i) {
            case 1:
                if (this.mOrientation == 1 || !ib()) {
                    return -1;
                }
                return 1;
            case 2:
                if (this.mOrientation == 1) {
                    return 1;
                }
                if (ib()) {
                    return -1;
                }
                return 1;
            case 17:
                return this.mOrientation != 0 ? j.INVALID_ID : -1;
            case 33:
                return this.mOrientation != 1 ? j.INVALID_ID : -1;
            case 66:
                return this.mOrientation == 0 ? 1 : j.INVALID_ID;
            case 130:
                return this.mOrientation == 1 ? 1 : j.INVALID_ID;
            default:
                return j.INVALID_ID;
        }
    }

    private View iM() {
        return getChildAt(this.alD ? getChildCount() - 1 : 0);
    }

    private View iN() {
        return getChildAt(this.alD ? 0 : getChildCount() - 1);
    }

    private View ai(boolean z) {
        if (this.alD) {
            return c(getChildCount() - 1, -1, z, true);
        }
        return c(0, getChildCount(), z, true);
    }

    private View aj(boolean z) {
        if (this.alD) {
            return c(0, getChildCount(), z, true);
        }
        return c(getChildCount() - 1, -1, z, true);
    }

    private View d(o oVar, s sVar) {
        return a(oVar, sVar, getChildCount() - 1, -1, sVar.getItemCount());
    }

    /* Access modifiers changed, original: 0000 */
    public View a(o oVar, s sVar, int i, int i2, int i3) {
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
                if (((LayoutParams) childAt.getLayoutParams()).aoM.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        view2 = childAt;
                        i += i4;
                        view = view3;
                    }
                } else if (this.alA.bf(childAt) < jf && this.alA.bg(childAt) >= je) {
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

    private View iO() {
        return ai(0, getChildCount());
    }

    private View iP() {
        return ai(getChildCount() - 1, -1);
    }

    public final int iQ() {
        View c = c(0, getChildCount(), false, true);
        return c == null ? -1 : i.bt(c);
    }

    public final int iR() {
        View c = c(0, getChildCount(), true, false);
        return c == null ? -1 : i.bt(c);
    }

    public final int iS() {
        View c = c(getChildCount() - 1, -1, false, true);
        if (c == null) {
            return -1;
        }
        return i.bt(c);
    }

    public final int iT() {
        View c = c(getChildCount() - 1, -1, true, false);
        if (c == null) {
            return -1;
        }
        return i.bt(c);
    }

    private View c(int i, int i2, boolean z, boolean z2) {
        int i3;
        int i4 = 320;
        iJ();
        if (z) {
            i3 = 24579;
        } else {
            i3 = 320;
        }
        if (!z2) {
            i4 = 0;
        }
        if (this.mOrientation == 0) {
            return this.aoA.k(i, i2, i3, i4);
        }
        return this.aoB.k(i, i2, i3, i4);
    }

    private View ai(int i, int i2) {
        iJ();
        Object obj = i2 > i ? 1 : i2 < i ? -1 : null;
        if (obj == null) {
            return getChildAt(i);
        }
        int i3;
        int i4;
        if (this.alA.bf(getChildAt(i)) < this.alA.je()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.aoA.k(i, i2, i3, i4);
        }
        return this.aoB.k(i, i2, i3, i4);
    }

    public View a(View view, int i, o oVar, s sVar) {
        iI();
        if (getChildCount() == 0) {
            return null;
        }
        int bZ = bZ(i);
        if (bZ == j.INVALID_ID) {
            return null;
        }
        View iP;
        View view2;
        iJ();
        iJ();
        a(bZ, (int) (0.33333334f * ((float) this.alA.jg())), false, sVar);
        this.alz.alS = j.INVALID_ID;
        this.alz.alf = false;
        a(oVar, this.alz, sVar, true);
        if (bZ == -1) {
            if (this.alD) {
                iP = iP();
            } else {
                iP = iO();
            }
            view2 = iP;
        } else {
            if (this.alD) {
                iP = iO();
            } else {
                iP = iP();
            }
            view2 = iP;
        }
        if (bZ == -1) {
            iP = iM();
        } else {
            iP = iN();
        }
        if (!iP.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return iP;
    }

    public boolean iE() {
        return this.alJ == null && this.alB == this.alE;
    }
}
