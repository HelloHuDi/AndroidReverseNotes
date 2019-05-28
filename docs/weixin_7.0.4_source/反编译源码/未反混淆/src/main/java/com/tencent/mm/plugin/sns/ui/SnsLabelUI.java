package com.tencent.mm.plugin.sns.ui;

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

public class SnsLabelUI extends MMActivity implements f {
    public static int[] rth = new int[]{R.string.elx, R.string.elv, R.string.elr, R.string.elk};
    private AnimatedExpandableListView rtg;
    private ArrayList<String> rti;
    private String rtj;
    private String rtk;
    ap rtl;
    private int rtm = 0;
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

    static /* synthetic */ int ctB() {
        AppMethodBeat.i(39041);
        int ctw = ctw();
        AppMethodBeat.o(39041);
        return ctw;
    }

    static /* synthetic */ void h(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(39045);
        snsLabelUI.goBack();
        AppMethodBeat.o(39045);
    }

    static /* synthetic */ void k(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(39046);
        snsLabelUI.ctz();
        AppMethodBeat.o(39046);
    }

    static /* synthetic */ void n(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(39047);
        snsLabelUI.ctv();
        AppMethodBeat.o(39047);
    }

    static /* synthetic */ void o(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(39048);
        snsLabelUI.ctu();
        AppMethodBeat.o(39048);
    }

