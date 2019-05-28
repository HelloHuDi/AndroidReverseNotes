package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class d {
    public static ArrayList<EmojiGroupInfo> JG(String str) {
        AppMethodBeat.i(53162);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] parse xml faild. xml is null.");
            AppMethodBeat.o(53162);
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("Emotion");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList<EmojiGroupInfo> arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < elementsByTagName.getLength()) {
                        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                        NodeList childNodes = elementsByTagName.item(i2).getChildNodes();
                        int length = childNodes.getLength();
                        for (i = 0; i < length; i++) {
                            Node item = childNodes.item(i);
                            if (item != null && item.getNodeName() != null && item.getNodeName().equals("ProductID")) {
                                ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] productId:%s", item.getTextContent());
                                emojiGroupInfo.field_productID = r7;
                            } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("RecType")) {
                                if (item != null) {
                                    if (item.getNodeName() != null && item.getNodeName().equals("RecWord")) {
                                        ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] recWord:%s", item.getTextContent());
                                        emojiGroupInfo.field_recommandWord = r7;
                                    }
                                }
                                if (item != null && item.getNodeName() != null && item.getNodeName().equals("Name")) {
                                    ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] Name:%s", item.getTextContent());
                                    emojiGroupInfo.field_packName = r7;
                                } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Panel")) {
                                    ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] iconUrl:%s", item.getTextContent());
                                    emojiGroupInfo.field_packGrayIconUrl = r7;
                                } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Icon")) {
                                    ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] BigIconUrl:%s", item.getTextContent());
                                    emojiGroupInfo.field_BigIconUrl = r7;
                                } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("ButtonType"))) {
                                    ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] buttonType:%s", item.getTextContent());
                                    emojiGroupInfo.field_buttonType = Integer.valueOf(r7).intValue();
                                }
                            } else {
                                ab.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] RecType:%s", item.getTextContent());
                                emojiGroupInfo.field_recommandType = Integer.valueOf(r7).intValue();
                            }
                        }
                        if (!bo.isNullOrNil(emojiGroupInfo.field_productID)) {
                            emojiGroupInfo.field_recommand = 1;
                            emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                            emojiGroupInfo.field_sort = 0;
                            h.pYm.e(12068, Integer.valueOf(1), emojiGroupInfo.field_productID, Integer.valueOf(emojiGroupInfo.field_recommandType));
                            arrayList.add(emojiGroupInfo);
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(53162);
                        return arrayList;
                    }
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiRecommendXMLParser", "[parser] parseXML exception:%s", e.toString());
        }
        AppMethodBeat.o(53162);
        return null;
    }
}
