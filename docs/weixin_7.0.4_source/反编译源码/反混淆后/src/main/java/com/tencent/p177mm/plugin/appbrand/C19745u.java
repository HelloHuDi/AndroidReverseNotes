package com.tencent.p177mm.plugin.appbrand;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.u */
public final class C19745u {

    /* renamed from: com.tencent.mm.plugin.appbrand.u$a */
    public static class C19744a {
        public String appId;
        public String[] bQQ;
        public String nickname;
        public int uin;
        public String userName;

        public C19744a(int i, String[] strArr, String str, String str2, String str3) {
            this.uin = i;
            this.bQQ = strArr;
            this.nickname = str;
            this.appId = str2;
            this.userName = str3;
        }
    }

    /* renamed from: a */
    public static boolean m30568a(Context context, C19744a c19744a, int i, boolean z) {
        AppMethodBeat.m2504i(129117);
        if (context == null || c19744a == null) {
            C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
            AppMethodBeat.m2505o(129117);
            return false;
        } else if (c19744a.bQQ == null) {
            C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "no such user");
            AppMethodBeat.m2505o(129117);
            return false;
        } else {
            Bitmap k = C19745u.m30569k(c19744a.bQQ);
            if (k == null) {
                C4990ab.m7416i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
                AppMethodBeat.m2505o(129117);
                return true;
            }
            Intent a = C19745u.m30564a(context, c19744a, i, C19745u.m30565a(context, k, i), true);
            if (a == null) {
                C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
                AppMethodBeat.m2505o(129117);
                return false;
            }
            String da;
            if (((Intent) a.getParcelableExtra("android.intent.extra.shortcut.INTENT")) != null) {
                da = C42781b.m75867da(c19744a.appId + String.valueOf(i), C1427q.m3026LK());
                if (da != null) {
                    da = C42781b.m75858V(da.getBytes());
                } else {
                    da = null;
                }
                C4990ab.m7417i("MicroMsg.AppBrandShortcutManager", "alvinluo appId: %s, shortcutId: %s", r5, da);
            } else {
                da = null;
            }
            try {
                C42781b.m75861a(context, a, da, z);
                C4990ab.m7417i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", c19744a.userName);
                AppMethodBeat.m2505o(129117);
                return true;
            } catch (IllegalStateException e) {
                C4990ab.m7420w("MicroMsg.AppBrandShortcutManager", e.toString());
                AppMethodBeat.m2505o(129117);
                return false;
            }
        }
    }

    /* renamed from: a */
    public static boolean m30567a(Context context, C19744a c19744a, int i) {
        AppMethodBeat.m2504i(129118);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "remove fail, context or config is null.");
            AppMethodBeat.m2505o(129118);
            return false;
        } else if (c19744a.bQQ == null) {
            C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "no such user");
            AppMethodBeat.m2505o(129118);
            return false;
        } else {
            Intent a = C19745u.m30564a(context, c19744a, i, C19745u.m30565a(context, C19745u.m30569k(c19744a.bQQ), i), false);
            if (a == null) {
                C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                AppMethodBeat.m2505o(129118);
                return false;
            }
            C42781b.m75870s(context, a);
            C4990ab.m7417i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", c19744a.userName);
            AppMethodBeat.m2505o(129118);
            return true;
        }
    }

    /* renamed from: a */
    private static Intent m30564a(Context context, C19744a c19744a, int i, Bitmap bitmap, boolean z) {
        AppMethodBeat.m2504i(129119);
        if (c19744a == null || context == null || c19744a.userName == null) {
            C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
            AppMethodBeat.m2505o(129119);
            return null;
        } else if (bitmap == null && z) {
            C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "no bmp");
            AppMethodBeat.m2505o(129119);
            return null;
        } else {
            String str = TextUtils.isEmpty(c19744a.nickname) ? c19744a.userName : c19744a.nickname;
            Intent a = C27305t.auu().mo45003a(context.getPackageName(), i, c19744a.userName, c19744a.nickname, c19744a.bQQ, c19744a.appId, c19744a.uin, 1);
            Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", str);
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.INTENT", a);
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            AppMethodBeat.m2505o(129119);
            return intent;
        }
    }

    /* renamed from: k */
    private static Bitmap m30569k(String[] strArr) {
        Bitmap a;
        AppMethodBeat.m2504i(129120);
        for (String str : strArr) {
            if (!C5046bo.isNullOrNil(str)) {
                a = C37926b.abR().mo60681a(str, null);
                if (!(a == null || a.isRecycled())) {
                    break;
                }
            }
        }
        a = null;
        AppMethodBeat.m2505o(129120);
        return a;
    }

    /* renamed from: a */
    private static Bitmap m30565a(Context context, Bitmap bitmap, int i) {
        Bitmap bitmap2 = null;
        AppMethodBeat.m2504i(129121);
        if (context == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(129121);
        } else {
            int density = (int) (C1338a.getDensity(context) * 48.0f);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, density, density, false);
            if (createScaledBitmap != null) {
                bitmap2 = createScaledBitmap.copy(Config.ARGB_8888, true);
                C4990ab.m7417i("MicroMsg.AppBrandShortcutManager", "bitmap recycle %s", createScaledBitmap);
                createScaledBitmap.recycle();
            }
            if (i == 2) {
                C19745u.m30566a(context, bitmap2, C1338a.m2858an(context, C25738R.string.f9059o3));
            } else if (i == 1) {
                C19745u.m30566a(context, bitmap2, C1338a.m2858an(context, C25738R.string.f9060o4));
            }
            AppMethodBeat.m2505o(129121);
        }
        return bitmap2;
    }

    /* renamed from: a */
    private static void m30566a(Context context, Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(129122);
        if (context == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(129122);
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129122);
        } else {
            RectF rectF;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float density = C1338a.getDensity(context);
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
            AppMethodBeat.m2505o(129122);
        }
    }
}
