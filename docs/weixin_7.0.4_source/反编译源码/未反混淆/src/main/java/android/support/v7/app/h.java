package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class h extends g {
    private final UiModeManager Vd;

    class a extends a {
        a(Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (h.this.UV) {
                switch (i) {
                    case 0:
                        return a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }

    h(Context context, Window window, c cVar) {
        super(context, window, cVar);
        this.Vd = (UiModeManager) context.getSystemService("uimode");
    }

    /* Access modifiers changed, original: 0000 */
    public Callback a(Callback callback) {
        return new a(callback);
    }

    /* Access modifiers changed, original: final */
    public final int bg(int i) {
        if (i == 0 && this.Vd.getNightMode() == 0) {
            return -1;
        }
        return super.bg(i);
    }
}
