package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;

public class CollectHKMainUI extends CollectMainUI {
    private boolean kGg = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41246);
        super.onCreate(bundle);
        this.kHb.setVisibility(8);
        findViewById(R.id.ayi).setVisibility(0);
        findViewById(R.id.ayg).setVisibility(8);
        dOM().nf(1335);
        addIconOptionMenu(0, R.drawable.bli, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(41243);
                e.n(CollectHKMainUI.this.mController.ylL, "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
                AppMethodBeat.o(41243);
                return false;
            }
        });
        AppMethodBeat.o(41246);
    }

    public void onDestroy() {
        AppMethodBeat.i(41247);
        super.onDestroy();
        dOM().ng(1335);
        AppMethodBeat.o(41247);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bho() {
        AppMethodBeat.i(41248);
        g.RQ();
        this.kGD = (String) g.RP().Ry().get(a.USERINFO_WALLET_HK_PAY_URL_STRING, (Object) "");
        m mVar = new m(r.YG());
        if (bo.isNullOrNil(this.kGD)) {
            ab.i("MicroMsg.CollectHKMainUI", "force load payurl");
            this.kGg = true;
            dOM().a(mVar, true, 1);
            AppMethodBeat.o(41248);
            return;
        }
        dOM().a(mVar, false, 1);
        AppMethodBeat.o(41248);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bhp() {
        return this.kGE;
    }

    /* Access modifiers changed, original: protected|final */
    public final String bhq() {
        AppMethodBeat.i(41249);
        if (bo.isNullOrNil(this.kGF)) {
            this.kGF = ae.dOd();
        }
        String str = this.kGF;
        AppMethodBeat.o(41249);
        return str;
    }

    public final boolean f(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(41250);
        if (mVar instanceof m) {
            final m mVar2 = (m) mVar;
            if (i != 0 || i2 != 0) {
                ab.e("MicroMsg.CollectHKMainUI", "net error: %s", mVar);
            } else if (mVar2.kCl == 0) {
                this.kGD = mVar2.kCn;
                this.kGE = mVar2.kCz;
                this.kGF = mVar2.kCw;
                refreshView();
                if (bo.isNullOrNil(mVar2.kCt)) {
                    this.kHb.setVisibility(8);
                } else {
                    this.kGY.setText(mVar2.kCt);
                    this.kHb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(41244);
                            e.n(CollectHKMainUI.this.mController.ylL, mVar2.kCu, false);
                            AppMethodBeat.o(41244);
                        }
                    });
                    this.kHb.setVisibility(0);
                }
                if (bo.isNullOrNil(mVar2.kCx)) {
                    this.kGA.setVisibility(8);
                } else {
                    this.kGA.setText(mVar2.kCx);
                    this.kGA.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(41245);
                            if (!bo.isNullOrNil(mVar2.kCy)) {
                                e.n(CollectHKMainUI.this.mController.ylL, mVar2.kCy, true);
                            }
                            AppMethodBeat.o(41245);
                        }
                    });
                    this.kGA.setVisibility(0);
                }
                AppMethodBeat.o(41250);
                return true;
            }
            if (!this.kGg) {
                AppMethodBeat.o(41250);
                return true;
            }
        }
        AppMethodBeat.o(41250);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bhr() {
        AppMethodBeat.i(41251);
        ImageView imageView = (ImageView) this.kEu.findViewById(R.id.az5);
        ImageView imageView2 = (ImageView) this.kEu.findViewById(R.id.azc);
        LayoutParams layoutParams = (LayoutParams) imageView2.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.addRule(13);
        imageView2.setLayoutParams(layoutParams);
        if (aa.dor().equals("zh_HK")) {
            imageView.setImageResource(R.raw.collect_top_logo_hk_traditional);
            imageView2.setImageResource(R.raw.collect_bottom_logo_hk_traditional);
            AppMethodBeat.o(41251);
            return;
        }
        imageView.setImageResource(R.raw.collect_top_logo_hk);
        imageView2.setImageResource(R.raw.collect_bottom_logo_hk);
        AppMethodBeat.o(41251);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bhs() {
        AppMethodBeat.i(41252);
        super.bhs();
        if (this.kGL) {
            findViewById(R.id.ayi).setVisibility(8);
            AppMethodBeat.o(41252);
            return;
        }
        findViewById(R.id.ayi).setVisibility(0);
        AppMethodBeat.o(41252);
    }
}
