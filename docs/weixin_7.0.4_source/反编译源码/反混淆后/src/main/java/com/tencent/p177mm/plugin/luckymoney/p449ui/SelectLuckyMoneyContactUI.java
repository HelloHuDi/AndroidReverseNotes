package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.C23923q;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.C41349x;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI */
public class SelectLuckyMoneyContactUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private View oiy;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(43077);
        super.mo7850Kh();
        HashSet hashSet = new HashSet();
        hashSet.addAll(C15830s.dIf());
        hashSet.addAll(C15830s.dIg());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            hashSet.addAll(C5046bo.m7508P(stringExtra.split(",")));
        }
        this.elZ = new ArrayList();
        this.elZ.addAll(hashSet);
        AppMethodBeat.m2505o(43077);
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(43078);
        if (i < getContentLV().getHeaderViewsCount()) {
            C4990ab.m7417i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", Integer.valueOf(i));
            C4990ab.m7416i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            int intExtra = getIntent().getIntExtra("key_friends_num", 0);
            Intent intent = new Intent();
            int C = C15830s.m24190C(16, 1, 2, 4, 16384, 64, 65536, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", C);
            intent.putExtra("max_limit_num", intExtra);
            intent.putExtra("titile", getString(C25738R.string.csx, new Object[]{Integer.valueOf(intExtra)}));
            intent.putExtra("sub_title", getString(C25738R.string.g0q));
            C25985d.m41466b((Context) this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
            AppMethodBeat.m2505o(43078);
            return;
        }
        C5445a c5445a = (C5445a) getContentLV().getAdapter().getItem(i);
        if (c5445a == null) {
            AppMethodBeat.m2505o(43078);
            return;
        }
        C7616ad c7616ad = c5445a.ehM;
        if (c7616ad == null) {
            AppMethodBeat.m2505o(43078);
            return;
        }
        String str = c7616ad.field_username;
        C4990ab.m7417i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", str);
        final Intent intent2 = new Intent();
        intent2.putExtra("Select_Conv_User", str);
        String str2 = null;
        if (C1855t.m3896kH(str)) {
            str2 = getString(C25738R.string.fsu, new Object[]{Integer.valueOf(C37921n.m64060mA(str))});
        }
        ((C40437i) C1720g.m3528K(C40437i.class)).mo56643a(this.mController, str, getString(C25738R.string.dr7), str, str2, getString(C25738R.string.f9221tf), new C30111a() {
            /* renamed from: a */
            public final void mo6399a(boolean z, String str, int i) {
                AppMethodBeat.m2504i(43076);
                if (z) {
                    SelectLuckyMoneyContactUI.this.setResult(-1, intent2);
                    SelectLuckyMoneyContactUI.this.finish();
                }
                AppMethodBeat.m2505o(43076);
            }
        });
        AppMethodBeat.m2505o(43078);
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.m2504i(43079);
        String string = getString(C25738R.string.csy);
        AppMethodBeat.m2505o(43079);
        return string;
    }

    public final C40845o aoz() {
        AppMethodBeat.m2504i(43080);
        C41349x c41349x = new C41349x(this, this.elZ);
        AppMethodBeat.m2505o(43080);
        return c41349x;
    }

    public final C36877m aoA() {
        AppMethodBeat.m2504i(43081);
        C23923q c23923q = new C23923q(this, this.elZ, false, this.scene);
        AppMethodBeat.m2505o(43081);
        return c23923q;
    }

    public final int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    /* renamed from: a */
    public final void mo7851a(ListView listView, int i) {
        AppMethodBeat.m2504i(43082);
        super.mo7851a(listView, i);
        if (this.oiy == null) {
            View inflate = View.inflate(this, 2130970587, null);
            this.oiy = inflate.findViewById(2131821019);
            ((TextView) inflate.findViewById(2131821051)).setText(C25738R.string.cr5);
            listView.addHeaderView(inflate);
        }
        this.oiy.setVisibility(i);
        AppMethodBeat.m2505o(43082);
    }

    public final void bMQ() {
        AppMethodBeat.m2504i(43083);
        super.bMQ();
        aqX();
        AppMethodBeat.m2505o(43083);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(43084);
        if (i == 4) {
            bMQ();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(43084);
        return onKeyUp;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(43085);
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
            AppMethodBeat.m2505o(43085);
            return;
        }
        C4990ab.m7412e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(43085);
    }
}
