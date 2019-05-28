package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.p761o.C7487a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3469e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3470f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C43298a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7310be.C5132a;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.storage.al */
public final class C15433al extends C7298n implements C7310be {
    public static final String[] fnj = new String[]{C7563j.m13217a(C7487a.ccO, "rconversation"), C7563j.m13217a(C7487a.ccO, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )"};
    private final C4927e bSd;
    private C5133b xXr;
    private C3469e xXs;
    private C7565a xXt = new C7565a();
    private C4934l<C5132a, C7617ak> xXu = new C154341();
    private C4934l<C5132a, C7617ak> xXv = new C154322();

    /* renamed from: com.tencent.mm.storage.al$a */
    static class C7565a extends C6454a<C3470f> implements C3470f {
        private C7565a() {
        }

        /* synthetic */ C7565a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo7929a(C7620bi c7620bi, C7617ak c7617ak, boolean z, C3460c c3460c) {
            AppMethodBeat.m2504i(1197);
            final C7620bi c7620bi2 = c7620bi;
            final C7617ak c7617ak2 = c7617ak;
            final boolean z2 = z;
            final C3460c c3460c2 = c3460c;
            mo14669a(new C1387a<C3470f>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(1195);
                    ((C3470f) obj).mo7929a(c7620bi2, c7617ak2, z2, c3460c2);
                    AppMethodBeat.m2505o(1195);
                }
            });
            AppMethodBeat.m2505o(1197);
        }

