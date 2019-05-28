package com.tencent.p177mm.chatroom.p216ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p710c.C6401j;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C19403g;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeUI */
public class RoomUpgradeUI extends MMActivity implements C1202f {
    private String chatroomName;
    private ProgressDialog ehJ = null;
    private int ehs;
    private int eht;
    private C7577u eih;
    private View ekM;
    private ImageView ekN;
    private TextView ekO;
    private TextView ekP;
    private TextView ekQ;
    private TextView ekU;
    private View ekV;
    private TextView ekW;
    private C6401j ekX;
    private String ekY;
    private boolean ekZ;
    private boolean ela;
    private int status;

    /* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeUI$6 */
    class C92256 implements OnClickListener {
        C92256() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(104241);
            RoomUpgradeUI.this.finish();
            AppMethodBeat.m2505o(104241);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeUI$1 */
    class C181521 implements OnMenuItemClickListener {
        C181521() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104235);
            RoomUpgradeUI.this.finish();
            AppMethodBeat.m2505o(104235);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeUI$2 */
    class C376452 implements View.OnClickListener {
        C376452() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(104236);
            switch (RoomUpgradeUI.this.status) {
                case 1:
                    if (RoomUpgradeUI.this.ela) {
                        C26041b.m41590a(RoomUpgradeUI.this, RoomUpgradeUI.this.chatroomName, true);
                        AppMethodBeat.m2505o(104236);
                        return;
                    }
                    RoomUpgradeUI.m63603a(RoomUpgradeUI.this, true);
                    AppMethodBeat.m2505o(104236);
                    return;
                case 2:
                case 5:
                    if (!RoomUpgradeUI.this.ela) {
                        RoomUpgradeUI.m63603a(RoomUpgradeUI.this, false);
                        break;
                    }
                    RoomUpgradeUI.m63607d(RoomUpgradeUI.this);
                    AppMethodBeat.m2505o(104236);
                    return;
            }
            AppMethodBeat.m2505o(104236);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeUI$3 */
    class C376463 implements View.OnClickListener {
        C376463() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(104237);
            if (RoomUpgradeUI.this.ekU.getVisibility() == 0) {
                Intent intent = new Intent();
                RoomUpgradeUI.this.ekY = RoomUpgradeUI.this.getString(C25738R.string.ajo, new Object[]{C4988aa.dor()});
                intent.putExtra("rawUrl", RoomUpgradeUI.this.ekY);
                intent.putExtra("geta8key_username", C1853r.m3846Yz());
                intent.putExtra("showShare", false);
                C25985d.m41468b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 500);
            }
            AppMethodBeat.m2505o(104237);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeUI$5 */
    class C376475 implements OnCancelListener {
        C376475() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(104240);
            if (RoomUpgradeUI.this.ekX != null) {
                C1720g.m3535RO().eJo.mo14547c(RoomUpgradeUI.this.ekX);
                RoomUpgradeUI.this.ekX = null;
            }
            RoomUpgradeUI.this.finish();
            AppMethodBeat.m2505o(104240);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m63604b(RoomUpgradeUI roomUpgradeUI, String str) {
        AppMethodBeat.m2504i(104260);
        roomUpgradeUI.m63615kl(str);
        AppMethodBeat.m2505o(104260);
    }

    /* renamed from: d */
    static /* synthetic */ void m63607d(RoomUpgradeUI roomUpgradeUI) {
        AppMethodBeat.m2504i(104259);
        roomUpgradeUI.m63597Kg();
        AppMethodBeat.m2505o(104259);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104242);
        super.onCreate(bundle);
        m63598Kh();
        initView();
        AppMethodBeat.m2505o(104242);
    }

    /* renamed from: Kg */
    private void m63597Kg() {
        AppMethodBeat.m2504i(104244);
        Intent intent = new Intent(this, RoomAlphaProcessUI.class);
        intent.addFlags(67108864);
        intent.addFlags(65536);
        intent.putExtra("RoomInfo_Id", this.chatroomName);
        startActivity(intent);
        AppMethodBeat.m2505o(104244);
    }

