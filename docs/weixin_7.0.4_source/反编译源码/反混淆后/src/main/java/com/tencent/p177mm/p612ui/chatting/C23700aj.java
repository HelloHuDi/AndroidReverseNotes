package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C45335jj;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.aj */
public final class C23700aj {
    private C7616ad cFn = null;
    private Context context;
    private SimpleDateFormat juL = new SimpleDateFormat("yyyy-MM-dd");
    String mGM = null;
    List<C7620bi> yIP;
    private String yLV = null;
    ArrayList<Uri> yLW = new ArrayList();

    public C23700aj(Context context, List<C7620bi> list, C7616ad c7616ad) {
        AppMethodBeat.m2504i(30962);
        this.context = context;
        this.yIP = list;
        this.cFn = c7616ad;
        AppMethodBeat.m2505o(30962);
    }

    public final String dCL() {
        AppMethodBeat.m2504i(30963);
        String str = "MicroMsg.OtherMailHistoryExporter";
        String str2 = "export: history is null? %B, selectItems.size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.mGM == null);
        objArr[1] = Integer.valueOf(this.yIP.size());
        C4990ab.m7411d(str, str2, objArr);
        String str3;
        if (this.mGM != null) {
            str3 = this.mGM;
            AppMethodBeat.m2505o(30963);
            return str3;
        }
        this.yLW.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dCM());
        stringBuilder.append("\n\n");
        for (C7620bi c7620bi : this.yIP) {
            if (this.yLV == null) {
                this.yLV = m36542nd(c7620bi.field_createTime);
                stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.yLV}));
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            } else {
                str = m36542nd(c7620bi.field_createTime);
                if (!str.equals(this.yLV)) {
                    this.yLV = str;
                    stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.yLV}));
                    stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
            if (c7620bi.isText()) {
                if (!c7620bi.isText()) {
                    str3 = null;
                } else if (c7620bi.field_isSend == 1) {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{m36541aP(c7620bi), c7620bi.field_content});
                } else if (C1855t.m3896kH(this.cFn.field_username)) {
                    str3 = C1829bf.m3761ox(c7620bi.field_content) != -1 ? String.format("%s\n\n%s\n\n", new Object[]{m36541aP(c7620bi), c7620bi.field_content.substring(C1829bf.m3761ox(c7620bi.field_content) + 1).trim()}) : null;
                } else {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{m36541aP(c7620bi), c7620bi.field_content});
                }
                stringBuilder.append(str3);
            } else if (c7620bi.drE()) {
                if (c7620bi.drE()) {
                    long j = c7620bi.field_msgId;
                    long j2 = c7620bi.field_msgSvrId;
                    str = C44284ad.m80020nb(j);
                    if (C5046bo.isNullOrNil(str)) {
                        str = C44284ad.m80021nc(j2);
                    }
                    C4990ab.m7411d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", str);
                    if (!C5046bo.isNullOrNil(str)) {
                        this.yLW.add(Uri.parse("content://".concat(String.valueOf(str))));
                        str = String.format("[%s: %s(%s)]", new Object[]{this.context.getString(C25738R.string.b8u), new File(str).getName(), this.context.getString(C25738R.string.b8q)});
                        str3 = String.format("%s\n\n%s\n\n", new Object[]{m36541aP(c7620bi), str});
                        stringBuilder.append(str3);
                    }
                }
                str3 = null;
                stringBuilder.append(str3);
            } else {
                if (c7620bi.drD()) {
                    str = String.format("[%s]", new Object[]{this.context.getString(C25738R.string.b8z)});
                } else if (c7620bi.dts()) {
                    str = c7620bi.field_isSend == 1 ? this.context.getString(C25738R.string.b8x) : this.context.getString(C25738R.string.b8w);
                } else if (c7620bi.bAC()) {
                    C45335jj c45335jj = new C45335jj();
                    c45335jj.cEF.cEA = 1;
                    c45335jj.cEF.csG = c7620bi;
                    C4879a.xxA.mo10055m(c45335jj);
                    str = String.format("[%s]", new Object[]{c45335jj.cEG.cBp});
                } else {
                    if (c7620bi.bAA()) {
                        C8910b me = C8910b.m16064me(C5046bo.anj(c7620bi.field_content));
                        if (me != null) {
                            switch (me.type) {
                                case 4:
                                case 6:
                                    C30065b aiE = C14877am.aUq().aiE(me.csD);
                                    if (aiE != null) {
                                        File file = new File(aiE.field_fileFullPath);
                                        if (file.exists()) {
                                            this.yLW.add(Uri.fromFile(file));
                                            break;
                                        }
                                    }
                                    break;
                            }
                            C40439f bT = C46494g.m87739bT(me.appId, true);
                            if (bT == null) {
                                str = "";
                            } else {
                                String str4 = bT.field_appName;
                                str = 6 == me.type ? String.format("[%s: %s(%s)]", new Object[]{this.context.getString(C25738R.string.b8p), str4, this.context.getString(C25738R.string.b8q)}) : String.format("[%s: %s]", new Object[]{this.context.getString(C25738R.string.b8p), str4});
                            }
                        }
                    } else if (c7620bi.dtw()) {
                        C9638aw.m17190ZK();
                        str = C18628c.m29080XO().mo15260Rn(c7620bi.field_content).nickname;
                        str = String.format("[%s: %s]", new Object[]{this.context.getString(C25738R.string.b8r), str});
                    } else if (c7620bi.bws()) {
                        r7 = new Object[3];
                        C37961o.all();
                        r7[1] = new File(C9720t.m17303uh(c7620bi.field_imgPath)).getName();
                        r7[2] = this.context.getString(C25738R.string.b8q);
                        str = String.format("[%s: %s(%s)]", r7);
                        C37961o.all();
                        File file2 = new File(C9720t.m17303uh(c7620bi.field_imgPath));
                        if (file2.exists()) {
                            this.yLW.add(Uri.fromFile(file2));
                        }
                    } else if (c7620bi.dtx() || c7620bi.dty()) {
                        str = String.format("[%s]", new Object[]{this.context.getString(C25738R.string.b8s)});
                    }
                    str = null;
                }
                C4990ab.m7417i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", str);
                stringBuilder.append(String.format("%s\n\n%s\n\n", new Object[]{m36541aP(c7620bi), str}));
            }
        }
        stringBuilder.append("\n\n");
        this.mGM = stringBuilder.toString();
        str3 = this.mGM;
        AppMethodBeat.m2505o(30963);
        return str3;
    }

    private String dCM() {
        String str;
        AppMethodBeat.m2504i(30964);
        if (C1855t.m3896kH(this.cFn.field_username)) {
            if (C5046bo.isNullOrNil(this.cFn.field_nickname)) {
                String str2;
                str = "";
                Iterator it = C37921n.m64074my(this.cFn.field_username).iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    str = str2 + C1854s.m3866mJ((String) it.next()) + ", ";
                }
                str = str2.substring(0, str2.length() - 2);
            } else {
                str = this.cFn.mo16706Oi();
            }
            str = String.format(this.context.getString(C25738R.string.e38), new Object[]{str});
        } else {
            str = this.context.getString(C25738R.string.e39);
            Object[] objArr = new Object[2];
            objArr[0] = this.cFn.mo16706Oi();
            C9638aw.m17190ZK();
            objArr[1] = C18628c.m29072Ry().get(4, null);
            str = String.format(str, objArr);
        }
        AppMethodBeat.m2505o(30964);
        return str;
    }

    /* renamed from: aP */
    private String m36541aP(C7620bi c7620bi) {
        String str;
        AppMethodBeat.m2504i(30965);
        String str2 = null;
        if (C1855t.m3896kH(this.cFn.field_username)) {
            str = c7620bi.field_content;
            int ox = C1829bf.m3761ox(str);
            if (ox != -1) {
                str2 = C1854s.m3866mJ(str.substring(0, ox).trim());
            }
        } else {
            str2 = C1854s.m3866mJ(c7620bi.field_talker);
        }
        if (c7620bi.field_isSend == 1) {
            C4990ab.m7416i("MicroMsg.OtherMailHistoryExporter", "isSend");
            str2 = C1853r.m3820YB();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(c7620bi.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(30965);
        return str2;
    }

    /* renamed from: nd */
    private String m36542nd(long j) {
        AppMethodBeat.m2504i(30966);
        String format = this.juL.format(new Date(j));
        AppMethodBeat.m2505o(30966);
        return format;
    }
}
