package com.tencent.p177mm.plugin.expt.hellhound.core.stack;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.expt.hellhound.core.C11759b;
import com.tencent.p177mm.plugin.expt.hellhound.core.p1258a.C20599b;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C38988b.C340761;
import com.tencent.p177mm.protocal.protobuf.C44101be;
import com.tencent.p177mm.protocal.protobuf.C44102bf;
import com.tencent.p177mm.protocal.protobuf.C46526bd;
import com.tencent.p177mm.protocal.protobuf.cgq;
import com.tencent.p177mm.protocal.protobuf.chm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.d */
public final class C20600d {
    private static volatile C20600d lMv;
    public C20601e lMw = new C20601e();

    public static C20600d bqu() {
        AppMethodBeat.m2504i(73362);
        if (lMv == null) {
            synchronized (C20600d.class) {
                try {
                    if (lMv == null) {
                        lMv = new C20600d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(73362);
                    }
                }
            }
        }
        C20600d c20600d = lMv;
        AppMethodBeat.m2505o(73362);
        return c20600d;
    }

    private C20600d() {
        AppMethodBeat.m2504i(73363);
        C4990ab.m7416i("ActivityStackSupervisor", "habbyge-mali, ActivityStackSupervisor");
        if (C11759b.bqo()) {
            C4990ab.m7416i("ActivityStackDao", "habbyge-mali, ActivityStackDao reset");
            C20599b.m31826v("hell_astackd_mmkv_key", new byte[0]);
        }
        AppMethodBeat.m2505o(73363);
    }

