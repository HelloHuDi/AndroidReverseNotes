package com.tencent.p177mm.plugin.luckymoney.scaledLayout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager */
public abstract class ViewPagerLayoutManager extends LinearLayoutManager {
    private boolean alC = false;
    private boolean alD = false;
    private boolean alF = true;
    private int alG = -1;
    private boolean alI;
    private boolean alm = false;
    public int mOrientation;
    public SparseArray<View> obh = new SparseArray();
    protected int obi;
    protected int obk;
    protected int obl;
    protected int obm;
    protected float obn;
    protected C34454b obo;
    private SavedState obp = null;
    protected float obq;
    private boolean obr;
    private int obs;
    private int obt;
    int obu = -1;
    private Interpolator obv;
    int obw = BaseClientBuilder.API_PRIORITY_OTHER;
    private View obx;

    /* renamed from: com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager$SavedState */
    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C212111();
        boolean oby;
        float offset;
        int position;

        /* renamed from: com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager$SavedState$1 */
        static class C212111 implements Creator<SavedState> {
            C212111() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(42485);
                SavedState savedState = new SavedState(parcel);
                AppMethodBeat.m2505o(42485);
                return savedState;
            }
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(42486);
            this.position = parcel.readInt();
            this.offset = parcel.readFloat();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.oby = z;
            AppMethodBeat.m2505o(42486);
        }

        public SavedState(SavedState savedState) {
            this.position = savedState.position;
            this.offset = savedState.offset;
            this.oby = savedState.oby;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(42487);
            parcel.writeInt(this.position);
            parcel.writeFloat(this.offset);
            parcel.writeInt(this.oby ? 1 : 0);
            AppMethodBeat.m2505o(42487);
        }

        static {
            AppMethodBeat.m2504i(42488);
            AppMethodBeat.m2505o(42488);
        }
    }

    public abstract float bLT();

    /* renamed from: m */
    public abstract void mo36593m(View view, float f);

    public ViewPagerLayoutManager(int i, boolean z) {
        setOrientation(i);
        mo1758ah(z);
        this.aoE = true;
        mo31843an(false);
    }

    /* renamed from: iA */
    public final LayoutParams mo1773iA() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: a */
    public final void mo1756a(RecyclerView recyclerView, C25374o c25374o) {
        super.mo1756a(recyclerView, c25374o);
        if (this.alI) {
            mo31854d(c25374o);
            c25374o.clear();
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.obp != null) {
            return new SavedState(this.obp);
        }
        Parcelable savedState = new SavedState();
        savedState.position = this.alG;
        savedState.offset = this.obn;
        savedState.oby = this.alD;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.obp = new SavedState((SavedState) parcelable);
            requestLayout();
        }
    }

    /* renamed from: iG */
    public final boolean mo1776iG() {
        return this.mOrientation == 0;
    }

    /* renamed from: iH */
    public final boolean mo1777iH() {
        return this.mOrientation == 1;
    }

    public final int getOrientation() {
        return this.mOrientation;
    }

    public final void setOrientation(int i) {
        if (i == 0 || i == 1) {
            mo1745T(null);
            if (i != this.mOrientation) {
                this.mOrientation = i;
                this.obo = null;
                this.obw = BaseClientBuilder.API_PRIORITY_OTHER;
                removeAllViews();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
    }

    /* renamed from: ah */
    public final void mo1758ah(boolean z) {
        mo1745T(null);
        if (z != this.alC) {
            this.alC = z;
            removeAllViews();
        }
    }

    /* renamed from: a */
    public final void mo1755a(RecyclerView recyclerView, int i) {
        int currentPosition;
        if (this.alm) {
            currentPosition = getCurrentPosition();
            int itemCount = getItemCount();
            int i2;
            if (i < currentPosition) {
                i2 = currentPosition - i;
                itemCount = (itemCount - currentPosition) + i;
                currentPosition = i2 < itemCount ? currentPosition - i2 : currentPosition + itemCount;
            } else {
                i2 = i - currentPosition;
                itemCount = (itemCount + currentPosition) - i;
                currentPosition = i2 < itemCount ? currentPosition + i2 : currentPosition - itemCount;
            }
            currentPosition = mo36594qY(currentPosition);
        } else {
            currentPosition = mo36594qY(i);
        }
        if (this.mOrientation == 1) {
            recyclerView.mo66329a(0, currentPosition, this.obv);
        } else {
            recyclerView.mo66329a(currentPosition, 0, this.obv);
        }
    }

    /* renamed from: c */
    public final void mo1765c(C25374o c25374o, C31880s c31880s) {
        if (c31880s.getItemCount() == 0) {
            mo31854d(c25374o);
            this.obn = 0.0f;
            return;
        }
        boolean z;
        ViewPagerLayoutManager viewPagerLayoutManager;
        mo1778iJ();
        if (this.mOrientation == 1 || !mo1784ib()) {
            z = this.alC;
            viewPagerLayoutManager = this;
        } else if (this.alC) {
            z = false;
            viewPagerLayoutManager = this;
        } else {
            z = true;
            viewPagerLayoutManager = this;
        }
        viewPagerLayoutManager.alD = z;
        View d = ViewPagerLayoutManager.m32566d(c25374o, c31880s, 0);
        if (d == null) {
            mo31854d(c25374o);
            this.obn = 0.0f;
            return;
        }
        mo31849bu(d);
        this.obi = this.obo.mo24294bj(d);
        this.obk = this.obo.mo24295bk(d);
        this.obl = (this.obo.mo24297jg() - this.obi) / 2;
        if (this.obw == BaseClientBuilder.API_PRIORITY_OTHER) {
            this.obm = (this.obo.bLR() - this.obk) / 2;
        } else {
            this.obm = (this.obo.bLR() - this.obk) - this.obw;
        }
        this.obq = bLT();
        bLV();
        if (this.obq == 0.0f) {
            this.obs = 1;
            this.obt = 1;
        } else {
            this.obs = ((int) Math.abs(bMd() / this.obq)) + 1;
            this.obt = ((int) Math.abs(bMc() / this.obq)) + 1;
        }
        if (this.obp != null) {
            this.alD = this.obp.oby;
            this.alG = this.obp.position;
            this.obn = this.obp.offset;
        }
        if (this.alG != -1) {
            this.obn = this.alD ? ((float) this.alG) * (-this.obq) : ((float) this.alG) * this.obq;
        }
        m32568e(c25374o);
    }

    /* renamed from: d */
    private static View m32566d(C25374o c25374o, C31880s c31880s, int i) {
        while (i < c31880s.getItemCount() && i >= 0) {
            try {
                return c25374o.mo42372cq(i);
            } catch (Exception e) {
                i++;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo1753a(C31880s c31880s) {
        super.mo1753a(c31880s);
        this.obp = null;
        this.alG = -1;
    }

    /* renamed from: a */
    public final boolean mo31836a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
        boolean z = false;
        int currentPosition = getCurrentPosition();
        View bW = mo1760bW(currentPosition);
        if (bW != null) {
            if (recyclerView.hasFocus()) {
                if (this.mOrientation == 1) {
                    if (i == 33) {
                        if (!this.alD) {
                            z = true;
                        }
                    } else if (i != 130) {
                        z = true;
                    } else if (this.alD) {
                        z = true;
                    }
                } else if (i == 17) {
                    if (!this.alD) {
                        z = true;
                    }
                } else if (i != 66) {
                    z = true;
                } else if (this.alD) {
                    z = true;
                }
                if (!z) {
                    C34457d.m56483a(recyclerView, this, z ? currentPosition - 1 : currentPosition + 1);
                }
            } else {
                bW.addFocusables(arrayList, i, i2);
            }
        }
        return true;
    }

    /* renamed from: a */
    public final View mo1748a(View view, int i, C25374o c25374o, C31880s c31880s) {
        return null;
    }

    /* renamed from: iJ */
    public final void mo1778iJ() {
        if (this.obo == null) {
            this.obo = C34454b.m56464a(this, this.mOrientation);
        }
    }

    /* Access modifiers changed, original: protected */
    public void bLV() {
    }

    /* renamed from: xS */
    private float m32570xS(int i) {
        return this.alD ? ((float) i) * (-this.obq) : ((float) i) * this.obq;
    }

    /* renamed from: jW */
    public final void mo31875jW() {
        removeAllViews();
        this.obn = 0.0f;
    }

    /* renamed from: bY */
    public final void mo1762bY(int i) {
        if (this.alm || (i >= 0 && i < getItemCount())) {
            this.alG = i;
            this.obn = this.alD ? ((float) i) * (-this.obq) : ((float) i) * this.obq;
            requestLayout();
        }
    }

    /* renamed from: d */
    public final int mo1766d(C31880s c31880s) {
        return bLW();
    }

    /* renamed from: e */
    public final int mo1767e(C31880s c31880s) {
        return bLW();
    }

    /* renamed from: f */
    public final int mo1768f(C31880s c31880s) {
        return bLX();
    }

    /* renamed from: g */
    public final int mo1769g(C31880s c31880s) {
        return bLX();
    }

    /* renamed from: h */
    public final int mo1771h(C31880s c31880s) {
        return bLY();
    }

    /* renamed from: i */
    public final int mo1772i(C31880s c31880s) {
        return bLY();
    }

    private int bLW() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.alF) {
            return !this.alD ? getCurrentPosition() : (getItemCount() - getCurrentPosition()) - 1;
        } else {
            float bMf = bMf();
            return !this.alD ? (int) bMf : (int) (bMf + (((float) (getItemCount() - 1)) * this.obq));
        }
    }

    private int bLX() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (this.alF) {
            return (int) this.obq;
        }
        return 1;
    }

    private int bLY() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (this.alF) {
            return (int) (((float) getItemCount()) * this.obq);
        }
        return getItemCount();
    }

    /* renamed from: a */
    public final int mo1746a(int i, C25374o c25374o, C31880s c31880s) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return m32565b(i, c25374o);
    }

    /* renamed from: b */
    public final int mo1759b(int i, C25374o c25374o, C31880s c31880s) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return m32565b(i, c25374o);
    }

    /* renamed from: b */
    private int m32565b(int i, C25374o c25374o) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        mo1778iJ();
        float bLU = ((float) i) / bLU();
        if (Math.abs(bLU) < 1.0E-8f) {
            return 0;
        }
        float f = this.obn + bLU;
        if (!this.alm && f < bMb()) {
            i = (int) (((float) i) - ((f - bMb()) * bLU()));
        } else if (!this.alm && f > bMa()) {
            i = (int) ((bMa() - this.obn) * bLU());
        }
        this.obn = (((float) i) / bLU()) + this.obn;
        m32568e(c25374o);
        return i;
    }

    /* renamed from: e */
    private void m32568e(C25374o c25374o) {
        mo31845b(c25374o);
        this.obh.clear();
        int itemCount = getItemCount();
        if (itemCount != 0) {
            int bMe = this.alD ? -bMe() : bMe();
            int i = bMe - this.obs;
            int i2 = this.obt + bMe;
            if (bLZ()) {
                if (this.obu % 2 == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                    i2 = this.obu / 2;
                    i = (bMe - i2) + 1;
                    i2 = (i2 + bMe) + 1;
                } else {
                    i2 = (this.obu - 1) / 2;
                    i = bMe - i2;
                    i2 = (i2 + bMe) + 1;
                }
            }
            if (!this.alm) {
                if (i < 0) {
                    if (bLZ()) {
                        i2 = this.obu;
                        i = 0;
                    } else {
                        i = 0;
                    }
                }
                if (i2 > itemCount) {
                    i2 = itemCount;
                }
            }
            float f = Float.MIN_VALUE;
            int i3 = i;
            while (i3 < i2) {
                float f2;
                if (bLZ() || !m32562aK(m32570xS(i3) - this.obn)) {
                    if (i3 >= itemCount) {
                        i = i3 % itemCount;
                    } else if (i3 < 0) {
                        i = (-i3) % itemCount;
                        if (i == 0) {
                            i = itemCount;
                        }
                        i = itemCount - i;
                    } else {
                        i = i3;
                    }
                    View cq = c25374o.mo42372cq(i);
                    mo31849bu(cq);
                    ViewPagerLayoutManager.m32567do(cq);
                    m32569n(cq, m32570xS(i3) - this.obn);
                    f2 = this.obr ? 0.0f : (float) i;
                    if (f2 > f) {
                        addView(cq);
                    } else {
                        addView(cq, 0);
                    }
                    if (i3 == bMe) {
                        this.obx = cq;
                    }
                    this.obh.put(i3, cq);
                } else {
                    f2 = f;
                }
                i3++;
                f = f2;
            }
            this.obx.requestFocus();
        }
    }

    private boolean bLZ() {
        return this.obu != -1;
    }

    /* renamed from: aK */
    private boolean m32562aK(float f) {
        return f > bMc() || f < bMd();
    }

    /* renamed from: do */
    private static void m32567do(View view) {
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    private float bMa() {
        return !this.alD ? ((float) (getItemCount() - 1)) * this.obq : 0.0f;
    }

    private float bMb() {
        return !this.alD ? 0.0f : ((float) (-(getItemCount() - 1))) * this.obq;
    }

    /* renamed from: n */
    private void m32569n(View view, float f) {
        int aL = m32563aL(f);
        int aM = m32564aM(f);
        if (this.mOrientation == 1) {
            C17480i.m27160j(view, this.obm + aL, this.obl + aM, (aL + this.obm) + this.obk, (aM + this.obl) + this.obi);
        } else {
            C17480i.m27160j(view, this.obl + aL, this.obm + aM, (aL + this.obl) + this.obi, (aM + this.obm) + this.obk);
        }
        mo36593m(view, f);
    }

    /* renamed from: aL */
    private int m32563aL(float f) {
        return this.mOrientation == 1 ? 0 : (int) f;
    }

    /* renamed from: aM */
    private int m32564aM(float f) {
        return this.mOrientation == 1 ? (int) f : 0;
    }

    private float bMc() {
        return (float) (this.obo.mo24297jg() - this.obl);
    }

    private float bMd() {
        return (float) (((-this.obi) - this.obo.mo24296je()) - this.obl);
    }

    /* Access modifiers changed, original: protected */
    public float bLU() {
        return 1.0f;
    }

    private int getCurrentPosition() {
        if (getItemCount() == 0) {
            return 0;
        }
        int bMe = bMe();
        if (!this.alm) {
            return Math.abs(bMe);
        }
        if (this.alD) {
            if (bMe > 0) {
                bMe = getItemCount() - (bMe % getItemCount());
            } else {
                bMe = (-bMe) % getItemCount();
            }
        } else if (bMe >= 0) {
            bMe %= getItemCount();
        } else {
            bMe = (bMe % getItemCount()) + getItemCount();
        }
        return bMe == getItemCount() ? 0 : bMe;
    }

    /* renamed from: bW */
    public final View mo1760bW(int i) {
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return null;
        }
        for (int i2 = 0; i2 < this.obh.size(); i2++) {
            int keyAt = this.obh.keyAt(i2);
            if (keyAt < 0) {
                keyAt %= itemCount;
                if (keyAt == 0) {
                    keyAt = -itemCount;
                }
                if (keyAt + itemCount == i) {
                    return (View) this.obh.valueAt(i2);
                }
            } else if (i == keyAt % itemCount) {
                return (View) this.obh.valueAt(i2);
            }
        }
        return null;
    }

    private int bMe() {
        if (this.obq == 0.0f) {
            return 0;
        }
        return Math.round(this.obn / this.obq);
    }

    private float bMf() {
        if (this.alD) {
            if (!this.alm) {
                return this.obn;
            }
            if (this.obn <= 0.0f) {
                return this.obn % (this.obq * ((float) getItemCount()));
            }
            return (((float) getItemCount()) * (-this.obq)) + (this.obn % (this.obq * ((float) getItemCount())));
        } else if (!this.alm) {
            return this.obn;
        } else {
            if (this.obn >= 0.0f) {
                return this.obn % (this.obq * ((float) getItemCount()));
            }
            return (((float) getItemCount()) * this.obq) + (this.obn % (this.obq * ((float) getItemCount())));
        }
    }

    /* renamed from: qY */
    public final int mo36594qY(int i) {
        if (this.alm) {
            return (int) (((((float) ((!this.alD ? i - bMe() : (-bMe()) - i) + bMe())) * this.obq) - this.obn) * bLU());
        }
        return (int) ((((!this.alD ? this.obq : -this.obq) * ((float) i)) - this.obn) * bLU());
    }
}
