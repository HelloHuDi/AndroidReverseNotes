package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.honey_pay.p434a.C3286k;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.chl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI */
public class HoneyPayCardBackUI extends HoneyPayBaseUI {
    private CdnImageView nqV;
    private WalletTextView nqW;
    private TextView nqX;
    private TextView nqY;
    private TextView nqZ;
    private String nra;
    private chl nrb;

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI$2 */
    class C210512 implements C40929a {
        C210512() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI$1 */
    class C210521 implements OnMenuItemClickListener {
        C210521() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(41771);
            HoneyPayCardBackUI.this.aqX();
            HoneyPayCardBackUI.this.aoB();
            HoneyPayCardBackUI.this.finish();
            AppMethodBeat.m2505o(41771);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI$3 */
    class C210533 implements C40929a {
        C210533() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41773);
        this.nqT = C25738R.color.f12096s4;
        this.yll = true;
        super.onCreate(bundle);
        setMMTitle("");
        setBackBtn(new C210521());
        mo39992nf(2851);
        this.nra = getIntent().getStringExtra("key_card_no");
        initView();
        C4990ab.m7417i(this.TAG, "do qry card detail: %s", this.nra);
        C1207m c3286k = new C3286k(this.nra);
        c3286k.mo70321o(this);
        mo39970a(c3286k, true, false);
        AppMethodBeat.m2505o(41773);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41774);
        this.nqV = (CdnImageView) findViewById(2131824847);
        this.nqW = (WalletTextView) findViewById(2131824850);
        this.nqX = (TextView) findViewById(2131824851);
        this.nqY = (TextView) findViewById(2131824848);
        this.nqZ = (TextView) findViewById(2131824849);
        this.nqW.setPrefix(C44423ae.dOd());
        AppMethodBeat.m2505o(41774);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41775);
        super.onDestroy();
        mo39993ng(2851);
        AppMethodBeat.m2505o(41775);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41776);
        if (c1207m instanceof C3286k) {
            final C3286k c3286k = (C3286k) c1207m;
            c3286k.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41772);
                    HoneyPayCardBackUI.this.nrb = c3286k.nqI.woi;
                    HoneyPayCardBackUI.m32358a(HoneyPayCardBackUI.this, c3286k.nqI);
                    AppMethodBeat.m2505o(41772);
                }
            }).mo70319b(new C210533()).mo70320c(new C210512());
        }
        AppMethodBeat.m2505o(41776);
        return true;
    }

    public final int getLayoutId() {
        return 2130969820;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41777);
        if (i == 1 && i2 == -1) {
            C4990ab.m7416i(this.TAG, "unbind success");
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(41777);
    }
}
