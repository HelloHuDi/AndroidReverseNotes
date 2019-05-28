package com.bumptech.glide.p086c.p092d.p093a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.p086c.C17546i;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31969l;
import com.bumptech.glide.p086c.C44994c;
import com.bumptech.glide.p086c.p087a.C31924c;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p095h.C31975e;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.bumptech.glide.c.d.a.c */
public final class C0770c implements C31969l<Bitmap> {
    public static final C17546i<Integer> aET = C17546i.m27397c("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));
    public static final C17546i<CompressFormat> aEU = C17546i.m27395Z("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private final C8515b awk;

    static {
        AppMethodBeat.m2504i(92186);
        AppMethodBeat.m2505o(92186);
    }

    public C0770c(C8515b c8515b) {
        this.awk = c8515b;
    }

    @Deprecated
    public C0770c() {
        this.awk = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A:{Catch:{ all -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8 A:{SYNTHETIC, Splitter:B:35:0x00c8} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A:{Catch:{ all -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d4 A:{SYNTHETIC, Splitter:B:43:0x00d4} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m1757a(C17526u<Bitmap> c17526u, File file, C31967j c31967j) {
        CompressFormat compressFormat;
        boolean z;
        Throwable th;
        AppMethodBeat.m2504i(92184);
        Bitmap bitmap = (Bitmap) c17526u.get();
        CompressFormat compressFormat2 = (CompressFormat) c31967j.mo52069a(aEU);
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
            long ok = C31975e.m51954ok();
            int intValue = ((Integer) c31967j.mo52069a(aET)).intValue();
            OutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    if (this.awk != null) {
                        fileOutputStream = new C31924c(fileOutputStream, this.awk);
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
                        AppMethodBeat.m2505o(92184);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(92184);
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
                AppMethodBeat.m2505o(92184);
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
                AppMethodBeat.m2505o(92184);
                throw th;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                new StringBuilder("Compressed with type: ").append(compressFormat).append(" of size ").append(C45002j.m82425k(bitmap)).append(" in ").append(C31975e.m51955q(ok)).append(", options format: ").append(c31967j.mo52069a(aEU)).append(", hasAlpha: ").append(bitmap.hasAlpha());
            }
            AppMethodBeat.m2505o(92184);
            return z;
        } catch (Throwable th4) {
            AppMethodBeat.m2505o(92184);
        }
    }

    /* renamed from: b */
    public final C44994c mo2228b(C31967j c31967j) {
        return C44994c.TRANSFORMED;
    }
}
