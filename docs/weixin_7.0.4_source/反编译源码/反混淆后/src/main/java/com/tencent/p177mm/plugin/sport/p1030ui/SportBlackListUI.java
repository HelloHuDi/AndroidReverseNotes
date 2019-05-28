package com.tencent.p177mm.plugin.sport.p1030ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference.C30100a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sport.ui.SportBlackListUI */
public class SportBlackListUI extends MMPreference {
    private ContactListExpandPreference ehS;
    private List<String> rPT;
    private C30100a rPU = new C292652();

    /* renamed from: com.tencent.mm.plugin.sport.ui.SportBlackListUI$1 */
    class C292641 implements OnMenuItemClickListener {
        C292641() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25136);
            SportBlackListUI.this.finish();
            AppMethodBeat.m2505o(25136);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sport.ui.SportBlackListUI$2 */
    class C292652 implements C30100a {
        C292652() {
        }

        /* renamed from: iA */
        public final void mo14654iA(int i) {
            AppMethodBeat.m2504i(25137);
            String KX = SportBlackListUI.this.ehS.mo48351KX(i);
            SportBlackListUI.this.rPT.remove(KX);
            SportBlackListUI.this.ehS.mo48371u(null, SportBlackListUI.this.rPT);
            SportBlackListUI.this.ehS.refresh();
            C9638aw.m17190ZK();
            C1855t.m3892h(C18628c.m29078XM().aoO(KX));
            C22162d.m33785kT(40);
            AppMethodBeat.m2505o(25137);
        }

        /* renamed from: iC */
        public final void mo14656iC(int i) {
            AppMethodBeat.m2504i(25138);
            SportBlackListUI.m46463c(SportBlackListUI.this);
            AppMethodBeat.m2505o(25138);
        }

        /* renamed from: iB */
        public final void mo14655iB(int i) {
            AppMethodBeat.m2504i(25139);
            String KX = SportBlackListUI.this.ehS.mo48351KX(i);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", KX);
            C25985d.m41467b(SportBlackListUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.m2505o(25139);
        }

        /* renamed from: JT */
        public final void mo14653JT() {
            AppMethodBeat.m2504i(25140);
            SportBlackListUI.this.ehS.djD();
            AppMethodBeat.m2505o(25140);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SportBlackListUI() {
        AppMethodBeat.m2504i(25141);
        AppMethodBeat.m2505o(25141);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25142);
        super.onCreate(bundle);
        C22162d.m33785kT(39);
        if (this.rPT == null) {
            this.rPT = new ArrayList();
        }
        C9638aw.m17190ZK();
        Cursor d = C18628c.m29078XM().mo15738d("@werun.black.android", "", null);
        while (d.moveToNext()) {
            this.rPT.add(d.getString(0));
        }
        d.close();
        this.ehS = (ContactListExpandPreference) this.yCw.aqO("black_contact_list_pref");
        this.ehS.mo48357a(this.yCw, this.ehS.mKey);
        this.ehS.mo48368oD(true).mo48369oE(true);
        this.ehS.mo48371u(null, this.rPT);
        this.ehS.mo48354a(this.rPU);
        this.ehS.setSummary((int) C25738R.string.bii);
        setMMTitle(getString(C25738R.string.bh7));
        setBackBtn(new C292641());
        AppMethodBeat.m2505o(25142);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8568cg;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(25143);
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            if (intent == null) {
                AppMethodBeat.m2505o(25143);
                return;
            }
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (C5046bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.m2505o(25143);
                return;
            }
            ArrayList<String> P = C5046bo.m7508P(stringExtra.split(","));
            if (P == null) {
                AppMethodBeat.m2505o(25143);
                return;
            }
            this.rPT.addAll(P);
            this.ehS.mo48371u(null, this.rPT);
            this.ehS.refresh();
            for (String stringExtra2 : P) {
                C9638aw.m17190ZK();
                C1855t.m3891g(C18628c.m29078XM().aoO(stringExtra2));
            }
        }
        AppMethodBeat.m2505o(25143);
    }

    /* renamed from: c */
    static /* synthetic */ void m46463c(SportBlackListUI sportBlackListUI) {
        AppMethodBeat.m2504i(25144);
        String c = C5046bo.m7536c(sportBlackListUI.rPT, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", sportBlackListUI.getString(C25738R.string.f8782eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", C15830s.m24190C(C15830s.znF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        intent.putExtra("always_select_contact", c);
        C25985d.m41466b((Context) sportBlackListUI, ".ui.contact.SelectContactUI", intent, 0);
        AppMethodBeat.m2505o(25144);
    }
}
