package com.google.android.gms.internal.p1161auth-api-phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzj */
public final class zzj extends SmsRetrieverClient {
    public zzj(Activity activity) {
        super(activity);
    }

    public zzj(Context context) {
        super(context);
    }

    public final Task<Void> startSmsRetriever() {
        AppMethodBeat.m2504i(80433);
        Task doWrite = doWrite((TaskApiCall) new zzk(this));
        AppMethodBeat.m2505o(80433);
        return doWrite;
    }
}
