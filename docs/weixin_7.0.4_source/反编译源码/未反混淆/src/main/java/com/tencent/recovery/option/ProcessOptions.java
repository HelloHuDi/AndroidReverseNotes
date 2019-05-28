package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class ProcessOptions {
    private Express Aru;
    public int azs;

    public static final class Builder {
        public Express Aru;
        private int azs;

        public final Builder dQh() {
            this.azs = Downloads.MIN_WAIT_FOR_NETWORK;
            return this;
        }

        public final ProcessOptions dQi() {
            ProcessOptions processOptions = new ProcessOptions();
            processOptions.azs = this.azs;
            processOptions.Aru = this.Aru;
            return processOptions;
        }
    }
}
