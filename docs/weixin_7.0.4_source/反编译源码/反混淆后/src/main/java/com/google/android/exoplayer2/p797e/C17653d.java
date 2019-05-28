package com.google.android.exoplayer2.p797e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.e.d */
public final class C17653d {
    private static final C45029a beN = new C45029a("OMX.google.raw.decoder", null, null, false, false);
    private static final Pattern beO = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<C8665a, List<C45029a>> beP = new HashMap();
    private static final SparseIntArray beQ;
    private static final SparseIntArray beR;
    private static final Map<String, Integer> beS;
    private static int beT = -1;

    /* renamed from: com.google.android.exoplayer2.e.d$a */
    static final class C8665a {
        public final boolean bdY;
        public final String mimeType;

        public C8665a(String str, boolean z) {
            this.mimeType = str;
            this.bdY = z;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(95239);
            int hashCode = (this.bdY ? 1231 : 1237) + (((this.mimeType == null ? 0 : this.mimeType.hashCode()) + 31) * 31);
            AppMethodBeat.m2505o(95239);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(95240);
            if (this == obj) {
                AppMethodBeat.m2505o(95240);
                return true;
            } else if (obj == null || obj.getClass() != C8665a.class) {
                AppMethodBeat.m2505o(95240);
                return false;
            } else {
                C8665a c8665a = (C8665a) obj;
                if (TextUtils.equals(this.mimeType, c8665a.mimeType) && this.bdY == c8665a.bdY) {
                    AppMethodBeat.m2505o(95240);
                    return true;
                }
                AppMethodBeat.m2505o(95240);
                return false;
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.e.d$c */
    interface C8666c {
        /* renamed from: a */
        boolean mo19165a(String str, CodecCapabilities codecCapabilities);

        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);

        /* renamed from: rL */
        boolean mo19168rL();
    }

    /* renamed from: com.google.android.exoplayer2.e.d$b */
    public static class C17654b extends Exception {
        /* synthetic */ C17654b(Throwable th, byte b) {
            this(th);
        }

        private C17654b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* renamed from: com.google.android.exoplayer2.e.d$d */
    static final class C17655d implements C8666c {
        private C17655d() {
        }

        /* synthetic */ C17655d(byte b) {
            this();
        }

        public final int getCodecCount() {
            AppMethodBeat.m2504i(95241);
            int codecCount = MediaCodecList.getCodecCount();
            AppMethodBeat.m2505o(95241);
            return codecCount;
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            AppMethodBeat.m2504i(95242);
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            AppMethodBeat.m2505o(95242);
            return codecInfoAt;
        }

        /* renamed from: rL */
        public final boolean mo19168rL() {
            return false;
        }

        /* renamed from: a */
        public final boolean mo19165a(String str, CodecCapabilities codecCapabilities) {
            AppMethodBeat.m2504i(95243);
            boolean equals = "video/avc".equals(str);
            AppMethodBeat.m2505o(95243);
            return equals;
        }
    }

    @TargetApi(21)
    /* renamed from: com.google.android.exoplayer2.e.d$e */
    static final class C17656e implements C8666c {
        private final int beU;
        private MediaCodecInfo[] beV;

        public C17656e(boolean z) {
            AppMethodBeat.m2504i(95244);
            this.beU = z ? 1 : 0;
            AppMethodBeat.m2505o(95244);
        }

        public final int getCodecCount() {
            AppMethodBeat.m2504i(95245);
            m27512rM();
            int length = this.beV.length;
            AppMethodBeat.m2505o(95245);
            return length;
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            AppMethodBeat.m2504i(95246);
            m27512rM();
            MediaCodecInfo mediaCodecInfo = this.beV[i];
            AppMethodBeat.m2505o(95246);
            return mediaCodecInfo;
        }

        /* renamed from: rL */
        public final boolean mo19168rL() {
            return true;
        }

        /* renamed from: a */
        public final boolean mo19165a(String str, CodecCapabilities codecCapabilities) {
            AppMethodBeat.m2504i(95247);
            boolean isFeatureSupported = codecCapabilities.isFeatureSupported("secure-playback");
            AppMethodBeat.m2505o(95247);
            return isFeatureSupported;
        }

        /* renamed from: rM */
        private void m27512rM() {
            AppMethodBeat.m2504i(95248);
            if (this.beV == null) {
                this.beV = new MediaCodecList(this.beU).getCodecInfos();
            }
            AppMethodBeat.m2505o(95248);
        }
    }

    static {
        AppMethodBeat.m2504i(95256);
        SparseIntArray sparseIntArray = new SparseIntArray();
        beQ = sparseIntArray;
        sparseIntArray.put(66, 1);
        beQ.put(77, 2);
        beQ.put(88, 4);
        beQ.put(100, 8);
        sparseIntArray = new SparseIntArray();
        beR = sparseIntArray;
        sparseIntArray.put(10, 1);
        beR.put(11, 4);
        beR.put(12, 8);
        beR.put(13, 16);
        beR.put(20, 32);
        beR.put(21, 64);
        beR.put(22, 128);
        beR.put(30, 256);
        beR.put(31, 512);
        beR.put(32, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        beR.put(40, 2048);
        beR.put(41, 4096);
        beR.put(42, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        beR.put(50, 16384);
        beR.put(51, 32768);
        beR.put(52, 65536);
        HashMap hashMap = new HashMap();
        beS = hashMap;
        hashMap.put("L30", Integer.valueOf(1));
        beS.put("L60", Integer.valueOf(4));
        beS.put("L63", Integer.valueOf(16));
        beS.put("L90", Integer.valueOf(64));
        beS.put("L93", Integer.valueOf(256));
        beS.put("L120", Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        beS.put("L123", Integer.valueOf(4096));
        beS.put("L150", Integer.valueOf(16384));
        beS.put("L153", Integer.valueOf(65536));
        beS.put("L156", Integer.valueOf(262144));
        beS.put("L180", Integer.valueOf(1048576));
        beS.put("L183", Integer.valueOf(4194304));
        beS.put("L186", Integer.valueOf(16777216));
        beS.put("H30", Integer.valueOf(2));
        beS.put("H60", Integer.valueOf(8));
        beS.put("H63", Integer.valueOf(32));
        beS.put("H90", Integer.valueOf(128));
        beS.put("H93", Integer.valueOf(512));
        beS.put("H120", Integer.valueOf(2048));
        beS.put("H123", Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE));
        beS.put("H150", Integer.valueOf(32768));
        beS.put("H153", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        beS.put("H156", Integer.valueOf(SQLiteGlobal.journalSizeLimit));
        beS.put("H180", Integer.valueOf(2097152));
        beS.put("H183", Integer.valueOf(8388608));
        beS.put("H186", Integer.valueOf(33554432));
        AppMethodBeat.m2505o(95256);
    }

    /* renamed from: rJ */
    public static C45029a m27507rJ() {
        return beN;
    }

    /* renamed from: e */
    public static C45029a m27505e(String str, boolean z) {
        AppMethodBeat.m2504i(95249);
        List f = C17653d.m27506f(str, z);
        if (f.isEmpty()) {
            AppMethodBeat.m2505o(95249);
            return null;
        }
        C45029a c45029a = (C45029a) f.get(0);
        AppMethodBeat.m2505o(95249);
        return c45029a;
    }

    /* renamed from: f */
    private static synchronized List<C45029a> m27506f(String str, boolean z) {
        List<C45029a> list;
        synchronized (C17653d.class) {
            AppMethodBeat.m2504i(95250);
            C8665a c8665a = new C8665a(str, z);
            list = (List) beP.get(c8665a);
            if (list != null) {
                AppMethodBeat.m2505o(95250);
            } else {
                List a = C17653d.m27502a(c8665a, C17675v.SDK_INT >= 21 ? new C17656e(z) : new C17655d());
                if (z && a.isEmpty() && 21 <= C17675v.SDK_INT && C17675v.SDK_INT <= 23) {
                    List a2 = C17653d.m27502a(c8665a, new C17655d());
                    if (!a2.isEmpty()) {
                        new StringBuilder("MediaCodecList API didn't list secure decoder for: ").append(str).append(". Assuming: ").append(((C45029a) a2.get(0)).name);
                    }
                    a = a2;
                }
                C17653d.m27509v(a);
                list = Collections.unmodifiableList(a);
                beP.put(c8665a, list);
                AppMethodBeat.m2505o(95250);
            }
        }
        return list;
    }

    /* renamed from: rK */
    public static int m27508rK() {
        int i = 0;
        AppMethodBeat.m2504i(95251);
        if (beT == -1) {
            C45029a e = C17653d.m27505e("video/avc", false);
            if (e != null) {
                int i2 = 0;
                for (CodecProfileLevel codecProfileLevel : e.mo72546rD()) {
                    switch (codecProfileLevel.level) {
                        case 1:
                            i = 25344;
                            break;
                        case 2:
                            i = 25344;
                            break;
                        case 8:
                            i = 101376;
                            break;
                        case 16:
                            i = 101376;
                            break;
                        case 32:
                            i = 101376;
                            break;
                        case 64:
                            i = 202752;
                            break;
                        case 128:
                            i = 414720;
                            break;
                        case 256:
                            i = 414720;
                            break;
                        case 512:
                            i = Downloads.SPLIT_RANGE_SIZE_NET;
                            break;
                        case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                            i = 1310720;
                            break;
                        case 2048:
                            i = 2097152;
                            break;
                        case 4096:
                            i = 2097152;
                            break;
                        case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                            i = 2228224;
                            break;
                        case 16384:
                            i = 5652480;
                            break;
                        case 32768:
                            i = 9437184;
                            break;
                        case 65536:
                            i = 9437184;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    i2 = Math.max(i, i2);
                }
                i = Math.max(i2, C17675v.SDK_INT >= 21 ? 345600 : 172800);
            }
            beT = i;
        }
        i = beT;
        AppMethodBeat.m2505o(95251);
        return i;
    }

    /* JADX WARNING: Missing block: B:9:0x0032, code skipped:
            if (r6.equals("hev1") != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ay */
    public static Pair<Integer, Integer> m27503ay(String str) {
        int i = 0;
        AppMethodBeat.m2504i(95252);
        if (str == null) {
            AppMethodBeat.m2505o(95252);
            return null;
        }
        String[] split = str.split("\\.");
        String str2 = split[0];
        switch (str2.hashCode()) {
            case 3006243:
                if (str2.equals("avc1")) {
                    i = 2;
                    break;
                }
            case 3006244:
                if (str2.equals("avc2")) {
                    i = 3;
                    break;
                }
            case 3199032:
                break;
            case 3214780:
                if (str2.equals("hvc1")) {
                    i = 1;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case 0:
            case 1:
                if (split.length < 4) {
                    AppMethodBeat.m2505o(95252);
                    return null;
                }
                Matcher matcher = beO.matcher(split[1]);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if ("1".equals(group)) {
                        i = 1;
                    } else if ("2".equals(group)) {
                        i = 2;
                    } else {
                        AppMethodBeat.m2505o(95252);
                        return null;
                    }
                    Integer num = (Integer) beS.get(split[3]);
                    if (num == null) {
                        new StringBuilder("Unknown HEVC level string: ").append(matcher.group(1));
                        AppMethodBeat.m2505o(95252);
                        return null;
                    }
                    Pair<Integer, Integer> pair = new Pair(Integer.valueOf(i), num);
                    AppMethodBeat.m2505o(95252);
                    return pair;
                }
                AppMethodBeat.m2505o(95252);
                return null;
            case 2:
            case 3:
                Pair<Integer, Integer> e = C17653d.m27504e(split);
                AppMethodBeat.m2505o(95252);
                return e;
            default:
                AppMethodBeat.m2505o(95252);
                return null;
        }
    }

    /* renamed from: a */
    private static List<C45029a> m27502a(C8665a c8665a, C8666c c8666c) {
        AppMethodBeat.m2504i(95253);
        ArrayList arrayList = new ArrayList();
        String str = c8665a.mimeType;
        int codecCount = c8666c.getCodecCount();
        boolean rL = c8666c.mo19168rL();
        loop0:
        for (int i = 0; i < codecCount; i++) {
            Object obj;
            MediaCodecInfo codecInfoAt = c8666c.getCodecInfoAt(i);
            String name = codecInfoAt.getName();
            if (codecInfoAt.isEncoder() || (!rL && name.endsWith(".secure"))) {
                obj = null;
            } else if (C17675v.SDK_INT < 21 && ("CIPAACDecoder".equals(name) || "CIPMP3Decoder".equals(name) || "CIPVorbisDecoder".equals(name) || "CIPAMRNBDecoder".equals(name) || "AACDecoder".equals(name) || "MP3Decoder".equals(name))) {
                obj = null;
            } else if (C17675v.SDK_INT < 18 && "OMX.SEC.MP3.Decoder".equals(name)) {
                obj = null;
            } else if (C17675v.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(name) && ("a70".equals(C17675v.DEVICE) || ("Xiaomi".equals(C17675v.MANUFACTURER) && C17675v.DEVICE.startsWith("HM")))) {
                obj = null;
            } else if (C17675v.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(name) && ("dlxu".equals(C17675v.DEVICE) || "protou".equals(C17675v.DEVICE) || "ville".equals(C17675v.DEVICE) || "villeplus".equals(C17675v.DEVICE) || "villec2".equals(C17675v.DEVICE) || C17675v.DEVICE.startsWith("gee") || "C6602".equals(C17675v.DEVICE) || "C6603".equals(C17675v.DEVICE) || "C6606".equals(C17675v.DEVICE) || "C6616".equals(C17675v.DEVICE) || "L36h".equals(C17675v.DEVICE) || "SO-02E".equals(C17675v.DEVICE))) {
                obj = null;
            } else if (C17675v.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(name) && ("C1504".equals(C17675v.DEVICE) || "C1505".equals(C17675v.DEVICE) || "C1604".equals(C17675v.DEVICE) || "C1605".equals(C17675v.DEVICE))) {
                obj = null;
            } else if (C17675v.SDK_INT < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && C17675v.MANUFACTURER.equals("samsung") && (C17675v.DEVICE.startsWith("zeroflte") || C17675v.DEVICE.startsWith("zerolte") || C17675v.DEVICE.startsWith("zenlte") || C17675v.DEVICE.equals("SC-05G") || C17675v.DEVICE.equals("marinelteatt") || C17675v.DEVICE.equals("404SC") || C17675v.DEVICE.equals("SC-04G") || C17675v.DEVICE.equals("SCV31")))) {
                obj = null;
            } else if (C17675v.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(name) && "samsung".equals(C17675v.MANUFACTURER) && (C17675v.DEVICE.startsWith("d2") || C17675v.DEVICE.startsWith("serrano") || C17675v.DEVICE.startsWith("jflte") || C17675v.DEVICE.startsWith("santos") || C17675v.DEVICE.startsWith("t0"))) {
                obj = null;
            } else if (C17675v.SDK_INT <= 19 && C17675v.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(name)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        try {
                            boolean z;
                            CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                            boolean a = c8666c.mo19165a(str, capabilitiesForType);
                            if (C17675v.SDK_INT > 22 || !((C17675v.MODEL.equals("ODROID-XU3") || C17675v.MODEL.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name)))) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if ((!rL || c8665a.bdY != a) && (rL || c8665a.bdY)) {
                                if (!rL && a) {
                                    arrayList.add(C45029a.m82520a(name + ".secure", str, capabilitiesForType, z, true));
                                    AppMethodBeat.m2505o(95253);
                                    break loop0;
                                }
                            }
                            arrayList.add(C45029a.m82520a(name, str, capabilitiesForType, z, false));
                        } catch (Exception e) {
                            if (C17675v.SDK_INT > 23 || arrayList.isEmpty()) {
                                new StringBuilder("Failed to query codec ").append(name).append(" (").append(str2).append(")");
                                AppMethodBeat.m2505o(95253);
                                throw e;
                            }
                            new StringBuilder("Skipping codec ").append(name).append(" (failed to query capabilities)");
                        } catch (Exception e2) {
                            C17654b c17654b = new C17654b(e2, (byte) 0);
                            AppMethodBeat.m2505o(95253);
                            throw c17654b;
                        }
                    }
                }
                continue;
            }
        }
        AppMethodBeat.m2505o(95253);
        return arrayList;
    }

    /* renamed from: v */
    private static void m27509v(List<C45029a> list) {
        int i = 1;
        AppMethodBeat.m2504i(95254);
        if (C17675v.SDK_INT < 26 && list.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(((C45029a) list.get(0)).name)) {
            while (i < list.size()) {
                C45029a c45029a = (C45029a) list.get(i);
                if ("OMX.google.raw.decoder".equals(c45029a.name)) {
                    list.remove(i);
                    list.add(0, c45029a);
                    AppMethodBeat.m2505o(95254);
                    return;
                }
                i++;
            }
        }
        AppMethodBeat.m2505o(95254);
    }

    /* renamed from: e */
    private static Pair<Integer, Integer> m27504e(String[] strArr) {
        AppMethodBeat.m2504i(95255);
        if (strArr.length < 2) {
            AppMethodBeat.m2505o(95255);
            return null;
        }
        try {
            Integer valueOf;
            Integer valueOf2;
            if (strArr[1].length() == 6) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                AppMethodBeat.m2505o(95255);
                return null;
            }
            Integer valueOf3 = Integer.valueOf(beQ.get(valueOf.intValue()));
            if (valueOf3 == null) {
                new StringBuilder("Unknown AVC profile: ").append(valueOf);
                AppMethodBeat.m2505o(95255);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(beR.get(valueOf2.intValue()));
            if (valueOf4 == null) {
                new StringBuilder("Unknown AVC level: ").append(valueOf2);
                AppMethodBeat.m2505o(95255);
                return null;
            }
            Pair<Integer, Integer> pair = new Pair(valueOf3, valueOf4);
            AppMethodBeat.m2505o(95255);
            return pair;
        } catch (NumberFormatException e) {
            AppMethodBeat.m2505o(95255);
            return null;
        }
    }
}
