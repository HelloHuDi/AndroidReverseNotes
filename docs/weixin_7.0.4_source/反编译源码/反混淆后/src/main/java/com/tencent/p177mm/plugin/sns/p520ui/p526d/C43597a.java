package com.tencent.p177mm.plugin.sns.p520ui.p526d;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9465sc;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C21734a;
import com.tencent.p177mm.plugin.sns.abtest.C21865a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13413ap;
import com.tencent.p177mm.plugin.sns.model.C13413ap.C13414b;
import com.tencent.p177mm.plugin.sns.model.C29045ae;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.plugin.sns.p1558j.C39739a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34928c;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34929d;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34931e;
import com.tencent.p177mm.plugin.sns.p520ui.C29190ao;
import com.tencent.p177mm.plugin.sns.p520ui.C39828ar;
import com.tencent.p177mm.plugin.sns.p520ui.C43589aj;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.C46922l;
import com.tencent.p177mm.plugin.sns.p520ui.FlipView;
import com.tencent.p177mm.plugin.sns.p520ui.SnsBrowseUI;
import com.tencent.p177mm.plugin.sns.p520ui.SnsOnlineVideoActivity;
import com.tencent.p177mm.plugin.sns.p520ui.SnsPermissionUI;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.ui.d.a */
public final class C43597a implements C1202f, C5279d {
    private Activity activity;
    private int cvd;
    private ClipboardManager mmO = ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard"));
    private String rJA;
    private TimeLineObject rJB;
    private View rJz;
    private C44275p rhB;
    private C29045ae rhQ;

    public final void bIB() {
        AppMethodBeat.m2504i(40230);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(218, (C1202f) this);
        AppMethodBeat.m2505o(40230);
    }

    public final void removeListener() {
        AppMethodBeat.m2504i(40231);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(218, (C1202f) this);
        AppMethodBeat.m2505o(40231);
    }

    public C43597a(Activity activity, int i, C29045ae c29045ae) {
        AppMethodBeat.m2504i(40232);
        this.activity = activity;
        this.cvd = i;
        this.rhQ = c29045ae;
        AppMethodBeat.m2505o(40232);
    }

    /* renamed from: a */
    public final void mo69202a(View view, String str, TimeLineObject timeLineObject) {
        this.rJz = view;
        this.rJA = str;
        this.rJB = timeLineObject;
    }

    private String cuX() {
        AppMethodBeat.m2504i(40233);
        if (this.rJz != null && (this.rJz.getTag() instanceof C39828ar) && ((C39828ar) this.rJz.getTag()).ctI()) {
            C13414b Ye = C13413ap.m21540Ye(C13373af.cnF().mo62918YT(this.rJA).cqA());
            if (Ye != null) {
                String str = Ye.result;
                AppMethodBeat.m2505o(40233);
                return str;
            }
        }
        AppMethodBeat.m2505o(40233);
        return null;
    }

