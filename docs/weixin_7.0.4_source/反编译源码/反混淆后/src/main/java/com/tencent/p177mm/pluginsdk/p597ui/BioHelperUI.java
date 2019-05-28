package com.tencent.p177mm.pluginsdk.p597ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.ui.BioHelperUI */
public class BioHelperUI extends MMActivity {
    private String elr;
    private String igi;
    private int lqz;
    private int mType;
    private String nER;
    private String vgT;
    private C40449b vgU;

    /* renamed from: com.tencent.mm.pluginsdk.ui.BioHelperUI$2 */
    class C149012 implements OnClickListener {
        C149012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125668);
            BioHelperUI.this.vgU.mo63858fP(BioHelperUI.this);
            AppMethodBeat.m2505o(125668);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.BioHelperUI$1 */
    class C300941 implements OnMenuItemClickListener {
        C300941() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125667);
            BioHelperUI.this.finish();
            AppMethodBeat.m2505o(125667);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.BioHelperUI$3 */
    class C358093 implements OnClickListener {
        C358093() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125669);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", new StringBuilder(BioHelperUI.this.vgT).toString());
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
            C25985d.m41467b(BioHelperUI.this, "webview", ".ui.tools.WebViewUI", intent);
            BioHelperUI.this.finish();
            AppMethodBeat.m2505o(125669);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.BioHelperUI$b */
    interface C40449b {
        /* renamed from: aE */
        void mo63852aE(Intent intent);

        String diT();

        int diU();

        String diV();

        String diW();

        /* renamed from: f */
        void mo63857f(int i, int i2, Intent intent);

        /* renamed from: fP */
        void mo63858fP(Context context);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.BioHelperUI$a */
    class C40450a implements C40449b {
        private C40450a() {
        }

        /* synthetic */ C40450a(BioHelperUI bioHelperUI, byte b) {
            this();
        }

        /* renamed from: aE */
        public final void mo63852aE(Intent intent) {
        }

        public final String diT() {
            AppMethodBeat.m2504i(125670);
            String string = BioHelperUI.this.getString(C25738R.string.a90);
            AppMethodBeat.m2505o(125670);
            return string;
        }

        public final int diU() {
            return C25738R.drawable.b35;
        }

        public final String diV() {
            AppMethodBeat.m2504i(125671);
            String string = BioHelperUI.this.getString(C25738R.string.a91);
            AppMethodBeat.m2505o(125671);
            return string;
        }

        public final String diW() {
            AppMethodBeat.m2504i(125672);
            String string = BioHelperUI.this.getString(C25738R.string.a8y);
            AppMethodBeat.m2505o(125672);
            return string;
        }

        /* renamed from: fP */
        public final void mo63858fP(Context context) {
            AppMethodBeat.m2504i(125673);
            Intent intent = new Intent();
            intent.putExtra("k_user_name", BioHelperUI.this.igi);
            intent.putExtra("k_purpose", 2);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_ticket", BioHelperUI.this.elr);
            C25985d.m41468b(BioHelperUI.this.mController.ylL, "facedetect", ".ui.FaceDetectUI", intent, 1025);
            AppMethodBeat.m2505o(125673);
        }

