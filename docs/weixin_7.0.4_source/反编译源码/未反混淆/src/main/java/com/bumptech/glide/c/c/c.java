package com.bumptech.glide.c.c;

import android.util.Log;
import com.bumptech.glide.c.d;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class c implements d<ByteBuffer> {
    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, j jVar) {
        AppMethodBeat.i(92044);
        boolean a = a((ByteBuffer) obj, file);
        AppMethodBeat.o(92044);
        return a;
    }

    private static boolean a(ByteBuffer byteBuffer, File file) {
        AppMethodBeat.i(92043);
        boolean z = false;
        try {
            a.b(byteBuffer, file);
            z = true;
        } catch (IOException e) {
            Log.isLoggable("ByteBufferEncoder", 3);
        }
        AppMethodBeat.o(92043);
        return z;
    }
}
