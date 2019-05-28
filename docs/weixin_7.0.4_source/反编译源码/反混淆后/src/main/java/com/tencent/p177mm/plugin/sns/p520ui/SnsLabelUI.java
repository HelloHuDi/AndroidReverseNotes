package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.widget.listview.AnimatedExpandableListView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.C42558b;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C7108v;
import com.tencent.p177mm.plugin.sns.model.C7110x;
import com.tencent.p177mm.plugin.sns.p520ui.C22064ap.C22063b;
import com.tencent.p177mm.plugin.sns.p520ui.C22064ap.C22065c;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI */
public class SnsLabelUI extends MMActivity implements C1202f {
    public static int[] rth = new int[]{C25738R.string.elx, C25738R.string.elv, C25738R.string.elr, C25738R.string.elk};
    private AnimatedExpandableListView rtg;
    private ArrayList<String> rti;
    private String rtj;
    private String rtk;
    C22064ap rtl;
    private int rtm = 0;
    private boolean rtn;
    private boolean rto = false;
    private boolean rtp = false;
    private boolean rtq = false;
    private int rtr;
    private C44275p rts;
    private String rtt;
    private int rtu;
    private ArrayList<String> rtv;
    private ArrayList<String> rtw;
    private ArrayList<Long> rtx;
    private ArrayList<String[]> rty;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$12 */
    class C1353612 implements OnClickListener {
        C1353612() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39022);
            SnsLabelUI.m86545o(SnsLabelUI.this);
            AppMethodBeat.m2505o(39022);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$7 */
    class C135387 implements OnMenuItemClickListener {
        C135387() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39017);
            SnsLabelUI.m86538h(SnsLabelUI.this);
            AppMethodBeat.m2505o(39017);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$8 */
    class C135398 implements OnMenuItemClickListener {
        C135398() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39018);
            Context context = SnsLabelUI.this;
            String c = C5046bo.m7536c(context.rtl.rtH, ",");
            String c2 = C5046bo.m7536c(context.rtl.rtJ, ",");
            String c3 = C5046bo.m7536c(context.rtl.rtI, ",");
            String c4 = C5046bo.m7536c(context.rtl.rtK, ",");
            if ((context.rtl.rtF == 2 && context.rtl.rtH.size() == 0 && context.rtl.rtJ.size() == 0) || (context.rtl.rtF == 3 && context.rtl.rtI.size() == 0 && context.rtl.rtK.size() == 0)) {
                C30379h.m48443a(context, context.getString(C25738R.string.elu), "", context.getString(C25738R.string.em3), null);
            } else if ((context.rtl.rtF == 2 && C5046bo.isNullOrNil(c) && C5046bo.isNullOrNil(c2)) || (context.rtl.rtF == 3 && C5046bo.isNullOrNil(c3) && C5046bo.isNullOrNil(c4))) {
                C30379h.m48443a(context, context.getString(C25738R.string.elu), "", context.getString(C25738R.string.em3), null);
            } else {
                context.ctv();
            }
            AppMethodBeat.m2505o(39018);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$5 */
    class C220165 implements OnGroupClickListener {
        C220165() {
        }

