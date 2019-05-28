package com.tencent.p177mm.plugin.backup.bakoldlogic.p917b;

import android.graphics.Bitmap.CompressFormat;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C18338na;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p1393a.C27452a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p917b.C11111i.C11112a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11131d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C27478c;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5035be;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.b */
public final class C38641b implements C45737j {

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.b$a */
    static class C11106a {
        public static String jrk = "<msg>";
        public static String jrl = "</msg>";
        public static String jvr = "]]>";

        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.b$a$a */
        static class C11107a {
            boolean bYN = true;
            Map<String, String> jvs = null;

            public C11107a(String str) {
                AppMethodBeat.m2504i(17767);
                this.jvs = C5035be.amR(str);
                if (this.jvs == null) {
                    this.bYN = false;
                    this.jvs = new HashMap();
                }
                AppMethodBeat.m2505o(17767);
            }

            /* Access modifiers changed, original: final */
            public final int getInt(String str) {
                AppMethodBeat.m2504i(17768);
                if (this.jvs.containsKey(str)) {
                    int i = C5046bo.getInt((String) this.jvs.get(str), 0);
                    AppMethodBeat.m2505o(17768);
                    return i;
                }
                AppMethodBeat.m2505o(17768);
                return 0;
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.b$a$b */
        static class C11108b {
            StringBuffer jvt = new StringBuffer();

            C11108b() {
                AppMethodBeat.m2504i(17769);
                AppMethodBeat.m2505o(17769);
            }

            /* renamed from: Fi */
            public final void mo22806Fi(String str) {
                AppMethodBeat.m2504i(17770);
                this.jvt.append("<" + str + ">");
                AppMethodBeat.m2505o(17770);
            }

            /* renamed from: Fj */
            public final void mo22807Fj(String str) {
                AppMethodBeat.m2504i(17771);
                this.jvt.append("</" + str + ">");
                AppMethodBeat.m2505o(17771);
            }

            private void setText(String str) {
                AppMethodBeat.m2504i(17772);
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(17772);
                } else if (str.contains(C11106a.jvr)) {
                    this.jvt.append("<![CDATA[" + C5046bo.ani(str) + "]]>");
                    AppMethodBeat.m2505o(17772);
                } else {
                    this.jvt.append("<![CDATA[" + str + "]]>");
                    AppMethodBeat.m2505o(17772);
                }
            }

            private void setText(int i) {
                AppMethodBeat.m2504i(17773);
                this.jvt.append(i);
                AppMethodBeat.m2505o(17773);
            }

            /* renamed from: cY */
            public final void mo22809cY(String str, String str2) {
                AppMethodBeat.m2504i(17774);
                mo22806Fi(str);
                setText(str2);
                mo22807Fj(str);
                AppMethodBeat.m2505o(17774);
            }

            /* renamed from: bE */
            public final void mo22808bE(String str, int i) {
                AppMethodBeat.m2504i(17775);
                mo22806Fi(str);
                setText(i);
                mo22807Fj(str);
                AppMethodBeat.m2505o(17775);
            }

            /* renamed from: m */
            public final void mo22810m(String str, Map<String, String> map) {
                AppMethodBeat.m2504i(17776);
                this.jvt.append("<".concat(String.valueOf(str)));
                for (String str2 : map.keySet()) {
                    this.jvt.append(" " + str2 + " =  \"" + ((String) map.get(str2)) + "\" ");
                }
                this.jvt.append(">");
                map.clear();
                AppMethodBeat.m2505o(17776);
            }
        }

