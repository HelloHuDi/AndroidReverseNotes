package com.tencent.mars.mm;

import android.content.Context;
import com.tencent.mars.app.AppLogic.AccountInfo;
import com.tencent.mars.app.AppLogic.DeviceInfo;
import com.tencent.mars.app.AppLogic.ICallBack;
import com.tencent.mm.network.aa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class AppCallBack implements ICallBack {
    private static final String TAG = "AppCallBack";
    private Context context = null;
    DeviceInfo info = new DeviceInfo(d.DEVICE_NAME, d.eSg);

    private static String exception2String(Exception exception) {
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public AppCallBack(Context context) {
        this.context = context;
    }

    public String getAppFilePath() {
        if (this.context == null) {
            Assert.assertTrue(false);
            return null;
        }
        try {
            File filesDir = this.context.getFilesDir();
            if (!filesDir.exists()) {
                filesDir.createNewFile();
            }
            return filesDir.toString();
        } catch (Exception e) {
            ab.e(TAG, exception2String(e));
            Assert.assertTrue(e.getClass().getSimpleName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + e.getStackTrace()[0] + ", " + e.getStackTrace()[1], false);
            return "";
        }
    }

    public AccountInfo getAccountInfo() {
        AccountInfo accountInfo = new AccountInfo();
        if (!(aa.ano() == null || aa.ano().gcU == null)) {
            try {
                accountInfo.uin = (long) aa.ano().gcU.QF();
                accountInfo.userName = aa.ano().gcU.adD();
                if (bo.isNullOrNil(accountInfo.userName)) {
                    accountInfo.userName = aa.ano().gcU.getUsername();
                }
            } catch (Exception e) {
            }
        }
        return accountInfo;
    }

    public int getClientVersion() {
        return d.vxo;
    }

    public DeviceInfo getDeviceType() {
        return this.info;
    }

    public String getCurLanguage() {
        return com.tencent.mm.sdk.platformtools.aa.dor();
    }
}
