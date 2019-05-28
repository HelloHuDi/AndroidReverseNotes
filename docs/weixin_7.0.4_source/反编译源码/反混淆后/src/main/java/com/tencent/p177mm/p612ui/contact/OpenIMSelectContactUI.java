package com.tencent.p177mm.p612ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.contact.SelectContactUI.C15803a;
import com.tencent.p177mm.p612ui.contact.p625a.C46674k;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.OpenIMSelectContactUI */
public class OpenIMSelectContactUI extends MMBaseSelectContactUI {
    private String csB;
    private List<String> elZ;
    private HashSet<String> gnG;
    private String title;
    private int zkf;
    private HashSet<String> zol;
    private HashSet<String> zom;
    private int zon;
    private boolean zoo = true;
    private C15803a zop = new C15803a();

    /* renamed from: com.tencent.mm.ui.contact.OpenIMSelectContactUI$1 */
    class C239111 implements OnMenuItemClickListener {
        C239111() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33824);
            ArrayList a = OpenIMSelectContactUI.m39100a(OpenIMSelectContactUI.this, C15830s.m24192hr(OpenIMSelectContactUI.this.zon, Utility.DEFAULT_STREAM_BUFFER_SIZE));
            a.remove(C1853r.m3846Yz());
            ArrayList arrayList = new ArrayList(OpenIMSelectContactUI.this.zom);
            arrayList.removeAll(a);
            boolean a2 = OpenIMSelectContactUI.m39101a(OpenIMSelectContactUI.this, a, arrayList);
            AppMethodBeat.m2505o(33824);
            return a2;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.OpenIMSelectContactUI$2 */
    class C249692 implements OnClickListener {
        C249692() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public OpenIMSelectContactUI() {
        AppMethodBeat.m2504i(33825);
        AppMethodBeat.m2505o(33825);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m39101a(OpenIMSelectContactUI openIMSelectContactUI, List list, List list2) {
        AppMethodBeat.m2504i(33839);
        boolean q = openIMSelectContactUI.m39103q(list, list2);
        AppMethodBeat.m2505o(33839);
        return q;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33826);
        super.onCreate(bundle);
        if (C15830s.m24192hr(this.zon, 64)) {
            mo17379a(1, getString(C25738R.string.f9187s6), (OnMenuItemClickListener) new C239111(), C5535b.GREEN);
        }
        m39098Kt();
        Iterator it = this.gnG.iterator();
        while (it.hasNext()) {
            ajq((String) it.next());
        }
        AppMethodBeat.m2505o(33826);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(33827);
        super.mo7850Kh();
        this.csB = getIntent().getStringExtra("openim_appid");
        this.title = getIntent().getStringExtra("titile");
        this.zkf = getIntent().getIntExtra("list_type", -1);
        this.zon = getIntent().getIntExtra("list_attr", C15830s.znD);
        this.elZ = new ArrayList();
        this.gnG = new HashSet();
        this.zom = new HashSet();
        this.zol = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.zol.addAll(C5046bo.m7508P(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.gnG.addAll(C5046bo.m7508P(stringExtra.split(",")));
            this.zom.addAll(this.gnG);
        }
        HashSet hashSet = new HashSet();
        String stringExtra2 = getIntent().getStringExtra("block_contact");
        if (!C5046bo.isNullOrNil(stringExtra2)) {
            hashSet.addAll(C5046bo.m7508P(stringExtra2.split(",")));
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(C15830s.dIf());
        hashSet2.addAll(C15830s.dIg());
        this.elZ.addAll(hashSet2);
        AppMethodBeat.m2505o(33827);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aow() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aox() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        AppMethodBeat.m2504i(33828);
        if (C5046bo.isNullOrNil(this.title)) {
            this.title = ((C32873b) C1720g.m3528K(C32873b.class)).mo44300a(this.csB, "openim_acct_type_title", C32874a.TYPE_WORDING);
        }
        String str = this.title;
        AppMethodBeat.m2505o(33828);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final C40845o aoz() {
        AppMethodBeat.m2504i(33829);
        C46676w c46676w = new C46676w(this.csB, this, this.elZ, C15830s.m24192hr(this.zon, 64));
        AppMethodBeat.m2505o(33829);
        return c46676w;
    }

    /* Access modifiers changed, original: protected|final */
    public final C36877m aoA() {
        AppMethodBeat.m2504i(33830);
        C23923q c23923q = new C23923q(this, this.elZ, C15830s.m24192hr(this.zon, 64), this.scene);
        AppMethodBeat.m2505o(33830);
        return c23923q;
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(33831);
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        if (headerViewsCount < 0) {
            C4990ab.m7417i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i));
            AppMethodBeat.m2505o(33831);
            return;
        }
        C5445a Pn = dHV().getItem(headerViewsCount);
        if (Pn == null) {
            AppMethodBeat.m2505o(33831);
        } else if (Pn.ehM == null) {
            AppMethodBeat.m2505o(33831);
        } else if (Pn.ehM.field_deleteFlag == 1) {
            AppMethodBeat.m2505o(33831);
        } else {
            String str = Pn.ehM.field_username;
            C4990ab.m7417i("OpenIMSelectContactUI", "ClickUser=%s", str);
            if (C15830s.m24192hr(this.zon, 64)) {
                if (!C15830s.m24192hr(this.zon, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.gnG.size() < getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER)) {
                    if (!this.zol.contains(str)) {
                        dIb();
                        ajq(str);
                        if (this.gnG.contains(str)) {
                            this.gnG.remove(str);
                        } else {
                            this.gnG.add(str);
                        }
                    }
                } else if (!this.zol.contains(str)) {
                    dIb();
                    if (this.gnG.contains(str)) {
                        ajq(str);
                        this.gnG.remove(str);
                    } else {
                        str = getIntent().getStringExtra("too_many_member_tip_string");
                        if (C5046bo.isNullOrNil(str)) {
                            str = getString(C25738R.string.e1m, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        C30379h.m48438a(this.mController.ylL, str, getString(C25738R.string.f9213t6), new C249692());
                    }
                }
                m39098Kt();
                if (this.zoo && (this.zkf == 1 || this.zkf == 0)) {
                    headerViewsCount = this.zol != null ? this.zol.size() : 0;
                    if (this.gnG != null) {
                        i2 = this.gnG.size();
                    }
                    this.zop.mo28016e(this, headerViewsCount + i2, C5046bo.ank(C26373g.m41964Nu().getValue("ChatRoomInviteStartCount")));
                }
                dHW().notifyDataSetChanged();
                AppMethodBeat.m2505o(33831);
                return;
            }
            m39103q(C5046bo.m7508P(new String[]{str}), new ArrayList(0));
            AppMethodBeat.m2505o(33831);
        }
    }

    /* renamed from: Kt */
    private void m39098Kt() {
        AppMethodBeat.m2504i(33832);
        if (!C15830s.m24192hr(this.zon, 64) || this.gnG.size() <= 0) {
            updateOptionMenuText(1, getString(C25738R.string.f9077ot));
            enableOptionMenu(1, false);
            AppMethodBeat.m2505o(33832);
            return;
        }
        updateOptionMenuText(1, getString(C25738R.string.f9077ot) + "(" + this.gnG.size() + ")");
        int intExtra = getIntent().getIntExtra("min_limit_num", 0);
        if (!C15830s.m24192hr(this.zon, 262144) || this.gnG.size() >= intExtra) {
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(33832);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.m2505o(33832);
    }

    private void ajq(String str) {
        AppMethodBeat.m2504i(33833);
        if (this.opo == null) {
            AppMethodBeat.m2505o(33833);
            return;
        }
        this.opo.ajq(str);
        AppMethodBeat.m2505o(33833);
    }

    /* renamed from: q */
    private boolean m39103q(List<String> list, List<String> list2) {
        AppMethodBeat.m2504i(33834);
        C4990ab.m7417i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", list, list2);
        Intent intent = new Intent();
        intent.putExtra("Select_Contact", C5046bo.m7536c((List) list, ","));
        intent.putExtra("Cancel_Select_Contact", C5046bo.m7536c((List) list2, ","));
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(33834);
        return true;
    }

    /* renamed from: vI */
    public final void mo7901vI(String str) {
        AppMethodBeat.m2504i(33835);
        this.gnG.remove(str);
        dHV().notifyDataSetChanged();
        m39098Kt();
        AppMethodBeat.m2505o(33835);
    }

    public final boolean dId() {
        return false;
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(33836);
        boolean contains;
        if (c5445a.zmW && c5445a.ehM != null) {
            contains = this.gnG.contains(c5445a.ehM.field_username);
            AppMethodBeat.m2505o(33836);
            return contains;
        } else if (c5445a.zmX && c5445a.ehM != null) {
            contains = this.gnG.contains(c5445a.ehM.field_username);
            AppMethodBeat.m2505o(33836);
            return contains;
        } else if (c5445a instanceof C46674k) {
            contains = this.gnG.isEmpty();
            AppMethodBeat.m2505o(33836);
            return contains;
        } else {
            AppMethodBeat.m2505o(33836);
            return false;
        }
    }

    /* renamed from: b */
    public final boolean mo39661b(C5445a c5445a) {
        AppMethodBeat.m2504i(33837);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(33837);
            return false;
        }
        boolean contains = this.zol.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(33837);
        return contains;
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m39100a(OpenIMSelectContactUI openIMSelectContactUI, boolean z) {
        AppMethodBeat.m2504i(33838);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it = openIMSelectContactUI.gnG.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !C1855t.m3910mW(str)) {
                hashSet.add(str);
            } else {
                List<String> mz = C37921n.m64075mz(str);
                if (mz != null) {
                    for (String str2 : mz) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.m2505o(33838);
        return arrayList;
    }
}
