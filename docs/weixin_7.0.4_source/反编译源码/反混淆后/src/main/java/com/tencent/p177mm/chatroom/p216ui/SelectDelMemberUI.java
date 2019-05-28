package com.tencent.p177mm.chatroom.p216ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p216ui.SelectMemberUI.C7666c;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.tencent.mm.chatroom.ui.SelectDelMemberUI */
public class SelectDelMemberUI extends SelectMemberUI {
    private int ejS;

    /* renamed from: com.tencent.mm.chatroom.ui.SelectDelMemberUI$1 */
    class C92291 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.chatroom.ui.SelectDelMemberUI$1$1 */
        class C92301 implements OnClickListener {
            C92301() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(104386);
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", C5046bo.m7536c(SelectDelMemberUI.m16759a(SelectDelMemberUI.this), ","));
                SelectDelMemberUI.this.setResult(-1, intent);
                SelectDelMemberUI.this.finish();
                AppMethodBeat.m2505o(104386);
            }
        }

        /* renamed from: com.tencent.mm.chatroom.ui.SelectDelMemberUI$1$2 */
        class C92312 implements OnClickListener {
            C92312() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C92291() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104387);
            C30379h.m48440a(SelectDelMemberUI.this, SelectDelMemberUI.this.getString(C25738R.string.ds0), "", new C92301(), new C92312());
            AppMethodBeat.m2505o(104387);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kq */
    public final void mo17459Kq() {
        AppMethodBeat.m2504i(104388);
        super.mo17459Kq();
        this.ejS = getIntent().getIntExtra("room_member_count", 0);
        AppMethodBeat.m2505o(104388);
    }

    /* renamed from: Kr */
    public final boolean mo17460Kr() {
        return true;
    }

    public final void initView() {
        AppMethodBeat.m2504i(104389);
        super.initView();
        setMMTitle(getString(C25738R.string.dun) + "(" + this.ejS + ")");
        mo17379a(1, getString(C25738R.string.b5_), (OnMenuItemClickListener) new C92291(), C5535b.RED);
        m16758Kt();
        AppMethodBeat.m2505o(104389);
    }

    public void finish() {
        AppMethodBeat.m2504i(104390);
        aqX();
        super.finish();
        AppMethodBeat.m2505o(104390);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Ku */
    public final HashSet<String> mo17462Ku() {
        AppMethodBeat.m2504i(104391);
        HashSet<String> Ku = super.mo17462Ku();
        if (mo17466Kz().aos(C1853r.m3846Yz())) {
            AppMethodBeat.m2505o(104391);
            return Ku;
        }
        for (String str : mo17466Kz().afg()) {
            if (mo17466Kz().aoo(str) || mo17466Kz().aos(str)) {
                Ku.add(str);
            }
        }
        AppMethodBeat.m2505o(104391);
        return Ku;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: w */
    public final void mo17468w(int i, boolean z) {
        AppMethodBeat.m2504i(104392);
        super.mo17468w(i, z);
        m16758Kt();
        AppMethodBeat.m2505o(104392);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo17467a(View view, int i, long j) {
        AppMethodBeat.m2504i(104393);
        super.mo17467a(view, i, j);
        ((C7666c) view.getTag()).emS.performClick();
        AppMethodBeat.m2505o(104393);
    }

    /* renamed from: Kt */
    private void m16758Kt() {
        AppMethodBeat.m2504i(104394);
        if (this.emD.size() > 0) {
            updateOptionMenuText(1, getString(C25738R.string.b5_) + "(" + this.emD.size() + ")");
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(104394);
            return;
        }
        updateOptionMenuText(1, getString(C25738R.string.b5_));
        enableOptionMenu(1, false);
        AppMethodBeat.m2505o(104394);
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m16759a(SelectDelMemberUI selectDelMemberUI) {
        AppMethodBeat.m2504i(104395);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(selectDelMemberUI.emD);
        AppMethodBeat.m2505o(104395);
        return arrayList;
    }
}
