package com.tencent.p177mm.plugin.base.model;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5661b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.base.model.b */
public final class C42781b {
    public static final String SOURCE_KEY = C4996ah.getPackageName();
    private static char[] fuo = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String jDl = "";

    static {
        AppMethodBeat.m2504i(79080);
        AppMethodBeat.m2505o(79080);
    }

    /* renamed from: Z */
    public static boolean m75859Z(Context context, String str) {
        AppMethodBeat.m2504i(79062);
        jDl = C1853r.m3846Yz();
        Intent a = C42781b.m75860a(context, str, true, jDl);
        Intent intent = (Intent) a.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        if (intent == null) {
            AppMethodBeat.m2505o(79062);
            return false;
        }
        C42781b.m75861a(context, a, intent.getStringExtra("app_shortcut_custom_id"), true);
        AppMethodBeat.m2505o(79062);
        return true;
    }

    /* renamed from: q */
    public static void m75868q(Context context, Intent intent) {
        AppMethodBeat.m2504i(79063);
        C42781b.m75861a(context, intent, null, true);
        AppMethodBeat.m2505o(79063);
    }

    /* renamed from: a */
    public static void m75861a(Context context, Intent intent, String str, boolean z) {
        AppMethodBeat.m2504i(79064);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "context is null");
            AppMethodBeat.m2505o(79064);
        } else if (intent == null) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "intent is null");
            AppMethodBeat.m2505o(79064);
        } else {
            boolean a;
            if (VERSION.SDK_INT < 26) {
                a = C42781b.m75862a(context, intent, z);
            } else {
                a = C42781b.m75865b(context, intent, str, z);
            }
            if (!a && z) {
                C42781b.m75866d(context, false, z);
            }
            AppMethodBeat.m2505o(79064);
        }
    }

    /* renamed from: r */
    public static void m75869r(Context context, Intent intent) {
        AppMethodBeat.m2504i(79065);
        C42781b.m75861a(context, intent, null, false);
        AppMethodBeat.m2505o(79065);
    }

    /* renamed from: a */
    private static boolean m75862a(Context context, Intent intent, boolean z) {
        AppMethodBeat.m2504i(79066);
        context.sendBroadcast(intent);
        C42781b.m75866d(context, true, z);
        AppMethodBeat.m2505o(79066);
        return true;
    }

    @TargetApi(26)
    /* renamed from: b */
    private static boolean m75865b(Context context, Intent intent, String str, boolean z) {
        AppMethodBeat.m2504i(79067);
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "shortcut manager is null");
            AppMethodBeat.m2505o(79067);
            return false;
        } else if (!shortcutManager.isRequestPinShortcutSupported()) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "alvinluo not support pin shortcuts");
            AppMethodBeat.m2505o(79067);
            return false;
        } else if (intent.getBooleanExtra("is_main_shortcut", false)) {
            C4990ab.m7416i("MicroMsg.ShortcutManager", "alvinluo main icon, do not create shortcut");
            AppMethodBeat.m2505o(79067);
            return false;
        } else {
            Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
            if (intent2 == null) {
                C4990ab.m7412e("MicroMsg.ShortcutManager", "alvinluo shortcut intent is null");
                AppMethodBeat.m2505o(79067);
                return false;
            }
            Object obj;
            int intExtra;
            if (C5046bo.isNullOrNil(str)) {
                str = intent2.getStringExtra("app_shortcut_custom_id");
            }
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.ShortcutManager", "alvinluo shortcutId is null, then use short name as shortcutId");
                str = intent.getStringExtra("android.intent.extra.shortcut.NAME");
                obj = 1;
            } else {
                obj = null;
            }
            C4990ab.m7417i("MicroMsg.ShortcutManager", "alvinluo shortcutId: %s", str);
            String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
            if (((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")) != null) {
                C4990ab.m7417i("MicroMsg.ShortcutManager", "alvinluo icon resource name: %s, %s", ((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")).resourceName, ((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")).packageName);
            }
            Bitmap bitmap = (Bitmap) intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
            if (bitmap == null) {
                C4990ab.m7416i("MicroMsg.ShortcutManager", "extra_shortcut_icon is null, use icon resource id");
                intExtra = intent.getIntExtra("shortcut_icon_resource_id", -1);
                if (intExtra == -1) {
                    C4990ab.m7412e("MicroMsg.ShortcutManager", "icon resource id is null");
                    AppMethodBeat.m2505o(79067);
                    return false;
                }
                bitmap = BitmapFactory.decodeResource(context.getResources(), intExtra);
            }
            if (bitmap == null) {
                C4990ab.m7412e("MicroMsg.ShortcutManager", "icon bitmap is null");
                AppMethodBeat.m2505o(79067);
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
            C4990ab.m7417i("MicroMsg.ShortcutManager", "alvinluo add shortcut above android o, duplicate: %b", Boolean.valueOf(intent.getBooleanExtra("duplicate", false)));
            if (intent.getBooleanExtra("duplicate", false)) {
                shortcutManager.requestPinShortcut(build, null);
                C42781b.m75866d(context, true, z);
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
                C4990ab.m7417i("MicroMsg.ShortcutManager", "alvinluo shortcut exist: %b, shortcutName: %s", Boolean.valueOf(z2), stringExtra);
                if (z2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(build);
                    boolean updateShortcuts = shortcutManager.updateShortcuts(arrayList);
                    C4990ab.m7417i("MicroMsg.ShortcutManager", "alvinluo update shortcuts result: %b", Boolean.valueOf(updateShortcuts));
                    C42781b.m75866d(context, true, z);
                } else if (z) {
                    intent2 = shortcutManager.createShortcutResultIntent(build);
                    intent2.setClass(context, ShortcutBroadCastReceiver.class);
                    shortcutManager.requestPinShortcut(build, PendingIntent.getBroadcast(context, 0, intent2, 134217728).getIntentSender());
                } else {
                    shortcutManager.requestPinShortcut(build, null);
                }
            }
            AppMethodBeat.m2505o(79067);
            return true;
        }
    }

    /* renamed from: d */
    private static void m75866d(Context context, boolean z, boolean z2) {
        AppMethodBeat.m2504i(79068);
        if (z2) {
            String string;
            if (z) {
                string = context.getString(C25738R.string.f8817fv);
            } else {
                string = context.getString(C25738R.string.f8815ft);
            }
            C30379h.m48465bQ(context, string);
        }
        AppMethodBeat.m2505o(79068);
    }

    /* renamed from: x */
    public static void m75871x(final Activity activity) {
        AppMethodBeat.m2504i(79069);
        if (!C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getBoolean("no_more_show_add_short_cut_dialog", false)) {
            final C5659a c5659a = new C5659a(activity);
            c5659a.asO(activity.getString(C25738R.string.ehk));
            String string = activity.getString(C25738R.string.ehl);
            String string2 = activity.getString(C25738R.string.ehj);
            c5659a.mo11514al(string);
            c5659a.asL(string2);
            c5659a.mo11509Qg(C25738R.string.f9151r4);
            c5659a.zQM = true;
            c5659a.mo11511a(new C5661b() {
                /* renamed from: s */
                public final void mo11528s(boolean z, boolean z2) {
                    AppMethodBeat.m2504i(79061);
                    c5659a.gud.dismiss();
                    if (z2) {
                        activity.getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("no_more_show_add_short_cut_dialog", true).apply();
                    }
                    AppMethodBeat.m2505o(79061);
                }
            });
            c5659a.show();
        }
        AppMethodBeat.m2505o(79069);
    }

    /* renamed from: aa */
    public static boolean m75863aa(Context context, String str) {
        AppMethodBeat.m2504i(79070);
        jDl = C1853r.m3846Yz();
        C42781b.m75870s(context, C42781b.m75860a(context, str, false, jDl));
        AppMethodBeat.m2505o(79070);
        return true;
    }

    /* renamed from: s */
    public static boolean m75870s(Context context, Intent intent) {
        AppMethodBeat.m2504i(79071);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "context is null");
            AppMethodBeat.m2505o(79071);
            return false;
        } else if (intent == null) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "intent is null");
            AppMethodBeat.m2505o(79071);
            return false;
        } else if (VERSION.SDK_INT < 26) {
            context.sendBroadcast(intent);
            AppMethodBeat.m2505o(79071);
            return true;
        } else {
            AppMethodBeat.m2505o(79071);
            return true;
        }
    }

    /* renamed from: a */
    private static Intent m75860a(Context context, String str, boolean z, String str2) {
        AppMethodBeat.m2504i(79072);
        if (str == null || context == null) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "getIntent, wrong parameters");
            AppMethodBeat.m2505o(79072);
            return null;
        }
        Bitmap ab = C42781b.m75864ab(context, str);
        if (ab == null) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "no bmp");
            AppMethodBeat.m2505o(79072);
            return null;
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "no such user");
            AppMethodBeat.m2505o(79072);
            return null;
        }
        String Ft = C42781b.m75856Ft(str);
        C4990ab.m7417i("MicroMsg.ShortcutManager", "alvinluo encryptShortcutUser: %s", Ft);
        if (C5046bo.isNullOrNil(Ft)) {
            AppMethodBeat.m2505o(79072);
            return null;
        }
        Intent intent = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent.putExtra("LauncherUI.Shortcut.Username", Ft);
        intent.putExtra("LauncherUI.From.Biz.Shortcut", true);
        intent.putExtra("app_shortcut_custom_id", Ft);
        intent.setPackage(context.getPackageName());
        intent.addFlags(67108864);
        Intent intent2 = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.NAME", C1855t.m3879a(aoO, str));
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON", ab);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_SOURCE_KEY", SOURCE_KEY);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_OWNER_ID", C42781b.m75856Ft(str2));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_UNIQUE_ID", Ft);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_TYPE", C42781b.m75854C(aoO));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_CONTAINER", 0);
        AppMethodBeat.m2505o(79072);
        return intent2;
    }

    /* renamed from: ab */
    private static Bitmap m75864ab(Context context, String str) {
        AppMethodBeat.m2504i(79073);
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        Bitmap a = C41730b.m73490a(str, false, -1);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "getScaledBitmap fail, bmp is null");
            a = C5056d.m7610LV(C25738R.drawable.ad2);
        }
        if (a == null) {
            C4990ab.m7412e("MicroMsg.ShortcutManager", "use default avatar, bmp is null");
            AppMethodBeat.m2505o(79073);
            return null;
        }
        a = Bitmap.createScaledBitmap(a, i, i, false);
        AppMethodBeat.m2505o(79073);
        return a;
    }

    /* renamed from: C */
    public static int m75854C(C7616ad c7616ad) {
        AppMethodBeat.m2504i(79074);
        if (c7616ad.dsf()) {
            AppMethodBeat.m2505o(79074);
            return 2;
        } else if (C1855t.m3924nJ(c7616ad.field_username)) {
            AppMethodBeat.m2505o(79074);
            return 0;
        } else {
            AppMethodBeat.m2505o(79074);
            return 1;
        }
    }

    /* renamed from: da */
    public static String m75867da(String str, String str2) {
        AppMethodBeat.m2504i(79075);
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
            AppMethodBeat.m2505o(79075);
            return str3;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ShortcutManager", "Exception in rc4, %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ShortcutManager", e, "", new Object[0]);
            AppMethodBeat.m2505o(79075);
            return null;
        }
    }

    /* renamed from: Fs */
    public static String m75855Fs(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(79076);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(79076);
            return str2;
        }
        String aw = C5046bo.m7524aw(C4996ah.getContext(), Process.myPid());
        String packageName = C4996ah.getPackageName();
        C4990ab.m7417i("MicroMsg.ShortcutManager", "process name: %s", aw);
        try {
            int QF;
            if (!packageName.equals(aw)) {
                QF = C1892aa.ano().gcU.mo5495QF();
            } else if (C1720g.m3534RN().mo5161QY()) {
                C1720g.m3534RN();
                QF = C1668a.m3383QF();
            } else {
                AppMethodBeat.m2505o(79076);
                return str2;
            }
            if (str.startsWith("shortcut_")) {
                str = C42781b.m75867da(new String(C42781b.m75857Fu(str.substring(9))), String.valueOf(QF));
                AppMethodBeat.m2505o(79076);
                return str;
            }
            AppMethodBeat.m2505o(79076);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ShortcutManager", str2, "exception: %s", e.getMessage());
            AppMethodBeat.m2505o(79076);
            return str2;
        }
    }

    /* renamed from: Ft */
    public static String m75856Ft(String str) {
        AppMethodBeat.m2504i(79077);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(79077);
            return null;
        }
        String aw = C5046bo.m7524aw(C4996ah.getContext(), Process.myPid());
        String packageName = C4996ah.getPackageName();
        if (!packageName.equals(aw) || C1720g.m3534RN().mo5161QY()) {
            C4990ab.m7417i("MicroMsg.ShortcutManager", "process name: %s", aw);
            try {
                if (packageName.equals(aw)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    C1720g.m3534RN();
                    aw = C42781b.m75867da(str, stringBuilder.append(C1668a.m3383QF()).toString());
                } else {
                    aw = C42781b.m75867da(str, C1892aa.ano().gcU.mo5495QF());
                }
                if (C5046bo.isNullOrNil(aw)) {
                    AppMethodBeat.m2505o(79077);
                    return null;
                }
                aw = "shortcut_" + C42781b.m75858V(aw.getBytes());
                AppMethodBeat.m2505o(79077);
                return aw;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", e.getMessage());
                AppMethodBeat.m2505o(79077);
                return null;
            }
        }
        AppMethodBeat.m2505o(79077);
        return null;
    }

    /* renamed from: V */
    public static String m75858V(byte[] bArr) {
        AppMethodBeat.m2504i(79078);
        if (bArr == null) {
            AppMethodBeat.m2505o(79078);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(fuo[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(fuo[bArr[i] & 15]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(79078);
        return stringBuilder2;
    }

    /* renamed from: Fu */
    public static final byte[] m75857Fu(String str) {
        AppMethodBeat.m2504i(79079);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(79079);
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        AppMethodBeat.m2505o(79079);
        return bArr;
    }
}
