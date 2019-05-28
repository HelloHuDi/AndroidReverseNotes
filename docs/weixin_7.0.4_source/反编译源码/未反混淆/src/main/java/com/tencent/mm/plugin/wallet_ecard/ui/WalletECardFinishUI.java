package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.protocal.protobuf.bhg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;

@a(19)
public class WalletECardFinishUI extends WalletECardBaseUI {
    private TextView kEq;
    private Button nsJ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48146);
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.a69));
        dyb();
        setMMTitle("");
        enableBackMenu(false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48144);
                ab.i("MicroMsg.WalletECardFinishUI", "press back btn");
                WalletECardFinishUI.this.nsJ.performClick();
                AppMethodBeat.o(48144);
                return false;
            }
        });
        showHomeBtn(false);
        initView();
        AppMethodBeat.o(48146);
    }

    public final void initView() {
        AppMethodBeat.i(48147);
        this.kEq = (TextView) findViewById(R.id.ld);
        byte[] byteArray = this.mBundle.getByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.tQa);
        if (byteArray != null) {
            try {
                if (byteArray.length != 0) {
                    bhg bhg = (bhg) new bhg().parseFrom(byteArray);
                    if (!(bhg == null || bo.isNullOrNil(bhg.desc))) {
                        this.kEq.setText(bhg.desc);
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WalletECardFinishUI", e, "", new Object[0]);
            }
        }
        this.nsJ = (Button) findViewById(R.id.bbd);
        this.nsJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48145);
                ab.i("MicroMsg.WalletECardFinishUI", "click finish");
                com.tencent.mm.sdk.b.a.xxA.m(new lu());
                c dOD = WalletECardFinishUI.this.dOD();
                if (dOD != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_process_result_code", -1);
                    dOD.b(WalletECardFinishUI.this.mController.ylL, bundle);
                    AppMethodBeat.o(48145);
                    return;
                }
                ab.w("MicroMsg.WalletECardFinishUI", "process is null");
                WalletECardFinishUI.this.finish();
                AppMethodBeat.o(48145);
            }
        });
        AppMethodBeat.o(48147);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.t4;
    }
}
