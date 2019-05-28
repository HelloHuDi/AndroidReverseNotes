package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class d {
    public static String uMW = "";
    public static HashMap<String, JSONArray> uMX = new HashMap();
    public static boolean uNa = false;
    public static String uNb = (an.bvi() + "/fav_fileicon_recording.png");
    private static String uNc = (an.bvi() + "/ofm_file_icon.png");
    private static String uNd = (an.bvi() + "/app_attach_file_icon_pic.png");
    public static String uNe = (an.bvi() + "/location_msg.png");
    public static String uNf = (an.bvi() + "/note_fav_not_support.png");
    public m uMP = null;
    public g uMQ;
    public HashMap<String, w> uMR = new HashMap();
    public HashMap<String, String> uMS = new HashMap();
    public HashMap<String, o> uMT = new HashMap();
    public String uMU = "WeNote_0";
    public String uMV = "";
    public boolean uMY = false;
    public abf uMZ = new abf();

    public abstract void a(aar aar, String str);

    public abstract String b(aar aar);

    public abstract void bm(Context context, String str);

    public abstract void bn(Context context, String str);

    public abstract void bo(Context context, String str);

    public abstract String c(aar aar);

    public abstract void n(aar aar);

    public final void ef(List<aar> list) {
        ArrayList ahg;
        Throwable e;
        w wVar = new w();
        List list2 = null;
        for (aar aar : list) {
            o oVar = new o();
            oVar.uOo = aar.whb;
            if (aar.dataType == 1) {
                oVar.uOo = "-1";
            }
            String valueOf;
            if (!bo.isNullOrNil(oVar.uOo)) {
                if (!oVar.uOo.equals("WeNoteHtmlFile")) {
                    if (!oVar.uOo.equals("-1")) {
                        int i = bo.getInt(oVar.uOo.substring(7), 0);
                        int i2 = bo.getInt(this.uMU.substring(7), 0);
                        StringBuilder stringBuilder = new StringBuilder("WeNote_");
                        if (i2 > i) {
                            valueOf = String.valueOf(i2);
                        } else {
                            valueOf = String.valueOf(i);
                        }
                        this.uMU = stringBuilder.append(valueOf).toString();
                    }
                    oVar.mnd = aar.mnd;
                    String b;
                    String str;
                    switch (aar.dataType) {
                        case 1:
                            if (!bo.isNullOrNil(aar.desc)) {
                                if (wVar.uOF.size() > 0 && wVar.uOF.get(wVar.uOF.size() - 1) != null && ((o) wVar.uOF.get(wVar.uOF.size() - 1)).uOo.equals("-1")) {
                                    t tVar = (t) wVar.uOF.get(wVar.uOF.size() - 1);
                                    tVar.content += aar.desc;
                                    break;
                                }
                                i iVar = new i();
                                iVar.uOo = oVar.uOo;
                                iVar.content = aar.desc;
                                wVar.uOF.add(iVar);
                                break;
                            }
                            break;
                            break;
                        case 2:
                            f fVar = new f();
                            fVar.uOo = oVar.uOo;
                            fVar.type = 2;
                            fVar.mnd = oVar.mnd;
                            fVar.uOn = aar;
                            b = b(aar);
                            if (!bo.isNullOrNil(b)) {
                                str = b + "_bigthumb";
                                String c = c(aar);
                                if (!e.ct(c)) {
                                    a(aar, c);
                                }
                                if (e.ct(b)) {
                                    fVar.uOp = true;
                                    c.ht(b, str);
                                } else {
                                    n(aar);
                                    fVar.uOp = false;
                                    this.uMS.put(aar.mnd, oVar.uOo);
                                }
                                fVar.cHg = str;
                                fVar.uOq = b;
                                wVar.uOF.add(fVar);
                                this.uMT.put(oVar.uOo, fVar);
                                break;
                            }
                            break;
                        case 3:
                        case 20:
                            v bVar;
                            if (aar.dataType == 20) {
                                bVar = new b();
                                if (!bo.isNullOrNil(aar.wfZ)) {
                                    ((b) bVar).qxI = true;
                                }
                            } else {
                                bVar = new l();
                            }
                            bVar.uOo = oVar.uOo;
                            bVar.type = 4;
                            bVar.mnd = oVar.mnd;
                            bVar.uOn = aar;
                            valueOf = b(aar);
                            if (bo.isNullOrNil(valueOf) || !e.ct(valueOf)) {
                                n(aar);
                                bVar.uOp = false;
                                bVar.uOD = ah.getContext().getString(R.string.bsg);
                                this.uMS.put(aar.mnd, oVar.uOo);
                            } else {
                                bVar.uOp = true;
                                bVar.hNN = uNb;
                                bVar.length = (int) f.fY((long) aar.duration);
                            }
                            bVar.cHg = valueOf;
                            bVar.uOC = f.K(ah.getContext(), (int) f.fY((long) aar.duration));
                            bVar.cAP = aar.duration;
                            gh ghVar = new gh();
                            ghVar.cAH.type = 17;
                            ghVar.cAH.cAJ = aar;
                            a.xxA.m(ghVar);
                            bVar.cAO = ghVar.cAI.ret;
                            bVar.uOf = aar.wgo;
                            wVar.uOF.add(bVar);
                            this.uMT.put(oVar.uOo, bVar);
                            break;
                        case 4:
                            k kVar = new k();
                            kVar.uOo = oVar.uOo;
                            kVar.type = 6;
                            kVar.mnd = oVar.mnd;
                            kVar.uOn = aar;
                            if (aar != null) {
                                kVar.duration = aar.duration;
                            }
                            kVar.thumbPath = c(aar);
                            str = b(aar);
                            kVar.cHg = str;
                            if (!(bo.isNullOrNil(kVar.thumbPath) || e.ct(kVar.thumbPath))) {
                                if (e.ct(str)) {
                                    Bitmap LY = com.tencent.mm.plugin.fav.ui.c.LY(str);
                                    if (LY != null) {
                                        try {
                                            ab.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                            com.tencent.mm.pluginsdk.i.f.a(LY, CompressFormat.JPEG, kVar.thumbPath, true);
                                        } catch (Exception e2) {
                                            ab.printErrStackTrace("MicroMsg.WNNoteBase", e2, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    a(aar, kVar.thumbPath);
                                    this.uMS.put(aar.mnd + "_t", oVar.uOo);
                                }
                            }
                            if (bo.isNullOrNil(str) || !e.ct(str)) {
                                kVar.uOp = false;
                                this.uMS.put(aar.mnd, oVar.uOo);
                            } else {
                                kVar.uOp = true;
                            }
                            wVar.uOF.add(kVar);
                            this.uMT.put(oVar.uOo, kVar);
                            break;
                        case 6:
                            r rVar = new r();
                            rVar.cEB = (float) aar.wgT.why.lat;
                            rVar.fFz = (float) aar.wgT.why.lng;
                            rVar.cED = aar.wgT.why.cED;
                            rVar.uOy = aar.wgT.why.label;
                            rVar.uOz = aar.wgT.why.cIK;
                            rVar.uOA = aar.whb;
                            com.tencent.mm.plugin.wenote.model.a.g gVar = new com.tencent.mm.plugin.wenote.model.a.g();
                            gVar.uOo = oVar.uOo;
                            gVar.type = 3;
                            gVar.mnd = oVar.mnd;
                            gVar.uOn = aar;
                            gVar.uOp = true;
                            gVar.eUu = rVar.uOz;
                            gVar.fBg = rVar.uOy;
                            gVar.lat = (double) rVar.cEB;
                            gVar.lng = (double) rVar.fFz;
                            gVar.scale = (double) rVar.cED;
                            gVar.cHg = "";
                            wVar.uOF.add(gVar);
                            this.uMT.put(oVar.uOo, gVar);
                            break;
                        case 8:
                            com.tencent.mm.plugin.wenote.model.a.d dVar = new com.tencent.mm.plugin.wenote.model.a.d();
                            dVar.uOo = oVar.uOo;
                            dVar.type = 5;
                            dVar.mnd = oVar.mnd;
                            dVar.uOn = aar;
                            b = b(aar);
                            if (bo.isNullOrNil(b) || !e.ct(b)) {
                                dVar.uOp = false;
                                this.uMS.put(aar.mnd, oVar.uOo);
                            } else {
                                dVar.uOp = true;
                                dVar.cHg = b;
                            }
                            dVar.hNN = h.aha(aar.wgo);
                            dVar.title = aar.title;
                            dVar.content = aar.desc;
                            dVar.uOf = aar.wgo;
                            if (bo.isNullOrNil(dVar.content)) {
                                dVar.content = f.aC((float) aar.wgu);
                            }
                            wVar.uOF.add(dVar);
                            this.uMT.put(oVar.uOo, dVar);
                            break;
                        default:
                            if (aar.dataType <= 0) {
                                break;
                            }
                            j jVar = new j();
                            jVar.uOo = oVar.uOo;
                            jVar.type = 0;
                            jVar.mnd = oVar.mnd;
                            jVar.uOn = aar;
                            String b2 = b(aar);
                            jVar.uOp = true;
                            jVar.cHg = b2;
                            jVar.hNN = uNf;
                            jVar.title = ah.getContext().getResources().getString(R.string.bqr);
                            jVar.content = ah.getContext().getResources().getString(R.string.bpw);
                            wVar.uOF.add(jVar);
                            this.uMT.put(oVar.uOo, jVar);
                            break;
                    }
                }
                valueOf = b(aar);
                List ahg2;
                if (bo.isNullOrNil(valueOf) || !e.ct(valueOf)) {
                    n(aar);
                    wVar.uOG = true;
                    ab.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", aar.mnd);
                    this.uMS.put(aar.mnd, oVar.uOo);
                    ahg2 = list2;
                } else {
                    try {
                        wVar.uOE = e.cy(valueOf);
                        ahg2 = com.tencent.mm.plugin.wenote.b.b.ahg(wVar.uOE);
                        try {
                            ab.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", aar.mnd);
                            uMX.containsKey(wVar.uOE);
                        } catch (Exception e3) {
                            e = e3;
                            ab.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
                            ab.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(bo.isNullOrNil(aar.wfZ)), Boolean.valueOf(bo.isNullOrNil(aar.wgb)));
                            list2 = ahg2;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        ahg2 = list2;
                    }
                }
                ab.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(bo.isNullOrNil(aar.wfZ)), Boolean.valueOf(bo.isNullOrNil(aar.wgb)));
                list2 = ahg2;
            } else {
                ab.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
                valueOf = b(aar);
                if (bo.isNullOrNil(valueOf) || !e.ct(valueOf)) {
                    n(aar);
                    return;
                } else {
                    f.y(this.uMP.cHh, valueOf);
                    return;
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            h.a(wVar.uOF, list2, true);
        }
        if (this.uMP.cvx == -1) {
            this.uMR.put(Long.toString(this.uMP.cHh), wVar);
        } else {
            this.uMR.put(Long.toString(this.uMP.cvx), wVar);
        }
    }

    public final void b(ld ldVar) {
        if (ldVar.cGU == null) {
            ab.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
            return;
        }
        String str = ldVar.cGU.cGW;
        o oVar = (o) this.uMT.get(str);
        if (oVar == null) {
            ab.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
            return;
        }
        ab.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", Integer.valueOf(oVar.type));
        switch (oVar.type) {
            case 2:
                bo(ldVar.cGU.context, str);
                return;
            case 3:
                bn(ldVar.cGU.context, str);
                return;
            case 5:
                bm(ldVar.cGU.context, str);
                return;
            case 6:
                bp(ldVar.cGU.context, str);
                return;
            default:
                return;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static abf a(String str, List<o> list, aar aar) {
        String bvl;
        LinkedList linkedList = new LinkedList();
        abf abf = new abf();
        if (aar != null) {
            linkedList.add(aar);
        } else if (!bo.isNullOrNil(str) && str.length() > 0) {
            bvl = an.bvl();
            aar aar2 = new aar();
            aar2.LE(8);
            aar2.ale("WeNoteHtmlFile");
            aar2.oY(true);
            aar2.mf(e.asZ(bvl));
            aar2.akR(".htm");
            linkedList.add(aar2);
            String o = f.o(aar2);
            if (!e.ct(o)) {
                e.y(bvl, o);
            }
            aar2.akV(o);
        }
        for (o oVar : list) {
            if (oVar != null) {
                if (oVar.uOn != null) {
                    linkedList.add(oVar.uOn);
                } else {
                    aar aar3 = new aar();
                    aas aas = new aas();
                    aat aat = new aat();
                    aat.LI(6);
                    aas.c(aat);
                    aar3.a(aas);
                    switch (oVar.type) {
                        case 1:
                            if (!uNa) {
                                h.pYm.e(14547, Integer.valueOf(6));
                                uNa = true;
                            }
                            aar3.LE(1);
                            aar3.oX(true);
                            aar3.oY(true);
                            i iVar = (i) oVar;
                            aar3.akU(oVar.mnd);
                            aar3.akI(com.tencent.mm.plugin.wenote.b.b.ahh(iVar.content));
                            if (!bo.isNullOrNil(aar3.desc) && aar3.desc.length() > 1000) {
                                aar3.akI(aar3.desc.substring(0, 1000));
                            }
                        case 2:
                            aar3.LE(2);
                            p pVar = (p) oVar;
                            bvl = pVar.uOq;
                            aar3.akV(bvl);
                            if (bo.isNullOrNil(((p) oVar).mnd)) {
                                aar3.akU(f.agW(pVar.toString()));
                                com.tencent.mm.sdk.platformtools.d.c(bvl, 150, 150, CompressFormat.JPEG, 90, f.c(aar3));
                                aar3.akW(f.c(aar3));
                            } else {
                                aar3.akU(oVar.mnd);
                                aar3.akW(pVar.cHg);
                            }
                            aar3.LE(2);
                        case 3:
                            aar3.LE(6);
                            s sVar = (s) oVar;
                            aar3.akU(oVar.mnd);
                            aay aay = new aay();
                            aay.alu(sVar.fBg);
                            aay.E(sVar.lat);
                            aay.D(sVar.lng);
                            aay.LJ((int) sVar.scale);
                            aay.alv(sVar.eUu);
                            aar3.oX(true);
                            aar3.oY(true);
                            aar3.wgT.a(aay);
                        case 4:
                            aar3.LE(3);
                            v vVar = (v) oVar;
                            aar3.akU(oVar.mnd);
                            String str2 = vVar.cHg;
                            if (!(bo.isNullOrNil(str2) || str2.length() == 0)) {
                                aar3.akV(str2);
                                aar3.LD(vVar.cAP);
                                aar3.oY(true);
                                aar3.akR(vVar.uOf);
                            }
                        case 5:
                            aar3.LE(8);
                            u uVar = (u) oVar;
                            aar3.akU(oVar.mnd);
                            aar3.akV(uVar.cHg);
                            aar3.oY(true);
                            aar3.akH(uVar.title);
                            aar3.akI(uVar.content);
                            aar3.akR(uVar.uOf);
                            aar3.ale(oVar.uOo);
                            linkedList.add(aar3);
                            break;
                        case 6:
                            aar3.LE(4);
                            k kVar = (k) oVar;
                            aar3.akU(oVar.mnd);
                            aar3.akV(kVar.cHg);
                            aar3.akW(kVar.thumbPath);
                            com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(kVar.cHg);
                            if (WR != null) {
                                aar3.LD(WR.ckU());
                            } else {
                                aar3.LD(1);
                            }
                            aar3.akR(kVar.uOf);
                            aar3.ale(oVar.uOo);
                            linkedList.add(aar3);
                            break;
                    }
                    aar3.ale(oVar.uOo);
                    linkedList.add(aar3);
                }
            }
        }
        a(linkedList, (List) list);
        abf.aE(linkedList);
        return abf;
    }

    private static void a(LinkedList<aar> linkedList, List<o> list) {
        ab.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
        if (linkedList.size() > 0) {
            int size = linkedList.size();
            int i = 0;
            while (i < size) {
                aar aar = (aar) linkedList.get(i);
                if (i > 0 && bo.isNullOrNil(aar.wfZ)) {
                    aar.akU(f.agW(aar.toString()));
                    o oVar = null;
                    if (i - 1 >= 0 && i - 1 < list.size() && list.size() > 0) {
                        oVar = (o) list.get(i - 1);
                    }
                    if (!(oVar == null || oVar.uOo == null || !oVar.uOo.equals(aar.whb))) {
                        oVar.mnd = aar.mnd;
                    }
                }
                if (i <= 0 || bo.isNullOrNil(aar.wfZ) || bo.isNullOrNil(aar.wgb)) {
                    String atg;
                    String x;
                    ab.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", Integer.valueOf(i), Integer.valueOf(aar.dataType));
                    String str = aar.wgx;
                    if (e.ct(str)) {
                        ab.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", str);
                        atg = e.atg(str);
                        x = com.tencent.mm.a.g.x(e.e(str, 0, 256));
                        aar.akS(atg);
                        aar.akT(x);
                        aar.mf(new com.tencent.mm.vfs.b(str).length());
                        atg = f.o(aar);
                        boolean ct = e.ct(atg);
                        if (!(str.equals(atg) || ct || "WeNoteHtmlFile".equals(aar.whb))) {
                            e.y(str, atg);
                        }
                    } else {
                        ab.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", str);
                    }
                    str = aar.wgz;
                    if (e.ct(str)) {
                        ab.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", str);
                        atg = e.atg(str);
                        x = com.tencent.mm.a.g.cA(str);
                        aar.akX(atg);
                        aar.akY(x);
                        aar.mg(new com.tencent.mm.vfs.b(str).length());
                        String c = f.c(aar);
                        if (!(str.equals(c) || e.ct(c))) {
                            e.y(str, c);
                        }
                    } else {
                        ab.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", str);
                    }
                } else {
                    aar.oX(true);
                    aar.oY(true);
                }
                i++;
            }
        }
    }

    public void agU(String str) {
    }

    private void bp(Context context, String str) {
        k kVar = (k) this.uMT.get(str);
        if (!bo.isNullOrNil(kVar.cHg)) {
            if (!e.ct(kVar.cHg)) {
                aar agV = agV(kVar.mnd);
                if (agV == null) {
                    ab.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
                    return;
                }
                n(agV);
            }
            Intent intent = new Intent();
            if (this.uMQ == null) {
                intent.putExtra("key_detail_info_id", 0);
            } else {
                intent.putExtra("key_detail_info_id", this.uMQ.field_localId);
            }
            intent.putExtra("key_detail_fav_path", kVar.cHg);
            intent.putExtra("key_detail_fav_thumb_path", kVar.thumbPath);
            intent.putExtra("key_detail_fav_video_duration", kVar.duration);
            intent.putExtra("key_detail_data_id", kVar.mnd);
            intent.putExtra("key_detail_statExtStr", "");
            intent.putExtra("key_detail_fav_video_show_download_status", true);
            com.tencent.mm.plugin.fav.a.b.a(context, ".ui.detail.FavoriteVideoPlayUI", intent, 1);
        }
    }

    public final aar agV(String str) {
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
            return null;
        }
        String str2 = (String) this.uMS.get(str);
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", str);
            return null;
        }
        o oVar = (o) this.uMT.get(str2);
        if (oVar != null) {
            return oVar.uOn;
        }
        ab.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", str2);
        return null;
    }

    public String ddH() {
        return "";
    }
}
