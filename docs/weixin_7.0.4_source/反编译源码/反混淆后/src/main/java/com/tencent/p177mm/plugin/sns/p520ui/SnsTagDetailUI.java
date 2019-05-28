package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C7108v;
import com.tencent.p177mm.plugin.sns.model.C7109w;
import com.tencent.p177mm.plugin.sns.model.C7110x;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30106k.C14929b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference.C30100a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI */
public class SnsTagDetailUI extends MMPreference implements C1202f, C4937b {
    protected String cvZ = "";
    protected C15541f ehK;
    protected ContactListExpandPreference ehS;
    protected List<String> kPL = new ArrayList();
    protected long qJQ;
    protected String rxA = "";
    private boolean rxB = false;
    protected C30100a rxC = new C398159();
    protected int scene = 0;
    protected C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI$5 */
    class C220305 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI$5$1 */
        class C220311 implements OnClickListener {
            C220311() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(39347);
                SnsTagDetailUI.this.finish();
                AppMethodBeat.m2505o(39347);
            }
        }

        C220305() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39348);
            if (!(SnsTagDetailUI.this.rxA + " " + C5046bo.m7536c(SnsTagDetailUI.this.kPL, ",")).equals(SnsTagDetailUI.this.cvZ) || SnsTagDetailUI.this.qJQ == 0) {
                C30379h.m48432a(SnsTagDetailUI.this, (int) C25738R.string.eor, (int) C25738R.string.f9238tz, new C220311(), null);
                AppMethodBeat.m2505o(39348);
            } else {
                SnsTagDetailUI.this.finish();
                AppMethodBeat.m2505o(39348);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI$6 */
    class C291396 implements OnMenuItemClickListener {
        C291396() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39349);
            SnsTagDetailUI.this.bKl();
            AppMethodBeat.m2505o(39349);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI$7 */
    class C291407 implements OnClickListener {
        C291407() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39350);
            SnsTagDetailUI.this.finish();
            AppMethodBeat.m2505o(39350);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI$2 */
    class C398142 implements OnClickListener {
        C398142() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI$9 */
    class C398159 implements C30100a {
        C398159() {
        }

        /* renamed from: iA */
        public final void mo14654iA(int i) {
            AppMethodBeat.m2504i(39352);
            String KX = SnsTagDetailUI.this.ehS.mo48351KX(i);
            C4990ab.m7410d("MicroMsg.SnsTagDetailUI", "roomPref del " + i + " userName : " + KX);
            C1720g.m3537RQ();
            if (C5046bo.m7532bc((String) C1720g.m3536RP().mo5239Ry().get(2, null), "").equals(KX)) {
                C30379h.m48467g(SnsTagDetailUI.this.mController.ylL, C25738R.string.dse, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(39352);
                return;
            }
            SnsTagDetailUI.this.mo47265km(KX);
            if (!(SnsTagDetailUI.this.rxA + " " + C5046bo.m7536c(SnsTagDetailUI.this.kPL, ",")).equals(SnsTagDetailUI.this.cvZ) || SnsTagDetailUI.this.qJQ == 0) {
                SnsTagDetailUI.this.enableOptionMenu(true);
                AppMethodBeat.m2505o(39352);
                return;
            }
            SnsTagDetailUI.this.enableOptionMenu(false);
            AppMethodBeat.m2505o(39352);
        }

        /* renamed from: iC */
        public final void mo14656iC(int i) {
            AppMethodBeat.m2504i(39353);
            C4990ab.m7410d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(i)));
            SnsTagDetailUI.m81670a(SnsTagDetailUI.this);
            AppMethodBeat.m2505o(39353);
        }

        /* renamed from: iB */
        public final void mo14655iB(int i) {
            AppMethodBeat.m2504i(39354);
            String KX = SnsTagDetailUI.this.ehS.mo48351KX(i);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", KX);
            C24826a.gkE.mo38912c(intent, SnsTagDetailUI.this);
            AppMethodBeat.m2505o(39354);
        }

        /* renamed from: JT */
        public final void mo14653JT() {
            AppMethodBeat.m2504i(39355);
            if (SnsTagDetailUI.this.ehS != null) {
                SnsTagDetailUI.this.ehS.djD();
            }
            AppMethodBeat.m2505o(39355);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI$3 */
    class C435853 implements OnCancelListener {
        C435853() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI$4 */
    class C435864 implements C14929b {
        C435864() {
        }

        /* renamed from: iD */
        public final boolean mo4758iD(int i) {
            AppMethodBeat.m2504i(39346);
            if (!SnsTagDetailUI.this.ehS.mo48349KU(i)) {
                C4990ab.m7410d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(i)));
            }
            AppMethodBeat.m2505o(39346);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTagDetailUI$1 */
    class C447671 implements OnClickListener {
        C447671() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39345);
            SnsTagDetailUI.this.csQ();
            AppMethodBeat.m2505o(39345);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsTagDetailUI() {
        AppMethodBeat.m2504i(39356);
        AppMethodBeat.m2505o(39356);
    }

    /* Access modifiers changed, original: protected */
    public void csO() {
        AppMethodBeat.m2504i(39357);
        C4990ab.m7410d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(290, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(291, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(292, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(293, (C1202f) this);
        C1720g.m3537RQ();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this);
        if (C13373af.cnL().cru().size() == 0) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C7108v(1), 0);
            this.rxB = true;
        }
        AppMethodBeat.m2505o(39357);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39358);
        super.onCreate(bundle);
        csO();
        this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
        this.qJQ = getIntent().getLongExtra("k_sns_tag_id", 0);
        if (this.qJQ == 4) {
            this.rxA = getString(C25738R.string.ep5);
        } else if (this.qJQ == 5) {
            this.rxA = getString(C25738R.string.epg);
        } else {
            this.rxA = C13373af.cnL().mo55579kF(this.qJQ).field_tagName;
        }
        if (this.qJQ == 0) {
            String stringExtra = getIntent().getStringExtra("k_sns_tag_list");
            this.rxA = C5046bo.m7532bc(getIntent().getStringExtra("k_sns_tag_name"), "");
            C7309bd cnt = C13373af.cnt();
            String Yz = C1853r.m3846Yz();
            ArrayList<String> P = C5046bo.m7508P(stringExtra.split(","));
            if (P != null) {
                for (String stringExtra2 : P) {
                    if (!(this.kPL.contains(stringExtra2) || !C7486a.m12942jh(cnt.aoO(stringExtra2).field_type) || Yz.equals(stringExtra2))) {
                        this.kPL.add(stringExtra2);
                    }
                }
            }
        } else {
            this.kPL = csS();
        }
        if (this.rxA == null || this.rxA.equals("")) {
            this.rxA = getString(C25738R.string.ep4);
            this.rxA = C34955aj.m57391XZ(getString(C25738R.string.ep4));
        }
        initView();
        ctU();
        updateTitle();
        if (this.qJQ < 6) {
            this.ehK.aqP("delete_tag_name");
            this.ehK.aqP("delete_tag_name_category");
            if (this.qJQ > 0) {
                this.ehK.aqP("settings_tag_name");
                this.ehK.aqP("settings_tag_name_category");
            }
        }
        if (this.qJQ == 4) {
            this.ehK.aqP("black");
            this.ehK.aqP("group");
        } else if (this.qJQ == 5) {
            this.ehK.aqP("outside");
            this.ehK.aqP("group");
        } else {
            this.ehK.aqP("black");
            this.ehK.aqP("outside");
        }
        if (this.qJQ == 0) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.cvZ = this.rxA + " " + C5046bo.m7536c(this.kPL, ",");
        AppMethodBeat.m2505o(39358);
    }

    /* Access modifiers changed, original: protected */
    public void csP() {
        AppMethodBeat.m2504i(39359);
        C4990ab.m7410d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(290, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(291, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(292, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(293, (C1202f) this);
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3537RQ();
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this);
        }
        AppMethodBeat.m2505o(39359);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39360);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        csP();
        super.onDestroy();
        AppMethodBeat.m2505o(39360);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8570cj;
    }

    public void onResume() {
        AppMethodBeat.m2504i(39361);
        super.onResume();
        ctU();
        AppMethodBeat.m2505o(39361);
    }

    /* Access modifiers changed, original: protected|final */
    public final void updateTitle() {
        AppMethodBeat.m2504i(39363);
        setMMTitle(this.rxA + "(" + this.kPL.size() + ")");
        AppMethodBeat.m2505o(39363);
    }

    private void ctU() {
        AppMethodBeat.m2504i(39364);
        Preference aqO = this.ehK.aqO("settings_tag_name");
        if (aqO != null) {
            if (this.rxA.length() > 20) {
                this.rxA = this.rxA.substring(0, 20);
            }
            aqO.setSummary(this.rxA);
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(39364);
    }

    /* Access modifiers changed, original: protected */
    public void csQ() {
        AppMethodBeat.m2504i(39365);
        if (this.qJQ != 0) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C7110x(this.qJQ, this.rxA), 0);
        }
        getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.epc), true, new C435853());
        AppMethodBeat.m2505o(39365);
    }

    private void ctV() {
        AppMethodBeat.m2504i(39366);
        this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
        if (this.ehS != null) {
            this.ehS.mo48357a(this.ehK, this.ehS.mKey);
            this.ehS.mo48368oD(true).mo48369oE(true);
            this.ehS.mo48371u(null, this.kPL);
            this.ehS.mo48355a(new C435864());
            this.ehS.mo48354a(this.rxC);
        }
        AppMethodBeat.m2505o(39366);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39368);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            if (!(this.rxA + " " + C5046bo.m7536c(this.kPL, ",")).equals(this.cvZ) || this.qJQ == 0) {
                C30379h.m48432a((Context) this, (int) C25738R.string.eor, (int) C25738R.string.f9238tz, new C291407(), null);
            } else {
                finish();
            }
            AppMethodBeat.m2505o(39368);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(39368);
        return dispatchKeyEvent;
    }

    /* Access modifiers changed, original: protected */
    public void bKl() {
        AppMethodBeat.m2504i(39369);
        if ((this.rxA + " " + C5046bo.m7536c(this.kPL, ",")).equals(this.cvZ) && this.qJQ != 0) {
            finish();
            AppMethodBeat.m2505o(39369);
        } else if (C13373af.cnL().mo55581v(this.qJQ, this.rxA)) {
            C30379h.m48461b((Context) this, getString(C25738R.string.eow, new Object[]{this.rxA}), getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(39369);
        } else {
            final C1207m c7109w = new C7109w(3, this.qJQ, this.rxA, this.kPL.size(), this.kPL, this.scene);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c7109w, 0);
            getString(C25738R.string.f9238tz);
            this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.epc), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(39351);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c7109w);
                    AppMethodBeat.m2505o(39351);
                }
            });
            AppMethodBeat.m2505o(39369);
        }
    }

    /* Access modifiers changed, original: protected */
    public List<String> csS() {
        AppMethodBeat.m2504i(39370);
        List<String> linkedList = new LinkedList();
        C13479t kF = C13373af.cnL().mo55579kF(this.qJQ);
        if (!(kF.field_memberList == null || kF.field_memberList.equals(""))) {
            linkedList = C5046bo.m7508P(kF.field_memberList.split(","));
        }
        AppMethodBeat.m2505o(39370);
        return linkedList;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: km */
    public void mo47265km(String str) {
        AppMethodBeat.m2504i(39371);
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(39371);
            return;
        }
        this.kPL.remove(str);
        if (this.ehS != null) {
            this.ehS.mo48360ci(this.kPL);
            this.ehS.notifyChanged();
        }
        if (this.kPL.size() == 0 && this.ehS != null) {
            this.ehS.djD();
            this.ehS.mo48368oD(true).mo48369oE(false);
            this.ehK.notifyDataSetChanged();
        } else if (this.ehS != null) {
            this.ehS.mo48368oD(true).mo48369oE(true);
        }
        updateTitle();
        AppMethodBeat.m2505o(39371);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: dr */
    public void mo47264dr(List<String> list) {
        AppMethodBeat.m2504i(39372);
        C7309bd cnt = C13373af.cnt();
        String Yz = C1853r.m3846Yz();
        for (String str : list) {
            if (!(this.kPL.contains(str) || !C7486a.m12942jh(cnt.aoO(str).field_type) || Yz.equals(str))) {
                this.kPL.add(str);
            }
        }
        if (this.ehS != null) {
            this.ehS.mo48360ci(this.kPL);
            this.ehS.notifyChanged();
        }
        if (this.kPL.size() > 0) {
            this.ehS.mo48368oD(true).mo48369oE(true);
        } else {
            this.ehS.mo48368oD(true).mo48369oE(false);
        }
        updateTitle();
        AppMethodBeat.m2505o(39372);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39373);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(39373);
            return;
        }
        String stringExtra;
        switch (i) {
            case 1:
                if (intent != null) {
                    int i3;
                    String stringExtra2 = intent.getStringExtra("Select_Contact");
                    if (C5046bo.nullAsNil(C1853r.m3846Yz()).equals(stringExtra2)) {
                        i3 = 1;
                    } else if (this.kPL == null) {
                        i3 = 0;
                    } else {
                        i3 = 0;
                        for (String stringExtra3 : this.kPL) {
                            int i4;
                            if (stringExtra3.equals(stringExtra2)) {
                                i4 = 1;
                            } else {
                                i4 = i3;
                            }
                            i3 = i4;
                        }
                    }
                    if (i3 == 0) {
                        ArrayList P = C5046bo.m7508P(stringExtra2.split(","));
                        if (P != null) {
                            mo47264dr(P);
                            break;
                        } else {
                            AppMethodBeat.m2505o(39373);
                            return;
                        }
                    }
                    C30379h.m48461b((Context) this, getString(C25738R.string.f8716cy, new Object[]{Integer.valueOf(0), Integer.valueOf(0)}), getString(C25738R.string.f9238tz), true);
                    AppMethodBeat.m2505o(39373);
                    return;
                }
                AppMethodBeat.m2505o(39373);
                return;
            case 2:
                stringExtra3 = intent.getStringExtra("k_sns_tag_name");
                if (stringExtra3 != null) {
                    this.rxA = stringExtra3;
                }
                updateTitle();
                C4990ab.m7410d("MicroMsg.SnsTagDetailUI", "updateName " + this.rxA);
                break;
            default:
                AppMethodBeat.m2505o(39373);
                return;
        }
        if (!(this.rxA + " " + C5046bo.m7536c(this.kPL, ",")).equals(this.cvZ) || this.qJQ == 0) {
            enableOptionMenu(true);
            AppMethodBeat.m2505o(39373);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.m2505o(39373);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(39374);
        C4990ab.m7416i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (c1207m.getType()) {
            case 290:
                finish();
                AppMethodBeat.m2505o(39374);
                return;
            case 291:
                finish();
                AppMethodBeat.m2505o(39374);
                return;
            case 292:
                if (!(this.ehS == null || !this.rxB || (this instanceof SnsBlackDetailUI))) {
                    C4990ab.m7410d("MicroMsg.SnsTagDetailUI", "update form net");
                    this.cvZ = this.rxA + " " + C5046bo.m7536c(((C7108v) c1207m).mo15446kk(this.qJQ), ",");
                    LinkedList linkedList = new LinkedList();
                    List<String> list = this.kPL;
                    this.kPL = csS();
                    if (list != null) {
                        for (String str2 : list) {
                            if (!this.kPL.contains(str2)) {
                                this.kPL.add(str2);
                            }
                        }
                    }
                    this.ehS.mo48360ci(this.kPL);
                    this.ehS.notifyChanged();
                    break;
                }
        }
        AppMethodBeat.m2505o(39374);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(39362);
        String str = preference.mKey;
        if (str.equals("settings_tag_name") && (this.qJQ >= 6 || this.qJQ == 0)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_mode_name_type", 3);
            intent.putExtra("Contact_Nick", C5046bo.m7532bc(this.rxA, " "));
            C24826a.gkE.mo38895a(intent, (Activity) this);
        }
        if (str.equals("delete_tag_name")) {
            C30379h.m48432a((Context) this, (int) C25738R.string.e3w, (int) C25738R.string.f9238tz, new C447671(), new C398142());
        }
        AppMethodBeat.m2505o(39362);
        return false;
    }

    public final void initView() {
        AppMethodBeat.m2504i(39367);
        this.ehK = this.yCw;
        ctV();
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        setBackBtn(new C220305());
        mo17379a(0, getString(C25738R.string.f9142qt), (OnMenuItemClickListener) new C291396(), C5535b.GREEN);
        AppMethodBeat.m2505o(39367);
    }

    /* renamed from: a */
    static /* synthetic */ void m81670a(SnsTagDetailUI snsTagDetailUI) {
        AppMethodBeat.m2504i(39375);
        String c = C5046bo.m7536c(snsTagDetailUI.kPL, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", snsTagDetailUI.getString(C25738R.string.f8782eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("KBlockOpenImFav", true);
        String str = "list_attr";
        intent.putExtra(str, C15830s.m24193hs(C15830s.m24190C(C15830s.znF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 16777216));
        intent.putExtra("always_select_contact", c);
        C25985d.m41466b((Context) snsTagDetailUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.m2505o(39375);
    }
}