    /* renamed from: Kh */
    private void m63598Kh() {
        AppMethodBeat.m2504i(104245);
        this.chatroomName = getIntent().getStringExtra("room_name");
        C4990ab.m7417i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", this.chatroomName);
        C1720g.m3535RO().eJo.mo14539a((int) C19403g.CTRL_INDEX, (C1202f) this);
        this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.chatroomName);
        if (this.eih == null) {
            finish();
            AppMethodBeat.m2505o(104245);
            return;
        }
        boolean z;
        this.ekZ = C1853r.m3846Yz().equals(this.eih.field_roomowner);
        if (C4988aa.doo()) {
            z = false;
        } else {
            z = true;
        }
        this.ela = z;
        AppMethodBeat.m2505o(104245);
    }

    public final void initView() {
        AppMethodBeat.m2504i(104246);
        setMMTitle((int) C25738R.string.dv4);
        setBackBtn(new C181521());
        this.ekM = findViewById(2131822367);
        this.ekV = findViewById(2131822370);
        this.ekN = (ImageView) findViewById(2131822368);
        this.ekO = (TextView) findViewById(2131822369);
        this.ekP = (TextView) findViewById(2131822371);
        this.ekQ = (TextView) findViewById(2131822373);
        this.ekW = (TextView) findViewById(2131822372);
        this.ekW.setOnClickListener(new C376452());
        this.ekU = (TextView) findViewById(2131822374);
        this.ekU.setOnClickListener(new C376463());
        if (this.ekZ) {
            m63600Kj();
        } else {
            m63599Ki();
        }
        if (this.ela) {
            this.ekU.setVisibility(8);
        }
        AppMethodBeat.m2505o(104246);
    }

    public void onResume() {
        AppMethodBeat.m2504i(104247);
        super.onResume();
        AppMethodBeat.m2505o(104247);
    }

    public void onPause() {
        AppMethodBeat.m2504i(104248);
        super.onPause();
        AppMethodBeat.m2505o(104248);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104249);
        C1720g.m3535RO().eJo.mo14547c(this.ekX);
        C1720g.m3535RO().eJo.mo14546b((int) C19403g.CTRL_INDEX, (C1202f) this);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(104249);
    }

    /* renamed from: Ki */
    private void m63599Ki() {
        AppMethodBeat.m2504i(104250);
        m63596Kf();
        if (!this.ela) {
            this.ekU.setVisibility(0);
        }
        this.ekU.setText(C25738R.string.dv7);
        this.ekW.setVisibility(8);
        this.ekQ.setVisibility(8);
        AppMethodBeat.m2505o(104250);
    }

    /* renamed from: Kf */
    private void m63596Kf() {
        AppMethodBeat.m2504i(104251);
        m63614kk(this.eih.field_roomowner);
        int drW = this.eih.drW();
        this.ekP.setVisibility(0);
        if (drW <= 40) {
            this.ekP.setText(getString(C25738R.string.dvb, new Object[]{getString(C25738R.string.dv6)}));
            AppMethodBeat.m2505o(104251);
            return;
        }
        this.ekP.setText(getString(C25738R.string.dvb, new Object[]{getString(C25738R.string.dv5)}));
        AppMethodBeat.m2505o(104251);
    }

