package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

@Deprecated
public class GcmPubSub {
    private static GcmPubSub zzn;
    private static final Pattern zzp = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    private InstanceID zzo;

    static {
        AppMethodBeat.m2504i(69951);
        AppMethodBeat.m2505o(69951);
    }

    private GcmPubSub(Context context) {
        AppMethodBeat.m2504i(69947);
        this.zzo = InstanceID.getInstance(context);
        AppMethodBeat.m2505o(69947);
    }

    @Deprecated
    public static synchronized GcmPubSub getInstance(Context context) {
        GcmPubSub gcmPubSub;
        synchronized (GcmPubSub.class) {
            AppMethodBeat.m2504i(69948);
            if (zzn == null) {
                GoogleCloudMessaging.zze(context);
                zzn = new GcmPubSub(context);
            }
            gcmPubSub = zzn;
            AppMethodBeat.m2505o(69948);
        }
        return gcmPubSub;
    }

    @Deprecated
    public void subscribe(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(69949);
        String str3;
        String valueOf;
        IllegalArgumentException illegalArgumentException;
        if (str == null || str.isEmpty()) {
            str3 = "Invalid appInstanceToken: ";
            valueOf = String.valueOf(str);
            illegalArgumentException = new IllegalArgumentException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            AppMethodBeat.m2505o(69949);
            throw illegalArgumentException;
        } else if (str2 == null || !zzp.matcher(str2).matches()) {
            str3 = "Invalid topic name: ";
            valueOf = String.valueOf(str2);
            illegalArgumentException = new IllegalArgumentException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            AppMethodBeat.m2505o(69949);
            throw illegalArgumentException;
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("gcm.topic", str2);
            this.zzo.getToken(str, str2, bundle);
            AppMethodBeat.m2505o(69949);
        }
    }

    @Deprecated
    public void unsubscribe(String str, String str2) {
        AppMethodBeat.m2504i(69950);
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", str2);
        this.zzo.zzd(str, str2, bundle);
        AppMethodBeat.m2505o(69950);
    }
}
