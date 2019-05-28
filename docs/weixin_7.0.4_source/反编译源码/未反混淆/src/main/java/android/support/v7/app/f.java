package android.support.v7.app;

import android.content.Context;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

final class f extends h {

    class a extends a {
        a(Callback callback) {
            super(callback);
        }

        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState bh = f.this.bh(0);
            if (bh == null || bh.VK == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, bh.VK, i);
            }
        }
    }

    f(Context context, Window window, c cVar) {
        super(context, window, cVar);
    }

    /* Access modifiers changed, original: final */
    public final Callback a(Callback callback) {
        return new a(callback);
    }
}
