package com.tencent.mm.ca;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.svg.b.b;

public final class d {
    com.tencent.mm.svg.a.a xuG = new com.tencent.mm.svg.a.a();

    public static class a implements com.tencent.mm.compatible.g.a.a {
        com.tencent.mm.svg.a.a xuG = new com.tencent.mm.svg.a.a();

        public a() {
            AppMethodBeat.i(105912);
            AppMethodBeat.o(105912);
        }

        public final Bitmap decodeResource(Resources resources, int i, Options options) {
            AppMethodBeat.i(105913);
            if (this.xuG.g(resources, i)) {
                float f = 0.0f;
                if (options != null) {
                    f = ((float) options.inDensity) / 160.0f;
                }
                Bitmap b = com.tencent.mm.svg.a.a.b(resources, i, f);
                AppMethodBeat.o(105913);
                return b;
            }
            AppMethodBeat.o(105913);
            return null;
        }
    }

    public d() {
        AppMethodBeat.i(105914);
        AppMethodBeat.o(105914);
    }

    static {
        AppMethodBeat.i(105917);
        com.tencent.mm.compatible.g.a.a(new a());
        b.pu(ah.getContext().getSharedPreferences("wechat_svg_debug", h.Mu()).getBoolean("open_tag", false));
        AppMethodBeat.o(105917);
    }

    public final Drawable f(Resources resources, int i) {
        AppMethodBeat.i(105915);
        Drawable drawable = null;
        if (this.xuG.g(resources, i)) {
            drawable = com.tencent.mm.svg.a.a.f(resources, i);
        }
        AppMethodBeat.o(105915);
        return drawable;
    }

    public static void oZ(boolean z) {
        AppMethodBeat.i(105916);
        ah.getContext().getSharedPreferences("wechat_svg_debug", h.Mu()).edit().putBoolean("open_tag", z).commit();
        b.pu(z);
        AppMethodBeat.o(105916);
    }
}
