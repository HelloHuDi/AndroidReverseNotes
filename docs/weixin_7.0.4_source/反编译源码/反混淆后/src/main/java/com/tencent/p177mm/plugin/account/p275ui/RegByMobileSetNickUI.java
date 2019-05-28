package com.tencent.p177mm.plugin.account.p275ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.modelsimple.C26472s;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5622c;
import com.tencent.p177mm.platformtools.C45474a;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindQQUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@Deprecated
/* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI */
public class RegByMobileSetNickUI extends MMActivity implements C1202f {
    private String cFl;
    private ProgressDialog ehJ = null;
    private EditText gGu;
    private C18970q gGv = null;
    private boolean gGw;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI$2 */
    class C99872 implements OnMenuItemClickListener {
        C99872() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125430);
            RegByMobileSetNickUI.this.aqX();
            RegByMobileSetNickUI.this.finish();
            AppMethodBeat.m2505o(125430);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI$1 */
    class C266371 implements OnMenuItemClickListener {
        C266371() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125429);
            String trim = RegByMobileSetNickUI.this.gGu.getText().toString().trim();
            if (trim == null || trim.length() <= 0) {
                C30379h.m48467g(RegByMobileSetNickUI.this, C25738R.string.f0j, C25738R.string.dln);
                AppMethodBeat.m2505o(125429);
            } else {
                RegByMobileSetNickUI.this.aqX();
                final C1207m c26472s = new C26472s("", RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_pwd"), trim, 0, "", RegByMobileSetNickUI.this.cFl, RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_ticket"), 4);
                C1720g.m3540Rg().mo14541a(c26472s, 0);
                RegByMobileSetNickUI regByMobileSetNickUI = RegByMobileSetNickUI.this;
                Context context = RegByMobileSetNickUI.this;
                RegByMobileSetNickUI.this.getString(C25738R.string.f9238tz);
                regByMobileSetNickUI.ehJ = C30379h.m48458b(context, RegByMobileSetNickUI.this.getString(C25738R.string.dmm), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(125428);
                        C1720g.m3540Rg().mo14547c(c26472s);
                        AppMethodBeat.m2505o(125428);
                    }
                });
                AppMethodBeat.m2505o(125429);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125431);
        super.onCreate(bundle);
        this.gGw = getIntent().getBooleanExtra("is_sync_addr", false);
        this.cFl = getIntent().getExtras().getString("bindmcontact_mobile");
        initView();
        C1720g.m3540Rg().mo14539a(126, (C1202f) this);
        AppMethodBeat.m2505o(125431);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125432);
        if (this.gGv != null) {
            C18970q c18970q = this.gGv;
            C23639t c23639t = c18970q.gFy;
            c23639t.cancel();
            c23639t.che.stopTimer();
            c23639t.reset();
            c18970q.text = null;
        }
        C1720g.m3540Rg().mo14546b(126, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(125432);
    }

    public final int getLayoutId() {
        return 2130970498;
    }

    public final void initView() {
        AppMethodBeat.m2504i(125433);
        setMMTitle((int) C25738R.string.dlk);
        this.gGu = (EditText) findViewById(2131826941);
        this.gGu.addTextChangedListener(new C5622c(this.gGu, null, 16));
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C266371());
        setBackBtn(new C99872());
        AppMethodBeat.m2505o(125433);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125434);
        if (i == 4) {
            finish();
            AppMethodBeat.m2505o(125434);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125434);
        return onKeyDown;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125435);
        C4990ab.m7416i("MicroMsg.RegByMobileSetNickUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!C5046bo.m7544cv(this)) {
            AppMethodBeat.m2505o(125435);
        } else if (i == 0 && i2 == 0) {
            int YD = C1853r.m3822YD();
            C4990ab.m7410d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile status = " + YD + " isSync = " + this.gGw);
            if (this.gGw) {
                YD &= -131073;
                C38033l.apP();
                getApplicationContext();
                C45474a.anC();
            } else {
                YD |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            }
            C4990ab.m7410d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile update = ".concat(String.valueOf(YD)));
            C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(YD));
            if (this.gGw) {
                YD = 2;
            } else {
                YD = 1;
            }
            act act = new act();
            act.wkw = 17;
            act.pvD = YD;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
            C24679a.gkF.mo38844BS();
            C6665av.fly.mo14897ak("login_user_name", this.cFl);
            Intent bh = C24679a.gkE.mo38909bh(this);
            bh.putExtra("LauncherUI.enter_from_reg", true);
            bh.addFlags(67108864);
            if (((C26472s) c1207m).fPC) {
                MMWizardActivity.m23792b(this, new Intent(this, BindQQUI.class).putExtra("bindqq_regbymobile", 1), bh);
                AppMethodBeat.m2505o(125435);
                return;
            }
            MMWizardActivity.m23792b(this, new Intent(this, BindFacebookUI.class), bh);
            AppMethodBeat.m2505o(125435);
        } else {
            boolean z;
            if (c1207m.getType() == 126) {
                C42124a jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this, null, null);
                    AppMethodBeat.m2505o(125435);
                    return;
                }
            }
            if (!C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
                switch (i) {
                    case 4:
                        if (i2 != -7 && i2 != -10) {
                            if (i2 == -75) {
                                C30379h.m48467g(this, C25738R.string.f8810fn, C25738R.string.djw);
                                z = true;
                                break;
                            }
                        }
                        C30379h.m48467g(this, C25738R.string.djv, C25738R.string.djw);
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
                AppMethodBeat.m2505o(125435);
                return;
            }
            Toast.makeText(this, getString(C25738R.string.byf, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(125435);
        }
    }
}
