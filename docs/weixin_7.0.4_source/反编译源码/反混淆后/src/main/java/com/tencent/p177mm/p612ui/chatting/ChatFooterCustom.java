package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16530c;
import com.tencent.p177mm.p184aj.C37455j;
import com.tencent.p177mm.p184aj.C41744q;
import com.tencent.p177mm.p230g.p231a.C37765mu;
import com.tencent.p177mm.p230g.p231a.C45345mv;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.chatting.p616c.C44812c.C30473a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C44070r.C23257a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter.C35868e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7616ad;
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

/* renamed from: com.tencent.mm.ui.chatting.ChatFooterCustom */
public class ChatFooterCustom extends LinearLayout implements OnClickListener, C1837a {
    private C7616ad cFn;
    private String igi;
    private Object kbe;
    private LinearLayout lfQ;
    private C16527d pkW;
    private C35868e vmZ;
    private int yHA;
    private C5140bq yHB;
    private C30419a yHC;
    private C30420b yHD;
    private List<String> yHE;
    private final String yHF;
    private final String yHG;
    private C37455j yHH;
    private ImageView yHv;
    public ImageView yHw;
    public LinearLayout yHx;
    public C30500g yHy;
    private C30473a yHz;
    private MMFragment ymV;

    /* renamed from: com.tencent.mm.ui.chatting.ChatFooterCustom$a */
    class C30419a extends C4884c<C37765mu> {
        private C30419a() {
            AppMethodBeat.m2504i(30467);
            this.xxI = C37765mu.class.getName().hashCode();
            AppMethodBeat.m2505o(30467);
        }

