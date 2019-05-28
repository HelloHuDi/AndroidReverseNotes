package com.tencent.p177mm.plugin.sns.p520ui.jsapi;

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
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
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
import com.tencent.p177mm.plugin.label.p1276a.C24783b;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C7108v;
import com.tencent.p177mm.plugin.sns.model.C7110x;
import com.tencent.p177mm.plugin.sns.p520ui.jsapi.C22129a.C4085b;
import com.tencent.p177mm.plugin.sns.p520ui.jsapi.C22129a.C4086c;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI */
public class JsapiSnsLabelUI extends MMActivity implements C1202f {
    public static int[] rth = new int[]{C25738R.string.elx, C25738R.string.elv, C25738R.string.elr, C25738R.string.elk};
    public int rJl = 0;
    public int rJm = 1;
    public int rJn = 2;
    public int rJo = 3;
    private List<String> rJp = Arrays.asList("public,private,visible,invisible".split(","));
    C22129a rJq;
    List<String> rJr = new ArrayList();
    private AnimatedExpandableListView rtg;
    private ArrayList<String> rti;
    private String rtj;
    private String rtk;
    private int rtm = this.rJl;
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

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$1 */
    class C221271 implements C4085b {
        C221271() {
        }

        /* renamed from: a */
        public final void mo8948a(C4086c c4086c) {
            AppMethodBeat.m2504i(40172);
            JsapiSnsLabelUI.m57744a(JsapiSnsLabelUI.this, c4086c.rtQ, c4086c.rtR);
            AppMethodBeat.m2505o(40172);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$3 */
    class C221283 implements Runnable {
        C221283() {
        }

        public final void run() {
            AppMethodBeat.m2504i(40174);
            JsapiSnsLabelUI.this.rJq.rtF = JsapiSnsLabelUI.this.rtr;
            if (JsapiSnsLabelUI.this.rtw != null) {
                if (JsapiSnsLabelUI.this.rti == null) {
                    JsapiSnsLabelUI.this.rti = JsapiSnsLabelUI.this.rtw;
                } else {
                    JsapiSnsLabelUI.this.rti.addAll(JsapiSnsLabelUI.this.rtw);
                }
                Iterator it = JsapiSnsLabelUI.this.rtw.iterator();
                while (it.hasNext()) {
                    JsapiSnsLabelUI.this.rJq;
                    C22129a.m33745ZF((String) it.next());
                }
                HashSet hashSet = new HashSet(JsapiSnsLabelUI.this.rti);
                JsapiSnsLabelUI.this.rti.clear();
                JsapiSnsLabelUI.this.rti.addAll(hashSet);
                JsapiSnsLabelUI.this.rtw.clear();
                JsapiSnsLabelUI.this.rtw = null;
                hashSet.clear();
            }
            JsapiSnsLabelUI.this.rJq.mo37677T(JsapiSnsLabelUI.this.rti);
            JsapiSnsLabelUI.m57759k(JsapiSnsLabelUI.this);
            JsapiSnsLabelUI.this.rJq.notifyDataSetChanged();
            JsapiSnsLabelUI.this.rtg.mo39900Qi(JsapiSnsLabelUI.this.rJq.rtF);
            if (JsapiSnsLabelUI.this.rts != null && JsapiSnsLabelUI.this.rts.isShowing()) {
                JsapiSnsLabelUI.this.rts.dismiss();
            }
            AppMethodBeat.m2505o(40174);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$2 */
    class C292292 implements Runnable {
        C292292() {
        }

        public final void run() {
            AppMethodBeat.m2504i(40173);
            C21156a.bJa().ahw();
            JsapiSnsLabelUI.this.rti = (ArrayList) C21156a.bJa().bIV();
            JsapiSnsLabelUI.this.rJq.mo37677T(JsapiSnsLabelUI.this.rti);
            JsapiSnsLabelUI.m57759k(JsapiSnsLabelUI.this);
            if ((JsapiSnsLabelUI.this.rti == null || JsapiSnsLabelUI.this.rti.size() == 0) && !((JsapiSnsLabelUI.this.rtk != null && JsapiSnsLabelUI.this.rtk.length() != 0) || JsapiSnsLabelUI.this.rJq.rtF == JsapiSnsLabelUI.this.rJl || JsapiSnsLabelUI.this.rJq.rtF == JsapiSnsLabelUI.this.rJm)) {
                JsapiSnsLabelUI.this.rJq.rtF = JsapiSnsLabelUI.this.rJl;
            }
            JsapiSnsLabelUI.this.rJq.notifyDataSetChanged();
            JsapiSnsLabelUI.this.rtt = null;
            AppMethodBeat.m2505o(40173);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$4 */
    class C292304 implements OnClickListener {
        C292304() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$11 */
    class C3513111 implements OnClickListener {
        C3513111() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(40182);
            JsapiSnsLabelUI.m57763n(JsapiSnsLabelUI.this);
            AppMethodBeat.m2505o(40182);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$5 */
    class C351325 implements OnGroupClickListener {
        C351325() {
        }

        public final boolean onGroupClick(ExpandableListView expandableListView, View view, final int i, long j) {
            AppMethodBeat.m2504i(40176);
            int i2 = JsapiSnsLabelUI.this.rJq.rtF;
            C4990ab.m7417i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", Integer.valueOf(i2), Integer.valueOf(i));
            if (!JsapiSnsLabelUI.m57742a(JsapiSnsLabelUI.this, i).equals("visible") && !JsapiSnsLabelUI.m57742a(JsapiSnsLabelUI.this, i).equals("invisible")) {
                if (i2 >= 0 && (JsapiSnsLabelUI.m57742a(JsapiSnsLabelUI.this, i2).equals("visible") || JsapiSnsLabelUI.m57742a(JsapiSnsLabelUI.this, i2).equals("invisible"))) {
                    JsapiSnsLabelUI.this.rtg.mo39901Qj(i2);
                }
                JsapiSnsLabelUI.this.rJq.rtF = i;
                AppMethodBeat.m2505o(40176);
                return false;
            } else if (JsapiSnsLabelUI.this.rtw != null && JsapiSnsLabelUI.this.rtw.size() != 0 && JsapiSnsLabelUI.cuW() == 0) {
                JsapiSnsLabelUI.this.rtr = i;
                JsapiSnsLabelUI.m57749c(JsapiSnsLabelUI.this);
                C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
                AppMethodBeat.m2505o(40176);
                return true;
            } else if (JsapiSnsLabelUI.this.rtq) {
                JsapiSnsLabelUI.this.rto = true;
                JsapiSnsLabelUI.this.rtr = i;
                JsapiSnsLabelUI.this.rts = C30379h.m48458b(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(C25738R.string.elt), false, null);
                C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
                AppMethodBeat.m2505o(40176);
                return true;
            } else if (JsapiSnsLabelUI.this.rJq.rtE == null || JsapiSnsLabelUI.this.rJq.rtE.size() == 0) {
                JsapiSnsLabelUI.this.rtr = i;
                JsapiSnsLabelUI.m57754f(JsapiSnsLabelUI.this);
                C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
                AppMethodBeat.m2505o(40176);
                return true;
            } else {
                if (i2 != i) {
                    if (JsapiSnsLabelUI.m57742a(JsapiSnsLabelUI.this, i2).equals("visible")) {
                        JsapiSnsLabelUI.this.rtg.collapseGroup(i2);
                        JsapiSnsLabelUI.this.rJq.rtH.clear();
                        JsapiSnsLabelUI.this.rJq.rtJ.clear();
                    } else if (JsapiSnsLabelUI.m57742a(JsapiSnsLabelUI.this, i2).equals("invisible")) {
                        JsapiSnsLabelUI.this.rtg.collapseGroup(i2);
                        JsapiSnsLabelUI.this.rJq.rtI.clear();
                        JsapiSnsLabelUI.this.rJq.rtK.clear();
                    }
                    JsapiSnsLabelUI.this.rtg.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(40175);
                            JsapiSnsLabelUI.this.rtg.mo39900Qi(i);
                            AppMethodBeat.m2505o(40175);
                        }
                    });
                } else if (JsapiSnsLabelUI.this.rtg.isGroupExpanded(i)) {
                    JsapiSnsLabelUI.this.rtg.mo39901Qj(i);
                } else {
                    JsapiSnsLabelUI.this.rtg.mo39900Qi(i);
                }
                JsapiSnsLabelUI.this.rJq.rtF = i;
                AppMethodBeat.m2505o(40176);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$7 */
    class C351347 implements OnMenuItemClickListener {
        C351347() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40178);
            JsapiSnsLabelUI.m57756h(JsapiSnsLabelUI.this);
            AppMethodBeat.m2505o(40178);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$8 */
    class C351358 implements OnMenuItemClickListener {
        C351358() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40179);
            Context context = JsapiSnsLabelUI.this;
            String c = C5046bo.m7536c(context.rJq.rtH, ",");
            String c2 = C5046bo.m7536c(context.rJq.rtJ, ",");
            String c3 = C5046bo.m7536c(context.rJq.rtI, ",");
            String c4 = C5046bo.m7536c(context.rJq.rtK, ",");
            if ((context.rJq.rtF == context.rJn && context.rJq.rtH.size() == 0 && context.rJq.rtJ.size() == 0) || (context.rJq.rtF == context.rJo && context.rJq.rtI.size() == 0 && context.rJq.rtK.size() == 0)) {
                C30379h.m48443a(context, context.getString(C25738R.string.elu), "", context.getString(C25738R.string.em3), null);
            } else if ((context.rJq.rtF == context.rJn && C5046bo.isNullOrNil(c) && C5046bo.isNullOrNil(c2)) || (context.rJq.rtF == context.rJo && C5046bo.isNullOrNil(c3) && C5046bo.isNullOrNil(c4))) {
                C30379h.m48443a(context, context.getString(C25738R.string.elu), "", context.getString(C25738R.string.em3), null);
            } else {
                context.ctv();
            }
            AppMethodBeat.m2505o(40179);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$12 */
    class C3513612 implements OnClickListener {
        C3513612() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(40183);
            JsapiSnsLabelUI.m57764o(JsapiSnsLabelUI.this);
            AppMethodBeat.m2505o(40183);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$6 */
    class C351386 implements OnChildClickListener {
        C351386() {
        }

        public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            AppMethodBeat.m2504i(40177);
            if (i2 == JsapiSnsLabelUI.this.rJq.getChildrenCount(i) - 1) {
                JsapiSnsLabelUI.this.rtr = i;
                JsapiSnsLabelUI.m57754f(JsapiSnsLabelUI.this);
            } else {
                String str = (String) JsapiSnsLabelUI.this.rJq.getChild(i, i2);
                JsapiSnsLabelUI.this.rJq;
                C22129a.m33745ZF(str);
                if (i == JsapiSnsLabelUI.this.rJn) {
                    JsapiSnsLabelUI.m57745a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.this.rJq.rtH, str, view);
                } else if (i == JsapiSnsLabelUI.this.rJo) {
                    JsapiSnsLabelUI.m57745a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.this.rJq.rtI, str, view);
                }
            }
            AppMethodBeat.m2505o(40177);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI$9 */
    class C351399 implements OnClickListener {
        C351399() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(40180);
            JsapiSnsLabelUI.this.rtp = true;
            C21156a.bJa().mo41640ce(JsapiSnsLabelUI.this.rtw);
            JsapiSnsLabelUI.this.rts = C30379h.m48458b(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(C25738R.string.elt), false, null);
            AppMethodBeat.m2505o(40180);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public JsapiSnsLabelUI() {
        AppMethodBeat.m2504i(40184);
        AppMethodBeat.m2505o(40184);
    }

    static /* synthetic */ int cuW() {
        AppMethodBeat.m2504i(138392);
        int ctw = JsapiSnsLabelUI.ctw();
        AppMethodBeat.m2505o(138392);
        return ctw;
    }

    /* renamed from: h */
    static /* synthetic */ void m57756h(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.m2504i(138396);
        jsapiSnsLabelUI.goBack();
        AppMethodBeat.m2505o(138396);
    }

    /* renamed from: k */
    static /* synthetic */ void m57759k(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.m2504i(138397);
        jsapiSnsLabelUI.ctz();
        AppMethodBeat.m2505o(138397);
    }

    /* renamed from: n */
    static /* synthetic */ void m57763n(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.m2504i(40216);
        jsapiSnsLabelUI.ctv();
        AppMethodBeat.m2505o(40216);
    }

    /* renamed from: o */
    static /* synthetic */ void m57764o(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.m2504i(138398);
        jsapiSnsLabelUI.ctu();
        AppMethodBeat.m2505o(138398);
    }

    public final int getLayoutId() {
        return 2130970767;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(40185);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
            AppMethodBeat.m2505o(40185);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(40185);
        return dispatchKeyEvent;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(40186);
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
        this.rJq = new C22129a(this);
        this.rJq.rJx = false;
        this.rJq.rJw = new C221271();
        Intent intent = getIntent();
        if (intent == null) {
            this.rtm = this.rJl;
            this.rJq.style = 0;
            this.rtj = null;
            this.rtk = null;
        } else {
            if (intent.hasExtra("k_title")) {
                setMMTitle(intent.getStringExtra("k_title"));
            }
            this.rtm = intent.getIntExtra("KLabel_range_index", this.rJl);
            this.rJq.style = intent.getIntExtra("k_sns_label_ui_style", 0);
            this.rtj = intent.getStringExtra("Klabel_name_list");
            this.rtk = intent.getStringExtra("Kother_user_name_list");
            if (!TextUtils.isEmpty(intent.getStringExtra("k_sns_label_ui_title"))) {
                setMMTitle(intent.getStringExtra("k_sns_label_ui_title"));
            }
        }
        this.rJq.rtF = this.rtm;
        if (this.rJq.style == 1) {
            findViewById(2131827784).setBackgroundResource(C25738R.color.f11782h4);
        }
        if (this.rtm == this.rJn) {
            if (!TextUtils.isEmpty(this.rtj)) {
                this.rJq.rtH = C5046bo.m7508P(this.rtj.split(","));
            }
            if (!TextUtils.isEmpty(this.rtk)) {
                this.rJq.rtJ = C5046bo.m7508P(this.rtk.split(","));
            }
        } else if (this.rtm == this.rJo) {
            if (!TextUtils.isEmpty(this.rtj)) {
                this.rJq.rtI = C5046bo.m7508P(this.rtj.split(","));
            }
            if (!TextUtils.isEmpty(this.rtk)) {
                this.rJq.rtK = C5046bo.m7508P(this.rtk.split(","));
            }
        }
        C1720g.m3537RQ();
        this.rtn = ((Boolean) C1720g.m3536RP().mo5239Ry().get(335873, Boolean.TRUE)).booleanValue();
        if (this.rtn) {
            this.rtp = true;
            this.rtq = true;
            if (JsapiSnsLabelUI.ctw() > 0) {
                this.rto = true;
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C7108v(1), 0);
        }
        initView();
        intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("k_select_group");
            boolean booleanExtra = intent.getBooleanExtra("k_show_public", true);
            boolean booleanExtra2 = intent.getBooleanExtra("k_show_private", true);
            boolean booleanExtra3 = intent.getBooleanExtra("k_show_include", true);
            boolean booleanExtra4 = intent.getBooleanExtra("k_show_exclude", true);
            int[] iArr = new int[]{C25738R.string.elx, C25738R.string.elv, C25738R.string.elr, C25738R.string.elk};
            this.rJr.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (booleanExtra) {
                arrayList.add(Integer.valueOf(iArr[0]));
                arrayList2.add(Integer.valueOf(iArr[0]));
                this.rJr.add(this.rJp.get(0));
            }
            if (booleanExtra2) {
                arrayList.add(Integer.valueOf(iArr[1]));
                arrayList2.add(Integer.valueOf(iArr[1]));
                this.rJr.add(this.rJp.get(1));
            }
            if (booleanExtra3) {
                arrayList.add(Integer.valueOf(iArr[2]));
                arrayList2.add(Integer.valueOf(iArr[2]));
                this.rJr.add(this.rJp.get(2));
            }
            if (booleanExtra4) {
                arrayList.add(Integer.valueOf(iArr[3]));
                arrayList2.add(Integer.valueOf(iArr[3]));
                this.rJr.add(this.rJp.get(3));
            }
            if (this.rJr.size() == 0) {
                finish();
                AppMethodBeat.m2505o(40186);
                return;
            }
            this.rJl = this.rJr.indexOf("public");
            this.rJm = this.rJr.indexOf("private");
            this.rJn = this.rJr.indexOf("visible");
            this.rJo = this.rJr.indexOf("invisible");
            if (this.rJq != null) {
                C22129a c22129a = this.rJq;
                List list = this.rJr;
                c22129a.rJv = list;
                c22129a.rJl = list.indexOf("public");
                c22129a.rJm = list.indexOf("private");
                c22129a.rJn = list.indexOf("visible");
                c22129a.rJo = list.indexOf("invisible");
                this.rJq.rJu = arrayList.size();
                this.rJq.rth = JsapiSnsLabelUI.m57752dw(arrayList);
                this.rJq.rtD = JsapiSnsLabelUI.m57752dw(arrayList2);
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.rJq.rtF = this.rJr.indexOf(stringExtra);
                    if (stringExtra.equals("visible")) {
                        if (!TextUtils.isEmpty(this.rtj)) {
                            this.rJq.rtH = C5046bo.m7508P(this.rtj.split(","));
                        }
                        if (!TextUtils.isEmpty(this.rtk)) {
                            this.rJq.rtJ = C5046bo.m7508P(this.rtk.split(","));
                        }
                        this.rtg.expandGroup(this.rJr.indexOf(stringExtra));
                        AppMethodBeat.m2505o(40186);
                        return;
                    } else if (stringExtra.equals("invisible")) {
                        if (!TextUtils.isEmpty(this.rtj)) {
                            this.rJq.rtI = C5046bo.m7508P(this.rtj.split(","));
                        }
                        if (!TextUtils.isEmpty(this.rtk)) {
                            this.rJq.rtK = C5046bo.m7508P(this.rtk.split(","));
                        }
                        this.rtg.expandGroup(this.rJr.indexOf(stringExtra));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(40186);
    }

    /* renamed from: dw */
    private static int[] m57752dw(List<Integer> list) {
        AppMethodBeat.m2504i(40187);
        int[] iArr = new int[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                iArr[i2] = ((Integer) list.get(i2)).intValue();
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(40187);
                return iArr;
            }
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(40188);
        boolean booleanExtra = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
        this.rtg = (AnimatedExpandableListView) findViewById(2131827785);
        this.rti = (ArrayList) C21156a.bJa().bIV();
        this.rJq.rtG = booleanExtra;
        this.rJq.mo37677T(this.rti);
        ctz();
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.f9951l8);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.rtg.addHeaderView(view);
        this.rtg.setAdapter(this.rJq);
        this.rtg.setOnGroupClickListener(new C351325());
        this.rtg.setOnChildClickListener(new C351386());
        setBackBtn(new C351347());
        mo17379a(0, getString(C25738R.string.elm), (OnMenuItemClickListener) new C351358(), C5535b.GREEN);
        AppMethodBeat.m2505o(40188);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(40189);
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
                if (this.rtr == this.rJn) {
                    this.rJq.rtJ.clear();
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        this.rJq.rtJ.addAll(C5046bo.m7508P(stringExtra.split(",")));
                        this.rJq.rtF = this.rtr;
                    }
                } else if (this.rtr == this.rJo) {
                    this.rJq.rtK.clear();
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        this.rJq.rtK.addAll(C5046bo.m7508P(stringExtra.split(",")));
                        this.rJq.rtF = this.rtr;
                    }
                }
                this.rJq.notifyDataSetChanged();
                this.rtg.expandGroup(this.rtr);
                AppMethodBeat.m2505o(40189);
                return;
            }
            intent2 = new Intent();
            intent2.putExtra("Select_Contact", stringExtra);
            C25985d.m41468b(this.mController.ylL, "label", ".ui.ContactLabelEditUI", intent2, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            AppMethodBeat.m2505o(40189);
        } else if (i2 == -1 && i == WearableStatusCodes.DUPLICATE_LISTENER) {
            stringExtra = intent.getStringExtra("Select_Contact");
            C4990ab.m7417i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra));
            if (!C5046bo.isNullOrNil(stringExtra)) {
                intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                C25985d.m41468b((Context) this, "label", ".ui.ContactLabelEditUI", intent2, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            }
            AppMethodBeat.m2505o(40189);
        } else {
            if (i2 == 0 && i == WearableStatusCodes.UNKNOWN_LISTENER && intent != null) {
                stringExtra = intent.getStringExtra("k_sns_label_add_label");
                this.rtt = intent.getStringExtra("k_sns_label_add_label");
                this.rtg.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(40181);
                        JsapiSnsLabelUI.this.rti = (ArrayList) C21156a.bJa().bIV();
                        if (JsapiSnsLabelUI.this.rti == null) {
                            JsapiSnsLabelUI.this.rti = new ArrayList();
                        }
                        int i;
                        if (C5046bo.isNullOrNil(stringExtra)) {
                            i = -1;
                        } else {
                            if (!JsapiSnsLabelUI.this.rti.contains(stringExtra)) {
                                JsapiSnsLabelUI.this.rti.add(stringExtra);
                            }
                            i = JsapiSnsLabelUI.this.rti.indexOf(stringExtra);
                        }
                        JsapiSnsLabelUI.this.rJq.mo37677T(JsapiSnsLabelUI.this.rti);
                        JsapiSnsLabelUI.m57759k(JsapiSnsLabelUI.this);
                        JsapiSnsLabelUI.this.rJq.rtF = JsapiSnsLabelUI.this.rtr;
                        if (!(C5046bo.isNullOrNil(stringExtra) || i == -1)) {
                            if (JsapiSnsLabelUI.this.rtr == JsapiSnsLabelUI.this.rJn) {
                                JsapiSnsLabelUI.this.rJq.rtH.add(stringExtra);
                                JsapiSnsLabelUI.this.rJq.rtJ.clear();
                            } else if (JsapiSnsLabelUI.this.rtr == JsapiSnsLabelUI.this.rJo) {
                                JsapiSnsLabelUI.this.rJq.rtI.add(stringExtra);
                                JsapiSnsLabelUI.this.rJq.rtK.clear();
                            }
                        }
                        JsapiSnsLabelUI.this.rJq.notifyDataSetChanged();
                        JsapiSnsLabelUI.this.rtg.expandGroup(JsapiSnsLabelUI.this.rtr);
                        JsapiSnsLabelUI.this.rtt = null;
                        AppMethodBeat.m2505o(40181);
                    }
                }, 600);
            }
            AppMethodBeat.m2505o(40189);
        }
    }

    private boolean ctt() {
        AppMethodBeat.m2504i(40190);
        boolean z = false;
        int i = this.rJq.rtF;
        if (this.rJq.rtF != this.rtm) {
            if ((i == this.rJn && (this.rJq.rtH.size() != 0 || this.rJq.rtJ.size() != 0)) || (i == this.rJo && (this.rJq.rtI.size() != 0 || this.rJq.rtK.size() != 0))) {
                z = true;
            } else if (i == this.rJm || i == this.rJl) {
                z = true;
            }
        } else if (!((i != this.rJn || this.rJq.rtH.size() == 0 || (C5046bo.m7536c(this.rJq.rtH, ",").equals(this.rtj) && C5046bo.m7536c(this.rJq.rtJ, ",").equals(this.rtk))) && (i != this.rJo || this.rJq.rtI.size() == 0 || (C5046bo.m7536c(this.rJq.rtI, ",").equals(this.rtj) && C5046bo.m7536c(this.rJq.rtK, ",").equals(this.rtk))))) {
            z = true;
        }
        AppMethodBeat.m2505o(40190);
        return z;
    }

    private void goBack() {
        AppMethodBeat.m2504i(40191);
        if (ctt()) {
            C30379h.m48453a((Context) this, true, getString(C25738R.string.elq), "", getString(C25738R.string.elp), getString(C25738R.string.elo), new C3513111(), new C3513612());
            AppMethodBeat.m2505o(40191);
            return;
        }
        ctu();
        AppMethodBeat.m2505o(40191);
    }

    private void ctu() {
        AppMethodBeat.m2504i(40192);
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.rtm);
        m57746ar(intent);
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(40192);
    }

    /* Access modifiers changed, original: final */
    public final void ctv() {
        AppMethodBeat.m2504i(40193);
        Intent intent = new Intent();
        if (this.rJq.rtF == this.rJn) {
            this.rtj = C5046bo.m7536c(this.rJq.rtH, ",");
            this.rtk = C5046bo.m7536c(this.rJq.rtJ, ",");
            m57746ar(intent);
        } else if (this.rJq.rtF == this.rJo) {
            this.rtj = C5046bo.m7536c(this.rJq.rtI, ",");
            this.rtk = C5046bo.m7536c(this.rJq.rtK, ",");
            m57746ar(intent);
        }
        intent.putExtra("k_select_group", m57736Er(this.rJq.rtF));
        intent.putExtra("k_select_index", this.rJq.rtF);
        intent.putExtra("Ktag_range_index", this.rJq.rtF);
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(40193);
    }

    /* renamed from: ar */
    private void m57746ar(Intent intent) {
        AppMethodBeat.m2504i(40194);
        ctA();
        intent.putExtra("Klabel_name_list", JsapiSnsLabelUI.m57738ZN(this.rtj));
        intent.putExtra("Kother_user_name_list", JsapiSnsLabelUI.m57737ZM(this.rtk));
        intent.putExtra("k_select_group", m57736Er(this.rJq.rtF));
        AppMethodBeat.m2505o(40194);
    }

    /* renamed from: Er */
    private String m57736Er(int i) {
        AppMethodBeat.m2504i(138390);
        String str;
        if (i >= this.rJr.size() || i < 0) {
            str = "";
            AppMethodBeat.m2505o(138390);
            return str;
        }
        str = (String) this.rJr.get(i);
        AppMethodBeat.m2505o(138390);
        return str;
    }

    /* renamed from: ZM */
    private static String m57737ZM(String str) {
        AppMethodBeat.m2504i(40195);
        List<String> hT = C5046bo.m7569hT(str, ",");
        JSONArray jSONArray = new JSONArray();
        if (hT != null) {
            for (String str2 : hT) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("username", str2);
                    jSONObject.put("displayName", JsapiSnsLabelUI.m57762mJ(str2));
                    jSONObject.put("avatar", JsapiSnsLabelUI.m57739ZO(str2));
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsLabelUI", e, "", new Object[0]);
                }
            }
        }
        String str22 = jSONArray.toString();
        AppMethodBeat.m2505o(40195);
        return str22;
    }

