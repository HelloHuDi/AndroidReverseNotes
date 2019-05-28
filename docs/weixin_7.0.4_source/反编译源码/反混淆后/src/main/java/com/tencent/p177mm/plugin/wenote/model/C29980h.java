package com.tencent.p177mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C26189le;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9465sc;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.fav.p407a.C11851an;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C31480h;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.pluginsdk.location.C14866b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abd;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.model.WMElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wenote.model.h */
public final class C29980h {
    private static Map<String, String> mid;
    public static String uNA = (C11851an.bvi() + "/fav_fileicon_txt.png");
    public static String uNB = (C11851an.bvi() + "/fav_fileicon_pdf.png");
    public static String uNC = (C11851an.bvi() + "/fav_fileicon_unknow.png");
    private static String[] uND = new String[]{"<div>", "<div/>", "<object", "<br", "</"};
    private static String[] uNE = new String[]{"＜div>", "＜div/>", "＜object", "＜br", "＜/"};
    private static LinkedList<abd> uNF = null;
    private static String uNG = "";
    public static String uNt = (C11851an.bvi() + "/fav_fileicon_video.png");
    public static String uNu = (C11851an.bvi() + "/fav_fileicon_music.png");
    public static String uNv = (C11851an.bvi() + "/fav_list_img_default.png");
    public static String uNw = (C11851an.bvi() + "/fav_fileicon_zip.png");
    public static String uNx = (C11851an.bvi() + "/fav_fileicon_word.png");
    public static String uNy = (C11851an.bvi() + "/fav_fileicon_ppt.png");
    public static String uNz = (C11851an.bvi() + "/fav_fileicon_xls.png");

    /* renamed from: aR */
    private static void m47437aR(JSONObject jSONObject) {
        AppMethodBeat.m2504i(26635);
        C26189le c26189le = new C26189le();
        c26189le.cHe.type = 6;
        c26189le.cHe.jsonString = jSONObject.toString();
        c26189le.cHe.cGW = "";
        C4879a.xxA.mo10055m(c26189le);
        AppMethodBeat.m2505o(26635);
    }

