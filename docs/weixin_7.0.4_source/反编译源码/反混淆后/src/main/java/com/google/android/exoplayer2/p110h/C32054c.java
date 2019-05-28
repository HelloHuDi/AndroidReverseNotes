package com.google.android.exoplayer2.p110h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.exoplayer2.h.c */
public final class C32054c implements C0867f {
    private InputStream azC;
    private final AssetManager azj;
    private final C41615u<? super C32054c> bpJ;
    private long bpK;
    private boolean opened;
    private Uri uri;

    /* renamed from: com.google.android.exoplayer2.h.c$a */
    public static final class C32055a extends IOException {
        public C32055a(IOException iOException) {
            super(iOException);
        }
    }

    public C32054c(Context context, C41615u<? super C32054c> c41615u) {
        AppMethodBeat.m2504i(95787);
        this.azj = context.getAssets();
        this.bpJ = c41615u;
        AppMethodBeat.m2505o(95787);
    }

    /* renamed from: a */
    public final long mo2583a(C17665i c17665i) {
        AppMethodBeat.m2504i(95788);
        try {
            this.uri = c17665i.uri;
            String path = this.uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.azC = this.azj.open(path, 1);
            if (this.azC.skip(c17665i.position) < c17665i.position) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.m2505o(95788);
                throw eOFException;
            }
            if (c17665i.bgY != -1) {
                this.bpK = c17665i.bgY;
            } else {
                this.bpK = (long) this.azC.available();
                if (this.bpK == 2147483647L) {
                    this.bpK = -1;
                }
            }
            this.opened = true;
            if (this.bpJ != null) {
                this.bpJ.mo59502tq();
            }
            long j = this.bpK;
            AppMethodBeat.m2505o(95788);
            return j;
        } catch (IOException e) {
            C32055a c32055a = new C32055a(e);
            AppMethodBeat.m2505o(95788);
            throw c32055a;
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95789);
        if (i2 == 0) {
            AppMethodBeat.m2505o(95789);
            return 0;
        } else if (this.bpK == 0) {
            AppMethodBeat.m2505o(95789);
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
                    AppMethodBeat.m2505o(95789);
                    return read;
                } else if (this.bpK != -1) {
                    C32055a c32055a = new C32055a(new EOFException());
                    AppMethodBeat.m2505o(95789);
                    throw c32055a;
                } else {
                    AppMethodBeat.m2505o(95789);
                    return -1;
                }
            } catch (IOException e) {
                C32055a c32055a2 = new C32055a(e);
                AppMethodBeat.m2505o(95789);
                throw c32055a2;
            }
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() {
        AppMethodBeat.m2504i(95790);
        this.uri = null;
        try {
            if (this.azC != null) {
                this.azC.close();
            }
            this.azC = null;
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.mo59503tr();
                    AppMethodBeat.m2505o(95790);
                    return;
                }
            }
            AppMethodBeat.m2505o(95790);
        } catch (IOException e) {
            C32055a c32055a = new C32055a(e);
            AppMethodBeat.m2505o(95790);
            throw c32055a;
        } catch (Throwable th) {
            this.azC = null;
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.mo59503tr();
                }
            }
            AppMethodBeat.m2505o(95790);
        }
    }
}
