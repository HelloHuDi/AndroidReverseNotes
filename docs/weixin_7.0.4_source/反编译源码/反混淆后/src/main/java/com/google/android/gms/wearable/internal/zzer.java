package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzer<T> {
    private final Map<T, zzhk<T>> zzeb = new HashMap();

    zzer() {
        AppMethodBeat.m2504i(71279);
        AppMethodBeat.m2505o(71279);
    }

    public final void zza(IBinder iBinder) {
        AppMethodBeat.m2504i(71280);
        synchronized (this.zzeb) {
            zzep zzep;
            if (iBinder == null) {
                zzep = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
                if (queryLocalInterface instanceof zzep) {
                    zzep = (zzep) queryLocalInterface;
                } else {
                    Object zzep2 = new zzeq(iBinder);
                }
            }
            zzhk zzhk;
            try {
                zzek zzgz = new zzgz();
                for (Entry entry : this.zzeb.entrySet()) {
                    zzhk = (zzhk) entry.getValue();
                    zzep2.zza(zzgz, new zzd(zzhk));
                    if (Log.isLoggable("WearableClient", 3)) {
                        String valueOf = String.valueOf(entry.getKey());
                        String valueOf2 = String.valueOf(zzhk);
                        new StringBuilder((String.valueOf(valueOf).length() + 27) + String.valueOf(valueOf2).length()).append("onPostInitHandler: added: ").append(valueOf).append("/").append(valueOf2);
                    }
                }
            } catch (RemoteException e) {
                String valueOf3 = String.valueOf(entry.getKey());
                String valueOf4 = String.valueOf(zzhk);
                new StringBuilder((String.valueOf(valueOf3).length() + 32) + String.valueOf(valueOf4).length()).append("onPostInitHandler: Didn't add: ").append(valueOf3).append("/").append(valueOf4);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(71280);
            }
        }
        AppMethodBeat.m2505o(71280);
    }

    public final void zza(zzhg zzhg, ResultHolder<Status> resultHolder, T t) {
        AppMethodBeat.m2504i(71282);
        synchronized (this.zzeb) {
            try {
                zzhk zzhk = (zzhk) this.zzeb.remove(t);
                if (zzhk == null) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        String valueOf = String.valueOf(t);
                        new StringBuilder(String.valueOf(valueOf).length() + 25).append("remove Listener unknown: ").append(valueOf);
                    }
                    resultHolder.setResult(new Status(WearableStatusCodes.UNKNOWN_LISTENER));
                } else {
                    zzhk.clear();
                    if (Log.isLoggable("WearableClient", 2)) {
                        String valueOf2 = String.valueOf(t);
                        new StringBuilder(String.valueOf(valueOf2).length() + 24).append("service.removeListener: ").append(valueOf2);
                    }
                    ((zzep) zzhg.getService()).zza(new zzet(this.zzeb, t, resultHolder), new zzfw(zzhk));
                    AppMethodBeat.m2505o(71282);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(71282);
            }
        }
    }

    public final void zza(zzhg zzhg, ResultHolder<Status> resultHolder, T t, zzhk<T> zzhk) {
        AppMethodBeat.m2504i(71281);
        synchronized (this.zzeb) {
            try {
                String valueOf;
                if (this.zzeb.get(t) != null) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        valueOf = String.valueOf(t);
                        new StringBuilder(String.valueOf(valueOf).length() + 20).append("duplicate listener: ").append(valueOf);
                    }
                    resultHolder.setResult(new Status(WearableStatusCodes.DUPLICATE_LISTENER));
                    AppMethodBeat.m2505o(71281);
                    return;
                }
                if (Log.isLoggable("WearableClient", 2)) {
                    valueOf = String.valueOf(t);
                    new StringBuilder(String.valueOf(valueOf).length() + 14).append("new listener: ").append(valueOf);
                }
                this.zzeb.put(t, zzhk);
                ((zzep) zzhg.getService()).zza(new zzes(this.zzeb, t, resultHolder), new zzd(zzhk));
                AppMethodBeat.m2505o(71281);
            } catch (RemoteException e) {
                if (Log.isLoggable("WearableClient", 3)) {
                    String valueOf2 = String.valueOf(t);
                    new StringBuilder(String.valueOf(valueOf2).length() + 39).append("addListener failed, removing listener: ").append(valueOf2);
                }
                this.zzeb.remove(t);
                AppMethodBeat.m2505o(71281);
                throw e;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(71281);
                throw th;
            }
        }
    }
}
