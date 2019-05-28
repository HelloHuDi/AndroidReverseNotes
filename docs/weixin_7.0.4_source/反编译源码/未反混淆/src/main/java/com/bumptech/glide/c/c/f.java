package com.bumptech.glide.c.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class f<Data> implements n<File, Data> {
    private final d<Data> aDX;

    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() {
                public final /* synthetic */ void R(Object obj) {
                    AppMethodBeat.i(92058);
                    ((ParcelFileDescriptor) obj).close();
                    AppMethodBeat.o(92058);
                }

                public final Class<ParcelFileDescriptor> mg() {
                    return ParcelFileDescriptor.class;
                }

                public final /* synthetic */ Object o(File file) {
                    AppMethodBeat.i(92059);
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
                    AppMethodBeat.o(92059);
                    return open;
                }
            });
            AppMethodBeat.i(92060);
            AppMethodBeat.o(92060);
        }
    }

    static final class c<Data> implements com.bumptech.glide.c.a.d<Data> {
        private final d<Data> aDY;
        private Data data;
        private final File file;

        c(File file, d<Data> dVar) {
            this.file = file;
            this.aDY = dVar;
        }

        public final void a(g gVar, com.bumptech.glide.c.a.d.a<? super Data> aVar) {
            AppMethodBeat.i(92061);
            try {
                this.data = this.aDY.o(this.file);
                aVar.S(this.data);
                AppMethodBeat.o(92061);
            } catch (FileNotFoundException e) {
                Log.isLoggable("FileLoader", 3);
                aVar.b(e);
                AppMethodBeat.o(92061);
            }
        }

        public final void cleanup() {
            AppMethodBeat.i(92062);
            if (this.data != null) {
                try {
                    this.aDY.R(this.data);
                    AppMethodBeat.o(92062);
                    return;
                } catch (IOException e) {
                }
            }
            AppMethodBeat.o(92062);
        }

        public final void cancel() {
        }

        public final Class<Data> mg() {
            AppMethodBeat.i(92063);
            Class mg = this.aDY.mg();
            AppMethodBeat.o(92063);
            return mg;
        }

        public final com.bumptech.glide.c.a mh() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    public static class a<Data> implements o<File, Data> {
        private final d<Data> aDY;

        public a(d<Data> dVar) {
            this.aDY = dVar;
        }

        public final n<File, Data> a(r rVar) {
            AppMethodBeat.i(92057);
            f fVar = new f(this.aDY);
            AppMethodBeat.o(92057);
            return fVar;
        }
    }

    public interface d<Data> {
        void R(Data data);

        Class<Data> mg();

        Data o(File file);
    }

    public static class e extends a<InputStream> {
        public e() {
            super(new d<InputStream>() {
                public final /* synthetic */ void R(Object obj) {
                    AppMethodBeat.i(92064);
                    ((InputStream) obj).close();
                    AppMethodBeat.o(92064);
                }

                public final Class<InputStream> mg() {
                    return InputStream.class;
                }

                public final /* synthetic */ Object o(File file) {
                    AppMethodBeat.i(92065);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    AppMethodBeat.o(92065);
                    return fileInputStream;
                }
            });
            AppMethodBeat.i(92066);
            AppMethodBeat.o(92066);
        }
    }

    public final /* bridge */ /* synthetic */ boolean X(Object obj) {
        return true;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92067);
        File file = (File) obj;
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(new com.bumptech.glide.g.b(file), new c(file, this.aDX));
        AppMethodBeat.o(92067);
        return aVar;
    }

    public f(d<Data> dVar) {
        this.aDX = dVar;
    }
}
