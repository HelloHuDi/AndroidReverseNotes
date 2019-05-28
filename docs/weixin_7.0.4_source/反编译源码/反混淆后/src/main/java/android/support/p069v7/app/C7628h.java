package android.support.p069v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.p069v7.app.C7590g.C7453a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

/* renamed from: android.support.v7.app.h */
class C7628h extends C7590g {
    /* renamed from: Vd */
    private final UiModeManager f2130Vd;

    /* renamed from: android.support.v7.app.h$a */
    class C7591a extends C7453a {
        C7591a(Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (C7628h.this.f2126UV) {
                switch (i) {
                    case 0:
                        return mo16367a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }

    C7628h(Context context, Window window, C0575c c0575c) {
        super(context, window, c0575c);
        this.f2130Vd = (UiModeManager) context.getSystemService("uimode");
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public Callback mo14031a(Callback callback) {
        return new C7591a(callback);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bg */
    public final int mo16927bg(int i) {
        if (i == 0 && this.f2130Vd.getNightMode() == 0) {
            return -1;
        }
        return super.mo16927bg(i);
    }
}
