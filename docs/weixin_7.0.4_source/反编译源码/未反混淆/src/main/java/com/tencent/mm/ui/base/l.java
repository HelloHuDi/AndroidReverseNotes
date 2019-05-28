package com.tencent.mm.ui.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class l implements ContextMenu {
    public CharSequence abz;
    private Context mContext;
    public List<MenuItem> yvT = new ArrayList();

    public l(Context context) {
        AppMethodBeat.i(112533);
        this.mContext = context;
        AppMethodBeat.o(112533);
    }

    public final boolean dzR() {
        AppMethodBeat.i(112534);
        if (this.yvT.size() == 0) {
            AppMethodBeat.o(112534);
            return true;
        }
        AppMethodBeat.o(112534);
        return false;
    }

    public final MenuItem add(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(112535);
        m mVar = new m(this.mContext, i2, i);
        mVar.setTitle(i4);
        this.yvT.add(mVar);
        AppMethodBeat.o(112535);
        return mVar;
    }

    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        AppMethodBeat.i(112536);
        m mVar = new m(this.mContext, i2, i);
        mVar.setTitle(charSequence);
        this.yvT.add(mVar);
        AppMethodBeat.o(112536);
        return mVar;
    }

    public final MenuItem add(int i) {
        AppMethodBeat.i(112537);
        m mVar = new m(this.mContext, 0, 0);
        mVar.setTitle(i);
        this.yvT.add(mVar);
        AppMethodBeat.o(112537);
        return mVar;
    }

    public final MenuItem add(CharSequence charSequence) {
        AppMethodBeat.i(112538);
        m mVar = new m(this.mContext, 0, 0);
        mVar.setTitle(charSequence);
        this.yvT.add(mVar);
        AppMethodBeat.o(112538);
        return mVar;
    }

    public final MenuItem ax(int i, int i2, int i3) {
        AppMethodBeat.i(112539);
        m mVar = new m(this.mContext, i, 0);
        mVar.setTitle(i2);
        mVar.setIcon(i3);
        this.yvT.add(mVar);
        AppMethodBeat.o(112539);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, Drawable drawable) {
        AppMethodBeat.i(112540);
        m mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.setIcon(drawable);
        this.yvT.add(mVar);
        AppMethodBeat.o(112540);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z) {
        AppMethodBeat.i(112541);
        m mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.mKB = charSequence2;
        mVar.setIcon(drawable);
        mVar.xeS = z;
        this.yvT.add(mVar);
        AppMethodBeat.o(112541);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, int i2, boolean z) {
        AppMethodBeat.i(112542);
        m mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.setIcon(i2);
        mVar.xeS = z;
        this.yvT.add(mVar);
        AppMethodBeat.o(112542);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(112543);
        m mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.mKB = charSequence2;
        mVar.setIcon(0);
        this.yvT.add(mVar);
        AppMethodBeat.o(112543);
        return mVar;
    }

    public final MenuItem hi(int i, int i2) {
        AppMethodBeat.i(112544);
        m mVar = new m(this.mContext, i, 0);
        mVar.setTitle(i2);
        this.yvT.add(mVar);
        AppMethodBeat.o(112544);
        return mVar;
    }

    public final MenuItem e(int i, CharSequence charSequence) {
        AppMethodBeat.i(112545);
        m mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        this.yvT.add(mVar);
        AppMethodBeat.o(112545);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, int i2) {
        AppMethodBeat.i(112546);
        m mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.setIcon(i2);
        this.yvT.add(mVar);
        AppMethodBeat.o(112546);
        return mVar;
    }

    public final MenuItem a(int i, int i2, CharSequence charSequence) {
        AppMethodBeat.i(112547);
        m mVar = new m(this.mContext, i, 0);
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 0);
        mVar.setTitle(spannableString);
        this.yvT.add(mVar);
        AppMethodBeat.o(112547);
        return mVar;
    }

    public final MenuItem i(MenuItem menuItem) {
        AppMethodBeat.i(112548);
        if (menuItem != null) {
            this.yvT.add(menuItem);
        }
        AppMethodBeat.o(112548);
        return null;
    }

    public final SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    public final void removeItem(int i) {
        AppMethodBeat.i(112549);
        ArrayList arrayList = new ArrayList();
        for (MenuItem menuItem : this.yvT) {
            if (menuItem.getItemId() == i) {
                arrayList.add(menuItem);
            }
        }
        this.yvT.removeAll(arrayList);
        AppMethodBeat.o(112549);
    }

    public final void removeGroup(int i) {
    }

    public final void clear() {
        AppMethodBeat.i(112550);
        for (MenuItem menuItem : this.yvT) {
            ((m) menuItem).yvW = null;
            ((m) menuItem).setOnMenuItemClickListener(null);
        }
        this.yvT.clear();
        this.abz = null;
        AppMethodBeat.o(112550);
    }

    public final void setGroupCheckable(int i, boolean z, boolean z2) {
    }

    public final void setGroupVisible(int i, boolean z) {
    }

    public final void setGroupEnabled(int i, boolean z) {
    }

    public final boolean hasVisibleItems() {
        return false;
    }

    public final MenuItem findItem(int i) {
        AppMethodBeat.i(112551);
        for (MenuItem menuItem : this.yvT) {
            if (menuItem.getItemId() == i) {
                AppMethodBeat.o(112551);
                return menuItem;
            }
        }
        AppMethodBeat.o(112551);
        return null;
    }

    public final int size() {
        AppMethodBeat.i(112552);
        if (this.yvT == null) {
            AppMethodBeat.o(112552);
            return 0;
        }
        int size = this.yvT.size();
        AppMethodBeat.o(112552);
        return size;
    }

    public final MenuItem getItem(int i) {
        AppMethodBeat.i(112553);
        MenuItem menuItem = (MenuItem) this.yvT.get(i);
        AppMethodBeat.o(112553);
        return menuItem;
    }

    public final void close() {
    }

    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return false;
    }

    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    public final boolean performIdentifierAction(int i, int i2) {
        return false;
    }

    public final void setQwertyMode(boolean z) {
    }

    public final ContextMenu setHeaderTitle(int i) {
        AppMethodBeat.i(112554);
        if (i > 0) {
            ContextMenu headerTitle = setHeaderTitle(this.mContext.getString(i));
            AppMethodBeat.o(112554);
            return headerTitle;
        }
        AppMethodBeat.o(112554);
        return this;
    }

    public final ContextMenu setHeaderTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.abz = charSequence;
        }
        return this;
    }

    public final ContextMenu setHeaderIcon(int i) {
        return this;
    }

    public final ContextMenu setHeaderIcon(Drawable drawable) {
        return this;
    }

    public final ContextMenu setHeaderView(View view) {
        return this;
    }

    public final void clearHeader() {
    }
}
