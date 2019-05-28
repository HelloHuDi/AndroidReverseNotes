package com.bumptech.glide.c.d.c;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v7.c.a.b;
import android.support.v7.view.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static volatile boolean aFO = true;

    public static Drawable b(Context context, Context context2, int i) {
        AppMethodBeat.i(92284);
        Drawable a = a(context, context2, i, null);
        AppMethodBeat.o(92284);
        return a;
    }

    public static Drawable a(Context context, int i, Theme theme) {
        AppMethodBeat.i(92285);
        Drawable a = a(context, context, i, theme);
        AppMethodBeat.o(92285);
        return a;
    }

    private static Drawable a(Context context, Context context2, int i, Theme theme) {
        Drawable g;
        AppMethodBeat.i(92286);
        try {
            if (aFO) {
                g = b.g(theme != null ? new d(context2, theme) : context2, i);
                AppMethodBeat.o(92286);
                return g;
            }
        } catch (NoClassDefFoundError e) {
            aFO = false;
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                AppMethodBeat.o(92286);
                throw e2;
            }
            g = android.support.v4.content.b.g(context2, i);
            AppMethodBeat.o(92286);
            return g;
        } catch (NotFoundException e3) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        g = android.support.v4.content.a.b.b(context2.getResources(), i, theme);
        AppMethodBeat.o(92286);
        return g;
    }
}
