package com.tencent.p177mm.plugin.emoji.p727g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* renamed from: com.tencent.mm.plugin.emoji.g.d */
public final class C20377d {
    /* renamed from: JG */
    public static ArrayList<EmojiGroupInfo> m31543JG(String str) {
        AppMethodBeat.m2504i(53162);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] parse xml faild. xml is null.");
            AppMethodBeat.m2505o(53162);
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
                                C4990ab.m7411d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] productId:%s", item.getTextContent());
                                emojiGroupInfo.field_productID = r7;
                            } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("RecType")) {
                                if (item != null) {
                                    if (item.getNodeName() != null && item.getNodeName().equals("RecWord")) {
                                        C4990ab.m7411d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] recWord:%s", item.getTextContent());
                                        emojiGroupInfo.field_recommandWord = r7;
                                    }
                                }
                                if (item != null && item.getNodeName() != null && item.getNodeName().equals("Name")) {
                                    C4990ab.m7411d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] Name:%s", item.getTextContent());
                                    emojiGroupInfo.field_packName = r7;
                                } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Panel")) {
                                    C4990ab.m7411d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] iconUrl:%s", item.getTextContent());
                                    emojiGroupInfo.field_packGrayIconUrl = r7;
                                } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Icon")) {
                                    C4990ab.m7411d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] BigIconUrl:%s", item.getTextContent());
                                    emojiGroupInfo.field_BigIconUrl = r7;
                                } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("ButtonType"))) {
                                    C4990ab.m7411d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] buttonType:%s", item.getTextContent());
                                    emojiGroupInfo.field_buttonType = Integer.valueOf(r7).intValue();
                                }
                            } else {
                                C4990ab.m7411d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] RecType:%s", item.getTextContent());
                                emojiGroupInfo.field_recommandType = Integer.valueOf(r7).intValue();
                            }
                        }
                        if (!C5046bo.isNullOrNil(emojiGroupInfo.field_productID)) {
                            emojiGroupInfo.field_recommand = 1;
                            emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                            emojiGroupInfo.field_sort = 0;
                            C7060h.pYm.mo8381e(12068, Integer.valueOf(1), emojiGroupInfo.field_productID, Integer.valueOf(emojiGroupInfo.field_recommandType));
                            arrayList.add(emojiGroupInfo);
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(53162);
                        return arrayList;
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiRecommendXMLParser", "[parser] parseXML exception:%s", e.toString());
        }
        AppMethodBeat.m2505o(53162);
        return null;
    }
}
