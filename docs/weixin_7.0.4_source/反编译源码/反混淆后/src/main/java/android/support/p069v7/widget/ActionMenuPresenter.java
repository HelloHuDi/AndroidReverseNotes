package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.view.C0455b;
import android.support.p057v4.view.C0455b.C0452a;
import android.support.p069v7.view.C0602a;
import android.support.p069v7.view.menu.ActionMenuItemView;
import android.support.p069v7.view.menu.ActionMenuItemView.C0615b;
import android.support.p069v7.view.menu.C0626n;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C0630p;
import android.support.p069v7.view.menu.C0630p.C0629a;
import android.support.p069v7.view.menu.C0632s;
import android.support.p069v7.view.menu.C6232b;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6239j;
import android.support.p069v7.view.menu.C7459u;
import android.support.p069v7.widget.ActionMenuView.C0642a;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.p177mm.C25738R;
import java.util.ArrayList;

/* renamed from: android.support.v7.widget.ActionMenuPresenter */
final class ActionMenuPresenter extends C6232b implements C0452a {
    private int adA;
    private int adB;
    private int adC;
    private boolean adD;
    private boolean adE;
    private boolean adF;
    boolean adG;
    private int adH;
    private final SparseBooleanArray adI = new SparseBooleanArray();
    private View adJ;
    C6248e adK;
    C6245a adL;
    C0641c adM;
    private C6246b adN;
    final C6249f adO = new C6249f();
    int adP;
    C7460d adv;
    Drawable adw;
    boolean adx;
    private boolean ady;
    private boolean adz;

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$SavedState */
    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C06401();
        public int adV;

        /* renamed from: android.support.v7.widget.ActionMenuPresenter$SavedState$1 */
        static class C06401 implements Creator<SavedState> {
            C06401() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.adV = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.adV);
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$c */
    class C0641c implements Runnable {
        private C6248e adR;

        public C0641c(C6248e c6248e) {
            this.adR = c6248e;
        }

