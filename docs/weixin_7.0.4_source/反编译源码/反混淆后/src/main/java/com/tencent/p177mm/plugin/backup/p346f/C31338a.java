package com.tencent.p177mm.plugin.backup.p346f;

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
import com.tencent.p177mm.plugin.backup.p1394h.C38657b;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p1394h.C45748c;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p346f.C11149i.C11150a;
import com.tencent.p177mm.plugin.backup.p346f.C45745h.C19972a;
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
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.backup.f.a */
public final class C31338a implements C27487l {

    /* renamed from: com.tencent.mm.plugin.backup.f.a$a */
    static class C31339a {
        public static String jrk = "<msg>";
        public static String jrl = "</msg>";
        public static String jvr = "]]>";

        /* renamed from: com.tencent.mm.plugin.backup.f.a$a$b */
        static class C2656b {
            StringBuffer jvt = new StringBuffer();

            C2656b() {
                AppMethodBeat.m2504i(17437);
                AppMethodBeat.m2505o(17437);
            }

            /* renamed from: Fi */
            public final void mo6719Fi(String str) {
                AppMethodBeat.m2504i(17438);
                this.jvt.append("<" + str + ">");
                AppMethodBeat.m2505o(17438);
            }

            /* renamed from: Fj */
            public final void mo6720Fj(String str) {
                AppMethodBeat.m2504i(17439);
                this.jvt.append("</" + str + ">");
                AppMethodBeat.m2505o(17439);
            }

            private void setText(String str) {
                AppMethodBeat.m2504i(17440);
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(17440);
                } else if (str.contains(C31339a.jvr)) {
                    this.jvt.append("<![CDATA[" + C5046bo.ani(str) + "]]>");
                    AppMethodBeat.m2505o(17440);
                } else {
                    this.jvt.append("<![CDATA[" + str + "]]>");
                    AppMethodBeat.m2505o(17440);
                }
            }

            private void setText(int i) {
                AppMethodBeat.m2504i(17441);
                this.jvt.append(i);
                AppMethodBeat.m2505o(17441);
            }

            /* renamed from: cY */
            public final void mo6722cY(String str, String str2) {
                AppMethodBeat.m2504i(17442);
                mo6719Fi(str);
                setText(str2);
                mo6720Fj(str);
                AppMethodBeat.m2505o(17442);
            }

            /* renamed from: bE */
            public final void mo6721bE(String str, int i) {
                AppMethodBeat.m2504i(17443);
                mo6719Fi(str);
                setText(i);
                mo6720Fj(str);
                AppMethodBeat.m2505o(17443);
            }

