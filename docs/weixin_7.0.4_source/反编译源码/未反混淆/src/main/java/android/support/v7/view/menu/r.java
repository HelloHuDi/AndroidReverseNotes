package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.b.a.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;

class r extends c<a> implements Menu {
    r(Context context, a aVar) {
        super(context, aVar);
    }

    public MenuItem add(CharSequence charSequence) {
        return e(((a) this.aar).add(charSequence));
    }

    public MenuItem add(int i) {
        return e(((a) this.aar).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return e(((a) this.aar).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return e(((a) this.aar).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((a) this.aar).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return a(((a) this.aar).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(((a) this.aar).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(((a) this.aar).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((a) this.aar).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = e(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((a) this.aar).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((a) this.aar).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((a) this.aar).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((a) this.aar).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return e(((a) this.aar).findItem(i));
    }

    public int size() {
        return ((a) this.aar).size();
    }

    public MenuItem getItem(int i) {
        return e(((a) this.aar).getItem(i));
    }

    public void close() {
        ((a) this.aar).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((a) this.aar).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((a) this.aar).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((a) this.aar).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((a) this.aar).setQwertyMode(z);
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
        ((a) this.aar).removeItem(i);
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
        ((a) this.aar).removeGroup(i);
    }

    public void clear() {
        if (this.aap != null) {
            this.aap.clear();
        }
        if (this.aaq != null) {
            this.aaq.clear();
        }
        ((a) this.aar).clear();
    }
}
