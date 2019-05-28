package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24109b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C14492ap;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.d */
public final class C44784d extends C43884a {
    private C24109b mUw = new C297783();

    /* renamed from: com.tencent.mm.plugin.webview.luggage.b.d$1 */
    class C297771 extends C17817c {
        C297771() {
        }

        public final String name() {
            return "menu:share:appmessage";
        }

        /* renamed from: wQ */
        public final JSONObject mo7075wQ() {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.b.d$3 */
    class C297783 implements C24109b {
        C297783() {
        }

        public final void aIu() {
            AppMethodBeat.m2504i(6427);
            MainProcessTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            AppBrandMainProcessService.m54349a(favUrlTask);
            AppMethodBeat.m2505o(6427);
        }
    }

    public C44784d() {
        super(3);
        AppMethodBeat.m2504i(6428);
        AppMethodBeat.m2505o(6428);
    }

    /* renamed from: a */
    public final void mo38418a(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6429);
        boolean z = c24905d.bPP.getBoolean("is_favorite_item", false);
        boolean z2 = c24905d.bPP.getBoolean("key_detail_can_delete", true);
        if (z) {
            if (z2) {
                c44273l.mo70049a(3, context.getString(C25738R.string.f9088p4), (int) C1318a.bottomsheet_icon_del);
            }
            AppMethodBeat.m2505o(6429);
            return;
        }
        c44273l.mo70049a(3, context.getString(C25738R.string.dcq), (int) C1318a.bottomsheet_icon_fav);
        AppMethodBeat.m2505o(6429);
    }

    /* renamed from: a */
    public final void mo38417a(Context context, final C24905d c24905d) {
        AppMethodBeat.m2504i(6430);
        if (c24905d.bPP.getBoolean("is_favorite_item", false)) {
            C30379h.m48419a(context, context.getString(C25738R.string.f9089p5), null, null, context.getString(C25738R.string.f9088p4), new C30382d() {
                /* renamed from: bV */
                public final void mo4975bV(int i, int i2) {
                    AppMethodBeat.m2504i(6426);
                    switch (i2) {
                        case -1:
                            Bundle bundle = new Bundle();
                            bundle.putLong("fav_local_id", c24905d.bPP.getLong("fav_local_id", -1));
                            MainProcessTask favUrlTask = new FavUrlTask();
                            favUrlTask.actionType = 4;
                            favUrlTask.mqu = bundle;
                            AppBrandMainProcessService.m54355b(favUrlTask);
                            if (favUrlTask.csN) {
                                c24905d.finish();
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.m2505o(6426);
                }
            });
            C7060h.pYm.mo15419k(982, 3, 1);
            AppMethodBeat.m2505o(6430);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", c24905d.bPP.getLong("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", c24905d.bPP.getString("sns_local_id"));
        bundle.putInt("news_svr_id", c24905d.bPP.getInt("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", c24905d.bPP.getString("news_svr_tweetid"));
        bundle.putInt("message_index", c24905d.bPP.getInt("message_index", 0));
        String url = c24905d.getUrl();
        String cWL = c24905d.cWL();
        bundle.putString("rawUrl", cWL);
        if (!C5046bo.isNullOrNil(cWL) && cWL.endsWith("#rd")) {
            cWL = cWL.substring(0, cWL.length() - 3);
            if (!(C5046bo.isNullOrNil(url) || url.startsWith(cWL))) {
                bundle.putString("rawUrl", url);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(C5046bo.isNullOrNil(url) || url.startsWith(cWL))) {
            bundle.putString("rawUrl", url);
            bundle.putLong("msg_id", Long.MIN_VALUE);
            bundle.putString("sns_local_id", "");
        }
        bundle.putString("preChatName", c24905d.bPP.getString("preChatName"));
        bundle.putInt("preMsgIndex", c24905d.bPP.getInt("preMsgIndex", 0));
        bundle.putString("prePublishId", c24905d.bPP.getString("prePublishId"));
        bundle.putString("preUsername", c24905d.bPP.getString("preUsername"));
        MainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 1;
        favUrlTask.mqu = bundle;
        AppBrandMainProcessService.m54355b(favUrlTask);
        if (favUrlTask.uhJ) {
            C14492ap.m22691IF(1);
            c24905d.cWN().aen("sendAppMessage");
            c24905d.bPN.mo52826a(new C297771());
        } else {
            C45932c.m85258a(favUrlTask.ret, (Activity) context, this.mUw);
        }
        C7060h.pYm.mo15419k(982, 2, 1);
        AppMethodBeat.m2505o(6430);
    }
}
