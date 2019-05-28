package com.bumptech.glide.c.b.b;

import com.bumptech.glide.c.h;
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.a.b;
import com.bumptech.glide.h.f;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class j {
    private final f<h, String> aDv = new f(1000);
    private final android.support.v4.f.k.a<a> aDw = com.bumptech.glide.h.a.a.a(10, new com.bumptech.glide.h.a.a.a<a>() {
        public final /* synthetic */ Object mG() {
            AppMethodBeat.i(91997);
            a na = AnonymousClass1.na();
            AppMethodBeat.o(91997);
            return na;
        }

        private static a na() {
            AppMethodBeat.i(91996);
            try {
                a aVar = new a(MessageDigest.getInstance(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM));
                AppMethodBeat.o(91996);
                return aVar;
            } catch (NoSuchAlgorithmException e) {
                RuntimeException runtimeException = new RuntimeException(e);
                AppMethodBeat.o(91996);
                throw runtimeException;
            }
        }
    });

    static final class a implements c {
        private final b aAq = new com.bumptech.glide.h.a.b.a();
        final MessageDigest aDy;

        a(MessageDigest messageDigest) {
            AppMethodBeat.i(91998);
            this.aDy = messageDigest;
            AppMethodBeat.o(91998);
        }

        public final b my() {
            return this.aAq;
        }
    }

    public j() {
        AppMethodBeat.i(91999);
        AppMethodBeat.o(91999);
    }

    public final String c(h hVar) {
        String str;
        AppMethodBeat.i(92000);
        synchronized (this.aDv) {
            try {
                str = (String) this.aDv.get(hVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(92000);
            }
        }
        if (str == null) {
            str = d(hVar);
        }
        synchronized (this.aDv) {
            try {
                this.aDv.put(hVar, str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(92000);
                }
            }
        }
        return str;
    }

    private String d(h hVar) {
        AppMethodBeat.i(92001);
        a aVar = (a) i.d(this.aDw.aA(), "Argument must not be null");
        try {
            hVar.a(aVar.aDy);
            String i = com.bumptech.glide.h.j.i(aVar.aDy.digest());
            return i;
        } finally {
            this.aDw.release(aVar);
            AppMethodBeat.o(92001);
        }
    }
}
