package com.bumptech.glide.p086c.p090c;

import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p1157g.C17555b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.c.c.b */
public final class C17530b<Data> implements C37175n<byte[], Data> {
    private final C8531b<Data> aDO;

    /* renamed from: com.bumptech.glide.c.c.b$b */
    public interface C8531b<Data> {
        /* renamed from: h */
        Data mo18633h(byte[] bArr);

        /* renamed from: mg */
        Class<Data> mo18634mg();
    }

    /* renamed from: com.bumptech.glide.c.c.b$a */
    public static class C17531a implements C31953o<byte[], ByteBuffer> {

        /* renamed from: com.bumptech.glide.c.c.b$a$1 */
        class C175321 implements C8531b<ByteBuffer> {
            C175321() {
            }

            /* renamed from: mg */
            public final Class<ByteBuffer> mo18634mg() {
                return ByteBuffer.class;
            }

            /* renamed from: h */
            public final /* synthetic */ Object mo18633h(byte[] bArr) {
                AppMethodBeat.m2504i(92036);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                AppMethodBeat.m2505o(92036);
                return wrap;
            }
        }

        /* renamed from: a */
        public final C37175n<byte[], ByteBuffer> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92037);
            C17530b c17530b = new C17530b(new C175321());
            AppMethodBeat.m2505o(92037);
            return c17530b;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.b$d */
    public static class C17533d implements C31953o<byte[], InputStream> {

        /* renamed from: com.bumptech.glide.c.c.b$d$1 */
        class C175341 implements C8531b<InputStream> {
            C175341() {
            }

            /* renamed from: mg */
            public final Class<InputStream> mo18634mg() {
                return InputStream.class;
            }

            /* renamed from: h */
            public final /* synthetic */ Object mo18633h(byte[] bArr) {
                AppMethodBeat.m2504i(92040);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                AppMethodBeat.m2505o(92040);
                return byteArrayInputStream;
            }
        }

        /* renamed from: a */
        public final C37175n<byte[], InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92041);
            C17530b c17530b = new C17530b(new C175341());
            AppMethodBeat.m2505o(92041);
            return c17530b;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.b$c */
    static class C17535c<Data> implements C0742d<Data> {
        private final C8531b<Data> aDO;
        private final byte[] aDQ;

        C17535c(byte[] bArr, C8531b<Data> c8531b) {
            this.aDQ = bArr;
            this.aDO = c8531b;
        }

        /* renamed from: a */
        public final void mo2184a(C37192g c37192g, C0743a<? super Data> c0743a) {
            AppMethodBeat.m2504i(92038);
            c0743a.mo2189S(this.aDO.mo18633h(this.aDQ));
            AppMethodBeat.m2505o(92038);
        }

        public final void cleanup() {
        }

        public final void cancel() {
        }

        /* renamed from: mg */
        public final Class<Data> mo2187mg() {
            AppMethodBeat.m2504i(92039);
            Class mg = this.aDO.mo18634mg();
            AppMethodBeat.m2505o(92039);
            return mg;
        }

        /* renamed from: mh */
        public final C25405a mo2188mh() {
            return C25405a.LOCAL;
        }
    }

    /* renamed from: X */
    public final /* bridge */ /* synthetic */ boolean mo2224X(Object obj) {
        return true;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92042);
        byte[] bArr = (byte[]) obj;
        C37176a c37176a = new C37176a(new C17555b(bArr), new C17535c(bArr, this.aDO));
        AppMethodBeat.m2505o(92042);
        return c37176a;
    }

    public C17530b(C8531b<Data> c8531b) {
        this.aDO = c8531b;
    }
}
