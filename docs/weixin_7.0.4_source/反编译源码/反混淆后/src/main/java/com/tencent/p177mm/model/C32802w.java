package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p230g.p231a.C37699ci;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* renamed from: com.tencent.mm.model.w */
public final class C32802w implements C1201e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(77798);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null || c7254cm.vED == null) {
            C4990ab.m7414f("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension failed, invalid cmdAM");
            AppMethodBeat.m2505o(77798);
        } else {
            C4990ab.m7416i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension start");
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(C1946aa.m4148a(c7254cm.vED).getBytes(ProtocolPackage.ServerEncoding))));
                parse.normalize();
                NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("deletepackage");
                if (elementsByTagName != null && elementsByTagName.getLength() == 1) {
                    NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        Node item = childNodes.item(i);
                        if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("pack"))) {
                            NamedNodeMap attributes = item.getAttributes();
                            if (attributes != null) {
                                item = attributes.getNamedItem("type");
                                if (item != null) {
                                    int i2 = C5046bo.getInt(item.getNodeValue(), 0);
                                    C37699ci c37699ci = new C37699ci();
                                    c37699ci.cvy.cvz = i2;
                                    C4879a.xxA.mo10055m(c37699ci);
                                }
                            }
                        }
                    }
                }
                C4990ab.m7416i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension end");
                AppMethodBeat.m2505o(77798);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.DeletePackageMsgExtension", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(77798);
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
