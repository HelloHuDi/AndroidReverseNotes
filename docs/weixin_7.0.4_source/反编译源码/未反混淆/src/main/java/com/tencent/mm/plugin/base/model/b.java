package com.tencent.mm.plugin.base.model;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static final String SOURCE_KEY = ah.getPackageName();
    private static char[] fuo = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String jDl = "";

    static {
        AppMethodBeat.i(79080);
        AppMethodBeat.o(79080);
    }

    public static boolean Z(Context context, String str) {
        AppMethodBeat.i(79062);
        jDl = r.Yz();
        Intent a = a(context, str, true, jDl);
        Intent intent = (Intent) a.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        if (intent == null) {
            AppMethodBeat.o(79062);
            return false;
        }
        a(context, a, intent.getStringExtra("app_shortcut_custom_id"), true);
        AppMethodBeat.o(79062);
        return true;
    }

    public static void q(Context context, Intent intent) {
        AppMethodBeat.i(79063);
        a(context, intent, null, true);
        AppMethodBeat.o(79063);
    }

    public static void a(Context context, Intent intent, String str, boolean z) {
        AppMethodBeat.i(79064);
        if (context == null) {
            ab.e("MicroMsg.ShortcutManager", "context is null");
            AppMethodBeat.o(79064);
        } else if (intent == null) {
            ab.e("MicroMsg.ShortcutManager", "intent is null");
            AppMethodBeat.o(79064);
        } else {
            boolean a;
            if (VERSION.SDK_INT < 26) {
                a = a(context, intent, z);
            } else {
                a = b(context, intent, str, z);
            }
            if (!a && z) {
                d(context, false, z);
            }
            AppMethodBeat.o(79064);
        }
    }

    public static void r(Context context, Intent intent) {
        AppMethodBeat.i(79065);
        a(context, intent, null, false);
        AppMethodBeat.o(79065);
    }

    private static boolean a(Context context, Intent intent, boolean z) {
        AppMethodBeat.i(79066);
        context.sendBroadcast(intent);
        d(context, true, z);
        AppMethodBeat.o(79066);
        return true;
    }

    @TargetApi(26)
    private static boolean b(Context context, Intent intent, String str, boolean z) {
        AppMethodBeat.i(79067);
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null) {
            ab.e("MicroMsg.ShortcutManager", "shortcut manager is null");
            AppMethodBeat.o(79067);
            return false;
        } else if (!shortcutManager.isRequestPinShortcutSupported()) {
            ab.e("MicroMsg.ShortcutManager", "alvinluo not support pin shortcuts");
            AppMethodBeat.o(79067);
            return false;
        } else if (intent.getBooleanExtra("is_main_shortcut", false)) {
            ab.i("MicroMsg.ShortcutManager", "alvinluo main icon, do not create shortcut");
            AppMethodBeat.o(79067);
            return false;
        } else {
            Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
            if (intent2 == null) {
                ab.e("MicroMsg.ShortcutManager", "alvinluo shortcut intent is null");
                AppMethodBeat.o(79067);
                return false;
            }
            Object obj;
            int intExtra;
            if (bo.isNullOrNil(str)) {
                str = intent2.getStringExtra("app_shortcut_custom_id");
            }
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.ShortcutManager", "alvinluo shortcutId is null, then use short name as shortcutId");
                str = intent.getStringExtra("android.intent.extra.shortcut.NAME");
                obj = 1;
            } else {
                obj = null;
            }
            ab.i("MicroMsg.ShortcutManager", "alvinluo shortcutId: %s", str);
            String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
            if (((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")) != null) {
                ab.i("MicroMsg.ShortcutManager", "alvinluo icon resource name: %s, %s", ((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")).resourceName, ((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")).packageName);
            }
            Bitmap bitmap = (Bitmap) intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
            if (bitmap == null) {
                ab.i("MicroMsg.ShortcutManager", "extra_shortcut_icon is null, use icon resource id");
                intExtra = intent.getIntExtra("shortcut_icon_resource_id", -1);
                if (intExtra == -1) {
                    ab.e("MicroMsg.ShortcutManager", "icon resource id is null");
                    AppMethodBeat.o(79067);
                    return false;
                }
                bitmap = BitmapFactory.decodeResource(context.getResources(), intExtra);
            }
            if (bitmap == null) {
                ab.e("MicroMsg.ShortcutManager", "icon bitmap is null");
                AppMethodBeat.o(79067);
                return false;
            }
            boolean booleanExtra = intent.getBooleanExtra("shortcut_is_adaptive_icon", false);
            Builder intent3 = new Builder(context, str).setShortLabel(intent.getStringExtra("android.intent.extra.shortcut.NAME")).setLongLabel(intent.getStringExtra("android.intent.extra.shortcut.NAME")).setIntent(intent2);
            if (booleanExtra) {
                intent3.setIcon(Icon.createWithBitmap(bitmap));
            } else {
                intent3.setIcon(Icon.createWithAdaptiveBitmap(bitmap));
            }
            ShortcutInfo build = intent3.build();
            ab.i("MicroMsg.ShortcutManager", "alvinluo add shortcut above android o, duplicate: %b", Boolean.valueOf(intent.getBooleanExtra("duplicate", false)));
            if (intent.getBooleanExtra("duplicate", false)) {
                shortcutManager.requestPinShortcut(build, null);
                d(context, true, z);
            } else {
                boolean z2;
                List pinnedShortcuts = shortcutManager.getPinnedShortcuts();
                int i = 0;
                while (true) {
                    intExtra = i;
                    if (intExtra >= pinnedShortcuts.size()) {
                        z2 = false;
                        break;
                    }
                    ShortcutInfo shortcutInfo = (ShortcutInfo) pinnedShortcuts.get(intExtra);
                    if (obj == null) {
                        if (shortcutInfo != null && shortcutInfo.getId().equals(str)) {
                            z2 = true;
                            break;
                        }
                    } else if (!(shortcutInfo == null || shortcutInfo.getShortLabel() == null || !shortcutInfo.getShortLabel().equals(stringExtra))) {
                        z2 = true;
                        break;
                    }
                    i = intExtra + 1;
                }
                ab.i("MicroMsg.ShortcutManager", "alvinluo shortcut exist: %b, shortcutName: %s", Boolean.valueOf(z2), stringExtra);
                if (z2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(build);
                    boolean updateShortcuts = shortcutManager.updateShortcuts(arrayList);
                    ab.i("MicroMsg.ShortcutManager", "alvinluo update shortcuts result: %b", Boolean.valueOf(updateShortcuts));
                    d(context, true, z);
                } else if (z) {
                    intent2 = shortcutManager.createShortcutResultIntent(build);
                    intent2.setClass(context, ShortcutBroadCastReceiver.class);
                    shortcutManager.requestPinShortcut(build, PendingIntent.getBroadcast(context, 0, intent2, 134217728).getIntentSender());
                } else {
                    shortcutManager.requestPinShortcut(build, null);
                }
            }
            AppMethodBeat.o(79067);
            return true;
        }
    }

    private static void d(Context context, boolean z, boolean z2) {
        AppMethodBeat.i(79068);
        if (z2) {
            String string;
            if (z) {
                string = context.getString(R.string.fv);
            } else {
                string = context.getString(R.string.ft);
            }
            h.bQ(context, string);
        }
        AppMethodBeat.o(79068);
    }

    public static void x(final Activity activity) {
        AppMethodBeat.i(79069);
        if (!ah.getContext().getSharedPreferences(ah.doA(), 0).getBoolean("no_more_show_add_short_cut_dialog", false)) {
            final a aVar = new a(activity);
            aVar.asO(activity.getString(R.string.ehk));
            String string = activity.getString(R.string.ehl);
            String string2 = activity.getString(R.string.ehj);
            aVar.al(string);
            aVar.asL(string2);
            aVar.Qg(R.string.r4);
            aVar.zQM = true;
            aVar.a(new com.tencent.mm.ui.widget.a.e.b() {
                public final void s(boolean z, boolean z2) {
                    AppMethodBeat.i(79061);
                    aVar.gud.dismiss();
                    if (z2) {
                        activity.getSharedPreferences(ah.doA(), 0).edit().putBoolean("no_more_show_add_short_cut_dialog", true).apply();
                    }
                    AppMethodBeat.o(79061);
                }
            });
            aVar.show();
        }
        AppMethodBeat.o(79069);
    }

    public static boolean aa(Context context, String str) {
        AppMethodBeat.i(79070);
        jDl = r.Yz();
        s(context, a(context, str, false, jDl));
        AppMethodBeat.o(79070);
        return true;
    }

    public static boolean s(Context context, Intent intent) {
        AppMethodBeat.i(79071);
        if (context == null) {
            ab.e("MicroMsg.ShortcutManager", "context is null");
            AppMethodBeat.o(79071);
            return false;
        } else if (intent == null) {
            ab.e("MicroMsg.ShortcutManager", "intent is null");
            AppMethodBeat.o(79071);
            return false;
        } else if (VERSION.SDK_INT < 26) {
            context.sendBroadcast(intent);
            AppMethodBeat.o(79071);
            return true;
        } else {
            AppMethodBeat.o(79071);
            return true;
        }
    }

    private static Intent a(Context context, String str, boolean z, String str2) {
        AppMethodBeat.i(79072);
        if (str == null || context == null) {
            ab.e("MicroMsg.ShortcutManager", "getIntent, wrong parameters");
            AppMethodBeat.o(79072);
            return null;
        }
        Bitmap ab = ab(context, str);
        if (ab == null) {
            ab.e("MicroMsg.ShortcutManager", "no bmp");
            AppMethodBeat.o(79072);
            return null;
        }
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            ab.e("MicroMsg.ShortcutManager", "no such user");
            AppMethodBeat.o(79072);
            return null;
        }
        String Ft = Ft(str);
        ab.i("MicroMsg.ShortcutManager", "alvinluo encryptShortcutUser: %s", Ft);
        if (bo.isNullOrNil(Ft)) {
            AppMethodBeat.o(79072);
            return null;
        }
        Intent intent = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent.putExtra("LauncherUI.Shortcut.Username", Ft);
        intent.putExtra("LauncherUI.From.Biz.Shortcut", true);
        intent.putExtra("app_shortcut_custom_id", Ft);
        intent.setPackage(context.getPackageName());
        intent.addFlags(67108864);
        Intent intent2 = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.NAME", t.a(aoO, str));
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON", ab);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_SOURCE_KEY", SOURCE_KEY);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_OWNER_ID", Ft(str2));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_UNIQUE_ID", Ft);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_TYPE", C(aoO));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_CONTAINER", 0);
        AppMethodBeat.o(79072);
        return intent2;
    }

    private static Bitmap ab(Context context, String str) {
        AppMethodBeat.i(79073);
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
        if (a == null) {
            ab.e("MicroMsg.ShortcutManager", "getScaledBitmap fail, bmp is null");
            a = d.LV(R.drawable.ad2);
        }
        if (a == null) {
            ab.e("MicroMsg.ShortcutManager", "use default avatar, bmp is null");
            AppMethodBeat.o(79073);
            return null;
        }
        a = Bitmap.createScaledBitmap(a, i, i, false);
        AppMethodBeat.o(79073);
        return a;
    }

    public static int C(ad adVar) {
        AppMethodBeat.i(79074);
        if (adVar.dsf()) {
            AppMethodBeat.o(79074);
            return 2;
        } else if (t.nJ(adVar.field_username)) {
            AppMethodBeat.o(79074);
            return 0;
        } else {
            AppMethodBeat.o(79074);
            return 1;
        }
    }

    public static String da(String str, String str2) {
        AppMethodBeat.i(79075);
        try {
            int i;
            int[] iArr = new int[256];
            byte[] bArr = new byte[256];
            for (i = 0; i < 256; i++) {
                iArr[i] = i;
            }
            for (i = 0; i < 256; i = (short) (i + 1)) {
                bArr[i] = (byte) str2.charAt(i % str2.length());
            }
            int i2 = 0;
            for (i = 0; i < 255; i++) {
                i2 = ((i2 + iArr[i]) + bArr[i]) % 256;
                int i3 = iArr[i];
                iArr[i] = iArr[i2];
                iArr[i2] = i3;
            }
            char[] toCharArray = str.toCharArray();
            char[] cArr = new char[toCharArray.length];
            i2 = 0;
            int i4 = 0;
            for (i = 0; i < toCharArray.length; i = (short) (i + 1)) {
                i2 = (i2 + 1) % 256;
                i4 = (i4 + iArr[i2]) % 256;
                int i5 = iArr[i2];
                iArr[i2] = iArr[i4];
                iArr[i4] = i5;
                cArr[i] = (char) (((char) iArr[(iArr[i2] + (iArr[i4] % 256)) % 256]) ^ toCharArray[i]);
            }
            String str3 = new String(cArr);
            AppMethodBeat.o(79075);
            return str3;
        } catch (Exception e) {
            ab.e("MicroMsg.ShortcutManager", "Exception in rc4, %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ShortcutManager", e, "", new Object[0]);
            AppMethodBeat.o(79075);
            return null;
        }
    }

    public static String Fs(String str) {
        String str2 = null;
        AppMethodBeat.i(79076);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(79076);
            return str2;
        }
        String aw = bo.aw(ah.getContext(), Process.myPid());
        String packageName = ah.getPackageName();
        ab.i("MicroMsg.ShortcutManager", "process name: %s", aw);
        try {
            int QF;
            if (!packageName.equals(aw)) {
                QF = aa.ano().gcU.QF();
            } else if (g.RN().QY()) {
                g.RN();
                QF = com.tencent.mm.kernel.a.QF();
            } else {
                AppMethodBeat.o(79076);
                return str2;
            }
            if (str.startsWith("shortcut_")) {
                str = da(new String(Fu(str.substring(9))), String.valueOf(QF));
                AppMethodBeat.o(79076);
                return str;
            }
            AppMethodBeat.o(79076);
            return str;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ShortcutManager", str2, "exception: %s", e.getMessage());
            AppMethodBeat.o(79076);
            return str2;
        }
    }

    public static String Ft(String str) {
        AppMethodBeat.i(79077);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(79077);
            return null;
        }
        String aw = bo.aw(ah.getContext(), Process.myPid());
        String packageName = ah.getPackageName();
        if (!packageName.equals(aw) || g.RN().QY()) {
            ab.i("MicroMsg.ShortcutManager", "process name: %s", aw);
            try {
                if (packageName.equals(aw)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    g.RN();
                    aw = da(str, stringBuilder.append(com.tencent.mm.kernel.a.QF()).toString());
                } else {
                    aw = da(str, aa.ano().gcU.QF());
                }
                if (bo.isNullOrNil(aw)) {
                    AppMethodBeat.o(79077);
                    return null;
                }
                aw = "shortcut_" + V(aw.getBytes());
                AppMethodBeat.o(79077);
                return aw;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", e.getMessage());
                AppMethodBeat.o(79077);
                return null;
            }
        }
        AppMethodBeat.o(79077);
        return null;
    }

    public static String V(byte[] bArr) {
        AppMethodBeat.i(79078);
        if (bArr == null) {
            AppMethodBeat.o(79078);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(fuo[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(fuo[bArr[i] & 15]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(79078);
        return stringBuilder2;
    }

    public static final byte[] Fu(String str) {
        AppMethodBeat.i(79079);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(79079);
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        AppMethodBeat.o(79079);
        return bArr;
    }
}
