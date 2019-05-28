package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bd;
import android.support.v7.widget.x;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window.Callback;
import com.tencent.mm.R;
import java.util.ArrayList;

final class l extends ActionBar {
    x Wk;
    boolean Wl;
    Callback Wm;
    private boolean Wn;
    private boolean Wo;
    private ArrayList<Object> Wp = new ArrayList();
    private final Runnable Wq = new Runnable() {
        public final void run() {
            l lVar = l.this;
            Menu menu = lVar.getMenu();
            h hVar = menu instanceof h ? (h) menu : null;
            if (hVar != null) {
                hVar.gx();
            }
            try {
                menu.clear();
                if (!(lVar.Wm.onCreatePanelMenu(0, menu) && lVar.Wm.onPreparePanel(0, null, menu))) {
                    menu.clear();
                }
                if (hVar != null) {
                    hVar.gy();
                }
            } catch (Throwable th) {
                if (hVar != null) {
                    hVar.gy();
                }
            }
        }
    };
    private final android.support.v7.widget.Toolbar.b Wr = new android.support.v7.widget.Toolbar.b() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return l.this.Wm.onMenuItemSelected(0, menuItem);
        }
    };

    final class a implements android.support.v7.view.menu.o.a {
        private boolean Vt;

        a() {
        }

        public final boolean d(h hVar) {
            if (l.this.Wm == null) {
                return false;
            }
            l.this.Wm.onMenuOpened(108, hVar);
            return true;
        }

        public final void a(h hVar, boolean z) {
            if (!this.Vt) {
                this.Vt = true;
                l.this.Wk.dismissPopupMenus();
                if (l.this.Wm != null) {
                    l.this.Wm.onPanelClosed(108, hVar);
                }
                this.Vt = false;
            }
        }
    }

    final class b implements android.support.v7.view.menu.h.a {
        b() {
        }

        public final boolean a(h hVar, MenuItem menuItem) {
            return false;
        }

        public final void b(h hVar) {
            if (l.this.Wm == null) {
                return;
            }
            if (l.this.Wk.isOverflowMenuShowing()) {
                l.this.Wm.onPanelClosed(108, hVar);
            } else if (l.this.Wm.onPreparePanel(0, null, hVar)) {
                l.this.Wm.onMenuOpened(108, hVar);
            }
        }
    }

    class c extends i {
        public c(Callback callback) {
            super(callback);
        }

        public final boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !l.this.Wl) {
                l.this.Wk.gX();
                l.this.Wl = true;
            }
            return onPreparePanel;
        }

        public final View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(l.this.Wk.getContext());
            }
            return super.onCreatePanelView(i);
        }
    }

    l(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.Wk = new bd(toolbar, false);
        this.Wm = new c(callback);
        this.Wk.setWindowCallback(this.Wm);
        toolbar.setOnMenuItemClickListener(this.Wr);
        this.Wk.setWindowTitle(charSequence);
    }

    public final void setCustomView(View view) {
        LayoutParams layoutParams = new LayoutParams();
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.Wk.setCustomView(view);
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.Wk.getContext()).inflate(i, this.Wk.hW(), false));
    }

    public final void fa() {
        this.Wk.setIcon((int) R.drawable.a8g);
    }

    public final void setLogo(Drawable drawable) {
        this.Wk.setLogo(drawable);
    }

    public final void setElevation(float f) {
        s.h(this.Wk.hW(), f);
    }

    public final Context getThemedContext() {
        return this.Wk.getContext();
    }

    public final void K(boolean z) {
    }

    public final void setHomeActionContentDescription(int i) {
        this.Wk.setNavigationContentDescription(i);
    }

    public final void L(boolean z) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void setWindowTitle(CharSequence charSequence) {
        this.Wk.setWindowTitle(charSequence);
    }

    @SuppressLint({"WrongConstant"})
    public final void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    private void setDisplayOptions(int i, int i2) {
        this.Wk.setDisplayOptions((this.Wk.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
    }

    public final void fb() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public final void fc() {
        setDisplayOptions(0, 8);
    }

    public final void fd() {
        setDisplayOptions(16, 16);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.Wk.setBackgroundDrawable(drawable);
    }

    public final View getCustomView() {
        return this.Wk.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.Wk.getTitle();
    }

    public final int getDisplayOptions() {
        return this.Wk.getDisplayOptions();
    }

    public final int getHeight() {
        return this.Wk.getHeight();
    }

    public final void show() {
        this.Wk.setVisibility(0);
    }

    public final void hide() {
        this.Wk.setVisibility(8);
    }

    public final boolean isShowing() {
        return this.Wk.getVisibility() == 0;
    }

    public final boolean ff() {
        return this.Wk.showOverflowMenu();
    }

    public final boolean fg() {
        return this.Wk.hideOverflowMenu();
    }

    public final boolean fh() {
        this.Wk.hW().removeCallbacks(this.Wq);
        s.b(this.Wk.hW(), this.Wq);
        return true;
    }

    public final boolean collapseActionView() {
        if (!this.Wk.hasExpandedActionView()) {
            return false;
        }
        this.Wk.collapseActionView();
        return true;
    }

    public final boolean b(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            ff();
        }
        return true;
    }

    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu == null) {
            return false;
        }
        boolean z;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
            z = true;
        } else {
            z = false;
        }
        menu.setQwertyMode(z);
        return menu.performShortcut(i, keyEvent, 0);
    }

    /* Access modifiers changed, original: final */
    public final void onDestroy() {
        this.Wk.hW().removeCallbacks(this.Wq);
    }

    public final void M(boolean z) {
        if (z != this.Wo) {
            this.Wo = z;
            int size = this.Wp.size();
            for (int i = 0; i < size; i++) {
                this.Wp.get(i);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final Menu getMenu() {
        if (!this.Wn) {
            this.Wk.a(new a(), new b());
            this.Wn = true;
        }
        return this.Wk.getMenu();
    }
}
