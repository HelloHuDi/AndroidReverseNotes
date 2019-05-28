package com.tencent.p177mm.booter.notification;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.p057v4.app.C0363v.C0358c;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.notification.p841a.C25977g;
import com.tencent.p177mm.booter.notification.queue.C25980c;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p230g.p231a.C18435w;
import com.tencent.p177mm.p230g.p231a.C6499jg;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C40618o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C7620bi;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.booter.notification.c */
public final class C44684c extends C41902a {
    public static String edB = "com.tencent.preference.notification.key.unread.msg";
    public static String edC = "com.tencent.preference.notification.key.unread.talker";
    public static String edD = "com.tencent.preference.notification.key.all.notified.msgid";
    public C25977g cfT = new C25977g(this.mContext);
    Context mContext = C4996ah.getContext();

    /* renamed from: com.tencent.mm.booter.notification.c$a */
    public static class C44685a implements Serializable {
        public int edE;
        public String userName;

        private C44685a() {
        }

        public /* synthetic */ C44685a(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(15925);
            String str = "[" + this.userName + "(" + this.edE + ")]";
            AppMethodBeat.m2505o(15925);
            return str;
        }
    }

    public C44684c() {
        AppMethodBeat.m2504i(15926);
        AppMethodBeat.m2505o(15926);
    }

    /* renamed from: IJ */
    public static Notification m81264IJ() {
        AppMethodBeat.m2504i(15927);
        Notification notification = new Notification();
        notification.icon = C25738R.drawable.icon;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 300;
        notification.ledOffMS = 1000;
        AppMethodBeat.m2505o(15927);
        return notification;
    }

    /* renamed from: a */
    public static boolean m81269a(String str, C7620bi c7620bi, int i, boolean z) {
        AppMethodBeat.m2504i(15928);
        C4990ab.m7411d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
        if (!C9638aw.m17179RK()) {
            C4990ab.m7417i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(15928);
            return false;
        } else if (c7620bi != null && C44684c.m81271eS(c7620bi.field_msgSvrId) && !z) {
            C4990ab.m7417i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", Long.valueOf(c7620bi.field_msgSvrId));
            AppMethodBeat.m2505o(15928);
            return false;
        } else if ((i & 1) == 0) {
            C4990ab.m7417i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(15928);
            return false;
        } else {
            C9638aw.m17190ZK();
            if (C18628c.m29074XI() && !C1853r.m3855ku(C1853r.m3824YF())) {
                r4 = new Object[4];
                C9638aw.m17190ZK();
                r4[2] = Boolean.valueOf(C18628c.m29074XI());
                r4[3] = Boolean.valueOf(C1853r.m3855ku(C1853r.m3824YF()));
                C4990ab.m7417i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", r4);
                AppMethodBeat.m2505o(15928);
                return false;
            } else if (C1855t.m3907mT(str)) {
                C6499jg c6499jg = new C6499jg();
                c6499jg.cEu.czE = 3;
                C4879a.xxA.mo10055m(c6499jg);
                if (!c6499jg.cEv.cvi) {
                    c6499jg = new C6499jg();
                    c6499jg.cEu.czE = 1;
                    c6499jg.cEu.cEw = str;
                    c6499jg.cEu.cEx = 3;
                    C4879a.xxA.mo10055m(c6499jg);
                }
                C4990ab.m7417i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
                AppMethodBeat.m2505o(15928);
                return false;
            } else if (C1855t.m3928nN(str) || !(!C1855t.m3901mN(str) || C1855t.m3927nM(str) || c7620bi == null || c7620bi.apB(C1853r.m3846Yz()) || c7620bi.getType() == 64 || c7620bi == null || c7620bi.dtV())) {
                C4990ab.m7417i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
                AppMethodBeat.m2505o(15928);
                return false;
            } else {
                AppMethodBeat.m2505o(15928);
                return true;
            }
        }
    }

