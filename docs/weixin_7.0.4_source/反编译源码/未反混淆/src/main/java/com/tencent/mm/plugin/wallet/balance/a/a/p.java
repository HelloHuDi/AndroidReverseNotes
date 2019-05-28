package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public final class p {
    public static final p tfu = new p();
    private static final String tfv = (b.eSn + "wallet/lqt");
    private static final String tfw = (tfv + "/save/");
    private static final String tfx = (tfv + "/fetch/");
    public azb tfi;
    public azb tfj;
    private long tfk;
    private long tfl;
    private List<Bankcard> tfm;
    private List<Bankcard> tfn;
    private ReentrantLock tfo = new ReentrantLock();
    public String tfp;
    public String tfq;
    public String tfr;
    public int tfs;
    public Vector<a> tft = new Vector();

    public interface a {
        void cMI();
    }

    public p() {
        AppMethodBeat.i(45248);
        AppMethodBeat.o(45248);
    }

    static {
        AppMethodBeat.i(45260);
        AppMethodBeat.o(45260);
    }

    public final void a(azb azb, final boolean z) {
        AppMethodBeat.i(45249);
        if (azb != null) {
            this.tfo.lock();
            if (z) {
                this.tfi = azb;
                this.tfm = null;
                this.tfk = System.currentTimeMillis();
            } else {
                this.tfj = azb;
                this.tfn = null;
                this.tfl = System.currentTimeMillis();
            }
            this.tfo.unlock();
            ab.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", azb, Boolean.valueOf(z));
            try {
                final byte[] toByteArray = azb.toByteArray();
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(45247);
                        if (toByteArray != null) {
                            p.this.tfo.lock();
                            if (z) {
                                if (e.ct(p.tfw)) {
                                    e.N(p.tfw, true);
                                }
                                e.tf(p.tfw);
                                p.this.tfm = null;
                            } else {
                                if (e.ct(p.tfx)) {
                                    e.N(p.tfx, true);
                                }
                                e.tf(p.tfx);
                                p.this.tfn = null;
                            }
                            p.this.tfo.unlock();
                            try {
                                String access$200;
                                String str = System.currentTimeMillis();
                                String str2 = "MicroMsg.LqtBindQueryInfoCache";
                                String str3 = "saveCacheToDisk, dir: %s, name: %s, save: %s";
                                Object[] objArr = new Object[3];
                                objArr[0] = z ? p.tfw : p.tfx;
                                objArr[1] = str;
                                objArr[2] = Boolean.valueOf(z);
                                ab.i(str2, str3, objArr);
                                long yz = bo.yz();
                                StringBuilder stringBuilder = new StringBuilder();
                                if (z) {
                                    access$200 = p.tfw;
                                } else {
                                    access$200 = p.tfx;
                                }
                                access$200 = stringBuilder.append(access$200).append(str).toString();
                                byte[] bArr = toByteArray;
                                e.b(access$200, bArr, bArr.length);
                                ab.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", Long.valueOf(bo.az(yz)));
                                AppMethodBeat.o(45247);
                                return;
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", e.getMessage());
                            }
                        }
                        AppMethodBeat.o(45247);
                    }
                }, "LqtBindQueryInfoCache_saveCacheToDiski");
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", e.getMessage());
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(45246);
                    Iterator it = p.this.tft.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).cMI();
                    }
                    AppMethodBeat.o(45246);
                }
            });
        }
        AppMethodBeat.o(45249);
    }

    public final void a(bfg bfg) {
        this.tfp = bfg.tfp;
        this.tfq = bfg.tfq;
        this.tfr = bfg.tfr;
        this.tfs = bfg.tfs;
    }

    public final boolean mH(boolean z) {
        AppMethodBeat.i(45250);
        mL(z);
        azb azb = z ? this.tfi : this.tfj;
        if (azb != null) {
            ab.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", Boolean.valueOf(azb.wCS));
            boolean z2 = azb.wCS;
            AppMethodBeat.o(45250);
            return z2;
        }
        AppMethodBeat.o(45250);
        return false;
    }

    public final Bankcard mI(boolean z) {
        AppMethodBeat.i(45251);
        mL(z);
        azb azb = z ? this.tfi : this.tfj;
        if (!(azb == null || bo.isNullOrNil(azb.wCO))) {
            List<Bankcard> mK = mK(z);
            if (mK != null && mK.size() > 0) {
                String str = azb.wCO;
                if (!bo.isNullOrNil(str)) {
                    for (Bankcard bankcard : mK) {
                        if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                            AppMethodBeat.o(45251);
                            return bankcard;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(45251);
        return null;
    }

    public final Bankcard cMF() {
        AppMethodBeat.i(45252);
        mL(true);
        azb azb = this.tfi;
        if (azb != null) {
            Bankcard a = af.a(azb.wCQ);
            AppMethodBeat.o(45252);
            return a;
        }
        AppMethodBeat.o(45252);
        return null;
    }

    public final List<Bankcard> mJ(boolean z) {
        AppMethodBeat.i(45253);
        mL(z);
        if ((z ? this.tfi : this.tfj) != null) {
            List mK = mK(z);
            AppMethodBeat.o(45253);
            return mK;
        }
        AppMethodBeat.o(45253);
        return null;
    }

    public final String cMG() {
        AppMethodBeat.i(45254);
        mL(true);
        azb azb = this.tfi;
        String str;
        if (azb != null) {
            str = azb.wCU;
            AppMethodBeat.o(45254);
            return str;
        }
        str = "";
        AppMethodBeat.o(45254);
        return str;
    }

    public final int cMH() {
        AppMethodBeat.i(45255);
        mL(true);
        azb azb = this.tfi;
        if (azb != null) {
            int i = azb.wCV;
            AppMethodBeat.o(45255);
            return i;
        }
        AppMethodBeat.o(45255);
        return 0;
    }

    public static List<Bankcard> Ha(int i) {
        AppMethodBeat.i(45256);
        List mJ = tfu.mJ(i == 1);
        if (mJ == null || mJ.size() == 0) {
            s.cNC();
            mJ = s.cND().cQF();
        }
        LinkedList linkedList = new LinkedList();
        if (mJ != null) {
            for (Bankcard bankcard : mJ) {
                if (bankcard.cPc()) {
                    s.cNC();
                    if (!s.cND().cQi()) {
                        linkedList.add(bankcard);
                    }
                }
                if (i == 1 && (bankcard.field_support_lqt_turn_in == 1 || bankcard.cPc())) {
                    linkedList.add(bankcard);
                }
                if (i == 2 && (bankcard.field_support_lqt_turn_out == 1 || bankcard.cPc())) {
                    linkedList.add(bankcard);
                }
            }
        }
        AppMethodBeat.o(45256);
        return linkedList;
    }

    private List<Bankcard> mK(boolean z) {
        AppMethodBeat.i(45257);
        azb azb = z ? this.tfi : this.tfj;
        try {
            this.tfo.lock();
            if (azb == null) {
                if (z) {
                    this.tfm = null;
                } else {
                    this.tfn = null;
                }
                this.tfo.unlock();
                AppMethodBeat.o(45257);
                return null;
            }
            List<Bankcard> list;
            if (z) {
                if (this.tfm != null && this.tfm.size() > 0) {
                    list = this.tfm;
                    this.tfo.unlock();
                    AppMethodBeat.o(45257);
                    return list;
                }
            } else if (this.tfn != null && this.tfn.size() > 0) {
                list = this.tfn;
                this.tfo.unlock();
                AppMethodBeat.o(45257);
                return list;
            }
            Bankcard a;
            Iterator it;
            if (z) {
                this.tfm = new ArrayList();
                if (this.tfi.wCQ != null) {
                    a = af.a(this.tfi.wCQ);
                    if (a != null) {
                        this.tfm.add(a);
                    }
                }
                if (this.tfi.wmz != null && this.tfi.wmz.size() > 0) {
                    it = this.tfi.wmz.iterator();
                    while (it.hasNext()) {
                        a = com.tencent.mm.plugin.wallet_core.model.d.a((oq) it.next());
                        if (a != null) {
                            this.tfm.add(a);
                        }
                    }
                }
                list = this.tfm;
                this.tfo.unlock();
                AppMethodBeat.o(45257);
                return list;
            }
            this.tfn = new ArrayList();
            if (this.tfj.wCQ != null) {
                a = af.a(this.tfj.wCQ);
                if (a != null) {
                    this.tfn.add(a);
                }
            }
            if (this.tfj.wmz != null && this.tfj.wmz.size() > 0) {
                it = this.tfj.wmz.iterator();
                while (it.hasNext()) {
                    a = com.tencent.mm.plugin.wallet_core.model.d.a((oq) it.next());
                    if (a != null) {
                        this.tfn.add(a);
                    }
                }
            }
            list = this.tfn;
            this.tfo.unlock();
            AppMethodBeat.o(45257);
            return list;
        } catch (Throwable th) {
            this.tfo.unlock();
            AppMethodBeat.o(45257);
        }
    }

    public final void mL(boolean z) {
        AppMethodBeat.i(45258);
        long currentTimeMillis = System.currentTimeMillis();
        azb azb = z ? this.tfi : this.tfj;
        long j = z ? this.tfk : this.tfl;
        if (azb != null) {
            if (currentTimeMillis - j > 3600000) {
                ab.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
                this.tfi = null;
                if (z) {
                    this.tfk = 0;
                } else {
                    this.tfl = 0;
                }
            }
            AppMethodBeat.o(45258);
        }
        mM(z);
        AppMethodBeat.o(45258);
    }

    private void mM(boolean z) {
        AppMethodBeat.i(45259);
        String str = z ? tfw : tfx;
        List<com.tencent.mm.vfs.FileSystem.a> cl = e.cl(str, false);
        if (cl == null || cl.size() == 0) {
            AppMethodBeat.o(45259);
            return;
        }
        ab.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", cl, Boolean.valueOf(z));
        long currentTimeMillis = System.currentTimeMillis();
        for (com.tencent.mm.vfs.FileSystem.a aVar : cl) {
            String str2 = aVar.name;
            String str3 = str + str2;
            long j = bo.getLong(str2, 0);
            ab.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", Long.valueOf(j));
            if (j <= 0) {
                e.deleteFile(str3);
            } else if (currentTimeMillis - j < 3600000) {
                byte[] e = e.e(str3, 0, -1);
                azb azb = new azb();
                try {
                    azb.parseFrom(e);
                } catch (IOException e2) {
                    azb = null;
                    ab.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e2, "parse bindquery from cache error: %s", e2.getMessage());
                }
                if (azb != null) {
                    this.tfo.lock();
                    if (z) {
                        this.tfi = azb;
                        this.tfm = null;
                        this.tfk = j;
                    } else {
                        this.tfj = azb;
                        this.tfn = null;
                        this.tfl = j;
                    }
                    this.tfo.unlock();
                    ab.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", azb, Long.valueOf(j));
                    AppMethodBeat.o(45259);
                    return;
                }
            } else {
                e.deleteFile(str3);
            }
        }
        AppMethodBeat.o(45259);
    }
}
