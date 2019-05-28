package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

final class a {
    a() {
    }

    public static BindWordingContent tp(String str) {
        AppMethodBeat.i(123429);
        BindWordingContent bindWordingContent = new BindWordingContent("", "");
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    str2 = newPullParser.getName();
                    break;
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        text = text.trim();
                        if (!str2.equalsIgnoreCase("title")) {
                            if (!str2.equalsIgnoreCase("text")) {
                                if (!str2.equalsIgnoreCase("type")) {
                                    break;
                                }
                                try {
                                    bindWordingContent.bWu = Integer.valueOf(text);
                                    break;
                                } catch (Exception e) {
                                    bindWordingContent.bWu = Integer.valueOf(0);
                                    break;
                                }
                            }
                            bindWordingContent.content = text;
                            break;
                        }
                        bindWordingContent.title = text;
                        break;
                    }
                default:
                    break;
            }
        }
        AppMethodBeat.o(123429);
        return bindWordingContent;
    }
}
