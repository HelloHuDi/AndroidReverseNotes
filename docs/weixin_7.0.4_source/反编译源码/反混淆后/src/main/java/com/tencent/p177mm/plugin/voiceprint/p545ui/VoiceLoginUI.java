package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38271be;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45580bd;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voiceprint.model.C22450n;
import com.tencent.p177mm.plugin.voiceprint.model.C22450n.C14016a;
import com.tencent.p177mm.plugin.voiceprint.model.C35343e;
import com.tencent.p177mm.plugin.voiceprint.model.C43717h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI */
public class VoiceLoginUI extends BaseVoicePrintUI implements C14016a {
    private String igi = null;
    private C22450n sMn = null;

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI$1 */
    class C224541 implements OnMenuItemClickListener {
        C224541() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(26190);
            VoiceLoginUI.m86978a(VoiceLoginUI.this);
            AppMethodBeat.m2505o(26190);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI$2 */
    class C437232 implements OnClickListener {
        C437232() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(26191);
            dialogInterface.dismiss();
            VoiceLoginUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(26191);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI$3 */
    class C437243 implements OnClickListener {
        C437243() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(26192);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(26192);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m86978a(VoiceLoginUI voiceLoginUI) {
        AppMethodBeat.m2504i(26204);
        voiceLoginUI.goBack();
        AppMethodBeat.m2505o(26204);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26193);
        super.onCreate(bundle);
        C7060h.pYm.mo8381e(11557, Integer.valueOf(1));
        this.igi = C5046bo.m7532bc(getIntent().getStringExtra("Kusername"), null);
        String bc = C5046bo.m7532bc(getIntent().getStringExtra("Kvertify_key"), null);
        C4990ab.m7411d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", this.igi, Boolean.valueOf(C5046bo.isNullOrNil(bc)));
        if (C5046bo.isNullOrNil(this.igi) && C5046bo.isNullOrNil(bc)) {
            C4990ab.m7412e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
            AppMethodBeat.m2505o(26193);
            return;
        }
        this.sMn = new C22450n();
        this.sMn.igi = this.igi;
        this.sMn.hjp = bc;
        this.sMn.sLv = this;
        C22450n c22450n = this.sMn;
        if (C5046bo.isNullOrNil(c22450n.hjp)) {
            C9638aw.m17182Rg().mo14541a(new C35343e(c22450n.igi), 0);
        } else {
            c22450n.cHN();
        }
        boolean a = C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 80, "", "");
        C4990ab.m7417i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a), C5046bo.dpG(), this);
        setBackBtn(new C224541());
        if (C1443d.m3068iW(23)) {
            getWindow().setStatusBarColor(getResources().getColor(C25738R.color.f12200vs));
            dxW();
        }
        AppMethodBeat.m2505o(26193);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHU() {
        AppMethodBeat.m2504i(26194);
        C4990ab.m7411d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", this.sLO);
        if (!(C5046bo.isNullOrNil(this.sLO) || C5046bo.isNullOrNil(this.sLs))) {
            C22450n c22450n = this.sMn;
            C1207m c43717h = new C43717h(this.sLO, c22450n.sLt, c22450n.hjp);
            c43717h.sLb = true;
            C9638aw.m17182Rg().mo14541a(c43717h, 0);
            this.sLJ.setEnabled(false);
            this.sLM.bQs();
        }
        AppMethodBeat.m2505o(26194);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKm() {
        AppMethodBeat.m2504i(26195);
        findViewById(2131823774).setVisibility(8);
        this.sLM.bQs();
        this.sLM.setTitleText((int) C25738R.string.f2f);
        this.sLM.cIf();
        this.sLJ.setEnabled(false);
        AppMethodBeat.m2505o(26195);
    }

    private void goBack() {
        AppMethodBeat.m2504i(26196);
        setResult(0);
        finish();
        AppMethodBeat.m2505o(26196);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(26197);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(26197);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(26197);
        return onKeyDown;
    }

    public final void abU(String str) {
        AppMethodBeat.m2504i(26198);
        C4990ab.m7410d("MicroMsg.VoiceLoginUI", "onGetText");
        this.sLs = str;
        this.sLM.cIe();
        this.sLM.setTipText(str);
        this.sLM.bQt();
        this.sLJ.setEnabled(true);
        AppMethodBeat.m2505o(26198);
    }

    public final void cHM() {
        AppMethodBeat.m2504i(26200);
        mo63246FV(C25738R.string.f2l);
        AppMethodBeat.m2505o(26200);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26202);
        super.onDestroy();
        if (this.sMn != null) {
            C1202f c1202f = this.sMn;
            C9638aw.m17182Rg().mo14546b((int) C45579bb.CTRL_INDEX, c1202f);
            C9638aw.m17182Rg().mo14546b((int) C45580bd.CTRL_INDEX, c1202f);
            C9638aw.m17182Rg().mo14546b((int) C38271be.CTRL_INDEX, c1202f);
            c1202f.sLv = null;
        }
        AppMethodBeat.m2505o(26202);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(26203);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(26203);
            return;
        }
        C4990ab.m7417i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C437232(), new C437243());
                    break;
                }
                cHR();
                AppMethodBeat.m2505o(26203);
                return;
        }
        AppMethodBeat.m2505o(26203);
    }

    /* renamed from: mh */
    public final void mo26249mh(boolean z) {
        AppMethodBeat.m2504i(26199);
        this.sLM.bQt();
        this.sLJ.setEnabled(true);
        if (z) {
            C4990ab.m7417i("MicroMsg.VoiceLoginUI", "login success[%s]", C5046bo.anv(this.sMn.gCk));
            Intent intent = new Intent();
            intent.putExtra("VoiceLoginAuthPwd", this.sMn.gCk);
            setResult(-1, intent);
            finish();
            AppMethodBeat.m2505o(26199);
            return;
        }
        C4990ab.m7416i("MicroMsg.VoiceLoginUI", "login failed");
        this.sLM.setErr((int) C25738R.string.f2e);
        this.sLM.cIg();
        AppMethodBeat.m2505o(26199);
    }

    public final void cHO() {
        AppMethodBeat.m2504i(26201);
        this.sLJ.setEnabled(false);
        this.sLJ.setVisibility(4);
        this.sLM.bQt();
        this.sLM.setErr((int) C25738R.string.f2k);
        this.sLM.cIg();
        AppMethodBeat.m2505o(26201);
    }
}
