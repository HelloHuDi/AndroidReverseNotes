package com.tencent.p177mm.plugin.location.p446ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelsimple.C45453u;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18313ld;
import com.tencent.p177mm.p230g.p231a.C9306cg;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.location.model.C39283e;
import com.tencent.p177mm.plugin.location.model.LocationInfo;
import com.tencent.p177mm.plugin.location.p446ui.C12403n;
import com.tencent.p177mm.plugin.location.p446ui.C12403n.C12404a;
import com.tencent.p177mm.plugin.location.p446ui.C34412d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.tools.AppChooserUI;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14976d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C40490t;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aas;
import com.tencent.p177mm.protocal.protobuf.aaz;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.protocal.protobuf.buf;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.i */
public class C21182i extends C28374a implements C1202f {
    private boolean cHc = true;
    protected long cvx = -1;
    public C46607d ext = new C46607d(this.activity);
    private boolean hOy = false;
    private long nOa = 0;
    private String nRo = "";
    C12403n nRp;
    C36356d nRq;
    boolean nRr = false;
    private Runnable nRs;
    private C42206a nRt = new C33545();

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.i$3 */
    class C33523 implements OnClickListener {
        C33523() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113741);
            C21182i.this.bKH();
            C21182i.this.nRq.cpD();
            AppMethodBeat.m2505o(113741);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.i$4 */
    class C33534 implements OnClickListener {
        C33534() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113742);
            C21182i.this.czL = 0;
            C21182i.this.bKB();
            C21182i.this.bKK();
            AppMethodBeat.m2505o(113742);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.i$5 */
    class C33545 implements C42206a {
        C33545() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(113743);
            if (z) {
                C4990ab.m7410d("MicroMsg.ViewMapUI", "onGetLocation flong " + f + " flat " + f2);
                if (((double) f2) == 0.0d && ((double) f) == 0.0d) {
                    AppMethodBeat.m2505o(113743);
                    return true;
                }
                C4990ab.m7410d("MicroMsg.ViewMapUI", "myLocation " + C21182i.this.nOK.nJu + " " + C21182i.this.nOK.nJv);
                C4990ab.m7410d("MicroMsg.ViewMapUI", "location my show");
                C21182i.this.nOK.nJu = (double) f2;
                C21182i.this.nOK.nJv = (double) f;
                C21182i.this.nOO.mo33924a(C21182i.this.nOK.nJu, C21182i.this.nOK.nJv, C21182i.this.nOV, C21182i.this.nOK.nJt);
                AppMethodBeat.m2505o(113743);
                return true;
            }
            AppMethodBeat.m2505o(113743);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.i$6 */
    class C33556 implements Runnable {
        C33556() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113744);
            if (C21182i.this.nOP) {
                if (C21182i.this.ehJ != null) {
                    C21182i.this.ehJ.dismiss();
                }
                C21182i.this.bKD();
            }
            C21182i.this.nOP = false;
            AppMethodBeat.m2505o(113744);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.i$2 */
    class C69602 implements C5279d {

        /* renamed from: com.tencent.mm.plugin.location.ui.impl.i$2$1 */
        class C69611 implements DialogInterface.OnClickListener {
            C69611() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(113739);
                long longExtra = C21182i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                C9306cg c9306cg = new C9306cg();
                c9306cg.cvt.cvv = longExtra;
                C4879a.xxA.mo10055m(c9306cg);
                C4990ab.m7411d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", Long.valueOf(longExtra), Boolean.valueOf(C5046bo.m7517a(Boolean.valueOf(c9306cg.cvu.cvi), false)));
                if (C5046bo.m7517a(Boolean.valueOf(c9306cg.cvu.cvi), false)) {
                    C21182i.this.activity.finish();
                }
                AppMethodBeat.m2505o(113739);
            }
        }

