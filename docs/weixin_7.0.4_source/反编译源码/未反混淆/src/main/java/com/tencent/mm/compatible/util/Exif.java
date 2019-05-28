package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Exif {
    public static final int PARSE_EXIF_ERROR_CORRUPT = 1985;
    public static final int PARSE_EXIF_ERROR_NO_EXIF = 1983;
    public static final int PARSE_EXIF_ERROR_NO_JPEG = 1982;
    public static final int PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN = 1984;
    public static final int PARSE_EXIF_SUCCESS = 0;
    private static final String TAG = "MicroMsg.Exif";
    public double altitude = 0.0d;
    public short bitsPerSample;
    public String copyright;
    public String dateTime;
    public String dateTimeDigitized;
    public String dateTimeOriginal;
    public double exposureBiasValue;
    public double exposureTime;
    public double fNumber;
    public int fileSource;
    public byte flash;
    public double focalLength;
    public short focalLengthIn35mm;
    public String imageDescription;
    public int imageHeight;
    public int imageWidth;
    public short isoSpeedRatings;
    public double latitude = -1.0d;
    public double longitude = -1.0d;
    private android.support.d.a mExif;
    public String make;
    public short meteringMode;
    public String model;
    public short orientation;
    public int sceneType;
    public double shutterSpeedValue;
    public String software;
    public String subSecTimeOriginal;
    public double subjectDistance;
    public String yCbCrSubSampling;

    public static class a {
        public double altitude;
        public double latitude;
        public double longitude;

        public a(double d, double d2, double d3) {
            this.latitude = d;
            this.longitude = d2;
            this.altitude = d3;
        }
    }

    public int parseFromFile(String str) {
        AppMethodBeat.i(93087);
        Closeable closeable = null;
        try {
            closeable = e.openRead(str);
            this.mExif = new android.support.d.a((InputStream) closeable);
            readExifFromInterface();
            bo.b(closeable);
            AppMethodBeat.o(93087);
            return 0;
        } catch (Exception e) {
            ab.w(TAG, "Cannot read EXIF from file '%s': %s", str, e.getMessage());
            bo.b(closeable);
            AppMethodBeat.o(93087);
            return -1;
        } catch (Throwable th) {
            bo.b(closeable);
            AppMethodBeat.o(93087);
        }
    }

    public int parseFromStream(InputStream inputStream) {
        AppMethodBeat.i(93088);
        try {
            this.mExif = new android.support.d.a(inputStream);
            readExifFromInterface();
            AppMethodBeat.o(93088);
            return 0;
        } catch (Exception e) {
            ab.w(TAG, "Cannot read EXIF from stream '%s': %s", inputStream, e.getMessage());
            AppMethodBeat.o(93088);
            return -1;
        }
    }

    public int parseFrom(byte[] bArr) {
        AppMethodBeat.i(93089);
        int parseFromStream = parseFromStream(new ByteArrayInputStream(bArr));
        AppMethodBeat.o(93089);
        return parseFromStream;
    }

    public int parseFrom(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(93090);
        int parseFromStream = parseFromStream(new ByteArrayInputStream(bArr, i, i2));
        AppMethodBeat.o(93090);
        return parseFromStream;
    }

    private void readExifFromInterface() {
        int i = -1;
        AppMethodBeat.i(93091);
        if (this.mExif == null) {
            AppMethodBeat.o(93091);
            return;
        }
        double d;
        this.imageDescription = this.mExif.getAttribute(android.support.d.a.TAG_IMAGE_DESCRIPTION);
        this.make = this.mExif.getAttribute(android.support.d.a.TAG_MAKE);
        this.model = this.mExif.getAttribute(android.support.d.a.TAG_MODEL);
        this.orientation = (short) this.mExif.getAttributeInt(android.support.d.a.TAG_ORIENTATION, 0);
        this.bitsPerSample = (short) this.mExif.getAttributeInt(android.support.d.a.TAG_BITS_PER_SAMPLE, 0);
        this.software = this.mExif.getAttribute(android.support.d.a.TAG_SOFTWARE);
        this.dateTime = this.mExif.getAttribute(android.support.d.a.TAG_DATETIME);
        this.dateTimeOriginal = this.mExif.getAttribute(android.support.d.a.TAG_DATETIME_ORIGINAL);
        this.dateTimeDigitized = this.mExif.getAttribute(android.support.d.a.TAG_DATETIME_DIGITIZED);
        this.subSecTimeOriginal = this.mExif.getAttribute(android.support.d.a.TAG_SUBSEC_TIME_ORIGINAL);
        this.copyright = this.mExif.getAttribute(android.support.d.a.TAG_COPYRIGHT);
        this.exposureTime = this.mExif.getAttributeDouble(android.support.d.a.TAG_EXPOSURE_TIME, 0.0d);
        this.fNumber = this.mExif.getAttributeDouble(android.support.d.a.TAG_F_NUMBER, 0.0d);
        this.isoSpeedRatings = (short) this.mExif.getAttributeInt(android.support.d.a.TAG_ISO_SPEED_RATINGS, 0);
        this.flash = (byte) this.mExif.getAttributeInt(android.support.d.a.TAG_FLASH, 0);
        this.imageWidth = this.mExif.getAttributeInt(android.support.d.a.TAG_IMAGE_WIDTH, 0);
        this.imageHeight = this.mExif.getAttributeInt(android.support.d.a.TAG_IMAGE_LENGTH, 0);
        this.fileSource = this.mExif.getAttributeInt(android.support.d.a.TAG_FILE_SOURCE, 0);
        this.sceneType = this.mExif.getAttributeInt(android.support.d.a.TAG_SCENE_TYPE, 0);
        double[] cH = this.mExif.cH();
        if (cH != null) {
            this.latitude = cH[0];
            this.longitude = cH[1];
        }
        android.support.d.a aVar = this.mExif;
        double attributeDouble = aVar.getAttributeDouble(android.support.d.a.TAG_GPS_ALTITUDE, -1.0d);
        int attributeInt = aVar.getAttributeInt(android.support.d.a.TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            d = 0.0d;
        } else {
            if (attributeInt != 1) {
                i = 1;
            }
            d = ((double) i) * attributeDouble;
        }
        this.altitude = d;
        AppMethodBeat.o(93091);
    }

    public int getOrientationInDegree() {
        AppMethodBeat.i(93092);
        if (this.mExif != null) {
            switch (this.mExif.getAttributeInt(android.support.d.a.TAG_ORIENTATION, 1)) {
                case 3:
                case 4:
                    AppMethodBeat.o(93092);
                    return 180;
                case 5:
                case 8:
                    AppMethodBeat.o(93092);
                    return 270;
                case 6:
                case 7:
                    AppMethodBeat.o(93092);
                    return 90;
                default:
                    AppMethodBeat.o(93092);
                    return 0;
            }
        }
        switch (this.orientation) {
            case (short) 3:
                AppMethodBeat.o(93092);
                return 180;
            case (short) 6:
                AppMethodBeat.o(93092);
                return 90;
            case (short) 8:
                AppMethodBeat.o(93092);
                return 270;
            default:
                AppMethodBeat.o(93092);
                return 0;
        }
    }

    public a getLocation() {
        AppMethodBeat.i(93093);
        if (this.latitude < 0.0d || this.longitude < 0.0d) {
            AppMethodBeat.o(93093);
            return null;
        }
        a aVar = new a(this.latitude, this.longitude, this.altitude);
        AppMethodBeat.o(93093);
        return aVar;
    }

    public long getUxtimeDatatimeOriginal() {
        long j = 0;
        AppMethodBeat.i(93094);
        try {
            if (this.dateTimeOriginal == null) {
                AppMethodBeat.o(93094);
            } else {
                j = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(this.dateTimeOriginal).getTime() / 1000;
                AppMethodBeat.o(93094);
            }
        } catch (ParseException e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.o(93094);
        }
        return j;
    }

    public static Exif fromFile(String str) {
        AppMethodBeat.i(93095);
        Exif exif = new Exif();
        exif.parseFromFile(str);
        AppMethodBeat.o(93095);
        return exif;
    }

    public static Exif fromStream(InputStream inputStream) {
        AppMethodBeat.i(93096);
        Exif exif = new Exif();
        exif.parseFromStream(inputStream);
        AppMethodBeat.o(93096);
        return exif;
    }
}
