package com.tencent.p177mm.plugin.masssend.p452ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.C23923q;
import com.tencent.p177mm.p612ui.contact.C36246c;
import com.tencent.p177mm.p612ui.contact.C36246c.C30666a;
import com.tencent.p177mm.p612ui.contact.C36252n;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.MultiSelectContactView;
import com.tencent.p177mm.pluginsdk.p597ui.MultiSelectContactView.C35818a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI */
public class MassSendSelectContactUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private HashSet<String> gnG;
    private Button opm;
    private boolean opn;
    private MultiSelectContactView opo;

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI$2 */
    class C34442 implements OnClickListener {
        C34442() {
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.m2504i(22875);
            C4990ab.m7416i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
            C36252n c36252n = (C36252n) ((HeaderViewListAdapter) MassSendSelectContactUI.this.getContentLV().getAdapter()).getWrappedAdapter();
            if (MassSendSelectContactUI.this.opn) {
                MassSendSelectContactUI.this.opm.setText(C25738R.string.cz3);
                Iterator it = MassSendSelectContactUI.this.gnG.iterator();
                while (it.hasNext()) {
                    MassSendSelectContactUI.this.opo.ajq((String) it.next());
                }
                MassSendSelectContactUI.this.gnG.clear();
            } else {
                MassSendSelectContactUI.this.opm.setText(C25738R.string.cyr);
                int count = c36252n.getCount();
                for (int i = 0; i < count; i++) {
                    C5445a Pn = c36252n.getItem(i);
                    if (!(Pn == null || Pn.ehM == null || MassSendSelectContactUI.this.gnG.contains(Pn.ehM.field_username))) {
                        MassSendSelectContactUI.this.gnG.add(Pn.ehM.field_username);
                        MassSendSelectContactUI.this.opo.ajq(Pn.ehM.field_username);
                    }
                }
            }
            MassSendSelectContactUI massSendSelectContactUI = MassSendSelectContactUI.this;
            if (MassSendSelectContactUI.this.opn) {
                z = false;
            } else {
                z = true;
            }
            massSendSelectContactUI.opn = z;
            MassSendSelectContactUI.m5722a(MassSendSelectContactUI.this, MassSendSelectContactUI.this.gnG.size());
            c36252n.notifyDataSetChanged();
            AppMethodBeat.m2505o(22875);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI$1 */
    class C34451 implements OnMenuItemClickListener {
        C34451() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22874);
            C4990ab.m7416i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
            List P = C5046bo.m7508P((String[]) MassSendSelectContactUI.this.gnG.toArray(new String[0]));
            if (P == null) {
                C4990ab.m7412e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
                AppMethodBeat.m2505o(22874);
                return false;
            }
            P.remove(C1853r.m3846Yz());
            String c = C5046bo.m7536c(P, ";");
            Intent intent = new Intent(MassSendSelectContactUI.this, MassSendMsgUI.class);
            intent.putExtra("mass_send_contact_list", c);
            MassSendSelectContactUI.this.startActivity(intent);
            AppMethodBeat.m2505o(22874);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI$3 */
    class C34463 implements C35818a {
        C34463() {
        }

        /* renamed from: vI */
        public final void mo7901vI(String str) {
            AppMethodBeat.m2504i(22876);
            if (str != null) {
                MassSendSelectContactUI.this.gnG.remove(str);
                MassSendSelectContactUI.m5722a(MassSendSelectContactUI.this, MassSendSelectContactUI.this.gnG.size());
            }
            AppMethodBeat.m2505o(22876);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(22877);
        super.mo7850Kh();
        this.elZ = new ArrayList();
        this.elZ.addAll(C15830s.dIf());
        this.elZ.addAll(C15830s.dIg());
        this.elZ.add(C1853r.m3846Yz());
        this.gnG = new HashSet();
        AppMethodBeat.m2505o(22877);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22878);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.MassSendSelectContactUI", "create!");
        this.opo = this.opo;
        if (this.opo == null) {
            finish();
            AppMethodBeat.m2505o(22878);
            return;
        }
        this.opo.setBackgroundDrawable(null);
        mo17379a(1, getString(C25738R.string.cz2), (OnMenuItemClickListener) new C34451(), C5535b.GREEN);
        this.opm = (Button) findViewById(2131825939);
        this.opm.setOnClickListener(new C34442());
        this.opo.setOnContactDeselectListener(new C34463());
        m5727yu(this.gnG.size());
        AppMethodBeat.m2505o(22878);
    }

    /* renamed from: yu */
    private void m5727yu(int i) {
        AppMethodBeat.m2504i(22879);
        if (i > 0) {
            updateOptionMenuText(1, getString(C25738R.string.cz2) + "(" + this.gnG.size() + ")");
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(22879);
            return;
        }
        updateOptionMenuText(1, getString(C25738R.string.cz2));
        enableOptionMenu(1, false);
        AppMethodBeat.m2505o(22879);
    }

    /* renamed from: QA */
    public final void mo7896QA(String str) {
        AppMethodBeat.m2504i(22880);
        C7060h.pYm.mo8381e(11225, Integer.valueOf(1), Integer.valueOf(0));
        Intent intent = new Intent();
        intent.putExtra("label", str);
        intent.putExtra("always_select_contact", C5046bo.m7536c(new ArrayList(this.gnG), ","));
        intent.putExtra("list_attr", C15830s.m24190C(16384, 64));
        C25985d.m41466b((Context) this, ".ui.contact.SelectLabelContactUI", intent, 0);
        AppMethodBeat.m2505o(22880);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.m2504i(22881);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            AppMethodBeat.m2505o(22881);
            return;
        }
        switch (i) {
            case 0:
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    C4990ab.m7417i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        Object obj = split[i3];
                        if (this.gnG.add(obj)) {
                            this.opo.ajq(obj);
                        }
                        i3++;
                    }
                    m5727yu(this.gnG.size());
                    dHV().notifyDataSetChanged();
                    if (this.elS != null) {
                        this.elS.clearFocus();
                        this.elS.dJS();
                        break;
                    }
                }
                C4990ab.m7416i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                AppMethodBeat.m2505o(22881);
                return;
                break;
        }
        AppMethodBeat.m2505o(22881);
    }

    public final int getLayoutId() {
        return 2130970077;
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(22882);
        C36252n dHV = dHV();
        C5445a Pn = dHV.getItem(i - getContentLV().getHeaderViewsCount());
        if (Pn == null) {
            AppMethodBeat.m2505o(22882);
        } else if (Pn.ehM == null) {
            AppMethodBeat.m2505o(22882);
        } else {
            C4990ab.m7417i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", Pn.ehM.field_username);
            String str = Pn.ehM.field_username;
            dIb();
            if (this.gnG.contains(str)) {
                this.gnG.remove(str);
                this.opo.ajq(str);
            } else {
                this.gnG.add(str);
                this.opo.ajq(str);
            }
            m5727yu(this.gnG.size());
            dHV.notifyDataSetChanged();
            dIb();
            dIc();
            AppMethodBeat.m2505o(22882);
        }
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return true;
    }

    public final String aoy() {
        AppMethodBeat.m2504i(22883);
        String string = getString(C25738R.string.cz4);
        AppMethodBeat.m2505o(22883);
        return string;
    }

    public final C40845o aoz() {
        AppMethodBeat.m2504i(22884);
        C30666a c30666a = new C30666a();
        c30666a.zkR = true;
        c30666a.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        C36246c c36246c = new C36246c(this, this.elZ, true, c30666a);
        AppMethodBeat.m2505o(22884);
        return c36246c;
    }

    public final C36877m aoA() {
        AppMethodBeat.m2504i(22885);
        C23923q c23923q = new C23923q(this, this.elZ, true, this.scene);
        AppMethodBeat.m2505o(22885);
        return c23923q;
    }

    public final int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public final boolean bOd() {
        return true;
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(22886);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(22886);
            return false;
        }
        boolean contains = this.gnG.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(22886);
        return contains;
    }
}
