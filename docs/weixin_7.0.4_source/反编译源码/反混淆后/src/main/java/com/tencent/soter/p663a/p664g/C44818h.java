package com.tencent.soter.p663a.p664g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C30973j;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p665a.C44473a;
import com.tencent.soter.core.p665a.C44473a.C36452d;
import com.tencent.soter.core.p665a.C44473a.C5825b;
import com.tencent.soter.p663a.p1106b.C16163a;
import com.tencent.soter.p663a.p1107c.C16167a;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C24293c;
import com.tencent.soter.p663a.p1108f.C24293c.C24292b;
import com.tencent.soter.p663a.p1108f.C24293c.C24294a;
import com.tencent.soter.p663a.p1108f.C40991f;
import com.tencent.soter.p663a.p1108f.C40991f.C40990a;
import com.tencent.soter.p663a.p1108f.C40991f.C40992b;
import com.tencent.soter.p663a.p1349d.C40987a;
import com.tencent.soter.p663a.p1349d.C40989b;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;
import junit.framework.Assert;

/* renamed from: com.tencent.soter.a.g.h */
public final class C44818h extends C44469d implements C16169a {
    String AvS = null;
    private C24293c AwB = null;
    C40991f AwC = null;
    private WeakReference<Context> AwD = null;
    C40987a AwE = null;
    C40989b AwF = null;
    C30973j AwG = null;
    private C7381a AwH = null;
    boolean AwI;
    boolean AwJ;
    boolean AwK;
    private int gOW = -1;
    String tWZ = null;

    /* renamed from: com.tencent.soter.a.g.h$a */
    class C7381a extends C5825b {
        long AvH;
        Signature AwM;

