package com.tencent.p177mm.platformtools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.vfs.C5730e;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.platformtools.q */
public final class C45477q {
    /* renamed from: a */
    public static boolean m83806a(String str, Context context, int i) {
        AppMethodBeat.m2504i(79003);
        if (C5063r.amo(str)) {
            if (!C5046bo.isNullOrNil(str)) {
                String RL = C40612a.m70042RL("gif");
                C5730e.m8643tf(C5730e.atb(RL));
                if (C5730e.m8644y(str, RL) >= 0) {
                    C40612a.m70043a(RL, context);
                    Toast.makeText(context, context.getString(i, new Object[]{C40612a.dlz()}), 1).show();
                    AppMethodBeat.m2505o(79003);
                    return true;
                }
            }
            AppMethodBeat.m2505o(79003);
            return false;
        }
        boolean a = C45477q.m83807a(str, context, true, i);
        AppMethodBeat.m2505o(79003);
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.ExportImgUtil", r5, "rotate img failed.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:38:0x008f, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:51:0x00a7, code skipped:
            r1 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m83807a(String str, Context context, boolean z, int i) {
        String RL;
        OutputStream outputStream;
        OutputStream outputStream2;
        AppMethodBeat.m2504i(79004);
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(79004);
            return false;
        }
        RL = C40612a.m70042RL("jpg");
        C5730e.m8643tf(C5730e.atb(RL));
        if (C5730e.m8644y(str, RL) < 0) {
            AppMethodBeat.m2505o(79004);
            return false;
        }
        if (MMNativeJpeg.isProgressive(RL)) {
            outputStream = null;
            try {
                int bJ = ExifHelper.m7368bJ(RL);
                Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(RL);
                if (decodeAsBitmap != null) {
                    decodeAsBitmap = C5056d.m7648b(decodeAsBitmap, (float) bJ);
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    outputStream = C5730e.m8617L(RL, false);
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
        C40612a.m70043a(RL, context);
        if (z) {
            Toast.makeText(context, context.getString(i, new Object[]{C40612a.dlz()}), 1).show();
        }
        AppMethodBeat.m2505o(79004);
        return true;
        try {
            C5730e.deleteFile(RL);
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception e3) {
                }
            }
            AppMethodBeat.m2505o(79004);
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
            AppMethodBeat.m2505o(79004);
            throw th3;
        }
        AppMethodBeat.m2505o(79004);
        return false;
    }

    @Deprecated
    /* renamed from: a */
    public static void m83805a(String str, Context context) {
        AppMethodBeat.m2504i(79005);
        C40612a.m70043a(str, context);
        AppMethodBeat.m2505o(79005);
    }
}
