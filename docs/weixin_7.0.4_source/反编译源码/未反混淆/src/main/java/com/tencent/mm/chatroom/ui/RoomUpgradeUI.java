package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.chatroom.c.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RoomUpgradeUI extends MMActivity implements f {
    private String chatroomName;
    private ProgressDialog ehJ = null;
    private int ehs;
    private int eht;
    private u eih;
    private View ekM;
    private ImageView ekN;
    private TextView ekO;
    private TextView ekP;
    private TextView ekQ;
    private TextView ekU;
    private View ekV;
    private TextView ekW;
    private j ekX;
    private String ekY;
    private boolean ekZ;
    private boolean ela;
    private int status;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(RoomUpgradeUI roomUpgradeUI, String str) {
        AppMethodBeat.i(104260);
        roomUpgradeUI.kl(str);
        AppMethodBeat.o(104260);
    }

    static /* synthetic */ void d(RoomUpgradeUI roomUpgradeUI) {
        AppMethodBeat.i(104259);
        roomUpgradeUI.Kg();
        AppMethodBeat.o(104259);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104242);
        super.onCreate(bundle);
        Kh();
        initView();
        AppMethodBeat.o(104242);
    }

    private void Kg() {
        AppMethodBeat.i(104244);
        Intent intent = new Intent(this, RoomAlphaProcessUI.class);
        intent.addFlags(67108864);
        intent.addFlags(65536);
        intent.putExtra("RoomInfo_Id", this.chatroomName);
        startActivity(intent);
        AppMethodBeat.o(104244);
    }

    private void Kh() {
        AppMethodBeat.i(104245);
        this.chatroomName = getIntent().getStringExtra("room_name");
        ab.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", this.chatroomName);
        g.RO().eJo.a((int) com.tencent.mm.plugin.appbrand.jsapi.j.g.CTRL_INDEX, (f) this);
        this.eih = ((c) g.K(c.class)).XV().oa(this.chatroomName);
        if (this.eih == null) {
            finish();
            AppMethodBeat.o(104245);
            return;
        }
        boolean z;
        this.ekZ = r.Yz().equals(this.eih.field_roomowner);
        if (aa.doo()) {
            z = false;
        } else {
            z = true;
        }
        this.ela = z;
        AppMethodBeat.o(104245);
    }

    public final void initView() {
        AppMethodBeat.i(104246);
        setMMTitle((int) R.string.dv4);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104235);
                RoomUpgradeUI.this.finish();
                AppMethodBeat.o(104235);
                return true;
            }
        });
        this.ekM = findViewById(R.id.al9);
        this.ekV = findViewById(R.id.alb);
        this.ekN = (ImageView) findViewById(R.id.al_);
        this.ekO = (TextView) findViewById(R.id.ala);
        this.ekP = (TextView) findViewById(R.id.alc);
        this.ekQ = (TextView) findViewById(R.id.ale);
        this.ekW = (TextView) findViewById(R.id.ald);
        this.ekW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(104236);
                switch (RoomUpgradeUI.this.status) {
                    case 1:
                        if (RoomUpgradeUI.this.ela) {
                            b.a(RoomUpgradeUI.this, RoomUpgradeUI.this.chatroomName, true);
                            AppMethodBeat.o(104236);
                            return;
                        }
                        RoomUpgradeUI.a(RoomUpgradeUI.this, true);
                        AppMethodBeat.o(104236);
                        return;
                    case 2:
                    case 5:
                        if (!RoomUpgradeUI.this.ela) {
                            RoomUpgradeUI.a(RoomUpgradeUI.this, false);
                            break;
                        }
                        RoomUpgradeUI.d(RoomUpgradeUI.this);
                        AppMethodBeat.o(104236);
                        return;
                }
                AppMethodBeat.o(104236);
            }
        });
        this.ekU = (TextView) findViewById(R.id.alf);
        this.ekU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(104237);
                if (RoomUpgradeUI.this.ekU.getVisibility() == 0) {
                    Intent intent = new Intent();
                    RoomUpgradeUI.this.ekY = RoomUpgradeUI.this.getString(R.string.ajo, new Object[]{aa.dor()});
                    intent.putExtra("rawUrl", RoomUpgradeUI.this.ekY);
                    intent.putExtra("geta8key_username", r.Yz());
                    intent.putExtra("showShare", false);
                    d.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 500);
                }
                AppMethodBeat.o(104237);
            }
        });
        if (this.ekZ) {
            Kj();
        } else {
            Ki();
        }
        if (this.ela) {
            this.ekU.setVisibility(8);
        }
        AppMethodBeat.o(104246);
    }

    public void onResume() {
        AppMethodBeat.i(104247);
        super.onResume();
        AppMethodBeat.o(104247);
    }

    public void onPause() {
        AppMethodBeat.i(104248);
        super.onPause();
        AppMethodBeat.o(104248);
    }

    public void onDestroy() {
        AppMethodBeat.i(104249);
        g.RO().eJo.c(this.ekX);
        g.RO().eJo.b((int) com.tencent.mm.plugin.appbrand.jsapi.j.g.CTRL_INDEX, (f) this);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.o(104249);
    }

    private void Ki() {
        AppMethodBeat.i(104250);
        Kf();
        if (!this.ela) {
            this.ekU.setVisibility(0);
        }
        this.ekU.setText(R.string.dv7);
        this.ekW.setVisibility(8);
        this.ekQ.setVisibility(8);
        AppMethodBeat.o(104250);
    }

    private void Kf() {
        AppMethodBeat.i(104251);
        kk(this.eih.field_roomowner);
        int drW = this.eih.drW();
        this.ekP.setVisibility(0);
        if (drW <= 40) {
            this.ekP.setText(getString(R.string.dvb, new Object[]{getString(R.string.dv6)}));
            AppMethodBeat.o(104251);
            return;
        }
        this.ekP.setText(getString(R.string.dvb, new Object[]{getString(R.string.dv5)}));
        AppMethodBeat.o(104251);
    }

    private void kk(final String str) {
        AppMethodBeat.i(104252);
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) > 0) {
            kl(str);
            AppMethodBeat.o(104252);
            return;
        }
        a.flu.a(str, this.chatroomName, new b.a() {
            public final void o(String str, boolean z) {
                AppMethodBeat.i(104239);
                if (z) {
                    RoomUpgradeUI.this.ekM.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(104238);
                            RoomUpgradeUI.b(RoomUpgradeUI.this, str);
                            AppMethodBeat.o(104238);
                        }
                    });
                }
                AppMethodBeat.o(104239);
            }
        });
        AppMethodBeat.o(104252);
    }

    private void kl(String str) {
        CharSequence charSequence;
        AppMethodBeat.i(104253);
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            Object charSequence2 = null;
        } else {
            charSequence2 = aoO.field_conRemark;
        }
        if (bo.isNullOrNil(charSequence2)) {
            charSequence2 = kg(str);
        }
        if (bo.isNullOrNil(charSequence2) && aoO != null && ((int) aoO.ewQ) > 0) {
            charSequence2 = aoO.Oi();
        }
        if (bo.isNullOrNil(charSequence2)) {
            charSequence2 = str;
        }
        com.tencent.mm.pluginsdk.ui.a.b.b(this.ekN, str);
        this.ekO.setVisibility(0);
        this.ekO.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, charSequence2, (int) this.ekO.getTextSize()));
        AppMethodBeat.o(104253);
    }

    private String kg(String str) {
        AppMethodBeat.i(104254);
        if (this.eih == null) {
            AppMethodBeat.o(104254);
            return null;
        }
        String mJ = this.eih.mJ(str);
        AppMethodBeat.o(104254);
        return mJ;
    }

    public final int getLayoutId() {
        return R.layout.l1;
    }

    private void Kj() {
        AppMethodBeat.i(104255);
        this.ehJ = h.b((Context) this, getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(104240);
                if (RoomUpgradeUI.this.ekX != null) {
                    g.RO().eJo.c(RoomUpgradeUI.this.ekX);
                    RoomUpgradeUI.this.ekX = null;
                }
                RoomUpgradeUI.this.finish();
                AppMethodBeat.o(104240);
            }
        });
        this.ekX = new j(this.chatroomName);
        g.RO().eJo.a(this.ekX, 0);
        AppMethodBeat.o(104255);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(104256);
        ab.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        switch (i) {
            case 400:
                finish();
                AppMethodBeat.o(104256);
                return;
            default:
                ab.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
                AppMethodBeat.o(104256);
                return;
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(104257);
        ab.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0 && mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.j.g.CTRL_INDEX) {
                j jVar = (j) mVar;
                this.status = jVar.status;
                this.ehs = jVar.ehs;
                this.eht = jVar.eht;
                Kf();
                this.ekQ.setVisibility(0);
                this.ekW.setText(getString(R.string.dv3));
                if (this.eht > 0) {
                    this.ekQ.setText(getString(R.string.dv_, new Object[]{Integer.valueOf(this.eht)}));
                } else {
                    this.ekQ.setText(getString(R.string.dva));
                }
                if (!this.ela) {
                    this.ekU.setVisibility(0);
                }
                switch (this.status) {
                    case 1:
                    case 2:
                    case 5:
                        this.ekW.setVisibility(0);
                        this.ekU.setText(R.string.dv8);
                        AppMethodBeat.o(104257);
                        return;
                    case 3:
                    case 4:
                    case 6:
                        this.ekW.setVisibility(0);
                        this.ekW.setEnabled(false);
                        this.ekU.setText(R.string.dv8);
                        AppMethodBeat.o(104257);
                        return;
                    case 7:
                        this.ekW.setVisibility(8);
                        this.ekU.setText(R.string.dv7);
                        this.ekW.setEnabled(false);
                        break;
                }
            }
            AppMethodBeat.o(104257);
            return;
        }
        h.a((Context) this, getString(R.string.dv9), getString(R.string.tz), false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(104241);
                RoomUpgradeUI.this.finish();
                AppMethodBeat.o(104241);
            }
        });
        AppMethodBeat.o(104257);
    }

    public void onNewIntent(Intent intent) {
        boolean booleanExtra;
        AppMethodBeat.i(104243);
        if (intent.hasExtra("upgrade_success")) {
            booleanExtra = intent.getBooleanExtra("upgrade_success", false);
        } else {
            if (intent.hasExtra("wizard_activity_result_code") && intent.getIntExtra("wizard_activity_result_code", -1) == -1) {
                Kg();
            }
            if (intent.hasExtra("announce_ok")) {
                Kg();
            }
            booleanExtra = false;
        }
        if (booleanExtra) {
            Kh();
            int intExtra = intent.getIntExtra("left_quota", 0);
            Kf();
            this.ekW.setVisibility(8);
            this.eht = intExtra;
            if (this.eht > 0) {
                this.ekQ.setText(getString(R.string.dv_, new Object[]{Integer.valueOf(this.eht)}));
            } else {
                this.ekQ.setText(getString(R.string.dva));
            }
            if (!this.ela) {
                this.ekU.setVisibility(0);
            }
            this.ekU.setText(R.string.dv7);
            AppMethodBeat.o(104243);
            return;
        }
        AppMethodBeat.o(104243);
    }
}
