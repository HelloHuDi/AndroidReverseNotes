package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.webview.model.C43911ah;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C43989k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C43989k.C14705a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C43989k.C40350c;
import com.tencent.p177mm.plugin.webview.stub.C46434d.C35624a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.b */
public class C29922b extends C43989k {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.b$a */
    class C29921a extends C40350c {
        private C29921a() {
            super();
        }

        /* synthetic */ C29921a(C29922b c29922b, byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(8676);
            C4990ab.m7416i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
            if (C29922b.this.fow == null) {
                C4990ab.m7412e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
                AppMethodBeat.m2505o(8676);
                return;
            }
            try {
                C29922b.this.uzS = C35624a.m58467G(iBinder);
                C29922b.this.uzS.mo15528a(C29922b.this.uJD, C29922b.this.fow.hashCode());
                C29922b.this.dcU();
                C29922b.this.mo38561a(C29922b.this.uzS, C29922b.this.uFu);
                C29922b.this.dbU();
                AppMethodBeat.m2505o(8676);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8676);
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(8677);
            super.onServiceDisconnected(componentName);
            AppMethodBeat.m2505o(8677);
        }
    }

    public C29922b(MMWebView mMWebView) {
        super(mMWebView, (byte) 0);
        AppMethodBeat.m2504i(8678);
        this.uJC = new C29921a(this, (byte) 0);
        AppMethodBeat.m2505o(8678);
    }

    public boolean agc(String str) {
        AppMethodBeat.m2504i(8679);
        boolean agc = super.agc(str);
        AppMethodBeat.m2505o(8679);
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
        AppMethodBeat.m2504i(8680);
        try {
            this.uzS.mo15533a(this.uJt, true, null);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (agD(this.uJt)) {
            AppMethodBeat.m2505o(8680);
            return;
        }
        Uri parse = Uri.parse(this.uJt);
        if (parse.getScheme() == null) {
            this.uJt += "http://";
            parse = Uri.parse(this.uJt);
        }
        if (parse.getScheme().startsWith("http")) {
            C4990ab.m7416i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
            this.uJr = new C14705a(this.uJy ? "" : this.uJt);
            this.uJy = false;
            if (!this.uJn && !this.uFu.has(this.uJt)) {
                if (afI(this.uJt)) {
                    mo38560NT(this.uJt);
                    this.uJu = this.uJt;
                }
                mo38570bI(this.uJt, false);
                AppMethodBeat.m2505o(8680);
            } else if (!C43911ah.aes(this.uJt)) {
                C4990ab.m7414f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.uJt);
                agd(this.uJt);
                AppMethodBeat.m2505o(8680);
            } else if (afI(this.uJt)) {
                mo38560NT(this.uJt);
                AppMethodBeat.m2505o(8680);
            } else {
                this.fow.loadUrl(this.uJt);
                AppMethodBeat.m2505o(8680);
            }
        } else if (C43911ah.aes(this.uJt)) {
            this.fow.loadUrl(this.uJt);
            AppMethodBeat.m2505o(8680);
        } else {
            agd(this.uJt);
            AppMethodBeat.m2505o(8680);
        }
    }
}
