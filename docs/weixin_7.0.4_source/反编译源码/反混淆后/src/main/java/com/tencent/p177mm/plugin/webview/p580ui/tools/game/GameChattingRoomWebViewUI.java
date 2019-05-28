package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.bizui.p1604a.C45756a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI */
public class GameChattingRoomWebViewUI extends WebViewUI {
    private String jumpUrl = "";
    private int uCW = 4;
    private int uCX = 5;
    final C30111a uCY = new C171031();
    final C30111a uCZ = new C171042();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI$1 */
    class C171031 implements C30111a {
        C171031() {
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(8643);
            GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.this.uCW, new Intent());
            GameChattingRoomWebViewUI.this.finish();
            AppMethodBeat.m2505o(8643);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI$2 */
    class C171042 implements C30111a {
        C171042() {
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(8644);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", GameChattingRoomWebViewUI.this.jumpUrl);
            GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.this.uCX, intent);
            GameChattingRoomWebViewUI.this.finish();
            AppMethodBeat.m2505o(8644);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameChattingRoomWebViewUI() {
        AppMethodBeat.m2504i(8645);
        AppMethodBeat.m2505o(8645);
    }

    public final boolean afM(String str) {
        return true;
    }

    public final void afL(String str) {
        AppMethodBeat.m2504i(8646);
        C4990ab.m7417i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", str);
        this.jumpUrl = str;
        String stringExtra = getIntent().getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        if (stringExtra != null) {
            String string;
            if (getIntent().getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING) == null) {
                string = getString(C25738R.string.f8823g1);
            } else {
                string = getString(C25738R.string.ata, new Object[]{getIntent().getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)});
            }
            String string2 = getString(C25738R.string.ath);
            if (stringExtra.equals("action_create")) {
                C45756a.m84568a(this.mController, getString(C25738R.string.b3n), string, string2, this.uCY, this.uCZ);
                AppMethodBeat.m2505o(8646);
                return;
            } else if (stringExtra.equals("action_join")) {
                C45756a.m84568a(this.mController, getString(C25738R.string.ck8), string, string2, this.uCY, this.uCZ);
            }
        }
        AppMethodBeat.m2505o(8646);
    }
}
