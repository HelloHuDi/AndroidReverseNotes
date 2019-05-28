package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class RemittanceOSUI extends RemittanceBaseUI implements d.a {
    private c omX = new c<vo>() {
        {
            AppMethodBeat.i(45091);
            this.xxI = vo.class.getName().hashCode();
            AppMethodBeat.o(45091);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(45092);
            if (RemittanceOSUI.this.pWv) {
                RemittanceOSUI.this.finish();
            }
            AppMethodBeat.o(45092);
            return false;
        }
    };
    private int pWq;
    private String pWr;
    private String pWs;
    private String pWt;
    private String pWu;
    private boolean pWv = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceOSUI() {
        AppMethodBeat.i(45097);
        AppMethodBeat.o(45097);
    }

    public final void cfz() {
    }

    public final void cfB() {
        AppMethodBeat.i(45098);
        h.pYm.e(13337, Integer.valueOf(2));
        AppMethodBeat.o(45098);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45100);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xxA.b(this.omX);
        this.Ahr.nf(1622);
        this.Ahr.nf(1574);
        initView();
        this.kGa.setTitleText("");
        o.acd().a((d.a) this);
        this.pWq = getIntent().getIntExtra("os_currency", 0);
        this.pWr = getIntent().getStringExtra("os_currencyuint");
        this.pWs = getIntent().getStringExtra("os_currencywording");
        this.pWt = getIntent().getStringExtra("os_notice");
        this.pWu = getIntent().getStringExtra("os_notice_url");
        this.kGa.setTitleText(this.pWr);
        cfG();
        AppMethodBeat.o(45100);
    }

    public final void a(String str, int i, String str2, String str3, String str4, String str5, String str6, fw fwVar) {
        AppMethodBeat.i(45101);
        String YB = r.YB();
        if (bo.isNullOrNil(YB)) {
            YB = r.Yz();
        }
        g.RQ();
        ad aoO = ((j) g.K(j.class)).XM().aoO(this.edV);
        String str7 = this.edV;
        if (((int) aoO.ewQ) != 0) {
            str7 = aoO.Oj();
        }
        m zVar = new z(this.pQV, YB, this.edV, str7, str, this.pWq);
        zVar.eHT = "RemittanceProcess";
        a(zVar, true, true);
        h.pYm.e(13337, Integer.valueOf(1), Double.valueOf(this.pQV));
        AppMethodBeat.o(45101);
    }

    /* Access modifiers changed, original: protected|final */
    public final void VV(String str) {
        AppMethodBeat.i(45102);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.pWv = true;
        AppMethodBeat.o(45102);
    }

    /* Access modifiers changed, original: protected|final */
    public final void VW(String str) {
        AppMethodBeat.i(45103);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.pWv = true;
        AppMethodBeat.o(45103);
    }

    public final void cfG() {
        AppMethodBeat.i(45104);
        if (bo.isNullOrNil(this.pWt)) {
            ab.i("MicroMsg.RemittanceOSUI", "no bulletin data");
            AppMethodBeat.o(45104);
            return;
        }
        e.a((TextView) findViewById(R.id.a2f), "", this.pWt, this.pWu);
        AppMethodBeat.o(45104);
    }

    public void onResume() {
        AppMethodBeat.i(45105);
        super.onResume();
        AppMethodBeat.o(45105);
    }

    public void onPause() {
        AppMethodBeat.i(45106);
        super.onPause();
        AppMethodBeat.o(45106);
    }

    public void onDestroy() {
        AppMethodBeat.i(45107);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.omX);
        o.acd().b(this);
        this.Ahr.ng(1622);
        this.Ahr.ng(1574);
        AppMethodBeat.o(45107);
    }

    public final void qj(String str) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45108);
        ab.d("MicroMsg.RemittanceOSUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.edV);
        this.pWv = false;
        if (i == 3 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(45108);
    }

    public final int getLayoutId() {
        return R.layout.aoj;
    }

    public final void b(int i, int i2, String str, m mVar, boolean z) {
        AppMethodBeat.i(45109);
        super.b(i, i2, str, mVar, z);
        if (i == 0 && i2 == 0 && (mVar instanceof z)) {
            int i3;
            final z zVar = (z) mVar;
            if (zVar.pPl <= 0) {
                i3 = 0;
            } else if (zVar.pQB == 0) {
                com.tencent.mm.ui.base.h.d(this, getString(R.string.dq2, new Object[]{Integer.valueOf(zVar.pPl)}), getString(R.string.t6), getString(R.string.do6), getString(R.string.dpq), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45093);
                        RemittanceOSUI.this.VV(zVar.pPf);
                        AppMethodBeat.o(45093);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45094);
                        RemittanceOSUI.this.VW(zVar.pQA);
                        AppMethodBeat.o(45094);
                    }
                });
                i3 = 1;
            } else if (zVar.pQB == 1) {
                com.tencent.mm.ui.base.h.d(this, getString(R.string.dq2, new Object[]{Integer.valueOf(zVar.pPl)}), getString(R.string.t6), getString(R.string.do6), getString(R.string.dpq), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45095);
                        RemittanceOSUI.this.VV(zVar.pPf);
                        AppMethodBeat.o(45095);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45096);
                        RemittanceOSUI.this.VW(zVar.pQA);
                        AppMethodBeat.o(45096);
                    }
                });
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                String str2 = ((z) mVar).pPf;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 3);
            }
        }
        AppMethodBeat.o(45109);
    }

    public final void cfC() {
        AppMethodBeat.i(45099);
        t.makeText(this.mController.ylL, getString(R.string.dpr, new Object[]{this.pWr}), 0).show();
        AppMethodBeat.o(45099);
    }
}
