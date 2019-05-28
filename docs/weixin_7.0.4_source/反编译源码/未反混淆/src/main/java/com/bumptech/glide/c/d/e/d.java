package com.bumptech.glide.c.d.e;

import android.util.Log;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.c;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.l;
import com.bumptech.glide.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class d implements l<c> {
    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, j jVar) {
        AppMethodBeat.i(92333);
        boolean a = a((u) obj, file);
        AppMethodBeat.o(92333);
        return a;
    }

    public final c b(j jVar) {
        return c.SOURCE;
    }

    private static boolean a(u<c> uVar, File file) {
        boolean z;
        AppMethodBeat.i(92332);
        try {
            a.b(((c) uVar.get()).getBuffer(), file);
            z = true;
        } catch (IOException e) {
            Log.isLoggable("GifEncoder", 5);
            z = false;
        }
        AppMethodBeat.o(92332);
        return z;
    }
}
