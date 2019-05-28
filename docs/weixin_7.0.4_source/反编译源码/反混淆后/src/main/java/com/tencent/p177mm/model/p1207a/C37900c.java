package com.tencent.p177mm.model.p1207a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* renamed from: com.tencent.mm.model.a.c */
public final class C37900c {
    C45435b fnW = null;
    C45435b fnX = null;

    /* Access modifiers changed, original: final */
    /* renamed from: oQ */
    public final void mo60655oQ(String str) {
        AppMethodBeat.m2504i(118142);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.abtest.AbTestManager", "[Abtest] parse xml faild. xml is null.");
            AppMethodBeat.m2505o(118142);
            return;
        }
        C4990ab.m7417i("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML content:%s", str);
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("testcase");
            if (elementsByTagName != null) {
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    C45435b c45435b = new C45435b();
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i2 = 0; i2 < length; i2++) {
                        Node item = childNodes.item(i2);
                        if (item != null && item.getNodeName() != null && item.getNodeName().equals("testpoint")) {
                            NamedNodeMap attributes = item.getAttributes();
                            C42183e c42183e = new C42183e();
                            if (attributes != null) {
                                Node namedItem = attributes.getNamedItem("id");
                                if (namedItem != null) {
                                    C4990ab.m7411d("MicroMsg.abtest.AbTestManager", "[Abtest] idValue:%s", namedItem.getNodeValue());
                                    c42183e.f17167id = r9;
                                }
                                Node namedItem2 = attributes.getNamedItem("reportid");
                                if (namedItem2 != null) {
                                    C4990ab.m7411d("MicroMsg.abtest.AbTestManager", "[Abtest] reportIdValue:%s", namedItem2.getNodeValue());
                                    c42183e.fnY = r7;
                                }
                            }
                            C4990ab.m7411d("MicroMsg.abtest.AbTestManager", "[Abtest] casePointContent:%s", item.getTextContent());
                            c42183e.value = r6;
                            c45435b.fnV.put(c42183e.f17167id, c42183e);
                        } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("verifymd5")) {
                            if (item != null) {
                                if (item.getNodeName() != null && item.getNodeName().equals("testcaseid")) {
                                    C4990ab.m7411d("MicroMsg.abtest.AbTestManager", "[Abtest] testcaseidContent:%s", item.getTextContent());
                                    c45435b.fnS = r6;
                                }
                            }
                            if (item != null && item.getNodeName() != null && item.getNodeName().equals("starttime")) {
                                C4990ab.m7411d("MicroMsg.abtest.AbTestManager", "[Abtest] starttimeContent:%s", item.getTextContent());
                                c45435b.fnT = r6;
                            } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("endtime"))) {
                                C4990ab.m7411d("MicroMsg.abtest.AbTestManager", "[Abtest] endtimeContent:%s", item.getTextContent());
                                c45435b.fnU = r6;
                            }
                        } else {
                            C4990ab.m7411d("MicroMsg.abtest.AbTestManager", "[Abtest] verifymd5Content:%s", item.getTextContent());
                            c45435b.eyp = r6;
                        }
                    }
                    if (C5046bo.isNullOrNil(c45435b.fnS) || !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(c45435b.fnS)) {
                        this.fnW = c45435b;
                    } else {
                        this.fnX = c45435b;
                    }
                }
            }
            AppMethodBeat.m2505o(118142);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML exception:%s", e.toString());
            AppMethodBeat.m2505o(118142);
        }
    }

    public final boolean aaI() {
        if (this.fnW == null) {
            return false;
        }
        return true;
    }

    /* renamed from: oP */
    public final C42183e mo60654oP(String str) {
        AppMethodBeat.m2504i(118143);
        C42183e c42183e = null;
        if (this.fnW != null) {
            c42183e = this.fnW.mo73237oP(str);
        }
        if (c42183e == null && this.fnX != null) {
            c42183e = this.fnX.mo73237oP(str);
        }
        AppMethodBeat.m2505o(118143);
        return c42183e;
    }
}
