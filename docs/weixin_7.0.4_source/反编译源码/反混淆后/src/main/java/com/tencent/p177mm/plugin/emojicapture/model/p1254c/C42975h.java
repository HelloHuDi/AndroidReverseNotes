package com.tencent.p177mm.plugin.emojicapture.model.p1254c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceCompressItem;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "()V", "fromPath", "", "getFromPath", "()Ljava/lang/String;", "setFromPath", "(Ljava/lang/String;)V", "toPath", "getToPath", "setToPath", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.c.h */
public final class C42975h extends C45869a {
    public String ljG = "";
    public String ljH = "";

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo35712a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(2731);
        C25052j.m39376p(str, "tag");
        C25052j.m39376p(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case 1996335617:
                if (str.equals("CopyFromImagePath")) {
                    this.ljG = C45869a.m84979d(xmlPullParser);
                    AppMethodBeat.m2505o(2731);
                    return;
                }
                break;
            case 2044488976:
                if (str.equals("CopyToImagePath")) {
                    this.ljH = C45869a.m84979d(xmlPullParser);
                    AppMethodBeat.m2505o(2731);
                    return;
                }
                break;
        }
        C45869a.m84978a(xmlPullParser);
        AppMethodBeat.m2505o(2731);
    }
}
