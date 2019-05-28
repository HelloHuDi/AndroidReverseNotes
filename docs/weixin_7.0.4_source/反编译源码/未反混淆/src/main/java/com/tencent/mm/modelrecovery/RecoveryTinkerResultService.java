package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.a;
import java.util.ArrayList;

public class RecoveryTinkerResultService extends AbstractResultService {
    public void onCreate() {
        AppMethodBeat.i(16544);
        super.onCreate();
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onCreate", new Object[0]);
        AppMethodBeat.o(16544);
    }

    public void onDestroy() {
        AppMethodBeat.i(16545);
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onDestroy", new Object[0]);
        super.onDestroy();
        AppMethodBeat.o(16545);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(16546);
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "RecoveryTinkerResultService receive result: %s", aVar);
        CommonOptions iz = OptionFactory.iz(this);
        ArrayList arrayList = new ArrayList();
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.eCq = iz.eCq;
        recoveryHandleItem.clientVersion = iz.clientVersion;
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.key = "KeyPatchResultTotalCount";
        if (aVar.cxT) {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch success", new Object[0]);
            recoveryHandleItem.key = "KeyPatchResultSuccessCount";
        } else {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch fail ", new Object[0]);
            if (aVar.Arh != null) {
                RecoveryLog.i("Recovery.RecoveryTinkerResultService", "fail reason %s", aVar.Arh.getMessage());
                recoveryHandleItem.key = String.format("%s[%s]", new Object[]{"KeyPatchResultFailCount", aVar.Arh.getMessage()});
            } else {
                recoveryHandleItem.key = "KeyPatchResultFailCount";
            }
        }
        arrayList.add(recoveryHandleItem);
        RecoveryLogic.a((Context) this, arrayList, WXRecoveryUploadService.class.getName());
        stopSelf();
        AppMethodBeat.o(16546);
    }
}
