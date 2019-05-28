package com.tencent.p177mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C18313ld;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.plugin.fav.p407a.C11851an;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.wenote.model.p585a.C23178g;
import com.tencent.p177mm.plugin.wenote.model.p585a.C23179p;
import com.tencent.p177mm.plugin.wenote.model.p585a.C24930f;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29978o;
import com.tencent.p177mm.plugin.wenote.model.p585a.C35738s;
import com.tencent.p177mm.plugin.wenote.model.p585a.C35739t;
import com.tencent.p177mm.plugin.wenote.model.p585a.C35740u;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40366k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40367r;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44002d;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44003l;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44004m;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44794b;
import com.tencent.p177mm.plugin.wenote.model.p585a.C46451j;
import com.tencent.p177mm.plugin.wenote.model.p585a.C4667v;
import com.tencent.p177mm.plugin.wenote.model.p585a.C4668w;
import com.tencent.p177mm.plugin.wenote.p1333b.C23176b;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.pluginsdk.p1082i.C44053f;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aas;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.wenote.model.d */
public abstract class C40369d {
    public static String uMW = "";
    public static HashMap<String, JSONArray> uMX = new HashMap();
    public static boolean uNa = false;
    public static String uNb = (C11851an.bvi() + "/fav_fileicon_recording.png");
    private static String uNc = (C11851an.bvi() + "/ofm_file_icon.png");
    private static String uNd = (C11851an.bvi() + "/app_attach_file_icon_pic.png");
    public static String uNe = (C11851an.bvi() + "/location_msg.png");
    public static String uNf = (C11851an.bvi() + "/note_fav_not_support.png");
    public C44004m uMP = null;
    public C27966g uMQ;
    public HashMap<String, C4668w> uMR = new HashMap();
    public HashMap<String, String> uMS = new HashMap();
    public HashMap<String, C29978o> uMT = new HashMap();
    public String uMU = "WeNote_0";
    public String uMV = "";
    public boolean uMY = false;
    public abf uMZ = new abf();

    /* renamed from: a */
    public abstract void mo26987a(aar aar, String str);

    /* renamed from: b */
    public abstract String mo26990b(aar aar);

    /* renamed from: bm */
    public abstract void mo26991bm(Context context, String str);

    /* renamed from: bn */
    public abstract void mo26992bn(Context context, String str);

    /* renamed from: bo */
    public abstract void mo26993bo(Context context, String str);

    /* renamed from: c */
    public abstract String mo26994c(aar aar);

    /* renamed from: n */
    public abstract void mo26996n(aar aar);

