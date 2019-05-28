package com.tencent.mm.plugin.webview.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.pluginsdk.ui.tools.u.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.b;

public final class i extends a implements OnCreateContextMenuListener {
    String icB;
    int icC;
    int icD;
    h icE;
    b icF;
    b icG;
    private c icL = new c() {
        public final void BY(String str) {
            AppMethodBeat.i(7626);
            if (i.this.cZu()) {
                AppMethodBeat.o(7626);
                return;
            }
            try {
                if (i.this.cZv().icy != null) {
                    i.this.cZv().icy.a(str, null, i.this.cZv().jLX, i.this.cZv().jLY);
                    AppMethodBeat.o(7626);
                    return;
                }
                ab.i("MicroMsg.WebViewLongClickHelper", "viewCaptureCallback, invoker is null");
                AppMethodBeat.o(7626);
            } catch (RemoteException e) {
                ab.e("MicroMsg.WebViewLongClickHelper", "recog failed");
                AppMethodBeat.o(7626);
            }
        }
    };

    public i(WebViewUI webViewUI) {
        super(webViewUI);
        AppMethodBeat.i(7633);
        AppMethodBeat.o(7633);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(7634);
        if (cZu()) {
            AppMethodBeat.o(7634);
            return;
        }
        try {
            b hitTestResult;
            if (view instanceof WebView) {
                hitTestResult = cZv().pzf.getHitTestResult();
                if (hitTestResult == null) {
                    AppMethodBeat.o(7634);
                    return;
                }
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                }
                AppMethodBeat.o(7634);
                return;
            }
            if (view instanceof MMWebView) {
                hitTestResult = ((MMWebView) view).getHitTestResult();
                if (hitTestResult == null) {
                    AppMethodBeat.o(7634);
                    return;
                } else if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    a(contextMenu, hitTestResult);
                }
            }
            AppMethodBeat.o(7634);
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu exp %s", e.getMessage());
            AppMethodBeat.o(7634);
        }
    }

    private boolean cWZ() {
        boolean z = false;
        AppMethodBeat.i(7635);
        int afH = cZv().afH(bo.nullAsNil(cZv().uwi));
        if (afH == 53 || afH == 52) {
            ab.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
            AppMethodBeat.o(7635);
        } else {
            try {
                if (cZv().icy == null) {
                    ab.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
                    AppMethodBeat.o(7635);
                } else {
                    z = cZv().icy.cZo();
                    AppMethodBeat.o(7635);
                }
            } catch (RemoteException e) {
                ab.e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + e.getMessage());
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(ContextMenu contextMenu, final String str) {
        AppMethodBeat.i(7638);
        if (cZu()) {
            AppMethodBeat.o(7638);
            return false;
        }
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = cZv().icy.isSDCardAvailable();
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (isSDCardAvailable) {
            contextMenu.setHeaderTitle(R.string.g2h);
            try {
                isSDCardAvailable = cZv().icy.cZd();
            } catch (Exception e2) {
                ab.e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", e2.getMessage());
                isSDCardAvailable = false;
            }
            ab.i("MicroMsg.WebViewLongClickHelper", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(cZv().icz.cZT().dmn()), Boolean.valueOf(cZv().icz.cZT().dmo()));
            if (isSDCardAvailable && r3) {
                contextMenu.add(0, 0, 0, cZv().getString(R.string.dhh)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(7628);
                        try {
                            u.a(i.this.cZv(), str, com.tencent.xweb.b.dTR().getCookie(str), i.this.cZv().icy.isSDCardAvailable(), new a() {
                                public final void BX(String str) {
                                    AppMethodBeat.i(7627);
                                    if (bo.isNullOrNil(str)) {
                                        ab.w("MicroMsg.WebViewLongClickHelper", "share image to friend fail, imgPath is null");
                                        AppMethodBeat.o(7627);
                                        return;
                                    }
                                    i.a(i.this, str);
                                    AppMethodBeat.o(7627);
                                }
                            });
                        } catch (Exception e) {
                            ab.e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + e.getMessage());
                        }
                        AppMethodBeat.o(7628);
                        return true;
                    }
                });
            }
            contextMenu.add(0, 0, 0, cZv().getString(R.string.dwz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    boolean isSDCardAvailable;
                    AppMethodBeat.i(7629);
                    try {
                        isSDCardAvailable = i.this.cZv().icy.isSDCardAvailable();
                    } catch (Exception e) {
                        ab.e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + e.getMessage());
                        isSDCardAvailable = false;
                    }
                    try {
                        u.a(i.this.cZv(), str, com.tencent.xweb.b.dTR().getCookie(str), isSDCardAvailable);
                    } catch (Exception e2) {
                        ab.e("MicroMsg.WebViewLongClickHelper", "save to sdcard failed : %s", e2.getMessage());
                    }
                    AppMethodBeat.o(7629);
                    return true;
                }
            });
            if (isSDCardAvailable && r4) {
                contextMenu.add(0, 0, 0, cZv().getString(R.string.dcq)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(7631);
                        try {
                            boolean isSDCardAvailable = i.this.cZv().icy.isSDCardAvailable();
                            String replaceAll = str.replaceAll("tp=webp", "");
                            u.a(i.this.cZv(), replaceAll, com.tencent.xweb.b.dTR().getCookie(replaceAll), isSDCardAvailable, new a() {
                                public final void BX(String str) {
                                    AppMethodBeat.i(7630);
                                    i.b(i.this, str);
                                    AppMethodBeat.o(7630);
                                }
                            });
                        } catch (Exception e) {
                            ab.e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + e.getMessage());
                        }
                        AppMethodBeat.o(7631);
                        return true;
                    }
                });
            }
            if (this.icB != null) {
                String string;
                final String str2 = this.icB;
                if (!com.tencent.mm.plugin.scanner.a.BR(this.icC)) {
                    if (com.tencent.mm.plugin.scanner.a.ba(this.icC, this.icB)) {
                        string = cZv().getString(R.string.diz);
                    } else if (com.tencent.mm.plugin.scanner.a.BQ(this.icC)) {
                        string = cZv().getString(R.string.dix);
                    }
                    if (!bo.isNullOrNil(string)) {
                        contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                            public final boolean onMenuItemClick(MenuItem menuItem) {
                                AppMethodBeat.i(7632);
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("preUsername", i.this.cZv().getIntent().getStringExtra("preUsername"));
                                    bundle.putString("preChatName", i.this.cZv().getIntent().getStringExtra("preChatName"));
                                    bundle.putString("rawUrl", i.this.cZv().cOG);
                                    i.this.cZv().icy.a(str2, i.this.cZv().dae(), i.afD(str), i.this.icC, i.this.icD, bundle);
                                    ab.i("MicroMsg.WebViewLongClickHelper", "onMenuItemClick recognize qbcode");
                                } catch (RemoteException e) {
                                    ab.e("MicroMsg.WebViewLongClickHelper", "recognize qbar result failed");
                                }
                                AppMethodBeat.o(7632);
                                return false;
                            }
                        });
                    }
                    this.icB = null;
                    AppMethodBeat.o(7638);
                    return true;
                }
                string = cZv().getString(R.string.diy);
                if (bo.isNullOrNil(string)) {
                }
                this.icB = null;
                AppMethodBeat.o(7638);
                return true;
            }
            AppMethodBeat.o(7638);
            return false;
        }
        AppMethodBeat.o(7638);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(ContextMenu contextMenu, b bVar) {
        AppMethodBeat.i(7636);
        if (!a(contextMenu, bVar.mExtra) && cZv().icz.cZT().dml() && cWZ()) {
            this.icG = bVar;
            this.icE = new h();
            this.icE.a(cZv().pzf, this.icL);
        }
        AppMethodBeat.o(7636);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(ContextMenu contextMenu, b bVar) {
        AppMethodBeat.i(7637);
        if (!a(contextMenu, bVar.mExtra) && cZv().icz.cZT().dml() && cWZ()) {
            this.icF = bVar;
            this.icE = new h();
            this.icE.a(cZv().pzf, this.icL);
        }
        AppMethodBeat.o(7637);
    }

    static /* synthetic */ String afD(String str) {
        AppMethodBeat.i(7641);
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(7641);
            return str;
        } else if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.o(7641);
            return str;
        } else {
            AppMethodBeat.o(7641);
            return str;
        }
    }
}
