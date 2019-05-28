package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzff extends BaseGmsClient<zzey> {
    public zzff(Context context, Looper looper, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(context, looper, 93, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(68869);
        if (iBinder == null) {
            AppMethodBeat.o(68869);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (queryLocalInterface instanceof zzey) {
            zzey zzey = (zzey) queryLocalInterface;
            AppMethodBeat.o(68869);
            return zzey;
        }
        zzfa zzfa = new zzfa(iBinder);
        AppMethodBeat.o(68869);
        return zzfa;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.measurement.START";
    }
}
