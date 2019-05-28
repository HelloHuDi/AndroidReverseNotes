package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.Map;
import org.json.JSONObject;

public final class a {
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

    public static a R(JSONObject jSONObject) {
        AppMethodBeat.i(35546);
        a aVar = new a();
        aVar.appName = jSONObject.optString("task_name");
        aVar.downloadUrl = jSONObject.optString("task_url");
        aVar.kOB = jSONObject.optString("alternative_url");
        aVar.kOC = jSONObject.optLong("task_size");
        aVar.kOD = jSONObject.optString("file_md5");
        aVar.extInfo = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        aVar.fileType = bo.getInt(jSONObject.optString("fileType"), 0);
        aVar.appId = jSONObject.optString("appid");
        aVar.packageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        aVar.scene = jSONObject.optInt("scene", 1000);
        aVar.cBA = jSONObject.optInt("downloader_type", 1);
        aVar.kNt = jSONObject.optBoolean("download_in_wifi", false);
        AppMethodBeat.o(35546);
        return aVar;
    }

    public static a H(Map<String, Object> map) {
        AppMethodBeat.i(35547);
        a aVar = new a();
        if (map == null) {
            AppMethodBeat.o(35547);
            return aVar;
        }
        aVar.appName = (String) map.get("task_name");
        aVar.downloadUrl = (String) map.get("task_url");
        aVar.kOB = (String) map.get("alternative_url");
        aVar.kOC = bo.getLong((String) map.get("task_size"), 0);
        aVar.kOD = (String) map.get("file_md5");
        aVar.extInfo = (String) map.get(IssueStorage.COLUMN_EXT_INFO);
        aVar.fileType = bo.getInt((String) map.get("fileType"), 0);
        aVar.appId = (String) map.get("appid");
        aVar.packageName = (String) map.get("package_name");
        aVar.scene = bo.getInt((String) map.get("scene"), 1000);
        aVar.cBA = bo.getInt((String) map.get("downloader_type"), 1);
        AppMethodBeat.o(35547);
        return aVar;
    }

    public final boolean isValid() {
        AppMethodBeat.i(35548);
        if (bo.isNullOrNil(this.downloadUrl)) {
            AppMethodBeat.o(35548);
            return false;
        }
        AppMethodBeat.o(35548);
        return true;
    }
}
