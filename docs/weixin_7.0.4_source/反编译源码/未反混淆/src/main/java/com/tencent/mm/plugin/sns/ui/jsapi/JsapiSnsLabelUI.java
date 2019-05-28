package com.tencent.mm.plugin.sns.ui.jsapi;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsapiSnsLabelUI extends MMActivity implements f {
    public static int[] rth = new int[]{R.string.elx, R.string.elv, R.string.elr, R.string.elk};
    public int rJl = 0;
    public int rJm = 1;
    public int rJn = 2;
    public int rJo = 3;
    private List<String> rJp = Arrays.asList("public,private,visible,invisible".split(","));
    a rJq;
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
    private p rts;
    private String rtt;
    private int rtu;
    private ArrayList<String> rtv;
    private ArrayList<String> rtw;
    private ArrayList<Long> rtx;
    private ArrayList<String[]> rty;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public JsapiSnsLabelUI() {
        AppMethodBeat.i(40184);
        AppMethodBeat.o(40184);
    }

    static /* synthetic */ int cuW() {
        AppMethodBeat.i(138392);
        int ctw = ctw();
        AppMethodBeat.o(138392);
        return ctw;
    }

    static /* synthetic */ void h(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(138396);
        jsapiSnsLabelUI.goBack();
        AppMethodBeat.o(138396);
    }

    static /* synthetic */ void k(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(138397);
        jsapiSnsLabelUI.ctz();
        AppMethodBeat.o(138397);
    }

    static /* synthetic */ void n(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(40216);
        jsapiSnsLabelUI.ctv();
        AppMethodBeat.o(40216);
    }

    static /* synthetic */ void o(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(138398);
        jsapiSnsLabelUI.ctu();
        AppMethodBeat.o(138398);
    }

    public final int getLayoutId() {
        return R.layout.ave;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(40185);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
            AppMethodBeat.o(40185);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(40185);
        return dispatchKeyEvent;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(40186);
        super.onCreate(bundle);
        setMMTitle((int) R.string.eph);
        g.RQ();
        g.RO().eJo.a(292, (f) this);
        g.RQ();
        g.RO().eJo.a((int) b.CTRL_INDEX, (f) this);
        g.RQ();
        g.RO().eJo.a(638, (f) this);
        g.RQ();
        g.RO().eJo.a(290, (f) this);
        this.rJq = new a(this);
        this.rJq.rJx = false;
        this.rJq.rJw = new a.b() {
            public final void a(c cVar) {
                AppMethodBeat.i(40172);
                JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, cVar.rtQ, cVar.rtR);
                AppMethodBeat.o(40172);
            }
        };
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
            findViewById(R.id.ejp).setBackgroundResource(R.color.h4);
        }
        if (this.rtm == this.rJn) {
            if (!TextUtils.isEmpty(this.rtj)) {
                this.rJq.rtH = bo.P(this.rtj.split(","));
            }
            if (!TextUtils.isEmpty(this.rtk)) {
                this.rJq.rtJ = bo.P(this.rtk.split(","));
            }
        } else if (this.rtm == this.rJo) {
            if (!TextUtils.isEmpty(this.rtj)) {
                this.rJq.rtI = bo.P(this.rtj.split(","));
            }
            if (!TextUtils.isEmpty(this.rtk)) {
                this.rJq.rtK = bo.P(this.rtk.split(","));
            }
        }
        g.RQ();
        this.rtn = ((Boolean) g.RP().Ry().get(335873, Boolean.TRUE)).booleanValue();
        if (this.rtn) {
            this.rtp = true;
            this.rtq = true;
            if (ctw() > 0) {
                this.rto = true;
            }
            g.RQ();
            g.RO().eJo.a(new v(1), 0);
        }
        initView();
        intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("k_select_group");
            boolean booleanExtra = intent.getBooleanExtra("k_show_public", true);
            boolean booleanExtra2 = intent.getBooleanExtra("k_show_private", true);
            boolean booleanExtra3 = intent.getBooleanExtra("k_show_include", true);
            boolean booleanExtra4 = intent.getBooleanExtra("k_show_exclude", true);
            int[] iArr = new int[]{R.string.elx, R.string.elv, R.string.elr, R.string.elk};
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
                AppMethodBeat.o(40186);
                return;
            }
            this.rJl = this.rJr.indexOf("public");
            this.rJm = this.rJr.indexOf("private");
            this.rJn = this.rJr.indexOf("visible");
            this.rJo = this.rJr.indexOf("invisible");
            if (this.rJq != null) {
                a aVar = this.rJq;
                List list = this.rJr;
                aVar.rJv = list;
                aVar.rJl = list.indexOf("public");
                aVar.rJm = list.indexOf("private");
                aVar.rJn = list.indexOf("visible");
                aVar.rJo = list.indexOf("invisible");
                this.rJq.rJu = arrayList.size();
                this.rJq.rth = dw(arrayList);
                this.rJq.rtD = dw(arrayList2);
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.rJq.rtF = this.rJr.indexOf(stringExtra);
                    if (stringExtra.equals("visible")) {
                        if (!TextUtils.isEmpty(this.rtj)) {
                            this.rJq.rtH = bo.P(this.rtj.split(","));
                        }
                        if (!TextUtils.isEmpty(this.rtk)) {
                            this.rJq.rtJ = bo.P(this.rtk.split(","));
                        }
                        this.rtg.expandGroup(this.rJr.indexOf(stringExtra));
                        AppMethodBeat.o(40186);
                        return;
                    } else if (stringExtra.equals("invisible")) {
                        if (!TextUtils.isEmpty(this.rtj)) {
                            this.rJq.rtI = bo.P(this.rtj.split(","));
                        }
                        if (!TextUtils.isEmpty(this.rtk)) {
                            this.rJq.rtK = bo.P(this.rtk.split(","));
                        }
                        this.rtg.expandGroup(this.rJr.indexOf(stringExtra));
                    }
                }
            }
        }
        AppMethodBeat.o(40186);
    }

    private static int[] dw(List<Integer> list) {
        AppMethodBeat.i(40187);
        int[] iArr = new int[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                iArr[i2] = ((Integer) list.get(i2)).intValue();
                i = i2 + 1;
            } else {
                AppMethodBeat.o(40187);
                return iArr;
            }
        }
    }

    public final void initView() {
        AppMethodBeat.i(40188);
        boolean booleanExtra = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
        this.rtg = (AnimatedExpandableListView) findViewById(R.id.ejq);
        this.rti = (ArrayList) a.bJa().bIV();
        this.rJq.rtG = booleanExtra;
        this.rJq.T(this.rti);
        ctz();
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(R.dimen.l8);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.rtg.addHeaderView(view);
        this.rtg.setAdapter(this.rJq);
        this.rtg.setOnGroupClickListener(new OnGroupClickListener() {
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, final int i, long j) {
                AppMethodBeat.i(40176);
                int i2 = JsapiSnsLabelUI.this.rJq.rtF;
                ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", Integer.valueOf(i2), Integer.valueOf(i));
                if (!JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("visible") && !JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i).equals("invisible")) {
                    if (i2 >= 0 && (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i2).equals("visible") || JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i2).equals("invisible"))) {
                        JsapiSnsLabelUI.this.rtg.Qj(i2);
                    }
                    JsapiSnsLabelUI.this.rJq.rtF = i;
                    AppMethodBeat.o(40176);
                    return false;
                } else if (JsapiSnsLabelUI.this.rtw != null && JsapiSnsLabelUI.this.rtw.size() != 0 && JsapiSnsLabelUI.cuW() == 0) {
                    JsapiSnsLabelUI.this.rtr = i;
                    JsapiSnsLabelUI.c(JsapiSnsLabelUI.this);
                    ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
                    AppMethodBeat.o(40176);
                    return true;
                } else if (JsapiSnsLabelUI.this.rtq) {
                    JsapiSnsLabelUI.this.rto = true;
                    JsapiSnsLabelUI.this.rtr = i;
                    JsapiSnsLabelUI.this.rts = h.b(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(R.string.elt), false, null);
                    ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
                    AppMethodBeat.o(40176);
                    return true;
                } else if (JsapiSnsLabelUI.this.rJq.rtE == null || JsapiSnsLabelUI.this.rJq.rtE.size() == 0) {
                    JsapiSnsLabelUI.this.rtr = i;
                    JsapiSnsLabelUI.f(JsapiSnsLabelUI.this);
                    ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
                    AppMethodBeat.o(40176);
                    return true;
                } else {
                    if (i2 != i) {
                        if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i2).equals("visible")) {
                            JsapiSnsLabelUI.this.rtg.collapseGroup(i2);
                            JsapiSnsLabelUI.this.rJq.rtH.clear();
                            JsapiSnsLabelUI.this.rJq.rtJ.clear();
                        } else if (JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, i2).equals("invisible")) {
                            JsapiSnsLabelUI.this.rtg.collapseGroup(i2);
                            JsapiSnsLabelUI.this.rJq.rtI.clear();
                            JsapiSnsLabelUI.this.rJq.rtK.clear();
                        }
                        JsapiSnsLabelUI.this.rtg.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(40175);
                                JsapiSnsLabelUI.this.rtg.Qi(i);
                                AppMethodBeat.o(40175);
                            }
                        });
                    } else if (JsapiSnsLabelUI.this.rtg.isGroupExpanded(i)) {
                        JsapiSnsLabelUI.this.rtg.Qj(i);
                    } else {
                        JsapiSnsLabelUI.this.rtg.Qi(i);
                    }
                    JsapiSnsLabelUI.this.rJq.rtF = i;
                    AppMethodBeat.o(40176);
                    return true;
                }
            }
        });
        this.rtg.setOnChildClickListener(new OnChildClickListener() {
            public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
                AppMethodBeat.i(40177);
                if (i2 == JsapiSnsLabelUI.this.rJq.getChildrenCount(i) - 1) {
                    JsapiSnsLabelUI.this.rtr = i;
                    JsapiSnsLabelUI.f(JsapiSnsLabelUI.this);
                } else {
                    String str = (String) JsapiSnsLabelUI.this.rJq.getChild(i, i2);
                    JsapiSnsLabelUI.this.rJq;
                    a.ZF(str);
                    if (i == JsapiSnsLabelUI.this.rJn) {
                        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 1, JsapiSnsLabelUI.this.rJq.rtH, str, view);
                    } else if (i == JsapiSnsLabelUI.this.rJo) {
                        JsapiSnsLabelUI.a(JsapiSnsLabelUI.this, 2, JsapiSnsLabelUI.this.rJq.rtI, str, view);
                    }
                }
                AppMethodBeat.o(40177);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40178);
                JsapiSnsLabelUI.h(JsapiSnsLabelUI.this);
                AppMethodBeat.o(40178);
                return true;
            }
        });
        a(0, getString(R.string.elm), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40179);
                Context context = JsapiSnsLabelUI.this;
                String c = bo.c(context.rJq.rtH, ",");
                String c2 = bo.c(context.rJq.rtJ, ",");
                String c3 = bo.c(context.rJq.rtI, ",");
                String c4 = bo.c(context.rJq.rtK, ",");
                if ((context.rJq.rtF == context.rJn && context.rJq.rtH.size() == 0 && context.rJq.rtJ.size() == 0) || (context.rJq.rtF == context.rJo && context.rJq.rtI.size() == 0 && context.rJq.rtK.size() == 0)) {
                    h.a(context, context.getString(R.string.elu), "", context.getString(R.string.em3), null);
                } else if ((context.rJq.rtF == context.rJn && bo.isNullOrNil(c) && bo.isNullOrNil(c2)) || (context.rJq.rtF == context.rJo && bo.isNullOrNil(c3) && bo.isNullOrNil(c4))) {
                    h.a(context, context.getString(R.string.elu), "", context.getString(R.string.em3), null);
                } else {
                    context.ctv();
                }
                AppMethodBeat.o(40179);
                return true;
            }
        }, q.b.GREEN);
        AppMethodBeat.o(40188);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(40189);
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        Intent intent2;
        if (i2 == -1 && i == WearableStatusCodes.DATA_ITEM_TOO_LARGE) {
            ab.i("MicroMsg.SnsLabelUI", "the Activity completed");
            stringExtra = intent.getStringExtra("Select_Contacts_To_Create_New_Label");
            if (bo.isNullOrNil(stringExtra)) {
                stringExtra = intent.getStringExtra("Select_Contact");
                this.rtk = new String(stringExtra);
                ab.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra));
                if (this.rtr == this.rJn) {
                    this.rJq.rtJ.clear();
                    if (!bo.isNullOrNil(stringExtra)) {
                        this.rJq.rtJ.addAll(bo.P(stringExtra.split(",")));
                        this.rJq.rtF = this.rtr;
                    }
                } else if (this.rtr == this.rJo) {
                    this.rJq.rtK.clear();
                    if (!bo.isNullOrNil(stringExtra)) {
                        this.rJq.rtK.addAll(bo.P(stringExtra.split(",")));
                        this.rJq.rtF = this.rtr;
                    }
                }
                this.rJq.notifyDataSetChanged();
                this.rtg.expandGroup(this.rtr);
                AppMethodBeat.o(40189);
                return;
            }
            intent2 = new Intent();
            intent2.putExtra("Select_Contact", stringExtra);
            d.b(this.mController.ylL, "label", ".ui.ContactLabelEditUI", intent2, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            AppMethodBeat.o(40189);
        } else if (i2 == -1 && i == WearableStatusCodes.DUPLICATE_LISTENER) {
            stringExtra = intent.getStringExtra("Select_Contact");
            ab.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra));
            if (!bo.isNullOrNil(stringExtra)) {
                intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                d.b((Context) this, "label", ".ui.ContactLabelEditUI", intent2, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            }
            AppMethodBeat.o(40189);
        } else {
            if (i2 == 0 && i == WearableStatusCodes.UNKNOWN_LISTENER && intent != null) {
                stringExtra = intent.getStringExtra("k_sns_label_add_label");
                this.rtt = intent.getStringExtra("k_sns_label_add_label");
                this.rtg.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(40181);
                        JsapiSnsLabelUI.this.rti = (ArrayList) a.bJa().bIV();
                        if (JsapiSnsLabelUI.this.rti == null) {
                            JsapiSnsLabelUI.this.rti = new ArrayList();
                        }
                        int i;
                        if (bo.isNullOrNil(stringExtra)) {
                            i = -1;
                        } else {
                            if (!JsapiSnsLabelUI.this.rti.contains(stringExtra)) {
                                JsapiSnsLabelUI.this.rti.add(stringExtra);
                            }
                            i = JsapiSnsLabelUI.this.rti.indexOf(stringExtra);
                        }
                        JsapiSnsLabelUI.this.rJq.T(JsapiSnsLabelUI.this.rti);
                        JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
                        JsapiSnsLabelUI.this.rJq.rtF = JsapiSnsLabelUI.this.rtr;
                        if (!(bo.isNullOrNil(stringExtra) || i == -1)) {
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
                        AppMethodBeat.o(40181);
                    }
                }, 600);
            }
            AppMethodBeat.o(40189);
        }
    }

    private boolean ctt() {
        AppMethodBeat.i(40190);
        boolean z = false;
        int i = this.rJq.rtF;
        if (this.rJq.rtF != this.rtm) {
            if ((i == this.rJn && (this.rJq.rtH.size() != 0 || this.rJq.rtJ.size() != 0)) || (i == this.rJo && (this.rJq.rtI.size() != 0 || this.rJq.rtK.size() != 0))) {
                z = true;
            } else if (i == this.rJm || i == this.rJl) {
                z = true;
            }
        } else if (!((i != this.rJn || this.rJq.rtH.size() == 0 || (bo.c(this.rJq.rtH, ",").equals(this.rtj) && bo.c(this.rJq.rtJ, ",").equals(this.rtk))) && (i != this.rJo || this.rJq.rtI.size() == 0 || (bo.c(this.rJq.rtI, ",").equals(this.rtj) && bo.c(this.rJq.rtK, ",").equals(this.rtk))))) {
            z = true;
        }
        AppMethodBeat.o(40190);
        return z;
    }

    private void goBack() {
        AppMethodBeat.i(40191);
        if (ctt()) {
            h.a((Context) this, true, getString(R.string.elq), "", getString(R.string.elp), getString(R.string.elo), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(40182);
                    JsapiSnsLabelUI.n(JsapiSnsLabelUI.this);
                    AppMethodBeat.o(40182);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(40183);
                    JsapiSnsLabelUI.o(JsapiSnsLabelUI.this);
                    AppMethodBeat.o(40183);
                }
            });
            AppMethodBeat.o(40191);
            return;
        }
        ctu();
        AppMethodBeat.o(40191);
    }

    private void ctu() {
        AppMethodBeat.i(40192);
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.rtm);
        ar(intent);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(40192);
    }

    /* Access modifiers changed, original: final */
    public final void ctv() {
        AppMethodBeat.i(40193);
        Intent intent = new Intent();
        if (this.rJq.rtF == this.rJn) {
            this.rtj = bo.c(this.rJq.rtH, ",");
            this.rtk = bo.c(this.rJq.rtJ, ",");
            ar(intent);
        } else if (this.rJq.rtF == this.rJo) {
            this.rtj = bo.c(this.rJq.rtI, ",");
            this.rtk = bo.c(this.rJq.rtK, ",");
            ar(intent);
        }
        intent.putExtra("k_select_group", Er(this.rJq.rtF));
        intent.putExtra("k_select_index", this.rJq.rtF);
        intent.putExtra("Ktag_range_index", this.rJq.rtF);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(40193);
    }

    private void ar(Intent intent) {
        AppMethodBeat.i(40194);
        ctA();
        intent.putExtra("Klabel_name_list", ZN(this.rtj));
        intent.putExtra("Kother_user_name_list", ZM(this.rtk));
        intent.putExtra("k_select_group", Er(this.rJq.rtF));
        AppMethodBeat.o(40194);
    }

    private String Er(int i) {
        AppMethodBeat.i(138390);
        String str;
        if (i >= this.rJr.size() || i < 0) {
            str = "";
            AppMethodBeat.o(138390);
            return str;
        }
        str = (String) this.rJr.get(i);
        AppMethodBeat.o(138390);
        return str;
    }

    private static String ZM(String str) {
        AppMethodBeat.i(40195);
        List<String> hT = bo.hT(str, ",");
        JSONArray jSONArray = new JSONArray();
        if (hT != null) {
            for (String str2 : hT) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("username", str2);
                    jSONObject.put("displayName", mJ(str2));
                    jSONObject.put("avatar", ZO(str2));
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.SnsLabelUI", e, "", new Object[0]);
                }
            }
        }
        String str22 = jSONArray.toString();
        AppMethodBeat.o(40195);
        return str22;
    }

    private static String ZN(String str) {
        AppMethodBeat.i(40196);
        List<String> hT = bo.hT(str, ",");
        JSONObject jSONObject = new JSONObject();
        com.tencent.mm.plugin.label.a.b bJa = a.bJa();
        for (String str2 : hT) {
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put(str2, jSONArray);
                hT = bJa.PH(bJa.PE(str2));
                if (hT != null) {
                    for (String str22 : hT) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("username", str22);
                        jSONObject2.put("displayName", mJ(str22));
                        jSONObject2.put("avatar", ZO(str22));
                        jSONArray.put(jSONObject2);
                    }
                }
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.SnsLabelUI", e, "", new Object[0]);
            }
        }
        String str222 = jSONObject.toString();
        AppMethodBeat.o(40196);
        return str222;
    }

    private static String mJ(String str) {
        AppMethodBeat.i(40197);
        String mJ = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(str);
        AppMethodBeat.o(40197);
        return mJ;
    }

    private static String ZO(String str) {
        AppMethodBeat.i(40198);
        com.tencent.mm.ah.h qo = o.act().qo(str);
        String acl;
        if (qo != null) {
            acl = qo.acl();
            AppMethodBeat.o(40198);
            return acl;
        }
        acl = "";
        AppMethodBeat.o(40198);
        return acl;
    }

    public void onDestroy() {
        AppMethodBeat.i(40199);
        g.RQ();
        g.RO().eJo.b(292, (f) this);
        g.RQ();
        g.RO().eJo.b((int) b.CTRL_INDEX, (f) this);
        g.RQ();
        g.RO().eJo.b(638, (f) this);
        g.RQ();
        g.RO().eJo.b(290, (f) this);
        super.onDestroy();
        AppMethodBeat.o(40199);
    }

    public void onResume() {
        AppMethodBeat.i(40200);
        if (!(this.rJq == null || this.rtt != null || this.rtg == null)) {
            this.rtg.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(40173);
                    a.bJa().ahw();
                    JsapiSnsLabelUI.this.rti = (ArrayList) a.bJa().bIV();
                    JsapiSnsLabelUI.this.rJq.T(JsapiSnsLabelUI.this.rti);
                    JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
                    if ((JsapiSnsLabelUI.this.rti == null || JsapiSnsLabelUI.this.rti.size() == 0) && !((JsapiSnsLabelUI.this.rtk != null && JsapiSnsLabelUI.this.rtk.length() != 0) || JsapiSnsLabelUI.this.rJq.rtF == JsapiSnsLabelUI.this.rJl || JsapiSnsLabelUI.this.rJq.rtF == JsapiSnsLabelUI.this.rJm)) {
                        JsapiSnsLabelUI.this.rJq.rtF = JsapiSnsLabelUI.this.rJl;
                    }
                    JsapiSnsLabelUI.this.rJq.notifyDataSetChanged();
                    JsapiSnsLabelUI.this.rtt = null;
                    AppMethodBeat.o(40173);
                }
            }, 600);
        }
        super.onResume();
        AppMethodBeat.o(40200);
    }

    /* JADX WARNING: Missing block: B:30:0x00f3, code skipped:
            if (r0 == null) goto L_0x00f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40201);
        ab.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.rtp) {
            int count;
            String str2;
            switch (mVar.getType()) {
                case 290:
                    if (!(i == 0 && i2 == 0)) {
                        ab.i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
                        break;
                    }
                case 292:
                    if (i == 0 && i2 == 0) {
                        Cursor cursor = af.cnL().getCursor();
                        this.rtu = cursor.getCount();
                        if (this.rtu > 0) {
                            Object str22;
                            cursor.moveToFirst();
                            t tVar = new t();
                            count = cursor.getCount();
                            this.rtw = new ArrayList(count);
                            this.rtv = new ArrayList(count);
                            this.rty = new ArrayList(count);
                            this.rtx = new ArrayList(count);
                            while (!cursor.isAfterLast()) {
                                tVar.d(cursor);
                                if (tVar.field_memberList == null || tVar.field_memberList.length() == 0) {
                                    ab.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
                                } else {
                                    this.rty.add(tVar.field_memberList.split(","));
                                    String str3 = tVar.field_tagName;
                                    ArrayList arrayList = this.rtw;
                                    List bIX = a.bJa().bIX();
                                    if (bIX == null) {
                                        str22 = str3;
                                    } else if (bIX.contains(str3)) {
                                        str22 = String.format(getString(R.string.eln), new Object[]{str3});
                                    } else {
                                        str22 = str3;
                                    }
                                    arrayList.add(str22);
                                    this.rtv.add(str3);
                                    this.rtx.add(Long.valueOf(tVar.field_tagId));
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
                            this.rtg.Qi(this.rtr);
                            g.RQ();
                            g.RP().Ry().set(335873, Boolean.FALSE);
                        }
                        cursor.close();
                        if (this.rto) {
                            this.rtp = true;
                            a.bJa().ce(this.rtw);
                        } else {
                            this.rtp = false;
                        }
                    } else {
                        cty();
                        ab.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
                    }
                    this.rtq = false;
                    AppMethodBeat.o(40201);
                    return;
                case b.CTRL_INDEX /*635*/:
                    if (i == 0 && i2 == 0) {
                        ds(this.rty);
                        AppMethodBeat.o(40201);
                        return;
                    }
                    cty();
                    ab.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
                    AppMethodBeat.o(40201);
                    return;
                case 638:
                    if (i == 0 && i2 == 0) {
                        Iterator it = this.rtv.iterator();
                        Iterator it2 = this.rtx.iterator();
                        while (it.hasNext()) {
                            long longValue = ((Long) it2.next()).longValue();
                            str22 = (String) it.next();
                            if (longValue != 0) {
                                g.RQ();
                                g.RO().eJo.a(new x(longValue, str22), 0);
                            }
                        }
                        g.RQ();
                        g.RP().Ry().set(335874, Integer.valueOf(0));
                        this.rti = (ArrayList) a.bJa().bIV();
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
                        hVar.e(11455, objArr);
                        this.rtg.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(40174);
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
                                        a.ZF((String) it.next());
                                    }
                                    HashSet hashSet = new HashSet(JsapiSnsLabelUI.this.rti);
                                    JsapiSnsLabelUI.this.rti.clear();
                                    JsapiSnsLabelUI.this.rti.addAll(hashSet);
                                    JsapiSnsLabelUI.this.rtw.clear();
                                    JsapiSnsLabelUI.this.rtw = null;
                                    hashSet.clear();
                                }
                                JsapiSnsLabelUI.this.rJq.T(JsapiSnsLabelUI.this.rti);
                                JsapiSnsLabelUI.k(JsapiSnsLabelUI.this);
                                JsapiSnsLabelUI.this.rJq.notifyDataSetChanged();
                                JsapiSnsLabelUI.this.rtg.Qi(JsapiSnsLabelUI.this.rJq.rtF);
                                if (JsapiSnsLabelUI.this.rts != null && JsapiSnsLabelUI.this.rts.isShowing()) {
                                    JsapiSnsLabelUI.this.rts.dismiss();
                                }
                                AppMethodBeat.o(40174);
                            }
                        }, 600);
                        g.RQ();
                        g.RP().Ry().set(335873, Boolean.FALSE);
                        AppMethodBeat.o(40201);
                        return;
                    }
                    cty();
                    ab.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
                    AppMethodBeat.o(40201);
                    return;
            }
            AppMethodBeat.o(40201);
            return;
        }
        AppMethodBeat.o(40201);
    }

    private static int ctw() {
        AppMethodBeat.i(40202);
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(335874, Integer.valueOf(0))).intValue();
        AppMethodBeat.o(40202);
        return intValue;
    }

    private static void ctx() {
        AppMethodBeat.i(40203);
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(335874, Integer.valueOf(0))).intValue() + 1;
        g.RQ();
        g.RP().Ry().set(335874, Integer.valueOf(intValue));
        AppMethodBeat.o(40203);
    }

    private void cty() {
        AppMethodBeat.i(40204);
        com.tencent.mm.plugin.report.service.h.pYm.e(11455, "", "", Integer.valueOf(this.rtu), Integer.valueOf(0));
        ctx();
        this.rtw = null;
        this.rtq = false;
        this.rtp = false;
        if (this.rts != null && this.rts.isShowing()) {
            this.rts.dismiss();
        }
        if (this.rto) {
            this.rto = false;
            AppMethodBeat.o(40204);
            return;
        }
        int i = R.string.em2;
        if (ctw() > 1) {
            i = R.string.em1;
        }
        h.a((Context) this, i, (int) R.string.s6, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(40204);
    }

    private void ds(List<String[]> list) {
        AppMethodBeat.i(40205);
        if (this.rtw == null || this.rtw.size() == 0) {
            AppMethodBeat.o(40205);
            return;
        }
        Iterator it = this.rtw.iterator();
        Iterator it2 = list.iterator();
        ArrayList arrayList = new ArrayList(this.rtw.size());
        ArrayList arrayList2 = new ArrayList(this.rtw.size());
        while (it.hasNext()) {
            arrayList.add(a.bJa().PE((String) it.next()));
            arrayList2.add(bo.c(Arrays.asList((Object[]) it2.next()), ","));
            this.rtp = true;
        }
        a.bJa().i(arrayList, arrayList2);
        AppMethodBeat.o(40205);
    }

    private void ctz() {
        AppMethodBeat.i(40206);
        if (this.rti == null || this.rti.isEmpty()) {
            if (this.rJq.rtH != null) {
                this.rJq.rtH.clear();
            }
            if (this.rJq.rtI != null) {
                this.rJq.rtI.clear();
            }
            AppMethodBeat.o(40206);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it;
        String str;
        if (this.rJr.size() <= 0 || !"visible".equals(Er(this.rtm)) || this.rJq.rtH == null) {
            if (this.rJr.size() > 0 && "invisible".equals(Er(this.rtm))) {
                it = this.rJq.rtI.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    if (!this.rti.contains(str)) {
                        arrayList.add(str);
                    }
                }
                this.rJq.rtI.removeAll(arrayList);
            }
            AppMethodBeat.o(40206);
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
        AppMethodBeat.o(40206);
    }

    private void ctA() {
        AppMethodBeat.i(40207);
        if (this.rti == null || this.rti.isEmpty()) {
            this.rtj = "";
            AppMethodBeat.o(40207);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.rtj != null) {
            List<String> P = bo.P(this.rtj.split(","));
            if (P != null) {
                for (String str : P) {
                    if (!this.rti.contains(str)) {
                        arrayList.add(str);
                    }
                }
                P.removeAll(arrayList);
                this.rtj = bo.c((List) P, ",");
            }
        }
        AppMethodBeat.o(40207);
    }

    static /* synthetic */ void a(JsapiSnsLabelUI jsapiSnsLabelUI, int i, int i2) {
        AppMethodBeat.i(40208);
        if (jsapiSnsLabelUI.rJq != null) {
            Object child = jsapiSnsLabelUI.rJq.getChild(i, i2);
            if (child != null && (child instanceof String)) {
                String str = (String) child;
                String PE = a.bJa().PE(str);
                Intent intent = new Intent();
                intent.putExtra("label_id", PE);
                intent.putExtra("label_name", str);
                intent.putExtra("is_show_delete", false);
                d.b(jsapiSnsLabelUI.mController.ylL, "label", ".ui.ContactLabelEditUI", intent, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            }
        }
        AppMethodBeat.o(40208);
    }

    static /* synthetic */ void c(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(138393);
        h.a((Context) jsapiSnsLabelUI, jsapiSnsLabelUI.getString(R.string.em4), null, jsapiSnsLabelUI.getString(R.string.em3), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(40180);
                JsapiSnsLabelUI.this.rtp = true;
                a.bJa().ce(JsapiSnsLabelUI.this.rtw);
                JsapiSnsLabelUI.this.rts = h.b(JsapiSnsLabelUI.this, JsapiSnsLabelUI.this.getString(R.string.elt), false, null);
                AppMethodBeat.o(40180);
            }
        });
        AppMethodBeat.o(138393);
    }

    static /* synthetic */ void f(JsapiSnsLabelUI jsapiSnsLabelUI) {
        AppMethodBeat.i(138394);
        Intent intent = new Intent();
        intent.putExtra("titile", jsapiSnsLabelUI.getString(R.string.eu));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_attr", s.C(s.znE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        if (jsapiSnsLabelUI.rtr == jsapiSnsLabelUI.rJn) {
            if (jsapiSnsLabelUI.rJq.rtJ.size() > 0) {
                intent.putExtra("already_select_contact", bo.c(jsapiSnsLabelUI.rJq.rtJ, ","));
            }
        } else if (jsapiSnsLabelUI.rtr == jsapiSnsLabelUI.rJo && jsapiSnsLabelUI.rJq.rtK.size() > 0) {
            intent.putExtra("already_select_contact", bo.c(jsapiSnsLabelUI.rJq.rtK, ","));
        }
        intent.putExtra("KBlockOpenImFav", true);
        d.b((Context) jsapiSnsLabelUI, ".ui.contact.SelectContactUI", intent, (int) WearableStatusCodes.DATA_ITEM_TOO_LARGE);
        AppMethodBeat.o(138394);
    }

    static /* synthetic */ void a(JsapiSnsLabelUI jsapiSnsLabelUI, int i, ArrayList arrayList, String str, View view) {
        AppMethodBeat.i(138395);
        if (jsapiSnsLabelUI.rJq == null || jsapiSnsLabelUI.rJq.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.checkbox_unselected);
                AppMethodBeat.o(138395);
                return;
            }
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.checkbox_selected);
                AppMethodBeat.o(138395);
                return;
            }
            ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.checkbox_selected_red);
            AppMethodBeat.o(138395);
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i == 1) {
                ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.sight_list_checkbox_unselected);
                AppMethodBeat.o(138395);
                return;
            }
            ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.sight_list_checkbox_unselected_red);
            AppMethodBeat.o(138395);
        } else {
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.sight_list_checkbox_selected);
                AppMethodBeat.o(138395);
                return;
            }
            ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.sight_list_checkbox_selected_red);
            AppMethodBeat.o(138395);
        }
    }
}
