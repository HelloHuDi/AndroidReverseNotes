package com.tencent.p177mm.plugin.welab.p584ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.welab.C29974a;
import com.tencent.p177mm.plugin.welab.C40361d;
import com.tencent.p177mm.plugin.welab.C40363f;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C29973b;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.plugin.welab.p584ui.widget.WelabRoundCornerImageView;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.axk;
import com.tencent.p177mm.protocal.protobuf.axl;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.welab.ui.WelabAppInfoUI */
public class WelabAppInfoUI extends MMActivity {
    private String csB;
    private TextView gne;
    private TextView iKo;
    private MMSwitchBtn ixT;
    private Button mlE;
    private TextView pnu;
    private C23169a uMg;
    private int uMh;
    private boolean uMi;
    private WelabRoundCornerImageView uMj;
    private RecyclerView uMk;
    private View uMl;
    private View uMm;
    private View uMn;
    private View uMo;
    private C23170a uMp;
    private OnClickListener uMq = new C147175();

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabAppInfoUI$5 */
    class C147175 implements OnClickListener {
        C147175() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(80603);
            String obj = view.getTag().toString();
            Intent intent = new Intent();
            intent.putExtra("nowUrl", obj);
            intent.putExtra("urlList", (String[]) ((C23170a) WelabAppInfoUI.this.uMk.getAdapter()).kFl.toArray(new String[0]));
            Context context = WelabAppInfoUI.this;
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            C25985d.m41467b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
            AppMethodBeat.m2505o(80603);
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabAppInfoUI$a */
    class C23170a extends C41523a<C23172b> {
        public List<String> kFl;

