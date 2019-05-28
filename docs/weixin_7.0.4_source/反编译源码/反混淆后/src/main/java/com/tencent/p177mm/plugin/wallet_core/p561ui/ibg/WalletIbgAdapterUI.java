package com.tencent.p177mm.plugin.wallet_core.p561ui.ibg;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.p749c.p750a.C36835b;
import com.tencent.p177mm.pluginsdk.model.C46499v.C30086a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI */
public class WalletIbgAdapterUI extends WalletBaseUI {

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI$1 */
    class C355001 implements OnClickListener {
        C355001() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47836);
            C30086a.dhr();
            Toast.makeText(WalletIbgAdapterUI.this, WalletIbgAdapterUI.this.getString(C25738R.string.fzg), 1).show();
            WalletIbgAdapterUI.this.finish();
            AppMethodBeat.m2505o(47836);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI$2 */
    class C355012 implements OnClickListener {
        C355012() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47837);
            WalletIbgAdapterUI.this.finish();
            AppMethodBeat.m2505o(47837);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47838);
        super.onCreate(bundle);
        mo9439AM(4);
        this.Ahr.mo49372nf(1564);
        mo39970a(new C36835b(), true, false);
        AppMethodBeat.m2505o(47838);
    }

    public void onResume() {
        AppMethodBeat.m2504i(47839);
        super.onResume();
        AppMethodBeat.m2505o(47839);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47840);
        if (i == 0 && i2 == 0 && (c1207m instanceof C36835b)) {
            int i3 = ((C36835b) c1207m).tuH;
            String str2 = ((C36835b) c1207m).jumpUrl;
            C4990ab.m7417i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", str2, Integer.valueOf(i3));
            if (i3 == 1) {
                C4990ab.m7417i("MicroMsg.WalletH5AdapterUI", "now status = %d", Integer.valueOf(C30086a.dhq()));
                switch (C30086a.dhq()) {
                    case 1:
                    case 4:
                        i3 = 1;
                        break;
                    case 2:
                    case 3:
                        C1720g.m3537RQ();
                        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                            Toast.makeText(this, getString(C25738R.string.fzh), 1).show();
                            C30086a.dhr();
                            finish();
                        } else {
                            cSv();
                        }
                        i3 = 0;
                        break;
                    default:
                        cSv();
                        i3 = 0;
                        break;
                }
                if (i3 != 0) {
                    adg(str2);
                    finish();
                    AppMethodBeat.m2505o(47840);
                }
                AppMethodBeat.m2505o(47840);
            } else {
                adg(str2);
                finish();
                AppMethodBeat.m2505o(47840);
            }
        } else {
            C24143a.m37113b((Activity) this, null, 0);
            AppMethodBeat.m2505o(47840);
        }
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47841);
        this.Ahr.mo49373ng(1564);
        super.onDestroy();
        AppMethodBeat.m2505o(47841);
    }

    private void adg(String str) {
        AppMethodBeat.m2504i(47842);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(47842);
    }

    private void cSv() {
        AppMethodBeat.m2504i(47843);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.TRUE);
        C30379h.m48453a((Context) this, false, getString(C25738R.string.fzk), "", getString(C25738R.string.fzf), getString(C25738R.string.fze), new C355001(), new C355012());
        AppMethodBeat.m2505o(47843);
    }

    public final int getLayoutId() {
        return -1;
    }
}
