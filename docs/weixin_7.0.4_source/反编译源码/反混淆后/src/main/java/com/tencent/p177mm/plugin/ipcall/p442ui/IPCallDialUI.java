package com.tencent.p177mm.plugin.ipcall.p442ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18402tp;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C46032c;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C12251b;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34369c;
import com.tencent.p177mm.plugin.ipcall.p442ui.C12313b.C12323a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.crw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallDialUI */
public class IPCallDialUI extends MMActivity implements C1202f, C12323a {
    private String gHT;
    private TextView goa;
    private C12313b nCg;
    private String nCh;
    private String nCi;
    private String nCj;
    private String nCk;
    private int nCl = 0;
    private int nCm = 0;
    private int nCn = -1;
    private LinkedList<crw> nCo;
    C12251b nCp;
    C34369c nCq;
    private C4884c nCr = new C211112();
    private DialPad nzR;
    private TextView nzS;
    private EditText nzT;
    private View nzU;
    private ImageButton nzV;
    private View nzW;
    private TextView nzX;
    private TextView nzY;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallDialUI$1 */
    class C211101 implements OnMenuItemClickListener {
        C211101() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22124);
            IPCallDialUI.this.finish();
            AppMethodBeat.m2505o(22124);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallDialUI$2 */
    class C211112 extends C4884c<C18402tp> {
        C211112() {
            AppMethodBeat.m2504i(22125);
            this.xxI = C18402tp.class.getName().hashCode();
            AppMethodBeat.m2505o(22125);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(22126);
            C18402tp c18402tp = (C18402tp) c4883b;
            if (c18402tp instanceof C18402tp) {
                String str = c18402tp.cPM.countryCode;
                if (!(IPCallDialUI.this.nCg == null || C5046bo.isNullOrNil(str))) {
                    IPCallDialUI.this.nCg.mo24164OZ(str);
                }
            }
            AppMethodBeat.m2505o(22126);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallDialUI$4 */
    class C211124 implements OnClickListener {
        C211124() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22128);
            dialogInterface.dismiss();
            IPCallDialUI.this.finish();
            AppMethodBeat.m2505o(22128);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallDialUI$3 */
    class C211133 implements OnClickListener {
        C211133() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22127);
            dialogInterface.dismiss();
            IPCallDialUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(22127);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public IPCallDialUI() {
        AppMethodBeat.m2504i(22129);
        AppMethodBeat.m2505o(22129);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22130);
        super.onCreate(bundle);
        C4879a.xxA.mo10052c(this.nCr);
        C9638aw.m17182Rg().mo14539a(807, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(746, (C1202f) this);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        setBackBtn(new C211101(), C1318a.actionbar_quit_webview_icon);
        this.gHT = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.nCh = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.nCi = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.nCj = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.nCk = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.nCl = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        C4990ab.m7417i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", this.gHT, this.nCh, this.nCi, this.nCj, this.nCk, Integer.valueOf(this.nCl));
        if (!C5046bo.isNullOrNil(this.nCh)) {
            this.nCh = C34382c.m56377PA(this.nCh);
        }
        if (C5046bo.isNullOrNil(this.nCj)) {
            if (C46041a.m85635Pu(this.nCh)) {
                if (C5046bo.isNullOrNil(C46041a.m85633Ps(this.nCh))) {
                    this.nCh = C46041a.m85636Pv(this.nCh);
                } else {
                    C4990ab.m7416i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
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
                    AppMethodBeat.m2505o(22130);
                    return;
                }
            }
            this.nCj = C34382c.bIR();
        }
        if (this.nCl != 1) {
            this.nCn = 0;
            this.nCm = 3;
            this.nCp = new C12251b(this.nCh, this.nCj, "", C5046bo.m7555gQ(this), this.nCl);
            C9638aw.m17182Rg().mo14541a(this.nCp, 0);
        } else {
            this.nCn = -1;
            this.nCm = 4;
        }
        init();
        AppMethodBeat.m2505o(22130);
    }

    public void onStart() {
        AppMethodBeat.m2504i(22131);
        super.onStart();
        this.nCq = new C34369c();
        C9638aw.m17182Rg().mo14541a(this.nCq, 0);
        AppMethodBeat.m2505o(22131);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22132);
        C4990ab.m7410d("MicroMsg.IPCallDialUI", "onResume");
        super.onResume();
        AppMethodBeat.m2505o(22132);
    }

