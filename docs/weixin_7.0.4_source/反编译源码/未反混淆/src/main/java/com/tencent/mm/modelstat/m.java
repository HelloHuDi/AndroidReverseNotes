package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bb.b;
import com.tencent.mm.sdk.platformtools.bb.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashSet;
import junit.framework.Assert;

public final class m extends k implements c<Integer, k> {
    private static final String[] fTO = new String[]{"realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut"};
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) "};
    private long fTL;
    public bb<Integer, k> fTM = new bb(this, g.RS().oAl.getLooper(), 30, 2);
    private long fTN;
    public h fni;

    public m(h hVar) {
        int i = 0;
        AppMethodBeat.i(78753);
        this.fni = hVar;
        HashSet hashSet = new HashSet();
        for (Object add : fTO) {
            hashSet.add(add);
        }
        Cursor a = this.fni.a("PRAGMA table_info(netstat);", null, 2);
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
                this.fni.hY("netstat", "ALTER TABLE netstat ADD COLUMN " + obj + " INT;");
            }
            i++;
        }
        this.fTN = System.currentTimeMillis();
        AppMethodBeat.o(78753);
    }

    public final k md(int i) {
        AppMethodBeat.i(78754);
        k kVar = (k) this.fTM.get(Integer.valueOf(i));
        if (kVar == null) {
            Cursor a = this.fni.a("netstat", null, "peroid = ".concat(String.valueOf(i)), null, null, null, null, 2);
            if (a.moveToFirst()) {
                kVar = new k();
                kVar.d(a);
            }
            a.close();
            if (kVar != null) {
                this.fTM.A(Integer.valueOf(i), kVar);
            } else {
                bb bbVar = this.fTM;
                Integer valueOf = Integer.valueOf(i);
                k kVar2 = new k();
                kVar2.bJt = 0;
                kVar2.id = 0;
                kVar2.fSZ = 0;
                kVar2.fTa = 0;
                kVar2.fTb = 0;
                kVar2.fTc = 0;
                kVar2.fTd = 0;
                kVar2.fTe = 0;
                kVar2.fTf = 0;
                kVar2.fTg = 0;
                kVar2.fTh = 0;
                kVar2.fTi = 0;
                kVar2.fTj = 0;
                kVar2.fTk = 0;
                kVar2.fTl = 0;
                kVar2.fTm = 0;
                kVar2.fTn = 0;
                kVar2.fTo = 0;
                kVar2.fTp = 0;
                kVar2.fTq = 0;
                kVar2.fTr = 0;
                kVar2.fTs = 0;
                kVar2.fTt = 0;
                kVar2.fTu = 0;
                kVar2.fTv = 0;
                kVar2.fTw = 0;
                kVar2.fTx = 0;
                kVar2.fTy = 0;
                kVar2.fTz = 0;
                kVar2.fTA = 0;
                kVar2.fTB = 0;
                bbVar.A(valueOf, kVar2);
            }
        } else if (kVar.fSZ != i) {
            kVar = null;
        }
        AppMethodBeat.o(78754);
        return kVar;
    }

    public final void a(k kVar) {
        AppMethodBeat.i(78755);
        Assert.assertNotNull(kVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (kVar.fSZ <= 0) {
            kVar.fSZ = (int) (currentTimeMillis / 86400000);
        }
        if (kVar.fSZ <= 0) {
            AppMethodBeat.o(78755);
            return;
        }
        k md = md(kVar.fSZ);
        if (md == null || kVar.fSZ != md.fSZ) {
            kVar.bJt |= 2;
            kVar.id = -1;
            if (md != null) {
                ab.i("MicroMsg.NetStat", md.toString());
            } else {
                ab.i("MicroMsg.NetStat", "NetStat started.");
            }
        } else {
            kVar.bJt = md.bJt | 1;
            kVar.fTa += md.fTb;
            kVar.fTb += md.fTb;
            kVar.fTc += md.fTd;
            kVar.fTd += md.fTd;
            kVar.fTe += md.fTe;
            kVar.fTf += md.fTf;
            kVar.fTg += md.fTg;
            kVar.fTh += md.fTh;
            kVar.fTi += md.fTi;
            kVar.fTj += md.fTj;
            kVar.fTk += md.fTk;
            kVar.fTl += md.fTl;
            kVar.fTm += md.fTn;
            kVar.fTn += md.fTn;
            kVar.fTo += md.fTp;
            kVar.fTp += md.fTp;
            kVar.fTq += md.fTq;
            kVar.fTr += md.fTr;
            kVar.fTs += md.fTs;
            kVar.fTt += md.fTt;
            kVar.fTu += md.fTu;
            kVar.fTv += md.fTv;
            kVar.fTw += md.fTw;
            kVar.fTx += md.fTx;
            kVar.fTy += md.fTy;
            kVar.fTz += md.fTz;
            kVar.fTA += md.fTA;
            kVar.fTB += md.fTB;
            kVar.id = md.id;
            if (currentTimeMillis - this.fTN > 300000) {
                ab.i("MicroMsg.NetStat", kVar.toString());
            }
            b(kVar);
            AppMethodBeat.o(78755);
        }
        this.fTN = currentTimeMillis;
        b(kVar);
        AppMethodBeat.o(78755);
    }

    public final boolean b(k kVar) {
        AppMethodBeat.i(78756);
        Assert.assertNotNull(kVar);
        Assert.assertTrue(kVar.fSZ > 0);
        boolean A = this.fTM.A(Integer.valueOf(kVar.fSZ), kVar);
        AppMethodBeat.o(78756);
        return A;
    }

    public final void akk() {
        AppMethodBeat.i(78757);
        int dpB = (int) (bo.dpB() / 86400000);
        if (md(dpB) != null) {
            AppMethodBeat.o(78757);
            return;
        }
        k kVar = new k();
        kVar.fSZ = dpB;
        kVar.id = -1;
        b(kVar);
        AppMethodBeat.o(78757);
    }

    public final long akl() {
        AppMethodBeat.i(78758);
        this.fTM.pl(true);
        int dpB = (int) (bo.dpB() / 86400000);
        Cursor a = this.fni.a("SELECT peroid FROM netstat  WHERE peroid > " + ((int) ((bo.anU() - 1296000000) / 86400000)) + " order by peroid limit 1", null, 2);
        if (a.moveToFirst()) {
            dpB = a.getInt(a.getColumnIndex("peroid"));
        }
        a.close();
        long j = ((long) dpB) * 86400000;
        AppMethodBeat.o(78758);
        return j;
    }

    public final k me(int i) {
        k kVar = null;
        AppMethodBeat.i(78759);
        this.fTM.pl(true);
        Cursor a = this.fni.a("SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(i)), null, 2);
        if (a.moveToFirst()) {
            kVar = new k();
            kVar.d(a);
        }
        a.close();
        AppMethodBeat.o(78759);
        return kVar;
    }

    public final boolean akm() {
        AppMethodBeat.i(78760);
        if (this.fni.inTransaction()) {
            ab.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
            AppMethodBeat.o(78760);
            return false;
        }
        this.fTL = this.fni.iV(Thread.currentThread().getId());
        if (this.fTL <= 0) {
            ab.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.fTL + " return false");
            AppMethodBeat.o(78760);
            return false;
        }
        AppMethodBeat.o(78760);
        return true;
    }

    public final void a(b<Integer, k> bVar) {
        AppMethodBeat.i(78761);
        int i = bVar.xBj;
        k kVar = (k) bVar.values;
        if (kVar != null && i == 1) {
            i = kVar.fSZ;
            int i2 = kVar.id;
            if (i > 0) {
                ContentValues contentValues = new ContentValues();
                if ((kVar.bJt & 2) != 0) {
                    contentValues.put("peroid", Integer.valueOf(kVar.fSZ));
                }
                if ((kVar.bJt & 4) != 0) {
                    contentValues.put("textCountIn", Integer.valueOf(kVar.fTa));
                }
                if ((kVar.bJt & 8) != 0) {
                    contentValues.put("textBytesIn", Integer.valueOf(kVar.fTb));
                }
                if ((kVar.bJt & 16) != 0) {
                    contentValues.put("imageCountIn", Integer.valueOf(kVar.fTc));
                }
                if ((kVar.bJt & 32) != 0) {
                    contentValues.put("imageBytesIn", Integer.valueOf(kVar.fTd));
                }
                if ((kVar.bJt & 64) != 0) {
                    contentValues.put("voiceCountIn", Integer.valueOf(kVar.fTe));
                }
                if ((kVar.bJt & 128) != 0) {
                    contentValues.put("voiceBytesIn", Integer.valueOf(kVar.fTf));
                }
                if ((kVar.bJt & 256) != 0) {
                    contentValues.put("videoCountIn", Integer.valueOf(kVar.fTg));
                }
                if ((kVar.bJt & 512) != 0) {
                    contentValues.put("videoBytesIn", Integer.valueOf(kVar.fTh));
                }
                if ((kVar.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    contentValues.put("mobileBytesIn", Integer.valueOf(kVar.fTi));
                }
                if ((kVar.bJt & 2048) != 0) {
                    contentValues.put("wifiBytesIn", Integer.valueOf(kVar.fTj));
                }
                if ((kVar.bJt & 4096) != 0) {
                    contentValues.put("sysMobileBytesIn", Integer.valueOf(kVar.fTk));
                }
                if ((kVar.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
                    contentValues.put("sysWifiBytesIn", Integer.valueOf(kVar.fTl));
                }
                if ((kVar.bJt & 16384) != 0) {
                    contentValues.put("textCountOut", Integer.valueOf(kVar.fTm));
                }
                if ((kVar.bJt & 32768) != 0) {
                    contentValues.put("textBytesOut", Integer.valueOf(kVar.fTn));
                }
                if ((kVar.bJt & 65536) != 0) {
                    contentValues.put("imageCountOut", Integer.valueOf(kVar.fTo));
                }
                if ((kVar.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                    contentValues.put("imageBytesOut", Integer.valueOf(kVar.fTp));
                }
                if ((kVar.bJt & 262144) != 0) {
                    contentValues.put("voiceCountOut", Integer.valueOf(kVar.fTq));
                }
                if ((kVar.bJt & SQLiteGlobal.journalSizeLimit) != 0) {
                    contentValues.put("voiceBytesOut", Integer.valueOf(kVar.fTr));
                }
                if ((kVar.bJt & 1048576) != 0) {
                    contentValues.put("videoCountOut", Integer.valueOf(kVar.fTs));
                }
                if ((kVar.bJt & 2097152) != 0) {
                    contentValues.put("videoBytesOut", Integer.valueOf(kVar.fTt));
                }
                if ((kVar.bJt & 4194304) != 0) {
                    contentValues.put("mobileBytesOut", Integer.valueOf(kVar.fTu));
                }
                if ((kVar.bJt & 8388608) != 0) {
                    contentValues.put("wifiBytesOut", Integer.valueOf(kVar.fTv));
                }
                if ((kVar.bJt & 16777216) != 0) {
                    contentValues.put("sysMobileBytesOut", Integer.valueOf(kVar.fTw));
                }
                if ((kVar.bJt & 33554432) != 0) {
                    contentValues.put("sysWifiBytesOut", Integer.valueOf(kVar.fTx));
                }
                if ((kVar.bJt & 67108864) != 0) {
                    contentValues.put("realMobileBytesIn", Integer.valueOf(kVar.fTy));
                }
                if ((kVar.bJt & 134217728) != 0) {
                    contentValues.put("realWifiBytesIn", Integer.valueOf(kVar.fTz));
                }
                if ((kVar.bJt & 268435456) != 0) {
                    contentValues.put("realMobileBytesOut", Integer.valueOf(kVar.fTA));
                }
                if ((kVar.bJt & 536870912) != 0) {
                    contentValues.put("realWifiBytesOut", Integer.valueOf(kVar.fTB));
                }
                if (i2 < 0) {
                    kVar.id = (int) this.fni.insert("netstat", "id", contentValues);
                    AppMethodBeat.o(78761);
                    return;
                }
                this.fni.update("netstat", contentValues, "peroid=".concat(String.valueOf(i)), null);
            }
        }
        AppMethodBeat.o(78761);
    }

    public final void akn() {
        AppMethodBeat.i(78762);
        if (this.fTL > 0) {
            this.fni.mB(this.fTL);
        }
        AppMethodBeat.o(78762);
    }
}
