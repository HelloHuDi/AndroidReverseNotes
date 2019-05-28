package com.tencent.p177mm.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.CoreService.C9177a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.service.ProcessService */
public final class ProcessService {
    public static ConcurrentHashMap<String, C5080b> xFh = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.service.ProcessService$PushProcessServicer */
    public static class PushProcessServicer extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.PushProcessServicer";
        }
    }

    /* renamed from: com.tencent.mm.service.ProcessService$SupportProcessService */
    public static class SupportProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.SupportProcessService";
        }
    }

    /* renamed from: com.tencent.mm.service.ProcessService$ToolsProcessService */
    public static class ToolsProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.ToolsProcessService";
        }
    }

    /* renamed from: com.tencent.mm.service.ProcessService$ExDeviceProcessService */
    public static class ExDeviceProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.ExDeviceProcessService";
        }
    }

    /* renamed from: com.tencent.mm.service.ProcessService$DexOptProcessService */
    public static class DexOptProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.DexOptProcessService";
        }
    }

    /* renamed from: com.tencent.mm.service.ProcessService$MMProcessService */
    public static class MMProcessService extends CommonProcessService {
        private C9177a ebC = null;

        public final String getTag() {
            return "MicroMsg.MMProcessService";
        }

        public void onCreate() {
            AppMethodBeat.m2504i(58943);
            try {
                this.ebC = (C9177a) Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance();
                C4990ab.m7411d("MicroMsg.MMProcessService", "broadcastRegisterHelper = %s", this.ebC);
                this.ebC.registerBroadcasts();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMProcessService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", e.getMessage());
            }
            super.onCreate();
            AppMethodBeat.m2505o(58943);
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(58944);
            if (this.ebC != null) {
                try {
                    this.ebC.unRegisterBroadcasts();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MMProcessService", "onDestroy unRegisterBroadcasts() Exception = %s ", e.getMessage());
                }
            }
            super.onDestroy();
            AppMethodBeat.m2505o(58944);
        }
    }

    /* renamed from: com.tencent.mm.service.ProcessService$SandBoxProcessService */
    public static class SandBoxProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.SandBoxProcessService";
        }
    }

    /* renamed from: com.tencent.mm.service.ProcessService$ToolsmpProcessService */
    public static class ToolsmpProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.ToolsmpProcessService";
        }
    }

    static {
        AppMethodBeat.m2504i(58945);
        AppMethodBeat.m2505o(58945);
    }
}
