package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.model.aw;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.a.d.b;
import com.tencent.mm.plugin.ipcall.a.d.c;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

@a(3)
public class IPCallDialUI extends MMActivity implements f, b.a {
    private String gHT;
    private TextView goa;
    private b nCg;
    private String nCh;
    private String nCi;
    private String nCj;
    private String nCk;
    private int nCl = 0;
    private int nCm = 0;
    private int nCn = -1;
    private LinkedList<crw> nCo;
    b nCp;
    c nCq;
    private com.tencent.mm.sdk.b.c nCr = new com.tencent.mm.sdk.b.c<tp>() {
        {
            AppMethodBeat.i(22125);
            this.xxI = tp.class.getName().hashCode();
            AppMethodBeat.o(22125);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(22126);
            tp tpVar = (tp) bVar;
            if (tpVar instanceof tp) {
                String str = tpVar.cPM.countryCode;
                if (!(IPCallDialUI.this.nCg == null || bo.isNullOrNil(str))) {
                    IPCallDialUI.this.nCg.OZ(str);
                }
            }
            AppMethodBeat.o(22126);
            return false;
        }
    };
    private DialPad nzR;
    private TextView nzS;
    private EditText nzT;
    private View nzU;
    private ImageButton nzV;
    private View nzW;
    private TextView nzX;
    private TextView nzY;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallDialUI() {
        AppMethodBeat.i(22129);
        AppMethodBeat.o(22129);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22130);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xxA.c(this.nCr);
        aw.Rg().a(807, (f) this);
        aw.Rg().a(746, (f) this);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22124);
                IPCallDialUI.this.finish();
                AppMethodBeat.o(22124);
                return true;
            }
        }, R.raw.actionbar_quit_webview_icon);
        this.gHT = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.nCh = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.nCi = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.nCj = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.nCk = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.nCl = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        ab.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", this.gHT, this.nCh, this.nCi, this.nCj, this.nCk, Integer.valueOf(this.nCl));
        if (!bo.isNullOrNil(this.nCh)) {
            this.nCh = com.tencent.mm.plugin.ipcall.b.c.PA(this.nCh);
        }
        if (bo.isNullOrNil(this.nCj)) {
            if (com.tencent.mm.plugin.ipcall.b.a.Pu(this.nCh)) {
                if (bo.isNullOrNil(com.tencent.mm.plugin.ipcall.b.a.Ps(this.nCh))) {
                    this.nCh = com.tencent.mm.plugin.ipcall.b.a.Pv(this.nCh);
                } else {
                    ab.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
                    this.nCm = 4;
                    Intent intent = new Intent(this, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_contactId", this.nCi);
                    intent.putExtra("IPCallTalkUI_countryCode", this.nCj);
                    intent.putExtra("IPCallTalkUI_nickname", this.gHT);
                    intent.putExtra("IPCallTalkUI_phoneNumber", this.nCh);
                    intent.putExtra("IPCallTalkUI_dialScene", this.nCl);
                    intent.putExtra("IPCallTalkUI_countryType", this.nCm);
                    startActivityForResult(intent, 1001);
                    finish();
                    AppMethodBeat.o(22130);
                    return;
                }
            }
            this.nCj = com.tencent.mm.plugin.ipcall.b.c.bIR();
        }
        if (this.nCl != 1) {
            this.nCn = 0;
            this.nCm = 3;
            this.nCp = new b(this.nCh, this.nCj, "", bo.gQ(this), this.nCl);
            aw.Rg().a(this.nCp, 0);
        } else {
            this.nCn = -1;
            this.nCm = 4;
        }
        init();
        AppMethodBeat.o(22130);
    }

    public void onStart() {
        AppMethodBeat.i(22131);
        super.onStart();
        this.nCq = new c();
        aw.Rg().a(this.nCq, 0);
        AppMethodBeat.o(22131);
    }

    public void onResume() {
        AppMethodBeat.i(22132);
        ab.d("MicroMsg.IPCallDialUI", "onResume");
        super.onResume();
        AppMethodBeat.o(22132);
    }

    public final int getLayoutId() {
        return R.layout.a8n;
    }

    private void init() {
        AppMethodBeat.i(22133);
        ab.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bo.dpG());
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            setMMTitle((int) R.string.cgk);
            setVolumeControlStream(1);
            this.nzR = (DialPad) findViewById(R.id.cks);
            this.nzS = (TextView) findViewById(R.id.ckj);
            this.nzW = findViewById(R.id.ckm);
            this.nzT = (EditText) findViewById(R.id.ckk);
            this.nzU = findViewById(R.id.ckl);
            this.goa = (TextView) findViewById(R.id.cko);
            this.nzV = (ImageButton) findViewById(R.id.b_n);
            this.nzX = (TextView) findViewById(R.id.ckn);
            this.nzY = (TextView) findViewById(R.id.ckp);
            this.nCg = new b(this, this.nzT, this.nzS, this.nzU, this.nzR, this.nzV, this.goa, this.nzW, this.nzX, this.nzY);
            this.nCg.nzQ = this;
            if (!bo.isNullOrNil(this.nCh)) {
                this.nCg.cq(this.nCh, -1);
            }
            if (!bo.isNullOrNil(this.nCj)) {
                this.nCg.OZ(this.nCj);
            }
            if (!(bo.isNullOrNil(this.nCh) || bo.isNullOrNil(this.nCj))) {
                this.nCg.bId();
            }
            this.nCg.ae(this.nCo);
            AppMethodBeat.o(22133);
            return;
        }
        AppMethodBeat.o(22133);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(22134);
        super.onActivityResult(i, i2, intent);
        b bVar = this.nCg;
        ab.d("MicroMsg.DialPadController", "onActivityResult");
        if (i == 100 && i2 == 100) {
            String bc = bo.bc(intent.getStringExtra("country_name"), "");
            String bc2 = bo.bc(intent.getStringExtra("couttry_code"), "");
            ab.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", bc2, bc);
            if (!(bo.isNullOrNil(bc2) || bo.isNullOrNil(bc))) {
                bVar.nzZ = bc;
                bVar.nAa = "+".concat(String.valueOf(bc2));
                bVar.nzS.setText(bVar.nAa);
                bVar.nAb = b.eL(bc2.replace("+", ""), bVar.nAb);
                bVar.cq(bVar.nAb, -1);
                bVar.nAf = false;
            }
            AppMethodBeat.o(22134);
            return;
        }
        if (i == 1001 && i2 == -1) {
            intent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
            bVar.crP.setResult(-1, intent);
            bVar.crP.finish();
        }
        AppMethodBeat.o(22134);
    }

    public final void p(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(22135);
        ab.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", str, str2, str3, str4);
        if (!com.tencent.mm.plugin.ipcall.b.c.eo(this)) {
            AppMethodBeat.o(22135);
        } else if (com.tencent.mm.plugin.ipcall.a.c.bHc().xf(bo.getInt(str, -1))) {
            h.b((Context) this, getString(R.string.abs), getString(R.string.abt), true);
            com.tencent.mm.plugin.report.service.h.pYm.X(12058, str);
            AppMethodBeat.o(22135);
        } else {
            com.tencent.mm.plugin.report.service.h.pYm.e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            Intent intent = new Intent(this, IPCallTalkUI.class);
            intent.putExtra("IPCallTalkUI_contactId", str3);
            intent.putExtra("IPCallTalkUI_countryCode", str);
            intent.putExtra("IPCallTalkUI_nickname", str4);
            intent.putExtra("IPCallTalkUI_phoneNumber", str2);
            intent.putExtra("IPCallTalkUI_dialScene", this.nCl);
            intent.putExtra("IPCallTalkUI_countryType", this.nCm);
            startActivityForResult(intent, 1001);
            AppMethodBeat.o(22135);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(22136);
        super.onDestroy();
        if (this.nCg != null) {
            this.nCg.nzQ = null;
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.nCr);
        aw.Rg().b(807, (f) this);
        aw.Rg().b(746, (f) this);
        AppMethodBeat.o(22136);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(22137);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(22137);
            return;
        }
        ab.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22127);
                            dialogInterface.dismiss();
                            IPCallDialUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(22127);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22128);
                            dialogInterface.dismiss();
                            IPCallDialUI.this.finish();
                            AppMethodBeat.o(22128);
                        }
                    });
                    break;
                }
                init();
                AppMethodBeat.o(22137);
                return;
        }
        AppMethodBeat.o(22137);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(22138);
        if (mVar instanceof b) {
            if (i == 0 && i2 == 0 && mVar == this.nCp) {
                if (this.nCp.nyi != null) {
                    ab.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", Integer.valueOf(this.nCp.nyi.vYu), this.nCp.nyi.wOT, this.nCp.nyi.nHd);
                }
                if (this.nCn != 2) {
                    int i3;
                    this.nCn = 1;
                    this.nCm = 1;
                    b bVar = this.nCp;
                    if (bVar.nyi == null || bVar.nyi.vYu != 2) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        ab.i("MicroMsg.IPCallDialUI", "check error show error dialog");
                        AppMethodBeat.o(22138);
                        return;
                    }
                    bVar = this.nCp;
                    if (bVar.nyi == null || !(bVar.nyi.vYu == 1 || bVar.nyi.vYu == 0)) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        if (this.nCp.nyi == null || bo.isNullOrNil(this.nCp.nyi.nHd)) {
                            ab.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
                        } else if (this.nCg != null) {
                            ab.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", this.nCp.nyi.nHd, this.nCj);
                            this.nCj = this.nCp.nyi.nHd;
                            this.nCg.OZ(this.nCp.nyi.nHd);
                        }
                    }
                    if (!(this.nCp.nyi == null || bo.isNullOrNil(this.nCp.nyi.wOT) || this.nCg == null)) {
                        ab.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", this.nCp.nyi.wOT, this.nCh);
                        this.nCh = this.nCp.nyi.wOT;
                        this.nCg.cq(this.nCp.nyi.wOT, -1);
                        AppMethodBeat.o(22138);
                        return;
                    }
                }
                ab.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
                AppMethodBeat.o(22138);
                return;
            }
        } else if (mVar instanceof c) {
            if (i == 0 && i2 == 0) {
                this.nCo = ((c) mVar).nyk.wuh;
            } else {
                this.nCo = null;
            }
            if (this.nCg != null) {
                this.nCg.ae(this.nCo);
            }
        }
        AppMethodBeat.o(22138);
    }

    public final void Pa(String str) {
        AppMethodBeat.i(22139);
        ab.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", str, this.nCj);
        if (!(this.nCn == 2 || this.nCn == -1 || this.nCj.equals(str))) {
            bIm();
        }
        AppMethodBeat.o(22139);
    }

    public final void Pb(String str) {
        AppMethodBeat.i(22140);
        ab.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", str, this.nCh);
        if (!(this.nCn == 2 || this.nCn == -1 || this.nCh.equals(str))) {
            bIm();
        }
        AppMethodBeat.o(22140);
    }

    private void bIm() {
        AppMethodBeat.i(22141);
        ab.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
        this.nCn = 2;
        if (this.nCm == 1) {
            this.nCm = 2;
            AppMethodBeat.o(22141);
            return;
        }
        this.nCm = 4;
        AppMethodBeat.o(22141);
    }
}
