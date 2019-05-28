package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI extends MMPreference implements f, b {
    protected String cvZ = "";
    protected com.tencent.mm.ui.base.preference.f ehK;
    protected ContactListExpandPreference ehS;
    protected List<String> kPL = new ArrayList();
    protected long qJQ;
    protected String rxA = "";
    private boolean rxB = false;
    protected a rxC = new a() {
        public final void iA(int i) {
            AppMethodBeat.i(39352);
            String KX = SnsTagDetailUI.this.ehS.KX(i);
            ab.d("MicroMsg.SnsTagDetailUI", "roomPref del " + i + " userName : " + KX);
            g.RQ();
            if (bo.bc((String) g.RP().Ry().get(2, null), "").equals(KX)) {
                h.g(SnsTagDetailUI.this.mController.ylL, R.string.dse, R.string.tz);
                AppMethodBeat.o(39352);
                return;
            }
            SnsTagDetailUI.this.km(KX);
            if (!(SnsTagDetailUI.this.rxA + " " + bo.c(SnsTagDetailUI.this.kPL, ",")).equals(SnsTagDetailUI.this.cvZ) || SnsTagDetailUI.this.qJQ == 0) {
                SnsTagDetailUI.this.enableOptionMenu(true);
                AppMethodBeat.o(39352);
                return;
            }
            SnsTagDetailUI.this.enableOptionMenu(false);
            AppMethodBeat.o(39352);
        }

        public final void iC(int i) {
            AppMethodBeat.i(39353);
            ab.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(i)));
            SnsTagDetailUI.a(SnsTagDetailUI.this);
            AppMethodBeat.o(39353);
        }

        public final void iB(int i) {
            AppMethodBeat.i(39354);
            String KX = SnsTagDetailUI.this.ehS.KX(i);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", KX);
            com.tencent.mm.plugin.sns.c.a.gkE.c(intent, SnsTagDetailUI.this);
            AppMethodBeat.o(39354);
        }

        public final void JT() {
            AppMethodBeat.i(39355);
            if (SnsTagDetailUI.this.ehS != null) {
                SnsTagDetailUI.this.ehS.djD();
            }
            AppMethodBeat.o(39355);
        }
    };
    protected int scene = 0;
    protected p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsTagDetailUI() {
        AppMethodBeat.i(39356);
        AppMethodBeat.o(39356);
    }

    /* Access modifiers changed, original: protected */
    public void csO() {
        AppMethodBeat.i(39357);
        ab.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
        g.RQ();
        g.RO().eJo.a(290, (f) this);
        g.RQ();
        g.RO().eJo.a(291, (f) this);
        g.RQ();
        g.RO().eJo.a(292, (f) this);
        g.RQ();
        g.RO().eJo.a(293, (f) this);
        g.RQ();
        ((j) g.K(j.class)).XM().a(this);
        if (af.cnL().cru().size() == 0) {
            g.RQ();
            g.RO().eJo.a(new v(1), 0);
            this.rxB = true;
        }
        AppMethodBeat.o(39357);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39358);
        super.onCreate(bundle);
        csO();
        this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
        this.qJQ = getIntent().getLongExtra("k_sns_tag_id", 0);
        if (this.qJQ == 4) {
            this.rxA = getString(R.string.ep5);
        } else if (this.qJQ == 5) {
            this.rxA = getString(R.string.epg);
        } else {
            this.rxA = af.cnL().kF(this.qJQ).field_tagName;
        }
        if (this.qJQ == 0) {
            String stringExtra = getIntent().getStringExtra("k_sns_tag_list");
            this.rxA = bo.bc(getIntent().getStringExtra("k_sns_tag_name"), "");
            bd cnt = af.cnt();
            String Yz = r.Yz();
            ArrayList<String> P = bo.P(stringExtra.split(","));
            if (P != null) {
                for (String stringExtra2 : P) {
                    if (!(this.kPL.contains(stringExtra2) || !com.tencent.mm.n.a.jh(cnt.aoO(stringExtra2).field_type) || Yz.equals(stringExtra2))) {
                        this.kPL.add(stringExtra2);
                    }
                }
            }
        } else {
            this.kPL = csS();
        }
        if (this.rxA == null || this.rxA.equals("")) {
            this.rxA = getString(R.string.ep4);
            this.rxA = aj.XZ(getString(R.string.ep4));
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
        this.cvZ = this.rxA + " " + bo.c(this.kPL, ",");
        AppMethodBeat.o(39358);
    }

    /* Access modifiers changed, original: protected */
    public void csP() {
        AppMethodBeat.i(39359);
        ab.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
        g.RQ();
        g.RO().eJo.b(290, (f) this);
        g.RQ();
        g.RO().eJo.b(291, (f) this);
        g.RQ();
        g.RO().eJo.b(292, (f) this);
        g.RQ();
        g.RO().eJo.b(293, (f) this);
        g.RQ();
        if (g.RN().QY()) {
            g.RQ();
            ((j) g.K(j.class)).XM().b(this);
        }
        AppMethodBeat.o(39359);
    }

    public void onDestroy() {
        AppMethodBeat.i(39360);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        csP();
        super.onDestroy();
        AppMethodBeat.o(39360);
    }

    public final void a(int i, n nVar, Object obj) {
    }

    public final int JC() {
        return R.xml.cj;
    }

    public void onResume() {
        AppMethodBeat.i(39361);
        super.onResume();
        ctU();
        AppMethodBeat.o(39361);
    }

    /* Access modifiers changed, original: protected|final */
    public final void updateTitle() {
        AppMethodBeat.i(39363);
        setMMTitle(this.rxA + "(" + this.kPL.size() + ")");
        AppMethodBeat.o(39363);
    }

    private void ctU() {
        AppMethodBeat.i(39364);
        Preference aqO = this.ehK.aqO("settings_tag_name");
        if (aqO != null) {
            if (this.rxA.length() > 20) {
                this.rxA = this.rxA.substring(0, 20);
            }
            aqO.setSummary(this.rxA);
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.o(39364);
    }

    /* Access modifiers changed, original: protected */
    public void csQ() {
        AppMethodBeat.i(39365);
        if (this.qJQ != 0) {
            g.RQ();
            g.RO().eJo.a(new x(this.qJQ, this.rxA), 0);
        }
        getString(R.string.tz);
        this.tipDialog = h.b((Context) this, getString(R.string.epc), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(39365);
    }

    private void ctV() {
        AppMethodBeat.i(39366);
        this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
        if (this.ehS != null) {
            this.ehS.a(this.ehK, this.ehS.mKey);
            this.ehS.oD(true).oE(true);
            this.ehS.u(null, this.kPL);
            this.ehS.a(new k.b() {
                public final boolean iD(int i) {
                    AppMethodBeat.i(39346);
                    if (!SnsTagDetailUI.this.ehS.KU(i)) {
                        ab.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(i)));
                    }
                    AppMethodBeat.o(39346);
                    return true;
                }
            });
            this.ehS.a(this.rxC);
        }
        AppMethodBeat.o(39366);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(39368);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            if (!(this.rxA + " " + bo.c(this.kPL, ",")).equals(this.cvZ) || this.qJQ == 0) {
                h.a((Context) this, (int) R.string.eor, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(39350);
                        SnsTagDetailUI.this.finish();
                        AppMethodBeat.o(39350);
                    }
                }, null);
            } else {
                finish();
            }
            AppMethodBeat.o(39368);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(39368);
        return dispatchKeyEvent;
    }

    /* Access modifiers changed, original: protected */
    public void bKl() {
        AppMethodBeat.i(39369);
        if ((this.rxA + " " + bo.c(this.kPL, ",")).equals(this.cvZ) && this.qJQ != 0) {
            finish();
            AppMethodBeat.o(39369);
        } else if (af.cnL().v(this.qJQ, this.rxA)) {
            h.b((Context) this, getString(R.string.eow, new Object[]{this.rxA}), getString(R.string.tz), true);
            AppMethodBeat.o(39369);
        } else {
            final m wVar = new w(3, this.qJQ, this.rxA, this.kPL.size(), this.kPL, this.scene);
            g.RQ();
            g.RO().eJo.a(wVar, 0);
            getString(R.string.tz);
            this.tipDialog = h.b((Context) this, getString(R.string.epc), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(39351);
                    g.RQ();
                    g.RO().eJo.c(wVar);
                    AppMethodBeat.o(39351);
                }
            });
            AppMethodBeat.o(39369);
        }
    }

    /* Access modifiers changed, original: protected */
    public List<String> csS() {
        AppMethodBeat.i(39370);
        List<String> linkedList = new LinkedList();
        t kF = af.cnL().kF(this.qJQ);
        if (!(kF.field_memberList == null || kF.field_memberList.equals(""))) {
            linkedList = bo.P(kF.field_memberList.split(","));
        }
        AppMethodBeat.o(39370);
        return linkedList;
    }

    /* Access modifiers changed, original: protected */
    public void km(String str) {
        AppMethodBeat.i(39371);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(39371);
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
        updateTitle();
        AppMethodBeat.o(39371);
    }

    /* Access modifiers changed, original: protected */
    public void dr(List<String> list) {
        AppMethodBeat.i(39372);
        bd cnt = af.cnt();
        String Yz = r.Yz();
        for (String str : list) {
            if (!(this.kPL.contains(str) || !com.tencent.mm.n.a.jh(cnt.aoO(str).field_type) || Yz.equals(str))) {
                this.kPL.add(str);
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
        updateTitle();
        AppMethodBeat.o(39372);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39373);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(39373);
            return;
        }
        String stringExtra;
        switch (i) {
            case 1:
                if (intent != null) {
                    int i3;
                    String stringExtra2 = intent.getStringExtra("Select_Contact");
                    if (bo.nullAsNil(r.Yz()).equals(stringExtra2)) {
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
                        ArrayList P = bo.P(stringExtra2.split(","));
                        if (P != null) {
                            dr(P);
                            break;
                        } else {
                            AppMethodBeat.o(39373);
                            return;
                        }
                    }
                    h.b((Context) this, getString(R.string.cy, new Object[]{Integer.valueOf(0), Integer.valueOf(0)}), getString(R.string.tz), true);
                    AppMethodBeat.o(39373);
                    return;
                }
                AppMethodBeat.o(39373);
                return;
            case 2:
                stringExtra3 = intent.getStringExtra("k_sns_tag_name");
                if (stringExtra3 != null) {
                    this.rxA = stringExtra3;
                }
                updateTitle();
                ab.d("MicroMsg.SnsTagDetailUI", "updateName " + this.rxA);
                break;
            default:
                AppMethodBeat.o(39373);
                return;
        }
        if (!(this.rxA + " " + bo.c(this.kPL, ",")).equals(this.cvZ) || this.qJQ == 0) {
            enableOptionMenu(true);
            AppMethodBeat.o(39373);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(39373);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(39374);
        ab.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (mVar.getType()) {
            case 290:
                finish();
                AppMethodBeat.o(39374);
                return;
            case 291:
                finish();
                AppMethodBeat.o(39374);
                return;
            case 292:
                if (!(this.ehS == null || !this.rxB || (this instanceof SnsBlackDetailUI))) {
                    ab.d("MicroMsg.SnsTagDetailUI", "update form net");
                    this.cvZ = this.rxA + " " + bo.c(((v) mVar).kk(this.qJQ), ",");
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
                    this.ehS.ci(this.kPL);
                    this.ehS.notifyChanged();
                    break;
                }
        }
        AppMethodBeat.o(39374);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(39362);
        String str = preference.mKey;
        if (str.equals("settings_tag_name") && (this.qJQ >= 6 || this.qJQ == 0)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_mode_name_type", 3);
            intent.putExtra("Contact_Nick", bo.bc(this.rxA, " "));
            com.tencent.mm.plugin.sns.c.a.gkE.a(intent, (Activity) this);
        }
        if (str.equals("delete_tag_name")) {
            h.a((Context) this, (int) R.string.e3w, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(39345);
                    SnsTagDetailUI.this.csQ();
                    AppMethodBeat.o(39345);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        AppMethodBeat.o(39362);
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(39367);
        this.ehK = this.yCw;
        ctV();
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39348);
                if (!(SnsTagDetailUI.this.rxA + " " + bo.c(SnsTagDetailUI.this.kPL, ",")).equals(SnsTagDetailUI.this.cvZ) || SnsTagDetailUI.this.qJQ == 0) {
                    h.a(SnsTagDetailUI.this, (int) R.string.eor, (int) R.string.tz, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(39347);
                            SnsTagDetailUI.this.finish();
                            AppMethodBeat.o(39347);
                        }
                    }, null);
                    AppMethodBeat.o(39348);
                } else {
                    SnsTagDetailUI.this.finish();
                    AppMethodBeat.o(39348);
                }
                return true;
            }
        });
        a(0, getString(R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39349);
                SnsTagDetailUI.this.bKl();
                AppMethodBeat.o(39349);
                return true;
            }
        }, q.b.GREEN);
        AppMethodBeat.o(39367);
    }

    static /* synthetic */ void a(SnsTagDetailUI snsTagDetailUI) {
        AppMethodBeat.i(39375);
        String c = bo.c(snsTagDetailUI.kPL, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", snsTagDetailUI.getString(R.string.eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("KBlockOpenImFav", true);
        String str = "list_attr";
        intent.putExtra(str, s.hs(s.C(s.znF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 16777216));
        intent.putExtra("always_select_contact", c);
        d.b((Context) snsTagDetailUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(39375);
    }
}
