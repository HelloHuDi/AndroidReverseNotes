package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;

public class PermissionSettingUI extends MMPreference implements f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private boolean ppf = false;
    private ad ppg = null;
    private boolean pph = false;
    private boolean ppi = false;
    private long ppj = 0;
    private int scene = 0;
    public p tipDialog = null;
    private String userName = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23745);
        super.onCreate(bundle);
        g.RQ();
        g.RO().eJo.a(291, (f) this);
        this.userName = getIntent().getStringExtra("sns_permission_userName");
        this.ppf = getIntent().getBooleanExtra("sns_permission_anim", false);
        this.ppj = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0);
        this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
        ab.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", Integer.valueOf(this.scene));
        g.RQ();
        this.ppg = ((j) g.K(j.class)).XM().aoO(this.userName);
        if (this.ppg == null) {
            ab.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", this.userName);
            finish();
        }
        this.ppg.setUsername(this.userName);
        initView();
        ic icVar = new ic();
        icVar.cDb.cAd = 1;
        a.xxA.m(icVar);
        AppMethodBeat.o(23745);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(23746);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
            setResult(-1, new Intent());
            finish();
            AppMethodBeat.o(23746);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(23746);
        return dispatchKeyEvent;
    }

    public void onDestroy() {
        AppMethodBeat.i(23747);
        super.onDestroy();
        b.gkF.BS();
        g.RQ();
        g.RO().eJo.b(291, (f) this);
        if (!(this.ppj == 0 || this.ppj == -1)) {
            rd rdVar = new rd();
            rdVar.cNh.cNi = this.ppi;
            rdVar.cNh.cBh = this.ppj;
            a.xxA.m(rdVar);
        }
        AppMethodBeat.o(23747);
    }

    public final int JC() {
        return R.xml.b9;
    }

    private void cbv() {
        CharSequence string;
        AppMethodBeat.i(23749);
        g.RQ();
        this.ppg = ((j) g.K(j.class)).XM().aoO(this.userName);
        this.ppg.setUsername(this.userName);
        boolean Od = this.ppg.Od();
        boolean UV = UV(this.userName);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("star_contact");
        boolean Oc = this.ppg.Oc();
        if (Oc) {
            string = this.mController.ylL.getResources().getString(R.string.b1z);
        } else {
            string = this.mController.ylL.getResources().getString(R.string.aw5);
        }
        checkBoxPreference.setTitle(string);
        checkBoxPreference.uOT = Oc;
        this.ehK.ce("star_contact", true);
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("sns_outside_permiss");
        checkBoxPreference.uOT = Od;
        int i = this.ppg.dtS;
        ab.d("MicroMsg.SnsPermissionUI", "sex:%d", Integer.valueOf(i));
        if (i == 1) {
            checkBoxPreference.setTitle((int) R.string.enc);
        } else if (i == 2) {
            checkBoxPreference.setTitle((int) R.string.enb);
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("sns_black_permiss");
        if (i == 1) {
            checkBoxPreference.setTitle((int) R.string.ejv);
        } else if (i == 2) {
            checkBoxPreference.setTitle((int) R.string.eju);
        }
        checkBoxPreference.uOT = UV;
        if (!com.tencent.mm.n.a.jh(this.ppg.field_type)) {
            this.ehK.aqP("sns_black_permiss");
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(23749);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(23751);
        ab.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + mVar.getType());
        if (mVar.getType() == 291) {
            ab.d("MicroMsg.SnsPermissionUI", "tipDialog " + (this.tipDialog == null));
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            cbv();
            if (this.pph) {
                this.ppi = true;
            }
        }
        AppMethodBeat.o(23751);
    }

    public final void initView() {
        AppMethodBeat.i(23748);
        this.ehK = this.yCw;
        setMMTitle((int) R.string.ene);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23744);
                PermissionSettingUI.this.aqX();
                PermissionSettingUI.this.setResult(-1, new Intent());
                PermissionSettingUI.this.finish();
                AppMethodBeat.o(23744);
                return true;
            }
        });
        cbv();
        AppMethodBeat.o(23748);
    }

    private static boolean UV(String str) {
        AppMethodBeat.i(23750);
        boolean UV = n.qFA.UV(str);
        AppMethodBeat.o(23750);
        return UV;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(23752);
        String str = preference.mKey;
        if (str.equals("sns_outside_permiss")) {
            ro roVar = new ro();
            roVar.cNw.cNy = true;
            roVar.cNw.cNx = false;
            roVar.cNw.username = this.userName;
            a.xxA.m(roVar);
            if (this.ppg.Od()) {
                t.l(this.ppg);
            } else {
                t.k(this.ppg);
            }
            AppMethodBeat.o(23752);
            return true;
        } else if (str.equals("sns_black_permiss")) {
            int i;
            ro roVar2 = new ro();
            roVar2.cNw.cNy = false;
            roVar2.cNw.cNx = true;
            roVar2.cNw.username = this.userName;
            boolean UV = UV(this.userName);
            roVar2.cNw.cNz = UV;
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
            mo moVar = new mo();
            moVar.cIr.list = linkedList;
            moVar.cIr.czE = i;
            moVar.cIr.cIs = 5;
            a.xxA.m(moVar);
            getString(R.string.tz);
            this.tipDialog = h.b((Context) this, getString(R.string.avi), true, null);
            a.xxA.m(roVar2);
            AppMethodBeat.o(23752);
            return true;
        } else if (str.equals("star_contact")) {
            if (this.ppg.Oc()) {
                t.n(this.ppg);
            } else {
                t.m(this.ppg);
            }
            AppMethodBeat.o(23752);
            return true;
        } else {
            AppMethodBeat.o(23752);
            return false;
        }
    }
}
