package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.by;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class n extends by {
    protected static com.tencent.mm.sdk.e.c.a ccO;
    public String kYQ = "";
    public String mAppName = "";
    public String mWA = "";
    public String mWB = "";
    public int mWC = 0;
    public long mWD = 0;
    public long mWE = 0;
    public int mWF = 0;
    public a mWG = new a();
    public String mWH = "";
    public String mWI = "";
    public String mWJ = "";
    public String mWK = "";
    public String mWL = "";
    public String mWM = "";
    public String mWN = "";
    public String mWO;
    public String mWP;
    public String mWQ;
    public String mWR;
    public String mWS;
    public g mWT;
    public f mWU = new f();
    public h mWV = new h();
    public j mWW = new j();
    public b mWX = new b();
    public k mWY = new k();
    public l mWZ = new l();
    public long mWf = 0;
    private boolean mWg = false;
    public String mWh = "";
    public String mWi = "";
    public String mWj = "";
    public String mWk = "";
    public String mWl = "";
    public int mWm = 0;
    public String mWn = "";
    public String mWo = "";
    public LinkedList<i> mWp = new LinkedList();
    public boolean mWq;
    public d mWr = new d();
    public boolean mWs;
    public c mWt = new c();
    public HashMap<String, e> mWu = new HashMap();
    public String mWv = "";
    public int mWw = 0;
    public int mWx = 0;
    public int mWy = 0;
    public String mWz = "";
    public int mXa;
    public int mXb;
    public String mXc;
    public int mXd = 0;
    public String mXe = "";
    public boolean mXf = false;

    public static class a {
        public boolean mTC;
        public boolean mXg;
        public List<String> mXh = new ArrayList();
        public int orientation;
        public String url;

        public a() {
            AppMethodBeat.i(111287);
            AppMethodBeat.o(111287);
        }
    }

    public static class c {
        public String eeO;
        public String mXj;
        public String mXk;
    }

    public static class d {
        public String mText;
        public String mXj;
        public int mXl;
        public int mXm;
        public int mXn;
    }

    public static class j {
        public int kgX = 0;
        public String mXy;
        public long mXz = 0;
    }

    public static class l {
        public int mXB;
        public String mXy;
    }

    public static class k {
        public int mXA;
    }

    public static class b {
        public List<String> mXh = new ArrayList();
        public String mXi;

        public b() {
            AppMethodBeat.i(111288);
            AppMethodBeat.o(111288);
        }
    }

    public static class e {
        public String lAF;
        public int mXo;
    }

    public static class f {
        public String mXj;
        public String mXk;
        public String mXp;
    }

    public static class i {
        public String bCu;
        public String mXu;
        public String mXv;
        public String mXw;
        public String mXx;
        public String userName;
    }

    public static class h {
        public String mName;
        public String mXk;
        public boolean mXt;
    }

    public static class g {
        public String mXk;
        public String mXq;
        public String mXr;
        public String mXs;
    }

    public n() {
        AppMethodBeat.i(111289);
        AppMethodBeat.o(111289);
    }

    public final void bEl() {
        AppMethodBeat.i(111290);
        if (this.mWg) {
            AppMethodBeat.o(111290);
            return;
        }
        if (this.field_msgType == 100) {
            u.bEx();
            u.a(this);
        } else {
            p.a(this);
        }
        this.mWg = true;
        AppMethodBeat.o(111290);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(111291);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xDd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "msgId";
        aVar.columns[1] = "mergerId";
        aVar.xDd.put("mergerId", "TEXT");
        stringBuilder.append(" mergerId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "gameMsgId";
        aVar.xDd.put("gameMsgId", "TEXT");
        stringBuilder.append(" gameMsgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgType";
        aVar.xDd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.xDd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "expireTime";
        aVar.xDd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "showInMsgList";
        aVar.xDd.put("showInMsgList", "INTEGER default 'true' ");
        stringBuilder.append(" showInMsgList INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "isRead";
        aVar.xDd.put("isRead", "INTEGER default 'false' ");
        stringBuilder.append(" isRead INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "label";
        aVar.xDd.put("label", "TEXT default '' ");
        stringBuilder.append(" label TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "isHidden";
        aVar.xDd.put("isHidden", "INTEGER default 'false' ");
        stringBuilder.append(" isHidden INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "weight";
        aVar.xDd.put("weight", "TEXT default '' ");
        stringBuilder.append(" weight TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "rawXML";
        aVar.xDd.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "receiveTime";
        aVar.xDd.put("receiveTime", "LONG default '0' ");
        stringBuilder.append(" receiveTime LONG default '0' ");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(111291);
    }
}
