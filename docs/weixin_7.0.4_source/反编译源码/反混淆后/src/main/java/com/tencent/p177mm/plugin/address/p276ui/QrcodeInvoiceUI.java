package com.tencent.p177mm.plugin.address.p276ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1529bw.p1530a.C37623a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.plugin.p984j.p985a.C12328b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI */
public class QrcodeInvoiceUI extends MMActivity {
    private Dialog gII = null;
    private int gJi = 0;
    private TextView gJm;
    private C12328b gJw = null;
    private InvoiceQrcodeTextView gKA;
    private InvoiceQrcodeTextView gKB;
    private InvoiceQrcodeTextView gKC;
    private InvoiceQrcodeTextView gKD;
    private InvoiceQrcodeTextView gKE;
    private Bitmap gKF;
    private C46633o gKG = null;
    private ImageView gKH;
    private View gKI;
    private float gKJ = 0.0f;
    private OnClickListener gKK = new C100265();
    private OnClickListener gKL = new C20416();
    private InvoiceQrcodeTextView gKy;
    private InvoiceQrcodeTextView gKz;

    /* renamed from: com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI$6 */
    class C20416 implements OnClickListener {
        C20416() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(16917);
            if (view.getId() == 2131826095 && QrcodeInvoiceUI.this.gKG != null) {
                QrcodeInvoiceUI.this.showPopupWindow(view);
                QrcodeInvoiceUI.m42542d(QrcodeInvoiceUI.this);
            }
            AppMethodBeat.m2505o(16917);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI$5 */
    class C100265 implements OnClickListener {
        C100265() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(16916);
            if (view.getId() == 2131825034 && QrcodeInvoiceUI.this.gKG != null && QrcodeInvoiceUI.this.gKG.isShowing()) {
                QrcodeInvoiceUI.this.gKG.dismiss();
            }
            AppMethodBeat.m2505o(16916);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI$3 */
    class C189883 implements OnClickListener {
        C189883() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(16914);
            if (QrcodeInvoiceUI.this.gKG != null && QrcodeInvoiceUI.this.gKG.isShowing()) {
                QrcodeInvoiceUI.this.gKG.dismiss();
            }
            AppMethodBeat.m2505o(16914);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI$4 */
    class C267054 implements OnDismissListener {
        C267054() {
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(16915);
            QrcodeInvoiceUI.m42541c(QrcodeInvoiceUI.this);
            AppMethodBeat.m2505o(16915);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI$1 */
    class C267061 implements OnMenuItemClickListener {
        C267061() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16912);
            QrcodeInvoiceUI.this.setResult(0);
            QrcodeInvoiceUI.this.finish();
            AppMethodBeat.m2505o(16912);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI$2 */
    class C267072 implements OnMenuItemClickListener {
        C267072() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16913);
            Intent intent = new Intent();
            intent.setClass(QrcodeInvoiceUI.this, AddInvoiceUI.class);
            intent.putExtra("invoice_id", QrcodeInvoiceUI.this.gJi);
            QrcodeInvoiceUI.this.startActivity(intent);
            AppMethodBeat.m2505o(16913);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public QrcodeInvoiceUI() {
        AppMethodBeat.m2504i(16918);
        AppMethodBeat.m2505o(16918);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(16919);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
        this.gJi = getIntent().getIntExtra("invoice_id", 0);
        setMMTitle((int) C25738R.string.cfn);
        AppMethodBeat.m2505o(16919);
    }

    public void onResume() {
        AppMethodBeat.m2504i(16920);
        getWindow().setSoftInputMode(3);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(16920);
    }

    public final void initView() {
        AppMethodBeat.m2504i(16921);
        findViewById(2131826085);
        this.gKy = (InvoiceQrcodeTextView) findViewById(2131826087);
        if (this.gKy != null) {
            this.gKy.asd();
        }
        this.gKz = (InvoiceQrcodeTextView) findViewById(2131826088);
        if (this.gKz != null) {
            this.gKz.asd();
        }
        this.gKA = (InvoiceQrcodeTextView) findViewById(2131826089);
        if (this.gKA != null) {
            this.gKA.asd();
        }
        this.gKB = (InvoiceQrcodeTextView) findViewById(2131826090);
        if (this.gKB != null) {
            this.gKB.asd();
        }
        this.gKC = (InvoiceQrcodeTextView) findViewById(2131826091);
        if (this.gKC != null) {
            this.gKC.asd();
        }
        this.gKD = (InvoiceQrcodeTextView) findViewById(2131826092);
        if (this.gKD != null) {
            this.gKD.asd();
        }
        this.gKE = (InvoiceQrcodeTextView) findViewById(2131826093);
        if (this.gKE != null) {
            this.gKE.asd();
        }
        this.gKA.gJU = true;
        this.gKA.gJN = true;
        if (this.gJi != 0) {
            this.gJm = (TextView) findViewById(2131826086);
            this.gJw = C33045a.arR().mo44443nd(this.gJi);
            if (this.gJw == null) {
                C4990ab.m7416i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
                finish();
            }
            if (this.gJw != null && this.gJw.type != null && this.gJw.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.gJm.setText(getString(C25738R.string.cfc));
                this.gKz.setVisibility(8);
                if (this.gJw.nuJ == null || this.gJw.nuJ.equals("")) {
                    this.gKA.setVisibility(8);
                } else {
                    this.gKA.setVisibility(0);
                    this.gKA.setValStr(this.gJw.nuJ);
                }
                if (this.gJw.nuP == null || this.gJw.nuP.equals("")) {
                    this.gKB.setVisibility(8);
                } else {
                    this.gKB.setVisibility(0);
                    this.gKB.setValStr(this.gJw.nuP);
                }
                if (this.gJw.nuN == null || this.gJw.nuN.equals("")) {
                    this.gKC.setVisibility(8);
                } else {
                    this.gKC.setVisibility(0);
                    this.gKC.setValStr(this.gJw.nuN);
                }
                if (this.gJw.nuL == null || this.gJw.nuL.equals("")) {
                    this.gKD.setVisibility(8);
                } else {
                    this.gKD.setVisibility(0);
                    this.gKD.setValStr(this.gJw.nuL);
                }
                if (this.gJw.nuK == null || this.gJw.nuK.equals("")) {
                    this.gKE.setVisibility(8);
                } else {
                    this.gKE.setVisibility(0);
                    this.gKE.setValStr(this.gJw.nuK);
                }
            } else if (!(this.gJw == null || this.gJw.type == null || !this.gJw.type.equals("1"))) {
                this.gJm.setText(getString(C25738R.string.cfi));
                this.gKy.setVisibility(8);
                this.gKA.setVisibility(8);
                this.gKB.setVisibility(8);
                this.gKC.setVisibility(8);
                this.gKD.setVisibility(8);
                this.gKE.setVisibility(8);
            }
            this.gJm.setVisibility(0);
            if (this.gJw != null) {
                this.gKy.setValStr(this.gJw.title);
                this.gKz.setValStr(this.gJw.nuI);
            }
            ase();
        } else {
            C4990ab.m7416i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
            finish();
        }
        setBackBtn(new C267061());
        mo17379a(0, getString(C25738R.string.f9099pg), (OnMenuItemClickListener) new C267072(), C5535b.GREEN);
        ImageView imageView;
        View findViewById;
        TextView textView;
        if (this.gJw == null || this.gJw.nuQ == null || this.gJw.nuQ.equals("")) {
            imageView = (ImageView) findViewById(2131826095);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            findViewById = findViewById(2131826094);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            textView = (TextView) findViewById(2131826096);
            if (textView != null) {
                textView.setVisibility(8);
            }
            AppMethodBeat.m2505o(16921);
            return;
        }
        imageView = (ImageView) findViewById(2131826095);
        if (imageView != null) {
            imageView.setVisibility(0);
            this.gKF = C37623a.m63542b(this, this.gJw.nuQ, 12, 3);
            imageView.setImageBitmap(this.gKF);
            imageView.setOnClickListener(this.gKL);
        }
        findViewById = findViewById(2131826094);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        textView = (TextView) findViewById(2131826096);
        if (textView != null) {
            textView.setVisibility(0);
        }
        AppMethodBeat.m2505o(16921);
    }

    private void ase() {
        AppMethodBeat.m2504i(16922);
        if (this.gKG != null) {
            AppMethodBeat.m2505o(16922);
            return;
        }
        View inflate = View.inflate(this, 2130969877, null);
        inflate.setOnClickListener(new C189883());
        this.gKI = inflate.findViewById(2131825033);
        this.gKH = (ImageView) inflate.findViewById(2131825034);
        this.gKG = new C46633o(inflate, -1, -1, true);
        this.gKG.setClippingEnabled(false);
        this.gKG.update();
        this.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
        this.gKG.setOnDismissListener(new C267054());
        AppMethodBeat.m2505o(16922);
    }

    public void showPopupWindow(View view) {
        AppMethodBeat.m2504i(16923);
        if (!(this.gKG == null || this.gKG.isShowing())) {
            this.gKG.showAtLocation(view.getRootView(), 17, 0, 0);
            this.gKG.setFocusable(true);
            this.gKG.setTouchable(true);
            this.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
            this.gKG.setOutsideTouchable(true);
            this.gKI.setVisibility(0);
            this.gKH.setOnClickListener(this.gKK);
            this.gKH.setImageBitmap(this.gKF);
            if (this.gKF != null) {
                C4990ab.m7412e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                C4990ab.m7416i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.gKG.update();
        }
        AppMethodBeat.m2505o(16923);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(16924);
        super.onDestroy();
        AppMethodBeat.m2505o(16924);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(16925);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        C4990ab.m7410d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:".concat(String.valueOf(stringExtra)));
                        this.gKC.setValStr(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        C4990ab.m7410d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(stringExtra)));
                        this.gKC.setValStr(stringExtra);
                    }
                    AppMethodBeat.m2505o(16925);
                    return;
                }
                break;
            case 3:
                if (i2 != -1) {
                    C4990ab.m7416i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(16925);
    }

    public final int getLayoutId() {
        return 2130970215;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(16926);
        if (i == 4) {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(16926);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(16926);
        return onKeyUp;
    }

    /* renamed from: c */
    static /* synthetic */ void m42541c(QrcodeInvoiceUI qrcodeInvoiceUI) {
        AppMethodBeat.m2504i(16927);
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness > qrcodeInvoiceUI.gKJ) {
            attributes.screenBrightness = qrcodeInvoiceUI.gKJ;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
        AppMethodBeat.m2505o(16927);
    }

    /* renamed from: d */
    static /* synthetic */ void m42542d(QrcodeInvoiceUI qrcodeInvoiceUI) {
        AppMethodBeat.m2504i(16928);
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            qrcodeInvoiceUI.gKJ = attributes.screenBrightness;
            attributes.screenBrightness = 0.85f;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
        AppMethodBeat.m2505o(16928);
    }
}
