package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

final class zzbg implements GetInputStreamResult {
    private final InputStream zzct;
    private final Status zzp;

    zzbg(Status status, @Nullable InputStream inputStream) {
        AppMethodBeat.m2504i(71070);
        this.zzp = (Status) Preconditions.checkNotNull(status);
        this.zzct = inputStream;
        AppMethodBeat.m2505o(71070);
    }

    @Nullable
    public final InputStream getInputStream() {
        return this.zzct;
    }

    public final Status getStatus() {
        return this.zzp;
    }

    public final void release() {
        AppMethodBeat.m2504i(71071);
        if (this.zzct != null) {
            try {
                this.zzct.close();
                AppMethodBeat.m2505o(71071);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(71071);
    }
}
