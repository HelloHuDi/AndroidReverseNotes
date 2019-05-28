package android.support.p069v7.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* renamed from: android.support.v7.widget.j */
final class C0720j {
    /* renamed from: a */
    static InputConnection m1620a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                if (parent instanceof C0710bl) {
                    editorInfo.hintText = ((C0710bl) parent).getHint();
                    break;
                }
            }
        }
        return inputConnection;
    }
}
