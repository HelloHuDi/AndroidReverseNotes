package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.view.d;

public class StartUnbindQQ extends MMWizardActivity implements f {
    private String grq = null;
    private View guo;
    private c gup;
    private p tipDialog;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13765);
        super.onCreate(bundle);
        g.Rg().a((int) d.MIC_PTU_ZIPAI_OKINAWA, (f) this);
        this.grq = getIntent().getStringExtra("notice");
        AppMethodBeat.o(13765);
    }

    public void onDestroy() {
        AppMethodBeat.i(13766);
        g.Rg().b((int) d.MIC_PTU_ZIPAI_OKINAWA, (f) this);
        super.onDestroy();
        AppMethodBeat.o(13766);
    }

    public void onResume() {
        AppMethodBeat.i(13767);
        super.onResume();
        initView();
        AppMethodBeat.o(13767);
    }

    public final int getLayoutId() {
        return R.layout.axi;
    }

    public final void initView() {
        AppMethodBeat.i(13768);
        setMMTitle((int) R.string.ey9);
        this.guo = findViewById(R.id.ep4);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13761);
                StartUnbindQQ.this.finish();
                AppMethodBeat.o(13761);
                return true;
            }
        });
        this.guo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13763);
                if (StartUnbindQQ.this.gup == null) {
                    StartUnbindQQ.this.gup = h.a(StartUnbindQQ.this, StartUnbindQQ.this.getString(R.string.e4u), null, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13762);
                            g.Rg().a(new com.tencent.mm.plugin.account.bind.a.d(""), 0);
                            StartUnbindQQ startUnbindQQ = StartUnbindQQ.this;
                            Context context = StartUnbindQQ.this;
                            StartUnbindQQ.this.getString(R.string.tz);
                            startUnbindQQ.tipDialog = h.b(context, StartUnbindQQ.this.getString(R.string.e4v), true, null);
                            AppMethodBeat.o(13762);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(13763);
                    return;
                }
                StartUnbindQQ.this.gup.show();
                AppMethodBeat.o(13763);
            }
        });
        AppMethodBeat.o(13768);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(13769);
        ab.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + mVar.getType());
        if (mVar.getType() == d.MIC_PTU_ZIPAI_OKINAWA) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0) {
                int a = bo.a((Integer) g.RP().Ry().get(9, null), 0);
                ab.d("MicroMsg.StartUnbindQQ", "iBindUin ".concat(String.valueOf(a)));
                if (a != 0) {
                    ((j) g.K(j.class)).XU().delete(new com.tencent.mm.a.p(a) + "@qqim");
                }
                Object obj = g.RP().Ry().get(102407, null);
                if (obj != null && ((String) obj).length() > 0) {
                    g.RP().Ry().set(102407, null);
                }
                try {
                    a.xxA.m(new ag());
                    String str2 = new com.tencent.mm.a.p(bo.a((Integer) g.RP().Ry().get(9, null), 0)) + "@qqim";
                    ((j) g.K(j.class)).XU().delete(str2);
                    ((j) g.K(j.class)).XM().aoU(str2);
                    o.act().qp(str2);
                    String str3 = r.Yz() + "@qqim";
                    o.act().qp(str3);
                    o.acd();
                    com.tencent.mm.ah.d.E(str2, false);
                    o.acd();
                    com.tencent.mm.ah.d.E(str2, true);
                    o.acd();
                    com.tencent.mm.ah.d.E(str3, false);
                    o.acd();
                    com.tencent.mm.ah.d.E(str3, true);
                    an anVar = (an) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
                    ab.d("MicroMsg.QQGroupStorage", "delete all");
                    if (anVar.fni.delete("qqgroup", null, null) > 0) {
                        anVar.doNotify();
                    }
                    com.tencent.mm.plugin.account.a.a.gkF.BS();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                    ab.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                }
                g.RP().Ry().set(9, Integer.valueOf(0));
                tt ttVar = new tt();
                ttVar.cPS.cPT = false;
                ttVar.cPS.cPU = true;
                a.xxA.m(ttVar);
                if (bo.isNullOrNil(this.grq)) {
                    Ni(1);
                } else {
                    h.a((Context) this, this.grq, "", getString(R.string.r4), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13764);
                            StartUnbindQQ.b(StartUnbindQQ.this);
                            AppMethodBeat.o(13764);
                        }
                    });
                }
            }
            com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
            if (jY != null) {
                jY.a(this, null, null);
                AppMethodBeat.o(13769);
                return;
            }
        }
        AppMethodBeat.o(13769);
    }

    static /* synthetic */ void b(StartUnbindQQ startUnbindQQ) {
        AppMethodBeat.i(13770);
        startUnbindQQ.Ni(1);
        AppMethodBeat.o(13770);
    }
}
