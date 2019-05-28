package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.q;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMFragment;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom extends LinearLayout implements OnClickListener, com.tencent.mm.model.bz.a {
    private ad cFn;
    private String igi;
    private Object kbe;
    private LinearLayout lfQ;
    private d pkW;
    private e vmZ;
    private int yHA;
    private bq yHB;
    private a yHC;
    private b yHD;
    private List<String> yHE;
    private final String yHF;
    private final String yHG;
    private j yHH;
    private ImageView yHv;
    public ImageView yHw;
    public LinearLayout yHx;
    public g yHy;
    private com.tencent.mm.ui.chatting.c.c.a yHz;
    private MMFragment ymV;

    class a extends c<mu> {
        private a() {
            AppMethodBeat.i(30467);
            this.xxI = mu.class.getName().hashCode();
            AppMethodBeat.o(30467);
        }

        /* synthetic */ a(ChatFooterCustom chatFooterCustom, byte b) {
            this();
            AppMethodBeat.i(30469);
            this.xxI = mu.class.getName().hashCode();
            AppMethodBeat.o(30469);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(30468);
            mu muVar = (mu) bVar;
            switch (muVar.cII.bJt) {
                case 0:
                    ChatFooterCustom.this.r(1005, muVar);
                    break;
                case 1:
                    ChatFooterCustom.this.r(1006, muVar);
                    break;
            }
            AppMethodBeat.o(30468);
            return false;
        }
    }

    class b extends c<mv> {
        private b() {
            AppMethodBeat.i(30470);
            this.xxI = mv.class.getName().hashCode();
            AppMethodBeat.o(30470);
        }

        /* synthetic */ b(ChatFooterCustom chatFooterCustom, byte b) {
            this();
            AppMethodBeat.i(30472);
            this.xxI = mv.class.getName().hashCode();
            AppMethodBeat.o(30472);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(30471);
            mv mvVar = (mv) bVar;
            switch (mvVar.cIL.bJt) {
                case 0:
                    ChatFooterCustom.this.r(1004, mvVar);
                    break;
                case 1:
                    ChatFooterCustom.this.r(1003, mvVar);
                    break;
            }
            AppMethodBeat.o(30471);
            return false;
        }
    }

    public void setOnFooterSwitchListener(e eVar) {
        this.vmZ = eVar;
    }

    public void setOnProcessClickListener(com.tencent.mm.ui.chatting.c.c.a aVar) {
        this.yHz = aVar;
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(30473);
        this.lfQ = null;
        this.yHv = null;
        this.yHw = null;
        this.yHx = null;
        this.yHy = null;
        this.vmZ = null;
        this.yHz = null;
        this.yHA = 0;
        this.yHE = new LinkedList();
        this.yHF = "qrcode";
        this.yHG = "barcode";
        this.kbe = new Object();
        AppMethodBeat.o(30473);
    }

    public final void ctm() {
        AppMethodBeat.i(30475);
        if (this.yHC != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.yHC);
        }
        if (this.yHD != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.yHD);
        }
        AppMethodBeat.o(30475);
    }

    private void dBT() {
        AppMethodBeat.i(30477);
        File file = new File(com.tencent.mm.compatible.util.e.euR);
        if (file.exists() || file.mkdir()) {
            if (!(this.ymV == null || n.a(this.ymV, com.tencent.mm.compatible.util.e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG))) {
                Toast.makeText((Activity) getContext(), getContext().getString(R.string.e29), 1).show();
            }
            AppMethodBeat.o(30477);
            return;
        }
        Toast.makeText((Activity) getContext(), getContext().getString(R.string.aor), 1).show();
        AppMethodBeat.o(30477);
    }

    private String getSender() {
        String Yz;
        AppMethodBeat.i(30478);
        String str = "ChatCustomFooter";
        StringBuilder append = new StringBuilder("getSender ").append(this.yHB == null).append(" ");
        if (this.yHB == null) {
            Yz = r.Yz();
        } else {
            Yz = this.yHB.name;
        }
        ab.i(str, append.append(Yz).toString());
        if (this.yHB == null) {
            Yz = r.Yz();
            AppMethodBeat.o(30478);
            return Yz;
        }
        Yz = this.yHB.name;
        AppMethodBeat.o(30478);
        return Yz;
    }

    public final void dBU() {
        AppMethodBeat.i(30479);
        if (this.yHy != null) {
            this.yHy.dBX();
        }
        AppMethodBeat.o(30479);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:39:0x01a9, B:52:0x0222] */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0);
     */
    /* JADX WARNING: Missing block: B:47:0x01ed, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:49:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0);
     */
    /* JADX WARNING: Missing block: B:57:0x0270, code skipped:
            switch(r0) {
                case 100: goto L_0x0275;
                case 101: goto L_0x02c5;
                case 102: goto L_0x030d;
                case 103: goto L_0x0317;
                case 104: goto L_0x0362;
                case 105: goto L_0x036c;
                case 106: goto L_0x03ae;
                case 107: goto L_0x03d4;
                default: goto L_0x0273;
            };
     */
    /* JADX WARNING: Missing block: B:59:0x0275, code skipped:
            r0 = new android.content.Intent();
            r0.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            r0.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
            r0.putExtra("key_is_finish_on_scanned", true);
            r0.putExtra("key_is_hide_right_btn", true);
     */
    /* JADX WARNING: Missing block: B:60:0x029e, code skipped:
            if (com.tencent.mm.r.a.bI(getContext()) != false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:61:0x02a0, code skipped:
            getContext();
     */
    /* JADX WARNING: Missing block: B:62:0x02a7, code skipped:
            if (com.tencent.mm.bg.e.akI() != false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:63:0x02a9, code skipped:
            com.tencent.mm.bp.d.b(getContext(), "scanner", ".ui.BaseScanUI", r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(30480);
     */
    /* JADX WARNING: Missing block: B:71:0x02c5, code skipped:
            r0 = new android.content.Intent();
            r0.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            r0.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
            r0.putExtra("key_is_finish_on_scanned", false);
            r0.putExtra("key_is_hide_right_btn", true);
     */
    /* JADX WARNING: Missing block: B:72:0x02ee, code skipped:
            if (com.tencent.mm.r.a.bI(getContext()) != false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:73:0x02f0, code skipped:
            getContext();
     */
    /* JADX WARNING: Missing block: B:74:0x02f7, code skipped:
            if (com.tencent.mm.bg.e.akI() != false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:75:0x02f9, code skipped:
            com.tencent.mm.bp.d.b(getContext(), "scanner", ".ui.BaseScanUI", r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(30480);
     */
    /* JADX WARNING: Missing block: B:76:0x030d, code skipped:
            dBT();
            com.tencent.matrix.trace.core.AppMethodBeat.o(30480);
     */
    /* JADX WARNING: Missing block: B:77:0x0317, code skipped:
            com.tencent.mm.model.aw.ZK();
     */
    /* JADX WARNING: Missing block: B:78:0x031e, code skipped:
            if (com.tencent.mm.model.c.isSDCardAvailable() != false) goto L_0x032e;
     */
    /* JADX WARNING: Missing block: B:79:0x0320, code skipped:
            com.tencent.mm.ui.base.t.hO(getContext());
            com.tencent.matrix.trace.core.AppMethodBeat.o(30480);
     */
    /* JADX WARNING: Missing block: B:80:0x032e, code skipped:
            com.tencent.mm.ui.base.h.a(getContext(), null, new java.lang.String[]{getContext().getString(com.tencent.mm.R.string.akb), getContext().getString(com.tencent.mm.R.string.aka)}, null, new com.tencent.mm.ui.chatting.ChatFooterCustom.AnonymousClass1(r10));
            com.tencent.matrix.trace.core.AppMethodBeat.o(30480);
     */
    /* JADX WARNING: Missing block: B:81:0x0362, code skipped:
            dBS();
            com.tencent.matrix.trace.core.AppMethodBeat.o(30480);
     */
    /* JADX WARNING: Missing block: B:82:0x036c, code skipped:
            r0 = new android.content.Intent();
            r0.putExtra("map_view_type", 0);
            r0.putExtra("map_sender_name", getSender());
            r0.putExtra("map_talker_name", getTalkerUserName());
            r0.putExtra("view_type_key", 1);
            r0.putExtra("key_get_location_type", 1);
            com.tencent.mm.bp.d.b(getContext(), com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(30480);
     */
    /* JADX WARNING: Missing block: B:83:0x03ae, code skipped:
            r0 = new com.tencent.mm.g.a.ed();
            r0.cxE.op = 1;
            r0.cxE.userName = r10.cFn.field_username;
            r0.cxE.context = getContext();
            com.tencent.mm.sdk.b.a.xxA.m(r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(30480);
     */
    /* JADX WARNING: Missing block: B:84:0x03d4, code skipped:
            r0 = new com.tencent.mm.g.a.ed();
            r0.cxE.op = 2;
            r0.cxE.userName = r10.cFn.field_username;
            r0.cxE.context = getContext();
            com.tencent.mm.sdk.b.a.xxA.m(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onClick(View view) {
        String str = null;
        synchronized (this) {
            AppMethodBeat.i(30480);
            Object tag = view.getTag();
            if (tag instanceof j) {
                i.Lt(8);
                j e = (j) tag;
                e.content = "";
                String str2;
                switch (e.type) {
                    case 0:
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        ab.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(view.getWidth()));
                        g gVar = this.yHy;
                        int width = iArr[0] + (view.getWidth() / 2);
                        int i = iArr[1];
                        if (!gVar.isShowing()) {
                            gVar.a(e, width, i);
                            AppMethodBeat.o(30480);
                            break;
                        }
                        gVar.dBX();
                        if (!(e == null || (gVar.yHP.id == e.id && gVar.yHP.key.equals(e.key)))) {
                            gVar.a(e, width, i);
                        }
                        AppMethodBeat.o(30480);
                        break;
                    case 1:
                        ab.i("ChatCustomFooter", "get latest message");
                        dBW();
                        this.yHy.dBX();
                        e.state = j.fwo;
                        b(e);
                        d(e);
                        this.yHz.dDC();
                        AppMethodBeat.o(30480);
                        break;
                    case 2:
                        ab.i("ChatCustomFooter", "start webview url");
                        dBW();
                        this.yHy.dBX();
                        e.state = j.fwo;
                        b(e);
                        d(e);
                        if (!(com.tencent.mm.pluginsdk.r.a.vax.c(getContext(), e.value, new Object[0]) || e.a(e.cRS, getContext(), this.ymV, this.igi))) {
                            Intent intent = new Intent();
                            intent.putExtra("KPublisherId", "custom_menu");
                            intent.putExtra("pre_username", this.igi);
                            intent.putExtra("prePublishId", "custom_menu");
                            intent.putExtra("preUsername", this.igi);
                            intent.putExtra("preChatName", this.igi);
                            intent.putExtra("preChatTYPE", u.ad(this.igi, this.igi));
                            intent.putExtra("rawUrl", e.value);
                            intent.putExtra("geta8key_username", this.igi);
                            intent.putExtra("from_scence", 1);
                            com.tencent.mm.bp.d.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.o(30480);
                            break;
                        }
                    case 3:
                        ab.i("ChatCustomFooter", "switch to input");
                        this.yHy.dBX();
                        dBV();
                        e.state = j.fwo;
                        b(e);
                        d(e);
                        AppMethodBeat.o(30480);
                        break;
                    case 4:
                        ab.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                        dBW();
                        this.yHy.dBX();
                        e.state = j.fwp;
                        String str3 = e.id + e.key;
                        synchronized (this.kbe) {
                            this.yHE.add(str3);
                        }
                        str2 = "ChatCustomFooter";
                        String str4 = "addToMenuClickCmdList %s %d";
                        break;
                    case 5:
                        dBW();
                        this.yHy.dBX();
                        e.state = j.fwo;
                        b(e);
                        d(e);
                        if (!TextUtils.isEmpty(e.value)) {
                            JSONObject jSONObject = new JSONObject(e.value);
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.scene = 1035;
                            appBrandStatObject.cst = this.igi;
                            e = (com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class);
                            Context context = getContext();
                            str2 = jSONObject.optString("userName");
                            String optString = jSONObject.optString("pagePath");
                            if (this.pkW != null) {
                                str = this.pkW.field_appId;
                            }
                            e.a(context, str2, null, 0, 0, optString, appBrandStatObject, str);
                            break;
                        }
                        AppMethodBeat.o(30480);
                        break;
                }
                AppMethodBeat.o(30480);
            } else {
                AppMethodBeat.o(30480);
            }
        }
    }

    private boolean a(j jVar) {
        AppMethodBeat.i(30481);
        if (jVar == null) {
            AppMethodBeat.o(30481);
            return false;
        }
        String str = jVar.id + jVar.key;
        synchronized (this.kbe) {
            int i;
            int i2 = 0;
            while (i2 < this.yHE.size()) {
                try {
                    if (((String) this.yHE.get(i2)).equals(str)) {
                        i = i2;
                        break;
                    }
                    i2++;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(30481);
                }
            }
            i = -1;
            if (i >= 0) {
                this.yHE.remove(i);
                ab.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", str, Integer.valueOf(this.yHE.size()));
            } else {
                ab.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", str, Integer.valueOf(this.yHE.size()));
                AppMethodBeat.o(30481);
                return false;
            }
        }
        return true;
    }

    private void b(j jVar) {
        AppMethodBeat.i(30482);
        h.pYm.e(10809, this.igi, Integer.valueOf(jVar.id), jVar.key, j.fwo, "");
        AppMethodBeat.o(30482);
    }

    private void c(j jVar) {
        AppMethodBeat.i(30483);
        h.pYm.e(10809, this.igi, Integer.valueOf(jVar.id), jVar.key, j.fwq, jVar.content);
        AppMethodBeat.o(30483);
    }

    public String getTalkerUserName() {
        return this.cFn == null ? null : this.cFn.field_username;
    }

    public final boolean r(int i, Object obj) {
        AppMethodBeat.i(30484);
        if (obj != null) {
            switch (i) {
                case 201:
                case 203:
                    i = 1001;
                    break;
                case 217:
                    i = 1002;
                    break;
            }
            String stringExtra;
            ArrayList arrayList;
            switch (i) {
                case 1001:
                    ab.i("ChatCustomFooter", "return from camera");
                    if (!(obj instanceof Intent)) {
                        ab.e("ChatCustomFooter", "type error");
                        AppMethodBeat.o(30484);
                        break;
                    }
                    stringExtra = ((Intent) obj).getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        File file = new File(stringExtra);
                        if (file.exists() && file.isFile()) {
                            ab.i("ChatCustomFooter", "%s retrieved!", stringExtra);
                            ab.i("ChatCustomFooter", "MD5 is %s", com.tencent.mm.a.g.v(file));
                            if (this.yHH == null || !(this.yHH.fws == 102 || this.yHH.fws == 103)) {
                                ab.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
                                AppMethodBeat.o(30484);
                                break;
                            }
                            arrayList = new ArrayList();
                            arrayList.add(stringExtra);
                            this.yHH.state = j.fwq;
                            this.yHH.g(arrayList);
                            if (a(this.yHH)) {
                                d(this.yHH);
                                c(this.yHH);
                            }
                        } else {
                            ab.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                        }
                        AppMethodBeat.o(30484);
                        break;
                    }
                    ab.e("ChatCustomFooter", "return null path");
                    AppMethodBeat.o(30484);
                    break;
                    break;
                case 1002:
                    ab.i("ChatCustomFooter", "return from albumn");
                    if (!(obj instanceof Intent)) {
                        ab.e("ChatCustomFooter", "type error");
                        AppMethodBeat.o(30484);
                        break;
                    }
                    ArrayList stringArrayListExtra = ((Intent) obj).getStringArrayListExtra("CropImage_OutputPath_List");
                    arrayList = new ArrayList();
                    if (!(stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            stringExtra = (String) it.next();
                            ab.i("ChatCustomFooter", "retrieving bitmap path %s", stringExtra);
                            if (stringExtra != null) {
                                File file2 = new File(stringExtra);
                                if (file2.exists() && file2.isFile()) {
                                    ab.i("ChatCustomFooter", "%s retrieved!", stringExtra);
                                    arrayList.add(com.tencent.mm.a.g.v(file2));
                                    ab.i("ChatCustomFooter", "MD5 is %s", stringExtra);
                                } else {
                                    ab.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                                }
                            } else {
                                ab.e("ChatCustomFooter", "no file contained!");
                            }
                        }
                        if (this.yHH == null || !(this.yHH.fws == 104 || this.yHH.fws == 103 || this.yHH.fws == 102)) {
                            ab.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
                            AppMethodBeat.o(30484);
                            break;
                        }
                        this.yHH.state = j.fwq;
                        this.yHH.g(arrayList);
                        if (a(this.yHH)) {
                            d(this.yHH);
                            c(this.yHH);
                        }
                    }
                    AppMethodBeat.o(30484);
                    break;
                    break;
                case 1003:
                    ab.i("ChatCustomFooter", "send qrcode wait msg");
                    if (!cO(obj)) {
                        AppMethodBeat.o(30484);
                        break;
                    }
                    this.yHz.dDC();
                    AppMethodBeat.o(30484);
                    break;
                case 1004:
                    ab.i("ChatCustomFooter", "send qrcode direct");
                    cO(obj);
                    AppMethodBeat.o(30484);
                    break;
                case 1005:
                    ab.i("ChatCustomFooter", "send current");
                    cN(obj);
                    AppMethodBeat.o(30484);
                    break;
                case 1006:
                    ab.i("ChatCustomFooter", "send selected");
                    cN(obj);
                    AppMethodBeat.o(30484);
                    break;
                default:
                    AppMethodBeat.o(30484);
                    break;
            }
        }
        ab.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
        AppMethodBeat.o(30484);
        return true;
    }

    private boolean cN(Object obj) {
        AppMethodBeat.i(30485);
        if (obj instanceof mu) {
            mu muVar = (mu) obj;
            double d = muVar.cII.lat;
            double d2 = muVar.cII.lng;
            int i = muVar.cII.cED;
            ab.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), muVar.cII.label, muVar.cII.cIK);
            if (this.yHH == null || this.yHH.fws != 105) {
                ab.e("ChatCustomFooter", "cache lost or location type is not correct");
                AppMethodBeat.o(30485);
            } else {
                this.yHH.state = j.fwq;
                this.yHH.a(d, d2, i, r7, r8);
                if (a(this.yHH)) {
                    d(this.yHH);
                    c(this.yHH);
                }
                AppMethodBeat.o(30485);
            }
        } else {
            ab.e("ChatCustomFooter", "send current location data type error!");
            AppMethodBeat.o(30485);
        }
        return true;
    }

    private boolean cO(Object obj) {
        AppMethodBeat.i(30486);
        if (obj instanceof mv) {
            mv mvVar = (mv) obj;
            if (this.yHH == null || !(this.yHH.fws == 100 || this.yHH.fws == 101)) {
                ab.e("ChatCustomFooter", "null pointer in cache or type error");
                AppMethodBeat.o(30486);
                return false;
            }
            ab.i("ChatCustomFooter", "scan type: %s , scan result:%s", Oh(mvVar.cIL.cIN), mvVar.cIL.scanResult);
            this.yHH.state = j.fwq;
            this.yHH.az(r2, r3);
            if (a(this.yHH)) {
                d(this.yHH);
                c(this.yHH);
            }
            AppMethodBeat.o(30486);
            return true;
        }
        ab.e("ChatCustomFooter", "send current location data type error!");
        AppMethodBeat.o(30486);
        return false;
    }

    private static String Oh(int i) {
        switch (i) {
            case 0:
                return "qrcode";
            case 1:
                return "barcode";
            default:
                return "";
        }
    }

    private void d(j jVar) {
        AppMethodBeat.i(30487);
        ab.i("ChatCustomFooter", jVar.getInfo());
        aw.Rg().a(new q(this.igi, jVar.getInfo()), 0);
        AppMethodBeat.o(30487);
    }

    public final void u(ViewGroup viewGroup) {
        AppMethodBeat.i(30488);
        this.lfQ = (LinearLayout) findViewById(R.id.an4);
        this.yHx = (LinearLayout) findViewById(R.id.an2);
        this.yHx.setVisibility(0);
        this.yHw = (ImageView) findViewById(R.id.an3);
        this.yHw.setVisibility(0);
        this.yHw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30464);
                ChatFooterCustom.c(ChatFooterCustom.this);
                AppMethodBeat.o(30464);
            }
        });
        this.yHv = (ImageView) findViewById(R.id.an5);
        this.yHv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30465);
                ChatFooterCustom.this.yHy.dBX();
                ImageView imageView = (ImageView) view;
                int i;
                View childAt;
                int i2;
                if (imageView.getTag() == null) {
                    imageView.setTag(new Object());
                    imageView.setImageResource(R.drawable.v0);
                    for (i = 0; i < ChatFooterCustom.this.yHA; i++) {
                        childAt = ChatFooterCustom.this.lfQ.getChildAt(i);
                        if (i >= 3) {
                            i2 = 0;
                        } else {
                            i2 = 8;
                        }
                        childAt.setVisibility(i2);
                    }
                    AppMethodBeat.o(30465);
                    return;
                }
                imageView.setTag(null);
                imageView.setImageResource(R.drawable.uz);
                for (i = 0; i < ChatFooterCustom.this.yHA; i++) {
                    childAt = ChatFooterCustom.this.lfQ.getChildAt(i);
                    if (i < 3) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    childAt.setVisibility(i2);
                }
                AppMethodBeat.o(30465);
            }
        });
        this.yHy = new g(getContext(), viewGroup);
        this.yHy.yHJ = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(30466);
                ChatFooterCustom.this.onClick(view);
                AppMethodBeat.o(30466);
            }
        };
        AppMethodBeat.o(30488);
    }

    public final void a(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(30489);
        String a = aa.a(aVar.eAB.vED);
        ab.i("ChatCustomFooter", "SysCmdMsgExtension:".concat(String.valueOf(a)));
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(a));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 0:
                    case 2:
                        a = newPullParser.getName();
                        if (!"sysmsg".equals(a)) {
                            if (!"username".equals(a)) {
                                if (!"data".equals(a)) {
                                    break;
                                }
                                newPullParser.nextText();
                                break;
                            }
                            newPullParser.nextText();
                            break;
                        } else if (!"type".equals(newPullParser.getAttributeName(0))) {
                            break;
                        } else {
                            newPullParser.getAttributeValue(0);
                            break;
                        }
                    default:
                        break;
                }
            }
            AppMethodBeat.o(30489);
        } catch (Exception e) {
            ab.printErrStackTrace("ChatCustomFooter", e, "", new Object[0]);
            AppMethodBeat.o(30489);
        }
    }

    private void dBV() {
        AppMethodBeat.i(30490);
        ab.i("ChatCustomFooter", "switch footer");
        if (this.vmZ != null) {
            this.yHy.dBX();
            this.vmZ.oS(true);
        }
        AppMethodBeat.o(30490);
    }

    public ad getTalker() {
        return this.cFn;
    }

    public void setTalker(ad adVar) {
        this.cFn = adVar;
    }

    private void dBW() {
        AppMethodBeat.i(30491);
        if (this.cFn == null) {
            AppMethodBeat.o(30491);
            return;
        }
        if (this.cFn.duk == 1) {
            aw.ZK();
            com.tencent.mm.model.c.XR().ape(this.cFn.field_username);
        }
        AppMethodBeat.o(30491);
    }

    public final void a(MMFragment mMFragment, d dVar, String str) {
        AppMethodBeat.i(30474);
        com.tencent.mm.aj.d.b.c aeo = dVar.cJ(false).aeo();
        IllegalArgumentException illegalArgumentException;
        if (aeo == null || aeo.fvL == null || str == null) {
            illegalArgumentException = new IllegalArgumentException(" menuInfo or username is null ! ");
            AppMethodBeat.o(30474);
            throw illegalArgumentException;
        }
        this.yHA = Math.min(aeo.fvL.size(), 6);
        ab.i("ChatCustomFooter", "setMenus, count:" + this.yHA);
        if (this.yHA <= 0) {
            illegalArgumentException = new IllegalArgumentException(" mTabCount is invalid ! ");
            AppMethodBeat.o(30474);
            throw illegalArgumentException;
        }
        if (this.yHA > 3) {
            this.yHv.setVisibility(0);
        } else {
            this.yHv.setVisibility(8);
        }
        this.lfQ.setWeightSum((float) Math.min(this.yHA, 3));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                break;
            }
            FrameLayout frameLayout = (FrameLayout) this.lfQ.getChildAt(i2);
            TextView textView = (TextView) frameLayout.findViewById(R.id.an0);
            frameLayout.findViewById(R.id.amz).setVisibility(8);
            ImageView imageView = (ImageView) frameLayout.getChildAt(2);
            imageView.setVisibility(8);
            if (i2 < this.yHA) {
                j jVar = (j) aeo.fvL.get(i2);
                frameLayout.setTag(jVar);
                textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(getContext(), jVar.name));
                if (jVar.type == 0) {
                    imageView.setVisibility(0);
                }
                frameLayout.setOnClickListener(this);
                frameLayout.setVisibility(0);
            } else if (i2 < 3 || this.yHA <= 3) {
                frameLayout.setVisibility(8);
            } else {
                frameLayout.setTag(null);
                textView.setText("");
                imageView.setVisibility(8);
                frameLayout.setOnClickListener(null);
                frameLayout.setVisibility(0);
            }
            i = i2 + 1;
        }
        this.ymV = mMFragment;
        this.igi = str;
        this.pkW = dVar;
        if (this.yHC != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.yHC);
        }
        if (this.yHD != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.yHD);
        }
        this.yHC = new a(this, (byte) 0);
        this.yHD = new b(this, (byte) 0);
        com.tencent.mm.sdk.b.a.xxA.c(this.yHC);
        com.tencent.mm.sdk.b.a.xxA.c(this.yHD);
        AppMethodBeat.o(30474);
    }

    private void dBS() {
        AppMethodBeat.i(30476);
        if (!(this.ymV == null || this.cFn == null || ah.isNullOrNil(this.igi))) {
            n.b(this.ymV, 9, this.igi, this.cFn.field_username);
        }
        AppMethodBeat.o(30476);
    }
}
