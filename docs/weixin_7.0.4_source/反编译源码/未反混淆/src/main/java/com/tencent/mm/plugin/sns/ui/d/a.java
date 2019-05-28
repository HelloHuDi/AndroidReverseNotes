package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.c;
import com.tencent.mm.plugin.sns.a.b.j.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsBrowseUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class a implements f, d {
    private Activity activity;
    private int cvd;
    private ClipboardManager mmO = ((ClipboardManager) ah.getContext().getSystemService("clipboard"));
    private String rJA;
    private TimeLineObject rJB;
    private View rJz;
    private p rhB;
    private ae rhQ;

    public final void bIB() {
        AppMethodBeat.i(40230);
        g.RQ();
        g.RO().eJo.a(218, (f) this);
        AppMethodBeat.o(40230);
    }

    public final void removeListener() {
        AppMethodBeat.i(40231);
        g.RQ();
        g.RO().eJo.b(218, (f) this);
        AppMethodBeat.o(40231);
    }

    public a(Activity activity, int i, ae aeVar) {
        AppMethodBeat.i(40232);
        this.activity = activity;
        this.cvd = i;
        this.rhQ = aeVar;
        AppMethodBeat.o(40232);
    }

    public final void a(View view, String str, TimeLineObject timeLineObject) {
        this.rJz = view;
        this.rJA = str;
        this.rJB = timeLineObject;
    }

    private String cuX() {
        AppMethodBeat.i(40233);
        if (this.rJz != null && (this.rJz.getTag() instanceof ar) && ((ar) this.rJz.getTag()).ctI()) {
            b Ye = ap.Ye(af.cnF().YT(this.rJA).cqA());
            if (Ye != null) {
                String str = Ye.result;
                AppMethodBeat.o(40233);
                return str;
            }
        }
        AppMethodBeat.o(40233);
        return null;
    }

    private com.tencent.mm.plugin.sns.storage.a f(n nVar) {
        AppMethodBeat.i(40234);
        com.tencent.mm.plugin.sns.storage.a cqr;
        if (nVar == null) {
            AppMethodBeat.o(40234);
            return null;
        } else if (this.cvd == 2) {
            cqr = nVar.cqr();
            AppMethodBeat.o(40234);
            return cqr;
        } else {
            cqr = nVar.cqq();
            AppMethodBeat.o(40234);
            return cqr;
        }
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.i(40235);
        if (this.rJz == null) {
            AppMethodBeat.o(40235);
            return;
        }
        CharSequence cuX;
        com.tencent.mm.plugin.secinforeport.a.a aVar;
        cl clVar;
        n YT;
        String nW;
        v.b y;
        long anT;
        n YT2;
        bau bau;
        TimeLineObject timeLineObject;
        abf abf;
        abl abl;
        String cqA;
        l lVar;
        n YT3;
        Intent intent;
        cl clVar2;
        com.tencent.mm.modelsns.b lY;
        n YS;
        switch (menuItem.getItemId()) {
            case 0:
                cuX = cuX();
                if (bo.isNullOrNil(cuX)) {
                    cuX = this.rJB.xfF;
                }
                this.mmO.setText(cuX);
                h.bQ(this.activity, this.activity.getString(R.string.oz));
                aVar = com.tencent.mm.plugin.secinforeport.a.a.qjm;
                com.tencent.mm.plugin.secinforeport.a.a.h(2, this.rJB.Id, bo.ana(cuX));
                AppMethodBeat.o(40235);
                return;
            case 1:
                cuX = cuX();
                if (bo.isNullOrNil(cuX)) {
                    cuX = this.rJB.xfF;
                }
                this.rhQ.cnj().gg(this.rJA, this.rJB.Id);
                clVar = new cl();
                com.tencent.mm.plugin.sns.j.a.a(clVar, this.rJA, cuX);
                clVar.cvA.activity = this.activity;
                clVar.cvA.cvH = 30;
                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                AppMethodBeat.o(40235);
                return;
            case 2:
                this.rhQ.cnj().gg(this.rJA, this.rJB.Id);
                clVar = new cl();
                YT = com.tencent.mm.plugin.sns.storage.h.YT(this.rJA);
                if (YT.DI(32) && YT.cqo().coK()) {
                    ZP(this.rJA);
                } else if (this.rJB.dtW == 1) {
                    com.tencent.mm.plugin.sns.j.a.a(clVar, this.rJA, 0);
                    clVar.cvA.activity = this.activity;
                    clVar.cvA.cvH = 31;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                } else {
                    com.tencent.mm.plugin.sns.j.a.a(clVar, this.rJA, ((ao) this.rJz.getTag()).index);
                    clVar.cvA.activity = this.activity;
                    clVar.cvA.cvH = 31;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                }
                if (YT.DI(32)) {
                    i.a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT.field_snsId, 11, 0));
                }
                AppMethodBeat.o(40235);
                return;
            case 3:
                this.rhQ.cnj().gg(this.rJA, this.rJB.Id);
                String ZJ = au.ZJ(this.rJB.xfI.Url);
                if (bo.isNullOrNil(ZJ)) {
                    ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                    AppMethodBeat.o(40235);
                    return;
                }
                cl clVar3 = new cl();
                n YT4 = com.tencent.mm.plugin.sns.storage.h.YT(this.rJA);
                if (YT4 != null) {
                    nW = v.nW(YT4.field_snsId);
                    y = v.Zp().y(nW, true);
                    y.j("prePublishId", "sns_" + i.jV(YT4.field_snsId));
                    y.j("preUsername", YT4.field_userName);
                    y.j("preChatName", "");
                    y.j("url", ZJ);
                    y.j("preMsgIndex", Integer.valueOf(0));
                    y.j("sendAppMsgScene", Integer.valueOf(1));
                    y.j("adExtStr", YT4.cqu().rjC);
                    clVar3.cvA.cvF = nW;
                }
                YT = af.cnF().YT(this.rJA);
                if (YT != null && this.rJB.xfI.wbJ == 18) {
                    j.a(j.d.AdUrl, c.Fav, e.Samll, 0, YT, this.cvd);
                }
                if (bo.isNullOrNil(this.rJB.rCK)) {
                    if (YT.DI(32)) {
                        i.a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT4.field_snsId, 11, 0));
                    }
                    com.tencent.mm.plugin.sns.j.a.a(clVar3, ZJ, this.rJA);
                    clVar3.cvA.activity = this.activity;
                    clVar3.cvA.cvH = 28;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar3);
                    if (clVar3.cvB.ret == 0) {
                        anT = bo.anT();
                        if (!bo.isNullOrNil(ZJ)) {
                            ab.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), ZJ, Long.valueOf(anT), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1));
                            nW = "";
                            try {
                                nW = URLEncoder.encode(ZJ, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                ab.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e, "", new Object[0]);
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.e(13378, nW, Long.valueOf(anT), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1));
                        }
                    }
                    AppMethodBeat.o(40235);
                    return;
                }
                ZP(YT.cqU());
                AppMethodBeat.o(40235);
                return;
            case 4:
                this.rhQ.cnj().gg(this.rJA, this.rJB.Id);
                YT2 = af.cnF().YT(this.rJA);
                if (this.rJB.xfI.wbK.size() != 0) {
                    bau = (bau) this.rJB.xfI.wbK.get(0);
                    if (YT2 == null || bau == null) {
                        ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                        AppMethodBeat.o(40235);
                        return;
                    }
                    cl clVar4 = new cl();
                    if (bau == null || YT2 == null || YT2.reX == 0) {
                        ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                        clVar4.cvA.cvG = R.string.boh;
                    } else if (af.cnn()) {
                        ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                        clVar4.cvA.cvG = R.string.boz;
                    } else {
                        String jV = i.jV(YT2.field_snsId);
                        jV = String.format("%s#%s", new Object[]{jV, bau.Id});
                        abf abf2 = new abf();
                        abl abl2 = new abl();
                        ab.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", YT2.field_userName);
                        abl2.alD(YT2.field_userName);
                        abl2.alE(r.Yz());
                        abl2.LN(2);
                        abl2.ml(((long) YT2.field_createTime) * 1000);
                        abl2.alI(YT2.cqA());
                        abl2.alF(jV);
                        aar aar = new aar();
                        aar.akZ(jV);
                        aar.akO(bau.Url);
                        aar.akP(bau.wEL);
                        aar.akN(YT2.cqu().xfI.Url);
                        jV = an.fZ(af.getAccSnsPath(), bau.Id) + i.e(bau);
                        if (com.tencent.mm.vfs.e.ct(jV)) {
                            aar.akW(jV);
                        } else {
                            aar.oY(true);
                            aar.akQ(bau.wEH);
                            abu abu = new abu();
                            abu.alT(bau.wEH);
                            abf2.b(abu);
                        }
                        aar.LE(7);
                        aar.akH(bau.Title);
                        aar.akI(bau.Desc);
                        aar.oX(true);
                        abf2.wiv.add(aar);
                        abf2.a(abl2);
                        clVar4.cvA.cvC = abf2;
                        clVar4.cvA.type = 7;
                        com.tencent.mm.plugin.sns.j.a.a(aar, YT2);
                    }
                    clVar4.cvA.activity = this.activity;
                    clVar4.cvA.cvH = 25;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar4);
                }
                AppMethodBeat.o(40235);
                return;
            case 5:
                this.rhQ.cnj().gg(this.rJA, this.rJB.Id);
                if (this.rJB != null) {
                    clVar = new cl();
                    timeLineObject = this.rJB;
                    if (timeLineObject == null) {
                        ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                        clVar.cvA.cvG = R.string.boh;
                    } else {
                        abf = new abf();
                        abl = new abl();
                        abe abe = new abe();
                        abl.alD(timeLineObject.jBB);
                        abl.alE(r.Yz());
                        abl.LN(2);
                        abl.ml(bo.anU());
                        if (timeLineObject.xfH != null) {
                            abl.alJ(timeLineObject.xfH.Id);
                        }
                        if (timeLineObject.xfI != null) {
                            abe.alw(timeLineObject.xfI.Title);
                            abe.alx(timeLineObject.xfI.Desc);
                            if (!(timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.isEmpty())) {
                                bau = (bau) timeLineObject.xfI.wbK.get(0);
                                abe.LK(bau.cuu);
                                abe.alz(bau.rik);
                                abe.aly(bau.wEH);
                            }
                        }
                        clVar.cvA.title = abe.title;
                        clVar.cvA.desc = abe.desc;
                        clVar.cvA.cvC = abf;
                        clVar.cvA.type = 10;
                        abf.a(abl);
                        abf.b(abe);
                    }
                    clVar.cvA.activity = this.activity;
                    clVar.cvA.cvH = 26;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                    AppMethodBeat.o(40235);
                    return;
                }
                break;
            case 7:
                com.tencent.mm.plugin.sns.model.r rVar;
                cqA = af.cnF().YT(this.rJA).cqA();
                lVar = (l) this.rJz.getTag();
                m rVar2;
                if (com.tencent.mm.plugin.sns.storage.v.Zl(cqA)) {
                    rVar2 = new com.tencent.mm.plugin.sns.model.r(com.tencent.mm.plugin.sns.storage.v.Zm(cqA), 6, lVar.qJj);
                    g.RQ();
                    g.RO().eJo.a(rVar2, 0);
                    rVar = rVar2;
                } else {
                    rVar2 = new com.tencent.mm.plugin.sns.model.r(com.tencent.mm.plugin.sns.storage.v.Zm(cqA), 4, lVar.qJj);
                    g.RQ();
                    g.RO().eJo.a(rVar2, 0);
                    m rVar3 = rVar2;
                }
                Context context = this.activity;
                this.activity.getString(R.string.tz);
                this.rhB = h.b(context, this.activity.getString(R.string.ek6), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(40229);
                        g.RQ();
                        g.RO().eJo.c(rVar3);
                        AppMethodBeat.o(40229);
                    }
                });
                AppMethodBeat.o(40235);
                return;
            case 8:
                YT3 = af.cnF().YT(this.rJA);
                if (YT3 != null) {
                    com.tencent.mm.plugin.sns.abtest.a.b(YT3);
                    intent = new Intent();
                    intent.putExtra("sns_permission_snsinfo_svr_id", YT3.field_snsId);
                    intent.putExtra("sns_permission_userName", YT3.field_userName);
                    intent.putExtra("sns_permission_anim", true);
                    intent.setClass(this.activity, SnsPermissionUI.class);
                    this.activity.startActivityForResult(intent, 11);
                    AppMethodBeat.o(40235);
                    return;
                }
                break;
            case 9:
                this.rhQ.cnj().gg(this.rJA, this.rJB.Id);
                if (this.rJB != null) {
                    clVar = new cl();
                    timeLineObject = this.rJB;
                    if (timeLineObject == null) {
                        ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                        clVar.cvA.cvG = R.string.boh;
                    } else {
                        abf = new abf();
                        abl = new abl();
                        abo abo = new abo();
                        abl.alD(timeLineObject.jBB);
                        abl.alE(r.Yz());
                        abl.LN(8);
                        abl.ml(bo.anU());
                        if (timeLineObject.xfH != null) {
                            abl.alJ(timeLineObject.xfH.Id);
                        }
                        if (timeLineObject.xfI != null) {
                            abo.alM(timeLineObject.xfI.Title);
                            abo.alN(timeLineObject.xfI.Desc);
                            if (!(timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.isEmpty())) {
                                bau = (bau) timeLineObject.xfI.wbK.get(0);
                                abo.alP(bau.rik);
                                abo.alO(bau.wEH);
                            }
                        }
                        clVar.cvA.title = abo.title;
                        clVar.cvA.desc = abo.desc;
                        clVar.cvA.cvC = abf;
                        clVar.cvA.type = 15;
                        abf.a(abl);
                        abf.b(abo);
                    }
                    clVar.cvA.activity = this.activity;
                    clVar.cvA.cvH = 27;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                    AppMethodBeat.o(40235);
                    return;
                }
                break;
            case 10:
                this.rhQ.cnj().gg(this.rJA, this.rJB.Id);
                YT3 = com.tencent.mm.plugin.sns.storage.h.YT(this.rJA);
                if (YT3.DI(32) && YT3.cqo().coK()) {
                    YT2 = af.cnF().YT(this.rJA);
                    if (YT2 != null && YT2.DI(32)) {
                        i.a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT3.field_snsId, 11, 0));
                    }
                    ZP(this.rJA);
                    AppMethodBeat.o(40235);
                    return;
                }
                YT = af.cnF().YT(this.rJA);
                if (YT != null) {
                    if (YT.DI(32)) {
                        j.a(j.d.Sight, c.Fav, e.Samll, 0, YT, this.cvd);
                        i.a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT.field_snsId, 11, 0));
                    }
                    clVar2 = new cl();
                    com.tencent.mm.plugin.sns.j.a.a(clVar2, YT);
                    clVar2.cvA.activity = this.activity;
                    clVar2.cvA.cvH = 29;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar2);
                }
                AppMethodBeat.o(40235);
                return;
            case 11:
                if (this.rJz.getTag() instanceof l) {
                    lVar = (l) this.rJz.getTag();
                    this.mmO.setText(lVar.ncM);
                    h.bQ(this.activity, this.activity.getString(R.string.oz));
                    if (lVar.qJj != null) {
                        aVar = com.tencent.mm.plugin.secinforeport.a.a.qjm;
                        com.tencent.mm.plugin.secinforeport.a.a.h(4, this.rJB.Id + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + lVar.qJj.wZG, bo.ana(lVar.ncM));
                    }
                    AppMethodBeat.o(40235);
                    return;
                }
                break;
            case 12:
                bau = (bau) this.rJB.xfI.wbK.get(0);
                nW = an.fZ(af.getAccSnsPath(), bau.Id) + i.e(bau);
                intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("image_path", nW);
                intent.putExtra("Retr_Msg_Type", 11);
                com.tencent.mm.bp.d.b(this.activity, ".ui.transmit.SelectConversationUI", intent, 15);
                AppMethodBeat.o(40235);
                return;
            case 13:
                com.tencent.mm.plugin.sns.abtest.a.a(this.activity, af.cnF().YT(this.rJA));
                AppMethodBeat.o(40235);
                return;
            case 14:
                YT2 = af.cnF().YT(this.rJA);
                if (YT2 != null) {
                    if (this.cvd == 0) {
                        lY = com.tencent.mm.modelsns.b.lY(714);
                    } else {
                        lY = com.tencent.mm.modelsns.b.lZ(714);
                    }
                    lY.tx(i.j(YT2)).mb(YT2.field_type).cS(YT2.DI(32)).tx(YT2.crc());
                    lY.ajK();
                }
                ap.r(YT2);
                AppMethodBeat.o(40235);
                return;
            case 15:
                if (this.rJz.getTag() instanceof l) {
                    lVar = (l) this.rJz.getTag();
                    YS = af.cnF().YS(lVar.rib);
                    if (YS != null) {
                        com.tencent.mm.modelsns.b lY2;
                        if (this.cvd == 0) {
                            lY2 = com.tencent.mm.modelsns.b.lY(715);
                        } else {
                            lY2 = com.tencent.mm.modelsns.b.lZ(715);
                        }
                        lY2.tx(i.j(YS)).mb(YS.field_type).cS(YS.DI(32)).tx(YS.crc());
                        if (lVar.qJj != null) {
                            lY2.tx(lVar.qJj.wZG == 0 ? lVar.qJj.wZJ : lVar.qJj.wZG);
                        } else {
                            lY2.tx("");
                        }
                        lY2.ajK();
                    }
                    ap.a((l) this.rJz.getTag());
                    AppMethodBeat.o(40235);
                    return;
                }
                break;
            case 16:
                ap.s(af.cnF().YT(this.rJA));
                AppMethodBeat.o(40235);
                return;
            case 17:
                if (this.rJz.getTag() instanceof l) {
                    ap.b((l) this.rJz.getTag());
                    AppMethodBeat.o(40235);
                    return;
                }
                break;
            case 18:
                Activity activity = this.activity;
                YS = af.cnF().YT(this.rJA);
                if (YS != null) {
                    Intent intent2 = new Intent();
                    if (YS.cqu().xfI.wbJ == 1) {
                        int i2 = 0;
                        if (this.rJz.getTag() instanceof aj) {
                            i2 = ((ao) this.rJz.getTag()).index;
                        }
                        bau a = com.tencent.mm.plugin.sns.model.aj.a(YS, i2);
                        if (a == null) {
                            ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                            AppMethodBeat.o(40235);
                            return;
                        }
                        intent2.putExtra("sns_send_data_ui_image_path", FlipView.g(an.fZ(af.getAccSnsPath(), a.Id) + i.l(a), activity));
                        intent2.putExtra("sns_send_data_ui_image_position", i2);
                    } else if ((YS.cqu().xfI.wbJ == 4 || YS.cqu().xfI.wbJ == 15 || YS.cqu().xfI.wbJ == 3) && ((bau) YS.cqu().xfI.wbK.get(0)) == null) {
                        ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                        AppMethodBeat.o(40235);
                        return;
                    }
                    intent2.putExtra("exdevice_open_scene_type", 1);
                    intent2.putExtra("sns_local_id", this.rJA);
                    intent2.putExtra("sns_send_data_ui_activity", true);
                    com.tencent.mm.bp.d.f(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent2);
                }
                AppMethodBeat.o(40235);
                return;
            case 19:
                YT3 = af.cnF().YT(this.rJA);
                if (YT3 == null) {
                    ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                    AppMethodBeat.o(40235);
                    return;
                } else if (YT3.DI(32)) {
                    ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                    AppMethodBeat.o(40235);
                    return;
                } else {
                    bau = (bau) YT3.cqu().xfI.wbK.get(0);
                    if (bau == null) {
                        ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                        AppMethodBeat.o(40235);
                        return;
                    }
                    cqA = an.fZ(af.getAccSnsPath(), bau.Id);
                    String str = "";
                    if (com.tencent.mm.vfs.e.ct(cqA + i.j(bau))) {
                        str = cqA + i.e(bau);
                    }
                    if (com.tencent.mm.vfs.e.ct(cqA + i.p(bau))) {
                        str = cqA + i.n(bau);
                    }
                    Intent intent3 = new Intent();
                    intent3.setClass(this.activity, SnsOnlineVideoActivity.class);
                    intent3.putExtra("intent_thumbpath", str);
                    intent3.putExtra("intent_localid", this.rJA);
                    intent3.putExtra("intent_from_scene", this.cvd);
                    intent3.putExtra("intent_ismute", true);
                    if (this.rJz != null) {
                        int[] iArr = new int[2];
                        this.rJz.getLocationInWindow(iArr);
                        int width = this.rJz.getWidth();
                        int height = this.rJz.getHeight();
                        intent3.putExtra("img_gallery_left", iArr[0]);
                        intent3.putExtra("img_gallery_top", iArr[1]);
                        intent3.putExtra("img_gallery_width", width);
                        intent3.putExtra("img_gallery_height", height);
                    }
                    this.activity.startActivity(intent3);
                    this.activity.overridePendingTransition(0, 0);
                    AppMethodBeat.o(40235);
                    return;
                }
            case 20:
                this.rhQ.cnj().gg(this.rJA, this.rJB.Id);
                YT3 = com.tencent.mm.plugin.sns.storage.h.YT(this.rJA);
                if (YT3.DI(32) && YT3.cqo().coK()) {
                    YT2 = af.cnF().YT(this.rJA);
                    if (!(YT2 == null || !YT2.DI(32) || this.rJB == null)) {
                        i.a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT3.field_snsId, 11, 0));
                    }
                    ZP(this.rJA);
                    AppMethodBeat.o(40235);
                    return;
                }
                String ZJ2;
                YT = af.cnF().YT(this.rJA);
                nW = null;
                if (YT != null && YT.DI(32)) {
                    nW = YT.crb();
                    if (bo.isNullOrNil(nW)) {
                        nW = YT.getAdLink();
                    }
                }
                if (bo.isNullOrNil(nW)) {
                    ZJ2 = au.ZJ(this.rJB.xfI.Url);
                } else {
                    ZJ2 = nW;
                }
                if (bo.isNullOrNil(ZJ2)) {
                    ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                    AppMethodBeat.o(40235);
                    return;
                }
                cl clVar5 = new cl();
                n YT5 = com.tencent.mm.plugin.sns.storage.h.YT(this.rJA);
                if (YT5 != null) {
                    nW = v.nW(YT5.field_snsId);
                    y = v.Zp().y(nW, true);
                    y.j("prePublishId", "sns_" + i.jV(YT5.field_snsId));
                    y.j("preUsername", YT5.field_userName);
                    y.j("preChatName", "");
                    y.j("url", ZJ2);
                    y.j("preMsgIndex", Integer.valueOf(0));
                    y.j("sendAppMsgScene", Integer.valueOf(1));
                    y.j("adExtStr", YT5.cqu().rjC);
                    clVar5.cvA.cvF = nW;
                }
                if (YT != null && (this.rJB.xfI.wbJ == 18 || YT.DI(32))) {
                    j.a(j.d.AdUrl, c.Fav, e.Samll, 0, YT, this.cvd);
                    if (this.rJB != null) {
                        i.a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT5.field_snsId, 11, 0));
                    }
                }
                if (bo.isNullOrNil(this.rJB.rCK)) {
                    com.tencent.mm.plugin.sns.j.a.a(clVar5, ZJ2, this.rJA);
                    clVar5.cvA.activity = this.activity;
                    clVar5.cvA.cvH = 28;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar5);
                    if (clVar5.cvB.ret == 0) {
                        anT = bo.anT();
                        if (!bo.isNullOrNil(ZJ2)) {
                            ab.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), ZJ2, Long.valueOf(anT), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1));
                            nW = "";
                            try {
                                nW = URLEncoder.encode(ZJ2, "UTF-8");
                            } catch (UnsupportedEncodingException e2) {
                                ab.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e2, "", new Object[0]);
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.e(13378, nW, Long.valueOf(anT), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1));
                        }
                    }
                    AppMethodBeat.o(40235);
                    return;
                }
                ZP(YT.cqU());
                AppMethodBeat.o(40235);
                return;
            case 21:
                n YT6 = com.tencent.mm.plugin.sns.storage.h.YT(this.rJA);
                if (YT6 == null) {
                    ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
                    AppMethodBeat.o(40235);
                    return;
                }
                int i3;
                ao aoVar = (ao) this.rJz.getTag();
                Activity activity2 = this.activity;
                Intent intent4 = menuItem.getIntent();
                if (this.cvd == 0) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                int i4 = this.cvd;
                ae aeVar = this.rhQ;
                if (intent4 == null) {
                    ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
                    AppMethodBeat.o(40235);
                    return;
                } else if (aeVar == null) {
                    ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
                    AppMethodBeat.o(40235);
                    return;
                } else if (YT6 == null) {
                    ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
                    AppMethodBeat.o(40235);
                    return;
                } else {
                    g.RQ();
                    if (g.RP().isSDCardAvailable()) {
                        String str2 = aoVar.czD;
                        int i5 = aoVar.index;
                        int i6 = aoVar.position;
                        timeLineObject = YT6.cqu();
                        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() == 0) {
                            ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
                            AppMethodBeat.o(40235);
                            return;
                        }
                        aeVar.cnj().x(YT6);
                        TimeLineObject cqu = YT6.cqu();
                        bau = i5 < cqu.xfI.wbK.size() ? (bau) cqu.xfI.wbK.get(i5) : new bau();
                        if (af.cnC().B(bau)) {
                            com.tencent.mm.modelsns.b lY3;
                            if (i3 == 1) {
                                lY3 = com.tencent.mm.modelsns.b.lY(716);
                            } else {
                                lY3 = com.tencent.mm.modelsns.b.lZ(716);
                            }
                            lY3.tx(i.j(YT6)).mb(YT6.field_type).cS(YT6.DI(32)).tx(YT6.crc()).tx(bau.Id).mb(i5).mb(cqu.xfI.wbK.size());
                            lY3.ajK();
                            if (i3 == 1) {
                                lY = com.tencent.mm.modelsns.b.lY(744);
                            } else {
                                lY = com.tencent.mm.modelsns.b.lZ(744);
                            }
                            lY.tx(i.j(YT6)).mb(YT6.field_type).cS(YT6.DI(32)).tx(YT6.crc());
                            lY.b(intent4, "intent_key_StatisticsOplog");
                            intent4.putExtra("sns_soon_enter_photoedit_ui", true);
                            intent4.putExtra("sns_gallery_localId", str2);
                            intent4.putExtra("sns_gallery_position", i5);
                            intent4.putExtra("sns_position", i6);
                            intent4.putExtra("sns_gallery_showtype", 1);
                            intent4.putExtra("K_ad_scene", i3);
                            intent4.putExtra("K_ad_source", i4);
                            intent4.putExtra("k_is_from_sns_main_timeline", true);
                            intent4.setClass(activity2, SnsBrowseUI.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("stat_scene", 3);
                            bundle.putString("stat_msg_id", "sns_" + i.jV(YT6.field_snsId));
                            bundle.putString("stat_send_msg_user", YT6.field_userName);
                            intent4.putExtra("_stat_obj", bundle);
                            activity2.startActivity(intent4);
                            activity2.overridePendingTransition(0, 0);
                            AppMethodBeat.o(40235);
                            return;
                        }
                        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", Integer.valueOf(bau.cNE));
                        AppMethodBeat.o(40235);
                        return;
                    }
                    ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
                    AppMethodBeat.o(40235);
                    return;
                }
            case 22:
                if (this.rJB != null) {
                    clVar2 = new cl();
                    com.tencent.mm.plugin.sns.j.a.a(clVar2, this.rJA);
                    clVar2.cvA.activity = this.activity;
                    clVar2.cvA.cvH = 28;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar2);
                    break;
                }
                ab.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
                AppMethodBeat.o(40235);
                return;
        }
        AppMethodBeat.o(40235);
    }

    private void ZP(String str) {
        AppMethodBeat.i(40236);
        n YT = af.cnF().YT(str);
        if (YT == null) {
            AppMethodBeat.o(40236);
            return;
        }
        String y;
        TimeLineObject cqu = YT.cqu();
        if (YT.DI(32)) {
            com.tencent.mm.plugin.sns.storage.e crd = YT.crd();
            y = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y(YT);
            if (!bo.isNullOrNil(y)) {
                crd.field_adxml = y;
            }
            y = crd.field_adxml;
        } else {
            y = cqu.rCK;
        }
        Map z = br.z(y, "adxml");
        if (z == null) {
            AppMethodBeat.o(40236);
        } else if (z.containsKey(".adxml.adCanvasInfo")) {
            String nW = v.nW(YT.field_snsId);
            String bc = bo.bc((String) z.get(".adxml.adCanvasInfo.shareTitle"), "");
            String bc2 = bo.bc((String) z.get(".adxml.adCanvasInfo.shareWebUrl"), "");
            String bc3 = bo.bc((String) z.get(".adxml.adCanvasInfo.shareDesc"), "");
            cl clVar = new cl();
            sc scVar = new sc();
            scVar.cNZ.cOc = str;
            scVar.cNZ.cOd = clVar;
            scVar.cNZ.url = bc2;
            com.tencent.mm.sdk.b.a.xxA.m(scVar);
            if (scVar.cOa.cvi) {
                clVar.cvA.cvF = nW;
                clVar.cvA.title = bc;
                clVar.cvA.desc = bc3;
                abf abf = clVar.cvA.cvC;
                if (!(abf == null || abf.wiv == null || abf.wiv.size() <= 0 || abf.wiv.get(0) == null)) {
                    ((aar) abf.wiv.get(0)).alg(y);
                    if (bo.isNullOrNil(((aar) abf.wiv.get(0)).title)) {
                        ((aar) abf.wiv.get(0)).akH(clVar.cvA.title);
                    }
                    if (bo.isNullOrNil(((aar) abf.wiv.get(0)).desc)) {
                        ((aar) abf.wiv.get(0)).akI(clVar.cvA.desc);
                    }
                    abl abl = new abl();
                    abl.alD(cqu.jBB);
                    abl.alE(r.Yz());
                    abl.LN(2);
                    abl.ml(bo.anU());
                    abf.a(abl);
                }
                clVar.cvA.activity = this.activity;
                clVar.cvA.cvH = 28;
                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                AppMethodBeat.o(40236);
                return;
            }
            if (clVar.cvA.cvG == 0) {
                clVar.cvA.cvG = R.string.bop;
            }
            h.g(this.activity, clVar.cvA.cvG, 0);
            AppMethodBeat.o(40236);
        } else {
            h.g(this.activity, R.string.bor, 0);
            AppMethodBeat.o(40236);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(40237);
        if (i2 == -1) {
            if (i == 15) {
                n YT = af.cnF().YT(this.rJA);
                bau bau = (bau) this.rJB.xfI.wbK.get(0);
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                String str = an.fZ(af.getAccSnsPath(), bau.Id) + i.e(bau);
                for (String str2 : bo.P(stringExtra.split(","))) {
                    String str3;
                    if (YT.DI(32)) {
                        str3 = an.fZ(af.getAccSnsPath(), bau.Id) + i.j(bau);
                        TimeLineObject cqu = YT.cqu();
                        com.tencent.mm.plugin.sns.storage.b cqo = YT.cqo();
                        cfh cfh = new cfh();
                        cfh.wid = bau.rEd;
                        cfh.fiG = bau.wEO;
                        if (cqu.xfI.wbJ == 15) {
                            cfh.fiM = f(YT).qPj;
                            cfh.fiN = cqu.Id;
                        } else {
                            cfh.fiM = cqu.xfN.fiM;
                            cfh.fiN = cqu.xfN.fiN;
                        }
                        cfh.fiI = cqu.xfF;
                        cfh.fiL = bo.isNullOrNil(bau.wER) ? bau.wEH : bau.wER;
                        if (cqo != null && cqo.qUn == 0) {
                            cfh.fiK = cqo.qUp;
                            cfh.fiJ = cqo.qUo;
                        }
                        ab.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", str2, str3, str, bau.wEO, Integer.valueOf(bau.rEd), Integer.valueOf(i.Xr(str3)));
                        com.tencent.mm.plugin.messenger.a.g.bOk().a(this.activity, str2, str3, str, 43, r8, cfh, cqu.rjC);
                        com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra2, str2);
                        i.a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT.field_snsId, 12, 0));
                        boolean kH = t.kH(str2);
                        j.a(j.d.Sight, kH ? c.Chatroom : c.Chat, e.Samll, kH ? com.tencent.mm.model.n.mA(str2) : 0, YT, this.cvd);
                        AppMethodBeat.o(40237);
                        return;
                    }
                    str3 = an.fZ(af.getAccSnsPath(), bau.Id) + i.j(bau);
                    ab.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", str2, str3, str, bau.wEO, Integer.valueOf(bau.rEd), Integer.valueOf(i.Xr(str3)));
                    com.tencent.mm.plugin.messenger.a.g.bOk().a(this.activity, str2, str3, str, 43, r8, this.rJB.rjC);
                    com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra2, str2);
                }
                com.tencent.mm.ui.widget.snackbar.b.i(this.activity, this.activity.getString(R.string.cbn));
                AppMethodBeat.o(40237);
                return;
            }
        } else if (i == 15) {
            n YT2 = af.cnF().YT(this.rJA);
            if (YT2 == null) {
                ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", this.rJA);
                AppMethodBeat.o(40237);
                return;
            }
            i.a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT2.field_snsId, 13, 0));
        }
        AppMethodBeat.o(40237);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40238);
        ab.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
        if (this.rhB != null && this.rhB.isShowing()) {
            this.rhB.dismiss();
        }
        AppMethodBeat.o(40238);
    }
}
