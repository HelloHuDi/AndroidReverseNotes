package android.support.p069v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.p057v4.p060b.p061a.C0368a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;

/* renamed from: android.support.v7.view.menu.r */
class C7457r extends C6233c<C0368a> implements Menu {
    C7457r(Context context, C0368a c0368a) {
        super(context, c0368a);
    }

    public MenuItem add(CharSequence charSequence) {
        return mo14106e(((C0368a) this.aar).add(charSequence));
    }

    public MenuItem add(int i) {
        return mo14106e(((C0368a) this.aar).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo14106e(((C0368a) this.aar).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo14106e(((C0368a) this.aar).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return mo14105a(((C0368a) this.aar).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return mo14105a(((C0368a) this.aar).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return mo14105a(((C0368a) this.aar).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return mo14105a(((C0368a) this.aar).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((C0368a) this.aar).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = mo14106e(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((C0368a) this.aar).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((C0368a) this.aar).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((C0368a) this.aar).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((C0368a) this.aar).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return mo14106e(((C0368a) this.aar).findItem(i));
    }

    public int size() {
        return ((C0368a) this.aar).size();
    }

    public MenuItem getItem(int i) {
        return mo14106e(((C0368a) this.aar).getItem(i));
    }

    public void close() {
        ((C0368a) this.aar).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((C0368a) this.aar).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((C0368a) this.aar).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((C0368a) this.aar).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((C0368a) this.aar).setQwertyMode(z);
    }

    public void removeItem(int i) {
        if (this.aap != null) {
            Iterator it = this.aap.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    break;
                }
            }
        }
        ((C0368a) this.aar).removeItem(i);
    }

    public void removeGroup(int i) {
        if (this.aap != null) {
            Iterator it = this.aap.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
        ((C0368a) this.aar).removeGroup(i);
    }

    public void clear() {
        if (this.aap != null) {
            this.aap.clear();
        }
        if (this.aaq != null) {
            this.aaq.clear();
        }
        ((C0368a) this.aar).clear();
    }
}
