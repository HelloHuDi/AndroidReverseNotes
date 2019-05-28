package com.tencent.mm.plugin.address.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.q;

public class QrcodeInvoiceUI extends MMActivity {
    private Dialog gII = null;
    private int gJi = 0;
    private TextView gJm;
    private b gJw = null;
    private InvoiceQrcodeTextView gKA;
    private InvoiceQrcodeTextView gKB;
    private InvoiceQrcodeTextView gKC;
    private InvoiceQrcodeTextView gKD;
    private InvoiceQrcodeTextView gKE;
    private Bitmap gKF;
    private o gKG = null;
    private ImageView gKH;
    private View gKI;
    private float gKJ = 0.0f;
    private OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(16916);
            if (view.getId() == R.id.cjc && QrcodeInvoiceUI.this.gKG != null && QrcodeInvoiceUI.this.gKG.isShowing()) {
                QrcodeInvoiceUI.this.gKG.dismiss();
            }
            AppMethodBeat.o(16916);
        }
    };
    private OnClickListener gKL = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(16917);
            if (view.getId() == R.id.db2 && QrcodeInvoiceUI.this.gKG != null) {
                QrcodeInvoiceUI.this.showPopupWindow(view);
                QrcodeInvoiceUI.d(QrcodeInvoiceUI.this);
            }
            AppMethodBeat.o(16917);
        }
    };
    private InvoiceQrcodeTextView gKy;
    private InvoiceQrcodeTextView gKz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrcodeInvoiceUI() {
        AppMethodBeat.i(16918);
        AppMethodBeat.o(16918);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(16919);
        super.onCreate(bundle);
        ab.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
        this.gJi = getIntent().getIntExtra("invoice_id", 0);
        setMMTitle((int) R.string.cfn);
        AppMethodBeat.o(16919);
    }

    public void onResume() {
        AppMethodBeat.i(16920);
        getWindow().setSoftInputMode(3);
        super.onResume();
        initView();
        AppMethodBeat.o(16920);
    }

    public final void initView() {
        AppMethodBeat.i(16921);
        findViewById(R.id.das);
        this.gKy = (InvoiceQrcodeTextView) findViewById(R.id.dau);
        if (this.gKy != null) {
            this.gKy.asd();
        }
        this.gKz = (InvoiceQrcodeTextView) findViewById(R.id.dav);
        if (this.gKz != null) {
            this.gKz.asd();
        }
        this.gKA = (InvoiceQrcodeTextView) findViewById(R.id.daw);
        if (this.gKA != null) {
            this.gKA.asd();
        }
        this.gKB = (InvoiceQrcodeTextView) findViewById(R.id.dax);
        if (this.gKB != null) {
            this.gKB.asd();
        }
        this.gKC = (InvoiceQrcodeTextView) findViewById(R.id.day);
        if (this.gKC != null) {
            this.gKC.asd();
        }
        this.gKD = (InvoiceQrcodeTextView) findViewById(R.id.daz);
        if (this.gKD != null) {
            this.gKD.asd();
        }
        this.gKE = (InvoiceQrcodeTextView) findViewById(R.id.db0);
        if (this.gKE != null) {
            this.gKE.asd();
        }
        this.gKA.gJU = true;
        this.gKA.gJN = true;
        if (this.gJi != 0) {
            this.gJm = (TextView) findViewById(R.id.dat);
            this.gJw = a.arR().nd(this.gJi);
            if (this.gJw == null) {
                ab.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
                finish();
            }
            if (this.gJw != null && this.gJw.type != null && this.gJw.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.gJm.setText(getString(R.string.cfc));
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
                this.gJm.setText(getString(R.string.cfi));
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
            ab.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
            finish();
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16912);
                QrcodeInvoiceUI.this.setResult(0);
                QrcodeInvoiceUI.this.finish();
                AppMethodBeat.o(16912);
                return true;
            }
        });
        a(0, getString(R.string.pg), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16913);
                Intent intent = new Intent();
                intent.setClass(QrcodeInvoiceUI.this, AddInvoiceUI.class);
                intent.putExtra("invoice_id", QrcodeInvoiceUI.this.gJi);
                QrcodeInvoiceUI.this.startActivity(intent);
                AppMethodBeat.o(16913);
                return true;
            }
        }, q.b.GREEN);
        ImageView imageView;
        View findViewById;
        TextView textView;
        if (this.gJw == null || this.gJw.nuQ == null || this.gJw.nuQ.equals("")) {
            imageView = (ImageView) findViewById(R.id.db2);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            findViewById = findViewById(R.id.db1);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            textView = (TextView) findViewById(R.id.db3);
            if (textView != null) {
                textView.setVisibility(8);
            }
            AppMethodBeat.o(16921);
            return;
        }
        imageView = (ImageView) findViewById(R.id.db2);
        if (imageView != null) {
            imageView.setVisibility(0);
            this.gKF = com.tencent.mm.bw.a.a.b(this, this.gJw.nuQ, 12, 3);
            imageView.setImageBitmap(this.gKF);
            imageView.setOnClickListener(this.gKL);
        }
        findViewById = findViewById(R.id.db1);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        textView = (TextView) findViewById(R.id.db3);
        if (textView != null) {
            textView.setVisibility(0);
        }
        AppMethodBeat.o(16921);
    }

    private void ase() {
        AppMethodBeat.i(16922);
        if (this.gKG != null) {
            AppMethodBeat.o(16922);
            return;
        }
        View inflate = View.inflate(this, R.layout.a8c, null);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(16914);
                if (QrcodeInvoiceUI.this.gKG != null && QrcodeInvoiceUI.this.gKG.isShowing()) {
                    QrcodeInvoiceUI.this.gKG.dismiss();
                }
                AppMethodBeat.o(16914);
            }
        });
        this.gKI = inflate.findViewById(R.id.cjb);
        this.gKH = (ImageView) inflate.findViewById(R.id.cjc);
        this.gKG = new o(inflate, -1, -1, true);
        this.gKG.setClippingEnabled(false);
        this.gKG.update();
        this.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
        this.gKG.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss() {
                AppMethodBeat.i(16915);
                QrcodeInvoiceUI.c(QrcodeInvoiceUI.this);
                AppMethodBeat.o(16915);
            }
        });
        AppMethodBeat.o(16922);
    }

    public void showPopupWindow(View view) {
        AppMethodBeat.i(16923);
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
                ab.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                ab.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.gKG.update();
        }
        AppMethodBeat.o(16923);
    }

    public void onDestroy() {
        AppMethodBeat.i(16924);
        super.onDestroy();
        AppMethodBeat.o(16924);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(16925);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!bo.isNullOrNil(stringExtra)) {
                        ab.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:".concat(String.valueOf(stringExtra)));
                        this.gKC.setValStr(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bo.isNullOrNil(stringExtra)) {
                        ab.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(stringExtra)));
                        this.gKC.setValStr(stringExtra);
                    }
                    AppMethodBeat.o(16925);
                    return;
                }
                break;
            case 3:
                if (i2 != -1) {
                    ab.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
                    break;
                }
                break;
        }
        AppMethodBeat.o(16925);
    }

    public final int getLayoutId() {
        return R.layout.agh;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(16926);
        if (i == 4) {
            setResult(0);
            finish();
            AppMethodBeat.o(16926);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(16926);
        return onKeyUp;
    }

    static /* synthetic */ void c(QrcodeInvoiceUI qrcodeInvoiceUI) {
        AppMethodBeat.i(16927);
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness > qrcodeInvoiceUI.gKJ) {
            attributes.screenBrightness = qrcodeInvoiceUI.gKJ;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
        AppMethodBeat.o(16927);
    }

    static /* synthetic */ void d(QrcodeInvoiceUI qrcodeInvoiceUI) {
        AppMethodBeat.i(16928);
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            qrcodeInvoiceUI.gKJ = attributes.screenBrightness;
            attributes.screenBrightness = 0.85f;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
        AppMethodBeat.o(16928);
    }
}