        public final boolean onGroupClick(ExpandableListView expandableListView, View view, final int i, long j) {
            AppMethodBeat.m2504i(39015);
            int i2 = SnsLabelUI.this.rtl.rtF;
            C4990ab.m7417i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", Integer.valueOf(i2), Integer.valueOf(i));
            if (i <= 1) {
                if (i2 > 1) {
                    SnsLabelUI.this.rtg.mo39901Qj(i2);
                }
                SnsLabelUI.this.rtl.rtF = i;
                AppMethodBeat.m2505o(39015);
                return false;
            } else if (SnsLabelUI.this.rtw != null && SnsLabelUI.this.rtw.size() != 0 && SnsLabelUI.ctB() == 0) {
                SnsLabelUI.this.rtr = i;
                SnsLabelUI.m86532c(SnsLabelUI.this);
                C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
                AppMethodBeat.m2505o(39015);
                return true;
            } else if (SnsLabelUI.this.rtq) {
                SnsLabelUI.this.rto = true;
                SnsLabelUI.this.rtr = i;
                SnsLabelUI.this.rts = C30379h.m48458b(SnsLabelUI.this, SnsLabelUI.this.getString(C25738R.string.elt), false, null);
                C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
                AppMethodBeat.m2505o(39015);
                return true;
            } else if (SnsLabelUI.this.rtl.rtE == null || SnsLabelUI.this.rtl.rtE.size() == 0) {
                SnsLabelUI.this.rtr = i;
                SnsLabelUI.m86536f(SnsLabelUI.this);
                C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
                AppMethodBeat.m2505o(39015);
                return true;
            } else {
                if (i2 != i) {
                    if (i2 == 2) {
                        SnsLabelUI.this.rtg.collapseGroup(2);
                        SnsLabelUI.this.rtl.rtH.clear();
                        SnsLabelUI.this.rtl.rtJ.clear();
                    } else if (i2 == 3) {
                        SnsLabelUI.this.rtg.collapseGroup(3);
                        SnsLabelUI.this.rtl.rtI.clear();
                        SnsLabelUI.this.rtl.rtK.clear();
                    }
                    SnsLabelUI.this.rtg.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(39014);
                            SnsLabelUI.this.rtg.mo39900Qi(i);
                            AppMethodBeat.m2505o(39014);
                        }
                    });
                } else if (SnsLabelUI.this.rtg.isGroupExpanded(i)) {
                    SnsLabelUI.this.rtg.mo39901Qj(i);
                } else {
                    SnsLabelUI.this.rtg.mo39900Qi(i);
                }
                SnsLabelUI.this.rtl.rtF = i;
                AppMethodBeat.m2505o(39015);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$11 */
    class C2912211 implements OnClickListener {
        C2912211() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39021);
            SnsLabelUI.m86544n(SnsLabelUI.this);
            AppMethodBeat.m2505o(39021);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$6 */
    class C291236 implements OnChildClickListener {
        C291236() {
        }

        public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            AppMethodBeat.m2504i(39016);
            if (i2 == SnsLabelUI.this.rtl.getChildrenCount(i) - 1) {
                SnsLabelUI.this.rtr = i;
                SnsLabelUI.m86536f(SnsLabelUI.this);
            } else {
                String str = (String) SnsLabelUI.this.rtl.getChild(i, i2);
                SnsLabelUI.this.rtl;
                C22064ap.m33683ZF(str);
                if (i == 2) {
                    SnsLabelUI.m86530a(SnsLabelUI.this, 1, SnsLabelUI.this.rtl.rtH, str, view);
                } else if (i == 3) {
                    SnsLabelUI.m86530a(SnsLabelUI.this, 2, SnsLabelUI.this.rtl.rtI, str, view);
                }
            }
            AppMethodBeat.m2505o(39016);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$3 */
    class C398033 implements Runnable {
        C398033() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39013);
            SnsLabelUI.this.rtl.rtF = SnsLabelUI.this.rtr;
            if (SnsLabelUI.this.rtw != null) {
                if (SnsLabelUI.this.rti == null) {
                    SnsLabelUI.this.rti = SnsLabelUI.this.rtw;
                } else {
                    SnsLabelUI.this.rti.addAll(SnsLabelUI.this.rtw);
                }
                Iterator it = SnsLabelUI.this.rtw.iterator();
                while (it.hasNext()) {
                    SnsLabelUI.this.rtl;
                    C22064ap.m33683ZF((String) it.next());
                }
                HashSet hashSet = new HashSet(SnsLabelUI.this.rti);
                SnsLabelUI.this.rti.clear();
                SnsLabelUI.this.rti.addAll(hashSet);
                SnsLabelUI.this.rtw.clear();
                SnsLabelUI.this.rtw = null;
                hashSet.clear();
            }
            SnsLabelUI.this.rtl.mo37619T(SnsLabelUI.this.rti);
            SnsLabelUI.m86541k(SnsLabelUI.this);
            SnsLabelUI.this.rtl.notifyDataSetChanged();
            SnsLabelUI.this.rtg.mo39900Qi(SnsLabelUI.this.rtl.rtF);
            if (SnsLabelUI.this.rts != null && SnsLabelUI.this.rts.isShowing()) {
                SnsLabelUI.this.rts.dismiss();
            }
            AppMethodBeat.m2505o(39013);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$9 */
    class C398049 implements OnClickListener {
        C398049() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39019);
            SnsLabelUI.this.rtp = true;
            C21156a.bJa().mo41640ce(SnsLabelUI.this.rtw);
            SnsLabelUI.this.rts = C30379h.m48458b(SnsLabelUI.this, SnsLabelUI.this.getString(C25738R.string.elt), false, null);
            AppMethodBeat.m2505o(39019);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$1 */
    class C435801 implements C22063b {
        C435801() {
        }

