package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bz.a;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter {
    private static final char[] iRk = new char[]{'<', '>', '\"', '\'', '&', 10};
    private static final String[] iRl = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />"};
    private static final String yLX = ("<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + u.hL("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>");
    private ad cFn = null;
    private Context context;
    private float eOg = 1.0f;
    private List<bi> yIP;
    private String yLV = null;

    public static class ImageSpanData implements Parcelable {
        public static final Creator<ImageSpanData> CREATOR = new Creator<ImageSpanData>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ImageSpanData[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(30967);
                ImageSpanData imageSpanData = new ImageSpanData();
                imageSpanData.coc = parcel.readInt();
                imageSpanData.endPos = parcel.readInt();
                imageSpanData.path = parcel.readString();
                imageSpanData.thumbnail = parcel.readInt();
                AppMethodBeat.o(30967);
                return imageSpanData;
            }
        };
        int coc;
        int endPos;
        String path;
        private int thumbnail = 0;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(30968);
            parcel.writeInt(this.coc);
            parcel.writeInt(this.endPos);
            parcel.writeString(this.path);
            parcel.writeInt(this.thumbnail);
            AppMethodBeat.o(30968);
        }

        static {
            AppMethodBeat.i(30969);
            AppMethodBeat.o(30969);
        }
    }

    static {
        AppMethodBeat.i(30975);
        AppMethodBeat.o(30975);
    }

    private static String ani(String str) {
        AppMethodBeat.i(30970);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(30970);
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
        AppMethodBeat.o(30970);
        return str2;
    }

    public QQMailHistoryExporter(Context context, List<bi> list, ad adVar) {
        this.context = context;
        this.yIP = list;
        this.cFn = adVar;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String dCL() {
        String str;
        AppMethodBeat.i(30971);
        ab.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", Integer.valueOf(this.yIP.size()));
        if (a.ga(this.context)) {
            this.eOg = a.dm(this.context);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<div id=\"history\">\n");
        stringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[]{Float.valueOf(this.eOg), Float.valueOf(this.eOg), dCM()}));
        for (bi biVar : this.yIP) {
            String nd;
            if (this.yLV == null) {
                this.yLV = nd(biVar.field_createTime);
                stringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[]{Float.valueOf(this.eOg), this.yLV}));
            } else {
                nd = nd(biVar.field_createTime);
                if (!nd.equals(this.yLV)) {
                    this.yLV = nd;
                    stringBuilder.append("<br>");
                    stringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[]{Float.valueOf(this.eOg), this.yLV}));
                }
            }
            String concat;
            if (biVar.isText()) {
                if (!biVar.isText()) {
                    str = null;
                } else if (biVar.field_isSend == 1) {
                    str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), aP(biVar), Float.valueOf(this.eOg), ani(biVar.field_content)});
                } else if (t.kH(this.cFn.field_username)) {
                    if (bf.ox(biVar.field_content) != -1) {
                        str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), aP(biVar), Float.valueOf(this.eOg), ani(biVar.field_content.substring(bf.ox(biVar.field_content) + 1).trim())});
                    } else {
                        str = null;
                    }
                } else {
                    str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), aP(biVar), Float.valueOf(this.eOg), ani(biVar.field_content)});
                }
                stringBuilder.append(str);
            } else if (biVar.drE()) {
                if (biVar.drE()) {
                    long j = biVar.field_msgId;
                    long j2 = biVar.field_msgSvrId;
                    nd = ad.nb(j);
                    if (bo.isNullOrNil(nd)) {
                        nd = ad.nc(j2);
                    }
                    ab.d("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", nd);
                    if (!bo.isNullOrNil(nd)) {
                        concat = "file://".concat(String.valueOf(nd));
                        nd = String.format(yLX, new Object[]{Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), concat, nd});
                        str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), aP(biVar), Float.valueOf(this.eOg), nd});
                        stringBuilder.append(str);
                    }
                }
                str = null;
                stringBuilder.append(str);
            } else {
                nd = null;
                if (biVar.drD()) {
                    nd = String.format("[%s]", new Object[]{this.context.getString(R.string.b8z)});
                } else if (biVar.dts()) {
                    if (biVar.field_isSend == 1) {
                        nd = this.context.getString(R.string.b8x);
                    } else {
                        nd = this.context.getString(R.string.b8w);
                    }
                } else if (biVar.bAC()) {
                    jj jjVar = new jj();
                    jjVar.cEF.cEA = 1;
                    jjVar.cEF.csG = biVar;
                    com.tencent.mm.sdk.b.a.xxA.m(jjVar);
                    nd = String.format("[%s]", new Object[]{jjVar.cEG.cBp});
                } else if (biVar.bAA()) {
                    concat = "";
                    nd = biVar.field_content;
                    if (t.kH(this.cFn.field_username)) {
                        ab.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
                        int ox = bf.ox(biVar.field_content);
                        if (ox != -1) {
                            nd = biVar.field_content.substring(ox + 1).trim();
                        }
                    }
                    b me = b.me(bo.anj(nd));
                    if (me == null) {
                        ab.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
                        nd = String.format("[%s]", new Object[]{this.context.getString(R.string.b8p)});
                    } else {
                        f bT = g.bT(me.appId, true);
                        nd = (bT == null || bo.isNullOrNil(bT.field_appName)) ? me.appName : bT.field_appName;
                        nd = g.b(this.context, bT, nd);
                        if (!biVar.dtz()) {
                            if (!biVar.dtA()) {
                                switch (me.type) {
                                    case 1:
                                        if (!bo.isNullOrNil(nd)) {
                                            nd = String.format("[%s: %s]", new Object[]{nd, ani(me.title)});
                                            break;
                                        }
                                        nd = ani(me.title);
                                        break;
                                    case 2:
                                        nd = ad.a(biVar, me);
                                        if (!bo.isNullOrNil(nd)) {
                                            concat = "file://".concat(String.valueOf(nd));
                                            nd = String.format(yLX, new Object[]{Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), concat, nd});
                                            break;
                                        }
                                    case 3:
                                        if (!bo.isNullOrNil(me.description)) {
                                            nd = String.format("[%s: %s-%s]", new Object[]{this.context.getString(R.string.b8v), ani(me.title), ani(me.description)});
                                            break;
                                        }
                                        nd = String.format("[%s: %s]", new Object[]{this.context.getString(R.string.b8v), ani(me.title)});
                                        break;
                                    case 4:
                                    case 5:
                                        nd = String.format("[%s: %s]", new Object[]{ani(me.title), ani(me.url)});
                                        break;
                                    case 6:
                                        if (!bo.isNullOrNil(me.description)) {
                                            nd = String.format("[%s: %s-%s(%s)]", new Object[]{this.context.getString(R.string.b8t), ani(me.title), ani(me.description), this.context.getString(R.string.b8q)});
                                            break;
                                        }
                                        nd = String.format("[%s: %s]", new Object[]{this.context.getString(R.string.b8t), ani(me.title)});
                                        break;
                                    case 8:
                                        nd = String.format("[%s]", new Object[]{this.context.getString(R.string.b8s)});
                                        break;
                                    default:
                                        nd = String.format("[%s]", new Object[]{this.context.getString(R.string.b8p)});
                                        break;
                                }
                            }
                            nd = ad.a(biVar, me);
                            if (!bo.isNullOrNil(nd)) {
                                concat = "file://".concat(String.valueOf(nd));
                                nd = String.format(yLX, new Object[]{Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), concat, nd});
                            }
                            nd = concat;
                        } else if (bo.isNullOrNil(nd)) {
                            nd = ani(me.title);
                        } else {
                            nd = String.format("[%s: %s]", new Object[]{nd, ani(me.title)});
                        }
                    }
                } else if (biVar.dtw()) {
                    aw.ZK();
                    nd = c.XO().Rn(biVar.field_content).nickname;
                    nd = String.format("[%s: %s]", new Object[]{this.context.getString(R.string.b8r), nd});
                } else if (biVar.bws()) {
                    r2 = new Object[3];
                    o.all();
                    r2[1] = new File(com.tencent.mm.modelvideo.t.uh(biVar.field_imgPath)).getName();
                    r2[2] = this.context.getString(R.string.b8q);
                    nd = String.format("[%s: %s(%s)]", r2);
                } else if (biVar.dtx() || biVar.dty()) {
                    nd = String.format("[%s]", new Object[]{this.context.getString(R.string.b8s)});
                }
                ab.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", nd);
                stringBuilder.append(String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.eOg), aP(biVar), Float.valueOf(this.eOg), nd}));
            }
        }
        stringBuilder.append("\n</div>\n");
        str = stringBuilder.toString();
        AppMethodBeat.o(30971);
        return str;
    }

    private String dCM() {
        String str;
        AppMethodBeat.i(30972);
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
        AppMethodBeat.o(30972);
        return str;
    }

    private String aP(bi biVar) {
        String str;
        AppMethodBeat.i(30973);
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
            ab.i("MicroMsg.QQMailHistoryExporter", "isSend");
            str2 = r.YB();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(biVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        str2 = stringBuilder.toString();
        AppMethodBeat.o(30973);
        return str2;
    }

    private static String nd(long j) {
        AppMethodBeat.i(30974);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
        AppMethodBeat.o(30974);
        return format;
    }
}
