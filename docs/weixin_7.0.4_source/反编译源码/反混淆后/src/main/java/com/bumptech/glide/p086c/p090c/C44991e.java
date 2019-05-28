package com.bumptech.glide.p086c.p090c;

import android.util.Base64;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p1157g.C17555b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.c.e */
public final class C44991e<Model, Data> implements C37175n<Model, Data> {
    private final C44990a<Data> aDS;

    /* renamed from: com.bumptech.glide.c.c.e$b */
    static final class C8532b<Data> implements C0742d<Data> {
        private final String aDT;
        private final C44990a<Data> aDU;
        private Data data;

        C8532b(String str, C44990a<Data> c44990a) {
            this.aDT = str;
            this.aDU = c44990a;
        }

        /* renamed from: a */
        public final void mo2184a(C37192g c37192g, C0743a<? super Data> c0743a) {
            AppMethodBeat.m2504i(92048);
            try {
                this.data = this.aDU.mo18636aa(this.aDT);
                c0743a.mo2189S(this.data);
                AppMethodBeat.m2505o(92048);
            } catch (IllegalArgumentException e) {
                c0743a.mo2190b(e);
                AppMethodBeat.m2505o(92048);
            }
        }

        public final void cleanup() {
            AppMethodBeat.m2504i(92049);
            try {
                this.aDU.mo18635R(this.data);
                AppMethodBeat.m2505o(92049);
            } catch (IOException e) {
                AppMethodBeat.m2505o(92049);
            }
        }

        public final void cancel() {
        }

        /* renamed from: mg */
        public final Class<Data> mo2187mg() {
            AppMethodBeat.m2504i(92050);
            Class mg = this.aDU.mo18637mg();
            AppMethodBeat.m2505o(92050);
            return mg;
        }

        /* renamed from: mh */
        public final C25405a mo2188mh() {
            return C25405a.LOCAL;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.e$c */
    public static final class C8533c<Model> implements C31953o<Model, InputStream> {
        private final C44990a<InputStream> aDV = new C85341();

        /* renamed from: com.bumptech.glide.c.c.e$c$1 */
        class C85341 implements C44990a<InputStream> {
            C85341() {
            }

            /* renamed from: R */
            public final /* synthetic */ void mo18635R(Object obj) {
                AppMethodBeat.m2504i(92051);
                ((InputStream) obj).close();
                AppMethodBeat.m2505o(92051);
            }

            /* renamed from: mg */
            public final Class<InputStream> mo18637mg() {
                return InputStream.class;
            }

            /* renamed from: aa */
            public final /* synthetic */ Object mo18636aa(String str) {
                AppMethodBeat.m2504i(92052);
                IllegalArgumentException illegalArgumentException;
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        illegalArgumentException = new IllegalArgumentException("Missing comma in data URL.");
                        AppMethodBeat.m2505o(92052);
                        throw illegalArgumentException;
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        AppMethodBeat.m2505o(92052);
                        return byteArrayInputStream;
                    } else {
                        illegalArgumentException = new IllegalArgumentException("Not a base64 image data URL.");
                        AppMethodBeat.m2505o(92052);
                        throw illegalArgumentException;
                    }
                }
                illegalArgumentException = new IllegalArgumentException("Not a valid image data URL.");
                AppMethodBeat.m2505o(92052);
                throw illegalArgumentException;
            }
        }

        public C8533c() {
            AppMethodBeat.m2504i(92053);
            AppMethodBeat.m2505o(92053);
        }

        /* renamed from: a */
        public final C37175n<Model, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92054);
            C44991e c44991e = new C44991e(this.aDV);
            AppMethodBeat.m2505o(92054);
            return c44991e;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.e$a */
    public interface C44990a<Data> {
        /* renamed from: R */
        void mo18635R(Data data);

        /* renamed from: aa */
        Data mo18636aa(String str);

        /* renamed from: mg */
        Class<Data> mo18637mg();
    }

    public C44991e(C44990a<Data> c44990a) {
        this.aDS = c44990a;
    }

    /* renamed from: b */
    public final C37176a<Data> mo2225b(Model model, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92055);
        C37176a c37176a = new C37176a(new C17555b(model), new C8532b(model.toString(), this.aDS));
        AppMethodBeat.m2505o(92055);
        return c37176a;
    }

    /* renamed from: X */
    public final boolean mo2224X(Model model) {
        AppMethodBeat.m2504i(92056);
        boolean startsWith = model.toString().startsWith("data:image");
        AppMethodBeat.m2505o(92056);
        return startsWith;
    }
}
