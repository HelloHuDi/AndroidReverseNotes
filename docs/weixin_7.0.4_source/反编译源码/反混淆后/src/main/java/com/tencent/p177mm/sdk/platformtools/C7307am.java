package com.tencent.p177mm.sdk.platformtools;

import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5017aq.C5016a;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.platformtools.am */
public class C7307am extends Handler implements C5016a {
    private String toStringResult = null;
    private Looper xzn = getLooper();
    private Callback xzo;
    public C5006a xzp;

    /* renamed from: com.tencent.mm.sdk.platformtools.am$a */
    public interface C5006a {
        void handleMessage(Message message);

        void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, long j3, float f);

        void onTaskAdded(Runnable runnable, C5017aq c5017aq);

        void onTaskRunEnd(Runnable runnable, C5017aq c5017aq);
    }

    public C7307am(C5006a c5006a) {
        AppMethodBeat.m2504i(52142);
        this.xzp = c5006a;
        AppMethodBeat.m2505o(52142);
    }

    public C7307am(Looper looper, C5006a c5006a) {
        super(looper);
        AppMethodBeat.m2504i(52143);
        this.xzp = c5006a;
        AppMethodBeat.m2505o(52143);
    }

    public C7307am(Callback callback, C5006a c5006a) {
        super(callback);
        AppMethodBeat.m2504i(52144);
        this.xzo = callback;
        this.xzp = c5006a;
        AppMethodBeat.m2505o(52144);
    }

    public C7307am(Looper looper, Callback callback, C5006a c5006a) {
        super(looper, callback);
        AppMethodBeat.m2504i(52145);
        this.xzo = callback;
        this.xzp = c5006a;
        AppMethodBeat.m2505o(52145);
    }

    public boolean sendMessageAtTime(Message message, long j) {
        AppMethodBeat.m2504i(52146);
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
            AppMethodBeat.m2505o(52146);
            return sendMessageAtTime;
        }
        C5017aq c5017aq = new C5017aq(this.xzn.getThread(), message.getTarget() == null ? this : message.getTarget(), callback, message.obj, this);
        if (uptimeMillis > 0) {
            c5017aq.xzH = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), c5017aq);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        if (getLooper() == null || getLooper().getThread().isAlive()) {
            if (this.xzp != null) {
                this.xzp.onTaskAdded(callback, c5017aq);
            }
            sendMessageAtTime = super.sendMessageAtTime(obtain, j);
            if (!(sendMessageAtTime || this.xzp == null)) {
                this.xzp.onTaskRunEnd(callback, c5017aq);
            }
            AppMethodBeat.m2505o(52146);
            return sendMessageAtTime;
        }
        C4990ab.m7421w("MicroMsg.MMInnerHandler", "sendMessageAtTime but thread[%d, %s] is dead so return false!", Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName());
        AppMethodBeat.m2505o(52146);
        return false;
    }

    public void dispatchMessage(Message message) {
        AppMethodBeat.m2504i(52147);
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
            AppMethodBeat.m2505o(52147);
            return;
        }
        super.dispatchMessage(message);
        AppMethodBeat.m2505o(52147);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.m2504i(52148);
        if (this.xzp != null) {
            this.xzp.handleMessage(message);
        }
        AppMethodBeat.m2505o(52148);
    }

    public String toString() {
        AppMethodBeat.m2504i(52149);
        if (this.toStringResult == null) {
            this.toStringResult = "MMInnerHandler{listener = " + this.xzp + "}";
        }
        String str = this.toStringResult;
        AppMethodBeat.m2505o(52149);
        return str;
    }

    /* renamed from: a */
    public final void mo10318a(Runnable runnable, C5017aq c5017aq) {
        AppMethodBeat.m2504i(52150);
        if (this.xzp != null) {
            this.xzp.onTaskRunEnd(runnable, c5017aq);
        }
        AppMethodBeat.m2505o(52150);
    }

    /* renamed from: a */
    public final void mo10319a(Runnable runnable, Thread thread, long j, long j2, long j3, float f) {
        AppMethodBeat.m2504i(52151);
        if (this.xzp != null) {
            this.xzp.onLog(null, runnable, thread, j, j2, j3, f);
        }
        AppMethodBeat.m2505o(52151);
    }
}
