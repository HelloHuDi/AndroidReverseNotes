package com.tencent.p177mm.plugin.account.p275ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C38037x;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI */
public class RegByMobileVoiceVerifyUI extends MMActivity implements C1202f {
    private String cFl;
    private TextView exj;
    private String gBC;
    private String gGN;
    private C32815a gGP;
    private C38037x gGQ;
    private int gGR = 0;
    private String gsF;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI$2 */
    class C189232 implements OnClickListener {
        C189232() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125462);
            RegByMobileVoiceVerifyUI.this.startActivityForResult(new Intent(RegByMobileVoiceVerifyUI.this, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", RegByMobileVoiceVerifyUI.this.gGN), Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(125462);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI$3 */
    class C266403 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI$3$1 */
        class C266391 implements DialogInterface.OnClickListener {
            C266391() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(125463);
                RegByMobileVoiceVerifyUI.this.finish();
                AppMethodBeat.m2505o(125463);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI$3$2 */
        class C266412 implements DialogInterface.OnClickListener {
            C266412() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(125464);
                RegByMobileVoiceVerifyUI.this.finish();
                AppMethodBeat.m2505o(125464);
            }
        }

        C266403() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125465);
            if (RegByMobileVoiceVerifyUI.this.gGR == 0 || RegByMobileVoiceVerifyUI.this.gGR == 2 || RegByMobileVoiceVerifyUI.this.gGR == 3) {
                RegByMobileVoiceVerifyUI.this.gGP = new C32815a(RegByMobileVoiceVerifyUI.this.cFl, RegByMobileVoiceVerifyUI.m74816d(RegByMobileVoiceVerifyUI.this), "", 1, RegByMobileVoiceVerifyUI.this.gGN);
                C1720g.m3540Rg().mo14541a(RegByMobileVoiceVerifyUI.this.gGP, 0);
                C30379h.m48431a(RegByMobileVoiceVerifyUI.this, (int) C25738R.string.a85, (int) C25738R.string.f9238tz, new C266391());
                AppMethodBeat.m2505o(125465);
                return;
            }
            if (RegByMobileVoiceVerifyUI.this.gGR == 4 || RegByMobileVoiceVerifyUI.this.gGR == 1) {
                RegByMobileVoiceVerifyUI.this.gGQ = new C38037x(RegByMobileVoiceVerifyUI.this.cFl, 1, "", 1, RegByMobileVoiceVerifyUI.this.gGN);
                C1720g.m3540Rg().mo14541a(RegByMobileVoiceVerifyUI.this.gGQ, 0);
                C30379h.m48431a(RegByMobileVoiceVerifyUI.this, (int) C25738R.string.a85, (int) C25738R.string.f9238tz, new C266412());
            }
            AppMethodBeat.m2505o(125465);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI$1 */
    class C422991 implements OnMenuItemClickListener {
        C422991() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125461);
            RegByMobileVoiceVerifyUI.this.aqX();
            RegByMobileVoiceVerifyUI.this.finish();
            AppMethodBeat.m2505o(125461);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: d */
    static /* synthetic */ int m74816d(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        switch (regByMobileVoiceVerifyUI.gGR) {
            case 0:
                return 14;
            case 2:
                return 8;
            default:
                return 16;
        }
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125466);
        super.onCreate(bundle);
        this.cFl = getIntent().getExtras().getString("bindmcontact_mobile");
        this.gGR = getIntent().getExtras().getInt("voice_verify_type");
        if (this.gGR == 0 || this.gGR == 2 || this.gGR == 3) {
            C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        } else if (this.gGR == 4 || this.gGR == 1) {
            C1720g.m3540Rg().mo14539a(132, (C1202f) this);
        }
        this.gsF = C42756a.m75794FP();
        initView();
        AppMethodBeat.m2505o(125466);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125467);
        super.onResume();
        if (this.gGR == 0 || this.gGR == 2 || this.gGR == 3) {
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_500,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R200_500")).append(",1").toString());
            C42756a.m75798wz("R200_500");
        }
        AppMethodBeat.m2505o(125467);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125468);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(132, (C1202f) this);
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        if (this.gGR == 0 || this.gGR == 2 || this.gGR == 3) {
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_500,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R200_500")).append(",2").toString());
        }
        AppMethodBeat.m2505o(125468);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125469);
        if (i == 4) {
            C42756a.m75796wA(this.gsF);
            aqX();
            finish();
            AppMethodBeat.m2505o(125469);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125469);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.m2504i(125470);
        setMMTitle((int) C25738R.string.a88);
        setBackBtn(new C422991());
        this.exj = (TextView) findViewById(2131821776);
        Button button = (Button) findViewById(2131821777);
        this.gBC = RegByMobileVoiceVerifySelectUI.m81304wx(this.cFl);
        this.exj.setText(this.gBC);
        this.gGN = C17950b.m28215sN(this.cFl);
        findViewById(2131821775).setOnClickListener(new C189232());
        button.setOnClickListener(new C266403());
        AppMethodBeat.m2505o(125470);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(125471);
        super.onActivityResult(i, i2, intent);
        if (i == Downloads.MIN_WAIT_FOR_NETWORK) {
            if (intent == null) {
                AppMethodBeat.m2505o(125471);
                return;
            }
            this.gBC = intent.getStringExtra("voice_verify_language");
            this.gGN = intent.getStringExtra("voice_verify_code");
            this.exj.setText(this.gBC);
        }
        AppMethodBeat.m2505o(125471);
    }

    public final int getLayoutId() {
        return 2130968846;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125472);
        C4990ab.m7416i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.m2505o(125472);
    }
}
