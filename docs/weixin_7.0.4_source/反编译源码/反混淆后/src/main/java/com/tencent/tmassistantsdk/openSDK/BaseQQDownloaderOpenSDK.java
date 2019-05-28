package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class BaseQQDownloaderOpenSDK {
    protected static final String TAG = "BaseQQDownloaderOpenSDK";
    protected String hostPackageName = null;
    protected int hostVersionCode = 0;
    protected Context mContext = null;
    protected ReferenceQueue<ITMQQDownloaderOpenSDKListener> mListenerQueue = new ReferenceQueue();
    protected ArrayList<WeakReference<ITMQQDownloaderOpenSDKListener>> mWeakListenerArrayList = new ArrayList();
    protected int sdkAPILevel = 1;
    protected TMAssistantSDKChannel sdkChannel = new TMAssistantSDKChannel();

    public abstract long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2);

    public abstract long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str);

    public abstract long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2);

    public abstract void destroyQQDownloaderOpenSDK();

    public abstract TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam);

    public abstract void initQQDownloaderOpenSDK(Context context);

    public abstract void startToAuthorized(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str);

    public abstract void startToWebView(Context context, String str);

    protected BaseQQDownloaderOpenSDK() {
    }

    public boolean registerListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        if (iTMQQDownloaderOpenSDKListener == null) {
            return false;
        }
        while (true) {
            Reference poll = this.mListenerQueue.poll();
            if (poll == null) {
                break;
            }
            this.mWeakListenerArrayList.remove(poll);
        }
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            if (((ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get()) == iTMQQDownloaderOpenSDKListener) {
                return true;
            }
        }
        this.mWeakListenerArrayList.add(new WeakReference(iTMQQDownloaderOpenSDKListener, this.mListenerQueue));
        return true;
    }

    public boolean unregisterListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        if (iTMQQDownloaderOpenSDKListener == null) {
            return false;
        }
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            if (((ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get()) == iTMQQDownloaderOpenSDKListener) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public int checkQQDownloaderInstalled() {
        if (this.mContext == null) {
            throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
        }
        String str = "com.tencent.android.qqdownloader";
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            try {
                if (packageManager.getPackageInfo(str, 0) == null) {
                    return 1;
                }
                if (this.sdkAPILevel > GlobalUtil.getInstance().getQQDownloaderAPILevel()) {
                    return 2;
                }
                return 0;
            } catch (NameNotFoundException e) {
                TMLog.m60588i(TAG, "packagename not found！");
            }
        }
        return 1;
    }

    public static int getQQDownloadApiLevel(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return 0;
            }
            return applicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
        } catch (Exception e) {
            TMLog.m60588i(TAG, "packagename not found！");
            return 0;
        }
    }

    public void startToDownloadTaskList(Context context) {
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("tmast://download?hostpname=" + this.hostPackageName + "&hostversion=" + this.hostVersionCode));
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public long addDownloadTaskFromWebview(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        String formatIntentUriPath = formatIntentUriPath(5, hashMap);
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis + 300000;
        TMLog.m60588i(TAG, "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=; dataItemType=0;dataItemAction=" + formatIntentUriPath);
        return this.sdkChannel.AddDataItem(this.hostPackageName, this.hostVersionCode, "", 0, formatIntentUriPath, currentTimeMillis, j, 0, null);
    }

    public long buildAddDBData(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2, String str, String str2, int i) {
        Map formatMapParams;
        if (TextUtils.isEmpty(str2)) {
            formatMapParams = formatMapParams(tMQQDownloaderOpenSDKParam, z, z2);
        } else {
            formatMapParams = formatMapParams(tMQQDownloaderOpenSDKParam, true, true);
            formatMapParams.put("verifytype", str2);
        }
        String formatIntentUriPath = formatIntentUriPath(i, formatMapParams);
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis + 300000;
        TMLog.m60588i(TAG, "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=; dataItemType=0;dataItemAction=" + formatIntentUriPath);
        return this.sdkChannel.AddDataItem(this.hostPackageName, this.hostVersionCode, "", 0, formatIntentUriPath, currentTimeMillis, j, 0, null);
    }

    /* Access modifiers changed, original: protected */
    public long buildAddDBData(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return this.sdkChannel.AddDataItem(null, 0, null, 0, null, currentTimeMillis, currentTimeMillis + 300000, 1, bArr);
    }

    /* Access modifiers changed, original: protected */
    public Map<String, String> formatMapParams(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        String formatOplist = formatOplist(z, z2);
        HashMap hashMap = new HashMap();
        hashMap.put("hostpname", this.hostPackageName);
        hashMap.put("hostversioncode", String.valueOf(this.hostVersionCode));
        hashMap.put("sngappid", tMQQDownloaderOpenSDKParam.SNGAppId);
        hashMap.put("appid", tMQQDownloaderOpenSDKParam.taskAppId);
        hashMap.put("apkid", tMQQDownloaderOpenSDKParam.taskApkId);
        hashMap.put("pname", tMQQDownloaderOpenSDKParam.taskPackageName);
        hashMap.put(OpenSDKTool4Assistant.EXTRA_VIA, tMQQDownloaderOpenSDKParam.via);
        hashMap.put(OpenSDKTool4Assistant.EXTRA_UIN, tMQQDownloaderOpenSDKParam.uin);
        hashMap.put("uintype", tMQQDownloaderOpenSDKParam.uinType);
        hashMap.put("versioncode", String.valueOf(tMQQDownloaderOpenSDKParam.taskVersion));
        hashMap.put("oplist", formatOplist);
        hashMap.put("channelid", tMQQDownloaderOpenSDKParam.channelId);
        hashMap.put("actionflag", tMQQDownloaderOpenSDKParam.actionFlag);
        hashMap.put("sdkid", tMQQDownloaderOpenSDKParam.sdkId);
        return hashMap;
    }

    /* Access modifiers changed, original: protected */
    public String formatIntentUriPath(int i, Map<String, String> map) {
        String str;
        switch (i) {
            case 1:
                str = "download";
                break;
            case 2:
                str = "appdetails";
                break;
            case 3:
                str = "appdetails";
                break;
            case 4:
                str = "updatedownload";
                break;
            case 5:
                str = "webview";
                break;
            default:
                str = "appdetails";
                break;
        }
        String str2 = "tpmast://" + str + "?";
        String str3 = "";
        if (map != null && map.size() > 0) {
            int i2 = 0;
            for (Entry entry : map.entrySet()) {
                String str4 = (String) entry.getKey();
                str = (String) entry.getValue();
                if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str)) {
                    str = str3;
                } else {
                    String str5;
                    if (i2 <= 0) {
                        str5 = "";
                    } else {
                        str5 = "&";
                    }
                    str = str3 + str5 + str4 + "=" + URLEncoder.encode(str);
                }
                i2++;
                str3 = str;
            }
        }
        str = str2 + str3;
        TMLog.m60588i(TAG, "path:".concat(String.valueOf(str)));
        return formatEncryptUrl(str);
    }

    public boolean removeDownloadTask(long j) {
        if (j >= 0) {
            return this.sdkChannel.delDataItem(j);
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    public String formatEncryptUrl(String str) {
        return "tmast://encrypt?encryptdata=".concat(String.valueOf(URLEncoder.encode(OpenSDKTool4Assistant.encryptUri(str))));
    }

    /* Access modifiers changed, original: protected */
    public String formatOplist(boolean z, boolean z2) {
        String str = "";
        if (z && z2) {
            return "1;2";
        }
        if (z2) {
            return "2";
        }
        if (z) {
            return "1";
        }
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void onStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i, int i2, String str) {
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.m60588i(TAG, "onDownloadStateChanged listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnDownloadTaskStateChanged(tMQQDownloaderOpenSDKParam, i, i2, str);
            }
        }
    }
}
