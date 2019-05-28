package com.tencent.recovery;

import android.content.Context;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.IOptionsCreator;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.p662wx.WXConstantsRecovery;
import com.tencent.recovery.p662wx.service.WXRecoveryHandleService;
import com.tencent.recovery.p662wx.service.WXRecoveryUploadService;
import com.tencent.recovery.p662wx.util.FileUtil;
import com.tencent.recovery.p662wx.util.WXUtil;
import com.tencent.recovery.util.Util;
import java.io.File;

public class DefaultOptionsCreator implements IOptionsCreator {
    private String clientVersion;

    public ProcessOptions createProcessOptions(String str, int i) {
        return null;
    }

    public CommonOptions createCommonOptions(Context context) {
        Builder builder = new Builder();
        builder.Aro = WXRecoveryHandleService.class.getName();
        builder.Arp = WXRecoveryUploadService.class.getName();
        builder.clientVersion = getClientVersion();
        builder.Arl = String.format("http://dldir1.qq.com/weixin/android/recovery-%s.conf", new Object[]{getClientVersion()});
        builder.eCq = WXUtil.m8761iG(context);
        builder.Arq = true;
        builder.Arr = 600000;
        builder.Ars = 600000;
        return builder.dQg();
    }

    private String getClientVersion() {
        if (Util.isNullOrNil(this.clientVersion)) {
            File file = new File(WXConstantsRecovery.ArA, "version.info");
            if (file.exists()) {
                this.clientVersion = FileUtil.m8748ae(file);
            }
        }
        if (Util.isNullOrNil(this.clientVersion)) {
            this.clientVersion = BuildConfig.CLIENT_VERSION;
        }
        return this.clientVersion;
    }

    public String toString() {
        return String.format("Creator: [ClientVersion=%s] ", new Object[]{getClientVersion()});
    }
}
