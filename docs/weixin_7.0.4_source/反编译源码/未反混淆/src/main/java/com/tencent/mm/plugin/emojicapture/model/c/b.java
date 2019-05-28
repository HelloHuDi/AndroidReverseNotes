package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensConfig;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensItem;", "getItemList", "()Ljava/util/LinkedList;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
public final class b extends a {
    public final LinkedList<d> ewZ = new LinkedList();

    public b() {
        AppMethodBeat.i(2720);
        AppMethodBeat.o(2720);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(2719);
        j.p(str, "tag");
        j.p(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case -424713737:
                if (str.equals("EmoticonLensItem")) {
                    d dVar = new d();
                    dVar.f(xmlPullParser);
                    this.ewZ.add(dVar);
                    ab.i(c.TAG, String.valueOf(dVar));
                    AppMethodBeat.o(2719);
                    return;
                }
                break;
            case -424634494:
                if (str.equals("EmoticonLensList")) {
                    AppMethodBeat.o(2719);
                    return;
                }
                break;
            case -304135898:
                if (str.equals("EmoticonLensConfig")) {
                    AppMethodBeat.o(2719);
                    return;
                }
                break;
        }
        a.a(xmlPullParser);
        AppMethodBeat.o(2719);
    }
}
