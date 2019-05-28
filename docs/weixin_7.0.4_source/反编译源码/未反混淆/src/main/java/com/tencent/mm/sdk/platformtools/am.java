package com.tencent.mm.sdk.platformtools;

import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public class am extends Handler implements com.tencent.mm.sdk.platformtools.aq.a {
    private String toStringResult = null;
    private Looper xzn = getLooper();
    private Callback xzo;
    public a xzp;

    public interface a {
        void handleMessage(Message message);

        void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, long j3, float f);

        void onTaskAdded(Runnable runnable, aq aqVar);

        void onTaskRunEnd(Runnable runnable, aq aqVar);
    }

    public am(a aVar) {
        AppMethodBeat.i(52142);
        this.xzp = aVar;
        AppMethodBeat.o(52142);
    }

    public am(Looper looper, a aVar) {
        super(looper);
        AppMethodBeat.i(52143);
        this.xzp = aVar;
        AppMethodBeat.o(52143);
    }

    public am(Callback callback, a aVar) {
        super(callback);
        AppMethodBeat.i(52144);
        this.xzo = callback;
        this.xzp = aVar;
        AppMethodBeat.o(52144);
    }

    public am(Looper looper, Callback callback, a aVar) {
        super(looper, callback);
        AppMethodBeat.i(52145);
        this.xzo = callback;
        this.xzp = aVar;
        AppMethodBeat.o(52145);
    }

    public boolean sendMessageAtTime(Message message, long j) {
        AppMethodBeat.i(52146);
        Assert.assertTrue("msg is null", message != null);
        Runnable callback = message.getCallback();
        long uptimeMillis = j - SystemClock.uptimeMillis();
        boolean sendMessageAtTime;
        if (callback == null) {
            Bundle bundle = new Bundle();
            bundle.putBundle("tmp", message.getData());
            bundle.putLong("delay", uptimeMillis);
            bundle.putLong("addTime", System.currentTimeMillis());
            message.setData(bundle);
            sendMessageAtTime = super.sendMessageAtTime(message, j);
            AppMethodBeat.o(52146);
            return sendMessageAtTime;
        }
        aq aqVar = new aq(this.xzn.getThread(), message.getTarget() == null ? this : message.getTarget(), callback, message.obj, this);
        if (uptimeMillis > 0) {
            aqVar.xzH = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), aqVar);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        if (getLooper() == null || getLooper().getThread().isAlive()) {
            if (this.xzp != null) {
                this.xzp.onTaskAdded(callback, aqVar);
            }
            sendMessageAtTime = super.sendMessageAtTime(obtain, j);
            if (!(sendMessageAtTime || this.xzp == null)) {
                this.xzp.onTaskRunEnd(callback, aqVar);
            }
            AppMethodBeat.o(52146);
            return sendMessageAtTime;
        }
        ab.w("MicroMsg.MMInnerHandler", "sendMessageAtTime but thread[%d, %s] is dead so return false!", Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName());
        AppMethodBeat.o(52146);
        return false;
    }

    public void dispatchMessage(Message message) {
        AppMethodBeat.i(52147);
        if (message.getCallback() == null && this.xzo == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle data = message.getData();
            long j = data.getLong("addTime");
            long j2 = data.getLong("delay");
            data = data.getBundle("tmp");
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            long j3 = (currentTimeMillis - j) - j2;
            message.setData(data);
            handleMessage(message);
            if (this.xzp != null) {
                this.xzp.onLog(message, null, this.xzn.getThread(), System.currentTimeMillis() - currentTimeMillis, Debug.threadCpuTimeNanos() - threadCpuTimeNanos, j3, -1.0f);
            }
            AppMethodBeat.o(52147);
            return;
        }
        super.dispatchMessage(message);
        AppMethodBeat.o(52147);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(52148);
        if (this.xzp != null) {
            this.xzp.handleMessage(message);
        }
        AppMethodBeat.o(52148);
    }

    public String toString() {
        AppMethodBeat.i(52149);
        if (this.toStringResult == null) {
            this.toStringResult = "MMInnerHandler{listener = " + this.xzp + "}";
        }
        String str = this.toStringResult;
        AppMethodBeat.o(52149);
        return str;
    }

    public final void a(Runnable runnable, aq aqVar) {
        AppMethodBeat.i(52150);
        if (this.xzp != null) {
            this.xzp.onTaskRunEnd(runnable, aqVar);
        }
        AppMethodBeat.o(52150);
    }

    public final void a(Runnable runnable, Thread thread, long j, long j2, long j3, float f) {
        AppMethodBeat.i(52151);
        if (this.xzp != null) {
            this.xzp.onLog(null, runnable, thread, j, j2, j3, f);
        }
        AppMethodBeat.o(52151);
    }
}
