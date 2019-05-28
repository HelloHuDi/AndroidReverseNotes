package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.Callable;

final class zzhh implements Callable<Boolean> {
    private final /* synthetic */ byte[] zzee;
    private final /* synthetic */ ParcelFileDescriptor zzfg;

    zzhh(zzhg zzhg, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
        this.zzfg = parcelFileDescriptor;
        this.zzee = bArr;
    }

    private final Boolean zzd() {
        String valueOf;
        AppMethodBeat.m2504i(71414);
        if (Log.isLoggable("WearableClient", 3)) {
            valueOf = String.valueOf(this.zzfg);
            new StringBuilder(String.valueOf(valueOf).length() + 36).append("processAssets: writing data to FD : ").append(valueOf);
        }
        AutoCloseOutputStream autoCloseOutputStream = new AutoCloseOutputStream(this.zzfg);
        Boolean bool;
        String valueOf2;
        try {
            autoCloseOutputStream.write(this.zzee);
            autoCloseOutputStream.flush();
            if (Log.isLoggable("WearableClient", 3)) {
                valueOf = String.valueOf(this.zzfg);
                new StringBuilder(String.valueOf(valueOf).length() + 27).append("processAssets: wrote data: ").append(valueOf);
            }
            bool = Boolean.TRUE;
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    valueOf2 = String.valueOf(this.zzfg);
                    new StringBuilder(String.valueOf(valueOf2).length() + 24).append("processAssets: closing: ").append(valueOf2);
                }
                autoCloseOutputStream.close();
            } catch (IOException e) {
            }
            AppMethodBeat.m2505o(71414);
            return bool;
        } catch (IOException e2) {
            valueOf = String.valueOf(this.zzfg);
            new StringBuilder(String.valueOf(valueOf).length() + 36).append("processAssets: writing data failed: ").append(valueOf);
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    valueOf = String.valueOf(this.zzfg);
                    new StringBuilder(String.valueOf(valueOf).length() + 24).append("processAssets: closing: ").append(valueOf);
                }
                autoCloseOutputStream.close();
            } catch (IOException e3) {
            }
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(71414);
            return bool;
        } catch (Throwable th) {
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    valueOf2 = String.valueOf(this.zzfg);
                    new StringBuilder(String.valueOf(valueOf2).length() + 24).append("processAssets: closing: ").append(valueOf2);
                }
                autoCloseOutputStream.close();
            } catch (IOException e4) {
            }
            AppMethodBeat.m2505o(71414);
        }
    }

    public final /* synthetic */ Object call() {
        AppMethodBeat.m2504i(71415);
        Boolean zzd = zzd();
        AppMethodBeat.m2505o(71415);
        return zzd;
    }
}
