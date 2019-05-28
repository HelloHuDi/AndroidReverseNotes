package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.bz.a;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.m.g;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends b {
    int dtW;
    private c yhs;
    View zwu;

    public j(final Context context) {
        super(context);
        AppMethodBeat.i(34668);
        this.zwu = View.inflate(context, R.layout.a86, null);
        if (this.zwu == null) {
            AppMethodBeat.o(34668);
            return;
        }
        this.dtW = ah.getInt(g.Nu().getValue("InviteFriendsControlFlags"), 0);
        this.zwu.setVisibility(8);
        this.zwu.setPadding(0, -a.fromDPToPix(context, R.dimen.m3), 0, 0);
        if ((this.dtW & 1) > 0) {
            this.zwu.setVisibility(0);
            this.zwu.setPadding(0, 0, 0, 0);
        }
        this.zwu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(34664);
                Intent intent = new Intent();
                intent.putExtra("Invite_friends", 1);
                d.b(context, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", intent);
                h.pYm.e(14034, Integer.valueOf(1));
                AppMethodBeat.o(34664);
            }
        });
        this.yhs = new c<cq>() {
            {
                AppMethodBeat.i(34666);
                this.xxI = cq.class.getName().hashCode();
                AppMethodBeat.o(34666);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(34667);
                ab.i("MicroMsg.InviteFriendBanner", "dynamic config file change");
                j.this.dtW = ah.getInt(g.Nu().getValue("InviteFriendsControlFlags"), 0);
                if ((j.this.dtW & 1) > 0) {
                    j.this.zwu.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(34665);
                            j.this.zwu.setVisibility(0);
                            j.this.zwu.setPadding(0, 0, 0, 0);
                            AppMethodBeat.o(34665);
                        }
                    });
                }
                AppMethodBeat.o(34667);
                return true;
            }
        };
        AppMethodBeat.o(34668);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean aMN() {
        AppMethodBeat.i(34669);
        com.tencent.mm.sdk.b.a.xxA.c(this.yhs);
        if (this.zwu == null || this.zwu.getVisibility() != 0) {
            AppMethodBeat.o(34669);
            return false;
        }
        AppMethodBeat.o(34669);
        return true;
    }

    public final void release() {
        AppMethodBeat.i(34670);
        com.tencent.mm.sdk.b.a.xxA.d(this.yhs);
        AppMethodBeat.o(34670);
    }

    public final void destroy() {
    }

    public final View getView() {
        return this.zwu;
    }
}
