package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class ModRemarkRoomNameUI extends MMActivity implements a {
    private String ehq;
    private p eir = null;
    private String ejG = "";
    private MMEditText ejH;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104121);
        super.onCreate(bundle);
        this.ehq = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        AppMethodBeat.o(104121);
    }

    public final void initView() {
        AppMethodBeat.i(104122);
        setMMTitle((int) R.string.drh);
        this.ejH = (MMEditText) findViewById(R.id.dca);
        final CharSequence nullAsNil = bo.nullAsNil(getIntent().getStringExtra("room_name"));
        if (bo.isNullOrNil(nullAsNil)) {
            this.ejH.setHint(j.b((Context) this, ((c) g.K(c.class)).XV().mJ(this.ehq), this.ejH.getTextSize()));
            this.ejH.setEllipsize(TruncateAt.END);
        } else {
            this.ejH.setText(j.b((Context) this, nullAsNil, this.ejH.getTextSize()));
        }
        this.ejH.setSelection(this.ejH.getText().length());
        this.ejH.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(104117);
                if (!nullAsNil.equals(charSequence)) {
                    ModRemarkRoomNameUI.this.enableOptionMenu(true);
                }
                if (charSequence.length() > 0) {
                    ModRemarkRoomNameUI.this.ejH.setEllipsize(null);
                    AppMethodBeat.o(104117);
                    return;
                }
                ModRemarkRoomNameUI.this.ejH.setEllipsize(TruncateAt.END);
                AppMethodBeat.o(104117);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        com.tencent.mm.ui.tools.b.c hz = com.tencent.mm.ui.tools.b.c.d(this.ejH).hz(1, 32);
        hz.zIx = false;
        hz.a(null);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104118);
                ModRemarkRoomNameUI.this.setResult(0);
                ModRemarkRoomNameUI.this.finish();
                AppMethodBeat.o(104118);
                return true;
            }
        });
        a(0, getString(R.string.tc), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104119);
                ModRemarkRoomNameUI.this.aqX();
                String str = "";
                String Ne = b.Ne();
                if (bo.isNullOrNil(Ne) || !str.matches(".*[" + Ne + "].*")) {
                    com.tencent.mm.ui.tools.b.c.d(ModRemarkRoomNameUI.this.ejH).hz(1, 32).a(ModRemarkRoomNameUI.this);
                    AppMethodBeat.o(104119);
                    return true;
                }
                h.b(ModRemarkRoomNameUI.this.mController.ylL, ModRemarkRoomNameUI.this.getString(R.string.ce4, new Object[]{Ne}), ModRemarkRoomNameUI.this.getString(R.string.tz), true);
                AppMethodBeat.o(104119);
                return false;
            }
        }, q.b.GREEN);
        enableOptionMenu(false);
        AppMethodBeat.o(104122);
    }

    public void onPause() {
        AppMethodBeat.i(104123);
        super.onPause();
        AppMethodBeat.o(104123);
    }

    public void onDestroy() {
        AppMethodBeat.i(104124);
        super.onDestroy();
        AppMethodBeat.o(104124);
    }

    public final int getLayoutId() {
        return R.layout.ah8;
    }

    public final void ki(String str) {
        AppMethodBeat.i(104125);
        this.ejG = str;
        final com.tencent.mm.roomsdk.a.c.a M = com.tencent.mm.roomsdk.a.b.alY(this.ehq).M(this.ehq, this.ejG);
        M.d(new e() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(104120);
                e eVar = (e) aVar;
                if (this.ret != 0) {
                    M.cancel();
                    if (!(bo.isNullOrNil(eVar.content) && bo.isNullOrNil(eVar.title))) {
                        h.b(ModRemarkRoomNameUI.this, eVar.content, eVar.title, true);
                        AppMethodBeat.o(104120);
                        return;
                    }
                } else if (this.ret == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("room_name", ModRemarkRoomNameUI.this.ejG);
                    ModRemarkRoomNameUI.this.setResult(-1, intent);
                    ModRemarkRoomNameUI.this.finish();
                }
                AppMethodBeat.o(104120);
            }
        });
        AppCompatActivity appCompatActivity = this.mController.ylL;
        getString(R.string.tz);
        M.a(appCompatActivity, getString(R.string.av5), false, null);
        AppMethodBeat.o(104125);
    }

    public final void JW() {
        AppMethodBeat.i(104126);
        h.g(this, R.string.e8m, R.string.e8p);
        AppMethodBeat.o(104126);
    }

    public final void JX() {
        AppMethodBeat.i(104127);
        h.g(this, R.string.e8n, R.string.e8p);
        AppMethodBeat.o(104127);
    }
}
