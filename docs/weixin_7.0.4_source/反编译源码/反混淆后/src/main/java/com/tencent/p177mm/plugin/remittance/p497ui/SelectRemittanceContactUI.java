package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.C23923q;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI */
public class SelectRemittanceContactUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private int fromScene;
    private View oiy;
    private List<String> pUw;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45171);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(45171);
    }

    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(45172);
        super.mo7850Kh();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        String stringExtra = getIntent().getStringExtra("recent_remittance_contact_list");
        C4990ab.m7418v("MicroMsg.SelectRemittanceContactUI", "recent list:".concat(String.valueOf(stringExtra)));
        this.pUw = new ArrayList();
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.pUw = C5046bo.m7508P(stringExtra.split(","));
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(C15830s.dIf());
        hashSet.addAll(C15830s.dIg());
        String stringExtra2 = getIntent().getStringExtra("Select_block_List");
        if (!C5046bo.isNullOrNil(stringExtra2)) {
            hashSet.addAll(C5046bo.m7508P(stringExtra2.split(",")));
        }
        this.elZ = new ArrayList();
        this.elZ.addAll(hashSet);
        AppMethodBeat.m2505o(45172);
    }

    public final C40845o aoz() {
        AppMethodBeat.m2504i(45173);
        C41305g c41305g = new C41305g(this, this.pUw, this.elZ, this.fromScene);
        AppMethodBeat.m2505o(45173);
        return c41305g;
    }

    public final C36877m aoA() {
        AppMethodBeat.m2504i(45174);
        C23923q c23923q = new C23923q(this, this.elZ, false, this.scene);
        AppMethodBeat.m2505o(45174);
        return c23923q;
    }

    public final int[] bMP() {
        if (this.fromScene == 1) {
            return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        }
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(45175);
        int C;
        if (i < getContentLV().getHeaderViewsCount()) {
            C4990ab.m7417i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", Integer.valueOf(i));
            C4990ab.m7416i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            Intent intent = new Intent();
            if (this.fromScene == 1) {
                intent.putExtra("list_attr", C15830s.m24190C(C15830s.znD, 16384, 64, 4096, 262144));
                intent.putExtra("min_limit_num", 1);
                intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
                intent.putExtra("titile", getString(C25738R.string.fsz));
                intent.putExtra("without_openim", true);
            } else {
                C = C15830s.m24190C(16, 1, 2, 4, 16384);
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", C);
                intent.putExtra("titile", getString(C25738R.string.dqe));
                intent.putExtra("sub_title", getString(C25738R.string.fux));
            }
            C25985d.m41466b((Context) this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
            AppMethodBeat.m2505o(45175);
            return;
        }
        C5445a c5445a = (C5445a) getContentLV().getAdapter().getItem(i);
        if (c5445a == null) {
            AppMethodBeat.m2505o(45175);
            return;
        }
        C7616ad c7616ad = c5445a.ehM;
        if (c7616ad == null) {
            AppMethodBeat.m2505o(45175);
            return;
        }
        C4990ab.m7417i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", c7616ad.field_username);
        Intent intent2 = new Intent();
        intent2.putExtra("Select_Conv_User", r0);
        setResult(-1, intent2);
        finish();
        aqX();
        if (dHV() instanceof C41305g) {
            int i2;
            C = i - getContentLV().getHeaderViewsCount();
            C41305g c41305g = (C41305g) dHV();
            C4990ab.m7411d("MicroMsg.RecentConversationAdapter", "pos: %s", Integer.valueOf(C));
            if (c41305g.pUu >= 0) {
                if (c41305g.pUv < 0) {
                    i2 = 1;
                } else if (C > c41305g.pUu && C < c41305g.pUv) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    C7060h.pYm.mo8381e(13721, Integer.valueOf(6), Integer.valueOf(1));
                }
            }
            i2 = 0;
            if (i2 != 0) {
            }
        }
        AppMethodBeat.m2505o(45175);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45176);
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            C4990ab.m7416i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            C4990ab.m7416i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i == 1) {
            if (i2 == -1) {
                C4990ab.m7416i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
                setResult(-1, intent);
                finish();
            }
            AppMethodBeat.m2505o(45176);
            return;
        }
        C4990ab.m7412e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(45176);
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.m2504i(45177);
        String string;
        if (this.fromScene == 1) {
            string = getString(C25738R.string.fsx);
            AppMethodBeat.m2505o(45177);
            return string;
        }
        string = getString(C25738R.string.dqi);
        AppMethodBeat.m2505o(45177);
        return string;
    }

    /* renamed from: a */
    public final void mo7851a(ListView listView, int i) {
        AppMethodBeat.m2504i(45178);
        super.mo7851a(listView, i);
        if (this.oiy == null) {
            View inflate = View.inflate(this, 2130970587, null);
            this.oiy = inflate.findViewById(2131821019);
            TextView textView = (TextView) inflate.findViewById(2131821051);
            if (this.fromScene == 1) {
                textView.setText(C25738R.string.fsv);
            } else {
                textView.setText(C25738R.string.dpg);
            }
            listView.addHeaderView(inflate);
        }
        this.oiy.setVisibility(i);
        AppMethodBeat.m2505o(45178);
    }

    public final void bMQ() {
        AppMethodBeat.m2504i(45179);
        super.bMQ();
        aqX();
        AppMethodBeat.m2505o(45179);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(45180);
        if (keyEvent.getKeyCode() == 4) {
            AppMethodBeat.m2505o(45180);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(45180);
        return onKeyDown;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(45181);
        if (i == 4) {
            bMQ();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(45181);
        return onKeyUp;
    }
}
