package com.tencent.p177mm.plugin.soter.p769ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.app.C7452b;
import android.util.SparseArray;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.soter.p1029c.C29252a;
import com.tencent.p177mm.plugin.soter.p1029c.C46260c;
import com.tencent.p177mm.plugin.soter.p1029c.C46260c.C39853a;
import com.tencent.p177mm.plugin.soter.p528d.C39855i;
import com.tencent.p177mm.plugin.soter.p528d.C39856k;
import com.tencent.p177mm.plugin.soter.p528d.C46263j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.p663a.C30954a.C309551;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16166d;
import com.tencent.soter.p663a.p1106b.C46744e;
import com.tencent.soter.p663a.p1107c.C16167a;
import com.tencent.soter.p663a.p664g.C40994f;
import com.tencent.soter.p663a.p664g.C44471e;
import com.tencent.soter.p663a.p664g.C44471e.C44470a;
import com.tencent.soter.p663a.p664g.C44472g;
import java.lang.ref.WeakReference;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI */
public class SoterAuthenticationUI extends AppCompatActivity {
    private static C7452b rNO = null;
    public static C7645a rOu = null;
    /* renamed from: JF */
    private ResultReceiver f2131JF;
    private String appId = null;
    private int fromScene = -1;
    private ProgressDialog kvA = null;
    private C39853a rOe = new C76461();
    private C46260c rOr = null;
    private boolean rOs = false;
    private C30972i rOt = null;
    private C16164b<C16166d> rOv = new C76472();
    private int scene = -1;

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI$a */
    public static class C7645a extends Handler {
        private WeakReference<SoterAuthenticationUI> lWJ;

        /* synthetic */ C7645a(SoterAuthenticationUI soterAuthenticationUI, byte b) {
            this(soterAuthenticationUI);
        }

        private C7645a(SoterAuthenticationUI soterAuthenticationUI) {
            AppMethodBeat.m2504i(73897);
            this.lWJ = null;
            this.lWJ = new WeakReference(soterAuthenticationUI);
            AppMethodBeat.m2505o(73897);
        }

