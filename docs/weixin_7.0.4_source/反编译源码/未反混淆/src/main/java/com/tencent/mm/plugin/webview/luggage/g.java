package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.tools.j;
import java.util.HashMap;
import java.util.Map;

public final class g implements OnCreateContextMenuListener {
    j icA;
    String icB;
    int icC;
    int icD;
    h icE;
    com.tencent.xweb.WebView.b icF;
    com.tencent.xweb.WebView.b icG;
    private com.tencent.mm.plugin.webview.modeltools.h.c icL = new com.tencent.mm.plugin.webview.modeltools.h.c() {
        public final void BY(String str) {
            AppMethodBeat.i(6120);
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            bundle.putString("img_path", str);
            f.a("com.tencent.mm", bundle, c.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(6119);
                    Bundle bundle = (Bundle) obj;
                    g.a(g.this, bundle.getString("file_path"), bundle.getString("result"), bundle.getInt("code_type"), bundle.getInt("code_version"));
                    AppMethodBeat.o(6119);
                }
            });
            AppMethodBeat.o(6120);
        }
    };
    private com.tencent.mm.ui.widget.snackbar.a.b mUw = new com.tencent.mm.ui.widget.snackbar.a.b() {
        public final void aIu() {
            AppMethodBeat.i(6130);
            MainProcessTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            AppBrandMainProcessService.a(favUrlTask);
            AppMethodBeat.o(6130);
        }
    };
    d uiI;

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(6133);
            Bundle bundle = (Bundle) obj;
            cl clVar = new cl();
            ((ad) com.tencent.mm.kernel.g.K(ad.class)).a(clVar, 1, bundle.getString("image_path", ""));
            com.tencent.mm.sdk.b.a.xxA.m(clVar);
            bundle.putInt("fav_simple_img_result", clVar.cvB.ret);
            cVar.ao(bundle);
            AppMethodBeat.o(6133);
        }
    }

    static class c implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private com.tencent.mm.sdk.b.c eFv = new com.tencent.mm.sdk.b.c<nr>() {
            {
                AppMethodBeat.i(6136);
                this.xxI = nr.class.getName().hashCode();
                AppMethodBeat.o(6136);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(6137);
                nr nrVar = (nr) bVar;
                ab.d("MicroMsg.QBarLogicTask", "mRecogResultListener");
                if (!(nrVar instanceof nr)) {
                    AppMethodBeat.o(6137);
                } else if (c.this.uiP == null || c.this.uiP.containsKey(nrVar.cJX.filePath)) {
                    if (c.this.uiP != null) {
                        c.this.uiP.remove(nrVar.cJX.filePath);
                    }
                    ab.d("MicroMsg.QBarLogicTask", "result: " + nrVar.cJX.result);
                    Bundle bundle = new Bundle();
                    bundle.putString("file_path", nrVar.cJX.filePath);
                    bundle.putString("result", nrVar.cJX.result);
                    bundle.putInt("code_type", nrVar.cJX.cvn);
                    bundle.putInt("code_version", nrVar.cJX.cvo);
                    c.this.eGc.ao(bundle);
                    AppMethodBeat.o(6137);
                } else {
                    AppMethodBeat.o(6137);
                }
                return false;
            }
        };
        private com.tencent.mm.ipcinvoker.c eGc;
        private Map<String, Integer> uiP;

        private c() {
            AppMethodBeat.i(6138);
            AppMethodBeat.o(6138);
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(6139);
            Bundle bundle = (Bundle) obj;
            this.eGc = cVar;
            int i = bundle.getInt("type");
            String string = bundle.getString("img_path");
            switch (i) {
                case 1:
                    if (this.uiP == null) {
                        this.uiP = new HashMap();
                        com.tencent.mm.sdk.b.a.xxA.c(this.eFv);
                    }
                    np npVar = new np();
                    npVar.cJU.filePath = string;
                    com.tencent.mm.sdk.b.a.xxA.m(npVar);
                    this.uiP.put(string, Integer.valueOf(1));
                    AppMethodBeat.o(6139);
                    return;
                case 2:
                    if (this.uiP != null && this.uiP.containsKey(string)) {
                        an anVar = new an();
                        anVar.ctC.filePath = string;
                        com.tencent.mm.sdk.b.a.xxA.m(anVar);
                        this.uiP.remove(string);
                        break;
                    }
                    ab.e("MicroMsg.QBarLogicTask", "%s is not recognizing", string);
                    AppMethodBeat.o(6139);
                    return;
            }
            AppMethodBeat.o(6139);
        }
    }

    static class b implements i<IPCBoolean, IPCBoolean> {
        private b() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(6135);
            IPCBoolean cXa = cXa();
            AppMethodBeat.o(6135);
            return cXa;
        }

        private static IPCBoolean cXa() {
            int i;
            boolean z = true;
            AppMethodBeat.i(6134);
            IPCBoolean iPCBoolean = new IPCBoolean();
            try {
                i = bo.getInt(com.tencent.mm.m.g.Nu().getValue("EnableWebviewScanQRCode"), 1);
            } catch (Exception e) {
                ab.e("MicroMsg.GameWebViewMenuListHelper", "isAllowScanQRCode parseInt failed");
                i = 0;
            }
            if (i != 1) {
                z = false;
            }
            iPCBoolean.value = z;
            AppMethodBeat.o(6134);
            return iPCBoolean;
        }
    }

    static class d implements com.tencent.mm.plugin.webview.luggage.ipc.c {
        private d() {
        }

        public final void a(Context context, Bundle bundle, com.tencent.mm.plugin.webview.luggage.ipc.a aVar) {
            AppMethodBeat.i(6140);
            String string = bundle.getString("result");
            if (bo.isNullOrNil(string)) {
                AppMethodBeat.o(6140);
                return;
            }
            String string2 = bundle.getString("url");
            int i = bundle.getInt("codeType");
            int i2 = bundle.getInt("codeVersion");
            Intent intent = new Intent();
            intent.setClass(context, WebviewScanImageActivity.class);
            intent.setFlags(603979776);
            intent.putExtra("key_string_for_scan", string);
            intent.putExtra("key_string_for_url", string2);
            intent.putExtra("key_codetype_for_scan", i);
            intent.putExtra("key_codeversion_for_scan", i2);
            context.startActivity(intent);
            aVar.l(null);
            AppMethodBeat.o(6140);
        }
    }

    static class e implements com.tencent.mm.plugin.webview.luggage.ipc.c {
        private e() {
        }

        public final void a(Context context, Bundle bundle, final com.tencent.mm.plugin.webview.luggage.ipc.a aVar) {
            AppMethodBeat.i(6143);
            String string = bundle.getString("img_path");
            if (r.amo(string)) {
                EmojiInfo Jd;
                EmojiInfo Jd2 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(com.tencent.mm.a.g.cz(string));
                if (Jd2 == null || !Jd2.duP()) {
                    com.tencent.mm.pluginsdk.a.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                    ah.getContext();
                    Jd = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(emojiMgr.Jf(string));
                } else {
                    Jd = Jd2;
                }
                boolean cs = Jd == null ? false : com.tencent.mm.a.e.cs(Jd.dve());
                String dve = Jd == null ? string : Jd.dve();
                Options options = new Options();
                options.inJustDecodeBounds = true;
                boolean z;
                if ((com.tencent.mm.sdk.platformtools.d.decodeFile(dve, options) == null || options.outHeight <= com.tencent.mm.m.b.Na()) && options.outWidth <= com.tencent.mm.m.b.Na()) {
                    z = false;
                } else {
                    z = true;
                }
                if (cs > com.tencent.mm.m.b.Nb() || z) {
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.string.b9x), "", context.getString(R.string.cd_), null);
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.string.b9x), "", context.getString(R.string.cd_), "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(6141);
                            aVar.l(null);
                            AppMethodBeat.o(6141);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(6142);
                            aVar.l(null);
                            AppMethodBeat.o(6142);
                        }
                    });
                    AppMethodBeat.o(6143);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", Jd != null ? Jd.Aq() : "");
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                com.tencent.mm.plugin.webview.a.a.gkE.k(intent, context);
                aVar.l(null);
                AppMethodBeat.o(6143);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", string);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.addFlags(268435456);
            com.tencent.mm.plugin.webview.a.a.gkE.k(intent2, context);
            aVar.l(null);
            AppMethodBeat.o(6143);
        }
    }

    public g(d dVar) {
        AppMethodBeat.i(6144);
        this.uiI = dVar;
        this.icA = new j(dVar.mContext);
        this.icA.a(dVar.getWebView(), this, null);
        this.icA.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(6121);
                if (g.this.icE != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 2);
                    bundle.putString("img_path", g.this.icE.upr);
                    f.a("com.tencent.mm", bundle, c.class, null);
                    g.this.icE.cYK();
                }
                AppMethodBeat.o(6121);
            }
        });
        AppMethodBeat.o(6144);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(6145);
        ab.d("MicroMsg.GameWebViewMenuListHelper", "onCreateContextMenu");
        com.tencent.xweb.WebView.b hitTestResult;
        if (view instanceof WebView) {
            hitTestResult = this.uiI.getWebView().getHitTestResult();
            if (hitTestResult == null) {
                AppMethodBeat.o(6145);
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                b(contextMenu, hitTestResult);
            }
            AppMethodBeat.o(6145);
            return;
        }
        hitTestResult = this.uiI.getWebView().getHitTestResult();
        if (hitTestResult == null) {
            AppMethodBeat.o(6145);
            return;
        }
        if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
            a(contextMenu, hitTestResult);
        }
        AppMethodBeat.o(6145);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(ContextMenu contextMenu, final String str) {
        AppMethodBeat.i(6146);
        if (com.tencent.mm.compatible.util.f.Mn()) {
            boolean RK;
            if (ah.bqo()) {
                RK = com.tencent.mm.kernel.g.RK();
            } else {
                Bundle bundle = (Bundle) f.a("com.tencent.mm", null, com.tencent.mm.plugin.webview.luggage.c.c.b.class);
                RK = bundle != null ? bundle.getBoolean("has_set_uin", false) : true;
            }
            contextMenu.setHeaderTitle(R.string.g2h);
            ab.i("MicroMsg.GameWebViewMenuListHelper", "hasSetAcc = %b", Boolean.valueOf(RK));
            if (RK) {
                contextMenu.add(0, 0, 0, this.uiI.mContext.getString(R.string.dhh)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(6125);
                        u.a(g.this.uiI.mContext, str, com.tencent.xweb.b.dTR().getCookie(str), com.tencent.mm.compatible.util.f.Mn(), new com.tencent.mm.pluginsdk.ui.tools.u.a() {
                            public final void BX(String str) {
                                AppMethodBeat.i(6124);
                                if (bo.isNullOrNil(str)) {
                                    ab.w("MicroMsg.GameWebViewMenuListHelper", "share image to friend fail, imgPath is null");
                                    AppMethodBeat.o(6124);
                                    return;
                                }
                                g.a(g.this, str);
                                AppMethodBeat.o(6124);
                            }
                        });
                        AppMethodBeat.o(6125);
                        return true;
                    }
                });
            }
            contextMenu.add(0, 0, 0, this.uiI.mContext.getString(R.string.dwz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(6126);
                    try {
                        u.a(g.this.uiI.mContext, str, com.tencent.xweb.b.dTR().getCookie(str), com.tencent.mm.compatible.util.f.Mn());
                    } catch (Exception e) {
                        ab.e("MicroMsg.GameWebViewMenuListHelper", "save to sdcard failed : %s", e.getMessage());
                    }
                    AppMethodBeat.o(6126);
                    return true;
                }
            });
            if (RK) {
                contextMenu.add(0, 0, 0, this.uiI.mContext.getString(R.string.dcq)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(6128);
                        String replaceAll = str.replaceAll("tp=webp", "");
                        u.a(g.this.uiI.mContext, replaceAll, com.tencent.xweb.b.dTR().getCookie(replaceAll), com.tencent.mm.compatible.util.f.Mn(), new com.tencent.mm.pluginsdk.ui.tools.u.a() {
                            public final void BX(String str) {
                                AppMethodBeat.i(6127);
                                g.b(g.this, str);
                                AppMethodBeat.o(6127);
                            }
                        });
                        AppMethodBeat.o(6128);
                        return true;
                    }
                });
            }
            if (this.icB != null) {
                String string;
                final String str2 = this.icB;
                if (!com.tencent.mm.plugin.scanner.a.BR(this.icC)) {
                    if (com.tencent.mm.plugin.scanner.a.ba(this.icC, this.icB)) {
                        string = this.uiI.mContext.getString(R.string.diz);
                    } else if (com.tencent.mm.plugin.scanner.a.BQ(this.icC)) {
                        string = this.uiI.mContext.getString(R.string.dix);
                    }
                    if (!bo.isNullOrNil(string)) {
                        contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                            public final boolean onMenuItemClick(MenuItem menuItem) {
                                AppMethodBeat.i(6129);
                                ab.i("MicroMsg.GameWebViewMenuListHelper", "onMenuItemClick recognize qbcode");
                                Bundle bundle = new Bundle();
                                bundle.putString("result", str2);
                                bundle.putString("url", g.b(g.this));
                                bundle.putInt("codeType", g.this.icC);
                                bundle.putInt("codeVersion", g.this.icD);
                                com.tencent.mm.plugin.webview.luggage.ipc.b.a(g.this.uiI.mContext, bundle, d.class);
                                AppMethodBeat.o(6129);
                                return false;
                            }
                        });
                    }
                    this.icB = null;
                    AppMethodBeat.o(6146);
                    return true;
                }
                string = this.uiI.mContext.getString(R.string.diy);
                if (bo.isNullOrNil(string)) {
                }
                this.icB = null;
                AppMethodBeat.o(6146);
                return true;
            }
            AppMethodBeat.o(6146);
            return false;
        }
        ab.e("MicroMsg.GameWebViewMenuListHelper", "SD card unavailable");
        AppMethodBeat.o(6146);
        return true;
    }

    private static boolean cWZ() {
        AppMethodBeat.i(6149);
        IPCBoolean iPCBoolean = (IPCBoolean) f.a("com.tencent.mm", null, b.class);
        if (iPCBoolean != null) {
            boolean z = iPCBoolean.value;
            AppMethodBeat.o(6149);
            return z;
        }
        AppMethodBeat.o(6149);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void a(ContextMenu contextMenu, com.tencent.xweb.WebView.b bVar) {
        AppMethodBeat.i(6147);
        if (!a(contextMenu, bVar.mExtra) && this.uiI.cWM().aej(this.uiI.getUrl()).dml() && cWZ()) {
            this.icG = bVar;
            this.icE = new h();
            this.icE.a(this.uiI.getWebView(), this.icL);
        }
        AppMethodBeat.o(6147);
    }

    /* Access modifiers changed, original: final */
    public final void b(ContextMenu contextMenu, com.tencent.xweb.WebView.b bVar) {
        AppMethodBeat.i(6148);
        if (!a(contextMenu, bVar.mExtra) && this.uiI.cWM().aej(this.uiI.getUrl()).dml() && cWZ()) {
            this.icF = bVar;
            this.icE = new h();
            this.icE.a(this.uiI.getWebView(), this.icL);
        }
        AppMethodBeat.o(6148);
    }

    static /* synthetic */ void a(g gVar, String str, final String str2, int i, int i2) {
        AppMethodBeat.i(6150);
        ab.d("MicroMsg.GameWebViewMenuListHelper", "result: ".concat(String.valueOf(str2)));
        if (gVar.icE == null || str == null || !str.equals(gVar.icE.upr)) {
            AppMethodBeat.o(6150);
            return;
        }
        if (gVar.icE != null) {
            gVar.icE.cYK();
        }
        gVar.icC = i;
        gVar.icD = i2;
        if (str2 == null || gVar.icA == null) {
            AppMethodBeat.o(6150);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6123);
                if (g.this.uiI == null) {
                    AppMethodBeat.o(6123);
                    return;
                }
                g.this.icB = str2;
                g.this.icA.b(g.this.uiI.getWebView(), new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(6122);
                        if (g.this.icF != null) {
                            ab.d("MicroMsg.GameWebViewMenuListHelper", "show webkit menu");
                            g.this.b(contextMenu, g.this.icF);
                            g.this.icF = null;
                            AppMethodBeat.o(6122);
                            return;
                        }
                        if (g.this.icG != null) {
                            ab.d("MicroMsg.GameWebViewMenuListHelper", "show IX5 menu");
                            g.this.a(contextMenu, g.this.icG);
                            g.this.icG = null;
                        }
                        AppMethodBeat.o(6122);
                    }
                }, null);
                g.this.icA.cuu();
                AppMethodBeat.o(6123);
            }
        });
        AppMethodBeat.o(6150);
    }

    static /* synthetic */ String b(g gVar) {
        AppMethodBeat.i(6153);
        String url = gVar.uiI.getUrl();
        AppMethodBeat.o(6153);
        return url;
    }
}
