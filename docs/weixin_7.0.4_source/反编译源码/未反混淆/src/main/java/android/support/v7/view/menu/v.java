package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class v extends r implements SubMenu {
    v(Context context, c cVar) {
        super(context, cVar);
    }

    public final SubMenu setHeaderTitle(int i) {
        ((c) this.aar).setHeaderTitle(i);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        ((c) this.aar).setHeaderTitle(charSequence);
        return this;
    }

    public final SubMenu setHeaderIcon(int i) {
        ((c) this.aar).setHeaderIcon(i);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        ((c) this.aar).setHeaderIcon(drawable);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        ((c) this.aar).setHeaderView(view);
        return this;
    }

    public final void clearHeader() {
        ((c) this.aar).clearHeader();
    }

    public final SubMenu setIcon(int i) {
        ((c) this.aar).setIcon(i);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable) {
        ((c) this.aar).setIcon(drawable);
        return this;
    }

    public final MenuItem getItem() {
        return e(((c) this.aar).getItem());
    }
}
