package com.tencent.p177mm.plugin.scanner.p740a;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.scanner.p740a.C39626r.C13118a;
import com.tencent.p177mm.plugin.scanner.p740a.C39626r.C28891b;
import com.tencent.p177mm.plugin.scanner.p740a.C39626r.C39625c;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.tencent.mm.plugin.scanner.a.s */
public final class C46182s {
    private C39626r qaD = new C39626r();

    public C46182s() {
        AppMethodBeat.m2504i(80890);
        AppMethodBeat.m2505o(80890);
    }

    /* renamed from: We */
    public final void mo74170We(String str) {
        AppMethodBeat.m2504i(80891);
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 1:
                    C39626r.qaD = this.qaD;
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
                                                this.qaD.qap = C46182s.m86324h(newPullParser);
                                                break;
                                            }
                                            this.qaD.qao = C46182s.m86324h(newPullParser);
                                            break;
                                        }
                                        this.qaD.qan = C46182s.m86324h(newPullParser);
                                        break;
                                    }
                                    this.qaD.qau = C46182s.m86323g(newPullParser);
                                    break;
                                }
                                this.qaD.qat = C46182s.m86323g(newPullParser);
                                break;
                            }
                            this.qaD.qas = C46182s.m86323g(newPullParser);
                            break;
                        }
                        this.qaD.qar = C46182s.m86323g(newPullParser);
                        break;
                    }
                    this.qaD.qam = new C28891b(newPullParser.getAttributeValue(null, "firstName"), newPullParser.getAttributeValue(null, "middleName"), newPullParser.getAttributeValue(null, "lastName"));
                    break;
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        text = text.trim();
                        if (!str2.equals("nickName")) {
                            if (!str2.equals("photoUrl")) {
                                if (!str2.equals("birthday")) {
                                    C39626r c39626r;
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
                                                    c39626r = this.qaD;
                                                    if (c39626r.qaz == null) {
                                                        c39626r.qaz = new ArrayList();
                                                    }
                                                    if (!(text == null || c39626r.qaz.contains(text))) {
                                                        c39626r.qaz.add(text);
                                                        break;
                                                    }
                                                }
                                                c39626r = this.qaD;
                                                if (c39626r.qay == null) {
                                                    c39626r.qay = new ArrayList();
                                                }
                                                if (!(text == null || c39626r.qay.contains(text))) {
                                                    c39626r.qay.add(text);
                                                    break;
                                                }
                                            }
                                            c39626r = this.qaD;
                                            if (c39626r.qax == null) {
                                                c39626r.qax = new ArrayList();
                                            }
                                            if (!(text == null || c39626r.qax.contains(text))) {
                                                c39626r.qax.add(text);
                                                break;
                                            }
                                        }
                                        c39626r = this.qaD;
                                        if (c39626r.qaw == null) {
                                            c39626r.qaw = new ArrayList();
                                        }
                                        if (!(text == null || c39626r.qaw.contains(text))) {
                                            c39626r.qaw.add(text);
                                            break;
                                        }
                                    }
                                    c39626r = this.qaD;
                                    if (c39626r.qav == null) {
                                        c39626r.qav = new ArrayList();
                                    }
                                    if (!(text == null || c39626r.qav.contains(text))) {
                                        c39626r.qav.add(text);
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
        C39626r.qaD = this.qaD;
        AppMethodBeat.m2505o(80891);
    }

    /* renamed from: g */
    private static C13118a m86323g(XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(80892);
        C13118a c13118a = new C13118a(xmlPullParser.getAttributeValue(null, "postOfficeBox"), xmlPullParser.getAttributeValue(null, "extendedAddress"), xmlPullParser.getAttributeValue(null, "street"), xmlPullParser.getAttributeValue(null, TencentExtraKeys.LOCATION_KEY_LOCALITY), xmlPullParser.getAttributeValue(null, "region"), xmlPullParser.getAttributeValue(null, "postalCode"), xmlPullParser.getAttributeValue(null, UserDataStore.COUNTRY));
        AppMethodBeat.m2505o(80892);
        return c13118a;
    }

    /* renamed from: h */
    private static C39625c m86324h(XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(80893);
        C39625c c39625c = new C39625c(xmlPullParser.getAttributeValue(null, "type"), xmlPullParser.getAttributeValue(null, "buffer"));
        AppMethodBeat.m2505o(80893);
        return c39625c;
    }
}
