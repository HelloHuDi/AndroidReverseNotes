package com.tencent.p177mm.plugin.translate.p1308a;

import android.util.SparseArray;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.protocal.protobuf.cis;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.translate.a.c */
public final class C36832c implements C35328a {
    public ArrayList<C22444a> eES;
    public int exv;
    public final C35330d[] sKw;
    public Queue<C36833c> sKx;
    public HashMap<String, Integer> sKy;

    /* renamed from: com.tencent.mm.plugin.translate.a.c$a */
    public interface C22444a {
        /* renamed from: a */
        void mo37993a(int i, SparseArray<C36833c> sparseArray);
    }

    /* renamed from: com.tencent.mm.plugin.translate.a.c$b */
    public static final class C29474b {
        public static final C36832c sKz = new C36832c();

        static {
            AppMethodBeat.m2504i(26061);
            AppMethodBeat.m2505o(26061);
        }
    }

    /* renamed from: com.tencent.mm.plugin.translate.a.c$c */
    public static class C36833c {
        private static int sKD = 0;
        public String cNS;
        public String cPG;
        public String cPz;
        public byte[] dJG;
        /* renamed from: id */
        public String f15476id;
        public int ret;
        public int sKA;
        public int sKB;
        public String sKC;
        public String source;
        public int type;

        public C36833c(String str, String str2, int i, String str3, byte[] bArr) {
            AppMethodBeat.m2504i(26062);
            this.cPz = str;
            this.f15476id = str2;
            this.type = i;
            this.source = str3;
            this.dJG = bArr;
            if (sKD == BaseClientBuilder.API_PRIORITY_OTHER) {
                sKD = 0;
            }
            int i2 = sKD + 1;
            sKD = i2;
            this.sKB = i2;
            if (i == 1) {
                i2 = C1829bf.m3761ox(str);
                if (i2 != -1) {
                    String trim = str.substring(0, i2).trim();
                    if (trim != null && trim.length() > 0) {
                        this.sKC = trim;
                        this.cPz = str.substring(i2 + 1).trim();
                    }
                }
            }
            AppMethodBeat.m2505o(26062);
        }
    }

    /* synthetic */ C36832c(byte b) {
        this();
    }

    private C36832c() {
        AppMethodBeat.m2504i(26063);
        this.exv = 0;
        this.eES = new ArrayList(1);
        this.sKx = new LinkedList();
        this.sKy = new HashMap();
        this.sKw = new C35330d[1];
        AppMethodBeat.m2505o(26063);
    }

    /* renamed from: b */
    private void m61232b(int i, SparseArray<C36833c> sparseArray) {
        AppMethodBeat.m2504i(26064);
        Iterator it = this.eES.iterator();
        while (it.hasNext()) {
            ((C22444a) it.next()).mo37993a(i, sparseArray);
        }
        AppMethodBeat.m2505o(26064);
    }

    public final void cHI() {
        int i = 0;
        AppMethodBeat.m2504i(26065);
        C4990ab.m7411d("MicroMsg.TranslateServiceManager", "current waitings : %s", Integer.valueOf(this.sKx.size()));
        if (this.sKx.size() == 0) {
            AppMethodBeat.m2505o(26065);
            return;
        }
        if (this.exv <= this.sKw.length) {
            while (i < this.sKw.length) {
                if (this.sKw[i] == null) {
                    this.sKw[i] = new C35330d(i, this);
                    this.sKw[i].init();
                }
                if (!this.sKw[i].sKF && this.sKw[i].mo56075e(this.sKx)) {
                    this.exv++;
                }
                i++;
            }
        }
        AppMethodBeat.m2505o(26065);
    }

    public final boolean abQ(String str) {
        AppMethodBeat.m2504i(26066);
        boolean containsKey = this.sKy.containsKey(str);
        AppMethodBeat.m2505o(26066);
        return containsKey;
    }

    /* renamed from: a */
    public final void mo56073a(int i, SparseArray<C36833c> sparseArray, LinkedList<cis> linkedList) {
        int i2;
        HashMap hashMap;
        AppMethodBeat.m2504i(26067);
        this.exv--;
        if (linkedList == null || sparseArray.size() != linkedList.size()) {
            C4990ab.m7410d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
            HashMap hashMap2 = new HashMap();
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                hashMap2.put(((C36833c) sparseArray.valueAt(i2)).f15476id, Integer.valueOf(((C36833c) sparseArray.valueAt(i2)).sKB));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        C36833c c36833c;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                cis cis = (cis) it.next();
                c36833c = (C36833c) sparseArray.get(cis.xhA);
                if (c36833c == null) {
                    C4990ab.m7421w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", Integer.valueOf(cis.xhA), Integer.valueOf(cis.Ret), C5046bo.anv(cis.xhD));
                } else {
                    String str = cis.xhD;
                    if (c36833c.type == 1) {
                        str = C1829bf.m3744al(str, c36833c.sKC);
                        c36833c.cPz = C1829bf.m3744al(c36833c.cPz, c36833c.sKC);
                    }
                    c36833c.cPG = str;
                    c36833c.ret = cis.Ret;
                    c36833c.cNS = cis.xhE;
                    byte[] bufferToBytes = (cis.wlw == null || cis.wlw.getBuffer() == null) ? null : cis.wlw.getBufferToBytes();
                    c36833c.dJG = bufferToBytes;
                    c36833c.sKA = cis.xhF;
                    this.sKy.remove(c36833c.f15476id);
                    if (hashMap != null) {
                        hashMap.remove(c36833c.f15476id);
                    }
                }
            }
        } else {
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                c36833c = (C36833c) sparseArray.valueAt(i2);
                if (c36833c.type == 1) {
                    c36833c.cPz = C1829bf.m3744al(c36833c.cPz, c36833c.sKC);
                }
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry key : hashMap.entrySet()) {
                this.sKy.remove(key.getKey());
                C4990ab.m7411d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", key.getKey(), key.getValue());
            }
        }
        m61232b(i, sparseArray);
        cHI();
        AppMethodBeat.m2505o(26067);
    }
}
