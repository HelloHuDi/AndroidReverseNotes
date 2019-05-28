package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

final class zzgt extends zzgm<GetOutputStreamResult> {
    private final zzbr zzeu;

    public zzgt(ResultHolder<GetOutputStreamResult> resultHolder, zzbr zzbr) {
        super(resultHolder);
        AppMethodBeat.i(71382);
        this.zzeu = (zzbr) Preconditions.checkNotNull(zzbr);
        AppMethodBeat.o(71382);
    }

    public final void zza(zzdo zzdo) {
        AppMethodBeat.i(71383);
        OutputStream outputStream = null;
        if (zzdo.zzdr != null) {
            outputStream = new zzbl(new AutoCloseOutputStream(zzdo.zzdr));
            this.zzeu.zza(new zzbm(outputStream));
        }
        zza(new zzbh(new Status(zzdo.statusCode), outputStream));
        AppMethodBeat.o(71383);
    }
}
