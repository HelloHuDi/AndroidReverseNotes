package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p275ui.SimpleLoginUI;
import com.tencent.p177mm.protocal.protobuf.C30221rv;
import com.tencent.p177mm.protocal.protobuf.C35950ru;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.CheckSmsCanAddCardUI */
public class CheckSmsCanAddCardUI extends MMActivity implements C1202f {
    private C7472b ehh;
    private String yfP;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29161);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            AppMethodBeat.m2505o(29161);
            return;
        }
        int i;
        Uri data = getIntent().getData();
        if (data != null) {
            String host = data.getHost();
            if (C5046bo.isNullOrNil(host) || !host.equals("cardpackage")) {
                C4990ab.m7413e("MicroMsg.CheckSmsCanAddCardUI", "err host, host = %s", host);
            } else {
                this.yfP = data.getQueryParameter("encrystr");
                C4990ab.m7417i("MicroMsg.CheckSmsCanAddCardUI", "encryptCardInfo = %s", this.yfP);
                if (!C5046bo.isNullOrNil(this.yfP)) {
                    i = 1;
                    if (i == 0) {
                        C9638aw.m17182Rg().mo14539a(1038, (C1202f) this);
                        C1196a c1196a = new C1196a();
                        c1196a.fsJ = new C35950ru();
                        c1196a.fsK = new C30221rv();
                        c1196a.fsI = 1038;
                        c1196a.uri = "/cgi-bin/mmbiz-bin/api/checksmscanaddcard";
                        this.ehh = c1196a.acD();
                        ((C35950ru) this.ehh.fsG.fsP).vZg = this.yfP;
                        C4990ab.m7417i("MicroMsg.CheckSmsCanAddCardUI", "encry value is %s", this.yfP);
                        this.ehh = C1226w.m2657b(this.ehh);
                        AppMethodBeat.m2505o(29161);
                        return;
                    }
                    dwv();
                    AppMethodBeat.m2505o(29161);
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
        return 2130969910;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(29162);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(1038, (C1202f) this);
        AppMethodBeat.m2505o(29162);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(29163);
        C4990ab.m7417i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            C30221rv c30221rv = (C30221rv) this.ehh.fsH.fsP;
            C4990ab.m7417i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", c30221rv.cMC, c30221rv.cMD);
            Intent intent = new Intent();
            intent.putExtra("key_card_id", r1);
            intent.putExtra("key_card_ext", r0);
            intent.putExtra("key_from_scene", 8);
            intent.putExtra("key_is_sms_add_card", true);
            C25985d.m41472c((Context) this, "card", ".ui.CardDetailUI", intent);
            finish();
            AppMethodBeat.m2505o(29163);
            return;
        }
        dwv();
        AppMethodBeat.m2505o(29163);
    }

    private void dwv() {
        AppMethodBeat.m2504i(29164);
        Toast.makeText(this, getString(C25738R.string.f0m), 1).show();
        LauncherUI.m59303ho(this);
        finish();
        AppMethodBeat.m2505o(29164);
    }
}
