package com.tencent.p177mm.plugin.topstory.p541ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C39962h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30106k.C14929b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference.C30100a;
import com.tencent.p177mm.protocal.protobuf.C44170th;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI */
public class TopStorySettingVisibilityDetailUI extends MMPreference implements C1202f {
    protected String cvZ = "";
    protected C15541f ehK;
    protected ContactListExpandPreference ehS;
    protected List<String> kPL = new ArrayList();
    protected long qJQ;
    protected String rxA = "";
    protected C30100a rxC = new C294356();
    protected Preference sCJ;
    protected Preference sCK;
    protected List<String> sCL = new ArrayList();
    protected List<String> sCM = new ArrayList();
    private Set<C39962h> sCN = new HashSet();
    protected C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI$2 */
    class C42172 implements OnMenuItemClickListener {
        C42172() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(1636);
            TopStorySettingVisibilityDetailUI.m46705b(TopStorySettingVisibilityDetailUI.this);
            AppMethodBeat.m2505o(1636);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI$3 */
    class C42183 implements OnMenuItemClickListener {
        C42183() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(1637);
            TopStorySettingVisibilityDetailUI.this.bKl();
            AppMethodBeat.m2505o(1637);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI$4 */
    class C42194 implements OnClickListener {
        C42194() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(1638);
            TopStorySettingVisibilityDetailUI.this.finish();
            AppMethodBeat.m2505o(1638);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI$5 */
    class C42205 implements C14929b {
        C42205() {
        }

        /* renamed from: iD */
        public final boolean mo4758iD(int i) {
            AppMethodBeat.m2504i(1639);
            if (!TopStorySettingVisibilityDetailUI.this.ehS.mo48349KU(i)) {
                C4990ab.m7410d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(i)));
            }
            AppMethodBeat.m2505o(1639);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI$1 */
    class C294341 implements OnClickListener {
        C294341() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(1635);
            for (String remove : TopStorySettingVisibilityDetailUI.this.sCM) {
                TopStorySettingVisibilityDetailUI.this.kPL.remove(remove);
            }
            if (TopStorySettingVisibilityDetailUI.this.ehS != null) {
                TopStorySettingVisibilityDetailUI.this.ehS.mo48360ci(TopStorySettingVisibilityDetailUI.this.kPL);
                TopStorySettingVisibilityDetailUI.this.ehS.notifyChanged();
            }
            TopStorySettingVisibilityDetailUI.this.sCM.clear();
            TopStorySettingVisibilityDetailUI.m46704a(TopStorySettingVisibilityDetailUI.this);
            TopStorySettingVisibilityDetailUI.this.updateTitle();
            AppMethodBeat.m2505o(1635);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI$6 */
    class C294356 implements C30100a {
        C294356() {
        }

        /* renamed from: iA */
        public final void mo14654iA(int i) {
            AppMethodBeat.m2504i(1640);
            String KX = TopStorySettingVisibilityDetailUI.this.ehS.mo48351KX(i);
            C4990ab.m7416i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + i + " userName : " + KX);
            C1720g.m3537RQ();
            if (C5046bo.m7532bc((String) C1720g.m3536RP().mo5239Ry().get(2, null), "").equals(KX)) {
                C30379h.m48461b(TopStorySettingVisibilityDetailUI.this.mController.ylL, TopStorySettingVisibilityDetailUI.this.getString(C25738R.string.dse), "", true);
                AppMethodBeat.m2505o(1640);
                return;
            }
            TopStorySettingVisibilityDetailUI.this.mo47668km(KX);
            if (!(TopStorySettingVisibilityDetailUI.this.rxA + " " + C5046bo.m7536c(TopStorySettingVisibilityDetailUI.this.kPL, ",")).equals(TopStorySettingVisibilityDetailUI.this.cvZ) || TopStorySettingVisibilityDetailUI.this.qJQ == 0) {
                TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
                AppMethodBeat.m2505o(1640);
                return;
            }
            TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
            AppMethodBeat.m2505o(1640);
        }

        /* renamed from: iC */
        public final void mo14656iC(int i) {
            AppMethodBeat.m2504i(1641);
            C4990ab.m7410d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(i)));
            TopStorySettingVisibilityDetailUI.m46706c(TopStorySettingVisibilityDetailUI.this);
            AppMethodBeat.m2505o(1641);
        }

