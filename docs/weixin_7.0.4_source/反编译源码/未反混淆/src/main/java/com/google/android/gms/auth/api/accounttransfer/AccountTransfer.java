package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzw;
import com.google.android.gms.internal.auth.zzx;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AccountTransfer {
    public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
    public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
    public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
    public static final String KEY_EXTRA_ACCOUNT_TYPE = "key_extra_account_type";
    private static final ClientKey<zzx> zzau = new ClientKey();
    private static final AbstractClientBuilder<zzx, zzq> zzav = new zzd();
    private static final Api<zzq> zzaw = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzav, zzau);
    @Deprecated
    private static final zze zzax = new zzw();
    private static final zzt zzay = new zzw();

    static {
        AppMethodBeat.i(76977);
        AppMethodBeat.o(76977);
    }

    private AccountTransfer() {
    }

    public static AccountTransferClient getAccountTransferClient(Activity activity) {
        AppMethodBeat.i(76975);
        AccountTransferClient accountTransferClient = new AccountTransferClient(activity);
        AppMethodBeat.o(76975);
        return accountTransferClient;
    }

    public static AccountTransferClient getAccountTransferClient(Context context) {
        AppMethodBeat.i(76976);
        AccountTransferClient accountTransferClient = new AccountTransferClient(context);
        AppMethodBeat.o(76976);
        return accountTransferClient;
    }
}