        /* synthetic */ C30419a(ChatFooterCustom chatFooterCustom, byte b) {
            this();
            AppMethodBeat.m2504i(30469);
            this.xxI = C37765mu.class.getName().hashCode();
            AppMethodBeat.m2505o(30469);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(30468);
            C37765mu c37765mu = (C37765mu) c4883b;
            switch (c37765mu.cII.bJt) {
                case 0:
                    ChatFooterCustom.this.mo64207r(1005, c37765mu);
                    break;
                case 1:
                    ChatFooterCustom.this.mo64207r(1006, c37765mu);
                    break;
            }
            AppMethodBeat.m2505o(30468);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChatFooterCustom$b */
    class C30420b extends C4884c<C45345mv> {
        private C30420b() {
            AppMethodBeat.m2504i(30470);
            this.xxI = C45345mv.class.getName().hashCode();
            AppMethodBeat.m2505o(30470);
        }

        /* synthetic */ C30420b(ChatFooterCustom chatFooterCustom, byte b) {
            this();
            AppMethodBeat.m2504i(30472);
            this.xxI = C45345mv.class.getName().hashCode();
            AppMethodBeat.m2505o(30472);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(30471);
            C45345mv c45345mv = (C45345mv) c4883b;
            switch (c45345mv.cIL.bJt) {
                case 0:
                    ChatFooterCustom.this.mo64207r(1004, c45345mv);
                    break;
                case 1:
                    ChatFooterCustom.this.mo64207r(1003, c45345mv);
                    break;
            }
            AppMethodBeat.m2505o(30471);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChatFooterCustom$1 */
    class C406961 implements C30391c {
        C406961() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(30463);
            switch (i) {
                case 0:
                    ChatFooterCustom.m70326a(ChatFooterCustom.this);
                    AppMethodBeat.m2505o(30463);
                    return;
                case 1:
                    ChatFooterCustom.m70329b(ChatFooterCustom.this);
                    break;
            }
            AppMethodBeat.m2505o(30463);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChatFooterCustom$2 */
    class C406972 implements OnClickListener {
        C406972() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30464);
            ChatFooterCustom.m70331c(ChatFooterCustom.this);
            AppMethodBeat.m2505o(30464);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChatFooterCustom$3 */
    class C406983 implements OnClickListener {
        C406983() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30465);
            ChatFooterCustom.this.yHy.dBX();
            ImageView imageView = (ImageView) view;
            int i;
            View childAt;
            int i2;
            if (imageView.getTag() == null) {
                imageView.setTag(new Object());
                imageView.setImageResource(C25738R.drawable.f6905v0);
                for (i = 0; i < ChatFooterCustom.this.yHA; i++) {
                    childAt = ChatFooterCustom.this.lfQ.getChildAt(i);
                    if (i >= 3) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    childAt.setVisibility(i2);
                }
                AppMethodBeat.m2505o(30465);
                return;
            }
            imageView.setTag(null);
            imageView.setImageResource(C25738R.drawable.f6904uz);
            for (i = 0; i < ChatFooterCustom.this.yHA; i++) {
                childAt = ChatFooterCustom.this.lfQ.getChildAt(i);
                if (i < 3) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                childAt.setVisibility(i2);
            }
            AppMethodBeat.m2505o(30465);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChatFooterCustom$4 */
    class C406994 implements OnItemClickListener {
        C406994() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(30466);
            ChatFooterCustom.this.onClick(view);
            AppMethodBeat.m2505o(30466);
        }
    }

    public void setOnFooterSwitchListener(C35868e c35868e) {
        this.vmZ = c35868e;
    }

    public void setOnProcessClickListener(C30473a c30473a) {
        this.yHz = c30473a;
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(30473);
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
        AppMethodBeat.m2505o(30473);
    }

    public final void ctm() {
        AppMethodBeat.m2504i(30475);
        if (this.yHC != null) {
            C4879a.xxA.mo10053d(this.yHC);
        }
        if (this.yHD != null) {
            C4879a.xxA.mo10053d(this.yHD);
        }
        AppMethodBeat.m2505o(30475);
    }

    private void dBT() {
        AppMethodBeat.m2504i(30477);
        File file = new File(C6457e.euR);
        if (file.exists() || file.mkdir()) {
            if (!(this.ymV == null || C14987n.m23305a(this.ymV, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG))) {
                Toast.makeText((Activity) getContext(), getContext().getString(C25738R.string.e29), 1).show();
            }
            AppMethodBeat.m2505o(30477);
            return;
        }
        Toast.makeText((Activity) getContext(), getContext().getString(C25738R.string.aor), 1).show();
        AppMethodBeat.m2505o(30477);
    }

    private String getSender() {
        String Yz;
        AppMethodBeat.m2504i(30478);
        String str = "ChatCustomFooter";
        StringBuilder append = new StringBuilder("getSender ").append(this.yHB == null).append(" ");
        if (this.yHB == null) {
            Yz = C1853r.m3846Yz();
        } else {
            Yz = this.yHB.name;
        }
        C4990ab.m7416i(str, append.append(Yz).toString());
        if (this.yHB == null) {
            Yz = C1853r.m3846Yz();
            AppMethodBeat.m2505o(30478);
            return Yz;
        }
        Yz = this.yHB.name;
        AppMethodBeat.m2505o(30478);
        return Yz;
    }

    public final void dBU() {
        AppMethodBeat.m2504i(30479);
        if (this.yHy != null) {
            this.yHy.dBX();
        }
        AppMethodBeat.m2505o(30479);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:39:0x01a9, B:52:0x0222] */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r0);
     */
    /* JADX WARNING: Missing block: B:47:0x01ed, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:49:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r0);
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
            if (com.tencent.p177mm.p1510r.C35973a.m59178bI(getContext()) != false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:61:0x02a0, code skipped:
            getContext();
     */
    /* JADX WARNING: Missing block: B:62:0x02a7, code skipped:
            if (com.tencent.p177mm.p203bg.C17981e.akI() != false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:63:0x02a9, code skipped:
            com.tencent.p177mm.p842bp.C25985d.m41467b(getContext(), "scanner", ".ui.BaseScanUI", r0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(30480);
     */
    /* JADX WARNING: Missing block: B:71:0x02c5, code skipped:
            r0 = new android.content.Intent();
            r0.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            r0.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
            r0.putExtra("key_is_finish_on_scanned", false);
            r0.putExtra("key_is_hide_right_btn", true);
     */
    /* JADX WARNING: Missing block: B:72:0x02ee, code skipped:
            if (com.tencent.p177mm.p1510r.C35973a.m59178bI(getContext()) != false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:73:0x02f0, code skipped:
            getContext();
     */
    /* JADX WARNING: Missing block: B:74:0x02f7, code skipped:
            if (com.tencent.p177mm.p203bg.C17981e.akI() != false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:75:0x02f9, code skipped:
            com.tencent.p177mm.p842bp.C25985d.m41467b(getContext(), "scanner", ".ui.BaseScanUI", r0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(30480);
     */
    /* JADX WARNING: Missing block: B:76:0x030d, code skipped:
            dBT();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(30480);
     */
    /* JADX WARNING: Missing block: B:77:0x0317, code skipped:
            com.tencent.p177mm.model.C9638aw.m17190ZK();
     */
    /* JADX WARNING: Missing block: B:78:0x031e, code skipped:
            if (com.tencent.p177mm.model.C18628c.isSDCardAvailable() != false) goto L_0x032e;
     */
    /* JADX WARNING: Missing block: B:79:0x0320, code skipped:
            com.tencent.p177mm.p612ui.base.C23639t.m36492hO(getContext());
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(30480);
     */
    /* JADX WARNING: Missing block: B:80:0x032e, code skipped:
            com.tencent.p177mm.p612ui.base.C30379h.m48422a(getContext(), null, new java.lang.String[]{getContext().getString(com.tencent.p177mm.C25738R.string.akb), getContext().getString(com.tencent.p177mm.C25738R.string.aka)}, null, new com.tencent.p177mm.p612ui.chatting.ChatFooterCustom.C406961(r10));
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(30480);
     */
    /* JADX WARNING: Missing block: B:81:0x0362, code skipped:
            dBS();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(30480);
     */
    /* JADX WARNING: Missing block: B:82:0x036c, code skipped:
            r0 = new android.content.Intent();
            r0.putExtra("map_view_type", 0);
            r0.putExtra("map_sender_name", getSender());
            r0.putExtra("map_talker_name", getTalkerUserName());
            r0.putExtra("view_type_key", 1);
            r0.putExtra("key_get_location_type", 1);
            com.tencent.p177mm.p842bp.C25985d.m41467b(getContext(), com.google.firebase.analytics.FirebaseAnalytics.C8741b.LOCATION, ".ui.RedirectUI", r0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(30480);
     */
    /* JADX WARNING: Missing block: B:83:0x03ae, code skipped:
            r0 = new com.tencent.p177mm.p230g.p231a.C18247ed();
            r0.cxE.f4320op = 1;
            r0.cxE.userName = r10.cFn.field_username;
            r0.cxE.context = getContext();
            com.tencent.p177mm.sdk.p600b.C4879a.xxA.mo10055m(r0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(30480);
     */
    /* JADX WARNING: Missing block: B:84:0x03d4, code skipped:
            r0 = new com.tencent.p177mm.p230g.p231a.C18247ed();
            r0.cxE.f4320op = 2;
            r0.cxE.userName = r10.cFn.field_username;
            r0.cxE.context = getContext();
            com.tencent.p177mm.sdk.p600b.C4879a.xxA.mo10055m(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onClick(View view) {
        String str = null;
        synchronized (this) {
            AppMethodBeat.m2504i(30480);
            Object tag = view.getTag();
            if (tag instanceof C37455j) {
                C14991i.m23324Lt(8);
                C37455j e = (C37455j) tag;
                e.content = "";
                String str2;
                switch (e.type) {
                    case 0:
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        C4990ab.m7417i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(view.getWidth()));
                        C30500g c30500g = this.yHy;
                        int width = iArr[0] + (view.getWidth() / 2);
                        int i = iArr[1];
                        if (!c30500g.isShowing()) {
                            c30500g.mo48914a(e, width, i);
                            AppMethodBeat.m2505o(30480);
                            break;
                        }
                        c30500g.dBX();
                        if (!(e == null || (c30500g.yHP.f16115id == e.f16115id && c30500g.yHP.key.equals(e.key)))) {
                            c30500g.mo48914a(e, width, i);
                        }
                        AppMethodBeat.m2505o(30480);
                        break;
                    case 1:
                        C4990ab.m7416i("ChatCustomFooter", "get latest message");
                        dBW();
                        this.yHy.dBX();
                        e.state = C37455j.fwo;
                        m70328b(e);
                        m70335d(e);
                        this.yHz.dDC();
                        AppMethodBeat.m2505o(30480);
                        break;
                    case 2:
                        C4990ab.m7416i("ChatCustomFooter", "start webview url");
                        dBW();
                        this.yHy.dBX();
                        e.state = C37455j.fwo;
                        m70328b(e);
                        m70335d(e);
                        if (!(C23257a.vax.mo52975c(getContext(), e.value, new Object[0]) || C15636e.m23923a(e.cRS, getContext(), this.ymV, this.igi))) {
                            Intent intent = new Intent();
                            intent.putExtra("KPublisherId", "custom_menu");
                            intent.putExtra("pre_username", this.igi);
                            intent.putExtra("prePublishId", "custom_menu");
                            intent.putExtra("preUsername", this.igi);
                            intent.putExtra("preChatName", this.igi);
                            intent.putExtra("preChatTYPE", C32798u.m53583ad(this.igi, this.igi));
                            intent.putExtra("rawUrl", e.value);
                            intent.putExtra("geta8key_username", this.igi);
                            intent.putExtra("from_scence", 1);
                            C25985d.m41467b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.m2505o(30480);
                            break;
                        }
                    case 3:
                        C4990ab.m7416i("ChatCustomFooter", "switch to input");
                        this.yHy.dBX();
                        dBV();
                        e.state = C37455j.fwo;
                        m70328b(e);
                        m70335d(e);
                        AppMethodBeat.m2505o(30480);
                        break;
                    case 4:
                        C4990ab.m7416i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                        dBW();
                        this.yHy.dBX();
                        e.state = C37455j.fwp;
                        String str3 = e.f16115id + e.key;
                        synchronized (this.kbe) {
                            this.yHE.add(str3);
                        }
                        str2 = "ChatCustomFooter";
                        String str4 = "addToMenuClickCmdList %s %d";
                        break;
                    case 5:
                        dBW();
                        this.yHy.dBX();
                        e.state = C37455j.fwo;
                        m70328b(e);
                        m70335d(e);
                        if (!TextUtils.isEmpty(e.value)) {
                            JSONObject jSONObject = new JSONObject(e.value);
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.scene = 1035;
                            appBrandStatObject.cst = this.igi;
                            e = (C45691e) C1720g.m3528K(C45691e.class);
                            Context context = getContext();
                            str2 = jSONObject.optString("userName");
                            String optString = jSONObject.optString("pagePath");
                            if (this.pkW != null) {
                                str = this.pkW.field_appId;
                            }
                            e.mo68046a(context, str2, null, 0, 0, optString, appBrandStatObject, str);
                            break;
                        }
                        AppMethodBeat.m2505o(30480);
                        break;
                }
                AppMethodBeat.m2505o(30480);
            } else {
                AppMethodBeat.m2505o(30480);
            }
        }
    }

    /* renamed from: a */
    private boolean m70327a(C37455j c37455j) {
        AppMethodBeat.m2504i(30481);
        if (c37455j == null) {
            AppMethodBeat.m2505o(30481);
            return false;
        }
        String str = c37455j.f16115id + c37455j.key;
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
                    AppMethodBeat.m2505o(30481);
                }
            }
            i = -1;
            if (i >= 0) {
                this.yHE.remove(i);
                C4990ab.m7413e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", str, Integer.valueOf(this.yHE.size()));
            } else {
                C4990ab.m7413e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", str, Integer.valueOf(this.yHE.size()));
                AppMethodBeat.m2505o(30481);
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m70328b(C37455j c37455j) {
        AppMethodBeat.m2504i(30482);
        C7060h.pYm.mo8381e(10809, this.igi, Integer.valueOf(c37455j.f16115id), c37455j.key, C37455j.fwo, "");
        AppMethodBeat.m2505o(30482);
    }

    /* renamed from: c */
    private void m70330c(C37455j c37455j) {
        AppMethodBeat.m2504i(30483);
        C7060h.pYm.mo8381e(10809, this.igi, Integer.valueOf(c37455j.f16115id), c37455j.key, C37455j.fwq, c37455j.content);
        AppMethodBeat.m2505o(30483);
    }

    public String getTalkerUserName() {
        return this.cFn == null ? null : this.cFn.field_username;
    }

    /* renamed from: r */
    public final boolean mo64207r(int i, Object obj) {
        AppMethodBeat.m2504i(30484);
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
                    C4990ab.m7416i("ChatCustomFooter", "return from camera");
                    if (!(obj instanceof Intent)) {
                        C4990ab.m7412e("ChatCustomFooter", "type error");
                        AppMethodBeat.m2505o(30484);
                        break;
                    }
                    stringExtra = ((Intent) obj).getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        File file = new File(stringExtra);
                        if (file.exists() && file.isFile()) {
                            C4990ab.m7417i("ChatCustomFooter", "%s retrieved!", stringExtra);
                            C4990ab.m7417i("ChatCustomFooter", "MD5 is %s", C1178g.m2589v(file));
                            if (this.yHH == null || !(this.yHH.fws == 102 || this.yHH.fws == 103)) {
                                C4990ab.m7412e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
                                AppMethodBeat.m2505o(30484);
                                break;
                            }
                            arrayList = new ArrayList();
                            arrayList.add(stringExtra);
                            this.yHH.state = C37455j.fwq;
                            this.yHH.mo60368g(arrayList);
                            if (m70327a(this.yHH)) {
                                m70335d(this.yHH);
                                m70330c(this.yHH);
                            }
                        } else {
                            C4990ab.m7413e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                        }
                        AppMethodBeat.m2505o(30484);
                        break;
                    }
                    C4990ab.m7412e("ChatCustomFooter", "return null path");
                    AppMethodBeat.m2505o(30484);
                    break;
                    break;
                case 1002:
                    C4990ab.m7416i("ChatCustomFooter", "return from albumn");
                    if (!(obj instanceof Intent)) {
                        C4990ab.m7412e("ChatCustomFooter", "type error");
                        AppMethodBeat.m2505o(30484);
                        break;
                    }
                    ArrayList stringArrayListExtra = ((Intent) obj).getStringArrayListExtra("CropImage_OutputPath_List");
                    arrayList = new ArrayList();
                    if (!(stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            stringExtra = (String) it.next();
                            C4990ab.m7417i("ChatCustomFooter", "retrieving bitmap path %s", stringExtra);
                            if (stringExtra != null) {
                                File file2 = new File(stringExtra);
                                if (file2.exists() && file2.isFile()) {
                                    C4990ab.m7417i("ChatCustomFooter", "%s retrieved!", stringExtra);
                                    arrayList.add(C1178g.m2589v(file2));
                                    C4990ab.m7417i("ChatCustomFooter", "MD5 is %s", stringExtra);
                                } else {
                                    C4990ab.m7413e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                                }
                            } else {
                                C4990ab.m7412e("ChatCustomFooter", "no file contained!");
                            }
                        }
                        if (this.yHH == null || !(this.yHH.fws == 104 || this.yHH.fws == 103 || this.yHH.fws == 102)) {
                            C4990ab.m7412e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
                            AppMethodBeat.m2505o(30484);
                            break;
                        }
                        this.yHH.state = C37455j.fwq;
                        this.yHH.mo60368g(arrayList);
                        if (m70327a(this.yHH)) {
                            m70335d(this.yHH);
                            m70330c(this.yHH);
                        }
                    }
                    AppMethodBeat.m2505o(30484);
                    break;
                    break;
                case 1003:
                    C4990ab.m7416i("ChatCustomFooter", "send qrcode wait msg");
                    if (!m70333cO(obj)) {
                        AppMethodBeat.m2505o(30484);
                        break;
                    }
                    this.yHz.dDC();
                    AppMethodBeat.m2505o(30484);
                    break;
                case 1004:
                    C4990ab.m7416i("ChatCustomFooter", "send qrcode direct");
                    m70333cO(obj);
                    AppMethodBeat.m2505o(30484);
                    break;
                case 1005:
                    C4990ab.m7416i("ChatCustomFooter", "send current");
                    m70332cN(obj);
                    AppMethodBeat.m2505o(30484);
                    break;
                case 1006:
                    C4990ab.m7416i("ChatCustomFooter", "send selected");
                    m70332cN(obj);
                    AppMethodBeat.m2505o(30484);
                    break;
                default:
                    AppMethodBeat.m2505o(30484);
                    break;
            }
        }
        C4990ab.m7412e("ChatCustomFooter", "returned data is null, maybe serve for UI");
        AppMethodBeat.m2505o(30484);
        return true;
    }

