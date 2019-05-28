package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI extends MMActivity {
    private String elr;
    private String igi;
    private int lqz;
    private int mType;
    private String nER;
    private String vgT;
    private b vgU;

    interface b {
        void aE(Intent intent);

        String diT();

        int diU();

        String diV();

        String diW();

        void f(int i, int i2, Intent intent);

        void fP(Context context);
    }

    class a implements b {
        private a() {
        }

        /* synthetic */ a(BioHelperUI bioHelperUI, byte b) {
            this();
        }

        public final void aE(Intent intent) {
        }

        public final String diT() {
            AppMethodBeat.i(125670);
            String string = BioHelperUI.this.getString(R.string.a90);
            AppMethodBeat.o(125670);
            return string;
        }

        public final int diU() {
            return R.drawable.b35;
        }

        public final String diV() {
            AppMethodBeat.i(125671);
            String string = BioHelperUI.this.getString(R.string.a91);
            AppMethodBeat.o(125671);
            return string;
        }

        public final String diW() {
            AppMethodBeat.i(125672);
            String string = BioHelperUI.this.getString(R.string.a8y);
            AppMethodBeat.o(125672);
            return string;
        }

        public final void fP(Context context) {
            AppMethodBeat.i(125673);
            Intent intent = new Intent();
            intent.putExtra("k_user_name", BioHelperUI.this.igi);
            intent.putExtra("k_purpose", 2);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_ticket", BioHelperUI.this.elr);
            d.b(BioHelperUI.this.mController.ylL, "facedetect", ".ui.FaceDetectUI", intent, 1025);
            AppMethodBeat.o(125673);
        }

        public final void f(int i, int i2, Intent intent) {
            int i3 = 0;
            AppMethodBeat.i(125674);
            if (i2 == 2 && intent != null) {
                BioHelperUI.this.finish();
                String stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                String str = "MicroMsg.BioHelperUI";
                String str2 = "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bo.isNullOrNil(stringExtra));
                if (!bo.isNullOrNil(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                ab.i(str, str2, objArr);
            }
            AppMethodBeat.o(125674);
        }
    }

    class c implements b {
        private int gOW;

        private c() {
        }

        /* synthetic */ c(BioHelperUI bioHelperUI, byte b) {
            this();
        }

        public final void aE(Intent intent) {
            AppMethodBeat.i(125675);
            if (intent == null) {
                AppMethodBeat.o(125675);
                return;
            }
            this.gOW = intent.getIntExtra("kscene_type", 73);
            AppMethodBeat.o(125675);
        }

        public final String diT() {
            AppMethodBeat.i(125676);
            String string = BioHelperUI.this.getString(R.string.a94);
            AppMethodBeat.o(125676);
            return string;
        }

        public final int diU() {
            return R.drawable.au8;
        }

        public final String diV() {
            AppMethodBeat.i(125677);
            String string = BioHelperUI.this.getString(R.string.a93);
            AppMethodBeat.o(125677);
            return string;
        }

        public final String diW() {
            AppMethodBeat.i(125678);
            String string = BioHelperUI.this.getString(R.string.a8z);
            AppMethodBeat.o(125678);
            return string;
        }

        public final void fP(Context context) {
            AppMethodBeat.i(125679);
            Intent intent = new Intent();
            intent.putExtra("kscene_type", this.gOW);
            intent.putExtra("Kusername", BioHelperUI.this.igi);
            intent.putExtra("Kvertify_key", BioHelperUI.this.elr);
            d.b(context, "voiceprint", ".ui.VoiceLoginUI", intent, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.o(125679);
        }

        public final void f(int i, int i2, Intent intent) {
            int i3 = 0;
            AppMethodBeat.i(125680);
            if (i2 == -1) {
                if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                    String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                    String str = "MicroMsg.BioHelperUI";
                    String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(bo.isNullOrNil(stringExtra));
                    if (!bo.isNullOrNil(stringExtra)) {
                        i3 = stringExtra.length();
                    }
                    objArr[1] = Integer.valueOf(i3);
                    ab.d(str, str2, objArr);
                    Intent intent2 = new Intent();
                    intent2.putExtra("VoiceLoginAuthPwd", stringExtra);
                    intent2.putExtra("KVoiceHelpCode", BioHelperUI.this.lqz);
                    BioHelperUI.this.setResult(-1, intent2);
                }
                BioHelperUI.this.finish();
            }
            AppMethodBeat.o(125680);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        b bVar = null;
        AppMethodBeat.i(125681);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("k_type", 1);
        ab.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", Integer.valueOf(this.mType));
        this.igi = bo.bc(getIntent().getStringExtra("Kusername"), null);
        this.elr = bo.bc(getIntent().getStringExtra("Kvertify_key"), null);
        this.vgT = bo.bc(getIntent().getStringExtra("KVoiceHelpUrl"), null);
        this.nER = bo.bc(getIntent().getStringExtra("KVoiceHelpWording"), null);
        this.lqz = getIntent().getIntExtra("KVoiceHelpCode", 0);
        if (this.mType == 0) {
            bVar = new c(this, (byte) 0);
        } else if (this.mType == 1) {
            bVar = new a(this, (byte) 0);
        } else {
            ab.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        }
        this.vgU = bVar;
        if (this.vgU == null || bo.isNullOrNil(this.igi) || bo.isNullOrNil(this.elr)) {
            ab.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
            finish();
            AppMethodBeat.o(125681);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.a6m);
        if (bo.isNullOrNil(this.nER)) {
            textView.setText(this.vgU.diW());
        } else {
            textView.setText(this.nER);
        }
        setMMTitle(this.vgU.diT());
        ((ImageView) findViewById(R.id.a6l)).setImageResource(this.vgU.diU());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125667);
                BioHelperUI.this.finish();
                AppMethodBeat.o(125667);
                return true;
            }
        });
        this.vgU.aE(getIntent());
        Button button = (Button) findViewById(R.id.a6n);
        button.setText(this.vgU.diV());
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125668);
                BioHelperUI.this.vgU.fP(BioHelperUI.this);
                AppMethodBeat.o(125668);
            }
        });
        findViewById(R.id.a6o).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125669);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", new StringBuilder(BioHelperUI.this.vgT).toString());
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                d.b(BioHelperUI.this, "webview", ".ui.tools.WebViewUI", intent);
                BioHelperUI.this.finish();
                AppMethodBeat.o(125669);
            }
        });
        AppMethodBeat.o(125681);
    }

    public final int getLayoutId() {
        return R.layout.gp;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(125682);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.BioHelperUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        this.vgU.f(i, i2, intent);
        AppMethodBeat.o(125682);
    }
}