        /* renamed from: a */
        public final void mo37618a(C22065c c22065c) {
            AppMethodBeat.m2504i(39011);
            SnsLabelUI.m86529a(SnsLabelUI.this, c22065c.rtQ, c22065c.rtR);
            AppMethodBeat.m2505o(39011);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$2 */
    class C435812 implements Runnable {
        C435812() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39012);
            C21156a.bJa().ahw();
            SnsLabelUI.this.rti = (ArrayList) C21156a.bJa().bIV();
            SnsLabelUI.this.rtl.mo37619T(SnsLabelUI.this.rti);
            SnsLabelUI.m86541k(SnsLabelUI.this);
            if ((SnsLabelUI.this.rti == null || SnsLabelUI.this.rti.size() == 0) && !((SnsLabelUI.this.rtk != null && SnsLabelUI.this.rtk.length() != 0) || SnsLabelUI.this.rtl.rtF == 0 || SnsLabelUI.this.rtl.rtF == 1)) {
                SnsLabelUI.this.rtl.rtF = 0;
            }
            SnsLabelUI.this.rtl.notifyDataSetChanged();
            SnsLabelUI.this.rtt = null;
            AppMethodBeat.m2505o(39012);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsLabelUI$4 */
    class C462404 implements OnClickListener {
        C462404() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static /* synthetic */ int ctB() {
        AppMethodBeat.m2504i(39041);
        int ctw = SnsLabelUI.ctw();
        AppMethodBeat.m2505o(39041);
        return ctw;
    }

    /* renamed from: h */
    static /* synthetic */ void m86538h(SnsLabelUI snsLabelUI) {
        AppMethodBeat.m2504i(39045);
        snsLabelUI.goBack();
        AppMethodBeat.m2505o(39045);
    }

    /* renamed from: k */
    static /* synthetic */ void m86541k(SnsLabelUI snsLabelUI) {
        AppMethodBeat.m2504i(39046);
        snsLabelUI.ctz();
        AppMethodBeat.m2505o(39046);
    }

    /* renamed from: n */
    static /* synthetic */ void m86544n(SnsLabelUI snsLabelUI) {
        AppMethodBeat.m2504i(39047);
        snsLabelUI.ctv();
        AppMethodBeat.m2505o(39047);
    }

    /* renamed from: o */
    static /* synthetic */ void m86545o(SnsLabelUI snsLabelUI) {
        AppMethodBeat.m2504i(39048);
        snsLabelUI.ctu();
        AppMethodBeat.m2505o(39048);
    }

    public final int getLayoutId() {
        return 2130970767;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39023);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
            AppMethodBeat.m2505o(39023);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(39023);
        return dispatchKeyEvent;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39024);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.eph);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(292, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) C42558b.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(638, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(290, (C1202f) this);
        this.rtl = new C22064ap(this);
        this.rtl.rtL = new C435801();
        Intent intent = getIntent();
        if (intent == null) {
            this.rtm = 0;
            this.rtl.style = 0;
            this.rtj = null;
            this.rtk = null;
        } else {
            this.rtm = intent.getIntExtra("KLabel_range_index", 0);
            this.rtl.style = intent.getIntExtra("k_sns_label_ui_style", 0);
            this.rtj = intent.getStringExtra("Klabel_name_list");
            this.rtk = intent.getStringExtra("Kother_user_name_list");
            if (!TextUtils.isEmpty(intent.getStringExtra("k_sns_label_ui_title"))) {
                setMMTitle(intent.getStringExtra("k_sns_label_ui_title"));
            }
        }
        this.rtl.rtF = this.rtm;
        if (this.rtl.style == 1) {
            findViewById(2131827784).setBackgroundResource(C25738R.color.f11782h4);
        }
        if (this.rtm == 2) {
            if (!TextUtils.isEmpty(this.rtj)) {
                this.rtl.rtH = C5046bo.m7508P(this.rtj.split(","));
            }
            if (!TextUtils.isEmpty(this.rtk)) {
                this.rtl.rtJ = C5046bo.m7508P(this.rtk.split(","));
            }
        } else if (this.rtm == 3) {
            if (!TextUtils.isEmpty(this.rtj)) {
                this.rtl.rtI = C5046bo.m7508P(this.rtj.split(","));
            }
            if (!TextUtils.isEmpty(this.rtk)) {
                this.rtl.rtK = C5046bo.m7508P(this.rtk.split(","));
            }
        }
        C1720g.m3537RQ();
        this.rtn = ((Boolean) C1720g.m3536RP().mo5239Ry().get(335873, Boolean.TRUE)).booleanValue();
        if (this.rtn) {
            this.rtp = true;
            this.rtq = true;
            if (SnsLabelUI.ctw() > 0) {
                this.rto = true;
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C7108v(1), 0);
        }
        initView();
        AppMethodBeat.m2505o(39024);
    }