    /* renamed from: f */
    private C21980a m77985f(C46236n c46236n) {
        AppMethodBeat.m2504i(40234);
        C21980a cqr;
        if (c46236n == null) {
            AppMethodBeat.m2505o(40234);
            return null;
        } else if (this.cvd == 2) {
            cqr = c46236n.cqr();
            AppMethodBeat.m2505o(40234);
            return cqr;
        } else {
            cqr = c46236n.cqq();
            AppMethodBeat.m2505o(40234);
            return cqr;
        }
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.m2504i(40235);
        if (this.rJz == null) {
            AppMethodBeat.m2505o(40235);
            return;
        }
        CharSequence cuX;
        C21734a c21734a;
        C45316cl c45316cl;
        C46236n YT;
        String nW;
        C32800b y;
        long anT;
        C46236n YT2;
        bau bau;
        TimeLineObject timeLineObject;
        abf abf;
        abl abl;
        String cqA;
        C46922l c46922l;
        C46236n YT3;
        Intent intent;
        C45316cl c45316cl2;
        C37952b lY;
        C46236n YS;
        switch (menuItem.getItemId()) {
            case 0:
                cuX = cuX();
                if (C5046bo.isNullOrNil(cuX)) {
                    cuX = this.rJB.xfF;
                }
                this.mmO.setText(cuX);
                C30379h.m48465bQ(this.activity, this.activity.getString(C25738R.string.f9083oz));
                c21734a = C21734a.qjm;
                C21734a.m33275h(2, this.rJB.f15074Id, C5046bo.ana(cuX));
                AppMethodBeat.m2505o(40235);
                return;
            case 1:
                cuX = cuX();
                if (C5046bo.isNullOrNil(cuX)) {
                    cuX = this.rJB.xfF;
                }
                this.rhQ.cnj().mo69104gg(this.rJA, this.rJB.f15074Id);
                c45316cl = new C45316cl();
                C39739a.m67962a(c45316cl, this.rJA, cuX);
                c45316cl.cvA.activity = this.activity;
                c45316cl.cvA.cvH = 30;
                C4879a.xxA.mo10055m(c45316cl);
                AppMethodBeat.m2505o(40235);
                return;
            case 2:
                this.rhQ.cnj().mo69104gg(this.rJA, this.rJB.f15074Id);
                c45316cl = new C45316cl();
                YT = C21990h.m33616YT(this.rJA);
                if (YT.mo74253DI(32) && YT.cqo().coK()) {
                    m77984ZP(this.rJA);
                } else if (this.rJB.dtW == 1) {
                    C39739a.m67961a(c45316cl, this.rJA, 0);
                    c45316cl.cvA.activity = this.activity;
                    c45316cl.cvA.cvH = 31;
                    C4879a.xxA.mo10055m(c45316cl);
                } else {
                    C39739a.m67961a(c45316cl, this.rJA, ((C29190ao) this.rJz.getTag()).index);
                    c45316cl.cvA.activity = this.activity;
                    c45316cl.cvA.cvH = 31;
                    C4879a.xxA.mo10055m(c45316cl);
                }
                if (YT.mo74253DI(32)) {
                    C29036i.m46098a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT.field_snsId, 11, 0));
                }
                AppMethodBeat.m2505o(40235);
                return;
            case 3:
                this.rhQ.cnj().mo69104gg(this.rJA, this.rJB.f15074Id);
                String ZJ = C46251au.m86604ZJ(this.rJB.xfI.Url);
                if (C5046bo.isNullOrNil(ZJ)) {
                    C4990ab.m7420w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                C45316cl c45316cl3 = new C45316cl();
                C46236n YT4 = C21990h.m33616YT(this.rJA);
                if (YT4 != null) {
                    nW = C37922v.m64078nW(YT4.field_snsId);
                    y = C37922v.m64076Zp().mo60676y(nW, true);
                    y.mo53356j("prePublishId", "sns_" + C29036i.m46117jV(YT4.field_snsId));
                    y.mo53356j("preUsername", YT4.field_userName);
                    y.mo53356j("preChatName", "");
                    y.mo53356j("url", ZJ);
                    y.mo53356j("preMsgIndex", Integer.valueOf(0));
                    y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                    y.mo53356j("adExtStr", YT4.cqu().rjC);
                    c45316cl3.cvA.cvF = nW;
                }
                YT = C13373af.cnF().mo62918YT(this.rJA);
                if (YT != null && this.rJB.xfI.wbJ == 18) {
                    C34927j.m57343a(C34929d.AdUrl, C34928c.Fav, C34931e.Samll, 0, YT, this.cvd);
                }
                if (C5046bo.isNullOrNil(this.rJB.rCK)) {
                    if (YT.mo74253DI(32)) {
                        C29036i.m46098a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT4.field_snsId, 11, 0));
                    }
                    C39739a.m67963a(c45316cl3, ZJ, this.rJA);
                    c45316cl3.cvA.activity = this.activity;
                    c45316cl3.cvA.cvH = 28;
                    C4879a.xxA.mo10055m(c45316cl3);
                    if (c45316cl3.cvB.ret == 0) {
                        anT = C5046bo.anT();
                        if (!C5046bo.isNullOrNil(ZJ)) {
                            C4990ab.m7411d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), ZJ, Long.valueOf(anT), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1));
                            nW = "";
                            try {
                                nW = URLEncoder.encode(ZJ, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                C4990ab.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e, "", new Object[0]);
                            }
                            C7060h.pYm.mo8381e(13378, nW, Long.valueOf(anT), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1));
                        }
                    }
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                m77984ZP(YT.cqU());
                AppMethodBeat.m2505o(40235);
                return;
            case 4:
                this.rhQ.cnj().mo69104gg(this.rJA, this.rJB.f15074Id);
                YT2 = C13373af.cnF().mo62918YT(this.rJA);
                if (this.rJB.xfI.wbK.size() != 0) {
                    bau = (bau) this.rJB.xfI.wbK.get(0);
                    if (YT2 == null || bau == null) {
                        C4990ab.m7420w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                        AppMethodBeat.m2505o(40235);
                        return;
                    }
                    C45316cl c45316cl4 = new C45316cl();
                    if (bau == null || YT2 == null || YT2.reX == 0) {
                        C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                        c45316cl4.cvA.cvG = C25738R.string.boh;
                    } else if (C13373af.cnn()) {
                        C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                        c45316cl4.cvA.cvG = C25738R.string.boz;
                    } else {
                        String jV = C29036i.m46117jV(YT2.field_snsId);
                        jV = String.format("%s#%s", new Object[]{jV, bau.f17915Id});
                        abf abf2 = new abf();
                        abl abl2 = new abl();
                        C4990ab.m7417i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", YT2.field_userName);
                        abl2.alD(YT2.field_userName);
                        abl2.alE(C1853r.m3846Yz());
                        abl2.mo39126LN(2);
                        abl2.mo39136ml(((long) YT2.field_createTime) * 1000);
                        abl2.alI(YT2.cqA());
                        abl2.alF(jV);
                        aar aar = new aar();
                        aar.akZ(jV);
                        aar.akO(bau.Url);
                        aar.akP(bau.wEL);
                        aar.akN(YT2.cqu().xfI.Url);
                        jV = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46108e(bau);
                        if (C5730e.m8628ct(jV)) {
                            aar.akW(jV);
                        } else {
                            aar.mo27435oY(true);
                            aar.akQ(bau.wEH);
                            abu abu = new abu();
                            abu.alT(bau.wEH);
                            abf2.mo74746b(abu);
                        }
                        aar.mo27394LE(7);
                        aar.akH(bau.Title);
                        aar.akI(bau.Desc);
                        aar.mo27434oX(true);
                        abf2.wiv.add(aar);
                        abf2.mo74737a(abl2);
                        c45316cl4.cvA.cvC = abf2;
                        c45316cl4.cvA.type = 7;
                        C39739a.m67956a(aar, YT2);
                    }
                    c45316cl4.cvA.activity = this.activity;
                    c45316cl4.cvA.cvH = 25;
                    C4879a.xxA.mo10055m(c45316cl4);
                }
                AppMethodBeat.m2505o(40235);
                return;
            case 5:
                this.rhQ.cnj().mo69104gg(this.rJA, this.rJB.f15074Id);
                if (this.rJB != null) {
                    c45316cl = new C45316cl();
                    timeLineObject = this.rJB;
                    if (timeLineObject == null) {
                        C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                        c45316cl.cvA.cvG = C25738R.string.boh;
                    } else {
                        abf = new abf();
                        abl = new abl();
                        abe abe = new abe();
                        abl.alD(timeLineObject.jBB);
                        abl.alE(C1853r.m3846Yz());
                        abl.mo39126LN(2);
                        abl.mo39136ml(C5046bo.anU());
                        if (timeLineObject.xfH != null) {
                            abl.alJ(timeLineObject.xfH.f17242Id);
                        }
                        if (timeLineObject.xfI != null) {
                            abe.alw(timeLineObject.xfI.Title);
                            abe.alx(timeLineObject.xfI.Desc);
                            if (!(timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.isEmpty())) {
                                bau = (bau) timeLineObject.xfI.wbK.get(0);
                                abe.mo27436LK(bau.cuu);
                                abe.alz(bau.rik);
                                abe.aly(bau.wEH);
                            }
                        }
                        c45316cl.cvA.title = abe.title;
                        c45316cl.cvA.desc = abe.desc;
                        c45316cl.cvA.cvC = abf;
                        c45316cl.cvA.type = 10;
                        abf.mo74737a(abl);
                        abf.mo74744b(abe);
                    }
                    c45316cl.cvA.activity = this.activity;
                    c45316cl.cvA.cvH = 26;
                    C4879a.xxA.mo10055m(c45316cl);
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                break;
            case 7:
                C46224r c46224r;
                cqA = C13373af.cnF().mo62918YT(this.rJA).cqA();
                c46922l = (C46922l) this.rJz.getTag();
                C1207m c46224r2;
                if (C35002v.m57482Zl(cqA)) {
                    c46224r2 = new C46224r(C35002v.m57483Zm(cqA), 6, c46922l.qJj);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(c46224r2, 0);
                    c46224r = c46224r2;
                } else {
                    c46224r2 = new C46224r(C35002v.m57483Zm(cqA), 4, c46922l.qJj);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(c46224r2, 0);
                    C1207m c46224r3 = c46224r2;
                }
                Context context = this.activity;
                this.activity.getString(C25738R.string.f9238tz);
                this.rhB = C30379h.m48458b(context, this.activity.getString(C25738R.string.ek6), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(40229);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14547c(c46224r3);
                        AppMethodBeat.m2505o(40229);
                    }
                });
                AppMethodBeat.m2505o(40235);
                return;
            case 8:
                YT3 = C13373af.cnF().mo62918YT(this.rJA);
                if (YT3 != null) {
                    C21865a.m33415b(YT3);
                    intent = new Intent();
                    intent.putExtra("sns_permission_snsinfo_svr_id", YT3.field_snsId);
                    intent.putExtra("sns_permission_userName", YT3.field_userName);
                    intent.putExtra("sns_permission_anim", true);
                    intent.setClass(this.activity, SnsPermissionUI.class);
                    this.activity.startActivityForResult(intent, 11);
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                break;
            case 9:
                this.rhQ.cnj().mo69104gg(this.rJA, this.rJB.f15074Id);
                if (this.rJB != null) {
                    c45316cl = new C45316cl();
                    timeLineObject = this.rJB;
                    if (timeLineObject == null) {
                        C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                        c45316cl.cvA.cvG = C25738R.string.boh;
                    } else {
                        abf = new abf();
                        abl = new abl();
                        abo abo = new abo();
                        abl.alD(timeLineObject.jBB);
                        abl.alE(C1853r.m3846Yz());
                        abl.mo39126LN(8);
                        abl.mo39136ml(C5046bo.anU());
                        if (timeLineObject.xfH != null) {
                            abl.alJ(timeLineObject.xfH.f17242Id);
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
                        c45316cl.cvA.title = abo.title;
                        c45316cl.cvA.desc = abo.desc;
                        c45316cl.cvA.cvC = abf;
                        c45316cl.cvA.type = 15;
                        abf.mo74737a(abl);
                        abf.mo74745b(abo);
                    }
                    c45316cl.cvA.activity = this.activity;
                    c45316cl.cvA.cvH = 27;
                    C4879a.xxA.mo10055m(c45316cl);
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                break;
            case 10:
                this.rhQ.cnj().mo69104gg(this.rJA, this.rJB.f15074Id);
                YT3 = C21990h.m33616YT(this.rJA);
                if (YT3.mo74253DI(32) && YT3.cqo().coK()) {
                    YT2 = C13373af.cnF().mo62918YT(this.rJA);
                    if (YT2 != null && YT2.mo74253DI(32)) {
                        C29036i.m46098a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT3.field_snsId, 11, 0));
                    }
                    m77984ZP(this.rJA);
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                YT = C13373af.cnF().mo62918YT(this.rJA);
                if (YT != null) {
                    if (YT.mo74253DI(32)) {
                        C34927j.m57343a(C34929d.Sight, C34928c.Fav, C34931e.Samll, 0, YT, this.cvd);
                        C29036i.m46098a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT.field_snsId, 11, 0));
                    }
                    c45316cl2 = new C45316cl();
                    C39739a.m67958a(c45316cl2, YT);
                    c45316cl2.cvA.activity = this.activity;
                    c45316cl2.cvA.cvH = 29;
                    C4879a.xxA.mo10055m(c45316cl2);
                }
                AppMethodBeat.m2505o(40235);
                return;
            case 11:
                if (this.rJz.getTag() instanceof C46922l) {
                    c46922l = (C46922l) this.rJz.getTag();
                    this.mmO.setText(c46922l.ncM);
                    C30379h.m48465bQ(this.activity, this.activity.getString(C25738R.string.f9083oz));
                    if (c46922l.qJj != null) {
                        c21734a = C21734a.qjm;
                        C21734a.m33275h(4, this.rJB.f15074Id + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c46922l.qJj.wZG, C5046bo.ana(c46922l.ncM));
                    }
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                break;
            case 12:
                bau = (bau) this.rJB.xfI.wbK.get(0);
                nW = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46108e(bau);
                intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("image_path", nW);
                intent.putExtra("Retr_Msg_Type", 11);
                C25985d.m41466b(this.activity, ".ui.transmit.SelectConversationUI", intent, 15);
                AppMethodBeat.m2505o(40235);
                return;
            case 13:
                C21865a.m33409a(this.activity, C13373af.cnF().mo62918YT(this.rJA));
                AppMethodBeat.m2505o(40235);
                return;
            case 14:
                YT2 = C13373af.cnF().mo62918YT(this.rJA);
                if (YT2 != null) {
                    if (this.cvd == 0) {
                        lY = C37952b.m64170lY(714);
                    } else {
                        lY = C37952b.m64171lZ(714);
                    }
                    lY.mo60722tx(C29036i.m46115j(YT2)).mo60720mb(YT2.field_type).mo60718cS(YT2.mo74253DI(32)).mo60722tx(YT2.crc());
                    lY.ajK();
                }
                C13413ap.m21556r(YT2);
                AppMethodBeat.m2505o(40235);
                return;
            case 15:
                if (this.rJz.getTag() instanceof C46922l) {
                    c46922l = (C46922l) this.rJz.getTag();
                    YS = C13373af.cnF().mo62917YS(c46922l.rib);
                    if (YS != null) {
                        C37952b lY2;
                        if (this.cvd == 0) {
                            lY2 = C37952b.m64170lY(715);
                        } else {
                            lY2 = C37952b.m64171lZ(715);
                        }
                        lY2.mo60722tx(C29036i.m46115j(YS)).mo60720mb(YS.field_type).mo60718cS(YS.mo74253DI(32)).mo60722tx(YS.crc());
                        if (c46922l.qJj != null) {
                            lY2.mo60722tx(c46922l.qJj.wZG == 0 ? c46922l.qJj.wZJ : c46922l.qJj.wZG);
                        } else {
                            lY2.mo60722tx("");
                        }
                        lY2.ajK();
                    }
                    C13413ap.m21543a((C46922l) this.rJz.getTag());
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                break;
            case 16:
                C13413ap.m21557s(C13373af.cnF().mo62918YT(this.rJA));
                AppMethodBeat.m2505o(40235);
                return;
            case 17:
                if (this.rJz.getTag() instanceof C46922l) {
                    C13413ap.m21546b((C46922l) this.rJz.getTag());
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                break;
            case 18:
                Activity activity = this.activity;
                YS = C13373af.cnF().mo62918YT(this.rJA);
                if (YS != null) {
                    Intent intent2 = new Intent();
                    if (YS.cqu().xfI.wbJ == 1) {
                        int i2 = 0;
                        if (this.rJz.getTag() instanceof C43589aj) {
                            i2 = ((C29190ao) this.rJz.getTag()).index;
                        }
                        bau a = C34955aj.m57394a(YS, i2);
                        if (a == null) {
                            C4990ab.m7420w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                            AppMethodBeat.m2505o(40235);
                            return;
                        }
                        intent2.putExtra("sns_send_data_ui_image_path", FlipView.m89491g(C3892an.m6198fZ(C13373af.getAccSnsPath(), a.f17915Id) + C29036i.m46121l(a), activity));
                        intent2.putExtra("sns_send_data_ui_image_position", i2);
                    } else if ((YS.cqu().xfI.wbJ == 4 || YS.cqu().xfI.wbJ == 15 || YS.cqu().xfI.wbJ == 3) && ((bau) YS.cqu().xfI.wbK.get(0)) == null) {
                        C4990ab.m7420w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                        AppMethodBeat.m2505o(40235);
                        return;
                    }
                    intent2.putExtra("exdevice_open_scene_type", 1);
                    intent2.putExtra("sns_local_id", this.rJA);
                    intent2.putExtra("sns_send_data_ui_activity", true);
                    C25985d.m41473f(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent2);
                }
                AppMethodBeat.m2505o(40235);
                return;
            case 19:
                YT3 = C13373af.cnF().mo62918YT(this.rJA);
                if (YT3 == null) {
                    C4990ab.m7420w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                    AppMethodBeat.m2505o(40235);
                    return;
                } else if (YT3.mo74253DI(32)) {
                    C4990ab.m7420w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                    AppMethodBeat.m2505o(40235);
                    return;
                } else {
                    bau = (bau) YT3.cqu().xfI.wbK.get(0);
                    if (bau == null) {
                        C4990ab.m7420w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                        AppMethodBeat.m2505o(40235);
                        return;
                    }
                    cqA = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
                    String str = "";
                    if (C5730e.m8628ct(cqA + C29036i.m46116j(bau))) {
                        str = cqA + C29036i.m46108e(bau);
                    }
                    if (C5730e.m8628ct(cqA + C29036i.m46126p(bau))) {
                        str = cqA + C29036i.m46123n(bau);
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
                    AppMethodBeat.m2505o(40235);
                    return;
                }
            case 20:
                this.rhQ.cnj().mo69104gg(this.rJA, this.rJB.f15074Id);
                YT3 = C21990h.m33616YT(this.rJA);
                if (YT3.mo74253DI(32) && YT3.cqo().coK()) {
                    YT2 = C13373af.cnF().mo62918YT(this.rJA);
                    if (!(YT2 == null || !YT2.mo74253DI(32) || this.rJB == null)) {
                        C29036i.m46098a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT3.field_snsId, 11, 0));
                    }
                    m77984ZP(this.rJA);
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                String ZJ2;
                YT = C13373af.cnF().mo62918YT(this.rJA);
                nW = null;
                if (YT != null && YT.mo74253DI(32)) {
                    nW = YT.crb();
                    if (C5046bo.isNullOrNil(nW)) {
                        nW = YT.getAdLink();
                    }
                }
                if (C5046bo.isNullOrNil(nW)) {
                    ZJ2 = C46251au.m86604ZJ(this.rJB.xfI.Url);
                } else {
                    ZJ2 = nW;
                }
                if (C5046bo.isNullOrNil(ZJ2)) {
                    C4990ab.m7420w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                C45316cl c45316cl5 = new C45316cl();
                C46236n YT5 = C21990h.m33616YT(this.rJA);
                if (YT5 != null) {
                    nW = C37922v.m64078nW(YT5.field_snsId);
                    y = C37922v.m64076Zp().mo60676y(nW, true);
                    y.mo53356j("prePublishId", "sns_" + C29036i.m46117jV(YT5.field_snsId));
                    y.mo53356j("preUsername", YT5.field_userName);
                    y.mo53356j("preChatName", "");
                    y.mo53356j("url", ZJ2);
                    y.mo53356j("preMsgIndex", Integer.valueOf(0));
                    y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                    y.mo53356j("adExtStr", YT5.cqu().rjC);
                    c45316cl5.cvA.cvF = nW;
                }
                if (YT != null && (this.rJB.xfI.wbJ == 18 || YT.mo74253DI(32))) {
                    C34927j.m57343a(C34929d.AdUrl, C34928c.Fav, C34931e.Samll, 0, YT, this.cvd);
                    if (this.rJB != null) {
                        C29036i.m46098a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT5.field_snsId, 11, 0));
                    }
                }
                if (C5046bo.isNullOrNil(this.rJB.rCK)) {
                    C39739a.m67963a(c45316cl5, ZJ2, this.rJA);
                    c45316cl5.cvA.activity = this.activity;
                    c45316cl5.cvA.cvH = 28;
                    C4879a.xxA.mo10055m(c45316cl5);
                    if (c45316cl5.cvB.ret == 0) {
                        anT = C5046bo.anT();
                        if (!C5046bo.isNullOrNil(ZJ2)) {
                            C4990ab.m7411d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), ZJ2, Long.valueOf(anT), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1));
                            nW = "";
                            try {
                                nW = URLEncoder.encode(ZJ2, "UTF-8");
                            } catch (UnsupportedEncodingException e2) {
                                C4990ab.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e2, "", new Object[0]);
                            }
                            C7060h.pYm.mo8381e(13378, nW, Long.valueOf(anT), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1));
                        }
                    }
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                m77984ZP(YT.cqU());
                AppMethodBeat.m2505o(40235);
                return;
            case 21:
                C46236n YT6 = C21990h.m33616YT(this.rJA);
                if (YT6 == null) {
                    C4990ab.m7420w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
                    AppMethodBeat.m2505o(40235);
                    return;
                }
                int i3;
                C29190ao c29190ao = (C29190ao) this.rJz.getTag();
                Activity activity2 = this.activity;
                Intent intent4 = menuItem.getIntent();
                if (this.cvd == 0) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                int i4 = this.cvd;
                C29045ae c29045ae = this.rhQ;
                if (intent4 == null) {
                    C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
                    AppMethodBeat.m2505o(40235);
                    return;
                } else if (c29045ae == null) {
                    C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
                    AppMethodBeat.m2505o(40235);
                    return;
                } else if (YT6 == null) {
                    C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
                    AppMethodBeat.m2505o(40235);
                    return;
                } else {
                    C1720g.m3537RQ();
                    if (C1720g.m3536RP().isSDCardAvailable()) {
                        String str2 = c29190ao.czD;
                        int i5 = c29190ao.index;
                        int i6 = c29190ao.position;
                        timeLineObject = YT6.cqu();
                        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() == 0) {
                            C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
                            AppMethodBeat.m2505o(40235);
                            return;
                        }
                        c29045ae.cnj().mo69122x(YT6);
                        TimeLineObject cqu = YT6.cqu();
                        bau = i5 < cqu.xfI.wbK.size() ? (bau) cqu.xfI.wbK.get(i5) : new bau();
                        if (C13373af.cnC().mo37429B(bau)) {
                            C37952b lY3;
                            if (i3 == 1) {
                                lY3 = C37952b.m64170lY(716);
                            } else {
                                lY3 = C37952b.m64171lZ(716);
                            }
                            lY3.mo60722tx(C29036i.m46115j(YT6)).mo60720mb(YT6.field_type).mo60718cS(YT6.mo74253DI(32)).mo60722tx(YT6.crc()).mo60722tx(bau.f17915Id).mo60720mb(i5).mo60720mb(cqu.xfI.wbK.size());
                            lY3.ajK();
                            if (i3 == 1) {
                                lY = C37952b.m64170lY(744);
                            } else {
                                lY = C37952b.m64171lZ(744);
                            }
                            lY.mo60722tx(C29036i.m46115j(YT6)).mo60720mb(YT6.field_type).mo60718cS(YT6.mo74253DI(32)).mo60722tx(YT6.crc());
                            lY.mo60717b(intent4, "intent_key_StatisticsOplog");
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
                            bundle.putString("stat_msg_id", "sns_" + C29036i.m46117jV(YT6.field_snsId));
                            bundle.putString("stat_send_msg_user", YT6.field_userName);
                            intent4.putExtra("_stat_obj", bundle);
                            activity2.startActivity(intent4);
                            activity2.overridePendingTransition(0, 0);
                            AppMethodBeat.m2505o(40235);
                            return;
                        }
                        C4990ab.m7413e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", Integer.valueOf(bau.cNE));
                        AppMethodBeat.m2505o(40235);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
                    AppMethodBeat.m2505o(40235);
                    return;
                }
            case 22:
                if (this.rJB != null) {
                    c45316cl2 = new C45316cl();
                    C39739a.m67960a(c45316cl2, this.rJA);
                    c45316cl2.cvA.activity = this.activity;
                    c45316cl2.cvA.cvH = 28;
                    C4879a.xxA.mo10055m(c45316cl2);
                    break;
                }
                C4990ab.m7412e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
                AppMethodBeat.m2505o(40235);
                return;
        }
        AppMethodBeat.m2505o(40235);
    }

    /* renamed from: ZP */
    private void m77984ZP(String str) {
        AppMethodBeat.m2504i(40236);
        C46236n YT = C13373af.cnF().mo62918YT(str);
        if (YT == null) {
            AppMethodBeat.m2505o(40236);
            return;
        }
        String y;
        TimeLineObject cqu = YT.cqu();
        if (YT.mo74253DI(32)) {
            C43570e crd = YT.crd();
            y = C3953i.m6309y(YT);
            if (!C5046bo.isNullOrNil(y)) {
                crd.field_adxml = y;
            }
            y = crd.field_adxml;
        } else {
            y = cqu.rCK;
        }
        Map z = C5049br.m7595z(y, "adxml");
        if (z == null) {
            AppMethodBeat.m2505o(40236);
        } else if (z.containsKey(".adxml.adCanvasInfo")) {
            String nW = C37922v.m64078nW(YT.field_snsId);
            String bc = C5046bo.m7532bc((String) z.get(".adxml.adCanvasInfo.shareTitle"), "");
            String bc2 = C5046bo.m7532bc((String) z.get(".adxml.adCanvasInfo.shareWebUrl"), "");
            String bc3 = C5046bo.m7532bc((String) z.get(".adxml.adCanvasInfo.shareDesc"), "");
            C45316cl c45316cl = new C45316cl();
            C9465sc c9465sc = new C9465sc();
            c9465sc.cNZ.cOc = str;
            c9465sc.cNZ.cOd = c45316cl;
            c9465sc.cNZ.url = bc2;
            C4879a.xxA.mo10055m(c9465sc);
            if (c9465sc.cOa.cvi) {
                c45316cl.cvA.cvF = nW;
                c45316cl.cvA.title = bc;
                c45316cl.cvA.desc = bc3;
                abf abf = c45316cl.cvA.cvC;
                if (!(abf == null || abf.wiv == null || abf.wiv.size() <= 0 || abf.wiv.get(0) == null)) {
                    ((aar) abf.wiv.get(0)).alg(y);
                    if (C5046bo.isNullOrNil(((aar) abf.wiv.get(0)).title)) {
                        ((aar) abf.wiv.get(0)).akH(c45316cl.cvA.title);
                    }
                    if (C5046bo.isNullOrNil(((aar) abf.wiv.get(0)).desc)) {
                        ((aar) abf.wiv.get(0)).akI(c45316cl.cvA.desc);
                    }
                    abl abl = new abl();
                    abl.alD(cqu.jBB);
                    abl.alE(C1853r.m3846Yz());
                    abl.mo39126LN(2);
                    abl.mo39136ml(C5046bo.anU());
                    abf.mo74737a(abl);
                }
                c45316cl.cvA.activity = this.activity;
                c45316cl.cvA.cvH = 28;
                C4879a.xxA.mo10055m(c45316cl);
                AppMethodBeat.m2505o(40236);
                return;
            }
            if (c45316cl.cvA.cvG == 0) {
                c45316cl.cvA.cvG = C25738R.string.bop;
            }
            C30379h.m48467g(this.activity, c45316cl.cvA.cvG, 0);
            AppMethodBeat.m2505o(40236);
        } else {
            C30379h.m48467g(this.activity, C25738R.string.bor, 0);
            AppMethodBeat.m2505o(40236);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(40237);
        if (i2 == -1) {
            if (i == 15) {
                C46236n YT = C13373af.cnF().mo62918YT(this.rJA);
                bau bau = (bau) this.rJB.xfI.wbK.get(0);
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                String str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46108e(bau);
                for (String str2 : C5046bo.m7508P(stringExtra.split(","))) {
                    String str3;
                    if (YT.mo74253DI(32)) {
                        str3 = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau);
                        TimeLineObject cqu = YT.cqu();
                        C21984b cqo = YT.cqo();
                        cfh cfh = new cfh();
                        cfh.wid = bau.rEd;
                        cfh.fiG = bau.wEO;
                        if (cqu.xfI.wbJ == 15) {
                            cfh.fiM = m77985f(YT).qPj;
                            cfh.fiN = cqu.f15074Id;
                        } else {
                            cfh.fiM = cqu.xfN.fiM;
                            cfh.fiN = cqu.xfN.fiN;
                        }
                        cfh.fiI = cqu.xfF;
                        cfh.fiL = C5046bo.isNullOrNil(bau.wER) ? bau.wEH : bau.wER;
                        if (cqo != null && cqo.qUn == 0) {
                            cfh.fiK = cqo.qUp;
                            cfh.fiJ = cqo.qUo;
                        }
                        C4990ab.m7417i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", str2, str3, str, bau.wEO, Integer.valueOf(bau.rEd), Integer.valueOf(C29036i.m46095Xr(str3)));
                        C12519g.bOk().mo46458a(this.activity, str2, str3, str, 43, r8, cfh, cqu.rjC);
                        C12519g.bOk().mo46461eZ(stringExtra2, str2);
                        C29036i.m46098a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT.field_snsId, 12, 0));
                        boolean kH = C1855t.m3896kH(str2);
                        C34927j.m57343a(C34929d.Sight, kH ? C34928c.Chatroom : C34928c.Chat, C34931e.Samll, kH ? C37921n.m64060mA(str2) : 0, YT, this.cvd);
                        AppMethodBeat.m2505o(40237);
                        return;
                    }
                    str3 = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau);
                    C4990ab.m7417i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", str2, str3, str, bau.wEO, Integer.valueOf(bau.rEd), Integer.valueOf(C29036i.m46095Xr(str3)));
                    C12519g.bOk().mo46459a(this.activity, str2, str3, str, 43, r8, this.rJB.rjC);
                    C12519g.bOk().mo46461eZ(stringExtra2, str2);
                }
                C5670b.m8523i(this.activity, this.activity.getString(C25738R.string.cbn));
                AppMethodBeat.m2505o(40237);
                return;
            }
        } else if (i == 15) {
            C46236n YT2 = C13373af.cnF().mo62918YT(this.rJA);
            if (YT2 == null) {
                C4990ab.m7421w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", this.rJA);
                AppMethodBeat.m2505o(40237);
                return;
            }
            C29036i.m46098a(new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT2.field_snsId, 13, 0));
        }
        AppMethodBeat.m2505o(40237);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40238);
        C4990ab.m7416i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
        if (this.rhB != null && this.rhB.isShowing()) {
            this.rhB.dismiss();
        }
        AppMethodBeat.m2505o(40238);
    }
}
