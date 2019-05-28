package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.xweb.x5.sdk.d;

@a(3)
public class MiniQBReaderUI extends MMActivity {
    private int ret = -1;
    private String vuT = Integer.toString(hashCode());

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MiniQBReaderUI() {
        AppMethodBeat.i(28171);
        AppMethodBeat.o(28171);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(28172);
        super.onCreate(bundle);
        ab.i("MicroMsg.MiniQBReaderUI", "onCreate");
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("file_path");
        String stringExtra2 = intent.getStringExtra("file_ext");
        this.ret = p.a(this, stringExtra, stringExtra2, this.vuT, new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(28170);
                ab.i("MicroMsg.MiniQBReaderUI", "startMiniQBToLoadUrl, onReceiveValue: %s", (String) obj);
                if ("fileReaderClosed".equals((String) obj)) {
                    MiniQBReaderUI.this.finish();
                }
                AppMethodBeat.o(28170);
            }
        });
        ab.i("MicroMsg.MiniQBReaderUI", "tryOpenByQbSdk , ret:%b", Integer.valueOf(this.ret));
        new StringBuilder("tryOpenByQbSdk , ret:").append(this.ret);
        Intent intent2 = new Intent();
        intent2.setAction("MINIQB_OPEN_RET");
        intent2.putExtra("file_path", stringExtra);
        intent2.putExtra("file_ext", stringExtra2);
        stringExtra2 = "MINIQB_OPEN_RET_VAL";
        if (this.ret != 0) {
            z = false;
        }
        intent2.putExtra(stringExtra2, z);
        sendBroadcast(intent2, WXApp.WXAPP_BROADCAST_PERMISSION);
        if (this.ret != 0) {
            finish();
        }
        AppMethodBeat.o(28172);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(28173);
        super.onNewIntent(intent);
        ab.i("MicroMsg.MiniQBReaderUI", "onNewIntent");
        AppMethodBeat.o(28173);
    }

    public void onDestroy() {
        AppMethodBeat.i(28174);
        ab.i("MicroMsg.MiniQBReaderUI", "onDestroy");
        if (this.ret == 0) {
            try {
                d.closeFileReader(this);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MiniQBReaderUI", e, "", new Object[0]);
            }
        }
        super.onDestroy();
        AppMethodBeat.o(28174);
    }
}
