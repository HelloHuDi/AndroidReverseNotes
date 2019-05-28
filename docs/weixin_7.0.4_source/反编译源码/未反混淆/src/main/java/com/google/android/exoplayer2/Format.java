package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Creator<Format> CREATOR = new Creator<Format>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Format[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(95192);
            Format format = new Format(parcel);
            AppMethodBeat.o(95192);
            return format;
        }
    };
    private int aBR;
    public final String aOa;
    public final Metadata aOb;
    public final String aOc;
    public final String aOd;
    public final int aOe;
    public final List<byte[]> aOf;
    public final DrmInitData aOg;
    public final float aOh;
    public final int aOi;
    public final float aOj;
    public final int aOk;
    public final byte[] aOl;
    public final ColorInfo aOm;
    public final int aOn;
    public final int aOo;
    public final int aOp;
    public final int aOq;
    public final long aOr;
    public final int aOs;
    public final String aOt;
    public final int aOu;
    public final int bitrate;
    public final int height;
    public final String id;
    public final int sampleRate;
    public final int width;

    public static Format a(String str, String str2, String str3, int i, int i2, int i3) {
        AppMethodBeat.i(95193);
        Format format = new Format(str, str2, null, str3, i, -1, i2, i3, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.o(95193);
        return format;
    }

    public static Format a(String str, String str2, int i, int i2, List<byte[]> list, float f) {
        AppMethodBeat.i(95194);
        Format a = a(str, str2, -1, i, i2, list, -1, f, null, -1, null, null);
        AppMethodBeat.o(95194);
        return a;
    }

    public static Format a(String str, String str2, int i, int i2, int i3, List<byte[]> list, int i4, float f, byte[] bArr, int i5, ColorInfo colorInfo, DrmInitData drmInitData) {
        AppMethodBeat.i(95195);
        Format format = new Format(str, null, str2, null, -1, i, i2, i3, -1.0f, i4, f, bArr, i5, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
        AppMethodBeat.o(95195);
        return format;
    }

    public static Format a(String str, String str2, int i, String str3) {
        AppMethodBeat.i(95196);
        Format format = new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str3, -1, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.o(95196);
        return format;
    }

    public static Format a(String str, String str2, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, String str3) {
        AppMethodBeat.i(95197);
        Format a = a(str, str2, i, i2, i3, i4, -1, list, drmInitData, 0, str3);
        AppMethodBeat.o(95197);
        return a;
    }

    public static Format a(String str, String str2, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str3) {
        AppMethodBeat.i(95198);
        Format a = a(str, str2, i, i2, i3, i4, i5, -1, -1, list, drmInitData, i6, str3, null);
        AppMethodBeat.o(95198);
        return a;
    }

    public static Format a(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, int i8, String str3, Metadata metadata) {
        AppMethodBeat.i(95199);
        Format format = new Format(str, null, str2, null, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str3, -1, Long.MAX_VALUE, list, drmInitData, metadata);
        AppMethodBeat.o(95199);
        return format;
    }

    public static Format a(String str, String str2, String str3, int i, String str4) {
        AppMethodBeat.i(95200);
        Format a = a(str, str2, str3, i, str4, -1);
        AppMethodBeat.o(95200);
        return a;
    }

    public static Format a(String str, String str2, String str3, int i, String str4, int i2) {
        AppMethodBeat.i(95201);
        Format format = new Format(str, str2, str3, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str4, i2, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.o(95201);
        return format;
    }

    public static Format as(String str) {
        AppMethodBeat.i(95202);
        Format a = a(null, str, 0, null, null);
        AppMethodBeat.o(95202);
        return a;
    }

    public static Format a(String str, String str2, int i, String str3, DrmInitData drmInitData) {
        AppMethodBeat.i(95203);
        Format a = a(str, str2, i, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
        AppMethodBeat.o(95203);
        return a;
    }

    public static Format a(String str, String str2, int i, String str3, int i2) {
        AppMethodBeat.i(95204);
        Format a = a(str, str2, i, str3, i2, null, Long.MAX_VALUE, Collections.emptyList());
        AppMethodBeat.o(95204);
        return a;
    }

    public static Format a(String str, String str2, long j) {
        AppMethodBeat.i(95205);
        Format a = a(null, str, 0, str2, -1, null, j, Collections.emptyList());
        AppMethodBeat.o(95205);
        return a;
    }

    public static Format a(String str, String str2, int i, String str3, int i2, DrmInitData drmInitData, long j, List<byte[]> list) {
        AppMethodBeat.i(95206);
        Format format = new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str3, i2, j, list, drmInitData, null);
        AppMethodBeat.o(95206);
        return format;
    }

    public static Format a(String str, String str2, List<byte[]> list, String str3, DrmInitData drmInitData) {
        AppMethodBeat.i(95207);
        Format format = new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str3, -1, Long.MAX_VALUE, list, drmInitData, null);
        AppMethodBeat.o(95207);
        return format;
    }

    public static Format j(String str, String str2) {
        AppMethodBeat.i(95208);
        Format format = new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.o(95208);
        return format;
    }

    public static Format c(String str, long j) {
        AppMethodBeat.i(95209);
        Format format = new Format(null, null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null);
        AppMethodBeat.o(95209);
        return format;
    }

    public static Format k(String str, String str2) {
        AppMethodBeat.i(95210);
        Format format = new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.o(95210);
        return format;
    }

    private Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        AppMethodBeat.i(95211);
        this.id = str;
        this.aOc = str2;
        this.aOd = str3;
        this.aOa = str4;
        this.bitrate = i;
        this.aOe = i2;
        this.width = i3;
        this.height = i4;
        this.aOh = f;
        this.aOi = i5;
        this.aOj = f2;
        this.aOl = bArr;
        this.aOk = i6;
        this.aOm = colorInfo;
        this.aOn = i7;
        this.sampleRate = i8;
        this.aOo = i9;
        this.aOp = i10;
        this.aOq = i11;
        this.aOs = i12;
        this.aOt = str5;
        this.aOu = i13;
        this.aOr = j;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.aOf = list;
        this.aOg = drmInitData;
        this.aOb = metadata;
        AppMethodBeat.o(95211);
    }

    Format(Parcel parcel) {
        AppMethodBeat.i(95212);
        this.id = parcel.readString();
        this.aOc = parcel.readString();
        this.aOd = parcel.readString();
        this.aOa = parcel.readString();
        this.bitrate = parcel.readInt();
        this.aOe = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.aOh = parcel.readFloat();
        this.aOi = parcel.readInt();
        this.aOj = parcel.readFloat();
        this.aOl = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
        this.aOk = parcel.readInt();
        this.aOm = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.aOn = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.aOo = parcel.readInt();
        this.aOp = parcel.readInt();
        this.aOq = parcel.readInt();
        this.aOs = parcel.readInt();
        this.aOt = parcel.readString();
        this.aOu = parcel.readInt();
        this.aOr = parcel.readLong();
        int readInt = parcel.readInt();
        this.aOf = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.aOf.add(parcel.createByteArray());
        }
        this.aOg = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.aOb = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        AppMethodBeat.o(95212);
    }

    public final Format dw(int i) {
        AppMethodBeat.i(95213);
        Format format = new Format(this.id, this.aOc, this.aOd, this.aOa, this.bitrate, i, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, this.aOs, this.aOt, this.aOu, this.aOr, this.aOf, this.aOg, this.aOb);
        AppMethodBeat.o(95213);
        return format;
    }

    public final Format E(long j) {
        AppMethodBeat.i(95214);
        Format format = new Format(this.id, this.aOc, this.aOd, this.aOa, this.bitrate, this.aOe, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, this.aOs, this.aOt, this.aOu, j, this.aOf, this.aOg, this.aOb);
        AppMethodBeat.o(95214);
        return format;
    }

    public final Format a(String str, String str2, int i, int i2, int i3, int i4, String str3) {
        AppMethodBeat.i(95215);
        Format format = new Format(str, this.aOc, this.aOd, str2, i, this.aOe, i2, i3, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, i4, str3, this.aOu, this.aOr, this.aOf, this.aOg, this.aOb);
        AppMethodBeat.o(95215);
        return format;
    }

    public final Format aY(int i, int i2) {
        AppMethodBeat.i(95216);
        Format format = new Format(this.id, this.aOc, this.aOd, this.aOa, this.bitrate, this.aOe, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, i, i2, this.aOs, this.aOt, this.aOu, this.aOr, this.aOf, this.aOg, this.aOb);
        AppMethodBeat.o(95216);
        return format;
    }

    public final Format a(DrmInitData drmInitData) {
        AppMethodBeat.i(95217);
        Format format = new Format(this.id, this.aOc, this.aOd, this.aOa, this.bitrate, this.aOe, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, this.aOs, this.aOt, this.aOu, this.aOr, this.aOf, drmInitData, this.aOb);
        AppMethodBeat.o(95217);
        return format;
    }

    public final Format a(Metadata metadata) {
        AppMethodBeat.i(95218);
        Format format = new Format(this.id, this.aOc, this.aOd, this.aOa, this.bitrate, this.aOe, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, this.aOs, this.aOt, this.aOu, this.aOr, this.aOf, this.aOg, metadata);
        AppMethodBeat.o(95218);
        return format;
    }

    public final int qb() {
        return (this.width == -1 || this.height == -1) ? -1 : this.width * this.height;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat qc() {
        AppMethodBeat.i(95219);
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.aOd);
        String str = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        String str2 = this.aOt;
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
        a(mediaFormat, "max-input-size", this.aOe);
        a(mediaFormat, "width", this.width);
        a(mediaFormat, "height", this.height);
        str = "frame-rate";
        float f = this.aOh;
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
        a(mediaFormat, "rotation-degrees", this.aOi);
        a(mediaFormat, "channel-count", this.aOn);
        a(mediaFormat, "sample-rate", this.sampleRate);
        a(mediaFormat, "encoder-delay", this.aOp);
        a(mediaFormat, "encoder-padding", this.aOq);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aOf.size()) {
                break;
            }
            mediaFormat.setByteBuffer("csd-".concat(String.valueOf(i2)), ByteBuffer.wrap((byte[]) this.aOf.get(i2)));
            i = i2 + 1;
        }
        ColorInfo colorInfo = this.aOm;
        if (colorInfo != null) {
            a(mediaFormat, "color-transfer", colorInfo.aUV);
            a(mediaFormat, "color-standard", colorInfo.aUU);
            a(mediaFormat, "color-range", colorInfo.aUW);
            str2 = "hdr-static-info";
            byte[] bArr = colorInfo.brS;
            if (bArr != null) {
                mediaFormat.setByteBuffer(str2, ByteBuffer.wrap(bArr));
            }
        }
        AppMethodBeat.o(95219);
        return mediaFormat;
    }

    public final String toString() {
        AppMethodBeat.i(95220);
        String str = "Format(" + this.id + ", " + this.aOc + ", " + this.aOd + ", " + this.bitrate + ", " + this.aOt + ", [" + this.width + ", " + this.height + ", " + this.aOh + "], [" + this.aOn + ", " + this.sampleRate + "])";
        AppMethodBeat.o(95220);
        return str;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.i(95221);
        if (this.aBR == 0) {
            hashCode = ((this.aOg == null ? 0 : this.aOg.hashCode()) + (((((this.aOt == null ? 0 : this.aOt.hashCode()) + (((((((((((((this.aOa == null ? 0 : this.aOa.hashCode()) + (((this.aOd == null ? 0 : this.aOd.hashCode()) + (((this.aOc == null ? 0 : this.aOc.hashCode()) + (((this.id == null ? 0 : this.id.hashCode()) + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.aOn) * 31) + this.sampleRate) * 31)) * 31) + this.aOu) * 31)) * 31;
            if (this.aOb != null) {
                i = this.aOb.hashCode();
            }
            this.aBR = hashCode + i;
        }
        hashCode = this.aBR;
        AppMethodBeat.o(95221);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95222);
        if (this == obj) {
            AppMethodBeat.o(95222);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95222);
            return false;
        } else {
            Format format = (Format) obj;
            if (this.bitrate == format.bitrate && this.aOe == format.aOe && this.width == format.width && this.height == format.height && this.aOh == format.aOh && this.aOi == format.aOi && this.aOj == format.aOj && this.aOk == format.aOk && this.aOn == format.aOn && this.sampleRate == format.sampleRate && this.aOo == format.aOo && this.aOp == format.aOp && this.aOq == format.aOq && this.aOr == format.aOr && this.aOs == format.aOs && v.j(this.id, format.id) && v.j(this.aOt, format.aOt) && this.aOu == format.aOu && v.j(this.aOc, format.aOc) && v.j(this.aOd, format.aOd) && v.j(this.aOa, format.aOa) && v.j(this.aOg, format.aOg) && v.j(this.aOb, format.aOb) && v.j(this.aOm, format.aOm) && Arrays.equals(this.aOl, format.aOl) && this.aOf.size() == format.aOf.size()) {
                int i = 0;
                while (i < this.aOf.size()) {
                    if (Arrays.equals((byte[]) this.aOf.get(i), (byte[]) format.aOf.get(i))) {
                        i++;
                    } else {
                        AppMethodBeat.o(95222);
                        return false;
                    }
                }
                AppMethodBeat.o(95222);
                return true;
            }
            AppMethodBeat.o(95222);
            return false;
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i) {
        AppMethodBeat.i(95223);
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
        AppMethodBeat.o(95223);
    }

    public static String a(Format format) {
        AppMethodBeat.i(95224);
        String str;
        if (format == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(95224);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append(format.id).append(", mimeType=").append(format.aOd);
        if (format.bitrate != -1) {
            stringBuilder.append(", bitrate=").append(format.bitrate);
        }
        if (!(format.width == -1 || format.height == -1)) {
            stringBuilder.append(", res=").append(format.width).append(VideoMaterialUtil.CRAZYFACE_X).append(format.height);
        }
        if (format.aOh != -1.0f) {
            stringBuilder.append(", fps=").append(format.aOh);
        }
        if (format.aOn != -1) {
            stringBuilder.append(", channels=").append(format.aOn);
        }
        if (format.sampleRate != -1) {
            stringBuilder.append(", sample_rate=").append(format.sampleRate);
        }
        if (format.aOt != null) {
            stringBuilder.append(", language=").append(format.aOt);
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(95224);
        return str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(95225);
        parcel.writeString(this.id);
        parcel.writeString(this.aOc);
        parcel.writeString(this.aOd);
        parcel.writeString(this.aOa);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.aOe);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.aOh);
        parcel.writeInt(this.aOi);
        parcel.writeFloat(this.aOj);
        parcel.writeInt(this.aOl != null ? 1 : 0);
        if (this.aOl != null) {
            parcel.writeByteArray(this.aOl);
        }
        parcel.writeInt(this.aOk);
        parcel.writeParcelable(this.aOm, i);
        parcel.writeInt(this.aOn);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.aOo);
        parcel.writeInt(this.aOp);
        parcel.writeInt(this.aOq);
        parcel.writeInt(this.aOs);
        parcel.writeString(this.aOt);
        parcel.writeInt(this.aOu);
        parcel.writeLong(this.aOr);
        int size = this.aOf.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray((byte[]) this.aOf.get(i2));
        }
        parcel.writeParcelable(this.aOg, 0);
        parcel.writeParcelable(this.aOb, 0);
        AppMethodBeat.o(95225);
    }

    static {
        AppMethodBeat.i(95226);
        AppMethodBeat.o(95226);
    }
}
