package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.a.b;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationResult;
import com.tencent.soter.core.biometric.BiometricManagerCompat.CryptoObject;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.j;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;
import junit.framework.Assert;

public final class i extends d implements a {
    String AvS = null;
    private c AwB = null;
    f AwC = null;
    private WeakReference<Context> AwD = null;
    j AwG = null;
    boolean AwI;
    boolean AwJ;
    boolean AwK;
    com.tencent.soter.a.a.a AwS = null;
    b AwT = null;
    private a AwU = null;
    int Awh;
    private int gOW = -1;
    String tWZ = null;

    class a extends AuthenticationCallback {
        private long AvH;
        private Signature AwM;

        /* synthetic */ a(i iVar, Signature signature, byte b) {
            this(signature);
        }

        static /* synthetic */ String ap(CharSequence charSequence) {
            AppMethodBeat.i(10540);
            String ao = ao(charSequence);
            AppMethodBeat.o(10540);
            return ao;
        }

        private a(Signature signature) {
            this.AwM = null;
            this.AwM = signature;
        }

        private static String ao(CharSequence charSequence) {
            AppMethodBeat.i(10533);
            String str;
            if (charSequence == null) {
                str = "unknown error";
                AppMethodBeat.o(10533);
                return str;
            }
            str = charSequence.toString();
            AppMethodBeat.o(10533);
            return str;
        }

