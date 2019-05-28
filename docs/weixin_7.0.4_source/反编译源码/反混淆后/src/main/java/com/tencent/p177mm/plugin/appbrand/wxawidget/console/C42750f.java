package com.tencent.p177mm.plugin.appbrand.wxawidget.console;

import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.f */
public final class C42750f {
    /* renamed from: cX */
    public static boolean m75786cX(View view) {
        AppMethodBeat.m2504i(11172);
        if (view == null) {
            AppMethodBeat.m2505o(11172);
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.m2505o(11172);
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.m2505o(11172);
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            C4990ab.m7413e("MicroMsg.InputMethodHelper", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        AppMethodBeat.m2505o(11172);
        return hideSoftInputFromWindow;
    }
}
