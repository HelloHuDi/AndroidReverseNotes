package com.tencent.mm.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.splash.d;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class o {
    public static final d ceX = new d() {
        public final boolean cV(String str) {
            AppMethodBeat.i(138004);
            boolean cW = o.cW(str);
            AppMethodBeat.o(138004);
            return cW;
        }

        public final Activity m(Activity activity) {
            AppMethodBeat.i(138005);
            Activity l = o.l(activity);
            AppMethodBeat.o(138005);
            return l;
        }
    };
    private static final HashSet ceY = new HashSet();

    public static final class a {
        private static boolean ceZ = false;
        private static Class cfa;
        private static Field cfb;
        private static Class cfc;
        private static Field cfd;

        public static String h(Message message) {
            AppMethodBeat.i(137991);
            if (!ceZ) {
                try {
                    Class cls = Class.forName("android.app.ActivityThread$ReceiverData");
                    cfa = cls;
                    Field declaredField = cls.getDeclaredField("intent");
                    cfb = declaredField;
                    declaredField.setAccessible(true);
                    cls = Class.forName("android.app.ActivityThread$CreateServiceData");
                    cfc = cls;
                    declaredField = cls.getDeclaredField("intent");
                    cfd = declaredField;
                    declaredField.setAccessible(true);
                    ceZ = true;
                } catch (Throwable th) {
                    ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", th, "", new Object[0]);
                }
            }
            if (ceZ) {
                Intent intent;
                try {
                    if (cfa.isInstance(message.obj)) {
                        intent = (Intent) cfb.get(message.obj);
                    } else {
                        if (cfc.isInstance(message.obj)) {
                            intent = (Intent) cfd.get(message.obj);
                        }
                        intent = null;
                    }
                } catch (Throwable th2) {
                    ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", th2, "", new Object[0]);
                }
                if (intent != null) {
                    String className = intent.getComponent().getClassName();
                    AppMethodBeat.o(137991);
                    return className;
                }
                AppMethodBeat.o(137991);
                return null;
            }
            AppMethodBeat.o(137991);
            return null;
        }
    }

    static /* synthetic */ boolean cW(String str) {
        AppMethodBeat.i(137983);
        boolean cV = cV(str);
        AppMethodBeat.o(137983);
        return cV;
    }

    static {
        AppMethodBeat.i(137985);
        ceY.addAll(Arrays.asList(new String[]{"com.tencent.mm.plugin.card.ui.CardHomePageUI", "com.tencent.mm.plugin.card.ui.CardHomePageNewUI", "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI", "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", "com.tencent.mm.ui.chatting.ChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.readerapp.ui.ReaderAppUI", "com.tencent.mm.ui.SingleChatInfoUI", "com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI", "com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI", "com.tencent.mm.plugin.sns.ui.SnsBrowseUI", "com.tencent.mm.chatroom.ui.ChatroomInfoUI"}));
        AppMethodBeat.o(137985);
    }

    private static boolean bg(boolean z) {
        AppMethodBeat.i(137980);
        if (!((h) g.RM().Rn()).SG()) {
            if (z) {
                ab.i("MicroMsg.PreventAccountNotReady", "not main process");
            }
            AppMethodBeat.o(137980);
            return true;
        } else if (g.RQ().eKs && g.RN().QY()) {
            if (z) {
                ab.i("MicroMsg.PreventAccountNotReady", "account hasInitialized");
            }
            AppMethodBeat.o(137980);
            return true;
        } else {
            AppMethodBeat.o(137980);
            return false;
        }
    }

    private static boolean cV(String str) {
        AppMethodBeat.i(137981);
        ab.i("MicroMsg.PreventAccountNotReady", "eatActivity %s", str);
        if (bg(true)) {
            AppMethodBeat.o(137981);
            return false;
        }
        if (str != null) {
            if (ceY.contains(str)) {
                ab.w("MicroMsg.PreventAccountNotReady", "protect this activity %s", str);
                AppMethodBeat.o(137981);
                return true;
            }
            try {
                g.RM();
                ActivityInfo activityInfo = ((h) g.RM().Rn()).cc.getPackageManager().getActivityInfo(new ComponentName(ah.getPackageName(), str), 128);
                if (activityInfo != null) {
                    ab.i("MicroMsg.PreventAccountNotReady", "%s info.exported = %s", str, Boolean.valueOf(activityInfo.exported));
                    if (!activityInfo.exported) {
                        AppMethodBeat.o(137981);
                        return true;
                    }
                }
            } catch (NameNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(137981);
        return false;
    }

    public static void Bx() {
        AppMethodBeat.i(137982);
        ArrayList arrayList = new ArrayList();
        Iterator it = com.tencent.mm.splash.h.xGD.iterator();
        while (it.hasNext()) {
            Message message = (Message) it.next();
            try {
                String h = a.h(message);
                if (h != null) {
                    int i;
                    if (((k) Class.forName(h).getAnnotation(k.class)) != null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        com.tencent.mm.splash.h.u(message);
                        ab.i("MicroMsg.PreventAccountNotReady", "replay message for %s", h);
                    }
                }
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", th, "", new Object[0]);
            }
            arrayList.add(message);
        }
        com.tencent.mm.splash.h.xGD.clear();
        com.tencent.mm.splash.h.xGD.addAll(arrayList);
        AppMethodBeat.o(137982);
    }

    static /* synthetic */ Activity l(Activity activity) {
        AppMethodBeat.i(137984);
        if (!(bg(false) || activity == null)) {
            int i;
            if (((i) activity.getClass().getAnnotation(i.class)) != null) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 != 0) {
                ab.w("MicroMsg.PreventAccountNotReady", "this activity %s need account but account not initiated, so we need replace it with a suicide activity.", activity);
                s sVar = new s();
                AppMethodBeat.o(137984);
                return sVar;
            }
        }
        AppMethodBeat.o(137984);
        return activity;
    }
}
