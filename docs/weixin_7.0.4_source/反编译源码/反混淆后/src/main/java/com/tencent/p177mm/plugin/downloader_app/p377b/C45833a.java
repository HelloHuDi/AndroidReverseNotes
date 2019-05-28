package com.tencent.p177mm.plugin.downloader_app.p377b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.b.a */
public final class C45833a {
    public String appId;
    public String appName;
    public int cBA;
    public String downloadUrl;
    public String extInfo;
    public int fileType;
    public boolean kNt;
    public String kOB;
    public long kOC;
    public String kOD;
    public String packageName;
    public int scene;

    /* renamed from: R */
    public static C45833a m84829R(JSONObject jSONObject) {
        AppMethodBeat.m2504i(35546);
        C45833a c45833a = new C45833a();
        c45833a.appName = jSONObject.optString("task_name");
        c45833a.downloadUrl = jSONObject.optString("task_url");
        c45833a.kOB = jSONObject.optString("alternative_url");
        c45833a.kOC = jSONObject.optLong("task_size");
        c45833a.kOD = jSONObject.optString("file_md5");
        c45833a.extInfo = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        c45833a.fileType = C5046bo.getInt(jSONObject.optString("fileType"), 0);
        c45833a.appId = jSONObject.optString("appid");
        c45833a.packageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        c45833a.scene = jSONObject.optInt("scene", 1000);
        c45833a.cBA = jSONObject.optInt("downloader_type", 1);
        c45833a.kNt = jSONObject.optBoolean("download_in_wifi", false);
        AppMethodBeat.m2505o(35546);
        return c45833a;
    }

    /* renamed from: H */
    public static C45833a m84828H(Map<String, Object> map) {
        AppMethodBeat.m2504i(35547);
        C45833a c45833a = new C45833a();
        if (map == null) {
            AppMethodBeat.m2505o(35547);
            return c45833a;
        }
        c45833a.appName = (String) map.get("task_name");
        c45833a.downloadUrl = (String) map.get("task_url");
        c45833a.kOB = (String) map.get("alternative_url");
        c45833a.kOC = C5046bo.getLong((String) map.get("task_size"), 0);
        c45833a.kOD = (String) map.get("file_md5");
        c45833a.extInfo = (String) map.get(IssueStorage.COLUMN_EXT_INFO);
        c45833a.fileType = C5046bo.getInt((String) map.get("fileType"), 0);
        c45833a.appId = (String) map.get("appid");
        c45833a.packageName = (String) map.get("package_name");
        c45833a.scene = C5046bo.getInt((String) map.get("scene"), 1000);
        c45833a.cBA = C5046bo.getInt((String) map.get("downloader_type"), 1);
        AppMethodBeat.m2505o(35547);
        return c45833a;
    }

    public final boolean isValid() {
        AppMethodBeat.m2504i(35548);
        if (C5046bo.isNullOrNil(this.downloadUrl)) {
            AppMethodBeat.m2505o(35548);
            return false;
        }
        AppMethodBeat.m2505o(35548);
        return true;
    }
}
