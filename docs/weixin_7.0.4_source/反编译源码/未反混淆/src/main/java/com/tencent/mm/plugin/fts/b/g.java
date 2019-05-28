package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
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

public final class g extends com.tencent.mm.plugin.fts.a.b {
    m eAX;
    private com.tencent.mm.ai.f fur = new com.tencent.mm.ai.f() {
        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
            AppMethodBeat.i(136794);
            if (mVar instanceof c) {
                c cVar = (c) mVar;
                if (i == 0 && i2 == 0) {
                    ab.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", cVar.vbm.toString());
                } else {
                    ab.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    List list = cVar.vbm;
                    if (i2 == -44) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(1));
                        HashMap hashMap = new HashMap();
                        hashMap.put(list.get(0), Integer.valueOf(0));
                        com.tencent.mm.kernel.g.Rg().a(new c(list, linkedList, "你好，我是珍惜", cVar.mGZ, hashMap, cVar.mGZ), 0);
                    }
                    if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
                        Toast.makeText(ah.getContext(), str, 1).show();
                    }
                    AppMethodBeat.o(136794);
                    return;
                }
            }
            AppMethodBeat.o(136794);
        }
    };
    com.tencent.mm.sdk.b.c mGU = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d>() {
        {
            AppMethodBeat.i(136792);
            this.xxI = com.tencent.mm.g.a.d.class.getName().hashCode();
            AppMethodBeat.o(136792);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136793);
            if (!((com.tencent.mm.g.a.d) bVar).crQ.crR) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136791);
                        if (!g.this.aGx) {
                            g.this.eAX.a(BaseClientBuilder.API_PRIORITY_OTHER, new b(g.this, (byte) 0));
                        }
                        AppMethodBeat.o(136791);
                    }
                }, 10000);
                g.this.mGU.dead();
            }
            AppMethodBeat.o(136793);
            return false;
        }
    };
    String[] mGV;
    List<String> mGW;

    class f extends com.tencent.mm.plugin.fts.a.a.a {
        private int count;
        private String cuP;

        public f(int i, String str) {
            this.count = i;
            this.cuP = str;
        }

        public final boolean execute() {
            AppMethodBeat.i(136802);
            if (g.this.mGV == null) {
                String cy = com.tencent.mm.vfs.e.cy("/sdcard/test_insert_msg_words.txt");
                g.this.mGV = cy.split(",");
            }
            if (g.this.mGW == null) {
                g.this.mGW = new ArrayList();
                if (bo.isNullOrNil(this.cuP)) {
                    Cursor dss = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().dss();
                    while (dss.moveToNext()) {
                        g.this.mGW.add(dss.getString(0));
                    }
                    dss.close();
                } else {
                    g.this.mGW.add(this.cuP);
                }
            }
            if (g.this.mGV != null) {
                for (int i = 0; i < this.count; i++) {
                    Object obj;
                    String D = D(g.this.mGV);
                    bi biVar = new bi();
                    biVar.setType(1);
                    biVar.hO(1);
                    biVar.setStatus(4);
                    biVar.setContent(D);
                    List list = g.this.mGW;
                    if (list.size() > 1) {
                        obj = list.get(new Random().nextInt(list.size() - 1));
                    } else {
                        obj = list.get(0);
                    }
                    biVar.ju((String) obj);
                    biVar.eJ(System.currentTimeMillis() - 250327040);
                    ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Z(biVar);
                    ab.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(D.length()), Long.valueOf(biVar.field_msgId));
                }
            }
            AppMethodBeat.o(136802);
            return true;
        }

        private static String D(String[] strArr) {
            AppMethodBeat.i(136803);
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 300; i++) {
                stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(136803);
            return stringBuffer2;
        }
    }

    class g extends com.tencent.mm.plugin.fts.a.a.a {
        private g() {
        }

        /* synthetic */ g(g gVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136804);
            if (g.this.mGV == null) {
                String cy = com.tencent.mm.vfs.e.cy("/sdcard/test_insert_msg_words.txt");
                g.this.mGV = cy.split(",");
            }
            if (g.this.mGW == null) {
                g.this.mGW = new ArrayList();
                Cursor dss = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().dss();
                while (dss.moveToNext()) {
                    g.this.mGW.add(dss.getString(0));
                }
                dss.close();
            }
            if (g.this.mGV != null) {
                int[] iArr = new int[]{1000, 2000, 5000, Downloads.MIN_WAIT_FOR_NETWORK, i.sHCENCODEVIDEOTIMEOUT, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, 100000};
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
                        String D = D(g.this.mGV);
                        bi biVar = new bi();
                        biVar.setType(1);
                        biVar.hO(1);
                        biVar.setStatus(4);
                        biVar.setContent(D);
                        biVar.ju((String) g.this.mGW.get(i2));
                        biVar.eJ(System.currentTimeMillis());
                        ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Z(biVar);
                        ab.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", Integer.valueOf(i3), Integer.valueOf(iArr[i2]), Integer.valueOf(D.length()), Long.valueOf(biVar.field_msgId));
                        i = i3 + 1;
                    }
                    i = i2 + 1;
                }
            }
            AppMethodBeat.o(136804);
            return true;
        }

        private static String D(String[] strArr) {
            AppMethodBeat.i(136805);
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 300; i++) {
                stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(136805);
            return stringBuffer2;
        }
    }

    class e extends com.tencent.mm.plugin.fts.a.a.a {
        com.tencent.mm.plugin.fts.a.a.i mEl;

        public e(com.tencent.mm.plugin.fts.a.a.i iVar) {
            this.mEl = iVar;
        }

        public final boolean execute() {
            return true;
        }

        public final String getName() {
            return "FTSTestAddChatroomContactTask";
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private b() {
        }

        /* synthetic */ b(g gVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136796);
            StringBuffer stringBuffer = new StringBuffer();
            long length = com.tencent.mm.plugin.fts.d.bAc().length();
            com.tencent.mm.plugin.fts.a.e.mCL.mCN = length / 1048576;
            stringBuffer.append("[DBSize]=" + bo.my(length));
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            com.tencent.mm.plugin.fts.a.e.mCL.mCO = bAG();
            com.tencent.mm.plugin.fts.a.e.mCL.mCP = bAH();
            com.tencent.mm.plugin.fts.a.e.mCL.mCR = bAE();
            com.tencent.mm.plugin.fts.a.e.mCL.mCQ = bAF();
            ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexDB().K(-301, com.tencent.mm.plugin.fts.a.e.mCL.mCO);
            ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexDB().K(-302, com.tencent.mm.plugin.fts.a.e.mCL.mCP);
            ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexDB().K(-303, com.tencent.mm.plugin.fts.a.e.mCL.mCR);
            ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexDB().K(-304, com.tencent.mm.plugin.fts.a.e.mCL.mCQ);
            stringBuffer.append("[WXContact]=" + com.tencent.mm.plugin.fts.a.e.mCL.mCO);
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("[WXChatroom]=" + com.tencent.mm.plugin.fts.a.e.mCL.mCP);
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("[Favorite]=" + com.tencent.mm.plugin.fts.a.e.mCL.mCR);
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("[Message]=" + com.tencent.mm.plugin.fts.a.e.mCL.mCQ);
            String stringBuffer2 = stringBuffer.toString();
            ab.i("MicroMsg.FTS.FTSSearchTestLogic", stringBuffer2);
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fts.a.c.mCx, "FTS5IndexMicroMsgInfo.txt");
            if (bVar.exists()) {
                bVar.delete();
            }
            if (!bVar.dMC().exists()) {
                bVar.dMC().mkdirs();
            }
            String w = com.tencent.mm.vfs.j.w(bVar.dMD());
            byte[] bytes = stringBuffer2.getBytes();
            int b = com.tencent.mm.vfs.e.b(w, bytes, bytes.length);
            ab.i("MicroMsg.FTS.FTSSearchTestLogic", "write fts info %d %s", Integer.valueOf(b), com.tencent.mm.vfs.j.w(bVar.dMD()));
            AppMethodBeat.o(136796);
            return true;
        }

        private static long bAE() {
            AppMethodBeat.i(136797);
            Cursor rawQuery = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[]{"FTS5MetaFavorite", Integer.valueOf(9)}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                AppMethodBeat.o(136797);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.o(136797);
            }
        }

        private static long bAF() {
            AppMethodBeat.i(136798);
            Cursor rawQuery = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s", new Object[]{"FTS5MetaMessage"}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                AppMethodBeat.o(136798);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.o(136798);
            }
        }

        private static long bAG() {
            AppMethodBeat.i(136799);
            Cursor rawQuery = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT), Integer.valueOf(1)}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                AppMethodBeat.o(136799);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.o(136799);
            }
        }

        private static long bAH() {
            AppMethodBeat.i(136800);
            Cursor rawQuery = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38)}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                AppMethodBeat.o(136800);
                return 0;
            } finally {
                rawQuery.close();
                AppMethodBeat.o(136800);
            }
        }

        public final String getName() {
            return "FTS5DBInfoTask";
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private d() {
        }

        /* synthetic */ d(g gVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136801);
            com.tencent.mm.kernel.g.RP().eJN.hY(null, "UPDATE rconversation SET unReadCount = 0;");
            AppMethodBeat.o(136801);
            return true;
        }

        public final String getName() {
            return "FTSClearUnReadCountTask";
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private a() {
        }

        /* synthetic */ a(g gVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136795);
            SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException("For Test");
            AppMethodBeat.o(136795);
            throw sQLiteDatabaseCorruptException;
        }
    }

    class c extends com.tencent.mm.pluginsdk.model.m {
        public String mGZ = "";

        public c(int i, List<Integer> list, String str, String str2, Map<String, Integer> map, String str3) {
            super(i, list, str, str2, map, str3);
        }
    }

    public g() {
        AppMethodBeat.i(136806);
        AppMethodBeat.o(136806);
    }

    public final String getName() {
        return "SearchTestLogic";
    }

    public final boolean onCreate() {
        AppMethodBeat.i(136807);
        if (((n) com.tencent.mm.kernel.g.M(n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
            this.eAX = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSTaskDaemon();
            this.mGU.dnU();
            AppMethodBeat.o(136807);
            return true;
        }
        ab.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
        AppMethodBeat.o(136807);
        return false;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.i iVar) {
        com.tencent.mm.plugin.fts.a.a.a fVar;
        AppMethodBeat.i(136808);
        switch (iVar.hbo) {
            case 65521:
                fVar = new f(iVar.mEt, iVar.talker);
                break;
            case 65523:
                fVar = new e(iVar);
                break;
            case 65524:
                fVar = new d(this, (byte) 0);
                break;
            case 65525:
                fVar = new g(this, (byte) 0);
                break;
            default:
                fVar = new a(this, (byte) 0);
                break;
        }
        fVar = this.eAX.a(-65536, fVar);
        AppMethodBeat.o(136808);
        return fVar;
    }

    public final boolean Pq() {
        AppMethodBeat.i(136809);
        com.tencent.mm.kernel.g.Rg().b(30, this.fur);
        AppMethodBeat.o(136809);
        return false;
    }
}
