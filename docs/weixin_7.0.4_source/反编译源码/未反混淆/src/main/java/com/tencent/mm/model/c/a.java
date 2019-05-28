package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class a {
    private static DocumentBuilder foC = null;

    public static class a {
        public List<com.tencent.mm.storage.a> foD = new LinkedList();
        public List<c> items = new LinkedList();

        public a() {
            AppMethodBeat.i(118155);
            AppMethodBeat.o(118155);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x027b A:{Catch:{ Exception -> 0x034f }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a0 A:{Catch:{ Exception -> 0x034f }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0326 A:{Catch:{ Exception -> 0x034f }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0252 A:{Catch:{ Exception -> 0x034f }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x027b A:{Catch:{ Exception -> 0x034f }} */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a0 A:{Catch:{ Exception -> 0x034f }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0326 A:{Catch:{ Exception -> 0x034f }} */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x035f A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARNING: Missing block: B:61:0x0184, code skipped:
            if (r7.field_startTime == 0) goto L_0x0186;
     */
    /* JADX WARNING: Missing block: B:66:0x01b3, code skipped:
            if (r7.field_endTime == 0) goto L_0x01b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a pb(String str) {
        AppMethodBeat.i(118156);
        a aVar = new a();
        ab.d("MicroMsg.ABTestParser", "ABTest msg content: %s", str);
        Element pd = pd(str);
        if (pd == null) {
            ab.e("MicroMsg.ABTestParser", "Msg parsing failed, msg: %s", str);
            AppMethodBeat.o(118156);
            return aVar;
        }
        NamedNodeMap attributes = pd.getAttributes();
        if (attributes == null) {
            AppMethodBeat.o(118156);
            return null;
        }
        int i;
        NodeList childNodes;
        int i2;
        int i3;
        Node namedItem = attributes.getNamedItem("type");
        if (namedItem != null && "newabtestinfo".equals(namedItem.getNodeValue())) {
            NodeList elementsByTagName = pd.getElementsByTagName("prioritylevel");
            if (elementsByTagName.getLength() > 0) {
                i = bo.getInt(elementsByTagName.item(0).getTextContent(), 1);
                childNodes = pd.getChildNodes();
                i2 = 0;
                while (true) {
                    i3 = i2;
                    if (i3 >= childNodes.getLength()) {
                        Node item = childNodes.item(i3);
                        if (item != null) {
                            Object obj;
                            NodeList elementsByTagName2;
                            if (item.getNodeType() == (short) 1 && item.getNodeName().equals("exp")) {
                                try {
                                    Element element = (Element) item;
                                    c cVar = new c();
                                    NamedNodeMap attributes2 = element.getAttributes();
                                    if (attributes2 == null) {
                                        obj = null;
                                    } else {
                                        Node namedItem2 = attributes2.getNamedItem("layerid");
                                        if (namedItem2 == null) {
                                            obj = null;
                                        } else {
                                            cVar.field_layerId = namedItem2.getNodeValue();
                                            namedItem2 = attributes2.getNamedItem("id");
                                            if (namedItem2 == null) {
                                                obj = null;
                                            } else {
                                                cVar.field_expId = namedItem2.getNodeValue();
                                                Node namedItem3 = attributes2.getNamedItem("business");
                                                if (namedItem3 == null) {
                                                    cVar.field_business = "";
                                                } else {
                                                    cVar.field_business = namedItem3.getNodeValue();
                                                }
                                                elementsByTagName2 = element.getElementsByTagName("sequence");
                                                if (elementsByTagName2.getLength() == 0) {
                                                    obj = null;
                                                } else {
                                                    cVar.field_sequence = bo.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                                    elementsByTagName2 = element.getElementsByTagName("prioritylevel");
                                                    if (elementsByTagName2.getLength() > 0) {
                                                        cVar.field_prioritylevel = bo.getInt(elementsByTagName2.item(0).getTextContent(), 0);
                                                    } else {
                                                        cVar.field_prioritylevel = 0;
                                                    }
                                                    elementsByTagName2 = element.getElementsByTagName("starttime");
                                                    if (elementsByTagName2.getLength() > 0) {
                                                        cVar.field_startTime = bo.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                                    }
                                                    cVar.field_startTime = System.currentTimeMillis() / 1000;
                                                    elementsByTagName2 = element.getElementsByTagName("endtime");
                                                    if (elementsByTagName2.getLength() > 0) {
                                                        cVar.field_endTime = bo.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                                    }
                                                    cVar.field_endTime = Long.MAX_VALUE;
                                                    elementsByTagName2 = element.getElementsByTagName("noreport");
                                                    if (elementsByTagName2.getLength() > 0) {
                                                        cVar.field_needReport = bo.getInt(elementsByTagName2.item(0).getTextContent(), 0) == 0;
                                                    }
                                                    cVar.field_rawXML = a(element);
                                                    c obj2 = cVar;
                                                }
                                            }
                                        }
                                    }
                                    aVar.items.add(obj2);
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.ABTestParser", e, "parseExp", new Object[0]);
                                }
                            }
                            if (item.getNodeType() == (short) 1 && item.getNodeName().equals("expinfo")) {
                                try {
                                    Collection collection;
                                    pd = (Element) item;
                                    LinkedList linkedList = new LinkedList();
                                    attributes = pd.getAttributes();
                                    if (attributes == null) {
                                        collection = null;
                                    } else {
                                        Node namedItem4 = attributes.getNamedItem("id");
                                        if (namedItem4 == null) {
                                            collection = null;
                                        } else {
                                            String nodeValue = namedItem4.getNodeValue();
                                            NodeList elementsByTagName3 = pd.getElementsByTagName("sequence");
                                            if (elementsByTagName3.getLength() == 0) {
                                                collection = null;
                                            } else {
                                                long j;
                                                long j2;
                                                HashMap hashMap;
                                                long j3 = bo.getLong(elementsByTagName3.item(0).getTextContent(), 0);
                                                elementsByTagName3 = pd.getElementsByTagName("starttime");
                                                if (elementsByTagName3.getLength() > 0) {
                                                    long j4 = bo.getLong(elementsByTagName3.item(0).getTextContent(), 0);
                                                    if (j4 != 0) {
                                                        j = j4;
                                                        elementsByTagName3 = pd.getElementsByTagName("endtime");
                                                        if (elementsByTagName3.getLength() > 0) {
                                                            j4 = bo.getLong(elementsByTagName3.item(0).getTextContent(), 0);
                                                            if (j4 != 0) {
                                                                boolean z;
                                                                j2 = j4;
                                                                elementsByTagName2 = pd.getElementsByTagName("noreport");
                                                                if (elementsByTagName2.getLength() > 0) {
                                                                    z = bo.getInt(elementsByTagName2.item(0).getTextContent(), 0) == 1;
                                                                } else {
                                                                    z = false;
                                                                }
                                                                hashMap = new HashMap();
                                                                elementsByTagName3 = pd.getElementsByTagName("args");
                                                                if (elementsByTagName3.getLength() > 0) {
                                                                    NodeList childNodes2 = elementsByTagName3.item(0).getChildNodes();
                                                                    for (int i4 = 0; i4 < childNodes2.getLength(); i4++) {
                                                                        item = childNodes2.item(i4);
                                                                        if (item.getNodeType() == (short) 1 && item.getNodeName().equals("arg")) {
                                                                            elementsByTagName3 = ((Element) item).getElementsByTagName("key");
                                                                            NodeList elementsByTagName4 = ((Element) item).getElementsByTagName("value");
                                                                            if (!(elementsByTagName3.getLength() == 0 || elementsByTagName4.getLength() == 0)) {
                                                                                hashMap.put(elementsByTagName3.item(0).getTextContent(), elementsByTagName4.item(0).getTextContent());
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                for (String str2 : hashMap.keySet()) {
                                                                    com.tencent.mm.storage.a aVar2 = new com.tencent.mm.storage.a();
                                                                    aVar2.field_abtestkey = str2;
                                                                    aVar2.field_value = (String) hashMap.get(str2);
                                                                    aVar2.field_expId = nodeValue;
                                                                    aVar2.field_sequence = j3;
                                                                    aVar2.field_prioritylevel = i;
                                                                    aVar2.field_startTime = j;
                                                                    aVar2.field_endTime = j2;
                                                                    aVar2.field_noReport = z;
                                                                    linkedList.add(aVar2);
                                                                }
                                                                obj2 = linkedList;
                                                            }
                                                        }
                                                        j2 = Long.MAX_VALUE;
                                                        elementsByTagName2 = pd.getElementsByTagName("noreport");
                                                        if (elementsByTagName2.getLength() > 0) {
                                                        }
                                                        hashMap = new HashMap();
                                                        elementsByTagName3 = pd.getElementsByTagName("args");
                                                        if (elementsByTagName3.getLength() > 0) {
                                                        }
                                                        for (String str22 : hashMap.keySet()) {
                                                        }
                                                        obj2 = linkedList;
                                                    }
                                                }
                                                j = System.currentTimeMillis() / 1000;
                                                elementsByTagName3 = pd.getElementsByTagName("endtime");
                                                if (elementsByTagName3.getLength() > 0) {
                                                }
                                                j2 = Long.MAX_VALUE;
                                                elementsByTagName2 = pd.getElementsByTagName("noreport");
                                                if (elementsByTagName2.getLength() > 0) {
                                                }
                                                hashMap = new HashMap();
                                                elementsByTagName3 = pd.getElementsByTagName("args");
                                                if (elementsByTagName3.getLength() > 0) {
                                                }
                                                for (String str222 : hashMap.keySet()) {
                                                }
                                                obj2 = linkedList;
                                            }
                                        }
                                    }
                                    aVar.foD.addAll(collection);
                                } catch (Exception e2) {
                                    ab.e("MicroMsg.ABTestParser", e2.getMessage());
                                }
                            }
                        }
                        i2 = i3 + 1;
                    } else {
                        AppMethodBeat.o(118156);
                        return aVar;
                    }
                }
            }
        }
        i = 1;
        childNodes = pd.getChildNodes();
        i2 = 0;
        while (true) {
            i3 = i2;
            if (i3 >= childNodes.getLength()) {
            }
            i2 = i3 + 1;
        }
    }

    public static Map<String, String> pc(String str) {
        AppMethodBeat.i(118157);
        HashMap hashMap = new HashMap();
        Element pd = pd(str);
        if (pd == null) {
            ab.e("MicroMsg.ABTestParser", "Raw XML string parsing failed, xml: %s", str);
            AppMethodBeat.o(118157);
            return hashMap;
        }
        NodeList elementsByTagName = pd.getElementsByTagName("args");
        if (elementsByTagName.getLength() > 0) {
            NodeList childNodes = elementsByTagName.item(0).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == (short) 1 && item.getNodeName().equals("arg")) {
                    elementsByTagName = ((Element) item).getElementsByTagName("key");
                    NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("value");
                    if (!(elementsByTagName.getLength() == 0 || elementsByTagName2.getLength() == 0)) {
                        hashMap.put(elementsByTagName.item(0).getTextContent(), elementsByTagName2.item(0).getTextContent());
                    }
                }
            }
        }
        AppMethodBeat.o(118157);
        return hashMap;
    }

    private static Element pd(String str) {
        AppMethodBeat.i(118158);
        try {
            DocumentBuilder documentBuilder;
            InputSource inputSource = new InputSource(new ByteArrayInputStream(str.getBytes()));
            if (foC != null) {
                documentBuilder = foC;
            } else {
                documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                foC = documentBuilder;
            }
            Document parse = documentBuilder.parse(inputSource);
            parse.normalize();
            Element documentElement = parse.getDocumentElement();
            AppMethodBeat.o(118158);
            return documentElement;
        } catch (Exception e) {
            ab.e("MicroMsg.ABTestParser", e.toString());
            AppMethodBeat.o(118158);
            return null;
        }
    }

    private static String a(Node node) {
        AppMethodBeat.i(118159);
        StringWriter stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            ab.printErrStackTrace("MicroMsg.ABTestParser", e, "nodeToString", new Object[0]);
        }
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(118159);
        return stringWriter2;
    }
}
