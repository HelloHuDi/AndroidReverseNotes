package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26263vo;
import com.tencent.p177mm.p230g.p231a.C37719fw;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.remittance.model.C3723z;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceOSUI */
public class RemittanceOSUI extends RemittanceBaseUI implements C8915a {
    private C4884c omX = new C216621();
    private int pWq;
    private String pWr;
    private String pWs;
    private String pWt;
    private String pWu;
    private boolean pWv = false;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceOSUI$1 */
    class C216621 extends C4884c<C26263vo> {
        C216621() {
            AppMethodBeat.m2504i(45091);
            this.xxI = C26263vo.class.getName().hashCode();
            AppMethodBeat.m2505o(45091);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(45092);
            if (RemittanceOSUI.this.pWv) {
                RemittanceOSUI.this.finish();
            }
            AppMethodBeat.m2505o(45092);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RemittanceOSUI() {
        AppMethodBeat.m2504i(45097);
        AppMethodBeat.m2505o(45097);
    }

    public final void cfz() {
    }

    public final void cfB() {
        AppMethodBeat.m2504i(45098);
        C7060h.pYm.mo8381e(13337, Integer.valueOf(2));
        AppMethodBeat.m2505o(45098);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45100);
        super.onCreate(bundle);
        C4879a.xxA.mo10051b(this.omX);
        this.Ahr.mo49372nf(1622);
        this.Ahr.mo49372nf(1574);
        initView();
        this.kGa.setTitleText("");
        C17884o.acd().mo67498a((C8915a) this);
        this.pWq = getIntent().getIntExtra("os_currency", 0);
        this.pWr = getIntent().getStringExtra("os_currencyuint");
        this.pWs = getIntent().getStringExtra("os_currencywording");
        this.pWt = getIntent().getStringExtra("os_notice");
        this.pWu = getIntent().getStringExtra("os_notice_url");
        this.kGa.setTitleText(this.pWr);
        cfG();
        AppMethodBeat.m2505o(45100);
    }

    /* renamed from: a */
    public final void mo37144a(String str, int i, String str2, String str3, String str4, String str5, String str6, C37719fw c37719fw) {
        AppMethodBeat.m2504i(45101);
        String YB = C1853r.m3820YB();
        if (C5046bo.isNullOrNil(YB)) {
            YB = C1853r.m3846Yz();
        }
        C1720g.m3537RQ();
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.edV);
        String str7 = this.edV;
        if (((int) aoO.ewQ) != 0) {
            str7 = aoO.mo16707Oj();
        }
        C1207m c3723z = new C3723z(this.pQV, YB, this.edV, str7, str, this.pWq);
        c3723z.eHT = "RemittanceProcess";
        mo39970a(c3723z, true, true);
        C7060h.pYm.mo8381e(13337, Integer.valueOf(1), Double.valueOf(this.pQV));
        AppMethodBeat.m2505o(45101);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: VV */
    public final void mo55436VV(String str) {
        AppMethodBeat.m2504i(45102);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        C25985d.m41468b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.pWv = true;
        AppMethodBeat.m2505o(45102);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: VW */
    public final void mo55437VW(String str) {
        AppMethodBeat.m2504i(45103);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        C25985d.m41468b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.pWv = true;
        AppMethodBeat.m2505o(45103);
    }

    public final void cfG() {
        AppMethodBeat.m2504i(45104);
        if (C5046bo.isNullOrNil(this.pWt)) {
            C4990ab.m7416i("MicroMsg.RemittanceOSUI", "no bulletin data");
            AppMethodBeat.m2505o(45104);
            return;
        }
        C36391e.m59985a((TextView) findViewById(2131821634), "", this.pWt, this.pWu);
        AppMethodBeat.m2505o(45104);
    }

    public void onResume() {
        AppMethodBeat.m2504i(45105);
        super.onResume();
        AppMethodBeat.m2505o(45105);
    }

    public void onPause() {
        AppMethodBeat.m2504i(45106);
        super.onPause();
        AppMethodBeat.m2505o(45106);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45107);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.omX);
        C17884o.acd().mo67500b(this);
        this.Ahr.mo49373ng(1622);
        this.Ahr.mo49373ng(1574);
        AppMethodBeat.m2505o(45107);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45108);
        C4990ab.m7410d("MicroMsg.RemittanceOSUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.edV);
        this.pWv = false;
        if (i == 3 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(45108);
    }

    public final int getLayoutId() {
        return 2130970514;
    }

    /* renamed from: b */
    public final void mo24300b(int i, int i2, String str, C1207m c1207m, boolean z) {
        AppMethodBeat.m2504i(45109);
        super.mo24300b(i, i2, str, c1207m, z);
        if (i == 0 && i2 == 0 && (c1207m instanceof C3723z)) {
            int i3;
            final C3723z c3723z = (C3723z) c1207m;
            if (c3723z.pPl <= 0) {
                i3 = 0;
            } else if (c3723z.pQB == 0) {
                C30379h.m48466d(this, getString(C25738R.string.dq2, new Object[]{Integer.valueOf(c3723z.pPl)}), getString(C25738R.string.f9213t6), getString(C25738R.string.do6), getString(C25738R.string.dpq), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(45093);
                        RemittanceOSUI.this.mo55436VV(c3723z.pPf);
                        AppMethodBeat.m2505o(45093);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(45094);
                        RemittanceOSUI.this.mo55437VW(c3723z.pQA);
                        AppMethodBeat.m2505o(45094);
                    }
                });
                i3 = 1;
            } else if (c3723z.pQB == 1) {
                C30379h.m48466d(this, getString(C25738R.string.dq2, new Object[]{Integer.valueOf(c3723z.pPl)}), getString(C25738R.string.f9213t6), getString(C25738R.string.do6), getString(C25738R.string.dpq), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(45095);
                        RemittanceOSUI.this.mo55436VV(c3723z.pPf);
                        AppMethodBeat.m2505o(45095);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(45096);
                        RemittanceOSUI.this.mo55437VW(c3723z.pQA);
                        AppMethodBeat.m2505o(45096);
                    }
                });
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                String str2 = ((C3723z) c1207m).pPf;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                C25985d.m41468b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 3);
            }
        }
        AppMethodBeat.m2505o(45109);
    }

    public final void cfC() {
        AppMethodBeat.m2504i(45099);
        C23639t.makeText(this.mController.ylL, getString(C25738R.string.dpr, new Object[]{this.pWr}), 0).show();
        AppMethodBeat.m2505o(45099);
    }
}
