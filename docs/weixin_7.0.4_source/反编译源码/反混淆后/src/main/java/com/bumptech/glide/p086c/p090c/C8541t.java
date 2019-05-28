package com.bumptech.glide.p086c.p090c;

import android.util.Log;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C37189d;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.bumptech.glide.c.c.t */
public final class C8541t implements C37189d<InputStream> {
    private final C8515b azx;

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo2227a(Object obj, File file, C31967j c31967j) {
        AppMethodBeat.m2504i(92133);
        boolean a = m15169a((InputStream) obj, file);
        AppMethodBeat.m2505o(92133);
        return a;
    }

    public C8541t(C8515b c8515b) {
        this.azx = c8515b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A:{SYNTHETIC, Splitter:B:26:0x004e} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f A:{SYNTHETIC, Splitter:B:12:0x002f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m15169a(InputStream inputStream, File file) {
        boolean z;
        Throwable th;
        AppMethodBeat.m2504i(92132);
        byte[] bArr = (byte[]) this.azx.mo18608a(65536, byte[].class);
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
                        AppMethodBeat.m2505o(92132);
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
                        AppMethodBeat.m2505o(92132);
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
            AppMethodBeat.m2505o(92132);
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            this.azx.put(bArr);
            AppMethodBeat.m2505o(92132);
            throw th;
        }
        AppMethodBeat.m2505o(92132);
        return z;
    }
}
