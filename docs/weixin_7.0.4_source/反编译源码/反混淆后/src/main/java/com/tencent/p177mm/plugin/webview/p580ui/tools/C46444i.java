package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.plugin.webview.modeltools.C14543h;
import com.tencent.p177mm.plugin.webview.modeltools.C14543h.C14545c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u.C23348a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.WebView.C41116b;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.i */
public final class C46444i extends C35640a implements OnCreateContextMenuListener {
    String icB;
    int icC;
    int icD;
    C14543h icE;
    C41116b icF;
    C41116b icG;
    private C14545c icL = new C439651();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.i$1 */
    class C439651 implements C14545c {
        C439651() {
        }

        /* renamed from: BY */
        public final void mo26772BY(String str) {
            AppMethodBeat.m2504i(7626);
            if (C46444i.this.cZu()) {
                AppMethodBeat.m2505o(7626);
                return;
            }
            try {
                if (C46444i.this.cZv().icy != null) {
                    C46444i.this.cZv().icy.mo15531a(str, null, C46444i.this.cZv().jLX, C46444i.this.cZv().jLY);
                    AppMethodBeat.m2505o(7626);
                    return;
                }
                C4990ab.m7416i("MicroMsg.WebViewLongClickHelper", "viewCaptureCallback, invoker is null");
                AppMethodBeat.m2505o(7626);
            } catch (RemoteException e) {
                C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "recog failed");
                AppMethodBeat.m2505o(7626);
            }
        }
    }

    public C46444i(WebViewUI webViewUI) {
        super(webViewUI);
        AppMethodBeat.m2504i(7633);
        AppMethodBeat.m2505o(7633);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(7634);
        if (cZu()) {
            AppMethodBeat.m2505o(7634);
            return;
        }
        try {
            C41116b hitTestResult;
            if (view instanceof WebView) {
                hitTestResult = cZv().pzf.getHitTestResult();
                if (hitTestResult == null) {
                    AppMethodBeat.m2505o(7634);
                    return;
                }
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    mo74663b(contextMenu, hitTestResult);
                }
                AppMethodBeat.m2505o(7634);
                return;
            }
            if (view instanceof MMWebView) {
                hitTestResult = ((MMWebView) view).getHitTestResult();
                if (hitTestResult == null) {
                    AppMethodBeat.m2505o(7634);
                    return;
                } else if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    mo74662a(contextMenu, hitTestResult);
                }
            }
            AppMethodBeat.m2505o(7634);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu exp %s", e.getMessage());
            AppMethodBeat.m2505o(7634);
        }
    }

    private boolean cWZ() {
        boolean z = false;
        AppMethodBeat.m2504i(7635);
        int afH = cZv().afH(C5046bo.nullAsNil(cZv().uwi));
        if (afH == 53 || afH == 52) {
            C4990ab.m7416i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
            AppMethodBeat.m2505o(7635);
        } else {
            try {
                if (cZv().icy == null) {
                    C4990ab.m7420w("MicroMsg.WebViewLongClickHelper", "invoker is null");
                    AppMethodBeat.m2505o(7635);
                } else {
                    z = cZv().icy.cZo();
                    AppMethodBeat.m2505o(7635);
                }
            } catch (RemoteException e) {
                C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + e.getMessage());
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m87592a(ContextMenu contextMenu, final String str) {
        AppMethodBeat.m2504i(7638);
        if (cZu()) {
            AppMethodBeat.m2505o(7638);
            return false;
        }
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = cZv().icy.isSDCardAvailable();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (isSDCardAvailable) {
            contextMenu.setHeaderTitle(C25738R.string.g2h);
            try {
                isSDCardAvailable = cZv().icy.cZd();
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", e2.getMessage());
                isSDCardAvailable = false;
            }
            C4990ab.m7417i("MicroMsg.WebViewLongClickHelper", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(cZv().icz.cZT().dmn()), Boolean.valueOf(cZv().icz.cZT().dmo()));
            if (isSDCardAvailable && r3) {
                contextMenu.add(0, 0, 0, cZv().getString(C25738R.string.dhh)).setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.i$2$1 */
                    class C299271 implements C23348a {
                        C299271() {
                        }

                        /* renamed from: BX */
                        public final void mo26720BX(String str) {
                            AppMethodBeat.m2504i(7627);
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7420w("MicroMsg.WebViewLongClickHelper", "share image to friend fail, imgPath is null");
                                AppMethodBeat.m2505o(7627);
                                return;
                            }
                            C46444i.m87591a(C46444i.this, str);
                            AppMethodBeat.m2505o(7627);
                        }
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(7628);
                        try {
                            C30152u.m47741a(C46444i.this.cZv(), str, C44576b.dTR().getCookie(str), C46444i.this.cZv().icy.isSDCardAvailable(), new C299271());
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + e.getMessage());
                        }
                        AppMethodBeat.m2505o(7628);
                        return true;
                    }
                });
            }
            contextMenu.add(0, 0, 0, cZv().getString(C25738R.string.dwz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    boolean isSDCardAvailable;
                    AppMethodBeat.m2504i(7629);
                    try {
                        isSDCardAvailable = C46444i.this.cZv().icy.isSDCardAvailable();
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + e.getMessage());
                        isSDCardAvailable = false;
                    }
                    try {
                        C30152u.m47740a(C46444i.this.cZv(), str, C44576b.dTR().getCookie(str), isSDCardAvailable);
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.WebViewLongClickHelper", "save to sdcard failed : %s", e2.getMessage());
                    }
                    AppMethodBeat.m2505o(7629);
                    return true;
                }
            });
            if (isSDCardAvailable && r4) {
                contextMenu.add(0, 0, 0, cZv().getString(C25738R.string.dcq)).setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.i$4$1 */
                    class C356841 implements C23348a {
                        C356841() {
                        }

                        /* renamed from: BX */
                        public final void mo26720BX(String str) {
                            AppMethodBeat.m2504i(7630);
                            C46444i.m87593b(C46444i.this, str);
                            AppMethodBeat.m2505o(7630);
                        }
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(7631);
                        try {
                            boolean isSDCardAvailable = C46444i.this.cZv().icy.isSDCardAvailable();
                            String replaceAll = str.replaceAll("tp=webp", "");
                            C30152u.m47741a(C46444i.this.cZv(), replaceAll, C44576b.dTR().getCookie(replaceAll), isSDCardAvailable, new C356841());
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + e.getMessage());
                        }
                        AppMethodBeat.m2505o(7631);
                        return true;
                    }
                });
            }
            if (this.icB != null) {
                String string;
                final String str2 = this.icB;
                if (!C13119a.m21149BR(this.icC)) {
                    if (C13119a.m21150ba(this.icC, this.icB)) {
                        string = cZv().getString(C25738R.string.diz);
                    } else if (C13119a.m21148BQ(this.icC)) {
                        string = cZv().getString(C25738R.string.dix);
                    }
                    if (!C5046bo.isNullOrNil(string)) {
                        contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                            public final boolean onMenuItemClick(MenuItem menuItem) {
                                AppMethodBeat.m2504i(7632);
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("preUsername", C46444i.this.cZv().getIntent().getStringExtra("preUsername"));
                                    bundle.putString("preChatName", C46444i.this.cZv().getIntent().getStringExtra("preChatName"));
                                    bundle.putString("rawUrl", C46444i.this.cZv().cOG);
                                    C46444i.this.cZv().icy.mo15530a(str2, C46444i.this.cZv().dae(), C46444i.afD(str), C46444i.this.icC, C46444i.this.icD, bundle);
                                    C4990ab.m7416i("MicroMsg.WebViewLongClickHelper", "onMenuItemClick recognize qbcode");
                                } catch (RemoteException e) {
                                    C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "recognize qbar result failed");
                                }
                                AppMethodBeat.m2505o(7632);
                                return false;
                            }
                        });
                    }
                    this.icB = null;
                    AppMethodBeat.m2505o(7638);
                    return true;
                }
                string = cZv().getString(C25738R.string.diy);
                if (C5046bo.isNullOrNil(string)) {
                }
                this.icB = null;
                AppMethodBeat.m2505o(7638);
                return true;
            }
            AppMethodBeat.m2505o(7638);
            return false;
        }
        AppMethodBeat.m2505o(7638);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo74662a(ContextMenu contextMenu, C41116b c41116b) {
        AppMethodBeat.m2504i(7636);
        if (!m87592a(contextMenu, c41116b.mExtra) && cZv().icz.cZT().dml() && cWZ()) {
            this.icG = c41116b;
            this.icE = new C14543h();
            this.icE.mo26769a(cZv().pzf, this.icL);
        }
        AppMethodBeat.m2505o(7636);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo74663b(ContextMenu contextMenu, C41116b c41116b) {
        AppMethodBeat.m2504i(7637);
        if (!m87592a(contextMenu, c41116b.mExtra) && cZv().icz.cZT().dml() && cWZ()) {
            this.icF = c41116b;
            this.icE = new C14543h();
            this.icE.mo26769a(cZv().pzf, this.icL);
        }
        AppMethodBeat.m2505o(7637);
    }

    static /* synthetic */ String afD(String str) {
        AppMethodBeat.m2504i(7641);
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(7641);
            return str;
        } else if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(7641);
            return str;
        } else {
            AppMethodBeat.m2505o(7641);
            return str;
        }
    }
}
