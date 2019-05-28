package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.v4.f.a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzeb extends zzjq {
    zzeb(zzjr zzjr) {
        super(zzjr);
    }

    private final Boolean zza(double d, zzkg zzkg) {
        AppMethodBeat.i(68589);
        try {
            Boolean zza = zza(new BigDecimal(d), zzkg, Math.ulp(d));
            AppMethodBeat.o(68589);
            return zza;
        } catch (NumberFormatException e) {
            AppMethodBeat.o(68589);
            return null;
        }
    }

    private final Boolean zza(long j, zzkg zzkg) {
        AppMethodBeat.i(68588);
        try {
            Boolean zza = zza(new BigDecimal(j), zzkg, 0.0d);
            AppMethodBeat.o(68588);
            return zza;
        } catch (NumberFormatException e) {
            AppMethodBeat.o(68588);
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        AppMethodBeat.i(68585);
        if (bool == null) {
            AppMethodBeat.o(68585);
            return null;
        }
        Boolean valueOf = Boolean.valueOf(bool.booleanValue() ^ z);
        AppMethodBeat.o(68585);
        return valueOf;
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        AppMethodBeat.i(68587);
        if (str == null) {
            AppMethodBeat.o(68587);
            return null;
        }
        CharSequence str4;
        if (i == 6) {
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(68587);
                return null;
            }
        } else if (str2 == null) {
            AppMethodBeat.o(68587);
            return null;
        }
        if (!(z || i == 1)) {
            str4 = str4.toUpperCase(Locale.ENGLISH);
        }
        Boolean valueOf;
        switch (i) {
            case 1:
                try {
                    valueOf = Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str4).matches());
                    AppMethodBeat.o(68587);
                    return valueOf;
                } catch (PatternSyntaxException e) {
                    zzge().zzip().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    AppMethodBeat.o(68587);
                    return null;
                }
            case 2:
                valueOf = Boolean.valueOf(str4.startsWith(str2));
                AppMethodBeat.o(68587);
                return valueOf;
            case 3:
                valueOf = Boolean.valueOf(str4.endsWith(str2));
                AppMethodBeat.o(68587);
                return valueOf;
            case 4:
                valueOf = Boolean.valueOf(str4.contains(str2));
                AppMethodBeat.o(68587);
                return valueOf;
            case 5:
                valueOf = Boolean.valueOf(str4.equals(str2));
                AppMethodBeat.o(68587);
                return valueOf;
            case 6:
                valueOf = Boolean.valueOf(list.contains(str4));
                AppMethodBeat.o(68587);
                return valueOf;
            default:
                AppMethodBeat.o(68587);
                return null;
        }
    }

    private final Boolean zza(String str, zzkg zzkg) {
        Boolean bool = null;
        AppMethodBeat.i(68590);
        if (zzka.zzck(str)) {
            try {
                bool = zza(new BigDecimal(str), zzkg, 0.0d);
                AppMethodBeat.o(68590);
            } catch (NumberFormatException e) {
                AppMethodBeat.o(68590);
            }
        } else {
            AppMethodBeat.o(68590);
        }
        return bool;
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzki zzki) {
        int i = 0;
        String str2 = null;
        AppMethodBeat.i(68586);
        Preconditions.checkNotNull(zzki);
        if (str == null) {
            AppMethodBeat.o(68586);
            return null;
        } else if (zzki.zzash == null || zzki.zzash.intValue() == 0) {
            AppMethodBeat.o(68586);
            return null;
        } else {
            List list;
            if (zzki.zzash.intValue() == 6) {
                if (zzki.zzask == null || zzki.zzask.length == 0) {
                    AppMethodBeat.o(68586);
                    return null;
                }
            } else if (zzki.zzasi == null) {
                AppMethodBeat.o(68586);
                return null;
            }
            int intValue = zzki.zzash.intValue();
            boolean z = zzki.zzasj != null && zzki.zzasj.booleanValue();
            String toUpperCase = (z || intValue == 1 || intValue == 6) ? zzki.zzasi : zzki.zzasi.toUpperCase(Locale.ENGLISH);
            if (zzki.zzask == null) {
                list = null;
            } else {
                String[] strArr = zzki.zzask;
                if (z) {
                    list = Arrays.asList(strArr);
                } else {
                    list = new ArrayList();
                    int length = strArr.length;
                    while (i < length) {
                        list.add(strArr[i].toUpperCase(Locale.ENGLISH));
                        i++;
                    }
                }
            }
            if (intValue == 1) {
                str2 = toUpperCase;
            }
            Boolean zza = zza(str, intValue, z, toUpperCase, list, str2);
            AppMethodBeat.o(68586);
            return zza;
        }
    }

    /* JADX WARNING: Missing block: B:39:0x009d, code skipped:
            if (r5 != null) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @VisibleForTesting
    private static Boolean zza(BigDecimal bigDecimal, zzkg zzkg, double d) {
        boolean z = true;
        AppMethodBeat.i(68591);
        Preconditions.checkNotNull(zzkg);
        if (zzkg.zzarz == null || zzkg.zzarz.intValue() == 0) {
            AppMethodBeat.o(68591);
            return null;
        }
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        if (zzkg.zzarz.intValue() == 4) {
            if (zzkg.zzasc == null || zzkg.zzasd == null) {
                AppMethodBeat.o(68591);
                return null;
            }
        } else if (zzkg.zzasb == null) {
            AppMethodBeat.o(68591);
            return null;
        }
        int intValue = zzkg.zzarz.intValue();
        BigDecimal bigDecimal4;
        if (zzkg.zzarz.intValue() == 4) {
            if (zzka.zzck(zzkg.zzasc) && zzka.zzck(zzkg.zzasd)) {
                try {
                    bigDecimal2 = new BigDecimal(zzkg.zzasc);
                    bigDecimal4 = new BigDecimal(zzkg.zzasd);
                    bigDecimal3 = null;
                } catch (NumberFormatException e) {
                    AppMethodBeat.o(68591);
                    return null;
                }
            }
            AppMethodBeat.o(68591);
            return null;
        } else if (zzka.zzck(zzkg.zzasb)) {
            try {
                bigDecimal3 = new BigDecimal(zzkg.zzasb);
                bigDecimal4 = null;
                bigDecimal2 = null;
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(68591);
                return null;
            }
        } else {
            AppMethodBeat.o(68591);
            return null;
        }
        if (intValue == 4) {
            if (bigDecimal2 == null) {
                AppMethodBeat.o(68591);
                return null;
            }
        }
        Boolean valueOf;
        switch (intValue) {
            case 1:
                if (bigDecimal.compareTo(bigDecimal3) != -1) {
                    z = false;
                }
                valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(68591);
                return valueOf;
            case 2:
                if (bigDecimal.compareTo(bigDecimal3) != 1) {
                    z = false;
                }
                valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(68591);
                return valueOf;
            case 3:
                if (d != 0.0d) {
                    if (!(bigDecimal.compareTo(bigDecimal3.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal3.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1)) {
                        z = false;
                    }
                    valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(68591);
                    return valueOf;
                }
                if (bigDecimal.compareTo(bigDecimal3) != 0) {
                    z = false;
                }
                valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(68591);
                return valueOf;
            case 4:
                if (bigDecimal.compareTo(bigDecimal2) == -1 || bigDecimal.compareTo(bigDecimal4) == 1) {
                    z = false;
                }
                valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(68591);
                return valueOf;
        }
        AppMethodBeat.o(68591);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0775  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0778  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0482  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0be4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zzkm[] zza(String str, zzkn[] zzknArr, zzks[] zzksArr) {
        int intValue;
        zzkr zzkr;
        BitSet bitSet;
        BitSet bitSet2;
        int i;
        zzkm zzkm;
        zzei zzix;
        int i2;
        int length;
        Map map;
        Map map2;
        zzkm zzkm2;
        AppMethodBeat.i(68584);
        Preconditions.checkNotEmpty(str);
        HashSet hashSet = new HashSet();
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        Map zzbf = zzix().zzbf(str);
        if (zzbf != null) {
            for (Integer intValue2 : zzbf.keySet()) {
                intValue = intValue2.intValue();
                zzkr = (zzkr) zzbf.get(Integer.valueOf(intValue));
                bitSet = (BitSet) aVar2.get(Integer.valueOf(intValue));
                bitSet2 = (BitSet) aVar3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    aVar2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    aVar3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (i = 0; i < (zzkr.zzauk.length << 6); i++) {
                    if (zzka.zza(zzkr.zzauk, i)) {
                        zzge().zzit().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzka.zza(zzkr.zzaul, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                zzkm = new zzkm();
                aVar.put(Integer.valueOf(intValue), zzkm);
                zzkm.zzasy = Boolean.FALSE;
                zzkm.zzasx = zzkr;
                zzkm.zzasw = new zzkr();
                zzkm.zzasw.zzaul = zzka.zza(bitSet);
                zzkm.zzasw.zzauk = zzka.zza(bitSet2);
            }
        }
        if (zzknArr != null) {
            zzkn zzkn = null;
            long j = 0;
            Long l = null;
            a aVar4 = new a();
            int length2 = zzknArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                zzko[] zzkoArr;
                String str2;
                long j2;
                Long l2;
                zzkn zzkn2;
                zzeq zzf;
                zzeq zzeq;
                long j3;
                zzkn zzkn3 = zzknArr[i4];
                String str3 = zzkn3.name;
                zzko[] zzkoArr2 = zzkn3.zzata;
                if (zzgg().zzd(str, zzew.zzahv)) {
                    int length3;
                    zzko zzko;
                    zzgb();
                    Long l3 = (Long) zzka.zzb(zzkn3, "_eid");
                    Object obj = l3 != null ? 1 : null;
                    Object obj2 = (obj == null || !str3.equals("_ep")) ? null : 1;
                    if (obj2 != null) {
                        zzgb();
                        str3 = (String) zzka.zzb(zzkn3, "_en");
                        if (TextUtils.isEmpty(str3)) {
                            zzge().zzim().zzg("Extra parameter without an event name. eventId", l3);
                        } else {
                            Long l4;
                            if (zzkn == null || l == null || l3.longValue() != l.longValue()) {
                                Pair zza = zzix().zza(str, l3);
                                if (zza == null || zza.first == null) {
                                    zzge().zzim().zze("Extra parameter without existing main event. eventName, eventId", str3, l3);
                                } else {
                                    zzkn zzkn4 = (zzkn) zza.first;
                                    j = ((Long) zza.second).longValue();
                                    zzgb();
                                    l4 = (Long) zzka.zzb(zzkn4, "_eid");
                                    zzkn = zzkn4;
                                }
                            } else {
                                l4 = l;
                            }
                            j--;
                            if (j <= 0) {
                                zzix = zzix();
                                zzix.zzab();
                                zzix.zzge().zzit().zzg("Clearing complex main event info. appId", str);
                                try {
                                    zzix.getWritableDatabase().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                                } catch (SQLiteException e) {
                                    zzix.zzge().zzim().zzg("Error clearing complex main event", e);
                                }
                            } else {
                                zzix().zza(str, l3, j, zzkn);
                            }
                            zzko[] zzkoArr3 = new zzko[(zzkn.zzata.length + zzkoArr2.length)];
                            i2 = 0;
                            zzko[] zzkoArr4 = zzkn.zzata;
                            length3 = zzkoArr4.length;
                            i = 0;
                            while (i < length3) {
                                zzko = zzkoArr4[i];
                                zzgb();
                                if (zzka.zza(zzkn3, zzko.name) == null) {
                                    i3 = i2 + 1;
                                    zzkoArr3[i2] = zzko;
                                } else {
                                    i3 = i2;
                                }
                                i++;
                                i2 = i3;
                            }
                            if (i2 > 0) {
                                length = zzkoArr2.length;
                                i3 = 0;
                                while (i3 < length) {
                                    i = i2 + 1;
                                    zzkoArr3[i2] = zzkoArr2[i3];
                                    i3++;
                                    i2 = i;
                                }
                                zzkoArr = i2 == zzkoArr3.length ? zzkoArr3 : (zzko[]) Arrays.copyOf(zzkoArr3, i2);
                                str2 = str3;
                                j2 = j;
                                l2 = l4;
                                zzkn2 = zzkn;
                            } else {
                                zzge().zzip().zzg("No unique parameters in main event. eventName", str3);
                                zzkoArr = zzkoArr2;
                                str2 = str3;
                                j2 = j;
                                l2 = l4;
                                zzkn2 = zzkn;
                            }
                        }
                        i3 = i4 + 1;
                    } else if (obj != null) {
                        zzgb();
                        Long valueOf = Long.valueOf(0);
                        l = zzka.zzb(zzkn3, "_epc");
                        if (l != null) {
                            valueOf = l;
                        }
                        j = valueOf.longValue();
                        if (j <= 0) {
                            zzge().zzip().zzg("Complex event with zero extra param count. eventName", str3);
                            zzkoArr = zzkoArr2;
                            str2 = str3;
                            j2 = j;
                            l2 = l3;
                            zzkn2 = zzkn3;
                        } else {
                            zzix().zza(str, l3, j, zzkn3);
                            zzkoArr = zzkoArr2;
                            str2 = str3;
                            j2 = j;
                            l2 = l3;
                            zzkn2 = zzkn3;
                        }
                    }
                    zzf = zzix().zzf(str, zzkn3.name);
                    if (zzf != null) {
                        zzge().zzip().zze("Event aggregate wasn't created during raw event logging. appId, event", zzfg.zzbm(str), zzga().zzbj(str2));
                        zzeq = new zzeq(str, zzkn3.name, 1, 1, zzkn3.zzatb.longValue(), 0, null, null, null);
                    } else {
                        zzeq = zzf.zzie();
                    }
                    zzix().zza(zzeq);
                    j3 = zzeq.zzafr;
                    map = (Map) aVar4.get(str2);
                    if (map != null) {
                        map = zzix().zzk(str, str2);
                        if (map == null) {
                            map = new a();
                        }
                        aVar4.put(str2, map);
                        map2 = map;
                    } else {
                        map2 = map;
                    }
                    for (Integer intValue22 : map2.keySet()) {
                        int intValue3 = intValue22.intValue();
                        if (hashSet.contains(Integer.valueOf(intValue3))) {
                            zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(intValue3));
                        } else {
                            BitSet bitSet3;
                            BitSet bitSet4;
                            bitSet = (BitSet) aVar2.get(Integer.valueOf(intValue3));
                            bitSet2 = (BitSet) aVar3.get(Integer.valueOf(intValue3));
                            if (((zzkm) aVar.get(Integer.valueOf(intValue3))) == null) {
                                zzkm2 = new zzkm();
                                aVar.put(Integer.valueOf(intValue3), zzkm2);
                                zzkm2.zzasy = Boolean.TRUE;
                                bitSet = new BitSet();
                                aVar2.put(Integer.valueOf(intValue3), bitSet);
                                bitSet2 = new BitSet();
                                aVar3.put(Integer.valueOf(intValue3), bitSet2);
                                bitSet3 = bitSet2;
                                bitSet4 = bitSet;
                            } else {
                                bitSet3 = bitSet2;
                                bitSet4 = bitSet;
                            }
                            for (zzke zzke : (List) map2.get(Integer.valueOf(intValue3))) {
                                if (zzge().isLoggable(2)) {
                                    zzge().zzit().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), zzke.zzarp, zzga().zzbj(zzke.zzarq));
                                    zzge().zzit().zzg("Filter definition", zzga().zza(zzke));
                                }
                                if (zzke.zzarp == null || zzke.zzarp.intValue() > 256) {
                                    zzge().zzip().zze("Invalid event filter ID. appId, id", zzfg.zzbm(str), String.valueOf(zzke.zzarp));
                                } else if (bitSet4.get(zzke.zzarp.intValue())) {
                                    zzge().zzit().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), zzke.zzarp);
                                } else {
                                    Boolean zza2;
                                    zzfi zzit;
                                    String str4;
                                    if (zzke.zzart != null) {
                                        zza2 = zza(j3, zzke.zzart);
                                        if (zza2 == null) {
                                            zza2 = null;
                                        } else if (!zza2.booleanValue()) {
                                            zza2 = Boolean.FALSE;
                                        }
                                        zzit = zzge().zzit();
                                        str4 = "Event filter result";
                                        if (zza2 != null) {
                                            obj = BuildConfig.COMMAND;
                                        } else {
                                            Boolean bool = zza2;
                                        }
                                        zzit.zzg(str4, obj);
                                        if (zza2 != null) {
                                            hashSet.add(Integer.valueOf(intValue3));
                                        } else {
                                            bitSet3.set(zzke.zzarp.intValue());
                                            if (zza2.booleanValue()) {
                                                bitSet4.set(zzke.zzarp.intValue());
                                            }
                                        }
                                    }
                                    HashSet hashSet2 = new HashSet();
                                    for (zzkf zzkf : zzke.zzarr) {
                                        if (TextUtils.isEmpty(zzkf.zzary)) {
                                            zzge().zzip().zzg("null or empty param name in filter. event", zzga().zzbj(str2));
                                            zza2 = null;
                                            break;
                                        }
                                        hashSet2.add(zzkf.zzary);
                                    }
                                    a aVar5 = new a();
                                    for (zzko zzko2 : zzkoArr) {
                                        if (hashSet2.contains(zzko2.name)) {
                                            if (zzko2.zzate == null) {
                                                if (zzko2.zzarc == null) {
                                                    if (zzko2.zzajf == null) {
                                                        zzge().zzip().zze("Unknown value for param. event, param", zzga().zzbj(str2), zzga().zzbk(zzko2.name));
                                                        zza2 = null;
                                                        break;
                                                    }
                                                    aVar5.put(zzko2.name, zzko2.zzajf);
                                                } else {
                                                    aVar5.put(zzko2.name, zzko2.zzarc);
                                                }
                                            } else {
                                                aVar5.put(zzko2.name, zzko2.zzate);
                                            }
                                        }
                                    }
                                    zzkf[] zzkfArr = zzke.zzarr;
                                    int length4 = zzkfArr.length;
                                    i2 = 0;
                                    while (true) {
                                        intValue = i2;
                                        if (intValue >= length4) {
                                            zza2 = Boolean.TRUE;
                                            break;
                                        }
                                        zzkf zzkf2 = zzkfArr[intValue];
                                        boolean equals = Boolean.TRUE.equals(zzkf2.zzarx);
                                        String str5 = zzkf2.zzary;
                                        if (TextUtils.isEmpty(str5)) {
                                            zzge().zzip().zzg("Event has empty param name. event", zzga().zzbj(str2));
                                            zza2 = null;
                                            break;
                                        }
                                        Object obj3 = aVar5.get(str5);
                                        if (obj3 instanceof Long) {
                                            if (zzkf2.zzarw == null) {
                                                zzge().zzip().zze("No number filter for long param. event, param", zzga().zzbj(str2), zzga().zzbk(str5));
                                                zza2 = null;
                                                break;
                                            }
                                            zza2 = zza(((Long) obj3).longValue(), zzkf2.zzarw);
                                            if (zza2 == null) {
                                                zza2 = null;
                                                break;
                                            }
                                            if (((!zza2.booleanValue() ? 1 : 0) ^ equals) != 0) {
                                                zza2 = Boolean.FALSE;
                                                break;
                                            }
                                        } else if (obj3 instanceof Double) {
                                            if (zzkf2.zzarw == null) {
                                                zzge().zzip().zze("No number filter for double param. event, param", zzga().zzbj(str2), zzga().zzbk(str5));
                                                zza2 = null;
                                                break;
                                            }
                                            zza2 = zza(((Double) obj3).doubleValue(), zzkf2.zzarw);
                                            if (zza2 == null) {
                                                zza2 = null;
                                                break;
                                            }
                                            if (((!zza2.booleanValue() ? 1 : 0) ^ equals) != 0) {
                                                zza2 = Boolean.FALSE;
                                                break;
                                            }
                                        } else if (obj3 instanceof String) {
                                            if (zzkf2.zzarv == null) {
                                                if (zzkf2.zzarw != null) {
                                                    if (!zzka.zzck((String) obj3)) {
                                                        zzge().zzip().zze("Invalid param value for number filter. event, param", zzga().zzbj(str2), zzga().zzbk(str5));
                                                        zza2 = null;
                                                        break;
                                                    }
                                                    zza2 = zza((String) obj3, zzkf2.zzarw);
                                                } else {
                                                    zzge().zzip().zze("No filter for String param. event, param", zzga().zzbj(str2), zzga().zzbk(str5));
                                                    zza2 = null;
                                                    break;
                                                }
                                            }
                                            zza2 = zza((String) obj3, zzkf2.zzarv);
                                            if (zza2 == null) {
                                                zza2 = null;
                                                break;
                                            }
                                            if (((!zza2.booleanValue() ? 1 : 0) ^ equals) != 0) {
                                                zza2 = Boolean.FALSE;
                                                break;
                                            }
                                        } else if (obj3 == null) {
                                            zzge().zzit().zze("Missing param for filter. event, param", zzga().zzbj(str2), zzga().zzbk(str5));
                                            zza2 = Boolean.FALSE;
                                        } else {
                                            zzge().zzip().zze("Unknown param type. event, param", zzga().zzbj(str2), zzga().zzbk(str5));
                                            zza2 = null;
                                        }
                                        i2 = intValue + 1;
                                    }
                                    zzit = zzge().zzit();
                                    str4 = "Event filter result";
                                    if (zza2 != null) {
                                    }
                                    zzit.zzg(str4, obj);
                                    if (zza2 != null) {
                                    }
                                }
                            }
                        }
                    }
                    j = j2;
                    l = l2;
                    zzkn = zzkn2;
                    i3 = i4 + 1;
                }
                zzkoArr = zzkoArr2;
                str2 = str3;
                j2 = j;
                l2 = l;
                zzkn2 = zzkn;
                zzf = zzix().zzf(str, zzkn3.name);
                if (zzf != null) {
                }
                zzix().zza(zzeq);
                j3 = zzeq.zzafr;
                map = (Map) aVar4.get(str2);
                if (map != null) {
                }
                while (r11.hasNext()) {
                }
                j = j2;
                l = l2;
                zzkn = zzkn2;
                i3 = i4 + 1;
            }
        }
        if (zzksArr != null) {
            a aVar6 = new a();
            for (zzks zzks : zzksArr) {
                map = (Map) aVar6.get(zzks.name);
                if (map == null) {
                    map = zzix().zzl(str, zzks.name);
                    if (map == null) {
                        map = new a();
                    }
                    aVar6.put(zzks.name, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                for (Integer intValue222 : r7.keySet()) {
                    length = intValue222.intValue();
                    if (hashSet.contains(Integer.valueOf(length))) {
                        zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(length));
                    } else {
                        bitSet = (BitSet) aVar2.get(Integer.valueOf(length));
                        bitSet2 = (BitSet) aVar3.get(Integer.valueOf(length));
                        if (((zzkm) aVar.get(Integer.valueOf(length))) == null) {
                            zzkm2 = new zzkm();
                            aVar.put(Integer.valueOf(length), zzkm2);
                            zzkm2.zzasy = Boolean.TRUE;
                            bitSet = new BitSet();
                            aVar2.put(Integer.valueOf(length), bitSet);
                            bitSet2 = new BitSet();
                            aVar3.put(Integer.valueOf(length), bitSet2);
                        }
                        for (zzkh zzkh : (List) r7.get(Integer.valueOf(length))) {
                            if (zzge().isLoggable(2)) {
                                zzge().zzit().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(length), zzkh.zzarp, zzga().zzbl(zzkh.zzasf));
                                zzge().zzit().zzg("Filter definition", zzga().zza(zzkh));
                            }
                            if (zzkh.zzarp == null || zzkh.zzarp.intValue() > 256) {
                                zzge().zzip().zze("Invalid property filter ID. appId, id", zzfg.zzbm(str), String.valueOf(zzkh.zzarp));
                                hashSet.add(Integer.valueOf(length));
                                break;
                            } else if (bitSet.get(zzkh.zzarp.intValue())) {
                                zzge().zzit().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(length), zzkh.zzarp);
                            } else {
                                Boolean bool2;
                                Object obj4;
                                zzkf zzkf3 = zzkh.zzasg;
                                if (zzkf3 == null) {
                                    zzge().zzip().zzg("Missing property filter. property", zzga().zzbl(zzks.name));
                                    bool2 = null;
                                } else {
                                    boolean equals2 = Boolean.TRUE.equals(zzkf3.zzarx);
                                    if (zzks.zzate != null) {
                                        if (zzkf3.zzarw == null) {
                                            zzge().zzip().zzg("No number filter for long property. property", zzga().zzbl(zzks.name));
                                            bool2 = null;
                                        } else {
                                            bool2 = zza(zza(zzks.zzate.longValue(), zzkf3.zzarw), equals2);
                                        }
                                    } else if (zzks.zzarc != null) {
                                        if (zzkf3.zzarw == null) {
                                            zzge().zzip().zzg("No number filter for double property. property", zzga().zzbl(zzks.name));
                                            bool2 = null;
                                        } else {
                                            bool2 = zza(zza(zzks.zzarc.doubleValue(), zzkf3.zzarw), equals2);
                                        }
                                    } else if (zzks.zzajf == null) {
                                        zzge().zzip().zzg("User property has no value, property", zzga().zzbl(zzks.name));
                                        bool2 = null;
                                    } else if (zzkf3.zzarv == null) {
                                        if (zzkf3.zzarw == null) {
                                            zzge().zzip().zzg("No string or number filter defined. property", zzga().zzbl(zzks.name));
                                        } else if (zzka.zzck(zzks.zzajf)) {
                                            bool2 = zza(zza(zzks.zzajf, zzkf3.zzarw), equals2);
                                        } else {
                                            zzge().zzip().zze("Invalid user property value for Numeric number filter. property, value", zzga().zzbl(zzks.name), zzks.zzajf);
                                        }
                                        bool2 = null;
                                    } else {
                                        bool2 = zza(zza(zzks.zzajf, zzkf3.zzarv), equals2);
                                    }
                                }
                                zzfi zzit2 = zzge().zzit();
                                String str6 = "Property filter result";
                                if (bool2 == null) {
                                    obj4 = BuildConfig.COMMAND;
                                } else {
                                    Boolean obj42 = bool2;
                                }
                                zzit2.zzg(str6, obj42);
                                if (bool2 == null) {
                                    hashSet.add(Integer.valueOf(length));
                                } else {
                                    bitSet2.set(zzkh.zzarp.intValue());
                                    if (bool2.booleanValue()) {
                                        bitSet.set(zzkh.zzarp.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zzkm[] zzkmArr = new zzkm[aVar2.size()];
        i2 = 0;
        for (Integer intValue2222 : aVar2.keySet()) {
            intValue = intValue2222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue))) {
                zzkm2 = (zzkm) aVar.get(Integer.valueOf(intValue));
                zzkm = zzkm2 == null ? new zzkm() : zzkm2;
                int i5 = i2 + 1;
                zzkmArr[i2] = zzkm;
                zzkm.zzarl = Integer.valueOf(intValue);
                zzkm.zzasw = new zzkr();
                zzkm.zzasw.zzaul = zzka.zza((BitSet) aVar2.get(Integer.valueOf(intValue)));
                zzkm.zzasw.zzauk = zzka.zza((BitSet) aVar3.get(Integer.valueOf(intValue)));
                zzix = zzix();
                zzkr = zzkm.zzasw;
                zzix.zzch();
                zzix.zzab();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzkr);
                try {
                    byte[] bArr = new byte[zzkr.zzvm()];
                    zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
                    zzkr.zza(zzb);
                    zzb.zzve();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("audience_id", Integer.valueOf(intValue));
                    contentValues.put("current_results", bArr);
                    try {
                        if (zzix.getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                            zzix.zzge().zzim().zzg("Failed to insert filter results (got -1). appId", zzfg.zzbm(str));
                        }
                        i2 = i5;
                    } catch (SQLiteException e2) {
                        zzix.zzge().zzim().zze("Error storing filter results. appId", zzfg.zzbm(str), e2);
                        i2 = i5;
                    }
                } catch (IOException e3) {
                    zzix.zzge().zzim().zze("Configuration loss. Failed to serialize filter results. appId", zzfg.zzbm(str), e3);
                    i2 = i5;
                }
            }
        }
        zzkm[] zzkmArr2 = (zzkm[]) Arrays.copyOf(zzkmArr, i2);
        AppMethodBeat.o(68584);
        return zzkmArr2;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }
}
