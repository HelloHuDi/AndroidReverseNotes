package com.tencent.p177mm.emoji.p1598e;

import android.content.Context;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C40628r;
import com.tencent.p177mm.storage.emotion.SmileyInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: com.tencent.mm.emoji.e.a */
public final class C41953a {
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static ArrayList<SmileyInfo> m74097a(C5728b c5728b) {
        Throwable th;
        AppMethodBeat.m2504i(62270);
        ArrayList arrayList = new ArrayList();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            InputStream p = C5730e.m8638p(c5728b);
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
                                    if (C5046bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
                                        smileyInfo.field_cnValue = smileyInfo.field_key;
                                    } else {
                                        smileyInfo.field_cnValue = item.getTextContent();
                                    }
                                } else if (nodeName.equalsIgnoreCase("qq-value")) {
                                    if (C5046bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
                                        smileyInfo.field_qqValue = smileyInfo.field_key;
                                    } else {
                                        smileyInfo.field_qqValue = item.getTextContent();
                                    }
                                } else if (nodeName.equalsIgnoreCase("en-value")) {
                                    if (C5046bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
                                        smileyInfo.field_enValue = smileyInfo.field_key;
                                    } else {
                                        smileyInfo.field_enValue = item.getTextContent();
                                    }
                                } else if (nodeName.equalsIgnoreCase("tw-value")) {
                                    if (C5046bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
                                        smileyInfo.field_twValue = smileyInfo.field_key;
                                    } else {
                                        smileyInfo.field_twValue = item.getTextContent();
                                    }
                                } else if (nodeName.equalsIgnoreCase("th-value")) {
                                    if (C5046bo.isNullOrNil(item.getTextContent()) || BuildConfig.COMMAND.equalsIgnoreCase(item.getTextContent())) {
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
                                        C4990ab.m7412e("MicroMsg.EmojiResHelper", C5046bo.m7574l(e));
                                        intValue = -1;
                                    }
                                    smileyInfo.field_eggIndex = intValue;
                                }
                            }
                            smileyInfo.field_position = -1;
                            C4990ab.m7410d("MicroMsg.EmojiResHelper", smileyInfo.toString());
                            if (C5046bo.isNullOrNil(smileyInfo.field_key)) {
                                C4990ab.m7416i("MicroMsg.EmojiResHelper", "key is empty");
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
                AppMethodBeat.m2505o(62270);
                throw th;
            }
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.EmojiResHelper", "parserSmileyConfig parseXML exception:%s", e2.toString());
        }
        if (arrayList.size() == 0) {
            C4990ab.m7420w("MicroMsg.EmojiResHelper", "parserSmileyConfig empty!");
        }
        AppMethodBeat.m2505o(62270);
        return arrayList;
    }

    /* renamed from: b */
    public static ArrayList<C40628r> m74098b(C5728b c5728b) {
        AppMethodBeat.m2504i(62271);
        ArrayList arrayList = new ArrayList();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        InputStream inputStream = null;
        try {
            inputStream = C5730e.m8638p(c5728b);
            Document parse = newInstance.newDocumentBuilder().parse(inputStream);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("item");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    if (!(item == null || C5046bo.isNullOrNil(item.getTextContent()))) {
                        String replaceAll = item.getTextContent().replaceAll("\"", "");
                        if (replaceAll.startsWith("\\\\u")) {
                            char[] toChars = Character.toChars(Integer.parseInt(replaceAll.substring(3), 16));
                            replaceAll = "";
                            for (char valueOf : toChars) {
                                replaceAll = replaceAll + String.valueOf(valueOf);
                            }
                        }
                        C40628r c40628r = new C40628r(i, replaceAll);
                        if (C5046bo.isNullOrNil(c40628r.field_key)) {
                            C4990ab.m7416i("MicroMsg.EmojiResHelper", "key is null.");
                        } else {
                            arrayList.add(c40628r);
                        }
                        C4990ab.m7410d("MicroMsg.EmojiResHelper", c40628r.toString());
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
            C4990ab.m7413e("MicroMsg.EmojiResHelper", "parseSmileyPanelConfig parseXML exception:%s", e2.toString());
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
            AppMethodBeat.m2505o(62271);
        }
        AppMethodBeat.m2505o(62271);
        return arrayList;
    }

    /* renamed from: y */
    public static int m74099y(Context context, int i) {
        AppMethodBeat.m2504i(62272);
        if (context == null) {
            AppMethodBeat.m2505o(62272);
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        int i2 = typedValue.resourceId;
        AppMethodBeat.m2505o(62272);
        return i2;
    }
}
