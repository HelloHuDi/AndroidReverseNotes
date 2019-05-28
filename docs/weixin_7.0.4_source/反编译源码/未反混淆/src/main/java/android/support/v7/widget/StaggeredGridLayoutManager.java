package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.b.c;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.r;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public final class StaggeredGridLayoutManager extends i implements android.support.v7.widget.RecyclerView.r.b {
    private int akU;
    boolean alC;
    boolean alD;
    private boolean alF;
    int alG;
    int alH;
    b[] arR;
    am arS;
    am arT;
    private int arU;
    private final ag arV;
    private BitSet arW;
    LazySpanLookup arX;
    private int arY;
    private boolean arZ;
    private boolean asa;
    private SavedState asb;
    private int asc;
    private final a asd;
    private boolean ase;
    private int[] asf;
    private final Runnable asg;
    private int mOrientation;
    private final Rect oT;

    static class LazySpanLookup {
        List<FullSpanItem> asm;
        int[] mData;

        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new Creator<FullSpanItem>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new FullSpanItem[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }
            };
            int asn;
            int[] aso;
            boolean asp;
            int mPosition;

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
            public final int cR(int i) {
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
        public final int cK(int i) {
            if (this.asm != null) {
                for (int size = this.asm.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.asm.get(size)).mPosition >= i) {
                        this.asm.remove(size);
                    }
                }
            }
            return cL(i);
        }

        /* Access modifiers changed, original: final */
        public final int cL(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            int cP = cP(i);
            if (cP == -1) {
                int[] iArr = this.mData;
                Arrays.fill(iArr, i, iArr.length, -1);
                return this.mData.length;
            }
            Arrays.fill(this.mData, i, cP + 1, -1);
            return cP + 1;
        }

        /* Access modifiers changed, original: final */
        public final int cM(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            return this.mData[i];
        }

        /* Access modifiers changed, original: final */
        public final void a(int i, b bVar) {
            cO(i);
            this.mData[i] = bVar.mIndex;
        }

        private int cN(int i) {
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        private void cO(int i) {
            if (this.mData == null) {
                this.mData = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.mData, -1);
            } else if (i >= this.mData.length) {
                int[] iArr = this.mData;
                this.mData = new int[cN(i)];
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
        public final void aL(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                cO(i + i2);
                int[] iArr = this.mData;
                int i3 = i + i2;
                int[] iArr2 = this.mData;
                System.arraycopy(iArr, i3, iArr2, i, (iArr2.length - i) - i2);
                Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
                aM(i, i2);
            }
        }

        private void aM(int i, int i2) {
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
        public final void aN(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                cO(i + i2);
                int[] iArr = this.mData;
                System.arraycopy(iArr, i, iArr, i + i2, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, i, i + i2, -1);
                aO(i, i2);
            }
        }

        private void aO(int i, int i2) {
            if (this.asm != null) {
                for (int size = this.asm.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.asm.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }

        private int cP(int i) {
            if (this.asm == null) {
                return -1;
            }
            FullSpanItem cQ = cQ(i);
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

        public final void a(FullSpanItem fullSpanItem) {
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

        public final FullSpanItem cQ(int i) {
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

        public final FullSpanItem q(int i, int i2, int i3) {
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

    class a {
        int Lp;
        boolean alO;
        boolean alP;
        boolean ash;
        int[] asi;
        final /* synthetic */ StaggeredGridLayoutManager asj;
        int mPosition;

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.mPosition = -1;
            this.Lp = j.INVALID_ID;
            this.alO = false;
            this.ash = false;
            this.alP = false;
            if (this.asi != null) {
                Arrays.fill(this.asi, -1);
            }
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

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        b ask;
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

        public final int kY() {
            if (this.ask == null) {
                return -1;
            }
            return this.ask.mIndex;
        }
    }

    class b {
        final /* synthetic */ StaggeredGridLayoutManager asj;
        ArrayList<View> asv;
        int asw;
        int asx;
        int asy;
        final int mIndex;

        /* Access modifiers changed, original: final */
        public final int cS(int i) {
            if (this.asw != j.INVALID_ID) {
                return this.asw;
            }
            if (this.asv.size() == 0) {
                return i;
            }
            kZ();
            return this.asw;
        }

        private void kZ() {
            View view = (View) this.asv.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.asw = this.asj.arS.bf(view);
            if (layoutParams.asl) {
                FullSpanItem cQ = this.asj.arX.cQ(layoutParams.aoM.ki());
                if (cQ != null && cQ.asn == -1) {
                    this.asw -= cQ.cR(this.mIndex);
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final int la() {
            if (this.asw != j.INVALID_ID) {
                return this.asw;
            }
            kZ();
            return this.asw;
        }

        /* Access modifiers changed, original: final */
        public final int cT(int i) {
            if (this.asx != j.INVALID_ID) {
                return this.asx;
            }
            if (this.asv.size() == 0) {
                return i;
            }
            lb();
            return this.asx;
        }

        private void lb() {
            View view = (View) this.asv.get(this.asv.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.asx = this.asj.arS.bg(view);
            if (layoutParams.asl) {
                FullSpanItem cQ = this.asj.arX.cQ(layoutParams.aoM.ki());
                if (cQ != null && cQ.asn == 1) {
                    this.asx = cQ.cR(this.mIndex) + this.asx;
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final int lc() {
            if (this.asx != j.INVALID_ID) {
                return this.asx;
            }
            lb();
            return this.asx;
        }

        /* Access modifiers changed, original: final */
        public final void bO(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.ask = this;
            this.asv.add(0, view);
            this.asw = j.INVALID_ID;
            if (this.asv.size() == 1) {
                this.asx = j.INVALID_ID;
            }
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.kx()) {
                this.asy += this.asj.arS.bj(view);
            }
        }

        /* Access modifiers changed, original: final */
        public final void bP(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.ask = this;
            this.asv.add(view);
            this.asx = j.INVALID_ID;
            if (this.asv.size() == 1) {
                this.asw = j.INVALID_ID;
            }
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.kx()) {
                this.asy += this.asj.arS.bj(view);
            }
        }

        /* Access modifiers changed, original: final */
        public final void clear() {
            this.asv.clear();
            ld();
            this.asy = 0;
        }

        private void ld() {
            this.asw = j.INVALID_ID;
            this.asx = j.INVALID_ID;
        }

        /* Access modifiers changed, original: final */
        public final void cU(int i) {
            this.asw = i;
            this.asx = i;
        }

        /* Access modifiers changed, original: final */
        public final void le() {
            int size = this.asv.size();
            View view = (View) this.asv.remove(size - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.ask = null;
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.kx()) {
                this.asy -= this.asj.arS.bj(view);
            }
            if (size == 1) {
                this.asw = j.INVALID_ID;
            }
            this.asx = j.INVALID_ID;
        }

        /* Access modifiers changed, original: final */
        public final void lf() {
            View view = (View) this.asv.remove(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.ask = null;
            if (this.asv.size() == 0) {
                this.asx = j.INVALID_ID;
            }
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.kx()) {
                this.asy -= this.asj.arS.bj(view);
            }
            this.asw = j.INVALID_ID;
        }

        /* Access modifiers changed, original: final */
        public final void cV(int i) {
            if (this.asw != j.INVALID_ID) {
                this.asw += i;
            }
            if (this.asx != j.INVALID_ID) {
                this.asx += i;
            }
        }

        public final int lg() {
            if (this.asj.alC) {
                return aP(this.asv.size() - 1, -1);
            }
            return aP(0, this.asv.size());
        }

        public final int lh() {
            if (this.asj.alC) {
                return aP(0, this.asv.size());
            }
            return aP(this.asv.size() - 1, -1);
        }

        private int aP(int i, int i2) {
            int je = this.asj.arS.je();
            int jf = this.asj.arS.jf();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                Object obj;
                View view = (View) this.asv.get(i);
                int bf = this.asj.arS.bf(view);
                int bg = this.asj.arS.bg(view);
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
                    return i.bt(view);
                }
                i += i3;
            }
            return -1;
        }

        public final View aQ(int i, int i2) {
            View view = null;
            int i3;
            View view2;
            if (i2 == -1) {
                int size = this.asv.size();
                i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.asv.get(i3);
                    if ((this.asj.alC && i.bt(view2) <= i) || ((!this.asj.alC && i.bt(view2) >= i) || !view2.hasFocusable())) {
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
                if ((this.asj.alC && i.bt(view2) >= i) || ((!this.asj.alC && i.bt(view2) <= i) || !view2.hasFocusable())) {
                    break;
                }
                i3--;
                view = view2;
            }
            return view;
        }
    }

    public final boolean iF() {
        return this.arY != 0;
    }

    private boolean kS() {
        if (getChildCount() == 0 || this.arY == 0 || !this.pv) {
            return false;
        }
        int kW;
        int kX;
        if (this.alD) {
            kW = kW();
            kX = kX();
        } else {
            kW = kX();
            kX = kW();
        }
        if (kW == 0 && kT() != null) {
            this.arX.clear();
            this.aoD = true;
            requestLayout();
            return true;
        } else if (!this.ase) {
            return false;
        } else {
            int i = this.alD ? -1 : 1;
            FullSpanItem q = this.arX.q(kW, kX + 1, i);
            if (q == null) {
                this.ase = false;
                this.arX.cK(kX + 1);
                return false;
            }
            FullSpanItem q2 = this.arX.q(kW, q.mPosition, i * -1);
            if (q2 == null) {
                this.arX.cK(q.mPosition);
            } else {
                this.arX.cK(q2.mPosition + 1);
            }
            this.aoD = true;
            requestLayout();
            return true;
        }
    }

    public final void cm(int i) {
        if (i == 0) {
            kS();
        }
    }

    public final void a(RecyclerView recyclerView, o oVar) {
        super.a(recyclerView, oVar);
        removeCallbacks(this.asg);
        for (int i = 0; i < this.akU; i++) {
            this.arR[i].clear();
        }
        recyclerView.requestLayout();
    }

    private View kT() {
        int i;
        int i2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.akU);
        bitSet.set(0, this.akU, true);
        boolean z = (this.mOrientation == 1 && ib()) ? true : true;
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
                if (a(layoutParams.ask)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.ask.mIndex);
            }
            if (!(layoutParams.asl || i3 + i2 == i)) {
                boolean z2;
                View childAt2 = getChildAt(i3 + i2);
                int bg;
                if (this.alD) {
                    childCount = this.arS.bg(childAt);
                    bg = this.arS.bg(childAt2);
                    if (childCount < bg) {
                        return childAt;
                    }
                    if (childCount == bg) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    childCount = this.arS.bf(childAt);
                    bg = this.arS.bf(childAt2);
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

    private boolean a(b bVar) {
        if (this.alD) {
            if (bVar.lc() < this.arS.jf()) {
                return !((LayoutParams) ((View) bVar.asv.get(bVar.asv.size() + -1)).getLayoutParams()).asl;
            }
        } else if (bVar.la() > this.arS.je()) {
            return !((LayoutParams) ((View) bVar.asv.get(0)).getLayoutParams()).asl;
        }
        return false;
    }

    public final void T(String str) {
        if (this.asb == null) {
            super.T(str);
        }
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

    private boolean ib() {
        return s.T(this.aiB) == 1;
    }

    public final void a(Rect rect, int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            paddingTop = i.l(i2, paddingTop + rect.height(), s.aa(this.aiB));
            paddingRight = i.l(i, paddingRight + (this.arU * this.akU), s.Z(this.aiB));
        } else {
            paddingRight = i.l(i, paddingRight + rect.width(), s.Z(this.aiB));
            paddingTop = i.l(i2, paddingTop + (this.arU * this.akU), s.aa(this.aiB));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    public final void c(o oVar, RecyclerView.s sVar) {
        Object obj = 1;
        while (true) {
            Object obj2 = obj;
            a aVar = this.asd;
            if (!(this.asb == null && this.alG == -1) && sVar.getItemCount() == 0) {
                d(oVar);
                aVar.reset();
                return;
            }
            Object obj3;
            int i;
            int i2;
            int itemCount;
            int childCount;
            if (aVar.alP && this.alG == -1 && this.asb == null) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (obj3 != null) {
                boolean z;
                aVar.reset();
                if (this.asb != null) {
                    if (this.asb.asr > 0) {
                        if (this.asb.asr == this.akU) {
                            for (i = 0; i < this.akU; i++) {
                                this.arR[i].clear();
                                i2 = this.asb.ass[i];
                                if (i2 != j.INVALID_ID) {
                                    if (this.asb.alZ) {
                                        i2 += this.arS.jf();
                                    } else {
                                        i2 += this.arS.je();
                                    }
                                }
                                this.arR[i].cU(i2);
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
                    T(null);
                    if (!(this.asb == null || this.asb.alC == z)) {
                        this.asb.alC = z;
                    }
                    this.alC = z;
                    requestLayout();
                    iI();
                    if (this.asb.alX != -1) {
                        this.alG = this.asb.alX;
                        aVar.alO = this.asb.alZ;
                    } else {
                        aVar.alO = this.alD;
                    }
                    if (this.asb.ast > 1) {
                        this.arX.mData = this.asb.asu;
                        this.arX.asm = this.asb.asm;
                    }
                } else {
                    iI();
                    aVar.alO = this.alD;
                }
                if (sVar.apv || this.alG == -1) {
                    obj = null;
                } else if (this.alG < 0 || this.alG >= sVar.getItemCount()) {
                    this.alG = -1;
                    this.alH = j.INVALID_ID;
                    obj = null;
                } else {
                    if (this.asb == null || this.asb.alX == -1 || this.asb.asr <= 0) {
                        View bW = bW(this.alG);
                        if (bW != null) {
                            if (this.alD) {
                                i = kW();
                            } else {
                                i = kX();
                            }
                            aVar.mPosition = i;
                            if (this.alH != j.INVALID_ID) {
                                if (aVar.alO) {
                                    aVar.Lp = (this.arS.jf() - this.alH) - this.arS.bg(bW);
                                } else {
                                    aVar.Lp = (this.arS.je() + this.alH) - this.arS.bf(bW);
                                }
                                obj = 1;
                            } else if (this.arS.bj(bW) > this.arS.jg()) {
                                if (aVar.alO) {
                                    i = this.arS.jf();
                                } else {
                                    i = this.arS.je();
                                }
                                aVar.Lp = i;
                            } else {
                                i = this.arS.bf(bW) - this.arS.je();
                                if (i < 0) {
                                    aVar.Lp = -i;
                                } else {
                                    i = this.arS.jf() - this.arS.bg(bW);
                                    if (i < 0) {
                                        aVar.Lp = i;
                                    } else {
                                        aVar.Lp = j.INVALID_ID;
                                    }
                                }
                            }
                        } else {
                            aVar.mPosition = this.alG;
                            if (this.alH == j.INVALID_ID) {
                                if (cJ(aVar.mPosition) == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                aVar.alO = z;
                                if (aVar.alO) {
                                    i = aVar.asj.arS.jf();
                                } else {
                                    i = aVar.asj.arS.je();
                                }
                                aVar.Lp = i;
                            } else {
                                i = this.alH;
                                if (aVar.alO) {
                                    aVar.Lp = aVar.asj.arS.jf() - i;
                                } else {
                                    aVar.Lp = i + aVar.asj.arS.je();
                                }
                            }
                            aVar.ash = true;
                        }
                    } else {
                        aVar.Lp = j.INVALID_ID;
                        aVar.mPosition = this.alG;
                    }
                    obj = 1;
                }
                if (obj == null) {
                    if (this.arZ) {
                        itemCount = sVar.getItemCount();
                        for (i2 = getChildCount() - 1; i2 >= 0; i2--) {
                            i = i.bt(getChildAt(i2));
                            if (i >= 0 && i < itemCount) {
                                break;
                            }
                        }
                        i = 0;
                    } else {
                        itemCount = sVar.getItemCount();
                        childCount = getChildCount();
                        for (i2 = 0; i2 < childCount; i2++) {
                            i = i.bt(getChildAt(i2));
                            if (i >= 0 && i < itemCount) {
                                break;
                            }
                        }
                        i = 0;
                    }
                    aVar.mPosition = i;
                    aVar.Lp = j.INVALID_ID;
                }
                aVar.alP = true;
            }
            if (this.asb == null && this.alG == -1 && !(aVar.alO == this.arZ && ib() == this.asa)) {
                this.arX.clear();
                aVar.ash = true;
            }
            if (getChildCount() > 0 && (this.asb == null || this.asb.asr <= 0)) {
                if (aVar.ash) {
                    for (i = 0; i < this.akU; i++) {
                        this.arR[i].clear();
                        if (aVar.Lp != j.INVALID_ID) {
                            this.arR[i].cU(aVar.Lp);
                        }
                    }
                } else if (obj3 != null || this.asd.asi == null) {
                    for (i = 0; i < this.akU; i++) {
                        b bVar = this.arR[i];
                        boolean z2 = this.alD;
                        childCount = aVar.Lp;
                        if (z2) {
                            i2 = bVar.cT(j.INVALID_ID);
                        } else {
                            i2 = bVar.cS(j.INVALID_ID);
                        }
                        bVar.clear();
                        if (i2 != j.INVALID_ID && ((!z2 || i2 >= bVar.asj.arS.jf()) && (z2 || i2 <= bVar.asj.arS.je()))) {
                            if (childCount != j.INVALID_ID) {
                                i2 += childCount;
                            }
                            bVar.asx = i2;
                            bVar.asw = i2;
                        }
                    }
                    a aVar2 = this.asd;
                    b[] bVarArr = this.arR;
                    itemCount = bVarArr.length;
                    if (aVar2.asi == null || aVar2.asi.length < itemCount) {
                        aVar2.asi = new int[aVar2.asj.arR.length];
                    }
                    for (i = 0; i < itemCount; i++) {
                        aVar2.asi[i] = bVarArr[i].cS(j.INVALID_ID);
                    }
                } else {
                    for (i = 0; i < this.akU; i++) {
                        b bVar2 = this.arR[i];
                        bVar2.clear();
                        bVar2.cU(this.asd.asi[i]);
                    }
                }
            }
            b(oVar);
            this.arV.alf = false;
            this.ase = false;
            cA(this.arT.jg());
            a(aVar.mPosition, sVar);
            if (aVar.alO) {
                cB(-1);
                a(oVar, this.arV, sVar);
                cB(1);
                this.arV.alh = aVar.mPosition + this.arV.ali;
                a(oVar, this.arV, sVar);
            } else {
                cB(1);
                a(oVar, this.arV, sVar);
                cB(-1);
                this.arV.alh = aVar.mPosition + this.arV.ali;
                a(oVar, this.arV, sVar);
            }
            if (this.arT.getMode() != ErrorDialogData.SUPPRESSED) {
                float f = 0.0f;
                childCount = getChildCount();
                itemCount = 0;
                while (itemCount < childCount) {
                    float f2;
                    View childAt = getChildAt(itemCount);
                    float bj = (float) this.arT.bj(childAt);
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
                if (this.arT.getMode() == j.INVALID_ID) {
                    i = Math.min(i, this.arT.jg());
                }
                cA(i);
                if (this.arU != itemCount) {
                    for (i2 = 0; i2 < childCount; i2++) {
                        View childAt2 = getChildAt(i2);
                        LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (!layoutParams.asl) {
                            if (ib() && this.mOrientation == 1) {
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
                    a(oVar, sVar, true);
                    b(oVar, sVar, false);
                } else {
                    b(oVar, sVar, true);
                    a(oVar, sVar, false);
                }
            }
            obj = null;
            if (!(obj2 == null || sVar.apv)) {
                obj2 = (this.arY == 0 || getChildCount() <= 0 || (!this.ase && kT() == null)) ? null : 1;
                if (obj2 != null) {
                    removeCallbacks(this.asg);
                    if (kS()) {
                        obj = 1;
                    }
                }
            }
            if (sVar.apv) {
                this.asd.reset();
            }
            this.arZ = aVar.alO;
            this.asa = ib();
            if (obj != null) {
                this.asd.reset();
                obj = null;
            } else {
                return;
            }
        }
    }

    public final void a(RecyclerView.s sVar) {
        super.a(sVar);
        this.alG = -1;
        this.alH = j.INVALID_ID;
        this.asb = null;
        this.asd.reset();
    }

    private void cA(int i) {
        this.arU = i / this.akU;
        this.asc = MeasureSpec.makeMeasureSpec(i, this.arT.getMode());
    }

    public final boolean iE() {
        return this.asb == null;
    }

    public final int d(RecyclerView.s sVar) {
        return j(sVar);
    }

    private int j(RecyclerView.s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        am amVar = this.arS;
        View at = at(!this.alF);
        if (this.alF) {
            z = false;
        }
        return at.a(sVar, amVar, at, au(z), this, this.alF, this.alD);
    }

    public final int e(RecyclerView.s sVar) {
        return j(sVar);
    }

    public final int f(RecyclerView.s sVar) {
        return k(sVar);
    }

    private int k(RecyclerView.s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        am amVar = this.arS;
        View at = at(!this.alF);
        if (this.alF) {
            z = false;
        }
        return at.a(sVar, amVar, at, au(z), this, this.alF);
    }

    public final int g(RecyclerView.s sVar) {
        return k(sVar);
    }

    public final int h(RecyclerView.s sVar) {
        return l(sVar);
    }

    private int l(RecyclerView.s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        am amVar = this.arS;
        View at = at(!this.alF);
        if (this.alF) {
            z = false;
        }
        return at.b(sVar, amVar, at, au(z), this, this.alF);
    }

    public final int i(RecyclerView.s sVar) {
        return l(sVar);
    }

    private void a(View view, LayoutParams layoutParams) {
        if (layoutParams.asl) {
            if (this.mOrientation == 1) {
                l(view, this.asc, i.c(this.mHeight, this.aoK, getPaddingTop() + getPaddingBottom(), layoutParams.height, true));
            } else {
                l(view, i.c(this.mWidth, this.aoJ, getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.asc);
            }
        } else if (this.mOrientation == 1) {
            l(view, i.c(this.arU, this.aoJ, 0, layoutParams.width, false), i.c(this.mHeight, this.aoK, getPaddingTop() + getPaddingBottom(), layoutParams.height, true));
        } else {
            l(view, i.c(this.mWidth, this.aoJ, getPaddingLeft() + getPaddingRight(), layoutParams.width, true), i.c(this.arU, this.aoK, 0, layoutParams.height, false));
        }
    }

    private void l(View view, int i, int i2) {
        g(view, this.oT);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int o = o(i, layoutParams.leftMargin + this.oT.left, layoutParams.rightMargin + this.oT.right);
        int o2 = o(i2, layoutParams.topMargin + this.oT.top, layoutParams.bottomMargin + this.oT.bottom);
        if (b(view, o, o2, layoutParams)) {
            view.measure(o, o2);
        }
    }

    private static int o(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == j.INVALID_ID || mode == ErrorDialogData.SUPPRESSED) {
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
                kW = kW();
            } else {
                kW = kX();
            }
            savedState.alX = kW;
            if (this.alD) {
                au = au(true);
            } else {
                au = at(true);
            }
            if (au == null) {
                kW = -1;
            } else {
                kW = i.bt(au);
            }
            savedState.asq = kW;
            savedState.asr = this.akU;
            savedState.ass = new int[this.akU];
            for (kW = 0; kW < this.akU; kW++) {
                int cT;
                if (this.arZ) {
                    cT = this.arR[kW].cT(j.INVALID_ID);
                    if (cT != j.INVALID_ID) {
                        cT -= this.arS.jf();
                    }
                } else {
                    cT = this.arR[kW].cS(j.INVALID_ID);
                    if (cT != j.INVALID_ID) {
                        cT -= this.arS.je();
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

    public final void a(o oVar, RecyclerView.s sVar, View view, android.support.v4.view.a.b bVar) {
        int i = 1;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            int kY;
            int i2;
            int i3;
            int i4;
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.mOrientation == 0) {
                kY = layoutParams2.kY();
                if (layoutParams2.asl) {
                    i = this.akU;
                }
                i2 = -1;
                i3 = -1;
                i4 = i;
            } else {
                i3 = layoutParams2.kY();
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
            bVar.H(c.b(kY, i4, i3, i2, layoutParams2.asl));
            return;
        }
        super.a(view, bVar);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View at = at(false);
            View au = au(false);
            if (at != null && au != null) {
                int bt = i.bt(at);
                int bt2 = i.bt(au);
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

    public final int a(o oVar, RecyclerView.s sVar) {
        if (this.mOrientation == 0) {
            return this.akU;
        }
        return super.a(oVar, sVar);
    }

    public final int b(o oVar, RecyclerView.s sVar) {
        if (this.mOrientation == 1) {
            return this.akU;
        }
        return super.b(oVar, sVar);
    }

    private View at(boolean z) {
        int je = this.arS.je();
        int jf = this.arS.jf();
        int childCount = getChildCount();
        View view = null;
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            int bf = this.arS.bf(childAt);
            if (this.arS.bg(childAt) > je && bf < jf) {
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

    private View au(boolean z) {
        int je = this.arS.je();
        int jf = this.arS.jf();
        View view = null;
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            int bf = this.arS.bf(childAt);
            int bg = this.arS.bg(childAt);
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

    private void a(o oVar, RecyclerView.s sVar, boolean z) {
        int cG = cG(j.INVALID_ID);
        if (cG != j.INVALID_ID) {
            cG = this.arS.jf() - cG;
            if (cG > 0) {
                cG -= -c(-cG, oVar, sVar);
                if (z && cG > 0) {
                    this.arS.cc(cG);
                }
            }
        }
    }

    private void b(o oVar, RecyclerView.s sVar, boolean z) {
        int cF = cF(BaseClientBuilder.API_PRIORITY_OTHER);
        if (cF != BaseClientBuilder.API_PRIORITY_OTHER) {
            cF -= this.arS.je();
            if (cF > 0) {
                cF -= c(cF, oVar, sVar);
                if (z && cF > 0) {
                    this.arS.cc(-cF);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int i, RecyclerView.s sVar) {
        int i2;
        int i3;
        ag agVar;
        boolean z = false;
        this.arV.alg = 0;
        this.arV.alh = i;
        if (jV()) {
            i2 = sVar.ape;
            if (i2 != -1) {
                if (this.alD == (i2 < i)) {
                    i2 = this.arS.jg();
                    i3 = 0;
                } else {
                    i3 = this.arS.jg();
                    i2 = 0;
                }
                if (getClipToPadding()) {
                    this.arV.alk = i2 + this.arS.getEnd();
                    this.arV.alj = -i3;
                } else {
                    this.arV.alj = this.arS.je() - i3;
                    this.arV.alk = i2 + this.arS.jf();
                }
                this.arV.all = false;
                this.arV.alf = true;
                agVar = this.arV;
                if (this.arS.getMode() == 0 && this.arS.getEnd() == 0) {
                    z = true;
                }
                agVar.alm = z;
            }
        }
        i2 = 0;
        i3 = 0;
        if (getClipToPadding()) {
        }
        this.arV.all = false;
        this.arV.alf = true;
        agVar = this.arV;
        z = true;
        agVar.alm = z;
    }

    private void cB(int i) {
        int i2 = 1;
        this.arV.sE = i;
        ag agVar = this.arV;
        if (this.alD != (i == -1)) {
            i2 = -1;
        }
        agVar.ali = i2;
    }

    public final void ck(int i) {
        super.ck(i);
        for (int i2 = 0; i2 < this.akU; i2++) {
            this.arR[i2].cV(i);
        }
    }

    public final void cl(int i) {
        super.cl(i);
        for (int i2 = 0; i2 < this.akU; i2++) {
            this.arR[i2].cV(i);
        }
    }

    public final void d(RecyclerView recyclerView, int i, int i2) {
        p(i, i2, 2);
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        p(i, i2, 1);
    }

    public final void a(RecyclerView recyclerView) {
        this.arX.clear();
        requestLayout();
    }

    public final void a(RecyclerView recyclerView, int i, int i2, int i3) {
        p(i, i2, 8);
    }

    public final void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        p(i, i2, 4);
    }

    private void p(int i, int i2, int i3) {
        int i4;
        int i5;
        int kW = this.alD ? kW() : kX();
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
        this.arX.cL(i5);
        switch (i3) {
            case 1:
                this.arX.aN(i, i2);
                break;
            case 2:
                this.arX.aL(i, i2);
                break;
            case 8:
                this.arX.aL(i, 1);
                this.arX.aN(i2, 1);
                break;
        }
        if (i4 > kW) {
            if (i5 <= (this.alD ? kX() : kW())) {
                requestLayout();
            }
        }
    }

    private int a(o oVar, ag agVar, RecyclerView.s sVar) {
        int i;
        int jf;
        int je;
        this.arW.set(0, this.akU, true);
        if (this.arV.alm) {
            i = agVar.sE == 1 ? BaseClientBuilder.API_PRIORITY_OTHER : j.INVALID_ID;
        } else if (agVar.sE == 1) {
            i = agVar.alk + agVar.alg;
        } else {
            i = agVar.alj - agVar.alg;
        }
        aK(agVar.sE, i);
        if (this.alD) {
            jf = this.arS.jf();
        } else {
            jf = this.arS.je();
        }
        Object obj = null;
        while (agVar.b(sVar) && (this.arV.alm || !this.arW.isEmpty())) {
            b a;
            int bj;
            int i2;
            int bj2;
            View a2 = agVar.a(oVar);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int ki = layoutParams.aoM.ki();
            int cM = this.arX.cM(ki);
            Object obj2 = cM == -1 ? 1 : null;
            if (obj2 != null) {
                a = layoutParams.asl ? this.arR[0] : a(agVar);
                this.arX.a(ki, a);
            } else {
                a = this.arR[cM];
            }
            layoutParams.ask = a;
            if (agVar.sE == 1) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
            a(a2, layoutParams);
            if (agVar.sE == 1) {
                if (layoutParams.asl) {
                    cM = cG(jf);
                } else {
                    cM = a.cT(jf);
                }
                bj = this.arS.bj(a2) + cM;
                if (obj2 == null || !layoutParams.asl) {
                    i2 = cM;
                } else {
                    FullSpanItem cC = cC(cM);
                    cC.asn = -1;
                    cC.mPosition = ki;
                    this.arX.a(cC);
                    i2 = cM;
                }
            } else {
                if (layoutParams.asl) {
                    cM = cF(jf);
                } else {
                    cM = a.cS(jf);
                }
                i2 = cM - this.arS.bj(a2);
                if (obj2 != null && layoutParams.asl) {
                    FullSpanItem cD = cD(cM);
                    cD.asn = 1;
                    cD.mPosition = ki;
                    this.arX.a(cD);
                }
                bj = cM;
            }
            if (layoutParams.asl && agVar.ali == -1) {
                if (obj2 == null) {
                    Object obj3 = agVar.sE == 1 ? !kU() ? 1 : null : !kV() ? 1 : null;
                    if (obj3 != null) {
                        FullSpanItem cQ = this.arX.cQ(ki);
                        if (cQ != null) {
                            cQ.asp = true;
                        }
                    }
                }
                this.ase = true;
            }
            a(a2, layoutParams, agVar);
            if (ib() && this.mOrientation == 1) {
                if (layoutParams.asl) {
                    cM = this.arT.jf();
                } else {
                    cM = this.arT.jf() - (((this.akU - 1) - a.mIndex) * this.arU);
                }
                bj2 = cM - this.arT.bj(a2);
                ki = cM;
            } else {
                if (layoutParams.asl) {
                    cM = this.arT.je();
                } else {
                    cM = (a.mIndex * this.arU) + this.arT.je();
                }
                ki = cM + this.arT.bj(a2);
                bj2 = cM;
            }
            if (this.mOrientation == 1) {
                i.k(a2, bj2, i2, ki, bj);
            } else {
                i.k(a2, i2, bj2, bj, ki);
            }
            if (layoutParams.asl) {
                aK(this.arV.sE, i);
            } else {
                a(a, this.arV.sE, i);
            }
            a(oVar, this.arV);
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
            a(oVar, this.arV);
        }
        if (this.arV.sE == -1) {
            je = this.arS.je() - cF(this.arS.je());
        } else {
            je = cG(this.arS.jf()) - this.arS.jf();
        }
        return je > 0 ? Math.min(agVar.alg, je) : 0;
    }

    private FullSpanItem cC(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.aso = new int[this.akU];
        for (int i2 = 0; i2 < this.akU; i2++) {
            fullSpanItem.aso[i2] = i - this.arR[i2].cT(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem cD(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.aso = new int[this.akU];
        for (int i2 = 0; i2 < this.akU; i2++) {
            fullSpanItem.aso[i2] = this.arR[i2].cS(i) - i;
        }
        return fullSpanItem;
    }

    private void a(View view, LayoutParams layoutParams, ag agVar) {
        if (agVar.sE == 1) {
            if (layoutParams.asl) {
                bM(view);
            } else {
                layoutParams.ask.bP(view);
            }
        } else if (layoutParams.asl) {
            bN(view);
        } else {
            layoutParams.ask.bO(view);
        }
    }

    private void a(o oVar, ag agVar) {
        if (agVar.alf && !agVar.alm) {
            int cE;
            if (agVar.alg == 0) {
                if (agVar.sE == -1) {
                    b(oVar, agVar.alk);
                } else {
                    a(oVar, agVar.alj);
                }
            } else if (agVar.sE == -1) {
                cE = agVar.alj - cE(agVar.alj);
                if (cE < 0) {
                    cE = agVar.alk;
                } else {
                    cE = agVar.alk - Math.min(cE, agVar.alg);
                }
                b(oVar, cE);
            } else {
                cE = cH(agVar.alk) - agVar.alk;
                if (cE < 0) {
                    cE = agVar.alj;
                } else {
                    cE = Math.min(cE, agVar.alg) + agVar.alj;
                }
                a(oVar, cE);
            }
        }
    }

    private void bM(View view) {
        for (int i = this.akU - 1; i >= 0; i--) {
            this.arR[i].bP(view);
        }
    }

    private void bN(View view) {
        for (int i = this.akU - 1; i >= 0; i--) {
            this.arR[i].bO(view);
        }
    }

    private void aK(int i, int i2) {
        for (int i3 = 0; i3 < this.akU; i3++) {
            if (!this.arR[i3].asv.isEmpty()) {
                a(this.arR[i3], i, i2);
            }
        }
    }

    private void a(b bVar, int i, int i2) {
        int i3 = bVar.asy;
        if (i == -1) {
            if (i3 + bVar.la() <= i2) {
                this.arW.set(bVar.mIndex, false);
            }
        } else if (bVar.lc() - i3 >= i2) {
            this.arW.set(bVar.mIndex, false);
        }
    }

    private int cE(int i) {
        int cS = this.arR[0].cS(i);
        for (int i2 = 1; i2 < this.akU; i2++) {
            int cS2 = this.arR[i2].cS(i);
            if (cS2 > cS) {
                cS = cS2;
            }
        }
        return cS;
    }

    private int cF(int i) {
        int cS = this.arR[0].cS(i);
        for (int i2 = 1; i2 < this.akU; i2++) {
            int cS2 = this.arR[i2].cS(i);
            if (cS2 < cS) {
                cS = cS2;
            }
        }
        return cS;
    }

    private boolean kU() {
        int cT = this.arR[0].cT(j.INVALID_ID);
        for (int i = 1; i < this.akU; i++) {
            if (this.arR[i].cT(j.INVALID_ID) != cT) {
                return false;
            }
        }
        return true;
    }

    private boolean kV() {
        int cS = this.arR[0].cS(j.INVALID_ID);
        for (int i = 1; i < this.akU; i++) {
            if (this.arR[i].cS(j.INVALID_ID) != cS) {
                return false;
            }
        }
        return true;
    }

    private int cG(int i) {
        int cT = this.arR[0].cT(i);
        for (int i2 = 1; i2 < this.akU; i2++) {
            int cT2 = this.arR[i2].cT(i);
            if (cT2 > cT) {
                cT = cT2;
            }
        }
        return cT;
    }

    private int cH(int i) {
        int cT = this.arR[0].cT(i);
        for (int i2 = 1; i2 < this.akU; i2++) {
            int cT2 = this.arR[i2].cT(i);
            if (cT2 < cT) {
                cT = cT2;
            }
        }
        return cT;
    }

    private void a(o oVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.arS.bg(childAt) <= i && this.arS.bh(childAt) <= i) {
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
                        this.arR[i2].lf();
                    }
                } else if (layoutParams.ask.asv.size() != 1) {
                    layoutParams.ask.lf();
                } else {
                    return;
                }
                a(childAt, oVar);
            } else {
                return;
            }
        }
    }

    private void b(o oVar, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.arS.bf(childAt) >= i && this.arS.bi(childAt) >= i) {
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
                        this.arR[i2].le();
                    }
                } else if (layoutParams.ask.asv.size() != 1) {
                    layoutParams.ask.le();
                } else {
                    return;
                }
                a(childAt, oVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean cI(int i) {
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
        if (((i == -1) == this.alD) != ib()) {
            return false;
        }
        return true;
    }

    private b a(ag agVar) {
        int i;
        int i2;
        int i3;
        b bVar = null;
        if (cI(agVar.sE)) {
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
        b bVar2;
        int cT;
        if (agVar.sE == 1) {
            i4 = BaseClientBuilder.API_PRIORITY_OTHER;
            je = this.arS.je();
            i5 = i;
            while (i5 != i3) {
                bVar2 = this.arR[i5];
                cT = bVar2.cT(je);
                if (cT >= i4) {
                    cT = i4;
                    bVar2 = bVar;
                }
                i5 += i2;
                i4 = cT;
                bVar = bVar2;
            }
        } else {
            i4 = j.INVALID_ID;
            je = this.arS.jf();
            i5 = i;
            while (i5 != i3) {
                bVar2 = this.arR[i5];
                cT = bVar2.cS(je);
                if (cT <= i4) {
                    cT = i4;
                    bVar2 = bVar;
                }
                i5 += i2;
                i4 = cT;
                bVar = bVar2;
            }
        }
        return bVar;
    }

    public final boolean iH() {
        return this.mOrientation == 1;
    }

    public final boolean iG() {
        return this.mOrientation == 0;
    }

    public final int a(int i, o oVar, RecyclerView.s sVar) {
        return c(i, oVar, sVar);
    }

    public final int b(int i, o oVar, RecyclerView.s sVar) {
        return c(i, oVar, sVar);
    }

    private int cJ(int i) {
        if (getChildCount() != 0) {
            if ((i < kX()) != this.alD) {
                return -1;
            }
            return 1;
        } else if (this.alD) {
            return 1;
        } else {
            return -1;
        }
    }

    public final PointF bX(int i) {
        int cJ = cJ(i);
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

    public final void a(RecyclerView recyclerView, int i) {
        ah ahVar = new ah(recyclerView.getContext());
        ahVar.ape = i;
        a((r) ahVar);
    }

    public final void bY(int i) {
        if (!(this.asb == null || this.asb.alX == i)) {
            SavedState savedState = this.asb;
            savedState.ass = null;
            savedState.asr = 0;
            savedState.alX = -1;
            savedState.asq = -1;
        }
        this.alG = i;
        this.alH = j.INVALID_ID;
        requestLayout();
    }

    public final void a(int i, int i2, RecyclerView.s sVar, android.support.v7.widget.RecyclerView.i.a aVar) {
        int i3 = 0;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            b(i, sVar);
            if (this.asf == null || this.asf.length < this.akU) {
                this.asf = new int[this.akU];
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.akU; i5++) {
                int cS;
                if (this.arV.ali == -1) {
                    cS = this.arV.alj - this.arR[i5].cS(this.arV.alj);
                } else {
                    cS = this.arR[i5].cT(this.arV.alk) - this.arV.alk;
                }
                if (cS >= 0) {
                    this.asf[i4] = cS;
                    i4++;
                }
            }
            Arrays.sort(this.asf, 0, i4);
            while (i3 < i4 && this.arV.b(sVar)) {
                aVar.T(this.arV.alh, this.asf[i3]);
                ag agVar = this.arV;
                agVar.alh += this.arV.ali;
                i3++;
            }
        }
    }

    private void b(int i, RecyclerView.s sVar) {
        int kW;
        int i2;
        if (i > 0) {
            kW = kW();
            i2 = 1;
        } else {
            i2 = -1;
            kW = kX();
        }
        this.arV.alf = true;
        a(kW, sVar);
        cB(i2);
        ag agVar = this.arV;
        agVar.alh = kW + agVar.ali;
        this.arV.alg = Math.abs(i);
    }

    private int c(int i, o oVar, RecyclerView.s sVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        b(i, sVar);
        int a = a(oVar, this.arV, sVar);
        if (this.arV.alg >= a) {
            if (i < 0) {
                i = -a;
            } else {
                i = a;
            }
        }
        this.arS.cc(-i);
        this.arZ = this.alD;
        this.arV.alg = 0;
        a(oVar, this.arV);
        return i;
    }

    private int kW() {
        int childCount = getChildCount();
        return childCount == 0 ? 0 : i.bt(getChildAt(childCount - 1));
    }

    private int kX() {
        if (getChildCount() == 0) {
            return 0;
        }
        return i.bt(getChildAt(0));
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams iA() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams d(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final View a(View view, int i, o oVar, RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return null;
        }
        View bl = bl(view);
        if (bl == null) {
            return null;
        }
        int i2;
        iI();
        switch (i) {
            case 1:
                if (this.mOrientation != 1) {
                    if (!ib()) {
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
                    if (!ib()) {
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
                    i2 = j.INVALID_ID;
                    break;
                }
                i2 = -1;
                break;
            case 33:
                if (this.mOrientation != 1) {
                    i2 = j.INVALID_ID;
                    break;
                }
                i2 = -1;
                break;
            case 66:
                if (this.mOrientation != 0) {
                    i2 = j.INVALID_ID;
                    break;
                }
                i2 = 1;
                break;
            case 130:
                if (this.mOrientation != 1) {
                    i2 = j.INVALID_ID;
                    break;
                }
                i2 = 1;
                break;
            default:
                i2 = j.INVALID_ID;
                break;
        }
        if (i2 == j.INVALID_ID) {
            return null;
        }
        int kW;
        View aQ;
        int i3;
        View bW;
        LayoutParams layoutParams = (LayoutParams) bl.getLayoutParams();
        boolean z = layoutParams.asl;
        b bVar = layoutParams.ask;
        if (i2 == 1) {
            kW = kW();
        } else {
            kW = kX();
        }
        a(kW, sVar);
        cB(i2);
        ag agVar = this.arV;
        agVar.alh = agVar.ali + kW;
        this.arV.alg = (int) (0.33333334f * ((float) this.arS.jg()));
        this.arV.all = true;
        this.arV.alf = false;
        a(oVar, this.arV, sVar);
        this.arZ = this.alD;
        if (!z) {
            aQ = bVar.aQ(kW, i2);
            if (!(aQ == null || aQ == bl)) {
                return aQ;
            }
        }
        if (cI(i2)) {
            for (int i4 = this.akU - 1; i4 >= 0; i4--) {
                aQ = this.arR[i4].aQ(kW, i2);
                if (aQ != null && aQ != bl) {
                    return aQ;
                }
            }
        } else {
            for (i3 = 0; i3 < this.akU; i3++) {
                View aQ2 = this.arR[i3].aQ(kW, i2);
                if (aQ2 != null && aQ2 != bl) {
                    return aQ2;
                }
            }
        }
        Object obj = (!this.alC ? 1 : null) == (i2 == -1 ? 1 : null) ? 1 : null;
        if (!z) {
            if (obj != null) {
                kW = bVar.lg();
            } else {
                kW = bVar.lh();
            }
            bW = bW(kW);
            if (!(bW == null || bW == bl)) {
                return bW;
            }
        }
        if (cI(i2)) {
            for (i3 = this.akU - 1; i3 >= 0; i3--) {
                if (i3 != bVar.mIndex) {
                    if (obj != null) {
                        kW = this.arR[i3].lg();
                    } else {
                        kW = this.arR[i3].lh();
                    }
                    bW = bW(kW);
                    if (!(bW == null || bW == bl)) {
                        return bW;
                    }
                }
            }
        } else {
            for (kW = 0; kW < this.akU; kW++) {
                if (obj != null) {
                    i3 = this.arR[kW].lg();
                } else {
                    i3 = this.arR[kW].lh();
                }
                aQ = bW(i3);
                if (aQ != null && aQ != bl) {
                    return aQ;
                }
            }
        }
        return null;
    }
}
