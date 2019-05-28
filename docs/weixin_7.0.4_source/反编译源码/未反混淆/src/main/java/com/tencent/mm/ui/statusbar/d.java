package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.support.v4.widget.j;
import android.view.View;
import android.view.Window;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.h.b;

public final class d {
    public static Activity cY(Context context) {
        AppMethodBeat.i(67850);
        Context context2 = context;
        while (context2 != null) {
            if (context2 instanceof Activity) {
                Activity activity = (Activity) context2;
                AppMethodBeat.o(67850);
                return activity;
            }
            if (context2 instanceof ContextWrapper) {
                context = ((ContextWrapper) context2).getBaseContext();
                if (context != context2) {
                    context2 = context;
                }
            }
            AppMethodBeat.o(67850);
            return null;
        }
        AppMethodBeat.o(67850);
        return null;
    }

    public static boolean b(Window window) {
        AppMethodBeat.i(67851);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.o(67851);
            return false;
        } else if (VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            AppMethodBeat.o(67851);
            return false;
        } else {
            AppMethodBeat.o(67851);
            return true;
        }
    }

    public static void a(Window window) {
        AppMethodBeat.i(67852);
        if (window == null) {
            AppMethodBeat.o(67852);
            return;
        }
        if (VERSION.SDK_INT >= 21 && ((window.getAttributes().flags & j.INVALID_ID) == 0 || window.getStatusBarColor() != 0)) {
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.o(67852);
    }

    public static boolean a(Window window, boolean z) {
        AppMethodBeat.i(67853);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.o(67853);
            return false;
        } else if (dJo()) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            } else {
                systemUiVisibility &= -8193;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
            AppMethodBeat.o(67853);
            return true;
        } else {
            AppMethodBeat.o(67853);
            return false;
        }
    }

    public static boolean dJo() {
        AppMethodBeat.i(67854);
        if (VERSION.SDK_INT < 23 || b.Mt()) {
            AppMethodBeat.o(67854);
            return false;
        }
        AppMethodBeat.o(67854);
        return true;
    }
}
