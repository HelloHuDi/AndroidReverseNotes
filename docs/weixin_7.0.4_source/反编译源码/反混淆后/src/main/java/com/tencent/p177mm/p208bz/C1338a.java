package com.tencent.p177mm.p208bz;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.bz.a */
public final class C1338a {
    private static float density = -1.0f;
    private static float scale = 0.0f;
    private static C1337a xuo = null;
    private static SparseIntArray xup = new SparseIntArray();

    /* renamed from: com.tencent.mm.bz.a$a */
    public interface C1337a {
        int dmF();

        ColorStateList dmG();

        Drawable dmH();

        int dmI();

        String dmJ();
    }

    static {
        AppMethodBeat.m2504i(115145);
        AppMethodBeat.m2505o(115145);
    }

    /* renamed from: i */
    public static int m2872i(Context context, int i) {
        AppMethodBeat.m2504i(115126);
        int dmF;
        if (xuo != null) {
            dmF = xuo.dmF();
            AppMethodBeat.m2505o(115126);
            return dmF;
        } else if (context == null) {
            C4990ab.m7413e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(115126);
            return 0;
        } else {
            dmF = context.getResources().getColor(i);
            AppMethodBeat.m2505o(115126);
            return dmF;
        }
    }

    /* renamed from: h */
    public static ColorStateList m2870h(Context context, int i) {
        AppMethodBeat.m2504i(115127);
        ColorStateList dmG;
        if (xuo != null) {
            dmG = xuo.dmG();
            AppMethodBeat.m2505o(115127);
            return dmG;
        } else if (context == null) {
            C4990ab.m7413e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(115127);
            return null;
        } else {
            dmG = context.getResources().getColorStateList(i);
            AppMethodBeat.m2505o(115127);
            return dmG;
        }
    }

    /* renamed from: g */
    public static Drawable m2864g(Context context, int i) {
        AppMethodBeat.m2504i(115128);
        Drawable dmH;
        if (xuo != null) {
            dmH = xuo.dmH();
            AppMethodBeat.m2505o(115128);
            return dmH;
        } else if (context == null) {
            C4990ab.m7413e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(115128);
            return null;
        } else {
            dmH = context.getResources().getDrawable(i);
            AppMethodBeat.m2505o(115128);
            return dmH;
        }
    }

