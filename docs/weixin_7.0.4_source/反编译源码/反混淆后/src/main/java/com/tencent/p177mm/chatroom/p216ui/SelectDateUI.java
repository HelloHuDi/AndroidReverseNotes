package com.tencent.p177mm.chatroom.p216ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p1187a.C45282a;
import com.tencent.p177mm.chatroom.p710c.C26014a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;

/* renamed from: com.tencent.mm.chatroom.ui.SelectDateUI */
public class SelectDateUI extends MMActivity implements C45282a {
    private C44275p ejZ = null;
    private long ejc = -1;
    private DayPickerView emn;
    private String emo;
    private HashMap<String, C26014a> emp;
    private TextView emq;
    private C7306ak mHandler;

    /* renamed from: com.tencent.mm.chatroom.ui.SelectDateUI$1 */
    class C324601 implements Runnable {

        /* renamed from: com.tencent.mm.chatroom.ui.SelectDateUI$1$1 */
        class C260401 implements Runnable {
            C260401() {
            }

            public final void run() {
                AppMethodBeat.m2504i(104379);
                SelectDateUI.this.emn.setBeginDate(SelectDateUI.this.ejc == -1 ? System.currentTimeMillis() * 1000 : SelectDateUI.this.ejc);
                SelectDateUI.this.emn.mo33627a(SelectDateUI.this, SelectDateUI.this.emp.values());
                if (SelectDateUI.this.emp.size() == 0) {
                    SelectDateUI.this.emq.setVisibility(0);
                    SelectDateUI.this.emn.setVisibility(8);
                    SelectDateUI.this.emq.setText(SelectDateUI.this.getString(C25738R.string.ano));
                    AppMethodBeat.m2505o(104379);
                    return;
                }
                SelectDateUI.this.emq.setVisibility(8);
                SelectDateUI.this.emn.setVisibility(0);
                AppMethodBeat.m2505o(104379);
            }
        }

        C324601() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104380);
            SelectDateUI.m63642a(SelectDateUI.this);
            SelectDateUI.this.mHandler.post(new C260401());
            AppMethodBeat.m2505o(104380);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectDateUI$2 */
    class C376492 implements OnMenuItemClickListener {
        C376492() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104381);
            SelectDateUI.this.finish();
            AppMethodBeat.m2505o(104381);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104382);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(2131820940), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        setMMTitle((int) C25738R.string.dum);
        this.emn = (DayPickerView) findViewById(2131827311);
        this.emq = (TextView) findViewById(2131821477);
        this.emp = new HashMap();
        this.mHandler = new C7306ak(getMainLooper());
        this.emo = getIntent().getStringExtra("detail_username");
        C7305d.post(new C324601(), "prepare_data");
        setBackBtn(new C376492());
        AppMethodBeat.m2505o(104382);
    }

    public final int getLayoutId() {
        return 2130970588;
    }

    /* renamed from: Jz */
    public final long mo60480Jz() {
        AppMethodBeat.m2504i(104383);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.m2505o(104383);
        return currentTimeMillis;
    }

    /* renamed from: a */
    public final void mo60481a(C26014a c26014a) {
        AppMethodBeat.m2504i(104384);
        if (c26014a == null) {
            C4990ab.m7412e("MicroMsg.SelectDateUI", "null == calendarDay");
            AppMethodBeat.m2505o(104384);
            return;
        }
        C4990ab.m7417i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", Long.valueOf(c26014a.ehg), Integer.valueOf(c26014a.ehf), Integer.valueOf(c26014a.month), Integer.valueOf(c26014a.year));
        C4990ab.m7417i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", Long.valueOf(c26014a.cvx));
        C25985d.m41473f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.emo).putExtra("finish_direct", true).putExtra("from_date_search", true).putExtra("msg_local_id", r0));
        AppMethodBeat.m2505o(104384);
    }
}
