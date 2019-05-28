package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C23184e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.t */
public abstract class C23185t<V, C extends C46458g<V>> {
    /* renamed from: a */
    public abstract ArrayList<Object> mo38809a(Spannable spannable, C23184e c23184e, C44014s c44014s);

    /* renamed from: a */
    public abstract void mo38810a(WXRTEditText wXRTEditText, V v);

    public abstract int dfy();

    /* renamed from: r */
    public abstract C23184e mo38812r(WXRTEditText wXRTEditText);

    /* renamed from: s */
    public final boolean mo38813s(WXRTEditText wXRTEditText) {
        return !mo38809a(wXRTEditText.getText(), mo38812r(wXRTEditText), C44014s.uSx).isEmpty();
    }

    /* renamed from: f */
    protected static boolean m35565f(int i, int... iArr) {
        for (int i2 = 0; i2 < 2; i2++) {
            int i3 = iArr[i2];
            if ((i & i3) == i3) {
                return true;
            }
        }
        return false;
    }
}
