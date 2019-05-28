package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.List;

public class SelectDelRoomManagerUI extends SelectMemberUI {
    private boolean emk = false;
    private List<String> emv = new ArrayList();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectDelRoomManagerUI() {
        AppMethodBeat.i(104398);
        AppMethodBeat.o(104398);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kq() {
        AppMethodBeat.i(104399);
        super.Kq();
        String stringExtra = getIntent().getStringExtra("RoomManagers");
        if (stringExtra != null) {
            for (Object add : stringExtra.split(",")) {
                this.emv.add(add);
            }
        }
        this.emk = true;
        AppMethodBeat.o(104399);
    }

    public final boolean Kr() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean Kv() {
        return false;
    }

    public final void initView() {
        String string;
        b bVar;
        AppMethodBeat.i(104400);
        super.initView();
        setMMTitle(this.emk ? getString(R.string.dup) : getString(R.string.duo));
        if (this.emk) {
            string = getString(R.string.b5_);
        } else {
            string = getString(R.string.qt);
        }
        AnonymousClass1 anonymousClass1 = new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104397);
                if (SelectDelRoomManagerUI.this.emk) {
                    h.a(SelectDelRoomManagerUI.this, SelectDelRoomManagerUI.this.getString(R.string.ds0), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(104396);
                            Intent intent = new Intent();
                            intent.putExtra("Select_Contact", bo.c(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
                            SelectDelRoomManagerUI.this.setResult(-1, intent);
                            SelectDelRoomManagerUI.this.finish();
                            AppMethodBeat.o(104396);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(104397);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Contact", bo.c(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
                    SelectDelRoomManagerUI.this.setResult(-1, intent);
                    SelectDelRoomManagerUI.this.finish();
                    AppMethodBeat.o(104397);
                }
                return true;
            }
        };
        if (this.emk) {
            bVar = b.RED;
        } else {
            bVar = b.GREEN;
        }
        a(1, string, (OnMenuItemClickListener) anonymousClass1, bVar);
        Kt();
        AppMethodBeat.o(104400);
    }

    public void finish() {
        AppMethodBeat.i(104401);
        aqX();
        super.finish();
        AppMethodBeat.o(104401);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(View view, int i, long j) {
        AppMethodBeat.i(104402);
        super.a(view, i, j);
        ((c) view.getTag()).emS.performClick();
        AppMethodBeat.o(104402);
    }

    /* Access modifiers changed, original: protected|final */
    public final BaseAdapter Kw() {
        AppMethodBeat.i(104403);
        BaseAdapter Kw = super.Kw();
        AppMethodBeat.o(104403);
        return Kw;
    }

    /* Access modifiers changed, original: protected|final */
    public final void w(int i, boolean z) {
        AppMethodBeat.i(104404);
        super.w(i, z);
        Kt();
        AppMethodBeat.o(104404);
    }

    /* Access modifiers changed, original: protected|final */
    public final List<String> Kx() {
        return this.emv;
    }

    private void Kt() {
        AppMethodBeat.i(104405);
        if (this.emD.size() > 0) {
            enableOptionMenu(1, true);
            AppMethodBeat.o(104405);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(104405);
    }

    static /* synthetic */ ArrayList b(SelectDelRoomManagerUI selectDelRoomManagerUI) {
        AppMethodBeat.i(104406);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(selectDelRoomManagerUI.emD);
        AppMethodBeat.o(104406);
        return arrayList;
    }
}
