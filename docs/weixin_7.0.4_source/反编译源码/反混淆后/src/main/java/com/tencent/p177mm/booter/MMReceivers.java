package com.tencent.p177mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Looper;
import android.os.Process;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C26347k;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.network.C1892aa.C1893a;
import com.tencent.p177mm.p230g.p231a.C18335mw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C35986af;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.booter.MMReceivers */
public final class MMReceivers {

    @C26347k
    /* renamed from: com.tencent.mm.booter.MMReceivers$AlarmReceiver */
    public static class AlarmReceiver extends BroadcastReceiver {

        /* renamed from: com.tencent.mm.booter.MMReceivers$AlarmReceiver$1 */
        class C91811 implements Runnable {
            C91811() {
            }

            public final void run() {
                AppMethodBeat.m2504i(57766);
                C4879a.xxA.mo10048a(new C18335mw(), Looper.getMainLooper());
                C4990ab.m7416i("MicroMsg.AlarmReceiver", "onReceive() publish PushKeepAliveEvent");
                AppMethodBeat.m2505o(57766);
            }
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(57767);
            if (context == null || intent == null) {
                AppMethodBeat.m2505o(57767);
                return;
            }
            if (!C1668a.m3382Mz().getBoolean("keepaliveserviceswitch", false)) {
                C4990ab.m7416i("MicroMsg.AlarmReceiver", "onReceive() MMHandlerThread() publish PushKeepAliveEvent");
                C5004al.m7442n(new C91811(), 10000);
            }
            boolean booleanExtra = intent.getBooleanExtra("MMBoot_Bump", false);
            C4990ab.m7416i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(booleanExtra)));
            if (booleanExtra) {
                AlarmReceiver.m16678bp(context);
                AppMethodBeat.m2505o(57767);
                return;
            }
            if (!C1324b.m2837c(context, "alarm", true)) {
                AlarmReceiver.m16681bs(context);
                C4990ab.dot();
            }
            AppMethodBeat.m2505o(57767);
        }

        /* renamed from: bp */
        public static void m16678bp(Context context) {
            long j = 30000;
            AppMethodBeat.m2504i(57768);
            long dov = C35986af.dov();
            C4990ab.m7410d("MicroMsg.AlarmReceiver", "bumper comes, next=".concat(String.valueOf(dov)));
            if (dov > 1860000) {
                AppMethodBeat.m2505o(57768);
                return;
            }
            if (dov >= 30000) {
                j = dov;
            }
            AlarmReceiver.m16677a(j, context);
            AppMethodBeat.m2505o(57768);
        }

        /* renamed from: a */
        private static void m16677a(long j, Context context) {
            AppMethodBeat.m2504i(57769);
            C4990ab.m7420w("MicroMsg.AlarmReceiver", "reset bumper, interval=".concat(String.valueOf(j)));
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                C4990ab.m7412e("MicroMsg.AlarmReceiver", "keep bumper failed, null am");
                AppMethodBeat.m2505o(57769);
                return;
            }
            alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 268435456));
            AppMethodBeat.m2505o(57769);
        }

        /* renamed from: bq */
        public static void m16679bq(Context context) {
            AppMethodBeat.m2504i(57770);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                C4990ab.m7412e("MicroMsg.AlarmReceiver", "stop bumper failed, null am");
                AppMethodBeat.m2505o(57770);
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
            AppMethodBeat.m2505o(57770);
        }

        /* renamed from: br */
        public static void m16680br(Context context) {
            AppMethodBeat.m2504i(57771);
            C4990ab.m7420w("MicroMsg.AlarmReceiver", "keep awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                C4990ab.m7412e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                AppMethodBeat.m2505o(57771);
                return;
            }
            int i = C1892aa.anj() ? 300000 : 900000;
            alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) i), (long) i, PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 268435456));
            AppMethodBeat.m2505o(57771);
        }

        /* renamed from: bs */
        public static void m16681bs(Context context) {
            AppMethodBeat.m2504i(57772);
            C4990ab.m7420w("MicroMsg.AlarmReceiver", "stop awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                C4990ab.m7412e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                AppMethodBeat.m2505o(57772);
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 536870912);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
            AppMethodBeat.m2505o(57772);
        }
    }

    /* renamed from: com.tencent.mm.booter.MMReceivers$ExdeviceProcessReceiver */
    public static class ExdeviceProcessReceiver extends BroadcastReceiver {
        private static C18095a ebV = null;

        /* renamed from: a */
        public static void m16682a(C18095a c18095a) {
            ebV = c18095a;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(57775);
            if (ebV != null) {
                ebV.onReceive(context, intent);
            }
            AppMethodBeat.m2505o(57775);
        }
    }

    @C26347k
    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140819", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    /* renamed from: com.tencent.mm.booter.MMReceivers$ConnectionReceiver */
    public static class ConnectionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(57774);
            if (context == null) {
                AppMethodBeat.m2505o(57774);
                return;
            }
            C4990ab.m7416i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
            if (!C1324b.m2837c(context, "connection", true)) {
                AlarmReceiver.m16681bs(context);
                C4990ab.dot();
                AppMethodBeat.m2505o(57774);
            } else if (C1892aa.ann() == null) {
                AppMethodBeat.m2505o(57774);
            } else {
                NetworkInfo networkInfo = null;
                try {
                    networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed. exception: %s", e.getMessage());
                }
                C1893a ann;
                if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
                    String str = "MicroMsg.ConnectionReceiver";
                    String str2 = "NetworkAvailable: false, state:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = networkInfo == null ? BuildConfig.COMMAND : networkInfo.getState();
                    C4990ab.m7417i(str, str2, objArr);
                    ann = C1892aa.ann();
                    if (networkInfo != null) {
                        networkInfo.getTypeName();
                    }
                    if (networkInfo != null) {
                        networkInfo.getSubtypeName();
                    }
                    ann.mo5479bt(false);
                    AppMethodBeat.m2505o(57774);
                    return;
                }
                C4990ab.m7416i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
                ann = C1892aa.ann();
                networkInfo.getTypeName();
                networkInfo.getSubtypeName();
                ann.mo5479bt(true);
                AppMethodBeat.m2505o(57774);
            }
        }
    }

    /* renamed from: com.tencent.mm.booter.MMReceivers$a */
    public interface C18095a {
        void onReceive(Context context, Intent intent);
    }

    /* renamed from: com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver */
    public static class ToolsMpProcessReceiver extends BroadcastReceiver {
        private static C18095a ebV = null;

        /* renamed from: a */
        public static void m63505a(C18095a c18095a) {
            ebV = c18095a;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(57777);
            if (ebV != null) {
                ebV.onReceive(context, intent);
            }
            AppMethodBeat.m2505o(57777);
        }
    }

    /* renamed from: com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver */
    public static class ToolsProcessReceiver extends BroadcastReceiver {
        private static C18095a ebV = null;

        /* renamed from: a */
        public static void m63506a(C18095a c18095a) {
            ebV = c18095a;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(57778);
            if (ebV != null) {
                ebV.onReceive(context, intent);
            }
            AppMethodBeat.m2505o(57778);
        }
    }

    /* renamed from: com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver */
    public static class SandBoxProcessReceiver extends BroadcastReceiver {
        private static C18095a ebV = null;

        /* renamed from: a */
        public static void m73998a(C18095a c18095a) {
            ebV = c18095a;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(57776);
            if (ebV != null) {
                ebV.onReceive(context, intent);
            }
            AppMethodBeat.m2505o(57776);
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    /* renamed from: com.tencent.mm.booter.MMReceivers$BootReceiver */
    public static class BootReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(57773);
            if (context == null) {
                AppMethodBeat.m2505o(57773);
                return;
            }
            new StringBuilder("system booted, pid=").append(Process.myPid());
            if (!C1324b.m2837c(context, "auto", true)) {
                AlarmReceiver.m16681bs(context);
                C4990ab.dot();
            }
            AppMethodBeat.m2505o(57773);
        }
    }
}
