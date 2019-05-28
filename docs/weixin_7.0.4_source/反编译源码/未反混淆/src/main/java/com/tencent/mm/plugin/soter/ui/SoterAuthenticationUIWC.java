package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.b;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.plugin.soter.d.l;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.b.d;
import com.tencent.soter.a.b.e;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUIWC extends MMActivity {
    private static b rNO = null;
    public static a rOx = null;
    private String appId = null;
    private int fromScene = -1;
    private ProgressDialog kvA = null;
    private c rOr = null;
    private com.tencent.soter.a.b.b<d> rOv = new com.tencent.soter.a.b.b<d>() {
        public final /* bridge */ /* synthetic */ void a(e eVar) {
        }
    };

    public static class a extends Handler {
        private WeakReference<SoterAuthenticationUIWC> lWJ;

        /* synthetic */ a(SoterAuthenticationUIWC soterAuthenticationUIWC, byte b) {
            this(soterAuthenticationUIWC);
        }

        private a(SoterAuthenticationUIWC soterAuthenticationUIWC) {
            AppMethodBeat.i(59362);
            this.lWJ = null;
            this.lWJ = new WeakReference(soterAuthenticationUIWC);
            AppMethodBeat.o(59362);
        }

        @TargetApi(23)
        public final void handleMessage(Message message) {
            AppMethodBeat.i(59363);
            super.handleMessage(message);
            k kVar;
            switch (message.what) {
                case 0:
                    ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform ok");
                    kVar = (k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.a((SoterAuthenticationUIWC) this.lWJ.get(), kVar);
                    AppMethodBeat.o(59363);
                    return;
                case 1:
                    ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform cancel");
                    kVar = (k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.b((SoterAuthenticationUIWC) this.lWJ.get(), kVar);
                    AppMethodBeat.o(59363);
                    return;
                case 2:
                    ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform fail");
                    kVar = (k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.c((SoterAuthenticationUIWC) this.lWJ.get(), kVar);
                    AppMethodBeat.o(59363);
                    return;
                case 3:
                    ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: request permission");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(59363);
                        return;
                    }
                    String[] stringArray = message.getData().getStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                    int i = message.getData().getInt("request_code");
                    if (stringArray == null || stringArray.length <= 1) {
                        ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: permission null");
                        AppMethodBeat.o(59363);
                        return;
                    }
                    ((SoterAuthenticationUIWC) this.lWJ.get()).requestPermissions(stringArray, i);
                    AppMethodBeat.o(59363);
                    return;
                case 4:
                    ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: show progress");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.a((SoterAuthenticationUIWC) this.lWJ.get());
                    AppMethodBeat.o(59363);
                    return;
                case 5:
                    ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: dismiss progress");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.b((SoterAuthenticationUIWC) this.lWJ.get());
                    AppMethodBeat.o(59363);
                    return;
                case 6:
                    ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: show dialog");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(59363);
                        return;
                    }
                    SoterAuthenticationUIWC.rNO = (b) message.obj;
                    AppMethodBeat.o(59363);
                    return;
                default:
                    ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: unidentified msg: %d", Integer.valueOf(message.what));
                    AppMethodBeat.o(59363);
                    return;
            }
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(59364);
            if (aVar.lWJ != null) {
                aVar.lWJ.clear();
            }
            AppMethodBeat.o(59364);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SoterAuthenticationUIWC() {
        AppMethodBeat.i(59365);
        AppMethodBeat.o(59365);
    }

    static /* synthetic */ void c(SoterAuthenticationUIWC soterAuthenticationUIWC, k kVar) {
        AppMethodBeat.i(59376);
        soterAuthenticationUIWC.a(kVar);
        AppMethodBeat.o(59376);
    }

    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(59366);
        super.onCreate(bundle);
        if (rOx != null) {
            a.a(rOx);
        }
        rOx = new a(this, (byte) 0);
        j jVar = new j();
        k kVar = new k();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (bo.isNullOrNil(stringExtra)) {
            ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode : null");
            kVar.errCode = 90003;
            kVar.aIm = "authen mode is null";
        } else {
            try {
                jVar.rOi = Byte.parseByte(bo.bc(stringExtra.substring(2), "00"), 16);
                jVar.msn = getIntent().getStringExtra("challenge");
                jVar.content = getIntent().getStringExtra("auth_content");
                if (!m.cvU()) {
                    ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: not support soter");
                    kVar.errCode = 90001;
                    kVar.aIm = "not support soter";
                } else if (jVar.rOi <= (byte) 0) {
                    ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: request mode illegal");
                    kVar.errCode = 90003;
                    kVar.aIm = "resp model error";
                } else if (bo.isNullOrNil(jVar.msn)) {
                    ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge null");
                    kVar.errCode = 90004;
                    kVar.aIm = "challenge is null";
                } else if (jVar.msn.length() >= 512) {
                    ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge too long");
                    kVar.errCode = 90004;
                    kVar.aIm = "challenge is too long. 512 chars at most";
                } else if (bo.isNullOrNil(jVar.content)) {
                    jVar.content = getString(R.string.eqt);
                } else if (jVar.content.length() > 42) {
                    ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: content too long. use default");
                    jVar.content = getString(R.string.eqt);
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode format: %s", stringExtra);
                kVar.errCode = 90003;
                kVar.aIm = "authen mode is illegal: number format error. found: ".concat(String.valueOf(stringExtra));
            }
        }
        if (kVar.errCode != 0) {
            a(kVar);
            AppMethodBeat.o(59366);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        com.tencent.mm.plugin.soter.c.a aVar = com.tencent.mm.plugin.soter.c.a.rNL;
        this.rOr = com.tencent.mm.plugin.soter.c.a.a(this, jVar, kVar, rOx);
        if (this.rOr == null) {
            ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: no corresponding authen mode");
            kVar.errCode = 90003;
            kVar.aIm = "no corresponding mode";
            a(kVar);
            AppMethodBeat.o(59366);
            return;
        }
        this.rOr.rOd = new f();
        this.rOr.rOc = new com.tencent.mm.plugin.soter.b.e();
        this.rOr.gOW = 2;
        this.appId = getIntent().getStringExtra("key_app_id");
        this.rOr.fj();
        AppMethodBeat.o(59366);
    }

    public void onResume() {
        AppMethodBeat.i(59367);
        super.onResume();
        if (this.rOr != null) {
            this.rOr.onResume();
        }
        AppMethodBeat.o(59367);
    }

    public void onPause() {
        AppMethodBeat.i(59368);
        super.onPause();
        if (this.rOr != null) {
            this.rOr.onPause();
        }
        AppMethodBeat.o(59368);
    }

    public final int getLayoutId() {
        return -1;
    }

    private void a(k kVar) {
        AppMethodBeat.i(59369);
        setResult(1, d(kVar));
        c(kVar);
        finish();
        AppMethodBeat.o(59369);
    }

    private static Intent d(k kVar) {
        AppMethodBeat.i(59370);
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", kVar.errCode);
        bundle.putString("err_msg", kVar.aIm);
        bundle.putByte("use_mode", kVar.rOj);
        bundle.putString("result_json", kVar.cLO);
        bundle.putString("result_json_signature", kVar.rOk);
        ab.d("MicroMsg.SoterAuthenticationUIWC", "hy: dump mp soter result: %s", bundle.toString());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        AppMethodBeat.o(59370);
        return intent;
    }

    private void c(k kVar) {
        AppMethodBeat.i(59371);
        if (kVar == null) {
            AppMethodBeat.o(59371);
            return;
        }
        if (this.fromScene == 0) {
            int zS = zS(kVar.errCode);
            l lVar = l.rOl;
            l.l("requireSoterBiometricAuthentication", this.appId, zS, kVar.errCode);
        }
        AppMethodBeat.o(59371);
    }

    private static int zS(int i) {
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
        AppMethodBeat.i(59372);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.rOr != null) {
            this.rOr.onRequestPermissionsResult(i, strArr, iArr);
        }
        AppMethodBeat.o(59372);
    }

    public void onDestroy() {
        AppMethodBeat.i(59373);
        super.onDestroy();
        if (this.kvA != null && this.kvA.isShowing()) {
            ab.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mProgressDialog dismiss!");
            this.kvA.dismiss();
        }
        if (rNO != null && rNO.isShowing()) {
            ab.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mAuthenDialog dismiss!");
            rNO.dismiss();
        }
        a.a(rOx);
        AppMethodBeat.o(59373);
    }

    static /* synthetic */ void a(SoterAuthenticationUIWC soterAuthenticationUIWC, k kVar) {
        AppMethodBeat.i(59374);
        soterAuthenticationUIWC.setResult(-1, d(kVar));
        soterAuthenticationUIWC.c(kVar);
        soterAuthenticationUIWC.finish();
        AppMethodBeat.o(59374);
    }

    static /* synthetic */ void b(SoterAuthenticationUIWC soterAuthenticationUIWC, k kVar) {
        AppMethodBeat.i(59375);
        kVar.errCode = 90008;
        kVar.aIm = "user cancelled the authentication process";
        soterAuthenticationUIWC.setResult(0, d(kVar));
        soterAuthenticationUIWC.c(kVar);
        soterAuthenticationUIWC.finish();
        AppMethodBeat.o(59375);
    }
}
