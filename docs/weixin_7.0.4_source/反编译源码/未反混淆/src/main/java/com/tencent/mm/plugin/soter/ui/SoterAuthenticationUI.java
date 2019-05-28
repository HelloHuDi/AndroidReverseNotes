package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.b;
import android.util.SparseArray;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.soter.a.b.d;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUI extends AppCompatActivity {
    private static b rNO = null;
    public static a rOu = null;
    private ResultReceiver JF;
    private String appId = null;
    private int fromScene = -1;
    private ProgressDialog kvA = null;
    private com.tencent.mm.plugin.soter.c.c.a rOe = new com.tencent.mm.plugin.soter.c.c.a() {
        public final void a(i iVar) {
            AppMethodBeat.i(73895);
            SoterAuthenticationUI.this.rOt = iVar;
            AppMethodBeat.o(73895);
        }
    };
    private c rOr = null;
    private boolean rOs = false;
    private i rOt = null;
    private com.tencent.soter.a.b.b<d> rOv = new com.tencent.soter.a.b.b<d>() {
        public final /* synthetic */ void a(e eVar) {
            AppMethodBeat.i(73896);
            ab.i("MicroMsg.SoterAuthenticationUI", "hy: init soter ".concat(String.valueOf(((d) eVar).isSuccess())));
            AppMethodBeat.o(73896);
        }
    };
    private int scene = -1;

    public static class a extends Handler {
        private WeakReference<SoterAuthenticationUI> lWJ;

        /* synthetic */ a(SoterAuthenticationUI soterAuthenticationUI, byte b) {
            this(soterAuthenticationUI);
        }

        private a(SoterAuthenticationUI soterAuthenticationUI) {
            AppMethodBeat.i(73897);
            this.lWJ = null;
            this.lWJ = new WeakReference(soterAuthenticationUI);
            AppMethodBeat.o(73897);
        }

        @TargetApi(23)
        public final void handleMessage(Message message) {
            AppMethodBeat.i(73898);
            super.handleMessage(message);
            k kVar;
            switch (message.what) {
                case 0:
                    ab.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
                    kVar = (k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(73898);
                        return;
                    }
                    SoterAuthenticationUI.a((SoterAuthenticationUI) this.lWJ.get(), kVar);
                    AppMethodBeat.o(73898);
                    return;
                case 1:
                    ab.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
                    kVar = (k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(73898);
                        return;
                    }
                    SoterAuthenticationUI.b((SoterAuthenticationUI) this.lWJ.get(), kVar);
                    AppMethodBeat.o(73898);
                    return;
                case 2:
                    ab.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
                    kVar = (k) message.obj;
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(73898);
                        return;
                    }
                    SoterAuthenticationUI.c((SoterAuthenticationUI) this.lWJ.get(), kVar);
                    AppMethodBeat.o(73898);
                    return;
                case 3:
                    ab.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(73898);
                        return;
                    }
                    String[] stringArray = message.getData().getStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                    int i = message.getData().getInt("request_code");
                    if (stringArray == null || stringArray.length <= 1) {
                        ab.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
                        AppMethodBeat.o(73898);
                        return;
                    }
                    ((SoterAuthenticationUI) this.lWJ.get()).requestPermissions(stringArray, i);
                    AppMethodBeat.o(73898);
                    return;
                case 4:
                    ab.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(73898);
                        return;
                    }
                    SoterAuthenticationUI.a((SoterAuthenticationUI) this.lWJ.get());
                    AppMethodBeat.o(73898);
                    return;
                case 5:
                    ab.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(73898);
                        return;
                    }
                    SoterAuthenticationUI.b((SoterAuthenticationUI) this.lWJ.get());
                    AppMethodBeat.o(73898);
                    return;
                case 6:
                    ab.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
                    if (this.lWJ == null || this.lWJ.get() == null) {
                        ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(73898);
                        return;
                    }
                    SoterAuthenticationUI.rNO = (b) message.obj;
                    AppMethodBeat.o(73898);
                    return;
                default:
                    ab.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", Integer.valueOf(message.what));
                    AppMethodBeat.o(73898);
                    return;
            }
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(73899);
            if (aVar.lWJ != null) {
                aVar.lWJ.clear();
            }
            AppMethodBeat.o(73899);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SoterAuthenticationUI() {
        AppMethodBeat.i(73900);
        AppMethodBeat.o(73900);
    }

    static /* synthetic */ void c(SoterAuthenticationUI soterAuthenticationUI, k kVar) {
        AppMethodBeat.i(73911);
        soterAuthenticationUI.a(kVar);
        AppMethodBeat.o(73911);
    }

    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73901);
        super.onCreate(bundle);
        this.JF = (ResultReceiver) getIntent().getParcelableExtra("Soter_Result_Receiver");
        if (rOu != null) {
            a.a(rOu);
        }
        rOu = new a(this, (byte) 0);
        j jVar = new j();
        k kVar = new k();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (bo.isNullOrNil(stringExtra)) {
            ab.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
            kVar.errCode = 90003;
            kVar.aIm = "authen mode is null";
        } else {
            try {
                jVar.rOi = Byte.parseByte(bo.bc(stringExtra.substring(2), "00"), 16);
                jVar.msn = getIntent().getStringExtra("challenge");
                jVar.content = getIntent().getStringExtra("auth_content");
                if (!com.tencent.soter.core.a.dQN()) {
                    ab.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
                    kVar.errCode = 90001;
                    kVar.aIm = "not support soter";
                } else if (jVar.rOi <= (byte) 0) {
                    ab.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
                    kVar.errCode = 90003;
                    kVar.aIm = "resp model error";
                } else if (bo.isNullOrNil(jVar.msn)) {
                    ab.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
                    kVar.errCode = 90004;
                    kVar.aIm = "challenge is null";
                } else if (jVar.msn.length() >= 512) {
                    ab.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
                    kVar.errCode = 90004;
                    kVar.aIm = "challenge is too long. 512 chars at most";
                } else if (bo.isNullOrNil(jVar.content)) {
                    jVar.content = getString(R.string.eqt);
                } else if (jVar.content.length() > 42) {
                    ab.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
                    jVar.content = getString(R.string.eqt);
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                ab.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", stringExtra);
                kVar.errCode = 90003;
                kVar.aIm = "authen mode is illegal: number format error. found: ".concat(String.valueOf(stringExtra));
            }
        }
        if (kVar.errCode != 0) {
            a(kVar);
            AppMethodBeat.o(73901);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_luggage_fromscene", 1);
        this.scene = getIntent().getIntExtra("key_soter_fp_luggage_scene", 2048);
        com.tencent.mm.plugin.soter.c.a aVar = com.tencent.mm.plugin.soter.c.a.rNL;
        this.rOr = com.tencent.mm.plugin.soter.c.a.a(this, jVar, kVar, rOu);
        if (this.rOr == null) {
            ab.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
            kVar.errCode = 90003;
            kVar.aIm = "no corresponding mode";
            a(kVar);
            AppMethodBeat.o(73901);
            return;
        }
        this.rOr.rOd = null;
        this.rOr.rOc = null;
        this.rOr.gOW = this.scene;
        this.rOr.rOe = this.rOe;
        boolean isInit = com.tencent.soter.a.c.a.dRe().isInit();
        ab.i("MicroMsg.SoterAuthenticationUI", "hy: isInit:".concat(String.valueOf(isInit)));
        if (!isInit) {
            ab.i("MicroMsg.SoterAuthenticationUI", "hy: init scene:" + this.rOr.gOW);
            com.tencent.soter.a.g.e eVar = new com.tencent.soter.a.g.e.a().E(this.rOr.gOW).Awt;
            g.dRq().R(new com.tencent.soter.a.a.AnonymousClass1(getApplicationContext(), eVar, this.rOv));
            this.rOs = true;
        }
        this.appId = getIntent().getStringExtra("key_app_id");
        this.rOr.fj();
        AppMethodBeat.o(73901);
    }

    public void onResume() {
        AppMethodBeat.i(73902);
        super.onResume();
        if (this.rOr != null) {
            this.rOr.onResume();
        }
        AppMethodBeat.o(73902);
    }

    public void onPause() {
        AppMethodBeat.i(73903);
        super.onPause();
        if (this.rOr != null) {
            this.rOr.onPause();
        }
        AppMethodBeat.o(73903);
    }

    private void a(k kVar) {
        AppMethodBeat.i(73904);
        this.JF.send(1, b(kVar));
        c(kVar);
        finish();
        AppMethodBeat.o(73904);
    }

    private static Bundle b(k kVar) {
        AppMethodBeat.i(73905);
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", kVar.errCode);
        bundle.putString("err_msg", kVar.aIm);
        bundle.putByte("use_mode", kVar.rOj);
        bundle.putString("result_json", kVar.cLO);
        bundle.putString("result_json_signature", kVar.rOk);
        ab.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", bundle.toString());
        AppMethodBeat.o(73905);
        return bundle;
    }

    private void c(k kVar) {
        AppMethodBeat.i(73906);
        if (kVar == null) {
            AppMethodBeat.o(73906);
            return;
        }
        if (this.fromScene == 1) {
            com.tencent.mm.plugin.soter.d.i.ai(this.appId, kVar.errCode, zS(kVar.errCode));
        }
        AppMethodBeat.o(73906);
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
        AppMethodBeat.i(73907);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.rOr != null) {
            this.rOr.onRequestPermissionsResult(i, strArr, iArr);
        }
        AppMethodBeat.o(73907);
    }

    public void onDestroy() {
        AppMethodBeat.i(73908);
        super.onDestroy();
        if (this.kvA != null && this.kvA.isShowing()) {
            ab.i("MicroMsg.SoterAuthenticationUI", "onDestroy mProgressDialog dismiss!");
            this.kvA.dismiss();
        }
        if (rNO != null && rNO.isShowing()) {
            ab.i("MicroMsg.SoterAuthenticationUI", "onDestroy mAuthenDialog dismiss!");
            rNO.dismiss();
        }
        a.a(rOu);
        if (this.rOs) {
            f.dRn().dRo();
            com.tencent.soter.a.c.a dRe = com.tencent.soter.a.c.a.dRe();
            synchronized (com.tencent.soter.a.c.a.class) {
                try {
                    dRe.bZi = false;
                    dRe.cul = false;
                    dRe.AvO = new SparseArray(10);
                    dRe.AvP = null;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(73908);
                }
            }
            return;
        }
        AppMethodBeat.o(73908);
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI, k kVar) {
        AppMethodBeat.i(73910);
        kVar.errCode = 90008;
        kVar.aIm = "user cancelled the authentication process";
        soterAuthenticationUI.JF.send(0, b(kVar));
        soterAuthenticationUI.c(kVar);
        soterAuthenticationUI.finish();
        AppMethodBeat.o(73910);
    }
}
