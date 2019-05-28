package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.b.c;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class f {
    private static DocumentBuilder foC = null;

    /* JADX WARNING: Removed duplicated region for block: B:72:0x03bf A:{Catch:{ Exception -> 0x024b }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x03d2 A:{Catch:{ Exception -> 0x024b }} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x03e5 A:{Catch:{ Exception -> 0x024b }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x03f8 A:{Catch:{ Exception -> 0x024b }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b1 A:{Catch:{ Exception -> 0x024b }} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x03bf A:{Catch:{ Exception -> 0x024b }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x03d2 A:{Catch:{ Exception -> 0x024b }} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x03e5 A:{Catch:{ Exception -> 0x024b }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x03f8 A:{Catch:{ Exception -> 0x024b }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:64:0x023e, code skipped:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:65:0x023f, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Welabparser", com.tencent.mm.sdk.platformtools.bo.l(r3));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a agK(String str) {
        AppMethodBeat.i(80556);
        ab.v("MicroMsg.Welabparser", "ABTest msg content: %s", str);
        String replaceAll = str.replaceAll(">\n+\\s*<", "><");
        a aVar = new a();
        Element pd = pd(replaceAll);
        if (pd == null) {
            ab.e("MicroMsg.Welabparser", "Msg parsing failed, msg: %s", replaceAll);
            AppMethodBeat.o(80556);
            return aVar;
        }
        NamedNodeMap attributes = pd.getAttributes();
        if (attributes == null) {
            AppMethodBeat.o(80556);
            return null;
        }
        Node namedItem = attributes.getNamedItem("type");
        int i = 1;
        if (namedItem == null || !"newabtestlabs".equals(namedItem.getNodeValue())) {
            ab.i("MicroMsg.Welabparser", "recv illegal type msg");
            AppMethodBeat.o(80556);
            return aVar;
        }
        NodeList elementsByTagName = pd.getElementsByTagName("prioritylevel");
        if (elementsByTagName.getLength() > 0) {
            i = bo.getInt(elementsByTagName.item(0).getTextContent(), 1);
        }
        elementsByTagName = pd.getElementsByTagName("status");
        if (elementsByTagName.getLength() > 0) {
            aVar.field_status = bo.getInt(elementsByTagName.item(0).getTextContent(), 1);
        }
        aVar.field_prioritylevel = i;
        NodeList childNodes = pd.getChildNodes();
        i = 0;
        while (true) {
            int i2 = i;
            if (i2 < childNodes.getLength()) {
                Node item = childNodes.item(i2);
                if (item != null && item.getNodeType() == (short) 1 && item.getNodeName().equals("expinfo")) {
                    Element element = (Element) item;
                    NamedNodeMap attributes2 = element.getAttributes();
                    if (attributes2 != null) {
                        Node namedItem2 = attributes2.getNamedItem("id");
                        if (namedItem2 != null) {
                            aVar.field_expId = namedItem2.getNodeValue();
                            NodeList elementsByTagName2 = element.getElementsByTagName("sequence");
                            if (elementsByTagName2.getLength() != 0) {
                                long j;
                                long currentTimeMillis;
                                long j2 = bo.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                elementsByTagName2 = element.getElementsByTagName("starttime");
                                if (elementsByTagName2.getLength() > 0) {
                                    j = bo.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                    if (j == 0) {
                                        currentTimeMillis = System.currentTimeMillis() / 1000;
                                    } else {
                                        currentTimeMillis = j;
                                    }
                                } else {
                                    currentTimeMillis = System.currentTimeMillis() / 1000;
                                }
                                try {
                                    long j3;
                                    HashMap hashMap;
                                    NodeList elementsByTagName3;
                                    aVar.field_idkey = bo.getInt(element.getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent(), -1);
                                    aVar.field_idkeyValue = bo.getInt(element.getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(1).getTextContent(), -1);
                                    elementsByTagName2 = element.getElementsByTagName("endtime");
                                    if (elementsByTagName2.getLength() > 0) {
                                        j = bo.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                        if (j != 0) {
                                            j3 = j;
                                            hashMap = new HashMap();
                                            elementsByTagName3 = element.getElementsByTagName("args");
                                            if (elementsByTagName3.getLength() > 0) {
                                                NodeList childNodes2 = elementsByTagName3.item(0).getChildNodes();
                                                i = 0;
                                                while (true) {
                                                    int i3 = i;
                                                    if (i3 < childNodes2.getLength()) {
                                                        namedItem2 = childNodes2.item(i3);
                                                        if (namedItem2.getNodeType() == (short) 1 && namedItem2.getNodeName().equals("arg")) {
                                                            elementsByTagName3 = ((Element) namedItem2).getElementsByTagName("key");
                                                            elementsByTagName2 = ((Element) namedItem2).getElementsByTagName("value");
                                                            if (!(elementsByTagName3.getLength() == 0 || elementsByTagName2.getLength() == 0)) {
                                                                hashMap.put(elementsByTagName3.item(0).getTextContent(), elementsByTagName2.item(0).getTextContent());
                                                            }
                                                        }
                                                        i = i3 + 1;
                                                    }
                                                }
                                                aVar.field_sequence = j2;
                                                aVar.field_starttime = currentTimeMillis;
                                                aVar.field_endtime = j3;
                                                aVar.field_AllVer = bo.ank((String) hashMap.get("AllVer"));
                                                aVar.field_BizType = bo.ank((String) hashMap.get("BizType"));
                                                aVar.field_Desc_cn = (String) hashMap.get("Desc_cn");
                                                aVar.field_Desc_en = (String) hashMap.get("Desc_en");
                                                aVar.field_Desc_hk = (String) hashMap.get("Desc_hk");
                                                aVar.field_Desc_tw = (String) hashMap.get("Desc_tw");
                                                aVar.field_DetailURL = (String) hashMap.get("DetailURL");
                                                aVar.field_Introduce_cn = (String) hashMap.get("Introduce_cn");
                                                aVar.field_Introduce_en = (String) hashMap.get("Introduce_en");
                                                aVar.field_Introduce_hk = (String) hashMap.get("Introduce_hk");
                                                aVar.field_Introduce_tw = (String) hashMap.get("Introduce_tw");
                                                aVar.field_Pos = bo.ank((String) hashMap.get("Pos"));
                                                aVar.field_Type = bo.ank((String) hashMap.get("Type"));
                                                aVar.field_Switch = bo.ank((String) hashMap.get("Switch"));
                                                aVar.field_WeAppPath = (String) hashMap.get("WeAppPath");
                                                aVar.field_WeAppUser = (String) hashMap.get("WeAppUser");
                                                aVar.field_LabsAppId = (String) hashMap.get("LabsAppId");
                                                aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                                aVar.field_Title_cn = (String) hashMap.get("Title_cn");
                                                aVar.field_Title_en = (String) hashMap.get("Title_en");
                                                aVar.field_Title_hk = (String) hashMap.get("Title_hk");
                                                aVar.field_Title_tw = (String) hashMap.get("Title_tw");
                                                aVar.field_ThumbUrl_cn = (String) hashMap.get("ThumbUrl_cn");
                                                aVar.field_ThumbUrl_en = (String) hashMap.get("ThumbUrl_en");
                                                aVar.field_ThumbUrl_hk = (String) hashMap.get("ThumbUrl_hk");
                                                aVar.field_ThumbUrl_tw = (String) hashMap.get("ThumbUrl_tw");
                                                aVar.field_ImgUrl_android_cn = a(hashMap, "ImgUrl_android_cn");
                                                aVar.field_ImgUrl_android_tw = a(hashMap, "ImgUrl_android_tw");
                                                aVar.field_ImgUrl_android_en = a(hashMap, "ImgUrl_android_en");
                                                aVar.field_ImgUrl_android_hk = a(hashMap, "ImgUrl_android_hk");
                                                if (TextUtils.isEmpty(aVar.field_ImgUrl_android_cn)) {
                                                    aVar.field_ImgUrl_android_cn = (String) hashMap.get("ImgUrl_cn");
                                                }
                                                if (TextUtils.isEmpty(aVar.field_ImgUrl_android_en)) {
                                                    aVar.field_ImgUrl_android_en = (String) hashMap.get("ImgUrl_en");
                                                }
                                                if (TextUtils.isEmpty(aVar.field_ImgUrl_android_hk)) {
                                                    aVar.field_ImgUrl_android_hk = (String) hashMap.get("ImgUrl_hk");
                                                }
                                                if (TextUtils.isEmpty(aVar.field_ImgUrl_android_tw)) {
                                                    aVar.field_ImgUrl_android_tw = (String) hashMap.get("ImgUrl_tw");
                                                }
                                                aVar.field_RedPoint = bo.ank((String) hashMap.get("RedPoint"));
                                                aVar.field_WeAppDebugMode = bo.ank((String) hashMap.get("WeAppDebugMode"));
                                                aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                                aVar.field_Icon = (String) hashMap.get("Icon");
                                            }
                                            aVar.field_sequence = j2;
                                            aVar.field_starttime = currentTimeMillis;
                                            aVar.field_endtime = j3;
                                            aVar.field_AllVer = bo.ank((String) hashMap.get("AllVer"));
                                            aVar.field_BizType = bo.ank((String) hashMap.get("BizType"));
                                            aVar.field_Desc_cn = (String) hashMap.get("Desc_cn");
                                            aVar.field_Desc_en = (String) hashMap.get("Desc_en");
                                            aVar.field_Desc_hk = (String) hashMap.get("Desc_hk");
                                            aVar.field_Desc_tw = (String) hashMap.get("Desc_tw");
                                            aVar.field_DetailURL = (String) hashMap.get("DetailURL");
                                            aVar.field_Introduce_cn = (String) hashMap.get("Introduce_cn");
                                            aVar.field_Introduce_en = (String) hashMap.get("Introduce_en");
                                            aVar.field_Introduce_hk = (String) hashMap.get("Introduce_hk");
                                            aVar.field_Introduce_tw = (String) hashMap.get("Introduce_tw");
                                            aVar.field_Pos = bo.ank((String) hashMap.get("Pos"));
                                            aVar.field_Type = bo.ank((String) hashMap.get("Type"));
                                            aVar.field_Switch = bo.ank((String) hashMap.get("Switch"));
                                            aVar.field_WeAppPath = (String) hashMap.get("WeAppPath");
                                            aVar.field_WeAppUser = (String) hashMap.get("WeAppUser");
                                            aVar.field_LabsAppId = (String) hashMap.get("LabsAppId");
                                            aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                            aVar.field_Title_cn = (String) hashMap.get("Title_cn");
                                            aVar.field_Title_en = (String) hashMap.get("Title_en");
                                            aVar.field_Title_hk = (String) hashMap.get("Title_hk");
                                            aVar.field_Title_tw = (String) hashMap.get("Title_tw");
                                            aVar.field_ThumbUrl_cn = (String) hashMap.get("ThumbUrl_cn");
                                            aVar.field_ThumbUrl_en = (String) hashMap.get("ThumbUrl_en");
                                            aVar.field_ThumbUrl_hk = (String) hashMap.get("ThumbUrl_hk");
                                            aVar.field_ThumbUrl_tw = (String) hashMap.get("ThumbUrl_tw");
                                            aVar.field_ImgUrl_android_cn = a(hashMap, "ImgUrl_android_cn");
                                            aVar.field_ImgUrl_android_tw = a(hashMap, "ImgUrl_android_tw");
                                            aVar.field_ImgUrl_android_en = a(hashMap, "ImgUrl_android_en");
                                            aVar.field_ImgUrl_android_hk = a(hashMap, "ImgUrl_android_hk");
                                            if (TextUtils.isEmpty(aVar.field_ImgUrl_android_cn)) {
                                            }
                                            if (TextUtils.isEmpty(aVar.field_ImgUrl_android_en)) {
                                            }
                                            if (TextUtils.isEmpty(aVar.field_ImgUrl_android_hk)) {
                                            }
                                            if (TextUtils.isEmpty(aVar.field_ImgUrl_android_tw)) {
                                            }
                                            aVar.field_RedPoint = bo.ank((String) hashMap.get("RedPoint"));
                                            aVar.field_WeAppDebugMode = bo.ank((String) hashMap.get("WeAppDebugMode"));
                                            aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                            aVar.field_Icon = (String) hashMap.get("Icon");
                                        }
                                    }
                                    j3 = Long.MAX_VALUE;
                                    hashMap = new HashMap();
                                    elementsByTagName3 = element.getElementsByTagName("args");
                                    if (elementsByTagName3.getLength() > 0) {
                                    }
                                    aVar.field_sequence = j2;
                                    aVar.field_starttime = currentTimeMillis;
                                    aVar.field_endtime = j3;
                                    aVar.field_AllVer = bo.ank((String) hashMap.get("AllVer"));
                                    aVar.field_BizType = bo.ank((String) hashMap.get("BizType"));
                                    aVar.field_Desc_cn = (String) hashMap.get("Desc_cn");
                                    aVar.field_Desc_en = (String) hashMap.get("Desc_en");
                                    aVar.field_Desc_hk = (String) hashMap.get("Desc_hk");
                                    aVar.field_Desc_tw = (String) hashMap.get("Desc_tw");
                                    aVar.field_DetailURL = (String) hashMap.get("DetailURL");
                                    aVar.field_Introduce_cn = (String) hashMap.get("Introduce_cn");
                                    aVar.field_Introduce_en = (String) hashMap.get("Introduce_en");
                                    aVar.field_Introduce_hk = (String) hashMap.get("Introduce_hk");
                                    aVar.field_Introduce_tw = (String) hashMap.get("Introduce_tw");
                                    aVar.field_Pos = bo.ank((String) hashMap.get("Pos"));
                                    aVar.field_Type = bo.ank((String) hashMap.get("Type"));
                                    aVar.field_Switch = bo.ank((String) hashMap.get("Switch"));
                                    aVar.field_WeAppPath = (String) hashMap.get("WeAppPath");
                                    aVar.field_WeAppUser = (String) hashMap.get("WeAppUser");
                                    aVar.field_LabsAppId = (String) hashMap.get("LabsAppId");
                                    aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                    aVar.field_Title_cn = (String) hashMap.get("Title_cn");
                                    aVar.field_Title_en = (String) hashMap.get("Title_en");
                                    aVar.field_Title_hk = (String) hashMap.get("Title_hk");
                                    aVar.field_Title_tw = (String) hashMap.get("Title_tw");
                                    aVar.field_ThumbUrl_cn = (String) hashMap.get("ThumbUrl_cn");
                                    aVar.field_ThumbUrl_en = (String) hashMap.get("ThumbUrl_en");
                                    aVar.field_ThumbUrl_hk = (String) hashMap.get("ThumbUrl_hk");
                                    aVar.field_ThumbUrl_tw = (String) hashMap.get("ThumbUrl_tw");
                                    aVar.field_ImgUrl_android_cn = a(hashMap, "ImgUrl_android_cn");
                                    aVar.field_ImgUrl_android_tw = a(hashMap, "ImgUrl_android_tw");
                                    aVar.field_ImgUrl_android_en = a(hashMap, "ImgUrl_android_en");
                                    aVar.field_ImgUrl_android_hk = a(hashMap, "ImgUrl_android_hk");
                                    if (TextUtils.isEmpty(aVar.field_ImgUrl_android_cn)) {
                                    }
                                    if (TextUtils.isEmpty(aVar.field_ImgUrl_android_en)) {
                                    }
                                    if (TextUtils.isEmpty(aVar.field_ImgUrl_android_hk)) {
                                    }
                                    if (TextUtils.isEmpty(aVar.field_ImgUrl_android_tw)) {
                                    }
                                    aVar.field_RedPoint = bo.ank((String) hashMap.get("RedPoint"));
                                    aVar.field_WeAppDebugMode = bo.ank((String) hashMap.get("WeAppDebugMode"));
                                    aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                    aVar.field_Icon = (String) hashMap.get("Icon");
                                } catch (Exception e) {
                                    ab.e("MicroMsg.Welabparser", e.getMessage());
                                }
                            }
                        }
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(80556);
                return aVar;
            }
        }
    }

    private static String a(HashMap<String, String> hashMap, String str) {
        AppMethodBeat.i(80557);
        StringBuilder stringBuilder = new StringBuilder();
        String str2;
        if (hashMap.containsKey(str)) {
            stringBuilder.append((String) hashMap.get(str)).append(";");
            int i = 1;
            while (true) {
                int i2 = i;
                str2 = str + "_" + i2;
                if (hashMap.containsKey(str2)) {
                    stringBuilder.append((String) hashMap.get(str2)).append(";");
                    i = i2 + 1;
                } else {
                    str2 = stringBuilder.toString();
                    AppMethodBeat.o(80557);
                    return str2;
                }
            }
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.o(80557);
        return str2;
    }

    public static List<String> agL(String str) {
        AppMethodBeat.i(80558);
        if (TextUtils.isEmpty(str)) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.o(80558);
            return list;
        }
        List<String> asList = Arrays.asList(str.split(";"));
        AppMethodBeat.o(80558);
        return asList;
    }

    private static Element pd(String str) {
        AppMethodBeat.i(80559);
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
            AppMethodBeat.o(80559);
            return documentElement;
        } catch (Exception e) {
            ab.e("MicroMsg.Welabparser", e.toString());
            AppMethodBeat.o(80559);
            return null;
        }
    }

    public static a a(c cVar) {
        AppMethodBeat.i(80560);
        a aVar = new a();
        aVar.field_expId = String.valueOf(cVar.uMa);
        aVar.field_sequence = (long) cVar.uMb;
        aVar.field_starttime = cVar.startTime > 0 ? cVar.startTime : System.currentTimeMillis() / 1000;
        aVar.field_endtime = cVar.endTime > 0 ? cVar.endTime : Long.MAX_VALUE;
        String str = "xlab_" + cVar.uMa;
        HashMap hashMap = cVar.cag;
        aVar.field_AllVer = bo.ank((String) hashMap.get(ep(str, "AllVer")));
        aVar.field_BizType = bo.ank((String) hashMap.get(ep(str, "BizType")));
        aVar.field_Desc_cn = (String) hashMap.get(ep(str, "Desc_cn"));
        aVar.field_Desc_en = (String) hashMap.get(ep(str, "Desc_en"));
        aVar.field_Desc_hk = (String) hashMap.get(ep(str, "Desc_hk"));
        aVar.field_Desc_tw = (String) hashMap.get(ep(str, "Desc_tw"));
        aVar.field_DetailURL = (String) hashMap.get(ep(str, "DetailURL"));
        aVar.field_Introduce_cn = (String) hashMap.get(ep(str, "Introduce_cn"));
        aVar.field_Introduce_en = (String) hashMap.get(ep(str, "Introduce_en"));
        aVar.field_Introduce_hk = (String) hashMap.get(ep(str, "Introduce_hk"));
        aVar.field_Introduce_tw = (String) hashMap.get(ep(str, "Introduce_tw"));
        aVar.field_Pos = bo.ank((String) hashMap.get(ep(str, "Pos")));
        aVar.field_Type = bo.ank((String) hashMap.get(ep(str, "Type")));
        aVar.field_Switch = bo.ank((String) hashMap.get(ep(str, "Switch")));
        aVar.field_WeAppPath = (String) hashMap.get(ep(str, "WeAppPath"));
        aVar.field_WeAppUser = (String) hashMap.get(ep(str, "WeAppUser"));
        aVar.field_LabsAppId = (String) hashMap.get(ep(str, "LabsAppId"));
        aVar.field_TitleKey_android = (String) hashMap.get(ep(str, "TitleKey_android"));
        aVar.field_Title_cn = (String) hashMap.get(ep(str, "Title_cn"));
        aVar.field_Title_en = (String) hashMap.get(ep(str, "Title_en"));
        aVar.field_Title_hk = (String) hashMap.get(ep(str, "Title_hk"));
        aVar.field_Title_tw = (String) hashMap.get(ep(str, "Title_tw"));
        aVar.field_ThumbUrl_cn = (String) hashMap.get(ep(str, "ThumbUrl_cn"));
        aVar.field_ThumbUrl_en = (String) hashMap.get(ep(str, "ThumbUrl_en"));
        aVar.field_ThumbUrl_hk = (String) hashMap.get(ep(str, "ThumbUrl_hk"));
        aVar.field_ThumbUrl_tw = (String) hashMap.get(ep(str, "ThumbUrl_tw"));
        aVar.field_ImgUrl_android_cn = a(hashMap, ep(str, "ImgUrl_android_cn")).replace(',', ';');
        aVar.field_ImgUrl_android_tw = a(hashMap, ep(str, "ImgUrl_android_tw")).replace(',', ';');
        aVar.field_ImgUrl_android_en = a(hashMap, ep(str, "ImgUrl_android_en")).replace(',', ';');
        aVar.field_ImgUrl_android_hk = a(hashMap, ep(str, "ImgUrl_android_hk")).replace(',', ';');
        if (TextUtils.isEmpty(aVar.field_ImgUrl_android_cn)) {
            aVar.field_ImgUrl_android_cn = (String) hashMap.get(ep(str, "ImgUrl_cn"));
        }
        if (TextUtils.isEmpty(aVar.field_ImgUrl_android_en)) {
            aVar.field_ImgUrl_android_en = (String) hashMap.get(ep(str, "ImgUrl_en"));
        }
        if (TextUtils.isEmpty(aVar.field_ImgUrl_android_hk)) {
            aVar.field_ImgUrl_android_hk = (String) hashMap.get(ep(str, "ImgUrl_hk"));
        }
        if (TextUtils.isEmpty(aVar.field_ImgUrl_android_tw)) {
            aVar.field_ImgUrl_android_tw = (String) hashMap.get(ep(str, "ImgUrl_tw"));
        }
        aVar.field_RedPoint = bo.ank((String) hashMap.get(ep(str, "RedPoint")));
        aVar.field_WeAppDebugMode = bo.ank((String) hashMap.get(ep(str, "WeAppDebugMode")));
        aVar.field_TitleKey_android = (String) hashMap.get(ep(str, "TitleKey_android"));
        aVar.field_Icon = (String) hashMap.get(ep(str, "Icon"));
        aVar.field_bItemFromXExpt = 1;
        aVar.field_status = bo.ank((String) hashMap.get(ep(str, "status")));
        aVar.field_idkey = bo.ank((String) hashMap.get(ep(str, "idkey")));
        aVar.field_idkeyValue = bo.ank((String) hashMap.get(ep(str, "idkeyValue")));
        AppMethodBeat.o(80560);
        return aVar;
    }

    private static String ep(String str, String str2) {
        AppMethodBeat.i(80561);
        String toLowerCase = (str + "_" + str2).toLowerCase();
        AppMethodBeat.o(80561);
        return toLowerCase;
    }
}
