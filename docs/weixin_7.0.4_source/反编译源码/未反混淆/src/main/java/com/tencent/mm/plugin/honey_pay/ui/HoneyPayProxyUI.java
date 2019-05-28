package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.p;
import java.io.IOException;

@a(3)
public class HoneyPayProxyUI extends HoneyPayBaseUI {
    private String nra;
    private boolean nsL;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41929);
        super.onCreate(bundle);
        nf(2876);
        nf(2613);
        this.nsL = getIntent().getBooleanExtra("key_is_payer", false);
        this.nra = getIntent().getStringExtra("key_card_no");
        ab.i(this.TAG, "is payer: %s", Boolean.valueOf(this.nsL));
        m lVar;
        if (this.nsL) {
            ab.i(this.TAG, "do qry payer detail");
            lVar = new l(this.nra);
            lVar.o(this);
            a(lVar, true, false);
            AppMethodBeat.o(41929);
            return;
        }
        lVar = new com.tencent.mm.plugin.honey_pay.a.m(this.nra);
        lVar.o(this);
        a(lVar, true, false);
        AppMethodBeat.o(41929);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFY() {
    }

    public void onDestroy() {
        AppMethodBeat.i(41930);
        super.onDestroy();
        ng(2876);
        ng(2613);
        AppMethodBeat.o(41930);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41931);
        if (mVar instanceof l) {
            final l lVar = (l) mVar;
            lVar.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41926);
                    if (lVar.nqJ.wci != null) {
                        ab.i(HoneyPayProxyUI.this.TAG, "state: %s", Integer.valueOf(lVar.nqJ.wci.state));
                    }
                    HoneyPayProxyUI.a(HoneyPayProxyUI.this, lVar.nqJ);
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.o(41926);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41925);
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.o(41925);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            });
        } else if (mVar instanceof com.tencent.mm.plugin.honey_pay.a.m) {
            final com.tencent.mm.plugin.honey_pay.a.m mVar2 = (com.tencent.mm.plugin.honey_pay.a.m) mVar;
            mVar2.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41928);
                    ab.i(HoneyPayProxyUI.this.TAG, "state: %s", Integer.valueOf(mVar2.nqK.wps.state));
                    if (mVar2.nqK.wps.state == 1) {
                        HoneyPayProxyUI.a(HoneyPayProxyUI.this, mVar2.nqK);
                    } else {
                        HoneyPayProxyUI.b(HoneyPayProxyUI.this, mVar2.nqK);
                    }
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.o(41928);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41927);
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.o(41927);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            });
        }
        AppMethodBeat.o(41931);
        return true;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean bwQ() {
        return true;
    }

    static /* synthetic */ void b(HoneyPayProxyUI honeyPayProxyUI, bnn bnn) {
        AppMethodBeat.i(41934);
        ab.i(honeyPayProxyUI.TAG, "go to card detail");
        Intent intent = new Intent(honeyPayProxyUI, HoneyPayCardDetailUI.class);
        intent.putExtra("key_card_no", honeyPayProxyUI.nra);
        intent.putExtra("key_scene", 1);
        try {
            intent.putExtra("key_qry_response", bnn.toByteArray());
        } catch (IOException e) {
            ab.printErrStackTrace(honeyPayProxyUI.TAG, e, "", new Object[0]);
        }
        honeyPayProxyUI.startActivity(intent);
        AppMethodBeat.o(41934);
    }
}
