package com.tencent.p177mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C15422bb;
import com.tencent.p177mm.sdk.platformtools.C15422bb.C15421b;
import com.tencent.p177mm.sdk.platformtools.C15422bb.C15424c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashSet;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelstat.m */
public final class C31275m extends C7296k implements C15424c<Integer, C42223k> {
    private static final String[] fTO = new String[]{"realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut"};
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) "};
    private long fTL;
    public C15422bb<Integer, C42223k> fTM = new C15422bb(this, C1720g.m3539RS().oAl.getLooper(), 30, 2);
    private long fTN;
    public C7480h fni;

    public C31275m(C7480h c7480h) {
        int i = 0;
        AppMethodBeat.m2504i(78753);
        this.fni = c7480h;
        HashSet hashSet = new HashSet();
        for (Object add : fTO) {
            hashSet.add(add);
        }
        Cursor a = this.fni.mo10104a("PRAGMA table_info(netstat);", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            hashSet.remove(a.getString(columnIndex));
        }
        a.close();
        String[] strArr = fTO;
        columnIndex = strArr.length;
        while (i < columnIndex) {
            Object obj = strArr[i];
            if (hashSet.contains(obj)) {
                this.fni.mo10108hY("netstat", "ALTER TABLE netstat ADD COLUMN " + obj + " INT;");
            }
            i++;
        }
        this.fTN = System.currentTimeMillis();
        AppMethodBeat.m2505o(78753);
    }

    /* renamed from: md */
    public final C42223k mo51241md(int i) {
        AppMethodBeat.m2504i(78754);
        C42223k c42223k = (C42223k) this.fTM.get(Integer.valueOf(i));
        if (c42223k == null) {
            Cursor a = this.fni.mo10105a("netstat", null, "peroid = ".concat(String.valueOf(i)), null, null, null, null, 2);
            if (a.moveToFirst()) {
                c42223k = new C42223k();
                c42223k.mo67751d(a);
            }
            a.close();
            if (c42223k != null) {
                this.fTM.mo27466A(Integer.valueOf(i), c42223k);
            } else {
                C15422bb c15422bb = this.fTM;
                Integer valueOf = Integer.valueOf(i);
                C42223k c42223k2 = new C42223k();
                c42223k2.bJt = 0;
                c42223k2.f17169id = 0;
                c42223k2.fSZ = 0;
                c42223k2.fTa = 0;
                c42223k2.fTb = 0;
                c42223k2.fTc = 0;
                c42223k2.fTd = 0;
                c42223k2.fTe = 0;
                c42223k2.fTf = 0;
                c42223k2.fTg = 0;
                c42223k2.fTh = 0;
                c42223k2.fTi = 0;
                c42223k2.fTj = 0;
                c42223k2.fTk = 0;
                c42223k2.fTl = 0;
                c42223k2.fTm = 0;
                c42223k2.fTn = 0;
                c42223k2.fTo = 0;
                c42223k2.fTp = 0;
                c42223k2.fTq = 0;
                c42223k2.fTr = 0;
                c42223k2.fTs = 0;
                c42223k2.fTt = 0;
                c42223k2.fTu = 0;
                c42223k2.fTv = 0;
                c42223k2.fTw = 0;
                c42223k2.fTx = 0;
                c42223k2.fTy = 0;
                c42223k2.fTz = 0;
                c42223k2.fTA = 0;
                c42223k2.fTB = 0;
                c15422bb.mo27466A(valueOf, c42223k2);
            }
        } else if (c42223k.fSZ != i) {
            c42223k = null;
        }
        AppMethodBeat.m2505o(78754);
        return c42223k;
    }

    /* renamed from: a */
    public final void mo51237a(C42223k c42223k) {
        AppMethodBeat.m2504i(78755);
        Assert.assertNotNull(c42223k);
        long currentTimeMillis = System.currentTimeMillis();
        if (c42223k.fSZ <= 0) {
            c42223k.fSZ = (int) (currentTimeMillis / 86400000);
        }
        if (c42223k.fSZ <= 0) {
            AppMethodBeat.m2505o(78755);
            return;
        }
        C42223k md = mo51241md(c42223k.fSZ);
        if (md == null || c42223k.fSZ != md.fSZ) {
            c42223k.bJt |= 2;
            c42223k.f17169id = -1;
            if (md != null) {
                C4990ab.m7416i("MicroMsg.NetStat", md.toString());
            } else {
                C4990ab.m7416i("MicroMsg.NetStat", "NetStat started.");
            }
        } else {
            c42223k.bJt = md.bJt | 1;
            c42223k.fTa += md.fTb;
            c42223k.fTb += md.fTb;
            c42223k.fTc += md.fTd;
            c42223k.fTd += md.fTd;
            c42223k.fTe += md.fTe;
            c42223k.fTf += md.fTf;
            c42223k.fTg += md.fTg;
            c42223k.fTh += md.fTh;
            c42223k.fTi += md.fTi;
            c42223k.fTj += md.fTj;
            c42223k.fTk += md.fTk;
            c42223k.fTl += md.fTl;
            c42223k.fTm += md.fTn;
            c42223k.fTn += md.fTn;
            c42223k.fTo += md.fTp;
            c42223k.fTp += md.fTp;
            c42223k.fTq += md.fTq;
            c42223k.fTr += md.fTr;
            c42223k.fTs += md.fTs;
            c42223k.fTt += md.fTt;
            c42223k.fTu += md.fTu;
            c42223k.fTv += md.fTv;
            c42223k.fTw += md.fTw;
            c42223k.fTx += md.fTx;
            c42223k.fTy += md.fTy;
            c42223k.fTz += md.fTz;
            c42223k.fTA += md.fTA;
            c42223k.fTB += md.fTB;
            c42223k.f17169id = md.f17169id;
            if (currentTimeMillis - this.fTN > 300000) {
                C4990ab.m7416i("MicroMsg.NetStat", c42223k.toString());
            }
            mo51240b(c42223k);
            AppMethodBeat.m2505o(78755);
        }
        this.fTN = currentTimeMillis;
        mo51240b(c42223k);
        AppMethodBeat.m2505o(78755);
    }

    /* renamed from: b */
    public final boolean mo51240b(C42223k c42223k) {
        AppMethodBeat.m2504i(78756);
        Assert.assertNotNull(c42223k);
        Assert.assertTrue(c42223k.fSZ > 0);
        boolean A = this.fTM.mo27466A(Integer.valueOf(c42223k.fSZ), c42223k);
        AppMethodBeat.m2505o(78756);
        return A;
    }

    public final void akk() {
        AppMethodBeat.m2504i(78757);
        int dpB = (int) (C5046bo.dpB() / 86400000);
        if (mo51241md(dpB) != null) {
            AppMethodBeat.m2505o(78757);
            return;
        }
        C42223k c42223k = new C42223k();
        c42223k.fSZ = dpB;
        c42223k.f17169id = -1;
        mo51240b(c42223k);
        AppMethodBeat.m2505o(78757);
    }

    public final long akl() {
        AppMethodBeat.m2504i(78758);
        this.fTM.mo27468pl(true);
        int dpB = (int) (C5046bo.dpB() / 86400000);
        Cursor a = this.fni.mo10104a("SELECT peroid FROM netstat  WHERE peroid > " + ((int) ((C5046bo.anU() - 1296000000) / 86400000)) + " order by peroid limit 1", null, 2);
        if (a.moveToFirst()) {
            dpB = a.getInt(a.getColumnIndex("peroid"));
        }
        a.close();
        long j = ((long) dpB) * 86400000;
        AppMethodBeat.m2505o(78758);
        return j;
    }

    /* renamed from: me */
    public final C42223k mo51242me(int i) {
        C42223k c42223k = null;
        AppMethodBeat.m2504i(78759);
        this.fTM.mo27468pl(true);
        Cursor a = this.fni.mo10104a("SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(i)), null, 2);
        if (a.moveToFirst()) {
            c42223k = new C42223k();
            c42223k.mo67751d(a);
        }
        a.close();
        AppMethodBeat.m2505o(78759);
        return c42223k;
    }

    public final boolean akm() {
        AppMethodBeat.m2504i(78760);
        if (this.fni.inTransaction()) {
            C4990ab.m7416i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
            AppMethodBeat.m2505o(78760);
            return false;
        }
        this.fTL = this.fni.mo15639iV(Thread.currentThread().getId());
        if (this.fTL <= 0) {
            C4990ab.m7416i("MicroMsg.NetStat", "summer preAppend ticket: " + this.fTL + " return false");
            AppMethodBeat.m2505o(78760);
            return false;
        }
        AppMethodBeat.m2505o(78760);
        return true;
    }

    /* renamed from: a */
    public final void mo27469a(C15421b<Integer, C42223k> c15421b) {
        AppMethodBeat.m2504i(78761);
        int i = c15421b.xBj;
        C42223k c42223k = (C42223k) c15421b.values;
        if (c42223k != null && i == 1) {
            i = c42223k.fSZ;
            int i2 = c42223k.f17169id;
            if (i > 0) {
                ContentValues contentValues = new ContentValues();
                if ((c42223k.bJt & 2) != 0) {
                    contentValues.put("peroid", Integer.valueOf(c42223k.fSZ));
                }
                if ((c42223k.bJt & 4) != 0) {
                    contentValues.put("textCountIn", Integer.valueOf(c42223k.fTa));
                }
                if ((c42223k.bJt & 8) != 0) {
                    contentValues.put("textBytesIn", Integer.valueOf(c42223k.fTb));
                }
                if ((c42223k.bJt & 16) != 0) {
                    contentValues.put("imageCountIn", Integer.valueOf(c42223k.fTc));
                }
                if ((c42223k.bJt & 32) != 0) {
                    contentValues.put("imageBytesIn", Integer.valueOf(c42223k.fTd));
                }
                if ((c42223k.bJt & 64) != 0) {
                    contentValues.put("voiceCountIn", Integer.valueOf(c42223k.fTe));
                }
                if ((c42223k.bJt & 128) != 0) {
                    contentValues.put("voiceBytesIn", Integer.valueOf(c42223k.fTf));
                }
                if ((c42223k.bJt & 256) != 0) {
                    contentValues.put("videoCountIn", Integer.valueOf(c42223k.fTg));
                }
                if ((c42223k.bJt & 512) != 0) {
                    contentValues.put("videoBytesIn", Integer.valueOf(c42223k.fTh));
                }
                if ((c42223k.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    contentValues.put("mobileBytesIn", Integer.valueOf(c42223k.fTi));
                }
                if ((c42223k.bJt & 2048) != 0) {
                    contentValues.put("wifiBytesIn", Integer.valueOf(c42223k.fTj));
                }
                if ((c42223k.bJt & 4096) != 0) {
                    contentValues.put("sysMobileBytesIn", Integer.valueOf(c42223k.fTk));
                }
                if ((c42223k.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
                    contentValues.put("sysWifiBytesIn", Integer.valueOf(c42223k.fTl));
                }
                if ((c42223k.bJt & 16384) != 0) {
                    contentValues.put("textCountOut", Integer.valueOf(c42223k.fTm));
                }
                if ((c42223k.bJt & 32768) != 0) {
                    contentValues.put("textBytesOut", Integer.valueOf(c42223k.fTn));
                }
                if ((c42223k.bJt & 65536) != 0) {
                    contentValues.put("imageCountOut", Integer.valueOf(c42223k.fTo));
                }
                if ((c42223k.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                    contentValues.put("imageBytesOut", Integer.valueOf(c42223k.fTp));
                }
                if ((c42223k.bJt & 262144) != 0) {
                    contentValues.put("voiceCountOut", Integer.valueOf(c42223k.fTq));
                }
                if ((c42223k.bJt & SQLiteGlobal.journalSizeLimit) != 0) {
                    contentValues.put("voiceBytesOut", Integer.valueOf(c42223k.fTr));
                }
                if ((c42223k.bJt & 1048576) != 0) {
                    contentValues.put("videoCountOut", Integer.valueOf(c42223k.fTs));
                }
                if ((c42223k.bJt & 2097152) != 0) {
                    contentValues.put("videoBytesOut", Integer.valueOf(c42223k.fTt));
                }
                if ((c42223k.bJt & 4194304) != 0) {
                    contentValues.put("mobileBytesOut", Integer.valueOf(c42223k.fTu));
                }
                if ((c42223k.bJt & 8388608) != 0) {
                    contentValues.put("wifiBytesOut", Integer.valueOf(c42223k.fTv));
                }
                if ((c42223k.bJt & 16777216) != 0) {
                    contentValues.put("sysMobileBytesOut", Integer.valueOf(c42223k.fTw));
                }
                if ((c42223k.bJt & 33554432) != 0) {
                    contentValues.put("sysWifiBytesOut", Integer.valueOf(c42223k.fTx));
                }
                if ((c42223k.bJt & 67108864) != 0) {
                    contentValues.put("realMobileBytesIn", Integer.valueOf(c42223k.fTy));
                }
                if ((c42223k.bJt & 134217728) != 0) {
                    contentValues.put("realWifiBytesIn", Integer.valueOf(c42223k.fTz));
                }
                if ((c42223k.bJt & 268435456) != 0) {
                    contentValues.put("realMobileBytesOut", Integer.valueOf(c42223k.fTA));
                }
                if ((c42223k.bJt & 536870912) != 0) {
                    contentValues.put("realWifiBytesOut", Integer.valueOf(c42223k.fTB));
                }
                if (i2 < 0) {
                    c42223k.f17169id = (int) this.fni.insert("netstat", "id", contentValues);
                    AppMethodBeat.m2505o(78761);
                    return;
                }
                this.fni.update("netstat", contentValues, "peroid=".concat(String.valueOf(i)), null);
            }
        }
        AppMethodBeat.m2505o(78761);
    }

    public final void akn() {
        AppMethodBeat.m2504i(78762);
        if (this.fTL > 0) {
            this.fni.mo15640mB(this.fTL);
        }
        AppMethodBeat.m2505o(78762);
    }
}
