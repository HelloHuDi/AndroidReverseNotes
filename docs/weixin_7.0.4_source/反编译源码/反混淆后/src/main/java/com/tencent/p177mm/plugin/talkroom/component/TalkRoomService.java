package com.tencent.p177mm.plugin.talkroom.component;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.talkroom.component.TalkRoomService */
public class TalkRoomService extends Service {
    private C24838g sxG;

    static {
        AppMethodBeat.m2504i(25748);
        C4990ab.m7416i("MicroMsg.TalkRoomService", Thread.currentThread().getId());
        AppMethodBeat.m2505o(25748);
    }

    public void onCreate() {
        AppMethodBeat.m2504i(25743);
        C4990ab.m7410d("MicroMsg.TalkRoomService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (VERSION.SDK_INT < 18) {
            startForeground(9999, new Notification());
        }
        if (this.sxG == null) {
            this.sxG = new C24838g();
        }
        AppMethodBeat.m2505o(25743);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25744);
        C4990ab.m7410d("MicroMsg.TalkRoomService", "onDestroy~~~ threadID:" + Thread.currentThread());
        super.onDestroy();
        AppMethodBeat.m2505o(25744);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(25745);
        C4990ab.m7410d("MicroMsg.TalkRoomService", "onUnbind~~~ threadID:" + Thread.currentThread());
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(25745);
        return onUnbind;
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(25746);
        C4990ab.m7410d("MicroMsg.TalkRoomService", "onBind~~~ threadID:" + Thread.currentThread());
        C24838g c24838g = this.sxG;
        AppMethodBeat.m2505o(25746);
        return c24838g;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.m2504i(25747);
        C4990ab.m7410d("MicroMsg.TalkRoomService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
        AppMethodBeat.m2505o(25747);
    }
}
