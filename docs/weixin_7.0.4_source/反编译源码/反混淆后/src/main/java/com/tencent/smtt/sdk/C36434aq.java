package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* renamed from: com.tencent.smtt.sdk.aq */
class C36434aq extends Handler {
    /* renamed from: a */
    final /* synthetic */ C5813an f15166a;

    C36434aq(C5813an c5813an, Looper looper) {
        this.f15166a = c5813an;
        super(looper);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.m2504i(64398);
        QbSdk.setTBSInstallingStatus(true);
        Object[] objArr;
        switch (message.what) {
            case 1:
                TbsLog.m80434i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                objArr = (Object[]) message.obj;
                C5813an.m8805a(this.f15166a, (Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                AppMethodBeat.m2505o(64398);
                return;
            case 2:
                TbsLog.m80434i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                objArr = (Object[]) message.obj;
                C5813an.m8804a(this.f15166a, (Context) objArr[0], (Context) objArr[1], ((Integer) objArr[2]).intValue());
                AppMethodBeat.m2505o(64398);
                return;
            case 3:
                TbsLog.m80434i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                objArr = (Object[]) message.obj;
                this.f15166a.mo12160b((Context) objArr[0], (Bundle) objArr[1]);
                AppMethodBeat.m2505o(64398);
                return;
            case 4:
                TbsLog.m80434i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
                objArr = (Object[]) message.obj;
                this.f15166a.mo12155a((Context) objArr[0], (File) objArr[1], ((Integer) objArr[2]).intValue());
                QbSdk.setTBSInstallingStatus(false);
                super.handleMessage(message);
                break;
        }
        AppMethodBeat.m2505o(64398);
    }
}
