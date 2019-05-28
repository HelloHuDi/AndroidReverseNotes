package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import com.google.android.gms.internal.gcm.zzd;
import com.google.android.gms.internal.gcm.zze;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzm extends zzd implements zzl {
    zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.iid.IMessengerCompat");
    }

    public final void send(Message message) {
        AppMethodBeat.i(57575);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zze.zzd(obtainAndWriteInterfaceToken, message);
        transactOneway(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(57575);
    }
}