    public final int getLayoutId() {
        return R.layout.ave;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(39023);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
            AppMethodBeat.o(39023);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(39023);
        return dispatchKeyEvent;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39024);
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
        this.rtl = new ap(this);
        this.rtl.rtL = new ap.b() {
            public final void a(c cVar) {
                AppMethodBeat.i(39011);
                SnsLabelUI.a(SnsLabelUI.this, cVar.rtQ, cVar.rtR);
                AppMethodBeat.o(39011);
            }
        };
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
            findViewById(R.id.ejp).setBackgroundResource(R.color.h4);
        }
        if (this.rtm == 2) {
            if (!TextUtils.isEmpty(this.rtj)) {
                this.rtl.rtH = bo.P(this.rtj.split(","));
            }
            if (!TextUtils.isEmpty(this.rtk)) {
                this.rtl.rtJ = bo.P(this.rtk.split(","));
            }
        } else if (this.rtm == 3) {
            if (!TextUtils.isEmpty(this.rtj)) {
                this.rtl.rtI = bo.P(this.rtj.split(","));
            }
            if (!TextUtils.isEmpty(this.rtk)) {
                this.rtl.rtK = bo.P(this.rtk.split(","));
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
        AppMethodBeat.o(39024);
    }

    public final void initView() {
        AppMethodBeat.i(39025);
        boolean booleanExtra = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
        this.rtg = (AnimatedExpandableListView) findViewById(R.id.ejq);
        this.rti = (ArrayList) a.bJa().bIV();
        this.rtl.rtG = booleanExtra;
        this.rtl.T(this.rti);
        ctz();
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(R.dimen.l8);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.rtg.addHeaderView(view);
        this.rtg.setAdapter(this.rtl);
        if (this.rtl.rtF == 2) {
            this.rtg.expandGroup(2);
        } else if (this.rtl.rtF == 3) {
            this.rtg.expandGroup(3);
        }
        this.rtg.setOnGroupClickListener(new OnGroupClickListener() {
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, final int i, long j) {
                AppMethodBeat.i(39015);
                int i2 = SnsLabelUI.this.rtl.rtF;
                ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", Integer.valueOf(i2), Integer.valueOf(i));
                if (i <= 1) {
                    if (i2 > 1) {
                        SnsLabelUI.this.rtg.Qj(i2);
                    }
                    SnsLabelUI.this.rtl.rtF = i;
                    AppMethodBeat.o(39015);
                    return false;
                } else if (SnsLabelUI.this.rtw != null && SnsLabelUI.this.rtw.size() != 0 && SnsLabelUI.ctB() == 0) {
                    SnsLabelUI.this.rtr = i;
                    SnsLabelUI.c(SnsLabelUI.this);
                    ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
                    AppMethodBeat.o(39015);
                    return true;
                } else if (SnsLabelUI.this.rtq) {
                    SnsLabelUI.this.rto = true;
                    SnsLabelUI.this.rtr = i;
                    SnsLabelUI.this.rts = h.b(SnsLabelUI.this, SnsLabelUI.this.getString(R.string.elt), false, null);
                    ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
                    AppMethodBeat.o(39015);
                    return true;
                } else if (SnsLabelUI.this.rtl.rtE == null || SnsLabelUI.this.rtl.rtE.size() == 0) {
                    SnsLabelUI.this.rtr = i;
                    SnsLabelUI.f(SnsLabelUI.this);
                    ab.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
                    AppMethodBeat.o(39015);
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
                                AppMethodBeat.i(39014);
                                SnsLabelUI.this.rtg.Qi(i);
                                AppMethodBeat.o(39014);
                            }
                        });
                    } else if (SnsLabelUI.this.rtg.isGroupExpanded(i)) {
                        SnsLabelUI.this.rtg.Qj(i);
                    } else {
                        SnsLabelUI.this.rtg.Qi(i);
                    }
                    SnsLabelUI.this.rtl.rtF = i;
                    AppMethodBeat.o(39015);
                    return true;
                }
            }
        });
        this.rtg.setOnChildClickListener(new OnChildClickListener() {
            public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
                AppMethodBeat.i(39016);
                if (i2 == SnsLabelUI.this.rtl.getChildrenCount(i) - 1) {
                    SnsLabelUI.this.rtr = i;
                    SnsLabelUI.f(SnsLabelUI.this);
                } else {
                    String str = (String) SnsLabelUI.this.rtl.getChild(i, i2);
                    SnsLabelUI.this.rtl;
                    ap.ZF(str);
                    if (i == 2) {
                        SnsLabelUI.a(SnsLabelUI.this, 1, SnsLabelUI.this.rtl.rtH, str, view);
                    } else if (i == 3) {
                        SnsLabelUI.a(SnsLabelUI.this, 2, SnsLabelUI.this.rtl.rtI, str, view);
                    }
                }
                AppMethodBeat.o(39016);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39017);
                SnsLabelUI.h(SnsLabelUI.this);
                AppMethodBeat.o(39017);
                return true;
            }
        });
        a(0, getString(R.string.elm), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39018);
                Context context = SnsLabelUI.this;
                String c = bo.c(context.rtl.rtH, ",");
                String c2 = bo.c(context.rtl.rtJ, ",");
                String c3 = bo.c(context.rtl.rtI, ",");
                String c4 = bo.c(context.rtl.rtK, ",");
                if ((context.rtl.rtF == 2 && context.rtl.rtH.size() == 0 && context.rtl.rtJ.size() == 0) || (context.rtl.rtF == 3 && context.rtl.rtI.size() == 0 && context.rtl.rtK.size() == 0)) {
                    h.a(context, context.getString(R.string.elu), "", context.getString(R.string.em3), null);
                } else if ((context.rtl.rtF == 2 && bo.isNullOrNil(c) && bo.isNullOrNil(c2)) || (context.rtl.rtF == 3 && bo.isNullOrNil(c3) && bo.isNullOrNil(c4))) {
                    h.a(context, context.getString(R.string.elu), "", context.getString(R.string.em3), null);
                } else {
                    context.ctv();
                }
                AppMethodBeat.o(39018);
                return true;
            }
        }, q.b.GREEN);
        AppMethodBeat.o(39025);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39026);
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
                if (this.rtr == 2) {
                    this.rtl.rtJ.clear();
                    if (!bo.isNullOrNil(stringExtra)) {
                        this.rtl.rtJ.addAll(bo.P(stringExtra.split(",")));
                        this.rtl.rtF = this.rtr;
                    }
                } else if (this.rtr == 3) {
                    this.rtl.rtK.clear();
                    if (!bo.isNullOrNil(stringExtra)) {
                        this.rtl.rtK.addAll(bo.P(stringExtra.split(",")));
                        this.rtl.rtF = this.rtr;
                    }
                }
                this.rtl.notifyDataSetChanged();
                this.rtg.expandGroup(this.rtr);
                AppMethodBeat.o(39026);
                return;
            }
            intent2 = new Intent();
            intent2.putExtra("Select_Contact", stringExtra);
            d.b(this.mController.ylL, "label", ".ui.ContactLabelEditUI", intent2, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            AppMethodBeat.o(39026);
        } else if (i2 == -1 && i == WearableStatusCodes.DUPLICATE_LISTENER) {
            stringExtra = intent.getStringExtra("Select_Contact");
            ab.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", String.valueOf(stringExtra));
            if (!bo.isNullOrNil(stringExtra)) {
                intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                d.b((Context) this, "label", ".ui.ContactLabelEditUI", intent2, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            }
            AppMethodBeat.o(39026);
        } else {
            if (i2 == 0 && i == WearableStatusCodes.UNKNOWN_LISTENER && intent != null) {
                stringExtra = intent.getStringExtra("k_sns_label_add_label");
                this.rtt = intent.getStringExtra("k_sns_label_add_label");
                this.rtg.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39020);
                        SnsLabelUI.this.rti = (ArrayList) a.bJa().bIV();
                        if (SnsLabelUI.this.rti == null) {
                            SnsLabelUI.this.rti = new ArrayList();
                        }
                        int i;
                        if (bo.isNullOrNil(stringExtra)) {
                            i = -1;
                        } else {
                            if (!SnsLabelUI.this.rti.contains(stringExtra)) {
                                SnsLabelUI.this.rti.add(stringExtra);
                            }
                            i = SnsLabelUI.this.rti.indexOf(stringExtra);
                        }
                        SnsLabelUI.this.rtl.T(SnsLabelUI.this.rti);
                        SnsLabelUI.k(SnsLabelUI.this);
                        SnsLabelUI.this.rtl.rtF = SnsLabelUI.this.rtr;
                        if (!(bo.isNullOrNil(stringExtra) || i == -1)) {
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
                        AppMethodBeat.o(39020);
                    }
                }, 600);
            }
            AppMethodBeat.o(39026);
        }
    }

    private boolean ctt() {
        boolean z = true;
        AppMethodBeat.i(39027);
        int i = this.rtl.rtF;
        if (this.rtl.rtF == this.rtm ? (i != 2 || this.rtl.rtH.size() == 0 || (bo.c(this.rtl.rtH, ",").equals(this.rtj) && bo.c(this.rtl.rtJ, ",").equals(this.rtk))) && (i != 3 || this.rtl.rtI.size() == 0 || (bo.c(this.rtl.rtI, ",").equals(this.rtj) && bo.c(this.rtl.rtK, ",").equals(this.rtk))) : (i != 2 || (this.rtl.rtH.size() == 0 && this.rtl.rtJ.size() == 0)) && !((i == 3 && (this.rtl.rtI.size() != 0 || this.rtl.rtK.size() != 0)) || i == 1 || i == 0)) {
            z = false;
        }
        AppMethodBeat.o(39027);
        return z;
    }

    private void goBack() {
        AppMethodBeat.i(39028);
        if (ctt()) {
            h.a((Context) this, true, getString(R.string.elq), "", getString(R.string.elp), getString(R.string.elo), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(39021);
                    SnsLabelUI.n(SnsLabelUI.this);
                    AppMethodBeat.o(39021);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(39022);
                    SnsLabelUI.o(SnsLabelUI.this);
                    AppMethodBeat.o(39022);
                }
            });
            AppMethodBeat.o(39028);
            return;
        }
        ctu();
        AppMethodBeat.o(39028);
    }

    private void ctu() {
        AppMethodBeat.i(39029);
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.rtm);
        if (this.rtm == 2 || this.rtm == 3) {
            ctA();
            intent.putExtra("Klabel_name_list", this.rtj);
            intent.putExtra("Kother_user_name_list", this.rtk);
        }
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(39029);
    }

    /* Access modifiers changed, original: final */
    public final void ctv() {
        AppMethodBeat.i(39030);
        Intent intent = new Intent();
        if (this.rtl.rtF == 2) {
            this.rtj = bo.c(this.rtl.rtH, ",");
            this.rtk = bo.c(this.rtl.rtJ, ",");
            ctA();
            intent.putExtra("Klabel_name_list", this.rtj);
            intent.putExtra("Kother_user_name_list", this.rtk);
        } else if (this.rtl.rtF == 3) {
            this.rtj = bo.c(this.rtl.rtI, ",");
            this.rtk = bo.c(this.rtl.rtK, ",");
            ctA();
            intent.putExtra("Klabel_name_list", this.rtj);
            intent.putExtra("Kother_user_name_list", this.rtk);
        }
        intent.putExtra("Ktag_range_index", this.rtl.rtF);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(39030);
    }

    public void onDestroy() {
        AppMethodBeat.i(39031);
        g.RQ();
        g.RO().eJo.b(292, (f) this);
        g.RQ();
        g.RO().eJo.b((int) b.CTRL_INDEX, (f) this);
        g.RQ();
        g.RO().eJo.b(638, (f) this);
        g.RQ();
        g.RO().eJo.b(290, (f) this);
        super.onDestroy();
        AppMethodBeat.o(39031);
    }

    public void onResume() {
        AppMethodBeat.i(39032);
        if (!(this.rtl == null || this.rtt != null || this.rtg == null)) {
            this.rtg.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(39012);
                    a.bJa().ahw();
                    SnsLabelUI.this.rti = (ArrayList) a.bJa().bIV();
                    SnsLabelUI.this.rtl.T(SnsLabelUI.this.rti);
                    SnsLabelUI.k(SnsLabelUI.this);
                    if ((SnsLabelUI.this.rti == null || SnsLabelUI.this.rti.size() == 0) && !((SnsLabelUI.this.rtk != null && SnsLabelUI.this.rtk.length() != 0) || SnsLabelUI.this.rtl.rtF == 0 || SnsLabelUI.this.rtl.rtF == 1)) {
                        SnsLabelUI.this.rtl.rtF = 0;
                    }
                    SnsLabelUI.this.rtl.notifyDataSetChanged();
                    SnsLabelUI.this.rtt = null;
                    AppMethodBeat.o(39012);
                }
            }, 600);
        }
        super.onResume();
        AppMethodBeat.o(39032);
    }

    /* JADX WARNING: Missing block: B:30:0x00f3, code skipped:
            if (r0 == null) goto L_0x00f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(39033);
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
                            this.rtl.rtF = this.rtr;
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
                    AppMethodBeat.o(39033);
                    return;
                case b.CTRL_INDEX /*635*/:
                    if (i == 0 && i2 == 0) {
                        ds(this.rty);
                        AppMethodBeat.o(39033);
                        return;
                    }
                    cty();
                    ab.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
                    AppMethodBeat.o(39033);
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
                                AppMethodBeat.i(39013);
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
                                        ap.ZF((String) it.next());
                                    }
                                    HashSet hashSet = new HashSet(SnsLabelUI.this.rti);
                                    SnsLabelUI.this.rti.clear();
                                    SnsLabelUI.this.rti.addAll(hashSet);
                                    SnsLabelUI.this.rtw.clear();
                                    SnsLabelUI.this.rtw = null;
                                    hashSet.clear();
                                }
                                SnsLabelUI.this.rtl.T(SnsLabelUI.this.rti);
                                SnsLabelUI.k(SnsLabelUI.this);
                                SnsLabelUI.this.rtl.notifyDataSetChanged();
                                SnsLabelUI.this.rtg.Qi(SnsLabelUI.this.rtl.rtF);
                                if (SnsLabelUI.this.rts != null && SnsLabelUI.this.rts.isShowing()) {
                                    SnsLabelUI.this.rts.dismiss();
                                }
                                AppMethodBeat.o(39013);
                            }
                        }, 600);
                        g.RQ();
                        g.RP().Ry().set(335873, Boolean.FALSE);
                        AppMethodBeat.o(39033);
                        return;
                    }
                    cty();
                    ab.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
                    AppMethodBeat.o(39033);
                    return;
            }
            AppMethodBeat.o(39033);
            return;
        }
        AppMethodBeat.o(39033);
    }

    private static int ctw() {
        AppMethodBeat.i(39034);
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(335874, Integer.valueOf(0))).intValue();
        AppMethodBeat.o(39034);
        return intValue;
    }

    private static void ctx() {
        AppMethodBeat.i(39035);
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(335874, Integer.valueOf(0))).intValue() + 1;
        g.RQ();
        g.RP().Ry().set(335874, Integer.valueOf(intValue));
        AppMethodBeat.o(39035);
    }

    private void cty() {
        AppMethodBeat.i(39036);
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
            AppMethodBeat.o(39036);
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
        AppMethodBeat.o(39036);
    }

    private void ds(List<String[]> list) {
        AppMethodBeat.i(39037);
        if (this.rtw == null || this.rtw.size() == 0) {
            AppMethodBeat.o(39037);
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
        AppMethodBeat.o(39037);
    }

    private void ctz() {
        AppMethodBeat.i(39038);
        if (this.rti == null || this.rti.isEmpty()) {
            if (this.rtl.rtH != null) {
                this.rtl.rtH.clear();
            }
            if (this.rtl.rtI != null) {
                this.rtl.rtI.clear();
            }
            AppMethodBeat.o(39038);
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
            AppMethodBeat.o(39038);
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
        AppMethodBeat.o(39038);
    }

    private void ctA() {
        AppMethodBeat.i(39039);
        if (this.rti == null || this.rti.isEmpty()) {
            this.rtj = "";
            AppMethodBeat.o(39039);
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
        AppMethodBeat.o(39039);
    }

    static /* synthetic */ void a(SnsLabelUI snsLabelUI, int i, int i2) {
        AppMethodBeat.i(39040);
        if (snsLabelUI.rtl != null) {
            Object child = snsLabelUI.rtl.getChild(i, i2);
            if (child != null && (child instanceof String)) {
                String str = (String) child;
                String PE = a.bJa().PE(str);
                Intent intent = new Intent();
                intent.putExtra("label_id", PE);
                intent.putExtra("label_name", str);
                intent.putExtra("is_show_delete", false);
                d.b(snsLabelUI.mController.ylL, "label", ".ui.ContactLabelEditUI", intent, (int) WearableStatusCodes.UNKNOWN_LISTENER);
            }
        }
        AppMethodBeat.o(39040);
    }

    static /* synthetic */ void c(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(39042);
        h.a((Context) snsLabelUI, snsLabelUI.getString(R.string.em4), null, snsLabelUI.getString(R.string.em3), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(39019);
                SnsLabelUI.this.rtp = true;
                a.bJa().ce(SnsLabelUI.this.rtw);
                SnsLabelUI.this.rts = h.b(SnsLabelUI.this, SnsLabelUI.this.getString(R.string.elt), false, null);
                AppMethodBeat.o(39019);
            }
        });
        AppMethodBeat.o(39042);
    }

    static /* synthetic */ void f(SnsLabelUI snsLabelUI) {
        AppMethodBeat.i(39043);
        Intent intent = new Intent();
        intent.putExtra("titile", snsLabelUI.getString(R.string.eu));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_attr", s.C(s.znE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        if (snsLabelUI.rtr == 2) {
            if (snsLabelUI.rtl.rtJ.size() > 0) {
                intent.putExtra("already_select_contact", bo.c(snsLabelUI.rtl.rtJ, ","));
            }
        } else if (snsLabelUI.rtr == 3 && snsLabelUI.rtl.rtK.size() > 0) {
            intent.putExtra("already_select_contact", bo.c(snsLabelUI.rtl.rtK, ","));
        }
        intent.putExtra("KBlockOpenImFav", true);
        d.b((Context) snsLabelUI, ".ui.contact.SelectContactUI", intent, (int) WearableStatusCodes.DATA_ITEM_TOO_LARGE);
        AppMethodBeat.o(39043);
    }

    static /* synthetic */ void a(SnsLabelUI snsLabelUI, int i, ArrayList arrayList, String str, View view) {
        AppMethodBeat.i(39044);
        if (snsLabelUI.rtl == null || snsLabelUI.rtl.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.checkbox_unselected);
                AppMethodBeat.o(39044);
                return;
            }
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.checkbox_selected);
                AppMethodBeat.o(39044);
                return;
            }
            ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.checkbox_selected_red);
            AppMethodBeat.o(39044);
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i == 1) {
                ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.sight_list_checkbox_unselected);
                AppMethodBeat.o(39044);
                return;
            }
            ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.sight_list_checkbox_unselected_red);
            AppMethodBeat.o(39044);
        } else {
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.sight_list_checkbox_selected);
                AppMethodBeat.o(39044);
                return;
            }
            ((ImageView) view.findViewById(R.id.ejs)).setImageResource(R.raw.sight_list_checkbox_selected_red);
            AppMethodBeat.o(39044);
        }
    }
}
