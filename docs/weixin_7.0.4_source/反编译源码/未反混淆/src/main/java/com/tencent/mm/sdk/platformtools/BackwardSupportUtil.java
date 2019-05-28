package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.vfs.e;
import java.io.InputStream;

public final class BackwardSupportUtil {

    public static class ExifHelper {

        public static class LatLongData implements Parcelable {
            public static final Creator<LatLongData> CREATOR = new Creator<LatLongData>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new LatLongData[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(93286);
                    LatLongData latLongData = new LatLongData();
                    latLongData.cEB = parcel.readFloat();
                    latLongData.fFz = parcel.readFloat();
                    AppMethodBeat.o(93286);
                    return latLongData;
                }
            };
            public float cEB;
            public float fFz;

            public LatLongData() {
                this.cEB = 0.0f;
                this.fFz = 0.0f;
            }

            public LatLongData(float f, float f2) {
                this.cEB = f;
                this.fFz = f2;
            }

            public int hashCode() {
                return ((int) (this.cEB * 10000.0f)) + ((int) (this.fFz * 10000.0f));
            }

            public boolean equals(Object obj) {
                AppMethodBeat.i(93287);
                if (obj instanceof LatLongData) {
                    LatLongData latLongData = (LatLongData) obj;
                    if (Math.abs(this.cEB - latLongData.cEB) >= 1.0E-6f || Math.abs(this.fFz - latLongData.fFz) >= 1.0E-6f) {
                        AppMethodBeat.o(93287);
                        return false;
                    }
                    AppMethodBeat.o(93287);
                    return true;
                }
                AppMethodBeat.o(93287);
                return false;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.i(93288);
                parcel.writeFloat(this.cEB);
                parcel.writeFloat(this.fFz);
                AppMethodBeat.o(93288);
            }

            static {
                AppMethodBeat.i(93289);
                AppMethodBeat.o(93289);
            }
        }

        public static int bJ(String str) {
            AppMethodBeat.i(93290);
            if (bo.isNullOrNil(str)) {
                ab.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                AppMethodBeat.o(93290);
                return 0;
            } else if (e.ct(str)) {
                int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
                AppMethodBeat.o(93290);
                return orientationInDegree;
            } else {
                ab.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                AppMethodBeat.o(93290);
                return 0;
            }
        }

