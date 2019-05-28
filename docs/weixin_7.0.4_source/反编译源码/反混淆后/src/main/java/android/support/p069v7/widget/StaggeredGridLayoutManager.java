package android.support.p069v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.view.p067a.C0445b.C0444c;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C17480i.C17481a;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.support.p069v7.widget.RecyclerView.C37139r.C37140b;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* renamed from: android.support.v7.widget.StaggeredGridLayoutManager */
public final class StaggeredGridLayoutManager extends C17480i implements C37140b {
    private int akU;
    boolean alC;
    boolean alD;
    private boolean alF;
    int alG;
    int alH;
    C31887b[] arR;
    C17487am arS;
    C17487am arT;
    private int arU;
    private final C44968ag arV;
    private BitSet arW;
    LazySpanLookup arX;
    private int arY;
    private boolean arZ;
    private boolean asa;
    private SavedState asb;
    private int asc;
    private final C17485a asd;
    private boolean ase;
    private int[] asf;
    private final Runnable asg;
    private int mOrientation;
    /* renamed from: oT */
    private final Rect f17549oT;

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup */
    static class LazySpanLookup {
        List<FullSpanItem> asm;
        int[] mData;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem */
        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new C06651();
            int asn;
            int[] aso;
            boolean asp;
            int mPosition;

            /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1 */
            static class C06651 implements Creator<FullSpanItem> {
                C06651() {
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new FullSpanItem[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }
            }

            FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.mPosition = parcel.readInt();
                this.asn = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.asp = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.aso = new int[readInt];
                    parcel.readIntArray(this.aso);
                }
            }

            FullSpanItem() {
            }

