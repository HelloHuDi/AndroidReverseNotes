package com.tencent.p177mm.plugin.wallet_ecard.p563ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet.bind.C41325a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C46375g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI */
public class WalletECardLogoutUI extends WalletECardBaseUI {
    private TextView gnj;
    private TextView iDT;
    private View iWz;
    private CdnImageView ntk;
    private String tDT;
    private TextView tQJ;
    private LinearLayout tQK;
    private Button tQL;
    private String tlg;

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI$1 */
    class C44811 implements OnClickListener {
        C44811() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48148);
            WalletECardLogoutUI.m50907a(WalletECardLogoutUI.this);
            AppMethodBeat.m2505o(48148);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI$3 */
    class C226873 implements C40929a {
        C226873() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI$2 */
    class C296892 implements C40929a {
        C296892() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardLogoutUI$6 */
    class C314666 implements OnClickListener {
        C314666() {
        }

        public final void onClick(View view) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48151);
        super.onCreate(bundle);
        mo39992nf(2931);
        initView();
        setMMTitle((int) C25738R.string.b8f);
        Log.m81049i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
        C1207m c46375g = new C46375g();
        c46375g.mo70321o(this);
        mo39970a(c46375g, true, false);
        AppMethodBeat.m2505o(48151);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48152);
        this.iDT = (TextView) findViewById(2131823374);
        this.tQJ = (TextView) findViewById(2131823375);
        this.tQK = (LinearLayout) findViewById(2131823376);
        this.gnj = (TextView) findViewById(2131823378);
        this.ntk = (CdnImageView) findViewById(2131823373);
        this.iWz = findViewById(2131823379);
        this.tQL = (Button) findViewById(2131823377);
        this.tQL.setOnClickListener(new C44811());
        AppMethodBeat.m2505o(48152);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48153);
        super.onDestroy();
        mo39993ng(2931);
        AppMethodBeat.m2505o(48153);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48154);
        if (c1207m instanceof C46375g) {
            final C46375g c46375g = (C46375g) c1207m;
            c46375g.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48149);
                    WalletECardLogoutUI.this.tlg = c46375g.tQo.pbo;
                    WalletECardLogoutUI.this.tDT = c46375g.tQo.pbn;
                    WalletECardLogoutUI.m50908a(WalletECardLogoutUI.this, c46375g.tQo);
                    AppMethodBeat.m2505o(48149);
                }
            }).mo70319b(new C226873()).mo70320c(new C296892());
            AppMethodBeat.m2505o(48154);
            return true;
        }
        AppMethodBeat.m2505o(48154);
        return false;
    }

    public final int getLayoutId() {
        return 2130969313;
    }

    /* renamed from: a */
    static /* synthetic */ void m50907a(WalletECardLogoutUI walletECardLogoutUI) {
        AppMethodBeat.m2504i(48155);
        Log.m81049i("MicroMsg.WalletECardLogoutUI", "do logout");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_show_detail", false);
        Bankcard bankcard = new Bankcard();
        bankcard.field_bindSerial = walletECardLogoutUI.tlg;
        bankcard.field_bankcardType = walletECardLogoutUI.tDT;
        bundle.putParcelable("key_bankcard", bankcard);
        bundle.putInt("scene", 2);
        C24143a.m37105a(walletECardLogoutUI, C41325a.class, bundle);
        AppMethodBeat.m2505o(48155);
    }
}
