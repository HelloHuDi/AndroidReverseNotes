package com.tencent.p177mm.plugin.fingerprint.faceid.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.fingerprint.p413b.C11927i;
import com.tencent.p177mm.plugin.fingerprint.p413b.C45945m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.wallet.C30157a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.soter.p663a.p664g.C40994f;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI */
public class WalletFaceIdAuthUI extends WalletBaseUI {
    int gOW;
    Button mqV;
    private C28052c mqW;

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$a */
    static class C3123a extends C28052c {

        /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$a$1 */
        class C31241 implements C30157a {
            C31241() {
            }

            /* renamed from: aC */
            public final void mo7375aC(int i, String str) {
                AppMethodBeat.m2504i(41368);
                C4990ab.m7417i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", Integer.valueOf(i), str);
                C3123a.this.mrc.bgk();
                if (i == 0) {
                    C3123a.this.bwX();
                    AppMethodBeat.m2505o(41368);
                    return;
                }
                C3123a.this.mrc.mo45975Ml(C3123a.this.mrc.getString(C25738R.string.a96));
                AppMethodBeat.m2505o(41368);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$a$2 */
        class C31252 implements OnClickListener {
            C31252() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(41369);
                C3123a.m5359a(C3123a.this);
                AppMethodBeat.m2505o(41369);
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m5359a(C3123a c3123a) {
            AppMethodBeat.m2504i(41376);
            c3123a.bwV();
            AppMethodBeat.m2505o(41376);
        }

        public C3123a(WalletFaceIdAuthUI walletFaceIdAuthUI) {
            super(walletFaceIdAuthUI);
            AppMethodBeat.m2504i(41370);
            C46261a.m86635EB(0);
            AppMethodBeat.m2505o(41370);
        }

        public final void onCreate() {
            AppMethodBeat.m2504i(41371);
            this.mrc.getWindow().setDimAmount(0.0f);
            super.onCreate();
            this.mrc.mController.hideTitleView();
            this.mrc.dyb();
            this.mrc.mo9439AM(8);
            AppMethodBeat.m2505o(41371);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bwR() {
            AppMethodBeat.m2504i(41372);
            C4990ab.m7416i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
            this.mrc.bgj();
            this.mrb.mo27383a(this.mrc, new C31241(), this.gHr);
            AppMethodBeat.m2505o(41372);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: c */
        public final boolean mo7373c(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41373);
            if (this.mrb.mo27385c(i, i2, str, c1207m)) {
                AppMethodBeat.m2505o(41373);
                return true;
            } else if (c1207m instanceof C35475y) {
                this.mrc.bgk();
                C30379h.m48447a(this.mrc, this.mrc.getString(C25738R.string.bmu), this.mrc.getString(C25738R.string.bmt), this.mrc.getString(C25738R.string.fnj), false, new C31252());
                AppMethodBeat.m2505o(41373);
                return true;
            } else {
                AppMethodBeat.m2505o(41373);
                return false;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void bwS() {
            AppMethodBeat.m2504i(41374);
            bwV();
            AppMethodBeat.m2505o(41374);
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
            AppMethodBeat.m2504i(41375);
            C4990ab.m7416i("MicroMsg.WalletFaceIdAuthUI", "do finish");
            this.mrc.finish();
            AppMethodBeat.m2505o(41375);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$b */
    public static class C3126b extends C28052c {

        /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$b$1 */
        class C31271 implements C30157a {
            C31271() {
            }

            /* renamed from: aC */
            public final void mo7375aC(int i, String str) {
                AppMethodBeat.m2504i(41377);
                C4990ab.m7417i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", Integer.valueOf(i), str);
                C3126b.this.mrc.bgk();
                if (i == 0) {
                    C3126b.this.mrc.mqV.setEnabled(true);
                    AppMethodBeat.m2505o(41377);
                    return;
                }
                C3126b.this.mrc.mo45975Ml(C3126b.this.mrc.getString(C25738R.string.a96));
                AppMethodBeat.m2505o(41377);
            }
        }

        public C3126b(WalletFaceIdAuthUI walletFaceIdAuthUI) {
            super(walletFaceIdAuthUI);
            AppMethodBeat.m2504i(41378);
            C46261a.m86635EB(1);
            AppMethodBeat.m2505o(41378);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bwR() {
            AppMethodBeat.m2504i(41379);
            C4990ab.m7416i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
            this.mrc.bgj();
            this.mrb.mo27383a(this.mrc, new C31271(), this.gHr);
            AppMethodBeat.m2505o(41379);
        }

        /* renamed from: c */
        public final boolean mo7373c(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41380);
            if (this.mrb.mo27385c(i, i2, str, c1207m)) {
                AppMethodBeat.m2505o(41380);
                return true;
            } else if (c1207m instanceof C35475y) {
                this.mrc.bgk();
                bwW();
                Toast.makeText(this.mrc, C25738R.string.bva, 0).show();
                AppMethodBeat.m2505o(41380);
                return true;
            } else {
                AppMethodBeat.m2505o(41380);
                return false;
            }
        }

        public final void bwT() {
            AppMethodBeat.m2504i(41381);
            C4990ab.m7416i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
            bwX();
            AppMethodBeat.m2505o(41381);
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
            AppMethodBeat.m2504i(41382);
            bwW();
            AppMethodBeat.m2505o(41382);
        }

        private void bwW() {
            AppMethodBeat.m2504i(41383);
            C4990ab.m7416i("MicroMsg.WalletFaceIdAuthUI", "do end process");
            C24143a.m37113b(this.mrc, new Bundle(), 0);
            AppMethodBeat.m2505o(41383);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$c */
    public static abstract class C28052c {
        protected String gHr;
        protected Bundle hRX;
        protected C30052l mra;
        protected C45945m mrb;
        protected WalletFaceIdAuthUI mrc;

        /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$c$1 */
        class C207671 implements C30157a {
            C207671() {
            }

            /* renamed from: aC */
            public final void mo7375aC(int i, String str) {
                AppMethodBeat.m2504i(41384);
                if (i == 0) {
                    C4990ab.m7416i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
                    C28052c.this.mrc.mo39970a(new C35475y(null, 19), false, false);
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(C28052c.this.bwU() == 1 ? 1 : 2);
                    c7060h.mo8381e(15817, objArr);
                    C7060h.pYm.mo15419k(916, 1, 1);
                    AppMethodBeat.m2505o(41384);
                    return;
                }
                C28052c.this.mrc.bgk();
                C4990ab.m7412e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
                C28052c.this.mrc.mo45975Ml(C28052c.this.mrc.getString(C25738R.string.bms));
                C7060h.pYm.mo15419k(916, 2, 1);
                AppMethodBeat.m2505o(41384);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$c$2 */
        class C280512 implements C11932a {
            C280512() {
            }

            /* renamed from: ef */
            public final void mo9481ef(int i, int i2) {
                AppMethodBeat.m2504i(41385);
                C28052c.this.mo45977vK(i);
                AppMethodBeat.m2505o(41385);
            }

            /* renamed from: vJ */
            public final void mo9482vJ(int i) {
                AppMethodBeat.m2504i(41386);
                C28052c.this.mrc.mo45975Ml(C28052c.this.mrc.getString(C25738R.string.bms));
                AppMethodBeat.m2505o(41386);
            }

            public final void bwO() {
                AppMethodBeat.m2504i(41387);
                C28052c.this.mrc.finish();
                AppMethodBeat.m2505o(41387);
            }
        }

        public abstract boolean bwP();

        public abstract void bwR();

        public abstract void bwS();

        public abstract void bwT();

        public abstract int bwU();

        /* renamed from: c */
        public abstract boolean mo7373c(int i, int i2, String str, C1207m c1207m);

        public C28052c(WalletFaceIdAuthUI walletFaceIdAuthUI) {
            Bundle bundle;
            this.mrc = walletFaceIdAuthUI;
            if (walletFaceIdAuthUI.gOW == 0) {
                bundle = walletFaceIdAuthUI.dOD().mqu;
            } else {
                bundle = walletFaceIdAuthUI.getIntent().getExtras();
            }
            this.hRX = bundle;
            this.mrb = new C45945m();
            this.mra = (C30052l) C1720g.m3528K(C30052l.class);
        }

        public void onCreate() {
            boolean z = true;
            if (this.mra == null) {
                C4990ab.m7420w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
                this.mrc.mo45975Ml(this.mrc.getString(C25738R.string.bms));
                return;
            }
            boolean z2;
            boolean bxA = this.mra.bxA();
            boolean bxB = this.mra.bxB();
            if (C1427q.etg.etr != 1) {
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
                C4990ab.m7421w(str, str2, objArr);
                this.mrc.mo45975Ml(this.mrc.getString(C25738R.string.bms));
                return;
            }
            this.gHr = this.hRX.getString("pwd");
            if (C5046bo.isNullOrNil(this.gHr)) {
                C4990ab.m7420w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
                this.mrc.mo45975Ml(this.mrc.getString(C25738R.string.bms));
                return;
            }
            C40994f.dRn().dRo();
            bwR();
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: vK */
        public final void mo45977vK(int i) {
            int i2 = 1;
            this.mrc.bgj();
            if (bwU() == 1) {
                i2 = 2;
            }
            this.mrb.mo27384a(new C207671(), String.valueOf(i), i2);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bwX() {
            C4990ab.m7416i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
            C11927i c11927i = (C11927i) C1720g.m3528K(C11927i.class);
            Bundle bundle = new Bundle();
            bundle.putInt("face_auth_scene", 0);
            c11927i.mo7361a(this.mrc, new C280512(), bundle);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$2 */
    class C280532 implements OnClickListener {
        C280532() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41367);
            WalletFaceIdAuthUI.this.mqW.bwS();
            AppMethodBeat.m2505o(41367);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI$1 */
    class C280541 implements View.OnClickListener {
        C280541() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41366);
            WalletFaceIdAuthUI.this.mqW.bwT();
            AppMethodBeat.m2505o(41366);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41388);
        this.gOW = getIntent().getIntExtra("key_scene", 1);
        C4990ab.m7417i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", Integer.valueOf(this.gOW));
        if (this.gOW == 0) {
            this.mqW = new C3126b(this);
        } else if (this.gOW == 1) {
            this.mqW = new C3123a(this);
        }
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.bmv);
        this.mqW.onCreate();
        initView();
        AppMethodBeat.m2505o(41388);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41389);
        this.mqV = (Button) findViewById(2131823862);
        this.mqV.setOnClickListener(new C280541());
        AppMethodBeat.m2505o(41389);
    }

    public final boolean bwP() {
        AppMethodBeat.m2504i(41390);
        boolean bwP = this.mqW.bwP();
        AppMethodBeat.m2505o(41390);
        return bwP;
    }

    public final boolean bwQ() {
        return true;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41391);
        boolean c = this.mqW.mo7373c(i, i2, str, c1207m);
        AppMethodBeat.m2505o(41391);
        return c;
    }

    public final int getLayoutId() {
        return 2130969488;
    }

    /* renamed from: Ml */
    public final void mo45975Ml(String str) {
        AppMethodBeat.m2504i(41392);
        C30379h.m48447a((Context) this, str, "", getString(C25738R.string.f9151r4), false, new C280532());
        AppMethodBeat.m2505o(41392);
    }
}
