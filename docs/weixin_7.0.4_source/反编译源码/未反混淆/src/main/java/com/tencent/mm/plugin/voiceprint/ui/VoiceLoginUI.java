package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class VoiceLoginUI extends BaseVoicePrintUI implements a {
    private String igi = null;
    private n sMn = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(VoiceLoginUI voiceLoginUI) {
        AppMethodBeat.i(26204);
        voiceLoginUI.goBack();
        AppMethodBeat.o(26204);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26193);
        super.onCreate(bundle);
        h.pYm.e(11557, Integer.valueOf(1));
        this.igi = bo.bc(getIntent().getStringExtra("Kusername"), null);
        String bc = bo.bc(getIntent().getStringExtra("Kvertify_key"), null);
        ab.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", this.igi, Boolean.valueOf(bo.isNullOrNil(bc)));
        if (bo.isNullOrNil(this.igi) && bo.isNullOrNil(bc)) {
            ab.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
            AppMethodBeat.o(26193);
            return;
        }
        this.sMn = new n();
        this.sMn.igi = this.igi;
        this.sMn.hjp = bc;
        this.sMn.sLv = this;
        n nVar = this.sMn;
        if (bo.isNullOrNil(nVar.hjp)) {
            aw.Rg().a(new e(nVar.igi), 0);
        } else {
            nVar.cHN();
        }
        boolean a = b.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
        ab.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a), bo.dpG(), this);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26190);
                VoiceLoginUI.a(VoiceLoginUI.this);
                AppMethodBeat.o(26190);
                return true;
            }
        });
        if (d.iW(23)) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.vs));
            dxW();
        }
        AppMethodBeat.o(26193);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHU() {
        AppMethodBeat.i(26194);
        ab.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", this.sLO);
        if (!(bo.isNullOrNil(this.sLO) || bo.isNullOrNil(this.sLs))) {
            n nVar = this.sMn;
            m hVar = new com.tencent.mm.plugin.voiceprint.model.h(this.sLO, nVar.sLt, nVar.hjp);
            hVar.sLb = true;
            aw.Rg().a(hVar, 0);
            this.sLJ.setEnabled(false);
            this.sLM.bQs();
        }
        AppMethodBeat.o(26194);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKm() {
        AppMethodBeat.i(26195);
        findViewById(R.id.bma).setVisibility(8);
        this.sLM.bQs();
        this.sLM.setTitleText((int) R.string.f2f);
        this.sLM.cIf();
        this.sLJ.setEnabled(false);
        AppMethodBeat.o(26195);
    }

    private void goBack() {
        AppMethodBeat.i(26196);
        setResult(0);
        finish();
        AppMethodBeat.o(26196);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(26197);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(26197);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(26197);
        return onKeyDown;
    }

    public final void abU(String str) {
        AppMethodBeat.i(26198);
        ab.d("MicroMsg.VoiceLoginUI", "onGetText");
        this.sLs = str;
        this.sLM.cIe();
        this.sLM.setTipText(str);
        this.sLM.bQt();
        this.sLJ.setEnabled(true);
        AppMethodBeat.o(26198);
    }

    public final void cHM() {
        AppMethodBeat.i(26200);
        FV(R.string.f2l);
        AppMethodBeat.o(26200);
    }

    public void onDestroy() {
        AppMethodBeat.i(26202);
        super.onDestroy();
        if (this.sMn != null) {
            f fVar = this.sMn;
            aw.Rg().b((int) bb.CTRL_INDEX, fVar);
            aw.Rg().b((int) bd.CTRL_INDEX, fVar);
            aw.Rg().b((int) be.CTRL_INDEX, fVar);
            fVar.sLv = null;
        }
        AppMethodBeat.o(26202);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(26203);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(26203);
            return;
        }
        ab.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(26191);
                            dialogInterface.dismiss();
                            VoiceLoginUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(26191);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(26192);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(26192);
                        }
                    });
                    break;
                }
                cHR();
                AppMethodBeat.o(26203);
                return;
        }
        AppMethodBeat.o(26203);
    }

    public final void mh(boolean z) {
        AppMethodBeat.i(26199);
        this.sLM.bQt();
        this.sLJ.setEnabled(true);
        if (z) {
            ab.i("MicroMsg.VoiceLoginUI", "login success[%s]", bo.anv(this.sMn.gCk));
            Intent intent = new Intent();
            intent.putExtra("VoiceLoginAuthPwd", this.sMn.gCk);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(26199);
            return;
        }
        ab.i("MicroMsg.VoiceLoginUI", "login failed");
        this.sLM.setErr((int) R.string.f2e);
        this.sLM.cIg();
        AppMethodBeat.o(26199);
    }

    public final void cHO() {
        AppMethodBeat.i(26201);
        this.sLJ.setEnabled(false);
        this.sLJ.setVisibility(4);
        this.sLM.bQt();
        this.sLM.setErr((int) R.string.f2k);
        this.sLM.cIg();
        AppMethodBeat.o(26201);
    }
}
