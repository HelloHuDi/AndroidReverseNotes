package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class aj {
    private ad cFn = null;
    private Context context;
    private SimpleDateFormat juL = new SimpleDateFormat("yyyy-MM-dd");
    String mGM = null;
    List<bi> yIP;
    private String yLV = null;
    ArrayList<Uri> yLW = new ArrayList();

    public aj(Context context, List<bi> list, ad adVar) {
        AppMethodBeat.i(30962);
        this.context = context;
        this.yIP = list;
        this.cFn = adVar;
        AppMethodBeat.o(30962);
    }

    public final String dCL() {
        AppMethodBeat.i(30963);
        String str = "MicroMsg.OtherMailHistoryExporter";
        String str2 = "export: history is null? %B, selectItems.size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.mGM == null);
        objArr[1] = Integer.valueOf(this.yIP.size());
        ab.d(str, str2, objArr);
        String str3;
        if (this.mGM != null) {
            str3 = this.mGM;
            AppMethodBeat.o(30963);
            return str3;
        }
        this.yLW.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dCM());
        stringBuilder.append("\n\n");
        for (bi biVar : this.yIP) {
            if (this.yLV == null) {
                this.yLV = nd(biVar.field_createTime);
                stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.yLV}));
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            } else {
                str = nd(biVar.field_createTime);
                if (!str.equals(this.yLV)) {
                    this.yLV = str;
                    stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.yLV}));
                    stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
            if (biVar.isText()) {
                if (!biVar.isText()) {
                    str3 = null;
                } else if (biVar.field_isSend == 1) {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aP(biVar), biVar.field_content});
                } else if (t.kH(this.cFn.field_username)) {
                    str3 = bf.ox(biVar.field_content) != -1 ? String.format("%s\n\n%s\n\n", new Object[]{aP(biVar), biVar.field_content.substring(bf.ox(biVar.field_content) + 1).trim()}) : null;
                } else {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aP(biVar), biVar.field_content});
                }
                stringBuilder.append(str3);
            } else if (biVar.drE()) {
                if (biVar.drE()) {
                    long j = biVar.field_msgId;
                    long j2 = biVar.field_msgSvrId;
                    str = ad.nb(j);
                    if (bo.isNullOrNil(str)) {
                        str = ad.nc(j2);
                    }
                    ab.d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", str);
                    if (!bo.isNullOrNil(str)) {
                        this.yLW.add(Uri.parse("content://".concat(String.valueOf(str))));
                        str = String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.string.b8u), new File(str).getName(), this.context.getString(R.string.b8q)});
                        str3 = String.format("%s\n\n%s\n\n", new Object[]{aP(biVar), str});
                        stringBuilder.append(str3);
                    }
                }
                str3 = null;
                stringBuilder.append(str3);
            } else {
                if (biVar.drD()) {
                    str = String.format("[%s]", new Object[]{this.context.getString(R.string.b8z)});
                } else if (biVar.dts()) {
                    str = biVar.field_isSend == 1 ? this.context.getString(R.string.b8x) : this.context.getString(R.string.b8w);
                } else if (biVar.bAC()) {
                    jj jjVar = new jj();
                    jjVar.cEF.cEA = 1;
                    jjVar.cEF.csG = biVar;
                    a.xxA.m(jjVar);
                    str = String.format("[%s]", new Object[]{jjVar.cEG.cBp});
                } else {
                    if (biVar.bAA()) {
                        b me = b.me(bo.anj(biVar.field_content));
                        if (me != null) {
                            switch (me.type) {
                                case 4:
                                case 6:
                                    com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
                                    if (aiE != null) {
                                        File file = new File(aiE.field_fileFullPath);
                                        if (file.exists()) {
                                            this.yLW.add(Uri.fromFile(file));
                                            break;
                                        }
                                    }
                                    break;
                            }
                            f bT = g.bT(me.appId, true);
                            if (bT == null) {
                                str = "";
                            } else {
                                String str4 = bT.field_appName;
                                str = 6 == me.type ? String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.string.b8p), str4, this.context.getString(R.string.b8q)}) : String.format("[%s: %s]", new Object[]{this.context.getString(R.string.b8p), str4});
                            }
                        }
                    } else if (biVar.dtw()) {
                        aw.ZK();
                        str = c.XO().Rn(biVar.field_content).nickname;
                        str = String.format("[%s: %s]", new Object[]{this.context.getString(R.string.b8r), str});
                    } else if (biVar.bws()) {
                        r7 = new Object[3];
                        o.all();
                        r7[1] = new File(com.tencent.mm.modelvideo.t.uh(biVar.field_imgPath)).getName();
                        r7[2] = this.context.getString(R.string.b8q);
                        str = String.format("[%s: %s(%s)]", r7);
                        o.all();
                        File file2 = new File(com.tencent.mm.modelvideo.t.uh(biVar.field_imgPath));
                        if (file2.exists()) {
                            this.yLW.add(Uri.fromFile(file2));
                        }
                    } else if (biVar.dtx() || biVar.dty()) {
                        str = String.format("[%s]", new Object[]{this.context.getString(R.string.b8s)});
                    }
                    str = null;
                }
                ab.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", str);
                stringBuilder.append(String.format("%s\n\n%s\n\n", new Object[]{aP(biVar), str}));
            }
        }
        stringBuilder.append("\n\n");
        this.mGM = stringBuilder.toString();
        str3 = this.mGM;
        AppMethodBeat.o(30963);
        return str3;
    }

    private String dCM() {
        String str;
        AppMethodBeat.i(30964);
        if (t.kH(this.cFn.field_username)) {
            if (bo.isNullOrNil(this.cFn.field_nickname)) {
                String str2;
                str = "";
                Iterator it = n.my(this.cFn.field_username).iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    str = str2 + s.mJ((String) it.next()) + ", ";
                }
                str = str2.substring(0, str2.length() - 2);
            } else {
                str = this.cFn.Oi();
            }
            str = String.format(this.context.getString(R.string.e38), new Object[]{str});
        } else {
            str = this.context.getString(R.string.e39);
            Object[] objArr = new Object[2];
            objArr[0] = this.cFn.Oi();
            aw.ZK();
            objArr[1] = c.Ry().get(4, null);
            str = String.format(str, objArr);
        }
        AppMethodBeat.o(30964);
        return str;
    }

    private String aP(bi biVar) {
        String str;
        AppMethodBeat.i(30965);
        String str2 = null;
        if (t.kH(this.cFn.field_username)) {
            str = biVar.field_content;
            int ox = bf.ox(str);
            if (ox != -1) {
                str2 = s.mJ(str.substring(0, ox).trim());
            }
        } else {
            str2 = s.mJ(biVar.field_talker);
        }
        if (biVar.field_isSend == 1) {
            ab.i("MicroMsg.OtherMailHistoryExporter", "isSend");
            str2 = r.YB();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(biVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        str2 = stringBuilder.toString();
        AppMethodBeat.o(30965);
        return str2;
    }

    private String nd(long j) {
        AppMethodBeat.i(30966);
        String format = this.juL.format(new Date(j));
        AppMethodBeat.o(30966);
        return format;
    }
}
