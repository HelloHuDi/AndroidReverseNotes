package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w {
    public static int a(Intent intent, String str, int i) {
        AppMethodBeat.i(52008);
        if (intent == null) {
            AppMethodBeat.o(52008);
        } else {
            try {
                i = intent.getIntExtra(str, i);
            } catch (Exception e) {
                ab.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.o(52008);
        }
        return i;
    }

    public static int k(Bundle bundle, String str) {
        int i = 0;
        AppMethodBeat.i(52009);
        if (bundle == null) {
            AppMethodBeat.o(52009);
        } else {
            try {
                i = bundle.getInt(str, 0);
            } catch (Exception e) {
                ab.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.o(52009);
        }
        return i;
    }

    public static long m(Intent intent, String str) {
        long j = 0;
        AppMethodBeat.i(52010);
        if (intent == null) {
            AppMethodBeat.o(52010);
        } else {
            try {
                j = intent.getLongExtra(str, 0);
            } catch (Exception e) {
                ab.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.o(52010);
        }
        return j;
    }

    public static Bundle aM(Intent intent) {
        Bundle bundle = null;
        AppMethodBeat.i(52011);
        if (intent == null) {
            AppMethodBeat.o(52011);
        } else {
            try {
                bundle = intent.getExtras();
            } catch (Exception e) {
                ab.e("MicroMsg.IntentUtil", "getExtras exception:%s", e.getMessage());
            }
            AppMethodBeat.o(52011);
        }
        return bundle;
    }

    public static boolean a(Intent intent, String str, boolean z) {
        AppMethodBeat.i(52012);
        if (intent == null) {
            AppMethodBeat.o(52012);
        } else {
            try {
                z = intent.getBooleanExtra(str, z);
            } catch (Exception e) {
                ab.e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.o(52012);
        }
        return z;
    }

    public static String n(Intent intent, String str) {
        String str2 = null;
        AppMethodBeat.i(52013);
        if (intent == null) {
            AppMethodBeat.o(52013);
        } else {
            try {
                str2 = intent.getStringExtra(str);
            } catch (Exception e) {
                ab.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.o(52013);
        }
        return str2;
    }

    public static String l(Bundle bundle, String str) {
        String str2 = null;
        AppMethodBeat.i(52014);
        if (bundle == null) {
            AppMethodBeat.o(52014);
        } else {
            try {
                str2 = bundle.getString(str);
            } catch (Exception e) {
                ab.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.o(52014);
        }
        return str2;
    }

    public static byte[] o(Intent intent, String str) {
        byte[] bArr = null;
        AppMethodBeat.i(52015);
        if (intent == null) {
            AppMethodBeat.o(52015);
        } else {
            try {
                bArr = intent.getByteArrayExtra(str);
            } catch (Exception e) {
                ab.e("MicroMsg.IntentUtil", "getByteArrayExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.o(52015);
        }
        return bArr;
    }

    public static Parcelable p(Intent intent, String str) {
        Parcelable parcelable = null;
        AppMethodBeat.i(52016);
        if (intent == null) {
            AppMethodBeat.o(52016);
        } else {
            try {
                parcelable = intent.getParcelableExtra(str);
            } catch (Exception e) {
                ab.e("MicroMsg.IntentUtil", "getParcelableExtra exception:%s", e.getMessage());
            }
            AppMethodBeat.o(52016);
        }
        return parcelable;
    }

    public static void b(Intent intent, String str, boolean z) {
        AppMethodBeat.i(52017);
        try {
            intent.putExtra(str, z);
            AppMethodBeat.o(52017);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.IntentUtil", e, "", new Object[0]);
            AppMethodBeat.o(52017);
        }
    }
}
