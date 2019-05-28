package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI extends LuckyMoneyBaseUI {
    private int Lp = 0;
    private boolean hZu = false;
    private List<r> nSx = new LinkedList();
    private boolean ocG = true;
    private String ocP = "";
    private MMLoadMoreListView odn;
    private e odo;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyCanShareListUI() {
        AppMethodBeat.i(42639);
        AppMethodBeat.o(42639);
    }

    static /* synthetic */ void d(LuckyMoneyCanShareListUI luckyMoneyCanShareListUI) {
        AppMethodBeat.i(42644);
        luckyMoneyCanShareListUI.bMr();
        AppMethodBeat.o(42644);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42640);
        super.onCreate(bundle);
        initView();
        bMr();
        AppMethodBeat.o(42640);
    }

    public final void initView() {
        AppMethodBeat.i(42641);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42636);
                LuckyMoneyCanShareListUI.this.finish();
                AppMethodBeat.o(42636);
                return true;
            }
        });
        this.odn = (MMLoadMoreListView) findViewById(R.id.cxf);
        setMMTitle(getString(R.string.crc));
        this.odo = new f(this.mController.ylL);
        this.odn.setAdapter(this.odo);
        this.odn.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(42637);
                r yb = LuckyMoneyCanShareListUI.this.odo.getItem((int) j);
                if (!(yb == null || bo.isNullOrNil(yb.nSX))) {
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyCanShareListUI.this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
                    intent.putExtra("key_sendid", yb.nSX);
                    LuckyMoneyCanShareListUI.this.startActivity(intent);
                }
                AppMethodBeat.o(42637);
            }
        });
        this.odn.setOnLoadMoreListener(new a() {
            public final void KB() {
                AppMethodBeat.i(42638);
                if (LuckyMoneyCanShareListUI.this.ocG && !LuckyMoneyCanShareListUI.this.hZu) {
                    LuckyMoneyCanShareListUI.d(LuckyMoneyCanShareListUI.this);
                }
                AppMethodBeat.o(42638);
            }
        });
        AppMethodBeat.o(42641);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42642);
        if ((mVar instanceof ai) && i == 0 && i2 == 0) {
            ai aiVar = (ai) mVar;
            LinkedList linkedList = aiVar.nYQ.nXj;
            this.ocP = aiVar.nYz;
            if (linkedList != null) {
                for (int i3 = 0; i3 < linkedList.size(); i3++) {
                    this.nSx.add(linkedList.get(i3));
                }
                this.Lp += linkedList.size();
                this.ocG = aiVar.bLF();
                this.hZu = false;
                this.odo.ck(this.nSx);
            }
            if (this.ocG) {
                this.odn.dzN();
            } else {
                this.odn.dzO();
            }
            AppMethodBeat.o(42642);
            return true;
        }
        AppMethodBeat.o(42642);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.aab;
    }

    private void bMr() {
        AppMethodBeat.i(42643);
        this.hZu = true;
        if (this.Lp == 0) {
            this.ocP = "";
        }
        n(new ai(10, this.Lp, 3, "", "v1.0", this.ocP));
        AppMethodBeat.o(42643);
    }
}