        /* renamed from: f */
        public final void mo63857f(int i, int i2, Intent intent) {
            int i3 = 0;
            AppMethodBeat.m2504i(125674);
            if (i2 == 2 && intent != null) {
                BioHelperUI.this.finish();
                String stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                String str = "MicroMsg.BioHelperUI";
                String str2 = "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(C5046bo.isNullOrNil(stringExtra));
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                C4990ab.m7417i(str, str2, objArr);
            }
            AppMethodBeat.m2505o(125674);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.BioHelperUI$c */
    class C40451c implements C40449b {
        private int gOW;

        private C40451c() {
        }

        /* synthetic */ C40451c(BioHelperUI bioHelperUI, byte b) {
            this();
        }

        /* renamed from: aE */
        public final void mo63852aE(Intent intent) {
            AppMethodBeat.m2504i(125675);
            if (intent == null) {
                AppMethodBeat.m2505o(125675);
                return;
            }
            this.gOW = intent.getIntExtra("kscene_type", 73);
            AppMethodBeat.m2505o(125675);
        }

        public final String diT() {
            AppMethodBeat.m2504i(125676);
            String string = BioHelperUI.this.getString(C25738R.string.a94);
            AppMethodBeat.m2505o(125676);
            return string;
        }

        public final int diU() {
            return C25738R.drawable.au8;
        }

        public final String diV() {
            AppMethodBeat.m2504i(125677);
            String string = BioHelperUI.this.getString(C25738R.string.a93);
            AppMethodBeat.m2505o(125677);
            return string;
        }

        public final String diW() {
            AppMethodBeat.m2504i(125678);
            String string = BioHelperUI.this.getString(C25738R.string.a8z);
            AppMethodBeat.m2505o(125678);
            return string;
        }

        /* renamed from: fP */
        public final void mo63858fP(Context context) {
            AppMethodBeat.m2504i(125679);
            Intent intent = new Intent();
            intent.putExtra("kscene_type", this.gOW);
            intent.putExtra("Kusername", BioHelperUI.this.igi);
            intent.putExtra("Kvertify_key", BioHelperUI.this.elr);
            C25985d.m41468b(context, "voiceprint", ".ui.VoiceLoginUI", intent, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(125679);
        }

        /* renamed from: f */
        public final void mo63857f(int i, int i2, Intent intent) {
            int i3 = 0;
            AppMethodBeat.m2504i(125680);
            if (i2 == -1) {
                if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                    String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                    String str = "MicroMsg.BioHelperUI";
                    String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(C5046bo.isNullOrNil(stringExtra));
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        i3 = stringExtra.length();
                    }
                    objArr[1] = Integer.valueOf(i3);
                    C4990ab.m7411d(str, str2, objArr);
                    Intent intent2 = new Intent();
                    intent2.putExtra("VoiceLoginAuthPwd", stringExtra);
                    intent2.putExtra("KVoiceHelpCode", BioHelperUI.this.lqz);
                    BioHelperUI.this.setResult(-1, intent2);
                }
                BioHelperUI.this.finish();
            }
            AppMethodBeat.m2505o(125680);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        C40449b c40449b = null;
        AppMethodBeat.m2504i(125681);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("k_type", 1);
        C4990ab.m7417i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", Integer.valueOf(this.mType));
        this.igi = C5046bo.m7532bc(getIntent().getStringExtra("Kusername"), null);
        this.elr = C5046bo.m7532bc(getIntent().getStringExtra("Kvertify_key"), null);
        this.vgT = C5046bo.m7532bc(getIntent().getStringExtra("KVoiceHelpUrl"), null);
        this.nER = C5046bo.m7532bc(getIntent().getStringExtra("KVoiceHelpWording"), null);
        this.lqz = getIntent().getIntExtra("KVoiceHelpCode", 0);
        if (this.mType == 0) {
            c40449b = new C40451c(this, (byte) 0);
        } else if (this.mType == 1) {
            c40449b = new C40450a(this, (byte) 0);
        } else {
            C4990ab.m7412e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        }
        this.vgU = c40449b;
        if (this.vgU == null || C5046bo.isNullOrNil(this.igi) || C5046bo.isNullOrNil(this.elr)) {
            C4990ab.m7420w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
            finish();
            AppMethodBeat.m2505o(125681);
            return;
        }
        TextView textView = (TextView) findViewById(2131821789);
        if (C5046bo.isNullOrNil(this.nER)) {
            textView.setText(this.vgU.diW());
        } else {
            textView.setText(this.nER);
        }
        setMMTitle(this.vgU.diT());
        ((ImageView) findViewById(2131821788)).setImageResource(this.vgU.diU());
        setBackBtn(new C300941());
        this.vgU.mo63852aE(getIntent());
        Button button = (Button) findViewById(2131821790);
        button.setText(this.vgU.diV());
        button.setOnClickListener(new C149012());
        findViewById(2131821791).setOnClickListener(new C358093());
        AppMethodBeat.m2505o(125681);
    }

    public final int getLayoutId() {
        return 2130968850;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.m2504i(125682);
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
        C4990ab.m7417i(str, str2, objArr);
        this.vgU.mo63857f(i, i2, intent);
        AppMethodBeat.m2505o(125682);
    }
}
