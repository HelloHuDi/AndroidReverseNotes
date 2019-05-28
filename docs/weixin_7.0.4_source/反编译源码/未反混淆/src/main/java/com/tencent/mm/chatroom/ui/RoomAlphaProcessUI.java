package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.chatroom.c.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
@Deprecated
public class RoomAlphaProcessUI extends MMActivity implements a {
    private String chatroomName;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104130);
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        m qVar = new q(this.chatroomName);
        g.RO().eJo.a(482, new com.tencent.mm.chatroom.ui.b.AnonymousClass2(h.b((Context) this, getString(R.string.cn5), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        }), this, this));
        g.RO().eJo.a(qVar, 0);
        AppMethodBeat.o(104130);
    }

    public void onResume() {
        AppMethodBeat.i(104131);
        super.onResume();
        AppMethodBeat.o(104131);
    }

    public void onPause() {
        AppMethodBeat.i(104132);
        super.onPause();
        AppMethodBeat.o(104132);
    }

    public void onDestroy() {
        AppMethodBeat.i(104133);
        super.onDestroy();
        AppMethodBeat.o(104133);
    }

    public final void initView() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private static void p(Runnable runnable) {
        AppMethodBeat.i(104134);
        new ak().postDelayed(runnable, 200);
        AppMethodBeat.o(104134);
    }

    public final void e(final boolean z, final int i) {
        AppMethodBeat.i(104135);
        if (z) {
            h.bQ(this, getString(R.string.dvg));
            p(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(104128);
                    Intent intent = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
                    intent.setFlags(603979776);
                    intent.putExtra("room_name", RoomAlphaProcessUI.this.chatroomName);
                    intent.putExtra("upgrade_success", z);
                    intent.putExtra("left_quota", i);
                    RoomAlphaProcessUI.this.startActivity(intent);
                    AppMethodBeat.o(104128);
                }
            });
            AppMethodBeat.o(104135);
            return;
        }
        h.a((Context) this, getString(R.string.dvf), "", null);
        p(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104129);
                Intent intent = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
                intent.setFlags(603979776);
                intent.putExtra("room_name", RoomAlphaProcessUI.this.chatroomName);
                intent.putExtra("upgrade_success", z);
                RoomAlphaProcessUI.this.startActivity(intent);
                AppMethodBeat.o(104129);
            }
        });
        AppMethodBeat.o(104135);
    }
}
