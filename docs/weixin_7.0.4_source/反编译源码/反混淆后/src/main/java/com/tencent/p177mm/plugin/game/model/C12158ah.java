package com.tencent.p177mm.plugin.game.model;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C28229n.C28231e;
import com.tencent.p177mm.plugin.game.model.C28229n.C28233i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.tencent.mm.plugin.game.model.ah */
public final class C12158ah {
    /* renamed from: X */
    private static String m20092X(LinkedList<C28233i> linkedList) {
        AppMethodBeat.m2504i(111406);
        String str;
        if (C5046bo.m7548ek(linkedList)) {
            str = "";
            AppMethodBeat.m2505o(111406);
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C28233i c28233i = (C28233i) it.next();
                newSerializer.startTag(null, "userinfo");
                newSerializer.attribute(null, "jump_id", c28233i.mXx);
                newSerializer.startTag(null, "username");
                try {
                    newSerializer.text(C5046bo.m7532bc(c28233i.userName, ""));
                } catch (Exception e) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "username");
                newSerializer.startTag(null, "nickname");
                try {
                    newSerializer.text(C5046bo.m7532bc(c28233i.bCu, ""));
                } catch (Exception e2) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "nickname");
                newSerializer.startTag(null, "usericon");
                try {
                    newSerializer.text(C5046bo.m7532bc(c28233i.mXu, ""));
                } catch (Exception e3) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "usericon");
                newSerializer.startTag(null, Scopes.PROFILE);
                try {
                    newSerializer.text(C5046bo.m7532bc(c28233i.mXv, ""));
                } catch (Exception e4) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, Scopes.PROFILE);
                newSerializer.startTag(null, "badge_icon");
                try {
                    newSerializer.text(C5046bo.m7532bc(c28233i.mXw, ""));
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
            AppMethodBeat.m2505o(111406);
            return str;
        } catch (Exception e6) {
            C4990ab.m7412e("MicroMsg.GameXmlProcess", e6.getMessage());
            str = "";
            AppMethodBeat.m2505o(111406);
            return str;
        }
    }

    /* renamed from: a */
    private static String m20094a(LinkedList<C28233i> linkedList, HashMap<String, C28231e> hashMap) {
        AppMethodBeat.m2504i(111407);
        String str;
        if (C5046bo.m7548ek(linkedList) || hashMap.isEmpty()) {
            str = "";
            AppMethodBeat.m2505o(111407);
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C28233i c28233i = (C28233i) it.next();
                C28231e c28231e = (C28231e) hashMap.get(c28233i.mXx);
                if (c28231e != null) {
                    newSerializer.startTag(null, "jump");
                    newSerializer.attribute(null, "id", c28233i.mXx);
                    newSerializer.startTag(null, "jump_type");
                    try {
                        newSerializer.text(String.valueOf(c28231e.mXo));
                    } catch (Exception e) {
                        newSerializer.text("");
                    }
                    newSerializer.endTag(null, "jump_type");
                    newSerializer.startTag(null, "jump_url");
                    try {
                        newSerializer.text(C5046bo.m7532bc(c28231e.lAF, ""));
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
            AppMethodBeat.m2505o(111407);
            return str;
        } catch (Exception e3) {
            C4990ab.m7412e("MicroMsg.GameXmlProcess", e3.getMessage());
            str = "";
            AppMethodBeat.m2505o(111407);
            return str;
        }
    }

    /* renamed from: a */
    public static String m20093a(String str, LinkedList<C28233i> linkedList, HashMap<String, C28231e> hashMap) {
        AppMethodBeat.m2504i(111408);
        if (C5046bo.isNullOrNil(str) || C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(111408);
            return str;
        }
        String X = C12158ah.m20092X(linkedList);
        if (C5046bo.isNullOrNil(X)) {
            AppMethodBeat.m2505o(111408);
            return str;
        }
        String a = C12158ah.m20094a(linkedList, hashMap);
        StringBuilder stringBuilder = new StringBuilder(str);
        try {
            if (stringBuilder.indexOf("<userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.indexOf("<userinfo>"), "<usercount>" + linkedList.size() + 1 + "</usercount>");
            }
            if (stringBuilder.lastIndexOf("</userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</userinfo>") + 11, X);
            }
            if (!(stringBuilder.lastIndexOf("</jump>") == -1 || C5046bo.isNullOrNil(a))) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</jump>") + 7, a);
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.GameXmlProcess", e.getMessage());
            C4990ab.m7412e("MicroMsg.GameXmlProcess", "xml is invalid : ".concat(String.valueOf(str)));
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(111408);
        return str;
    }
}
