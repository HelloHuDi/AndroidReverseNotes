package com.tencent.mm.plugin.game.luggage.c.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.ap;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class g extends a {
    private b mUw = new b() {
        public final void aIu() {
            AppMethodBeat.i(135905);
            MainProcessTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            AppBrandMainProcessService.a(favUrlTask);
            AppMethodBeat.o(135905);
        }
    };

    public g() {
        super(4);
        AppMethodBeat.i(135906);
        AppMethodBeat.o(135906);
    }

    public final void a(Context context, d dVar, bbb bbb) {
        AppMethodBeat.i(135907);
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", dVar.bPP.getLong("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", dVar.bPP.getString("sns_local_id"));
        bundle.putInt("news_svr_id", dVar.bPP.getInt("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", dVar.bPP.getString("news_svr_tweetid"));
        bundle.putInt("message_index", dVar.bPP.getInt("message_index", 0));
        String url = dVar.getUrl();
        String cWL = dVar.cWL();
        bundle.putString("rawUrl", cWL);
        if (!bo.isNullOrNil(cWL) && cWL.endsWith("#rd")) {
            cWL = cWL.substring(0, cWL.length() - 3);
            if (!(bo.isNullOrNil(url) || url.startsWith(cWL))) {
                bundle.putString("rawUrl", url);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bo.isNullOrNil(url) || url.startsWith(cWL))) {
            bundle.putString("rawUrl", url);
            bundle.putLong("msg_id", Long.MIN_VALUE);
            bundle.putString("sns_local_id", "");
        }
        bundle.putString("preChatName", dVar.bPP.getString("preChatName"));
        bundle.putInt("preMsgIndex", dVar.bPP.getInt("preMsgIndex", 0));
        bundle.putString("prePublishId", dVar.bPP.getString("prePublishId"));
        bundle.putString("preUsername", dVar.bPP.getString("preUsername"));
        MainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 1;
        favUrlTask.mqu = bundle;
        AppBrandMainProcessService.b(favUrlTask);
        if (favUrlTask.uhJ) {
            ap.IF(1);
            dVar.bPN.a(new c() {
                public final String name() {
                    return "menu:share:appmessage";
                }

                public final JSONObject wQ() {
                    return null;
                }
            });
            AppMethodBeat.o(135907);
            return;
        }
        com.tencent.mm.plugin.fav.ui.c.a(favUrlTask.ret, (Activity) context, this.mUw);
        AppMethodBeat.o(135907);
    }
}
