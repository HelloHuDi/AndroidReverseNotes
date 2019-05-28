package com.bumptech.glide.p086c.p090c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p1157g.C17555b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.c.f */
public final class C41194f<Data> implements C37175n<File, Data> {
    private final C37172d<Data> aDX;

    /* renamed from: com.bumptech.glide.c.c.f$b */
    public static class C8535b extends C36675a<ParcelFileDescriptor> {

        /* renamed from: com.bumptech.glide.c.c.f$b$1 */
        class C07611 implements C37172d<ParcelFileDescriptor> {
            C07611() {
            }

            /* renamed from: R */
            public final /* synthetic */ void mo2220R(Object obj) {
                AppMethodBeat.m2504i(92058);
                ((ParcelFileDescriptor) obj).close();
                AppMethodBeat.m2505o(92058);
            }

            /* renamed from: mg */
            public final Class<ParcelFileDescriptor> mo2221mg() {
                return ParcelFileDescriptor.class;
            }

            /* renamed from: o */
            public final /* synthetic */ Object mo2222o(File file) {
                AppMethodBeat.m2504i(92059);
                ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
                AppMethodBeat.m2505o(92059);
                return open;
            }
        }

        public C8535b() {
            super(new C07611());
            AppMethodBeat.m2504i(92060);
            AppMethodBeat.m2505o(92060);
        }
    }

    /* renamed from: com.bumptech.glide.c.c.f$c */
    static final class C25430c<Data> implements C0742d<Data> {
        private final C37172d<Data> aDY;
        private Data data;
        private final File file;

        C25430c(File file, C37172d<Data> c37172d) {
            this.file = file;
            this.aDY = c37172d;
        }

        /* renamed from: a */
        public final void mo2184a(C37192g c37192g, C0743a<? super Data> c0743a) {
            AppMethodBeat.m2504i(92061);
            try {
                this.data = this.aDY.mo2222o(this.file);
                c0743a.mo2189S(this.data);
                AppMethodBeat.m2505o(92061);
            } catch (FileNotFoundException e) {
                Log.isLoggable("FileLoader", 3);
                c0743a.mo2190b(e);
                AppMethodBeat.m2505o(92061);
            }
        }

        public final void cleanup() {
            AppMethodBeat.m2504i(92062);
            if (this.data != null) {
                try {
                    this.aDY.mo2220R(this.data);
                    AppMethodBeat.m2505o(92062);
                    return;
                } catch (IOException e) {
                }
            }
            AppMethodBeat.m2505o(92062);
        }

        public final void cancel() {
        }

        /* renamed from: mg */
        public final Class<Data> mo2187mg() {
            AppMethodBeat.m2504i(92063);
            Class mg = this.aDY.mo2221mg();
            AppMethodBeat.m2505o(92063);
            return mg;
        }

        /* renamed from: mh */
        public final C25405a mo2188mh() {
            return C25405a.LOCAL;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.f$a */
    public static class C36675a<Data> implements C31953o<File, Data> {
        private final C37172d<Data> aDY;

        public C36675a(C37172d<Data> c37172d) {
            this.aDY = c37172d;
        }

        /* renamed from: a */
        public final C37175n<File, Data> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92057);
            C41194f c41194f = new C41194f(this.aDY);
            AppMethodBeat.m2505o(92057);
            return c41194f;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.f$d */
    public interface C37172d<Data> {
        /* renamed from: R */
        void mo2220R(Data data);

        /* renamed from: mg */
        Class<Data> mo2221mg();

        /* renamed from: o */
        Data mo2222o(File file);
    }

    /* renamed from: com.bumptech.glide.c.c.f$e */
    public static class C37173e extends C36675a<InputStream> {

        /* renamed from: com.bumptech.glide.c.c.f$e$1 */
        class C371741 implements C37172d<InputStream> {
            C371741() {
            }

            /* renamed from: R */
            public final /* synthetic */ void mo2220R(Object obj) {
                AppMethodBeat.m2504i(92064);
                ((InputStream) obj).close();
                AppMethodBeat.m2505o(92064);
            }

            /* renamed from: mg */
            public final Class<InputStream> mo2221mg() {
                return InputStream.class;
            }

            /* renamed from: o */
            public final /* synthetic */ Object mo2222o(File file) {
                AppMethodBeat.m2504i(92065);
                FileInputStream fileInputStream = new FileInputStream(file);
                AppMethodBeat.m2505o(92065);
                return fileInputStream;
            }
        }

        public C37173e() {
            super(new C371741());
            AppMethodBeat.m2504i(92066);
            AppMethodBeat.m2505o(92066);
        }
    }

    /* renamed from: X */
    public final /* bridge */ /* synthetic */ boolean mo2224X(Object obj) {
        return true;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92067);
        File file = (File) obj;
        C37176a c37176a = new C37176a(new C17555b(file), new C25430c(file, this.aDX));
        AppMethodBeat.m2505o(92067);
        return c37176a;
    }

    public C41194f(C37172d<Data> c37172d) {
        this.aDX = c37172d;
    }
}
