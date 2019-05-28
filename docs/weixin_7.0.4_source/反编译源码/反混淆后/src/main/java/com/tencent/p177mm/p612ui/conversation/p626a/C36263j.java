package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.conversation.a.j */
public final class C36263j extends C14933b {
    int dtW;
    private C4884c yhs;
    View zwu;

    /* renamed from: com.tencent.mm.ui.conversation.a.j$2 */
    class C306822 extends C4884c<C6471cq> {

        /* renamed from: com.tencent.mm.ui.conversation.a.j$2$1 */
        class C239681 implements Runnable {
            C239681() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34665);
                C36263j.this.zwu.setVisibility(0);
                C36263j.this.zwu.setPadding(0, 0, 0, 0);
                AppMethodBeat.m2505o(34665);
            }
        }

        C306822() {
            AppMethodBeat.m2504i(34666);
            this.xxI = C6471cq.class.getName().hashCode();
            AppMethodBeat.m2505o(34666);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34667);
            C4990ab.m7416i("MicroMsg.InviteFriendBanner", "dynamic config file change");
            C36263j.this.dtW = C42252ah.getInt(C26373g.m41964Nu().getValue("InviteFriendsControlFlags"), 0);
            if ((C36263j.this.dtW & 1) > 0) {
                C36263j.this.zwu.post(new C239681());
            }
            AppMethodBeat.m2505o(34667);
            return true;
        }
    }

    public C36263j(final Context context) {
        super(context);
        AppMethodBeat.m2504i(34668);
        this.zwu = View.inflate(context, 2130969870, null);
        if (this.zwu == null) {
            AppMethodBeat.m2505o(34668);
            return;
        }
        this.dtW = C42252ah.getInt(C26373g.m41964Nu().getValue("InviteFriendsControlFlags"), 0);
        this.zwu.setVisibility(8);
        this.zwu.setPadding(0, -C1338a.fromDPToPix(context, C25738R.dimen.f9978m3), 0, 0);
        if ((this.dtW & 1) > 0) {
            this.zwu.setVisibility(0);
            this.zwu.setPadding(0, 0, 0, 0);
        }
        this.zwu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(34664);
                Intent intent = new Intent();
                intent.putExtra("Invite_friends", 1);
                C25985d.m41467b(context, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", intent);
                C7060h.pYm.mo8381e(14034, Integer.valueOf(1));
                AppMethodBeat.m2505o(34664);
            }
        });
        this.yhs = new C306822();
        AppMethodBeat.m2505o(34668);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(34669);
        C4879a.xxA.mo10052c(this.yhs);
        if (this.zwu == null || this.zwu.getVisibility() != 0) {
            AppMethodBeat.m2505o(34669);
            return false;
        }
        AppMethodBeat.m2505o(34669);
        return true;
    }

    public final void release() {
        AppMethodBeat.m2504i(34670);
        C4879a.xxA.mo10053d(this.yhs);
        AppMethodBeat.m2505o(34670);
    }

    public final void destroy() {
    }

    public final View getView() {
        return this.zwu;
    }
}
