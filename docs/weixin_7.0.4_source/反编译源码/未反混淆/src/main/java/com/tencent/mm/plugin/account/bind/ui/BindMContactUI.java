package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindMContactUI extends MMWizardActivity {
    private String cFl;
    private String countryCode = null;
    private String fHE = null;
    private int fromScene = 0;
    private boolean gqB = false;
    private EditText grE;
    private LinearLayout grF;
    private TextView grG;
    private TextView grH;
    private TextView grI;
    private String grJ = null;
    private i gro;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(BindMContactUI bindMContactUI, String str) {
        AppMethodBeat.i(13477);
        bindMContactUI.vL(str);
        AppMethodBeat.o(13477);
    }

    static /* synthetic */ void g(BindMContactUI bindMContactUI) {
        AppMethodBeat.i(13478);
        bindMContactUI.apb();
        AppMethodBeat.o(13478);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13468);
        super.onCreate(bundle);
        setMMTitle((int) R.string.a79);
        this.fHE = bo.bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bo.bc(getIntent().getStringExtra("couttry_code"), "");
        this.grJ = bo.bc(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        initView();
        AppMethodBeat.o(13468);
    }

    public void onDestroy() {
        AppMethodBeat.i(13469);
        super.onDestroy();
        if (this.gro != null) {
            this.gro.recycle();
        }
        AppMethodBeat.o(13469);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13470);
        if (i == 4) {
            apb();
            AppMethodBeat.o(13470);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13470);
        return onKeyDown;
    }

    private void apb() {
        AppMethodBeat.i(13471);
        if (this.fromScene == 0 || this.fromScene == 3) {
            int i;
            int i2;
            if (this.fromScene == 3) {
                i = R.string.a6o;
            } else {
                i = R.string.a6n;
            }
            if (this.fromScene == 3) {
                i2 = R.string.a6q;
            } else {
                i2 = R.string.a6p;
            }
            h.a((Context) this, i, i2, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13459);
                    BindMContactUI.a(BindMContactUI.this);
                    AppMethodBeat.o(13459);
                }
            }, null);
            AppMethodBeat.o(13471);
            return;
        }
        ynD.clear();
        Ni(1);
        AppMethodBeat.o(13471);
    }

    public final void initView() {
        AppMethodBeat.i(13472);
        this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        ab.i("MicroMsg.BindMContactUI", "bindScene:%d", Integer.valueOf(this.fromScene));
        this.grE = (EditText) findViewById(R.id.a50);
        this.grF = (LinearLayout) findViewById(R.id.a4x);
        this.grH = (TextView) findViewById(R.id.a4z);
        this.grI = (TextView) findViewById(R.id.a4y);
        this.grG = (TextView) findViewById(R.id.a5w);
        if (this.fromScene == 3) {
            String str = (String) g.RP().Ry().get(6, null);
            if (!bo.isNullOrNil(str)) {
                String Ps;
                if (str.startsWith("+")) {
                    Ps = av.Ps(str);
                    if (!bo.isNullOrNil(Ps)) {
                        str = str.substring(Ps.length() + 1);
                    }
                } else {
                    Ps = "86";
                }
                av avVar = new av();
                str = av.formatNumber(Ps, str);
                this.grG.setText(getString(R.string.a6c, new Object[]{str}));
            }
        }
        if (!bo.isNullOrNil(this.fHE)) {
            this.grH.setText(this.fHE);
        }
        if (bo.isNullOrNil(this.countryCode)) {
            this.countryCode = getString(R.string.b3a);
            if (this.countryCode.startsWith("+")) {
                this.countryCode = this.countryCode.substring(1);
            }
        }
        this.grI.setText("+" + this.countryCode);
        if (this.grJ == null || this.grJ.equals("")) {
            g.RS().a(new a() {
                String ekv;

                public final boolean acg() {
                    AppMethodBeat.i(13460);
                    if (bo.isNullOrNil((BindMContactUI.this.grE.getText()).trim())) {
                        if (bo.isNullOrNil(this.ekv)) {
                            BindMContactUI.this.grE.setText("");
                        } else {
                            BindMContactUI.this.grE.setText(this.ekv);
                            BindMContactUI.this.grE.setSelection(this.ekv.length());
                        }
                    }
                    AppMethodBeat.o(13460);
                    return true;
                }

                public final boolean acf() {
                    AppMethodBeat.i(13461);
                    this.ekv = ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getPhoneNum(BindMContactUI.this, BindMContactUI.this.countryCode);
                    AppMethodBeat.o(13461);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(13462);
                    String str = super.toString() + "|initView";
                    AppMethodBeat.o(13462);
                    return str;
                }
            });
        } else {
            this.grE.setText(this.grJ);
            this.grE.setSelection(this.grJ.length());
        }
        addTextOptionMenu(0, getString(R.string.s1), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i = 0;
                AppMethodBeat.i(13463);
                BindMContactUI.this.cFl = BindMContactUI.this.grI.getText().toString().trim() + bo.PA(BindMContactUI.this.grE.getText().toString());
                if (!com.tencent.mm.pluginsdk.a.aij(BindMContactUI.this.cFl) || bo.PA(BindMContactUI.this.grE.getText().toString()).length() <= 0) {
                    h.g(BindMContactUI.this, R.string.a70, R.string.tz);
                    AppMethodBeat.o(13463);
                } else {
                    ab.i("MicroMsg.BindMContactUI", "nextStep %d", Integer.valueOf(BindMContactUI.f(BindMContactUI.this)));
                    String m;
                    boolean booleanValue;
                    BindMContactUI bindMContactUI;
                    Object[] objArr;
                    switch (BindMContactUI.f(BindMContactUI.this)) {
                        case 0:
                            h.b(BindMContactUI.this, BindMContactUI.this.getString(R.string.a7c), "", true);
                            break;
                        case 1:
                            ab.i("MicroMsg.BindMContactUI", "do next, send sms to self");
                            BindMContactUI.b(BindMContactUI.this, BindMContactUI.this.cFl);
                            break;
                        case 2:
                            int i2;
                            m = b.m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.b3_));
                            booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            bindMContactUI = BindMContactUI.this;
                            objArr = new Object[5];
                            objArr[0] = aa.dor();
                            objArr[1] = m;
                            objArr[2] = "setting";
                            objArr[3] = Integer.valueOf(1);
                            if (booleanValue) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            objArr[4] = Integer.valueOf(i2);
                            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, bindMContactUI.getString(R.string.g7o, objArr), 30767, true);
                            break;
                        case 3:
                            m = b.m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.b3_));
                            booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            bindMContactUI = BindMContactUI.this;
                            objArr = new Object[5];
                            objArr[0] = aa.dor();
                            objArr[1] = m;
                            objArr[2] = "login";
                            objArr[3] = Integer.valueOf(1);
                            if (booleanValue) {
                                i = 1;
                            }
                            objArr[4] = Integer.valueOf(i);
                            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, bindMContactUI.getString(R.string.g7o, objArr), 30766, true);
                            break;
                        case 4:
                            m = b.m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.b3_));
                            booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            bindMContactUI = BindMContactUI.this;
                            objArr = new Object[5];
                            objArr[0] = aa.dor();
                            objArr[1] = m;
                            objArr[2] = "bindMobileA";
                            objArr[3] = Integer.valueOf(1);
                            if (booleanValue) {
                                i = 1;
                            }
                            objArr[4] = Integer.valueOf(i);
                            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, bindMContactUI.getString(R.string.g7o, objArr), 30767, true);
                            break;
                        case 5:
                            m = b.m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.b3_));
                            booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            bindMContactUI = BindMContactUI.this;
                            objArr = new Object[5];
                            objArr[0] = aa.dor();
                            objArr[1] = m;
                            objArr[2] = "bindMobileB";
                            objArr[3] = Integer.valueOf(1);
                            if (booleanValue) {
                                i = 1;
                            }
                            objArr[4] = Integer.valueOf(i);
                            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, bindMContactUI.getString(R.string.g7o, objArr), 30767, true);
                            break;
                        case 6:
                            m = b.m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.b3_));
                            booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            bindMContactUI = BindMContactUI.this;
                            objArr = new Object[5];
                            objArr[0] = aa.dor();
                            objArr[1] = m;
                            objArr[2] = "bindMobileC";
                            objArr[3] = Integer.valueOf(1);
                            if (booleanValue) {
                                i = 1;
                            }
                            objArr[4] = Integer.valueOf(i);
                            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, bindMContactUI.getString(R.string.g7o, objArr), 30767, true);
                            break;
                        case 7:
                            m = b.m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.b3_));
                            booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            bindMContactUI = BindMContactUI.this;
                            objArr = new Object[5];
                            objArr[0] = aa.dor();
                            objArr[1] = m;
                            objArr[2] = "bindMobileD";
                            objArr[3] = Integer.valueOf(1);
                            if (booleanValue) {
                                i = 1;
                            }
                            objArr[4] = Integer.valueOf(i);
                            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, bindMContactUI.getString(R.string.g7o, objArr), 30767, true);
                            break;
                    }
                    AppMethodBeat.o(13463);
                }
                return true;
            }
        });
        this.grE.requestFocus();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13464);
                BindMContactUI.g(BindMContactUI.this);
                AppMethodBeat.o(13464);
                return true;
            }
        });
        this.grF.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13465);
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMContactUI.this.fHE);
                intent.putExtra("couttry_code", BindMContactUI.this.countryCode);
                com.tencent.mm.plugin.account.a.a.gkE.b(intent, BindMContactUI.this);
                AppMethodBeat.o(13465);
            }
        });
        AppMethodBeat.o(13472);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13473);
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.fHE = bo.bc(intent.getStringExtra("country_name"), "");
                this.countryCode = bo.bc(intent.getStringExtra("couttry_code"), "");
                if (!this.fHE.equals("")) {
                    this.grH.setText(this.fHE);
                }
                if (!this.countryCode.equals("")) {
                    this.grI.setText("+" + this.countryCode);
                    break;
                }
                break;
        }
        Bundle bundleExtra;
        switch (i) {
            case 30765:
                if (intent != null) {
                    bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("birthdayComfirmOK")) {
                        vL(this.cFl);
                        break;
                    }
                }
                break;
            case 30766:
                if (intent != null) {
                    bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("agree_privacy")) {
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(13466);
                                com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, BindMContactUI.this.getString(R.string.g7l, new Object[]{aa.dor()}), 30765, true);
                                com.tencent.mm.ui.base.b.hN(BindMContactUI.this);
                                AppMethodBeat.o(13466);
                            }
                        }, 100);
                    }
                    AppMethodBeat.o(13473);
                    return;
                }
                break;
            case 30767:
                if (intent != null) {
                    bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("agree_privacy")) {
                        vL(this.cFl);
                    }
                    AppMethodBeat.o(13473);
                    return;
                }
                break;
        }
        AppMethodBeat.o(13473);
    }

    private void vL(final String str) {
        AppMethodBeat.i(13474);
        if (this.gro == null) {
            i.b bVar = i.b.BINDMOBILE;
            if (this.fromScene == 3) {
                bVar = i.b.CHANGEMOBILE;
            }
            this.gro = new i(bVar, this, new i.a() {
                public final void e(int i, Bundle bundle) {
                    AppMethodBeat.i(13467);
                    if (i == 1) {
                        ab.i("MicroMsg.BindMContactUI", "next to BindMContactVerifyUI for bind mobile");
                        Intent intent = new Intent(BindMContactUI.this, BindMContactVerifyUI.class);
                        intent.putExtra("bindmcontact_mobile", str);
                        intent.putExtra("KEnterFromBanner", BindMContactUI.this.gqB);
                        intent.putExtra("bind_scene", BindMContactUI.this.fromScene);
                        MMWizardActivity.J(BindMContactUI.this, intent);
                    }
                    AppMethodBeat.o(13467);
                }
            });
        }
        this.gro.wn(str);
        AppMethodBeat.o(13474);
    }

    public final int getLayoutId() {
        return R.layout.gg;
    }

    static /* synthetic */ void a(BindMContactUI bindMContactUI) {
        AppMethodBeat.i(13475);
        bindMContactUI.Ni(1);
        AppMethodBeat.o(13475);
    }

    static /* synthetic */ int f(BindMContactUI bindMContactUI) {
        String str;
        AppMethodBeat.i(13476);
        String bc = bo.bc((String) g.RP().Ry().get(274436, null), "CN");
        boolean equalsIgnoreCase = "CN".equalsIgnoreCase(bc);
        boolean sO = b.sO(bc);
        ab.i("MicroMsg.BindMContactUI", "regCountry %s, gdpr %s", bc, Boolean.valueOf(sO));
        String str2 = (String) g.RP().Ry().get(6, null);
        String str3 = "";
        if (bo.isNullOrNil(str2)) {
            str = str2;
        } else {
            str = av.Ps(str2);
            str3 = b.m(bindMContactUI, str, bindMContactUI.getString(R.string.b3_));
        }
        if (bo.isNullOrNil(str3)) {
            str3 = bc;
        }
        boolean equalsIgnoreCase2 = "CN".equalsIgnoreCase(str3);
        boolean sO2 = b.sO(str3);
        ab.i("MicroMsg.BindMContactUI", "curBindMobile %s, curBindIso %s, gdpr %s", str, str3, Boolean.valueOf(sO2));
        boolean equals = bindMContactUI.countryCode.equals("86");
        boolean sP = b.sP(bindMContactUI.countryCode);
        ab.i("MicroMsg.BindMContactUI", "countryCode %s, gdpr %s", bindMContactUI.countryCode, Boolean.valueOf(sP));
        if (equals) {
            if (d.vxp) {
                if (equalsIgnoreCase) {
                    if (!equalsIgnoreCase2) {
                        if (sO2) {
                            AppMethodBeat.o(13476);
                            return 5;
                        }
                        AppMethodBeat.o(13476);
                        return 4;
                    }
                } else if (sO) {
                    AppMethodBeat.o(13476);
                    return 6;
                } else if (sO2) {
                    AppMethodBeat.o(13476);
                    return 6;
                } else {
                    AppMethodBeat.o(13476);
                    return 7;
                }
            }
        } else if (equalsIgnoreCase) {
            if (sP) {
                AppMethodBeat.o(13476);
                return 0;
            }
            AppMethodBeat.o(13476);
            return 2;
        } else if (!sO && sP) {
            AppMethodBeat.o(13476);
            return 3;
        }
        AppMethodBeat.o(13476);
        return 1;
    }
}
