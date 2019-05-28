package com.tencent.p177mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.p662wx.service.WXRecoveryUploadService;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.C46819a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.modelrecovery.RecoveryTinkerResultService */
public class RecoveryTinkerResultService extends AbstractResultService {
    public void onCreate() {
        AppMethodBeat.m2504i(16544);
        super.onCreate();
        RecoveryLog.m8712i("Recovery.RecoveryTinkerResultService", "onCreate", new Object[0]);
        AppMethodBeat.m2505o(16544);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(16545);
        RecoveryLog.m8712i("Recovery.RecoveryTinkerResultService", "onDestroy", new Object[0]);
        super.onDestroy();
        AppMethodBeat.m2505o(16545);
    }

    /* renamed from: a */
    public final void mo33931a(C46819a c46819a) {
        AppMethodBeat.m2504i(16546);
        RecoveryLog.m8712i("Recovery.RecoveryTinkerResultService", "RecoveryTinkerResultService receive result: %s", c46819a);
        CommonOptions iz = OptionFactory.m8722iz(this);
        ArrayList arrayList = new ArrayList();
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.eCq = iz.eCq;
        recoveryHandleItem.clientVersion = iz.clientVersion;
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.key = "KeyPatchResultTotalCount";
        if (c46819a.cxT) {
            RecoveryLog.m8712i("Recovery.RecoveryTinkerResultService", "patch success", new Object[0]);
            recoveryHandleItem.key = "KeyPatchResultSuccessCount";
        } else {
            RecoveryLog.m8712i("Recovery.RecoveryTinkerResultService", "patch fail ", new Object[0]);
            if (c46819a.Arh != null) {
                RecoveryLog.m8712i("Recovery.RecoveryTinkerResultService", "fail reason %s", c46819a.Arh.getMessage());
                recoveryHandleItem.key = String.format("%s[%s]", new Object[]{"KeyPatchResultFailCount", c46819a.Arh.getMessage()});
            } else {
                recoveryHandleItem.key = "KeyPatchResultFailCount";
            }
        }
        arrayList.add(recoveryHandleItem);
        RecoveryLogic.m8701a((Context) this, arrayList, WXRecoveryUploadService.class.getName());
        stopSelf();
        AppMethodBeat.m2505o(16546);
    }
}
