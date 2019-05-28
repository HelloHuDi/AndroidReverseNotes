package com.tencent.p177mm.plugin.wallet_ecard.p563ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C6517lu;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C43818a;
import com.tencent.p177mm.protocal.protobuf.bhg;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI */
public class WalletECardFinishUI extends WalletECardBaseUI {
    private TextView kEq;
    private Button nsJ;

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI$2 */
    class C314642 implements OnClickListener {
        C314642() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48145);
            C4990ab.m7416i("MicroMsg.WalletECardFinishUI", "click finish");
            C4879a.xxA.mo10055m(new C6517lu());
            C40931c dOD = WalletECardFinishUI.this.dOD();
            if (dOD != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_process_result_code", -1);
                dOD.mo8125b(WalletECardFinishUI.this.mController.ylL, bundle);
                AppMethodBeat.m2505o(48145);
                return;
            }
            C4990ab.m7420w("MicroMsg.WalletECardFinishUI", "process is null");
            WalletECardFinishUI.this.finish();
            AppMethodBeat.m2505o(48145);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI$1 */
    class C314651 implements OnMenuItemClickListener {
        C314651() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(48144);
            C4990ab.m7416i("MicroMsg.WalletECardFinishUI", "press back btn");
            WalletECardFinishUI.this.nsJ.performClick();
            AppMethodBeat.m2505o(48144);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48146);
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.a69));
        dyb();
        setMMTitle("");
        enableBackMenu(false);
        setBackBtn(new C314651());
        showHomeBtn(false);
        initView();
        AppMethodBeat.m2505o(48146);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48147);
        this.kEq = (TextView) findViewById(2131820991);
        byte[] byteArray = this.mBundle.getByteArray(C43818a.tQa);
        if (byteArray != null) {
            try {
                if (byteArray.length != 0) {
                    bhg bhg = (bhg) new bhg().parseFrom(byteArray);
                    if (!(bhg == null || C5046bo.isNullOrNil(bhg.desc))) {
                        this.kEq.setText(bhg.desc);
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletECardFinishUI", e, "", new Object[0]);
            }
        }
        this.nsJ = (Button) findViewById(2131823370);
        this.nsJ.setOnClickListener(new C314642());
        AppMethodBeat.m2505o(48147);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130969311;
    }
}
