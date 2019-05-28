package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Class(creator = "FieldMappingDictionaryCreator")
public class FieldMappingDictionary extends AbstractSafeParcelable {
    public static final Creator<FieldMappingDictionary> CREATOR = new FieldMappingDictionaryCreator();
    @VersionField(id = 1)
    private final int zzal;
    private final HashMap<String, Map<String, Field<?, ?>>> zzxk;
    @SafeParcelable.Field(getter = "getSerializedDictionary", id = 2)
    private final ArrayList<Entry> zzxl;
    @SafeParcelable.Field(getter = "getRootClassName", id = 3)
    private final String zzxm;

    @Class(creator = "FieldMapPairCreator")
    public static class FieldMapPair extends AbstractSafeParcelable {
        public static final Creator<FieldMapPair> CREATOR = new FieldMapPairCreator();
        @VersionField(id = 1)
        private final int versionCode;
        @SafeParcelable.Field(id = 2)
        final String zzxo;
        @SafeParcelable.Field(id = 3)
        final Field<?, ?> zzxp;

        static {
            AppMethodBeat.m2504i(61563);
            AppMethodBeat.m2505o(61563);
        }

        @Constructor
        FieldMapPair(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) Field<?, ?> field) {
            this.versionCode = i;
            this.zzxo = str;
            this.zzxp = field;
        }

        FieldMapPair(String str, Field<?, ?> field) {
            this.versionCode = 1;
            this.zzxo = str;
            this.zzxp = field;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(61562);
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
            SafeParcelWriter.writeString(parcel, 2, this.zzxo, false);
            SafeParcelWriter.writeParcelable(parcel, 3, this.zzxp, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            AppMethodBeat.m2505o(61562);
        }
    }

    @Class(creator = "FieldMappingDictionaryEntryCreator")
    public static class Entry extends AbstractSafeParcelable {
        public static final Creator<Entry> CREATOR = new FieldMappingDictionaryEntryCreator();
        @SafeParcelable.Field(id = 2)
        final String className;
        @VersionField(id = 1)
        private final int versionCode;
        @SafeParcelable.Field(id = 3)
        final ArrayList<FieldMapPair> zzxn;

        static {
            AppMethodBeat.m2504i(61561);
            AppMethodBeat.m2505o(61561);
        }

        @Constructor
        Entry(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.zzxn = arrayList;
        }

        Entry(String str, Map<String, Field<?, ?>> map) {
            ArrayList arrayList;
            AppMethodBeat.m2504i(61559);
            this.versionCode = 1;
            this.className = str;
            if (map == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : map.keySet()) {
                    arrayList2.add(new FieldMapPair(str2, (Field) map.get(str2)));
                }
                arrayList = arrayList2;
            }
            this.zzxn = arrayList;
            AppMethodBeat.m2505o(61559);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(61560);
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
            SafeParcelWriter.writeString(parcel, 2, this.className, false);
            SafeParcelWriter.writeTypedList(parcel, 3, this.zzxn, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            AppMethodBeat.m2505o(61560);
        }
    }

    static {
        AppMethodBeat.m2504i(61574);
        AppMethodBeat.m2505o(61574);
    }

    @Constructor
    FieldMappingDictionary(@Param(id = 1) int i, @Param(id = 2) ArrayList<Entry> arrayList, @Param(id = 3) String str) {
        AppMethodBeat.m2504i(61564);
        this.zzal = i;
        this.zzxl = null;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Entry entry = (Entry) arrayList.get(i2);
            String str2 = entry.className;
            HashMap hashMap2 = new HashMap();
            int size2 = entry.zzxn.size();
            for (int i3 = 0; i3 < size2; i3++) {
                FieldMapPair fieldMapPair = (FieldMapPair) entry.zzxn.get(i3);
                hashMap2.put(fieldMapPair.zzxo, fieldMapPair.zzxp);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zzxk = hashMap;
        this.zzxm = (String) Preconditions.checkNotNull(str);
        linkFields();
        AppMethodBeat.m2505o(61564);
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> cls) {
        AppMethodBeat.m2504i(61567);
        this.zzal = 1;
        this.zzxl = null;
        this.zzxk = new HashMap();
        this.zzxm = cls.getCanonicalName();
        AppMethodBeat.m2505o(61567);
    }

    public void copyInternalFieldMappings() {
        AppMethodBeat.m2504i(61566);
        for (String str : this.zzxk.keySet()) {
            Map map = (Map) this.zzxk.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, ((Field) map.get(str2)).copyForDictionary());
            }
            this.zzxk.put(str, hashMap);
        }
        AppMethodBeat.m2505o(61566);
    }

    @VisibleForTesting
    public Map<String, Field<?, ?>> getFieldMapping(Class<? extends FastJsonResponse> cls) {
        AppMethodBeat.m2504i(61569);
        Map map = (Map) this.zzxk.get(cls.getCanonicalName());
        AppMethodBeat.m2505o(61569);
        return map;
    }

    public Map<String, Field<?, ?>> getFieldMapping(String str) {
        AppMethodBeat.m2504i(61570);
        Map map = (Map) this.zzxk.get(str);
        AppMethodBeat.m2505o(61570);
        return map;
    }

    public String getRootClassName() {
        return this.zzxm;
    }

    public boolean hasFieldMappingForClass(Class<? extends FastJsonResponse> cls) {
        AppMethodBeat.m2504i(61571);
        boolean containsKey = this.zzxk.containsKey(cls.getCanonicalName());
        AppMethodBeat.m2505o(61571);
        return containsKey;
    }

    public void linkFields() {
        AppMethodBeat.m2504i(61565);
        for (String str : this.zzxk.keySet()) {
            Map map = (Map) this.zzxk.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).setFieldMappingDictionary(this);
            }
        }
        AppMethodBeat.m2505o(61565);
    }

    public void put(Class<? extends FastJsonResponse> cls, Map<String, Field<?, ?>> map) {
        AppMethodBeat.m2504i(61568);
        this.zzxk.put(cls.getCanonicalName(), map);
        AppMethodBeat.m2505o(61568);
    }

    public String toString() {
        AppMethodBeat.m2504i(61572);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.zzxk.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.zzxk.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        String str3 = stringBuilder.toString();
        AppMethodBeat.m2505o(61572);
        return str3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61573);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzxk.keySet()) {
            arrayList.add(new Entry(str, (Map) this.zzxk.get(str)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, getRootClassName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(61573);
    }
}
