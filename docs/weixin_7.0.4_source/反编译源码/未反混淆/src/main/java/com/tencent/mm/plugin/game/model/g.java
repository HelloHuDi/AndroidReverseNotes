package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class g {
    JSONObject mVR = new JSONObject();

    protected g(String str) {
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameServerData", "Null or nil json string");
            return;
        }
        try {
            this.mVR = new JSONObject(str);
        } catch (JSONException e) {
            ab.e("MicroMsg.GameServerData", "Json parsing error");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final JSONArray optJSONArray(String str) {
        return this.mVR.optJSONArray(str);
    }

    private static String j(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    protected static LinkedList<c> s(JSONArray jSONArray) {
        LinkedList<c> linkedList = new LinkedList();
        if (jSONArray == null || jSONArray.length() == 0) {
            ab.i("MicroMsg.GameServerData", "Null or empty json array");
            return linkedList;
        }
        ab.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", Integer.valueOf(jSONArray.length()));
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                ab.e("MicroMsg.GameServerData", "Invalid json object");
                obj = null;
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("YYB");
                String j = j(optJSONObject, "appID");
                if (bo.isNullOrNil(j)) {
                    ab.e("MicroMsg.GameServerData", "No AppID field, abort");
                    obj = null;
                } else {
                    ab.i("MicroMsg.GameServerData", "Parsing AppID: %s", j);
                    obj = new c();
                    obj.field_appId = j;
                    obj.field_appName = j(optJSONObject, "name");
                    obj.field_appIconUrl = j(optJSONObject, "iconURL");
                    obj.field_appType = ",1,";
                    obj.field_packageName = j(optJSONObject, "AndroidPackageName");
                    obj.ih(j(optJSONObject, "downloadURL"));
                    obj.ik(j(optJSONObject, "AndroidApkMd5"));
                    j = j(optJSONObject, "GooglePlayDownloadUrl");
                    int optInt = optJSONObject.optInt("GooglePlayDownloadFlag");
                    obj.il(j);
                    if (!bo.isNullOrNil(j)) {
                        ab.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", j, Integer.valueOf(optInt));
                        obj.hq(optInt);
                    }
                    if (optJSONObject2 != null) {
                        obj.hq(optJSONObject2.optInt("AndroidDownloadFlag"));
                    }
                    if (optJSONObject2 != null) {
                        obj.iq(j(optJSONObject2, "DownloadUrl"));
                        obj.ir(j(optJSONObject2, "ApkMd5"));
                        obj.io(j(optJSONObject2, "PreemptiveUrl"));
                        obj.ip(j(optJSONObject2, "ExtInfo"));
                        obj.hr(optJSONObject2.optInt("SupportedVersionCode"));
                    }
                    obj.mVk = j(optJSONObject, "desc");
                    obj.mVj = j(optJSONObject, "brief");
                    obj.type = optJSONObject.optInt("type", 0);
                    obj.status = optJSONObject.optInt("status");
                    obj.mVm = j(optJSONObject, "webURL");
                    obj.mVn = j(optJSONObject, "adUrl");
                    obj.ctu = j(optJSONObject, "noticeid");
                    obj.mVo = optJSONObject.optBoolean("isSubscribed");
                    obj.versionCode = optJSONObject.optInt(DownloadInfoColumns.VERSIONCODE);
                    if (optJSONObject2 != null) {
                        obj.mVp = j(optJSONObject2, "DownloadTipsWording");
                        obj.mVq = j(optJSONObject2, "BackBtnWording");
                        obj.mVr = j(optJSONObject2, "DownloadBtnWording");
                    }
                }
            }
            if (obj != null) {
                linkedList.add(obj);
            }
        }
        return linkedList;
    }
}
