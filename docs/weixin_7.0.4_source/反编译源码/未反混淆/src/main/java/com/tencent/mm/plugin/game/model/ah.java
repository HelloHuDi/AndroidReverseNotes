package com.tencent.mm.plugin.game.model;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.n.e;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class ah {
    private static String X(LinkedList<i> linkedList) {
        AppMethodBeat.i(111406);
        String str;
        if (bo.ek(linkedList)) {
            str = "";
            AppMethodBeat.o(111406);
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                newSerializer.startTag(null, "userinfo");
                newSerializer.attribute(null, "jump_id", iVar.mXx);
                newSerializer.startTag(null, "username");
                try {
                    newSerializer.text(bo.bc(iVar.userName, ""));
                } catch (Exception e) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "username");
                newSerializer.startTag(null, "nickname");
                try {
                    newSerializer.text(bo.bc(iVar.bCu, ""));
                } catch (Exception e2) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "nickname");
                newSerializer.startTag(null, "usericon");
                try {
                    newSerializer.text(bo.bc(iVar.mXu, ""));
                } catch (Exception e3) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "usericon");
                newSerializer.startTag(null, Scopes.PROFILE);
                try {
                    newSerializer.text(bo.bc(iVar.mXv, ""));
                } catch (Exception e4) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, Scopes.PROFILE);
                newSerializer.startTag(null, "badge_icon");
                try {
                    newSerializer.text(bo.bc(iVar.mXw, ""));
                } catch (Exception e5) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "badge_icon");
                newSerializer.endTag(null, "userinfo");
            }
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            str = stringWriter.getBuffer().toString();
            AppMethodBeat.o(111406);
            return str;
        } catch (Exception e6) {
            ab.e("MicroMsg.GameXmlProcess", e6.getMessage());
            str = "";
            AppMethodBeat.o(111406);
            return str;
        }
    }

    private static String a(LinkedList<i> linkedList, HashMap<String, e> hashMap) {
        AppMethodBeat.i(111407);
        String str;
        if (bo.ek(linkedList) || hashMap.isEmpty()) {
            str = "";
            AppMethodBeat.o(111407);
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                e eVar = (e) hashMap.get(iVar.mXx);
                if (eVar != null) {
                    newSerializer.startTag(null, "jump");
                    newSerializer.attribute(null, "id", iVar.mXx);
                    newSerializer.startTag(null, "jump_type");
                    try {
                        newSerializer.text(String.valueOf(eVar.mXo));
                    } catch (Exception e) {
                        newSerializer.text("");
                    }
                    newSerializer.endTag(null, "jump_type");
                    newSerializer.startTag(null, "jump_url");
                    try {
                        newSerializer.text(bo.bc(eVar.lAF, ""));
                    } catch (Exception e2) {
                        newSerializer.text("");
                    }
                    newSerializer.endTag(null, "jump_url");
                    newSerializer.endTag(null, "jump");
                }
            }
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            str = stringWriter.getBuffer().toString();
            AppMethodBeat.o(111407);
            return str;
        } catch (Exception e3) {
            ab.e("MicroMsg.GameXmlProcess", e3.getMessage());
            str = "";
            AppMethodBeat.o(111407);
            return str;
        }
    }

    public static String a(String str, LinkedList<i> linkedList, HashMap<String, e> hashMap) {
        AppMethodBeat.i(111408);
        if (bo.isNullOrNil(str) || bo.ek(linkedList)) {
            AppMethodBeat.o(111408);
            return str;
        }
        String X = X(linkedList);
        if (bo.isNullOrNil(X)) {
            AppMethodBeat.o(111408);
            return str;
        }
        String a = a(linkedList, hashMap);
        StringBuilder stringBuilder = new StringBuilder(str);
        try {
            if (stringBuilder.indexOf("<userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.indexOf("<userinfo>"), "<usercount>" + linkedList.size() + 1 + "</usercount>");
            }
            if (stringBuilder.lastIndexOf("</userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</userinfo>") + 11, X);
            }
            if (!(stringBuilder.lastIndexOf("</jump>") == -1 || bo.isNullOrNil(a))) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</jump>") + 7, a);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.GameXmlProcess", e.getMessage());
            ab.e("MicroMsg.GameXmlProcess", "xml is invalid : ".concat(String.valueOf(str)));
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(111408);
        return str;
    }
}