        @TargetApi(23)
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(73898);
            super.handleMessage(message);
            C39856k c39856k;
            switch (message.what) {
                case 0:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
                    c39856k = (C39856k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.m2505o(73898);
                        return;
                    }
                    SoterAuthenticationUI.m13618a((SoterAuthenticationUI) this.lWJ.get(), c39856k);
                    AppMethodBeat.m2505o(73898);
                    return;
                case 1:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
                    c39856k = (C39856k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.m2505o(73898);
                        return;
                    }
                    SoterAuthenticationUI.m13622b((SoterAuthenticationUI) this.lWJ.get(), c39856k);
                    AppMethodBeat.m2505o(73898);
                    return;
                case 2:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
                    c39856k = (C39856k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.m2505o(73898);
                        return;
                    }
                    SoterAuthenticationUI.m13624c((SoterAuthenticationUI) this.lWJ.get(), c39856k);
                    AppMethodBeat.m2505o(73898);
                    return;
                case 3:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.m2505o(73898);
                        return;
                    }
                    String[] stringArray = message.getData().getStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                    int i = message.getData().getInt("request_code");
                    if (stringArray == null || stringArray.length <= 1) {
                        C4990ab.m7412e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
                        AppMethodBeat.m2505o(73898);
                        return;
                    }
                    ((SoterAuthenticationUI) this.lWJ.get()).requestPermissions(stringArray, i);
                    AppMethodBeat.m2505o(73898);
                    return;
                case 4:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.m2505o(73898);
                        return;
                    }
                    SoterAuthenticationUI.m13617a((SoterAuthenticationUI) this.lWJ.get());
                    AppMethodBeat.m2505o(73898);
                    return;
                case 5:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.m2505o(73898);
                        return;
                    }
                    SoterAuthenticationUI.m13621b((SoterAuthenticationUI) this.lWJ.get());
                    AppMethodBeat.m2505o(73898);
                    return;
                case 6:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.m2505o(73898);
                        return;
                    }
                    SoterAuthenticationUI.rNO = (C7452b) message.obj;
                    AppMethodBeat.m2505o(73898);
                    return;
                default:
                    C4990ab.m7413e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", Integer.valueOf(message.what));
                    AppMethodBeat.m2505o(73898);
                    return;
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m13626a(C7645a c7645a) {
            AppMethodBeat.m2504i(73899);
            if (c7645a.lWJ != null) {
                c7645a.lWJ.clear();
            }
            AppMethodBeat.m2505o(73899);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI$1 */
    class C76461 implements C39853a {
        C76461() {
        }

        /* renamed from: a */
        public final void mo17329a(C30972i c30972i) {
            AppMethodBeat.m2504i(73895);
            SoterAuthenticationUI.this.rOt = c30972i;
            AppMethodBeat.m2505o(73895);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI$2 */
    class C76472 implements C16164b<C16166d> {
        C76472() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(73896);
            C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: init soter ".concat(String.valueOf(((C16166d) c46744e).isSuccess())));
            AppMethodBeat.m2505o(73896);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SoterAuthenticationUI() {
        AppMethodBeat.m2504i(73900);
        AppMethodBeat.m2505o(73900);
    }

    /* renamed from: c */
    static /* synthetic */ void m13624c(SoterAuthenticationUI soterAuthenticationUI, C39856k c39856k) {
        AppMethodBeat.m2504i(73911);
        soterAuthenticationUI.m13616a(c39856k);
        AppMethodBeat.m2505o(73911);
    }

    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(73901);
        super.onCreate(bundle);
        this.f2131JF = (ResultReceiver) getIntent().getParcelableExtra("Soter_Result_Receiver");
        if (rOu != null) {
            C7645a.m13626a(rOu);
        }
        rOu = new C7645a(this, (byte) 0);
        C46263j c46263j = new C46263j();
        C39856k c39856k = new C39856k();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7412e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
            c39856k.errCode = 90003;
            c39856k.aIm = "authen mode is null";
        } else {
            try {
                c46263j.rOi = Byte.parseByte(C5046bo.m7532bc(stringExtra.substring(2), "00"), 16);
                c46263j.msn = getIntent().getStringExtra("challenge");
                c46263j.content = getIntent().getStringExtra("auth_content");
                if (!C40997a.dQN()) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
                    c39856k.errCode = 90001;
                    c39856k.aIm = "not support soter";
                } else if (c46263j.rOi <= (byte) 0) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
                    c39856k.errCode = 90003;
                    c39856k.aIm = "resp model error";
                } else if (C5046bo.isNullOrNil(c46263j.msn)) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
                    c39856k.errCode = 90004;
                    c39856k.aIm = "challenge is null";
                } else if (c46263j.msn.length() >= 512) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
                    c39856k.errCode = 90004;
                    c39856k.aIm = "challenge is too long. 512 chars at most";
                } else if (C5046bo.isNullOrNil(c46263j.content)) {
                    c46263j.content = getString(C25738R.string.eqt);
                } else if (c46263j.content.length() > 42) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
                    c46263j.content = getString(C25738R.string.eqt);
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                C4990ab.m7413e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", stringExtra);
                c39856k.errCode = 90003;
                c39856k.aIm = "authen mode is illegal: number format error. found: ".concat(String.valueOf(stringExtra));
            }
        }
        if (c39856k.errCode != 0) {
            m13616a(c39856k);
            AppMethodBeat.m2505o(73901);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_luggage_fromscene", 1);
        this.scene = getIntent().getIntExtra("key_soter_fp_luggage_scene", 2048);
        C29252a c29252a = C29252a.rNL;
        this.rOr = C29252a.m46445a(this, c46263j, c39856k, rOu);
        if (this.rOr == null) {
            C4990ab.m7412e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
            c39856k.errCode = 90003;
            c39856k.aIm = "no corresponding mode";
            m13616a(c39856k);
            AppMethodBeat.m2505o(73901);
            return;
        }
        this.rOr.rOd = null;
        this.rOr.rOc = null;
        this.rOr.gOW = this.scene;
        this.rOr.rOe = this.rOe;
        boolean isInit = C16167a.dRe().isInit();
        C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: isInit:".concat(String.valueOf(isInit)));
        if (!isInit) {
            C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "hy: init scene:" + this.rOr.gOW);
            C44471e c44471e = new C44470a().mo70643E(this.rOr.gOW).Awt;
            C44472g.dRq().mo70644R(new C309551(getApplicationContext(), c44471e, this.rOv));
            this.rOs = true;
        }
        this.appId = getIntent().getStringExtra("key_app_id");
        this.rOr.mo69233fj();
        AppMethodBeat.m2505o(73901);
    }

    public void onResume() {
        AppMethodBeat.m2504i(73902);
        super.onResume();
        if (this.rOr != null) {
            this.rOr.onResume();
        }
        AppMethodBeat.m2505o(73902);
    }

    public void onPause() {
        AppMethodBeat.m2504i(73903);
        super.onPause();
        if (this.rOr != null) {
            this.rOr.onPause();
        }
        AppMethodBeat.m2505o(73903);
    }

    /* renamed from: a */
    private void m13616a(C39856k c39856k) {
        AppMethodBeat.m2504i(73904);
        this.f2131JF.send(1, SoterAuthenticationUI.m13619b(c39856k));
        m13623c(c39856k);
        finish();
        AppMethodBeat.m2505o(73904);
    }

    /* renamed from: b */
    private static Bundle m13619b(C39856k c39856k) {
        AppMethodBeat.m2504i(73905);
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", c39856k.errCode);
        bundle.putString("err_msg", c39856k.aIm);
        bundle.putByte("use_mode", c39856k.rOj);
        bundle.putString("result_json", c39856k.cLO);
        bundle.putString("result_json_signature", c39856k.rOk);
        C4990ab.m7411d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", bundle.toString());
        AppMethodBeat.m2505o(73905);
        return bundle;
    }

    /* renamed from: c */
    private void m13623c(C39856k c39856k) {
        AppMethodBeat.m2504i(73906);
        if (c39856k == null) {
            AppMethodBeat.m2505o(73906);
            return;
        }
        if (this.fromScene == 1) {
            C39855i.m68267ai(this.appId, c39856k.errCode, SoterAuthenticationUI.m13625zS(c39856k.errCode));
        }
        AppMethodBeat.m2505o(73906);
    }

    /* renamed from: zS */
    private static int m13625zS(int i) {
        switch (i) {
            case 0:
                return 0;
            case 90001:
            case 90002:
            case 90003:
            case 90004:
            case 90006:
            case 90007:
            case 90011:
                return 2;
            case 90008:
            case 90009:
            case 90010:
                return 3;
            default:
                return -1;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(73907);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.rOr != null) {
            this.rOr.onRequestPermissionsResult(i, strArr, iArr);
        }
        AppMethodBeat.m2505o(73907);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(73908);
        super.onDestroy();
        if (this.kvA != null && this.kvA.isShowing()) {
            C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "onDestroy mProgressDialog dismiss!");
            this.kvA.dismiss();
        }
        if (rNO != null && rNO.isShowing()) {
            C4990ab.m7416i("MicroMsg.SoterAuthenticationUI", "onDestroy mAuthenDialog dismiss!");
            rNO.dismiss();
        }
        C7645a.m13626a(rOu);
        if (this.rOs) {
            C40994f.dRn().dRo();
            C16167a dRe = C16167a.dRe();
            synchronized (C16167a.class) {
                try {
                    dRe.bZi = false;
                    dRe.cul = false;
                    dRe.AvO = new SparseArray(10);
                    dRe.AvP = null;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(73908);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(73908);
    }

    /* renamed from: b */
    static /* synthetic */ void m13622b(SoterAuthenticationUI soterAuthenticationUI, C39856k c39856k) {
        AppMethodBeat.m2504i(73910);
        c39856k.errCode = 90008;
        c39856k.aIm = "user cancelled the authentication process";
        soterAuthenticationUI.f2131JF.send(0, SoterAuthenticationUI.m13619b(c39856k));
        soterAuthenticationUI.m13623c(c39856k);
        soterAuthenticationUI.finish();
        AppMethodBeat.m2505o(73910);
    }
}
