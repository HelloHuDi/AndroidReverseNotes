package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.C41642a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* renamed from: com.google.firebase.iid.ab */
final class C32095ab implements C41649ae {
    private final C41642a bvs;
    private final C32099f bvt;
    final C25586m bwH;
    private final ScheduledThreadPoolExecutor bwI = new ScheduledThreadPoolExecutor(1);
    private final FirebaseInstanceId bwi;

    C32095ab(C41642a c41642a, FirebaseInstanceId firebaseInstanceId, C32099f c32099f) {
        AppMethodBeat.m2504i(108794);
        this.bvs = c41642a;
        this.bwi = firebaseInstanceId;
        this.bvt = c32099f;
        this.bwH = new C25586m(c41642a.getApplicationContext(), c32099f);
        AppMethodBeat.m2505o(108794);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: h */
    public final String mo52658h(Bundle bundle) {
        AppMethodBeat.m2504i(108797);
        IOException iOException;
        if (bundle == null) {
            iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.m2505o(108797);
            throw iOException;
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            AppMethodBeat.m2505o(108797);
        } else {
            string = bundle.getString("unregistered");
            if (string != null) {
                AppMethodBeat.m2505o(108797);
            } else {
                string = bundle.getString("error");
                if ("RST".equals(string)) {
                    this.bwi.mo43239uI();
                    iOException = new IOException("INSTANCE_ID_RESET");
                    AppMethodBeat.m2505o(108797);
                    throw iOException;
                } else if (string != null) {
                    IOException iOException2 = new IOException(string);
                    AppMethodBeat.m2505o(108797);
                    throw iOException2;
                } else {
                    string = String.valueOf(bundle);
                    new StringBuilder(String.valueOf(string).length() + 21).append("Unexpected response: ").append(string);
                    Throwable th = new Throwable();
                    iOException = new IOException("SERVICE_NOT_AVAILABLE");
                    AppMethodBeat.m2505o(108797);
                    throw iOException;
                }
            }
        }
        return string;
    }

    /* renamed from: q */
    public final Task<String> mo52659q(String str, String str2) {
        AppMethodBeat.m2504i(108795);
        Bundle bundle = new Bundle();
        mo52657c(str, str2, bundle);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.bwI.execute(new C37304ac(this, bundle, taskCompletionSource));
        Task continueWith = taskCompletionSource.getTask().continueWith(this.bwI, new C45072ad(this));
        AppMethodBeat.m2505o(108795);
        return continueWith;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final Bundle mo52657c(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(108796);
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("appid", FirebaseInstanceId.zzf());
        bundle.putString("gmp_app_id", this.bvs.mo67040us().zzs);
        bundle.putString("gmsv", Integer.toString(this.bvt.mo52666uQ()));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", this.bvt.mo52664uO());
        bundle.putString("app_ver_name", this.bvt.mo52665uP());
        bundle.putString("cliv", "fiid-12451000");
        AppMethodBeat.m2505o(108796);
        return bundle;
    }
}
