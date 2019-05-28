package com.tencent.p177mm.p612ui.base;

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

/* renamed from: com.tencent.mm.ui.base.l */
public final class C44273l implements ContextMenu {
    public CharSequence abz;
    private Context mContext;
    public List<MenuItem> yvT = new ArrayList();

    public C44273l(Context context) {
        AppMethodBeat.m2504i(112533);
        this.mContext = context;
        AppMethodBeat.m2505o(112533);
    }

    public final boolean dzR() {
        AppMethodBeat.m2504i(112534);
        if (this.yvT.size() == 0) {
            AppMethodBeat.m2505o(112534);
            return true;
        }
        AppMethodBeat.m2505o(112534);
        return false;
    }

    public final MenuItem add(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(112535);
        C44274m c44274m = new C44274m(this.mContext, i2, i);
        c44274m.setTitle(i4);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112535);
        return c44274m;
    }

    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        AppMethodBeat.m2504i(112536);
        C44274m c44274m = new C44274m(this.mContext, i2, i);
        c44274m.setTitle(charSequence);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112536);
        return c44274m;
    }

    public final MenuItem add(int i) {
        AppMethodBeat.m2504i(112537);
        C44274m c44274m = new C44274m(this.mContext, 0, 0);
        c44274m.setTitle(i);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112537);
        return c44274m;
    }

    public final MenuItem add(CharSequence charSequence) {
        AppMethodBeat.m2504i(112538);
        C44274m c44274m = new C44274m(this.mContext, 0, 0);
        c44274m.setTitle(charSequence);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112538);
        return c44274m;
    }

    /* renamed from: ax */
    public final MenuItem mo70063ax(int i, int i2, int i3) {
        AppMethodBeat.m2504i(112539);
        C44274m c44274m = new C44274m(this.mContext, i, 0);
        c44274m.setTitle(i2);
        c44274m.setIcon(i3);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112539);
        return c44274m;
    }

    /* renamed from: a */
    public final MenuItem mo70051a(int i, CharSequence charSequence, Drawable drawable) {
        AppMethodBeat.m2504i(112540);
        C44274m c44274m = new C44274m(this.mContext, i, 0);
        c44274m.setTitle(charSequence);
        c44274m.setIcon(drawable);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112540);
        return c44274m;
    }

    /* renamed from: a */
    public final MenuItem mo70053a(int i, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z) {
        AppMethodBeat.m2504i(112541);
        C44274m c44274m = new C44274m(this.mContext, i, 0);
        c44274m.setTitle(charSequence);
        c44274m.mKB = charSequence2;
        c44274m.setIcon(drawable);
        c44274m.xeS = z;
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112541);
        return c44274m;
    }

    /* renamed from: a */
    public final MenuItem mo70050a(int i, CharSequence charSequence, int i2, boolean z) {
        AppMethodBeat.m2504i(112542);
        C44274m c44274m = new C44274m(this.mContext, i, 0);
        c44274m.setTitle(charSequence);
        c44274m.setIcon(i2);
        c44274m.xeS = z;
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112542);
        return c44274m;
    }

    /* renamed from: a */
    public final MenuItem mo70052a(int i, CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.m2504i(112543);
        C44274m c44274m = new C44274m(this.mContext, i, 0);
        c44274m.setTitle(charSequence);
        c44274m.mKB = charSequence2;
        c44274m.setIcon(0);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112543);
        return c44274m;
    }

    /* renamed from: hi */
    public final MenuItem mo70072hi(int i, int i2) {
        AppMethodBeat.m2504i(112544);
        C44274m c44274m = new C44274m(this.mContext, i, 0);
        c44274m.setTitle(i2);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112544);
        return c44274m;
    }

    /* renamed from: e */
    public final MenuItem mo70068e(int i, CharSequence charSequence) {
        AppMethodBeat.m2504i(112545);
        C44274m c44274m = new C44274m(this.mContext, i, 0);
        c44274m.setTitle(charSequence);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112545);
        return c44274m;
    }

    /* renamed from: a */
    public final MenuItem mo70049a(int i, CharSequence charSequence, int i2) {
        AppMethodBeat.m2504i(112546);
        C44274m c44274m = new C44274m(this.mContext, i, 0);
        c44274m.setTitle(charSequence);
        c44274m.setIcon(i2);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112546);
        return c44274m;
    }

    /* renamed from: a */
    public final MenuItem mo70048a(int i, int i2, CharSequence charSequence) {
        AppMethodBeat.m2504i(112547);
        C44274m c44274m = new C44274m(this.mContext, i, 0);
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 0);
        c44274m.setTitle(spannableString);
        this.yvT.add(c44274m);
        AppMethodBeat.m2505o(112547);
        return c44274m;
    }

    /* renamed from: i */
    public final MenuItem mo70073i(MenuItem menuItem) {
        AppMethodBeat.m2504i(112548);
        if (menuItem != null) {
            this.yvT.add(menuItem);
        }
        AppMethodBeat.m2505o(112548);
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
        AppMethodBeat.m2504i(112549);
        ArrayList arrayList = new ArrayList();
        for (MenuItem menuItem : this.yvT) {
            if (menuItem.getItemId() == i) {
                arrayList.add(menuItem);
            }
        }
        this.yvT.removeAll(arrayList);
        AppMethodBeat.m2505o(112549);
    }

    public final void removeGroup(int i) {
    }

    public final void clear() {
        AppMethodBeat.m2504i(112550);
        for (MenuItem menuItem : this.yvT) {
            ((C44274m) menuItem).yvW = null;
            ((C44274m) menuItem).setOnMenuItemClickListener(null);
        }
        this.yvT.clear();
        this.abz = null;
        AppMethodBeat.m2505o(112550);
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
        AppMethodBeat.m2504i(112551);
        for (MenuItem menuItem : this.yvT) {
            if (menuItem.getItemId() == i) {
                AppMethodBeat.m2505o(112551);
                return menuItem;
            }
        }
        AppMethodBeat.m2505o(112551);
        return null;
    }

    public final int size() {
        AppMethodBeat.m2504i(112552);
        if (this.yvT == null) {
            AppMethodBeat.m2505o(112552);
            return 0;
        }
        int size = this.yvT.size();
        AppMethodBeat.m2505o(112552);
        return size;
    }

    public final MenuItem getItem(int i) {
        AppMethodBeat.m2504i(112553);
        MenuItem menuItem = (MenuItem) this.yvT.get(i);
        AppMethodBeat.m2505o(112553);
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
        AppMethodBeat.m2504i(112554);
        if (i > 0) {
            ContextMenu headerTitle = setHeaderTitle(this.mContext.getString(i));
            AppMethodBeat.m2505o(112554);
            return headerTitle;
        }
        AppMethodBeat.m2505o(112554);
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
