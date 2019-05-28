package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.p177mm.p230g.p231a.C45362rd;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C7109w;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsPermissionUI */
public class SnsPermissionUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private boolean ppf = false;
    private C7616ad ppg = null;
    private boolean pph = false;
    private boolean ppi = false;
    private long ppj = 0;
    private int scene = 0;
    public C44275p tipDialog = null;
    private String userName = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsPermissionUI$1 */
    class C220211 implements OnMenuItemClickListener {
        C220211() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39175);
            SnsPermissionUI.this.aqX();
            SnsPermissionUI.this.setResult(-1, new Intent());
            SnsPermissionUI.this.finish();
            AppMethodBeat.m2505o(39175);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m81667a(SnsPermissionUI snsPermissionUI) {
        AppMethodBeat.m2504i(39185);
        snsPermissionUI.onStop();
        AppMethodBeat.m2505o(39185);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39177);
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
        AppMethodBeat.m2505o(39177);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39178);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
            setResult(-1, new Intent());
            finish();
            AppMethodBeat.m2505o(39178);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(39178);
        return dispatchKeyEvent;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39179);
        super.onDestroy();
        C24826a.gkF.mo38844BS();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(291, (C1202f) this);
        if (!(this.ppj == 0 || this.ppj == -1)) {
            C45362rd c45362rd = new C45362rd();
            c45362rd.cNh.cNi = this.ppi;
            c45362rd.cNh.cBh = this.ppj;
            C4879a.xxA.mo10055m(c45362rd);
        }
        AppMethodBeat.m2505o(39179);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8566ce;
    }

    private void cbv() {
        AppMethodBeat.m2504i(39181);
        C1720g.m3537RQ();
        this.ppg = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.userName);
        this.ppg.setUsername(this.userName);
        boolean Od = this.ppg.mo16701Od();
        boolean UV = SnsPermissionUI.m81666UV(this.userName);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("sns_outside_permiss");
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
        AppMethodBeat.m2505o(39181);
    }

    /* renamed from: UV */
    private static boolean m81666UV(String str) {
        AppMethodBeat.m2504i(39182);
        C13479t kF = C13373af.cnL().mo55579kF(5);
        if (C5046bo.isNullOrNil(kF.field_memberList)) {
            AppMethodBeat.m2505o(39182);
            return false;
        }
        boolean contains = C5046bo.m7508P(kF.field_memberList.split(",")).contains(str);
        AppMethodBeat.m2505o(39182);
        return contains;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(39183);
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
        AppMethodBeat.m2505o(39183);
    }

    public final void initView() {
        AppMethodBeat.m2504i(39180);
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.ene);
        setBackBtn(new C220211());
        cbv();
        AppMethodBeat.m2505o(39180);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(39184);
        String str = preference.mKey;
        C18384ro c18384ro;
        if (str.equals("sns_outside_permiss")) {
            c18384ro = new C18384ro();
            c18384ro.cNw.cNy = true;
            c18384ro.cNw.cNx = false;
            c18384ro.cNw.username = this.userName;
            C4879a.xxA.mo10055m(c18384ro);
            if (this.ppg.mo16701Od()) {
                C1855t.m3898l(this.ppg);
            } else {
                C1855t.m3895k(this.ppg);
            }
            AppMethodBeat.m2505o(39184);
            return true;
        } else if (str.equals("sns_black_permiss")) {
            int i;
            c18384ro = new C18384ro();
            c18384ro.cNw.cNy = false;
            c18384ro.cNw.cNx = true;
            c18384ro.cNw.username = this.userName;
            C4879a.xxA.mo10055m(c18384ro);
            boolean UV = SnsPermissionUI.m81666UV(this.userName);
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
            final C1207m c7109w = new C7109w(i, 5, "", linkedList.size(), linkedList, this.scene);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c7109w, 0);
            getString(C25738R.string.f9238tz);
            this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.epc), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(39176);
                    SnsPermissionUI.m81667a(SnsPermissionUI.this);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c7109w);
                    AppMethodBeat.m2505o(39176);
                }
            });
            AppMethodBeat.m2505o(39184);
            return true;
        } else {
            AppMethodBeat.m2505o(39184);
            return false;
        }
    }
}