    /* renamed from: a */
    public final void mo35872a(Intent intent, String str, String str2) {
        AppMethodBeat.m2504i(73364);
        C20601e c20601e = this.lMw;
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                C44102bf c44102bf;
                int i;
                C44102bf bqs;
                cgq cgq;
                int intValue;
                int flags = intent.getFlags();
                C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push activity/flags: " + str + "/0x" + Integer.toHexString(flags));
                if (TextUtils.isEmpty(str2)) {
                    C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, startActivity: ".concat(String.valueOf(str)));
                } else {
                    C7583c bqz = C20602g.bqz();
                    c44102bf = (C44102bf) bqz.get(0);
                    C44101be c44101be = (C44101be) bqz.get(1);
                    if (c44101be != null) {
                        C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, topAR: " + c44101be.vDg.activityName + "/" + c44101be.vDg.wkp + "/" + str + "/" + str2);
                    }
                    int i2 = (c44101be == null || c44101be.vDg == null || !c44101be.vDg.activityName.equals(str) || !TextUtils.isEmpty(c44101be.vDg.wkp)) ? 0 : 1;
                    if (i2 != 0) {
                        c44101be.vDg.wkp = str2;
                        C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, create/newIntent: only push stack".concat(String.valueOf(str)));
                        C27895c.m44357a(c44102bf);
                        AppMethodBeat.m2505o(73364);
                        return;
                    }
                    C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, create/newIntent: ".concat(String.valueOf(str)));
                }
                C44101be c44101be2 = new C44101be();
                c44101be2.vDg = new chm();
                c44101be2.vDg.activityName = str;
                chm chm = c44101be2.vDg;
                if (str2 == null) {
                    str2 = "";
                }
                chm.wkp = str2;
                c44101be2.flags = flags;
                c44101be2.state = C45901a.CREATE.value;
                if (flags == 0) {
                    i = 0;
                } else if ((268435456 & flags) == 268435456) {
                    C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_NEW_TASK");
                    i = 100;
                    int i3 = c44101be2.flags;
                    C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, flagActivityNewTask flags = 0x" + Integer.toHexString(i3) + "/" + c44101be2.vDg.activityName);
                    if ((134217728 & i3) == 134217728) {
                        C4990ab.m7410d("ActivityStackWrapper", "activity stack push: FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_MULTIPLE_TASK");
                        i = 3;
                    } else if ((32768 & i3) == 32768) {
                        C4990ab.m7410d("ActivityStackWrapper", "activity stack push: FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK");
                        if (TextUtils.isEmpty(c44101be2.vDg.activityName)) {
                            i = 100;
                        } else {
                            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, flagNewTaskAndClearTask: " + c44101be2.vDg.activityName);
                            bqs = C27895c.bqs();
                            C20602g.m31836c(bqs);
                            C7583c a = C20602g.m31831a(bqs, c44101be2);
                            if (a == null) {
                                i = 101;
                            } else {
                                cgq = (cgq) a.get(0);
                                cgq.xfy.clear();
                                cgq.xfx = false;
                                cgq.xfy.addLast(c44101be2);
                                C27895c.m44357a(bqs);
                                i = 100;
                            }
                        }
                    } else if ((i3 & 67108864) == 67108864) {
                        i = 2;
                    } else {
                        boolean d = c20601e.lMx.mo35875d(c44101be2);
                        C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, push activityExisted = ".concat(String.valueOf(d)));
                        if (!d) {
                            i = 101;
                        }
                    }
                } else if ((flags & 67108864) == 67108864) {
                    C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_CLEAR_TOP");
                    i = 2;
                } else if ((536870912 & flags) == 536870912) {
                    C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_SINGLE_TOP");
                    i = 1;
                } else if ((WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT & flags) == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_REORDER_TO_FRONT");
                    if ((flags & 67108864) == 67108864) {
                        i = 2;
                    } else {
                        C4990ab.m7410d("ActivityStackWrapper", "activity stack push: FLAG_ACTIVITY_REORDER_TO_FRONT");
                        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, reorderMode: " + c44101be2.vDg.activityName);
                        C44102bf bqs2 = C27895c.bqs();
                        C20602g.m31836c(bqs2);
                        C7583c c = C20602g.m31837c(bqs2, c44101be2);
                        int intValue2 = ((Integer) c.get(0)).intValue();
                        intValue = ((Integer) c.get(1)).intValue();
                        if (intValue < 0) {
                            C20602g.m31834b(bqs2, c44101be2);
                        } else {
                            if (intValue2 == bqs2.vDi.size() - 1) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            if (i != 0) {
                                cgq = (cgq) bqs2.vDi.getLast();
                                if (cgq == null) {
                                    C20602g.m31834b(bqs2, c44101be2);
                                } else {
                                    C20602g.m31834b(bqs2, (C44101be) cgq.xfy.remove(intValue));
                                }
                            } else {
                                cgq = (cgq) bqs2.vDi.remove(intValue2);
                                bqs2.vDi.addLast(cgq);
                                C20602g.m31834b(bqs2, (C44101be) cgq.xfy.remove(intValue));
                            }
                        }
                        C27895c.m44357a(bqs2);
                        i = 100;
                    }
                } else if ((134217728 & flags) == 134217728 && (SQLiteGlobal.journalSizeLimit & flags) == SQLiteGlobal.journalSizeLimit) {
                    i = 3;
                    C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, Intent.FLAG_ACTIVITY_MULTIPLE_TASK");
                } else {
                    C4990ab.m7412e("ActivityStackWrapper", "activity stack push: activigy/flags = " + c44101be2.vDg.activityName + "/0x" + Integer.toHexString(flags));
                    i = 100;
                }
                switch (i) {
                    case 0:
                        C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, LAUNCH_MULTIPLE: " + c44101be2.vDg.activityName);
                        c44102bf = C27895c.bqs();
                        C20602g.m31836c(c44102bf);
                        if (C20602g.m31835b(c44102bf)) {
                            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, standardMode.1: " + c44101be2.vDg.activityName);
                            C20602g.m31832a(c44102bf, c44101be2, false);
                        } else {
                            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, standardMode.2: " + c44101be2.vDg.activityName);
                            C20602g.m31834b(c44102bf, c44101be2);
                        }
                        C27895c.m44357a(c44102bf);
                        AppMethodBeat.m2505o(73364);
                        return;
                    case 1:
                        C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, LAUNCH_SINGLE_TOP: " + c44101be2.vDg.activityName);
                        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleTopMode: " + c44101be2.vDg.activityName);
                        bqs = C27895c.bqs();
                        C20602g.m31836c(bqs);
                        if (C20602g.m31835b(bqs)) {
                            C20602g.m31832a(bqs, c44101be2, false);
                        } else {
                            C44101be c44101be3;
                            if (bqs == null) {
                                c44101be3 = null;
                            } else {
                                cgq = null;
                                if (!bqs.vDi.isEmpty()) {
                                    cgq = (cgq) bqs.vDi.getLast();
                                }
                                if (cgq == null) {
                                    c44101be3 = null;
                                } else if (cgq.xfy.isEmpty()) {
                                    c44101be3 = null;
                                } else {
                                    c44101be3 = (C44101be) cgq.xfy.getLast();
                                }
                            }
                            if (c44101be3 == null || !C45902h.m85094a(c44101be2.vDg, c44101be3.vDg)) {
                                C20602g.m31834b(bqs, c44101be2);
                            } else {
                                C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleTopMode = " + c44101be2.vDg.activityName);
                            }
                        }
                        C27895c.m44357a(bqs);
                        AppMethodBeat.m2505o(73364);
                        return;
                    case 2:
                        C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, LAUNCH_SINGLE_TASK: " + c44101be2.vDg.activityName);
                        C20602g c20602g = c20601e.lMx;
                        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: " + c44101be2.vDg.activityName);
                        C44102bf bqs3 = C27895c.bqs();
                        C20602g.m31836c(bqs3);
                        if (C20602g.m31835b(bqs3)) {
                            C20602g.m31832a(bqs3, c44101be2, false);
                        } else {
                            C7583c c2 = C20602g.m31837c(bqs3, c44101be2);
                            intValue = ((Integer) c2.get(0)).intValue();
                            flags = ((Integer) c2.get(1)).intValue();
                            if (flags < 0) {
                                C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: not in stack !");
                                C20602g.m31834b(bqs3, c44101be2);
                            } else {
                                if ((intValue == bqs3.vDi.size() + -1 ? 1 : 0) != 0) {
                                    if (flags == ((cgq) bqs3.vDi.getLast()).xfy.size() - 1) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: in top of stack !");
                                        i = 0;
                                    } else {
                                        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: in stack, but not top of stack !");
                                        i = 1;
                                    }
                                } else {
                                    C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: in stack, but not top of stack !");
                                    i = 2;
                                }
                                if (i == 1) {
                                    c20602g.mo35873a(bqs3, flags + 1);
                                }
                                if (i == 2) {
                                    c20602g.mo35874a(bqs3, intValue + 1, c44101be2);
                                    c20602g.mo35873a(bqs3, flags + 1);
                                }
                            }
                        }
                        C27895c.m44357a(bqs3);
                        AppMethodBeat.m2505o(73364);
                        return;
                    case 3:
                        C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, LAUNCH_SINGLE_INSTANCE: " + c44101be2.vDg.activityName);
                        C20602g.m31838c(c44101be2);
                        AppMethodBeat.m2505o(73364);
                        return;
                    case 100:
                        C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, FLAG_ACTIVITY_DO_NOTHING: " + c44101be2.vDg.activityName);
                        AppMethodBeat.m2505o(73364);
                        return;
                    case 101:
                        C4990ab.m7410d("ActivityStackWrapper", "habbyge-mali, FLAG_ACTIVITY_CREATE_TASKRECORD: " + c44101be2.vDg.activityName);
                        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, newTaskRecord: " + c44101be2.vDg.activityName + "/false");
                        c44102bf = C27895c.bqs();
                        C20602g.m31836c(c44102bf);
                        C20602g.m31832a(c44102bf, c44101be2, false);
                        C27895c.m44357a(c44102bf);
                        AppMethodBeat.m2505o(73364);
                        return;
                    default:
                        C4990ab.m7412e("ActivityStackWrapper", "habbyge-mali, operateStack.exception");
                        break;
                }
            }
            C4990ab.m7412e("ActivityStackWrapper", "habbyge-mali, push: aName=null, action = ".concat(String.valueOf(intent.getAction())));
            AppMethodBeat.m2505o(73364);
            return;
        }
        AppMethodBeat.m2505o(73364);
    }

    public static C44101be bqv() {
        AppMethodBeat.m2504i(73365);
        C44101be c44101be = (C44101be) C20602g.bqz().get(1);
        AppMethodBeat.m2505o(73365);
        return c44101be;
    }

    /* renamed from: a */
    public static void m31827a(String str, String str2, C45901a c45901a) {
        AppMethodBeat.m2504i(73366);
        C44102bf bqs = C27895c.bqs();
        if (bqs.vDj == null) {
            bqs.vDj = new C46526bd();
        }
        switch (C340761.lMu[c45901a.ordinal()]) {
            case 1:
                if (bqs.vDj.vDb == null) {
                    bqs.vDj.vDb = new C44101be();
                }
                if (bqs.vDj.vDb.vDg == null) {
                    bqs.vDj.vDb.vDg = new chm();
                }
                bqs.vDj.vDb.vDg.activityName = str;
                bqs.vDj.vDb.vDg.wkp = str2;
                bqs.vDj.vDb.state = C45901a.CREATE.value;
                break;
            case 2:
                if (bqs.vDj.vDc == null) {
                    bqs.vDj.vDc = new C44101be();
                }
                if (bqs.vDj.vDc.vDg == null) {
                    bqs.vDj.vDc.vDg = new chm();
                }
                bqs.vDj.vDc.vDg.activityName = str;
                bqs.vDj.vDc.vDg.wkp = str2;
                bqs.vDj.vDc.state = C45901a.RESUME.value;
                break;
            case 3:
                if (bqs.vDj.vDd == null) {
                    bqs.vDj.vDd = new C44101be();
                }
                if (bqs.vDj.vDd.vDg == null) {
                    bqs.vDj.vDd.vDg = new chm();
                }
                bqs.vDj.vDd.vDg.activityName = str;
                bqs.vDj.vDd.vDg.wkp = str2;
                bqs.vDj.vDd.state = C45901a.PAUSE.value;
                break;
            case 4:
                if (bqs.vDj.vDe == null) {
                    bqs.vDj.vDe = new C44101be();
                }
                if (bqs.vDj.vDe.vDg == null) {
                    bqs.vDj.vDe.vDg = new chm();
                }
                bqs.vDj.vDe.vDg.activityName = str;
                bqs.vDj.vDe.vDg.wkp = str2;
                bqs.vDj.vDe.state = C45901a.STOP.value;
                break;
        }
        C27895c.m44357a(bqs);
        AppMethodBeat.m2505o(73366);
    }

    public static C7583c<String, String> bqw() {
        AppMethodBeat.m2504i(73367);
        C44102bf bqs = C27895c.bqs();
        C7583c<String, String> F;
        if (bqs.vDj == null) {
            C7583c F2 = C5710a.m8574F(null, null);
            AppMethodBeat.m2505o(73367);
            return F2;
        } else if (bqs.vDj.vDb == null) {
            F = C5710a.m8574F(null, null);
            AppMethodBeat.m2505o(73367);
            return F;
        } else {
            String str = bqs.vDj.vDb.vDg.activityName;
            String str2 = bqs.vDj.vDb.vDg.wkp;
            C4990ab.m7416i("ActivityPointerWrapper", "habbyge-mali, getCreateActivity: ".concat(String.valueOf(str)));
            F = C5710a.m8574F(str, str2);
            AppMethodBeat.m2505o(73367);
            return F;
        }
    }

    public static C7583c<String, String> bqx() {
        AppMethodBeat.m2504i(73368);
        C44102bf bqs = C27895c.bqs();
        C7583c<String, String> F;
        if (bqs.vDj == null) {
            C7583c F2 = C5710a.m8574F(null, null);
            AppMethodBeat.m2505o(73368);
            return F2;
        } else if (bqs.vDj.vDc == null) {
            F = C5710a.m8574F(null, null);
            AppMethodBeat.m2505o(73368);
            return F;
        } else {
            String str = bqs.vDj.vDc.vDg.activityName;
            String str2 = bqs.vDj.vDc.vDg.wkp;
            C4990ab.m7416i("ActivityPointerWrapper", "habbyge-mali, getResumedActivity: ".concat(String.valueOf(str)));
            F = C5710a.m8574F(str, str2);
            AppMethodBeat.m2505o(73368);
            return F;
        }
    }

    public static C7583c<String, String> bqy() {
        AppMethodBeat.m2504i(73369);
        C44102bf bqs = C27895c.bqs();
        C7583c<String, String> F;
        if (bqs.vDj == null) {
            C7583c F2 = C5710a.m8574F(null, null);
            AppMethodBeat.m2505o(73369);
            return F2;
        } else if (bqs.vDj.vDd == null) {
            F = C5710a.m8574F(null, null);
            AppMethodBeat.m2505o(73369);
            return F;
        } else {
            String str = bqs.vDj.vDd.vDg.activityName;
            String str2 = bqs.vDj.vDd.vDg.wkp;
            C4990ab.m7416i("ActivityPointerWrapper", "habbyge-mali, getPausedActivity: ".concat(String.valueOf(str)));
            F = C5710a.m8574F(str, str2);
            AppMethodBeat.m2505o(73369);
            return F;
        }
    }

    /* renamed from: k */
    public static boolean m31828k(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(73370);
        C4990ab.m7410d("TokenWrapper", "habbyge-mali, TokenWrapper.equalWithHashCode: " + str + "=" + str2 + "/" + str3 + "=" + str4);
        if (str.equals(str3) && str2.equals(str4)) {
            AppMethodBeat.m2505o(73370);
            return true;
        }
        AppMethodBeat.m2505o(73370);
        return false;
    }
}
