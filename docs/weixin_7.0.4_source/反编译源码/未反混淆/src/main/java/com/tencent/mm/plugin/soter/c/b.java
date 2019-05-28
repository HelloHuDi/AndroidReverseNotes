package com.tencent.mm.plugin.soter.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.d.a;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public final class b extends c {
    TextView iqw = null;
    Handler mMainHandler = new Handler(Looper.getMainLooper());
    a mrV = null;
    boolean rNN = false;
    android.support.v7.app.b rNO = null;
    ImageView rNP = null;
    private final int rNQ = 3;
    private int rNR = 0;
    private final long rNS = 500;
    Animation rNT = null;
    Animation rNU = null;
    Runnable rNV = new Runnable() {
        public final void run() {
            AppMethodBeat.i(73880);
            b.this.iqw.setTextColor(b.this.iqw.getResources().getColor(R.color.ry));
            b.this.iqw.setText(b.this.iqw.getResources().getString(R.string.erc));
            b.this.rNP.setImageResource(R.drawable.b5z);
            AppMethodBeat.o(73880);
        }
    };

    /* renamed from: com.tencent.mm.plugin.soter.c.b$8 */
    class AnonymousClass8 implements AnimationListener {
        final /* synthetic */ CharSequence tT;

        AnonymousClass8(CharSequence charSequence) {
            this.tT = charSequence;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(73878);
            b.this.rNP.setImageResource(R.drawable.b60);
            b.this.iqw.setText(this.tT);
            b.this.iqw.setTextColor(b.this.iqw.getResources().getColor(R.color.a56));
            b.this.iqw.removeCallbacks(b.this.rNV);
            AppMethodBeat.o(73878);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(73879);
            b.this.iqw.post(b.this.rNV);
            AppMethodBeat.o(73879);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(73890);
        bVar.cvH();
        AppMethodBeat.o(73890);
    }

    public b(WeakReference<Activity> weakReference, j jVar, k kVar, Handler handler) {
        super(weakReference, jVar, kVar, handler);
        AppMethodBeat.i(73881);
        AppMethodBeat.o(73881);
    }

    @TargetApi(23)
    public final void fj() {
        AppMethodBeat.i(73882);
        if (!com.tencent.soter.core.a.iR(ah.getContext())) {
            this.rOb.errCode = 90011;
            this.rOb.aIm = "no fingerprint enrolled";
            cvM();
        }
        try {
            if (ah.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0) {
                G(new String[]{"android.permission.USE_FINGERPRINT"});
                AppMethodBeat.o(73882);
                return;
            }
            this.rNN = true;
            AppMethodBeat.o(73882);
        } catch (NoSuchMethodError e) {
            ab.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
            this.rNN = true;
            AppMethodBeat.o(73882);
        }
    }

    private boolean cvG() {
        AppMethodBeat.i(73883);
        cvI();
        ab.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
        AnonymousClass1 anonymousClass1 = new com.tencent.soter.a.b.b<c>() {
            public final /* synthetic */ void a(e eVar) {
                AppMethodBeat.i(73864);
                c cVar = (c) eVar;
                ab.i("MicroMsg.SoterControllerFingerprint", "hy: update mp auth key result: errcode: %d, errmsg: %s", Integer.valueOf(cVar.errCode), cVar.aIm);
                b.this.cvJ();
                if (cVar.isSuccess()) {
                    b.a(b.this, false);
                    if (b.this.rOe != null) {
                        b.this.rOe.a((i) cVar.AvM);
                    }
                } else {
                    com.tencent.mm.plugin.soter.d.i.fI(2, cVar.errCode);
                }
                if (cVar.errCode == 12) {
                    ab.e("MicroMsg.SoterControllerFingerprint", "hy: model is null");
                    b.this.rOb.errCode = 90007;
                    b.this.rOb.aIm = "auth key can not be retrieved";
                    b.this.cvM();
                    AppMethodBeat.o(73864);
                } else if (cVar.errCode == 5) {
                    ab.v("MicroMsg.SoterControllerFingerprint", "alvinluo: gen auth key failed, remove auth key");
                    com.tencent.soter.a.a.Ri(b.this.gOW);
                    b.this.rOb.errCode = 90007;
                    b.this.rOb.aIm = "auth key generate failed";
                    b.this.cvM();
                    AppMethodBeat.o(73864);
                } else {
                    if (cVar.errCode == 10) {
                        ab.i("MicroMsg.SoterControllerFingerprint", "hy: update auth key failed. remove auth key");
                        com.tencent.soter.a.a.Ri(b.this.gOW);
                        b.this.rOb.errCode = 90007;
                        b.this.rOb.aIm = "auth key update error";
                        b.this.cvM();
                    }
                    AppMethodBeat.o(73864);
                }
            }
        };
        ab.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.gOW);
        com.tencent.soter.a.a.a(anonymousClass1, false, this.gOW, this.rOc, this.rOd);
        AppMethodBeat.o(73883);
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(73884);
        if (i == 0) {
            if (strArr.length <= 0 || iArr.length <= 0 || !"android.permission.USE_FINGERPRINT".equals(strArr[0]) || iArr[0] != 0) {
                ab.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
                this.rOb.errCode = 90002;
                this.rOb.aIm = "user not grant to use fingerprint";
                cvM();
            } else {
                ab.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
                cvG();
                this.rNN = true;
                AppMethodBeat.o(73884);
                return;
            }
        }
        AppMethodBeat.o(73884);
    }

    private void cvH() {
        AppMethodBeat.i(73885);
        this.mrV = new a();
        AnonymousClass3 anonymousClass3 = new com.tencent.soter.a.b.b<com.tencent.soter.a.b.a>() {
            public final /* synthetic */ void a(e eVar) {
                AppMethodBeat.i(73867);
                final com.tencent.soter.a.b.a aVar = (com.tencent.soter.a.b.a) eVar;
                ab.i("MicroMsg.SoterControllerFingerprint", "alvinluo request authentication result errCode: %d, errMsg: %s", Integer.valueOf(aVar.errCode), aVar.aIm);
                b.this.rNN = false;
                if (aVar.isSuccess()) {
                    b.this.mMainHandler.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(73866);
                            com.tencent.soter.core.c.j jVar = (com.tencent.soter.core.c.j) aVar.AvM;
                            b.this.rOb.errCode = 0;
                            b.this.rOb.aIm = "OK";
                            b.this.rOb.rOj = (byte) 1;
                            b.this.rOb.cLO = jVar.Avx;
                            b.this.rOb.rOk = jVar.signature;
                            b.this.cvK();
                            AppMethodBeat.o(73866);
                        }
                    }, 500);
                    AppMethodBeat.o(73867);
                    return;
                }
                com.tencent.mm.plugin.soter.d.i.fI(3, aVar.errCode);
                if (aVar.errCode == 13 || aVar.errCode == 20) {
                    ab.i("MicroMsg.SoterControllerFingerprint", "hy: start authen error, maybe key invalid. remove former key and give suggestion");
                    com.tencent.soter.a.a.Ri(b.this.gOW);
                    b.this.rOb.errCode = 90007;
                    b.this.rOb.aIm = "start fingerprint authen failed";
                } else if (aVar.errCode == 25) {
                    b.this.rOb.errCode = 90010;
                    b.this.rOb.aIm = "authenticate freeze. please try again later";
                } else {
                    b.this.rOb.errCode = 90007;
                    b.this.rOb.aIm = "authenticate error: " + aVar.aIm;
                }
                b.this.cvM();
                AppMethodBeat.o(73867);
            }
        };
        com.tencent.soter.a.d.b anonymousClass4 = new com.tencent.soter.a.d.b() {
            public final void bxL() {
                AppMethodBeat.i(73869);
                ab.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
                b.this.rNN = true;
                AppMethodBeat.o(73869);
            }

            public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                AppMethodBeat.i(73870);
                ab.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", Integer.valueOf(i), charSequence);
                AppMethodBeat.o(73870);
            }

            public final void bxM() {
                AppMethodBeat.i(73871);
                ab.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
                b.this.rNN = false;
                b.this.mrV = null;
                b bVar = b.this;
                bVar.iqw.removeCallbacks(bVar.rNV);
                bVar.rNP.setImageResource(R.drawable.b61);
                bVar.iqw.setTextColor(bVar.iqw.getResources().getColor(R.color.a2e));
                bVar.iqw.setText(bVar.iqw.getResources().getString(R.string.erd));
                AppMethodBeat.o(73871);
            }

            public final void onAuthenticationFailed() {
                AppMethodBeat.i(73872);
                ab.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
                b bVar = b.this;
                String string = ah.getContext().getString(R.string.er_);
                if (bVar.rNT == null) {
                    bVar.rNT = b.eS(bVar.rNP.getContext());
                }
                if (bVar.rNU == null) {
                    bVar.rNU = b.eS(bVar.rNP.getContext());
                }
                bVar.rNT.setAnimationListener(new AnonymousClass8(string));
                bVar.iqw.startAnimation(bVar.rNT);
                bVar.rNP.startAnimation(bVar.rNU);
                b.this.mMainHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(73868);
                        b.this.rNN = false;
                        b.a(b.this, true);
                        AppMethodBeat.o(73868);
                    }
                }, 500);
                AppMethodBeat.o(73872);
            }

            public final void onAuthenticationCancelled() {
                AppMethodBeat.i(73873);
                ab.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
                b.this.mrV = null;
                AppMethodBeat.o(73873);
            }

            public final void onAuthenticationError(int i, CharSequence charSequence) {
                AppMethodBeat.i(73874);
                ab.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", Integer.valueOf(i), charSequence);
                AppMethodBeat.o(73874);
            }
        };
        com.tencent.soter.a.g.b.a aug = new com.tencent.soter.a.g.b.a().Rj(this.gOW).iW(ah.getContext()).a(this.mrV).aug(this.rOa.msn);
        aug.Awk.Awg = null;
        com.tencent.soter.a.a.a(anonymousClass3, aug.a(anonymousClass4).Awk);
        AppMethodBeat.o(73885);
    }

    public final void onResume() {
        AppMethodBeat.i(73886);
        if (this.rNN) {
            cvG();
        }
        AppMethodBeat.o(73886);
    }

    @TargetApi(16)
    public final void onPause() {
        AppMethodBeat.i(73887);
        if (this.rNN && this.mrV != null) {
            this.mrV.rr(true);
        }
        if (this.rNO != null && this.rNO.isShowing()) {
            this.rNO.dismiss();
        }
        AppMethodBeat.o(73887);
    }

    public static Animation eS(Context context) {
        AppMethodBeat.i(73888);
        if (context == null) {
            ab.e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
            AppMethodBeat.o(73888);
            return null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.r);
        if (-1 > 0) {
            loadAnimation.setDuration(-1);
        }
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        AppMethodBeat.o(73888);
        return loadAnimation;
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        AppMethodBeat.i(73889);
        if (bVar.rNO == null || !bVar.rNO.isShowing()) {
            if (bVar.hiC == null || bVar.hiC.get() == null) {
                ab.e("MicroMsg.SoterControllerFingerprint", "hy: ui released.");
                bVar.rOb.errCode = 90007;
                bVar.rOb.aIm = "internal error occurred: ui released";
                bVar.cvM();
            } else {
                if (bVar.rNO == null) {
                    Activity activity = (Activity) bVar.hiC.get();
                    android.support.v7.app.b.a aVar = new android.support.v7.app.b.a(activity);
                    View inflate = activity.getLayoutInflater().inflate(R.layout.b8j, null, false);
                    bVar.rNP = (ImageView) inflate.findViewById(R.id.btn);
                    bVar.iqw = (TextView) inflate.findViewById(R.id.bto);
                    ((TextView) inflate.findViewById(R.id.btm)).setText(bVar.rOa.content);
                    aVar.UA.mView = inflate;
                    aVar.UA.Tl = 0;
                    aVar.UA.Tq = false;
                    aVar.UA.mCancelable = true;
                    AnonymousClass6 anonymousClass6 = new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(73876);
                            ab.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
                            b.this.mrV.rr(true);
                            b.this.cvL();
                            AppMethodBeat.o(73876);
                        }
                    };
                    aVar.UA.TY = aVar.UA.mContext.getText(R.string.eqr);
                    aVar.UA.Ua = anonymousClass6;
                    aVar.UA.Ue = new OnCancelListener() {
                        @TargetApi(16)
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(73877);
                            ab.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
                            b.this.cvL();
                            AppMethodBeat.o(73877);
                        }
                    };
                    bVar.rNO = aVar.fi();
                    bVar.rNO.setOnShowListener(new OnShowListener() {
                        public final void onShow(DialogInterface dialogInterface) {
                            AppMethodBeat.i(73875);
                            b.this.rNO.Uz.Tv.setTextColor(ah.getContext().getResources().getColor(R.color.in));
                            AppMethodBeat.o(73875);
                        }
                    });
                    bVar.a(bVar.rNO);
                    bVar.rNO.setCanceledOnTouchOutside(false);
                }
                if (!bVar.rNO.isShowing()) {
                    bVar.rNO.show();
                }
            }
        }
        if (z) {
            boolean z2;
            if (VERSION.SDK_INT < 23) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                ab.i("MicroMsg.SoterControllerFingerprint", "hy: req restart after fail, but no need");
                AppMethodBeat.o(73889);
                return;
            }
        }
        if (bVar.mrV != null) {
            ab.e("MicroMsg.SoterControllerFingerprint", "alvinluo mFingerprintCanceller not null, cancel and start auth by delaying 500ms.");
            bVar.mrV.rr(true);
            bVar.mMainHandler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(73865);
                    b.this.mrV = new a();
                    b.a(b.this);
                    AppMethodBeat.o(73865);
                }
            }, 500);
            AppMethodBeat.o(73889);
            return;
        }
        bVar.cvH();
        AppMethodBeat.o(73889);
    }
}
