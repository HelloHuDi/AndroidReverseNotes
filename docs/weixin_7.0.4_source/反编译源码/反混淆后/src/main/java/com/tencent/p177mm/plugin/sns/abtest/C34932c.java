package com.tencent.p177mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p1207a.C18608f;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.p230g.p231a.C45362rd;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p520ui.SnsPermissionUI;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.sns.abtest.c */
public final class C34932c {
    private static String qCS = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private static Set<Long> qCT = new HashSet();
    private static OnClickListener qCU;
    private static boolean qCh = false;
    private static C4884c qCq = new C133551();

    /* renamed from: com.tencent.mm.plugin.sns.abtest.c$1 */
    static class C133551 extends C4884c<C45362rd> {
        C133551() {
            AppMethodBeat.m2504i(35679);
            this.xxI = C45362rd.class.getName().hashCode();
            AppMethodBeat.m2505o(35679);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(35680);
            C45362rd c45362rd = (C45362rd) c4883b;
            if (c45362rd instanceof C45362rd) {
                boolean z = c45362rd.cNh.cNi;
                long j = c45362rd.cNh.cBh;
                C4990ab.m7411d("MicroMsg.SellerABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", Boolean.valueOf(z), Long.valueOf(j));
                if (j != 0 && C34932c.qCT.contains(Long.valueOf(j))) {
                    C34932c.m57348t(j, z);
                }
            }
            AppMethodBeat.m2505o(35680);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.c$2 */
    static class C290312 implements OnClickListener {
        C290312() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(35681);
            if (view.getTag() instanceof C46236n) {
                C46236n c46236n = (C46236n) view.getTag();
                if (!(c46236n == null || C5046bo.isNullOrNil(c46236n.cqA()))) {
                    C34932c.m57346S(view.getContext(), c46236n.cqA());
                }
            }
            AppMethodBeat.m2505o(35681);
        }
    }

    static {
        AppMethodBeat.m2504i(35687);
        AppMethodBeat.m2505o(35687);
    }

    public static void cmb() {
        AppMethodBeat.m2504i(35682);
        if (C26407g.aaK().mo60654oP("6") != null) {
            qCS = C26407g.aaK().mo60654oP("6").value;
            C4990ab.m7411d("MicroMsg.SellerABTestManager", "startABTest, value:%s", qCS);
            qCh = true;
            C4879a.xxA.mo10052c(qCq);
            qCU = new C290312();
        }
        AppMethodBeat.m2505o(35682);
    }

    public static void cmc() {
        AppMethodBeat.m2504i(35683);
        qCU = null;
        C4879a.xxA.mo10053d(qCq);
        if (qCh) {
            C26407g.aaK().mo60654oP("6").fob = 2;
            C26407g.aaK().mo60654oP("6").result = qCT.size();
            C18608f.m29040a(C26407g.aaK().mo60654oP("6"));
            C4990ab.m7411d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", Integer.valueOf(2), qCT.size());
        }
        qCS = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        qCh = false;
        qCT.clear();
        AppMethodBeat.m2505o(35683);
    }

    /* renamed from: b */
    public static void m57347b(View view, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(35684);
        if (qCh) {
            baseViewHolder.rIa = false;
            baseViewHolder.rHY = (ViewStub) view.findViewById(2131827912);
            baseViewHolder.rHY.setVisibility(8);
        }
        AppMethodBeat.m2505o(35684);
    }

    /* renamed from: t */
    static /* synthetic */ void m57348t(long j, boolean z) {
        AppMethodBeat.m2504i(35685);
        if (qCh) {
            C26407g.aaK().mo60654oP("6").fob = 3;
            C26407g.aaK().mo60654oP("6").result = (z ? 2 : 1) + "|" + j;
            C18608f.m29040a(C26407g.aaK().mo60654oP("6"));
            C4990ab.m7411d("MicroMsg.SellerABTestManager", "endABTestWhenFinishBlock, snsSvrId:%d, isBlock:%b, scene:%d, actionResult:%s", Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(3), r0);
        }
        AppMethodBeat.m2505o(35685);
    }

    /* renamed from: S */
    static /* synthetic */ void m57346S(Context context, String str) {
        AppMethodBeat.m2504i(35686);
        C46236n YS = C13373af.cnF().mo62917YS(str);
        if (YS != null) {
            String str2 = YS.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str2);
            intent.putExtra("sns_permission_snsinfo_svr_id", YS.field_snsId);
            intent.putExtra("sns_permission_block_scene", 7);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(35686);
    }
}
