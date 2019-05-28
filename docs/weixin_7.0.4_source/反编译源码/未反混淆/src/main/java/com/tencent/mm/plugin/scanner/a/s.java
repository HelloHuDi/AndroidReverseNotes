package com.tencent.mm.plugin.scanner.a;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.a.r.a;
import com.tencent.mm.plugin.scanner.a.r.b;
import com.tencent.mm.plugin.scanner.a.r.c;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class s {
    private r qaD = new r();

    public s() {
        AppMethodBeat.i(80890);
        AppMethodBeat.o(80890);
    }

    public final void We(String str) {
        AppMethodBeat.i(80891);
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 1:
                    r.qaD = this.qaD;
                    break;
                case 2:
                    str2 = newPullParser.getName();
                    if (!str2.equals("name")) {
                        if (!str2.equals("address")) {
                            if (!str2.equals("deliveryAddress")) {
                                if (!str2.equals("homeAddress")) {
                                    if (!str2.equals("workAddress")) {
                                        if (!str2.equals("photo")) {
                                            if (!str2.equals("logo")) {
                                                if (!str2.equals("sound")) {
                                                    break;
                                                }
                                                this.qaD.qap = h(newPullParser);
                                                break;
                                            }
                                            this.qaD.qao = h(newPullParser);
                                            break;
                                        }
                                        this.qaD.qan = h(newPullParser);
                                        break;
                                    }
                                    this.qaD.qau = g(newPullParser);
                                    break;
                                }
                                this.qaD.qat = g(newPullParser);
                                break;
                            }
                            this.qaD.qas = g(newPullParser);
                            break;
                        }
                        this.qaD.qar = g(newPullParser);
                        break;
                    }
                    this.qaD.qam = new b(newPullParser.getAttributeValue(null, "firstName"), newPullParser.getAttributeValue(null, "middleName"), newPullParser.getAttributeValue(null, "lastName"));
                    break;
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        text = text.trim();
                        if (!str2.equals("nickName")) {
                            if (!str2.equals("photoUrl")) {
                                if (!str2.equals("birthday")) {
                                    r rVar;
                                    if (!str2.equals("mobilePhoneNumber")) {
                                        if (!str2.equals("homePhoneNumber")) {
                                            if (!str2.equals("workPhoneNumber")) {
                                                if (!str2.equals("telAVPhoneNumber")) {
                                                    if (!str2.equals("phoneNumber")) {
                                                        if (!str2.equals(Scopes.EMAIL)) {
                                                            if (!str2.equals("title")) {
                                                                if (!str2.equals("role")) {
                                                                    if (!str2.equals("agent")) {
                                                                        if (!str2.equals("note")) {
                                                                            if (!str2.equals("url")) {
                                                                                if (!str2.equals("organization")) {
                                                                                    break;
                                                                                }
                                                                                this.qaD.hHW = text;
                                                                                break;
                                                                            }
                                                                            this.qaD.url = text;
                                                                            break;
                                                                        }
                                                                        this.qaD.qaC = text;
                                                                        break;
                                                                    }
                                                                    this.qaD.qaB = text;
                                                                    break;
                                                                }
                                                                this.qaD.qaA = text;
                                                                break;
                                                            }
                                                            this.qaD.title = text;
                                                            break;
                                                        }
                                                        this.qaD.dtV = text;
                                                        break;
                                                    }
                                                    rVar = this.qaD;
                                                    if (rVar.qaz == null) {
                                                        rVar.qaz = new ArrayList();
                                                    }
                                                    if (!(text == null || rVar.qaz.contains(text))) {
                                                        rVar.qaz.add(text);
                                                        break;
                                                    }
                                                }
                                                rVar = this.qaD;
                                                if (rVar.qay == null) {
                                                    rVar.qay = new ArrayList();
                                                }
                                                if (!(text == null || rVar.qay.contains(text))) {
                                                    rVar.qay.add(text);
                                                    break;
                                                }
                                            }
                                            rVar = this.qaD;
                                            if (rVar.qax == null) {
                                                rVar.qax = new ArrayList();
                                            }
                                            if (!(text == null || rVar.qax.contains(text))) {
                                                rVar.qax.add(text);
                                                break;
                                            }
                                        }
                                        rVar = this.qaD;
                                        if (rVar.qaw == null) {
                                            rVar.qaw = new ArrayList();
                                        }
                                        if (!(text == null || rVar.qaw.contains(text))) {
                                            rVar.qaw.add(text);
                                            break;
                                        }
                                    }
                                    rVar = this.qaD;
                                    if (rVar.qav == null) {
                                        rVar.qav = new ArrayList();
                                    }
                                    if (!(text == null || rVar.qav.contains(text))) {
                                        rVar.qav.add(text);
                                        break;
                                    }
                                }
                                this.qaD.qaq = text;
                                break;
                            }
                            this.qaD.hHN = text;
                            break;
                        }
                        this.qaD.bCu = text;
                        break;
                    }
                default:
                    break;
            }
        }
        r.qaD = this.qaD;
        AppMethodBeat.o(80891);
    }

    private static a g(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(80892);
        a aVar = new a(xmlPullParser.getAttributeValue(null, "postOfficeBox"), xmlPullParser.getAttributeValue(null, "extendedAddress"), xmlPullParser.getAttributeValue(null, "street"), xmlPullParser.getAttributeValue(null, TencentExtraKeys.LOCATION_KEY_LOCALITY), xmlPullParser.getAttributeValue(null, "region"), xmlPullParser.getAttributeValue(null, "postalCode"), xmlPullParser.getAttributeValue(null, UserDataStore.COUNTRY));
        AppMethodBeat.o(80892);
        return aVar;
    }

    private static c h(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(80893);
        c cVar = new c(xmlPullParser.getAttributeValue(null, "type"), xmlPullParser.getAttributeValue(null, "buffer"));
        AppMethodBeat.o(80893);
        return cVar;
    }
}
