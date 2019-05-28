package com.tencent.mm.plugin.topstory.ui.home;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.k.b;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.q;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@a(3)
public class TopStorySettingVisibilityDetailUI extends MMPreference implements f {
    protected String cvZ = "";
    protected com.tencent.mm.ui.base.preference.f ehK;
    protected ContactListExpandPreference ehS;
    protected List<String> kPL = new ArrayList();
    protected long qJQ;
    protected String rxA = "";
    protected ContactListExpandPreference.a rxC = new ContactListExpandPreference.a() {
        public final void iA(int i) {
            AppMethodBeat.i(1640);
            String KX = TopStorySettingVisibilityDetailUI.this.ehS.KX(i);
            ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + i + " userName : " + KX);
            g.RQ();
            if (bo.bc((String) g.RP().Ry().get(2, null), "").equals(KX)) {
                h.b(TopStorySettingVisibilityDetailUI.this.mController.ylL, TopStorySettingVisibilityDetailUI.this.getString(R.string.dse), "", true);
                AppMethodBeat.o(1640);
                return;
            }
            TopStorySettingVisibilityDetailUI.this.km(KX);
            if (!(TopStorySettingVisibilityDetailUI.this.rxA + " " + bo.c(TopStorySettingVisibilityDetailUI.this.kPL, ",")).equals(TopStorySettingVisibilityDetailUI.this.cvZ) || TopStorySettingVisibilityDetailUI.this.qJQ == 0) {
                TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
                AppMethodBeat.o(1640);
                return;
            }
            TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
            AppMethodBeat.o(1640);
        }

