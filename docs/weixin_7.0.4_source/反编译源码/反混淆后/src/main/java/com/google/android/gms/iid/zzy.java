package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzy {
    final Messenger zzab;
    final MessengerCompat zzcj;

    zzy(IBinder iBinder) {
        AppMethodBeat.m2504i(57617);
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.zzab = new Messenger(iBinder);
            this.zzcj = null;
            AppMethodBeat.m2505o(57617);
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.zzcj = new MessengerCompat(iBinder);
            this.zzab = null;
            AppMethodBeat.m2505o(57617);
        } else {
            String str = "Invalid interface descriptor: ";
            interfaceDescriptor = String.valueOf(interfaceDescriptor);
            if (interfaceDescriptor.length() != 0) {
                str.concat(interfaceDescriptor);
            } else {
                interfaceDescriptor = new String(str);
            }
            RemoteException remoteException = new RemoteException();
            AppMethodBeat.m2505o(57617);
            throw remoteException;
        }
    }
}
