package com.tencent.p177mm.plugin.story.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.protocal.protobuf.cej;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C25274k;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert;", "", "()V", "Companion", "pullXml", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.p */
public final class C43646p {
    private static final String TAG = TAG;
    private static String jvr = "]]>";
    public static final C13798a rTj = new C13798a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "editor", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.p$a */
    public static final class C13798a {
        private C13798a() {
        }

        public /* synthetic */ C13798a(byte b) {
            this();
        }

        /* renamed from: a */
        public static String m21948a(cfb cfb, cej cej) {
            AppMethodBeat.m2504i(109135);
            C25052j.m39376p(cfb, "timeLine");
            C13799b c13799b = new C13799b();
            HashMap hashMap = new HashMap();
            c13799b.mo25983Fi("StoryObject");
            c13799b.mo25983Fi("id");
            if (cfb.f16206Id == null || cfb.f16206Id.equals("")) {
                c13799b.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                c13799b.setText(cfb.f16206Id);
            }
            c13799b.mo25984Fj("id");
            if (cfb.jBB != null) {
                c13799b.mo25983Fi("username");
                c13799b.aaD(cfb.jBB);
                c13799b.mo25984Fj("username");
            }
            c13799b.mo25983Fi("createTime");
            c13799b.aaD(String.valueOf(cfb.pcX));
            c13799b.mo25984Fj("createTime");
            c13799b.mo25983Fi("scope");
            c13799b.setText(cfb.xeC);
            c13799b.mo25984Fj("scope");
            c13799b.mo25983Fi("featured");
            c13799b.setText(cfb.xeD);
            c13799b.mo25984Fj("featured");
            c13799b.mo25983Fi("report");
            c13799b.mo25983Fi("publish_obj_id");
            String str = cfb.xeB;
            if (str == null) {
                str = "";
            }
            c13799b.aaD(str);
            c13799b.mo25984Fj("publish_obj_id");
            C4990ab.m7416i("czf", "report ".concat(String.valueOf(cej)));
            if (cej != null) {
                c13799b.mo25983Fi("music");
                if (cej.xef) {
                    c13799b.mo25983Fi("req_id");
                    c13799b.aaD(String.valueOf(cej.xee));
                    c13799b.mo25984Fj("req_id");
                    c13799b.mo25983Fi("id");
                    c13799b.setText(cej.rTW);
                    c13799b.mo25984Fj("id");
                    c13799b.mo25983Fi(C8741b.INDEX);
                    c13799b.setText(cej.xdZ);
                    c13799b.mo25984Fj(C8741b.INDEX);
                }
                c13799b.mo25984Fj("music");
                c13799b.mo25983Fi("emojiList");
                LinkedList<String> linkedList = cej.xeg;
                C25052j.m39375o(linkedList, "editor.emojiMd5");
                for (String str2 : linkedList) {
                    c13799b.mo25983Fi("emoji");
                    C25052j.m39375o(str2, "it");
                    c13799b.aaD(str2);
                    c13799b.mo25984Fj("emoji");
                }
                c13799b.mo25984Fj("emojiList");
                c13799b.mo25983Fi("wordList");
                linkedList = cej.xeh;
                C25052j.m39375o(linkedList, "editor.wordText");
                for (String str22 : linkedList) {
                    c13799b.mo25983Fi("word");
                    C25052j.m39375o(str22, "it");
                    c13799b.aaD(str22);
                    c13799b.mo25984Fj("word");
                }
                c13799b.mo25984Fj("wordList");
            }
            c13799b.mo25984Fj("report");
            c13799b.mo25983Fi("ContentObject");
            c13799b.mo25983Fi("title");
            c13799b.aaD(C13798a.m21946YE(cfb.xeA.Title));
            c13799b.mo25984Fj("title");
            if (cfb.xeA.wbK.size() > 0) {
                c13799b.mo25983Fi("mediaList");
                Iterator it = cfb.xeA.wbK.iterator();
                while (it.hasNext()) {
                    cek cek = (cek) it.next();
                    c13799b.mo25983Fi("media");
                    c13799b.mo25983Fi("id");
                    str22 = cek.f4416Id;
                    C25052j.m39375o(str22, "media.Id");
                    if (C25052j.m39373j(C13798a.m21947YF(str22), "")) {
                        c13799b.aaD(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    } else {
                        str22 = cek.f4416Id;
                        C25052j.m39375o(str22, "media.Id");
                        c13799b.aaD(C13798a.m21947YF(str22));
                    }
                    c13799b.mo25984Fj("id");
                    c13799b.mo25983Fi("type");
                    c13799b.aaD(String.valueOf(cek.jCt));
                    c13799b.mo25984Fj("type");
                    c13799b.mo25983Fi(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    c13799b.jvt.append(cek.duration);
                    c13799b.mo25984Fj(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    hashMap.clear();
                    hashMap.put("type", String.valueOf(cek.wEG));
                    if (!C5046bo.isNullOrNil(cek.cvZ)) {
                        hashMap.put("md5", cek.cvZ);
                    }
                    if (!C5046bo.isNullOrNil(cek.wFc)) {
                        hashMap.put("videomd5", cek.wFc);
                    }
                    c13799b.mo25986m("url", hashMap);
                    c13799b.aaD(C13798a.m21946YE(cek.Url));
                    c13799b.mo25984Fj("url");
                    if (!(cek.wEH == null || cek.wEH.equals(""))) {
                        hashMap.clear();
                        hashMap.put("type", String.valueOf(cek.wEI));
                        c13799b.mo25986m("thumb", hashMap);
                        c13799b.aaD(C13798a.m21946YE(cek.wEH));
                        c13799b.mo25984Fj("thumb");
                    }
                    if (cek.cuu > 0) {
                        c13799b.mo25983Fi("subType");
                        c13799b.aaD(String.valueOf(cek.cuu));
                        c13799b.mo25984Fj("subType");
                    }
                    c13799b.mo25984Fj("media");
                }
                c13799b.mo25984Fj("mediaList");
            }
            c13799b.mo25984Fj("ContentObject");
            c13799b.mo25984Fj("StoryObject");
            str22 = c13799b.jvt.toString();
            C25052j.m39375o(str22, "sb.toString()");
            C4990ab.m7410d(C43646p.TAG, "xmlContent: ".concat(String.valueOf(str22)));
            if (C5049br.m7595z(str22, "StoryObject") == null) {
                C4990ab.m7412e(C43646p.TAG, "xml is error");
                str22 = "";
                AppMethodBeat.m2505o(109135);
                return str22;
            }
            AppMethodBeat.m2505o(109135);
            return str22;
        }

        /* renamed from: YE */
        private static String m21946YE(String str) {
            return str == null ? "" : str;
        }

        /* renamed from: YF */
        private static String m21947YF(String str) {
            AppMethodBeat.m2504i(109136);
            C25052j.m39376p(str, "s");
            if (C5046bo.isNullOrNil(str)) {
                str = "";
                AppMethodBeat.m2505o(109136);
                return str;
            } else if (C13798a.isNumeric(str)) {
                AppMethodBeat.m2505o(109136);
                return str;
            } else {
                str = "";
                AppMethodBeat.m2505o(109136);
                return str;
            }
        }

        private static boolean isNumeric(String str) {
            AppMethodBeat.m2504i(109137);
            C25052j.m39376p(str, "str");
            boolean aq = new C25274k("\\d*").mo42119aq(str);
            AppMethodBeat.m2505o(109137);
            return aq;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0015J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\"\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0018J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.p$b */
    public static final class C13799b {
        StringBuffer jvt = new StringBuffer();

        public C13799b() {
            AppMethodBeat.m2504i(109144);
            AppMethodBeat.m2505o(109144);
        }

        /* renamed from: Fi */
        public final void mo25983Fi(String str) {
            AppMethodBeat.m2504i(109138);
            C25052j.m39376p(str, "tag");
            this.jvt.append("<" + str + '>');
            AppMethodBeat.m2505o(109138);
        }

        /* renamed from: Fj */
        public final void mo25984Fj(String str) {
            AppMethodBeat.m2504i(109139);
            C25052j.m39376p(str, "tag");
            this.jvt.append("</" + str + '>');
            AppMethodBeat.m2505o(109139);
        }

        public final void aaD(String str) {
            AppMethodBeat.m2504i(109140);
            C25052j.m39376p(str, "value");
            setText(str);
            AppMethodBeat.m2505o(109140);
        }

        public final void setText(String str) {
            AppMethodBeat.m2504i(109141);
            C25052j.m39376p(str, "value");
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(109141);
                return;
            }
            CharSequence charSequence = str;
            C13798a c13798a = C43646p.rTj;
            if (C31820v.m51526a(charSequence, (CharSequence) C43646p.jvr, false)) {
                this.jvt.append("<![CDATA[" + C5046bo.ani(str) + "]]>");
                AppMethodBeat.m2505o(109141);
                return;
            }
            this.jvt.append("<![CDATA[" + str + "]]>");
            AppMethodBeat.m2505o(109141);
        }

        public final void setText(int i) {
            AppMethodBeat.m2504i(109142);
            this.jvt.append(i);
            AppMethodBeat.m2505o(109142);
        }

        /* renamed from: m */
        public final void mo25986m(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(109143);
            C25052j.m39376p(str, "tag");
            C25052j.m39376p(map, "values");
            this.jvt.append("<".concat(String.valueOf(str)));
            for (String str2 : map.keySet()) {
                this.jvt.append(" " + str2 + "=\"" + ((String) map.get(str2)) + "\" ");
            }
            this.jvt.append(">");
            map.clear();
            AppMethodBeat.m2505o(109143);
        }
    }

    static {
        AppMethodBeat.m2504i(109145);
        AppMethodBeat.m2505o(109145);
    }
}
