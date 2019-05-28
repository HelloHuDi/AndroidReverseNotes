package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.util.Set;

public final class a {

    public static class a {
        Set<Long> nJC;
        private com.tencent.mm.modelgeo.c.a nJD = new com.tencent.mm.modelgeo.c.a() {
            /* JADX WARNING: Missing block: B:21:0x007c, code skipped:
            if (r0.length() > 0) goto L_0x007e;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void b(Addr addr) {
                AppMethodBeat.i(113299);
                a aVar = a.this;
                if (addr.tag != null && (addr.tag instanceof Long)) {
                    bi jf = ((j) g.K(j.class)).bOr().jf(((Long) addr.tag).longValue());
                    if (!bo.isNullOrNil(addr.fBg)) {
                        int i;
                        String trim;
                        Object obj;
                        String str = jf.field_content;
                        if (jf.field_isSend == 0) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        boolean kH = t.kH(jf.field_talker);
                        if (kH && i != 0) {
                            int ox = bf.ox(str);
                            if (ox != -1) {
                                str = str.substring(ox + 1).trim();
                            }
                        }
                        b apD = b.apD(str);
                        apD.label = addr.agv();
                        str = "";
                        if (kH && i != 0) {
                            i = bf.ox(jf.field_content);
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
                        ab.d("MicroMsg.LocationServer", "xml: ".concat(String.valueOf(obj)));
                        jf.setContent(obj);
                        ((j) g.K(j.class)).bOr().a(jf.field_msgId, jf);
                        aVar.nJC.remove(Long.valueOf(jf.field_msgId));
                    }
                }
                AppMethodBeat.o(113299);
            }
        };

        public a() {
            AppMethodBeat.i(113300);
            AppMethodBeat.o(113300);
        }

        public final void bJq() {
            AppMethodBeat.i(113301);
            if (this.nJC != null) {
                this.nJC.clear();
            }
            c.agw().a(this.nJD);
            AppMethodBeat.o(113301);
        }

        public final String[] W(bi biVar) {
            int i = 1;
            AppMethodBeat.i(113302);
            String[] strArr = new String[2];
            String str = biVar.field_content;
            if (bo.isNullOrNil(str)) {
                strArr[0] = "";
                strArr[1] = "";
                AppMethodBeat.o(113302);
                return strArr;
            }
            int i2;
            String str2;
            if (biVar.field_isSend == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (t.kH(biVar.field_talker) && i2 != 0) {
                i2 = bf.ox(str);
                if (i2 != -1) {
                    str = str.substring(i2 + 1).trim();
                }
            }
            b Ro = ((j) g.K(j.class)).bOr().Ro(str);
            if (Ro.dua()) {
                str = Ro.label;
                str2 = Ro.eUu;
                strArr[0] = str;
                strArr[1] = str2;
            } else {
                strArr[0] = Ro.label;
                strArr[1] = "";
            }
            if (bo.isNullOrNil(strArr[0]) && bo.isNullOrNil(strArr[1])) {
                ab.i("MicroMsg.LocationServer", "pull from sever");
                long j = biVar.field_msgId;
                if (!(this.nJC == null || this.nJC.contains(Long.valueOf(j)))) {
                    str2 = biVar.field_content;
                    if (biVar.field_isSend != 0) {
                        i = 0;
                    }
                    if (t.kH(biVar.field_talker) && i != 0) {
                        i = bf.ox(str2);
                        if (i != -1) {
                            str2 = str2.substring(i + 1).trim();
                        }
                    }
                    Ro = b.apD(str2);
                    this.nJC.add(Long.valueOf(j));
                    c.agw().a(Ro.nJu, Ro.nJv, this.nJD, Long.valueOf(biVar.field_msgId));
                }
            }
            AppMethodBeat.o(113302);
            return strArr;
        }
    }
}
