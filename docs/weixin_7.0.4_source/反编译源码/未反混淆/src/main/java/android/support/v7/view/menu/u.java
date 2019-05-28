package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.h.a;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class u extends h implements SubMenu {
    public h acs;
    private j act;

    public u(Context context, h hVar, j jVar) {
        super(context);
        this.acs = hVar;
        this.act = jVar;
    }

    public void setQwertyMode(boolean z) {
        this.acs.setQwertyMode(z);
    }

    public final boolean gv() {
        return this.acs.gv();
    }

    public final boolean gw() {
        return this.acs.gw();
    }

    public MenuItem getItem() {
        return this.act;
    }

    public final void a(a aVar) {
        this.acs.a(aVar);
    }

    public final h gE() {
        return this.acs.gE();
    }

    /* Access modifiers changed, original: final */
    public final boolean d(h hVar, MenuItem menuItem) {
        return super.d(hVar, menuItem) || this.acs.d(hVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.act.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.act.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(0, null, 0, drawable, null);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.a(0, null, i, null, null);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(0, charSequence, 0, null, null);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.a(i, null, 0, null, null);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(0, null, 0, null, view);
        return this;
    }

    public final boolean g(j jVar) {
        return this.acs.g(jVar);
    }

    public final boolean h(j jVar) {
        return this.acs.h(jVar);
    }

    public final String gu() {
        int itemId = this.act != null ? this.act.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.gu() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + itemId;
    }
}
