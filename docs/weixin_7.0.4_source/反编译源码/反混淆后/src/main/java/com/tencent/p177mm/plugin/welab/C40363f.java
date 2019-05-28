package com.tencent.p177mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.plugin.welab.p753b.C14716c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.welab.f */
public final class C40363f {
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("MicroMsg.Welabparser", com.tencent.p177mm.sdk.platformtools.C5046bo.m7574l(r3));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static C23169a agK(String str) {
        AppMethodBeat.m2504i(80556);
        C4990ab.m7419v("MicroMsg.Welabparser", "ABTest msg content: %s", str);
        String replaceAll = str.replaceAll(">\n+\\s*<", "><");
        C23169a c23169a = new C23169a();
        Element pd = C40363f.m69206pd(replaceAll);
        if (pd == null) {
            C4990ab.m7413e("MicroMsg.Welabparser", "Msg parsing failed, msg: %s", replaceAll);
            AppMethodBeat.m2505o(80556);
            return c23169a;
        }
        NamedNodeMap attributes = pd.getAttributes();
        if (attributes == null) {
            AppMethodBeat.m2505o(80556);
            return null;
        }
        Node namedItem = attributes.getNamedItem("type");
        int i = 1;
        if (namedItem == null || !"newabtestlabs".equals(namedItem.getNodeValue())) {
            C4990ab.m7416i("MicroMsg.Welabparser", "recv illegal type msg");
            AppMethodBeat.m2505o(80556);
            return c23169a;
        }
        NodeList elementsByTagName = pd.getElementsByTagName("prioritylevel");
        if (elementsByTagName.getLength() > 0) {
            i = C5046bo.getInt(elementsByTagName.item(0).getTextContent(), 1);
        }
        elementsByTagName = pd.getElementsByTagName("status");
        if (elementsByTagName.getLength() > 0) {
            c23169a.field_status = C5046bo.getInt(elementsByTagName.item(0).getTextContent(), 1);
        }
        c23169a.field_prioritylevel = i;
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
                            c23169a.field_expId = namedItem2.getNodeValue();
                            NodeList elementsByTagName2 = element.getElementsByTagName("sequence");
                            if (elementsByTagName2.getLength() != 0) {
                                long j;
                                long currentTimeMillis;
                                long j2 = C5046bo.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                elementsByTagName2 = element.getElementsByTagName("starttime");
                                if (elementsByTagName2.getLength() > 0) {
                                    j = C5046bo.getLong(elementsByTagName2.item(0).getTextContent(), 0);
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
                                    c23169a.field_idkey = C5046bo.getInt(element.getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent(), -1);
                                    c23169a.field_idkeyValue = C5046bo.getInt(element.getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(1).getTextContent(), -1);
                                    elementsByTagName2 = element.getElementsByTagName("endtime");
                                    if (elementsByTagName2.getLength() > 0) {
                                        j = C5046bo.getLong(elementsByTagName2.item(0).getTextContent(), 0);
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
                                                c23169a.field_sequence = j2;
                                                c23169a.field_starttime = currentTimeMillis;
                                                c23169a.field_endtime = j3;
                                                c23169a.field_AllVer = C5046bo.ank((String) hashMap.get("AllVer"));
                                                c23169a.field_BizType = C5046bo.ank((String) hashMap.get("BizType"));
                                                c23169a.field_Desc_cn = (String) hashMap.get("Desc_cn");
                                                c23169a.field_Desc_en = (String) hashMap.get("Desc_en");
                                                c23169a.field_Desc_hk = (String) hashMap.get("Desc_hk");
                                                c23169a.field_Desc_tw = (String) hashMap.get("Desc_tw");
                                                c23169a.field_DetailURL = (String) hashMap.get("DetailURL");
                                                c23169a.field_Introduce_cn = (String) hashMap.get("Introduce_cn");
                                                c23169a.field_Introduce_en = (String) hashMap.get("Introduce_en");
                                                c23169a.field_Introduce_hk = (String) hashMap.get("Introduce_hk");
                                                c23169a.field_Introduce_tw = (String) hashMap.get("Introduce_tw");
                                                c23169a.field_Pos = C5046bo.ank((String) hashMap.get("Pos"));
                                                c23169a.field_Type = C5046bo.ank((String) hashMap.get("Type"));
                                                c23169a.field_Switch = C5046bo.ank((String) hashMap.get("Switch"));
                                                c23169a.field_WeAppPath = (String) hashMap.get("WeAppPath");
                                                c23169a.field_WeAppUser = (String) hashMap.get("WeAppUser");
                                                c23169a.field_LabsAppId = (String) hashMap.get("LabsAppId");
                                                c23169a.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                                c23169a.field_Title_cn = (String) hashMap.get("Title_cn");
                                                c23169a.field_Title_en = (String) hashMap.get("Title_en");
                                                c23169a.field_Title_hk = (String) hashMap.get("Title_hk");
                                                c23169a.field_Title_tw = (String) hashMap.get("Title_tw");
                                                c23169a.field_ThumbUrl_cn = (String) hashMap.get("ThumbUrl_cn");
                                                c23169a.field_ThumbUrl_en = (String) hashMap.get("ThumbUrl_en");
                                                c23169a.field_ThumbUrl_hk = (String) hashMap.get("ThumbUrl_hk");
                                                c23169a.field_ThumbUrl_tw = (String) hashMap.get("ThumbUrl_tw");
                                                c23169a.field_ImgUrl_android_cn = C40363f.m69204a(hashMap, "ImgUrl_android_cn");
                                                c23169a.field_ImgUrl_android_tw = C40363f.m69204a(hashMap, "ImgUrl_android_tw");
                                                c23169a.field_ImgUrl_android_en = C40363f.m69204a(hashMap, "ImgUrl_android_en");
                                                c23169a.field_ImgUrl_android_hk = C40363f.m69204a(hashMap, "ImgUrl_android_hk");
                                                if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_cn)) {
                                                    c23169a.field_ImgUrl_android_cn = (String) hashMap.get("ImgUrl_cn");
                                                }
                                                if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_en)) {
                                                    c23169a.field_ImgUrl_android_en = (String) hashMap.get("ImgUrl_en");
                                                }
                                                if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_hk)) {
                                                    c23169a.field_ImgUrl_android_hk = (String) hashMap.get("ImgUrl_hk");
                                                }
                                                if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_tw)) {
                                                    c23169a.field_ImgUrl_android_tw = (String) hashMap.get("ImgUrl_tw");
                                                }
                                                c23169a.field_RedPoint = C5046bo.ank((String) hashMap.get("RedPoint"));
                                                c23169a.field_WeAppDebugMode = C5046bo.ank((String) hashMap.get("WeAppDebugMode"));
                                                c23169a.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                                c23169a.field_Icon = (String) hashMap.get("Icon");
                                            }
                                            c23169a.field_sequence = j2;
                                            c23169a.field_starttime = currentTimeMillis;
                                            c23169a.field_endtime = j3;
                                            c23169a.field_AllVer = C5046bo.ank((String) hashMap.get("AllVer"));
                                            c23169a.field_BizType = C5046bo.ank((String) hashMap.get("BizType"));
                                            c23169a.field_Desc_cn = (String) hashMap.get("Desc_cn");
                                            c23169a.field_Desc_en = (String) hashMap.get("Desc_en");
                                            c23169a.field_Desc_hk = (String) hashMap.get("Desc_hk");
                                            c23169a.field_Desc_tw = (String) hashMap.get("Desc_tw");
                                            c23169a.field_DetailURL = (String) hashMap.get("DetailURL");
                                            c23169a.field_Introduce_cn = (String) hashMap.get("Introduce_cn");
                                            c23169a.field_Introduce_en = (String) hashMap.get("Introduce_en");
                                            c23169a.field_Introduce_hk = (String) hashMap.get("Introduce_hk");
                                            c23169a.field_Introduce_tw = (String) hashMap.get("Introduce_tw");
                                            c23169a.field_Pos = C5046bo.ank((String) hashMap.get("Pos"));
                                            c23169a.field_Type = C5046bo.ank((String) hashMap.get("Type"));
                                            c23169a.field_Switch = C5046bo.ank((String) hashMap.get("Switch"));
                                            c23169a.field_WeAppPath = (String) hashMap.get("WeAppPath");
                                            c23169a.field_WeAppUser = (String) hashMap.get("WeAppUser");
                                            c23169a.field_LabsAppId = (String) hashMap.get("LabsAppId");
                                            c23169a.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                            c23169a.field_Title_cn = (String) hashMap.get("Title_cn");
                                            c23169a.field_Title_en = (String) hashMap.get("Title_en");
                                            c23169a.field_Title_hk = (String) hashMap.get("Title_hk");
                                            c23169a.field_Title_tw = (String) hashMap.get("Title_tw");
                                            c23169a.field_ThumbUrl_cn = (String) hashMap.get("ThumbUrl_cn");
                                            c23169a.field_ThumbUrl_en = (String) hashMap.get("ThumbUrl_en");
                                            c23169a.field_ThumbUrl_hk = (String) hashMap.get("ThumbUrl_hk");
                                            c23169a.field_ThumbUrl_tw = (String) hashMap.get("ThumbUrl_tw");
                                            c23169a.field_ImgUrl_android_cn = C40363f.m69204a(hashMap, "ImgUrl_android_cn");
                                            c23169a.field_ImgUrl_android_tw = C40363f.m69204a(hashMap, "ImgUrl_android_tw");
                                            c23169a.field_ImgUrl_android_en = C40363f.m69204a(hashMap, "ImgUrl_android_en");
                                            c23169a.field_ImgUrl_android_hk = C40363f.m69204a(hashMap, "ImgUrl_android_hk");
                                            if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_cn)) {
                                            }
                                            if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_en)) {
                                            }
                                            if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_hk)) {
                                            }
                                            if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_tw)) {
                                            }
                                            c23169a.field_RedPoint = C5046bo.ank((String) hashMap.get("RedPoint"));
                                            c23169a.field_WeAppDebugMode = C5046bo.ank((String) hashMap.get("WeAppDebugMode"));
                                            c23169a.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                            c23169a.field_Icon = (String) hashMap.get("Icon");
                                        }
                                    }
                                    j3 = Long.MAX_VALUE;
                                    hashMap = new HashMap();
                                    elementsByTagName3 = element.getElementsByTagName("args");
                                    if (elementsByTagName3.getLength() > 0) {
                                    }
                                    c23169a.field_sequence = j2;
                                    c23169a.field_starttime = currentTimeMillis;
                                    c23169a.field_endtime = j3;
                                    c23169a.field_AllVer = C5046bo.ank((String) hashMap.get("AllVer"));
                                    c23169a.field_BizType = C5046bo.ank((String) hashMap.get("BizType"));
                                    c23169a.field_Desc_cn = (String) hashMap.get("Desc_cn");
                                    c23169a.field_Desc_en = (String) hashMap.get("Desc_en");
                                    c23169a.field_Desc_hk = (String) hashMap.get("Desc_hk");
                                    c23169a.field_Desc_tw = (String) hashMap.get("Desc_tw");
                                    c23169a.field_DetailURL = (String) hashMap.get("DetailURL");
                                    c23169a.field_Introduce_cn = (String) hashMap.get("Introduce_cn");
                                    c23169a.field_Introduce_en = (String) hashMap.get("Introduce_en");
                                    c23169a.field_Introduce_hk = (String) hashMap.get("Introduce_hk");
                                    c23169a.field_Introduce_tw = (String) hashMap.get("Introduce_tw");
                                    c23169a.field_Pos = C5046bo.ank((String) hashMap.get("Pos"));
                                    c23169a.field_Type = C5046bo.ank((String) hashMap.get("Type"));
                                    c23169a.field_Switch = C5046bo.ank((String) hashMap.get("Switch"));
                                    c23169a.field_WeAppPath = (String) hashMap.get("WeAppPath");
                                    c23169a.field_WeAppUser = (String) hashMap.get("WeAppUser");
                                    c23169a.field_LabsAppId = (String) hashMap.get("LabsAppId");
                                    c23169a.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                    c23169a.field_Title_cn = (String) hashMap.get("Title_cn");
                                    c23169a.field_Title_en = (String) hashMap.get("Title_en");
                                    c23169a.field_Title_hk = (String) hashMap.get("Title_hk");
                                    c23169a.field_Title_tw = (String) hashMap.get("Title_tw");
                                    c23169a.field_ThumbUrl_cn = (String) hashMap.get("ThumbUrl_cn");
                                    c23169a.field_ThumbUrl_en = (String) hashMap.get("ThumbUrl_en");
                                    c23169a.field_ThumbUrl_hk = (String) hashMap.get("ThumbUrl_hk");
                                    c23169a.field_ThumbUrl_tw = (String) hashMap.get("ThumbUrl_tw");
                                    c23169a.field_ImgUrl_android_cn = C40363f.m69204a(hashMap, "ImgUrl_android_cn");
                                    c23169a.field_ImgUrl_android_tw = C40363f.m69204a(hashMap, "ImgUrl_android_tw");
                                    c23169a.field_ImgUrl_android_en = C40363f.m69204a(hashMap, "ImgUrl_android_en");
                                    c23169a.field_ImgUrl_android_hk = C40363f.m69204a(hashMap, "ImgUrl_android_hk");
                                    if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_cn)) {
                                    }
                                    if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_en)) {
                                    }
                                    if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_hk)) {
                                    }
                                    if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_tw)) {
                                    }
                                    c23169a.field_RedPoint = C5046bo.ank((String) hashMap.get("RedPoint"));
                                    c23169a.field_WeAppDebugMode = C5046bo.ank((String) hashMap.get("WeAppDebugMode"));
                                    c23169a.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                    c23169a.field_Icon = (String) hashMap.get("Icon");
                                } catch (Exception e) {
                                    C4990ab.m7412e("MicroMsg.Welabparser", e.getMessage());
                                }
                            }
                        }
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(80556);
                return c23169a;
            }
        }
    }

    /* renamed from: a */
    private static String m69204a(HashMap<String, String> hashMap, String str) {
        AppMethodBeat.m2504i(80557);
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
                    AppMethodBeat.m2505o(80557);
                    return str2;
                }
            }
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(80557);
        return str2;
    }

    public static List<String> agL(String str) {
        AppMethodBeat.m2504i(80558);
        if (TextUtils.isEmpty(str)) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.m2505o(80558);
            return list;
        }
        List<String> asList = Arrays.asList(str.split(";"));
        AppMethodBeat.m2505o(80558);
        return asList;
    }

    /* renamed from: pd */
    private static Element m69206pd(String str) {
        AppMethodBeat.m2504i(80559);
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
            AppMethodBeat.m2505o(80559);
            return documentElement;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.Welabparser", e.toString());
            AppMethodBeat.m2505o(80559);
            return null;
        }
    }

    /* renamed from: a */
    public static C23169a m69203a(C14716c c14716c) {
        AppMethodBeat.m2504i(80560);
        C23169a c23169a = new C23169a();
        c23169a.field_expId = String.valueOf(c14716c.uMa);
        c23169a.field_sequence = (long) c14716c.uMb;
        c23169a.field_starttime = c14716c.startTime > 0 ? c14716c.startTime : System.currentTimeMillis() / 1000;
        c23169a.field_endtime = c14716c.endTime > 0 ? c14716c.endTime : Long.MAX_VALUE;
        String str = "xlab_" + c14716c.uMa;
        HashMap hashMap = c14716c.cag;
        c23169a.field_AllVer = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "AllVer")));
        c23169a.field_BizType = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "BizType")));
        c23169a.field_Desc_cn = (String) hashMap.get(C40363f.m69205ep(str, "Desc_cn"));
        c23169a.field_Desc_en = (String) hashMap.get(C40363f.m69205ep(str, "Desc_en"));
        c23169a.field_Desc_hk = (String) hashMap.get(C40363f.m69205ep(str, "Desc_hk"));
        c23169a.field_Desc_tw = (String) hashMap.get(C40363f.m69205ep(str, "Desc_tw"));
        c23169a.field_DetailURL = (String) hashMap.get(C40363f.m69205ep(str, "DetailURL"));
        c23169a.field_Introduce_cn = (String) hashMap.get(C40363f.m69205ep(str, "Introduce_cn"));
        c23169a.field_Introduce_en = (String) hashMap.get(C40363f.m69205ep(str, "Introduce_en"));
        c23169a.field_Introduce_hk = (String) hashMap.get(C40363f.m69205ep(str, "Introduce_hk"));
        c23169a.field_Introduce_tw = (String) hashMap.get(C40363f.m69205ep(str, "Introduce_tw"));
        c23169a.field_Pos = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "Pos")));
        c23169a.field_Type = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "Type")));
        c23169a.field_Switch = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "Switch")));
        c23169a.field_WeAppPath = (String) hashMap.get(C40363f.m69205ep(str, "WeAppPath"));
        c23169a.field_WeAppUser = (String) hashMap.get(C40363f.m69205ep(str, "WeAppUser"));
        c23169a.field_LabsAppId = (String) hashMap.get(C40363f.m69205ep(str, "LabsAppId"));
        c23169a.field_TitleKey_android = (String) hashMap.get(C40363f.m69205ep(str, "TitleKey_android"));
        c23169a.field_Title_cn = (String) hashMap.get(C40363f.m69205ep(str, "Title_cn"));
        c23169a.field_Title_en = (String) hashMap.get(C40363f.m69205ep(str, "Title_en"));
        c23169a.field_Title_hk = (String) hashMap.get(C40363f.m69205ep(str, "Title_hk"));
        c23169a.field_Title_tw = (String) hashMap.get(C40363f.m69205ep(str, "Title_tw"));
        c23169a.field_ThumbUrl_cn = (String) hashMap.get(C40363f.m69205ep(str, "ThumbUrl_cn"));
        c23169a.field_ThumbUrl_en = (String) hashMap.get(C40363f.m69205ep(str, "ThumbUrl_en"));
        c23169a.field_ThumbUrl_hk = (String) hashMap.get(C40363f.m69205ep(str, "ThumbUrl_hk"));
        c23169a.field_ThumbUrl_tw = (String) hashMap.get(C40363f.m69205ep(str, "ThumbUrl_tw"));
        c23169a.field_ImgUrl_android_cn = C40363f.m69204a(hashMap, C40363f.m69205ep(str, "ImgUrl_android_cn")).replace(',', ';');
        c23169a.field_ImgUrl_android_tw = C40363f.m69204a(hashMap, C40363f.m69205ep(str, "ImgUrl_android_tw")).replace(',', ';');
        c23169a.field_ImgUrl_android_en = C40363f.m69204a(hashMap, C40363f.m69205ep(str, "ImgUrl_android_en")).replace(',', ';');
        c23169a.field_ImgUrl_android_hk = C40363f.m69204a(hashMap, C40363f.m69205ep(str, "ImgUrl_android_hk")).replace(',', ';');
        if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_cn)) {
            c23169a.field_ImgUrl_android_cn = (String) hashMap.get(C40363f.m69205ep(str, "ImgUrl_cn"));
        }
        if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_en)) {
            c23169a.field_ImgUrl_android_en = (String) hashMap.get(C40363f.m69205ep(str, "ImgUrl_en"));
        }
        if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_hk)) {
            c23169a.field_ImgUrl_android_hk = (String) hashMap.get(C40363f.m69205ep(str, "ImgUrl_hk"));
        }
        if (TextUtils.isEmpty(c23169a.field_ImgUrl_android_tw)) {
            c23169a.field_ImgUrl_android_tw = (String) hashMap.get(C40363f.m69205ep(str, "ImgUrl_tw"));
        }
        c23169a.field_RedPoint = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "RedPoint")));
        c23169a.field_WeAppDebugMode = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "WeAppDebugMode")));
        c23169a.field_TitleKey_android = (String) hashMap.get(C40363f.m69205ep(str, "TitleKey_android"));
        c23169a.field_Icon = (String) hashMap.get(C40363f.m69205ep(str, "Icon"));
        c23169a.field_bItemFromXExpt = 1;
        c23169a.field_status = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "status")));
        c23169a.field_idkey = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "idkey")));
        c23169a.field_idkeyValue = C5046bo.ank((String) hashMap.get(C40363f.m69205ep(str, "idkeyValue")));
        AppMethodBeat.m2505o(80560);
        return c23169a;
    }

    /* renamed from: ep */
    private static String m69205ep(String str, String str2) {
        AppMethodBeat.m2504i(80561);
        String toLowerCase = (str + "_" + str2).toLowerCase();
        AppMethodBeat.m2505o(80561);
        return toLowerCase;
    }
}
