package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzk;
import com.google.android.gms.internal.auth.zzu;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WorkAccount {
    public static final Api<NoOptions> API = new Api("WorkAccount.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final AbstractClientBuilder<zzu, NoOptions> CLIENT_BUILDER = new zzi();
    private static final ClientKey<zzu> CLIENT_KEY = new ClientKey();
    @Deprecated
    public static final WorkAccountApi WorkAccountApi = new zzk();

    static {
        AppMethodBeat.m2504i(76964);
        AppMethodBeat.m2505o(76964);
    }

    private WorkAccount() {
    }

    public static WorkAccountClient getClient(Activity activity) {
        AppMethodBeat.m2504i(76962);
        WorkAccountClient workAccountClient = new WorkAccountClient(activity);
        AppMethodBeat.m2505o(76962);
        return workAccountClient;
    }

    public static WorkAccountClient getClient(Context context) {
        AppMethodBeat.m2504i(76963);
        WorkAccountClient workAccountClient = new WorkAccountClient(context);
        AppMethodBeat.m2505o(76963);
        return workAccountClient;
    }
}