    public final void initView() {
        AppMethodBeat.m2504i(39025);
        boolean booleanExtra = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
        this.rtg = (AnimatedExpandableListView) findViewById(2131827785);
        this.rti = (ArrayList) C21156a.bJa().bIV();
        this.rtl.rtG = booleanExtra;
        this.rtl.mo37619T(this.rti);
        ctz();
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.f9951l8);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.rtg.addHeaderView(view);
        this.rtg.setAdapter(this.rtl);
        if (this.rtl.rtF == 2) {
            this.rtg.expandGroup(2);
        } else if (this.rtl.rtF == 3) {
            this.rtg.expandGroup(3);
        }
        this.rtg.setOnGroupClickListener(new C220165());
        this.rtg.setOnChildClickListener(new C291236());
        setBackBtn(new C135387());
        mo17379a(0, getString(C25738R.string.elm), (OnMenuItemClickListener) new C135398(), C5535b.GREEN);
        AppMethodBeat.m2505o(39025);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39026);
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        Intent intent2;
        if (i2 == -1 && i == WearableStatusCodes.DATA_ITEM_TOO_LARGE) {
            C4990ab.m7416i("MicroMsg.SnsLabelUI", "the Activity completed");
            stringExtra = intent.getStringExtra("Select_Contacts_To_Create_New_Label");
            if (C5046bo.isNullOrNil(stringExtra)) {
                stringExtra = intent.getStringExtra("Select_Contact");
                this.rtk = new String(stringExtra);
                C4990ab.m7417i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra));
                if (this.rtr == 2) {
                    this.rtl.rtJ.clear();
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        this.rtl.rtJ.addAll(C5046bo.m7508P(stringExtra.split(",")));
                        this.rtl.rtF = this.rtr;
                    }
                } else if (this.rtr == 3) {
                    this.rtl.rtK.clear();
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        this.rtl.rtK.addAll(C5046bo.m7508P(stringExtra.split(",")));
                        this.rtl.rtF = this.rtr;
                    }
                }
                this.rtl.notifyDataSetChanged();
                this.rtg.expandGroup(this.rtr);
                AppMethodBeat.m2505o(39026);
                return;
            }
            intent2 = new Intent();
            intent2.putExtra("Select_Contact", stringExtra);
            C25985d.m41468b(this.mController.ylL, "label", ".ui.ContactLabelEditUI", intent2, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            AppMethodBeat.m2505o(39026);
        } else if (i2 == -1 && i == WearableStatusCodes.DUPLICATE_LISTENER) {
            stringExtra = intent.getStringExtra("Select_Contact");
            C4990ab.m7417i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra));
            if (!C5046bo.isNullOrNil(stringExtra)) {
                intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                C25985d.m41468b((Context) this, "label", ".ui.ContactLabelEditUI", intent2, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            }
            AppMethodBeat.m2505o(39026);
        } else {
            if (i2 == 0 && i == WearableStatusCodes.UNKNOWN_LISTENER && intent != null) {
                stringExtra = intent.getStringExtra("k_sns_label_add_label");
                this.rtt = intent.getStringExtra("k_sns_label_add_label");
                this.rtg.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(39020);
                        SnsLabelUI.this.rti = (ArrayList) C21156a.bJa().bIV();
                        if (SnsLabelUI.this.rti == null) {
                            SnsLabelUI.this.rti = new ArrayList();
                        }
                        int i;
                        if (C5046bo.isNullOrNil(stringExtra)) {
                            i = -1;
                        } else {
                            if (!SnsLabelUI.this.rti.contains(stringExtra)) {
                                SnsLabelUI.this.rti.add(stringExtra);
                            }
                            i = SnsLabelUI.this.rti.indexOf(stringExtra);
                        }
                        SnsLabelUI.this.rtl.mo37619T(SnsLabelUI.this.rti);
                        SnsLabelUI.m86541k(SnsLabelUI.this);
                        SnsLabelUI.this.rtl.rtF = SnsLabelUI.this.rtr;
                        if (!(C5046bo.isNullOrNil(stringExtra) || i == -1)) {
                            if (SnsLabelUI.this.rtr == 2) {
                                SnsLabelUI.this.rtl.rtH.add(stringExtra);
                                SnsLabelUI.this.rtl.rtJ.clear();
                            } else if (SnsLabelUI.this.rtr == 3) {
                                SnsLabelUI.this.rtl.rtI.add(stringExtra);
                                SnsLabelUI.this.rtl.rtK.clear();
                            }
                        }
                        SnsLabelUI.this.rtl.notifyDataSetChanged();
                        SnsLabelUI.this.rtg.expandGroup(SnsLabelUI.this.rtr);
                        SnsLabelUI.this.rtt = null;
                        AppMethodBeat.m2505o(39020);
                    }
                }, 600);
            }
            AppMethodBeat.m2505o(39026);
        }
    }

    private boolean ctt() {
        boolean z = true;
        AppMethodBeat.m2504i(39027);
        int i = this.rtl.rtF;
        if (this.rtl.rtF == this.rtm ? (i != 2 || this.rtl.rtH.size() == 0 || (C5046bo.m7536c(this.rtl.rtH, ",").equals(this.rtj) && C5046bo.m7536c(this.rtl.rtJ, ",").equals(this.rtk))) && (i != 3 || this.rtl.rtI.size() == 0 || (C5046bo.m7536c(this.rtl.rtI, ",").equals(this.rtj) && C5046bo.m7536c(this.rtl.rtK, ",").equals(this.rtk))) : (i != 2 || (this.rtl.rtH.size() == 0 && this.rtl.rtJ.size() == 0)) && !((i == 3 && (this.rtl.rtI.size() != 0 || this.rtl.rtK.size() != 0)) || i == 1 || i == 0)) {
            z = false;
        }
        AppMethodBeat.m2505o(39027);
        return z;
    }

    private void goBack() {
        AppMethodBeat.m2504i(39028);
        if (ctt()) {
            C30379h.m48453a((Context) this, true, getString(C25738R.string.elq), "", getString(C25738R.string.elp), getString(C25738R.string.elo), new C2912211(), new C1353612());
            AppMethodBeat.m2505o(39028);
            return;
        }
        ctu();
        AppMethodBeat.m2505o(39028);
    }

    private void ctu() {
        AppMethodBeat.m2504i(39029);
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.rtm);
        if (this.rtm == 2 || this.rtm == 3) {
            ctA();
            intent.putExtra("Klabel_name_list", this.rtj);
            intent.putExtra("Kother_user_name_list", this.rtk);
        }
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(39029);
    }

    /* Access modifiers changed, original: final */
    public final void ctv() {
        AppMethodBeat.m2504i(39030);
        Intent intent = new Intent();
        if (this.rtl.rtF == 2) {
            this.rtj = C5046bo.m7536c(this.rtl.rtH, ",");
            this.rtk = C5046bo.m7536c(this.rtl.rtJ, ",");
            ctA();
            intent.putExtra("Klabel_name_list", this.rtj);
            intent.putExtra("Kother_user_name_list", this.rtk);
        } else if (this.rtl.rtF == 3) {
            this.rtj = C5046bo.m7536c(this.rtl.rtI, ",");
            this.rtk = C5046bo.m7536c(this.rtl.rtK, ",");
            ctA();
            intent.putExtra("Klabel_name_list", this.rtj);
            intent.putExtra("Kother_user_name_list", this.rtk);
        }
        intent.putExtra("Ktag_range_index", this.rtl.rtF);
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(39030);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39031);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(292, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) C42558b.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(638, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(290, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(39031);
    }

    public void onResume() {
        AppMethodBeat.m2504i(39032);
        if (!(this.rtl == null || this.rtt != null || this.rtg == null)) {
            this.rtg.postDelayed(new C435812(), 600);
        }
        super.onResume();
        AppMethodBeat.m2505o(39032);
    }

    /* JADX WARNING: Missing block: B:30:0x00f3, code skipped:
            if (r0 == null) goto L_0x00f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(39033);
        C4990ab.m7417i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.rtp) {
            int count;
            String str2;
            switch (c1207m.getType()) {
                case 290:
                    if (!(i == 0 && i2 == 0)) {
                        C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
                        break;
                    }
                case 292:
                    if (i == 0 && i2 == 0) {
                        Cursor cursor = C13373af.cnL().getCursor();
                        this.rtu = cursor.getCount();
                        if (this.rtu > 0) {
                            Object str22;
                            cursor.moveToFirst();
                            C13479t c13479t = new C13479t();
                            count = cursor.getCount();
                            this.rtw = new ArrayList(count);
                            this.rtv = new ArrayList(count);
                            this.rty = new ArrayList(count);
                            this.rtx = new ArrayList(count);
                            while (!cursor.isAfterLast()) {
                                c13479t.mo8995d(cursor);
                                if (c13479t.field_memberList == null || c13479t.field_memberList.length() == 0) {
                                    C4990ab.m7412e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
                                } else {
                                    this.rty.add(c13479t.field_memberList.split(","));
                                    String str3 = c13479t.field_tagName;
                                    ArrayList arrayList = this.rtw;
                                    List bIX = C21156a.bJa().bIX();
                                    if (bIX == null) {
                                        str22 = str3;
                                    } else if (bIX.contains(str3)) {
                                        str22 = String.format(getString(C25738R.string.eln), new Object[]{str3});
                                    } else {
                                        str22 = str3;
                                    }
                                    arrayList.add(str22);
                                    this.rtv.add(str3);
                                    this.rtx.add(Long.valueOf(c13479t.field_tagId));
                                }
                                cursor.moveToNext();
                            }
                            cursor.close();
                            if (this.rtv.size() != 0) {
                                str22 = 1;
                                break;
                            } else {
                                str22 = null;
                                break;
                            }
                        }
                        if (this.rtq) {
                            this.rtl.rtF = this.rtr;
                            this.rtg.mo39900Qi(this.rtr);
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(335873, Boolean.FALSE);
                        }
                        cursor.close();
                        if (this.rto) {
                            this.rtp = true;
                            C21156a.bJa().mo41640ce(this.rtw);
                        } else {
                            this.rtp = false;
                        }
                    } else {
                        cty();
                        C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
                    }
                    this.rtq = false;
                    AppMethodBeat.m2505o(39033);
                    return;
                case C42558b.CTRL_INDEX /*635*/:
                    if (i == 0 && i2 == 0) {
                        m86534ds(this.rty);
                        AppMethodBeat.m2505o(39033);
                        return;
                    }
                    cty();
                    C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
                    AppMethodBeat.m2505o(39033);
                    return;
                case 638:
                    if (i == 0 && i2 == 0) {
                        Iterator it = this.rtv.iterator();
                        Iterator it2 = this.rtx.iterator();
                        while (it.hasNext()) {
                            long longValue = ((Long) it2.next()).longValue();
                            str22 = (String) it.next();
                            if (longValue != 0) {
                                C1720g.m3537RQ();
                                C1720g.m3535RO().eJo.mo14541a(new C7110x(longValue, str22), 0);
                            }
                        }
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(335874, Integer.valueOf(0));
                        this.rti = (ArrayList) C21156a.bJa().bIV();
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr = new Object[4];
                        objArr[0] = "";
                        objArr[1] = "";
                        objArr[2] = Integer.valueOf(this.rtu);
                        if (this.rtw == null) {
                            count = 0;
                        } else {
                            count = this.rtw.size();
                        }
                        objArr[3] = Integer.valueOf(count);
                        c7060h.mo8381e(11455, objArr);
                        this.rtg.postDelayed(new C398033(), 600);
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(335873, Boolean.FALSE);
                        AppMethodBeat.m2505o(39033);
                        return;
                    }
                    cty();
                    C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
                    AppMethodBeat.m2505o(39033);
                    return;
            }
            AppMethodBeat.m2505o(39033);
            return;
        }
        AppMethodBeat.m2505o(39033);
    }

    private static int ctw() {
        AppMethodBeat.m2504i(39034);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(335874, Integer.valueOf(0))).intValue();
        AppMethodBeat.m2505o(39034);
        return intValue;
    }

    private static void ctx() {
        AppMethodBeat.m2504i(39035);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(335874, Integer.valueOf(0))).intValue() + 1;
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(335874, Integer.valueOf(intValue));
        AppMethodBeat.m2505o(39035);
    }

    private void cty() {
        AppMethodBeat.m2504i(39036);
        C7060h.pYm.mo8381e(11455, "", "", Integer.valueOf(this.rtu), Integer.valueOf(0));
        SnsLabelUI.ctx();
        this.rtw = null;
        this.rtq = false;
        this.rtp = false;
        if (this.rts != null && this.rts.isShowing()) {
            this.rts.dismiss();
        }
        if (this.rto) {
            this.rto = false;
            AppMethodBeat.m2505o(39036);
            return;
        }
        int i = C25738R.string.em2;
        if (SnsLabelUI.ctw() > 1) {
            i = C25738R.string.em1;
        }
        C30379h.m48431a((Context) this, i, (int) C25738R.string.f9187s6, new C462404());
        AppMethodBeat.m2505o(39036);
    }

    /* renamed from: ds */
    private void m86534ds(List<String[]> list) {
        AppMethodBeat.m2504i(39037);
        if (this.rtw == null || this.rtw.size() == 0) {
            AppMethodBeat.m2505o(39037);
            return;
        }
        Iterator it = this.rtw.iterator();
        Iterator it2 = list.iterator();
        ArrayList arrayList = new ArrayList(this.rtw.size());
        ArrayList arrayList2 = new ArrayList(this.rtw.size());
        while (it.hasNext()) {
            arrayList.add(C21156a.bJa().mo41632PE((String) it.next()));
            arrayList2.add(C5046bo.m7536c(Arrays.asList((Object[]) it2.next()), ","));
            this.rtp = true;
        }
        C21156a.bJa().mo41642i(arrayList, arrayList2);
        AppMethodBeat.m2505o(39037);
    }

    private void ctz() {
        AppMethodBeat.m2504i(39038);
        if (this.rti == null || this.rti.isEmpty()) {
            if (this.rtl.rtH != null) {
                this.rtl.rtH.clear();
            }
            if (this.rtl.rtI != null) {
                this.rtl.rtI.clear();
            }
            AppMethodBeat.m2505o(39038);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it;
        String str;
        if (this.rtm != 2 || this.rtl.rtH == null) {
            if (this.rtm == 3) {
                it = this.rtl.rtI.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    if (!this.rti.contains(str)) {
                        arrayList.add(str);
                    }
                }
                this.rtl.rtI.removeAll(arrayList);
            }
            AppMethodBeat.m2505o(39038);
            return;
        }
        it = this.rtl.rtH.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (!this.rti.contains(str)) {
                arrayList.add(str);
            }
        }
        this.rtl.rtH.removeAll(arrayList);
        AppMethodBeat.m2505o(39038);
    }

    private void ctA() {
        AppMethodBeat.m2504i(39039);
        if (this.rti == null || this.rti.isEmpty()) {
            this.rtj = "";
            AppMethodBeat.m2505o(39039);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.rtj != null) {
            List<String> P = C5046bo.m7508P(this.rtj.split(","));
            if (P != null) {
                for (String str : P) {
                    if (!this.rti.contains(str)) {
                        arrayList.add(str);
                    }
                }
                P.removeAll(arrayList);
                this.rtj = C5046bo.m7536c((List) P, ",");
            }
        }
        AppMethodBeat.m2505o(39039);
    }

    /* renamed from: a */
    static /* synthetic */ void m86529a(SnsLabelUI snsLabelUI, int i, int i2) {
        AppMethodBeat.m2504i(39040);
        if (snsLabelUI.rtl != null) {
            Object child = snsLabelUI.rtl.getChild(i, i2);
            if (child != null && (child instanceof String)) {
                String str = (String) child;
                String PE = C21156a.bJa().mo41632PE(str);
                Intent intent = new Intent();
                intent.putExtra("label_id", PE);
                intent.putExtra("label_name", str);
                intent.putExtra("is_show_delete", false);
                C25985d.m41468b(snsLabelUI.mController.ylL, "label", ".ui.ContactLabelEditUI", intent, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            }
        }
        AppMethodBeat.m2505o(39040);
    }

    /* renamed from: c */
    static /* synthetic */ void m86532c(SnsLabelUI snsLabelUI) {
        AppMethodBeat.m2504i(39042);
        C30379h.m48443a((Context) snsLabelUI, snsLabelUI.getString(C25738R.string.em4), null, snsLabelUI.getString(C25738R.string.em3), new C398049());
        AppMethodBeat.m2505o(39042);
    }

    /* renamed from: f */
    static /* synthetic */ void m86536f(SnsLabelUI snsLabelUI) {
        AppMethodBeat.m2504i(39043);
        Intent intent = new Intent();
        intent.putExtra("titile", snsLabelUI.getString(C25738R.string.f8782eu));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_attr", C15830s.m24190C(C15830s.znE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        if (snsLabelUI.rtr == 2) {
            if (snsLabelUI.rtl.rtJ.size() > 0) {
                intent.putExtra("already_select_contact", C5046bo.m7536c(snsLabelUI.rtl.rtJ, ","));
            }
        } else if (snsLabelUI.rtr == 3 && snsLabelUI.rtl.rtK.size() > 0) {
            intent.putExtra("already_select_contact", C5046bo.m7536c(snsLabelUI.rtl.rtK, ","));
        }
        intent.putExtra("KBlockOpenImFav", true);
        C25985d.m41466b((Context) snsLabelUI, ".ui.contact.SelectContactUI", intent, (int) WearableStatusCodes.DATA_ITEM_TOO_LARGE);
        AppMethodBeat.m2505o(39043);
    }

    /* renamed from: a */
    static /* synthetic */ void m86530a(SnsLabelUI snsLabelUI, int i, ArrayList arrayList, String str, View view) {
        AppMethodBeat.m2504i(39044);
        if (snsLabelUI.rtl == null || snsLabelUI.rtl.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.checkbox_unselected);
                AppMethodBeat.m2505o(39044);
                return;
            }
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.checkbox_selected);
                AppMethodBeat.m2505o(39044);
                return;
            }
            ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.checkbox_selected_red);
            AppMethodBeat.m2505o(39044);
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i == 1) {
                ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.sight_list_checkbox_unselected);
                AppMethodBeat.m2505o(39044);
                return;
            }
            ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.sight_list_checkbox_unselected_red);
            AppMethodBeat.m2505o(39044);
        } else {
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.sight_list_checkbox_selected);
                AppMethodBeat.m2505o(39044);
                return;
            }
            ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.sight_list_checkbox_selected_red);
            AppMethodBeat.m2505o(39044);
        }
    }
}
