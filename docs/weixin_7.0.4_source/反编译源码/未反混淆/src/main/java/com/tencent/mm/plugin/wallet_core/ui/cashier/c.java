package com.tencent.mm.plugin.wallet_core.ui.cashier;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.soter.a.g.f;

public final class c extends i implements LifecycleObserver {
    private ViewGroup ius;
    private ImageView tMG;
    TextView tMH;
    ImageView tMI;
    TextView tMJ;
    a tMK;
    b tML;

    class a {
        public String czZ;
        public l mrm = ((l) g.K(l.class));
        int msy;
        int tJZ;
        lv tMN;

        a() {
            AppMethodBeat.i(47829);
            AppMethodBeat.o(47829);
        }
    }

    public interface b {
        void a(com.tencent.mm.g.a.lv.b bVar);

        void cSr();

        void cSs();

        void cSt();
    }

    public c(Context context) {
        super(context, R.style.zt);
        AppMethodBeat.i(47830);
        init();
        AppMethodBeat.o(47830);
    }

    public c(Context context, int i) {
        super(context, R.style.zt);
        AppMethodBeat.i(47831);
        init();
        AppMethodBeat.o(47831);
    }

    private void init() {
        AppMethodBeat.i(47832);
        initView();
        setContentView(this.ius);
        setCanceledOnTouchOutside(false);
        this.tMK = new a();
        setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(47824);
                if (c.this.tML != null) {
                    c.this.tML.cSs();
                }
                AppMethodBeat.o(47824);
            }
        });
        setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(47825);
                ab.i("MicroMsg.WcPayCashierFingerprintDialog", "dialog dismiss");
                a b = c.this.tMK;
                ab.i("MicroMsg.WcPayCashierFingerprintDialog", "release fingerprint");
                b.mrm.bxk();
                c.this.tML = null;
                AppMethodBeat.o(47825);
            }
        });
        AppMethodBeat.o(47832);
    }

    private void initView() {
        AppMethodBeat.i(47833);
        this.ius = (ViewGroup) View.inflate(getContext(), R.layout.b6w, null);
        this.tMG = (ImageView) this.ius.findViewById(R.id.fiz);
        this.tMH = (TextView) this.ius.findViewById(R.id.fj0);
        this.tMI = (ImageView) this.ius.findViewById(R.id.fj1);
        this.tMJ = (TextView) this.ius.findViewById(R.id.fj2);
        ImageView imageView = this.tMG;
        int i = b.tLO;
        int i2 = b.tLO;
        bo.n(imageView, i, i, i2, i2);
        this.tMG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47826);
                ab.i("MicroMsg.WcPayCashierFingerprintDialog", "click back icon");
                c.this.cancel();
                AppMethodBeat.o(47826);
            }
        });
        AppMethodBeat.o(47833);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(47834);
        super.onCreate(bundle);
        a aVar = this.tMK;
        ab.i("MicroMsg.WcPayCashierFingerprintDialog", "req fingerprint");
        f.dRn().dRo();
        com.tencent.mm.plugin.soter.d.a.cvP();
        aVar.tMN = new lv();
        aVar.tMN.cHD.cBT = aVar.czZ;
        aVar.tMN.cHD.cHF = 1;
        aVar.tMN.cHD.cHH = new Runnable() {
            public final void run() {
                AppMethodBeat.i(47828);
                com.tencent.mm.g.a.lv.b bVar = a.this.tMN.cHE;
                if (bVar == null) {
                    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.o(47828);
                    return;
                }
                int i = bVar.errCode;
                ab.i("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint verify errCode: %d, errMsg: %s", Integer.valueOf(i), bVar.aIm);
                c cVar;
                if (i == 0) {
                    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint success, soterAuthReq: %s", bVar.cHI);
                    cVar = c.this;
                    cVar.tMI.setImageResource(R.raw.cashier_fingerprint_icon);
                    cVar.tMJ.setTextColor(cVar.getContext().getResources().getColor(R.color.rr));
                    cVar.tMH.setVisibility(4);
                    com.tencent.mm.plugin.soter.d.a.EC(0);
                    a.this.tJZ = a.this.tJZ + 1;
                    c.this.dismiss();
                    if (c.this.tML != null) {
                        c.this.tML.a(bVar);
                        AppMethodBeat.o(47828);
                        return;
                    }
                }
                boolean z;
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int i2 = currentTimeMillis - a.this.msy;
                if (i2 > 1) {
                    a.this.msy = currentTimeMillis;
                    a.this.tJZ = a.this.tJZ + 1;
                }
                boolean z2 = i == 2 || i == 10308;
                if (bVar.cHJ == 2) {
                    z = true;
                } else {
                    z = false;
                }
                ab.d("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint not match, shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(a.this.tJZ), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (a.this.tJZ < 3 && i2 > 1)) && !z2) {
                    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint retry: %s", Integer.valueOf(a.this.tJZ));
                    cVar = c.this;
                    cVar.tMI.setImageResource(R.raw.cashier_fingerprint_icon_error);
                    cVar.tMJ.setTextColor(cVar.getContext().getResources().getColor(R.color.ct));
                    cVar.tMH.setVisibility(0);
                    cVar.tMH.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(47827);
                            ab.i("MicroMsg.WcPayCashierFingerprintDialog", "click switch payway");
                            c.this.dismiss();
                            if (c.this.tML != null) {
                                c.this.tML.cSt();
                            }
                            AppMethodBeat.o(47827);
                        }
                    });
                    com.tencent.mm.plugin.soter.d.a.EC(1);
                    AppMethodBeat.o(47828);
                    return;
                } else if (a.this.tJZ >= 3 || z2) {
                    ab.w("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint verify fail!");
                    com.tencent.mm.plugin.soter.d.a.EC(2);
                    c.this.dismiss();
                    if (c.this.tML != null) {
                        c.this.tML.cSr();
                    }
                }
                AppMethodBeat.o(47828);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(aVar.tMN);
        AppMethodBeat.o(47834);
    }

    @OnLifecycleEvent(Event.ON_PAUSE)
    public final void onActivityPause() {
        AppMethodBeat.i(47835);
        ab.i("MicroMsg.WcPayCashierFingerprintDialog", "activity paused, release and dismiss");
        cancel();
        AppMethodBeat.o(47835);
    }

    public final int cSu() {
        return this.tMK == null ? 0 : this.tMK.tJZ;
    }
}
