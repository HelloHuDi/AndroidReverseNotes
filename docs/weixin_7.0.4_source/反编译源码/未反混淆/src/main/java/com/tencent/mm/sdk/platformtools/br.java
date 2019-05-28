package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class br {
    private static ThreadLocal<XmlPullParser> xCn = new ThreadLocal();

    static class a {
        XmlPullParser xCo;
        private String xCp;
        StringBuilder xCq = new StringBuilder();
        Map<String, String> xCr;
        Map<Integer, Integer> xCs;

        public a(String str, String str2) {
            AppMethodBeat.i(52440);
            this.xCp = str2;
            XmlPullParser xmlPullParser = (XmlPullParser) br.xCn.get();
            this.xCo = xmlPullParser;
            if (xmlPullParser == null) {
                ThreadLocal dpO = br.xCn;
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                this.xCo = newPullParser;
                dpO.set(newPullParser);
            }
            this.xCo.setInput(new StringReader(str));
            this.xCs = new HashMap();
            this.xCr = new HashMap();
            AppMethodBeat.o(52440);
        }
    }

    public static Map<String, String> z(String str, String str2) {
        AppMethodBeat.i(52441);
        int indexOf = str == null ? -1 : str.indexOf("<".concat(String.valueOf(str2)));
        if (indexOf < 0) {
            ab.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", str2);
            AppMethodBeat.o(52441);
            return null;
        }
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        try {
            a aVar = new a(str, str2);
            indexOf = aVar.xCo.getEventType();
            while (indexOf != 1) {
                int next = aVar.xCo.next();
                if (next == 2) {
                    aVar.xCq.append('.').append(aVar.xCo.getName());
                    Object stringBuilder = aVar.xCq.toString();
                    int hashCode = stringBuilder.hashCode();
                    Integer num = (Integer) aVar.xCs.get(Integer.valueOf(hashCode));
                    if (num != null) {
                        num = Integer.valueOf(num.intValue() + 1);
                        aVar.xCq.append(num);
                        aVar.xCs.put(Integer.valueOf(hashCode), num);
                        stringBuilder = stringBuilder + num;
                    } else {
                        aVar.xCs.put(Integer.valueOf(hashCode), Integer.valueOf(0));
                    }
                    aVar.xCr.put(stringBuilder, "");
                    for (indexOf = 0; indexOf < aVar.xCo.getAttributeCount(); indexOf++) {
                        aVar.xCr.put(stringBuilder + ".$" + aVar.xCo.getAttributeName(indexOf), aVar.xCo.getAttributeValue(indexOf));
                    }
                    indexOf = next;
                } else if (next == 4) {
                    String text = aVar.xCo.getText();
                    if (text != null) {
                        aVar.xCr.put(aVar.xCq.toString(), text);
                    }
                    indexOf = next;
                } else {
                    if (next == 3) {
                        aVar.xCq = aVar.xCq.delete(aVar.xCq.lastIndexOf("."), aVar.xCq.length());
                        if (aVar.xCq.length() == 0) {
                            break;
                        }
                    }
                    indexOf = next;
                }
            }
            Map<String, String> map = aVar.xCr;
            AppMethodBeat.o(52441);
            return map;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.XmlParser", e, "[ %s ]", str);
            AppMethodBeat.o(52441);
            return null;
        }
    }

    public static String b(Node node) {
        AppMethodBeat.i(52442);
        StringWriter stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            ab.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", e.getMessage());
        }
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(52442);
        return stringWriter2;
    }

    static {
        AppMethodBeat.i(52443);
        AppMethodBeat.o(52443);
    }
}
