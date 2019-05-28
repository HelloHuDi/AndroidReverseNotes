package com.bumptech.glide.c.d.e;

import android.util.Log;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.f.a;
import com.bumptech.glide.c.g;
import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class j implements k<InputStream, c> {
    private final k<ByteBuffer, c> aGo;
    private final List<f> azH;
    private final b azx;

    public final /* synthetic */ u a(Object obj, int i, int i2, com.bumptech.glide.c.j jVar) {
        AppMethodBeat.i(92358);
        byte[] d = d((InputStream) obj);
        if (d == null) {
            AppMethodBeat.o(92358);
            return null;
        }
        u a = this.aGo.a(ByteBuffer.wrap(d), i, i2, jVar);
        AppMethodBeat.o(92358);
        return a;
    }

    public final /* synthetic */ boolean a(Object obj, com.bumptech.glide.c.j jVar) {
        AppMethodBeat.i(92359);
        InputStream inputStream = (InputStream) obj;
        if (((Boolean) jVar.a(i.aGn)).booleanValue() || g.a(this.azH, inputStream, this.azx) != a.GIF) {
            AppMethodBeat.o(92359);
            return false;
        }
        AppMethodBeat.o(92359);
        return true;
    }

    public j(List<f> list, k<ByteBuffer, c> kVar, b bVar) {
        this.azH = list;
        this.aGo = kVar;
        this.azx = bVar;
    }

    private static byte[] d(InputStream inputStream) {
        AppMethodBeat.i(92357);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(92357);
                    return toByteArray;
                }
            }
        } catch (IOException e) {
            Log.isLoggable("StreamGifDecoder", 5);
            AppMethodBeat.o(92357);
            return null;
        }
    }
}
