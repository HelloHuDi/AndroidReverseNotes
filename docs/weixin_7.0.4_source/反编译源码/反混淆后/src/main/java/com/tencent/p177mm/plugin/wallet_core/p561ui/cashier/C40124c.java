package com.tencent.p177mm.plugin.wallet_core.p561ui.cashier;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C18316lv;
import com.tencent.p177mm.p230g.p231a.C18316lv.C18317b;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.p663a.p664g.C40994f;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.c */
public final class C40124c extends C15532i implements LifecycleObserver {
    private ViewGroup ius;
    private ImageView tMG;
    TextView tMH;
    ImageView tMI;
    TextView tMJ;
    C40123a tMK;
    C40125b tML;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.c$1 */
    class C143091 implements OnCancelListener {
        C143091() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(47824);
            if (C40124c.this.tML != null) {
                C40124c.this.tML.cSs();
            }
            AppMethodBeat.m2505o(47824);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.c$2 */
    class C143102 implements OnDismissListener {
        C143102() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(47825);
            C4990ab.m7416i("MicroMsg.WcPayCashierFingerprintDialog", "dialog dismiss");
            C40123a b = C40124c.this.tMK;
            C4990ab.m7416i("MicroMsg.WcPayCashierFingerprintDialog", "release fingerprint");
            b.mrm.bxk();
            C40124c.this.tML = null;
            AppMethodBeat.m2505o(47825);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.c$3 */
    class C143113 implements OnClickListener {
        C143113() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47826);
            C4990ab.m7416i("MicroMsg.WcPayCashierFingerprintDialog", "click back icon");
            C40124c.this.cancel();
            AppMethodBeat.m2505o(47826);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.c$4 */
    class C143124 implements OnClickListener {
        C143124() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47827);
            C4990ab.m7416i("MicroMsg.WcPayCashierFingerprintDialog", "click switch payway");
            C40124c.this.dismiss();
            if (C40124c.this.tML != null) {
                C40124c.this.tML.cSt();
            }
            AppMethodBeat.m2505o(47827);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.c$a */
    class C40123a {
        public String czZ;
        public C30052l mrm = ((C30052l) C1720g.m3528K(C30052l.class));
        int msy;
        int tJZ;
        C18316lv tMN;

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.c$a$1 */
        class C226231 implements Runnable {
            C226231() {
            }

            public final void run() {
                AppMethodBeat.m2504i(47828);
                C18317b c18317b = C40123a.this.tMN.cHE;
                if (c18317b == null) {
                    C4990ab.m7416i("MicroMsg.WcPayCashierFingerprintDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.m2505o(47828);
                    return;
                }
                int i = c18317b.errCode;
                C4990ab.m7417i("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint verify errCode: %d, errMsg: %s", Integer.valueOf(i), c18317b.aIm);
                C40124c c40124c;
                if (i == 0) {
                    C4990ab.m7417i("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint success, soterAuthReq: %s", c18317b.cHI);
                    c40124c = C40124c.this;
                    c40124c.tMI.setImageResource(C1318a.cashier_fingerprint_icon);
                    c40124c.tMJ.setTextColor(c40124c.getContext().getResources().getColor(C25738R.color.f12084rr));
                    c40124c.tMH.setVisibility(4);
                    C46261a.m86636EC(0);
                    C40123a.this.tJZ = C40123a.this.tJZ + 1;
                    C40124c.this.dismiss();
                    if (C40124c.this.tML != null) {
                        C40124c.this.tML.mo9487a(c18317b);
                        AppMethodBeat.m2505o(47828);
                        return;
                    }
                }
                boolean z;
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int i2 = currentTimeMillis - C40123a.this.msy;
                if (i2 > 1) {
                    C40123a.this.msy = currentTimeMillis;
                    C40123a.this.tJZ = C40123a.this.tJZ + 1;
                }
                boolean z2 = i == 2 || i == 10308;
                if (c18317b.cHJ == 2) {
                    z = true;
                } else {
                    z = false;
                }
                C4990ab.m7411d("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint not match, shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(C40123a.this.tJZ), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (C40123a.this.tJZ < 3 && i2 > 1)) && !z2) {
                    C4990ab.m7417i("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint retry: %s", Integer.valueOf(C40123a.this.tJZ));
                    c40124c = C40124c.this;
                    c40124c.tMI.setImageResource(C1318a.cashier_fingerprint_icon_error);
                    c40124c.tMJ.setTextColor(c40124c.getContext().getResources().getColor(C25738R.color.f11671ct));
                    c40124c.tMH.setVisibility(0);
                    c40124c.tMH.setOnClickListener(new C143124());
                    C46261a.m86636EC(1);
                    AppMethodBeat.m2505o(47828);
                    return;
                } else if (C40123a.this.tJZ >= 3 || z2) {
                    C4990ab.m7420w("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint verify fail!");
                    C46261a.m86636EC(2);
                    C40124c.this.dismiss();
                    if (C40124c.this.tML != null) {
                        C40124c.this.tML.cSr();
                    }
                }
                AppMethodBeat.m2505o(47828);
            }
        }

        C40123a() {
            AppMethodBeat.m2504i(47829);
            AppMethodBeat.m2505o(47829);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.c$b */
    public interface C40125b {
        /* renamed from: a */
        void mo9487a(C18317b c18317b);

        void cSr();

        void cSs();

        void cSt();
    }

    public C40124c(Context context) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(47830);
        init();
        AppMethodBeat.m2505o(47830);
    }

    public C40124c(Context context, int i) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(47831);
        init();
        AppMethodBeat.m2505o(47831);
    }

    private void init() {
        AppMethodBeat.m2504i(47832);
        initView();
        setContentView(this.ius);
        setCanceledOnTouchOutside(false);
        this.tMK = new C40123a();
        setOnCancelListener(new C143091());
        setOnDismissListener(new C143102());
        AppMethodBeat.m2505o(47832);
    }

    private void initView() {
        AppMethodBeat.m2504i(47833);
        this.ius = (ViewGroup) View.inflate(getContext(), 2130971196, null);
        this.tMG = (ImageView) this.ius.findViewById(2131829126);
        this.tMH = (TextView) this.ius.findViewById(2131829127);
        this.tMI = (ImageView) this.ius.findViewById(2131829128);
        this.tMJ = (TextView) this.ius.findViewById(2131829129);
        ImageView imageView = this.tMG;
        int i = C4432b.tLO;
        int i2 = C4432b.tLO;
        C5046bo.m7582n(imageView, i, i, i2, i2);
        this.tMG.setOnClickListener(new C143113());
        AppMethodBeat.m2505o(47833);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47834);
        super.onCreate(bundle);
        C40123a c40123a = this.tMK;
        C4990ab.m7416i("MicroMsg.WcPayCashierFingerprintDialog", "req fingerprint");
        C40994f.dRn().dRo();
        C46261a.cvP();
        c40123a.tMN = new C18316lv();
        c40123a.tMN.cHD.cBT = c40123a.czZ;
        c40123a.tMN.cHD.cHF = 1;
        c40123a.tMN.cHD.cHH = new C226231();
        C4879a.xxA.mo10055m(c40123a.tMN);
        AppMethodBeat.m2505o(47834);
    }

    @OnLifecycleEvent(Event.ON_PAUSE)
    public final void onActivityPause() {
        AppMethodBeat.m2504i(47835);
        C4990ab.m7416i("MicroMsg.WcPayCashierFingerprintDialog", "activity paused, release and dismiss");
        cancel();
        AppMethodBeat.m2505o(47835);
    }

    public final int cSu() {
        return this.tMK == null ? 0 : this.tMK.tJZ;
    }
}
