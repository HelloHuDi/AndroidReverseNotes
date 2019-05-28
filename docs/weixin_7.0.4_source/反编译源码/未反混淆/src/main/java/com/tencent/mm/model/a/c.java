package com.tencent.mm.model.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class c {
    b fnW = null;
    b fnX = null;

    /* Access modifiers changed, original: final */
    public final void oQ(String str) {
        AppMethodBeat.i(118142);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.abtest.AbTestManager", "[Abtest] parse xml faild. xml is null.");
            AppMethodBeat.o(118142);
            return;
        }
        ab.i("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML content:%s", str);
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("testcase");
            if (elementsByTagName != null) {
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    b bVar = new b();
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i2 = 0; i2 < length; i2++) {
                        Node item = childNodes.item(i2);
                        if (item != null && item.getNodeName() != null && item.getNodeName().equals("testpoint")) {
                            NamedNodeMap attributes = item.getAttributes();
                            e eVar = new e();
                            if (attributes != null) {
                                Node namedItem = attributes.getNamedItem("id");
                                if (namedItem != null) {
                                    ab.d("MicroMsg.abtest.AbTestManager", "[Abtest] idValue:%s", namedItem.getNodeValue());
                                    eVar.id = r9;
                                }
                                Node namedItem2 = attributes.getNamedItem("reportid");
                                if (namedItem2 != null) {
                                    ab.d("MicroMsg.abtest.AbTestManager", "[Abtest] reportIdValue:%s", namedItem2.getNodeValue());
                                    eVar.fnY = r7;
                                }
                            }
                            ab.d("MicroMsg.abtest.AbTestManager", "[Abtest] casePointContent:%s", item.getTextContent());
                            eVar.value = r6;
                            bVar.fnV.put(eVar.id, eVar);
                        } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("verifymd5")) {
                            if (item != null) {
                                if (item.getNodeName() != null && item.getNodeName().equals("testcaseid")) {
                                    ab.d("MicroMsg.abtest.AbTestManager", "[Abtest] testcaseidContent:%s", item.getTextContent());
                                    bVar.fnS = r6;
                                }
                            }
                            if (item != null && item.getNodeName() != null && item.getNodeName().equals("starttime")) {
                                ab.d("MicroMsg.abtest.AbTestManager", "[Abtest] starttimeContent:%s", item.getTextContent());
                                bVar.fnT = r6;
                            } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("endtime"))) {
                                ab.d("MicroMsg.abtest.AbTestManager", "[Abtest] endtimeContent:%s", item.getTextContent());
                                bVar.fnU = r6;
                            }
                        } else {
                            ab.d("MicroMsg.abtest.AbTestManager", "[Abtest] verifymd5Content:%s", item.getTextContent());
                            bVar.eyp = r6;
                        }
                    }
                    if (bo.isNullOrNil(bVar.fnS) || !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(bVar.fnS)) {
                        this.fnW = bVar;
                    } else {
                        this.fnX = bVar;
                    }
                }
            }
            AppMethodBeat.o(118142);
        } catch (Exception e) {
            ab.e("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML exception:%s", e.toString());
            AppMethodBeat.o(118142);
        }
    }

    public final boolean aaI() {
        if (this.fnW == null) {
            return false;
        }
        return true;
    }

    public final e oP(String str) {
        AppMethodBeat.i(118143);
        e eVar = null;
        if (this.fnW != null) {
            eVar = this.fnW.oP(str);
        }
        if (eVar == null && this.fnX != null) {
            eVar = this.fnX.oP(str);
        }
        AppMethodBeat.o(118143);
        return eVar;
    }
}