        C69602() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(113740);
            Intent intent;
            switch (menuItem.getItemId()) {
                case 0:
                    C21182i.this.bKI();
                    AppMethodBeat.m2505o(113740);
                    return;
                case 1:
                    if (C21182i.this.type == 2) {
                        C27968h.m44531j(C21182i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1), 1, 0);
                    }
                    intent = new Intent();
                    intent.putExtra("Retr_Msg_content", C39283e.m66951a(C21182i.this.nOJ));
                    intent.putExtra("Retr_Msg_Type", 9);
                    C25985d.m41473f(C21182i.this.activity, ".ui.transmit.MsgRetransmitUI", intent);
                    AppMethodBeat.m2505o(113740);
                    return;
                case 2:
                    C21182i.this.czL = 0;
                    C21182i.this.bKK();
                    AppMethodBeat.m2505o(113740);
                    return;
                case 3:
                    C21182i.this.bKJ();
                    AppMethodBeat.m2505o(113740);
                    return;
                case 4:
                    C30379h.m48440a(C21182i.this.activity, C21182i.this.activity.getString(C25738R.string.f9089p5), "", new C69611(), null);
                    AppMethodBeat.m2505o(113740);
                    return;
                case 5:
                    long longExtra = C21182i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_fav_item_id", longExtra);
                    intent2.putExtra("key_fav_scene", 2);
                    C39037b.m66371b(C21182i.this.activity, ".ui.FavTagEditUI", intent2);
                    AppMethodBeat.m2505o(113740);
                    return;
                case 6:
                    intent = new Intent();
                    intent.putExtra("Retr_Msg_content", C39283e.m66951a(C21182i.this.nOJ));
                    intent.putExtra("Retr_Msg_Id", C21182i.this.cvx);
                    C25985d.m41473f(C21182i.this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                    AppMethodBeat.m2505o(113740);
                    return;
                case 7:
                    try {
                        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(C21182i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                        C7060h.pYm.mo8381e(15378, Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_type));
                        C4990ab.m7411d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_type));
                        iE.field_flag = 0;
                        iE.field_updateTime = System.currentTimeMillis();
                        iE.field_localId = -1;
                        iE.field_sourceType = 6;
                        if (iE.field_favProto.wit != null) {
                            iE.field_favProto.wit.alF("");
                            iE.field_favProto.wit.mo39126LN(6);
                            iE.field_favProto.wit.alD(C1853r.m3846Yz());
                        }
                        iE.field_fromUser = C1853r.m3846Yz();
                        LinkedList linkedList = new LinkedList();
                        aar aar = new aar();
                        aas aas = new aas();
                        aas.mo48440a(iE.field_favProto.why);
                        aar.mo27398a(aas);
                        aar.ale("WeNote_0");
                        aar.mo27394LE(6);
                        linkedList.add(0, aar);
                        iE.field_favProto.mo74738aE(linkedList);
                        iE.field_type = 18;
                        iE.field_xml = C27966g.m44521s(iE);
                        abh abh = new abh();
                        Activity activity = C21182i.this.activity;
                        C18313ld c18313ld = new C18313ld();
                        c18313ld.cGU.field_localId = iE.field_localId;
                        c18313ld.cGU.cHa = 5;
                        c18313ld.cGU.cGW = iE.field_xml;
                        c18313ld.cGU.context = activity;
                        Bundle bundle = new Bundle();
                        aaz aaz = iE.field_favProto.vzK;
                        if (aaz != null) {
                            bundle.putString("noteauthor", aaz.wim);
                            bundle.putString("noteeditor", aaz.win);
                        }
                        bundle.putLong("edittime", iE.field_updateTime);
                        c18313ld.cGU.cGZ = bundle;
                        c18313ld.cGU.field_favProto = iE.field_favProto;
                        c18313ld.cGU.type = 2;
                        c18313ld.cGU.cHc = true;
                        c18313ld.cGU.cHd = abh;
                        C4879a.xxA.mo10055m(c18313ld);
                        C21182i.this.activity.finish();
                        AppMethodBeat.m2505o(113740);
                        return;
                    } catch (Throwable th) {
                        Toast.makeText(C21182i.this.activity, C25738R.string.br_, 0).show();
                        break;
                    }
            }
            AppMethodBeat.m2505o(113740);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.i$7 */
    class C211837 implements OnCancelListener {
        C211837() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            C21182i.this.nOP = false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.i$1 */
    class C211841 implements C36073c {
        C211841() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(113738);
            c44273l.mo70049a(1, C21182i.this.getString(C25738R.string.f9228tn), 0);
            if (C21182i.this.type == 1) {
                c44273l.mo70049a(3, C21182i.this.getString(C25738R.string.dcq), 0);
            } else if (C21182i.this.type == 2 && C21182i.this.activity.getIntent().getBooleanExtra("kFavCanDel", true)) {
                c44273l.mo70049a(7, C21182i.this.getString(C25738R.string.br8), 0);
                c44273l.mo70049a(5, C21182i.this.getString(C25738R.string.bo9), 0);
                c44273l.mo70049a(4, C21182i.this.getString(C25738R.string.f9088p4), 0);
            }
            C9321dq c9321dq = new C9321dq();
            c9321dq.cxc.cvx = C21182i.this.cvx;
            C4879a.xxA.mo10055m(c9321dq);
            if (c9321dq.cxd.cwB || C46494g.m87754o(C4996ah.getContext(), 4)) {
                c44273l.mo70049a(6, C21182i.this.getString(C25738R.string.b6w), 0);
            }
            AppMethodBeat.m2505o(113738);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.i$8 */
    class C211858 implements OnClickListener {
        C211858() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113745);
            C21182i.this.bKI();
            AppMethodBeat.m2505o(113745);
        }
    }

    public C21182i(Activity activity) {
        super(activity);
        AppMethodBeat.m2504i(113746);
        C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetSpkEnhance, (C1202f) this);
        AppMethodBeat.m2505o(113746);
    }

    public boolean bKn() {
        AppMethodBeat.m2504i(113747);
        if (this.nRq == null || !this.nRq.isShowing()) {
            bKH();
            this.nRq.cpD();
        } else {
            this.nRq.cpE();
        }
        AppMethodBeat.m2505o(113747);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void bKH() {
        AppMethodBeat.m2504i(113748);
        this.nRq = new C36356d(this.activity, 1, false);
        this.nRq.rBl = new C211841();
        this.nRq.rBm = new C69602();
        AppMethodBeat.m2505o(113748);
    }

    /* Access modifiers changed, original: 0000 */
    public void bKm() {
        AppMethodBeat.m2504i(113749);
        this.nOL.nPb.setEnabled(true);
        this.nOL.nOX.setVisibility(8);
        mo46347b(this.nOJ);
        this.nOL.nLY.getIController().setZoom(this.nJw);
        this.nOL.nOZ.setEnabled(true);
        this.cHc = this.activity.getIntent().getBooleanExtra("kShowshare", true);
        if (this.cHc) {
            this.nOL.nOZ.setVisibility(0);
        } else {
            this.nOL.nOZ.setVisibility(8);
        }
        this.nRo = this.activity.getIntent().getStringExtra("soso_street_view_url");
        if (!C5046bo.isNullOrNil(this.nRo) && (C4988aa.dop() || C4988aa.doo())) {
            this.nRr = true;
        } else if (C4988aa.dop() || C4988aa.doo()) {
            this.nRr = false;
            try {
                buf buf = (buf) new C45453u((float) this.nOJ.nJv, (float) this.nOJ.nJu, this.cvx).ehh.fsG.fsP;
                C45453u c45453u = new C45453u(buf);
                C1720g.m3540Rg().mo14541a(new C45453u(buf), 0);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.ViewMapUI", e.toString());
            }
        }
        this.nOL.nOZ.setOnClickListener(new C33523());
        this.nRp = new C12403n(this.nOL.nLY, this.activity);
        C12403n c12403n = this.nRp;
        if (c12403n.mViewManager != null) {
            c12403n.mViewManager.addView(c12403n.nOz, 0.0d, 0.0d);
            c12403n.mViewManager.setMarkerTag(c12403n.nOz, "info_window_tag");
            if (c12403n.nOC) {
                c12403n.mViewManager.setInfoWindowAdapter(new C12404a(c12403n, (byte) 0));
                c12403n.mViewManager.showInfoWindowByView(c12403n.nOz);
            }
        }
        C12403n c12403n2 = this.nRp;
        LocationInfo locationInfo = this.nOJ;
        c12403n2.nJu = locationInfo.nJu;
        c12403n2.nJv = locationInfo.nJv;
        if (!C39283e.m66955j(this.nOJ.nJu, this.nOJ.nJv)) {
            C4990ab.m7411d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", Double.valueOf(this.nOJ.nJu), Double.valueOf(this.nOJ.nJv));
            c12403n2 = this.nRp;
            c12403n2.nLW = false;
            c12403n2.nOA.setVisibility(8);
        }
        if (2 == this.type) {
            C4990ab.m7417i("MicroMsg.ViewMapUI", "location id %s", this.nOJ.nJt);
            if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                bKj();
            }
            if (!C5046bo.isNullOrNil(this.nOJ.nJx)) {
                this.nOL.nOY.setVisibility(0);
            }
        }
        this.nON.put(this.nOJ.nJt, this.nRp);
        if (this.nOJ.bJp()) {
            if (!(this.eUu == null || this.eUu.equals(""))) {
                this.nRp.eUu = this.eUu;
            }
            this.nRp.setText(this.nRp.getPreText() + this.nOJ.nJx);
        } else if (C39283e.m66955j(this.nOJ.nJu, this.nOJ.nJv)) {
            this.nOO.mo33924a(this.nOJ.nJu, this.nOJ.nJv, this.nOV, this.nOJ.nJt);
        }
        c12403n2 = this.nRp;
        C33534 c33534 = new C33534();
        if (c12403n2.nOC && c12403n2.mViewManager != null) {
            c12403n2.mViewManager.setMarkerClick(c12403n2.nOz, c33534);
        }
        AppMethodBeat.m2505o(113749);
    }

    /* Access modifiers changed, original: protected */
    public void bKD() {
    }

    /* Access modifiers changed, original: protected */
    public void bKB() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKI() {
        AppMethodBeat.m2504i(113750);
        if (this.nRr) {
            C40490t.m69623a(new C14976d());
            Intent intent = new Intent();
            intent.putExtra("show_bottom", false);
            intent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("rawUrl", this.nRo);
            intent.putExtra("title", C25738R.string.dxp);
            intent.putExtra("webview_bg_color_rsID", C25738R.color.f11782h4);
            C25985d.m41467b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.m2505o(113750);
    }

    public void onResume() {
        AppMethodBeat.m2504i(113751);
        super.onResume();
        C4990ab.m7410d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.nOU != null) {
            this.nOU.mo44207b(this.nRt, true);
        }
        AppMethodBeat.m2505o(113751);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(113753);
        super.onCreate(bundle);
        double doubleExtra = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0d);
        C4990ab.m7416i("MicroMsg.ViewMapUI", "start dslat " + doubleExtra + " " + doubleExtra2);
        this.nJw = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
        if (this.nJw <= 0) {
            this.nJw = 15;
        }
        this.eUu = this.activity.getIntent().getStringExtra("kPoiName");
        String stringExtra = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
        C4990ab.m7410d("MicroMsg.ViewMapUI", "view " + doubleExtra + " " + doubleExtra2);
        LocationInfo locationInfo = this.nOJ;
        locationInfo.nJu = doubleExtra;
        locationInfo.nJv = doubleExtra2;
        locationInfo.nJx = stringExtra;
        locationInfo.nJw = this.nJw;
        locationInfo.cIK = this.eUu;
        this.cvx = this.activity.getIntent().getLongExtra("kMsgId", -1);
        this.nKN = this.activity.getIntent().getStringExtra("map_talker_name");
        initView();
        AppMethodBeat.m2505o(113753);
    }

    /* Access modifiers changed, original: protected */
    public void bKl() {
        AppMethodBeat.m2504i(113754);
        Intent intent = new Intent();
        intent.putExtra("kopenGmapNums", this.nOI.nLB);
        intent.putExtra("kopenOthersNums", this.nOI.nLC);
        intent.putExtra("kopenreportType", this.nOI.cKB);
        intent.putExtra("kRemark", bKk());
        intent.putExtra("soso_street_view_url", this.nRo);
        this.activity.setResult(-1, intent);
        AppMethodBeat.m2505o(113754);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKJ() {
        AppMethodBeat.m2504i(113755);
        C4990ab.m7411d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", Double.valueOf(this.nOJ.nJu), Double.valueOf(this.nOJ.nJv));
        Intent intent = new Intent();
        intent.putExtra("kfavorite", true);
        intent.putExtra("kopenGmapNums", this.nOI.nLB);
        intent.putExtra("kopenOthersNums", this.nOI.nLC);
        intent.putExtra("kopenreportType", this.nOI.cKB);
        intent.putExtra("kRemark", bKk());
        intent.putExtra("kwebmap_slat", this.nOJ.nJu);
        intent.putExtra("kwebmap_lng", this.nOJ.nJv);
        intent.putExtra("Kwebmap_locaion", this.nOJ.nJx);
        intent.putExtra("kPoiName", this.eUu);
        this.activity.setResult(-1, intent);
        this.activity.getIntent().getIntExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        this.activity.getIntent().getIntExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        this.activity.finish();
        AppMethodBeat.m2505o(113755);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKK() {
        AppMethodBeat.m2504i(113756);
        C7060h.pYm.mo8381e(12809, Integer.valueOf(3), "");
        C4990ab.m7411d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", Double.valueOf(this.nOJ.nJu), Double.valueOf(this.nOJ.nJv), Double.valueOf(this.nOK.nJu), Double.valueOf(this.nOK.nJv));
        if (this.nOK.bJo()) {
            bKD();
            AppMethodBeat.m2505o(113756);
            return;
        }
        this.nOP = true;
        if (this.handler == null) {
            AppMethodBeat.m2505o(113756);
            return;
        }
        if (this.nRs != null) {
            this.handler.removeCallbacks(this.nRs);
        }
        this.nRs = new C33556();
        this.handler.postDelayed(this.nRs, 10000);
        Context context = this.activity;
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, getString(C25738R.string.c9p), true, new C211837());
        AppMethodBeat.m2505o(113756);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(113757);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4098:
            case 4099:
                C34412d c34412d = this.nOI;
                Intent intent2;
                switch (i) {
                    case 4098:
                        Bundle bundleExtra;
                        ArrayList parcelableArrayList;
                        if (-1 == i2 && intent != null) {
                            String stringExtra = intent.getStringExtra("selectpkg");
                            bundleExtra = intent.getBundleExtra("transferback");
                            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                            parcelableArrayList = bundleExtra.getParcelableArrayList("locations");
                            c34412d.mo54920a((LocationInfo) parcelableArrayList.get(0), (LocationInfo) parcelableArrayList.get(1), stringExtra, booleanExtra);
                            AppMethodBeat.m2505o(113757);
                            return;
                        } else if (4097 == i2) {
                            if (intent.getBooleanExtra("isalways", false)) {
                                C7060h.pYm.mo8381e(11091, Integer.valueOf(6), Integer.valueOf(2));
                            } else {
                                C7060h.pYm.mo8381e(11091, Integer.valueOf(6), Integer.valueOf(1));
                            }
                            parcelableArrayList = intent.getBundleExtra("transferback").getParcelableArrayList("locations");
                            LocationInfo locationInfo = (LocationInfo) parcelableArrayList.get(0);
                            LocationInfo locationInfo2 = (LocationInfo) parcelableArrayList.get(1);
                            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(C5046bo.isNullOrNil(locationInfo.nJy) ? "zh-cn" : locationInfo.nJy)), new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)})));
                            bundleExtra = new Bundle();
                            bundleExtra.putParcelable("targetintent", intent3);
                            intent2 = new Intent();
                            intent2.setClass(c34412d.context, AppChooserUI.class);
                            intent2.putExtra("type", 1);
                            intent2.putExtra("title", c34412d.context.getResources().getString(C25738R.string.cnc));
                            intent2.putExtra("targetintent", intent3);
                            intent2.putExtra("transferback", bundleExtra);
                            intent2.putExtra("scene", 6);
                            ((Activity) c34412d.context).startActivityForResult(intent2, 4099);
                            AppMethodBeat.m2505o(113757);
                            return;
                        }
                        break;
                    case 4099:
                        if (-1 == i2 && intent != null) {
                            String stringExtra2 = intent.getStringExtra("selectpkg");
                            intent2 = new Intent((Intent) intent.getBundleExtra("transferback").getParcelable("targetintent"));
                            intent2.setPackage(stringExtra2);
                            intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                            c34412d.context.startActivity(intent2);
                            break;
                        }
                }
                break;
        }
        AppMethodBeat.m2505o(113757);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(113758);
        this.ext.release();
        this.handler.removeCallbacks(this.nRs);
        this.handler = null;
        C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetSpkEnhance, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(113758);
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        AppMethodBeat.m2504i(113759);
        String string = getString(C25738R.string.cnm);
        AppMethodBeat.m2505o(113759);
        return string;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(113760);
        switch (motionEvent.getAction()) {
            case 0:
                this.neG = motionEvent.getX();
                this.neH = motionEvent.getY();
                this.nOa = System.currentTimeMillis();
                this.hOy = false;
                bKC();
                break;
            case 1:
                if (!this.hOy) {
                    System.currentTimeMillis();
                    break;
                }
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.neG) > 10.0f || Math.abs(motionEvent.getY() - this.neH) > 10.0f) {
                    this.hOy = true;
                    bKA();
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(113760);
        return dispatchTouchEvent;
    }

    public void bKA() {
    }

    public void bKC() {
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(113761);
        C4990ab.m7411d("MicroMsg.ViewMapUI", "onScene end %d %d %d", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (c1207m.getType() != v2helper.EMethodSetSpkEnhance) {
            C4990ab.m7413e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        } else if (i2 == 0 && i == 0) {
            String tu = C45453u.m83729tu(((C45453u) c1207m).ajC().vOt);
            C4990ab.m7411d("MicroMsg.ViewMapUI", "getUrl success! url is %s", tu);
            this.nRo = tu;
            if (!C5046bo.isNullOrNil(tu)) {
                this.nRr = true;
            }
            if (this.type == 9 && !C5046bo.isNullOrNil(tu)) {
                TextView textView = (TextView) findViewById(2131824675);
                textView.setVisibility(0);
                textView.setOnClickListener(new C211858());
            }
            AppMethodBeat.m2505o(113761);
            return;
        }
        AppMethodBeat.m2505o(113761);
    }

    public void onPause() {
        AppMethodBeat.m2504i(113752);
        C4990ab.m7410d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.nOU != null) {
            this.nOU.mo44208c(this.nRt);
        }
        super.onPause();
        AppMethodBeat.m2505o(113752);
    }
}
