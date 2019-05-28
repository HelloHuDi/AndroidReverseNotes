package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.a.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public class SelectDateUI extends MMActivity implements a {
    private p ejZ = null;
    private long ejc = -1;
    private DayPickerView emn;
    private String emo;
    private HashMap<String, com.tencent.mm.chatroom.c.a> emp;
    private TextView emq;
    private ak mHandler;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104382);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.k0), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        setMMTitle((int) R.string.dum);
        this.emn = (DayPickerView) findViewById(R.id.e7x);
        this.emq = (TextView) findViewById(R.id.yi);
        this.emp = new HashMap();
        this.mHandler = new ak(getMainLooper());
        this.emo = getIntent().getStringExtra("detail_username");
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104380);
                SelectDateUI.a(SelectDateUI.this);
                SelectDateUI.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(104379);
                        SelectDateUI.this.emn.setBeginDate(SelectDateUI.this.ejc == -1 ? System.currentTimeMillis() * 1000 : SelectDateUI.this.ejc);
                        SelectDateUI.this.emn.a(SelectDateUI.this, SelectDateUI.this.emp.values());
                        if (SelectDateUI.this.emp.size() == 0) {
                            SelectDateUI.this.emq.setVisibility(0);
                            SelectDateUI.this.emn.setVisibility(8);
                            SelectDateUI.this.emq.setText(SelectDateUI.this.getString(R.string.ano));
                            AppMethodBeat.o(104379);
                            return;
                        }
                        SelectDateUI.this.emq.setVisibility(8);
                        SelectDateUI.this.emn.setVisibility(0);
                        AppMethodBeat.o(104379);
                    }
                });
                AppMethodBeat.o(104380);
            }
        }, "prepare_data");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104381);
                SelectDateUI.this.finish();
                AppMethodBeat.o(104381);
                return true;
            }
        });
        AppMethodBeat.o(104382);
    }

    public final int getLayoutId() {
        return R.layout.aqj;
    }

    public final long Jz() {
        AppMethodBeat.i(104383);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(104383);
        return currentTimeMillis;
    }

    public final void a(com.tencent.mm.chatroom.c.a aVar) {
        AppMethodBeat.i(104384);
        if (aVar == null) {
            ab.e("MicroMsg.SelectDateUI", "null == calendarDay");
            AppMethodBeat.o(104384);
            return;
        }
        ab.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", Long.valueOf(aVar.ehg), Integer.valueOf(aVar.ehf), Integer.valueOf(aVar.month), Integer.valueOf(aVar.year));
        ab.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", Long.valueOf(aVar.cvx));
        com.tencent.mm.bp.d.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.emo).putExtra("finish_direct", true).putExtra("from_date_search", true).putExtra("msg_local_id", r0));
        AppMethodBeat.o(104384);
    }
}
