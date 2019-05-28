package com.tencent.p177mm.plugin.emojicapture.model.p1254c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceCompressConfig;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "()V", "copyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceCompressItem;", "getCopyList", "()Ljava/util/LinkedList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.c.g */
public final class C42974g extends C45869a {
    public final LinkedList<C42975h> ljF = new LinkedList();

    public C42974g() {
        AppMethodBeat.m2504i(2730);
        AppMethodBeat.m2505o(2730);
    }

    /* renamed from: f */
    public final void mo68505f(XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(2728);
        C25052j.m39376p(xmlPullParser, "parser");
        xmlPullParser.nextTag();
        super.mo68505f(xmlPullParser);
        AppMethodBeat.m2505o(2728);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo35712a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(2729);
        C25052j.m39376p(str, "tag");
        C25052j.m39376p(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case 180673241:
                if (str.equals("EmoticonLensResouceCompreItem")) {
                    C42975h c42975h = new C42975h();
                    c42975h.mo68505f(xmlPullParser);
                    this.ljF.add(c42975h);
                    AppMethodBeat.m2505o(2729);
                    return;
                }
                break;
        }
        C45869a.m84978a(xmlPullParser);
        AppMethodBeat.m2505o(2729);
    }
}
