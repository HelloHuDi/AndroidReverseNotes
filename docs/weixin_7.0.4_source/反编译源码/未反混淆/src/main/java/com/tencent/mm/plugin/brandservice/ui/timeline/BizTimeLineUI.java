package com.tencent.mm.plugin.brandservice.ui.timeline;

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
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.k;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@i
public class BizTimeLineUI extends MMActivity implements h {
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
    private f jNy;
    private long jOA = 0;
    private long jOB = 0;
    private boolean jOC = false;
    private c jOD = new c() {
        public final void a(Object obj, a aVar) {
            AppMethodBeat.i(14194);
            BizTimeLineUI.this.aWx();
            AppMethodBeat.o(14194);
        }
    };
    private long jOE = 0;
    private final long jOF = 100;
    private boolean jOG = false;
    private List<q> jOH = new LinkedList();
    private boolean jOI = false;
    private com.tencent.mm.sdk.b.c jOJ = new com.tencent.mm.sdk.b.c<k>() {
        {
            AppMethodBeat.i(14191);
            this.xxI = k.class.getName().hashCode();
            AppMethodBeat.o(14191);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(14192);
            k kVar = (k) bVar;
            if (!(kVar == null || kVar.csh == null || kVar.csh.csi)) {
                BizTimeLineUI.this.jOA = 0;
            }
            AppMethodBeat.o(14192);
            return false;
        }
    };
    public StoryListView jOm;
    private View jOn;
    private ImageView jOo;
    LinearLayout jOp;
    private TextView jOq;
    private TextView jOr;
    private View jOs;
    private a jOt;
    private d jOu;
    private int joI = -1;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizTimeLineUI() {
        AppMethodBeat.i(14203);
        AppMethodBeat.o(14203);
    }

    static /* synthetic */ void a(BizTimeLineUI bizTimeLineUI) {
        AppMethodBeat.i(14222);
        bizTimeLineUI.aWy();
        AppMethodBeat.o(14222);
    }

