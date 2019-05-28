package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p069v7.view.menu.C0628o;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6239j;
import android.support.p069v7.view.menu.C7459u;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.p177mm.C25738R;
import java.util.ArrayList;

/* renamed from: android.support.design.internal.c */
public final class C31832c implements C0628o {
    /* renamed from: lE */
    public ColorStateList f14544lE;
    /* renamed from: lJ */
    public NavigationMenuView f14545lJ;
    /* renamed from: lK */
    public LinearLayout f14546lK;
    /* renamed from: lL */
    private C0627a f14547lL;
    /* renamed from: lM */
    public C31833b f14548lM;
    /* renamed from: lN */
    int f14549lN;
    /* renamed from: lO */
    boolean f14550lO;
    /* renamed from: lP */
    public ColorStateList f14551lP;
    /* renamed from: lQ */
    public Drawable f14552lQ;
    /* renamed from: lR */
    public int f14553lR;
    /* renamed from: lS */
    int f14554lS;
    /* renamed from: lo */
    C6236h f14555lo;
    public int mId;
    public LayoutInflater mLayoutInflater;
    final OnClickListener mOnClickListener = new C173791();

    /* renamed from: android.support.design.internal.c$d */
    interface C8320d {
    }

    /* renamed from: android.support.design.internal.c$g */
    static class C8321g extends C31836j {
        public C8321g(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(2130969278, viewGroup, false));
            this.apJ.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: android.support.design.internal.c$f */
    static class C16501f implements C8320d {
        /* renamed from: lV */
        final C6239j f3503lV;
        /* renamed from: lW */
        boolean f3504lW;

        C16501f(C6239j c6239j) {
            this.f3503lV = c6239j;
        }
    }

    /* renamed from: android.support.design.internal.c$1 */
    class C173791 implements OnClickListener {
        C173791() {
        }

        public final void onClick(View view) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            C31832c.this.mo51789o(true);
            MenuItem itemData = navigationMenuItemView.getItemData();
            boolean a = C31832c.this.f14555lo.mo14116a(itemData, C31832c.this, 0);
            if (itemData != null && itemData.isCheckable() && a) {
                C31832c.this.f14548lM.mo51797d(itemData);
            }
            C31832c.this.mo51789o(false);
            C31832c.this.mo1606n(false);
        }
    }

    /* renamed from: android.support.design.internal.c$e */
    static class C25300e implements C8320d {
        /* renamed from: jA */
        final int f5064jA;
        /* renamed from: jy */
        final int f5065jy;

        public C25300e(int i, int i2) {
            this.f5065jy = i;
            this.f5064jA = i2;
        }
    }

