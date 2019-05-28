package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.a.w;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    public static String edB = "com.tencent.preference.notification.key.unread.msg";
    public static String edC = "com.tencent.preference.notification.key.unread.talker";
    public static String edD = "com.tencent.preference.notification.key.all.notified.msgid";
    public g cfT = new g(this.mContext);
    Context mContext = ah.getContext();

    public static class a implements Serializable {
        public int edE;
        public String userName;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(15925);
            String str = "[" + this.userName + "(" + this.edE + ")]";
            AppMethodBeat.o(15925);
            return str;
        }
    }

    public c() {
        AppMethodBeat.i(15926);
        AppMethodBeat.o(15926);
    }

    public static Notification IJ() {
        AppMethodBeat.i(15927);
        Notification notification = new Notification();
        notification.icon = R.drawable.icon;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 300;
        notification.ledOffMS = 1000;
        AppMethodBeat.o(15927);
        return notification;
    }

    public static boolean a(String str, bi biVar, int i, boolean z) {
        AppMethodBeat.i(15928);
        ab.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
        if (!aw.RK()) {
            ab.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
            AppMethodBeat.o(15928);
            return false;
        } else if (biVar != null && eS(biVar.field_msgSvrId) && !z) {
            ab.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", Long.valueOf(biVar.field_msgSvrId));
            AppMethodBeat.o(15928);
            return false;
        } else if ((i & 1) == 0) {
            ab.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
            AppMethodBeat.o(15928);
            return false;
        } else {
            aw.ZK();
            if (com.tencent.mm.model.c.XI() && !r.ku(r.YF())) {
                r4 = new Object[4];
                aw.ZK();
                r4[2] = Boolean.valueOf(com.tencent.mm.model.c.XI());
                r4[3] = Boolean.valueOf(r.ku(r.YF()));
                ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", r4);
                AppMethodBeat.o(15928);
                return false;
            } else if (t.mT(str)) {
                jg jgVar = new jg();
                jgVar.cEu.czE = 3;
                com.tencent.mm.sdk.b.a.xxA.m(jgVar);
                if (!jgVar.cEv.cvi) {
                    jgVar = new jg();
                    jgVar.cEu.czE = 1;
                    jgVar.cEu.cEw = str;
                    jgVar.cEu.cEx = 3;
                    com.tencent.mm.sdk.b.a.xxA.m(jgVar);
                }
                ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
                AppMethodBeat.o(15928);
                return false;
            } else if (t.nN(str) || !(!t.mN(str) || t.nM(str) || biVar == null || biVar.apB(r.Yz()) || biVar.getType() == 64 || biVar == null || biVar.dtV())) {
                ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
                AppMethodBeat.o(15928);
                return false;
            } else {
                AppMethodBeat.o(15928);
                return true;
            }
        }
    }

    @TargetApi(11)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(15930);
        Notification a = a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, 0, null, null, 0, null, null, str4);
        AppMethodBeat.o(15930);
        return a;
    }

    @TargetApi(21)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i3, String str4, PendingIntent pendingIntent2, int i4, String str5, PendingIntent pendingIntent3, String str6) {
        AppMethodBeat.i(15931);
        android.support.v4.app.v.c bt = com.tencent.mm.bo.a.bt(this.mContext, com.tencent.mm.bo.a.dgM());
        if (i == -1) {
            i = com.tencent.mm.bo.a.bWV();
        }
        bt.dt().as(i).g(str3).EI = pendingIntent;
        bt.Fa = true;
        if (str != null) {
            bt.d(str);
        }
        if (str2 != null) {
            bt.e(str2);
        }
        bt.at(i2);
        if (bitmap != null) {
            bt.EL = bitmap;
        }
        if (notification != null) {
            if (notification.sound != null) {
                bt.b(notification.sound);
            }
            if (notification.vibrate != null) {
                bt.a(notification.vibrate);
            }
        }
        if (VERSION.SDK_INT >= 16) {
            if (str4 != null) {
                bt.a(i3, str4, pendingIntent2);
            }
            if (str5 != null) {
                bt.a(i4, str5, pendingIntent3);
            }
        }
        if (VERSION.SDK_INT >= 21) {
            bt.Fd = "msg";
            w wVar = new w();
            wVar.csR.username = str6;
            wVar.csR.title = str;
            com.tencent.mm.sdk.b.a.xxA.m(wVar);
            if (wVar.csR.csS != null) {
                bt.a(wVar.csR.csS);
            }
        }
        Notification build = bt.build();
        AppMethodBeat.o(15931);
        return build;
    }

    public static a a(List<a> list, String str) {
        AppMethodBeat.i(15932);
        if (list == null || str == null) {
            AppMethodBeat.o(15932);
            return null;
        }
        for (a aVar : list) {
            if (aVar.userName.equals(str)) {
                AppMethodBeat.o(15932);
                return aVar;
            }
        }
        AppMethodBeat.o(15932);
        return null;
    }

    public static int IK() {
        AppMethodBeat.i(15933);
        int i = com.tencent.mm.m.a.MA().getInt(edB, 0);
        AppMethodBeat.o(15933);
        return i;
    }

    public static ArrayList<a> IL() {
        AppMethodBeat.i(15934);
        ArrayList<a> arrayList;
        try {
            arrayList = (ArrayList) com.tencent.mm.booter.notification.queue.c.jQ(com.tencent.mm.m.a.MA().getString(edC, ""));
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
                AppMethodBeat.o(15934);
                return arrayList2;
            }
            AppMethodBeat.o(15934);
            return arrayList;
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
            arrayList = new ArrayList();
            AppMethodBeat.o(15934);
            return arrayList;
        } catch (IOException e2) {
            ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e2, "", new Object[0]);
            arrayList = new ArrayList();
            AppMethodBeat.o(15934);
            return arrayList;
        } catch (Exception e3) {
            ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e3, "Justin_Exception:%s", e3.getMessage());
            arrayList = new ArrayList();
            AppMethodBeat.o(15934);
            return arrayList;
        }
    }

    public static void f(ArrayList<a> arrayList) {
        AppMethodBeat.i(15935);
        if (arrayList == null) {
            com.tencent.mm.m.a.MA().edit().putString(edC, "").apply();
        } else {
            try {
                com.tencent.mm.m.a.MA().edit().putString(edC, com.tencent.mm.booter.notification.queue.c.a(new ArrayList(arrayList))).apply();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
                com.tencent.mm.m.a.MA().edit().putString(edC, "").apply();
            }
        }
        String str = "MicroMsg.Notification.AppMsg.Handle";
        String str2 = "saveTotalUnreadTalker %s";
        Object[] objArr = new Object[1];
        objArr[0] = arrayList == null ? BuildConfig.COMMAND : arrayList.toString();
        ab.i(str, str2, objArr);
        AppMethodBeat.o(15935);
    }

    public static void im(int i) {
        AppMethodBeat.i(15936);
        com.tencent.mm.m.a.MA().edit().putInt(edB, Math.max(0, i)).apply();
        ab.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", Integer.valueOf(r0));
        AppMethodBeat.o(15936);
    }

    public static void eR(long j) {
        AppMethodBeat.i(15937);
        if (j == 0) {
            AppMethodBeat.o(15937);
            return;
        }
        String IM = IM();
        if (IM.length() > AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS) {
            IM = IM.substring(IM.length() / 2, IM.length());
        }
        if (eS(j)) {
            AppMethodBeat.o(15937);
            return;
        }
        com.tencent.mm.m.a.MA().edit().putString(edD, IM + j + "%").apply();
        ab.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", IM);
        AppMethodBeat.o(15937);
    }

    public static boolean eS(long j) {
        AppMethodBeat.i(15938);
        if (j == 0) {
            AppMethodBeat.o(15938);
            return false;
        }
        ab.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", IM(), Long.valueOf(j));
        if (IM().contains(j + "%")) {
            AppMethodBeat.o(15938);
            return true;
        }
        AppMethodBeat.o(15938);
        return false;
    }

    private static String IM() {
        AppMethodBeat.i(15939);
        String string = com.tencent.mm.m.a.MA().getString(edD, "");
        AppMethodBeat.o(15939);
        return string;
    }

    public static void II() {
        AppMethodBeat.i(15940);
        com.tencent.mm.m.a.MA().edit().putString(edD, "").apply();
        AppMethodBeat.o(15940);
    }

    public final int a(NotificationItem notificationItem, g gVar) {
        AppMethodBeat.i(15929);
        if (o.gn(this.mContext)) {
            ab.i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
            if (f.DEBUG || f.PRE_RELEASE) {
                List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.processName.startsWith("com.tencent.mm") && o.a(runningAppProcessInfo) == 3) {
                            o.gm(this.mContext);
                        }
                    }
                }
            }
        } else if (!(VERSION.SDK_INT < 16 || notificationItem == null || notificationItem.Fl == null)) {
            notificationItem.Fl.priority = 1;
            if (!com.tencent.mm.m.a.MB()) {
                notificationItem.Fl.vibrate = new long[0];
                if (!(gVar.eeN || gVar.eeM)) {
                    notificationItem.Fl.priority = 0;
                }
            }
        }
        int a = super.a(notificationItem, gVar);
        AppMethodBeat.o(15929);
        return a;
    }
}