    static /* synthetic */ void b(BizTimeLineUI bizTimeLineUI, int i, int i2) {
        AppMethodBeat.i(14228);
        bizTimeLineUI.dE(i, i2);
        AppMethodBeat.o(14228);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(14204);
        super.onCreate(bundle);
        xE(-1052684);
        setTitleBarDoubleClickListener(new Runnable() {
            public final void run() {
                AppMethodBeat.i(14185);
                if (BizTimeLineUI.this.uiu || BizTimeLineUI.this.isFinishing()) {
                    AppMethodBeat.o(14185);
                    return;
                }
                BizTimeLineUI.m(BizTimeLineUI.this);
                AppMethodBeat.o(14185);
            }
        });
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100045");
        boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpenSearch"));
        ab.d("MicroMsg.BizTimeLineUI", "open search entrance:%b", Boolean.valueOf(z));
        if (z) {
            addIconOptionMenu(0, R.string.ewn, R.raw.actionbar_icon_dark_search, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(14202);
                    if (aa.HU(0)) {
                        Intent cVd = aa.cVd();
                        cVd.putExtra("title", BizTimeLineUI.this.getString(R.string.c2b));
                        cVd.putExtra("searchbar_tips", BizTimeLineUI.this.getString(R.string.c2b));
                        cVd.putExtra("KRightBtn", true);
                        cVd.putExtra("ftsneedkeyboard", true);
                        cVd.putExtra("publishIdPrefix", "bs");
                        cVd.putExtra("ftsType", 2);
                        cVd.putExtra("ftsbizscene", 11);
                        Map d = aa.d(11, true, 2);
                        String HP = aa.HP(bo.ank((String) d.get("scene")));
                        d.put("sessionId", HP);
                        cVd.putExtra("sessionId", HP);
                        cVd.putExtra("rawUrl", aa.E(d));
                        cVd.putExtra("key_load_js_without_delay", true);
                        cVd.addFlags(67108864);
                        HP = ac.adN("bizAccountTopSearch");
                        if (!TextUtils.isEmpty(HP)) {
                            cVd.putExtra("key_search_input_hint", HP);
                        }
                        d.b(ah.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd);
                    } else {
                        ab.e("MicroMsg.BizTimeLineUI", "fts h5 template not avail");
                    }
                    AppMethodBeat.o(14202);
                    return true;
                }
            });
        }
        addIconOptionMenu(1, R.string.a_e, R.raw.actionbar_menu_list_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(14184);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("biz_from_scene", 2);
                intent.putExtra("biz_time_line_line_session_id", BizTimeLineUI.this.ctE);
                intent.putExtra("biz_enter_source", BizTimeLineUI.this.cvd);
                d.f(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", intent);
                BizTimeLineUI.this.jNy.si(7);
                BizTimeLineUI.this.jOC = true;
                AppMethodBeat.o(14184);
                return true;
            }
        });
        setMMTitle((int) R.string.a_i);
        ta(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(14186);
                BizTimeLineUI.this.finish();
                AppMethodBeat.o(14186);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        this.jOn = getLayoutInflater().inflate(R.layout.gw, null);
        this.jOr = (TextView) this.jOn.findViewById(R.id.a72);
        this.jOr.setTextSize(1, 14.0f);
        this.jOs = this.jOn.findViewById(R.id.a71);
        ((LinearLayout) this.mController.mActionBar.getCustomView()).addView(this.jOn);
        LayoutParams layoutParams = (LayoutParams) this.jOn.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.weight = 1.0f;
        this.jOn.setLayoutParams(layoutParams);
        this.jOs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(14187);
                BizTimeLineUI.m(BizTimeLineUI.this);
                AppMethodBeat.o(14187);
            }
        });
        this.jOn.setVisibility(8);
        this.emptyTipTv = (TextView) findViewById(R.id.a74);
        this.emptyTipTv.setText(R.string.a9t);
        this.jOu = new d(this);
        com.tencent.mm.sdk.b.a.xxA.c(this.jOu.hAA);
        this.ctE = (int) (System.currentTimeMillis() / 1000);
        this.cvd = getIntent().getIntExtra("biz_enter_source", 1);
        this.jNy = new f(this.ctE);
        s.Mj(this.ctE);
        c cVar = new c();
        if (c.aWu()) {
            aWy();
        } else {
            getString(R.string.tz);
            final p b = h.b((Context) this, getString(R.string.un), false, null);
            com.tencent.mm.sdk.g.d.post(new com.tencent.mm.plugin.brandservice.ui.timeline.c.AnonymousClass1(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14195);
                    if (b != null && b.isShowing()) {
                        b.dismiss();
                    }
                    if (BizTimeLineUI.this.isFinishing()) {
                        ab.w("MicroMsg.BizTimeLineUI", "checkInitListView isFinishing, just return");
                        AppMethodBeat.o(14195);
                        return;
                    }
                    BizTimeLineUI.a(BizTimeLineUI.this);
                    AppMethodBeat.o(14195);
                }
            }), "BizTimeLineMigrateThread");
        }
        ab.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
        int intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue();
        if ((intValue & 4) == 0) {
            ((j) g.K(j.class)).XR().apc("officialaccounts");
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(intValue | 4));
        }
        f.n(this);
        this.jOA = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.xxA.c(this.jOJ);
        if (((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(1)) {
            ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rX(90);
        }
        r aeX = z.aeX();
        if (aeX.yam) {
            aeX.yam = false;
            com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(139002);
                    if (r.yal != null && r.yal.length > 0) {
                        ab.d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed start");
                        ArrayList arrayList = new ArrayList();
                        for (String hY : r.yal) {
                            long currentTimeMillis = System.currentTimeMillis();
                            r.this.fni.hY("BizTimeLineInfo", hY);
                            int currentTimeMillis2 = (int) ((System.currentTimeMillis() - currentTimeMillis) / 1000);
                            IDKey iDKey = new IDKey();
                            iDKey.SetID(1049);
                            iDKey.SetKey(r.Mv(currentTimeMillis2));
                            iDKey.SetValue(1);
                            arrayList.add(iDKey);
                        }
                        com.tencent.mm.plugin.report.service.h.pYm.b(arrayList, false);
                        ab.d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed end");
                    }
                    AppMethodBeat.o(139002);
                }
            }, "BizTimeLineInfoStorageThread", 1000);
        }
        AppMethodBeat.o(14204);
    }

    public final void aWx() {
        AppMethodBeat.i(14206);
        if (isFinishing()) {
            AppMethodBeat.o(14206);
            return;
        }
        if (z.aeY().baS() > 0) {
            this.jOp.setVisibility(0);
            this.jOq.setText(getString(R.string.a_8, new Object[]{Integer.valueOf(r0)}));
            q drQ = z.aeY().drQ();
            if (drQ != null) {
                this.jOo.setVisibility(0);
                com.tencent.mm.pluginsdk.ui.a.b.b(this.jOo, drQ.field_talker);
                s.mM(drQ.field_msgId);
            } else {
                this.jOo.setVisibility(8);
            }
            if (this.jOt != null && this.jOt.getCount() == 0) {
                this.jOt.notifyDataSetChanged();
            }
            AppMethodBeat.o(14206);
            return;
        }
        this.jOp.setVisibility(8);
        AppMethodBeat.o(14206);
    }

    private void aX(final List<q> list) {
        AppMethodBeat.i(14208);
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                AppMethodBeat.i(14200);
                Looper.myQueue().removeIdleHandler(this);
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                com.tencent.mm.plugin.brandservice.ui.b.c.aX(linkedList);
                AppMethodBeat.o(14200);
                return false;
            }
        });
        AppMethodBeat.o(14208);
    }

    private void c(final q qVar) {
        AppMethodBeat.i(14209);
        this.jOm.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(14201);
                BizTimeLineUI.this.jOt.jNw = false;
                BizTimeLineUI.this.jNw = false;
                int max = Math.max(0, BizTimeLineUI.this.jOm.getFirstVisiblePosition() - BizTimeLineUI.this.jOm.getHeaderViewsCount());
                BizTimeLineUI.this.jOt.a(qVar);
                BizTimeLineUI.this.jOt.a(BizTimeLineUI.this.jOt.sg(max));
                BizTimeLineUI.j(BizTimeLineUI.this);
                ab.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", Integer.valueOf(max));
                AppMethodBeat.o(14201);
            }
        }, 50);
        AppMethodBeat.o(14209);
    }

    private View aWz() {
        AppMethodBeat.i(14210);
        this.jNV = getLayoutInflater().inflate(R.layout.gz, null);
        View view = this.jNV;
        AppMethodBeat.o(14210);
        return view;
    }

    private View aWA() {
        AppMethodBeat.i(14211);
        this.gwR = getLayoutInflater().inflate(R.layout.h0, null);
        this.jNo = (BizTimeLineHotView) this.gwR.findViewById(R.id.a7_);
        View view = this.gwR;
        AppMethodBeat.o(14211);
        return view;
    }

    public final void aWB() {
        AppMethodBeat.i(14212);
        if (!(isFinishing() || this.jNV == null)) {
            TextView textView = (TextView) findViewById(R.id.a79);
            ((ProgressBar) findViewById(R.id.a78)).setVisibility(8);
            textView.setText(getString(R.string.a_5));
        }
        AppMethodBeat.o(14212);
    }

    public final int getLayoutId() {
        return R.layout.gx;
    }

    public final void aWC() {
        AppMethodBeat.i(14213);
        long currentTimeMillis = System.currentTimeMillis() - this.jOE;
        if (!this.jOG || currentTimeMillis >= 200) {
            ab.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", Boolean.valueOf(this.jOG), Long.valueOf(currentTimeMillis));
            this.jOG = true;
            if (currentTimeMillis < 100) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(14188);
                        BizTimeLineUI.this.jOG = false;
                        if (BizTimeLineUI.this.isFinishing()) {
                            ab.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
                            AppMethodBeat.o(14188);
                            return;
                        }
                        BizTimeLineUI.this.aWC();
                        AppMethodBeat.o(14188);
                    }
                }, 100);
                AppMethodBeat.o(14213);
                return;
            }
            aWD();
            this.jOE = System.currentTimeMillis();
            this.jOG = false;
            AppMethodBeat.o(14213);
            return;
        }
        ab.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
        AppMethodBeat.o(14213);
    }

    private void aWD() {
        AppMethodBeat.i(14214);
        if (this.jOt == null || this.cAY) {
            AppMethodBeat.o(14214);
        } else if (this.jOt.iKa.size() > 0) {
            final long j = ((q) this.jOt.iKa.get(0)).field_orderFlag;
            ab.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", Integer.valueOf(z.aeX().mG(j)));
            if (z.aeX().mG(j) > 0) {
                MY(8);
                if (this.jOn.getVisibility() == 8) {
                    this.jOn.setVisibility(4);
                }
                this.jOr.setText(getString(R.string.a_d, new Object[]{Integer.valueOf(r2)}));
                this.jOn.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(14189);
                        if (z.aeX().mG(j) <= 0) {
                            BizTimeLineUI.this.MY(0);
                            AppMethodBeat.o(14189);
                            return;
                        }
                        float x = BizTimeLineUI.this.jOn.getX();
                        int width = (int) ((((float) BizTimeLineUI.this.jOn.getWidth()) + (x + x)) / 2.0f);
                        int gd = com.tencent.mm.bz.a.gd(BizTimeLineUI.this.mController.ylL) / 2;
                        if (width != gd) {
                            BizTimeLineUI.this.jOn.setX(((float) (gd - width)) + x);
                            ab.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", Float.valueOf(x), Float.valueOf(r1));
                        }
                        if (BizTimeLineUI.this.jOn.getVisibility() != 0) {
                            BizTimeLineUI.this.jOn.setVisibility(0);
                        }
                        AppMethodBeat.o(14189);
                    }
                });
                AppMethodBeat.o(14214);
                return;
            }
            this.jOn.setVisibility(8);
            MY(0);
            AppMethodBeat.o(14214);
        } else {
            AppMethodBeat.o(14214);
        }
    }

    public final void aWE() {
        AppMethodBeat.i(14215);
        ab.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
        aWC();
        AppMethodBeat.o(14215);
    }

    public final void aWv() {
        AppMethodBeat.i(14216);
        if (this.jOt != null) {
            this.jOt.notifyDataSetChanged();
        }
        AppMethodBeat.o(14216);
    }

    public void onDestroy() {
        AppMethodBeat.i(14217);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.jOu.hAA);
        jOv = System.currentTimeMillis();
        if (!(this.jOt == null || this.jOm == null)) {
            q aWp = this.jOt.aWp();
            if (aWp != null) {
                jOw = aWp.field_orderFlag;
            }
            aWp = this.jOt.sg(aWF());
            if (aWp != null) {
                jOx = aWp.field_orderFlag;
            } else {
                ab.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", Integer.valueOf(aWF()));
            }
            a aVar = this.jOt;
            z.aeX().a(aVar.jKp);
            aVar.jNp.jQR.clear();
        }
        z.aeY().a(this.jOD);
        if (this.jOA != 0) {
            this.iQc += System.currentTimeMillis() - this.jOB;
            com.tencent.mm.plugin.report.service.h.pYm.e(13932, Integer.valueOf(((int) (r0 - this.jOA)) / 1000), Integer.valueOf(1), Integer.valueOf(this.ctE), Integer.valueOf((int) (this.iQc / 1000)), Integer.valueOf(this.cvd));
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.jOJ);
        this.jNy.jOe = aWF();
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.i(14171);
                LinkedList linkedList = new LinkedList();
                for (Entry value : f.this.jOf.entrySet()) {
                    linkedList.add((a) value.getValue());
                }
                g.RO().eJo.a(new com.tencent.mm.plugin.brandservice.b.g(linkedList, f.this.jOd, f.this.jOe, f.this.ctE), 0);
                AppMethodBeat.o(14171);
            }
        }, 0);
        com.tencent.mm.plugin.brandservice.ui.b.b.clean();
        ao.clear();
        com.tencent.mm.ai.f fVar = this.jNo;
        ((j) g.K(j.class)).XR().b(fVar);
        com.tencent.mm.sdk.b.a.xxA.d(fVar.jQq);
        e eVar = fVar.jQg;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        bfc bfc = new bfc();
        aVar2.fsJ = bfc;
        aVar2.fsK = new bfd();
        aVar2.uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
        aVar2.fsI = 2550;
        com.tencent.mm.ai.b acD = aVar2.acD();
        bfc.vZZ = s.getSessionId();
        bfc.wIZ = eVar.jQC;
        LinkedList linkedList = new LinkedList();
        if (eVar.jQB.size() > 0) {
            for (Entry value : eVar.jQB.entrySet()) {
                linkedList.add((bfe) value.getValue());
            }
        }
        bfc.wIY = linkedList;
        w.a(acD, new w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(14344);
                ab.i("MicroMsg.BizTimeLineOftenReadReport", "often_read_bar_report CGI return, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.o(14344);
                return 0;
            }
        });
        g.Rg().b(2768, fVar);
        s.Mj(0);
        AppMethodBeat.o(14217);
    }

    public void onResume() {
        AppMethodBeat.i(14218);
        super.onResume();
        if (this.jOC) {
            this.jOC = false;
            this.jNy.si(8);
        }
        if (this.jOt != null) {
            a aVar = this.jOt;
            aVar.cAY = false;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.c cVar = aVar.jNp;
            if (cVar.jQU) {
                cVar.jQU = false;
                if (cVar.jQO <= 0) {
                    cVar.aWR();
                }
            }
        }
        if (this.cAY) {
            this.cAY = false;
            aWC();
        }
        this.jOB = System.currentTimeMillis();
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.i(14193);
                if (BizTimeLineUI.this.isFinishing() || BizTimeLineUI.this.jOm == null || BizTimeLineUI.this.jOm.getFirstVisiblePosition() != 0 || BizTimeLineUI.this.jNo == null) {
                    AppMethodBeat.o(14193);
                    return;
                }
                BizTimeLineUI.this.jNo.aWJ();
                AppMethodBeat.o(14193);
            }
        }, 500);
        AppMethodBeat.o(14218);
    }

    public void onPause() {
        AppMethodBeat.i(14219);
        super.onPause();
        q qVar = null;
        if (this.jOt != null) {
            a aVar = this.jOt;
            aVar.jNv.stopPlay();
            aVar.cAY = true;
            aVar.jNp.jQU = true;
            qVar = this.jOt.aWq();
        }
        aY(this.jOH);
        if (qVar != null) {
            z.aeX().mH(qVar.field_orderFlag);
        } else {
            z.aeX().drK();
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
        AppMethodBeat.o(14219);
    }

    private void dE(int i, int i2) {
        int i3 = 0;
        AppMethodBeat.i(14220);
        if (!(i != 0 || this.jNw || jOz == i)) {
            this.jNo.aWJ();
        }
        if (this.jNw || this.jOI || (jOz == i && this.joI == i2)) {
            AppMethodBeat.o(14220);
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

    private static void aY(List<q> list) {
        AppMethodBeat.i(14221);
        if (!bo.ek(list)) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : list) {
                qVar.field_isRead = 1;
            }
            linkedList.addAll(list);
            z.aeX().eo(linkedList);
        }
        AppMethodBeat.o(14221);
    }

    private static int aWF() {
        return jOz > 0 ? jOz - 1 : 0;
    }

    private void aWw() {
        AppMethodBeat.i(14205);
        this.jOp = (LinearLayout) findViewById(R.id.a7a);
        this.jOq = (TextView) findViewById(R.id.a7c);
        this.jOo = (ImageView) findViewById(R.id.a7b);
        aWx();
        this.jOp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(14183);
                Intent intent = new Intent(BizTimeLineUI.this.mController.ylL, BizTimeLineNewMsgUI.class);
                intent.putExtra("biz_time_line_line_enter_scene", 1);
                BizTimeLineUI.this.startActivity(intent);
                AppMethodBeat.o(14183);
            }
        });
        AppMethodBeat.o(14205);
    }

    private void aWy() {
        List drH;
        AppMethodBeat.i(14207);
        this.jOm = (StoryListView) findViewById(R.id.a73);
        this.jOm.addFooterView(aWz());
        this.jOm.addHeaderView(aWA());
        final int i = jOz;
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = com.tencent.mm.m.g.Nu().getInt("BizTimeLineStayTime", 180) * 1000;
        if (jOv == 0 || jOw == 0 || currentTimeMillis - jOv >= ((long) i2)) {
            this.jNw = false;
            drH = z.aeX().drH();
            aX(drH);
        } else {
            drH = z.aeX().mD(jOw);
            this.jNw = true;
        }
        ab.i("MicroMsg.BizTimeLineUI", "initListView stayTime %d %d/%d  orderFlag %d, keep %b", Integer.valueOf(i2), Long.valueOf(jOv), Long.valueOf(currentTimeMillis), Long.valueOf(jOw), Boolean.valueOf(this.jNw));
        this.jOt = new a(this, drH, this.jNw, this.jNy, this.jNo);
        this.jNy.jOd = aWF();
        aWw();
        this.jOm.setAdapter(this.jOt);
        this.jOm.setFooterDividersEnabled(false);
        this.jOm.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(14196);
                o.ahp().cm(i);
                if (i == 0) {
                    BizTimeLineUI.this.jOt.dD(BizTimeLineUI.this.jOm.getFirstVisiblePosition(), BizTimeLineUI.this.jOm.getLastVisiblePosition());
                }
                if (i == 2) {
                    BizTimeLineUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, com.tencent.mm.hardcoder.i.SCENE_BIZ_SCROLL, WXHardCoderJNI.hcBizAction, "MicroMsg.BizTimeLineUI");
                    ab.i("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", Integer.valueOf(com.tencent.mm.hardcoder.i.SCENE_BIZ_SCROLL), Integer.valueOf(BizTimeLineUI.this.ehv));
                }
                AppMethodBeat.o(14196);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(14197);
                BizTimeLineUI.a(BizTimeLineUI.this, i, i2);
                BizTimeLineUI.jOz = i;
                AppMethodBeat.o(14197);
            }
        });
        this.jOm.setEmptyView(this.emptyTipTv);
        this.jOm.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(14198);
                if (BizTimeLineUI.this.jNw && i != 0) {
                    BizTimeLineUI.f(BizTimeLineUI.this);
                    BizTimeLineUI.this.aWC();
                }
                if (BizTimeLineUI.this.jNw && i == 0) {
                    BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.this.jOt.sg(0));
                }
                if (!bo.ek(drH)) {
                    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new com.tencent.mm.plugin.brandservice.ui.timeline.f.AnonymousClass3(((q) drH.get(0)).field_orderFlag, BizTimeLineUI.this.cvd), 0);
                }
                AppMethodBeat.o(14198);
            }
        }, 100);
        this.jOm.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AppMethodBeat.i(14199);
                BizTimeLineUI.this.jOt.dD(BizTimeLineUI.this.jOm.getFirstVisiblePosition(), BizTimeLineUI.this.jOm.getLastVisiblePosition());
                BizTimeLineUI.this.jOm.removeOnLayoutChangeListener(this);
                AppMethodBeat.o(14199);
            }
        });
        if (drH.size() < 10) {
            aWB();
        }
        z.aeY().a(this.jOD, Looper.getMainLooper());
        AppMethodBeat.o(14207);
    }

    static /* synthetic */ void a(BizTimeLineUI bizTimeLineUI, int i, int i2) {
        AppMethodBeat.i(14223);
        bizTimeLineUI.dE(i, (i + i2) - 1);
        AppMethodBeat.o(14223);
    }

    static /* synthetic */ void f(BizTimeLineUI bizTimeLineUI) {
        AppMethodBeat.i(14224);
        if (bizTimeLineUI.jOt == null || bizTimeLineUI.jOm == null) {
            AppMethodBeat.o(14224);
            return;
        }
        if (jOx != 0) {
            List list = bizTimeLineUI.jOt.iKa;
            int i = 0;
            while (i < list.size()) {
                q qVar = (q) list.get(i);
                if (qVar == null || qVar.field_orderFlag != jOx) {
                    i++;
                } else {
                    com.tencent.mm.pluginsdk.ui.tools.k.a(bizTimeLineUI.jOm, i + 1, jOy, false);
                    bizTimeLineUI.c(qVar);
                    ab.i("MicroMsg.BizTimeLineUI", "setListViewPosition %d", Integer.valueOf(i));
                    AppMethodBeat.o(14224);
                    return;
                }
            }
        }
        AppMethodBeat.o(14224);
    }

    static /* synthetic */ void j(BizTimeLineUI bizTimeLineUI) {
        int i = 0;
        AppMethodBeat.i(14226);
        if (bizTimeLineUI.jOm == null || bizTimeLineUI.jOt == null) {
            AppMethodBeat.o(14226);
            return;
        }
        int firstVisiblePosition = bizTimeLineUI.jOm.getFirstVisiblePosition();
        int lastVisiblePosition = bizTimeLineUI.jOm.getLastVisiblePosition();
        bizTimeLineUI.dE(firstVisiblePosition, lastVisiblePosition);
        if (firstVisiblePosition > 0) {
            firstVisiblePosition--;
        } else {
            firstVisiblePosition = 0;
        }
        if (lastVisiblePosition > 0) {
            i = lastVisiblePosition - 1;
        }
        while (firstVisiblePosition <= i) {
            q sg = bizTimeLineUI.jOt.sg(firstVisiblePosition);
            if (sg != null) {
                bizTimeLineUI.jOt.FE(sg.field_talker);
                bizTimeLineUI.jNy.c(sg, firstVisiblePosition);
            }
            firstVisiblePosition++;
        }
        AppMethodBeat.o(14226);
    }

    static /* synthetic */ void m(BizTimeLineUI bizTimeLineUI) {
        AppMethodBeat.i(14227);
        if (!(bizTimeLineUI.jOt == null || bizTimeLineUI.jOm == null || bizTimeLineUI.jOt.getCount() <= 0)) {
            bizTimeLineUI.jOt.aWr();
            bizTimeLineUI.jOt.notifyDataSetChanged();
            bizTimeLineUI.jOI = true;
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14190);
                    BizTimeLineUI.this.jOI = false;
                    if (!(BizTimeLineUI.this.isFinishing() || BizTimeLineUI.this.jOm == null)) {
                        BizTimeLineUI.b(BizTimeLineUI.this, BizTimeLineUI.this.jOm.getFirstVisiblePosition(), BizTimeLineUI.this.jOm.getLastVisiblePosition());
                    }
                    AppMethodBeat.o(14190);
                }
            }, 200);
            bizTimeLineUI.jOm.setSelection(0);
            bizTimeLineUI.jNy.si(6);
            if (bizTimeLineUI.jOt != null) {
                q aWq = bizTimeLineUI.jOt.aWq();
                if (aWq != null) {
                    s.mL(aWq.field_orderFlag);
                }
            }
            bizTimeLineUI.aWE();
        }
        AppMethodBeat.o(14227);
    }
}