    /* renamed from: android.support.design.internal.c$h */
    static class C25301h extends C31836j {
        public C25301h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(2130969280, viewGroup, false));
        }
    }

    /* renamed from: android.support.design.internal.c$b */
    public class C31833b extends C41523a<C31836j> {
        /* renamed from: lU */
        private C6239j f14557lU;
        /* renamed from: lr */
        boolean f14558lr;
        final ArrayList<C8320d> mItems = new ArrayList();

        /* renamed from: a */
        public final /* synthetic */ void mo51794a(C41531v c41531v) {
            C31836j c31836j = (C31836j) c41531v;
            if (c31836j instanceof C8321g) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) c31836j.apJ;
                if (navigationMenuItemView.f1722lD != null) {
                    navigationMenuItemView.f1722lD.removeAllViews();
                }
                navigationMenuItemView.f1721lC.setCompoundDrawables(null, null, null, null);
            }
        }

        public C31833b() {
            mo51795bu();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemCount() {
            return this.mItems.size();
        }

        public final int getItemViewType(int i) {
            C8320d c8320d = (C8320d) this.mItems.get(i);
            if (c8320d instanceof C25300e) {
                return 2;
            }
            if (c8320d instanceof C31835c) {
                return 3;
            }
            if (!(c8320d instanceof C16501f)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((C16501f) c8320d).f3503lV.hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: bu */
        public final void mo51795bu() {
            if (!this.f14558lr) {
                this.f14558lr = true;
                this.mItems.clear();
                this.mItems.add(new C31835c());
                int i = -1;
                int i2 = 0;
                boolean z = false;
                int size = C31832c.this.f14555lo.mo14138gB().size();
                int i3 = 0;
                while (i3 < size) {
                    int i4;
                    C6239j c6239j = (C6239j) C31832c.this.f14555lo.mo14138gB().get(i3);
                    if (c6239j.isChecked()) {
                        mo51797d(c6239j);
                    }
                    if (c6239j.isCheckable()) {
                        c6239j.mo14165V(false);
                    }
                    int i5;
                    if (c6239j.hasSubMenu()) {
                        SubMenu subMenu = c6239j.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.mItems.add(new C25300e(C31832c.this.f14554lS, 0));
                            }
                            this.mItems.add(new C16501f(c6239j));
                            Object obj = null;
                            int size2 = this.mItems.size();
                            int size3 = subMenu.size();
                            for (i5 = 0; i5 < size3; i5++) {
                                C6239j c6239j2 = (C6239j) subMenu.getItem(i5);
                                if (c6239j2.isVisible()) {
                                    if (obj == null && c6239j2.getIcon() != null) {
                                        obj = 1;
                                    }
                                    if (c6239j2.isCheckable()) {
                                        c6239j2.mo14165V(false);
                                    }
                                    if (c6239j.isChecked()) {
                                        mo51797d(c6239j);
                                    }
                                    this.mItems.add(new C16501f(c6239j2));
                                }
                            }
                            if (obj != null) {
                                m51564k(size2, this.mItems.size());
                            }
                        }
                        i4 = i;
                    } else {
                        int size4;
                        boolean z2;
                        i5 = c6239j.getGroupId();
                        if (i5 != i) {
                            size4 = this.mItems.size();
                            z2 = c6239j.getIcon() != null;
                            if (i3 != 0) {
                                size4++;
                                this.mItems.add(new C25300e(C31832c.this.f14554lS, C31832c.this.f14554lS));
                            }
                        } else if (z || c6239j.getIcon() == null) {
                            z2 = z;
                            size4 = i2;
                        } else {
                            z2 = true;
                            m51564k(i2, this.mItems.size());
                            size4 = i2;
                        }
                        C16501f c16501f = new C16501f(c6239j);
                        c16501f.f3504lW = z2;
                        this.mItems.add(c16501f);
                        z = z2;
                        i2 = size4;
                        i4 = i5;
                    }
                    i3++;
                    i = i4;
                }
                this.f14558lr = false;
            }
        }

        /* renamed from: k */
        private void m51564k(int i, int i2) {
            while (i < i2) {
                ((C16501f) this.mItems.get(i)).f3504lW = true;
                i++;
            }
        }

        /* renamed from: d */
        public final void mo51797d(C6239j c6239j) {
            if (this.f14557lU != c6239j && c6239j.isCheckable()) {
                if (this.f14557lU != null) {
                    this.f14557lU.setChecked(false);
                }
                this.f14557lU = c6239j;
                c6239j.setChecked(true);
            }
        }

        /* renamed from: bv */
        public final Bundle mo51796bv() {
            Bundle bundle = new Bundle();
            if (this.f14557lU != null) {
                bundle.putInt("android:menu:checked", this.f14557lU.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.mItems.size();
            for (int i = 0; i < size; i++) {
                C8320d c8320d = (C8320d) this.mItems.get(i);
                if (c8320d instanceof C16501f) {
                    C6239j c6239j = ((C16501f) c8320d).f3503lV;
                    View actionView = c6239j != null ? c6239j.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(c6239j.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }
    }

    /* renamed from: android.support.design.internal.c$i */
    static class C31834i extends C31836j {
        public C31834i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(2130969281, viewGroup, false));
        }
    }

    /* renamed from: android.support.design.internal.c$c */
    static class C31835c implements C8320d {
        C31835c() {
        }
    }

    /* renamed from: android.support.design.internal.c$j */
    static abstract class C31836j extends C41531v {
        public C31836j(View view) {
            super(view);
        }
    }

    /* renamed from: android.support.design.internal.c$a */
    static class C31837a extends C31836j {
        public C31837a(View view) {
            super(view);
        }
    }

    /* renamed from: a */
    public final void mo1598a(Context context, C6236h c6236h) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.f14555lo = c6236h;
        this.f14554lS = context.getResources().getDimensionPixelOffset(C25738R.dimen.f10360z3);
    }

    /* renamed from: n */
    public final void mo1606n(boolean z) {
        if (this.f14548lM != null) {
            C31833b c31833b = this.f14548lM;
            c31833b.mo51795bu();
            c31833b.aop.notifyChanged();
        }
    }

    /* renamed from: a */
    public final void mo1600a(C0627a c0627a) {
        this.f14547lL = c0627a;
    }

    /* renamed from: a */
    public final boolean mo1601a(C7459u c7459u) {
        return false;
    }

    /* renamed from: a */
    public final void mo1599a(C6236h c6236h, boolean z) {
        if (this.f14547lL != null) {
            this.f14547lL.mo1596a(c6236h, z);
        }
    }

    /* renamed from: bt */
    public final boolean mo1603bt() {
        return false;
    }

    /* renamed from: b */
    public final boolean mo1602b(C6239j c6239j) {
        return false;
    }

    /* renamed from: c */
    public final boolean mo1604c(C6239j c6239j) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }

    public final Parcelable onSaveInstanceState() {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        SparseArray sparseArray;
        Parcelable bundle = new Bundle();
        if (this.f14545lJ != null) {
            sparseArray = new SparseArray();
            this.f14545lJ.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.f14548lM != null) {
            bundle.putBundle("android:menu:adapter", this.f14548lM.mo51796bv());
        }
        if (this.f14546lK == null) {
            return bundle;
        }
        sparseArray = new SparseArray();
        this.f14546lK.saveHierarchyState(sparseArray);
        bundle.putSparseParcelableArray("android:menu:header", sparseArray);
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i = 0;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f14545lJ.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                C8320d c8320d;
                C6239j c6239j;
                C31833b c31833b = this.f14548lM;
                int i2 = bundle2.getInt("android:menu:checked", 0);
                if (i2 != 0) {
                    c31833b.f14558lr = true;
                    int size = c31833b.mItems.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c8320d = (C8320d) c31833b.mItems.get(i3);
                        if (c8320d instanceof C16501f) {
                            c6239j = ((C16501f) c8320d).f3503lV;
                            if (c6239j != null && c6239j.getItemId() == i2) {
                                c31833b.mo51797d(c6239j);
                                break;
                            }
                        }
                    }
                    c31833b.f14558lr = false;
                    c31833b.mo51795bu();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = c31833b.mItems.size();
                    while (i < size2) {
                        c8320d = (C8320d) c31833b.mItems.get(i);
                        if (c8320d instanceof C16501f) {
                            c6239j = ((C16501f) c8320d).f3503lV;
                            if (c6239j != null) {
                                View actionView = c6239j.getActionView();
                                if (actionView != null) {
                                    ParcelableSparseArray parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(c6239j.getItemId());
                                    if (parcelableSparseArray != null) {
                                        actionView.restoreHierarchyState(parcelableSparseArray);
                                    }
                                }
                            }
                        }
                        i++;
                    }
                }
            }
            sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray != null) {
                this.f14546lK.restoreHierarchyState(sparseParcelableArray);
            }
        }
    }

    public final void setItemIconTintList(ColorStateList colorStateList) {
        this.f14544lE = colorStateList;
        mo1606n(false);
    }

    public final void setItemTextColor(ColorStateList colorStateList) {
        this.f14551lP = colorStateList;
        mo1606n(false);
    }

    public final void setItemTextAppearance(int i) {
        this.f14549lN = i;
        this.f14550lO = true;
        mo1606n(false);
    }

    public final void setItemBackground(Drawable drawable) {
        this.f14552lQ = drawable;
        mo1606n(false);
    }

    /* renamed from: o */
    public final void mo51789o(boolean z) {
        if (this.f14548lM != null) {
            this.f14548lM.f14558lr = z;
        }
    }
}
