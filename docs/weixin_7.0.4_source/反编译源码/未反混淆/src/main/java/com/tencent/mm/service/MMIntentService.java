package com.tencent.mm.service;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class MMIntentService extends MMService {
    private String mName;
    private volatile Looper xFb;
    private volatile a xFc;

    final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(115272);
            MMIntentService.this.onHandleIntent((Intent) message.obj);
            MMIntentService mMIntentService = MMIntentService.this;
            ab.i(mMIntentService.getTag(), "%s stopSelf() startId = %d mStartId = %d", "MicroMsg.MMService", Integer.valueOf(message.arg1), Integer.valueOf(mMIntentService.bWH));
            if (message.arg1 == mMIntentService.bWH) {
                mMIntentService.q(new Intent(), "stop");
            }
            AppMethodBeat.o(115272);
        }
    }

    public abstract void onHandleIntent(Intent intent);

    public MMIntentService(String str) {
        this.mName = str;
    }

    public final void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("IntentService[" + this.mName + "]");
        handlerThread.start();
        this.xFb = handlerThread.getLooper();
        this.xFc = new a(this.xFb);
    }

    public final void onStart(Intent intent, int i) {
        Message obtainMessage = this.xFc.obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.obj = intent;
        this.xFc.sendMessage(obtainMessage);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return 2;
    }

    public final void onDestroy() {
        this.xFb.quit();
    }
}
