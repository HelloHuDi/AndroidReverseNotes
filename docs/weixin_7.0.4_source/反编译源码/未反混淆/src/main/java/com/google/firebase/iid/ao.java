package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ao {
    final Messenger bwC;
    final zzi bwZ;

    ao(IBinder iBinder) {
        AppMethodBeat.i(108834);
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.bwC = new Messenger(iBinder);
            this.bwZ = null;
            AppMethodBeat.o(108834);
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.bwZ = new zzi(iBinder);
            this.bwC = null;
            AppMethodBeat.o(108834);
        } else {
            String str = "Invalid interface descriptor: ";
            interfaceDescriptor = String.valueOf(interfaceDescriptor);
            if (interfaceDescriptor.length() != 0) {
                str.concat(interfaceDescriptor);
            } else {
                interfaceDescriptor = new String(str);
            }
            RemoteException remoteException = new RemoteException();
            AppMethodBeat.o(108834);
            throw remoteException;
        }
    }
}
