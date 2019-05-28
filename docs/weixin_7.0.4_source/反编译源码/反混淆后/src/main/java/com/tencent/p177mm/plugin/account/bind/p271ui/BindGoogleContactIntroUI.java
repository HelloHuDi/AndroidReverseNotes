package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C32968w;
import com.tencent.p177mm.plugin.account.friend.p272a.C32968w.C1993a;
import com.tencent.p177mm.plugin.account.friend.p272a.C38035m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.TXLiveConstants;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI */
public class BindGoogleContactIntroUI extends MMActivity implements C1202f {
    private ImageView gqh;
    private TextView gqi;
    private Button gqj;
    private Button gqk;
    private boolean gql = false;
    private boolean gqm = false;
    private String gqn;
    private ProgressDialog gqo;
    private C32968w gqp;
    private int gqq;
    private OnClickListener gqr = new C329351();
    private OnClickListener gqs = new C329312();

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI$4 */
    class C19664 implements OnCancelListener {
        C19664() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(13336);
            C1720g.m3540Rg().mo14547c(BindGoogleContactIntroUI.this.gqp);
            AppMethodBeat.m2505o(13336);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI$2 */
    class C329312 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI$2$1 */
        class C329321 implements DialogInterface.OnClickListener {
            C329321() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13333);
                BindGoogleContactIntroUI.m53869b(BindGoogleContactIntroUI.this);
                AppMethodBeat.m2505o(13333);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI$2$2 */
        class C329332 implements DialogInterface.OnClickListener {
            C329332() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C329312() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13334);
            C30379h.m48453a(BindGoogleContactIntroUI.this.mController.ylL, true, BindGoogleContactIntroUI.this.getString(C25738R.string.ey7), "", BindGoogleContactIntroUI.this.getString(C25738R.string.ey6), BindGoogleContactIntroUI.this.getString(C25738R.string.f9076or), new C329321(), new C329332());
            AppMethodBeat.m2505o(13334);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI$3 */
    class C329343 implements OnMenuItemClickListener {
        C329343() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13335);
            BindGoogleContactIntroUI.this.finish();
            AppMethodBeat.m2505o(13335);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI$1 */
    class C329351 implements OnClickListener {
        C329351() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13332);
            Intent intent = new Intent(BindGoogleContactIntroUI.this, BindGoogleContactUI.class);
            intent.putExtra("enter_scene", BindGoogleContactIntroUI.this.gqq);
            BindGoogleContactIntroUI.this.startActivity(intent);
            AppMethodBeat.m2505o(13332);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BindGoogleContactIntroUI() {
        AppMethodBeat.m2504i(13337);
        AppMethodBeat.m2505o(13337);
    }

    public final int getLayoutId() {
        return 2130968839;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13338);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.a61);
        this.gqq = getIntent().getIntExtra("enter_scene", 0);
        this.gql = C38035m.m64353cx(this);
        if (this.gql) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
        }
        AppMethodBeat.m2505o(13338);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13339);
        super.onResume();
        this.gqn = (String) C1720g.m3536RP().mo5239Ry().get(208903, null);
        if (TextUtils.isEmpty(this.gqn)) {
            this.gqm = false;
        } else {
            this.gqm = true;
        }
        initView();
        if (this.gqm) {
            this.gqk.setVisibility(0);
            this.gqj.setVisibility(8);
            this.gqi.setVisibility(0);
            this.gqi.setText(getString(C25738R.string.a5z, new Object[]{this.gqn}));
            this.gqk.setOnClickListener(this.gqs);
        } else {
            aoP();
        }
        C1720g.m3540Rg().mo14539a(487, (C1202f) this);
        AppMethodBeat.m2505o(13339);
    }

    public void onStop() {
        AppMethodBeat.m2504i(13340);
        super.onStop();
        C1720g.m3540Rg().mo14546b(487, (C1202f) this);
        AppMethodBeat.m2505o(13340);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13341);
        super.onDestroy();
        AppMethodBeat.m2505o(13341);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13342);
        setBackBtn(new C329343());
        this.gqh = (ImageView) findViewById(2131821750);
        this.gqi = (TextView) findViewById(2131821751);
        this.gqj = (Button) findViewById(2131821752);
        this.gqk = (Button) findViewById(2131821753);
        AppMethodBeat.m2505o(13342);
    }

    private void aoP() {
        AppMethodBeat.m2504i(13343);
        this.gqk.setVisibility(8);
        this.gqj.setVisibility(0);
        this.gqh.setVisibility(0);
        this.gqi.setVisibility(0);
        this.gqi.setText(C25738R.string.a60);
        this.gqj.setText(C25738R.string.a5y);
        this.gqj.setOnClickListener(this.gqr);
        AppMethodBeat.m2505o(13343);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13344);
        C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
                this.gql = intent.getBooleanExtra("gpservices", false);
                AppMethodBeat.m2505o(13344);
                return;
            }
        } else if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
            this.gql = intent.getBooleanExtra("gpservices", false);
        }
        AppMethodBeat.m2505o(13344);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(13345);
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactIntroUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        C4990ab.m7417i(str2, str3, objArr);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        if (i == 0 && i2 == 0) {
            C1720g.m3536RP().mo5239Ry().set(208903, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(208901, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(208902, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(208905, Boolean.TRUE);
            C1720g.m3536RP().mo5239Ry().dsb();
            aoP();
            C30379h.m48465bQ(this, getString(C25738R.string.ey8));
            AppMethodBeat.m2505o(13345);
            return;
        }
        C4990ab.m7416i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
        Toast.makeText(this, C25738R.string.c8s, 0).show();
        AppMethodBeat.m2505o(13345);
    }

    /* renamed from: b */
    static /* synthetic */ void m53869b(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        AppMethodBeat.m2504i(13346);
        bindGoogleContactIntroUI.gqp = new C32968w(C1993a.MM_BIND_GCONTACT_OPCODE_UNBIND, bindGoogleContactIntroUI.gqn, C32968w.gvM);
        C1720g.m3540Rg().mo14541a(bindGoogleContactIntroUI.gqp, 0);
        bindGoogleContactIntroUI.getString(C25738R.string.f9238tz);
        bindGoogleContactIntroUI.gqo = C30379h.m48458b((Context) bindGoogleContactIntroUI, bindGoogleContactIntroUI.getString(C25738R.string.f9260un), true, new C19664());
        AppMethodBeat.m2505o(13346);
    }
}
