package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

final class ab implements ae {
    private final a bvs;
    private final f bvt;
    final m bwH;
    private final ScheduledThreadPoolExecutor bwI = new ScheduledThreadPoolExecutor(1);
    private final FirebaseInstanceId bwi;

    ab(a aVar, FirebaseInstanceId firebaseInstanceId, f fVar) {
        AppMethodBeat.i(108794);
        this.bvs = aVar;
        this.bwi = firebaseInstanceId;
        this.bvt = fVar;
        this.bwH = new m(aVar.getApplicationContext(), fVar);
        AppMethodBeat.o(108794);
    }

    /* Access modifiers changed, original: final */
    public final String h(Bundle bundle) {
        AppMethodBeat.i(108797);
        IOException iOException;
        if (bundle == null) {
            iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(108797);
            throw iOException;
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            AppMethodBeat.o(108797);
        } else {
            string = bundle.getString("unregistered");
            if (string != null) {
                AppMethodBeat.o(108797);
            } else {
                string = bundle.getString("error");
                if ("RST".equals(string)) {
                    this.bwi.uI();
                    iOException = new IOException("INSTANCE_ID_RESET");
                    AppMethodBeat.o(108797);
                    throw iOException;
                } else if (string != null) {
                    IOException iOException2 = new IOException(string);
                    AppMethodBeat.o(108797);
                    throw iOException2;
                } else {
                    string = String.valueOf(bundle);
                    new StringBuilder(String.valueOf(string).length() + 21).append("Unexpected response: ").append(string);
                    Throwable th = new Throwable();
                    iOException = new IOException("SERVICE_NOT_AVAILABLE");
                    AppMethodBeat.o(108797);
                    throw iOException;
                }
            }
        }
        return string;
    }

    public final Task<String> q(String str, String str2) {
        AppMethodBeat.i(108795);
        Bundle bundle = new Bundle();
        c(str, str2, bundle);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.bwI.execute(new ac(this, bundle, taskCompletionSource));
        Task continueWith = taskCompletionSource.getTask().continueWith(this.bwI, new ad(this));
        AppMethodBeat.o(108795);
        return continueWith;
    }

    /* Access modifiers changed, original: final */
    public final Bundle c(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(108796);
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("appid", FirebaseInstanceId.zzf());
        bundle.putString("gmp_app_id", this.bvs.us().zzs);
        bundle.putString("gmsv", Integer.toString(this.bvt.uQ()));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", this.bvt.uO());
        bundle.putString("app_ver_name", this.bvt.uP());
        bundle.putString("cliv", "fiid-12451000");
        AppMethodBeat.o(108796);
        return bundle;
    }
}
