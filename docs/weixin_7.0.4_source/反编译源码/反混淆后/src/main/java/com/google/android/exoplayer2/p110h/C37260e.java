package com.google.android.exoplayer2.p110h;

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

/* renamed from: com.google.android.exoplayer2.h.e */
public final class C37260e implements C0867f {
    private InputStream azC;
    private final C41615u<? super C37260e> bpJ;
    private long bpK;
    private final ContentResolver bpL;
    private AssetFileDescriptor bpM;
    private boolean opened;
    private Uri uri;

    /* renamed from: com.google.android.exoplayer2.h.e$a */
    public static class C0866a extends IOException {
        public C0866a(IOException iOException) {
            super(iOException);
        }
    }

    public C37260e(Context context, C41615u<? super C37260e> c41615u) {
        AppMethodBeat.m2504i(95791);
        this.bpL = context.getContentResolver();
        this.bpJ = c41615u;
        AppMethodBeat.m2505o(95791);
    }

    /* renamed from: a */
    public final long mo2583a(C17665i c17665i) {
        AppMethodBeat.m2504i(95792);
        try {
            this.uri = c17665i.uri;
            this.bpM = this.bpL.openAssetFileDescriptor(this.uri, "r");
            if (this.bpM == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Could not open file descriptor for: " + this.uri);
                AppMethodBeat.m2505o(95792);
                throw fileNotFoundException;
            }
            this.azC = new FileInputStream(this.bpM.getFileDescriptor());
            long startOffset = this.bpM.getStartOffset();
            startOffset = this.azC.skip(c17665i.position + startOffset) - startOffset;
            if (startOffset != c17665i.position) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.m2505o(95792);
                throw eOFException;
            }
            if (c17665i.bgY != -1) {
                this.bpK = c17665i.bgY;
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
                this.bpJ.mo59502tq();
            }
            startOffset = this.bpK;
            AppMethodBeat.m2505o(95792);
            return startOffset;
        } catch (IOException e) {
            C0866a c0866a = new C0866a(e);
            AppMethodBeat.m2505o(95792);
            throw c0866a;
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95793);
        if (i2 == 0) {
            AppMethodBeat.m2505o(95793);
            return 0;
        } else if (this.bpK == 0) {
            AppMethodBeat.m2505o(95793);
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
                        this.bpJ.mo59501eK(read);
                    }
                    AppMethodBeat.m2505o(95793);
                    return read;
                } else if (this.bpK != -1) {
                    C0866a c0866a = new C0866a(new EOFException());
                    AppMethodBeat.m2505o(95793);
                    throw c0866a;
                } else {
                    AppMethodBeat.m2505o(95793);
                    return -1;
                }
            } catch (IOException e) {
                C0866a c0866a2 = new C0866a(e);
                AppMethodBeat.m2505o(95793);
                throw c0866a2;
            }
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() {
        C0866a c0866a;
        AppMethodBeat.m2504i(95794);
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
                        this.bpJ.mo59503tr();
                        AppMethodBeat.m2505o(95794);
                        return;
                    }
                }
                AppMethodBeat.m2505o(95794);
            } catch (IOException e) {
                c0866a = new C0866a(e);
                AppMethodBeat.m2505o(95794);
                throw c0866a;
            } catch (Throwable th) {
                this.bpM = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.bpJ != null) {
                        this.bpJ.mo59503tr();
                    }
                }
                AppMethodBeat.m2505o(95794);
            }
        } catch (IOException e2) {
            c0866a = new C0866a(e2);
            AppMethodBeat.m2505o(95794);
            throw c0866a;
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
                        this.bpJ.mo59503tr();
                    }
                }
                AppMethodBeat.m2505o(95794);
            } catch (IOException e22) {
                c0866a = new C0866a(e22);
                AppMethodBeat.m2505o(95794);
                throw c0866a;
            } catch (Throwable th3) {
                this.bpM = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.bpJ != null) {
                        this.bpJ.mo59503tr();
                    }
                }
                AppMethodBeat.m2505o(95794);
            }
        }
    }
}
