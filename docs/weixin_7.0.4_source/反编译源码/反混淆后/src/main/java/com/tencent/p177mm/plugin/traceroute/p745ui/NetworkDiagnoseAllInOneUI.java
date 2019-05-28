package com.tencent.p177mm.plugin.traceroute.p745ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p230g.p231a.C6510kr;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI */
public class NetworkDiagnoseAllInOneUI extends MMActivity implements OnClickListener {
    private ImageView cAw;
    private C42206a ecy;
    private Button grC;
    private C7564ap gyS;
    private boolean nPX;
    private C26443d nQL;
    private int sIN;
    private TextView sIO;
    private TextView sIP;
    private TextView sIQ;
    private TextView sIR;
    private C44275p sIS;
    private int sIT;
    private String sIU;
    private C4884c<C6510kr> sIV;
    private boolean sIW;
    private boolean sIX;
    private boolean sIY;

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI$1 */
    class C71651 extends C4884c<C6510kr> {

        /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI$1$1 */
        class C71661 implements Runnable {
            C71661() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25991);
                NetworkDiagnoseAllInOneUI.m78324b(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.m2505o(25991);
            }
        }

        C71651() {
            AppMethodBeat.m2504i(25993);
            this.xxI = C6510kr.class.getName().hashCode();
            AppMethodBeat.m2505o(25993);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            int i;
            boolean z = true;
            AppMethodBeat.m2504i(25994);
            C6510kr c6510kr = (C6510kr) c4883b;
            C4990ab.m7419v("MicroMsg.NetworkDiagnoseAllInOneUI", "diagnose callback, stage:%d, status:%d", Integer.valueOf(c6510kr.cGB.cGC), Integer.valueOf(c6510kr.cGB.status));
            NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI;
            if (c6510kr.cGB.cGC == 0) {
                NetworkDiagnoseAllInOneUI.this.sIT = 33;
                networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                if (c6510kr.cGB.status != 0) {
                    z = false;
                }
                networkDiagnoseAllInOneUI.sIW = z;
            } else if (c6510kr.cGB.cGC == 1) {
                NetworkDiagnoseAllInOneUI.this.sIT = 66;
                networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                if (c6510kr.cGB.status != 0) {
                    z = false;
                }
                networkDiagnoseAllInOneUI.sIX = z;
            } else if (c6510kr.cGB.cGC == 2) {
                networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                if (c6510kr.cGB.status != 0) {
                    z = false;
                }
                networkDiagnoseAllInOneUI.sIY = z;
            }
            int a = NetworkDiagnoseAllInOneUI.this.sIN;
            if (c6510kr.cGB.cGD) {
                NetworkDiagnoseAllInOneUI.this.sIT = 100;
                i = 1000;
                C5004al.m7441d(new C71661());
                NetworkDiagnoseAllInOneUI.this.sIU = c6510kr.cGB.cGE;
                if (NetworkDiagnoseAllInOneUI.this.sIW) {
                    a = 2;
                } else if (NetworkDiagnoseAllInOneUI.this.sIX) {
                    a = 4;
                } else if (NetworkDiagnoseAllInOneUI.this.sIY) {
                    a = 5;
                } else {
                    a = 3;
                }
            } else {
                i = 0;
            }
            C5004al.m7442n(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(25992);
                    NetworkDiagnoseAllInOneUI.this.sIN = a;
                    NetworkDiagnoseAllInOneUI.m78324b(NetworkDiagnoseAllInOneUI.this);
                    AppMethodBeat.m2505o(25992);
                }
            }, (long) i);
            AppMethodBeat.m2505o(25994);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI$2 */
    class C353222 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI$2$1 */
        class C140061 implements Runnable {
            C140061() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25995);
                NetworkDiagnoseAllInOneUI.this.grC.setEnabled(true);
                if (NetworkDiagnoseAllInOneUI.this.sIS != null && NetworkDiagnoseAllInOneUI.this.sIS.isShowing()) {
                    NetworkDiagnoseAllInOneUI.this.sIS.dismiss();
                }
                NetworkDiagnoseAllInOneUI.this.sIN = 6;
                NetworkDiagnoseAllInOneUI.m78324b(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.m2505o(25995);
            }
        }

        /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI$2$2 */
        class C353232 implements DialogInterface.OnClickListener {
            C353232() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(25996);
                C26443d.m42103bX(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.m2505o(25996);
            }
        }

        C353222() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            String str;
            AppMethodBeat.m2504i(25997);
            C4990ab.m7417i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", Boolean.valueOf(z));
            if (NetworkDiagnoseAllInOneUI.this.nQL != null) {
                NetworkDiagnoseAllInOneUI.this.nQL.mo44208c(NetworkDiagnoseAllInOneUI.this.ecy);
            }
            C5004al.m7441d(new C140061());
            NetworkDiagnoseAllInOneUI.this.sIU;
            if (z) {
                str = (String.valueOf(f2) + "-" + String.valueOf(f)) + "," + NetworkDiagnoseAllInOneUI.this.sIU;
            } else {
                if (!(NetworkDiagnoseAllInOneUI.this.nPX || C26443d.agA())) {
                    NetworkDiagnoseAllInOneUI.this.nPX = true;
                    C30379h.m48445a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(C25738R.string.c9z), NetworkDiagnoseAllInOneUI.this.getString(C25738R.string.f9238tz), NetworkDiagnoseAllInOneUI.this.getString(C25738R.string.ckr), NetworkDiagnoseAllInOneUI.this.getString(C25738R.string.f9076or), false, new C353232(), null);
                }
                C4990ab.m7412e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
                str = "," + NetworkDiagnoseAllInOneUI.this.sIU;
            }
            C7060h.pYm.mo8374X(14533, str);
            AppMethodBeat.m2505o(25997);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI$3 */
    class C353243 implements C5015a {
        C353243() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25998);
            NetworkDiagnoseAllInOneUI.this.sIT = NetworkDiagnoseAllInOneUI.this.sIT + 1;
            C4990ab.m7419v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", Integer.valueOf(NetworkDiagnoseAllInOneUI.this.sIT));
            if (NetworkDiagnoseAllInOneUI.this.sIT > 99) {
                AppMethodBeat.m2505o(25998);
                return false;
            }
            if (NetworkDiagnoseAllInOneUI.this.sIN == 1) {
                NetworkDiagnoseAllInOneUI.this.sIQ.setText(NetworkDiagnoseAllInOneUI.this.getString(C25738R.string.b5p, new Object[]{Integer.valueOf(NetworkDiagnoseAllInOneUI.this.sIT)}));
            }
            AppMethodBeat.m2505o(25998);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI$4 */
    class C353254 implements C1835a {
        C353254() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(25999);
            if (c1902e == null) {
                AppMethodBeat.m2505o(25999);
                return;
            }
            try {
                c1902e.adj();
                AppMethodBeat.m2505o(25999);
            } catch (Exception e) {
                AppMethodBeat.m2505o(25999);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI$6 */
    class C353266 implements DialogInterface.OnClickListener {
        C353266() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(26001);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(26001);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI$5 */
    class C400085 implements DialogInterface.OnClickListener {
        C400085() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(26000);
            NetworkDiagnoseAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(26000);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m78324b(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        AppMethodBeat.m2504i(26010);
        networkDiagnoseAllInOneUI.ard();
        AppMethodBeat.m2505o(26010);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26002);
        super.onCreate(bundle);
        overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8293s);
        setMMTitle("");
        getSupportActionBar().hide();
        Intent intent = getIntent();
        this.sIN = intent.getIntExtra("diagnose_state", 0);
        this.sIT = intent.getIntExtra("diagnose_percent", 1);
        this.sIU = intent.getStringExtra("diagnose_kvInfo");
        C4990ab.m7417i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", Integer.valueOf(this.sIN), Integer.valueOf(this.sIT), this.sIU);
        if (this.sIN == 0) {
            this.sIN = 1;
            C4990ab.m7416i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
            C9638aw.m17182Rg().mo14541a(new C6668bk(new C353254()), 0);
        }
        this.grC = (Button) findViewById(2131826325);
        this.sIO = (TextView) findViewById(2131826321);
        this.sIP = (TextView) findViewById(2131826326);
        this.cAw = (ImageView) findViewById(2131826322);
        this.sIQ = (TextView) findViewById(2131826323);
        this.sIR = (TextView) findViewById(2131826324);
        this.sIO.setOnClickListener(this);
        this.grC.setOnClickListener(this);
        this.sIP.setOnClickListener(this);
        ard();
        this.sIV = new C71651();
        C4879a.xxA.mo10051b(this.sIV);
        this.ecy = new C353222();
        this.gyS = new C7564ap(new C353243(), true);
        if (this.sIN == 0 || this.sIN == 1) {
            this.gyS.mo16770ae(1000, 1000);
        }
        AppMethodBeat.m2505o(26002);
    }

    public void finish() {
        AppMethodBeat.m2504i(26003);
        super.finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8373ce);
        AppMethodBeat.m2505o(26003);
    }

    public final int getLayoutId() {
        return 2130970296;
    }

    private void ard() {
        AppMethodBeat.m2504i(26004);
        C4990ab.m7417i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", Integer.valueOf(this.sIN));
        switch (this.sIN) {
            case 0:
            case 1:
                this.cAw.setImageResource(C1318a.network_diagnose_work);
                this.sIQ.setText(getString(C25738R.string.b5p, new Object[]{Integer.valueOf(this.sIT)}));
                this.sIR.setText(C25738R.string.b5h);
                this.grC.setVisibility(4);
                this.sIP.setVisibility(4);
                AppMethodBeat.m2505o(26004);
                return;
            case 2:
                this.cAw.setImageResource(C1318a.network_diagnose_work);
                this.sIQ.setText(C25738R.string.b5t);
                this.sIR.setText(C25738R.string.b5k);
                this.grC.setVisibility(0);
                this.sIP.setVisibility(4);
                AppMethodBeat.m2505o(26004);
                return;
            case 3:
                Intent intent = new Intent();
                intent.putExtra("title", C25738R.string.d5l);
                intent.putExtra("rawUrl", getString(C25738R.string.d5i));
                intent.putExtra("showShare", false);
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                m78338mg(false);
                finish();
                AppMethodBeat.m2505o(26004);
                return;
            case 4:
                this.cAw.setImageResource(C1318a.network_diagnose_fail);
                this.sIQ.setText(C25738R.string.b5s);
                this.sIR.setText(C25738R.string.b5i);
                this.grC.setVisibility(0);
                this.grC.setText(C25738R.string.b5e);
                this.sIP.setVisibility(0);
                AppMethodBeat.m2505o(26004);
                return;
            case 5:
                this.cAw.setImageResource(C1318a.network_diagnose_fail);
                this.sIQ.setText(C25738R.string.b5q);
                this.sIR.setText(C25738R.string.b5i);
                this.grC.setVisibility(0);
                this.grC.setText(C25738R.string.b5e);
                this.sIP.setVisibility(0);
                AppMethodBeat.m2505o(26004);
                return;
            case 6:
                this.cAw.setImageResource(C1318a.network_diagnose_feedback);
                this.sIQ.setText(C25738R.string.b5r);
                this.sIR.setText(C25738R.string.b5j);
                this.grC.setVisibility(0);
                this.grC.setText(C25738R.string.b5d);
                this.sIP.setVisibility(4);
                break;
        }
        AppMethodBeat.m2505o(26004);
    }

    private void beo() {
        AppMethodBeat.m2504i(26005);
        if (this.nQL == null) {
            this.nQL = C26443d.agz();
        }
        this.nQL.mo44204a(this.ecy, true);
        AppMethodBeat.m2505o(26005);
    }

    /* renamed from: mg */
    private void m78338mg(boolean z) {
        AppMethodBeat.m2504i(26006);
        if (C5046bo.isNullOrNil(this.sIU)) {
            AppMethodBeat.m2505o(26006);
            return;
        }
        C4990ab.m7417i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", Boolean.valueOf(z));
        if (z) {
            if (C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", "")) {
                getString(C25738R.string.f9238tz);
                this.sIS = C30379h.m48458b((Context) this, getString(C25738R.string.b5v), true, null);
                this.grC.setEnabled(false);
                beo();
            }
            AppMethodBeat.m2505o(26006);
            return;
        }
        C7060h.pYm.mo8374X(14533, "," + this.sIU);
        AppMethodBeat.m2505o(26006);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(26007);
        if ((this.sIN == 5 || this.sIN == 4) && view == this.grC) {
            m78338mg(true);
            AppMethodBeat.m2505o(26007);
            return;
        }
        m78338mg(false);
        finish();
        AppMethodBeat.m2505o(26007);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26008);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.sIV);
        if (this.nQL != null) {
            this.nQL.mo44208c(this.ecy);
            this.nQL = null;
        }
        if (this.gyS != null) {
            this.gyS.stopTimer();
            this.gyS = null;
        }
        AppMethodBeat.m2505o(26008);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(26009);
        C4990ab.m7417i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 71:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.dbt), false, new C400085(), new C353266());
                    break;
                }
                m78338mg(true);
                AppMethodBeat.m2505o(26009);
                return;
        }
        AppMethodBeat.m2505o(26009);
    }
}
