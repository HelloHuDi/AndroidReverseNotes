package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.af.o;
import com.tencent.mm.af.p;
import com.tencent.mm.g.a.na;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements j {

    static class a {
        public static String jrk = "<msg>";
        public static String jrl = "</msg>";
        public static String jvr = "]]>";

        static class a {
            boolean bYN = true;
            Map<String, String> jvs = null;

            public a(String str) {
                AppMethodBeat.i(17767);
                this.jvs = be.amR(str);
                if (this.jvs == null) {
                    this.bYN = false;
                    this.jvs = new HashMap();
                }
                AppMethodBeat.o(17767);
            }

            /* Access modifiers changed, original: final */
            public final int getInt(String str) {
                AppMethodBeat.i(17768);
                if (this.jvs.containsKey(str)) {
                    int i = bo.getInt((String) this.jvs.get(str), 0);
                    AppMethodBeat.o(17768);
                    return i;
                }
                AppMethodBeat.o(17768);
                return 0;
            }
        }

        static class b {
            StringBuffer jvt = new StringBuffer();

            b() {
                AppMethodBeat.i(17769);
                AppMethodBeat.o(17769);
            }

            public final void Fi(String str) {
                AppMethodBeat.i(17770);
                this.jvt.append("<" + str + ">");
                AppMethodBeat.o(17770);
            }

            public final void Fj(String str) {
                AppMethodBeat.i(17771);
                this.jvt.append("</" + str + ">");
                AppMethodBeat.o(17771);
            }

            private void setText(String str) {
                AppMethodBeat.i(17772);
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(17772);
                } else if (str.contains(a.jvr)) {
                    this.jvt.append("<![CDATA[" + bo.ani(str) + "]]>");
                    AppMethodBeat.o(17772);
                } else {
                    this.jvt.append("<![CDATA[" + str + "]]>");
                    AppMethodBeat.o(17772);
                }
            }

            private void setText(int i) {
                AppMethodBeat.i(17773);
                this.jvt.append(i);
                AppMethodBeat.o(17773);
            }

            public final void cY(String str, String str2) {
                AppMethodBeat.i(17774);
                Fi(str);
                setText(str2);
                Fj(str);
                AppMethodBeat.o(17774);
            }

            public final void bE(String str, int i) {
                AppMethodBeat.i(17775);
                Fi(str);
                setText(i);
                Fj(str);
                AppMethodBeat.o(17775);
            }

            public final void m(String str, Map<String, String> map) {
                AppMethodBeat.i(17776);
                this.jvt.append("<".concat(String.valueOf(str)));
                for (String str2 : map.keySet()) {
                    this.jvt.append(" " + str2 + " =  \"" + ((String) map.get(str2)) + "\" ");
                }
                this.jvt.append(">");
                map.clear();
                AppMethodBeat.o(17776);
            }
        }

        public static String Fh(String str) {
            AppMethodBeat.i(17777);
            o b = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(0, str);
            a aVar = new a(str);
            String str2;
            if (aVar.bYN) {
                String str3;
                String str4;
                String str5;
                b bVar = new b();
                List list = b.fjr;
                HashMap hashMap = new HashMap();
                bVar.Fi("msg");
                hashMap.put("appid", (String) aVar.jvs.get(".msg.appmsg.$appid"));
                hashMap.put("sdkver", (String) aVar.jvs.get(".msg.appmsg.$sdkver"));
                bVar.m("appmsg", hashMap);
                if (list == null) {
                    list = new LinkedList();
                }
                if (list.size() == 0) {
                    str3 = "";
                    str4 = "";
                    str5 = "";
                } else {
                    str3 = ((p) list.get(0)).title;
                    str4 = ((p) list.get(0)).url;
                    list.get(0);
                    str5 = ((p) list.get(0)).fjz;
                }
                bVar.cY("title", str3);
                bVar.cY("des", (String) aVar.jvs.get(".msg.appmsg.des"));
                bVar.cY(NativeProtocol.WEB_DIALOG_ACTION, (String) aVar.jvs.get(".msg.appmsg.action"));
                bVar.bE("type", aVar.getInt(".msg.appmsg.type"));
                bVar.bE("showtype", aVar.getInt(".msg.appmsg.showtype"));
                bVar.cY(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, (String) aVar.jvs.get(".msg.appmsg.content"));
                bVar.cY("url", str4);
                bVar.cY("lowurl", (String) aVar.jvs.get(".msg.appmsg.lowurl"));
                bVar.Fi("appattach");
                bVar.bE("totallen", aVar.getInt(".msg.appmsg.appattach.totallen"));
                bVar.cY("attachid", (String) aVar.jvs.get(".msg.appmsg.appattach.attachid"));
                bVar.cY("fileext", (String) aVar.jvs.get(".msg.appmsg.appattach.fileext"));
                bVar.Fj("appattach");
                bVar.Fi("mmreader");
                hashMap.put("type", b.type);
                hashMap.put("convMsgCount", list.size());
                bVar.m("category", hashMap);
                bVar.cY("name", b.cMh);
                bVar.Fi("topnew");
                bVar.cY("cover", (String) aVar.jvs.get(".msg.appmsg.mmreader.category.topnew.cover"));
                bVar.cY("width", (String) aVar.jvs.get(".msg.appmsg.mmreader.category.topnew.width"));
                bVar.cY("height", (String) aVar.jvs.get(".msg.appmsg.mmreader.category.topnew.height"));
                bVar.cY("digest", str5);
                bVar.Fj("topnew");
                int i = 0;
                while (i < list.size()) {
                    bVar.Fi("item");
                    if (list.get(i) != null) {
                        str4 = ((p) list.get(i)).title;
                        str3 = ((p) list.get(i)).url;
                        String str6 = ((p) list.get(i)).fjv;
                        String str7 = ((p) list.get(i)).fjw;
                        String str8 = ((p) list.get(i)).time;
                        String str9 = ((p) list.get(i)).fjx;
                        String str10 = ((p) list.get(i)).fjy;
                        str2 = ((p) list.get(i)).fjz;
                        bVar.cY("title", str4);
                        bVar.cY("url", str3);
                        bVar.cY("shorturl", str6);
                        bVar.cY("longurl", str7);
                        bVar.cY("pub_time", str8);
                        bVar.cY("cover", str9);
                        bVar.cY("tweetid", str10);
                        bVar.cY("digest", str2);
                        bVar.cY("fileid", (String) aVar.jvs.get((".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i))) + ".fileid"));
                        bVar.Fi("source");
                        bVar.Fi("source");
                        bVar.cY("name", b.cMh);
                        bVar.Fj("source");
                        bVar.Fj("source");
                        bVar.Fj("item");
                    }
                    i++;
                }
                bVar.Fj("category");
                bVar.Fi(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                bVar.cY("convName", b.cMg);
                bVar.cY("nickname", b.cMh);
                bVar.Fj(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                bVar.Fj("mmreader");
                bVar.Fj("appmsg");
                bVar.cY("fromusername", b.cMg);
                bVar.bE("scene", aVar.getInt(".msg.scene"));
                bVar.Fi("appinfo");
                bVar.cY("version", (String) aVar.jvs.get(".msg.appinfo.appname"));
                bVar.cY("appname", (String) aVar.jvs.get(".msg.appinfo.version"));
                bVar.Fj("appinfo");
                bVar.cY("commenturl", b.dJv);
                bVar.Fj("msg");
                ab.d("MicroMsg.AppmsgConvert", "xml " + bVar.jvt.toString());
                str2 = bVar.jvt.toString();
                AppMethodBeat.o(17777);
                return str2;
            }
            ab.e("MicroMsg.AppmsgConvert", "buffer error");
            str2 = "";
            AppMethodBeat.o(17777);
            return str2;
        }
    }

    public final int a(gu guVar, bi biVar, LinkedList<u> linkedList) {
        AppMethodBeat.i(17778);
        bts bts;
        switch (biVar.getType()) {
            case 1048625:
                int i;
                if (bo.isNullOrNil(biVar.field_content)) {
                    i = 0;
                } else {
                    i = biVar.field_content.getBytes().length;
                }
                if (biVar.field_content == null) {
                    AppMethodBeat.o(17778);
                    return -1;
                }
                String trim = ap.aps(biVar.field_content).xXL.trim();
                if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.Fd(trim)) {
                    trim = biVar.field_content;
                    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.Fd(trim)) {
                        ab.e("MicroMsg.BakOldItemAppMsg", "get xml error ".concat(String.valueOf(trim)));
                        AppMethodBeat.o(17778);
                        return 0;
                    }
                }
                if (!bo.isNullOrNil(trim)) {
                    bts = new bts();
                    bts.alV(bo.bc(trim, ""));
                    guVar.vED = bts;
                    com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(trim);
                    String Yb = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().Yb();
                    String I = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUo().I(biVar.field_imgPath, true);
                    String str = Yb + me.fgq;
                    if (e.asZ(I) <= 0) {
                        AppMethodBeat.o(17778);
                        return -1;
                    }
                    i = (i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(I, guVar, linkedList, 6, "_thumb")) + i) + i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(str, guVar, linkedList, com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUp().aqi(ap.aps(aa.a(guVar.vED)).cvZ)));
                }
                AppMethodBeat.o(17778);
                return i;
            case 285212721:
                int i2;
                if (bo.isNullOrNil(biVar.field_content)) {
                    i2 = 0;
                } else {
                    i2 = biVar.field_content.getBytes().length;
                }
                String Fh = a.Fh(biVar.field_content);
                if (bo.isNullOrNil(Fh)) {
                    AppMethodBeat.o(17778);
                    return 0;
                }
                bts = new bts();
                bts.alV(bo.bc(Fh, ""));
                guVar.vED = bts;
                AppMethodBeat.o(17778);
                return i2;
            default:
                int b = b(guVar, biVar, linkedList);
                AppMethodBeat.o(17778);
                return b;
        }
    }

    public final int a(String str, gu guVar, bi biVar) {
        AppMethodBeat.i(17780);
        String str2 = guVar.vEB.wVI;
        String str3 = guVar.vED.wVI;
        if (str3 == null) {
            AppMethodBeat.o(17780);
            return 0;
        }
        int ox;
        biVar.setContent(str3);
        if (biVar.field_isSend != 1 && d.kH(str2)) {
            ox = d.ox(guVar.vED.wVI);
            if (ox != -1) {
                str3 = (guVar.vED.wVI + " ").substring(ox + 2).trim();
            }
        }
        String anj = bo.anj(str3);
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(anj);
        int i;
        if (me == null) {
            ab.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
            AppMethodBeat.o(17780);
            return 0;
        } else if (me.type == 2000) {
            biVar.setType(419430449);
            d.l(biVar);
            AppMethodBeat.o(17780);
            return 0;
        } else if (me.type == 19 || me.type == 24) {
            biVar.setType(l.d(me));
            d.l(biVar);
            na naVar = new na();
            naVar.cJc.cHz = me.fgU;
            naVar.cJc.cuQ = biVar.field_msgId;
            com.tencent.mm.sdk.b.a.xxA.m(naVar);
            ab.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", naVar.cJd.cJe);
            String[] split = naVar.cJd.cJe.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            for (i = 0; i < split.length; i++) {
                anj = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(guVar, 7, ".".concat(String.valueOf(i)));
                if (!bo.isNullOrNil(anj)) {
                    ab.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", anj, Integer.valueOf(i));
                    e.y(com.tencent.mm.plugin.backup.bakoldlogic.a.a.Fp(anj), split[i]);
                }
            }
            AppMethodBeat.o(17780);
            return 0;
        } else {
            f fVar = new f();
            fVar.field_appId = me.appId;
            c aUZ = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ();
            com.tencent.mm.model.b bVar;
            if (aUZ.uin == 0) {
                bVar = new com.tencent.mm.model.b();
                AppMethodBeat.o(17780);
                throw bVar;
            }
            if (aUZ.jyw.b((com.tencent.mm.sdk.e.c) fVar, new String[0]) && fVar.field_appVersion < me.axy) {
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aVa().g(1, me.appId);
            }
            biVar.setType(l.d(me));
            byte[] b = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(guVar, 6);
            if (b != null && biVar.field_msgId == 0) {
                str3 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUo().a(b, me.type == 2, CompressFormat.PNG);
                ab.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.g.Mq() + " thumbData MsgInfo path:" + str3);
                if (!bo.isNullOrNil(str3)) {
                    biVar.jv(str3);
                    ab.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(str3)));
                }
            }
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(guVar, 8);
            i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(guVar, 8);
            if (bo.isNullOrNil(str2)) {
                str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(guVar, 7);
                i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(guVar, 7);
            }
            String Fp = com.tencent.mm.plugin.backup.bakoldlogic.a.a.Fp(str2);
            d.l(biVar);
            j jVar = new j();
            me.a(jVar);
            jVar.field_msgId = biVar.field_msgId;
            c aUZ2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ();
            if (aUZ2.uin == 0) {
                bVar = new com.tencent.mm.model.b();
                AppMethodBeat.o(17780);
                throw bVar;
            }
            aUZ2.jyv.b((com.tencent.mm.sdk.e.c) jVar);
            if (!bo.isNullOrNil(str2)) {
                h XO = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().XO();
                if (str.equals(guVar.vEB.wVI)) {
                    str2 = guVar.vEC.wVI;
                } else {
                    str2 = guVar.vEB.wVI;
                }
                bi Q = XO.Q(str2, guVar.ptF);
                com.tencent.mm.pluginsdk.model.app.b aiE = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUq().aiE(me.csD);
                if (aiE == null) {
                    ab.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
                    long j = Q.field_msgId;
                    com.tencent.mm.af.j.b me2 = com.tencent.mm.af.j.b.me(anj);
                    if (me2 != null) {
                        anj = l.X(com.tencent.mm.compatible.util.e.euQ, me2.title, me2.fgp);
                        int i2 = me2.sdkVer;
                        String str4 = me2.appId;
                        String str5 = me2.csD;
                        ox = me2.fgo;
                        com.tencent.mm.pluginsdk.model.app.b bVar2 = new com.tencent.mm.pluginsdk.model.app.b();
                        bVar2.field_fileFullPath = anj;
                        bVar2.field_appId = str4;
                        bVar2.field_sdkVer = (long) i2;
                        bVar2.field_mediaSvrId = str5;
                        bVar2.field_totalLen = (long) ox;
                        bVar2.field_status = 101;
                        bVar2.field_isUpload = false;
                        bVar2.field_createTime = bo.anU();
                        bVar2.field_lastModifyTime = bo.anT();
                        bVar2.field_msgInfoId = j;
                        bVar2.field_netTimes = 0;
                        if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUq().b((com.tencent.mm.sdk.e.c) bVar2)) {
                            ab.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", Long.valueOf(j));
                        }
                    }
                    aiE = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUq().aiE(me.csD);
                    if (aiE == null) {
                        ab.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", me.csD);
                        AppMethodBeat.o(17780);
                        return 0;
                    } else if (!(me.fgo == 0 || i == 0)) {
                        if (i >= me.fgo) {
                            aiE.field_status = 199;
                        } else if (biVar.field_isSend == 1) {
                            aiE.field_status = 105;
                        } else {
                            aiE.field_status = 102;
                        }
                    }
                }
                long j2 = (long) i;
                aiE.field_offset = j2;
                aiE.field_totalLen = j2;
                e.is(Fp, aiE.field_fileFullPath);
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUq().a(aiE, new String[0]);
            }
            AppMethodBeat.o(17780);
            return 0;
        }
    }

    private static int b(gu guVar, bi biVar, LinkedList<u> linkedList) {
        int i;
        com.tencent.mm.af.j.b me;
        AppMethodBeat.i(17779);
        if (bo.isNullOrNil(biVar.field_content)) {
            i = 0;
        } else {
            i = biVar.field_content.getBytes().length;
        }
        String str = biVar.field_content;
        if (biVar.field_isSend != 1 && d.kH(biVar.field_talker)) {
            int indexOf = biVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str = biVar.field_content.substring(indexOf + 1);
            }
        }
        str = bo.anj(str);
        if (str != null) {
            me = com.tencent.mm.af.j.b.me(str);
        } else {
            me = null;
        }
        if (me == null) {
            ab.e("MicroMsg.BakOldItemAppMsg", "content is null");
            AppMethodBeat.o(17779);
            return 0;
        }
        ab.d("MicroMsg.BakOldItemAppMsg", "content type " + me.type);
        String I = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUo().I(biVar.field_imgPath, true);
        if (e.ct(I)) {
            i += i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(I, guVar, linkedList, 6, "_thumb"));
        } else if (me.type == 2) {
            AppMethodBeat.o(17779);
            return -1;
        }
        com.tencent.mm.pluginsdk.model.app.b aiE;
        switch (me.type) {
            case 2:
                if (!bo.isNullOrNil(me.csD)) {
                    com.tencent.mm.pluginsdk.model.app.b aiE2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUq().aiE(me.csD);
                    if ((aiE2 != null && aiE2.bCR()) || (biVar.field_isSend == 1 && aiE2 != null && aiE2.field_isUpload)) {
                        I = aiE2.field_fileFullPath;
                        if (e.ct(I)) {
                            ab.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(I)));
                            i += i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(I, guVar, linkedList, 8, false, null));
                            break;
                        }
                    }
                }
                break;
            case 6:
                aiE = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUq().aiE(me.csD);
                if ((aiE != null && aiE.bCR()) || (biVar.field_isSend == 1 && aiE != null && aiE.field_isUpload)) {
                    ab.d("MicroMsg.BakOldItemAppMsg", "full path " + aiE.field_fileFullPath);
                    if (e.ct(aiE.field_fileFullPath)) {
                        if (com.tencent.mm.plugin.backup.b.d.aSx() == 1 && ((long) (me.fgo / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) >= 0 && me.filemd5 != null) {
                            i += i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(aiE.field_fileFullPath, guVar, linkedList, 7, true, new u()));
                            break;
                        }
                        i += i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(aiE.field_fileFullPath, guVar, linkedList, 7, false, null));
                        break;
                    }
                }
                break;
            case 7:
                aiE = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().aUq().aiE(me.csD);
                if ((aiE != null && aiE.bCR()) || (biVar.field_isSend == 1 && aiE != null && aiE.field_isUpload)) {
                    ab.d("MicroMsg.BakOldItemAppMsg", "full path " + aiE.field_fileFullPath);
                    if (e.ct(aiE.field_fileFullPath)) {
                        i += i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(aiE.field_fileFullPath, guVar, linkedList, 7, false, null));
                        break;
                    }
                }
                break;
            case 19:
            case 24:
                na naVar = new na();
                naVar.cJc.cHz = me.fgU;
                naVar.cJc.cuQ = biVar.field_msgId;
                com.tencent.mm.sdk.b.a.xxA.m(naVar);
                ab.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", naVar.cJd.cJe);
                String[] split = naVar.cJd.cJe.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (e.ct(split[i2])) {
                        ab.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", split[i2], Integer.valueOf(i2));
                        i += i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(split[i2], guVar, linkedList, 7, "_fav.".concat(String.valueOf(i2))));
                    }
                }
                break;
        }
        AppMethodBeat.o(17779);
        return i;
    }
}
