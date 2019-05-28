package com.tencent.mm.plugin.sns.lucky.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.l.a;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private ListView nSL;
    OnScrollListener nSS = new OnScrollListener() {
        private boolean nST = false;
        private boolean nSU;

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(45182);
            if (absListView.getCount() == 0) {
                AppMethodBeat.o(45182);
                return;
            }
            switch (i) {
                case 0:
                    this.nST = false;
                    AppMethodBeat.o(45182);
                    return;
                case 1:
                    this.nST = true;
                    break;
            }
            AppMethodBeat.o(45182);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            AppMethodBeat.i(45183);
            if (i3 == 0 || !this.nST) {
                AppMethodBeat.o(45183);
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
                    SnsLuckyMoneyDetailUI.this.getResources().getDrawable(R.color.a0o);
                    SnsLuckyMoneyDetailUI.cmy();
                } else {
                    SnsLuckyMoneyDetailUI.cmz();
                }
                this.nSU = z;
            }
            AppMethodBeat.o(45183);
        }
    };
    private final int oey = 750;
    private final int oez = 240;
    private b qHe;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsLuckyMoneyDetailUI() {
        AppMethodBeat.i(45185);
        AppMethodBeat.o(45185);
    }

    static /* synthetic */ void cmy() {
    }

    static /* synthetic */ void cmz() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45186);
        super.onCreate(bundle);
        initView();
        List Qe = a.Qe(getIntent().getStringExtra("key_feedid"));
        if (!(Qe == null || Qe.size() == 0)) {
            b bVar = this.qHe;
            if (Qe == null) {
                LinkedList linkedList = new LinkedList();
            } else {
                bVar.nSx = Qe;
            }
            bVar.notifyDataSetChanged();
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.a0r));
        }
        setMMSubTitle(null);
        AppMethodBeat.o(45186);
    }

    public final void initView() {
        AppMethodBeat.i(45187);
        getResources().getDrawable(R.drawable.b8e);
        setMMTitle((int) R.string.emc);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45184);
                SnsLuckyMoneyDetailUI.this.finish();
                AppMethodBeat.o(45184);
                return true;
            }
        });
        this.nSL = (ListView) findViewById(R.id.cvt);
        this.qHe = new b(this.mController.ylL);
        this.nSL.setAdapter(this.qHe);
        this.nSL.setOnScrollListener(this.nSS);
        this.nSL.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        AppMethodBeat.o(45187);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(45188);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(45188);
        return dispatchKeyEvent;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.ax6;
    }

    public void onDestroy() {
        AppMethodBeat.i(45189);
        super.onDestroy();
        AppMethodBeat.o(45189);
    }
}
