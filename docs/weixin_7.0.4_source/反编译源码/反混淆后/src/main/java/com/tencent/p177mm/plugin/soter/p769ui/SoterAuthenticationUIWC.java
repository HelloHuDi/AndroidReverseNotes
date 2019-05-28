package com.tencent.p177mm.plugin.soter.p769ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p069v7.app.C7452b;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.soter.p1029c.C29252a;
import com.tencent.p177mm.plugin.soter.p1029c.C46260c;
import com.tencent.p177mm.plugin.soter.p527b.C35151f;
import com.tencent.p177mm.plugin.soter.p527b.C36819e;
import com.tencent.p177mm.plugin.soter.p528d.C35157l;
import com.tencent.p177mm.plugin.soter.p528d.C39856k;
import com.tencent.p177mm.plugin.soter.p528d.C4104m;
import com.tencent.p177mm.plugin.soter.p528d.C46263j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16166d;
import com.tencent.soter.p663a.p1106b.C46744e;
import java.lang.ref.WeakReference;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC */
public class SoterAuthenticationUIWC extends MMActivity {
    private static C7452b rNO = null;
    public static C35158a rOx = null;
    private String appId = null;
    private int fromScene = -1;
    private ProgressDialog kvA = null;
    private C46260c rOr = null;
    private C16164b<C16166d> rOv = new C462641();

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC$a */
    public static class C35158a extends Handler {
        private WeakReference<SoterAuthenticationUIWC> lWJ;

        /* synthetic */ C35158a(SoterAuthenticationUIWC soterAuthenticationUIWC, byte b) {
            this(soterAuthenticationUIWC);
        }

        private C35158a(SoterAuthenticationUIWC soterAuthenticationUIWC) {
            AppMethodBeat.m2504i(59362);
            this.lWJ = null;
            this.lWJ = new WeakReference(soterAuthenticationUIWC);
            AppMethodBeat.m2505o(59362);
        }

