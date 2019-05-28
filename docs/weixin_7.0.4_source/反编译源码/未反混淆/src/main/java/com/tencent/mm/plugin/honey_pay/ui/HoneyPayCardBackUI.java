package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class HoneyPayCardBackUI extends HoneyPayBaseUI {
    private CdnImageView nqV;
    private WalletTextView nqW;
    private TextView nqX;
    private TextView nqY;
    private TextView nqZ;
    private String nra;
    private chl nrb;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41773);
        this.nqT = R.color.s4;
        this.yll = true;
        super.onCreate(bundle);
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(41771);
                HoneyPayCardBackUI.this.aqX();
                HoneyPayCardBackUI.this.aoB();
                HoneyPayCardBackUI.this.finish();
                AppMethodBeat.o(41771);
                return false;
            }
        });
        nf(2851);
        this.nra = getIntent().getStringExtra("key_card_no");
        initView();
        ab.i(this.TAG, "do qry card detail: %s", this.nra);
        m kVar = new k(this.nra);
        kVar.o(this);
        a(kVar, true, false);
        AppMethodBeat.o(41773);
    }

    public final void initView() {
        AppMethodBeat.i(41774);
        this.nqV = (CdnImageView) findViewById(R.id.cea);
        this.nqW = (WalletTextView) findViewById(R.id.ced);
        this.nqX = (TextView) findViewById(R.id.cee);
        this.nqY = (TextView) findViewById(R.id.ceb);
        this.nqZ = (TextView) findViewById(R.id.cec);
        this.nqW.setPrefix(ae.dOd());
        AppMethodBeat.o(41774);
    }

    public void onDestroy() {
        AppMethodBeat.i(41775);
        super.onDestroy();
        ng(2851);
        AppMethodBeat.o(41775);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41776);
        if (mVar instanceof k) {
            final k kVar = (k) mVar;
            kVar.a(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41772);
                    HoneyPayCardBackUI.this.nrb = kVar.nqI.woi;
                    HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, kVar.nqI);
                    AppMethodBeat.o(41772);
                }
            }).b(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            }).c(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            });
        }
        AppMethodBeat.o(41776);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.a6t;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41777);
        if (i == 1 && i2 == -1) {
            ab.i(this.TAG, "unbind success");
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(41777);
    }
}
