package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C7484ax;
import com.tencent.p177mm.modelsimple.C45454x;
import com.tencent.p177mm.modelsimple.C9703aa;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactUI;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a.C18796a;
import com.tencent.p177mm.protocal.protobuf.C7260gf;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI */
public class RegByMobileSetPwdUI extends SetPwdUI {
    private String cxb = null;
    private TextView gDQ;
    private TextView gGA;
    private View gGB;
    private View gGC;
    private TextView gGD;
    public View gGE;
    public EditText gGF;
    private boolean gGG = false;
    public boolean gGH;
    private int gGI = 0;
    private SKBuiltinBuffer_t gGJ = null;
    private String hint = null;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI$1 */
    class C99881 implements OnClickListener {
        C99881() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125438);
            final String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
                final Intent intent = new Intent(RegByMobileSetPwdUI.this, BindMContactUI.class);
                intent.putExtra("bind_scene", 4);
                C30379h.m48445a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(C25738R.string.dlu), "", RegByMobileSetPwdUI.this.getString(C25738R.string.a8x), RegByMobileSetPwdUI.this.getString(C25738R.string.f9076or), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(125436);
                        MMWizardActivity.m23791J(RegByMobileSetPwdUI.this, intent);
                        AppMethodBeat.m2505o(125436);
                    }
                }, null);
                AppMethodBeat.m2505o(125438);
                return;
            }
            C4990ab.m7416i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
            C30379h.m48445a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(C25738R.string.dls, new Object[]{str}), "", RegByMobileSetPwdUI.this.getString(C25738R.string.f9221tf), RegByMobileSetPwdUI.this.getString(C25738R.string.f9076or), true, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(125437);
                    Intent intent = new Intent(RegByMobileSetPwdUI.this, MobileVerifyUI.class);
                    intent.putExtra("bindmcontact_mobile", str);
                    intent.putExtra("mobile_verify_purpose", 5);
                    RegByMobileSetPwdUI.this.startActivityForResult(intent, 10001);
                    AppMethodBeat.m2505o(125437);
                }
            }, null);
            AppMethodBeat.m2505o(125438);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI$2 */
    class C455032 implements DialogInterface.OnClickListener {
        C455032() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125439);
            RegByMobileSetPwdUI.this.finish();
            AppMethodBeat.m2505o(125439);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125441);
        super.onCreate(bundle);
        this.hint = getIntent().getStringExtra("kintent_hint");
        this.gHY = getIntent().getBooleanExtra("kintent_cancelable", true);
        this.gGG = getIntent().getBooleanExtra("from_unbind", false);
        C1720g.m3540Rg().mo14539a(384, (C1202f) this);
        C1720g.m3540Rg().mo14539a(255, (C1202f) this);
        initView();
        byte[] anf = C5046bo.anf(C7484ax.m12915ZQ().getString("_auth_key", ""));
        C7260gf c7260gf = new C7260gf();
        if (C5046bo.m7540cb(anf)) {
            this.gGJ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        } else {
            this.gGJ = new SKBuiltinBuffer_t().setBuffer(anf);
            try {
                c7260gf.parseFrom(anf);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", e, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
            }
        }
        C1720g.m3540Rg().mo14541a(new C9706r(1), 0);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9160rd), false, null);
        AppMethodBeat.m2505o(125441);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125442);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(384, (C1202f) this);
        C1720g.m3540Rg().mo14546b(255, (C1202f) this);
        AppMethodBeat.m2505o(125442);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(125443);
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("setpwd_ticket");
        C4990ab.m7417i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", stringExtra);
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.cxb = stringExtra;
            this.gGI = 4;
            this.gGE.setVisibility(8);
            this.gGB.setVisibility(8);
        }
        AppMethodBeat.m2505o(125443);
    }

    public final int getLayoutId() {
        return 2130970499;
    }

    public final void initView() {
        AppMethodBeat.m2504i(125444);
        if (!this.gHY) {
            dyf();
        }
        setMMTitle((int) C25738R.string.dm0);
        this.gGA = (TextView) findViewById(2131826877);
        this.gGC = findViewById(2131826943);
        this.gDQ = (TextView) findViewById(2131826942);
        this.gGD = (TextView) findViewById(2131826944);
        if (this.hint != null && this.hint.length() > 0) {
            this.gDQ.setText(this.hint);
        }
        this.gGE = findViewById(2131826945);
        this.gGF = (EditText) this.gGE.findViewById(2131826947);
        this.gGB = findViewById(2131826952);
        this.gGB.setOnClickListener(new C99881());
        if (this.gGG || !C1720g.m3534RN().mo5161QY()) {
            this.gGC.setVisibility(8);
        } else {
            this.gGC.setVisibility(0);
            String YA = C1853r.m3819YA();
            if (C5046bo.isNullOrNil(YA)) {
                YA = C1853r.m3846Yz();
                if (C7616ad.aoA(YA)) {
                    YA = null;
                }
            }
            if (C5046bo.isNullOrNil(YA)) {
                YA = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
                String str = (String) C1720g.m3536RP().mo5239Ry().get(5, null);
                if (!C5046bo.isNullOrNil(YA)) {
                    if (C5046bo.ant(YA).booleanValue()) {
                        String replace;
                        C5025av c5025av = new C5025av();
                        str = "86";
                        if (YA.startsWith("+")) {
                            replace = YA.replace("+", "");
                            YA = C5025av.m7481Ps(replace);
                            if (YA != null) {
                                replace = replace.substring(YA.length());
                                str = YA;
                            } else {
                                str = YA;
                            }
                        } else {
                            replace = YA;
                        }
                        YA = C5025av.formatNumber(str, replace);
                        this.gGD.setText(C25738R.string.e8g);
                        this.gGA.setText(YA);
                    }
                    this.gDQ.setText(C25738R.string.dm2);
                } else if (C5046bo.isNullOrNil(str)) {
                    this.gGC.setVisibility(8);
                } else {
                    this.gGA.setText(str);
                    this.gGD.setText(C25738R.string.e6k);
                    this.gDQ.setText(C25738R.string.dm1);
                }
            } else {
                this.gGD.setText(C25738R.string.ecn);
                this.gGA.setText(YA);
            }
        }
        ars();
        AppMethodBeat.m2505o(125444);
    }

    private void ars() {
        AppMethodBeat.m2504i(125445);
        TextView textView = (TextView) findViewById(2131826946);
        TextView textView2 = (TextView) findViewById(2131826948);
        TextView textView3 = (TextView) findViewById(2131826950);
        EditText editText = (EditText) findViewById(2131826949);
        EditText editText2 = (EditText) findViewById(2131826951);
        if (!C4988aa.don()) {
            textView.setTextSize(1, 14.0f);
            textView2.setTextSize(1, 14.0f);
            textView3.setTextSize(1, 14.0f);
            editText.setTextSize(1, 14.0f);
            editText2.setTextSize(1, 14.0f);
        }
        float measureText = this.gGD.getPaint().measureText(this.gGD.getText().toString());
        float measureText2 = textView.getPaint().measureText(textView.getText().toString());
        float measureText3 = textView2.getPaint().measureText(textView2.getText().toString());
        float max = Math.max(Math.max(Math.max(measureText, measureText3), textView3.getPaint().measureText(textView3.getText().toString())), measureText2);
        textView.setWidth((int) max);
        this.gGD.setWidth((int) max);
        textView2.setWidth((int) max);
        textView2.setWidth((int) max);
        AppMethodBeat.m2505o(125445);
    }

    /* Access modifiers changed, original: protected|final */
    public final String arl() {
        AppMethodBeat.m2504i(125446);
        String obj = ((EditText) findViewById(2131826949)).getText().toString();
        AppMethodBeat.m2505o(125446);
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final C1207m ark() {
        AppMethodBeat.m2504i(125447);
        if (C5046bo.isNullOrNil(this.cxb)) {
            this.cxb = (String) C1720g.m3536RP().mo5239Ry().get(77830, null);
        }
        C45454x c45454x = new C45454x(this.gHW, this.cxb, this.gGI, this.gGJ);
        AppMethodBeat.m2505o(125447);
        return c45454x;
    }

    /* Access modifiers changed, original: protected|final */
    public final String arm() {
        AppMethodBeat.m2504i(125448);
        String obj = ((EditText) findViewById(2131826951)).getText().toString();
        AppMethodBeat.m2505o(125448);
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final void art() {
        AppMethodBeat.m2504i(125449);
        if (C5046bo.isNullOrNil(this.cxb) && this.gGH) {
            C1720g.m3540Rg().mo14541a(new C9703aa(this.gGF.getText().toString(), "", "", ""), 0);
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9222th), false, null);
            AppMethodBeat.m2505o(125449);
            return;
        }
        super.art();
        AppMethodBeat.m2505o(125449);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo53562a(C18796a c18796a) {
        AppMethodBeat.m2504i(125450);
        switch (c18796a) {
            case TwoPasswordsNotMatch:
                C30379h.m48467g(this, C25738R.string.dll, C25738R.string.dln);
                AppMethodBeat.m2505o(125450);
                return;
            case BeyondMaximumLength:
                C30379h.m48467g(this, C25738R.string.dlm, C25738R.string.dln);
                AppMethodBeat.m2505o(125450);
                return;
            case DisallowShortNumericPassword:
                C30379h.m48467g(this, C25738R.string.f0r, C25738R.string.dln);
                AppMethodBeat.m2505o(125450);
                return;
            case NotReachMinimumLength:
                C30379h.m48467g(this, C25738R.string.f0t, C25738R.string.dln);
                break;
        }
        AppMethodBeat.m2505o(125450);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: k */
    public final boolean mo53567k(int i, int i2, String str) {
        AppMethodBeat.m2504i(125451);
        if (i == 0 && i2 == 0) {
            finish();
            AppMethodBeat.m2505o(125451);
            return true;
        }
        boolean j = mo67826j(i, i2, str);
        AppMethodBeat.m2505o(125451);
        return j;
    }

    public final boolean aru() {
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125452);
        C4990ab.m7417i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", Integer.valueOf(i2), str, c1207m);
        super.onSceneEnd(i, i2, str, c1207m);
        if (c1207m.getType() == 255) {
            if (((C9706r) c1207m).fPs == 1) {
                if (i == 0 && i2 == 0) {
                    this.gGE.setVisibility(0);
                    this.gGB.setVisibility(0);
                    this.gGH = true;
                    AppMethodBeat.m2505o(125452);
                    return;
                } else if (i2 == -3 && i == 4) {
                    this.gGH = false;
                    AppMethodBeat.m2505o(125452);
                    return;
                } else {
                    this.gGE.setVisibility(0);
                    this.gGB.setVisibility(0);
                    C42124a jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        C4990ab.m7417i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", Integer.valueOf(i2), Integer.valueOf(jY.showType), jY.url, jY.desc);
                        C30379h.m48448a((Context) this, jY.desc, jY.Title, false, new C455032());
                    }
                    AppMethodBeat.m2505o(125452);
                    return;
                }
            }
        } else if (c1207m.getType() == 384) {
            if (i == 0 && i2 == 0) {
                C1720g.m3536RP().mo5239Ry().set(77830, ((C9703aa) c1207m).agg());
                arJ();
                AppMethodBeat.m2505o(125452);
                return;
            }
            C30379h.m48467g(this, C25738R.string.dlw, C25738R.string.f9238tz);
        }
        AppMethodBeat.m2505o(125452);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(125453);
        if (i == 10001 && i2 == -1) {
            String stringExtra = intent.getStringExtra("setpwd_ticket");
            C4990ab.m7417i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", stringExtra);
            if (!C5046bo.isNullOrNil(stringExtra)) {
                this.cxb = stringExtra;
                this.gGI = 6;
                this.gGE.setVisibility(8);
                this.gGB.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(125453);
    }
}
