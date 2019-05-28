package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

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
    protected b obo;
    private SavedState obp = null;
    protected float obq;
    private boolean obr;
    private int obs;
    private int obt;
    int obu = -1;
    private Interpolator obv;
    int obw = BaseClientBuilder.API_PRIORITY_OTHER;
    private View obx;

    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(42485);
                SavedState savedState = new SavedState(parcel);
                AppMethodBeat.o(42485);
                return savedState;
            }
        };
        boolean oby;
        float offset;
        int position;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(42486);
            this.position = parcel.readInt();
            this.offset = parcel.readFloat();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.oby = z;
            AppMethodBeat.o(42486);
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
            AppMethodBeat.i(42487);
            parcel.writeInt(this.position);
            parcel.writeFloat(this.offset);
            parcel.writeInt(this.oby ? 1 : 0);
            AppMethodBeat.o(42487);
        }

        static {
            AppMethodBeat.i(42488);
            AppMethodBeat.o(42488);
        }
    }

    public abstract float bLT();

    public abstract void m(View view, float f);

    public ViewPagerLayoutManager(int i, boolean z) {
        setOrientation(i);
        ah(z);
        this.aoE = true;
        an(false);
    }

    public final LayoutParams iA() {
        return new LayoutParams(-2, -2);
    }

    public final void a(RecyclerView recyclerView, o oVar) {
        super.a(recyclerView, oVar);
        if (this.alI) {
            d(oVar);
            oVar.clear();
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

    public final boolean iG() {
        return this.mOrientation == 0;
    }

    public final boolean iH() {
        return this.mOrientation == 1;
    }

    public final int getOrientation() {
        return this.mOrientation;
    }

    public final void setOrientation(int i) {
        if (i == 0 || i == 1) {
            T(null);
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

    public final void ah(boolean z) {
        T(null);
        if (z != this.alC) {
            this.alC = z;
            removeAllViews();
        }
    }

    public final void a(RecyclerView recyclerView, int i) {
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
            currentPosition = qY(currentPosition);
        } else {
            currentPosition = qY(i);
        }
        if (this.mOrientation == 1) {
            recyclerView.a(0, currentPosition, this.obv);
        } else {
            recyclerView.a(currentPosition, 0, this.obv);
        }
    }

    public final void c(o oVar, s sVar) {
        if (sVar.getItemCount() == 0) {
            d(oVar);
            this.obn = 0.0f;
            return;
        }
        boolean z;
        ViewPagerLayoutManager viewPagerLayoutManager;
        iJ();
        if (this.mOrientation == 1 || !ib()) {
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
        View d = d(oVar, sVar, 0);
        if (d == null) {
            d(oVar);
            this.obn = 0.0f;
            return;
        }
        bu(d);
        this.obi = this.obo.bj(d);
        this.obk = this.obo.bk(d);
        this.obl = (this.obo.jg() - this.obi) / 2;
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
        e(oVar);
    }

    private static View d(o oVar, s sVar, int i) {
        while (i < sVar.getItemCount() && i >= 0) {
            try {
                return oVar.cq(i);
            } catch (Exception e) {
                i++;
            }
        }
        return null;
    }

    public final void a(s sVar) {
        super.a(sVar);
        this.obp = null;
        this.alG = -1;
    }

    public final boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
        boolean z = false;
        int currentPosition = getCurrentPosition();
        View bW = bW(currentPosition);
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
                    d.a(recyclerView, this, z ? currentPosition - 1 : currentPosition + 1);
                }
            } else {
                bW.addFocusables(arrayList, i, i2);
            }
        }
        return true;
    }

    public final View a(View view, int i, o oVar, s sVar) {
        return null;
    }

    public final void iJ() {
        if (this.obo == null) {
            this.obo = b.a(this, this.mOrientation);
        }
    }

    /* Access modifiers changed, original: protected */
    public void bLV() {
    }

    private float xS(int i) {
        return this.alD ? ((float) i) * (-this.obq) : ((float) i) * this.obq;
    }

    public final void jW() {
        removeAllViews();
        this.obn = 0.0f;
    }

    public final void bY(int i) {
        if (this.alm || (i >= 0 && i < getItemCount())) {
            this.alG = i;
            this.obn = this.alD ? ((float) i) * (-this.obq) : ((float) i) * this.obq;
            requestLayout();
        }
    }

    public final int d(s sVar) {
        return bLW();
    }

    public final int e(s sVar) {
        return bLW();
    }

    public final int f(s sVar) {
        return bLX();
    }

    public final int g(s sVar) {
        return bLX();
    }

    public final int h(s sVar) {
        return bLY();
    }

    public final int i(s sVar) {
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

    public final int a(int i, o oVar, s sVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return b(i, oVar);
    }

    public final int b(int i, o oVar, s sVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return b(i, oVar);
    }

    private int b(int i, o oVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        iJ();
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
        e(oVar);
        return i;
    }

    private void e(o oVar) {
        b(oVar);
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
                if (bLZ() || !aK(xS(i3) - this.obn)) {
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
                    View cq = oVar.cq(i);
                    bu(cq);
                    m10do(cq);
                    n(cq, xS(i3) - this.obn);
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

    private boolean aK(float f) {
        return f > bMc() || f < bMd();
    }

    /* renamed from: do */
    private static void m10do(View view) {
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

    private void n(View view, float f) {
        int aL = aL(f);
        int aM = aM(f);
        if (this.mOrientation == 1) {
            i.j(view, this.obm + aL, this.obl + aM, (aL + this.obm) + this.obk, (aM + this.obl) + this.obi);
        } else {
            i.j(view, this.obl + aL, this.obm + aM, (aL + this.obl) + this.obi, (aM + this.obm) + this.obk);
        }
        m(view, f);
    }

    private int aL(float f) {
        return this.mOrientation == 1 ? 0 : (int) f;
    }

    private int aM(float f) {
        return this.mOrientation == 1 ? (int) f : 0;
    }

    private float bMc() {
        return (float) (this.obo.jg() - this.obl);
    }

    private float bMd() {
        return (float) (((-this.obi) - this.obo.je()) - this.obl);
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

    public final View bW(int i) {
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

    public final int qY(int i) {
        if (this.alm) {
            return (int) (((((float) ((!this.alD ? i - bMe() : (-bMe()) - i) + bMe())) * this.obq) - this.obn) * bLU());
        }
        return (int) ((((!this.alD ? this.obq : -this.obq) * ((float) i)) - this.obn) * bLU());
    }
}
