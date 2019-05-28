package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p520ui.SnsCommentFooter.C35017b;
import com.tencent.p177mm.plugin.sns.storage.C21992j;
import com.tencent.p177mm.plugin.sns.storage.C29096k;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI */
public class SnsStrangerCommentDetailUI extends MMActivity implements C43559b {
    private static int rxv = 4;
    private long cND;
    private int cvd;
    private ImageView gvq;
    private TextView jWY;
    private View omD;
    private C22062an rhs;
    private C46236n ros;
    private int rpW = -1;
    private C4931a rtZ = new C291377();
    private ListView rxn;
    private SnsCommentFooter rxo;
    private LinearLayout rxp;
    private List<View> rxq;
    private C29131a rxr;
    private boolean rxs = false;
    private boolean rxt = false;
    private C7616ad rxu;
    private String talker;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$1 */
    class C39991 implements OnClickListener {
        C39991() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39311);
            C4978c.m7375a(SnsStrangerCommentDetailUI.this.rxn);
            AppMethodBeat.m2505o(39311);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$2 */
    class C40002 implements Runnable {
        int rro = -1;
        int rrp = 10;

        C40002() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39312);
            if (!SnsStrangerCommentDetailUI.this.rxs) {
                this.rrp = 10;
            }
            SnsStrangerCommentDetailUI.this.rxs = true;
            C4990ab.m7412e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + SnsStrangerCommentDetailUI.this.rxn.getBottom() + " footer.top" + SnsStrangerCommentDetailUI.this.rxn.getTop());
            int top = SnsStrangerCommentDetailUI.this.rxo.getTop();
            int i = this.rrp;
            this.rrp = i - 1;
            if (i > 0 && (this.rro != top || SnsStrangerCommentDetailUI.this.rxn.getBottom() == SnsStrangerCommentDetailUI.this.rpW)) {
                new C7306ak().postDelayed(this, 30);
            }
            this.rro = top;
            C4978c.m7376b(SnsStrangerCommentDetailUI.this.rxn, SnsStrangerCommentDetailUI.this.rxn.getCount() - 1);
            AppMethodBeat.m2505o(39312);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$3 */
    class C40013 implements C35017b {
        C40013() {
        }

        /* renamed from: Zr */
        public final void mo8842Zr(String str) {
            AppMethodBeat.m2504i(39313);
            C4990ab.m7418v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
            SnsStrangerCommentDetailUI.this.rxt = true;
            SnsStrangerCommentDetailUI.m46298a(SnsStrangerCommentDetailUI.this, SnsStrangerCommentDetailUI.this.ros, str);
            AppMethodBeat.m2505o(39313);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$4 */
    class C40024 implements OnMenuItemClickListener {
        C40024() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39314);
            SnsStrangerCommentDetailUI.this.finish();
            AppMethodBeat.m2505o(39314);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$10 */
    class C2912810 implements Runnable {
        C2912810() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39321);
            SnsStrangerCommentDetailUI.this.rpW = SnsStrangerCommentDetailUI.this.rxn.getBottom();
            C4990ab.m7410d("MicroMsg.SnsStrangerCommentDetailUI", "listOriginalBottom: " + SnsStrangerCommentDetailUI.this.rpW);
            AppMethodBeat.m2505o(39321);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$11 */
    class C2912911 implements OnScrollListener {
        C2912911() {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$9 */
    class C291309 implements OnClickListener {
        C291309() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39320);
            if (view.getTag() instanceof C29190ao) {
                SnsStrangerCommentDetailUI.this.rhs.mo37617t(view, 2, 1);
            }
            AppMethodBeat.m2505o(39320);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$a */
    class C29131a extends C46692p<C21992j> {
        private Activity czX;
        private OnClickListener jNC = new C291321();

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$a$a */
        class C29127a {
            ImageView ejo;
            TextView gKl;
            TextView pnE;
            TextView qeX;
            ImageView rxz;
            TextView timeTv;

            C29127a() {
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$a$1 */
        class C291321 implements OnClickListener {
            C291321() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(39322);
                String str = (String) view.getTag();
                C4990ab.m7410d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:".concat(String.valueOf(str)));
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                C24826a.gkE.mo38912c(intent, C29131a.this.czX);
                AppMethodBeat.m2505o(39322);
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(39328);
            C21992j c21992j = (C21992j) obj;
            if (c21992j == null) {
                c21992j = new C21992j();
            }
            c21992j.mo8995d(cursor);
            AppMethodBeat.m2505o(39328);
            return c21992j;
        }

        public C29131a(Activity activity) {
            super(activity, new C21992j());
            AppMethodBeat.m2504i(39324);
            this.czX = activity;
            AppMethodBeat.m2505o(39324);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C29127a c29127a;
            AppMethodBeat.m2504i(39325);
            if (view == null) {
                C29127a c29127a2 = new C29127a();
                view = View.inflate(this.czX, 2130970804, null);
                c29127a2.ejo = (ImageView) view.findViewById(2131827859);
                c29127a2.gKl = (TextView) view.findViewById(2131827861);
                c29127a2.pnE = (TextView) view.findViewById(2131827860);
                c29127a2.qeX = (TextView) view.findViewById(2131827863);
                c29127a2.timeTv = (TextView) view.findViewById(2131827864);
                c29127a2.rxz = (ImageView) view.findViewById(2131827862);
                view.setTag(c29127a2);
                c29127a = c29127a2;
            } else {
                c29127a = (C29127a) view.getTag();
            }
            C21992j c21992j = (C21992j) getItem(i);
            try {
                CharSequence charSequence;
                can can = (can) new can().parseFrom(c21992j.field_curActionBuf);
                C40460b.m69439t(c29127a.ejo, can.wPm);
                c29127a.ejo.setTag(can.wPm);
                c29127a.ejo.setOnClickListener(this.jNC);
                if (can.wZD != null) {
                    charSequence = can.wZD;
                } else {
                    charSequence = ((C21992j) this.ylb).field_talker;
                }
                c29127a.pnE.setTag(can.wPm);
                SpannableString b = C44089j.m79293b(this.czX, charSequence, c29127a.pnE.getTextSize());
                b.setSpan(new C24944o(can.wPm) {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(39323);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", view.getTag().toString());
                        C24826a.gkE.mo38912c(intent, C29131a.this.czX);
                        AppMethodBeat.m2505o(39323);
                    }
                }, 0, charSequence.length(), 33);
                c29127a.pnE.setText(b, BufferType.SPANNABLE);
                c29127a.pnE.setOnTouchListener(new C46247aa());
                if (c21992j.field_type == 3) {
                    c29127a.gKl.setVisibility(0);
                    c29127a.rxz.setVisibility(8);
                    C4990ab.m7418v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + can.vFH + "  time:" + can.pcX + " timeFormatted:" + C29198aw.m46376l(this.czX, ((long) can.pcX) * 1000));
                    c29127a.gKl.setText(can.ncM + " ");
                    C44089j.m79307h(c29127a.gKl, 2);
                    c29127a.gKl.setVisibility(0);
                } else {
                    c29127a.gKl.setVisibility(8);
                    c29127a.rxz.setVisibility(0);
                }
                if (!C1853r.m3846Yz().equals(can.wPm)) {
                    c29127a.qeX.setVisibility(0);
                    TextView textView = c29127a.qeX;
                    switch (can.vFH) {
                        case 18:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(C25738R.string.eku));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, C1338a.m2864g(this.czX, C25738R.drawable.al5), null);
                            break;
                        case 22:
                        case 23:
                        case 24:
                        case 26:
                        case 27:
                        case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        case 29:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(C25738R.string.ekw));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, C1338a.m2864g(this.czX, C25738R.drawable.al7), null);
                            break;
                        case 25:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(C25738R.string.ekt));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, C1338a.m2864g(this.czX, C25738R.drawable.al3), null);
                            break;
                        case 30:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(C25738R.string.ekv));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, C1338a.m2864g(this.czX, C25738R.drawable.al4), null);
                            break;
                        default:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(C25738R.string.ekx));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, C1338a.m2864g(this.czX, C25738R.drawable.al6), null);
                            break;
                    }
                }
                c29127a.qeX.setVisibility(8);
                c29127a.timeTv.setText(C29198aw.m46376l(this.czX, ((long) can.pcX) * 1000));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsStrangerCommentDetailUI", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(39325);
            return view;
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(39326);
            C29096k cnK = C13373af.cnK();
            String l = SnsStrangerCommentDetailUI.this.talker;
            l = C29096k.cqE() + " where talker = " + C7480h.escape(l) + " and  snsID = " + SnsStrangerCommentDetailUI.this.cND + " and ( type = 3 or type = 5 )";
            C4990ab.m7418v("MicroMsg.SnsCommentStorage", "comment sql:".concat(String.valueOf(l)));
            setCursor(cnK.fni.mo10104a(l, null, 0));
            AppMethodBeat.m2505o(39326);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(39327);
            mo6869KC();
            AppMethodBeat.m2505o(39327);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$6 */
    class C291346 implements C30391c {
        C291346() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(39316);
            switch (i) {
                case 0:
                    if (!SnsStrangerCommentDetailUI.this.rxu.mo16698Oa()) {
                        C1855t.m3893i(SnsStrangerCommentDetailUI.this.rxu);
                        SnsStrangerCommentDetailUI.this.rxu.mo16678ND();
                        C24826a.gkF.mo38844BS();
                        break;
                    }
                    C1855t.m3894j(SnsStrangerCommentDetailUI.this.rxu);
                    SnsStrangerCommentDetailUI.this.rxu.mo16679NE();
                    C24826a.gkF.mo38844BS();
                    AppMethodBeat.m2505o(39316);
                    return;
            }
            AppMethodBeat.m2505o(39316);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$8 */
    class C291358 implements Runnable {
        C291358() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39319);
            SnsStrangerCommentDetailUI.this.rxn.setSelection(SnsStrangerCommentDetailUI.this.rxr.getCount() - 1);
            AppMethodBeat.m2505o(39319);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$5 */
    class C291365 implements OnMenuItemClickListener {
        C291365() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39315);
            SnsStrangerCommentDetailUI.m46300b(SnsStrangerCommentDetailUI.this);
            AppMethodBeat.m2505o(39315);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$7 */
    class C291377 implements C4931a {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$7$1 */
        class C291381 implements Runnable {
            C291381() {
            }

            public final void run() {
                AppMethodBeat.m2504i(39317);
                C4990ab.m7418v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
                SnsStrangerCommentDetailUI.this.rxr.mo5248a(null, null);
                if (SnsStrangerCommentDetailUI.this.rxt) {
                    SnsStrangerCommentDetailUI.this.rxt = false;
                    C13373af.bCo().postDelayed(new C291358(), 10);
                }
                AppMethodBeat.m2505o(39317);
            }
        }

        C291377() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(39318);
            C13373af.bCo().post(new C291381());
            AppMethodBeat.m2505o(39318);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsStrangerCommentDetailUI() {
        AppMethodBeat.m2504i(39329);
        AppMethodBeat.m2505o(39329);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39330);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.ek2);
        this.cND = getIntent().getLongExtra("INTENT_SNSID", 0);
        this.talker = getIntent().getStringExtra("INTENT_TALKER");
        this.ros = C13373af.cnF().mo62941kD(this.cND);
        this.cvd = getIntent().getIntExtra("INTENT_SOURCE", -1);
        C1720g.m3537RQ();
        this.rxu = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.talker);
        if (this.ros == null || this.talker == null) {
            finish();
            AppMethodBeat.m2505o(39330);
            return;
        }
        this.rhs = new C22062an(this);
        C13373af.cnK().mo10116c(this.rtZ);
        initView();
        AppMethodBeat.m2505o(39330);
    }

    public void onResume() {
        AppMethodBeat.m2504i(39331);
        C13373af.cnA().mo69136a((C43559b) this);
        super.onResume();
        AppMethodBeat.m2505o(39331);
    }

    public void onPause() {
        AppMethodBeat.m2504i(39332);
        C13373af.cnA().mo69142b((C43559b) this);
        super.onPause();
        AppMethodBeat.m2505o(39332);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39333);
        C13373af.cnK().mo10117d(this.rtZ);
        C13373af.cnC().mo37452ab(this);
        if (this.rxr != null) {
            this.rxr.bIf();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(39333);
    }

    public final void initView() {
        AppMethodBeat.m2504i(39334);
        this.rxn = (ListView) findViewById(2131827707);
        this.rxo = (SnsCommentFooter) findViewById(2131822763);
        this.omD = View.inflate(this, 2130970803, null);
        ctP();
        ctS();
        ctT();
        C39991 c39991 = new C39991();
        setBackBtn(new C40024());
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C291365());
        AppMethodBeat.m2505o(39334);
    }

    private void ctP() {
        AppMethodBeat.m2504i(39335);
        this.rxp = (LinearLayout) this.omD.findViewById(2131827858);
        this.gvq = (ImageView) this.omD.findViewById(2131827708);
        this.jWY = (TextView) this.omD.findViewById(2131827857);
        C40460b.m69439t(this.gvq, this.ros.field_userName);
        this.jWY.setText(C44089j.m79293b((Context) this, ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(this.ros.field_userName), this.jWY.getTextSize()));
        ctQ();
        ctR();
        AppMethodBeat.m2505o(39335);
    }

    private void ctQ() {
        AppMethodBeat.m2504i(39336);
        this.rxp.removeAllViews();
        int b = C4977b.m7371b((Context) this, (float) rxv);
        LinkedList linkedList = this.ros.cqu().xfI.wbK;
        this.rxq = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                MMImageView mMImageView = new MMImageView(this);
                mMImageView.setPadding(b, b, b, b);
                this.rxp.addView(mMImageView, new LayoutParams(-2, -2));
                Bitmap Xh = C13373af.cnC().mo37436a((bau) linkedList.get(i2), (ImageView) mMImageView, hashCode(), C44222az.xYU).mo73229Xh();
                if (Xh == null) {
                    SnsStrangerCommentDetailUI.m46297a(this.ros.field_type, mMImageView);
                } else {
                    mMImageView.setImageBitmap(Xh);
                }
                this.rxq.add(mMImageView);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(39336);
                return;
            }
        }
    }

    private void ctR() {
        AppMethodBeat.m2504i(39337);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.rxq.size()) {
                C29190ao c29190ao = new C29190ao();
                c29190ao.czD = this.ros.cqU();
                c29190ao.index = i2;
                c29190ao.rsl = this.rxq;
                ((View) this.rxq.get(i2)).setTag(c29190ao);
                ((View) this.rxq.get(i2)).setOnClickListener(new C291309());
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(39337);
                return;
            }
        }
    }

    private void ctS() {
        AppMethodBeat.m2504i(39338);
        this.rxn.addHeaderView(this.omD);
        this.rxr = new C29131a(this);
        this.rxn.post(new C2912810());
        this.rxn.setAdapter(this.rxr);
        this.rxn.setOnScrollListener(new C2912911());
        AppMethodBeat.m2505o(39338);
    }

    private void ctT() {
        AppMethodBeat.m2504i(39339);
        this.rxo.setAfterEditAction(new C40002());
        this.rxo.ctf();
        this.rxo.setOnCommentSendImp(new C40013());
        this.rxo.setCommentHint(getString(C25738R.string.env) + this.talker + getString(C25738R.string.ejk));
        AppMethodBeat.m2505o(39339);
    }

    public final int getLayoutId() {
        return 2130970752;
    }

    /* renamed from: a */
    private static void m46297a(int i, MMImageView mMImageView) {
        int i2 = C1318a.app_attach_file_icon_webpage;
        AppMethodBeat.m2504i(39340);
        switch (i) {
            case 1:
                i2 = C25738R.drawable.avp;
                break;
            case 2:
                mMImageView.setImageDrawable(null);
                i2 = 0;
                break;
            case 4:
                i2 = C1318a.app_attach_file_icon_music;
                break;
            case 5:
                i2 = C1318a.app_attach_file_icon_video;
                break;
            case 6:
                i2 = C1318a.app_attach_file_icon_location;
                break;
            case 7:
                i2 = C25738R.drawable.avp;
                break;
            case 8:
                mMImageView.setImageDrawable(null);
                i2 = 0;
                break;
        }
        if (i2 != 0) {
            mMImageView.setImageResource(i2);
        }
        AppMethodBeat.m2505o(39340);
    }

    /* renamed from: Xw */
    public final void mo17655Xw(String str) {
        AppMethodBeat.m2504i(39341);
        ctQ();
        AppMethodBeat.m2505o(39341);
    }

    /* renamed from: bj */
    public final void mo8771bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39342);
        C4990ab.m7416i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(39342);
            return;
        }
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                    if (managedQuery.moveToFirst()) {
                        startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))))));
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.m2505o(39342);
    }

    /* renamed from: bk */
    public final void mo8772bk(String str, boolean z) {
    }

    /* renamed from: b */
    static /* synthetic */ void m46300b(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        AppMethodBeat.m2504i(39343);
        String[] strArr = new String[1];
        if (snsStrangerCommentDetailUI.rxu == null) {
            snsStrangerCommentDetailUI.rxu = new C7616ad();
            AppMethodBeat.m2505o(39343);
            return;
        }
        if (!C7486a.m12942jh(snsStrangerCommentDetailUI.rxu.field_type)) {
            C1855t.m3890f(snsStrangerCommentDetailUI.rxu);
        }
        if (snsStrangerCommentDetailUI.rxu.mo16698Oa()) {
            strArr[0] = snsStrangerCommentDetailUI.getString(C25738R.string.ay6);
        } else {
            strArr[0] = snsStrangerCommentDetailUI.getString(C25738R.string.ay1);
        }
        C30379h.m48424a((Context) snsStrangerCommentDetailUI, "", strArr, "", false, new C291346());
        AppMethodBeat.m2505o(39343);
    }

    /* renamed from: a */
    static /* synthetic */ void m46298a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, C46236n c46236n, String str) {
        AppMethodBeat.m2504i(39344);
        if (str == null || str.trim().equals("")) {
            AppMethodBeat.m2505o(39344);
            return;
        }
        C3890a.m6186a(snsStrangerCommentDetailUI.talker, 3, str, c46236n, snsStrangerCommentDetailUI.cvd);
        AppMethodBeat.m2505o(39344);
    }
}
