package com.tencent.p177mm.plugin.collect.p368ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.collect.model.C2833m;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.collect.ui.CollectHKMainUI */
public class CollectHKMainUI extends CollectMainUI {
    private boolean kGg = false;

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectHKMainUI$1 */
    class C28441 implements OnMenuItemClickListener {
        C28441() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(41243);
            C36391e.m60016n(CollectHKMainUI.this.mController.ylL, "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
            AppMethodBeat.m2505o(41243);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41246);
        super.onCreate(bundle);
        this.kHb.setVisibility(8);
        findViewById(2131822857).setVisibility(0);
        findViewById(2131822855).setVisibility(8);
        dOM().mo49372nf(1335);
        addIconOptionMenu(0, C25738R.drawable.bli, new C28441());
        AppMethodBeat.m2505o(41246);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41247);
        super.onDestroy();
        dOM().mo49373ng(1335);
        AppMethodBeat.m2505o(41247);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bho() {
        AppMethodBeat.m2504i(41248);
        C1720g.m3537RQ();
        this.kGD = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_HK_PAY_URL_STRING, (Object) "");
        C2833m c2833m = new C2833m(C1853r.m3825YG());
        if (C5046bo.isNullOrNil(this.kGD)) {
            C4990ab.m7416i("MicroMsg.CollectHKMainUI", "force load payurl");
            this.kGg = true;
            dOM().mo49367a(c2833m, true, 1);
            AppMethodBeat.m2505o(41248);
            return;
        }
        dOM().mo49367a(c2833m, false, 1);
        AppMethodBeat.m2505o(41248);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bhp() {
        return this.kGE;
    }

    /* Access modifiers changed, original: protected|final */
    public final String bhq() {
        AppMethodBeat.m2504i(41249);
        if (C5046bo.isNullOrNil(this.kGF)) {
            this.kGF = C44423ae.dOd();
        }
        String str = this.kGF;
        AppMethodBeat.m2505o(41249);
        return str;
    }

    /* renamed from: f */
    public final boolean mo24791f(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41250);
        if (c1207m instanceof C2833m) {
            final C2833m c2833m = (C2833m) c1207m;
            if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.CollectHKMainUI", "net error: %s", c1207m);
            } else if (c2833m.kCl == 0) {
                this.kGD = c2833m.kCn;
                this.kGE = c2833m.kCz;
                this.kGF = c2833m.kCw;
                refreshView();
                if (C5046bo.isNullOrNil(c2833m.kCt)) {
                    this.kHb.setVisibility(8);
                } else {
                    this.kGY.setText(c2833m.kCt);
                    this.kHb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(41244);
                            C36391e.m60016n(CollectHKMainUI.this.mController.ylL, c2833m.kCu, false);
                            AppMethodBeat.m2505o(41244);
                        }
                    });
                    this.kHb.setVisibility(0);
                }
                if (C5046bo.isNullOrNil(c2833m.kCx)) {
                    this.kGA.setVisibility(8);
                } else {
                    this.kGA.setText(c2833m.kCx);
                    this.kGA.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(41245);
                            if (!C5046bo.isNullOrNil(c2833m.kCy)) {
                                C36391e.m60016n(CollectHKMainUI.this.mController.ylL, c2833m.kCy, true);
                            }
                            AppMethodBeat.m2505o(41245);
                        }
                    });
                    this.kGA.setVisibility(0);
                }
                AppMethodBeat.m2505o(41250);
                return true;
            }
            if (!this.kGg) {
                AppMethodBeat.m2505o(41250);
                return true;
            }
        }
        AppMethodBeat.m2505o(41250);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bhr() {
        AppMethodBeat.m2504i(41251);
        ImageView imageView = (ImageView) this.kEu.findViewById(2131822880);
        ImageView imageView2 = (ImageView) this.kEu.findViewById(2131822888);
        LayoutParams layoutParams = (LayoutParams) imageView2.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.addRule(13);
        imageView2.setLayoutParams(layoutParams);
        if (C4988aa.dor().equals("zh_HK")) {
            imageView.setImageResource(C1318a.collect_top_logo_hk_traditional);
            imageView2.setImageResource(C1318a.collect_bottom_logo_hk_traditional);
            AppMethodBeat.m2505o(41251);
            return;
        }
        imageView.setImageResource(C1318a.collect_top_logo_hk);
        imageView2.setImageResource(C1318a.collect_bottom_logo_hk);
        AppMethodBeat.m2505o(41251);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bhs() {
        AppMethodBeat.m2504i(41252);
        super.bhs();
        if (this.kGL) {
            findViewById(2131822857).setVisibility(8);
            AppMethodBeat.m2505o(41252);
            return;
        }
        findViewById(2131822857).setVisibility(0);
        AppMethodBeat.m2505o(41252);
    }
}