        /* renamed from: Fh */
        public static String m18814Fh(String str) {
            AppMethodBeat.m2504i(17777);
            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(0, str);
            C11107a c11107a = new C11107a(str);
            String str2;
            if (c11107a.bYN) {
                String str3;
                String str4;
                String str5;
                C11108b c11108b = new C11108b();
                List list = b.fjr;
                HashMap hashMap = new HashMap();
                c11108b.mo22806Fi("msg");
                hashMap.put("appid", (String) c11107a.jvs.get(".msg.appmsg.$appid"));
                hashMap.put("sdkver", (String) c11107a.jvs.get(".msg.appmsg.$sdkver"));
                c11108b.mo22810m("appmsg", hashMap);
                if (list == null) {
                    list = new LinkedList();
                }
                if (list.size() == 0) {
                    str3 = "";
                    str4 = "";
                    str5 = "";
                } else {
                    str3 = ((C32224p) list.get(0)).title;
                    str4 = ((C32224p) list.get(0)).url;
                    list.get(0);
                    str5 = ((C32224p) list.get(0)).fjz;
                }
                c11108b.mo22809cY("title", str3);
                c11108b.mo22809cY("des", (String) c11107a.jvs.get(".msg.appmsg.des"));
                c11108b.mo22809cY(NativeProtocol.WEB_DIALOG_ACTION, (String) c11107a.jvs.get(".msg.appmsg.action"));
                c11108b.mo22808bE("type", c11107a.getInt(".msg.appmsg.type"));
                c11108b.mo22808bE("showtype", c11107a.getInt(".msg.appmsg.showtype"));
                c11108b.mo22809cY(C8741b.CONTENT, (String) c11107a.jvs.get(".msg.appmsg.content"));
                c11108b.mo22809cY("url", str4);
                c11108b.mo22809cY("lowurl", (String) c11107a.jvs.get(".msg.appmsg.lowurl"));
                c11108b.mo22806Fi("appattach");
                c11108b.mo22808bE("totallen", c11107a.getInt(".msg.appmsg.appattach.totallen"));
                c11108b.mo22809cY("attachid", (String) c11107a.jvs.get(".msg.appmsg.appattach.attachid"));
                c11108b.mo22809cY("fileext", (String) c11107a.jvs.get(".msg.appmsg.appattach.fileext"));
                c11108b.mo22807Fj("appattach");
                c11108b.mo22806Fi("mmreader");
                hashMap.put("type", b.type);
                hashMap.put("convMsgCount", list.size());
                c11108b.mo22810m("category", hashMap);
                c11108b.mo22809cY("name", b.cMh);
                c11108b.mo22806Fi("topnew");
                c11108b.mo22809cY("cover", (String) c11107a.jvs.get(".msg.appmsg.mmreader.category.topnew.cover"));
                c11108b.mo22809cY("width", (String) c11107a.jvs.get(".msg.appmsg.mmreader.category.topnew.width"));
                c11108b.mo22809cY("height", (String) c11107a.jvs.get(".msg.appmsg.mmreader.category.topnew.height"));
                c11108b.mo22809cY("digest", str5);
                c11108b.mo22807Fj("topnew");
                int i = 0;
                while (i < list.size()) {
                    c11108b.mo22806Fi("item");
                    if (list.get(i) != null) {
                        str4 = ((C32224p) list.get(i)).title;
                        str3 = ((C32224p) list.get(i)).url;
                        String str6 = ((C32224p) list.get(i)).fjv;
                        String str7 = ((C32224p) list.get(i)).fjw;
                        String str8 = ((C32224p) list.get(i)).time;
                        String str9 = ((C32224p) list.get(i)).fjx;
                        String str10 = ((C32224p) list.get(i)).fjy;
                        str2 = ((C32224p) list.get(i)).fjz;
                        c11108b.mo22809cY("title", str4);
                        c11108b.mo22809cY("url", str3);
                        c11108b.mo22809cY("shorturl", str6);
                        c11108b.mo22809cY("longurl", str7);
                        c11108b.mo22809cY("pub_time", str8);
                        c11108b.mo22809cY("cover", str9);
                        c11108b.mo22809cY("tweetid", str10);
                        c11108b.mo22809cY("digest", str2);
                        c11108b.mo22809cY("fileid", (String) c11107a.jvs.get((".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i))) + ".fileid"));
                        c11108b.mo22806Fi("source");
                        c11108b.mo22806Fi("source");
                        c11108b.mo22809cY("name", b.cMh);
                        c11108b.mo22807Fj("source");
                        c11108b.mo22807Fj("source");
                        c11108b.mo22807Fj("item");
                    }
                    i++;
                }
                c11108b.mo22807Fj("category");
                c11108b.mo22806Fi(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                c11108b.mo22809cY("convName", b.cMg);
                c11108b.mo22809cY("nickname", b.cMh);
                c11108b.mo22807Fj(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                c11108b.mo22807Fj("mmreader");
                c11108b.mo22807Fj("appmsg");
                c11108b.mo22809cY("fromusername", b.cMg);
                c11108b.mo22808bE("scene", c11107a.getInt(".msg.scene"));
                c11108b.mo22806Fi("appinfo");
                c11108b.mo22809cY("version", (String) c11107a.jvs.get(".msg.appinfo.appname"));
                c11108b.mo22809cY("appname", (String) c11107a.jvs.get(".msg.appinfo.version"));
                c11108b.mo22807Fj("appinfo");
                c11108b.mo22809cY("commenturl", b.dJv);
                c11108b.mo22807Fj("msg");
                C4990ab.m7410d("MicroMsg.AppmsgConvert", "xml " + c11108b.jvt.toString());
                str2 = c11108b.jvt.toString();
                AppMethodBeat.m2505o(17777);
                return str2;
            }
            C4990ab.m7412e("MicroMsg.AppmsgConvert", "buffer error");
            str2 = "";
            AppMethodBeat.m2505o(17777);
            return str2;
        }
    }

    /* renamed from: a */
    public final int mo22811a(C40522gu c40522gu, C7620bi c7620bi, LinkedList<C19993u> linkedList) {
        AppMethodBeat.m2504i(17778);
        bts bts;
        switch (c7620bi.getType()) {
            case 1048625:
                int i;
                if (C5046bo.isNullOrNil(c7620bi.field_content)) {
                    i = 0;
                } else {
                    i = c7620bi.field_content.getBytes().length;
                }
                if (c7620bi.field_content == null) {
                    AppMethodBeat.m2505o(17778);
                    return -1;
                }
                String trim = C44218ap.aps(c7620bi.field_content).xXL.trim();
                if (!C27452a.m43553Fd(trim)) {
                    trim = c7620bi.field_content;
                    if (!C27452a.m43553Fd(trim)) {
                        C4990ab.m7412e("MicroMsg.BakOldItemAppMsg", "get xml error ".concat(String.valueOf(trim)));
                        AppMethodBeat.m2505o(17778);
                        return 0;
                    }
                }
                if (!C5046bo.isNullOrNil(trim)) {
                    bts = new bts();
                    bts.alV(C5046bo.m7532bc(trim, ""));
                    c40522gu.vED = bts;
                    C8910b me = C8910b.m16064me(trim);
                    String Yb = C11124b.aUY().aUZ().mo45273Yb();
                    String I = C11124b.aUY().aUZ().aUo().mo73074I(c7620bi.field_imgPath, true);
                    String str = Yb + me.fgq;
                    if (C5730e.asZ(I) <= 0) {
                        AppMethodBeat.m2505o(17778);
                        return -1;
                    }
                    i = (C11111i.m18825a(new C11112a(I, c40522gu, linkedList, 6, "_thumb")) + i) + C11111i.m18825a(new C11112a(str, c40522gu, linkedList, C11124b.aUY().aUZ().aUp().aqi(C44218ap.aps(C1946aa.m4148a(c40522gu.vED)).cvZ)));
                }
                AppMethodBeat.m2505o(17778);
                return i;
            case 285212721:
                int i2;
                if (C5046bo.isNullOrNil(c7620bi.field_content)) {
                    i2 = 0;
                } else {
                    i2 = c7620bi.field_content.getBytes().length;
                }
                String Fh = C11106a.m18814Fh(c7620bi.field_content);
                if (C5046bo.isNullOrNil(Fh)) {
                    AppMethodBeat.m2505o(17778);
                    return 0;
                }
                bts = new bts();
                bts.alV(C5046bo.m7532bc(Fh, ""));
                c40522gu.vED = bts;
                AppMethodBeat.m2505o(17778);
                return i2;
            default:
                int b = C38641b.m65532b(c40522gu, c7620bi, linkedList);
                AppMethodBeat.m2505o(17778);
                return b;
        }
    }

    /* renamed from: a */
    public final int mo22812a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17780);
        String str2 = c40522gu.vEB.wVI;
        String str3 = c40522gu.vED.wVI;
        if (str3 == null) {
            AppMethodBeat.m2505o(17780);
            return 0;
        }
        int ox;
        c7620bi.setContent(str3);
        if (c7620bi.field_isSend != 1 && C11131d.m18844kH(str2)) {
            ox = C11131d.m18846ox(c40522gu.vED.wVI);
            if (ox != -1) {
                str3 = (c40522gu.vED.wVI + " ").substring(ox + 2).trim();
            }
        }
        String anj = C5046bo.anj(str3);
        C8910b me = C8910b.m16064me(anj);
        int i;
        if (me == null) {
            C4990ab.m7412e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
            AppMethodBeat.m2505o(17780);
            return 0;
        } else if (me.type == 2000) {
            c7620bi.setType(419430449);
            C11131d.m18845l(c7620bi);
            AppMethodBeat.m2505o(17780);
            return 0;
        } else if (me.type == 19 || me.type == 24) {
            c7620bi.setType(C4733l.m7100d(me));
            C11131d.m18845l(c7620bi);
            C18338na c18338na = new C18338na();
            c18338na.cJc.cHz = me.fgU;
            c18338na.cJc.cuQ = c7620bi.field_msgId;
            C4879a.xxA.mo10055m(c18338na);
            C4990ab.m7417i("MicroMsg.BakOldItemAppMsg", "pathList:%s", c18338na.cJd.cJe);
            String[] split = c18338na.cJd.cJe.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            for (i = 0; i < split.length; i++) {
                anj = C27452a.m43558a(c40522gu, 7, ".".concat(String.valueOf(i)));
                if (!C5046bo.isNullOrNil(anj)) {
                    C4990ab.m7417i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", anj, Integer.valueOf(i));
                    C5730e.m8644y(C27452a.m43555Fp(anj), split[i]);
                }
            }
            AppMethodBeat.m2505o(17780);
            return 0;
        } else {
            C40439f c40439f = new C40439f();
            c40439f.field_appId = me.appId;
            C27478c aUZ = C11124b.aUY().aUZ();
            C1819b c1819b;
            if (aUZ.uin == 0) {
                c1819b = new C1819b();
                AppMethodBeat.m2505o(17780);
                throw c1819b;
            }
            if (aUZ.jyw.mo10102b((C4925c) c40439f, new String[0]) && c40439f.field_appVersion < me.axy) {
                C11124b.aUY().aVa().mo73539g(1, me.appId);
            }
            c7620bi.setType(C4733l.m7100d(me));
            byte[] b = C27452a.m43561b(c40522gu, 6);
            if (b != null && c7620bi.field_msgId == 0) {
                str3 = C11124b.aUY().aUZ().aUo().mo73094a(b, me.type == 2, CompressFormat.PNG);
                C4990ab.m7410d("MicroMsg.BakOldItemAppMsg", C1447g.m3075Mq() + " thumbData MsgInfo path:" + str3);
                if (!C5046bo.isNullOrNil(str3)) {
                    c7620bi.mo14795jv(str3);
                    C4990ab.m7410d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(str3)));
                }
            }
            str2 = C27452a.m43557a(c40522gu, 8);
            i = C27452a.m43563c(c40522gu, 8);
            if (C5046bo.isNullOrNil(str2)) {
                str2 = C27452a.m43557a(c40522gu, 7);
                i = C27452a.m43563c(c40522gu, 7);
            }
            String Fp = C27452a.m43555Fp(str2);
            C11131d.m18845l(c7620bi);
            C8909j c8909j = new C8909j();
            me.mo20335a(c8909j);
            c8909j.field_msgId = c7620bi.field_msgId;
            C27478c aUZ2 = C11124b.aUY().aUZ();
            if (aUZ2.uin == 0) {
                c1819b = new C1819b();
                AppMethodBeat.m2505o(17780);
                throw c1819b;
            }
            aUZ2.jyv.mo10101b((C4925c) c8909j);
            if (!C5046bo.isNullOrNil(str2)) {
                C6977h XO = C11124b.aUY().aUZ().mo45269XO();
                if (str.equals(c40522gu.vEB.wVI)) {
                    str2 = c40522gu.vEC.wVI;
                } else {
                    str2 = c40522gu.vEB.wVI;
                }
                C7620bi Q = XO.mo15241Q(str2, c40522gu.ptF);
                C30065b aiE = C11124b.aUY().aUZ().aUq().aiE(me.csD);
                if (aiE == null) {
                    C4990ab.m7416i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
                    long j = Q.field_msgId;
                    C8910b me2 = C8910b.m16064me(anj);
                    if (me2 != null) {
                        anj = C4733l.m7083X(C6457e.euQ, me2.title, me2.fgp);
                        int i2 = me2.sdkVer;
                        String str4 = me2.appId;
                        String str5 = me2.csD;
                        ox = me2.fgo;
                        C30065b c30065b = new C30065b();
                        c30065b.field_fileFullPath = anj;
                        c30065b.field_appId = str4;
                        c30065b.field_sdkVer = (long) i2;
                        c30065b.field_mediaSvrId = str5;
                        c30065b.field_totalLen = (long) ox;
                        c30065b.field_status = 101;
                        c30065b.field_isUpload = false;
                        c30065b.field_createTime = C5046bo.anU();
                        c30065b.field_lastModifyTime = C5046bo.anT();
                        c30065b.field_msgInfoId = j;
                        c30065b.field_netTimes = 0;
                        if (!C11124b.aUY().aUZ().aUq().mo10101b((C4925c) c30065b)) {
                            C4990ab.m7413e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", Long.valueOf(j));
                        }
                    }
                    aiE = C11124b.aUY().aUZ().aUq().aiE(me.csD);
                    if (aiE == null) {
                        C4990ab.m7413e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", me.csD);
                        AppMethodBeat.m2505o(17780);
                        return 0;
                    } else if (!(me.fgo == 0 || i == 0)) {
                        if (i >= me.fgo) {
                            aiE.field_status = 199;
                        } else if (c7620bi.field_isSend == 1) {
                            aiE.field_status = 105;
                        } else {
                            aiE.field_status = 102;
                        }
                    }
                }
                long j2 = (long) i;
                aiE.field_offset = j2;
                aiE.field_totalLen = j2;
                C5730e.m8634is(Fp, aiE.field_fileFullPath);
                C11124b.aUY().aUZ().aUq().mo48326a(aiE, new String[0]);
            }
            AppMethodBeat.m2505o(17780);
            return 0;
        }
    }

