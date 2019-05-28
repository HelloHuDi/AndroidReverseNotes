package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p198aw.C9059f;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C37721gh.C9356b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.fav.p407a.C11850al;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C36764n;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C41268k;
import com.tencent.p177mm.plugin.fav.p407a.C43052ao;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aax;
import com.tencent.p177mm.protocal.protobuf.abi;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.acb;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.m */
public final class C43082m extends C4884c<C37721gh> {
    public C43082m() {
        AppMethodBeat.m2504i(74284);
        this.xxI = C37721gh.class.getName().hashCode();
        AppMethodBeat.m2505o(74284);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(74287);
        boolean d = C43082m.m76573d((C37721gh) c4883b);
        AppMethodBeat.m2505o(74287);
        return d;
    }

    /* renamed from: d */
    private static boolean m76573d(C37721gh c37721gh) {
        AppMethodBeat.m2504i(74285);
        C27966g iE;
        String[] a;
        List arrayList;
        C27966g iE2;
        aar aar;
        int i;
        C9356b c9356b;
        C9356b c9356b2;
        int i2;
        switch (c37721gh.cAH.type) {
            case 2:
                if (c37721gh.cAH.cAJ != null) {
                    C5728b c5728b = new C5728b(C39037b.m66370b(c37721gh.cAH.cAJ));
                    if (c5728b.exists()) {
                        c37721gh.cAI.path = C5736j.m8649w(c5728b.dMD());
                    }
                    c5728b = new C5728b(C39037b.m66379c(c37721gh.cAH.cAJ));
                    if (c5728b.exists()) {
                        c37721gh.cAI.thumbPath = C5736j.m8649w(c5728b.dMD());
                        break;
                    }
                }
                break;
            case 4:
                iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                if (!(iE == null || iE.field_tagProto.wiJ == null)) {
                    c37721gh.cAI.bka = new ArrayList();
                    c37721gh.cAI.bka.addAll(iE.field_tagProto.wiJ);
                    break;
                }
            case 6:
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10116c(c37721gh.cAH.cAL);
                c37721gh.cAI.ret = 0;
                break;
            case 7:
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10117d(c37721gh.cAH.cAL);
                c37721gh.cAI.ret = 0;
                break;
            case 8:
                c37721gh.cAI.cAU = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buR();
                c37721gh.cAI.ret = 0;
                break;
            case 9:
                iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                c37721gh.cAI.cAT = C39037b.m66347a(iE.field_type, iE.field_favProto, iE.field_tagProto);
                c37721gh.cAI.ret = 0;
                break;
            case 10:
                ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(c37721gh.cAH.context, ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv), c37721gh.cAH.cAS);
                c37721gh.cAI.ret = 0;
                break;
            case 11:
                a = C39037b.m66367a(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv), c37721gh.cAH.handler);
                c37721gh.cAI.thumbPath = a[0];
                c37721gh.cAI.thumbUrl = a[1];
                c37721gh.cAI.ret = 0;
                break;
            case 12:
                C39037b.m66365a(c37721gh.cAH.cvv, c37721gh.cAH.cAM);
                break;
            case 13:
                iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                C39037b.m66417q(iE);
                if (iE == null && c37721gh.cAH.cvC != null) {
                    iE = C39037b.m66345a(c37721gh.cAH.cvC);
                }
                C11909i.m19791a(c37721gh.cAH.context, c37721gh.cAH.toUser, c37721gh.cAH.cAN, iE, c37721gh.cAH.cAM);
                break;
            case 14:
                if (!C39037b.m66393f(c37721gh.cAH.cAJ)) {
                    c37721gh.cAI.ret = 0;
                    break;
                }
                c37721gh.cAI.ret = 1;
                break;
            case 15:
                C39037b.m66410l(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv));
                break;
            case 16:
                C39037b.m66411m(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv));
                break;
            case 17:
                c37721gh.cAI.ret = C39037b.m66340LE(c37721gh.cAH.cAJ.wgo);
                break;
            case 18:
                arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(7));
                ArrayList<C27966g> a2 = C39037b.m66349a(null, null, arrayList, null, null, null);
                ArrayList arrayList2 = new ArrayList();
                for (C27966g iE3 : a2) {
                    abl abl = iE3.field_favProto.wit;
                    aar c;
                    if (iE3.field_type == 7) {
                        c = C39037b.m66378c(iE3);
                        arrayList2.add(C9059f.m16431a(6, null, c.title, c.desc, c.wgg, c.wgk, c.wgi, c.mnd, C39037b.bul(), C43082m.m76574k(c), "", abl.appId));
                    } else if (iE3.field_type == 14 && iE3.field_favProto.wiv != null) {
                        Iterator it = iE3.field_favProto.wiv.iterator();
                        while (it.hasNext()) {
                            c = (aar) it.next();
                            if (c.dataType == 7) {
                                arrayList2.add(C9059f.m16431a(6, null, c.title, c.desc, c.wgg, c.wgk, c.wgi, c.mnd, C39037b.bul(), C43082m.m76574k(c), "", abl.appId));
                            }
                        }
                    }
                }
                c37721gh.cAI.cAV = arrayList2;
                break;
            case 19:
                if (c37721gh.cAH.cvv != -1) {
                    if (c37721gh.cAH.cAO != -1) {
                        if (c37721gh.cAH.cAO == -3 && c37721gh.cAH.cvv > 0) {
                            iE2 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                            if (iE2 != null) {
                                iE2.field_itemStatus = c37721gh.cAH.cAK.getIntExtra("fav_note_item_status", iE2.field_itemStatus);
                                iE2.field_updateTime = c37721gh.cAH.cAK.getLongExtra("fav_note_item_updatetime", iE2.field_updateTime);
                                iE2.mo45881LH(c37721gh.cAH.cAK.getStringExtra("fav_note_xml"));
                                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iE2, "localId");
                                break;
                            }
                        }
                        if (c37721gh.cAH.cAO == -2 && c37721gh.cAH.cvv > 0) {
                            iE2 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                            if (!(iE2 == null || iE2.field_itemStatus != 10 || C5046bo.isNullOrNil(iE2.field_xml))) {
                                iE2.mo45881LH(iE2.field_xml);
                                if (iE2.field_favProto != null && iE2.field_favProto.wiv.size() > 1) {
                                    aar = (aar) iE2.field_favProto.wiv.get(0);
                                    if (!(C5046bo.isNullOrNil(aar.wfZ) || C5046bo.isNullOrNil(aar.wgb))) {
                                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iE2, "localId");
                                        break;
                                    }
                                }
                            }
                        }
                        Intent intent = new Intent();
                        if (c37721gh.cAH.cvv > 0 && !C5046bo.isNullOrNil(c37721gh.cAH.desc) && c37721gh.cAH.cAO > 0) {
                            iE3 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                            if (iE3 != null) {
                                intent.putExtra("fav_note_xml", C27966g.m44521s(iE3));
                                intent.putExtra("fav_note_item_updatetime", iE3.field_updateTime);
                            }
                        }
                        C27966g a3 = C3109h.m5349a(c37721gh.cAH.cvC.wiv, c37721gh.cAH.cvv);
                        if (!C5046bo.isNullOrNil(c37721gh.cAH.desc)) {
                            if (c37721gh.cAH.cAO > 0) {
                                intent.putExtra("fav_note_item_status", a3.field_itemStatus);
                                c37721gh.cAH.cAK = intent;
                                a3.field_favProto.mo74735LM(a3.field_favProto.version + 1);
                            }
                            a3.field_itemStatus = 1;
                            C39037b.m66417q(a3);
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(a3, "localId");
                            if (c37721gh.cAH.desc.equals("fav_add_new_note")) {
                                if (a3.field_favProto.version != 0) {
                                    a3.field_favProto.mo74735LM(a3.field_favProto.version + 1);
                                } else {
                                    a3.field_favProto.mo74735LM(a3.field_favProto.version + 2);
                                }
                                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(a3, "localId");
                                C3109h.m5350a(c37721gh.cAH.title, c37721gh.cAH.cvC.wiv, c37721gh.cAH.cvv);
                                break;
                            }
                        }
                        if (a3.field_favProto.version != 0) {
                            a3.field_favProto.mo74735LM(a3.field_favProto.version + 1);
                        } else {
                            a3.field_favProto.mo74735LM(a3.field_favProto.version + 2);
                        }
                        a3.field_itemStatus = 1;
                        C39037b.m66417q(a3);
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(a3, "localId");
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getCheckCdnService().run();
                        break;
                    }
                    iE3 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                    if (!(iE3 == null || iE3.field_favProto == null || iE3.field_favProto.wiv.size() <= 1)) {
                        c37721gh.cAI.cAY = C5046bo.isNullOrNil(((aar) iE3.field_favProto.wiv.get(0)).wfZ);
                        break;
                    }
                }
                C3109h.m5350a(c37721gh.cAH.title, c37721gh.cAH.cvC.wiv, -1);
                break;
                break;
            case 20:
                C43052ao.bvo().bvp();
                C43052ao bvo = C43052ao.bvo();
                String str = c37721gh.cAH.title;
                int i3 = c37721gh.cAH.cAO;
                i = c37721gh.cAH.cAP;
                bvo.path = C5046bo.m7532bc(str, "");
                bvo.cAO = i3;
                bvo.duration = i;
                break;
            case 21:
                c37721gh.cAI.path = C34171j.m56018B(c37721gh.cAH.context, c37721gh.cAH.cAP).toString();
                break;
            case 22:
                C43052ao.bvo();
                C43052ao.bvq().destroy();
                break;
            case 23:
                C43052ao.bvo();
                C43052ao.bvq().buJ();
                break;
            case 24:
                c9356b = c37721gh.cAI;
                C43052ao.bvo();
                c9356b.cAW = C43052ao.bvq().mo58604T(c37721gh.cAH.path, c37721gh.cAH.cAO, c37721gh.cAH.cAP);
                break;
            case 25:
                C43052ao.bvo();
                C43052ao.bvq().stopPlay();
                break;
            case 26:
                boolean z;
                double d;
                c9356b = c37721gh.cAI;
                C43052ao.bvo();
                c9356b.path = C43052ao.bvq().path;
                c9356b = c37721gh.cAI;
                C43052ao.bvo();
                c9356b.cAW = C43052ao.bvq().buH();
                c9356b = c37721gh.cAI;
                C43052ao.bvo();
                c9356b.cAX = C43052ao.bvq().buI();
                C9356b c9356b3 = c37721gh.cAI;
                C43052ao.bvo();
                C36764n bvq = C43052ao.bvq();
                if (bvq.mfO == null) {
                    C4990ab.m7420w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    z = false;
                } else {
                    z = bvq.mfO.mo33395DA();
                }
                c9356b3.cAY = z;
                c9356b2 = c37721gh.cAI;
                C43052ao.bvo();
                bvq = C43052ao.bvq();
                if (bvq.mfO == null) {
                    C4990ab.m7420w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                    d = 0.0d;
                } else {
                    d = bvq.mfO.mo33398Ez();
                }
                c9356b2.cAZ = d;
                break;
            case 27:
                if (c37721gh.cAH.cAJ != null) {
                    c37721gh.cAI.path = C5736j.m8649w(new C5728b(C39037b.m66370b(c37721gh.cAH.cAJ)).dMD());
                    c37721gh.cAI.thumbPath = C5736j.m8649w(new C5728b(C39037b.m66379c(c37721gh.cAH.cAJ)).dMD());
                    break;
                }
                break;
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                iE3 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                if (iE3 != null) {
                    if (!C5046bo.isNullOrNil(c37721gh.cAH.path)) {
                        C39037b.m66359a(iE3, c37721gh.cAH.cAJ);
                        break;
                    }
                    C39037b.m66360a(iE3, c37721gh.cAH.cAJ, true);
                    break;
                }
                C39037b.m66375b(c37721gh.cAH.cAJ, c37721gh.cAH.cAO, c37721gh.cAH.cvv);
                C39037b.m66362a(c37721gh.cAH.cAJ, c37721gh.cAH.cAO, c37721gh.cAH.cvv);
                break;
            case 30:
                C39037b.m66380c(c37721gh);
                break;
            case 31:
                C11850al c11850al = (C11850al) c37721gh.cAH.cwn;
                c37721gh.cAI.path = c11850al.mgu;
                if (!(c11850al.ftl == null || c11850al.ftl.mo5618ZS() == null || c11850al.ftl.mo5618ZS().vyl != -435)) {
                    iE2 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) c11850al.mgq);
                    if (!(iE2 == null || iE2.field_favProto == null || iE2.field_favProto.wiv == null)) {
                        iE2.field_favProto.mo74735LM(iE2.field_favProto.version + 2);
                        iE2.field_itemStatus = 1;
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iE2, "localId");
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getCheckCdnService().run();
                        break;
                    }
                }
            case 32:
                iE3 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                if (iE3 == null && c37721gh.cAH.cvC != null) {
                    iE3 = C39037b.m66345a(c37721gh.cAH.cvC);
                }
                C41268k c41268k = new C41268k();
                c9356b2 = c37721gh.cAI;
                i2 = (!c41268k.mo61948t(iE3) || C39037b.m66395g(iE3)) ? 0 : 1;
                c9356b2.ret = i2;
                c37721gh.cAI.cAY = C41268k.m71869u(iE3);
                c37721gh.cAI.path = "";
                if (iE3 == null) {
                    c37721gh.cAI.cAY = true;
                    c37721gh.cAI.path = null;
                    break;
                }
                break;
            case 33:
                iE2 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                if (iE2 != null) {
                    iE2.field_favProto.mo74738aE(c37721gh.cAH.cvC.wiv);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23680b(iE2, "localId");
                    break;
                }
                break;
            case 34:
                iE3 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37721gh.cAH.cvv);
                if (iE3 != null && iE3.field_type == 18) {
                    c37721gh.cAH.cvC = iE3.field_favProto;
                    break;
                }
            case 35:
                C39037b.bug();
                break;
            case 36:
                c37721gh.cAI.ret = C39037b.bup() ? 1 : 0;
                break;
            case C2275g.CTRL_INDEX /*37*/:
                C39037b.m66387e(c37721gh.cAH.context, c37721gh.cAH.desc, c37721gh.cAH.title, c37721gh.cAH.path);
                break;
            case 38:
                C4990ab.m7417i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", c37721gh.cAH.cAQ);
                if (!C5046bo.isNullOrNil(c37721gh.cAH.cAQ)) {
                    a = c37721gh.cAH.cAQ.split(";");
                    LinkedList<String> linkedList = new LinkedList();
                    linkedList.addAll(Arrays.asList(a));
                    if (linkedList.size() > 0) {
                        arrayList = new ArrayList();
                        for (String valueOf : linkedList) {
                            try {
                                i = Integer.valueOf(valueOf).intValue();
                                if (i > 0) {
                                    iE3 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) i);
                                    aax aax = new aax();
                                    aax.vEp = i;
                                    if (!(iE3 == null || C5046bo.isNullOrNil(iE3.field_xml))) {
                                        aax.vEv = iE3.field_xml;
                                    }
                                    arrayList.add(aax);
                                }
                            } catch (Exception e) {
                            }
                        }
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).checkFavItem(arrayList);
                        C4990ab.m7416i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                        break;
                    }
                }
                break;
            case 39:
                try {
                    C4990ab.m7417i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", c37721gh.cAH.cAQ, c37721gh.cAH.cAR);
                    i2 = C5046bo.getInt(c37721gh.cAH.cAQ, -1);
                    ArrayList P = C5046bo.m7508P(c37721gh.cAH.cAR.split(";"));
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(P);
                    C27966g iF = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) i2);
                    if (iF != null) {
                        abi abi = new abi();
                        abi.vEp = i2;
                        Object obj = null;
                        for (aar aar2 : iF.field_favProto.wiv) {
                            acb acb;
                            if (hashSet.remove(aar2.mnd + "#0")) {
                                if (C5046bo.isNullOrNil(aar2.wgb)) {
                                    C37461f.afy();
                                    aar2.akM(C8941a.afp());
                                    C27968h.m44533vv(2);
                                }
                                if (C5730e.m8628ct(C39037b.m66370b(aar2))) {
                                    aar2.mo27397LH(1);
                                    C39037b.m66364a(aar2, iF, 0, false);
                                    C27968h.m44533vv(3);
                                    obj = 1;
                                } else {
                                    C27968h.m44533vv(5);
                                    acb = new acb();
                                    acb.vXB = aar2.mnd;
                                    acb.vXH = 0;
                                    acb.jBT = 4;
                                    abi.wiy.add(acb);
                                }
                            }
                            if (hashSet.remove(aar2.mnd + "#1")) {
                                if (C5046bo.isNullOrNil(aar2.wgb)) {
                                    C37461f.afy();
                                    aar2.akM(C8941a.afp());
                                    C27968h.m44533vv(2);
                                }
                                if (C5730e.m8628ct(C39037b.m66379c(aar2))) {
                                    aar2.mo27397LH(-1);
                                    C39037b.m66363a(aar2, iF, 0);
                                    C27968h.m44533vv(3);
                                    obj = 1;
                                } else {
                                    C27968h.m44533vv(5);
                                    acb = new acb();
                                    acb.vXB = aar2.mnd;
                                    acb.vXH = 1;
                                    acb.jBT = 4;
                                    abi.wiy.add(acb);
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            C4990ab.m7417i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", hashSet.toString());
                            C27968h.m44534vw(hashSet.size());
                            Iterator it2 = hashSet.iterator();
                            while (it2.hasNext()) {
                                try {
                                    a = ((String) it2.next()).split("#");
                                    acb acb2 = new acb();
                                    acb2.vXB = a[0];
                                    acb2.vXH = Integer.valueOf(a[1]).intValue();
                                    acb2.jBT = 3;
                                    abi.wiy.add(acb2);
                                } catch (Exception e2) {
                                }
                            }
                        }
                        if (abi.wiy.size() > 0) {
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).checkFavItem(abi);
                        }
                        if (obj == null) {
                            C27968h.m44533vv(7);
                            C4990ab.m7416i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                            break;
                        }
                        if (iF.field_type == 18) {
                            iF.field_favProto.mo74735LM(iF.field_favProto.version + 1);
                        }
                        iF.field_itemStatus = 15;
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iF, "localId");
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
                        C27968h.m44533vv(6);
                        break;
                    }
                    C4990ab.m7417i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", Integer.valueOf(i2));
                    C27968h.m44533vv(8);
                    break;
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", e3, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                    break;
                }
        }
        AppMethodBeat.m2505o(74285);
        return false;
    }

    /* renamed from: k */
    private static String m76574k(aar aar) {
        String w;
        AppMethodBeat.m2504i(74286);
        C5728b c5728b = new C5728b(C39037b.m66379c(aar));
        if (c5728b.exists()) {
            w = C5736j.m8649w(c5728b.dMD());
        } else if (aar.cvq == null) {
            w = "";
        } else {
            c5728b = new C5728b(C39037b.bue() + C1178g.m2591x(aar.cvq.getBytes()));
            w = c5728b.exists() ? C5736j.m8649w(c5728b.dMD()) : "";
        }
        AppMethodBeat.m2505o(74286);
        return w;
    }
}