    /* renamed from: ef */
    public final void mo63731ef(List<aar> list) {
        ArrayList ahg;
        Throwable e;
        C4668w c4668w = new C4668w();
        List list2 = null;
        for (aar aar : list) {
            C29978o c29978o = new C29978o();
            c29978o.uOo = aar.whb;
            if (aar.dataType == 1) {
                c29978o.uOo = "-1";
            }
            String valueOf;
            if (!C5046bo.isNullOrNil(c29978o.uOo)) {
                if (!c29978o.uOo.equals("WeNoteHtmlFile")) {
                    if (!c29978o.uOo.equals("-1")) {
                        int i = C5046bo.getInt(c29978o.uOo.substring(7), 0);
                        int i2 = C5046bo.getInt(this.uMU.substring(7), 0);
                        StringBuilder stringBuilder = new StringBuilder("WeNote_");
                        if (i2 > i) {
                            valueOf = String.valueOf(i2);
                        } else {
                            valueOf = String.valueOf(i);
                        }
                        this.uMU = stringBuilder.append(valueOf).toString();
                    }
                    c29978o.mnd = aar.mnd;
                    String b;
                    String str;
                    switch (aar.dataType) {
                        case 1:
                            if (!C5046bo.isNullOrNil(aar.desc)) {
                                if (c4668w.uOF.size() > 0 && c4668w.uOF.get(c4668w.uOF.size() - 1) != null && ((C29978o) c4668w.uOF.get(c4668w.uOF.size() - 1)).uOo.equals("-1")) {
                                    C35739t c35739t = (C35739t) c4668w.uOF.get(c4668w.uOF.size() - 1);
                                    c35739t.content += aar.desc;
                                    break;
                                }
                                C40365i c40365i = new C40365i();
                                c40365i.uOo = c29978o.uOo;
                                c40365i.content = aar.desc;
                                c4668w.uOF.add(c40365i);
                                break;
                            }
                            break;
                            break;
                        case 2:
                            C24930f c24930f = new C24930f();
                            c24930f.uOo = c29978o.uOo;
                            c24930f.type = 2;
                            c24930f.mnd = c29978o.mnd;
                            c24930f.uOn = aar;
                            b = mo26990b(aar);
                            if (!C5046bo.isNullOrNil(b)) {
                                str = b + "_bigthumb";
                                String c = mo26994c(aar);
                                if (!C5730e.m8628ct(c)) {
                                    mo26987a(aar, c);
                                }
                                if (C5730e.m8628ct(b)) {
                                    c24930f.uOp = true;
                                    C29977c.m47432ht(b, str);
                                } else {
                                    mo26996n(aar);
                                    c24930f.uOp = false;
                                    this.uMS.put(aar.mnd, c29978o.uOo);
                                }
                                c24930f.cHg = str;
                                c24930f.uOq = b;
                                c4668w.uOF.add(c24930f);
                                this.uMT.put(c29978o.uOo, c24930f);
                                break;
                            }
                            break;
                        case 3:
                        case 20:
                            C4667v c44794b;
                            if (aar.dataType == 20) {
                                c44794b = new C44794b();
                                if (!C5046bo.isNullOrNil(aar.wfZ)) {
                                    ((C44794b) c44794b).qxI = true;
                                }
                            } else {
                                c44794b = new C44003l();
                            }
                            c44794b.uOo = c29978o.uOo;
                            c44794b.type = 4;
                            c44794b.mnd = c29978o.mnd;
                            c44794b.uOn = aar;
                            valueOf = mo26990b(aar);
                            if (C5046bo.isNullOrNil(valueOf) || !C5730e.m8628ct(valueOf)) {
                                mo26996n(aar);
                                c44794b.uOp = false;
                                c44794b.uOD = C4996ah.getContext().getString(C25738R.string.bsg);
                                this.uMS.put(aar.mnd, c29978o.uOo);
                            } else {
                                c44794b.uOp = true;
                                c44794b.hNN = uNb;
                                c44794b.length = (int) C14719f.m22908fY((long) aar.duration);
                            }
                            c44794b.cHg = valueOf;
                            c44794b.uOC = C14719f.m22903K(C4996ah.getContext(), (int) C14719f.m22908fY((long) aar.duration));
                            c44794b.cAP = aar.duration;
                            C37721gh c37721gh = new C37721gh();
                            c37721gh.cAH.type = 17;
                            c37721gh.cAH.cAJ = aar;
                            C4879a.xxA.mo10055m(c37721gh);
                            c44794b.cAO = c37721gh.cAI.ret;
                            c44794b.uOf = aar.wgo;
                            c4668w.uOF.add(c44794b);
                            this.uMT.put(c29978o.uOo, c44794b);
                            break;
                        case 4:
                            C40366k c40366k = new C40366k();
                            c40366k.uOo = c29978o.uOo;
                            c40366k.type = 6;
                            c40366k.mnd = c29978o.mnd;
                            c40366k.uOn = aar;
                            if (aar != null) {
                                c40366k.duration = aar.duration;
                            }
                            c40366k.thumbPath = mo26994c(aar);
                            str = mo26990b(aar);
                            c40366k.cHg = str;
                            if (!(C5046bo.isNullOrNil(c40366k.thumbPath) || C5730e.m8628ct(c40366k.thumbPath))) {
                                if (C5730e.m8628ct(str)) {
                                    Bitmap LY = C45932c.m85253LY(str);
                                    if (LY != null) {
                                        try {
                                            C4990ab.m7416i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                            C44053f.m79182a(LY, CompressFormat.JPEG, c40366k.thumbPath, true);
                                        } catch (Exception e2) {
                                            C4990ab.printErrStackTrace("MicroMsg.WNNoteBase", e2, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    mo26987a(aar, c40366k.thumbPath);
                                    this.uMS.put(aar.mnd + "_t", c29978o.uOo);
                                }
                            }
                            if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
                                c40366k.uOp = false;
                                this.uMS.put(aar.mnd, c29978o.uOo);
                            } else {
                                c40366k.uOp = true;
                            }
                            c4668w.uOF.add(c40366k);
                            this.uMT.put(c29978o.uOo, c40366k);
                            break;
                        case 6:
                            C40367r c40367r = new C40367r();
                            c40367r.cEB = (float) aar.wgT.why.lat;
                            c40367r.fFz = (float) aar.wgT.why.lng;
                            c40367r.cED = aar.wgT.why.cED;
                            c40367r.uOy = aar.wgT.why.label;
                            c40367r.uOz = aar.wgT.why.cIK;
                            c40367r.uOA = aar.whb;
                            C23178g c23178g = new C23178g();
                            c23178g.uOo = c29978o.uOo;
                            c23178g.type = 3;
                            c23178g.mnd = c29978o.mnd;
                            c23178g.uOn = aar;
                            c23178g.uOp = true;
                            c23178g.eUu = c40367r.uOz;
                            c23178g.fBg = c40367r.uOy;
                            c23178g.lat = (double) c40367r.cEB;
                            c23178g.lng = (double) c40367r.fFz;
                            c23178g.scale = (double) c40367r.cED;
                            c23178g.cHg = "";
                            c4668w.uOF.add(c23178g);
                            this.uMT.put(c29978o.uOo, c23178g);
                            break;
                        case 8:
                            C44002d c44002d = new C44002d();
                            c44002d.uOo = c29978o.uOo;
                            c44002d.type = 5;
                            c44002d.mnd = c29978o.mnd;
                            c44002d.uOn = aar;
                            b = mo26990b(aar);
                            if (C5046bo.isNullOrNil(b) || !C5730e.m8628ct(b)) {
                                c44002d.uOp = false;
                                this.uMS.put(aar.mnd, c29978o.uOo);
                            } else {
                                c44002d.uOp = true;
                                c44002d.cHg = b;
                            }
                            c44002d.hNN = C29980h.aha(aar.wgo);
                            c44002d.title = aar.title;
                            c44002d.content = aar.desc;
                            c44002d.uOf = aar.wgo;
                            if (C5046bo.isNullOrNil(c44002d.content)) {
                                c44002d.content = C14719f.m22905aC((float) aar.wgu);
                            }
                            c4668w.uOF.add(c44002d);
                            this.uMT.put(c29978o.uOo, c44002d);
                            break;
                        default:
                            if (aar.dataType <= 0) {
                                break;
                            }
                            C46451j c46451j = new C46451j();
                            c46451j.uOo = c29978o.uOo;
                            c46451j.type = 0;
                            c46451j.mnd = c29978o.mnd;
                            c46451j.uOn = aar;
                            String b2 = mo26990b(aar);
                            c46451j.uOp = true;
                            c46451j.cHg = b2;
                            c46451j.hNN = uNf;
                            c46451j.title = C4996ah.getContext().getResources().getString(C25738R.string.bqr);
                            c46451j.content = C4996ah.getContext().getResources().getString(C25738R.string.bpw);
                            c4668w.uOF.add(c46451j);
                            this.uMT.put(c29978o.uOo, c46451j);
                            break;
                    }
                }
                valueOf = mo26990b(aar);
                List ahg2;
                if (C5046bo.isNullOrNil(valueOf) || !C5730e.m8628ct(valueOf)) {
                    mo26996n(aar);
                    c4668w.uOG = true;
                    C4990ab.m7417i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", aar.mnd);
                    this.uMS.put(aar.mnd, c29978o.uOo);
                    ahg2 = list2;
                } else {
                    try {
                        c4668w.uOE = C5730e.m8631cy(valueOf);
                        ahg2 = C23176b.ahg(c4668w.uOE);
                        try {
                            C4990ab.m7417i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", aar.mnd);
                            uMX.containsKey(c4668w.uOE);
                        } catch (Exception e3) {
                            e = e3;
                            C4990ab.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
                            C4990ab.m7417i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(C5046bo.isNullOrNil(aar.wfZ)), Boolean.valueOf(C5046bo.isNullOrNil(aar.wgb)));
                            list2 = ahg2;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        ahg2 = list2;
                    }
                }
                C4990ab.m7417i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(C5046bo.isNullOrNil(aar.wfZ)), Boolean.valueOf(C5046bo.isNullOrNil(aar.wgb)));
                list2 = ahg2;
            } else {
                C4990ab.m7412e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
                valueOf = mo26990b(aar);
                if (C5046bo.isNullOrNil(valueOf) || !C5730e.m8628ct(valueOf)) {
                    mo26996n(aar);
                    return;
                } else {
                    C14719f.m22911y(this.uMP.cHh, valueOf);
                    return;
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            C29980h.m47435a(c4668w.uOF, list2, true);
        }
        if (this.uMP.cvx == -1) {
            this.uMR.put(Long.toString(this.uMP.cHh), c4668w);
        } else {
            this.uMR.put(Long.toString(this.uMP.cvx), c4668w);
        }
    }

    /* renamed from: b */
    public final void mo63730b(C18313ld c18313ld) {
        if (c18313ld.cGU == null) {
            C4990ab.m7412e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
            return;
        }
        String str = c18313ld.cGU.cGW;
        C29978o c29978o = (C29978o) this.uMT.get(str);
        if (c29978o == null) {
            C4990ab.m7412e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
            return;
        }
        C4990ab.m7417i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", Integer.valueOf(c29978o.type));
        switch (c29978o.type) {
            case 2:
                mo26993bo(c18313ld.cGU.context, str);
                return;
            case 3:
                mo26992bn(c18313ld.cGU.context, str);
                return;
            case 5:
                mo26991bm(c18313ld.cGU.context, str);
                return;
            case 6:
                m69213bp(c18313ld.cGU.context, str);
                return;
            default:
                return;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static abf m69211a(String str, List<C29978o> list, aar aar) {
        String bvl;
        LinkedList linkedList = new LinkedList();
        abf abf = new abf();
        if (aar != null) {
            linkedList.add(aar);
        } else if (!C5046bo.isNullOrNil(str) && str.length() > 0) {
            bvl = C11851an.bvl();
            aar aar2 = new aar();
            aar2.mo27394LE(8);
            aar2.ale("WeNoteHtmlFile");
            aar2.mo27435oY(true);
            aar2.mo27431mf(C5730e.asZ(bvl));
            aar2.akR(".htm");
            linkedList.add(aar2);
            String o = C14719f.m22910o(aar2);
            if (!C5730e.m8628ct(o)) {
                C5730e.m8644y(bvl, o);
            }
            aar2.akV(o);
        }
        for (C29978o c29978o : list) {
            if (c29978o != null) {
                if (c29978o.uOn != null) {
                    linkedList.add(c29978o.uOn);
                } else {
                    aar aar3 = new aar();
                    aas aas = new aas();
                    aat aat = new aat();
                    aat.mo64043LI(6);
                    aas.mo48444c(aat);
                    aar3.mo27398a(aas);
                    switch (c29978o.type) {
                        case 1:
                            if (!uNa) {
                                C7060h.pYm.mo8381e(14547, Integer.valueOf(6));
                                uNa = true;
                            }
                            aar3.mo27394LE(1);
                            aar3.mo27434oX(true);
                            aar3.mo27435oY(true);
                            C40365i c40365i = (C40365i) c29978o;
                            aar3.akU(c29978o.mnd);
                            aar3.akI(C23176b.ahh(c40365i.content));
                            if (!C5046bo.isNullOrNil(aar3.desc) && aar3.desc.length() > 1000) {
                                aar3.akI(aar3.desc.substring(0, 1000));
                            }
                        case 2:
                            aar3.mo27394LE(2);
                            C23179p c23179p = (C23179p) c29978o;
                            bvl = c23179p.uOq;
                            aar3.akV(bvl);
                            if (C5046bo.isNullOrNil(((C23179p) c29978o).mnd)) {
                                aar3.akU(C14719f.agW(c23179p.toString()));
                                C5056d.m7656c(bvl, 150, 150, CompressFormat.JPEG, 90, C14719f.m22907c(aar3));
                                aar3.akW(C14719f.m22907c(aar3));
                            } else {
                                aar3.akU(c29978o.mnd);
                                aar3.akW(c23179p.cHg);
                            }
                            aar3.mo27394LE(2);
                        case 3:
                            aar3.mo27394LE(6);
                            C35738s c35738s = (C35738s) c29978o;
                            aar3.akU(c29978o.mnd);
                            aay aay = new aay();
                            aay.alu(c35738s.fBg);
                            aay.mo15621E(c35738s.lat);
                            aay.mo15620D(c35738s.lng);
                            aay.mo15622LJ((int) c35738s.scale);
                            aay.alv(c35738s.eUu);
                            aar3.mo27434oX(true);
                            aar3.mo27435oY(true);
                            aar3.wgT.mo48440a(aay);
                        case 4:
                            aar3.mo27394LE(3);
                            C4667v c4667v = (C4667v) c29978o;
                            aar3.akU(c29978o.mnd);
                            String str2 = c4667v.cHg;
                            if (!(C5046bo.isNullOrNil(str2) || str2.length() == 0)) {
                                aar3.akV(str2);
                                aar3.mo27393LD(c4667v.cAP);
                                aar3.mo27435oY(true);
                                aar3.akR(c4667v.uOf);
                            }
                        case 5:
                            aar3.mo27394LE(8);
                            C35740u c35740u = (C35740u) c29978o;
                            aar3.akU(c29978o.mnd);
                            aar3.akV(c35740u.cHg);
                            aar3.mo27435oY(true);
                            aar3.akH(c35740u.title);
                            aar3.akI(c35740u.content);
                            aar3.akR(c35740u.uOf);
                            aar3.ale(c29978o.uOo);
                            linkedList.add(aar3);
                            break;
                        case 6:
                            aar3.mo27394LE(4);
                            C40366k c40366k = (C40366k) c29978o;
                            aar3.akU(c29978o.mnd);
                            aar3.akV(c40366k.cHg);
                            aar3.akW(c40366k.thumbPath);
                            C43528a WR = C21846d.m33388WR(c40366k.cHg);
                            if (WR != null) {
                                aar3.mo27393LD(WR.ckU());
                            } else {
                                aar3.mo27393LD(1);
                            }
                            aar3.akR(c40366k.uOf);
                            aar3.ale(c29978o.uOo);
                            linkedList.add(aar3);
                            break;
                    }
                    aar3.ale(c29978o.uOo);
                    linkedList.add(aar3);
                }
            }
        }
        C40369d.m69212a(linkedList, (List) list);
        abf.mo74738aE(linkedList);
        return abf;
    }

    /* renamed from: a */
    private static void m69212a(LinkedList<aar> linkedList, List<C29978o> list) {
        C4990ab.m7416i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
        if (linkedList.size() > 0) {
            int size = linkedList.size();
            int i = 0;
            while (i < size) {
                aar aar = (aar) linkedList.get(i);
                if (i > 0 && C5046bo.isNullOrNil(aar.wfZ)) {
                    aar.akU(C14719f.agW(aar.toString()));
                    C29978o c29978o = null;
                    if (i - 1 >= 0 && i - 1 < list.size() && list.size() > 0) {
                        c29978o = (C29978o) list.get(i - 1);
                    }
                    if (!(c29978o == null || c29978o.uOo == null || !c29978o.uOo.equals(aar.whb))) {
                        c29978o.mnd = aar.mnd;
                    }
                }
                if (i <= 0 || C5046bo.isNullOrNil(aar.wfZ) || C5046bo.isNullOrNil(aar.wgb)) {
                    String atg;
                    String x;
                    C4990ab.m7417i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", Integer.valueOf(i), Integer.valueOf(aar.dataType));
                    String str = aar.wgx;
                    if (C5730e.m8628ct(str)) {
                        C4990ab.m7417i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", str);
                        atg = C5730e.atg(str);
                        x = C1178g.m2591x(C5730e.m8632e(str, 0, 256));
                        aar.akS(atg);
                        aar.akT(x);
                        aar.mo27431mf(new C5728b(str).length());
                        atg = C14719f.m22910o(aar);
                        boolean ct = C5730e.m8628ct(atg);
                        if (!(str.equals(atg) || ct || "WeNoteHtmlFile".equals(aar.whb))) {
                            C5730e.m8644y(str, atg);
                        }
                    } else {
                        C4990ab.m7413e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", str);
                    }
                    str = aar.wgz;
                    if (C5730e.m8628ct(str)) {
                        C4990ab.m7417i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", str);
                        atg = C5730e.atg(str);
                        x = C1178g.m2586cA(str);
                        aar.akX(atg);
                        aar.akY(x);
                        aar.mo27432mg(new C5728b(str).length());
                        String c = C14719f.m22907c(aar);
                        if (!(str.equals(c) || C5730e.m8628ct(c))) {
                            C5730e.m8644y(str, c);
                        }
                    } else {
                        C4990ab.m7413e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", str);
                    }
                } else {
                    aar.mo27434oX(true);
                    aar.mo27435oY(true);
                }
                i++;
            }
        }
    }

    public void agU(String str) {
    }

    /* renamed from: bp */
    private void m69213bp(Context context, String str) {
        C40366k c40366k = (C40366k) this.uMT.get(str);
        if (!C5046bo.isNullOrNil(c40366k.cHg)) {
            if (!C5730e.m8628ct(c40366k.cHg)) {
                aar agV = agV(c40366k.mnd);
                if (agV == null) {
                    C4990ab.m7412e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
                    return;
                }
                mo26996n(agV);
            }
            Intent intent = new Intent();
            if (this.uMQ == null) {
                intent.putExtra("key_detail_info_id", 0);
            } else {
                intent.putExtra("key_detail_info_id", this.uMQ.field_localId);
            }
            intent.putExtra("key_detail_fav_path", c40366k.cHg);
            intent.putExtra("key_detail_fav_thumb_path", c40366k.thumbPath);
            intent.putExtra("key_detail_fav_video_duration", c40366k.duration);
            intent.putExtra("key_detail_data_id", c40366k.mnd);
            intent.putExtra("key_detail_statExtStr", "");
            intent.putExtra("key_detail_fav_video_show_download_status", true);
            C39037b.m66352a(context, ".ui.detail.FavoriteVideoPlayUI", intent, 1);
        }
    }

    public final aar agV(String str) {
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
            return null;
        }
        String str2 = (String) this.uMS.get(str);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", str);
            return null;
        }
        C29978o c29978o = (C29978o) this.uMT.get(str2);
        if (c29978o != null) {
            return c29978o.uOn;
        }
        C4990ab.m7413e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", str2);
        return null;
    }

    public String ddH() {
        return "";
    }
}
