package com.google.android.exoplayer2.h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements f {
    private InputStream azC;
    private final AssetManager azj;
    private final u<? super c> bpJ;
    private long bpK;
    private boolean opened;
    private Uri uri;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context, u<? super c> uVar) {
        AppMethodBeat.i(95787);
        this.azj = context.getAssets();
        this.bpJ = uVar;
        AppMethodBeat.o(95787);
    }

    public final long a(i iVar) {
        AppMethodBeat.i(95788);
        try {
            this.uri = iVar.uri;
            String path = this.uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.azC = this.azj.open(path, 1);
            if (this.azC.skip(iVar.position) < iVar.position) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(95788);
                throw eOFException;
            }
            if (iVar.bgY != -1) {
                this.bpK = iVar.bgY;
            } else {
                this.bpK = (long) this.azC.available();
                if (this.bpK == 2147483647L) {
                    this.bpK = -1;
                }
            }
            this.opened = true;
            if (this.bpJ != null) {
                this.bpJ.tq();
            }
            long j = this.bpK;
            AppMethodBeat.o(95788);
            return j;
        } catch (IOException e) {
            a aVar = new a(e);
            AppMethodBeat.o(95788);
            throw aVar;
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95789);
        if (i2 == 0) {
            AppMethodBeat.o(95789);
            return 0;
        } else if (this.bpK == 0) {
            AppMethodBeat.o(95789);
            return -1;
        } else {
            try {
                if (this.bpK != -1) {
                    i2 = (int) Math.min(this.bpK, (long) i2);
                }
                int read = this.azC.read(bArr, i, i2);
                if (read != -1) {
                    if (this.bpK != -1) {
                        this.bpK -= (long) read;
                    }
                    if (this.bpJ != null) {
                        this.bpJ.eK(read);
                    }
                    AppMethodBeat.o(95789);
                    return read;
                } else if (this.bpK != -1) {
                    a aVar = new a(new EOFException());
                    AppMethodBeat.o(95789);
                    throw aVar;
                } else {
                    AppMethodBeat.o(95789);
                    return -1;
                }
            } catch (IOException e) {
                a aVar2 = new a(e);
                AppMethodBeat.o(95789);
                throw aVar2;
            }
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() {
        AppMethodBeat.i(95790);
        this.uri = null;
        try {
            if (this.azC != null) {
                this.azC.close();
            }
            this.azC = null;
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.tr();
                    AppMethodBeat.o(95790);
                    return;
                }
            }
            AppMethodBeat.o(95790);
        } catch (IOException e) {
            a aVar = new a(e);
            AppMethodBeat.o(95790);
            throw aVar;
        } catch (Throwable th) {
            this.azC = null;
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.tr();
                }
            }
            AppMethodBeat.o(95790);
        }
    }
}
