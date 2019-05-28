package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI extends WalletBaseUI {
    int gOW;
    Button mqV;
    private c mqW;

    static class a extends c {
        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(41376);
            aVar.bwV();
            AppMethodBeat.o(41376);
        }

        public a(WalletFaceIdAuthUI walletFaceIdAuthUI) {
            super(walletFaceIdAuthUI);
            AppMethodBeat.i(41370);
            com.tencent.mm.plugin.soter.d.a.EB(0);
            AppMethodBeat.o(41370);
        }

        public final void onCreate() {
            AppMethodBeat.i(41371);
            this.mrc.getWindow().setDimAmount(0.0f);
            super.onCreate();
            this.mrc.mController.hideTitleView();
            this.mrc.dyb();
            this.mrc.AM(8);
            AppMethodBeat.o(41371);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bwR() {
            AppMethodBeat.i(41372);
            ab.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
            this.mrc.bgj();
            this.mrb.a(this.mrc, new com.tencent.mm.pluginsdk.wallet.a() {
                public final void aC(int i, String str) {
                    AppMethodBeat.i(41368);
                    ab.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", Integer.valueOf(i), str);
                    a.this.mrc.bgk();
                    if (i == 0) {
                        a.this.bwX();
                        AppMethodBeat.o(41368);
                        return;
                    }
                    a.this.mrc.Ml(a.this.mrc.getString(R.string.a96));
                    AppMethodBeat.o(41368);
                }
            }, this.gHr);
            AppMethodBeat.o(41372);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean c(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(41373);
            if (this.mrb.c(i, i2, str, mVar)) {
                AppMethodBeat.o(41373);
                return true;
            } else if (mVar instanceof y) {
                this.mrc.bgk();
                h.a(this.mrc, this.mrc.getString(R.string.bmu), this.mrc.getString(R.string.bmt), this.mrc.getString(R.string.fnj), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(41369);
                        a.a(a.this);
                        AppMethodBeat.o(41369);
                    }
                });
                AppMethodBeat.o(41373);
                return true;
            } else {
                AppMethodBeat.o(41373);
                return false;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void bwS() {
            AppMethodBeat.i(41374);
            bwV();
            AppMethodBeat.o(41374);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bwT() {
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean bwP() {
            return true;
        }

        /* Access modifiers changed, original: protected|final */
        public final int bwU() {
            return 1;
        }

        private void bwV() {
            AppMethodBeat.i(41375);
            ab.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
            this.mrc.finish();
            AppMethodBeat.o(41375);
        }
    }

    public static class b extends c {
        public b(WalletFaceIdAuthUI walletFaceIdAuthUI) {
            super(walletFaceIdAuthUI);
            AppMethodBeat.i(41378);
            com.tencent.mm.plugin.soter.d.a.EB(1);
            AppMethodBeat.o(41378);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bwR() {
            AppMethodBeat.i(41379);
            ab.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
            this.mrc.bgj();
            this.mrb.a(this.mrc, new com.tencent.mm.pluginsdk.wallet.a() {
                public final void aC(int i, String str) {
                    AppMethodBeat.i(41377);
                    ab.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", Integer.valueOf(i), str);
                    b.this.mrc.bgk();
                    if (i == 0) {
                        b.this.mrc.mqV.setEnabled(true);
                        AppMethodBeat.o(41377);
                        return;
                    }
                    b.this.mrc.Ml(b.this.mrc.getString(R.string.a96));
                    AppMethodBeat.o(41377);
                }
            }, this.gHr);
            AppMethodBeat.o(41379);
        }

        public final boolean c(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(41380);
            if (this.mrb.c(i, i2, str, mVar)) {
                AppMethodBeat.o(41380);
                return true;
            } else if (mVar instanceof y) {
                this.mrc.bgk();
                bwW();
                Toast.makeText(this.mrc, R.string.bva, 0).show();
                AppMethodBeat.o(41380);
                return true;
            } else {
                AppMethodBeat.o(41380);
                return false;
            }
        }

        public final void bwT() {
            AppMethodBeat.i(41381);
            ab.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
            bwX();
            AppMethodBeat.o(41381);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean bwP() {
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final int bwU() {
            return 0;
        }

        public final void bwS() {
            AppMethodBeat.i(41382);
            bwW();
            AppMethodBeat.o(41382);
        }

        private void bwW() {
            AppMethodBeat.i(41383);
            ab.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
            com.tencent.mm.wallet_core.a.b(this.mrc, new Bundle(), 0);
            AppMethodBeat.o(41383);
        }
    }

    public static abstract class c {
        protected String gHr;
        protected Bundle hRX;
        protected l mra;
        protected com.tencent.mm.plugin.fingerprint.b.m mrb;
        protected WalletFaceIdAuthUI mrc;

        public abstract boolean bwP();

        public abstract void bwR();

        public abstract void bwS();

        public abstract void bwT();

        public abstract int bwU();

        public abstract boolean c(int i, int i2, String str, m mVar);

        public c(WalletFaceIdAuthUI walletFaceIdAuthUI) {
            Bundle bundle;
            this.mrc = walletFaceIdAuthUI;
            if (walletFaceIdAuthUI.gOW == 0) {
                bundle = walletFaceIdAuthUI.dOD().mqu;
            } else {
                bundle = walletFaceIdAuthUI.getIntent().getExtras();
            }
            this.hRX = bundle;
            this.mrb = new com.tencent.mm.plugin.fingerprint.b.m();
            this.mra = (l) g.K(l.class);
        }

        public void onCreate() {
            boolean z = true;
            if (this.mra == null) {
                ab.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
                this.mrc.Ml(this.mrc.getString(R.string.bms));
                return;
            }
            boolean z2;
            boolean bxA = this.mra.bxA();
            boolean bxB = this.mra.bxB();
            if (q.etg.etr != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!bxA || !bxB || z2 || this.hRX == null) {
                String str = "MicroMsg.WalletFaceIdAuthUI";
                String str2 = "support: %s, enrolled: %s, forceClose: %s, data: %s";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(bxA);
                objArr[1] = Boolean.valueOf(bxB);
                objArr[2] = Boolean.valueOf(z2);
                if (this.hRX != null) {
                    z = false;
                }
                objArr[3] = Boolean.valueOf(z);
                ab.w(str, str2, objArr);
                this.mrc.Ml(this.mrc.getString(R.string.bms));
                return;
            }
            this.gHr = this.hRX.getString("pwd");
            if (bo.isNullOrNil(this.gHr)) {
                ab.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
                this.mrc.Ml(this.mrc.getString(R.string.bms));
                return;
            }
            f.dRn().dRo();
            bwR();
        }

        /* Access modifiers changed, original: protected|final */
        public final void vK(int i) {
            int i2 = 1;
            this.mrc.bgj();
            if (bwU() == 1) {
                i2 = 2;
            }
            this.mrb.a(new com.tencent.mm.pluginsdk.wallet.a() {
                public final void aC(int i, String str) {
                    AppMethodBeat.i(41384);
                    if (i == 0) {
                        ab.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
                        c.this.mrc.a(new y(null, 19), false, false);
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(c.this.bwU() == 1 ? 1 : 2);
                        hVar.e(15817, objArr);
                        com.tencent.mm.plugin.report.service.h.pYm.k(916, 1, 1);
                        AppMethodBeat.o(41384);
                        return;
                    }
                    c.this.mrc.bgk();
                    ab.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
                    c.this.mrc.Ml(c.this.mrc.getString(R.string.bms));
                    com.tencent.mm.plugin.report.service.h.pYm.k(916, 2, 1);
                    AppMethodBeat.o(41384);
                }
            }, String.valueOf(i), i2);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bwX() {
            ab.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
            i iVar = (i) g.K(i.class);
            Bundle bundle = new Bundle();
            bundle.putInt("face_auth_scene", 0);
            iVar.a(this.mrc, new a() {
                public final void ef(int i, int i2) {
                    AppMethodBeat.i(41385);
                    c.this.vK(i);
                    AppMethodBeat.o(41385);
                }

                public final void vJ(int i) {
                    AppMethodBeat.i(41386);
                    c.this.mrc.Ml(c.this.mrc.getString(R.string.bms));
                    AppMethodBeat.o(41386);
                }

                public final void bwO() {
                    AppMethodBeat.i(41387);
                    c.this.mrc.finish();
                    AppMethodBeat.o(41387);
                }
            }, bundle);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41388);
        this.gOW = getIntent().getIntExtra("key_scene", 1);
        ab.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", Integer.valueOf(this.gOW));
        if (this.gOW == 0) {
            this.mqW = new b(this);
        } else if (this.gOW == 1) {
            this.mqW = new a(this);
        }
        super.onCreate(bundle);
        setMMTitle((int) R.string.bmv);
        this.mqW.onCreate();
        initView();
        AppMethodBeat.o(41388);
    }

    public final void initView() {
        AppMethodBeat.i(41389);
        this.mqV = (Button) findViewById(R.id.boo);
        this.mqV.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41366);
                WalletFaceIdAuthUI.this.mqW.bwT();
                AppMethodBeat.o(41366);
            }
        });
        AppMethodBeat.o(41389);
    }

    public final boolean bwP() {
        AppMethodBeat.i(41390);
        boolean bwP = this.mqW.bwP();
        AppMethodBeat.o(41390);
        return bwP;
    }

    public final boolean bwQ() {
        return true;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41391);
        boolean c = this.mqW.c(i, i2, str, mVar);
        AppMethodBeat.o(41391);
        return c;
    }

    public final int getLayoutId() {
        return R.layout.xw;
    }

    public final void Ml(String str) {
        AppMethodBeat.i(41392);
        h.a((Context) this, str, "", getString(R.string.r4), false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(41367);
                WalletFaceIdAuthUI.this.mqW.bwS();
                AppMethodBeat.o(41367);
            }
        });
        AppMethodBeat.o(41392);
    }
}
