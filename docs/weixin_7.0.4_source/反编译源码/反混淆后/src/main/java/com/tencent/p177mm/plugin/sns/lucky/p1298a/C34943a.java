package com.tencent.p177mm.plugin.sns.lucky.p1298a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.sns.lucky.a.a */
public final class C34943a {
    /* renamed from: fV */
    public static C45434n m57363fV(String str, String str2) {
        AppMethodBeat.m2504i(35877);
        int argb = Color.argb(51, 255, 255, 255);
        C45434n Xi = C29036i.m46086Xi(str);
        if (Xi == null) {
            C4990ab.m7412e("MicroMsg.BlurHelper", "returnBitmap error1 ");
            AppMethodBeat.m2505o(35877);
            return null;
        }
        C45434n a = C34943a.m57362a(Xi.mo73229Xh(), str2, argb, 55);
        AppMethodBeat.m2505o(35877);
        return a;
    }

    /* renamed from: a */
    public static C45434n m57362a(Bitmap bitmap, String str, int i, int i2) {
        AppMethodBeat.m2504i(35878);
        C45434n w = C45434n.m83680w(C5056d.m7660e(bitmap, i2));
        if (w == null) {
            C4990ab.m7412e("MicroMsg.BlurHelper", "returnBitmap error2 ");
        }
        if (w != null) {
            new Canvas(w.mo73229Xh()).drawColor(i);
        }
        try {
            C5056d.m7625a(w.mo73229Xh(), 70, CompressFormat.JPEG, str, false);
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.BlurHelper", "error for exception " + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.BlurHelper", e, "", new Object[0]);
        }
        C4990ab.m7416i("MicroMsg.BlurHelper", "blur done bitmap  ".concat(String.valueOf(w)));
        AppMethodBeat.m2505o(35878);
        return w;
    }
}
