package android.support.p069v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.app.ActionBar.LayoutParams;
import android.support.p069v7.view.C0614i;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.support.p069v7.widget.C0728x;
import android.support.p069v7.widget.C6256bd;
import android.support.p069v7.widget.Toolbar;
import android.support.p069v7.widget.Toolbar.C0669b;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window.Callback;
import com.tencent.p177mm.C25738R;
import java.util.ArrayList;

/* renamed from: android.support.v7.app.l */
final class C6223l extends ActionBar {
    /* renamed from: Wk */
    C0728x f1833Wk;
    /* renamed from: Wl */
    boolean f1834Wl;
    /* renamed from: Wm */
    Callback f1835Wm;
    /* renamed from: Wn */
    private boolean f1836Wn;
    /* renamed from: Wo */
    private boolean f1837Wo;
    /* renamed from: Wp */
    private ArrayList<Object> f1838Wp = new ArrayList();
    /* renamed from: Wq */
    private final Runnable f1839Wq = new C05831();
    /* renamed from: Wr */
    private final C0669b f1840Wr = new C62192();

    /* renamed from: android.support.v7.app.l$1 */
    class C05831 implements Runnable {
        C05831() {
        }

        public final void run() {
            C6223l c6223l = C6223l.this;
            Menu menu = c6223l.getMenu();
            C6236h c6236h = menu instanceof C6236h ? (C6236h) menu : null;
            if (c6236h != null) {
                c6236h.mo14146gx();
            }
            try {
                menu.clear();
                if (!(c6223l.f1835Wm.onCreatePanelMenu(0, menu) && c6223l.f1835Wm.onPreparePanel(0, null, menu))) {
                    menu.clear();
                }
                if (c6236h != null) {
                    c6236h.mo14147gy();
                }
            } catch (Throwable th) {
                if (c6236h != null) {
                    c6236h.mo14147gy();
                }
            }
        }
    }

