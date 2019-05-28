package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI extends MMActivity {
    private String chatroomName;
    private u eih;
    private Button ekL;
    private View ekM;
    private ImageView ekN;
    private TextView ekO;
    private TextView ekP;
    private TextView ekQ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(RoomUpgradeResultUI roomUpgradeResultUI) {
        AppMethodBeat.i(104233);
        roomUpgradeResultUI.goBack();
        AppMethodBeat.o(104233);
    }

    static /* synthetic */ void a(RoomUpgradeResultUI roomUpgradeResultUI, String str) {
        AppMethodBeat.i(104234);
        roomUpgradeResultUI.kl(str);
        AppMethodBeat.o(104234);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104224);
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("chatroom");
        ab.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", this.chatroomName);
        this.eih = ((c) g.K(c.class)).XV().oa(this.chatroomName);
        if (this.eih == null) {
            goBack();
        }
        initView();
        AppMethodBeat.o(104224);
    }

    public void onDestroy() {
        AppMethodBeat.i(104225);
        super.onDestroy();
        AppMethodBeat.o(104225);
    }

    public final void initView() {
        AppMethodBeat.i(104226);
        setMMTitle((int) R.string.dv4);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104220);
                RoomUpgradeResultUI.a(RoomUpgradeResultUI.this);
                AppMethodBeat.o(104220);
                return true;
            }
        });
        this.ekM = findViewById(R.id.al9);
        this.ekN = (ImageView) findViewById(R.id.al_);
        this.ekO = (TextView) findViewById(R.id.ala);
        this.ekP = (TextView) findViewById(R.id.alc);
        this.ekQ = (TextView) findViewById(R.id.ale);
        this.ekL = (Button) findViewById(R.id.alf);
        this.ekL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(104221);
                Intent intent = new Intent();
                String str = "rawUrl";
                intent.putExtra(str, RoomUpgradeResultUI.this.getString(R.string.ajo, new Object[]{aa.dor()}));
                intent.putExtra("geta8key_username", r.Yz());
                d.c(RoomUpgradeResultUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
                AppMethodBeat.o(104221);
            }
        });
        cu();
        AppMethodBeat.o(104226);
    }

    private void cu() {
        AppMethodBeat.i(104227);
        Kf();
        this.ekL.setText(R.string.dv7);
        this.ekQ.setVisibility(8);
        AppMethodBeat.o(104227);
    }

    private void Kf() {
        AppMethodBeat.i(104228);
        this.ekL.setVisibility(0);
        kk(this.eih.field_roomowner);
        int drW = this.eih.drW();
        this.ekP.setVisibility(0);
        this.ekP.setText(getString(R.string.dvb, new Object[]{Integer.valueOf(drW)}));
        AppMethodBeat.o(104228);
    }

    private void kk(final String str) {
        AppMethodBeat.i(104229);
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) > 0) {
            kl(str);
            AppMethodBeat.o(104229);
            return;
        }
        a.flu.a(str, this.chatroomName, new b.a() {
            public final void o(String str, boolean z) {
                AppMethodBeat.i(104223);
                if (z) {
                    RoomUpgradeResultUI.this.ekM.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(104222);
                            RoomUpgradeResultUI.a(RoomUpgradeResultUI.this, str);
                            AppMethodBeat.o(104222);
                        }
                    });
                }
                AppMethodBeat.o(104223);
            }
        });
        AppMethodBeat.o(104229);
    }

    private void kl(String str) {
        AppMethodBeat.i(104230);
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            AppMethodBeat.o(104230);
            return;
        }
        String Oi = aoO.Oi();
        com.tencent.mm.pluginsdk.ui.a.b.b(this.ekN, str);
        this.ekO.setVisibility(0);
        this.ekO.setText(Oi);
        AppMethodBeat.o(104230);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(104231);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(104231);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(104231);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(104232);
        Intent intent = new Intent(this, RoomUpgradeUI.class);
        intent.addFlags(67108864);
        intent.putExtra("finish_self", true);
        startActivity(intent);
        AppMethodBeat.o(104232);
    }

    public final int getLayoutId() {
        return R.layout.l1;
    }
}
