package com.tencent.soter.a.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;

public final class b {
    c Awf;
    public f Awg;
    public int Awh;
    com.tencent.soter.a.d.b Awi;
    com.tencent.soter.a.a.b Awj;
    public int gOW;
    Context mContext;
    com.tencent.soter.a.d.a mrV;
    com.tencent.soter.a.a.a mrW;
    String tWZ;

    public static class a {
        public b Awk = new b();

        public a() {
            AppMethodBeat.i(10477);
            AppMethodBeat.o(10477);
        }

        public final a Rj(int i) {
            this.Awk.gOW = i;
            return this;
        }

        public final a aug(String str) {
            this.Awk.tWZ = str;
            return this;
        }

        public final a iW(Context context) {
            this.Awk.mContext = context;
            return this;
        }

        public final a a(com.tencent.soter.a.d.a aVar) {
            this.Awk.mrV = aVar;
            return this;
        }

        public final a a(com.tencent.soter.a.d.b bVar) {
            this.Awk.Awi = bVar;
            return this;
        }

        public final a a(com.tencent.soter.a.a.a aVar) {
            this.Awk.mrW = aVar;
            return this;
        }

        public final a a(com.tencent.soter.a.a.b bVar) {
            this.Awk.Awj = bVar;
            return this;
        }

        public final a Rk(int i) {
            this.Awk.Awh = i;
            return this;
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }

    public final String toString() {
        AppMethodBeat.i(10478);
        String str = "AuthenticationParam{mScene=" + this.gOW + ", mChallenge='" + this.tWZ + '\'' + ", mIWrapGetChallengeStr=" + this.Awf + ", mIWrapUploadSignature=" + this.Awg + ", mContext=" + this.mContext + ", mBiometricType=" + this.Awh + '}';
        AppMethodBeat.o(10478);
        return str;
    }
}
