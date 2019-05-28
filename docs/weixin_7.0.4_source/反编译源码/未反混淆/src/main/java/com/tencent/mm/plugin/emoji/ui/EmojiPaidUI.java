package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public class EmojiPaidUI extends BaseEmojiStoreUI {
    private g[] lam;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53391);
        super.onCreate(bundle);
        h.pYm.e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(10), Integer.valueOf(10));
        AppMethodBeat.o(53391);
    }

    /* Access modifiers changed, original: protected|final */
    public final int aH(byte[] bArr) {
        AppMethodBeat.i(53392);
        int aH = super.aH(bArr);
        AppMethodBeat.o(53392);
        return aH;
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkV() {
        return 2;
    }

    public final void initView() {
        AppMethodBeat.i(53393);
        setMMTitle((int) R.string.b_m);
        if (r.YL()) {
            addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(53389);
                    EmojiPaidUI.a(EmojiPaidUI.this);
                    AppMethodBeat.o(53389);
                    return true;
                }
            });
        }
        super.initView();
        this.Ek.setVisibility(8);
        this.mListView.setVisibility(8);
        AppMethodBeat.o(53393);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkQ() {
    }

    public void onDestroy() {
        AppMethodBeat.i(53394);
        super.onDestroy();
        if (this.lam != null && this.lam.length > 0) {
            for (m c : this.lam) {
                com.tencent.mm.kernel.g.RO().eJo.c(c);
            }
        }
        AppMethodBeat.o(53394);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(g gVar) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53395);
        ab.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        blb();
        CharSequence charSequence = "";
        int intExtra;
        if (intent != null) {
            intExtra = intent.getIntExtra("key_err_code", 0);
            ab.w("MicroMsg.emoji.EmojiPaidUI", "errCode:".concat(String.valueOf(intExtra)));
            charSequence = intent.getStringExtra("key_err_msg");
            ab.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:".concat(String.valueOf(charSequence)));
        } else {
            intExtra = 0;
        }
        if (i2 != -1) {
            Toast.makeText(this, R.string.b_s, 0).show();
            AppMethodBeat.o(53395);
        } else if (intent == null || intExtra != 0) {
            Toast.makeText(this, charSequence, 0).show();
            AppMethodBeat.o(53395);
        } else {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                Toast.makeText(this, charSequence, 0).show();
                AppMethodBeat.o(53395);
                return;
            }
            this.kYe = null;
            this.kYc = -1;
            z(false, false);
            com.tencent.mm.kernel.g.RP().Ry().set(208900, Boolean.TRUE);
            Toast.makeText(this, R.string.b_t, 0).show();
            AppMethodBeat.o(53395);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(boolean z, f fVar, boolean z2, boolean z3) {
        AppMethodBeat.i(53396);
        if (!(fVar == null || !z || this.kVA == null)) {
            this.kVA.b(fVar);
        }
        if (this.kVA == null || fVar == null || fVar.kVp <= 0) {
            this.Ek.setVisibility(0);
            this.kYa.setText(R.string.b_j);
            this.mListView.setVisibility(8);
            AppMethodBeat.o(53396);
            return;
        }
        this.Ek.setVisibility(8);
        this.mListView.setVisibility(0);
        AppMethodBeat.o(53396);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkS() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final a bkO() {
        AppMethodBeat.i(53397);
        d dVar = new d(this.mController.ylL);
        AppMethodBeat.o(53397);
        return dVar;
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(53398);
        if (str != null && str.equals("event_update_group")) {
            blo();
            dS(131074, 50);
        }
        AppMethodBeat.o(53398);
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
