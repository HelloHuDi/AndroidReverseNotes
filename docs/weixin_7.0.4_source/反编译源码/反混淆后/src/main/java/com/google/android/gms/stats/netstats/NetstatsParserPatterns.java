package com.google.android.gms.stats.netstats;

import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.stats.internal.C45058G.netStats.patterns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetstatsParserPatterns {
    public static final String BUCKET_PATTERN = (PlatformVersion.isAtLeastLollipopMR1() ? NEW_BUCKET_PATTERN : OLD_BUCKET_PATTERN);
    public static final String HISTORY_PATTERN = ".*bucketDuration=(?<duration>[0-9]+).*";
    public static final String IDENTS_PATTERN = " *ident=\\[(?<idents>.*)\\](?: uid=(?<uid>-?[0-9]+))?(?: set=(?<set>\\w+))?(?: tag=0x(?<tag>[0-9a-f]+))?.*";
    public static final String IDENT_PATTERN = (PlatformVersion.isAtLeastLollipopMR1() ? NEW_IDENT_PATTERN : OLD_IDENT_PATTERN);
    public static final String NEW_BUCKET_PATTERN = " *st=(?<start>[0-9]+)(?: rb=(?<rxBytes>[0-9]+))?(?: rp=(?<rxPackets>[0-9]+))?(?: tb=(?<txBytes>[0-9]+))?(?: tp=(?<txPackets>[0-9]+))?(?: op=(?<operations>[0-9]+))?.*";
    public static final String NEW_IDENT_PATTERN = "[\\[{](?:type=(?<type>-1|\\w+))[, ]*(?:subType=(?<subtype>[^,]+))?[, ]*(?:subscriberId=(?<subscriberId>[0-9]+)(?:...)?)?[, ]*(?<roaming>ROAMING)?[^\\]}]*[\\]}]";
    public static final int NEW_TS_TO_MILLIS = 1000;
    public static final String OLD_BUCKET_PATTERN = " *bucketStart=(?<start>[0-9]+)(?: activeTime=(?<active>[0-9]+))?(?: rxBytes=(?<rxBytes>[0-9]+))?(?: rxPackets=(?<rxPackets>[0-9]+))?(?: txBytes=(?<txBytes>[0-9]+))?(?: txPackets=(?<txPackets>[0-9]+))?(?: operations=(?<operations>[0-9]+))?.*";
    public static final String OLD_IDENT_PATTERN = "\\[(?:type=(?<type>-1|\\w+))[, ]*(?:subType=(?<subtype>[^,]+))?[, ]*(?:subscriberId=(?<subscriberId>[0-9]+)(?:...)?)?[, ]*(?<roaming>ROAMING)?[^]]*\\]";
    public static final int OLD_TS_TO_MILLIS = 1;
    public static final int TS_TO_MILLIS = (PlatformVersion.isAtLeastLollipopMR1() ? 1000 : 1);
    public static final String TYPE_BACKGROUND_PATTERN = "DEFAULT";
    public static final String TYPE_BOTH_PATTERN = "ALL";
    public static final String TYPE_DEBUG_VPN_IN_PATTERN = "DBG_VPN_IN";
    public static final String TYPE_DEBUG_VPN_OUT_PATTERN = "DBG_VPN_OUT";
    public static final String TYPE_FOREGROUND_PATTERN = "FOREGROUND";
    public static final String UID_STATS_START_PATTERN = "UID stats:|Detailed UID stats:";
    public static final String UID_TAG_STATS_START_PATTERN = "UID tag stats:";
    private static final Pattern zzafe = Pattern.compile("\\?<([a-zA-Z0-9]+)>");
    private Pattern zzaen;
    private Map<String, Integer> zzaeo;
    private Pattern zzaep;
    private Map<String, Integer> zzaeq;
    private Pattern zzaer;
    private Map<String, Integer> zzaes;
    private Pattern zzaet;
    private Map<String, Integer> zzaeu;
    private Pattern zzaev = Pattern.compile((String) patterns.UID_STATS_START.getBinderSafe());
    private Pattern zzaew = Pattern.compile((String) patterns.UID_TAG_STATS_START.getBinderSafe());
    private Pattern zzaex = Pattern.compile((String) patterns.TYPE_BOTH.getBinderSafe());
    private Pattern zzaey = Pattern.compile((String) patterns.TYPE_BACKGROUND.getBinderSafe());
    private Pattern zzaez = Pattern.compile((String) patterns.TYPE_FOREGROUND.getBinderSafe());
    private Pattern zzafa = Pattern.compile((String) patterns.TYPE_DEBUG_VPN_IN_PATTERN.getBinderSafe());
    private Pattern zzafb = Pattern.compile((String) patterns.TYPE_DEBUG_VPN_OUT_PATTERN.getBinderSafe());
    private int zzafc = ((Integer) patterns.TAG_RADIX.getBinderSafe()).intValue();
    private int zzafd = ((Integer) patterns.TS_TO_MILLIS.getBinderSafe()).intValue();

    public static class NetstatsMatcher {
        private Matcher zzaff;
        private Map<String, Integer> zzafg;

        public NetstatsMatcher(Matcher matcher, Map<String, Integer> map) {
            this.zzaff = matcher;
            this.zzafg = map;
        }

        public boolean find() {
            AppMethodBeat.m2504i(113979);
            boolean find = this.zzaff.find();
            AppMethodBeat.m2505o(113979);
            return find;
        }

        public String get(String str) {
            AppMethodBeat.m2504i(113980);
            String group;
            if (this.zzafg.containsKey(str)) {
                group = this.zzaff.group(((Integer) this.zzafg.get(str)).intValue());
                AppMethodBeat.m2505o(113980);
                return group;
            }
            String str2 = "Unknown group ";
            group = String.valueOf(str);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(group.length() != 0 ? str2.concat(group) : new String(str2));
            AppMethodBeat.m2505o(113980);
            throw illegalArgumentException;
        }

        public boolean matches() {
            AppMethodBeat.m2504i(113978);
            boolean matches = this.zzaff.matches();
            AppMethodBeat.m2505o(113978);
            return matches;
        }
    }

    static {
        AppMethodBeat.m2504i(113994);
        AppMethodBeat.m2505o(113994);
    }

    public NetstatsParserPatterns() {
        AppMethodBeat.m2504i(113981);
        String str = (String) patterns.IDENTS.getBinderSafe();
        this.zzaen = zzp(str);
        this.zzaeo = zzo(str);
        str = (String) patterns.IDENT.getBinderSafe();
        this.zzaep = zzp(str);
        this.zzaeq = zzo(str);
        str = (String) patterns.HISTORY.getBinderSafe();
        this.zzaer = zzp(str);
        this.zzaes = zzo(str);
        str = (String) patterns.BUCKET.getBinderSafe();
        this.zzaet = zzp(str);
        this.zzaeu = zzo(str);
        AppMethodBeat.m2505o(113981);
    }

    private static Map<String, Integer> zzo(String str) {
        AppMethodBeat.m2504i(113982);
        HashMap hashMap = new HashMap();
        Matcher matcher = zzafe.matcher(str);
        int i = 1;
        while (matcher.find()) {
            hashMap.put(matcher.group(1), Integer.valueOf(i));
            i++;
        }
        AppMethodBeat.m2505o(113982);
        return hashMap;
    }

    private static Pattern zzp(String str) {
        AppMethodBeat.m2504i(113983);
        Pattern compile = Pattern.compile(zzafe.matcher(str).replaceAll(""));
        AppMethodBeat.m2505o(113983);
        return compile;
    }

    public NetstatsMatcher bucket(String str) {
        AppMethodBeat.m2504i(113987);
        NetstatsMatcher netstatsMatcher = new NetstatsMatcher(this.zzaet.matcher(str), this.zzaeu);
        AppMethodBeat.m2505o(113987);
        return netstatsMatcher;
    }

    public NetstatsMatcher history(String str) {
        AppMethodBeat.m2504i(113986);
        NetstatsMatcher netstatsMatcher = new NetstatsMatcher(this.zzaer.matcher(str), this.zzaes);
        AppMethodBeat.m2505o(113986);
        return netstatsMatcher;
    }

    public NetstatsMatcher ident(String str) {
        AppMethodBeat.m2504i(113985);
        NetstatsMatcher netstatsMatcher = new NetstatsMatcher(this.zzaep.matcher(str), this.zzaeq);
        AppMethodBeat.m2505o(113985);
        return netstatsMatcher;
    }

    public NetstatsMatcher idents(String str) {
        AppMethodBeat.m2504i(113984);
        NetstatsMatcher netstatsMatcher = new NetstatsMatcher(this.zzaen.matcher(str), this.zzaeo);
        AppMethodBeat.m2505o(113984);
        return netstatsMatcher;
    }

    public boolean isTypeBackground(String str) {
        AppMethodBeat.m2504i(113991);
        boolean matches = this.zzaey.matcher(str).matches();
        AppMethodBeat.m2505o(113991);
        return matches;
    }

    public boolean isTypeBoth(String str) {
        AppMethodBeat.m2504i(113990);
        boolean matches = this.zzaex.matcher(str).matches();
        AppMethodBeat.m2505o(113990);
        return matches;
    }

    public boolean isTypeDebugVpn(String str) {
        AppMethodBeat.m2504i(113993);
        if (this.zzafa.matcher(str).matches() || this.zzafb.matcher(str).matches()) {
            AppMethodBeat.m2505o(113993);
            return true;
        }
        AppMethodBeat.m2505o(113993);
        return false;
    }

    public boolean isTypeForeground(String str) {
        AppMethodBeat.m2504i(113992);
        boolean matches = this.zzaez.matcher(str).matches();
        AppMethodBeat.m2505o(113992);
        return matches;
    }

    public boolean isUidStart(String str) {
        AppMethodBeat.m2504i(113988);
        boolean matches = this.zzaev.matcher(str).matches();
        AppMethodBeat.m2505o(113988);
        return matches;
    }

    public boolean isUidTagStart(String str) {
        AppMethodBeat.m2504i(113989);
        boolean matches = this.zzaew.matcher(str).matches();
        AppMethodBeat.m2505o(113989);
        return matches;
    }

    public int tagRadix() {
        return this.zzafc;
    }

    public long toMillis(long j) {
        return ((long) this.zzafd) * j;
    }
}
