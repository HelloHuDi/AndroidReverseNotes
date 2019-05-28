package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceCompressItem;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "()V", "fromPath", "", "getFromPath", "()Ljava/lang/String;", "setFromPath", "(Ljava/lang/String;)V", "toPath", "getToPath", "setToPath", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
public final class h extends a {
    public String ljG = "";
    public String ljH = "";

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(2731);
        j.p(str, "tag");
        j.p(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case 1996335617:
                if (str.equals("CopyFromImagePath")) {
                    this.ljG = a.d(xmlPullParser);
                    AppMethodBeat.o(2731);
                    return;
                }
                break;
            case 2044488976:
                if (str.equals("CopyToImagePath")) {
                    this.ljH = a.d(xmlPullParser);
                    AppMethodBeat.o(2731);
                    return;
                }
                break;
        }
        a.a(xmlPullParser);
        AppMethodBeat.o(2731);
    }
}
