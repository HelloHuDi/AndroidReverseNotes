package com.tencent.p177mm.plugin.fts.p423b;

import android.database.Cursor;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.plugin.fts.C45972d;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C24765b;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.fts.b.g */
public final class C34220g extends C24765b {
    C12028m eAX;
    private C1202f fur = new C69242();
    C4884c mGU = new C69221();
    String[] mGV;
    List<String> mGW;

    /* renamed from: com.tencent.mm.plugin.fts.b.g$1 */
    class C69221 extends C4884c<C26111d> {

        /* renamed from: com.tencent.mm.plugin.fts.b.g$1$1 */
        class C69231 implements Runnable {
            C69231() {
            }

            public final void run() {
                AppMethodBeat.m2504i(136791);
                if (!C34220g.this.aGx) {
                    C34220g.this.eAX.mo23853a(BaseClientBuilder.API_PRIORITY_OTHER, new C34221b(C34220g.this, (byte) 0));
                }
                AppMethodBeat.m2505o(136791);
            }
        }

        C69221() {
            AppMethodBeat.m2504i(136792);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(136792);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136793);
            if (!((C26111d) c4883b).crQ.crR) {
                C5004al.m7442n(new C69231(), 10000);
                C34220g.this.mGU.dead();
            }
            AppMethodBeat.m2505o(136793);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.g$2 */
    class C69242 implements C1202f {
        C69242() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(136794);
            if (c1207m instanceof C34224c) {
                C34224c c34224c = (C34224c) c1207m;
                if (i == 0 && i2 == 0) {
                    C4990ab.m7417i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", c34224c.vbm.toString());
                } else {
                    C4990ab.m7413e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    List list = c34224c.vbm;
                    if (i2 == -44) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(1));
                        HashMap hashMap = new HashMap();
                        hashMap.put(list.get(0), Integer.valueOf(0));
                        C1720g.m3540Rg().mo14541a(new C34224c(list, linkedList, "你好，我是珍惜", c34224c.mGZ, hashMap, c34224c.mGZ), 0);
                    }
                    if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
                        Toast.makeText(C4996ah.getContext(), str, 1).show();
                    }
                    AppMethodBeat.m2505o(136794);
                    return;
                }
            }
            AppMethodBeat.m2505o(136794);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.g$f */
    class C12049f extends C28106a {
        private int count;
        private String cuP;

        public C12049f(int i, String str) {
            this.count = i;
            this.cuP = str;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136802);
            if (C34220g.this.mGV == null) {
                String cy = C5730e.m8631cy("/sdcard/test_insert_msg_words.txt");
                C34220g.this.mGV = cy.split(",");
            }
            if (C34220g.this.mGW == null) {
                C34220g.this.mGW = new ArrayList();
                if (C5046bo.isNullOrNil(this.cuP)) {
                    Cursor dss = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().dss();
                    while (dss.moveToNext()) {
                        C34220g.this.mGW.add(dss.getString(0));
                    }
                    dss.close();
                } else {
                    C34220g.this.mGW.add(this.cuP);
                }
            }
            if (C34220g.this.mGV != null) {
                for (int i = 0; i < this.count; i++) {
                    Object obj;
                    String D = C12049f.m19960D(C34220g.this.mGV);
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.setType(1);
                    c7620bi.mo14781hO(1);
                    c7620bi.setStatus(4);
                    c7620bi.setContent(D);
                    List list = C34220g.this.mGW;
                    if (list.size() > 1) {
                        obj = list.get(new Random().nextInt(list.size() - 1));
                    } else {
                        obj = list.get(0);
                    }
                    c7620bi.mo14794ju((String) obj);
                    c7620bi.mo14775eJ(System.currentTimeMillis() - 250327040);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
                    C4990ab.m7417i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(D.length()), Long.valueOf(c7620bi.field_msgId));
                }
            }
            AppMethodBeat.m2505o(136802);
            return true;
        }

        /* renamed from: D */
        private static String m19960D(String[] strArr) {
            AppMethodBeat.m2504i(136803);
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 300; i++) {
                stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.m2505o(136803);
            return stringBuffer2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.g$g */
    class C20852g extends C28106a {
        private C20852g() {
        }

        /* synthetic */ C20852g(C34220g c34220g, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136804);
            if (C34220g.this.mGV == null) {
                String cy = C5730e.m8631cy("/sdcard/test_insert_msg_words.txt");
                C34220g.this.mGV = cy.split(",");
            }
            if (C34220g.this.mGW == null) {
                C34220g.this.mGW = new ArrayList();
                Cursor dss = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().dss();
                while (dss.moveToNext()) {
                    C34220g.this.mGW.add(dss.getString(0));
                }
                dss.close();
            }
            if (C34220g.this.mGV != null) {
                int[] iArr = new int[]{1000, 2000, 5000, Downloads.MIN_WAIT_FOR_NETWORK, C1625i.sHCENCODEVIDEOTIMEOUT, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, 100000};
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 7) {
                        break;
                    }
                    i = 0;
                    while (true) {
                        int i3 = i;
                        if (i3 >= iArr[i2]) {
                            break;
                        }
                        String D = C20852g.m32061D(C34220g.this.mGV);
                        C7620bi c7620bi = new C7620bi();
                        c7620bi.setType(1);
                        c7620bi.mo14781hO(1);
                        c7620bi.setStatus(4);
                        c7620bi.setContent(D);
                        c7620bi.mo14794ju((String) C34220g.this.mGW.get(i2));
                        c7620bi.mo14775eJ(System.currentTimeMillis());
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
                        C4990ab.m7417i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", Integer.valueOf(i3), Integer.valueOf(iArr[i2]), Integer.valueOf(D.length()), Long.valueOf(c7620bi.field_msgId));
                        i = i3 + 1;
                    }
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(136804);
            return true;
        }

        /* renamed from: D */
        private static String m32061D(String[] strArr) {
            AppMethodBeat.m2504i(136805);
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 300; i++) {
                stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.m2505o(136805);
            return stringBuffer2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.g$e */
    class C31362e extends C28106a {
        C20846i mEl;

        public C31362e(C20846i c20846i) {
            this.mEl = c20846i;
        }

        public final boolean execute() {
            return true;
        }

        public final String getName() {
            return "FTSTestAddChatroomContactTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.g$b */
    class C34221b extends C28106a {
        private C34221b() {
        }

        /* synthetic */ C34221b(C34220g c34220g, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136796);
            StringBuffer stringBuffer = new StringBuffer();
            long length = C45972d.bAc().length();
            C3163e.mCL.mCN = length / 1048576;
            stringBuffer.append("[DBSize]=" + C5046bo.m7580my(length));
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            C3163e.mCL.mCO = C34221b.bAG();
            C3163e.mCL.mCP = C34221b.bAH();
            C3163e.mCL.mCR = C34221b.bAE();
            C3163e.mCL.mCQ = C34221b.bAF();
            ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().mo54778K(-301, C3163e.mCL.mCO);
            ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().mo54778K(-302, C3163e.mCL.mCP);
            ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().mo54778K(-303, C3163e.mCL.mCR);
            ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().mo54778K(-304, C3163e.mCL.mCQ);
            stringBuffer.append("[WXContact]=" + C3163e.mCL.mCO);
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("[WXChatroom]=" + C3163e.mCL.mCP);
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("[Favorite]=" + C3163e.mCL.mCR);
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("[Message]=" + C3163e.mCL.mCQ);
            String stringBuffer2 = stringBuffer.toString();
            C4990ab.m7416i("MicroMsg.FTS.FTSSearchTestLogic", stringBuffer2);
            C5728b c5728b = new C5728b(C34202c.mCx, "FTS5IndexMicroMsgInfo.txt");
            if (c5728b.exists()) {
                c5728b.delete();
            }
            if (!c5728b.dMC().exists()) {
                c5728b.dMC().mkdirs();
            }
            String w = C5736j.m8649w(c5728b.dMD());
            byte[] bytes = stringBuffer2.getBytes();
            int b = C5730e.m8624b(w, bytes, bytes.length);
            C4990ab.m7417i("MicroMsg.FTS.FTSSearchTestLogic", "write fts info %d %s", Integer.valueOf(b), C5736j.m8649w(c5728b.dMD()));
            AppMethodBeat.m2505o(136796);
            return true;
        }

        private static long bAE() {
            AppMethodBeat.m2504i(136797);
            Cursor rawQuery = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[]{"FTS5MetaFavorite", Integer.valueOf(9)}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                AppMethodBeat.m2505o(136797);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.m2505o(136797);
            }
        }

        private static long bAF() {
            AppMethodBeat.m2504i(136798);
            Cursor rawQuery = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s", new Object[]{"FTS5MetaMessage"}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                AppMethodBeat.m2505o(136798);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.m2505o(136798);
            }
        }

        private static long bAG() {
            AppMethodBeat.m2504i(136799);
            Cursor rawQuery = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT), Integer.valueOf(1)}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                AppMethodBeat.m2505o(136799);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.m2505o(136799);
            }
        }

        private static long bAH() {
            AppMethodBeat.m2504i(136800);
            Cursor rawQuery = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38)}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                AppMethodBeat.m2505o(136800);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.m2505o(136800);
            }
        }

        public final String getName() {
            return "FTS5DBInfoTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.g$d */
    class C34222d extends C28106a {
        private C34222d() {
        }

        /* synthetic */ C34222d(C34220g c34220g, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136801);
            C1720g.m3536RP().eJN.mo10108hY(null, "UPDATE rconversation SET unReadCount = 0;");
            AppMethodBeat.m2505o(136801);
            return true;
        }

        public final String getName() {
            return "FTSClearUnReadCountTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.g$a */
    class C34223a extends C28106a {
        private C34223a() {
        }

        /* synthetic */ C34223a(C34220g c34220g, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136795);
            SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException("For Test");
            AppMethodBeat.m2505o(136795);
            throw sQLiteDatabaseCorruptException;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.g$c */
    class C34224c extends C46498m {
        public String mGZ = "";

        public C34224c(int i, List<Integer> list, String str, String str2, Map<String, Integer> map, String str3) {
            super(i, list, str, str2, map, str3);
        }
    }

    public C34220g() {
        AppMethodBeat.m2504i(136806);
        AppMethodBeat.m2505o(136806);
    }

    public final String getName() {
        return "SearchTestLogic";
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(136807);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            this.mGU.dnU();
            AppMethodBeat.m2505o(136807);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
        AppMethodBeat.m2505o(136807);
        return false;
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        C28106a c12049f;
        AppMethodBeat.m2504i(136808);
        switch (c20846i.hbo) {
            case 65521:
                c12049f = new C12049f(c20846i.mEt, c20846i.talker);
                break;
            case 65523:
                c12049f = new C31362e(c20846i);
                break;
            case 65524:
                c12049f = new C34222d(this, (byte) 0);
                break;
            case 65525:
                c12049f = new C20852g(this, (byte) 0);
                break;
            default:
                c12049f = new C34223a(this, (byte) 0);
                break;
        }
        c12049f = this.eAX.mo23853a(-65536, c12049f);
        AppMethodBeat.m2505o(136808);
        return c12049f;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        AppMethodBeat.m2504i(136809);
        C1720g.m3540Rg().mo14546b(30, this.fur);
        AppMethodBeat.m2505o(136809);
        return false;
    }
}