    @TargetApi(11)
    /* renamed from: a */
    public final Notification mo71726a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.m2504i(15930);
        Notification a = mo71725a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, 0, null, null, 0, null, null, str4);
        AppMethodBeat.m2505o(15930);
        return a;
    }

    @TargetApi(21)
    /* renamed from: a */
    public final Notification mo71725a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i3, String str4, PendingIntent pendingIntent2, int i4, String str5, PendingIntent pendingIntent3, String str6) {
        AppMethodBeat.m2504i(15931);
        C0358c bt = C45186a.m83262bt(this.mContext, C45186a.dgM());
        if (i == -1) {
            i = C45186a.bWV();
        }
        bt.mo622dt().mo616as(i).mo625g(str3).f362EI = pendingIntent;
        bt.f379Fa = true;
        if (str != null) {
            bt.mo621d(str);
        }
        if (str2 != null) {
            bt.mo623e(str2);
        }
        bt.mo617at(i2);
        if (bitmap != null) {
            bt.f365EL = bitmap;
        }
        if (notification != null) {
            if (notification.sound != null) {
                bt.mo619b(notification.sound);
            }
            if (notification.vibrate != null) {
                bt.mo615a(notification.vibrate);
            }
        }
        if (VERSION.SDK_INT >= 16) {
            if (str4 != null) {
                bt.mo610a(i3, str4, pendingIntent2);
            }
            if (str5 != null) {
                bt.mo610a(i4, str5, pendingIntent3);
            }
        }
        if (VERSION.SDK_INT >= 21) {
            bt.f382Fd = "msg";
            C18435w c18435w = new C18435w();
            c18435w.csR.username = str6;
            c18435w.csR.title = str;
            C4879a.xxA.mo10055m(c18435w);
            if (c18435w.csR.csS != null) {
                bt.mo612a(c18435w.csR.csS);
            }
        }
        Notification build = bt.build();
        AppMethodBeat.m2505o(15931);
        return build;
    }

    /* renamed from: a */
    public static C44685a m81268a(List<C44685a> list, String str) {
        AppMethodBeat.m2504i(15932);
        if (list == null || str == null) {
            AppMethodBeat.m2505o(15932);
            return null;
        }
        for (C44685a c44685a : list) {
            if (c44685a.userName.equals(str)) {
                AppMethodBeat.m2505o(15932);
                return c44685a;
            }
        }
        AppMethodBeat.m2505o(15932);
        return null;
    }

    /* renamed from: IK */
    public static int m81265IK() {
        AppMethodBeat.m2504i(15933);
        int i = C37885a.m63948MA().getInt(edB, 0);
        AppMethodBeat.m2505o(15933);
        return i;
    }

    /* renamed from: IL */
    public static ArrayList<C44685a> m81266IL() {
        AppMethodBeat.m2504i(15934);
        ArrayList<C44685a> arrayList;
        try {
            arrayList = (ArrayList) C25980c.m41444jQ(C37885a.m63948MA().getString(edC, ""));
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
                AppMethodBeat.m2505o(15934);
                return arrayList2;
            }
            AppMethodBeat.m2505o(15934);
            return arrayList;
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
            arrayList = new ArrayList();
            AppMethodBeat.m2505o(15934);
            return arrayList;
        } catch (IOException e2) {
            C4990ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e2, "", new Object[0]);
            arrayList = new ArrayList();
            AppMethodBeat.m2505o(15934);
            return arrayList;
        } catch (Exception e3) {
            C4990ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e3, "Justin_Exception:%s", e3.getMessage());
            arrayList = new ArrayList();
            AppMethodBeat.m2505o(15934);
            return arrayList;
        }
    }

    /* renamed from: f */
    public static void m81272f(ArrayList<C44685a> arrayList) {
        AppMethodBeat.m2504i(15935);
        if (arrayList == null) {
            C37885a.m63948MA().edit().putString(edC, "").apply();
        } else {
            try {
                C37885a.m63948MA().edit().putString(edC, C25980c.m41443a(new ArrayList(arrayList))).apply();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e, "", new Object[0]);
                C37885a.m63948MA().edit().putString(edC, "").apply();
            }
        }
        String str = "MicroMsg.Notification.AppMsg.Handle";
        String str2 = "saveTotalUnreadTalker %s";
        Object[] objArr = new Object[1];
        objArr[0] = arrayList == null ? BuildConfig.COMMAND : arrayList.toString();
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(15935);
    }

    /* renamed from: im */
    public static void m81273im(int i) {
        AppMethodBeat.m2504i(15936);
        C37885a.m63948MA().edit().putInt(edB, Math.max(0, i)).apply();
        C4990ab.m7417i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", Integer.valueOf(r0));
        AppMethodBeat.m2505o(15936);
    }

    /* renamed from: eR */
    public static void m81270eR(long j) {
        AppMethodBeat.m2504i(15937);
        if (j == 0) {
            AppMethodBeat.m2505o(15937);
            return;
        }
        String IM = C44684c.m81267IM();
        if (IM.length() > AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS) {
            IM = IM.substring(IM.length() / 2, IM.length());
        }
        if (C44684c.m81271eS(j)) {
            AppMethodBeat.m2505o(15937);
            return;
        }
        C37885a.m63948MA().edit().putString(edD, IM + j + "%").apply();
        C4990ab.m7411d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", IM);
        AppMethodBeat.m2505o(15937);
    }

    /* renamed from: eS */
    public static boolean m81271eS(long j) {
        AppMethodBeat.m2504i(15938);
        if (j == 0) {
            AppMethodBeat.m2505o(15938);
            return false;
        }
        C4990ab.m7411d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", C44684c.m81267IM(), Long.valueOf(j));
        if (C44684c.m81267IM().contains(j + "%")) {
            AppMethodBeat.m2505o(15938);
            return true;
        }
        AppMethodBeat.m2505o(15938);
        return false;
    }

    /* renamed from: IM */
    private static String m81267IM() {
        AppMethodBeat.m2504i(15939);
        String string = C37885a.m63948MA().getString(edD, "");
        AppMethodBeat.m2505o(15939);
        return string;
    }

    /* renamed from: II */
    public static void m81263II() {
        AppMethodBeat.m2504i(15940);
        C37885a.m63948MA().edit().putString(edD, "").apply();
        AppMethodBeat.m2505o(15940);
    }

    /* renamed from: a */
    public final int mo67551a(NotificationItem notificationItem, C25977g c25977g) {
        AppMethodBeat.m2504i(15929);
        if (C40618o.m70064gn(this.mContext)) {
            C4990ab.m7416i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
            if (C5058f.DEBUG || C5058f.PRE_RELEASE) {
                List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.processName.startsWith("com.tencent.mm") && C40618o.m70059a(runningAppProcessInfo) == 3) {
                            C40618o.m70063gm(this.mContext);
                        }
                    }
                }
            }
        } else if (!(VERSION.SDK_INT < 16 || notificationItem == null || notificationItem.f1223Fl == null)) {
            notificationItem.f1223Fl.priority = 1;
            if (!C37885a.m63949MB()) {
                notificationItem.f1223Fl.vibrate = new long[0];
                if (!(c25977g.eeN || c25977g.eeM)) {
                    notificationItem.f1223Fl.priority = 0;
                }
            }
        }
        int a = super.mo67551a(notificationItem, c25977g);
        AppMethodBeat.m2505o(15929);
        return a;
    }
}
