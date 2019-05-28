package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.aw.f;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m extends c<gh> {
    public m() {
        AppMethodBeat.i(74284);
        this.xxI = gh.class.getName().hashCode();
        AppMethodBeat.o(74284);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(74287);
        boolean d = d((gh) bVar);
        AppMethodBeat.o(74287);
        return d;
    }

    private static boolean d(gh ghVar) {
        AppMethodBeat.i(74285);
        g iE;
        String[] a;
        List arrayList;
        g iE2;
        aar aar;
        int i;
        gh.b bVar;
        gh.b bVar2;
        int i2;
        switch (ghVar.cAH.type) {
            case 2:
                if (ghVar.cAH.cAJ != null) {
                    com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(ghVar.cAH.cAJ));
                    if (bVar3.exists()) {
                        ghVar.cAI.path = j.w(bVar3.dMD());
                    }
                    bVar3 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(ghVar.cAH.cAJ));
                    if (bVar3.exists()) {
                        ghVar.cAI.thumbPath = j.w(bVar3.dMD());
                        break;
                    }
                }
                break;
            case 4:
                iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                if (!(iE == null || iE.field_tagProto.wiJ == null)) {
                    ghVar.cAI.bka = new ArrayList();
                    ghVar.cAI.bka.addAll(iE.field_tagProto.wiJ);
                    break;
                }
            case 6:
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().c(ghVar.cAH.cAL);
                ghVar.cAI.ret = 0;
                break;
            case 7:
                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().d(ghVar.cAH.cAL);
                ghVar.cAI.ret = 0;
                break;
            case 8:
                ghVar.cAI.cAU = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buR();
                ghVar.cAI.ret = 0;
                break;
            case 9:
                iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                ghVar.cAI.cAT = com.tencent.mm.plugin.fav.a.b.a(iE.field_type, iE.field_favProto, iE.field_tagProto);
                ghVar.cAI.ret = 0;
                break;
            case 10:
                ((y) com.tencent.mm.kernel.g.K(y.class)).a(ghVar.cAH.context, ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv), ghVar.cAH.cAS);
                ghVar.cAI.ret = 0;
                break;
            case 11:
                a = com.tencent.mm.plugin.fav.a.b.a(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv), ghVar.cAH.handler);
                ghVar.cAI.thumbPath = a[0];
                ghVar.cAI.thumbUrl = a[1];
                ghVar.cAI.ret = 0;
                break;
            case 12:
                com.tencent.mm.plugin.fav.a.b.a(ghVar.cAH.cvv, ghVar.cAH.cAM);
                break;
            case 13:
                iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                com.tencent.mm.plugin.fav.a.b.q(iE);
                if (iE == null && ghVar.cAH.cvC != null) {
                    iE = com.tencent.mm.plugin.fav.a.b.a(ghVar.cAH.cvC);
                }
                i.a(ghVar.cAH.context, ghVar.cAH.toUser, ghVar.cAH.cAN, iE, ghVar.cAH.cAM);
                break;
            case 14:
                if (!com.tencent.mm.plugin.fav.a.b.f(ghVar.cAH.cAJ)) {
                    ghVar.cAI.ret = 0;
                    break;
                }
                ghVar.cAI.ret = 1;
                break;
            case 15:
                com.tencent.mm.plugin.fav.a.b.l(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv));
                break;
            case 16:
                com.tencent.mm.plugin.fav.a.b.m(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv));
                break;
            case 17:
                ghVar.cAI.ret = com.tencent.mm.plugin.fav.a.b.LE(ghVar.cAH.cAJ.wgo);
                break;
            case 18:
                arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(7));
                ArrayList<g> a2 = com.tencent.mm.plugin.fav.a.b.a(null, null, arrayList, null, null, null);
                ArrayList arrayList2 = new ArrayList();
                for (g iE3 : a2) {
                    abl abl = iE3.field_favProto.wit;
                    aar c;
                    if (iE3.field_type == 7) {
                        c = com.tencent.mm.plugin.fav.a.b.c(iE3);
                        arrayList2.add(f.a(6, null, c.title, c.desc, c.wgg, c.wgk, c.wgi, c.mnd, com.tencent.mm.plugin.fav.a.b.bul(), k(c), "", abl.appId));
                    } else if (iE3.field_type == 14 && iE3.field_favProto.wiv != null) {
                        Iterator it = iE3.field_favProto.wiv.iterator();
                        while (it.hasNext()) {
                            c = (aar) it.next();
                            if (c.dataType == 7) {
                                arrayList2.add(f.a(6, null, c.title, c.desc, c.wgg, c.wgk, c.wgi, c.mnd, com.tencent.mm.plugin.fav.a.b.bul(), k(c), "", abl.appId));
                            }
                        }
                    }
                }
                ghVar.cAI.cAV = arrayList2;
                break;
            case 19:
                if (ghVar.cAH.cvv != -1) {
                    if (ghVar.cAH.cAO != -1) {
                        if (ghVar.cAH.cAO == -3 && ghVar.cAH.cvv > 0) {
                            iE2 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                            if (iE2 != null) {
                                iE2.field_itemStatus = ghVar.cAH.cAK.getIntExtra("fav_note_item_status", iE2.field_itemStatus);
                                iE2.field_updateTime = ghVar.cAH.cAK.getLongExtra("fav_note_item_updatetime", iE2.field_updateTime);
                                iE2.LH(ghVar.cAH.cAK.getStringExtra("fav_note_xml"));
                                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(iE2, "localId");
                                break;
                            }
                        }
                        if (ghVar.cAH.cAO == -2 && ghVar.cAH.cvv > 0) {
                            iE2 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                            if (!(iE2 == null || iE2.field_itemStatus != 10 || bo.isNullOrNil(iE2.field_xml))) {
                                iE2.LH(iE2.field_xml);
                                if (iE2.field_favProto != null && iE2.field_favProto.wiv.size() > 1) {
                                    aar = (aar) iE2.field_favProto.wiv.get(0);
                                    if (!(bo.isNullOrNil(aar.wfZ) || bo.isNullOrNil(aar.wgb))) {
                                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(iE2, "localId");
                                        break;
                                    }
                                }
                            }
                        }
                        Intent intent = new Intent();
                        if (ghVar.cAH.cvv > 0 && !bo.isNullOrNil(ghVar.cAH.desc) && ghVar.cAH.cAO > 0) {
                            iE3 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                            if (iE3 != null) {
                                intent.putExtra("fav_note_xml", g.s(iE3));
                                intent.putExtra("fav_note_item_updatetime", iE3.field_updateTime);
                            }
                        }
                        g a3 = h.a(ghVar.cAH.cvC.wiv, ghVar.cAH.cvv);
                        if (!bo.isNullOrNil(ghVar.cAH.desc)) {
                            if (ghVar.cAH.cAO > 0) {
                                intent.putExtra("fav_note_item_status", a3.field_itemStatus);
                                ghVar.cAH.cAK = intent;
                                a3.field_favProto.LM(a3.field_favProto.version + 1);
                            }
                            a3.field_itemStatus = 1;
                            com.tencent.mm.plugin.fav.a.b.q(a3);
                            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(a3, "localId");
                            if (ghVar.cAH.desc.equals("fav_add_new_note")) {
                                if (a3.field_favProto.version != 0) {
                                    a3.field_favProto.LM(a3.field_favProto.version + 1);
                                } else {
                                    a3.field_favProto.LM(a3.field_favProto.version + 2);
                                }
                                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(a3, "localId");
                                h.a(ghVar.cAH.title, ghVar.cAH.cvC.wiv, ghVar.cAH.cvv);
                                break;
                            }
                        }
                        if (a3.field_favProto.version != 0) {
                            a3.field_favProto.LM(a3.field_favProto.version + 1);
                        } else {
                            a3.field_favProto.LM(a3.field_favProto.version + 2);
                        }
                        a3.field_itemStatus = 1;
                        com.tencent.mm.plugin.fav.a.b.q(a3);
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(a3, "localId");
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getCheckCdnService().run();
                        break;
                    }
                    iE3 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                    if (!(iE3 == null || iE3.field_favProto == null || iE3.field_favProto.wiv.size() <= 1)) {
                        ghVar.cAI.cAY = bo.isNullOrNil(((aar) iE3.field_favProto.wiv.get(0)).wfZ);
                        break;
                    }
                }
                h.a(ghVar.cAH.title, ghVar.cAH.cvC.wiv, -1);
                break;
                break;
            case 20:
                ao.bvo().bvp();
                ao bvo = ao.bvo();
                String str = ghVar.cAH.title;
                int i3 = ghVar.cAH.cAO;
                i = ghVar.cAH.cAP;
                bvo.path = bo.bc(str, "");
                bvo.cAO = i3;
                bvo.duration = i;
                break;
            case 21:
                ghVar.cAI.path = j.B(ghVar.cAH.context, ghVar.cAH.cAP).toString();
                break;
            case 22:
                ao.bvo();
                ao.bvq().destroy();
                break;
            case 23:
                ao.bvo();
                ao.bvq().buJ();
                break;
            case 24:
                bVar = ghVar.cAI;
                ao.bvo();
                bVar.cAW = ao.bvq().T(ghVar.cAH.path, ghVar.cAH.cAO, ghVar.cAH.cAP);
                break;
            case 25:
                ao.bvo();
                ao.bvq().stopPlay();
                break;
            case 26:
                boolean z;
                double d;
                bVar = ghVar.cAI;
                ao.bvo();
                bVar.path = ao.bvq().path;
                bVar = ghVar.cAI;
                ao.bvo();
                bVar.cAW = ao.bvq().buH();
                bVar = ghVar.cAI;
                ao.bvo();
                bVar.cAX = ao.bvq().buI();
                gh.b bVar4 = ghVar.cAI;
                ao.bvo();
                n bvq = ao.bvq();
                if (bvq.mfO == null) {
                    ab.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    z = false;
                } else {
                    z = bvq.mfO.DA();
                }
                bVar4.cAY = z;
                bVar2 = ghVar.cAI;
                ao.bvo();
                bvq = ao.bvq();
                if (bvq.mfO == null) {
                    ab.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                    d = 0.0d;
                } else {
                    d = bvq.mfO.Ez();
                }
                bVar2.cAZ = d;
                break;
            case 27:
                if (ghVar.cAH.cAJ != null) {
                    ghVar.cAI.path = j.w(new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(ghVar.cAH.cAJ)).dMD());
                    ghVar.cAI.thumbPath = j.w(new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(ghVar.cAH.cAJ)).dMD());
                    break;
                }
                break;
            case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                iE3 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                if (iE3 != null) {
                    if (!bo.isNullOrNil(ghVar.cAH.path)) {
                        com.tencent.mm.plugin.fav.a.b.a(iE3, ghVar.cAH.cAJ);
                        break;
                    }
                    com.tencent.mm.plugin.fav.a.b.a(iE3, ghVar.cAH.cAJ, true);
                    break;
                }
                com.tencent.mm.plugin.fav.a.b.b(ghVar.cAH.cAJ, ghVar.cAH.cAO, ghVar.cAH.cvv);
                com.tencent.mm.plugin.fav.a.b.a(ghVar.cAH.cAJ, ghVar.cAH.cAO, ghVar.cAH.cvv);
                break;
            case 30:
                com.tencent.mm.plugin.fav.a.b.c(ghVar);
                break;
            case 31:
                al alVar = (al) ghVar.cAH.cwn;
                ghVar.cAI.path = alVar.mgu;
                if (!(alVar.ftl == null || alVar.ftl.ZS() == null || alVar.ftl.ZS().vyl != -435)) {
                    iE2 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iF((long) alVar.mgq);
                    if (!(iE2 == null || iE2.field_favProto == null || iE2.field_favProto.wiv == null)) {
                        iE2.field_favProto.LM(iE2.field_favProto.version + 2);
                        iE2.field_itemStatus = 1;
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(iE2, "localId");
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getCheckCdnService().run();
                        break;
                    }
                }
            case 32:
                iE3 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                if (iE3 == null && ghVar.cAH.cvC != null) {
                    iE3 = com.tencent.mm.plugin.fav.a.b.a(ghVar.cAH.cvC);
                }
                k kVar = new k();
                bVar2 = ghVar.cAI;
                i2 = (!kVar.t(iE3) || com.tencent.mm.plugin.fav.a.b.g(iE3)) ? 0 : 1;
                bVar2.ret = i2;
                ghVar.cAI.cAY = k.u(iE3);
                ghVar.cAI.path = "";
                if (iE3 == null) {
                    ghVar.cAI.cAY = true;
                    ghVar.cAI.path = null;
                    break;
                }
                break;
            case 33:
                iE2 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                if (iE2 != null) {
                    iE2.field_favProto.aE(ghVar.cAH.cvC.wiv);
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().b(iE2, "localId");
                    break;
                }
                break;
            case 34:
                iE3 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(ghVar.cAH.cvv);
                if (iE3 != null && iE3.field_type == 18) {
                    ghVar.cAH.cvC = iE3.field_favProto;
                    break;
                }
            case 35:
                com.tencent.mm.plugin.fav.a.b.bug();
                break;
            case 36:
                ghVar.cAI.ret = com.tencent.mm.plugin.fav.a.b.bup() ? 1 : 0;
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                com.tencent.mm.plugin.fav.a.b.e(ghVar.cAH.context, ghVar.cAH.desc, ghVar.cAH.title, ghVar.cAH.path);
                break;
            case 38:
                ab.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", ghVar.cAH.cAQ);
                if (!bo.isNullOrNil(ghVar.cAH.cAQ)) {
                    a = ghVar.cAH.cAQ.split(";");
                    LinkedList<String> linkedList = new LinkedList();
                    linkedList.addAll(Arrays.asList(a));
                    if (linkedList.size() > 0) {
                        arrayList = new ArrayList();
                        for (String valueOf : linkedList) {
                            try {
                                i = Integer.valueOf(valueOf).intValue();
                                if (i > 0) {
                                    iE3 = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iF((long) i);
                                    aax aax = new aax();
                                    aax.vEp = i;
                                    if (!(iE3 == null || bo.isNullOrNil(iE3.field_xml))) {
                                        aax.vEv = iE3.field_xml;
                                    }
                                    arrayList.add(aax);
                                }
                            } catch (Exception e) {
                            }
                        }
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).checkFavItem(arrayList);
                        ab.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                        break;
                    }
                }
                break;
            case 39:
                try {
                    ab.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", ghVar.cAH.cAQ, ghVar.cAH.cAR);
                    i2 = bo.getInt(ghVar.cAH.cAQ, -1);
                    ArrayList P = bo.P(ghVar.cAH.cAR.split(";"));
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(P);
                    g iF = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iF((long) i2);
                    if (iF != null) {
                        abi abi = new abi();
                        abi.vEp = i2;
                        Object obj = null;
                        for (aar aar2 : iF.field_favProto.wiv) {
                            acb acb;
                            if (hashSet.remove(aar2.mnd + "#0")) {
                                if (bo.isNullOrNil(aar2.wgb)) {
                                    com.tencent.mm.al.f.afy();
                                    aar2.akM(a.afp());
                                    h.vv(2);
                                }
                                if (e.ct(com.tencent.mm.plugin.fav.a.b.b(aar2))) {
                                    aar2.LH(1);
                                    com.tencent.mm.plugin.fav.a.b.a(aar2, iF, 0, false);
                                    h.vv(3);
                                    obj = 1;
                                } else {
                                    h.vv(5);
                                    acb = new acb();
                                    acb.vXB = aar2.mnd;
                                    acb.vXH = 0;
                                    acb.jBT = 4;
                                    abi.wiy.add(acb);
                                }
                            }
                            if (hashSet.remove(aar2.mnd + "#1")) {
                                if (bo.isNullOrNil(aar2.wgb)) {
                                    com.tencent.mm.al.f.afy();
                                    aar2.akM(a.afp());
                                    h.vv(2);
                                }
                                if (e.ct(com.tencent.mm.plugin.fav.a.b.c(aar2))) {
                                    aar2.LH(-1);
                                    com.tencent.mm.plugin.fav.a.b.a(aar2, iF, 0);
                                    h.vv(3);
                                    obj = 1;
                                } else {
                                    h.vv(5);
                                    acb = new acb();
                                    acb.vXB = aar2.mnd;
                                    acb.vXH = 1;
                                    acb.jBT = 4;
                                    abi.wiy.add(acb);
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            ab.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", hashSet.toString());
                            h.vw(hashSet.size());
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
                            ((ae) com.tencent.mm.kernel.g.M(ae.class)).checkFavItem(abi);
                        }
                        if (obj == null) {
                            h.vv(7);
                            ab.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                            break;
                        }
                        if (iF.field_type == 18) {
                            iF.field_favProto.LM(iF.field_favProto.version + 1);
                        }
                        iF.field_itemStatus = 15;
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(iF, "localId");
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().run();
                        h.vv(6);
                        break;
                    }
                    ab.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", Integer.valueOf(i2));
                    h.vv(8);
                    break;
                } catch (Exception e3) {
                    ab.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", e3, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                    break;
                }
        }
        AppMethodBeat.o(74285);
        return false;
    }

    private static String k(aar aar) {
        String w;
        AppMethodBeat.i(74286);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(aar));
        if (bVar.exists()) {
            w = j.w(bVar.dMD());
        } else if (aar.cvq == null) {
            w = "";
        } else {
            bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bue() + com.tencent.mm.a.g.x(aar.cvq.getBytes()));
            w = bVar.exists() ? j.w(bVar.dMD()) : "";
        }
        AppMethodBeat.o(74286);
        return w;
    }
}
