package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class d extends a {
    private b mUw = new b() {
        public final void aIu() {
            AppMethodBeat.i(6427);
            MainProcessTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            AppBrandMainProcessService.a(favUrlTask);
            AppMethodBeat.o(6427);
        }
    };

    public d() {
        super(3);
        AppMethodBeat.i(6428);
        AppMethodBeat.o(6428);
    }

    public final void a(Context context, com.tencent.mm.plugin.webview.luggage.d dVar, l lVar) {
        AppMethodBeat.i(6429);
        boolean z = dVar.bPP.getBoolean("is_favorite_item", false);
        boolean z2 = dVar.bPP.getBoolean("key_detail_can_delete", true);
        if (z) {
            if (z2) {
                lVar.a(3, context.getString(R.string.p4), (int) R.raw.bottomsheet_icon_del);
            }
            AppMethodBeat.o(6429);
            return;
        }
        lVar.a(3, context.getString(R.string.dcq), (int) R.raw.bottomsheet_icon_fav);
        AppMethodBeat.o(6429);
    }

    public final void a(Context context, final com.tencent.mm.plugin.webview.luggage.d dVar) {
        AppMethodBeat.i(6430);
        if (dVar.bPP.getBoolean("is_favorite_item", false)) {
            h.a(context, context.getString(R.string.p5), null, null, context.getString(R.string.p4), new com.tencent.mm.ui.base.h.d() {
                public final void bV(int i, int i2) {
                    AppMethodBeat.i(6426);
                    switch (i2) {
                        case -1:
                            Bundle bundle = new Bundle();
                            bundle.putLong("fav_local_id", dVar.bPP.getLong("fav_local_id", -1));
                            MainProcessTask favUrlTask = new FavUrlTask();
                            favUrlTask.actionType = 4;
                            favUrlTask.mqu = bundle;
                            AppBrandMainProcessService.b(favUrlTask);
                            if (favUrlTask.csN) {
                                dVar.finish();
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(6426);
                }
            });
            com.tencent.mm.plugin.report.service.h.pYm.k(982, 3, 1);
            AppMethodBeat.o(6430);
            return;
        }
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
            dVar.cWN().aen("sendAppMessage");
            dVar.bPN.a(new c() {
                public final String name() {
                    return "menu:share:appmessage";
                }

                public final JSONObject wQ() {
                    return null;
                }
            });
        } else {
            com.tencent.mm.plugin.fav.ui.c.a(favUrlTask.ret, (Activity) context, this.mUw);
        }
        com.tencent.mm.plugin.report.service.h.pYm.k(982, 2, 1);
        AppMethodBeat.o(6430);
    }
}
