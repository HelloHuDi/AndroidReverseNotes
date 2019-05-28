package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final Object sLock = new Object();
    private static final GoogleApiAvailabilityLight zzacw = GoogleApiAvailabilityLight.getInstance();
    private static Method zzacx = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    static {
        AppMethodBeat.i(90505);
        AppMethodBeat.o(90505);
    }

    public static void installIfNeeded(Context context) {
        AppMethodBeat.i(90503);
        Preconditions.checkNotNull(context, "Context must not be null");
        zzacw.verifyGooglePlayServicesIsAvailable(context, 11925000);
        GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException;
        try {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                Log.isLoggable("ProviderInstaller", 6);
                googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException(8);
                AppMethodBeat.o(90503);
                throw googlePlayServicesNotAvailableException;
            }
            synchronized (sLock) {
                try {
                    if (zzacx == null) {
                        zzacx = remoteContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
                    }
                    zzacx.invoke(null, new Object[]{remoteContext});
                } catch (Exception e) {
                    Throwable cause = e.getCause();
                    if (Log.isLoggable("ProviderInstaller", 6)) {
                        Object message = cause == null ? e.getMessage() : cause.getMessage();
                        String str = "Failed to install provider: ";
                        String valueOf = String.valueOf(message);
                        if (valueOf.length() != 0) {
                            str.concat(valueOf);
                        } else {
                            valueOf = new String(str);
                        }
                    }
                    googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException(8);
                    AppMethodBeat.o(90503);
                    throw googlePlayServicesNotAvailableException;
                } catch (Throwable th) {
                    AppMethodBeat.o(90503);
                    throw th;
                }
            }
            AppMethodBeat.o(90503);
        } catch (NotFoundException e2) {
            Log.isLoggable("ProviderInstaller", 6);
            googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException(8);
            AppMethodBeat.o(90503);
            throw googlePlayServicesNotAvailableException;
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        AppMethodBeat.i(90504);
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
        AppMethodBeat.o(90504);
    }
}
