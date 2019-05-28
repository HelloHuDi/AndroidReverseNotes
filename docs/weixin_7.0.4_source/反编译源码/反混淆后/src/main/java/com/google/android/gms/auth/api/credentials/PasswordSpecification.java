package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

@Class(creator = "PasswordSpecificationCreator")
@Reserved({1000})
public final class PasswordSpecification extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<PasswordSpecification> CREATOR = new zzm();
    public static final PasswordSpecification zzdg = new zzd().zzd(12, 16).zze("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zzd("abcdefghijkmnopqrstxyz", 1).zzd("ABCDEFGHJKLMNPQRSTXY", 1).zzd("3456789", 1).zzj();
    private static final PasswordSpecification zzdh = new zzd().zzd(12, 16).zze("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zzd("abcdefghijklmnopqrstuvwxyz", 1).zzd("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zzd("1234567890", 1).zzj();
    @Field(id = 1)
    private final String zzdi;
    @Field(id = 2)
    private final List<String> zzdj;
    @Field(id = 3)
    private final List<Integer> zzdk;
    @Field(id = 4)
    private final int zzdl;
    @Field(id = 5)
    private final int zzdm;
    private final int[] zzdn;
    private final Random zzdo;

    public static class zzd {
        private final List<String> zzdj = new ArrayList();
        private final List<Integer> zzdk = new ArrayList();
        private int zzdl = 12;
        private int zzdm = 16;
        private final TreeSet<Character> zzdp = new TreeSet();

        public zzd() {
            AppMethodBeat.m2504i(50355);
            AppMethodBeat.m2505o(50355);
        }

        private static TreeSet<Character> zzd(String str, String str2) {
            AppMethodBeat.m2504i(50359);
            zze zze;
            if (TextUtils.isEmpty(str)) {
                zze = new zze(String.valueOf(str2).concat(" cannot be null or empty"));
                AppMethodBeat.m2505o(50359);
                throw zze;
            }
            TreeSet treeSet = new TreeSet();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.zze(c, 32, 126)) {
                    zze = new zze(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
                    AppMethodBeat.m2505o(50359);
                    throw zze;
                }
                treeSet.add(Character.valueOf(c));
            }
            AppMethodBeat.m2505o(50359);
            return treeSet;
        }

        public final zzd zzd(int i, int i2) {
            this.zzdl = 12;
            this.zzdm = 16;
            return this;
        }

        public final zzd zzd(String str, int i) {
            AppMethodBeat.m2504i(50357);
            this.zzdj.add(PasswordSpecification.zze(zzd(str, "requiredChars")));
            this.zzdk.add(Integer.valueOf(1));
            AppMethodBeat.m2505o(50357);
            return this;
        }

        public final zzd zze(String str) {
            AppMethodBeat.m2504i(50356);
            this.zzdp.addAll(zzd(str, "allowedChars"));
            AppMethodBeat.m2505o(50356);
            return this;
        }

        public final PasswordSpecification zzj() {
            AppMethodBeat.m2504i(50358);
            zze zze;
            if (this.zzdp.isEmpty()) {
                zze = new zze("no allowed characters specified");
                AppMethodBeat.m2505o(50358);
                throw zze;
            }
            int i = 0;
            for (Integer intValue : this.zzdk) {
                i = intValue.intValue() + i;
            }
            if (i > this.zzdm) {
                zze = new zze("required character count cannot be greater than the max password size");
                AppMethodBeat.m2505o(50358);
                throw zze;
            }
            boolean[] zArr = new boolean[95];
            for (String toCharArray : this.zzdj) {
                for (char c : toCharArray.toCharArray()) {
                    if (zArr[c - 32]) {
                        zze = new zze("character " + c + " occurs in more than one required character set");
                        AppMethodBeat.m2505o(50358);
                        throw zze;
                    }
                    zArr[c - 32] = true;
                }
            }
            PasswordSpecification passwordSpecification = new PasswordSpecification(PasswordSpecification.zze(this.zzdp), this.zzdj, this.zzdk, this.zzdl, this.zzdm);
            AppMethodBeat.m2505o(50358);
            return passwordSpecification;
        }
    }

    public static class zze extends Error {
        public zze(String str) {
            super(str);
        }
    }

    static {
        AppMethodBeat.m2504i(50365);
        AppMethodBeat.m2505o(50365);
    }

    @Constructor
    PasswordSpecification(@Param(id = 1) String str, @Param(id = 2) List<String> list, @Param(id = 3) List<Integer> list2, @Param(id = 4) int i, @Param(id = 5) int i2) {
        AppMethodBeat.m2504i(50360);
        this.zzdi = str;
        this.zzdj = Collections.unmodifiableList(list);
        this.zzdk = Collections.unmodifiableList(list2);
        this.zzdl = i;
        this.zzdm = i2;
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i3 = 0;
        for (String toCharArray : this.zzdj) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i3;
            }
            i3++;
        }
        this.zzdn = iArr;
        this.zzdo = new SecureRandom();
        AppMethodBeat.m2505o(50360);
    }

    private static String zzd(Collection<Character> collection) {
        AppMethodBeat.m2504i(50362);
        char[] cArr = new char[collection.size()];
        int i = 0;
        Iterator it = collection.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = i2 + 1;
                cArr[i2] = ((Character) it.next()).charValue();
            } else {
                String str = new String(cArr);
                AppMethodBeat.m2505o(50362);
                return str;
            }
        }
    }

    private static boolean zzd(int i, int i2, int i3) {
        return i < 32 || i > 126;
    }

    static /* synthetic */ String zze(Collection collection) {
        AppMethodBeat.m2504i(50363);
        String zzd = zzd(collection);
        AppMethodBeat.m2505o(50363);
        return zzd;
    }

    static /* synthetic */ boolean zze(int i, int i2, int i3) {
        AppMethodBeat.m2504i(50364);
        boolean zzd = zzd(i, 32, 126);
        AppMethodBeat.m2505o(50364);
        return zzd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(50361);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdi, false);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzdj, false);
        SafeParcelWriter.writeIntegerList(parcel, 3, this.zzdk, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzdl);
        SafeParcelWriter.writeInt(parcel, 5, this.zzdm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(50361);
    }
}
