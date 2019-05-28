package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

@a(3)
public class LuckyMoneyBeforeDetailUI extends LuckyMoneyBaseUI {
    private Dialog gII;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        String queryParameter;
        AppMethodBeat.i(42578);
        super.onCreate(bundle);
        overridePendingTransition(0, R.anim.cr);
        ae.m(this, getResources().getColor(R.color.a3p));
        AM(8);
        String stringExtra = getIntent().getStringExtra("key_sendid");
        String stringExtra2 = getIntent().getStringExtra("key_native_url");
        int intExtra = getIntent().getIntExtra("key_jump_from", 2);
        ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid=" + bo.nullAsNil(stringExtra) + ", nativeurl=" + bo.nullAsNil(stringExtra2) + ", jumpFrom=" + intExtra);
        if (intExtra == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (!(byteArrayExtra == null || ((k) new k().parseFrom(byteArrayExtra)) == null)) {
                    iJ(false);
                    AppMethodBeat.o(42578);
                    return;
                }
            } catch (Exception e) {
                ab.w("MicroMsg.LuckyMoneyBeforeDetailUI", "Parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bo.isNullOrNil(stringExtra) && !bo.isNullOrNil(stringExtra2)) {
            try {
                queryParameter = Uri.parse(stringExtra2).getQueryParameter("sendid");
            } catch (Exception e2) {
            }
            if (bo.isNullOrNil(queryParameter)) {
                ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "get recordList");
                this.gII = h.a(this.mController.ylL, 3, (int) R.style.kd, getString(R.string.cn5), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(42577);
                        if (LuckyMoneyBeforeDetailUI.this.gII != null && LuckyMoneyBeforeDetailUI.this.gII.isShowing()) {
                            LuckyMoneyBeforeDetailUI.this.gII.dismiss();
                        }
                        LuckyMoneyBeforeDetailUI.this.ocz.bLz();
                        if (LuckyMoneyBeforeDetailUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyBeforeDetailUI.this.mController.contentView.getVisibility() == 4) {
                            ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "user cancel & finish");
                            LuckyMoneyBeforeDetailUI.this.finish();
                        }
                        AppMethodBeat.o(42577);
                    }
                });
                b(new af(queryParameter, 11, 0, stringExtra2, "v1.0", ""), false);
                AppMethodBeat.o(42578);
                return;
            }
            ab.w("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid null or nil, finish");
            finish();
            AppMethodBeat.o(42578);
            return;
        }
        queryParameter = stringExtra;
        if (bo.isNullOrNil(queryParameter)) {
        }
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42579);
        ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + mVar.getType());
        if (mVar instanceof af) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            if (i == 0 && i2 == 0) {
                af afVar = (af) mVar;
                try {
                    getIntent().putExtra("key_detail_info", afVar.nYn.toByteArray());
                    getIntent().putExtra("key_process_content", afVar.nYz);
                    getIntent().putExtra("key_detail_emoji_md5", afVar.nYA);
                    getIntent().putExtra("key_detail_emoji_type", afVar.nYB);
                    getIntent().putExtra("key_emoji_switch", afVar.nYC);
                    iJ(true);
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.LuckyMoneyBeforeDetailUI", e, "", new Object[0]);
                    finish();
                }
                AppMethodBeat.o(42579);
                return true;
            }
            h.bQ(this, str);
            finish();
            AppMethodBeat.o(42579);
            return true;
        }
        AppMethodBeat.o(42579);
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    public void finish() {
        AppMethodBeat.i(42580);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(42580);
    }

    private void iJ(boolean z) {
        AppMethodBeat.i(42581);
        ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "go to detail ui");
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(42576);
                Intent intent = new Intent(LuckyMoneyBeforeDetailUI.this.mController.ylL, LuckyMoneyDetailUI.class);
                intent.putExtras(LuckyMoneyBeforeDetailUI.this.getIntent());
                LuckyMoneyBeforeDetailUI.this.startActivity(intent);
                LuckyMoneyBeforeDetailUI.this.finish();
                AppMethodBeat.o(42576);
            }
        };
        if (z) {
            al.n(anonymousClass1, 100);
            AppMethodBeat.o(42581);
            return;
        }
        anonymousClass1.run();
        AppMethodBeat.o(42581);
    }
}
