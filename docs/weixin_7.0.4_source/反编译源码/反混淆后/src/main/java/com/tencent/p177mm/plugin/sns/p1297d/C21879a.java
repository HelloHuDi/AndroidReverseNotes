package com.tencent.p177mm.plugin.sns.p1297d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C37899l;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.p215cf.C37632b;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.d.a */
public final class C21879a {
    /* renamed from: c */
    public static C45434n m33432c(String str, Options options) {
        AppMethodBeat.m2504i(35785);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = C37899l.m63997Xf().mo60650a(str, options);
            if (a != null) {
                a = C29036i.m46128s(str, a);
            }
            C4990ab.m7411d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a);
            C45434n w = C45434n.m83680w(a);
            AppMethodBeat.m2505o(35785);
            return w;
        } catch (OutOfMemoryError e) {
            C37632b.dvU();
            C4990ab.m7412e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            AppMethodBeat.m2505o(35785);
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m33431b(String str, Options options) {
        AppMethodBeat.m2504i(35786);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = C37899l.m63997Xf().mo60650a(str, options);
            if (a != null) {
                a = C29036i.m46128s(str, a);
            }
            C4990ab.m7411d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a);
            AppMethodBeat.m2505o(35786);
            return a;
        } catch (OutOfMemoryError e) {
            C37632b.dvU();
            C4990ab.m7412e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            AppMethodBeat.m2505o(35786);
            return null;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.SnsBitmapUtil", e2, "", new Object[0]);
            AppMethodBeat.m2505o(35786);
            return null;
        }
    }
}
