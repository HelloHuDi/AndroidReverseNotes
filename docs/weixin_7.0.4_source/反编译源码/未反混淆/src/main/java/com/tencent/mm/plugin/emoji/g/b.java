package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static ArrayList<xx> JE(String str) {
        AppMethodBeat.i(53158);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            AppMethodBeat.o(53158);
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("EmojiMd5");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList<xx> arrayList = new ArrayList();
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    xx xxVar = new xx();
                    String toLowerCase = item.getTextContent().toLowerCase();
                    NamedNodeMap attributes = item.getAttributes();
                    Node namedItem = attributes.getNamedItem("thumburl");
                    if (namedItem != null) {
                        xxVar.ThumbUrl = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("cdnurl");
                    if (namedItem != null) {
                        xxVar.Url = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("productid");
                    if (namedItem != null) {
                        xxVar.ProductID = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("designerid");
                    if (namedItem != null) {
                        xxVar.wdC = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("aeskey");
                    if (namedItem != null) {
                        xxVar.AesKey = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("encrypturl");
                    if (namedItem != null) {
                        xxVar.EncryptUrl = namedItem.getNodeValue();
                    }
                    item = attributes.getNamedItem("activityid");
                    if (item != null) {
                        xxVar.ActivityID = item.getNodeValue();
                    }
                    xxVar.Md5 = toLowerCase;
                    arrayList.add(xxVar);
                }
                AppMethodBeat.o(53158);
                return arrayList;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", e.toString());
        }
        AppMethodBeat.o(53158);
        return null;
    }

    public static ArrayList<String> JF(String str) {
        AppMethodBeat.i(53159);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            AppMethodBeat.o(53159);
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("ProductID");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList<String> arrayList = new ArrayList();
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    arrayList.add(elementsByTagName.item(i).getTextContent());
                }
                AppMethodBeat.o(53159);
                return arrayList;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", e.toString());
        }
        AppMethodBeat.o(53159);
        return null;
    }
}
