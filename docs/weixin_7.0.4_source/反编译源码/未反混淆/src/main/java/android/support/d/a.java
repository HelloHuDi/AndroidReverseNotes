package android.support.d;

import android.content.res.AssetManager.AssetInputStream;
import android.util.Pair;
import com.facebook.internal.Utility;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.jsapi.i.i;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.IOUtils;
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

public class a {
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
    private static final d TAG_RAF_IMAGE_SIZE = new d(TAG_STRIP_OFFSETS, 273, 3, (byte) 0);
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
    private static final List<Integer> vR = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(8)});
    private static final List<Integer> vS = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5)});
    public static final int[] vT = new int[]{8, 8, 8};
    public static final int[] vU = new int[]{4};
    public static final int[] vV = new int[]{8};
    static final byte[] vW = new byte[]{(byte) -1, (byte) -40, (byte) -1};
    private static final byte[] vX = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 0};
    private static final byte[] vY = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 85, (byte) 83, (byte) 0, (byte) 73, (byte) 73};
    private static SimpleDateFormat vZ;
    private static final Pattern wL = Pattern.compile(".*[1-9].*");
    private static final Pattern wM = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    static final String[] wa = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    static final int[] wb = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    private static final byte[] wc = new byte[]{(byte) 65, (byte) 83, (byte) 67, (byte) 73, (byte) 73, (byte) 0, (byte) 0, (byte) 0};
    private static final d[] wd = new d[]{new d(TAG_NEW_SUBFILE_TYPE, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, 4, (byte) 0), new d(TAG_SUBFILE_TYPE, 255, 4, (byte) 0), new d(TAG_IMAGE_WIDTH, 256, (byte) 0), new d(TAG_IMAGE_LENGTH, (int) com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO, (byte) 0), new d(TAG_BITS_PER_SAMPLE, com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO, 3, (byte) 0), new d(TAG_COMPRESSION, com.tencent.view.d.MIC_PTU_ZIPAI_MEDSEA, 3, (byte) 0), new d(TAG_PHOTOMETRIC_INTERPRETATION, com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM, 3, (byte) 0), new d(TAG_IMAGE_DESCRIPTION, 270, 2, (byte) 0), new d(TAG_MAKE, 271, 2, (byte) 0), new d(TAG_MODEL, 272, 2, (byte) 0), new d(TAG_STRIP_OFFSETS, 273, (byte) 0), new d(TAG_ORIENTATION, 274, 3, (byte) 0), new d(TAG_SAMPLES_PER_PIXEL, 277, 3, (byte) 0), new d(TAG_ROWS_PER_STRIP, (int) com.tencent.view.d.MIC_PTU_TRANS_XINGYE, (byte) 0), new d(TAG_STRIP_BYTE_COUNTS, (int) com.tencent.view.d.MIC_PTU_TRANS_ROUHE, (byte) 0), new d(TAG_X_RESOLUTION, com.tencent.view.d.MIC_PTU_BAIXI, 5, (byte) 0), new d(TAG_Y_RESOLUTION, 283, 5, (byte) 0), new d(TAG_PLANAR_CONFIGURATION, 284, 3, (byte) 0), new d(TAG_RESOLUTION_UNIT, com.tencent.view.d.MIC_PTU_YINGTAOBUDING, 3, (byte) 0), new d(TAG_TRANSFER_FUNCTION, 301, 3, (byte) 0), new d(TAG_SOFTWARE, com.tencent.view.d.MIC_PTU_QINGCHENG, 2, (byte) 0), new d(TAG_DATETIME, 306, 2, (byte) 0), new d(TAG_ARTIST, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, 2, (byte) 0), new d(TAG_WHITE_POINT, 318, 5, (byte) 0), new d(TAG_PRIMARY_CHROMATICITIES, ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5, (byte) 0), new d(TAG_SUB_IFD_POINTER, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0), new d(TAG_Y_CB_CR_COEFFICIENTS, i.CTRL_INDEX, 5, (byte) 0), new d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3, (byte) 0), new d(TAG_Y_CB_CR_POSITIONING, 531, 3, (byte) 0), new d(TAG_REFERENCE_BLACK_WHITE, com.tencent.mm.plugin.appbrand.jsapi.media.c.CTRL_INDEX, 5, (byte) 0), new d(TAG_COPYRIGHT, 33432, 2, (byte) 0), new d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new d(TAG_RW2_SENSOR_TOP_BORDER, 4, 4, (byte) 0), new d(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4, (byte) 0), new d(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4, (byte) 0), new d(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4, (byte) 0), new d(TAG_RW2_ISO, 23, 3, (byte) 0), new d(TAG_RW2_JPG_FROM_RAW, 46, 7, (byte) 0)};
    private static final d[] we = new d[]{new d(TAG_EXPOSURE_TIME, 33434, 5, (byte) 0), new d(TAG_F_NUMBER, 33437, 5, (byte) 0), new d(TAG_EXPOSURE_PROGRAM, 34850, 3, (byte) 0), new d(TAG_SPECTRAL_SENSITIVITY, 34852, 2, (byte) 0), new d(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3, (byte) 0), new d(TAG_OECF, 34856, 7, (byte) 0), new d(TAG_EXIF_VERSION, 36864, 2, (byte) 0), new d(TAG_DATETIME_ORIGINAL, 36867, 2, (byte) 0), new d(TAG_DATETIME_DIGITIZED, 36868, 2, (byte) 0), new d(TAG_COMPONENTS_CONFIGURATION, 37121, 7, (byte) 0), new d(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5, (byte) 0), new d(TAG_SHUTTER_SPEED_VALUE, 37377, 10, (byte) 0), new d(TAG_APERTURE_VALUE, 37378, 5, (byte) 0), new d(TAG_BRIGHTNESS_VALUE, 37379, 10, (byte) 0), new d(TAG_EXPOSURE_BIAS_VALUE, 37380, 10, (byte) 0), new d(TAG_MAX_APERTURE_VALUE, 37381, 5, (byte) 0), new d(TAG_SUBJECT_DISTANCE, 37382, 5, (byte) 0), new d(TAG_METERING_MODE, 37383, 3, (byte) 0), new d(TAG_LIGHT_SOURCE, 37384, 3, (byte) 0), new d(TAG_FLASH, 37385, 3, (byte) 0), new d(TAG_FOCAL_LENGTH, 37386, 5, (byte) 0), new d(TAG_SUBJECT_AREA, 37396, 3, (byte) 0), new d(TAG_MAKER_NOTE, 37500, 7, (byte) 0), new d(TAG_USER_COMMENT, 37510, 7, (byte) 0), new d(TAG_SUBSEC_TIME, 37520, 2, (byte) 0), new d(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2, (byte) 0), new d(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2, (byte) 0), new d(TAG_FLASHPIX_VERSION, 40960, 7, (byte) 0), new d(TAG_COLOR_SPACE, 40961, 3, (byte) 0), new d(TAG_PIXEL_X_DIMENSION, 40962, (byte) 0), new d(TAG_PIXEL_Y_DIMENSION, 40963, (byte) 0), new d(TAG_RELATED_SOUND_FILE, 40964, 2, (byte) 0), new d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4, (byte) 0), new d(TAG_FLASH_ENERGY, 41483, 5, (byte) 0), new d(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7, (byte) 0), new d(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5, (byte) 0), new d(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5, (byte) 0), new d(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3, (byte) 0), new d(TAG_SUBJECT_LOCATION, 41492, 3, (byte) 0), new d(TAG_EXPOSURE_INDEX, 41493, 5, (byte) 0), new d(TAG_SENSING_METHOD, 41495, 3, (byte) 0), new d(TAG_FILE_SOURCE, 41728, 7, (byte) 0), new d(TAG_SCENE_TYPE, 41729, 7, (byte) 0), new d(TAG_CFA_PATTERN, 41730, 7, (byte) 0), new d(TAG_CUSTOM_RENDERED, 41985, 3, (byte) 0), new d(TAG_EXPOSURE_MODE, 41986, 3, (byte) 0), new d(TAG_WHITE_BALANCE, 41987, 3, (byte) 0), new d(TAG_DIGITAL_ZOOM_RATIO, 41988, 5, (byte) 0), new d(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3, (byte) 0), new d(TAG_SCENE_CAPTURE_TYPE, 41990, 3, (byte) 0), new d(TAG_GAIN_CONTROL, 41991, 3, (byte) 0), new d(TAG_CONTRAST, 41992, 3, (byte) 0), new d(TAG_SATURATION, 41993, 3, (byte) 0), new d(TAG_SHARPNESS, 41994, 3, (byte) 0), new d(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7, (byte) 0), new d(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3, (byte) 0), new d(TAG_IMAGE_UNIQUE_ID, 42016, 2, (byte) 0), new d(TAG_DNG_VERSION, 50706, 1, (byte) 0), new d(TAG_DEFAULT_CROP_SIZE, 50720, (byte) 0)};
    private static final d[] wf = new d[]{new d(TAG_GPS_VERSION_ID, 0, 1, (byte) 0), new d(TAG_GPS_LATITUDE_REF, 1, 2, (byte) 0), new d(TAG_GPS_LATITUDE, 2, 5, (byte) 0), new d(TAG_GPS_LONGITUDE_REF, 3, 2, (byte) 0), new d(TAG_GPS_LONGITUDE, 4, 5, (byte) 0), new d(TAG_GPS_ALTITUDE_REF, 5, 1, (byte) 0), new d(TAG_GPS_ALTITUDE, 6, 5, (byte) 0), new d(TAG_GPS_TIMESTAMP, 7, 5, (byte) 0), new d(TAG_GPS_SATELLITES, 8, 2, (byte) 0), new d(TAG_GPS_STATUS, 9, 2, (byte) 0), new d(TAG_GPS_MEASURE_MODE, 10, 2, (byte) 0), new d(TAG_GPS_DOP, 11, 5, (byte) 0), new d(TAG_GPS_SPEED_REF, 12, 2, (byte) 0), new d(TAG_GPS_SPEED, 13, 5, (byte) 0), new d(TAG_GPS_TRACK_REF, 14, 2, (byte) 0), new d(TAG_GPS_TRACK, 15, 5, (byte) 0), new d(TAG_GPS_IMG_DIRECTION_REF, 16, 2, (byte) 0), new d(TAG_GPS_IMG_DIRECTION, 17, 5, (byte) 0), new d(TAG_GPS_MAP_DATUM, 18, 2, (byte) 0), new d(TAG_GPS_DEST_LATITUDE_REF, 19, 2, (byte) 0), new d(TAG_GPS_DEST_LATITUDE, 20, 5, (byte) 0), new d(TAG_GPS_DEST_LONGITUDE_REF, 21, 2, (byte) 0), new d(TAG_GPS_DEST_LONGITUDE, 22, 5, (byte) 0), new d(TAG_GPS_DEST_BEARING_REF, 23, 2, (byte) 0), new d(TAG_GPS_DEST_BEARING, 24, 5, (byte) 0), new d(TAG_GPS_DEST_DISTANCE_REF, 25, 2, (byte) 0), new d(TAG_GPS_DEST_DISTANCE, 26, 5, (byte) 0), new d(TAG_GPS_PROCESSING_METHOD, 27, 7, (byte) 0), new d(TAG_GPS_AREA_INFORMATION, 28, 7, (byte) 0), new d(TAG_GPS_DATESTAMP, 29, 2, (byte) 0), new d(TAG_GPS_DIFFERENTIAL, 30, 3, (byte) 0)};
    private static final d[] wg = new d[]{new d(TAG_INTEROPERABILITY_INDEX, 1, 2, (byte) 0)};
    private static final d[] wh = new d[]{new d(TAG_NEW_SUBFILE_TYPE, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, 4, (byte) 0), new d(TAG_SUBFILE_TYPE, 255, 4, (byte) 0), new d(TAG_THUMBNAIL_IMAGE_WIDTH, 256, (byte) 0), new d(TAG_THUMBNAIL_IMAGE_LENGTH, (int) com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO, (byte) 0), new d(TAG_BITS_PER_SAMPLE, com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO, 3, (byte) 0), new d(TAG_COMPRESSION, com.tencent.view.d.MIC_PTU_ZIPAI_MEDSEA, 3, (byte) 0), new d(TAG_PHOTOMETRIC_INTERPRETATION, com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM, 3, (byte) 0), new d(TAG_IMAGE_DESCRIPTION, 270, 2, (byte) 0), new d(TAG_MAKE, 271, 2, (byte) 0), new d(TAG_MODEL, 272, 2, (byte) 0), new d(TAG_STRIP_OFFSETS, 273, (byte) 0), new d(TAG_ORIENTATION, 274, 3, (byte) 0), new d(TAG_SAMPLES_PER_PIXEL, 277, 3, (byte) 0), new d(TAG_ROWS_PER_STRIP, (int) com.tencent.view.d.MIC_PTU_TRANS_XINGYE, (byte) 0), new d(TAG_STRIP_BYTE_COUNTS, (int) com.tencent.view.d.MIC_PTU_TRANS_ROUHE, (byte) 0), new d(TAG_X_RESOLUTION, com.tencent.view.d.MIC_PTU_BAIXI, 5, (byte) 0), new d(TAG_Y_RESOLUTION, 283, 5, (byte) 0), new d(TAG_PLANAR_CONFIGURATION, 284, 3, (byte) 0), new d(TAG_RESOLUTION_UNIT, com.tencent.view.d.MIC_PTU_YINGTAOBUDING, 3, (byte) 0), new d(TAG_TRANSFER_FUNCTION, 301, 3, (byte) 0), new d(TAG_SOFTWARE, com.tencent.view.d.MIC_PTU_QINGCHENG, 2, (byte) 0), new d(TAG_DATETIME, 306, 2, (byte) 0), new d(TAG_ARTIST, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, 2, (byte) 0), new d(TAG_WHITE_POINT, 318, 5, (byte) 0), new d(TAG_PRIMARY_CHROMATICITIES, ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, 5, (byte) 0), new d(TAG_SUB_IFD_POINTER, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0), new d(TAG_Y_CB_CR_COEFFICIENTS, i.CTRL_INDEX, 5, (byte) 0), new d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3, (byte) 0), new d(TAG_Y_CB_CR_POSITIONING, 531, 3, (byte) 0), new d(TAG_REFERENCE_BLACK_WHITE, com.tencent.mm.plugin.appbrand.jsapi.media.c.CTRL_INDEX, 5, (byte) 0), new d(TAG_COPYRIGHT, 33432, 2, (byte) 0), new d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new d(TAG_DNG_VERSION, 50706, 1, (byte) 0), new d(TAG_DEFAULT_CROP_SIZE, 50720, (byte) 0)};
    private static final d[] wi = new d[]{new d(TAG_ORF_THUMBNAIL_IMAGE, 256, 7, (byte) 0), new d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4, (byte) 0), new d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4, (byte) 0)};
    private static final d[] wj = new d[]{new d(TAG_ORF_PREVIEW_IMAGE_START, com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO, 4, (byte) 0), new d(TAG_ORF_PREVIEW_IMAGE_LENGTH, com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO, 4, (byte) 0)};
    private static final d[] wk = new d[]{new d(TAG_ORF_ASPECT_FRAME, 4371, 3, (byte) 0)};
    private static final d[] wl = new d[]{new d(TAG_COLOR_SPACE, 55, 3, (byte) 0)};
    static final d[][] wm = new d[][]{wd, we, wf, wg, wh, wd, wi, wj, wk, wl};
    private static final d[] wn = new d[]{new d(TAG_SUB_IFD_POINTER, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, 4, (byte) 0), new d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4, (byte) 0), new d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1, (byte) 0), new d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1, (byte) 0)};
    private static final d wo = new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0);
    private static final d wp = new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0);
    private static final HashMap<Integer, d>[] wq = new HashMap[wm.length];
    private static final HashMap<String, d>[] wr = new HashMap[wm.length];
    private static final HashSet<String> ws = new HashSet(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    private static final HashMap<Integer, Integer> wt = new HashMap();
    private static final Charset wu = Charset.forName("US-ASCII");
    static final byte[] wv = "Exif\u0000\u0000".getBytes(wu);
    private final String mFilename;
    private boolean wA;
    private int wB;
    private int wC;
    private byte[] wD;
    private int wE;
    private int wF;
    private int wG;
    private int wH;
    private int wI;
    private int wJ;
    private boolean wK;
    private final AssetInputStream ww;
    private int wx;
    private final HashMap<String, c>[] wy;
    private ByteOrder wz;

    static class a extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private final int mLength;
        int mPosition;
        private DataInputStream wN;
        ByteOrder wO;

        public a(InputStream inputStream) {
            this.wO = ByteOrder.BIG_ENDIAN;
            this.wN = new DataInputStream(inputStream);
            this.mLength = this.wN.available();
            this.mPosition = 0;
            this.wN.mark(this.mLength);
        }

        public a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }

        public final void seek(long j) {
            if (((long) this.mPosition) > j) {
                this.mPosition = 0;
                this.wN.reset();
                this.wN.mark(this.mLength);
            } else {
                j -= (long) this.mPosition;
            }
            if (skipBytes((int) j) != ((int) j)) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public final int available() {
            return this.wN.available();
        }

        public final int read() {
            this.mPosition++;
            return this.wN.read();
        }

        public final int read(byte[] bArr, int i, int i2) {
            int read = this.wN.read(bArr, i, i2);
            this.mPosition += read;
            return read;
        }

        public final int readUnsignedByte() {
            this.mPosition++;
            return this.wN.readUnsignedByte();
        }

        public final String readLine() {
            return null;
        }

        public final boolean readBoolean() {
            this.mPosition++;
            return this.wN.readBoolean();
        }

        public final char readChar() {
            this.mPosition += 2;
            return this.wN.readChar();
        }

        public final String readUTF() {
            this.mPosition += 2;
            return this.wN.readUTF();
        }

        public final void readFully(byte[] bArr, int i, int i2) {
            this.mPosition += i2;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            } else if (this.wN.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public final void readFully(byte[] bArr) {
            this.mPosition += bArr.length;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            } else if (this.wN.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public final byte readByte() {
            this.mPosition++;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.wN.read();
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
            int read = this.wN.read();
            int read2 = this.wN.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            } else if (this.wO == LITTLE_ENDIAN) {
                return (short) (read + (read2 << 8));
            } else {
                if (this.wO == BIG_ENDIAN) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.wO);
            }
        }

        public final int readInt() {
            this.mPosition += 4;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.wN.read();
            int read2 = this.wN.read();
            int read3 = this.wN.read();
            int read4 = this.wN.read();
            if ((((read | read2) | read3) | read4) < 0) {
                throw new EOFException();
            } else if (this.wO == LITTLE_ENDIAN) {
                return read + ((read2 << 8) + ((read3 << 16) + (read4 << 24)));
            } else if (this.wO == BIG_ENDIAN) {
                return (((read << 24) + (read2 << 16)) + (read3 << 8)) + read4;
            } else {
                throw new IOException("Invalid byte order: " + this.wO);
            }
        }

        public final int skipBytes(int i) {
            int min = Math.min(i, this.mLength - this.mPosition);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.wN.skipBytes(min - i2);
            }
            this.mPosition += i2;
            return i2;
        }

        public final int readUnsignedShort() {
            this.mPosition += 2;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.wN.read();
            int read2 = this.wN.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            } else if (this.wO == LITTLE_ENDIAN) {
                return read + (read2 << 8);
            } else {
                if (this.wO == BIG_ENDIAN) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.wO);
            }
        }

        public final long cM() {
            return ((long) readInt()) & 4294967295L;
        }

        public final long readLong() {
            this.mPosition += 8;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            }
            int read = this.wN.read();
            int read2 = this.wN.read();
            int read3 = this.wN.read();
            int read4 = this.wN.read();
            int read5 = this.wN.read();
            int read6 = this.wN.read();
            int read7 = this.wN.read();
            int read8 = this.wN.read();
            if ((((((((read | read2) | read3) | read4) | read5) | read6) | read7) | read8) < 0) {
                throw new EOFException();
            } else if (this.wO == LITTLE_ENDIAN) {
                return ((long) read) + (((((long) read3) << 16) + (((((long) read5) << 32) + (((((long) read7) << 48) + (((long) read8) << 56)) + (((long) read6) << 40))) + (((long) read4) << 24))) + (((long) read2) << 8));
            } else if (this.wO == BIG_ENDIAN) {
                return (((((((((long) read2) << 48) + (((long) read) << 56)) + (((long) read3) << 40)) + (((long) read4) << 32)) + (((long) read5) << 24)) + (((long) read6) << 16)) + (((long) read7) << 8)) + ((long) read8);
            } else {
                throw new IOException("Invalid byte order: " + this.wO);
            }
        }

        public final float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        public final double readDouble() {
            return Double.longBitsToDouble(readLong());
        }
    }

    static class b extends FilterOutputStream {
        ByteOrder wO;
        private final OutputStream wP;

        public b(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.wP = outputStream;
            this.wO = byteOrder;
        }

        public final void write(byte[] bArr) {
            this.wP.write(bArr);
        }

        public final void write(byte[] bArr, int i, int i2) {
            this.wP.write(bArr, i, i2);
        }

        public final void writeByte(int i) {
            this.wP.write(i);
        }

        public final void writeShort(short s) {
            if (this.wO == ByteOrder.LITTLE_ENDIAN) {
                this.wP.write((s >>> 0) & 255);
                this.wP.write((s >>> 8) & 255);
            } else if (this.wO == ByteOrder.BIG_ENDIAN) {
                this.wP.write((s >>> 8) & 255);
                this.wP.write((s >>> 0) & 255);
            }
        }

        public final void writeInt(int i) {
            if (this.wO == ByteOrder.LITTLE_ENDIAN) {
                this.wP.write((i >>> 0) & 255);
                this.wP.write((i >>> 8) & 255);
                this.wP.write((i >>> 16) & 255);
                this.wP.write((i >>> 24) & 255);
            } else if (this.wO == ByteOrder.BIG_ENDIAN) {
                this.wP.write((i >>> 24) & 255);
                this.wP.write((i >>> 16) & 255);
                this.wP.write((i >>> 8) & 255);
                this.wP.write((i >>> 0) & 255);
            }
        }
    }

    static class c {
        public final int format;
        public final int wQ;
        public final byte[] wR;

        /* synthetic */ c(int i, int i2, byte[] bArr, byte b) {
            this(i, i2, bArr);
        }

        c(int i, int i2, byte[] bArr) {
            this.format = i;
            this.wQ = i2;
            this.wR = bArr;
        }

        public static c a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.wb[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new c(3, iArr.length, wrap.array());
        }

        public static c a(int i, ByteOrder byteOrder) {
            return a(new int[]{i}, byteOrder);
        }

        public static c a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.wb[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new c(4, jArr.length, wrap.array());
        }

        public static c a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static c b(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.wb[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new c(9, iArr.length, wrap.array());
        }

        public static c E(String str) {
            byte[] bytes = (str + 0).getBytes(a.wu);
            return new c(2, bytes.length, bytes);
        }

        public static c a(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.wb[5] * eVarArr.length)]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.wU);
                wrap.putInt((int) eVar.wV);
            }
            return new c(5, eVarArr.length, wrap.array());
        }

        public static c a(e eVar, ByteOrder byteOrder) {
            return a(new e[]{eVar}, byteOrder);
        }

        public static c b(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.wb[10] * eVarArr.length)]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.wU);
                wrap.putInt((int) eVar.wV);
            }
            return new c(10, eVarArr.length, wrap.array());
        }

        public static c a(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.wb[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new c(12, dArr.length, wrap.array());
        }

        public final String toString() {
            return "(" + a.wa[this.format] + ", data length:" + this.wR.length + ")";
        }

        /* Access modifiers changed, original: final */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0042=Splitter:B:20:0x0042, B:53:0x00a6=Splitter:B:53:0x00a6} */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0042=Splitter:B:20:0x0042, B:53:0x00a6=Splitter:B:53:0x00a6} */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0073 A:{Catch:{ IOException -> 0x009c, all -> 0x01a5 }} */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0082 A:{Catch:{ IOException -> 0x009c, all -> 0x01a5 }} */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x0199 A:{SYNTHETIC, Splitter:B:133:0x0199} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final Object a(ByteOrder byteOrder) {
            a aVar;
            Throwable th;
            int i = 1;
            int i2 = 0;
            a aVar2;
            try {
                aVar2 = new a(this.wR);
                try {
                    aVar2.wO = byteOrder;
                    Object str;
                    int i3;
                    switch (this.format) {
                        case 1:
                        case 6:
                            if (this.wR.length != 1 || this.wR[0] < (byte) 0 || this.wR[0] > (byte) 1) {
                                str = new String(this.wR, a.wu);
                                try {
                                    aVar2.close();
                                    return str;
                                } catch (IOException e) {
                                    return str;
                                }
                            }
                            str = new String(new char[]{(char) (this.wR[0] + 48)});
                            try {
                                aVar2.close();
                                return str;
                            } catch (IOException e2) {
                                return str;
                            }
                        case 2:
                        case 7:
                            StringBuilder stringBuilder;
                            if (this.wQ >= a.wc.length) {
                                for (int i4 = 0; i4 < a.wc.length; i4++) {
                                    if (this.wR[i4] != a.wc[i4]) {
                                        i = 0;
                                        if (i != 0) {
                                            i = a.wc.length;
                                            stringBuilder = new StringBuilder();
                                            while (i < this.wQ) {
                                                byte b = this.wR[i];
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
                                            aVar2.close();
                                            return str;
                                        }
                                    }
                                }
                                if (i != 0) {
                                }
                            }
                            i = 0;
                            stringBuilder = new StringBuilder();
                            while (i < this.wQ) {
                            }
                            str = stringBuilder.toString();
                            try {
                                aVar2.close();
                                return str;
                            } catch (IOException e3) {
                                return str;
                            }
                        case 3:
                            str = new int[this.wQ];
                            while (i2 < this.wQ) {
                                str[i2] = aVar2.readUnsignedShort();
                                i2++;
                            }
                            try {
                                aVar2.close();
                                return str;
                            } catch (IOException e4) {
                                return str;
                            }
                        case 4:
                            str = new long[this.wQ];
                            while (i2 < this.wQ) {
                                str[i2] = aVar2.cM();
                                i2++;
                            }
                            try {
                                aVar2.close();
                                return str;
                            } catch (IOException e5) {
                                return str;
                            }
                        case 5:
                            str = new e[this.wQ];
                            while (true) {
                                i3 = i2;
                                if (i3 < this.wQ) {
                                    str[i3] = new e(aVar2.cM(), aVar2.cM(), (byte) 0);
                                    i2 = i3 + 1;
                                } else {
                                    try {
                                        aVar2.close();
                                        return str;
                                    } catch (IOException e6) {
                                        return str;
                                    }
                                }
                            }
                        case 8:
                            str = new int[this.wQ];
                            while (i2 < this.wQ) {
                                str[i2] = aVar2.readShort();
                                i2++;
                            }
                            try {
                                aVar2.close();
                                return str;
                            } catch (IOException e7) {
                                return str;
                            }
                        case 9:
                            str = new int[this.wQ];
                            while (i2 < this.wQ) {
                                str[i2] = aVar2.readInt();
                                i2++;
                            }
                            try {
                                aVar2.close();
                                return str;
                            } catch (IOException e8) {
                                return str;
                            }
                        case 10:
                            str = new e[this.wQ];
                            while (true) {
                                i3 = i2;
                                if (i3 < this.wQ) {
                                    str[i3] = new e((long) aVar2.readInt(), (long) aVar2.readInt(), (byte) 0);
                                    i2 = i3 + 1;
                                } else {
                                    try {
                                        aVar2.close();
                                        return str;
                                    } catch (IOException e9) {
                                        return str;
                                    }
                                }
                            }
                        case 11:
                            str = new double[this.wQ];
                            while (i2 < this.wQ) {
                                str[i2] = (double) aVar2.readFloat();
                                i2++;
                            }
                            try {
                                aVar2.close();
                                return str;
                            } catch (IOException e10) {
                                return str;
                            }
                        case 12:
                            str = new double[this.wQ];
                            while (i2 < this.wQ) {
                                str[i2] = aVar2.readDouble();
                                i2++;
                            }
                            try {
                                aVar2.close();
                                return str;
                            } catch (IOException e11) {
                                return str;
                            }
                        default:
                            try {
                                aVar2.close();
                            } catch (IOException e12) {
                            }
                            return null;
                    }
                } catch (IOException e13) {
                    aVar = aVar2;
                } catch (Throwable th2) {
                    th = th2;
                    if (aVar2 != null) {
                        try {
                            aVar2.close();
                        } catch (IOException e14) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e15) {
                aVar = null;
                if (aVar != null) {
                    try {
                        aVar.close();
                    } catch (IOException e16) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                aVar2 = null;
                if (aVar2 != null) {
                }
                throw th;
            }
        }

        public final double b(ByteOrder byteOrder) {
            Object a = a(byteOrder);
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
                } else if (a instanceof e[]) {
                    e[] eVarArr = (e[]) a;
                    if (eVarArr.length == 1) {
                        return eVarArr[0].cN();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public final int c(ByteOrder byteOrder) {
            Object a = a(byteOrder);
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

        public final String d(ByteOrder byteOrder) {
            int i = 0;
            Object a = a(byteOrder);
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
            } else if (!(a instanceof e[])) {
                return null;
            } else {
                e[] eVarArr = (e[]) a;
                while (i < eVarArr.length) {
                    stringBuilder.append(eVarArr[i].wU);
                    stringBuilder.append(IOUtils.DIR_SEPARATOR_UNIX);
                    stringBuilder.append(eVarArr[i].wV);
                    if (i + 1 != eVarArr.length) {
                        stringBuilder.append(",");
                    }
                    i++;
                }
                return stringBuilder.toString();
            }
        }

        public final int size() {
            return a.wb[this.format] * this.wQ;
        }
    }

    static class d {
        public final String name;
        public final int number;
        public final int wS;
        public final int wT;

        /* synthetic */ d(String str, int i, int i2, byte b) {
            this(str, i, i2);
        }

        private d(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.wS = i2;
            this.wT = -1;
        }

        private d(String str, int i) {
            this.name = str;
            this.number = i;
            this.wS = 3;
            this.wT = 4;
        }

        /* Access modifiers changed, original: final */
        public final boolean an(int i) {
            if (this.wS == 7 || i == 7 || this.wS == i || this.wT == i) {
                return true;
            }
            if ((this.wS == 4 || this.wT == 4) && i == 3) {
                return true;
            }
            if ((this.wS == 9 || this.wT == 9) && i == 8) {
                return true;
            }
            if ((this.wS == 12 || this.wT == 12) && i == 11) {
                return true;
            }
            return false;
        }
    }

    static class e {
        public final long wU;
        public final long wV;

        /* synthetic */ e(long j, long j2, byte b) {
            this(j, j2);
        }

        private e(double d) {
            this((long) (10000.0d * d), 10000);
        }

        private e(long j, long j2) {
            if (j2 == 0) {
                this.wU = 0;
                this.wV = 1;
                return;
            }
            this.wU = j;
            this.wV = j2;
        }

        public final String toString() {
            return this.wU + "/" + this.wV;
        }

        public final double cN() {
            return ((double) this.wU) / ((double) this.wV);
        }
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        vZ = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < wm.length; i++) {
            wq[i] = new HashMap();
            wr[i] = new HashMap();
            for (d dVar : wm[i]) {
                wq[i].put(Integer.valueOf(dVar.number), dVar);
                wr[i].put(dVar.name, dVar);
            }
        }
        wt.put(Integer.valueOf(wn[0].number), Integer.valueOf(5));
        wt.put(Integer.valueOf(wn[1].number), Integer.valueOf(1));
        wt.put(Integer.valueOf(wn[2].number), Integer.valueOf(2));
        wt.put(Integer.valueOf(wn[3].number), Integer.valueOf(3));
        wt.put(Integer.valueOf(wn[4].number), Integer.valueOf(7));
        wt.put(Integer.valueOf(wn[5].number), Integer.valueOf(8));
    }

    public a(String str) {
        Throwable th;
        this.wy = new HashMap[wm.length];
        this.wz = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        this.ww = null;
        this.mFilename = str;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                b((InputStream) fileInputStream);
                closeQuietly(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            closeQuietly(fileInputStream);
            throw th;
        }
    }

    public a(InputStream inputStream) {
        this.wy = new HashMap[wm.length];
        this.wz = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        this.mFilename = null;
        if (inputStream instanceof AssetInputStream) {
            this.ww = (AssetInputStream) inputStream;
        } else {
            this.ww = null;
        }
        b(inputStream);
    }

    private c C(String str) {
        Object str2;
        if (TAG_ISO_SPEED_RATINGS.equals(str2)) {
            str2 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= wm.length) {
                return null;
            }
            c cVar = (c) this.wy[i2].get(str2);
            if (cVar != null) {
                return cVar;
            }
            i = i2 + 1;
        }
    }

    public final String getAttribute(String str) {
        c C = C(str);
        if (C == null) {
            return null;
        }
        if (!ws.contains(str)) {
            return C.d(this.wz);
        }
        if (!str.equals(TAG_GPS_TIMESTAMP)) {
            try {
                return Double.toString(C.b(this.wz));
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (C.format == 5 || C.format == 10) {
            e[] eVarArr = (e[]) C.a(this.wz);
            if (eVarArr == null || eVarArr.length != 3) {
                new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(eVarArr));
                return null;
            }
            return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) eVarArr[0].wU) / ((float) eVarArr[0].wV))), Integer.valueOf((int) (((float) eVarArr[1].wU) / ((float) eVarArr[1].wV))), Integer.valueOf((int) (((float) eVarArr[2].wU) / ((float) eVarArr[2].wV)))});
        } else {
            new StringBuilder("GPS Timestamp format is not rational. format=").append(C.format);
            return null;
        }
    }

    public final int getAttributeInt(String str, int i) {
        c C = C(str);
        if (C == null) {
            return i;
        }
        try {
            return C.c(this.wz);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public final double getAttributeDouble(String str, double d) {
        c C = C(str);
        if (C == null) {
            return d;
        }
        try {
            return C.b(this.wz);
        } catch (NumberFormatException e) {
            return d;
        }
    }

    public final void setAttribute(String str, String str2) {
        Object str3;
        if (TAG_ISO_SPEED_RATINGS.equals(str3)) {
            str3 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        if (str2 != null && ws.contains(str3)) {
            if (str3.equals(TAG_GPS_TIMESTAMP)) {
                Matcher matcher = wM.matcher(str2);
                if (matcher.find()) {
                    str2 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    new StringBuilder("Invalid value for ").append(str3).append(" : ").append(str2);
                    return;
                }
            }
            try {
                str2 = new e(Double.parseDouble(str2), (byte) 0).toString();
            } catch (NumberFormatException e) {
                new StringBuilder("Invalid value for ").append(str3).append(" : ").append(str2);
                return;
            }
        }
        for (int i = 0; i < wm.length; i++) {
            if (i != 4 || this.wA) {
                d dVar = (d) wr[i].get(str3);
                if (dVar != null) {
                    if (str2 != null) {
                        int i2;
                        Pair D = D(str2);
                        if (dVar.wS == ((Integer) D.first).intValue() || dVar.wS == ((Integer) D.second).intValue()) {
                            i2 = dVar.wS;
                        } else if (dVar.wT != -1 && (dVar.wT == ((Integer) D.first).intValue() || dVar.wT == ((Integer) D.second).intValue())) {
                            i2 = dVar.wT;
                        } else if (dVar.wS == 1 || dVar.wS == 7 || dVar.wS == 2) {
                            i2 = dVar.wS;
                        } else {
                            String str4;
                            StringBuilder append = new StringBuilder("Given tag (").append(str3).append(") value didn't match with one of expected formats: ").append(wa[dVar.wS]).append(dVar.wT == -1 ? "" : ", " + wa[dVar.wT]).append(" (guess: ").append(wa[((Integer) D.first).intValue()]);
                            if (((Integer) D.second).intValue() == -1) {
                                str4 = "";
                            } else {
                                str4 = ", " + wa[((Integer) D.second).intValue()];
                            }
                            append.append(str4).append(")");
                        }
                        String[] split;
                        int[] iArr;
                        String[] split2;
                        e[] eVarArr;
                        String[] split3;
                        switch (i2) {
                            case 1:
                                Object cVar;
                                HashMap hashMap = this.wy[i];
                                if (str2.length() != 1 || str2.charAt(0) < '0' || str2.charAt(0) > '1') {
                                    byte[] bytes = str2.getBytes(wu);
                                    cVar = new c(1, bytes.length, bytes);
                                } else {
                                    cVar = new c(1, 1, new byte[]{(byte) (str2.charAt(0) - 48)});
                                }
                                hashMap.put(str3, cVar);
                                break;
                            case 2:
                            case 7:
                                this.wy[i].put(str3, c.E(str2));
                                break;
                            case 3:
                                split = str2.split(",");
                                iArr = new int[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    iArr[i2] = Integer.parseInt(split[i2]);
                                }
                                this.wy[i].put(str3, c.a(iArr, this.wz));
                                break;
                            case 4:
                                split = str2.split(",");
                                long[] jArr = new long[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    jArr[i2] = Long.parseLong(split[i2]);
                                }
                                this.wy[i].put(str3, c.a(jArr, this.wz));
                                break;
                            case 5:
                                split2 = str2.split(",");
                                eVarArr = new e[split2.length];
                                for (i2 = 0; i2 < split2.length; i2++) {
                                    split3 = split2[i2].split("/");
                                    eVarArr[i2] = new e((long) Double.parseDouble(split3[0]), (long) Double.parseDouble(split3[1]), (byte) 0);
                                }
                                this.wy[i].put(str3, c.a(eVarArr, this.wz));
                                break;
                            case 9:
                                split = str2.split(",");
                                iArr = new int[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    iArr[i2] = Integer.parseInt(split[i2]);
                                }
                                this.wy[i].put(str3, c.b(iArr, this.wz));
                                break;
                            case 10:
                                split2 = str2.split(",");
                                eVarArr = new e[split2.length];
                                for (i2 = 0; i2 < split2.length; i2++) {
                                    split3 = split2[i2].split("/");
                                    eVarArr[i2] = new e((long) Double.parseDouble(split3[0]), (long) Double.parseDouble(split3[1]), (byte) 0);
                                }
                                this.wy[i].put(str3, c.b(eVarArr, this.wz));
                                break;
                            case 12:
                                split = str2.split(",");
                                double[] dArr = new double[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    dArr[i2] = Double.parseDouble(split[i2]);
                                }
                                this.wy[i].put(str3, c.a(dArr, this.wz));
                                break;
                            default:
                                break;
                        }
                    }
                    this.wy[i].remove(str3);
                }
            }
        }
    }

    private void removeAttribute(String str) {
        for (int i = 0; i < wm.length; i++) {
            this.wy[i].remove(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0248 A:{Catch:{ IOException -> 0x00c0, all -> 0x00cd }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(InputStream inputStream) {
        Object obj;
        c cVar;
        c cVar2;
        int[] iArr;
        int i;
        int i2 = 0;
        while (i2 < wm.length) {
            try {
                this.wy[i2] = new HashMap();
                i2++;
            } catch (IOException e) {
                this.wK = false;
            } finally {
                cI();
            }
        }
        InputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        BufferedInputStream bufferedInputStream2 = (BufferedInputStream) bufferedInputStream;
        bufferedInputStream2.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream2.read(bArr);
        bufferedInputStream2.reset();
        if (e(bArr)) {
            i2 = 4;
        } else if (f(bArr)) {
            i2 = 9;
        } else {
            a aVar = new a(bArr);
            this.wz = c(aVar);
            aVar.wO = this.wz;
            short readShort = aVar.readShort();
            aVar.close();
            if (readShort == (short) 20306 || readShort == (short) 21330) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                i2 = 7;
            } else {
                aVar = new a(bArr);
                this.wz = c(aVar);
                aVar.wO = this.wz;
                short readShort2 = aVar.readShort();
                aVar.close();
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
        this.wx = i2;
        a aVar2 = new a(bufferedInputStream);
        switch (this.wx) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                a(aVar2);
                break;
            case 4:
                a(aVar2, 0, 0);
                break;
            case 7:
                a(aVar2);
                cVar = (c) this.wy[1].get(TAG_MAKER_NOTE);
                if (cVar != null) {
                    a aVar3 = new a(cVar.wR);
                    aVar3.wO = this.wz;
                    byte[] bArr2 = new byte[vX.length];
                    aVar3.readFully(bArr2);
                    aVar3.seek(0);
                    byte[] bArr3 = new byte[vY.length];
                    aVar3.readFully(bArr3);
                    if (Arrays.equals(bArr2, vX)) {
                        aVar3.seek(8);
                    } else if (Arrays.equals(bArr3, vY)) {
                        aVar3.seek(12);
                    }
                    b(aVar3, 6);
                    cVar = (c) this.wy[7].get(TAG_ORF_PREVIEW_IMAGE_START);
                    cVar2 = (c) this.wy[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
                    if (!(cVar == null || cVar2 == null)) {
                        this.wy[5].put(TAG_JPEG_INTERCHANGE_FORMAT, cVar);
                        this.wy[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, cVar2);
                    }
                    cVar = (c) this.wy[8].get(TAG_ORF_ASPECT_FRAME);
                    if (cVar != null) {
                        iArr = (int[]) cVar.a(this.wz);
                        if (iArr != null && iArr.length == 4) {
                            if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                                i = (iArr[2] - iArr[0]) + 1;
                                i2 = (iArr[3] - iArr[1]) + 1;
                                if (i < i2) {
                                    i += i2;
                                    i2 = i - i2;
                                    i -= i2;
                                }
                                cVar2 = c.a(i, this.wz);
                                cVar = c.a(i2, this.wz);
                                this.wy[0].put(TAG_IMAGE_WIDTH, cVar2);
                                this.wy[0].put(TAG_IMAGE_LENGTH, cVar);
                                break;
                            }
                        }
                        new StringBuilder("Invalid aspect frame values. frame=").append(Arrays.toString(iArr));
                        break;
                    }
                }
                break;
            case 9:
                b(aVar2);
                break;
            case 10:
                a(aVar2);
                if (((c) this.wy[0].get(TAG_RW2_JPG_FROM_RAW)) != null) {
                    a(aVar2, this.wJ, 5);
                }
                cVar = (c) this.wy[0].get(TAG_RW2_ISO);
                cVar2 = (c) this.wy[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
                if (cVar != null && cVar2 == null) {
                    this.wy[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, cVar);
                    break;
                }
        }
        HashMap hashMap = this.wy[4];
        cVar = (c) hashMap.get(TAG_COMPRESSION);
        if (cVar != null) {
            this.wE = cVar.c(this.wz);
            switch (this.wE) {
                case 1:
                case 7:
                    cVar = (c) hashMap.get(TAG_BITS_PER_SAMPLE);
                    if (cVar != null) {
                        iArr = (int[]) cVar.a(this.wz);
                        if (Arrays.equals(vT, iArr)) {
                            obj = 1;
                        } else if (this.wx == 3) {
                            cVar2 = (c) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION);
                            if (cVar2 != null) {
                                i = cVar2.c(this.wz);
                                if ((i == 1 && Arrays.equals(iArr, vV)) || (i == 6 && Arrays.equals(iArr, vT))) {
                                    i2 = 1;
                                }
                            }
                        }
                        if (obj != null) {
                            b(aVar2, hashMap);
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                    }
                    break;
                case 6:
                    a(aVar2, hashMap);
                    break;
            }
        }
        this.wE = 6;
        a(aVar2, hashMap);
        this.wK = true;
    }

    public final void saveAttributes() {
        Closeable fileInputStream;
        Closeable fileOutputStream;
        Throwable th;
        if (!this.wK || this.wx != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        } else if (this.mFilename == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        } else {
            byte[] thumbnailBytes;
            if (this.wE == 6 || this.wE == 7) {
                thumbnailBytes = getThumbnailBytes();
            } else {
                thumbnailBytes = null;
            }
            this.wD = thumbnailBytes;
            File file = new File(this.mFilename + ".tmp");
            if (new File(this.mFilename).renameTo(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(this.mFilename);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                    try {
                        b((InputStream) fileInputStream, (OutputStream) fileOutputStream);
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        file.delete();
                        this.wD = null;
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    fileInputStream = null;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
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
        if (!this.wA) {
            return null;
        }
        if (this.wD != null) {
            return this.wD;
        }
        Closeable closeable2;
        try {
            if (this.ww != null) {
                closeable2 = this.ww;
                try {
                    if (closeable2.markSupported()) {
                        closeable2.reset();
                        closeable = closeable2;
                    } else {
                        closeQuietly(closeable2);
                        return null;
                    }
                } catch (IOException e) {
                    closeQuietly(closeable2);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = closeable2;
                    closeQuietly(closeable);
                    throw th;
                }
            }
            closeable = this.mFilename != null ? new FileInputStream(this.mFilename) : null;
            if (closeable == null) {
                try {
                    throw new FileNotFoundException();
                } catch (IOException e2) {
                    closeable2 = closeable;
                    closeQuietly(closeable2);
                    return null;
                } catch (Throwable th22) {
                    th = th22;
                    closeQuietly(closeable);
                    throw th;
                }
            } else if (closeable.skip((long) this.wB) != ((long) this.wB)) {
                throw new IOException("Corrupted image");
            } else {
                byte[] bArr = new byte[this.wC];
                if (closeable.read(bArr) != this.wC) {
                    throw new IOException("Corrupted image");
                }
                this.wD = bArr;
                closeQuietly(closeable);
                return bArr;
            }
        } catch (IOException e3) {
            closeable2 = null;
            closeQuietly(closeable2);
            return null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            closeQuietly(closeable);
            throw th;
        }
    }

    public final double[] cH() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (!(attribute == null || attribute2 == null || attribute3 == null || attribute4 == null)) {
            try {
                double g = g(attribute, attribute2);
                double g2 = g(attribute3, attribute4);
                return new double[]{g, g2};
            } catch (IllegalArgumentException e) {
                new StringBuilder("Latitude/longitude values are not parseable. ").append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{attribute, attribute2, attribute3, attribute4}));
            }
        }
        return null;
    }

    private static double g(String str, String str2) {
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

    private static boolean e(byte[] bArr) {
        for (int i = 0; i < vW.length; i++) {
            if (bArr[i] != vW[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean f(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private void a(a aVar, int i, int i2) {
        aVar.wO = ByteOrder.BIG_ENDIAN;
        aVar.seek((long) i);
        byte readByte = aVar.readByte();
        if (readByte != (byte) -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i3 = i + 1;
        if (aVar.readByte() != (byte) -40) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i4 = i3 + 1;
        while (true) {
            byte readByte2 = aVar.readByte();
            if (readByte2 != (byte) -1) {
                throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
            }
            i4++;
            byte readByte3 = aVar.readByte();
            i3 = i4 + 1;
            if (readByte3 == (byte) -39 || readByte3 == (byte) -38) {
                aVar.wO = this.wz;
            } else {
                i4 = aVar.readUnsignedShort() - 2;
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
                        if (aVar.skipBytes(1) == 1) {
                            this.wy[i2].put(TAG_IMAGE_LENGTH, c.a((long) aVar.readUnsignedShort(), this.wz));
                            this.wy[i2].put(TAG_IMAGE_WIDTH, c.a((long) aVar.readUnsignedShort(), this.wz));
                            i4 -= 5;
                            break;
                        }
                        throw new IOException("Invalid SOFx");
                    case (byte) -31:
                        if (i4 >= 6) {
                            bArr = new byte[6];
                            if (aVar.read(bArr) == 6) {
                                i3 += 6;
                                i4 -= 6;
                                if (Arrays.equals(bArr, wv)) {
                                    if (i4 > 0) {
                                        this.wF = i3;
                                        bArr = new byte[i4];
                                        if (aVar.read(bArr) == i4) {
                                            i3 += i4;
                                            a aVar2 = new a(bArr);
                                            a(aVar2, bArr.length);
                                            b(aVar2, i2);
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
                        if (aVar.read(bArr) == i4) {
                            if (getAttribute(TAG_USER_COMMENT) != null) {
                                i4 = 0;
                                break;
                            }
                            this.wy[1].put(TAG_USER_COMMENT, c.E(new String(bArr, wu)));
                            i4 = 0;
                            break;
                        }
                        throw new IOException("Invalid exif");
                }
                if (i4 < 0) {
                    throw new IOException("Invalid length");
                } else if (aVar.skipBytes(i4) != i4) {
                    throw new IOException("Invalid JPEG segment");
                } else {
                    i4 += i3;
                }
            }
        }
        aVar.wO = this.wz;
    }

    private void a(a aVar) {
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        cJ();
        if (this.wx == 8) {
            c cVar = (c) this.wy[1].get(TAG_MAKER_NOTE);
            if (cVar != null) {
                a aVar2 = new a(cVar.wR);
                aVar2.wO = this.wz;
                aVar2.seek(6);
                b(aVar2, 9);
                cVar = (c) this.wy[9].get(TAG_COLOR_SPACE);
                if (cVar != null) {
                    this.wy[1].put(TAG_COLOR_SPACE, cVar);
                }
            }
        }
    }

    private void b(a aVar) {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i, 5);
        aVar.seek((long) i2);
        aVar.wO = ByteOrder.BIG_ENDIAN;
        i2 = aVar.readInt();
        for (i = 0; i < i2; i++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                i = aVar.readShort();
                i2 = aVar.readShort();
                c a = c.a(i, this.wz);
                c a2 = c.a(i2, this.wz);
                this.wy[0].put(TAG_IMAGE_LENGTH, a);
                this.wy[0].put(TAG_IMAGE_WIDTH, a2);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    private void b(InputStream inputStream, OutputStream outputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        b bVar = new b(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != (byte) -1) {
            throw new IOException("Invalid marker");
        }
        bVar.writeByte(-1);
        if (dataInputStream.readByte() != (byte) -40) {
            throw new IOException("Invalid marker");
        }
        bVar.writeByte(-40);
        bVar.writeByte(-1);
        bVar.writeByte(-31);
        a(bVar);
        byte[] bArr = new byte[4096];
        while (dataInputStream.readByte() == (byte) -1) {
            byte readByte = dataInputStream.readByte();
            int readUnsignedShort;
            int read;
            switch (readByte) {
                case (byte) -39:
                case (byte) -38:
                    bVar.writeByte(-1);
                    bVar.writeByte(readByte);
                    copy(dataInputStream, bVar);
                    return;
                case (byte) -31:
                    readUnsignedShort = dataInputStream.readUnsignedShort() - 2;
                    if (readUnsignedShort >= 0) {
                        byte[] bArr2 = new byte[6];
                        if (readUnsignedShort >= 6) {
                            if (dataInputStream.read(bArr2) == 6) {
                                if (Arrays.equals(bArr2, wv)) {
                                    if (dataInputStream.skipBytes(readUnsignedShort - 6) == readUnsignedShort - 6) {
                                        break;
                                    }
                                    throw new IOException("Invalid length");
                                }
                            }
                            throw new IOException("Invalid exif");
                        }
                        bVar.writeByte(-1);
                        bVar.writeByte(readByte);
                        bVar.writeShort((short) (readUnsignedShort + 2));
                        if (readUnsignedShort >= 6) {
                            readUnsignedShort -= 6;
                            bVar.write(bArr2);
                        }
                        while (readUnsignedShort > 0) {
                            read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, 4096));
                            if (read < 0) {
                                break;
                            }
                            bVar.write(bArr, 0, read);
                            readUnsignedShort -= read;
                        }
                        break;
                    }
                    throw new IOException("Invalid length");
                default:
                    bVar.writeByte(-1);
                    bVar.writeByte(readByte);
                    readUnsignedShort = dataInputStream.readUnsignedShort();
                    bVar.writeShort((short) readUnsignedShort);
                    readUnsignedShort -= 2;
                    if (readUnsignedShort >= 0) {
                        while (readUnsignedShort > 0) {
                            read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, 4096));
                            if (read < 0) {
                                break;
                            }
                            bVar.write(bArr, 0, read);
                            readUnsignedShort -= read;
                        }
                        break;
                    }
                    throw new IOException("Invalid length");
            }
        }
        throw new IOException("Invalid marker");
    }

    private void cI() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.wy[0].put(TAG_DATETIME, c.E(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.wy[0].put(TAG_IMAGE_WIDTH, c.a(0, this.wz));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.wy[0].put(TAG_IMAGE_LENGTH, c.a(0, this.wz));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.wy[0].put(TAG_ORIENTATION, c.a(0, this.wz));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.wy[1].put(TAG_LIGHT_SOURCE, c.a(0, this.wz));
        }
    }

    private static ByteOrder c(a aVar) {
        short readShort = aVar.readShort();
        switch (readShort) {
            case (short) 18761:
                return ByteOrder.LITTLE_ENDIAN;
            case (short) 19789:
                return ByteOrder.BIG_ENDIAN;
            default:
                throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void a(a aVar, int i) {
        this.wz = c(aVar);
        aVar.wO = this.wz;
        int readUnsignedShort = aVar.readUnsignedShort();
        if (this.wx == 7 || this.wx == 10 || readUnsignedShort == 42) {
            readUnsignedShort = aVar.readInt();
            if (readUnsignedShort < 8 || readUnsignedShort >= i) {
                throw new IOException("Invalid first Ifd offset: ".concat(String.valueOf(readUnsignedShort)));
            }
            readUnsignedShort -= 8;
            if (readUnsignedShort > 0 && aVar.skipBytes(readUnsignedShort) != readUnsignedShort) {
                throw new IOException("Couldn't jump to first Ifd: ".concat(String.valueOf(readUnsignedShort)));
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void b(a aVar, int i) {
        while (aVar.mPosition + 2 <= aVar.mLength) {
            short readShort = aVar.readShort();
            if (aVar.mPosition + (readShort * 12) <= aVar.mLength) {
                for (short s = (short) 0; s < readShort; s = (short) (s + 1)) {
                    int i2;
                    int readUnsignedShort = aVar.readUnsignedShort();
                    int readUnsignedShort2 = aVar.readUnsignedShort();
                    int readInt = aVar.readInt();
                    long j = 4 + ((long) aVar.mPosition);
                    d dVar = (d) wq[i].get(Integer.valueOf(readUnsignedShort));
                    long j2 = 0;
                    Object obj = null;
                    if (dVar == null) {
                        i2 = readUnsignedShort2;
                    } else if (readUnsignedShort2 <= 0 || readUnsignedShort2 >= wb.length) {
                        i2 = readUnsignedShort2;
                    } else if (dVar.an(readUnsignedShort2)) {
                        if (readUnsignedShort2 == 7) {
                            readUnsignedShort2 = dVar.wS;
                        }
                        j2 = ((long) readInt) * ((long) wb[readUnsignedShort2]);
                        if (j2 < 0 || j2 > 2147483647L) {
                            i2 = readUnsignedShort2;
                        } else {
                            obj = 1;
                            i2 = readUnsignedShort2;
                        }
                    } else {
                        new StringBuilder("Skip the tag entry since data format (").append(wa[readUnsignedShort2]).append(") is unexpected for tag: ").append(dVar.name);
                        i2 = readUnsignedShort2;
                    }
                    if (obj == null) {
                        aVar.seek(j);
                    } else {
                        c a;
                        if (j2 > 4) {
                            readUnsignedShort2 = aVar.readInt();
                            if (this.wx == 7) {
                                if (TAG_MAKER_NOTE.equals(dVar.name)) {
                                    this.wG = readUnsignedShort2;
                                } else if (i == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(dVar.name)) {
                                    this.wH = readUnsignedShort2;
                                    this.wI = readInt;
                                    a = c.a(6, this.wz);
                                    c a2 = c.a((long) this.wH, this.wz);
                                    c a3 = c.a((long) this.wI, this.wz);
                                    this.wy[4].put(TAG_COMPRESSION, a);
                                    this.wy[4].put(TAG_JPEG_INTERCHANGE_FORMAT, a2);
                                    this.wy[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, a3);
                                }
                            } else if (this.wx == 10 && TAG_RW2_JPG_FROM_RAW.equals(dVar.name)) {
                                this.wJ = readUnsignedShort2;
                            }
                            if (((long) readUnsignedShort2) + j2 <= ((long) aVar.mLength)) {
                                aVar.seek((long) readUnsignedShort2);
                            } else {
                                aVar.seek(j);
                            }
                        }
                        Integer num = (Integer) wt.get(Integer.valueOf(readUnsignedShort));
                        if (num != null) {
                            long j3 = -1;
                            switch (i2) {
                                case 3:
                                    j3 = (long) aVar.readUnsignedShort();
                                    break;
                                case 4:
                                    j3 = aVar.cM();
                                    break;
                                case 8:
                                    j3 = (long) aVar.readShort();
                                    break;
                                case 9:
                                case 13:
                                    j3 = (long) aVar.readInt();
                                    break;
                            }
                            if (j3 > 0 && j3 < ((long) aVar.mLength)) {
                                aVar.seek(j3);
                                b(aVar, num.intValue());
                            }
                            aVar.seek(j);
                        } else {
                            byte[] bArr = new byte[((int) j2)];
                            aVar.readFully(bArr);
                            a = new c(i2, readInt, bArr, (byte) 0);
                            this.wy[i].put(dVar.name, a);
                            if (TAG_DNG_VERSION.equals(dVar.name)) {
                                this.wx = 3;
                            }
                            if (((TAG_MAKE.equals(dVar.name) || TAG_MODEL.equals(dVar.name)) && a.d(this.wz).contains("PENTAX")) || (TAG_COMPRESSION.equals(dVar.name) && a.c(this.wz) == CdnLogic.kBizGeneric)) {
                                this.wx = 8;
                            }
                            if (((long) aVar.mPosition) != j) {
                                aVar.seek(j);
                            }
                        }
                    }
                }
                if (aVar.mPosition + 4 <= aVar.mLength) {
                    int readInt2 = aVar.readInt();
                    if (readInt2 > 8 && readInt2 < aVar.mLength) {
                        aVar.seek((long) readInt2);
                        if (this.wy[4].isEmpty()) {
                            i = 4;
                        } else if (this.wy[5].isEmpty()) {
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

    private void c(a aVar, int i) {
        c cVar = (c) this.wy[i].get(TAG_IMAGE_WIDTH);
        if (((c) this.wy[i].get(TAG_IMAGE_LENGTH)) == null || cVar == null) {
            c cVar2 = (c) this.wy[i].get(TAG_JPEG_INTERCHANGE_FORMAT);
            if (cVar2 != null) {
                a(aVar, cVar2.c(this.wz), i);
            }
        }
    }

    private void a(a aVar, HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        c cVar2 = (c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (cVar != null && cVar2 != null) {
            int c = cVar.c(this.wz);
            int min = Math.min(cVar2.c(this.wz), aVar.available() - c);
            if (this.wx == 4 || this.wx == 9 || this.wx == 10) {
                c += this.wF;
            } else if (this.wx == 7) {
                c += this.wG;
            }
            if (c > 0 && min > 0) {
                this.wA = true;
                this.wB = c;
                this.wC = min;
                if (this.mFilename == null && this.ww == null) {
                    byte[] bArr = new byte[min];
                    aVar.seek((long) c);
                    aVar.readFully(bArr);
                    this.wD = bArr;
                }
            }
        }
    }

    private void b(a aVar, HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_STRIP_OFFSETS);
        c cVar2 = (c) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (cVar != null && cVar2 != null) {
            long[] i = i(cVar.a(this.wz));
            long[] i2 = i(cVar2.a(this.wz));
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
                    aVar.seek((long) i7);
                    i5 += i7;
                    byte[] bArr2 = new byte[i6];
                    aVar.read(bArr2);
                    i5 += i6;
                    System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
                    i4 += bArr2.length;
                }
                this.wA = true;
                this.wD = bArr;
                this.wC = bArr.length;
            }
        }
    }

    private boolean h(HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_IMAGE_LENGTH);
        c cVar2 = (c) hashMap.get(TAG_IMAGE_WIDTH);
        if (!(cVar == null || cVar2 == null)) {
            int c = cVar.c(this.wz);
            int c2 = cVar2.c(this.wz);
            if (c <= 512 && c2 <= 512) {
                return true;
            }
        }
        return false;
    }

    private void cJ() {
        q(0, 5);
        q(0, 4);
        q(5, 4);
        c cVar = (c) this.wy[1].get(TAG_PIXEL_X_DIMENSION);
        c cVar2 = (c) this.wy[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(cVar == null || cVar2 == null)) {
            this.wy[0].put(TAG_IMAGE_WIDTH, cVar);
            this.wy[0].put(TAG_IMAGE_LENGTH, cVar2);
        }
        if (this.wy[4].isEmpty() && h(this.wy[5])) {
            this.wy[4] = this.wy[5];
            this.wy[5] = new HashMap();
        }
        h(this.wy[4]);
    }

    private void d(a aVar, int i) {
        c cVar = (c) this.wy[i].get(TAG_DEFAULT_CROP_SIZE);
        c cVar2 = (c) this.wy[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        c cVar3 = (c) this.wy[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        c cVar4 = (c) this.wy[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        c cVar5 = (c) this.wy[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (cVar != null) {
            Object a;
            Object a2;
            if (cVar.format == 5) {
                e[] eVarArr = (e[]) cVar.a(this.wz);
                if (eVarArr == null || eVarArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(eVarArr));
                    return;
                } else {
                    a = c.a(eVarArr[0], this.wz);
                    a2 = c.a(eVarArr[1], this.wz);
                }
            } else {
                int[] iArr = (int[]) cVar.a(this.wz);
                if (iArr == null || iArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(iArr));
                    return;
                } else {
                    a = c.a(iArr[0], this.wz);
                    a2 = c.a(iArr[1], this.wz);
                }
            }
            this.wy[i].put(TAG_IMAGE_WIDTH, a);
            this.wy[i].put(TAG_IMAGE_LENGTH, a2);
        } else if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
            c(aVar, i);
        } else {
            int c = cVar2.c(this.wz);
            int c2 = cVar4.c(this.wz);
            int c3 = cVar5.c(this.wz);
            int c4 = cVar3.c(this.wz);
            if (c2 > c && c3 > c4) {
                c = c2 - c;
                c2 = c3 - c4;
                cVar = c.a(c, this.wz);
                cVar2 = c.a(c2, this.wz);
                this.wy[i].put(TAG_IMAGE_LENGTH, cVar);
                this.wy[i].put(TAG_IMAGE_WIDTH, cVar2);
            }
        }
    }

    private int a(b bVar) {
        int size;
        int i;
        int i2;
        Entry entry;
        int[] iArr = new int[wm.length];
        int[] iArr2 = new int[wm.length];
        for (d dVar : wn) {
            removeAttribute(dVar.name);
        }
        removeAttribute(wo.name);
        removeAttribute(wp.name);
        for (i2 = 0; i2 < wm.length; i2++) {
            for (Object obj : this.wy[i2].entrySet().toArray()) {
                entry = (Entry) obj;
                if (entry.getValue() == null) {
                    this.wy[i2].remove(entry.getKey());
                }
            }
        }
        if (!this.wy[1].isEmpty()) {
            this.wy[0].put(wn[1].name, c.a(0, this.wz));
        }
        if (!this.wy[2].isEmpty()) {
            this.wy[0].put(wn[2].name, c.a(0, this.wz));
        }
        if (!this.wy[3].isEmpty()) {
            this.wy[1].put(wn[3].name, c.a(0, this.wz));
        }
        if (this.wA) {
            this.wy[4].put(wo.name, c.a(0, this.wz));
            this.wy[4].put(wp.name, c.a((long) this.wC, this.wz));
        }
        for (i = 0; i < wm.length; i++) {
            i2 = 0;
            for (Entry entry2 : this.wy[i].entrySet()) {
                size = ((c) entry2.getValue()).size();
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
        for (size = 0; size < wm.length; size++) {
            if (!this.wy[size].isEmpty()) {
                iArr[size] = i2;
                i2 += (((this.wy[size].size() * 12) + 2) + 4) + iArr2[size];
            }
        }
        if (this.wA) {
            this.wy[4].put(wo.name, c.a((long) i2, this.wz));
            this.wB = i2 + 6;
            i2 += this.wC;
        }
        int i3 = i2 + 8;
        if (!this.wy[1].isEmpty()) {
            this.wy[0].put(wn[1].name, c.a((long) iArr[1], this.wz));
        }
        if (!this.wy[2].isEmpty()) {
            this.wy[0].put(wn[2].name, c.a((long) iArr[2], this.wz));
        }
        if (!this.wy[3].isEmpty()) {
            this.wy[1].put(wn[3].name, c.a((long) iArr[3], this.wz));
        }
        bVar.writeShort((short) i3);
        bVar.write(wv);
        bVar.writeShort(this.wz == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        bVar.wO = this.wz;
        bVar.writeShort((short) 42);
        bVar.writeInt(8);
        for (int i4 = 0; i4 < wm.length; i4++) {
            if (!this.wy[i4].isEmpty()) {
                c cVar;
                bVar.writeShort((short) this.wy[i4].size());
                size = ((iArr[i4] + 2) + (this.wy[i4].size() * 12)) + 4;
                i = size;
                for (Entry entry22 : this.wy[i4].entrySet()) {
                    int i5 = ((d) wr[i4].get(entry22.getKey())).number;
                    cVar = (c) entry22.getValue();
                    i2 = cVar.size();
                    bVar.writeShort((short) i5);
                    bVar.writeShort((short) cVar.format);
                    bVar.writeInt(cVar.wQ);
                    if (i2 > 4) {
                        bVar.writeInt((int) ((long) i));
                        i += i2;
                    } else {
                        bVar.write(cVar.wR);
                        if (i2 < 4) {
                            for (size = i2; size < 4; size++) {
                                bVar.writeByte(0);
                            }
                        }
                    }
                }
                if (i4 != 0 || this.wy[4].isEmpty()) {
                    bVar.writeInt(0);
                } else {
                    bVar.writeInt((int) ((long) iArr[4]));
                }
                for (Entry entry222 : this.wy[i4].entrySet()) {
                    cVar = (c) entry222.getValue();
                    if (cVar.wR.length > 4) {
                        bVar.write(cVar.wR, 0, cVar.wR.length);
                    }
                }
            }
        }
        if (this.wA) {
            bVar.write(getThumbnailBytes());
        }
        bVar.wO = ByteOrder.BIG_ENDIAN;
        return i3;
    }

    private static Pair<Integer, Integer> D(String str) {
        if (str.contains(",")) {
            String[] split = str.split(",");
            Pair<Integer, Integer> D = D(split[0]);
            if (((Integer) D.first).intValue() == 2) {
                return D;
            }
            int i = 1;
            while (i < split.length) {
                int intValue;
                int i2;
                Pair D2 = D(split[i]);
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

    private void q(int i, int i2) {
        if (!this.wy[i].isEmpty() && !this.wy[i2].isEmpty()) {
            c cVar = (c) this.wy[i].get(TAG_IMAGE_LENGTH);
            c cVar2 = (c) this.wy[i].get(TAG_IMAGE_WIDTH);
            c cVar3 = (c) this.wy[i2].get(TAG_IMAGE_LENGTH);
            c cVar4 = (c) this.wy[i2].get(TAG_IMAGE_WIDTH);
            if (cVar != null && cVar2 != null && cVar3 != null && cVar4 != null) {
                int c = cVar.c(this.wz);
                int c2 = cVar2.c(this.wz);
                int c3 = cVar3.c(this.wz);
                int c4 = cVar4.c(this.wz);
                if (c < c3 && c2 < c4) {
                    HashMap hashMap = this.wy[i];
                    HashMap[] hashMapArr = this.wy;
                    hashMapArr[i] = hashMapArr[i2];
                    this.wy[i2] = hashMap;
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

    private static long[] i(Object obj) {
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
