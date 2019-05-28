package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C29630d;
import com.tencent.p177mm.plugin.wallet_core.model.C43804af;
import com.tencent.p177mm.protocal.protobuf.C40553oq;
import com.tencent.p177mm.protocal.protobuf.azb;
import com.tencent.p177mm.protocal.protobuf.bfg;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.p */
public final class C22496p {
    public static final C22496p tfu = new C22496p();
    private static final String tfv = (C1761b.eSn + "wallet/lqt");
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
    public Vector<C22497a> tft = new Vector();

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.p$1 */
    class C43081 implements Runnable {
        C43081() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45246);
            Iterator it = C22496p.this.tft.iterator();
            while (it.hasNext()) {
                ((C22497a) it.next()).cMI();
            }
            AppMethodBeat.m2505o(45246);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.p$a */
    public interface C22497a {
        void cMI();
    }

    public C22496p() {
        AppMethodBeat.m2504i(45248);
        AppMethodBeat.m2505o(45248);
    }

    static {
        AppMethodBeat.m2504i(45260);
        AppMethodBeat.m2505o(45260);
    }

    /* renamed from: a */
    public final void mo38047a(azb azb, final boolean z) {
        AppMethodBeat.m2504i(45249);
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
            C4990ab.m7417i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", azb, Boolean.valueOf(z));
            try {
                final byte[] toByteArray = azb.toByteArray();
                C7305d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(45247);
                        if (toByteArray != null) {
                            C22496p.this.tfo.lock();
                            if (z) {
                                if (C5730e.m8628ct(C22496p.tfw)) {
                                    C5730e.m8618N(C22496p.tfw, true);
                                }
                                C5730e.m8643tf(C22496p.tfw);
                                C22496p.this.tfm = null;
                            } else {
                                if (C5730e.m8628ct(C22496p.tfx)) {
                                    C5730e.m8618N(C22496p.tfx, true);
                                }
                                C5730e.m8643tf(C22496p.tfx);
                                C22496p.this.tfn = null;
                            }
                            C22496p.this.tfo.unlock();
                            try {
                                String access$200;
                                String str = System.currentTimeMillis();
                                String str2 = "MicroMsg.LqtBindQueryInfoCache";
                                String str3 = "saveCacheToDisk, dir: %s, name: %s, save: %s";
                                Object[] objArr = new Object[3];
                                objArr[0] = z ? C22496p.tfw : C22496p.tfx;
                                objArr[1] = str;
                                objArr[2] = Boolean.valueOf(z);
                                C4990ab.m7417i(str2, str3, objArr);
                                long yz = C5046bo.m7588yz();
                                StringBuilder stringBuilder = new StringBuilder();
                                if (z) {
                                    access$200 = C22496p.tfw;
                                } else {
                                    access$200 = C22496p.tfx;
                                }
                                access$200 = stringBuilder.append(access$200).append(str).toString();
                                byte[] bArr = toByteArray;
                                C5730e.m8624b(access$200, bArr, bArr.length);
                                C4990ab.m7417i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", Long.valueOf(C5046bo.m7525az(yz)));
                                AppMethodBeat.m2505o(45247);
                                return;
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", e.getMessage());
                            }
                        }
                        AppMethodBeat.m2505o(45247);
                    }
                }, "LqtBindQueryInfoCache_saveCacheToDiski");
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", e.getMessage());
            }
            C5004al.m7441d(new C43081());
        }
        AppMethodBeat.m2505o(45249);
    }

    /* renamed from: a */
    public final void mo38048a(bfg bfg) {
        this.tfp = bfg.tfp;
        this.tfq = bfg.tfq;
        this.tfr = bfg.tfr;
        this.tfs = bfg.tfs;
    }

    /* renamed from: mH */
    public final boolean mo38052mH(boolean z) {
        AppMethodBeat.m2504i(45250);
        mo38055mL(z);
        azb azb = z ? this.tfi : this.tfj;
        if (azb != null) {
            C4990ab.m7417i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", Boolean.valueOf(azb.wCS));
            boolean z2 = azb.wCS;
            AppMethodBeat.m2505o(45250);
            return z2;
        }
        AppMethodBeat.m2505o(45250);
        return false;
    }

    /* renamed from: mI */
    public final Bankcard mo38053mI(boolean z) {
        AppMethodBeat.m2504i(45251);
        mo38055mL(z);
        azb azb = z ? this.tfi : this.tfj;
        if (!(azb == null || C5046bo.isNullOrNil(azb.wCO))) {
            List<Bankcard> mK = m34204mK(z);
            if (mK != null && mK.size() > 0) {
                String str = azb.wCO;
                if (!C5046bo.isNullOrNil(str)) {
                    for (Bankcard bankcard : mK) {
                        if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                            AppMethodBeat.m2505o(45251);
                            return bankcard;
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(45251);
        return null;
    }

    public final Bankcard cMF() {
        AppMethodBeat.m2504i(45252);
        mo38055mL(true);
        azb azb = this.tfi;
        if (azb != null) {
            Bankcard a = C43804af.m78517a(azb.wCQ);
            AppMethodBeat.m2505o(45252);
            return a;
        }
        AppMethodBeat.m2505o(45252);
        return null;
    }

    /* renamed from: mJ */
    public final List<Bankcard> mo38054mJ(boolean z) {
        AppMethodBeat.m2504i(45253);
        mo38055mL(z);
        if ((z ? this.tfi : this.tfj) != null) {
            List mK = m34204mK(z);
            AppMethodBeat.m2505o(45253);
            return mK;
        }
        AppMethodBeat.m2505o(45253);
        return null;
    }

    public final String cMG() {
        AppMethodBeat.m2504i(45254);
        mo38055mL(true);
        azb azb = this.tfi;
        String str;
        if (azb != null) {
            str = azb.wCU;
            AppMethodBeat.m2505o(45254);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(45254);
        return str;
    }

    public final int cMH() {
        AppMethodBeat.m2504i(45255);
        mo38055mL(true);
        azb azb = this.tfi;
        if (azb != null) {
            int i = azb.wCV;
            AppMethodBeat.m2505o(45255);
            return i;
        }
        AppMethodBeat.m2505o(45255);
        return 0;
    }

    /* renamed from: Ha */
    public static List<Bankcard> m34199Ha(int i) {
        AppMethodBeat.m2504i(45256);
        List mJ = tfu.mo38054mJ(i == 1);
        if (mJ == null || mJ.size() == 0) {
            C46332s.cNC();
            mJ = C46332s.cND().cQF();
        }
        LinkedList linkedList = new LinkedList();
        if (mJ != null) {
            for (Bankcard bankcard : mJ) {
                if (bankcard.cPc()) {
                    C46332s.cNC();
                    if (!C46332s.cND().cQi()) {
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
        AppMethodBeat.m2505o(45256);
        return linkedList;
    }

    /* renamed from: mK */
    private List<Bankcard> m34204mK(boolean z) {
        AppMethodBeat.m2504i(45257);
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
                AppMethodBeat.m2505o(45257);
                return null;
            }
            List<Bankcard> list;
            if (z) {
                if (this.tfm != null && this.tfm.size() > 0) {
                    list = this.tfm;
                    this.tfo.unlock();
                    AppMethodBeat.m2505o(45257);
                    return list;
                }
            } else if (this.tfn != null && this.tfn.size() > 0) {
                list = this.tfn;
                this.tfo.unlock();
                AppMethodBeat.m2505o(45257);
                return list;
            }
            Bankcard a;
            Iterator it;
            if (z) {
                this.tfm = new ArrayList();
                if (this.tfi.wCQ != null) {
                    a = C43804af.m78517a(this.tfi.wCQ);
                    if (a != null) {
                        this.tfm.add(a);
                    }
                }
                if (this.tfi.wmz != null && this.tfi.wmz.size() > 0) {
                    it = this.tfi.wmz.iterator();
                    while (it.hasNext()) {
                        a = C29630d.m46995a((C40553oq) it.next());
                        if (a != null) {
                            this.tfm.add(a);
                        }
                    }
                }
                list = this.tfm;
                this.tfo.unlock();
                AppMethodBeat.m2505o(45257);
                return list;
            }
            this.tfn = new ArrayList();
            if (this.tfj.wCQ != null) {
                a = C43804af.m78517a(this.tfj.wCQ);
                if (a != null) {
                    this.tfn.add(a);
                }
            }
            if (this.tfj.wmz != null && this.tfj.wmz.size() > 0) {
                it = this.tfj.wmz.iterator();
                while (it.hasNext()) {
                    a = C29630d.m46995a((C40553oq) it.next());
                    if (a != null) {
                        this.tfn.add(a);
                    }
                }
            }
            list = this.tfn;
            this.tfo.unlock();
            AppMethodBeat.m2505o(45257);
            return list;
        } catch (Throwable th) {
            this.tfo.unlock();
            AppMethodBeat.m2505o(45257);
        }
    }

    /* renamed from: mL */
    public final void mo38055mL(boolean z) {
        AppMethodBeat.m2504i(45258);
        long currentTimeMillis = System.currentTimeMillis();
        azb azb = z ? this.tfi : this.tfj;
        long j = z ? this.tfk : this.tfl;
        if (azb != null) {
            if (currentTimeMillis - j > 3600000) {
                C4990ab.m7416i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
                this.tfi = null;
                if (z) {
                    this.tfk = 0;
                } else {
                    this.tfl = 0;
                }
            }
            AppMethodBeat.m2505o(45258);
        }
        m34205mM(z);
        AppMethodBeat.m2505o(45258);
    }

    /* renamed from: mM */
    private void m34205mM(boolean z) {
        AppMethodBeat.m2504i(45259);
        String str = z ? tfw : tfx;
        List<C5712a> cl = C5730e.m8627cl(str, false);
        if (cl == null || cl.size() == 0) {
            AppMethodBeat.m2505o(45259);
            return;
        }
        C4990ab.m7417i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", cl, Boolean.valueOf(z));
        long currentTimeMillis = System.currentTimeMillis();
        for (C5712a c5712a : cl) {
            String str2 = c5712a.name;
            String str3 = str + str2;
            long j = C5046bo.getLong(str2, 0);
            C4990ab.m7417i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", Long.valueOf(j));
            if (j <= 0) {
                C5730e.deleteFile(str3);
            } else if (currentTimeMillis - j < 3600000) {
                byte[] e = C5730e.m8632e(str3, 0, -1);
                azb azb = new azb();
                try {
                    azb.parseFrom(e);
                } catch (IOException e2) {
                    azb = null;
                    C4990ab.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e2, "parse bindquery from cache error: %s", e2.getMessage());
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
                    C4990ab.m7417i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", azb, Long.valueOf(j));
                    AppMethodBeat.m2505o(45259);
                    return;
                }
            } else {
                C5730e.deleteFile(str3);
            }
        }
        AppMethodBeat.m2505o(45259);
    }
}
