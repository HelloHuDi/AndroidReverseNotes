package com.tencent.p177mm.p612ui.contact;

import android.app.Activity;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.AlphabetScrollBar;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.MMTagPanel;
import com.tencent.p177mm.p612ui.base.MMTagPanel.C44799a;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar.C30374a;
import com.tencent.p177mm.p612ui.contact.C36877m.C36878a;
import com.tencent.p177mm.p612ui.contact.LabelContainerView.C30632a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.MultiSelectContactView;
import com.tencent.p177mm.pluginsdk.p597ui.MultiSelectContactView.C35818a;
import com.tencent.p177mm.pluginsdk.p597ui.MultiSelectContactView.C40457b;
import com.tencent.p177mm.pluginsdk.p597ui.MultiSelectContactView.C44075c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.MMBaseSelectContactUI */
public abstract class MMBaseSelectContactUI extends MMActivity implements OnItemClickListener, C35818a, C40457b, C44075c, C30374a, C36251l, C5600b {
    protected C5601o elS;
    public MultiSelectContactView opo;
    private ListView pxq;
    private View qzN;
    protected int scene;
    private AlphabetScrollBar zmY;
    private C40845o zmZ;
    public C36877m zna;
    private C46633o znb;
    private View znc;
    private View znd;
    private TextView zne;
    private LabelContainerView znf;
    private TextView zng;
    private MMTagPanel znh;
    private boolean zni = true;
    private List<String> znj = new ArrayList();

    /* renamed from: com.tencent.mm.ui.contact.MMBaseSelectContactUI$1 */
    class C54361 implements OnTouchListener {
        C54361() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(105214);
            MMBaseSelectContactUI.this.dIa();
            MMBaseSelectContactUI.this.dIb();
            MMBaseSelectContactUI.this.dIc();
            AppMethodBeat.m2505o(105214);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.MMBaseSelectContactUI$2 */
    class C157952 implements OnMenuItemClickListener {
        C157952() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(105215);
            MMBaseSelectContactUI.this.bMQ();
            AppMethodBeat.m2505o(105215);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.MMBaseSelectContactUI$3 */
    class C157963 implements C36878a {
        C157963() {
        }

