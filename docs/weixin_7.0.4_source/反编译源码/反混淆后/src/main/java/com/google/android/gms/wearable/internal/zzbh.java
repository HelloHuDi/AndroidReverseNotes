package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

final class zzbh implements GetOutputStreamResult {
    private final OutputStream zzcu;
    private final Status zzp;

    zzbh(Status status, @Nullable OutputStream outputStream) {
        AppMethodBeat.m2504i(71072);
        this.zzp = (Status) Preconditions.checkNotNull(status);
        this.zzcu = outputStream;
        AppMethodBeat.m2505o(71072);
    }

    @Nullable
    public final OutputStream getOutputStream() {
        return this.zzcu;
    }

    public final Status getStatus() {
        return this.zzp;
    }

    public final void release() {
        AppMethodBeat.m2504i(71073);
        if (this.zzcu != null) {
            try {
                this.zzcu.close();
                AppMethodBeat.m2505o(71073);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(71073);
    }
}
