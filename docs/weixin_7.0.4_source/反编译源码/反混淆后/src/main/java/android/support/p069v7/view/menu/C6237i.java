package android.support.p069v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.p069v7.app.C7452b;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;

/* renamed from: android.support.v7.view.menu.i */
final class C6237i implements OnClickListener, OnDismissListener, OnKeyListener, C0627a {
    private C0627a aaL;
    C7452b abL;
    C6235f abM;
    /* renamed from: lo */
    C6236h f1910lo;

    public C6237i(C6236h c6236h) {
        this.f1910lo = c6236h;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.abL.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.abL.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f1910lo.mo14110U(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1910lo.performShortcut(i, keyEvent, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.abM.mo1599a(this.f1910lo, true);
    }

    /* renamed from: a */
    public final void mo1596a(C6236h c6236h, boolean z) {
        if ((z || c6236h == this.f1910lo) && this.abL != null) {
            this.abL.dismiss();
        }
        if (this.aaL != null) {
            this.aaL.mo1596a(c6236h, z);
        }
    }

    /* renamed from: d */
    public final boolean mo1597d(C6236h c6236h) {
        if (this.aaL != null) {
            return this.aaL.mo1597d(c6236h);
        }
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1910lo.mo14116a((C6239j) this.abM.getAdapter().getItem(i), null, 0);
    }
}