        /* renamed from: w */
        public final void mo28008w(String str, int i, boolean z) {
            AppMethodBeat.m2504i(105216);
            C4990ab.m7417i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", Integer.valueOf(i));
            if (!z || i != 0) {
                MMBaseSelectContactUI.m36831c(MMBaseSelectContactUI.this);
                AppMethodBeat.m2505o(105216);
            } else if (C5046bo.isNullOrNil(str)) {
                MMBaseSelectContactUI.this.dIa();
                AppMethodBeat.m2505o(105216);
            } else {
                MMBaseSelectContactUI.m36830b(MMBaseSelectContactUI.this);
                AppMethodBeat.m2505o(105216);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.MMBaseSelectContactUI$4 */
    class C157974 implements OnScrollListener {
        C157974() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(105217);
            if (i != 0) {
                MMBaseSelectContactUI.this.aqX();
                MMBaseSelectContactUI.this.dIc();
            }
            AppMethodBeat.m2505o(105217);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(105218);
            if (!(MMBaseSelectContactUI.this.aow() || MMBaseSelectContactUI.this.opo == null)) {
                View childAt = MMBaseSelectContactUI.this.pxq.getChildAt(MMBaseSelectContactUI.this.pxq.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    MMBaseSelectContactUI.this.qzN.setVisibility(0);
                } else {
                    MMBaseSelectContactUI.this.qzN.setVisibility(8);
                }
            }
            if (i < 2) {
                AppMethodBeat.m2505o(105218);
                return;
            }
            C1720g.m3537RQ();
            if (!C5046bo.m7546e((Boolean) C1720g.m3536RP().mo5239Ry().get(12296, null))) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(12296, Boolean.TRUE);
                if (MMBaseSelectContactUI.this.znb != null) {
                    MMBaseSelectContactUI.this.znb.dismiss();
                }
                MMBaseSelectContactUI.this.znb = C23639t.m36486a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.getString(C25738R.string.cw9), 4000);
            }
            AppMethodBeat.m2505o(105218);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.MMBaseSelectContactUI$6 */
    class C239016 implements C44799a {
        C239016() {
        }

        /* renamed from: JR */
        public final void mo23722JR(String str) {
        }

        /* renamed from: JS */
        public final void mo23723JS(String str) {
            AppMethodBeat.m2504i(105221);
            MMBaseSelectContactUI.this.mo7896QA(str);
            AppMethodBeat.m2505o(105221);
        }

        /* renamed from: JT */
        public final void mo23724JT(String str) {
        }

        /* renamed from: q */
        public final void mo23728q(boolean z, int i) {
        }

        public final void bmm() {
        }

        /* renamed from: JU */
        public final void mo23725JU(String str) {
        }

        /* renamed from: JV */
        public final void mo23726JV(String str) {
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.MMBaseSelectContactUI$5 */
    class C239025 implements C30632a {
        C239025() {
        }

        public final void bmk() {
            AppMethodBeat.m2504i(105219);
            if (MMBaseSelectContactUI.this.opo != null) {
                MMBaseSelectContactUI.this.opo.clearFocus();
            }
            if (MMBaseSelectContactUI.this.elS != null) {
                MMBaseSelectContactUI.this.elS.clearFocus();
                MMBaseSelectContactUI.this.elS.dJS();
            }
            MMBaseSelectContactUI.this.znf.requestFocus();
            MMBaseSelectContactUI.this.znf.setVisibility(8);
            AppMethodBeat.m2505o(105219);
        }

        public final void bml() {
            AppMethodBeat.m2504i(105220);
            MMBaseSelectContactUI.this.aqX();
            AppMethodBeat.m2505o(105220);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.MMBaseSelectContactUI$7 */
    class C239037 implements Runnable {

        /* renamed from: com.tencent.mm.ui.contact.MMBaseSelectContactUI$7$1 */
        class C239041 implements Runnable {
            C239041() {
            }

            public final void run() {
                AppMethodBeat.m2504i(105222);
                MMBaseSelectContactUI.this.dHY();
                AppMethodBeat.m2505o(105222);
            }
        }

        C239037() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105223);
            MMBaseSelectContactUI.this.znj = C21156a.bJa().bIV();
            MMBaseSelectContactUI.this.zni = true;
            C5004al.m7441d(new C239041());
            AppMethodBeat.m2505o(105223);
        }

        public final String toString() {
            AppMethodBeat.m2504i(105224);
            String str = super.toString() + "|updateLabelList";
            AppMethodBeat.m2505o(105224);
            return str;
        }
    }

    public abstract C36877m aoA();

    public abstract boolean aow();

    public abstract boolean aox();

    public abstract String aoy();

    public abstract C40845o aoz();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
        if (C1720g.m3531RK()) {
            mo7850Kh();
            C4990ab.m7416i("MicroMsg.MMBaseSelectContactUI", "initData done!");
            initView();
            C4990ab.m7416i("MicroMsg.MMBaseSelectContactUI", "initView done!");
            return;
        }
        C4990ab.m7412e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
        C4990ab.dou();
        finish();
    }

    public final C36252n dHV() {
        if (getContentLV().getHeaderViewsCount() > 0) {
            return (C36252n) ((HeaderViewListAdapter) getContentLV().getAdapter()).getWrappedAdapter();
        }
        return (C36252n) getContentLV().getAdapter();
    }

    public ListView getContentLV() {
        return this.pxq;
    }

    public C40845o dHW() {
        return this.zmZ;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Kh */
    public void mo7850Kh() {
        this.scene = getIntent().getIntExtra("scene", 0);
    }

    public void initView() {
        setMMTitle(aoy());
        this.pxq = (ListView) findViewById(2131820897);
        this.zmZ = aoz();
        this.zna = aoA();
        this.qzN = findViewById(2131820899);
        if (dId()) {
            this.znd = findViewById(2131820903);
            this.zne = (TextView) findViewById(2131820904);
            this.znd.setOnTouchListener(new C54361());
            if (aow()) {
                this.elS = new C5601o((byte) 0);
                this.elS.zHa = this;
                mo17380a(this.elS);
            } else {
                this.opo = (MultiSelectContactView) findViewById(2131820898);
                this.opo.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, C8415j.INVALID_ID), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, C8415j.INVALID_ID));
                this.opo.setOnSearchTextChangeListener(this);
                this.opo.setOnSearchTextFouceChangeListener(this);
                this.opo.setOnContactDeselectListener(this);
                this.opo.setVisibility(0);
                this.znc = new View(this.mController.ylL);
                this.znc.setLayoutParams(new LayoutParams(-1, this.opo.getMeasuredHeight()));
                this.znc.setVisibility(4);
                this.pxq.addHeaderView(this.znc);
                findViewById(2131820896).setVisibility(0);
            }
        }
        mo7851a(this.pxq, 0);
        this.pxq.setAdapter(this.zmZ);
        setBackBtn(new C157952());
        if (this.zna != null) {
            this.zna.mo49041a(new C157963());
        }
        this.pxq.setOnScrollListener(new C157974());
        this.pxq.setOnItemClickListener(this);
        if (aox()) {
            this.zmY = (AlphabetScrollBar) findViewById(2131820900);
            this.zmY.setVisibility(0);
            this.zmY.setOnScrollBarTouchListener(this);
        }
        if (bOd()) {
            this.znf = (LabelContainerView) findViewById(2131820901);
            this.zng = (TextView) this.znf.findViewById(16908310);
            this.zng.setText(C25738R.string.e18);
            this.znh = (MMTagPanel) this.znf.findViewById(2131820902);
            this.znh.setTagSelectedBG(C25738R.drawable.a31);
            this.znh.setTagSelectedTextColorRes(C25738R.color.f12212w4);
            this.znf.setOnLabelContainerListener(new C239025());
            this.znh.setCallBack(new C239016());
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        if (headerViewsCount >= 0) {
            C5445a Pn = dHV().getItem(headerViewsCount);
            Pn.aou().aov();
            if (Pn.eDk) {
                headerViewsCount = Pn.mFr;
                int i2 = Pn.mFs;
                if (Pn.bAv()) {
                    headerViewsCount = 15;
                } else if (headerViewsCount == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    switch (i2) {
                        case 1:
                            headerViewsCount = 1;
                            break;
                        case 2:
                            headerViewsCount = 2;
                            break;
                        case 3:
                            headerViewsCount = 3;
                            break;
                        case 4:
                            headerViewsCount = 4;
                            break;
                        case 5:
                            headerViewsCount = 5;
                            break;
                        case 6:
                            headerViewsCount = 6;
                            break;
                        case 7:
                            headerViewsCount = 7;
                            break;
                        case 11:
                            headerViewsCount = 8;
                            break;
                        case 15:
                            headerViewsCount = 16;
                            break;
                        case 16:
                            headerViewsCount = 10;
                            break;
                        case 17:
                        case 18:
                            headerViewsCount = 9;
                            break;
                        default:
                            headerViewsCount = 0;
                            break;
                    }
                } else if (headerViewsCount == 131075) {
                    switch (i2) {
                        case 1:
                        case 5:
                            headerViewsCount = 12;
                            break;
                        case 2:
                        case 6:
                            headerViewsCount = 13;
                            break;
                        case 3:
                        case 7:
                            headerViewsCount = 14;
                            break;
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 34:
                        case 35:
                        case 36:
                        case C2275g.CTRL_INDEX /*37*/:
                        case 38:
                            headerViewsCount = 11;
                            break;
                        default:
                            headerViewsCount = 0;
                            break;
                    }
                } else {
                    headerViewsCount = headerViewsCount == 65536 ? 17 : 0;
                }
                switch (Pn.mFr) {
                    case 65536:
                        i2 = 5;
                        break;
                    case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                        i2 = 2;
                        break;
                    case 131075:
                        i2 = 3;
                        break;
                    case 131076:
                        i2 = 4;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                if (Pn.zpC) {
                    i2 = 1;
                }
                if (Pn.klY == 5) {
                    i2 = 7;
                }
                C4990ab.m7419v("MicroMsg.SelectContactReportLogic", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{Pn.query, Integer.valueOf(Pn.scene), Integer.valueOf(i2), Integer.valueOf(Pn.mFm), Integer.valueOf(headerViewsCount)}));
                C7060h.pYm.mo8374X(13234, r0);
            }
        }
        if (!dHV().mo39695Po(i)) {
            mo7859mO(i);
        }
    }

    /* renamed from: mO */
    public void mo7859mO(int i) {
    }

    private String dHX() {
        if (this.elS != null) {
            return this.elS.getSearchContent();
        }
        if (this.opo != null) {
            return this.opo.getSearchContent();
        }
        return "";
    }

    private void dHY() {
        boolean dJs = this.elS != null ? this.elS.dJs() : this.opo != null ? this.opo.hasFocus() : false;
        if (dJs && C5046bo.isNullOrNil(dHX())) {
            if (this.znj == null || this.znj.size() <= 0) {
                this.znf.setVisibility(8);
                return;
            }
            this.znf.setVisibility(0);
            this.znh.mo71950a(null, this.znj);
        } else if (this.znf != null) {
            this.znf.setVisibility(8);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.znb != null) {
            this.znb.dismiss();
        }
    }

    public void onResume() {
        super.onResume();
        if (bOd() && this.zni) {
            this.zni = false;
            C1720g.m3539RS().mo10302aa(new C239037());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.zmY != null) {
            this.zmY.yAU = null;
        }
        if (this.zmZ != null) {
            this.zmZ.finish();
        }
        if (this.zna != null) {
            this.zna.finish();
        }
        if (this.znb != null) {
            this.znb.dismiss();
        }
    }

    public int getLayoutId() {
        return 2130970216;
    }

    /* renamed from: Qa */
    public final void mo39660Qa(String str) {
        C4990ab.m7417i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", str);
        if (bOd()) {
            dHY();
        }
        if (this.zna == null) {
            return;
        }
        if (C5046bo.isNullOrNil(str)) {
            this.zna.clearData();
            this.zna.notifyDataSetChanged();
            dIa();
            return;
        }
        this.zna.mo24874a(str, bMP(), dHZ());
    }

    public final void dji() {
        if (bOd()) {
            dHY();
        }
    }

    public int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131081};
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo7851a(ListView listView, int i) {
    }

