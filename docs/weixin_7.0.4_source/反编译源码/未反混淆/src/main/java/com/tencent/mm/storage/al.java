package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.be.b;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.xwalk.core.XWalkEnvironment;

public final class al extends n implements be {
    public static final String[] fnj = new String[]{j.a(com.tencent.mm.o.a.ccO, "rconversation"), j.a(com.tencent.mm.o.a.ccO, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )"};
    private final e bSd;
    private b xXr;
    private com.tencent.mm.plugin.messenger.foundation.a.e xXs;
    private a xXt = new a();
    private l<com.tencent.mm.storage.be.a, ak> xXu = new l<com.tencent.mm.storage.be.a, ak>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(1193);
            ((com.tencent.mm.storage.be.a) obj).a((ak) obj2, al.this);
            AppMethodBeat.o(1193);
        }
    };
    private l<com.tencent.mm.storage.be.a, ak> xXv = new l<com.tencent.mm.storage.be.a, ak>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(1194);
            ((com.tencent.mm.storage.be.a) obj).a((ak) obj2, al.this);
            AppMethodBeat.o(1194);
        }
    };

    static class a extends com.tencent.mm.ci.a<f> implements f {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(bi biVar, ak akVar, boolean z, c cVar) {
            AppMethodBeat.i(1197);
            final bi biVar2 = biVar;
            final ak akVar2 = akVar;
            final boolean z2 = z;
            final c cVar2 = cVar;
            a(new com.tencent.mm.ci.a.a<f>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(1195);
                    ((f) obj).a(biVar2, akVar2, z2, cVar2);
                    AppMethodBeat.o(1195);
                }
            });
            AppMethodBeat.o(1197);
        }

        public final void b(bi biVar, ak akVar, boolean z, c cVar) {
            AppMethodBeat.i(1198);
            final bi biVar2 = biVar;
            final ak akVar2 = akVar;
            final boolean z2 = z;
            final c cVar2 = cVar;
            a(new com.tencent.mm.ci.a.a<f>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(1196);
                    ((f) obj).b(biVar2, akVar2, z2, cVar2);
                    AppMethodBeat.o(1196);
                }
            });
            AppMethodBeat.o(1198);
        }
    }

    static {
        AppMethodBeat.i(1265);
        AppMethodBeat.o(1265);
    }

    public al(e eVar) {
        byte b;
        AppMethodBeat.i(1199);
        Assert.assertTrue(eVar instanceof h);
        Cursor a = eVar.a("PRAGMA table_info( rconversation)", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(a.getString(columnIndex))) {
                    b = (byte) 1;
                    break;
                }
            }
        }
        b = (byte) 0;
        a.close();
        List<String> a2 = j.a(com.tencent.mm.o.a.ccO, "rconversation", eVar);
        a2.addAll(j.a(com.tencent.mm.o.a.ccO, "rbottleconversation", eVar));
        for (String hY : a2) {
            eVar.hY("rconversation", hY);
        }
        if (b == (byte) 0) {
            eVar.hY("rconversation", "update rconversation set flag = conversationTime");
        }
        this.bSd = eVar;
        AppMethodBeat.o(1199);
    }

    private static String aoW(String str) {
        AppMethodBeat.i(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        ab.v("MicroMsg.ConversationStorage", "talker :".concat(String.valueOf(str)));
        String str2;
        if (ad.mR(str)) {
            str2 = "rbottleconversation";
            AppMethodBeat.o(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
            return str2;
        }
        str2 = "rconversation";
        AppMethodBeat.o(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        return str2;
    }

    public final void a(b bVar) {
        this.xXr = bVar;
    }

    public final b Cb() {
        return this.xXr;
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.e eVar) {
        this.xXs = eVar;
    }

    public final com.tencent.mm.vending.b.b a(f fVar) {
        AppMethodBeat.i(1201);
        com.tencent.mm.vending.b.b aD = this.xXt.aD(fVar);
        AppMethodBeat.o(1201);
        return aD;
    }

    public final void a(com.tencent.mm.storage.be.a aVar) {
        AppMethodBeat.i(1202);
        this.xXv.a(aVar, null);
        AppMethodBeat.o(1202);
    }

    public final void b(com.tencent.mm.storage.be.a aVar) {
        AppMethodBeat.i(1203);
        this.xXv.remove(aVar);
        AppMethodBeat.o(1203);
    }

    public final void c(com.tencent.mm.storage.be.a aVar) {
        AppMethodBeat.i(1204);
        this.xXu.a(aVar, null);
        AppMethodBeat.o(1204);
    }

    public final void d(com.tencent.mm.storage.be.a aVar) {
        AppMethodBeat.i(1205);
        this.xXu.remove(aVar);
        AppMethodBeat.o(1205);
    }

    /* JADX WARNING: Missing block: B:50:0x01a3, code skipped:
            if (r4 != null) goto L_0x01a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.tencent.mm.plugin.messenger.foundation.a.a.h hVar, c cVar) {
        AppMethodBeat.i(1206);
        if (cVar == null) {
            ab.f("MicroMsg.ConversationStorage", "null notifyInfo");
            AppMethodBeat.o(1206);
            return;
        }
        ak akVar;
        boolean z;
        int i;
        long j;
        String str;
        int i2;
        String str2 = cVar.talker;
        ak aoZ = aoZ(str2);
        bi Rb = hVar.Rb(str2);
        if (aoZ == null) {
            ab.i("MicroMsg.ConversationStorage", "create new cvs:%s", str2);
            aoZ = new ak(str2);
            if (ad.mR(str2)) {
                aoZ.hN(1);
            }
            akVar = aoZ;
            z = true;
        } else {
            akVar = aoZ;
            z = false;
        }
        this.xXt.a(Rb, akVar, z, cVar);
        ab.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d ", cVar.talker, cVar.oqJ, Integer.valueOf(cVar.oqL));
        if (!(Rb == null || Rb.field_msgId == 0)) {
            if (cVar.oqL == 1 && ((bi) cVar.oqK.get(0)).field_msgId != Rb.field_msgId) {
                ab.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", Long.valueOf(Rb.field_msgId), Long.valueOf(((bi) cVar.oqK.get(0)).field_msgId));
            }
            i = Rb.field_flag;
            j = akVar.field_lastSeq;
            long j2 = Rb.field_msgSeq;
            long j3 = (long) akVar.field_UnDeliverCount;
            ab.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
            if ((cVar.oqJ.equals("insert") && cVar.oqL > 0) || (cVar.oqJ.equals("update") && akVar.field_unReadCount + cVar.oqL >= 0)) {
                akVar.hM(akVar.field_unReadCount + cVar.oqL);
                if (j2 > j) {
                    ab.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", Long.valueOf(j2));
                    akVar.eF(j2);
                }
            } else if (cVar.oqN > 0 && j2 < j && ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().R(akVar.field_username, j).field_msgId == 0) {
                j3 = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Ru(akVar.field_username);
                ab.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
                akVar.eF(j2);
                if (j > j3) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yo().N(akVar.field_username, j3);
                }
            }
            if (Rb.bwt() && Rb.field_isSend == 1) {
                akVar.field_sightTime = Rb.field_createTime;
                akVar.duU = true;
            }
        }
        if (cVar.oqJ.equals("insert") && cVar.oqK.size() > 0 && t.kH(cVar.talker)) {
            str2 = r.Yz();
            Iterator it = cVar.oqK.iterator();
            while (it.hasNext()) {
                bi biVar = (bi) it.next();
                if (biVar.field_isSend != 1) {
                    if (!biVar.isText()) {
                        Object obj;
                        if (biVar.getType() == 503316529) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                    if (biVar.apB(str2)) {
                        akVar.hR(akVar.field_atCount + 1);
                    } else if (biVar.dtV()) {
                        akVar.hR(akVar.field_atCount + 4096);
                    }
                }
                Map z2 = br.z(biVar.field_content, "sysmsg");
                if (bi.aT(z2)) {
                    akVar.hU(akVar.field_UnReadInvite + 1);
                } else if (bi.aU(z2)) {
                    akVar.hU(akVar.field_UnReadInvite + 4096);
                }
            }
        }
        i = 0;
        if (cVar != null) {
            str = cVar.talker;
        } else {
            str = null;
        }
        if (!(cVar == null || cVar.oqJ == null || !cVar.oqJ.equals("delete"))) {
            if (cVar.oqN > 0) {
                i = cVar.oqN;
            }
            ab.i("MicroMsg.ConversationStorage", "notify delete count %d ", Integer.valueOf(cVar.oqN));
        }
        int i3 = i;
        if (cVar == null || cVar.oqJ == null || !cVar.oqJ.equals("insert")) {
            i2 = 0;
        } else {
            if (cVar.oqM > 0) {
                i = cVar.oqM;
            } else {
                i = 0;
            }
            ab.i("MicroMsg.ConversationStorage", "notify insert all count %d ", Integer.valueOf(cVar.oqM));
            i2 = i;
        }
        String str3 = "MicroMsg.ConversationStorage";
        String str4 = "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]";
        Object[] objArr = new Object[7];
        objArr[0] = bo.bc(str, "");
        if (Rb != null) {
            j = Rb.field_msgSeq;
        } else {
            j = -1;
        }
        objArr[1] = Long.valueOf(j);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(i3);
        objArr[5] = Long.valueOf(Thread.currentThread().getId());
        objArr[6] = akVar.field_parentRef;
        ab.i(str3, str4, objArr);
        if (z && i3 > 0 && i2 == 0) {
            ab.i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", str, akVar.field_username);
            AppMethodBeat.o(1206);
            return;
        }
        this.xXu.cF(akVar);
        this.xXu.doNotify();
        if (str == null) {
            ab.e("MicroMsg.ConversationStorage", "talker == null");
            AppMethodBeat.o(1206);
        } else if (str.equals(akVar.field_username)) {
            if (Rb == null || Rb.field_msgId == 0) {
                ab.i("MicroMsg.ConversationStorage", "update null conversation with talker ".concat(String.valueOf(str)));
                if (!z) {
                    akVar.dsI();
                    a(akVar, i3, i2);
                    a(akVar, str, true);
                } else if (((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Rp(str) > 0) {
                    if (Rb.bwt() || com.tencent.mm.sdk.a.b.dnQ()) {
                        akVar.eD(Rb.field_createTime);
                    } else {
                        akVar.eD(bo.anU());
                    }
                    a(akVar, i3, i2);
                    d(akVar);
                }
            } else {
                ab.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + Rb.field_msgId);
                akVar.ap(Rb);
                if (this.xXr != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    this.xXr.a(Rb, pString, pString2, pInt, akVar.jl(2097152));
                    ab.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", pString2.value);
                    akVar.jh(pString.value);
                    akVar.ji(pString2.value);
                    akVar.hP(pInt.value);
                } else {
                    str3 = ac(Rb.getType(), akVar.field_content);
                    akVar.jh(bo.nullAsNil(akVar.field_digest).concat(bo.isNullOrNil(str3) ? "" : " " + bo.nullAsNil(str3)));
                }
                akVar.jg(Integer.toString(Rb.getType()));
                if (this.xXs != null) {
                    this.xXs.a(Rb, akVar);
                }
                akVar.eE(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 1, Rb.field_createTime));
                if (z) {
                    ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
                    if (!(aoO == null || bo.isNullOrNil(aoO.field_username) || !aoO.Oe())) {
                        akVar.eE(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 2, 0));
                    }
                    a(akVar, i3, i2);
                    if (Rb.bwt() || com.tencent.mm.sdk.a.b.dnQ()) {
                        akVar.eD(Rb.field_createTime);
                    } else {
                        akVar.eD(bo.anU());
                    }
                    d(akVar);
                } else {
                    a(akVar, i3, i2);
                    a(akVar, str, true);
                }
            }
            this.xXv.cF(akVar);
            this.xXv.doNotify();
            this.xXt.b(Rb, akVar, z, cVar);
            AppMethodBeat.o(1206);
        } else {
            ab.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
            AppMethodBeat.o(1206);
        }
    }

    private static long c(ak akVar) {
        AppMethodBeat.i(1207);
        long a;
        if (akVar != null) {
            a = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, akVar.field_conversationTime);
            AppMethodBeat.o(1207);
            return a;
        }
        a = bo.anU() & 72057594037927935L;
        AppMethodBeat.o(1207);
        return a;
    }

    public final void aoX(String str) {
        AppMethodBeat.i(1208);
        ab.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", str, an.doR());
        if (this.bSd.delete(aoW(str), "username=?", new String[]{str}) != 0) {
            b(5, this, str);
        }
        AppMethodBeat.o(1208);
    }

    public final boolean dsJ() {
        AppMethodBeat.i(1209);
        boolean z = this.bSd.hY("rconversation", "delete from rconversation") || this.bSd.hY("rconversation", "delete from rbottleconversation");
        if (z) {
            b(5, this, "");
        }
        AppMethodBeat.o(1209);
        return z;
    }

    public final boolean aoY(String str) {
        AppMethodBeat.i(1210);
        ab.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, an.doR());
        boolean hY = this.bSd.hY("rconversation", "delete from " + aoW(str) + " where username like '%" + str + "'");
        if (hY) {
            b(5, this, str);
        }
        AppMethodBeat.o(1210);
        return hY;
    }

    public final ak aoZ(String str) {
        AppMethodBeat.i(1211);
        Cursor a = this.bSd.a(aoW(str), null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            ak akVar = new ak();
            akVar.d(a);
            a.close();
            AppMethodBeat.o(1211);
            return akVar;
        }
        ab.w("MicroMsg.ConversationStorage", "get null with username:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.o(1211);
        return null;
    }

    public final HashMap<String, Long> dsK() {
        AppMethodBeat.i(1213);
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = new HashMap();
        Cursor a = this.bSd.a("rconversation", new String[]{"username", "conversationTime"}, null, null, null, null, null, 2);
        if (a.moveToFirst()) {
            while (true) {
                int i;
                if (a == null) {
                    i = 0;
                } else if (a.isClosed() || a.isBeforeFirst() || a.isAfterLast()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    hashMap.put(a.getString(0), Long.valueOf(a.getLong(1)));
                    a.moveToNext();
                } else {
                    a.close();
                    ab.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(1213);
                    return hashMap;
                }
            }
        }
        a.close();
        AppMethodBeat.o(1213);
        return hashMap;
    }

    public final void dsL() {
        AppMethodBeat.i(1216);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.bSd.update("rconversation", contentValues, null, null);
        AppMethodBeat.o(1216);
    }

    public final void apa(String str) {
        AppMethodBeat.i(1217);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.bSd.update("rconversation", contentValues, "username=?", new String[]{str});
        AppMethodBeat.o(1217);
    }

    public final boolean apc(String str) {
        AppMethodBeat.i(1219);
        if (str.length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
            AppMethodBeat.o(1219);
            return false;
        }
        ab.d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", str);
        ak aoZ = aoZ(str);
        if (aoZ == null) {
            AppMethodBeat.o(1219);
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("unReadCount", Integer.valueOf(0));
        contentValues.put("unReadMuteCount", Integer.valueOf(0));
        contentValues.put("UnReadInvite", Integer.valueOf(0));
        contentValues.put("atCount", Integer.valueOf(0));
        contentValues.put("attrflag", Integer.valueOf(aoZ.field_attrflag & -1048577));
        int update = this.bSd.update(aoW(str), contentValues, "parentRef= ?", new String[]{bo.vA(str)});
        if (update > 0) {
            b(3, this, str);
        }
        if (update > 0) {
            AppMethodBeat.o(1219);
            return true;
        }
        AppMethodBeat.o(1219);
        return false;
    }

    public final boolean apd(String str) {
        AppMethodBeat.i(1220);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "update conversation failed");
            AppMethodBeat.o(1220);
            return false;
        }
        ak aoZ = aoZ(str);
        if (aoZ == null || (aoZ.field_unReadCount > 0 && str.equals(aoZ.field_username))) {
            AppMethodBeat.o(1220);
            return true;
        }
        boolean hY = this.bSd.hY("rconversation", "update " + aoW(str) + " set unReadCount = 1, atCount = 0, attrflag = " + (aoZ.field_attrflag | 1048576) + " where username = \"" + bo.vA(str) + "\"");
        if (hY) {
            b(3, this, str);
        }
        AppMethodBeat.o(1220);
        return hY;
    }

    public final boolean a(String str, int i, boolean z, int i2) {
        AppMethodBeat.i(1221);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1221);
            return false;
        } else if (aoZ(str) == null) {
            AppMethodBeat.o(1221);
            return true;
        } else {
            int i3;
            if (z) {
                i3 = i2 | i;
            } else {
                i3 = (i ^ -1) & i2;
            }
            if (i3 == i2) {
                AppMethodBeat.o(1221);
                return false;
            }
            boolean hY = this.bSd.hY("rconversation", "update " + aoW(str) + " set attrflag = " + i3 + " where username = \"" + bo.vA(str) + "\"");
            if (hY) {
                b(3, this, str);
            }
            AppMethodBeat.o(1221);
            return hY;
        }
    }

    public final int a(ak akVar, String str) {
        AppMethodBeat.i(139144);
        int a = a(akVar, str, true);
        AppMethodBeat.o(139144);
        return a;
    }

    public final int a(ak akVar, String str, boolean z) {
        AppMethodBeat.i(1223);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "update conversation failed");
            AppMethodBeat.o(1223);
            return 0;
        }
        if (z) {
            akVar.eE(c(akVar));
        }
        e(akVar);
        int update = this.bSd.update(aoW(str), akVar.Hl(), "username=?", new String[]{str});
        if (update != 0) {
            b(3, this, str);
        } else {
            ab.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", aoW(str));
        }
        AppMethodBeat.o(1223);
        return update;
    }

    private static void e(ak akVar) {
        AppMethodBeat.i(1224);
        if (akVar == null) {
            AppMethodBeat.o(1224);
            return;
        }
        if (akVar.field_unReadCount > 0) {
            ab.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
            if ((akVar.field_attrflag & 1048576) != 0) {
                akVar.hM(akVar.field_unReadCount - 1);
                akVar.hQ(akVar.field_attrflag & -1048577);
            }
        }
        AppMethodBeat.o(1224);
    }

    private long dsM() {
        AppMethodBeat.i(1225);
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        Cursor a = this.bSd.a("select max(conversationTime) as conversationTime from rconversation", null, 2);
        while (a.moveToNext()) {
            j = a.getLong(0);
        }
        a.close();
        ab.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(1225);
        return j;
    }

    public final boolean ape(String str) {
        boolean z = false;
        AppMethodBeat.i(1226);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
            AppMethodBeat.o(1226);
        } else {
            ak aoZ = aoZ(str);
            if (aoZ == null) {
                ab.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
                AppMethodBeat.o(1226);
            } else {
                z = this.bSd.hY("rconversation", "update " + aoW(aoZ.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aoZ, 1, dsM() + 1) + " where username = \"" + bo.vA(aoZ.field_username) + "\"");
                if (z) {
                    b(3, this, aoZ.field_username);
                }
                AppMethodBeat.o(1226);
            }
        }
        return z;
    }

    public final boolean apf(String str) {
        boolean z = false;
        AppMethodBeat.i(1227);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
            AppMethodBeat.o(1227);
        } else {
            ak akVar;
            if (aoZ(str) == null) {
                akVar = new ak(str);
                akVar.eD(System.currentTimeMillis());
                d(akVar);
                ab.i("MicroMsg.ConversationStorage", "setPlacedTop username = ".concat(String.valueOf(str)));
            }
            akVar = aoZ(str);
            if (akVar == null) {
                AppMethodBeat.o(1227);
            } else {
                z = this.bSd.hY("rconversation", "update " + aoW(akVar.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 2, 0) + " where username = \"" + bo.vA(akVar.field_username) + "\"");
                if (z) {
                    b(3, this, akVar.field_username);
                }
                AppMethodBeat.o(1227);
            }
        }
        return z;
    }

    public final boolean apg(String str) {
        AppMethodBeat.i(1228);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
            AppMethodBeat.o(1228);
            return false;
        }
        boolean f = f(aoZ(str));
        AppMethodBeat.o(1228);
        return f;
    }

    public final boolean f(ak akVar) {
        AppMethodBeat.i(1229);
        if (akVar == null) {
            ab.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
            AppMethodBeat.o(1229);
            return false;
        }
        boolean hY = this.bSd.hY("rconversation", "update " + aoW(akVar.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 3, akVar.field_conversationTime) + " where username = \"" + bo.vA(akVar.field_username) + "\"");
        if (hY) {
            b(3, this, akVar.field_username);
        }
        AppMethodBeat.o(1229);
        return hY;
    }

    public final boolean aph(String str) {
        AppMethodBeat.i(1230);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
            AppMethodBeat.o(1230);
            return false;
        }
        boolean g = g(aoZ(str));
        AppMethodBeat.o(1230);
        return g;
    }

    public final boolean g(ak akVar) {
        AppMethodBeat.i(1231);
        if (akVar == null) {
            ab.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
            AppMethodBeat.o(1231);
            return false;
        } else if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 4, 0) != 0) {
            AppMethodBeat.o(1231);
            return true;
        } else {
            AppMethodBeat.o(1231);
            return false;
        }
    }

    public final Cursor c(String str, List<String> list, String str2) {
        AppMethodBeat.i(1232);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from rconversation where ");
        if (com.tencent.mm.o.a.ewS == str2) {
            stringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bo.vA(str2)).append("' ");
        }
        stringBuilder.append(bo.nullAsNil(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc, conversationTime desc");
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.o(1232);
        return rawQuery;
    }

    public final List<String> dsN() {
        AppMethodBeat.i(1233);
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rconversation.username from rconversation,rcontact where ");
        stringBuilder.append("rconversation.username = rcontact.username");
        stringBuilder.append(bo.nullAsNil(bo.nullAsNil(t.fkP)));
        stringBuilder.append(" and ( verifyFlag & 8 ) = 0");
        stringBuilder.append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
        for (String append : t.fkY) {
            stringBuilder.append(" and rconversation.username != '").append(append).append("'");
        }
        stringBuilder.append(" order by sightTime desc, flag desc, conversationTime desc");
        Cursor a = this.bSd.a(stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                do {
                    arrayList.add(a.getString(0));
                } while (a.moveToNext());
            }
            a.close();
        }
        ab.d("MicroMsg.ConversationStorage", "user list:%s", arrayList);
        AppMethodBeat.o(1233);
        return arrayList;
    }

    public final Cursor a(String str, List<String> list, String str2, boolean z) {
        AppMethodBeat.i(1234);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where ");
        if (com.tencent.mm.o.a.ewS == str2) {
            stringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bo.vA(str2)).append("' ");
        }
        stringBuilder.append(bo.nullAsNil(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc");
        ab.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + stringBuilder.toString());
        Cursor a = this.bSd.a(stringBuilder.toString(), null, z ? 4 : 0);
        AppMethodBeat.o(1234);
        return a;
    }

    public final Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2) {
        AppMethodBeat.i(1235);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where (");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != arrayList.size() - 1) {
                stringBuilder.append("username = '" + ((String) arrayList.get(i)) + "' OR ");
            } else {
                stringBuilder.append("username = '" + ((String) arrayList.get(i)) + "'");
            }
        }
        stringBuilder.append(") and ");
        if (com.tencent.mm.o.a.ewS == str2) {
            stringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bo.vA(str2)).append("' ");
        }
        stringBuilder.append(bo.nullAsNil(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username != '").append(append).append("'");
            }
        }
        ab.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql %s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.o(1235);
        return rawQuery;
    }

    private static String z(String str, List<String> list) {
        AppMethodBeat.i(1236);
        String str2 = "";
        if (list != null && list.size() > 0) {
            str2 = str2 + str + " not in (";
            int i = 0;
            while (i < list.size()) {
                str2 = str2 + "\"" + bo.vA((String) list.get(i)) + "\"" + (i == list.size() + -1 ? "" : ",");
                i++;
            }
            str2 = str2 + ") ";
        }
        AppMethodBeat.o(1236);
        return str2;
    }

    public final Cursor a(String str, List<String> list, boolean z, String str2) {
        Object obj;
        AppMethodBeat.i(1237);
        String str3 = " ";
        String str4 = " ";
        if (str2 != null && str2.length() > 0) {
            str4 = " and rconversation.username = rcontact.username ";
        }
        str4 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + str3 + " where rconversation.username = rcontact.username" + str4 + bo.nullAsNil(str);
        str4 = str4 + z(" and rconversation.username", list);
        if (z) {
            str4 = str4 + " and ( verifyFlag & 8 ) = 0";
        }
        if (str2 != null && str2.length() > 0) {
            str4 = str4 + (" and ( rconversation.username like '%" + str2 + "%' or content like '%" + str2 + "%' or rcontact.nickname like '%" + str2 + "%' or rcontact.alias like '%" + str2 + "%' or rcontact.pyInitial like '%" + str2 + "%' or rcontact.quanPin like '%" + str2 + "%' or rcontact.conRemark like '%" + str2 + "%'  ) ");
        }
        if (str2 == null || str2.equals("")) {
            obj = str4 + " order by flag desc, conversationTime desc";
        } else {
            obj = str4 + " order by rconversation.username like \"%@chatroom\" asc";
        }
        ab.d("MicroMsg.ConversationStorage", "getSearchCursor sql ".concat(String.valueOf(obj)));
        Cursor rawQuery = this.bSd.rawQuery(obj, null);
        AppMethodBeat.o(1237);
        return rawQuery;
    }

    public final Cursor api(String str) {
        AppMethodBeat.i(1238);
        Cursor rawQuery = this.bSd.rawQuery("select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bo.nullAsNil(str) + " order by flag desc, conversationTime desc", null);
        AppMethodBeat.o(1238);
        return rawQuery;
    }

    public final void aF(LinkedList<String> linkedList) {
        AppMethodBeat.i(1239);
        ab.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", an.doR());
        if (linkedList.isEmpty()) {
            ab.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
            AppMethodBeat.o(1239);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = (String) linkedList.poll();
        stringBuilder.append("delete from rconversation where ");
        stringBuilder.append("username='").append(str).append('\'');
        while (!linkedList.isEmpty()) {
            stringBuilder.append(" or username='").append((String) linkedList.poll()).append('\'');
        }
        ab.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", stringBuilder.toString());
        this.bSd.hY("rconversation", stringBuilder.toString());
        AppMethodBeat.o(1239);
    }

    public final List<String> dsO() {
        AppMethodBeat.i(1240);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ab.i("MicroMsg.ConversationStorage", "getAllConvUserName sql %s", ("select username from rconversation" + z(" where username", arrayList)) + " order by flag desc, conversationTime desc");
        Cursor rawQuery = this.bSd.rawQuery(r0, null);
        int columnIndex = rawQuery.getColumnIndex("username");
        while (rawQuery.moveToNext()) {
            arrayList2.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        AppMethodBeat.o(1240);
        return arrayList2;
    }

    public final Cursor t(List<String> list, int i) {
        AppMethodBeat.i(1241);
        String str = "select username from rconversation";
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                str = str + (i3 > 0 ? " and " : " where ") + "username != \"" + bo.vA((String) list.get(i3)) + "\"";
                i2 = i3 + 1;
            } else {
                Cursor rawQuery = this.bSd.rawQuery(str + " order by flag desc, conversationTime desc limit 50 offset " + i, null);
                AppMethodBeat.o(1241);
                return rawQuery;
            }
        }
    }

    public final Cursor dsP() {
        AppMethodBeat.i(1242);
        Cursor rawQuery = this.bSd.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
        AppMethodBeat.o(1242);
        return rawQuery;
    }

    public final boolean MV(String str) {
        boolean z;
        AppMethodBeat.i(1243);
        Cursor a = this.bSd.a(aoW(str), null, "username=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            z = true;
        } else {
            z = false;
        }
        a.close();
        AppMethodBeat.o(1243);
        return z;
    }

    public final Cursor apj(String str) {
        AppMethodBeat.i(1244);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT username, unReadCount");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE (username LIKE '%@chatroom' ");
        stringBuilder.append(" or username LIKE '%@im.chatroom' ) ");
        stringBuilder.append(bo.nullAsNil(str));
        stringBuilder.append(" AND unReadCount > 0");
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.o(1244);
        return rawQuery;
    }

    public final Cursor ic(String str, String str2) {
        AppMethodBeat.i(1245);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount");
        stringBuilder.append(" from rconversation where username = '").append(str).append("' AND ( parentRef is ").append(com.tencent.mm.o.a.ewS).append(" or parentRef = '' ) ").append(bo.nullAsNil(str2));
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.o(1245);
        return rawQuery;
    }

    public final Cursor A(String str, List<String> list) {
        AppMethodBeat.i(1246);
        ab.i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", str, bo.dpG());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(unReadCount) from rconversation, rcontact");
        stringBuilder.append(" where rconversation.unReadCount > 0 AND (rconversation.parentRef is ").append(com.tencent.mm.o.a.ewS).append(" or parentRef = '' ) AND rconversation.username = rcontact.username").append(bo.nullAsNil(str)).append(" AND ( type & 512 ) == 0");
        stringBuilder.append(" AND rcontact.username != 'officialaccounts'");
        if (!(list == null || list.isEmpty())) {
            for (String append : list) {
                stringBuilder.append(" AND rconversation.username != '").append(append).append("'");
            }
        }
        ab.v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(append, null);
        AppMethodBeat.o(1246);
        return rawQuery;
    }

    public final Cursor apk(String str) {
        AppMethodBeat.i(1247);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(rconversation.username)");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(bo.nullAsNil(str));
        stringBuilder.append(" AND ( type & 512 ) == 0");
        stringBuilder.append(" AND ( attrflag & 2097152 ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.o.a.ewS).append(" or parentRef = '' ) ");
        stringBuilder.append(" AND rcontact.username != 'officialaccounts')");
        ab.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(r0, null);
        AppMethodBeat.o(1247);
        return rawQuery;
    }

    public final Cursor eo(String str, int i) {
        AppMethodBeat.i(1248);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(bo.nullAsNil(str));
        stringBuilder.append(" AND ( type & 512 ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.o.a.ewS).append(" or parentRef = '' ) ");
        stringBuilder.append(" AND rcontact.username != 'officialaccounts')");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
        if (i > 0) {
            stringBuilder.append(" LIMIT ").append(String.valueOf(i));
        }
        ab.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(r0, null);
        AppMethodBeat.o(1248);
        return rawQuery;
    }

    public final int dsQ() {
        int i = 0;
        AppMethodBeat.i(1249);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT SUM(rconversation.unReadCount)");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts'");
        ab.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", stringBuilder.toString());
        Cursor a = this.bSd.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        AppMethodBeat.o(1249);
        return i;
    }

    public final String dsR() {
        AppMethodBeat.i(1250);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts'");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
        stringBuilder.append(" LIMIT 1 ");
        ab.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", stringBuilder.toString());
        Cursor a = this.bSd.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                String string = a.getString(0);
                a.close();
                AppMethodBeat.o(1250);
                return string;
            }
            a.close();
        }
        AppMethodBeat.o(1250);
        return null;
    }

    public final int apl(String str) {
        int i = 0;
        AppMethodBeat.i(1251);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        ab.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", stringBuilder.toString());
        Cursor a = this.bSd.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        AppMethodBeat.o(1251);
        return i;
    }

    public final String apm(String str) {
        AppMethodBeat.i(1252);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        stringBuilder.append(" ORDER BY conversationTime DESC, conversationTime DESC ");
        stringBuilder.append(" LIMIT 1 ");
        ab.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", stringBuilder.toString());
        Cursor a = this.bSd.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                String string = a.getString(0);
                a.close();
                AppMethodBeat.o(1252);
                return string;
            }
            a.close();
        }
        AppMethodBeat.o(1252);
        return null;
    }

    public final Cursor dsS() {
        AppMethodBeat.i(1253);
        ab.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", "select count(*) from rbottleconversation where unReadCount > 0");
        Cursor rawQuery = this.bSd.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
        AppMethodBeat.o(1253);
        return rawQuery;
    }

    public final int nR(String str) {
        int i = 0;
        AppMethodBeat.i(1254);
        Cursor a = this.bSd.a("select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bo.nullAsNil(str), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(1254);
        return i;
    }

    public final ak dsT() {
        ak akVar;
        AppMethodBeat.i(1255);
        Cursor c = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().c(t.fkP, null, "officialaccounts");
        if (c != null) {
            if (c.getCount() <= 0 || !c.moveToFirst()) {
                akVar = null;
            } else {
                akVar = new ak();
                akVar.d(c);
            }
            c.close();
        } else {
            akVar = null;
        }
        AppMethodBeat.o(1255);
        return akVar;
    }

    public final ak apn(String str) {
        ak akVar;
        AppMethodBeat.i(1256);
        Cursor c = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().c(t.fkP, null, str);
        if (c != null) {
            if (c.getCount() <= 0 || !c.moveToFirst()) {
                akVar = null;
            } else {
                akVar = new ak();
                akVar.d(c);
            }
            c.close();
        } else {
            akVar = null;
        }
        AppMethodBeat.o(1256);
        return akVar;
    }

    public final void c(String[] strArr, String str) {
        int i;
        AppMethodBeat.i(1257);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '").append(bo.nullAsNil(str)).append("' where 1 != 1 ");
        for (i = 0; i <= 0; i++) {
            stringBuilder.append(" or username = '").append(strArr[0]).append("'");
        }
        ab.d("MicroMsg.ConversationStorage", "update sql: %s", stringBuilder.toString());
        if (this.bSd.hY("rconversation", stringBuilder.toString())) {
            for (i = 0; i <= 0; i++) {
                b(3, this, strArr[0]);
            }
        }
        AppMethodBeat.o(1257);
    }

    public final int apo(String str) {
        int i = 0;
        AppMethodBeat.i(1258);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(atCount) from rconversation");
        stringBuilder.append(" where unReadCount > 0");
        if (!bo.isNullOrNil(str)) {
            stringBuilder.append(" and username = '").append(str).append("'");
        }
        ab.d("MicroMsg.ConversationStorage", "query sql: %s", stringBuilder.toString());
        Cursor a = this.bSd.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        AppMethodBeat.o(1258);
        return i;
    }

    public final String ac(int i, String str) {
        AppMethodBeat.i(1259);
        String str2 = null;
        if (!bo.isNullOrNil(str)) {
            switch (i) {
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    Map z = br.z(str, "msg");
                    if (z != null) {
                        str2 = (String) z.get(".msg.appmsg.title");
                        ab.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", str2);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(1259);
        return str2;
    }

    public final boolean apK() {
        AppMethodBeat.i(1260);
        if (this.bSd == null || this.bSd.dpU()) {
            String str = "MicroMsg.ConversationStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.bSd == null ? BuildConfig.COMMAND : Boolean.valueOf(this.bSd.dpU());
            ab.w(str, str2, objArr);
            AppMethodBeat.o(1260);
            return false;
        }
        AppMethodBeat.o(1260);
        return true;
    }

    public final void app(String str) {
        AppMethodBeat.i(1261);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bo.vA(str) + "\"");
        ab.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", stringBuilder.toString());
        if (this.bSd.hY("rconversation", stringBuilder.toString())) {
            b(3, this, str);
        }
        AppMethodBeat.o(1261);
    }

    public final void apq(String str) {
        AppMethodBeat.i(1262);
        ab.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", str, Integer.valueOf(this.bSd.delete(aoW(str), "username=? or parentRef =?", new String[]{str, str})));
        if (this.bSd.delete(aoW(str), "username=? or parentRef =?", new String[]{str, str}) != 0) {
            b(5, this, str);
        }
        AppMethodBeat.o(1262);
    }

    public final int apr(String str) {
        int i = -1;
        AppMethodBeat.i(1263);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(1263);
        } else {
            Cursor a = this.bSd.a("select msgCount from rconversation where username=" + h.escape(str), null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(1263);
        }
        return i;
    }

    public final Cursor dsU() {
        AppMethodBeat.i(1264);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username, ");
        stringBuilder.append("rconversation.unReadCount");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND ( parentRef is ").append(com.tencent.mm.o.a.ewS).append(" or parentRef = '' ) ");
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.o(1264);
        return rawQuery;
    }

    public final void aq(bi biVar) {
        AppMethodBeat.i(1212);
        String str = biVar.field_talker;
        boolean z = false;
        ak aoZ = aoZ(str);
        if (aoZ == null || aoZ.field_conversationTime <= biVar.field_createTime || aoZ.field_conversationTime == Long.MAX_VALUE) {
            if (aoZ == null) {
                aoZ = new ak(str);
                z = true;
            }
            aoZ.hO(biVar.field_isSend);
            aoZ.hM(aoZ.field_unReadCount);
            aoZ.ap(biVar);
            aoZ.jg(Integer.toString(biVar.getType()));
            aoZ.eE((aoZ.field_flag & 4611686018427387904L) | (biVar.field_createTime & 72057594037927935L));
            if (z) {
                d(aoZ);
                AppMethodBeat.o(1212);
                return;
            }
            a(aoZ, str, true);
            AppMethodBeat.o(1212);
            return;
        }
        ab.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        AppMethodBeat.o(1212);
    }

    public final long d(ak akVar) {
        AppMethodBeat.i(1214);
        String nullAsNil = bo.nullAsNil(akVar.field_username);
        if (nullAsNil.length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
            AppMethodBeat.o(1214);
            return -1;
        }
        akVar.eE(c(akVar));
        e(akVar);
        long insert = this.bSd.insert(aoW(nullAsNil), null, akVar.Hl());
        if (insert != -1) {
            b(2, this, akVar.field_username);
        } else {
            ab.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", aoW(nullAsNil));
        }
        AppMethodBeat.o(1214);
        return insert;
    }

    public final void a(ak akVar, int i, int i2) {
        AppMethodBeat.i(1215);
        if (!bf.oB(akVar.field_username)) {
            AppMethodBeat.o(1215);
        } else if (bo.nullAsNil(akVar.field_username).length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
            AppMethodBeat.o(1215);
        } else {
            if (akVar.field_msgCount == 0) {
                akVar.hL(bf.oA(akVar.field_username));
                ab.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
            } else if (i > 0) {
                akVar.hL(akVar.field_msgCount - i);
                if (akVar.field_msgCount < 0) {
                    ab.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
                    akVar.hL(0);
                }
            } else if (i2 > 0) {
                akVar.hL(akVar.field_msgCount + i2);
            }
            ab.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(akVar.field_msgCount), akVar.field_username, Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(1215);
        }
    }

    public final boolean apb(String str) {
        AppMethodBeat.i(1218);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.ConversationStorage", "update conversation failed");
        } else {
            ab.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", str);
            ak aoZ = aoZ(str);
            if (aoZ == null) {
                AppMethodBeat.o(1218);
                return true;
            } else if (aoZ.field_unReadCount == 0 && aoZ.field_unReadMuteCount == 0 && str.equals(aoZ.field_username)) {
                a(str, 1048576, false, aoZ.field_attrflag);
                ContentValues contentValues = new ContentValues();
                contentValues.put("UnReadInvite", Integer.valueOf(0));
                contentValues.put("atCount", Integer.valueOf(0));
                if (this.bSd.update(aoW(str), contentValues, "username= ?", new String[]{bo.vA(str)}) > 0) {
                    b(3, this, str);
                }
                AppMethodBeat.o(1218);
                return true;
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("unReadCount", Integer.valueOf(0));
                contentValues2.put("unReadMuteCount", Integer.valueOf(0));
                contentValues2.put("UnReadInvite", Integer.valueOf(0));
                contentValues2.put("atCount", Integer.valueOf(0));
                contentValues2.put("attrflag", Integer.valueOf(aoZ.field_attrflag & -1048577));
                int update = this.bSd.update(aoW(str), contentValues2, "username= ?", new String[]{bo.vA(str)});
                if (update > 0) {
                    b(3, this, str);
                }
                if (update > 0) {
                    AppMethodBeat.o(1218);
                    return true;
                }
            }
        }
        AppMethodBeat.o(1218);
        return false;
    }
}
