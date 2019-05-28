package com.tencent.recovery;

import com.tencent.recovery.config.Express;
import com.tencent.recovery.config.ExpressItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.ProcessOptions;
import java.util.ArrayList;

public class ConstantsRecovery {

    public static final class DefaultCommonOptions {
        public static final CommonOptions AqJ;

        static {
            Builder builder = new Builder();
            builder.eCq = "";
            builder.clientVersion = "";
            builder.Arl = "";
            builder.Aro = "";
            builder.Arp = "";
            AqJ = builder.dQg();
        }
    }

    public static final class DefaultExpress {
        public static final Express AqK = new Express();
        public static final Express AqL = new Express();
        public static final Express AqM = new Express();

        static {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ExpressItem(17, 1114112));
            AqK.mo11990fA(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1118208));
            AqL.mo11990fA(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1114112));
            AqM.mo11990fA(arrayList);
        }
    }

    public static final class DefaultProcessOptions {
        public static final ProcessOptions AqN;
        public static final ProcessOptions AqO;
        public static final ProcessOptions AqP;

        static {
            ProcessOptions.Builder builder = new ProcessOptions.Builder();
            builder.Aru = DefaultExpress.AqK;
            builder.dQh();
            AqN = builder.dQi();
            builder = new ProcessOptions.Builder();
            builder.Aru = DefaultExpress.AqL;
            builder.dQh();
            AqO = builder.dQi();
            builder = new ProcessOptions.Builder();
            builder.Aru = DefaultExpress.AqM;
            builder.dQh();
            AqP = builder.dQi();
        }
    }

    public static final class IntentAction {
    }

    public static final class IntentKeys {
    }

    public static final class Message {
    }

    public static final class ProcessStage {
    }

    public static final class ProcessStartFlag {
    }

    public static final class ProcessStatus {
    }

    public static final class ReportType {
    }

    public static final class SpKeys {
    }
}
