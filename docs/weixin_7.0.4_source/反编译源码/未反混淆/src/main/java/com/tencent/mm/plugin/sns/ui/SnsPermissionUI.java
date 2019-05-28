package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;

public class SnsPermissionUI extends MMPreference implements f {
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

    static /* synthetic */ void a(SnsPermissionUI snsPermissionUI) {
        AppMethodBeat.i(39185);
        snsPermissionUI.onStop();
        AppMethodBeat.o(39185);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39177);
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
        AppMethodBeat.o(39177);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(39178);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
            setResult(-1, new Intent());
            finish();
            AppMethodBeat.o(39178);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(39178);
        return dispatchKeyEvent;
    }

    public void onDestroy() {
        AppMethodBeat.i(39179);
        super.onDestroy();
        a.gkF.BS();
        g.RQ();
        g.RO().eJo.b(291, (f) this);
        if (!(this.ppj == 0 || this.ppj == -1)) {
            rd rdVar = new rd();
            rdVar.cNh.cNi = this.ppi;
            rdVar.cNh.cBh = this.ppj;
            com.tencent.mm.sdk.b.a.xxA.m(rdVar);
        }
        AppMethodBeat.o(39179);
    }

    public final int JC() {
        return R.xml.ce;
    }

    private void cbv() {
        AppMethodBeat.i(39181);
        g.RQ();
        this.ppg = ((j) g.K(j.class)).XM().aoO(this.userName);
        this.ppg.setUsername(this.userName);
        boolean Od = this.ppg.Od();
        boolean UV = UV(this.userName);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("sns_outside_permiss");
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
        AppMethodBeat.o(39181);
    }

    private static boolean UV(String str) {
        AppMethodBeat.i(39182);
        t kF = af.cnL().kF(5);
        if (bo.isNullOrNil(kF.field_memberList)) {
            AppMethodBeat.o(39182);
            return false;
        }
        boolean contains = bo.P(kF.field_memberList.split(",")).contains(str);
        AppMethodBeat.o(39182);
        return contains;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(39183);
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
        AppMethodBeat.o(39183);
    }

    public final void initView() {
        AppMethodBeat.i(39180);
        this.ehK = this.yCw;
        setMMTitle((int) R.string.ene);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39175);
                SnsPermissionUI.this.aqX();
                SnsPermissionUI.this.setResult(-1, new Intent());
                SnsPermissionUI.this.finish();
                AppMethodBeat.o(39175);
                return true;
            }
        });
        cbv();
        AppMethodBeat.o(39180);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(39184);
        String str = preference.mKey;
        ro roVar;
        if (str.equals("sns_outside_permiss")) {
            roVar = new ro();
            roVar.cNw.cNy = true;
            roVar.cNw.cNx = false;
            roVar.cNw.username = this.userName;
            com.tencent.mm.sdk.b.a.xxA.m(roVar);
            if (this.ppg.Od()) {
                com.tencent.mm.model.t.l(this.ppg);
            } else {
                com.tencent.mm.model.t.k(this.ppg);
            }
            AppMethodBeat.o(39184);
            return true;
        } else if (str.equals("sns_black_permiss")) {
            int i;
            roVar = new ro();
            roVar.cNw.cNy = false;
            roVar.cNw.cNx = true;
            roVar.cNw.username = this.userName;
            com.tencent.mm.sdk.b.a.xxA.m(roVar);
            boolean UV = UV(this.userName);
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
            final m wVar = new w(i, 5, "", linkedList.size(), linkedList, this.scene);
            g.RQ();
            g.RO().eJo.a(wVar, 0);
            getString(R.string.tz);
            this.tipDialog = h.b((Context) this, getString(R.string.epc), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(39176);
                    SnsPermissionUI.a(SnsPermissionUI.this);
                    g.RQ();
                    g.RO().eJo.c(wVar);
                    AppMethodBeat.o(39176);
                }
            });
            AppMethodBeat.o(39184);
            return true;
        } else {
            AppMethodBeat.o(39184);
            return false;
        }
    }
}
