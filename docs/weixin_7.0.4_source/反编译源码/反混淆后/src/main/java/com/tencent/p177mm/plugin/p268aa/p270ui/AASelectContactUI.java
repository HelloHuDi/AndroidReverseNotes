package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.contact.C36252n;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.p268aa.p269a.C9797h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.ui.AASelectContactUI */
public class AASelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> gnF;
    private HashSet<String> gnG;
    private long gnH;
    private int gnI;
    private CheckBox gnJ;
    private View gnK;
    private String title;

    /* renamed from: com.tencent.mm.plugin.aa.ui.AASelectContactUI$4 */
    class C19604 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.aa.ui.AASelectContactUI$4$1 */
        class C19611 implements OnClickListener {
            C19611() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(40752);
                if (((long) AASelectContactUI.this.gnG.size()) > AASelectContactUI.this.gnH) {
                    C30379h.m48461b(AASelectContactUI.this.mController.ylL, AASelectContactUI.this.getString(C25738R.string.clt, new Object[]{Long.valueOf(AASelectContactUI.this.gnH)}), "", true);
                    C7060h.pYm.mo8381e(13722, Integer.valueOf(3));
                    AppMethodBeat.m2505o(40752);
                    return;
                }
                List linkedList = new LinkedList();
                linkedList.addAll(AASelectContactUI.this.gnG);
                AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", C5046bo.m7536c(linkedList, ",")));
                AASelectContactUI.this.finish();
                C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(11));
                AppMethodBeat.m2505o(40752);
            }
        }

        /* renamed from: com.tencent.mm.plugin.aa.ui.AASelectContactUI$4$2 */
        class C19622 implements OnClickListener {
            C19622() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(40753);
                AASelectContactUI.this.finish();
                C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(10));
                AppMethodBeat.m2505o(40753);
            }
        }

        C19604() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40754);
            if (AASelectContactUI.this.gnG == null || AASelectContactUI.this.gnG.size() <= 0 || ((long) AASelectContactUI.this.gnG.size()) > AASelectContactUI.this.gnH || (AASelectContactUI.this.gnG.size() == 1 && AASelectContactUI.this.gnG.contains(C1853r.m3846Yz()))) {
                AASelectContactUI.this.finish();
            } else {
                C30379h.m48445a(AASelectContactUI.this, AASelectContactUI.this.getString(C25738R.string.f8679bu), null, AASelectContactUI.this.getString(C25738R.string.f8683by), AASelectContactUI.this.getString(C25738R.string.f8682bx), false, new C19611(), new C19622());
            }
            C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(7));
            AppMethodBeat.m2505o(40754);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AASelectContactUI$1 */
    class C329031 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.aa.ui.AASelectContactUI$1$2 */
        class C329052 implements OnClickListener {
            C329052() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C329031() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40749);
            if (AASelectContactUI.this.gnJ.isChecked()) {
                if (AASelectContactUI.this.gnG != null) {
                    AASelectContactUI.this.gnG.clear();
                } else {
                    AASelectContactUI.this.gnG = new HashSet();
                }
                AASelectContactUI.this.gnJ.setChecked(false);
                AASelectContactUI.this.dHV().notifyDataSetChanged();
            } else {
                final List vE = C9797h.m17462vE(AASelectContactUI.this.chatroomName);
                if (((long) vE.size()) > AASelectContactUI.this.gnH) {
                    C30379h.m48440a(AASelectContactUI.this.mController.ylL, AASelectContactUI.this.getString(C25738R.string.f8681bw, new Object[]{Long.valueOf(AASelectContactUI.this.gnH)}), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(40748);
                            AASelectContactUI.m53841a(AASelectContactUI.this, vE);
                            AppMethodBeat.m2505o(40748);
                        }
                    }, new C329052());
                } else {
                    AASelectContactUI.m53841a(AASelectContactUI.this, vE);
                }
            }
            C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(6));
            AppMethodBeat.m2505o(40749);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AASelectContactUI$2 */
    class C329062 implements OnCheckedChangeListener {
        C329062() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(40750);
            AASelectContactUI.m53845e(AASelectContactUI.this);
            AppMethodBeat.m2505o(40750);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AASelectContactUI$3 */
    class C329073 implements OnMenuItemClickListener {
        C329073() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40751);
            if (((long) AASelectContactUI.this.gnG.size()) > AASelectContactUI.this.gnH) {
                C30379h.m48461b(AASelectContactUI.this.mController.ylL, AASelectContactUI.this.getString(C25738R.string.clt, new Object[]{Long.valueOf(AASelectContactUI.this.gnH)}), "", true);
                C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(8));
                C7060h.pYm.mo8381e(13722, Integer.valueOf(3));
                AppMethodBeat.m2505o(40751);
            } else if (AASelectContactUI.this.gnG.size() <= 0) {
                C30379h.m48461b(AASelectContactUI.this.mController.ylL, AASelectContactUI.this.getString(C25738R.string.f8684bz, new Object[]{Integer.valueOf(1)}), "", true);
                C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(9));
                AppMethodBeat.m2505o(40751);
            } else {
                List linkedList = new LinkedList();
                linkedList.addAll(AASelectContactUI.this.gnG);
                AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", C5046bo.m7536c(linkedList, ",")));
                AASelectContactUI.this.finish();
                AASelectContactUI.this.aqX();
                C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(8));
                AppMethodBeat.m2505o(40751);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: e */
    static /* synthetic */ void m53845e(AASelectContactUI aASelectContactUI) {
        AppMethodBeat.m2504i(40766);
        aASelectContactUI.m53838Kt();
        AppMethodBeat.m2505o(40766);
    }

    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(40755);
        super.mo7850Kh();
        this.title = getIntent().getStringExtra("titile");
        this.gnH = getIntent().getLongExtra("max_select_num", 20);
        this.gnI = getIntent().getIntExtra("select_type", 1);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!C1855t.m3896kH(this.chatroomName)) {
            C4990ab.m7416i("MicroMsg.AASelectContactUI", "is single chat");
        }
        this.gnG = new HashSet();
        this.gnF = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.gnF.addAll(Arrays.asList(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.gnG.addAll(C5046bo.m7508P(stringExtra.split(",")));
            m53838Kt();
        }
        this.gnJ = (CheckBox) findViewById(2131820907);
        this.gnK = findViewById(2131820906);
        this.gnK.setOnClickListener(new C329031());
        if (this.gnG.size() == C9797h.m17462vE(this.chatroomName).size()) {
            this.gnJ.setChecked(true);
        } else {
            this.gnJ.setChecked(false);
        }
        this.gnJ.setOnCheckedChangeListener(new C329062());
        AppMethodBeat.m2505o(40755);
    }

    public final void initView() {
        AppMethodBeat.m2504i(40756);
        super.initView();
        mo17379a(1, getString(C25738R.string.f9187s6), (OnMenuItemClickListener) new C329073(), C5535b.GREEN);
        m53838Kt();
        this.opo.setOnContactDeselectListener(this);
        setBackBtn(new C19604());
        AppMethodBeat.m2505o(40756);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(40757);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.gnF.addAll(C5046bo.m7508P(stringExtra.split(",")));
        }
        AppMethodBeat.m2505o(40757);
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        return this.title;
    }

    public final C40845o aoz() {
        AppMethodBeat.m2504i(40758);
        C41217d c41217d = new C41217d(this, this.chatroomName);
        AppMethodBeat.m2505o(40758);
        return c41217d;
    }

    public final C36877m aoA() {
        AppMethodBeat.m2504i(40759);
        C45489e c45489e = new C45489e(this, this.chatroomName);
        AppMethodBeat.m2505o(40759);
        return c45489e;
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(40760);
        C36252n dHV = dHV();
        C5445a Pn = dHV.getItem(i - getContentLV().getHeaderViewsCount());
        if (Pn == null) {
            AppMethodBeat.m2505o(40760);
        } else if (Pn.ehM == null) {
            AppMethodBeat.m2505o(40760);
        } else {
            C4990ab.m7417i("MicroMsg.AASelectContactUI", "ClickUser=%s", Pn.ehM.field_username);
            String str = Pn.ehM.field_username;
            if (str.equals(C1853r.m3846Yz())) {
                C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(4));
            } else {
                C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(5));
            }
            dIb();
            if (this.gnG.contains(str)) {
                this.gnG.remove(str);
            } else {
                this.gnG.add(str);
            }
            if (this.gnG.size() == C9797h.m17462vE(this.chatroomName).size()) {
                this.gnJ.setChecked(true);
            } else {
                this.gnJ.setChecked(false);
            }
            dHV.notifyDataSetChanged();
            m53838Kt();
            AppMethodBeat.m2505o(40760);
        }
    }

    /* renamed from: Kt */
    private void m53838Kt() {
        AppMethodBeat.m2504i(40763);
        if (this.gnG.size() > 0) {
            updateOptionMenuText(1, getString(C25738R.string.f8648ax, new Object[]{Integer.valueOf(this.gnG.size())}));
        } else {
            updateOptionMenuText(1, getString(C25738R.string.f9187s6));
        }
        if (this.gnG.size() == 1 && this.gnG.contains(C1853r.m3846Yz())) {
            enableOptionMenu(1, false);
            AppMethodBeat.m2505o(40763);
            return;
        }
        enableOptionMenu(1, true);
        AppMethodBeat.m2505o(40763);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: vI */
    public final void mo7901vI(String str) {
        AppMethodBeat.m2504i(40764);
        this.gnG.remove(str);
        dHV().notifyDataSetChanged();
        AppMethodBeat.m2505o(40764);
    }

    public final int getLayoutId() {
        return 2130968582;
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(40761);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(40761);
            return false;
        }
        boolean contains = this.gnG.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(40761);
        return contains;
    }

    /* renamed from: b */
    public final boolean mo39661b(C5445a c5445a) {
        AppMethodBeat.m2504i(40762);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(40762);
            return false;
        }
        boolean contains = this.gnF.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(40762);
        return contains;
    }
}
