package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C12244d;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C34367b;
import com.tencent.p177mm.plugin.ipcall.p442ui.C21144j.C21148a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI */
public class IPCallTalkUI extends MMActivity implements C21148a {
    private String gHT;
    private String nCh;
    private String nCi;
    private String nCj;
    private String nCk;
    private int nCl;
    private int nCm;
    private C21144j nFX;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI$1 */
    class C123081 implements Runnable {
        C123081() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22360);
            IPCallTalkUI.this.setResult(-1, new Intent());
            IPCallTalkUI.this.finish();
            AppMethodBeat.m2505o(22360);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI$2 */
    class C123092 implements OnClickListener {
        C123092() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22361);
            dialogInterface.dismiss();
            IPCallTalkUI.this.finish();
            IPCallTalkUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(22361);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI$3 */
    class C123103 implements OnClickListener {
        C123103() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22362);
            dialogInterface.dismiss();
            IPCallTalkUI.this.finish();
            AppMethodBeat.m2505o(22362);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22363);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        getWindow().addFlags(6946944);
        this.gHT = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.nCh = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.nCi = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.nCj = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.nCk = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.nCl = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        this.nCm = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
        C4990ab.m7417i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", this.gHT, this.nCh, this.nCi, this.nCj, this.nCk, Integer.valueOf(this.nCl), Integer.valueOf(this.nCm));
        C4990ab.m7417i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 80, null, null)), C5046bo.dpG());
        if (C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            init();
            AppMethodBeat.m2505o(22363);
            return;
        }
        AppMethodBeat.m2505o(22363);
    }

    private void init() {
        AppMethodBeat.m2504i(22364);
        this.nFX = new C21144j(this);
        this.nFX.nGI = this;
        this.nFX.mo36462b(this.gHT, this.nCh, this.nCi, this.nCj, this.nCk, this.nCl, this.nCm);
        AppMethodBeat.m2505o(22364);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22365);
        super.onDestroy();
        setScreenEnable(true);
        if (this.nFX != null) {
            C21144j c21144j = this.nFX;
            C4990ab.m7416i("MicroMsg.TalkUIController", "onDestroy");
            c21144j.nGH.nuX = null;
            C21088i.bHt().crP = null;
            C21088i.bHt().nxk = null;
            C21088i.bHt().mo54895a(null);
            C34367b bHt = C21088i.bHt();
            bHt.nxh.nxu = null;
            C12244d c12244d = bHt.nxh;
            c12244d.mfW.dps();
            c12244d.mfS.dpt();
            c21144j.nGG = null;
            c21144j.nGI = null;
        }
        AppMethodBeat.m2505o(22365);
    }

    public final int getLayoutId() {
        return 2130969890;
    }

    /* renamed from: ix */
    public final void mo24158ix(boolean z) {
        AppMethodBeat.m2504i(22366);
        if (z) {
            C5004al.m7442n(new C123081(), 3000);
            AppMethodBeat.m2505o(22366);
            return;
        }
        AppMethodBeat.m2505o(22366);
    }

    public void onBackPressed() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(22367);
        if (this.nFX != null) {
            boolean z;
            if (C21088i.bHu().bHl()) {
                int bHJ;
                if (i == 25) {
                    bHJ = C21088i.bHt().bHJ();
                    if (bHJ != -1) {
                        C9638aw.m17191ZL().mo4839iK(bHJ);
                        z = true;
                        if (z) {
                            AppMethodBeat.m2505o(22367);
                            return true;
                        }
                    }
                } else if (i == 24) {
                    bHJ = C21088i.bHt().bHJ();
                    if (bHJ != -1) {
                        C9638aw.m17191ZL().mo4838iJ(bHJ);
                        z = true;
                        if (z) {
                        }
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(22367);
        return onKeyDown;
    }

    public void onPause() {
        AppMethodBeat.m2504i(22368);
        C4990ab.m7410d("MicroMsg.IPCallTalkUI", "onPause");
        super.onPause();
        if (this.nFX != null) {
            C4990ab.m7410d("MicroMsg.TalkUIController", "onPause");
        }
        AppMethodBeat.m2505o(22368);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22369);
        C4990ab.m7410d("MicroMsg.IPCallTalkUI", "onResume");
        super.onResume();
        if (this.nFX != null) {
            C4990ab.m7410d("MicroMsg.TalkUIController", "onResume");
            C9638aw.getNotification().cancel(42);
        }
        AppMethodBeat.m2505o(22369);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(22370);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(22370);
            return;
        }
        C4990ab.m7417i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C123092(), new C123103());
                    break;
                }
                init();
                AppMethodBeat.m2505o(22370);
                return;
        }
        AppMethodBeat.m2505o(22370);
    }
}
