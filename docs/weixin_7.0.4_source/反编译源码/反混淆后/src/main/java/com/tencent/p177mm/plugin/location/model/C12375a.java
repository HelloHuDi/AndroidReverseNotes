package com.tencent.p177mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.modelgeo.C18657c;
import com.tencent.p177mm.modelgeo.C18657c.C18660a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.location.model.a */
public final class C12375a {

    /* renamed from: com.tencent.mm.plugin.location.model.a$a */
    public static class C12376a {
        Set<Long> nJC;
        private C18660a nJD = new C123771();

        /* renamed from: com.tencent.mm.plugin.location.model.a$a$1 */
        class C123771 implements C18660a {
            C123771() {
            }

            /* JADX WARNING: Missing block: B:21:0x007c, code skipped:
            if (r0.length() > 0) goto L_0x007e;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: b */
            public final void mo8746b(Addr addr) {
                AppMethodBeat.m2504i(113299);
                C12376a c12376a = C12376a.this;
                if (addr.tag != null && (addr.tag instanceof Long)) {
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(((Long) addr.tag).longValue());
                    if (!C5046bo.isNullOrNil(addr.fBg)) {
                        int i;
                        String trim;
                        Object obj;
                        String str = jf.field_content;
                        if (jf.field_isSend == 0) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        boolean kH = C1855t.m3896kH(jf.field_talker);
                        if (kH && i != 0) {
                            int ox = C1829bf.m3761ox(str);
                            if (ox != -1) {
                                str = str.substring(ox + 1).trim();
                            }
                        }
                        C5136b apD = C5136b.apD(str);
                        apD.label = addr.agv();
                        str = "";
                        if (kH && i != 0) {
                            i = C1829bf.m3761ox(jf.field_content);
                            if (i != -1) {
                                trim = jf.field_content.substring(0, i).trim();
                            }
                        }
                        trim = str;
                        if (apD.xZt == null || apD.xZt.equals("")) {
                            apD.xZt = "";
                        }
                        if (apD.xZs == null || apD.xZs.equals("")) {
                            apD.xZt = "";
                        }
                        if (apD.xZr == null || apD.xZr.equals("")) {
                            apD.xZr = "";
                        }
                        if (apD.svN == null || apD.svN.equals("")) {
                            apD.svN = "";
                        }
                        if (apD.label == null || apD.label.equals("")) {
                            apD.label = "";
                        }
                        if (apD.xZq == null || apD.xZq.equals("")) {
                            apD.xZq = "";
                        }
                        String str2 = "<msg><location x=\"" + apD.nJu + "\" y=\"" + apD.nJv + "\" scale=\"" + apD.cED + "\" label=\"" + apD.label + "\" maptype=\"" + apD.xZq + "\"  fromusername=\"" + apD.svN + "\" /></msg>";
                        if (!kH || trim.equals("")) {
                            trim = str2;
                        } else {
                            obj = trim + ":\n" + str2;
                        }
                        C4990ab.m7410d("MicroMsg.LocationServer", "xml: ".concat(String.valueOf(obj)));
                        jf.setContent(obj);
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(jf.field_msgId, jf);
                        c12376a.nJC.remove(Long.valueOf(jf.field_msgId));
                    }
                }
                AppMethodBeat.m2505o(113299);
            }
        }

        public C12376a() {
            AppMethodBeat.m2504i(113300);
            AppMethodBeat.m2505o(113300);
        }

        public final void bJq() {
            AppMethodBeat.m2504i(113301);
            if (this.nJC != null) {
                this.nJC.clear();
            }
            C18657c.agw().mo33925a(this.nJD);
            AppMethodBeat.m2505o(113301);
        }

        /* renamed from: W */
        public final String[] mo24226W(C7620bi c7620bi) {
            int i = 1;
            AppMethodBeat.m2504i(113302);
            String[] strArr = new String[2];
            String str = c7620bi.field_content;
            if (C5046bo.isNullOrNil(str)) {
                strArr[0] = "";
                strArr[1] = "";
                AppMethodBeat.m2505o(113302);
                return strArr;
            }
            int i2;
            String str2;
            if (c7620bi.field_isSend == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (C1855t.m3896kH(c7620bi.field_talker) && i2 != 0) {
                i2 = C1829bf.m3761ox(str);
                if (i2 != -1) {
                    str = str.substring(i2 + 1).trim();
                }
            }
            C5136b Ro = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15261Ro(str);
            if (Ro.dua()) {
                str = Ro.label;
                str2 = Ro.eUu;
                strArr[0] = str;
                strArr[1] = str2;
            } else {
                strArr[0] = Ro.label;
                strArr[1] = "";
            }
            if (C5046bo.isNullOrNil(strArr[0]) && C5046bo.isNullOrNil(strArr[1])) {
                C4990ab.m7416i("MicroMsg.LocationServer", "pull from sever");
                long j = c7620bi.field_msgId;
                if (!(this.nJC == null || this.nJC.contains(Long.valueOf(j)))) {
                    str2 = c7620bi.field_content;
                    if (c7620bi.field_isSend != 0) {
                        i = 0;
                    }
                    if (C1855t.m3896kH(c7620bi.field_talker) && i != 0) {
                        i = C1829bf.m3761ox(str2);
                        if (i != -1) {
                            str2 = str2.substring(i + 1).trim();
                        }
                    }
                    Ro = C5136b.apD(str2);
                    this.nJC.add(Long.valueOf(j));
                    C18657c.agw().mo33924a(Ro.nJu, Ro.nJv, this.nJD, Long.valueOf(c7620bi.field_msgId));
                }
            }
            AppMethodBeat.m2505o(113302);
            return strArr;
        }
    }
}
