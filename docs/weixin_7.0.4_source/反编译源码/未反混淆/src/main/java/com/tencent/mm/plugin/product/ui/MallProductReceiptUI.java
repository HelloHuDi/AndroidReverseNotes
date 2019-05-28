package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

public class MallProductReceiptUI extends MallBaseUI {
    private c piK;
    private d pja = null;
    private AutoCompleteTextView pjb = null;
    private h pjc = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.al_;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44093);
        super.onCreate(bundle);
        this.pja = a.bZC().bZE();
        a.bZC();
        this.piK = a.bZD();
        initView();
        AppMethodBeat.o(44093);
    }

    public final void initView() {
        AppMethodBeat.i(44094);
        setMMTitle((int) R.string.cxi);
        addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i = 0;
                AppMethodBeat.i(44090);
                String obj = MallProductReceiptUI.this.pjb.getText().toString();
                if (bo.isNullOrNil(obj)) {
                    t.makeText(MallProductReceiptUI.this, R.string.cxh, 0).show();
                } else {
                    c b = MallProductReceiptUI.this.piK;
                    b.pgV = new bpz();
                    bpz bpz = b.pgV;
                    if (!bo.isNullOrNil(obj)) {
                        i = 1;
                    }
                    bpz.wSm = i;
                    b.pgV.naq = obj;
                    MallProductReceiptUI.this.finish();
                }
                AppMethodBeat.o(44090);
                return true;
            }
        });
        this.pjb = (AutoCompleteTextView) findViewById(R.id.dor);
        bpz bZK = this.piK.bZK();
        if (!(bZK == null || bo.isNullOrNil(bZK.naq))) {
            this.pjb.setText(bZK.naq);
        }
        this.pjb.setSelection(this.pjb.getText().length());
        this.pjc = new h(this);
        this.pjb.setAdapter(this.pjc);
        this.pjb.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object obj;
                AppMethodBeat.i(44091);
                d c = MallProductReceiptUI.this.pja;
                if (c.phg == null || i >= c.phg.size()) {
                    obj = null;
                } else {
                    obj = (String) c.phg.get(i);
                }
                ab.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = ".concat(String.valueOf(obj)));
                if (!bo.isNullOrNil(obj)) {
                    MallProductReceiptUI.this.pjb.setText(obj);
                }
                AppMethodBeat.o(44091);
            }
        });
        View.inflate(this.mController.ylL, R.layout.al6, null).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44092);
                d c = MallProductReceiptUI.this.pja;
                c.phg.clear();
                c.bZX();
                MallProductReceiptUI.this.pjc.notifyDataSetChanged();
                AppMethodBeat.o(44092);
            }
        });
        AppMethodBeat.o(44094);
    }
}
