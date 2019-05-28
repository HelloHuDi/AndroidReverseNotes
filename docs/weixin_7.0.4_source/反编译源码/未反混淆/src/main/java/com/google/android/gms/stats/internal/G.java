package com.google.android.gms.stats.internal;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.stats.netstats.NetstatsParserPatterns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class G {

    public static final class netStats {
        public static final GservicesValue<Long> dataSourcePollIntervalMillis = GservicesValue.value("gms:stats:netstats:data_source_poll_millis", Long.valueOf(TimeUnit.MINUTES.toMillis(30)));
        public static final GservicesValue<Boolean> enabled = GservicesValue.value("gms:stats:netstats:enabled", true);
        public static final GservicesValue<Long> recordIntervalSecs = GservicesValue.value("gms:stats:netstats:record_interval_secs", Long.valueOf(TimeUnit.DAYS.toSeconds(1)));

        public static final class patterns {
            public static final GservicesValue<String> BUCKET = GservicesValue.value("gms:stats:netstats:pattern:bucket", NetstatsParserPatterns.BUCKET_PATTERN);
            public static final GservicesValue<String> HISTORY = GservicesValue.value("gms:stats:netstats:pattern:history", NetstatsParserPatterns.HISTORY_PATTERN);
            public static final GservicesValue<String> IDENT = GservicesValue.value("gms:stats:netstats:pattern:ident", NetstatsParserPatterns.IDENT_PATTERN);
            public static final GservicesValue<String> IDENTS = GservicesValue.value("gms:stats:netstats:pattern:idents", NetstatsParserPatterns.IDENTS_PATTERN);
            public static final GservicesValue<Integer> TAG_RADIX = GservicesValue.value("gms:stats:netstats:pattern:tag_radix", Integer.valueOf(16));
            public static final GservicesValue<Integer> TS_TO_MILLIS = GservicesValue.value("gms:stats:netstats:pattern:ts_to_millis", Integer.valueOf(NetstatsParserPatterns.TS_TO_MILLIS));
            public static final GservicesValue<String> TYPE_BACKGROUND = GservicesValue.value("gms:stats:netstats:pattern:type_background", "DEFAULT");
            public static final GservicesValue<String> TYPE_BOTH = GservicesValue.value("gms:stats:netstats:pattern:type_both", NetstatsParserPatterns.TYPE_BOTH_PATTERN);
            public static final GservicesValue<String> TYPE_DEBUG_VPN_IN_PATTERN = GservicesValue.value("gms:stats:netstats:pattern:type_debug_vpn_in_pattern", NetstatsParserPatterns.TYPE_DEBUG_VPN_IN_PATTERN);
            public static final GservicesValue<String> TYPE_DEBUG_VPN_OUT_PATTERN = GservicesValue.value("gms:stats:netstats:pattern:type_debug_vpn_out_pattern", NetstatsParserPatterns.TYPE_DEBUG_VPN_OUT_PATTERN);
            public static final GservicesValue<String> TYPE_FOREGROUND = GservicesValue.value("gms:stats:netstats:pattern:type_foreground", NetstatsParserPatterns.TYPE_FOREGROUND_PATTERN);
            public static final GservicesValue<String> UID_STATS_START = GservicesValue.value("gms:stats:netstats:pattern:uid_start", NetstatsParserPatterns.UID_STATS_START_PATTERN);
            public static final GservicesValue<String> UID_TAG_STATS_START = GservicesValue.value("gms:stats:netstats:pattern:uid_tag_start", NetstatsParserPatterns.UID_TAG_STATS_START_PATTERN);

            static {
                AppMethodBeat.i(113976);
                AppMethodBeat.o(113976);
            }

            private patterns() {
            }
        }

        static {
            AppMethodBeat.i(113977);
            AppMethodBeat.o(113977);
        }

        private netStats() {
        }
    }
}