    /* renamed from: cN */
    private boolean m70332cN(Object obj) {
        AppMethodBeat.m2504i(30485);
        if (obj instanceof C37765mu) {
            C37765mu c37765mu = (C37765mu) obj;
            double d = c37765mu.cII.lat;
            double d2 = c37765mu.cII.lng;
            int i = c37765mu.cII.cED;
            C4990ab.m7417i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), c37765mu.cII.label, c37765mu.cII.cIK);
            if (this.yHH == null || this.yHH.fws != 105) {
                C4990ab.m7412e("ChatCustomFooter", "cache lost or location type is not correct");
                AppMethodBeat.m2505o(30485);
            } else {
                this.yHH.state = C37455j.fwq;
                this.yHH.mo60366a(d, d2, i, r7, r8);
                if (m70327a(this.yHH)) {
                    m70335d(this.yHH);
                    m70330c(this.yHH);
                }
                AppMethodBeat.m2505o(30485);
            }
        } else {
            C4990ab.m7412e("ChatCustomFooter", "send current location data type error!");
            AppMethodBeat.m2505o(30485);
        }
        return true;
    }

    /* renamed from: cO */
    private boolean m70333cO(Object obj) {
        AppMethodBeat.m2504i(30486);
        if (obj instanceof C45345mv) {
            C45345mv c45345mv = (C45345mv) obj;
            if (this.yHH == null || !(this.yHH.fws == 100 || this.yHH.fws == 101)) {
                C4990ab.m7412e("ChatCustomFooter", "null pointer in cache or type error");
                AppMethodBeat.m2505o(30486);
                return false;
            }
            C4990ab.m7417i("ChatCustomFooter", "scan type: %s , scan result:%s", ChatFooterCustom.m70325Oh(c45345mv.cIL.cIN), c45345mv.cIL.scanResult);
            this.yHH.state = C37455j.fwq;
            this.yHH.mo60367az(r2, r3);
            if (m70327a(this.yHH)) {
                m70335d(this.yHH);
                m70330c(this.yHH);
            }
            AppMethodBeat.m2505o(30486);
            return true;
        }
        C4990ab.m7412e("ChatCustomFooter", "send current location data type error!");
        AppMethodBeat.m2505o(30486);
        return false;
    }

    /* renamed from: Oh */
    private static String m70325Oh(int i) {
        switch (i) {
            case 0:
                return "qrcode";
            case 1:
                return "barcode";
            default:
                return "";
        }
    }

    /* renamed from: d */
    private void m70335d(C37455j c37455j) {
        AppMethodBeat.m2504i(30487);
        C4990ab.m7416i("ChatCustomFooter", c37455j.getInfo());
        C9638aw.m17182Rg().mo14541a(new C41744q(this.igi, c37455j.getInfo()), 0);
        AppMethodBeat.m2505o(30487);
    }

    /* renamed from: u */
    public final void mo64211u(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(30488);
        this.lfQ = (LinearLayout) findViewById(2131822436);
        this.yHx = (LinearLayout) findViewById(2131822434);
        this.yHx.setVisibility(0);
        this.yHw = (ImageView) findViewById(2131822435);
        this.yHw.setVisibility(0);
        this.yHw.setOnClickListener(new C406972());
        this.yHv = (ImageView) findViewById(2131822437);
        this.yHv.setOnClickListener(new C406983());
        this.yHy = new C30500g(getContext(), viewGroup);
        this.yHy.yHJ = new C406994();
        AppMethodBeat.m2505o(30488);
    }

    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        AppMethodBeat.m2504i(30489);
        String a = C1946aa.m4148a(c1197a.eAB.vED);
        C4990ab.m7416i("ChatCustomFooter", "SysCmdMsgExtension:".concat(String.valueOf(a)));
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
            AppMethodBeat.m2505o(30489);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("ChatCustomFooter", e, "", new Object[0]);
            AppMethodBeat.m2505o(30489);
        }
    }

    private void dBV() {
        AppMethodBeat.m2504i(30490);
        C4990ab.m7416i("ChatCustomFooter", "switch footer");
        if (this.vmZ != null) {
            this.yHy.dBX();
            this.vmZ.mo48814oS(true);
        }
        AppMethodBeat.m2505o(30490);
    }

    public C7616ad getTalker() {
        return this.cFn;
    }

    public void setTalker(C7616ad c7616ad) {
        this.cFn = c7616ad;
    }

    private void dBW() {
        AppMethodBeat.m2504i(30491);
        if (this.cFn == null) {
            AppMethodBeat.m2505o(30491);
            return;
        }
        if (this.cFn.duk == 1) {
            C9638aw.m17190ZK();
            C18628c.m29083XR().ape(this.cFn.field_username);
        }
        AppMethodBeat.m2505o(30491);
    }

    /* renamed from: a */
    public final void mo64201a(MMFragment mMFragment, C16527d c16527d, String str) {
        AppMethodBeat.m2504i(30474);
        C16530c aeo = c16527d.mo30481cJ(false).aeo();
        IllegalArgumentException illegalArgumentException;
        if (aeo == null || aeo.fvL == null || str == null) {
            illegalArgumentException = new IllegalArgumentException(" menuInfo or username is null ! ");
            AppMethodBeat.m2505o(30474);
            throw illegalArgumentException;
        }
        this.yHA = Math.min(aeo.fvL.size(), 6);
        C4990ab.m7416i("ChatCustomFooter", "setMenus, count:" + this.yHA);
        if (this.yHA <= 0) {
            illegalArgumentException = new IllegalArgumentException(" mTabCount is invalid ! ");
            AppMethodBeat.m2505o(30474);
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
            TextView textView = (TextView) frameLayout.findViewById(2131822432);
            frameLayout.findViewById(2131822431).setVisibility(8);
            ImageView imageView = (ImageView) frameLayout.getChildAt(2);
            imageView.setVisibility(8);
            if (i2 < this.yHA) {
                C37455j c37455j = (C37455j) aeo.fvL.get(i2);
                frameLayout.setTag(c37455j);
                textView.setText(C44089j.m79292b(getContext(), c37455j.name));
                if (c37455j.type == 0) {
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
        this.pkW = c16527d;
        if (this.yHC != null) {
            C4879a.xxA.mo10053d(this.yHC);
        }
        if (this.yHD != null) {
            C4879a.xxA.mo10053d(this.yHD);
        }
        this.yHC = new C30419a(this, (byte) 0);
        this.yHD = new C30420b(this, (byte) 0);
        C4879a.xxA.mo10052c(this.yHC);
        C4879a.xxA.mo10052c(this.yHD);
        AppMethodBeat.m2505o(30474);
    }

    private void dBS() {
        AppMethodBeat.m2504i(30476);
        if (!(this.ymV == null || this.cFn == null || C42252ah.isNullOrNil(this.igi))) {
            C14987n.m23308b(this.ymV, 9, this.igi, this.cFn.field_username);
        }
        AppMethodBeat.m2505o(30476);
    }
}