        public final void onAuthenticationError(final int i, final CharSequence charSequence) {
            AppMethodBeat.i(10534);
            d.e("Soter.TaskBiometricAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i), charSequence);
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10525);
                    if (i.this.AwT != null) {
                        i.this.AwT.onAuthenticationError(i, charSequence);
                    }
                    AppMethodBeat.o(10525);
                }
            });
            if (i == 10308) {
                i.this.b(new com.tencent.soter.a.b.a(25, ao(charSequence)));
            } else {
                i.this.b(new com.tencent.soter.a.b.a(21, ao(charSequence)));
            }
            dRu();
            AppMethodBeat.o(10534);
        }

        public final void onAuthenticationHelp(final int i, final CharSequence charSequence) {
            AppMethodBeat.i(10535);
            d.w("Soter.TaskBiometricAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i), charSequence);
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10526);
                    if (i.this.AwT != null) {
                        i.this.AwT.onAuthenticationHelp(i, a.ap(charSequence));
                    }
                    AppMethodBeat.o(10526);
                }
            });
            AppMethodBeat.o(10535);
        }

        public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
            AppMethodBeat.i(10536);
            d.i("Soter.TaskBiometricAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10527);
                    if (i.this.AwT != null) {
                        i.this.AwT.bxM();
                    }
                    AppMethodBeat.o(10527);
                }
            });
            g.dRq().R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10528);
                    i iVar;
                    if (g.isNullOrNil(i.this.tWZ)) {
                        d.e("Soter.TaskBiometricAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                        a.this.onAuthenticationError(-1000, "challenge is null");
                        AppMethodBeat.o(10528);
                    } else if (com.tencent.soter.core.a.dQL() == 1) {
                        iVar = i.this;
                        a.this.AwM;
                        try {
                            iVar.AwG = com.tencent.soter.core.a.co(com.tencent.soter.core.a.nB(a.this.AvH));
                            if (iVar.AwC != null) {
                                iVar.dRs();
                                AppMethodBeat.o(10528);
                                return;
                            }
                            d.i("Soter.TaskBiometricAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                            iVar.b(new com.tencent.soter.a.b.a(iVar.AwG));
                            AppMethodBeat.o(10528);
                        } catch (Exception e) {
                            d.e("Soter.TaskBiometricAuthentication", "soter: finish sign failed due to exception: %s", e.getMessage());
                            d.a("Soter.TaskBiometricAuthentication", e, "soter: sign failed due to exception");
                            iVar.b(new com.tencent.soter.a.b.a(22, "sign failed even after user authenticated the key."));
                            AppMethodBeat.o(10528);
                        }
                    } else {
                        try {
                            a.this.AwM.update(i.this.tWZ.getBytes(Charset.forName("UTF-8")));
                        } catch (SignatureException e2) {
                            d.e("Soter.TaskBiometricAuthentication", "soter: exception in update", new Object[0]);
                            d.a("Soter.TaskBiometricAuthentication", e2, "soter: exception in update");
                            d.e("Soter.TaskBiometricAuthentication", "soter: remove the auth key: %s", i.this.AvS);
                            com.tencent.soter.core.a.cn(i.this.AvS, false);
                            i.this.b(new com.tencent.soter.a.b.a(30, "update signature failed. authkey removed after this failure, please check"));
                        }
                        try {
                            iVar = i.this;
                            try {
                                iVar.AwG = com.tencent.soter.core.a.co(a.this.AwM.sign());
                                if (iVar.AwC != null) {
                                    iVar.dRs();
                                    AppMethodBeat.o(10528);
                                    return;
                                }
                                d.i("Soter.TaskBiometricAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                                iVar.b(new com.tencent.soter.a.b.a(iVar.AwG));
                                AppMethodBeat.o(10528);
                            } catch (SignatureException e22) {
                                d.e("Soter.TaskBiometricAuthentication", "soter: sign failed due to exception: %s", e22.getMessage());
                                d.a("Soter.TaskBiometricAuthentication", e22, "soter: sign failed due to exception");
                                iVar.b(new com.tencent.soter.a.b.a(22, "sign failed even after user authenticated the key."));
                                AppMethodBeat.o(10528);
                            }
                        } catch (Exception e3) {
                            d.e("Soter.TaskBiometricAuthentication", "soter: exception in executeWhenAuthenticated method", new Object[0]);
                            d.a("Soter.TaskBiometricAuthentication", e3, "soter: exception when execute");
                            a.this.onAuthenticationError(-1000, "execute failed");
                            AppMethodBeat.o(10528);
                        }
                    }
                }
            });
            dRu();
            AppMethodBeat.o(10536);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.i(10537);
            d.w("Soter.TaskBiometricAuthentication", "soter: authentication failed once", new Object[0]);
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10529);
                    if (i.this.AwT != null) {
                        i.this.AwT.onAuthenticationFailed();
                    }
                    AppMethodBeat.o(10529);
                }
            });
            if (i.this.AwI) {
                d.i("Soter.TaskBiometricAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                i.this.AwS.rp(false);
                g.dRq().R(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(10531);
                        i.this.AwS.dRd();
                        AppMethodBeat.o(10531);
                    }
                });
                g.dRq().s(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(10532);
                        i.this.b(a.this.AwM);
                        AppMethodBeat.o(10532);
                    }
                }, 1000);
            }
            if (i.this.Awh == 2) {
                d.i("Soter.TaskBiometricAuthentication", "soter: should compat faceid logic.", new Object[0]);
                i.this.b(new com.tencent.soter.a.b.a(21, "faceid not match"));
            }
            AppMethodBeat.o(10537);
        }

        public final void onAuthenticationCancelled() {
            AppMethodBeat.i(10538);
            d.i("Soter.TaskBiometricAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (i.this.AwK) {
                d.v("Soter.TaskBiometricAuthentication", "soter: during ignore cancel period", new Object[0]);
                AppMethodBeat.o(10538);
                return;
            }
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10530);
                    if (i.this.AwT != null) {
                        i.this.AwT.onAuthenticationCancelled();
                    }
                    AppMethodBeat.o(10530);
                }
            });
            i.this.b(new com.tencent.soter.a.b.a(24, "user cancelled authentication"));
            dRu();
            AppMethodBeat.o(10538);
        }

        @SuppressLint({"NewApi"})
        private void dRu() {
            AppMethodBeat.i(10539);
            if (i.this.AwJ || i.this.Awh == 2) {
                i.this.AwS.rp(false);
                i.this.AwK = true;
            }
            AppMethodBeat.o(10539);
        }
    }

    public i(b bVar) {
        boolean z = true;
        AppMethodBeat.i(10541);
        boolean z2 = VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.AwI = z2;
        if (VERSION.SDK_INT >= 23) {
            z = false;
        }
        this.AwJ = z;
        this.AwK = false;
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("param is null!");
            AppMethodBeat.o(10541);
            throw illegalArgumentException;
        }
        this.gOW = bVar.gOW;
        this.AwB = bVar.Awf;
        this.AwC = bVar.Awg;
        this.AwD = new WeakReference(bVar.mContext);
        this.AwT = bVar.Awj;
        this.AwS = bVar.mrW;
        this.Awh = bVar.Awh;
        this.tWZ = bVar.tWZ;
        AppMethodBeat.o(10541);
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"DefaultLocale", "NewApi"})
    public final boolean dRl() {
        AppMethodBeat.i(10542);
        if (!com.tencent.soter.a.c.a.dRe().isInit()) {
            d.w("Soter.TaskBiometricAuthentication", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.soter.a.b.a(14));
            AppMethodBeat.o(10542);
            return true;
        } else if (com.tencent.soter.a.c.a.dRe().dRc()) {
            Assert.assertTrue(VERSION.SDK_INT >= 16);
            this.AvS = (String) com.tencent.soter.a.c.a.dRe().dRg().get(this.gOW, "");
            if (g.isNullOrNil(this.AvS)) {
                d.w("Soter.TaskBiometricAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.soter.a.b.a(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.o(10542);
                return true;
            } else if (!com.tencent.soter.core.a.aua(this.AvS)) {
                d.w("Soter.TaskBiometricAuthentication", "soter: auth key %s not exists. need re-generate", this.AvS);
                b(new com.tencent.soter.a.b.a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.o(10542);
                return true;
            } else if (this.AwB == null && g.isNullOrNil(this.tWZ)) {
                d.w("Soter.TaskBiometricAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                b(new com.tencent.soter.a.b.a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
                AppMethodBeat.o(10542);
                return true;
            } else {
                Context context = (Context) this.AwD.get();
                if (context == null) {
                    d.w("Soter.TaskBiometricAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    b(new com.tencent.soter.a.b.a(17));
                    AppMethodBeat.o(10542);
                    return true;
                } else if (!BiometricManagerCompat.from(context, Integer.valueOf(this.Awh)).hasEnrolledBiometric()) {
                    d.w("Soter.TaskBiometricAuthentication", "soter: user has not enrolled any biometric in system.", new Object[0]);
                    b(new com.tencent.soter.a.b.a(18));
                    AppMethodBeat.o(10542);
                    return true;
                } else if (com.tencent.soter.core.a.aC(context, this.Awh)) {
                    d.w("Soter.TaskBiometricAuthentication", "soter: biometric sensor frozen", new Object[0]);
                    b(new com.tencent.soter.a.b.a(25, "Too many failed times"));
                    AppMethodBeat.o(10542);
                    return true;
                } else if (this.AwS == null) {
                    d.w("Soter.TaskBiometricAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.AwS = new com.tencent.soter.a.a.a();
                    AppMethodBeat.o(10542);
                    return false;
                } else {
                    if (this.AwC == null) {
                        d.w("Soter.TaskBiometricAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    AppMethodBeat.o(10542);
                    return false;
                }
            }
        } else {
            d.w("Soter.TaskBiometricAuthentication", "soter: not support soter", new Object[0]);
            b(new com.tencent.soter.a.b.a(2));
            AppMethodBeat.o(10542);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
        AppMethodBeat.i(10543);
        if (this.AwS != null) {
            this.AwS.rp(true);
        }
        AppMethodBeat.o(10543);
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.i(10544);
        if (g.isNullOrNil(this.tWZ)) {
            d.i("Soter.TaskBiometricAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.AwB.bR(new com.tencent.soter.a.f.c.a());
            this.AwB.a(new com.tencent.soter.a.f.b<c.b>() {
                public final /* synthetic */ void dd(Object obj) {
                    AppMethodBeat.i(10521);
                    c.b bVar = (c.b) obj;
                    if (g.isNullOrNil(bVar.msn)) {
                        d.w("Soter.TaskBiometricAuthentication", "soter: get challenge failed", new Object[0]);
                        i.this.b(new com.tencent.soter.a.b.a(19));
                        AppMethodBeat.o(10521);
                        return;
                    }
                    i.this.tWZ = bVar.msn;
                    i.this.dRr();
                    AppMethodBeat.o(10521);
                }
            });
            this.AwB.execute();
            AppMethodBeat.o(10544);
            return;
        }
        d.i("Soter.TaskBiometricAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        dRr();
        AppMethodBeat.o(10544);
    }

    /* Access modifiers changed, original: final */
    public final void dRr() {
        AppMethodBeat.i(10545);
        if (com.tencent.soter.core.a.dQL() == 1) {
            SoterSessionResult iC = com.tencent.soter.core.a.iC(this.AvS, this.tWZ);
            if (iC == null) {
                d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
                b(new com.tencent.soter.a.b.a(13));
                AppMethodBeat.o(10545);
                return;
            } else if (iC.bFZ != 0) {
                d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
                b(new com.tencent.soter.a.b.a(13));
                AppMethodBeat.o(10545);
                return;
            } else {
                d.d("Soter.TaskBiometricAuthentication", "soter: session is %d", Long.valueOf(iC.AvH));
                this.AwU = new a(this, null, (byte) 0);
                this.AwU.AvH = iC.AvH;
                b(null);
                g.dRq().d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(10522);
                        if (i.this.AwT != null) {
                            i.this.AwT.bxL();
                        }
                        AppMethodBeat.o(10522);
                    }
                });
                AppMethodBeat.o(10545);
                return;
            }
        }
        Signature aud = com.tencent.soter.core.a.aud(this.AvS);
        if (aud == null) {
            d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign", new Object[0]);
            b(new com.tencent.soter.a.b.a(13));
            AppMethodBeat.o(10545);
            return;
        }
        this.AwU = new a(this, aud, (byte) 0);
        b(aud);
        g.dRq().d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(10523);
                if (i.this.AwT != null) {
                    i.this.AwT.bxL();
                }
                AppMethodBeat.o(10523);
            }
        });
        AppMethodBeat.o(10545);
    }

    /* Access modifiers changed, original: final */
    public final void dRs() {
        AppMethodBeat.i(10547);
        if (this.AwG == null) {
            b(new com.tencent.soter.a.b.a(22, "sign failed even after user authenticated the key."));
            AppMethodBeat.o(10547);
            return;
        }
        this.AwC.bR(new com.tencent.soter.a.f.f.a(this.AwG.signature, this.AwG.Avx, this.AwG.Avw));
        this.AwC.a(new com.tencent.soter.a.f.b<f.b>() {
            public final /* synthetic */ void dd(Object obj) {
                AppMethodBeat.i(10524);
                if (((f.b) obj).lSP) {
                    d.i("Soter.TaskBiometricAuthentication", "soter: upload and verify succeed", new Object[0]);
                    i.this.b(new com.tencent.soter.a.b.a(i.this.AwG));
                    AppMethodBeat.o(10524);
                    return;
                }
                d.w("Soter.TaskBiometricAuthentication", "soter: upload or verify failed", new Object[0]);
                i.this.b(new com.tencent.soter.a.b.a(23));
                AppMethodBeat.o(10524);
            }
        });
        this.AwC.execute();
        AppMethodBeat.o(10547);
    }

    public final void dRk() {
        AppMethodBeat.i(10548);
        d.i("Soter.TaskBiometricAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.AwU != null) {
            this.AwU.onAuthenticationCancelled();
        }
        AppMethodBeat.o(10548);
    }

    public final boolean isCancelled() {
        return this.AwK;
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"NewApi"})
    public final void b(Signature signature) {
        CancellationSignal cancellationSignal = null;
        AppMethodBeat.i(10546);
        if (this.AvW) {
            d.w("Soter.TaskBiometricAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            AppMethodBeat.o(10546);
            return;
        }
        Context context = (Context) this.AwD.get();
        if (context == null) {
            d.w("Soter.TaskBiometricAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            b(new com.tencent.soter.a.b.a(17));
            AppMethodBeat.o(10546);
            return;
        }
        try {
            d.v("Soter.TaskBiometricAuthentication", "soter: performing start", new Object[0]);
            BiometricManagerCompat from = BiometricManagerCompat.from(context, Integer.valueOf(this.Awh));
            CryptoObject cryptoObject = new CryptoObject(signature);
            if (this.AwS != null) {
                cancellationSignal = this.AwS.zZp;
            }
            from.authenticate(cryptoObject, 0, cancellationSignal, this.AwU, null);
            AppMethodBeat.o(10546);
        } catch (Exception e) {
            String message = e.getMessage();
            d.e("Soter.TaskBiometricAuthentication", "soter: caused exception when authenticating: %s", message);
            d.a("Soter.TaskBiometricAuthentication", e, "soter: caused exception when authenticating");
            b(new com.tencent.soter.a.b.a(20, String.format("start authentication failed due to %s", new Object[]{message})));
            AppMethodBeat.o(10546);
        }
    }
}
