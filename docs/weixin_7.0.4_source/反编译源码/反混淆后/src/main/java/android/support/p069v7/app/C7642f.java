package android.support.p069v7.app;

import android.content.Context;
import android.support.p069v7.app.AppCompatDelegateImplV9.PanelFeatureState;
import android.support.p069v7.app.C7628h.C7591a;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

/* renamed from: android.support.v7.app.f */
final class C7642f extends C7628h {

    /* renamed from: android.support.v7.app.f$a */
    class C7627a extends C7591a {
        C7627a(Callback callback) {
            super(callback);
        }

        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState bh = C7642f.this.mo16355bh(0);
            if (bh == null || bh.f853VK == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, bh.f853VK, i);
            }
        }
    }

    C7642f(Context context, Window window, C0575c c0575c) {
        super(context, window, c0575c);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final Callback mo14031a(Callback callback) {
        return new C7627a(callback);
    }
}
