package com.tencent.p177mm.p1088u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32248f;
import com.tencent.p177mm.api.C45152l;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p1375bl.C25867a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.ajc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C40626ba;
import java.util.List;
import java.util.Map;
import org.apache.commons.p703b.C6130d;

/* renamed from: com.tencent.mm.u.b */
public final class C44228b implements C1202f {
    private List<C32248f> eAC;
    private C23525a eAD;
    private C45152l eAE;

    /* renamed from: com.tencent.mm.u.b$a */
    public interface C23525a {
        /* renamed from: a */
        void mo11554a(C32248f c32248f);

        /* renamed from: b */
        void mo11555b(C32248f c32248f);
    }

    public C44228b(List<C32248f> list, C45152l c45152l, C23525a c23525a) {
        AppMethodBeat.m2504i(35449);
        C1720g.m3540Rg().mo14539a(825, (C1202f) this);
        this.eAE = c45152l;
        this.eAD = c23525a;
        this.eAC = list;
        AppMethodBeat.m2505o(35449);
    }

    /* renamed from: Pn */
    public final void mo69869Pn() {
        AppMethodBeat.m2504i(35450);
        for (C32248f c32248f : this.eAC) {
            if (c32248f != null && c32248f.field_cgi != null && c32248f.field_cmdid > 0) {
                C4990ab.m7417i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", c32248f.field_functionmsgid);
                c32248f.field_status = 0;
                this.eAE.mo39139b(c32248f.field_businessInfo);
                C1720g.m3540Rg().mo14541a(new C25867a(c32248f), 0);
            } else if (c32248f != null) {
                int i;
                C7254cm a = C44228b.m79822a(c32248f.field_addMsg, c32248f.field_defaultContent);
                C4990ab.m7417i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", a);
                c32248f.mo52942a(a);
                if (c32248f.field_actionTime > C1839cb.aaD() / 1000) {
                    i = -2;
                } else {
                    i = 2;
                }
                c32248f.field_status = i;
                C40626ba c40626ba = C40626ba.xZa;
                C40626ba.m70154a(c32248f.field_functionmsgid, c32248f);
                if (a != null && this.eAC.remove(c32248f)) {
                    this.eAD.mo11554a(c32248f);
                } else if (this.eAC.remove(c32248f)) {
                    this.eAD.mo11555b(c32248f);
                }
                if (this.eAC.size() <= 0) {
                    release();
                }
            }
        }
        AppMethodBeat.m2505o(35450);
    }

