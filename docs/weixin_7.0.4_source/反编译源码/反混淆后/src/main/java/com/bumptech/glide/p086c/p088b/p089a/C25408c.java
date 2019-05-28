package com.bumptech.glide.p086c.p088b.p089a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.bumptech.glide.c.b.a.c */
final class C25408c implements C0751l {
    private final C25409b aCq = new C25409b();
    private final C44982h<C25410a, Bitmap> aCr = new C44982h();

    /* renamed from: com.bumptech.glide.c.b.a.c$b */
    static class C25409b extends C37164d<C25410a> {
        C25409b() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: g */
        public final C25410a mo42450g(int i, int i2, Config config) {
            AppMethodBeat.m2504i(91900);
            C25410a c25410a = (C25410a) mo59240mS();
            c25410a.mo42452f(i, i2, config);
            AppMethodBeat.m2505o(91900);
            return c25410a;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        /* renamed from: mR */
        public final /* synthetic */ C31928m mo18619mR() {
            AppMethodBeat.m2504i(91901);
            C25410a c25410a = new C25410a(this);
            AppMethodBeat.m2505o(91901);
            return c25410a;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.a.c$a */
    static class C25410a implements C31928m {
        private final C25409b aCs;
        private Config aCt;
        private int height;
        private int width;

        public C25410a(C25409b c25409b) {
            this.aCs = c25409b;
        }

        /* renamed from: f */
        public final void mo42452f(int i, int i2, Config config) {
            this.width = i;
            this.height = i2;
            this.aCt = config;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C25410a)) {
                return false;
            }
            C25410a c25410a = (C25410a) obj;
            if (this.width == c25410a.width && this.height == c25410a.height && this.aCt == c25410a.aCt) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(91897);
            int hashCode = (this.aCt != null ? this.aCt.hashCode() : 0) + (((this.width * 31) + this.height) * 31);
            AppMethodBeat.m2505o(91897);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(91898);
            String e = C25408c.m40148e(this.width, this.height, this.aCt);
            AppMethodBeat.m2505o(91898);
            return e;
        }

        /* renamed from: mQ */
        public final void mo18616mQ() {
            AppMethodBeat.m2504i(91899);
            this.aCs.mo59239a(this);
            AppMethodBeat.m2505o(91899);
        }
    }

    C25408c() {
        AppMethodBeat.m2504i(91902);
        AppMethodBeat.m2505o(91902);
    }

    /* renamed from: g */
    public final void mo2205g(Bitmap bitmap) {
        AppMethodBeat.m2504i(91903);
        this.aCr.mo72259a(this.aCq.mo42450g(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
        AppMethodBeat.m2505o(91903);
    }

    /* renamed from: c */
    public final Bitmap mo2203c(int i, int i2, Config config) {
        AppMethodBeat.m2504i(91904);
        Bitmap bitmap = (Bitmap) this.aCr.mo72260b(this.aCq.mo42450g(i, i2, config));
        AppMethodBeat.m2505o(91904);
        return bitmap;
    }

    /* renamed from: mP */
    public final Bitmap mo2208mP() {
        AppMethodBeat.m2504i(91905);
        Bitmap bitmap = (Bitmap) this.aCr.removeLast();
        AppMethodBeat.m2505o(91905);
        return bitmap;
    }

    /* renamed from: d */
    public final String mo2204d(int i, int i2, Config config) {
        AppMethodBeat.m2504i(91907);
        String e = C25408c.m40148e(i, i2, config);
        AppMethodBeat.m2505o(91907);
        return e;
    }

    /* renamed from: i */
    public final int mo2207i(Bitmap bitmap) {
        AppMethodBeat.m2504i(91908);
        int k = C45002j.m82425k(bitmap);
        AppMethodBeat.m2505o(91908);
        return k;
    }

    public final String toString() {
        AppMethodBeat.m2504i(91909);
        String str = "AttributeStrategy:\n  " + this.aCr;
        AppMethodBeat.m2505o(91909);
        return str;
    }

    /* renamed from: e */
    static String m40148e(int i, int i2, Config config) {
        AppMethodBeat.m2504i(91910);
        String str = "[" + i + VideoMaterialUtil.CRAZYFACE_X + i2 + "], " + config;
        AppMethodBeat.m2505o(91910);
        return str;
    }

    /* renamed from: h */
    public final String mo2206h(Bitmap bitmap) {
        AppMethodBeat.m2504i(91906);
        String e = C25408c.m40148e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        AppMethodBeat.m2505o(91906);
        return e;
    }
}
