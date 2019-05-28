package com.tencent.mm.plugin.choosemsgfile.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.xweb.x5.sdk.d;
import org.json.JSONException;
import org.json.JSONObject;

@a(3)
public class ChooseMsgFileShowUI extends MMActivity {
    private int kvD;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ChooseMsgFileShowUI chooseMsgFileShowUI, String str, String str2) {
        AppMethodBeat.i(54438);
        chooseMsgFileShowUI.dy(str, str2);
        AppMethodBeat.o(54438);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(54434);
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
            ab.printErrStackTrace("MicroMsg.ChooseMsgFileShowUI", e, "", new Object[0]);
        }
        d.a(this, str, new ValueCallback<Boolean>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(54432);
                if (!((Boolean) obj).booleanValue()) {
                    ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this, stringExtra, stringExtra2);
                    AppMethodBeat.o(54432);
                } else if (d.isTbsCoreInited()) {
                    ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, stringExtra, stringExtra2);
                    AppMethodBeat.o(54432);
                } else {
                    ab.i("MicroMsg.ChooseMsgFileShowUI", "tbs preInit");
                    d.a(ChooseMsgFileShowUI.this, new d.a() {
                        public final void onViewInitFinished(boolean z) {
                            AppMethodBeat.i(54431);
                            ab.i("MicroMsg.ChooseMsgFileShowUI", "tbs preInit callback, %b", Boolean.valueOf(z));
                            if (z) {
                                ChooseMsgFileShowUI.b(ChooseMsgFileShowUI.this, stringExtra, stringExtra2);
                                AppMethodBeat.o(54431);
                                return;
                            }
                            ChooseMsgFileShowUI.a(ChooseMsgFileShowUI.this, stringExtra, stringExtra2);
                            AppMethodBeat.o(54431);
                        }
                    });
                    AppMethodBeat.o(54432);
                }
            }
        });
        AppMethodBeat.o(54434);
    }

    private void dy(String str, String str2) {
        AppMethodBeat.i(54435);
        Intent intent = new Intent();
        intent.setAction("MINIQB_OPEN_RET");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        ab.i("MicroMsg.ChooseMsgFileShowUI", "TBS MiniQB cannot open this file:%s", str);
        intent.putExtra("MINIQB_OPEN_RET_VAL", false);
        sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
        finish();
        AppMethodBeat.o(54435);
    }

    public void onDestroy() {
        AppMethodBeat.i(54436);
        if (this.kvD == 0) {
            try {
                d.closeFileReader(this);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ChooseMsgFileShowUI", e, "", new Object[0]);
            }
        }
        super.onDestroy();
        AppMethodBeat.o(54436);
    }

    public final int getLayoutId() {
        return -1;
    }

    public static void q(Context context, String str, String str2) {
        AppMethodBeat.i(54437);
        Intent intent = new Intent(context, ChooseMsgFileShowUI.class);
        intent.putExtra("key_filepath", str);
        intent.putExtra("key_fileext", str2);
        context.startActivity(intent);
        AppMethodBeat.o(54437);
    }

    static /* synthetic */ void b(ChooseMsgFileShowUI chooseMsgFileShowUI, String str, String str2) {
        AppMethodBeat.i(54439);
        chooseMsgFileShowUI.kvD = p.a(chooseMsgFileShowUI, str, str2, Integer.toString(chooseMsgFileShowUI.hashCode()), new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(54433);
                ab.i("MicroMsg.ChooseMsgFileShowUI", "QB openReadFile, receiveValue = %s", (String) obj);
                if ("fileReaderClosed".equals((String) obj)) {
                    ChooseMsgFileShowUI.this.finish();
                }
                AppMethodBeat.o(54433);
            }
        });
        ab.i("MicroMsg.ChooseMsgFileShowUI", "QB openReadFile, ret = %d", Integer.valueOf(chooseMsgFileShowUI.kvD));
        if (chooseMsgFileShowUI.kvD == ZipJNI.UNZ_PARAMERROR) {
            chooseMsgFileShowUI.dy(str, str2);
        }
        AppMethodBeat.o(54439);
    }
}
