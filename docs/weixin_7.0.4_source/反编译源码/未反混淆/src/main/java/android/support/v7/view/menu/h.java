package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h implements android.support.v4.b.a.a {
    private static final int[] abo = new int[]{1, 4, 5, 3, 2, 0};
    Drawable abA;
    View abB;
    private boolean abC = false;
    private boolean abD = false;
    private boolean abE = false;
    boolean abF = false;
    private boolean abG = false;
    private ArrayList<j> abH = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<o>> abI = new CopyOnWriteArrayList();
    j abJ;
    public boolean abK;
    private boolean abp;
    private boolean abq;
    public a abr;
    private ArrayList<j> abs;
    private boolean abt;
    public ArrayList<j> abu;
    private ArrayList<j> abv;
    private boolean abw;
    public int abx = 1;
    private ContextMenuInfo aby;
    CharSequence abz;
    protected final Context mContext;
    ArrayList<j> mItems;
    private final Resources mResources;

    public interface a {
        boolean a(h hVar, MenuItem menuItem);

        void b(h hVar);
    }

    public interface b {
        boolean f(j jVar);
    }

    public h(Context context) {
        boolean z = true;
        this.mContext = context;
        this.mResources = context.getResources();
        this.mItems = new ArrayList();
        this.abs = new ArrayList();
        this.abt = true;
        this.abu = new ArrayList();
        this.abv = new ArrayList();
        this.abw = true;
        if (this.mResources.getConfiguration().keyboard == 1 || !this.mResources.getBoolean(R.bool.d)) {
            z = false;
        }
        this.abq = z;
    }

    public final void a(o oVar) {
        a(oVar, this.mContext);
    }

    public final void a(o oVar, Context context) {
        this.abI.add(new WeakReference(oVar));
        oVar.a(context, this);
        this.abw = true;
    }

    public final void b(o oVar) {
        Iterator it = this.abI.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            o oVar2 = (o) weakReference.get();
            if (oVar2 == null || oVar2 == oVar) {
                this.abI.remove(weakReference);
            }
        }
    }

    private boolean a(u uVar, o oVar) {
        boolean z = false;
        if (this.abI.isEmpty()) {
            return false;
        }
        if (oVar != null) {
            z = oVar.a(uVar);
        }
        Iterator it = this.abI.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            o oVar2 = (o) weakReference.get();
            if (oVar2 == null) {
                this.abI.remove(weakReference);
            } else {
                if (z2) {
                    z = z2;
                } else {
                    z = oVar2.a(uVar);
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
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.abI.remove(weakReference);
                } else {
                    int id = oVar.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = oVar.onSaveInstanceState();
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
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.abI.remove(weakReference);
                } else {
                    int id = oVar.getId();
                    if (id > 0) {
                        Parcelable parcelable = (Parcelable) sparseParcelableArray.get(id);
                        if (parcelable != null) {
                            oVar.onRestoreInstanceState(parcelable);
                        }
                    }
                }
            }
        }
    }

    public final void c(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public final void d(Bundle bundle) {
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
                ((u) item.getSubMenu()).d(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(gu(), sparseArray);
        }
    }

    public final void e(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(gu());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((u) item.getSubMenu()).e(bundle);
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
    public String gu() {
        return "android:menu:actionviewstates";
    }

    public void a(a aVar) {
        this.abr = aVar;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.mResources.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.mResources.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        j jVar = (j) a(i, i2, i3, charSequence);
        u uVar = new u(this.mContext, this, jVar);
        jVar.b(uVar);
        return uVar;
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
            if (((j) this.mItems.get(i2)).getGroupId() == i) {
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
                if (i3 >= size2 || ((j) this.mItems.get(size)).getGroupId() != i) {
                    p(true);
                } else {
                    l(size, false);
                    i3 = i2;
                }
            }
            p(true);
        }
    }

    private void l(int i, boolean z) {
        if (i >= 0 && i < this.mItems.size()) {
            this.mItems.remove(i);
            if (z) {
                p(true);
            }
        }
    }

    public void clear() {
        if (this.abJ != null) {
            h(this.abJ);
        }
        this.mItems.clear();
        p(true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.mItems.get(i2);
            if (jVar.getGroupId() == i) {
                jVar.V(z2);
                jVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.mItems.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            j jVar = (j) this.mItems.get(i2);
            if (jVar.getGroupId() == i && jVar.X(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            p(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.mItems.get(i2);
            if (jVar.getGroupId() == i) {
                jVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.abK) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((j) this.mItems.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.mItems.get(i2);
            if (jVar.getItemId() == i) {
                return jVar;
            }
            if (jVar.hasSubMenu()) {
                MenuItem findItem = jVar.getSubMenu().findItem(i);
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
        return a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.abp = z;
        p(false);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean gv() {
        return this.abp;
    }

    public boolean gw() {
        return this.abq;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean d(h hVar, MenuItem menuItem) {
        return this.abr != null && this.abr.a(hVar, menuItem);
    }

    private static int b(ArrayList<j> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((j) arrayList.get(size)).ZO <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, null, i2);
        }
        if ((i2 & 2) != 0) {
            U(true);
        }
        return z;
    }

    private void a(List<j> list, int i, KeyEvent keyEvent) {
        boolean gv = gv();
        int modifiers = keyEvent.getModifiers();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.mItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                int i3;
                j jVar = (j) this.mItems.get(i2);
                if (jVar.hasSubMenu()) {
                    ((h) jVar.getSubMenu()).a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = gv ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
                if ((modifiers & 69647) == ((gv ? jVar.getAlphabeticModifiers() : jVar.getNumericModifiers()) & 69647)) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (!(i3 == 0 || alphabeticShortcut == 0 || ((alphabeticShortcut != keyData.meta[0] && alphabeticShortcut != keyData.meta[2] && (!gv || alphabeticShortcut != 8 || i != 67)) || !jVar.isEnabled()))) {
                    list.add(jVar);
                }
            }
        }
    }

    private j a(int i, KeyEvent keyEvent) {
        List list = this.abH;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (j) list.get(0);
        }
        boolean gv = gv();
        for (int i2 = 0; i2 < size; i2++) {
            char alphabeticShortcut;
            j jVar = (j) list.get(i2);
            if (gv) {
                alphabeticShortcut = jVar.getAlphabeticShortcut();
            } else {
                alphabeticShortcut = jVar.getNumericShortcut();
            }
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return jVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return jVar;
            }
            if (gv && alphabeticShortcut == 8 && i == 67) {
                return jVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), null, i2);
    }

    public final boolean a(MenuItem menuItem, o oVar, int i) {
        j jVar = (j) menuItem;
        if (jVar == null || !jVar.isEnabled()) {
            return false;
        }
        boolean z;
        boolean gF = jVar.gF();
        android.support.v4.view.b bVar = jVar.abS;
        if (bVar == null || !bVar.hasSubMenu()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (jVar.gN()) {
            expandActionView = jVar.expandActionView() | gF;
            if (!expandActionView) {
                return expandActionView;
            }
            U(true);
            return expandActionView;
        } else if (jVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                U(false);
            }
            if (!jVar.hasSubMenu()) {
                jVar.b(new u(this.mContext, this, jVar));
            }
            u uVar = (u) jVar.getSubMenu();
            if (z) {
                bVar.onPrepareSubMenu(uVar);
            }
            expandActionView = a(uVar, oVar) | gF;
            if (expandActionView) {
                return expandActionView;
            }
            U(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                U(true);
            }
            return gF;
        }
    }

    public final void U(boolean z) {
        if (!this.abG) {
            this.abG = true;
            Iterator it = this.abI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.abI.remove(weakReference);
                } else {
                    oVar.a(this, z);
                }
            }
            this.abG = false;
        }
    }

    public void close() {
        U(true);
    }

    public void p(boolean z) {
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
            gx();
            Iterator it = this.abI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.abI.remove(weakReference);
                } else {
                    oVar.n(z);
                }
            }
            gy();
        }
    }

    public final void gx() {
        if (!this.abC) {
            this.abC = true;
            this.abD = false;
            this.abE = false;
        }
    }

    public final void gy() {
        this.abC = false;
        if (this.abD) {
            this.abD = false;
            p(this.abE);
        }
    }

    /* Access modifiers changed, original: final */
    public final void gz() {
        this.abt = true;
        p(true);
    }

    /* Access modifiers changed, original: final */
    public final void gA() {
        this.abw = true;
        p(true);
    }

    public final ArrayList<j> gB() {
        if (!this.abt) {
            return this.abs;
        }
        this.abs.clear();
        int size = this.mItems.size();
        for (int i = 0; i < size; i++) {
            j jVar = (j) this.mItems.get(i);
            if (jVar.isVisible()) {
                this.abs.add(jVar);
            }
        }
        this.abt = false;
        this.abw = true;
        return this.abs;
    }

    public final void gC() {
        ArrayList gB = gB();
        if (this.abw) {
            Iterator it = this.abI.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.abI.remove(weakReference);
                } else {
                    i = oVar.bt() | i;
                }
            }
            if (i != 0) {
                this.abu.clear();
                this.abv.clear();
                i = gB.size();
                for (int i2 = 0; i2 < i; i2++) {
                    j jVar = (j) gB.get(i2);
                    if (jVar.gJ()) {
                        this.abu.add(jVar);
                    } else {
                        this.abv.add(jVar);
                    }
                }
            } else {
                this.abu.clear();
                this.abv.clear();
                this.abv.addAll(gB());
            }
            this.abw = false;
        }
    }

    public final ArrayList<j> gD() {
        gC();
        return this.abv;
    }

    public void clearHeader() {
        this.abA = null;
        this.abz = null;
        this.abB = null;
        p(false);
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
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
                this.abA = android.support.v4.content.b.g(this.mContext, i2);
            } else if (drawable != null) {
                this.abA = drawable;
            }
            this.abB = null;
        }
        p(false);
    }

    public h gE() {
        return this;
    }

    public boolean g(j jVar) {
        boolean z = false;
        if (!this.abI.isEmpty()) {
            gx();
            Iterator it = this.abI.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.abI.remove(weakReference);
                } else {
                    z = oVar.b(jVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            gy();
            if (z) {
                this.abJ = jVar;
            }
        }
        return z;
    }

    public boolean h(j jVar) {
        boolean z = false;
        if (!this.abI.isEmpty() && this.abJ == jVar) {
            gx();
            Iterator it = this.abI.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.abI.remove(weakReference);
                } else {
                    z = oVar.c(jVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            gy();
            if (z) {
                this.abJ = null;
            }
        }
        return z;
    }

    /* Access modifiers changed, original: protected */
    public MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = (-65536 & i3) >> 16;
        if (i4 < 0 || i4 >= abo.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i5 = (abo[i4] << 16) | (CdnLogic.kBizGeneric & i3);
        j jVar = new j(this, i, i2, i3, i5, charSequence, this.abx);
        if (this.aby != null) {
            jVar.abV = this.aby;
        }
        this.mItems.add(b(this.mItems, i5), jVar);
        p(true);
        return jVar;
    }

    public void removeItem(int i) {
        int i2;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((j) this.mItems.get(i3)).getItemId() == i) {
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        l(i2, true);
    }
}
