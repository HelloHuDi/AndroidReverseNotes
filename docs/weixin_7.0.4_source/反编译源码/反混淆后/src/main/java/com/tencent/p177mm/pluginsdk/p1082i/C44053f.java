package com.tencent.p177mm.pluginsdk.p1082i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.pluginsdk.i.f */
public final class C44053f {
    /* renamed from: mK */
    public static String m79183mK(int i) {
        AppMethodBeat.m2504i(27480);
        String format = String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
        AppMethodBeat.m2505o(27480);
        return format;
    }

    private static boolean isNullOrNil(String str) {
        AppMethodBeat.m2504i(27481);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(27481);
            return true;
        }
        AppMethodBeat.m2505o(27481);
        return false;
    }

    /* renamed from: a */
    public static void m79182a(Bitmap bitmap, CompressFormat compressFormat, String str, boolean z) {
        AppMethodBeat.m2504i(27482);
        IOException iOException;
        if (C44053f.isNullOrNil(str)) {
            iOException = new IOException("saveBitmapToImage pathName null or nil");
            AppMethodBeat.m2505o(27482);
            throw iOException;
        }
        OutputStream outputStream = null;
        try {
            outputStream = C5730e.m8617L(str, false);
            bitmap.compress(compressFormat, 60, outputStream);
            outputStream.flush();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException iOException2) {
                    C4990ab.printErrStackTrace("MicroMsg.VideoUtil", iOException2, "", new Object[0]);
                }
            }
            if (z) {
                C4990ab.m7417i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
                AppMethodBeat.m2505o(27482);
                return;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VideoUtil", e, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException iOException22) {
                    C4990ab.printErrStackTrace("MicroMsg.VideoUtil", iOException22, "", new Object[0]);
                }
            }
            if (z) {
                C4990ab.m7417i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
                AppMethodBeat.m2505o(27482);
                return;
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.VideoUtil", e2, "", new Object[0]);
                }
            }
            if (z) {
                C4990ab.m7417i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.m2505o(27482);
        }
        AppMethodBeat.m2505o(27482);
    }
}
