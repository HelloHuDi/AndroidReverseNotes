package com.google.firebase.iid;

import android.support.p057v4.p065f.C6197a;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.i */
final class C32100i {
    @GuardedBy("this")
    private final Map<Pair<String, String>, TaskCompletionSource<String>> bvJ = new C6197a();

    C32100i() {
        AppMethodBeat.m2504i(108728);
        AppMethodBeat.m2505o(108728);
    }

    /* renamed from: a */
    static String m52232a(TaskCompletionSource<String> taskCompletionSource) {
        IOException iOException;
        AppMethodBeat.m2504i(108731);
        try {
            String str = (String) Tasks.await(taskCompletionSource.getTask());
            AppMethodBeat.m2505o(108731);
            return str;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                IOException iOException2 = (IOException) cause;
                AppMethodBeat.m2505o(108731);
                throw iOException2;
            } else if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.m2505o(108731);
                throw runtimeException;
            } else {
                iOException = new IOException(cause);
                AppMethodBeat.m2505o(108731);
                throw iOException;
            }
        } catch (InterruptedException e2) {
            iOException = new IOException(e2);
            AppMethodBeat.m2505o(108731);
            throw iOException;
        }
    }

    /* renamed from: a */
    private static String m52233a(C37307l c37307l, TaskCompletionSource<String> taskCompletionSource) {
        AppMethodBeat.m2504i(108730);
        try {
            String zzp = c37307l.zzp();
            taskCompletionSource.setResult(zzp);
            AppMethodBeat.m2505o(108730);
            return zzp;
        } catch (IOException | RuntimeException e) {
            taskCompletionSource.setException(e);
            AppMethodBeat.m2505o(108730);
            throw e;
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized C37307l mo52668a(String str, String str2, C37307l c37307l) {
        C37307l c37307l2;
        AppMethodBeat.m2504i(108729);
        Pair pair = new Pair(str, str2);
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.bvJ.get(pair);
        if (taskCompletionSource != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                new StringBuilder(String.valueOf(valueOf).length() + 29).append("Joining ongoing request for: ").append(valueOf);
            }
            C32101j c32101j = new C32101j(taskCompletionSource);
            AppMethodBeat.m2505o(108729);
            c37307l2 = c32101j;
        } else {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf2 = String.valueOf(pair);
                new StringBuilder(String.valueOf(valueOf2).length() + 24).append("Making new request for: ").append(valueOf2);
            }
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            this.bvJ.put(pair, taskCompletionSource2);
            c37307l2 = new C32102k(this, c37307l, taskCompletionSource2, pair);
            AppMethodBeat.m2505o(108729);
        }
        return c37307l2;
    }
}