        /* renamed from: com.tencent.soter.a.g.h$a$8 */
        class C73828 implements Runnable {
            C73828() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10505);
                C44818h.this.mo72023a(C7381a.this.AwM);
                AppMethodBeat.m2505o(10505);
            }
        }

        /* renamed from: com.tencent.soter.a.g.h$a$6 */
        class C73846 implements Runnable {
            C73846() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10503);
                if (C44818h.this.AwF != null) {
                    C44818h.this.AwF.onAuthenticationCancelled();
                }
                AppMethodBeat.m2505o(10503);
            }
        }

        /* renamed from: com.tencent.soter.a.g.h$a$7 */
        class C73857 implements Runnable {
            C73857() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10504);
                C44818h.this.AwE.dRd();
                AppMethodBeat.m2505o(10504);
            }
        }

        /* renamed from: com.tencent.soter.a.g.h$a$3 */
        class C73863 implements Runnable {
            C73863() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10500);
                C44818h c44818h;
                if (C24321g.isNullOrNil(C44818h.this.tWZ)) {
                    C44476d.m80483e("Soter.TaskAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                    C7381a.this.onAuthenticationError(-1000, "challenge is null");
                    AppMethodBeat.m2505o(10500);
                } else if (C40997a.dQL() == 1) {
                    c44818h = C44818h.this;
                    try {
                        c44818h.AwG = C40997a.m71094co(C40997a.m71102nB(C7381a.this.AvH));
                        if (c44818h.AwC != null) {
                            c44818h.dRs();
                            AppMethodBeat.m2505o(10500);
                            return;
                        }
                        C44476d.m80484i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                        c44818h.mo70642b(new C16163a(c44818h.AwG));
                        AppMethodBeat.m2505o(10500);
                    } catch (Exception e) {
                        C44476d.m80483e("Soter.TaskAuthentication", "soter: finish sign failed due to exception: %s", e.getMessage());
                        C44476d.m80481a("Soter.TaskAuthentication", e, "soter: sign failed due to exception");
                        c44818h.mo70642b(new C16163a(22, "sign failed even after user authenticated the key."));
                        AppMethodBeat.m2505o(10500);
                    }
                } else {
                    try {
                        C7381a.this.AwM.update(C44818h.this.tWZ.getBytes(Charset.forName("UTF-8")));
                    } catch (SignatureException e2) {
                        C44476d.m80483e("Soter.TaskAuthentication", "soter: exception in update", new Object[0]);
                        C44476d.m80481a("Soter.TaskAuthentication", e2, "soter: exception in update");
                        C44476d.m80483e("Soter.TaskAuthentication", "soter: remove the auth key: %s", C44818h.this.AvS);
                        C40997a.m71093cn(C44818h.this.AvS, false);
                        C44818h.this.mo70642b(new C16163a(30, "update signature failed. authkey removed after this failure, please check"));
                    }
                    try {
                        c44818h = C44818h.this;
                        try {
                            c44818h.AwG = C40997a.m71094co(C7381a.this.AwM.sign());
                            if (c44818h.AwC != null) {
                                c44818h.dRs();
                                AppMethodBeat.m2505o(10500);
                                return;
                            }
                            C44476d.m80484i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                            c44818h.mo70642b(new C16163a(c44818h.AwG));
                            AppMethodBeat.m2505o(10500);
                        } catch (SignatureException e22) {
                            C44476d.m80483e("Soter.TaskAuthentication", "soter: sign failed due to exception: %s", e22.getMessage());
                            C44476d.m80481a("Soter.TaskAuthentication", e22, "soter: sign failed due to exception");
                            c44818h.mo70642b(new C16163a(22, "sign failed even after user authenticated the key."));
                            AppMethodBeat.m2505o(10500);
                        }
                    } catch (Exception e3) {
                        C44476d.m80483e("Soter.TaskAuthentication", "soter: exception in executeWhenAuthenticated method", new Object[0]);
                        C44476d.m80481a("Soter.TaskAuthentication", e3, "soter: exception when execute");
                        C7381a.this.onAuthenticationError(-1000, "execute failed");
                        AppMethodBeat.m2505o(10500);
                    }
                }
            }
        }

        /* renamed from: com.tencent.soter.a.g.h$a$5 */
        class C73875 implements Runnable {
            C73875() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10502);
                if (C44818h.this.AwF != null) {
                    C44818h.this.AwF.onAuthenticationFailed();
                }
                AppMethodBeat.m2505o(10502);
            }
        }

        /* renamed from: com.tencent.soter.a.g.h$a$4 */
        class C73894 implements Runnable {
            C73894() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10501);
                if (C44818h.this.AwF != null) {
                    C44818h.this.AwF.bxM();
                }
                AppMethodBeat.m2505o(10501);
            }
        }

        /* synthetic */ C7381a(C44818h c44818h, Signature signature, byte b) {
            this(signature);
        }

        private C7381a(Signature signature) {
            this.AwM = null;
            this.AwM = signature;
        }

        /* renamed from: ao */
        static String m12631ao(CharSequence charSequence) {
            AppMethodBeat.m2504i(10506);
            String str;
            if (charSequence == null) {
                str = "unknown error";
                AppMethodBeat.m2505o(10506);
                return str;
            }
            str = charSequence.toString();
            AppMethodBeat.m2505o(10506);
            return str;
        }

        public final void onAuthenticationError(final int i, final CharSequence charSequence) {
            AppMethodBeat.m2504i(10507);
            C44476d.m80483e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i), charSequence);
            if (i != 10308) {
                C44472g.dRq().mo70645d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(10498);
                        if (C44818h.this.AwF != null) {
                            C44818h.this.AwF.onAuthenticationError(i, charSequence);
                        }
                        AppMethodBeat.m2505o(10498);
                    }
                });
                C44818h.this.mo70642b(new C16163a(21, C7381a.m12631ao(charSequence)));
            } else {
                C44818h.this.mo70642b(new C16163a(25, C7381a.m12631ao(charSequence)));
            }
            dRt();
            AppMethodBeat.m2505o(10507);
        }

        public final void onAuthenticationHelp(final int i, final CharSequence charSequence) {
            AppMethodBeat.m2504i(10508);
            C44476d.m80486w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i), charSequence);
            C44472g.dRq().mo70645d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10499);
                    if (C44818h.this.AwF != null) {
                        C44818h.this.AwF.onAuthenticationHelp(i, C7381a.m12631ao(charSequence));
                    }
                    AppMethodBeat.m2505o(10499);
                }
            });
            AppMethodBeat.m2505o(10508);
        }

        public final void cvW() {
            AppMethodBeat.m2504i(10509);
            C44476d.m80484i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            C44472g.dRq().mo70644R(new C73863());
            C44472g.dRq().mo70645d(new C73894());
            dRt();
            AppMethodBeat.m2505o(10509);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.m2504i(10510);
            super.onAuthenticationFailed();
            C44476d.m80486w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
            C44472g.dRq().mo70645d(new C73875());
            if (C44818h.this.AwI) {
                C44476d.m80484i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                C44818h.this.AwE.mo64931rr(false);
                C44472g.dRq().mo70644R(new C73857());
                C44472g.dRq().mo70646s(new C73828(), 1000);
            }
            AppMethodBeat.m2505o(10510);
        }

        public final void onAuthenticationCancelled() {
            AppMethodBeat.m2504i(10511);
            C44476d.m80484i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (C44818h.this.AwK) {
                C44476d.m80485v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
                AppMethodBeat.m2505o(10511);
                return;
            }
            super.onAuthenticationCancelled();
            C44472g.dRq().mo70645d(new C73846());
            C44818h.this.mo70642b(new C16163a(24, "user cancelled authentication"));
            dRt();
            AppMethodBeat.m2505o(10511);
        }

        @SuppressLint({"NewApi"})
        private void dRt() {
            AppMethodBeat.m2504i(10512);
            if (C44818h.this.AwJ) {
                C44818h.this.AwE.mo64931rr(false);
                C44818h.this.AwK = true;
            }
            AppMethodBeat.m2505o(10512);
        }
    }

    /* renamed from: com.tencent.soter.a.g.h$3 */
    class C243013 implements Runnable {
        C243013() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10496);
            if (C44818h.this.AwF != null) {
                C44818h.this.AwF.bxL();
            }
            AppMethodBeat.m2505o(10496);
        }
    }

    /* renamed from: com.tencent.soter.a.g.h$4 */
    class C364504 implements C24291b<C40992b> {
        C364504() {
        }

        /* renamed from: dd */
        public final /* synthetic */ void mo40382dd(Object obj) {
            AppMethodBeat.m2504i(10497);
            if (((C40992b) obj).lSP) {
                C44476d.m80484i("Soter.TaskAuthentication", "soter: upload and verify succeed", new Object[0]);
                C44818h.this.mo70642b(new C16163a(C44818h.this.AwG));
                AppMethodBeat.m2505o(10497);
                return;
            }
            C44476d.m80486w("Soter.TaskAuthentication", "soter: upload or verify failed", new Object[0]);
            C44818h.this.mo70642b(new C16163a(23));
            AppMethodBeat.m2505o(10497);
        }
    }

    /* renamed from: com.tencent.soter.a.g.h$1 */
    class C409961 implements C24291b<C24292b> {
        C409961() {
        }

        /* renamed from: dd */
        public final /* synthetic */ void mo40382dd(Object obj) {
            AppMethodBeat.m2504i(10494);
            C24292b c24292b = (C24292b) obj;
            if (C24321g.isNullOrNil(c24292b.msn)) {
                C44476d.m80486w("Soter.TaskAuthentication", "soter: get challenge failed", new Object[0]);
                C44818h.this.mo70642b(new C16163a(19));
                AppMethodBeat.m2505o(10494);
                return;
            }
            C44818h.this.tWZ = c24292b.msn;
            C44818h.this.dRr();
            AppMethodBeat.m2505o(10494);
        }
    }

    /* renamed from: com.tencent.soter.a.g.h$2 */
    class C448192 implements Runnable {
        C448192() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10495);
            if (C44818h.this.AwF != null) {
                C44818h.this.AwF.bxL();
            }
            AppMethodBeat.m2505o(10495);
        }
    }

    public C44818h(C24298b c24298b) {
        boolean z = true;
        AppMethodBeat.m2504i(10513);
        boolean z2 = VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.AwI = z2;
        if (VERSION.SDK_INT >= 23) {
            z = false;
        }
        this.AwJ = z;
        this.AwK = false;
        if (c24298b == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("param is null!");
            AppMethodBeat.m2505o(10513);
            throw illegalArgumentException;
        }
        this.gOW = c24298b.gOW;
        this.AwB = c24298b.Awf;
        this.AwC = c24298b.Awg;
        this.AwD = new WeakReference(c24298b.mContext);
        this.AwF = c24298b.Awi;
        this.AwE = c24298b.mrV;
        this.tWZ = c24298b.tWZ;
        AppMethodBeat.m2505o(10513);
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"DefaultLocale", "NewApi"})
    public final boolean dRl() {
        AppMethodBeat.m2504i(10514);
        if (!C16167a.dRe().isInit()) {
            C44476d.m80486w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
            mo70642b(new C16163a(14));
            AppMethodBeat.m2505o(10514);
            return true;
        } else if (C16167a.dRe().dRc()) {
            Assert.assertTrue(VERSION.SDK_INT >= 16);
            this.AvS = (String) C16167a.dRe().dRg().get(this.gOW, "");
            if (C24321g.isNullOrNil(this.AvS)) {
                C44476d.m80486w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                mo70642b(new C16163a(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.m2505o(10514);
                return true;
            } else if (!C40997a.aua(this.AvS)) {
                C44476d.m80486w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", this.AvS);
                mo70642b(new C16163a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.m2505o(10514);
                return true;
            } else if (this.AwB == null && C24321g.isNullOrNil(this.tWZ)) {
                C44476d.m80486w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                mo70642b(new C16163a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
                AppMethodBeat.m2505o(10514);
                return true;
            } else {
                Context context = (Context) this.AwD.get();
                if (context == null) {
                    C44476d.m80486w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    mo70642b(new C16163a(17));
                    AppMethodBeat.m2505o(10514);
                    return true;
                } else if (!C44473a.m80472iU(context).hasEnrolledFingerprints()) {
                    C44476d.m80486w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
                    mo70642b(new C16163a(18));
                    AppMethodBeat.m2505o(10514);
                    return true;
                } else if (C40997a.m71101iT(context)) {
                    C44476d.m80486w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
                    mo70642b(new C16163a(25, "Too many failed times"));
                    AppMethodBeat.m2505o(10514);
                    return true;
                } else if (this.AwE == null) {
                    C44476d.m80486w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.AwE = new C40987a();
                    AppMethodBeat.m2505o(10514);
                    return false;
                } else {
                    if (this.AwC == null) {
                        C44476d.m80486w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    AppMethodBeat.m2505o(10514);
                    return false;
                }
            }
        } else {
            C44476d.m80486w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
            mo70642b(new C16163a(2));
            AppMethodBeat.m2505o(10514);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
        AppMethodBeat.m2504i(10515);
        if (this.AwE != null) {
            this.AwE.mo64931rr(true);
        }
        AppMethodBeat.m2505o(10515);
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.m2504i(10516);
        if (C24321g.isNullOrNil(this.tWZ)) {
            C44476d.m80484i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.AwB.mo55795bR(new C24294a());
            this.AwB.mo55794a(new C409961());
            this.AwB.execute();
            AppMethodBeat.m2505o(10516);
            return;
        }
        C44476d.m80484i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        dRr();
        AppMethodBeat.m2505o(10516);
    }

    /* Access modifiers changed, original: final */
    public final void dRr() {
        AppMethodBeat.m2504i(10517);
        if (C40997a.dQL() == 1) {
            SoterSessionResult iC = C40997a.m71095iC(this.AvS, this.tWZ);
            if (iC == null) {
                C44476d.m80486w("Soter.TaskAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
                mo70642b(new C16163a(13));
                AppMethodBeat.m2505o(10517);
                return;
            } else if (iC.bFZ != 0) {
                C44476d.m80486w("Soter.TaskAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
                mo70642b(new C16163a(13));
                AppMethodBeat.m2505o(10517);
                return;
            } else {
                C44476d.m80482d("Soter.TaskAuthentication", "soter: session is %d", Long.valueOf(iC.AvH));
                this.AwH = new C7381a(this, null, (byte) 0);
                this.AwH.AvH = iC.AvH;
                mo72023a(null);
                C44472g.dRq().mo70645d(new C448192());
                AppMethodBeat.m2505o(10517);
                return;
            }
        }
        Signature aud = C40997a.aud(this.AvS);
        if (aud == null) {
            C44476d.m80486w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
            mo70642b(new C16163a(13));
            AppMethodBeat.m2505o(10517);
            return;
        }
        this.AwH = new C7381a(this, aud, (byte) 0);
        mo72023a(aud);
        C44472g.dRq().mo70645d(new C243013());
        AppMethodBeat.m2505o(10517);
    }

    /* Access modifiers changed, original: final */
    public final void dRs() {
        AppMethodBeat.m2504i(10519);
        if (this.AwG == null) {
            mo70642b(new C16163a(22, "sign failed even after user authenticated the key."));
            AppMethodBeat.m2505o(10519);
            return;
        }
        this.AwC.mo55795bR(new C40990a(this.AwG.signature, this.AwG.Avx, this.AwG.Avw));
        this.AwC.mo55794a(new C364504());
        this.AwC.execute();
        AppMethodBeat.m2505o(10519);
    }

    public final void dRk() {
        AppMethodBeat.m2504i(10520);
        C44476d.m80484i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.AwH != null) {
            this.AwH.onAuthenticationCancelled();
        }
        AppMethodBeat.m2505o(10520);
    }

    public final boolean isCancelled() {
        return this.AwK;
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public final void mo72023a(Signature signature) {
        AppMethodBeat.m2504i(10518);
        if (this.AvW) {
            C44476d.m80486w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            AppMethodBeat.m2505o(10518);
            return;
        }
        Context context = (Context) this.AwD.get();
        if (context == null) {
            C44476d.m80486w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            mo70642b(new C16163a(17));
            AppMethodBeat.m2505o(10518);
            return;
        }
        try {
            CancellationSignal cancellationSignal;
            C44476d.m80485v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
            C44473a iU = C44473a.m80472iU(context);
            C36452d c36452d = new C36452d(signature);
            if (this.AwE != null) {
                cancellationSignal = this.AwE.zZp;
            } else {
                cancellationSignal = null;
            }
            iU.mo70647a(c36452d, cancellationSignal, this.AwH);
            AppMethodBeat.m2505o(10518);
        } catch (Exception e) {
            String message = e.getMessage();
            C44476d.m80483e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", message);
            C44476d.m80481a("Soter.TaskAuthentication", e, "soter: caused exception when authenticating");
            mo70642b(new C16163a(20, String.format("start authentication failed due to %s", new Object[]{message})));
            AppMethodBeat.m2505o(10518);
        }
    }
}
