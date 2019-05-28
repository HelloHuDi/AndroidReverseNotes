package com.tencent.tmassistantsdk.network;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKAuthorizedInfo;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo;
import com.tencent.tmassistantsdk.util.TMLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAuthorizedHttpRequest extends GetHttpRequest {
    protected static final String TAG = "GetAuthorizedHttpRequest";
    protected IGetAuthorizedHttpRequestListenner mGetAuthorizedListener = null;

    public void setListenner(IGetAuthorizedHttpRequestListenner iGetAuthorizedHttpRequestListenner) {
        this.mGetAuthorizedListener = iGetAuthorizedHttpRequestListenner;
    }

    public void sendRequest(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        AppMethodBeat.i(75831);
        if (tMOpenSDKAuthorizedInfo != null) {
            super.sendData(authorizedInfoToString(tMOpenSDKAuthorizedInfo));
        }
        AppMethodBeat.o(75831);
    }

    /* Access modifiers changed, original: protected */
    public void onFinished(JSONObject jSONObject, int i) {
        AppMethodBeat.i(75832);
        if (this.mGetAuthorizedListener == null) {
            TMLog.i(TAG, "mGetAuthorizedListener is null !");
            AppMethodBeat.o(75832);
            return;
        }
        if (i != 0 || jSONObject == null) {
            this.mGetAuthorizedListener.onGetAuthorizedRequestFinished(null, i);
        } else {
            try {
                AuthorizedResult jsonObjectToRespData = jsonObjectToRespData(jSONObject);
                if (jsonObjectToRespData != null) {
                    this.mGetAuthorizedListener.onGetAuthorizedRequestFinished(jsonObjectToRespData, 0);
                    AppMethodBeat.o(75832);
                    return;
                }
            } catch (JSONException e) {
                this.mGetAuthorizedListener.onGetAuthorizedRequestFinished(null, 704);
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
                AppMethodBeat.o(75832);
                return;
            }
        }
        AppMethodBeat.o(75832);
    }

    private String authorizedInfoToString(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        AppMethodBeat.i(75833);
        String str = ((((((((((("" + "?appId=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.appId)) + "&userId=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.userId)) + "&userIdType=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.userIdType)) + "&identityInfo=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.identityInfo)) + "&identityType=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.identityType)) + "&gamePackageName=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.gamePackageName)) + "&gameVersionCode=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.gameVersionCode)) + "&gameChannelId=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.gameChannelId)) + "&actionFlag=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.actionFlag)) + "&verifyType=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.verifyType)) + "&via=" + URLEncoder.encode(tMOpenSDKAuthorizedInfo.via)) + "&actionType=" + tMOpenSDKAuthorizedInfo.actionType;
        AppMethodBeat.o(75833);
        return str;
    }

    private AuthorizedResult jsonObjectToRespData(JSONObject jSONObject) {
        AppMethodBeat.i(75834);
        AuthorizedResult authorizedResult = new AuthorizedResult();
        authorizedResult.hasAuthoried = jSONObject.getInt("hasAuthoried");
        authorizedResult.errorCode = jSONObject.getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE);
        authorizedResult.downloadUrl = jSONObject.getString("downloadUrl");
        authorizedResult.versionCode = jSONObject.getInt(DownloadInfoColumns.VERSIONCODE);
        JSONObject jSONObject2 = jSONObject.getJSONObject("tipsInfo");
        TipsInfo tipsInfo = null;
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            TipsInfo tipsInfo2 = new TipsInfo();
            tipsInfo2.title = jSONObject2.getString("title");
            tipsInfo2.content = jSONObject2.getString(b.CONTENT);
            JSONArray jSONArray = jSONObject2.getJSONArray("actionButton");
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    ActionButton actionButton = new ActionButton();
                    actionButton.textInstalled = jSONArray.getJSONObject(i).getString("textInstalled");
                    actionButton.textUninstalled = jSONArray.getJSONObject(i).getString("textUninstalled");
                    actionButton.jumpType = jSONArray.getJSONObject(i).getInt("jumpType");
                    actionButton.jumpUrl = jSONArray.getJSONObject(i).getString("jumpUrl");
                    arrayList.add(actionButton);
                }
            }
            tipsInfo2.actionButton = arrayList;
            tipsInfo = tipsInfo2;
        }
        authorizedResult.tipsInfo = tipsInfo;
        TMLog.i(TAG, "dataInfo :" + authorizedResult.toString());
        AppMethodBeat.o(75834);
        return authorizedResult;
    }
}
