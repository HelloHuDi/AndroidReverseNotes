package com.tencent.p177mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.phonenumber.PhoneItem.C33496a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.j */
public final class C45670j {
    private static final String TAG = TAG;
    private static final String ixP = ixP;
    public static final C45669a ixQ = new C45669a();
    private static final ArrayList<PhoneItem> ixy = new ArrayList();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0010J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0010J\"\u0010\u0013\u001a\u00020\r2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bJ\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u0017\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager$Companion;", "", "()V", "PHONE_ITEMS", "", "getPHONE_ITEMS", "()Ljava/lang/String;", "TAG", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "add", "", "phoneItem", "get", "", "init", "newPhoneItems", "remove", "delPhoneItems", "uninit", "updatePhoneItem", "update", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.j$a */
    public static final class C45669a {
        private C45669a() {
        }

        public /* synthetic */ C45669a(byte b) {
            this();
        }

        /* renamed from: aM */
        public final synchronized void mo73461aM(List<PhoneItem> list) {
            Object obj;
            AppMethodBeat.m2504i(134807);
            C25052j.m39376p(list, "newPhoneItems");
            C45670j.ixy.clear();
            C45670j.ixy.addAll(list);
            for (PhoneItem phoneItem : C45669a.aKO()) {
                if (phoneItem.ixN) {
                    Iterator it = C45670j.ixy.iterator();
                    while (it.hasNext()) {
                        PhoneItem phoneItem2 = (PhoneItem) it.next();
                        if (C25052j.m39373j(phoneItem.cFl, phoneItem2.cFl)) {
                            phoneItem2.ixN = true;
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null && C45670j.ixy.size() > 0) {
                        ((PhoneItem) C45670j.ixy.get(0)).ixN = true;
                    }
                    C45124d.m82932v(C45670j.TAG, "init oldphoneItems:%s", r4);
                    C45124d.m82932v(C45670j.TAG, "init phoneItems:%s", C45670j.ixy);
                    AppMethodBeat.m2505o(134807);
                }
            }
            obj = null;
            ((PhoneItem) C45670j.ixy.get(0)).ixN = true;
            C45124d.m82932v(C45670j.TAG, "init oldphoneItems:%s", r4);
            C45124d.m82932v(C45670j.TAG, "init phoneItems:%s", C45670j.ixy);
            AppMethodBeat.m2505o(134807);
        }

        public final synchronized List<PhoneItem> aKN() {
            List aKM;
            AppMethodBeat.m2504i(134808);
            aKM = C45670j.ixy;
            AppMethodBeat.m2505o(134808);
            return aKM;
        }

        /* renamed from: o */
        public final synchronized void mo73463o(ArrayList<PhoneItem> arrayList) {
            AppMethodBeat.m2504i(134809);
            if (arrayList == null) {
                C45124d.m82933w(C45670j.TAG, "delPhoneItems is null");
                AppMethodBeat.m2505o(134809);
            } else {
                Object obj;
                ArrayList arrayList2 = new ArrayList(C45670j.ixy);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.remove((PhoneItem) it.next());
                }
                C45670j.ixy.clear();
                C45670j.ixy.addAll(arrayList2);
                Iterator it2 = C45670j.ixy.iterator();
                while (it2.hasNext()) {
                    if (((PhoneItem) it2.next()).ixN) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null && C45670j.ixy.size() > 0) {
                    ((PhoneItem) C45670j.ixy.get(0)).ixN = true;
                }
                C45124d.m82932v(C45670j.TAG, "remove phoneItems:%s", C45670j.ixy);
                AppMethodBeat.m2505o(134809);
            }
        }

        /* renamed from: a */
        public final synchronized void mo73459a(PhoneItem phoneItem) {
            AppMethodBeat.m2504i(134810);
            C25052j.m39376p(phoneItem, "phoneItem");
            Iterator it = C45670j.ixy.iterator();
            while (it.hasNext()) {
                ((PhoneItem) it.next()).ixN = false;
            }
            if (C45670j.ixy.contains(phoneItem)) {
                C45670j.ixy.set(C45670j.ixy.indexOf(phoneItem), phoneItem);
                AppMethodBeat.m2505o(134810);
            } else {
                C45670j.ixy.add(phoneItem);
                AppMethodBeat.m2505o(134810);
            }
        }

        /* renamed from: b */
        public final synchronized void mo73462b(PhoneItem phoneItem) {
            PhoneItem phoneItem2;
            AppMethodBeat.m2504i(134811);
            if (phoneItem != null) {
                Iterator it = C45670j.ixy.iterator();
                while (it.hasNext()) {
                    ((PhoneItem) it.next()).ixN = false;
                }
                it = C45670j.ixy.iterator();
                while (it.hasNext()) {
                    phoneItem2 = (PhoneItem) it.next();
                    if (C25052j.m39373j(phoneItem.cFl, phoneItem2.cFl)) {
                        phoneItem2.ixN = true;
                    }
                }
            }
            List<PhoneItem> aKM = C45670j.ixy;
            JSONArray jSONArray = new JSONArray();
            for (PhoneItem phoneItem22 : aKM) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mobile", phoneItem22.cFl);
                jSONObject.put("show_mobile", phoneItem22.ixI);
                jSONObject.put("need_auth", phoneItem22.ixK);
                jSONObject.put("allow_send_sms", phoneItem22.ixL);
                jSONObject.put("encryptedData", phoneItem22.ixJ);
                jSONObject.put("iv", phoneItem22.biC);
                jSONObject.put("is_wechat", phoneItem22.ixM);
                jSONObject.put("is_check", phoneItem22.ixN);
                String jSONObject2 = jSONObject.toString();
                C25052j.m39375o(jSONObject2, "jsonObject.toString()");
                jSONArray.put(jSONObject2);
            }
            C45124d.m82926d(C45670j.TAG, "update %s", jSONArray.toString());
            C42340f.m74880xH().mo53682bG(C45670j.ixP, jSONArray.toString());
            C45124d.m82932v(C45670j.TAG, "uninit phoneItems:%s", C45670j.ixy);
            C45670j.ixy.clear();
            AppMethodBeat.m2505o(134811);
        }

        private static List<PhoneItem> aKO() {
            JSONArray jSONArray;
            AppMethodBeat.m2504i(134812);
            try {
                jSONArray = new JSONArray(C42340f.m74880xH().get(C45670j.ixP, ""));
            } catch (Exception e) {
                jSONArray = null;
            }
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                int length = jSONArray.length() - 1;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        C33496a c33496a = PhoneItem.ixO;
                        String string = jSONArray.getString(i);
                        C25052j.m39375o(string, "jsonArray.getString(i)");
                        PhoneItem Ds = C33496a.m54716Ds(string);
                        if (Ds != null) {
                            arrayList.add(Ds);
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                    }
                }
            }
            C45124d.m82926d(C45670j.TAG, "get %s", String.valueOf(jSONArray));
            List list = arrayList;
            AppMethodBeat.m2505o(134812);
            return list;
        }
    }

    static {
        AppMethodBeat.m2504i(134813);
        AppMethodBeat.m2505o(134813);
    }
}
