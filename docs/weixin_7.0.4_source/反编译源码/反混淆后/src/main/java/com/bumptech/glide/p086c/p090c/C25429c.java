package com.bumptech.glide.p086c.p090c;

import android.util.Log;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C37189d;
import com.bumptech.glide.p095h.C31973a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.c.c.c */
public final class C25429c implements C37189d<ByteBuffer> {
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo2227a(Object obj, File file, C31967j c31967j) {
        AppMethodBeat.m2504i(92044);
        boolean a = C25429c.m40187a((ByteBuffer) obj, file);
        AppMethodBeat.m2505o(92044);
        return a;
    }

    /* renamed from: a */
    private static boolean m40187a(ByteBuffer byteBuffer, File file) {
        AppMethodBeat.m2504i(92043);
        boolean z = false;
        try {
            C31973a.m51949b(byteBuffer, file);
            z = true;
        } catch (IOException e) {
            Log.isLoggable("ByteBufferEncoder", 3);
        }
        AppMethodBeat.m2505o(92043);
        return z;
    }
}
