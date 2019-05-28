package android.support.p069v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p060b.p061a.C0368a;
import android.support.p057v4.view.C0455b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.p177mm.C25738R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v7.view.menu.h */
public class C6236h implements C0368a {
    private static final int[] abo = new int[]{1, 4, 5, 3, 2, 0};
    Drawable abA;
    View abB;
    private boolean abC = false;
    private boolean abD = false;
    private boolean abE = false;
    boolean abF = false;
    private boolean abG = false;
    private ArrayList<C6239j> abH = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<C0628o>> abI = new CopyOnWriteArrayList();
    C6239j abJ;
    public boolean abK;
    private boolean abp;
    private boolean abq;
    public C0623a abr;
    private ArrayList<C6239j> abs;
    private boolean abt;
    public ArrayList<C6239j> abu;
    private ArrayList<C6239j> abv;
    private boolean abw;
    public int abx = 1;
    private ContextMenuInfo aby;
    CharSequence abz;
    protected final Context mContext;
    ArrayList<C6239j> mItems;
    private final Resources mResources;

    /* renamed from: android.support.v7.view.menu.h$a */
    public interface C0623a {
        /* renamed from: a */
        boolean mo1584a(C6236h c6236h, MenuItem menuItem);

        /* renamed from: b */
        void mo1585b(C6236h c6236h);
    }

    /* renamed from: android.support.v7.view.menu.h$b */
    public interface C0624b {
        /* renamed from: f */
        boolean mo1586f(C6239j c6239j);
    }

    public C6236h(Context context) {
        boolean z = true;
        this.mContext = context;
        this.mResources = context.getResources();
        this.mItems = new ArrayList();
        this.abs = new ArrayList();
        this.abt = true;
        this.abu = new ArrayList();
        this.abv = new ArrayList();
        this.abw = true;
        if (this.mResources.getConfiguration().keyboard == 1 || !this.mResources.getBoolean(C25738R.bool.f11602d)) {
            z = false;
        }
        this.abq = z;
    }

    /* renamed from: a */
    public final void mo14114a(C0628o c0628o) {
        mo14115a(c0628o, this.mContext);
    }

    /* renamed from: a */
    public final void mo14115a(C0628o c0628o, Context context) {
        this.abI.add(new WeakReference(c0628o));
        c0628o.mo1598a(context, this);
        this.abw = true;
    }

