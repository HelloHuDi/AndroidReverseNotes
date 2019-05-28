package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.protocal.protobuf.C44122go;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.storage.n */
public final class C15444n extends C7563j<C15443m> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C15443m.ccO, "BackupTempMoveTime")};
    public C4927e bSd;

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo16757a(long j, C4925c c4925c) {
        AppMethodBeat.m2504i(29021);
        boolean a = super.mo16757a(j, (C15443m) c4925c);
        AppMethodBeat.m2505o(29021);
        return a;
    }

    static {
        AppMethodBeat.m2504i(29022);
        AppMethodBeat.m2505o(29022);
    }

    public C15444n(C7480h c7480h) {
        super(c7480h, C15443m.ccO, "BackupTempMoveTime", null);
        this.bSd = c7480h;
    }

    /* renamed from: a */
    public final void mo27487a(LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        AppMethodBeat.m2504i(29019);
        if (getCount() <= 0) {
            linkedList3.addAll(linkedList);
            linkedList4.addAll(linkedList2);
            AppMethodBeat.m2505o(29019);
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
                C4990ab.m7410d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:".concat(String.valueOf(str2)));
                Cursor rawQuery = this.bSd.rawQuery(str2, null);
                if (rawQuery == null) {
                    C4990ab.m7413e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", str);
                    linkedList5 = null;
                } else {
                    while (rawQuery.moveToNext()) {
                        C15443m c15443m = new C15443m();
                        c15443m.mo8995d(rawQuery);
                        C44122go c44122go = new C44122go();
                        c44122go.startTime = c15443m.field_startTime;
                        c44122go.endTime = c15443m.field_endTime;
                        linkedList6.add(c44122go);
                    }
                    rawQuery.close();
                    linkedList5 = linkedList6;
                }
                if (linkedList5 == null || linkedList5.size() <= 0 || longValue2 < ((C44122go) linkedList5.getFirst()).startTime || longValue > ((C44122go) linkedList5.getLast()).endTime) {
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
                            C44122go c44122go2 = (C44122go) linkedList5.get(i2);
                            if (longValue <= c44122go2.endTime) {
                                if (longValue < c44122go2.startTime) {
                                    obj = 1;
                                    linkedList3.add(str);
                                    linkedList4.add(Long.valueOf(longValue));
                                    if (longValue2 < c44122go2.startTime) {
                                        linkedList4.add(Long.valueOf(longValue2));
                                        longValue = c44122go2.startTime;
                                        obj2 = 1;
                                        break;
                                    }
                                    linkedList4.add(Long.valueOf(c44122go2.startTime));
                                }
                                longValue = c44122go2.endTime;
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
        AppMethodBeat.m2505o(29019);
    }

    public final boolean drx() {
        AppMethodBeat.m2504i(29020);
        C4990ab.m7417i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", Boolean.valueOf(this.bSd.mo10108hY("BackupTempMoveTime", "delete from BackupTempMoveTime")));
        AppMethodBeat.m2505o(29020);
        return this.bSd.mo10108hY("BackupTempMoveTime", "delete from BackupTempMoveTime");
    }
}
