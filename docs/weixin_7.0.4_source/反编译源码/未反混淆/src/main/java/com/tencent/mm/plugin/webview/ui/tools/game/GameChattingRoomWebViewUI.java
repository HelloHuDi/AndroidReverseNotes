package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ab;

public class GameChattingRoomWebViewUI extends WebViewUI {
    private String jumpUrl = "";
    private int uCW = 4;
    private int uCX = 5;
    final a uCY = new a() {
        public final void a(boolean z, String str, int i) {
            AppMethodBeat.i(8643);
            GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.this.uCW, new Intent());
            GameChattingRoomWebViewUI.this.finish();
            AppMethodBeat.o(8643);
        }
    };
    final a uCZ = new a() {
        public final void a(boolean z, String str, int i) {
            AppMethodBeat.i(8644);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", GameChattingRoomWebViewUI.this.jumpUrl);
            GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.this.uCX, intent);
            GameChattingRoomWebViewUI.this.finish();
            AppMethodBeat.o(8644);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameChattingRoomWebViewUI() {
        AppMethodBeat.i(8645);
        AppMethodBeat.o(8645);
    }

    public final boolean afM(String str) {
        return true;
    }

    public final void afL(String str) {
        AppMethodBeat.i(8646);
        ab.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", str);
        this.jumpUrl = str;
        String stringExtra = getIntent().getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        if (stringExtra != null) {
            String string;
            if (getIntent().getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING) == null) {
                string = getString(R.string.g1);
            } else {
                string = getString(R.string.ata, new Object[]{getIntent().getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)});
            }
            String string2 = getString(R.string.ath);
            if (stringExtra.equals("action_create")) {
                com.tencent.mm.plugin.bizui.a.a.a(this.mController, getString(R.string.b3n), string, string2, this.uCY, this.uCZ);
                AppMethodBeat.o(8646);
                return;
            } else if (stringExtra.equals("action_join")) {
                com.tencent.mm.plugin.bizui.a.a.a(this.mController, getString(R.string.ck8), string, string2, this.uCY, this.uCZ);
            }
        }
        AppMethodBeat.o(8646);
    }
}
