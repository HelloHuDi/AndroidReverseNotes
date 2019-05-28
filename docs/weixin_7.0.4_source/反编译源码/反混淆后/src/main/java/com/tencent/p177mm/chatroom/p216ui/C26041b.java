package com.tencent.p177mm.chatroom.p216ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p710c.C26015q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.storage.C7577u;

/* renamed from: com.tencent.mm.chatroom.ui.b */
public final class C26041b {

    /* renamed from: com.tencent.mm.chatroom.ui.b$a */
    interface C18165a {
        /* renamed from: e */
        void mo33657e(boolean z, int i);
    }

    /* renamed from: com.tencent.mm.chatroom.ui.b$1 */
    static class C260421 implements OnCancelListener {
        C260421() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.b$2 */
    static class C260432 implements C1202f {
        final /* synthetic */ ProgressDialog eiD;
        final /* synthetic */ boolean ekJ = false;
        final /* synthetic */ C18165a ekK;
        final /* synthetic */ Activity val$activity;

        C260432(ProgressDialog progressDialog, Activity activity, C18165a c18165a) {
            this.eiD = progressDialog;
            this.val$activity = activity;
            this.ekK = c18165a;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(104218);
            C1720g.m3535RO().eJo.mo14546b(482, (C1202f) this);
            if (!this.ekJ) {
                this.eiD.cancel();
            }
            boolean z = false;
            this.val$activity.getString(C25738R.string.dvf);
            C26015q c26015q = (C26015q) c1207m;
            if (i == 0 && i2 == 0) {
                C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(c26015q.chatroomName);
                if (oa == null) {
                    oa = new C7577u();
                }
                oa.mo16805ib(C1853r.m3846Yz(), c26015q.ehC);
                C37921n.m64050a(oa);
                z = true;
            }
            if (this.ekK != null) {
                this.ekK.mo33657e(z, c26015q.ehE);
            }
            AppMethodBeat.m2505o(104218);
        }
    }

    /* renamed from: a */
    public static void m41590a(Activity activity, String str, boolean z) {
        AppMethodBeat.m2504i(104219);
        Intent intent;
        if (z) {
            intent = new Intent(activity, RoomUpgradeUI.class);
            intent.setFlags(603979776);
            intent.putExtra("room_name", str);
            Intent intent2 = new Intent();
            intent2.setClassName(activity, "com.tencent.mm.plugin.account.ui.bind.BindMobileUI");
            intent2.putExtra("is_bind_for_chatroom_upgrade", true);
            MMWizardActivity.m23792b(activity, intent2, intent);
            AppMethodBeat.m2505o(104219);
            return;
        }
        intent = new Intent(activity, RoomUpgradeUI.class);
        intent.setFlags(603979776);
        intent.putExtra("room_name", str);
        intent.putExtra("announce_ok", true);
        activity.startActivity(intent);
        AppMethodBeat.m2505o(104219);
    }
}
