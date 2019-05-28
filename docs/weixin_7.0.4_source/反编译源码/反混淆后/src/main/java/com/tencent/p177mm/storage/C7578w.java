package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6561an;
import com.tencent.p177mm.p712j.p713a.p714a.C6594c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.storage.w */
public final class C7578w extends C6561an {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: mO */
    public final List<C6594c> mo16810mO(long j) {
        AppMethodBeat.m2504i(60103);
        LinkedList linkedList = new LinkedList();
        if (this.field_seqBlockInfo == null) {
            AppMethodBeat.m2505o(60103);
            return linkedList;
        }
        Iterator it = this.field_seqBlockInfo.eoG.iterator();
        while (it.hasNext()) {
            C6594c c6594c = (C6594c) it.next();
            if (c6594c.eoF <= j) {
                linkedList.add(c6594c);
            }
        }
        AppMethodBeat.m2505o(60103);
        return linkedList;
    }

    /* renamed from: mP */
    public final List<C6594c> mo16811mP(long j) {
        AppMethodBeat.m2504i(60104);
        LinkedList linkedList = new LinkedList();
        if (this.field_seqBlockInfo == null) {
            AppMethodBeat.m2505o(60104);
            return linkedList;
        }
        Iterator it = this.field_seqBlockInfo.eoG.iterator();
        while (it.hasNext()) {
            C6594c c6594c = (C6594c) it.next();
            if (c6594c.eoC > j) {
                linkedList.add(c6594c);
            }
        }
        AppMethodBeat.m2505o(60104);
        return linkedList;
    }

    public final String toString() {
        AppMethodBeat.m2504i(60105);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("username:").append(this.field_username).append(" ");
        stringBuilder.append("lastLocalSeq:").append(this.field_lastLocalSeq).append(" ");
        stringBuilder.append("lastPushSeq:").append(this.field_lastPushSeq).append(" ");
        if (this.field_seqBlockInfo != null) {
            stringBuilder.append("block:");
            Iterator it = this.field_seqBlockInfo.eoG.iterator();
            while (it.hasNext()) {
                C6594c c6594c = (C6594c) it.next();
                stringBuilder.append("[").append(c6594c.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c6594c.eoD).append("][").append(c6594c.eoE).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c6594c.eoF).append("] | ");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(60105);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.m2504i(60106);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[1] = "lastPushSeq";
        c4924a.xDd.put("lastPushSeq", "LONG");
        stringBuilder.append(" lastPushSeq LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "lastLocalSeq";
        c4924a.xDd.put("lastLocalSeq", "LONG");
        stringBuilder.append(" lastLocalSeq LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "lastPushCreateTime";
        c4924a.xDd.put("lastPushCreateTime", "LONG");
        stringBuilder.append(" lastPushCreateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "lastLocalCreateTime";
        c4924a.xDd.put("lastLocalCreateTime", "LONG");
        stringBuilder.append(" lastLocalCreateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "seqBlockInfo";
        c4924a.xDd.put("seqBlockInfo", "BLOB");
        stringBuilder.append(" seqBlockInfo BLOB");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(60106);
    }
}
