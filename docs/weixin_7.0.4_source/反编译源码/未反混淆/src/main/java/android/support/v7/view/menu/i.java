package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.b;
import android.support.v7.view.menu.o.a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;

final class i implements OnClickListener, OnDismissListener, OnKeyListener, a {
    private a aaL;
    b abL;
    f abM;
    h lo;

    public i(h hVar) {
        this.lo = hVar;
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
                            this.lo.U(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.lo.performShortcut(i, keyEvent, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.abM.a(this.lo, true);
    }

    public final void a(h hVar, boolean z) {
        if ((z || hVar == this.lo) && this.abL != null) {
            this.abL.dismiss();
        }
        if (this.aaL != null) {
            this.aaL.a(hVar, z);
        }
    }

    public final boolean d(h hVar) {
        if (this.aaL != null) {
            return this.aaL.d(hVar);
        }
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lo.a((j) this.abM.getAdapter().getItem(i), null, 0);
    }
}
