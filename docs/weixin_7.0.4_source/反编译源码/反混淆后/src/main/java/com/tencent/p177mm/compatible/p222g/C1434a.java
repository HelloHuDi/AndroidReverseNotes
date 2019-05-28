package com.tencent.p177mm.compatible.p222g;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.compatible.g.a */
public final class C1434a extends BitmapFactory {
    private static C1433a euC = null;

    /* renamed from: com.tencent.mm.compatible.g.a$a */
    public interface C1433a {
        Bitmap decodeResource(Resources resources, int i, Options options);
    }

    /* renamed from: a */
    public static void m3059a(C1433a c1433a) {
        euC = c1433a;
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        AppMethodBeat.m2504i(93049);
        Bitmap decodeResource = C1434a.decodeResource(resources, i, null);
        AppMethodBeat.m2505o(93049);
        return decodeResource;
    }

    public static Bitmap decodeResource(Resources resources, int i, Options options) {
        Bitmap decodeResource;
        AppMethodBeat.m2504i(93050);
        if (euC != null) {
            decodeResource = euC.decodeResource(resources, i, options);
            if (decodeResource != null) {
                AppMethodBeat.m2505o(93050);
                return decodeResource;
            }
        }
        decodeResource = C1434a.m3058a(resources, i, options);
        AppMethodBeat.m2505o(93050);
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
    /* renamed from: a */
    private static Bitmap m3058a(Resources resources, int i, Options options) {
        Bitmap decodeStream;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(93051);
        C5056d.dnX();
        InputStream openRawResource;
        try {
            TypedValue typedValue = new TypedValue();
            openRawResource = resources.openRawResource(i, typedValue);
            try {
                bitmap = C1434a.decodeResourceStream(resources, typedValue, openRawResource, null, options);
                if (bitmap == null) {
                    decodeStream = C1434a.decodeStream(openRawResource);
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
            AppMethodBeat.m2505o(93051);
            return decodeStream;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            InputStream inputStream = bitmap;
            if (inputStream != null) {
            }
            AppMethodBeat.m2505o(93051);
            throw th3;
        }
        if (decodeStream == null || options == null) {
            AppMethodBeat.m2505o(93051);
            return decodeStream;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Problem decoding into existing bitmap");
        AppMethodBeat.m2505o(93051);
        throw illegalArgumentException;
    }
}
