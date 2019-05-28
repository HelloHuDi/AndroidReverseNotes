package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C32617po;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI */
public class ConfirmScanBankCardResultUI extends MMActivity {
    protected static final Map<String, Bitmap> qcf = new HashMap();
    protected Bitmap mBmp = null;
    private String qce = null;
    private ImageView qcg;
    private EditText qch;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI$1 */
    class C216911 implements OnClickListener {
        C216911() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81010);
            if (ConfirmScanBankCardResultUI.this.qch != null) {
                String obj = ConfirmScanBankCardResultUI.this.qch.getEditableText().toString();
                if (C5046bo.isNullOrNil(obj)) {
                    AppMethodBeat.m2505o(81010);
                    return;
                }
                C32617po c32617po = new C32617po();
                c32617po.cLL.action = 1;
                c32617po.cLL.cardNum = obj;
                C4879a.xxA.mo10055m(c32617po);
                ConfirmScanBankCardResultUI.m33207b(ConfirmScanBankCardResultUI.this);
            }
            AppMethodBeat.m2505o(81010);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI$2 */
    class C216922 implements OnMenuItemClickListener {
        C216922() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(81011);
            ConfirmScanBankCardResultUI.this.finish();
            AppMethodBeat.m2505o(81011);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m33207b(ConfirmScanBankCardResultUI confirmScanBankCardResultUI) {
        AppMethodBeat.m2504i(81016);
        super.finish();
        AppMethodBeat.m2505o(81016);
    }

    static {
        AppMethodBeat.m2504i(81017);
        AppMethodBeat.m2505o(81017);
    }

    /* renamed from: c */
    public static void m33208c(Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(81012);
        if (bitmap == null || bitmap.isRecycled() || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(81012);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(C4996ah.getContext(), ConfirmScanBankCardResultUI.class);
        intent.addFlags(268435456);
        intent.putExtra("_card_num_", str);
        String concat = "_image_cache_key_".concat(String.valueOf(str));
        qcf.put(concat, bitmap);
        intent.putExtra("_image_cache_key_", concat);
        C4996ah.getContext().startActivity(intent);
        AppMethodBeat.m2505o(81012);
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        AppMethodBeat.m2504i(81013);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.dz3);
        if (getIntent() == null) {
            C4990ab.m7412e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
            obj = null;
        } else {
            this.qce = getIntent().getStringExtra("_image_cache_key_");
            if (C5046bo.isNullOrNil(this.qce)) {
                C4990ab.m7412e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
                obj = null;
            } else {
                this.mBmp = (Bitmap) qcf.get(this.qce);
                if (this.mBmp == null || this.mBmp.isRecycled()) {
                    C4990ab.m7412e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
        }
        if (obj == null) {
            finish();
            AppMethodBeat.m2505o(81013);
            return;
        }
        String stringExtra = getIntent().getStringExtra("_card_num_");
        if (C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7412e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
            finish();
            AppMethodBeat.m2505o(81013);
            return;
        }
        this.qcg = (ImageView) findViewById(2131822949);
        this.qch = (EditText) findViewById(2131822950);
        this.qcg.setImageBitmap(this.mBmp);
        this.qch.setText(stringExtra);
        findViewById(2131822951).setOnClickListener(new C216911());
        setBackBtn(new C216922());
        AppMethodBeat.m2505o(81013);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(81014);
        super.onDestroy();
        if (this.qcg != null) {
            this.qcg.setImageBitmap(null);
        }
        if (!C5046bo.isNullOrNil(this.qce)) {
            qcf.remove(this.qce);
        }
        if (this.mBmp != null) {
            C4990ab.m7417i("MicroMsg.ConfirmScanBankCardResultUI", "bitmap recycle %s", this.mBmp.toString());
            this.mBmp.recycle();
        }
        AppMethodBeat.m2505o(81014);
    }

    public void finish() {
        AppMethodBeat.m2504i(81015);
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("scan_bankcard_with_confirm_ui", true);
        intent.addFlags(268435456);
        intent.setClass(this, BaseScanUI.class);
        startActivity(intent);
        super.finish();
        AppMethodBeat.m2505o(81015);
    }

    public final int getLayoutId() {
        return 2130969192;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
