package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

final class zzhi implements Runnable {
    private final /* synthetic */ Uri zzco;
    private final /* synthetic */ boolean zzcp;
    private final /* synthetic */ String zzcs;
    private final /* synthetic */ ResultHolder zzfh;
    private final /* synthetic */ zzhg zzfi;

    zzhi(zzhg zzhg, Uri uri, ResultHolder resultHolder, boolean z, String str) {
        this.zzfi = zzhg;
        this.zzco = uri;
        this.zzfh = resultHolder;
        this.zzcp = z;
        this.zzcs = str;
    }

    public final void run() {
        AppMethodBeat.i(71416);
        Log.isLoggable("WearableClient", 2);
        if ("file".equals(this.zzco.getScheme())) {
            Object file = new File(this.zzco.getPath());
            try {
                ParcelFileDescriptor open = ParcelFileDescriptor.open(file, (this.zzcp ? 33554432 : 0) | 671088640);
                try {
                    ((zzep) this.zzfi.getService()).zza(new zzhf(this.zzfh), this.zzcs, open);
                    return;
                } catch (RemoteException e) {
                    this.zzfh.setFailedResult(new Status(8));
                    return;
                } finally {
                    try {
                        open.close();
                    } catch (IOException e2) {
                    }
                    AppMethodBeat.o(71416);
                }
            } catch (FileNotFoundException e3) {
                String valueOf = String.valueOf(file);
                new StringBuilder(String.valueOf(valueOf).length() + 49).append("File couldn't be opened for Channel.receiveFile: ").append(valueOf);
                this.zzfh.setFailedResult(new Status(13));
                AppMethodBeat.o(71416);
                return;
            }
        }
        this.zzfh.setFailedResult(new Status(10, "Channel.receiveFile used with non-file URI"));
        AppMethodBeat.o(71416);
    }
}