            /* renamed from: m */
            public final void mo6723m(String str, Map<String, String> map) {
                AppMethodBeat.m2504i(17444);
                this.jvt.append("<".concat(String.valueOf(str)));
                for (String str2 : map.keySet()) {
                    this.jvt.append(" " + str2 + " =  \"" + ((String) map.get(str2)) + "\" ");
                }
                this.jvt.append(">");
                map.clear();
                AppMethodBeat.m2505o(17444);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.f.a$a$a */
        static class C31340a {
            boolean bYN = true;
            Map<String, String> jvs = null;

            public C31340a(String str) {
                AppMethodBeat.m2504i(17435);
                this.jvs = C5035be.amR(str);
                if (this.jvs == null) {
                    this.bYN = false;
                    this.jvs = new HashMap();
                }
                AppMethodBeat.m2505o(17435);
            }

            /* Access modifiers changed, original: final */
            public final int getInt(String str) {
                AppMethodBeat.m2504i(17436);
                if (this.jvs.containsKey(str)) {
                    int i = C5046bo.getInt((String) this.jvs.get(str), 0);
                    AppMethodBeat.m2505o(17436);
                    return i;
                }
                AppMethodBeat.m2505o(17436);
                return 0;
            }
        }

        /* renamed from: Fh */
        public static String m50640Fh(String str) {
            AppMethodBeat.m2504i(17445);
            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(0, str);
            C31340a c31340a = new C31340a(str);
            String str2;
            if (c31340a.bYN) {
                String str3;
                String str4;
                String str5;
                C2656b c2656b = new C2656b();
                List list = b.fjr;
                HashMap hashMap = new HashMap();
                c2656b.mo6719Fi("msg");
                hashMap.put("appid", (String) c31340a.jvs.get(".msg.appmsg.$appid"));
                hashMap.put("sdkver", (String) c31340a.jvs.get(".msg.appmsg.$sdkver"));
                c2656b.mo6723m("appmsg", hashMap);
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
                c2656b.mo6722cY("title", str3);
                c2656b.mo6722cY("des", (String) c31340a.jvs.get(".msg.appmsg.des"));
                c2656b.mo6722cY(NativeProtocol.WEB_DIALOG_ACTION, (String) c31340a.jvs.get(".msg.appmsg.action"));
                c2656b.mo6721bE("type", c31340a.getInt(".msg.appmsg.type"));
                c2656b.mo6721bE("showtype", c31340a.getInt(".msg.appmsg.showtype"));
                c2656b.mo6722cY(C8741b.CONTENT, (String) c31340a.jvs.get(".msg.appmsg.content"));
                c2656b.mo6722cY("url", str4);
                c2656b.mo6722cY("lowurl", (String) c31340a.jvs.get(".msg.appmsg.lowurl"));
                c2656b.mo6719Fi("appattach");
                c2656b.mo6721bE("totallen", c31340a.getInt(".msg.appmsg.appattach.totallen"));
                c2656b.mo6722cY("attachid", (String) c31340a.jvs.get(".msg.appmsg.appattach.attachid"));
                c2656b.mo6722cY("fileext", (String) c31340a.jvs.get(".msg.appmsg.appattach.fileext"));
                c2656b.mo6720Fj("appattach");
                c2656b.mo6719Fi("mmreader");
                hashMap.put("type", b.type);
                hashMap.put("convMsgCount", list.size());
                c2656b.mo6723m("category", hashMap);
                c2656b.mo6722cY("name", b.cMh);
                c2656b.mo6719Fi("topnew");
                c2656b.mo6722cY("cover", (String) c31340a.jvs.get(".msg.appmsg.mmreader.category.topnew.cover"));
                c2656b.mo6722cY("width", (String) c31340a.jvs.get(".msg.appmsg.mmreader.category.topnew.width"));
                c2656b.mo6722cY("height", (String) c31340a.jvs.get(".msg.appmsg.mmreader.category.topnew.height"));
                c2656b.mo6722cY("digest", str5);
                c2656b.mo6720Fj("topnew");
                int i = 0;
                while (i < list.size()) {
                    c2656b.mo6719Fi("item");
                    if (list.get(i) != null) {
                        str4 = ((C32224p) list.get(i)).title;
                        str3 = ((C32224p) list.get(i)).url;
                        String str6 = ((C32224p) list.get(i)).fjv;
                        String str7 = ((C32224p) list.get(i)).fjw;
                        String str8 = ((C32224p) list.get(i)).time;
                        String str9 = ((C32224p) list.get(i)).fjx;
                        String str10 = ((C32224p) list.get(i)).fjy;
                        str2 = ((C32224p) list.get(i)).fjz;
                        c2656b.mo6722cY("title", str4);
                        c2656b.mo6722cY("url", str3);
                        c2656b.mo6722cY("shorturl", str6);
                        c2656b.mo6722cY("longurl", str7);
                        c2656b.mo6722cY("pub_time", str8);
                        c2656b.mo6722cY("cover", str9);
                        c2656b.mo6722cY("tweetid", str10);
                        c2656b.mo6722cY("digest", str2);
                        c2656b.mo6722cY("fileid", (String) c31340a.jvs.get((".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i))) + ".fileid"));
                        c2656b.mo6719Fi("source");
                        c2656b.mo6719Fi("source");
                        c2656b.mo6722cY("name", b.cMh);
                        c2656b.mo6720Fj("source");
                        c2656b.mo6720Fj("source");
                        c2656b.mo6720Fj("item");
                    }
                    i++;
                }
                c2656b.mo6720Fj("category");
                c2656b.mo6719Fi(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                c2656b.mo6722cY("convName", b.cMg);
                c2656b.mo6722cY("nickname", b.cMh);
                c2656b.mo6720Fj(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                c2656b.mo6720Fj("mmreader");
                c2656b.mo6720Fj("appmsg");
                c2656b.mo6722cY("fromusername", b.cMg);
                c2656b.mo6721bE("scene", c31340a.getInt(".msg.scene"));
                c2656b.mo6719Fi("appinfo");
                c2656b.mo6722cY("version", (String) c31340a.jvs.get(".msg.appinfo.appname"));
                c2656b.mo6722cY("appname", (String) c31340a.jvs.get(".msg.appinfo.version"));
                c2656b.mo6720Fj("appinfo");
                c2656b.mo6722cY("commenturl", b.dJv);
                c2656b.mo6720Fj("msg");
                C4990ab.m7410d("MicroMsg.AppmsgConvert", "xml " + c2656b.jvt.toString());
                str2 = c2656b.jvt.toString();
                AppMethodBeat.m2505o(17445);
                return str2;
            }
            C4990ab.m7412e("MicroMsg.AppmsgConvert", "buffer error");
            str2 = "";
            AppMethodBeat.m2505o(17445);
            return str2;
        }
    }

    /* renamed from: a */
    public final int mo35219a(C40522gu c40522gu, boolean z, C7620bi c7620bi, String str, LinkedList<C19993u> linkedList, HashMap<Long, C19972a> hashMap, boolean z2, long j) {
        AppMethodBeat.m2504i(17446);
        int i;
        String str2;
        bts bts;
        switch (c7620bi.getType()) {
            case 1048625:
                if (C5046bo.isNullOrNil(c7620bi.field_content)) {
                    i = 0;
                } else {
                    i = c7620bi.field_content.getBytes().length;
                }
                if (c7620bi.field_content == null) {
                    AppMethodBeat.m2505o(17446);
                    return -1;
                }
                str2 = c7620bi.field_content;
                if (!C38635g.m65506Fd(str2)) {
                    str2 = c7620bi.field_content;
                    if (!C38635g.m65506Fd(str2)) {
                        C4990ab.m7412e("MicroMsg.BackupItemAppMsg", "get xml error ".concat(String.valueOf(str2)));
                        AppMethodBeat.m2505o(17446);
                        return 0;
                    }
                }
                if (!C5046bo.isNullOrNil(str2)) {
                    bts = new bts();
                    bts.alV(C5046bo.m7532bc(str2, ""));
                    c40522gu.vED = bts;
                    C8910b me = C8910b.m16064me(str2);
                    String Yb = C38658d.aUr().aUs().mo61502Yb();
                    String I = C38658d.aUr().aUs().aUo().mo73074I(c7620bi.field_imgPath, true);
                    String str3 = Yb + me.fgq;
                    if (C5730e.asZ(I) <= 0) {
                        I = str3 + "_thumb";
                    }
                    i = (i + C11149i.m18856a(new C11150a(I, c40522gu, (LinkedList) linkedList, 6, z, "_thumb", z2))) + C11149i.m18856a(new C11150a(str3, c40522gu, (LinkedList) linkedList, 5, z, z2, null));
                }
                AppMethodBeat.m2505o(17446);
                return i;
            case 285212721:
            case 486539313:
                if (C5046bo.isNullOrNil(c7620bi.field_content)) {
                    i = 0;
                } else {
                    i = c7620bi.field_content.getBytes().length;
                }
                if (z) {
                    AppMethodBeat.m2505o(17446);
                    return i;
                }
                str2 = C31339a.m50640Fh(c7620bi.field_content);
                if (C5046bo.isNullOrNil(str2)) {
                    AppMethodBeat.m2505o(17446);
                    return 0;
                }
                bts = new bts();
                bts.alV(C5046bo.m7532bc(str2, ""));
                c40522gu.vED = bts;
                AppMethodBeat.m2505o(17446);
                return i;
            default:
                i = C31338a.m50637b(c40522gu, z, c7620bi, str, linkedList, hashMap, z2, j);
                AppMethodBeat.m2505o(17446);
                return i;
        }
    }

    /* renamed from: a */
    public final int mo35220a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17448);
        String str2 = c40522gu.vEB.wVI;
        String str3 = c40522gu.vED.wVI;
        if (str3 == null) {
            AppMethodBeat.m2505o(17448);
            return 0;
        }
        int ox;
        c7620bi.setContent(str3);
        if (c7620bi.field_isSend != 1 && C45748c.m84549kH(str2)) {
            ox = C45748c.m84551ox(c40522gu.vED.wVI);
            if (ox != -1) {
                str3 = (c40522gu.vED.wVI + " ").substring(ox + 2).trim();
            }
        }
        String anj = C5046bo.anj(str3);
        C8910b me = C8910b.m16064me(anj);
        int i;
        if (me == null) {
            C4990ab.m7412e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
            AppMethodBeat.m2505o(17448);
            return 0;
        } else if (me.type == 2000) {
            c7620bi.setType(419430449);
            C45748c.m84550l(c7620bi);
            AppMethodBeat.m2505o(17448);
            return 0;
        } else if (me.type == 19 || me.type == 24) {
            c7620bi.setType(C4733l.m7100d(me));
            C45748c.m84550l(c7620bi);
            C18338na c18338na = new C18338na();
            c18338na.cJc.cHz = me.fgU;
            c18338na.cJc.cuQ = c7620bi.field_msgId;
            C4879a.xxA.mo10055m(c18338na);
            C4990ab.m7417i("MicroMsg.BackupItemAppMsg", "pathList:%s", c18338na.cJd.cJe);
            String[] split = c18338na.cJd.cJe.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            for (i = 0; i < split.length; i++) {
                anj = C38635g.m65512a(c40522gu, 7, ".".concat(String.valueOf(i)));
                if (!C5046bo.isNullOrNil(anj)) {
                    C4990ab.m7417i("MicroMsg.BackupItemAppMsg", "record media exit:%s, index:%d", anj, Integer.valueOf(i));
                    C5730e.m8644y(C38635g.m65503Fa(anj) + anj, split[i]);
                }
            }
            AppMethodBeat.m2505o(17448);
            return 0;
        } else {
            C40439f c40439f = new C40439f();
            c40439f.field_appId = me.appId;
            C38657b aUs = C38658d.aUr().aUs();
            C1819b c1819b;
            if (aUs.uin == 0) {
                c1819b = new C1819b();
                AppMethodBeat.m2505o(17448);
                throw c1819b;
            }
            if (aUs.jyw.mo10102b((C4925c) c40439f, new String[0]) && c40439f.field_appVersion < me.axy) {
                C38658d.aUr().aUt().mo73547g(1, me.appId);
            }
            c7620bi.setType(C4733l.m7100d(me));
            byte[] b = C38635g.m65520b(c40522gu, 6);
            if (b != null && c7620bi.field_msgId == 0) {
                str3 = C38658d.aUr().aUs().aUo().mo73094a(b, me.type == 2, CompressFormat.PNG);
                C4990ab.m7410d("MicroMsg.BackupItemAppMsg", C1447g.m3075Mq() + " thumbData MsgInfo path:" + str3);
                if (!C5046bo.isNullOrNil(str3)) {
                    c7620bi.mo14795jv(str3);
                    C4990ab.m7410d("MicroMsg.BackupItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(str3)));
                }
            }
            str2 = C38635g.m65511a(c40522gu, 8);
            i = C38635g.m65522c(c40522gu, 8);
            if (C5046bo.isNullOrNil(str2)) {
                str2 = C38635g.m65511a(c40522gu, 7);
                i = C38635g.m65522c(c40522gu, 7);
            }
            String str4 = C38635g.m65503Fa(str2) + str2;
            C45748c.m84550l(c7620bi);
            C8909j c8909j = new C8909j();
            me.mo20335a(c8909j);
            c8909j.field_msgId = c7620bi.field_msgId;
            C38657b aUs2 = C38658d.aUr().aUs();
            if (aUs2.uin == 0) {
                c1819b = new C1819b();
                AppMethodBeat.m2505o(17448);
                throw c1819b;
            }
            aUs2.jyv.mo10101b((C4925c) c8909j);
            if (!C5046bo.isNullOrNil(str2)) {
                C6977h XO = C38658d.aUr().aUs().mo61498XO();
                if (str.equals(c40522gu.vEB.wVI)) {
                    str2 = c40522gu.vEC.wVI;
                } else {
                    str2 = c40522gu.vEB.wVI;
                }
                C7620bi Q = XO.mo15241Q(str2, c40522gu.ptF);
                C30065b aiE = C38658d.aUr().aUs().aUq().aiE(me.csD);
                if (aiE == null) {
                    C4990ab.m7416i("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
                    long j = Q.field_msgId;
                    C8910b me2 = C8910b.m16064me(anj);
                    if (me2 != null) {
                        anj = C4733l.m7083X(C6457e.euQ, me2.title, me2.fgp);
                        int i2 = me2.sdkVer;
                        String str5 = me2.appId;
                        String str6 = me2.csD;
                        ox = me2.fgo;
                        C30065b c30065b = new C30065b();
                        c30065b.field_fileFullPath = anj;
                        c30065b.field_appId = str5;
                        c30065b.field_sdkVer = (long) i2;
                        c30065b.field_mediaSvrId = str6;
                        c30065b.field_totalLen = (long) ox;
                        c30065b.field_status = 101;
                        c30065b.field_isUpload = false;
                        c30065b.field_createTime = C5046bo.anU();
                        c30065b.field_lastModifyTime = C5046bo.anT();
                        c30065b.field_msgInfoId = j;
                        c30065b.field_netTimes = 0;
                        if (!C38658d.aUr().aUs().aUq().mo10101b((C4925c) c30065b)) {
                            C4990ab.m7413e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", Long.valueOf(j));
                        }
                    }
                    aiE = C38658d.aUr().aUs().aUq().aiE(me.csD);
                    if (aiE == null) {
                        C4990ab.m7413e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", me.csD);
                        AppMethodBeat.m2505o(17448);
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
                C5730e.m8644y(str4, aiE.field_fileFullPath);
                C38658d.aUr().aUs().aUq().mo48326a(aiE, new String[0]);
            }
            AppMethodBeat.m2505o(17448);
            return 0;
        }
    }

    /* renamed from: b */
    private static int m50637b(C40522gu c40522gu, boolean z, C7620bi c7620bi, String str, LinkedList<C19993u> linkedList, HashMap<Long, C19972a> hashMap, boolean z2, long j) {
        int i;
        C8910b me;
        AppMethodBeat.m2504i(17447);
        if (C5046bo.isNullOrNil(c7620bi.field_content)) {
            i = 0;
        } else {
            i = c7620bi.field_content.getBytes().length;
        }
        String str2 = c7620bi.field_content;
        if (c7620bi.field_isSend != 1 && C45748c.m84549kH(c7620bi.field_talker)) {
            int indexOf = c7620bi.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = c7620bi.field_content.substring(indexOf + 1);
            }
        }
        str2 = C5046bo.anj(str2);
        if (str2 != null) {
            me = C8910b.m16064me(str2);
        } else {
            me = null;
        }
        if (me == null) {
            C4990ab.m7412e("MicroMsg.BackupItemAppMsg", "content is null");
            AppMethodBeat.m2505o(17447);
            return 0;
        }
        C4990ab.m7410d("MicroMsg.BackupItemAppMsg", "content type " + me.type);
        String I = C38658d.aUr().aUs().aUo().mo73074I(c7620bi.field_imgPath, true);
        if (C5730e.m8628ct(I)) {
            i += C11149i.m18856a(new C11150a(I, c40522gu, (LinkedList) linkedList, 6, z, "_thumb", z2));
        } else if (me.type == 2) {
            AppMethodBeat.m2505o(17447);
            return -1;
        }
        C30065b aiE;
        switch (me.type) {
            case 2:
                if (!C5046bo.isNullOrNil(me.csD)) {
                    C30065b aiE2 = C38658d.aUr().aUs().aUq().aiE(me.csD);
                    if ((aiE2 != null && aiE2.bCR()) || (c7620bi.field_isSend == 1 && aiE2 != null && aiE2.field_isUpload)) {
                        I = aiE2.field_fileFullPath;
                        if (C5730e.m8628ct(I)) {
                            C4990ab.m7410d("MicroMsg.BackupItemAppMsg", "image ".concat(String.valueOf(I)));
                            i += C11149i.m18856a(new C11150a(I, c40522gu, (LinkedList) linkedList, 8, z, z2, null));
                            break;
                        }
                    }
                }
                break;
            case 6:
                aiE = C38658d.aUr().aUs().aUq().aiE(me.csD);
                if ((aiE != null && aiE.bCR()) || (c7620bi.field_isSend == 1 && aiE != null && aiE.field_isUpload)) {
                    C4990ab.m7410d("MicroMsg.BackupItemAppMsg", "full path " + aiE.field_fileFullPath);
                    if (C5730e.m8628ct(aiE.field_fileFullPath)) {
                        if (!z) {
                            if (C38634d.aSx() == 1 && ((long) (me.fgo / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) >= j && me.filemd5 != null) {
                                String str3;
                                String str4;
                                if (c7620bi.field_isSend == 1) {
                                    str3 = str;
                                    str4 = c7620bi.field_talker;
                                } else {
                                    str3 = c7620bi.field_talker;
                                    str4 = str;
                                }
                                C19993u c19993u = new C19993u();
                                i += C11149i.m18856a(new C11150a(aiE.field_fileFullPath, c40522gu, (LinkedList) linkedList, 7, z, true, c19993u));
                                if (hashMap != null) {
                                    C19972a c19972a = new C19972a();
                                    c19972a.jvy = c19993u;
                                    c19972a.cvZ = me.filemd5;
                                    c19972a.jvA = str3 + "_" + str4 + "_" + c7620bi.field_msgSvrId + "_backup";
                                    c19972a.jvz = c7620bi.field_msgSvrId;
                                    hashMap.put(Long.valueOf(c7620bi.field_msgSvrId), c19972a);
                                    break;
                                }
                            }
                            i += C11149i.m18856a(new C11150a(aiE.field_fileFullPath, c40522gu, (LinkedList) linkedList, 7, z, z2, null));
                            break;
                        }
                        i += C11149i.m18856a(new C11150a(aiE.field_fileFullPath, c40522gu, (LinkedList) linkedList, 7, z, z2, null));
                        break;
                    }
                }
                break;
            case 7:
                aiE = C38658d.aUr().aUs().aUq().aiE(me.csD);
                if ((aiE != null && aiE.bCR()) || (c7620bi.field_isSend == 1 && aiE != null && aiE.field_isUpload)) {
                    C4990ab.m7410d("MicroMsg.BackupItemAppMsg", "full path " + aiE.field_fileFullPath);
                    if (C5730e.m8628ct(aiE.field_fileFullPath)) {
                        i += C11149i.m18856a(new C11150a(aiE.field_fileFullPath, c40522gu, (LinkedList) linkedList, 7, z, z2, null));
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
                C4990ab.m7417i("MicroMsg.BackupItemAppMsg", "pathList:%s", c18338na.cJd.cJe);
                String[] split = c18338na.cJd.cJe.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= split.length) {
                        break;
                    }
                    if (C5730e.m8628ct(split[i3])) {
                        C4990ab.m7417i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", split[i3], Integer.valueOf(i3));
                        i += C11149i.m18856a(new C11150a(split[i3], c40522gu, (LinkedList) linkedList, 7, z, "_fav.".concat(String.valueOf(i3)), z2));
                    }
                    i2 = i3 + 1;
                }
        }
        AppMethodBeat.m2505o(17447);
        return i;
    }
}
