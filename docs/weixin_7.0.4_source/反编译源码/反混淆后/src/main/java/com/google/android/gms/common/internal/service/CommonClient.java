package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.service.ICommonService.Stub;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CommonClient extends GmsClient<ICommonService> {
    public static final String START_SERVICE_ACTION = "com.google.android.gms.common.service.START";

    public CommonClient(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    /* Access modifiers changed, original: protected */
    public ICommonService createServiceInterface(IBinder iBinder) {
        AppMethodBeat.m2504i(61394);
        ICommonService asInterface = Stub.asInterface(iBinder);
        AppMethodBeat.m2505o(61394);
        return asInterface;
    }

    public int getMinApkVersion() {
        AppMethodBeat.m2504i(61395);
        int minApkVersion = super.getMinApkVersion();
        AppMethodBeat.m2505o(61395);
        return minApkVersion;
    }

    public String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    public String getStartServiceAction() {
        return START_SERVICE_ACTION;
    }
}