    /* renamed from: android.support.v7.app.l$2 */
    class C62192 implements C0669b {
        C62192() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return C6223l.this.f1835Wm.onMenuItemSelected(0, menuItem);
        }
    }

    /* renamed from: android.support.v7.app.l$a */
    final class C6220a implements C0627a {
        /* renamed from: Vt */
        private boolean f1829Vt;

        C6220a() {
        }

        /* renamed from: d */
        public final boolean mo1597d(C6236h c6236h) {
            if (C6223l.this.f1835Wm == null) {
                return false;
            }
            C6223l.this.f1835Wm.onMenuOpened(108, c6236h);
            return true;
        }

        /* renamed from: a */
        public final void mo1596a(C6236h c6236h, boolean z) {
            if (!this.f1829Vt) {
                this.f1829Vt = true;
                C6223l.this.f1833Wk.dismissPopupMenus();
                if (C6223l.this.f1835Wm != null) {
                    C6223l.this.f1835Wm.onPanelClosed(108, c6236h);
                }
                this.f1829Vt = false;
            }
        }
    }

    /* renamed from: android.support.v7.app.l$b */
    final class C6221b implements C0623a {
        C6221b() {
        }

        /* renamed from: a */
        public final boolean mo1584a(C6236h c6236h, MenuItem menuItem) {
            return false;
        }

        /* renamed from: b */
        public final void mo1585b(C6236h c6236h) {
            if (C6223l.this.f1835Wm == null) {
                return;
            }
            if (C6223l.this.f1833Wk.isOverflowMenuShowing()) {
                C6223l.this.f1835Wm.onPanelClosed(108, c6236h);
            } else if (C6223l.this.f1835Wm.onPreparePanel(0, null, c6236h)) {
                C6223l.this.f1835Wm.onMenuOpened(108, c6236h);
            }
        }
    }

    /* renamed from: android.support.v7.app.l$c */
    class C6222c extends C0614i {
        public C6222c(Callback callback) {
            super(callback);
        }

        public final boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !C6223l.this.f1834Wl) {
                C6223l.this.f1833Wk.mo2150gX();
                C6223l.this.f1834Wl = true;
            }
            return onPreparePanel;
        }

        public final View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(C6223l.this.f1833Wk.getContext());
            }
            return super.onCreatePanelView(i);
        }
    }

    C6223l(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f1833Wk = new C6256bd(toolbar, false);
        this.f1835Wm = new C6222c(callback);
        this.f1833Wk.setWindowCallback(this.f1835Wm);
        toolbar.setOnMenuItemClickListener(this.f1840Wr);
        this.f1833Wk.setWindowTitle(charSequence);
    }

    public final void setCustomView(View view) {
        LayoutParams layoutParams = new LayoutParams();
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f1833Wk.setCustomView(view);
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.f1833Wk.getContext()).inflate(i, this.f1833Wk.mo2159hW(), false));
    }

    /* renamed from: fa */
    public final void mo1337fa() {
        this.f1833Wk.setIcon((int) C25738R.drawable.a8g);
    }

    public final void setLogo(Drawable drawable) {
        this.f1833Wk.setLogo(drawable);
    }

    public final void setElevation(float f) {
        C0477s.m945h(this.f1833Wk.mo2159hW(), f);
    }

    public final Context getThemedContext() {
        return this.f1833Wk.getContext();
    }

    /* renamed from: K */
    public final void mo1331K(boolean z) {
    }

    public final void setHomeActionContentDescription(int i) {
        this.f1833Wk.setNavigationContentDescription(i);
    }

    /* renamed from: L */
    public final void mo1332L(boolean z) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void setWindowTitle(CharSequence charSequence) {
        this.f1833Wk.setWindowTitle(charSequence);
    }

    @SuppressLint({"WrongConstant"})
    public final void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    private void setDisplayOptions(int i, int i2) {
        this.f1833Wk.setDisplayOptions((this.f1833Wk.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
    }

    /* renamed from: fb */
    public final void mo1338fb() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    /* renamed from: fc */
    public final void mo1339fc() {
        setDisplayOptions(0, 8);
    }

    /* renamed from: fd */
    public final void mo1340fd() {
        setDisplayOptions(16, 16);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.f1833Wk.setBackgroundDrawable(drawable);
    }

    public final View getCustomView() {
        return this.f1833Wk.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.f1833Wk.getTitle();
    }

    public final int getDisplayOptions() {
        return this.f1833Wk.getDisplayOptions();
    }

    public final int getHeight() {
        return this.f1833Wk.getHeight();
    }

    public final void show() {
        this.f1833Wk.setVisibility(0);
    }

    public final void hide() {
        this.f1833Wk.setVisibility(8);
    }

    public final boolean isShowing() {
        return this.f1833Wk.getVisibility() == 0;
    }

    /* renamed from: ff */
    public final boolean mo1342ff() {
        return this.f1833Wk.showOverflowMenu();
    }

    /* renamed from: fg */
    public final boolean mo1343fg() {
        return this.f1833Wk.hideOverflowMenu();
    }

    /* renamed from: fh */
    public final boolean mo1344fh() {
        this.f1833Wk.mo2159hW().removeCallbacks(this.f1839Wq);
        C0477s.m934b(this.f1833Wk.mo2159hW(), this.f1839Wq);
        return true;
    }

    public final boolean collapseActionView() {
        if (!this.f1833Wk.hasExpandedActionView()) {
            return false;
        }
        this.f1833Wk.collapseActionView();
        return true;
    }

    /* renamed from: b */
    public final boolean mo1335b(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo1342ff();
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
        this.f1833Wk.mo2159hW().removeCallbacks(this.f1839Wq);
    }

    /* renamed from: M */
    public final void mo1333M(boolean z) {
        if (z != this.f1837Wo) {
            this.f1837Wo = z;
            int size = this.f1838Wp.size();
            for (int i = 0; i < size; i++) {
                this.f1838Wp.get(i);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final Menu getMenu() {
        if (!this.f1836Wn) {
            this.f1833Wk.mo2142a(new C6220a(), new C6221b());
            this.f1836Wn = true;
        }
        return this.f1833Wk.getMenu();
    }
}
