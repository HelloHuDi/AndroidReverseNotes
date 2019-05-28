package com.tencent.mm.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

public final class ProcessService {
    public static ConcurrentHashMap<String, b> xFh = new ConcurrentHashMap();

    public static class PushProcessServicer extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.PushProcessServicer";
        }
    }

    public static class SupportProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.SupportProcessService";
        }
    }

    public static class ToolsProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.ToolsProcessService";
        }
    }

    public static class ExDeviceProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.ExDeviceProcessService";
        }
    }

    public static class DexOptProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.DexOptProcessService";
        }
    }

    public static class MMProcessService extends CommonProcessService {
        private a ebC = null;

        public final String getTag() {
            return "MicroMsg.MMProcessService";
        }

        public void onCreate() {
            AppMethodBeat.i(58943);
            try {
                this.ebC = (a) Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance();
                ab.d("MicroMsg.MMProcessService", "broadcastRegisterHelper = %s", this.ebC);
                this.ebC.registerBroadcasts();
            } catch (Exception e) {
                ab.e("MicroMsg.MMProcessService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", e.getMessage());
            }
            super.onCreate();
            AppMethodBeat.o(58943);
        }

        public void onDestroy() {
            AppMethodBeat.i(58944);
            if (this.ebC != null) {
                try {
                    this.ebC.unRegisterBroadcasts();
                } catch (Exception e) {
                    ab.e("MicroMsg.MMProcessService", "onDestroy unRegisterBroadcasts() Exception = %s ", e.getMessage());
                }
            }
            super.onDestroy();
            AppMethodBeat.o(58944);
        }
    }

    public static class SandBoxProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.SandBoxProcessService";
        }
    }

    public static class ToolsmpProcessService extends CommonProcessService {
        public final String getTag() {
            return "MicroMsg.ToolsmpProcessService";
        }
    }

    static {
        AppMethodBeat.i(58945);
        AppMethodBeat.o(58945);
    }
}
