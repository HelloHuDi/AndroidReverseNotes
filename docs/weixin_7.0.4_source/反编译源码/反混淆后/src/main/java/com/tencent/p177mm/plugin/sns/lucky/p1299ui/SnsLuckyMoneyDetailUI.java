package com.tencent.p177mm.plugin.sns.lucky.p1299ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyBaseUI;
import com.tencent.p177mm.plugin.p444l.C3330a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI */
public class SnsLuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private ListView nSL;
    OnScrollListener nSS = new C219091();
    private final int oey = 750;
    private final int oez = 240;
    private C29041b qHe;

    /* renamed from: com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI$3 */
    class C219073 implements OnItemClickListener {
        C219073() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI$2 */
    class C219082 implements OnMenuItemClickListener {
        C219082() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45184);
            SnsLuckyMoneyDetailUI.this.finish();
            AppMethodBeat.m2505o(45184);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI$1 */
    class C219091 implements OnScrollListener {
        private boolean nST = false;
        private boolean nSU;

        C219091() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(45182);
            if (absListView.getCount() == 0) {
                AppMethodBeat.m2505o(45182);
                return;
            }
            switch (i) {
                case 0:
                    this.nST = false;
                    AppMethodBeat.m2505o(45182);
                    return;
                case 1:
                    this.nST = true;
                    break;
            }
            AppMethodBeat.m2505o(45182);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            AppMethodBeat.m2504i(45183);
            if (i3 == 0 || !this.nST) {
                AppMethodBeat.m2505o(45183);
                return;
            }
            if (i <= 0) {
                int top;
                View childAt = absListView.getChildAt(i);
                if (childAt != null) {
                    top = 0 - childAt.getTop();
                } else {
                    top = 0;
                }
                if (top <= 100) {
                    z = false;
                }
            }
            if (this.nSU != z) {
                if (z) {
                    SnsLuckyMoneyDetailUI.this.getResources().getDrawable(C25738R.color.a0o);
                    SnsLuckyMoneyDetailUI.cmy();
                } else {
                    SnsLuckyMoneyDetailUI.cmz();
                }
                this.nSU = z;
            }
            AppMethodBeat.m2505o(45183);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsLuckyMoneyDetailUI() {
        AppMethodBeat.m2504i(45185);
        AppMethodBeat.m2505o(45185);
    }

    static /* synthetic */ void cmy() {
    }

    static /* synthetic */ void cmz() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45186);
        super.onCreate(bundle);
        initView();
        List Qe = C3330a.m5633Qe(getIntent().getStringExtra("key_feedid"));
        if (!(Qe == null || Qe.size() == 0)) {
            C29041b c29041b = this.qHe;
            if (Qe == null) {
                LinkedList linkedList = new LinkedList();
            } else {
                c29041b.nSx = Qe;
            }
            c29041b.notifyDataSetChanged();
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(C25738R.color.a0r));
        }
        setMMSubTitle(null);
        AppMethodBeat.m2505o(45186);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45187);
        getResources().getDrawable(C25738R.drawable.b8e);
        setMMTitle((int) C25738R.string.emc);
        setBackBtn(new C219082());
        this.nSL = (ListView) findViewById(2131825494);
        this.qHe = new C29041b(this.mController.ylL);
        this.nSL.setAdapter(this.qHe);
        this.nSL.setOnScrollListener(this.nSS);
        this.nSL.setOnItemClickListener(new C219073());
        AppMethodBeat.m2505o(45187);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(45188);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(45188);
        return dispatchKeyEvent;
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130970832;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45189);
        super.onDestroy();
        AppMethodBeat.m2505o(45189);
    }
}
