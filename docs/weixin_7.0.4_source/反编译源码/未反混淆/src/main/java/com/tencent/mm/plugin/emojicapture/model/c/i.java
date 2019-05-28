package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceFileConfig;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "()V", "ResouceFileVersion", "", "getResouceFileVersion", "()I", "setResouceFileVersion", "(I)V", "fileList", "Ljava/util/LinkedList;", "", "getFileList", "()Ljava/util/LinkedList;", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
public final class i extends a {
    public int ljI;
    private final LinkedList<String> ljJ = new LinkedList();

    public i() {
        AppMethodBeat.i(2733);
        AppMethodBeat.o(2733);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(2732);
        j.p(str, "tag");
        j.p(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case 2115186004:
                if (str.equals("ResouceFileVersion")) {
                    this.ljI = a.e(xmlPullParser);
                    AppMethodBeat.o(2732);
                    return;
                }
                break;
        }
        a.a(xmlPullParser);
        AppMethodBeat.o(2732);
    }
}
