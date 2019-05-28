package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.LinkedList;

public class i extends a implements f {
    private boolean cHc = true;
    protected long cvx = -1;
    public d ext = new d(this.activity);
    private boolean hOy = false;
    private long nOa = 0;
    private String nRo = "";
    n nRp;
    com.tencent.mm.ui.widget.a.d nRq;
    boolean nRr = false;
    private Runnable nRs;
    private a nRt = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(113743);
            if (z) {
                ab.d("MicroMsg.ViewMapUI", "onGetLocation flong " + f + " flat " + f2);
                if (((double) f2) == 0.0d && ((double) f) == 0.0d) {
                    AppMethodBeat.o(113743);
                    return true;
                }
                ab.d("MicroMsg.ViewMapUI", "myLocation " + i.this.nOK.nJu + " " + i.this.nOK.nJv);
                ab.d("MicroMsg.ViewMapUI", "location my show");
                i.this.nOK.nJu = (double) f2;
                i.this.nOK.nJv = (double) f;
                i.this.nOO.a(i.this.nOK.nJu, i.this.nOK.nJv, i.this.nOV, i.this.nOK.nJt);
                AppMethodBeat.o(113743);
                return true;
            }
            AppMethodBeat.o(113743);
            return false;
        }
    };

    public i(Activity activity) {
        super(activity);
        AppMethodBeat.i(113746);
        g.Rg().a((int) v2helper.EMethodSetSpkEnhance, (f) this);
        AppMethodBeat.o(113746);
    }

    public boolean bKn() {
        AppMethodBeat.i(113747);
        if (this.nRq == null || !this.nRq.isShowing()) {
            bKH();
            this.nRq.cpD();
        } else {
            this.nRq.cpE();
        }
        AppMethodBeat.o(113747);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void bKH() {
        AppMethodBeat.i(113748);
        this.nRq = new com.tencent.mm.ui.widget.a.d(this.activity, 1, false);
        this.nRq.rBl = new c() {
            public final void a(l lVar) {
                AppMethodBeat.i(113738);
                lVar.a(1, i.this.getString(R.string.tn), 0);
                if (i.this.type == 1) {
                    lVar.a(3, i.this.getString(R.string.dcq), 0);
                } else if (i.this.type == 2 && i.this.activity.getIntent().getBooleanExtra("kFavCanDel", true)) {
                    lVar.a(7, i.this.getString(R.string.br8), 0);
                    lVar.a(5, i.this.getString(R.string.bo9), 0);
                    lVar.a(4, i.this.getString(R.string.p4), 0);
                }
                dq dqVar = new dq();
                dqVar.cxc.cvx = i.this.cvx;
                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                if (dqVar.cxd.cwB || com.tencent.mm.pluginsdk.model.app.g.o(ah.getContext(), 4)) {
                    lVar.a(6, i.this.getString(R.string.b6w), 0);
                }
                AppMethodBeat.o(113738);
            }
        };
        this.nRq.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(113740);
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 0:
                        i.this.bKI();
                        AppMethodBeat.o(113740);
                        return;
                    case 1:
                        if (i.this.type == 2) {
                            h.j(i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1), 1, 0);
                        }
                        intent = new Intent();
                        intent.putExtra("Retr_Msg_content", e.a(i.this.nOJ));
                        intent.putExtra("Retr_Msg_Type", 9);
                        com.tencent.mm.bp.d.f(i.this.activity, ".ui.transmit.MsgRetransmitUI", intent);
                        AppMethodBeat.o(113740);
                        return;
                    case 2:
                        i.this.czL = 0;
                        i.this.bKK();
                        AppMethodBeat.o(113740);
                        return;
                    case 3:
                        i.this.bKJ();
                        AppMethodBeat.o(113740);
                        return;
                    case 4:
                        com.tencent.mm.ui.base.h.a(i.this.activity, i.this.activity.getString(R.string.p5), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(113739);
                                long longExtra = i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                                cg cgVar = new cg();
                                cgVar.cvt.cvv = longExtra;
                                com.tencent.mm.sdk.b.a.xxA.m(cgVar);
                                ab.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", Long.valueOf(longExtra), Boolean.valueOf(bo.a(Boolean.valueOf(cgVar.cvu.cvi), false)));
                                if (bo.a(Boolean.valueOf(cgVar.cvu.cvi), false)) {
                                    i.this.activity.finish();
                                }
                                AppMethodBeat.o(113739);
                            }
                        }, null);
                        AppMethodBeat.o(113740);
                        return;
                    case 5:
                        long longExtra = i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_fav_item_id", longExtra);
                        intent2.putExtra("key_fav_scene", 2);
                        b.b(i.this.activity, ".ui.FavTagEditUI", intent2);
                        AppMethodBeat.o(113740);
                        return;
                    case 6:
                        intent = new Intent();
                        intent.putExtra("Retr_Msg_content", e.a(i.this.nOJ));
                        intent.putExtra("Retr_Msg_Id", i.this.cvx);
                        com.tencent.mm.bp.d.f(i.this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        AppMethodBeat.o(113740);
                        return;
                    case 7:
                        try {
                            com.tencent.mm.plugin.fav.a.g iE = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                            com.tencent.mm.plugin.report.service.h.pYm.e(15378, Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_type));
                            ab.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_type));
                            iE.field_flag = 0;
                            iE.field_updateTime = System.currentTimeMillis();
                            iE.field_localId = -1;
                            iE.field_sourceType = 6;
                            if (iE.field_favProto.wit != null) {
                                iE.field_favProto.wit.alF("");
                                iE.field_favProto.wit.LN(6);
                                iE.field_favProto.wit.alD(r.Yz());
                            }
                            iE.field_fromUser = r.Yz();
                            LinkedList linkedList = new LinkedList();
                            aar aar = new aar();
                            aas aas = new aas();
                            aas.a(iE.field_favProto.why);
                            aar.a(aas);
                            aar.ale("WeNote_0");
                            aar.LE(6);
                            linkedList.add(0, aar);
                            iE.field_favProto.aE(linkedList);
                            iE.field_type = 18;
                            iE.field_xml = com.tencent.mm.plugin.fav.a.g.s(iE);
                            abh abh = new abh();
                            Activity activity = i.this.activity;
                            ld ldVar = new ld();
                            ldVar.cGU.field_localId = iE.field_localId;
                            ldVar.cGU.cHa = 5;
                            ldVar.cGU.cGW = iE.field_xml;
                            ldVar.cGU.context = activity;
                            Bundle bundle = new Bundle();
                            aaz aaz = iE.field_favProto.vzK;
                            if (aaz != null) {
                                bundle.putString("noteauthor", aaz.wim);
                                bundle.putString("noteeditor", aaz.win);
                            }
                            bundle.putLong("edittime", iE.field_updateTime);
                            ldVar.cGU.cGZ = bundle;
                            ldVar.cGU.field_favProto = iE.field_favProto;
                            ldVar.cGU.type = 2;
                            ldVar.cGU.cHc = true;
                            ldVar.cGU.cHd = abh;
                            com.tencent.mm.sdk.b.a.xxA.m(ldVar);
                            i.this.activity.finish();
                            AppMethodBeat.o(113740);
                            return;
                        } catch (Throwable th) {
                            Toast.makeText(i.this.activity, R.string.br_, 0).show();
                            break;
                        }
                }
                AppMethodBeat.o(113740);
            }
        };
        AppMethodBeat.o(113748);
    }

    /* Access modifiers changed, original: 0000 */
    public void bKm() {
        AppMethodBeat.i(113749);
        this.nOL.nPb.setEnabled(true);
        this.nOL.nOX.setVisibility(8);
        b(this.nOJ);
        this.nOL.nLY.getIController().setZoom(this.nJw);
        this.nOL.nOZ.setEnabled(true);
        this.cHc = this.activity.getIntent().getBooleanExtra("kShowshare", true);
        if (this.cHc) {
            this.nOL.nOZ.setVisibility(0);
        } else {
            this.nOL.nOZ.setVisibility(8);
        }
        this.nRo = this.activity.getIntent().getStringExtra("soso_street_view_url");
        if (!bo.isNullOrNil(this.nRo) && (aa.dop() || aa.doo())) {
            this.nRr = true;
        } else if (aa.dop() || aa.doo()) {
            this.nRr = false;
            try {
                buf buf = (buf) new u((float) this.nOJ.nJv, (float) this.nOJ.nJu, this.cvx).ehh.fsG.fsP;
                u uVar = new u(buf);
                g.Rg().a(new u(buf), 0);
            } catch (Exception e) {
                ab.e("MicroMsg.ViewMapUI", e.toString());
            }
        }
        this.nOL.nOZ.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113741);
                i.this.bKH();
                i.this.nRq.cpD();
                AppMethodBeat.o(113741);
            }
        });
        this.nRp = new n(this.nOL.nLY, this.activity);
        n nVar = this.nRp;
        if (nVar.mViewManager != null) {
            nVar.mViewManager.addView(nVar.nOz, 0.0d, 0.0d);
            nVar.mViewManager.setMarkerTag(nVar.nOz, "info_window_tag");
            if (nVar.nOC) {
                nVar.mViewManager.setInfoWindowAdapter(new n.a(nVar, (byte) 0));
                nVar.mViewManager.showInfoWindowByView(nVar.nOz);
            }
        }
        n nVar2 = this.nRp;
        LocationInfo locationInfo = this.nOJ;
        nVar2.nJu = locationInfo.nJu;
        nVar2.nJv = locationInfo.nJv;
        if (!e.j(this.nOJ.nJu, this.nOJ.nJv)) {
            ab.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", Double.valueOf(this.nOJ.nJu), Double.valueOf(this.nOJ.nJv));
            nVar2 = this.nRp;
            nVar2.nLW = false;
            nVar2.nOA.setVisibility(8);
        }
        if (2 == this.type) {
            ab.i("MicroMsg.ViewMapUI", "location id %s", this.nOJ.nJt);
            if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                bKj();
            }
            if (!bo.isNullOrNil(this.nOJ.nJx)) {
                this.nOL.nOY.setVisibility(0);
            }
        }
        this.nON.put(this.nOJ.nJt, this.nRp);
        if (this.nOJ.bJp()) {
            if (!(this.eUu == null || this.eUu.equals(""))) {
                this.nRp.eUu = this.eUu;
            }
            this.nRp.setText(this.nRp.getPreText() + this.nOJ.nJx);
        } else if (e.j(this.nOJ.nJu, this.nOJ.nJv)) {
            this.nOO.a(this.nOJ.nJu, this.nOJ.nJv, this.nOV, this.nOJ.nJt);
        }
        nVar2 = this.nRp;
        AnonymousClass4 anonymousClass4 = new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113742);
                i.this.czL = 0;
                i.this.bKB();
                i.this.bKK();
                AppMethodBeat.o(113742);
            }
        };
        if (nVar2.nOC && nVar2.mViewManager != null) {
            nVar2.mViewManager.setMarkerClick(nVar2.nOz, anonymousClass4);
        }
        AppMethodBeat.o(113749);
    }

    /* Access modifiers changed, original: protected */
    public void bKD() {
    }

    /* Access modifiers changed, original: protected */
    public void bKB() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKI() {
        AppMethodBeat.i(113750);
        if (this.nRr) {
            t.a(new com.tencent.mm.pluginsdk.ui.tools.d());
            Intent intent = new Intent();
            intent.putExtra("show_bottom", false);
            intent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("rawUrl", this.nRo);
            intent.putExtra("title", R.string.dxp);
            intent.putExtra("webview_bg_color_rsID", R.color.h4);
            com.tencent.mm.bp.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(113750);
    }

    public void onResume() {
        AppMethodBeat.i(113751);
        super.onResume();
        ab.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.nOU != null) {
            this.nOU.b(this.nRt, true);
        }
        AppMethodBeat.o(113751);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113753);
        super.onCreate(bundle);
        double doubleExtra = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0d);
        ab.i("MicroMsg.ViewMapUI", "start dslat " + doubleExtra + " " + doubleExtra2);
        this.nJw = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
        if (this.nJw <= 0) {
            this.nJw = 15;
        }
        this.eUu = this.activity.getIntent().getStringExtra("kPoiName");
        String stringExtra = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
        ab.d("MicroMsg.ViewMapUI", "view " + doubleExtra + " " + doubleExtra2);
        LocationInfo locationInfo = this.nOJ;
        locationInfo.nJu = doubleExtra;
        locationInfo.nJv = doubleExtra2;
        locationInfo.nJx = stringExtra;
        locationInfo.nJw = this.nJw;
        locationInfo.cIK = this.eUu;
        this.cvx = this.activity.getIntent().getLongExtra("kMsgId", -1);
        this.nKN = this.activity.getIntent().getStringExtra("map_talker_name");
        initView();
        AppMethodBeat.o(113753);
    }

    /* Access modifiers changed, original: protected */
    public void bKl() {
        AppMethodBeat.i(113754);
        Intent intent = new Intent();
        intent.putExtra("kopenGmapNums", this.nOI.nLB);
        intent.putExtra("kopenOthersNums", this.nOI.nLC);
        intent.putExtra("kopenreportType", this.nOI.cKB);
        intent.putExtra("kRemark", bKk());
        intent.putExtra("soso_street_view_url", this.nRo);
        this.activity.setResult(-1, intent);
        AppMethodBeat.o(113754);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKJ() {
        AppMethodBeat.i(113755);
        ab.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", Double.valueOf(this.nOJ.nJu), Double.valueOf(this.nOJ.nJv));
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
        AppMethodBeat.o(113755);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKK() {
        AppMethodBeat.i(113756);
        com.tencent.mm.plugin.report.service.h.pYm.e(12809, Integer.valueOf(3), "");
        ab.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", Double.valueOf(this.nOJ.nJu), Double.valueOf(this.nOJ.nJv), Double.valueOf(this.nOK.nJu), Double.valueOf(this.nOK.nJv));
        if (this.nOK.bJo()) {
            bKD();
            AppMethodBeat.o(113756);
            return;
        }
        this.nOP = true;
        if (this.handler == null) {
            AppMethodBeat.o(113756);
            return;
        }
        if (this.nRs != null) {
            this.handler.removeCallbacks(this.nRs);
        }
        this.nRs = new Runnable() {
            public final void run() {
                AppMethodBeat.i(113744);
                if (i.this.nOP) {
                    if (i.this.ehJ != null) {
                        i.this.ehJ.dismiss();
                    }
                    i.this.bKD();
                }
                i.this.nOP = false;
                AppMethodBeat.o(113744);
            }
        };
        this.handler.postDelayed(this.nRs, 10000);
        Context context = this.activity;
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b(context, getString(R.string.c9p), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                i.this.nOP = false;
            }
        });
        AppMethodBeat.o(113756);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(113757);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4098:
            case 4099:
                com.tencent.mm.plugin.location.ui.d dVar = this.nOI;
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
                            dVar.a((LocationInfo) parcelableArrayList.get(0), (LocationInfo) parcelableArrayList.get(1), stringExtra, booleanExtra);
                            AppMethodBeat.o(113757);
                            return;
                        } else if (4097 == i2) {
                            if (intent.getBooleanExtra("isalways", false)) {
                                com.tencent.mm.plugin.report.service.h.pYm.e(11091, Integer.valueOf(6), Integer.valueOf(2));
                            } else {
                                com.tencent.mm.plugin.report.service.h.pYm.e(11091, Integer.valueOf(6), Integer.valueOf(1));
                            }
                            parcelableArrayList = intent.getBundleExtra("transferback").getParcelableArrayList("locations");
                            LocationInfo locationInfo = (LocationInfo) parcelableArrayList.get(0);
                            LocationInfo locationInfo2 = (LocationInfo) parcelableArrayList.get(1);
                            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(bo.isNullOrNil(locationInfo.nJy) ? "zh-cn" : locationInfo.nJy)), new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)})));
                            bundleExtra = new Bundle();
                            bundleExtra.putParcelable("targetintent", intent3);
                            intent2 = new Intent();
                            intent2.setClass(dVar.context, AppChooserUI.class);
                            intent2.putExtra("type", 1);
                            intent2.putExtra("title", dVar.context.getResources().getString(R.string.cnc));
                            intent2.putExtra("targetintent", intent3);
                            intent2.putExtra("transferback", bundleExtra);
                            intent2.putExtra("scene", 6);
                            ((Activity) dVar.context).startActivityForResult(intent2, 4099);
                            AppMethodBeat.o(113757);
                            return;
                        }
                        break;
                    case 4099:
                        if (-1 == i2 && intent != null) {
                            String stringExtra2 = intent.getStringExtra("selectpkg");
                            intent2 = new Intent((Intent) intent.getBundleExtra("transferback").getParcelable("targetintent"));
                            intent2.setPackage(stringExtra2);
                            intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                            dVar.context.startActivity(intent2);
                            break;
                        }
                }
                break;
        }
        AppMethodBeat.o(113757);
    }

    public void onDestroy() {
        AppMethodBeat.i(113758);
        this.ext.release();
        this.handler.removeCallbacks(this.nRs);
        this.handler = null;
        g.Rg().b((int) v2helper.EMethodSetSpkEnhance, (f) this);
        super.onDestroy();
        AppMethodBeat.o(113758);
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        AppMethodBeat.i(113759);
        String string = getString(R.string.cnm);
        AppMethodBeat.o(113759);
        return string;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(113760);
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
        AppMethodBeat.o(113760);
        return dispatchTouchEvent;
    }

    public void bKA() {
    }

    public void bKC() {
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(113761);
        ab.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (mVar.getType() != v2helper.EMethodSetSpkEnhance) {
            ab.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        } else if (i2 == 0 && i == 0) {
            String tu = u.tu(((u) mVar).ajC().vOt);
            ab.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", tu);
            this.nRo = tu;
            if (!bo.isNullOrNil(tu)) {
                this.nRr = true;
            }
            if (this.type == 9 && !bo.isNullOrNil(tu)) {
                TextView textView = (TextView) findViewById(R.id.c_n);
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(113745);
                        i.this.bKI();
                        AppMethodBeat.o(113745);
                    }
                });
            }
            AppMethodBeat.o(113761);
            return;
        }
        AppMethodBeat.o(113761);
    }

    public void onPause() {
        AppMethodBeat.i(113752);
        ab.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.nOU != null) {
            this.nOU.c(this.nRt);
        }
        super.onPause();
        AppMethodBeat.o(113752);
    }
}
