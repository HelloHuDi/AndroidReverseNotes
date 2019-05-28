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

final class zzhj implements Runnable {
    private final /* synthetic */ Uri zzco;
    private final /* synthetic */ long zzcq;
    private final /* synthetic */ long zzcr;
    private final /* synthetic */ String zzcs;
    private final /* synthetic */ ResultHolder zzfh;
    private final /* synthetic */ zzhg zzfi;

    zzhj(zzhg zzhg, Uri uri, ResultHolder resultHolder, String str, long j, long j2) {
        this.zzfi = zzhg;
        this.zzco = uri;
        this.zzfh = resultHolder;
        this.zzcs = str;
        this.zzcq = j;
        this.zzcr = j2;
    }

    public final void run() {
        AppMethodBeat.m2504i(71417);
        Log.isLoggable("WearableClient", 2);
        if ("file".equals(this.zzco.getScheme())) {
            File file = new File(this.zzco.getPath());
            try {
                ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
                try {
                    ((zzep) this.zzfi.getService()).zza(new zzhc(this.zzfh), this.zzcs, open, this.zzcq, this.zzcr);
                    return;
                } catch (RemoteException e) {
                    this.zzfh.setFailedResult(new Status(8));
                    return;
                } finally {
                    try {
                        open.close();
                    } catch (IOException e2) {
                    }
                    AppMethodBeat.m2505o(71417);
                }
            } catch (FileNotFoundException e3) {
                String valueOf = String.valueOf(file);
                new StringBuilder(String.valueOf(valueOf).length() + 46).append("File couldn't be opened for Channel.sendFile: ").append(valueOf);
                this.zzfh.setFailedResult(new Status(13));
                AppMethodBeat.m2505o(71417);
                return;
            }
        }
        this.zzfh.setFailedResult(new Status(10, "Channel.sendFile used with non-file URI"));
        AppMethodBeat.m2505o(71417);
    }
}
