package com.tencent.p177mm.plugin.emoji.p727g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* renamed from: com.tencent.mm.plugin.emoji.g.b */
public final class C20376b {
    /* renamed from: JE */
    public static ArrayList<C40588xx> m31541JE(String str) {
        AppMethodBeat.m2504i(53158);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            AppMethodBeat.m2505o(53158);
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("EmojiMd5");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList<C40588xx> arrayList = new ArrayList();
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    C40588xx c40588xx = new C40588xx();
                    String toLowerCase = item.getTextContent().toLowerCase();
                    NamedNodeMap attributes = item.getAttributes();
                    Node namedItem = attributes.getNamedItem("thumburl");
                    if (namedItem != null) {
                        c40588xx.ThumbUrl = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("cdnurl");
                    if (namedItem != null) {
                        c40588xx.Url = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("productid");
                    if (namedItem != null) {
                        c40588xx.ProductID = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("designerid");
                    if (namedItem != null) {
                        c40588xx.wdC = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("aeskey");
                    if (namedItem != null) {
                        c40588xx.AesKey = namedItem.getNodeValue();
                    }
                    namedItem = attributes.getNamedItem("encrypturl");
                    if (namedItem != null) {
                        c40588xx.EncryptUrl = namedItem.getNodeValue();
                    }
                    item = attributes.getNamedItem("activityid");
                    if (item != null) {
                        c40588xx.ActivityID = item.getNodeValue();
                    }
                    c40588xx.Md5 = toLowerCase;
                    arrayList.add(c40588xx);
                }
                AppMethodBeat.m2505o(53158);
                return arrayList;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", e.toString());
        }
        AppMethodBeat.m2505o(53158);
        return null;
    }

    /* renamed from: JF */
    public static ArrayList<String> m31542JF(String str) {
        AppMethodBeat.m2504i(53159);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            AppMethodBeat.m2505o(53159);
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
                AppMethodBeat.m2505o(53159);
                return arrayList;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", e.toString());
        }
        AppMethodBeat.m2505o(53159);
        return null;
    }
}