    private void release() {
        AppMethodBeat.m2504i(35451);
        C1720g.m3540Rg().mo14546b(825, (C1202f) this);
        AppMethodBeat.m2505o(35451);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(35452);
        if (c1207m.getType() != 825) {
            AppMethodBeat.m2505o(35452);
            return;
        }
        C25867a c25867a = (C25867a) c1207m;
        ajc ajc = c25867a.gcx;
        C32248f c32248f = c25867a.gcy;
        C4990ab.m7417i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", Integer.valueOf(this.eAC.size()), Integer.valueOf(i2), str);
        if (this.eAC.contains(c32248f)) {
            C40626ba c40626ba;
            int i3;
            if (i2 != 0 || ((i2 == 0 && ajc == null) || ((ajc != null && ajc.OpCode == 2) || (ajc != null && ajc.OpCode == 1)))) {
                String str2 = "FunctionMsg.FunctionMsgFetcher";
                String str3 = "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s";
                Object[] objArr = new Object[4];
                objArr[0] = c32248f.field_functionmsgid;
                objArr[1] = Long.valueOf(c32248f.field_preVersion);
                objArr[2] = Long.valueOf(c32248f.field_version);
                objArr[3] = Integer.valueOf(ajc == null ? -1 : ajc.OpCode);
                C4990ab.m7417i(str2, str3, objArr);
                if (c32248f.field_retryCount < c32248f.field_retryCountLimit) {
                    str2 = "FunctionMsg.FunctionMsgFetcher";
                    str3 = "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s";
                    objArr = new Object[4];
                    objArr[0] = Integer.valueOf(c32248f.field_retryCount);
                    objArr[1] = c32248f.field_functionmsgid;
                    objArr[2] = Integer.valueOf(c32248f.field_retryinterval);
                    objArr[3] = Boolean.valueOf(ajc == null);
                    C4990ab.m7417i(str2, str3, objArr);
                    if (ajc != null) {
                        C4990ab.m7417i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", Integer.valueOf(ajc.OpCode), Integer.valueOf(ajc.wpa));
                        if (ajc.OpCode == 2) {
                            c32248f.field_actionTime = (long) ajc.wpa;
                            c32248f.field_retryCount++;
                            c32248f.field_status = -1;
                        } else if (ajc.OpCode == 1) {
                            c32248f.field_status = 3;
                            c32248f.field_retryCount = c32248f.field_retryCountLimit;
                        } else {
                            c32248f.field_status = 3;
                        }
                        c32248f.mo52951cF(ajc.woW);
                    } else {
                        c32248f.field_status = -1;
                        c32248f.field_actionTime = (C1839cb.aaD() / 1000) + ((long) c32248f.field_retryinterval);
                        c32248f.field_retryCount++;
                    }
                } else {
                    c32248f.field_status = 3;
                }
                c40626ba = C40626ba.xZa;
                C40626ba.m70154a(c32248f.field_functionmsgid, c32248f);
                if (c32248f.field_status != 3) {
                    C7060h.pYm.mo8378a((long) c32248f.field_reportid, (long) c32248f.field_failkey, 1, false);
                    long aaD = c32248f.field_actionTime - (C1839cb.aaD() / 1000);
                    C4990ab.m7417i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", Long.valueOf(aaD * 1000), Integer.valueOf(c32248f.field_retryCount));
                } else {
                    C7254cm a = C44228b.m79822a(c32248f.field_addMsg, c32248f.field_defaultContent);
                    C4990ab.m7417i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", a);
                    c32248f.mo52942a(a);
                    if (a == null) {
                        i3 = 3;
                    } else {
                        i3 = 2;
                    }
                    c32248f.field_status = i3;
                    if (3 == c32248f.field_status) {
                        c32248f.field_version = c32248f.field_preVersion;
                        C7060h.pYm.mo8378a((long) c32248f.field_reportid, (long) c32248f.field_finalfailkey, 1, false);
                    }
                    c40626ba = C40626ba.xZa;
                    C40626ba.m70154a(c32248f.field_functionmsgid, c32248f);
                }
            } else if (ajc != null && i2 == 0 && (ajc.OpCode == 3 || ajc.OpCode == 0)) {
                C4990ab.m7417i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", c32248f.field_functionmsgid, Long.valueOf(ajc.woY), Long.valueOf(c32248f.field_version), Integer.valueOf(ajc.wpa), Integer.valueOf(ajc.OpCode));
                if (ajc.OpCode == 3) {
                    i3 = -2;
                } else {
                    i3 = 2;
                }
                c32248f.field_status = i3;
                c32248f.mo52942a(ajc.woZ);
                c32248f.field_businessInfo = ajc.woX;
                c32248f.field_actionTime = (long) ajc.wpa;
                c40626ba = C40626ba.xZa;
                C40626ba.m70154a(c32248f.field_functionmsgid, c32248f);
            }
            if ((c32248f.field_status == 2 || c32248f.field_status == -2) && this.eAC.remove(c32248f)) {
                this.eAD.mo11554a(c32248f);
                C7060h.pYm.mo8378a((long) c32248f.field_reportid, (long) c32248f.field_successkey, 1, false);
            } else if (this.eAC.remove(c32248f)) {
                this.eAD.mo11555b(c32248f);
            }
        }
        if (this.eAC.size() <= 0) {
            release();
        }
        AppMethodBeat.m2505o(35452);
    }