        /* renamed from: b */
        public final void mo7930b(C7620bi c7620bi, C7617ak c7617ak, boolean z, C3460c c3460c) {
            AppMethodBeat.m2504i(1198);
            final C7620bi c7620bi2 = c7620bi;
            final C7617ak c7617ak2 = c7617ak;
            final boolean z2 = z;
            final C3460c c3460c2 = c3460c;
            mo14669a(new C1387a<C3470f>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(1196);
                    ((C3470f) obj).mo7930b(c7620bi2, c7617ak2, z2, c3460c2);
                    AppMethodBeat.m2505o(1196);
                }
            });
            AppMethodBeat.m2505o(1198);
        }
    }

    /* renamed from: com.tencent.mm.storage.al$2 */
    class C154322 extends C4934l<C5132a, C7617ak> {
        C154322() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(1194);
            ((C5132a) obj).mo10531a((C7617ak) obj2, C15433al.this);
            AppMethodBeat.m2505o(1194);
        }
    }

    /* renamed from: com.tencent.mm.storage.al$1 */
    class C154341 extends C4934l<C5132a, C7617ak> {
        C154341() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(1193);
            ((C5132a) obj).mo10531a((C7617ak) obj2, C15433al.this);
            AppMethodBeat.m2505o(1193);
        }
    }

    static {
        AppMethodBeat.m2504i(1265);
        AppMethodBeat.m2505o(1265);
    }

    public C15433al(C4927e c4927e) {
        byte b;
        AppMethodBeat.m2504i(1199);
        Assert.assertTrue(c4927e instanceof C7480h);
        Cursor a = c4927e.mo10104a("PRAGMA table_info( rconversation)", null, 2);
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
        List<String> a2 = C7563j.m13219a(C7487a.ccO, "rconversation", c4927e);
        a2.addAll(C7563j.m13219a(C7487a.ccO, "rbottleconversation", c4927e));
        for (String hY : a2) {
            c4927e.mo10108hY("rconversation", hY);
        }
        if (b == (byte) 0) {
            c4927e.mo10108hY("rconversation", "update rconversation set flag = conversationTime");
        }
        this.bSd = c4927e;
        AppMethodBeat.m2505o(1199);
    }

    private static String aoW(String str) {
        AppMethodBeat.m2504i(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        C4990ab.m7418v("MicroMsg.ConversationStorage", "talker :".concat(String.valueOf(str)));
        String str2;
        if (C7616ad.m13548mR(str)) {
            str2 = "rbottleconversation";
            AppMethodBeat.m2505o(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
            return str2;
        }
        str2 = "rconversation";
        AppMethodBeat.m2505o(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        return str2;
    }

    /* renamed from: a */
    public final void mo15776a(C5133b c5133b) {
        this.xXr = c5133b;
    }

    /* renamed from: Cb */
    public final C5133b mo15765Cb() {
        return this.xXr;
    }

    /* renamed from: a */
    public final void mo15773a(C3469e c3469e) {
        this.xXs = c3469e;
    }

    /* renamed from: a */
    public final C7358b mo15772a(C3470f c3470f) {
        AppMethodBeat.m2504i(1201);
        C7358b aD = this.xXt.mo14670aD(c3470f);
        AppMethodBeat.m2505o(1201);
        return aD;
    }

    /* renamed from: a */
    public final void mo15775a(C5132a c5132a) {
        AppMethodBeat.m2504i(1202);
        this.xXv.mo10125a(c5132a, null);
        AppMethodBeat.m2505o(1202);
    }

    /* renamed from: b */
    public final void mo15803b(C5132a c5132a) {
        AppMethodBeat.m2504i(1203);
        this.xXv.remove(c5132a);
        AppMethodBeat.m2505o(1203);
    }

    /* renamed from: c */
    public final void mo15805c(C5132a c5132a) {
        AppMethodBeat.m2504i(1204);
        this.xXu.mo10125a(c5132a, null);
        AppMethodBeat.m2505o(1204);
    }

    /* renamed from: d */
    public final void mo15808d(C5132a c5132a) {
        AppMethodBeat.m2504i(1205);
        this.xXu.remove(c5132a);
        AppMethodBeat.m2505o(1205);
    }

    /* JADX WARNING: Missing block: B:50:0x01a3, code skipped:
            if (r4 != null) goto L_0x01a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final void mo15802b(C6977h c6977h, C3460c c3460c) {
        AppMethodBeat.m2504i(1206);
        if (c3460c == null) {
            C4990ab.m7414f("MicroMsg.ConversationStorage", "null notifyInfo");
            AppMethodBeat.m2505o(1206);
            return;
        }
        C7617ak c7617ak;
        boolean z;
        int i;
        long j;
        String str;
        int i2;
        String str2 = c3460c.talker;
        C7617ak aoZ = aoZ(str2);
        C7620bi Rb = c6977h.mo15248Rb(str2);
        if (aoZ == null) {
            C4990ab.m7417i("MicroMsg.ConversationStorage", "create new cvs:%s", str2);
            aoZ = new C7617ak(str2);
            if (C7616ad.m13548mR(str2)) {
                aoZ.mo14749hN(1);
            }
            c7617ak = aoZ;
            z = true;
        } else {
            c7617ak = aoZ;
            z = false;
        }
        this.xXt.mo7929a(Rb, c7617ak, z, c3460c);
        C4990ab.m7417i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d ", c3460c.talker, c3460c.oqJ, Integer.valueOf(c3460c.oqL));
        if (!(Rb == null || Rb.field_msgId == 0)) {
            if (c3460c.oqL == 1 && ((C7620bi) c3460c.oqK.get(0)).field_msgId != Rb.field_msgId) {
                C4990ab.m7421w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", Long.valueOf(Rb.field_msgId), Long.valueOf(((C7620bi) c3460c.oqK.get(0)).field_msgId));
            }
            i = Rb.field_flag;
            j = c7617ak.field_lastSeq;
            long j2 = Rb.field_msgSeq;
            long j3 = (long) c7617ak.field_UnDeliverCount;
            C4990ab.m7417i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
            if ((c3460c.oqJ.equals("insert") && c3460c.oqL > 0) || (c3460c.oqJ.equals("update") && c7617ak.field_unReadCount + c3460c.oqL >= 0)) {
                c7617ak.mo14748hM(c7617ak.field_unReadCount + c3460c.oqL);
                if (j2 > j) {
                    C4990ab.m7417i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", Long.valueOf(j2));
                    c7617ak.mo14744eF(j2);
                }
            } else if (c3460c.oqN > 0 && j2 < j && ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15246R(c7617ak.field_username, j).field_msgId == 0) {
                j3 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15267Ru(c7617ak.field_username);
                C4990ab.m7417i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
                c7617ak.mo14744eF(j2);
                if (j > j3) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7905N(c7617ak.field_username, j3);
                }
            }
            if (Rb.bwt() && Rb.field_isSend == 1) {
                c7617ak.field_sightTime = Rb.field_createTime;
                c7617ak.duU = true;
            }
        }
        if (c3460c.oqJ.equals("insert") && c3460c.oqK.size() > 0 && C1855t.m3896kH(c3460c.talker)) {
            str2 = C1853r.m3846Yz();
            Iterator it = c3460c.oqK.iterator();
            while (it.hasNext()) {
                C7620bi c7620bi = (C7620bi) it.next();
                if (c7620bi.field_isSend != 1) {
                    if (!c7620bi.isText()) {
                        Object obj;
                        if (c7620bi.getType() == 503316529) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                    if (c7620bi.apB(str2)) {
                        c7617ak.mo14753hR(c7617ak.field_atCount + 1);
                    } else if (c7620bi.dtV()) {
                        c7617ak.mo14753hR(c7617ak.field_atCount + 4096);
                    }
                }
                Map z2 = C5049br.m7595z(c7620bi.field_content, "sysmsg");
                if (C7620bi.m13567aT(z2)) {
                    c7617ak.mo14756hU(c7617ak.field_UnReadInvite + 1);
                } else if (C7620bi.m13568aU(z2)) {
                    c7617ak.mo14756hU(c7617ak.field_UnReadInvite + 4096);
                }
            }
        }
        i = 0;
        if (c3460c != null) {
            str = c3460c.talker;
        } else {
            str = null;
        }
        if (!(c3460c == null || c3460c.oqJ == null || !c3460c.oqJ.equals("delete"))) {
            if (c3460c.oqN > 0) {
                i = c3460c.oqN;
            }
            C4990ab.m7417i("MicroMsg.ConversationStorage", "notify delete count %d ", Integer.valueOf(c3460c.oqN));
        }
        int i3 = i;
        if (c3460c == null || c3460c.oqJ == null || !c3460c.oqJ.equals("insert")) {
            i2 = 0;
        } else {
            if (c3460c.oqM > 0) {
                i = c3460c.oqM;
            } else {
                i = 0;
            }
            C4990ab.m7417i("MicroMsg.ConversationStorage", "notify insert all count %d ", Integer.valueOf(c3460c.oqM));
            i2 = i;
        }
        String str3 = "MicroMsg.ConversationStorage";
        String str4 = "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]";
        Object[] objArr = new Object[7];
        objArr[0] = C5046bo.m7532bc(str, "");
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
        objArr[6] = c7617ak.field_parentRef;
        C4990ab.m7417i(str3, str4, objArr);
        if (z && i3 > 0 && i2 == 0) {
            C4990ab.m7417i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", str, c7617ak.field_username);
            AppMethodBeat.m2505o(1206);
            return;
        }
        this.xXu.mo10126cF(c7617ak);
        this.xXu.doNotify();
        if (str == null) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "talker == null");
            AppMethodBeat.m2505o(1206);
        } else if (str.equals(c7617ak.field_username)) {
            if (Rb == null || Rb.field_msgId == 0) {
                C4990ab.m7416i("MicroMsg.ConversationStorage", "update null conversation with talker ".concat(String.valueOf(str)));
                if (!z) {
                    c7617ak.dsI();
                    mo15774a(c7617ak, i3, i2);
                    mo15768a(c7617ak, str, true);
                } else if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15262Rp(str) > 0) {
                    if (Rb.bwt() || C4872b.dnQ()) {
                        c7617ak.mo14742eD(Rb.field_createTime);
                    } else {
                        c7617ak.mo14742eD(C5046bo.anU());
                    }
                    mo15774a(c7617ak, i3, i2);
                    mo15807d(c7617ak);
                }
            } else {
                C4990ab.m7418v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + Rb.field_msgId);
                c7617ak.mo17068ap(Rb);
                if (this.xXr != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    this.xXr.mo10533a(Rb, pString, pString2, pInt, c7617ak.mo16714jl(2097152));
                    C4990ab.m7411d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", pString2.value);
                    c7617ak.mo14758jh(pString.value);
                    c7617ak.mo14759ji(pString2.value);
                    c7617ak.mo14751hP(pInt.value);
                } else {
                    str3 = mo15779ac(Rb.getType(), c7617ak.field_content);
                    c7617ak.mo14758jh(C5046bo.nullAsNil(c7617ak.field_digest).concat(C5046bo.isNullOrNil(str3) ? "" : " " + C5046bo.nullAsNil(str3)));
                }
                c7617ak.mo14757jg(Integer.toString(Rb.getType()));
                if (this.xXs != null) {
                    this.xXs.mo7928a(Rb, c7617ak);
                }
                c7617ak.mo14743eE(C43298a.m77176a(c7617ak, 1, Rb.field_createTime));
                if (z) {
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                    if (!(aoO == null || C5046bo.isNullOrNil(aoO.field_username) || !aoO.mo16702Oe())) {
                        c7617ak.mo14743eE(C43298a.m77176a(c7617ak, 2, 0));
                    }
                    mo15774a(c7617ak, i3, i2);
                    if (Rb.bwt() || C4872b.dnQ()) {
                        c7617ak.mo14742eD(Rb.field_createTime);
                    } else {
                        c7617ak.mo14742eD(C5046bo.anU());
                    }
                    mo15807d(c7617ak);
                } else {
                    mo15774a(c7617ak, i3, i2);
                    mo15768a(c7617ak, str, true);
                }
            }
            this.xXv.mo10126cF(c7617ak);
            this.xXv.doNotify();
            this.xXt.mo7930b(Rb, c7617ak, z, c3460c);
            AppMethodBeat.m2505o(1206);
        } else {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
            AppMethodBeat.m2505o(1206);
        }
    }

    /* renamed from: c */
    private static long m23719c(C7617ak c7617ak) {
        AppMethodBeat.m2504i(1207);
        long a;
        if (c7617ak != null) {
            a = C43298a.m77177a(c7617ak, c7617ak.field_conversationTime);
            AppMethodBeat.m2505o(1207);
            return a;
        }
        a = C5046bo.anU() & 72057594037927935L;
        AppMethodBeat.m2505o(1207);
        return a;
    }

    public final void aoX(String str) {
        AppMethodBeat.m2504i(1208);
        C4990ab.m7421w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", str, C5007an.doR());
        if (this.bSd.delete(C15433al.aoW(str), "username=?", new String[]{str}) != 0) {
            mo10120b(5, this, str);
        }
        AppMethodBeat.m2505o(1208);
    }

    public final boolean dsJ() {
        AppMethodBeat.m2504i(1209);
        boolean z = this.bSd.mo10108hY("rconversation", "delete from rconversation") || this.bSd.mo10108hY("rconversation", "delete from rbottleconversation");
        if (z) {
            mo10120b(5, this, "");
        }
        AppMethodBeat.m2505o(1209);
        return z;
    }

    public final boolean aoY(String str) {
        AppMethodBeat.m2504i(1210);
        C4990ab.m7421w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, C5007an.doR());
        boolean hY = this.bSd.mo10108hY("rconversation", "delete from " + C15433al.aoW(str) + " where username like '%" + str + "'");
        if (hY) {
            mo10120b(5, this, str);
        }
        AppMethodBeat.m2505o(1210);
        return hY;
    }

    public final C7617ak aoZ(String str) {
        AppMethodBeat.m2504i(1211);
        Cursor a = this.bSd.mo10105a(C15433al.aoW(str), null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            C7617ak c7617ak = new C7617ak();
            c7617ak.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(1211);
            return c7617ak;
        }
        C4990ab.m7420w("MicroMsg.ConversationStorage", "get null with username:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.m2505o(1211);
        return null;
    }

    public final HashMap<String, Long> dsK() {
        AppMethodBeat.m2504i(1213);
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = new HashMap();
        Cursor a = this.bSd.mo10105a("rconversation", new String[]{"username", "conversationTime"}, null, null, null, null, null, 2);
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
                    C4990ab.m7410d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(1213);
                    return hashMap;
                }
            }
        }
        a.close();
        AppMethodBeat.m2505o(1213);
        return hashMap;
    }

    public final void dsL() {
        AppMethodBeat.m2504i(1216);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.bSd.update("rconversation", contentValues, null, null);
        AppMethodBeat.m2505o(1216);
    }

    public final void apa(String str) {
        AppMethodBeat.m2504i(1217);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.bSd.update("rconversation", contentValues, "username=?", new String[]{str});
        AppMethodBeat.m2505o(1217);
    }

    public final boolean apc(String str) {
        AppMethodBeat.m2504i(1219);
        if (str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
            AppMethodBeat.m2505o(1219);
            return false;
        }
        C4990ab.m7411d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", str);
        C7617ak aoZ = aoZ(str);
        if (aoZ == null) {
            AppMethodBeat.m2505o(1219);
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("unReadCount", Integer.valueOf(0));
        contentValues.put("unReadMuteCount", Integer.valueOf(0));
        contentValues.put("UnReadInvite", Integer.valueOf(0));
        contentValues.put("atCount", Integer.valueOf(0));
        contentValues.put("attrflag", Integer.valueOf(aoZ.field_attrflag & -1048577));
        int update = this.bSd.update(C15433al.aoW(str), contentValues, "parentRef= ?", new String[]{C5046bo.m7586vA(str)});
        if (update > 0) {
            mo10120b(3, this, str);
        }
        if (update > 0) {
            AppMethodBeat.m2505o(1219);
            return true;
        }
        AppMethodBeat.m2505o(1219);
        return false;
    }

    public final boolean apd(String str) {
        AppMethodBeat.m2504i(1220);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "update conversation failed");
            AppMethodBeat.m2505o(1220);
            return false;
        }
        C7617ak aoZ = aoZ(str);
        if (aoZ == null || (aoZ.field_unReadCount > 0 && str.equals(aoZ.field_username))) {
            AppMethodBeat.m2505o(1220);
            return true;
        }
        boolean hY = this.bSd.mo10108hY("rconversation", "update " + C15433al.aoW(str) + " set unReadCount = 1, atCount = 0, attrflag = " + (aoZ.field_attrflag | 1048576) + " where username = \"" + C5046bo.m7586vA(str) + "\"");
        if (hY) {
            mo10120b(3, this, str);
        }
        AppMethodBeat.m2505o(1220);
        return hY;
    }

    /* renamed from: a */
    public final boolean mo15777a(String str, int i, boolean z, int i2) {
        AppMethodBeat.m2504i(1221);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1221);
            return false;
        } else if (aoZ(str) == null) {
            AppMethodBeat.m2505o(1221);
            return true;
        } else {
            int i3;
            if (z) {
                i3 = i2 | i;
            } else {
                i3 = (i ^ -1) & i2;
            }
            if (i3 == i2) {
                AppMethodBeat.m2505o(1221);
                return false;
            }
            boolean hY = this.bSd.mo10108hY("rconversation", "update " + C15433al.aoW(str) + " set attrflag = " + i3 + " where username = \"" + C5046bo.m7586vA(str) + "\"");
            if (hY) {
                mo10120b(3, this, str);
            }
            AppMethodBeat.m2505o(1221);
            return hY;
        }
    }

    /* renamed from: a */
    public final int mo15767a(C7617ak c7617ak, String str) {
        AppMethodBeat.m2504i(139144);
        int a = mo15768a(c7617ak, str, true);
        AppMethodBeat.m2505o(139144);
        return a;
    }

    /* renamed from: a */
    public final int mo15768a(C7617ak c7617ak, String str, boolean z) {
        AppMethodBeat.m2504i(1223);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "update conversation failed");
            AppMethodBeat.m2505o(1223);
            return 0;
        }
        if (z) {
            c7617ak.mo14743eE(C15433al.m23719c(c7617ak));
        }
        C15433al.m23720e(c7617ak);
        int update = this.bSd.update(C15433al.aoW(str), c7617ak.mo10098Hl(), "username=?", new String[]{str});
        if (update != 0) {
            mo10120b(3, this, str);
        } else {
            C4990ab.m7413e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", C15433al.aoW(str));
        }
        AppMethodBeat.m2505o(1223);
        return update;
    }

    /* renamed from: e */
    private static void m23720e(C7617ak c7617ak) {
        AppMethodBeat.m2504i(1224);
        if (c7617ak == null) {
            AppMethodBeat.m2505o(1224);
            return;
        }
        if (c7617ak.field_unReadCount > 0) {
            C4990ab.m7410d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
            if ((c7617ak.field_attrflag & 1048576) != 0) {
                c7617ak.mo14748hM(c7617ak.field_unReadCount - 1);
                c7617ak.mo14752hQ(c7617ak.field_attrflag & -1048577);
            }
        }
        AppMethodBeat.m2505o(1224);
    }

    private long dsM() {
        AppMethodBeat.m2504i(1225);
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        Cursor a = this.bSd.mo10104a("select max(conversationTime) as conversationTime from rconversation", null, 2);
        while (a.moveToNext()) {
            j = a.getLong(0);
        }
        a.close();
        C4990ab.m7411d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(1225);
        return j;
    }

    public final boolean ape(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(1226);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
            AppMethodBeat.m2505o(1226);
        } else {
            C7617ak aoZ = aoZ(str);
            if (aoZ == null) {
                C4990ab.m7412e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
                AppMethodBeat.m2505o(1226);
            } else {
                z = this.bSd.mo10108hY("rconversation", "update " + C15433al.aoW(aoZ.field_username) + " set flag = " + C43298a.m77176a(aoZ, 1, dsM() + 1) + " where username = \"" + C5046bo.m7586vA(aoZ.field_username) + "\"");
                if (z) {
                    mo10120b(3, this, aoZ.field_username);
                }
                AppMethodBeat.m2505o(1226);
            }
        }
        return z;
    }

    public final boolean apf(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(1227);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
            AppMethodBeat.m2505o(1227);
        } else {
            C7617ak c7617ak;
            if (aoZ(str) == null) {
                c7617ak = new C7617ak(str);
                c7617ak.mo14742eD(System.currentTimeMillis());
                mo15807d(c7617ak);
                C4990ab.m7416i("MicroMsg.ConversationStorage", "setPlacedTop username = ".concat(String.valueOf(str)));
            }
            c7617ak = aoZ(str);
            if (c7617ak == null) {
                AppMethodBeat.m2505o(1227);
            } else {
                z = this.bSd.mo10108hY("rconversation", "update " + C15433al.aoW(c7617ak.field_username) + " set flag = " + C43298a.m77176a(c7617ak, 2, 0) + " where username = \"" + C5046bo.m7586vA(c7617ak.field_username) + "\"");
                if (z) {
                    mo10120b(3, this, c7617ak.field_username);
                }
                AppMethodBeat.m2505o(1227);
            }
        }
        return z;
    }

    public final boolean apg(String str) {
        AppMethodBeat.m2504i(1228);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
            AppMethodBeat.m2505o(1228);
            return false;
        }
        boolean f = mo15821f(aoZ(str));
        AppMethodBeat.m2505o(1228);
        return f;
    }

    /* renamed from: f */
    public final boolean mo15821f(C7617ak c7617ak) {
        AppMethodBeat.m2504i(1229);
        if (c7617ak == null) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
            AppMethodBeat.m2505o(1229);
            return false;
        }
        boolean hY = this.bSd.mo10108hY("rconversation", "update " + C15433al.aoW(c7617ak.field_username) + " set flag = " + C43298a.m77176a(c7617ak, 3, c7617ak.field_conversationTime) + " where username = \"" + C5046bo.m7586vA(c7617ak.field_username) + "\"");
        if (hY) {
            mo10120b(3, this, c7617ak.field_username);
        }
        AppMethodBeat.m2505o(1229);
        return hY;
    }

    public final boolean aph(String str) {
        AppMethodBeat.m2504i(1230);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "isPlacedTop failed");
            AppMethodBeat.m2505o(1230);
            return false;
        }
        boolean g = mo15822g(aoZ(str));
        AppMethodBeat.m2505o(1230);
        return g;
    }

    /* renamed from: g */
    public final boolean mo15822g(C7617ak c7617ak) {
        AppMethodBeat.m2504i(1231);
        if (c7617ak == null) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
            AppMethodBeat.m2505o(1231);
            return false;
        } else if (C43298a.m77176a(c7617ak, 4, 0) != 0) {
            AppMethodBeat.m2505o(1231);
            return true;
        } else {
            AppMethodBeat.m2505o(1231);
            return false;
        }
    }

    /* renamed from: c */
    public final Cursor mo15804c(String str, List<String> list, String str2) {
        AppMethodBeat.m2504i(1232);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from rconversation where ");
        if (C7487a.ewS == str2) {
            stringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(C5046bo.m7586vA(str2)).append("' ");
        }
        stringBuilder.append(C5046bo.nullAsNil(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc, conversationTime desc");
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.m2505o(1232);
        return rawQuery;
    }

    public final List<String> dsN() {
        AppMethodBeat.m2504i(1233);
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rconversation.username from rconversation,rcontact where ");
        stringBuilder.append("rconversation.username = rcontact.username");
        stringBuilder.append(C5046bo.nullAsNil(C5046bo.nullAsNil(C1855t.fkP)));
        stringBuilder.append(" and ( verifyFlag & 8 ) = 0");
        stringBuilder.append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
        for (String append : C1855t.fkY) {
            stringBuilder.append(" and rconversation.username != '").append(append).append("'");
        }
        stringBuilder.append(" order by sightTime desc, flag desc, conversationTime desc");
        Cursor a = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                do {
                    arrayList.add(a.getString(0));
                } while (a.moveToNext());
            }
            a.close();
        }
        C4990ab.m7411d("MicroMsg.ConversationStorage", "user list:%s", arrayList);
        AppMethodBeat.m2505o(1233);
        return arrayList;
    }

    /* renamed from: a */
    public final Cursor mo15769a(String str, List<String> list, String str2, boolean z) {
        AppMethodBeat.m2504i(1234);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where ");
        if (C7487a.ewS == str2) {
            stringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(C5046bo.m7586vA(str2)).append("' ");
        }
        stringBuilder.append(C5046bo.nullAsNil(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc");
        C4990ab.m7410d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + stringBuilder.toString());
        Cursor a = this.bSd.mo10104a(stringBuilder.toString(), null, z ? 4 : 0);
        AppMethodBeat.m2505o(1234);
        return a;
    }

    /* renamed from: a */
    public final Cursor mo15771a(ArrayList<String> arrayList, String str, List<String> list, String str2) {
        AppMethodBeat.m2504i(1235);
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
        if (C7487a.ewS == str2) {
            stringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(C5046bo.m7586vA(str2)).append("' ");
        }
        stringBuilder.append(C5046bo.nullAsNil(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username != '").append(append).append("'");
            }
        }
        C4990ab.m7411d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql %s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.m2505o(1235);
        return rawQuery;
    }

    /* renamed from: z */
    private static String m23721z(String str, List<String> list) {
        AppMethodBeat.m2504i(1236);
        String str2 = "";
        if (list != null && list.size() > 0) {
            str2 = str2 + str + " not in (";
            int i = 0;
            while (i < list.size()) {
                str2 = str2 + "\"" + C5046bo.m7586vA((String) list.get(i)) + "\"" + (i == list.size() + -1 ? "" : ",");
                i++;
            }
            str2 = str2 + ") ";
        }
        AppMethodBeat.m2505o(1236);
        return str2;
    }

    /* renamed from: a */
    public final Cursor mo15770a(String str, List<String> list, boolean z, String str2) {
        Object obj;
        AppMethodBeat.m2504i(1237);
        String str3 = " ";
        String str4 = " ";
        if (str2 != null && str2.length() > 0) {
            str4 = " and rconversation.username = rcontact.username ";
        }
        str4 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + str3 + " where rconversation.username = rcontact.username" + str4 + C5046bo.nullAsNil(str);
        str4 = str4 + C15433al.m23721z(" and rconversation.username", list);
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
        C4990ab.m7410d("MicroMsg.ConversationStorage", "getSearchCursor sql ".concat(String.valueOf(obj)));
        Cursor rawQuery = this.bSd.rawQuery(obj, null);
        AppMethodBeat.m2505o(1237);
        return rawQuery;
    }

    public final Cursor api(String str) {
        AppMethodBeat.m2504i(1238);
        Cursor rawQuery = this.bSd.rawQuery("select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + C5046bo.nullAsNil(str) + " order by flag desc, conversationTime desc", null);
        AppMethodBeat.m2505o(1238);
        return rawQuery;
    }

    /* renamed from: aF */
    public final void mo15778aF(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(1239);
        C4990ab.m7421w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", C5007an.doR());
        if (linkedList.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
            AppMethodBeat.m2505o(1239);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = (String) linkedList.poll();
        stringBuilder.append("delete from rconversation where ");
        stringBuilder.append("username='").append(str).append('\'');
        while (!linkedList.isEmpty()) {
            stringBuilder.append(" or username='").append((String) linkedList.poll()).append('\'');
        }
        C4990ab.m7417i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", stringBuilder.toString());
        this.bSd.mo10108hY("rconversation", stringBuilder.toString());
        AppMethodBeat.m2505o(1239);
    }

    public final List<String> dsO() {
        AppMethodBeat.m2504i(1240);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        C4990ab.m7417i("MicroMsg.ConversationStorage", "getAllConvUserName sql %s", ("select username from rconversation" + C15433al.m23721z(" where username", arrayList)) + " order by flag desc, conversationTime desc");
        Cursor rawQuery = this.bSd.rawQuery(r0, null);
        int columnIndex = rawQuery.getColumnIndex("username");
        while (rawQuery.moveToNext()) {
            arrayList2.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        AppMethodBeat.m2505o(1240);
        return arrayList2;
    }

    /* renamed from: t */
    public final Cursor mo15825t(List<String> list, int i) {
        AppMethodBeat.m2504i(1241);
        String str = "select username from rconversation";
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                str = str + (i3 > 0 ? " and " : " where ") + "username != \"" + C5046bo.m7586vA((String) list.get(i3)) + "\"";
                i2 = i3 + 1;
            } else {
                Cursor rawQuery = this.bSd.rawQuery(str + " order by flag desc, conversationTime desc limit 50 offset " + i, null);
                AppMethodBeat.m2505o(1241);
                return rawQuery;
            }
        }
    }

    public final Cursor dsP() {
        AppMethodBeat.m2504i(1242);
        Cursor rawQuery = this.bSd.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
        AppMethodBeat.m2505o(1242);
        return rawQuery;
    }

    /* renamed from: MV */
    public final boolean mo15766MV(String str) {
        boolean z;
        AppMethodBeat.m2504i(1243);
        Cursor a = this.bSd.mo10105a(C15433al.aoW(str), null, "username=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            z = true;
        } else {
            z = false;
        }
        a.close();
        AppMethodBeat.m2505o(1243);
        return z;
    }

    public final Cursor apj(String str) {
        AppMethodBeat.m2504i(1244);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT username, unReadCount");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE (username LIKE '%@chatroom' ");
        stringBuilder.append(" or username LIKE '%@im.chatroom' ) ");
        stringBuilder.append(C5046bo.nullAsNil(str));
        stringBuilder.append(" AND unReadCount > 0");
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.m2505o(1244);
        return rawQuery;
    }

    /* renamed from: ic */
    public final Cursor mo15823ic(String str, String str2) {
        AppMethodBeat.m2504i(1245);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount");
        stringBuilder.append(" from rconversation where username = '").append(str).append("' AND ( parentRef is ").append(C7487a.ewS).append(" or parentRef = '' ) ").append(C5046bo.nullAsNil(str2));
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.m2505o(1245);
        return rawQuery;
    }

    /* renamed from: A */
    public final Cursor mo15764A(String str, List<String> list) {
        AppMethodBeat.m2504i(1246);
        C4990ab.m7417i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", str, C5046bo.dpG());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(unReadCount) from rconversation, rcontact");
        stringBuilder.append(" where rconversation.unReadCount > 0 AND (rconversation.parentRef is ").append(C7487a.ewS).append(" or parentRef = '' ) AND rconversation.username = rcontact.username").append(C5046bo.nullAsNil(str)).append(" AND ( type & 512 ) == 0");
        stringBuilder.append(" AND rcontact.username != 'officialaccounts'");
        if (!(list == null || list.isEmpty())) {
            for (String append : list) {
                stringBuilder.append(" AND rconversation.username != '").append(append).append("'");
            }
        }
        C4990ab.m7419v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(append, null);
        AppMethodBeat.m2505o(1246);
        return rawQuery;
    }

    public final Cursor apk(String str) {
        AppMethodBeat.m2504i(1247);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(rconversation.username)");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(C5046bo.nullAsNil(str));
        stringBuilder.append(" AND ( type & 512 ) == 0");
        stringBuilder.append(" AND ( attrflag & 2097152 ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(C7487a.ewS).append(" or parentRef = '' ) ");
        stringBuilder.append(" AND rcontact.username != 'officialaccounts')");
        C4990ab.m7417i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(r0, null);
        AppMethodBeat.m2505o(1247);
        return rawQuery;
    }

    /* renamed from: eo */
    public final Cursor mo15820eo(String str, int i) {
        AppMethodBeat.m2504i(1248);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(C5046bo.nullAsNil(str));
        stringBuilder.append(" AND ( type & 512 ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(C7487a.ewS).append(" or parentRef = '' ) ");
        stringBuilder.append(" AND rcontact.username != 'officialaccounts')");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
        if (i > 0) {
            stringBuilder.append(" LIMIT ").append(String.valueOf(i));
        }
        C4990ab.m7417i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(r0, null);
        AppMethodBeat.m2505o(1248);
        return rawQuery;
    }

    public final int dsQ() {
        int i = 0;
        AppMethodBeat.m2504i(1249);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT SUM(rconversation.unReadCount)");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts'");
        C4990ab.m7411d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", stringBuilder.toString());
        Cursor a = this.bSd.mo10104a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        AppMethodBeat.m2505o(1249);
        return i;
    }

    public final String dsR() {
        AppMethodBeat.m2504i(1250);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts'");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
        stringBuilder.append(" LIMIT 1 ");
        C4990ab.m7417i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", stringBuilder.toString());
        Cursor a = this.bSd.mo10104a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                String string = a.getString(0);
                a.close();
                AppMethodBeat.m2505o(1250);
                return string;
            }
            a.close();
        }
        AppMethodBeat.m2505o(1250);
        return null;
    }

    public final int apl(String str) {
        int i = 0;
        AppMethodBeat.m2504i(1251);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        C4990ab.m7417i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", stringBuilder.toString());
        Cursor a = this.bSd.mo10104a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        AppMethodBeat.m2505o(1251);
        return i;
    }

    public final String apm(String str) {
        AppMethodBeat.m2504i(1252);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        stringBuilder.append(" ORDER BY conversationTime DESC, conversationTime DESC ");
        stringBuilder.append(" LIMIT 1 ");
        C4990ab.m7417i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", stringBuilder.toString());
        Cursor a = this.bSd.mo10104a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                String string = a.getString(0);
                a.close();
                AppMethodBeat.m2505o(1252);
                return string;
            }
            a.close();
        }
        AppMethodBeat.m2505o(1252);
        return null;
    }

    public final Cursor dsS() {
        AppMethodBeat.m2504i(1253);
        C4990ab.m7417i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", "select count(*) from rbottleconversation where unReadCount > 0");
        Cursor rawQuery = this.bSd.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
        AppMethodBeat.m2505o(1253);
        return rawQuery;
    }

    /* renamed from: nR */
    public final int mo15824nR(String str) {
        int i = 0;
        AppMethodBeat.m2504i(1254);
        Cursor a = this.bSd.mo10104a("select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + C5046bo.nullAsNil(str), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(1254);
        return i;
    }

    public final C7617ak dsT() {
        C7617ak c7617ak;
        AppMethodBeat.m2504i(1255);
        Cursor c = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15804c(C1855t.fkP, null, "officialaccounts");
        if (c != null) {
            if (c.getCount() <= 0 || !c.moveToFirst()) {
                c7617ak = null;
            } else {
                c7617ak = new C7617ak();
                c7617ak.mo8995d(c);
            }
            c.close();
        } else {
            c7617ak = null;
        }
        AppMethodBeat.m2505o(1255);
        return c7617ak;
    }

    public final C7617ak apn(String str) {
        C7617ak c7617ak;
        AppMethodBeat.m2504i(1256);
        Cursor c = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15804c(C1855t.fkP, null, str);
        if (c != null) {
            if (c.getCount() <= 0 || !c.moveToFirst()) {
                c7617ak = null;
            } else {
                c7617ak = new C7617ak();
                c7617ak.mo8995d(c);
            }
            c.close();
        } else {
            c7617ak = null;
        }
        AppMethodBeat.m2505o(1256);
        return c7617ak;
    }

    /* renamed from: c */
    public final void mo15806c(String[] strArr, String str) {
        int i;
        AppMethodBeat.m2504i(1257);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '").append(C5046bo.nullAsNil(str)).append("' where 1 != 1 ");
        for (i = 0; i <= 0; i++) {
            stringBuilder.append(" or username = '").append(strArr[0]).append("'");
        }
        C4990ab.m7411d("MicroMsg.ConversationStorage", "update sql: %s", stringBuilder.toString());
        if (this.bSd.mo10108hY("rconversation", stringBuilder.toString())) {
            for (i = 0; i <= 0; i++) {
                mo10120b(3, this, strArr[0]);
            }
        }
        AppMethodBeat.m2505o(1257);
    }

    public final int apo(String str) {
        int i = 0;
        AppMethodBeat.m2504i(1258);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(atCount) from rconversation");
        stringBuilder.append(" where unReadCount > 0");
        if (!C5046bo.isNullOrNil(str)) {
            stringBuilder.append(" and username = '").append(str).append("'");
        }
        C4990ab.m7411d("MicroMsg.ConversationStorage", "query sql: %s", stringBuilder.toString());
        Cursor a = this.bSd.mo10104a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        AppMethodBeat.m2505o(1258);
        return i;
    }

    /* renamed from: ac */
    public final String mo15779ac(int i, String str) {
        AppMethodBeat.m2504i(1259);
        String str2 = null;
        if (!C5046bo.isNullOrNil(str)) {
            switch (i) {
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    Map z = C5049br.m7595z(str, "msg");
                    if (z != null) {
                        str2 = (String) z.get(".msg.appmsg.title");
                        C4990ab.m7411d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", str2);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.m2505o(1259);
        return str2;
    }

    public final boolean apK() {
        AppMethodBeat.m2504i(1260);
        if (this.bSd == null || this.bSd.dpU()) {
            String str = "MicroMsg.ConversationStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.bSd == null ? BuildConfig.COMMAND : Boolean.valueOf(this.bSd.dpU());
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(1260);
            return false;
        }
        AppMethodBeat.m2505o(1260);
        return true;
    }

    public final void app(String str) {
        AppMethodBeat.m2504i(1261);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + C5046bo.m7586vA(str) + "\"");
        C4990ab.m7411d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", stringBuilder.toString());
        if (this.bSd.mo10108hY("rconversation", stringBuilder.toString())) {
            mo10120b(3, this, str);
        }
        AppMethodBeat.m2505o(1261);
    }

    public final void apq(String str) {
        AppMethodBeat.m2504i(1262);
        C4990ab.m7411d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", str, Integer.valueOf(this.bSd.delete(C15433al.aoW(str), "username=? or parentRef =?", new String[]{str, str})));
        if (this.bSd.delete(C15433al.aoW(str), "username=? or parentRef =?", new String[]{str, str}) != 0) {
            mo10120b(5, this, str);
        }
        AppMethodBeat.m2505o(1262);
    }

    public final int apr(String str) {
        int i = -1;
        AppMethodBeat.m2504i(1263);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(1263);
        } else {
            Cursor a = this.bSd.mo10104a("select msgCount from rconversation where username=" + C7480h.escape(str), null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(1263);
        }
        return i;
    }

    public final Cursor dsU() {
        AppMethodBeat.m2504i(1264);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username, ");
        stringBuilder.append("rconversation.unReadCount");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND ( parentRef is ").append(C7487a.ewS).append(" or parentRef = '' ) ");
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.m2505o(1264);
        return rawQuery;
    }

    /* renamed from: aq */
    public final void mo15801aq(C7620bi c7620bi) {
        AppMethodBeat.m2504i(1212);
        String str = c7620bi.field_talker;
        boolean z = false;
        C7617ak aoZ = aoZ(str);
        if (aoZ == null || aoZ.field_conversationTime <= c7620bi.field_createTime || aoZ.field_conversationTime == Long.MAX_VALUE) {
            if (aoZ == null) {
                aoZ = new C7617ak(str);
                z = true;
            }
            aoZ.mo14750hO(c7620bi.field_isSend);
            aoZ.mo14748hM(aoZ.field_unReadCount);
            aoZ.mo17068ap(c7620bi);
            aoZ.mo14757jg(Integer.toString(c7620bi.getType()));
            aoZ.mo14743eE((aoZ.field_flag & 4611686018427387904L) | (c7620bi.field_createTime & 72057594037927935L));
            if (z) {
                mo15807d(aoZ);
                AppMethodBeat.m2505o(1212);
                return;
            }
            mo15768a(aoZ, str, true);
            AppMethodBeat.m2505o(1212);
            return;
        }
        C4990ab.m7416i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        AppMethodBeat.m2505o(1212);
    }

    /* renamed from: d */
    public final long mo15807d(C7617ak c7617ak) {
        AppMethodBeat.m2504i(1214);
        String nullAsNil = C5046bo.nullAsNil(c7617ak.field_username);
        if (nullAsNil.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
            AppMethodBeat.m2505o(1214);
            return -1;
        }
        c7617ak.mo14743eE(C15433al.m23719c(c7617ak));
        C15433al.m23720e(c7617ak);
        long insert = this.bSd.insert(C15433al.aoW(nullAsNil), null, c7617ak.mo10098Hl());
        if (insert != -1) {
            mo10120b(2, this, c7617ak.field_username);
        } else {
            C4990ab.m7413e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", C15433al.aoW(nullAsNil));
        }
        AppMethodBeat.m2505o(1214);
        return insert;
    }

    /* renamed from: a */
    public final void mo15774a(C7617ak c7617ak, int i, int i2) {
        AppMethodBeat.m2504i(1215);
        if (!C1829bf.m3755oB(c7617ak.field_username)) {
            AppMethodBeat.m2505o(1215);
        } else if (C5046bo.nullAsNil(c7617ak.field_username).length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
            AppMethodBeat.m2505o(1215);
        } else {
            if (c7617ak.field_msgCount == 0) {
                c7617ak.mo14747hL(C1829bf.m3754oA(c7617ak.field_username));
                C4990ab.m7416i("MicroMsg.ConversationStorage", "getMsgCount from message table");
            } else if (i > 0) {
                c7617ak.mo14747hL(c7617ak.field_msgCount - i);
                if (c7617ak.field_msgCount < 0) {
                    C4990ab.m7412e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
                    c7617ak.mo14747hL(0);
                }
            } else if (i2 > 0) {
                c7617ak.mo14747hL(c7617ak.field_msgCount + i2);
            }
            C4990ab.m7417i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(c7617ak.field_msgCount), c7617ak.field_username, Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(1215);
        }
    }

    public final boolean apb(String str) {
        AppMethodBeat.m2504i(1218);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConversationStorage", "update conversation failed");
        } else {
            C4990ab.m7411d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", str);
            C7617ak aoZ = aoZ(str);
            if (aoZ == null) {
                AppMethodBeat.m2505o(1218);
                return true;
            } else if (aoZ.field_unReadCount == 0 && aoZ.field_unReadMuteCount == 0 && str.equals(aoZ.field_username)) {
                mo15777a(str, 1048576, false, aoZ.field_attrflag);
                ContentValues contentValues = new ContentValues();
                contentValues.put("UnReadInvite", Integer.valueOf(0));
                contentValues.put("atCount", Integer.valueOf(0));
                if (this.bSd.update(C15433al.aoW(str), contentValues, "username= ?", new String[]{C5046bo.m7586vA(str)}) > 0) {
                    mo10120b(3, this, str);
                }
                AppMethodBeat.m2505o(1218);
                return true;
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("unReadCount", Integer.valueOf(0));
                contentValues2.put("unReadMuteCount", Integer.valueOf(0));
                contentValues2.put("UnReadInvite", Integer.valueOf(0));
                contentValues2.put("atCount", Integer.valueOf(0));
                contentValues2.put("attrflag", Integer.valueOf(aoZ.field_attrflag & -1048577));
                int update = this.bSd.update(C15433al.aoW(str), contentValues2, "username= ?", new String[]{C5046bo.m7586vA(str)});
                if (update > 0) {
                    mo10120b(3, this, str);
                }
                if (update > 0) {
                    AppMethodBeat.m2505o(1218);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(1218);
        return false;
    }
}
