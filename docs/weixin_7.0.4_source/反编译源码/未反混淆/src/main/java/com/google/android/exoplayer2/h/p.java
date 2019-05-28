package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class p implements f {
    private final u<? super p> bpJ;
    private long bpK;
    private RandomAccessFile bqD;
    private boolean opened;
    private Uri uri;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public p() {
        this(null);
    }

    public p(u<? super p> uVar) {
        this.bpJ = uVar;
    }

    public final long a(i iVar) {
        AppMethodBeat.i(95835);
        try {
            this.uri = iVar.uri;
            this.bqD = new RandomAccessFile(iVar.uri.getPath(), "r");
            this.bqD.seek(iVar.position);
            this.bpK = iVar.bgY == -1 ? this.bqD.length() - iVar.position : iVar.bgY;
            if (this.bpK < 0) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(95835);
                throw eOFException;
            }
            this.opened = true;
            if (this.bpJ != null) {
                this.bpJ.tq();
            }
            long j = this.bpK;
            AppMethodBeat.o(95835);
            return j;
        } catch (IOException e) {
            a aVar = new a(e);
            AppMethodBeat.o(95835);
            throw aVar;
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95836);
        if (i2 == 0) {
            AppMethodBeat.o(95836);
            return 0;
        } else if (this.bpK == 0) {
            AppMethodBeat.o(95836);
            return -1;
        } else {
            try {
                int read = this.bqD.read(bArr, i, (int) Math.min(this.bpK, (long) i2));
                if (read > 0) {
                    this.bpK -= (long) read;
                    if (this.bpJ != null) {
                        this.bpJ.eK(read);
                    }
                }
                AppMethodBeat.o(95836);
                return read;
            } catch (IOException e) {
                a aVar = new a(e);
                AppMethodBeat.o(95836);
                throw aVar;
            }
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() {
        AppMethodBeat.i(95837);
        this.uri = null;
        try {
            if (this.bqD != null) {
                this.bqD.close();
            }
            this.bqD = null;
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.tr();
                    AppMethodBeat.o(95837);
                    return;
                }
            }
            AppMethodBeat.o(95837);
        } catch (IOException e) {
            a aVar = new a(e);
            AppMethodBeat.o(95837);
            throw aVar;
        } catch (Throwable th) {
            this.bqD = null;
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.tr();
                }
            }
            AppMethodBeat.o(95837);
        }
    }
}
