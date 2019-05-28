package com.bumptech.glide.c.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.b.c;
import com.bumptech.glide.b.d;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public final class a implements k<ByteBuffer, c> {
    private static final a aFP = new a();
    private static final b aFQ = new b();
    private final b aFR;
    private final a aFS;
    private final b aFT;
    private final List<f> azH;
    private final Context context;

    static class b {
        private final Queue<d> aDb = j.dn(0);

        b() {
            AppMethodBeat.i(92298);
            AppMethodBeat.o(92298);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized d c(ByteBuffer byteBuffer) {
            d dVar;
            AppMethodBeat.i(92299);
            dVar = (d) this.aDb.poll();
            if (dVar == null) {
                dVar = new d();
            }
            dVar.aym = null;
            Arrays.fill(dVar.ayl, (byte) 0);
            dVar.ayn = new c();
            dVar.blockSize = 0;
            dVar.aym = byteBuffer.asReadOnlyBuffer();
            dVar.aym.position(0);
            dVar.aym.order(ByteOrder.LITTLE_ENDIAN);
            AppMethodBeat.o(92299);
            return dVar;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void a(d dVar) {
            AppMethodBeat.i(92300);
            dVar.aym = null;
            dVar.ayn = null;
            this.aDb.offer(dVar);
            AppMethodBeat.o(92300);
        }
    }

    static class a {
        a() {
        }
    }

    public final /* synthetic */ boolean a(Object obj, com.bumptech.glide.c.j jVar) {
        AppMethodBeat.i(92305);
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (!((Boolean) jVar.a(i.aGn)).booleanValue()) {
            com.bumptech.glide.c.f.a b;
            List list = this.azH;
            if (byteBuffer != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    b = ((f) list.get(i)).b(byteBuffer);
                    if (b != com.bumptech.glide.c.f.a.UNKNOWN) {
                        break;
                    }
                }
            }
            b = com.bumptech.glide.c.f.a.UNKNOWN;
            if (b == com.bumptech.glide.c.f.a.GIF) {
                AppMethodBeat.o(92305);
                return true;
            }
        }
        AppMethodBeat.o(92305);
        return false;
    }

    static {
        AppMethodBeat.i(92306);
        AppMethodBeat.o(92306);
    }

    public a(Context context, List<f> list, e eVar, com.bumptech.glide.c.b.a.b bVar) {
        this(context, list, eVar, bVar, aFQ, aFP);
    }

    private a(Context context, List<f> list, e eVar, com.bumptech.glide.c.b.a.b bVar, b bVar2, a aVar) {
        AppMethodBeat.i(92301);
        this.context = context.getApplicationContext();
        this.azH = list;
        this.aFS = aVar;
        this.aFT = new b(eVar, bVar);
        this.aFR = bVar2;
        AppMethodBeat.o(92301);
    }

    private e a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.c.j jVar) {
        AppMethodBeat.i(92302);
        d c = this.aFR.c(byteBuffer);
        try {
            e a = a(byteBuffer, i, i2, c, jVar);
            return a;
        } finally {
            this.aFR.a(c);
            AppMethodBeat.o(92302);
        }
    }

    private e a(ByteBuffer byteBuffer, int i, int i2, d dVar, com.bumptech.glide.c.j jVar) {
        AppMethodBeat.i(92303);
        long ok = com.bumptech.glide.h.e.ok();
        try {
            if (dVar.aym == null) {
                IllegalStateException illegalStateException = new IllegalStateException("You must call setData() before parseHeader()");
                AppMethodBeat.o(92303);
                throw illegalStateException;
            }
            if (!dVar.md()) {
                dVar.ma();
                if (!dVar.md()) {
                    dVar.lY();
                    if (dVar.ayn.frameCount < 0) {
                        dVar.ayn.status = 1;
                    }
                }
            }
            c cVar = dVar.ayn;
            if (cVar.frameCount <= 0 || cVar.status != 0) {
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.h.e.q(ok));
                }
                AppMethodBeat.o(92303);
                return null;
            }
            Config config = jVar.a(i.aFl) == com.bumptech.glide.c.b.PREFER_RGB_565 ? Config.RGB_565 : Config.ARGB_8888;
            int min = Math.min(cVar.height / i2, cVar.width / i);
            min = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
            if (Log.isLoggable("BufferGifDecoder", 2) && min > 1) {
                new StringBuilder("Downsampling GIF, sampleSize: ").append(min).append(", target dimens: [").append(i).append(VideoMaterialUtil.CRAZYFACE_X).append(i2).append("], actual dimens: [").append(cVar.width).append(VideoMaterialUtil.CRAZYFACE_X).append(cVar.height).append("]");
            }
            com.bumptech.glide.b.e eVar = new com.bumptech.glide.b.e(this.aFT, cVar, byteBuffer, min);
            eVar.a(config);
            eVar.advance();
            Bitmap lX = eVar.lX();
            if (lX == null) {
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.h.e.q(ok));
                }
                AppMethodBeat.o(92303);
                return null;
            }
            e eVar2 = new e(new c(this.context, eVar, com.bumptech.glide.c.d.b.nm(), i, i2, lX));
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.h.e.q(ok));
            }
            AppMethodBeat.o(92303);
            return eVar2;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.h.e.q(ok));
            }
            AppMethodBeat.o(92303);
        }
    }
}
