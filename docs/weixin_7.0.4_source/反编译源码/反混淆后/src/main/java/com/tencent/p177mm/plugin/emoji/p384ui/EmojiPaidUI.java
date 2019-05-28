package com.tencent.p177mm.plugin.emoji.p384ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.p381a.C2927d;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiPaidUI */
public class EmojiPaidUI extends BaseEmojiStoreUI {
    private C42945g[] lam;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiPaidUI$1 */
    class C339701 implements OnMenuItemClickListener {
        C339701() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53389);
            EmojiPaidUI.m55602a(EmojiPaidUI.this);
            AppMethodBeat.m2505o(53389);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiPaidUI$2 */
    class C339712 implements C30391c {
        C339712() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(53390);
            switch (i) {
                case 0:
                    Intent intent = new Intent();
                    intent.putExtra("key_action_type", 200002);
                    C25985d.m41468b(EmojiPaidUI.this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                    C4990ab.m7416i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
                    EmojiPaidUI.this.aoW();
                    break;
            }
            AppMethodBeat.m2505o(53390);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53391);
        super.onCreate(bundle);
        C7060h.pYm.mo8381e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(10), Integer.valueOf(10));
        AppMethodBeat.m2505o(53391);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aH */
    public final int mo30708aH(byte[] bArr) {
        AppMethodBeat.m2504i(53392);
        int aH = super.mo30708aH(bArr);
        AppMethodBeat.m2505o(53392);
        return aH;
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkV() {
        return 2;
    }

    public final void initView() {
        AppMethodBeat.m2504i(53393);
        setMMTitle((int) C25738R.string.b_m);
        if (C1853r.m3830YL()) {
            addIconOptionMenu(0, C25738R.drawable.f6899uu, new C339701());
        }
        super.initView();
        this.f3573Ek.setVisibility(8);
        this.mListView.setVisibility(8);
        AppMethodBeat.m2505o(53393);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkQ() {
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53394);
        super.onDestroy();
        if (this.lam != null && this.lam.length > 0) {
            for (C1207m c : this.lam) {
                C1720g.m3535RO().eJo.mo14547c(c);
            }
        }
        AppMethodBeat.m2505o(53394);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo30705a(C42945g c42945g) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53395);
        C4990ab.m7416i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        blb();
        CharSequence charSequence = "";
        int intExtra;
        if (intent != null) {
            intExtra = intent.getIntExtra("key_err_code", 0);
            C4990ab.m7420w("MicroMsg.emoji.EmojiPaidUI", "errCode:".concat(String.valueOf(intExtra)));
            charSequence = intent.getStringExtra("key_err_msg");
            C4990ab.m7420w("MicroMsg.emoji.EmojiPaidUI", "errMsg:".concat(String.valueOf(charSequence)));
        } else {
            intExtra = 0;
        }
        if (i2 != -1) {
            Toast.makeText(this, C25738R.string.b_s, 0).show();
            AppMethodBeat.m2505o(53395);
        } else if (intent == null || intExtra != 0) {
            Toast.makeText(this, charSequence, 0).show();
            AppMethodBeat.m2505o(53395);
        } else {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                Toast.makeText(this, charSequence, 0).show();
                AppMethodBeat.m2505o(53395);
                return;
            }
            this.kYe = null;
            this.kYc = -1;
            mo30736z(false, false);
            C1720g.m3536RP().mo5239Ry().set(208900, Boolean.TRUE);
            Toast.makeText(this, C25738R.string.b_t, 0).show();
            AppMethodBeat.m2505o(53395);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo30707a(boolean z, C20383f c20383f, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(53396);
        if (!(c20383f == null || !z || this.kVA == null)) {
            this.kVA.mo54490b(c20383f);
        }
        if (this.kVA == null || c20383f == null || c20383f.kVp <= 0) {
            this.f3573Ek.setVisibility(0);
            this.kYa.setText(C25738R.string.b_j);
            this.mListView.setVisibility(8);
            AppMethodBeat.m2505o(53396);
            return;
        }
        this.f3573Ek.setVisibility(8);
        this.mListView.setVisibility(0);
        AppMethodBeat.m2505o(53396);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkS() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final C33944a bkO() {
        AppMethodBeat.m2504i(53397);
        C2927d c2927d = new C2927d(this.mController.ylL);
        AppMethodBeat.m2505o(53397);
        return c2927d;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(53398);
        if (str != null && str.equals("event_update_group")) {
            blo();
            mo45578dS(131074, 50);
        }
        AppMethodBeat.m2505o(53398);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkM() {
        return 10;
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkN() {
        return 6;
    }
}
