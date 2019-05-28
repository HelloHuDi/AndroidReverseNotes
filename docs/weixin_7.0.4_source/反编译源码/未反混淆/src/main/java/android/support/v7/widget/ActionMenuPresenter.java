package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.s;
import android.support.v7.view.menu.u;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import java.util.ArrayList;

final class ActionMenuPresenter extends android.support.v7.view.menu.b implements android.support.v4.view.b.a {
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
    e adK;
    a adL;
    c adM;
    private b adN;
    final f adO = new f();
    int adP;
    d adv;
    Drawable adw;
    boolean adx;
    private boolean ady;
    private boolean adz;

    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        public int adV;

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

    class c implements Runnable {
        private e adR;

        public c(e eVar) {
            this.adR = eVar;
        }

        public final void run() {
            if (ActionMenuPresenter.this.lo != null) {
                h hVar = ActionMenuPresenter.this.lo;
                if (hVar.abr != null) {
                    hVar.abr.b(hVar);
                }
            }
            View view = (View) ActionMenuPresenter.this.aao;
            if (!(view == null || view.getWindowToken() == null || !this.adR.gP())) {
                ActionMenuPresenter.this.adK = this.adR;
            }
            ActionMenuPresenter.this.adM = null;
        }
    }

    class a extends n {
        public a(Context context, u uVar, View view) {
            super(context, uVar, view, false);
            if (!((j) uVar.getItem()).gJ()) {
                this.pP = ActionMenuPresenter.this.adv == null ? (View) ActionMenuPresenter.this.aao : ActionMenuPresenter.this.adv;
            }
            c(ActionMenuPresenter.this.adO);
        }

        public final void onDismiss() {
            ActionMenuPresenter.this.adL = null;
            ActionMenuPresenter.this.adP = 0;
            super.onDismiss();
        }
    }

    class b extends android.support.v7.view.menu.ActionMenuItemView.b {
        b() {
        }

        public final s gm() {
            return ActionMenuPresenter.this.adL != null ? ActionMenuPresenter.this.adL.gO() : null;
        }
    }

    class e extends n {
        public e(Context context, h hVar, View view) {
            super(context, hVar, view, true);
            c(ActionMenuPresenter.this.adO);
        }

        public final void onDismiss() {
            if (ActionMenuPresenter.this.lo != null) {
                ActionMenuPresenter.this.lo.close();
            }
            ActionMenuPresenter.this.adK = null;
            super.onDismiss();
        }
    }

    class f implements android.support.v7.view.menu.o.a {
        f() {
        }

        public final boolean d(h hVar) {
            if (hVar == null) {
                return false;
            }
            ActionMenuPresenter.this.adP = ((u) hVar).getItem().getItemId();
            android.support.v7.view.menu.o.a aVar = ActionMenuPresenter.this.lL;
            return aVar != null ? aVar.d(hVar) : false;
        }

        public final void a(h hVar, boolean z) {
            if (hVar instanceof u) {
                hVar.gE().U(false);
            }
            android.support.v7.view.menu.o.a aVar = ActionMenuPresenter.this.lL;
            if (aVar != null) {
                aVar.a(hVar, z);
            }
        }
    }

    class d extends AppCompatImageView implements android.support.v7.widget.ActionMenuView.a {
        private final float[] adS = new float[2];

        public d(Context context) {
            super(context, null, R.attr.dq);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            be.a(this, getContentDescription());
            setOnTouchListener(new ae(this, ActionMenuPresenter.this) {
                public final s gm() {
                    if (ActionMenuPresenter.this.adK == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.adK.gO();
                }

                public final boolean gn() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                public final boolean hc() {
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

        public final boolean gk() {
            return false;
        }

        public final boolean gl() {
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
                android.support.v4.a.a.a.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context);
    }

    public final void a(Context context, h hVar) {
        boolean z = true;
        super.a(context, hVar);
        Resources resources = context.getResources();
        android.support.v7.view.a X = android.support.v7.view.a.X(context);
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
            this.adC = X.fY();
        }
        int i = this.adA;
        if (this.ady) {
            if (this.adv == null) {
                this.adv = new d(this.aak);
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

    public final void gY() {
        if (!this.adD) {
            this.adC = android.support.v7.view.a.X(this.mContext).fY();
        }
        if (this.lo != null) {
            this.lo.p(true);
        }
    }

    public final void gZ() {
        this.ady = true;
        this.adz = true;
    }

    public final p f(ViewGroup viewGroup) {
        p pVar = this.aao;
        p f = super.f(viewGroup);
        if (pVar != f) {
            ((ActionMenuView) f).setPresenter(this);
        }
        return f;
    }

    public final View a(j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.gN()) {
            actionView = super.a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.b(layoutParams));
        }
        return actionView;
    }

    public final void a(j jVar, android.support.v7.view.menu.p.a aVar) {
        aVar.a(jVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.aao);
        if (this.adN == null) {
            this.adN = new b();
        }
        actionMenuItemView.setPopupCallback(this.adN);
    }

    public final boolean e(j jVar) {
        return jVar.gJ();
    }

    public final void n(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        super.n(z);
        ((View) this.aao).requestLayout();
        if (this.lo != null) {
            h hVar = this.lo;
            hVar.gC();
            ArrayList arrayList = hVar.abu;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                android.support.v4.view.b bVar = ((j) arrayList.get(i)).abS;
                if (bVar != null) {
                    bVar.LG = this;
                }
            }
        }
        ArrayList gD = this.lo != null ? this.lo.gD() : null;
        if (this.ady && gD != null) {
            i = gD.size();
            if (i == 1) {
                int i4;
                if (((j) gD.get(0)).isActionViewExpanded()) {
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
                this.adv = new d(this.aak);
            }
            ViewGroup viewGroup = (ViewGroup) this.adv.getParent();
            if (viewGroup != this.aao) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.adv);
                }
                ((ActionMenuView) this.aao).addView(this.adv, ActionMenuView.he());
            }
        } else if (this.adv != null && this.adv.getParent() == this.aao) {
            ((ViewGroup) this.aao).removeView(this.adv);
        }
        ((ActionMenuView) this.aao).setOverflowReserved(this.ady);
    }

    public final boolean b(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.adv) {
            return false;
        }
        return super.b(viewGroup, i);
    }

