package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import javax.annotation.Nullable;

public final class zzbj extends InputStream {
    private final InputStream zzcv;
    @Nullable
    private volatile zzav zzcw;

    public zzbj(InputStream inputStream) {
        AppMethodBeat.i(71075);
        this.zzcv = (InputStream) Preconditions.checkNotNull(inputStream);
        AppMethodBeat.o(71075);
    }

    private final int zza(int i) {
        AppMethodBeat.i(71086);
        if (i == -1) {
            zzav zzav = this.zzcw;
            if (zzav != null) {
                ChannelIOException channelIOException = new ChannelIOException("Channel closed unexpectedly before stream was finished", zzav.zzg, zzav.zzcj);
                AppMethodBeat.o(71086);
                throw channelIOException;
            }
        }
        AppMethodBeat.o(71086);
        return i;
    }

    public final int available() {
        AppMethodBeat.i(71077);
        int available = this.zzcv.available();
        AppMethodBeat.o(71077);
        return available;
    }

    public final void close() {
        AppMethodBeat.i(71078);
        this.zzcv.close();
        AppMethodBeat.o(71078);
    }

    public final void mark(int i) {
        AppMethodBeat.i(71079);
        this.zzcv.mark(i);
        AppMethodBeat.o(71079);
    }

    public final boolean markSupported() {
        AppMethodBeat.i(71080);
        boolean markSupported = this.zzcv.markSupported();
        AppMethodBeat.o(71080);
        return markSupported;
    }

    public final int read() {
        AppMethodBeat.i(71081);
        int zza = zza(this.zzcv.read());
        AppMethodBeat.o(71081);
        return zza;
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.i(71082);
        int zza = zza(this.zzcv.read(bArr));
        AppMethodBeat.o(71082);
        return zza;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(71083);
        int zza = zza(this.zzcv.read(bArr, i, i2));
        AppMethodBeat.o(71083);
        return zza;
    }

    public final void reset() {
        AppMethodBeat.i(71084);
        this.zzcv.reset();
        AppMethodBeat.o(71084);
    }

    public final long skip(long j) {
        AppMethodBeat.i(71085);
        long skip = this.zzcv.skip(j);
        AppMethodBeat.o(71085);
        return skip;
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzav zzav) {
        AppMethodBeat.i(71076);
        this.zzcw = (zzav) Preconditions.checkNotNull(zzav);
        AppMethodBeat.o(71076);
    }
}
