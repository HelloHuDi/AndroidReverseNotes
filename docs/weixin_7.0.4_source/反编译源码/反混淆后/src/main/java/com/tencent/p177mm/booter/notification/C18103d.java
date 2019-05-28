package com.tencent.p177mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.notification.p841a.C25977g;
import com.tencent.p177mm.booter.notification.queue.C9203b;
import com.tencent.p177mm.booter.notification.queue.NotificationQueue;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.booter.notification.d */
public final class C18103d {
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

    /* renamed from: z */
    public static void m28523z(String str, int i) {
        AppMethodBeat.m2504i(15943);
        if (C42252ah.isNullOrNil(str)) {
            C4990ab.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
            AppMethodBeat.m2505o(15943);
            return;
        }
        String Ft = C42781b.m75856Ft(str);
        if (C42252ah.isNullOrNil(Ft)) {
            AppMethodBeat.m2505o(15943);
            return;
        }
        C18103d.m28516A(Ft, i);
        AppMethodBeat.m2505o(15943);
    }

    /* renamed from: bx */
    public static void m28519bx(boolean z) {
        AppMethodBeat.m2504i(15944);
        if (edP) {
            Context context = C4996ah.getContext();
            if (context == null) {
                AppMethodBeat.m2505o(15944);
                return;
            }
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                AppMethodBeat.m2505o(15944);
                return;
            }
            try {
                C4990ab.m7416i("MicroMsg.BusinessNotification", "sync all user badge");
                Bundle call = contentResolver.call(edQ, "getShortcutList", null, null);
                if (call == null) {
                    C4990ab.m7416i("MicroMsg.BusinessNotification", "getShortcutList return null");
                    AppMethodBeat.m2505o(15944);
                    return;
                }
                String string = call.getString("shortcut_list");
                if (string != null) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        string = ((JSONObject) jSONArray.get(i)).getString("app_shortcut_custom_id");
                        if (!(string == null || string.equalsIgnoreCase(BuildConfig.COMMAND))) {
                            String Fs = C42781b.m75855Fs(string);
                            C18103d.m28523z(Fs, z ? 0 : C18559f.m28906kF(Fs));
                        }
                    }
                }
                AppMethodBeat.m2505o(15944);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BusinessNotification", e, "sync all user badge: no support getShortcutList", new Object[0]);
                AppMethodBeat.m2505o(15944);
                return;
            }
        }
        AppMethodBeat.m2505o(15944);
    }

    static {
        AppMethodBeat.m2504i(15950);
        AppMethodBeat.m2505o(15950);
    }

    /* renamed from: a */
    public static int m28518a(Notification notification, C25977g c25977g) {
        AppMethodBeat.m2504i(15945);
        if (notification == null || !edF) {
            AppMethodBeat.m2505o(15945);
            return 0;
        }
        int i;
        if (c25977g == null) {
            i = 0;
        } else {
            int i2 = c25977g.eeH;
            NotificationQueue notificationQueue = C9203b.m16707IP().eeh;
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
            C4990ab.m7417i("MicroMsg.BusinessNotification", "miuiNotification: %d", Integer.valueOf(i));
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
        AppMethodBeat.m2505o(15945);
        return i;
    }

    /* renamed from: IN */
    private static boolean m28517IN() {
        AppMethodBeat.m2504i(15946);
        if (edN) {
            boolean z = edM;
            AppMethodBeat.m2505o(15946);
            return z;
        }
        edN = true;
        if (Build.BRAND.equals(edL)) {
            edM = true;
            AppMethodBeat.m2505o(15946);
            return true;
        }
        edM = false;
        AppMethodBeat.m2505o(15946);
        return false;
    }

    /* renamed from: A */
    private static void m28516A(String str, int i) {
        AppMethodBeat.m2504i(15947);
        if (C4996ah.getContext() == null) {
            C4990ab.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
            AppMethodBeat.m2505o(15947);
            return;
        }
        Context context = C4996ah.getContext();
        if (i < 0) {
            i = C18559f.m28885Nr();
        }
        C18103d.m28520c(context, str, i);
        AppMethodBeat.m2505o(15947);
    }

    /* renamed from: c */
    private static boolean m28520c(final Context context, final String str, final int i) {
        AppMethodBeat.m2504i(15948);
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(15941);
                C18103d.m28521d(context, str, i);
                AppMethodBeat.m2505o(15941);
            }
        }, "normalNotification");
        AppMethodBeat.m2505o(15948);
        return true;
    }

    /* renamed from: in */
    public static void m28522in(int i) {
        boolean z;
        AppMethodBeat.m2504i(15942);
        if (C4996ah.getContext() != null && C18103d.m28517IN()) {
            Context context = C4996ah.getContext();
            int Nr = i == -1 ? C18559f.m28885Nr() : i;
            if (!(context == null || !C18103d.m28517IN() || edO == Nr)) {
                edO = Nr;
                Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                intent.putExtra("badge_count", Nr);
                intent.putExtra("badge_count_package_name", C4996ah.getPackageName());
                intent.putExtra("badge_count_class_name", LauncherUI.class.getName());
                C4990ab.m7417i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", Integer.valueOf(Nr), Build.BRAND);
                context.sendBroadcast(intent);
            }
        }
        if (edK) {
            if (VERSION.SDK_INT < 11) {
                edK = false;
            } else if (edJ != i) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("package", C4996ah.getPackageName());
                    bundle.putString("class", LauncherUI.class.getName());
                    bundle.putInt("badgenumber", i);
                    edK = C4996ah.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle) != null;
                    C4990ab.m7417i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", Integer.valueOf(i), Boolean.valueOf(edK));
                } catch (Exception e) {
                    C4990ab.m7416i("MicroMsg.BusinessNotification", "no huawei badge");
                    C4990ab.m7412e("MicroMsg.BusinessNotification", "alvin: no badge" + e.toString());
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
                intent2.putExtra(DownloadInfoColumns.PACKAGENAME, C4996ah.getPackageName());
                intent2.putExtra("className", LauncherUI.class.getName());
                intent2.putExtra("notificationNum", i);
                C4996ah.getContext().sendBroadcast(intent2);
                C4990ab.m7417i("MicroMsg.BusinessNotification", "vivo badge: %d", Integer.valueOf(i));
            } catch (Exception e2) {
                edG = false;
                C4990ab.printErrStackTrace("MicroMsg.BusinessNotification", e2, "", new Object[0]);
            }
        }
        C18103d.m28516A(null, i);
        AppMethodBeat.m2505o(15942);
    }

    /* renamed from: d */
    static /* synthetic */ void m28521d(Context context, String str, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(15949);
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
                bundle.putString("app_shortcut_class_name", C4996ah.doz() + ".ui.LauncherUI");
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null || contentResolver.call(edQ, "setAppBadgeCount", null, bundle) == null) {
                    z = false;
                }
                C4990ab.m7417i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", str, Integer.valueOf(i), Boolean.valueOf(z));
                AppMethodBeat.m2505o(15949);
                return;
            } catch (Exception e) {
                edP = false;
                C4990ab.m7412e("MicroMsg.BusinessNotification", "alvin: no support normal badge");
            }
        }
        AppMethodBeat.m2505o(15949);
    }
}
