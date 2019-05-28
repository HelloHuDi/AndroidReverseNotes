package android.support.p069v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p060b.p061a.C6194c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.v */
final class C7593v extends C7457r implements SubMenu {
    C7593v(Context context, C6194c c6194c) {
        super(context, c6194c);
    }

    public final SubMenu setHeaderTitle(int i) {
        ((C6194c) this.aar).setHeaderTitle(i);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        ((C6194c) this.aar).setHeaderTitle(charSequence);
        return this;
    }

    public final SubMenu setHeaderIcon(int i) {
        ((C6194c) this.aar).setHeaderIcon(i);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        ((C6194c) this.aar).setHeaderIcon(drawable);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        ((C6194c) this.aar).setHeaderView(view);
        return this;
    }

    public final void clearHeader() {
        ((C6194c) this.aar).clearHeader();
    }

    public final SubMenu setIcon(int i) {
        ((C6194c) this.aar).setIcon(i);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable) {
        ((C6194c) this.aar).setIcon(drawable);
        return this;
    }

    public final MenuItem getItem() {
        return mo14106e(((C6194c) this.aar).getItem());
    }
}
