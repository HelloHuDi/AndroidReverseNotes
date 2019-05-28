package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.ActUtil;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfe extends zzhh {
    private static final AtomicReference<String[]> zzaij = new AtomicReference();
    private static final AtomicReference<String[]> zzaik = new AtomicReference();
    private static final AtomicReference<String[]> zzail = new AtomicReference();

    static {
        AppMethodBeat.m2504i(68868);
        AppMethodBeat.m2505o(68868);
    }

    zzfe(zzgl zzgl) {
        super(zzgl);
    }

    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        int i = 0;
        AppMethodBeat.m2504i(68836);
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        while (i < strArr.length) {
            if (zzka.zzs(str, strArr[i])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        if (strArr3[i] == null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(strArr2[i]);
                            stringBuilder.append("(");
                            stringBuilder.append(strArr[i]);
                            stringBuilder.append(")");
                            strArr3[i] = stringBuilder.toString();
                        }
                        str = strArr3[i];
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(68836);
                    }
                }
                return str;
            }
            i++;
        }
        AppMethodBeat.m2505o(68836);
        return str;
    }

    private static void zza(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(68844);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
        AppMethodBeat.m2505o(68844);
    }

    private final void zza(StringBuilder stringBuilder, int i, zzkf zzkf) {
        AppMethodBeat.m2504i(68848);
        if (zzkf == null) {
            AppMethodBeat.m2505o(68848);
            return;
        }
        zza(stringBuilder, i);
        stringBuilder.append("filter {\n");
        zza(stringBuilder, i, "complement", zzkf.zzarx);
        zza(stringBuilder, i, "param_name", zzbk(zzkf.zzary));
        int i2 = i + 1;
        String str = "string_filter";
        zzki zzki = zzkf.zzarv;
        if (zzki != null) {
            zza(stringBuilder, i2);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (zzki.zzash != null) {
                Object obj = "UNKNOWN_MATCH_TYPE";
                switch (zzki.zzash.intValue()) {
                    case 1:
                        obj = "REGEXP";
                        break;
                    case 2:
                        obj = "BEGINS_WITH";
                        break;
                    case 3:
                        obj = "ENDS_WITH";
                        break;
                    case 4:
                        obj = "PARTIAL";
                        break;
                    case 5:
                        obj = "EXACT";
                        break;
                    case 6:
                        obj = "IN_LIST";
                        break;
                }
                zza(stringBuilder, i2, "match_type", obj);
            }
            zza(stringBuilder, i2, ActUtil.EXPRESSION, zzki.zzasi);
            zza(stringBuilder, i2, "case_sensitive", zzki.zzasj);
            if (zzki.zzask.length > 0) {
                zza(stringBuilder, i2 + 1);
                stringBuilder.append("expression_list {\n");
                for (String str2 : zzki.zzask) {
                    zza(stringBuilder, i2 + 2);
                    stringBuilder.append(str2);
                    stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                stringBuilder.append("}\n");
            }
            zza(stringBuilder, i2);
            stringBuilder.append("}\n");
        }
        zza(stringBuilder, i2, "number_filter", zzkf.zzarw);
        zza(stringBuilder, i);
        stringBuilder.append("}\n");
        AppMethodBeat.m2505o(68848);
    }

    private final void zza(StringBuilder stringBuilder, int i, String str, zzkg zzkg) {
        AppMethodBeat.m2504i(68847);
        if (zzkg == null) {
            AppMethodBeat.m2505o(68847);
            return;
        }
        zza(stringBuilder, i);
        stringBuilder.append(str);
        stringBuilder.append(" {\n");
        if (zzkg.zzarz != null) {
            Object obj = "UNKNOWN_COMPARISON_TYPE";
            switch (zzkg.zzarz.intValue()) {
                case 1:
                    obj = "LESS_THAN";
                    break;
                case 2:
                    obj = "GREATER_THAN";
                    break;
                case 3:
                    obj = "EQUAL";
                    break;
                case 4:
                    obj = "BETWEEN";
                    break;
            }
            zza(stringBuilder, i, "comparison_type", obj);
        }
        zza(stringBuilder, i, "match_as_float", zzkg.zzasa);
        zza(stringBuilder, i, "comparison_value", zzkg.zzasb);
        zza(stringBuilder, i, "min_comparison_value", zzkg.zzasc);
        zza(stringBuilder, i, "max_comparison_value", zzkg.zzasd);
        zza(stringBuilder, i);
        stringBuilder.append("}\n");
        AppMethodBeat.m2505o(68847);
    }

    private static void zza(StringBuilder stringBuilder, int i, String str, zzkr zzkr) {
        AppMethodBeat.m2504i(68846);
        if (zzkr == null) {
            AppMethodBeat.m2505o(68846);
            return;
        }
        int i2;
        int i3;
        zza(stringBuilder, 3);
        stringBuilder.append(str);
        stringBuilder.append(" {\n");
        if (zzkr.zzaul != null) {
            zza(stringBuilder, 4);
            stringBuilder.append("results: ");
            long[] jArr = zzkr.zzaul;
            int length = jArr.length;
            i2 = 0;
            i3 = 0;
            while (i2 < length) {
                Long valueOf = Long.valueOf(jArr[i2]);
                int i4 = i3 + 1;
                if (i3 != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(valueOf);
                i2++;
                i3 = i4;
            }
            stringBuilder.append(10);
        }
        if (zzkr.zzauk != null) {
            zza(stringBuilder, 4);
            stringBuilder.append("status: ");
            long[] jArr2 = zzkr.zzauk;
            int length2 = jArr2.length;
            i2 = 0;
            i3 = 0;
            while (i2 < length2) {
                Long valueOf2 = Long.valueOf(jArr2[i2]);
                int i5 = i3 + 1;
                if (i3 != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(valueOf2);
                i2++;
                i3 = i5;
            }
            stringBuilder.append(10);
        }
        zza(stringBuilder, 3);
        stringBuilder.append("}\n");
        AppMethodBeat.m2505o(68846);
    }

    private static void zza(StringBuilder stringBuilder, int i, String str, Object obj) {
        AppMethodBeat.m2504i(68845);
        if (obj == null) {
            AppMethodBeat.m2505o(68845);
            return;
        }
        zza(stringBuilder, i + 1);
        stringBuilder.append(str);
        stringBuilder.append(": ");
        stringBuilder.append(obj);
        stringBuilder.append(10);
        AppMethodBeat.m2505o(68845);
    }

    private final String zzb(zzer zzer) {
        AppMethodBeat.m2504i(68839);
        String zzb;
        if (zzer == null) {
            AppMethodBeat.m2505o(68839);
            return null;
        } else if (zzil()) {
            zzb = zzb(zzer.zzif());
            AppMethodBeat.m2505o(68839);
            return zzb;
        } else {
            zzb = zzer.toString();
            AppMethodBeat.m2505o(68839);
            return zzb;
        }
    }

    private final boolean zzil() {
        AppMethodBeat.m2504i(68832);
        boolean isLoggable = this.zzacw.zzge().isLoggable(3);
        AppMethodBeat.m2505o(68832);
        return isLoggable;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(68859);
        Context context = super.getContext();
        AppMethodBeat.m2505o(68859);
        return context;
    }

    /* Access modifiers changed, original: protected|final */
    public final String zza(zzep zzep) {
        AppMethodBeat.m2504i(68838);
        String stringBuilder;
        if (zzep == null) {
            AppMethodBeat.m2505o(68838);
            return null;
        } else if (zzil()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Event{appId='");
            stringBuilder2.append(zzep.zzti);
            stringBuilder2.append("', name='");
            stringBuilder2.append(zzbj(zzep.name));
            stringBuilder2.append("', params=");
            stringBuilder2.append(zzb(zzep.zzafq));
            stringBuilder2.append("}");
            stringBuilder = stringBuilder2.toString();
            AppMethodBeat.m2505o(68838);
            return stringBuilder;
        } else {
            stringBuilder = zzep.toString();
            AppMethodBeat.m2505o(68838);
            return stringBuilder;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String zza(zzke zzke) {
        int i = 0;
        AppMethodBeat.m2504i(68842);
        String str;
        if (zzke == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(68842);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        zza(stringBuilder, 0, "filter_id", zzke.zzarp);
        zza(stringBuilder, 0, "event_name", zzbj(zzke.zzarq));
        zza(stringBuilder, 1, "event_count_filter", zzke.zzart);
        stringBuilder.append("  filters {\n");
        zzkf[] zzkfArr = zzke.zzarr;
        int length = zzkfArr.length;
        while (i < length) {
            zza(stringBuilder, 2, zzkfArr[i]);
            i++;
        }
        zza(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(68842);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final String zza(zzkh zzkh) {
        AppMethodBeat.m2504i(68843);
        String str;
        if (zzkh == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(68843);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        zza(stringBuilder, 0, "filter_id", zzkh.zzarp);
        zza(stringBuilder, 0, "property_name", zzbl(zzkh.zzasf));
        zza(stringBuilder, 1, zzkh.zzasg);
        stringBuilder.append("}\n");
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(68843);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final String zza(zzkp zzkp) {
        AppMethodBeat.m2504i(68841);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (zzkp.zzatf != null) {
            for (zzkq zzkq : zzkp.zzatf) {
                if (!(zzkq == null || zzkq == null)) {
                    zza(stringBuilder, 1);
                    stringBuilder.append("bundle {\n");
                    zza(stringBuilder, 1, "protocol_version", zzkq.zzath);
                    zza(stringBuilder, 1, "platform", zzkq.zzatp);
                    zza(stringBuilder, 1, "gmp_version", zzkq.zzatt);
                    zza(stringBuilder, 1, "uploading_gmp_version", zzkq.zzatu);
                    zza(stringBuilder, 1, "config_version", zzkq.zzauf);
                    zza(stringBuilder, 1, "gmp_app_id", zzkq.zzadm);
                    zza(stringBuilder, 1, "app_id", zzkq.zzti);
                    zza(stringBuilder, 1, "app_version", zzkq.zzth);
                    zza(stringBuilder, 1, "app_version_major", zzkq.zzaub);
                    zza(stringBuilder, 1, "firebase_instance_id", zzkq.zzado);
                    zza(stringBuilder, 1, "dev_cert_hash", zzkq.zzatx);
                    zza(stringBuilder, 1, "app_store", zzkq.zzadt);
                    zza(stringBuilder, 1, "upload_timestamp_millis", zzkq.zzatk);
                    zza(stringBuilder, 1, "start_timestamp_millis", zzkq.zzatl);
                    zza(stringBuilder, 1, "end_timestamp_millis", zzkq.zzatm);
                    zza(stringBuilder, 1, "previous_bundle_start_timestamp_millis", zzkq.zzatn);
                    zza(stringBuilder, 1, "previous_bundle_end_timestamp_millis", zzkq.zzato);
                    zza(stringBuilder, 1, "app_instance_id", zzkq.zzadl);
                    zza(stringBuilder, 1, "resettable_device_id", zzkq.zzatv);
                    zza(stringBuilder, 1, "device_id", zzkq.zzaue);
                    zza(stringBuilder, 1, "limited_ad_tracking", zzkq.zzatw);
                    zza(stringBuilder, 1, "os_version", zzkq.zzatq);
                    zza(stringBuilder, 1, "device_model", zzkq.zzatr);
                    zza(stringBuilder, 1, "user_default_language", zzkq.zzafn);
                    zza(stringBuilder, 1, "time_zone_offset_minutes", zzkq.zzats);
                    zza(stringBuilder, 1, "bundle_sequential_index", zzkq.zzaty);
                    zza(stringBuilder, 1, "service_upload", zzkq.zzatz);
                    zza(stringBuilder, 1, "health_monitor", zzkq.zzaek);
                    if (!(zzkq.zzaug == null || zzkq.zzaug.longValue() == 0)) {
                        zza(stringBuilder, 1, "android_id", zzkq.zzaug);
                    }
                    if (zzkq.zzauj != null) {
                        zza(stringBuilder, 1, "retry_counter", zzkq.zzauj);
                    }
                    zzks[] zzksArr = zzkq.zzatj;
                    if (zzksArr != null) {
                        for (zzks zzks : zzksArr) {
                            if (zzks != null) {
                                zza(stringBuilder, 2);
                                stringBuilder.append("user_property {\n");
                                zza(stringBuilder, 2, "set_timestamp_millis", zzks.zzaun);
                                zza(stringBuilder, 2, "name", zzbl(zzks.name));
                                zza(stringBuilder, 2, "string_value", zzks.zzajf);
                                zza(stringBuilder, 2, "int_value", zzks.zzate);
                                zza(stringBuilder, 2, "double_value", zzks.zzarc);
                                zza(stringBuilder, 2);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    zzkm[] zzkmArr = zzkq.zzaua;
                    if (zzkmArr != null) {
                        for (zzkm zzkm : zzkmArr) {
                            if (zzkm != null) {
                                zza(stringBuilder, 2);
                                stringBuilder.append("audience_membership {\n");
                                zza(stringBuilder, 2, "audience_id", zzkm.zzarl);
                                zza(stringBuilder, 2, "new_audience", zzkm.zzasy);
                                zza(stringBuilder, 2, "current_data", zzkm.zzasw);
                                zza(stringBuilder, 2, "previous_data", zzkm.zzasx);
                                zza(stringBuilder, 2);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    zzkn[] zzknArr = zzkq.zzati;
                    if (zzknArr != null) {
                        for (zzkn zzkn : zzknArr) {
                            if (zzkn != null) {
                                zza(stringBuilder, 2);
                                stringBuilder.append("event {\n");
                                zza(stringBuilder, 2, "name", zzbj(zzkn.name));
                                zza(stringBuilder, 2, "timestamp_millis", zzkn.zzatb);
                                zza(stringBuilder, 2, "previous_timestamp_millis", zzkn.zzatc);
                                zza(stringBuilder, 2, "count", zzkn.count);
                                zzko[] zzkoArr = zzkn.zzata;
                                if (zzkoArr != null) {
                                    for (zzko zzko : zzkoArr) {
                                        if (zzko != null) {
                                            zza(stringBuilder, 3);
                                            stringBuilder.append("param {\n");
                                            zza(stringBuilder, 3, "name", zzbk(zzko.name));
                                            zza(stringBuilder, 3, "string_value", zzko.zzajf);
                                            zza(stringBuilder, 3, "int_value", zzko.zzate);
                                            zza(stringBuilder, 3, "double_value", zzko.zzarc);
                                            zza(stringBuilder, 3);
                                            stringBuilder.append("}\n");
                                        }
                                    }
                                }
                                zza(stringBuilder, 2);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    zza(stringBuilder, 1);
                    stringBuilder.append("}\n");
                }
            }
        }
        stringBuilder.append("}\n");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(68841);
        return stringBuilder2;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(68851);
        super.zzab();
        AppMethodBeat.m2505o(68851);
    }

    /* Access modifiers changed, original: protected|final */
    public final String zzb(Bundle bundle) {
        AppMethodBeat.m2504i(68840);
        String stringBuilder;
        if (bundle == null) {
            AppMethodBeat.m2505o(68840);
            return null;
        } else if (zzil()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String stringBuilder3 : bundle.keySet()) {
                if (stringBuilder2.length() != 0) {
                    stringBuilder2.append(", ");
                } else {
                    stringBuilder2.append("Bundle[{");
                }
                stringBuilder2.append(zzbk(stringBuilder3));
                stringBuilder2.append("=");
                stringBuilder2.append(bundle.get(stringBuilder3));
            }
            stringBuilder2.append("}]");
            stringBuilder3 = stringBuilder2.toString();
            AppMethodBeat.m2505o(68840);
            return stringBuilder3;
        } else {
            stringBuilder3 = bundle.toString();
            AppMethodBeat.m2505o(68840);
            return stringBuilder3;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String zzb(zzeu zzeu) {
        AppMethodBeat.m2504i(68837);
        String stringBuilder;
        if (zzeu == null) {
            AppMethodBeat.m2505o(68837);
            return null;
        } else if (zzil()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("origin=");
            stringBuilder2.append(zzeu.origin);
            stringBuilder2.append(",name=");
            stringBuilder2.append(zzbj(zzeu.name));
            stringBuilder2.append(",params=");
            stringBuilder2.append(zzb(zzeu.zzafq));
            stringBuilder = stringBuilder2.toString();
            AppMethodBeat.m2505o(68837);
            return stringBuilder;
        } else {
            stringBuilder = zzeu.toString();
            AppMethodBeat.m2505o(68837);
            return stringBuilder;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String zzbj(String str) {
        AppMethodBeat.m2504i(68833);
        if (str == null) {
            AppMethodBeat.m2505o(68833);
            return null;
        } else if (zzil()) {
            str = zza(str, Event.zzacy, Event.zzacx, zzaij);
            AppMethodBeat.m2505o(68833);
            return str;
        } else {
            AppMethodBeat.m2505o(68833);
            return str;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String zzbk(String str) {
        AppMethodBeat.m2504i(68834);
        if (str == null) {
            AppMethodBeat.m2505o(68834);
            return null;
        } else if (zzil()) {
            str = zza(str, Param.zzada, Param.zzacz, zzaik);
            AppMethodBeat.m2505o(68834);
            return str;
        } else {
            AppMethodBeat.m2505o(68834);
            return str;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String zzbl(String str) {
        AppMethodBeat.m2504i(68835);
        if (str == null) {
            AppMethodBeat.m2505o(68835);
            return null;
        } else if (!zzil()) {
            AppMethodBeat.m2505o(68835);
            return str;
        } else if (str.startsWith("_exp_")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("experiment_id");
            stringBuilder.append("(");
            stringBuilder.append(str);
            stringBuilder.append(")");
            str = stringBuilder.toString();
            AppMethodBeat.m2505o(68835);
            return str;
        } else {
            str = zza(str, UserProperty.zzadc, UserProperty.zzadb, zzail);
            AppMethodBeat.m2505o(68835);
            return str;
        }
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(68858);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(68858);
        return zzbt;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(68849);
        super.zzfr();
        AppMethodBeat.m2505o(68849);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(68850);
        super.zzfs();
        AppMethodBeat.m2505o(68850);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(68852);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(68852);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(68853);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(68853);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(68854);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(68854);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(68855);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(68855);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(68856);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(68856);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(68857);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(68857);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(68860);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(68860);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(68861);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(68861);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(68862);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(68862);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(68863);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(68863);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(68864);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(68864);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(68865);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(68865);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(68866);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(68866);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(68867);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(68867);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }
}
