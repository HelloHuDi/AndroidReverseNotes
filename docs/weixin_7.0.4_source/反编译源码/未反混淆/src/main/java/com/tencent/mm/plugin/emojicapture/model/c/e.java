package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\nJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangString;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "()V", "scene", "", "getScene", "()I", "setScene", "(I)V", "textCn", "", "getTextCn", "()Ljava/lang/String;", "setTextCn", "(Ljava/lang/String;)V", "textEn", "getTextEn", "setTextEn", "textHk", "getTextHk", "setTextHk", "textTw", "getTextTw", "setTextTw", "get", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "toString", "plugin-emojicapture_release"})
public final class e extends a {
    private String ljB = "";
    private String ljC = "";
    private String ljD = "";
    private String ljE = "";
    private int scene;

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(2724);
        j.p(str, "tag");
        j.p(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case 3241:
                if (str.equals("en")) {
                    this.ljE = a.d(xmlPullParser);
                    break;
                }
                break;
            case 115861276:
                if (str.equals("zh_CN")) {
                    this.ljB = a.d(xmlPullParser);
                    AppMethodBeat.o(2724);
                    return;
                }
                break;
            case 115861428:
                if (str.equals("zh_HK")) {
                    this.ljD = a.d(xmlPullParser);
                    AppMethodBeat.o(2724);
                    return;
                }
                break;
            case 115861812:
                if (str.equals("zh_TW")) {
                    this.ljC = a.d(xmlPullParser);
                    AppMethodBeat.o(2724);
                    return;
                }
                break;
            case 142587723:
                if (str.equals("EmoticonLensScenes")) {
                    this.scene = a.e(xmlPullParser);
                    AppMethodBeat.o(2724);
                    return;
                }
                break;
        }
        AppMethodBeat.o(2724);
    }

    public final String toString() {
        AppMethodBeat.i(2725);
        String str = "MultiLangString(textCn='" + this.ljB + "', textTw='" + this.ljC + "', textHk='" + this.ljD + "', textEn='" + this.ljE + "')";
        AppMethodBeat.o(2725);
        return str;
    }
}
