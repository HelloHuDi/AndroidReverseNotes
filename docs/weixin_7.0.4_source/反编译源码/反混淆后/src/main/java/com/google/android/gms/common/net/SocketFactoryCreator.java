package com.google.android.gms.common.net;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.net.ISocketFactoryCreator.Stub;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SocketFactoryCreator extends RemoteCreator<ISocketFactoryCreator> {
    private static SocketFactoryCreator zzvr;

    protected SocketFactoryCreator() {
        super("com.google.android.gms.common.net.SocketFactoryCreatorImpl");
    }

    public static SocketFactoryCreator getInstance() {
        AppMethodBeat.m2504i(89930);
        if (zzvr == null) {
            zzvr = new SocketFactoryCreator();
        }
        SocketFactoryCreator socketFactoryCreator = zzvr;
        AppMethodBeat.m2505o(89930);
        return socketFactoryCreator;
    }

    /* Access modifiers changed, original: protected */
    public ISocketFactoryCreator getRemoteCreator(IBinder iBinder) {
        AppMethodBeat.m2504i(89929);
        ISocketFactoryCreator asInterface = Stub.asInterface(iBinder);
        AppMethodBeat.m2505o(89929);
        return asInterface;
    }

    public SSLSocketFactory makeSocketFactory(Context context, KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, boolean z) {
        AppMethodBeat.m2504i(89927);
        try {
            SSLSocketFactory sSLSocketFactory = (SSLSocketFactory) ObjectWrapper.unwrap(((ISocketFactoryCreator) getRemoteCreatorInstance(context)).newSocketFactory(ObjectWrapper.wrap(context), ObjectWrapper.wrap(keyManagerArr), ObjectWrapper.wrap(trustManagerArr), z));
            AppMethodBeat.m2505o(89927);
            return sSLSocketFactory;
        } catch (RemoteException | RemoteCreatorException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(89927);
            throw runtimeException;
        }
    }

    public SSLSocketFactory makeSocketFactoryWithCacheDir(Context context, KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, String str) {
        AppMethodBeat.m2504i(89928);
        try {
            SSLSocketFactory sSLSocketFactory = (SSLSocketFactory) ObjectWrapper.unwrap(((ISocketFactoryCreator) getRemoteCreatorInstance(context)).newSocketFactoryWithCacheDir(ObjectWrapper.wrap(context), ObjectWrapper.wrap(keyManagerArr), ObjectWrapper.wrap(trustManagerArr), str));
            AppMethodBeat.m2505o(89928);
            return sSLSocketFactory;
        } catch (RemoteException | RemoteCreatorException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(89928);
            throw runtimeException;
        }
    }
}
