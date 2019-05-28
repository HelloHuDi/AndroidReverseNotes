package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import javax.annotation.Nullable;

@Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new WakeLockEventCreator();
    @Field(getter = "getTimeout", id = 16)
    private final long mTimeout;
    @VersionField(id = 1)
    private final int zzal;
    @Field(getter = "getTimeMillis", id = 2)
    private final long zzxv;
    @Field(getter = "getEventType", id = 11)
    private int zzxw;
    @Field(getter = "getElapsedRealtime", id = 8)
    private final long zzyd;
    private long zzyf;
    @Field(getter = "getWakeLockName", id = 4)
    private final String zzyq;
    @Field(getter = "getSecondaryWakeLockName", id = 10)
    private final String zzyr;
    @Field(getter = "getCodePackage", id = 17)
    private final String zzys;
    @Field(getter = "getWakeLockType", id = 5)
    private final int zzyt;
    @Field(getter = "getCallingPackages", id = 6)
    private final List<String> zzyu;
    @Field(getter = "getEventKey", id = 12)
    private final String zzyv;
    @Field(getter = "getDeviceState", id = 14)
    private int zzyw;
    @Field(getter = "getHostPackage", id = 13)
    private final String zzyx;
    @Field(getter = "getBeginPowerPercentage", id = 15)
    private final float zzyy;

    static {
        AppMethodBeat.i(89980);
        AppMethodBeat.o(89980);
    }

    @Constructor
    WakeLockEvent(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 11) int i2, @Param(id = 4) String str, @Param(id = 5) int i3, @Param(id = 6) List<String> list, @Param(id = 12) String str2, @Param(id = 8) long j2, @Param(id = 14) int i4, @Param(id = 10) String str3, @Param(id = 13) String str4, @Param(id = 15) float f, @Param(id = 16) long j3, @Param(id = 17) String str5) {
        this.zzal = i;
        this.zzxv = j;
        this.zzxw = i2;
        this.zzyq = str;
        this.zzyr = str3;
        this.zzys = str5;
        this.zzyt = i3;
        this.zzyf = -1;
        this.zzyu = list;
        this.zzyv = str2;
        this.zzyd = j2;
        this.zzyw = i4;
        this.zzyx = str4;
        this.zzyy = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public WakeLockEvent(WakeLockEvent wakeLockEvent) {
        this(wakeLockEvent.zzal, wakeLockEvent.getTimeMillis(), wakeLockEvent.getEventType(), wakeLockEvent.getWakeLockName(), wakeLockEvent.getWakeLockType(), wakeLockEvent.getCallingPackages(), wakeLockEvent.getEventKey(), wakeLockEvent.getElapsedRealtime(), wakeLockEvent.getDeviceState(), wakeLockEvent.getSecondaryWakeLockName(), wakeLockEvent.getHostPackage(), wakeLockEvent.getBeginPowerPercentage(), wakeLockEvent.getTimeout(), wakeLockEvent.getCodePackage());
        AppMethodBeat.i(89974);
        AppMethodBeat.o(89974);
    }

    public static boolean checkEventType(StatsEvent statsEvent) {
        AppMethodBeat.i(89978);
        if (7 == statsEvent.getEventType() || 8 == statsEvent.getEventType() || 9 == statsEvent.getEventType() || 10 == statsEvent.getEventType() || 11 == statsEvent.getEventType() || 12 == statsEvent.getEventType()) {
            AppMethodBeat.o(89978);
            return true;
        }
        AppMethodBeat.o(89978);
        return false;
    }

    public final StatsEvent ReconstructCloseEvent(StatsEvent statsEvent) {
        AppMethodBeat.i(89975);
        if (statsEvent instanceof WakeLockEvent) {
            WakeLockEvent wakeLockEvent = (WakeLockEvent) statsEvent;
            statsEvent = new WakeLockEvent(wakeLockEvent).setEventType(getEventType()).setDurationMillis(getElapsedRealtime() - wakeLockEvent.getElapsedRealtime());
            AppMethodBeat.o(89975);
            return statsEvent;
        }
        AppMethodBeat.o(89975);
        return statsEvent;
    }

    public final float getBeginPowerPercentage() {
        return this.zzyy;
    }

    @Nullable
    public final List<String> getCallingPackages() {
        return this.zzyu;
    }

    public final String getCodePackage() {
        return this.zzys;
    }

    public final int getDeviceState() {
        return this.zzyw;
    }

    public final long getDurationMillis() {
        return this.zzyf;
    }

    public final long getElapsedRealtime() {
        return this.zzyd;
    }

    public final String getEventKey() {
        return this.zzyv;
    }

    public final int getEventType() {
        return this.zzxw;
    }

    public final String getHostPackage() {
        return this.zzyx;
    }

    public final String getSecondaryWakeLockName() {
        return this.zzyr;
    }

    public final String getSpecificString() {
        AppMethodBeat.i(89977);
        String wakeLockName = getWakeLockName();
        int wakeLockType = getWakeLockType();
        Object join = getCallingPackages() == null ? "" : TextUtils.join(",", getCallingPackages());
        int deviceState = getDeviceState();
        Object secondaryWakeLockName = getSecondaryWakeLockName() == null ? "" : getSecondaryWakeLockName();
        Object hostPackage = getHostPackage() == null ? "" : getHostPackage();
        float beginPowerPercentage = getBeginPowerPercentage();
        Object codePackage = getCodePackage() == null ? "" : getCodePackage();
        String stringBuilder = new StringBuilder(((((String.valueOf(wakeLockName).length() + 45) + String.valueOf(join).length()) + String.valueOf(secondaryWakeLockName).length()) + String.valueOf(hostPackage).length()) + String.valueOf(codePackage).length()).append("\t").append(wakeLockName).append("\t").append(wakeLockType).append("\t").append(join).append("\t").append(deviceState).append("\t").append(secondaryWakeLockName).append("\t").append(hostPackage).append("\t").append(beginPowerPercentage).append("\t").append(codePackage).toString();
        AppMethodBeat.o(89977);
        return stringBuilder;
    }

    public final long getTimeMillis() {
        return this.zzxv;
    }

    public final long getTimeout() {
        return this.mTimeout;
    }

    public final String getWakeLockName() {
        return this.zzyq;
    }

    public final int getWakeLockType() {
        return this.zzyt;
    }

    public final WakeLockEvent markTimeOut() {
        if (this.mTimeout != 0) {
            this.zzyf = this.mTimeout;
        }
        if (7 == this.zzxw) {
            this.zzxw = 9;
        } else if (10 == this.zzxw) {
            this.zzxw = 12;
        }
        return this;
    }

    public final StatsEvent setDurationMillis(long j) {
        this.zzyf = j;
        return this;
    }

    public final StatsEvent setEventType(int i) {
        this.zzxw = i;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(89976);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeLong(parcel, 2, getTimeMillis());
        SafeParcelWriter.writeString(parcel, 4, getWakeLockName(), false);
        SafeParcelWriter.writeInt(parcel, 5, getWakeLockType());
        SafeParcelWriter.writeStringList(parcel, 6, getCallingPackages(), false);
        SafeParcelWriter.writeLong(parcel, 8, getElapsedRealtime());
        SafeParcelWriter.writeString(parcel, 10, getSecondaryWakeLockName(), false);
        SafeParcelWriter.writeInt(parcel, 11, getEventType());
        SafeParcelWriter.writeString(parcel, 12, getEventKey(), false);
        SafeParcelWriter.writeString(parcel, 13, getHostPackage(), false);
        SafeParcelWriter.writeInt(parcel, 14, getDeviceState());
        SafeParcelWriter.writeFloat(parcel, 15, getBeginPowerPercentage());
        SafeParcelWriter.writeLong(parcel, 16, getTimeout());
        SafeParcelWriter.writeString(parcel, 17, getCodePackage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(89976);
    }
}
