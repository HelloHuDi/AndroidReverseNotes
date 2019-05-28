package com.bumptech.glide.c.c;

import android.util.Base64;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e<Model, Data> implements n<Model, Data> {
    private final a<Data> aDS;

    static final class b<Data> implements d<Data> {
        private final String aDT;
        private final a<Data> aDU;
        private Data data;

        b(String str, a<Data> aVar) {
            this.aDT = str;
            this.aDU = aVar;
        }

        public final void a(g gVar, com.bumptech.glide.c.a.d.a<? super Data> aVar) {
            AppMethodBeat.i(92048);
            try {
                this.data = this.aDU.aa(this.aDT);
                aVar.S(this.data);
                AppMethodBeat.o(92048);
            } catch (IllegalArgumentException e) {
                aVar.b(e);
                AppMethodBeat.o(92048);
            }
        }

        public final void cleanup() {
            AppMethodBeat.i(92049);
            try {
                this.aDU.R(this.data);
                AppMethodBeat.o(92049);
            } catch (IOException e) {
                AppMethodBeat.o(92049);
            }
        }

        public final void cancel() {
        }

        public final Class<Data> mg() {
            AppMethodBeat.i(92050);
            Class mg = this.aDU.mg();
            AppMethodBeat.o(92050);
            return mg;
        }

        public final com.bumptech.glide.c.a mh() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {
        private final a<InputStream> aDV = new a<InputStream>() {
            public final /* synthetic */ void R(Object obj) {
                AppMethodBeat.i(92051);
                ((InputStream) obj).close();
                AppMethodBeat.o(92051);
            }

            public final Class<InputStream> mg() {
                return InputStream.class;
            }

            public final /* synthetic */ Object aa(String str) {
                AppMethodBeat.i(92052);
                IllegalArgumentException illegalArgumentException;
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        illegalArgumentException = new IllegalArgumentException("Missing comma in data URL.");
                        AppMethodBeat.o(92052);
                        throw illegalArgumentException;
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        AppMethodBeat.o(92052);
                        return byteArrayInputStream;
                    } else {
                        illegalArgumentException = new IllegalArgumentException("Not a base64 image data URL.");
                        AppMethodBeat.o(92052);
                        throw illegalArgumentException;
                    }
                }
                illegalArgumentException = new IllegalArgumentException("Not a valid image data URL.");
                AppMethodBeat.o(92052);
                throw illegalArgumentException;
            }
        };

        public c() {
            AppMethodBeat.i(92053);
            AppMethodBeat.o(92053);
        }

        public final n<Model, InputStream> a(r rVar) {
            AppMethodBeat.i(92054);
            e eVar = new e(this.aDV);
            AppMethodBeat.o(92054);
            return eVar;
        }
    }

    public interface a<Data> {
        void R(Data data);

        Data aa(String str);

        Class<Data> mg();
    }

    public e(a<Data> aVar) {
        this.aDS = aVar;
    }

    public final com.bumptech.glide.c.c.n.a<Data> b(Model model, int i, int i2, j jVar) {
        AppMethodBeat.i(92055);
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(new com.bumptech.glide.g.b(model), new b(model.toString(), this.aDS));
        AppMethodBeat.o(92055);
        return aVar;
    }

    public final boolean X(Model model) {
        AppMethodBeat.i(92056);
        boolean startsWith = model.toString().startsWith("data:image");
        AppMethodBeat.o(92056);
        return startsWith;
    }
}
