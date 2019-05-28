package com.tencent.p177mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.w */
public final class C5068w {
    /* renamed from: a */
    public static int m7682a(Intent intent, String str, int i) {
        AppMethodBeat.m2504i(52008);
        if (intent == null) {
            AppMethodBeat.m2505o(52008);
        } else {
            try {
                i = intent.getIntExtra(str, i);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(52008);
        }
        return i;
    }

    /* renamed from: k */
    public static int m7686k(Bundle bundle, String str) {
        int i = 0;
        AppMethodBeat.m2504i(52009);
        if (bundle == null) {
            AppMethodBeat.m2505o(52009);
        } else {
            try {
                i = bundle.getInt(str, 0);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(52009);
        }
        return i;
    }

    /* renamed from: m */
    public static long m7688m(Intent intent, String str) {
        long j = 0;
        AppMethodBeat.m2504i(52010);
        if (intent == null) {
            AppMethodBeat.m2505o(52010);
        } else {
            try {
                j = intent.getLongExtra(str, 0);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(52010);
        }
        return j;
    }

    /* renamed from: aM */
    public static Bundle m7684aM(Intent intent) {
        Bundle bundle = null;
        AppMethodBeat.m2504i(52011);
        if (intent == null) {
            AppMethodBeat.m2505o(52011);
        } else {
            try {
                bundle = intent.getExtras();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IntentUtil", "getExtras exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(52011);
        }
        return bundle;
    }

    /* renamed from: a */
    public static boolean m7683a(Intent intent, String str, boolean z) {
        AppMethodBeat.m2504i(52012);
        if (intent == null) {
            AppMethodBeat.m2505o(52012);
        } else {
            try {
                z = intent.getBooleanExtra(str, z);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(52012);
        }
        return z;
    }

    /* renamed from: n */
    public static String m7689n(Intent intent, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(52013);
        if (intent == null) {
            AppMethodBeat.m2505o(52013);
        } else {
            try {
                str2 = intent.getStringExtra(str);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(52013);
        }
        return str2;
    }

    /* renamed from: l */
    public static String m7687l(Bundle bundle, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(52014);
        if (bundle == null) {
            AppMethodBeat.m2505o(52014);
        } else {
            try {
                str2 = bundle.getString(str);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(52014);
        }
        return str2;
    }

    /* renamed from: o */
    public static byte[] m7690o(Intent intent, String str) {
        byte[] bArr = null;
        AppMethodBeat.m2504i(52015);
        if (intent == null) {
            AppMethodBeat.m2505o(52015);
        } else {
            try {
                bArr = intent.getByteArrayExtra(str);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IntentUtil", "getByteArrayExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(52015);
        }
        return bArr;
    }

    /* renamed from: p */
    public static Parcelable m7691p(Intent intent, String str) {
        Parcelable parcelable = null;
        AppMethodBeat.m2504i(52016);
        if (intent == null) {
            AppMethodBeat.m2505o(52016);
        } else {
            try {
                parcelable = intent.getParcelableExtra(str);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IntentUtil", "getParcelableExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(52016);
        }
        return parcelable;
    }

    /* renamed from: b */
    public static void m7685b(Intent intent, String str, boolean z) {
        AppMethodBeat.m2504i(52017);
        try {
            intent.putExtra(str, z);
            AppMethodBeat.m2505o(52017);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.IntentUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(52017);
        }
    }
}
