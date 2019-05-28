package com.tencent.p177mm.plugin.product.p482ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import com.tencent.p177mm.plugin.product.p481b.C12808c;
import com.tencent.p177mm.plugin.product.p481b.C12810d;
import com.tencent.p177mm.protocal.protobuf.bpz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.product.ui.MallProductReceiptUI */
public class MallProductReceiptUI extends MallBaseUI {
    private C12808c piK;
    private C12810d pja = null;
    private AutoCompleteTextView pjb = null;
    private C12828h pjc = null;

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductReceiptUI$2 */
    class C36032 implements OnItemClickListener {
        C36032() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object obj;
            AppMethodBeat.m2504i(44091);
            C12810d c = MallProductReceiptUI.this.pja;
            if (c.phg == null || i >= c.phg.size()) {
                obj = null;
            } else {
                obj = (String) c.phg.get(i);
            }
            C4990ab.m7410d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = ".concat(String.valueOf(obj)));
            if (!C5046bo.isNullOrNil(obj)) {
                MallProductReceiptUI.this.pjb.setText(obj);
            }
            AppMethodBeat.m2505o(44091);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductReceiptUI$3 */
    class C36043 implements OnClickListener {
        C36043() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44092);
            C12810d c = MallProductReceiptUI.this.pja;
            c.phg.clear();
            c.bZX();
            MallProductReceiptUI.this.pjc.notifyDataSetChanged();
            AppMethodBeat.m2505o(44092);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductReceiptUI$1 */
    class C214411 implements OnMenuItemClickListener {
        C214411() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            int i = 0;
            AppMethodBeat.m2504i(44090);
            String obj = MallProductReceiptUI.this.pjb.getText().toString();
            if (C5046bo.isNullOrNil(obj)) {
                C23639t.makeText(MallProductReceiptUI.this, C25738R.string.cxh, 0).show();
            } else {
                C12808c b = MallProductReceiptUI.this.piK;
                b.pgV = new bpz();
                bpz bpz = b.pgV;
                if (!C5046bo.isNullOrNil(obj)) {
                    i = 1;
                }
                bpz.wSm = i;
                b.pgV.naq = obj;
                MallProductReceiptUI.this.finish();
            }
            AppMethodBeat.m2505o(44090);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970393;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44093);
        super.onCreate(bundle);
        this.pja = C34676a.bZC().bZE();
        C34676a.bZC();
        this.piK = C34676a.bZD();
        initView();
        AppMethodBeat.m2505o(44093);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44094);
        setMMTitle((int) C25738R.string.cxi);
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C214411());
        this.pjb = (AutoCompleteTextView) findViewById(2131826602);
        bpz bZK = this.piK.bZK();
        if (!(bZK == null || C5046bo.isNullOrNil(bZK.naq))) {
            this.pjb.setText(bZK.naq);
        }
        this.pjb.setSelection(this.pjb.getText().length());
        this.pjc = new C12828h(this);
        this.pjb.setAdapter(this.pjc);
        this.pjb.setOnItemClickListener(new C36032());
        View.inflate(this.mController.ylL, 2130970389, null).setOnClickListener(new C36043());
        AppMethodBeat.m2505o(44094);
    }
}
