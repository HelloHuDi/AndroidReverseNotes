package com.tencent.mm.plugin.scanner.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.po;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class ConfirmScanBankCardResultUI extends MMActivity {
    protected static final Map<String, Bitmap> qcf = new HashMap();
    protected Bitmap mBmp = null;
    private String qce = null;
    private ImageView qcg;
    private EditText qch;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(ConfirmScanBankCardResultUI confirmScanBankCardResultUI) {
        AppMethodBeat.i(81016);
        super.finish();
        AppMethodBeat.o(81016);
    }

    static {
        AppMethodBeat.i(81017);
        AppMethodBeat.o(81017);
    }

    public static void c(Bitmap bitmap, String str) {
        AppMethodBeat.i(81012);
        if (bitmap == null || bitmap.isRecycled() || bo.isNullOrNil(str)) {
            AppMethodBeat.o(81012);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(ah.getContext(), ConfirmScanBankCardResultUI.class);
        intent.addFlags(268435456);
        intent.putExtra("_card_num_", str);
        String concat = "_image_cache_key_".concat(String.valueOf(str));
        qcf.put(concat, bitmap);
        intent.putExtra("_image_cache_key_", concat);
        ah.getContext().startActivity(intent);
        AppMethodBeat.o(81012);
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        AppMethodBeat.i(81013);
        super.onCreate(bundle);
        setMMTitle((int) R.string.dz3);
        if (getIntent() == null) {
            ab.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
            obj = null;
        } else {
            this.qce = getIntent().getStringExtra("_image_cache_key_");
            if (bo.isNullOrNil(this.qce)) {
                ab.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
                obj = null;
            } else {
                this.mBmp = (Bitmap) qcf.get(this.qce);
                if (this.mBmp == null || this.mBmp.isRecycled()) {
                    ab.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
        }
        if (obj == null) {
            finish();
            AppMethodBeat.o(81013);
            return;
        }
        String stringExtra = getIntent().getStringExtra("_card_num_");
        if (bo.isNullOrNil(stringExtra)) {
            ab.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
            finish();
            AppMethodBeat.o(81013);
            return;
        }
        this.qcg = (ImageView) findViewById(R.id.b10);
        this.qch = (EditText) findViewById(R.id.b11);
        this.qcg.setImageBitmap(this.mBmp);
        this.qch.setText(stringExtra);
        findViewById(R.id.b12).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(81010);
                if (ConfirmScanBankCardResultUI.this.qch != null) {
                    String obj = ConfirmScanBankCardResultUI.this.qch.getEditableText().toString();
                    if (bo.isNullOrNil(obj)) {
                        AppMethodBeat.o(81010);
                        return;
                    }
                    po poVar = new po();
                    poVar.cLL.action = 1;
                    poVar.cLL.cardNum = obj;
                    com.tencent.mm.sdk.b.a.xxA.m(poVar);
                    ConfirmScanBankCardResultUI.b(ConfirmScanBankCardResultUI.this);
                }
                AppMethodBeat.o(81010);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(81011);
                ConfirmScanBankCardResultUI.this.finish();
                AppMethodBeat.o(81011);
                return true;
            }
        });
        AppMethodBeat.o(81013);
    }

    public void onDestroy() {
        AppMethodBeat.i(81014);
        super.onDestroy();
        if (this.qcg != null) {
            this.qcg.setImageBitmap(null);
        }
        if (!bo.isNullOrNil(this.qce)) {
            qcf.remove(this.qce);
        }
        if (this.mBmp != null) {
            ab.i("MicroMsg.ConfirmScanBankCardResultUI", "bitmap recycle %s", this.mBmp.toString());
            this.mBmp.recycle();
        }
        AppMethodBeat.o(81014);
    }

    public void finish() {
        AppMethodBeat.i(81015);
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("scan_bankcard_with_confirm_ui", true);
        intent.addFlags(268435456);
        intent.setClass(this, BaseScanUI.class);
        startActivity(intent);
        super.finish();
        AppMethodBeat.o(81015);
    }

    public final int getLayoutId() {
        return R.layout.pw;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
