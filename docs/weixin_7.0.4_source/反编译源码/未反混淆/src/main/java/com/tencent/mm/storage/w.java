package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.an;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w extends an {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final List<c> mO(long j) {
        AppMethodBeat.i(60103);
        LinkedList linkedList = new LinkedList();
        if (this.field_seqBlockInfo == null) {
            AppMethodBeat.o(60103);
            return linkedList;
        }
        Iterator it = this.field_seqBlockInfo.eoG.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.eoF <= j) {
                linkedList.add(cVar);
            }
        }
        AppMethodBeat.o(60103);
        return linkedList;
    }

    public final List<c> mP(long j) {
        AppMethodBeat.i(60104);
        LinkedList linkedList = new LinkedList();
        if (this.field_seqBlockInfo == null) {
            AppMethodBeat.o(60104);
            return linkedList;
        }
        Iterator it = this.field_seqBlockInfo.eoG.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.eoC > j) {
                linkedList.add(cVar);
            }
        }
        AppMethodBeat.o(60104);
        return linkedList;
    }

    public final String toString() {
        AppMethodBeat.i(60105);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("username:").append(this.field_username).append(" ");
        stringBuilder.append("lastLocalSeq:").append(this.field_lastLocalSeq).append(" ");
        stringBuilder.append("lastPushSeq:").append(this.field_lastPushSeq).append(" ");
        if (this.field_seqBlockInfo != null) {
            stringBuilder.append("block:");
            Iterator it = this.field_seqBlockInfo.eoG.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                stringBuilder.append("[").append(cVar.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(cVar.eoD).append("][").append(cVar.eoE).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(cVar.eoF).append("] | ");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(60105);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.i(60106);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[1] = "lastPushSeq";
        aVar.xDd.put("lastPushSeq", "LONG");
        stringBuilder.append(" lastPushSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "lastLocalSeq";
        aVar.xDd.put("lastLocalSeq", "LONG");
        stringBuilder.append(" lastLocalSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "lastPushCreateTime";
        aVar.xDd.put("lastPushCreateTime", "LONG");
        stringBuilder.append(" lastPushCreateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "lastLocalCreateTime";
        aVar.xDd.put("lastLocalCreateTime", "LONG");
        stringBuilder.append(" lastLocalCreateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "seqBlockInfo";
        aVar.xDd.put("seqBlockInfo", "BLOB");
        stringBuilder.append(" seqBlockInfo BLOB");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(60106);
    }
}
