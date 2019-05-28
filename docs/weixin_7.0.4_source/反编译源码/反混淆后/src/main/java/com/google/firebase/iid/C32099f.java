package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.C41642a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.f */
public final class C32099f {
    private final Context bvF;
    @GuardedBy("this")
    private int bvG;
    @GuardedBy("this")
    private int bvH = 0;
    @GuardedBy("this")
    private String zzbu;
    @GuardedBy("this")
    private String zzbv;

    public C32099f(Context context) {
        this.bvF = context;
    }

    /* renamed from: a */
    public static String m52226a(KeyPair keyPair) {
        AppMethodBeat.m2504i(108718);
        try {
            byte[] digest = MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1).digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            String encodeToString = Base64.encodeToString(digest, 0, 8, 11);
            AppMethodBeat.m2505o(108718);
            return encodeToString;
        } catch (NoSuchAlgorithmException e) {
            AppMethodBeat.m2505o(108718);
            return null;
        }
    }

    /* renamed from: aX */
    private final PackageInfo m52227aX(String str) {
        AppMethodBeat.m2504i(108723);
        try {
            PackageInfo packageInfo = this.bvF.getPackageManager().getPackageInfo(str, 0);
            AppMethodBeat.m2505o(108723);
            return packageInfo;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to find package ").append(valueOf);
            AppMethodBeat.m2505o(108723);
            return null;
        }
    }

    private final synchronized void zzab() {
        AppMethodBeat.m2504i(108722);
        PackageInfo aX = m52227aX(this.bvF.getPackageName());
        if (aX != null) {
            this.zzbu = Integer.toString(aX.versionCode);
            this.zzbv = aX.versionName;
        }
        AppMethodBeat.m2505o(108722);
    }

    /* renamed from: uO */
    public final synchronized String mo52664uO() {
        String str;
        AppMethodBeat.m2504i(108719);
        if (this.zzbu == null) {
            zzab();
        }
        str = this.zzbu;
        AppMethodBeat.m2505o(108719);
        return str;
    }

    /* renamed from: uP */
    public final synchronized String mo52665uP() {
        String str;
        AppMethodBeat.m2504i(108720);
        if (this.zzbv == null) {
            zzab();
        }
        str = this.zzbv;
        AppMethodBeat.m2505o(108720);
        return str;
    }

    /* renamed from: uQ */
    public final synchronized int mo52666uQ() {
        int i;
        AppMethodBeat.m2504i(108721);
        if (this.bvG == 0) {
            PackageInfo aX = m52227aX("com.google.android.gms");
            if (aX != null) {
                this.bvG = aX.versionCode;
            }
        }
        i = this.bvG;
        AppMethodBeat.m2505o(108721);
        return i;
    }

    public final synchronized int zzx() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(108716);
            if (this.bvH != 0) {
                i = this.bvH;
                AppMethodBeat.m2505o(108716);
            } else {
                PackageManager packageManager = this.bvF.getPackageManager();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                    AppMethodBeat.m2505o(108716);
                } else {
                    Intent intent;
                    List queryIntentServices;
                    if (!PlatformVersion.isAtLeastO()) {
                        intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                        intent.setPackage("com.google.android.gms");
                        queryIntentServices = packageManager.queryIntentServices(intent, 0);
                        if (queryIntentServices != null && queryIntentServices.size() > 0) {
                            this.bvH = 1;
                            i = this.bvH;
                            AppMethodBeat.m2505o(108716);
                        }
                    }
                    intent = new Intent("com.google.iid.TOKEN_REQUEST");
                    intent.setPackage("com.google.android.gms");
                    queryIntentServices = packageManager.queryBroadcastReceivers(intent, 0);
                    if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                        if (PlatformVersion.isAtLeastO()) {
                            this.bvH = 2;
                        } else {
                            this.bvH = 1;
                        }
                        i = this.bvH;
                        AppMethodBeat.m2505o(108716);
                    } else {
                        this.bvH = 2;
                        i = this.bvH;
                        AppMethodBeat.m2505o(108716);
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    public static String m52228b(C41642a c41642a) {
        AppMethodBeat.m2504i(108717);
        String str = c41642a.mo67040us().buJ;
        if (str != null) {
            AppMethodBeat.m2505o(108717);
            return str;
        }
        str = c41642a.mo67040us().zzs;
        if (str.startsWith("1:")) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split.length < 2) {
                AppMethodBeat.m2505o(108717);
                return null;
            }
            str = split[1];
            if (str.isEmpty()) {
                AppMethodBeat.m2505o(108717);
                return null;
            }
            AppMethodBeat.m2505o(108717);
            return str;
        }
        AppMethodBeat.m2505o(108717);
        return str;
    }
}
