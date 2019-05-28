package com.tencent.soter.p663a.p664g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.p663a.p1105a.C40985a;
import com.tencent.soter.p663a.p1105a.C40986b;
import com.tencent.soter.p663a.p1108f.C24293c;
import com.tencent.soter.p663a.p1108f.C40991f;
import com.tencent.soter.p663a.p1349d.C40987a;
import com.tencent.soter.p663a.p1349d.C40989b;

/* renamed from: com.tencent.soter.a.g.b */
public final class C24298b {
    C24293c Awf;
    public C40991f Awg;
    public int Awh;
    C40989b Awi;
    C40986b Awj;
    public int gOW;
    Context mContext;
    C40987a mrV;
    C40985a mrW;
    String tWZ;

    /* renamed from: com.tencent.soter.a.g.b$a */
    public static class C5823a {
        public C24298b Awk = new C24298b();

        public C5823a() {
            AppMethodBeat.m2504i(10477);
            AppMethodBeat.m2505o(10477);
        }

        /* renamed from: Rj */
        public final C5823a mo12210Rj(int i) {
            this.Awk.gOW = i;
            return this;
        }

        public final C5823a aug(String str) {
            this.Awk.tWZ = str;
            return this;
        }

        /* renamed from: iW */
        public final C5823a mo12217iW(Context context) {
            this.Awk.mContext = context;
            return this;
        }

        /* renamed from: a */
        public final C5823a mo12214a(C40987a c40987a) {
            this.Awk.mrV = c40987a;
            return this;
        }

        /* renamed from: a */
        public final C5823a mo12215a(C40989b c40989b) {
            this.Awk.Awi = c40989b;
            return this;
        }

        /* renamed from: a */
        public final C5823a mo12212a(C40985a c40985a) {
            this.Awk.mrW = c40985a;
            return this;
        }

        /* renamed from: a */
        public final C5823a mo12213a(C40986b c40986b) {
            this.Awk.Awj = c40986b;
            return this;
        }

        /* renamed from: Rk */
        public final C5823a mo12211Rk(int i) {
            this.Awk.Awh = i;
            return this;
        }
    }

    /* synthetic */ C24298b(byte b) {
        this();
    }

    private C24298b() {
    }

    public final String toString() {
        AppMethodBeat.m2504i(10478);
        String str = "AuthenticationParam{mScene=" + this.gOW + ", mChallenge='" + this.tWZ + '\'' + ", mIWrapGetChallengeStr=" + this.Awf + ", mIWrapUploadSignature=" + this.Awg + ", mContext=" + this.mContext + ", mBiometricType=" + this.Awh + '}';
        AppMethodBeat.m2505o(10478);
        return str;
    }
}
