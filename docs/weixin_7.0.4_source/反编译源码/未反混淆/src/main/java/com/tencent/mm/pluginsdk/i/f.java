package com.tencent.mm.pluginsdk.i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.OutputStream;

public final class f {
    public static String mK(int i) {
        AppMethodBeat.i(27480);
        String format = String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
        AppMethodBeat.o(27480);
        return format;
    }

    private static boolean isNullOrNil(String str) {
        AppMethodBeat.i(27481);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(27481);
            return true;
        }
        AppMethodBeat.o(27481);
        return false;
    }

    public static void a(Bitmap bitmap, CompressFormat compressFormat, String str, boolean z) {
        AppMethodBeat.i(27482);
        IOException iOException;
        if (isNullOrNil(str)) {
            iOException = new IOException("saveBitmapToImage pathName null or nil");
            AppMethodBeat.o(27482);
            throw iOException;
        }
        OutputStream outputStream = null;
        try {
            outputStream = e.L(str, false);
            bitmap.compress(compressFormat, 60, outputStream);
            outputStream.flush();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException iOException2) {
                    ab.printErrStackTrace("MicroMsg.VideoUtil", iOException2, "", new Object[0]);
                }
            }
            if (z) {
                ab.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
                AppMethodBeat.o(27482);
                return;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VideoUtil", e, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException iOException22) {
                    ab.printErrStackTrace("MicroMsg.VideoUtil", iOException22, "", new Object[0]);
                }
            }
            if (z) {
                ab.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
                AppMethodBeat.o(27482);
                return;
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.VideoUtil", e2, "", new Object[0]);
                }
            }
            if (z) {
                ab.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.o(27482);
        }
        AppMethodBeat.o(27482);
    }
}
