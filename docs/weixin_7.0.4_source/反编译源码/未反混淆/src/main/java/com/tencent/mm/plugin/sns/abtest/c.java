package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static String qCS = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private static Set<Long> qCT = new HashSet();
    private static OnClickListener qCU;
    private static boolean qCh = false;
    private static com.tencent.mm.sdk.b.c qCq = new com.tencent.mm.sdk.b.c<rd>() {
        {
            AppMethodBeat.i(35679);
            this.xxI = rd.class.getName().hashCode();
            AppMethodBeat.o(35679);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(35680);
            rd rdVar = (rd) bVar;
            if (rdVar instanceof rd) {
                boolean z = rdVar.cNh.cNi;
                long j = rdVar.cNh.cBh;
                ab.d("MicroMsg.SellerABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", Boolean.valueOf(z), Long.valueOf(j));
                if (j != 0 && c.qCT.contains(Long.valueOf(j))) {
                    c.t(j, z);
                }
            }
            AppMethodBeat.o(35680);
            return false;
        }
    };

    static {
        AppMethodBeat.i(35687);
        AppMethodBeat.o(35687);
    }

    public static void cmb() {
        AppMethodBeat.i(35682);
        if (g.aaK().oP("6") != null) {
            qCS = g.aaK().oP("6").value;
            ab.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", qCS);
            qCh = true;
            a.xxA.c(qCq);
            qCU = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(35681);
                    if (view.getTag() instanceof n) {
                        n nVar = (n) view.getTag();
                        if (!(nVar == null || bo.isNullOrNil(nVar.cqA()))) {
                            c.S(view.getContext(), nVar.cqA());
                        }
                    }
                    AppMethodBeat.o(35681);
                }
            };
        }
        AppMethodBeat.o(35682);
    }

    public static void cmc() {
        AppMethodBeat.i(35683);
        qCU = null;
        a.xxA.d(qCq);
        if (qCh) {
            g.aaK().oP("6").fob = 2;
            g.aaK().oP("6").result = qCT.size();
            f.a(g.aaK().oP("6"));
            ab.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", Integer.valueOf(2), qCT.size());
        }
        qCS = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        qCh = false;
        qCT.clear();
        AppMethodBeat.o(35683);
    }

    public static void b(View view, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(35684);
        if (qCh) {
            baseViewHolder.rIa = false;
            baseViewHolder.rHY = (ViewStub) view.findViewById(R.id.en6);
            baseViewHolder.rHY.setVisibility(8);
        }
        AppMethodBeat.o(35684);
    }

    static /* synthetic */ void t(long j, boolean z) {
        AppMethodBeat.i(35685);
        if (qCh) {
            g.aaK().oP("6").fob = 3;
            g.aaK().oP("6").result = (z ? 2 : 1) + "|" + j;
            f.a(g.aaK().oP("6"));
            ab.d("MicroMsg.SellerABTestManager", "endABTestWhenFinishBlock, snsSvrId:%d, isBlock:%b, scene:%d, actionResult:%s", Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(3), r0);
        }
        AppMethodBeat.o(35685);
    }

    static /* synthetic */ void S(Context context, String str) {
        AppMethodBeat.i(35686);
        n YS = af.cnF().YS(str);
        if (YS != null) {
            String str2 = YS.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str2);
            intent.putExtra("sns_permission_snsinfo_svr_id", YS.field_snsId);
            intent.putExtra("sns_permission_block_scene", 7);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.o(35686);
    }
}
