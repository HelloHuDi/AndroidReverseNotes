package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new zzi();
    private final long zzaj;
    private final long zzak;

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long zzaj;
        private long zzak;

        public Builder() {
            this.zzaj = -1;
            this.zzak = -1;
            this.isPersisted = false;
        }

        public OneoffTask build() {
            AppMethodBeat.m2504i(69979);
            checkConditions();
            OneoffTask oneoffTask = new OneoffTask(this, null);
            AppMethodBeat.m2505o(69979);
            return oneoffTask;
        }

        /* Access modifiers changed, original: protected */
        public void checkConditions() {
            AppMethodBeat.m2504i(69978);
            super.checkConditions();
            IllegalArgumentException illegalArgumentException;
            if (this.zzaj == -1 || this.zzak == -1) {
                illegalArgumentException = new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
                AppMethodBeat.m2505o(69978);
                throw illegalArgumentException;
            } else if (this.zzaj >= this.zzak) {
                illegalArgumentException = new IllegalArgumentException("Window start must be shorter than window end.");
                AppMethodBeat.m2505o(69978);
                throw illegalArgumentException;
            } else {
                AppMethodBeat.m2505o(69978);
            }
        }

        public Builder setExecutionWindow(long j, long j2) {
            this.zzaj = j;
            this.zzak = j2;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder setPersisted(boolean z) {
            this.isPersisted = z;
            return this;
        }

        public Builder setRequiredNetwork(int i) {
            this.requiredNetworkState = i;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        public Builder setService(Class<? extends GcmTaskService> cls) {
            AppMethodBeat.m2504i(69977);
            this.gcmTaskService = cls.getName();
            AppMethodBeat.m2505o(69977);
            return this;
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public Builder setUpdateCurrent(boolean z) {
            this.updateCurrent = z;
            return this;
        }
    }

    static {
        AppMethodBeat.m2504i(69993);
        AppMethodBeat.m2505o(69993);
    }

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(69989);
        this.zzaj = parcel.readLong();
        this.zzak = parcel.readLong();
        AppMethodBeat.m2505o(69989);
    }

    private OneoffTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        AppMethodBeat.m2504i(69988);
        this.zzaj = builder.zzaj;
        this.zzak = builder.zzak;
        AppMethodBeat.m2505o(69988);
    }

    public long getWindowEnd() {
        return this.zzak;
    }

    public long getWindowStart() {
        return this.zzaj;
    }

    public void toBundle(Bundle bundle) {
        AppMethodBeat.m2504i(69990);
        super.toBundle(bundle);
        bundle.putLong("window_start", this.zzaj);
        bundle.putLong("window_end", this.zzak);
        AppMethodBeat.m2505o(69990);
    }

    public String toString() {
        AppMethodBeat.m2504i(69992);
        String obj = super.toString();
        long windowStart = getWindowStart();
        obj = new StringBuilder(String.valueOf(obj).length() + 64).append(obj).append(" windowStart=").append(windowStart).append(" windowEnd=").append(getWindowEnd()).toString();
        AppMethodBeat.m2505o(69992);
        return obj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(69991);
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.zzaj);
        parcel.writeLong(this.zzak);
        AppMethodBeat.m2505o(69991);
    }
}
