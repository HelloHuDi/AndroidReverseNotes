package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.d.b;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.j;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;
import junit.framework.Assert;

public final class h extends d implements a {
    String AvS = null;
    private c AwB = null;
    f AwC = null;
    private WeakReference<Context> AwD = null;
    com.tencent.soter.a.d.a AwE = null;
    b AwF = null;
    j AwG = null;
    private a AwH = null;
    boolean AwI;
    boolean AwJ;
    boolean AwK;
    private int gOW = -1;
    String tWZ = null;

    class a extends com.tencent.soter.core.a.a.b {
        long AvH;
        Signature AwM;

        /* synthetic */ a(h hVar, Signature signature, byte b) {
            this(signature);
        }

        private a(Signature signature) {
            this.AwM = null;
            this.AwM = signature;
        }

        static String ao(CharSequence charSequence) {
            AppMethodBeat.i(10506);
            String str;
            if (charSequence == null) {
                str = "unknown error";
                AppMethodBeat.o(10506);
                return str;
            }
            str = charSequence.toString();
            AppMethodBeat.o(10506);
            return str;
        }

        public final void onAuthenticationError(final int i, final CharSequence charSequence) {
            AppMethodBeat.i(10507);
            d.e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i), charSequence);
            if (i != 10308) {
                g.dRq().d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(10498);
                        if (h.this.AwF != null) {
                            h.this.AwF.onAuthenticationError(i, charSequence);
                        }
                        AppMethodBeat.o(10498);
                    }
                });
                h.this.b(new com.tencent.soter.a.b.a(21, ao(charSequence)));
            } else {
                h.this.b(new com.tencent.soter.a.b.a(25, ao(charSequence)));
            }
            dRt();
            AppMethodBeat.o(10507);
        }

        public final void onAuthenticationHelp(final int i, final CharSequence charSequence) {
            AppMethodBeat.i(10508);
            d.w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i), charSequence);
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10499);
                    if (h.this.AwF != null) {
                        h.this.AwF.onAuthenticationHelp(i, a.ao(charSequence));
                    }
                    AppMethodBeat.o(10499);
                }
            });
            AppMethodBeat.o(10508);
        }

        public final void cvW() {
            AppMethodBeat.i(10509);
            d.i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            g.dRq().R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10500);
                    h hVar;
                    if (g.isNullOrNil(h.this.tWZ)) {
                        d.e("Soter.TaskAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                        a.this.onAuthenticationError(-1000, "challenge is null");
                        AppMethodBeat.o(10500);
                    } else if (com.tencent.soter.core.a.dQL() == 1) {
                        hVar = h.this;
                        try {
                            hVar.AwG = com.tencent.soter.core.a.co(com.tencent.soter.core.a.nB(a.this.AvH));
                            if (hVar.AwC != null) {
                                hVar.dRs();
                                AppMethodBeat.o(10500);
                                return;
                            }
                            d.i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                            hVar.b(new com.tencent.soter.a.b.a(hVar.AwG));
                            AppMethodBeat.o(10500);
                        } catch (Exception e) {
                            d.e("Soter.TaskAuthentication", "soter: finish sign failed due to exception: %s", e.getMessage());
                            d.a("Soter.TaskAuthentication", e, "soter: sign failed due to exception");
                            hVar.b(new com.tencent.soter.a.b.a(22, "sign failed even after user authenticated the key."));
                            AppMethodBeat.o(10500);
                        }
                    } else {
                        try {
                            a.this.AwM.update(h.this.tWZ.getBytes(Charset.forName("UTF-8")));
                        } catch (SignatureException e2) {
                            d.e("Soter.TaskAuthentication", "soter: exception in update", new Object[0]);
                            d.a("Soter.TaskAuthentication", e2, "soter: exception in update");
                            d.e("Soter.TaskAuthentication", "soter: remove the auth key: %s", h.this.AvS);
                            com.tencent.soter.core.a.cn(h.this.AvS, false);
                            h.this.b(new com.tencent.soter.a.b.a(30, "update signature failed. authkey removed after this failure, please check"));
                        }
                        try {
                            hVar = h.this;
                            try {
                                hVar.AwG = com.tencent.soter.core.a.co(a.this.AwM.sign());
                                if (hVar.AwC != null) {
                                    hVar.dRs();
                                    AppMethodBeat.o(10500);
                                    return;
                                }
                                d.i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                                hVar.b(new com.tencent.soter.a.b.a(hVar.AwG));
                                AppMethodBeat.o(10500);
                            } catch (SignatureException e22) {
                                d.e("Soter.TaskAuthentication", "soter: sign failed due to exception: %s", e22.getMessage());
                                d.a("Soter.TaskAuthentication", e22, "soter: sign failed due to exception");
                                hVar.b(new com.tencent.soter.a.b.a(22, "sign failed even after user authenticated the key."));
                                AppMethodBeat.o(10500);
                            }
                        } catch (Exception e3) {
                            d.e("Soter.TaskAuthentication", "soter: exception in executeWhenAuthenticated method", new Object[0]);
                            d.a("Soter.TaskAuthentication", e3, "soter: exception when execute");
                            a.this.onAuthenticationError(-1000, "execute failed");
                            AppMethodBeat.o(10500);
                        }
                    }
                }
            });
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10501);
                    if (h.this.AwF != null) {
                        h.this.AwF.bxM();
                    }
                    AppMethodBeat.o(10501);
                }
            });
            dRt();
            AppMethodBeat.o(10509);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.i(10510);
            super.onAuthenticationFailed();
            d.w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10502);
                    if (h.this.AwF != null) {
                        h.this.AwF.onAuthenticationFailed();
                    }
                    AppMethodBeat.o(10502);
                }
            });
            if (h.this.AwI) {
                d.i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                h.this.AwE.rr(false);
                g.dRq().R(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(10504);
                        h.this.AwE.dRd();
                        AppMethodBeat.o(10504);
                    }
                });
                g.dRq().s(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(10505);
                        h.this.a(a.this.AwM);
                        AppMethodBeat.o(10505);
                    }
                }, 1000);
            }
            AppMethodBeat.o(10510);
        }

        public final void onAuthenticationCancelled() {
            AppMethodBeat.i(10511);
            d.i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (h.this.AwK) {
                d.v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
                AppMethodBeat.o(10511);
                return;
            }
            super.onAuthenticationCancelled();
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10503);
                    if (h.this.AwF != null) {
                        h.this.AwF.onAuthenticationCancelled();
                    }
                    AppMethodBeat.o(10503);
                }
            });
            h.this.b(new com.tencent.soter.a.b.a(24, "user cancelled authentication"));
            dRt();
            AppMethodBeat.o(10511);
        }

        @SuppressLint({"NewApi"})
        private void dRt() {
            AppMethodBeat.i(10512);
            if (h.this.AwJ) {
                h.this.AwE.rr(false);
                h.this.AwK = true;
            }
            AppMethodBeat.o(10512);
        }
    }

    public h(b bVar) {
        boolean z = true;
        AppMethodBeat.i(10513);
        boolean z2 = VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.AwI = z2;
        if (VERSION.SDK_INT >= 23) {
            z = false;
        }
        this.AwJ = z;
        this.AwK = false;
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("param is null!");
            AppMethodBeat.o(10513);
            throw illegalArgumentException;
        }
        this.gOW = bVar.gOW;
        this.AwB = bVar.Awf;
        this.AwC = bVar.Awg;
        this.AwD = new WeakReference(bVar.mContext);
        this.AwF = bVar.Awi;
        this.AwE = bVar.mrV;
        this.tWZ = bVar.tWZ;
        AppMethodBeat.o(10513);
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"DefaultLocale", "NewApi"})
    public final boolean dRl() {
        AppMethodBeat.i(10514);
        if (!com.tencent.soter.a.c.a.dRe().isInit()) {
            d.w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.soter.a.b.a(14));
            AppMethodBeat.o(10514);
            return true;
        } else if (com.tencent.soter.a.c.a.dRe().dRc()) {
            Assert.assertTrue(VERSION.SDK_INT >= 16);
            this.AvS = (String) com.tencent.soter.a.c.a.dRe().dRg().get(this.gOW, "");
            if (g.isNullOrNil(this.AvS)) {
                d.w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.soter.a.b.a(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.o(10514);
                return true;
            } else if (!com.tencent.soter.core.a.aua(this.AvS)) {
                d.w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", this.AvS);
                b(new com.tencent.soter.a.b.a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.o(10514);
                return true;
            } else if (this.AwB == null && g.isNullOrNil(this.tWZ)) {
                d.w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                b(new com.tencent.soter.a.b.a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
                AppMethodBeat.o(10514);
                return true;
            } else {
                Context context = (Context) this.AwD.get();
                if (context == null) {
                    d.w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    b(new com.tencent.soter.a.b.a(17));
                    AppMethodBeat.o(10514);
                    return true;
                } else if (!com.tencent.soter.core.a.a.iU(context).hasEnrolledFingerprints()) {
                    d.w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
                    b(new com.tencent.soter.a.b.a(18));
                    AppMethodBeat.o(10514);
                    return true;
                } else if (com.tencent.soter.core.a.iT(context)) {
                    d.w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
                    b(new com.tencent.soter.a.b.a(25, "Too many failed times"));
                    AppMethodBeat.o(10514);
                    return true;
                } else if (this.AwE == null) {
                    d.w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.AwE = new com.tencent.soter.a.d.a();
                    AppMethodBeat.o(10514);
                    return false;
                } else {
                    if (this.AwC == null) {
                        d.w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    AppMethodBeat.o(10514);
                    return false;
                }
            }
        } else {
            d.w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
            b(new com.tencent.soter.a.b.a(2));
            AppMethodBeat.o(10514);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
        AppMethodBeat.i(10515);
        if (this.AwE != null) {
            this.AwE.rr(true);
        }
        AppMethodBeat.o(10515);
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.i(10516);
        if (g.isNullOrNil(this.tWZ)) {
            d.i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.AwB.bR(new com.tencent.soter.a.f.c.a());
            this.AwB.a(new com.tencent.soter.a.f.b<c.b>() {
                public final /* synthetic */ void dd(Object obj) {
                    AppMethodBeat.i(10494);
                    c.b bVar = (c.b) obj;
                    if (g.isNullOrNil(bVar.msn)) {
                        d.w("Soter.TaskAuthentication", "soter: get challenge failed", new Object[0]);
                        h.this.b(new com.tencent.soter.a.b.a(19));
                        AppMethodBeat.o(10494);
                        return;
                    }
                    h.this.tWZ = bVar.msn;
                    h.this.dRr();
                    AppMethodBeat.o(10494);
                }
            });
            this.AwB.execute();
            AppMethodBeat.o(10516);
            return;
        }
        d.i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        dRr();
        AppMethodBeat.o(10516);
    }

    /* Access modifiers changed, original: final */
    public final void dRr() {
        AppMethodBeat.i(10517);
        if (com.tencent.soter.core.a.dQL() == 1) {
            SoterSessionResult iC = com.tencent.soter.core.a.iC(this.AvS, this.tWZ);
            if (iC == null) {
                d.w("Soter.TaskAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
                b(new com.tencent.soter.a.b.a(13));
                AppMethodBeat.o(10517);
                return;
            } else if (iC.bFZ != 0) {
                d.w("Soter.TaskAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
                b(new com.tencent.soter.a.b.a(13));
                AppMethodBeat.o(10517);
                return;
            } else {
                d.d("Soter.TaskAuthentication", "soter: session is %d", Long.valueOf(iC.AvH));
                this.AwH = new a(this, null, (byte) 0);
                this.AwH.AvH = iC.AvH;
                a(null);
                g.dRq().d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(10495);
                        if (h.this.AwF != null) {
                            h.this.AwF.bxL();
                        }
                        AppMethodBeat.o(10495);
                    }
                });
                AppMethodBeat.o(10517);
                return;
            }
        }
        Signature aud = com.tencent.soter.core.a.aud(this.AvS);
        if (aud == null) {
            d.w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
            b(new com.tencent.soter.a.b.a(13));
            AppMethodBeat.o(10517);
            return;
        }
        this.AwH = new a(this, aud, (byte) 0);
        a(aud);
        g.dRq().d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(10496);
                if (h.this.AwF != null) {
                    h.this.AwF.bxL();
                }
                AppMethodBeat.o(10496);
            }
        });
        AppMethodBeat.o(10517);
    }

    /* Access modifiers changed, original: final */
    public final void dRs() {
        AppMethodBeat.i(10519);
        if (this.AwG == null) {
            b(new com.tencent.soter.a.b.a(22, "sign failed even after user authenticated the key."));
            AppMethodBeat.o(10519);
            return;
        }
        this.AwC.bR(new com.tencent.soter.a.f.f.a(this.AwG.signature, this.AwG.Avx, this.AwG.Avw));
        this.AwC.a(new com.tencent.soter.a.f.b<f.b>() {
            public final /* synthetic */ void dd(Object obj) {
                AppMethodBeat.i(10497);
                if (((f.b) obj).lSP) {
                    d.i("Soter.TaskAuthentication", "soter: upload and verify succeed", new Object[0]);
                    h.this.b(new com.tencent.soter.a.b.a(h.this.AwG));
                    AppMethodBeat.o(10497);
                    return;
                }
                d.w("Soter.TaskAuthentication", "soter: upload or verify failed", new Object[0]);
                h.this.b(new com.tencent.soter.a.b.a(23));
                AppMethodBeat.o(10497);
            }
        });
        this.AwC.execute();
        AppMethodBeat.o(10519);
    }

    public final void dRk() {
        AppMethodBeat.i(10520);
        d.i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.AwH != null) {
            this.AwH.onAuthenticationCancelled();
        }
        AppMethodBeat.o(10520);
    }

    public final boolean isCancelled() {
        return this.AwK;
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"NewApi"})
    public final void a(Signature signature) {
        AppMethodBeat.i(10518);
        if (this.AvW) {
            d.w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            AppMethodBeat.o(10518);
            return;
        }
        Context context = (Context) this.AwD.get();
        if (context == null) {
            d.w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            b(new com.tencent.soter.a.b.a(17));
            AppMethodBeat.o(10518);
            return;
        }
        try {
            CancellationSignal cancellationSignal;
            d.v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
            com.tencent.soter.core.a.a iU = com.tencent.soter.core.a.a.iU(context);
            com.tencent.soter.core.a.a.d dVar = new com.tencent.soter.core.a.a.d(signature);
            if (this.AwE != null) {
                cancellationSignal = this.AwE.zZp;
            } else {
                cancellationSignal = null;
            }
            iU.a(dVar, cancellationSignal, this.AwH);
            AppMethodBeat.o(10518);
        } catch (Exception e) {
            String message = e.getMessage();
            d.e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", message);
            d.a("Soter.TaskAuthentication", e, "soter: caused exception when authenticating");
            b(new com.tencent.soter.a.b.a(20, String.format("start authentication failed due to %s", new Object[]{message})));
            AppMethodBeat.o(10518);
        }
    }
}
