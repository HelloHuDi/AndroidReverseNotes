package com.tencent.p177mm.plugin.subapp.p1039c;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C37964e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.subapp.c.j */
public final class C13903j implements C1202f {
    private static int cqX = 0;
    Queue<String> cqQ = new LinkedList();
    Queue<String> cqR = new LinkedList();
    Map<String, C1446a> cqS = new HashMap();
    private boolean cqT = false;
    private boolean cqU = false;
    int cqV = 0;
    private long cqW = 0;
    C1446a cqZ = new C1446a();
    private C7564ap cra = new C7564ap(C9638aw.m17180RS().oAl.getLooper(), new C139053(), false);
    private boolean running = false;

    /* renamed from: com.tencent.mm.plugin.subapp.c.j$2 */
    class C139042 implements Runnable {
        C139042() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25308);
            long currentTimeMillis = System.currentTimeMillis() - C13903j.this.cqW;
            C4990ab.m7410d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + C13903j.this.running + " timeWait:" + currentTimeMillis + " sending:" + C13903j.this.cqU + " recving:" + C13903j.this.cqT);
            if (C13903j.this.running) {
                if (currentTimeMillis < 60000) {
                    AppMethodBeat.m2505o(25308);
                    return;
                }
                C4990ab.m7412e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + C13903j.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + C13903j.this.cqU + " recving:" + C13903j.this.cqT);
            }
            C13903j.this.running = true;
            C13903j.this.cqU = false;
            C13903j.this.cqV = 3;
            C13903j.this.cqT = false;
            C13903j.this.cqZ.evE = SystemClock.elapsedRealtime();
            C13903j.this.cra.mo16770ae(10, 10);
            AppMethodBeat.m2505o(25308);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.c.j$3 */
    class C139053 implements C5015a {
        C139053() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25309);
            C4990ab.m7410d("MicroMsg.VoiceRemindService", "onTimerExpired");
            try {
                C13903j.m22055h(C13903j.this);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VoiceRemindService", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(25309);
            return false;
        }
    }

    /* renamed from: Fc */
    static /* synthetic */ int m22045Fc() {
        int i = cqX;
        cqX = i + 1;
        return i;
    }

    /* renamed from: Fd */
    static /* synthetic */ int m22046Fd() {
        int i = cqX;
        cqX = i - 1;
        return i;
    }

    /* renamed from: i */
    static /* synthetic */ void m22056i(C13903j c13903j) {
        AppMethodBeat.m2504i(25315);
        c13903j.m22044Fb();
        AppMethodBeat.m2505o(25315);
    }

    public C13903j() {
        AppMethodBeat.m2504i(25310);
        C9638aw.m17182Rg().mo14539a((int) ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, (C1202f) this);
        AppMethodBeat.m2505o(25310);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(25311);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                int i;
                Object obj;
                AppMethodBeat.m2504i(25307);
                C13903j.m22045Fc();
                String str;
                if (c1207m.getType() == 128) {
                    C13903j.this.cqT = false;
                    str = ((C37964e) c1207m).fileName;
                    i = ((C37964e) c1207m).retCode;
                    obj = str;
                } else if (c1207m.getType() == ErrorCode.ERROR_GETSTRINGARRAY_JARFILE) {
                    C13903j.this.cqU = false;
                    str = ((C46290b) c1207m).fileName;
                    i = ((C46290b) c1207m).retCode;
                    String obj2 = str;
                } else {
                    C4990ab.m7412e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + c1207m.getType());
                    C13903j.m22046Fd();
                    AppMethodBeat.m2505o(25307);
                    return;
                }
                long j = 0;
                if (!(obj2 == null || C13903j.this.cqS.get(obj2) == null)) {
                    j = ((C1446a) C13903j.this.cqS.get(obj2)).mo4908Mr();
                    C13903j.this.cqS.remove(obj2);
                }
                C4990ab.m7410d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + c1207m.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + obj2 + " time:" + j);
                if (i == 3 && i != 0) {
                    C13903j.this.cqV = C13903j.this.cqV - 1;
                } else if (i != 0) {
                    C13903j.this.cqV = 0;
                }
                C4990ab.m7410d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + C13903j.cqX + " stop:" + C13903j.this.cqV + " running:" + C13903j.this.running + " recving:" + C13903j.this.cqT + " sending:" + C13903j.this.cqU);
                if (C13903j.this.cqV > 0) {
                    C13903j.m22055h(C13903j.this);
                } else if (!(C13903j.this.cqU || C13903j.this.cqT)) {
                    C13903j.m22056i(C13903j.this);
                }
                C13903j.m22046Fd();
                AppMethodBeat.m2505o(25307);
            }
        });
        AppMethodBeat.m2505o(25311);
    }

    /* renamed from: Fb */
    private void m22044Fb() {
        AppMethodBeat.m2504i(25312);
        this.cqS.clear();
        this.cqQ.clear();
        this.cqR.clear();
        this.cqU = false;
        this.cqT = false;
        this.running = false;
        C4990ab.m7410d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.cqZ.mo4908Mr());
        AppMethodBeat.m2505o(25312);
    }

    public final void run() {
        AppMethodBeat.m2504i(25313);
        C9638aw.m17180RS().mo10302aa(new C139042());
        AppMethodBeat.m2505o(25313);
    }

    /* renamed from: h */
    static /* synthetic */ void m22055h(C13903j c13903j) {
        AppMethodBeat.m2504i(25314);
        c13903j.cqW = System.currentTimeMillis();
        if ((!c13903j.cqT && c13903j.cqR.size() == 0) || (!c13903j.cqU && c13903j.cqQ.size() == 0)) {
            C43667k cDE = C41315d.cDE();
            Cursor a = cDE.bSd.mo10104a(("SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo") + " WHERE status<97  order by createtime", null, 2);
            List list = null;
            int i = 0;
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    C29385g c29385g = new C29385g();
                    c29385g.mo8995d(a);
                    list.add(c29385g);
                    i++;
                } while (a.moveToNext());
            }
            a.close();
            C4990ab.m7410d("MicroMsg.VoiceRemindStorage", "getUnfinishInfo resCount:".concat(String.valueOf(i)));
            if (list == null) {
                C4990ab.m7410d("MicroMsg.VoiceRemindService", "getNeedRunInfo null ");
            } else {
                C4990ab.m7410d("MicroMsg.VoiceRemindService", "getNeedRunInfo " + list.size());
            }
            if (!(list == null || list.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String mx = C5046bo.m7579mx(currentTimeMillis);
                for (C29385g c29385g2 : list) {
                    if (c13903j.cqS.containsKey(c29385g2.field_filename)) {
                        C4990ab.m7410d("MicroMsg.VoiceRemindService", "File is Already running:" + c29385g2.field_filename);
                    } else {
                        Object obj;
                        C4990ab.m7410d("MicroMsg.VoiceRemindService", "Get file:" + c29385g2.field_filename + " status:" + c29385g2.field_status + " user" + c29385g2.field_user + " human:" + c29385g2.field_human + " create:" + C5046bo.m7579mx(c29385g2.field_createtime) + " last:" + C5046bo.m7579mx(c29385g2.field_lastmodifytime) + " now:" + C5046bo.m7579mx(currentTimeMillis) + " " + (currentTimeMillis - c29385g2.field_lastmodifytime));
                        if (c29385g2.field_status == 5 || c29385g2.field_status == 6) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            if (currentTimeMillis - c29385g2.field_lastmodifytime > 80 && c29385g2.field_status == 5) {
                                C4990ab.m7412e("MicroMsg.VoiceRemindService", "time out file: " + c29385g2.field_filename + " last:" + C5046bo.m7579mx(c29385g2.field_lastmodifytime) + " now:" + mx);
                                C22335h.m34034um(c29385g2.field_filename);
                            } else if (currentTimeMillis - c29385g2.field_lastmodifytime > 300 && c29385g2.field_status == 6) {
                                C4990ab.m7412e("MicroMsg.VoiceRemindService", "time out file: " + c29385g2.field_filename + " last:" + C5046bo.m7579mx(c29385g2.field_lastmodifytime) + " now:" + mx);
                                C22335h.m34034um(c29385g2.field_filename);
                            } else if (c29385g2.field_filenowsize >= c29385g2.field_offset) {
                                C4990ab.m7410d("MicroMsg.VoiceRemindService", "file: " + c29385g2.field_filename + " stat:" + c29385g2.field_status + " now:" + c29385g2.field_filenowsize + " net:" + c29385g2.field_offset);
                            } else {
                                c13903j.cqR.offer(c29385g2.field_filename);
                                c13903j.cqS.put(c29385g2.field_filename, null);
                            }
                        }
                        if (c29385g2.ame()) {
                            C4990ab.m7410d("MicroMsg.VoiceRemindService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + c29385g2.field_lastmodifytime + "  info.getStatus() " + c29385g2.field_status + "  info.getCreateTime() " + c29385g2.field_createtime);
                            if (currentTimeMillis - c29385g2.field_lastmodifytime > 10 && (c29385g2.field_status == 2 || c29385g2.field_status == 1)) {
                                C4990ab.m7412e("MicroMsg.VoiceRemindService", "time out file: " + c29385g2.field_filename + " last:" + C5046bo.m7579mx(c29385g2.field_lastmodifytime) + " now:" + mx);
                                C22335h.m34034um(c29385g2.field_filename);
                            } else if (currentTimeMillis - c29385g2.field_createtime > 600 && c29385g2.field_status == 3) {
                                C4990ab.m7412e("MicroMsg.VoiceRemindService", "time out file: " + c29385g2.field_filename + " last:" + C5046bo.m7579mx(c29385g2.field_lastmodifytime) + " now:" + mx);
                                C22335h.m34034um(c29385g2.field_filename);
                            } else if (c29385g2.field_user.length() <= 0) {
                                C4990ab.m7412e("MicroMsg.VoiceRemindService", "Create a new ChatRoom? , set username first :" + c29385g2.field_filename);
                            } else {
                                c13903j.cqQ.offer(c29385g2.field_filename);
                                c13903j.cqS.put(c29385g2.field_filename, null);
                            }
                        }
                    }
                }
                C4990ab.m7410d("MicroMsg.VoiceRemindService", "GetNeedRun procing:" + c13903j.cqS.size() + " [recv:" + c13903j.cqR.size() + ",send:" + c13903j.cqQ.size() + "]");
                c13903j.cqR.size();
                c13903j.cqQ.size();
            }
        }
        if (c13903j.cqT || c13903j.cqR.size() != 0 || c13903j.cqU || c13903j.cqQ.size() != 0) {
            String str;
            if (!c13903j.cqT && c13903j.cqR.size() > 0) {
                str = (String) c13903j.cqR.poll();
                C4990ab.m7410d("MicroMsg.VoiceRemindService", "Start Recv :".concat(String.valueOf(str)));
                if (str != null) {
                    c13903j.cqS.put(str, new C1446a());
                    c13903j.cqT = true;
                    C4990ab.m7410d("MicroMsg.VoiceRemindService", "tiger download voice");
                }
            }
            if (!c13903j.cqU && c13903j.cqQ.size() > 0) {
                str = (String) c13903j.cqQ.poll();
                C4990ab.m7410d("MicroMsg.VoiceRemindService", "Start Send :".concat(String.valueOf(str)));
                if (str != null) {
                    c13903j.cqS.put(str, new C1446a());
                    c13903j.cqU = true;
                    C9638aw.m17182Rg().mo14541a(new C46290b(str), 0);
                }
            }
            AppMethodBeat.m2505o(25314);
            return;
        }
        c13903j.m22044Fb();
        C4990ab.m7410d("MicroMsg.VoiceRemindService", "No Data Any More , Stop Service");
        AppMethodBeat.m2505o(25314);
    }
}
