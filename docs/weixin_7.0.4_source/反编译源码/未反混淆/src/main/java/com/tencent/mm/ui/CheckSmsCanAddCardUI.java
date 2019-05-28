package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class CheckSmsCanAddCardUI extends MMActivity implements f {
    private b ehh;
    private String yfP;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29161);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (!aw.ZM() || aw.QT()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            AppMethodBeat.o(29161);
            return;
        }
        int i;
        Uri data = getIntent().getData();
        if (data != null) {
            String host = data.getHost();
            if (bo.isNullOrNil(host) || !host.equals("cardpackage")) {
                ab.e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", host);
            } else {
                this.yfP = data.getQueryParameter("encrystr");
                ab.i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", this.yfP);
                if (!bo.isNullOrNil(this.yfP)) {
                    i = 1;
                    if (i == 0) {
                        aw.Rg().a(1038, (f) this);
                        a aVar = new a();
                        aVar.fsJ = new ru();
                        aVar.fsK = new rv();
                        aVar.fsI = 1038;
                        aVar.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
                        this.ehh = aVar.acD();
                        ((ru) this.ehh.fsG.fsP).vZg = this.yfP;
                        ab.i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", this.yfP);
                        this.ehh = w.b(this.ehh);
                        AppMethodBeat.o(29161);
                        return;
                    }
                    dwv();
                    AppMethodBeat.o(29161);
                    return;
                }
            }
        }
        i = 0;
        if (i == 0) {
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return R.layout.a99;
    }

    public void onDestroy() {
        AppMethodBeat.i(29162);
        super.onDestroy();
        aw.Rg().b(1038, (f) this);
        AppMethodBeat.o(29162);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(29163);
        ab.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            rv rvVar = (rv) this.ehh.fsH.fsP;
            ab.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", rvVar.cMC, rvVar.cMD);
            Intent intent = new Intent();
            intent.putExtra("key_card_id", r1);
            intent.putExtra("key_card_ext", r0);
            intent.putExtra("key_from_scene", 8);
            intent.putExtra("key_is_sms_add_card", true);
            d.c((Context) this, "card", ".ui.CardDetailUI", intent);
            finish();
            AppMethodBeat.o(29163);
            return;
        }
        dwv();
        AppMethodBeat.o(29163);
    }

    private void dwv() {
        AppMethodBeat.i(29164);
        Toast.makeText(this, getString(R.string.f0m), 1).show();
        LauncherUI.ho(this);
        finish();
        AppMethodBeat.o(29164);
    }
}
