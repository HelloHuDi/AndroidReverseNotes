package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_ecard.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.wallet_core.c.p.a;
import org.xwalk.core.Log;

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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48151);
        super.onCreate(bundle);
        nf(2931);
        initView();
        setMMTitle((int) R.string.b8f);
        Log.i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
        m gVar = new g();
        gVar.o(this);
        a(gVar, true, false);
        AppMethodBeat.o(48151);
    }

    public final void initView() {
        AppMethodBeat.i(48152);
        this.iDT = (TextView) findViewById(R.id.bbh);
        this.tQJ = (TextView) findViewById(R.id.bbi);
        this.tQK = (LinearLayout) findViewById(R.id.bbj);
        this.gnj = (TextView) findViewById(R.id.bbl);
        this.ntk = (CdnImageView) findViewById(R.id.bbg);
        this.iWz = findViewById(R.id.bbm);
        this.tQL = (Button) findViewById(R.id.bbk);
        this.tQL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48148);
                WalletECardLogoutUI.a(WalletECardLogoutUI.this);
                AppMethodBeat.o(48148);
            }
        });
        AppMethodBeat.o(48152);
    }

    public void onDestroy() {
        AppMethodBeat.i(48153);
        super.onDestroy();
        ng(2931);
        AppMethodBeat.o(48153);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48154);
        if (mVar instanceof g) {
            final g gVar = (g) mVar;
            gVar.a(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48149);
                    WalletECardLogoutUI.this.tlg = gVar.tQo.pbo;
                    WalletECardLogoutUI.this.tDT = gVar.tQo.pbn;
                    WalletECardLogoutUI.a(WalletECardLogoutUI.this, gVar.tQo);
                    AppMethodBeat.o(48149);
                }
            }).b(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            }).c(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            });
            AppMethodBeat.o(48154);
            return true;
        }
        AppMethodBeat.o(48154);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.t6;
    }

    static /* synthetic */ void a(WalletECardLogoutUI walletECardLogoutUI) {
        AppMethodBeat.i(48155);
        Log.i("MicroMsg.WalletECardLogoutUI", "do logout");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_show_detail", false);
        Bankcard bankcard = new Bankcard();
        bankcard.field_bindSerial = walletECardLogoutUI.tlg;
        bankcard.field_bankcardType = walletECardLogoutUI.tDT;
        bundle.putParcelable("key_bankcard", bankcard);
        bundle.putInt("scene", 2);
        com.tencent.mm.wallet_core.a.a(walletECardLogoutUI, com.tencent.mm.plugin.wallet.bind.a.class, bundle);
        AppMethodBeat.o(48155);
    }
}
