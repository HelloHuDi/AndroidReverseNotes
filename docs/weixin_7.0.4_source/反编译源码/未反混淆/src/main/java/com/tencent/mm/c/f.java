package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class f {
    private static boolean cdt = false;

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085 A:{Splitter:B:19:0x0062, ExcHandler: SAXException (e org.xml.sax.SAXException)} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A:{Splitter:B:19:0x0062, ExcHandler: IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008f A:{Splitter:B:19:0x0062, ExcHandler: Exception (e java.lang.Exception)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:26:0x0086, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(125707);
     */
    /* JADX WARNING: Missing block: B:28:0x008b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(125707);
     */
    /* JADX WARNING: Missing block: B:30:0x0090, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(125707);
     */
    /* JADX WARNING: Missing block: B:49:0x00fc, code skipped:
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:56:?, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:57:?, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:58:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Map<String, String> z(String str, String str2) {
        AppMethodBeat.i(125707);
        int indexOf = str == null ? -1 : str.indexOf(60);
        if (indexOf < 0) {
            System.err.println("text not in xml format");
            AppMethodBeat.o(125707);
            return null;
        }
        if (indexOf > 0) {
            System.err.println("fix xml header from ".concat(String.valueOf(indexOf)));
            str = str.substring(indexOf);
        }
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(125707);
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            if (newDocumentBuilder == null) {
                System.err.println("new Document Builder failed");
                AppMethodBeat.o(125707);
                return null;
            }
            Document parse;
            try {
                parse = newDocumentBuilder.parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
                parse.normalize();
            } catch (DOMException e) {
            } catch (SAXException e2) {
            } catch (IOException e3) {
            } catch (Exception e4) {
            }
            if (parse == null) {
                System.err.println("new Document failed");
                AppMethodBeat.o(125707);
                return null;
            }
            Element documentElement = parse.getDocumentElement();
            if (documentElement == null) {
                System.err.println("getDocumentElement failed");
                AppMethodBeat.o(125707);
                return null;
            }
            if (str2.equals(documentElement.getNodeName())) {
                a(hashMap, "", "", documentElement, 0);
            } else {
                NodeList elementsByTagName = documentElement.getElementsByTagName(str2);
                if (elementsByTagName.getLength() <= 0) {
                    System.err.println("parse item null");
                    AppMethodBeat.o(125707);
                    return null;
                }
                if (elementsByTagName.getLength() > 1) {
                    System.err.println("parse items more than one");
                }
                a(hashMap, "", "", elementsByTagName.item(0), 0);
            }
            if (cdt) {
                e(hashMap);
            }
            AppMethodBeat.o(125707);
            return hashMap;
        } catch (ParserConfigurationException e5) {
            AppMethodBeat.o(125707);
            return null;
        }
    }

    private static void a(Map<String, String> map, String str, String str2, Node node, int i) {
        AppMethodBeat.i(125708);
        if (node.getNodeName().equals("#text")) {
            map.put(str, node.getNodeValue());
            map.put(str2, node.getNodeValue());
            AppMethodBeat.o(125708);
        } else if (node.getNodeName().equals("#cdata-section")) {
            map.put(str, node.getNodeValue());
            map.put(str2, node.getNodeValue());
            AppMethodBeat.o(125708);
        } else {
            Object obj;
            int i2;
            Object stringBuilder = new StringBuilder(String.valueOf(str)).append(".").append(node.getNodeName()).toString();
            String stringBuilder2 = new StringBuilder(String.valueOf(str2)).append(".").append(node.getNodeName()).toString();
            if (i > 0) {
                stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append(i).toString();
                map.put(stringBuilder, node.getNodeValue());
                stringBuilder2 = new StringBuilder(String.valueOf(stringBuilder2)).append("#").append(i).toString();
                map.put(stringBuilder2, node.getNodeValue());
                obj = stringBuilder2;
            } else {
                map.put(stringBuilder, node.getNodeValue());
                map.put(stringBuilder2, node.getNodeValue());
                String obj2 = stringBuilder2;
            }
            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null) {
                for (i2 = 0; i2 < attributes.getLength(); i2++) {
                    Node item = attributes.item(i2);
                    map.put(new StringBuilder(String.valueOf(stringBuilder)).append(".$").append(item.getNodeName()).toString(), item.getNodeValue());
                    map.put(new StringBuilder(String.valueOf(obj2)).append(".$").append(item.getNodeName()).toString(), item.getNodeValue());
                }
            }
            HashMap hashMap = new HashMap();
            NodeList childNodes = node.getChildNodes();
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item2 = childNodes.item(i3);
                Integer num = (Integer) hashMap.get(item2.getNodeName());
                if (num == null) {
                    i2 = 0;
                } else {
                    i2 = num.intValue();
                }
                a(map, stringBuilder, obj2, item2, i2);
                hashMap.put(item2.getNodeName(), Integer.valueOf(i2 + 1));
            }
            AppMethodBeat.o(125708);
        }
    }

    private static void e(Map<String, String> map) {
        AppMethodBeat.i(125709);
        if (map.size() <= 0) {
            System.err.println("empty values");
            AppMethodBeat.o(125709);
            return;
        }
        for (Entry entry : map.entrySet()) {
            System.err.println("key=" + ((String) entry.getKey()) + " value=" + ((String) entry.getValue()));
        }
        AppMethodBeat.o(125709);
    }
}
