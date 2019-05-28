package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.soter.a.g.f;

public final class b extends i implements LifecycleObserver {
    private View jcl;
    TextView kGq;
    FrameAnimatorImageView mre;
    TextView mrf;
    private TextView mrg;
    ViewGroup mrh;
    private ViewGroup mri;
    private a mrj;

    static class a implements OnCancelListener, OnDismissListener, OnShowListener {
        private Bundle fPq;
        b mrl;
        private l mrm;
        private a mrn;
        private int mro;
        boolean mrp = false;
        private c mrq = new c() {
            public final void bJ(int i, int i2) {
                AppMethodBeat.i(41396);
                ab.i("MicroMsg.WalletFaceIdDialog", "auth result: %s, retry: %s", Integer.valueOf(i), Integer.valueOf(a.this.retryCount));
                switch (i) {
                    case 0:
                        ab.i("MicroMsg.WalletFaceIdDialog", "identify success");
                        a.this.mro = i2;
                        a.this.retryCount = a.this.retryCount + 1;
                        a.b(a.this, i2);
                        AppMethodBeat.o(41396);
                        return;
                    case 2000:
                    case 2001:
                    case 2002:
                    case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                    case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                    case 2009:
                    case 10308:
                        a.this.retryCount = a.this.retryCount + 1;
                        if (a.this.retryCount >= 2) {
                            a.c(a.this, i);
                            break;
                        }
                        a.d(a.this);
                        AppMethodBeat.o(41396);
                        return;
                }
                AppMethodBeat.o(41396);
            }
        };
        private int retryCount = 0;
        private int scene;

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(41408);
            aVar.bxb();
            AppMethodBeat.o(41408);
        }

        static /* synthetic */ void e(a aVar) {
            AppMethodBeat.i(41413);
            aVar.vJ(-1);
            AppMethodBeat.o(41413);
        }

        public a(b bVar, a aVar, Bundle bundle) {
            AppMethodBeat.i(41400);
            this.mrl = bVar;
            this.mrn = aVar;
            this.fPq = bundle;
            if (this.fPq != null) {
                this.scene = this.fPq.getInt("face_auth_scene");
            }
            AppMethodBeat.o(41400);
        }

        private void bxb() {
            AppMethodBeat.i(41401);
            this.mrm.bxk();
            AppMethodBeat.o(41401);
        }

        /* Access modifiers changed, original: final */
        public final void bxc() {
            AppMethodBeat.i(41402);
            ab.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
            if (this.mrm == null) {
                ab.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
                AppMethodBeat.o(41402);
                return;
            }
            this.mrm.bxu();
            this.mrm.bxt();
            if (!this.mrm.bxB()) {
                ab.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
                vJ(-2);
                AppMethodBeat.o(41402);
            } else if (bo.isNullOrNil(v.tCn.msn)) {
                ab.i("MicroMsg.WalletFaceIdDialog", "no challenge");
                vJ(-3);
                AppMethodBeat.o(41402);
            } else {
                this.mrm.a(this.mrq);
                this.mrl.bxa();
                AppMethodBeat.o(41402);
            }
        }

        /* Access modifiers changed, original: final */
        public final void vJ(int i) {
            AppMethodBeat.i(41403);
            ab.i("MicroMsg.WalletFaceIdDialog", "auth fail");
            if (this.mrn != null) {
                this.mrn.vJ(i);
                this.mrn = null;
            }
            this.mrl.dismiss();
            AppMethodBeat.o(41403);
        }

        /* Access modifiers changed, original: final */
        public final void bwO() {
            AppMethodBeat.i(41404);
            ab.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
            if (this.mrn != null) {
                this.mrn.bwO();
                this.mrn = null;
            }
            AppMethodBeat.o(41404);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(41405);
            ab.i("MicroMsg.WalletFaceIdDialog", "face id dialog dismiss");
            bxb();
            if (this.scene == 1) {
                bwO();
            }
            AppMethodBeat.o(41405);
        }

        public final void onShow(DialogInterface dialogInterface) {
            AppMethodBeat.i(41406);
            ab.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
            this.mrm = (l) g.K(l.class);
            f.dRn().dRo();
            bxc();
            AppMethodBeat.o(41406);
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(41407);
            ab.d("MicroMsg.WalletFaceIdDialog", "face id dialog cancel");
            bwO();
            AppMethodBeat.o(41407);
        }

        static /* synthetic */ void b(a aVar, final int i) {
            AppMethodBeat.i(41409);
            ab.i("MicroMsg.WalletFaceIdDialog", "auth success");
            if (aVar.retryCount == 0) {
                h.pYm.k(916, 3, 1);
            } else {
                h.pYm.k(916, 4, 1);
            }
            b bVar = aVar.mrl;
            bVar.mre.a(R.drawable.mx, new com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView.a() {
                public final void onStop() {
                    AppMethodBeat.i(41397);
                    a.d(a.this, i);
                    AppMethodBeat.o(41397);
                }
            });
            AppMethodBeat.o(41409);
        }

        static /* synthetic */ void d(a aVar) {
            AppMethodBeat.i(41410);
            aVar.mrl.bwZ();
            aVar.mrl.d(null);
            b bVar = aVar.mrl;
            bVar.mrh.setVisibility(0);
            bVar.mrf.setVisibility(0);
            bVar.kGq.setText(R.string.bmx);
            bVar.mrf.setText(R.string.bmw);
            AppMethodBeat.o(41410);
        }

