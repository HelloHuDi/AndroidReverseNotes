package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.i;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.l;
import com.bumptech.glide.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class c implements l<Bitmap> {
    public static final i<Integer> aET = i.c("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));
    public static final i<CompressFormat> aEU = i.Z("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private final b awk;

    static {
        AppMethodBeat.i(92186);
        AppMethodBeat.o(92186);
    }

    public c(b bVar) {
        this.awk = bVar;
    }

    @Deprecated
    public c() {
        this.awk = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A:{Catch:{ all -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8 A:{SYNTHETIC, Splitter:B:35:0x00c8} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A:{Catch:{ all -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d4 A:{SYNTHETIC, Splitter:B:43:0x00d4} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(u<Bitmap> uVar, File file, j jVar) {
        CompressFormat compressFormat;
        boolean z;
        Throwable th;
        AppMethodBeat.i(92184);
        Bitmap bitmap = (Bitmap) uVar.get();
        CompressFormat compressFormat2 = (CompressFormat) jVar.a(aEU);
        if (compressFormat2 != null) {
            compressFormat = compressFormat2;
        } else if (bitmap.hasAlpha()) {
            compressFormat = CompressFormat.PNG;
        } else {
            compressFormat = CompressFormat.JPEG;
        }
        Integer.valueOf(bitmap.getWidth());
        Integer.valueOf(bitmap.getHeight());
        try {
            long ok = e.ok();
            int intValue = ((Integer) jVar.a(aET)).intValue();
            OutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    if (this.awk != null) {
                        fileOutputStream = new com.bumptech.glide.c.a.c(fileOutputStream, this.awk);
                    }
                    bitmap.compress(compressFormat, intValue, fileOutputStream);
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                        z = true;
                    } catch (IOException e) {
                        z = true;
                    }
                } catch (IOException e2) {
                    try {
                        Log.isLoggable("BitmapEncoder", 3);
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                                z = false;
                            } catch (IOException e3) {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        if (Log.isLoggable("BitmapEncoder", 2)) {
                        }
                        AppMethodBeat.o(92184);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.o(92184);
                        throw th;
                    }
                }
            } catch (IOException e4) {
                fileOutputStream = null;
                Log.isLoggable("BitmapEncoder", 3);
                if (fileOutputStream == null) {
                }
                if (Log.isLoggable("BitmapEncoder", 2)) {
                }
                AppMethodBeat.o(92184);
                return z;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.o(92184);
                throw th;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                new StringBuilder("Compressed with type: ").append(compressFormat).append(" of size ").append(com.bumptech.glide.h.j.k(bitmap)).append(" in ").append(e.q(ok)).append(", options format: ").append(jVar.a(aEU)).append(", hasAlpha: ").append(bitmap.hasAlpha());
            }
            AppMethodBeat.o(92184);
            return z;
        } catch (Throwable th4) {
            AppMethodBeat.o(92184);
        }
    }

    public final com.bumptech.glide.c.c b(j jVar) {
        return com.bumptech.glide.c.c.TRANSFORMED;
    }
}
