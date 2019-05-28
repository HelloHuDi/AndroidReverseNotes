package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ac;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class a implements c, d {
    private static final float[] lOi = new float[]{0.0f, 0.3f, 0.45f, 0.55f, 0.67f, 0.75f, 0.85f, 1.0f};
    private static final float[] lOj = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.2f, 0.3f, 0.4f};
    private static final float[] lOk = new float[]{0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final int[] lOl = new int[]{15, 35, 83, 140, 209, 297, 417, 599, 926, 1720};
    private static final float[] lOm = new float[]{0.0f, 0.3f, 0.5f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static final float[] lOn = new float[]{0.0f, 0.3f, 0.45f, 0.55f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static final float[] lOo = new float[]{0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final int[] lOp = new int[]{2400, 7500, 13000, 21500, 41000, 65000, 116000, 215000, 455000};
    private static final float[] lOq = new float[]{0.0f, 0.35f, 0.5f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static a lOs;
    private SimpleDateFormat lOr = null;
    public b lOt;
    private ac lOu;
    private String[] lOv;
    private boolean lOw = false;
    int lOx = 0;

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(73578);
        aVar.brh();
        AppMethodBeat.o(73578);
    }

    static /* synthetic */ List d(a aVar) {
        AppMethodBeat.i(73579);
        List bri = aVar.bri();
        AppMethodBeat.o(73579);
        return bri;
    }

    static /* synthetic */ boolean p(long j, int i) {
        if (i <= 0 && j <= 5000) {
            return true;
        }
        return false;
    }

    public static a brg() {
        AppMethodBeat.i(73564);
        if (lOs == null) {
            lOs = new a();
        }
        a aVar = lOs;
        AppMethodBeat.o(73564);
        return aVar;
    }

    private void brh() {
        AppMethodBeat.i(73565);
        if (this.lOu == null) {
            AppMethodBeat.o(73565);
            return;
        }
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_ROOM_EXPT_INFO_STRING, this.lOu.Fj());
        ab.i("MicroMsg.ChatRoomExptService", "save expt info[%s]", this.lOu.Fk());
        AppMethodBeat.o(73565);
    }

    public final void v(Context context, Intent intent) {
        AppMethodBeat.i(73566);
        intent.setClass(context, RoomExptDebugUI.class);
        context.startActivity(intent);
        AppMethodBeat.o(73566);
    }

    public final void gS(final boolean z) {
        AppMethodBeat.i(73567);
        d.post(new Runnable() {
            public final void run() {
                long j;
                AppMethodBeat.i(73560);
                h hVar = h.pYm;
                if (z) {
                    j = 13;
                } else {
                    j = 12;
                }
                hVar.k(869, j, 1);
                AppMethodBeat.o(73560);
            }
        }, "click_room_mute_msg");
        AppMethodBeat.o(73567);
    }

    public final void aE(final String str, final boolean z) {
        AppMethodBeat.i(73568);
        ab.d("MicroMsg.ChatRoomExptService", "enter chat room [%s] isMute[%b]", str, Boolean.valueOf(z));
        if (this.lOx > 0) {
            this.lOx--;
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(73561);
                    a.aF(str, z);
                    AppMethodBeat.o(73561);
                }
            });
            AppMethodBeat.o(73568);
        } else if (this.lOv == null || this.lOv.length <= 0) {
            ab.d("MicroMsg.ChatRoomExptService", "roomname list is null");
            AppMethodBeat.o(73568);
        } else if (this.lOu == null) {
            AppMethodBeat.o(73568);
        } else if (this.lOu.cYn >= 5) {
            ab.d("MicroMsg.ChatRoomExptService", "exptInfo is finish [%d]", Long.valueOf(this.lOu.cYn));
            AppMethodBeat.o(73568);
        } else {
            g.RS().aa(new Runnable() {
                public final void run() {
                    boolean z;
                    int i = 0;
                    AppMethodBeat.i(73562);
                    com.tencent.mm.plugin.expt.a.a aVar = (com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class);
                    com.tencent.mm.plugin.expt.a.a.a aVar2 = com.tencent.mm.plugin.expt.a.a.a.mmchatroom_mute_abtest_flag;
                    if (a.this.lOu != null) {
                        z = a.this.lOu.cYq;
                    } else {
                        z = false;
                    }
                    if (aVar.a(aVar2, z)) {
                        int min = Math.min(a.this.lOv.length, 5);
                        while (i < min) {
                            if (str.equals(a.this.lOv[i])) {
                                a.aF(str, z);
                                a.this.lOu.cYn = 6;
                                a.this.lOu.eX("");
                                a.c(a.this);
                                AppMethodBeat.o(73562);
                                return;
                            }
                            i++;
                        }
                        AppMethodBeat.o(73562);
                        return;
                    }
                    AppMethodBeat.o(73562);
                }
            });
            AppMethodBeat.o(73568);
        }
    }

    public final void onAccountRelease() {
        this.lOu = null;
        this.lOt = null;
    }

    private static float a(float[] fArr, int[] iArr, long j) {
        AppMethodBeat.i(73571);
        if (fArr == null || fArr.length <= 0) {
            AppMethodBeat.o(73571);
            return 0.0f;
        } else if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(73571);
            return 0.0f;
        } else {
            int length = fArr.length - 1;
            int min = Math.min(fArr.length, iArr.length);
            int i = 0;
            while (i < min) {
                if (j < ((long) iArr[i])) {
                    break;
                }
                i++;
            }
            i = length;
            float f = fArr[i];
            AppMethodBeat.o(73571);
            return f;
        }
    }

    private static float c(float[] fArr, int i) {
        if (fArr == null || fArr.length <= 0) {
            return 0.0f;
        }
        if (i >= fArr.length) {
            return fArr[fArr.length - 1];
        }
        if (i <= 0) {
            return fArr[0];
        }
        return fArr[i];
    }

    private static float b(float f, int i, int i2) {
        float f2 = 0.0f;
        AppMethodBeat.i(73572);
        if (i <= 0) {
            AppMethodBeat.o(73572);
        } else {
            if ((i2 == 1 ? 1 : 0) != 0) {
                try {
                    f2 = (((f / ((float) i)) + (f / 7.0f)) / 2.0f) - c(lOj, i);
                } catch (Exception e) {
                    ab.e("MicroMsg.ChatRoomExptService", "calc finish score error[%s]", e.toString());
                }
            } else {
                f2 = c(lOi, i) + (((f / ((float) i)) + (f / 7.0f)) / 2.0f);
            }
            ab.d("MicroMsg.ChatRoomExptService", "calc finish score result[%f] day[%d] isMute[%d] score[%f]", Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f));
            AppMethodBeat.o(73572);
        }
        return f2;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x022a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<c> bri() {
        Throwable e;
        Cursor cursor;
        AppMethodBeat.i(73573);
        if (this.lOu == null) {
            ab.w("MicroMsg.ChatRoomExptService", "calc expt result but expt info is null");
            AppMethodBeat.o(73573);
            return null;
        } else if (this.lOu.cYn >= 3) {
            ab.i("MicroMsg.ChatRoomExptService", "user already enter mute chatroom and unmute room. exptFlag [%d]", Long.valueOf(this.lOu.cYn));
            AppMethodBeat.o(73573);
            return null;
        } else {
            boolean z;
            com.tencent.mm.plugin.expt.a.a aVar = (com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class);
            com.tencent.mm.plugin.expt.a.a.a aVar2 = com.tencent.mm.plugin.expt.a.a.a.mmchatroom_mute_abtest_flag;
            if (this.lOu != null) {
                z = this.lOu.cYq;
            } else {
                z = false;
            }
            if (!aVar.a(aVar2, z)) {
                ab.i("MicroMsg.ChatRoomExptService", "user no expt user");
                AppMethodBeat.o(73573);
                return null;
            } else if (this.lOv != null && this.lOv.length > 0) {
                ab.i("MicroMsg.ChatRoomExptService", "user already had expt result");
                AppMethodBeat.o(73573);
                return null;
            } else if (this.lOw) {
                ab.d("MicroMsg.ChatRoomExptService", "it is calc expt now");
                AppMethodBeat.o(73573);
                return null;
            } else {
                long yz = bo.yz();
                this.lOw = true;
                Cursor brm;
                try {
                    h.pYm.k(869, 21, 1);
                    brm = this.lOt.brm();
                    float f = 0.0f;
                    try {
                        float f2;
                        String string;
                        String string2;
                        float b;
                        ArrayList arrayList = new ArrayList();
                        if (brm != null) {
                            while (brm.moveToNext()) {
                                if (brm.getColumnCount() < 5) {
                                    ab.w("MicroMsg.ChatRoomExptService", "columnCount less than 5");
                                    f2 = f;
                                    break;
                                }
                                string = brm.getString(0);
                                string2 = brm.getString(1);
                                b = b(brm.getFloat(4), brm.getInt(3), brm.getInt(2));
                                c cVar = new c();
                                cVar.cuP = string;
                                cVar.nickname = string2;
                                cVar.lOE = b;
                                arrayList.add(cVar);
                                f += b;
                            }
                        }
                        f2 = f;
                        Collections.sort(arrayList);
                        f = 0.0f;
                        if (arrayList.size() > 0) {
                            f = f2 / ((float) arrayList.size());
                        }
                        b = Math.max(f, 0.0f);
                        com.tencent.mm.g.b.a.g gVar = new com.tencent.mm.g.b.a.g();
                        StringBuffer stringBuffer = null;
                        int min = Math.min(arrayList.size(), 5);
                        int i = 0;
                        while (i < min) {
                            c cVar2 = (c) arrayList.get(i);
                            if (cVar2.lOE > b) {
                                if (stringBuffer != null) {
                                    stringBuffer.append(";").append(cVar2.cuP);
                                } else {
                                    stringBuffer = new StringBuffer();
                                    stringBuffer.append(cVar2.cuP);
                                }
                                com.tencent.mm.g.b.a.g et = gVar.es(cVar2.cuP).et(cVar2.lOE);
                                et.cVd = (int) this.lOu.cYn;
                                et.ajK();
                            }
                            i++;
                            stringBuffer = stringBuffer;
                        }
                        if (stringBuffer != null) {
                            this.lOu.eX(stringBuffer.toString());
                            this.lOu.cYn = 4;
                            this.lOv = this.lOu.cYp.split(";");
                            h.pYm.k(869, 22, 1);
                        } else {
                            this.lOu.cYn = 5;
                            this.lOu.eX("");
                            this.lOv = null;
                            h.pYm.k(869, 23, 1);
                        }
                        brh();
                        this.lOw = false;
                        string = "MicroMsg.ChatRoomExptService";
                        string2 = "calcExptResult [%s] roomnameList [%s] cost[%d]";
                        Object[] objArr = new Object[3];
                        objArr[0] = this.lOu.Fk();
                        objArr[1] = this.lOv != null ? Arrays.toString(this.lOv) : BuildConfig.COMMAND;
                        objArr[2] = Long.valueOf(bo.az(yz));
                        ab.i(string, string2, objArr);
                        if (brm != null) {
                            brm.close();
                        }
                        AppMethodBeat.o(73573);
                        return arrayList;
                    } catch (Exception e2) {
                        e = e2;
                        cursor = brm;
                    } catch (Throwable th) {
                        e = th;
                        if (brm != null) {
                        }
                        AppMethodBeat.o(73573);
                        throw e;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                    try {
                        ab.printErrStackTrace("MicroMsg.ChatRoomExptService", e, "calcExptResult error", new Object[0]);
                        if (cursor != null) {
                            cursor.close();
                        }
                        ab.w("MicroMsg.ChatRoomExptService", "default return null?");
                        AppMethodBeat.o(73573);
                        return null;
                    } catch (Throwable th2) {
                        e = th2;
                        brm = cursor;
                        if (brm != null) {
                        }
                        AppMethodBeat.o(73573);
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    brm = null;
                    if (brm != null) {
                        brm.close();
                    }
                    AppMethodBeat.o(73573);
                    throw e;
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void brj() {
        AppMethodBeat.i(73574);
        try {
            this.lOt.bSd.delete("RoomMuteExpt", null, null);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e, "deleteAll", new Object[0]);
        }
        brk();
        AppMethodBeat.o(73574);
    }

    /* Access modifiers changed, original: protected|final */
    public final void brk() {
        AppMethodBeat.i(73575);
        if (this.lOu != null) {
            this.lOu = new ac();
            this.lOu.cYq = true;
            brh();
        }
        this.lOv = null;
        AppMethodBeat.o(73575);
    }

    /* Access modifiers changed, original: protected|final */
    public final String brl() {
        AppMethodBeat.i(73576);
        String Fk;
        if (this.lOu != null) {
            Fk = this.lOu.Fk();
            AppMethodBeat.o(73576);
            return Fk;
        }
        Fk = "";
        AppMethodBeat.o(73576);
        return Fk;
    }

    public final void a(String str, String str2, long j, int i, int i2, boolean z) {
        boolean z2;
        Object obj;
        AppMethodBeat.i(73569);
        com.tencent.mm.plugin.expt.a.a aVar = (com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class);
        com.tencent.mm.plugin.expt.a.a.a aVar2 = com.tencent.mm.plugin.expt.a.a.a.mmchatroom_mute_abtest_flag;
        if (this.lOu != null) {
            z2 = this.lOu.cYq;
        } else {
            z2 = false;
        }
        if (aVar.a(aVar2, z2)) {
            h.pYm.k(869, 1, 1);
            long j2 = this.lOu.cYn;
            if (j2 >= 3) {
                ab.d("MicroMsg.ChatRoomExptService", "room expt already finish");
                obj = null;
            } else {
                long j3;
                Object obj2 = j2 == 0 ? 1 : null;
                if (z) {
                    j3 = 1 | j2;
                } else {
                    j3 = 2 | j2;
                }
                this.lOu.cYn = j3;
                if (j3 >= 3) {
                    ab.d("MicroMsg.ChatRoomExptService", "user already enter mute room and unmute room, don't expt");
                    h.pYm.k(869, 2, 1);
                    brh();
                    obj = null;
                } else {
                    if (obj2 != null) {
                        if (this.lOu.cYo <= 0) {
                            this.lOu.Fq();
                        }
                        brh();
                    }
                    obj = 1;
                }
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            AppMethodBeat.o(73569);
            return;
        }
        final long j4 = j;
        final int i3 = i2;
        final String str3 = str;
        final int i4 = i;
        final boolean z3 = z;
        final String str4 = str2;
        g.RS().aa(new Runnable() {
            public final void run() {
                e eVar;
                boolean z;
                boolean c;
                AppMethodBeat.i(73563);
                long yz = bo.yz();
                long anT = bo.anT();
                if (a.this.lOu.cYo <= 0) {
                    a.this.lOu.Fq();
                    a.c(a.this);
                } else if (anT - a.this.lOu.cYo >= 604800) {
                    a.d(a.this);
                    AppMethodBeat.o(73563);
                    return;
                }
                String e = a.e(a.this);
                boolean p = a.p(j4, i3);
                e eh = a.this.lOt.eh(str3, e);
                String str = "MicroMsg.ChatRoomExptService";
                String str2 = "get db [%s %s] item [%s]";
                Object[] objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = e;
                objArr[2] = eh != null ? eh : BuildConfig.COMMAND;
                ab.i(str, str2, objArr);
                if (eh != null) {
                    eh.field_sendCount += i3;
                    eh.field_unReadCount += i4;
                    eh.field_disRedDotCount = (p ? 1 : 0) + eh.field_disRedDotCount;
                    eh.field_enterCount = (p ? 0 : 1) + eh.field_enterCount;
                    eh.field_stayTime += j4;
                    eh.field_isMute = z3 ? 1 : 0;
                    eVar = eh;
                    z = true;
                } else {
                    eh = new e();
                    eh.field_chatroom = str3;
                    eh.field_nickname = str4;
                    eh.field_daySec = e;
                    eh.field_sendCount = i3;
                    eh.field_isMute = z3 ? 1 : 0;
                    eh.field_unReadCount = i4;
                    eh.field_disRedDotCount = p ? 1 : 0;
                    eh.field_enterCount = p ? 0 : 1;
                    eh.field_stayTime = j4;
                    eVar = eh;
                    z = false;
                }
                a.a(eVar);
                if (z) {
                    c = a.this.lOt.c(eVar);
                } else {
                    c = a.this.lOt.b(eVar);
                }
                if (!c) {
                    h.pYm.k(869, 32, 1);
                }
                ab.i("MicroMsg.ChatRoomExptService", "noteroominfo isUpdate[%b] dbOpRet[%b] cost[%d] item[%s]", Boolean.valueOf(z), Boolean.valueOf(c), Long.valueOf(bo.az(yz)), eVar);
                AppMethodBeat.o(73563);
            }
        });
        AppMethodBeat.o(73569);
    }

    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(73570);
        if (this.lOu == null) {
            String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_ROOM_EXPT_INFO_STRING, (Object) "");
            if (bo.isNullOrNil(str)) {
                this.lOu = new ac();
                this.lOu.cYq = false;
            } else {
                this.lOu = new ac(str);
                if (!bo.isNullOrNil(this.lOu.cYp)) {
                    this.lOv = this.lOu.cYp.split(";");
                }
            }
            ab.i("MicroMsg.ChatRoomExptService", "load expt roomnameList[%s] info[%s]", this.lOv, this.lOu.Fk());
        }
        AppMethodBeat.o(73570);
    }

    static /* synthetic */ void aF(String str, boolean z) {
        String string;
        String string2;
        long j;
        AppMethodBeat.i(73577);
        if (z) {
            string = ah.getResources().getString(R.string.ajs);
            string2 = ah.getResources().getString(R.string.ajp);
        } else {
            string = ah.getResources().getString(R.string.ajq);
            string2 = ah.getResources().getString(R.string.ajr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<sysmsg type=\"chatroommuteexpt\">");
        stringBuffer.append("<chatroommuteexpt>");
        stringBuffer.append("<text><![CDATA[").append(string).append("]]></text>");
        stringBuffer.append("<link>");
        stringBuffer.append("<scene>chatroommuteexpt</scene>");
        stringBuffer.append("<text><![CDATA[").append(string2).append("]]></text>");
        stringBuffer.append("</link>");
        stringBuffer.append("</chatroommuteexpt>");
        stringBuffer.append("</sysmsg>");
        bi biVar = new bi();
        biVar.ju(str);
        biVar.hO(2);
        biVar.setType(10002);
        biVar.eJ(bf.aaa());
        biVar.setContent(stringBuffer.toString());
        bf.l(biVar);
        h hVar = h.pYm;
        if (z) {
            j = 11;
        } else {
            j = 10;
        }
        hVar.k(869, j, 1);
        AppMethodBeat.o(73577);
    }

    static /* synthetic */ String e(a aVar) {
        AppMethodBeat.i(73580);
        if (aVar.lOr == null) {
            aVar.lOr = new SimpleDateFormat("yyyyMMdd");
        }
        String format = aVar.lOr.format(new Date(bo.anU()));
        AppMethodBeat.o(73580);
        return format;
    }
}
