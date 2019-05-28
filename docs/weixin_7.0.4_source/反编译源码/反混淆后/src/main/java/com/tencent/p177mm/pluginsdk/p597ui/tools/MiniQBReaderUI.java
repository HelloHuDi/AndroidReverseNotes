package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.pluginsdk.model.C44066p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.p685x5.sdk.C24544d;

@C5271a(3)
/* renamed from: com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI */
public class MiniQBReaderUI extends MMActivity {
    private int ret = -1;
    private String vuT = Integer.toString(hashCode());

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI$1 */
    class C233421 implements ValueCallback<String> {
        C233421() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(28170);
            C4990ab.m7417i("MicroMsg.MiniQBReaderUI", "startMiniQBToLoadUrl, onReceiveValue: %s", (String) obj);
            if ("fileReaderClosed".equals((String) obj)) {
                MiniQBReaderUI.this.finish();
            }
            AppMethodBeat.m2505o(28170);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MiniQBReaderUI() {
        AppMethodBeat.m2504i(28171);
        AppMethodBeat.m2505o(28171);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.m2504i(28172);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.MiniQBReaderUI", "onCreate");
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("file_path");
        String stringExtra2 = intent.getStringExtra("file_ext");
        this.ret = C44066p.m79209a(this, stringExtra, stringExtra2, this.vuT, new C233421());
        C4990ab.m7417i("MicroMsg.MiniQBReaderUI", "tryOpenByQbSdk , ret:%b", Integer.valueOf(this.ret));
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
        AppMethodBeat.m2505o(28172);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(28173);
        super.onNewIntent(intent);
        C4990ab.m7416i("MicroMsg.MiniQBReaderUI", "onNewIntent");
        AppMethodBeat.m2505o(28173);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(28174);
        C4990ab.m7416i("MicroMsg.MiniQBReaderUI", "onDestroy");
        if (this.ret == 0) {
            try {
                C24544d.closeFileReader(this);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MiniQBReaderUI", e, "", new Object[0]);
            }
        }
        super.onDestroy();
        AppMethodBeat.m2505o(28174);
    }
}
