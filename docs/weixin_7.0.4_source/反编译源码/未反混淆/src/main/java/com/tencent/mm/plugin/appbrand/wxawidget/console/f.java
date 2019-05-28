package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class f {
    public static boolean cX(View view) {
        AppMethodBeat.i(11172);
        if (view == null) {
            AppMethodBeat.o(11172);
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(11172);
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(11172);
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            ab.e("MicroMsg.InputMethodHelper", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        AppMethodBeat.o(11172);
        return hideSoftInputFromWindow;
    }
}
