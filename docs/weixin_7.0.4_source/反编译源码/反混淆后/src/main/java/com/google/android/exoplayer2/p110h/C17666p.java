package com.google.android.exoplayer2.p110h;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.google.android.exoplayer2.h.p */
public final class C17666p implements C0867f {
    private final C41615u<? super C17666p> bpJ;
    private long bpK;
    private RandomAccessFile bqD;
    private boolean opened;
    private Uri uri;

    /* renamed from: com.google.android.exoplayer2.h.p$a */
    public static class C17667a extends IOException {
        public C17667a(IOException iOException) {
            super(iOException);
        }
    }

    public C17666p() {
        this(null);
    }

    public C17666p(C41615u<? super C17666p> c41615u) {
        this.bpJ = c41615u;
    }

    /* renamed from: a */
    public final long mo2583a(C17665i c17665i) {
        AppMethodBeat.m2504i(95835);
        try {
            this.uri = c17665i.uri;
            this.bqD = new RandomAccessFile(c17665i.uri.getPath(), "r");
            this.bqD.seek(c17665i.position);
            this.bpK = c17665i.bgY == -1 ? this.bqD.length() - c17665i.position : c17665i.bgY;
            if (this.bpK < 0) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.m2505o(95835);
                throw eOFException;
            }
            this.opened = true;
            if (this.bpJ != null) {
                this.bpJ.mo59502tq();
            }
            long j = this.bpK;
            AppMethodBeat.m2505o(95835);
            return j;
        } catch (IOException e) {
            C17667a c17667a = new C17667a(e);
            AppMethodBeat.m2505o(95835);
            throw c17667a;
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95836);
        if (i2 == 0) {
            AppMethodBeat.m2505o(95836);
            return 0;
        } else if (this.bpK == 0) {
            AppMethodBeat.m2505o(95836);
            return -1;
        } else {
            try {
                int read = this.bqD.read(bArr, i, (int) Math.min(this.bpK, (long) i2));
                if (read > 0) {
                    this.bpK -= (long) read;
                    if (this.bpJ != null) {
                        this.bpJ.mo59501eK(read);
                    }
                }
                AppMethodBeat.m2505o(95836);
                return read;
            } catch (IOException e) {
                C17667a c17667a = new C17667a(e);
                AppMethodBeat.m2505o(95836);
                throw c17667a;
            }
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() {
        AppMethodBeat.m2504i(95837);
        this.uri = null;
        try {
            if (this.bqD != null) {
                this.bqD.close();
            }
            this.bqD = null;
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.mo59503tr();
                    AppMethodBeat.m2505o(95837);
                    return;
                }
            }
            AppMethodBeat.m2505o(95837);
        } catch (IOException e) {
            C17667a c17667a = new C17667a(e);
            AppMethodBeat.m2505o(95837);
            throw c17667a;
        } catch (Throwable th) {
            this.bqD = null;
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.mo59503tr();
                }
            }
            AppMethodBeat.m2505o(95837);
        }
    }
}
