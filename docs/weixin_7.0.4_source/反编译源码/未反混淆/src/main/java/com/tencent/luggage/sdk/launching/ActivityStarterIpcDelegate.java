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
    public static final Creator<ActivityStarterIpcDelegate> CREATOR = new Creator<ActivityStarterIpcDelegate>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ActivityStarterIpcDelegate[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101663);
            ActivityStarterIpcDelegate activityStarterIpcDelegate = new ActivityStarterIpcDelegate(parcel, (byte) 0);
            AppMethodBeat.o(101663);
            return activityStarterIpcDelegate;
        }
    };
    public final ResultReceiver bRc;

    /* synthetic */ ActivityStarterIpcDelegate(Parcel parcel, byte b) {
        this(parcel);
    }

    public static ActivityStarterIpcDelegate aw(Context context) {
        AppMethodBeat.i(101664);
        if (context instanceof Activity) {
            ActivityStarterIpcDelegate activityStarterIpcDelegate = new ActivityStarterIpcDelegate((Activity) context);
            AppMethodBeat.o(101664);
            return activityStarterIpcDelegate;
        }
        AppMethodBeat.o(101664);
        return null;
    }

    public ActivityStarterIpcDelegate(final Activity activity) {
        AppMethodBeat.i(101665);
        this.bRc = new ResultReceiver(new Handler(Looper.getMainLooper())) {
            /* Access modifiers changed, original: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                AppMethodBeat.i(101662);
                super.onReceiveResult(i, bundle);
                if (4660 == i && bundle != null) {
                    Intent intent = (Intent) bundle.getParcelable("intent");
                    if (intent != null) {
                        intent.setFlags(intent.getFlags() & -268435457);
                        activity.startActivity(intent);
                    }
                }
                AppMethodBeat.o(101662);
            }
        };
        AppMethodBeat.o(101665);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(101666);
        this.bRc.writeToParcel(parcel, i);
        AppMethodBeat.o(101666);
    }

    private ActivityStarterIpcDelegate(Parcel parcel) {
        AppMethodBeat.i(101667);
        this.bRc = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        AppMethodBeat.o(101667);
    }

    static {
        AppMethodBeat.i(101668);
        AppMethodBeat.o(101668);
    }
}
