package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class RegByMobileVoiceVerifyUI extends MMActivity implements f {
    private String cFl;
    private TextView exj;
    private String gBC;
    private String gGN;
    private a gGP;
    private x gGQ;
    private int gGR = 0;
    private String gsF;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ int d(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
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
        AppMethodBeat.i(125466);
        super.onCreate(bundle);
        this.cFl = getIntent().getExtras().getString("bindmcontact_mobile");
        this.gGR = getIntent().getExtras().getInt("voice_verify_type");
        if (this.gGR == 0 || this.gGR == 2 || this.gGR == 3) {
            g.Rg().a(145, (f) this);
        } else if (this.gGR == 4 || this.gGR == 1) {
            g.Rg().a(132, (f) this);
        }
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        initView();
        AppMethodBeat.o(125466);
    }

    public void onResume() {
        AppMethodBeat.i(125467);
        super.onResume();
        if (this.gGR == 0 || this.gGR == 2 || this.gGR == 3) {
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_500,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_500")).append(",1").toString());
            com.tencent.mm.plugin.b.a.wz("R200_500");
        }
        AppMethodBeat.o(125467);
    }

    public void onDestroy() {
        AppMethodBeat.i(125468);
        super.onDestroy();
        g.Rg().b(132, (f) this);
        g.Rg().b(145, (f) this);
        if (this.gGR == 0 || this.gGR == 2 || this.gGR == 3) {
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_500,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_500")).append(",2").toString());
        }
        AppMethodBeat.o(125468);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125469);
        if (i == 4) {
            com.tencent.mm.plugin.b.a.wA(this.gsF);
            aqX();
            finish();
            AppMethodBeat.o(125469);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125469);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.i(125470);
        setMMTitle((int) R.string.a88);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125461);
                RegByMobileVoiceVerifyUI.this.aqX();
                RegByMobileVoiceVerifyUI.this.finish();
                AppMethodBeat.o(125461);
                return true;
            }
        });
        this.exj = (TextView) findViewById(R.id.a6_);
        Button button = (Button) findViewById(R.id.a6a);
        this.gBC = RegByMobileVoiceVerifySelectUI.wx(this.cFl);
        this.exj.setText(this.gBC);
        this.gGN = b.sN(this.cFl);
        findViewById(R.id.a69).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125462);
                RegByMobileVoiceVerifyUI.this.startActivityForResult(new Intent(RegByMobileVoiceVerifyUI.this, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", RegByMobileVoiceVerifyUI.this.gGN), Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.o(125462);
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125465);
                if (RegByMobileVoiceVerifyUI.this.gGR == 0 || RegByMobileVoiceVerifyUI.this.gGR == 2 || RegByMobileVoiceVerifyUI.this.gGR == 3) {
                    RegByMobileVoiceVerifyUI.this.gGP = new a(RegByMobileVoiceVerifyUI.this.cFl, RegByMobileVoiceVerifyUI.d(RegByMobileVoiceVerifyUI.this), "", 1, RegByMobileVoiceVerifyUI.this.gGN);
                    g.Rg().a(RegByMobileVoiceVerifyUI.this.gGP, 0);
                    h.a(RegByMobileVoiceVerifyUI.this, (int) R.string.a85, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125463);
                            RegByMobileVoiceVerifyUI.this.finish();
                            AppMethodBeat.o(125463);
                        }
                    });
                    AppMethodBeat.o(125465);
                    return;
                }
                if (RegByMobileVoiceVerifyUI.this.gGR == 4 || RegByMobileVoiceVerifyUI.this.gGR == 1) {
                    RegByMobileVoiceVerifyUI.this.gGQ = new x(RegByMobileVoiceVerifyUI.this.cFl, 1, "", 1, RegByMobileVoiceVerifyUI.this.gGN);
                    g.Rg().a(RegByMobileVoiceVerifyUI.this.gGQ, 0);
                    h.a(RegByMobileVoiceVerifyUI.this, (int) R.string.a85, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125464);
                            RegByMobileVoiceVerifyUI.this.finish();
                            AppMethodBeat.o(125464);
                        }
                    });
                }
                AppMethodBeat.o(125465);
            }
        });
        AppMethodBeat.o(125470);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(125471);
        super.onActivityResult(i, i2, intent);
        if (i == Downloads.MIN_WAIT_FOR_NETWORK) {
            if (intent == null) {
                AppMethodBeat.o(125471);
                return;
            }
            this.gBC = intent.getStringExtra("voice_verify_language");
            this.gGN = intent.getStringExtra("voice_verify_code");
            this.exj.setText(this.gBC);
        }
        AppMethodBeat.o(125471);
    }

    public final int getLayoutId() {
        return R.layout.gl;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125472);
        ab.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.o(125472);
    }
}
