package com.tencent.soter.p663a.p664g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationResult;
import com.tencent.soter.core.biometric.BiometricManagerCompat.CryptoObject;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C30973j;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.p663a.p1105a.C40985a;
import com.tencent.soter.p663a.p1105a.C40986b;
import com.tencent.soter.p663a.p1106b.C16163a;
import com.tencent.soter.p663a.p1107c.C16167a;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C24293c;
import com.tencent.soter.p663a.p1108f.C24293c.C24292b;
import com.tencent.soter.p663a.p1108f.C24293c.C24294a;
import com.tencent.soter.p663a.p1108f.C40991f;
import com.tencent.soter.p663a.p1108f.C40991f.C40990a;
import com.tencent.soter.p663a.p1108f.C40991f.C40992b;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;
import junit.framework.Assert;

/* renamed from: com.tencent.soter.a.g.i */
public final class C24303i extends C44469d implements C16169a {
    String AvS = null;
    private C24293c AwB = null;
    C40991f AwC = null;
    private WeakReference<Context> AwD = null;
    C30973j AwG = null;
    boolean AwI;
    boolean AwJ;
    boolean AwK;
    C40985a AwS = null;
    C40986b AwT = null;
    private C24307a AwU = null;
    int Awh;
    private int gOW = -1;
    String tWZ = null;

