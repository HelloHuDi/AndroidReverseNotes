package com.tencent.p177mm.chatroom.p216ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;

@Deprecated
/* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeResultUI */
public class RoomUpgradeResultUI extends MMActivity {
    private String chatroomName;
    private C7577u eih;
    private Button ekL;
    private View ekM;
    private ImageView ekN;
    private TextView ekO;
    private TextView ekP;
    private TextView ekQ;

    /* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeResultUI$2 */
    class C13802 implements OnClickListener {
        C13802() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(104221);
            Intent intent = new Intent();
            String str = "rawUrl";
            intent.putExtra(str, RoomUpgradeResultUI.this.getString(C25738R.string.ajo, new Object[]{C4988aa.dor()}));
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            C25985d.m41471c(RoomUpgradeResultUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
            AppMethodBeat.m2505o(104221);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeResultUI$1 */
    class C181511 implements OnMenuItemClickListener {
        C181511() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104220);
            RoomUpgradeResultUI.m74048a(RoomUpgradeResultUI.this);
            AppMethodBeat.m2505o(104220);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m74048a(RoomUpgradeResultUI roomUpgradeResultUI) {
        AppMethodBeat.m2504i(104233);
        roomUpgradeResultUI.goBack();
        AppMethodBeat.m2505o(104233);
    }

    /* renamed from: a */
    static /* synthetic */ void m74049a(RoomUpgradeResultUI roomUpgradeResultUI, String str) {
        AppMethodBeat.m2504i(104234);
        roomUpgradeResultUI.m74053kl(str);
        AppMethodBeat.m2505o(104234);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104224);
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("chatroom");
        C4990ab.m7417i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", this.chatroomName);
        this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.chatroomName);
        if (this.eih == null) {
            goBack();
        }
        initView();
        AppMethodBeat.m2505o(104224);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104225);
        super.onDestroy();
        AppMethodBeat.m2505o(104225);
    }

    public final void initView() {
        AppMethodBeat.m2504i(104226);
        setMMTitle((int) C25738R.string.dv4);
        setBackBtn(new C181511());
        this.ekM = findViewById(2131822367);
        this.ekN = (ImageView) findViewById(2131822368);
        this.ekO = (TextView) findViewById(2131822369);
        this.ekP = (TextView) findViewById(2131822371);
        this.ekQ = (TextView) findViewById(2131822373);
        this.ekL = (Button) findViewById(2131822374);
        this.ekL.setOnClickListener(new C13802());
        m74051cu();
        AppMethodBeat.m2505o(104226);
    }

    /* renamed from: cu */
    private void m74051cu() {
        AppMethodBeat.m2504i(104227);
        m74047Kf();
        this.ekL.setText(C25738R.string.dv7);
        this.ekQ.setVisibility(8);
        AppMethodBeat.m2505o(104227);
    }

    /* renamed from: Kf */
    private void m74047Kf() {
        AppMethodBeat.m2504i(104228);
        this.ekL.setVisibility(0);
        m74052kk(this.eih.field_roomowner);
        int drW = this.eih.drW();
        this.ekP.setVisibility(0);
        this.ekP.setText(getString(C25738R.string.dvb, new Object[]{Integer.valueOf(drW)}));
        AppMethodBeat.m2505o(104228);
    }

    /* renamed from: kk */
    private void m74052kk(final String str) {
        AppMethodBeat.m2504i(104229);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) > 0) {
            m74053kl(str);
            AppMethodBeat.m2505o(104229);
            return;
        }
        C26417a.flu.mo20966a(str, this.chatroomName, new C9636a() {

            /* renamed from: com.tencent.mm.chatroom.ui.RoomUpgradeResultUI$3$1 */
            class C324561 implements Runnable {
                C324561() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(104222);
                    RoomUpgradeResultUI.m74049a(RoomUpgradeResultUI.this, str);
                    AppMethodBeat.m2505o(104222);
                }
            }

            /* renamed from: o */
            public final void mo6218o(String str, boolean z) {
                AppMethodBeat.m2504i(104223);
                if (z) {
                    RoomUpgradeResultUI.this.ekM.post(new C324561());
                }
                AppMethodBeat.m2505o(104223);
            }
        });
        AppMethodBeat.m2505o(104229);
    }

    /* renamed from: kl */
    private void m74053kl(String str) {
        AppMethodBeat.m2504i(104230);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            AppMethodBeat.m2505o(104230);
            return;
        }
        String Oi = aoO.mo16706Oi();
        C40460b.m69434b(this.ekN, str);
        this.ekO.setVisibility(0);
        this.ekO.setText(Oi);
        AppMethodBeat.m2505o(104230);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(104231);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(104231);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(104231);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(104232);
        Intent intent = new Intent(this, RoomUpgradeUI.class);
        intent.addFlags(67108864);
        intent.putExtra("finish_self", true);
        startActivity(intent);
        AppMethodBeat.m2505o(104232);
    }

    public final int getLayoutId() {
        return 2130969010;
    }
}
