package com.tencent.luggage.bridge;

import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.bridge.a */
abstract class C8856a {
    protected C8857b bOe;
    protected JSONObject bOf;

    C8856a() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wJ */
    public final C8857b mo20028wJ() {
        return this.bOe;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wK */
    public final JSONObject mo20029wK() {
        return this.bOf;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.bOe.name());
        hashMap.put("data", this.bOf);
        return new JSONObject(hashMap).toString();
    }
}
