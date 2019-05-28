package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView.C36055a;
import com.tencent.p177mm.plugin.luckymoney.model.C21206r;
import com.tencent.p177mm.plugin.luckymoney.model.C3383ai;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI */
public class LuckyMoneyCanShareListUI extends LuckyMoneyBaseUI {
    /* renamed from: Lp */
    private int f3576Lp = 0;
    private boolean hZu = false;
    private List<C21206r> nSx = new LinkedList();
    private boolean ocG = true;
    private String ocP = "";
    private MMLoadMoreListView odn;
    private C39343e odo;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI$1 */
    class C34011 implements OnMenuItemClickListener {
        C34011() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42636);
            LuckyMoneyCanShareListUI.this.finish();
            AppMethodBeat.m2505o(42636);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI$2 */
    class C34022 implements OnItemClickListener {
        C34022() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(42637);
            C21206r yb = LuckyMoneyCanShareListUI.this.odo.getItem((int) j);
            if (!(yb == null || C5046bo.isNullOrNil(yb.nSX))) {
                Intent intent = new Intent();
                intent.setClass(LuckyMoneyCanShareListUI.this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
                intent.putExtra("key_sendid", yb.nSX);
                LuckyMoneyCanShareListUI.this.startActivity(intent);
            }
            AppMethodBeat.m2505o(42637);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI$3 */
    class C168043 implements C36055a {
        C168043() {
        }

        /* renamed from: KB */
        public final void mo8166KB() {
            AppMethodBeat.m2504i(42638);
            if (LuckyMoneyCanShareListUI.this.ocG && !LuckyMoneyCanShareListUI.this.hZu) {
                LuckyMoneyCanShareListUI.m25880d(LuckyMoneyCanShareListUI.this);
            }
            AppMethodBeat.m2505o(42638);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyCanShareListUI() {
        AppMethodBeat.m2504i(42639);
        AppMethodBeat.m2505o(42639);
    }

    /* renamed from: d */
    static /* synthetic */ void m25880d(LuckyMoneyCanShareListUI luckyMoneyCanShareListUI) {
        AppMethodBeat.m2504i(42644);
        luckyMoneyCanShareListUI.bMr();
        AppMethodBeat.m2505o(42644);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42640);
        super.onCreate(bundle);
        initView();
        bMr();
        AppMethodBeat.m2505o(42640);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42641);
        setBackBtn(new C34011());
        this.odn = (MMLoadMoreListView) findViewById(2131825554);
        setMMTitle(getString(C25738R.string.crc));
        this.odo = new C34505f(this.mController.ylL);
        this.odn.setAdapter(this.odo);
        this.odn.setOnItemClickListener(new C34022());
        this.odn.setOnLoadMoreListener(new C168043());
        AppMethodBeat.m2505o(42641);
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42642);
        if ((c1207m instanceof C3383ai) && i == 0 && i2 == 0) {
            C3383ai c3383ai = (C3383ai) c1207m;
            LinkedList linkedList = c3383ai.nYQ.nXj;
            this.ocP = c3383ai.nYz;
            if (linkedList != null) {
                for (int i3 = 0; i3 < linkedList.size(); i3++) {
                    this.nSx.add(linkedList.get(i3));
                }
                this.f3576Lp += linkedList.size();
                this.ocG = c3383ai.bLF();
                this.hZu = false;
                this.odo.mo62229ck(this.nSx);
            }
            if (this.ocG) {
                this.odn.dzN();
            } else {
                this.odn.dzO();
            }
            AppMethodBeat.m2505o(42642);
            return true;
        }
        AppMethodBeat.m2505o(42642);
        return false;
    }

    public final int getLayoutId() {
        return 2130969987;
    }

    private void bMr() {
        AppMethodBeat.m2504i(42643);
        this.hZu = true;
        if (this.f3576Lp == 0) {
            this.ocP = "";
        }
        mo24304n(new C3383ai(10, this.f3576Lp, 3, "", "v1.0", this.ocP));
        AppMethodBeat.m2505o(42643);
    }
}
