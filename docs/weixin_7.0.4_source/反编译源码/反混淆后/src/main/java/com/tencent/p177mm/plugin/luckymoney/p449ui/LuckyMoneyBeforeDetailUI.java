package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.luckymoney.model.C12425af;
import com.tencent.p177mm.plugin.luckymoney.model.C12428k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI */
public class LuckyMoneyBeforeDetailUI extends LuckyMoneyBaseUI {
    private Dialog gII;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI$1 */
    class C212131 implements Runnable {
        C212131() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42576);
            Intent intent = new Intent(LuckyMoneyBeforeDetailUI.this.mController.ylL, LuckyMoneyDetailUI.class);
            intent.putExtras(LuckyMoneyBeforeDetailUI.this.getIntent());
            LuckyMoneyBeforeDetailUI.this.startActivity(intent);
            LuckyMoneyBeforeDetailUI.this.finish();
            AppMethodBeat.m2505o(42576);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI$2 */
    class C212142 implements OnCancelListener {
        C212142() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42577);
            if (LuckyMoneyBeforeDetailUI.this.gII != null && LuckyMoneyBeforeDetailUI.this.gII.isShowing()) {
                LuckyMoneyBeforeDetailUI.this.gII.dismiss();
            }
            LuckyMoneyBeforeDetailUI.this.ocz.bLz();
            if (LuckyMoneyBeforeDetailUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyBeforeDetailUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyBeforeDetailUI", "user cancel & finish");
                LuckyMoneyBeforeDetailUI.this.finish();
            }
            AppMethodBeat.m2505o(42577);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        String queryParameter;
        AppMethodBeat.m2504i(42578);
        super.onCreate(bundle);
        overridePendingTransition(0, C25738R.anim.f8386cr);
        C5222ae.m7955m(this, getResources().getColor(C25738R.color.a3p));
        mo9439AM(8);
        String stringExtra = getIntent().getStringExtra("key_sendid");
        String stringExtra2 = getIntent().getStringExtra("key_native_url");
        int intExtra = getIntent().getIntExtra("key_jump_from", 2);
        C4990ab.m7416i("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid=" + C5046bo.nullAsNil(stringExtra) + ", nativeurl=" + C5046bo.nullAsNil(stringExtra2) + ", jumpFrom=" + intExtra);
        if (intExtra == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (!(byteArrayExtra == null || ((C12428k) new C12428k().parseFrom(byteArrayExtra)) == null)) {
                    m77031iJ(false);
                    AppMethodBeat.m2505o(42578);
                    return;
                }
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.LuckyMoneyBeforeDetailUI", "Parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (C5046bo.isNullOrNil(stringExtra) && !C5046bo.isNullOrNil(stringExtra2)) {
            try {
                queryParameter = Uri.parse(stringExtra2).getQueryParameter("sendid");
            } catch (Exception e2) {
            }
            if (C5046bo.isNullOrNil(queryParameter)) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyBeforeDetailUI", "get recordList");
                this.gII = C30379h.m48426a(this.mController.ylL, 3, (int) C25738R.style.f10970kd, getString(C25738R.string.cn5), true, new C212142());
                mo24301b(new C12425af(queryParameter, 11, 0, stringExtra2, "v1.0", ""), false);
                AppMethodBeat.m2505o(42578);
                return;
            }
            C4990ab.m7420w("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid null or nil, finish");
            finish();
            AppMethodBeat.m2505o(42578);
            return;
        }
        queryParameter = stringExtra;
        if (C5046bo.isNullOrNil(queryParameter)) {
        }
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42579);
        C4990ab.m7416i("MicroMsg.LuckyMoneyBeforeDetailUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + c1207m.getType());
        if (c1207m instanceof C12425af) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            if (i == 0 && i2 == 0) {
                C12425af c12425af = (C12425af) c1207m;
                try {
                    getIntent().putExtra("key_detail_info", c12425af.nYn.toByteArray());
                    getIntent().putExtra("key_process_content", c12425af.nYz);
                    getIntent().putExtra("key_detail_emoji_md5", c12425af.nYA);
                    getIntent().putExtra("key_detail_emoji_type", c12425af.nYB);
                    getIntent().putExtra("key_emoji_switch", c12425af.nYC);
                    m77031iJ(true);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.LuckyMoneyBeforeDetailUI", e, "", new Object[0]);
                    finish();
                }
                AppMethodBeat.m2505o(42579);
                return true;
            }
            C30379h.m48465bQ(this, str);
            finish();
            AppMethodBeat.m2505o(42579);
            return true;
        }
        AppMethodBeat.m2505o(42579);
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    public void finish() {
        AppMethodBeat.m2504i(42580);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(42580);
    }

    /* renamed from: iJ */
    private void m77031iJ(boolean z) {
        AppMethodBeat.m2504i(42581);
        C4990ab.m7416i("MicroMsg.LuckyMoneyBeforeDetailUI", "go to detail ui");
        C212131 c212131 = new C212131();
        if (z) {
            C5004al.m7442n(c212131, 100);
            AppMethodBeat.m2505o(42581);
            return;
        }
        c212131.run();
        AppMethodBeat.m2505o(42581);
    }
}
