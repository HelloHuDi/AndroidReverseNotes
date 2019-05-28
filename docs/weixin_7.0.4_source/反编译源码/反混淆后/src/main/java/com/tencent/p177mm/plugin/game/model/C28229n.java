package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18463by;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.model.n */
public final class C28229n extends C18463by {
    protected static C4924a ccO;
    public String kYQ = "";
    public String mAppName = "";
    public String mWA = "";
    public String mWB = "";
    public int mWC = 0;
    public long mWD = 0;
    public long mWE = 0;
    public int mWF = 0;
    public C3244a mWG = new C3244a();
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
    public C28235g mWT;
    public C28232f mWU = new C28232f();
    public C28234h mWV = new C28234h();
    public C12171j mWW = new C12171j();
    public C28230b mWX = new C28230b();
    public C28228k mWY = new C28228k();
    public C12172l mWZ = new C12172l();
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
    public LinkedList<C28233i> mWp = new LinkedList();
    public boolean mWq;
    public C12170d mWr = new C12170d();
    public boolean mWs;
    public C3245c mWt = new C3245c();
    public HashMap<String, C28231e> mWu = new HashMap();
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

    /* renamed from: com.tencent.mm.plugin.game.model.n$a */
    public static class C3244a {
        public boolean mTC;
        public boolean mXg;
        public List<String> mXh = new ArrayList();
        public int orientation;
        public String url;

        public C3244a() {
            AppMethodBeat.m2504i(111287);
            AppMethodBeat.m2505o(111287);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$c */
    public static class C3245c {
        public String eeO;
        public String mXj;
        public String mXk;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$d */
    public static class C12170d {
        public String mText;
        public String mXj;
        public int mXl;
        public int mXm;
        public int mXn;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$j */
    public static class C12171j {
        public int kgX = 0;
        public String mXy;
        public long mXz = 0;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$l */
    public static class C12172l {
        public int mXB;
        public String mXy;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$k */
    public static class C28228k {
        public int mXA;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$b */
    public static class C28230b {
        public List<String> mXh = new ArrayList();
        public String mXi;

        public C28230b() {
            AppMethodBeat.m2504i(111288);
            AppMethodBeat.m2505o(111288);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$e */
    public static class C28231e {
        public String lAF;
        public int mXo;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$f */
    public static class C28232f {
        public String mXj;
        public String mXk;
        public String mXp;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$i */
    public static class C28233i {
        public String bCu;
        public String mXu;
        public String mXv;
        public String mXw;
        public String mXx;
        public String userName;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$h */
    public static class C28234h {
        public String mName;
        public String mXk;
        public boolean mXt;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.n$g */
    public static class C28235g {
        public String mXk;
        public String mXq;
        public String mXr;
        public String mXs;
    }

    public C28229n() {
        AppMethodBeat.m2504i(111289);
        AppMethodBeat.m2505o(111289);
    }

    public final void bEl() {
        AppMethodBeat.m2504i(111290);
        if (this.mWg) {
            AppMethodBeat.m2505o(111290);
            return;
        }
        if (this.field_msgType == 100) {
            C12175u.bEx();
            C12175u.m20105a(this);
        } else {
            C46011p.m85489a(this);
        }
        this.mWg = true;
        AppMethodBeat.m2505o(111290);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(111291);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[14];
        c4924a.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "msgId";
        c4924a.xDd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "msgId";
        c4924a.columns[1] = "mergerId";
        c4924a.xDd.put("mergerId", "TEXT");
        stringBuilder.append(" mergerId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "gameMsgId";
        c4924a.xDd.put("gameMsgId", "TEXT");
        stringBuilder.append(" gameMsgId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "msgType";
        c4924a.xDd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "createTime";
        c4924a.xDd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "expireTime";
        c4924a.xDd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "showInMsgList";
        c4924a.xDd.put("showInMsgList", "INTEGER default 'true' ");
        stringBuilder.append(" showInMsgList INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "isRead";
        c4924a.xDd.put("isRead", "INTEGER default 'false' ");
        stringBuilder.append(" isRead INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "label";
        c4924a.xDd.put("label", "TEXT default '' ");
        stringBuilder.append(" label TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = "isHidden";
        c4924a.xDd.put("isHidden", "INTEGER default 'false' ");
        stringBuilder.append(" isHidden INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "weight";
        c4924a.xDd.put("weight", "TEXT default '' ");
        stringBuilder.append(" weight TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "rawXML";
        c4924a.xDd.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "receiveTime";
        c4924a.xDd.put("receiveTime", "LONG default '0' ");
        stringBuilder.append(" receiveTime LONG default '0' ");
        c4924a.columns[14] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(111291);
    }
}
