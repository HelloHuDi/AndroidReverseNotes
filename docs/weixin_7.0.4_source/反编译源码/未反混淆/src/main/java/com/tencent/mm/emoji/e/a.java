package com.tencent.mm.emoji.e;

import android.content.Context;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ArrayList<SmileyInfo> a(b bVar) {
        Throwable th;
        AppMethodBeat.i(62270);
        ArrayList arrayList = new ArrayList();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            InputStream p = e.p(bVar);
            Throwable th2 = null;
            try {
                Document parse = newInstance.newDocumentBuilder().parse(p);
                parse.normalize();
                NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("emoji");
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    int length = elementsByTagName.getLength();
                    for (int i = 0; i < length; i++) {
                        NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                        if (childNodes != null && childNodes.getLength() > 0) {
                            SmileyInfo smileyInfo = new SmileyInfo();
                            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                                Node item = childNodes.item(i2);
                                String nodeName = item.getNodeName();
                                if (nodeName.equalsIgnoreCase("key")) {
                                    smileyInfo.field_key = item.getTextContent();
                                } else if (nodeName.equalsIgnoreCase("cn-value")) {
                                    if (bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
                                        smileyInfo.field_cnValue = smileyInfo.field_key;
                                    } else {
                                        smileyInfo.field_cnValue = item.getTextContent();
                                    }
                                } else if (nodeName.equalsIgnoreCase("qq-value")) {
                                    if (bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
                                        smileyInfo.field_qqValue = smileyInfo.field_key;
                                    } else {
                                        smileyInfo.field_qqValue = item.getTextContent();
                                    }
                                } else if (nodeName.equalsIgnoreCase("en-value")) {
                                    if (bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
                                        smileyInfo.field_enValue = smileyInfo.field_key;
                                    } else {
                                        smileyInfo.field_enValue = item.getTextContent();
                                    }
                                } else if (nodeName.equalsIgnoreCase("tw-value")) {
                                    if (bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
                                        smileyInfo.field_twValue = smileyInfo.field_key;
                                    } else {
                                        smileyInfo.field_twValue = item.getTextContent();
                                    }
                                } else if (nodeName.equalsIgnoreCase("th-value")) {
                                    if (bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
                                        smileyInfo.field_thValue = smileyInfo.field_key;
                                    } else {
                                        smileyInfo.field_thValue = item.getTextContent();
                                    }
                                } else if (nodeName.equalsIgnoreCase(DownloadInfo.FILENAME)) {
                                    smileyInfo.field_fileName = item.getTextContent();
                                } else if (nodeName.equalsIgnoreCase("eggIndex")) {
                                    int intValue;
                                    try {
                                        intValue = Integer.valueOf(item.getTextContent()).intValue();
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.EmojiResHelper", bo.l(e));
                                        intValue = -1;
                                    }
                                    smileyInfo.field_eggIndex = intValue;
                                }
                            }
                            smileyInfo.field_position = -1;
                            ab.d("MicroMsg.EmojiResHelper", smileyInfo.toString());
                            if (bo.isNullOrNil(smileyInfo.field_key)) {
                                ab.i("MicroMsg.EmojiResHelper", "key is empty");
                            } else {
                                arrayList.add(smileyInfo);
                            }
                        }
                    }
                }
                if (p != null) {
                    p.close();
                }
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                if (p != null) {
                }
                AppMethodBeat.o(62270);
                throw th;
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.EmojiResHelper", "parserSmileyConfig parseXML exception:%s", e2.toString());
        }
        if (arrayList.size() == 0) {
            ab.w("MicroMsg.EmojiResHelper", "parserSmileyConfig empty!");
        }
        AppMethodBeat.o(62270);
        return arrayList;
    }

    public static ArrayList<r> b(b bVar) {
        AppMethodBeat.i(62271);
        ArrayList arrayList = new ArrayList();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        InputStream inputStream = null;
        try {
            inputStream = e.p(bVar);
            Document parse = newInstance.newDocumentBuilder().parse(inputStream);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("item");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    if (!(item == null || bo.isNullOrNil(item.getTextContent()))) {
                        String replaceAll = item.getTextContent().replaceAll("\"", "");
                        if (replaceAll.startsWith("\\\\u")) {
                            char[] toChars = Character.toChars(Integer.parseInt(replaceAll.substring(3), 16));
                            replaceAll = "";
                            for (char valueOf : toChars) {
                                replaceAll = replaceAll + String.valueOf(valueOf);
                            }
                        }
                        r rVar = new r(i, replaceAll);
                        if (bo.isNullOrNil(rVar.field_key)) {
                            ab.i("MicroMsg.EmojiResHelper", "key is null.");
                        } else {
                            arrayList.add(rVar);
                        }
                        ab.d("MicroMsg.EmojiResHelper", rVar.toString());
                    }
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.EmojiResHelper", "parseSmileyPanelConfig parseXML exception:%s", e2.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(62271);
        }
        AppMethodBeat.o(62271);
        return arrayList;
    }

    public static int y(Context context, int i) {
        AppMethodBeat.i(62272);
        if (context == null) {
            AppMethodBeat.o(62272);
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        int i2 = typedValue.resourceId;
        AppMethodBeat.o(62272);
        return i2;
    }
}
