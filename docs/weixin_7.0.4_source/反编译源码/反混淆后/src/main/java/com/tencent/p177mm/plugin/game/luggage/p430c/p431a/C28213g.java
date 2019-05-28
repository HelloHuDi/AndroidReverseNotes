package com.tencent.p177mm.plugin.game.luggage.p430c.p431a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24109b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C14492ap;
import com.tencent.p177mm.protocal.protobuf.bbb;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.c.a.g */
public final class C28213g extends C34289a {
    private C24109b mUw = new C32272();

    /* renamed from: com.tencent.mm.plugin.game.luggage.c.a.g$1 */
    class C32261 extends C17817c {
        C32261() {
        }

        public final String name() {
            return "menu:share:appmessage";
        }

        /* renamed from: wQ */
        public final JSONObject mo7075wQ() {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.c.a.g$2 */
    class C32272 implements C24109b {
        C32272() {
        }

        public final void aIu() {
            AppMethodBeat.m2504i(135905);
            MainProcessTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            AppBrandMainProcessService.m54349a(favUrlTask);
            AppMethodBeat.m2505o(135905);
        }
    }

    public C28213g() {
        super(4);
        AppMethodBeat.m2504i(135906);
        AppMethodBeat.m2505o(135906);
    }

    /* renamed from: a */
    public final void mo7540a(Context context, C24905d c24905d, bbb bbb) {
        AppMethodBeat.m2504i(135907);
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
            c24905d.bPN.mo52826a(new C32261());
            AppMethodBeat.m2505o(135907);
            return;
        }
        C45932c.m85258a(favUrlTask.ret, (Activity) context, this.mUw);
        AppMethodBeat.m2505o(135907);
    }
}
