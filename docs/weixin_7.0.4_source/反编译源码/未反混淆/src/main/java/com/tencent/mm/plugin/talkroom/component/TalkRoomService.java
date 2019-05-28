package com.tencent.mm.plugin.talkroom.component;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class TalkRoomService extends Service {
    private g sxG;

    static {
        AppMethodBeat.i(25748);
        ab.i("MicroMsg.TalkRoomService", Thread.currentThread().getId());
        AppMethodBeat.o(25748);
    }

    public void onCreate() {
        AppMethodBeat.i(25743);
        ab.d("MicroMsg.TalkRoomService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (VERSION.SDK_INT < 18) {
            startForeground(9999, new Notification());
        }
        if (this.sxG == null) {
            this.sxG = new g();
        }
        AppMethodBeat.o(25743);
    }

    public void onDestroy() {
        AppMethodBeat.i(25744);
        ab.d("MicroMsg.TalkRoomService", "onDestroy~~~ threadID:" + Thread.currentThread());
        super.onDestroy();
        AppMethodBeat.o(25744);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(25745);
        ab.d("MicroMsg.TalkRoomService", "onUnbind~~~ threadID:" + Thread.currentThread());
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(25745);
        return onUnbind;
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(25746);
        ab.d("MicroMsg.TalkRoomService", "onBind~~~ threadID:" + Thread.currentThread());
        g gVar = this.sxG;
        AppMethodBeat.o(25746);
        return gVar;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(25747);
        ab.d("MicroMsg.TalkRoomService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
        AppMethodBeat.o(25747);
    }
}
