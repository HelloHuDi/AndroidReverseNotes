package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@a(19)
public class SelectRemittanceContactUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private int fromScene;
    private View oiy;
    private List<String> pUw;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45171);
        super.onCreate(bundle);
        AppMethodBeat.o(45171);
    }

    public final void Kh() {
        AppMethodBeat.i(45172);
        super.Kh();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        String stringExtra = getIntent().getStringExtra("recent_remittance_contact_list");
        ab.v("MicroMsg.SelectRemittanceContactUI", "recent list:".concat(String.valueOf(stringExtra)));
        this.pUw = new ArrayList();
        if (!bo.isNullOrNil(stringExtra)) {
            this.pUw = bo.P(stringExtra.split(","));
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(s.dIf());
        hashSet.addAll(s.dIg());
        String stringExtra2 = getIntent().getStringExtra("Select_block_List");
        if (!bo.isNullOrNil(stringExtra2)) {
            hashSet.addAll(bo.P(stringExtra2.split(",")));
        }
        this.elZ = new ArrayList();
        this.elZ.addAll(hashSet);
        AppMethodBeat.o(45172);
    }

    public final o aoz() {
        AppMethodBeat.i(45173);
        g gVar = new g(this, this.pUw, this.elZ, this.fromScene);
        AppMethodBeat.o(45173);
        return gVar;
    }

    public final m aoA() {
        AppMethodBeat.i(45174);
        q qVar = new q(this, this.elZ, false, this.scene);
        AppMethodBeat.o(45174);
        return qVar;
    }

    public final int[] bMP() {
        if (this.fromScene == 1) {
            return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        }
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mO(int i) {
        AppMethodBeat.i(45175);
        int C;
        if (i < getContentLV().getHeaderViewsCount()) {
            ab.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", Integer.valueOf(i));
            ab.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            Intent intent = new Intent();
            if (this.fromScene == 1) {
                intent.putExtra("list_attr", s.C(s.znD, 16384, 64, 4096, 262144));
                intent.putExtra("min_limit_num", 1);
                intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
                intent.putExtra("titile", getString(R.string.fsz));
                intent.putExtra("without_openim", true);
            } else {
                C = s.C(16, 1, 2, 4, 16384);
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", C);
                intent.putExtra("titile", getString(R.string.dqe));
                intent.putExtra("sub_title", getString(R.string.fux));
            }
            d.b((Context) this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(R.anim.cg, R.anim.b6);
            AppMethodBeat.o(45175);
            return;
        }
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) getContentLV().getAdapter().getItem(i);
        if (aVar == null) {
            AppMethodBeat.o(45175);
            return;
        }
        ad adVar = aVar.ehM;
        if (adVar == null) {
            AppMethodBeat.o(45175);
            return;
        }
        ab.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", adVar.field_username);
        Intent intent2 = new Intent();
        intent2.putExtra("Select_Conv_User", r0);
        setResult(-1, intent2);
        finish();
        aqX();
        if (dHV() instanceof g) {
            int i2;
            C = i - getContentLV().getHeaderViewsCount();
            g gVar = (g) dHV();
            ab.d("MicroMsg.RecentConversationAdapter", "pos: %s", Integer.valueOf(C));
            if (gVar.pUu >= 0) {
                if (gVar.pUv < 0) {
                    i2 = 1;
                } else if (C > gVar.pUu && C < gVar.pUv) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    h.pYm.e(13721, Integer.valueOf(6), Integer.valueOf(1));
                }
            }
            i2 = 0;
            if (i2 != 0) {
            }
        }
        AppMethodBeat.o(45175);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45176);
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
            AppMethodBeat.o(45176);
            return;
        }
        ab.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
        AppMethodBeat.o(45176);
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.i(45177);
        String string;
        if (this.fromScene == 1) {
            string = getString(R.string.fsx);
            AppMethodBeat.o(45177);
            return string;
        }
        string = getString(R.string.dqi);
        AppMethodBeat.o(45177);
        return string;
    }

    public final void a(ListView listView, int i) {
        AppMethodBeat.i(45178);
        super.a(listView, i);
        if (this.oiy == null) {
            View inflate = View.inflate(this, R.layout.aqi, null);
            this.oiy = inflate.findViewById(R.id.m5);
            TextView textView = (TextView) inflate.findViewById(R.id.n0);
            if (this.fromScene == 1) {
                textView.setText(R.string.fsv);
            } else {
                textView.setText(R.string.dpg);
            }
            listView.addHeaderView(inflate);
        }
        this.oiy.setVisibility(i);
        AppMethodBeat.o(45178);
    }

    public final void bMQ() {
        AppMethodBeat.i(45179);
        super.bMQ();
        aqX();
        AppMethodBeat.o(45179);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(45180);
        if (keyEvent.getKeyCode() == 4) {
            AppMethodBeat.o(45180);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(45180);
        return onKeyDown;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(45181);
        if (i == 4) {
            bMQ();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(45181);
        return onKeyUp;
    }
}
