package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzae;
import com.google.android.gms.internal.auth.zzag;
import com.google.android.gms.internal.auth.zzai;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzv;
import com.google.android.gms.internal.auth.zzx;
import com.google.android.gms.internal.auth.zzy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AccountTransferClient extends GoogleApi<zzq> {
    private static final ClientKey<zzx> zzau = new ClientKey();
    private static final AbstractClientBuilder<zzx, zzq> zzav = new zzf();
    private static final Api<zzq> zzaw = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzav, zzau);

    static class zzd<T> extends zzv {
        private zze<T> zzbg;

        public zzd(zze<T> zze) {
            this.zzbg = zze;
        }

        public final void onFailure(Status status) {
            AppMethodBeat.m2504i(76978);
            this.zzbg.zzd(status);
            AppMethodBeat.m2505o(76978);
        }
    }

    static abstract class zze<T> extends TaskApiCall<zzx, T> {
        private TaskCompletionSource<T> zzbh;

        private zze() {
        }

        /* synthetic */ zze(zzf zzf) {
            this();
        }

        public /* synthetic */ void doExecute(AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
            zzx zzx = (zzx) anyClient;
            this.zzbh = taskCompletionSource;
            zzd((zzac) zzx.getService());
        }

        /* Access modifiers changed, original: protected|final */
        public final void setResult(T t) {
            this.zzbh.setResult(t);
        }

        /* Access modifiers changed, original: protected|final */
        public final void zzd(Status status) {
            AccountTransferClient.zze(this.zzbh, status);
        }

        public abstract void zzd(zzac zzac);
    }

    static abstract class zzf extends zze<Void> {
        zzab zzbi;

        private zzf() {
            super();
            this.zzbi = new zzn(this);
        }

        /* synthetic */ zzf(zzf zzf) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(76988);
        AppMethodBeat.m2505o(76988);
    }

    AccountTransferClient(Activity activity) {
        super(activity, zzaw, null, new Builder().setMapper(new ApiExceptionMapper()).build());
        AppMethodBeat.m2504i(76980);
        AppMethodBeat.m2505o(76980);
    }

    AccountTransferClient(Context context) {
        super(context, zzaw, null, new Builder().setMapper(new ApiExceptionMapper()).build());
        AppMethodBeat.m2504i(76979);
        AppMethodBeat.m2505o(76979);
    }

    private static void zzd(TaskCompletionSource taskCompletionSource, Status status) {
        AppMethodBeat.m2504i(76986);
        taskCompletionSource.setException(new AccountTransferException(status));
        AppMethodBeat.m2505o(76986);
    }

    static /* synthetic */ void zze(TaskCompletionSource taskCompletionSource, Status status) {
        AppMethodBeat.m2504i(76987);
        zzd(taskCompletionSource, status);
        AppMethodBeat.m2505o(76987);
    }

    public Task<DeviceMetaData> getDeviceMetaData(String str) {
        AppMethodBeat.m2504i(76983);
        Preconditions.checkNotNull(str);
        Task doRead = doRead((TaskApiCall) new zzj(this, new zzy(str)));
        AppMethodBeat.m2505o(76983);
        return doRead;
    }

    public Task<Void> notifyCompletion(String str, int i) {
        AppMethodBeat.m2504i(76985);
        Preconditions.checkNotNull(str);
        Task doWrite = doWrite((TaskApiCall) new zzm(this, new zzae(str, i)));
        AppMethodBeat.m2505o(76985);
        return doWrite;
    }

    public Task<byte[]> retrieveData(String str) {
        AppMethodBeat.m2504i(76982);
        Preconditions.checkNotNull(str);
        Task doRead = doRead((TaskApiCall) new zzh(this, new zzag(str)));
        AppMethodBeat.m2505o(76982);
        return doRead;
    }

    public Task<Void> sendData(String str, byte[] bArr) {
        AppMethodBeat.m2504i(76981);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bArr);
        Task doWrite = doWrite((TaskApiCall) new zzg(this, new zzai(str, bArr)));
        AppMethodBeat.m2505o(76981);
        return doWrite;
    }

    public Task<Void> showUserChallenge(String str, PendingIntent pendingIntent) {
        AppMethodBeat.m2504i(76984);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(pendingIntent);
        Task doWrite = doWrite((TaskApiCall) new zzl(this, new zzak(str, pendingIntent)));
        AppMethodBeat.m2505o(76984);
        return doWrite;
    }
}
