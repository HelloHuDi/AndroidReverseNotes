package com.tencent.mm.plugin.subapp.c;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class j implements f {
    private static int cqX = 0;
    Queue<String> cqQ = new LinkedList();
    Queue<String> cqR = new LinkedList();
    Map<String, a> cqS = new HashMap();
    private boolean cqT = false;
    private boolean cqU = false;
    int cqV = 0;
    private long cqW = 0;
    a cqZ = new a();
    private ap cra = new ap(aw.RS().oAl.getLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(25309);
            ab.d("MicroMsg.VoiceRemindService", "onTimerExpired");
            try {
                j.h(j.this);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VoiceRemindService", e, "", new Object[0]);
            }
            AppMethodBeat.o(25309);
            return false;
        }
    }, false);
    private boolean running = false;

    static /* synthetic */ int Fc() {
        int i = cqX;
        cqX = i + 1;
        return i;
    }

    static /* synthetic */ int Fd() {
        int i = cqX;
        cqX = i - 1;
        return i;
    }

    static /* synthetic */ void i(j jVar) {
        AppMethodBeat.i(25315);
        jVar.Fb();
        AppMethodBeat.o(25315);
    }

    public j() {
        AppMethodBeat.i(25310);
        aw.Rg().a((int) ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, (f) this);
        AppMethodBeat.o(25310);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final m mVar) {
        AppMethodBeat.i(25311);
        aw.RS().aa(new Runnable() {
            public final void run() {
                int i;
                Object obj;
                AppMethodBeat.i(25307);
                j.Fc();
                String str;
                if (mVar.getType() == 128) {
                    j.this.cqT = false;
                    str = ((e) mVar).fileName;
                    i = ((e) mVar).retCode;
                    obj = str;
                } else if (mVar.getType() == ErrorCode.ERROR_GETSTRINGARRAY_JARFILE) {
                    j.this.cqU = false;
                    str = ((b) mVar).fileName;
                    i = ((b) mVar).retCode;
                    String obj2 = str;
                } else {
                    ab.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + mVar.getType());
                    j.Fd();
                    AppMethodBeat.o(25307);
                    return;
                }
                long j = 0;
                if (!(obj2 == null || j.this.cqS.get(obj2) == null)) {
                    j = ((a) j.this.cqS.get(obj2)).Mr();
                    j.this.cqS.remove(obj2);
                }
                ab.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + mVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + obj2 + " time:" + j);
                if (i == 3 && i != 0) {
                    j.this.cqV = j.this.cqV - 1;
                } else if (i != 0) {
                    j.this.cqV = 0;
                }
                ab.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.cqX + " stop:" + j.this.cqV + " running:" + j.this.running + " recving:" + j.this.cqT + " sending:" + j.this.cqU);
                if (j.this.cqV > 0) {
                    j.h(j.this);
                } else if (!(j.this.cqU || j.this.cqT)) {
                    j.i(j.this);
                }
                j.Fd();
                AppMethodBeat.o(25307);
            }
        });
        AppMethodBeat.o(25311);
    }

    private void Fb() {
        AppMethodBeat.i(25312);
        this.cqS.clear();
        this.cqQ.clear();
        this.cqR.clear();
        this.cqU = false;
        this.cqT = false;
        this.running = false;
        ab.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.cqZ.Mr());
        AppMethodBeat.o(25312);
    }

    public final void run() {
        AppMethodBeat.i(25313);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(25308);
                long currentTimeMillis = System.currentTimeMillis() - j.this.cqW;
                ab.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.this.running + " timeWait:" + currentTimeMillis + " sending:" + j.this.cqU + " recving:" + j.this.cqT);
                if (j.this.running) {
                    if (currentTimeMillis < 60000) {
                        AppMethodBeat.o(25308);
                        return;
                    }
                    ab.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + j.this.cqU + " recving:" + j.this.cqT);
                }
                j.this.running = true;
                j.this.cqU = false;
                j.this.cqV = 3;
                j.this.cqT = false;
                j.this.cqZ.evE = SystemClock.elapsedRealtime();
                j.this.cra.ae(10, 10);
                AppMethodBeat.o(25308);
            }
        });
        AppMethodBeat.o(25313);
    }

    static /* synthetic */ void h(j jVar) {
        AppMethodBeat.i(25314);
        jVar.cqW = System.currentTimeMillis();
        if ((!jVar.cqT && jVar.cqR.size() == 0) || (!jVar.cqU && jVar.cqQ.size() == 0)) {
            k cDE = d.cDE();
            Cursor a = cDE.bSd.a(("SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo") + " WHERE status<97  order by createtime", null, 2);
            List list = null;
            int i = 0;
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(a);
                    list.add(gVar);
                    i++;
                } while (a.moveToNext());
            }
            a.close();
            ab.d("MicroMsg.VoiceRemindStorage", "getUnfinishInfo resCount:".concat(String.valueOf(i)));
            if (list == null) {
                ab.d("MicroMsg.VoiceRemindService", "getNeedRunInfo null ");
            } else {
                ab.d("MicroMsg.VoiceRemindService", "getNeedRunInfo " + list.size());
            }
            if (!(list == null || list.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String mx = bo.mx(currentTimeMillis);
                for (g gVar2 : list) {
                    if (jVar.cqS.containsKey(gVar2.field_filename)) {
                        ab.d("MicroMsg.VoiceRemindService", "File is Already running:" + gVar2.field_filename);
                    } else {
                        Object obj;
                        ab.d("MicroMsg.VoiceRemindService", "Get file:" + gVar2.field_filename + " status:" + gVar2.field_status + " user" + gVar2.field_user + " human:" + gVar2.field_human + " create:" + bo.mx(gVar2.field_createtime) + " last:" + bo.mx(gVar2.field_lastmodifytime) + " now:" + bo.mx(currentTimeMillis) + " " + (currentTimeMillis - gVar2.field_lastmodifytime));
                        if (gVar2.field_status == 5 || gVar2.field_status == 6) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 80 && gVar2.field_status == 5) {
                                ab.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bo.mx(gVar2.field_lastmodifytime) + " now:" + mx);
                                h.um(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_lastmodifytime > 300 && gVar2.field_status == 6) {
                                ab.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bo.mx(gVar2.field_lastmodifytime) + " now:" + mx);
                                h.um(gVar2.field_filename);
                            } else if (gVar2.field_filenowsize >= gVar2.field_offset) {
                                ab.d("MicroMsg.VoiceRemindService", "file: " + gVar2.field_filename + " stat:" + gVar2.field_status + " now:" + gVar2.field_filenowsize + " net:" + gVar2.field_offset);
                            } else {
                                jVar.cqR.offer(gVar2.field_filename);
                                jVar.cqS.put(gVar2.field_filename, null);
                            }
                        }
                        if (gVar2.ame()) {
                            ab.d("MicroMsg.VoiceRemindService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + gVar2.field_lastmodifytime + "  info.getStatus() " + gVar2.field_status + "  info.getCreateTime() " + gVar2.field_createtime);
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 10 && (gVar2.field_status == 2 || gVar2.field_status == 1)) {
                                ab.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bo.mx(gVar2.field_lastmodifytime) + " now:" + mx);
                                h.um(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_createtime > 600 && gVar2.field_status == 3) {
                                ab.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bo.mx(gVar2.field_lastmodifytime) + " now:" + mx);
                                h.um(gVar2.field_filename);
                            } else if (gVar2.field_user.length() <= 0) {
                                ab.e("MicroMsg.VoiceRemindService", "Create a new ChatRoom? , set username first :" + gVar2.field_filename);
                            } else {
                                jVar.cqQ.offer(gVar2.field_filename);
                                jVar.cqS.put(gVar2.field_filename, null);
                            }
                        }
                    }
                }
                ab.d("MicroMsg.VoiceRemindService", "GetNeedRun procing:" + jVar.cqS.size() + " [recv:" + jVar.cqR.size() + ",send:" + jVar.cqQ.size() + "]");
                jVar.cqR.size();
                jVar.cqQ.size();
            }
        }
        if (jVar.cqT || jVar.cqR.size() != 0 || jVar.cqU || jVar.cqQ.size() != 0) {
            String str;
            if (!jVar.cqT && jVar.cqR.size() > 0) {
                str = (String) jVar.cqR.poll();
                ab.d("MicroMsg.VoiceRemindService", "Start Recv :".concat(String.valueOf(str)));
                if (str != null) {
                    jVar.cqS.put(str, new a());
                    jVar.cqT = true;
                    ab.d("MicroMsg.VoiceRemindService", "tiger download voice");
                }
            }
            if (!jVar.cqU && jVar.cqQ.size() > 0) {
                str = (String) jVar.cqQ.poll();
                ab.d("MicroMsg.VoiceRemindService", "Start Send :".concat(String.valueOf(str)));
                if (str != null) {
                    jVar.cqS.put(str, new a());
                    jVar.cqU = true;
                    aw.Rg().a(new b(str), 0);
                }
            }
            AppMethodBeat.o(25314);
            return;
        }
        jVar.Fb();
        ab.d("MicroMsg.VoiceRemindService", "No Data Any More , Stop Service");
        AppMethodBeat.o(25314);
    }
}
