package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.ttpic.baseutils.BaseTemplateParser;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00032\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"})
public final class q {
    private static final String TAG = TAG;
    public static final a rTk = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$ContentObjTAG;", "", "()V", "XML_MEDIALIST", "", "getXML_MEDIALIST", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class b {
        private static final String rTl = rTl;
        public static final b rTm = new b();

        static {
            AppMethodBeat.i(109150);
            AppMethodBeat.o(109150);
        }

        private b() {
        }

        public static String cyr() {
            return rTl;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$MediaObjTAG;", "", "()V", "XML_DESC", "", "getXML_DESC", "()Ljava/lang/String;", "XML_DURATION", "getXML_DURATION", "XML_PRIVATED", "getXML_PRIVATED", "XML_SIZE", "getXML_SIZE", "XML_SUBTYPE", "getXML_SUBTYPE", "XML_TAG", "getXML_TAG", "XML_THUMB", "getXML_THUMB", "XML_THUMBTYPE", "getXML_THUMBTYPE", "XML_TITLE", "getXML_TITLE", "XML_TYPE", "getXML_TYPE", "XML_URL", "getXML_URL", "XML_URLTYPE", "getXML_URLTYPE", "XML_URL_MD5", "getXML_URL_MD5", "XML_USERDATA", "getXML_USERDATA", "XML_VIDEOMD5", "getXML_VIDEOMD5", "XML_id", "getXML_id", "plugin-story_release"})
    public static final class c {
        private static final String rTA = rTA;
        private static final String rTB = rTB;
        private static final String rTC = rTC;
        public static final c rTD = new c();
        private static final String rTn = rTn;
        private static final String rTo = rTo;
        private static final String rTp = rTp;
        private static final String rTq = rTq;
        private static final String rTr = rTr;
        private static final String rTs = rTs;
        private static final String rTt = rTt;
        private static final String rTu = rTu;
        private static final String rTv = rTv;
        private static final String rTw = rTw;
        private static final String rTx = rTx;
        private static final String rTy = rTy;
        private static final String rTz = rTz;

        static {
            AppMethodBeat.i(109151);
            AppMethodBeat.o(109151);
        }

        private c() {
        }

        public static String cys() {
            return rTn;
        }

        public static String cyt() {
            return rTo;
        }

        public static String cyu() {
            return rTp;
        }

        public static String cyv() {
            return rTs;
        }

        public static String cyw() {
            return rTt;
        }

        public static String cyx() {
            return rTu;
        }

        public static String cyy() {
            return rTv;
        }

        public static String cyz() {
            return rTw;
        }

        public static String cyA() {
            return rTz;
        }

        public static String cyB() {
            return rTA;
        }

        public static String cyC() {
            return rTB;
        }

        public static String cyD() {
            return rTC;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J$\u0010\f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJL\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0004J\u0010\u0010\"\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private static cfb a(cfb cfb) {
            AppMethodBeat.i(109146);
            cei cei = new cei();
            cei.vRp = 0.0f;
            cei.vRq = 0.0f;
            cei.guP = "";
            cei.wCE = 0;
            cei.wCC = "";
            cei.rki = 0;
            cei.rkg = "";
            cei.eUu = "";
            cei.wCF = 1;
            cei.wCH = "";
            cei.country = "";
            cfb.xez = cei;
            AppMethodBeat.o(109146);
            return cfb;
        }

        private static cfb a(Map<String, String> map, cfb cfb) {
            AppMethodBeat.i(109147);
            if (cfb.xeA == null) {
                cfb.xeA = new cea();
            }
            cfb.xeA.Title = tB((String) map.get("contTitle"));
            int i = 0;
            while (true) {
                Object stringBuilder;
                Object stringBuilder2;
                Object stringBuilder3;
                Object stringBuilder4;
                Object stringBuilder5;
                Object stringBuilder6;
                Object stringBuilder7;
                Object stringBuilder8;
                Object stringBuilder9;
                String stringBuilder10;
                Object stringBuilder11;
                Object obj;
                String obj2;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                StringBuilder stringBuilder12;
                d dVar;
                b bVar;
                c cVar;
                d dVar2;
                b bVar2;
                c cVar2;
                if (i != 0) {
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder = stringBuilder12.append(c.cyt()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder2 = stringBuilder12.append(c.cyu()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder3 = stringBuilder12.append(c.cyv()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder4 = stringBuilder12.append(c.cyw()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder5 = stringBuilder12.append(c.cyy()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder6 = stringBuilder12.append(c.cyx()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder7 = stringBuilder12.append(c.cyz()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder8 = stringBuilder12.append(c.cyA()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder9 = stringBuilder12.append(c.cyB()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12.append(c.cys()).append(i);
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar = c.rTD;
                    stringBuilder10 = stringBuilder12.append(c.cyC()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar2 = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar2 = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar2 = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys()).append(i);
                    cVar2 = c.rTD;
                    stringBuilder11 = stringBuilder12.append(c.cyD()).toString();
                    obj2 = stringBuilder10;
                } else {
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder = stringBuilder12.append(c.cyt()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder2 = stringBuilder12.append(c.cyu()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder3 = stringBuilder12.append(c.cyv()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder4 = stringBuilder12.append(c.cyw()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder5 = stringBuilder12.append(c.cyy()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder6 = stringBuilder12.append(c.cyx()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder7 = stringBuilder12.append(c.cyz()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder8 = stringBuilder12.append(c.cyA()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder9 = stringBuilder12.append(c.cyB()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12.append(c.cys());
                    stringBuilder12 = new StringBuilder();
                    dVar = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar = c.rTD;
                    stringBuilder10 = stringBuilder12.append(c.cyC()).toString();
                    stringBuilder12 = new StringBuilder();
                    dVar2 = d.rTL;
                    stringBuilder12 = stringBuilder12.append(d.cyH());
                    bVar2 = b.rTm;
                    stringBuilder12 = stringBuilder12.append(b.cyr());
                    cVar2 = c.rTD;
                    stringBuilder12 = stringBuilder12.append(c.cys());
                    cVar2 = c.rTD;
                    String stringBuilder112 = stringBuilder12.append(c.cyD()).toString();
                    obj2 = stringBuilder10;
                }
                String str8 = (String) map.get(stringBuilder);
                stringBuilder10 = (String) map.get(stringBuilder2);
                if (stringBuilder10 == null) {
                    str = "";
                } else {
                    str = stringBuilder10;
                }
                stringBuilder10 = (String) map.get(stringBuilder3);
                if (stringBuilder10 == null) {
                    str2 = "";
                } else {
                    str2 = stringBuilder10;
                }
                stringBuilder10 = (String) map.get(stringBuilder5);
                if (stringBuilder10 == null) {
                    str3 = "";
                } else {
                    str3 = stringBuilder10;
                }
                stringBuilder10 = (String) map.get(stringBuilder4);
                if (stringBuilder10 == null) {
                    str4 = "";
                } else {
                    str4 = stringBuilder10;
                }
                stringBuilder10 = (String) map.get(stringBuilder6);
                if (stringBuilder10 == null) {
                    str5 = "";
                } else {
                    str5 = stringBuilder10;
                }
                stringBuilder10 = (String) map.get(stringBuilder7);
                if (stringBuilder10 == null) {
                    str6 = "";
                } else {
                    str6 = stringBuilder10;
                }
                stringBuilder10 = (String) map.get(stringBuilder8);
                if (stringBuilder10 == null) {
                    str7 = "";
                } else {
                    str7 = stringBuilder10;
                }
                map.get(stringBuilder9);
                stringBuilder10 = (String) map.get(obj2);
                if (stringBuilder10 == null) {
                    obj2 = "";
                } else {
                    obj2 = stringBuilder10;
                }
                stringBuilder10 = (String) map.get(stringBuilder112);
                if (stringBuilder10 == null) {
                    stringBuilder10 = "";
                }
                if (str == null || str8 == null) {
                    AppMethodBeat.o(109147);
                } else {
                    float f;
                    cek cek = new cek();
                    cek.Id = tB(str8);
                    cek.jCt = bo.getInt(str, 0);
                    cek.Url = tB(str2);
                    cek.wEG = bo.getInt(str5, 0);
                    cek.wEH = tB(str3);
                    cek.wEI = bo.getInt(str6, 0);
                    cek.cuu = bo.getInt(str7, 0);
                    cek.cvZ = tB(obj2);
                    cek.wFc = tB(str4);
                    if (stringBuilder10 == null) {
                        f = 0.0f;
                    } else {
                        f = bo.getFloat(stringBuilder10, 0.0f);
                    }
                    cek.duration = f;
                    cfb.xeA.wbK.add(cek);
                    i++;
                }
            }
            AppMethodBeat.o(109147);
            return cfb;
        }

        public static cfb cyq() {
            AppMethodBeat.i(109148);
            cfb cfb = new cfb();
            cea cea = new cea();
            cei cei = new cei();
            cei.vRq = 0.0f;
            cei.vRp = 0.0f;
            cfb.xez = cei;
            cfb.xeA = cea;
            cfb.Id = "";
            cfb.pcX = 0;
            AppMethodBeat.o(109148);
            return cfb;
        }

        private static String tB(String str) {
            return str == null ? "" : str;
        }

        public static cfb aaE(String str) {
            AppMethodBeat.i(109149);
            j.p(str, BaseTemplateParser.POSTFIX_ORIG);
            Map z = br.z(str, "StoryObject");
            if (z != null) {
                cfb cyq = cyq();
                d dVar = d.rTL;
                cyq.Id = tB((String) z.get(d.cyE()));
                dVar = d.rTL;
                cyq.jBB = tB((String) z.get(d.cyF()));
                dVar = d.rTL;
                cyq.pcX = bo.getInt((String) z.get(d.cyG()), 0);
                dVar = d.rTL;
                cyq.xeC = bo.getInt((String) z.get(d.cyI()), 0);
                cfb a = a(z, a(cyq));
                AppMethodBeat.o(109149);
                return a;
            }
            AppMethodBeat.o(109149);
            return null;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"})
    public static final class d {
        private static final String rTE = rTE;
        private static final String rTF = rTF;
        private static final String rTG = rTG;
        private static final String rTH = rTH;
        private static final String rTI = rTI;
        private static final String rTJ = rTJ;
        private static final String rTK = rTK;
        public static final d rTL = new d();

        static {
            AppMethodBeat.i(109152);
            AppMethodBeat.o(109152);
        }

        private d() {
        }

        public static String cyE() {
            return rTE;
        }

        public static String cyF() {
            return rTF;
        }

        public static String cyG() {
            return rTG;
        }

        public static String cyH() {
            return rTJ;
        }

        public static String cyI() {
            return rTK;
        }
    }

    static {
        AppMethodBeat.i(109153);
        AppMethodBeat.o(109153);
    }
}
