package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.HashSet;

public final class aa {
    public static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
    public Object lock;
    public HashSet<String> pQC;
    public HashMap<String, String> pQD;

    public aa() {
        AppMethodBeat.i(44794);
        this.pQC = null;
        this.pQD = new HashMap();
        this.pQC = new HashSet();
        this.lock = new Object();
        AppMethodBeat.o(44794);
    }

    public final boolean VO(String str) {
        boolean contains;
        AppMethodBeat.i(44795);
        synchronized (this.lock) {
            try {
                contains = this.pQC.contains(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(44795);
            }
        }
        return contains;
    }

    private synchronized boolean VP(String str) {
        boolean z;
        AppMethodBeat.i(44796);
        if (this.pQC.contains(str)) {
            ab.i(TAG, "it is a duplicate msg");
            z = false;
            AppMethodBeat.o(44796);
        } else {
            z = this.pQC.add(str);
            AppMethodBeat.o(44796);
        }
        return z;
    }

    public final boolean fN(String str, String str2) {
        AppMethodBeat.i(44797);
        String str3 = (String) this.pQD.get(str);
        if (bo.isNullOrNil(str3)) {
            ab.w(TAG, "empty transid: %s", str);
            AppMethodBeat.o(44797);
            return false;
        }
        boolean Z = Z(str, str3, str2);
        AppMethodBeat.o(44797);
        return Z;
    }

    public final boolean Z(String str, String str2, String str3) {
        AppMethodBeat.i(44798);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            ab.e(TAG, "msgxml or toUserName or antiRepeatid is null");
            AppMethodBeat.o(44798);
            return false;
        } else if (VP(str)) {
            bi biVar = new bi();
            biVar.setContent(str2);
            biVar.setStatus(2);
            biVar.ju(str3);
            biVar.eJ(bf.oC(str3));
            biVar.hO(1);
            biVar.setType(419430449);
            long Z = ((j) g.K(j.class)).bOr().Z(biVar);
            if (Z < 0) {
                ab.e(TAG, com.tencent.mm.compatible.util.g.Mq() + "insert msg failed :" + Z);
                this.pQC.remove(str);
                AppMethodBeat.o(44798);
                return false;
            }
            boolean b;
            biVar.setMsgId(Z);
            if (biVar.bAA()) {
                b.fRa.a(biVar, k.k(biVar));
            } else {
                b.fRa.j(biVar);
            }
            com.tencent.mm.af.j jVar = new com.tencent.mm.af.j();
            jVar.field_xml = biVar.field_content;
            String anj = bo.anj(str2);
            com.tencent.mm.af.j.b bVar = null;
            if (anj != null) {
                bVar = com.tencent.mm.af.j.b.X(anj, biVar.field_reserved);
                if (bVar != null) {
                    jVar.field_title = bVar.title;
                    jVar.field_description = bVar.description;
                }
            }
            jVar.field_type = 2000;
            jVar.field_msgId = Z;
            com.tencent.mm.af.j ma = a.bYK().ma(Z);
            if (ma == null || ma.field_msgId != Z) {
                b = a.bYK().b((c) jVar);
                if (!b) {
                    ab.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(Z)));
                }
            } else {
                b = a.bYK().c(jVar, new String[0]);
            }
            if (bVar != null) {
                com.tencent.mm.plugin.remittance.b.c cVar = new com.tencent.mm.plugin.remittance.b.c();
                cVar.field_locaMsgId = biVar.field_msgId;
                cVar.field_transferId = bVar.fhy;
                cVar.field_receiveStatus = -1;
                cVar.field_isSend = true;
                com.tencent.mm.plugin.remittance.a.c.ceW();
                com.tencent.mm.plugin.remittance.a.c.ceY().a(cVar);
            }
            AppMethodBeat.o(44798);
            return b;
        } else {
            AppMethodBeat.o(44798);
            return false;
        }
    }
}
