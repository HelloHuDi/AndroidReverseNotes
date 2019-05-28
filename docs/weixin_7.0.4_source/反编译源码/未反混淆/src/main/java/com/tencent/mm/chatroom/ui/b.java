package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.chatroom.c.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMWizardActivity;

public final class b {

    interface a {
        void e(boolean z, int i);
    }

    /* renamed from: com.tencent.mm.chatroom.ui.b$2 */
    static class AnonymousClass2 implements f {
        final /* synthetic */ ProgressDialog eiD;
        final /* synthetic */ boolean ekJ = false;
        final /* synthetic */ a ekK;
        final /* synthetic */ Activity val$activity;

        AnonymousClass2(ProgressDialog progressDialog, Activity activity, a aVar) {
            this.eiD = progressDialog;
            this.val$activity = activity;
            this.ekK = aVar;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(104218);
            g.RO().eJo.b(482, (f) this);
            if (!this.ekJ) {
                this.eiD.cancel();
            }
            boolean z = false;
            this.val$activity.getString(R.string.dvf);
            q qVar = (q) mVar;
            if (i == 0 && i2 == 0) {
                u oa = ((c) g.K(c.class)).XV().oa(qVar.chatroomName);
                if (oa == null) {
                    oa = new u();
                }
                oa.ib(r.Yz(), qVar.ehC);
                n.a(oa);
                z = true;
            }
            if (this.ekK != null) {
                this.ekK.e(z, qVar.ehE);
            }
            AppMethodBeat.o(104218);
        }
    }

    public static void a(Activity activity, String str, boolean z) {
        AppMethodBeat.i(104219);
        Intent intent;
        if (z) {
            intent = new Intent(activity, RoomUpgradeUI.class);
            intent.setFlags(603979776);
            intent.putExtra("room_name", str);
            Intent intent2 = new Intent();
            intent2.setClassName(activity, "com.tencent.mm.plugin.account.ui.bind.BindMobileUI");
            intent2.putExtra("is_bind_for_chatroom_upgrade", true);
            MMWizardActivity.b(activity, intent2, intent);
            AppMethodBeat.o(104219);
            return;
        }
        intent = new Intent(activity, RoomUpgradeUI.class);
        intent.setFlags(603979776);
        intent.putExtra("room_name", str);
        intent.putExtra("announce_ok", true);
        activity.startActivity(intent);
        AppMethodBeat.o(104219);
    }
}
