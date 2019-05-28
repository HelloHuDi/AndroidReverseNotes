package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.ui.h.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.q;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyIndexUI extends LuckyMoneyBaseUI {
    private int obL;
    private LinearLayout oeG;
    private LinearLayout oeH;
    private LinearLayout oeI;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42726);
        super.onCreate(bundle);
        ((b) g.K(b.class)).a(this, null);
        initView();
        b(new ag("v1.0", ((Integer) g.RP().Ry().get(a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(0))).intValue(), (byte) 0), false);
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        h.pYm.e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        AppMethodBeat.o(42726);
    }

    public void onResume() {
        AppMethodBeat.i(42727);
        super.onResume();
        b bVar = (b) g.K(b.class);
        bVar.a(this, bVar.cTi(), null);
        AppMethodBeat.o(42727);
    }

    public final void initView() {
        AppMethodBeat.i(42728);
        setMMTitle((int) R.string.ctj);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42721);
                LuckyMoneyIndexUI.this.finish();
                AppMethodBeat.o(42721);
                return true;
            }
        });
        this.oeG = (LinearLayout) findViewById(R.id.cwu);
        this.oeH = (LinearLayout) findViewById(R.id.cwt);
        this.oeI = (LinearLayout) findViewById(R.id.cwv);
        ((Button) findViewById(R.id.cws)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42722);
                h.pYm.e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                LuckyMoneyIndexUI.a(LuckyMoneyIndexUI.this, 0);
                AppMethodBeat.o(42722);
            }
        });
        ((Button) findViewById(R.id.cwr)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42723);
                h.pYm.e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                LuckyMoneyIndexUI.a(LuckyMoneyIndexUI.this, 1);
                AppMethodBeat.o(42723);
            }
        });
        a(0, getString(R.string.cri), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42725);
                h.pYm.e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(LuckyMoneyIndexUI.this.getString(R.string.crm));
                linkedList2.add(Integer.valueOf(0));
                linkedList.add(LuckyMoneyIndexUI.this.getString(R.string.cro));
                linkedList2.add(Integer.valueOf(1));
                com.tencent.mm.ui.base.h.a(LuckyMoneyIndexUI.this.mController.ylL, "", linkedList, linkedList2, "", false, new d() {
                    public final void bV(int i, int i2) {
                        int i3 = 1;
                        AppMethodBeat.i(42724);
                        switch (i2) {
                            case 1:
                                h.pYm.e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6));
                                break;
                            default:
                                h.pYm.e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5));
                                i3 = 2;
                                break;
                        }
                        Intent intent = new Intent();
                        intent.setClass(LuckyMoneyIndexUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", i3);
                        LuckyMoneyIndexUI.this.startActivity(intent);
                        AppMethodBeat.o(42724);
                    }
                });
                AppMethodBeat.o(42725);
                return true;
            }
        }, q.b.TRANSPARENT_GOLD_TEXT);
        bMx();
        AppMethodBeat.o(42728);
    }

    private void bMx() {
        AppMethodBeat.i(42729);
        com.tencent.mm.plugin.luckymoney.b.a.bKN();
        i bLu = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLu();
        if (bLu == null) {
            AppMethodBeat.o(42729);
            return;
        }
        ImageView imageView = (ImageView) findViewById(R.id.cwp);
        if ((bLu.nWJ & 1) == 1) {
            ab.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
            imageView.setImageResource(R.drawable.b_0);
            AppMethodBeat.o(42729);
            return;
        }
        imageView.setImageResource(R.drawable.b_1);
        AppMethodBeat.o(42729);
    }

    public final int getLayoutId() {
        return R.layout.aa8;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42730);
        if (mVar instanceof ag) {
            if (i == 0 && i2 == 0) {
                ag agVar = (ag) mVar;
                c cVar = new c();
                cVar.textColor = getResources().getColor(R.color.u6);
                cVar.ogM = 101;
                h.a(this, this.oeG, agVar.nXf, cVar, "Text");
                cVar = new c();
                cVar.textColor = getResources().getColor(R.color.u6);
                cVar.ogM = 100;
                h.a(this, this.oeH, agVar.nYJ, cVar, "Text");
                cVar = new c();
                cVar.ogM = 102;
                h.a(this, this.oeI, agVar.nYH, cVar, "Pic");
                bMx();
            }
            AppMethodBeat.o(42730);
            return true;
        }
        AppMethodBeat.o(42730);
        return false;
    }

    static /* synthetic */ void a(LuckyMoneyIndexUI luckyMoneyIndexUI, int i) {
        AppMethodBeat.i(42731);
        Intent intent = new Intent();
        intent.setClass(luckyMoneyIndexUI.mController.ylL, LuckyMoneyPrepareUI.class);
        intent.putExtra("key_way", 3);
        intent.putExtra("key_type", i);
        intent.putExtra("pay_channel", luckyMoneyIndexUI.obL);
        luckyMoneyIndexUI.startActivity(intent);
        AppMethodBeat.o(42731);
    }
}
