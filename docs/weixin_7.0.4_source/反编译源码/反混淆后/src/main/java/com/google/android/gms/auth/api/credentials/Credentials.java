package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Credentials {
    public static CredentialsClient getClient(Activity activity) {
        AppMethodBeat.m2504i(50329);
        CredentialsClient credentialsClient = new CredentialsClient(activity, CredentialsOptions.DEFAULT);
        AppMethodBeat.m2505o(50329);
        return credentialsClient;
    }

    public static CredentialsClient getClient(Activity activity, CredentialsOptions credentialsOptions) {
        AppMethodBeat.m2504i(50330);
        CredentialsClient credentialsClient = new CredentialsClient(activity, (AuthCredentialsOptions) credentialsOptions);
        AppMethodBeat.m2505o(50330);
        return credentialsClient;
    }

    public static CredentialsClient getClient(Context context) {
        AppMethodBeat.m2504i(50331);
        CredentialsClient credentialsClient = new CredentialsClient(context, CredentialsOptions.DEFAULT);
        AppMethodBeat.m2505o(50331);
        return credentialsClient;
    }

    public static CredentialsClient getClient(Context context, CredentialsOptions credentialsOptions) {
        AppMethodBeat.m2504i(50332);
        CredentialsClient credentialsClient = new CredentialsClient(context, (AuthCredentialsOptions) credentialsOptions);
        AppMethodBeat.m2505o(50332);
        return credentialsClient;
    }
}
