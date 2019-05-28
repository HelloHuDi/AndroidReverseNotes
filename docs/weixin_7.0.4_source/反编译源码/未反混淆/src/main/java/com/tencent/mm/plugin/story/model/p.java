package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.k.k;
import a.k.v;
import a.l;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert;", "", "()V", "Companion", "pullXml", "plugin-story_release"})
public final class p {
    private static final String TAG = TAG;
    private static String jvr = "]]>";
    public static final a rTj = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "editor", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static String a(cfb cfb, cej cej) {
            AppMethodBeat.i(109135);
            j.p(cfb, "timeLine");
            b bVar = new b();
            HashMap hashMap = new HashMap();
            bVar.Fi("StoryObject");
            bVar.Fi("id");
            if (cfb.Id == null || cfb.Id.equals("")) {
                bVar.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                bVar.setText(cfb.Id);
            }
            bVar.Fj("id");
            if (cfb.jBB != null) {
                bVar.Fi("username");
                bVar.aaD(cfb.jBB);
                bVar.Fj("username");
            }
            bVar.Fi("createTime");
            bVar.aaD(String.valueOf(cfb.pcX));
            bVar.Fj("createTime");
            bVar.Fi("scope");
            bVar.setText(cfb.xeC);
            bVar.Fj("scope");
            bVar.Fi("featured");
            bVar.setText(cfb.xeD);
            bVar.Fj("featured");
            bVar.Fi("report");
            bVar.Fi("publish_obj_id");
            String str = cfb.xeB;
            if (str == null) {
                str = "";
            }
            bVar.aaD(str);
            bVar.Fj("publish_obj_id");
            ab.i("czf", "report ".concat(String.valueOf(cej)));
            if (cej != null) {
                bVar.Fi("music");
                if (cej.xef) {
                    bVar.Fi("req_id");
                    bVar.aaD(String.valueOf(cej.xee));
                    bVar.Fj("req_id");
                    bVar.Fi("id");
                    bVar.setText(cej.rTW);
                    bVar.Fj("id");
                    bVar.Fi(com.google.firebase.analytics.FirebaseAnalytics.b.INDEX);
                    bVar.setText(cej.xdZ);
                    bVar.Fj(com.google.firebase.analytics.FirebaseAnalytics.b.INDEX);
                }
                bVar.Fj("music");
                bVar.Fi("emojiList");
                LinkedList<String> linkedList = cej.xeg;
                j.o(linkedList, "editor.emojiMd5");
                for (String str2 : linkedList) {
                    bVar.Fi("emoji");
                    j.o(str2, "it");
                    bVar.aaD(str2);
                    bVar.Fj("emoji");
                }
                bVar.Fj("emojiList");
                bVar.Fi("wordList");
                linkedList = cej.xeh;
                j.o(linkedList, "editor.wordText");
                for (String str22 : linkedList) {
                    bVar.Fi("word");
                    j.o(str22, "it");
                    bVar.aaD(str22);
                    bVar.Fj("word");
                }
                bVar.Fj("wordList");
            }
            bVar.Fj("report");
            bVar.Fi("ContentObject");
            bVar.Fi("title");
            bVar.aaD(YE(cfb.xeA.Title));
            bVar.Fj("title");
            if (cfb.xeA.wbK.size() > 0) {
                bVar.Fi("mediaList");
                Iterator it = cfb.xeA.wbK.iterator();
                while (it.hasNext()) {
                    cek cek = (cek) it.next();
                    bVar.Fi("media");
                    bVar.Fi("id");
                    str22 = cek.Id;
                    j.o(str22, "media.Id");
                    if (j.j(YF(str22), "")) {
                        bVar.aaD(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    } else {
                        str22 = cek.Id;
                        j.o(str22, "media.Id");
                        bVar.aaD(YF(str22));
                    }
                    bVar.Fj("id");
                    bVar.Fi("type");
                    bVar.aaD(String.valueOf(cek.jCt));
                    bVar.Fj("type");
                    bVar.Fi(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    bVar.jvt.append(cek.duration);
                    bVar.Fj(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    hashMap.clear();
                    hashMap.put("type", String.valueOf(cek.wEG));
                    if (!bo.isNullOrNil(cek.cvZ)) {
                        hashMap.put("md5", cek.cvZ);
                    }
                    if (!bo.isNullOrNil(cek.wFc)) {
                        hashMap.put("videomd5", cek.wFc);
                    }
                    bVar.m("url", hashMap);
                    bVar.aaD(YE(cek.Url));
                    bVar.Fj("url");
                    if (!(cek.wEH == null || cek.wEH.equals(""))) {
                        hashMap.clear();
                        hashMap.put("type", String.valueOf(cek.wEI));
                        bVar.m("thumb", hashMap);
                        bVar.aaD(YE(cek.wEH));
                        bVar.Fj("thumb");
                    }
                    if (cek.cuu > 0) {
                        bVar.Fi("subType");
                        bVar.aaD(String.valueOf(cek.cuu));
                        bVar.Fj("subType");
                    }
                    bVar.Fj("media");
                }
                bVar.Fj("mediaList");
            }
            bVar.Fj("ContentObject");
            bVar.Fj("StoryObject");
            str22 = bVar.jvt.toString();
            j.o(str22, "sb.toString()");
            ab.d(p.TAG, "xmlContent: ".concat(String.valueOf(str22)));
            if (br.z(str22, "StoryObject") == null) {
                ab.e(p.TAG, "xml is error");
                str22 = "";
                AppMethodBeat.o(109135);
                return str22;
            }
            AppMethodBeat.o(109135);
            return str22;
        }

        private static String YE(String str) {
            return str == null ? "" : str;
        }

        private static String YF(String str) {
            AppMethodBeat.i(109136);
            j.p(str, "s");
            if (bo.isNullOrNil(str)) {
                str = "";
                AppMethodBeat.o(109136);
                return str;
            } else if (isNumeric(str)) {
                AppMethodBeat.o(109136);
                return str;
            } else {
                str = "";
                AppMethodBeat.o(109136);
                return str;
            }
        }

        private static boolean isNumeric(String str) {
            AppMethodBeat.i(109137);
            j.p(str, "str");
            boolean aq = new k("\\d*").aq(str);
            AppMethodBeat.o(109137);
            return aq;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0015J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\"\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0018J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"})
    public static final class b {
        StringBuffer jvt = new StringBuffer();

        public b() {
            AppMethodBeat.i(109144);
            AppMethodBeat.o(109144);
        }

        public final void Fi(String str) {
            AppMethodBeat.i(109138);
            j.p(str, "tag");
            this.jvt.append("<" + str + '>');
            AppMethodBeat.o(109138);
        }

        public final void Fj(String str) {
            AppMethodBeat.i(109139);
            j.p(str, "tag");
            this.jvt.append("</" + str + '>');
            AppMethodBeat.o(109139);
        }

        public final void aaD(String str) {
            AppMethodBeat.i(109140);
            j.p(str, "value");
            setText(str);
            AppMethodBeat.o(109140);
        }

        public final void setText(String str) {
            AppMethodBeat.i(109141);
            j.p(str, "value");
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(109141);
                return;
            }
            CharSequence charSequence = str;
            a aVar = p.rTj;
            if (v.a(charSequence, (CharSequence) p.jvr, false)) {
                this.jvt.append("<![CDATA[" + bo.ani(str) + "]]>");
                AppMethodBeat.o(109141);
                return;
            }
            this.jvt.append("<![CDATA[" + str + "]]>");
            AppMethodBeat.o(109141);
        }

        public final void setText(int i) {
            AppMethodBeat.i(109142);
            this.jvt.append(i);
            AppMethodBeat.o(109142);
        }

        public final void m(String str, Map<String, String> map) {
            AppMethodBeat.i(109143);
            j.p(str, "tag");
            j.p(map, "values");
            this.jvt.append("<".concat(String.valueOf(str)));
            for (String str2 : map.keySet()) {
                this.jvt.append(" " + str2 + "=\"" + ((String) map.get(str2)) + "\" ");
            }
            this.jvt.append(">");
            map.clear();
            AppMethodBeat.o(109143);
        }
    }

    static {
        AppMethodBeat.i(109145);
        AppMethodBeat.o(109145);
    }
}