    public final boolean a(u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        View childAt;
        u uVar2 = uVar;
        while (uVar2.acs != this.lo) {
            uVar2 = (u) uVar2.acs;
        }
        j item = uVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.aao;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof android.support.v7.view.menu.p.a) && ((android.support.v7.view.menu.p.a) childAt).getItemData() == item) {
                    break;
                }
            }
        }
        childAt = null;
        if (childAt == null) {
            return false;
        }
        boolean z;
        this.adP = uVar.getItem().getItemId();
        int size = uVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item2 = uVar.getItem(i2);
            if (item2.isVisible() && item2.getIcon() != null) {
                z = true;
                break;
            }
        }
        z = false;
        this.adL = new a(this.mContext, uVar, childAt);
        this.adL.setForceShowIcon(z);
        if (this.adL.gP()) {
            super.a(uVar);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final boolean showOverflowMenu() {
        if (!this.ady || isOverflowMenuShowing() || this.lo == null || this.aao == null || this.adM != null || this.lo.gD().isEmpty()) {
            return false;
        }
        this.adM = new c(new e(this.mContext, this.lo, this.adv));
        ((View) this.aao).post(this.adM);
        super.a(null);
        return true;
    }

    public final boolean hideOverflowMenu() {
        if (this.adM == null || this.aao == null) {
            e eVar = this.adK;
            if (eVar == null) {
                return false;
            }
            eVar.dismiss();
            return true;
        }
        ((View) this.aao).removeCallbacks(this.adM);
        this.adM = null;
        return true;
    }

    public final boolean ha() {
        return hideOverflowMenu() | hb();
    }

    public final boolean hb() {
        if (this.adL == null) {
            return false;
        }
        this.adL.dismiss();
        return true;
    }

    public final boolean isOverflowMenuShowing() {
        return this.adK != null && this.adK.isShowing();
    }

    public final boolean bt() {
        int size;
        ArrayList arrayList;
        j jVar;
        int i;
        if (this.lo != null) {
            ArrayList gB = this.lo.gB();
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
            jVar = (j) arrayList.get(i6);
            if (jVar.gL()) {
                i4++;
            } else if (jVar.gK()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.adG && jVar.isActionViewExpanded()) {
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
            j jVar2 = (j) arrayList.get(i8);
            View a;
            int i9;
            if (jVar2.gL()) {
                a = a(jVar2, this.adJ, viewGroup);
                if (this.adJ == null) {
                    this.adJ = a;
                }
                if (this.adE) {
                    i = i4 - ActionMenuView.f(a, i5, i4, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                    i = i4;
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = jVar2.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                jVar2.Y(true);
                i2 = i4;
                i7 = i;
                i3 = i9;
            } else if (jVar2.gK()) {
                boolean z;
                int groupId = jVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.adE || i4 > 0);
                if (z3) {
                    a = a(jVar2, this.adJ, viewGroup);
                    if (this.adJ == null) {
                        this.adJ = a;
                    }
                    if (this.adE) {
                        int f = ActionMenuView.f(a, i5, i4, makeMeasureSpec, 0);
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
                        jVar = (j) arrayList.get(i10);
                        if (jVar.getGroupId() == groupId) {
                            if (jVar.gJ()) {
                                i4++;
                            }
                            jVar.Y(false);
                        }
                    }
                    i = i4;
                } else {
                    i = i6;
                }
                if (z) {
                    i--;
                }
                jVar2.Y(z);
                i7 = i9;
                i6 = i;
            } else {
                jVar2.Y(false);
                i7 = i4;
            }
            i8++;
            i4 = i7;
        }
        return true;
    }

    public final void a(h hVar, boolean z) {
        ha();
        super.a(hVar, z);
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
                MenuItem findItem = this.lo.findItem(savedState.adV);
                if (findItem != null) {
                    a((u) findItem.getSubMenu());
                }
            }
        }
    }

    public final void F(boolean z) {
        if (z) {
            super.a(null);
        } else if (this.lo != null) {
            this.lo.U(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.aao = actionMenuView;
        actionMenuView.lo = this.lo;
    }
}
