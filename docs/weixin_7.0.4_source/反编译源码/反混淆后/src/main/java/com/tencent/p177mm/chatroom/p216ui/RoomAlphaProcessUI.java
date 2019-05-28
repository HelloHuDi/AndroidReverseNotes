package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p216ui.C26041b.C18165a;
import com.tencent.p177mm.chatroom.p216ui.C26041b.C260421;
import com.tencent.p177mm.chatroom.p216ui.C26041b.C260432;
import com.tencent.p177mm.chatroom.p710c.C26015q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

@C5271a(3)
@Deprecated
/* renamed from: com.tencent.mm.chatroom.ui.RoomAlphaProcessUI */
public class RoomAlphaProcessUI extends MMActivity implements C18165a {
    private String chatroomName;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104130);
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        C1207m c26015q = new C26015q(this.chatroomName);
        C1720g.m3535RO().eJo.mo14539a(482, new C260432(C30379h.m48458b((Context) this, getString(C25738R.string.cn5), false, new C260421()), this, this));
        C1720g.m3535RO().eJo.mo14541a(c26015q, 0);
        AppMethodBeat.m2505o(104130);
    }

    public void onResume() {
        AppMethodBeat.m2504i(104131);
        super.onResume();
        AppMethodBeat.m2505o(104131);
    }

    public void onPause() {
        AppMethodBeat.m2504i(104132);
        super.onPause();
        AppMethodBeat.m2505o(104132);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104133);
        super.onDestroy();
        AppMethodBeat.m2505o(104133);
    }

    public final void initView() {
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: p */
    private static void m63594p(Runnable runnable) {
        AppMethodBeat.m2504i(104134);
        new C7306ak().postDelayed(runnable, 200);
        AppMethodBeat.m2505o(104134);
    }

    /* renamed from: e */
    public final void mo33657e(final boolean z, final int i) {
        AppMethodBeat.m2504i(104135);
        if (z) {
            C30379h.m48465bQ(this, getString(C25738R.string.dvg));
            RoomAlphaProcessUI.m63594p(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(104128);
                    Intent intent = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
                    intent.setFlags(603979776);
                    intent.putExtra("room_name", RoomAlphaProcessUI.this.chatroomName);
                    intent.putExtra("upgrade_success", z);
                    intent.putExtra("left_quota", i);
                    RoomAlphaProcessUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(104128);
                }
            });
            AppMethodBeat.m2505o(104135);
            return;
        }
        C30379h.m48438a((Context) this, getString(C25738R.string.dvf), "", null);
        RoomAlphaProcessUI.m63594p(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(104129);
                Intent intent = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
                intent.setFlags(603979776);
                intent.putExtra("room_name", RoomAlphaProcessUI.this.chatroomName);
                intent.putExtra("upgrade_success", z);
                RoomAlphaProcessUI.this.startActivity(intent);
                AppMethodBeat.m2505o(104129);
            }
        });
        AppMethodBeat.m2505o(104135);
    }
}
