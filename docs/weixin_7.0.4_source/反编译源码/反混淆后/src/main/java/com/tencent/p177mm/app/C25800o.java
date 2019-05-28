package com.tencent.p177mm.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.kernel.C26347k;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.splash.C5105d;
import com.tencent.p177mm.splash.C5115h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.app.o */
public final class C25800o {
    public static final C5105d ceX = new C258011();
    private static final HashSet ceY = new HashSet();

    /* renamed from: com.tencent.mm.app.o$a */
    public static final class C9005a {
        private static boolean ceZ = false;
        private static Class cfa;
        private static Field cfb;
        private static Class cfc;
        private static Field cfd;

        /* renamed from: h */
        public static String m16239h(Message message) {
            AppMethodBeat.m2504i(137991);
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
                    C4990ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", th, "", new Object[0]);
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
                    C4990ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", th2, "", new Object[0]);
                }
                if (intent != null) {
                    String className = intent.getComponent().getClassName();
                    AppMethodBeat.m2505o(137991);
                    return className;
                }
                AppMethodBeat.m2505o(137991);
                return null;
            }
            AppMethodBeat.m2505o(137991);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.app.o$1 */
    static class C258011 implements C5105d {
        C258011() {
        }

        /* renamed from: cV */
        public final boolean mo10477cV(String str) {
            AppMethodBeat.m2504i(138004);
            boolean cW = C25800o.m41031cW(str);
            AppMethodBeat.m2505o(138004);
            return cW;
        }

        /* renamed from: m */
        public final Activity mo10478m(Activity activity) {
            AppMethodBeat.m2504i(138005);
            Activity l = C25800o.m41032l(activity);
            AppMethodBeat.m2505o(138005);
            return l;
        }
    }

    /* renamed from: cW */
    static /* synthetic */ boolean m41031cW(String str) {
        AppMethodBeat.m2504i(137983);
        boolean cV = C25800o.m41030cV(str);
        AppMethodBeat.m2505o(137983);
        return cV;
    }

    static {
        AppMethodBeat.m2504i(137985);
        ceY.addAll(Arrays.asList(new String[]{"com.tencent.mm.plugin.card.ui.CardHomePageUI", "com.tencent.mm.plugin.card.ui.CardHomePageNewUI", "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI", "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", "com.tencent.mm.ui.chatting.ChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.readerapp.ui.ReaderAppUI", "com.tencent.mm.ui.SingleChatInfoUI", "com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI", "com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI", "com.tencent.mm.plugin.sns.ui.SnsBrowseUI", "com.tencent.mm.chatroom.ui.ChatroomInfoUI"}));
        AppMethodBeat.m2505o(137985);
    }

    /* renamed from: bg */
    private static boolean m41029bg(boolean z) {
        AppMethodBeat.m2504i(137980);
        if (!((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            if (z) {
                C4990ab.m7416i("MicroMsg.PreventAccountNotReady", "not main process");
            }
            AppMethodBeat.m2505o(137980);
            return true;
        } else if (C1720g.m3537RQ().eKs && C1720g.m3534RN().mo5161QY()) {
            if (z) {
                C4990ab.m7416i("MicroMsg.PreventAccountNotReady", "account hasInitialized");
            }
            AppMethodBeat.m2505o(137980);
            return true;
        } else {
            AppMethodBeat.m2505o(137980);
            return false;
        }
    }

    /* renamed from: cV */
    private static boolean m41030cV(String str) {
        AppMethodBeat.m2504i(137981);
        C4990ab.m7417i("MicroMsg.PreventAccountNotReady", "eatActivity %s", str);
        if (C25800o.m41029bg(true)) {
            AppMethodBeat.m2505o(137981);
            return false;
        }
        if (str != null) {
            if (ceY.contains(str)) {
                C4990ab.m7421w("MicroMsg.PreventAccountNotReady", "protect this activity %s", str);
                AppMethodBeat.m2505o(137981);
                return true;
            }
            try {
                C1720g.m3533RM();
                ActivityInfo activityInfo = ((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc.getPackageManager().getActivityInfo(new ComponentName(C4996ah.getPackageName(), str), 128);
                if (activityInfo != null) {
                    C4990ab.m7417i("MicroMsg.PreventAccountNotReady", "%s info.exported = %s", str, Boolean.valueOf(activityInfo.exported));
                    if (!activityInfo.exported) {
                        AppMethodBeat.m2505o(137981);
                        return true;
                    }
                }
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(137981);
        return false;
    }

    /* renamed from: Bx */
    public static void m41028Bx() {
        AppMethodBeat.m2504i(137982);
        ArrayList arrayList = new ArrayList();
        Iterator it = C5115h.xGD.iterator();
        while (it.hasNext()) {
            Message message = (Message) it.next();
            try {
                String h = C9005a.m16239h(message);
                if (h != null) {
                    int i;
                    if (((C26347k) Class.forName(h).getAnnotation(C26347k.class)) != null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        C5115h.m7783u(message);
                        C4990ab.m7417i("MicroMsg.PreventAccountNotReady", "replay message for %s", h);
                    }
                }
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", th, "", new Object[0]);
            }
            arrayList.add(message);
        }
        C5115h.xGD.clear();
        C5115h.xGD.addAll(arrayList);
        AppMethodBeat.m2505o(137982);
    }

    /* renamed from: l */
    static /* synthetic */ Activity m41032l(Activity activity) {
        AppMethodBeat.m2504i(137984);
        if (!(C25800o.m41029bg(false) || activity == null)) {
            int i;
            if (((C18524i) activity.getClass().getAnnotation(C18524i.class)) != null) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 != 0) {
                C4990ab.m7421w("MicroMsg.PreventAccountNotReady", "this activity %s need account but account not initiated, so we need replace it with a suicide activity.", activity);
                C45157s c45157s = new C45157s();
                AppMethodBeat.m2505o(137984);
                return c45157s;
            }
        }
        AppMethodBeat.m2505o(137984);
        return activity;
    }
}
