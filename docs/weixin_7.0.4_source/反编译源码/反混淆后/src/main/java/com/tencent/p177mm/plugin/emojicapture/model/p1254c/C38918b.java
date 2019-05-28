package com.tencent.p177mm.plugin.emojicapture.model.p1254c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensConfig;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensItem;", "getItemList", "()Ljava/util/LinkedList;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.c.b */
public final class C38918b extends C45869a {
    public final LinkedList<C20433d> ewZ = new LinkedList();

    public C38918b() {
        AppMethodBeat.m2504i(2720);
        AppMethodBeat.m2505o(2720);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo35712a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(2719);
        C25052j.m39376p(str, "tag");
        C25052j.m39376p(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case -424713737:
                if (str.equals("EmoticonLensItem")) {
                    C20433d c20433d = new C20433d();
                    c20433d.mo68505f(xmlPullParser);
                    this.ewZ.add(c20433d);
                    C4990ab.m7416i(C27803c.TAG, String.valueOf(c20433d));
                    AppMethodBeat.m2505o(2719);
                    return;
                }
                break;
            case -424634494:
                if (str.equals("EmoticonLensList")) {
                    AppMethodBeat.m2505o(2719);
                    return;
                }
                break;
            case -304135898:
                if (str.equals("EmoticonLensConfig")) {
                    AppMethodBeat.m2505o(2719);
                    return;
                }
                break;
        }
        C45869a.m84978a(xmlPullParser);
        AppMethodBeat.m2505o(2719);
    }
}
