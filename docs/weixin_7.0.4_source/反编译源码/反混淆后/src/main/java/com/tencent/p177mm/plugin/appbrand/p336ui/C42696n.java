package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C8415j;
import android.view.Display;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import android.view.WindowManager;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.n */
public enum C42696n {
    ;

    /* renamed from: H */
    public static void m75614H(View view, int i) {
        AppMethodBeat.m2504i(87382);
        if (!(view == null || view.getVisibility() == i)) {
            view.setVisibility(i);
        }
        AppMethodBeat.m2505o(87382);
    }

    public static int[] aMw() {
        AppMethodBeat.m2504i(87383);
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        AppMethodBeat.m2505o(87383);
        return r1;
    }

    /* renamed from: a */
    public static void m75615a(Window window) {
        AppMethodBeat.m2504i(87384);
        if (window == null) {
            AppMethodBeat.m2505o(87384);
            return;
        }
        if (VERSION.SDK_INT >= 21 && ((window.getAttributes().flags & C8415j.INVALID_ID) == 0 || window.getStatusBarColor() != 0)) {
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.m2505o(87384);
    }

    /* renamed from: a */
    public static boolean m75616a(Window window, boolean z) {
        AppMethodBeat.m2504i(87385);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.m2505o(87385);
            return false;
        } else if (VERSION.SDK_INT < 23 || (C4971b.m7363Ms() && C4971b.m7364Mt())) {
            AppMethodBeat.m2505o(87385);
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
            AppMethodBeat.m2505o(87385);
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m75618b(Window window) {
        AppMethodBeat.m2504i(87386);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.m2505o(87386);
            return false;
        } else if (VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            AppMethodBeat.m2505o(87386);
            return false;
        } else {
            AppMethodBeat.m2505o(87386);
            return true;
        }
    }

    /* renamed from: u */
    public static boolean m75624u(Activity activity) {
        AppMethodBeat.m2504i(87387);
        if (VERSION.SDK_INT < 24 || activity == null || !activity.isInMultiWindowMode()) {
            AppMethodBeat.m2505o(87387);
            return false;
        }
        AppMethodBeat.m2505o(87387);
        return true;
    }

    @Deprecated
    /* renamed from: cY */
    public static Activity m75621cY(Context context) {
        AppMethodBeat.m2504i(87388);
        Activity cY = C5546d.m8371cY(context);
        AppMethodBeat.m2505o(87388);
        return cY;
    }

    /* renamed from: ct */
    public static boolean m75622ct(View view) {
        AppMethodBeat.m2504i(87389);
        if (VERSION.SDK_INT < 24) {
            AppMethodBeat.m2505o(87389);
            return false;
        } else if (view == null) {
            AppMethodBeat.m2505o(87389);
            return false;
        } else {
            Context context = view.getContext();
            if ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if ((context instanceof Activity) && C42696n.m75624u((Activity) context)) {
                AppMethodBeat.m2505o(87389);
                return true;
            }
            AppMethodBeat.m2505o(87389);
            return false;
        }
    }

    /* renamed from: b */
    private static int m75617b(Window window, boolean z) {
        AppMethodBeat.m2504i(87390);
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
        C4990ab.m7417i("MicroMsg.AppBrandUIUtil", "hy: setting ui visibility: %d", Integer.valueOf(systemUiVisibility));
        AppMethodBeat.m2505o(87390);
        return systemUiVisibility;
    }

    /* renamed from: q */
    public static void m75623q(Context context, boolean z) {
        AppMethodBeat.m2504i(87391);
        Activity cY = C5546d.m8371cY(context);
        if (cY == null || cY.getWindow() == null) {
            C4990ab.m7421w("MicroMsg.AppBrandUIUtil", "configFullScreen with context(%s), get NULL activity", context);
            AppMethodBeat.m2505o(87391);
            return;
        }
        C42696n.m75620c(cY.getWindow(), z);
        AppMethodBeat.m2505o(87391);
    }

    /* renamed from: c */
    public static void m75620c(final Window window, boolean z) {
        AppMethodBeat.m2504i(87392);
        if (z) {
            window.getDecorView().setSystemUiVisibility(C42696n.m75617b(window, true));
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    AppMethodBeat.m2504i(87379);
                    C4990ab.m7410d("MicroMsg.AppBrandUIUtil", "visibility = ".concat(String.valueOf(i)));
                    if ((i & 4) == 0) {
                        window.getDecorView().setSystemUiVisibility(C42696n.m75619c(window));
                    }
                    AppMethodBeat.m2505o(87379);
                }
            });
            window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(87392);
            return;
        }
        window.getDecorView().setSystemUiVisibility(C42696n.m75617b(window, false));
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        window.clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.m2505o(87392);
    }
}
