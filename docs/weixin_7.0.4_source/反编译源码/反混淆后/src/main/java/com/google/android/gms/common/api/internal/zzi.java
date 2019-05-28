package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzi extends zzk {
    private final SparseArray<zza> zzed = new SparseArray();

    class zza implements OnConnectionFailedListener {
        public final int zzee;
        public final GoogleApiClient zzef;
        public final OnConnectionFailedListener zzeg;

        public zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            AppMethodBeat.m2504i(60923);
            this.zzee = i;
            this.zzef = googleApiClient;
            this.zzeg = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
            AppMethodBeat.m2505o(60923);
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            AppMethodBeat.m2504i(60924);
            String valueOf = String.valueOf(connectionResult);
            new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf);
            zzi.this.zzb(connectionResult, this.zzee);
            AppMethodBeat.m2505o(60924);
        }
    }

    private zzi(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        AppMethodBeat.m2504i(60926);
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
        AppMethodBeat.m2505o(60926);
    }

    public static zzi zza(LifecycleActivity lifecycleActivity) {
        AppMethodBeat.m2504i(60925);
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zzi zzi = (zzi) fragment.getCallbackOrNull("AutoManageHelper", zzi.class);
        if (zzi != null) {
            AppMethodBeat.m2505o(60925);
            return zzi;
        }
        zzi = new zzi(fragment);
        AppMethodBeat.m2505o(60925);
        return zzi;
    }

    private final zza zzd(int i) {
        AppMethodBeat.m2504i(60934);
        if (this.zzed.size() <= i) {
            AppMethodBeat.m2505o(60934);
            return null;
        }
        zza zza = (zza) this.zzed.get(this.zzed.keyAt(i));
        AppMethodBeat.m2505o(60934);
        return zza;
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.m2504i(60931);
        for (int i = 0; i < this.zzed.size(); i++) {
            zza zzd = zzd(i);
            if (zzd != null) {
                printWriter.append(str).append("GoogleApiClient #").print(zzd.zzee);
                printWriter.println(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                zzd.zzef.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
        AppMethodBeat.m2505o(60931);
    }

    public final void onStart() {
        AppMethodBeat.m2504i(60929);
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.zzed);
        new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf);
        if (this.zzer.get() == null) {
            for (int i = 0; i < this.zzed.size(); i++) {
                zza zzd = zzd(i);
                if (zzd != null) {
                    zzd.zzef.connect();
                }
            }
        }
        AppMethodBeat.m2505o(60929);
    }

    public void onStop() {
        AppMethodBeat.m2504i(60930);
        super.onStop();
        for (int i = 0; i < this.zzed.size(); i++) {
            zza zzd = zzd(i);
            if (zzd != null) {
                zzd.zzef.disconnect();
            }
        }
        AppMethodBeat.m2505o(60930);
    }

    public final void zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(60927);
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        Preconditions.checkState(this.zzed.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        zzl zzl = (zzl) this.zzer.get();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(zzl);
        new StringBuilder(String.valueOf(valueOf).length() + 49).append("starting AutoManage for client ").append(i).append(" ").append(z).append(" ").append(valueOf);
        this.zzed.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && zzl == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            new StringBuilder(String.valueOf(valueOf2).length() + 11).append("connecting ").append(valueOf2);
            googleApiClient.connect();
        }
        AppMethodBeat.m2505o(60927);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zza(ConnectionResult connectionResult, int i) {
        AppMethodBeat.m2504i(60932);
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            AppMethodBeat.m2505o(60932);
            return;
        }
        zza zza = (zza) this.zzed.get(i);
        if (zza != null) {
            zzc(i);
            OnConnectionFailedListener onConnectionFailedListener = zza.zzeg;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        AppMethodBeat.m2505o(60932);
    }

    public final void zzc(int i) {
        AppMethodBeat.m2504i(60928);
        zza zza = (zza) this.zzed.get(i);
        this.zzed.remove(i);
        if (zza != null) {
            zza.zzef.unregisterConnectionFailedListener(zza);
            zza.zzef.disconnect();
        }
        AppMethodBeat.m2505o(60928);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzr() {
        AppMethodBeat.m2504i(60933);
        for (int i = 0; i < this.zzed.size(); i++) {
            zza zzd = zzd(i);
            if (zzd != null) {
                zzd.zzef.connect();
            }
        }
        AppMethodBeat.m2505o(60933);
    }
}
