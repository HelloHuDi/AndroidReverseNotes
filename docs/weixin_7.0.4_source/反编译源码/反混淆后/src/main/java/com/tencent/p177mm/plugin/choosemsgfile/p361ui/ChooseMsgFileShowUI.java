package com.tencent.p177mm.plugin.choosemsgfile.p361ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.pluginsdk.model.C44066p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.p685x5.sdk.C24544d;
import com.tencent.xweb.p685x5.sdk.C24544d.C24545a;
import org.json.JSONException;
import org.json.JSONObject;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI */
public class ChooseMsgFileShowUI extends MMActivity {
    private int kvD;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI$2 */
    class C202202 implements ValueCallback<String> {
        C202202() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(54433);
            C4990ab.m7417i("MicroMsg.ChooseMsgFileShowUI", "QB openReadFile, receiveValue = %s", (String) obj);
            if ("fileReaderClosed".equals((String) obj)) {
                ChooseMsgFileShowUI.this.finish();
            }
            AppMethodBeat.m2505o(54433);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m31262a(ChooseMsgFileShowUI chooseMsgFileShowUI, String str, String str2) {
        AppMethodBeat.m2504i(54438);
        chooseMsgFileShowUI.m31264dy(str, str2);
        AppMethodBeat.m2505o(54438);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(54434);
        super.onCreate(bundle);
        final String stringExtra = getIntent().getStringExtra("key_filepath");
        final String stringExtra2 = getIntent().getStringExtra("key_fileext");
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("path", stringExtra);
            jSONObject.putOpt("ext", stringExtra2);
            str = jSONObject.toString();
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.ChooseMsgFileShowUI", e, "", new Object[0]);
        }
        C24544d.m38196a(this, str, new ValueCallback<Boolean>() {

            /* renamed from: com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI$1$1 */
            class C28031 implements C24545a {
                C28031() {
                }

                public final void onViewInitFinished(boolean z) {
                    AppMethodBeat.m2504i(54431);
                    C4990ab.m7417i("MicroMsg.ChooseMsgFileShowUI", "tbs preInit callback, %b", Boolean.valueOf(z));
                    if (z) {
                        ChooseMsgFileShowUI.m31263b(ChooseMsgFileShowUI.this, stringExtra, stringExtra2);
                        AppMethodBeat.m2505o(54431);
                        return;
                    }
                    ChooseMsgFileShowUI.m31262a(ChooseMsgFileShowUI.this, stringExtra, stringExtra2);
                    AppMethodBeat.m2505o(54431);
                }
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.m2504i(54432);
                if (!((Boolean) obj).booleanValue()) {
                    ChooseMsgFileShowUI.m31262a(ChooseMsgFileShowUI.this, stringExtra, stringExtra2);
                    AppMethodBeat.m2505o(54432);
                } else if (C24544d.isTbsCoreInited()) {
                    ChooseMsgFileShowUI.m31263b(ChooseMsgFileShowUI.this, stringExtra, stringExtra2);
                    AppMethodBeat.m2505o(54432);
                } else {
                    C4990ab.m7416i("MicroMsg.ChooseMsgFileShowUI", "tbs preInit");
                    C24544d.m38195a(ChooseMsgFileShowUI.this, new C28031());
                    AppMethodBeat.m2505o(54432);
                }
            }
        });
        AppMethodBeat.m2505o(54434);
    }

    /* renamed from: dy */
    private void m31264dy(String str, String str2) {
        AppMethodBeat.m2504i(54435);
        Intent intent = new Intent();
        intent.setAction("MINIQB_OPEN_RET");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        C4990ab.m7417i("MicroMsg.ChooseMsgFileShowUI", "TBS MiniQB cannot open this file:%s", str);
        intent.putExtra("MINIQB_OPEN_RET_VAL", false);
        sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
        finish();
        AppMethodBeat.m2505o(54435);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(54436);
        if (this.kvD == 0) {
            try {
                C24544d.closeFileReader(this);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ChooseMsgFileShowUI", e, "", new Object[0]);
            }
        }
        super.onDestroy();
        AppMethodBeat.m2505o(54436);
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: q */
    public static void m31265q(Context context, String str, String str2) {
        AppMethodBeat.m2504i(54437);
        Intent intent = new Intent(context, ChooseMsgFileShowUI.class);
        intent.putExtra("key_filepath", str);
        intent.putExtra("key_fileext", str2);
        context.startActivity(intent);
        AppMethodBeat.m2505o(54437);
    }

    /* renamed from: b */
    static /* synthetic */ void m31263b(ChooseMsgFileShowUI chooseMsgFileShowUI, String str, String str2) {
        AppMethodBeat.m2504i(54439);
        chooseMsgFileShowUI.kvD = C44066p.m79209a(chooseMsgFileShowUI, str, str2, Integer.toString(chooseMsgFileShowUI.hashCode()), new C202202());
        C4990ab.m7417i("MicroMsg.ChooseMsgFileShowUI", "QB openReadFile, ret = %d", Integer.valueOf(chooseMsgFileShowUI.kvD));
        if (chooseMsgFileShowUI.kvD == ZipJNI.UNZ_PARAMERROR) {
            chooseMsgFileShowUI.m31264dy(str, str2);
        }
        AppMethodBeat.m2505o(54439);
    }
}
