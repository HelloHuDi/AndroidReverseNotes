package com.tencent.p177mm.plugin.label.p445ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMTagPanel.C44799a;
import com.tencent.p177mm.p612ui.base.MMTagPanelScrollView;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.C42558b;
import com.tencent.p177mm.plugin.label.C21158c;
import com.tencent.p177mm.plugin.label.C21160e;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.label.p1277b.C43237d;
import com.tencent.p177mm.plugin.label.p445ui.widget.MMLabelPanel;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.cmh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C46619af;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI */
public class ContactLabelUI extends ContactLabelBaseUI implements C1202f {
    private String edV;
    private MMTagPanelScrollView nIC;
    private MMLabelPanel nID;
    private TextView nIE;
    private View nIF;
    private View nIG;
    private TextView nIH;
    private MMLabelPanel nII;
    private ListView nIJ;
    private ScrollView nIK;
    private C46043b nIL;
    private String nIM;
    private ArrayList<String> nIN;
    private HashSet<String> nIO = new HashSet();
    private HashSet<String> nIP = new HashSet();
    private ArrayList<String> nIQ = new ArrayList();
    private C12369a nIR = C12369a.Normal;
    private boolean nIS = false;
    private ArrayList<String> nIT;
    private boolean nId = true;

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$1 */
    class C123591 implements OnMenuItemClickListener {
        C123591() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22658);
            ContactLabelUI.this.onBackPressed();
            AppMethodBeat.m2505o(22658);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$7 */
    class C123607 implements C44799a {
        C123607() {
        }

        /* renamed from: JR */
        public final void mo23722JR(String str) {
            AppMethodBeat.m2504i(22664);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", str);
            ContactLabelUI.this.nID.removeTag(str);
            if (ContactLabelUI.this.nII != null) {
                ContactLabelUI.this.nII.mo71952cd(str, false);
            }
            ContactLabelUI.m20300a(ContactLabelUI.this, str);
            AppMethodBeat.m2505o(22664);
        }

        /* renamed from: JS */
        public final void mo23723JS(String str) {
            AppMethodBeat.m2504i(22665);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", str);
            AppMethodBeat.m2505o(22665);
        }

        /* renamed from: JT */
        public final void mo23724JT(String str) {
            AppMethodBeat.m2504i(22666);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", str);
            if (ContactLabelUI.this.nII != null) {
                ContactLabelUI.this.nII.mo71952cd(str, false);
            }
            ContactLabelUI.m20300a(ContactLabelUI.this, str);
            AppMethodBeat.m2505o(22666);
        }

        public final void bmm() {
            AppMethodBeat.m2504i(22667);
            C4990ab.m7410d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
            AppMethodBeat.m2505o(22667);
        }

        /* renamed from: JU */
        public final void mo23725JU(String str) {
            AppMethodBeat.m2504i(22668);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", str);
            ContactLabelUI.m20306b(ContactLabelUI.this, str);
            AppMethodBeat.m2505o(22668);
        }

        /* renamed from: JV */
        public final void mo23726JV(String str) {
            AppMethodBeat.m2504i(22669);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", String.valueOf(str));
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7410d("MicroMsg.Label.ContactLabelUI", "tag is null.");
                AppMethodBeat.m2505o(22669);
                return;
            }
            ContactLabelUI.this.nID.mo71951cc(str, true);
            if (ContactLabelUI.this.nII != null) {
                ContactLabelUI.this.nII.mo71952cd(str, true);
            }
            ContactLabelUI.m20301a(ContactLabelUI.this, str, ContactLabelUI.this.nIS);
            AppMethodBeat.m2505o(22669);
        }

