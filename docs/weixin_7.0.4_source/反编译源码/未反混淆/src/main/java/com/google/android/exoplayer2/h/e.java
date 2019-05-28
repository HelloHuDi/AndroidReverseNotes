package com.google.android.exoplayer2.h;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class e implements f {
    private InputStream azC;
    private final u<? super e> bpJ;
    private long bpK;
    private final ContentResolver bpL;
    private AssetFileDescriptor bpM;
    private boolean opened;
    private Uri uri;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public e(Context context, u<? super e> uVar) {
        AppMethodBeat.i(95791);
        this.bpL = context.getContentResolver();
        this.bpJ = uVar;
        AppMethodBeat.o(95791);
    }

    public final long a(i iVar) {
        AppMethodBeat.i(95792);
        try {
            this.uri = iVar.uri;
            this.bpM = this.bpL.openAssetFileDescriptor(this.uri, "r");
            if (this.bpM == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Could not open file descriptor for: " + this.uri);
                AppMethodBeat.o(95792);
                throw fileNotFoundException;
            }
            this.azC = new FileInputStream(this.bpM.getFileDescriptor());
            long startOffset = this.bpM.getStartOffset();
            startOffset = this.azC.skip(iVar.position + startOffset) - startOffset;
            if (startOffset != iVar.position) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(95792);
                throw eOFException;
            }
            if (iVar.bgY != -1) {
                this.bpK = iVar.bgY;
            } else {
                long length = this.bpM.getLength();
                if (length == -1) {
                    this.bpK = (long) this.azC.available();
                    if (this.bpK == 0) {
                        this.bpK = -1;
                    }
                } else {
                    this.bpK = length - startOffset;
                }
            }
            this.opened = true;
            if (this.bpJ != null) {
                this.bpJ.tq();
            }
            startOffset = this.bpK;
            AppMethodBeat.o(95792);
            return startOffset;
        } catch (IOException e) {
            a aVar = new a(e);
            AppMethodBeat.o(95792);
            throw aVar;
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95793);
        if (i2 == 0) {
            AppMethodBeat.o(95793);
            return 0;
        } else if (this.bpK == 0) {
            AppMethodBeat.o(95793);
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
                    AppMethodBeat.o(95793);
                    return read;
                } else if (this.bpK != -1) {
                    a aVar = new a(new EOFException());
                    AppMethodBeat.o(95793);
                    throw aVar;
                } else {
                    AppMethodBeat.o(95793);
                    return -1;
                }
            } catch (IOException e) {
                a aVar2 = new a(e);
                AppMethodBeat.o(95793);
                throw aVar2;
            }
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() {
        a aVar;
        AppMethodBeat.i(95794);
        this.uri = null;
        try {
            if (this.azC != null) {
                this.azC.close();
            }
            this.azC = null;
            try {
                if (this.bpM != null) {
                    this.bpM.close();
                }
                this.bpM = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.bpJ != null) {
                        this.bpJ.tr();
                        AppMethodBeat.o(95794);
                        return;
                    }
                }
                AppMethodBeat.o(95794);
            } catch (IOException e) {
                aVar = new a(e);
                AppMethodBeat.o(95794);
                throw aVar;
            } catch (Throwable th) {
                this.bpM = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.bpJ != null) {
                        this.bpJ.tr();
                    }
                }
                AppMethodBeat.o(95794);
            }
        } catch (IOException e2) {
            aVar = new a(e2);
            AppMethodBeat.o(95794);
            throw aVar;
        } catch (Throwable th2) {
            this.azC = null;
            try {
                if (this.bpM != null) {
                    this.bpM.close();
                }
                this.bpM = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.bpJ != null) {
                        this.bpJ.tr();
                    }
                }
                AppMethodBeat.o(95794);
            } catch (IOException e22) {
                aVar = new a(e22);
                AppMethodBeat.o(95794);
                throw aVar;
            } catch (Throwable th3) {
                this.bpM = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.bpJ != null) {
                        this.bpJ.tr();
                    }
                }
                AppMethodBeat.o(95794);
            }
        }
    }
}
