package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.i;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.ttpic.VError;
import java.util.Collections;
import java.util.Comparator;

@a(3)
public class WalletChangeLoanRepayBankcardUI extends WalletChangeBankcardUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45988);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45987);
                WalletChangeLoanRepayBankcardUI.this.setResult(-1, null);
                AppMethodBeat.o(45987);
                return true;
            }
        });
        AppMethodBeat.o(45988);
    }

    /* Access modifiers changed, original: protected|final */
    public final i cNP() {
        AppMethodBeat.i(45989);
        this.tgB = r.cPJ().tCN;
        if (this.tgB != null) {
            Collections.sort(this.tgB, new Comparator<Bankcard>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(45959);
                    Bankcard bankcard = (Bankcard) obj;
                    Bankcard bankcard2 = (Bankcard) obj2;
                    if (bankcard.cPc()) {
                        AppMethodBeat.o(45959);
                        return -1;
                    } else if (bankcard.cPd()) {
                        if (bankcard2.cPc()) {
                            AppMethodBeat.o(45959);
                            return 1;
                        }
                        AppMethodBeat.o(45959);
                        return -1;
                    } else if (bo.amZ(bankcard.field_forbidWord) < bo.amZ(bankcard2.field_forbidWord)) {
                        AppMethodBeat.o(45959);
                        return -1;
                    } else if (bo.amZ(bankcard.field_forbidWord) > bo.amZ(bankcard2.field_forbidWord)) {
                        AppMethodBeat.o(45959);
                        return 1;
                    } else {
                        AppMethodBeat.o(45959);
                        return 0;
                    }
                }
            });
        }
        i iVar = new i(this, this.tgB, this.toE, this.pWy);
        AppMethodBeat.o(45989);
        return iVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void Hf(int i) {
        AppMethodBeat.i(45990);
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
        AppMethodBeat.o(45990);
    }

    public final int getForceOrientation() {
        return 1;
    }
}
