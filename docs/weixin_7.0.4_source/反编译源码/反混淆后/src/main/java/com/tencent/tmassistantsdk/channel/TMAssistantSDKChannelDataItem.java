package com.tencent.tmassistantsdk.channel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.util.Base64;
import com.tencent.tmassistantsdk.util.Cryptor;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class TMAssistantSDKChannelDataItem {
    public static final int DATEITEM_VERSION = 1;
    private static final String ENCRYPT_KEY = "&-*)Wb5_U,[^!9'+";
    public static final int IPCDATA_MIN_VERSION = 1;
    private static final String TAG = "MicroMsg.TMAssistantSDKChannelDataItem";
    public int mDBIdentity = -1;
    public String mDataItemAction = "";
    public long mDataItemEndTime = 0;
    public long mDataItemStartTime = 0;
    public int mDataItemType = 0;
    public int mDataItemVersion = 0;
    public String mHostPackageName = "";
    public String mHostUserIdentity = "";
    public int mHostVersion = 0;
    public byte[] mIPCData = null;

    public TMAssistantSDKChannelDataItem(String str, int i, String str2, int i2, String str3, long j, long j2, int i3, byte[] bArr) {
        AppMethodBeat.m2504i(75618);
        this.mHostPackageName = str;
        if (this.mHostPackageName == null) {
            this.mHostPackageName = "";
        }
        this.mHostVersion = i;
        this.mHostUserIdentity = str2;
        if (this.mHostUserIdentity == null) {
            this.mHostUserIdentity = "";
        }
        this.mDataItemType = i2;
        this.mDataItemAction = str3;
        if (this.mDataItemAction == null) {
            this.mDataItemAction = "";
        }
        this.mDataItemStartTime = j;
        this.mDataItemEndTime = j2;
        this.mDataItemVersion = i3;
        this.mIPCData = bArr;
        AppMethodBeat.m2505o(75618);
    }

    public static TMAssistantSDKChannelDataItem getDataItemFromByte(byte[] bArr) {
        AppMethodBeat.m2504i(75619);
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.m2505o(75619);
            return null;
        }
        byte[] decrypt = new Cryptor().decrypt(bArr, ENCRYPT_KEY.getBytes());
        if (decrypt != null) {
            try {
                byte[] decode;
                TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem;
                JSONObject jSONObject = new JSONObject(new String(decrypt, "UTF-8"));
                String string = jSONObject.getString("mHostPackageName");
                int i = jSONObject.getInt("mHostVersion");
                String string2 = jSONObject.getString("mHostUserIdentity");
                int i2 = jSONObject.getInt("mDataItemType");
                String string3 = jSONObject.getString("mDataItemAction");
                long j = jSONObject.getLong("mDataItemStartTime");
                long j2 = jSONObject.getLong("mDataItemEndTime");
                int i3 = jSONObject.getInt("mDataItemVersion");
                if (i3 > 0) {
                    String string4 = jSONObject.getString("mIPCData");
                    if (string4 != null) {
                        decode = Base64.decode(string4, 0);
                        tMAssistantSDKChannelDataItem = new TMAssistantSDKChannelDataItem(string, i, string2, i2, string3, j, j2, i3, decode);
                        AppMethodBeat.m2505o(75619);
                        return tMAssistantSDKChannelDataItem;
                    }
                }
                decode = null;
                tMAssistantSDKChannelDataItem = new TMAssistantSDKChannelDataItem(string, i, string2, i2, string3, j, j2, i3, decode);
                AppMethodBeat.m2505o(75619);
                return tMAssistantSDKChannelDataItem;
            } catch (UnsupportedEncodingException e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            } catch (JSONException e2) {
                C4990ab.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(75619);
        return null;
    }

    public byte[] getBuffer() {
        AppMethodBeat.m2504i(75620);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mHostPackageName", this.mHostPackageName);
            jSONObject.put("mHostVersion", this.mHostVersion);
            jSONObject.put("mHostUserIdentity", this.mHostUserIdentity);
            jSONObject.put("mDataItemType", this.mDataItemType);
            jSONObject.put("mDataItemAction", this.mDataItemAction);
            jSONObject.put("mDataItemStartTime", this.mDataItemStartTime);
            jSONObject.put("mDataItemEndTime", this.mDataItemEndTime);
            jSONObject.put("mDataItemVersion", this.mDataItemVersion);
            if (this.mDataItemVersion > 0 && this.mIPCData != null) {
                String encodeToString = Base64.encodeToString(this.mIPCData, 0);
                if (encodeToString != null) {
                    jSONObject.put("mIPCData", encodeToString);
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes("UTF-8");
                if (bytes != null) {
                    bytes = new Cryptor().encrypt(bytes, ENCRYPT_KEY.getBytes());
                    AppMethodBeat.m2505o(75620);
                    return bytes;
                }
            }
        } catch (JSONException e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
        } catch (UnsupportedEncodingException e2) {
            C4990ab.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.m2505o(75620);
        return null;
    }
}
