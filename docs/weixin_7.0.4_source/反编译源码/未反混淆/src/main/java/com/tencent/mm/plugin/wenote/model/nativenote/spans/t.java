package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;

public abstract class t<V, C extends g<V>> {
    public abstract ArrayList<Object> a(Spannable spannable, e eVar, s sVar);

    public abstract void a(WXRTEditText wXRTEditText, V v);

    public abstract int dfy();

    public abstract e r(WXRTEditText wXRTEditText);

    public final boolean s(WXRTEditText wXRTEditText) {
        return !a(wXRTEditText.getText(), r(wXRTEditText), s.uSx).isEmpty();
    }

    protected static boolean f(int i, int... iArr) {
        for (int i2 = 0; i2 < 2; i2++) {
            int i3 = iArr[i2];
            if ((i & i3) == i3) {
                return true;
            }
        }
        return false;
    }
}
