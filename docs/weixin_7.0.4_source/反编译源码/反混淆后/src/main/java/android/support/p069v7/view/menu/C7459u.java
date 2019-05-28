package android.support.p069v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: android.support.v7.view.menu.u */
public class C7459u extends C6236h implements SubMenu {
    public C6236h acs;
    private C6239j act;

    public C7459u(Context context, C6236h c6236h, C6239j c6239j) {
        super(context);
        this.acs = c6236h;
        this.act = c6239j;
    }

    public void setQwertyMode(boolean z) {
        this.acs.setQwertyMode(z);
    }

    /* renamed from: gv */
    public final boolean mo14144gv() {
        return this.acs.mo14144gv();
    }

    /* renamed from: gw */
    public final boolean mo14145gw() {
        return this.acs.mo14145gw();
    }

    public MenuItem getItem() {
        return this.act;
    }

    /* renamed from: a */
    public final void mo14113a(C0623a c0623a) {
        this.acs.mo14113a(c0623a);
    }

    /* renamed from: gE */
    public final C6236h mo14141gE() {
        return this.acs.mo14141gE();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final boolean mo14132d(C6236h c6236h, MenuItem menuItem) {
        return super.mo14132d(c6236h, menuItem) || this.acs.mo14132d(c6236h, menuItem);
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
        super.mo14112a(0, null, 0, drawable, null);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.mo14112a(0, null, i, null, null);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.mo14112a(0, charSequence, 0, null, null);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.mo14112a(i, null, 0, null, null);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.mo14112a(0, null, 0, null, view);
        return this;
    }

    /* renamed from: g */
    public final boolean mo14136g(C6239j c6239j) {
        return this.acs.mo14136g(c6239j);
    }

    /* renamed from: h */
    public final boolean mo14149h(C6239j c6239j) {
        return this.acs.mo14149h(c6239j);
    }

    /* renamed from: gu */
    public final String mo14143gu() {
        int itemId = this.act != null ? this.act.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo14143gu() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + itemId;
    }
}
