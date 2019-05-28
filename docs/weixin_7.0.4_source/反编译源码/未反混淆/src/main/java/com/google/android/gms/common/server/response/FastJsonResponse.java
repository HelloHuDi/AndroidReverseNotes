package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public abstract class FastJsonResponse {
    protected static final String QUOTE = "\"";
    private int zzwk;
    private byte[] zzwl;
    private boolean zzwm;

    public interface FieldType {
        public static final int BASE64 = 8;
        public static final int BASE64_URL_SAFE = 9;
        public static final int BIG_DECIMAL = 5;
        public static final int BIG_INTEGER = 1;
        public static final int BOOLEAN = 6;
        public static final int CONCRETE_TYPE = 11;
        public static final int DOUBLE = 4;
        public static final int FLOAT = 3;
        public static final int INT = 0;
        public static final int LONG = 2;
        public static final int STRING = 7;
        public static final int STRING_MAP = 10;
    }

    @Class(creator = "FieldCreator")
    @VisibleForTesting
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final FieldCreator CREATOR = new FieldCreator();
        protected final Class<? extends FastJsonResponse> mConcreteType;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getConcreteTypeName", id = 8)
        protected final String mConcreteTypeName;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getOutputFieldName", id = 6)
        protected final String mOutputFieldName;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getSafeParcelableFieldId", id = 7)
        protected final int mSafeParcelableFieldId;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getTypeIn", id = 2)
        protected final int mTypeIn;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "isTypeInArray", id = 3)
        protected final boolean mTypeInArray;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getTypeOut", id = 4)
        protected final int mTypeOut;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "isTypeOutArray", id = 5)
        protected final boolean mTypeOutArray;
        @VersionField(getter = "getVersionCode", id = 1)
        private final int zzal;
        private FieldMappingDictionary zzwn;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        private FieldConverter<I, O> zzwo;

        static {
            AppMethodBeat.i(61521);
            AppMethodBeat.o(61521);
        }

        @Constructor
        Field(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) boolean z, @Param(id = 4) int i3, @Param(id = 5) boolean z2, @Param(id = 6) String str, @Param(id = 7) int i4, @Param(id = 8) String str2, @Param(id = 9) ConverterWrapper converterWrapper) {
            AppMethodBeat.i(61465);
            this.zzal = i;
            this.mTypeIn = i2;
            this.mTypeInArray = z;
            this.mTypeOut = i3;
            this.mTypeOutArray = z2;
            this.mOutputFieldName = str;
            this.mSafeParcelableFieldId = i4;
            if (str2 == null) {
                this.mConcreteType = null;
                this.mConcreteTypeName = null;
            } else {
                this.mConcreteType = SafeParcelResponse.class;
                this.mConcreteTypeName = str2;
            }
            if (converterWrapper == null) {
                this.zzwo = null;
                AppMethodBeat.o(61465);
                return;
            }
            this.zzwo = converterWrapper.unwrap();
            AppMethodBeat.o(61465);
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, FieldConverter<I, O> fieldConverter) {
            AppMethodBeat.i(61466);
            this.zzal = 1;
            this.mTypeIn = i;
            this.mTypeInArray = z;
            this.mTypeOut = i2;
            this.mTypeOutArray = z2;
            this.mOutputFieldName = str;
            this.mSafeParcelableFieldId = i3;
            this.mConcreteType = cls;
            if (cls == null) {
                this.mConcreteTypeName = null;
            } else {
                this.mConcreteTypeName = cls.getCanonicalName();
            }
            this.zzwo = fieldConverter;
            AppMethodBeat.o(61466);
        }

        public static Field<byte[], byte[]> forBase64(String str) {
            AppMethodBeat.i(61513);
            Field field = new Field(8, false, 8, false, str, -1, null, null);
            AppMethodBeat.o(61513);
            return field;
        }

        @VisibleForTesting
        public static Field<byte[], byte[]> forBase64(String str, int i) {
            AppMethodBeat.i(61489);
            Field field = new Field(8, false, 8, false, str, i, null, null);
            AppMethodBeat.o(61489);
            return field;
        }

        @VisibleForTesting
        public static Field<byte[], byte[]> forBase64UrlSafe(String str) {
            AppMethodBeat.i(61514);
            Field field = new Field(9, false, 9, false, str, -1, null, null);
            AppMethodBeat.o(61514);
            return field;
        }

        @VisibleForTesting
        public static Field<byte[], byte[]> forBase64UrlSafe(String str, int i) {
            AppMethodBeat.i(61490);
            Field field = new Field(9, false, 9, false, str, i, null, null);
            AppMethodBeat.o(61490);
            return field;
        }

        public static Field<BigDecimal, BigDecimal> forBigDecimal(String str) {
            AppMethodBeat.i(61507);
            Field field = new Field(5, false, 5, false, str, -1, null, null);
            AppMethodBeat.o(61507);
            return field;
        }

        @VisibleForTesting
        public static Field<BigDecimal, BigDecimal> forBigDecimal(String str, int i) {
            AppMethodBeat.i(61483);
            Field field = new Field(5, false, 5, false, str, i, null, null);
            AppMethodBeat.o(61483);
            return field;
        }

        public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String str) {
            AppMethodBeat.i(61508);
            Field field = new Field(5, true, 5, true, str, -1, null, null);
            AppMethodBeat.o(61508);
            return field;
        }

        public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String str, int i) {
            AppMethodBeat.i(61484);
            Field field = new Field(5, true, 5, true, str, i, null, null);
            AppMethodBeat.o(61484);
            return field;
        }

        public static Field<BigInteger, BigInteger> forBigInteger(String str) {
            AppMethodBeat.i(61499);
            Field field = new Field(1, false, 1, false, str, -1, null, null);
            AppMethodBeat.o(61499);
            return field;
        }

        public static Field<BigInteger, BigInteger> forBigInteger(String str, int i) {
            AppMethodBeat.i(61475);
            Field field = new Field(1, false, 1, false, str, i, null, null);
            AppMethodBeat.o(61475);
            return field;
        }

        public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String str) {
            AppMethodBeat.i(61500);
            Field field = new Field(0, true, 1, true, str, -1, null, null);
            AppMethodBeat.o(61500);
            return field;
        }

        public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String str, int i) {
            AppMethodBeat.i(61476);
            Field field = new Field(0, true, 1, true, str, i, null, null);
            AppMethodBeat.o(61476);
            return field;
        }

        public static Field<Boolean, Boolean> forBoolean(String str) {
            AppMethodBeat.i(61509);
            Field field = new Field(6, false, 6, false, str, -1, null, null);
            AppMethodBeat.o(61509);
            return field;
        }

        public static Field<Boolean, Boolean> forBoolean(String str, int i) {
            AppMethodBeat.i(61485);
            Field field = new Field(6, false, 6, false, str, i, null, null);
            AppMethodBeat.o(61485);
            return field;
        }

        public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String str) {
            AppMethodBeat.i(61510);
            Field field = new Field(6, true, 6, true, str, -1, null, null);
            AppMethodBeat.o(61510);
            return field;
        }

        public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String str, int i) {
            AppMethodBeat.i(61486);
            Field field = new Field(6, true, 6, true, str, i, null, null);
            AppMethodBeat.o(61486);
            return field;
        }

        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String str, int i, Class<T> cls) {
            AppMethodBeat.i(61492);
            Field field = new Field(11, false, 11, false, str, i, cls, null);
            AppMethodBeat.o(61492);
            return field;
        }

        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String str, Class<T> cls) {
            AppMethodBeat.i(61516);
            Field field = new Field(11, false, 11, false, str, -1, cls, null);
            AppMethodBeat.o(61516);
            return field;
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String str, int i, Class<T> cls) {
            AppMethodBeat.i(61493);
            Field field = new Field(11, true, 11, true, str, i, cls, null);
            AppMethodBeat.o(61493);
            return field;
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String str, Class<T> cls) {
            AppMethodBeat.i(61517);
            Field field = new Field(11, true, 11, true, str, -1, cls, null);
            AppMethodBeat.o(61517);
            return field;
        }

        public static Field<Double, Double> forDouble(String str) {
            AppMethodBeat.i(61505);
            Field field = new Field(4, false, 4, false, str, -1, null, null);
            AppMethodBeat.o(61505);
            return field;
        }

        public static Field<Double, Double> forDouble(String str, int i) {
            AppMethodBeat.i(61481);
            Field field = new Field(4, false, 4, false, str, i, null, null);
            AppMethodBeat.o(61481);
            return field;
        }

        public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String str) {
            AppMethodBeat.i(61506);
            Field field = new Field(4, true, 4, true, str, -1, null, null);
            AppMethodBeat.o(61506);
            return field;
        }

        public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String str, int i) {
            AppMethodBeat.i(61482);
            Field field = new Field(4, true, 4, true, str, i, null, null);
            AppMethodBeat.o(61482);
            return field;
        }

        public static Field<Float, Float> forFloat(String str) {
            AppMethodBeat.i(61503);
            Field field = new Field(3, false, 3, false, str, -1, null, null);
            AppMethodBeat.o(61503);
            return field;
        }

        public static Field<Float, Float> forFloat(String str, int i) {
            AppMethodBeat.i(61479);
            Field field = new Field(3, false, 3, false, str, i, null, null);
            AppMethodBeat.o(61479);
            return field;
        }

        public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String str) {
            AppMethodBeat.i(61504);
            Field field = new Field(3, true, 3, true, str, -1, null, null);
            AppMethodBeat.o(61504);
            return field;
        }

        public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String str, int i) {
            AppMethodBeat.i(61480);
            Field field = new Field(3, true, 3, true, str, i, null, null);
            AppMethodBeat.o(61480);
            return field;
        }

        public static Field<Integer, Integer> forInteger(String str) {
            AppMethodBeat.i(61497);
            Field field = new Field(0, false, 0, false, str, -1, null, null);
            AppMethodBeat.o(61497);
            return field;
        }

        @VisibleForTesting
        public static Field<Integer, Integer> forInteger(String str, int i) {
            AppMethodBeat.i(61473);
            Field field = new Field(0, false, 0, false, str, i, null, null);
            AppMethodBeat.o(61473);
            return field;
        }

        public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String str) {
            AppMethodBeat.i(61498);
            Field field = new Field(0, true, 0, true, str, -1, null, null);
            AppMethodBeat.o(61498);
            return field;
        }

        @VisibleForTesting
        public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String str, int i) {
            AppMethodBeat.i(61474);
            Field field = new Field(0, true, 0, true, str, i, null, null);
            AppMethodBeat.o(61474);
            return field;
        }

        @VisibleForTesting
        public static Field<Long, Long> forLong(String str) {
            AppMethodBeat.i(61501);
            Field field = new Field(2, false, 2, false, str, -1, null, null);
            AppMethodBeat.o(61501);
            return field;
        }

        public static Field<Long, Long> forLong(String str, int i) {
            AppMethodBeat.i(61477);
            Field field = new Field(2, false, 2, false, str, i, null, null);
            AppMethodBeat.o(61477);
            return field;
        }

        @VisibleForTesting
        public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String str) {
            AppMethodBeat.i(61502);
            Field field = new Field(2, true, 2, true, str, -1, null, null);
            AppMethodBeat.o(61502);
            return field;
        }

        public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String str, int i) {
            AppMethodBeat.i(61478);
            Field field = new Field(2, true, 2, true, str, i, null, null);
            AppMethodBeat.o(61478);
            return field;
        }

        public static Field<String, String> forString(String str) {
            AppMethodBeat.i(61511);
            Field field = new Field(7, false, 7, false, str, -1, null, null);
            AppMethodBeat.o(61511);
            return field;
        }

        public static Field<String, String> forString(String str, int i) {
            AppMethodBeat.i(61487);
            Field field = new Field(7, false, 7, false, str, i, null, null);
            AppMethodBeat.o(61487);
            return field;
        }

        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String str) {
            AppMethodBeat.i(61515);
            Field field = new Field(10, false, 10, false, str, -1, null, null);
            AppMethodBeat.o(61515);
            return field;
        }

        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String str, int i) {
            AppMethodBeat.i(61491);
            Field field = new Field(10, false, 10, false, str, i, null, null);
            AppMethodBeat.o(61491);
            return field;
        }

        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String str) {
            AppMethodBeat.i(61512);
            Field field = new Field(7, true, 7, true, str, -1, null, null);
            AppMethodBeat.o(61512);
            return field;
        }

        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String str, int i) {
            AppMethodBeat.i(61488);
            Field field = new Field(7, true, 7, true, str, i, null, null);
            AppMethodBeat.o(61488);
            return field;
        }

        public static Field withConverter(String str, int i, FieldConverter<?, ?> fieldConverter, boolean z) {
            AppMethodBeat.i(61496);
            Field field = new Field(fieldConverter.getTypeIn(), z, fieldConverter.getTypeOut(), false, str, i, null, fieldConverter);
            AppMethodBeat.o(61496);
            return field;
        }

        public static <T extends FieldConverter> Field withConverter(String str, int i, Class<T> cls, boolean z) {
            RuntimeException runtimeException;
            AppMethodBeat.i(61494);
            try {
                Field withConverter = withConverter(str, i, (FieldConverter) cls.newInstance(), z);
                AppMethodBeat.o(61494);
                return withConverter;
            } catch (InstantiationException e) {
                runtimeException = new RuntimeException(e);
                AppMethodBeat.o(61494);
                throw runtimeException;
            } catch (IllegalAccessException e2) {
                runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(61494);
                throw runtimeException;
            }
        }

        public static Field withConverter(String str, FieldConverter<?, ?> fieldConverter, boolean z) {
            AppMethodBeat.i(61495);
            Field withConverter = withConverter(str, -1, (FieldConverter) fieldConverter, z);
            AppMethodBeat.o(61495);
            return withConverter;
        }

        public static <T extends FieldConverter> Field withConverter(String str, Class<T> cls, boolean z) {
            AppMethodBeat.i(61518);
            Field withConverter = withConverter(str, -1, (Class) cls, z);
            AppMethodBeat.o(61518);
            return withConverter;
        }

        private final String zzcz() {
            return this.mConcreteTypeName == null ? null : this.mConcreteTypeName;
        }

        private final ConverterWrapper zzda() {
            AppMethodBeat.i(61468);
            if (this.zzwo == null) {
                AppMethodBeat.o(61468);
                return null;
            }
            ConverterWrapper wrap = ConverterWrapper.wrap(this.zzwo);
            AppMethodBeat.o(61468);
            return wrap;
        }

        public O convert(I i) {
            AppMethodBeat.i(61471);
            Object convert = this.zzwo.convert(i);
            AppMethodBeat.o(61471);
            return convert;
        }

        public I convertBack(O o) {
            AppMethodBeat.i(61472);
            Object convertBack = this.zzwo.convertBack(o);
            AppMethodBeat.o(61472);
            return convertBack;
        }

        public Field<I, O> copyForDictionary() {
            AppMethodBeat.i(61467);
            Field field = new Field(this.zzal, this.mTypeIn, this.mTypeInArray, this.mTypeOut, this.mTypeOutArray, this.mOutputFieldName, this.mSafeParcelableFieldId, this.mConcreteTypeName, zzda());
            AppMethodBeat.o(61467);
            return field;
        }

        public Class<? extends FastJsonResponse> getConcreteType() {
            return this.mConcreteType;
        }

        public Map<String, Field<?, ?>> getConcreteTypeFieldMappingFromDictionary() {
            AppMethodBeat.i(61470);
            Preconditions.checkNotNull(this.mConcreteTypeName);
            Preconditions.checkNotNull(this.zzwn);
            Map fieldMapping = this.zzwn.getFieldMapping(this.mConcreteTypeName);
            AppMethodBeat.o(61470);
            return fieldMapping;
        }

        public String getOutputFieldName() {
            return this.mOutputFieldName;
        }

        public int getSafeParcelableFieldId() {
            return this.mSafeParcelableFieldId;
        }

        public int getTypeIn() {
            return this.mTypeIn;
        }

        public int getTypeOut() {
            return this.mTypeOut;
        }

        public int getVersionCode() {
            return this.zzal;
        }

        public boolean hasConverter() {
            return this.zzwo != null;
        }

        public boolean isTypeInArray() {
            return this.mTypeInArray;
        }

        public boolean isTypeOutArray() {
            return this.mTypeOutArray;
        }

        public boolean isValidSafeParcelableFieldId() {
            return this.mSafeParcelableFieldId != -1;
        }

        public FastJsonResponse newConcreteTypeInstance() {
            AppMethodBeat.i(61469);
            if (this.mConcreteType == SafeParcelResponse.class) {
                Preconditions.checkNotNull(this.zzwn, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
                SafeParcelResponse safeParcelResponse = new SafeParcelResponse(this.zzwn, this.mConcreteTypeName);
                AppMethodBeat.o(61469);
                return safeParcelResponse;
            }
            FastJsonResponse fastJsonResponse = (FastJsonResponse) this.mConcreteType.newInstance();
            AppMethodBeat.o(61469);
            return fastJsonResponse;
        }

        public void setFieldMappingDictionary(FieldMappingDictionary fieldMappingDictionary) {
            this.zzwn = fieldMappingDictionary;
        }

        public String toString() {
            AppMethodBeat.i(61520);
            ToStringHelper add = Objects.toStringHelper(this).add(DownloadInfoColumns.VERSIONCODE, Integer.valueOf(this.zzal)).add("typeIn", Integer.valueOf(this.mTypeIn)).add("typeInArray", Boolean.valueOf(this.mTypeInArray)).add("typeOut", Integer.valueOf(this.mTypeOut)).add("typeOutArray", Boolean.valueOf(this.mTypeOutArray)).add("outputFieldName", this.mOutputFieldName).add("safeParcelFieldId", Integer.valueOf(this.mSafeParcelableFieldId)).add("concreteTypeName", zzcz());
            Class concreteType = getConcreteType();
            if (concreteType != null) {
                add.add("concreteType.class", concreteType.getCanonicalName());
            }
            if (this.zzwo != null) {
                add.add("converterName", this.zzwo.getClass().getCanonicalName());
            }
            String toStringHelper = add.toString();
            AppMethodBeat.o(61520);
            return toStringHelper;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(61519);
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
            SafeParcelWriter.writeInt(parcel, 2, getTypeIn());
            SafeParcelWriter.writeBoolean(parcel, 3, isTypeInArray());
            SafeParcelWriter.writeInt(parcel, 4, getTypeOut());
            SafeParcelWriter.writeBoolean(parcel, 5, isTypeOutArray());
            SafeParcelWriter.writeString(parcel, 6, getOutputFieldName(), false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            SafeParcelWriter.writeString(parcel, 8, zzcz(), false);
            SafeParcelWriter.writeParcelable(parcel, 9, zzda(), i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            AppMethodBeat.o(61519);
        }
    }

    public interface FieldConverter<I, O> {
        O convert(I i);

        I convertBack(O o);

        int getTypeIn();

        int getTypeOut();
    }

    public static InputStream getUnzippedStream(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (IOUtils.isGzipByteBuffer(bArr)) {
            try {
                return new GZIPInputStream(byteArrayInputStream);
            } catch (IOException e) {
            }
        }
        return byteArrayInputStream;
    }

    private final <I, O> void zza(Field<I, O> field, I i) {
        String outputFieldName = field.getOutputFieldName();
        Object convert = field.convert(i);
        switch (field.getTypeOut()) {
            case 0:
                if (zzb(outputFieldName, convert)) {
                    setIntegerInternal(field, outputFieldName, ((Integer) convert).intValue());
                    return;
                }
                return;
            case 1:
                setBigIntegerInternal(field, outputFieldName, (BigInteger) convert);
                return;
            case 2:
                if (zzb(outputFieldName, convert)) {
                    setLongInternal(field, outputFieldName, ((Long) convert).longValue());
                    return;
                }
                return;
            case 4:
                if (zzb(outputFieldName, convert)) {
                    setDoubleInternal(field, outputFieldName, ((Double) convert).doubleValue());
                    return;
                }
                return;
            case 5:
                setBigDecimalInternal(field, outputFieldName, (BigDecimal) convert);
                return;
            case 6:
                if (zzb(outputFieldName, convert)) {
                    setBooleanInternal(field, outputFieldName, ((Boolean) convert).booleanValue());
                    return;
                }
                return;
            case 7:
                setStringInternal(field, outputFieldName, (String) convert);
                return;
            case 8:
            case 9:
                if (zzb(outputFieldName, convert)) {
                    setDecodedBytesInternal(field, outputFieldName, (byte[]) convert);
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + field.getTypeOut());
        }
    }

    private static void zza(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.getTypeIn() == 11) {
            stringBuilder.append(((FastJsonResponse) field.getConcreteType().cast(obj)).toString());
        } else if (field.getTypeIn() == 7) {
            stringBuilder.append(QUOTE);
            stringBuilder.append(JsonUtils.escapeString((String) obj));
            stringBuilder.append(QUOTE);
        } else {
            stringBuilder.append(obj);
        }
    }

    private static <O> boolean zzb(String str, O o) {
        if (o != null) {
            return true;
        }
        if (Log.isLoggable("FastJsonResponse", 6)) {
            new StringBuilder(String.valueOf(str).length() + 58).append("Output field (").append(str).append(") has a null value, but expected a primitive");
        }
        return false;
    }

    public <T extends FastJsonResponse> void addConcreteType(String str, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeArray(String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String str, ArrayList<T> arrayList) {
        addConcreteTypeArray(str, arrayList);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String str, T t) {
        addConcreteType(str, t);
    }

    public HashMap<String, Object> getConcreteTypeArrays() {
        return null;
    }

    public HashMap<String, Object> getConcreteTypes() {
        return null;
    }

    public abstract Map<String, Field<?, ?>> getFieldMappings();

    /* Access modifiers changed, original: protected */
    public Object getFieldValue(Field field) {
        String outputFieldName = field.getOutputFieldName();
        if (field.getConcreteType() == null) {
            return getValueObject(field.getOutputFieldName());
        }
        Preconditions.checkState(getValueObject(field.getOutputFieldName()) == null, "Concrete field shouldn't be value object: %s", field.getOutputFieldName());
        Map concreteTypeArrays = field.isTypeOutArray() ? getConcreteTypeArrays() : getConcreteTypes();
        if (concreteTypeArrays != null) {
            return concreteTypeArrays.get(outputFieldName);
        }
        try {
            char toUpperCase = Character.toUpperCase(outputFieldName.charAt(0));
            String substring = outputFieldName.substring(1);
            return getClass().getMethod(new StringBuilder(String.valueOf(substring).length() + 4).append("get").append(toUpperCase).append(substring).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* Access modifiers changed, original: protected */
    public <O, I> I getOriginalValue(Field<I, O> field, Object obj) {
        return field.zzwo != null ? field.convertBack(obj) : obj;
    }

    public PostProcessor<? extends FastJsonResponse> getPostProcessor() {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A:{SYNTHETIC, Splitter:B:25:0x0045} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getResponseBody() {
        byte[] bArr;
        Throwable th;
        InputStream inputStream;
        Preconditions.checkState(this.zzwm);
        InputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(this.zzwl));
            try {
                bArr = new byte[4096];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = gZIPInputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    gZIPInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            gZIPInputStream = null;
            try {
                bArr = this.zzwl;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                inputStream = gZIPInputStream;
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        return bArr;
    }

    public int getResponseCode() {
        Preconditions.checkState(this.zzwm);
        return this.zzwk;
    }

    public abstract Object getValueObject(String str);

    /* Access modifiers changed, original: protected */
    public boolean isConcreteTypeArrayFieldSet(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    /* Access modifiers changed, original: protected */
    public boolean isConcreteTypeFieldSet(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* Access modifiers changed, original: protected */
    public boolean isFieldSet(Field field) {
        return field.getTypeOut() == 11 ? field.isTypeOutArray() ? isConcreteTypeArrayFieldSet(field.getOutputFieldName()) : isConcreteTypeFieldSet(field.getOutputFieldName()) : isPrimitiveFieldSet(field.getOutputFieldName());
    }

    public abstract boolean isPrimitiveFieldSet(String str);

    public <T extends FastJsonResponse> void parseNetworkResponse(int i, byte[] bArr) {
        this.zzwk = i;
        this.zzwl = bArr;
        this.zzwm = true;
        InputStream unzippedStream = getUnzippedStream(bArr);
        try {
            new FastParser().parse(unzippedStream, this);
        } finally {
            try {
                unzippedStream.close();
            } catch (IOException e) {
            }
        }
    }

    public final <O> void setBigDecimal(Field<BigDecimal, O> field, BigDecimal bigDecimal) {
        if (field.zzwo != null) {
            zza(field, bigDecimal);
        } else {
            setBigDecimalInternal(field, field.getOutputFieldName(), bigDecimal);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setBigDecimal(String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setBigDecimalInternal(Field<?, ?> field, String str, BigDecimal bigDecimal) {
        setBigDecimal(str, bigDecimal);
    }

    public final <O> void setBigDecimals(Field<ArrayList<BigDecimal>, O> field, ArrayList<BigDecimal> arrayList) {
        if (field.zzwo != null) {
            zza(field, arrayList);
        } else {
            setBigDecimalsInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setBigDecimals(String str, ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setBigDecimalsInternal(Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        setBigDecimals(str, (ArrayList) arrayList);
    }

    public final <O> void setBigInteger(Field<BigInteger, O> field, BigInteger bigInteger) {
        if (field.zzwo != null) {
            zza(field, bigInteger);
        } else {
            setBigIntegerInternal(field, field.getOutputFieldName(), bigInteger);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setBigInteger(String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setBigIntegerInternal(Field<?, ?> field, String str, BigInteger bigInteger) {
        setBigInteger(str, bigInteger);
    }

    public final <O> void setBigIntegers(Field<ArrayList<BigInteger>, O> field, ArrayList<BigInteger> arrayList) {
        if (field.zzwo != null) {
            zza(field, arrayList);
        } else {
            setBigIntegersInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setBigIntegers(String str, ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setBigIntegersInternal(Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        setBigIntegers(str, (ArrayList) arrayList);
    }

    public final <O> void setBoolean(Field<Boolean, O> field, boolean z) {
        if (field.zzwo != null) {
            zza(field, Boolean.valueOf(z));
        } else {
            setBooleanInternal(field, field.getOutputFieldName(), z);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setBoolean(String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setBooleanInternal(Field<?, ?> field, String str, boolean z) {
        setBoolean(str, z);
    }

    public final <O> void setBooleans(Field<ArrayList<Boolean>, O> field, ArrayList<Boolean> arrayList) {
        if (field.zzwo != null) {
            zza(field, arrayList);
        } else {
            setBooleansInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setBooleans(String str, ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setBooleansInternal(Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        setBooleans(str, (ArrayList) arrayList);
    }

    public final <O> void setDecodedBytes(Field<byte[], O> field, byte[] bArr) {
        if (field.zzwo != null) {
            zza(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.getOutputFieldName(), bArr);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setDecodedBytes(String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        setDecodedBytes(str, bArr);
    }

    public final <O> void setDouble(Field<Double, O> field, double d) {
        if (field.zzwo != null) {
            zza(field, Double.valueOf(d));
        } else {
            setDoubleInternal(field, field.getOutputFieldName(), d);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setDouble(String str, double d) {
        throw new UnsupportedOperationException("Double not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setDoubleInternal(Field<?, ?> field, String str, double d) {
        setDouble(str, d);
    }

    public final <O> void setDoubles(Field<ArrayList<Double>, O> field, ArrayList<Double> arrayList) {
        if (field.zzwo != null) {
            zza(field, arrayList);
        } else {
            setDoublesInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setDoubles(String str, ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setDoublesInternal(Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        setDoubles(str, (ArrayList) arrayList);
    }

    public final <O> void setFloat(Field<Float, O> field, float f) {
        if (field.zzwo != null) {
            zza(field, Float.valueOf(f));
        } else {
            setFloatInternal(field, field.getOutputFieldName(), f);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setFloat(String str, float f) {
        throw new UnsupportedOperationException("Float not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setFloatInternal(Field<?, ?> field, String str, float f) {
        setFloat(str, f);
    }

    public final <O> void setFloats(Field<ArrayList<Float>, O> field, ArrayList<Float> arrayList) {
        if (field.zzwo != null) {
            zza(field, arrayList);
        } else {
            setFloatsInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setFloats(String str, ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setFloatsInternal(Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        setFloats(str, (ArrayList) arrayList);
    }

    public final <O> void setInteger(Field<Integer, O> field, int i) {
        if (field.zzwo != null) {
            zza(field, Integer.valueOf(i));
        } else {
            setIntegerInternal(field, field.getOutputFieldName(), i);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setInteger(String str, int i) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setIntegerInternal(Field<?, ?> field, String str, int i) {
        setInteger(str, i);
    }

    public final <O> void setIntegers(Field<ArrayList<Integer>, O> field, ArrayList<Integer> arrayList) {
        if (field.zzwo != null) {
            zza(field, arrayList);
        } else {
            setIntegersInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setIntegers(String str, ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setIntegersInternal(Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        setIntegers(str, (ArrayList) arrayList);
    }

    public final <O> void setLong(Field<Long, O> field, long j) {
        if (field.zzwo != null) {
            zza(field, Long.valueOf(j));
        } else {
            setLongInternal(field, field.getOutputFieldName(), j);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setLong(String str, long j) {
        throw new UnsupportedOperationException("Long not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setLongInternal(Field<?, ?> field, String str, long j) {
        setLong(str, j);
    }

    public final <O> void setLongs(Field<ArrayList<Long>, O> field, ArrayList<Long> arrayList) {
        if (field.zzwo != null) {
            zza(field, arrayList);
        } else {
            setLongsInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setLongs(String str, ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setLongsInternal(Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        setLongs(str, (ArrayList) arrayList);
    }

    public final <O> void setString(Field<String, O> field, String str) {
        if (field.zzwo != null) {
            zza(field, str);
        } else {
            setStringInternal(field, field.getOutputFieldName(), str);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setString(String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setStringInternal(Field<?, ?> field, String str, String str2) {
        setString(str, str2);
    }

    public final <O> void setStringMap(Field<Map<String, String>, O> field, Map<String, String> map) {
        if (field.zzwo != null) {
            zza(field, map);
        } else {
            setStringMapInternal(field, field.getOutputFieldName(), map);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setStringMap(String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setStringMapInternal(Field<?, ?> field, String str, Map<String, String> map) {
        setStringMap(str, (Map) map);
    }

    public final <O> void setStrings(Field<ArrayList<String>, O> field, ArrayList<String> arrayList) {
        if (field.zzwo != null) {
            zza(field, arrayList);
        } else {
            setStringsInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setStrings(String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    /* Access modifiers changed, original: protected */
    public void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        setStrings(str, (ArrayList) arrayList);
    }

    public String toString() {
        Map fieldMappings = getFieldMappings();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field field = (Field) fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object originalValue = getOriginalValue(field, getFieldValue(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append(QUOTE).append(str).append("\":");
                if (originalValue != null) {
                    switch (field.getTypeOut()) {
                        case 8:
                            stringBuilder.append(QUOTE).append(Base64Utils.encode((byte[]) originalValue)).append(QUOTE);
                            break;
                        case 9:
                            stringBuilder.append(QUOTE).append(Base64Utils.encodeUrlSafe((byte[]) originalValue)).append(QUOTE);
                            break;
                        case 10:
                            MapUtils.writeStringMapToJson(stringBuilder, (HashMap) originalValue);
                            break;
                        default:
                            if (!field.isTypeInArray()) {
                                zza(stringBuilder, field, originalValue);
                                break;
                            }
                            ArrayList arrayList = (ArrayList) originalValue;
                            stringBuilder.append("[");
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                if (i > 0) {
                                    stringBuilder.append(",");
                                }
                                Object obj = arrayList.get(i);
                                if (obj != null) {
                                    zza(stringBuilder, field, obj);
                                }
                            }
                            stringBuilder.append("]");
                            break;
                    }
                }
                stringBuilder.append(BuildConfig.COMMAND);
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
