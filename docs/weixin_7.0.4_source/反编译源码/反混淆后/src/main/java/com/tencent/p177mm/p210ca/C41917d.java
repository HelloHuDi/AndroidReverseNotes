package com.tencent.p177mm.p210ca;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.compatible.p222g.C1434a.C1433a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.svg.p610a.C5147a;
import com.tencent.p177mm.svg.p611b.C5157b;

/* renamed from: com.tencent.mm.ca.d */
public final class C41917d {
    C5147a xuG = new C5147a();

    /* renamed from: com.tencent.mm.ca.d$a */
    public static class C9211a implements C1433a {
        C5147a xuG = new C5147a();

        public C9211a() {
            AppMethodBeat.m2504i(105912);
            AppMethodBeat.m2505o(105912);
        }

        public final Bitmap decodeResource(Resources resources, int i, Options options) {
            AppMethodBeat.m2504i(105913);
            if (this.xuG.mo10586g(resources, i)) {
                float f = 0.0f;
                if (options != null) {
                    f = ((float) options.inDensity) / 160.0f;
                }
                Bitmap b = C5147a.m7831b(resources, i, f);
                AppMethodBeat.m2505o(105913);
                return b;
            }
            AppMethodBeat.m2505o(105913);
            return null;
        }
    }

    public C41917d() {
        AppMethodBeat.m2504i(105914);
        AppMethodBeat.m2505o(105914);
    }

    static {
        AppMethodBeat.m2504i(105917);
        C1434a.m3059a(new C9211a());
        C5157b.m7862pu(C4996ah.getContext().getSharedPreferences("wechat_svg_debug", C1448h.m3078Mu()).getBoolean("open_tag", false));
        AppMethodBeat.m2505o(105917);
    }

    /* renamed from: f */
    public final Drawable mo67562f(Resources resources, int i) {
        AppMethodBeat.m2504i(105915);
        Drawable drawable = null;
        if (this.xuG.mo10586g(resources, i)) {
            drawable = C5147a.m7837f(resources, i);
        }
        AppMethodBeat.m2505o(105915);
        return drawable;
    }

    /* renamed from: oZ */
    public static void m74027oZ(boolean z) {
        AppMethodBeat.m2504i(105916);
        C4996ah.getContext().getSharedPreferences("wechat_svg_debug", C1448h.m3078Mu()).edit().putBoolean("open_tag", z).commit();
        C5157b.m7862pu(z);
        AppMethodBeat.m2505o(105916);
    }
}
