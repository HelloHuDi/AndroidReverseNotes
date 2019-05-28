package com.tencent.p177mm.plugin.wallet.pay.p557ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.pay.p557ui.WalletChangeBankcardUI.C296012;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40128i;
import com.tencent.ttpic.VError;
import java.util.Collections;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI */
public class WalletChangeLoanRepayBankcardUI extends WalletChangeBankcardUI {

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI$1 */
    class C43641 implements OnMenuItemClickListener {
        C43641() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45987);
            WalletChangeLoanRepayBankcardUI.this.setResult(-1, null);
            AppMethodBeat.m2505o(45987);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45988);
        super.onCreate(bundle);
        setBackBtn(new C43641());
        AppMethodBeat.m2505o(45988);
    }

    /* Access modifiers changed, original: protected|final */
    public final C40128i cNP() {
        AppMethodBeat.m2504i(45989);
        this.tgB = C14241r.cPJ().tCN;
        if (this.tgB != null) {
            Collections.sort(this.tgB, new C296012());
        }
        C40128i c40128i = new C40128i(this, this.tgB, this.toE, this.pWy);
        AppMethodBeat.m2505o(45989);
        return c40128i;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Hf */
    public final void mo47843Hf(int i) {
        AppMethodBeat.m2504i(45990);
        int size = this.tgB != null ? this.tgB.size() : 0;
        if (this.tgB != null && i < size) {
            Bankcard bankcard = (Bankcard) this.tgB.get(i);
            this.tgC = bankcard;
            this.toF.tGL = bankcard.field_bindSerial;
            this.pTi.setEnabled(true);
            this.toF.notifyDataSetChanged();
            Intent intent = new Intent();
            intent.putExtra("bindSerial", bankcard.field_bindSerial);
            intent.putExtra("ret", 0);
            setResult(-1, intent);
        } else if (size == i) {
            Intent intent2 = new Intent();
            intent2.putExtra("ret", VError.ERROR_DETECTOR_INSTANCE_INIT);
            setResult(-1, intent2);
        }
        finish();
        AppMethodBeat.m2505o(45990);
    }

    public final int getForceOrientation() {
        return 1;
    }
}
