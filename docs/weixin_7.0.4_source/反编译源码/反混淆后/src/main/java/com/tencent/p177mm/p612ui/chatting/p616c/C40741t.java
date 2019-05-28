package com.tencent.p177mm.p612ui.chatting.p616c;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.p069v7.app.ActionBar;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.widget.ActionBarContainer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.common.Scopes;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1441a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p871b.C18613e.C18614a;
import com.tencent.p177mm.model.p871b.C45437b;
import com.tencent.p177mm.model.p871b.C45437b.C9645a;
import com.tencent.p177mm.model.p871b.C45437b.C9646b;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p199ax.C1301c;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p232b.p233a.C32677t;
import com.tencent.p177mm.p612ui.C15481a;
import com.tencent.p177mm.p612ui.C24020t;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.C7354r;
import com.tencent.p177mm.p612ui.ServiceNotifySettingsUI;
import com.tencent.p177mm.p612ui.SingleChatInfoUI;
import com.tencent.p177mm.p612ui.chatting.BaseChattingUIFragment;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30468n;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40722a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40725t;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7335f;
import com.tencent.p177mm.p612ui.conversation.p626a.C5477e;
import com.tencent.p177mm.p612ui.conversation.p626a.C5477e.C5479a;
import com.tencent.p177mm.p612ui.p614b.C7318b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C35853a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.util.LinkedList;
import java.util.List;

@C15590a(dFp = C44299r.class)
/* renamed from: com.tencent.mm.ui.chatting.c.t */
public class C40741t extends C44291a implements C44299r {
    private int qvb = 0;
    private final C4931a yOu = new C407404();
    private boolean yOx = false;
    protected LinearLayout yQi;
    protected LinearLayout yQj;
    private List<String> yQk = new LinkedList();
    private String yQl;
    private ActionBarContainer yQm = null;
    public C7354r yQn = null;
    private C15481a yQo;
    private View yQp;
    final C24020t yQq = new C40747a();
    private C9645a yQr = new C304911();
    private Runnable yQs = null;
    private final C8915a yQt = new C407443();
    private OnMenuItemClickListener yQu = new C156297();
    final int yQv = 1;
    final int yQw = 2;
    final OnMenuItemClickListener yQx = new C304938();
    private View yQy = null;
    private View yQz = null;

    /* renamed from: com.tencent.mm.ui.chatting.c.t$7 */
    class C156297 implements OnMenuItemClickListener {
        C156297() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(31485);
            boolean dBP = C40741t.this.cgL.yTx.dBP();
            AppMethodBeat.m2505o(31485);
            return dBP;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.t$9 */
    class C237669 implements OnClickListener {
        C237669() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31487);
            C40741t.m70441a(C40741t.this);
            AppMethodBeat.m2505o(31487);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.t$1 */
    class C304911 implements C9645a {

        /* renamed from: com.tencent.mm.ui.chatting.c.t$1$1 */
        class C304921 implements Runnable {
            C304921() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31472);
                C9638aw.m17190ZK().mo33887Ym();
                if (C45437b.m83691a(C9646b.Chatting)) {
                    C40741t.m70443b(C40741t.this);
                    AppMethodBeat.m2505o(31472);
                    return;
                }
                C40741t.m70444c(C40741t.this);
                AppMethodBeat.m2505o(31472);
            }
        }

        C304911() {
        }

        public final void aaW() {
            AppMethodBeat.m2504i(31473);
            C46650a.dFz().post(new C304921());
            AppMethodBeat.m2505o(31473);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.t$8 */
    class C304938 implements OnMenuItemClickListener {
        C304938() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(31486);
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 5;
            c26250ui.cQx.talker = C40741t.this.cgL.sRl.field_username;
            c26250ui.cQx.context = C40741t.this.cgL.yTx.getContext();
            if (menuItem.getItemId() == 1) {
                c26250ui.cQx.cQs = 4;
            } else if (menuItem.getItemId() == 2) {
                c26250ui.cQx.cQs = 2;
            }
            C4879a.xxA.mo10055m(c26250ui);
            AppMethodBeat.m2505o(31486);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.t$4 */
    class C407404 implements C4931a {
        C407404() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(31478);
            C4990ab.m7418v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(str)));
            if (C40741t.this.cgL.dFx() && !C5046bo.isNullOrNil(str)) {
                C40741t.this.dEm();
                C40741t.this.dEp();
            }
            AppMethodBeat.m2505o(31478);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.t$6 */
    class C407426 implements C18614a {

        /* renamed from: com.tencent.mm.ui.chatting.c.t$6$1 */
        class C361541 implements Runnable {
            C361541() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31482);
                C40741t.m70449h(C40741t.this);
                AppMethodBeat.m2505o(31482);
            }
        }

        C407426() {
        }

        public final void aaX() {
            AppMethodBeat.m2504i(31483);
            C46650a.dFz().post(new C361541());
            AppMethodBeat.m2505o(31483);
        }

        public final void aaY() {
            AppMethodBeat.m2504i(31484);
            C40741t.m70450i(C40741t.this);
            AppMethodBeat.m2505o(31484);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.t$3 */
    class C407443 implements C8915a {
        C407443() {
        }

        /* renamed from: qj */
        public final void mo20342qj(final String str) {
            AppMethodBeat.m2504i(31477);
            C46650a.dFz().removeCallbacks(C40741t.this.yQs);
            C46650a.dFz().postDelayed(C40741t.this.yQs = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(31476);
                    if (!(C5046bo.isNullOrNil(C40741t.this.yQl) || C5046bo.isNullOrNil(str) || !str.equals(C40741t.this.yQl))) {
                        C40741t.this.mo64266qr(false);
                    }
                    AppMethodBeat.m2505o(31476);
                }
            }, 1000);
            AppMethodBeat.m2505o(31477);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.t$5 */
    class C407455 implements C18614a {

        /* renamed from: com.tencent.mm.ui.chatting.c.t$5$1 */
        class C407461 implements Runnable {
            C407461() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31479);
                C40741t.m70447f(C40741t.this);
                AppMethodBeat.m2505o(31479);
            }
        }

