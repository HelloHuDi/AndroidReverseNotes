package com.tencent.p177mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.remittance.p1017a.C28850c;
import com.tencent.p177mm.plugin.remittance.p1410b.C46168c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.remittance.model.aa */
public final class C34808aa {
    public static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
    public Object lock;
    public HashSet<String> pQC;
    public HashMap<String, String> pQD;

    public C34808aa() {
        AppMethodBeat.m2504i(44794);
        this.pQC = null;
        this.pQD = new HashMap();
        this.pQC = new HashSet();
        this.lock = new Object();
        AppMethodBeat.m2505o(44794);
    }

    /* renamed from: VO */
    public final boolean mo55423VO(String str) {
        boolean contains;
        AppMethodBeat.m2504i(44795);
        synchronized (this.lock) {
            try {
                contains = this.pQC.contains(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(44795);
            }
        }
        return contains;
    }

    /* renamed from: VP */
    private synchronized boolean m57170VP(String str) {
        boolean z;
        AppMethodBeat.m2504i(44796);
        if (this.pQC.contains(str)) {
            C4990ab.m7416i(TAG, "it is a duplicate msg");
            z = false;
            AppMethodBeat.m2505o(44796);
        } else {
            z = this.pQC.add(str);
            AppMethodBeat.m2505o(44796);
        }
        return z;
    }

    /* renamed from: fN */
    public final boolean mo55425fN(String str, String str2) {
        AppMethodBeat.m2504i(44797);
        String str3 = (String) this.pQD.get(str);
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7421w(TAG, "empty transid: %s", str);
            AppMethodBeat.m2505o(44797);
            return false;
        }
        boolean Z = mo55424Z(str, str3, str2);
        AppMethodBeat.m2505o(44797);
        return Z;
    }

    /* renamed from: Z */
    public final boolean mo55424Z(String str, String str2, String str3) {
        AppMethodBeat.m2504i(44798);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            C4990ab.m7412e(TAG, "msgxml or toUserName or antiRepeatid is null");
            AppMethodBeat.m2505o(44798);
            return false;
        } else if (m57170VP(str)) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.setContent(str2);
            c7620bi.setStatus(2);
            c7620bi.mo14794ju(str3);
            c7620bi.mo14775eJ(C1829bf.m3756oC(str3));
            c7620bi.mo14781hO(1);
            c7620bi.setType(419430449);
            long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
            if (Z < 0) {
                C4990ab.m7412e(TAG, C1447g.m3075Mq() + "insert msg failed :" + Z);
                this.pQC.remove(str);
                AppMethodBeat.m2505o(44798);
                return false;
            }
            boolean b;
            c7620bi.setMsgId(Z);
            if (c7620bi.bAA()) {
                C45457b.fRa.mo73256a(c7620bi, C1191k.m2615k(c7620bi));
            } else {
                C45457b.fRa.mo73265j(c7620bi);
            }
            C8909j c8909j = new C8909j();
            c8909j.field_xml = c7620bi.field_content;
            String anj = C5046bo.anj(str2);
            C8910b c8910b = null;
            if (anj != null) {
                c8910b = C8910b.m16058X(anj, c7620bi.field_reserved);
                if (c8910b != null) {
                    c8909j.field_title = c8910b.title;
                    c8909j.field_description = c8910b.description;
                }
            }
            c8909j.field_type = 2000;
            c8909j.field_msgId = Z;
            C8909j ma = C34832a.bYK().mo27204ma(Z);
            if (ma == null || ma.field_msgId != Z) {
                b = C34832a.bYK().mo10101b((C4925c) c8909j);
                if (!b) {
                    C4990ab.m7412e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(Z)));
                }
            } else {
                b = C34832a.bYK().mo10103c(c8909j, new String[0]);
            }
            if (c8910b != null) {
                C46168c c46168c = new C46168c();
                c46168c.field_locaMsgId = c7620bi.field_msgId;
                c46168c.field_transferId = c8910b.fhy;
                c46168c.field_receiveStatus = -1;
                c46168c.field_isSend = true;
                C28850c.ceW();
                C28850c.ceY().mo62549a(c46168c);
            }
            AppMethodBeat.m2505o(44798);
            return b;
        } else {
            AppMethodBeat.m2505o(44798);
            return false;
        }
    }
}
