package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.b.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class IPCallTalkUI extends MMActivity implements j.a {
    private String gHT;
    private String nCh;
    private String nCi;
    private String nCj;
    private String nCk;
    private int nCl;
    private int nCm;
    private j nFX;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22363);
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
        ab.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", this.gHT, this.nCh, this.nCi, this.nCj, this.nCk, Integer.valueOf(this.nCl), Integer.valueOf(this.nCm));
        ab.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bo.dpG());
        if (b.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            init();
            AppMethodBeat.o(22363);
            return;
        }
        AppMethodBeat.o(22363);
    }

    private void init() {
        AppMethodBeat.i(22364);
        this.nFX = new j(this);
        this.nFX.nGI = this;
        this.nFX.b(this.gHT, this.nCh, this.nCi, this.nCj, this.nCk, this.nCl, this.nCm);
        AppMethodBeat.o(22364);
    }

    public void onDestroy() {
        AppMethodBeat.i(22365);
        super.onDestroy();
        setScreenEnable(true);
        if (this.nFX != null) {
            j jVar = this.nFX;
            ab.i("MicroMsg.TalkUIController", "onDestroy");
            jVar.nGH.nuX = null;
            i.bHt().crP = null;
            i.bHt().nxk = null;
            i.bHt().a(null);
            com.tencent.mm.plugin.ipcall.a.b.b bHt = i.bHt();
            bHt.nxh.nxu = null;
            d dVar = bHt.nxh;
            dVar.mfW.dps();
            dVar.mfS.dpt();
            jVar.nGG = null;
            jVar.nGI = null;
        }
        AppMethodBeat.o(22365);
    }

    public final int getLayoutId() {
        return R.layout.a8p;
    }

    public final void ix(boolean z) {
        AppMethodBeat.i(22366);
        if (z) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22360);
                    IPCallTalkUI.this.setResult(-1, new Intent());
                    IPCallTalkUI.this.finish();
                    AppMethodBeat.o(22360);
                }
            }, 3000);
            AppMethodBeat.o(22366);
            return;
        }
        AppMethodBeat.o(22366);
    }

    public void onBackPressed() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(22367);
        if (this.nFX != null) {
            boolean z;
            if (i.bHu().bHl()) {
                int bHJ;
                if (i == 25) {
                    bHJ = i.bHt().bHJ();
                    if (bHJ != -1) {
                        aw.ZL().iK(bHJ);
                        z = true;
                        if (z) {
                            AppMethodBeat.o(22367);
                            return true;
                        }
                    }
                } else if (i == 24) {
                    bHJ = i.bHt().bHJ();
                    if (bHJ != -1) {
                        aw.ZL().iJ(bHJ);
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
        AppMethodBeat.o(22367);
        return onKeyDown;
    }

    public void onPause() {
        AppMethodBeat.i(22368);
        ab.d("MicroMsg.IPCallTalkUI", "onPause");
        super.onPause();
        if (this.nFX != null) {
            ab.d("MicroMsg.TalkUIController", "onPause");
        }
        AppMethodBeat.o(22368);
    }

    public void onResume() {
        AppMethodBeat.i(22369);
        ab.d("MicroMsg.IPCallTalkUI", "onResume");
        super.onResume();
        if (this.nFX != null) {
            ab.d("MicroMsg.TalkUIController", "onResume");
            aw.getNotification().cancel(42);
        }
        AppMethodBeat.o(22369);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(22370);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(22370);
            return;
        }
        ab.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22361);
                            dialogInterface.dismiss();
                            IPCallTalkUI.this.finish();
                            IPCallTalkUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(22361);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22362);
                            dialogInterface.dismiss();
                            IPCallTalkUI.this.finish();
                            AppMethodBeat.o(22362);
                        }
                    });
                    break;
                }
                init();
                AppMethodBeat.o(22370);
                return;
        }
        AppMethodBeat.o(22370);
    }
}
