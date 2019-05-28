package com.tencent.p177mm.plugin.game.luggage.p430c.p431a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.protocal.protobuf.bbb;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.c.a.d */
public final class C39207d extends C34289a {
    public C39207d() {
        super(8);
    }

    /* renamed from: a */
    public final void mo54819a(C24905d c24905d, C44273l c44273l, bbb bbb) {
        AppMethodBeat.m2504i(135900);
        String appId = c24905d.uij.getAppId();
        String string = c24905d.bPP.getString("shortcut_user_name");
        if (!(c24905d.bPP.getBoolean("from_shortcut", false) || C5046bo.isNullOrNil(appId) || C5046bo.isNullOrNil(string))) {
            c44273l.mo70068e(bbb.wkB, bbb.Title + "__" + bbb.ThumbUrl);
        }
        AppMethodBeat.m2505o(135900);
    }

    /* renamed from: a */
    public final void mo7540a(final Context context, final C24905d c24905d, bbb bbb) {
        AppMethodBeat.m2504i(135901);
        String string = c24905d.bPP.getString("shortcut_user_name");
        String appId = c24905d.uij.getAppId();
        if (C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(appId)) {
            AppMethodBeat.m2505o(135901);
            return;
        }
        final MainProcessTask addShortcutTask = new AddShortcutTask();
        addShortcutTask.username = string;
        addShortcutTask.appId = appId;
        addShortcutTask.hww = new Runnable() {

            /* renamed from: com.tencent.mm.plugin.game.luggage.c.a.d$1$1 */
            class C209771 extends C17817c {
                C209771() {
                }

                public final String name() {
                    return "onAddShortcutStatus";
                }

                /* renamed from: wQ */
                public final JSONObject mo7075wQ() {
                    AppMethodBeat.m2504i(135897);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("success", addShortcutTask.success);
                    } catch (Exception e) {
                    }
                    AppMethodBeat.m2505o(135897);
                    return jSONObject;
                }
            }

            /* renamed from: com.tencent.mm.plugin.game.luggage.c.a.d$1$2 */
            class C209782 implements OnClickListener {
                C209782() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(135898);
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(135898);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(135899);
                addShortcutTask.aBW();
                c24905d.bPN.mo52826a(new C209771());
                if (addShortcutTask.success) {
                    C30379h.m48433a(context, (int) C25738R.string.g1s, (int) C25738R.string.f9238tz, false, new C209782());
                    AppMethodBeat.m2505o(135899);
                    return;
                }
                Toast.makeText(context, context.getString(C25738R.string.g1r), 0).show();
                AppMethodBeat.m2505o(135899);
            }
        };
        addShortcutTask.aBV();
        AppBrandMainProcessService.m54349a(addShortcutTask);
        AppMethodBeat.m2505o(135901);
    }
}