        static /* synthetic */ void c(a aVar, int i) {
            AppMethodBeat.i(41411);
            ab.w("MicroMsg.WalletFaceIdDialog", "face id failed: %s", Integer.valueOf(aVar.scene));
            aVar.mrl.bwZ();
            h.pYm.k(916, 5, 1);
            aVar.mrp = true;
            if (aVar.scene == 0) {
                aVar.mrl.d(null);
                b bVar = aVar.mrl;
                bVar.kGq.setText(R.string.bmp);
                bVar.mrf.setVisibility(8);
                if (i == 10308) {
                    com.tencent.mm.plugin.soter.d.a.e(6, -1000223, i, "too many trial");
                    AppMethodBeat.o(41411);
                    return;
                }
                com.tencent.mm.plugin.soter.d.a.e(1000, -1000223, i, "fingerprint error");
                AppMethodBeat.o(41411);
                return;
            }
            aVar.mrl.d(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(41398);
                    ab.d("MicroMsg.WalletFaceIdDialog", "fail anim start");
                    AppMethodBeat.o(41398);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(41399);
                    ab.d("MicroMsg.WalletFaceIdDialog", "fail anim end");
                    a.e(a.this);
                    AppMethodBeat.o(41399);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            AppMethodBeat.o(41411);
        }

        static /* synthetic */ void d(a aVar, int i) {
            AppMethodBeat.i(41412);
            if (aVar.mrn != null) {
                aVar.mrn.ef(i, aVar.retryCount);
                aVar.mrn = null;
            }
            aVar.mrl.dismiss();
            AppMethodBeat.o(41412);
        }
    }

    public b(Context context, a aVar) {
        this(context, aVar, null);
    }

    public b(Context context, a aVar, Bundle bundle) {
        this(context);
        AppMethodBeat.i(41414);
        this.mrj = new a(this, aVar, bundle);
        setOnShowListener(this.mrj);
        setOnDismissListener(this.mrj);
        setOnCancelListener(this.mrj);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        AppMethodBeat.o(41414);
    }

    private b(Context context) {
        super(context, R.style.i5);
        AppMethodBeat.i(41415);
        initView();
        AppMethodBeat.o(41415);
    }

    private b(Context context, int i) {
        super(context, R.style.i5);
        AppMethodBeat.i(41416);
        initView();
        AppMethodBeat.o(41416);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(41417);
        super.onCreate(bundle);
        setContentView(this.jcl);
        AppMethodBeat.o(41417);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onStart() {
        AppMethodBeat.i(41418);
        super.onStart();
        AppMethodBeat.o(41418);
    }

    private void initView() {
        AppMethodBeat.i(41419);
        this.jcl = View.inflate(getContext(), R.layout.xv, null);
        this.mri = (ViewGroup) this.jcl.findViewById(R.id.boh);
        this.mre = (FrameAnimatorImageView) this.jcl.findViewById(R.id.boi);
        this.kGq = (TextView) this.jcl.findViewById(R.id.boj);
        this.mrf = (TextView) this.jcl.findViewById(R.id.bom);
        this.mrg = (TextView) this.jcl.findViewById(R.id.bol);
        this.mrh = (ViewGroup) this.jcl.findViewById(R.id.bok);
        bwY();
        this.mrg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41393);
                ab.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
                a a = b.this.mrj;
                ab.i("MicroMsg.WalletFaceIdDialog", "click left btn");
                if (a.mrp) {
                    a.vJ(-1);
                } else {
                    a.bwO();
                }
                b.this.dismiss();
                AppMethodBeat.o(41393);
            }
        });
        this.mrf.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41394);
                ab.d("MicroMsg.WalletFaceIdDialog", "click right btn");
                a a = b.this.mrj;
                ab.i("MicroMsg.WalletFaceIdDialog", "click right btn");
                b bVar = a.mrl;
                bVar.mrf.setEnabled(false);
                bVar.kGq.setText(R.string.bmn);
                a.bxc();
                AppMethodBeat.o(41394);
            }
        });
        AppMethodBeat.o(41419);
    }

    private void bwY() {
        AppMethodBeat.i(41420);
        this.jcl.setBackgroundColor(0);
        this.kGq.setTextColor(Color.parseColor("#888888"));
        AppMethodBeat.o(41420);
    }

    public final void bwZ() {
        AppMethodBeat.i(41421);
        getWindow().setDimAmount(0.5f);
        this.jcl.setBackgroundResource(R.drawable.wz);
        this.mri.setBackground(null);
        this.kGq.setTextColor(Color.parseColor("#111111"));
        this.kGq.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.dz));
        AppMethodBeat.o(41421);
    }

    public final void bxa() {
        AppMethodBeat.i(41422);
        ab.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
        this.mre.a(R.drawable.mz, new com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView.a() {
            public final void onStop() {
                AppMethodBeat.i(41395);
                ab.d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
                b.this.mre.a(R.drawable.mw, null);
                AppMethodBeat.o(41395);
            }
        });
        AppMethodBeat.o(41422);
    }

    public final void d(AnimationListener animationListener) {
        AppMethodBeat.i(41423);
        this.mre.setImageResource(R.drawable.b42);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.aw);
        this.mre.startAnimation(loadAnimation);
        if (animationListener != null) {
            loadAnimation.setAnimationListener(animationListener);
        }
        AppMethodBeat.o(41423);
    }

    @OnLifecycleEvent(Event.ON_STOP)
    public final void onActivityStop() {
        AppMethodBeat.i(41424);
        ab.i("MicroMsg.WalletFaceIdDialog", "activity pause");
        a.a(this.mrj);
        dismiss();
        AppMethodBeat.o(41424);
    }
}
