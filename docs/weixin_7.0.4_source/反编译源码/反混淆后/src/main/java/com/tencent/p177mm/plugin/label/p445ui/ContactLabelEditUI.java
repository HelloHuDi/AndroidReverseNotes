package com.tencent.p177mm.plugin.label.p445ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.C42558b;
import com.tencent.p177mm.plugin.label.C21158c;
import com.tencent.p177mm.plugin.label.C21160e;
import com.tencent.p177mm.plugin.label.C43234a;
import com.tencent.p177mm.plugin.label.p1277b.C21157a;
import com.tencent.p177mm.plugin.label.p1277b.C43235b;
import com.tencent.p177mm.plugin.label.p1277b.C43237d;
import com.tencent.p177mm.plugin.label.p1277b.C43238e;
import com.tencent.p177mm.plugin.label.p445ui.widget.InputClearablePreference;
import com.tencent.p177mm.plugin.label.p445ui.widget.InputClearablePreference.C24785a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30106k.C14929b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference.C30100a;
import com.tencent.p177mm.protocal.protobuf.axj;
import com.tencent.p177mm.protocal.protobuf.cmh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C46619af;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI */
public class ContactLabelEditUI extends MMPreference implements C1202f {
    private ProgressDialog gqo;
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(22540);
            switch (message.what) {
                case 6001:
                    ContactLabelEditUI.m85688a(ContactLabelEditUI.this);
                    AppMethodBeat.m2505o(22540);
                    return;
                case 6002:
                    C43234a.gkF.mo38844BS();
                    AppMethodBeat.m2505o(22540);
                    return;
                default:
                    C4990ab.m7421w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", Integer.valueOf(message.what));
                    AppMethodBeat.m2505o(22540);
                    return;
            }
        }
    };
    private boolean nBj = true;
    private String nHB;
    private String nHC;
    private String nHD;
    private C46619af nHE;
    private boolean nHF;
    private boolean nHG = false;
    private String nHH;
    private C15541f nHI;
    private ContactListExpandPreference nHJ;
    private InputClearablePreference nHK;
    private Preference nHL;
    private PreferenceTitleCategory nHM;
    private boolean nHN = true;
    private ArrayList<String> nHO = new ArrayList();
    private ArrayList<String> nHP = new ArrayList();
    private HashSet<String> nHQ = new HashSet();
    private HashSet<String> nHR = new HashSet();
    private HashSet<String> nHS = new HashSet();
    private String nHT;
    private String nHU;
    private boolean nHV;

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$2 */
    class C33322 implements OnClickListener {
        C33322() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$4 */
    class C33334 implements OnClickListener {
        C33334() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$11 */
    class C2116411 implements C24785a {
        C2116411() {
        }

        /* renamed from: PL */
        public final void mo36487PL(String str) {
            AppMethodBeat.m2504i(22550);
            ContactLabelEditUI.this.nHC = str;
            ContactLabelEditUI.m85695c(ContactLabelEditUI.this, str);
            ContactLabelEditUI.this.nHK.mo41643iA(false);
            AppMethodBeat.m2505o(22550);
        }

        /* renamed from: iy */
        public final void mo36488iy(boolean z) {
            AppMethodBeat.m2504i(22551);
            if (ContactLabelEditUI.this.nHN || !ContactLabelEditUI.this.nBj) {
                ContactLabelEditUI.this.enableOptionMenu(z);
                AppMethodBeat.m2505o(22551);
                return;
            }
            ContactLabelEditUI.this.enableOptionMenu(false);
            ContactLabelEditUI.this.nBj = false;
            AppMethodBeat.m2505o(22551);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$12 */
    class C2116512 implements Runnable {
        C2116512() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22552);
            ArrayList aoD = C21160e.bIZ().aoD(ContactLabelEditUI.this.nHD);
            if (aoD == null) {
                C4990ab.m7420w("MicroMsg.Label.ContactLabelEditUI", "result is null");
                AppMethodBeat.m2505o(22552);
                return;
            }
            if (aoD != null) {
                ContactLabelEditUI.this.nHO = aoD;
                if (ContactLabelEditUI.this.nHP == null) {
                    ContactLabelEditUI.this.nHP = new ArrayList();
                } else {
                    ContactLabelEditUI.this.nHP.clear();
                }
                ContactLabelEditUI.this.nHP.addAll(aoD);
            }
            if (ContactLabelEditUI.this.mHandler != null) {
                ContactLabelEditUI.this.mHandler.sendEmptyMessage(6001);
            }
            AppMethodBeat.m2505o(22552);
        }

        public final String toString() {
            AppMethodBeat.m2504i(22553);
            String str = super.toString() + "|initView";
            AppMethodBeat.m2505o(22553);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$3 */
    class C211663 implements OnCancelListener {
        C211663() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(22541);
            C9638aw.m17182Rg().cancel(C42558b.CTRL_INDEX);
            C9638aw.m17182Rg().cancel(637);
            AppMethodBeat.m2505o(22541);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$10 */
    class C2835510 implements C30100a {
        C2835510() {
        }

        /* renamed from: iB */
        public final void mo14655iB(int i) {
            AppMethodBeat.m2504i(22546);
            if (ContactLabelEditUI.this.nHJ.mo48350KW(i)) {
                String KX = ContactLabelEditUI.this.nHJ.mo48351KX(i);
                String KY = ContactLabelEditUI.this.nHJ.mo48352KY(i);
                if (C5046bo.isNullOrNil(KX)) {
                    AppMethodBeat.m2505o(22546);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", KX);
                intent.putExtra("Contact_RoomNickname", KY);
                C43234a.gkE.mo38912c(intent, ContactLabelEditUI.this);
            }
            AppMethodBeat.m2505o(22546);
        }

        /* renamed from: JT */
        public final void mo14653JT() {
            AppMethodBeat.m2504i(22547);
            if (ContactLabelEditUI.this.nHJ != null) {
                ContactLabelEditUI.this.nHJ.djD();
            }
            AppMethodBeat.m2505o(22547);
        }

        /* renamed from: iC */
        public final void mo14656iC(int i) {
            AppMethodBeat.m2504i(22548);
            ContactLabelEditUI.m85696d(ContactLabelEditUI.this);
            AppMethodBeat.m2505o(22548);
        }

        /* renamed from: iA */
        public final void mo14654iA(int i) {
            AppMethodBeat.m2504i(22549);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", Integer.valueOf(i), ContactLabelEditUI.this.nHJ.mo48351KX(i));
            ContactLabelEditUI.m85689a(ContactLabelEditUI.this, r0);
            AppMethodBeat.m2505o(22549);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$13 */
    class C2835613 implements OnScrollListener {
        C2835613() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(22554);
            if (i == 2 || i == 1) {
                ContactLabelEditUI.this.aqX();
            }
            AppMethodBeat.m2505o(22554);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$9 */
    class C283579 implements C14929b {
        C283579() {
        }

        /* renamed from: iD */
        public final boolean mo4758iD(int i) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$5 */
    class C344035 implements OnClickListener {
        C344035() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22542);
            ContactLabelEditUI.m85693b(ContactLabelEditUI.this);
            AppMethodBeat.m2505o(22542);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$6 */
    class C344046 implements OnClickListener {
        C344046() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22543);
            ContactLabelEditUI.this.setResult(0);
            ContactLabelEditUI.this.finish();
            AppMethodBeat.m2505o(22543);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$8 */
    class C344058 implements OnMenuItemClickListener {
        C344058() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22545);
            ContactLabelEditUI.m85693b(ContactLabelEditUI.this);
            AppMethodBeat.m2505o(22545);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$14 */
    class C3928014 implements OnClickListener {
        C3928014() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22555);
            ContactLabelEditUI.m85704l(ContactLabelEditUI.this);
            AppMethodBeat.m2505o(22555);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelEditUI$7 */
    class C392817 implements OnMenuItemClickListener {
        C392817() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22544);
            ContactLabelEditUI.this.onBackPressed();
            AppMethodBeat.m2505o(22544);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ContactLabelEditUI() {
        AppMethodBeat.m2504i(22556);
        AppMethodBeat.m2505o(22556);
    }

    /* renamed from: c */
    static /* synthetic */ void m85695c(ContactLabelEditUI contactLabelEditUI, String str) {
        AppMethodBeat.m2504i(22582);
        contactLabelEditUI.m85685PJ(str);
        AppMethodBeat.m2505o(22582);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8514az;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22557);
        super.onCreate(bundle);
        this.nHT = C1853r.m3846Yz();
        this.nHD = getIntent().getStringExtra("label_id");
        this.nHB = getIntent().getStringExtra("label_name");
        this.nHC = getIntent().getStringExtra("label_name");
        this.nHF = getIntent().getBooleanExtra("Is_Chatroom", false);
        this.nHU = getIntent().getStringExtra("label_source");
        boolean z = this.nHU != null && this.nHU.equals("label_source_Address");
        this.nHV = z;
        this.nHG = getIntent().getBooleanExtra("is_show_delete", true);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            ArrayList P = C5046bo.m7508P(stringExtra.split(","));
            this.nHO = new ArrayList();
            if (P != null && P.size() > 0) {
                int size = P.size();
                for (int i = 0; i < size; i++) {
                    stringExtra = (String) P.get(i);
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        if (!C1855t.m3912mY(stringExtra) || this.nHO.contains(stringExtra) || stringExtra.equals(this.nHT)) {
                            C4990ab.m7417i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", stringExtra);
                        } else {
                            this.nHO.add(stringExtra);
                            this.nHQ.add(stringExtra);
                            if (this.nHF) {
                                this.nHR.add(stringExtra);
                            }
                        }
                    }
                }
            }
        }
        C9638aw.m17182Rg().mo14539a((int) C42558b.CTRL_INDEX, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(637, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(638, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(22557);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22558);
        C26483d.m42196b(3, "ContactLabelEditUI" + bJj(), hashCode());
        C9638aw.m17182Rg().mo14539a(636, (C1202f) this);
        m85685PJ(this.nHC);
        bJd();
        super.onResume();
        AppMethodBeat.m2505o(22558);
    }

    public void onPause() {
        AppMethodBeat.m2504i(22559);
        C26483d.m42196b(4, "ContactLabelEditUI" + bJj(), hashCode());
        C9638aw.m17182Rg().mo14546b(636, (C1202f) this);
        super.onPause();
        AppMethodBeat.m2505o(22559);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22560);
        C9638aw.m17182Rg().mo14546b((int) C42558b.CTRL_INDEX, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(637, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(638, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(22560);
    }

    public final void initView() {
        AppMethodBeat.m2504i(22561);
        if (this.nHV) {
            C7060h.pYm.mo8381e(16097, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
        } else {
            C7060h.pYm.mo8381e(16097, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3));
        }
        if (C5046bo.isNullOrNil(this.nHD)) {
            this.nHN = true;
            this.nHH = getString(C25738R.string.dec);
        } else {
            this.nHN = false;
            this.nHE = C21160e.bIZ().aoF(this.nHD);
            this.nHH = getString(C25738R.string.deb);
        }
        setMMTitle(this.nHH);
        setBackBtn(new C392817());
        mo17379a(0, getString(C25738R.string.f9218tc), (OnMenuItemClickListener) new C344058(), C5535b.GREEN);
        this.nHI = this.yCw;
        this.nHJ = (ContactListExpandPreference) this.nHI.aqO("contact_label_contact_list");
        this.nHJ.mo48357a(this.nHI, this.nHJ.mKey);
        this.nHJ.mo48368oD(true);
        this.nHJ.mo48369oE(true);
        this.nHJ.djF();
        this.nHJ.djz();
        this.nHJ.mo48355a(new C283579());
        this.nHJ.mo48354a(new C2835510());
        this.nHK = (InputClearablePreference) this.nHI.aqO("contact_label_name");
        InputClearablePreference inputClearablePreference = this.nHK;
        inputClearablePreference.nJe = getString(C25738R.string.ckz);
        if (inputClearablePreference.nJj != null) {
            inputClearablePreference.nJj.setHint(inputClearablePreference.nJe);
        }
        this.nHK.hAa = getString(C25738R.string.cl8);
        inputClearablePreference = this.nHK;
        inputClearablePreference.nJf = getString(C25738R.string.f8707co);
        if (inputClearablePreference.nJl != null) {
            inputClearablePreference.nJl.setText(inputClearablePreference.nJf);
        }
        this.nHK.nJg = 36;
        this.nHK.nJi = this.nHN;
        this.nHK.nJn = new C2116411();
        this.nHK.setText(this.nHC);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(6001);
        }
        if (!this.nHN) {
            C9638aw.m17180RS().mo10302aa(new C2116512());
        } else if (this.nHO == null || this.nHO.size() <= 0) {
            this.nHJ.mo48358ag(new ArrayList());
        } else {
            this.nHJ.mo48371u(null, this.nHO);
        }
        if (this.nDp != null) {
            this.nDp.setOnScrollListener(new C2835613());
        }
        this.nHL = this.nHI.aqO("contact_label_delete");
        this.nHM = (PreferenceTitleCategory) this.nHI.aqO("contact_label_empty_category");
        if (this.nHN) {
            this.nHI.mo27716d(this.nHL);
            this.nHI.mo27716d(this.nHM);
            AppMethodBeat.m2505o(22561);
            return;
        }
        if (!this.nHG) {
            this.nHI.mo27716d(this.nHL);
        }
        AppMethodBeat.m2505o(22561);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(22562);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            AppMethodBeat.m2505o(22562);
            return;
        }
        switch (i) {
            case 7001:
                String stringExtra = intent.getStringExtra("Select_Contact");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                C4990ab.m7417i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", String.valueOf(stringExtra));
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    ArrayList P = C5046bo.m7508P(stringExtra.split(","));
                    if (P != null && P.size() > 0) {
                        int size = P.size();
                        int i3 = 0;
                        while (i3 < size) {
                            stringExtra = (String) P.get(i3);
                            if (!C5046bo.isNullOrNil(stringExtra)) {
                                if (!C1855t.m3912mY(stringExtra) || this.nHO.contains(stringExtra) || stringExtra.equals(this.nHT)) {
                                    C4990ab.m7417i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", stringExtra);
                                } else {
                                    this.nHO.add(stringExtra);
                                    if (!(this.nHP == null || this.nHP.contains(P.get(i3)))) {
                                        this.nHQ.add(stringExtra);
                                    }
                                    if (booleanExtra) {
                                        this.nHR.add(stringExtra);
                                    }
                                    if (this.nHS != null && this.nHS.contains(stringExtra)) {
                                        this.nHS.remove(stringExtra);
                                    }
                                }
                            }
                            i3++;
                        }
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(6001);
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.m2505o(22562);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22564);
        C4990ab.m7417i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (c1207m.getType()) {
            case C42558b.CTRL_INDEX /*635*/:
                if (i == 0 && i2 == 0) {
                    LinkedList linkedList = ((C21157a) c1207m).bJb().vEm;
                    if (linkedList == null || linkedList.size() <= 0) {
                        bJf();
                        AppMethodBeat.m2505o(22564);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", r0.wBr, ((axj) linkedList.get(0)).wBq);
                    this.nHD = r0.wBr;
                    bJg();
                    AppMethodBeat.m2505o(22564);
                    return;
                }
                bJf();
                AppMethodBeat.m2505o(22564);
                return;
            case 636:
                if (i != 0 || i2 != 0) {
                    C4990ab.m7420w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
                    bJh();
                    break;
                }
                m85690a(this.nHE);
                if (this.mHandler != null) {
                    this.mHandler.sendEmptyMessageDelayed(6002, 300);
                    AppMethodBeat.m2505o(22564);
                    return;
                }
                break;
            case 637:
                if (i == 0 && i2 == 0) {
                    int intValue;
                    String str2 = this.nHD;
                    String str3 = this.nHC;
                    C4990ab.m7416i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
                    try {
                        intValue = Integer.valueOf(str2).intValue();
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", String.valueOf(str2));
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        C46619af aoF = C21160e.bIZ().aoF(str2);
                        if (aoF == null) {
                            aoF = new C46619af();
                        }
                        aoF.field_labelID = intValue;
                        aoF.field_labelName = str3;
                        aoF.field_labelPYFull = C9790g.m17432vo(str3);
                        aoF.field_labelPYShort = C9790g.m17433vp(str3);
                        C21160e.bIZ().mo64075b(true, aoF, "labelID");
                    } else {
                        bJf();
                    }
                    bJg();
                    AppMethodBeat.m2505o(22564);
                    return;
                }
                bJf();
                AppMethodBeat.m2505o(22564);
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    bJe();
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        AppMethodBeat.m2505o(22564);
                        return;
                    }
                }
                bJf();
                AppMethodBeat.m2505o(22564);
                return;
                break;
        }
        AppMethodBeat.m2505o(22564);
    }

    private void bJd() {
        AppMethodBeat.m2504i(22565);
        if (this.nHJ != null) {
            this.nHJ.mo48371u(null, this.nHO);
            if (this.nHO == null || this.nHO.size() <= 0) {
                this.nHJ.djD();
            }
        }
        if (this.nHK != null) {
            this.nHK.setText(this.nHC);
        }
        AppMethodBeat.m2505o(22565);
    }

    /* renamed from: PJ */
    private void m85685PJ(String str) {
        AppMethodBeat.m2504i(22566);
        enableOptionMenu(!C5046bo.isNullOrNil(str));
        AppMethodBeat.m2505o(22566);
    }

    private void bJe() {
        int size;
        int size2;
        AppMethodBeat.m2504i(22567);
        C4990ab.m7416i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
        bJc();
        if (this.nHQ != null) {
            size = this.nHQ.size();
        } else {
            size = 0;
        }
        if (this.nHS != null) {
            size2 = this.nHS.size();
        } else {
            size2 = 0;
        }
        C4990ab.m7417i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", Integer.valueOf(size));
        if (size > 0) {
            int size3 = this.nHR.size();
            int max = Math.max(0, size - size3);
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[7];
            objArr[0] = C1853r.m3846Yz();
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(size);
            objArr[4] = Integer.valueOf(this.nHF ? 1 : 2);
            objArr[5] = Integer.valueOf(size3);
            objArr[6] = Integer.valueOf(max);
            c7060h.mo8381e(11220, objArr);
        }
        if (this.nHN) {
            Intent intent = getIntent();
            intent.putExtra("k_sns_label_add_label", this.nHC);
            setResult(0, intent);
            if (this.nHV) {
                C7060h.pYm.mo8381e(16097, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2));
            } else {
                C7060h.pYm.mo8381e(16097, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3));
            }
        } else {
            if (size > 0) {
                if (this.nHV) {
                    C7060h.pYm.mo8381e(16097, Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(2));
                } else {
                    C7060h.pYm.mo8381e(16097, Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(3));
                }
            }
            if (size2 > 0) {
                if (this.nHV) {
                    C7060h.pYm.mo8381e(16097, Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(2));
                } else {
                    C7060h.pYm.mo8381e(16097, Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(3));
                }
            }
            setResult(0);
        }
        finish();
        AppMethodBeat.m2505o(22567);
    }

    private void bJf() {
        AppMethodBeat.m2504i(22568);
        C4990ab.m7416i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
        bJc();
        m85683JN(getString(C25738R.string.f8706cn));
        AppMethodBeat.m2505o(22568);
    }

    /* renamed from: PK */
    private static boolean m85686PK(String str) {
        AppMethodBeat.m2504i(22569);
        if (C5046bo.isNullOrNil(C21160e.bIZ().mo64067PE(str))) {
            AppMethodBeat.m2505o(22569);
            return false;
        }
        AppMethodBeat.m2505o(22569);
        return true;
    }

    private void bJg() {
        int i;
        Iterator it;
        String str;
        String str2;
        String eR;
        cmh cmh;
        AppMethodBeat.m2504i(22570);
        String str3 = "MicroMsg.Label.ContactLabelEditUI";
        String str4 = "cpan[doUpdateContactList] addcount:%d,delcount:%d";
        Object[] objArr = new Object[2];
        if (this.nHQ == null) {
            i = 0;
        } else {
            i = this.nHQ.size();
        }
        objArr[0] = Integer.valueOf(i);
        if (this.nHS == null) {
            i = 0;
        } else {
            i = this.nHS.size();
        }
        objArr[1] = Integer.valueOf(i);
        C4990ab.m7417i(str3, str4, objArr);
        LinkedList linkedList = new LinkedList();
        if (this.nHQ != null && this.nHQ.size() > 0) {
            this.nHQ.size();
            it = this.nHQ.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                str2 = aoO.field_contactLabelIds;
                eR = C21158c.m32495eR(str2, this.nHD);
                C4990ab.m7417i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", str2, eR);
                if (!eR.equalsIgnoreCase(str2)) {
                    cmh = new cmh();
                    cmh.jBB = aoO.field_username;
                    cmh.wcD = eR;
                    linkedList.add(cmh);
                }
            }
        }
        if (this.nHS != null && this.nHS.size() > 0) {
            this.nHS.size();
            it = this.nHS.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                C9638aw.m17190ZK();
                str2 = C18628c.m29078XM().aoO(str).field_contactLabelIds;
                eR = C21158c.m32496eS(str2, this.nHD);
                C4990ab.m7417i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", str, str2, eR);
                if (!eR.equalsIgnoreCase(str2)) {
                    cmh = new cmh();
                    cmh.jBB = str;
                    cmh.wcD = eR;
                    linkedList.add(cmh);
                }
            }
        }
        if (linkedList.size() > 0) {
            C9638aw.m17182Rg().mo14541a(new C43237d(linkedList), 0);
            AppMethodBeat.m2505o(22570);
            return;
        }
        bJe();
        AppMethodBeat.m2505o(22570);
    }

    /* renamed from: PI */
    private void m85684PI(String str) {
        AppMethodBeat.m2504i(22571);
        getString(C25738R.string.f9238tz);
        this.gqo = C30379h.m48458b((Context) this, str, true, new C211663());
        AppMethodBeat.m2505o(22571);
    }

    private void bJc() {
        AppMethodBeat.m2504i(22572);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.m2505o(22572);
    }

    /* renamed from: JN */
    private void m85683JN(String str) {
        AppMethodBeat.m2504i(22573);
        C30379h.m48438a((Context) this, str, "", new C33334());
        AppMethodBeat.m2505o(22573);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(22574);
        if ((C5046bo.isNullOrNil(this.nHC) || this.nHC.equals(this.nHB)) && ((this.nHQ == null || this.nHQ.size() <= 0) && (this.nHS == null || this.nHS.size() <= 0))) {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(22574);
            return;
        }
        C30379h.m48466d(this, getString(C25738R.string.dwy), "", getString(C25738R.string.abl), getString(C25738R.string.abm), new C344035(), new C344046());
        AppMethodBeat.m2505o(22574);
    }

    /* renamed from: a */
    private void m85690a(C46619af c46619af) {
        AppMethodBeat.m2504i(22575);
        if (C21160e.bIZ().mo64069a(c46619af, "labelID")) {
            bJi();
            AppMethodBeat.m2505o(22575);
            return;
        }
        C4990ab.m7420w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
        bJh();
        AppMethodBeat.m2505o(22575);
    }

    private void bJh() {
        AppMethodBeat.m2504i(22576);
        m85683JN(getString(C25738R.string.b4x));
        AppMethodBeat.m2505o(22576);
    }

    private void bJi() {
        AppMethodBeat.m2504i(22577);
        setResult(-1);
        finish();
        AppMethodBeat.m2505o(22577);
    }

    public final String bJj() {
        if (this.nHN) {
            return "_New";
        }
        return "_Edit";
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(22563);
        String str = preference.mKey;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
            AppMethodBeat.m2505o(22563);
        } else {
            if (str.equals("contact_label_delete")) {
                C30379h.m48466d(this, getString(C25738R.string.ckx), "", getString(C25738R.string.f9088p4), getString(C25738R.string.f9076or), new C3928014(), new C33322());
            }
            C4990ab.m7411d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", str);
            AppMethodBeat.m2505o(22563);
        }
        return false;
    }

    /* renamed from: b */
    static /* synthetic */ void m85693b(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.m2504i(22579);
        C4990ab.m7416i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveLabelChange]");
        contactLabelEditUI.m85684PI(contactLabelEditUI.getString(C25738R.string.cl_));
        contactLabelEditUI.nHC = C5046bo.m7532bc(contactLabelEditUI.nHC, "");
        contactLabelEditUI.nHC = contactLabelEditUI.nHC.trim();
        if (C5046bo.isNullOrNil(contactLabelEditUI.nHC)) {
            contactLabelEditUI.bJc();
            contactLabelEditUI.m85683JN(contactLabelEditUI.getString(C25738R.string.cl2));
            AppMethodBeat.m2505o(22579);
        } else if (C5584f.asg(contactLabelEditUI.nHC) > 36) {
            contactLabelEditUI.bJc();
            contactLabelEditUI.m85683JN(String.format(contactLabelEditUI.getString(C25738R.string.f8708cp), new Object[]{Integer.valueOf(C5584f.m8385bP(36, ""))}));
            AppMethodBeat.m2505o(22579);
        } else if (!(ContactLabelEditUI.m85686PK(contactLabelEditUI.nHC) && contactLabelEditUI.nHN) && (!ContactLabelEditUI.m85686PK(contactLabelEditUI.nHC) || C5046bo.isNullOrNil(contactLabelEditUI.nHB) || contactLabelEditUI.nHB.equals(contactLabelEditUI.nHC))) {
            C46619af aoF = C21160e.bIZ().aoF(contactLabelEditUI.nHD);
            if (contactLabelEditUI.nHN || aoF.field_isTemporary) {
                C9638aw.m17182Rg().mo14541a(new C21157a(contactLabelEditUI.nHC), 0);
                AppMethodBeat.m2505o(22579);
                return;
            }
            C9638aw.m17182Rg().mo14541a(new C43238e(Integer.valueOf(contactLabelEditUI.nHD).intValue(), contactLabelEditUI.nHC), 0);
            AppMethodBeat.m2505o(22579);
        } else {
            contactLabelEditUI.bJc();
            contactLabelEditUI.m85683JN(contactLabelEditUI.getString(C25738R.string.f8705cm));
            AppMethodBeat.m2505o(22579);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m85696d(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.m2504i(22580);
        C4990ab.m7416i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealAddContact]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", C15830s.m24190C(C15830s.znE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelEditUI.getString(C25738R.string.cku));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 6);
        if (contactLabelEditUI.nHO != null) {
            intent.putExtra("always_select_contact", C5046bo.m7536c(contactLabelEditUI.nHO, ","));
        }
        C25985d.m41466b((Context) contactLabelEditUI, ".ui.contact.SelectContactUI", intent, 7001);
        AppMethodBeat.m2505o(22580);
    }

    /* renamed from: l */
    static /* synthetic */ void m85704l(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.m2504i(22583);
        if (contactLabelEditUI.nHE.field_isTemporary) {
            contactLabelEditUI.m85690a(contactLabelEditUI.nHE);
        } else {
            C46619af c46619af = contactLabelEditUI.nHE;
            if (c46619af == null) {
                C4990ab.m7420w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteScene] can not do scene. lable is null");
            } else {
                contactLabelEditUI.m85684PI(contactLabelEditUI.getString(C25738R.string.cky));
                C9638aw.m17182Rg().mo14541a(new C43235b(c46619af.field_labelID), 0);
            }
        }
        if (contactLabelEditUI.nHV) {
            C7060h.pYm.mo8381e(16097, Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2));
            AppMethodBeat.m2505o(22583);
            return;
        }
        C7060h.pYm.mo8381e(16097, Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(3));
        AppMethodBeat.m2505o(22583);
    }
}
