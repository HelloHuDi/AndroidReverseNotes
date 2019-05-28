package com.bumptech.glide.p086c.p092d.p788e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.p085b.C0741c;
import com.bumptech.glide.p085b.C31921d;
import com.bumptech.glide.p085b.C31922e;
import com.bumptech.glide.p086c.C0776f;
import com.bumptech.glide.p086c.C0776f.C0777a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.C37171b;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p086c.p092d.C37182b;
import com.bumptech.glide.p095h.C31975e;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/* renamed from: com.bumptech.glide.c.d.e.a */
public final class C41561a implements C31968k<ByteBuffer, C37186c> {
    private static final C41560a aFP = new C41560a();
    private static final C37185b aFQ = new C37185b();
    private final C37185b aFR;
    private final C41560a aFS;
    private final C44998b aFT;
    private final List<C0776f> azH;
    private final Context context;

    /* renamed from: com.bumptech.glide.c.d.e.a$b */
    static class C37185b {
        private final Queue<C31921d> aDb = C45002j.m82420dn(0);

        C37185b() {
            AppMethodBeat.m2504i(92298);
            AppMethodBeat.m2505o(92298);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: c */
        public final synchronized C31921d mo59268c(ByteBuffer byteBuffer) {
            C31921d c31921d;
            AppMethodBeat.m2504i(92299);
            c31921d = (C31921d) this.aDb.poll();
            if (c31921d == null) {
                c31921d = new C31921d();
            }
            c31921d.aym = null;
            Arrays.fill(c31921d.ayl, (byte) 0);
            c31921d.ayn = new C0741c();
            c31921d.blockSize = 0;
            c31921d.aym = byteBuffer.asReadOnlyBuffer();
            c31921d.aym.position(0);
            c31921d.aym.order(ByteOrder.LITTLE_ENDIAN);
            AppMethodBeat.m2505o(92299);
            return c31921d;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: a */
        public final synchronized void mo59267a(C31921d c31921d) {
            AppMethodBeat.m2504i(92300);
            c31921d.aym = null;
            c31921d.ayn = null;
            this.aDb.offer(c31921d);
            AppMethodBeat.m2505o(92300);
        }
    }

    /* renamed from: com.bumptech.glide.c.d.e.a$a */
    static class C41560a {
        C41560a() {
        }
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo2235a(Object obj, C31967j c31967j) {
        AppMethodBeat.m2504i(92305);
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (!((Boolean) c31967j.mo52069a(C41563i.aGn)).booleanValue()) {
            C0777a b;
            List list = this.azH;
            if (byteBuffer != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    b = ((C0776f) list.get(i)).mo2240b(byteBuffer);
                    if (b != C0777a.UNKNOWN) {
                        break;
                    }
                }
            }
            b = C0777a.UNKNOWN;
            if (b == C0777a.GIF) {
                AppMethodBeat.m2505o(92305);
                return true;
            }
        }
        AppMethodBeat.m2505o(92305);
        return false;
    }

    static {
        AppMethodBeat.m2504i(92306);
        AppMethodBeat.m2505o(92306);
    }

    public C41561a(Context context, List<C0776f> list, C31925e c31925e, C8515b c8515b) {
        this(context, list, c31925e, c8515b, aFQ, aFP);
    }

    private C41561a(Context context, List<C0776f> list, C31925e c31925e, C8515b c8515b, C37185b c37185b, C41560a c41560a) {
        AppMethodBeat.m2504i(92301);
        this.context = context.getApplicationContext();
        this.azH = list;
        this.aFS = c41560a;
        this.aFT = new C44998b(c31925e, c8515b);
        this.aFR = c37185b;
        AppMethodBeat.m2505o(92301);
    }

    /* renamed from: a */
    private C17542e m72754a(ByteBuffer byteBuffer, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92302);
        C31921d c = this.aFR.mo59268c(byteBuffer);
        try {
            C17542e a = m72753a(byteBuffer, i, i2, c, c31967j);
            return a;
        } finally {
            this.aFR.mo59267a(c);
            AppMethodBeat.m2505o(92302);
        }
    }

    /* renamed from: a */
    private C17542e m72753a(ByteBuffer byteBuffer, int i, int i2, C31921d c31921d, C31967j c31967j) {
        AppMethodBeat.m2504i(92303);
        long ok = C31975e.m51954ok();
        try {
            if (c31921d.aym == null) {
                IllegalStateException illegalStateException = new IllegalStateException("You must call setData() before parseHeader()");
                AppMethodBeat.m2505o(92303);
                throw illegalStateException;
            }
            if (!c31921d.mo52039md()) {
                c31921d.mo52038ma();
                if (!c31921d.mo52039md()) {
                    c31921d.mo52037lY();
                    if (c31921d.ayn.frameCount < 0) {
                        c31921d.ayn.status = 1;
                    }
                }
            }
            C0741c c0741c = c31921d.ayn;
            if (c0741c.frameCount <= 0 || c0741c.status != 0) {
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    new StringBuilder("Decoded GIF from stream in ").append(C31975e.m51955q(ok));
                }
                AppMethodBeat.m2505o(92303);
                return null;
            }
            Config config = c31967j.mo52069a(C41563i.aFl) == C37171b.PREFER_RGB_565 ? Config.RGB_565 : Config.ARGB_8888;
            int min = Math.min(c0741c.height / i2, c0741c.width / i);
            min = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
            if (Log.isLoggable("BufferGifDecoder", 2) && min > 1) {
                new StringBuilder("Downsampling GIF, sampleSize: ").append(min).append(", target dimens: [").append(i).append(VideoMaterialUtil.CRAZYFACE_X).append(i2).append("], actual dimens: [").append(c0741c.width).append(VideoMaterialUtil.CRAZYFACE_X).append(c0741c.height).append("]");
            }
            C31922e c31922e = new C31922e(this.aFT, c0741c, byteBuffer, min);
            c31922e.mo42430a(config);
            c31922e.advance();
            Bitmap lX = c31922e.mo42439lX();
            if (lX == null) {
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    new StringBuilder("Decoded GIF from stream in ").append(C31975e.m51955q(ok));
                }
                AppMethodBeat.m2505o(92303);
                return null;
            }
            C17542e c17542e = new C17542e(new C37186c(this.context, c31922e, C37182b.m62320nm(), i, i2, lX));
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                new StringBuilder("Decoded GIF from stream in ").append(C31975e.m51955q(ok));
            }
            AppMethodBeat.m2505o(92303);
            return c17542e;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                new StringBuilder("Decoded GIF from stream in ").append(C31975e.m51955q(ok));
            }
            AppMethodBeat.m2505o(92303);
        }
    }
}
