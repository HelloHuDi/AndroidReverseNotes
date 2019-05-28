package com.tencent.p177mm.plugin.webview.luggage;

import android.app.Activity;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C37691an;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24109b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.fav.p407a.C6893ad;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.plugin.webview.luggage.ipc.C35590c;
import com.tencent.p177mm.plugin.webview.luggage.ipc.C4541a;
import com.tencent.p177mm.plugin.webview.luggage.ipc.C4542b;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c.C29784b;
import com.tencent.p177mm.plugin.webview.modeltools.C14543h;
import com.tencent.p177mm.plugin.webview.modeltools.C14543h.C14545c;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u.C23348a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.WebView.C41116b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.luggage.g */
public final class C40230g implements OnCreateContextMenuListener {
    C46696j icA;
    String icB;
    int icC;
    int icD;
    C14543h icE;
    C41116b icF;
    C41116b icG;
    private C14545c icL = new C402271();
    private C24109b mUw = new C144738();
    C24905d uiI;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$8 */
    class C144738 implements C24109b {
        C144738() {
        }

        public final void aIu() {
            AppMethodBeat.m2504i(6130);
            MainProcessTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            AppBrandMainProcessService.m54349a(favUrlTask);
            AppMethodBeat.m2505o(6130);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$a */
    static class C22824a implements C37866a<Bundle, Bundle> {
        private C22824a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(6133);
            Bundle bundle = (Bundle) obj;
            C45316cl c45316cl = new C45316cl();
            ((C6893ad) C1720g.m3528K(C6893ad.class)).mo15151a(c45316cl, 1, bundle.getString("image_path", ""));
            C4879a.xxA.mo10055m(c45316cl);
            bundle.putInt("fav_simple_img_result", c45316cl.cvB.ret);
            c18507c.mo5960ao(bundle);
            AppMethodBeat.m2505o(6133);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$c */
    static class C22825c implements C37866a<Bundle, Bundle> {
        private C4884c eFv = new C228261();
        private C18507c eGc;
        private Map<String, Integer> uiP;

        /* renamed from: com.tencent.mm.plugin.webview.luggage.g$c$1 */
        class C228261 extends C4884c<C18346nr> {
            C228261() {
                AppMethodBeat.m2504i(6136);
                this.xxI = C18346nr.class.getName().hashCode();
                AppMethodBeat.m2505o(6136);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(6137);
                C18346nr c18346nr = (C18346nr) c4883b;
                C4990ab.m7410d("MicroMsg.QBarLogicTask", "mRecogResultListener");
                if (!(c18346nr instanceof C18346nr)) {
                    AppMethodBeat.m2505o(6137);
                } else if (C22825c.this.uiP == null || C22825c.this.uiP.containsKey(c18346nr.cJX.filePath)) {
                    if (C22825c.this.uiP != null) {
                        C22825c.this.uiP.remove(c18346nr.cJX.filePath);
                    }
                    C4990ab.m7410d("MicroMsg.QBarLogicTask", "result: " + c18346nr.cJX.result);
                    Bundle bundle = new Bundle();
                    bundle.putString("file_path", c18346nr.cJX.filePath);
                    bundle.putString("result", c18346nr.cJX.result);
                    bundle.putInt("code_type", c18346nr.cJX.cvn);
                    bundle.putInt("code_version", c18346nr.cJX.cvo);
                    C22825c.this.eGc.mo5960ao(bundle);
                    AppMethodBeat.m2505o(6137);
                } else {
                    AppMethodBeat.m2505o(6137);
                }
                return false;
            }
        }

        private C22825c() {
            AppMethodBeat.m2504i(6138);
            AppMethodBeat.m2505o(6138);
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(6139);
            Bundle bundle = (Bundle) obj;
            this.eGc = c18507c;
            int i = bundle.getInt("type");
            String string = bundle.getString("img_path");
            switch (i) {
                case 1:
                    if (this.uiP == null) {
                        this.uiP = new HashMap();
                        C4879a.xxA.mo10052c(this.eFv);
                    }
                    C45347np c45347np = new C45347np();
                    c45347np.cJU.filePath = string;
                    C4879a.xxA.mo10055m(c45347np);
                    this.uiP.put(string, Integer.valueOf(1));
                    AppMethodBeat.m2505o(6139);
                    return;
                case 2:
                    if (this.uiP != null && this.uiP.containsKey(string)) {
                        C37691an c37691an = new C37691an();
                        c37691an.ctC.filePath = string;
                        C4879a.xxA.mo10055m(c37691an);
                        this.uiP.remove(string);
                        break;
                    }
                    C4990ab.m7413e("MicroMsg.QBarLogicTask", "%s is not recognizing", string);
                    AppMethodBeat.m2505o(6139);
                    return;
            }
            AppMethodBeat.m2505o(6139);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$b */
    static class C29790b implements C45413i<IPCBoolean, IPCBoolean> {
        private C29790b() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(6135);
            IPCBoolean cXa = C29790b.cXa();
            AppMethodBeat.m2505o(6135);
            return cXa;
        }

        private static IPCBoolean cXa() {
            int i;
            boolean z = true;
            AppMethodBeat.m2504i(6134);
            IPCBoolean iPCBoolean = new IPCBoolean();
            try {
                i = C5046bo.getInt(C26373g.m41964Nu().getValue("EnableWebviewScanQRCode"), 1);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.GameWebViewMenuListHelper", "isAllowScanQRCode parseInt failed");
                i = 0;
            }
            if (i != 1) {
                z = false;
            }
            iPCBoolean.value = z;
            AppMethodBeat.m2505o(6134);
            return iPCBoolean;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$1 */
    class C402271 implements C14545c {

        /* renamed from: com.tencent.mm.plugin.webview.luggage.g$1$1 */
        class C402261 implements C18507c<Bundle> {
            C402261() {
            }

            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(6119);
                Bundle bundle = (Bundle) obj;
                C40230g.m69001a(C40230g.this, bundle.getString("file_path"), bundle.getString("result"), bundle.getInt("code_type"), bundle.getInt("code_version"));
                AppMethodBeat.m2505o(6119);
            }
        }

        C402271() {
        }

        /* renamed from: BY */
        public final void mo26772BY(String str) {
            AppMethodBeat.m2504i(6120);
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            bundle.putString("img_path", str);
            C9549f.m17012a("com.tencent.mm", bundle, C22825c.class, new C402261());
            AppMethodBeat.m2505o(6120);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$d */
    static class C40231d implements C35590c {
        private C40231d() {
        }

        /* renamed from: a */
        public final void mo56317a(Context context, Bundle bundle, C4541a c4541a) {
            AppMethodBeat.m2504i(6140);
            String string = bundle.getString("result");
            if (C5046bo.isNullOrNil(string)) {
                AppMethodBeat.m2505o(6140);
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
            c4541a.mo9613l(null);
            AppMethodBeat.m2505o(6140);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$e */
    static class C40232e implements C35590c {
        private C40232e() {
        }

        /* renamed from: a */
        public final void mo56317a(Context context, Bundle bundle, final C4541a c4541a) {
            AppMethodBeat.m2504i(6143);
            String string = bundle.getString("img_path");
            if (C5063r.amo(string)) {
                EmojiInfo Jd;
                EmojiInfo Jd2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(C1178g.m2587cz(string));
                if (Jd2 == null || !Jd2.duP()) {
                    C44795d emojiMgr = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr();
                    C4996ah.getContext();
                    Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(emojiMgr.mo35598Jf(string));
                } else {
                    Jd = Jd2;
                }
                boolean cs = Jd == null ? false : C1173e.m2560cs(Jd.dve());
                String dve = Jd == null ? string : Jd.dve();
                Options options = new Options();
                options.inJustDecodeBounds = true;
                boolean z;
                if ((C5056d.decodeFile(dve, options) == null || options.outHeight <= C42164b.m74339Na()) && options.outWidth <= C42164b.m74339Na()) {
                    z = false;
                } else {
                    z = true;
                }
                if (cs > C42164b.m74340Nb() || z) {
                    C30379h.m48443a(context, context.getString(C25738R.string.b9x), "", context.getString(C25738R.string.cd_), null);
                    C30379h.m48445a(context, context.getString(C25738R.string.b9x), "", context.getString(C25738R.string.cd_), "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(6141);
                            c4541a.mo9613l(null);
                            AppMethodBeat.m2505o(6141);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(6142);
                            c4541a.mo9613l(null);
                            AppMethodBeat.m2505o(6142);
                        }
                    });
                    AppMethodBeat.m2505o(6143);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", Jd != null ? Jd.mo20410Aq() : "");
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                C40211a.gkE.mo38926k(intent, context);
                c4541a.mo9613l(null);
                AppMethodBeat.m2505o(6143);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", string);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.addFlags(268435456);
            C40211a.gkE.mo38926k(intent2, context);
            c4541a.mo9613l(null);
            AppMethodBeat.m2505o(6143);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$2 */
    class C402332 implements OnCancelListener {
        C402332() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(6121);
            if (C40230g.this.icE != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("type", 2);
                bundle.putString("img_path", C40230g.this.icE.upr);
                C9549f.m17012a("com.tencent.mm", bundle, C22825c.class, null);
                C40230g.this.icE.cYK();
            }
            AppMethodBeat.m2505o(6121);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$9 */
    class C402349 implements C18507c<Bundle> {
        C402349() {
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(6132);
            final Bundle bundle = (Bundle) obj;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6131);
                    C45932c.m85258a(bundle.getInt("fav_simple_img_result"), (Activity) C40230g.this.uiI.mContext, C40230g.this.mUw);
                    AppMethodBeat.m2505o(6131);
                }
            });
            AppMethodBeat.m2505o(6132);
        }
    }

    public C40230g(C24905d c24905d) {
        AppMethodBeat.m2504i(6144);
        this.uiI = c24905d;
        this.icA = new C46696j(c24905d.mContext);
        this.icA.mo75005a(c24905d.getWebView(), this, null);
        this.icA.mo75012e(new C402332());
        AppMethodBeat.m2505o(6144);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(6145);
        C4990ab.m7410d("MicroMsg.GameWebViewMenuListHelper", "onCreateContextMenu");
        C41116b hitTestResult;
        if (view instanceof WebView) {
            hitTestResult = this.uiI.getWebView().getHitTestResult();
            if (hitTestResult == null) {
                AppMethodBeat.m2505o(6145);
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                mo63587b(contextMenu, hitTestResult);
            }
            AppMethodBeat.m2505o(6145);
            return;
        }
        hitTestResult = this.uiI.getWebView().getHitTestResult();
        if (hitTestResult == null) {
            AppMethodBeat.m2505o(6145);
            return;
        }
        if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
            mo63586a(contextMenu, hitTestResult);
        }
        AppMethodBeat.m2505o(6145);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m69002a(ContextMenu contextMenu, final String str) {
        AppMethodBeat.m2504i(6146);
        if (C1445f.m3070Mn()) {
            boolean RK;
            if (C4996ah.bqo()) {
                RK = C1720g.m3531RK();
            } else {
                Bundle bundle = (Bundle) C9549f.m17010a("com.tencent.mm", null, C29784b.class);
                RK = bundle != null ? bundle.getBoolean("has_set_uin", false) : true;
            }
            contextMenu.setHeaderTitle(C25738R.string.g2h);
            C4990ab.m7417i("MicroMsg.GameWebViewMenuListHelper", "hasSetAcc = %b", Boolean.valueOf(RK));
            if (RK) {
                contextMenu.add(0, 0, 0, this.uiI.mContext.getString(C25738R.string.dhh)).setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$4$1 */
                    class C297881 implements C23348a {
                        C297881() {
                        }

                        /* renamed from: BX */
                        public final void mo26720BX(String str) {
                            AppMethodBeat.m2504i(6124);
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7420w("MicroMsg.GameWebViewMenuListHelper", "share image to friend fail, imgPath is null");
                                AppMethodBeat.m2505o(6124);
                                return;
                            }
                            C40230g.m69000a(C40230g.this, str);
                            AppMethodBeat.m2505o(6124);
                        }
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(6125);
                        C30152u.m47741a(C40230g.this.uiI.mContext, str, C44576b.dTR().getCookie(str), C1445f.m3070Mn(), new C297881());
                        AppMethodBeat.m2505o(6125);
                        return true;
                    }
                });
            }
            contextMenu.add(0, 0, 0, this.uiI.mContext.getString(C25738R.string.dwz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.m2504i(6126);
                    try {
                        C30152u.m47740a(C40230g.this.uiI.mContext, str, C44576b.dTR().getCookie(str), C1445f.m3070Mn());
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.GameWebViewMenuListHelper", "save to sdcard failed : %s", e.getMessage());
                    }
                    AppMethodBeat.m2505o(6126);
                    return true;
                }
            });
            if (RK) {
                contextMenu.add(0, 0, 0, this.uiI.mContext.getString(C25738R.string.dcq)).setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    /* renamed from: com.tencent.mm.plugin.webview.luggage.g$6$1 */
                    class C144721 implements C23348a {
                        C144721() {
                        }

                        /* renamed from: BX */
                        public final void mo26720BX(String str) {
                            AppMethodBeat.m2504i(6127);
                            C40230g.m69004b(C40230g.this, str);
                            AppMethodBeat.m2505o(6127);
                        }
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(6128);
                        String replaceAll = str.replaceAll("tp=webp", "");
                        C30152u.m47741a(C40230g.this.uiI.mContext, replaceAll, C44576b.dTR().getCookie(replaceAll), C1445f.m3070Mn(), new C144721());
                        AppMethodBeat.m2505o(6128);
                        return true;
                    }
                });
            }
            if (this.icB != null) {
                String string;
                final String str2 = this.icB;
                if (!C13119a.m21149BR(this.icC)) {
                    if (C13119a.m21150ba(this.icC, this.icB)) {
                        string = this.uiI.mContext.getString(C25738R.string.diz);
                    } else if (C13119a.m21148BQ(this.icC)) {
                        string = this.uiI.mContext.getString(C25738R.string.dix);
                    }
                    if (!C5046bo.isNullOrNil(string)) {
                        contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                            public final boolean onMenuItemClick(MenuItem menuItem) {
                                AppMethodBeat.m2504i(6129);
                                C4990ab.m7416i("MicroMsg.GameWebViewMenuListHelper", "onMenuItemClick recognize qbcode");
                                Bundle bundle = new Bundle();
                                bundle.putString("result", str2);
                                bundle.putString("url", C40230g.m69003b(C40230g.this));
                                bundle.putInt("codeType", C40230g.this.icC);
                                bundle.putInt("codeVersion", C40230g.this.icD);
                                C4542b.m6918a(C40230g.this.uiI.mContext, bundle, C40231d.class);
                                AppMethodBeat.m2505o(6129);
                                return false;
                            }
                        });
                    }
                    this.icB = null;
                    AppMethodBeat.m2505o(6146);
                    return true;
                }
                string = this.uiI.mContext.getString(C25738R.string.diy);
                if (C5046bo.isNullOrNil(string)) {
                }
                this.icB = null;
                AppMethodBeat.m2505o(6146);
                return true;
            }
            AppMethodBeat.m2505o(6146);
            return false;
        }
        C4990ab.m7412e("MicroMsg.GameWebViewMenuListHelper", "SD card unavailable");
        AppMethodBeat.m2505o(6146);
        return true;
    }

