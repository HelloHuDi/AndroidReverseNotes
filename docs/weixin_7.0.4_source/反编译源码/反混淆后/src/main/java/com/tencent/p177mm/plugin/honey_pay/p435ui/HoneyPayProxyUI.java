package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.honey_pay.p434a.C12221l;
import com.tencent.p177mm.plugin.honey_pay.p434a.C12222m;
import com.tencent.p177mm.protocal.protobuf.bnn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import java.io.IOException;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI */
public class HoneyPayProxyUI extends HoneyPayBaseUI {
    private String nra;
    private boolean nsL;

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI$1 */
    class C283051 implements C40929a {
        C283051() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI$2 */
    class C283062 implements C40929a {
        C283062() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41925);
            HoneyPayProxyUI.this.finish();
            AppMethodBeat.m2505o(41925);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI$4 */
    class C283084 implements C40929a {
        C283084() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI$5 */
    class C283095 implements C40929a {
        C283095() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41927);
            HoneyPayProxyUI.this.finish();
            AppMethodBeat.m2505o(41927);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41929);
        super.onCreate(bundle);
        mo39992nf(2876);
        mo39992nf(2613);
        this.nsL = getIntent().getBooleanExtra("key_is_payer", false);
        this.nra = getIntent().getStringExtra("key_card_no");
        C4990ab.m7417i(this.TAG, "is payer: %s", Boolean.valueOf(this.nsL));
        C1207m c12221l;
        if (this.nsL) {
            C4990ab.m7416i(this.TAG, "do qry payer detail");
            c12221l = new C12221l(this.nra);
            c12221l.mo70321o(this);
            mo39970a(c12221l, true, false);
            AppMethodBeat.m2505o(41929);
            return;
        }
        c12221l = new C12222m(this.nra);
        c12221l.mo70321o(this);
        mo39970a(c12221l, true, false);
        AppMethodBeat.m2505o(41929);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFY() {
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41930);
        super.onDestroy();
        mo39993ng(2876);
        mo39993ng(2613);
        AppMethodBeat.m2505o(41930);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41931);
        if (c1207m instanceof C12221l) {
            final C12221l c12221l = (C12221l) c1207m;
            c12221l.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41926);
                    if (c12221l.nqJ.wci != null) {
                        C4990ab.m7417i(HoneyPayProxyUI.this.TAG, "state: %s", Integer.valueOf(c12221l.nqJ.wci.state));
                    }
                    HoneyPayProxyUI.m44903a(HoneyPayProxyUI.this, c12221l.nqJ);
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.m2505o(41926);
                }
            }).mo70319b(new C283062()).mo70320c(new C283051());
        } else if (c1207m instanceof C12222m) {
            final C12222m c12222m = (C12222m) c1207m;
            c12222m.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41928);
                    C4990ab.m7417i(HoneyPayProxyUI.this.TAG, "state: %s", Integer.valueOf(c12222m.nqK.wps.state));
                    if (c12222m.nqK.wps.state == 1) {
                        HoneyPayProxyUI.m44904a(HoneyPayProxyUI.this, c12222m.nqK);
                    } else {
                        HoneyPayProxyUI.m44905b(HoneyPayProxyUI.this, c12222m.nqK);
                    }
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.m2505o(41928);
                }
            }).mo70319b(new C283095()).mo70320c(new C283084());
        }
        AppMethodBeat.m2505o(41931);
        return true;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean bwQ() {
        return true;
    }

    /* renamed from: b */
    static /* synthetic */ void m44905b(HoneyPayProxyUI honeyPayProxyUI, bnn bnn) {
        AppMethodBeat.m2504i(41934);
        C4990ab.m7416i(honeyPayProxyUI.TAG, "go to card detail");
        Intent intent = new Intent(honeyPayProxyUI, HoneyPayCardDetailUI.class);
        intent.putExtra("key_card_no", honeyPayProxyUI.nra);
        intent.putExtra("key_scene", 1);
        try {
            intent.putExtra("key_qry_response", bnn.toByteArray());
        } catch (IOException e) {
            C4990ab.printErrStackTrace(honeyPayProxyUI.TAG, e, "", new Object[0]);
        }
        honeyPayProxyUI.startActivity(intent);
        AppMethodBeat.m2505o(41934);
    }
}
