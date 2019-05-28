package com.tencent.mm.bz;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a {
    private static float density = -1.0f;
    private static float scale = 0.0f;
    private static a xuo = null;
    private static SparseIntArray xup = new SparseIntArray();

    public interface a {
        int dmF();

        ColorStateList dmG();

        Drawable dmH();

        int dmI();

        String dmJ();
    }

    static {
        AppMethodBeat.i(115145);
        AppMethodBeat.o(115145);
    }

    public static int i(Context context, int i) {
        AppMethodBeat.i(115126);
        int dmF;
        if (xuo != null) {
            dmF = xuo.dmF();
            AppMethodBeat.o(115126);
            return dmF;
        } else if (context == null) {
            ab.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.o(115126);
            return 0;
        } else {
            dmF = context.getResources().getColor(i);
            AppMethodBeat.o(115126);
            return dmF;
        }
    }

    public static ColorStateList h(Context context, int i) {
        AppMethodBeat.i(115127);
        ColorStateList dmG;
        if (xuo != null) {
            dmG = xuo.dmG();
            AppMethodBeat.o(115127);
            return dmG;
        } else if (context == null) {
            ab.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.o(115127);
            return null;
        } else {
            dmG = context.getResources().getColorStateList(i);
            AppMethodBeat.o(115127);
            return dmG;
        }
    }

    public static Drawable g(Context context, int i) {
        AppMethodBeat.i(115128);
        Drawable dmH;
        if (xuo != null) {
            dmH = xuo.dmH();
            AppMethodBeat.o(115128);
            return dmH;
        } else if (context == null) {
            ab.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.o(115128);
            return null;
        } else {
            dmH = context.getResources().getDrawable(i);
            AppMethodBeat.o(115128);
            return dmH;
        }
    }

    public static int al(Context context, int i) {
        float f = 1.625f;
        AppMethodBeat.i(115129);
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
            AppMethodBeat.o(115129);
            return i3;
        } else if (context == null) {
            ab.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.o(115129);
            return 0;
        } else {
            i2 = xup.get(i, 0);
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                xup.put(i, i2);
            }
            i3 = (int) (f * ((float) i2));
            AppMethodBeat.o(115129);
            return i3;
        }
    }

    public static int am(Context context, int i) {
        int i2 = 0;
        AppMethodBeat.i(115130);
        if (xuo != null) {
            i2 = xup.get(i, i2);
            if (i2 == 0) {
                i2 = xuo.dmI();
                xup.put(i, i2);
            }
            AppMethodBeat.o(115130);
        } else if (context == null) {
            ab.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            AppMethodBeat.o(115130);
        } else {
            try {
                i2 = xup.get(i, 0);
            } catch (ArrayIndexOutOfBoundsException e) {
                ab.printErrStackTrace("MicroMsg.ResourceHelper", e, "[getDPSize] resId:%s", Integer.valueOf(i));
            }
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                xup.put(i, i2);
            }
            AppMethodBeat.o(115130);
        }
        return i2;
    }

    public static String an(Context context, int i) {
        AppMethodBeat.i(115131);
        String dmJ;
        if (xuo != null) {
            dmJ = xuo.dmJ();
            AppMethodBeat.o(115131);
            return dmJ;
        } else if (context == null) {
            ab.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", Integer.valueOf(i));
            dmJ = "";
            AppMethodBeat.o(115131);
            return dmJ;
        } else {
            dmJ = context.getResources().getString(i);
            AppMethodBeat.o(115131);
            return dmJ;
        }
    }

    public static float getDensity(Context context) {
        AppMethodBeat.i(115132);
        if (context == null) {
            context = ah.getContext();
        }
        float f = context.getResources().getDisplayMetrics().density;
        density = f;
        AppMethodBeat.o(115132);
        return f;
    }

    public static int fromDPToPix(Context context, int i) {
        AppMethodBeat.i(115133);
        int round = Math.round(getDensity(context) * ((float) i));
        AppMethodBeat.o(115133);
        return round;
    }

    public static int ao(Context context, int i) {
        AppMethodBeat.i(115134);
        int round = Math.round(((float) i) / getDensity(context));
        AppMethodBeat.o(115134);
        return round;
    }

    public static float dm(Context context) {
        AppMethodBeat.i(115135);
        if (scale == 0.0f) {
            if (context == null) {
                scale = 1.0f;
            } else {
                scale = context.getSharedPreferences(ah.doA(), 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        float f = scale;
        AppMethodBeat.o(115135);
        return f;
    }

    public static int fX(Context context) {
        AppMethodBeat.i(115136);
        float dm = dm(context);
        if (dm == 0.875f) {
            AppMethodBeat.o(115136);
            return 1;
        } else if (dm == 1.0f) {
            AppMethodBeat.o(115136);
            return 2;
        } else if (dm == 1.125f) {
            AppMethodBeat.o(115136);
            return 3;
        } else if (dm == 1.25f) {
            AppMethodBeat.o(115136);
            return 4;
        } else if (dm == 1.375f) {
            AppMethodBeat.o(115136);
            return 5;
        } else if (dm == 1.625f) {
            AppMethodBeat.o(115136);
            return 6;
        } else if (dm == 1.875f) {
            AppMethodBeat.o(115136);
            return 7;
        } else if (dm == 2.025f) {
            AppMethodBeat.o(115136);
            return 8;
        } else {
            AppMethodBeat.o(115136);
            return 2;
        }
    }

    public static float fY(Context context) {
        AppMethodBeat.i(115137);
        float f = 1.0f;
        if (ga(context)) {
            f = 1.3f;
        }
        AppMethodBeat.o(115137);
        return f;
    }

    public static float fZ(Context context) {
        AppMethodBeat.i(115138);
        float f = 1.0f;
        if (gb(context)) {
            f = 1.2f;
        } else if (ga(context)) {
            f = 1.1f;
        }
        AppMethodBeat.o(115138);
        return f;
    }

    public static void h(Context context, float f) {
        AppMethodBeat.i(115139);
        Editor edit = context.getSharedPreferences(ah.doA(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        scale = f;
        AppMethodBeat.o(115139);
    }

    public static boolean ga(Context context) {
        AppMethodBeat.i(115140);
        float dm = dm(context);
        scale = dm;
        if (Float.compare(dm, 1.125f) > 0) {
            AppMethodBeat.o(115140);
            return true;
        }
        AppMethodBeat.o(115140);
        return false;
    }

    public static boolean gb(Context context) {
        AppMethodBeat.i(115141);
        float dm = dm(context);
        scale = dm;
        if (Float.compare(dm, 1.375f) > 0) {
            AppMethodBeat.o(115141);
            return true;
        }
        AppMethodBeat.o(115141);
        return false;
    }

    public static boolean gc(Context context) {
        AppMethodBeat.i(115142);
        float dm = dm(context);
        scale = dm;
        if (dm == 0.875f) {
            AppMethodBeat.o(115142);
            return true;
        }
        AppMethodBeat.o(115142);
        return false;
    }

    public static int gd(Context context) {
        AppMethodBeat.i(115143);
        if (xuo != null) {
            AppMethodBeat.o(115143);
            return 0;
        } else if (context == null) {
            ab.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
            AppMethodBeat.o(115143);
            return 0;
        } else {
            int i = context.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.o(115143);
            return i;
        }
    }

    public static int ge(Context context) {
        AppMethodBeat.i(115144);
        if (xuo != null) {
            AppMethodBeat.o(115144);
            return 0;
        } else if (context == null) {
            ab.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
            AppMethodBeat.o(115144);
            return 0;
        } else {
            int i = context.getResources().getDisplayMetrics().heightPixels;
            AppMethodBeat.o(115144);
            return i;
        }
    }
}
