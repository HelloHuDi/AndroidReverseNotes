package com.tencent.mm.plugin.account.ui;

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
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class RegByEmailUI extends MMActivity implements f {
    private static String[] gFE;
    private String dtV;
    private ProgressDialog ehJ = null;
    private EditText gFA;
    private CheckBox gFB;
    private String gFC;
    private Map<String, String> gFD;
    private MMAutoCompleteTextView gFz;
    private String gsF;
    private String guf;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(RegByEmailUI regByEmailUI) {
        AppMethodBeat.i(125322);
        regByEmailUI.goBack();
        AppMethodBeat.o(125322);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125313);
        super.onCreate(bundle);
        String string = getString(R.string.dkf);
        if (d.vxr) {
            string = getString(R.string.ru) + getString(R.string.fk);
        }
        setMMTitle(string);
        a.gkF.BV();
        this.gFC = w.ct(this);
        ab.i("MicroMsg.RegByEmailUI", "get google account:[%s]", this.gFC);
        this.gFD = j.ghe.cl(this);
        if (!(this.gFD == null || this.gFD.isEmpty())) {
            gFE = new String[this.gFD.size()];
            this.gFD.keySet().toArray(gFE);
        }
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        initView();
        AppMethodBeat.o(125313);
    }

    public void onResume() {
        AppMethodBeat.i(125314);
        super.onResume();
        g.Rg().a((int) m.CTRL_INDEX, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R500_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R500_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.wz("R500_100");
        AppMethodBeat.o(125314);
    }

    public void onPause() {
        AppMethodBeat.i(125315);
        super.onPause();
        g.Rg().b((int) m.CTRL_INDEX, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R500_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R500_100")).append(",2").toString());
        AppMethodBeat.o(125315);
    }

    public final int getLayoutId() {
        return R.layout.any;
    }

    public final void initView() {
        AppMethodBeat.i(125316);
        this.gFz = (MMAutoCompleteTextView) findViewById(R.id.dx8);
        this.gFA = (EditText) findViewById(R.id.dx9);
        this.gFB = (CheckBox) findViewById(R.id.da_);
        if (!bo.isNullOrNil(this.gFC)) {
            this.gFA.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(125301);
                    RegByEmailUI.this.gFA.requestFocus();
                    AppMethodBeat.o(125301);
                }
            }, 500);
            this.gFz.setText(this.gFC);
        }
        if (gFE != null) {
            c cVar = new c(this, gFE, "@");
            this.gFz.setSpilter("@");
            this.gFz.setDropDownAnchor(R.id.dx7);
            this.gFz.setDropDownVerticalOffset(this.gFz.getPaddingBottom());
            this.gFz.setAdapter(cVar);
        }
        findViewById(R.id.daa).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125305);
                bo.M(RegByEmailUI.this, RegByEmailUI.this.getString(R.string.ezj));
                AppMethodBeat.o(125305);
            }
        });
        this.gFB.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(125306);
                RegByEmailUI.b(RegByEmailUI.this);
                AppMethodBeat.o(125306);
            }
        });
        addTextOptionMenu(0, getString(R.string.s1), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125307);
                RegByEmailUI.c(RegByEmailUI.this);
                AppMethodBeat.o(125307);
                return true;
            }
        });
        enableOptionMenu(false);
        this.gFz.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125308);
                RegByEmailUI.b(RegByEmailUI.this);
                AppMethodBeat.o(125308);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.gFA.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125309);
                RegByEmailUI.b(RegByEmailUI.this);
                AppMethodBeat.o(125309);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.gFA.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125310);
                if (i != 6 && i != 5) {
                    AppMethodBeat.o(125310);
                    return false;
                } else if (RegByEmailUI.this.gFB.isChecked()) {
                    RegByEmailUI.c(RegByEmailUI.this);
                    AppMethodBeat.o(125310);
                    return true;
                } else {
                    AppMethodBeat.o(125310);
                    return false;
                }
            }
        });
        this.gFA.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125311);
                if (66 != i || keyEvent.getAction() != 0) {
                    AppMethodBeat.o(125311);
                    return false;
                } else if (RegByEmailUI.this.gFB.isChecked()) {
                    RegByEmailUI.c(RegByEmailUI.this);
                    AppMethodBeat.o(125311);
                    return true;
                } else {
                    AppMethodBeat.o(125311);
                    return false;
                }
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125312);
                RegByEmailUI.e(RegByEmailUI.this);
                AppMethodBeat.o(125312);
                return true;
            }
        });
        AppMethodBeat.o(125316);
    }

    private void goBack() {
        AppMethodBeat.i(125317);
        h.a((Context) this, (int) R.string.dk0, (int) R.string.dk3, (int) R.string.s6, (int) R.string.or, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(125302);
                com.tencent.mm.plugin.b.a.wA(RegByEmailUI.this.gsF);
                RegByEmailUI.this.aqX();
                RegByEmailUI.this.finish();
                AppMethodBeat.o(125302);
            }
        }, null);
        AppMethodBeat.o(125317);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125318);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(125318);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125318);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(125319);
        ab.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (mVar.getType() != m.CTRL_INDEX) {
            ab.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", Integer.valueOf(mVar.getType()));
            AppMethodBeat.o(125319);
        } else if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.b.a.wA("R500_200");
            Intent intent = new Intent(this, EmailVerifyUI.class);
            intent.putExtra("email_address", this.dtV);
            intent.putExtra("password", this.guf);
            if (!(this.gFD == null || this.gFD.isEmpty())) {
                String[] split = this.dtV.split("@");
                if (split != null && split.length == 2) {
                    intent.putExtra("email_login_page", (String) this.gFD.get(split[1]));
                }
            }
            startActivity(intent);
            AppMethodBeat.o(125319);
        } else {
            int i3;
            if (!a.gkF.a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -111:
                        h.g(this, R.string.dk6, R.string.dk3);
                        i3 = 1;
                        break;
                    case -75:
                        h.g(this, R.string.fn, R.string.djw);
                        i3 = 1;
                        break;
                    case -34:
                        Toast.makeText(this, R.string.dk1, 0).show();
                        i3 = 1;
                        break;
                    case -7:
                        StringBuilder stringBuilder = new StringBuilder();
                        g.RN();
                        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R20_email_duplicate_confirm,");
                        g.RN();
                        com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R20_email_duplicate_confirm")).append(",3").toString());
                        h.a((Context) this, (int) R.string.dkg, (int) R.string.dk3, (int) R.string.dki, (int) R.string.dkh, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125304);
                                RegByEmailUI.this.finish();
                                com.tencent.mm.plugin.b.a.wA("L2_signup");
                                Intent intent = new Intent(RegByEmailUI.this, LoginPasswordUI.class);
                                intent.putExtra("email_address", RegByEmailUI.this.dtV);
                                RegByEmailUI.this.startActivity(intent);
                                AppMethodBeat.o(125304);
                            }
                        }, null);
                        i3 = 1;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
            }
            i3 = 1;
            if (i3 != 0) {
                AppMethodBeat.o(125319);
                return;
            }
            if (!bo.isNullOrNil(str)) {
                Map z = br.z(str, "e");
                if (z != null && z.size() > 0) {
                    String str2 = (String) z.get(".e.Content");
                    if (!bo.isNullOrNil(str2)) {
                        h.b((Context) this, str2, getString(R.string.dk3), true);
                        AppMethodBeat.o(125319);
                        return;
                    }
                }
            }
            Toast.makeText(this, getString(R.string.dkd, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(125319);
        }
    }

    static /* synthetic */ void b(RegByEmailUI regByEmailUI) {
        AppMethodBeat.i(125320);
        if (bo.isNullOrNil(regByEmailUI.gFz.getText().toString().trim()) || bo.isNullOrNil(regByEmailUI.gFA.getText().toString().trim()) || !regByEmailUI.gFB.isChecked()) {
            regByEmailUI.enableOptionMenu(false);
            AppMethodBeat.o(125320);
            return;
        }
        regByEmailUI.enableOptionMenu(true);
        AppMethodBeat.o(125320);
    }

    static /* synthetic */ void c(RegByEmailUI regByEmailUI) {
        AppMethodBeat.i(125321);
        regByEmailUI.dtV = regByEmailUI.gFz.getText().toString().trim();
        regByEmailUI.guf = regByEmailUI.gFA.getText().toString();
        if (bo.isNullOrNil(regByEmailUI.dtV)) {
            h.g(regByEmailUI, R.string.dk7, R.string.dk3);
            AppMethodBeat.o(125321);
        } else if (!bo.amW(regByEmailUI.dtV)) {
            h.g(regByEmailUI, R.string.dk6, R.string.dk3);
            AppMethodBeat.o(125321);
        } else if (bo.isNullOrNil(regByEmailUI.guf)) {
            h.g(regByEmailUI, R.string.dk8, R.string.dk3);
            AppMethodBeat.o(125321);
        } else if (bo.amY(regByEmailUI.guf)) {
            regByEmailUI.aqX();
            final com.tencent.mm.ai.m zVar = new z(regByEmailUI.dtV, regByEmailUI.guf);
            g.Rg().a(zVar, 0);
            regByEmailUI.getString(R.string.tz);
            regByEmailUI.ehJ = h.b((Context) regByEmailUI, regByEmailUI.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(125303);
                    g.Rg().c(zVar);
                    AppMethodBeat.o(125303);
                }
            });
            AppMethodBeat.o(125321);
        } else {
            h.g(regByEmailUI, R.string.f0t, R.string.dk3);
            AppMethodBeat.o(125321);
        }
    }
}
