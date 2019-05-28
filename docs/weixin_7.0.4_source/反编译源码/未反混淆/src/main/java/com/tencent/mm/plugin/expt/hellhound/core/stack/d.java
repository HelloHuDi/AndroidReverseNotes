package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.stack.b.AnonymousClass1;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class d {
    private static volatile d lMv;
    public e lMw = new e();

    public static d bqu() {
        AppMethodBeat.i(73362);
        if (lMv == null) {
            synchronized (d.class) {
                try {
                    if (lMv == null) {
                        lMv = new d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(73362);
                    }
                }
            }
        }
        d dVar = lMv;
        AppMethodBeat.o(73362);
        return dVar;
    }

    private d() {
        AppMethodBeat.i(73363);
        ab.i("ActivityStackSupervisor", "habbyge-mali, ActivityStackSupervisor");
        if (b.bqo()) {
            ab.i("ActivityStackDao", "habbyge-mali, ActivityStackDao reset");
            com.tencent.mm.plugin.expt.hellhound.core.a.b.v("hell_astackd_mmkv_key", new byte[0]);
        }
        AppMethodBeat.o(73363);
    }

    public final void a(Intent intent, String str, String str2) {
        AppMethodBeat.i(73364);
        e eVar = this.lMw;
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                bf bfVar;
                int i;
                bf bqs;
                cgq cgq;
                int intValue;
                int flags = intent.getFlags();
                ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push activity/flags: " + str + "/0x" + Integer.toHexString(flags));
                if (TextUtils.isEmpty(str2)) {
                    ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, startActivity: ".concat(String.valueOf(str)));
                } else {
                    c bqz = g.bqz();
                    bfVar = (bf) bqz.get(0);
                    be beVar = (be) bqz.get(1);
                    if (beVar != null) {
                        ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, topAR: " + beVar.vDg.activityName + "/" + beVar.vDg.wkp + "/" + str + "/" + str2);
                    }
                    int i2 = (beVar == null || beVar.vDg == null || !beVar.vDg.activityName.equals(str) || !TextUtils.isEmpty(beVar.vDg.wkp)) ? 0 : 1;
                    if (i2 != 0) {
                        beVar.vDg.wkp = str2;
                        ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, create/newIntent: only push stack".concat(String.valueOf(str)));
                        c.a(bfVar);
                        AppMethodBeat.o(73364);
                        return;
                    }
                    ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, create/newIntent: ".concat(String.valueOf(str)));
                }
                be beVar2 = new be();
                beVar2.vDg = new chm();
                beVar2.vDg.activityName = str;
                chm chm = beVar2.vDg;
                if (str2 == null) {
                    str2 = "";
                }
                chm.wkp = str2;
                beVar2.flags = flags;
                beVar2.state = a.CREATE.value;
                if (flags == 0) {
                    i = 0;
                } else if ((268435456 & flags) == 268435456) {
                    ab.d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_NEW_TASK");
                    i = 100;
                    int i3 = beVar2.flags;
                    ab.d("ActivityStackWrapper", "habbyge-mali, flagActivityNewTask flags = 0x" + Integer.toHexString(i3) + "/" + beVar2.vDg.activityName);
                    if ((134217728 & i3) == 134217728) {
                        ab.d("ActivityStackWrapper", "activity stack push: FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_MULTIPLE_TASK");
                        i = 3;
                    } else if ((32768 & i3) == 32768) {
                        ab.d("ActivityStackWrapper", "activity stack push: FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK");
                        if (TextUtils.isEmpty(beVar2.vDg.activityName)) {
                            i = 100;
                        } else {
                            ab.d("TaskRecordWrapper", "habbyge-mali, flagNewTaskAndClearTask: " + beVar2.vDg.activityName);
                            bqs = c.bqs();
                            g.c(bqs);
                            c a = g.a(bqs, beVar2);
                            if (a == null) {
                                i = 101;
                            } else {
                                cgq = (cgq) a.get(0);
                                cgq.xfy.clear();
                                cgq.xfx = false;
                                cgq.xfy.addLast(beVar2);
                                c.a(bqs);
                                i = 100;
                            }
                        }
                    } else if ((i3 & 67108864) == 67108864) {
                        i = 2;
                    } else {
                        boolean d = eVar.lMx.d(beVar2);
                        ab.d("ActivityStackWrapper", "habbyge-mali, push activityExisted = ".concat(String.valueOf(d)));
                        if (!d) {
                            i = 101;
                        }
                    }
                } else if ((flags & 67108864) == 67108864) {
                    ab.d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_CLEAR_TOP");
                    i = 2;
                } else if ((536870912 & flags) == 536870912) {
                    ab.d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_SINGLE_TOP");
                    i = 1;
                } else if ((WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT & flags) == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    ab.d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_REORDER_TO_FRONT");
                    if ((flags & 67108864) == 67108864) {
                        i = 2;
                    } else {
                        ab.d("ActivityStackWrapper", "activity stack push: FLAG_ACTIVITY_REORDER_TO_FRONT");
                        ab.d("TaskRecordWrapper", "habbyge-mali, reorderMode: " + beVar2.vDg.activityName);
                        bf bqs2 = c.bqs();
                        g.c(bqs2);
                        c c = g.c(bqs2, beVar2);
                        int intValue2 = ((Integer) c.get(0)).intValue();
                        intValue = ((Integer) c.get(1)).intValue();
                        if (intValue < 0) {
                            g.b(bqs2, beVar2);
                        } else {
                            if (intValue2 == bqs2.vDi.size() - 1) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            if (i != 0) {
                                cgq = (cgq) bqs2.vDi.getLast();
                                if (cgq == null) {
                                    g.b(bqs2, beVar2);
                                } else {
                                    g.b(bqs2, (be) cgq.xfy.remove(intValue));
                                }
                            } else {
                                cgq = (cgq) bqs2.vDi.remove(intValue2);
                                bqs2.vDi.addLast(cgq);
                                g.b(bqs2, (be) cgq.xfy.remove(intValue));
                            }
                        }
                        c.a(bqs2);
                        i = 100;
                    }
                } else if ((134217728 & flags) == 134217728 && (SQLiteGlobal.journalSizeLimit & flags) == SQLiteGlobal.journalSizeLimit) {
                    i = 3;
                    ab.d("ActivityStackWrapper", "habbyge-mali, Intent.FLAG_ACTIVITY_MULTIPLE_TASK");
                } else {
                    ab.e("ActivityStackWrapper", "activity stack push: activigy/flags = " + beVar2.vDg.activityName + "/0x" + Integer.toHexString(flags));
                    i = 100;
                }
                switch (i) {
                    case 0:
                        ab.d("ActivityStackWrapper", "habbyge-mali, LAUNCH_MULTIPLE: " + beVar2.vDg.activityName);
                        bfVar = c.bqs();
                        g.c(bfVar);
                        if (g.b(bfVar)) {
                            ab.d("TaskRecordWrapper", "habbyge-mali, standardMode.1: " + beVar2.vDg.activityName);
                            g.a(bfVar, beVar2, false);
                        } else {
                            ab.d("TaskRecordWrapper", "habbyge-mali, standardMode.2: " + beVar2.vDg.activityName);
                            g.b(bfVar, beVar2);
                        }
                        c.a(bfVar);
                        AppMethodBeat.o(73364);
                        return;
                    case 1:
                        ab.d("ActivityStackWrapper", "habbyge-mali, LAUNCH_SINGLE_TOP: " + beVar2.vDg.activityName);
                        ab.d("TaskRecordWrapper", "habbyge-mali, singleTopMode: " + beVar2.vDg.activityName);
                        bqs = c.bqs();
                        g.c(bqs);
                        if (g.b(bqs)) {
                            g.a(bqs, beVar2, false);
                        } else {
                            be beVar3;
                            if (bqs == null) {
                                beVar3 = null;
                            } else {
                                cgq = null;
                                if (!bqs.vDi.isEmpty()) {
                                    cgq = (cgq) bqs.vDi.getLast();
                                }
                                if (cgq == null) {
                                    beVar3 = null;
                                } else if (cgq.xfy.isEmpty()) {
                                    beVar3 = null;
                                } else {
                                    beVar3 = (be) cgq.xfy.getLast();
                                }
                            }
                            if (beVar3 == null || !h.a(beVar2.vDg, beVar3.vDg)) {
                                g.b(bqs, beVar2);
                            } else {
                                ab.d("TaskRecordWrapper", "habbyge-mali, singleTopMode = " + beVar2.vDg.activityName);
                            }
                        }
                        c.a(bqs);
                        AppMethodBeat.o(73364);
                        return;
                    case 2:
                        ab.d("ActivityStackWrapper", "habbyge-mali, LAUNCH_SINGLE_TASK: " + beVar2.vDg.activityName);
                        g gVar = eVar.lMx;
                        ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: " + beVar2.vDg.activityName);
                        bf bqs3 = c.bqs();
                        g.c(bqs3);
                        if (g.b(bqs3)) {
                            g.a(bqs3, beVar2, false);
                        } else {
                            c c2 = g.c(bqs3, beVar2);
                            intValue = ((Integer) c2.get(0)).intValue();
                            flags = ((Integer) c2.get(1)).intValue();
                            if (flags < 0) {
                                ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: not in stack !");
                                g.b(bqs3, beVar2);
                            } else {
                                if ((intValue == bqs3.vDi.size() + -1 ? 1 : 0) != 0) {
                                    if (flags == ((cgq) bqs3.vDi.getLast()).xfy.size() - 1) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: in top of stack !");
                                        i = 0;
                                    } else {
                                        ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: in stack, but not top of stack !");
                                        i = 1;
                                    }
                                } else {
                                    ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: in stack, but not top of stack !");
                                    i = 2;
                                }
                                if (i == 1) {
                                    gVar.a(bqs3, flags + 1);
                                }
                                if (i == 2) {
                                    gVar.a(bqs3, intValue + 1, beVar2);
                                    gVar.a(bqs3, flags + 1);
                                }
                            }
                        }
                        c.a(bqs3);
                        AppMethodBeat.o(73364);
                        return;
                    case 3:
                        ab.d("ActivityStackWrapper", "habbyge-mali, LAUNCH_SINGLE_INSTANCE: " + beVar2.vDg.activityName);
                        g.c(beVar2);
                        AppMethodBeat.o(73364);
                        return;
                    case 100:
                        ab.d("ActivityStackWrapper", "habbyge-mali, FLAG_ACTIVITY_DO_NOTHING: " + beVar2.vDg.activityName);
                        AppMethodBeat.o(73364);
                        return;
                    case 101:
                        ab.d("ActivityStackWrapper", "habbyge-mali, FLAG_ACTIVITY_CREATE_TASKRECORD: " + beVar2.vDg.activityName);
                        ab.d("TaskRecordWrapper", "habbyge-mali, newTaskRecord: " + beVar2.vDg.activityName + "/false");
                        bfVar = c.bqs();
                        g.c(bfVar);
                        g.a(bfVar, beVar2, false);
                        c.a(bfVar);
                        AppMethodBeat.o(73364);
                        return;
                    default:
                        ab.e("ActivityStackWrapper", "habbyge-mali, operateStack.exception");
                        break;
                }
            }
            ab.e("ActivityStackWrapper", "habbyge-mali, push: aName=null, action = ".concat(String.valueOf(intent.getAction())));
            AppMethodBeat.o(73364);
            return;
        }
        AppMethodBeat.o(73364);
    }

    public static be bqv() {
        AppMethodBeat.i(73365);
        be beVar = (be) g.bqz().get(1);
        AppMethodBeat.o(73365);
        return beVar;
    }

    public static void a(String str, String str2, a aVar) {
        AppMethodBeat.i(73366);
        bf bqs = c.bqs();
        if (bqs.vDj == null) {
            bqs.vDj = new bd();
        }
        switch (AnonymousClass1.lMu[aVar.ordinal()]) {
            case 1:
                if (bqs.vDj.vDb == null) {
                    bqs.vDj.vDb = new be();
                }
                if (bqs.vDj.vDb.vDg == null) {
                    bqs.vDj.vDb.vDg = new chm();
                }
                bqs.vDj.vDb.vDg.activityName = str;
                bqs.vDj.vDb.vDg.wkp = str2;
                bqs.vDj.vDb.state = a.CREATE.value;
                break;
            case 2:
                if (bqs.vDj.vDc == null) {
                    bqs.vDj.vDc = new be();
                }
                if (bqs.vDj.vDc.vDg == null) {
                    bqs.vDj.vDc.vDg = new chm();
                }
                bqs.vDj.vDc.vDg.activityName = str;
                bqs.vDj.vDc.vDg.wkp = str2;
                bqs.vDj.vDc.state = a.RESUME.value;
                break;
            case 3:
                if (bqs.vDj.vDd == null) {
                    bqs.vDj.vDd = new be();
                }
                if (bqs.vDj.vDd.vDg == null) {
                    bqs.vDj.vDd.vDg = new chm();
                }
                bqs.vDj.vDd.vDg.activityName = str;
                bqs.vDj.vDd.vDg.wkp = str2;
                bqs.vDj.vDd.state = a.PAUSE.value;
                break;
            case 4:
                if (bqs.vDj.vDe == null) {
                    bqs.vDj.vDe = new be();
                }
                if (bqs.vDj.vDe.vDg == null) {
                    bqs.vDj.vDe.vDg = new chm();
                }
                bqs.vDj.vDe.vDg.activityName = str;
                bqs.vDj.vDe.vDg.wkp = str2;
                bqs.vDj.vDe.state = a.STOP.value;
                break;
        }
        c.a(bqs);
        AppMethodBeat.o(73366);
    }

    public static c<String, String> bqw() {
        AppMethodBeat.i(73367);
        bf bqs = c.bqs();
        c<String, String> F;
        if (bqs.vDj == null) {
            c F2 = a.F(null, null);
            AppMethodBeat.o(73367);
            return F2;
        } else if (bqs.vDj.vDb == null) {
            F = a.F(null, null);
            AppMethodBeat.o(73367);
            return F;
        } else {
            String str = bqs.vDj.vDb.vDg.activityName;
            String str2 = bqs.vDj.vDb.vDg.wkp;
            ab.i("ActivityPointerWrapper", "habbyge-mali, getCreateActivity: ".concat(String.valueOf(str)));
            F = a.F(str, str2);
            AppMethodBeat.o(73367);
            return F;
        }
    }

    public static c<String, String> bqx() {
        AppMethodBeat.i(73368);
        bf bqs = c.bqs();
        c<String, String> F;
        if (bqs.vDj == null) {
            c F2 = a.F(null, null);
            AppMethodBeat.o(73368);
            return F2;
        } else if (bqs.vDj.vDc == null) {
            F = a.F(null, null);
            AppMethodBeat.o(73368);
            return F;
        } else {
            String str = bqs.vDj.vDc.vDg.activityName;
            String str2 = bqs.vDj.vDc.vDg.wkp;
            ab.i("ActivityPointerWrapper", "habbyge-mali, getResumedActivity: ".concat(String.valueOf(str)));
            F = a.F(str, str2);
            AppMethodBeat.o(73368);
            return F;
        }
    }

    public static c<String, String> bqy() {
        AppMethodBeat.i(73369);
        bf bqs = c.bqs();
        c<String, String> F;
        if (bqs.vDj == null) {
            c F2 = a.F(null, null);
            AppMethodBeat.o(73369);
            return F2;
        } else if (bqs.vDj.vDd == null) {
            F = a.F(null, null);
            AppMethodBeat.o(73369);
            return F;
        } else {
            String str = bqs.vDj.vDd.vDg.activityName;
            String str2 = bqs.vDj.vDd.vDg.wkp;
            ab.i("ActivityPointerWrapper", "habbyge-mali, getPausedActivity: ".concat(String.valueOf(str)));
            F = a.F(str, str2);
            AppMethodBeat.o(73369);
            return F;
        }
    }

    public static boolean k(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(73370);
        ab.d("TokenWrapper", "habbyge-mali, TokenWrapper.equalWithHashCode: " + str + "=" + str2 + "/" + str3 + "=" + str4);
        if (str.equals(str3) && str2.equals(str4)) {
            AppMethodBeat.o(73370);
            return true;
        }
        AppMethodBeat.o(73370);
        return false;
    }
}
