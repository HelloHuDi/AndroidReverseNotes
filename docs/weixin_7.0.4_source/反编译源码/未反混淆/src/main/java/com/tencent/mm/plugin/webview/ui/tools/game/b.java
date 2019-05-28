package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.k.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;

public class b extends k {

    class a extends c {
        private a() {
            super();
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(8676);
            ab.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
            if (b.this.fow == null) {
                ab.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
                AppMethodBeat.o(8676);
                return;
            }
            try {
                b.this.uzS = com.tencent.mm.plugin.webview.stub.d.a.G(iBinder);
                b.this.uzS.a(b.this.uJD, b.this.fow.hashCode());
                b.this.dcU();
                b.this.a(b.this.uzS, b.this.uFu);
                b.this.dbU();
                AppMethodBeat.o(8676);
            } catch (Exception e) {
                ab.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8676);
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(8677);
            super.onServiceDisconnected(componentName);
            AppMethodBeat.o(8677);
        }
    }

    public b(MMWebView mMWebView) {
        super(mMWebView, (byte) 0);
        AppMethodBeat.i(8678);
        this.uJC = new a(this, (byte) 0);
        AppMethodBeat.o(8678);
    }

    public boolean agc(String str) {
        AppMethodBeat.i(8679);
        boolean agc = super.agc(str);
        AppMethodBeat.o(8679);
        return agc;
    }

    public final boolean dbV() {
        return this.uJz;
    }

    public final String dbW() {
        return this.mTH;
    }

    public final Map dbX() {
        return this.uJB;
    }

    public void dbU() {
        AppMethodBeat.i(8680);
        try {
            this.uzS.a(this.uJt, true, null);
        } catch (Exception e) {
            ab.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (agD(this.uJt)) {
            AppMethodBeat.o(8680);
            return;
        }
        Uri parse = Uri.parse(this.uJt);
        if (parse.getScheme() == null) {
            this.uJt += "http://";
            parse = Uri.parse(this.uJt);
        }
        if (parse.getScheme().startsWith("http")) {
            ab.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
            this.uJr = new com.tencent.mm.plugin.webview.ui.tools.widget.k.a(this.uJy ? "" : this.uJt);
            this.uJy = false;
            if (!this.uJn && !this.uFu.has(this.uJt)) {
                if (afI(this.uJt)) {
                    NT(this.uJt);
                    this.uJu = this.uJt;
                }
                bI(this.uJt, false);
                AppMethodBeat.o(8680);
            } else if (!ah.aes(this.uJt)) {
                ab.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.uJt);
                agd(this.uJt);
                AppMethodBeat.o(8680);
            } else if (afI(this.uJt)) {
                NT(this.uJt);
                AppMethodBeat.o(8680);
            } else {
                this.fow.loadUrl(this.uJt);
                AppMethodBeat.o(8680);
            }
        } else if (ah.aes(this.uJt)) {
            this.fow.loadUrl(this.uJt);
            AppMethodBeat.o(8680);
        } else {
            agd(this.uJt);
            AppMethodBeat.o(8680);
        }
    }
}
