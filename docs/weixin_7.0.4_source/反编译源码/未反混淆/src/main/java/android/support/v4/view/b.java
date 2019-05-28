package android.support.v4.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {
    public a LG;
    public b LH;
    private final Context mContext;

    public interface a {
        void F(boolean z);
    }

    public interface b {
        void en();
    }

    public abstract View onCreateActionView();

    public b(Context context) {
        this.mContext = context;
    }

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public final void E(boolean z) {
        if (this.LG != null) {
            this.LG.F(z);
        }
    }

    public void a(b bVar) {
        if (this.LH != null) {
            new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?");
        }
        this.LH = bVar;
    }
}
