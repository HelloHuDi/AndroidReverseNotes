package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.internal.ISignInButtonCreator.Stub;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignInButtonCreator extends RemoteCreator<ISignInButtonCreator> {
    private static final SignInButtonCreator zzuz = new SignInButtonCreator();

    static {
        AppMethodBeat.i(61382);
        AppMethodBeat.o(61382);
    }

    private SignInButtonCreator() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View createView(Context context, int i, int i2) {
        AppMethodBeat.i(61378);
        View zza = zzuz.zza(context, i, i2);
        AppMethodBeat.o(61378);
        return zza;
    }

    private final View zza(Context context, int i, int i2) {
        AppMethodBeat.i(61379);
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, null);
            View view = (View) ObjectWrapper.unwrap(((ISignInButtonCreator) getRemoteCreatorInstance(context)).newSignInButtonFromConfig(ObjectWrapper.wrap(context), signInButtonConfig));
            AppMethodBeat.o(61379);
            return view;
        } catch (Exception e) {
            RemoteCreatorException remoteCreatorException = new RemoteCreatorException("Could not get button with size " + i + " and color " + i2, e);
            AppMethodBeat.o(61379);
            throw remoteCreatorException;
        }
    }

    public final ISignInButtonCreator getRemoteCreator(IBinder iBinder) {
        AppMethodBeat.i(61380);
        ISignInButtonCreator asInterface = Stub.asInterface(iBinder);
        AppMethodBeat.o(61380);
        return asInterface;
    }
}