            /* Access modifiers changed, original: final */
            /* renamed from: cR */
            public final int mo1823cR(int i) {
                return this.aso == null ? 0 : this.aso[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.asn);
                parcel.writeInt(this.asp ? 1 : 0);
                if (this.aso == null || this.aso.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.aso.length);
                parcel.writeIntArray(this.aso);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.asn + ", mHasUnwantedGapAfter=" + this.asp + ", mGapPerSpan=" + Arrays.toString(this.aso) + '}';
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cK */
        public final int mo1817cK(int i) {
            if (this.asm != null) {
                for (int size = this.asm.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.asm.get(size)).mPosition >= i) {
                        this.asm.remove(size);
                    }
                }
            }
            return mo1818cL(i);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cL */
        public final int mo1818cL(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            int cP = m1474cP(i);
            if (cP == -1) {
                int[] iArr = this.mData;
                Arrays.fill(iArr, i, iArr.length, -1);
                return this.mData.length;
            }
            Arrays.fill(this.mData, i, cP + 1, -1);
            return cP + 1;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cM */
        public final int mo1819cM(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            return this.mData[i];
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo1813a(int i, C31887b c31887b) {
            m1473cO(i);
            this.mData[i] = c31887b.mIndex;
        }

        /* renamed from: cN */
        private int m1472cN(int i) {
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* renamed from: cO */
        private void m1473cO(int i) {
            if (this.mData == null) {
                this.mData = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.mData, -1);
            } else if (i >= this.mData.length) {
                int[] iArr = this.mData;
                this.mData = new int[m1472cN(i)];
                System.arraycopy(iArr, 0, this.mData, 0, iArr.length);
                Arrays.fill(this.mData, iArr.length, this.mData.length, -1);
            }
        }

        /* Access modifiers changed, original: final */
        public final void clear() {
            if (this.mData != null) {
                Arrays.fill(this.mData, -1);
            }
            this.asm = null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: aL */
        public final void mo1815aL(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                m1473cO(i + i2);
                int[] iArr = this.mData;
                int i3 = i + i2;
                int[] iArr2 = this.mData;
                System.arraycopy(iArr, i3, iArr2, i, (iArr2.length - i) - i2);
                Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
                m1470aM(i, i2);
            }
        }

        /* renamed from: aM */
        private void m1470aM(int i, int i2) {
            if (this.asm != null) {
                int i3 = i + i2;
                for (int size = this.asm.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.asm.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        if (fullSpanItem.mPosition < i3) {
                            this.asm.remove(size);
                        } else {
                            fullSpanItem.mPosition -= i2;
                        }
                    }
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: aN */
        public final void mo1816aN(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                m1473cO(i + i2);
                int[] iArr = this.mData;
                System.arraycopy(iArr, i, iArr, i + i2, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, i, i + i2, -1);
                m1471aO(i, i2);
            }
        }

        /* renamed from: aO */
        private void m1471aO(int i, int i2) {
            if (this.asm != null) {
                for (int size = this.asm.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.asm.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }

        /* renamed from: cP */
        private int m1474cP(int i) {
            if (this.asm == null) {
                return -1;
            }
            FullSpanItem cQ = mo1820cQ(i);
            if (cQ != null) {
                this.asm.remove(cQ);
            }
            int size = this.asm.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.asm.get(i2)).mPosition >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            cQ = (FullSpanItem) this.asm.get(i2);
            this.asm.remove(i2);
            return cQ.mPosition;
        }

        /* renamed from: a */
        public final void mo1814a(FullSpanItem fullSpanItem) {
            if (this.asm == null) {
                this.asm = new ArrayList();
            }
            int size = this.asm.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.asm.get(i);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.asm.remove(i);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.asm.add(i, fullSpanItem);
                    return;
                }
            }
            this.asm.add(fullSpanItem);
        }

        /* renamed from: cQ */
        public final FullSpanItem mo1820cQ(int i) {
            if (this.asm == null) {
                return null;
            }
            for (int size = this.asm.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.asm.get(size);
                if (fullSpanItem.mPosition == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* renamed from: q */
        public final FullSpanItem mo1822q(int i, int i2, int i3) {
            if (this.asm == null) {
                return null;
            }
            int size = this.asm.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.asm.get(i4);
                if (fullSpanItem.mPosition >= i2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= i && (i3 == 0 || fullSpanItem.asn == i3 || fullSpanItem.asp)) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$a */
    class C17485a {
        /* renamed from: Lp */
        int f4037Lp;
        boolean alO;
        boolean alP;
        boolean ash;
        int[] asi;
        final /* synthetic */ StaggeredGridLayoutManager asj;
        int mPosition;

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.mPosition = -1;
            this.f4037Lp = C8415j.INVALID_ID;
            this.alO = false;
            this.ash = false;
            this.alP = false;
            if (this.asi != null) {
                Arrays.fill(this.asi, -1);
            }
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$SavedState */
    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C253771();
        boolean alC;
        int alX;
        boolean alZ;
        boolean asa;
        List<FullSpanItem> asm;
        int asq;
        int asr;
        int[] ass;
        int ast;
        int[] asu;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$SavedState$1 */
        static class C253771 implements Creator<SavedState> {
            C253771() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.alX = parcel.readInt();
            this.asq = parcel.readInt();
            this.asr = parcel.readInt();
            if (this.asr > 0) {
                this.ass = new int[this.asr];
                parcel.readIntArray(this.ass);
            }
            this.ast = parcel.readInt();
            if (this.ast > 0) {
                this.asu = new int[this.ast];
                parcel.readIntArray(this.asu);
            }
            this.alC = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.alZ = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.asa = z2;
            this.asm = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.asr = savedState.asr;
            this.alX = savedState.alX;
            this.asq = savedState.asq;
            this.ass = savedState.ass;
            this.ast = savedState.ast;
            this.asu = savedState.asu;
            this.alC = savedState.alC;
            this.alZ = savedState.alZ;
            this.asa = savedState.asa;
            this.asm = savedState.asm;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.alX);
            parcel.writeInt(this.asq);
            parcel.writeInt(this.asr);
            if (this.asr > 0) {
                parcel.writeIntArray(this.ass);
            }
            parcel.writeInt(this.ast);
            if (this.ast > 0) {
                parcel.writeIntArray(this.asu);
            }
            if (this.alC) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.alZ) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.asa) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.asm);
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams */
    public static class LayoutParams extends android.support.p069v7.widget.RecyclerView.LayoutParams {
        C31887b ask;
        boolean asl;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: kY */
        public final int mo51966kY() {
            if (this.ask == null) {
                return -1;
            }
            return this.ask.mIndex;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$b */
    class C31887b {
        final /* synthetic */ StaggeredGridLayoutManager asj;
        ArrayList<View> asv;
        int asw;
        int asx;
        int asy;
        final int mIndex;

        /* Access modifiers changed, original: final */
        /* renamed from: cS */
        public final int mo51970cS(int i) {
            if (this.asw != C8415j.INVALID_ID) {
                return this.asw;
            }
            if (this.asv.size() == 0) {
                return i;
            }
            m51718kZ();
            return this.asw;
        }

        /* renamed from: kZ */
        private void m51718kZ() {
            View view = (View) this.asv.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.asw = this.asj.arS.mo31893bf(view);
            if (layoutParams.asl) {
                FullSpanItem cQ = this.asj.arX.mo1820cQ(layoutParams.aoM.mo66453ki());
                if (cQ != null && cQ.asn == -1) {
                    this.asw -= cQ.mo1823cR(this.mIndex);
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: la */
        public final int mo51975la() {
            if (this.asw != C8415j.INVALID_ID) {
                return this.asw;
            }
            m51718kZ();
            return this.asw;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cT */
        public final int mo51971cT(int i) {
            if (this.asx != C8415j.INVALID_ID) {
                return this.asx;
            }
            if (this.asv.size() == 0) {
                return i;
            }
            m51719lb();
            return this.asx;
        }

        /* renamed from: lb */
        private void m51719lb() {
            View view = (View) this.asv.get(this.asv.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.asx = this.asj.arS.mo31894bg(view);
            if (layoutParams.asl) {
                FullSpanItem cQ = this.asj.arX.mo1820cQ(layoutParams.aoM.mo66453ki());
                if (cQ != null && cQ.asn == 1) {
                    this.asx = cQ.mo1823cR(this.mIndex) + this.asx;
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: lc */
        public final int mo51976lc() {
            if (this.asx != C8415j.INVALID_ID) {
                return this.asx;
            }
            m51719lb();
            return this.asx;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: bO */
        public final void mo51968bO(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.ask = this;
            this.asv.add(0, view);
            this.asw = C8415j.INVALID_ID;
            if (this.asv.size() == 1) {
                this.asx = C8415j.INVALID_ID;
            }
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.mo66467kx()) {
                this.asy += this.asj.arS.mo31897bj(view);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: bP */
        public final void mo51969bP(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.ask = this;
            this.asv.add(view);
            this.asx = C8415j.INVALID_ID;
            if (this.asv.size() == 1) {
                this.asw = C8415j.INVALID_ID;
            }
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.mo66467kx()) {
                this.asy += this.asj.arS.mo31897bj(view);
            }
        }

        /* Access modifiers changed, original: final */
        public final void clear() {
            this.asv.clear();
            m51720ld();
            this.asy = 0;
        }

        /* renamed from: ld */
        private void m51720ld() {
            this.asw = C8415j.INVALID_ID;
            this.asx = C8415j.INVALID_ID;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cU */
        public final void mo51972cU(int i) {
            this.asw = i;
            this.asx = i;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: le */
        public final void mo51977le() {
            int size = this.asv.size();
            View view = (View) this.asv.remove(size - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.ask = null;
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.mo66467kx()) {
                this.asy -= this.asj.arS.mo31897bj(view);
            }
            if (size == 1) {
                this.asw = C8415j.INVALID_ID;
            }
            this.asx = C8415j.INVALID_ID;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: lf */
        public final void mo51978lf() {
            View view = (View) this.asv.remove(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.ask = null;
            if (this.asv.size() == 0) {
                this.asx = C8415j.INVALID_ID;
            }
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.mo66467kx()) {
                this.asy -= this.asj.arS.mo31897bj(view);
            }
            this.asw = C8415j.INVALID_ID;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cV */
        public final void mo51973cV(int i) {
            if (this.asw != C8415j.INVALID_ID) {
                this.asw += i;
            }
            if (this.asx != C8415j.INVALID_ID) {
                this.asx += i;
            }
        }

        /* renamed from: lg */
        public final int mo51979lg() {
            if (this.asj.alC) {
                return m51717aP(this.asv.size() - 1, -1);
            }
            return m51717aP(0, this.asv.size());
        }

        /* renamed from: lh */
        public final int mo51980lh() {
            if (this.asj.alC) {
                return m51717aP(0, this.asv.size());
            }
            return m51717aP(this.asv.size() - 1, -1);
        }

        /* renamed from: aP */
        private int m51717aP(int i, int i2) {
            int je = this.asj.arS.mo31905je();
            int jf = this.asj.arS.mo31906jf();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                Object obj;
                View view = (View) this.asv.get(i);
                int bf = this.asj.arS.mo31893bf(view);
                int bg = this.asj.arS.mo31894bg(view);
                if (bf <= jf) {
                    obj = 1;
                } else {
                    obj = null;
                }
                Object obj2;
                if (bg >= je) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj != null && obj2 != null && (bf < je || bg > jf)) {
                    return C17480i.m27148bt(view);
                }
                i += i3;
            }
            return -1;
        }

        /* renamed from: aQ */
        public final View mo51967aQ(int i, int i2) {
            View view = null;
            int i3;
            View view2;
            if (i2 == -1) {
                int size = this.asv.size();
                i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.asv.get(i3);
                    if ((this.asj.alC && C17480i.m27148bt(view2) <= i) || ((!this.asj.alC && C17480i.m27148bt(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            i3 = this.asv.size() - 1;
            while (i3 >= 0) {
                view2 = (View) this.asv.get(i3);
                if ((this.asj.alC && C17480i.m27148bt(view2) >= i) || ((!this.asj.alC && C17480i.m27148bt(view2) <= i) || !view2.hasFocusable())) {
                    break;
                }
                i3--;
                view = view2;
            }
            return view;
        }
    }

    /* renamed from: iF */
    public final boolean mo1775iF() {
        return this.arY != 0;
    }

    /* renamed from: kS */
    private boolean m81103kS() {
        if (getChildCount() == 0 || this.arY == 0 || !this.f4036pv) {
            return false;
        }
        int kW;
        int kX;
        if (this.alD) {
            kW = m81107kW();
            kX = m81108kX();
        } else {
            kW = m81108kX();
            kX = m81107kW();
        }
        if (kW == 0 && m81104kT() != null) {
            this.arX.clear();
            this.aoD = true;
            requestLayout();
            return true;
        } else if (!this.ase) {
            return false;
        } else {
            int i = this.alD ? -1 : 1;
            FullSpanItem q = this.arX.mo1822q(kW, kX + 1, i);
            if (q == null) {
                this.ase = false;
                this.arX.mo1817cK(kX + 1);
                return false;
            }
            FullSpanItem q2 = this.arX.mo1822q(kW, q.mPosition, i * -1);
            if (q2 == null) {
                this.arX.mo1817cK(q.mPosition);
            } else {
                this.arX.mo1817cK(q2.mPosition + 1);
            }
            this.aoD = true;
            requestLayout();
            return true;
        }
    }

    /* renamed from: cm */
    public final void mo15124cm(int i) {
        if (i == 0) {
            m81103kS();
        }
    }

    /* renamed from: a */
    public final void mo1756a(RecyclerView recyclerView, C25374o c25374o) {
        super.mo1756a(recyclerView, c25374o);
        removeCallbacks(this.asg);
        for (int i = 0; i < this.akU; i++) {
            this.arR[i].clear();
        }
        recyclerView.requestLayout();
    }

    /* renamed from: kT */
    private View m81104kT() {
        int i;
        int i2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.akU);
        bitSet.set(0, this.akU, true);
        boolean z = (this.mOrientation == 1 && m81100ib()) ? true : true;
        if (this.alD) {
            i = -1;
        } else {
            i2 = childCount + 1;
            childCount = 0;
            i = i2;
        }
        if (childCount < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = childCount;
        while (i3 != i) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.ask.mIndex)) {
                if (m81079a(layoutParams.ask)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.ask.mIndex);
            }
            if (!(layoutParams.asl || i3 + i2 == i)) {
                boolean z2;
                View childAt2 = getChildAt(i3 + i2);
                int bg;
                if (this.alD) {
                    childCount = this.arS.mo31894bg(childAt);
                    bg = this.arS.mo31894bg(childAt2);
                    if (childCount < bg) {
                        return childAt;
                    }
                    if (childCount == bg) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    childCount = this.arS.mo31893bf(childAt);
                    bg = this.arS.mo31893bf(childAt2);
                    if (childCount > bg) {
                        return childAt;
                    }
                    if (childCount == bg) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    boolean z3;
                    if (layoutParams.ask.mIndex - ((LayoutParams) childAt2.getLayoutParams()).ask.mIndex < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z >= false) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 != z3) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m81079a(C31887b c31887b) {
        if (this.alD) {
            if (c31887b.mo51976lc() < this.arS.mo31906jf()) {
                return !((LayoutParams) ((View) c31887b.asv.get(c31887b.asv.size() + -1)).getLayoutParams()).asl;
            }
        } else if (c31887b.mo51975la() > this.arS.mo31905je()) {
            return !((LayoutParams) ((View) c31887b.asv.get(0)).getLayoutParams()).asl;
        }
        return false;
    }

    /* renamed from: T */
    public final void mo1745T(String str) {
        if (this.asb == null) {
            super.mo1745T(str);
        }
    }

    /* renamed from: iI */
    private void m81099iI() {
        boolean z = true;
        if (this.mOrientation == 1 || !m81100ib()) {
            z = this.alC;
        } else if (this.alC) {
            z = false;
        }
        this.alD = z;
    }

    /* renamed from: ib */
    private boolean m81100ib() {
        return C0477s.m893T(this.aiB) == 1;
    }

    /* renamed from: a */
    public final void mo31827a(Rect rect, int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            paddingTop = C17480i.m27162l(i2, paddingTop + rect.height(), C0477s.m909aa(this.aiB));
            paddingRight = C17480i.m27162l(i, paddingRight + (this.arU * this.akU), C0477s.m899Z(this.aiB));
        } else {
            paddingRight = C17480i.m27162l(i, paddingRight + rect.width(), C0477s.m899Z(this.aiB));
            paddingTop = C17480i.m27162l(i2, paddingTop + (this.arU * this.akU), C0477s.m909aa(this.aiB));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    /* renamed from: c */
    public final void mo1765c(C25374o c25374o, C31880s c31880s) {
        Object obj = 1;
        while (true) {
            Object obj2 = obj;
            C17485a c17485a = this.asd;
            if (!(this.asb == null && this.alG == -1) && c31880s.getItemCount() == 0) {
                mo31854d(c25374o);
                c17485a.reset();
                return;
            }
            Object obj3;
            int i;
            int i2;
            int itemCount;
            int childCount;
            if (c17485a.alP && this.alG == -1 && this.asb == null) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (obj3 != null) {
                boolean z;
                c17485a.reset();
                if (this.asb != null) {
                    if (this.asb.asr > 0) {
                        if (this.asb.asr == this.akU) {
                            for (i = 0; i < this.akU; i++) {
                                this.arR[i].clear();
                                i2 = this.asb.ass[i];
                                if (i2 != C8415j.INVALID_ID) {
                                    if (this.asb.alZ) {
                                        i2 += this.arS.mo31906jf();
                                    } else {
                                        i2 += this.arS.mo31905je();
                                    }
                                }
                                this.arR[i].mo51972cU(i2);
                            }
                        } else {
                            SavedState savedState = this.asb;
                            savedState.ass = null;
                            savedState.asr = 0;
                            savedState.ast = 0;
                            savedState.asu = null;
                            savedState.asm = null;
                            this.asb.alX = this.asb.asq;
                        }
                    }
                    this.asa = this.asb.asa;
                    z = this.asb.alC;
                    mo1745T(null);
                    if (!(this.asb == null || this.asb.alC == z)) {
                        this.asb.alC = z;
                    }
                    this.alC = z;
                    requestLayout();
                    m81099iI();
                    if (this.asb.alX != -1) {
                        this.alG = this.asb.alX;
                        c17485a.alO = this.asb.alZ;
                    } else {
                        c17485a.alO = this.alD;
                    }
                    if (this.asb.ast > 1) {
                        this.arX.mData = this.asb.asu;
                        this.arX.asm = this.asb.asm;
                    }
                } else {
                    m81099iI();
                    c17485a.alO = this.alD;
                }
                if (c31880s.apv || this.alG == -1) {
                    obj = null;
                } else if (this.alG < 0 || this.alG >= c31880s.getItemCount()) {
                    this.alG = -1;
                    this.alH = C8415j.INVALID_ID;
                    obj = null;
                } else {
                    if (this.asb == null || this.asb.alX == -1 || this.asb.asr <= 0) {
                        View bW = mo1760bW(this.alG);
                        if (bW != null) {
                            if (this.alD) {
                                i = m81107kW();
                            } else {
                                i = m81108kX();
                            }
                            c17485a.mPosition = i;
                            if (this.alH != C8415j.INVALID_ID) {
                                if (c17485a.alO) {
                                    c17485a.f4037Lp = (this.arS.mo31906jf() - this.alH) - this.arS.mo31894bg(bW);
                                } else {
                                    c17485a.f4037Lp = (this.arS.mo31905je() + this.alH) - this.arS.mo31893bf(bW);
                                }
                                obj = 1;
                            } else if (this.arS.mo31897bj(bW) > this.arS.mo31907jg()) {
                                if (c17485a.alO) {
                                    i = this.arS.mo31906jf();
                                } else {
                                    i = this.arS.mo31905je();
                                }
                                c17485a.f4037Lp = i;
                            } else {
                                i = this.arS.mo31893bf(bW) - this.arS.mo31905je();
                                if (i < 0) {
                                    c17485a.f4037Lp = -i;
                                } else {
                                    i = this.arS.mo31906jf() - this.arS.mo31894bg(bW);
                                    if (i < 0) {
                                        c17485a.f4037Lp = i;
                                    } else {
                                        c17485a.f4037Lp = C8415j.INVALID_ID;
                                    }
                                }
                            }
                        } else {
                            c17485a.mPosition = this.alG;
                            if (this.alH == C8415j.INVALID_ID) {
                                if (m81098cJ(c17485a.mPosition) == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                c17485a.alO = z;
                                if (c17485a.alO) {
                                    i = c17485a.asj.arS.mo31906jf();
                                } else {
                                    i = c17485a.asj.arS.mo31905je();
                                }
                                c17485a.f4037Lp = i;
                            } else {
                                i = this.alH;
                                if (c17485a.alO) {
                                    c17485a.f4037Lp = c17485a.asj.arS.mo31906jf() - i;
                                } else {
                                    c17485a.f4037Lp = i + c17485a.asj.arS.mo31905je();
                                }
                            }
                            c17485a.ash = true;
                        }
                    } else {
                        c17485a.f4037Lp = C8415j.INVALID_ID;
                        c17485a.mPosition = this.alG;
                    }
                    obj = 1;
                }
                if (obj == null) {
                    if (this.arZ) {
                        itemCount = c31880s.getItemCount();
                        for (i2 = getChildCount() - 1; i2 >= 0; i2--) {
                            i = C17480i.m27148bt(getChildAt(i2));
                            if (i >= 0 && i < itemCount) {
                                break;
                            }
                        }
                        i = 0;
                    } else {
                        itemCount = c31880s.getItemCount();
                        childCount = getChildCount();
                        for (i2 = 0; i2 < childCount; i2++) {
                            i = C17480i.m27148bt(getChildAt(i2));
                            if (i >= 0 && i < itemCount) {
                                break;
                            }
                        }
                        i = 0;
                    }
                    c17485a.mPosition = i;
                    c17485a.f4037Lp = C8415j.INVALID_ID;
                }
                c17485a.alP = true;
            }
            if (this.asb == null && this.alG == -1 && !(c17485a.alO == this.arZ && m81100ib() == this.asa)) {
                this.arX.clear();
                c17485a.ash = true;
            }
            if (getChildCount() > 0 && (this.asb == null || this.asb.asr <= 0)) {
                if (c17485a.ash) {
                    for (i = 0; i < this.akU; i++) {
                        this.arR[i].clear();
                        if (c17485a.f4037Lp != C8415j.INVALID_ID) {
                            this.arR[i].mo51972cU(c17485a.f4037Lp);
                        }
                    }
                } else if (obj3 != null || this.asd.asi == null) {
                    for (i = 0; i < this.akU; i++) {
                        C31887b c31887b = this.arR[i];
                        boolean z2 = this.alD;
                        childCount = c17485a.f4037Lp;
                        if (z2) {
                            i2 = c31887b.mo51971cT(C8415j.INVALID_ID);
                        } else {
                            i2 = c31887b.mo51970cS(C8415j.INVALID_ID);
                        }
                        c31887b.clear();
                        if (i2 != C8415j.INVALID_ID && ((!z2 || i2 >= c31887b.asj.arS.mo31906jf()) && (z2 || i2 <= c31887b.asj.arS.mo31905je()))) {
                            if (childCount != C8415j.INVALID_ID) {
                                i2 += childCount;
                            }
                            c31887b.asx = i2;
                            c31887b.asw = i2;
                        }
                    }
                    C17485a c17485a2 = this.asd;
                    C31887b[] c31887bArr = this.arR;
                    itemCount = c31887bArr.length;
                    if (c17485a2.asi == null || c17485a2.asi.length < itemCount) {
                        c17485a2.asi = new int[c17485a2.asj.arR.length];
                    }
                    for (i = 0; i < itemCount; i++) {
                        c17485a2.asi[i] = c31887bArr[i].mo51970cS(C8415j.INVALID_ID);
                    }
                } else {
                    for (i = 0; i < this.akU; i++) {
                        C31887b c31887b2 = this.arR[i];
                        c31887b2.clear();
                        c31887b2.mo51972cU(this.asd.asi[i]);
                    }
                }
            }
            mo31845b(c25374o);
            this.arV.alf = false;
            this.ase = false;
            m81089cA(this.arT.mo31907jg());
            m81072a(c17485a.mPosition, c31880s);
            if (c17485a.alO) {
                m81090cB(-1);
                m81070a(c25374o, this.arV, c31880s);
                m81090cB(1);
                this.arV.alh = c17485a.mPosition + this.arV.ali;
                m81070a(c25374o, this.arV, c31880s);
            } else {
                m81090cB(1);
                m81070a(c25374o, this.arV, c31880s);
                m81090cB(-1);
                this.arV.alh = c17485a.mPosition + this.arV.ali;
                m81070a(c25374o, this.arV, c31880s);
            }
            if (this.arT.getMode() != ErrorDialogData.SUPPRESSED) {
                float f = 0.0f;
                childCount = getChildCount();
                itemCount = 0;
                while (itemCount < childCount) {
                    float f2;
                    View childAt = getChildAt(itemCount);
                    float bj = (float) this.arT.mo31897bj(childAt);
                    if (bj >= f) {
                        if (((LayoutParams) childAt.getLayoutParams()).asl) {
                            f2 = (1.0f * bj) / ((float) this.akU);
                        } else {
                            f2 = bj;
                        }
                        f2 = Math.max(f, f2);
                    } else {
                        f2 = f;
                    }
                    itemCount++;
                    f = f2;
                }
                itemCount = this.arU;
                i = Math.round(((float) this.akU) * f);
                if (this.arT.getMode() == C8415j.INVALID_ID) {
                    i = Math.min(i, this.arT.mo31907jg());
                }
                m81089cA(i);
                if (this.arU != itemCount) {
                    for (i2 = 0; i2 < childCount; i2++) {
                        View childAt2 = getChildAt(i2);
                        LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (!layoutParams.asl) {
                            if (m81100ib() && this.mOrientation == 1) {
                                childAt2.offsetLeftAndRight(((-((this.akU - 1) - layoutParams.ask.mIndex)) * this.arU) - ((-((this.akU - 1) - layoutParams.ask.mIndex)) * itemCount));
                            } else {
                                int i3 = layoutParams.ask.mIndex * this.arU;
                                i = layoutParams.ask.mIndex * itemCount;
                                if (this.mOrientation == 1) {
                                    childAt2.offsetLeftAndRight(i3 - i);
                                } else {
                                    childAt2.offsetTopAndBottom(i3 - i);
                                }
                            }
                        }
                    }
                }
            }
            if (getChildCount() > 0) {
                if (this.alD) {
                    m81074a(c25374o, c31880s, true);
                    m81085b(c25374o, c31880s, false);
                } else {
                    m81085b(c25374o, c31880s, true);
                    m81074a(c25374o, c31880s, false);
                }
            }
            obj = null;
            if (!(obj2 == null || c31880s.apv)) {
                obj2 = (this.arY == 0 || getChildCount() <= 0 || (!this.ase && m81104kT() == null)) ? null : 1;
                if (obj2 != null) {
                    removeCallbacks(this.asg);
                    if (m81103kS()) {
                        obj = 1;
                    }
                }
            }
            if (c31880s.apv) {
                this.asd.reset();
            }
            this.arZ = c17485a.alO;
            this.asa = m81100ib();
            if (obj != null) {
                this.asd.reset();
                obj = null;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo1753a(C31880s c31880s) {
        super.mo1753a(c31880s);
        this.alG = -1;
        this.alH = C8415j.INVALID_ID;
        this.asb = null;
        this.asd.reset();
    }

    /* renamed from: cA */
    private void m81089cA(int i) {
        this.arU = i / this.akU;
        this.asc = MeasureSpec.makeMeasureSpec(i, this.arT.getMode());
    }

    /* renamed from: iE */
    public final boolean mo1774iE() {
        return this.asb == null;
    }

    /* renamed from: d */
    public final int mo1766d(C31880s c31880s) {
        return m81101j(c31880s);
    }

    /* renamed from: j */
    private int m81101j(C31880s c31880s) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        C17487am c17487am = this.arS;
        View at = m81081at(!this.alF);
        if (this.alF) {
            z = false;
        }
        return C17494at.m27290a(c31880s, c17487am, at, m81082au(z), this, this.alF, this.alD);
    }

    /* renamed from: e */
    public final int mo1767e(C31880s c31880s) {
        return m81101j(c31880s);
    }

    /* renamed from: f */
    public final int mo1768f(C31880s c31880s) {
        return m81102k(c31880s);
    }

    /* renamed from: k */
    private int m81102k(C31880s c31880s) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        C17487am c17487am = this.arS;
        View at = m81081at(!this.alF);
        if (this.alF) {
            z = false;
        }
        return C17494at.m27289a(c31880s, c17487am, at, m81082au(z), this, this.alF);
    }

    /* renamed from: g */
    public final int mo1769g(C31880s c31880s) {
        return m81102k(c31880s);
    }

    /* renamed from: h */
    public final int mo1771h(C31880s c31880s) {
        return m81109l(c31880s);
    }

    /* renamed from: l */
    private int m81109l(C31880s c31880s) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        C17487am c17487am = this.arS;
        View at = m81081at(!this.alF);
        if (this.alF) {
            z = false;
        }
        return C17494at.m27291b(c31880s, c17487am, at, m81082au(z), this, this.alF);
    }

    /* renamed from: i */
    public final int mo1772i(C31880s c31880s) {
        return m81109l(c31880s);
    }

    /* renamed from: a */
    private void m81077a(View view, LayoutParams layoutParams) {
        if (layoutParams.asl) {
            if (this.mOrientation == 1) {
                m81110l(view, this.asc, C17480i.m27154c(this.mHeight, this.aoK, getPaddingTop() + getPaddingBottom(), layoutParams.height, true));
            } else {
                m81110l(view, C17480i.m27154c(this.mWidth, this.aoJ, getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.asc);
            }
        } else if (this.mOrientation == 1) {
            m81110l(view, C17480i.m27154c(this.arU, this.aoJ, 0, layoutParams.width, false), C17480i.m27154c(this.mHeight, this.aoK, getPaddingTop() + getPaddingBottom(), layoutParams.height, true));
        } else {
            m81110l(view, C17480i.m27154c(this.mWidth, this.aoJ, getPaddingLeft() + getPaddingRight(), layoutParams.width, true), C17480i.m27154c(this.arU, this.aoK, 0, layoutParams.height, false));
        }
    }

    /* renamed from: l */
    private void m81110l(View view, int i, int i2) {
        mo31859g(view, this.f17549oT);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int o = StaggeredGridLayoutManager.m81111o(i, layoutParams.leftMargin + this.f17549oT.left, layoutParams.rightMargin + this.f17549oT.right);
        int o2 = StaggeredGridLayoutManager.m81111o(i2, layoutParams.topMargin + this.f17549oT.top, layoutParams.bottomMargin + this.f17549oT.bottom);
        if (mo31847b(view, o, o2, layoutParams)) {
            view.measure(o, o2);
        }
    }

    /* renamed from: o */
    private static int m81111o(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == C8415j.INVALID_ID || mode == ErrorDialogData.SUPPRESSED) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.asb = (SavedState) parcelable;
            requestLayout();
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.asb != null) {
            return new SavedState(this.asb);
        }
        SavedState savedState = new SavedState();
        savedState.alC = this.alC;
        savedState.alZ = this.arZ;
        savedState.asa = this.asa;
        if (this.arX == null || this.arX.mData == null) {
            savedState.ast = 0;
        } else {
            savedState.asu = this.arX.mData;
            savedState.ast = savedState.asu.length;
            savedState.asm = this.arX.asm;
        }
        if (getChildCount() > 0) {
            int kW;
            View au;
            if (this.arZ) {
                kW = m81107kW();
            } else {
                kW = m81108kX();
            }
            savedState.alX = kW;
            if (this.alD) {
                au = m81082au(true);
            } else {
                au = m81081at(true);
            }
            if (au == null) {
                kW = -1;
            } else {
                kW = C17480i.m27148bt(au);
            }
            savedState.asq = kW;
            savedState.asr = this.akU;
            savedState.ass = new int[this.akU];
            for (kW = 0; kW < this.akU; kW++) {
                int cT;
                if (this.arZ) {
                    cT = this.arR[kW].mo51971cT(C8415j.INVALID_ID);
                    if (cT != C8415j.INVALID_ID) {
                        cT -= this.arS.mo31906jf();
                    }
                } else {
                    cT = this.arR[kW].mo51970cS(C8415j.INVALID_ID);
                    if (cT != C8415j.INVALID_ID) {
                        cT -= this.arS.mo31905je();
                    }
                }
                savedState.ass[kW] = cT;
            }
        } else {
            savedState.alX = -1;
            savedState.asq = -1;
            savedState.asr = 0;
        }
        return savedState;
    }

    /* renamed from: a */
    public final void mo31828a(C25374o c25374o, C31880s c31880s, View view, C0445b c0445b) {
        int i = 1;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            int kY;
            int i2;
            int i3;
            int i4;
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.mOrientation == 0) {
                kY = layoutParams2.mo51966kY();
                if (layoutParams2.asl) {
                    i = this.akU;
                }
                i2 = -1;
                i3 = -1;
                i4 = i;
            } else {
                i3 = layoutParams2.mo51966kY();
                if (layoutParams2.asl) {
                    i2 = this.akU;
                    i4 = -1;
                    kY = -1;
                } else {
                    i2 = 1;
                    i4 = -1;
                    kY = -1;
                }
            }
            c0445b.mo985H(C0444c.m769b(kY, i4, i3, i2, layoutParams2.asl));
            return;
        }
        super.mo31832a(view, c0445b);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View at = m81081at(false);
            View au = m81082au(false);
            if (at != null && au != null) {
                int bt = C17480i.m27148bt(at);
                int bt2 = C17480i.m27148bt(au);
                if (bt < bt2) {
                    accessibilityEvent.setFromIndex(bt);
                    accessibilityEvent.setToIndex(bt2);
                    return;
                }
                accessibilityEvent.setFromIndex(bt2);
                accessibilityEvent.setToIndex(bt);
            }
        }
    }

    /* renamed from: a */
    public final int mo31824a(C25374o c25374o, C31880s c31880s) {
        if (this.mOrientation == 0) {
            return this.akU;
        }
        return super.mo31824a(c25374o, c31880s);
    }

    /* renamed from: b */
    public final int mo31844b(C25374o c25374o, C31880s c31880s) {
        if (this.mOrientation == 1) {
            return this.akU;
        }
        return super.mo31844b(c25374o, c31880s);
    }

    /* renamed from: at */
    private View m81081at(boolean z) {
        int je = this.arS.mo31905je();
        int jf = this.arS.mo31906jf();
        int childCount = getChildCount();
        View view = null;
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            int bf = this.arS.mo31893bf(childAt);
            if (this.arS.mo31894bg(childAt) > je && bf < jf) {
                if (bf >= je || !z) {
                    return childAt;
                }
                if (view == null) {
                    i++;
                    view = childAt;
                }
            }
            childAt = view;
            i++;
            view = childAt;
        }
        return view;
    }

    /* renamed from: au */
    private View m81082au(boolean z) {
        int je = this.arS.mo31905je();
        int jf = this.arS.mo31906jf();
        View view = null;
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            int bf = this.arS.mo31893bf(childAt);
            int bg = this.arS.mo31894bg(childAt);
            if (bg > je && bf < jf) {
                if (bg <= jf || !z) {
                    return childAt;
                }
                if (view == null) {
                    childCount--;
                    view = childAt;
                }
            }
            childAt = view;
            childCount--;
            view = childAt;
        }
        return view;
    }

    /* renamed from: a */
    private void m81074a(C25374o c25374o, C31880s c31880s, boolean z) {
        int cG = m81095cG(C8415j.INVALID_ID);
        if (cG != C8415j.INVALID_ID) {
            cG = this.arS.mo31906jf() - cG;
            if (cG > 0) {
                cG -= -m81088c(-cG, c25374o, c31880s);
                if (z && cG > 0) {
                    this.arS.mo31899cc(cG);
                }
            }
        }
    }

    /* renamed from: b */
    private void m81085b(C25374o c25374o, C31880s c31880s, boolean z) {
        int cF = m81094cF(BaseClientBuilder.API_PRIORITY_OTHER);
        if (cF != BaseClientBuilder.API_PRIORITY_OTHER) {
            cF -= this.arS.mo31905je();
            if (cF > 0) {
                cF -= m81088c(cF, c25374o, c31880s);
                if (z && cF > 0) {
                    this.arS.mo31899cc(-cF);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m81072a(int i, C31880s c31880s) {
        int i2;
        int i3;
        C44968ag c44968ag;
        boolean z = false;
        this.arV.alg = 0;
        this.arV.alh = i;
        if (mo31874jV()) {
            i2 = c31880s.ape;
            if (i2 != -1) {
                if (this.alD == (i2 < i)) {
                    i2 = this.arS.mo31907jg();
                    i3 = 0;
                } else {
                    i3 = this.arS.mo31907jg();
                    i2 = 0;
                }
                if (getClipToPadding()) {
                    this.arV.alk = i2 + this.arS.getEnd();
                    this.arV.alj = -i3;
                } else {
                    this.arV.alj = this.arS.mo31905je() - i3;
                    this.arV.alk = i2 + this.arS.mo31906jf();
                }
                this.arV.all = false;
                this.arV.alf = true;
                c44968ag = this.arV;
                if (this.arS.getMode() == 0 && this.arS.getEnd() == 0) {
                    z = true;
                }
                c44968ag.alm = z;
            }
        }
        i2 = 0;
        i3 = 0;
        if (getClipToPadding()) {
        }
        this.arV.all = false;
        this.arV.alf = true;
        c44968ag = this.arV;
        z = true;
        c44968ag.alm = z;
    }

    /* renamed from: cB */
    private void m81090cB(int i) {
        int i2 = 1;
        this.arV.f17708sE = i;
        C44968ag c44968ag = this.arV;
        if (this.alD != (i == -1)) {
            i2 = -1;
        }
        c44968ag.ali = i2;
    }

    /* renamed from: ck */
    public final void mo31851ck(int i) {
        super.mo31851ck(i);
        for (int i2 = 0; i2 < this.akU; i2++) {
            this.arR[i2].mo51973cV(i);
        }
    }

    /* renamed from: cl */
    public final void mo31852cl(int i) {
        super.mo31852cl(i);
        for (int i2 = 0; i2 < this.akU; i2++) {
            this.arR[i2].mo51973cV(i);
        }
    }

    /* renamed from: d */
    public final void mo15125d(RecyclerView recyclerView, int i, int i2) {
        m81112p(i, i2, 2);
    }

    /* renamed from: c */
    public final void mo15123c(RecyclerView recyclerView, int i, int i2) {
        m81112p(i, i2, 1);
    }

    /* renamed from: a */
    public final void mo15122a(RecyclerView recyclerView) {
        this.arX.clear();
        requestLayout();
    }

    /* renamed from: a */
    public final void mo31830a(RecyclerView recyclerView, int i, int i2, int i3) {
        m81112p(i, i2, 8);
    }

    /* renamed from: a */
    public final void mo31831a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m81112p(i, i2, 4);
    }

    /* renamed from: p */
    private void m81112p(int i, int i2, int i3) {
        int i4;
        int i5;
        int kW = this.alD ? m81107kW() : m81108kX();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.arX.mo1818cL(i5);
        switch (i3) {
            case 1:
                this.arX.mo1816aN(i, i2);
                break;
            case 2:
                this.arX.mo1815aL(i, i2);
                break;
            case 8:
                this.arX.mo1815aL(i, 1);
                this.arX.mo1816aN(i2, 1);
                break;
        }
        if (i4 > kW) {
            if (i5 <= (this.alD ? m81108kX() : m81107kW())) {
                requestLayout();
            }
        }
    }

    /* renamed from: a */
    private int m81070a(C25374o c25374o, C44968ag c44968ag, C31880s c31880s) {
        int i;
        int jf;
        int je;
        this.arW.set(0, this.akU, true);
        if (this.arV.alm) {
            i = c44968ag.f17708sE == 1 ? BaseClientBuilder.API_PRIORITY_OTHER : C8415j.INVALID_ID;
        } else if (c44968ag.f17708sE == 1) {
            i = c44968ag.alk + c44968ag.alg;
        } else {
            i = c44968ag.alj - c44968ag.alg;
        }
        m81080aK(c44968ag.f17708sE, i);
        if (this.alD) {
            jf = this.arS.mo31906jf();
        } else {
            jf = this.arS.mo31905je();
        }
        Object obj = null;
        while (c44968ag.mo72237b(c31880s) && (this.arV.alm || !this.arW.isEmpty())) {
            C31887b a;
            int bj;
            int i2;
            int bj2;
            View a2 = c44968ag.mo72236a(c25374o);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int ki = layoutParams.aoM.mo66453ki();
            int cM = this.arX.mo1819cM(ki);
            Object obj2 = cM == -1 ? 1 : null;
            if (obj2 != null) {
                a = layoutParams.asl ? this.arR[0] : m81071a(c44968ag);
                this.arX.mo1813a(ki, a);
            } else {
                a = this.arR[cM];
            }
            layoutParams.ask = a;
            if (c44968ag.f17708sE == 1) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
            m81077a(a2, layoutParams);
            if (c44968ag.f17708sE == 1) {
                if (layoutParams.asl) {
                    cM = m81095cG(jf);
                } else {
                    cM = a.mo51971cT(jf);
                }
                bj = this.arS.mo31897bj(a2) + cM;
                if (obj2 == null || !layoutParams.asl) {
                    i2 = cM;
                } else {
                    FullSpanItem cC = m81091cC(cM);
                    cC.asn = -1;
                    cC.mPosition = ki;
                    this.arX.mo1814a(cC);
                    i2 = cM;
                }
            } else {
                if (layoutParams.asl) {
                    cM = m81094cF(jf);
                } else {
                    cM = a.mo51970cS(jf);
                }
                i2 = cM - this.arS.mo31897bj(a2);
                if (obj2 != null && layoutParams.asl) {
                    FullSpanItem cD = m81092cD(cM);
                    cD.asn = 1;
                    cD.mPosition = ki;
                    this.arX.mo1814a(cD);
                }
                bj = cM;
            }
            if (layoutParams.asl && c44968ag.ali == -1) {
                if (obj2 == null) {
                    Object obj3 = c44968ag.f17708sE == 1 ? !m81105kU() ? 1 : null : !m81106kV() ? 1 : null;
                    if (obj3 != null) {
                        FullSpanItem cQ = this.arX.mo1820cQ(ki);
                        if (cQ != null) {
                            cQ.asp = true;
                        }
                    }
                }
                this.ase = true;
            }
            m81078a(a2, layoutParams, c44968ag);
            if (m81100ib() && this.mOrientation == 1) {
                if (layoutParams.asl) {
                    cM = this.arT.mo31906jf();
                } else {
                    cM = this.arT.mo31906jf() - (((this.akU - 1) - a.mIndex) * this.arU);
                }
                bj2 = cM - this.arT.mo31897bj(a2);
                ki = cM;
            } else {
                if (layoutParams.asl) {
                    cM = this.arT.mo31905je();
                } else {
                    cM = (a.mIndex * this.arU) + this.arT.mo31905je();
                }
                ki = cM + this.arT.mo31897bj(a2);
                bj2 = cM;
            }
            if (this.mOrientation == 1) {
                C17480i.m27161k(a2, bj2, i2, ki, bj);
            } else {
                C17480i.m27161k(a2, i2, bj2, bj, ki);
            }
            if (layoutParams.asl) {
                m81080aK(this.arV.f17708sE, i);
            } else {
                m81076a(a, this.arV.f17708sE, i);
            }
            m81075a(c25374o, this.arV);
            if (this.arV.all && a2.hasFocusable()) {
                if (layoutParams.asl) {
                    this.arW.clear();
                } else {
                    this.arW.set(a.mIndex, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m81075a(c25374o, this.arV);
        }
        if (this.arV.f17708sE == -1) {
            je = this.arS.mo31905je() - m81094cF(this.arS.mo31905je());
        } else {
            je = m81095cG(this.arS.mo31906jf()) - this.arS.mo31906jf();
        }
        return je > 0 ? Math.min(c44968ag.alg, je) : 0;
    }

    /* renamed from: cC */
    private FullSpanItem m81091cC(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.aso = new int[this.akU];
        for (int i2 = 0; i2 < this.akU; i2++) {
            fullSpanItem.aso[i2] = i - this.arR[i2].mo51971cT(i);
        }
        return fullSpanItem;
    }

    /* renamed from: cD */
    private FullSpanItem m81092cD(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.aso = new int[this.akU];
        for (int i2 = 0; i2 < this.akU; i2++) {
            fullSpanItem.aso[i2] = this.arR[i2].mo51970cS(i) - i;
        }
        return fullSpanItem;
    }

    /* renamed from: a */
    private void m81078a(View view, LayoutParams layoutParams, C44968ag c44968ag) {
        if (c44968ag.f17708sE == 1) {
            if (layoutParams.asl) {
                m81086bM(view);
            } else {
                layoutParams.ask.mo51969bP(view);
            }
        } else if (layoutParams.asl) {
            m81087bN(view);
        } else {
            layoutParams.ask.mo51968bO(view);
        }
    }

    /* renamed from: a */
    private void m81075a(C25374o c25374o, C44968ag c44968ag) {
        if (c44968ag.alf && !c44968ag.alm) {
            int cE;
            if (c44968ag.alg == 0) {
                if (c44968ag.f17708sE == -1) {
                    m81084b(c25374o, c44968ag.alk);
                } else {
                    m81073a(c25374o, c44968ag.alj);
                }
            } else if (c44968ag.f17708sE == -1) {
                cE = c44968ag.alj - m81093cE(c44968ag.alj);
                if (cE < 0) {
                    cE = c44968ag.alk;
                } else {
                    cE = c44968ag.alk - Math.min(cE, c44968ag.alg);
                }
                m81084b(c25374o, cE);
            } else {
                cE = m81096cH(c44968ag.alk) - c44968ag.alk;
                if (cE < 0) {
                    cE = c44968ag.alj;
                } else {
                    cE = Math.min(cE, c44968ag.alg) + c44968ag.alj;
                }
                m81073a(c25374o, cE);
            }
        }
    }

    /* renamed from: bM */
    private void m81086bM(View view) {
        for (int i = this.akU - 1; i >= 0; i--) {
            this.arR[i].mo51969bP(view);
        }
    }

    /* renamed from: bN */
    private void m81087bN(View view) {
        for (int i = this.akU - 1; i >= 0; i--) {
            this.arR[i].mo51968bO(view);
        }
    }

    /* renamed from: aK */
    private void m81080aK(int i, int i2) {
        for (int i3 = 0; i3 < this.akU; i3++) {
            if (!this.arR[i3].asv.isEmpty()) {
                m81076a(this.arR[i3], i, i2);
            }
        }
    }

    /* renamed from: a */
    private void m81076a(C31887b c31887b, int i, int i2) {
        int i3 = c31887b.asy;
        if (i == -1) {
            if (i3 + c31887b.mo51975la() <= i2) {
                this.arW.set(c31887b.mIndex, false);
            }
        } else if (c31887b.mo51976lc() - i3 >= i2) {
            this.arW.set(c31887b.mIndex, false);
        }
    }

    /* renamed from: cE */
    private int m81093cE(int i) {
        int cS = this.arR[0].mo51970cS(i);
        for (int i2 = 1; i2 < this.akU; i2++) {
            int cS2 = this.arR[i2].mo51970cS(i);
            if (cS2 > cS) {
                cS = cS2;
            }
        }
        return cS;
    }

    /* renamed from: cF */
    private int m81094cF(int i) {
        int cS = this.arR[0].mo51970cS(i);
        for (int i2 = 1; i2 < this.akU; i2++) {
            int cS2 = this.arR[i2].mo51970cS(i);
            if (cS2 < cS) {
                cS = cS2;
            }
        }
        return cS;
    }

    /* renamed from: kU */
    private boolean m81105kU() {
        int cT = this.arR[0].mo51971cT(C8415j.INVALID_ID);
        for (int i = 1; i < this.akU; i++) {
            if (this.arR[i].mo51971cT(C8415j.INVALID_ID) != cT) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: kV */
    private boolean m81106kV() {
        int cS = this.arR[0].mo51970cS(C8415j.INVALID_ID);
        for (int i = 1; i < this.akU; i++) {
            if (this.arR[i].mo51970cS(C8415j.INVALID_ID) != cS) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: cG */
    private int m81095cG(int i) {
        int cT = this.arR[0].mo51971cT(i);
        for (int i2 = 1; i2 < this.akU; i2++) {
            int cT2 = this.arR[i2].mo51971cT(i);
            if (cT2 > cT) {
                cT = cT2;
            }
        }
        return cT;
    }

    /* renamed from: cH */
    private int m81096cH(int i) {
        int cT = this.arR[0].mo51971cT(i);
        for (int i2 = 1; i2 < this.akU; i2++) {
            int cT2 = this.arR[i2].mo51971cT(i);
            if (cT2 < cT) {
                cT = cT2;
            }
        }
        return cT;
    }

    /* renamed from: a */
    private void m81073a(C25374o c25374o, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.arS.mo31894bg(childAt) <= i && this.arS.mo31895bh(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.asl) {
                    int i2 = 0;
                    while (i2 < this.akU) {
                        if (this.arR[i2].asv.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.akU; i2++) {
                        this.arR[i2].mo51978lf();
                    }
                } else if (layoutParams.ask.asv.size() != 1) {
                    layoutParams.ask.mo51978lf();
                } else {
                    return;
                }
                mo31833a(childAt, c25374o);
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m81084b(C25374o c25374o, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.arS.mo31893bf(childAt) >= i && this.arS.mo31896bi(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.asl) {
                    int i2 = 0;
                    while (i2 < this.akU) {
                        if (this.arR[i2].asv.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.akU; i2++) {
                        this.arR[i2].mo51977le();
                    }
                } else if (layoutParams.ask.asv.size() != 1) {
                    layoutParams.ask.mo51977le();
                } else {
                    return;
                }
                mo31833a(childAt, c25374o);
                childCount--;
            } else {
                return;
            }
        }
    }

    /* renamed from: cI */
    private boolean m81097cI(int i) {
        if (this.mOrientation == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.alD) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.alD) != m81100ib()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private C31887b m81071a(C44968ag c44968ag) {
        int i;
        int i2;
        int i3;
        C31887b c31887b = null;
        if (m81097cI(c44968ag.f17708sE)) {
            i = this.akU - 1;
            i2 = -1;
            i3 = -1;
        } else {
            i = 0;
            i2 = 1;
            i3 = this.akU;
        }
        int i4;
        int je;
        int i5;
        C31887b c31887b2;
        int cT;
        if (c44968ag.f17708sE == 1) {
            i4 = BaseClientBuilder.API_PRIORITY_OTHER;
            je = this.arS.mo31905je();
            i5 = i;
            while (i5 != i3) {
                c31887b2 = this.arR[i5];
                cT = c31887b2.mo51971cT(je);
                if (cT >= i4) {
                    cT = i4;
                    c31887b2 = c31887b;
                }
                i5 += i2;
                i4 = cT;
                c31887b = c31887b2;
            }
        } else {
            i4 = C8415j.INVALID_ID;
            je = this.arS.mo31906jf();
            i5 = i;
            while (i5 != i3) {
                c31887b2 = this.arR[i5];
                cT = c31887b2.mo51970cS(je);
                if (cT <= i4) {
                    cT = i4;
                    c31887b2 = c31887b;
                }
                i5 += i2;
                i4 = cT;
                c31887b = c31887b2;
            }
        }
        return c31887b;
    }

    /* renamed from: iH */
    public final boolean mo1777iH() {
        return this.mOrientation == 1;
    }

    /* renamed from: iG */
    public final boolean mo1776iG() {
        return this.mOrientation == 0;
    }

    /* renamed from: a */
    public final int mo1746a(int i, C25374o c25374o, C31880s c31880s) {
        return m81088c(i, c25374o, c31880s);
    }

    /* renamed from: b */
    public final int mo1759b(int i, C25374o c25374o, C31880s c31880s) {
        return m81088c(i, c25374o, c31880s);
    }

    /* renamed from: cJ */
    private int m81098cJ(int i) {
        if (getChildCount() != 0) {
            if ((i < m81108kX()) != this.alD) {
                return -1;
            }
            return 1;
        } else if (this.alD) {
            return 1;
        } else {
            return -1;
        }
    }

    /* renamed from: bX */
    public final PointF mo1761bX(int i) {
        int cJ = m81098cJ(i);
        PointF pointF = new PointF();
        if (cJ == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) cJ;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = (float) cJ;
        return pointF;
    }

    /* renamed from: a */
    public final void mo1755a(RecyclerView recyclerView, int i) {
        C41189ah c41189ah = new C41189ah(recyclerView.getContext());
        c41189ah.ape = i;
        mo31829a((C37139r) c41189ah);
    }

    /* renamed from: bY */
    public final void mo1762bY(int i) {
        if (!(this.asb == null || this.asb.alX == i)) {
            SavedState savedState = this.asb;
            savedState.ass = null;
            savedState.asr = 0;
            savedState.alX = -1;
            savedState.asq = -1;
        }
        this.alG = i;
        this.alH = C8415j.INVALID_ID;
        requestLayout();
    }

    /* renamed from: a */
    public final void mo1749a(int i, int i2, C31880s c31880s, C17481a c17481a) {
        int i3 = 0;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            m81083b(i, c31880s);
            if (this.asf == null || this.asf.length < this.akU) {
                this.asf = new int[this.akU];
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.akU; i5++) {
                int cS;
                if (this.arV.ali == -1) {
                    cS = this.arV.alj - this.arR[i5].mo51970cS(this.arV.alj);
                } else {
                    cS = this.arR[i5].mo51971cT(this.arV.alk) - this.arV.alk;
                }
                if (cS >= 0) {
                    this.asf[i4] = cS;
                    i4++;
                }
            }
            Arrays.sort(this.asf, 0, i4);
            while (i3 < i4 && this.arV.mo72237b(c31880s)) {
                c17481a.mo18521T(this.arV.alh, this.asf[i3]);
                C44968ag c44968ag = this.arV;
                c44968ag.alh += this.arV.ali;
                i3++;
            }
        }
    }

    /* renamed from: b */
    private void m81083b(int i, C31880s c31880s) {
        int kW;
        int i2;
        if (i > 0) {
            kW = m81107kW();
            i2 = 1;
        } else {
            i2 = -1;
            kW = m81108kX();
        }
        this.arV.alf = true;
        m81072a(kW, c31880s);
        m81090cB(i2);
        C44968ag c44968ag = this.arV;
        c44968ag.alh = kW + c44968ag.ali;
        this.arV.alg = Math.abs(i);
    }

    /* renamed from: c */
    private int m81088c(int i, C25374o c25374o, C31880s c31880s) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        m81083b(i, c31880s);
        int a = m81070a(c25374o, this.arV, c31880s);
        if (this.arV.alg >= a) {
            if (i < 0) {
                i = -a;
            } else {
                i = a;
            }
        }
        this.arS.mo31899cc(-i);
        this.arZ = this.alD;
        this.arV.alg = 0;
        m81075a(c25374o, this.arV);
        return i;
    }

    /* renamed from: kW */
    private int m81107kW() {
        int childCount = getChildCount();
        return childCount == 0 ? 0 : C17480i.m27148bt(getChildAt(childCount - 1));
    }

    /* renamed from: kX */
    private int m81108kX() {
        if (getChildCount() == 0) {
            return 0;
        }
        return C17480i.m27148bt(getChildAt(0));
    }

    /* renamed from: iA */
    public final RecyclerView.LayoutParams mo1773iA() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    /* renamed from: a */
    public final RecyclerView.LayoutParams mo31825a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    /* renamed from: d */
    public final RecyclerView.LayoutParams mo31853d(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* renamed from: a */
    public final boolean mo31834a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: a */
    public final View mo1748a(View view, int i, C25374o c25374o, C31880s c31880s) {
        if (getChildCount() == 0) {
            return null;
        }
        View bl = mo31848bl(view);
        if (bl == null) {
            return null;
        }
        int i2;
        m81099iI();
        switch (i) {
            case 1:
                if (this.mOrientation != 1) {
                    if (!m81100ib()) {
                        i2 = -1;
                        break;
                    }
                    i2 = 1;
                    break;
                }
                i2 = -1;
                break;
            case 2:
                if (this.mOrientation != 1) {
                    if (!m81100ib()) {
                        i2 = 1;
                        break;
                    }
                    i2 = -1;
                    break;
                }
                i2 = 1;
                break;
            case 17:
                if (this.mOrientation != 0) {
                    i2 = C8415j.INVALID_ID;
                    break;
                }
                i2 = -1;
                break;
            case 33:
                if (this.mOrientation != 1) {
                    i2 = C8415j.INVALID_ID;
                    break;
                }
                i2 = -1;
                break;
            case 66:
                if (this.mOrientation != 0) {
                    i2 = C8415j.INVALID_ID;
                    break;
                }
                i2 = 1;
                break;
            case 130:
                if (this.mOrientation != 1) {
                    i2 = C8415j.INVALID_ID;
                    break;
                }
                i2 = 1;
                break;
            default:
                i2 = C8415j.INVALID_ID;
                break;
        }
        if (i2 == C8415j.INVALID_ID) {
            return null;
        }
        int kW;
        View aQ;
        int i3;
        View bW;
        LayoutParams layoutParams = (LayoutParams) bl.getLayoutParams();
        boolean z = layoutParams.asl;
        C31887b c31887b = layoutParams.ask;
        if (i2 == 1) {
            kW = m81107kW();
        } else {
            kW = m81108kX();
        }
        m81072a(kW, c31880s);
        m81090cB(i2);
        C44968ag c44968ag = this.arV;
        c44968ag.alh = c44968ag.ali + kW;
        this.arV.alg = (int) (0.33333334f * ((float) this.arS.mo31907jg()));
        this.arV.all = true;
        this.arV.alf = false;
        m81070a(c25374o, this.arV, c31880s);
        this.arZ = this.alD;
        if (!z) {
            aQ = c31887b.mo51967aQ(kW, i2);
            if (!(aQ == null || aQ == bl)) {
                return aQ;
            }
        }
        if (m81097cI(i2)) {
            for (int i4 = this.akU - 1; i4 >= 0; i4--) {
                aQ = this.arR[i4].mo51967aQ(kW, i2);
                if (aQ != null && aQ != bl) {
                    return aQ;
                }
            }
        } else {
            for (i3 = 0; i3 < this.akU; i3++) {
                View aQ2 = this.arR[i3].mo51967aQ(kW, i2);
                if (aQ2 != null && aQ2 != bl) {
                    return aQ2;
                }
            }
        }
        Object obj = (!this.alC ? 1 : null) == (i2 == -1 ? 1 : null) ? 1 : null;
        if (!z) {
            if (obj != null) {
                kW = c31887b.mo51979lg();
            } else {
                kW = c31887b.mo51980lh();
            }
            bW = mo1760bW(kW);
            if (!(bW == null || bW == bl)) {
                return bW;
            }
        }
        if (m81097cI(i2)) {
            for (i3 = this.akU - 1; i3 >= 0; i3--) {
                if (i3 != c31887b.mIndex) {
                    if (obj != null) {
                        kW = this.arR[i3].mo51979lg();
                    } else {
                        kW = this.arR[i3].mo51980lh();
                    }
                    bW = mo1760bW(kW);
                    if (!(bW == null || bW == bl)) {
                        return bW;
                    }
                }
            }
        } else {
            for (kW = 0; kW < this.akU; kW++) {
                if (obj != null) {
                    i3 = this.arR[kW].mo51979lg();
                } else {
                    i3 = this.arR[kW].mo51980lh();
                }
                aQ = mo1760bW(i3);
                if (aQ != null && aQ != bl) {
                    return aQ;
                }
            }
        }
        return null;
    }
}
