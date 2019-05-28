package com.tencent.p177mm.plugin.facedetect.p403ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C33251a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C45575b;
import com.tencent.p177mm.plugin.facedetect.model.C34097l;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p966b.C45916l;
import com.tencent.p177mm.plugin.facedetectlight.Utils.C43050a.C3062b;
import com.tencent.p177mm.protocal.protobuf.blr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI */
public class FaceDetectConfirmUI extends MMActivity implements C1202f {
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
    private C44275p tipDialog;

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI$8 */
    class C118158 implements OnClickListener {
        C118158() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(370);
            try {
                String str = "appid=%s";
                Object[] objArr = new Object[1];
                objArr[0] = FaceDetectConfirmUI.this.appId != null ? FaceDetectConfirmUI.this.appId : "";
                C4990ab.m7417i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", FaceDetectConfirmUI.this.lSL + "?customInfo=" + C18178q.encode(String.format(str, objArr), "UTF-8"));
                FaceDetectConfirmUI.m66290a(FaceDetectConfirmUI.this, r0);
                AppMethodBeat.m2505o(370);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", e, "alvinluo jumpToWebView exception", new Object[0]);
                AppMethodBeat.m2505o(370);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI$1 */
    class C279331 implements OnMenuItemClickListener {
        C279331() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(363);
            C4990ab.m7416i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
            FaceDetectConfirmUI.m66288a(FaceDetectConfirmUI.this);
            AppMethodBeat.m2505o(363);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI$2 */
    class C279342 implements OnCheckedChangeListener {
        C279342() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(364);
            if (z) {
                FaceDetectConfirmUI.this.lWl.setEnabled(true);
                AppMethodBeat.m2505o(364);
                return;
            }
            FaceDetectConfirmUI.this.lWl.setEnabled(false);
            AppMethodBeat.m2505o(364);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI$3 */
    class C390153 implements OnClickListener {
        C390153() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(365);
            FaceDetectConfirmUI.this.lWm.setChecked(!FaceDetectConfirmUI.this.lWm.isChecked());
            AppMethodBeat.m2505o(365);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI$5 */
    class C390165 implements OnCancelListener {
        C390165() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI$4 */
    class C390174 implements OnClickListener {
        C390174() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(366);
            C4990ab.m7411d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", Integer.valueOf(FaceDetectConfirmUI.this.lWs));
            Intent intent = new Intent(FaceDetectConfirmUI.this, FaceDetectPrepareUI.class);
            Bundle extras = FaceDetectConfirmUI.this.getIntent().getExtras();
            if (extras != null) {
                extras.putInt("check_alive_type_response", FaceDetectConfirmUI.this.lWs);
                extras.putString("key_feedback_url", FaceDetectConfirmUI.this.lSK);
                extras.putString("business_tips", FaceDetectConfirmUI.this.lSO);
                extras.putFloat("mLight_threshold", FaceDetectConfirmUI.this.lSM);
                C4990ab.m7416i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.this.lWs);
                intent.putExtras(extras);
                FaceDetectConfirmUI.this.startActivityForResult(intent, 1);
                AppMethodBeat.m2505o(366);
                return;
            }
            C4990ab.m7412e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
            AppMethodBeat.m2505o(366);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI$6 */
    class C390186 implements DialogInterface.OnClickListener {
        C390186() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(367);
            Intent intent = new Intent();
            intent.putExtra("err_code", C34097l.m55892vm(90022));
            intent.putExtra("err_msg", "get confirm info error");
            FaceDetectReporter.bsJ().mo54651c(FaceDetectConfirmUI.this.businessType, false, 3, 2, 90022);
            FaceDetectReporter.bsJ().lUB = System.currentTimeMillis();
            FaceDetectReporter.bsJ().mo54652ce(FaceDetectConfirmUI.this.iBt, FaceDetectConfirmUI.this.businessType);
            FaceDetectConfirmUI.m66289a(FaceDetectConfirmUI.this, intent);
            FaceDetectConfirmUI.this.finish();
            AppMethodBeat.m2505o(367);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m66288a(FaceDetectConfirmUI faceDetectConfirmUI) {
        AppMethodBeat.m2504i(379);
        faceDetectConfirmUI.bth();
        AppMethodBeat.m2505o(379);
    }

    public final int getLayoutId() {
        return 2130969458;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(371);
        super.onCreate(bundle);
        this.appId = getIntent().getStringExtra("k_app_id");
        this.lWq = getIntent().getStringExtra("request_verify_pre_info");
        this.iBt = getIntent().getStringExtra("key_function_name");
        this.businessType = getIntent().getIntExtra("key_business_type", -1);
        this.lWr = getIntent().getIntExtra("check_alive_type", 0);
        C4990ab.m7417i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type : %s", Integer.valueOf(this.lWr));
        C4990ab.m7417i("MicroMsg.FaceDetectConfirmUI", "carson businessType : %s", Integer.valueOf(this.businessType));
        setMMTitle(getString(C25738R.string.bju));
        setBackBtn(new C279331());
        this.lWk = (TextView) findViewById(2131823765);
        this.lWl = (Button) findViewById(2131823768);
        this.lWt = (ImageView) findViewById(2131823763);
        this.lWu = (TextView) findViewById(2131823764);
        this.lWm = (CheckBox) findViewById(2131823766);
        this.lWm.setOnCheckedChangeListener(new C279342());
        this.lWm.setVisibility(8);
        this.lWn = (TextView) findViewById(2131823767);
        this.lWn.setOnClickListener(new C390153());
        this.lWo = (TextView) findViewById(2131823769);
        this.lWl.setOnClickListener(new C390174());
        C4990ab.m7416i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b(context, getString(C25738R.string.f9260un), false, new C390165());
        C1207m c45916l = new C45916l(this.appId, this.lWq, this.lWr);
        C1720g.m3540Rg().mo14539a(1147, (C1202f) this);
        C1720g.m3540Rg().mo14541a(c45916l, 0);
        C3062b.mdr.mo68582dM(this);
        AppMethodBeat.m2505o(371);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(C33251a.CTRL_INDEX);
        C4990ab.m7417i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            this.lWp = ((C45916l) c1207m).lSG;
            this.lSJ = ((C45916l) c1207m).lSJ;
            this.lSK = ((C45916l) c1207m).lSK;
            this.lSL = ((C45916l) c1207m).lSL;
            this.lSM = ((C45916l) c1207m).lSM;
            this.lWs = ((C45916l) c1207m).lSN;
            this.lSO = ((C45916l) c1207m).lSO;
            this.lWv = ((C45916l) c1207m).lSH;
            this.lWw = ((C45916l) c1207m).lSI;
            C4990ab.m7410d("MicroMsg.FaceDetectConfirmUI", c1207m.toString());
            if (C5046bo.isNullOrNil(this.lSJ)) {
                this.lSJ = getString(C25738R.string.bjs);
            }
            dismissDialog();
            this.lWl.setEnabled(true);
            this.lWk.setText(this.lSJ);
            String format = String.format(getString(C25738R.string.bjt), new Object[]{this.lWw});
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new StyleSpan(1), 0, format.lastIndexOf(" "), 17);
            this.lWu.setText(spannableString);
            C32291o.ahp().mo43765a(this.lWv, this.lWt);
            if (this.lWp != null) {
                C4990ab.m7419v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", this.lWp.cEh, this.lWp.wOM, this.lWp.url);
                final blr blr = this.lWp;
                C4990ab.m7417i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", blr.cEh);
                format = C5046bo.isNullOrNil(blr.cEh) ? getString(C25738R.string.bjq) : blr.cEh;
                String string = C5046bo.isNullOrNil(blr.wOM) ? getString(C25738R.string.bjp) : blr.wOM;
                Spannable newSpannable = Factory.getInstance().newSpannable(format + string);
                newSpannable.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(368);
                        if (C5046bo.isNullOrNil(blr.url)) {
                            C4990ab.m7412e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
                            AppMethodBeat.m2505o(368);
                            return;
                        }
                        FaceDetectConfirmUI.m66290a(FaceDetectConfirmUI.this, blr.url);
                        AppMethodBeat.m2505o(368);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.m2504i(369);
                        textPaint.setColor(FaceDetectConfirmUI.this.getResources().getColor(C25738R.color.f12123t7));
                        AppMethodBeat.m2505o(369);
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
                this.lWo.setText(getString(C25738R.string.bjn));
                this.lWo.setOnClickListener(new C118158());
                this.lWo.setVisibility(0);
            }
        } else {
            if (C5046bo.isNullOrNil(str)) {
                str = getString(C25738R.string.bkz);
            }
            dismissDialog();
            C30379h.m48448a((Context) this, str, getString(C25738R.string.f9238tz), false, new C390186());
        }
        C1720g.m3540Rg().mo14546b(1147, (C1202f) this);
        AppMethodBeat.m2505o(C33251a.CTRL_INDEX);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(C45575b.CTRL_INDEX);
        C4990ab.m7417i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        FaceDetectReporter.bsJ().lUB = System.currentTimeMillis();
        FaceDetectReporter.bsJ().mo54652ce(this.iBt, this.businessType);
        setResult(i2, intent);
        finish();
        AppMethodBeat.m2505o(C45575b.CTRL_INDEX);
    }

    private void bth() {
        AppMethodBeat.m2504i(374);
        Intent intent = new Intent();
        intent.putExtra("err_code", C34097l.m55892vm(90024));
        intent.putExtra("err_msg", "user cancel in confirm ui");
        FaceDetectReporter.bsJ().mo54651c(this.businessType, false, 3, 1, 90024);
        FaceDetectReporter.bsJ().lUB = System.currentTimeMillis();
        FaceDetectReporter.bsJ().mo54652ce(this.iBt, this.businessType);
        setResult(0, intent);
        finish();
        AppMethodBeat.m2505o(374);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(375);
        bth();
        super.onBackPressed();
        AppMethodBeat.m2505o(375);
    }

    public void finish() {
        AppMethodBeat.m2504i(376);
        dismissDialog();
        super.finish();
        AppMethodBeat.m2505o(376);
    }

    private void dismissDialog() {
        AppMethodBeat.m2504i(377);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(377);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(378);
        super.onDestroy();
        C3062b.mdr.stop();
        AppMethodBeat.m2505o(378);
    }
}
