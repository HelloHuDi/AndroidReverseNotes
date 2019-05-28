package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
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
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C45335jj;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.QQMailHistoryExporter */
public final class QQMailHistoryExporter {
    private static final char[] iRk = new char[]{'<', '>', '\"', '\'', '&', 10};
    private static final String[] iRl = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />"};
    private static final String yLX = ("<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + C30152u.m47750hL("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>");
    private C7616ad cFn = null;
    private Context context;
    private float eOg = 1.0f;
    private List<C7620bi> yIP;
    private String yLV = null;

    /* renamed from: com.tencent.mm.ui.chatting.QQMailHistoryExporter$ImageSpanData */
    public static class ImageSpanData implements Parcelable {
        public static final Creator<ImageSpanData> CREATOR = new C155581();
        int coc;
        int endPos;
        String path;
        private int thumbnail = 0;

        /* renamed from: com.tencent.mm.ui.chatting.QQMailHistoryExporter$ImageSpanData$1 */
        static class C155581 implements Creator<ImageSpanData> {
            C155581() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ImageSpanData[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(30967);
                ImageSpanData imageSpanData = new ImageSpanData();
                imageSpanData.coc = parcel.readInt();
                imageSpanData.endPos = parcel.readInt();
                imageSpanData.path = parcel.readString();
                imageSpanData.thumbnail = parcel.readInt();
                AppMethodBeat.m2505o(30967);
                return imageSpanData;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(30968);
            parcel.writeInt(this.coc);
            parcel.writeInt(this.endPos);
            parcel.writeString(this.path);
            parcel.writeInt(this.thumbnail);
            AppMethodBeat.m2505o(30968);
        }

        static {
            AppMethodBeat.m2504i(30969);
            AppMethodBeat.m2505o(30969);
        }
    }

    static {
        AppMethodBeat.m2504i(30975);
        AppMethodBeat.m2505o(30975);
    }

    private static String ani(String str) {
        AppMethodBeat.m2504i(30970);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(30970);
            return str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            Object obj = 1;
            for (int length2 = iRk.length - 1; length2 >= 0; length2--) {
                if (iRk[length2] == charAt) {
                    stringBuffer.append(iRl[length2]);
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                stringBuffer.append(charAt);
            }
        }
        str2 = stringBuffer.toString();
        AppMethodBeat.m2505o(30970);
        return str2;
    }

    public QQMailHistoryExporter(Context context, List<C7620bi> list, C7616ad c7616ad) {
        this.context = context;
        this.yIP = list;
        this.cFn = c7616ad;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String dCL() {
        String str;
        AppMethodBeat.m2504i(30971);
        C4990ab.m7417i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", Integer.valueOf(this.yIP.size()));
        if (C1338a.m2865ga(this.context)) {
            this.eOg = C1338a.m2860dm(this.context);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<div id=\"history\">\n");
        stringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[]{Float.valueOf(this.eOg), Float.valueOf(this.eOg), dCM()}));
        for (C7620bi c7620bi : this.yIP) {
            String nd;
            if (this.yLV == null) {
                this.yLV = QQMailHistoryExporter.m23862nd(c7620bi.field_createTime);
                stringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[]{Float.valueOf(this.eOg), this.yLV}));
            } else {
                nd = QQMailHistoryExporter.m23862nd(c7620bi.field_createTime);
                if (!nd.equals(this.yLV)) {
                    this.yLV = nd;
                    stringBuilder.append("<br>");
                    stringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[]{Float.valueOf(this.eOg), this.yLV}));
                }
            }
            String concat;
            if (c7620bi.isText()) {
                if (!c7620bi.isText()) {
                    str = null;
                } else if (c7620bi.field_isSend == 1) {
                    str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), m23861aP(c7620bi), Float.valueOf(this.eOg), QQMailHistoryExporter.ani(c7620bi.field_content)});
                } else if (C1855t.m3896kH(this.cFn.field_username)) {
                    if (C1829bf.m3761ox(c7620bi.field_content) != -1) {
                        str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), m23861aP(c7620bi), Float.valueOf(this.eOg), QQMailHistoryExporter.ani(c7620bi.field_content.substring(C1829bf.m3761ox(c7620bi.field_content) + 1).trim())});
                    } else {
                        str = null;
                    }
                } else {
                    str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), m23861aP(c7620bi), Float.valueOf(this.eOg), QQMailHistoryExporter.ani(c7620bi.field_content)});
                }
                stringBuilder.append(str);
            } else if (c7620bi.drE()) {
                if (c7620bi.drE()) {
                    long j = c7620bi.field_msgId;
                    long j2 = c7620bi.field_msgSvrId;
                    nd = C44284ad.m80020nb(j);
                    if (C5046bo.isNullOrNil(nd)) {
                        nd = C44284ad.m80021nc(j2);
                    }
                    C4990ab.m7411d("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", nd);
                    if (!C5046bo.isNullOrNil(nd)) {
                        concat = "file://".concat(String.valueOf(nd));
                        nd = String.format(yLX, new Object[]{Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), concat, nd});
                        str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), m23861aP(c7620bi), Float.valueOf(this.eOg), nd});
                        stringBuilder.append(str);
                    }
                }
                str = null;
                stringBuilder.append(str);
            } else {
                nd = null;
                if (c7620bi.drD()) {
                    nd = String.format("[%s]", new Object[]{this.context.getString(C25738R.string.b8z)});
                } else if (c7620bi.dts()) {
                    if (c7620bi.field_isSend == 1) {
                        nd = this.context.getString(C25738R.string.b8x);
                    } else {
                        nd = this.context.getString(C25738R.string.b8w);
                    }
                } else if (c7620bi.bAC()) {
                    C45335jj c45335jj = new C45335jj();
                    c45335jj.cEF.cEA = 1;
                    c45335jj.cEF.csG = c7620bi;
                    C4879a.xxA.mo10055m(c45335jj);
                    nd = String.format("[%s]", new Object[]{c45335jj.cEG.cBp});
                } else if (c7620bi.bAA()) {
                    concat = "";
                    nd = c7620bi.field_content;
                    if (C1855t.m3896kH(this.cFn.field_username)) {
                        C4990ab.m7410d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
                        int ox = C1829bf.m3761ox(c7620bi.field_content);
                        if (ox != -1) {
                            nd = c7620bi.field_content.substring(ox + 1).trim();
                        }
                    }
                    C8910b me = C8910b.m16064me(C5046bo.anj(nd));
                    if (me == null) {
                        C4990ab.m7420w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
                        nd = String.format("[%s]", new Object[]{this.context.getString(C25738R.string.b8p)});
                    } else {
                        C40439f bT = C46494g.m87739bT(me.appId, true);
                        nd = (bT == null || C5046bo.isNullOrNil(bT.field_appName)) ? me.appName : bT.field_appName;
                        nd = C46494g.m87733b(this.context, bT, nd);
                        if (!c7620bi.dtz()) {
                            if (!c7620bi.dtA()) {
                                switch (me.type) {
                                    case 1:
                                        if (!C5046bo.isNullOrNil(nd)) {
                                            nd = String.format("[%s: %s]", new Object[]{nd, QQMailHistoryExporter.ani(me.title)});
                                            break;
                                        }
                                        nd = QQMailHistoryExporter.ani(me.title);
                                        break;
                                    case 2:
                                        nd = C44284ad.m80018a(c7620bi, me);
                                        if (!C5046bo.isNullOrNil(nd)) {
                                            concat = "file://".concat(String.valueOf(nd));
                                            nd = String.format(yLX, new Object[]{Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), concat, nd});
                                            break;
                                        }
                                    case 3:
                                        if (!C5046bo.isNullOrNil(me.description)) {
                                            nd = String.format("[%s: %s-%s]", new Object[]{this.context.getString(C25738R.string.b8v), QQMailHistoryExporter.ani(me.title), QQMailHistoryExporter.ani(me.description)});
                                            break;
                                        }
                                        nd = String.format("[%s: %s]", new Object[]{this.context.getString(C25738R.string.b8v), QQMailHistoryExporter.ani(me.title)});
                                        break;
                                    case 4:
                                    case 5:
                                        nd = String.format("[%s: %s]", new Object[]{QQMailHistoryExporter.ani(me.title), QQMailHistoryExporter.ani(me.url)});
                                        break;
                                    case 6:
                                        if (!C5046bo.isNullOrNil(me.description)) {
                                            nd = String.format("[%s: %s-%s(%s)]", new Object[]{this.context.getString(C25738R.string.b8t), QQMailHistoryExporter.ani(me.title), QQMailHistoryExporter.ani(me.description), this.context.getString(C25738R.string.b8q)});
                                            break;
                                        }
                                        nd = String.format("[%s: %s]", new Object[]{this.context.getString(C25738R.string.b8t), QQMailHistoryExporter.ani(me.title)});
                                        break;
                                    case 8:
                                        nd = String.format("[%s]", new Object[]{this.context.getString(C25738R.string.b8s)});
                                        break;
                                    default:
                                        nd = String.format("[%s]", new Object[]{this.context.getString(C25738R.string.b8p)});
                                        break;
                                }
                            }
                            nd = C44284ad.m80018a(c7620bi, me);
                            if (!C5046bo.isNullOrNil(nd)) {
                                concat = "file://".concat(String.valueOf(nd));
                                nd = String.format(yLX, new Object[]{Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), concat, nd});
                            }
                            nd = concat;
                        } else if (C5046bo.isNullOrNil(nd)) {
                            nd = QQMailHistoryExporter.ani(me.title);
                        } else {
                            nd = String.format("[%s: %s]", new Object[]{nd, QQMailHistoryExporter.ani(me.title)});
                        }
                    }
                } else if (c7620bi.dtw()) {
                    C9638aw.m17190ZK();
                    nd = C18628c.m29080XO().mo15260Rn(c7620bi.field_content).nickname;
                    nd = String.format("[%s: %s]", new Object[]{this.context.getString(C25738R.string.b8r), nd});
                } else if (c7620bi.bws()) {
                    r2 = new Object[3];
                    C37961o.all();
                    r2[1] = new File(C9720t.m17303uh(c7620bi.field_imgPath)).getName();
                    r2[2] = this.context.getString(C25738R.string.b8q);
                    nd = String.format("[%s: %s(%s)]", r2);
                } else if (c7620bi.dtx() || c7620bi.dty()) {
                    nd = String.format("[%s]", new Object[]{this.context.getString(C25738R.string.b8s)});
                }
                C4990ab.m7411d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", nd);
                stringBuilder.append(String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), m23861aP(c7620bi), Float.valueOf(this.eOg), nd}));
            }
        }
        stringBuilder.append("\n</div>\n");
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(30971);
        return str;
    }

    private String dCM() {
        String str;
        AppMethodBeat.m2504i(30972);
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
        AppMethodBeat.m2505o(30972);
        return str;
    }

    /* renamed from: aP */
    private String m23861aP(C7620bi c7620bi) {
        String str;
        AppMethodBeat.m2504i(30973);
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
            C4990ab.m7416i("MicroMsg.QQMailHistoryExporter", "isSend");
            str2 = C1853r.m3820YB();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(c7620bi.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(30973);
        return str2;
    }

    /* renamed from: nd */
    private static String m23862nd(long j) {
        AppMethodBeat.m2504i(30974);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
        AppMethodBeat.m2505o(30974);
        return format;
    }
}