        public final void iC(int i) {
            AppMethodBeat.i(1641);
            ab.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(i)));
            TopStorySettingVisibilityDetailUI.c(TopStorySettingVisibilityDetailUI.this);
            AppMethodBeat.o(1641);
        }

        public final void iB(int i) {
            AppMethodBeat.i(1642);
            String KX = TopStorySettingVisibilityDetailUI.this.ehS.KX(i);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", KX);
            d.b(TopStorySettingVisibilityDetailUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(1642);
        }

        public final void JT() {
            AppMethodBeat.i(1643);
            if (TopStorySettingVisibilityDetailUI.this.ehS != null) {
                TopStorySettingVisibilityDetailUI.this.ehS.djD();
            }
            AppMethodBeat.o(1643);
        }
    };
    protected Preference sCJ;
    protected Preference sCK;
    protected List<String> sCL = new ArrayList();
    protected List<String> sCM = new ArrayList();
    private Set<com.tencent.mm.plugin.topstory.a.c.h> sCN = new HashSet();
    protected p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TopStorySettingVisibilityDetailUI() {
        AppMethodBeat.i(1645);
        AppMethodBeat.o(1645);
    }

    static /* synthetic */ void a(TopStorySettingVisibilityDetailUI topStorySettingVisibilityDetailUI) {
        AppMethodBeat.i(1660);
        topStorySettingVisibilityDetailUI.cFH();
        AppMethodBeat.o(1660);
    }

    static /* synthetic */ boolean b(TopStorySettingVisibilityDetailUI topStorySettingVisibilityDetailUI) {
        AppMethodBeat.i(1661);
        boolean cFG = topStorySettingVisibilityDetailUI.cFG();
        AppMethodBeat.o(1661);
        return cFG;
    }

    public final int JC() {
        return R.xml.cl;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(1646);
        if ("revert_pref".equals(preference.mKey)) {
            h.d(this, getString(R.string.ga1), "", getString(R.string.ga7), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(1635);
                    for (String remove : TopStorySettingVisibilityDetailUI.this.sCM) {
                        TopStorySettingVisibilityDetailUI.this.kPL.remove(remove);
                    }
                    if (TopStorySettingVisibilityDetailUI.this.ehS != null) {
                        TopStorySettingVisibilityDetailUI.this.ehS.ci(TopStorySettingVisibilityDetailUI.this.kPL);
                        TopStorySettingVisibilityDetailUI.this.ehS.notifyChanged();
                    }
                    TopStorySettingVisibilityDetailUI.this.sCM.clear();
                    TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this);
                    TopStorySettingVisibilityDetailUI.this.updateTitle();
                    AppMethodBeat.o(1635);
                }
            }, null);
        }
        AppMethodBeat.o(1646);
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1647);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("k_topstory_user_list");
        if (!bo.isNullOrNil(stringExtra)) {
            this.sCL = Arrays.asList(stringExtra.split(","));
            for (String stringExtra2 : this.sCL) {
                if (!bo.isNullOrNil(stringExtra2)) {
                    this.kPL.add(stringExtra2);
                }
            }
        }
        initView();
        this.qJQ = (long) getIntent().getIntExtra("k_topstory_type", 0);
        if (this.qJQ == 1) {
            this.rxA = getString(R.string.ga_);
            this.sCJ.setTitle((int) R.string.gaa);
        } else {
            this.rxA = getString(R.string.g_z);
            this.sCJ.setTitle((int) R.string.ga0);
        }
        g.Rg().a(2859, (f) this);
        enableOptionMenu(false);
        updateTitle();
        this.cvZ = this.rxA + " " + bo.c(this.kPL, ",");
        AppMethodBeat.o(1647);
    }

    public void onDestroy() {
        AppMethodBeat.i(1648);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        g.Rg().b(2859, (f) this);
        super.onDestroy();
        AppMethodBeat.o(1648);
    }

    private boolean cFG() {
        AppMethodBeat.i(1650);
        if ((this.rxA + " " + bo.c(this.kPL, ",")).equals(this.cvZ)) {
            finish();
            AppMethodBeat.o(1650);
            return true;
        }
        int i = R.string.ga1;
        if (this.tipDialog != null) {
            i = R.string.ga3;
        }
        h.d(this, getString(i), "", getString(R.string.ga7), getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(1638);
                TopStorySettingVisibilityDetailUI.this.finish();
                AppMethodBeat.o(1638);
            }
        }, null);
        AppMethodBeat.o(1650);
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(1651);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            cFG();
            AppMethodBeat.o(1651);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(1651);
        return dispatchKeyEvent;
    }

    private void ctV() {
        AppMethodBeat.i(1652);
        this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
        if (this.ehS != null) {
            this.ehS.a(this.ehK, this.ehS.mKey);
            this.ehS.oD(true).oE(true);
            this.ehS.u(null, this.kPL);
            this.ehS.a(new b() {
                public final boolean iD(int i) {
                    AppMethodBeat.i(1639);
                    if (!TopStorySettingVisibilityDetailUI.this.ehS.KU(i)) {
                        ab.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(i)));
                    }
                    AppMethodBeat.o(1639);
                    return true;
                }
            });
            this.ehS.a(this.rxC);
        }
        this.sCJ = this.ehK.aqO("desc");
        this.sCK = this.ehK.aqO("revert_pref");
        this.ehK.ce("revert_pref", true);
        AppMethodBeat.o(1652);
    }

    /* Access modifiers changed, original: protected|final */
    public final void updateTitle() {
        AppMethodBeat.i(1653);
        setMMTitle(this.rxA + "(" + this.kPL.size() + ")");
        AppMethodBeat.o(1653);
    }

    @SuppressLint({"StringFormatMatches"})
    private void cFH() {
        AppMethodBeat.i(1654);
        if (this.sCM.isEmpty()) {
            this.ehK.ce("revert_pref", true);
            AppMethodBeat.o(1654);
            return;
        }
        this.ehK.ce("revert_pref", false);
        this.sCK.setTitle(getString(R.string.ga4, new Object[]{Integer.valueOf(this.sCM.size())}));
        AppMethodBeat.o(1654);
    }

    /* Access modifiers changed, original: protected|final */
    public final void km(String str) {
        AppMethodBeat.i(1655);
        ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
        if (str == null || str.equals("")) {
            AppMethodBeat.o(1655);
            return;
        }
        this.kPL.remove(str);
        if (this.ehS != null) {
            this.ehS.ci(this.kPL);
            this.ehS.notifyChanged();
        }
        if (this.kPL.size() == 0 && this.ehS != null) {
            this.ehS.djD();
            this.ehS.oD(true).oE(false);
            this.ehK.notifyDataSetChanged();
        } else if (this.ehS != null) {
            this.ehS.oD(true).oE(true);
        }
        this.sCM.clear();
        cFH();
        updateTitle();
        AppMethodBeat.o(1655);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(1656);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(1656);
            return;
        }
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(1656);
                    return;
                }
                boolean z;
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (bo.nullAsNil(r.Yz()).equals(stringExtra)) {
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
                    h.b((Context) this, getString(R.string.cy), "", true);
                    AppMethodBeat.o(1656);
                    return;
                }
                ArrayList P = bo.P(stringExtra.split(","));
                if (P == null) {
                    AppMethodBeat.o(1656);
                    return;
                }
                String stringExtra2 = intent.getStringExtra("App_MsgId");
                if (bo.isNullOrNil(stringExtra2) || !stringExtra2.equals("fromSns")) {
                    h(P, true);
                } else {
                    h(P, false);
                }
                if (!(this.rxA + " " + bo.c(this.kPL, ",")).equals(this.cvZ) || this.qJQ == 0) {
                    enableOptionMenu(true);
                    AppMethodBeat.o(1656);
                    return;
                }
                enableOptionMenu(false);
                AppMethodBeat.o(1656);
                return;
            default:
                AppMethodBeat.o(1656);
                return;
        }
    }

    private void h(List<String> list, boolean z) {
        AppMethodBeat.i(1657);
        String str = "MicroMsg.TopStory.TopStorySettingVisibilityDetailUI";
        String str2 = "dealOnAddContact %s";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
        ab.i(str, str2, objArr);
        g.RQ();
        bd XM = ((j) g.K(j.class)).XM();
        str2 = r.Yz();
        for (String str3 : list) {
            if (!(this.kPL.contains(str3) || str2.equals(str3))) {
                if (com.tencent.mm.n.a.jh(XM.aoO(str3).field_type) || !z) {
                    this.kPL.add(str3);
                    this.sCM.add(str3);
                }
            }
        }
        if (this.ehS != null) {
            this.ehS.ci(this.kPL);
            this.ehS.notifyChanged();
        }
        if (this.kPL.size() > 0) {
            this.ehS.oD(true).oE(true);
        } else {
            this.ehS.oD(true).oE(false);
        }
        cFH();
        updateTitle();
        AppMethodBeat.o(1657);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(1659);
        ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar instanceof com.tencent.mm.plugin.topstory.a.c.h) {
            boolean z;
            com.tencent.mm.plugin.topstory.a.c.h hVar = (com.tencent.mm.plugin.topstory.a.c.h) mVar;
            boolean z2 = i == 0 && i2 == 0;
            if (!z2 || ((th) hVar.ehh.fsH.fsP).BaseResponse.Ret == 0) {
                z = z2;
            } else {
                ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", Integer.valueOf(((th) hVar.ehh.fsH.fsP).BaseResponse.Ret));
                z = false;
            }
            ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", Boolean.valueOf(z));
            if (!z) {
                hVar.fLW++;
                if (hVar.fLW < 2) {
                    m hVar2 = new com.tencent.mm.plugin.topstory.a.c.h(hVar);
                    g.RO().eJo.a(hVar2, 0);
                    this.sCN.add(hVar2);
                }
            }
            if (this.sCN.contains(mVar)) {
                this.sCN.remove(mVar);
                ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", Integer.valueOf(this.sCN.size()));
                if (this.sCN.isEmpty()) {
                    if (this.tipDialog != null) {
                        this.tipDialog.dismiss();
                        this.tipDialog = null;
                    }
                    finish();
                }
            }
        }
        AppMethodBeat.o(1659);
    }

    public final void initView() {
        AppMethodBeat.i(1649);
        this.ehK = this.yCw;
        ctV();
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(1636);
                TopStorySettingVisibilityDetailUI.b(TopStorySettingVisibilityDetailUI.this);
                AppMethodBeat.o(1636);
                return true;
            }
        });
        a(0, getString(R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(1637);
                TopStorySettingVisibilityDetailUI.this.bKl();
                AppMethodBeat.o(1637);
                return true;
            }
        }, q.b.GREEN);
        AppMethodBeat.o(1649);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKl() {
        int acS;
        AppMethodBeat.i(1658);
        if (((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG()) {
            acS = g.Rg().acS();
            if (acS == 4 || acS == 6) {
                acS = 1;
            } else {
                acS = 0;
            }
        } else {
            if (at.isConnected(ah.getContext())) {
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
            t.makeText(this, R.string.ga6, 0).show();
            AppMethodBeat.o(1658);
        } else if (!(this.rxA + " " + bo.c(this.kPL, ",")).equals(this.cvZ) || this.qJQ == 0) {
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
            getString(R.string.tz);
            this.tipDialog = h.b((Context) this, getString(R.string.ga9), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(1644);
                    for (m c : TopStorySettingVisibilityDetailUI.this.sCN) {
                        g.RO().eJo.c(c);
                    }
                    AppMethodBeat.o(1644);
                }
            });
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
                this.sCN.add(new com.tencent.mm.plugin.topstory.a.c.h(arrayList3, arrayList4));
            }
            ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", Integer.valueOf(this.sCN.size()));
            for (m a : this.sCN) {
                g.RO().eJo.a(a, 0);
            }
            AppMethodBeat.o(1658);
        } else {
            finish();
            AppMethodBeat.o(1658);
        }
    }

    static /* synthetic */ void c(TopStorySettingVisibilityDetailUI topStorySettingVisibilityDetailUI) {
        int i = 2;
        AppMethodBeat.i(1662);
        String c = bo.c(topStorySettingVisibilityDetailUI.kPL, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", topStorySettingVisibilityDetailUI.getString(R.string.eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("KBlockOpenImFav", true);
        intent.putExtra("show_too_many_member", false);
        int[] iArr = new int[]{s.znF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT};
        String str = "list_attr";
        intent.putExtra(str, s.hs(s.C(s.C(iArr), SQLiteGlobal.journalSizeLimit), 16777216));
        intent.putExtra("always_select_contact", c);
        c = "topstory_import_type";
        if (topStorySettingVisibilityDetailUI.qJQ == 1) {
            i = 1;
        }
        intent.putExtra(c, i);
        d.b((Context) topStorySettingVisibilityDetailUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(1662);
    }
}
