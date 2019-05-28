package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class RegByQQAuthUI extends MMActivity implements f {
    private String account;
    private String cIR;
    private String cxb;
    private ProgressDialog ehJ = null;
    private EditText gHh = null;
    private int gHi;
    private String guf;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.ao6;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125501);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(125501);
    }

    public void onDestroy() {
        AppMethodBeat.i(125502);
        super.onDestroy();
        AppMethodBeat.o(125502);
    }

    public void onResume() {
        AppMethodBeat.i(125503);
        super.onResume();
        g.Rg().a(126, (f) this);
        AppMethodBeat.o(125503);
    }

    public void onPause() {
        AppMethodBeat.i(125504);
        super.onPause();
        g.Rg().b(126, (f) this);
        AppMethodBeat.o(125504);
    }

    public final void initView() {
        AppMethodBeat.i(125505);
        this.gHi = getIntent().getIntExtra("RegByQQ_BindUin", 0);
        this.guf = getIntent().getStringExtra("RegByQQ_RawPsw");
        this.account = getIntent().getStringExtra("RegByQQ_Account");
        this.cxb = getIntent().getStringExtra("RegByQQ_Ticket");
        this.cIR = getIntent().getStringExtra("RegByQQ_Nick");
        ab.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.gHi + "  pass:" + this.guf + "  ticket:" + this.cxb);
        this.gHh = (EditText) findViewById(R.id.dy_);
        if (!(this.cIR == null || this.cIR.equals(""))) {
            this.gHh.setText(this.cIR);
        }
        setMMTitle((int) R.string.dmf);
        addTextOptionMenu(0, getString(R.string.s1), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125499);
                RegByQQAuthUI.this.cIR = RegByQQAuthUI.this.gHh.getText().toString().trim();
                if (RegByQQAuthUI.this.cIR.equals("")) {
                    h.g(RegByQQAuthUI.this, R.string.f0j, R.string.pq);
                    AppMethodBeat.o(125499);
                } else {
                    final m sVar = new s("", RegByQQAuthUI.this.guf, RegByQQAuthUI.this.cIR, RegByQQAuthUI.this.gHi, "", "", RegByQQAuthUI.this.cxb, 2);
                    g.Rg().a(sVar, 0);
                    RegByQQAuthUI regByQQAuthUI = RegByQQAuthUI.this;
                    Context context = RegByQQAuthUI.this;
                    RegByQQAuthUI.this.getString(R.string.tz);
                    regByQQAuthUI.ehJ = h.b(context, RegByQQAuthUI.this.getString(R.string.dmm), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(125498);
                            g.Rg().c(sVar);
                            AppMethodBeat.o(125498);
                        }
                    });
                    AppMethodBeat.o(125499);
                }
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125500);
                RegByQQAuthUI.this.aqX();
                RegByQQAuthUI.this.finish();
                AppMethodBeat.o(125500);
                return true;
            }
        });
        AppMethodBeat.o(125505);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125506);
        ab.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!bo.cv(this)) {
            AppMethodBeat.o(125506);
        } else if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case 126:
                    a.unhold();
                    av.fly.ak("login_user_name", this.account);
                    Intent intent = new Intent(this, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 1);
                    intent.putExtra("skip", true);
                    Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
                    bh.addFlags(67108864);
                    bh.putExtra("LauncherUI.enter_from_reg", true);
                    MMWizardActivity.b(this, intent, bh);
                    break;
            }
            AppMethodBeat.o(125506);
        } else {
            int i3;
            if (mVar.getType() == 126) {
                com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this, null, null);
                    AppMethodBeat.o(125506);
                    return;
                }
            }
            if (com.tencent.mm.plugin.account.a.a.gkF.a(this.mController.ylL, i, i2, str)) {
                i3 = 1;
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -75:
                            h.g(this.mController.ylL, R.string.fn, R.string.tz);
                            i3 = 1;
                            break;
                        case -72:
                            h.g(this.mController.ylL, R.string.dmb, R.string.tz);
                            i3 = 1;
                            break;
                        case -12:
                            h.g(this, R.string.dme, R.string.dmd);
                            i3 = 1;
                            break;
                        case -11:
                            h.g(this, R.string.dmc, R.string.dmd);
                            i3 = 1;
                            break;
                        case -4:
                            h.g(this, R.string.po, R.string.dmd);
                            i3 = 1;
                            break;
                        case -1:
                            if (g.Rg().acS() == 5) {
                                h.g(this, R.string.d5n, R.string.d5m);
                                i3 = 1;
                                break;
                            }
                        case -3:
                            h.g(this, R.string.pp, R.string.dmd);
                            i3 = 1;
                            break;
                    }
                }
                i3 = 0;
            }
            if (i3 != 0) {
                AppMethodBeat.o(125506);
                return;
            }
            Toast.makeText(this, getString(R.string.byf, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(125506);
        }
    }
}
