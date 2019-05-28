package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class j {
    private static String kTY = "";
    private static String kTZ = "temp";
    static String kUa = "newemoji";
    private static String kUb = "panel";
    public static String kUc = "suggest";
    public static String kUd = "egg";
    private static String kUe = com.google.firebase.analytics.FirebaseAnalytics.a.SEARCH;
    private static String kUf = "config.conf";
    private static String kUg = "emojipanel.zip";
    private static String kUh = "newemoji.zip";
    private static String kUi = "emoji_template.zip";
    private static String kUj = "emojisuggest.zip";
    private static String kUk = "egg.zip";
    private static String kUl = "newemoji-config.xml";
    private static String kUm = "emojipanel-config.xml";
    public static String kUn = "emojisuggest-config.xml";
    public static String kUo = "egg.xml";
    private static int kUp = 0;
    private static int kUq = 0;
    private static int kUr = 0;
    private static int kUs = 0;
    private static j kUt;
    public f kUu;

    public enum a {
        EMOJI,
        PANEL,
        SUGGEST,
        SEARCH,
        EGG;

        static {
            AppMethodBeat.o(52963);
        }
    }

    public static j bkb() {
        AppMethodBeat.i(52964);
        if (kUt == null) {
            synchronized (j.class) {
                try {
                    kUt = new j();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(52964);
                    }
                }
            }
        }
        j jVar = kUt;
        AppMethodBeat.o(52964);
        return jVar;
    }

    public static String getDataEmojiPath() {
        AppMethodBeat.i(52965);
        if (bo.isNullOrNil(kTY)) {
            kTY = e.eSk.replace("/data/user/0", "/data/data");
            kTY += "/emoji";
        }
        String str = kTY;
        AppMethodBeat.o(52965);
        return str;
    }

    public static boolean a(bf bfVar, a aVar, String str) {
        AppMethodBeat.i(52966);
        b bVar = new b(bfVar.cus.filePath);
        if (!bVar.exists() || bVar.length() <= 0) {
            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile update file don't exist.");
            AppMethodBeat.o(52966);
            return false;
        }
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile start. type:%s filePath:%s", String.valueOf(aVar), com.tencent.mm.vfs.j.w(bVar.dMD()));
        b bVar2 = new b(getDataEmojiPath(), str);
        if (bVar2.exists()) {
            com.tencent.mm.vfs.e.N(com.tencent.mm.vfs.j.w(bVar2.mUri), true);
        }
        switch (aVar) {
            case EMOJI:
                str2 = kUh;
                break;
            case PANEL:
                str2 = kUg;
                break;
            case SEARCH:
                str2 = kUi;
                break;
            case SUGGEST:
                str2 = kUj;
                break;
            case EGG:
                str2 = kUk;
                break;
            default:
                ab.w("MicroMsg.emoji.EmojiResUpdateMgr", "unknown type. type:%s", String.valueOf(aVar));
                str2 = "";
                break;
        }
        b bVar3 = new b(bVar2, str2);
        bVar2.mkdirs();
        com.tencent.mm.vfs.e.y(com.tencent.mm.vfs.j.w(bVar.dMD()), com.tencent.mm.vfs.j.w(bVar3.dMD()));
        int hU = bo.hU(com.tencent.mm.vfs.j.w(bVar3.dMD()), com.tencent.mm.vfs.j.w(bVar2.dMD()));
        com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.vfs.j.w(bVar3.mUri));
        ab.d("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile done. user time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (hU >= 0) {
            AppMethodBeat.o(52966);
            return true;
        }
        AppMethodBeat.o(52966);
        return false;
    }

    private static int g(b bVar) {
        Closeable bufferedReader;
        Throwable e;
        Throwable th;
        AppMethodBeat.i(52967);
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        if (bVar.exists()) {
            Closeable dVar;
            Closeable inputStreamReader;
            try {
                dVar = new d(bVar);
                try {
                    inputStreamReader = new InputStreamReader(dVar);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = null;
                        try {
                            ab.e("MicroMsg.emoji.EmojiResUpdateMgr", bo.l(e));
                            bo.b(dVar);
                            bo.b(inputStreamReader);
                            bo.b(bufferedReader);
                            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            AppMethodBeat.o(52967);
                            return i;
                        } catch (Throwable th2) {
                            th = th2;
                            bo.b(dVar);
                            bo.b(inputStreamReader);
                            bo.b(bufferedReader);
                            AppMethodBeat.o(52967);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        bo.b(dVar);
                        bo.b(inputStreamReader);
                        bo.b(bufferedReader);
                        AppMethodBeat.o(52967);
                        throw th;
                    }
                    try {
                        String str = "";
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        }
                        i = new JSONObject(str).getInt("version");
                        ab.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode config file content:%s version:%d", str, Integer.valueOf(i));
                        bo.b(dVar);
                        bo.b(inputStreamReader);
                        bo.b(bufferedReader);
                    } catch (Exception e3) {
                        e = e3;
                        ab.e("MicroMsg.emoji.EmojiResUpdateMgr", bo.l(e));
                        bo.b(dVar);
                        bo.b(inputStreamReader);
                        bo.b(bufferedReader);
                        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(52967);
                        return i;
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader = null;
                    inputStreamReader = null;
                    ab.e("MicroMsg.emoji.EmojiResUpdateMgr", bo.l(e));
                    bo.b(dVar);
                    bo.b(inputStreamReader);
                    bo.b(bufferedReader);
                    ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(52967);
                    return i;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    inputStreamReader = null;
                    bo.b(dVar);
                    bo.b(inputStreamReader);
                    bo.b(bufferedReader);
                    AppMethodBeat.o(52967);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
                inputStreamReader = null;
                dVar = null;
                ab.e("MicroMsg.emoji.EmojiResUpdateMgr", bo.l(e));
                bo.b(dVar);
                bo.b(inputStreamReader);
                bo.b(bufferedReader);
                ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(52967);
                return i;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                inputStreamReader = null;
                dVar = null;
                bo.b(dVar);
                bo.b(inputStreamReader);
                bo.b(bufferedReader);
                AppMethodBeat.o(52967);
                throw th;
            }
        }
        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion file don't exist. path:%s", com.tencent.mm.vfs.j.w(bVar.dMD()));
        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(52967);
        return i;
    }

    public static String bjS() {
        AppMethodBeat.i(52969);
        String OP = com.tencent.mm.emoji.a.e.OP();
        if (bo.isNullOrNil(OP)) {
            OP = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEW_PANEL_NAME_STRING, kUm);
        }
        AppMethodBeat.o(52969);
        return OP;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void h(b bVar) {
        Throwable th;
        AppMethodBeat.i(52970);
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            InputStream p = com.tencent.mm.vfs.e.p(bVar);
            Throwable th2 = null;
            try {
                Document parse = newInstance.newDocumentBuilder().parse(p);
                parse.normalize();
                NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("group");
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    int length = elementsByTagName.getLength();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                        if (childNodes != null && childNodes.getLength() > 0) {
                            int length2 = childNodes.getLength();
                            ArrayList arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < length2; i2++) {
                                Node item = childNodes.item(i2);
                                if (item.getNodeName().equals("word")) {
                                    String textContent = item.getTextContent();
                                    if (!bo.isNullOrNil(textContent)) {
                                        ab.d("MicroMsg.emoji.EmojiResUpdateMgr", "word:%s", textContent);
                                        arrayList2.add(textContent.trim());
                                    }
                                }
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                    com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYx.am(arrayList);
                    kUr = g(new b(getDataEmojiPath() + "/" + kUc, kUf));
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(kUr));
                }
                if (p != null) {
                    p.close();
                    AppMethodBeat.o(52970);
                    return;
                }
                AppMethodBeat.o(52970);
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                if (p != null) {
                }
                AppMethodBeat.o(52970);
                throw th;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiDescConfig parseXML exception:%s", e.toString());
            AppMethodBeat.o(52970);
        }
    }

    public static void a(bf bfVar, boolean z) {
        AppMethodBeat.i(52972);
        if (!z && !a(bfVar, a.EMOJI)) {
            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji need no update.");
            AppMethodBeat.o(52972);
        } else if (a(bfVar, a.EMOJI, kUa) || z) {
            b bVar = new b(new b(getDataEmojiPath(), kUa), kUl);
            if (bVar.exists()) {
                ArrayList a = com.tencent.mm.emoji.e.a.a(bVar);
                if (!a.isEmpty() && ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().w(a)) {
                    cs csVar = new cs();
                    csVar.cvT.cuu = 1;
                    com.tencent.mm.sdk.b.a.xxA.m(csVar);
                    kUp = g(new b(getDataEmojiPath() + "/" + kUa, kUf));
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(kUp));
                }
                AppMethodBeat.o(52972);
                return;
            }
            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji config don't exist.");
            AppMethodBeat.o(52972);
        } else {
            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji unzip file failed.");
            AppMethodBeat.o(52972);
        }
    }

    public static void b(bf bfVar, boolean z) {
        String str;
        AppMethodBeat.i(52973);
        if (!(z || a(bfVar, a.PANEL))) {
            int i;
            str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEW_PANEL_NAME_STRING, kUm);
            String OP = com.tencent.mm.emoji.a.e.OP();
            if (bo.isNullOrNil(OP) || str.equalsIgnoreCase(OP)) {
                i = 0;
            } else {
                i = 1;
            }
            if (i == 0) {
                ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel need no update.");
                AppMethodBeat.o(52973);
                return;
            }
        }
        if (a(bfVar, a.PANEL, kUb) || z) {
            Object obj;
            b bVar = new b(getDataEmojiPath(), kUb);
            str = com.tencent.mm.emoji.a.e.OP();
            if (bo.isNullOrNil(str)) {
                str = kUm;
                ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "no dynamic config panel file name. use default.");
                obj = str;
            } else {
                if (!new b(bVar, str).exists()) {
                    str = kUm;
                }
                ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "dynamic config panel file name :%s", str);
                String obj2 = str;
            }
            b bVar2 = new b(bVar, (String) obj2);
            if (bVar2.exists()) {
                ArrayList b = com.tencent.mm.emoji.e.a.b(bVar2);
                if (b.isEmpty()) {
                    ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfigFromFile smiley panel list is null.");
                } else if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().x(b)) {
                    cs csVar = new cs();
                    csVar.cvT.cuu = 2;
                    com.tencent.mm.sdk.b.a.xxA.m(csVar);
                    kUq = g(new b(getDataEmojiPath() + "/" + kUb, kUf));
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(kUq));
                }
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEW_PANEL_NAME_STRING, obj2);
                AppMethodBeat.o(52973);
                return;
            }
            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel config don't exist.");
            AppMethodBeat.o(52973);
            return;
        }
        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel unzip file failed.");
        AppMethodBeat.o(52973);
    }

    public static boolean b(bf bfVar) {
        AppMethodBeat.i(52974);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.cb.b.dqD();
        long j = com.tencent.mm.cb.b.dqD().xFH;
        com.tencent.mm.cb.b.dqD();
        int anS = com.tencent.mm.cb.b.anS(bfVar.cus.filePath);
        com.tencent.mm.cb.b.dqD();
        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "currentSupportVersion:%d current version:%d supportVersion:%d file version:%d use time:%d", Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(anS), Long.valueOf(com.tencent.mm.cb.b.anR(bfVar.cus.filePath)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (anS != 1 || r6 <= j) {
            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "need not update color emoji");
            AppMethodBeat.o(52974);
            return false;
        }
        AppMethodBeat.o(52974);
        return true;
    }

    public final f bjQ() {
        AppMethodBeat.i(52975);
        try {
            if (this.kUu == null) {
                byte[] e = com.tencent.mm.vfs.e.e(g.RP().cachePath + "eggingfo.ini", 0, -1);
                if (e == null) {
                    ab.d("MicroMsg.emoji.EmojiResUpdateMgr", "data is null, parse EggList from config file fail");
                } else {
                    this.kUu = (f) new f().parseFrom(e);
                }
            }
        } catch (Exception e2) {
            ab.w("MicroMsg.emoji.EmojiResUpdateMgr", "init crash : %s, try delete egg file", e2.getLocalizedMessage());
            ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e2, "", new Object[0]);
        }
        f fVar = this.kUu;
        AppMethodBeat.o(52975);
        return fVar;
    }

    public static boolean a(bf bfVar, a aVar) {
        int g;
        int intValue;
        AppMethodBeat.i(52968);
        if (a(bfVar, aVar, kTZ)) {
            b bVar = new b(getDataEmojiPath(), kTZ);
            ab.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode unzip file done.");
            g = g(new b(bVar, kUf));
        } else {
            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "unzip file failed. type:%s", String.valueOf(aVar));
            g = -1;
        }
        switch (aVar) {
            case EMOJI:
                intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0))).intValue();
                kUp = intValue;
                break;
            case PANEL:
                intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0))).intValue();
                kUq = intValue;
                break;
            case SEARCH:
                intValue = com.tencent.mm.ao.a.fAH;
                break;
            case SUGGEST:
                intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(0))).intValue();
                kUr = intValue;
                break;
            case EGG:
                intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_EGG_INT, Integer.valueOf(0))).intValue();
                kUs = intValue;
                break;
            default:
                intValue = -1;
                break;
        }
        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "file version:%d, current version:%d", Integer.valueOf(g), Integer.valueOf(intValue));
        if (g == -1 || intValue >= g) {
            AppMethodBeat.o(52968);
            return false;
        }
        AppMethodBeat.o(52968);
        return true;
    }

    public static void i(b bVar) {
        AppMethodBeat.i(52971);
        try {
            String cy = com.tencent.mm.vfs.e.cy(com.tencent.mm.vfs.j.w(bVar.dMD()));
            Map z = br.z(cy, "EasterEgg");
            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "eggXml:".concat(String.valueOf(cy)));
            if (z == null) {
                ab.e("MicroMsg.emoji.EmojiResUpdateMgr", "Exception in parseXml EasterEgg, please check the xml");
                AppMethodBeat.o(52971);
                return;
            }
            f fVar = new f();
            fVar.fMj = (double) bo.ank((String) z.get(".EasterEgg.$version"));
            int i = 0;
            while (true) {
                String str = ".EasterEgg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                if (z.get(str + ".$name") != null) {
                    com.tencent.mm.ba.d dVar = new com.tencent.mm.ba.d();
                    dVar.name = bo.nullAsNil((String) z.get(str + ".$name"));
                    dVar.fMc = bo.nullAsNil((String) z.get(str + ".$langs"));
                    dVar.cKB = bo.ank((String) z.get(str + ".$reportType"));
                    dVar.fMa = bo.anb((String) z.get(str + ".$BeginDate"));
                    dVar.fMb = bo.anb((String) z.get(str + ".$EndDate"));
                    dVar.fMd = bo.nullAsNil((String) z.get(str + ".FileName"));
                    dVar.fMe = bo.ank((String) z.get(str + ".AnimType"));
                    dVar.fMf = bo.ank((String) z.get(str + ".AnimType.$viewcount"));
                    dVar.fMg = bo.ank((String) z.get(str + ".AnimType.$minSize"));
                    dVar.maxSize = bo.ank((String) z.get(str + ".AnimType.$maxSize"));
                    int i2 = 0;
                    while (true) {
                        cy = str + ".KeyWord" + (i2 == 0 ? "" : Integer.valueOf(i2));
                        String str2 = cy + ".$lang";
                        if (z.get(cy) == null) {
                            break;
                        }
                        com.tencent.mm.ba.e eVar = new com.tencent.mm.ba.e();
                        eVar.fMh = bo.nullAsNil((String) z.get(cy));
                        eVar.lang = bo.nullAsNil((String) z.get(str2));
                        dVar.fLY.add(eVar);
                        i2++;
                    }
                    fVar.fMi.add(dVar);
                    i++;
                } else {
                    byte[] toByteArray = fVar.toByteArray();
                    com.tencent.mm.vfs.e.b(g.RP().cachePath + "eggingfo.ini", toByteArray, toByteArray.length);
                    kUs = g(new b(getDataEmojiPath() + "/" + kUd, kUf));
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_EGG_INT, Integer.valueOf(kUs));
                    AppMethodBeat.o(52971);
                    return;
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
            AppMethodBeat.o(52971);
        }
    }
}
