package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.util.VideoMaterialUtil;

final class zzfh implements Runnable {
    private final /* synthetic */ int zzaix;
    private final /* synthetic */ String zzaiy;
    private final /* synthetic */ Object zzaiz;
    private final /* synthetic */ Object zzaja;
    private final /* synthetic */ Object zzajb;
    private final /* synthetic */ zzfg zzajc;

    zzfh(zzfg zzfg, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzajc = zzfg;
        this.zzaix = i;
        this.zzaiy = str;
        this.zzaiz = obj;
        this.zzaja = obj2;
        this.zzajb = obj3;
    }

    public final void run() {
        AppMethodBeat.m2504i(68899);
        zzfr zzgf = this.zzajc.zzacw.zzgf();
        if (zzgf.isInitialized()) {
            if (this.zzajc.zzaim == 0) {
                if (this.zzajc.zzgg().zzds()) {
                    this.zzajc.zzaim = 'C';
                } else {
                    this.zzajc.zzaim = 'c';
                }
            }
            if (this.zzajc.zzadu < 0) {
                this.zzajc.zzadu = 12451;
            }
            char charAt = "01VDIWEA?".charAt(this.zzaix);
            char zza = this.zzajc.zzaim;
            long zzb = this.zzajc.zzadu;
            String zza2 = zzfg.zza(true, this.zzaiy, this.zzaiz, this.zzaja, this.zzajb);
            String stringBuilder = new StringBuilder(String.valueOf(zza2).length() + 24).append("2").append(charAt).append(zza).append(zzb).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(zza2).toString();
            if (stringBuilder.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                stringBuilder = this.zzaiy.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            zzgf.zzajt.zzc(stringBuilder, 1);
            AppMethodBeat.m2505o(68899);
            return;
        }
        this.zzajc.zza(6, "Persisted config not initialized. Not logging error/warn");
        AppMethodBeat.m2505o(68899);
    }
}