    /* renamed from: q */
    public static void m47441q(Context context, String str, int i) {
        AppMethodBeat.m2504i(26636);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(26636);
        } else if (C5730e.m8628ct(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                int fY = (int) C14719f.m22908fY((long) i);
                jSONObject.put("type", 4);
                jSONObject.put("downloaded", true);
                jSONObject.put("length", fY);
                jSONObject.put("lengthStr", C14719f.m22903K(context, fY));
                jSONObject.put("iconPath", C11851an.bvi() + "/fav_fileicon_recording.png");
                C29980h.m47437aR(jSONObject);
                AppMethodBeat.m2505o(26636);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(26636);
            }
        } else {
            AppMethodBeat.m2505o(26636);
        }
    }

    public static void agY(String str) {
        AppMethodBeat.m2504i(26637);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(26637);
        } else if (C5730e.m8628ct(str)) {
            C5728b c5728b = new C5728b(str);
            if (c5728b.exists()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 5);
                    jSONObject.put("downloaded", true);
                    jSONObject.put("title", c5728b.getName());
                    jSONObject.put(C8741b.CONTENT, C14719f.m22905aC((float) c5728b.length()));
                    jSONObject.put("iconPath", C29980h.aha(C5730e.m8630cv(str)));
                    jSONObject.put("localPath", str);
                    C29980h.m47437aR(jSONObject);
                    AppMethodBeat.m2505o(26637);
                    return;
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                    AppMethodBeat.m2505o(26637);
                    return;
                }
            }
            AppMethodBeat.m2505o(26637);
        } else {
            AppMethodBeat.m2505o(26637);
        }
    }

    public static void agZ(String str) {
        AppMethodBeat.m2504i(26638);
        C4990ab.m7416i("MicroMsg.WNNoteLogic", "insert location run");
        JSONObject jSONObject = new JSONObject(str);
        C4990ab.m7416i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
        Object obj = C11851an.bvk() + "/" + C1178g.m2591x((new C14866b(-1, (float) jSONObject.getDouble("lat"), (float) jSONObject.getDouble("lng"), jSONObject.getInt(WMElement.ANIMATE_TYPE_SCALE), 1).toString()).getBytes()) + ".png";
        C4990ab.m7417i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", obj);
        if (C5730e.m8628ct(obj)) {
            C4990ab.m7416i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
        }
        if (C5730e.m8628ct(obj)) {
            C4990ab.m7416i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
        } else {
            C4990ab.m7413e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", obj);
            obj = C40369d.uNe;
        }
        jSONObject.put("localPath", obj);
        C29980h.m47437aR(jSONObject);
        AppMethodBeat.m2505o(26638);
    }

    /* renamed from: ae */
    public static void m47438ae(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(26639);
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                jSONObject.put("type", 2);
                jSONObject.put("downloaded", true);
                String hs = C29977c.m47431hs(str, "");
                str = C29977c.m47432ht(str, "");
                if (C5046bo.isNullOrNil(hs) || C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(26639);
                    return;
                }
                jSONObject.put("bigImagePath", hs);
                jSONObject.put("localPath", str);
                C29980h.m47437aR(jSONObject);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(26639);
    }

    /* renamed from: bq */
    public static void m47439bq(Context context, String str) {
        int i;
        AppMethodBeat.m2504i(26640);
        JSONObject jSONObject = new JSONObject();
        if (!C5046bo.isNullOrNil(str)) {
            i = (int) C40371k.ddK().duration;
            int fY = (int) C14719f.m22908fY((long) i);
            try {
                jSONObject.put("downloaded", true);
                jSONObject.put("length", i);
                jSONObject.put("lengthStr", C14719f.m22903K(context, fY));
                jSONObject.put("iconPath", C11851an.bvi() + "/fav_fileicon_recording.png");
                jSONObject.put("localPath", str);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
        try {
            jSONObject.put("type", 4);
        } catch (JSONException e2) {
            C4990ab.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
        }
        i = C40371k.ddK().uNO;
        C26189le c26189le = new C26189le();
        c26189le.cHe.type = 6;
        c26189le.cHe.jsonString = jSONObject.toString();
        c26189le.cHe.cGW = Integer.toString(i);
        C4879a.xxA.mo10055m(c26189le);
        AppMethodBeat.m2505o(26640);
    }

    static {
        AppMethodBeat.m2504i(26646);
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
        AppMethodBeat.m2505o(26646);
    }

    public static String aha(String str) {
        AppMethodBeat.m2504i(26641);
        String str2 = (String) mid.get(str);
        if (str2 == null) {
            str2 = (String) mid.get("unknown");
            AppMethodBeat.m2505o(26641);
            return str2;
        }
        AppMethodBeat.m2505o(26641);
        return str2;
    }

    /* renamed from: a */
    public static ArrayList<C44001c> m47435a(Object obj, List<String> list, boolean z) {
        AppMethodBeat.m2504i(26642);
        if (obj == null) {
            AppMethodBeat.m2505o(26642);
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        ArrayList<C44001c> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C44001c c44001c = (C44001c) it.next();
            if (c44001c.getType() != 1) {
                arrayList2.add(c44001c);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            if (str.trim().equals("<ThisisNoteNodeHrObj>")) {
                C31480h c31480h = new C31480h();
                c31480h.uNT = false;
                c31480h.uNZ = false;
                arrayList2.add(i, c31480h);
            } else if (!str.trim().equals("<ThisisNoteNodeObj>")) {
                C40365i c40365i = new C40365i();
                c40365i.content = str;
                c40365i.uNT = false;
                c40365i.uNZ = false;
                c40365i.mnd = C14719f.agW(c40365i.toString());
                if (i < arrayList2.size()) {
                    arrayList2.add(i, c40365i);
                } else {
                    arrayList2.add(c40365i);
                }
            }
        }
        if (z) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        AppMethodBeat.m2505o(26642);
        return arrayList2;
    }

    /* renamed from: JW */
    public static void m47434JW(int i) {
        LinkedList linkedList;
        AppMethodBeat.m2504i(26643);
        uNF = null;
        uNG = "";
        String deu = C40380c.dem().deu();
        uNG = deu;
        LinkedList linkedList2 = new LinkedList();
        abf ahe = C40380c.dem().ahe(deu);
        if (ahe == null || ahe.wiv.size() <= 1) {
            linkedList = null;
        } else {
            Iterator it = ahe.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                String o = C14719f.m22910o(aar);
                if (!C5046bo.isNullOrNil(o) && aar.dataType == 2 && C5730e.m8628ct(o)) {
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
        C9638aw.m17182Rg().mo14541a(new C40368b(i, 1, uNG, uNF, null), 0);
        AppMethodBeat.m2505o(26643);
    }

    /* renamed from: a */
    public static void m47436a(Context context, Bitmap bitmap, boolean z) {
        C7060h c7060h;
        Object[] objArr;
        AppMethodBeat.m2504i(26644);
        String RL = C40612a.m70042RL("jpg");
        if (bitmap != null) {
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.JPEG, RL, true);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
                c7060h = C7060h.pYm;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(0);
                objArr[1] = Integer.valueOf(0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(3);
                objArr[4] = Integer.valueOf(z ? 1 : 0);
                c7060h.mo8381e(14811, objArr);
                RL = "";
            }
        } else {
            C4990ab.m7412e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
            c7060h = C7060h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(1);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            c7060h.mo8381e(14811, objArr);
            RL = "";
        }
        if (!C5046bo.isNullOrNil(RL)) {
            C40612a.m70043a(RL, context);
        }
        C5728b c5728b = new C5728b(RL);
        if (c5728b.exists()) {
            long length = c5728b.length() / 1024;
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
            abd.Md5 = C5730e.atg(RL);
            C9638aw.m17182Rg().mo14541a(new C40368b(0, 2, uNG, uNF, abd), 0);
            c7060h = C7060h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(i4);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Long.valueOf(length);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            c7060h.mo8381e(14811, objArr);
        }
        AppMethodBeat.m2505o(26644);
    }

    /* renamed from: br */
    public static void m47440br(Context context, String str) {
        AppMethodBeat.m2504i(26645);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
            AppMethodBeat.m2505o(26645);
            return;
        }
        C45316cl c45316cl = new C45316cl();
        C9465sc c9465sc = new C9465sc();
        c9465sc.cNZ.cOc = str;
        c9465sc.cNZ.cOd = c45316cl;
        c9465sc.cNZ.url = "";
        C4879a.xxA.mo10055m(c9465sc);
        if (c9465sc.cOa.cvi) {
            c45316cl.cvA.activity = (Activity) context;
            c45316cl.cvA.cvH = 28;
            C4879a.xxA.mo10055m(c45316cl);
            AppMethodBeat.m2505o(26645);
            return;
        }
        if (c45316cl.cvA.cvG == 0) {
            c45316cl.cvA.cvG = C25738R.string.bop;
        }
        C30379h.m48467g(context, c45316cl.cvA.cvG, 0);
        AppMethodBeat.m2505o(26645);
    }
}
