package com.tencent.p177mm.chatroom.p216ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p216ui.SelectMemberUI.C7666c;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI */
public class SelectAddRoomManagerUI extends SelectMemberUI {
    private boolean emk = false;
    private HashSet<String> eml = new HashSet();

    /* renamed from: com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI$1 */
    class C260391 implements OnMenuItemClickListener {
        C260391() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104370);
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", C5046bo.m7536c(SelectAddRoomManagerUI.m41584a(SelectAddRoomManagerUI.this), ","));
            SelectAddRoomManagerUI.this.setResult(-1, intent);
            SelectAddRoomManagerUI.this.finish();
            SelectAddRoomManagerUI.this.aqX();
            AppMethodBeat.m2505o(104370);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SelectAddRoomManagerUI() {
        AppMethodBeat.m2504i(104371);
        AppMethodBeat.m2505o(104371);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kq */
    public final void mo17459Kq() {
        AppMethodBeat.m2504i(104372);
        super.mo17459Kq();
        this.emk = false;
        for (String str : this.eih.afg()) {
            if (this.eih.aoo(str)) {
                this.eml.add(str);
            }
        }
        AppMethodBeat.m2505o(104372);
    }

    /* renamed from: Kr */
    public final boolean mo17460Kr() {
        return true;
    }

    public final void initView() {
        String string;
        C5535b c5535b;
        AppMethodBeat.m2504i(104373);
        super.initView();
        setMMTitle(this.emk ? getString(C25738R.string.dup) : getString(C25738R.string.duo));
        if (this.emk) {
            string = getString(C25738R.string.b5_);
        } else {
            string = getString(C25738R.string.f9142qt);
        }
        C260391 c260391 = new C260391();
        if (this.emk) {
            c5535b = C5535b.RED;
        } else {
            c5535b = C5535b.GREEN;
        }
        mo17379a(1, string, (OnMenuItemClickListener) c260391, c5535b);
        m41583Kt();
        AppMethodBeat.m2505o(104373);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: w */
    public final void mo17468w(int i, boolean z) {
        AppMethodBeat.m2504i(104374);
        super.mo17468w(i, z);
        m41583Kt();
        AppMethodBeat.m2505o(104374);
    }

    public void finish() {
        AppMethodBeat.m2504i(104375);
        aqX();
        super.finish();
        AppMethodBeat.m2505o(104375);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo17467a(View view, int i, long j) {
        AppMethodBeat.m2504i(104376);
        super.mo17467a(view, i, j);
        C7666c c7666c = (C7666c) view.getTag();
        String Oj = c7666c.emO.ehM.mo16707Oj();
        String str = c7666c.emO.ehM.field_username;
        String Oi = c7666c.emO.ehM.mo16706Oi();
        C4990ab.m7411d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", str, Oj, Oi);
        c7666c.emS.performClick();
        AppMethodBeat.m2505o(104376);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Ks */
    public final HashSet<String> mo17461Ks() {
        return this.eml;
    }

    /* renamed from: Kt */
    private void m41583Kt() {
        AppMethodBeat.m2504i(104377);
        if (this.emD.size() > 0) {
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(104377);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.m2505o(104377);
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m41584a(SelectAddRoomManagerUI selectAddRoomManagerUI) {
        AppMethodBeat.m2504i(104378);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(selectAddRoomManagerUI.emD);
        AppMethodBeat.m2505o(104378);
        return arrayList;
    }
}
