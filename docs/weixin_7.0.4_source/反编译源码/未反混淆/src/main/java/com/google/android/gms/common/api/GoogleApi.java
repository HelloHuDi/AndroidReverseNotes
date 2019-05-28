package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zzad;
import com.google.android.gms.common.api.internal.zzbo;
import com.google.android.gms.common.api.internal.zzby;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.ClientSettings.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;

@KeepForSdk
public class GoogleApi<O extends ApiOptions> {
    private final Api<O> mApi;
    private final Context mContext;
    private final int mId;
    private final O zzcl;
    private final zzh<O> zzcm;
    private final Looper zzcn;
    private final GoogleApiClient zzco;
    private final StatusExceptionMapper zzcp;
    protected final GoogleApiManager zzcq;

    @KeepForSdk
    public static class Settings {
        @KeepForSdk
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zzcr;
        public final Looper zzcs;

        @KeepForSdk
        public static class Builder {
            private Looper zzcn;
            private StatusExceptionMapper zzcp;

            @KeepForSdk
            public Settings build() {
                AppMethodBeat.i(60505);
                if (this.zzcp == null) {
                    this.zzcp = new ApiExceptionMapper();
                }
                if (this.zzcn == null) {
                    this.zzcn = Looper.getMainLooper();
                }
                Settings settings = new Settings(this.zzcp, null, this.zzcn, null);
                AppMethodBeat.o(60505);
                return settings;
            }

            @KeepForSdk
            public Builder setLooper(Looper looper) {
                AppMethodBeat.i(60504);
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zzcn = looper;
                AppMethodBeat.o(60504);
                return this;
            }

            @KeepForSdk
            public Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
                AppMethodBeat.i(60503);
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zzcp = statusExceptionMapper;
                AppMethodBeat.o(60503);
                return this;
            }
        }

        static {
            AppMethodBeat.i(60506);
            AppMethodBeat.o(60506);
        }

