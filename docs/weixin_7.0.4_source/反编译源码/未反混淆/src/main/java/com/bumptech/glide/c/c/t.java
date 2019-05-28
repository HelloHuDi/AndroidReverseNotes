package com.bumptech.glide.c.c;

import android.util.Log;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.d;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class t implements d<InputStream> {
    private final b azx;

    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, j jVar) {
        AppMethodBeat.i(92133);
        boolean a = a((InputStream) obj, file);
        AppMethodBeat.o(92133);
        return a;
    }

    public t(b bVar) {
        this.azx = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A:{SYNTHETIC, Splitter:B:26:0x004e} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f A:{SYNTHETIC, Splitter:B:12:0x002f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(InputStream inputStream, File file) {
        boolean z;
        Throwable th;
        AppMethodBeat.i(92132);
        byte[] bArr = (byte[]) this.azx.a(65536, byte[].class);
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    try {
                        Log.isLoggable("StreamEncoder", 3);
                        if (fileOutputStream != null) {
                        }
                        this.azx.put(bArr);
                        z = false;
                        AppMethodBeat.o(92132);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        this.azx.put(bArr);
                        AppMethodBeat.o(92132);
                        throw th;
                    }
                }
            }
            fileOutputStream.close();
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
            }
            this.azx.put(bArr);
            z = true;
        } catch (IOException e4) {
            fileOutputStream = null;
            Log.isLoggable("StreamEncoder", 3);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                }
            }
            this.azx.put(bArr);
            z = false;
            AppMethodBeat.o(92132);
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            this.azx.put(bArr);
            AppMethodBeat.o(92132);
            throw th;
        }
        AppMethodBeat.o(92132);
        return z;
    }
}
