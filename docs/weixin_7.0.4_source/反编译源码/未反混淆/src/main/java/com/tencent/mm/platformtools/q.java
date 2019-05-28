package com.tencent.mm.platformtools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.vfs.e;
import java.io.OutputStream;

public final class q {
    public static boolean a(String str, Context context, int i) {
        AppMethodBeat.i(79003);
        if (r.amo(str)) {
            if (!bo.isNullOrNil(str)) {
                String RL = a.RL("gif");
                e.tf(e.atb(RL));
                if (e.y(str, RL) >= 0) {
                    a.a(RL, context);
                    Toast.makeText(context, context.getString(i, new Object[]{a.dlz()}), 1).show();
                    AppMethodBeat.o(79003);
                    return true;
                }
            }
            AppMethodBeat.o(79003);
            return false;
        }
        boolean a = a(str, context, true, i);
        AppMethodBeat.o(79003);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A:{SYNTHETIC, Splitter:B:40:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A:{Splitter:B:10:0x0036, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A:{Splitter:B:10:0x0036, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A:{Splitter:B:10:0x0036, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:27:0x0073, code skipped:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:29:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.ExportImgUtil", r5, "rotate img failed.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:38:0x008f, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:51:0x00a7, code skipped:
            r1 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(String str, Context context, boolean z, int i) {
        String RL;
        OutputStream outputStream;
        OutputStream outputStream2;
        AppMethodBeat.i(79004);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(79004);
            return false;
        }
        RL = a.RL("jpg");
        e.tf(e.atb(RL));
        if (e.y(str, RL) < 0) {
            AppMethodBeat.o(79004);
            return false;
        }
        if (MMNativeJpeg.isProgressive(RL)) {
            outputStream = null;
            try {
                int bJ = ExifHelper.bJ(RL);
                Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(RL);
                if (decodeAsBitmap != null) {
                    decodeAsBitmap = d.b(decodeAsBitmap, (float) bJ);
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    outputStream = e.L(RL, false);
                    decodeAsBitmap.compress(compressFormat, 80, outputStream);
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                outputStream2 = outputStream;
            } catch (Throwable th) {
            }
        }
        a.a(RL, context);
        if (z) {
            Toast.makeText(context, context.getString(i, new Object[]{a.dlz()}), 1).show();
        }
        AppMethodBeat.o(79004);
        return true;
        try {
            e.deleteFile(RL);
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception e3) {
                }
            }
            AppMethodBeat.o(79004);
            return false;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            outputStream = outputStream2;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e4) {
                }
            }
            AppMethodBeat.o(79004);
            throw th3;
        }
        AppMethodBeat.o(79004);
        return false;
    }

    @Deprecated
    public static void a(String str, Context context) {
        AppMethodBeat.i(79005);
        a.a(str, context);
        AppMethodBeat.o(79005);
    }
}
