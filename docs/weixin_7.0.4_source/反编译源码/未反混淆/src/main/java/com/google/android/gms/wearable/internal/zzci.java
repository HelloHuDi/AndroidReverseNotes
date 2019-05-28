package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class zzci implements GetFdForAssetResult {
    private volatile boolean closed = false;
    private volatile InputStream zzct;
    private volatile ParcelFileDescriptor zzf;
    private final Status zzp;

    public zzci(Status status, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzp = status;
        this.zzf = parcelFileDescriptor;
    }

    public final ParcelFileDescriptor getFd() {
        AppMethodBeat.i(71137);
        if (this.closed) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot access the file descriptor after release().");
            AppMethodBeat.o(71137);
            throw illegalStateException;
        }
        ParcelFileDescriptor parcelFileDescriptor = this.zzf;
        AppMethodBeat.o(71137);
        return parcelFileDescriptor;
    }

    public final InputStream getInputStream() {
        AppMethodBeat.i(71138);
        if (this.closed) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot access the input stream after release().");
            AppMethodBeat.o(71138);
            throw illegalStateException;
        } else if (this.zzf == null) {
            AppMethodBeat.o(71138);
            return null;
        } else {
            if (this.zzct == null) {
                this.zzct = new AutoCloseInputStream(this.zzf);
            }
            InputStream inputStream = this.zzct;
            AppMethodBeat.o(71138);
            return inputStream;
        }
    }

    public final Status getStatus() {
        return this.zzp;
    }

    public final void release() {
        AppMethodBeat.i(71139);
        if (this.zzf == null) {
            AppMethodBeat.o(71139);
        } else if (this.closed) {
            IllegalStateException illegalStateException = new IllegalStateException("releasing an already released result.");
            AppMethodBeat.o(71139);
            throw illegalStateException;
        } else {
            try {
                if (this.zzct != null) {
                    this.zzct.close();
                } else {
                    this.zzf.close();
                }
                this.closed = true;
                this.zzf = null;
                this.zzct = null;
                AppMethodBeat.o(71139);
            } catch (IOException e) {
                AppMethodBeat.o(71139);
            }
        }
    }
}
