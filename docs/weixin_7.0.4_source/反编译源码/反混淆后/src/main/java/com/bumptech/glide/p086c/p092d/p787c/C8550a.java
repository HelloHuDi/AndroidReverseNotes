package com.bumptech.glide.p086c.p092d.p787c;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.content.p062a.C0378b;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.view.C0606d;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.c.a */
public final class C8550a {
    private static volatile boolean aFO = true;

    /* renamed from: b */
    public static Drawable m15197b(Context context, Context context2, int i) {
        AppMethodBeat.m2504i(92284);
        Drawable a = C8550a.m15196a(context, context2, i, null);
        AppMethodBeat.m2505o(92284);
        return a;
    }

    /* renamed from: a */
    public static Drawable m15195a(Context context, int i, Theme theme) {
        AppMethodBeat.m2504i(92285);
        Drawable a = C8550a.m15196a(context, context, i, theme);
        AppMethodBeat.m2505o(92285);
        return a;
    }

    /* renamed from: a */
    private static Drawable m15196a(Context context, Context context2, int i, Theme theme) {
        Drawable g;
        AppMethodBeat.m2504i(92286);
        try {
            if (aFO) {
                g = C0589b.m1275g(theme != null ? new C0606d(context2, theme) : context2, i);
                AppMethodBeat.m2505o(92286);
                return g;
            }
        } catch (NoClassDefFoundError e) {
            aFO = false;
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                AppMethodBeat.m2505o(92286);
                throw e2;
            }
            g = C0380b.m649g(context2, i);
            AppMethodBeat.m2505o(92286);
            return g;
        } catch (NotFoundException e3) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        g = C0378b.m634b(context2.getResources(), i, theme);
        AppMethodBeat.m2505o(92286);
        return g;
    }
}
