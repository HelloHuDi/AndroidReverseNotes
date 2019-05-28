package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.ai */
public final class C25584ai {
    @GuardedBy("MessengerIpcClient.class")
    private static C25584ai bwO;
    final Context bvF;
    final ScheduledExecutorService bwP;
    @GuardedBy("this")
    private C17707aj bwQ = new C17707aj(this, (byte) 0);
    @GuardedBy("this")
    private int bwR = 1;

    private C25584ai(Context context, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.m2504i(108818);
        this.bwP = scheduledExecutorService;
        this.bvF = context.getApplicationContext();
        AppMethodBeat.m2505o(108818);
    }

    /* renamed from: ar */
    public static synchronized C25584ai m40578ar(Context context) {
        C25584ai c25584ai;
        synchronized (C25584ai.class) {
            AppMethodBeat.m2504i(108817);
            if (bwO == null) {
                bwO = new C25584ai(context, Executors.newSingleThreadScheduledExecutor());
            }
            c25584ai = bwO;
            AppMethodBeat.m2505o(108817);
        }
        return c25584ai;
    }

    /* renamed from: a */
    public final synchronized <T> Task<T> mo43243a(C32098c<T> c32098c) {
        Task task;
        AppMethodBeat.m2504i(108819);
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(c32098c);
            new StringBuilder(String.valueOf(valueOf).length() + 9).append("Queueing ").append(valueOf);
        }
        if (!this.bwQ.mo32788b(c32098c)) {
            this.bwQ = new C17707aj(this, (byte) 0);
            this.bwQ.mo32788b(c32098c);
        }
        task = c32098c.bvD.getTask();
        AppMethodBeat.m2505o(108819);
        return task;
    }

    /* renamed from: uX */
    public final synchronized int mo43244uX() {
        int i;
        i = this.bwR;
        this.bwR = i + 1;
        return i;
    }
}
