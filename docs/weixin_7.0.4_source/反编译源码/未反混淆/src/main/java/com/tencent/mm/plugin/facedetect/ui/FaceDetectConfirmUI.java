package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.b.l;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@a(3)
public class FaceDetectConfirmUI extends MMActivity implements f {
    private String appId;
    private int businessType;
    private String iBt;
    private String lSJ = null;
    private String lSK = null;
    private String lSL = null;
    private float lSM;
    private String lSO;
    private TextView lWk;
    private Button lWl;
    private CheckBox lWm;
    private TextView lWn;
    private TextView lWo;
    private blr lWp = null;
    private String lWq;
    private int lWr;
    private int lWs;
    private ImageView lWt;
    private TextView lWu;
    private String lWv;
    private String lWw;
    private p tipDialog;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FaceDetectConfirmUI faceDetectConfirmUI) {
        AppMethodBeat.i(379);
        faceDetectConfirmUI.bth();
        AppMethodBeat.o(379);
    }

    public final int getLayoutId() {
        return R.layout.x3;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(371);
        super.onCreate(bundle);
        this.appId = getIntent().getStringExtra("k_app_id");
        this.lWq = getIntent().getStringExtra("request_verify_pre_info");
        this.iBt = getIntent().getStringExtra("key_function_name");
        this.businessType = getIntent().getIntExtra("key_business_type", -1);
        this.lWr = getIntent().getIntExtra("check_alive_type", 0);
        ab.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type : %s", Integer.valueOf(this.lWr));
        ab.i("MicroMsg.FaceDetectConfirmUI", "carson businessType : %s", Integer.valueOf(this.businessType));
        setMMTitle(getString(R.string.bju));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(363);
                ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
                FaceDetectConfirmUI.a(FaceDetectConfirmUI.this);
                AppMethodBeat.o(363);
                return false;
            }
        });
        this.lWk = (TextView) findViewById(R.id.bm2);
        this.lWl = (Button) findViewById(R.id.bm5);
        this.lWt = (ImageView) findViewById(R.id.bm0);
        this.lWu = (TextView) findViewById(R.id.bm1);
        this.lWm = (CheckBox) findViewById(R.id.bm3);
        this.lWm.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(364);
                if (z) {
                    FaceDetectConfirmUI.this.lWl.setEnabled(true);
                    AppMethodBeat.o(364);
                    return;
                }
                FaceDetectConfirmUI.this.lWl.setEnabled(false);
                AppMethodBeat.o(364);
            }
        });
        this.lWm.setVisibility(8);
        this.lWn = (TextView) findViewById(R.id.bm4);
        this.lWn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(365);
                FaceDetectConfirmUI.this.lWm.setChecked(!FaceDetectConfirmUI.this.lWm.isChecked());
                AppMethodBeat.o(365);
            }
        });
        this.lWo = (TextView) findViewById(R.id.bm6);
        this.lWl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(366);
                ab.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", Integer.valueOf(FaceDetectConfirmUI.this.lWs));
                Intent intent = new Intent(FaceDetectConfirmUI.this, FaceDetectPrepareUI.class);
                Bundle extras = FaceDetectConfirmUI.this.getIntent().getExtras();
                if (extras != null) {
                    extras.putInt("check_alive_type_response", FaceDetectConfirmUI.this.lWs);
                    extras.putString("key_feedback_url", FaceDetectConfirmUI.this.lSK);
                    extras.putString("business_tips", FaceDetectConfirmUI.this.lSO);
                    extras.putFloat("mLight_threshold", FaceDetectConfirmUI.this.lSM);
                    ab.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.this.lWs);
                    intent.putExtras(extras);
                    FaceDetectConfirmUI.this.startActivityForResult(intent, 1);
                    AppMethodBeat.o(366);
                    return;
                }
                ab.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
                AppMethodBeat.o(366);
            }
        });
        ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.tipDialog = h.b(context, getString(R.string.un), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        m lVar = new l(this.appId, this.lWq, this.lWr);
        g.Rg().a(1147, (f) this);
        g.Rg().a(lVar, 0);
        b.mdr.dM(this);
        AppMethodBeat.o(371);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            this.lWp = ((l) mVar).lSG;
            this.lSJ = ((l) mVar).lSJ;
            this.lSK = ((l) mVar).lSK;
            this.lSL = ((l) mVar).lSL;
            this.lSM = ((l) mVar).lSM;
            this.lWs = ((l) mVar).lSN;
            this.lSO = ((l) mVar).lSO;
            this.lWv = ((l) mVar).lSH;
            this.lWw = ((l) mVar).lSI;
            ab.d("MicroMsg.FaceDetectConfirmUI", mVar.toString());
            if (bo.isNullOrNil(this.lSJ)) {
                this.lSJ = getString(R.string.bjs);
            }
            dismissDialog();
            this.lWl.setEnabled(true);
            this.lWk.setText(this.lSJ);
            String format = String.format(getString(R.string.bjt), new Object[]{this.lWw});
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new StyleSpan(1), 0, format.lastIndexOf(" "), 17);
            this.lWu.setText(spannableString);
            o.ahp().a(this.lWv, this.lWt);
            if (this.lWp != null) {
                ab.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", this.lWp.cEh, this.lWp.wOM, this.lWp.url);
                final blr blr = this.lWp;
                ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", blr.cEh);
                format = bo.isNullOrNil(blr.cEh) ? getString(R.string.bjq) : blr.cEh;
                String string = bo.isNullOrNil(blr.wOM) ? getString(R.string.bjp) : blr.wOM;
                Spannable newSpannable = Factory.getInstance().newSpannable(format + string);
                newSpannable.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(368);
                        if (bo.isNullOrNil(blr.url)) {
                            ab.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
                            AppMethodBeat.o(368);
                            return;
                        }
                        FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, blr.url);
                        AppMethodBeat.o(368);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.i(369);
                        textPaint.setColor(FaceDetectConfirmUI.this.getResources().getColor(R.color.t7));
                        AppMethodBeat.o(369);
                    }
                }, format.length(), format.length() + string.length(), 33);
                this.lWm.setVisibility(0);
                this.lWn.setVisibility(0);
                this.lWn.setText(newSpannable);
                this.lWn.setMovementMethod(LinkMovementMethod.getInstance());
                if (blr.wON == 0) {
                    this.lWm.setChecked(false);
                    this.lWl.setEnabled(false);
                } else if (blr.wON == 1) {
                    this.lWm.setChecked(true);
                    this.lWl.setEnabled(true);
                }
                this.lWo.setText(getString(R.string.bjn));
                this.lWo.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(370);
                        try {
                            String str = "appid=%s";
                            Object[] objArr = new Object[1];
                            objArr[0] = FaceDetectConfirmUI.this.appId != null ? FaceDetectConfirmUI.this.appId : "";
                            ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", FaceDetectConfirmUI.this.lSL + "?customInfo=" + q.encode(String.format(str, objArr), "UTF-8"));
                            FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, r0);
                            AppMethodBeat.o(370);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", e, "alvinluo jumpToWebView exception", new Object[0]);
                            AppMethodBeat.o(370);
                        }
                    }
                });
                this.lWo.setVisibility(0);
            }
        } else {
            if (bo.isNullOrNil(str)) {
                str = getString(R.string.bkz);
            }
            dismissDialog();
            h.a((Context) this, str, getString(R.string.tz), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(367);
                    Intent intent = new Intent();
                    intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.vm(90022));
                    intent.putExtra("err_msg", "get confirm info error");
                    FaceDetectReporter.bsJ().c(FaceDetectConfirmUI.this.businessType, false, 3, 2, 90022);
                    FaceDetectReporter.bsJ().lUB = System.currentTimeMillis();
                    FaceDetectReporter.bsJ().ce(FaceDetectConfirmUI.this.iBt, FaceDetectConfirmUI.this.businessType);
                    FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, intent);
                    FaceDetectConfirmUI.this.finish();
                    AppMethodBeat.o(367);
                }
            });
        }
        g.Rg().b(1147, (f) this);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        FaceDetectReporter.bsJ().lUB = System.currentTimeMillis();
        FaceDetectReporter.bsJ().ce(this.iBt, this.businessType);
        setResult(i2, intent);
        finish();
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX);
    }

    private void bth() {
        AppMethodBeat.i(374);
        Intent intent = new Intent();
        intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.vm(90024));
        intent.putExtra("err_msg", "user cancel in confirm ui");
        FaceDetectReporter.bsJ().c(this.businessType, false, 3, 1, 90024);
        FaceDetectReporter.bsJ().lUB = System.currentTimeMillis();
        FaceDetectReporter.bsJ().ce(this.iBt, this.businessType);
        setResult(0, intent);
        finish();
        AppMethodBeat.o(374);
    }

    public void onBackPressed() {
        AppMethodBeat.i(375);
        bth();
        super.onBackPressed();
        AppMethodBeat.o(375);
    }

    public void finish() {
        AppMethodBeat.i(376);
        dismissDialog();
        super.finish();
        AppMethodBeat.o(376);
    }

    private void dismissDialog() {
        AppMethodBeat.i(377);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(377);
    }

    public void onDestroy() {
        AppMethodBeat.i(378);
        super.onDestroy();
        b.mdr.stop();
        AppMethodBeat.o(378);
    }
}