    /* renamed from: al */
    public static int m2856al(Context context, int i) {
        float f = 1.625f;
        AppMethodBeat.m2504i(115129);
        float f2 = scale;
        if (f2 <= 1.625f) {
            f = f2;
        }
        int i2;
        int i3;
        if (xuo != null) {
            i2 = xup.get(i, 0);
            if (i2 == 0) {
                i2 = xuo.dmI();
                xup.put(i, i2);
            }
            i3 = (int) (f * ((float) i2));
            AppMethodBeat.m2505o(115129);
            return i3;
        } else if (context == null) {
            C4990ab.m7413e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(115129);
            return 0;
        } else {
            i2 = xup.get(i, 0);
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                xup.put(i, i2);
            }
            i3 = (int) (f * ((float) i2));
            AppMethodBeat.m2505o(115129);
            return i3;
        }
    }

    /* renamed from: am */
    public static int m2857am(Context context, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(115130);
        if (xuo != null) {
            i2 = xup.get(i, i2);
            if (i2 == 0) {
                i2 = xuo.dmI();
                xup.put(i, i2);
            }
            AppMethodBeat.m2505o(115130);
        } else if (context == null) {
            C4990ab.m7413e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(115130);
        } else {
            try {
                i2 = xup.get(i, 0);
            } catch (ArrayIndexOutOfBoundsException e) {
                C4990ab.printErrStackTrace("MicroMsg.ResourceHelper", e, "[getDPSize] resId:%s", Integer.valueOf(i));
            }
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                xup.put(i, i2);
            }
            AppMethodBeat.m2505o(115130);
        }
        return i2;
    }

    /* renamed from: an */
    public static String m2858an(Context context, int i) {
        AppMethodBeat.m2504i(115131);
        String dmJ;
        if (xuo != null) {
            dmJ = xuo.dmJ();
            AppMethodBeat.m2505o(115131);
            return dmJ;
        } else if (context == null) {
            C4990ab.m7413e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", Integer.valueOf(i));
            dmJ = "";
            AppMethodBeat.m2505o(115131);
            return dmJ;
        } else {
            dmJ = context.getResources().getString(i);
            AppMethodBeat.m2505o(115131);
            return dmJ;
        }
    }

    public static float getDensity(Context context) {
        AppMethodBeat.m2504i(115132);
        if (context == null) {
            context = C4996ah.getContext();
        }
        float f = context.getResources().getDisplayMetrics().density;
        density = f;
        AppMethodBeat.m2505o(115132);
        return f;
    }

    public static int fromDPToPix(Context context, int i) {
        AppMethodBeat.m2504i(115133);
        int round = Math.round(C1338a.getDensity(context) * ((float) i));
        AppMethodBeat.m2505o(115133);
        return round;
    }

    /* renamed from: ao */
    public static int m2859ao(Context context, int i) {
        AppMethodBeat.m2504i(115134);
        int round = Math.round(((float) i) / C1338a.getDensity(context));
        AppMethodBeat.m2505o(115134);
        return round;
    }

    /* renamed from: dm */
    public static float m2860dm(Context context) {
        AppMethodBeat.m2504i(115135);
        if (scale == 0.0f) {
            if (context == null) {
                scale = 1.0f;
            } else {
                scale = context.getSharedPreferences(C4996ah.doA(), 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        float f = scale;
        AppMethodBeat.m2505o(115135);
        return f;
    }

    /* renamed from: fX */
    public static int m2861fX(Context context) {
        AppMethodBeat.m2504i(115136);
        float dm = C1338a.m2860dm(context);
        if (dm == 0.875f) {
            AppMethodBeat.m2505o(115136);
            return 1;
        } else if (dm == 1.0f) {
            AppMethodBeat.m2505o(115136);
            return 2;
        } else if (dm == 1.125f) {
            AppMethodBeat.m2505o(115136);
            return 3;
        } else if (dm == 1.25f) {
            AppMethodBeat.m2505o(115136);
            return 4;
        } else if (dm == 1.375f) {
            AppMethodBeat.m2505o(115136);
            return 5;
        } else if (dm == 1.625f) {
            AppMethodBeat.m2505o(115136);
            return 6;
        } else if (dm == 1.875f) {
            AppMethodBeat.m2505o(115136);
            return 7;
        } else if (dm == 2.025f) {
            AppMethodBeat.m2505o(115136);
            return 8;
        } else {
            AppMethodBeat.m2505o(115136);
            return 2;
        }
    }

    /* renamed from: fY */
    public static float m2862fY(Context context) {
        AppMethodBeat.m2504i(115137);
        float f = 1.0f;
        if (C1338a.m2865ga(context)) {
            f = 1.3f;
        }
        AppMethodBeat.m2505o(115137);
        return f;
    }

    /* renamed from: fZ */
    public static float m2863fZ(Context context) {
        AppMethodBeat.m2504i(115138);
        float f = 1.0f;
        if (C1338a.m2866gb(context)) {
            f = 1.2f;
        } else if (C1338a.m2865ga(context)) {
            f = 1.1f;
        }
        AppMethodBeat.m2505o(115138);
        return f;
    }

    /* renamed from: h */
    public static void m2871h(Context context, float f) {
        AppMethodBeat.m2504i(115139);
        Editor edit = context.getSharedPreferences(C4996ah.doA(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        scale = f;
        AppMethodBeat.m2505o(115139);
    }

    /* renamed from: ga */
    public static boolean m2865ga(Context context) {
        AppMethodBeat.m2504i(115140);
        float dm = C1338a.m2860dm(context);
        scale = dm;
        if (Float.compare(dm, 1.125f) > 0) {
            AppMethodBeat.m2505o(115140);
            return true;
        }
        AppMethodBeat.m2505o(115140);
        return false;
    }

    /* renamed from: gb */
    public static boolean m2866gb(Context context) {
        AppMethodBeat.m2504i(115141);
        float dm = C1338a.m2860dm(context);
        scale = dm;
        if (Float.compare(dm, 1.375f) > 0) {
            AppMethodBeat.m2505o(115141);
            return true;
        }
        AppMethodBeat.m2505o(115141);
        return false;
    }

    /* renamed from: gc */
    public static boolean m2867gc(Context context) {
        AppMethodBeat.m2504i(115142);
        float dm = C1338a.m2860dm(context);
        scale = dm;
        if (dm == 0.875f) {
            AppMethodBeat.m2505o(115142);
            return true;
        }
        AppMethodBeat.m2505o(115142);
        return false;
    }

    /* renamed from: gd */
    public static int m2868gd(Context context) {
        AppMethodBeat.m2504i(115143);
        if (xuo != null) {
            AppMethodBeat.m2505o(115143);
            return 0;
        } else if (context == null) {
            C4990ab.m7412e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
            AppMethodBeat.m2505o(115143);
            return 0;
        } else {
            int i = context.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.m2505o(115143);
            return i;
        }
    }

    /* renamed from: ge */
    public static int m2869ge(Context context) {
        AppMethodBeat.m2504i(115144);
        if (xuo != null) {
            AppMethodBeat.m2505o(115144);
            return 0;
        } else if (context == null) {
            C4990ab.m7412e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
            AppMethodBeat.m2505o(115144);
            return 0;
        } else {
            int i = context.getResources().getDisplayMetrics().heightPixels;
            AppMethodBeat.m2505o(115144);
            return i;
        }
    }
}