    /* renamed from: kk */
    private void m63614kk(final String str) {
        AppMethodBeat.m2504i(104252);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) > 0) {
            m63615kl(str);
            AppMethodBeat.m2505o(104252);
            return;
        }
        C26417a.flu.mo20966a(str, this.chatroomName, new C9636a() {

            /* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeUI$4$1 */
            class C376441 implements Runnable {
                C376441() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(104238);
                    RoomUpgradeUI.m63604b(RoomUpgradeUI.this, str);
                    AppMethodBeat.m2505o(104238);
                }
            }

            /* renamed from: o */
            public final void mo6218o(String str, boolean z) {
                AppMethodBeat.m2504i(104239);
                if (z) {
                    RoomUpgradeUI.this.ekM.post(new C376441());
                }
                AppMethodBeat.m2505o(104239);
            }
        });
        AppMethodBeat.m2505o(104252);
    }

    /* renamed from: kl */
    private void m63615kl(String str) {
        CharSequence charSequence;
        AppMethodBeat.m2504i(104253);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            Object charSequence2 = null;
        } else {
            charSequence2 = aoO.field_conRemark;
        }
        if (C5046bo.isNullOrNil(charSequence2)) {
            charSequence2 = m63613kg(str);
        }
        if (C5046bo.isNullOrNil(charSequence2) && aoO != null && ((int) aoO.ewQ) > 0) {
            charSequence2 = aoO.mo16706Oi();
        }
        if (C5046bo.isNullOrNil(charSequence2)) {
            charSequence2 = str;
        }
        C40460b.m69434b(this.ekN, str);
        this.ekO.setVisibility(0);
        this.ekO.setText(C44089j.m79294b((Context) this, charSequence2, (int) this.ekO.getTextSize()));
        AppMethodBeat.m2505o(104253);
    }

    /* renamed from: kg */
    private String m63613kg(String str) {
        AppMethodBeat.m2504i(104254);
        if (this.eih == null) {
            AppMethodBeat.m2505o(104254);
            return null;
        }
        String mJ = this.eih.mo16807mJ(str);
        AppMethodBeat.m2505o(104254);
        return mJ;
    }

    public final int getLayoutId() {
        return 2130969010;
    }

    /* renamed from: Kj */
    private void m63600Kj() {
        AppMethodBeat.m2504i(104255);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.cn5), true, new C376475());
        this.ekX = new C6401j(this.chatroomName);
        C1720g.m3535RO().eJo.mo14541a(this.ekX, 0);
        AppMethodBeat.m2505o(104255);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(104256);
        C4990ab.m7410d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        switch (i) {
            case 400:
                finish();
                AppMethodBeat.m2505o(104256);
                return;
            default:
                C4990ab.m7412e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
                AppMethodBeat.m2505o(104256);
                return;
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(104257);
        C4990ab.m7410d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0 && c1207m.getType() == C19403g.CTRL_INDEX) {
                C6401j c6401j = (C6401j) c1207m;
                this.status = c6401j.status;
                this.ehs = c6401j.ehs;
                this.eht = c6401j.eht;
                m63596Kf();
                this.ekQ.setVisibility(0);
                this.ekW.setText(getString(C25738R.string.dv3));
                if (this.eht > 0) {
                    this.ekQ.setText(getString(C25738R.string.dv_, new Object[]{Integer.valueOf(this.eht)}));
                } else {
                    this.ekQ.setText(getString(C25738R.string.dva));
                }
                if (!this.ela) {
                    this.ekU.setVisibility(0);
                }
                switch (this.status) {
                    case 1:
                    case 2:
                    case 5:
                        this.ekW.setVisibility(0);
                        this.ekU.setText(C25738R.string.dv8);
                        AppMethodBeat.m2505o(104257);
                        return;
                    case 3:
                    case 4:
                    case 6:
                        this.ekW.setVisibility(0);
                        this.ekW.setEnabled(false);
                        this.ekU.setText(C25738R.string.dv8);
                        AppMethodBeat.m2505o(104257);
                        return;
                    case 7:
                        this.ekW.setVisibility(8);
                        this.ekU.setText(C25738R.string.dv7);
                        this.ekW.setEnabled(false);
                        break;
                }
            }
            AppMethodBeat.m2505o(104257);
            return;
        }
        C30379h.m48448a((Context) this, getString(C25738R.string.dv9), getString(C25738R.string.f9238tz), false, new C92256());
        AppMethodBeat.m2505o(104257);
    }

    public void onNewIntent(Intent intent) {
        boolean booleanExtra;
        AppMethodBeat.m2504i(104243);
        if (intent.hasExtra("upgrade_success")) {
            booleanExtra = intent.getBooleanExtra("upgrade_success", false);
        } else {
            if (intent.hasExtra("wizard_activity_result_code") && intent.getIntExtra("wizard_activity_result_code", -1) == -1) {
                m63597Kg();
            }
            if (intent.hasExtra("announce_ok")) {
                m63597Kg();
            }
            booleanExtra = false;
        }
        if (booleanExtra) {
            m63598Kh();
            int intExtra = intent.getIntExtra("left_quota", 0);
            m63596Kf();
            this.ekW.setVisibility(8);
            this.eht = intExtra;
            if (this.eht > 0) {
                this.ekQ.setText(getString(C25738R.string.dv_, new Object[]{Integer.valueOf(this.eht)}));
            } else {
                this.ekQ.setText(getString(C25738R.string.dva));
            }
            if (!this.ela) {
                this.ekU.setVisibility(0);
            }
            this.ekU.setText(C25738R.string.dv7);
            AppMethodBeat.m2505o(104243);
            return;
        }
        AppMethodBeat.m2505o(104243);
    }
}
