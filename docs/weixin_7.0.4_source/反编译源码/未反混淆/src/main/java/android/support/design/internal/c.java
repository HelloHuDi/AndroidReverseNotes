package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.support.v7.widget.RecyclerView.v;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import java.util.ArrayList;

public final class c implements o {
    public ColorStateList lE;
    public NavigationMenuView lJ;
    public LinearLayout lK;
    private android.support.v7.view.menu.o.a lL;
    public b lM;
    int lN;
    boolean lO;
    public ColorStateList lP;
    public Drawable lQ;
    public int lR;
    int lS;
    android.support.v7.view.menu.h lo;
    public int mId;
    public LayoutInflater mLayoutInflater;
    final OnClickListener mOnClickListener = new OnClickListener() {
        public final void onClick(View view) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            c.this.o(true);
            MenuItem itemData = navigationMenuItemView.getItemData();
            boolean a = c.this.lo.a(itemData, c.this, 0);
            if (itemData != null && itemData.isCheckable() && a) {
                c.this.lM.d(itemData);
            }
            c.this.o(false);
            c.this.n(false);
        }
    };

    interface d {
    }

    static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.s8, viewGroup, false));
            this.apJ.setOnClickListener(onClickListener);
        }
    }

    static class f implements d {
        final android.support.v7.view.menu.j lV;
        boolean lW;

        f(android.support.v7.view.menu.j jVar) {
            this.lV = jVar;
        }
    }

    static class e implements d {
        final int jA;
        final int jy;

        public e(int i, int i2) {
            this.jy = i;
            this.jA = i2;
        }
    }

    static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.s_, viewGroup, false));
        }
    }

    public class b extends android.support.v7.widget.RecyclerView.a<j> {
        private android.support.v7.view.menu.j lU;
        boolean lr;
        final ArrayList<d> mItems = new ArrayList();

        public final /* synthetic */ void a(v vVar) {
            j jVar = (j) vVar;
            if (jVar instanceof g) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.apJ;
                if (navigationMenuItemView.lD != null) {
                    navigationMenuItemView.lD.removeAllViews();
                }
                navigationMenuItemView.lC.setCompoundDrawables(null, null, null, null);
            }
        }

        public b() {
            bu();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemCount() {
            return this.mItems.size();
        }

        public final int getItemViewType(int i) {
            d dVar = (d) this.mItems.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (!(dVar instanceof f)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((f) dVar).lV.hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        /* Access modifiers changed, original: final */
        public final void bu() {
            if (!this.lr) {
                this.lr = true;
                this.mItems.clear();
                this.mItems.add(new c());
                int i = -1;
                int i2 = 0;
                boolean z = false;
                int size = c.this.lo.gB().size();
                int i3 = 0;
                while (i3 < size) {
                    int i4;
                    android.support.v7.view.menu.j jVar = (android.support.v7.view.menu.j) c.this.lo.gB().get(i3);
                    if (jVar.isChecked()) {
                        d(jVar);
                    }
                    if (jVar.isCheckable()) {
                        jVar.V(false);
                    }
                    int i5;
                    if (jVar.hasSubMenu()) {
                        SubMenu subMenu = jVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.mItems.add(new e(c.this.lS, 0));
                            }
                            this.mItems.add(new f(jVar));
                            Object obj = null;
                            int size2 = this.mItems.size();
                            int size3 = subMenu.size();
                            for (i5 = 0; i5 < size3; i5++) {
                                android.support.v7.view.menu.j jVar2 = (android.support.v7.view.menu.j) subMenu.getItem(i5);
                                if (jVar2.isVisible()) {
                                    if (obj == null && jVar2.getIcon() != null) {
                                        obj = 1;
                                    }
                                    if (jVar2.isCheckable()) {
                                        jVar2.V(false);
                                    }
                                    if (jVar.isChecked()) {
                                        d(jVar);
                                    }
                                    this.mItems.add(new f(jVar2));
                                }
                            }
                            if (obj != null) {
                                k(size2, this.mItems.size());
                            }
                        }
                        i4 = i;
                    } else {
                        int size4;
                        boolean z2;
                        i5 = jVar.getGroupId();
                        if (i5 != i) {
                            size4 = this.mItems.size();
                            z2 = jVar.getIcon() != null;
                            if (i3 != 0) {
                                size4++;
                                this.mItems.add(new e(c.this.lS, c.this.lS));
                            }
                        } else if (z || jVar.getIcon() == null) {
                            z2 = z;
                            size4 = i2;
                        } else {
                            z2 = true;
                            k(i2, this.mItems.size());
                            size4 = i2;
                        }
                        f fVar = new f(jVar);
                        fVar.lW = z2;
                        this.mItems.add(fVar);
                        z = z2;
                        i2 = size4;
                        i4 = i5;
                    }
                    i3++;
                    i = i4;
                }
                this.lr = false;
            }
        }

        private void k(int i, int i2) {
            while (i < i2) {
                ((f) this.mItems.get(i)).lW = true;
                i++;
            }
        }

        public final void d(android.support.v7.view.menu.j jVar) {
            if (this.lU != jVar && jVar.isCheckable()) {
                if (this.lU != null) {
                    this.lU.setChecked(false);
                }
                this.lU = jVar;
                jVar.setChecked(true);
            }
        }

        public final Bundle bv() {
            Bundle bundle = new Bundle();
            if (this.lU != null) {
                bundle.putInt("android:menu:checked", this.lU.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.mItems.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) this.mItems.get(i);
                if (dVar instanceof f) {
                    android.support.v7.view.menu.j jVar = ((f) dVar).lV;
                    View actionView = jVar != null ? jVar.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(jVar.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }
    }

    static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.sa, viewGroup, false));
        }
    }

    static class c implements d {
        c() {
        }
    }

    static abstract class j extends v {
        public j(View view) {
            super(view);
        }
    }

    static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    public final void a(Context context, android.support.v7.view.menu.h hVar) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.lo = hVar;
        this.lS = context.getResources().getDimensionPixelOffset(R.dimen.z3);
    }

    public final void n(boolean z) {
        if (this.lM != null) {
            b bVar = this.lM;
            bVar.bu();
            bVar.aop.notifyChanged();
        }
    }

    public final void a(android.support.v7.view.menu.o.a aVar) {
        this.lL = aVar;
    }

    public final boolean a(u uVar) {
        return false;
    }

    public final void a(android.support.v7.view.menu.h hVar, boolean z) {
        if (this.lL != null) {
            this.lL.a(hVar, z);
        }
    }

    public final boolean bt() {
        return false;
    }

    public final boolean b(android.support.v7.view.menu.j jVar) {
        return false;
    }

    public final boolean c(android.support.v7.view.menu.j jVar) {
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
        if (this.lJ != null) {
            sparseArray = new SparseArray();
            this.lJ.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.lM != null) {
            bundle.putBundle("android:menu:adapter", this.lM.bv());
        }
        if (this.lK == null) {
            return bundle;
        }
        sparseArray = new SparseArray();
        this.lK.saveHierarchyState(sparseArray);
        bundle.putSparseParcelableArray("android:menu:header", sparseArray);
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i = 0;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.lJ.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                d dVar;
                android.support.v7.view.menu.j jVar;
                b bVar = this.lM;
                int i2 = bundle2.getInt("android:menu:checked", 0);
                if (i2 != 0) {
                    bVar.lr = true;
                    int size = bVar.mItems.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dVar = (d) bVar.mItems.get(i3);
                        if (dVar instanceof f) {
                            jVar = ((f) dVar).lV;
                            if (jVar != null && jVar.getItemId() == i2) {
                                bVar.d(jVar);
                                break;
                            }
                        }
                    }
                    bVar.lr = false;
                    bVar.bu();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = bVar.mItems.size();
                    while (i < size2) {
                        dVar = (d) bVar.mItems.get(i);
                        if (dVar instanceof f) {
                            jVar = ((f) dVar).lV;
                            if (jVar != null) {
                                View actionView = jVar.getActionView();
                                if (actionView != null) {
                                    ParcelableSparseArray parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(jVar.getItemId());
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
                this.lK.restoreHierarchyState(sparseParcelableArray);
            }
        }
    }

    public final void setItemIconTintList(ColorStateList colorStateList) {
        this.lE = colorStateList;
        n(false);
    }

    public final void setItemTextColor(ColorStateList colorStateList) {
        this.lP = colorStateList;
        n(false);
    }

    public final void setItemTextAppearance(int i) {
        this.lN = i;
        this.lO = true;
        n(false);
    }

    public final void setItemBackground(Drawable drawable) {
        this.lQ = drawable;
        n(false);
    }

    public final void o(boolean z) {
        if (this.lM != null) {
            this.lM.lr = z;
        }
    }
}
