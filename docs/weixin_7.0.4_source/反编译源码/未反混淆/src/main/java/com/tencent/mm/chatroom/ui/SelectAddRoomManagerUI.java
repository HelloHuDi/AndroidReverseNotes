package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectAddRoomManagerUI extends SelectMemberUI {
    private boolean emk = false;
    private HashSet<String> eml = new HashSet();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectAddRoomManagerUI() {
        AppMethodBeat.i(104371);
        AppMethodBeat.o(104371);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kq() {
        AppMethodBeat.i(104372);
        super.Kq();
        this.emk = false;
        for (String str : this.eih.afg()) {
            if (this.eih.aoo(str)) {
                this.eml.add(str);
            }
        }
        AppMethodBeat.o(104372);
    }

    public final boolean Kr() {
        return true;
    }

    public final void initView() {
        String string;
        b bVar;
        AppMethodBeat.i(104373);
        super.initView();
        setMMTitle(this.emk ? getString(R.string.dup) : getString(R.string.duo));
        if (this.emk) {
            string = getString(R.string.b5_);
        } else {
            string = getString(R.string.qt);
        }
        AnonymousClass1 anonymousClass1 = new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104370);
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", bo.c(SelectAddRoomManagerUI.a(SelectAddRoomManagerUI.this), ","));
                SelectAddRoomManagerUI.this.setResult(-1, intent);
                SelectAddRoomManagerUI.this.finish();
                SelectAddRoomManagerUI.this.aqX();
                AppMethodBeat.o(104370);
                return false;
            }
        };
        if (this.emk) {
            bVar = b.RED;
        } else {
            bVar = b.GREEN;
        }
        a(1, string, (OnMenuItemClickListener) anonymousClass1, bVar);
        Kt();
        AppMethodBeat.o(104373);
    }

    /* Access modifiers changed, original: protected|final */
    public final void w(int i, boolean z) {
        AppMethodBeat.i(104374);
        super.w(i, z);
        Kt();
        AppMethodBeat.o(104374);
    }

    public void finish() {
        AppMethodBeat.i(104375);
        aqX();
        super.finish();
        AppMethodBeat.o(104375);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(View view, int i, long j) {
        AppMethodBeat.i(104376);
        super.a(view, i, j);
        c cVar = (c) view.getTag();
        String Oj = cVar.emO.ehM.Oj();
        String str = cVar.emO.ehM.field_username;
        String Oi = cVar.emO.ehM.Oi();
        ab.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", str, Oj, Oi);
        cVar.emS.performClick();
        AppMethodBeat.o(104376);
    }

    /* Access modifiers changed, original: protected|final */
    public final HashSet<String> Ks() {
        return this.eml;
    }

    private void Kt() {
        AppMethodBeat.i(104377);
        if (this.emD.size() > 0) {
            enableOptionMenu(1, true);
            AppMethodBeat.o(104377);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(104377);
    }

    static /* synthetic */ ArrayList a(SelectAddRoomManagerUI selectAddRoomManagerUI) {
        AppMethodBeat.i(104378);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(selectAddRoomManagerUI.emD);
        AppMethodBeat.o(104378);
        return arrayList;
    }
}
