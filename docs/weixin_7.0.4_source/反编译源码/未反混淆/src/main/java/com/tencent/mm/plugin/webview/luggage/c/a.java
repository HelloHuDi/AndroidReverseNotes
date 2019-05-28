package com.tencent.mm.plugin.webview.luggage.c;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.statusbar.d;

public final class a {
    public static void c(final Window window, final boolean z) {
        AppMethodBeat.i(6495);
        if (z) {
            window.getDecorView().setSystemUiVisibility(b(window, z));
            window.setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    AppMethodBeat.i(6494);
                    if ((i & 4) == 0) {
                        window.getDecorView().setSystemUiVisibility(a.b(window, z));
                    }
                    AppMethodBeat.o(6494);
                }
            });
            AppMethodBeat.o(6495);
            return;
        }
        window.getDecorView().setSystemUiVisibility(b(window, z));
        window.clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        AppMethodBeat.o(6495);
    }

    public static int b(Window window, boolean z) {
        AppMethodBeat.i(6496);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (z) {
            systemUiVisibility = (systemUiVisibility | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) | 256;
            if (VERSION.SDK_INT >= 20) {
                systemUiVisibility = (systemUiVisibility | 512) | 2;
            }
            systemUiVisibility |= 4;
            if (VERSION.SDK_INT >= 19) {
                systemUiVisibility |= 4096;
            }
        } else {
            systemUiVisibility = (systemUiVisibility & -1025) & -257;
            if (VERSION.SDK_INT >= 20) {
                systemUiVisibility = (systemUiVisibility & -513) & -3;
            }
            systemUiVisibility &= -5;
            if (VERSION.SDK_INT >= 19) {
                systemUiVisibility &= -4097;
            }
        }
        AppMethodBeat.o(6496);
        return systemUiVisibility;
    }

    public static boolean a(Context context, int i, String str) {
        AppMethodBeat.i(6497);
        boolean c = c(context, i, bo.nullAsNil(str).equals("black"));
        AppMethodBeat.o(6497);
        return c;
    }

    public static boolean c(Context context, int i, boolean z) {
        AppMethodBeat.i(6498);
        if (!(context instanceof Activity)) {
            AppMethodBeat.o(6498);
            return false;
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(6498);
            return false;
        } else {
            Window window = ((Activity) context).getWindow();
            if (VERSION.SDK_INT < 23 || !d.a(window, z)) {
                if (VERSION.SDK_INT >= 21) {
                    if (z) {
                        i = ae.Jj(i);
                    }
                }
                AppMethodBeat.o(6498);
                return true;
            }
            window.setStatusBarColor(i);
            AppMethodBeat.o(6498);
            return true;
        }
    }
}