    public void bMQ() {
        aqX();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            bMQ();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: kp */
    public final void mo17482kp(String str) {
        if (this.zmZ != null) {
            int arM = this.zmZ.arM(str);
            if (arM == 0) {
                this.pxq.setSelection(0);
            } else if (arM <= 0) {
                C4990ab.m7417i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", Integer.valueOf(arM), str);
            } else if (aow()) {
                this.pxq.setSelection(arM);
            } else if (this.opo != null) {
                this.pxq.setSelectionFromTop(arM, this.opo.getMeasuredHeight());
            }
        }
    }

    /* renamed from: vN */
    public final boolean mo7459vN(String str) {
        return false;
    }

    /* renamed from: vO */
    public final void mo7460vO(String str) {
        C4990ab.m7417i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", str);
        if (bOd()) {
            if (this.elS != null) {
                this.elS.dJt();
            }
            dHY();
        }
        if (C5046bo.isNullOrNil(str)) {
            this.zna.clearData();
            this.zna.notifyDataSetChanged();
            dIa();
            return;
        }
        this.zna.mo24874a(str, bMP(), dHZ());
    }

    /* Access modifiers changed, original: protected */
    public boolean dHZ() {
        return false;
    }

    public final void apo() {
        dIa();
        if (bOd()) {
            dHY();
        }
    }

    public final void app() {
    }

    private void dIa() {
        C4990ab.m7416i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
        mo7851a(this.pxq, 0);
        this.pxq.setAdapter(this.zmZ);
        this.zmZ.notifyDataSetChanged();
        if (aox() && this.zmY != null) {
            this.zmY.setVisibility(0);
        }
        this.znd.setVisibility(8);
    }

    /* renamed from: vI */
    public void mo7901vI(String str) {
    }

    /* renamed from: b */
    public boolean mo39661b(C5445a c5445a) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7897a(C5445a c5445a) {
        return false;
    }

    public Activity getActivity() {
        return this;
    }

    /* Access modifiers changed, original: protected */
    public boolean bOd() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: QA */
    public void mo7896QA(String str) {
        C4990ab.m7417i("MicroMsg.MMBaseSelectContactUI", "select label=%s", str);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dIb() {
        if (this.elS != null) {
            if (!C5046bo.isNullOrNil(this.elS.getSearchContent())) {
                C5601o c5601o = this.elS;
                if (c5601o.zGZ != null) {
                    c5601o.zGZ.mo11323qO(true);
                }
            }
        } else if (this.opo != null && !C5046bo.isNullOrNil(this.opo.getSearchContent())) {
            this.opo.vhY.setText("");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void dIc() {
        if (this.elS != null) {
            if (this.elS.dJs()) {
                this.elS.clearFocus();
            }
        } else if (this.opo != null && this.opo.hasFocus()) {
            this.opo.clearFocus();
        }
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public boolean dId() {
        return this.zna != null;
    }

    /* renamed from: c */
    static /* synthetic */ void m36831c(MMBaseSelectContactUI mMBaseSelectContactUI) {
        C4990ab.m7416i("MicroMsg.MMBaseSelectContactUI", "setSearchStatus");
        mMBaseSelectContactUI.mo7851a(mMBaseSelectContactUI.pxq, 8);
        mMBaseSelectContactUI.pxq.setAdapter(mMBaseSelectContactUI.zna);
        mMBaseSelectContactUI.zna.notifyDataSetChanged();
        if (mMBaseSelectContactUI.aox() && mMBaseSelectContactUI.zmY != null) {
            mMBaseSelectContactUI.zmY.setVisibility(8);
        }
        mMBaseSelectContactUI.znd.setVisibility(8);
    }
}
