package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.m.f;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static boolean edF = true;
    private static boolean edG = true;
    private static boolean edH = false;
    private static int edI = -1;
    private static int edJ = -1;
    private static boolean edK = true;
    private static String edL = "samsung";
    public static boolean edM = true;
    public static boolean edN = false;
    private static int edO = -1;
    private static boolean edP = true;
    private static Uri edQ = Uri.parse("content://com.android.badge/badge");

    public static void z(String str, int i) {
        AppMethodBeat.i(15943);
        if (ah.isNullOrNil(str)) {
            ab.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
            AppMethodBeat.o(15943);
            return;
        }
        String Ft = b.Ft(str);
        if (ah.isNullOrNil(Ft)) {
            AppMethodBeat.o(15943);
            return;
        }
        A(Ft, i);
        AppMethodBeat.o(15943);
    }

    public static void bx(boolean z) {
        AppMethodBeat.i(15944);
        if (edP) {
            Context context = com.tencent.mm.sdk.platformtools.ah.getContext();
            if (context == null) {
                AppMethodBeat.o(15944);
                return;
            }
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                AppMethodBeat.o(15944);
                return;
            }
            try {
                ab.i("MicroMsg.BusinessNotification", "sync all user badge");
                Bundle call = contentResolver.call(edQ, "getShortcutList", null, null);
                if (call == null) {
                    ab.i("MicroMsg.BusinessNotification", "getShortcutList return null");
                    AppMethodBeat.o(15944);
                    return;
                }
                String string = call.getString("shortcut_list");
                if (string != null) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        string = ((JSONObject) jSONArray.get(i)).getString("app_shortcut_custom_id");
                        if (!(string == null || string.equalsIgnoreCase(BuildConfig.COMMAND))) {
                            String Fs = b.Fs(string);
                            z(Fs, z ? 0 : f.kF(Fs));
                        }
                    }
                }
                AppMethodBeat.o(15944);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BusinessNotification", e, "sync all user badge: no support getShortcutList", new Object[0]);
                AppMethodBeat.o(15944);
                return;
            }
        }
        AppMethodBeat.o(15944);
    }

    static {
        AppMethodBeat.i(15950);
        AppMethodBeat.o(15950);
    }

    public static int a(Notification notification, g gVar) {
        AppMethodBeat.i(15945);
        if (notification == null || !edF) {
            AppMethodBeat.o(15945);
            return 0;
        }
        int i;
        if (gVar == null) {
            i = 0;
        } else {
            int i2 = gVar.eeH;
            NotificationQueue notificationQueue = com.tencent.mm.booter.notification.queue.b.IP().eeh;
            if (notificationQueue.eeg == null) {
                notificationQueue.restore();
            }
            Iterator it = notificationQueue.eeg.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 = ((NotificationItem) it.next()).eea + i3;
            }
            i = i2 - i3;
        }
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, Integer.valueOf(i));
            notification.getClass().getField("extraNotification").set(notification, newInstance);
            ab.i("MicroMsg.BusinessNotification", "miuiNotification: %d", Integer.valueOf(i));
        } catch (NoSuchFieldException e) {
            edF = false;
        } catch (IllegalArgumentException e2) {
            edF = false;
        } catch (IllegalAccessException e3) {
            edF = false;
        } catch (ClassNotFoundException e4) {
            edF = false;
        } catch (InstantiationException e5) {
            edF = false;
        } catch (Exception e6) {
            edF = false;
        }
        AppMethodBeat.o(15945);
        return i;
    }

    private static boolean IN() {
        AppMethodBeat.i(15946);
        if (edN) {
            boolean z = edM;
            AppMethodBeat.o(15946);
            return z;
        }
        edN = true;
        if (Build.BRAND.equals(edL)) {
            edM = true;
            AppMethodBeat.o(15946);
            return true;
        }
        edM = false;
        AppMethodBeat.o(15946);
        return false;
    }

    private static void A(String str, int i) {
        AppMethodBeat.i(15947);
        if (com.tencent.mm.sdk.platformtools.ah.getContext() == null) {
            ab.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
            AppMethodBeat.o(15947);
            return;
        }
        Context context = com.tencent.mm.sdk.platformtools.ah.getContext();
        if (i < 0) {
            i = f.Nr();
        }
        c(context, str, i);
        AppMethodBeat.o(15947);
    }

    private static boolean c(final Context context, final String str, final int i) {
        AppMethodBeat.i(15948);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(15941);
                d.d(context, str, i);
                AppMethodBeat.o(15941);
            }
        }, "normalNotification");
        AppMethodBeat.o(15948);
        return true;
    }

    public static void in(int i) {
        boolean z;
        AppMethodBeat.i(15942);
        if (com.tencent.mm.sdk.platformtools.ah.getContext() != null && IN()) {
            Context context = com.tencent.mm.sdk.platformtools.ah.getContext();
            int Nr = i == -1 ? f.Nr() : i;
            if (!(context == null || !IN() || edO == Nr)) {
                edO = Nr;
                Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                intent.putExtra("badge_count", Nr);
                intent.putExtra("badge_count_package_name", com.tencent.mm.sdk.platformtools.ah.getPackageName());
                intent.putExtra("badge_count_class_name", LauncherUI.class.getName());
                ab.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", Integer.valueOf(Nr), Build.BRAND);
                context.sendBroadcast(intent);
            }
        }
        if (edK) {
            if (VERSION.SDK_INT < 11) {
                edK = false;
            } else if (edJ != i) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("package", com.tencent.mm.sdk.platformtools.ah.getPackageName());
                    bundle.putString("class", LauncherUI.class.getName());
                    bundle.putInt("badgenumber", i);
                    edK = com.tencent.mm.sdk.platformtools.ah.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle) != null;
                    ab.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", Integer.valueOf(i), Boolean.valueOf(edK));
                } catch (Exception e) {
                    ab.i("MicroMsg.BusinessNotification", "no huawei badge");
                    ab.e("MicroMsg.BusinessNotification", "alvin: no badge" + e.toString());
                    edK = false;
                }
            }
        }
        if (edH) {
            z = edG;
        } else {
            edH = true;
            if (Build.BRAND.equals("vivo")) {
                edG = true;
                z = true;
            } else {
                edG = false;
                z = false;
            }
        }
        if (z && edI != i) {
            try {
                Intent intent2 = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                intent2.putExtra(DownloadInfoColumns.PACKAGENAME, com.tencent.mm.sdk.platformtools.ah.getPackageName());
                intent2.putExtra("className", LauncherUI.class.getName());
                intent2.putExtra("notificationNum", i);
                com.tencent.mm.sdk.platformtools.ah.getContext().sendBroadcast(intent2);
                ab.i("MicroMsg.BusinessNotification", "vivo badge: %d", Integer.valueOf(i));
            } catch (Exception e2) {
                edG = false;
                ab.printErrStackTrace("MicroMsg.BusinessNotification", e2, "", new Object[0]);
            }
        }
        A(null, i);
        AppMethodBeat.o(15942);
    }

    static /* synthetic */ void d(Context context, String str, int i) {
        boolean z = true;
        AppMethodBeat.i(15949);
        if (edP) {
            try {
                Bundle bundle = new Bundle();
                if (str != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    bundle.putStringArrayList("app_shortcut_custom_id", arrayList);
                } else {
                    bundle.putStringArrayList("app_shortcut_custom_id", null);
                }
                bundle.putInt("app_badge_count", i);
                bundle.putString("app_shortcut_class_name", com.tencent.mm.sdk.platformtools.ah.doz() + ".ui.LauncherUI");
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null || contentResolver.call(edQ, "setAppBadgeCount", null, bundle) == null) {
                    z = false;
                }
                ab.i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", str, Integer.valueOf(i), Boolean.valueOf(z));
                AppMethodBeat.o(15949);
                return;
            } catch (Exception e) {
                edP = false;
                ab.e("MicroMsg.BusinessNotification", "alvin: no support normal badge");
            }
        }
        AppMethodBeat.o(15949);
    }
}
