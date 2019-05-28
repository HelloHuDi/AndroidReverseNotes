package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Creator<SafeParcelResponse> CREATOR = new SafeParcelResponseCreator();
    private final String mClassName;
    @VersionField(getter = "getVersionCode", id = 1)
    private final int zzal;
    @Field(getter = "getFieldMappingDictionary", id = 3)
    private final FieldMappingDictionary zzwn;
    @Field(getter = "getParcel", id = 2)
    private final Parcel zzxq;
    private final int zzxr;
    private int zzxs;
    private int zzxt;

    static {
        AppMethodBeat.i(61622);
        AppMethodBeat.o(61622);
    }

    @Constructor
    SafeParcelResponse(@Param(id = 1) int i, @Param(id = 2) Parcel parcel, @Param(id = 3) FieldMappingDictionary fieldMappingDictionary) {
        AppMethodBeat.i(61589);
        this.zzal = i;
        this.zzxq = (Parcel) Preconditions.checkNotNull(parcel);
        this.zzxr = 2;
        this.zzwn = fieldMappingDictionary;
        if (this.zzwn == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzwn.getRootClassName();
        }
        this.zzxs = 2;
        AppMethodBeat.o(61589);
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary fieldMappingDictionary, String str) {
        AppMethodBeat.i(61583);
        this.zzal = 1;
        this.zzxq = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzxq, 0);
        this.zzxr = 1;
        this.zzwn = (FieldMappingDictionary) Preconditions.checkNotNull(fieldMappingDictionary);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zzxs = 2;
        AppMethodBeat.o(61583);
    }

    public SafeParcelResponse(FieldMappingDictionary fieldMappingDictionary) {
        this(fieldMappingDictionary, fieldMappingDictionary.getRootClassName());
        AppMethodBeat.i(61581);
        AppMethodBeat.o(61581);
    }

    public SafeParcelResponse(FieldMappingDictionary fieldMappingDictionary, String str) {
        AppMethodBeat.i(61582);
        this.zzal = 1;
        this.zzxq = Parcel.obtain();
        this.zzxr = 0;
        this.zzwn = (FieldMappingDictionary) Preconditions.checkNotNull(fieldMappingDictionary);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zzxs = 0;
        AppMethodBeat.o(61582);
    }

    public static HashMap<String, String> convertBundleToStringMap(Bundle bundle) {
        AppMethodBeat.i(61620);
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        AppMethodBeat.o(61620);
        return hashMap;
    }

    public static Bundle convertStringMapToBundle(HashMap<String, String> hashMap) {
        AppMethodBeat.i(61621);
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putString(str, (String) hashMap.get(str));
        }
        AppMethodBeat.o(61621);
        return bundle;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t) {
        AppMethodBeat.i(61584);
        String canonicalName = t.getClass().getCanonicalName();
        SafeParcelResponse safeParcelResponse = new SafeParcelResponse((SafeParcelable) t, zza(t), canonicalName);
        AppMethodBeat.o(61584);
        return safeParcelResponse;
    }

    public static FieldMappingDictionary generateDictionary(Class<? extends FastJsonResponse> cls) {
        Throwable th;
        String str;
        String valueOf;
        IllegalStateException illegalStateException;
        AppMethodBeat.i(61588);
        try {
            FieldMappingDictionary zza = zza((FastJsonResponse) cls.newInstance());
            AppMethodBeat.o(61588);
            return zza;
        } catch (InstantiationException e) {
            th = e;
            str = "Could not instantiate an object of type ";
            valueOf = String.valueOf(cls.getCanonicalName());
            illegalStateException = new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            AppMethodBeat.o(61588);
            throw illegalStateException;
        } catch (IllegalAccessException e2) {
            th = e2;
            str = "Could not access object of type ";
            valueOf = String.valueOf(cls.getCanonicalName());
            illegalStateException = new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            AppMethodBeat.o(61588);
            throw illegalStateException;
        }
    }

    private static FieldMappingDictionary zza(FastJsonResponse fastJsonResponse) {
        AppMethodBeat.i(61585);
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.copyInternalFieldMappings();
        fieldMappingDictionary.linkFields();
        AppMethodBeat.o(61585);
        return fieldMappingDictionary;
    }

    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        String str;
        IllegalStateException illegalStateException;
        AppMethodBeat.i(61586);
        Class cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.hasFieldMappingForClass(cls)) {
            Map fieldMappings = fastJsonResponse.getFieldMappings();
            fieldMappingDictionary.put(cls, fieldMappings);
            for (String str2 : fieldMappings.keySet()) {
                String str22;
                FastJsonResponse.Field field = (FastJsonResponse.Field) fieldMappings.get(str22);
                Class concreteType = field.getConcreteType();
                if (concreteType != null) {
                    try {
                        zza(fieldMappingDictionary, (FastJsonResponse) concreteType.newInstance());
                    } catch (InstantiationException e) {
                        str = "Could not instantiate an object of type ";
                        str22 = String.valueOf(field.getConcreteType().getCanonicalName());
                        illegalStateException = new IllegalStateException(str22.length() != 0 ? str.concat(str22) : new String(str), e);
                        AppMethodBeat.o(61586);
                        throw illegalStateException;
                    } catch (IllegalAccessException e2) {
                        str = "Could not access object of type ";
                        str22 = String.valueOf(field.getConcreteType().getCanonicalName());
                        illegalStateException = new IllegalStateException(str22.length() != 0 ? str.concat(str22) : new String(str), e2);
                        AppMethodBeat.o(61586);
                        throw illegalStateException;
                    }
                }
            }
        }
        AppMethodBeat.o(61586);
    }

    private static void zza(StringBuilder stringBuilder, int i, Object obj) {
        AppMethodBeat.i(61619);
        IllegalArgumentException illegalArgumentException;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                AppMethodBeat.o(61619);
                return;
            case 7:
                stringBuilder.append("\"").append(JsonUtils.escapeString(obj.toString())).append("\"");
                AppMethodBeat.o(61619);
                return;
            case 8:
                stringBuilder.append("\"").append(Base64Utils.encode((byte[]) obj)).append("\"");
                AppMethodBeat.o(61619);
                return;
            case 9:
                stringBuilder.append("\"").append(Base64Utils.encodeUrlSafe((byte[]) obj));
                stringBuilder.append("\"");
                AppMethodBeat.o(61619);
                return;
            case 10:
                MapUtils.writeStringMapToJson(stringBuilder, (HashMap) obj);
                AppMethodBeat.o(61619);
                return;
            case 11:
                illegalArgumentException = new IllegalArgumentException("Method does not accept concrete type.");
                AppMethodBeat.o(61619);
                throw illegalArgumentException;
            default:
                illegalArgumentException = new IllegalArgumentException("Unknown type = " + i);
                AppMethodBeat.o(61619);
                throw illegalArgumentException;
        }
    }

    private final void zza(StringBuilder stringBuilder, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        Entry entry;
        AppMethodBeat.i(61617);
        SparseArray sparseArray = new SparseArray();
        for (Entry entry2 : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry2.getValue()).getSafeParcelableFieldId(), entry2);
        }
        stringBuilder.append('{');
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            entry2 = (Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry2 != null) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                stringBuilder.append("\"").append(str).append("\":");
                IllegalStateException illegalStateException;
                if (field.hasConverter()) {
                    switch (field.getTypeOut()) {
                        case 0:
                            zzb(stringBuilder, field, getOriginalValue(field, Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader))));
                            break;
                        case 1:
                            zzb(stringBuilder, field, getOriginalValue(field, SafeParcelReader.createBigInteger(parcel, readHeader)));
                            break;
                        case 2:
                            zzb(stringBuilder, field, getOriginalValue(field, Long.valueOf(SafeParcelReader.readLong(parcel, readHeader))));
                            break;
                        case 3:
                            zzb(stringBuilder, field, getOriginalValue(field, Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader))));
                            break;
                        case 4:
                            zzb(stringBuilder, field, getOriginalValue(field, Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader))));
                            break;
                        case 5:
                            zzb(stringBuilder, field, getOriginalValue(field, SafeParcelReader.createBigDecimal(parcel, readHeader)));
                            break;
                        case 6:
                            zzb(stringBuilder, field, getOriginalValue(field, Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader))));
                            break;
                        case 7:
                            zzb(stringBuilder, field, getOriginalValue(field, SafeParcelReader.createString(parcel, readHeader)));
                            break;
                        case 8:
                        case 9:
                            zzb(stringBuilder, field, getOriginalValue(field, SafeParcelReader.createByteArray(parcel, readHeader)));
                            break;
                        case 10:
                            zzb(stringBuilder, field, getOriginalValue(field, convertBundleToStringMap(SafeParcelReader.createBundle(parcel, readHeader))));
                            break;
                        case 11:
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Method does not accept concrete type.");
                            AppMethodBeat.o(61617);
                            throw illegalArgumentException;
                        default:
                            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Unknown field out type = " + field.getTypeOut());
                            AppMethodBeat.o(61617);
                            throw illegalArgumentException2;
                    }
                } else if (field.isTypeOutArray()) {
                    stringBuilder.append("[");
                    switch (field.getTypeOut()) {
                        case 0:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createIntArray(parcel, readHeader));
                            break;
                        case 1:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createBigIntegerArray(parcel, readHeader));
                            break;
                        case 2:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createLongArray(parcel, readHeader));
                            break;
                        case 3:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createFloatArray(parcel, readHeader));
                            break;
                        case 4:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createDoubleArray(parcel, readHeader));
                            break;
                        case 5:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createBigDecimalArray(parcel, readHeader));
                            break;
                        case 6:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createBooleanArray(parcel, readHeader));
                            break;
                        case 7:
                            ArrayUtils.writeStringArray(stringBuilder, SafeParcelReader.createStringArray(parcel, readHeader));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            AppMethodBeat.o(61617);
                            throw unsupportedOperationException;
                        case 11:
                            Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                            int length = createParcelArray.length;
                            for (i = 0; i < length; i++) {
                                if (i > 0) {
                                    stringBuilder.append(",");
                                }
                                createParcelArray[i].setDataPosition(0);
                                zza(stringBuilder, field.getConcreteTypeFieldMappingFromDictionary(), createParcelArray[i]);
                            }
                            break;
                        default:
                            illegalStateException = new IllegalStateException("Unknown field type out.");
                            AppMethodBeat.o(61617);
                            throw illegalStateException;
                    }
                    stringBuilder.append("]");
                } else {
                    switch (field.getTypeOut()) {
                        case 0:
                            stringBuilder.append(SafeParcelReader.readInt(parcel, readHeader));
                            break;
                        case 1:
                            stringBuilder.append(SafeParcelReader.createBigInteger(parcel, readHeader));
                            break;
                        case 2:
                            stringBuilder.append(SafeParcelReader.readLong(parcel, readHeader));
                            break;
                        case 3:
                            stringBuilder.append(SafeParcelReader.readFloat(parcel, readHeader));
                            break;
                        case 4:
                            stringBuilder.append(SafeParcelReader.readDouble(parcel, readHeader));
                            break;
                        case 5:
                            stringBuilder.append(SafeParcelReader.createBigDecimal(parcel, readHeader));
                            break;
                        case 6:
                            stringBuilder.append(SafeParcelReader.readBoolean(parcel, readHeader));
                            break;
                        case 7:
                            stringBuilder.append("\"").append(JsonUtils.escapeString(SafeParcelReader.createString(parcel, readHeader))).append("\"");
                            break;
                        case 8:
                            stringBuilder.append("\"").append(Base64Utils.encode(SafeParcelReader.createByteArray(parcel, readHeader))).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(Base64Utils.encodeUrlSafe(SafeParcelReader.createByteArray(parcel, readHeader)));
                            stringBuilder.append("\"");
                            break;
                        case 10:
                            Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                            Set<String> keySet = createBundle.keySet();
                            keySet.size();
                            stringBuilder.append("{");
                            i = 1;
                            for (String str2 : keySet) {
                                if (i == 0) {
                                    stringBuilder.append(",");
                                }
                                stringBuilder.append("\"").append(str2).append("\"");
                                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                stringBuilder.append("\"").append(JsonUtils.escapeString(createBundle.getString(str2))).append("\"");
                                i = 0;
                            }
                            stringBuilder.append("}");
                            break;
                        case 11:
                            Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                            createParcel.setDataPosition(0);
                            zza(stringBuilder, field.getConcreteTypeFieldMappingFromDictionary(), createParcel);
                            break;
                        default:
                            illegalStateException = new IllegalStateException("Unknown field type out");
                            AppMethodBeat.o(61617);
                            throw illegalStateException;
                    }
                }
                i = 1;
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            ParseException parseException = new ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
            AppMethodBeat.o(61617);
            throw parseException;
        }
        stringBuilder.append('}');
        AppMethodBeat.o(61617);
    }

    private final void zzb(FastJsonResponse.Field<?, ?> field) {
        AppMethodBeat.i(61595);
        IllegalStateException illegalStateException;
        if (!field.isValidSafeParcelableFieldId()) {
            illegalStateException = new IllegalStateException("Field does not have a valid safe parcelable field id.");
            AppMethodBeat.o(61595);
            throw illegalStateException;
        } else if (this.zzxq == null) {
            illegalStateException = new IllegalStateException("Internal Parcel object is null.");
            AppMethodBeat.o(61595);
            throw illegalStateException;
        } else {
            switch (this.zzxs) {
                case 0:
                    this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
                    this.zzxs = 1;
                    AppMethodBeat.o(61595);
                    return;
                case 1:
                    AppMethodBeat.o(61595);
                    return;
                case 2:
                    illegalStateException = new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                    AppMethodBeat.o(61595);
                    throw illegalStateException;
                default:
                    illegalStateException = new IllegalStateException("Unknown parse state in SafeParcelResponse.");
                    AppMethodBeat.o(61595);
                    throw illegalStateException;
            }
        }
    }

    private final void zzb(StringBuilder stringBuilder, FastJsonResponse.Field<?, ?> field, Object obj) {
        AppMethodBeat.i(61618);
        if (field.isTypeInArray()) {
            ArrayList arrayList = (ArrayList) obj;
            stringBuilder.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                zza(stringBuilder, field.getTypeIn(), arrayList.get(i));
            }
            stringBuilder.append("]");
            AppMethodBeat.o(61618);
            return;
        }
        zza(stringBuilder, field.getTypeIn(), obj);
        AppMethodBeat.o(61618);
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        AppMethodBeat.i(61615);
        zzb(field);
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        ArrayList arrayList3 = arrayList;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) obj)).getParcel());
        }
        SafeParcelWriter.writeParcelList(this.zzxq, field.getSafeParcelableFieldId(), arrayList2, true);
        AppMethodBeat.o(61615);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        AppMethodBeat.i(61614);
        zzb(field);
        SafeParcelWriter.writeParcel(this.zzxq, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).getParcel(), true);
        AppMethodBeat.o(61614);
    }

    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        AppMethodBeat.i(61592);
        if (this.zzwn == null) {
            AppMethodBeat.o(61592);
            return null;
        }
        Map fieldMapping = this.zzwn.getFieldMapping(this.mClassName);
        AppMethodBeat.o(61592);
        return fieldMapping;
    }

    public Parcel getParcel() {
        AppMethodBeat.i(61591);
        switch (this.zzxs) {
            case 0:
                this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
                break;
            case 1:
                break;
        }
        SafeParcelWriter.finishObjectHeader(this.zzxq, this.zzxt);
        this.zzxs = 2;
        Parcel parcel = this.zzxq;
        AppMethodBeat.o(61591);
        return parcel;
    }

    public Object getValueObject(String str) {
        AppMethodBeat.i(61593);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Converting to JSON does not require this method.");
        AppMethodBeat.o(61593);
        throw unsupportedOperationException;
    }

    public int getVersionCode() {
        return this.zzal;
    }

    public <T extends SafeParcelable> T inflate(Creator<T> creator) {
        AppMethodBeat.i(61587);
        Parcel parcel = getParcel();
        parcel.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(parcel);
        AppMethodBeat.o(61587);
        return safeParcelable;
    }

    public boolean isPrimitiveFieldSet(String str) {
        AppMethodBeat.i(61594);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Converting to JSON does not require this method.");
        AppMethodBeat.o(61594);
        throw unsupportedOperationException;
    }

    /* Access modifiers changed, original: protected */
    public void setBigDecimalInternal(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        AppMethodBeat.i(61606);
        zzb(field);
        SafeParcelWriter.writeBigDecimal(this.zzxq, field.getSafeParcelableFieldId(), bigDecimal, true);
        AppMethodBeat.o(61606);
    }

    /* Access modifiers changed, original: protected */
    public void setBigDecimalsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        AppMethodBeat.i(61607);
        zzb(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = (BigDecimal) arrayList.get(i);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zzxq, field.getSafeParcelableFieldId(), bigDecimalArr, true);
        AppMethodBeat.o(61607);
    }

    /* Access modifiers changed, original: protected */
    public void setBigIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        AppMethodBeat.i(61598);
        zzb(field);
        SafeParcelWriter.writeBigInteger(this.zzxq, field.getSafeParcelableFieldId(), bigInteger, true);
        AppMethodBeat.o(61598);
    }

    /* Access modifiers changed, original: protected */
    public void setBigIntegersInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        AppMethodBeat.i(61599);
        zzb(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = (BigInteger) arrayList.get(i);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zzxq, field.getSafeParcelableFieldId(), bigIntegerArr, true);
        AppMethodBeat.o(61599);
    }

    /* Access modifiers changed, original: protected */
    public void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        AppMethodBeat.i(61608);
        zzb(field);
        SafeParcelWriter.writeBoolean(this.zzxq, field.getSafeParcelableFieldId(), z);
        AppMethodBeat.o(61608);
    }

    /* Access modifiers changed, original: protected */
    public void setBooleansInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        AppMethodBeat.i(61609);
        zzb(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = ((Boolean) arrayList.get(i)).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zzxq, field.getSafeParcelableFieldId(), zArr, true);
        AppMethodBeat.o(61609);
    }

    /* Access modifiers changed, original: protected */
    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        AppMethodBeat.i(61612);
        zzb(field);
        SafeParcelWriter.writeByteArray(this.zzxq, field.getSafeParcelableFieldId(), bArr, true);
        AppMethodBeat.o(61612);
    }

    /* Access modifiers changed, original: protected */
    public void setDoubleInternal(FastJsonResponse.Field<?, ?> field, String str, double d) {
        AppMethodBeat.i(61604);
        zzb(field);
        SafeParcelWriter.writeDouble(this.zzxq, field.getSafeParcelableFieldId(), d);
        AppMethodBeat.o(61604);
    }

    /* Access modifiers changed, original: protected */
    public void setDoublesInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        AppMethodBeat.i(61605);
        zzb(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = ((Double) arrayList.get(i)).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zzxq, field.getSafeParcelableFieldId(), dArr, true);
        AppMethodBeat.o(61605);
    }

    /* Access modifiers changed, original: protected */
    public void setFloatInternal(FastJsonResponse.Field<?, ?> field, String str, float f) {
        AppMethodBeat.i(61602);
        zzb(field);
        SafeParcelWriter.writeFloat(this.zzxq, field.getSafeParcelableFieldId(), f);
        AppMethodBeat.o(61602);
    }

    /* Access modifiers changed, original: protected */
    public void setFloatsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        AppMethodBeat.i(61603);
        zzb(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = ((Float) arrayList.get(i)).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zzxq, field.getSafeParcelableFieldId(), fArr, true);
        AppMethodBeat.o(61603);
    }

    /* Access modifiers changed, original: protected */
    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        AppMethodBeat.i(61596);
        zzb(field);
        SafeParcelWriter.writeInt(this.zzxq, field.getSafeParcelableFieldId(), i);
        AppMethodBeat.o(61596);
    }

    /* Access modifiers changed, original: protected */
    public void setIntegersInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        AppMethodBeat.i(61597);
        zzb(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zzxq, field.getSafeParcelableFieldId(), iArr, true);
        AppMethodBeat.o(61597);
    }

    /* Access modifiers changed, original: protected */
    public void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j) {
        AppMethodBeat.i(61600);
        zzb(field);
        SafeParcelWriter.writeLong(this.zzxq, field.getSafeParcelableFieldId(), j);
        AppMethodBeat.o(61600);
    }

    /* Access modifiers changed, original: protected */
    public void setLongsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        AppMethodBeat.i(61601);
        zzb(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zzxq, field.getSafeParcelableFieldId(), jArr, true);
        AppMethodBeat.o(61601);
    }

    /* Access modifiers changed, original: protected */
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        AppMethodBeat.i(61610);
        zzb(field);
        SafeParcelWriter.writeString(this.zzxq, field.getSafeParcelableFieldId(), str2, true);
        AppMethodBeat.o(61610);
    }

    /* Access modifiers changed, original: protected */
    public void setStringMapInternal(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        AppMethodBeat.i(61613);
        zzb(field);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, (String) map.get(str2));
        }
        SafeParcelWriter.writeBundle(this.zzxq, field.getSafeParcelableFieldId(), bundle, true);
        AppMethodBeat.o(61613);
    }

    /* Access modifiers changed, original: protected */
    public void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(61611);
        zzb(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) arrayList.get(i);
        }
        SafeParcelWriter.writeStringArray(this.zzxq, field.getSafeParcelableFieldId(), strArr, true);
        AppMethodBeat.o(61611);
    }

    public String toString() {
        AppMethodBeat.i(61616);
        Preconditions.checkNotNull(this.zzwn, "Cannot convert to JSON on client side.");
        Parcel parcel = getParcel();
        parcel.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        zza(stringBuilder, this.zzwn.getFieldMapping(this.mClassName), parcel);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(61616);
        return stringBuilder2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcelable parcelable;
        AppMethodBeat.i(61590);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
        SafeParcelWriter.writeParcel(parcel, 2, getParcel(), false);
        switch (this.zzxr) {
            case 0:
                parcelable = null;
                break;
            case 1:
                parcelable = this.zzwn;
                break;
            case 2:
                parcelable = this.zzwn;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid creation type: " + this.zzxr);
                AppMethodBeat.o(61590);
                throw illegalStateException;
        }
        SafeParcelWriter.writeParcelable(parcel, 3, parcelable, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(61590);
    }
}
