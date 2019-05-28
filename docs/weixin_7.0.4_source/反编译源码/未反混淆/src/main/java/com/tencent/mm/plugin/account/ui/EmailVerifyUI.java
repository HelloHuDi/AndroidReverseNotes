package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.r;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.b;
import com.tencent.mm.ui.base.h;

public class EmailVerifyUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    private TextView gAF;
    private TextView gAG;
    private MMAutoSwitchEditTextView gAH;
    private Button gAI;
    private Button gAJ;
    private String gAK;
    private String gAL;
    private String gAM;
    private String gAN;
    private boolean gAO = false;
    private String gsF;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void d(EmailVerifyUI emailVerifyUI) {
        AppMethodBeat.i(124774);
        emailVerifyUI.goBack();
        AppMethodBeat.o(124774);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124766);
        super.onCreate(bundle);
        initView();
        this.gsF = a.FP();
        AppMethodBeat.o(124766);
    }

    public void onResume() {
        AppMethodBeat.i(124767);
        super.onResume();
        g.Rg().a((int) m.CTRL_INDEX, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R500_200,");
        g.RN();
        a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R500_200")).append(",1").toString());
        a.wz("R500_200");
        AppMethodBeat.o(124767);
    }

    public void onPause() {
        AppMethodBeat.i(124768);
        super.onPause();
        g.Rg().b((int) m.CTRL_INDEX, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R500_200,");
        g.RN();
        a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R500_200")).append(",2").toString());
        AppMethodBeat.o(124768);
    }

    public final int getLayoutId() {
        return R.layout.b19;
    }

    public final void initView() {
        AppMethodBeat.i(124769);
        setMMTitle((int) R.string.dkl);
        this.gAF = (TextView) findViewById(R.id.f07);
        this.gAF.setText(Html.fromHtml(getString(R.string.dk5)));
        this.gAG = (TextView) findViewById(R.id.f08);
        this.gAK = getIntent().getStringExtra("email_address");
        if (bo.isNullOrNil(this.gAK)) {
            ab.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
        } else {
            this.gAG.setText(this.gAK);
        }
        this.gAM = getIntent().getStringExtra("password");
        this.gAL = getIntent().getStringExtra("email_login_page");
        ab.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", this.gAK, this.gAL);
        this.gAH = (MMAutoSwitchEditTextView) findViewById(R.id.f09);
        this.gAH.setOnInputFinished(new MMAutoSwitchEditTextView.a() {
            public final void wr(String str) {
                AppMethodBeat.i(124757);
                EmailVerifyUI.this.enableOptionMenu(true);
                EmailVerifyUI.a(EmailVerifyUI.this, str);
                AppMethodBeat.o(124757);
            }
        });
        this.gAH.setOnTextChanged(new b() {
            public final void aqK() {
                AppMethodBeat.i(124758);
                EmailVerifyUI.this.enableOptionMenu(false);
                AppMethodBeat.o(124758);
            }
        });
        this.gAJ = (Button) findViewById(R.id.f0a);
        this.gAJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(124761);
                StringBuilder stringBuilder = new StringBuilder();
                g.RN();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R500_250,");
                g.RN();
                a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R500_250")).append(",3").toString());
                h.a(EmailVerifyUI.this, (int) R.string.dkc, (int) R.string.dk3, (int) R.string.s6, (int) R.string.or, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(124760);
                        final com.tencent.mm.ai.m zVar = new z(EmailVerifyUI.this.gAK, EmailVerifyUI.this.gAM);
                        g.Rg().a(zVar, 0);
                        EmailVerifyUI emailVerifyUI = EmailVerifyUI.this;
                        Context context = EmailVerifyUI.this;
                        EmailVerifyUI.this.getString(R.string.tz);
                        emailVerifyUI.ehJ = h.b(context, EmailVerifyUI.this.getString(R.string.dkk), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(124759);
                                g.Rg().c(zVar);
                                AppMethodBeat.o(124759);
                            }
                        });
                        AppMethodBeat.o(124760);
                    }
                }, null);
                AppMethodBeat.o(124761);
            }
        });
        this.gAI = (Button) findViewById(R.id.f0_);
        if (bo.isNullOrNil(this.gAL) || bo.isNullOrNil(this.gAK)) {
            this.gAI.setVisibility(8);
        } else {
            this.gAI.setVisibility(0);
            this.gAI.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(124762);
                    bo.M(EmailVerifyUI.this, EmailVerifyUI.this.gAL);
                    AppMethodBeat.o(124762);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124763);
                EmailVerifyUI.d(EmailVerifyUI.this);
                AppMethodBeat.o(124763);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.s1), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124764);
                EmailVerifyUI.this.gAN = EmailVerifyUI.this.gAH.getText();
                if (bo.isNullOrNil(EmailVerifyUI.this.gAN) || EmailVerifyUI.this.gAN.length() != 12) {
                    EmailVerifyUI.this.enableOptionMenu(false);
                } else {
                    EmailVerifyUI.a(EmailVerifyUI.this, EmailVerifyUI.this.gAN);
                }
                AppMethodBeat.o(124764);
                return true;
            }
        });
        enableOptionMenu(false);
        AppMethodBeat.o(124769);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(124770);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(124770);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(124770);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(124771);
        a.wA(this.gsF);
        finish();
        AppMethodBeat.o(124771);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(124772);
        ab.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        this.gAO = false;
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (mVar.getType() != m.CTRL_INDEX) {
            ab.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", Integer.valueOf(mVar.getType()));
            AppMethodBeat.o(124772);
            return;
        }
        int i3 = ((r.a) ((z) mVar).ftU.acF()).gvF.vIJ;
        StringBuilder stringBuilder;
        if (i != 0 || i2 != 0) {
            int i4;
            if (!com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -34:
                        Toast.makeText(this, R.string.dk1, 0).show();
                        i4 = 1;
                        break;
                    case -33:
                        h.a((Context) this, (int) R.string.dk2, (int) R.string.dk3, null);
                        i4 = 1;
                        break;
                    case -32:
                        h.a((Context) this, (int) R.string.dk4, (int) R.string.dk3, null);
                        stringBuilder = new StringBuilder();
                        g.RN();
                        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R500_260,");
                        g.RN();
                        a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R500_260")).append(",3").toString());
                        i4 = 1;
                        break;
                    default:
                        boolean i42 = false;
                        break;
                }
            }
            i42 = 1;
            if (i42 != 0) {
                AppMethodBeat.o(124772);
            } else if (i3 == 2) {
                Toast.makeText(this, getString(R.string.dkm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                AppMethodBeat.o(124772);
            } else {
                if (i3 == 1) {
                    Toast.makeText(this, getString(R.string.dkd, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
                AppMethodBeat.o(124772);
            }
        } else if (i3 == 2) {
            a.wA("R200_900_email");
            Intent intent = new Intent(this, RegSetInfoUI.class);
            intent.putExtra("regsetinfo_ticket", ((r.b) ((z) mVar).ftU.ZS()).gvG.wdB);
            intent.putExtra("regsetinfo_user", this.gAK);
            intent.putExtra("regsetinfo_ismobile", 3);
            intent.putExtra("regsetinfo_NextStyle", ((z) mVar).ajx());
            intent.putExtra("regsetinfo_pwd", this.gAM);
            intent.putExtra("regsetinfo_bind_email", this.gAK);
            startActivity(intent);
            AppMethodBeat.o(124772);
        } else if (i3 == 1) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R22_resend_email_code_alert,");
            g.RN();
            a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R22_resend_email_code_alert")).append(",3").toString());
            h.bQ(this, getString(R.string.dke));
            AppMethodBeat.o(124772);
        } else {
            ab.e("MicroMsg.EmailVerifyUI", "err opcode");
            AppMethodBeat.o(124772);
        }
    }
}
