package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.support.v4.widget.j;
import android.view.Display;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import android.view.WindowManager;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.statusbar.d;

public enum n {
    ;

    public static void H(View view, int i) {
        AppMethodBeat.i(87382);
        if (!(view == null || view.getVisibility() == i)) {
            view.setVisibility(i);
        }
        AppMethodBeat.o(87382);
    }

    public static int[] aMw() {
        AppMethodBeat.i(87383);
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        AppMethodBeat.o(87383);
        return r1;
    }

    public static void a(Window window) {
        AppMethodBeat.i(87384);
        if (window == null) {
            AppMethodBeat.o(87384);
            return;
        }
        if (VERSION.SDK_INT >= 21 && ((window.getAttributes().flags & j.INVALID_ID) == 0 || window.getStatusBarColor() != 0)) {
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.o(87384);
    }

    public static boolean a(Window window, boolean z) {
        AppMethodBeat.i(87385);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.o(87385);
            return false;
        } else if (VERSION.SDK_INT < 23 || (b.Ms() && b.Mt())) {
            AppMethodBeat.o(87385);
            return false;
        } else {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            } else {
                systemUiVisibility &= -8193;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
            AppMethodBeat.o(87385);
            return true;
        }
    }

    public static boolean b(Window window) {
        AppMethodBeat.i(87386);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.o(87386);
            return false;
        } else if (VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            AppMethodBeat.o(87386);
            return false;
        } else {
            AppMethodBeat.o(87386);
            return true;
        }
    }

    public static boolean u(Activity activity) {
        AppMethodBeat.i(87387);
        if (VERSION.SDK_INT < 24 || activity == null || !activity.isInMultiWindowMode()) {
            AppMethodBeat.o(87387);
            return false;
        }
        AppMethodBeat.o(87387);
        return true;
    }

    @Deprecated
    public static Activity cY(Context context) {
        AppMethodBeat.i(87388);
        Activity cY = d.cY(context);
        AppMethodBeat.o(87388);
        return cY;
    }

    public static boolean ct(View view) {
        AppMethodBeat.i(87389);
        if (VERSION.SDK_INT < 24) {
            AppMethodBeat.o(87389);
            return false;
        } else if (view == null) {
            AppMethodBeat.o(87389);
            return false;
        } else {
            Context context = view.getContext();
            if ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if ((context instanceof Activity) && u((Activity) context)) {
                AppMethodBeat.o(87389);
                return true;
            }
            AppMethodBeat.o(87389);
            return false;
        }
    }

    private static int b(Window window, boolean z) {
        AppMethodBeat.i(87390);
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
        ab.i("MicroMsg.AppBrandUIUtil", "hy: setting ui visibility: %d", Integer.valueOf(systemUiVisibility));
        AppMethodBeat.o(87390);
        return systemUiVisibility;
    }

    public static void q(Context context, boolean z) {
        AppMethodBeat.i(87391);
        Activity cY = d.cY(context);
        if (cY == null || cY.getWindow() == null) {
            ab.w("MicroMsg.AppBrandUIUtil", "configFullScreen with context(%s), get NULL activity", context);
            AppMethodBeat.o(87391);
            return;
        }
        c(cY.getWindow(), z);
        AppMethodBeat.o(87391);
    }

    public static void c(final Window window, boolean z) {
        AppMethodBeat.i(87392);
        if (z) {
            window.getDecorView().setSystemUiVisibility(b(window, true));
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    AppMethodBeat.i(87379);
                    ab.d("MicroMsg.AppBrandUIUtil", "visibility = ".concat(String.valueOf(i)));
                    if ((i & 4) == 0) {
                        window.getDecorView().setSystemUiVisibility(n.c(window));
                    }
                    AppMethodBeat.o(87379);
                }
            });
            window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.o(87392);
            return;
        }
        window.getDecorView().setSystemUiVisibility(b(window, false));
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        window.clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.o(87392);
    }
}