    public final int getLayoutId() {
        return 2130969888;
    }

    private void init() {
        AppMethodBeat.m2504i(22133);
        C4990ab.m7417i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 80, null, null)), C5046bo.dpG());
        if (C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            setMMTitle((int) C25738R.string.cgk);
            setVolumeControlStream(1);
            this.nzR = (DialPad) findViewById(2131825087);
            this.nzS = (TextView) findViewById(2131825078);
            this.nzW = findViewById(2131825081);
            this.nzT = (EditText) findViewById(2131825079);
            this.nzU = findViewById(2131825080);
            this.goa = (TextView) findViewById(2131825083);
            this.nzV = (ImageButton) findViewById(2131823306);
            this.nzX = (TextView) findViewById(2131825082);
            this.nzY = (TextView) findViewById(2131825084);
            this.nCg = new C12313b(this, this.nzT, this.nzS, this.nzU, this.nzR, this.nzV, this.goa, this.nzW, this.nzX, this.nzY);
            this.nCg.nzQ = this;
            if (!C5046bo.isNullOrNil(this.nCh)) {
                this.nCg.mo24167cq(this.nCh, -1);
            }
            if (!C5046bo.isNullOrNil(this.nCj)) {
                this.nCg.mo24164OZ(this.nCj);
            }
            if (!(C5046bo.isNullOrNil(this.nCh) || C5046bo.isNullOrNil(this.nCj))) {
                this.nCg.bId();
            }
            this.nCg.mo24165ae(this.nCo);
            AppMethodBeat.m2505o(22133);
            return;
        }
        AppMethodBeat.m2505o(22133);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(22134);
        super.onActivityResult(i, i2, intent);
        C12313b c12313b = this.nCg;
        C4990ab.m7410d("MicroMsg.DialPadController", "onActivityResult");
        if (i == 100 && i2 == 100) {
            String bc = C5046bo.m7532bc(intent.getStringExtra("country_name"), "");
            String bc2 = C5046bo.m7532bc(intent.getStringExtra("couttry_code"), "");
            C4990ab.m7411d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", bc2, bc);
            if (!(C5046bo.isNullOrNil(bc2) || C5046bo.isNullOrNil(bc))) {
                c12313b.nzZ = bc;
                c12313b.nAa = "+".concat(String.valueOf(bc2));
                c12313b.nzS.setText(c12313b.nAa);
                c12313b.nAb = C12313b.m20238eL(bc2.replace("+", ""), c12313b.nAb);
                c12313b.mo24167cq(c12313b.nAb, -1);
                c12313b.nAf = false;
            }
            AppMethodBeat.m2505o(22134);
            return;
        }
        if (i == 1001 && i2 == -1) {
            intent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
            c12313b.crP.setResult(-1, intent);
            c12313b.crP.finish();
        }
        AppMethodBeat.m2505o(22134);
    }

    /* renamed from: p */
    public final void mo24184p(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(22135);
        C4990ab.m7417i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", str, str2, str3, str4);
        if (!C34382c.m56382eo(this)) {
            AppMethodBeat.m2505o(22135);
        } else if (C46032c.bHc().mo73925xf(C5046bo.getInt(str, -1))) {
            C30379h.m48461b((Context) this, getString(C25738R.string.abs), getString(C25738R.string.abt), true);
            C7060h.pYm.mo8374X(12058, str);
            AppMethodBeat.m2505o(22135);
        } else {
            C7060h.pYm.mo8381e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            Intent intent = new Intent(this, IPCallTalkUI.class);
            intent.putExtra("IPCallTalkUI_contactId", str3);
            intent.putExtra("IPCallTalkUI_countryCode", str);
            intent.putExtra("IPCallTalkUI_nickname", str4);
            intent.putExtra("IPCallTalkUI_phoneNumber", str2);
            intent.putExtra("IPCallTalkUI_dialScene", this.nCl);
            intent.putExtra("IPCallTalkUI_countryType", this.nCm);
            startActivityForResult(intent, 1001);
            AppMethodBeat.m2505o(22135);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22136);
        super.onDestroy();
        if (this.nCg != null) {
            this.nCg.nzQ = null;
        }
        C4879a.xxA.mo10053d(this.nCr);
        C9638aw.m17182Rg().mo14546b(807, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(746, (C1202f) this);
        AppMethodBeat.m2505o(22136);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(22137);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(22137);
            return;
        }
        C4990ab.m7417i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C211133(), new C211124());
                    break;
                }
                init();
                AppMethodBeat.m2505o(22137);
                return;
        }
        AppMethodBeat.m2505o(22137);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22138);
        if (c1207m instanceof C12251b) {
            if (i == 0 && i2 == 0 && c1207m == this.nCp) {
                if (this.nCp.nyi != null) {
                    C4990ab.m7417i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", Integer.valueOf(this.nCp.nyi.vYu), this.nCp.nyi.wOT, this.nCp.nyi.nHd);
                }
                if (this.nCn != 2) {
                    int i3;
                    this.nCn = 1;
                    this.nCm = 1;
                    C12251b c12251b = this.nCp;
                    if (c12251b.nyi == null || c12251b.nyi.vYu != 2) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        C4990ab.m7416i("MicroMsg.IPCallDialUI", "check error show error dialog");
                        AppMethodBeat.m2505o(22138);
                        return;
                    }
                    c12251b = this.nCp;
                    if (c12251b.nyi == null || !(c12251b.nyi.vYu == 1 || c12251b.nyi.vYu == 0)) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        if (this.nCp.nyi == null || C5046bo.isNullOrNil(this.nCp.nyi.nHd)) {
                            C4990ab.m7416i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
                        } else if (this.nCg != null) {
                            C4990ab.m7417i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", this.nCp.nyi.nHd, this.nCj);
                            this.nCj = this.nCp.nyi.nHd;
                            this.nCg.mo24164OZ(this.nCp.nyi.nHd);
                        }
                    }
                    if (!(this.nCp.nyi == null || C5046bo.isNullOrNil(this.nCp.nyi.wOT) || this.nCg == null)) {
                        C4990ab.m7417i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", this.nCp.nyi.wOT, this.nCh);
                        this.nCh = this.nCp.nyi.wOT;
                        this.nCg.mo24167cq(this.nCp.nyi.wOT, -1);
                        AppMethodBeat.m2505o(22138);
                        return;
                    }
                }
                C4990ab.m7416i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
                AppMethodBeat.m2505o(22138);
                return;
            }
        } else if (c1207m instanceof C34369c) {
            if (i == 0 && i2 == 0) {
                this.nCo = ((C34369c) c1207m).nyk.wuh;
            } else {
                this.nCo = null;
            }
            if (this.nCg != null) {
                this.nCg.mo24165ae(this.nCo);
            }
        }
        AppMethodBeat.m2505o(22138);
    }

    /* renamed from: Pa */
    public final void mo24182Pa(String str) {
        AppMethodBeat.m2504i(22139);
        C4990ab.m7417i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", str, this.nCj);
        if (!(this.nCn == 2 || this.nCn == -1 || this.nCj.equals(str))) {
            bIm();
        }
        AppMethodBeat.m2505o(22139);
    }

    /* renamed from: Pb */
    public final void mo24183Pb(String str) {
        AppMethodBeat.m2504i(22140);
        C4990ab.m7417i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", str, this.nCh);
        if (!(this.nCn == 2 || this.nCn == -1 || this.nCh.equals(str))) {
            bIm();
        }
        AppMethodBeat.m2505o(22140);
    }

    private void bIm() {
        AppMethodBeat.m2504i(22141);
        C4990ab.m7416i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
        this.nCn = 2;
        if (this.nCm == 1) {
            this.nCm = 2;
            AppMethodBeat.m2505o(22141);
            return;
        }
        this.nCm = 4;
        AppMethodBeat.m2505o(22141);
    }
}
