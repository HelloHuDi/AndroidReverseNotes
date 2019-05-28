package com.google.android.exoplayer2.e;

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
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
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
public final class d {
    private static final a beN = new a("OMX.google.raw.decoder", null, null, false, false);
    private static final Pattern beO = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<a>> beP = new HashMap();
    private static final SparseIntArray beQ;
    private static final SparseIntArray beR;
    private static final Map<String, Integer> beS;
    private static int beT = -1;

    static final class a {
        public final boolean bdY;
        public final String mimeType;

        public a(String str, boolean z) {
            this.mimeType = str;
            this.bdY = z;
        }

        public final int hashCode() {
            AppMethodBeat.i(95239);
            int hashCode = (this.bdY ? 1231 : 1237) + (((this.mimeType == null ? 0 : this.mimeType.hashCode()) + 31) * 31);
            AppMethodBeat.o(95239);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(95240);
            if (this == obj) {
                AppMethodBeat.o(95240);
                return true;
            } else if (obj == null || obj.getClass() != a.class) {
                AppMethodBeat.o(95240);
                return false;
            } else {
                a aVar = (a) obj;
                if (TextUtils.equals(this.mimeType, aVar.mimeType) && this.bdY == aVar.bdY) {
                    AppMethodBeat.o(95240);
                    return true;
                }
                AppMethodBeat.o(95240);
                return false;
            }
        }
    }

    interface c {
        boolean a(String str, CodecCapabilities codecCapabilities);

        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);