    /* renamed from: b */
    public final void mo14126b(C0628o c0628o) {
        Iterator it = this.abI.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0628o c0628o2 = (C0628o) weakReference.get();
            if (c0628o2 == null || c0628o2 == c0628o) {
                this.abI.remove(weakReference);
            }
        }
    }

    /* renamed from: a */
    private boolean m10084a(C7459u c7459u, C0628o c0628o) {
        boolean z = false;
        if (this.abI.isEmpty()) {
            return false;
        }
        if (c0628o != null) {
            z = c0628o.mo1601a(c7459u);
        }
        Iterator it = this.abI.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0628o c0628o2 = (C0628o) weakReference.get();
            if (c0628o2 == null) {
                this.abI.remove(weakReference);
            } else {
                if (z2) {
                    z = z2;
                } else {
                    z = c0628o2.mo1601a(c7459u);
                }
                z2 = z;
            }
        }
        return z2;
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        if (!this.abI.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.abI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.abI.remove(weakReference);
                } else {
                    int id = c0628o.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = c0628o.onSaveInstanceState();
                        if (onSaveInstanceState != null) {
                            sparseArray.put(id, onSaveInstanceState);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public final void dispatchRestoreInstanceState(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.abI.isEmpty()) {
            Iterator it = this.abI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.abI.remove(weakReference);
                } else {
                    int id = c0628o.getId();
                    if (id > 0) {
                        Parcelable parcelable = (Parcelable) sparseParcelableArray.get(id);
                        if (parcelable != null) {
                            c0628o.onRestoreInstanceState(parcelable);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public final void mo14127c(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    /* renamed from: d */
    public final void mo14131d(Bundle bundle) {
        SparseArray sparseArray = null;
        int size = size();
        int i = 0;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((C7459u) item.getSubMenu()).mo14131d(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo14143gu(), sparseArray);
        }
    }

    /* renamed from: e */
    public final void mo14134e(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo14143gu());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C7459u) item.getSubMenu()).mo14134e(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    item.expandActionView();
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: gu */
    public String mo14143gu() {
        return "android:menu:actionviewstates";
    }

    /* renamed from: a */
    public void mo14113a(C0623a c0623a) {
        this.abr = c0623a;
    }

    public MenuItem add(CharSequence charSequence) {
        return mo14111a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return mo14111a(0, 0, 0, this.mResources.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo14111a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo14111a(i, i2, i3, this.mResources.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C6239j c6239j = (C6239j) mo14111a(i, i2, i3, charSequence);
        C7459u c7459u = new C7459u(this.mContext, this, c6239j);
        c6239j.mo14170b(c7459u);
        return c7459u;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.mResources.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeGroup(int i) {
        int i2;
        int size = size();
        for (i2 = 0; i2 < size; i2++) {
            if (((C6239j) this.mItems.get(i2)).getGroupId() == i) {
                size = i2;
                break;
            }
        }
        size = -1;
        if (size >= 0) {
            int size2 = this.mItems.size() - size;
            int i3 = 0;
            while (true) {
                i2 = i3 + 1;
                if (i3 >= size2 || ((C6239j) this.mItems.get(size)).getGroupId() != i) {
                    mo14152p(true);
                } else {
                    m10086l(size, false);
                    i3 = i2;
                }
            }
            mo14152p(true);
        }
    }

    /* renamed from: l */
    private void m10086l(int i, boolean z) {
        if (i >= 0 && i < this.mItems.size()) {
            this.mItems.remove(i);
            if (z) {
                mo14152p(true);
            }
        }
    }

    public void clear() {
        if (this.abJ != null) {
            mo14149h(this.abJ);
        }
        this.mItems.clear();
        mo14152p(true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            C6239j c6239j = (C6239j) this.mItems.get(i2);
            if (c6239j.getGroupId() == i) {
                c6239j.mo14165V(z2);
                c6239j.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.mItems.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            C6239j c6239j = (C6239j) this.mItems.get(i2);
            if (c6239j.getGroupId() == i && c6239j.mo14166X(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            mo14152p(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            C6239j c6239j = (C6239j) this.mItems.get(i2);
            if (c6239j.getGroupId() == i) {
                c6239j.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.abK) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C6239j) this.mItems.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C6239j c6239j = (C6239j) this.mItems.get(i2);
            if (c6239j.getItemId() == i) {
                return c6239j;
            }
            if (c6239j.hasSubMenu()) {
                MenuItem findItem = c6239j.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int size() {
        return this.mItems.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.mItems.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m10082a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.abp = z;
        mo14152p(false);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: gv */
    public boolean mo14144gv() {
        return this.abp;
    }

    /* renamed from: gw */
    public boolean mo14145gw() {
        return this.abq;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public boolean mo14132d(C6236h c6236h, MenuItem menuItem) {
        return this.abr != null && this.abr.mo1584a(c6236h, menuItem);
    }

    /* renamed from: b */
    private static int m10085b(ArrayList<C6239j> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C6239j) arrayList.get(size)).f1915ZO <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m10082a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = mo14116a(a, null, i2);
        }
        if ((i2 & 2) != 0) {
            mo14110U(true);
        }
        return z;
    }

    /* renamed from: a */
    private void m10083a(List<C6239j> list, int i, KeyEvent keyEvent) {
        boolean gv = mo14144gv();
        int modifiers = keyEvent.getModifiers();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.mItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                int i3;
                C6239j c6239j = (C6239j) this.mItems.get(i2);
                if (c6239j.hasSubMenu()) {
                    ((C6236h) c6239j.getSubMenu()).m10083a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = gv ? c6239j.getAlphabeticShortcut() : c6239j.getNumericShortcut();
                if ((modifiers & 69647) == ((gv ? c6239j.getAlphabeticModifiers() : c6239j.getNumericModifiers()) & 69647)) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (!(i3 == 0 || alphabeticShortcut == 0 || ((alphabeticShortcut != keyData.meta[0] && alphabeticShortcut != keyData.meta[2] && (!gv || alphabeticShortcut != 8 || i != 67)) || !c6239j.isEnabled()))) {
                    list.add(c6239j);
                }
            }
        }
    }

    /* renamed from: a */
    private C6239j m10082a(int i, KeyEvent keyEvent) {
        List list = this.abH;
        list.clear();
        m10083a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C6239j) list.get(0);
        }
        boolean gv = mo14144gv();
        for (int i2 = 0; i2 < size; i2++) {
            char alphabeticShortcut;
            C6239j c6239j = (C6239j) list.get(i2);
            if (gv) {
                alphabeticShortcut = c6239j.getAlphabeticShortcut();
            } else {
                alphabeticShortcut = c6239j.getNumericShortcut();
            }
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c6239j;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c6239j;
            }
            if (gv && alphabeticShortcut == 8 && i == 67) {
                return c6239j;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return mo14116a(findItem(i), null, i2);
    }

    /* renamed from: a */
    public final boolean mo14116a(MenuItem menuItem, C0628o c0628o, int i) {
        C6239j c6239j = (C6239j) menuItem;
        if (c6239j == null || !c6239j.isEnabled()) {
            return false;
        }
        boolean z;
        boolean gF = c6239j.mo14171gF();
        C0455b c0455b = c6239j.abS;
        if (c0455b == null || !c0455b.hasSubMenu()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (c6239j.mo14179gN()) {
            expandActionView = c6239j.expandActionView() | gF;
            if (!expandActionView) {
                return expandActionView;
            }
            mo14110U(true);
            return expandActionView;
        } else if (c6239j.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                mo14110U(false);
            }
            if (!c6239j.hasSubMenu()) {
                c6239j.mo14170b(new C7459u(this.mContext, this, c6239j));
            }
            C7459u c7459u = (C7459u) c6239j.getSubMenu();
            if (z) {
                c0455b.onPrepareSubMenu(c7459u);
            }
            expandActionView = m10084a(c7459u, c0628o) | gF;
            if (expandActionView) {
                return expandActionView;
            }
            mo14110U(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                mo14110U(true);
            }
            return gF;
        }
    }

    /* renamed from: U */
    public final void mo14110U(boolean z) {
        if (!this.abG) {
            this.abG = true;
            Iterator it = this.abI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.abI.remove(weakReference);
                } else {
                    c0628o.mo1599a(this, z);
                }
            }
            this.abG = false;
        }
    }

    public void close() {
        mo14110U(true);
    }

    /* renamed from: p */
    public void mo14152p(boolean z) {
        if (this.abC) {
            this.abD = true;
            if (z) {
                this.abE = true;
                return;
            }
            return;
        }
        if (z) {
            this.abt = true;
            this.abw = true;
        }
        if (!this.abI.isEmpty()) {
            mo14146gx();
            Iterator it = this.abI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.abI.remove(weakReference);
                } else {
                    c0628o.mo1606n(z);
                }
            }
            mo14147gy();
        }
    }

    /* renamed from: gx */
    public final void mo14146gx() {
        if (!this.abC) {
            this.abC = true;
            this.abD = false;
            this.abE = false;
        }
    }

    /* renamed from: gy */
    public final void mo14147gy() {
        this.abC = false;
        if (this.abD) {
            this.abD = false;
            mo14152p(this.abE);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: gz */
    public final void mo14148gz() {
        this.abt = true;
        mo14152p(true);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: gA */
    public final void mo14137gA() {
        this.abw = true;
        mo14152p(true);
    }

    /* renamed from: gB */
    public final ArrayList<C6239j> mo14138gB() {
        if (!this.abt) {
            return this.abs;
        }
        this.abs.clear();
        int size = this.mItems.size();
        for (int i = 0; i < size; i++) {
            C6239j c6239j = (C6239j) this.mItems.get(i);
            if (c6239j.isVisible()) {
                this.abs.add(c6239j);
            }
        }
        this.abt = false;
        this.abw = true;
        return this.abs;
    }

    /* renamed from: gC */
    public final void mo14139gC() {
        ArrayList gB = mo14138gB();
        if (this.abw) {
            Iterator it = this.abI.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.abI.remove(weakReference);
                } else {
                    i = c0628o.mo1603bt() | i;
                }
            }
            if (i != 0) {
                this.abu.clear();
                this.abv.clear();
                i = gB.size();
                for (int i2 = 0; i2 < i; i2++) {
                    C6239j c6239j = (C6239j) gB.get(i2);
                    if (c6239j.mo14175gJ()) {
                        this.abu.add(c6239j);
                    } else {
                        this.abv.add(c6239j);
                    }
                }
            } else {
                this.abu.clear();
                this.abv.clear();
                this.abv.addAll(mo14138gB());
            }
            this.abw = false;
        }
    }

    /* renamed from: gD */
    public final ArrayList<C6239j> mo14140gD() {
        mo14139gC();
        return this.abv;
    }

    public void clearHeader() {
        this.abA = null;
        this.abz = null;
        this.abB = null;
        mo14152p(false);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo14112a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = this.mResources;
        if (view != null) {
            this.abB = view;
            this.abz = null;
            this.abA = null;
        } else {
            if (i > 0) {
                this.abz = resources.getText(i);
            } else if (charSequence != null) {
                this.abz = charSequence;
            }
            if (i2 > 0) {
                this.abA = C0380b.m649g(this.mContext, i2);
            } else if (drawable != null) {
                this.abA = drawable;
            }
            this.abB = null;
        }
        mo14152p(false);
    }

    /* renamed from: gE */
    public C6236h mo14141gE() {
        return this;
    }

    /* renamed from: g */
    public boolean mo14136g(C6239j c6239j) {
        boolean z = false;
        if (!this.abI.isEmpty()) {
            mo14146gx();
            Iterator it = this.abI.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.abI.remove(weakReference);
                } else {
                    z = c0628o.mo1602b(c6239j);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            mo14147gy();
            if (z) {
                this.abJ = c6239j;
            }
        }
        return z;
    }

    /* renamed from: h */
    public boolean mo14149h(C6239j c6239j) {
        boolean z = false;
        if (!this.abI.isEmpty() && this.abJ == c6239j) {
            mo14146gx();
            Iterator it = this.abI.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.abI.remove(weakReference);
                } else {
                    z = c0628o.mo1604c(c6239j);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            mo14147gy();
            if (z) {
                this.abJ = null;
            }
        }
        return z;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public MenuItem mo14111a(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = (-65536 & i3) >> 16;
        if (i4 < 0 || i4 >= abo.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i5 = (abo[i4] << 16) | (CdnLogic.kBizGeneric & i3);
        C6239j c6239j = new C6239j(this, i, i2, i3, i5, charSequence, this.abx);
        if (this.aby != null) {
            c6239j.abV = this.aby;
        }
        this.mItems.add(C6236h.m10085b(this.mItems, i5), c6239j);
        mo14152p(true);
        return c6239j;
    }

    public void removeItem(int i) {
        int i2;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((C6239j) this.mItems.get(i3)).getItemId() == i) {
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        m10086l(i2, true);
    }
}
