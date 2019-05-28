package com.tencent.p177mm.plugin.game.model;

import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.model.g */
public abstract class C43190g {
    JSONObject mVR = new JSONObject();

    protected C43190g(String str) {
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameServerData", "Null or nil json string");
            return;
        }
        try {
            this.mVR = new JSONObject(str);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.GameServerData", "Json parsing error");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final JSONArray optJSONArray(String str) {
        return this.mVR.optJSONArray(str);
    }

    /* renamed from: j */
    private static String m76767j(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    /* renamed from: s */
    protected static LinkedList<C20992c> m76768s(JSONArray jSONArray) {
        LinkedList<C20992c> linkedList = new LinkedList();
        if (jSONArray == null || jSONArray.length() == 0) {
            C4990ab.m7416i("MicroMsg.GameServerData", "Null or empty json array");
            return linkedList;
        }
        C4990ab.m7417i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", Integer.valueOf(jSONArray.length()));
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                C4990ab.m7412e("MicroMsg.GameServerData", "Invalid json object");
                obj = null;
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("YYB");
                String j = C43190g.m76767j(optJSONObject, "appID");
                if (C5046bo.isNullOrNil(j)) {
                    C4990ab.m7412e("MicroMsg.GameServerData", "No AppID field, abort");
                    obj = null;
                } else {
                    C4990ab.m7417i("MicroMsg.GameServerData", "Parsing AppID: %s", j);
                    obj = new C20992c();
                    obj.field_appId = j;
                    obj.field_appName = C43190g.m76767j(optJSONObject, "name");
                    obj.field_appIconUrl = C43190g.m76767j(optJSONObject, "iconURL");
                    obj.field_appType = ",1,";
                    obj.field_packageName = C43190g.m76767j(optJSONObject, "AndroidPackageName");
                    obj.mo44076ih(C43190g.m76767j(optJSONObject, "downloadURL"));
                    obj.mo44079ik(C43190g.m76767j(optJSONObject, "AndroidApkMd5"));
                    j = C43190g.m76767j(optJSONObject, "GooglePlayDownloadUrl");
                    int optInt = optJSONObject.optInt("GooglePlayDownloadFlag");
                    obj.mo44080il(j);
                    if (!C5046bo.isNullOrNil(j)) {
                        C4990ab.m7417i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", j, Integer.valueOf(optInt));
                        obj.mo44071hq(optInt);
                    }
                    if (optJSONObject2 != null) {
                        obj.mo44071hq(optJSONObject2.optInt("AndroidDownloadFlag"));
                    }
                    if (optJSONObject2 != null) {
                        obj.mo44085iq(C43190g.m76767j(optJSONObject2, "DownloadUrl"));
                        obj.mo44086ir(C43190g.m76767j(optJSONObject2, "ApkMd5"));
                        obj.mo44083io(C43190g.m76767j(optJSONObject2, "PreemptiveUrl"));
                        obj.mo44084ip(C43190g.m76767j(optJSONObject2, "ExtInfo"));
                        obj.mo44072hr(optJSONObject2.optInt("SupportedVersionCode"));
                    }
                    obj.mVk = C43190g.m76767j(optJSONObject, "desc");
                    obj.mVj = C43190g.m76767j(optJSONObject, "brief");
                    obj.type = optJSONObject.optInt("type", 0);
                    obj.status = optJSONObject.optInt("status");
                    obj.mVm = C43190g.m76767j(optJSONObject, "webURL");
                    obj.mVn = C43190g.m76767j(optJSONObject, "adUrl");
                    obj.ctu = C43190g.m76767j(optJSONObject, "noticeid");
                    obj.mVo = optJSONObject.optBoolean("isSubscribed");
                    obj.versionCode = optJSONObject.optInt(DownloadInfoColumns.VERSIONCODE);
                    if (optJSONObject2 != null) {
                        obj.mVp = C43190g.m76767j(optJSONObject2, "DownloadTipsWording");
                        obj.mVq = C43190g.m76767j(optJSONObject2, "BackBtnWording");
                        obj.mVr = C43190g.m76767j(optJSONObject2, "DownloadBtnWording");
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
