package com.tencent.mars.p150mm;

import android.content.Context;
import com.tencent.mars.app.AppLogic.AccountInfo;
import com.tencent.mars.app.AppLogic.DeviceInfo;
import com.tencent.mars.app.AppLogic.ICallBack;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

/* renamed from: com.tencent.mars.mm.AppCallBack */
public class AppCallBack implements ICallBack {
    private static final String TAG = "AppCallBack";
    private Context context = null;
    DeviceInfo info = new DeviceInfo(C7243d.DEVICE_NAME, C7243d.eSg);

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
            C4990ab.m7412e(TAG, AppCallBack.exception2String(e));
            Assert.assertTrue(e.getClass().getSimpleName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + e.getStackTrace()[0] + ", " + e.getStackTrace()[1], false);
            return "";
        }
    }

    public AccountInfo getAccountInfo() {
        AccountInfo accountInfo = new AccountInfo();
        if (!(C1892aa.ano() == null || C1892aa.ano().gcU == null)) {
            try {
                accountInfo.uin = (long) C1892aa.ano().gcU.mo5495QF();
                accountInfo.userName = C1892aa.ano().gcU.adD();
                if (C5046bo.isNullOrNil(accountInfo.userName)) {
                    accountInfo.userName = C1892aa.ano().gcU.getUsername();
                }
            } catch (Exception e) {
            }
        }
        return accountInfo;
    }

    public int getClientVersion() {
        return C7243d.vxo;
    }

    public DeviceInfo getDeviceType() {
        return this.info;
    }

    public String getCurLanguage() {
        return C4988aa.dor();
    }
}
