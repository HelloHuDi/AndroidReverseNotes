package com.tencent.mm.plugin.talkroom.model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.af.b;
import com.tencent.mm.sdk.platformtools.ah;

public class TalkRoomReceiver extends BroadcastReceiver {
    protected static void init() {
        AppMethodBeat.i(25790);
        af.a(new b() {
            public final void prepare() {
                AppMethodBeat.i(25788);
                TalkRoomReceiver.bp(ah.getContext());
                AppMethodBeat.o(25788);
            }

            public final void cancel() {
                AppMethodBeat.i(25789);
                TalkRoomReceiver.bq(ah.getContext());
                AppMethodBeat.o(25789);
            }
        });
        AppMethodBeat.o(25790);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(25791);
        ab.i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(intent.getBooleanExtra("MMBoot_Bump", false))));
        bp(context);
        AppMethodBeat.o(25791);
    }

    public static void bp(Context context) {
        long j = 30000;
        AppMethodBeat.i(25792);
        long dov = af.dov();
        ab.d("MicroMsg.TalkRoomReceiver", "bumper comes, next=".concat(String.valueOf(dov)));
        if (dov > 600000) {
            AppMethodBeat.o(25792);
            return;
        }
        if (dov >= 30000) {
            j = dov;
        }
        a(j, context);
        AppMethodBeat.o(25792);
    }

    private static void a(long j, Context context) {
        AppMethodBeat.i(25793);
        ab.w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", Long.valueOf(j), Long.valueOf(SystemClock.elapsedRealtime()));
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            ab.e("MicroMsg.TalkRoomReceiver", "keep bumper failed, null am");
            AppMethodBeat.o(25793);
            return;
        }
        alarmManager.set(2, r2 + j, PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 268435456));
        AppMethodBeat.o(25793);
    }

    public static void bq(Context context) {
        AppMethodBeat.i(25794);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            ab.e("MicroMsg.TalkRoomReceiver", "stop bumper failed, null am");
            AppMethodBeat.o(25794);
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
        AppMethodBeat.o(25794);
    }
}
