package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.a;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMEditText.c;

@Deprecated
public class RegByMobileSetNickUI extends MMActivity implements f {
    private String cFl;
    private ProgressDialog ehJ = null;
    private EditText gGu;
    private q gGv = null;
    private boolean gGw;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125431);
        super.onCreate(bundle);
        this.gGw = getIntent().getBooleanExtra("is_sync_addr", false);
        this.cFl = getIntent().getExtras().getString("bindmcontact_mobile");
        initView();
        g.Rg().a(126, (f) this);
        AppMethodBeat.o(125431);
    }

    public void onDestroy() {
        AppMethodBeat.i(125432);
        if (this.gGv != null) {
            q qVar = this.gGv;
            t tVar = qVar.gFy;
            tVar.cancel();
            tVar.che.stopTimer();
            tVar.reset();
            qVar.text = null;
        }
        g.Rg().b(126, (f) this);
        super.onDestroy();
        AppMethodBeat.o(125432);
    }

    public final int getLayoutId() {
        return R.layout.ao4;
    }

    public final void initView() {
        AppMethodBeat.i(125433);
        setMMTitle((int) R.string.dlk);
        this.gGu = (EditText) findViewById(R.id.dxx);
        this.gGu.addTextChangedListener(new c(this.gGu, null, 16));
        addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125429);
                String trim = RegByMobileSetNickUI.this.gGu.getText().toString().trim();
                if (trim == null || trim.length() <= 0) {
                    h.g(RegByMobileSetNickUI.this, R.string.f0j, R.string.dln);
                    AppMethodBeat.o(125429);
                } else {
                    RegByMobileSetNickUI.this.aqX();
                    final m sVar = new s("", RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_pwd"), trim, 0, "", RegByMobileSetNickUI.this.cFl, RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_ticket"), 4);
                    g.Rg().a(sVar, 0);
                    RegByMobileSetNickUI regByMobileSetNickUI = RegByMobileSetNickUI.this;
                    Context context = RegByMobileSetNickUI.this;
                    RegByMobileSetNickUI.this.getString(R.string.tz);
                    regByMobileSetNickUI.ehJ = h.b(context, RegByMobileSetNickUI.this.getString(R.string.dmm), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(125428);
                            g.Rg().c(sVar);
                            AppMethodBeat.o(125428);
                        }
                    });
                    AppMethodBeat.o(125429);
                }
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125430);
                RegByMobileSetNickUI.this.aqX();
                RegByMobileSetNickUI.this.finish();
                AppMethodBeat.o(125430);
                return true;
            }
        });
        AppMethodBeat.o(125433);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125434);
        if (i == 4) {
            finish();
            AppMethodBeat.o(125434);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125434);
        return onKeyDown;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125435);
        ab.i("MicroMsg.RegByMobileSetNickUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!bo.cv(this)) {
            AppMethodBeat.o(125435);
        } else if (i == 0 && i2 == 0) {
            int YD = r.YD();
            ab.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile status = " + YD + " isSync = " + this.gGw);
            if (this.gGw) {
                YD &= -131073;
                l.apP();
                getApplicationContext();
                a.anC();
            } else {
                YD |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            }
            ab.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile update = ".concat(String.valueOf(YD)));
            g.RP().Ry().set(7, Integer.valueOf(YD));
            if (this.gGw) {
                YD = 2;
            } else {
                YD = 1;
            }
            act act = new act();
            act.wkw = 17;
            act.pvD = YD;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act));
            com.tencent.mm.plugin.account.a.a.gkF.BS();
            av.fly.ak("login_user_name", this.cFl);
            Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
            bh.putExtra("LauncherUI.enter_from_reg", true);
            bh.addFlags(67108864);
            if (((s) mVar).fPC) {
                MMWizardActivity.b(this, new Intent(this, BindQQUI.class).putExtra("bindqq_regbymobile", 1), bh);
                AppMethodBeat.o(125435);
                return;
            }
            MMWizardActivity.b(this, new Intent(this, BindFacebookUI.class), bh);
            AppMethodBeat.o(125435);
        } else {
            boolean z;
            if (mVar.getType() == 126) {
                com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this, null, null);
                    AppMethodBeat.o(125435);
                    return;
                }
            }
            if (!com.tencent.mm.plugin.account.a.a.gkF.a(this.mController.ylL, i, i2, str)) {
                switch (i) {
                    case 4:
                        if (i2 != -7 && i2 != -10) {
                            if (i2 == -75) {
                                h.g(this, R.string.fn, R.string.djw);
                                z = true;
                                break;
                            }
                        }
                        h.g(this, R.string.djv, R.string.djw);
                        z = true;
                        break;
                        break;
                    default:
                        z = false;
                        break;
                }
            }
            z = true;
            if (z) {
                AppMethodBeat.o(125435);
                return;
            }
            Toast.makeText(this, getString(R.string.byf, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(125435);
        }
    }
}