    /* renamed from: b */
    private static int m65532b(C40522gu c40522gu, C7620bi c7620bi, LinkedList<C19993u> linkedList) {
        int i;
        C8910b me;
        AppMethodBeat.m2504i(17779);
        if (C5046bo.isNullOrNil(c7620bi.field_content)) {
            i = 0;
        } else {
            i = c7620bi.field_content.getBytes().length;
        }
        String str = c7620bi.field_content;
        if (c7620bi.field_isSend != 1 && C11131d.m18844kH(c7620bi.field_talker)) {
            int indexOf = c7620bi.field_content.indexOf(58);
            if (indexOf != -1) {
                str = c7620bi.field_content.substring(indexOf + 1);
            }
        }
        str = C5046bo.anj(str);
        if (str != null) {
            me = C8910b.m16064me(str);
        } else {
            me = null;
        }
        if (me == null) {
            C4990ab.m7412e("MicroMsg.BakOldItemAppMsg", "content is null");
            AppMethodBeat.m2505o(17779);
            return 0;
        }
        C4990ab.m7410d("MicroMsg.BakOldItemAppMsg", "content type " + me.type);
        String I = C11124b.aUY().aUZ().aUo().mo73074I(c7620bi.field_imgPath, true);
        if (C5730e.m8628ct(I)) {
            i += C11111i.m18825a(new C11112a(I, c40522gu, linkedList, 6, "_thumb"));
        } else if (me.type == 2) {
            AppMethodBeat.m2505o(17779);
            return -1;
        }
        C30065b aiE;
        switch (me.type) {
            case 2:
                if (!C5046bo.isNullOrNil(me.csD)) {
                    C30065b aiE2 = C11124b.aUY().aUZ().aUq().aiE(me.csD);
                    if ((aiE2 != null && aiE2.bCR()) || (c7620bi.field_isSend == 1 && aiE2 != null && aiE2.field_isUpload)) {
                        I = aiE2.field_fileFullPath;
                        if (C5730e.m8628ct(I)) {
                            C4990ab.m7410d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(I)));
                            i += C11111i.m18825a(new C11112a(I, c40522gu, linkedList, 8, false, null));
                            break;
                        }
                    }
                }
                break;
            case 6:
                aiE = C11124b.aUY().aUZ().aUq().aiE(me.csD);
                if ((aiE != null && aiE.bCR()) || (c7620bi.field_isSend == 1 && aiE != null && aiE.field_isUpload)) {
                    C4990ab.m7410d("MicroMsg.BakOldItemAppMsg", "full path " + aiE.field_fileFullPath);
                    if (C5730e.m8628ct(aiE.field_fileFullPath)) {
                        if (C38634d.aSx() == 1 && ((long) (me.fgo / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) >= 0 && me.filemd5 != null) {
                            i += C11111i.m18825a(new C11112a(aiE.field_fileFullPath, c40522gu, linkedList, 7, true, new C19993u()));
                            break;
                        }
                        i += C11111i.m18825a(new C11112a(aiE.field_fileFullPath, c40522gu, linkedList, 7, false, null));
                        break;
                    }
                }
                break;
            case 7:
                aiE = C11124b.aUY().aUZ().aUq().aiE(me.csD);
                if ((aiE != null && aiE.bCR()) || (c7620bi.field_isSend == 1 && aiE != null && aiE.field_isUpload)) {
                    C4990ab.m7410d("MicroMsg.BakOldItemAppMsg", "full path " + aiE.field_fileFullPath);
                    if (C5730e.m8628ct(aiE.field_fileFullPath)) {
                        i += C11111i.m18825a(new C11112a(aiE.field_fileFullPath, c40522gu, linkedList, 7, false, null));
                        break;
                    }
                }
                break;
            case 19:
            case 24:
                C18338na c18338na = new C18338na();
                c18338na.cJc.cHz = me.fgU;
                c18338na.cJc.cuQ = c7620bi.field_msgId;
                C4879a.xxA.mo10055m(c18338na);
                C4990ab.m7417i("MicroMsg.BakOldItemAppMsg", "pathList:%s", c18338na.cJd.cJe);
                String[] split = c18338na.cJd.cJe.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (C5730e.m8628ct(split[i2])) {
                        C4990ab.m7417i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", split[i2], Integer.valueOf(i2));
                        i += C11111i.m18825a(new C11112a(split[i2], c40522gu, linkedList, 7, "_fav.".concat(String.valueOf(i2))));
                    }
                }
                break;
        }
        AppMethodBeat.m2505o(17779);
        return i;
    }
}
