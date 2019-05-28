package com.tencent.p177mm.plugin.multitalk.p459ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p230g.p231a.C37750kc;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.contact.C36252n;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.multitalk.model.C12626e;
import com.tencent.p177mm.plugin.multitalk.model.C34571j;
import com.tencent.p177mm.plugin.multitalk.model.C34572p;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C39422d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI */
public class MultiTalkSelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> gnF;
    private HashSet<String> gnG;
    private C4884c oGA = new C460892();
    private boolean oHU;
    private C39422d oHV;
    private boolean oHW = false;

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI$1 */
    class C345751 implements OnMenuItemClickListener {
        C345751() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(54158);
            if (C5023at.isNetworkConnected(C4996ah.getContext())) {
                List linkedList = new LinkedList();
                linkedList.addAll(MultiTalkSelectContactUI.this.gnG);
                linkedList.add(C1853r.m3846Yz());
                String c = C5046bo.m7536c(linkedList, ",");
                if (MultiTalkSelectContactUI.this.oHU) {
                    C12626e.m20588a(MultiTalkSelectContactUI.this.gnG.size(), MultiTalkSelectContactUI.this.oHW, 1, "", MultiTalkSelectContactUI.this.oHV.oIB);
                    C34572p.bSf().mo24567b(MultiTalkSelectContactUI.this, c, MultiTalkSelectContactUI.this.chatroomName);
                } else {
                    C12626e.m20588a(MultiTalkSelectContactUI.this.gnG.size(), MultiTalkSelectContactUI.this.oHW, 2, C34571j.bRU(), 0);
                    MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", c));
                    MultiTalkSelectContactUI.this.finish();
                }
            } else {
                C17981e.m28295a(MultiTalkSelectContactUI.this, C25738R.string.f6c, null);
            }
            MultiTalkSelectContactUI.this.aqX();
            AppMethodBeat.m2505o(54158);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI$2 */
    class C460892 extends C4884c<C37750kc> {
        C460892() {
            AppMethodBeat.m2504i(54159);
            this.xxI = C37750kc.class.getName().hashCode();
            AppMethodBeat.m2505o(54159);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(54160);
            C37750kc c37750kc = (C37750kc) c4883b;
            if ((c37750kc instanceof C37750kc) && c37750kc.cFw.action == 0) {
                MultiTalkSelectContactUI.this.finish();
            }
            AppMethodBeat.m2505o(54160);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MultiTalkSelectContactUI() {
        AppMethodBeat.m2504i(54161);
        AppMethodBeat.m2505o(54161);
    }

    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(54162);
        super.mo7850Kh();
        this.oHU = getIntent().getBooleanExtra("key_need_gallery", false);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!C1855t.m3896kH(this.chatroomName)) {
            finish();
        }
        this.gnG = new HashSet();
        this.gnF = new HashSet();
        AppMethodBeat.m2505o(54162);
    }

    public void initView() {
        AppMethodBeat.m2504i(54163);
        super.initView();
        mo17446xE(getResources().getColor(C25738R.color.f11906l8));
        dyb();
        this.oHV = new C39422d(this);
        if (this.oHU) {
            this.oHV.setVisible(true);
        } else {
            this.oHV.setVisible(false);
        }
        int i = C25738R.string.f9187s6;
        if (this.oHU) {
            i = C25738R.string.d39;
        }
        mo17379a(1, getString(i), (OnMenuItemClickListener) new C345751(), C5535b.GREEN);
        m85952Kt();
        this.opo.setBackgroundResource(C25738R.color.f11906l8);
        this.opo.getInputText().setTextColor(-1);
        AppMethodBeat.m2505o(54163);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(54164);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.gnF.addAll(C5046bo.m7508P(stringExtra.split(",")));
        }
        this.gnF.add(C1853r.m3846Yz());
        if (this.oHU) {
            this.oHV.mo62366Sp(C1853r.m3846Yz());
        }
        C4879a.xxA.mo10052c(this.oGA);
        AppMethodBeat.m2505o(54164);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(54165);
        C4879a.xxA.mo10053d(this.oGA);
        super.onDestroy();
        AppMethodBeat.m2505o(54165);
    }

    public final int getLayoutId() {
        return 2130970268;
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.m2504i(54166);
        String stringExtra = getIntent().getStringExtra("titile");
        AppMethodBeat.m2505o(54166);
        return stringExtra;
    }

    public final C40845o aoz() {
        AppMethodBeat.m2504i(54167);
        C34576a c34576a = new C34576a(this, this.chatroomName);
        AppMethodBeat.m2505o(54167);
        return c34576a;
    }

    public final C36877m aoA() {
        AppMethodBeat.m2504i(54168);
        C39421b c39421b = new C39421b(this, this.chatroomName);
        AppMethodBeat.m2505o(54168);
        return c39421b;
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(54169);
        C36252n dHV = dHV();
        C5445a Pn = dHV.getItem(i - getContentLV().getHeaderViewsCount());
        if (Pn == null) {
            AppMethodBeat.m2505o(54169);
        } else if (Pn.ehM == null) {
            AppMethodBeat.m2505o(54169);
        } else {
            C4990ab.m7417i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", Pn.ehM.field_username);
            String str = Pn.ehM.field_username;
            if (C1853r.m3846Yz().equals(str)) {
                AppMethodBeat.m2505o(54169);
                return;
            }
            dIb();
            if (this.gnG.contains(str)) {
                if (this.oHU) {
                    C39422d c39422d = this.oHV;
                    if (c39422d.size != 0) {
                        int i3;
                        int i4;
                        int i5 = -1;
                        for (i3 = 0; i3 < c39422d.oIu.getChildCount(); i3++) {
                            if (c39422d.oIu.getChildAt(i3).getTag().equals(str)) {
                                i5 = i3;
                                i4 = 1;
                                break;
                            }
                        }
                        i4 = 0;
                        if (i5 < 0) {
                            i3 = 0;
                            while (i3 < c39422d.oIv.getChildCount()) {
                                if (c39422d.oIv.getChildAt(i3).getTag().equals(str)) {
                                    break;
                                }
                                i3++;
                            }
                        }
                        i3 = i5;
                        i2 = 0;
                        if (i3 >= 0) {
                            if (i2 != 0) {
                                c39422d.oIv.removeViewAt(i3);
                                c39422d.size--;
                            }
                            if (i4 != 0) {
                                if (c39422d.size <= 5) {
                                    c39422d.oIu.removeViewAt(i3);
                                    c39422d.size--;
                                } else {
                                    c39422d.oIu.removeViewAt(i3);
                                    View childAt = c39422d.oIv.getChildAt(0);
                                    c39422d.oIv.removeViewAt(0);
                                    c39422d.oIu.addView(childAt);
                                    c39422d.size--;
                                }
                            }
                            c39422d.mo62369zj(c39422d.size);
                            c39422d.mo62370zk(c39422d.size);
                        }
                    }
                }
                this.gnG.remove(str);
            } else if (this.gnF.size() + this.gnG.size() == 9) {
                this.oHW = true;
                Toast.makeText(this, C25738R.string.d35, 0).show();
                AppMethodBeat.m2505o(54169);
                return;
            } else {
                if (this.oHU) {
                    this.oHV.mo62366Sp(str);
                }
                this.gnG.add(str);
            }
            dHV.notifyDataSetChanged();
            m85952Kt();
            AppMethodBeat.m2505o(54169);
        }
    }

    public final void bMQ() {
        AppMethodBeat.m2504i(54170);
        super.bMQ();
        aqX();
        AppMethodBeat.m2505o(54170);
    }

    /* renamed from: Kt */
    private void m85952Kt() {
        AppMethodBeat.m2504i(54173);
        if (this.gnG.size() > 0) {
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(54173);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.m2505o(54173);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(54171);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(54171);
            return false;
        }
        boolean contains = this.gnG.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(54171);
        return contains;
    }

    /* renamed from: b */
    public final boolean mo39661b(C5445a c5445a) {
        AppMethodBeat.m2504i(54172);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(54172);
            return false;
        }
        boolean contains = this.gnF.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(54172);
        return contains;
    }
}
