package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public final class c implements a {
    public ArrayList<a> eES;
    public int exv;
    public final d[] sKw;
    public Queue<c> sKx;
    public HashMap<String, Integer> sKy;

    public interface a {
        void a(int i, SparseArray<c> sparseArray);
    }

    public static final class b {
        public static final c sKz = new c();

        static {
            AppMethodBeat.i(26061);
            AppMethodBeat.o(26061);
        }
    }

    public static class c {
        private static int sKD = 0;
        public String cNS;
        public String cPG;
        public String cPz;
        public byte[] dJG;
        public String id;
        public int ret;
        public int sKA;
        public int sKB;
        public String sKC;
        public String source;
        public int type;

        public c(String str, String str2, int i, String str3, byte[] bArr) {
            AppMethodBeat.i(26062);
            this.cPz = str;
            this.id = str2;
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
                i2 = bf.ox(str);
                if (i2 != -1) {
                    String trim = str.substring(0, i2).trim();
                    if (trim != null && trim.length() > 0) {
                        this.sKC = trim;
                        this.cPz = str.substring(i2 + 1).trim();
                    }
                }
            }
            AppMethodBeat.o(26062);
        }
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        AppMethodBeat.i(26063);
        this.exv = 0;
        this.eES = new ArrayList(1);
        this.sKx = new LinkedList();
        this.sKy = new HashMap();
        this.sKw = new d[1];
        AppMethodBeat.o(26063);
    }

    private void b(int i, SparseArray<c> sparseArray) {
        AppMethodBeat.i(26064);
        Iterator it = this.eES.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i, sparseArray);
        }
        AppMethodBeat.o(26064);
    }

    public final void cHI() {
        int i = 0;
        AppMethodBeat.i(26065);
        ab.d("MicroMsg.TranslateServiceManager", "current waitings : %s", Integer.valueOf(this.sKx.size()));
        if (this.sKx.size() == 0) {
            AppMethodBeat.o(26065);
            return;
        }
        if (this.exv <= this.sKw.length) {
            while (i < this.sKw.length) {
                if (this.sKw[i] == null) {
                    this.sKw[i] = new d(i, this);
                    this.sKw[i].init();
                }
                if (!this.sKw[i].sKF && this.sKw[i].e(this.sKx)) {
                    this.exv++;
                }
                i++;
            }
        }
        AppMethodBeat.o(26065);
    }

    public final boolean abQ(String str) {
        AppMethodBeat.i(26066);
        boolean containsKey = this.sKy.containsKey(str);
        AppMethodBeat.o(26066);
        return containsKey;
    }

    public final void a(int i, SparseArray<c> sparseArray, LinkedList<cis> linkedList) {
        int i2;
        HashMap hashMap;
        AppMethodBeat.i(26067);
        this.exv--;
        if (linkedList == null || sparseArray.size() != linkedList.size()) {
            ab.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
            HashMap hashMap2 = new HashMap();
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                hashMap2.put(((c) sparseArray.valueAt(i2)).id, Integer.valueOf(((c) sparseArray.valueAt(i2)).sKB));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        c cVar;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                cis cis = (cis) it.next();
                cVar = (c) sparseArray.get(cis.xhA);
                if (cVar == null) {
                    ab.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", Integer.valueOf(cis.xhA), Integer.valueOf(cis.Ret), bo.anv(cis.xhD));
                } else {
                    String str = cis.xhD;
                    if (cVar.type == 1) {
                        str = bf.al(str, cVar.sKC);
                        cVar.cPz = bf.al(cVar.cPz, cVar.sKC);
                    }
                    cVar.cPG = str;
                    cVar.ret = cis.Ret;
                    cVar.cNS = cis.xhE;
                    byte[] bufferToBytes = (cis.wlw == null || cis.wlw.getBuffer() == null) ? null : cis.wlw.getBufferToBytes();
                    cVar.dJG = bufferToBytes;
                    cVar.sKA = cis.xhF;
                    this.sKy.remove(cVar.id);
                    if (hashMap != null) {
                        hashMap.remove(cVar.id);
                    }
                }
            }
        } else {
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                cVar = (c) sparseArray.valueAt(i2);
                if (cVar.type == 1) {
                    cVar.cPz = bf.al(cVar.cPz, cVar.sKC);
                }
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry key : hashMap.entrySet()) {
                this.sKy.remove(key.getKey());
                ab.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", key.getKey(), key.getValue());
            }
        }
        b(i, sparseArray);
        cHI();
        AppMethodBeat.o(26067);
    }
}
