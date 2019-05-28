package com.tencent.p177mm.p612ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.contact.C36246c.C30666a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.pluginsdk.p597ui.MultiSelectContactView.C35818a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C15430ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.SnsAddressUI */
public class SnsAddressUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private HashSet<String> gnG;

    /* renamed from: com.tencent.mm.ui.contact.SnsAddressUI$2 */
    class C239152 implements OnMenuItemClickListener {
        C239152() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33924);
            SnsAddressUI.this.finish();
            if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                SnsAddressUI.this.moveTaskToBack(true);
            }
            AppMethodBeat.m2505o(33924);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SnsAddressUI$3 */
    class C239163 implements C35818a {
        C239163() {
        }

        /* renamed from: vI */
        public final void mo7901vI(String str) {
            AppMethodBeat.m2504i(33925);
            if (str != null) {
                SnsAddressUI.this.gnG.remove(str);
                SnsAddressUI.m70777b(SnsAddressUI.this);
            }
            AppMethodBeat.m2505o(33925);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SnsAddressUI$1 */
    class C408401 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.ui.contact.SnsAddressUI$1$1 */
        class C408411 implements Runnable {
            C408411() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33922);
                if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    SnsAddressUI.this.moveTaskToBack(true);
                }
                AppMethodBeat.m2505o(33922);
            }
        }

        C408401() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33923);
            Intent intent = new Intent();
            List P = C5046bo.m7508P((String[]) SnsAddressUI.this.gnG.toArray(new String[0]));
            if (P == null || P.size() == 0) {
                intent.putExtra("Select_Contact", "");
            } else {
                intent.putExtra("Select_Contact", C5046bo.m7536c(P, ","));
            }
            SnsAddressUI.this.setResult(-1, intent);
            SnsAddressUI.this.finish();
            C5004al.m7442n(new C408411(), 100);
            SnsAddressUI.this.aqX();
            AppMethodBeat.m2505o(33923);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m70777b(SnsAddressUI snsAddressUI) {
        AppMethodBeat.m2504i(33937);
        snsAddressUI.m70775Kt();
        AppMethodBeat.m2505o(33937);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(33926);
        super.mo7850Kh();
        this.elZ = new ArrayList();
        ArrayList P = C5046bo.m7508P(C5046bo.m7532bc(getIntent().getStringExtra("Block_list"), "").split(","));
        HashSet dIf = C15830s.dIf();
        dIf.addAll(P);
        this.elZ.addAll(dIf);
        this.elZ.addAll(C15830s.dIg());
        this.gnG = new HashSet();
        String bc = C5046bo.m7532bc(getIntent().getStringExtra("Select_Contact"), "");
        if (!C5046bo.isNullOrNil(bc)) {
            this.gnG.addAll(C5046bo.m7508P(bc.split(",")));
        }
        AppMethodBeat.m2505o(33926);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33927);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.SnsAddressUI", "Create!");
        mo17379a(1, getString(C25738R.string.f9187s6), (OnMenuItemClickListener) new C408401(), C5535b.GREEN);
        setBackBtn(new C239152());
        Iterator it = this.gnG.iterator();
        while (it.hasNext()) {
            this.opo.ajq((String) it.next());
        }
        this.opo.setOnContactDeselectListener(new C239163());
        m70775Kt();
        AppMethodBeat.m2505o(33927);
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(33928);
        C36252n dHV = dHV();
        C5445a Pn = dHV.getItem(i - getContentLV().getHeaderViewsCount());
        if (Pn == null) {
            AppMethodBeat.m2505o(33928);
        } else if (Pn.ehM == null) {
            AppMethodBeat.m2505o(33928);
        } else {
            C4990ab.m7417i("MicroMsg.SnsAddressUI", "ClickUser=%s", Pn.ehM.field_username);
            String str = Pn.ehM.field_username;
            dIb();
            if (this.gnG.contains(str)) {
                this.gnG.remove(str);
                this.opo.ajq(str);
            } else if (this.gnG.size() < C15430ab.xID) {
                this.gnG.add(str);
                this.opo.ajq(str);
            } else {
                Toast.makeText(this, C25738R.string.emu, 0).show();
                C4990ab.m7417i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", Integer.valueOf(C15430ab.xID));
            }
            m70775Kt();
            dHV.notifyDataSetChanged();
            AppMethodBeat.m2505o(33928);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aow() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aox() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        AppMethodBeat.m2504i(33929);
        String bc = C5046bo.m7532bc(getIntent().getStringExtra("Add_address_titile"), "");
        AppMethodBeat.m2505o(33929);
        return bc;
    }

    /* Access modifiers changed, original: protected|final */
    public final C40845o aoz() {
        AppMethodBeat.m2504i(33930);
        C30666a c30666a = new C30666a();
        c30666a.zkR = true;
        c30666a.zkY = true;
        c30666a.zla = getString(C25738R.string.f8766ed);
        c30666a.zkZ = C5046bo.m7532bc(getIntent().getStringExtra("Add_get_from_sns"), "");
        c30666a.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        C36246c c36246c = new C36246c(this, this.elZ, true, c30666a);
        AppMethodBeat.m2505o(33930);
        return c36246c;
    }

    /* Access modifiers changed, original: protected|final */
    public final C36877m aoA() {
        AppMethodBeat.m2504i(33931);
        C23923q c23923q = new C23923q(this, this.elZ, true, this.scene);
        AppMethodBeat.m2505o(33931);
        return c23923q;
    }

    /* renamed from: Kt */
    private void m70775Kt() {
        String format;
        boolean z;
        AppMethodBeat.m2504i(33932);
        if (this.gnG.size() == 0) {
            format = String.format("%s", new Object[]{getString(C25738R.string.f9187s6)});
        } else {
            format = String.format("%s(%d/%d)", new Object[]{getString(C25738R.string.f9187s6), Integer.valueOf(this.gnG.size()), Integer.valueOf(C15430ab.xID)});
        }
        updateOptionMenuText(1, format);
        if (this.gnG.size() >= 0) {
            z = true;
        } else {
            z = false;
        }
        enableOptionMenu(1, z);
        AppMethodBeat.m2505o(33932);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.m2504i(33933);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(33933);
            return;
        }
        switch (i) {
            case 3:
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    C4990ab.m7417i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        Object obj = split[i3];
                        if (this.gnG.add(obj)) {
                            this.opo.ajq(obj);
                        }
                        i3++;
                    }
                    m70775Kt();
                    dHV().notifyDataSetChanged();
                    break;
                }
                C4990ab.m7416i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
                AppMethodBeat.m2505o(33933);
                return;
        }
        AppMethodBeat.m2505o(33933);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bOd() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: QA */
    public final void mo7896QA(String str) {
        AppMethodBeat.m2504i(33934);
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.gnG);
        intent.putExtra("always_select_contact", C5046bo.m7536c(new ArrayList(hashSet), ","));
        intent.putExtra("list_attr", C15830s.m24190C(16384, 64));
        startActivityForResult(intent, 3);
        AppMethodBeat.m2505o(33934);
    }

    public final int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    /* renamed from: vI */
    public final void mo7901vI(String str) {
        AppMethodBeat.m2504i(33936);
        this.gnG.remove(str);
        dHV().notifyDataSetChanged();
        m70775Kt();
        AppMethodBeat.m2505o(33936);
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(33935);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(33935);
            return false;
        }
        boolean contains = this.gnG.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(33935);
        return contains;
    }
}