        public final void run() {
            if (ActionMenuPresenter.this.f1907lo != null) {
                C6236h c6236h = ActionMenuPresenter.this.f1907lo;
                if (c6236h.abr != null) {
                    c6236h.abr.mo1585b(c6236h);
                }
            }
            View view = (View) ActionMenuPresenter.this.aao;
            if (!(view == null || view.getWindowToken() == null || !this.adR.mo1592gP())) {
                ActionMenuPresenter.this.adK = this.adR;
            }
            ActionMenuPresenter.this.adM = null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$a */
    class C6245a extends C0626n {
        public C6245a(Context context, C7459u c7459u, View view) {
            super(context, c7459u, view, false);
            if (!((C6239j) c7459u.getItem()).mo14175gJ()) {
                this.f997pP = ActionMenuPresenter.this.adv == null ? (View) ActionMenuPresenter.this.aao : ActionMenuPresenter.this.adv;
            }
            mo1589c(ActionMenuPresenter.this.adO);
        }

        public final void onDismiss() {
            ActionMenuPresenter.this.adL = null;
            ActionMenuPresenter.this.adP = 0;
            super.onDismiss();
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$b */
    class C6246b extends C0615b {
        C6246b() {
        }

        /* renamed from: gm */
        public final C0632s mo1567gm() {
            return ActionMenuPresenter.this.adL != null ? ActionMenuPresenter.this.adL.mo1591gO() : null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$e */
    class C6248e extends C0626n {
        public C6248e(Context context, C6236h c6236h, View view) {
            super(context, c6236h, view, true);
            mo1589c(ActionMenuPresenter.this.adO);
        }

        public final void onDismiss() {
            if (ActionMenuPresenter.this.f1907lo != null) {
                ActionMenuPresenter.this.f1907lo.close();
            }
            ActionMenuPresenter.this.adK = null;
            super.onDismiss();
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$f */
    class C6249f implements C0627a {
        C6249f() {
        }

        /* renamed from: d */
        public final boolean mo1597d(C6236h c6236h) {
            if (c6236h == null) {
                return false;
            }
            ActionMenuPresenter.this.adP = ((C7459u) c6236h).getItem().getItemId();
            C0627a c0627a = ActionMenuPresenter.this.f1906lL;
            return c0627a != null ? c0627a.mo1597d(c6236h) : false;
        }

        /* renamed from: a */
        public final void mo1596a(C6236h c6236h, boolean z) {
            if (c6236h instanceof C7459u) {
                c6236h.mo14141gE().mo14110U(false);
            }
            C0627a c0627a = ActionMenuPresenter.this.f1906lL;
            if (c0627a != null) {
                c0627a.mo1596a(c6236h, z);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$d */
    class C7460d extends AppCompatImageView implements C0642a {
        private final float[] adS = new float[2];

        public C7460d(Context context) {
            super(context, null, C25738R.attr.f5611dq);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C0701be.m1558a(this, getContentDescription());
            setOnTouchListener(new C0687ae(this, ActionMenuPresenter.this) {
                /* renamed from: gm */
                public final C0632s mo1948gm() {
                    if (ActionMenuPresenter.this.adK == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.adK.mo1591gO();
                }

                /* renamed from: gn */
                public final boolean mo1949gn() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                /* renamed from: hc */
                public final boolean mo1950hc() {
                    if (ActionMenuPresenter.this.adM != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.hideOverflowMenu();
                    return true;
                }
            });
        }

        public final boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
        }

        /* renamed from: gk */
        public final boolean mo1653gk() {
            return false;
        }

        /* renamed from: gl */
        public final boolean mo1654gl() {
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0280a.m456a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void mo1598a(Context context, C6236h c6236h) {
        boolean z = true;
        super.mo1598a(context, c6236h);
        Resources resources = context.getResources();
        C0602a X = C0602a.m1303X(context);
        if (!this.adz) {
            if (VERSION.SDK_INT < 19 && ViewConfiguration.get(X.mContext).hasPermanentMenuKey()) {
                z = false;
            }
            this.ady = z;
        }
        if (!this.adF) {
            this.adA = X.mContext.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.adD) {
            this.adC = X.mo1481fY();
        }
        int i = this.adA;
        if (this.ady) {
            if (this.adv == null) {
                this.adv = new C7460d(this.aak);
                if (this.adx) {
                    this.adv.setImageDrawable(this.adw);
                    this.adw = null;
                    this.adx = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.adv.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.adv.getMeasuredWidth();
        } else {
            this.adv = null;
        }
        this.adB = i;
        this.adH = (int) (56.0f * resources.getDisplayMetrics().density);
        this.adJ = null;
    }

    /* renamed from: gY */
    public final void mo16477gY() {
        if (!this.adD) {
            this.adC = C0602a.m1303X(this.mContext).mo1481fY();
        }
        if (this.f1907lo != null) {
            this.f1907lo.mo14152p(true);
        }
    }

    /* renamed from: gZ */
    public final void mo16478gZ() {
        this.ady = true;
        this.adz = true;
    }

    /* renamed from: f */
    public final C0630p mo14104f(ViewGroup viewGroup) {
        C0630p c0630p = this.aao;
        C0630p f = super.mo14104f(viewGroup);
        if (c0630p != f) {
            ((ActionMenuView) f).setPresenter(this);
        }
        return f;
    }

    /* renamed from: a */
    public final View mo14100a(C6239j c6239j, View view, ViewGroup viewGroup) {
        View actionView = c6239j.getActionView();
        if (actionView == null || c6239j.mo14179gN()) {
            actionView = super.mo14100a(c6239j, view, viewGroup);
        }
        actionView.setVisibility(c6239j.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.m10171b(layoutParams));
        }
        return actionView;
    }

    /* renamed from: a */
    public final void mo14101a(C6239j c6239j, C0629a c0629a) {
        c0629a.mo1609a(c6239j);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0629a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.aao);
        if (this.adN == null) {
            this.adN = new C6246b();
        }
        actionMenuItemView.setPopupCallback(this.adN);
    }

    /* renamed from: e */
    public final boolean mo14103e(C6239j c6239j) {
        return c6239j.mo14175gJ();
    }

    /* renamed from: n */
    public final void mo1606n(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        super.mo1606n(z);
        ((View) this.aao).requestLayout();
        if (this.f1907lo != null) {
            C6236h c6236h = this.f1907lo;
            c6236h.mo14139gC();
            ArrayList arrayList = c6236h.abu;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                C0455b c0455b = ((C6239j) arrayList.get(i)).abS;
                if (c0455b != null) {
                    c0455b.f553LG = this;
                }
            }
        }
        ArrayList gD = this.f1907lo != null ? this.f1907lo.mo14140gD() : null;
        if (this.ady && gD != null) {
            i = gD.size();
            if (i == 1) {
                int i4;
                if (((C6239j) gD.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.adv == null) {
                this.adv = new C7460d(this.aak);
            }
            ViewGroup viewGroup = (ViewGroup) this.adv.getParent();
            if (viewGroup != this.aao) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.adv);
                }
                ((ActionMenuView) this.aao).addView(this.adv, ActionMenuView.m10176he());
            }
        } else if (this.adv != null && this.adv.getParent() == this.aao) {
            ((ViewGroup) this.aao).removeView(this.adv);
        }
        ((ActionMenuView) this.aao).setOverflowReserved(this.ady);
    }

    /* renamed from: b */
    public final boolean mo14102b(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.adv) {
            return false;
        }
        return super.mo14102b(viewGroup, i);
    }

    /* renamed from: a */
    public final boolean mo1601a(C7459u c7459u) {
        if (!c7459u.hasVisibleItems()) {
            return false;
        }
        View childAt;
        C7459u c7459u2 = c7459u;
        while (c7459u2.acs != this.f1907lo) {
            c7459u2 = (C7459u) c7459u2.acs;
        }
        C6239j item = c7459u2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.aao;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof C0629a) && ((C0629a) childAt).getItemData() == item) {
                    break;
                }
            }
        }
        childAt = null;
        if (childAt == null) {
            return false;
        }
        boolean z;
        this.adP = c7459u.getItem().getItemId();
        int size = c7459u.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item2 = c7459u.getItem(i2);
            if (item2.isVisible() && item2.getIcon() != null) {
                z = true;
                break;
            }
        }
        z = false;
        this.adL = new C6245a(this.mContext, c7459u, childAt);
        this.adL.setForceShowIcon(z);
        if (this.adL.mo1592gP()) {
            super.mo1601a(c7459u);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final boolean showOverflowMenu() {
        if (!this.ady || isOverflowMenuShowing() || this.f1907lo == null || this.aao == null || this.adM != null || this.f1907lo.mo14140gD().isEmpty()) {
            return false;
        }
        this.adM = new C0641c(new C6248e(this.mContext, this.f1907lo, this.adv));
        ((View) this.aao).post(this.adM);
        super.mo1601a(null);
        return true;
    }

    public final boolean hideOverflowMenu() {
        if (this.adM == null || this.aao == null) {
            C6248e c6248e = this.adK;
            if (c6248e == null) {
                return false;
            }
            c6248e.dismiss();
            return true;
        }
        ((View) this.aao).removeCallbacks(this.adM);
        this.adM = null;
        return true;
    }

    /* renamed from: ha */
    public final boolean mo16479ha() {
        return hideOverflowMenu() | mo16480hb();
    }

    /* renamed from: hb */
    public final boolean mo16480hb() {
        if (this.adL == null) {
            return false;
        }
        this.adL.dismiss();
        return true;
    }

    public final boolean isOverflowMenuShowing() {
        return this.adK != null && this.adK.isShowing();
    }

    /* renamed from: bt */
    public final boolean mo1603bt() {
        int size;
        ArrayList arrayList;
        C6239j c6239j;
        int i;
        if (this.f1907lo != null) {
            ArrayList gB = this.f1907lo.mo14138gB();
            size = gB.size();
            arrayList = gB;
        } else {
            size = 0;
            arrayList = null;
        }
        int i2 = this.adC;
        int i3 = this.adB;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.aao;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            c6239j = (C6239j) arrayList.get(i6);
            if (c6239j.mo14177gL()) {
                i4++;
            } else if (c6239j.mo14176gK()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.adG && c6239j.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.ady && (obj != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.adI;
        sparseBooleanArray.clear();
        int i7 = 0;
        if (this.adE) {
            i7 = i3 / this.adH;
            i5 = ((i3 % this.adH) / i7) + this.adH;
        } else {
            i5 = 0;
        }
        i2 = 0;
        int i8 = 0;
        i4 = i7;
        while (i8 < size) {
            C6239j c6239j2 = (C6239j) arrayList.get(i8);
            View a;
            int i9;
            if (c6239j2.mo14177gL()) {
                a = mo14100a(c6239j2, this.adJ, viewGroup);
                if (this.adJ == null) {
                    this.adJ = a;
                }
                if (this.adE) {
                    i = i4 - ActionMenuView.m10173f(a, i5, i4, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                    i = i4;
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = c6239j2.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                c6239j2.mo14167Y(true);
                i2 = i4;
                i7 = i;
                i3 = i9;
            } else if (c6239j2.mo14176gK()) {
                boolean z;
                int groupId = c6239j2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.adE || i4 > 0);
                if (z3) {
                    a = mo14100a(c6239j2, this.adJ, viewGroup);
                    if (this.adJ == null) {
                        this.adJ = a;
                    }
                    if (this.adE) {
                        int f = ActionMenuView.m10173f(a, i5, i4, makeMeasureSpec, 0);
                        i4 -= f;
                        if (f == 0) {
                            i = 0;
                        }
                    } else {
                        a.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    i9 = a.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.adE) {
                        z = i & (i3 >= 0 ? 1 : 0);
                        i9 = i4;
                    } else {
                        z = i & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i4;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (int i10 = 0; i10 < i8; i10++) {
                        c6239j = (C6239j) arrayList.get(i10);
                        if (c6239j.getGroupId() == groupId) {
                            if (c6239j.mo14175gJ()) {
                                i4++;
                            }
                            c6239j.mo14167Y(false);
                        }
                    }
                    i = i4;
                } else {
                    i = i6;
                }
                if (z) {
                    i--;
                }
                c6239j2.mo14167Y(z);
                i7 = i9;
                i6 = i;
            } else {
                c6239j2.mo14167Y(false);
                i7 = i4;
            }
            i8++;
            i4 = i7;
        }
        return true;
    }

    /* renamed from: a */
    public final void mo1599a(C6236h c6236h, boolean z) {
        mo16479ha();
        super.mo1599a(c6236h, z);
    }

    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.adV = this.adP;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.adV > 0) {
                MenuItem findItem = this.f1907lo.findItem(savedState.adV);
                if (findItem != null) {
                    mo1601a((C7459u) findItem.getSubMenu());
                }
            }
        }
    }

    /* renamed from: F */
    public final void mo1041F(boolean z) {
        if (z) {
            super.mo1601a(null);
        } else if (this.f1907lo != null) {
            this.f1907lo.mo14110U(false);
        }
    }

    /* renamed from: a */
    public final void mo16476a(ActionMenuView actionMenuView) {
        this.aao = actionMenuView;
        actionMenuView.f1937lo = this.f1907lo;
    }
}
