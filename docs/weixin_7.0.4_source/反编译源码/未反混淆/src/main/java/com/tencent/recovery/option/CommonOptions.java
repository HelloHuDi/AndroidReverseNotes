package com.tencent.recovery.option;

public class CommonOptions {
    public String Arl;
    public String Aro;
    public String Arp;
    private boolean Arq;
    public long Arr;
    public long Ars;
    public String clientVersion;
    public String eCq;

    public static final class Builder {
        public String Arl;
        public String Aro;
        public String Arp;
        public boolean Arq;
        public long Arr;
        public long Ars;
        public String clientVersion;
        public String eCq;

        public final CommonOptions dQg() {
            CommonOptions commonOptions = new CommonOptions();
            commonOptions.Aro = this.Aro;
            commonOptions.Arp = this.Arp;
            commonOptions.clientVersion = this.clientVersion;
            commonOptions.Arl = this.Arl;
            commonOptions.eCq = this.eCq;
            commonOptions.Arq = this.Arq;
            commonOptions.Arr = this.Arr;
            commonOptions.Ars = this.Ars;
            return commonOptions;
        }
    }

    /* synthetic */ CommonOptions(byte b) {
        this();
    }

    private CommonOptions() {
    }
}