        /* renamed from: iB */
        public final void mo14655iB(int i) {
            AppMethodBeat.m2504i(1642);
            String KX = TopStorySettingVisibilityDetailUI.this.ehS.mo48351KX(i);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", KX);
            C25985d.m41467b(TopStorySettingVisibilityDetailUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.m2505o(1642);
        }

        /* renamed from: JT */
        public final void mo14653JT() {
            AppMethodBeat.m2504i(1643);
            if (TopStorySettingVisibilityDetailUI.this.ehS != null) {
                TopStorySettingVisibilityDetailUI.this.ehS.djD();
            }
            AppMethodBeat.m2505o(1643);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI$7 */
    class C294367 implements OnCancelListener {
        C294367() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(1644);
            for (C1207m c : TopStorySettingVisibilityDetailUI.this.sCN) {
                C1720g.m3535RO().eJo.mo14547c(c);
            }
            AppMethodBeat.m2505o(1644);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public TopStorySettingVisibilityDetailUI() {
        AppMethodBeat.m2504i(1645);
        AppMethodBeat.m2505o(1645);
    }

    /* renamed from: a */
    static /* synthetic */ void m46704a(TopStorySettingVisibilityDetailUI topStorySettingVisibilityDetailUI) {
        AppMethodBeat.m2504i(1660);
        topStorySettingVisibilityDetailUI.cFH();
        AppMethodBeat.m2505o(1660);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m46705b(TopStorySettingVisibilityDetailUI topStorySettingVisibilityDetailUI) {
        AppMethodBeat.m2504i(1661);
        boolean cFG = topStorySettingVisibilityDetailUI.cFG();
        AppMethodBeat.m2505o(1661);
        return cFG;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8572cl;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(1646);
        if ("revert_pref".equals(preference.mKey)) {
            C30379h.m48466d(this, getString(C25738R.string.ga1), "", getString(C25738R.string.ga7), getString(C25738R.string.f9076or), new C294341(), null);
        }
        AppMethodBeat.m2505o(1646);
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1647);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("k_topstory_user_list");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.sCL = Arrays.asList(stringExtra.split(","));
            for (String stringExtra2 : this.sCL) {
                if (!C5046bo.isNullOrNil(stringExtra2)) {
                    this.kPL.add(stringExtra2);
                }
            }
        }
        initView();
        this.qJQ = (long) getIntent().getIntExtra("k_topstory_type", 0);
        if (this.qJQ == 1) {
            this.rxA = getString(C25738R.string.ga_);
            this.sCJ.setTitle((int) C25738R.string.gaa);
        } else {
            this.rxA = getString(C25738R.string.g_z);
            this.sCJ.setTitle((int) C25738R.string.ga0);
        }
        C1720g.m3540Rg().mo14539a(2859, (C1202f) this);
        enableOptionMenu(false);
        updateTitle();
        this.cvZ = this.rxA + " " + C5046bo.m7536c(this.kPL, ",");
        AppMethodBeat.m2505o(1647);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(1648);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        C1720g.m3540Rg().mo14546b(2859, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(1648);
    }

    private boolean cFG() {
        AppMethodBeat.m2504i(1650);
        if ((this.rxA + " " + C5046bo.m7536c(this.kPL, ",")).equals(this.cvZ)) {
            finish();
            AppMethodBeat.m2505o(1650);
            return true;
        }
        int i = C25738R.string.ga1;
        if (this.tipDialog != null) {
            i = C25738R.string.ga3;
        }
        C30379h.m48466d(this, getString(i), "", getString(C25738R.string.ga7), getString(C25738R.string.f9076or), new C42194(), null);
        AppMethodBeat.m2505o(1650);
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(1651);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            cFG();
            AppMethodBeat.m2505o(1651);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(1651);
        return dispatchKeyEvent;
    }

    private void ctV() {
        AppMethodBeat.m2504i(1652);
        this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
        if (this.ehS != null) {
            this.ehS.mo48357a(this.ehK, this.ehS.mKey);
            this.ehS.mo48368oD(true).mo48369oE(true);
            this.ehS.mo48371u(null, this.kPL);
            this.ehS.mo48355a(new C42205());
            this.ehS.mo48354a(this.rxC);
        }
        this.sCJ = this.ehK.aqO("desc");
        this.sCK = this.ehK.aqO("revert_pref");
        this.ehK.mo27715ce("revert_pref", true);
        AppMethodBeat.m2505o(1652);
    }

    /* Access modifiers changed, original: protected|final */
    public final void updateTitle() {
        AppMethodBeat.m2504i(1653);
        setMMTitle(this.rxA + "(" + this.kPL.size() + ")");
        AppMethodBeat.m2505o(1653);
    }

    @SuppressLint({"StringFormatMatches"})
    private void cFH() {
        AppMethodBeat.m2504i(1654);
        if (this.sCM.isEmpty()) {
            this.ehK.mo27715ce("revert_pref", true);
            AppMethodBeat.m2505o(1654);
            return;
        }
        this.ehK.mo27715ce("revert_pref", false);
        this.sCK.setTitle(getString(C25738R.string.ga4, new Object[]{Integer.valueOf(this.sCM.size())}));
        AppMethodBeat.m2505o(1654);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: km */
    public final void mo47668km(String str) {
        AppMethodBeat.m2504i(1655);
        C4990ab.m7416i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(1655);
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
        this.sCM.clear();
        cFH();
        updateTitle();
        AppMethodBeat.m2505o(1655);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(1656);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(1656);
            return;
        }
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.m2505o(1656);
                    return;
                }
                boolean z;
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (C5046bo.nullAsNil(C1853r.m3846Yz()).equals(stringExtra)) {
                    z = true;
                } else if (this.kPL == null) {
                    z = false;
                } else {
                    z = false;
                    for (String equals : this.kPL) {
                        boolean z2;
                        if (equals.equals(stringExtra)) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    }
                }
                if (z) {
                    C30379h.m48461b((Context) this, getString(C25738R.string.f8716cy), "", true);
                    AppMethodBeat.m2505o(1656);
                    return;
                }
                ArrayList P = C5046bo.m7508P(stringExtra.split(","));
                if (P == null) {
                    AppMethodBeat.m2505o(1656);
                    return;
                }
                String stringExtra2 = intent.getStringExtra("App_MsgId");
                if (C5046bo.isNullOrNil(stringExtra2) || !stringExtra2.equals("fromSns")) {
                    m46708h(P, true);
                } else {
                    m46708h(P, false);
                }
                if (!(this.rxA + " " + C5046bo.m7536c(this.kPL, ",")).equals(this.cvZ) || this.qJQ == 0) {
                    enableOptionMenu(true);
                    AppMethodBeat.m2505o(1656);
                    return;
                }
                enableOptionMenu(false);
                AppMethodBeat.m2505o(1656);
                return;
            default:
                AppMethodBeat.m2505o(1656);
                return;
        }
    }

    /* renamed from: h */
    private void m46708h(List<String> list, boolean z) {
        AppMethodBeat.m2504i(1657);
        String str = "MicroMsg.TopStory.TopStorySettingVisibilityDetailUI";
        String str2 = "dealOnAddContact %s";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
        C4990ab.m7417i(str, str2, objArr);
        C1720g.m3537RQ();
        C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
        str2 = C1853r.m3846Yz();
        for (String str3 : list) {
            if (!(this.kPL.contains(str3) || str2.equals(str3))) {
                if (C7486a.m12942jh(XM.aoO(str3).field_type) || !z) {
                    this.kPL.add(str3);
                    this.sCM.add(str3);
                }
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
        cFH();
        updateTitle();
        AppMethodBeat.m2505o(1657);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(1659);
        C4990ab.m7416i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m instanceof C39962h) {
            boolean z;
            C39962h c39962h = (C39962h) c1207m;
            boolean z2 = i == 0 && i2 == 0;
            if (!z2 || ((C44170th) c39962h.ehh.fsH.fsP).BaseResponse.Ret == 0) {
                z = z2;
            } else {
                C4990ab.m7417i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", Integer.valueOf(((C44170th) c39962h.ehh.fsH.fsP).BaseResponse.Ret));
                z = false;
            }
            C4990ab.m7417i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", Boolean.valueOf(z));
            if (!z) {
                c39962h.fLW++;
                if (c39962h.fLW < 2) {
                    C1207m c39962h2 = new C39962h(c39962h);
                    C1720g.m3535RO().eJo.mo14541a(c39962h2, 0);
                    this.sCN.add(c39962h2);
                }
            }
            if (this.sCN.contains(c1207m)) {
                this.sCN.remove(c1207m);
                C4990ab.m7417i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", Integer.valueOf(this.sCN.size()));
                if (this.sCN.isEmpty()) {
                    if (this.tipDialog != null) {
                        this.tipDialog.dismiss();
                        this.tipDialog = null;
                    }
                    finish();
                }
            }
        }
        AppMethodBeat.m2505o(1659);
    }

    public final void initView() {
        AppMethodBeat.m2504i(1649);
        this.ehK = this.yCw;
        ctV();
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        setBackBtn(new C42172());
        mo17379a(0, getString(C25738R.string.f9142qt), (OnMenuItemClickListener) new C42183(), C5535b.GREEN);
        AppMethodBeat.m2505o(1649);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKl() {
        int acS;
        AppMethodBeat.m2504i(1658);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            acS = C1720g.m3540Rg().acS();
            if (acS == 4 || acS == 6) {
                acS = 1;
            } else {
                acS = 0;
            }
        } else {
            if (C5023at.isConnected(C4996ah.getContext())) {
                acS = 6;
            } else {
                acS = 0;
            }
            if (acS == 6) {
                acS = 1;
            } else {
                acS = 0;
            }
        }
        if (acS == 0) {
            C23639t.makeText(this, C25738R.string.ga6, 0).show();
            AppMethodBeat.m2505o(1658);
        } else if (!(this.rxA + " " + C5046bo.m7536c(this.kPL, ",")).equals(this.cvZ) || this.qJQ == 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str : this.kPL) {
                if (!this.sCL.contains(str)) {
                    arrayList.add(str);
                    if (this.qJQ == 1) {
                        arrayList2.add(Integer.valueOf(3));
                    } else {
                        arrayList2.add(Integer.valueOf(1));
                    }
                }
            }
            for (String str2 : this.sCL) {
                if (!this.kPL.contains(str2)) {
                    arrayList.add(str2);
                    if (this.qJQ == 1) {
                        arrayList2.add(Integer.valueOf(4));
                    } else {
                        arrayList2.add(Integer.valueOf(2));
                    }
                }
            }
            getString(C25738R.string.f9238tz);
            this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.ga9), true, new C294367());
            this.sCN.clear();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            acS = 0;
            while (acS < arrayList.size()) {
                arrayList3.clear();
                arrayList4.clear();
                int i = 0;
                while (acS < arrayList.size() && i < 50) {
                    arrayList3.add(arrayList.get(acS));
                    arrayList4.add(arrayList2.get(acS));
                    acS++;
                    i++;
                }
                this.sCN.add(new C39962h(arrayList3, arrayList4));
            }
            C4990ab.m7417i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", Integer.valueOf(this.sCN.size()));
            for (C1207m a : this.sCN) {
                C1720g.m3535RO().eJo.mo14541a(a, 0);
            }
            AppMethodBeat.m2505o(1658);
        } else {
            finish();
            AppMethodBeat.m2505o(1658);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m46706c(TopStorySettingVisibilityDetailUI topStorySettingVisibilityDetailUI) {
        int i = 2;
        AppMethodBeat.m2504i(1662);
        String c = C5046bo.m7536c(topStorySettingVisibilityDetailUI.kPL, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", topStorySettingVisibilityDetailUI.getString(C25738R.string.f8782eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("KBlockOpenImFav", true);
        intent.putExtra("show_too_many_member", false);
        int[] iArr = new int[]{C15830s.znF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT};
        String str = "list_attr";
        intent.putExtra(str, C15830s.m24193hs(C15830s.m24190C(C15830s.m24190C(iArr), SQLiteGlobal.journalSizeLimit), 16777216));
        intent.putExtra("always_select_contact", c);
        c = "topstory_import_type";
        if (topStorySettingVisibilityDetailUI.qJQ == 1) {
            i = 1;
        }
        intent.putExtra(c, i);
        C25985d.m41466b((Context) topStorySettingVisibilityDetailUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.m2505o(1662);
    }
}
