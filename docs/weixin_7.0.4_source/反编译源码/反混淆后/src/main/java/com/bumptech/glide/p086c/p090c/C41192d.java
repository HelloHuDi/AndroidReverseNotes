package com.bumptech.glide.p086c.p090c;

import android.util.Log;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p095h.C31973a;
import com.bumptech.glide.p1157g.C17555b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.c.c.d */
public final class C41192d implements C37175n<File, ByteBuffer> {

    /* renamed from: com.bumptech.glide.c.c.d$b */
    public static class C36674b implements C31953o<File, ByteBuffer> {
        /* renamed from: a */
        public final C37175n<File, ByteBuffer> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92046);
            C41192d c41192d = new C41192d();
            AppMethodBeat.m2505o(92046);
            return c41192d;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.d$a */
    static final class C41193a implements C0742d<ByteBuffer> {
        private final File file;

        C41193a(File file) {
            this.file = file;
        }

        /* renamed from: a */
        public final void mo2184a(C37192g c37192g, C0743a<? super ByteBuffer> c0743a) {
            AppMethodBeat.m2504i(92045);
            try {
                c0743a.mo2189S(C31973a.m51952p(this.file));
                AppMethodBeat.m2505o(92045);
            } catch (IOException e) {
                Log.isLoggable("ByteBufferFileLoader", 3);
                c0743a.mo2190b(e);
                AppMethodBeat.m2505o(92045);
            }
        }

        public final void cleanup() {
        }

        public final void cancel() {
        }

        /* renamed from: mg */
        public final Class<ByteBuffer> mo2187mg() {
            return ByteBuffer.class;
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
        AppMethodBeat.m2504i(92047);
        File file = (File) obj;
        C37176a c37176a = new C37176a(new C17555b(file), new C41193a(file));
        AppMethodBeat.m2505o(92047);
        return c37176a;
    }
}
