package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Creator<Format> CREATOR = new C86371();
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
    /* renamed from: id */
    public final String f2431id;
    public final int sampleRate;
    public final int width;

    /* renamed from: com.google.android.exoplayer2.Format$1 */
    static class C86371 implements Creator<Format> {
        C86371() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Format[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95192);
            Format format = new Format(parcel);
            AppMethodBeat.m2505o(95192);
            return format;
        }
    }

    /* renamed from: a */
    public static Format m15279a(String str, String str2, String str3, int i, int i2, int i3) {
        AppMethodBeat.m2504i(95193);
        Format format = new Format(str, str2, null, str3, i, -1, i2, i3, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.m2505o(95193);
        return format;
    }

    /* renamed from: a */
    public static Format m15273a(String str, String str2, int i, int i2, List<byte[]> list, float f) {
        AppMethodBeat.m2504i(95194);
        Format a = m15272a(str, str2, -1, i, i2, list, -1, f, null, -1, null, null);
        AppMethodBeat.m2505o(95194);
        return a;
    }

    /* renamed from: a */
    public static Format m15272a(String str, String str2, int i, int i2, int i3, List<byte[]> list, int i4, float f, byte[] bArr, int i5, ColorInfo colorInfo, DrmInitData drmInitData) {
        AppMethodBeat.m2504i(95195);
        Format format = new Format(str, null, str2, null, -1, i, i2, i3, -1.0f, i4, f, bArr, i5, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
        AppMethodBeat.m2505o(95195);
        return format;
    }

    /* renamed from: a */
    public static Format m15274a(String str, String str2, int i, String str3) {
        AppMethodBeat.m2504i(95196);
        Format format = new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str3, -1, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.m2505o(95196);
        return format;
    }

    /* renamed from: a */
    public static Format m15271a(String str, String str2, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, String str3) {
        AppMethodBeat.m2504i(95197);
        Format a = m15270a(str, str2, i, i2, i3, i4, -1, list, drmInitData, 0, str3);
        AppMethodBeat.m2505o(95197);
        return a;
    }

    /* renamed from: a */
    public static Format m15270a(String str, String str2, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str3) {
        AppMethodBeat.m2504i(95198);
        Format a = m15269a(str, str2, i, i2, i3, i4, i5, -1, -1, list, drmInitData, i6, str3, null);
        AppMethodBeat.m2505o(95198);
        return a;
    }

    /* renamed from: a */
    public static Format m15269a(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, int i8, String str3, Metadata metadata) {
        AppMethodBeat.m2504i(95199);
        Format format = new Format(str, null, str2, null, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str3, -1, Long.MAX_VALUE, list, drmInitData, metadata);
        AppMethodBeat.m2505o(95199);
        return format;
    }

    /* renamed from: a */
    public static Format m15280a(String str, String str2, String str3, int i, String str4) {
        AppMethodBeat.m2504i(95200);
        Format a = m15281a(str, str2, str3, i, str4, -1);
        AppMethodBeat.m2505o(95200);
        return a;
    }

    /* renamed from: a */
    public static Format m15281a(String str, String str2, String str3, int i, String str4, int i2) {
        AppMethodBeat.m2504i(95201);
        Format format = new Format(str, str2, str3, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str4, i2, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.m2505o(95201);
        return format;
    }

    /* renamed from: as */
    public static Format m15285as(String str) {
        AppMethodBeat.m2504i(95202);
        Format a = m15277a(null, str, 0, null, null);
        AppMethodBeat.m2505o(95202);
        return a;
    }

    /* renamed from: a */
    public static Format m15277a(String str, String str2, int i, String str3, DrmInitData drmInitData) {
        AppMethodBeat.m2504i(95203);
        Format a = m15276a(str, str2, i, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
        AppMethodBeat.m2505o(95203);
        return a;
    }

    /* renamed from: a */
    public static Format m15275a(String str, String str2, int i, String str3, int i2) {
        AppMethodBeat.m2504i(95204);
        Format a = m15276a(str, str2, i, str3, i2, null, Long.MAX_VALUE, Collections.emptyList());
        AppMethodBeat.m2505o(95204);
        return a;
    }

    /* renamed from: a */
    public static Format m15278a(String str, String str2, long j) {
        AppMethodBeat.m2504i(95205);
        Format a = m15276a(null, str, 0, str2, -1, null, j, Collections.emptyList());
        AppMethodBeat.m2505o(95205);
        return a;
    }

    /* renamed from: a */
    public static Format m15276a(String str, String str2, int i, String str3, int i2, DrmInitData drmInitData, long j, List<byte[]> list) {
        AppMethodBeat.m2504i(95206);
        Format format = new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str3, i2, j, list, drmInitData, null);
        AppMethodBeat.m2505o(95206);
        return format;
    }

    /* renamed from: a */
    public static Format m15282a(String str, String str2, List<byte[]> list, String str3, DrmInitData drmInitData) {
        AppMethodBeat.m2504i(95207);
        Format format = new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str3, -1, Long.MAX_VALUE, list, drmInitData, null);
        AppMethodBeat.m2505o(95207);
        return format;
    }

    /* renamed from: j */
    public static Format m15287j(String str, String str2) {
        AppMethodBeat.m2504i(95208);
        Format format = new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.m2505o(95208);
        return format;
    }

    /* renamed from: c */
    public static Format m15286c(String str, long j) {
        AppMethodBeat.m2504i(95209);
        Format format = new Format(null, null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null);
        AppMethodBeat.m2505o(95209);
        return format;
    }

    /* renamed from: k */
    public static Format m15288k(String str, String str2) {
        AppMethodBeat.m2504i(95210);
        Format format = new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
        AppMethodBeat.m2505o(95210);
        return format;
    }

    private Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        AppMethodBeat.m2504i(95211);
        this.f2431id = str;
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
        AppMethodBeat.m2505o(95211);
    }

    Format(Parcel parcel) {
        AppMethodBeat.m2504i(95212);
        this.f2431id = parcel.readString();
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
        AppMethodBeat.m2505o(95212);
    }

    /* renamed from: dw */
    public final Format mo19117dw(int i) {
        AppMethodBeat.m2504i(95213);
        Format format = new Format(this.f2431id, this.aOc, this.aOd, this.aOa, this.bitrate, i, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, this.aOs, this.aOt, this.aOu, this.aOr, this.aOf, this.aOg, this.aOb);
        AppMethodBeat.m2505o(95213);
        return format;
    }

    /* renamed from: E */
    public final Format mo19111E(long j) {
        AppMethodBeat.m2504i(95214);
        Format format = new Format(this.f2431id, this.aOc, this.aOd, this.aOa, this.bitrate, this.aOe, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, this.aOs, this.aOt, this.aOu, j, this.aOf, this.aOg, this.aOb);
        AppMethodBeat.m2505o(95214);
        return format;
    }

    /* renamed from: a */
    public final Format mo19114a(String str, String str2, int i, int i2, int i3, int i4, String str3) {
        AppMethodBeat.m2504i(95215);
        Format format = new Format(str, this.aOc, this.aOd, str2, i, this.aOe, i2, i3, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, i4, str3, this.aOu, this.aOr, this.aOf, this.aOg, this.aOb);
        AppMethodBeat.m2505o(95215);
        return format;
    }

    /* renamed from: aY */
    public final Format mo19115aY(int i, int i2) {
        AppMethodBeat.m2504i(95216);
        Format format = new Format(this.f2431id, this.aOc, this.aOd, this.aOa, this.bitrate, this.aOe, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, i, i2, this.aOs, this.aOt, this.aOu, this.aOr, this.aOf, this.aOg, this.aOb);
        AppMethodBeat.m2505o(95216);
        return format;
    }

    /* renamed from: a */
    public final Format mo19112a(DrmInitData drmInitData) {
        AppMethodBeat.m2504i(95217);
        Format format = new Format(this.f2431id, this.aOc, this.aOd, this.aOa, this.bitrate, this.aOe, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, this.aOs, this.aOt, this.aOu, this.aOr, this.aOf, drmInitData, this.aOb);
        AppMethodBeat.m2505o(95217);
        return format;
    }

    /* renamed from: a */
    public final Format mo19113a(Metadata metadata) {
        AppMethodBeat.m2504i(95218);
        Format format = new Format(this.f2431id, this.aOc, this.aOd, this.aOa, this.bitrate, this.aOe, this.width, this.height, this.aOh, this.aOi, this.aOj, this.aOl, this.aOk, this.aOm, this.aOn, this.sampleRate, this.aOo, this.aOp, this.aOq, this.aOs, this.aOt, this.aOu, this.aOr, this.aOf, this.aOg, metadata);
        AppMethodBeat.m2505o(95218);
        return format;
    }

    /* renamed from: qb */
    public final int mo19120qb() {
        return (this.width == -1 || this.height == -1) ? -1 : this.width * this.height;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    /* renamed from: qc */
    public final MediaFormat mo19121qc() {
        AppMethodBeat.m2504i(95219);
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.aOd);
        String str = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        String str2 = this.aOt;
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
        m15284a(mediaFormat, "max-input-size", this.aOe);
        m15284a(mediaFormat, "width", this.width);
        m15284a(mediaFormat, "height", this.height);
        str = "frame-rate";
        float f = this.aOh;
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
        m15284a(mediaFormat, "rotation-degrees", this.aOi);
        m15284a(mediaFormat, "channel-count", this.aOn);
        m15284a(mediaFormat, "sample-rate", this.sampleRate);
        m15284a(mediaFormat, "encoder-delay", this.aOp);
        m15284a(mediaFormat, "encoder-padding", this.aOq);
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
            m15284a(mediaFormat, "color-transfer", colorInfo.aUV);
            m15284a(mediaFormat, "color-standard", colorInfo.aUU);
            m15284a(mediaFormat, "color-range", colorInfo.aUW);
            str2 = "hdr-static-info";
            byte[] bArr = colorInfo.brS;
            if (bArr != null) {
                mediaFormat.setByteBuffer(str2, ByteBuffer.wrap(bArr));
            }
        }
        AppMethodBeat.m2505o(95219);
        return mediaFormat;
    }

    public final String toString() {
        AppMethodBeat.m2504i(95220);
        String str = "Format(" + this.f2431id + ", " + this.aOc + ", " + this.aOd + ", " + this.bitrate + ", " + this.aOt + ", [" + this.width + ", " + this.height + ", " + this.aOh + "], [" + this.aOn + ", " + this.sampleRate + "])";
        AppMethodBeat.m2505o(95220);
        return str;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        AppMethodBeat.m2504i(95221);
        if (this.aBR == 0) {
            hashCode = ((this.aOg == null ? 0 : this.aOg.hashCode()) + (((((this.aOt == null ? 0 : this.aOt.hashCode()) + (((((((((((((this.aOa == null ? 0 : this.aOa.hashCode()) + (((this.aOd == null ? 0 : this.aOd.hashCode()) + (((this.aOc == null ? 0 : this.aOc.hashCode()) + (((this.f2431id == null ? 0 : this.f2431id.hashCode()) + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.aOn) * 31) + this.sampleRate) * 31)) * 31) + this.aOu) * 31)) * 31;
            if (this.aOb != null) {
                i = this.aOb.hashCode();
            }
            this.aBR = hashCode + i;
        }
        hashCode = this.aBR;
        AppMethodBeat.m2505o(95221);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95222);
        if (this == obj) {
            AppMethodBeat.m2505o(95222);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95222);
            return false;
        } else {
            Format format = (Format) obj;
            if (this.bitrate == format.bitrate && this.aOe == format.aOe && this.width == format.width && this.height == format.height && this.aOh == format.aOh && this.aOi == format.aOi && this.aOj == format.aOj && this.aOk == format.aOk && this.aOn == format.aOn && this.sampleRate == format.sampleRate && this.aOo == format.aOo && this.aOp == format.aOp && this.aOq == format.aOq && this.aOr == format.aOr && this.aOs == format.aOs && C17675v.m27574j(this.f2431id, format.f2431id) && C17675v.m27574j(this.aOt, format.aOt) && this.aOu == format.aOu && C17675v.m27574j(this.aOc, format.aOc) && C17675v.m27574j(this.aOd, format.aOd) && C17675v.m27574j(this.aOa, format.aOa) && C17675v.m27574j(this.aOg, format.aOg) && C17675v.m27574j(this.aOb, format.aOb) && C17675v.m27574j(this.aOm, format.aOm) && Arrays.equals(this.aOl, format.aOl) && this.aOf.size() == format.aOf.size()) {
                int i = 0;
                while (i < this.aOf.size()) {
                    if (Arrays.equals((byte[]) this.aOf.get(i), (byte[]) format.aOf.get(i))) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(95222);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(95222);
                return true;
            }
            AppMethodBeat.m2505o(95222);
            return false;
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m15284a(MediaFormat mediaFormat, String str, int i) {
        AppMethodBeat.m2504i(95223);
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
        AppMethodBeat.m2505o(95223);
    }

    /* renamed from: a */
    public static String m15283a(Format format) {
        AppMethodBeat.m2504i(95224);
        String str;
        if (format == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(95224);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append(format.f2431id).append(", mimeType=").append(format.aOd);
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
        AppMethodBeat.m2505o(95224);
        return str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95225);
        parcel.writeString(this.f2431id);
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
        AppMethodBeat.m2505o(95225);
    }

    static {
        AppMethodBeat.m2504i(95226);
        AppMethodBeat.m2505o(95226);
    }
}
