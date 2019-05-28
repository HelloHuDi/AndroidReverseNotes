package com.tencent.mm.compatible.g;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.io.InputStream;

public final class a extends BitmapFactory {
    private static a euC = null;

    public interface a {
        Bitmap decodeResource(Resources resources, int i, Options options);
    }

    public static void a(a aVar) {
        euC = aVar;
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        AppMethodBeat.i(93049);
        Bitmap decodeResource = decodeResource(resources, i, null);
        AppMethodBeat.o(93049);
        return decodeResource;
    }

    public static Bitmap decodeResource(Resources resources, int i, Options options) {
        Bitmap decodeResource;
        AppMethodBeat.i(93050);
        if (euC != null) {
            decodeResource = euC.decodeResource(resources, i, options);
            if (decodeResource != null) {
                AppMethodBeat.o(93050);
                return decodeResource;
            }
        }
        decodeResource = a(resources, i, options);
        AppMethodBeat.o(93050);
        return decodeResource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A:{SYNTHETIC, Splitter:B:25:0x0043} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054 A:{Splitter:B:4:0x0014, ExcHandler: all (r1_4 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:34:0x0054, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:35:0x0055, code skipped:
            r2 = r1;
            r3 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Bitmap a(Resources resources, int i, Options options) {
        Bitmap decodeStream;
        Bitmap bitmap = null;
        AppMethodBeat.i(93051);
        d.dnX();
        InputStream openRawResource;
        try {
            TypedValue typedValue = new TypedValue();
            openRawResource = resources.openRawResource(i, typedValue);
            try {
                bitmap = decodeResourceStream(resources, typedValue, openRawResource, null, options);
                if (bitmap == null) {
                    decodeStream = decodeStream(openRawResource);
                } else {
                    decodeStream = bitmap;
                }
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Exception e2) {
                decodeStream = bitmap;
            } catch (Throwable th) {
            }
        } catch (Exception e3) {
            openRawResource = bitmap;
            decodeStream = bitmap;
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e4) {
                }
            }
            if (decodeStream == null) {
            }
            AppMethodBeat.o(93051);
            return decodeStream;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            InputStream inputStream = bitmap;
            if (inputStream != null) {
            }
            AppMethodBeat.o(93051);
            throw th3;
        }
        if (decodeStream == null || options == null) {
            AppMethodBeat.o(93051);
            return decodeStream;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Problem decoding into existing bitmap");
        AppMethodBeat.o(93051);
        throw illegalArgumentException;
    }
}