        /* renamed from: q */
        public final void mo23728q(boolean z, int i) {
            AppMethodBeat.m2504i(22670);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", String.valueOf(z), Integer.valueOf(i));
            if (z) {
                ContactLabelUI.this.enableOptionMenu(false);
                ContactLabelUI.this.nIE.setVisibility(0);
                ContactLabelUI.this.nIE.setText(C25738R.string.cl8);
                ContactLabelUI.this.nIE.setText(String.format(ContactLabelUI.this.getString(C25738R.string.cl8), new Object[]{Integer.valueOf(C5584f.m8385bP(36, "")), Integer.valueOf(i)}));
                AppMethodBeat.m2505o(22670);
                return;
            }
            ContactLabelUI.this.enableOptionMenu(true);
            ContactLabelUI.this.nIE.setVisibility(8);
            AppMethodBeat.m2505o(22670);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$8 */
    class C123618 implements C44799a {
        C123618() {
        }

        /* renamed from: JR */
        public final void mo23722JR(String str) {
            AppMethodBeat.m2504i(22671);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", String.valueOf(str));
            if (ContactLabelUI.this.nID != null) {
                ContactLabelUI.this.nID.removeTag(str);
            }
            ContactLabelUI.m20300a(ContactLabelUI.this, str);
            AppMethodBeat.m2505o(22671);
        }

        /* renamed from: JS */
        public final void mo23723JS(String str) {
            AppMethodBeat.m2504i(22672);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", String.valueOf(str));
            if (ContactLabelUI.this.nID != null) {
                ContactLabelUI.this.nID.mo71951cc(str, true);
            }
            ContactLabelUI.m20301a(ContactLabelUI.this, str, ContactLabelUI.this.nIS);
            AppMethodBeat.m2505o(22672);
        }

        /* renamed from: JT */
        public final void mo23724JT(String str) {
        }

        /* renamed from: q */
        public final void mo23728q(boolean z, int i) {
        }

        public final void bmm() {
        }

        /* renamed from: JU */
        public final void mo23725JU(String str) {
        }

        /* renamed from: JV */
        public final void mo23726JV(String str) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$10 */
    class C1236210 implements Runnable {
        C1236210() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22674);
            ContactLabelUI.this.nID.dAc();
            ContactLabelUI.this.showVKB();
            AppMethodBeat.m2505o(22674);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$11 */
    class C1236311 implements Runnable {
        C1236311() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22675);
            ContactLabelUI.this.nID.dAd();
            ContactLabelUI.this.aqX();
            AppMethodBeat.m2505o(22675);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$6 */
    class C123646 implements OnTouchListener {
        C123646() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(22663);
            if (motionEvent.getAction() == 2) {
                ContactLabelUI.this.aqX();
            }
            AppMethodBeat.m2505o(22663);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$9 */
    class C123659 implements OnItemClickListener {
        C123659() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22673);
            if (ContactLabelUI.this.nIL == null) {
                AppMethodBeat.m2505o(22673);
                return;
            }
            String item = ContactLabelUI.this.nIL.getItem(i);
            if (!(C5046bo.isNullOrNil(item) || ContactLabelUI.this.nID == null)) {
                ContactLabelUI.this.nID.dAb();
                ContactLabelUI.this.nID.mo71951cc(item, true);
                ContactLabelUI.this.nII.mo71952cd(item, true);
            }
            AppMethodBeat.m2505o(22673);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$12 */
    class C1236612 implements Runnable {
        C1236612() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22676);
            ContactLabelUI.this.nIO.clear();
            ContactLabelUI.this.nIP.clear();
            Collection collection = null;
            if (ContactLabelUI.this.nID != null) {
                C7616ad aoO;
                String str;
                if (ContactLabelUI.this.nIS) {
                    String str2 = null;
                    C9638aw.m17190ZK();
                    C7575bv RB = C18628c.m29079XN().mo15364RB(ContactLabelUI.this.edV);
                    if (RB != null) {
                        str2 = RB.field_contactLabels;
                    }
                    if (C5046bo.isNullOrNil(str2)) {
                        C9638aw.m17190ZK();
                        aoO = C18628c.m29078XM().aoO(ContactLabelUI.this.edV);
                        String str3 = aoO.field_encryptUsername;
                        if (!C5046bo.isNullOrNil(str3)) {
                            C9638aw.m17190ZK();
                            C7575bv RB2 = C18628c.m29079XN().mo15364RB(str3);
                            if (RB2 != null) {
                                str2 = RB2.field_contactLabels;
                            }
                        }
                        if (C5046bo.isNullOrNil(str2)) {
                            str = aoO.field_username;
                            C9638aw.m17190ZK();
                            RB = C18628c.m29079XN().mo15364RB(str);
                            if (RB != null) {
                                str2 = RB.field_contactLabels;
                            }
                        }
                    }
                    collection = (ArrayList) C21156a.bJa().mo41633PF(str2);
                } else {
                    C9638aw.m17190ZK();
                    aoO = C18628c.m29078XM().aoO(ContactLabelUI.this.edV);
                    if (aoO != null) {
                        str = aoO.field_contactLabelIds;
                        if (!C5046bo.isNullOrNil(str)) {
                            ArrayList arrayList = (ArrayList) C21156a.bJa().mo41634PG(str);
                        }
                    }
                }
                ContactLabelUI.this.nID.mo71950a(collection, (List) collection);
                ContactLabelUI.m20302a(ContactLabelUI.this, (ArrayList) collection);
            }
            if (ContactLabelUI.this.nII != null) {
                ContactLabelUI.this.nIQ = C21160e.bIZ().dsm();
                if (ContactLabelUI.this.nIQ != null && ContactLabelUI.this.nIQ.size() > 0) {
                    ContactLabelUI.this.nIS;
                    ContactLabelUI.this.nII.mo71950a(collection, (List) ContactLabelUI.this.nIQ);
                    if (ContactLabelUI.this.nId) {
                        C7060h.pYm.mo8381e(11346, Integer.valueOf(0), Integer.valueOf(1));
                        ContactLabelUI.this.nId = false;
                    }
                } else if (ContactLabelUI.this.nId) {
                    C7060h.pYm.mo8381e(11346, Integer.valueOf(0), Integer.valueOf(0));
                    ContactLabelUI.this.nId = false;
                }
            }
            ContactLabelUI.m20299a(ContactLabelUI.this, C12369a.Normal);
            AppMethodBeat.m2505o(22676);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$3 */
    class C123673 implements OnClickListener {
        C123673() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22660);
            ContactLabelUI.this.finish();
            AppMethodBeat.m2505o(22660);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$5 */
    class C123685 implements OnMenuItemClickListener {
        C123685() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22662);
            ContactLabelUI.m20298a(ContactLabelUI.this);
            AppMethodBeat.m2505o(22662);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$a */
    enum C12369a {
        Normal,
        Search,
        OverMaxCount,
        Invaildnput;

        static {
            AppMethodBeat.m2505o(22679);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$2 */
    class C123702 implements OnClickListener {
        C123702() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22659);
            ContactLabelUI.m20298a(ContactLabelUI.this);
            AppMethodBeat.m2505o(22659);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ContactLabelUI() {
        AppMethodBeat.m2504i(22680);
        AppMethodBeat.m2505o(22680);
    }

    /* renamed from: a */
    static /* synthetic */ void m20301a(ContactLabelUI contactLabelUI, String str, boolean z) {
        AppMethodBeat.m2504i(22698);
        contactLabelUI.m20303aR(str, z);
        AppMethodBeat.m2505o(22698);
    }

    public final int getLayoutId() {
        return 2130969230;
    }

    public final void initView() {
        AppMethodBeat.m2504i(22681);
        setMMTitle(getString(C25738R.string.f8709cq));
        setBackBtn(new C123591());
        mo17379a(0, getString(C25738R.string.f9218tc), (OnMenuItemClickListener) new C123685(), C5535b.GREEN);
        this.nIC = (MMTagPanelScrollView) findViewById(2131823070);
        this.nIC.setMaxLine(3);
        this.nID = (MMLabelPanel) findViewById(2131823071);
        this.nIE = (TextView) findViewById(2131823072);
        this.nIF = findViewById(2131823074);
        this.nIG = findViewById(2131823076);
        this.nIG.setBackgroundDrawable(null);
        this.nIH = (TextView) this.nIG.findViewById(16908310);
        this.nIH.setText(C25738R.string.cl7);
        this.nII = (MMLabelPanel) findViewById(2131823077);
        this.nIJ = (ListView) findViewById(2131823078);
        this.nIK = (ScrollView) findViewById(2131823073);
        if (this.nIK != null) {
            this.nIK.setOnTouchListener(new C123646());
        }
        this.nID.yxp = true;
        this.nID.mo71963qe(true);
        this.nID.setTagEditTextBG(C25738R.drawable.a2s);
        this.nID.setCallBack(new C123607());
        this.nII.mo71963qe(false);
        this.nII.setCallBack(new C123618());
        this.nIJ.setAdapter(this.nIL);
        this.nIJ.setOnItemClickListener(new C123659());
        enableOptionMenu(false);
        AppMethodBeat.m2505o(22681);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22682);
        super.onCreate(bundle);
        this.nIM = getIntent().getStringExtra("label_id_list");
        this.nIN = getIntent().getStringArrayListExtra("label_str_list");
        this.edV = getIntent().getStringExtra("label_username");
        this.nIS = getIntent().getBooleanExtra("is_stranger", false);
        this.nIL = new C46043b(this);
        initView();
        if (!(C5046bo.isNullOrNil(this.nIM) || this.nIN == null || this.nIN.size() <= 0)) {
            this.nID.mo71950a((Collection) this.nIN, (List) this.nIN);
        }
        if (this.nIS) {
            this.nIT = getIntent().getStringArrayListExtra("label_str_list");
            this.nID.mo71950a((Collection) this.nIT, (List) this.nIT);
        }
        C7060h.pYm.mo8381e(16097, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1));
        AppMethodBeat.m2505o(22682);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22683);
        C9638aw.m17182Rg().mo14539a((int) C42558b.CTRL_INDEX, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(638, (C1202f) this);
        C5004al.m7441d(new C1236612());
        super.onResume();
        AppMethodBeat.m2505o(22683);
    }

    public void onPause() {
        AppMethodBeat.m2504i(22684);
        C9638aw.m17182Rg().mo14546b((int) C42558b.CTRL_INDEX, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(638, (C1202f) this);
        super.onPause();
        AppMethodBeat.m2505o(22684);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22685);
        super.onDestroy();
        AppMethodBeat.m2505o(22685);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22686);
        C4990ab.m7417i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (c1207m.getType()) {
            case C42558b.CTRL_INDEX /*635*/:
                if (i == 0 && i2 == 0) {
                    bJl();
                    AppMethodBeat.m2505o(22686);
                    return;
                }
                bJf();
                AppMethodBeat.m2505o(22686);
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    C4990ab.m7416i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
                    bJm();
                    AppMethodBeat.m2505o(22686);
                    return;
                }
                bJf();
                AppMethodBeat.m2505o(22686);
                return;
            default:
                C4990ab.m7420w("MicroMsg.Label.ContactLabelUI", "unknow type.");
                AppMethodBeat.m2505o(22686);
                return;
        }
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(22687);
        if (bJn()) {
            C30379h.m48466d(this, getString(C25738R.string.dwy), "", getString(C25738R.string.abl), getString(C25738R.string.abm), new C123702(), new C123673());
            AppMethodBeat.m2505o(22687);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.m2505o(22687);
    }

    /* renamed from: a */
    private void m20297a(C12369a c12369a) {
        AppMethodBeat.m2504i(22688);
        this.nIR = c12369a;
        switch (this.nIR) {
            case Normal:
                this.nIJ.setVisibility(8);
                if (this.nIQ == null || this.nIQ.size() <= 0) {
                    this.nIK.setVisibility(8);
                    this.nIF.setVisibility(8);
                } else {
                    this.nIF.setVisibility(0);
                    this.nIK.setVisibility(0);
                }
                this.nIE.setVisibility(8);
                AppMethodBeat.m2505o(22688);
                return;
            case Search:
                this.nIK.setVisibility(8);
                this.nIJ.setVisibility(0);
                this.nIF.setVisibility(8);
                this.nIE.setVisibility(8);
                AppMethodBeat.m2505o(22688);
                return;
            case OverMaxCount:
                this.nIJ.setVisibility(8);
                this.nIK.setVisibility(8);
                this.nIF.setVisibility(8);
                this.nIE.setVisibility(0);
                this.nIE.setText(C25738R.string.cl8);
                AppMethodBeat.m2505o(22688);
                return;
            case Invaildnput:
                this.nIJ.setVisibility(8);
                this.nIK.setVisibility(8);
                this.nIF.setVisibility(8);
                this.nIE.setVisibility(0);
                this.nIE.setText(C25738R.string.cl8);
                break;
        }
        AppMethodBeat.m2505o(22688);
    }

    /* renamed from: aR */
    private void m20303aR(String str, boolean z) {
        AppMethodBeat.m2504i(22689);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.Label.ContactLabelUI", "tag is empty");
            AppMethodBeat.m2505o(22689);
            return;
        }
        String trim = str.trim();
        if (C5046bo.isNullOrNil(trim)) {
            C4990ab.m7420w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
            AppMethodBeat.m2505o(22689);
            return;
        }
        C46619af aoE = C21160e.bIZ().aoE(trim);
        if (z) {
            if (this.nIQ == null || !this.nIQ.contains(trim) || aoE == null) {
                this.nIP.add(trim);
            }
        } else if (this.nIQ == null || !this.nIQ.contains(trim) || (aoE != null && aoE.field_isTemporary)) {
            this.nIP.add(trim);
        }
        if (this.nIO != null && this.nIO.contains(trim)) {
            this.nIO.remove(trim);
        }
        if (bJn()) {
            enableOptionMenu(true);
        }
        AppMethodBeat.m2505o(22689);
    }

    private void bJl() {
        AppMethodBeat.m2504i(22690);
        C4990ab.m7416i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
        if (this.nID != null) {
            int size;
            int size2;
            int size3;
            C4990ab.m7416i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
            String str = "";
            ArrayList tagList = this.nID.getTagList();
            if (tagList != null && tagList.size() > 0) {
                str = C21158c.m32494cf(C21160e.bIZ().mo64071ai(tagList));
            }
            LinkedList linkedList = new LinkedList();
            cmh cmh = new cmh();
            cmh.wcD = str;
            cmh.jBB = this.edV;
            linkedList.add(cmh);
            C9638aw.m17182Rg().mo14541a(new C43237d(linkedList), 0);
            if (this.nIP != null) {
                size = this.nIP.size();
            } else {
                size = 0;
            }
            if (this.nIN != null) {
                size2 = this.nIN.size();
            } else {
                size2 = 0;
            }
            if (this.nIO != null) {
                size3 = this.nIO.size();
            } else {
                size3 = 0;
            }
            size2 = ((size3 + this.nID.getTagList().size()) - size2) - size;
            if (size > 0 || size2 > 0) {
                C4990ab.m7411d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", Integer.valueOf(size), Integer.valueOf(size2));
                C7060h.pYm.mo8381e(11220, C1853r.m3846Yz(), Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(0), Integer.valueOf(0));
            }
            if (size > 0) {
                C7060h.pYm.mo8381e(16097, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
            }
        }
        AppMethodBeat.m2505o(22690);
    }

    private void bJm() {
        AppMethodBeat.m2504i(22691);
        bJc();
        this.nIP.clear();
        this.nIO.clear();
        finish();
        AppMethodBeat.m2505o(22691);
    }

    private void bJf() {
        AppMethodBeat.m2504i(22692);
        bJc();
        mo36483JN(getString(C25738R.string.f8706cn));
        AppMethodBeat.m2505o(22692);
    }

    private boolean bJn() {
        AppMethodBeat.m2504i(22693);
        if (this.nID != null) {
            if (this.nIN == null || this.nIN.size() <= 0) {
                if (this.nID.getTagList() != null && this.nID.getTagList().size() > 0) {
                    AppMethodBeat.m2505o(22693);
                    return true;
                }
            } else if (this.nID.getTagList() != null || this.nID.getTagList().size() > 0) {
                ArrayList tagList = this.nID.getTagList();
                Collections.sort(this.nIN);
                Collections.sort(tagList);
                if (this.nIN.equals(tagList)) {
                    AppMethodBeat.m2505o(22693);
                    return false;
                }
                AppMethodBeat.m2505o(22693);
                return true;
            } else {
                AppMethodBeat.m2505o(22693);
                return true;
            }
        }
        AppMethodBeat.m2505o(22693);
        return false;
    }

    public void finish() {
        AppMethodBeat.m2504i(22694);
        if (this.nID != null) {
            this.nID.dAd();
        }
        Intent intent = new Intent();
        if (bJn()) {
            intent.putExtra("hasLableChange", true);
        } else {
            intent.putExtra("hasLableChange", false);
        }
        setResult(-1, intent);
        super.finish();
        AppMethodBeat.m2505o(22694);
    }
}
