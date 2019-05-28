package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new zzk();
    protected long mFlexInSeconds;
    protected long mIntervalInSeconds;

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long zzam;
        private long zzan;

        public Builder() {
            this.zzam = -1;
            this.zzan = -1;
            this.isPersisted = true;
        }

        public PeriodicTask build() {
            AppMethodBeat.m2504i(69998);
            checkConditions();
            PeriodicTask periodicTask = new PeriodicTask(this, null);
            AppMethodBeat.m2505o(69998);
            return periodicTask;
        }

        /* Access modifiers changed, original: protected */
        public void checkConditions() {
            AppMethodBeat.m2504i(69999);
            super.checkConditions();
            IllegalArgumentException illegalArgumentException;
            if (this.zzam == -1) {
                illegalArgumentException = new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
                AppMethodBeat.m2505o(69999);
                throw illegalArgumentException;
            } else if (this.zzam <= 0) {
                illegalArgumentException = new IllegalArgumentException("Period set cannot be less than or equal to 0: " + this.zzam);
                AppMethodBeat.m2505o(69999);
                throw illegalArgumentException;
            } else if (this.zzan == -1) {
                this.zzan = (long) (((float) this.zzam) * 0.1f);
                AppMethodBeat.m2505o(69999);
            } else {
                if (this.zzan > this.zzam) {
                    this.zzan = this.zzam;
                }
                AppMethodBeat.m2505o(69999);
            }
        }

        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder setFlex(long j) {
            this.zzan = j;
            return this;
        }

        public Builder setPeriod(long j) {
            this.zzam = j;
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
            AppMethodBeat.m2504i(69997);
            this.gcmTaskService = cls.getName();
            AppMethodBeat.m2505o(69997);
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
        AppMethodBeat.m2504i(70013);
        AppMethodBeat.m2505o(70013);
    }

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(70009);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = parcel.readLong();
        this.mFlexInSeconds = Math.min(parcel.readLong(), this.mIntervalInSeconds);
        AppMethodBeat.m2505o(70009);
    }

    private PeriodicTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        AppMethodBeat.m2504i(70008);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = builder.zzam;
        this.mFlexInSeconds = Math.min(builder.zzan, this.mIntervalInSeconds);
        AppMethodBeat.m2505o(70008);
    }

    public long getFlex() {
        return this.mFlexInSeconds;
    }

    public long getPeriod() {
        return this.mIntervalInSeconds;
    }

    public void toBundle(Bundle bundle) {
        AppMethodBeat.m2504i(70010);
        super.toBundle(bundle);
        bundle.putLong("period", this.mIntervalInSeconds);
        bundle.putLong("period_flex", this.mFlexInSeconds);
        AppMethodBeat.m2505o(70010);
    }

    public String toString() {
        AppMethodBeat.m2504i(70012);
        String obj = super.toString();
        long period = getPeriod();
        obj = new StringBuilder(String.valueOf(obj).length() + 54).append(obj).append(" period=").append(period).append(" flex=").append(getFlex()).toString();
        AppMethodBeat.m2505o(70012);
        return obj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(70011);
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.mIntervalInSeconds);
        parcel.writeLong(this.mFlexInSeconds);
        AppMethodBeat.m2505o(70011);
    }
}
