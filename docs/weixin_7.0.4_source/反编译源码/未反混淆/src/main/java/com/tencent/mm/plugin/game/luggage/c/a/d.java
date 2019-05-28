package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import org.json.JSONObject;

public final class d extends a {
    public d() {
        super(8);
    }

    public final void a(com.tencent.mm.plugin.webview.luggage.d dVar, l lVar, bbb bbb) {
        AppMethodBeat.i(135900);
        String appId = dVar.uij.getAppId();
        String string = dVar.bPP.getString("shortcut_user_name");
        if (!(dVar.bPP.getBoolean("from_shortcut", false) || bo.isNullOrNil(appId) || bo.isNullOrNil(string))) {
            lVar.e(bbb.wkB, bbb.Title + "__" + bbb.ThumbUrl);
        }
        AppMethodBeat.o(135900);
    }

    public final void a(final Context context, final com.tencent.mm.plugin.webview.luggage.d dVar, bbb bbb) {
        AppMethodBeat.i(135901);
        String string = dVar.bPP.getString("shortcut_user_name");
        String appId = dVar.uij.getAppId();
        if (bo.isNullOrNil(string) || bo.isNullOrNil(appId)) {
            AppMethodBeat.o(135901);
            return;
        }
        final MainProcessTask addShortcutTask = new AddShortcutTask();
        addShortcutTask.username = string;
        addShortcutTask.appId = appId;
        addShortcutTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(135899);
                addShortcutTask.aBW();
                dVar.bPN.a(new c() {
                    public final String name() {
                        return "onAddShortcutStatus";
                    }

                    public final JSONObject wQ() {
                        AppMethodBeat.i(135897);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("success", addShortcutTask.success);
                        } catch (Exception e) {
                        }
                        AppMethodBeat.o(135897);
                        return jSONObject;
                    }
                });
                if (addShortcutTask.success) {
                    h.a(context, (int) R.string.g1s, (int) R.string.tz, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(135898);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(135898);
                        }
                    });
                    AppMethodBeat.o(135899);
                    return;
                }
                Toast.makeText(context, context.getString(R.string.g1r), 0).show();
                AppMethodBeat.o(135899);
            }
        };
        addShortcutTask.aBV();
        AppBrandMainProcessService.a(addShortcutTask);
        AppMethodBeat.o(135901);
    }
}
