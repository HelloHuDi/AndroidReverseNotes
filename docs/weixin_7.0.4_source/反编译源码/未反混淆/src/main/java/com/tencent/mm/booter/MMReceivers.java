package com.tencent.mm.booter;

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
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.kernel.k;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.al;

public final class MMReceivers {

    @k
    public static class AlarmReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(57767);
            if (context == null || intent == null) {
                AppMethodBeat.o(57767);
                return;
            }
            if (!com.tencent.mm.kernel.a.Mz().getBoolean("keepaliveserviceswitch", false)) {
                ab.i("MicroMsg.AlarmReceiver", "onReceive() MMHandlerThread() publish PushKeepAliveEvent");
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(57766);
                        com.tencent.mm.sdk.b.a.xxA.a(new mw(), Looper.getMainLooper());
                        ab.i("MicroMsg.AlarmReceiver", "onReceive() publish PushKeepAliveEvent");
                        AppMethodBeat.o(57766);
                    }
                }, 10000);
            }
            boolean booleanExtra = intent.getBooleanExtra("MMBoot_Bump", false);
            ab.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(booleanExtra)));
            if (booleanExtra) {
                bp(context);
                AppMethodBeat.o(57767);
                return;
            }
            if (!b.c(context, "alarm", true)) {
                bs(context);
                ab.dot();
            }
            AppMethodBeat.o(57767);
        }

        public static void bp(Context context) {
            long j = 30000;
            AppMethodBeat.i(57768);
            long dov = af.dov();
            ab.d("MicroMsg.AlarmReceiver", "bumper comes, next=".concat(String.valueOf(dov)));
            if (dov > 1860000) {
                AppMethodBeat.o(57768);
                return;
            }
            if (dov >= 30000) {
                j = dov;
            }
            a(j, context);
            AppMethodBeat.o(57768);
        }

        private static void a(long j, Context context) {
            AppMethodBeat.i(57769);
            ab.w("MicroMsg.AlarmReceiver", "reset bumper, interval=".concat(String.valueOf(j)));
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                ab.e("MicroMsg.AlarmReceiver", "keep bumper failed, null am");
                AppMethodBeat.o(57769);
                return;
            }
            alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 268435456));
            AppMethodBeat.o(57769);
        }

        public static void bq(Context context) {
            AppMethodBeat.i(57770);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                ab.e("MicroMsg.AlarmReceiver", "stop bumper failed, null am");
                AppMethodBeat.o(57770);
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
            AppMethodBeat.o(57770);
        }

        public static void br(Context context) {
            AppMethodBeat.i(57771);
            ab.w("MicroMsg.AlarmReceiver", "keep awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                ab.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                AppMethodBeat.o(57771);
                return;
            }
            int i = aa.anj() ? 300000 : 900000;
            alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) i), (long) i, PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 268435456));
            AppMethodBeat.o(57771);
        }

        public static void bs(Context context) {
            AppMethodBeat.i(57772);
            ab.w("MicroMsg.AlarmReceiver", "stop awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                ab.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                AppMethodBeat.o(57772);
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 536870912);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
            AppMethodBeat.o(57772);
        }
    }

    public static class ExdeviceProcessReceiver extends BroadcastReceiver {
        private static a ebV = null;

        public static void a(a aVar) {
            ebV = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(57775);
            if (ebV != null) {
                ebV.onReceive(context, intent);
            }
            AppMethodBeat.o(57775);
        }
    }

    @k
    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140819", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class ConnectionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(57774);
            if (context == null) {
                AppMethodBeat.o(57774);
                return;
            }
            ab.i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
            if (!b.c(context, "connection", true)) {
                AlarmReceiver.bs(context);
                ab.dot();
                AppMethodBeat.o(57774);
            } else if (aa.ann() == null) {
                AppMethodBeat.o(57774);
            } else {
                NetworkInfo networkInfo = null;
                try {
                    networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception e) {
                    ab.e("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed. exception: %s", e.getMessage());
                }
                com.tencent.mm.network.aa.a ann;
                if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
                    String str = "MicroMsg.ConnectionReceiver";
                    String str2 = "NetworkAvailable: false, state:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = networkInfo == null ? BuildConfig.COMMAND : networkInfo.getState();
                    ab.i(str, str2, objArr);
                    ann = aa.ann();
                    if (networkInfo != null) {
                        networkInfo.getTypeName();
                    }
                    if (networkInfo != null) {
                        networkInfo.getSubtypeName();
                    }
                    ann.bt(false);
                    AppMethodBeat.o(57774);
                    return;
                }
                ab.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
                ann = aa.ann();
                networkInfo.getTypeName();
                networkInfo.getSubtypeName();
                ann.bt(true);
                AppMethodBeat.o(57774);
            }
        }
    }

    public interface a {
        void onReceive(Context context, Intent intent);
    }

    public static class ToolsMpProcessReceiver extends BroadcastReceiver {
        private static a ebV = null;

        public static void a(a aVar) {
            ebV = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(57777);
            if (ebV != null) {
                ebV.onReceive(context, intent);
            }
            AppMethodBeat.o(57777);
        }
    }

    public static class ToolsProcessReceiver extends BroadcastReceiver {
        private static a ebV = null;

        public static void a(a aVar) {
            ebV = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(57778);
            if (ebV != null) {
                ebV.onReceive(context, intent);
            }
            AppMethodBeat.o(57778);
        }
    }

    public static class SandBoxProcessReceiver extends BroadcastReceiver {
        private static a ebV = null;

        public static void a(a aVar) {
            ebV = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(57776);
            if (ebV != null) {
                ebV.onReceive(context, intent);
            }
            AppMethodBeat.o(57776);
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class BootReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(57773);
            if (context == null) {
                AppMethodBeat.o(57773);
                return;
            }
            new StringBuilder("system booted, pid=").append(Process.myPid());
            if (!b.c(context, "auto", true)) {
                AlarmReceiver.bs(context);
                ab.dot();
            }
            AppMethodBeat.o(57773);
        }
    }
}