        public static LatLongData ami(String str) {
            AppMethodBeat.i(93291);
            if (bo.isNullOrNil(str)) {
                ab.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                AppMethodBeat.o(93291);
                return null;
            } else if (e.ct(str)) {
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                if (location != null) {
                    LatLongData latLongData = new LatLongData();
                    latLongData.cEB = (float) location.latitude;
                    latLongData.fFz = (float) location.longitude;
                    AppMethodBeat.o(93291);
                    return latLongData;
                }
                AppMethodBeat.o(93291);
                return null;
            } else {
                ab.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                AppMethodBeat.o(93291);
                return null;
            }
        }
    }

    public static class a {
        public static void a(View view, Animation animation) {
            AppMethodBeat.i(93280);
            if (VERSION.SDK_INT >= 8) {
                b bVar = new b();
                animation.cancel();
                AppMethodBeat.o(93280);
                return;
            }
            a aVar = new a();
            a.ez(view);
            AppMethodBeat.o(93280);
        }
    }

    public static class b {
        public static Bitmap i(String str, float f) {
            AppMethodBeat.i(93281);
            float f2 = 160.0f * f;
            Bitmap j = d.j(str, f);
            if (j != null) {
                j.setDensity((int) f2);
            }
            AppMethodBeat.o(93281);
            return j;
        }

        public static int b(Context context, float f) {
            AppMethodBeat.i(93282);
            int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * f) / 160.0f);
            AppMethodBeat.o(93282);
            return round;
        }

        public static Bitmap a(InputStream inputStream, float f) {
            AppMethodBeat.i(93283);
            Bitmap b = b(inputStream, f);
            AppMethodBeat.o(93283);
            return b;
        }

        public static Bitmap b(InputStream inputStream, float f) {
            AppMethodBeat.i(93284);
            float f2 = 160.0f * f;
            Bitmap a = d.a(inputStream, f, 0, 0);
            if (a != null) {
                a.setDensity((int) f2);
            }
            AppMethodBeat.o(93284);
            return a;
        }

        public static String gi(Context context) {
            String str;
            AppMethodBeat.i(93285);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = "";
            if (displayMetrics.density < 1.0f) {
                str = str2 + "LDPI";
            } else if (displayMetrics.density >= 1.5f) {
                str = str2 + "HDPI";
            } else {
                str = str2 + "MDPI";
            }
            str = str + (configuration.orientation == 2 ? "_L" : "_P");
            AppMethodBeat.o(93285);
            return str;
        }
    }

    public static class c {
        public static void a(ListView listView) {
            AppMethodBeat.i(93292);
            if (listView == null) {
                AppMethodBeat.o(93292);
            } else if (VERSION.SDK_INT >= 8) {
                bi biVar = new bi();
                bi.c(listView);
                AppMethodBeat.o(93292);
            } else {
                bh bhVar = new bh();
                listView.setSelection(0);
                AppMethodBeat.o(93292);
            }
        }

        public static void b(ListView listView, int i) {
            AppMethodBeat.i(93293);
            if (listView == null) {
                AppMethodBeat.o(93293);
            } else if (VERSION.SDK_INT >= 8) {
                bi biVar = new bi();
                bi.d(listView, i);
                AppMethodBeat.o(93293);
            } else {
                bh bhVar = new bh();
                listView.setSelection(i);
                AppMethodBeat.o(93293);
            }
        }

        public static void c(ListView listView, int i) {
            AppMethodBeat.i(93294);
            if (listView == null) {
                AppMethodBeat.o(93294);
            } else if (VERSION.SDK_INT >= 11) {
                bi biVar = new bi();
                int firstVisiblePosition = listView.getFirstVisiblePosition();
                if (firstVisiblePosition < i && firstVisiblePosition + 10 < i) {
                    listView.setSelectionFromTop(i - 10, 0);
                } else if (firstVisiblePosition > i && firstVisiblePosition - 10 > i) {
                    listView.setSelectionFromTop(i + 10, 0);
                }
                if (VERSION.SDK_INT >= 11) {
                    listView.smoothScrollToPositionFromTop(i, 0);
                }
                AppMethodBeat.o(93294);
            } else {
                bh bhVar = new bh();
                listView.setSelectionFromTop(i, 0);
                AppMethodBeat.o(93294);
            }
        }
    }

    public static LatLongData amg(String str) {
        AppMethodBeat.i(93295);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(23);
            mediaMetadataRetriever.release();
            ab.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong locationString ".concat(String.valueOf(extractMetadata)));
            if (TextUtils.isEmpty(extractMetadata)) {
                AppMethodBeat.o(93295);
                return null;
            }
            char[] toCharArray = extractMetadata.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : toCharArray) {
                if (c == '+' || c == '-' || c == '.' || TextUtils.isDigitsOnly(String.valueOf(c))) {
                    stringBuilder.append(c);
                }
            }
            extractMetadata = stringBuilder.toString();
            int lastIndexOf = extractMetadata.lastIndexOf(43);
            if (-1 == lastIndexOf) {
                lastIndexOf = extractMetadata.lastIndexOf(45);
            }
            LatLongData latLongData = new LatLongData();
            latLongData.cEB = bo.ann(extractMetadata.substring(0, lastIndexOf));
            latLongData.fFz = bo.ann(extractMetadata.substring(lastIndexOf));
            AppMethodBeat.o(93295);
            return latLongData;
        } catch (Exception e) {
            ab.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + e.getMessage());
            AppMethodBeat.o(93295);
            return null;
        }
    }

    public static String amh(String str) {
        AppMethodBeat.i(93296);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(5);
            mediaMetadataRetriever.release();
            ab.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoTakeTime timeString ".concat(String.valueOf(extractMetadata)));
            AppMethodBeat.o(93296);
            return extractMetadata;
        } catch (Exception e) {
            ab.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + e.getMessage());
            AppMethodBeat.o(93296);
            return null;
        }
    }
}