        public final int getItemCount() {
            AppMethodBeat.m2504i(80604);
            int size = this.kFl.size();
            AppMethodBeat.m2505o(80604);
            return size;
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabAppInfoUI$4 */
    class C231714 implements OnClickListener {
        C231714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(80602);
            try {
                String str = "";
                C1720g.m3534RN();
                int QF = C1668a.m3383QF();
                String encode = URLEncoder.encode(C7243d.DEVICE_NAME, ProtocolPackage.ServerEncoding);
                String encode2 = URLEncoder.encode(C5046bo.dpA(), ProtocolPackage.ServerEncoding);
                String encode3 = URLEncoder.encode(C1427q.m3026LK(), ProtocolPackage.ServerEncoding);
                String encode4 = URLEncoder.encode(C7243d.vxi, ProtocolPackage.ServerEncoding);
                String encode5 = URLEncoder.encode(C7243d.vxj, ProtocolPackage.ServerEncoding);
                String encode6 = URLEncoder.encode(C7243d.vxk, ProtocolPackage.ServerEncoding);
                C1720g.m3534RN();
                String str2 = ("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(WelabAppInfoUI.this.uMg.field_expId + "|" + WelabAppInfoUI.this.csB) + "&version=" + C7243d.vxo + "&lang=" + C4988aa.m7403gw(C4996ah.getContext()) + "&" + C5046bo.nullAsNil(str) + ("&uin=" + QF + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + URLEncoder.encode(C1668a.m3397Rb(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(C5046bo.m7557gS(C4996ah.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (C5046bo.isNullOrNil(str) ? 0 : 1))) + "#/comment/4134";
                Intent intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", str2);
                intent.putExtra("title", "意见反馈");
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                C25985d.m41467b(WelabAppInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(80602);
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7413e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", e.getMessage());
                AppMethodBeat.m2505o(80602);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabAppInfoUI$b */
    class C23172b extends C41531v {
        public ImageView uMs;

        public C23172b(View view) {
            super(view);
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabAppInfoUI$1 */
    class C231731 implements OnMenuItemClickListener {
        C231731() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(80599);
            WelabAppInfoUI.this.aqX();
            WelabAppInfoUI.this.finish();
            AppMethodBeat.m2505o(80599);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabAppInfoUI$3 */
    class C231743 implements OnClickListener {
        C231743() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(80601);
            C4990ab.m7416i("WelabAppInfoUI", "open func " + WelabAppInfoUI.this.csB);
            C29974a ddj = C29974a.ddj();
            WelabAppInfoUI welabAppInfoUI = WelabAppInfoUI.this;
            String b = WelabAppInfoUI.this.csB;
            C29973b c29973b = (C29973b) ddj.uLR.get(b);
            if (c29973b != null) {
                C4990ab.m7416i("WelabMgr", "use custome opener to open ".concat(String.valueOf(b)));
                c29973b.mo9766f(welabAppInfoUI, b);
            } else {
                C4990ab.m7416i("WelabMgr", "use default opener open ".concat(String.valueOf(b)));
                if (ddj.agI(b).field_Type != 2) {
                    C4990ab.m7412e("WelabMgr", "can not find opener for ".concat(String.valueOf(b)));
                } else if (ddj.uLS != null) {
                    ddj.uLS.mo9766f(welabAppInfoUI, b);
                } else {
                    C4990ab.m7412e("WelabMgr", "defaultWeAppOpener is null!");
                }
            }
            C40361d.m69201t(WelabAppInfoUI.this.csB, 7, WelabAppInfoUI.this.uMi);
            AppMethodBeat.m2505o(80601);
        }
    }

    /* renamed from: com.tencent.mm.plugin.welab.ui.WelabAppInfoUI$2 */
    class C231752 implements C30795a {
        C231752() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(80600);
            if (WelabAppInfoUI.this.uMg.field_Switch == 2) {
                WelabAppInfoUI.this.uMg.field_Switch = 1;
                AppMethodBeat.m2505o(80600);
                return;
            }
            if (WelabAppInfoUI.this.uMg.field_Switch == 1) {
                WelabAppInfoUI.this.uMg.field_Switch = 2;
            }
            AppMethodBeat.m2505o(80600);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WelabAppInfoUI() {
        AppMethodBeat.m2504i(80607);
        AppMethodBeat.m2505o(80607);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.m2504i(80608);
        super.onCreate(bundle);
        mo17426pO(true);
        dyb();
        Intent intent = getIntent();
        if (intent != null) {
            this.csB = intent.getStringExtra("para_appid");
            this.uMg = C29974a.ddj().agI(this.csB);
            this.uMh = this.uMg.field_Switch;
            if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
                z = false;
            }
            this.uMi = z;
        }
        initView();
        C40361d.m69201t(this.csB, 2, this.uMi);
        AppMethodBeat.m2505o(80608);
    }

    public final int getLayoutId() {
        return 2130971225;
    }

    @TargetApi(21)
    private void ddy() {
        AppMethodBeat.m2504i(80609);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.a68));
        }
        AppMethodBeat.m2505o(80609);
    }

    public final void initView() {
        AppMethodBeat.m2504i(80610);
        super.initView();
        if (this.uMg == null) {
            C4990ab.m7412e("WelabAppInfoUI", "info is null");
            AppMethodBeat.m2505o(80610);
            return;
        }
        mo17369MY(8);
        ddy();
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(C25738R.color.a68));
        }
        setBackBtn(new C231731());
        this.uMj = (WelabRoundCornerImageView) findViewById(2131829200);
        this.gne = (TextView) findViewById(2131820678);
        this.pnu = (TextView) findViewById(2131821841);
        this.uMk = (RecyclerView) findViewById(2131829204);
        this.uMl = findViewById(2131829205);
        this.mlE = (Button) findViewById(2131823998);
        this.uMm = findViewById(2131829207);
        this.ixT = (MMSwitchBtn) findViewById(2131820932);
        this.iKo = (TextView) findViewById(2131829206);
        this.uMn = findViewById(2131829202);
        this.uMo = findViewById(2131829203);
        this.uMk.setLayoutManager(new LinearLayoutManager(0));
        this.uMk.setOverScrollMode(2);
        this.uMp = new C23170a();
        this.uMk.setAdapter(this.uMp);
        AppMethodBeat.m2505o(80610);
    }

    public void onPause() {
        int i = 0;
        AppMethodBeat.m2504i(80611);
        super.onPause();
        if (this.uMh != this.uMg.field_Switch) {
            boolean c = C29974a.ddj().uLQ.mo10103c(this.uMg, new String[0]);
            C4990ab.m7417i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", Boolean.valueOf(c), Integer.valueOf(this.uMh), Integer.valueOf(this.uMg.field_Switch));
            this.uMh = this.uMg.field_Switch;
            axl axl = new axl();
            axk axk = new axk();
            if (!this.uMg.ddw()) {
                i = C5046bo.ank(this.uMg.field_expId);
            }
            axk.wBs = i;
            axk.wBt = this.uMg.field_LabsAppId;
            if (this.uMg.field_Switch == 2) {
                i = 1;
            } else {
                i = 2;
            }
            axk.wkB = i;
            axl.eow.add(axk);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(207, axl));
            C40361d.m69201t(this.csB, this.uMg.field_Switch == 2 ? 4 : 5, this.uMi);
            if (this.uMg.field_Switch == 2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.uMg);
                C29974a.ddj();
                C29974a.m47423ed(arrayList);
            }
        }
        AppMethodBeat.m2505o(80611);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        TextView textView;
        C25815a ahv;
        AppMethodBeat.m2504i(80612);
        super.onResume();
        if (this.uMg.ddu() && this.uMg.field_Type == 1) {
            this.uMl.setVisibility(0);
            this.iKo.setText(getResources().getString(C25738R.string.g0v) + this.uMg.agR("field_Title"));
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
            this.ixT.setEnabled(true);
            if (this.uMg.field_Switch == 2) {
                sharedPreferences.edit().putBoolean(ddz(), true).commit();
                this.ixT.setCheck(true);
            } else {
                sharedPreferences.edit().putBoolean(ddz(), false).commit();
                this.ixT.setCheck(false);
            }
            this.ixT.setSwitchListener(new C231752());
        } else {
            this.uMl.setVisibility(8);
        }
        if (this.uMg.ddu()) {
            this.mlE.setText(getResources().getString(C25738R.string.g0t) + this.uMg.agR("field_Title"));
            if (this.uMg.field_Type != 1) {
                this.mlE.setVisibility(0);
                this.mlE.setOnClickListener(new C231743());
                textView = this.gne;
                C29974a.ddj();
                textView.setText(C29974a.m47421a(this.uMg));
                this.pnu.setText(this.uMg.agR("field_Introduce"));
                if (this.uMg.ddu()) {
                    this.uMm.setVisibility(8);
                } else {
                    this.uMm.setVisibility(0);
                    this.uMm.setOnClickListener(new C231714());
                }
                if (this.uMg.ddu()) {
                    this.uMn.setVisibility(0);
                    this.uMo.setVisibility(8);
                } else {
                    this.uMn.setVisibility(8);
                    this.uMo.setVisibility(0);
                }
                ddA();
                this.uMj.setCornerRadiusPercent(0.5f);
                ahv = C25815a.ahv();
                C29974a.ddj();
                ahv.mo43766a(C29974a.m47422b(this.uMg), this.uMj, C29974a.ddj().udB);
                AppMethodBeat.m2505o(80612);
            }
        }
        this.mlE.setVisibility(8);
        textView = this.gne;
        C29974a.ddj();
        textView.setText(C29974a.m47421a(this.uMg));
        this.pnu.setText(this.uMg.agR("field_Introduce"));
        if (this.uMg.ddu()) {
        }
        if (this.uMg.ddu()) {
        }
        ddA();
        this.uMj.setCornerRadiusPercent(0.5f);
        ahv = C25815a.ahv();
        C29974a.ddj();
        ahv.mo43766a(C29974a.m47422b(this.uMg), this.uMj, C29974a.ddj().udB);
        AppMethodBeat.m2505o(80612);
    }

    private String ddz() {
        AppMethodBeat.m2504i(80613);
        String str = "switch_" + this.uMg.field_LabsAppId;
        AppMethodBeat.m2505o(80613);
        return str;
    }

    private void ddA() {
        AppMethodBeat.m2504i(80614);
        String agR = this.uMg.agR("field_ImgUrl_android");
        if (TextUtils.isEmpty(agR)) {
            agR = this.uMg.agR("field_ImgUrl");
        }
        List agL = C40363f.agL(agR);
        Iterator it = agL.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty((String) it.next())) {
                it.remove();
            }
        }
        if (agL.isEmpty()) {
            this.uMk.setVisibility(8);
            AppMethodBeat.m2505o(80614);
            return;
        }
        this.uMk.setVisibility(0);
        this.uMp.kFl = agL;
        this.uMp.aop.notifyChanged();
        AppMethodBeat.m2505o(80614);
    }
}
