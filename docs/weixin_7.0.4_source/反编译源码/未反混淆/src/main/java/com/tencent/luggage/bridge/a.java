package com.tencent.luggage.bridge;

import java.util.HashMap;
import org.json.JSONObject;

abstract class a {
    protected b bOe;
    protected JSONObject bOf;

    a() {
    }

    /* Access modifiers changed, original: final */
    public final b wJ() {
        return this.bOe;
    }

    /* Access modifiers changed, original: final */
    public final JSONObject wK() {
        return this.bOf;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.bOe.name());
        hashMap.put("data", this.bOf);
        return new JSONObject(hashMap).toString();
    }
}
