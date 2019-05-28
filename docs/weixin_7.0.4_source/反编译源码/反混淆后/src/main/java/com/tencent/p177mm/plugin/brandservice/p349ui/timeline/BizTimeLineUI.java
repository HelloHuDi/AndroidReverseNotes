package com.tencent.p177mm.plugin.brandservice.p349ui.timeline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.chatting.C44290ao;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.bizui.widget.StoryListView;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C38689c;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C42809b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C20055f.C200563;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C20055f.C200582;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C33733c.C337341;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread.C20062e;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread.C20062e.C200631;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2703c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35897k;
import com.tencent.p177mm.protocal.protobuf.bfc;
import com.tencent.p177mm.protocal.protobuf.bfd;
import com.tencent.p177mm.protocal.protobuf.bfe;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C40635r;
import com.tencent.p177mm.storage.C40635r.C40633a;
import com.tencent.p177mm.storage.C40635r.C40634c;
import com.tencent.p177mm.storage.C40635r.C406387;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.smtt.sdk.WebView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@C18524i
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI */
public class BizTimeLineUI extends MMActivity implements C2697h {
    private static long jOv = 0;
    private static long jOw = 0;
    private static long jOx = 0;
    private static int jOy = 0;
    private static int jOz = 0;
    private boolean cAY = false;
    private int ctE;
    private int cvd = 1;
    private int ehv;
    private TextView emptyTipTv;
    private View gwR;
    private long iQc = 0;
    private View jNV;
    BizTimeLineHotView jNo;
    private boolean jNw = false;
    private C20055f jNy;
    private long jOA = 0;
    private long jOB = 0;
    private boolean jOC = false;
    private C40634c jOD = new C1122311();
    private long jOE = 0;
    private final long jOF = 100;
    private boolean jOG = false;
    private List<C46627q> jOH = new LinkedList();
    private boolean jOI = false;
    private C4884c jOJ = new C68119();
    public StoryListView jOm;
    private View jOn;
    private ImageView jOo;
    LinearLayout jOp;
    private TextView jOq;
    private TextView jOr;
    private View jOs;
    private C38701a jOt;
    private C33735d jOu;
    private int joI = -1;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$9 */
    class C68119 extends C4884c<C6504k> {
        C68119() {
            AppMethodBeat.m2504i(14191);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(14191);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(14192);
            C6504k c6504k = (C6504k) c4883b;
            if (!(c6504k == null || c6504k.csh == null || c6504k.csh.csi)) {
                BizTimeLineUI.this.jOA = 0;
            }
            AppMethodBeat.m2505o(14192);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$15 */
    class C1121015 implements OnLayoutChangeListener {
        C1121015() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppMethodBeat.m2504i(14199);
            BizTimeLineUI.this.jOt.mo61553dD(BizTimeLineUI.this.jOm.getFirstVisiblePosition(), BizTimeLineUI.this.jOm.getLastVisiblePosition());
            BizTimeLineUI.this.jOm.removeOnLayoutChangeListener(this);
            AppMethodBeat.m2505o(14199);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$3 */
    class C112113 implements Runnable {
        C112113() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14185);
            if (BizTimeLineUI.this.uiu || BizTimeLineUI.this.isFinishing()) {
                AppMethodBeat.m2505o(14185);
                return;
            }
            BizTimeLineUI.m18943m(BizTimeLineUI.this);
            AppMethodBeat.m2505o(14185);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$13 */
    class C1121213 implements OnScrollListener {
        C1121213() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(14196);
            C32291o.ahp().mo43773cm(i);
            if (i == 0) {
                BizTimeLineUI.this.jOt.mo61553dD(BizTimeLineUI.this.jOm.getFirstVisiblePosition(), BizTimeLineUI.this.jOm.getLastVisiblePosition());
            }
            if (i == 2) {
                BizTimeLineUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, C1625i.SCENE_BIZ_SCROLL, WXHardCoderJNI.hcBizAction, "MicroMsg.BizTimeLineUI");
                C4990ab.m7417i("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", Integer.valueOf(C1625i.SCENE_BIZ_SCROLL), Integer.valueOf(BizTimeLineUI.this.ehv));
            }
            AppMethodBeat.m2505o(14196);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(14197);
            BizTimeLineUI.m18924a(BizTimeLineUI.this, i, i2);
            BizTimeLineUI.jOz = i;
            AppMethodBeat.m2505o(14197);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$1 */
    class C112151 implements OnClickListener {
        C112151() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14183);
            Intent intent = new Intent(BizTimeLineUI.this.mController.ylL, BizTimeLineNewMsgUI.class);
            intent.putExtra("biz_time_line_line_enter_scene", 1);
            BizTimeLineUI.this.startActivity(intent);
            AppMethodBeat.m2505o(14183);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$2 */
    class C112162 implements OnMenuItemClickListener {
        C112162() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(14184);
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("biz_from_scene", 2);
            intent.putExtra("biz_time_line_line_session_id", BizTimeLineUI.this.ctE);
            intent.putExtra("biz_enter_source", BizTimeLineUI.this.cvd);
            C25985d.m41473f(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", intent);
            BizTimeLineUI.this.jNy.mo35305si(7);
            BizTimeLineUI.this.jOC = true;
            AppMethodBeat.m2505o(14184);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$4 */
    class C112174 implements OnMenuItemClickListener {
        C112174() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(14186);
            BizTimeLineUI.this.finish();
            AppMethodBeat.m2505o(14186);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$8 */
    class C112188 implements Runnable {
        C112188() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14190);
            BizTimeLineUI.this.jOI = false;
            if (!(BizTimeLineUI.this.isFinishing() || BizTimeLineUI.this.jOm == null)) {
                BizTimeLineUI.m18929b(BizTimeLineUI.this, BizTimeLineUI.this.jOm.getFirstVisiblePosition(), BizTimeLineUI.this.jOm.getLastVisiblePosition());
            }
            AppMethodBeat.m2505o(14190);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$10 */
    class C1121910 implements Runnable {
        C1121910() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14193);
            if (BizTimeLineUI.this.isFinishing() || BizTimeLineUI.this.jOm == null || BizTimeLineUI.this.jOm.getFirstVisiblePosition() != 0 || BizTimeLineUI.this.jNo == null) {
                AppMethodBeat.m2505o(14193);
                return;
            }
            BizTimeLineUI.this.jNo.aWJ();
            AppMethodBeat.m2505o(14193);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$5 */
    class C112215 implements OnClickListener {
        C112215() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14187);
            BizTimeLineUI.m18943m(BizTimeLineUI.this);
            AppMethodBeat.m2505o(14187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$11 */
    class C1122311 implements C40634c {
        C1122311() {
        }

        /* renamed from: a */
        public final void mo22929a(Object obj, C40633a c40633a) {
            AppMethodBeat.m2504i(14194);
            BizTimeLineUI.this.aWx();
            AppMethodBeat.m2505o(14194);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$18 */
    class C1122518 implements OnMenuItemClickListener {
        C1122518() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(14202);
            if (C46400aa.m87304HU(0)) {
                Intent cVd = C46400aa.cVd();
                cVd.putExtra("title", BizTimeLineUI.this.getString(C25738R.string.c2b));
                cVd.putExtra("searchbar_tips", BizTimeLineUI.this.getString(C25738R.string.c2b));
                cVd.putExtra("KRightBtn", true);
                cVd.putExtra("ftsneedkeyboard", true);
                cVd.putExtra("publishIdPrefix", "bs");
                cVd.putExtra("ftsType", 2);
                cVd.putExtra("ftsbizscene", 11);
                Map d = C46400aa.m87334d(11, true, 2);
                String HP = C46400aa.m87299HP(C5046bo.ank((String) d.get("scene")));
                d.put("sessionId", HP);
                cVd.putExtra("sessionId", HP);
                cVd.putExtra("rawUrl", C46400aa.m87298E(d));
                cVd.putExtra("key_load_js_without_delay", true);
                cVd.addFlags(67108864);
                HP = C29736ac.adN("bizAccountTopSearch");
                if (!TextUtils.isEmpty(HP)) {
                    cVd.putExtra("key_search_input_hint", HP);
                }
                C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd);
            } else {
                C4990ab.m7412e("MicroMsg.BizTimeLineUI", "fts h5 template not avail");
            }
            AppMethodBeat.m2505o(14202);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI$6 */
    class C112266 implements Runnable {
        C112266() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14188);
            BizTimeLineUI.this.jOG = false;
            if (BizTimeLineUI.this.isFinishing()) {
                C4990ab.m7420w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
                AppMethodBeat.m2505o(14188);
                return;
            }
            BizTimeLineUI.this.aWC();
            AppMethodBeat.m2505o(14188);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BizTimeLineUI() {
        AppMethodBeat.m2504i(14203);
        AppMethodBeat.m2505o(14203);
    }

    /* renamed from: a */
    static /* synthetic */ void m18923a(BizTimeLineUI bizTimeLineUI) {
        AppMethodBeat.m2504i(14222);
        bizTimeLineUI.aWy();
        AppMethodBeat.m2505o(14222);
    }

    /* renamed from: b */
    static /* synthetic */ void m18929b(BizTimeLineUI bizTimeLineUI, int i, int i2) {
        AppMethodBeat.m2504i(14228);
        bizTimeLineUI.m18933dE(i, i2);
        AppMethodBeat.m2505o(14228);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(14204);
        super.onCreate(bundle);
        mo17446xE(-1052684);
        setTitleBarDoubleClickListener(new C112113());
        C5141c ll = C18624c.abi().mo17131ll("100045");
        boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpenSearch"));
        C4990ab.m7411d("MicroMsg.BizTimeLineUI", "open search entrance:%b", Boolean.valueOf(z));
        if (z) {
            addIconOptionMenu(0, C25738R.string.ewn, C1318a.actionbar_icon_dark_search, new C1122518());
        }
        addIconOptionMenu(1, C25738R.string.a_e, C1318a.actionbar_menu_list_icon, new C112162());
        setMMTitle((int) C25738R.string.a_i);
        mo17443ta(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new C112174(), C1318a.actionbar_icon_dark_back);
        this.jOn = getLayoutInflater().inflate(2130968857, null);
        this.jOr = (TextView) this.jOn.findViewById(2131821805);
        this.jOr.setTextSize(1, 14.0f);
        this.jOs = this.jOn.findViewById(2131821804);
        ((LinearLayout) this.mController.mActionBar.getCustomView()).addView(this.jOn);
        LayoutParams layoutParams = (LayoutParams) this.jOn.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.weight = 1.0f;
        this.jOn.setLayoutParams(layoutParams);
        this.jOs.setOnClickListener(new C112215());
        this.jOn.setVisibility(8);
        this.emptyTipTv = (TextView) findViewById(2131821807);
        this.emptyTipTv.setText(C25738R.string.a9t);
        this.jOu = new C33735d(this);
        C4879a.xxA.mo10052c(this.jOu.hAA);
        this.ctE = (int) (System.currentTimeMillis() / 1000);
        this.cvd = getIntent().getIntExtra("biz_enter_source", 1);
        this.jNy = new C20055f(this.ctE);
        C30309s.m48267Mj(this.ctE);
        C33733c c33733c = new C33733c();
        if (C33733c.aWu()) {
            aWy();
        } else {
            getString(C25738R.string.f9238tz);
            final C44275p b = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), false, null);
            C7305d.post(new C337341(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(14195);
                    if (b != null && b.isShowing()) {
                        b.dismiss();
                    }
                    if (BizTimeLineUI.this.isFinishing()) {
                        C4990ab.m7420w("MicroMsg.BizTimeLineUI", "checkInitListView isFinishing, just return");
                        AppMethodBeat.m2505o(14195);
                        return;
                    }
                    BizTimeLineUI.m18923a(BizTimeLineUI.this);
                    AppMethodBeat.m2505o(14195);
                }
            }), "BizTimeLineMigrateThread");
        }
        C4990ab.m7410d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue();
        if ((intValue & 4) == 0) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apc("officialaccounts");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(intValue | 4));
        }
        C30036f.m47545n(this);
        this.jOA = System.currentTimeMillis();
        C4879a.xxA.mo10052c(this.jOJ);
        if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(1)) {
            ((C20023b) C1720g.m3528K(C20023b.class)).mo6759rX(90);
        }
        C40635r aeX = C41747z.aeX();
        if (aeX.yam) {
            aeX.yam = false;
            C7305d.xDG.mo10152b(new C406387(), "BizTimeLineInfoStorageThread", 1000);
        }
        AppMethodBeat.m2505o(14204);
    }

    public final void aWx() {
        AppMethodBeat.m2504i(14206);
        if (isFinishing()) {
            AppMethodBeat.m2505o(14206);
            return;
        }
        if (C41747z.aeY().baS() > 0) {
            this.jOp.setVisibility(0);
            this.jOq.setText(getString(C25738R.string.a_8, new Object[]{Integer.valueOf(r0)}));
            C46627q drQ = C41747z.aeY().drQ();
            if (drQ != null) {
                this.jOo.setVisibility(0);
                C40460b.m69434b(this.jOo, drQ.field_talker);
                C30309s.m48274mM(drQ.field_msgId);
            } else {
                this.jOo.setVisibility(8);
            }
            if (this.jOt != null && this.jOt.getCount() == 0) {
                this.jOt.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(14206);
            return;
        }
        this.jOp.setVisibility(8);
        AppMethodBeat.m2505o(14206);
    }

    /* renamed from: aX */
    private void m18926aX(final List<C46627q> list) {
        AppMethodBeat.m2504i(14208);
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                AppMethodBeat.m2504i(14200);
                Looper.myQueue().removeIdleHandler(this);
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                C38689c.m65624aX(linkedList);
                AppMethodBeat.m2505o(14200);
                return false;
            }
        });
        AppMethodBeat.m2505o(14208);
    }

