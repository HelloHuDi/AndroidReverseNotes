package com.google.firebase.iid;

import android.support.v4.f.a;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

final class i {
    @GuardedBy("this")
    private final Map<Pair<String, String>, TaskCompletionSource<String>> bvJ = new a();

    i() {
        AppMethodBeat.i(108728);
        AppMethodBeat.o(108728);
    }

    static String a(TaskCompletionSource<String> taskCompletionSource) {
        IOException iOException;
        AppMethodBeat.i(108731);
        try {
            String str = (String) Tasks.await(taskCompletionSource.getTask());
            AppMethodBeat.o(108731);
            return str;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                IOException iOException2 = (IOException) cause;
                AppMethodBeat.o(108731);
                throw iOException2;
            } else if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(108731);
                throw runtimeException;
            } else {
                iOException = new IOException(cause);
                AppMethodBeat.o(108731);
                throw iOException;
            }
        } catch (InterruptedException e2) {
            iOException = new IOException(e2);
            AppMethodBeat.o(108731);
            throw iOException;
        }
    }

    private static String a(l lVar, TaskCompletionSource<String> taskCompletionSource) {
        AppMethodBeat.i(108730);
        try {
            String zzp = lVar.zzp();
            taskCompletionSource.setResult(zzp);
            AppMethodBeat.o(108730);
            return zzp;
        } catch (IOException | RuntimeException e) {
            taskCompletionSource.setException(e);
            AppMethodBeat.o(108730);
            throw e;
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized l a(String str, String str2, l lVar) {
        l lVar2;
        AppMethodBeat.i(108729);
        Pair pair = new Pair(str, str2);
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.bvJ.get(pair);
        if (taskCompletionSource != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                new StringBuilder(String.valueOf(valueOf).length() + 29).append("Joining ongoing request for: ").append(valueOf);
            }
            j jVar = new j(taskCompletionSource);
            AppMethodBeat.o(108729);
            lVar2 = jVar;
        } else {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf2 = String.valueOf(pair);
                new StringBuilder(String.valueOf(valueOf2).length() + 24).append("Making new request for: ").append(valueOf2);
            }
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            this.bvJ.put(pair, taskCompletionSource2);
            lVar2 = new k(this, lVar, taskCompletionSource2, pair);
            AppMethodBeat.o(108729);
        }
        return lVar2;
    }
}
