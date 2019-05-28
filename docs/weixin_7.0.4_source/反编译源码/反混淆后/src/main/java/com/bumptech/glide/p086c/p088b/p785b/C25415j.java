package com.bumptech.glide.p086c.p088b.p785b;

import android.support.p057v4.p065f.C37122k.C8387a;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p095h.C0780f;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.C8561i;
import com.bumptech.glide.p095h.p1136a.C37193a;
import com.bumptech.glide.p095h.p1136a.C37193a.C31972c;
import com.bumptech.glide.p095h.p1136a.C37193a.C37194a;
import com.bumptech.glide.p095h.p1136a.C41574b;
import com.bumptech.glide.p095h.p1136a.C41574b.C17561a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.bumptech.glide.c.b.b.j */
public final class C25415j {
    private final C0780f<C0779h, String> aDv = new C0780f(1000);
    private final C8387a<C25416a> aDw = C37193a.m62341a(10, new C175201());

    /* renamed from: com.bumptech.glide.c.b.b.j$1 */
    class C175201 implements C37194a<C25416a> {
        C175201() {
        }

        /* renamed from: mG */
        public final /* synthetic */ Object mo18632mG() {
            AppMethodBeat.m2504i(91997);
            C25416a na = C175201.m27347na();
            AppMethodBeat.m2505o(91997);
            return na;
        }

        /* renamed from: na */
        private static C25416a m27347na() {
            AppMethodBeat.m2504i(91996);
            try {
                C25416a c25416a = new C25416a(MessageDigest.getInstance(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM));
                AppMethodBeat.m2505o(91996);
                return c25416a;
            } catch (NoSuchAlgorithmException e) {
                RuntimeException runtimeException = new RuntimeException(e);
                AppMethodBeat.m2505o(91996);
                throw runtimeException;
            }
        }
    }

    /* renamed from: com.bumptech.glide.c.b.b.j$a */
    static final class C25416a implements C31972c {
        private final C41574b aAq = new C17561a();
        final MessageDigest aDy;

        C25416a(MessageDigest messageDigest) {
            AppMethodBeat.m2504i(91998);
            this.aDy = messageDigest;
            AppMethodBeat.m2505o(91998);
        }

        /* renamed from: my */
        public final C41574b mo18630my() {
            return this.aAq;
        }
    }

    public C25415j() {
        AppMethodBeat.m2504i(91999);
        AppMethodBeat.m2505o(91999);
    }

    /* renamed from: c */
    public final String mo42462c(C0779h c0779h) {
        String str;
        AppMethodBeat.m2504i(92000);
        synchronized (this.aDv) {
            try {
                str = (String) this.aDv.get(c0779h);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(92000);
            }
        }
        if (str == null) {
            str = m40168d(c0779h);
        }
        synchronized (this.aDv) {
            try {
                this.aDv.put(c0779h, str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(92000);
                }
            }
        }
        return str;
    }

    /* renamed from: d */
    private String m40168d(C0779h c0779h) {
        AppMethodBeat.m2504i(92001);
        C25416a c25416a = (C25416a) C8561i.m15217d(this.aDw.mo6364aA(), "Argument must not be null");
        try {
            c0779h.mo2242a(c25416a.aDy);
            String i = C45002j.m82422i(c25416a.aDy.digest());
            return i;
        } finally {
            this.aDw.release(c25416a);
            AppMethodBeat.m2505o(92001);
        }
    }
}
