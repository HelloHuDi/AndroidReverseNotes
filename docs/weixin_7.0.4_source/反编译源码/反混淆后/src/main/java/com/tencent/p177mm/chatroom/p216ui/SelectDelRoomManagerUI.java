package com.tencent.p177mm.chatroom.p216ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p216ui.SelectMemberUI.C7666c;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI */
public class SelectDelRoomManagerUI extends SelectMemberUI {
    private boolean emk = false;
    private List<String> emv = new ArrayList();

    /* renamed from: com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI$1 */
    class C376501 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI$1$1 */
        class C324611 implements OnClickListener {
            C324611() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(104396);
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", C5046bo.m7536c(SelectDelRoomManagerUI.m63652b(SelectDelRoomManagerUI.this), ","));
                SelectDelRoomManagerUI.this.setResult(-1, intent);
                SelectDelRoomManagerUI.this.finish();
                AppMethodBeat.m2505o(104396);
            }
        }

        /* renamed from: com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI$1$2 */
        class C324622 implements OnClickListener {
            C324622() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C376501() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104397);
            if (SelectDelRoomManagerUI.this.emk) {
                C30379h.m48440a(SelectDelRoomManagerUI.this, SelectDelRoomManagerUI.this.getString(C25738R.string.ds0), "", new C324611(), new C324622());
                AppMethodBeat.m2505o(104397);
            } else {
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", C5046bo.m7536c(SelectDelRoomManagerUI.m63652b(SelectDelRoomManagerUI.this), ","));
                SelectDelRoomManagerUI.this.setResult(-1, intent);
                SelectDelRoomManagerUI.this.finish();
                AppMethodBeat.m2505o(104397);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SelectDelRoomManagerUI() {
        AppMethodBeat.m2504i(104398);
        AppMethodBeat.m2505o(104398);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kq */
    public final void mo17459Kq() {
        AppMethodBeat.m2504i(104399);
        super.mo17459Kq();
        String stringExtra = getIntent().getStringExtra("RoomManagers");
        if (stringExtra != null) {
            for (Object add : stringExtra.split(",")) {
                this.emv.add(add);
            }
        }
        this.emk = true;
        AppMethodBeat.m2505o(104399);
    }

    /* renamed from: Kr */
    public final boolean mo17460Kr() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kv */
    public final boolean mo17463Kv() {
        return false;
    }

    public final void initView() {
        String string;
        C5535b c5535b;
        AppMethodBeat.m2504i(104400);
        super.initView();
        setMMTitle(this.emk ? getString(C25738R.string.dup) : getString(C25738R.string.duo));
        if (this.emk) {
            string = getString(C25738R.string.b5_);
        } else {
            string = getString(C25738R.string.f9142qt);
        }
        C376501 c376501 = new C376501();
        if (this.emk) {
            c5535b = C5535b.RED;
        } else {
            c5535b = C5535b.GREEN;
        }
        mo17379a(1, string, (OnMenuItemClickListener) c376501, c5535b);
        m63650Kt();
        AppMethodBeat.m2505o(104400);
    }

    public void finish() {
        AppMethodBeat.m2504i(104401);
        aqX();
        super.finish();
        AppMethodBeat.m2505o(104401);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo17467a(View view, int i, long j) {
        AppMethodBeat.m2504i(104402);
        super.mo17467a(view, i, j);
        ((C7666c) view.getTag()).emS.performClick();
        AppMethodBeat.m2505o(104402);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kw */
    public final BaseAdapter mo17464Kw() {
        AppMethodBeat.m2504i(104403);
        BaseAdapter Kw = super.mo17464Kw();
        AppMethodBeat.m2505o(104403);
        return Kw;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: w */
    public final void mo17468w(int i, boolean z) {
        AppMethodBeat.m2504i(104404);
        super.mo17468w(i, z);
        m63650Kt();
        AppMethodBeat.m2505o(104404);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kx */
    public final List<String> mo17465Kx() {
        return this.emv;
    }

    /* renamed from: Kt */
    private void m63650Kt() {
        AppMethodBeat.m2504i(104405);
        if (this.emD.size() > 0) {
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(104405);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.m2505o(104405);
    }

    /* renamed from: b */
    static /* synthetic */ ArrayList m63652b(SelectDelRoomManagerUI selectDelRoomManagerUI) {
        AppMethodBeat.m2504i(104406);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(selectDelRoomManagerUI.emD);
        AppMethodBeat.m2505o(104406);
        return arrayList;
    }
}
