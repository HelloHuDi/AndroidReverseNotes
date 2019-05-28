package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.ba.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class cd implements e {
    public final b b(a aVar) {
        AppMethodBeat.i(77826);
        cm cmVar = aVar.eAB;
        if (cmVar == null || cmVar.vED == null) {
            ab.f("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension failed, invalid cmdAM");
            AppMethodBeat.o(77826);
        } else {
            ab.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension start");
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(aa.a(cmVar.vED).getBytes(ProtocolPackage.ServerEncoding))));
                parse.normalize();
                NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("updatepackage");
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
                                    g.RO().eJo.a(new k(bo.getInt(item.getNodeValue(), 0)), 0);
                                }
                            }
                        }
                    }
                }
                ab.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension end");
                AppMethodBeat.o(77826);
            } catch (Exception e) {
                ab.e("MicroMsg.UpdatePackageMsgExtension", "exception:%s", bo.l(e));
                AppMethodBeat.o(77826);
            }
        }
        return null;
    }

    public final void a(c cVar) {
    }
}
