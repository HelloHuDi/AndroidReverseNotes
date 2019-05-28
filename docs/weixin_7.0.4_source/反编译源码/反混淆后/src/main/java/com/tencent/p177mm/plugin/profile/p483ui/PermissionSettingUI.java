package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18384ro;
import com.tencent.p177mm.p230g.p231a.C26197mo;
import com.tencent.p177mm.p230g.p231a.C45362rd;
import com.tencent.p177mm.p230g.p231a.C9379ic;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.profile.ui.PermissionSettingUI */
public class PermissionSettingUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private boolean ppf = false;
    private C7616ad ppg = null;
    private boolean pph = false;
    private boolean ppi = false;
    private long ppj = 0;
    private int scene = 0;
    public C44275p tipDialog = null;
    private String userName = "";

    /* renamed from: com.tencent.mm.plugin.profile.ui.PermissionSettingUI$1 */
    class C286931 implements OnMenuItemClickListener {
        C286931() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23744);
            PermissionSettingUI.this.aqX();
            PermissionSettingUI.this.setResult(-1, new Intent());
            PermissionSettingUI.this.finish();
            AppMethodBeat.m2505o(23744);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(23745);
        super.onCreate(bundle);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(291, (C1202f) this);
        this.userName = getIntent().getStringExtra("sns_permission_userName");
        this.ppf = getIntent().getBooleanExtra("sns_permission_anim", false);
        this.ppj = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0);
        this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
        C4990ab.m7411d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", Integer.valueOf(this.scene));
        C1720g.m3537RQ();
        this.ppg = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.userName);
        if (this.ppg == null) {
            C4990ab.m7413e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", this.userName);
            finish();
        }
        this.ppg.setUsername(this.userName);
        initView();
        C9379ic c9379ic = new C9379ic();
        c9379ic.cDb.cAd = 1;
        C4879a.xxA.mo10055m(c9379ic);
        AppMethodBeat.m2505o(23745);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(23746);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
            setResult(-1, new Intent());
            finish();
            AppMethodBeat.m2505o(23746);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(23746);
        return dispatchKeyEvent;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(23747);
        super.onDestroy();
        C39503b.gkF.mo38844BS();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(291, (C1202f) this);
        if (!(this.ppj == 0 || this.ppj == -1)) {
            C45362rd c45362rd = new C45362rd();
            c45362rd.cNh.cNi = this.ppi;
            c45362rd.cNh.cBh = this.ppj;
            C4879a.xxA.mo10055m(c45362rd);
        }
        AppMethodBeat.m2505o(23747);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8524b9;
    }

    private void cbv() {
        CharSequence string;
        AppMethodBeat.m2504i(23749);
        C1720g.m3537RQ();
        this.ppg = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.userName);
        this.ppg.setUsername(this.userName);
        boolean Od = this.ppg.mo16701Od();
        boolean UV = PermissionSettingUI.m57025UV(this.userName);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("star_contact");
        boolean Oc = this.ppg.mo16700Oc();
        if (Oc) {
            string = this.mController.ylL.getResources().getString(C25738R.string.b1z);
        } else {
            string = this.mController.ylL.getResources().getString(C25738R.string.aw5);
        }
        checkBoxPreference.setTitle(string);
        checkBoxPreference.uOT = Oc;
        this.ehK.mo27715ce("star_contact", true);
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("sns_outside_permiss");
        checkBoxPreference.uOT = Od;
        int i = this.ppg.dtS;
        C4990ab.m7411d("MicroMsg.SnsPermissionUI", "sex:%d", Integer.valueOf(i));
        if (i == 1) {
            checkBoxPreference.setTitle((int) C25738R.string.enc);
        } else if (i == 2) {
            checkBoxPreference.setTitle((int) C25738R.string.enb);
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("sns_black_permiss");
        if (i == 1) {
            checkBoxPreference.setTitle((int) C25738R.string.ejv);
        } else if (i == 2) {
            checkBoxPreference.setTitle((int) C25738R.string.eju);
        }
        checkBoxPreference.uOT = UV;
        if (!C7486a.m12942jh(this.ppg.field_type)) {
            this.ehK.aqP("sns_black_permiss");
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(23749);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(23751);
        C4990ab.m7416i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + c1207m.getType());
        if (c1207m.getType() == 291) {
            C4990ab.m7410d("MicroMsg.SnsPermissionUI", "tipDialog " + (this.tipDialog == null));
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            cbv();
            if (this.pph) {
                this.ppi = true;
            }
        }
        AppMethodBeat.m2505o(23751);
    }

    public final void initView() {
        AppMethodBeat.m2504i(23748);
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.ene);
        setBackBtn(new C286931());
        cbv();
        AppMethodBeat.m2505o(23748);
    }

    /* renamed from: UV */
    private static boolean m57025UV(String str) {
        AppMethodBeat.m2504i(23750);
        boolean UV = C21877n.qFA.mo37357UV(str);
        AppMethodBeat.m2505o(23750);
        return UV;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(23752);
        String str = preference.mKey;
        if (str.equals("sns_outside_permiss")) {
            C18384ro c18384ro = new C18384ro();
            c18384ro.cNw.cNy = true;
            c18384ro.cNw.cNx = false;
            c18384ro.cNw.username = this.userName;
            C4879a.xxA.mo10055m(c18384ro);
            if (this.ppg.mo16701Od()) {
                C1855t.m3898l(this.ppg);
            } else {
                C1855t.m3895k(this.ppg);
            }
            AppMethodBeat.m2505o(23752);
            return true;
        } else if (str.equals("sns_black_permiss")) {
            int i;
            C18384ro c18384ro2 = new C18384ro();
            c18384ro2.cNw.cNy = false;
            c18384ro2.cNw.cNx = true;
            c18384ro2.cNw.username = this.userName;
            boolean UV = PermissionSettingUI.m57025UV(this.userName);
            c18384ro2.cNw.cNz = UV;
            String str2 = this.userName;
            if (UV) {
                i = 2;
            } else {
                i = 1;
            }
            if (i == 1 && 5 == 5) {
                this.pph = true;
                this.ppi = false;
            } else {
                this.pph = false;
                this.ppi = false;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            C26197mo c26197mo = new C26197mo();
            c26197mo.cIr.list = linkedList;
            c26197mo.cIr.czE = i;
            c26197mo.cIr.cIs = 5;
            C4879a.xxA.mo10055m(c26197mo);
            getString(C25738R.string.f9238tz);
            this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.avi), true, null);
            C4879a.xxA.mo10055m(c18384ro2);
            AppMethodBeat.m2505o(23752);
            return true;
        } else if (str.equals("star_contact")) {
            if (this.ppg.mo16700Oc()) {
                C1855t.m3914n(this.ppg);
            } else {
                C1855t.m3899m(this.ppg);
            }
            AppMethodBeat.m2505o(23752);
            return true;
        } else {
            AppMethodBeat.m2505o(23752);
            return false;
        }
    }
}
