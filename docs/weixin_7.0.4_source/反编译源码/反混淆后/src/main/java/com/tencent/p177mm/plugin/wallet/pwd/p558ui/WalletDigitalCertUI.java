package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C42088bj;
import com.tencent.p177mm.p612ui.C24020t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C46355k;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.wallet_core.p649c.C16076aa;
import com.tencent.p177mm.wallet_core.p649c.C24155m;
import com.tencent.p177mm.wallet_core.p649c.C46720ab;
import com.tencent.p177mm.wallet_core.p650ui.C40948d;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI */
public class WalletDigitalCertUI extends WalletBaseUI {
    private Button gzI;
    private ImageView iyo;
    private TextView pNx;
    private Button tro;
    private LinearLayout trp;
    private TextView trq;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI$1 */
    class C225451 extends C40948d {
        C225451() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46251);
            Intent intent = new Intent();
            intent.setClass(WalletDigitalCertUI.this, WalletIdCardCheckUI.class);
            WalletDigitalCertUI.this.startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(46251);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI$2 */
    class C225462 extends C40948d {
        C225462() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46252);
            C46720ab.dNZ();
            WalletDigitalCertUI.this.mo39970a(new C24155m(C46720ab.dNY()), true, true);
            C7060h.pYm.mo8381e(13731, Integer.valueOf(10));
            AppMethodBeat.m2505o(46252);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI$3 */
    class C248913 extends C24020t {
        C248913() {
        }

        /* renamed from: Kp */
        public final void mo39830Kp() {
            AppMethodBeat.m2504i(46253);
            WalletDigitalCertUI.this.finish();
            AppMethodBeat.m2505o(46253);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI$4 */
    class C354604 extends C40948d {
        C354604() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46255);
            if (view.getTag() instanceof C16076aa) {
                final C16076aa c16076aa = (C16076aa) view.getTag();
                C30379h.m48445a(WalletDigitalCertUI.this, WalletDigitalCertUI.this.getString(C25738R.string.fme, new Object[]{c16076aa.xoz}), "", WalletDigitalCertUI.this.getString(C25738R.string.f9088p4), WalletDigitalCertUI.this.getString(C25738R.string.f9076or), true, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46254);
                        C4990ab.m7417i("MicroMsg.WalletDigitalCertUI", "del crt %s", c16076aa.xfz);
                        WalletDigitalCertUI.this.mo39970a(new C24155m(c16076aa.xfz), true, true);
                        C42088bj c42088bj = new C42088bj();
                        c42088bj.cVT = 2;
                        c42088bj.dcm = 1;
                        c42088bj.ajK();
                        AppMethodBeat.m2505o(46254);
                    }
                }, null);
            }
            AppMethodBeat.m2505o(46255);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46256);
        super.onCreate(bundle);
        mo39992nf(1654);
        mo39992nf(1568);
        mo39992nf(1669);
        initView();
        C7060h.pYm.mo8381e(13731, Integer.valueOf(1));
        AppMethodBeat.m2505o(46256);
    }

    public final void initView() {
        AppMethodBeat.m2504i(46257);
        setMMTitle((int) C25738R.string.fmc);
        this.iyo = (ImageView) findViewById(2131828781);
        this.pNx = (TextView) findViewById(2131828782);
        this.tro = (Button) findViewById(2131828786);
        this.gzI = (Button) findViewById(2131828787);
        this.trp = (LinearLayout) findViewById(2131828789);
        this.trq = (TextView) findViewById(2131828788);
        this.tro.setOnClickListener(new C225451());
        this.gzI.setOnClickListener(new C225462());
        setBackBtn(new C248913());
        cOA();
        AppMethodBeat.m2505o(46257);
    }

    private void cOA() {
        AppMethodBeat.m2504i(46258);
        C4990ab.m7416i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
        this.trp.removeAllViews();
        if (C46720ab.dNZ().dOa()) {
            this.tro.setVisibility(8);
            this.gzI.setVisibility(0);
            this.pNx.setText(C25738R.string.fmv);
            this.iyo.setImageResource(C25738R.drawable.bl5);
        } else {
            this.tro.setVisibility(0);
            this.gzI.setVisibility(8);
            this.pNx.setText(C25738R.string.fmf);
            this.iyo.setImageResource(C25738R.drawable.bl6);
        }
        Vector vector = C46720ab.dNZ().Agf;
        if (vector.size() == 0) {
            this.trp.setVisibility(8);
            this.trq.setVisibility(8);
            AppMethodBeat.m2505o(46258);
            return;
        }
        this.trp.setVisibility(0);
        this.trq.setVisibility(0);
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            C16076aa c16076aa = (C16076aa) it.next();
            if (c16076aa.AfZ <= 0) {
                View inflate = View.inflate(this, 2130971078, null);
                TextView textView = (TextView) inflate.findViewById(2131828745);
                TextView textView2 = (TextView) inflate.findViewById(2131828746);
                ((TextView) inflate.findViewById(2131828744)).setText(c16076aa.xoz);
                textView.setText(c16076aa.AfY);
                textView2.setTag(c16076aa);
                textView2.setOnClickListener(new C354604());
                this.trp.addView(inflate);
            }
        }
        if (this.trp.getChildCount() == 0) {
            this.trq.setVisibility(8);
            AppMethodBeat.m2505o(46258);
            return;
        }
        this.trq.setVisibility(0);
        AppMethodBeat.m2505o(46258);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46259);
        super.onResume();
        AppMethodBeat.m2505o(46259);
    }

    public void onPause() {
        AppMethodBeat.m2504i(46260);
        super.onPause();
        AppMethodBeat.m2505o(46260);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46261);
        super.onDestroy();
        mo39993ng(1654);
        mo39993ng(1568);
        mo39993ng(1669);
        AppMethodBeat.m2505o(46261);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46262);
        if (!(c1207m instanceof C46355k)) {
            if (c1207m instanceof C24155m) {
                if (i2 == 0) {
                    C42088bj c42088bj = new C42088bj();
                    c42088bj.cVT = 2;
                    c42088bj.dcm = 2;
                    c42088bj.ajK();
                    C7060h.pYm.mo8381e(13731, Integer.valueOf(11));
                    C46720ab.dNZ().atp(((C24155m) c1207m).Afw);
                } else {
                    C7060h.pYm.mo8381e(13731, Integer.valueOf(12));
                }
            }
            AppMethodBeat.m2505o(46262);
            return false;
        }
        cOA();
        AppMethodBeat.m2505o(46262);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(46263);
        super.onActivityResult(i, i2, intent);
        if (1 == i && i2 == -1) {
            String string;
            String string2;
            boolean bxe = ((C30052l) C1720g.m3528K(C30052l.class)).bxe();
            SharedPreferences doB = C4996ah.doB();
            if (doB != null) {
                string = doB.getString("cpu_id", null);
                string2 = doB.getString("uid", null);
            } else {
                string2 = null;
                string = null;
            }
            C4990ab.m7417i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", Boolean.valueOf(bxe));
            mo39970a(new C46355k(bxe, string, string2), false, false);
        }
        AppMethodBeat.m2505o(46263);
    }

    public final int getLayoutId() {
        return 2130971092;
    }
}
