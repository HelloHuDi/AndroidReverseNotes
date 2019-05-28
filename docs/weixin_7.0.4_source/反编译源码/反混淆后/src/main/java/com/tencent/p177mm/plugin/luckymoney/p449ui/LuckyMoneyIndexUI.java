package com.tencent.p177mm.plugin.luckymoney.p449ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.plugin.luckymoney.model.C21200i;
import com.tencent.p177mm.plugin.luckymoney.model.C3381ag;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C21249h.C21253c;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI */
public class LuckyMoneyIndexUI extends LuckyMoneyBaseUI {
    private int obL;
    private LinearLayout oeG;
    private LinearLayout oeH;
    private LinearLayout oeI;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI$2 */
    class C34082 implements OnClickListener {
        C34082() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42722);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
            LuckyMoneyIndexUI.m32597a(LuckyMoneyIndexUI.this, 0);
            AppMethodBeat.m2505o(42722);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI$3 */
    class C34093 implements OnClickListener {
        C34093() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42723);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
            LuckyMoneyIndexUI.m32597a(LuckyMoneyIndexUI.this, 1);
            AppMethodBeat.m2505o(42723);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI$4 */
    class C124444 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI$4$1 */
        class C124451 implements C30382d {
            C124451() {
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                int i3 = 1;
                AppMethodBeat.m2504i(42724);
                switch (i2) {
                    case 1:
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6));
                        break;
                    default:
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5));
                        i3 = 2;
                        break;
                }
                Intent intent = new Intent();
                intent.setClass(LuckyMoneyIndexUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
                intent.putExtra("key_type", i3);
                LuckyMoneyIndexUI.this.startActivity(intent);
                AppMethodBeat.m2505o(42724);
            }
        }

        C124444() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42725);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
            List linkedList = new LinkedList();
            List linkedList2 = new LinkedList();
            linkedList.add(LuckyMoneyIndexUI.this.getString(C25738R.string.crm));
            linkedList2.add(Integer.valueOf(0));
            linkedList.add(LuckyMoneyIndexUI.this.getString(C25738R.string.cro));
            linkedList2.add(Integer.valueOf(1));
            C30379h.m48420a(LuckyMoneyIndexUI.this.mController.ylL, "", linkedList, linkedList2, "", false, new C124451());
            AppMethodBeat.m2505o(42725);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI$1 */
    class C212231 implements OnMenuItemClickListener {
        C212231() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42721);
            LuckyMoneyIndexUI.this.finish();
            AppMethodBeat.m2505o(42721);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42726);
        super.onCreate(bundle);
        ((C40167b) C1720g.m3528K(C40167b.class)).mo38286a(this, null);
        initView();
        mo24301b(new C3381ag("v1.0", ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(0))).intValue(), (byte) 0), false);
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        C7060h.pYm.mo8381e(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        AppMethodBeat.m2505o(42726);
    }

    public void onResume() {
        AppMethodBeat.m2504i(42727);
        super.onResume();
        C40167b c40167b = (C40167b) C1720g.m3528K(C40167b.class);
        c40167b.mo38287a(this, c40167b.cTi(), null);
        AppMethodBeat.m2505o(42727);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42728);
        setMMTitle((int) C25738R.string.ctj);
        setBackBtn(new C212231());
        this.oeG = (LinearLayout) findViewById(2131825532);
        this.oeH = (LinearLayout) findViewById(2131825531);
        this.oeI = (LinearLayout) findViewById(2131825533);
        ((Button) findViewById(2131825530)).setOnClickListener(new C34082());
        ((Button) findViewById(2131825529)).setOnClickListener(new C34093());
        mo17379a(0, getString(C25738R.string.cri), (OnMenuItemClickListener) new C124444(), C5535b.TRANSPARENT_GOLD_TEXT);
        bMx();
        AppMethodBeat.m2505o(42728);
    }

    private void bMx() {
        AppMethodBeat.m2504i(42729);
        C6964a.bKN();
        C21200i bLu = C6964a.bKO().bLu();
        if (bLu == null) {
            AppMethodBeat.m2505o(42729);
            return;
        }
        ImageView imageView = (ImageView) findViewById(2131825527);
        if ((bLu.nWJ & 1) == 1) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
            imageView.setImageResource(C25738R.drawable.b_0);
            AppMethodBeat.m2505o(42729);
            return;
        }
        imageView.setImageResource(C25738R.drawable.b_1);
        AppMethodBeat.m2505o(42729);
    }

    public final int getLayoutId() {
        return 2130969983;
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42730);
        if (c1207m instanceof C3381ag) {
            if (i == 0 && i2 == 0) {
                C3381ag c3381ag = (C3381ag) c1207m;
                C21253c c21253c = new C21253c();
                c21253c.textColor = getResources().getColor(C25738R.color.f12152u6);
                c21253c.ogM = 101;
                C21249h.m32620a(this, this.oeG, c3381ag.nXf, c21253c, "Text");
                c21253c = new C21253c();
                c21253c.textColor = getResources().getColor(C25738R.color.f12152u6);
                c21253c.ogM = 100;
                C21249h.m32620a(this, this.oeH, c3381ag.nYJ, c21253c, "Text");
                c21253c = new C21253c();
                c21253c.ogM = 102;
                C21249h.m32620a(this, this.oeI, c3381ag.nYH, c21253c, "Pic");
                bMx();
            }
            AppMethodBeat.m2505o(42730);
            return true;
        }
        AppMethodBeat.m2505o(42730);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m32597a(LuckyMoneyIndexUI luckyMoneyIndexUI, int i) {
        AppMethodBeat.m2504i(42731);
        Intent intent = new Intent();
        intent.setClass(luckyMoneyIndexUI.mController.ylL, LuckyMoneyPrepareUI.class);
        intent.putExtra("key_way", 3);
        intent.putExtra("key_type", i);
        intent.putExtra("pay_channel", luckyMoneyIndexUI.obL);
        luckyMoneyIndexUI.startActivity(intent);
        AppMethodBeat.m2505o(42731);
    }
}
