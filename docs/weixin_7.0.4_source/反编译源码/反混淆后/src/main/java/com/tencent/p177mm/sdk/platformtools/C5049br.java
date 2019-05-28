package com.tencent.p177mm.sdk.platformtools;

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

/* renamed from: com.tencent.mm.sdk.platformtools.br */
public final class C5049br {
    private static ThreadLocal<XmlPullParser> xCn = new ThreadLocal();

    /* renamed from: com.tencent.mm.sdk.platformtools.br$a */
    static class C5048a {
        XmlPullParser xCo;
        private String xCp;
        StringBuilder xCq = new StringBuilder();
        Map<String, String> xCr;
        Map<Integer, Integer> xCs;

        public C5048a(String str, String str2) {
            AppMethodBeat.m2504i(52440);
            this.xCp = str2;
            XmlPullParser xmlPullParser = (XmlPullParser) C5049br.xCn.get();
            this.xCo = xmlPullParser;
            if (xmlPullParser == null) {
                ThreadLocal dpO = C5049br.xCn;
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                this.xCo = newPullParser;
                dpO.set(newPullParser);
            }
            this.xCo.setInput(new StringReader(str));
            this.xCs = new HashMap();
            this.xCr = new HashMap();
            AppMethodBeat.m2505o(52440);
        }
    }

    /* renamed from: z */
    public static Map<String, String> m7595z(String str, String str2) {
        AppMethodBeat.m2504i(52441);
        int indexOf = str == null ? -1 : str.indexOf("<".concat(String.valueOf(str2)));
        if (indexOf < 0) {
            C4990ab.m7413e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", str2);
            AppMethodBeat.m2505o(52441);
            return null;
        }
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        try {
            C5048a c5048a = new C5048a(str, str2);
            indexOf = c5048a.xCo.getEventType();
            while (indexOf != 1) {
                int next = c5048a.xCo.next();
                if (next == 2) {
                    c5048a.xCq.append('.').append(c5048a.xCo.getName());
                    Object stringBuilder = c5048a.xCq.toString();
                    int hashCode = stringBuilder.hashCode();
                    Integer num = (Integer) c5048a.xCs.get(Integer.valueOf(hashCode));
                    if (num != null) {
                        num = Integer.valueOf(num.intValue() + 1);
                        c5048a.xCq.append(num);
                        c5048a.xCs.put(Integer.valueOf(hashCode), num);
                        stringBuilder = stringBuilder + num;
                    } else {
                        c5048a.xCs.put(Integer.valueOf(hashCode), Integer.valueOf(0));
                    }
                    c5048a.xCr.put(stringBuilder, "");
                    for (indexOf = 0; indexOf < c5048a.xCo.getAttributeCount(); indexOf++) {
                        c5048a.xCr.put(stringBuilder + ".$" + c5048a.xCo.getAttributeName(indexOf), c5048a.xCo.getAttributeValue(indexOf));
                    }
                    indexOf = next;
                } else if (next == 4) {
                    String text = c5048a.xCo.getText();
                    if (text != null) {
                        c5048a.xCr.put(c5048a.xCq.toString(), text);
                    }
                    indexOf = next;
                } else {
                    if (next == 3) {
                        c5048a.xCq = c5048a.xCq.delete(c5048a.xCq.lastIndexOf("."), c5048a.xCq.length());
                        if (c5048a.xCq.length() == 0) {
                            break;
                        }
                    }
                    indexOf = next;
                }
            }
            Map<String, String> map = c5048a.xCr;
            AppMethodBeat.m2505o(52441);
            return map;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.XmlParser", e, "[ %s ]", str);
            AppMethodBeat.m2505o(52441);
            return null;
        }
    }

    /* renamed from: b */
    public static String m7594b(Node node) {
        AppMethodBeat.m2504i(52442);
        StringWriter stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            C4990ab.m7413e("MicroMsg.SDK.XmlParser", "nodeToString: %s", e.getMessage());
        }
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.m2505o(52442);
        return stringWriter2;
    }

    static {
        AppMethodBeat.m2504i(52443);
        AppMethodBeat.m2505o(52443);
    }
}