        boolean rL();
    }

    public static class b extends Exception {
        /* synthetic */ b(Throwable th, byte b) {
            this(th);
        }

        private b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    static final class d implements c {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final int getCodecCount() {
            AppMethodBeat.i(95241);
            int codecCount = MediaCodecList.getCodecCount();
            AppMethodBeat.o(95241);
            return codecCount;
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            AppMethodBeat.i(95242);
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            AppMethodBeat.o(95242);
            return codecInfoAt;
        }

        public final boolean rL() {
            return false;
        }

        public final boolean a(String str, CodecCapabilities codecCapabilities) {
            AppMethodBeat.i(95243);
            boolean equals = "video/avc".equals(str);
            AppMethodBeat.o(95243);
            return equals;
        }
    }

    @TargetApi(21)
    static final class e implements c {
        private final int beU;
        private MediaCodecInfo[] beV;

        public e(boolean z) {
            AppMethodBeat.i(95244);
            this.beU = z ? 1 : 0;
            AppMethodBeat.o(95244);
        }

        public final int getCodecCount() {
            AppMethodBeat.i(95245);
            rM();
            int length = this.beV.length;
            AppMethodBeat.o(95245);
            return length;
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            AppMethodBeat.i(95246);
            rM();
            MediaCodecInfo mediaCodecInfo = this.beV[i];
            AppMethodBeat.o(95246);
            return mediaCodecInfo;
        }

        public final boolean rL() {
            return true;
        }

        public final boolean a(String str, CodecCapabilities codecCapabilities) {
            AppMethodBeat.i(95247);
            boolean isFeatureSupported = codecCapabilities.isFeatureSupported("secure-playback");
            AppMethodBeat.o(95247);
            return isFeatureSupported;
        }

        private void rM() {
            AppMethodBeat.i(95248);
            if (this.beV == null) {
                this.beV = new MediaCodecList(this.beU).getCodecInfos();
            }
            AppMethodBeat.o(95248);
        }
    }

    static {
        AppMethodBeat.i(95256);
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
        AppMethodBeat.o(95256);
    }

    public static a rJ() {
        return beN;
    }

    public static a e(String str, boolean z) {
        AppMethodBeat.i(95249);
        List f = f(str, z);
        if (f.isEmpty()) {
            AppMethodBeat.o(95249);
            return null;
        }
        a aVar = (a) f.get(0);
        AppMethodBeat.o(95249);
        return aVar;
    }

    private static synchronized List<a> f(String str, boolean z) {
        List<a> list;
        synchronized (d.class) {
            AppMethodBeat.i(95250);
            a aVar = new a(str, z);
            list = (List) beP.get(aVar);
            if (list != null) {
                AppMethodBeat.o(95250);
            } else {
                List a = a(aVar, v.SDK_INT >= 21 ? new e(z) : new d());
                if (z && a.isEmpty() && 21 <= v.SDK_INT && v.SDK_INT <= 23) {
                    List a2 = a(aVar, new d());
                    if (!a2.isEmpty()) {
                        new StringBuilder("MediaCodecList API didn't list secure decoder for: ").append(str).append(". Assuming: ").append(((a) a2.get(0)).name);
                    }
                    a = a2;
                }
                v(a);
                list = Collections.unmodifiableList(a);
                beP.put(aVar, list);
                AppMethodBeat.o(95250);
            }
        }
        return list;
    }

    public static int rK() {
        int i = 0;
        AppMethodBeat.i(95251);
        if (beT == -1) {
            a e = e("video/avc", false);
            if (e != null) {
                int i2 = 0;
                for (CodecProfileLevel codecProfileLevel : e.rD()) {
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
                i = Math.max(i2, v.SDK_INT >= 21 ? 345600 : 172800);
            }
            beT = i;
        }
        i = beT;
        AppMethodBeat.o(95251);
        return i;
    }

    /* JADX WARNING: Missing block: B:9:0x0032, code skipped:
            if (r6.equals("hev1") != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Pair<Integer, Integer> ay(String str) {
        int i = 0;
        AppMethodBeat.i(95252);
        if (str == null) {
            AppMethodBeat.o(95252);
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
                    AppMethodBeat.o(95252);
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
                        AppMethodBeat.o(95252);
                        return null;
                    }
                    Integer num = (Integer) beS.get(split[3]);
                    if (num == null) {
                        new StringBuilder("Unknown HEVC level string: ").append(matcher.group(1));
                        AppMethodBeat.o(95252);
                        return null;
                    }
                    Pair<Integer, Integer> pair = new Pair(Integer.valueOf(i), num);
                    AppMethodBeat.o(95252);
                    return pair;
                }
                AppMethodBeat.o(95252);
                return null;
            case 2:
            case 3:
                Pair<Integer, Integer> e = e(split);
                AppMethodBeat.o(95252);
                return e;
            default:
                AppMethodBeat.o(95252);
                return null;
        }
    }

    private static List<a> a(a aVar, c cVar) {
        AppMethodBeat.i(95253);
        ArrayList arrayList = new ArrayList();
        String str = aVar.mimeType;
        int codecCount = cVar.getCodecCount();
        boolean rL = cVar.rL();
        loop0:
        for (int i = 0; i < codecCount; i++) {
            Object obj;
            MediaCodecInfo codecInfoAt = cVar.getCodecInfoAt(i);
            String name = codecInfoAt.getName();
            if (codecInfoAt.isEncoder() || (!rL && name.endsWith(".secure"))) {
                obj = null;
            } else if (v.SDK_INT < 21 && ("CIPAACDecoder".equals(name) || "CIPMP3Decoder".equals(name) || "CIPVorbisDecoder".equals(name) || "CIPAMRNBDecoder".equals(name) || "AACDecoder".equals(name) || "MP3Decoder".equals(name))) {
                obj = null;
            } else if (v.SDK_INT < 18 && "OMX.SEC.MP3.Decoder".equals(name)) {
                obj = null;
            } else if (v.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(name) && ("a70".equals(v.DEVICE) || ("Xiaomi".equals(v.MANUFACTURER) && v.DEVICE.startsWith("HM")))) {
                obj = null;
            } else if (v.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(name) && ("dlxu".equals(v.DEVICE) || "protou".equals(v.DEVICE) || "ville".equals(v.DEVICE) || "villeplus".equals(v.DEVICE) || "villec2".equals(v.DEVICE) || v.DEVICE.startsWith("gee") || "C6602".equals(v.DEVICE) || "C6603".equals(v.DEVICE) || "C6606".equals(v.DEVICE) || "C6616".equals(v.DEVICE) || "L36h".equals(v.DEVICE) || "SO-02E".equals(v.DEVICE))) {
                obj = null;
            } else if (v.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(name) && ("C1504".equals(v.DEVICE) || "C1505".equals(v.DEVICE) || "C1604".equals(v.DEVICE) || "C1605".equals(v.DEVICE))) {
                obj = null;
            } else if (v.SDK_INT < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && v.MANUFACTURER.equals("samsung") && (v.DEVICE.startsWith("zeroflte") || v.DEVICE.startsWith("zerolte") || v.DEVICE.startsWith("zenlte") || v.DEVICE.equals("SC-05G") || v.DEVICE.equals("marinelteatt") || v.DEVICE.equals("404SC") || v.DEVICE.equals("SC-04G") || v.DEVICE.equals("SCV31")))) {
                obj = null;
            } else if (v.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(name) && "samsung".equals(v.MANUFACTURER) && (v.DEVICE.startsWith("d2") || v.DEVICE.startsWith("serrano") || v.DEVICE.startsWith("jflte") || v.DEVICE.startsWith("santos") || v.DEVICE.startsWith("t0"))) {
                obj = null;
            } else if (v.SDK_INT <= 19 && v.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(name)) {
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
                            boolean a = cVar.a(str, capabilitiesForType);
                            if (v.SDK_INT > 22 || !((v.MODEL.equals("ODROID-XU3") || v.MODEL.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name)))) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if ((!rL || aVar.bdY != a) && (rL || aVar.bdY)) {
                                if (!rL && a) {
                                    arrayList.add(a.a(name + ".secure", str, capabilitiesForType, z, true));
                                    AppMethodBeat.o(95253);
                                    break loop0;
                                }
                            }
                            arrayList.add(a.a(name, str, capabilitiesForType, z, false));
                        } catch (Exception e) {
                            if (v.SDK_INT > 23 || arrayList.isEmpty()) {
                                new StringBuilder("Failed to query codec ").append(name).append(" (").append(str2).append(")");
                                AppMethodBeat.o(95253);
                                throw e;
                            }
                            new StringBuilder("Skipping codec ").append(name).append(" (failed to query capabilities)");
                        } catch (Exception e2) {
                            b bVar = new b(e2, (byte) 0);
                            AppMethodBeat.o(95253);
                            throw bVar;
                        }
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(95253);
        return arrayList;
    }

    private static void v(List<a> list) {
        int i = 1;
        AppMethodBeat.i(95254);
        if (v.SDK_INT < 26 && list.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(((a) list.get(0)).name)) {
            while (i < list.size()) {
                a aVar = (a) list.get(i);
                if ("OMX.google.raw.decoder".equals(aVar.name)) {
                    list.remove(i);
                    list.add(0, aVar);
                    AppMethodBeat.o(95254);
                    return;
                }
                i++;
            }
        }
        AppMethodBeat.o(95254);
    }

    private static Pair<Integer, Integer> e(String[] strArr) {
        AppMethodBeat.i(95255);
        if (strArr.length < 2) {
            AppMethodBeat.o(95255);
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
                AppMethodBeat.o(95255);
                return null;
            }
            Integer valueOf3 = Integer.valueOf(beQ.get(valueOf.intValue()));
            if (valueOf3 == null) {
                new StringBuilder("Unknown AVC profile: ").append(valueOf);
                AppMethodBeat.o(95255);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(beR.get(valueOf2.intValue()));
            if (valueOf4 == null) {
                new StringBuilder("Unknown AVC level: ").append(valueOf2);
                AppMethodBeat.o(95255);
                return null;
            }
            Pair<Integer, Integer> pair = new Pair(valueOf3, valueOf4);
            AppMethodBeat.o(95255);
            return pair;
        } catch (NumberFormatException e) {
            AppMethodBeat.o(95255);
            return null;
        }
    }
}
