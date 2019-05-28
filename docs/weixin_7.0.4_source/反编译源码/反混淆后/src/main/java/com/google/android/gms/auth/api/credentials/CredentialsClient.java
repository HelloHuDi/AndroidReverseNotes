package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzaw;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CredentialsClient extends GoogleApi<AuthCredentialsOptions> {
    CredentialsClient(Activity activity, AuthCredentialsOptions authCredentialsOptions) {
        super(activity, Auth.CREDENTIALS_API, (ApiOptions) authCredentialsOptions, new ApiExceptionMapper());
        AppMethodBeat.m2504i(50334);
        AppMethodBeat.m2505o(50334);
    }

    CredentialsClient(Context context, AuthCredentialsOptions authCredentialsOptions) {
        super(context, Auth.CREDENTIALS_API, (ApiOptions) authCredentialsOptions, new ApiExceptionMapper());
        AppMethodBeat.m2504i(50333);
        AppMethodBeat.m2505o(50333);
    }

    public Task<Void> delete(Credential credential) {
        AppMethodBeat.m2504i(50338);
        Task toVoidTask = PendingResultUtil.toVoidTask(Auth.CredentialsApi.delete(asGoogleApiClient(), credential));
        AppMethodBeat.m2505o(50338);
        return toVoidTask;
    }

    public Task<Void> disableAutoSignIn() {
        AppMethodBeat.m2504i(50339);
        Task toVoidTask = PendingResultUtil.toVoidTask(Auth.CredentialsApi.disableAutoSignIn(asGoogleApiClient()));
        AppMethodBeat.m2505o(50339);
        return toVoidTask;
    }

    public PendingIntent getHintPickerIntent(HintRequest hintRequest) {
        AppMethodBeat.m2504i(50336);
        PendingIntent zzd = zzaw.zzd(getApplicationContext(), (AuthCredentialsOptions) getApiOptions(), hintRequest);
        AppMethodBeat.m2505o(50336);
        return zzd;
    }

    public Task<CredentialRequestResponse> request(CredentialRequest credentialRequest) {
        AppMethodBeat.m2504i(50335);
        Task toResponseTask = PendingResultUtil.toResponseTask(Auth.CredentialsApi.request(asGoogleApiClient(), credentialRequest), new CredentialRequestResponse());
        AppMethodBeat.m2505o(50335);
        return toResponseTask;
    }

    public Task<Void> save(Credential credential) {
        AppMethodBeat.m2504i(50337);
        Task toVoidTask = PendingResultUtil.toVoidTask(Auth.CredentialsApi.save(asGoogleApiClient(), credential));
        AppMethodBeat.m2505o(50337);
        return toVoidTask;
    }
}
