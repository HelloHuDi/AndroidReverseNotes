package com.tencent.p177mm.plugin.webview.luggage.p1420c;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.c.a */
public final class C46417a {
    /* renamed from: c */
    public static void m87415c(final Window window, final boolean z) {
        AppMethodBeat.m2504i(6495);
        if (z) {
            window.getDecorView().setSystemUiVisibility(C46417a.m87414b(window, z));
            window.setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    AppMethodBeat.m2504i(6494);
                    if ((i & 4) == 0) {
                        window.getDecorView().setSystemUiVisibility(C46417a.m87414b(window, z));
                    }
                    AppMethodBeat.m2505o(6494);
                }
            });
            AppMethodBeat.m2505o(6495);
            return;
        }
        window.getDecorView().setSystemUiVisibility(C46417a.m87414b(window, z));
        window.clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        AppMethodBeat.m2505o(6495);
    }

    /* renamed from: b */
    public static int m87414b(Window window, boolean z) {
        AppMethodBeat.m2504i(6496);
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
        AppMethodBeat.m2505o(6496);
        return systemUiVisibility;
    }

    /* renamed from: a */
    public static boolean m87413a(Context context, int i, String str) {
        AppMethodBeat.m2504i(6497);
        boolean c = C46417a.m87416c(context, i, C5046bo.nullAsNil(str).equals("black"));
        AppMethodBeat.m2505o(6497);
        return c;
    }

    /* renamed from: c */
    public static boolean m87416c(Context context, int i, boolean z) {
        AppMethodBeat.m2504i(6498);
        if (!(context instanceof Activity)) {
            AppMethodBeat.m2505o(6498);
            return false;
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(6498);
            return false;
        } else {
            Window window = ((Activity) context).getWindow();
            if (VERSION.SDK_INT < 23 || !C5546d.m8369a(window, z)) {
                if (VERSION.SDK_INT >= 21) {
                    if (z) {
                        i = C5222ae.m7932Jj(i);
                    }
                }
                AppMethodBeat.m2505o(6498);
                return true;
            }
            window.setStatusBarColor(i);
            AppMethodBeat.m2505o(6498);
            return true;
        }
    }
}
