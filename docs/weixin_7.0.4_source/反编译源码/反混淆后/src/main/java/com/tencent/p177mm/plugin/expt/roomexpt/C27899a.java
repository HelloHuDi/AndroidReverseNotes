package com.tencent.p177mm.plugin.expt.roomexpt;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p230g.p232b.p233a.C26293g;
import com.tencent.p177mm.p230g.p232b.p233a.C9500ac;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.roomexpt.a */
public final class C27899a implements C1671c, C38991d {
    private static final float[] lOi = new float[]{0.0f, 0.3f, 0.45f, 0.55f, 0.67f, 0.75f, 0.85f, 1.0f};
    private static final float[] lOj = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.2f, 0.3f, 0.4f};
    private static final float[] lOk = new float[]{0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final int[] lOl = new int[]{15, 35, 83, 140, 209, 297, 417, 599, 926, 1720};
    private static final float[] lOm = new float[]{0.0f, 0.3f, 0.5f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static final float[] lOn = new float[]{0.0f, 0.3f, 0.45f, 0.55f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static final float[] lOo = new float[]{0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final int[] lOp = new int[]{2400, 7500, 13000, 21500, 41000, 65000, 116000, 215000, 455000};
    private static final float[] lOq = new float[]{0.0f, 0.35f, 0.5f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static C27899a lOs;
    private SimpleDateFormat lOr = null;
    public C11763b lOt;
    private C9500ac lOu;
    private String[] lOv;
    private boolean lOw = false;
    int lOx = 0;

    /* renamed from: c */
    static /* synthetic */ void m44370c(C27899a c27899a) {
        AppMethodBeat.m2504i(73578);
        c27899a.brh();
        AppMethodBeat.m2505o(73578);
    }

    /* renamed from: d */
    static /* synthetic */ List m44371d(C27899a c27899a) {
        AppMethodBeat.m2504i(73579);
        List bri = c27899a.bri();
        AppMethodBeat.m2505o(73579);
        return bri;
    }

    /* renamed from: p */
    static /* synthetic */ boolean m44374p(long j, int i) {
        if (i <= 0 && j <= 5000) {
            return true;
        }
        return false;
    }

    public static C27899a brg() {
        AppMethodBeat.m2504i(73564);
        if (lOs == null) {
            lOs = new C27899a();
        }
        C27899a c27899a = lOs;
        AppMethodBeat.m2505o(73564);
        return c27899a;
    }

    private void brh() {
        AppMethodBeat.m2504i(73565);
        if (this.lOu == null) {
            AppMethodBeat.m2505o(73565);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ROOM_EXPT_INFO_STRING, this.lOu.mo4982Fj());
        C4990ab.m7417i("MicroMsg.ChatRoomExptService", "save expt info[%s]", this.lOu.mo4983Fk());
        AppMethodBeat.m2505o(73565);
    }

    /* renamed from: v */
    public final void mo45804v(Context context, Intent intent) {
        AppMethodBeat.m2504i(73566);
        intent.setClass(context, RoomExptDebugUI.class);
        context.startActivity(intent);
        AppMethodBeat.m2505o(73566);
    }

    /* renamed from: gS */
    public final void mo45803gS(final boolean z) {
        AppMethodBeat.m2504i(73567);
        C7305d.post(new Runnable() {
            public final void run() {
                long j;
                AppMethodBeat.m2504i(73560);
                C7060h c7060h = C7060h.pYm;
                if (z) {
                    j = 13;
                } else {
                    j = 12;
                }
                c7060h.mo15419k(869, j, 1);
                AppMethodBeat.m2505o(73560);
            }
        }, "click_room_mute_msg");
        AppMethodBeat.m2505o(73567);
    }

    /* renamed from: aE */
    public final void mo45798aE(final String str, final boolean z) {
        AppMethodBeat.m2504i(73568);
        C4990ab.m7411d("MicroMsg.ChatRoomExptService", "enter chat room [%s] isMute[%b]", str, Boolean.valueOf(z));
        if (this.lOx > 0) {
            this.lOx--;
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(73561);
                    C27899a.m44366aF(str, z);
                    AppMethodBeat.m2505o(73561);
                }
            });
            AppMethodBeat.m2505o(73568);
        } else if (this.lOv == null || this.lOv.length <= 0) {
            C4990ab.m7410d("MicroMsg.ChatRoomExptService", "roomname list is null");
            AppMethodBeat.m2505o(73568);
        } else if (this.lOu == null) {
            AppMethodBeat.m2505o(73568);
        } else if (this.lOu.cYn >= 5) {
            C4990ab.m7411d("MicroMsg.ChatRoomExptService", "exptInfo is finish [%d]", Long.valueOf(this.lOu.cYn));
            AppMethodBeat.m2505o(73568);
        } else {
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    boolean z;
                    int i = 0;
                    AppMethodBeat.m2504i(73562);
                    C34069a c34069a = (C34069a) C1720g.m3528K(C34069a.class);
                    C11745a c11745a = C11745a.mmchatroom_mute_abtest_flag;
                    if (C27899a.this.lOu != null) {
                        z = C27899a.this.lOu.cYq;
                    } else {
                        z = false;
                    }
                    if (c34069a.mo54614a(c11745a, z)) {
                        int min = Math.min(C27899a.this.lOv.length, 5);
                        while (i < min) {
                            if (str.equals(C27899a.this.lOv[i])) {
                                C27899a.m44366aF(str, z);
                                C27899a.this.lOu.cYn = 6;
                                C27899a.this.lOu.mo20730eX("");
                                C27899a.m44370c(C27899a.this);
                                AppMethodBeat.m2505o(73562);
                                return;
                            }
                            i++;
                        }
                        AppMethodBeat.m2505o(73562);
                        return;
                    }
                    AppMethodBeat.m2505o(73562);
                }
            });
            AppMethodBeat.m2505o(73568);
        }
    }

    public final void onAccountRelease() {
        this.lOu = null;
        this.lOt = null;
    }

    /* renamed from: a */
    private static float m44363a(float[] fArr, int[] iArr, long j) {
        AppMethodBeat.m2504i(73571);
        if (fArr == null || fArr.length <= 0) {
            AppMethodBeat.m2505o(73571);
            return 0.0f;
        } else if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.m2505o(73571);
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
            AppMethodBeat.m2505o(73571);
            return f;
        }
    }

    /* renamed from: c */
    private static float m44369c(float[] fArr, int i) {
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

    /* renamed from: b */
    private static float m44367b(float f, int i, int i2) {
        float f2 = 0.0f;
        AppMethodBeat.m2504i(73572);
        if (i <= 0) {
            AppMethodBeat.m2505o(73572);
        } else {
            if ((i2 == 1 ? 1 : 0) != 0) {
                try {
                    f2 = (((f / ((float) i)) + (f / 7.0f)) / 2.0f) - C27899a.m44369c(lOj, i);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.ChatRoomExptService", "calc finish score error[%s]", e.toString());
                }
            } else {
                f2 = C27899a.m44369c(lOi, i) + (((f / ((float) i)) + (f / 7.0f)) / 2.0f);
            }
            C4990ab.m7411d("MicroMsg.ChatRoomExptService", "calc finish score result[%f] day[%d] isMute[%d] score[%f]", Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f));
            AppMethodBeat.m2505o(73572);
        }
        return f2;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x022a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<C11764c> bri() {
        Throwable e;
        Cursor cursor;
        AppMethodBeat.m2504i(73573);
        if (this.lOu == null) {
            C4990ab.m7420w("MicroMsg.ChatRoomExptService", "calc expt result but expt info is null");
            AppMethodBeat.m2505o(73573);
            return null;
        } else if (this.lOu.cYn >= 3) {
            C4990ab.m7417i("MicroMsg.ChatRoomExptService", "user already enter mute chatroom and unmute room. exptFlag [%d]", Long.valueOf(this.lOu.cYn));
            AppMethodBeat.m2505o(73573);
            return null;
        } else {
            boolean z;
            C34069a c34069a = (C34069a) C1720g.m3528K(C34069a.class);
            C11745a c11745a = C11745a.mmchatroom_mute_abtest_flag;
            if (this.lOu != null) {
                z = this.lOu.cYq;
            } else {
                z = false;
            }
            if (!c34069a.mo54614a(c11745a, z)) {
                C4990ab.m7416i("MicroMsg.ChatRoomExptService", "user no expt user");
                AppMethodBeat.m2505o(73573);
                return null;
            } else if (this.lOv != null && this.lOv.length > 0) {
                C4990ab.m7416i("MicroMsg.ChatRoomExptService", "user already had expt result");
                AppMethodBeat.m2505o(73573);
                return null;
            } else if (this.lOw) {
                C4990ab.m7410d("MicroMsg.ChatRoomExptService", "it is calc expt now");
                AppMethodBeat.m2505o(73573);
                return null;
            } else {
                long yz = C5046bo.m7588yz();
                this.lOw = true;
                Cursor brm;
                try {
                    C7060h.pYm.mo15419k(869, 21, 1);
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
                                    C4990ab.m7420w("MicroMsg.ChatRoomExptService", "columnCount less than 5");
                                    f2 = f;
                                    break;
                                }
                                string = brm.getString(0);
                                string2 = brm.getString(1);
                                b = C27899a.m44367b(brm.getFloat(4), brm.getInt(3), brm.getInt(2));
                                C11764c c11764c = new C11764c();
                                c11764c.cuP = string;
                                c11764c.nickname = string2;
                                c11764c.lOE = b;
                                arrayList.add(c11764c);
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
                        C26293g c26293g = new C26293g();
                        StringBuffer stringBuffer = null;
                        int min = Math.min(arrayList.size(), 5);
                        int i = 0;
                        while (i < min) {
                            C11764c c11764c2 = (C11764c) arrayList.get(i);
                            if (c11764c2.lOE > b) {
                                if (stringBuffer != null) {
                                    stringBuffer.append(";").append(c11764c2.cuP);
                                } else {
                                    stringBuffer = new StringBuffer();
                                    stringBuffer.append(c11764c2.cuP);
                                }
                                C26293g et = c26293g.mo44054es(c11764c2.cuP).mo44055et(c11764c2.lOE);
                                et.cVd = (int) this.lOu.cYn;
                                et.ajK();
                            }
                            i++;
                            stringBuffer = stringBuffer;
                        }
                        if (stringBuffer != null) {
                            this.lOu.mo20730eX(stringBuffer.toString());
                            this.lOu.cYn = 4;
                            this.lOv = this.lOu.cYp.split(";");
                            C7060h.pYm.mo15419k(869, 22, 1);
                        } else {
                            this.lOu.cYn = 5;
                            this.lOu.mo20730eX("");
                            this.lOv = null;
                            C7060h.pYm.mo15419k(869, 23, 1);
                        }
                        brh();
                        this.lOw = false;
                        string = "MicroMsg.ChatRoomExptService";
                        string2 = "calcExptResult [%s] roomnameList [%s] cost[%d]";
                        Object[] objArr = new Object[3];
                        objArr[0] = this.lOu.mo4983Fk();
                        objArr[1] = this.lOv != null ? Arrays.toString(this.lOv) : BuildConfig.COMMAND;
                        objArr[2] = Long.valueOf(C5046bo.m7525az(yz));
                        C4990ab.m7417i(string, string2, objArr);
                        if (brm != null) {
                            brm.close();
                        }
                        AppMethodBeat.m2505o(73573);
                        return arrayList;
                    } catch (Exception e2) {
                        e = e2;
                        cursor = brm;
                    } catch (Throwable th) {
                        e = th;
                        if (brm != null) {
                        }
                        AppMethodBeat.m2505o(73573);
                        throw e;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.ChatRoomExptService", e, "calcExptResult error", new Object[0]);
                        if (cursor != null) {
                            cursor.close();
                        }
                        C4990ab.m7420w("MicroMsg.ChatRoomExptService", "default return null?");
                        AppMethodBeat.m2505o(73573);
                        return null;
                    } catch (Throwable th2) {
                        e = th2;
                        brm = cursor;
                        if (brm != null) {
                        }
                        AppMethodBeat.m2505o(73573);
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    brm = null;
                    if (brm != null) {
                        brm.close();
                    }
                    AppMethodBeat.m2505o(73573);
                    throw e;
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void brj() {
        AppMethodBeat.m2504i(73574);
        try {
            this.lOt.bSd.delete("RoomMuteExpt", null, null);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e, "deleteAll", new Object[0]);
        }
        brk();
        AppMethodBeat.m2505o(73574);
    }

    /* Access modifiers changed, original: protected|final */
    public final void brk() {
        AppMethodBeat.m2504i(73575);
        if (this.lOu != null) {
            this.lOu = new C9500ac();
            this.lOu.cYq = true;
            brh();
        }
        this.lOv = null;
        AppMethodBeat.m2505o(73575);
    }

    /* Access modifiers changed, original: protected|final */
    public final String brl() {
        AppMethodBeat.m2504i(73576);
        String Fk;
        if (this.lOu != null) {
            Fk = this.lOu.mo4983Fk();
            AppMethodBeat.m2505o(73576);
            return Fk;
        }
        Fk = "";
        AppMethodBeat.m2505o(73576);
        return Fk;
    }

    /* renamed from: a */
    public final void mo45797a(String str, String str2, long j, int i, int i2, boolean z) {
        boolean z2;
        Object obj;
        AppMethodBeat.m2504i(73569);
        C34069a c34069a = (C34069a) C1720g.m3528K(C34069a.class);
        C11745a c11745a = C11745a.mmchatroom_mute_abtest_flag;
        if (this.lOu != null) {
            z2 = this.lOu.cYq;
        } else {
            z2 = false;
        }
        if (c34069a.mo54614a(c11745a, z2)) {
            C7060h.pYm.mo15419k(869, 1, 1);
            long j2 = this.lOu.cYn;
            if (j2 >= 3) {
                C4990ab.m7410d("MicroMsg.ChatRoomExptService", "room expt already finish");
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
                    C4990ab.m7410d("MicroMsg.ChatRoomExptService", "user already enter mute room and unmute room, don't expt");
                    C7060h.pYm.mo15419k(869, 2, 1);
                    brh();
                    obj = null;
                } else {
                    if (obj2 != null) {
                        if (this.lOu.cYo <= 0) {
                            this.lOu.mo20729Fq();
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
            AppMethodBeat.m2505o(73569);
            return;
        }
        final long j4 = j;
        final int i3 = i2;
        final String str3 = str;
        final int i4 = i;
        final boolean z3 = z;
        final String str4 = str2;
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                C38992e c38992e;
                boolean z;
                boolean c;
                AppMethodBeat.m2504i(73563);
                long yz = C5046bo.m7588yz();
                long anT = C5046bo.anT();
                if (C27899a.this.lOu.cYo <= 0) {
                    C27899a.this.lOu.mo20729Fq();
                    C27899a.m44370c(C27899a.this);
                } else if (anT - C27899a.this.lOu.cYo >= 604800) {
                    C27899a.m44371d(C27899a.this);
                    AppMethodBeat.m2505o(73563);
                    return;
                }
                String e = C27899a.m44372e(C27899a.this);
                boolean p = C27899a.m44374p(j4, i3);
                C38992e eh = C27899a.this.lOt.mo23556eh(str3, e);
                String str = "MicroMsg.ChatRoomExptService";
                String str2 = "get db [%s %s] item [%s]";
                Object[] objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = e;
                objArr[2] = eh != null ? eh : BuildConfig.COMMAND;
                C4990ab.m7417i(str, str2, objArr);
                if (eh != null) {
                    eh.field_sendCount += i3;
                    eh.field_unReadCount += i4;
                    eh.field_disRedDotCount = (p ? 1 : 0) + eh.field_disRedDotCount;
                    eh.field_enterCount = (p ? 0 : 1) + eh.field_enterCount;
                    eh.field_stayTime += j4;
                    eh.field_isMute = z3 ? 1 : 0;
                    c38992e = eh;
                    z = true;
                } else {
                    eh = new C38992e();
                    eh.field_chatroom = str3;
                    eh.field_nickname = str4;
                    eh.field_daySec = e;
                    eh.field_sendCount = i3;
                    eh.field_isMute = z3 ? 1 : 0;
                    eh.field_unReadCount = i4;
                    eh.field_disRedDotCount = p ? 1 : 0;
                    eh.field_enterCount = p ? 0 : 1;
                    eh.field_stayTime = j4;
                    c38992e = eh;
                    z = false;
                }
                C27899a.m44365a(c38992e);
                if (z) {
                    c = C27899a.this.lOt.mo23555c(c38992e);
                } else {
                    c = C27899a.this.lOt.mo23552b(c38992e);
                }
                if (!c) {
                    C7060h.pYm.mo15419k(869, 32, 1);
                }
                C4990ab.m7417i("MicroMsg.ChatRoomExptService", "noteroominfo isUpdate[%b] dbOpRet[%b] cost[%d] item[%s]", Boolean.valueOf(z), Boolean.valueOf(c), Long.valueOf(C5046bo.m7525az(yz)), c38992e);
                AppMethodBeat.m2505o(73563);
            }
        });
        AppMethodBeat.m2505o(73569);
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(73570);
        if (this.lOu == null) {
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ROOM_EXPT_INFO_STRING, (Object) "");
            if (C5046bo.isNullOrNil(str)) {
                this.lOu = new C9500ac();
                this.lOu.cYq = false;
            } else {
                this.lOu = new C9500ac(str);
                if (!C5046bo.isNullOrNil(this.lOu.cYp)) {
                    this.lOv = this.lOu.cYp.split(";");
                }
            }
            C4990ab.m7417i("MicroMsg.ChatRoomExptService", "load expt roomnameList[%s] info[%s]", this.lOv, this.lOu.mo4983Fk());
        }
        AppMethodBeat.m2505o(73570);
    }

    /* renamed from: aF */
    static /* synthetic */ void m44366aF(String str, boolean z) {
        String string;
        String string2;
        long j;
        AppMethodBeat.m2504i(73577);
        if (z) {
            string = C4996ah.getResources().getString(C25738R.string.ajs);
            string2 = C4996ah.getResources().getString(C25738R.string.ajp);
        } else {
            string = C4996ah.getResources().getString(C25738R.string.ajq);
            string2 = C4996ah.getResources().getString(C25738R.string.ajr);
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
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14794ju(str);
        c7620bi.mo14781hO(2);
        c7620bi.setType(10002);
        c7620bi.mo14775eJ(C1829bf.aaa());
        c7620bi.setContent(stringBuffer.toString());
        C1829bf.m3752l(c7620bi);
        C7060h c7060h = C7060h.pYm;
        if (z) {
            j = 11;
        } else {
            j = 10;
        }
        c7060h.mo15419k(869, j, 1);
        AppMethodBeat.m2505o(73577);
    }

    /* renamed from: e */
    static /* synthetic */ String m44372e(C27899a c27899a) {
        AppMethodBeat.m2504i(73580);
        if (c27899a.lOr == null) {
            c27899a.lOr = new SimpleDateFormat("yyyyMMdd");
        }
        String format = c27899a.lOr.format(new Date(C5046bo.anU()));
        AppMethodBeat.m2505o(73580);
        return format;
    }
}
