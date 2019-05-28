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
        AppMethodBeat.m2504i(71075);
        this.zzcv = (InputStream) Preconditions.checkNotNull(inputStream);
        AppMethodBeat.m2505o(71075);
    }

    private final int zza(int i) {
        AppMethodBeat.m2504i(71086);
        if (i == -1) {
            zzav zzav = this.zzcw;
            if (zzav != null) {
                ChannelIOException channelIOException = new ChannelIOException("Channel closed unexpectedly before stream was finished", zzav.zzg, zzav.zzcj);
                AppMethodBeat.m2505o(71086);
                throw channelIOException;
            }
        }
        AppMethodBeat.m2505o(71086);
        return i;
    }

    public final int available() {
        AppMethodBeat.m2504i(71077);
        int available = this.zzcv.available();
        AppMethodBeat.m2505o(71077);
        return available;
    }

    public final void close() {
        AppMethodBeat.m2504i(71078);
        this.zzcv.close();
        AppMethodBeat.m2505o(71078);
    }

    public final void mark(int i) {
        AppMethodBeat.m2504i(71079);
        this.zzcv.mark(i);
        AppMethodBeat.m2505o(71079);
    }

    public final boolean markSupported() {
        AppMethodBeat.m2504i(71080);
        boolean markSupported = this.zzcv.markSupported();
        AppMethodBeat.m2505o(71080);
        return markSupported;
    }

    public final int read() {
        AppMethodBeat.m2504i(71081);
        int zza = zza(this.zzcv.read());
        AppMethodBeat.m2505o(71081);
        return zza;
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.m2504i(71082);
        int zza = zza(this.zzcv.read(bArr));
        AppMethodBeat.m2505o(71082);
        return zza;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(71083);
        int zza = zza(this.zzcv.read(bArr, i, i2));
        AppMethodBeat.m2505o(71083);
        return zza;
    }

    public final void reset() {
        AppMethodBeat.m2504i(71084);
        this.zzcv.reset();
        AppMethodBeat.m2505o(71084);
    }

    public final long skip(long j) {
        AppMethodBeat.m2504i(71085);
        long skip = this.zzcv.skip(j);
        AppMethodBeat.m2505o(71085);
        return skip;
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzav zzav) {
        AppMethodBeat.m2504i(71076);
        this.zzcw = (zzav) Preconditions.checkNotNull(zzav);
        AppMethodBeat.m2505o(71076);
    }
}
