package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.widget.bc;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.Thread.UncaughtExceptionHandler;

abstract class e extends d {
    private static boolean UD = true;
    private static final boolean UE;
    private static final int[] UF = new int[]{16842836};
    private CharSequence IT;
    final Window Ti;
    final Callback UG = this.Ti.getCallback();
    final Callback UH;
    final c UI;
    boolean UJ;
    boolean UK;
    boolean UL;
    boolean UM;
    boolean UN;
    private boolean UO;
    boolean UP;
    ActionBar mActionBar;
    final Context mContext;
    MenuInflater mY;

    class a implements android.support.v7.app.a.a {
        a() {
        }

        public final void bc(int i) {
            ActionBar supportActionBar = e.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    class b extends i {
        b(Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return e.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || e.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            h hVar;
            if (menu instanceof h) {
                hVar = (h) menu;
            } else {
                hVar = null;
            }
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.abK = true;
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar == null) {
                return onPreparePanel;
            }
            hVar.abK = false;
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            e.this.be(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            e.this.bd(i);
        }
    }

    public abstract android.support.v7.view.b b(android.support.v7.view.b.a aVar);

    public abstract void bd(int i);

    public abstract boolean be(int i);

    public abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    public abstract void fn();

    public abstract void k(CharSequence charSequence);

    public abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    static {
        boolean z = VERSION.SDK_INT < 21;
        UE = z;
        if (z && !UD) {
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

    e(Context context, Window window, c cVar) {
        this.mContext = context;
        this.Ti = window;
        this.UI = cVar;
        if (this.UG instanceof b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.UH = a(this.UG);
        this.Ti.setCallback(this.UH);
        bc a = bc.a(context, null, UF);
        Drawable cW = a.cW(0);
        if (cW != null) {
            this.Ti.setBackgroundDrawable(cW);
        }
        a.atG.recycle();
    }

    /* Access modifiers changed, original: 0000 */
    public Callback a(Callback callback) {
        return new b(callback);
    }

    public final ActionBar getSupportActionBar() {
        fn();
        return this.mActionBar;
    }

    public final MenuInflater getMenuInflater() {
        if (this.mY == null) {
            fn();
            this.mY = new g(this.mActionBar != null ? this.mActionBar.getThemedContext() : this.mContext);
        }
        return this.mY;
    }

    public final android.support.v7.app.a.a getDrawerToggleDelegate() {
        return new a();
    }

    /* Access modifiers changed, original: final */
    public final Context fo() {
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
        this.UO = true;
    }

    public void onStop() {
        this.UO = false;
    }

    public void onDestroy() {
        this.UP = true;
    }

    public boolean fl() {
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.IT = charSequence;
        k(charSequence);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* Access modifiers changed, original: final */
    public final CharSequence getTitle() {
        if (this.UG instanceof Activity) {
            return ((Activity) this.UG).getTitle();
        }
        return this.IT;
    }
}
