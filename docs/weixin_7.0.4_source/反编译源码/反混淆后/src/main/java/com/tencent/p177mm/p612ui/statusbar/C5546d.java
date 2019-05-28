package com.tencent.p177mm.p612ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C8415j;
import android.view.View;
import android.view.Window;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p609h.C4971b;

/* renamed from: com.tencent.mm.ui.statusbar.d */
public final class C5546d {
    /* renamed from: cY */
    public static Activity m8371cY(Context context) {
        AppMethodBeat.m2504i(67850);
        Context context2 = context;
        while (context2 != null) {
            if (context2 instanceof Activity) {
                Activity activity = (Activity) context2;
                AppMethodBeat.m2505o(67850);
                return activity;
            }
            if (context2 instanceof ContextWrapper) {
                context = ((ContextWrapper) context2).getBaseContext();
                if (context != context2) {
                    context2 = context;
                }
            }
            AppMethodBeat.m2505o(67850);
            return null;
        }
        AppMethodBeat.m2505o(67850);
        return null;
    }

    /* renamed from: b */
    public static boolean m8370b(Window window) {
        AppMethodBeat.m2504i(67851);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.m2505o(67851);
            return false;
        } else if (VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            AppMethodBeat.m2505o(67851);
            return false;
        } else {
            AppMethodBeat.m2505o(67851);
            return true;
        }
    }

    /* renamed from: a */
    public static void m8368a(Window window) {
        AppMethodBeat.m2504i(67852);
        if (window == null) {
            AppMethodBeat.m2505o(67852);
            return;
        }
        if (VERSION.SDK_INT >= 21 && ((window.getAttributes().flags & C8415j.INVALID_ID) == 0 || window.getStatusBarColor() != 0)) {
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.m2505o(67852);
    }

    /* renamed from: a */
    public static boolean m8369a(Window window, boolean z) {
        AppMethodBeat.m2504i(67853);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.m2505o(67853);
            return false;
        } else if (C5546d.dJo()) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            } else {
                systemUiVisibility &= -8193;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
            AppMethodBeat.m2505o(67853);
            return true;
        } else {
            AppMethodBeat.m2505o(67853);
            return false;
        }
    }

    public static boolean dJo() {
        AppMethodBeat.m2504i(67854);
        if (VERSION.SDK_INT < 23 || C4971b.m7364Mt()) {
            AppMethodBeat.m2505o(67854);
            return false;
        }
        AppMethodBeat.m2505o(67854);
        return true;
    }
}
