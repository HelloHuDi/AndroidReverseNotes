package android.support.p069v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.C6214a.C0573a;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.C0604b.C0603a;
import android.support.p069v7.view.C0611g;
import android.support.p069v7.view.C0614i;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.widget.C0699bc;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: android.support.v7.app.e */
abstract class C6217e extends C0576d {
    /* renamed from: UD */
    private static boolean f1812UD = true;
    /* renamed from: UE */
    private static final boolean f1813UE;
    /* renamed from: UF */
    private static final int[] f1814UF = new int[]{16842836};
    /* renamed from: IT */
    private CharSequence f1815IT;
    /* renamed from: Ti */
    final Window f1816Ti;
    /* renamed from: UG */
    final Callback f1817UG = this.f1816Ti.getCallback();
    /* renamed from: UH */
    final Callback f1818UH;
    /* renamed from: UI */
    final C0575c f1819UI;
    /* renamed from: UJ */
    boolean f1820UJ;
    /* renamed from: UK */
    boolean f1821UK;
    /* renamed from: UL */
    boolean f1822UL;
    /* renamed from: UM */
    boolean f1823UM;
    /* renamed from: UN */
    boolean f1824UN;
    /* renamed from: UO */
    private boolean f1825UO;
    /* renamed from: UP */
    boolean f1826UP;
    ActionBar mActionBar;
    final Context mContext;
    /* renamed from: mY */
    MenuInflater f1827mY;

    /* renamed from: android.support.v7.app.e$a */
    class C6215a implements C0573a {
        C6215a() {
        }

        /* renamed from: bc */
        public final void mo1392bc(int i) {
            ActionBar supportActionBar = C6217e.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* renamed from: android.support.v7.app.e$b */
    class C6216b extends C0614i {
        C6216b(Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return C6217e.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || C6217e.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C6236h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C6236h c6236h;
            if (menu instanceof C6236h) {
                c6236h = (C6236h) menu;
            } else {
                c6236h = null;
            }
            if (i == 0 && c6236h == null) {
                return false;
            }
            if (c6236h != null) {
                c6236h.abK = true;
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (c6236h == null) {
                return onPreparePanel;
            }
            c6236h.abK = false;
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            C6217e.this.mo14034be(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            C6217e.this.mo14033bd(i);
        }
    }

    /* renamed from: b */
    public abstract C0604b mo14032b(C0603a c0603a);

    /* renamed from: bd */
    public abstract void mo14033bd(int i);

    /* renamed from: be */
    public abstract boolean mo14034be(int i);

    public abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    /* renamed from: fn */
    public abstract void mo14036fn();

    /* renamed from: k */
    public abstract void mo14039k(CharSequence charSequence);

    public abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    static {
        boolean z = VERSION.SDK_INT < 21;
        f1813UE = z;
        if (z && !f1812UD) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                public final void uncaughtException(Thread thread, Throwable th) {
                    Object obj = null;
                    if (th instanceof NotFoundException) {
                        String message = th.getMessage();
                        if (message != null && (message.contains("drawable") || message.contains("Drawable"))) {
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        NotFoundException notFoundException = new NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    C6217e(Context context, Window window, C0575c c0575c) {
        this.mContext = context;
        this.f1816Ti = window;
        this.f1819UI = c0575c;
        if (this.f1817UG instanceof C6216b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1818UH = mo14031a(this.f1817UG);
        this.f1816Ti.setCallback(this.f1818UH);
        C0699bc a = C0699bc.m1554a(context, null, f1814UF);
        Drawable cW = a.mo2029cW(0);
        if (cW != null) {
            this.f1816Ti.setBackgroundDrawable(cW);
        }
        a.atG.recycle();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public Callback mo14031a(Callback callback) {
        return new C6216b(callback);
    }

    public final ActionBar getSupportActionBar() {
        mo14036fn();
        return this.mActionBar;
    }

    public final MenuInflater getMenuInflater() {
        if (this.f1827mY == null) {
            mo14036fn();
            this.f1827mY = new C0611g(this.mActionBar != null ? this.mActionBar.getThemedContext() : this.mContext);
        }
        return this.f1827mY;
    }

    public final C0573a getDrawerToggleDelegate() {
        return new C6215a();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fo */
    public final Context mo14037fo() {
        Context context = null;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        }
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    public void onStart() {
        this.f1825UO = true;
    }

    public void onStop() {
        this.f1825UO = false;
    }

    public void onDestroy() {
        this.f1826UP = true;
    }

    /* renamed from: fl */
    public boolean mo1401fl() {
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f1815IT = charSequence;
        mo14039k(charSequence);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* Access modifiers changed, original: final */
    public final CharSequence getTitle() {
        if (this.f1817UG instanceof Activity) {
            return ((Activity) this.f1817UG).getTitle();
        }
        return this.f1815IT;
    }
}