    /* renamed from: c */
    private void m18931c(final C46627q c46627q) {
        AppMethodBeat.m2504i(14209);
        this.jOm.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(14201);
                BizTimeLineUI.this.jOt.jNw = false;
                BizTimeLineUI.this.jNw = false;
                int max = Math.max(0, BizTimeLineUI.this.jOm.getFirstVisiblePosition() - BizTimeLineUI.this.jOm.getHeaderViewsCount());
                BizTimeLineUI.this.jOt.mo61549a(c46627q);
                BizTimeLineUI.this.jOt.mo61549a(BizTimeLineUI.this.jOt.mo61563sg(max));
                BizTimeLineUI.m18940j(BizTimeLineUI.this);
                C4990ab.m7417i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", Integer.valueOf(max));
                AppMethodBeat.m2505o(14201);
            }
        }, 50);
        AppMethodBeat.m2505o(14209);
    }

    private View aWz() {
        AppMethodBeat.m2504i(14210);
        this.jNV = getLayoutInflater().inflate(2130968860, null);
        View view = this.jNV;
        AppMethodBeat.m2505o(14210);
        return view;
    }

    private View aWA() {
        AppMethodBeat.m2504i(14211);
        this.gwR = getLayoutInflater().inflate(2130968861, null);
        this.jNo = (BizTimeLineHotView) this.gwR.findViewById(2131821813);
        View view = this.gwR;
        AppMethodBeat.m2505o(14211);
        return view;
    }

    public final void aWB() {
        AppMethodBeat.m2504i(14212);
        if (!(isFinishing() || this.jNV == null)) {
            TextView textView = (TextView) findViewById(2131821812);
            ((ProgressBar) findViewById(2131821811)).setVisibility(8);
            textView.setText(getString(C25738R.string.a_5));
        }
        AppMethodBeat.m2505o(14212);
    }

    public final int getLayoutId() {
        return 2130968858;
    }

    public final void aWC() {
        AppMethodBeat.m2504i(14213);
        long currentTimeMillis = System.currentTimeMillis() - this.jOE;
        if (!this.jOG || currentTimeMillis >= 200) {
            C4990ab.m7411d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", Boolean.valueOf(this.jOG), Long.valueOf(currentTimeMillis));
            this.jOG = true;
            if (currentTimeMillis < 100) {
                C5004al.m7442n(new C112266(), 100);
                AppMethodBeat.m2505o(14213);
                return;
            }
            aWD();
            this.jOE = System.currentTimeMillis();
            this.jOG = false;
            AppMethodBeat.m2505o(14213);
            return;
        }
        C4990ab.m7410d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
        AppMethodBeat.m2505o(14213);
    }

    private void aWD() {
        AppMethodBeat.m2504i(14214);
        if (this.jOt == null || this.cAY) {
            AppMethodBeat.m2505o(14214);
        } else if (this.jOt.iKa.size() > 0) {
            final long j = ((C46627q) this.jOt.iKa.get(0)).field_orderFlag;
            C4990ab.m7411d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", Integer.valueOf(C41747z.aeX().mo64117mG(j)));
            if (C41747z.aeX().mo64117mG(j) > 0) {
                mo17369MY(8);
                if (this.jOn.getVisibility() == 8) {
                    this.jOn.setVisibility(4);
                }
                this.jOr.setText(getString(C25738R.string.a_d, new Object[]{Integer.valueOf(r2)}));
                this.jOn.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(14189);
                        if (C41747z.aeX().mo64117mG(j) <= 0) {
                            BizTimeLineUI.this.mo17369MY(0);
                            AppMethodBeat.m2505o(14189);
                            return;
                        }
                        float x = BizTimeLineUI.this.jOn.getX();
                        int width = (int) ((((float) BizTimeLineUI.this.jOn.getWidth()) + (x + x)) / 2.0f);
                        int gd = C1338a.m2868gd(BizTimeLineUI.this.mController.ylL) / 2;
                        if (width != gd) {
                            BizTimeLineUI.this.jOn.setX(((float) (gd - width)) + x);
                            C4990ab.m7411d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", Float.valueOf(x), Float.valueOf(r1));
                        }
                        if (BizTimeLineUI.this.jOn.getVisibility() != 0) {
                            BizTimeLineUI.this.jOn.setVisibility(0);
                        }
                        AppMethodBeat.m2505o(14189);
                    }
                });
                AppMethodBeat.m2505o(14214);
                return;
            }
            this.jOn.setVisibility(8);
            mo17369MY(0);
            AppMethodBeat.m2505o(14214);
        } else {
            AppMethodBeat.m2505o(14214);
        }
    }

    public final void aWE() {
        AppMethodBeat.m2504i(14215);
        C4990ab.m7410d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
        aWC();
        AppMethodBeat.m2505o(14215);
    }

    public final void aWv() {
        AppMethodBeat.m2504i(14216);
        if (this.jOt != null) {
            this.jOt.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(14216);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(14217);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.jOu.hAA);
        jOv = System.currentTimeMillis();
        if (!(this.jOt == null || this.jOm == null)) {
            C46627q aWp = this.jOt.aWp();
            if (aWp != null) {
                jOw = aWp.field_orderFlag;
            }
            aWp = this.jOt.mo61563sg(BizTimeLineUI.aWF());
            if (aWp != null) {
                jOx = aWp.field_orderFlag;
            } else {
                C4990ab.m7421w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", Integer.valueOf(BizTimeLineUI.aWF()));
            }
            C38701a c38701a = this.jOt;
            C41747z.aeX().mo64100a(c38701a.jKp);
            c38701a.jNp.jQR.clear();
        }
        C41747z.aeY().mo39190a(this.jOD);
        if (this.jOA != 0) {
            this.iQc += System.currentTimeMillis() - this.jOB;
            C7060h.pYm.mo8381e(13932, Integer.valueOf(((int) (r0 - this.jOA)) / 1000), Integer.valueOf(1), Integer.valueOf(this.ctE), Integer.valueOf((int) (this.iQc / 1000)), Integer.valueOf(this.cvd));
        }
        C4879a.xxA.mo10053d(this.jOJ);
        this.jNy.jOe = BizTimeLineUI.aWF();
        C33720b.m55105a("BrandServiceWorkerThread", new C200582(), 0);
        C42809b.clean();
        C44290ao.clear();
        C1202f c1202f = this.jNo;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10121b(c1202f);
        C4879a.xxA.mo10053d(c1202f.jQq);
        C20062e c20062e = c1202f.jQg;
        C1196a c1196a = new C1196a();
        bfc bfc = new bfc();
        c1196a.fsJ = bfc;
        c1196a.fsK = new bfd();
        c1196a.uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
        c1196a.fsI = 2550;
        C7472b acD = c1196a.acD();
        bfc.vZZ = C30309s.getSessionId();
        bfc.wIZ = c20062e.jQC;
        LinkedList linkedList = new LinkedList();
        if (c20062e.jQB.size() > 0) {
            for (Entry value : c20062e.jQB.entrySet()) {
                linkedList.add((bfe) value.getValue());
            }
        }
        bfc.wIY = linkedList;
        C1226w.m2654a(acD, new C200631());
        C1720g.m3540Rg().mo14546b(2768, c1202f);
        C30309s.m48267Mj(0);
        AppMethodBeat.m2505o(14217);
    }

    public void onResume() {
        AppMethodBeat.m2504i(14218);
        super.onResume();
        if (this.jOC) {
            this.jOC = false;
            this.jNy.mo35305si(8);
        }
        if (this.jOt != null) {
            C38701a c38701a = this.jOt;
            c38701a.cAY = false;
            C2703c c2703c = c38701a.jNp;
            if (c2703c.jQU) {
                c2703c.jQU = false;
                if (c2703c.jQO <= 0) {
                    c2703c.aWR();
                }
            }
        }
        if (this.cAY) {
            this.cAY = false;
            aWC();
        }
        this.jOB = System.currentTimeMillis();
        C33720b.m55105a("BrandServiceWorkerThread", new C1121910(), 500);
        AppMethodBeat.m2505o(14218);
    }

    public void onPause() {
        AppMethodBeat.m2504i(14219);
        super.onPause();
        C46627q c46627q = null;
        if (this.jOt != null) {
            C38701a c38701a = this.jOt;
            c38701a.jNv.stopPlay();
            c38701a.cAY = true;
            c38701a.jNp.jQU = true;
            c46627q = this.jOt.aWq();
        }
        BizTimeLineUI.m18927aY(this.jOH);
        if (c46627q != null) {
            C41747z.aeX().mo64118mH(c46627q.field_orderFlag);
        } else {
            C41747z.aeX().drK();
        }
        if (this.jOm != null) {
            int top;
            View childAt = this.jOm.getChildAt(0);
            if (childAt != null) {
                top = childAt.getTop();
            } else {
                top = 0;
            }
            jOy = top;
        } else {
            jOy = 0;
        }
        this.cAY = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.iQc += currentTimeMillis - this.jOB;
        this.jOB = currentTimeMillis;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.ehv);
        this.ehv = 0;
        AppMethodBeat.m2505o(14219);
    }

    /* renamed from: dE */
    private void m18933dE(int i, int i2) {
        int i3 = 0;
        AppMethodBeat.m2504i(14220);
        if (!(i != 0 || this.jNw || jOz == i)) {
            this.jNo.aWJ();
        }
        if (this.jNw || this.jOI || (jOz == i && this.joI == i2)) {
            AppMethodBeat.m2505o(14220);
            return;
        }
        int i4;
        this.joI = i2;
        if (i > 0) {
            i4 = i - 1;
        } else {
            i4 = 0;
        }
        if (i2 > 0) {
            i3 = i2 - 1;
        }
        LinkedList linkedList = new LinkedList();
        for (i4 = 
/*
Method generation error in method: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.dE(int, int):void, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_8 'i4' int) = (r1_7 'i4' int), (r1_11 'i4' int) binds: {(r1_7 'i4' int)=B:18:0x002d, (r1_11 'i4' int)=B:29:0x004d} in method: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.dE(int, int):void, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:185)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 18 more

*/

    /* renamed from: aY */
    private static void m18927aY(List<C46627q> list) {
        AppMethodBeat.m2504i(14221);
        if (!C5046bo.m7548ek(list)) {
            LinkedList linkedList = new LinkedList();
            for (C46627q c46627q : list) {
                c46627q.field_isRead = 1;
            }
            linkedList.addAll(list);
            C41747z.aeX().mo64111eo(linkedList);
        }
        AppMethodBeat.m2505o(14221);
    }

    private static int aWF() {
        return jOz > 0 ? jOz - 1 : 0;
    }

    private void aWw() {
        AppMethodBeat.m2504i(14205);
        this.jOp = (LinearLayout) findViewById(2131821814);
        this.jOq = (TextView) findViewById(2131821816);
        this.jOo = (ImageView) findViewById(2131821815);
        aWx();
        this.jOp.setOnClickListener(new C112151());
        AppMethodBeat.m2505o(14205);
    }

    private void aWy() {
        List drH;
        AppMethodBeat.m2504i(14207);
        this.jOm = (StoryListView) findViewById(2131821806);
        this.jOm.addFooterView(aWz());
        this.jOm.addHeaderView(aWA());
        final int i = jOz;
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = C26373g.m41964Nu().getInt("BizTimeLineStayTime", 180) * 1000;
        if (jOv == 0 || jOw == 0 || currentTimeMillis - jOv >= ((long) i2)) {
            this.jNw = false;
            drH = C41747z.aeX().drH();
            m18926aX(drH);
        } else {
            drH = C41747z.aeX().mo64114mD(jOw);
            this.jNw = true;
        }
        C4990ab.m7417i("MicroMsg.BizTimeLineUI", "initListView stayTime %d %d/%d  orderFlag %d, keep %b", Integer.valueOf(i2), Long.valueOf(jOv), Long.valueOf(currentTimeMillis), Long.valueOf(jOw), Boolean.valueOf(this.jNw));
        this.jOt = new C38701a(this, drH, this.jNw, this.jNy, this.jNo);
        this.jNy.jOd = BizTimeLineUI.aWF();
        aWw();
        this.jOm.setAdapter(this.jOt);
        this.jOm.setFooterDividersEnabled(false);
        this.jOm.setOnScrollListener(new C1121213());
        this.jOm.setEmptyView(this.emptyTipTv);
        this.jOm.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(14198);
                if (BizTimeLineUI.this.jNw && i != 0) {
                    BizTimeLineUI.m18935f(BizTimeLineUI.this);
                    BizTimeLineUI.this.aWC();
                }
                if (BizTimeLineUI.this.jNw && i == 0) {
                    BizTimeLineUI.m18925a(BizTimeLineUI.this, BizTimeLineUI.this.jOt.mo61563sg(0));
                }
                if (!C5046bo.m7548ek(drH)) {
                    C33720b.m55105a("BrandServiceWorkerThread", new C200563(((C46627q) drH.get(0)).field_orderFlag, BizTimeLineUI.this.cvd), 0);
                }
                AppMethodBeat.m2505o(14198);
            }
        }, 100);
        this.jOm.addOnLayoutChangeListener(new C1121015());
        if (drH.size() < 10) {
            aWB();
        }
        C41747z.aeY().mo39191a(this.jOD, Looper.getMainLooper());
        AppMethodBeat.m2505o(14207);
    }

    /* renamed from: a */
    static /* synthetic */ void m18924a(BizTimeLineUI bizTimeLineUI, int i, int i2) {
        AppMethodBeat.m2504i(14223);
        bizTimeLineUI.m18933dE(i, (i + i2) - 1);
        AppMethodBeat.m2505o(14223);
    }

    /* renamed from: f */
    static /* synthetic */ void m18935f(BizTimeLineUI bizTimeLineUI) {
        AppMethodBeat.m2504i(14224);
        if (bizTimeLineUI.jOt == null || bizTimeLineUI.jOm == null) {
            AppMethodBeat.m2505o(14224);
            return;
        }
        if (jOx != 0) {
            List list = bizTimeLineUI.jOt.iKa;
            int i = 0;
            while (i < list.size()) {
                C46627q c46627q = (C46627q) list.get(i);
                if (c46627q == null || c46627q.field_orderFlag != jOx) {
                    i++;
                } else {
                    C35897k.m58842a(bizTimeLineUI.jOm, i + 1, jOy, false);
                    bizTimeLineUI.m18931c(c46627q);
                    C4990ab.m7417i("MicroMsg.BizTimeLineUI", "setListViewPosition %d", Integer.valueOf(i));
                    AppMethodBeat.m2505o(14224);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(14224);
    }

    /* renamed from: j */
    static /* synthetic */ void m18940j(BizTimeLineUI bizTimeLineUI) {
        int i = 0;
        AppMethodBeat.m2504i(14226);
        if (bizTimeLineUI.jOm == null || bizTimeLineUI.jOt == null) {
            AppMethodBeat.m2505o(14226);
            return;
        }
        int firstVisiblePosition = bizTimeLineUI.jOm.getFirstVisiblePosition();
        int lastVisiblePosition = bizTimeLineUI.jOm.getLastVisiblePosition();
        bizTimeLineUI.m18933dE(firstVisiblePosition, lastVisiblePosition);
        if (firstVisiblePosition > 0) {
            firstVisiblePosition--;
        } else {
            firstVisiblePosition = 0;
        }
        if (lastVisiblePosition > 0) {
            i = lastVisiblePosition - 1;
        }
        while (firstVisiblePosition <= i) {
            C46627q sg = bizTimeLineUI.jOt.mo61563sg(firstVisiblePosition);
            if (sg != null) {
                bizTimeLineUI.jOt.mo61548FE(sg.field_talker);
                bizTimeLineUI.jNy.mo35303c(sg, firstVisiblePosition);
            }
            firstVisiblePosition++;
        }
        AppMethodBeat.m2505o(14226);
    }

    /* renamed from: m */
    static /* synthetic */ void m18943m(BizTimeLineUI bizTimeLineUI) {
        AppMethodBeat.m2504i(14227);
        if (!(bizTimeLineUI.jOt == null || bizTimeLineUI.jOm == null || bizTimeLineUI.jOt.getCount() <= 0)) {
            bizTimeLineUI.jOt.aWr();
            bizTimeLineUI.jOt.notifyDataSetChanged();
            bizTimeLineUI.jOI = true;
            C5004al.m7442n(new C112188(), 200);
            bizTimeLineUI.jOm.setSelection(0);
            bizTimeLineUI.jNy.mo35305si(6);
            if (bizTimeLineUI.jOt != null) {
                C46627q aWq = bizTimeLineUI.jOt.aWq();
                if (aWq != null) {
                    C30309s.m48273mL(aWq.field_orderFlag);
                }
            }
            bizTimeLineUI.aWE();
        }
        AppMethodBeat.m2505o(14227);
    }
}
