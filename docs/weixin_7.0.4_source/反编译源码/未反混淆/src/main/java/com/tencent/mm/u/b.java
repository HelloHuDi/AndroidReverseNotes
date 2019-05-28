package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.api.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ba;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.d;

public final class b implements f {
    private List<com.tencent.mm.api.f> eAC;
    private a eAD;
    private l eAE;

    public interface a {
        void a(com.tencent.mm.api.f fVar);

        void b(com.tencent.mm.api.f fVar);
    }

    public b(List<com.tencent.mm.api.f> list, l lVar, a aVar) {
        AppMethodBeat.i(35449);
        g.Rg().a(825, (f) this);
        this.eAE = lVar;
        this.eAD = aVar;
        this.eAC = list;
        AppMethodBeat.o(35449);
    }

    public final void Pn() {
        AppMethodBeat.i(35450);
        for (com.tencent.mm.api.f fVar : this.eAC) {
            if (fVar != null && fVar.field_cgi != null && fVar.field_cmdid > 0) {
                ab.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", fVar.field_functionmsgid);
                fVar.field_status = 0;
                this.eAE.b(fVar.field_businessInfo);
                g.Rg().a(new com.tencent.mm.bl.a(fVar), 0);
            } else if (fVar != null) {
                int i;
                cm a = a(fVar.field_addMsg, fVar.field_defaultContent);
                ab.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", a);
                fVar.a(a);
                if (fVar.field_actionTime > cb.aaD() / 1000) {
                    i = -2;
                } else {
                    i = 2;
                }
                fVar.field_status = i;
                ba baVar = ba.xZa;
                ba.a(fVar.field_functionmsgid, fVar);
                if (a != null && this.eAC.remove(fVar)) {
                    this.eAD.a(fVar);
                } else if (this.eAC.remove(fVar)) {
                    this.eAD.b(fVar);
                }
                if (this.eAC.size() <= 0) {
                    release();
                }
            }
        }
        AppMethodBeat.o(35450);
    }

    private void release() {
        AppMethodBeat.i(35451);
        g.Rg().b(825, (f) this);
        AppMethodBeat.o(35451);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(35452);
        if (mVar.getType() != 825) {
            AppMethodBeat.o(35452);
            return;
        }
        com.tencent.mm.bl.a aVar = (com.tencent.mm.bl.a) mVar;
        ajc ajc = aVar.gcx;
        com.tencent.mm.api.f fVar = aVar.gcy;
        ab.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", Integer.valueOf(this.eAC.size()), Integer.valueOf(i2), str);
        if (this.eAC.contains(fVar)) {
            ba baVar;
            int i3;
            if (i2 != 0 || ((i2 == 0 && ajc == null) || ((ajc != null && ajc.OpCode == 2) || (ajc != null && ajc.OpCode == 1)))) {
                String str2 = "FunctionMsg.FunctionMsgFetcher";
                String str3 = "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s";
                Object[] objArr = new Object[4];
                objArr[0] = fVar.field_functionmsgid;
                objArr[1] = Long.valueOf(fVar.field_preVersion);
                objArr[2] = Long.valueOf(fVar.field_version);
                objArr[3] = Integer.valueOf(ajc == null ? -1 : ajc.OpCode);
                ab.i(str2, str3, objArr);
                if (fVar.field_retryCount < fVar.field_retryCountLimit) {
                    str2 = "FunctionMsg.FunctionMsgFetcher";
                    str3 = "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s";
                    objArr = new Object[4];
                    objArr[0] = Integer.valueOf(fVar.field_retryCount);
                    objArr[1] = fVar.field_functionmsgid;
                    objArr[2] = Integer.valueOf(fVar.field_retryinterval);
                    objArr[3] = Boolean.valueOf(ajc == null);
                    ab.i(str2, str3, objArr);
                    if (ajc != null) {
                        ab.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", Integer.valueOf(ajc.OpCode), Integer.valueOf(ajc.wpa));
                        if (ajc.OpCode == 2) {
                            fVar.field_actionTime = (long) ajc.wpa;
                            fVar.field_retryCount++;
                            fVar.field_status = -1;
                        } else if (ajc.OpCode == 1) {
                            fVar.field_status = 3;
                            fVar.field_retryCount = fVar.field_retryCountLimit;
                        } else {
                            fVar.field_status = 3;
                        }
                        fVar.cF(ajc.woW);
                    } else {
                        fVar.field_status = -1;
                        fVar.field_actionTime = (cb.aaD() / 1000) + ((long) fVar.field_retryinterval);
                        fVar.field_retryCount++;
                    }
                } else {
                    fVar.field_status = 3;
                }
                baVar = ba.xZa;
                ba.a(fVar.field_functionmsgid, fVar);
                if (fVar.field_status != 3) {
                    h.pYm.a((long) fVar.field_reportid, (long) fVar.field_failkey, 1, false);
                    long aaD = fVar.field_actionTime - (cb.aaD() / 1000);
                    ab.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", Long.valueOf(aaD * 1000), Integer.valueOf(fVar.field_retryCount));
                } else {
                    cm a = a(fVar.field_addMsg, fVar.field_defaultContent);
                    ab.i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", a);
                    fVar.a(a);
                    if (a == null) {
                        i3 = 3;
                    } else {
                        i3 = 2;
                    }
                    fVar.field_status = i3;
                    if (3 == fVar.field_status) {
                        fVar.field_version = fVar.field_preVersion;
                        h.pYm.a((long) fVar.field_reportid, (long) fVar.field_finalfailkey, 1, false);
                    }
                    baVar = ba.xZa;
                    ba.a(fVar.field_functionmsgid, fVar);
                }
            } else if (ajc != null && i2 == 0 && (ajc.OpCode == 3 || ajc.OpCode == 0)) {
                ab.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", fVar.field_functionmsgid, Long.valueOf(ajc.woY), Long.valueOf(fVar.field_version), Integer.valueOf(ajc.wpa), Integer.valueOf(ajc.OpCode));
                if (ajc.OpCode == 3) {
                    i3 = -2;
                } else {
                    i3 = 2;
                }
                fVar.field_status = i3;
                fVar.a(ajc.woZ);
                fVar.field_businessInfo = ajc.woX;
                fVar.field_actionTime = (long) ajc.wpa;
                baVar = ba.xZa;
                ba.a(fVar.field_functionmsgid, fVar);
            }
            if ((fVar.field_status == 2 || fVar.field_status == -2) && this.eAC.remove(fVar)) {
                this.eAD.a(fVar);
                h.pYm.a((long) fVar.field_reportid, (long) fVar.field_successkey, 1, false);
            } else if (this.eAC.remove(fVar)) {
                this.eAD.b(fVar);
            }
        }
        if (this.eAC.size() <= 0) {
            release();
        }
        AppMethodBeat.o(35452);
    }

