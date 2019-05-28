package android.support.p057v4.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v4.view.b */
public abstract class C0455b {
    /* renamed from: LG */
    public C0452a f553LG;
    /* renamed from: LH */
    public C0453b f554LH;
    private final Context mContext;

    /* renamed from: android.support.v4.view.b$a */
    public interface C0452a {
        /* renamed from: F */
        void mo1041F(boolean z);
    }

    /* renamed from: android.support.v4.view.b$b */
    public interface C0453b {
        /* renamed from: en */
        void mo1042en();
    }

    public abstract View onCreateActionView();

    public C0455b(Context context) {
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

    /* renamed from: E */
    public final void mo1044E(boolean z) {
        if (this.f553LG != null) {
            this.f553LG.mo1041F(z);
        }
    }

    /* renamed from: a */
    public void mo1045a(C0453b c0453b) {
        if (this.f554LH != null) {
            new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?");
        }
        this.f554LH = c0453b;
    }
}
