package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class j {
    private static final String TAG = TAG;
    private static final String ixP = ixP;
    public static final a ixQ = new a();
    private static final ArrayList<PhoneItem> ixy = new ArrayList();

    @l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0010J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0010J\"\u0010\u0013\u001a\u00020\r2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bJ\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u0017\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager$Companion;", "", "()V", "PHONE_ITEMS", "", "getPHONE_ITEMS", "()Ljava/lang/String;", "TAG", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "add", "", "phoneItem", "get", "", "init", "newPhoneItems", "remove", "delPhoneItems", "uninit", "updatePhoneItem", "update", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final synchronized void aM(List<PhoneItem> list) {
            Object obj;
            AppMethodBeat.i(134807);
            a.f.b.j.p(list, "newPhoneItems");
            j.ixy.clear();
            j.ixy.addAll(list);
            for (PhoneItem phoneItem : aKO()) {
                if (phoneItem.ixN) {
                    Iterator it = j.ixy.iterator();
                    while (it.hasNext()) {
                        PhoneItem phoneItem2 = (PhoneItem) it.next();
                        if (a.f.b.j.j(phoneItem.cFl, phoneItem2.cFl)) {
                            phoneItem2.ixN = true;
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null && j.ixy.size() > 0) {
                        ((PhoneItem) j.ixy.get(0)).ixN = true;
                    }
                    d.v(j.TAG, "init oldphoneItems:%s", r4);
                    d.v(j.TAG, "init phoneItems:%s", j.ixy);
                    AppMethodBeat.o(134807);
                }
            }
            obj = null;
            ((PhoneItem) j.ixy.get(0)).ixN = true;
            d.v(j.TAG, "init oldphoneItems:%s", r4);
            d.v(j.TAG, "init phoneItems:%s", j.ixy);
            AppMethodBeat.o(134807);
        }

        public final synchronized List<PhoneItem> aKN() {
            List aKM;
            AppMethodBeat.i(134808);
            aKM = j.ixy;
            AppMethodBeat.o(134808);
            return aKM;
        }

        public final synchronized void o(ArrayList<PhoneItem> arrayList) {
            AppMethodBeat.i(134809);
            if (arrayList == null) {
                d.w(j.TAG, "delPhoneItems is null");
                AppMethodBeat.o(134809);
            } else {
                Object obj;
                ArrayList arrayList2 = new ArrayList(j.ixy);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.remove((PhoneItem) it.next());
                }
                j.ixy.clear();
                j.ixy.addAll(arrayList2);
                Iterator it2 = j.ixy.iterator();
                while (it2.hasNext()) {
                    if (((PhoneItem) it2.next()).ixN) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null && j.ixy.size() > 0) {
                    ((PhoneItem) j.ixy.get(0)).ixN = true;
                }
                d.v(j.TAG, "remove phoneItems:%s", j.ixy);
                AppMethodBeat.o(134809);
            }
        }

        public final synchronized void a(PhoneItem phoneItem) {
            AppMethodBeat.i(134810);
            a.f.b.j.p(phoneItem, "phoneItem");
            Iterator it = j.ixy.iterator();
            while (it.hasNext()) {
                ((PhoneItem) it.next()).ixN = false;
            }
            if (j.ixy.contains(phoneItem)) {
                j.ixy.set(j.ixy.indexOf(phoneItem), phoneItem);
                AppMethodBeat.o(134810);
            } else {
                j.ixy.add(phoneItem);
                AppMethodBeat.o(134810);
            }
        }

        public final synchronized void b(PhoneItem phoneItem) {
            PhoneItem phoneItem2;
            AppMethodBeat.i(134811);
            if (phoneItem != null) {
                Iterator it = j.ixy.iterator();
                while (it.hasNext()) {
                    ((PhoneItem) it.next()).ixN = false;
                }
                it = j.ixy.iterator();
                while (it.hasNext()) {
                    phoneItem2 = (PhoneItem) it.next();
                    if (a.f.b.j.j(phoneItem.cFl, phoneItem2.cFl)) {
                        phoneItem2.ixN = true;
                    }
                }
            }
            List<PhoneItem> aKM = j.ixy;
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
                a.f.b.j.o(jSONObject2, "jsonObject.toString()");
                jSONArray.put(jSONObject2);
            }
            d.d(j.TAG, "update %s", jSONArray.toString());
            f.xH().bG(j.ixP, jSONArray.toString());
            d.v(j.TAG, "uninit phoneItems:%s", j.ixy);
            j.ixy.clear();
            AppMethodBeat.o(134811);
        }

        private static List<PhoneItem> aKO() {
            JSONArray jSONArray;
            AppMethodBeat.i(134812);
            try {
                jSONArray = new JSONArray(f.xH().get(j.ixP, ""));
            } catch (Exception e) {
                jSONArray = null;
            }
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                int length = jSONArray.length() - 1;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem.a aVar = PhoneItem.ixO;
                        String string = jSONArray.getString(i);
                        a.f.b.j.o(string, "jsonArray.getString(i)");
                        PhoneItem Ds = com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem.a.Ds(string);
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
            d.d(j.TAG, "get %s", String.valueOf(jSONArray));
            List list = arrayList;
            AppMethodBeat.o(134812);
            return list;
        }
    }

    static {
        AppMethodBeat.i(134813);
        AppMethodBeat.o(134813);
    }
}