    /* renamed from: com.tencent.soter.a.g.i$3 */
    class C161703 implements Runnable {
        C161703() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10523);
            if (C24303i.this.AwT != null) {
                C24303i.this.AwT.bxL();
            }
            AppMethodBeat.m2505o(10523);
        }
    }

    /* renamed from: com.tencent.soter.a.g.i$1 */
    class C243041 implements C24291b<C24292b> {
        C243041() {
        }

        /* renamed from: dd */
        public final /* synthetic */ void mo40382dd(Object obj) {
            AppMethodBeat.m2504i(10521);
            C24292b c24292b = (C24292b) obj;
            if (C24321g.isNullOrNil(c24292b.msn)) {
                C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: get challenge failed", new Object[0]);
                C24303i.this.mo70642b(new C16163a(19));
                AppMethodBeat.m2505o(10521);
                return;
            }
            C24303i.this.tWZ = c24292b.msn;
            C24303i.this.dRr();
            AppMethodBeat.m2505o(10521);
        }
    }

    /* renamed from: com.tencent.soter.a.g.i$2 */
    class C243052 implements Runnable {
        C243052() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10522);
            if (C24303i.this.AwT != null) {
                C24303i.this.AwT.bxL();
            }
            AppMethodBeat.m2505o(10522);
        }
    }

    /* renamed from: com.tencent.soter.a.g.i$4 */
    class C243064 implements C24291b<C40992b> {
        C243064() {
        }

        /* renamed from: dd */
        public final /* synthetic */ void mo40382dd(Object obj) {
            AppMethodBeat.m2504i(10524);
            if (((C40992b) obj).lSP) {
                C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: upload and verify succeed", new Object[0]);
                C24303i.this.mo70642b(new C16163a(C24303i.this.AwG));
                AppMethodBeat.m2505o(10524);
                return;
            }
            C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: upload or verify failed", new Object[0]);
            C24303i.this.mo70642b(new C16163a(23));
            AppMethodBeat.m2505o(10524);
        }
    }

    /* renamed from: com.tencent.soter.a.g.i$a */
    class C24307a extends AuthenticationCallback {
        private long AvH;
        private Signature AwM;

        /* renamed from: com.tencent.soter.a.g.i$a$5 */
        class C161715 implements Runnable {
            C161715() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10529);
                if (C24303i.this.AwT != null) {
                    C24303i.this.AwT.onAuthenticationFailed();
                }
                AppMethodBeat.m2505o(10529);
            }
        }

        /* renamed from: com.tencent.soter.a.g.i$a$7 */
        class C243027 implements Runnable {
            C243027() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10531);
                C24303i.this.AwS.dRd();
                AppMethodBeat.m2505o(10531);
            }
        }

        /* renamed from: com.tencent.soter.a.g.i$a$3 */
        class C243083 implements Runnable {
            C243083() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10527);
                if (C24303i.this.AwT != null) {
                    C24303i.this.AwT.bxM();
                }
                AppMethodBeat.m2505o(10527);
            }
        }

        /* renamed from: com.tencent.soter.a.g.i$a$4 */
        class C243094 implements Runnable {
            C243094() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10528);
                C24303i c24303i;
                if (C24321g.isNullOrNil(C24303i.this.tWZ)) {
                    C44476d.m80483e("Soter.TaskBiometricAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                    C24307a.this.onAuthenticationError(-1000, "challenge is null");
                    AppMethodBeat.m2505o(10528);
                } else if (C40997a.dQL() == 1) {
                    c24303i = C24303i.this;
                    C24307a.this.AwM;
                    try {
                        c24303i.AwG = C40997a.m71094co(C40997a.m71102nB(C24307a.this.AvH));
                        if (c24303i.AwC != null) {
                            c24303i.dRs();
                            AppMethodBeat.m2505o(10528);
                            return;
                        }
                        C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                        c24303i.mo70642b(new C16163a(c24303i.AwG));
                        AppMethodBeat.m2505o(10528);
                    } catch (Exception e) {
                        C44476d.m80483e("Soter.TaskBiometricAuthentication", "soter: finish sign failed due to exception: %s", e.getMessage());
                        C44476d.m80481a("Soter.TaskBiometricAuthentication", e, "soter: sign failed due to exception");
                        c24303i.mo70642b(new C16163a(22, "sign failed even after user authenticated the key."));
                        AppMethodBeat.m2505o(10528);
                    }
                } else {
                    try {
                        C24307a.this.AwM.update(C24303i.this.tWZ.getBytes(Charset.forName("UTF-8")));
                    } catch (SignatureException e2) {
                        C44476d.m80483e("Soter.TaskBiometricAuthentication", "soter: exception in update", new Object[0]);
                        C44476d.m80481a("Soter.TaskBiometricAuthentication", e2, "soter: exception in update");
                        C44476d.m80483e("Soter.TaskBiometricAuthentication", "soter: remove the auth key: %s", C24303i.this.AvS);
                        C40997a.m71093cn(C24303i.this.AvS, false);
                        C24303i.this.mo70642b(new C16163a(30, "update signature failed. authkey removed after this failure, please check"));
                    }
                    try {
                        c24303i = C24303i.this;
                        try {
                            c24303i.AwG = C40997a.m71094co(C24307a.this.AwM.sign());
                            if (c24303i.AwC != null) {
                                c24303i.dRs();
                                AppMethodBeat.m2505o(10528);
                                return;
                            }
                            C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                            c24303i.mo70642b(new C16163a(c24303i.AwG));
                            AppMethodBeat.m2505o(10528);
                        } catch (SignatureException e22) {
                            C44476d.m80483e("Soter.TaskBiometricAuthentication", "soter: sign failed due to exception: %s", e22.getMessage());
                            C44476d.m80481a("Soter.TaskBiometricAuthentication", e22, "soter: sign failed due to exception");
                            c24303i.mo70642b(new C16163a(22, "sign failed even after user authenticated the key."));
                            AppMethodBeat.m2505o(10528);
                        }
                    } catch (Exception e3) {
                        C44476d.m80483e("Soter.TaskBiometricAuthentication", "soter: exception in executeWhenAuthenticated method", new Object[0]);
                        C44476d.m80481a("Soter.TaskBiometricAuthentication", e3, "soter: exception when execute");
                        C24307a.this.onAuthenticationError(-1000, "execute failed");
                        AppMethodBeat.m2505o(10528);
                    }
                }
            }
        }

        /* renamed from: com.tencent.soter.a.g.i$a$6 */
        class C243106 implements Runnable {
            C243106() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10530);
                if (C24303i.this.AwT != null) {
                    C24303i.this.AwT.onAuthenticationCancelled();
                }
                AppMethodBeat.m2505o(10530);
            }
        }

        /* renamed from: com.tencent.soter.a.g.i$a$8 */
        class C243128 implements Runnable {
            C243128() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10532);
                C24303i.this.mo40387b(C24307a.this.AwM);
                AppMethodBeat.m2505o(10532);
            }
        }

        /* synthetic */ C24307a(C24303i c24303i, Signature signature, byte b) {
            this(signature);
        }

        /* renamed from: ap */
        static /* synthetic */ String m37476ap(CharSequence charSequence) {
            AppMethodBeat.m2504i(10540);
            String ao = C24307a.m37475ao(charSequence);
            AppMethodBeat.m2505o(10540);
            return ao;
        }

        private C24307a(Signature signature) {
            this.AwM = null;
            this.AwM = signature;
        }

        /* renamed from: ao */
        private static String m37475ao(CharSequence charSequence) {
            AppMethodBeat.m2504i(10533);
            String str;
            if (charSequence == null) {
                str = "unknown error";
                AppMethodBeat.m2505o(10533);
                return str;
            }
            str = charSequence.toString();
            AppMethodBeat.m2505o(10533);
            return str;
        }

        public final void onAuthenticationError(final int i, final CharSequence charSequence) {
            AppMethodBeat.m2504i(10534);
            C44476d.m80483e("Soter.TaskBiometricAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i), charSequence);
            C44472g.dRq().mo70645d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10525);
                    if (C24303i.this.AwT != null) {
                        C24303i.this.AwT.onAuthenticationError(i, charSequence);
                    }
                    AppMethodBeat.m2505o(10525);
                }
            });
            if (i == 10308) {
                C24303i.this.mo70642b(new C16163a(25, C24307a.m37475ao(charSequence)));
            } else {
                C24303i.this.mo70642b(new C16163a(21, C24307a.m37475ao(charSequence)));
            }
            dRu();
            AppMethodBeat.m2505o(10534);
        }

        public final void onAuthenticationHelp(final int i, final CharSequence charSequence) {
            AppMethodBeat.m2504i(10535);
            C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i), charSequence);
            C44472g.dRq().mo70645d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10526);
                    if (C24303i.this.AwT != null) {
                        C24303i.this.AwT.onAuthenticationHelp(i, C24307a.m37476ap(charSequence));
                    }
                    AppMethodBeat.m2505o(10526);
                }
            });
            AppMethodBeat.m2505o(10535);
        }

        public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
            AppMethodBeat.m2504i(10536);
            C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            C44472g.dRq().mo70645d(new C243083());
            C44472g.dRq().mo70644R(new C243094());
            dRu();
            AppMethodBeat.m2505o(10536);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.m2504i(10537);
            C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: authentication failed once", new Object[0]);
            C44472g.dRq().mo70645d(new C161715());
            if (C24303i.this.AwI) {
                C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                C24303i.this.AwS.mo64929rp(false);
                C44472g.dRq().mo70644R(new C243027());
                C44472g.dRq().mo70646s(new C243128(), 1000);
            }
            if (C24303i.this.Awh == 2) {
                C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: should compat faceid logic.", new Object[0]);
                C24303i.this.mo70642b(new C16163a(21, "faceid not match"));
            }
            AppMethodBeat.m2505o(10537);
        }

        public final void onAuthenticationCancelled() {
            AppMethodBeat.m2504i(10538);
            C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (C24303i.this.AwK) {
                C44476d.m80485v("Soter.TaskBiometricAuthentication", "soter: during ignore cancel period", new Object[0]);
                AppMethodBeat.m2505o(10538);
                return;
            }
            C44472g.dRq().mo70645d(new C243106());
            C24303i.this.mo70642b(new C16163a(24, "user cancelled authentication"));
            dRu();
            AppMethodBeat.m2505o(10538);
        }

        @SuppressLint({"NewApi"})
        private void dRu() {
            AppMethodBeat.m2504i(10539);
            if (C24303i.this.AwJ || C24303i.this.Awh == 2) {
                C24303i.this.AwS.mo64929rp(false);
                C24303i.this.AwK = true;
            }
            AppMethodBeat.m2505o(10539);
        }
    }

    public C24303i(C24298b c24298b) {
        boolean z = true;
        AppMethodBeat.m2504i(10541);
        boolean z2 = VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.AwI = z2;
        if (VERSION.SDK_INT >= 23) {
            z = false;
        }
        this.AwJ = z;
        this.AwK = false;
        if (c24298b == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("param is null!");
            AppMethodBeat.m2505o(10541);
            throw illegalArgumentException;
        }
        this.gOW = c24298b.gOW;
        this.AwB = c24298b.Awf;
        this.AwC = c24298b.Awg;
        this.AwD = new WeakReference(c24298b.mContext);
        this.AwT = c24298b.Awj;
        this.AwS = c24298b.mrW;
        this.Awh = c24298b.Awh;
        this.tWZ = c24298b.tWZ;
        AppMethodBeat.m2505o(10541);
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"DefaultLocale", "NewApi"})
    public final boolean dRl() {
        AppMethodBeat.m2504i(10542);
        if (!C16167a.dRe().isInit()) {
            C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: not initialized yet", new Object[0]);
            mo70642b(new C16163a(14));
            AppMethodBeat.m2505o(10542);
            return true;
        } else if (C16167a.dRe().dRc()) {
            Assert.assertTrue(VERSION.SDK_INT >= 16);
            this.AvS = (String) C16167a.dRe().dRg().get(this.gOW, "");
            if (C24321g.isNullOrNil(this.AvS)) {
                C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                mo70642b(new C16163a(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.m2505o(10542);
                return true;
            } else if (!C40997a.aua(this.AvS)) {
                C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: auth key %s not exists. need re-generate", this.AvS);
                mo70642b(new C16163a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.m2505o(10542);
                return true;
            } else if (this.AwB == null && C24321g.isNullOrNil(this.tWZ)) {
                C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                mo70642b(new C16163a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
                AppMethodBeat.m2505o(10542);
                return true;
            } else {
                Context context = (Context) this.AwD.get();
                if (context == null) {
                    C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    mo70642b(new C16163a(17));
                    AppMethodBeat.m2505o(10542);
                    return true;
                } else if (!BiometricManagerCompat.from(context, Integer.valueOf(this.Awh)).hasEnrolledBiometric()) {
                    C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: user has not enrolled any biometric in system.", new Object[0]);
                    mo70642b(new C16163a(18));
                    AppMethodBeat.m2505o(10542);
                    return true;
                } else if (C40997a.m71092aC(context, this.Awh)) {
                    C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: biometric sensor frozen", new Object[0]);
                    mo70642b(new C16163a(25, "Too many failed times"));
                    AppMethodBeat.m2505o(10542);
                    return true;
                } else if (this.AwS == null) {
                    C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.AwS = new C40985a();
                    AppMethodBeat.m2505o(10542);
                    return false;
                } else {
                    if (this.AwC == null) {
                        C44476d.m80486w("Soter.TaskBiometricAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    AppMethodBeat.m2505o(10542);
                    return false;
                }
            }
        } else {
            C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: not support soter", new Object[0]);
            mo70642b(new C16163a(2));
            AppMethodBeat.m2505o(10542);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
        AppMethodBeat.m2504i(10543);
        if (this.AwS != null) {
            this.AwS.mo64929rp(true);
        }
        AppMethodBeat.m2505o(10543);
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.m2504i(10544);
        if (C24321g.isNullOrNil(this.tWZ)) {
            C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.AwB.mo55795bR(new C24294a());
            this.AwB.mo55794a(new C243041());
            this.AwB.execute();
            AppMethodBeat.m2505o(10544);
            return;
        }
        C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        dRr();
        AppMethodBeat.m2505o(10544);
    }

    /* Access modifiers changed, original: final */
    public final void dRr() {
        AppMethodBeat.m2504i(10545);
        if (C40997a.dQL() == 1) {
            SoterSessionResult iC = C40997a.m71095iC(this.AvS, this.tWZ);
            if (iC == null) {
                C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
                mo70642b(new C16163a(13));
                AppMethodBeat.m2505o(10545);
                return;
            } else if (iC.bFZ != 0) {
                C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
                mo70642b(new C16163a(13));
                AppMethodBeat.m2505o(10545);
                return;
            } else {
                C44476d.m80482d("Soter.TaskBiometricAuthentication", "soter: session is %d", Long.valueOf(iC.AvH));
                this.AwU = new C24307a(this, null, (byte) 0);
                this.AwU.AvH = iC.AvH;
                mo40387b(null);
                C44472g.dRq().mo70645d(new C243052());
                AppMethodBeat.m2505o(10545);
                return;
            }
        }
        Signature aud = C40997a.aud(this.AvS);
        if (aud == null) {
            C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign", new Object[0]);
            mo70642b(new C16163a(13));
            AppMethodBeat.m2505o(10545);
            return;
        }
        this.AwU = new C24307a(this, aud, (byte) 0);
        mo40387b(aud);
        C44472g.dRq().mo70645d(new C161703());
        AppMethodBeat.m2505o(10545);
    }

    /* Access modifiers changed, original: final */
    public final void dRs() {
        AppMethodBeat.m2504i(10547);
        if (this.AwG == null) {
            mo70642b(new C16163a(22, "sign failed even after user authenticated the key."));
            AppMethodBeat.m2505o(10547);
            return;
        }
        this.AwC.mo55795bR(new C40990a(this.AwG.signature, this.AwG.Avx, this.AwG.Avw));
        this.AwC.mo55794a(new C243064());
        this.AwC.execute();
        AppMethodBeat.m2505o(10547);
    }

    public final void dRk() {
        AppMethodBeat.m2504i(10548);
        C44476d.m80484i("Soter.TaskBiometricAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.AwU != null) {
            this.AwU.onAuthenticationCancelled();
        }
        AppMethodBeat.m2505o(10548);
    }

    public final boolean isCancelled() {
        return this.AwK;
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public final void mo40387b(Signature signature) {
        CancellationSignal cancellationSignal = null;
        AppMethodBeat.m2504i(10546);
        if (this.AvW) {
            C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            AppMethodBeat.m2505o(10546);
            return;
        }
        Context context = (Context) this.AwD.get();
        if (context == null) {
            C44476d.m80486w("Soter.TaskBiometricAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            mo70642b(new C16163a(17));
            AppMethodBeat.m2505o(10546);
            return;
        }
        try {
            C44476d.m80485v("Soter.TaskBiometricAuthentication", "soter: performing start", new Object[0]);
            BiometricManagerCompat from = BiometricManagerCompat.from(context, Integer.valueOf(this.Awh));
            CryptoObject cryptoObject = new CryptoObject(signature);
            if (this.AwS != null) {
                cancellationSignal = this.AwS.zZp;
            }
            from.authenticate(cryptoObject, 0, cancellationSignal, this.AwU, null);
            AppMethodBeat.m2505o(10546);
        } catch (Exception e) {
            String message = e.getMessage();
            C44476d.m80483e("Soter.TaskBiometricAuthentication", "soter: caused exception when authenticating: %s", message);
            C44476d.m80481a("Soter.TaskBiometricAuthentication", e, "soter: caused exception when authenticating");
            mo70642b(new C16163a(20, String.format("start authentication failed due to %s", new Object[]{message})));
            AppMethodBeat.m2505o(10546);
        }
    }
}
