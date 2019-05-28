package com.tencent.p177mm.plugin.emoji.p947e;

import com.google.firebase.analytics.FirebaseAnalytics.C8740a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.emoji.p1598e.C41953a;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1177ao.C37462a;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C32529cs;
import com.tencent.p177mm.p707ba.C45180d;
import com.tencent.p177mm.p707ba.C6336e;
import com.tencent.p177mm.p707ba.C6337f;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C40922d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
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

/* renamed from: com.tencent.mm.plugin.emoji.e.j */
public class C45852j {
    private static String kTY = "";
    private static String kTZ = "temp";
    static String kUa = "newemoji";
    private static String kUb = "panel";
    public static String kUc = "suggest";
    public static String kUd = "egg";
    private static String kUe = C8740a.SEARCH;
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
    private static C45852j kUt;
    public C6337f kUu;

    /* renamed from: com.tencent.mm.plugin.emoji.e.j$a */
    public enum C27735a {
        EMOJI,
        PANEL,
        SUGGEST,
        SEARCH,
        EGG;

        static {
            AppMethodBeat.m2505o(52963);
        }
    }

    public static C45852j bkb() {
        AppMethodBeat.m2504i(52964);
        if (kUt == null) {
            synchronized (C45852j.class) {
                try {
                    kUt = new C45852j();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(52964);
                    }
                }
            }
        }
        C45852j c45852j = kUt;
        AppMethodBeat.m2505o(52964);
        return c45852j;
    }

    public static String getDataEmojiPath() {
        AppMethodBeat.m2504i(52965);
        if (C5046bo.isNullOrNil(kTY)) {
            kTY = C6457e.eSk.replace("/data/user/0", "/data/data");
            kTY += "/emoji";
        }
        String str = kTY;
        AppMethodBeat.m2505o(52965);
        return str;
    }

    /* renamed from: a */
    public static boolean m84895a(C32519bf c32519bf, C27735a c27735a, String str) {
        AppMethodBeat.m2504i(52966);
        C5728b c5728b = new C5728b(c32519bf.cus.filePath);
        if (!c5728b.exists() || c5728b.length() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile update file don't exist.");
            AppMethodBeat.m2505o(52966);
            return false;
        }
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile start. type:%s filePath:%s", String.valueOf(c27735a), C5736j.m8649w(c5728b.dMD()));
        C5728b c5728b2 = new C5728b(C45852j.getDataEmojiPath(), str);
        if (c5728b2.exists()) {
            C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
        }
        switch (c27735a) {
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
                C4990ab.m7421w("MicroMsg.emoji.EmojiResUpdateMgr", "unknown type. type:%s", String.valueOf(c27735a));
                str2 = "";
                break;
        }
        C5728b c5728b3 = new C5728b(c5728b2, str2);
        c5728b2.mkdirs();
        C5730e.m8644y(C5736j.m8649w(c5728b.dMD()), C5736j.m8649w(c5728b3.dMD()));
        int hU = C5046bo.m7570hU(C5736j.m8649w(c5728b3.dMD()), C5736j.m8649w(c5728b2.dMD()));
        C5730e.deleteFile(C5736j.m8649w(c5728b3.mUri));
        C4990ab.m7411d("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile done. user time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (hU >= 0) {
            AppMethodBeat.m2505o(52966);
            return true;
        }
        AppMethodBeat.m2505o(52966);
        return false;
    }

    /* renamed from: g */
    private static int m84898g(C5728b c5728b) {
        Closeable bufferedReader;
        Throwable e;
        Throwable th;
        AppMethodBeat.m2504i(52967);
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        if (c5728b.exists()) {
            Closeable c40922d;
            Closeable inputStreamReader;
            try {
                c40922d = new C40922d(c5728b);
                try {
                    inputStreamReader = new InputStreamReader(c40922d);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = null;
                        try {
                            C4990ab.m7412e("MicroMsg.emoji.EmojiResUpdateMgr", C5046bo.m7574l(e));
                            C5046bo.m7527b(c40922d);
                            C5046bo.m7527b(inputStreamReader);
                            C5046bo.m7527b(bufferedReader);
                            C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            AppMethodBeat.m2505o(52967);
                            return i;
                        } catch (Throwable th2) {
                            th = th2;
                            C5046bo.m7527b(c40922d);
                            C5046bo.m7527b(inputStreamReader);
                            C5046bo.m7527b(bufferedReader);
                            AppMethodBeat.m2505o(52967);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        C5046bo.m7527b(c40922d);
                        C5046bo.m7527b(inputStreamReader);
                        C5046bo.m7527b(bufferedReader);
                        AppMethodBeat.m2505o(52967);
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
                        C4990ab.m7411d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode config file content:%s version:%d", str, Integer.valueOf(i));
                        C5046bo.m7527b(c40922d);
                        C5046bo.m7527b(inputStreamReader);
                        C5046bo.m7527b(bufferedReader);
                    } catch (Exception e3) {
                        e = e3;
                        C4990ab.m7412e("MicroMsg.emoji.EmojiResUpdateMgr", C5046bo.m7574l(e));
                        C5046bo.m7527b(c40922d);
                        C5046bo.m7527b(inputStreamReader);
                        C5046bo.m7527b(bufferedReader);
                        C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.m2505o(52967);
                        return i;
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader = null;
                    inputStreamReader = null;
                    C4990ab.m7412e("MicroMsg.emoji.EmojiResUpdateMgr", C5046bo.m7574l(e));
                    C5046bo.m7527b(c40922d);
                    C5046bo.m7527b(inputStreamReader);
                    C5046bo.m7527b(bufferedReader);
                    C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(52967);
                    return i;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    inputStreamReader = null;
                    C5046bo.m7527b(c40922d);
                    C5046bo.m7527b(inputStreamReader);
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(52967);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
                inputStreamReader = null;
                c40922d = null;
                C4990ab.m7412e("MicroMsg.emoji.EmojiResUpdateMgr", C5046bo.m7574l(e));
                C5046bo.m7527b(c40922d);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(bufferedReader);
                C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(52967);
                return i;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                inputStreamReader = null;
                c40922d = null;
                C5046bo.m7527b(c40922d);
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(bufferedReader);
                AppMethodBeat.m2505o(52967);
                throw th;
            }
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion file don't exist. path:%s", C5736j.m8649w(c5728b.dMD()));
        C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(52967);
        return i;
    }

    public static String bjS() {
        AppMethodBeat.m2504i(52969);
        String OP = C26072e.m41621OP();
        if (C5046bo.isNullOrNil(OP)) {
            OP = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_NEW_PANEL_NAME_STRING, kUm);
        }
        AppMethodBeat.m2505o(52969);
        return OP;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public static void m84899h(C5728b c5728b) {
        Throwable th;
        AppMethodBeat.m2504i(52970);
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            InputStream p = C5730e.m8638p(c5728b);
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
                                    if (!C5046bo.isNullOrNil(textContent)) {
                                        C4990ab.m7411d("MicroMsg.emoji.EmojiResUpdateMgr", "word:%s", textContent);
                                        arrayList2.add(textContent.trim());
                                    }
                                }
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                    C42952j.getEmojiStorageMgr().xYx.mo39186am(arrayList);
                    kUr = C45852j.m84898g(new C5728b(C45852j.getDataEmojiPath() + "/" + kUc, kUf));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(kUr));
                }
                if (p != null) {
                    p.close();
                    AppMethodBeat.m2505o(52970);
                    return;
                }
                AppMethodBeat.m2505o(52970);
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                if (p != null) {
                }
                AppMethodBeat.m2505o(52970);
                throw th;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiDescConfig parseXML exception:%s", e.toString());
            AppMethodBeat.m2505o(52970);
        }
    }

    /* renamed from: a */
    public static void m84893a(C32519bf c32519bf, boolean z) {
        AppMethodBeat.m2504i(52972);
        if (!z && !C45852j.m84894a(c32519bf, C27735a.EMOJI)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji need no update.");
            AppMethodBeat.m2505o(52972);
        } else if (C45852j.m84895a(c32519bf, C27735a.EMOJI, kUa) || z) {
            C5728b c5728b = new C5728b(new C5728b(C45852j.getDataEmojiPath(), kUa), kUl);
            if (c5728b.exists()) {
                ArrayList a = C41953a.m74097a(c5728b);
                if (!a.isEmpty() && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35665w(a)) {
                    C32529cs c32529cs = new C32529cs();
                    c32529cs.cvT.cuu = 1;
                    C4879a.xxA.mo10055m(c32529cs);
                    kUp = C45852j.m84898g(new C5728b(C45852j.getDataEmojiPath() + "/" + kUa, kUf));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(kUp));
                }
                AppMethodBeat.m2505o(52972);
                return;
            }
            C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji config don't exist.");
            AppMethodBeat.m2505o(52972);
        } else {
            C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji unzip file failed.");
            AppMethodBeat.m2505o(52972);
        }
    }

    /* renamed from: b */
    public static void m84896b(C32519bf c32519bf, boolean z) {
        String str;
        AppMethodBeat.m2504i(52973);
        if (!(z || C45852j.m84894a(c32519bf, C27735a.PANEL))) {
            int i;
            str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_NEW_PANEL_NAME_STRING, kUm);
            String OP = C26072e.m41621OP();
            if (C5046bo.isNullOrNil(OP) || str.equalsIgnoreCase(OP)) {
                i = 0;
            } else {
                i = 1;
            }
            if (i == 0) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel need no update.");
                AppMethodBeat.m2505o(52973);
                return;
            }
        }
        if (C45852j.m84895a(c32519bf, C27735a.PANEL, kUb) || z) {
            Object obj;
            C5728b c5728b = new C5728b(C45852j.getDataEmojiPath(), kUb);
            str = C26072e.m41621OP();
            if (C5046bo.isNullOrNil(str)) {
                str = kUm;
                C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "no dynamic config panel file name. use default.");
                obj = str;
            } else {
                if (!new C5728b(c5728b, str).exists()) {
                    str = kUm;
                }
                C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "dynamic config panel file name :%s", str);
                String obj2 = str;
            }
            C5728b c5728b2 = new C5728b(c5728b, (String) obj2);
            if (c5728b2.exists()) {
                ArrayList b = C41953a.m74098b(c5728b2);
                if (b.isEmpty()) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfigFromFile smiley panel list is null.");
                } else if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35666x(b)) {
                    C32529cs c32529cs = new C32529cs();
                    c32529cs.cvT.cuu = 2;
                    C4879a.xxA.mo10055m(c32529cs);
                    kUq = C45852j.m84898g(new C5728b(C45852j.getDataEmojiPath() + "/" + kUb, kUf));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(kUq));
                }
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEW_PANEL_NAME_STRING, obj2);
                AppMethodBeat.m2505o(52973);
                return;
            }
            C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel config don't exist.");
            AppMethodBeat.m2505o(52973);
            return;
        }
        C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel unzip file failed.");
        AppMethodBeat.m2505o(52973);
    }

    /* renamed from: b */
    public static boolean m84897b(C32519bf c32519bf) {
        AppMethodBeat.m2504i(52974);
        long currentTimeMillis = System.currentTimeMillis();
        C37626b.dqD();
        long j = C37626b.dqD().xFH;
        C37626b.dqD();
        int anS = C37626b.anS(c32519bf.cus.filePath);
        C37626b.dqD();
        C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "currentSupportVersion:%d current version:%d supportVersion:%d file version:%d use time:%d", Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(anS), Long.valueOf(C37626b.anR(c32519bf.cus.filePath)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (anS != 1 || r6 <= j) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "need not update color emoji");
            AppMethodBeat.m2505o(52974);
            return false;
        }
        AppMethodBeat.m2505o(52974);
        return true;
    }

    public final C6337f bjQ() {
        AppMethodBeat.m2504i(52975);
        try {
            if (this.kUu == null) {
                byte[] e = C5730e.m8632e(C1720g.m3536RP().cachePath + "eggingfo.ini", 0, -1);
                if (e == null) {
                    C4990ab.m7410d("MicroMsg.emoji.EmojiResUpdateMgr", "data is null, parse EggList from config file fail");
                } else {
                    this.kUu = (C6337f) new C6337f().parseFrom(e);
                }
            }
        } catch (Exception e2) {
            C4990ab.m7421w("MicroMsg.emoji.EmojiResUpdateMgr", "init crash : %s, try delete egg file", e2.getLocalizedMessage());
            C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e2, "", new Object[0]);
        }
        C6337f c6337f = this.kUu;
        AppMethodBeat.m2505o(52975);
        return c6337f;
    }

    /* renamed from: a */
    public static boolean m84894a(C32519bf c32519bf, C27735a c27735a) {
        int g;
        int intValue;
        AppMethodBeat.m2504i(52968);
        if (C45852j.m84895a(c32519bf, c27735a, kTZ)) {
            C5728b c5728b = new C5728b(C45852j.getDataEmojiPath(), kTZ);
            C4990ab.m7410d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode unzip file done.");
            g = C45852j.m84898g(new C5728b(c5728b, kUf));
        } else {
            C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "unzip file failed. type:%s", String.valueOf(c27735a));
            g = -1;
        }
        switch (c27735a) {
            case EMOJI:
                intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0))).intValue();
                kUp = intValue;
                break;
            case PANEL:
                intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0))).intValue();
                kUq = intValue;
                break;
            case SEARCH:
                intValue = C37462a.fAH;
                break;
            case SUGGEST:
                intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(0))).intValue();
                kUr = intValue;
                break;
            case EGG:
                intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_EGG_INT, Integer.valueOf(0))).intValue();
                kUs = intValue;
                break;
            default:
                intValue = -1;
                break;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateMgr", "file version:%d, current version:%d", Integer.valueOf(g), Integer.valueOf(intValue));
        if (g == -1 || intValue >= g) {
            AppMethodBeat.m2505o(52968);
            return false;
        }
        AppMethodBeat.m2505o(52968);
        return true;
    }

    /* renamed from: i */
    public static void m84900i(C5728b c5728b) {
        AppMethodBeat.m2504i(52971);
        try {
            String cy = C5730e.m8631cy(C5736j.m8649w(c5728b.dMD()));
            Map z = C5049br.m7595z(cy, "EasterEgg");
            C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "eggXml:".concat(String.valueOf(cy)));
            if (z == null) {
                C4990ab.m7412e("MicroMsg.emoji.EmojiResUpdateMgr", "Exception in parseXml EasterEgg, please check the xml");
                AppMethodBeat.m2505o(52971);
                return;
            }
            C6337f c6337f = new C6337f();
            c6337f.fMj = (double) C5046bo.ank((String) z.get(".EasterEgg.$version"));
            int i = 0;
            while (true) {
                String str = ".EasterEgg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                if (z.get(str + ".$name") != null) {
                    C45180d c45180d = new C45180d();
                    c45180d.name = C5046bo.nullAsNil((String) z.get(str + ".$name"));
                    c45180d.fMc = C5046bo.nullAsNil((String) z.get(str + ".$langs"));
                    c45180d.cKB = C5046bo.ank((String) z.get(str + ".$reportType"));
                    c45180d.fMa = C5046bo.anb((String) z.get(str + ".$BeginDate"));
                    c45180d.fMb = C5046bo.anb((String) z.get(str + ".$EndDate"));
                    c45180d.fMd = C5046bo.nullAsNil((String) z.get(str + ".FileName"));
                    c45180d.fMe = C5046bo.ank((String) z.get(str + ".AnimType"));
                    c45180d.fMf = C5046bo.ank((String) z.get(str + ".AnimType.$viewcount"));
                    c45180d.fMg = C5046bo.ank((String) z.get(str + ".AnimType.$minSize"));
                    c45180d.maxSize = C5046bo.ank((String) z.get(str + ".AnimType.$maxSize"));
                    int i2 = 0;
                    while (true) {
                        cy = str + ".KeyWord" + (i2 == 0 ? "" : Integer.valueOf(i2));
                        String str2 = cy + ".$lang";
                        if (z.get(cy) == null) {
                            break;
                        }
                        C6336e c6336e = new C6336e();
                        c6336e.fMh = C5046bo.nullAsNil((String) z.get(cy));
                        c6336e.lang = C5046bo.nullAsNil((String) z.get(str2));
                        c45180d.fLY.add(c6336e);
                        i2++;
                    }
                    c6337f.fMi.add(c45180d);
                    i++;
                } else {
                    byte[] toByteArray = c6337f.toByteArray();
                    C5730e.m8624b(C1720g.m3536RP().cachePath + "eggingfo.ini", toByteArray, toByteArray.length);
                    kUs = C45852j.m84898g(new C5728b(C45852j.getDataEmojiPath() + "/" + kUd, kUf));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_EGG_INT, Integer.valueOf(kUs));
                    AppMethodBeat.m2505o(52971);
                    return;
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
            AppMethodBeat.m2505o(52971);
        }
    }
}
