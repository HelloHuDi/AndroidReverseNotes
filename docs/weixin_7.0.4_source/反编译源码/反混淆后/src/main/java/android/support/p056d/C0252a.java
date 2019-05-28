package android.support.p056d;

import android.content.res.AssetManager.AssetInputStream;
import android.util.Pair;
import com.facebook.internal.Utility;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.C42541c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C27003i;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C38405e;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.view.C31128d;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: android.support.d.a */
public class C0252a {
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final C0250d TAG_RAF_IMAGE_SIZE = new C0250d(TAG_STRIP_OFFSETS, 273, 3, (byte) 0);
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    /* renamed from: vR */
    private static final List<Integer> f110vR = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(8)});
    /* renamed from: vS */
    private static final List<Integer> f111vS = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5)});
    /* renamed from: vT */
    public static final int[] f112vT = new int[]{8, 8, 8};
    /* renamed from: vU */
    public static final int[] f113vU = new int[]{4};
    /* renamed from: vV */
    public static final int[] f114vV = new int[]{8};
    /* renamed from: vW */
    static final byte[] f115vW = new byte[]{(byte) -1, (byte) -40, (byte) -1};
    /* renamed from: vX */
    private static final byte[] f116vX = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 0};
    /* renamed from: vY */
    private static final byte[] f117vY = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 85, (byte) 83, (byte) 0, (byte) 73, (byte) 73};
    /* renamed from: vZ */
    private static SimpleDateFormat f118vZ;
    /* renamed from: wL */
    private static final Pattern f119wL = Pattern.compile(".*[1-9].*");
    /* renamed from: wM */
    private static final Pattern f120wM = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    /* renamed from: wa */
    static final String[] f121wa = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    /* renamed from: wb */
    static final int[] f122wb = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    /* renamed from: wc */
    private static final byte[] f123wc = new byte[]{(byte) 65, (byte) 83, (byte) 67, (byte) 73, (byte) 73, (byte) 0, (byte) 0, (byte) 0};
    /* renamed from: wd */
    private static final C0250d[] f124wd = new C0250d[]{new C0250d(TAG_NEW_SUBFILE_TYPE, C31128d.MIC_PTU_ZIPAI_LIGHTRED, 4, (byte) 0), new C0250d(TAG_SUBFILE_TYPE, 255, 4, (byte) 0), new C0250d(TAG_IMAGE_WIDTH, 256, (byte) 0), new C0250d(TAG_IMAGE_LENGTH, (int) C31128d.MIC_PTU_ZIPAI_TOKYO, (byte) 0), new C0250d(TAG_BITS_PER_SAMPLE, C31128d.MIC_PTU_ZIPAI_SAPPORO, 3, (byte) 0), new C0250d(TAG_COMPRESSION, C31128d.MIC_PTU_ZIPAI_MEDSEA, 3, (byte) 0), new C0250d(TAG_PHOTOMETRIC_INTERPRETATION, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM, 3, (byte) 0), new C0250d(TAG_IMAGE_DESCRIPTION, 270, 2, (byte) 0), new C0250d(TAG_MAKE, 271, 2, (byte) 0), new C0250d(TAG_MODEL, 272, 2, (byte) 0), new C0250d(TAG_STRIP_OFFSETS, 273, (byte) 0), new C0250d(TAG_ORIENTATION, 274, 3, (byte) 0), new C0250d(TAG_SAMPLES_PER_PIXEL, 277, 3, (byte) 0), new C0250d(TAG_ROWS_PER_STRIP, (int) C31128d.MIC_PTU_TRANS_XINGYE, (byte) 0), new C0250d(TAG_STRIP_BYTE_COUNTS, (int) C31128d.MIC_PTU_TRANS_ROUHE, (byte) 0), new C0250d(TAG_X_RESOLUTION, C31128d.MIC_PTU_BAIXI, 5, (byte) 0), new C0250d(TAG_Y_RESOLUTION, 283, 5, (byte) 0), new C0250d(TAG_PLANAR_CONFIGURATION, 284, 3, (byte) 0), new C0250d(TAG_RESOLUTION_UNIT, C31128d.MIC_PTU_YINGTAOBUDING, 3, (byte) 0), new C0250d(TAG_TRANSFER_FUNCTION, 301, 3, (byte) 0), new C0250d(TAG_SOFTWARE, C31128d.MIC_PTU_QINGCHENG, 2, (byte) 0), new C0250d(TAG_DATETIME, 306, 2, (byte) 0), new C0250d(TAG_ARTIST, C38405e.CTRL_INDEX, 2, (byte) 0), new C0250d(TAG_WHITE_POINT, 318, 5, (byte) 0), new C0250d(TAG_PRIMARY_CHROMATICITIES, ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5, (byte) 0), new C0250d(TAG_SUB_IFD_POINTER, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4, (byte) 0), new C0250d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0), new C0250d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0), new C0250d(TAG_Y_CB_CR_COEFFICIENTS, C27003i.CTRL_INDEX, 5, (byte) 0), new C0250d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3, (byte) 0), new C0250d(TAG_Y_CB_CR_POSITIONING, 531, 3, (byte) 0), new C0250d(TAG_REFERENCE_BLACK_WHITE, C42541c.CTRL_INDEX, 5, (byte) 0), new C0250d(TAG_COPYRIGHT, 33432, 2, (byte) 0), new C0250d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new C0250d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new C0250d(TAG_RW2_SENSOR_TOP_BORDER, 4, 4, (byte) 0), new C0250d(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4, (byte) 0), new C0250d(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4, (byte) 0), new C0250d(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4, (byte) 0), new C0250d(TAG_RW2_ISO, 23, 3, (byte) 0), new C0250d(TAG_RW2_JPG_FROM_RAW, 46, 7, (byte) 0)};
    /* renamed from: we */
    private static final C0250d[] f125we = new C0250d[]{new C0250d(TAG_EXPOSURE_TIME, 33434, 5, (byte) 0), new C0250d(TAG_F_NUMBER, 33437, 5, (byte) 0), new C0250d(TAG_EXPOSURE_PROGRAM, 34850, 3, (byte) 0), new C0250d(TAG_SPECTRAL_SENSITIVITY, 34852, 2, (byte) 0), new C0250d(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3, (byte) 0), new C0250d(TAG_OECF, 34856, 7, (byte) 0), new C0250d(TAG_EXIF_VERSION, 36864, 2, (byte) 0), new C0250d(TAG_DATETIME_ORIGINAL, 36867, 2, (byte) 0), new C0250d(TAG_DATETIME_DIGITIZED, 36868, 2, (byte) 0), new C0250d(TAG_COMPONENTS_CONFIGURATION, 37121, 7, (byte) 0), new C0250d(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5, (byte) 0), new C0250d(TAG_SHUTTER_SPEED_VALUE, 37377, 10, (byte) 0), new C0250d(TAG_APERTURE_VALUE, 37378, 5, (byte) 0), new C0250d(TAG_BRIGHTNESS_VALUE, 37379, 10, (byte) 0), new C0250d(TAG_EXPOSURE_BIAS_VALUE, 37380, 10, (byte) 0), new C0250d(TAG_MAX_APERTURE_VALUE, 37381, 5, (byte) 0), new C0250d(TAG_SUBJECT_DISTANCE, 37382, 5, (byte) 0), new C0250d(TAG_METERING_MODE, 37383, 3, (byte) 0), new C0250d(TAG_LIGHT_SOURCE, 37384, 3, (byte) 0), new C0250d(TAG_FLASH, 37385, 3, (byte) 0), new C0250d(TAG_FOCAL_LENGTH, 37386, 5, (byte) 0), new C0250d(TAG_SUBJECT_AREA, 37396, 3, (byte) 0), new C0250d(TAG_MAKER_NOTE, 37500, 7, (byte) 0), new C0250d(TAG_USER_COMMENT, 37510, 7, (byte) 0), new C0250d(TAG_SUBSEC_TIME, 37520, 2, (byte) 0), new C0250d(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2, (byte) 0), new C0250d(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2, (byte) 0), new C0250d(TAG_FLASHPIX_VERSION, 40960, 7, (byte) 0), new C0250d(TAG_COLOR_SPACE, 40961, 3, (byte) 0), new C0250d(TAG_PIXEL_X_DIMENSION, 40962, (byte) 0), new C0250d(TAG_PIXEL_Y_DIMENSION, 40963, (byte) 0), new C0250d(TAG_RELATED_SOUND_FILE, 40964, 2, (byte) 0), new C0250d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4, (byte) 0), new C0250d(TAG_FLASH_ENERGY, 41483, 5, (byte) 0), new C0250d(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7, (byte) 0), new C0250d(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5, (byte) 0), new C0250d(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5, (byte) 0), new C0250d(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3, (byte) 0), new C0250d(TAG_SUBJECT_LOCATION, 41492, 3, (byte) 0), new C0250d(TAG_EXPOSURE_INDEX, 41493, 5, (byte) 0), new C0250d(TAG_SENSING_METHOD, 41495, 3, (byte) 0), new C0250d(TAG_FILE_SOURCE, 41728, 7, (byte) 0), new C0250d(TAG_SCENE_TYPE, 41729, 7, (byte) 0), new C0250d(TAG_CFA_PATTERN, 41730, 7, (byte) 0), new C0250d(TAG_CUSTOM_RENDERED, 41985, 3, (byte) 0), new C0250d(TAG_EXPOSURE_MODE, 41986, 3, (byte) 0), new C0250d(TAG_WHITE_BALANCE, 41987, 3, (byte) 0), new C0250d(TAG_DIGITAL_ZOOM_RATIO, 41988, 5, (byte) 0), new C0250d(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3, (byte) 0), new C0250d(TAG_SCENE_CAPTURE_TYPE, 41990, 3, (byte) 0), new C0250d(TAG_GAIN_CONTROL, 41991, 3, (byte) 0), new C0250d(TAG_CONTRAST, 41992, 3, (byte) 0), new C0250d(TAG_SATURATION, 41993, 3, (byte) 0), new C0250d(TAG_SHARPNESS, 41994, 3, (byte) 0), new C0250d(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7, (byte) 0), new C0250d(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3, (byte) 0), new C0250d(TAG_IMAGE_UNIQUE_ID, 42016, 2, (byte) 0), new C0250d(TAG_DNG_VERSION, 50706, 1, (byte) 0), new C0250d(TAG_DEFAULT_CROP_SIZE, 50720, (byte) 0)};
    /* renamed from: wf */
    private static final C0250d[] f126wf = new C0250d[]{new C0250d(TAG_GPS_VERSION_ID, 0, 1, (byte) 0), new C0250d(TAG_GPS_LATITUDE_REF, 1, 2, (byte) 0), new C0250d(TAG_GPS_LATITUDE, 2, 5, (byte) 0), new C0250d(TAG_GPS_LONGITUDE_REF, 3, 2, (byte) 0), new C0250d(TAG_GPS_LONGITUDE, 4, 5, (byte) 0), new C0250d(TAG_GPS_ALTITUDE_REF, 5, 1, (byte) 0), new C0250d(TAG_GPS_ALTITUDE, 6, 5, (byte) 0), new C0250d(TAG_GPS_TIMESTAMP, 7, 5, (byte) 0), new C0250d(TAG_GPS_SATELLITES, 8, 2, (byte) 0), new C0250d(TAG_GPS_STATUS, 9, 2, (byte) 0), new C0250d(TAG_GPS_MEASURE_MODE, 10, 2, (byte) 0), new C0250d(TAG_GPS_DOP, 11, 5, (byte) 0), new C0250d(TAG_GPS_SPEED_REF, 12, 2, (byte) 0), new C0250d(TAG_GPS_SPEED, 13, 5, (byte) 0), new C0250d(TAG_GPS_TRACK_REF, 14, 2, (byte) 0), new C0250d(TAG_GPS_TRACK, 15, 5, (byte) 0), new C0250d(TAG_GPS_IMG_DIRECTION_REF, 16, 2, (byte) 0), new C0250d(TAG_GPS_IMG_DIRECTION, 17, 5, (byte) 0), new C0250d(TAG_GPS_MAP_DATUM, 18, 2, (byte) 0), new C0250d(TAG_GPS_DEST_LATITUDE_REF, 19, 2, (byte) 0), new C0250d(TAG_GPS_DEST_LATITUDE, 20, 5, (byte) 0), new C0250d(TAG_GPS_DEST_LONGITUDE_REF, 21, 2, (byte) 0), new C0250d(TAG_GPS_DEST_LONGITUDE, 22, 5, (byte) 0), new C0250d(TAG_GPS_DEST_BEARING_REF, 23, 2, (byte) 0), new C0250d(TAG_GPS_DEST_BEARING, 24, 5, (byte) 0), new C0250d(TAG_GPS_DEST_DISTANCE_REF, 25, 2, (byte) 0), new C0250d(TAG_GPS_DEST_DISTANCE, 26, 5, (byte) 0), new C0250d(TAG_GPS_PROCESSING_METHOD, 27, 7, (byte) 0), new C0250d(TAG_GPS_AREA_INFORMATION, 28, 7, (byte) 0), new C0250d(TAG_GPS_DATESTAMP, 29, 2, (byte) 0), new C0250d(TAG_GPS_DIFFERENTIAL, 30, 3, (byte) 0)};
    /* renamed from: wg */
    private static final C0250d[] f127wg = new C0250d[]{new C0250d(TAG_INTEROPERABILITY_INDEX, 1, 2, (byte) 0)};
    /* renamed from: wh */
    private static final C0250d[] f128wh = new C0250d[]{new C0250d(TAG_NEW_SUBFILE_TYPE, C31128d.MIC_PTU_ZIPAI_LIGHTRED, 4, (byte) 0), new C0250d(TAG_SUBFILE_TYPE, 255, 4, (byte) 0), new C0250d(TAG_THUMBNAIL_IMAGE_WIDTH, 256, (byte) 0), new C0250d(TAG_THUMBNAIL_IMAGE_LENGTH, (int) C31128d.MIC_PTU_ZIPAI_TOKYO, (byte) 0), new C0250d(TAG_BITS_PER_SAMPLE, C31128d.MIC_PTU_ZIPAI_SAPPORO, 3, (byte) 0), new C0250d(TAG_COMPRESSION, C31128d.MIC_PTU_ZIPAI_MEDSEA, 3, (byte) 0), new C0250d(TAG_PHOTOMETRIC_INTERPRETATION, C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM, 3, (byte) 0), new C0250d(TAG_IMAGE_DESCRIPTION, 270, 2, (byte) 0), new C0250d(TAG_MAKE, 271, 2, (byte) 0), new C0250d(TAG_MODEL, 272, 2, (byte) 0), new C0250d(TAG_STRIP_OFFSETS, 273, (byte) 0), new C0250d(TAG_ORIENTATION, 274, 3, (byte) 0), new C0250d(TAG_SAMPLES_PER_PIXEL, 277, 3, (byte) 0), new C0250d(TAG_ROWS_PER_STRIP, (int) C31128d.MIC_PTU_TRANS_XINGYE, (byte) 0), new C0250d(TAG_STRIP_BYTE_COUNTS, (int) C31128d.MIC_PTU_TRANS_ROUHE, (byte) 0), new C0250d(TAG_X_RESOLUTION, C31128d.MIC_PTU_BAIXI, 5, (byte) 0), new C0250d(TAG_Y_RESOLUTION, 283, 5, (byte) 0), new C0250d(TAG_PLANAR_CONFIGURATION, 284, 3, (byte) 0), new C0250d(TAG_RESOLUTION_UNIT, C31128d.MIC_PTU_YINGTAOBUDING, 3, (byte) 0), new C0250d(TAG_TRANSFER_FUNCTION, 301, 3, (byte) 0), new C0250d(TAG_SOFTWARE, C31128d.MIC_PTU_QINGCHENG, 2, (byte) 0), new C0250d(TAG_DATETIME, 306, 2, (byte) 0), new C0250d(TAG_ARTIST, C38405e.CTRL_INDEX, 2, (byte) 0), new C0250d(TAG_WHITE_POINT, 318, 5, (byte) 0), new C0250d(TAG_PRIMARY_CHROMATICITIES, ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5, (byte) 0), new C0250d(TAG_SUB_IFD_POINTER, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4, (byte) 0), new C0250d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0), new C0250d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0), new C0250d(TAG_Y_CB_CR_COEFFICIENTS, C27003i.CTRL_INDEX, 5, (byte) 0), new C0250d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3, (byte) 0), new C0250d(TAG_Y_CB_CR_POSITIONING, 531, 3, (byte) 0), new C0250d(TAG_REFERENCE_BLACK_WHITE, C42541c.CTRL_INDEX, 5, (byte) 0), new C0250d(TAG_COPYRIGHT, 33432, 2, (byte) 0), new C0250d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new C0250d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new C0250d(TAG_DNG_VERSION, 50706, 1, (byte) 0), new C0250d(TAG_DEFAULT_CROP_SIZE, 50720, (byte) 0)};
    /* renamed from: wi */
    private static final C0250d[] f129wi = new C0250d[]{new C0250d(TAG_ORF_THUMBNAIL_IMAGE, 256, 7, (byte) 0), new C0250d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4, (byte) 0), new C0250d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4, (byte) 0)};
    /* renamed from: wj */
    private static final C0250d[] f130wj = new C0250d[]{new C0250d(TAG_ORF_PREVIEW_IMAGE_START, C31128d.MIC_PTU_ZIPAI_TOKYO, 4, (byte) 0), new C0250d(TAG_ORF_PREVIEW_IMAGE_LENGTH, C31128d.MIC_PTU_ZIPAI_SAPPORO, 4, (byte) 0)};
    /* renamed from: wk */
    private static final C0250d[] f131wk = new C0250d[]{new C0250d(TAG_ORF_ASPECT_FRAME, 4371, 3, (byte) 0)};
    /* renamed from: wl */
    private static final C0250d[] f132wl = new C0250d[]{new C0250d(TAG_COLOR_SPACE, 55, 3, (byte) 0)};
    /* renamed from: wm */
    static final C0250d[][] f133wm = new C0250d[][]{f124wd, f125we, f126wf, f127wg, f128wh, f124wd, f129wi, f130wj, f131wk, f132wl};
    /* renamed from: wn */
    private static final C0250d[] f134wn = new C0250d[]{new C0250d(TAG_SUB_IFD_POINTER, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4, (byte) 0), new C0250d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new C0250d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new C0250d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4, (byte) 0), new C0250d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1, (byte) 0), new C0250d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1, (byte) 0)};
    /* renamed from: wo */
    private static final C0250d f135wo = new C0250d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0);
    /* renamed from: wp */
    private static final C0250d f136wp = new C0250d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0);
    /* renamed from: wq */
    private static final HashMap<Integer, C0250d>[] f137wq = new HashMap[f133wm.length];
    /* renamed from: wr */
    private static final HashMap<String, C0250d>[] f138wr = new HashMap[f133wm.length];
    /* renamed from: ws */
    private static final HashSet<String> f139ws = new HashSet(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    /* renamed from: wt */
    private static final HashMap<Integer, Integer> f140wt = new HashMap();
    /* renamed from: wu */
    private static final Charset f141wu = Charset.forName("US-ASCII");
    /* renamed from: wv */
    static final byte[] f142wv = "Exif\u0000\u0000".getBytes(f141wu);
    private final String mFilename;
    /* renamed from: wA */
    private boolean f143wA;
    /* renamed from: wB */
    private int f144wB;
    /* renamed from: wC */
    private int f145wC;
    /* renamed from: wD */
    private byte[] f146wD;
    /* renamed from: wE */
    private int f147wE;
    /* renamed from: wF */
    private int f148wF;
    /* renamed from: wG */
    private int f149wG;
    /* renamed from: wH */
    private int f150wH;
    /* renamed from: wI */
    private int f151wI;
    /* renamed from: wJ */
    private int f152wJ;
    /* renamed from: wK */
    private boolean f153wK;
    /* renamed from: ww */
    private final AssetInputStream f154ww;
    /* renamed from: wx */
    private int f155wx;
    /* renamed from: wy */
    private final HashMap<String, C0249c>[] f156wy;
    /* renamed from: wz */
    private ByteOrder f157wz;

    /* renamed from: android.support.d.a$a */
    static class C0247a extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private final int mLength;
        int mPosition;
        /* renamed from: wN */
        private DataInputStream f100wN;
        /* renamed from: wO */
        ByteOrder f101wO;

        public C0247a(InputStream inputStream) {
            this.f101wO = ByteOrder.BIG_ENDIAN;
            this.f100wN = new DataInputStream(inputStream);
            this.mLength = this.f100wN.available();
            this.mPosition = 0;
            this.f100wN.mark(this.mLength);
        }

        public C0247a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }

        public final void seek(long j) {
            if (((long) this.mPosition) > j) {
                this.mPosition = 0;
                this.f100wN.reset();
                this.f100wN.mark(this.mLength);
            } else {
                j -= (long) this.mPosition;
            }
            if (skipBytes((int) j) != ((int) j)) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public final int available() {
            return this.f100wN.available();
        }

        public final int read() {
            this.mPosition++;
            return this.f100wN.read();
        }

        public final int read(byte[] bArr, int i, int i2) {
            int read = this.f100wN.read(bArr, i, i2);
            this.mPosition += read;
            return read;
        }

        public final int readUnsignedByte() {
            this.mPosition++;
            return this.f100wN.readUnsignedByte();
        }

        public final String readLine() {
            return null;
        }

        public final boolean readBoolean() {
            this.mPosition++;
            return this.f100wN.readBoolean();
        }

        public final char readChar() {
            this.mPosition += 2;
            return this.f100wN.readChar();
        }

        public final String readUTF() {
            this.mPosition += 2;
            return this.f100wN.readUTF();
        }

        public final void readFully(byte[] bArr, int i, int i2) {
            this.mPosition += i2;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            } else if (this.f100wN.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public final void readFully(byte[] bArr) {
            this.mPosition += bArr.length;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            } else if (this.f100wN.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public final byte readByte() {
            this.mPosition++;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.f100wN.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public final short readShort() {
            this.mPosition += 2;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.f100wN.read();
            int read2 = this.f100wN.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            } else if (this.f101wO == LITTLE_ENDIAN) {
                return (short) (read + (read2 << 8));
            } else {
                if (this.f101wO == BIG_ENDIAN) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f101wO);
            }
        }

        public final int readInt() {
            this.mPosition += 4;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.f100wN.read();
            int read2 = this.f100wN.read();
            int read3 = this.f100wN.read();
            int read4 = this.f100wN.read();
            if ((((read | read2) | read3) | read4) < 0) {
                throw new EOFException();
            } else if (this.f101wO == LITTLE_ENDIAN) {
                return read + ((read2 << 8) + ((read3 << 16) + (read4 << 24)));
            } else if (this.f101wO == BIG_ENDIAN) {
                return (((read << 24) + (read2 << 16)) + (read3 << 8)) + read4;
            } else {
                throw new IOException("Invalid byte order: " + this.f101wO);
            }
        }

        public final int skipBytes(int i) {
            int min = Math.min(i, this.mLength - this.mPosition);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.f100wN.skipBytes(min - i2);
            }
            this.mPosition += i2;
            return i2;
        }

        public final int readUnsignedShort() {
            this.mPosition += 2;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.f100wN.read();
            int read2 = this.f100wN.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            } else if (this.f101wO == LITTLE_ENDIAN) {
                return read + (read2 << 8);
            } else {
                if (this.f101wO == BIG_ENDIAN) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f101wO);
            }
        }

        /* renamed from: cM */
        public final long mo370cM() {
            return ((long) readInt()) & 4294967295L;
        }

        public final long readLong() {
            this.mPosition += 8;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.f100wN.read();
            int read2 = this.f100wN.read();
            int read3 = this.f100wN.read();
            int read4 = this.f100wN.read();
            int read5 = this.f100wN.read();
            int read6 = this.f100wN.read();
            int read7 = this.f100wN.read();
            int read8 = this.f100wN.read();
            if ((((((((read | read2) | read3) | read4) | read5) | read6) | read7) | read8) < 0) {
                throw new EOFException();
            } else if (this.f101wO == LITTLE_ENDIAN) {
                return ((long) read) + (((((long) read3) << 16) + (((((long) read5) << 32) + (((((long) read7) << 48) + (((long) read8) << 56)) + (((long) read6) << 40))) + (((long) read4) << 24))) + (((long) read2) << 8));
            } else if (this.f101wO == BIG_ENDIAN) {
                return (((((((((long) read2) << 48) + (((long) read) << 56)) + (((long) read3) << 40)) + (((long) read4) << 32)) + (((long) read5) << 24)) + (((long) read6) << 16)) + (((long) read7) << 8)) + ((long) read8);
            } else {
                throw new IOException("Invalid byte order: " + this.f101wO);
            }
        }

        public final float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        public final double readDouble() {
            return Double.longBitsToDouble(readLong());
        }
    }

    /* renamed from: android.support.d.a$b */
    static class C0248b extends FilterOutputStream {
        /* renamed from: wO */
        ByteOrder f102wO;
        /* renamed from: wP */
        private final OutputStream f103wP;

        public C0248b(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f103wP = outputStream;
            this.f102wO = byteOrder;
        }

        public final void write(byte[] bArr) {
            this.f103wP.write(bArr);
        }

        public final void write(byte[] bArr, int i, int i2) {
            this.f103wP.write(bArr, i, i2);
        }

        public final void writeByte(int i) {
            this.f103wP.write(i);
        }

        public final void writeShort(short s) {
            if (this.f102wO == ByteOrder.LITTLE_ENDIAN) {
                this.f103wP.write((s >>> 0) & 255);
                this.f103wP.write((s >>> 8) & 255);
            } else if (this.f102wO == ByteOrder.BIG_ENDIAN) {
                this.f103wP.write((s >>> 8) & 255);
                this.f103wP.write((s >>> 0) & 255);
            }
        }

        public final void writeInt(int i) {
            if (this.f102wO == ByteOrder.LITTLE_ENDIAN) {
                this.f103wP.write((i >>> 0) & 255);
                this.f103wP.write((i >>> 8) & 255);
                this.f103wP.write((i >>> 16) & 255);
                this.f103wP.write((i >>> 24) & 255);
            } else if (this.f102wO == ByteOrder.BIG_ENDIAN) {
                this.f103wP.write((i >>> 24) & 255);
                this.f103wP.write((i >>> 16) & 255);
                this.f103wP.write((i >>> 8) & 255);
                this.f103wP.write((i >>> 0) & 255);
            }
        }
    }

    /* renamed from: android.support.d.a$c */
    static class C0249c {
        public final int format;
        /* renamed from: wQ */
        public final int f104wQ;
        /* renamed from: wR */
        public final byte[] f105wR;

        /* synthetic */ C0249c(int i, int i2, byte[] bArr, byte b) {
            this(i, i2, bArr);
        }

        C0249c(int i, int i2, byte[] bArr) {
            this.format = i;
            this.f104wQ = i2;
            this.f105wR = bArr;
        }

        /* renamed from: a */
        public static C0249c m386a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C0252a.f122wb[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new C0249c(3, iArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C0249c m382a(int i, ByteOrder byteOrder) {
            return C0249c.m386a(new int[]{i}, byteOrder);
        }

        /* renamed from: a */
        public static C0249c m387a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C0252a.f122wb[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new C0249c(4, jArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C0249c m383a(long j, ByteOrder byteOrder) {
            return C0249c.m387a(new long[]{j}, byteOrder);
        }

        /* renamed from: b */
        public static C0249c m389b(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C0252a.f122wb[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new C0249c(9, iArr.length, wrap.array());
        }

        /* renamed from: E */
        public static C0249c m381E(String str) {
            byte[] bytes = (str + 0).getBytes(C0252a.f141wu);
            return new C0249c(2, bytes.length, bytes);
        }

        /* renamed from: a */
        public static C0249c m388a(C0251e[] c0251eArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C0252a.f122wb[5] * c0251eArr.length)]);
            wrap.order(byteOrder);
            for (C0251e c0251e : c0251eArr) {
                wrap.putInt((int) c0251e.f108wU);
                wrap.putInt((int) c0251e.f109wV);
            }
            return new C0249c(5, c0251eArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C0249c m384a(C0251e c0251e, ByteOrder byteOrder) {
            return C0249c.m388a(new C0251e[]{c0251e}, byteOrder);
        }

        /* renamed from: b */
        public static C0249c m390b(C0251e[] c0251eArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C0252a.f122wb[10] * c0251eArr.length)]);
            wrap.order(byteOrder);
            for (C0251e c0251e : c0251eArr) {
                wrap.putInt((int) c0251e.f108wU);
                wrap.putInt((int) c0251e.f109wV);
            }
            return new C0249c(10, c0251eArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C0249c m385a(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C0252a.f122wb[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new C0249c(12, dArr.length, wrap.array());
        }

        public final String toString() {
            return "(" + C0252a.f121wa[this.format] + ", data length:" + this.f105wR.length + ")";
        }

        /* Access modifiers changed, original: final */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0042=Splitter:B:20:0x0042, B:53:0x00a6=Splitter:B:53:0x00a6} */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0042=Splitter:B:20:0x0042, B:53:0x00a6=Splitter:B:53:0x00a6} */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0073 A:{Catch:{ IOException -> 0x009c, all -> 0x01a5 }} */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0082 A:{Catch:{ IOException -> 0x009c, all -> 0x01a5 }} */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x0199 A:{SYNTHETIC, Splitter:B:133:0x0199} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final Object mo394a(ByteOrder byteOrder) {
            C0247a c0247a;
            Throwable th;
            int i = 1;
            int i2 = 0;
            C0247a c0247a2;
            try {
                c0247a2 = new C0247a(this.f105wR);
                try {
                    c0247a2.f101wO = byteOrder;
                    Object str;
                    int i3;
                    switch (this.format) {
                        case 1:
                        case 6:
                            if (this.f105wR.length != 1 || this.f105wR[0] < (byte) 0 || this.f105wR[0] > (byte) 1) {
                                str = new String(this.f105wR, C0252a.f141wu);
                                try {
                                    c0247a2.close();
                                    return str;
                                } catch (IOException e) {
                                    return str;
                                }
                            }
                            str = new String(new char[]{(char) (this.f105wR[0] + 48)});
                            try {
                                c0247a2.close();
                                return str;
                            } catch (IOException e2) {
                                return str;
                            }
                        case 2:
                        case 7:
                            StringBuilder stringBuilder;
                            if (this.f104wQ >= C0252a.f123wc.length) {
                                for (int i4 = 0; i4 < C0252a.f123wc.length; i4++) {
                                    if (this.f105wR[i4] != C0252a.f123wc[i4]) {
                                        i = 0;
                                        if (i != 0) {
                                            i = C0252a.f123wc.length;
                                            stringBuilder = new StringBuilder();
                                            while (i < this.f104wQ) {
                                                byte b = this.f105wR[i];
                                                if (b != (byte) 0) {
                                                    if (b >= (byte) 32) {
                                                        stringBuilder.append((char) b);
                                                    } else {
                                                        stringBuilder.append('?');
                                                    }
                                                    i++;
                                                }
                                            }
                                            str = stringBuilder.toString();
                                            c0247a2.close();
                                            return str;
                                        }
                                    }
                                }
                                if (i != 0) {
                                }
                            }
                            i = 0;
                            stringBuilder = new StringBuilder();
                            while (i < this.f104wQ) {
                            }
                            str = stringBuilder.toString();
                            try {
                                c0247a2.close();
                                return str;
                            } catch (IOException e3) {
                                return str;
                            }
                        case 3:
                            str = new int[this.f104wQ];
                            while (i2 < this.f104wQ) {
                                str[i2] = c0247a2.readUnsignedShort();
                                i2++;
                            }
                            try {
                                c0247a2.close();
                                return str;
                            } catch (IOException e4) {
                                return str;
                            }
                        case 4:
                            str = new long[this.f104wQ];
                            while (i2 < this.f104wQ) {
                                str[i2] = c0247a2.mo370cM();
                                i2++;
                            }
                            try {
                                c0247a2.close();
                                return str;
                            } catch (IOException e5) {
                                return str;
                            }
                        case 5:
                            str = new C0251e[this.f104wQ];
                            while (true) {
                                i3 = i2;
                                if (i3 < this.f104wQ) {
                                    str[i3] = new C0251e(c0247a2.mo370cM(), c0247a2.mo370cM(), (byte) 0);
                                    i2 = i3 + 1;
                                } else {
                                    try {
                                        c0247a2.close();
                                        return str;
                                    } catch (IOException e6) {
                                        return str;
                                    }
                                }
                            }
                        case 8:
                            str = new int[this.f104wQ];
                            while (i2 < this.f104wQ) {
                                str[i2] = c0247a2.readShort();
                                i2++;
                            }
                            try {
                                c0247a2.close();
                                return str;
                            } catch (IOException e7) {
                                return str;
                            }
                        case 9:
                            str = new int[this.f104wQ];
                            while (i2 < this.f104wQ) {
                                str[i2] = c0247a2.readInt();
                                i2++;
                            }
                            try {
                                c0247a2.close();
                                return str;
                            } catch (IOException e8) {
                                return str;
                            }
                        case 10:
                            str = new C0251e[this.f104wQ];
                            while (true) {
                                i3 = i2;
                                if (i3 < this.f104wQ) {
                                    str[i3] = new C0251e((long) c0247a2.readInt(), (long) c0247a2.readInt(), (byte) 0);
                                    i2 = i3 + 1;
                                } else {
                                    try {
                                        c0247a2.close();
                                        return str;
                                    } catch (IOException e9) {
                                        return str;
                                    }
                                }
                            }
                        case 11:
                            str = new double[this.f104wQ];
                            while (i2 < this.f104wQ) {
                                str[i2] = (double) c0247a2.readFloat();
                                i2++;
                            }
                            try {
                                c0247a2.close();
                                return str;
                            } catch (IOException e10) {
                                return str;
                            }
                        case 12:
                            str = new double[this.f104wQ];
                            while (i2 < this.f104wQ) {
                                str[i2] = c0247a2.readDouble();
                                i2++;
                            }
                            try {
                                c0247a2.close();
                                return str;
                            } catch (IOException e11) {
                                return str;
                            }
                        default:
                            try {
                                c0247a2.close();
                            } catch (IOException e12) {
                            }
                            return null;
                    }
                } catch (IOException e13) {
                    c0247a = c0247a2;
                } catch (Throwable th2) {
                    th = th2;
                    if (c0247a2 != null) {
                        try {
                            c0247a2.close();
                        } catch (IOException e14) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e15) {
                c0247a = null;
                if (c0247a != null) {
                    try {
                        c0247a.close();
                    } catch (IOException e16) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                c0247a2 = null;
                if (c0247a2 != null) {
                }
                throw th;
            }
        }

        /* renamed from: b */
        public final double mo395b(ByteOrder byteOrder) {
            Object a = mo394a(byteOrder);
            if (a == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (a instanceof String) {
                return Double.parseDouble((String) a);
            } else {
                if (a instanceof long[]) {
                    long[] jArr = (long[]) a;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a instanceof int[]) {
                    int[] iArr = (int[]) a;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a instanceof double[]) {
                    double[] dArr = (double[]) a;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a instanceof C0251e[]) {
                    C0251e[] c0251eArr = (C0251e[]) a;
                    if (c0251eArr.length == 1) {
                        return c0251eArr[0].mo401cN();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        /* renamed from: c */
        public final int mo396c(ByteOrder byteOrder) {
            Object a = mo394a(byteOrder);
            if (a == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (a instanceof String) {
                return Integer.parseInt((String) a);
            } else {
                if (a instanceof long[]) {
                    long[] jArr = (long[]) a;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a instanceof int[]) {
                    int[] iArr = (int[]) a;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        /* renamed from: d */
        public final String mo397d(ByteOrder byteOrder) {
            int i = 0;
            Object a = mo394a(byteOrder);
            if (a == null) {
                return null;
            }
            if (a instanceof String) {
                return (String) a;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (a instanceof long[]) {
                long[] jArr = (long[]) a;
                while (i < jArr.length) {
                    stringBuilder.append(jArr[i]);
                    if (i + 1 != jArr.length) {
                        stringBuilder.append(",");
                    }
                    i++;
                }
                return stringBuilder.toString();
            } else if (a instanceof int[]) {
                int[] iArr = (int[]) a;
                while (i < iArr.length) {
                    stringBuilder.append(iArr[i]);
                    if (i + 1 != iArr.length) {
                        stringBuilder.append(",");
                    }
                    i++;
                }
                return stringBuilder.toString();
            } else if (a instanceof double[]) {
                double[] dArr = (double[]) a;
                while (i < dArr.length) {
                    stringBuilder.append(dArr[i]);
                    if (i + 1 != dArr.length) {
                        stringBuilder.append(",");
                    }
                    i++;
                }
                return stringBuilder.toString();
            } else if (!(a instanceof C0251e[])) {
                return null;
            } else {
                C0251e[] c0251eArr = (C0251e[]) a;
                while (i < c0251eArr.length) {
                    stringBuilder.append(c0251eArr[i].f108wU);
                    stringBuilder.append(IOUtils.DIR_SEPARATOR_UNIX);
                    stringBuilder.append(c0251eArr[i].f109wV);
                    if (i + 1 != c0251eArr.length) {
                        stringBuilder.append(",");
                    }
                    i++;
                }
                return stringBuilder.toString();
            }
        }

        public final int size() {
            return C0252a.f122wb[this.format] * this.f104wQ;
        }
    }

    /* renamed from: android.support.d.a$d */
    static class C0250d {
        public final String name;
        public final int number;
        /* renamed from: wS */
        public final int f106wS;
        /* renamed from: wT */
        public final int f107wT;

        /* synthetic */ C0250d(String str, int i, int i2, byte b) {
            this(str, i, i2);
        }

        private C0250d(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.f106wS = i2;
            this.f107wT = -1;
        }

        private C0250d(String str, int i) {
            this.name = str;
            this.number = i;
            this.f106wS = 3;
            this.f107wT = 4;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: an */
        public final boolean mo400an(int i) {
            if (this.f106wS == 7 || i == 7 || this.f106wS == i || this.f107wT == i) {
                return true;
            }
            if ((this.f106wS == 4 || this.f107wT == 4) && i == 3) {
                return true;
            }
            if ((this.f106wS == 9 || this.f107wT == 9) && i == 8) {
                return true;
            }
            if ((this.f106wS == 12 || this.f107wT == 12) && i == 11) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: android.support.d.a$e */
    static class C0251e {
        /* renamed from: wU */
        public final long f108wU;
        /* renamed from: wV */
        public final long f109wV;

        /* synthetic */ C0251e(long j, long j2, byte b) {
            this(j, j2);
        }

        private C0251e(double d) {
            this((long) (10000.0d * d), 10000);
        }

        private C0251e(long j, long j2) {
            if (j2 == 0) {
                this.f108wU = 0;
                this.f109wV = 1;
                return;
            }
            this.f108wU = j;
            this.f109wV = j2;
        }

        public final String toString() {
            return this.f108wU + "/" + this.f109wV;
        }

        /* renamed from: cN */
        public final double mo401cN() {
            return ((double) this.f108wU) / ((double) this.f109wV);
        }
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        f118vZ = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < f133wm.length; i++) {
            f137wq[i] = new HashMap();
            f138wr[i] = new HashMap();
            for (C0250d c0250d : f133wm[i]) {
                f137wq[i].put(Integer.valueOf(c0250d.number), c0250d);
                f138wr[i].put(c0250d.name, c0250d);
            }
        }
        f140wt.put(Integer.valueOf(f134wn[0].number), Integer.valueOf(5));
        f140wt.put(Integer.valueOf(f134wn[1].number), Integer.valueOf(1));
        f140wt.put(Integer.valueOf(f134wn[2].number), Integer.valueOf(2));
        f140wt.put(Integer.valueOf(f134wn[3].number), Integer.valueOf(3));
        f140wt.put(Integer.valueOf(f134wn[4].number), Integer.valueOf(7));
        f140wt.put(Integer.valueOf(f134wn[5].number), Integer.valueOf(8));
    }

    public C0252a(String str) {
        Throwable th;
        this.f156wy = new HashMap[f133wm.length];
        this.f157wz = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        this.f154ww = null;
        this.mFilename = str;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                m407b((InputStream) fileInputStream);
                C0252a.closeQuietly(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                C0252a.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            C0252a.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public C0252a(InputStream inputStream) {
        this.f156wy = new HashMap[f133wm.length];
        this.f157wz = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        this.mFilename = null;
        if (inputStream instanceof AssetInputStream) {
            this.f154ww = (AssetInputStream) inputStream;
        } else {
            this.f154ww = null;
        }
        m407b(inputStream);
    }

    /* renamed from: C */
    private C0249c m397C(String str) {
        Object str2;
        if (TAG_ISO_SPEED_RATINGS.equals(str2)) {
            str2 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= f133wm.length) {
                return null;
            }
            C0249c c0249c = (C0249c) this.f156wy[i2].get(str2);
            if (c0249c != null) {
                return c0249c;
            }
            i = i2 + 1;
        }
    }

    public final String getAttribute(String str) {
        C0249c C = m397C(str);
        if (C == null) {
            return null;
        }
        if (!f139ws.contains(str)) {
            return C.mo397d(this.f157wz);
        }
        if (!str.equals(TAG_GPS_TIMESTAMP)) {
            try {
                return Double.toString(C.mo395b(this.f157wz));
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (C.format == 5 || C.format == 10) {
            C0251e[] c0251eArr = (C0251e[]) C.mo394a(this.f157wz);
            if (c0251eArr == null || c0251eArr.length != 3) {
                new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(c0251eArr));
                return null;
            }
            return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) c0251eArr[0].f108wU) / ((float) c0251eArr[0].f109wV))), Integer.valueOf((int) (((float) c0251eArr[1].f108wU) / ((float) c0251eArr[1].f109wV))), Integer.valueOf((int) (((float) c0251eArr[2].f108wU) / ((float) c0251eArr[2].f109wV)))});
        } else {
            new StringBuilder("GPS Timestamp format is not rational. format=").append(C.format);
            return null;
        }
    }

    public final int getAttributeInt(String str, int i) {
        C0249c C = m397C(str);
        if (C == null) {
            return i;
        }
        try {
            return C.mo396c(this.f157wz);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public final double getAttributeDouble(String str, double d) {
        C0249c C = m397C(str);
        if (C == null) {
            return d;
        }
        try {
            return C.mo395b(this.f157wz);
        } catch (NumberFormatException e) {
            return d;
        }
    }

    public final void setAttribute(String str, String str2) {
        Object str3;
        if (TAG_ISO_SPEED_RATINGS.equals(str3)) {
            str3 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        if (str2 != null && f139ws.contains(str3)) {
            if (str3.equals(TAG_GPS_TIMESTAMP)) {
                Matcher matcher = f120wM.matcher(str2);
                if (matcher.find()) {
                    str2 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    new StringBuilder("Invalid value for ").append(str3).append(" : ").append(str2);
                    return;
                }
            }
            try {
                str2 = new C0251e(Double.parseDouble(str2), (byte) 0).toString();
            } catch (NumberFormatException e) {
                new StringBuilder("Invalid value for ").append(str3).append(" : ").append(str2);
                return;
            }
        }
        for (int i = 0; i < f133wm.length; i++) {
            if (i != 4 || this.f143wA) {
                C0250d c0250d = (C0250d) f138wr[i].get(str3);
                if (c0250d != null) {
                    if (str2 != null) {
                        int i2;
                        Pair D = C0252a.m398D(str2);
                        if (c0250d.f106wS == ((Integer) D.first).intValue() || c0250d.f106wS == ((Integer) D.second).intValue()) {
                            i2 = c0250d.f106wS;
                        } else if (c0250d.f107wT != -1 && (c0250d.f107wT == ((Integer) D.first).intValue() || c0250d.f107wT == ((Integer) D.second).intValue())) {
                            i2 = c0250d.f107wT;
                        } else if (c0250d.f106wS == 1 || c0250d.f106wS == 7 || c0250d.f106wS == 2) {
                            i2 = c0250d.f106wS;
                        } else {
                            String str4;
                            StringBuilder append = new StringBuilder("Given tag (").append(str3).append(") value didn't match with one of expected formats: ").append(f121wa[c0250d.f106wS]).append(c0250d.f107wT == -1 ? "" : ", " + f121wa[c0250d.f107wT]).append(" (guess: ").append(f121wa[((Integer) D.first).intValue()]);
                            if (((Integer) D.second).intValue() == -1) {
                                str4 = "";
                            } else {
                                str4 = ", " + f121wa[((Integer) D.second).intValue()];
                            }
                            append.append(str4).append(")");
                        }
                        String[] split;
                        int[] iArr;
                        String[] split2;
                        C0251e[] c0251eArr;
                        String[] split3;
                        switch (i2) {
                            case 1:
                                Object c0249c;
                                HashMap hashMap = this.f156wy[i];
                                if (str2.length() != 1 || str2.charAt(0) < '0' || str2.charAt(0) > '1') {
                                    byte[] bytes = str2.getBytes(f141wu);
                                    c0249c = new C0249c(1, bytes.length, bytes);
                                } else {
                                    c0249c = new C0249c(1, 1, new byte[]{(byte) (str2.charAt(0) - 48)});
                                }
                                hashMap.put(str3, c0249c);
                                break;
                            case 2:
                            case 7:
                                this.f156wy[i].put(str3, C0249c.m381E(str2));
                                break;
                            case 3:
                                split = str2.split(",");
                                iArr = new int[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    iArr[i2] = Integer.parseInt(split[i2]);
                                }
                                this.f156wy[i].put(str3, C0249c.m386a(iArr, this.f157wz));
                                break;
                            case 4:
                                split = str2.split(",");
                                long[] jArr = new long[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    jArr[i2] = Long.parseLong(split[i2]);
                                }
                                this.f156wy[i].put(str3, C0249c.m387a(jArr, this.f157wz));
                                break;
                            case 5:
                                split2 = str2.split(",");
                                c0251eArr = new C0251e[split2.length];
                                for (i2 = 0; i2 < split2.length; i2++) {
                                    split3 = split2[i2].split("/");
                                    c0251eArr[i2] = new C0251e((long) Double.parseDouble(split3[0]), (long) Double.parseDouble(split3[1]), (byte) 0);
                                }
                                this.f156wy[i].put(str3, C0249c.m388a(c0251eArr, this.f157wz));
                                break;
                            case 9:
                                split = str2.split(",");
                                iArr = new int[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    iArr[i2] = Integer.parseInt(split[i2]);
                                }
                                this.f156wy[i].put(str3, C0249c.m389b(iArr, this.f157wz));
                                break;
                            case 10:
                                split2 = str2.split(",");
                                c0251eArr = new C0251e[split2.length];
                                for (i2 = 0; i2 < split2.length; i2++) {
                                    split3 = split2[i2].split("/");
                                    c0251eArr[i2] = new C0251e((long) Double.parseDouble(split3[0]), (long) Double.parseDouble(split3[1]), (byte) 0);
                                }
                                this.f156wy[i].put(str3, C0249c.m390b(c0251eArr, this.f157wz));
                                break;
                            case 12:
                                split = str2.split(",");
                                double[] dArr = new double[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    dArr[i2] = Double.parseDouble(split[i2]);
                                }
                                this.f156wy[i].put(str3, C0249c.m385a(dArr, this.f157wz));
                                break;
                            default:
                                break;
                        }
                    }
                    this.f156wy[i].remove(str3);
                }
            }
        }
    }

    private void removeAttribute(String str) {
        for (int i = 0; i < f133wm.length; i++) {
            this.f156wy[i].remove(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0248 A:{Catch:{ IOException -> 0x00c0, all -> 0x00cd }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m407b(InputStream inputStream) {
        Object obj;
        C0249c c0249c;
        C0249c c0249c2;
        int[] iArr;
        int i;
        int i2 = 0;
        while (i2 < f133wm.length) {
            try {
                this.f156wy[i2] = new HashMap();
                i2++;
            } catch (IOException e) {
                this.f153wK = false;
            } finally {
                m411cI();
            }
        }
        InputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        BufferedInputStream bufferedInputStream2 = (BufferedInputStream) bufferedInputStream;
        bufferedInputStream2.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream2.read(bArr);
        bufferedInputStream2.reset();
        if (C0252a.m416e(bArr)) {
            i2 = 4;
        } else if (C0252a.m417f(bArr)) {
            i2 = 9;
        } else {
            C0247a c0247a = new C0247a(bArr);
            this.f157wz = C0252a.m409c(c0247a);
            c0247a.f101wO = this.f157wz;
            short readShort = c0247a.readShort();
            c0247a.close();
            if (readShort == (short) 20306 || readShort == (short) 21330) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                i2 = 7;
            } else {
                c0247a = new C0247a(bArr);
                this.f157wz = C0252a.m409c(c0247a);
                c0247a.f101wO = this.f157wz;
                short readShort2 = c0247a.readShort();
                c0247a.close();
                if (readShort2 == (short) 85) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    i2 = 10;
                } else {
                    i2 = 0;
                }
            }
        }
        this.f155wx = i2;
        C0247a c0247a2 = new C0247a(bufferedInputStream);
        switch (this.f155wx) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                m400a(c0247a2);
                break;
            case 4:
                m402a(c0247a2, 0, 0);
                break;
            case 7:
                m400a(c0247a2);
                c0249c = (C0249c) this.f156wy[1].get(TAG_MAKER_NOTE);
                if (c0249c != null) {
                    C0247a c0247a3 = new C0247a(c0249c.f105wR);
                    c0247a3.f101wO = this.f157wz;
                    byte[] bArr2 = new byte[f116vX.length];
                    c0247a3.readFully(bArr2);
                    c0247a3.seek(0);
                    byte[] bArr3 = new byte[f117vY.length];
                    c0247a3.readFully(bArr3);
                    if (Arrays.equals(bArr2, f116vX)) {
                        c0247a3.seek(8);
                    } else if (Arrays.equals(bArr3, f117vY)) {
                        c0247a3.seek(12);
                    }
                    m405b(c0247a3, 6);
                    c0249c = (C0249c) this.f156wy[7].get(TAG_ORF_PREVIEW_IMAGE_START);
                    c0249c2 = (C0249c) this.f156wy[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
                    if (!(c0249c == null || c0249c2 == null)) {
                        this.f156wy[5].put(TAG_JPEG_INTERCHANGE_FORMAT, c0249c);
                        this.f156wy[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, c0249c2);
                    }
                    c0249c = (C0249c) this.f156wy[8].get(TAG_ORF_ASPECT_FRAME);
                    if (c0249c != null) {
                        iArr = (int[]) c0249c.mo394a(this.f157wz);
                        if (iArr != null && iArr.length == 4) {
                            if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                                i = (iArr[2] - iArr[0]) + 1;
                                i2 = (iArr[3] - iArr[1]) + 1;
                                if (i < i2) {
                                    i += i2;
                                    i2 = i - i2;
                                    i -= i2;
                                }
                                c0249c2 = C0249c.m382a(i, this.f157wz);
                                c0249c = C0249c.m382a(i2, this.f157wz);
                                this.f156wy[0].put(TAG_IMAGE_WIDTH, c0249c2);
                                this.f156wy[0].put(TAG_IMAGE_LENGTH, c0249c);
                                break;
                            }
                        }
                        new StringBuilder("Invalid aspect frame values. frame=").append(Arrays.toString(iArr));
                        break;
                    }
                }
                break;
            case 9:
                m404b(c0247a2);
                break;
            case 10:
                m400a(c0247a2);
                if (((C0249c) this.f156wy[0].get(TAG_RW2_JPG_FROM_RAW)) != null) {
                    m402a(c0247a2, this.f152wJ, 5);
                }
                c0249c = (C0249c) this.f156wy[0].get(TAG_RW2_ISO);
                c0249c2 = (C0249c) this.f156wy[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
                if (c0249c != null && c0249c2 == null) {
                    this.f156wy[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, c0249c);
                    break;
                }
        }
        HashMap hashMap = this.f156wy[4];
        c0249c = (C0249c) hashMap.get(TAG_COMPRESSION);
        if (c0249c != null) {
            this.f147wE = c0249c.mo396c(this.f157wz);
            switch (this.f147wE) {
                case 1:
                case 7:
                    c0249c = (C0249c) hashMap.get(TAG_BITS_PER_SAMPLE);
                    if (c0249c != null) {
                        iArr = (int[]) c0249c.mo394a(this.f157wz);
                        if (Arrays.equals(f112vT, iArr)) {
                            obj = 1;
                        } else if (this.f155wx == 3) {
                            c0249c2 = (C0249c) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION);
                            if (c0249c2 != null) {
                                i = c0249c2.mo396c(this.f157wz);
                                if ((i == 1 && Arrays.equals(iArr, f114vV)) || (i == 6 && Arrays.equals(iArr, f112vT))) {
                                    i2 = 1;
                                }
                            }
                        }
                        if (obj != null) {
                            m406b(c0247a2, hashMap);
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                    }
                    break;
                case 6:
                    m403a(c0247a2, hashMap);
                    break;
            }
        }
        this.f147wE = 6;
        m403a(c0247a2, hashMap);
        this.f153wK = true;
    }

    public final void saveAttributes() {
        Closeable fileInputStream;
        Closeable fileOutputStream;
        Throwable th;
        if (!this.f153wK || this.f155wx != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        } else if (this.mFilename == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        } else {
            byte[] thumbnailBytes;
            if (this.f147wE == 6 || this.f147wE == 7) {
                thumbnailBytes = getThumbnailBytes();
            } else {
                thumbnailBytes = null;
            }
            this.f146wD = thumbnailBytes;
            File file = new File(this.mFilename + ".tmp");
            if (new File(this.mFilename).renameTo(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(this.mFilename);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        C0252a.closeQuietly(fileInputStream);
                        C0252a.closeQuietly(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                    try {
                        m408b((InputStream) fileInputStream, (OutputStream) fileOutputStream);
                        C0252a.closeQuietly(fileInputStream);
                        C0252a.closeQuietly(fileOutputStream);
                        file.delete();
                        this.f146wD = null;
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        C0252a.closeQuietly(fileInputStream);
                        C0252a.closeQuietly(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    fileInputStream = null;
                    C0252a.closeQuietly(fileInputStream);
                    C0252a.closeQuietly(fileOutputStream);
                    file.delete();
                    throw th;
                }
            }
            throw new IOException("Could not rename to " + file.getAbsolutePath());
        }
    }

    private byte[] getThumbnailBytes() {
        Closeable closeable;
        Throwable th;
        if (!this.f143wA) {
            return null;
        }
        if (this.f146wD != null) {
            return this.f146wD;
        }
        Closeable closeable2;
        try {
            if (this.f154ww != null) {
                closeable2 = this.f154ww;
                try {
                    if (closeable2.markSupported()) {
                        closeable2.reset();
                        closeable = closeable2;
                    } else {
                        C0252a.closeQuietly(closeable2);
                        return null;
                    }
                } catch (IOException e) {
                    C0252a.closeQuietly(closeable2);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = closeable2;
                    C0252a.closeQuietly(closeable);
                    throw th;
                }
            }
            closeable = this.mFilename != null ? new FileInputStream(this.mFilename) : null;
            if (closeable == null) {
                try {
                    throw new FileNotFoundException();
                } catch (IOException e2) {
                    closeable2 = closeable;
                    C0252a.closeQuietly(closeable2);
                    return null;
                } catch (Throwable th22) {
                    th = th22;
                    C0252a.closeQuietly(closeable);
                    throw th;
                }
            } else if (closeable.skip((long) this.f144wB) != ((long) this.f144wB)) {
                throw new IOException("Corrupted image");
            } else {
                byte[] bArr = new byte[this.f145wC];
                if (closeable.read(bArr) != this.f145wC) {
                    throw new IOException("Corrupted image");
                }
                this.f146wD = bArr;
                C0252a.closeQuietly(closeable);
                return bArr;
            }
        } catch (IOException e3) {
            closeable2 = null;
            C0252a.closeQuietly(closeable2);
            return null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            C0252a.closeQuietly(closeable);
            throw th;
        }
    }

    /* renamed from: cH */
    public final double[] mo403cH() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (!(attribute == null || attribute2 == null || attribute3 == null || attribute4 == null)) {
            try {
                double g = C0252a.m418g(attribute, attribute2);
                double g2 = C0252a.m418g(attribute3, attribute4);
                return new double[]{g, g2};
            } catch (IllegalArgumentException e) {
                new StringBuilder("Latitude/longitude values are not parseable. ").append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{attribute, attribute2, attribute3, attribute4}));
            }
        }
        return null;
    }

    /* renamed from: g */
    private static double m418g(String str, String str2) {
        try {
            String[] split = str.split(",");
            String[] split2 = split[0].split("/");
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            split2 = split[1].split("/");
            double parseDouble2 = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            split = split[2].split("/");
            double parseDouble3 = ((Double.parseDouble(split[0].trim()) / Double.parseDouble(split[1].trim())) / 3600.0d) + (parseDouble + (parseDouble2 / 60.0d));
            if (str2.equals("S") || str2.equals(QLog.TAG_REPORTLEVEL_COLORUSER)) {
                return -parseDouble3;
            }
            if (str2.equals("N") || str2.equals(QLog.TAG_REPORTLEVEL_USER)) {
                return parseDouble3;
            }
            throw new IllegalArgumentException();
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: e */
    private static boolean m416e(byte[] bArr) {
        for (int i = 0; i < f115vW.length; i++) {
            if (bArr[i] != f115vW[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private static boolean m417f(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m402a(C0247a c0247a, int i, int i2) {
        c0247a.f101wO = ByteOrder.BIG_ENDIAN;
        c0247a.seek((long) i);
        byte readByte = c0247a.readByte();
        if (readByte != (byte) -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i3 = i + 1;
        if (c0247a.readByte() != (byte) -40) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i4 = i3 + 1;
        while (true) {
            byte readByte2 = c0247a.readByte();
            if (readByte2 != (byte) -1) {
                throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
            }
            i4++;
            byte readByte3 = c0247a.readByte();
            i3 = i4 + 1;
            if (readByte3 == (byte) -39 || readByte3 == (byte) -38) {
                c0247a.f101wO = this.f157wz;
            } else {
                i4 = c0247a.readUnsignedShort() - 2;
                i3 += 2;
                if (i4 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr;
                switch (readByte3) {
                    case (byte) -64:
                    case (byte) -63:
                    case (byte) -62:
                    case (byte) -61:
                    case (byte) -59:
                    case (byte) -58:
                    case (byte) -57:
                    case (byte) -55:
                    case (byte) -54:
                    case (byte) -53:
                    case (byte) -51:
                    case (byte) -50:
                    case (byte) -49:
                        if (c0247a.skipBytes(1) == 1) {
                            this.f156wy[i2].put(TAG_IMAGE_LENGTH, C0249c.m383a((long) c0247a.readUnsignedShort(), this.f157wz));
                            this.f156wy[i2].put(TAG_IMAGE_WIDTH, C0249c.m383a((long) c0247a.readUnsignedShort(), this.f157wz));
                            i4 -= 5;
                            break;
                        }
                        throw new IOException("Invalid SOFx");
                    case (byte) -31:
                        if (i4 >= 6) {
                            bArr = new byte[6];
                            if (c0247a.read(bArr) == 6) {
                                i3 += 6;
                                i4 -= 6;
                                if (Arrays.equals(bArr, f142wv)) {
                                    if (i4 > 0) {
                                        this.f148wF = i3;
                                        bArr = new byte[i4];
                                        if (c0247a.read(bArr) == i4) {
                                            i3 += i4;
                                            C0247a c0247a2 = new C0247a(bArr);
                                            m401a(c0247a2, bArr.length);
                                            m405b(c0247a2, i2);
                                            i4 = 0;
                                            break;
                                        }
                                        throw new IOException("Invalid exif");
                                    }
                                    throw new IOException("Invalid exif");
                                }
                            }
                            throw new IOException("Invalid exif");
                        }
                        break;
                    case (byte) -2:
                        bArr = new byte[i4];
                        if (c0247a.read(bArr) == i4) {
                            if (getAttribute(TAG_USER_COMMENT) != null) {
                                i4 = 0;
                                break;
                            }
                            this.f156wy[1].put(TAG_USER_COMMENT, C0249c.m381E(new String(bArr, f141wu)));
                            i4 = 0;
                            break;
                        }
                        throw new IOException("Invalid exif");
                }
                if (i4 < 0) {
                    throw new IOException("Invalid length");
                } else if (c0247a.skipBytes(i4) != i4) {
                    throw new IOException("Invalid JPEG segment");
                } else {
                    i4 += i3;
                }
            }
        }
        c0247a.f101wO = this.f157wz;
    }

    /* renamed from: a */
    private void m400a(C0247a c0247a) {
        m401a(c0247a, c0247a.available());
        m405b(c0247a, 0);
        m415d(c0247a, 0);
        m415d(c0247a, 5);
        m415d(c0247a, 4);
        m412cJ();
        if (this.f155wx == 8) {
            C0249c c0249c = (C0249c) this.f156wy[1].get(TAG_MAKER_NOTE);
            if (c0249c != null) {
                C0247a c0247a2 = new C0247a(c0249c.f105wR);
                c0247a2.f101wO = this.f157wz;
                c0247a2.seek(6);
                m405b(c0247a2, 9);
                c0249c = (C0249c) this.f156wy[9].get(TAG_COLOR_SPACE);
                if (c0249c != null) {
                    this.f156wy[1].put(TAG_COLOR_SPACE, c0249c);
                }
            }
        }
    }

    /* renamed from: b */
    private void m404b(C0247a c0247a) {
        c0247a.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        c0247a.read(bArr);
        c0247a.skipBytes(4);
        c0247a.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        m402a(c0247a, i, 5);
        c0247a.seek((long) i2);
        c0247a.f101wO = ByteOrder.BIG_ENDIAN;
        i2 = c0247a.readInt();
        for (i = 0; i < i2; i++) {
            int readUnsignedShort = c0247a.readUnsignedShort();
            int readUnsignedShort2 = c0247a.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                i = c0247a.readShort();
                i2 = c0247a.readShort();
                C0249c a = C0249c.m382a(i, this.f157wz);
                C0249c a2 = C0249c.m382a(i2, this.f157wz);
                this.f156wy[0].put(TAG_IMAGE_LENGTH, a);
                this.f156wy[0].put(TAG_IMAGE_WIDTH, a2);
                return;
            }
            c0247a.skipBytes(readUnsignedShort2);
        }
    }

    /* renamed from: b */
    private void m408b(InputStream inputStream, OutputStream outputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        C0248b c0248b = new C0248b(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != (byte) -1) {
            throw new IOException("Invalid marker");
        }
        c0248b.writeByte(-1);
        if (dataInputStream.readByte() != (byte) -40) {
            throw new IOException("Invalid marker");
        }
        c0248b.writeByte(-40);
        c0248b.writeByte(-1);
        c0248b.writeByte(-31);
        m399a(c0248b);
        byte[] bArr = new byte[4096];
        while (dataInputStream.readByte() == (byte) -1) {
            byte readByte = dataInputStream.readByte();
            int readUnsignedShort;
            int read;
            switch (readByte) {
                case (byte) -39:
                case (byte) -38:
                    c0248b.writeByte(-1);
                    c0248b.writeByte(readByte);
                    C0252a.copy(dataInputStream, c0248b);
                    return;
                case (byte) -31:
                    readUnsignedShort = dataInputStream.readUnsignedShort() - 2;
                    if (readUnsignedShort >= 0) {
                        byte[] bArr2 = new byte[6];
                        if (readUnsignedShort >= 6) {
                            if (dataInputStream.read(bArr2) == 6) {
                                if (Arrays.equals(bArr2, f142wv)) {
                                    if (dataInputStream.skipBytes(readUnsignedShort - 6) == readUnsignedShort - 6) {
                                        break;
                                    }
                                    throw new IOException("Invalid length");
                                }
                            }
                            throw new IOException("Invalid exif");
                        }
                        c0248b.writeByte(-1);
                        c0248b.writeByte(readByte);
                        c0248b.writeShort((short) (readUnsignedShort + 2));
                        if (readUnsignedShort >= 6) {
                            readUnsignedShort -= 6;
                            c0248b.write(bArr2);
                        }
                        while (readUnsignedShort > 0) {
                            read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, 4096));
                            if (read < 0) {
                                break;
                            }
                            c0248b.write(bArr, 0, read);
                            readUnsignedShort -= read;
                        }
                        break;
                    }
                    throw new IOException("Invalid length");
                default:
                    c0248b.writeByte(-1);
                    c0248b.writeByte(readByte);
                    readUnsignedShort = dataInputStream.readUnsignedShort();
                    c0248b.writeShort((short) readUnsignedShort);
                    readUnsignedShort -= 2;
                    if (readUnsignedShort >= 0) {
                        while (readUnsignedShort > 0) {
                            read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, 4096));
                            if (read < 0) {
                                break;
                            }
                            c0248b.write(bArr, 0, read);
                            readUnsignedShort -= read;
                        }
                        break;
                    }
                    throw new IOException("Invalid length");
            }
        }
        throw new IOException("Invalid marker");
    }

    /* renamed from: cI */
    private void m411cI() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.f156wy[0].put(TAG_DATETIME, C0249c.m381E(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.f156wy[0].put(TAG_IMAGE_WIDTH, C0249c.m383a(0, this.f157wz));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.f156wy[0].put(TAG_IMAGE_LENGTH, C0249c.m383a(0, this.f157wz));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.f156wy[0].put(TAG_ORIENTATION, C0249c.m383a(0, this.f157wz));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.f156wy[1].put(TAG_LIGHT_SOURCE, C0249c.m383a(0, this.f157wz));
        }
    }

    /* renamed from: c */
    private static ByteOrder m409c(C0247a c0247a) {
        short readShort = c0247a.readShort();
        switch (readShort) {
            case (short) 18761:
                return ByteOrder.LITTLE_ENDIAN;
            case (short) 19789:
                return ByteOrder.BIG_ENDIAN;
            default:
                throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    /* renamed from: a */
    private void m401a(C0247a c0247a, int i) {
        this.f157wz = C0252a.m409c(c0247a);
        c0247a.f101wO = this.f157wz;
        int readUnsignedShort = c0247a.readUnsignedShort();
        if (this.f155wx == 7 || this.f155wx == 10 || readUnsignedShort == 42) {
            readUnsignedShort = c0247a.readInt();
            if (readUnsignedShort < 8 || readUnsignedShort >= i) {
                throw new IOException("Invalid first Ifd offset: ".concat(String.valueOf(readUnsignedShort)));
            }
            readUnsignedShort -= 8;
            if (readUnsignedShort > 0 && c0247a.skipBytes(readUnsignedShort) != readUnsignedShort) {
                throw new IOException("Couldn't jump to first Ifd: ".concat(String.valueOf(readUnsignedShort)));
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* renamed from: b */
    private void m405b(C0247a c0247a, int i) {
        while (c0247a.mPosition + 2 <= c0247a.mLength) {
            short readShort = c0247a.readShort();
            if (c0247a.mPosition + (readShort * 12) <= c0247a.mLength) {
                for (short s = (short) 0; s < readShort; s = (short) (s + 1)) {
                    int i2;
                    int readUnsignedShort = c0247a.readUnsignedShort();
                    int readUnsignedShort2 = c0247a.readUnsignedShort();
                    int readInt = c0247a.readInt();
                    long j = 4 + ((long) c0247a.mPosition);
                    C0250d c0250d = (C0250d) f137wq[i].get(Integer.valueOf(readUnsignedShort));
                    long j2 = 0;
                    Object obj = null;
                    if (c0250d == null) {
                        i2 = readUnsignedShort2;
                    } else if (readUnsignedShort2 <= 0 || readUnsignedShort2 >= f122wb.length) {
                        i2 = readUnsignedShort2;
                    } else if (c0250d.mo400an(readUnsignedShort2)) {
                        if (readUnsignedShort2 == 7) {
                            readUnsignedShort2 = c0250d.f106wS;
                        }
                        j2 = ((long) readInt) * ((long) f122wb[readUnsignedShort2]);
                        if (j2 < 0 || j2 > 2147483647L) {
                            i2 = readUnsignedShort2;
                        } else {
                            obj = 1;
                            i2 = readUnsignedShort2;
                        }
                    } else {
                        new StringBuilder("Skip the tag entry since data format (").append(f121wa[readUnsignedShort2]).append(") is unexpected for tag: ").append(c0250d.name);
                        i2 = readUnsignedShort2;
                    }
                    if (obj == null) {
                        c0247a.seek(j);
                    } else {
                        C0249c a;
                        if (j2 > 4) {
                            readUnsignedShort2 = c0247a.readInt();
                            if (this.f155wx == 7) {
                                if (TAG_MAKER_NOTE.equals(c0250d.name)) {
                                    this.f149wG = readUnsignedShort2;
                                } else if (i == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(c0250d.name)) {
                                    this.f150wH = readUnsignedShort2;
                                    this.f151wI = readInt;
                                    a = C0249c.m382a(6, this.f157wz);
                                    C0249c a2 = C0249c.m383a((long) this.f150wH, this.f157wz);
                                    C0249c a3 = C0249c.m383a((long) this.f151wI, this.f157wz);
                                    this.f156wy[4].put(TAG_COMPRESSION, a);
                                    this.f156wy[4].put(TAG_JPEG_INTERCHANGE_FORMAT, a2);
                                    this.f156wy[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, a3);
                                }
                            } else if (this.f155wx == 10 && TAG_RW2_JPG_FROM_RAW.equals(c0250d.name)) {
                                this.f152wJ = readUnsignedShort2;
                            }
                            if (((long) readUnsignedShort2) + j2 <= ((long) c0247a.mLength)) {
                                c0247a.seek((long) readUnsignedShort2);
                            } else {
                                c0247a.seek(j);
                            }
                        }
                        Integer num = (Integer) f140wt.get(Integer.valueOf(readUnsignedShort));
                        if (num != null) {
                            long j3 = -1;
                            switch (i2) {
                                case 3:
                                    j3 = (long) c0247a.readUnsignedShort();
                                    break;
                                case 4:
                                    j3 = c0247a.mo370cM();
                                    break;
                                case 8:
                                    j3 = (long) c0247a.readShort();
                                    break;
                                case 9:
                                case 13:
                                    j3 = (long) c0247a.readInt();
                                    break;
                            }
                            if (j3 > 0 && j3 < ((long) c0247a.mLength)) {
                                c0247a.seek(j3);
                                m405b(c0247a, num.intValue());
                            }
                            c0247a.seek(j);
                        } else {
                            byte[] bArr = new byte[((int) j2)];
                            c0247a.readFully(bArr);
                            a = new C0249c(i2, readInt, bArr, (byte) 0);
                            this.f156wy[i].put(c0250d.name, a);
                            if (TAG_DNG_VERSION.equals(c0250d.name)) {
                                this.f155wx = 3;
                            }
                            if (((TAG_MAKE.equals(c0250d.name) || TAG_MODEL.equals(c0250d.name)) && a.mo397d(this.f157wz).contains("PENTAX")) || (TAG_COMPRESSION.equals(c0250d.name) && a.mo396c(this.f157wz) == CdnLogic.kBizGeneric)) {
                                this.f155wx = 8;
                            }
                            if (((long) c0247a.mPosition) != j) {
                                c0247a.seek(j);
                            }
                        }
                    }
                }
                if (c0247a.mPosition + 4 <= c0247a.mLength) {
                    int readInt2 = c0247a.readInt();
                    if (readInt2 > 8 && readInt2 < c0247a.mLength) {
                        c0247a.seek((long) readInt2);
                        if (this.f156wy[4].isEmpty()) {
                            i = 4;
                        } else if (this.f156wy[5].isEmpty()) {
                            i = 5;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
    }

    /* renamed from: c */
    private void m410c(C0247a c0247a, int i) {
        C0249c c0249c = (C0249c) this.f156wy[i].get(TAG_IMAGE_WIDTH);
        if (((C0249c) this.f156wy[i].get(TAG_IMAGE_LENGTH)) == null || c0249c == null) {
            C0249c c0249c2 = (C0249c) this.f156wy[i].get(TAG_JPEG_INTERCHANGE_FORMAT);
            if (c0249c2 != null) {
                m402a(c0247a, c0249c2.mo396c(this.f157wz), i);
            }
        }
    }

    /* renamed from: a */
    private void m403a(C0247a c0247a, HashMap hashMap) {
        C0249c c0249c = (C0249c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        C0249c c0249c2 = (C0249c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (c0249c != null && c0249c2 != null) {
            int c = c0249c.mo396c(this.f157wz);
            int min = Math.min(c0249c2.mo396c(this.f157wz), c0247a.available() - c);
            if (this.f155wx == 4 || this.f155wx == 9 || this.f155wx == 10) {
                c += this.f148wF;
            } else if (this.f155wx == 7) {
                c += this.f149wG;
            }
            if (c > 0 && min > 0) {
                this.f143wA = true;
                this.f144wB = c;
                this.f145wC = min;
                if (this.mFilename == null && this.f154ww == null) {
                    byte[] bArr = new byte[min];
                    c0247a.seek((long) c);
                    c0247a.readFully(bArr);
                    this.f146wD = bArr;
                }
            }
        }
    }

    /* renamed from: b */
    private void m406b(C0247a c0247a, HashMap hashMap) {
        C0249c c0249c = (C0249c) hashMap.get(TAG_STRIP_OFFSETS);
        C0249c c0249c2 = (C0249c) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (c0249c != null && c0249c2 != null) {
            long[] i = C0252a.m420i(c0249c.mo394a(this.f157wz));
            long[] i2 = C0252a.m420i(c0249c2.mo394a(this.f157wz));
            if (i != null && i2 != null) {
                int i3;
                long j = 0;
                for (long j2 : i2) {
                    j += j2;
                }
                byte[] bArr = new byte[((int) j)];
                int i4 = 0;
                int i5 = 0;
                for (i3 = 0; i3 < i.length; i3++) {
                    int i6 = (int) i2[i3];
                    int i7 = ((int) i[i3]) - i5;
                    c0247a.seek((long) i7);
                    i5 += i7;
                    byte[] bArr2 = new byte[i6];
                    c0247a.read(bArr2);
                    i5 += i6;
                    System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
                    i4 += bArr2.length;
                }
                this.f143wA = true;
                this.f146wD = bArr;
                this.f145wC = bArr.length;
            }
        }
    }

    /* renamed from: h */
    private boolean m419h(HashMap hashMap) {
        C0249c c0249c = (C0249c) hashMap.get(TAG_IMAGE_LENGTH);
        C0249c c0249c2 = (C0249c) hashMap.get(TAG_IMAGE_WIDTH);
        if (!(c0249c == null || c0249c2 == null)) {
            int c = c0249c.mo396c(this.f157wz);
            int c2 = c0249c2.mo396c(this.f157wz);
            if (c <= 512 && c2 <= 512) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: cJ */
    private void m412cJ() {
        m421q(0, 5);
        m421q(0, 4);
        m421q(5, 4);
        C0249c c0249c = (C0249c) this.f156wy[1].get(TAG_PIXEL_X_DIMENSION);
        C0249c c0249c2 = (C0249c) this.f156wy[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(c0249c == null || c0249c2 == null)) {
            this.f156wy[0].put(TAG_IMAGE_WIDTH, c0249c);
            this.f156wy[0].put(TAG_IMAGE_LENGTH, c0249c2);
        }
        if (this.f156wy[4].isEmpty() && m419h(this.f156wy[5])) {
            this.f156wy[4] = this.f156wy[5];
            this.f156wy[5] = new HashMap();
        }
        m419h(this.f156wy[4]);
    }

    /* renamed from: d */
    private void m415d(C0247a c0247a, int i) {
        C0249c c0249c = (C0249c) this.f156wy[i].get(TAG_DEFAULT_CROP_SIZE);
        C0249c c0249c2 = (C0249c) this.f156wy[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        C0249c c0249c3 = (C0249c) this.f156wy[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        C0249c c0249c4 = (C0249c) this.f156wy[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        C0249c c0249c5 = (C0249c) this.f156wy[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (c0249c != null) {
            Object a;
            Object a2;
            if (c0249c.format == 5) {
                C0251e[] c0251eArr = (C0251e[]) c0249c.mo394a(this.f157wz);
                if (c0251eArr == null || c0251eArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(c0251eArr));
                    return;
                } else {
                    a = C0249c.m384a(c0251eArr[0], this.f157wz);
                    a2 = C0249c.m384a(c0251eArr[1], this.f157wz);
                }
            } else {
                int[] iArr = (int[]) c0249c.mo394a(this.f157wz);
                if (iArr == null || iArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(iArr));
                    return;
                } else {
                    a = C0249c.m382a(iArr[0], this.f157wz);
                    a2 = C0249c.m382a(iArr[1], this.f157wz);
                }
            }
            this.f156wy[i].put(TAG_IMAGE_WIDTH, a);
            this.f156wy[i].put(TAG_IMAGE_LENGTH, a2);
        } else if (c0249c2 == null || c0249c3 == null || c0249c4 == null || c0249c5 == null) {
            m410c(c0247a, i);
        } else {
            int c = c0249c2.mo396c(this.f157wz);
            int c2 = c0249c4.mo396c(this.f157wz);
            int c3 = c0249c5.mo396c(this.f157wz);
            int c4 = c0249c3.mo396c(this.f157wz);
            if (c2 > c && c3 > c4) {
                c = c2 - c;
                c2 = c3 - c4;
                c0249c = C0249c.m382a(c, this.f157wz);
                c0249c2 = C0249c.m382a(c2, this.f157wz);
                this.f156wy[i].put(TAG_IMAGE_LENGTH, c0249c);
                this.f156wy[i].put(TAG_IMAGE_WIDTH, c0249c2);
            }
        }
    }

    /* renamed from: a */
    private int m399a(C0248b c0248b) {
        int size;
        int i;
        int i2;
        Entry entry;
        int[] iArr = new int[f133wm.length];
        int[] iArr2 = new int[f133wm.length];
        for (C0250d c0250d : f134wn) {
            removeAttribute(c0250d.name);
        }
        removeAttribute(f135wo.name);
        removeAttribute(f136wp.name);
        for (i2 = 0; i2 < f133wm.length; i2++) {
            for (Object obj : this.f156wy[i2].entrySet().toArray()) {
                entry = (Entry) obj;
                if (entry.getValue() == null) {
                    this.f156wy[i2].remove(entry.getKey());
                }
            }
        }
        if (!this.f156wy[1].isEmpty()) {
            this.f156wy[0].put(f134wn[1].name, C0249c.m383a(0, this.f157wz));
        }
        if (!this.f156wy[2].isEmpty()) {
            this.f156wy[0].put(f134wn[2].name, C0249c.m383a(0, this.f157wz));
        }
        if (!this.f156wy[3].isEmpty()) {
            this.f156wy[1].put(f134wn[3].name, C0249c.m383a(0, this.f157wz));
        }
        if (this.f143wA) {
            this.f156wy[4].put(f135wo.name, C0249c.m383a(0, this.f157wz));
            this.f156wy[4].put(f136wp.name, C0249c.m383a((long) this.f145wC, this.f157wz));
        }
        for (i = 0; i < f133wm.length; i++) {
            i2 = 0;
            for (Entry entry2 : this.f156wy[i].entrySet()) {
                size = ((C0249c) entry2.getValue()).size();
                if (size > 4) {
                    size += i2;
                } else {
                    size = i2;
                }
                i2 = size;
            }
            iArr2[i] = iArr2[i] + i2;
        }
        i2 = 8;
        for (size = 0; size < f133wm.length; size++) {
            if (!this.f156wy[size].isEmpty()) {
                iArr[size] = i2;
                i2 += (((this.f156wy[size].size() * 12) + 2) + 4) + iArr2[size];
            }
        }
        if (this.f143wA) {
            this.f156wy[4].put(f135wo.name, C0249c.m383a((long) i2, this.f157wz));
            this.f144wB = i2 + 6;
            i2 += this.f145wC;
        }
        int i3 = i2 + 8;
        if (!this.f156wy[1].isEmpty()) {
            this.f156wy[0].put(f134wn[1].name, C0249c.m383a((long) iArr[1], this.f157wz));
        }
        if (!this.f156wy[2].isEmpty()) {
            this.f156wy[0].put(f134wn[2].name, C0249c.m383a((long) iArr[2], this.f157wz));
        }
        if (!this.f156wy[3].isEmpty()) {
            this.f156wy[1].put(f134wn[3].name, C0249c.m383a((long) iArr[3], this.f157wz));
        }
        c0248b.writeShort((short) i3);
        c0248b.write(f142wv);
        c0248b.writeShort(this.f157wz == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        c0248b.f102wO = this.f157wz;
        c0248b.writeShort((short) 42);
        c0248b.writeInt(8);
        for (int i4 = 0; i4 < f133wm.length; i4++) {
            if (!this.f156wy[i4].isEmpty()) {
                C0249c c0249c;
                c0248b.writeShort((short) this.f156wy[i4].size());
                size = ((iArr[i4] + 2) + (this.f156wy[i4].size() * 12)) + 4;
                i = size;
                for (Entry entry22 : this.f156wy[i4].entrySet()) {
                    int i5 = ((C0250d) f138wr[i4].get(entry22.getKey())).number;
                    c0249c = (C0249c) entry22.getValue();
                    i2 = c0249c.size();
                    c0248b.writeShort((short) i5);
                    c0248b.writeShort((short) c0249c.format);
                    c0248b.writeInt(c0249c.f104wQ);
                    if (i2 > 4) {
                        c0248b.writeInt((int) ((long) i));
                        i += i2;
                    } else {
                        c0248b.write(c0249c.f105wR);
                        if (i2 < 4) {
                            for (size = i2; size < 4; size++) {
                                c0248b.writeByte(0);
                            }
                        }
                    }
                }
                if (i4 != 0 || this.f156wy[4].isEmpty()) {
                    c0248b.writeInt(0);
                } else {
                    c0248b.writeInt((int) ((long) iArr[4]));
                }
                for (Entry entry222 : this.f156wy[i4].entrySet()) {
                    c0249c = (C0249c) entry222.getValue();
                    if (c0249c.f105wR.length > 4) {
                        c0248b.write(c0249c.f105wR, 0, c0249c.f105wR.length);
                    }
                }
            }
        }
        if (this.f143wA) {
            c0248b.write(getThumbnailBytes());
        }
        c0248b.f102wO = ByteOrder.BIG_ENDIAN;
        return i3;
    }

    /* renamed from: D */
    private static Pair<Integer, Integer> m398D(String str) {
        if (str.contains(",")) {
            String[] split = str.split(",");
            Pair<Integer, Integer> D = C0252a.m398D(split[0]);
            if (((Integer) D.first).intValue() == 2) {
                return D;
            }
            int i = 1;
            while (i < split.length) {
                int intValue;
                int i2;
                Pair D2 = C0252a.m398D(split[i]);
                if (((Integer) D2.first).equals(D.first) || ((Integer) D2.second).equals(D.first)) {
                    intValue = ((Integer) D.first).intValue();
                } else {
                    intValue = -1;
                }
                if (((Integer) D.second).intValue() == -1 || !(((Integer) D2.first).equals(D.second) || ((Integer) D2.second).equals(D.second))) {
                    i2 = -1;
                } else {
                    i2 = ((Integer) D.second).intValue();
                }
                if (intValue == -1 && i2 == -1) {
                    return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
                }
                Pair<Integer, Integer> pair;
                if (intValue == -1) {
                    pair = new Pair(Integer.valueOf(i2), Integer.valueOf(-1));
                } else if (i2 == -1) {
                    pair = new Pair(Integer.valueOf(intValue), Integer.valueOf(-1));
                } else {
                    pair = D;
                }
                i++;
                D = pair;
            }
            return D;
        } else if (str.contains("/")) {
            String[] split2 = str.split("/");
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble < 0 || parseDouble2 < 0) {
                        return new Pair(Integer.valueOf(10), Integer.valueOf(-1));
                    }
                    if (parseDouble > 2147483647L || parseDouble2 > 2147483647L) {
                        return new Pair(Integer.valueOf(5), Integer.valueOf(-1));
                    }
                    return new Pair(Integer.valueOf(10), Integer.valueOf(5));
                } catch (NumberFormatException e) {
                }
            }
            return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
        } else {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                if (valueOf.longValue() >= 0 && valueOf.longValue() <= 65535) {
                    return new Pair(Integer.valueOf(3), Integer.valueOf(4));
                }
                if (valueOf.longValue() < 0) {
                    return new Pair(Integer.valueOf(9), Integer.valueOf(-1));
                }
                return new Pair(Integer.valueOf(4), Integer.valueOf(-1));
            } catch (NumberFormatException e2) {
                try {
                    Double.parseDouble(str);
                    return new Pair(Integer.valueOf(12), Integer.valueOf(-1));
                } catch (NumberFormatException e3) {
                    return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
                }
            }
        }
    }

    /* renamed from: q */
    private void m421q(int i, int i2) {
        if (!this.f156wy[i].isEmpty() && !this.f156wy[i2].isEmpty()) {
            C0249c c0249c = (C0249c) this.f156wy[i].get(TAG_IMAGE_LENGTH);
            C0249c c0249c2 = (C0249c) this.f156wy[i].get(TAG_IMAGE_WIDTH);
            C0249c c0249c3 = (C0249c) this.f156wy[i2].get(TAG_IMAGE_LENGTH);
            C0249c c0249c4 = (C0249c) this.f156wy[i2].get(TAG_IMAGE_WIDTH);
            if (c0249c != null && c0249c2 != null && c0249c3 != null && c0249c4 != null) {
                int c = c0249c.mo396c(this.f157wz);
                int c2 = c0249c2.mo396c(this.f157wz);
                int c3 = c0249c3.mo396c(this.f157wz);
                int c4 = c0249c4.mo396c(this.f157wz);
                if (c < c3 && c2 < c4) {
                    HashMap hashMap = this.f156wy[i];
                    HashMap[] hashMapArr = this.f156wy;
                    hashMapArr[i] = hashMapArr[i2];
                    this.f156wy[i2] = hashMap;
                }
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    private static int copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: i */
    private static long[] m420i(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = (long) iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
