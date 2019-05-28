package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class aq extends Handler {
    final /* synthetic */ an a;

    aq(an anVar, Looper looper) {
        this.a = anVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(64398);
        QbSdk.setTBSInstallingStatus(true);
        Object[] objArr;
        switch (message.what) {
            case 1:
                TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                objArr = (Object[]) message.obj;
                an.a(this.a, (Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                AppMethodBeat.o(64398);
                return;
            case 2:
                TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                objArr = (Object[]) message.obj;
                an.a(this.a, (Context) objArr[0], (Context) objArr[1], ((Integer) objArr[2]).intValue());
                AppMethodBeat.o(64398);
                return;
            case 3:
                TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                objArr = (Object[]) message.obj;
                this.a.b((Context) objArr[0], (Bundle) objArr[1]);
                AppMethodBeat.o(64398);
                return;
            case 4:
                TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
                objArr = (Object[]) message.obj;
                this.a.a((Context) objArr[0], (File) objArr[1], ((Integer) objArr[2]).intValue());
                QbSdk.setTBSInstallingStatus(false);
                super.handleMessage(message);
                break;
        }
        AppMethodBeat.o(64398);
    }
}