    private static boolean cWZ() {
        AppMethodBeat.m2504i(6149);
        IPCBoolean iPCBoolean = (IPCBoolean) C9549f.m17010a("com.tencent.mm", null, C29790b.class);
        if (iPCBoolean != null) {
            boolean z = iPCBoolean.value;
            AppMethodBeat.m2505o(6149);
            return z;
        }
        AppMethodBeat.m2505o(6149);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo63586a(ContextMenu contextMenu, C41116b c41116b) {
        AppMethodBeat.m2504i(6147);
        if (!m69002a(contextMenu, c41116b.mExtra) && this.uiI.cWM().aej(this.uiI.getUrl()).dml() && C40230g.cWZ()) {
            this.icG = c41116b;
            this.icE = new C14543h();
            this.icE.mo26769a(this.uiI.getWebView(), this.icL);
        }
        AppMethodBeat.m2505o(6147);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo63587b(ContextMenu contextMenu, C41116b c41116b) {
        AppMethodBeat.m2504i(6148);
        if (!m69002a(contextMenu, c41116b.mExtra) && this.uiI.cWM().aej(this.uiI.getUrl()).dml() && C40230g.cWZ()) {
            this.icF = c41116b;
            this.icE = new C14543h();
            this.icE.mo26769a(this.uiI.getWebView(), this.icL);
        }
        AppMethodBeat.m2505o(6148);
    }

    /* renamed from: a */
    static /* synthetic */ void m69001a(C40230g c40230g, String str, final String str2, int i, int i2) {
        AppMethodBeat.m2504i(6150);
        C4990ab.m7410d("MicroMsg.GameWebViewMenuListHelper", "result: ".concat(String.valueOf(str2)));
        if (c40230g.icE == null || str == null || !str.equals(c40230g.icE.upr)) {
            AppMethodBeat.m2505o(6150);
            return;
        }
        if (c40230g.icE != null) {
            c40230g.icE.cYK();
        }
        c40230g.icC = i;
        c40230g.icD = i2;
        if (str2 == null || c40230g.icA == null) {
            AppMethodBeat.m2505o(6150);
            return;
        }
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.webview.luggage.g$3$1 */
            class C228231 implements OnCreateContextMenuListener {
                C228231() {
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.m2504i(6122);
                    if (C40230g.this.icF != null) {
                        C4990ab.m7410d("MicroMsg.GameWebViewMenuListHelper", "show webkit menu");
                        C40230g.this.mo63587b(contextMenu, C40230g.this.icF);
                        C40230g.this.icF = null;
                        AppMethodBeat.m2505o(6122);
                        return;
                    }
                    if (C40230g.this.icG != null) {
                        C4990ab.m7410d("MicroMsg.GameWebViewMenuListHelper", "show IX5 menu");
                        C40230g.this.mo63586a(contextMenu, C40230g.this.icG);
                        C40230g.this.icG = null;
                    }
                    AppMethodBeat.m2505o(6122);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(6123);
                if (C40230g.this.uiI == null) {
                    AppMethodBeat.m2505o(6123);
                    return;
                }
                C40230g.this.icB = str2;
                C40230g.this.icA.mo75009b(C40230g.this.uiI.getWebView(), new C228231(), null);
                C40230g.this.icA.cuu();
                AppMethodBeat.m2505o(6123);
            }
        });
        AppMethodBeat.m2505o(6150);
    }

    /* renamed from: b */
    static /* synthetic */ String m69003b(C40230g c40230g) {
        AppMethodBeat.m2504i(6153);
        String url = c40230g.uiI.getUrl();
        AppMethodBeat.m2505o(6153);
        return url;
    }
}
