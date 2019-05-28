package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.internal.p1161auth-api-phone.zzi;
import com.google.android.gms.tasks.Task;

public abstract class SmsRetrieverClient extends GoogleApi<NoOptions> implements SmsRetrieverApi {
    private static final Api<NoOptions> API = new Api("SmsRetriever.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final AbstractClientBuilder<zzi, NoOptions> CLIENT_BUILDER = new zza();
    private static final ClientKey<zzi> CLIENT_KEY = new ClientKey();

    public SmsRetrieverClient(Activity activity) {
        super(activity, API, null, new ApiExceptionMapper());
    }

    public SmsRetrieverClient(Context context) {
        super(context, API, null, new ApiExceptionMapper());
    }

    public abstract Task<Void> startSmsRetriever();
}