        C407455() {
        }

        public final void aaX() {
            AppMethodBeat.m2504i(31480);
            C46650a.dFz().post(new C407461());
            AppMethodBeat.m2505o(31480);
        }

        public final void aaY() {
            AppMethodBeat.m2504i(31481);
            C40741t.m70448g(C40741t.this);
            AppMethodBeat.m2505o(31481);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.t$a */
    class C40747a extends C24020t {
        C40747a() {
        }

        /* renamed from: Kp */
        public final void mo39830Kp() {
            AppMethodBeat.m2504i(31492);
            if (C1855t.m3903mP(C40741t.this.cgL.getTalkerUserName())) {
                C32677t c32677t = new C32677t();
                c32677t.mo53208eO(C40741t.this.cgL.getTalkerUserName());
                c32677t.cXP = 4;
                c32677t.ajK();
            }
            C40741t.this.cgL.aqX();
            Intent intent;
            if (C1855t.m3918nD(C40741t.this.cgL.getTalkerUserName())) {
                C40741t.this.cgL.yTx.getContext().startActivity(new Intent(C40741t.this.cgL.yTx.getContext(), ServiceNotifySettingsUI.class));
                AppMethodBeat.m2505o(31492);
            } else if (C1855t.m3909mV(C40741t.this.cgL.getTalkerUserName())) {
                intent = new Intent();
                intent.putExtra("Contact_User", C40741t.this.cgL.getTalkerUserName());
                C25985d.m41467b(C40741t.this.cgL.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.m2505o(31492);
            } else if (((C40725t) C40741t.this.cgL.mo74857aF(C40725t.class)).dEF()) {
                C40741t.m70441a(C40741t.this);
                AppMethodBeat.m2505o(31492);
            } else if (((C36135d) C40741t.this.cgL.mo74857aF(C36135d.class)).dDx()) {
                AppMethodBeat.m2505o(31492);
            } else {
                intent = new Intent();
                intent.setClass(C40741t.this.cgL.yTx.getContext(), SingleChatInfoUI.class);
                intent.putExtra("Single_Chat_Talker", C40741t.this.cgL.getTalkerUserName());
                intent.putExtra("fromChatting", true);
                C40741t.this.cgL.yTx.startActivity(intent);
                AppMethodBeat.m2505o(31492);
            }
        }
    }

    public C40741t() {
        AppMethodBeat.m2504i(31493);
        AppMethodBeat.m2505o(31493);
    }

    /* renamed from: c */
    static /* synthetic */ void m70444c(C40741t c40741t) {
        AppMethodBeat.m2504i(31535);
        c40741t.dEw();
        AppMethodBeat.m2505o(31535);
    }

    /* renamed from: f */
    static /* synthetic */ void m70447f(C40741t c40741t) {
        AppMethodBeat.m2504i(31536);
        c40741t.dEs();
        AppMethodBeat.m2505o(31536);
    }

    /* renamed from: g */
    static /* synthetic */ void m70448g(C40741t c40741t) {
        AppMethodBeat.m2504i(31537);
        c40741t.dEt();
        AppMethodBeat.m2505o(31537);
    }

    /* renamed from: h */
    static /* synthetic */ void m70449h(C40741t c40741t) {
        AppMethodBeat.m2504i(31538);
        c40741t.dEu();
        AppMethodBeat.m2505o(31538);
    }

    /* renamed from: i */
    static /* synthetic */ void m70450i(C40741t c40741t) {
        AppMethodBeat.m2504i(31539);
        c40741t.dEv();
        AppMethodBeat.m2505o(31539);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        int i = 1;
        AppMethodBeat.m2504i(31494);
        super.onConfigurationChanged(configuration);
        C4990ab.m7410d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.cgL.yTx.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + configuration.orientation);
        this.cgL.yTx.getMMResources().getConfiguration().orientation = configuration.orientation;
        ((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX().djS();
        int i2 = this.yQm != null ? 1 : 0;
        if (this.yQp == null) {
            i = 0;
        }
        if ((i2 & i) != 0) {
            i = C1441a.m3065bG(this.cgL.yTx.getContext());
            this.yQp.setMinimumHeight(i);
            LayoutParams layoutParams = this.yQp.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            layoutParams.height = i;
            this.yQp.setLayoutParams(layoutParams);
            layoutParams = this.yQm.getLayoutParams();
            layoutParams.height = i;
            this.yQm.setLayoutParams(layoutParams);
        }
        if (this.yQn != null) {
            this.yQn.ymW.mActionBar.onConfigurationChanged(configuration);
        }
        AppMethodBeat.m2505o(31494);
    }

    /* renamed from: a */
    public final void mo10944a(C46650a c46650a) {
        AppMethodBeat.m2504i(31495);
        super.mo10944a(c46650a);
        if (isSupportCustomActionBar()) {
            this.yQn = new C7354r();
            C7354r c7354r = this.yQn;
            BaseChattingUIFragment baseChattingUIFragment = this.cgL.yTx;
            c7354r.ymV = baseChattingUIFragment;
            c7354r.ymW = new C7318b(baseChattingUIFragment.thisActivity(), c7354r);
            this.cgL.yTx.setActivityController(this.yQn);
        }
        AppMethodBeat.m2505o(31495);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31496);
        dEn();
        AppMethodBeat.m2505o(31496);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31498);
        mo64266qr(true);
        AppMethodBeat.m2505o(31498);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31501);
        dEl();
        AppMethodBeat.m2505o(31501);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31502);
        super.dDh();
        dEl();
        AppMethodBeat.m2505o(31502);
    }

    public final void dEk() {
        AppMethodBeat.m2504i(31503);
        if (this.cgL.getHeaderViewsCount() > 0) {
            this.yQi = (LinearLayout) this.cgL.getListView().findViewById(2131822691);
        } else {
            this.yQi = (LinearLayout) this.cgL.yTx.getContext().getLayoutInflater().inflate(2130969117, null);
            C46650a c46650a = this.cgL;
            c46650a.yTy.addHeaderView(this.yQi);
        }
        dEt();
        AppMethodBeat.m2505o(31503);
    }

    private void dBr() {
        AppMethodBeat.m2504i(31504);
        if (C1855t.m3908mU(this.cgL.getTalkerUserName())) {
            C16841a.bVv();
            this.cgL.yTx.addIconOptionMenu(0, (int) C25738R.string.f8699cg, (int) C1318a.actionbar_setting_icon, Boolean.valueOf(C1301c.m2776lQ(C32321b.fKF)).booleanValue(), this.yQq);
        }
        AppMethodBeat.m2505o(31504);
    }

    private void dEl() {
        AppMethodBeat.m2504i(31505);
        if (C1720g.m3534RN().mo5161QY()) {
            C17884o.acd().mo67500b(this.yQt);
            C9638aw.m17190ZK();
            C18628c.m29087XV().mo10117d(this.yOu);
        }
        C46650a.dFz().removeCallbacks(this.yQs);
        AppMethodBeat.m2505o(31505);
    }

    public final void dEm() {
        AppMethodBeat.m2504i(31506);
        this.cgL.yTx.setMMSubTitle(null);
        if (C1855t.m3908mU(this.cgL.getTalkerUserName())) {
            mo64255M(this.cgL.sRl.mo16706Oi());
            AppMethodBeat.m2505o(31506);
        } else if (((C23733z) this.cgL.mo74857aF(C23733z.class)).dET()) {
            setMMTitle(C25738R.string.dzg);
            AppMethodBeat.m2505o(31506);
        } else if (C7616ad.aou(this.cgL.getTalkerUserName())) {
            ((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX().setWordCountLimit(140);
            mo64255M(this.cgL.sRl.mo16707Oj());
            AppMethodBeat.m2505o(31506);
        } else if (C1855t.m3920nF(this.cgL.getTalkerUserName())) {
            mo64255M(this.cgL.sRl.mo16706Oi());
            AppMethodBeat.m2505o(31506);
        } else if (C7616ad.m13548mR(this.cgL.getTalkerUserName())) {
            mo64255M(this.cgL.yTx.getContext().getString(C25738R.string.aa8, new Object[]{m70442b(this.cgL.sRl)}).trim());
            AppMethodBeat.m2505o(31506);
        } else {
            if (C7616ad.m13549mg(this.cgL.getTalkerUserName())) {
                if (this.cgL.mo74857aF(C40722a.class) != null) {
                    ((C40722a) this.cgL.mo74857aF(C40722a.class)).dEm();
                    AppMethodBeat.m2505o(31506);
                    return;
                }
            } else if (this.cgL.dFw()) {
                if (C1855t.m3902mO(this.cgL.getTalkerUserName())) {
                    if (!C5046bo.isNullOrNil(this.cgL.sRl.field_nickname)) {
                        mo64255M(this.cgL.yTx.getContext().getString(C25738R.string.bwu, new Object[]{this.cgL.sRl.mo16706Oi(), Integer.valueOf(C37921n.m64060mA(this.cgL.getTalkerUserName()))}));
                        AppMethodBeat.m2505o(31506);
                        return;
                    } else if (C37921n.m64060mA(this.cgL.getTalkerUserName()) == 0) {
                        mo64255M(this.cgL.yTx.getContext().getString(C25738R.string.ao1));
                        AppMethodBeat.m2505o(31506);
                        return;
                    } else {
                        mo64255M(this.cgL.yTx.getContext().getString(C25738R.string.bwu, new Object[]{this.cgL.yTx.getContext().getString(C25738R.string.ao1), Integer.valueOf(C37921n.m64060mA(this.cgL.getTalkerUserName()))}));
                        AppMethodBeat.m2505o(31506);
                        return;
                    }
                } else if (C1855t.m3903mP(this.cgL.getTalkerUserName())) {
                    CharSequence string;
                    if (!C5046bo.isNullOrNil(this.cgL.sRl.field_nickname)) {
                        string = this.cgL.yTx.getContext().getString(C25738R.string.bwu, new Object[]{this.cgL.sRl.mo16706Oi(), Integer.valueOf(C37921n.m64060mA(this.cgL.getTalkerUserName()))});
                    } else if (C37921n.m64060mA(this.cgL.getTalkerUserName()) == 0) {
                        string = this.cgL.yTx.getContext().getString(C25738R.string.ao1);
                    } else {
                        string = this.cgL.yTx.getContext().getString(C25738R.string.bwu, new Object[]{this.cgL.yTx.getContext().getString(C25738R.string.ao1), Integer.valueOf(C37921n.m64060mA(this.cgL.getTalkerUserName()))});
                    }
                    mo64255M(C44089j.m79299c(this.cgL.yTx.getContext(), C44089j.m79294b(this.cgL.yTx.getContext(), string, C1338a.m2856al(this.cgL.yTx.getContext(), C25738R.dimen.f9728dt))));
                    AppMethodBeat.m2505o(31506);
                    return;
                }
            } else if (((C36135d) this.cgL.mo74857aF(C36135d.class)).dDo()) {
                AppMethodBeat.m2505o(31506);
                return;
            } else {
                this.yQo.mo27557pw(C7616ad.aow(this.cgL.getTalkerUserName()));
                this.cgL.yTx.setMMTitle(this.cgL.sRl.mo16707Oj());
                this.yQo.mo27557pw(C7616ad.aow(this.cgL.getTalkerUserName()));
                if (C7616ad.aox(this.cgL.getTalkerUserName())) {
                    this.cgL.yTx.setMMSubTitle(((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(this.cgL.sRl.field_openImAppid, this.cgL.sRl.field_descWordingId));
                }
            }
            AppMethodBeat.m2505o(31506);
        }
    }

    public final void setMMTitle(int i) {
        AppMethodBeat.m2504i(31507);
        mo64255M(this.cgL.yTx.getMMResources().getString(i));
        AppMethodBeat.m2505o(31507);
    }

    /* renamed from: b */
    private String m70442b(C7616ad c7616ad) {
        AppMethodBeat.m2504i(31508);
        String string;
        if (c7616ad == null) {
            string = this.cgL.yTx.getContext().getString(C25738R.string.ab0);
            AppMethodBeat.m2505o(31508);
            return string;
        } else if (RegionCodeDecoder.apQ(c7616ad.getCountryCode())) {
            string = c7616ad.getCity();
            if (C5046bo.isNullOrNil(string)) {
                string = C1854s.m3868mL(c7616ad.getProvince());
                if (C5046bo.isNullOrNil(string)) {
                    RegionCodeDecoder.duj();
                    string = RegionCodeDecoder.getLocName(c7616ad.getCountryCode());
                    AppMethodBeat.m2505o(31508);
                    return string;
                }
                AppMethodBeat.m2505o(31508);
                return string;
            }
            AppMethodBeat.m2505o(31508);
            return string;
        } else {
            string = C1854s.m3868mL(c7616ad.getProvince());
            if (C5046bo.isNullOrNil(string)) {
                string = this.cgL.yTx.getContext().getString(C25738R.string.ab0);
                AppMethodBeat.m2505o(31508);
                return string;
            }
            AppMethodBeat.m2505o(31508);
            return string;
        }
    }

    private boolean isSupportCustomActionBar() {
        AppMethodBeat.m2504i(31509);
        boolean isSupportNavigationSwipeBack = this.cgL.yTx.isSupportNavigationSwipeBack();
        AppMethodBeat.m2505o(31509);
        return isSupportNavigationSwipeBack;
    }

    /* renamed from: eM */
    public final void mo64265eM(View view) {
        AppMethodBeat.m2504i(31510);
        C4990ab.m7410d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
        if (isSupportCustomActionBar()) {
            if (this.yQm == null) {
                this.yQm = (ActionBarContainer) ((ViewStub) view.findViewById(2131822375)).inflate();
            }
            this.yQn.ymW.f1971SW = (ViewGroup) view;
        }
        AppMethodBeat.m2505o(31510);
    }

    /* renamed from: w */
    private View m70452w(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(31511);
        View view;
        if (this.yQp == null) {
            if (viewGroup == null) {
                this.yQp = C5616v.m8409hu(this.cgL.yTx.getContext()).inflate(2130968612, null);
            } else {
                this.yQp = C5616v.m8409hu(this.cgL.yTx.getContext()).inflate(2130968612, viewGroup, false);
            }
            view = this.yQp;
            AppMethodBeat.m2505o(31511);
            return view;
        } else if (this.yQp.getParent() == null) {
            view = this.yQp;
            AppMethodBeat.m2505o(31511);
            return view;
        } else if (this.yQp.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.yQp.getParent()).removeView(this.yQp);
            view = this.yQp;
            AppMethodBeat.m2505o(31511);
            return view;
        } else {
            if (viewGroup == null) {
                this.yQp = C5616v.m8409hu(this.cgL.yTx.getContext()).inflate(2130968612, null);
            } else {
                this.yQp = C5616v.m8409hu(this.cgL.yTx.getContext()).inflate(2130968612, viewGroup, false);
            }
            view = this.yQp;
            AppMethodBeat.m2505o(31511);
            return view;
        }
    }

    public final void dEn() {
        ActionBar supportActionBar;
        AppMethodBeat.m2504i(31512);
        if (this.cgL.yTx.isCurrentActivity || !isSupportCustomActionBar()) {
            supportActionBar = ((AppCompatActivity) this.cgL.yTx.getContext()).getSupportActionBar();
            View w = m70452w(null);
            supportActionBar.setCustomView(w);
            this.yQo = new C15481a(w);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.yQm.findViewById(2131820941);
            C4990ab.m7417i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", this.yQm);
            C4990ab.m7417i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", this.yQm.findViewById(2131820942));
            viewGroup.setVisibility(0);
            ActionBar supportActionBar2 = this.yQn.getSupportActionBar();
            View w2 = m70452w(viewGroup);
            supportActionBar2.setCustomView(w2);
            this.yQo = new C15481a(w2);
            int height = supportActionBar2.getHeight();
            if (height == 0) {
                DisplayMetrics displayMetrics = this.cgL.yTx.getMMResources().getDisplayMetrics();
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    height = this.cgL.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
                } else {
                    height = this.cgL.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
                }
            }
            w2.setMinimumHeight(height);
            LayoutParams layoutParams = w2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            layoutParams.height = height;
            w2.setLayoutParams(layoutParams);
            supportActionBar = supportActionBar2;
        }
        C40741t.m70440a(supportActionBar);
        this.yQo.mo27557pw(false);
        supportActionBar.setDisplayOptions((((supportActionBar.getDisplayOptions() | 16) & -5) & -3) & -9);
        dEo();
        setBackBtn(this.yQu);
        AppMethodBeat.m2505o(31512);
    }

    /* renamed from: a */
    private static void m70440a(ActionBar actionBar) {
        AppMethodBeat.m2504i(31513);
        if (actionBar.getCustomView() != null) {
            actionBar.getCustomView().findViewById(2131820964);
            actionBar.getCustomView().findViewById(2131820965);
            actionBar.getCustomView().findViewById(2131820966);
            actionBar.getCustomView().findViewById(2131820968);
            actionBar.getCustomView().findViewById(2131820969);
        }
        AppMethodBeat.m2505o(31513);
    }

    private void dEo() {
        AppMethodBeat.m2504i(31514);
        this.yQk.clear();
        this.yQk.add(this.cgL.yTx.getStringExtra("Chat_User"));
        AppMethodBeat.m2505o(31514);
    }

    public final void dEp() {
        AppMethodBeat.m2504i(31515);
        C23733z c23733z = (C23733z) this.cgL.mo74857aF(C23733z.class);
        if (c23733z.dET() || c23733z.dES()) {
            this.cgL.showOptionMenu(false);
            AppMethodBeat.m2505o(31515);
        } else if (((C30468n) this.cgL.mo74857aF(C30468n.class)).dDW()) {
            AppMethodBeat.m2505o(31515);
        } else {
            if (C1855t.m3908mU(this.cgL.getTalkerUserName())) {
                C16841a.bVv();
                this.cgL.yTx.addIconOptionMenu(0, (int) C25738R.string.f8699cg, (int) C1318a.actionbar_setting_icon, Boolean.valueOf(C1301c.m2776lQ(C32321b.fKF)).booleanValue(), this.yQq);
            } else if (C1855t.m3909mV(this.cgL.getTalkerUserName())) {
                m70439a(C25738R.string.f8699cg, C1318a.actionbar_setting_icon, this.yQq);
            } else if (C1855t.m3934nc(this.cgL.getTalkerUserName())) {
                m70439a(C25738R.string.f8699cg, C1318a.actionbar_setting_icon, this.yQq);
                C7060h.pYm.mo8374X(10071, "1");
            } else if (C1855t.m3935nd(this.cgL.getTalkerUserName())) {
                m70439a(C25738R.string.f8699cg, C1318a.actionbar_setting_icon, this.yQq);
            } else if (C1855t.m3918nD(this.cgL.getTalkerUserName())) {
                m70439a(C25738R.string.f8699cg, C1318a.actionbar_setting_icon, this.yQq);
            } else if (C1855t.m3923nI(this.cgL.getTalkerUserName())) {
                if (C1855t.m3946no(this.cgL.getTalkerUserName())) {
                    this.cgL.showOptionMenu(false);
                    AppMethodBeat.m2505o(31515);
                    return;
                }
                m70439a(C25738R.string.f8699cg, C1318a.actionbar_setting_icon, this.yQq);
            } else if (C7616ad.aou(this.cgL.getTalkerUserName()) || C7616ad.aow(this.cgL.getTalkerUserName()) || C7616ad.m13548mR(this.cgL.getTalkerUserName())) {
                m70439a(C25738R.string.anl, C1318a.actionbar_icon_dark_more, this.yQq);
            } else if (C7616ad.m13549mg(this.cgL.getTalkerUserName())) {
                if (this.cgL.mo74857aF(C40722a.class) != null) {
                    ((C40722a) this.cgL.mo74857aF(C40722a.class)).dFq();
                }
            } else if (((C40726v) this.cgL.mo74857aF(C40726v.class)).dEL() && C40729i.arl(this.cgL.getTalkerUserName())) {
                m70439a(C25738R.string.anl, C1318a.ofm_add_icon, this.yQq);
            } else {
                ((C36158x) this.cgL.mo74857aF(C36158x.class)).dEE();
                C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
                if (!C1855t.m3901mN(this.cgL.getTalkerUserName()) && !c36135d.dDm()) {
                    m70439a(C25738R.string.anl, C1318a.actionbar_icon_dark_more, this.yQq);
                } else if (((C7335f) this.cgL.mo74857aF(C7335f.class)).dDF()) {
                    C4990ab.m7416i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
                    m70439a(C25738R.string.anl, C1318a.actionbar_icon_dark_more, this.yQq);
                    this.cgL.showOptionMenu(true);
                } else if (!c36135d.dDm() || c36135d.dDn()) {
                    this.cgL.showOptionMenu(false);
                    AppMethodBeat.m2505o(31515);
                    return;
                } else {
                    m70439a(C25738R.string.anl, C1318a.actionbar_particular_icon, this.yQq);
                    this.cgL.showOptionMenu(true);
                }
            }
            if (C7616ad.m13548mR(this.cgL.getTalkerUserName())) {
                this.cgL.mo74883qv(true);
                AppMethodBeat.m2505o(31515);
                return;
            }
            this.cgL.showOptionMenu(true);
            AppMethodBeat.m2505o(31515);
        }
    }

    /* renamed from: a */
    private void m70439a(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.m2504i(31516);
        if (this.cgL.yTx.findMenuInfo(0) == null) {
            this.cgL.yTx.addIconOptionMenu(0, i, i2, onMenuItemClickListener);
            AppMethodBeat.m2505o(31516);
            return;
        }
        this.cgL.yTx.updateOptionMenu(0, i, i2, onMenuItemClickListener);
        AppMethodBeat.m2505o(31516);
    }

    /* renamed from: qr */
    public final void mo64266qr(boolean z) {
        AppMethodBeat.m2504i(31517);
        if (this.cgL == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
            AppMethodBeat.m2505o(31517);
            return;
        }
        if (this.cgL.dFx()) {
            this.yQl = C40729i.ark(this.cgL.getTalkerUserName());
            if (C5046bo.isNullOrNil(this.yQl) || !(((C7335f) this.cgL.mo74857aF(C7335f.class)).dDF() || ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDs())) {
                dEt();
            } else {
                dEr();
            }
        } else if (C40729i.arl(this.cgL.getTalkerUserName()) && !((C40726v) this.cgL.mo74857aF(C40726v.class)).dEL()) {
            this.yQl = this.cgL.getTalkerUserName();
            dEr();
        } else if (!((C40725t) this.cgL.mo74857aF(C40725t.class)).dEG()) {
            dEs();
        }
        if (z) {
            dEu();
            dEq();
        }
        AppMethodBeat.m2505o(31517);
    }

    private void dEq() {
        AppMethodBeat.m2504i(31518);
        if (this.cgL.yTx.getContext() == null) {
            C4990ab.m7420w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
            AppMethodBeat.m2505o(31518);
            return;
        }
        dEw();
        ViewGroup viewGroup = (ViewGroup) this.cgL.yTx.getContext().findViewById(2131822390);
        C35853a a = C5477e.m8281a(this.cgL.yTx.getContext(), C5479a.CHATTING_MONITORED_HINT, new Object[]{C9646b.Chatting});
        if (!(viewGroup == null || a == null || a.getView() == null || this.yQz != null)) {
            this.yQz = a.getView();
            viewGroup.addView(this.yQz, new LayoutParams(-1, -2));
        }
        AppMethodBeat.m2505o(31518);
    }

    @SuppressLint({"ResourceType"})
    public final void dEr() {
        LinearLayout linearLayout;
        AppMethodBeat.m2504i(31519);
        dEt();
        if (this.yQj == null) {
            C40729i.m70424a(this.cgL.yTx, 2131822376);
            this.yQj = (LinearLayout) this.cgL.yTx.getContext().findViewById(2131822407);
            LinearLayout linearLayout2 = (LinearLayout) this.cgL.yTx.getContext().getLayoutInflater().inflate(2130969116, null);
            this.yQj.addView(linearLayout2, new LayoutParams(-1, -2));
            linearLayout = linearLayout2;
        } else {
            linearLayout = (LinearLayout) this.yQj.findViewById(2131822687);
        }
        this.yQj.setVisibility(0);
        linearLayout.setVisibility(0);
        ImageView imageView = (ImageView) linearLayout.findViewById(2131822688);
        String str = this.yQl;
        if (C5046bo.isNullOrNil(str)) {
            str = this.cgL.sRl.field_username;
        }
        Bitmap a = C41730b.m73490a(str, false, -1);
        if (a == null) {
            imageView.setImageResource(C1318a.default_avatar);
        } else {
            imageView.setImageBitmap(a);
        }
        Button button = (Button) linearLayout.findViewById(2131822690);
        if (((C40725t) this.cgL.mo74857aF(C40725t.class)).dEF()) {
            ((C40725t) this.cgL.mo74857aF(C40725t.class)).mo10947a(button, linearLayout, this.yQj);
        }
        imageView.setOnClickListener(new C237669());
        button.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.ui.chatting.c.t$10$1 */
            class C53251 implements C14917a {
                C53251() {
                }

                /* renamed from: a */
                public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                    AppMethodBeat.m2504i(31488);
                    if (z) {
                        C1855t.m3960q(C40741t.this.cgL.sRl);
                        linearLayout.setVisibility(8);
                    }
                    AppMethodBeat.m2505o(31488);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(31491);
                if (((C40725t) C40741t.this.cgL.mo74857aF(C40725t.class)).dEF()) {
                    ((C40725t) C40741t.this.cgL.mo74857aF(C40725t.class)).mo10946OC(C40741t.this.qvb);
                    AppMethodBeat.m2505o(31491);
                    return;
                }
                CharSequence charSequence;
                if (((int) C40741t.this.cgL.sRl.ewQ) == 0) {
                    C9638aw.m17190ZK();
                    if (C18628c.m29078XM().mo15708aa(C40741t.this.cgL.sRl) != -1) {
                        C4990ab.m7413e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", C40741t.this.cgL.sRl);
                    }
                }
                if (C1855t.m3896kH(C40741t.this.cgL.sRl.field_username)) {
                    charSequence = C40741t.this.cgL.sRl.field_username;
                } else {
                    charSequence = "";
                }
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(C40741t.this.yQl);
                CharSequence bc = aoO != null ? C5046bo.m7532bc(aoO.dus, "") : "";
                C4990ab.m7417i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", C40741t.this.yQl, charSequence, bc);
                if ((TextUtils.isEmpty(charSequence) || !TextUtils.isEmpty(bc)) && !C7616ad.aox(aoO.field_username)) {
                    C14916a c14916a = new C14916a(C40741t.this.cgL.yTx.getContext(), new C53251());
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(3));
                    c14916a.ajw(bc);
                    c14916a.mo27243c(C40741t.this.yQl, charSequence, linkedList);
                } else {
                    C26417a.flu.mo20966a(C40741t.this.yQl, charSequence, new C9636a() {

                        /* renamed from: com.tencent.mm.ui.chatting.c.t$10$2$1 */
                        class C237631 implements C14917a {
                            C237631() {
                            }

                            /* renamed from: a */
                            public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                                AppMethodBeat.m2504i(31489);
                                if (z) {
                                    C1855t.m3960q(C40741t.this.cgL.sRl);
                                    linearLayout.setVisibility(8);
                                }
                                AppMethodBeat.m2505o(31489);
                            }
                        }

                        /* renamed from: o */
                        public final void mo6218o(String str, boolean z) {
                            AppMethodBeat.m2504i(31490);
                            C14916a c14916a = new C14916a(C40741t.this.cgL.yTx.getContext(), new C237631());
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(Integer.valueOf(3));
                            C9638aw.m17190ZK();
                            C7616ad aoO = C18628c.m29078XM().aoO(C40741t.this.yQl);
                            c14916a.ajw(aoO != null ? C5046bo.m7532bc(aoO.dus, "") : "");
                            c14916a.mo27243c(C40741t.this.yQl, charSequence, linkedList);
                            AppMethodBeat.m2505o(31490);
                        }
                    });
                }
                C7060h.pYm.mo8381e(11004, C40741t.this.yQl, Integer.valueOf(3));
                AppMethodBeat.m2505o(31491);
            }
        });
        C7060h.pYm.mo8381e(11004, this.yQl, Integer.valueOf(1));
        AppMethodBeat.m2505o(31519);
    }

    private void dEs() {
        AppMethodBeat.m2504i(31520);
        if (this.cgL.dFx() || this.yQi == null) {
            dEt();
            AppMethodBeat.m2505o(31520);
            return;
        }
        Object a;
        dEt();
        if (this.yQi.getTag() == null) {
            a = C5477e.m8281a(this.cgL.yTx.getContext(), C5479a.CHATTING_RECOMMEND_BANNER, new Object[]{this.cgL.getTalkerUserName(), this.cgL.dDw()});
            if (!(a == null || a.getView() == null)) {
                this.yQi.addView(a.getView(), new LayoutParams(-1, -2));
            }
        } else {
            C35853a a2 = (C35853a) this.yQi.getTag();
        }
        if (a2 != null) {
            this.yQi.setVisibility(0);
            this.yQi.setTag(a2);
        }
        C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, this.cgL.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0));
        AppMethodBeat.m2505o(31520);
    }

    private void dEt() {
        AppMethodBeat.m2504i(31521);
        this.yQi.setVisibility(8);
        if (this.yQj != null) {
            this.yQj.setVisibility(8);
        }
        AppMethodBeat.m2505o(31521);
    }

    private void dEu() {
        AppMethodBeat.m2504i(31522);
        if (this.cgL.yTx.getContext() == null) {
            C4990ab.m7420w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
            AppMethodBeat.m2505o(31522);
            return;
        }
        dEv();
        ViewGroup viewGroup = (ViewGroup) this.cgL.yTx.getContext().findViewById(2131822377);
        C35853a a = C5477e.m8281a(this.cgL.yTx.getContext(), C5479a.CHATTING_SECURITY_BANNER, new Object[]{this.cgL.getTalkerUserName(), this.cgL.dDw(), Boolean.valueOf(this.cgL.dFx())});
        if (!(viewGroup == null || a == null || a.getView() == null || this.yQy != null)) {
            this.yQy = a.getView();
            viewGroup.addView(this.yQy, new LayoutParams(-1, -2));
        }
        AppMethodBeat.m2505o(31522);
    }

    private void dEv() {
        AppMethodBeat.m2504i(31523);
        ViewGroup viewGroup = (ViewGroup) this.cgL.yTx.getContext().findViewById(2131822377);
        if (!(viewGroup == null || this.yQy == null)) {
            viewGroup.removeView(this.yQy);
            this.yQy = null;
        }
        AppMethodBeat.m2505o(31523);
    }

    private void dEw() {
        AppMethodBeat.m2504i(31524);
        ViewGroup viewGroup = (ViewGroup) this.cgL.yTx.getContext().findViewById(2131822390);
        if (!(viewGroup == null || this.yQz == null)) {
            viewGroup.removeView(this.yQz);
            this.yQz = null;
        }
        AppMethodBeat.m2505o(31524);
    }

    public final int dEx() {
        AppMethodBeat.m2504i(31525);
        int i = 0;
        if (this.yQi != null && this.yQi.isShown()) {
            i = this.yQi.getHeight() + 0;
        }
        AppMethodBeat.m2505o(31525);
        return i;
    }

    /* renamed from: M */
    public final void mo64255M(CharSequence charSequence) {
        AppMethodBeat.m2504i(31526);
        if (C1855t.m3903mP(this.cgL.getTalkerUserName())) {
            this.yQo.setTitle(charSequence);
            this.cgL.yTx.updateDescription(this.cgL.yTx.getContext().getString(C25738R.string.ak0, new Object[]{charSequence}));
            AppMethodBeat.m2505o(31526);
        } else if (C7616ad.aox(this.cgL.sRl.field_username)) {
            this.yQo.setTitle(((C32873b) C1720g.m3528K(C32873b.class)).mo44308e(C4996ah.getContext(), charSequence.toString(), C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9728dt)));
            this.cgL.yTx.updateDescription(this.cgL.yTx.getContext().getString(C25738R.string.ak0, new Object[]{r0}));
            AppMethodBeat.m2505o(31526);
        } else {
            this.yQo.setTitle(C44089j.m79294b(this.cgL.yTx.getContext(), charSequence, C1338a.m2856al(this.cgL.yTx.getContext(), C25738R.dimen.f9728dt)));
            this.cgL.yTx.updateDescription(this.cgL.yTx.getContext().getString(C25738R.string.ak0, new Object[]{r0}));
            AppMethodBeat.m2505o(31526);
        }
    }

    public final void setMMSubTitle(String str) {
        AppMethodBeat.m2504i(31527);
        SpannableString b = C44089j.m79294b(this.cgL.yTx.getContext(), (CharSequence) str, C1338a.m2856al(this.cgL.yTx.getContext(), C25738R.dimen.f9936kr));
        C15481a c15481a = this.yQo;
        if (b == null || C5046bo.isNullOrNil(b.toString())) {
            c15481a.yeg.setVisibility(8);
            AppMethodBeat.m2505o(31527);
            return;
        }
        c15481a.yeg.setVisibility(0);
        c15481a.yeg.setText(b);
        if (C1338a.m2865ga(c15481a.yeg.getContext())) {
            c15481a.yeg.setTextSize(1, 14.0f);
            c15481a.gnB.setTextSize(1, 18.0f);
        }
        AppMethodBeat.m2505o(31527);
    }

    public final void setBackBtn(final OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.m2504i(31528);
        this.yQo.mo27555b(new OnClickListener() {

            /* renamed from: com.tencent.mm.ui.chatting.c.t$2$1 */
            class C237641 implements Runnable {
                C237641() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(31474);
                    if (onMenuItemClickListener != null) {
                        onMenuItemClickListener.onMenuItemClick(null);
                    }
                    AppMethodBeat.m2505o(31474);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(31475);
                if (C40741t.this.cgL.yTx.isScreenEnable()) {
                    view.setSelected(false);
                    view.setPressed(false);
                    view.clearFocus();
                    view.invalidate();
                    view.post(new C237641());
                    AppMethodBeat.m2505o(31475);
                    return;
                }
                C4990ab.m7420w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
                AppMethodBeat.m2505o(31475);
            }
        });
        AppMethodBeat.m2505o(31528);
    }

    public final void setTitlePhoneIconVisibility(int i) {
        int i2;
        int i3 = 0;
        AppMethodBeat.m2504i(31529);
        C15481a c15481a = this.yQo;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = c15481a.yei;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        AppMethodBeat.m2505o(31529);
    }

    /* renamed from: Nd */
    public final void mo64256Nd(int i) {
        int i2;
        int i3 = 0;
        AppMethodBeat.m2504i(31530);
        C15481a c15481a = this.yQo;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = c15481a.yeh;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        AppMethodBeat.m2505o(31530);
    }

    public final void setTitleMuteIconVisibility(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(31531);
        if (C1855t.m3918nD(this.cgL.getTalkerUserName())) {
            this.yQo.mo27556pv(false);
            AppMethodBeat.m2505o(31531);
            return;
        }
        C15481a c15481a = this.yQo;
        if (i == 0) {
            z = true;
        }
        c15481a.mo27556pv(z);
        AppMethodBeat.m2505o(31531);
    }

    /* renamed from: OA */
    public final void mo64257OA(int i) {
        int i2;
        int i3 = 0;
        AppMethodBeat.m2504i(31532);
        C15481a c15481a = this.yQo;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = c15481a.yek;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        AppMethodBeat.m2505o(31532);
    }

    public final C7354r dBO() {
        return this.yQn;
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31497);
        this.qvb = this.cgL.yTx.getIntExtra("add_scene", 0);
        C17884o.acd().mo67498a(this.yQt);
        C9638aw.m17190ZK();
        C18628c.m29087XV().mo10116c(this.yOu);
        setBackBtn(this.yQu);
        dBr();
        dEm();
        dEp();
        dEt();
        this.yOx = true;
        AppMethodBeat.m2505o(31497);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31499);
        C9638aw.m17190ZK().mo33885Yk().mo60656a(new C407455());
        C9638aw.m17190ZK().mo33886Yl().mo60656a(new C407426());
        C45437b Ym = C9638aw.m17190ZK().mo33887Ym();
        C9645a c9645a = this.yQr;
        synchronized (C45437b.class) {
            try {
                Ym.mListeners.add(c9645a);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(31499);
                }
            }
        }
        if (!this.yOx) {
            dBr();
        }
        this.yOx = false;
        AppMethodBeat.m2505o(31499);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31500);
        if (C1720g.m3534RN().mo5161QY()) {
            C9638aw.m17190ZK().mo33885Yk().mo60656a(null);
            C9638aw.m17190ZK().mo33886Yl().mo60656a(null);
            C45437b Ym = C9638aw.m17190ZK().mo33887Ym();
            C9645a c9645a = this.yQr;
            synchronized (C45437b.class) {
                try {
                    Ym.mListeners.remove(c9645a);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(31500);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(31500);
    }
}