        @KeepForSdk
        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zzcr = statusExceptionMapper;
            this.zzcs = looper;
        }

        /* synthetic */ Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper, zzb zzb) {
            this(statusExceptionMapper, null, looper);
        }
    }

    @KeepForSdk
    public GoogleApi(Activity activity, Api<O> api, O o, Settings settings) {
        AppMethodBeat.i(60509);
        Preconditions.checkNotNull(activity, "Null activity is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.mApi = api;
        this.zzcl = o;
        this.zzcn = settings.zzcs;
        this.zzcm = zzh.zza(this.mApi, this.zzcl);
        this.zzco = new zzbo(this);
        this.zzcq = GoogleApiManager.zzb(this.mContext);
        this.mId = this.zzcq.zzbg();
        this.zzcp = settings.zzcr;
        zzad.zza(activity, this.zzcq, this.zzcm);
        this.zzcq.zza(this);
        AppMethodBeat.o(60509);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Activity activity, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(activity, (Api) api, (ApiOptions) o, new Builder().setMapper(statusExceptionMapper).setLooper(activity.getMainLooper()).build());
        AppMethodBeat.i(60511);
        AppMethodBeat.o(60511);
    }

    @KeepForSdk
    protected GoogleApi(Context context, Api<O> api, Looper looper) {
        AppMethodBeat.i(60507);
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.mApi = api;
        this.zzcl = null;
        this.zzcn = looper;
        this.zzcm = zzh.zza(api);
        this.zzco = new zzbo(this);
        this.zzcq = GoogleApiManager.zzb(this.mContext);
        this.mId = this.zzcq.zzbg();
        this.zzcp = new ApiExceptionMapper();
        AppMethodBeat.o(60507);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, Looper looper, StatusExceptionMapper statusExceptionMapper) {
        this(context, (Api) api, (ApiOptions) o, new Builder().setLooper(looper).setMapper(statusExceptionMapper).build());
        AppMethodBeat.i(60508);
        AppMethodBeat.o(60508);
    }

    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        AppMethodBeat.i(60510);
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.mApi = api;
        this.zzcl = o;
        this.zzcn = settings.zzcs;
        this.zzcm = zzh.zza(this.mApi, this.zzcl);
        this.zzco = new zzbo(this);
        this.zzcq = GoogleApiManager.zzb(this.mContext);
        this.mId = this.zzcq.zzbg();
        this.zzcp = settings.zzcr;
        this.zzcq.zza(this);
        AppMethodBeat.o(60510);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(context, (Api) api, (ApiOptions) o, new Builder().setMapper(statusExceptionMapper).build());
        AppMethodBeat.i(60512);
        AppMethodBeat.o(60512);
    }

    private final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T zza(int i, T t) {
        AppMethodBeat.i(60513);
        t.zzx();
        this.zzcq.zza(this, i, (ApiMethodImpl) t);
        AppMethodBeat.o(60513);
        return t;
    }

    private final <TResult, A extends AnyClient> Task<TResult> zza(int i, TaskApiCall<A, TResult> taskApiCall) {
        AppMethodBeat.i(60514);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzcq.zza(this, i, taskApiCall, taskCompletionSource, this.zzcp);
        Task task = taskCompletionSource.getTask();
        AppMethodBeat.o(60514);
        return task;
    }

    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.zzco;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @KeepForSdk
    public Builder createClientSettingsBuilder() {
        Account account;
        Collection requestedScopes;
        Builder realClientPackageName;
        AppMethodBeat.i(60526);
        Builder builder = new Builder();
        if (this.zzcl instanceof HasGoogleSignInAccountOptions) {
            GoogleSignInAccount googleSignInAccount = ((HasGoogleSignInAccountOptions) this.zzcl).getGoogleSignInAccount();
            if (googleSignInAccount != null) {
                account = googleSignInAccount.getAccount();
                builder = builder.setAccount(account);
                if (this.zzcl instanceof HasGoogleSignInAccountOptions) {
                    googleSignInAccount = ((HasGoogleSignInAccountOptions) this.zzcl).getGoogleSignInAccount();
                    if (googleSignInAccount != null) {
                        requestedScopes = googleSignInAccount.getRequestedScopes();
                        realClientPackageName = builder.addAllRequiredScopes(requestedScopes).setRealClientClassName(this.mContext.getClass().getName()).setRealClientPackageName(this.mContext.getPackageName());
                        AppMethodBeat.o(60526);
                        return realClientPackageName;
                    }
                }
                requestedScopes = Collections.emptySet();
                realClientPackageName = builder.addAllRequiredScopes(requestedScopes).setRealClientClassName(this.mContext.getClass().getName()).setRealClientPackageName(this.mContext.getPackageName());
                AppMethodBeat.o(60526);
                return realClientPackageName;
            }
        }
        account = this.zzcl instanceof HasAccountOptions ? ((HasAccountOptions) this.zzcl).getAccount() : null;
        builder = builder.setAccount(account);
        if (this.zzcl instanceof HasGoogleSignInAccountOptions) {
        }
        requestedScopes = Collections.emptySet();
        realClientPackageName = builder.addAllRequiredScopes(requestedScopes).setRealClientClassName(this.mContext.getClass().getName()).setRealClientPackageName(this.mContext.getPackageName());
        AppMethodBeat.o(60526);
        return realClientPackageName;
    }

    /* Access modifiers changed, original: protected */
    @KeepForSdk
    public Task<Boolean> disconnectService() {
        AppMethodBeat.i(60524);
        Task zzc = this.zzcq.zzc(this);
        AppMethodBeat.o(60524);
        return zzc;
    }

    @KeepForSdk
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t) {
        AppMethodBeat.i(60519);
        ApiMethodImpl zza = zza(2, (ApiMethodImpl) t);
        AppMethodBeat.o(60519);
        return zza;
    }

    @KeepForSdk
    public <TResult, A extends AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        AppMethodBeat.i(60520);
        Task zza = zza(2, (TaskApiCall) taskApiCall);
        AppMethodBeat.o(60520);
        return zza;
    }

    @KeepForSdk
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T doRead(T t) {
        AppMethodBeat.i(60515);
        ApiMethodImpl zza = zza(0, (ApiMethodImpl) t);
        AppMethodBeat.o(60515);
        return zza;
    }

    @KeepForSdk
    public <TResult, A extends AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        AppMethodBeat.i(60516);
        Task zza = zza(0, (TaskApiCall) taskApiCall);
        AppMethodBeat.o(60516);
        return zza;
    }

    @KeepForSdk
    public <A extends AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T t, U u) {
        AppMethodBeat.i(60521);
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(u);
        Preconditions.checkNotNull(t.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(u.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(t.getListenerKey().equals(u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        Task zza = this.zzcq.zza(this, (RegisterListenerMethod) t, (UnregisterListenerMethod) u);
        AppMethodBeat.o(60521);
        return zza;
    }

    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(ListenerKey<?> listenerKey) {
        AppMethodBeat.i(60522);
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        Task zza = this.zzcq.zza(this, (ListenerKey) listenerKey);
        AppMethodBeat.o(60522);
        return zza;
    }

    @KeepForSdk
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T doWrite(T t) {
        AppMethodBeat.i(60517);
        ApiMethodImpl zza = zza(1, (ApiMethodImpl) t);
        AppMethodBeat.o(60517);
        return zza;
    }

    @KeepForSdk
    public <TResult, A extends AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        AppMethodBeat.i(60518);
        Task zza = zza(1, (TaskApiCall) taskApiCall);
        AppMethodBeat.o(60518);
        return zza;
    }

    public final Api<O> getApi() {
        return this.mApi;
    }

    @KeepForSdk
    public O getApiOptions() {
        return this.zzcl;
    }

    @KeepForSdk
    public Context getApplicationContext() {
        return this.mContext;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    @KeepForSdk
    public Looper getLooper() {
        return this.zzcn;
    }

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(L l, String str) {
        AppMethodBeat.i(60523);
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(l, this.zzcn, str);
        AppMethodBeat.o(60523);
        return createListenerHolder;
    }

    public Client zza(Looper looper, zza<O> zza) {
        AppMethodBeat.i(60525);
        Looper looper2 = looper;
        Client buildClient = this.mApi.zzk().buildClient(this.mContext, looper2, createClientSettingsBuilder().build(), this.zzcl, zza, zza);
        AppMethodBeat.o(60525);
        return buildClient;
    }

    public zzby zza(Context context, Handler handler) {
        AppMethodBeat.i(60527);
        zzby zzby = new zzby(context, handler, createClientSettingsBuilder().build());
        AppMethodBeat.o(60527);
        return zzby;
    }

    public final zzh<O> zzm() {
        return this.zzcm;
    }
}
