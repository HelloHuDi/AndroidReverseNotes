package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class u {

    public static class a {
        public String appId;
        public String[] bQQ;
        public String nickname;
        public int uin;
        public String userName;

        public a(int i, String[] strArr, String str, String str2, String str3) {
            this.uin = i;
            this.bQQ = strArr;
            this.nickname = str;
            this.appId = str2;
            this.userName = str3;
        }
    }

    public static boolean a(Context context, a aVar, int i, boolean z) {
        AppMethodBeat.i(129117);
        if (context == null || aVar == null) {
            ab.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
            AppMethodBeat.o(129117);
            return false;
        } else if (aVar.bQQ == null) {
            ab.e("MicroMsg.AppBrandShortcutManager", "no such user");
            AppMethodBeat.o(129117);
            return false;
        } else {
            Bitmap k = k(aVar.bQQ);
            if (k == null) {
                ab.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
                AppMethodBeat.o(129117);
                return true;
            }
            Intent a = a(context, aVar, i, a(context, k, i), true);
            if (a == null) {
                ab.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
                AppMethodBeat.o(129117);
                return false;
            }
            String da;
            if (((Intent) a.getParcelableExtra("android.intent.extra.shortcut.INTENT")) != null) {
                da = b.da(aVar.appId + String.valueOf(i), q.LK());
                if (da != null) {
                    da = b.V(da.getBytes());
                } else {
                    da = null;
                }
                ab.i("MicroMsg.AppBrandShortcutManager", "alvinluo appId: %s, shortcutId: %s", r5, da);
            } else {
                da = null;
            }
            try {
                b.a(context, a, da, z);
                ab.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", aVar.userName);
                AppMethodBeat.o(129117);
                return true;
            } catch (IllegalStateException e) {
                ab.w("MicroMsg.AppBrandShortcutManager", e.toString());
                AppMethodBeat.o(129117);
                return false;
            }
        }
    }

    public static boolean a(Context context, a aVar, int i) {
        AppMethodBeat.i(129118);
        if (context == null) {
            ab.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or config is null.");
            AppMethodBeat.o(129118);
            return false;
        } else if (aVar.bQQ == null) {
            ab.e("MicroMsg.AppBrandShortcutManager", "no such user");
            AppMethodBeat.o(129118);
            return false;
        } else {
            Intent a = a(context, aVar, i, a(context, k(aVar.bQQ), i), false);
            if (a == null) {
                ab.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                AppMethodBeat.o(129118);
                return false;
            }
            b.s(context, a);
            ab.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", aVar.userName);
            AppMethodBeat.o(129118);
            return true;
        }
    }

    private static Intent a(Context context, a aVar, int i, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(129119);
        if (aVar == null || context == null || aVar.userName == null) {
            ab.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
            AppMethodBeat.o(129119);
            return null;
        } else if (bitmap == null && z) {
            ab.e("MicroMsg.AppBrandShortcutManager", "no bmp");
            AppMethodBeat.o(129119);
            return null;
        } else {
            String str = TextUtils.isEmpty(aVar.nickname) ? aVar.userName : aVar.nickname;
            Intent a = t.auu().a(context.getPackageName(), i, aVar.userName, aVar.nickname, aVar.bQQ, aVar.appId, aVar.uin, 1);
            Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", str);
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.INTENT", a);
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            AppMethodBeat.o(129119);
            return intent;
        }
    }

    private static Bitmap k(String[] strArr) {
        Bitmap a;
        AppMethodBeat.i(129120);
        for (String str : strArr) {
            if (!bo.isNullOrNil(str)) {
                a = com.tencent.mm.modelappbrand.a.b.abR().a(str, null);
                if (!(a == null || a.isRecycled())) {
                    break;
                }
            }
        }
        a = null;
        AppMethodBeat.o(129120);
        return a;
    }

    private static Bitmap a(Context context, Bitmap bitmap, int i) {
        Bitmap bitmap2 = null;
        AppMethodBeat.i(129121);
        if (context == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(129121);
        } else {
            int density = (int) (com.tencent.mm.bz.a.getDensity(context) * 48.0f);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, density, density, false);
            if (createScaledBitmap != null) {
                bitmap2 = createScaledBitmap.copy(Config.ARGB_8888, true);
                ab.i("MicroMsg.AppBrandShortcutManager", "bitmap recycle %s", createScaledBitmap);
                createScaledBitmap.recycle();
            }
            if (i == 2) {
                a(context, bitmap2, com.tencent.mm.bz.a.an(context, R.string.o3));
            } else if (i == 1) {
                a(context, bitmap2, com.tencent.mm.bz.a.an(context, R.string.o4));
            }
            AppMethodBeat.o(129121);
        }
        return bitmap2;
    }

    private static void a(Context context, Bitmap bitmap, String str) {
        AppMethodBeat.i(129122);
        if (context == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(129122);
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129122);
        } else {
            RectF rectF;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float density = com.tencent.mm.bz.a.getDensity(context);
            float f = 4.0f * density;
            float f2 = 2.0f * density;
            density *= 6.0f;
            Paint paint = new Paint();
            paint.setTextSize(density);
            paint.setFakeBoldText(true);
            paint.setAntiAlias(true);
            float measureText = paint.measureText(str);
            FontMetrics fontMetrics = paint.getFontMetrics();
            float f3 = fontMetrics.bottom - fontMetrics.top;
            paint.setColor(Color.parseColor("#459AE9"));
            Canvas canvas = new Canvas(bitmap);
            if (VERSION.SDK_INT < 26) {
                rectF = new RectF((((float) width) - measureText) - (2.0f * f), (((float) height) - f3) - (2.0f * f2), (float) width, (float) height);
            } else {
                rectF = new RectF(0.0f, (((float) height) - f3) - (2.0f * f2), measureText + (2.0f * f), (float) height);
            }
            canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
            paint.setColor(-1);
            canvas.drawText(str, rectF.left + f, (rectF.top + f2) - fontMetrics.ascent, paint);
            AppMethodBeat.o(129122);
        }
    }
}