    private static cm a(cm cmVar, String str) {
        AppMethodBeat.i(35453);
        if (cmVar == null) {
            ab.w("FunctionMsg.FunctionMsgFetcher", "null == raw");
            AppMethodBeat.o(35453);
            return null;
        }
        int indexOf = str.indexOf("<addmsg");
        if (indexOf == -1) {
            ab.e("FunctionMsg.FunctionMsgFetcher", "msgContent not start with <addmsg! content is null?%s", Boolean.valueOf(bo.isNullOrNil(str)));
            AppMethodBeat.o(35453);
            return null;
        }
        String str2;
        Map z = br.z(str.substring(indexOf), "addmsg");
        StringBuilder stringBuilder = new StringBuilder();
        if (z.containsKey(kT(".msgid"))) {
            indexOf = bo.getInt((String) z.get(kT(".msgid")), 0);
            cmVar.ptD = indexOf;
            stringBuilder.append("msgid:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(kT(".newmsgid"))) {
            long j = bo.getLong((String) z.get(kT(".newmsgid")), 0);
            cmVar.ptF = j;
            stringBuilder.append(" newMsgId:".concat(String.valueOf(j)));
        }
        if (z.containsKey(kT(".msgseq"))) {
            indexOf = bo.getInt((String) z.get(kT(".msgseq")), 0);
            cmVar.vEI = indexOf;
            stringBuilder.append(" msgSeq:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(kT(".fromusername"))) {
            str2 = (String) z.get(kT(".fromusername"));
            cmVar.vEB = aa.vy(str2);
            stringBuilder.append(" fromUsername:".concat(String.valueOf(str2)));
        }
        if (z.containsKey(kT(".tousername"))) {
            str2 = (String) z.get(kT(".tousername"));
            cmVar.vEC = aa.vy(str2);
            stringBuilder.append(" toUsername:".concat(String.valueOf(str2)));
        }
        if (z.containsKey(kT(".msgtype"))) {
            indexOf = bo.getInt((String) z.get(kT(".msgtype")), 0);
            cmVar.nao = indexOf;
            stringBuilder.append(" msgType:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(kT(".status"))) {
            indexOf = bo.getInt((String) z.get(kT(".status")), 0);
            cmVar.jBT = indexOf;
            stringBuilder.append(" status:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(kT(".content"))) {
            cmVar.vED = aa.vy(d.awL(str.substring(str.indexOf("<content>") + 9, str.indexOf("</content>"))));
            stringBuilder.append(" msgContent:*");
        } else {
            stringBuilder.append(" msgContent:null");
            cmVar.vED = null;
        }
        if (z.containsKey(kT(".msgsource"))) {
            cmVar.vEG = d.awL(str.substring(str.indexOf("<msgsource>") + 11, str.indexOf("</msgsource>")));
            stringBuilder.append(" msgSource:*");
        }
        if (z.containsKey(kT(".pushcontent"))) {
            cmVar.vEH = d.awL(str.substring(str.indexOf("<pushcontent>") + 13, str.indexOf("</pushcontent>")));
            stringBuilder.append(" pushContent:*");
        }
        if (z.containsKey(kT(".imgstatus"))) {
            indexOf = bo.getInt((String) z.get(kT(".imgstatus")), 0);
            cmVar.vEE = indexOf;
            stringBuilder.append(" ImgStatus:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(kT(".imgbuf"))) {
            cmVar.vEF = aa.vz((String) z.get(kT(".imgbuf")));
            stringBuilder.append(" imgBuf:*");
        }
        if (z.containsKey(kT(".createtime"))) {
            indexOf = bo.getInt((String) z.get(kT(".createtime")), 0);
            cmVar.pcX = indexOf;
            stringBuilder.append(" createTime:".concat(String.valueOf(indexOf)));
        }
        ab.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", stringBuilder.toString());
        AppMethodBeat.o(35453);
        return cmVar;
    }

    private static String kT(String str) {
        AppMethodBeat.i(35454);
        String concat = ".addmsg".concat(String.valueOf(str));
        AppMethodBeat.o(35454);
        return concat;
    }
}
