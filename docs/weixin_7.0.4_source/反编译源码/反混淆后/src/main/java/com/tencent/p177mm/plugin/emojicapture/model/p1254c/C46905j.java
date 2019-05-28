package com.tencent.p177mm.plugin.emojicapture.model.p1254c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/StringList;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "subTag", "", "(Ljava/lang/String;)V", "list", "Ljava/util/LinkedList;", "getList", "()Ljava/util/LinkedList;", "getSubTag", "()Ljava/lang/String;", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.c.j */
public final class C46905j extends C45869a {
    private final LinkedList<String> eow = new LinkedList();
    private final String ljK;

    public C46905j(String str) {
        C25052j.m39376p(str, "subTag");
        AppMethodBeat.m2504i(2735);
        this.ljK = str;
        AppMethodBeat.m2505o(2735);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo35712a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(2734);
        C25052j.m39376p(str, "tag");
        C25052j.m39376p(xmlPullParser, "parser");
        if (C25052j.m39373j(str, this.ljK)) {
            this.eow.add(C45869a.m84979d(xmlPullParser));
        }
        AppMethodBeat.m2505o(2734);
    }
}
