package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private View oiy;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void Kh() {
        AppMethodBeat.i(43077);
        super.Kh();
        HashSet hashSet = new HashSet();
        hashSet.addAll(s.dIf());
        hashSet.addAll(s.dIg());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!bo.isNullOrNil(stringExtra)) {
            hashSet.addAll(bo.P(stringExtra.split(",")));
        }
        this.elZ = new ArrayList();
        this.elZ.addAll(hashSet);
        AppMethodBeat.o(43077);
    }

    public final void mO(int i) {
        AppMethodBeat.i(43078);
        if (i < getContentLV().getHeaderViewsCount()) {
            ab.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", Integer.valueOf(i));
            ab.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            int intExtra = getIntent().getIntExtra("key_friends_num", 0);
            Intent intent = new Intent();
            int C = s.C(16, 1, 2, 4, 16384, 64, 65536, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", C);
            intent.putExtra("max_limit_num", intExtra);
            intent.putExtra("titile", getString(R.string.csx, new Object[]{Integer.valueOf(intExtra)}));
            intent.putExtra("sub_title", getString(R.string.g0q));
            d.b((Context) this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(R.anim.cg, R.anim.b6);
            AppMethodBeat.o(43078);
            return;
        }
        a aVar = (a) getContentLV().getAdapter().getItem(i);
        if (aVar == null) {
            AppMethodBeat.o(43078);
            return;
        }
        ad adVar = aVar.ehM;
        if (adVar == null) {
            AppMethodBeat.o(43078);
            return;
        }
        String str = adVar.field_username;
        ab.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", str);
        final Intent intent2 = new Intent();
        intent2.putExtra("Select_Conv_User", str);
        String str2 = null;
        if (t.kH(str)) {
            str2 = getString(R.string.fsu, new Object[]{Integer.valueOf(n.mA(str))});
        }
        ((i) g.K(i.class)).a(this.mController, str, getString(R.string.dr7), str, str2, getString(R.string.tf), new q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(43076);
                if (z) {
                    SelectLuckyMoneyContactUI.this.setResult(-1, intent2);
                    SelectLuckyMoneyContactUI.this.finish();
                }
                AppMethodBeat.o(43076);
            }
        });
        AppMethodBeat.o(43078);
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.i(43079);
        String string = getString(R.string.csy);
        AppMethodBeat.o(43079);
        return string;
    }

    public final o aoz() {
        AppMethodBeat.i(43080);
        x xVar = new x(this, this.elZ);
        AppMethodBeat.o(43080);
        return xVar;
    }

    public final m aoA() {
        AppMethodBeat.i(43081);
        com.tencent.mm.ui.contact.q qVar = new com.tencent.mm.ui.contact.q(this, this.elZ, false, this.scene);
        AppMethodBeat.o(43081);
        return qVar;
    }

    public final int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public final void a(ListView listView, int i) {
        AppMethodBeat.i(43082);
        super.a(listView, i);
        if (this.oiy == null) {
            View inflate = View.inflate(this, R.layout.aqi, null);
            this.oiy = inflate.findViewById(R.id.m5);
            ((TextView) inflate.findViewById(R.id.n0)).setText(R.string.cr5);
            listView.addHeaderView(inflate);
        }
        this.oiy.setVisibility(i);
        AppMethodBeat.o(43082);
    }

    public final void bMQ() {
        AppMethodBeat.i(43083);
        super.bMQ();
        aqX();
        AppMethodBeat.o(43083);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(43084);
        if (i == 4) {
            bMQ();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(43084);
        return onKeyUp;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(43085);
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            ab.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            ab.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i == 1) {
            if (i2 == -1) {
                ab.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
                setResult(-1, intent);
                finish();
            }
            AppMethodBeat.o(43085);
            return;
        }
        ab.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
        AppMethodBeat.o(43085);
    }
}
