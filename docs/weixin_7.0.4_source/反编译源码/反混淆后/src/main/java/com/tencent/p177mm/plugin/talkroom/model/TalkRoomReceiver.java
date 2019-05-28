package com.tencent.p177mm.plugin.talkroom.model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C35986af;
import com.tencent.p177mm.sdk.platformtools.C35986af.C30282b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.talkroom.model.TalkRoomReceiver */
public class TalkRoomReceiver extends BroadcastReceiver {

    /* renamed from: com.tencent.mm.plugin.talkroom.model.TalkRoomReceiver$1 */
    static class C294161 implements C30282b {
        C294161() {
        }

        public final void prepare() {
            AppMethodBeat.m2504i(25788);
            TalkRoomReceiver.m46687bp(C4996ah.getContext());
            AppMethodBeat.m2505o(25788);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(25789);
            TalkRoomReceiver.m46688bq(C4996ah.getContext());
            AppMethodBeat.m2505o(25789);
        }
    }

    protected static void init() {
        AppMethodBeat.m2504i(25790);
        C35986af.m59195a(new C294161());
        AppMethodBeat.m2505o(25790);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(25791);
        C4990ab.m7416i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(intent.getBooleanExtra("MMBoot_Bump", false))));
        TalkRoomReceiver.m46687bp(context);
        AppMethodBeat.m2505o(25791);
    }

    /* renamed from: bp */
    public static void m46687bp(Context context) {
        long j = 30000;
        AppMethodBeat.m2504i(25792);
        long dov = C35986af.dov();
        C4990ab.m7410d("MicroMsg.TalkRoomReceiver", "bumper comes, next=".concat(String.valueOf(dov)));
        if (dov > 600000) {
            AppMethodBeat.m2505o(25792);
            return;
        }
        if (dov >= 30000) {
            j = dov;
        }
        TalkRoomReceiver.m46686a(j, context);
        AppMethodBeat.m2505o(25792);
    }

    /* renamed from: a */
    private static void m46686a(long j, Context context) {
        AppMethodBeat.m2504i(25793);
        C4990ab.m7421w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", Long.valueOf(j), Long.valueOf(SystemClock.elapsedRealtime()));
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            C4990ab.m7412e("MicroMsg.TalkRoomReceiver", "keep bumper failed, null am");
            AppMethodBeat.m2505o(25793);
            return;
        }
        alarmManager.set(2, r2 + j, PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 268435456));
        AppMethodBeat.m2505o(25793);
    }

    /* renamed from: bq */
    public static void m46688bq(Context context) {
        AppMethodBeat.m2504i(25794);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            C4990ab.m7412e("MicroMsg.TalkRoomReceiver", "stop bumper failed, null am");
            AppMethodBeat.m2505o(25794);
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
        AppMethodBeat.m2505o(25794);
    }
}
