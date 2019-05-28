package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

public abstract class RemoteCreator<T> {
    private final String zzabo;
    private T zzabp;

    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    protected RemoteCreator(String str) {
        this.zzabo = str;
    }

    public abstract T getRemoteCreator(IBinder iBinder);

    /* Access modifiers changed, original: protected|final */
    public final T getRemoteCreatorInstance(Context context) {
        if (this.zzabp == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.zzabp = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zzabo).newInstance());
            } catch (ClassNotFoundException e) {
                throw new RemoteCreatorException("Could not load creator class.", e);
            } catch (InstantiationException e2) {
                throw new RemoteCreatorException("Could not instantiate creator.", e2);
            } catch (IllegalAccessException e3) {
                throw new RemoteCreatorException("Could not access creator.", e3);
            }
        }
        return this.zzabp;
    }
}