    /* renamed from: a */
    private static C7254cm m79822a(C7254cm c7254cm, String str) {
        AppMethodBeat.m2504i(35453);
        if (c7254cm == null) {
            C4990ab.m7420w("FunctionMsg.FunctionMsgFetcher", "null == raw");
            AppMethodBeat.m2505o(35453);
            return null;
        }
        int indexOf = str.indexOf("<addmsg");
        if (indexOf == -1) {
            C4990ab.m7413e("FunctionMsg.FunctionMsgFetcher", "msgContent not start with <addmsg! content is null?%s", Boolean.valueOf(C5046bo.isNullOrNil(str)));
            AppMethodBeat.m2505o(35453);
            return null;
        }
        String str2;
        Map z = C5049br.m7595z(str.substring(indexOf), "addmsg");
        StringBuilder stringBuilder = new StringBuilder();
        if (z.containsKey(C44228b.m79823kT(".msgid"))) {
            indexOf = C5046bo.getInt((String) z.get(C44228b.m79823kT(".msgid")), 0);
            c7254cm.ptD = indexOf;
            stringBuilder.append("msgid:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(C44228b.m79823kT(".newmsgid"))) {
            long j = C5046bo.getLong((String) z.get(C44228b.m79823kT(".newmsgid")), 0);
            c7254cm.ptF = j;
            stringBuilder.append(" newMsgId:".concat(String.valueOf(j)));
        }
        if (z.containsKey(C44228b.m79823kT(".msgseq"))) {
            indexOf = C5046bo.getInt((String) z.get(C44228b.m79823kT(".msgseq")), 0);
            c7254cm.vEI = indexOf;
            stringBuilder.append(" msgSeq:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(C44228b.m79823kT(".fromusername"))) {
            str2 = (String) z.get(C44228b.m79823kT(".fromusername"));
            c7254cm.vEB = C1946aa.m4154vy(str2);
            stringBuilder.append(" fromUsername:".concat(String.valueOf(str2)));
        }
        if (z.containsKey(C44228b.m79823kT(".tousername"))) {
            str2 = (String) z.get(C44228b.m79823kT(".tousername"));
            c7254cm.vEC = C1946aa.m4154vy(str2);
            stringBuilder.append(" toUsername:".concat(String.valueOf(str2)));
        }
        if (z.containsKey(C44228b.m79823kT(".msgtype"))) {
            indexOf = C5046bo.getInt((String) z.get(C44228b.m79823kT(".msgtype")), 0);
            c7254cm.nao = indexOf;
            stringBuilder.append(" msgType:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(C44228b.m79823kT(".status"))) {
            indexOf = C5046bo.getInt((String) z.get(C44228b.m79823kT(".status")), 0);
            c7254cm.jBT = indexOf;
            stringBuilder.append(" status:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(C44228b.m79823kT(".content"))) {
            c7254cm.vED = C1946aa.m4154vy(C6130d.awL(str.substring(str.indexOf("<content>") + 9, str.indexOf("</content>"))));
            stringBuilder.append(" msgContent:*");
        } else {
            stringBuilder.append(" msgContent:null");
            c7254cm.vED = null;
        }
        if (z.containsKey(C44228b.m79823kT(".msgsource"))) {
            c7254cm.vEG = C6130d.awL(str.substring(str.indexOf("<msgsource>") + 11, str.indexOf("</msgsource>")));
            stringBuilder.append(" msgSource:*");
        }
        if (z.containsKey(C44228b.m79823kT(".pushcontent"))) {
            c7254cm.vEH = C6130d.awL(str.substring(str.indexOf("<pushcontent>") + 13, str.indexOf("</pushcontent>")));
            stringBuilder.append(" pushContent:*");
        }
        if (z.containsKey(C44228b.m79823kT(".imgstatus"))) {
            indexOf = C5046bo.getInt((String) z.get(C44228b.m79823kT(".imgstatus")), 0);
            c7254cm.vEE = indexOf;
            stringBuilder.append(" ImgStatus:".concat(String.valueOf(indexOf)));
        }
        if (z.containsKey(C44228b.m79823kT(".imgbuf"))) {
            c7254cm.vEF = C1946aa.m4155vz((String) z.get(C44228b.m79823kT(".imgbuf")));
            stringBuilder.append(" imgBuf:*");
        }
        if (z.containsKey(C44228b.m79823kT(".createtime"))) {
            indexOf = C5046bo.getInt((String) z.get(C44228b.m79823kT(".createtime")), 0);
            c7254cm.pcX = indexOf;
            stringBuilder.append(" createTime:".concat(String.valueOf(indexOf)));
        }
        C4990ab.m7417i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", stringBuilder.toString());
        AppMethodBeat.m2505o(35453);
        return c7254cm;
    }

    /* renamed from: kT */
    private static String m79823kT(String str) {
        AppMethodBeat.m2504i(35454);
        String concat = ".addmsg".concat(String.valueOf(str));
        AppMethodBeat.m2505o(35454);
        return concat;
    }
}
