package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class SecurityAccountVerifyUI extends MMWizardActivity implements f {
    private String cCU;
    private String cCW;
    private String cFl;
    private ap che;
    private ProgressDialog ehJ = null;
    private String gsF;
    private String gzO;
    private Button gzR;
    private EditText gzV;
    private TextView gzW;
    private TextView gzX;
    private Button gzY;
    private boolean gzZ = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void f(SecurityAccountVerifyUI securityAccountVerifyUI) {
        AppMethodBeat.i(69932);
        securityAccountVerifyUI.aoZ();
        AppMethodBeat.o(69932);
    }

    public final int getLayoutId() {
        return R.layout.aq_;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69923);
        super.onCreate(bundle);
        this.gsF = a.FP();
        initView();
        AppMethodBeat.o(69923);
    }

    public void onResume() {
        AppMethodBeat.i(69924);
        g.Rg().a(145, (f) this);
        g.Rg().a(132, (f) this);
        super.onResume();
        if (!this.gzZ) {
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L600_200,");
            g.RN();
            a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("L600_200")).append(",1").toString());
            a.wz("L600_200");
        }
        AppMethodBeat.o(69924);
    }

    public void onPause() {
        AppMethodBeat.i(69925);
        g.Rg().b(145, (f) this);
        g.Rg().b(132, (f) this);
        super.onPause();
        if (!this.gzZ) {
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L600_200,");
            g.RN();
            a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("L600_200")).append(",2").toString());
        }
        AppMethodBeat.o(69925);
    }

    public void onDestroy() {
        AppMethodBeat.i(69926);
        super.onDestroy();
        this.che.stopTimer();
        AppMethodBeat.o(69926);
    }

    public final void initView() {
        AppMethodBeat.i(69927);
        this.cFl = getIntent().getStringExtra("binded_mobile");
        this.gzO = getIntent().getStringExtra("auth_ticket");
        this.gzZ = getIntent().getBooleanExtra("re_open_verify", false);
        this.gzV = (EditText) findViewById(R.id.a65);
        this.gzW = (TextView) findViewById(R.id.e7f);
        this.gzX = (TextView) findViewById(R.id.e7g);
        this.gzY = (Button) findViewById(R.id.e7h);
        this.gzV.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(69915);
                boolean z = (editable == null || bo.isNullOrNil(editable.toString())) ? false : true;
                SecurityAccountVerifyUI.this.enableOptionMenu(z);
                AppMethodBeat.o(69915);
            }
        });
        this.gzW.setText(bo.ans(this.cFl));
        this.gzX.setTag(Integer.valueOf(60));
        this.che = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(69916);
                int intValue = ((Integer) SecurityAccountVerifyUI.this.gzX.getTag()).intValue();
                if (intValue <= 1) {
                    SecurityAccountVerifyUI.this.gzY.setVisibility(0);
                    SecurityAccountVerifyUI.this.gzX.setVisibility(8);
                    AppMethodBeat.o(69916);
                    return false;
                }
                SecurityAccountVerifyUI.this.gzX.setTag(Integer.valueOf(intValue - 1));
                SecurityAccountVerifyUI.this.gzX.setText(SecurityAccountVerifyUI.this.getString(R.string.dwl, new Object[]{Integer.valueOf(intValue)}));
                if (SecurityAccountVerifyUI.this.gzX.getVisibility() != 0) {
                    SecurityAccountVerifyUI.this.gzX.setVisibility(0);
                }
                AppMethodBeat.o(69916);
                return true;
            }
        }, true);
        this.gzY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(69918);
                ab.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
                SecurityAccountVerifyUI.this.gzY.setVisibility(8);
                SecurityAccountVerifyUI.this.gzX.setTag(Integer.valueOf(60));
                SecurityAccountVerifyUI.this.che.stopTimer();
                SecurityAccountVerifyUI.this.che.ae(1000, 1000);
                final m aVar = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.this.cFl, 10, "", "", SecurityAccountVerifyUI.this.gzO);
                g.Rg().a(aVar, 0);
                SecurityAccountVerifyUI securityAccountVerifyUI = SecurityAccountVerifyUI.this;
                Context context = SecurityAccountVerifyUI.this.mController.ylL;
                SecurityAccountVerifyUI.this.getString(R.string.tz);
                securityAccountVerifyUI.ehJ = h.b(context, SecurityAccountVerifyUI.this.getString(R.string.dwo), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(69917);
                        g.Rg().c(aVar);
                        AppMethodBeat.o(69917);
                    }
                });
                AppMethodBeat.o(69918);
            }
        });
        if (!this.gzZ) {
            this.gzR = (Button) findViewById(R.id.e7c);
            this.gzR.setVisibility(0);
            this.gzR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(69919);
                    StringBuilder stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L600_300,");
                    g.RN();
                    a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("L600_300")).append(",1").toString());
                    String g = aa.g(SecurityAccountVerifyUI.this.getSharedPreferences(ah.doA(), 0));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{g}));
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("title", SecurityAccountVerifyUI.this.getString(R.string.dwj));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                    com.tencent.mm.plugin.account.a.a.gkE.i(intent, SecurityAccountVerifyUI.this);
                    AppMethodBeat.o(69919);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69920);
                SecurityAccountVerifyUI.f(SecurityAccountVerifyUI.this);
                AppMethodBeat.o(69920);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.s1), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69922);
                String trim = SecurityAccountVerifyUI.this.gzV.getText().toString().trim();
                if (bo.isNullOrNil(trim)) {
                    h.g(SecurityAccountVerifyUI.this, R.string.a7z, R.string.tz);
                    AppMethodBeat.o(69922);
                } else {
                    m xVar;
                    SecurityAccountVerifyUI.this.aqX();
                    SecurityAccountVerifyUI.this.cCU = com.tencent.mm.plugin.account.security.a.f.cz(SecurityAccountVerifyUI.this);
                    SecurityAccountVerifyUI.this.cCW = com.tencent.mm.plugin.account.security.a.f.aqE();
                    if (SecurityAccountVerifyUI.this.gzZ) {
                        xVar = new x(SecurityAccountVerifyUI.this.cFl, 11, trim, "", SecurityAccountVerifyUI.this.cCU, SecurityAccountVerifyUI.this.cCW);
                    } else {
                        xVar = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.this.cFl, trim, "", SecurityAccountVerifyUI.this.gzO, SecurityAccountVerifyUI.this.cCU, SecurityAccountVerifyUI.this.cCW);
                    }
                    g.Rg().a(xVar, 0);
                    SecurityAccountVerifyUI securityAccountVerifyUI = SecurityAccountVerifyUI.this;
                    Context context = SecurityAccountVerifyUI.this;
                    SecurityAccountVerifyUI.this.getString(R.string.tz);
                    securityAccountVerifyUI.ehJ = h.b(context, SecurityAccountVerifyUI.this.getString(R.string.a7n), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(69921);
                            g.Rg().c(xVar);
                            AppMethodBeat.o(69921);
                        }
                    });
                    AppMethodBeat.o(69922);
                }
                return true;
            }
        });
        enableOptionMenu(false);
        setMMTitle((int) R.string.dwd);
        this.che.ae(1000, 1000);
        AppMethodBeat.o(69927);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(69928);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.o(69928);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(69928);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.i(69929);
        cancel();
        Ni(1);
        AppMethodBeat.o(69929);
    }

    private boolean j(int i, int i2, String str) {
        boolean z = true;
        AppMethodBeat.i(69931);
        if (com.tencent.mm.plugin.account.a.a.gkF.a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.o(69931);
        } else {
            switch (i2) {
                case -74:
                    h.a(this.mController.ylL, (int) R.string.a6g, (int) R.string.tz, null);
                    break;
                case -57:
                case -1:
                    Toast.makeText(this.mController.ylL, R.string.ps, 0).show();
                    break;
                case -41:
                    Toast.makeText(this.mController.ylL, R.string.a6j, 0).show();
                    break;
                case -34:
                    Toast.makeText(this, R.string.a6k, 0).show();
                    break;
                case -33:
                    h.a(this.mController.ylL, (int) R.string.a7s, (int) R.string.a7y, null);
                    break;
                case -32:
                    h.a(this.mController.ylL, (int) R.string.a7t, (int) R.string.a7y, null);
                    break;
                default:
                    z = false;
                    break;
            }
            AppMethodBeat.o(69931);
        }
        return z;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(69930);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        Intent intent;
        switch (mVar.getType()) {
            case 132:
                if (i != 0 || i2 != 0) {
                    if (!j(i, i2, str)) {
                        Toast.makeText(this, getString(R.string.dwq, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        break;
                    }
                    AppMethodBeat.o(69930);
                    return;
                }
                com.tencent.mm.plugin.account.security.a.f.n(true, true);
                intent = new Intent(this, MySafeDeviceListUI.class);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
                AppMethodBeat.o(69930);
                return;
                break;
            case 145:
                com.tencent.mm.modelfriend.a aVar = (com.tencent.mm.modelfriend.a) mVar;
                if (aVar.Ah() == 10) {
                    if (i == 0 && i2 == 0) {
                        ab.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
                        AppMethodBeat.o(69930);
                        return;
                    }
                    ab.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (j(i, i2, str)) {
                        AppMethodBeat.o(69930);
                        return;
                    }
                    Toast.makeText(this.mController.ylL, getString(R.string.dwm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.o(69930);
                    return;
                } else if (aVar.Ah() != 11) {
                    ab.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", Integer.valueOf(aVar.Ah()), Integer.valueOf(i), Integer.valueOf(i2));
                    AppMethodBeat.o(69930);
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.gzO = aVar.agh();
                    ab.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.gzO);
                    int intExtra = getIntent().getIntExtra("from_source", 1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("from_source", intExtra);
                    intent2.putExtra("binded_mobile", this.cFl);
                    switch (intExtra) {
                        case 1:
                        case 2:
                        case 5:
                        case 6:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.gzO);
                            com.tencent.mm.plugin.account.a.a.gkE.a((Context) this, intent2, null);
                            finish();
                            AppMethodBeat.o(69930);
                            return;
                        case 3:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.gzO);
                            Object stringExtra = getIntent().getStringExtra("WizardTransactionId");
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            intent = (Intent) ynD.get(stringExtra);
                            ynD.clear();
                            if (intent != null) {
                                com.tencent.mm.plugin.account.a.a.gkE.a((Context) this, intent2, intent);
                            } else {
                                com.tencent.mm.plugin.account.a.a.gkE.a((Context) this, intent2, null);
                            }
                            finish();
                            AppMethodBeat.o(69930);
                            return;
                        default:
                            Ni(1);
                            AppMethodBeat.o(69930);
                            return;
                    }
                } else {
                    ab.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (j(i, i2, str)) {
                        AppMethodBeat.o(69930);
                        return;
                    }
                    Toast.makeText(this.mController.ylL, getString(R.string.dwq, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.o(69930);
                    return;
                }
        }
        AppMethodBeat.o(69930);
    }
}
