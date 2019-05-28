package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125441);
        super.onCreate(bundle);
        this.hint = getIntent().getStringExtra("kintent_hint");
        this.gHY = getIntent().getBooleanExtra("kintent_cancelable", true);
        this.gGG = getIntent().getBooleanExtra("from_unbind", false);
        g.Rg().a(384, (f) this);
        g.Rg().a(255, (f) this);
        initView();
        byte[] anf = bo.anf(ax.ZQ().getString("_auth_key", ""));
        gf gfVar = new gf();
        if (bo.cb(anf)) {
            this.gGJ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        } else {
            this.gGJ = new SKBuiltinBuffer_t().setBuffer(anf);
            try {
                gfVar.parseFrom(anf);
            } catch (IOException e) {
                ab.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", e, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
            }
        }
        g.Rg().a(new r(1), 0);
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.rd), false, null);
        AppMethodBeat.o(125441);
    }

    public void onDestroy() {
        AppMethodBeat.i(125442);
        super.onDestroy();
        g.Rg().b(384, (f) this);
        g.Rg().b(255, (f) this);
        AppMethodBeat.o(125442);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(125443);
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("setpwd_ticket");
        ab.i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", stringExtra);
        if (!bo.isNullOrNil(stringExtra)) {
            this.cxb = stringExtra;
            this.gGI = 4;
            this.gGE.setVisibility(8);
            this.gGB.setVisibility(8);
        }
        AppMethodBeat.o(125443);
    }

    public final int getLayoutId() {
        return R.layout.ao5;
    }

    public final void initView() {
        AppMethodBeat.i(125444);
        if (!this.gHY) {
            dyf();
        }
        setMMTitle((int) R.string.dm0);
        this.gGA = (TextView) findViewById(R.id.dw7);
        this.gGC = findViewById(R.id.dxz);
        this.gDQ = (TextView) findViewById(R.id.dxy);
        this.gGD = (TextView) findViewById(R.id.dy0);
        if (this.hint != null && this.hint.length() > 0) {
            this.gDQ.setText(this.hint);
        }
        this.gGE = findViewById(R.id.dy1);
        this.gGF = (EditText) this.gGE.findViewById(R.id.dy3);
        this.gGB = findViewById(R.id.dy8);
        this.gGB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125438);
                final String str = (String) g.RP().Ry().get(6, null);
                if (bo.isNullOrNil(str)) {
                    ab.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
                    final Intent intent = new Intent(RegByMobileSetPwdUI.this, BindMContactUI.class);
                    intent.putExtra("bind_scene", 4);
                    h.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(R.string.dlu), "", RegByMobileSetPwdUI.this.getString(R.string.a8x), RegByMobileSetPwdUI.this.getString(R.string.or), true, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125436);
                            MMWizardActivity.J(RegByMobileSetPwdUI.this, intent);
                            AppMethodBeat.o(125436);
                        }
                    }, null);
                    AppMethodBeat.o(125438);
                    return;
                }
                ab.i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
                h.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(R.string.dls, new Object[]{str}), "", RegByMobileSetPwdUI.this.getString(R.string.tf), RegByMobileSetPwdUI.this.getString(R.string.or), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125437);
                        Intent intent = new Intent(RegByMobileSetPwdUI.this, MobileVerifyUI.class);
                        intent.putExtra("bindmcontact_mobile", str);
                        intent.putExtra("mobile_verify_purpose", 5);
                        RegByMobileSetPwdUI.this.startActivityForResult(intent, 10001);
                        AppMethodBeat.o(125437);
                    }
                }, null);
                AppMethodBeat.o(125438);
            }
        });
        if (this.gGG || !g.RN().QY()) {
            this.gGC.setVisibility(8);
        } else {
            this.gGC.setVisibility(0);
            String YA = com.tencent.mm.model.r.YA();
            if (bo.isNullOrNil(YA)) {
                YA = com.tencent.mm.model.r.Yz();
                if (ad.aoA(YA)) {
                    YA = null;
                }
            }
            if (bo.isNullOrNil(YA)) {
                YA = (String) g.RP().Ry().get(6, null);
                String str = (String) g.RP().Ry().get(5, null);
                if (!bo.isNullOrNil(YA)) {
                    if (bo.ant(YA).booleanValue()) {
                        String replace;
                        av avVar = new av();
                        str = "86";
                        if (YA.startsWith("+")) {
                            replace = YA.replace("+", "");
                            YA = av.Ps(replace);
                            if (YA != null) {
                                replace = replace.substring(YA.length());
                                str = YA;
                            } else {
                                str = YA;
                            }
                        } else {
                            replace = YA;
                        }
                        YA = av.formatNumber(str, replace);
                        this.gGD.setText(R.string.e8g);
                        this.gGA.setText(YA);
                    }
                    this.gDQ.setText(R.string.dm2);
                } else if (bo.isNullOrNil(str)) {
                    this.gGC.setVisibility(8);
                } else {
                    this.gGA.setText(str);
                    this.gGD.setText(R.string.e6k);
                    this.gDQ.setText(R.string.dm1);
                }
            } else {
                this.gGD.setText(R.string.ecn);
                this.gGA.setText(YA);
            }
        }
        ars();
        AppMethodBeat.o(125444);
    }

    private void ars() {
        AppMethodBeat.i(125445);
        TextView textView = (TextView) findViewById(R.id.dy2);
        TextView textView2 = (TextView) findViewById(R.id.dy4);
        TextView textView3 = (TextView) findViewById(R.id.dy6);
        EditText editText = (EditText) findViewById(R.id.dy5);
        EditText editText2 = (EditText) findViewById(R.id.dy7);
        if (!aa.don()) {
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
        AppMethodBeat.o(125445);
    }

    /* Access modifiers changed, original: protected|final */
    public final String arl() {
        AppMethodBeat.i(125446);
        String obj = ((EditText) findViewById(R.id.dy5)).getText().toString();
        AppMethodBeat.o(125446);
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final m ark() {
        AppMethodBeat.i(125447);
        if (bo.isNullOrNil(this.cxb)) {
            this.cxb = (String) g.RP().Ry().get(77830, null);
        }
        x xVar = new x(this.gHW, this.cxb, this.gGI, this.gGJ);
        AppMethodBeat.o(125447);
        return xVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final String arm() {
        AppMethodBeat.i(125448);
        String obj = ((EditText) findViewById(R.id.dy7)).getText().toString();
        AppMethodBeat.o(125448);
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final void art() {
        AppMethodBeat.i(125449);
        if (bo.isNullOrNil(this.cxb) && this.gGH) {
            g.Rg().a(new com.tencent.mm.modelsimple.aa(this.gGF.getText().toString(), "", "", ""), 0);
            getString(R.string.tz);
            this.ehJ = h.b((Context) this, getString(R.string.th), false, null);
            AppMethodBeat.o(125449);
            return;
        }
        super.art();
        AppMethodBeat.o(125449);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        AppMethodBeat.i(125450);
        switch (aVar) {
            case TwoPasswordsNotMatch:
                h.g(this, R.string.dll, R.string.dln);
                AppMethodBeat.o(125450);
                return;
            case BeyondMaximumLength:
                h.g(this, R.string.dlm, R.string.dln);
                AppMethodBeat.o(125450);
                return;
            case DisallowShortNumericPassword:
                h.g(this, R.string.f0r, R.string.dln);
                AppMethodBeat.o(125450);
                return;
            case NotReachMinimumLength:
                h.g(this, R.string.f0t, R.string.dln);
                break;
        }
        AppMethodBeat.o(125450);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean k(int i, int i2, String str) {
        AppMethodBeat.i(125451);
        if (i == 0 && i2 == 0) {
            finish();
            AppMethodBeat.o(125451);
            return true;
        }
        boolean j = j(i, i2, str);
        AppMethodBeat.o(125451);
        return j;
    }

    public final boolean aru() {
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125452);
        ab.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", Integer.valueOf(i2), str, mVar);
        super.onSceneEnd(i, i2, str, mVar);
        if (mVar.getType() == 255) {
            if (((r) mVar).fPs == 1) {
                if (i == 0 && i2 == 0) {
                    this.gGE.setVisibility(0);
                    this.gGB.setVisibility(0);
                    this.gGH = true;
                    AppMethodBeat.o(125452);
                    return;
                } else if (i2 == -3 && i == 4) {
                    this.gGH = false;
                    AppMethodBeat.o(125452);
                    return;
                } else {
                    this.gGE.setVisibility(0);
                    this.gGB.setVisibility(0);
                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        ab.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", Integer.valueOf(i2), Integer.valueOf(jY.showType), jY.url, jY.desc);
                        h.a((Context) this, jY.desc, jY.Title, false, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125439);
                                RegByMobileSetPwdUI.this.finish();
                                AppMethodBeat.o(125439);
                            }
                        });
                    }
                    AppMethodBeat.o(125452);
                    return;
                }
            }
        } else if (mVar.getType() == 384) {
            if (i == 0 && i2 == 0) {
                g.RP().Ry().set(77830, ((com.tencent.mm.modelsimple.aa) mVar).agg());
                arJ();
                AppMethodBeat.o(125452);
                return;
            }
            h.g(this, R.string.dlw, R.string.tz);
        }
        AppMethodBeat.o(125452);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(125453);
        if (i == 10001 && i2 == -1) {
            String stringExtra = intent.getStringExtra("setpwd_ticket");
            ab.i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", stringExtra);
            if (!bo.isNullOrNil(stringExtra)) {
                this.cxb = stringExtra;
                this.gGI = 6;
                this.gGE.setVisibility(8);
                this.gGB.setVisibility(8);
            }
        }
        AppMethodBeat.o(125453);
    }
}
