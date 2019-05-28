package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectDelMemberUI extends SelectMemberUI {
    private int ejS;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kq() {
        AppMethodBeat.i(104388);
        super.Kq();
        this.ejS = getIntent().getIntExtra("room_member_count", 0);
        AppMethodBeat.o(104388);
    }

    public final boolean Kr() {
        return true;
    }

    public final void initView() {
        AppMethodBeat.i(104389);
        super.initView();
        setMMTitle(getString(R.string.dun) + "(" + this.ejS + ")");
        a(1, getString(R.string.b5_), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104387);
                h.a(SelectDelMemberUI.this, SelectDelMemberUI.this.getString(R.string.ds0), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(104386);
                        Intent intent = new Intent();
                        intent.putExtra("Select_Contact", bo.c(SelectDelMemberUI.a(SelectDelMemberUI.this), ","));
                        SelectDelMemberUI.this.setResult(-1, intent);
                        SelectDelMemberUI.this.finish();
                        AppMethodBeat.o(104386);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(104387);
                return false;
            }
        }, b.RED);
        Kt();
        AppMethodBeat.o(104389);
    }

    public void finish() {
        AppMethodBeat.i(104390);
        aqX();
        super.finish();
        AppMethodBeat.o(104390);
    }

    /* Access modifiers changed, original: protected|final */
    public final HashSet<String> Ku() {
        AppMethodBeat.i(104391);
        HashSet<String> Ku = super.Ku();
        if (Kz().aos(r.Yz())) {
            AppMethodBeat.o(104391);
            return Ku;
        }
        for (String str : Kz().afg()) {
            if (Kz().aoo(str) || Kz().aos(str)) {
                Ku.add(str);
            }
        }
        AppMethodBeat.o(104391);
        return Ku;
    }

    /* Access modifiers changed, original: protected|final */
    public final void w(int i, boolean z) {
        AppMethodBeat.i(104392);
        super.w(i, z);
        Kt();
        AppMethodBeat.o(104392);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(View view, int i, long j) {
        AppMethodBeat.i(104393);
        super.a(view, i, j);
        ((c) view.getTag()).emS.performClick();
        AppMethodBeat.o(104393);
    }

    private void Kt() {
        AppMethodBeat.i(104394);
        if (this.emD.size() > 0) {
            updateOptionMenuText(1, getString(R.string.b5_) + "(" + this.emD.size() + ")");
            enableOptionMenu(1, true);
            AppMethodBeat.o(104394);
            return;
        }
        updateOptionMenuText(1, getString(R.string.b5_));
        enableOptionMenu(1, false);
        AppMethodBeat.o(104394);
    }

    static /* synthetic */ ArrayList a(SelectDelMemberUI selectDelMemberUI) {
        AppMethodBeat.i(104395);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(selectDelMemberUI.emD);
        AppMethodBeat.o(104395);
        return arrayList;
    }
}