        @TargetApi(23)
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(59363);
            super.handleMessage(message);
            C39856k c39856k;
            switch (message.what) {
                case 0:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUIWC", "hy: inform ok");
                    c39856k = (C39856k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.m2505o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.m86647a((SoterAuthenticationUIWC) this.lWJ.get(), c39856k);
                    AppMethodBeat.m2505o(59363);
                    return;
                case 1:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUIWC", "hy: inform cancel");
                    c39856k = (C39856k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.m2505o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.m86650b((SoterAuthenticationUIWC) this.lWJ.get(), c39856k);
                    AppMethodBeat.m2505o(59363);
                    return;
                case 2:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUIWC", "hy: inform fail");
                    c39856k = (C39856k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.m2505o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.m86652c((SoterAuthenticationUIWC) this.lWJ.get(), c39856k);
                    AppMethodBeat.m2505o(59363);
                    return;
                case 3:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUIWC", "hy: request permission");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.m2505o(59363);
                        return;
                    }
                    String[] stringArray = message.getData().getStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                    int i = message.getData().getInt("request_code");
                    if (stringArray == null || stringArray.length <= 1) {
                        C4990ab.m7412e("MicroMsg.SoterAuthenticationUIWC", "hy: permission null");
                        AppMethodBeat.m2505o(59363);
                        return;
                    }
                    ((SoterAuthenticationUIWC) this.lWJ.get()).requestPermissions(stringArray, i);
                    AppMethodBeat.m2505o(59363);
                    return;
                case 4:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUIWC", "hy: show progress");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.m2505o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.m86646a((SoterAuthenticationUIWC) this.lWJ.get());
                    AppMethodBeat.m2505o(59363);
                    return;
                case 5:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUIWC", "hy: dismiss progress");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.m2505o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.m86649b((SoterAuthenticationUIWC) this.lWJ.get());
                    AppMethodBeat.m2505o(59363);
                    return;
                case 6:
                    C4990ab.m7416i("MicroMsg.SoterAuthenticationUIWC", "hy: show dialog");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        C4990ab.m7420w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.m2505o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.rNO = (C7452b) message.obj;
                    AppMethodBeat.m2505o(59363);
                    return;
                default:
                    C4990ab.m7413e("MicroMsg.SoterAuthenticationUIWC", "hy: unidentified msg: %d", Integer.valueOf(message.what));
                    AppMethodBeat.m2505o(59363);
                    return;
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m57792a(C35158a c35158a) {
            AppMethodBeat.m2504i(59364);
            if (c35158a.lWJ != null) {
                c35158a.lWJ.clear();
            }
            AppMethodBeat.m2505o(59364);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC$1 */
    class C462641 implements C16164b<C16166d> {
        C462641() {
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo17330a(C46744e c46744e) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SoterAuthenticationUIWC() {
        AppMethodBeat.m2504i(59365);
        AppMethodBeat.m2505o(59365);
    }

    /* renamed from: c */
    static /* synthetic */ void m86652c(SoterAuthenticationUIWC soterAuthenticationUIWC, C39856k c39856k) {
        AppMethodBeat.m2504i(59376);
        soterAuthenticationUIWC.m86645a(c39856k);
        AppMethodBeat.m2505o(59376);
    }

    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(59366);
        super.onCreate(bundle);
        if (rOx != null) {
            C35158a.m57792a(rOx);
        }
        rOx = new C35158a(this, (byte) 0);
        C46263j c46263j = new C46263j();
        C39856k c39856k = new C39856k();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7412e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode : null");
            c39856k.errCode = 90003;
            c39856k.aIm = "authen mode is null";
        } else {
            try {
                c46263j.rOi = Byte.parseByte(C5046bo.m7532bc(stringExtra.substring(2), "00"), 16);
                c46263j.msn = getIntent().getStringExtra("challenge");
                c46263j.content = getIntent().getStringExtra("auth_content");
                if (!C4104m.cvU()) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUIWC", "hy: not support soter");
                    c39856k.errCode = 90001;
                    c39856k.aIm = "not support soter";
                } else if (c46263j.rOi <= (byte) 0) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: request mode illegal");
                    c39856k.errCode = 90003;
                    c39856k.aIm = "resp model error";
                } else if (C5046bo.isNullOrNil(c46263j.msn)) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge null");
                    c39856k.errCode = 90004;
                    c39856k.aIm = "challenge is null";
                } else if (c46263j.msn.length() >= 512) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge too long");
                    c39856k.errCode = 90004;
                    c39856k.aIm = "challenge is too long. 512 chars at most";
                } else if (C5046bo.isNullOrNil(c46263j.content)) {
                    c46263j.content = getString(C25738R.string.eqt);
                } else if (c46263j.content.length() > 42) {
                    C4990ab.m7412e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: content too long. use default");
                    c46263j.content = getString(C25738R.string.eqt);
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                C4990ab.m7413e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode format: %s", stringExtra);
                c39856k.errCode = 90003;
                c39856k.aIm = "authen mode is illegal: number format error. found: ".concat(String.valueOf(stringExtra));
            }
        }
        if (c39856k.errCode != 0) {
            m86645a(c39856k);
            AppMethodBeat.m2505o(59366);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        C29252a c29252a = C29252a.rNL;
        this.rOr = C29252a.m46445a(this, c46263j, c39856k, rOx);
        if (this.rOr == null) {
            C4990ab.m7412e("MicroMsg.SoterAuthenticationUIWC", "hy: no corresponding authen mode");
            c39856k.errCode = 90003;
            c39856k.aIm = "no corresponding mode";
            m86645a(c39856k);
            AppMethodBeat.m2505o(59366);
            return;
        }
        this.rOr.rOd = new C35151f();
        this.rOr.rOc = new C36819e();
        this.rOr.gOW = 2;
        this.appId = getIntent().getStringExtra("key_app_id");
        this.rOr.mo69233fj();
        AppMethodBeat.m2505o(59366);
    }

    public void onResume() {
        AppMethodBeat.m2504i(59367);
        super.onResume();
        if (this.rOr != null) {
            this.rOr.onResume();
        }
        AppMethodBeat.m2505o(59367);
    }

    public void onPause() {
        AppMethodBeat.m2504i(59368);
        super.onPause();
        if (this.rOr != null) {
            this.rOr.onPause();
        }
        AppMethodBeat.m2505o(59368);
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: a */
    private void m86645a(C39856k c39856k) {
        AppMethodBeat.m2504i(59369);
        setResult(1, SoterAuthenticationUIWC.m86653d(c39856k));
        m86651c(c39856k);
        finish();
        AppMethodBeat.m2505o(59369);
    }

    /* renamed from: d */
    private static Intent m86653d(C39856k c39856k) {
        AppMethodBeat.m2504i(59370);
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", c39856k.errCode);
        bundle.putString("err_msg", c39856k.aIm);
        bundle.putByte("use_mode", c39856k.rOj);
        bundle.putString("result_json", c39856k.cLO);
        bundle.putString("result_json_signature", c39856k.rOk);
        C4990ab.m7411d("MicroMsg.SoterAuthenticationUIWC", "hy: dump mp soter result: %s", bundle.toString());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        AppMethodBeat.m2505o(59370);
        return intent;
    }

    /* renamed from: c */
    private void m86651c(C39856k c39856k) {
        AppMethodBeat.m2504i(59371);
        if (c39856k == null) {
            AppMethodBeat.m2505o(59371);
            return;
        }
        if (this.fromScene == 0) {
            int zS = SoterAuthenticationUIWC.m86654zS(c39856k.errCode);
            C35157l c35157l = C35157l.rOl;
            C35157l.m57791l("requireSoterBiometricAuthentication", this.appId, zS, c39856k.errCode);
        }
        AppMethodBeat.m2505o(59371);
    }

    /* renamed from: zS */
    private static int m86654zS(int i) {
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
        AppMethodBeat.m2504i(59372);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.rOr != null) {
            this.rOr.onRequestPermissionsResult(i, strArr, iArr);
        }
        AppMethodBeat.m2505o(59372);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(59373);
        super.onDestroy();
        if (this.kvA != null && this.kvA.isShowing()) {
            C4990ab.m7416i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mProgressDialog dismiss!");
            this.kvA.dismiss();
        }
        if (rNO != null && rNO.isShowing()) {
            C4990ab.m7416i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mAuthenDialog dismiss!");
            rNO.dismiss();
        }
        C35158a.m57792a(rOx);
        AppMethodBeat.m2505o(59373);
    }

    /* renamed from: a */
    static /* synthetic */ void m86647a(SoterAuthenticationUIWC soterAuthenticationUIWC, C39856k c39856k) {
        AppMethodBeat.m2504i(59374);
        soterAuthenticationUIWC.setResult(-1, SoterAuthenticationUIWC.m86653d(c39856k));
        soterAuthenticationUIWC.m86651c(c39856k);
        soterAuthenticationUIWC.finish();
        AppMethodBeat.m2505o(59374);
    }

    /* renamed from: b */
    static /* synthetic */ void m86650b(SoterAuthenticationUIWC soterAuthenticationUIWC, C39856k c39856k) {
        AppMethodBeat.m2504i(59375);
        c39856k.errCode = 90008;
        c39856k.aIm = "user cancelled the authentication process";
        soterAuthenticationUIWC.setResult(0, SoterAuthenticationUIWC.m86653d(c39856k));
        soterAuthenticationUIWC.m86651c(c39856k);
        soterAuthenticationUIWC.finish();
        AppMethodBeat.m2505o(59375);
    }
}
