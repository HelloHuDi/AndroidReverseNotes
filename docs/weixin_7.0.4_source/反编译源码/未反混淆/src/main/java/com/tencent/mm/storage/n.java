package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class n extends j<m> {
    public static final String[] fnj = new String[]{j.a(m.ccO, "BackupTempMoveTime")};
    public e bSd;

    public final /* bridge */ /* synthetic */ boolean a(long j, c cVar) {
        AppMethodBeat.i(29021);
        boolean a = super.a(j, (m) cVar);
        AppMethodBeat.o(29021);
        return a;
    }

    static {
        AppMethodBeat.i(29022);
        AppMethodBeat.o(29022);
    }

    public n(h hVar) {
        super(hVar, m.ccO, "BackupTempMoveTime", null);
        this.bSd = hVar;
    }

    public final void a(LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        AppMethodBeat.i(29019);
        if (getCount() <= 0) {
            linkedList3.addAll(linkedList);
            linkedList4.addAll(linkedList2);
            AppMethodBeat.o(29019);
            return;
        }
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            Object obj = null;
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (!it.hasNext()) {
                    break;
                }
                LinkedList linkedList5;
                long longValue2 = ((Long) it.next()).longValue();
                if (longValue2 == 0) {
                    longValue2 = Long.MAX_VALUE;
                }
                LinkedList linkedList6 = new LinkedList();
                String str2 = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\" ";
                ab.d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:".concat(String.valueOf(str2)));
                Cursor rawQuery = this.bSd.rawQuery(str2, null);
                if (rawQuery == null) {
                    ab.e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", str);
                    linkedList5 = null;
                } else {
                    while (rawQuery.moveToNext()) {
                        m mVar = new m();
                        mVar.d(rawQuery);
                        go goVar = new go();
                        goVar.startTime = mVar.field_startTime;
                        goVar.endTime = mVar.field_endTime;
                        linkedList6.add(goVar);
                    }
                    rawQuery.close();
                    linkedList5 = linkedList6;
                }
                if (linkedList5 == null || linkedList5.size() <= 0 || longValue2 < ((go) linkedList5.getFirst()).startTime || longValue > ((go) linkedList5.getLast()).endTime) {
                    linkedList3.add(str);
                    linkedList4.add(Long.valueOf(longValue));
                    linkedList4.add(Long.valueOf(longValue2));
                } else {
                    Object obj2;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= linkedList5.size() || longValue > longValue2) {
                            obj2 = obj;
                        } else {
                            go goVar2 = (go) linkedList5.get(i2);
                            if (longValue <= goVar2.endTime) {
                                if (longValue < goVar2.startTime) {
                                    obj = 1;
                                    linkedList3.add(str);
                                    linkedList4.add(Long.valueOf(longValue));
                                    if (longValue2 < goVar2.startTime) {
                                        linkedList4.add(Long.valueOf(longValue2));
                                        longValue = goVar2.startTime;
                                        obj2 = 1;
                                        break;
                                    }
                                    linkedList4.add(Long.valueOf(goVar2.startTime));
                                }
                                longValue = goVar2.endTime;
                            }
                            i = i2 + 1;
                        }
                    }
                    if (longValue <= longValue2) {
                        linkedList3.add(str);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        linkedList3.add(str);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                    }
                }
            }
        }
        AppMethodBeat.o(29019);
    }

    public final boolean drx() {
        AppMethodBeat.i(29020);
        ab.i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", Boolean.valueOf(this.bSd.hY("BackupTempMoveTime", "delete from BackupTempMoveTime")));
        AppMethodBeat.o(29020);
        return this.bSd.hY("BackupTempMoveTime", "delete from BackupTempMoveTime");
    }
}
