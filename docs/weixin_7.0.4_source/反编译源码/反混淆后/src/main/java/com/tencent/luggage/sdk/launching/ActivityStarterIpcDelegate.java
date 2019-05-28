package com.tencent.luggage.sdk.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActivityStarterIpcDelegate implements Parcelable {
    public static final Creator<ActivityStarterIpcDelegate> CREATOR = new C256992();
    public final ResultReceiver bRc;

    /* renamed from: com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate$2 */
    static class C256992 implements Creator<ActivityStarterIpcDelegate> {
        C256992() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ActivityStarterIpcDelegate[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(101663);
            ActivityStarterIpcDelegate activityStarterIpcDelegate = new ActivityStarterIpcDelegate(parcel, (byte) 0);
            AppMethodBeat.m2505o(101663);
            return activityStarterIpcDelegate;
        }
    }

    /* synthetic */ ActivityStarterIpcDelegate(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: aw */
    public static ActivityStarterIpcDelegate m82942aw(Context context) {
        AppMethodBeat.m2504i(101664);
        if (context instanceof Activity) {
            ActivityStarterIpcDelegate activityStarterIpcDelegate = new ActivityStarterIpcDelegate((Activity) context);
            AppMethodBeat.m2505o(101664);
            return activityStarterIpcDelegate;
        }
        AppMethodBeat.m2505o(101664);
        return null;
    }

    public ActivityStarterIpcDelegate(final Activity activity) {
        AppMethodBeat.m2504i(101665);
        this.bRc = new ResultReceiver(new Handler(Looper.getMainLooper())) {
            /* Access modifiers changed, original: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                AppMethodBeat.m2504i(101662);
                super.onReceiveResult(i, bundle);
                if (4660 == i && bundle != null) {
                    Intent intent = (Intent) bundle.getParcelable("intent");
                    if (intent != null) {
                        intent.setFlags(intent.getFlags() & -268435457);
                        activity.startActivity(intent);
                    }
                }
                AppMethodBeat.m2505o(101662);
            }
        };
        AppMethodBeat.m2505o(101665);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(101666);
        this.bRc.writeToParcel(parcel, i);
        AppMethodBeat.m2505o(101666);
    }

    private ActivityStarterIpcDelegate(Parcel parcel) {
        AppMethodBeat.m2504i(101667);
        this.bRc = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        AppMethodBeat.m2505o(101667);
    }

    static {
        AppMethodBeat.m2504i(101668);
        AppMethodBeat.m2505o(101668);
    }
}
