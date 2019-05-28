package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class ai {
    @GuardedBy("MessengerIpcClient.class")
    private static ai bwO;
    final Context bvF;
    final ScheduledExecutorService bwP;
    @GuardedBy("this")
    private aj bwQ = new aj(this, (byte) 0);
    @GuardedBy("this")
    private int bwR = 1;

    private ai(Context context, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(108818);
        this.bwP = scheduledExecutorService;
        this.bvF = context.getApplicationContext();
        AppMethodBeat.o(108818);
    }

    public static synchronized ai ar(Context context) {
        ai aiVar;
        synchronized (ai.class) {
            AppMethodBeat.i(108817);
            if (bwO == null) {
                bwO = new ai(context, Executors.newSingleThreadScheduledExecutor());
            }
            aiVar = bwO;
            AppMethodBeat.o(108817);
        }
        return aiVar;
    }

    public final synchronized <T> Task<T> a(c<T> cVar) {
        Task task;
        AppMethodBeat.i(108819);
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(cVar);
            new StringBuilder(String.valueOf(valueOf).length() + 9).append("Queueing ").append(valueOf);
        }
        if (!this.bwQ.b(cVar)) {
            this.bwQ = new aj(this, (byte) 0);
            this.bwQ.b(cVar);
        }
        task = cVar.bvD.getTask();
        AppMethodBeat.o(108819);
        return task;
    }

    public final synchronized int uX() {
        int i;
        i = this.bwR;
        this.bwR = i + 1;
        return i;
    }
}