    /* renamed from: ZN */
    private static String m57738ZN(String str) {
        AppMethodBeat.m2504i(40196);
        List<String> hT = C5046bo.m7569hT(str, ",");
        JSONObject jSONObject = new JSONObject();
        C24783b bJa = C21156a.bJa();
        for (String str2 : hT) {
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put(str2, jSONArray);
                hT = bJa.mo41635PH(bJa.mo41632PE(str2));
                if (hT != null) {
                    for (String str22 : hT) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("username", str22);
                        jSONObject2.put("displayName", JsapiSnsLabelUI.m57762mJ(str22));
                        jSONObject2.put("avatar", JsapiSnsLabelUI.m57739ZO(str22));
                        jSONArray.put(jSONObject2);
                    }
                }
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsLabelUI", e, "", new Object[0]);
            }
        }
        String str222 = jSONObject.toString();
        AppMethodBeat.m2505o(40196);
        return str222;
    }

    /* renamed from: mJ */
    private static String m57762mJ(String str) {
        AppMethodBeat.m2504i(40197);
        String mJ = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(str);
        AppMethodBeat.m2505o(40197);
        return mJ;
    }

    /* renamed from: ZO */
    private static String m57739ZO(String str) {
        AppMethodBeat.m2504i(40198);
        C17880h qo = C17884o.act().mo33392qo(str);
        String acl;
        if (qo != null) {
            acl = qo.acl();
            AppMethodBeat.m2505o(40198);
            return acl;
        }
        acl = "";
        AppMethodBeat.m2505o(40198);
        return acl;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(40199);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(292, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) C42558b.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(638, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(290, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(40199);
    }

    public void onResume() {
        AppMethodBeat.m2504i(40200);
        if (!(this.rJq == null || this.rtt != null || this.rtg == null)) {
            this.rtg.postDelayed(new C292292(), 600);
        }
        super.onResume();
        AppMethodBeat.m2505o(40200);
    }

    /* JADX WARNING: Missing block: B:30:0x00f3, code skipped:
            if (r0 == null) goto L_0x00f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40201);
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
                            this.rJq.rtF = this.rtr;
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
                    AppMethodBeat.m2505o(40201);
                    return;
                case C42558b.CTRL_INDEX /*635*/:
                    if (i == 0 && i2 == 0) {
                        m57751ds(this.rty);
                        AppMethodBeat.m2505o(40201);
                        return;
                    }
                    cty();
                    C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
                    AppMethodBeat.m2505o(40201);
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
                        this.rtg.postDelayed(new C221283(), 600);
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(335873, Boolean.FALSE);
                        AppMethodBeat.m2505o(40201);
                        return;
                    }
                    cty();
                    C4990ab.m7416i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
                    AppMethodBeat.m2505o(40201);
                    return;
            }
            AppMethodBeat.m2505o(40201);
            return;
        }
        AppMethodBeat.m2505o(40201);
    }

    private static int ctw() {
        AppMethodBeat.m2504i(40202);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(335874, Integer.valueOf(0))).intValue();
        AppMethodBeat.m2505o(40202);
        return intValue;
    }

    private static void ctx() {
        AppMethodBeat.m2504i(40203);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(335874, Integer.valueOf(0))).intValue() + 1;
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(335874, Integer.valueOf(intValue));
        AppMethodBeat.m2505o(40203);
    }

    private void cty() {
        AppMethodBeat.m2504i(40204);
        C7060h.pYm.mo8381e(11455, "", "", Integer.valueOf(this.rtu), Integer.valueOf(0));
        JsapiSnsLabelUI.ctx();
        this.rtw = null;
        this.rtq = false;
        this.rtp = false;
        if (this.rts != null && this.rts.isShowing()) {
            this.rts.dismiss();
        }
        if (this.rto) {
            this.rto = false;
            AppMethodBeat.m2505o(40204);
            return;
        }
        int i = C25738R.string.em2;
        if (JsapiSnsLabelUI.ctw() > 1) {
            i = C25738R.string.em1;
        }
        C30379h.m48431a((Context) this, i, (int) C25738R.string.f9187s6, new C292304());
        AppMethodBeat.m2505o(40204);
    }

    /* renamed from: ds */
    private void m57751ds(List<String[]> list) {
        AppMethodBeat.m2504i(40205);
        if (this.rtw == null || this.rtw.size() == 0) {
            AppMethodBeat.m2505o(40205);
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
        AppMethodBeat.m2505o(40205);
    }

    private void ctz() {
        AppMethodBeat.m2504i(40206);
        if (this.rti == null || this.rti.isEmpty()) {
            if (this.rJq.rtH != null) {
                this.rJq.rtH.clear();
            }
            if (this.rJq.rtI != null) {
                this.rJq.rtI.clear();
            }
            AppMethodBeat.m2505o(40206);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it;
        String str;
        if (this.rJr.size() <= 0 || !"visible".equals(m57736Er(this.rtm)) || this.rJq.rtH == null) {
            if (this.rJr.size() > 0 && "invisible".equals(m57736Er(this.rtm))) {
                it = this.rJq.rtI.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    if (!this.rti.contains(str)) {
                        arrayList.add(str);
                    }
                }
                this.rJq.rtI.removeAll(arrayList);
            }
            AppMethodBeat.m2505o(40206);
            return;
        }
        it = this.rJq.rtH.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (!this.rti.contains(str)) {
                arrayList.add(str);
            }
        }
        this.rJq.rtH.removeAll(arrayList);
        AppMethodBeat.m2505o(40206);
    }

    private void ctA() {
        AppMethodBeat.m2504i(40207);
        if (this.rti == null || this.rti.isEmpty()) {
            this.rtj = "";
            AppMethodBeat.m2505o(40207);
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
        AppMethodBeat.m2505o(40207);
    }

    /* renamed from: a */
    static /* synthetic */ void m57744a(JsapiSnsLabelUI jsapiSnsLabelUI, int i, int i2) {
        AppMethodBeat.m2504i(40208);
        if (jsapiSnsLabelUI.rJq != null) {
            Object child = jsapiSnsLabelUI.rJq.getChild(i, i2);
            if (child != null && (child instanceof String)) {
                String str = (String) child;
                String PE = C21156a.bJa().mo41632PE(str);
                Intent intent = new Intent();
                intent.putExtra("label_id", PE);
                intent.putExtra("label_name", str);
                intent.putExtra("is_show_delete", false);
                C25985d.m41468b(jsapiSnsLabelUI.mController.ylL, "label", ".ui.ContactLabelEditUI", intent, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            }
        }
        AppMethodBeat.m2505o(40208);
    }

    /* renamed from: c */
    static /* synthetic */ void m57749c(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.m2504i(138393);
        C30379h.m48443a((Context) jsapiSnsLabelUI, jsapiSnsLabelUI.getString(C25738R.string.em4), null, jsapiSnsLabelUI.getString(C25738R.string.em3), new C351399());
        AppMethodBeat.m2505o(138393);
    }

    /* renamed from: f */
    static /* synthetic */ void m57754f(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.m2504i(138394);
        Intent intent = new Intent();
        intent.putExtra("titile", jsapiSnsLabelUI.getString(C25738R.string.f8782eu));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_attr", C15830s.m24190C(C15830s.znE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        if (jsapiSnsLabelUI.rtr == jsapiSnsLabelUI.rJn) {
            if (jsapiSnsLabelUI.rJq.rtJ.size() > 0) {
                intent.putExtra("already_select_contact", C5046bo.m7536c(jsapiSnsLabelUI.rJq.rtJ, ","));
            }
        } else if (jsapiSnsLabelUI.rtr == jsapiSnsLabelUI.rJo && jsapiSnsLabelUI.rJq.rtK.size() > 0) {
            intent.putExtra("already_select_contact", C5046bo.m7536c(jsapiSnsLabelUI.rJq.rtK, ","));
        }
        intent.putExtra("KBlockOpenImFav", true);
        C25985d.m41466b((Context) jsapiSnsLabelUI, ".ui.contact.SelectContactUI", intent, (int) WearableStatusCodes.DATA_ITEM_TOO_LARGE);
        AppMethodBeat.m2505o(138394);
    }

    /* renamed from: a */
    static /* synthetic */ void m57745a(JsapiSnsLabelUI jsapiSnsLabelUI, int i, ArrayList arrayList, String str, View view) {
        AppMethodBeat.m2504i(138395);
        if (jsapiSnsLabelUI.rJq == null || jsapiSnsLabelUI.rJq.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.checkbox_unselected);
                AppMethodBeat.m2505o(138395);
                return;
            }
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.checkbox_selected);
                AppMethodBeat.m2505o(138395);
                return;
            }
            ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.checkbox_selected_red);
            AppMethodBeat.m2505o(138395);
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i == 1) {
                ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.sight_list_checkbox_unselected);
                AppMethodBeat.m2505o(138395);
                return;
            }
            ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.sight_list_checkbox_unselected_red);
            AppMethodBeat.m2505o(138395);
        } else {
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.sight_list_checkbox_selected);
                AppMethodBeat.m2505o(138395);
                return;
            }
            ((ImageView) view.findViewById(2131827787)).setImageResource(C1318a.sight_list_checkbox_selected_red);
            AppMethodBeat.m2505o(138395);
        }
    }
}
