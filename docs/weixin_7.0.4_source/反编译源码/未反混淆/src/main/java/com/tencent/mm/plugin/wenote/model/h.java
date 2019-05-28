package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abd;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.model.WMElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    private static Map<String, String> mid;
    public static String uNA = (an.bvi() + "/fav_fileicon_txt.png");
    public static String uNB = (an.bvi() + "/fav_fileicon_pdf.png");
    public static String uNC = (an.bvi() + "/fav_fileicon_unknow.png");
    private static String[] uND = new String[]{"<div>", "<div/>", "<object", "<br", "</"};
    private static String[] uNE = new String[]{"＜div>", "＜div/>", "＜object", "＜br", "＜/"};
    private static LinkedList<abd> uNF = null;
    private static String uNG = "";
    public static String uNt = (an.bvi() + "/fav_fileicon_video.png");
    public static String uNu = (an.bvi() + "/fav_fileicon_music.png");
    public static String uNv = (an.bvi() + "/fav_list_img_default.png");
    public static String uNw = (an.bvi() + "/fav_fileicon_zip.png");
    public static String uNx = (an.bvi() + "/fav_fileicon_word.png");
    public static String uNy = (an.bvi() + "/fav_fileicon_ppt.png");
    public static String uNz = (an.bvi() + "/fav_fileicon_xls.png");

    private static void aR(JSONObject jSONObject) {
        AppMethodBeat.i(26635);
        le leVar = new le();
        leVar.cHe.type = 6;
        leVar.cHe.jsonString = jSONObject.toString();
        leVar.cHe.cGW = "";
        a.xxA.m(leVar);
        AppMethodBeat.o(26635);
    }

    public static void q(Context context, String str, int i) {
        AppMethodBeat.i(26636);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(26636);
        } else if (e.ct(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                int fY = (int) f.fY((long) i);
                jSONObject.put("type", 4);
                jSONObject.put("downloaded", true);
                jSONObject.put("length", fY);
                jSONObject.put("lengthStr", f.K(context, fY));
                jSONObject.put("iconPath", an.bvi() + "/fav_fileicon_recording.png");
                aR(jSONObject);
                AppMethodBeat.o(26636);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                AppMethodBeat.o(26636);
            }
        } else {
            AppMethodBeat.o(26636);
        }
    }

    public static void agY(String str) {
        AppMethodBeat.i(26637);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(26637);
        } else if (e.ct(str)) {
            b bVar = new b(str);
            if (bVar.exists()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 5);
                    jSONObject.put("downloaded", true);
                    jSONObject.put("title", bVar.getName());
                    jSONObject.put(FirebaseAnalytics.b.CONTENT, f.aC((float) bVar.length()));
                    jSONObject.put("iconPath", aha(e.cv(str)));
                    jSONObject.put("localPath", str);
                    aR(jSONObject);
                    AppMethodBeat.o(26637);
                    return;
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                    AppMethodBeat.o(26637);
                    return;
                }
            }
            AppMethodBeat.o(26637);
        } else {
            AppMethodBeat.o(26637);
        }
    }

    public static void agZ(String str) {
        AppMethodBeat.i(26638);
        ab.i("MicroMsg.WNNoteLogic", "insert location run");
        JSONObject jSONObject = new JSONObject(str);
        ab.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
        Object obj = an.bvk() + "/" + g.x((new com.tencent.mm.pluginsdk.location.b(-1, (float) jSONObject.getDouble("lat"), (float) jSONObject.getDouble("lng"), jSONObject.getInt(WMElement.ANIMATE_TYPE_SCALE), 1).toString()).getBytes()) + ".png";
        ab.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", obj);
        if (e.ct(obj)) {
            ab.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
        }
        if (e.ct(obj)) {
            ab.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
        } else {
            ab.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", obj);
            obj = d.uNe;
        }
        jSONObject.put("localPath", obj);
        aR(jSONObject);
        AppMethodBeat.o(26638);
    }

    public static void ae(ArrayList<String> arrayList) {
        AppMethodBeat.i(26639);
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                jSONObject.put("type", 2);
                jSONObject.put("downloaded", true);
                String hs = c.hs(str, "");
                str = c.ht(str, "");
                if (bo.isNullOrNil(hs) || bo.isNullOrNil(str)) {
                    AppMethodBeat.o(26639);
                    return;
                }
                jSONObject.put("bigImagePath", hs);
                jSONObject.put("localPath", str);
                aR(jSONObject);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(26639);
    }

    public static void bq(Context context, String str) {
        int i;
        AppMethodBeat.i(26640);
        JSONObject jSONObject = new JSONObject();
        if (!bo.isNullOrNil(str)) {
            i = (int) k.ddK().duration;
            int fY = (int) f.fY((long) i);
            try {
                jSONObject.put("downloaded", true);
                jSONObject.put("length", i);
                jSONObject.put("lengthStr", f.K(context, fY));
                jSONObject.put("iconPath", an.bvi() + "/fav_fileicon_recording.png");
                jSONObject.put("localPath", str);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
        try {
            jSONObject.put("type", 4);
        } catch (JSONException e2) {
            ab.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
        }
        i = k.ddK().uNO;
        le leVar = new le();
        leVar.cHe.type = 6;
        leVar.cHe.jsonString = jSONObject.toString();
        leVar.cHe.cGW = Integer.toString(i);
        a.xxA.m(leVar);
        AppMethodBeat.o(26640);
    }

    static {
        AppMethodBeat.i(26646);
        mid = new HashMap();
        HashMap hashMap = new HashMap();
        mid = hashMap;
        hashMap.put("avi", uNt);
        mid.put("m4v", uNt);
        mid.put("vob", uNt);
        mid.put("mpeg", uNt);
        mid.put("mpe", uNt);
        mid.put("asx", uNt);
        mid.put("asf", uNt);
        mid.put("f4v", uNt);
        mid.put("flv", uNt);
        mid.put("mkv", uNt);
        mid.put("wmv", uNt);
        mid.put("wm", uNt);
        mid.put("3gp", uNt);
        mid.put("mp4", uNt);
        mid.put("rmvb", uNt);
        mid.put("rm", uNt);
        mid.put("ra", uNt);
        mid.put("ram", uNt);
        mid.put("mp3pro", uNu);
        mid.put("vqf", uNu);
        mid.put("cd", uNu);
        mid.put("md", uNu);
        mid.put("mod", uNu);
        mid.put("vorbis", uNu);
        mid.put("au", uNu);
        mid.put("amr", uNu);
        mid.put("silk", uNu);
        mid.put("wma", uNu);
        mid.put("mmf", uNu);
        mid.put("mid", uNu);
        mid.put("midi", uNu);
        mid.put("mp3", uNu);
        mid.put("aac", uNu);
        mid.put("ape", uNu);
        mid.put("aiff", uNu);
        mid.put("aif", uNu);
        mid.put("jfif", uNv);
        mid.put("tiff", uNv);
        mid.put("tif", uNv);
        mid.put("jpe", uNv);
        mid.put("dib", uNv);
        mid.put("jpeg", uNv);
        mid.put("jpg", uNv);
        mid.put("png", uNv);
        mid.put("bmp", uNv);
        mid.put("gif", uNv);
        mid.put("rar", uNw);
        mid.put("zip", uNw);
        mid.put("7z", uNw);
        mid.put("iso", uNw);
        mid.put("cab", uNw);
        mid.put("doc", uNx);
        mid.put("docx", uNx);
        mid.put("ppt", uNy);
        mid.put("pptx", uNy);
        mid.put("xls", uNz);
        mid.put("xlsx", uNz);
        mid.put("txt", uNA);
        mid.put("rtf", uNA);
        mid.put("pdf", uNB);
        mid.put("unknown", uNC);
        AppMethodBeat.o(26646);
    }

    public static String aha(String str) {
        AppMethodBeat.i(26641);
        String str2 = (String) mid.get(str);
        if (str2 == null) {
            str2 = (String) mid.get("unknown");
            AppMethodBeat.o(26641);
            return str2;
        }
        AppMethodBeat.o(26641);
        return str2;
    }

    public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> a(Object obj, List<String> list, boolean z) {
        AppMethodBeat.i(26642);
        if (obj == null) {
            AppMethodBeat.o(26642);
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
            if (cVar.getType() != 1) {
                arrayList2.add(cVar);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            if (str.trim().equals("<ThisisNoteNodeHrObj>")) {
                com.tencent.mm.plugin.wenote.model.a.h hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                hVar.uNT = false;
                hVar.uNZ = false;
                arrayList2.add(i, hVar);
            } else if (!str.trim().equals("<ThisisNoteNodeObj>")) {
                i iVar = new i();
                iVar.content = str;
                iVar.uNT = false;
                iVar.uNZ = false;
                iVar.mnd = f.agW(iVar.toString());
                if (i < arrayList2.size()) {
                    arrayList2.add(i, iVar);
                } else {
                    arrayList2.add(iVar);
                }
            }
        }
        if (z) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        AppMethodBeat.o(26642);
        return arrayList2;
    }

    public static void JW(int i) {
        LinkedList linkedList;
        AppMethodBeat.i(26643);
        uNF = null;
        uNG = "";
        String deu = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().deu();
        uNG = deu;
        LinkedList linkedList2 = new LinkedList();
        abf ahe = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().ahe(deu);
        if (ahe == null || ahe.wiv.size() <= 1) {
            linkedList = null;
        } else {
            Iterator it = ahe.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                String o = f.o(aar);
                if (!bo.isNullOrNil(o) && aar.dataType == 2 && e.ct(o)) {
                    abd abd = new abd();
                    abd.Md5 = aar.wgq;
                    abd.AesKey = aar.wgb;
                    abd.wip = aar.wfZ;
                    linkedList2.add(abd);
                }
            }
            linkedList = linkedList2;
        }
        uNF = linkedList;
        aw.Rg().a(new b(i, 1, uNG, uNF, null), 0);
        AppMethodBeat.o(26643);
    }

    public static void a(Context context, Bitmap bitmap, boolean z) {
        com.tencent.mm.plugin.report.service.h hVar;
        Object[] objArr;
        AppMethodBeat.i(26644);
        String RL = com.tencent.mm.sdk.f.a.RL("jpg");
        if (bitmap != null) {
            try {
                d.a(bitmap, 100, CompressFormat.JPEG, RL, true);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                ab.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
                hVar = com.tencent.mm.plugin.report.service.h.pYm;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(0);
                objArr[1] = Integer.valueOf(0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(3);
                objArr[4] = Integer.valueOf(z ? 1 : 0);
                hVar.e(14811, objArr);
                RL = "";
            }
        } else {
            ab.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
            hVar = com.tencent.mm.plugin.report.service.h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(1);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            hVar.e(14811, objArr);
            RL = "";
        }
        if (!bo.isNullOrNil(RL)) {
            com.tencent.mm.sdk.f.a.a(RL, context);
        }
        b bVar = new b(RL);
        if (bVar.exists()) {
            long length = bVar.length() / 1024;
            int i = 0;
            int i2 = 0;
            if (bitmap != null) {
                i = bitmap.getWidth();
                i2 = bitmap.getHeight();
                bitmap.recycle();
            }
            int i3 = i2;
            int i4 = i;
            abd abd = new abd();
            abd.Md5 = e.atg(RL);
            aw.Rg().a(new b(0, 2, uNG, uNF, abd), 0);
            hVar = com.tencent.mm.plugin.report.service.h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(i4);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Long.valueOf(length);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            hVar.e(14811, objArr);
        }
        AppMethodBeat.o(26644);
    }

    public static void br(Context context, String str) {
        AppMethodBeat.i(26645);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
            AppMethodBeat.o(26645);
            return;
        }
        cl clVar = new cl();
        sc scVar = new sc();
        scVar.cNZ.cOc = str;
        scVar.cNZ.cOd = clVar;
        scVar.cNZ.url = "";
        a.xxA.m(scVar);
        if (scVar.cOa.cvi) {
            clVar.cvA.activity = (Activity) context;
            clVar.cvA.cvH = 28;
            a.xxA.m(clVar);
            AppMethodBeat.o(26645);
            return;
        }
        if (clVar.cvA.cvG == 0) {
            clVar.cvA.cvG = R.string.bop;
        }
        com.tencent.mm.ui.base.h.g(context, clVar.cvA.cvG, 0);
        AppMethodBeat.o(26645);
    }
}
