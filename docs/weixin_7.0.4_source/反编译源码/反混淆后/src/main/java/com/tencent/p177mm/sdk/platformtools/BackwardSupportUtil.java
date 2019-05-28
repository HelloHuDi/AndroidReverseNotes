package com.tencent.p177mm.sdk.platformtools;

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
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.compatible.util.Exif.C1440a;
import com.tencent.p177mm.vfs.C5730e;
import java.io.InputStream;

/* renamed from: com.tencent.mm.sdk.platformtools.BackwardSupportUtil */
public final class BackwardSupportUtil {

    /* renamed from: com.tencent.mm.sdk.platformtools.BackwardSupportUtil$ExifHelper */
    public static class ExifHelper {

        /* renamed from: com.tencent.mm.sdk.platformtools.BackwardSupportUtil$ExifHelper$LatLongData */
        public static class LatLongData implements Parcelable {
            public static final Creator<LatLongData> CREATOR = new C49751();
            public float cEB;
            public float fFz;

            /* renamed from: com.tencent.mm.sdk.platformtools.BackwardSupportUtil$ExifHelper$LatLongData$1 */
            static class C49751 implements Creator<LatLongData> {
                C49751() {
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new LatLongData[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.m2504i(93286);
                    LatLongData latLongData = new LatLongData();
                    latLongData.cEB = parcel.readFloat();
                    latLongData.fFz = parcel.readFloat();
                    AppMethodBeat.m2505o(93286);
                    return latLongData;
                }
            }

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
                AppMethodBeat.m2504i(93287);
                if (obj instanceof LatLongData) {
                    LatLongData latLongData = (LatLongData) obj;
                    if (Math.abs(this.cEB - latLongData.cEB) >= 1.0E-6f || Math.abs(this.fFz - latLongData.fFz) >= 1.0E-6f) {
                        AppMethodBeat.m2505o(93287);
                        return false;
                    }
                    AppMethodBeat.m2505o(93287);
                    return true;
                }
                AppMethodBeat.m2505o(93287);
                return false;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.m2504i(93288);
                parcel.writeFloat(this.cEB);
                parcel.writeFloat(this.fFz);
                AppMethodBeat.m2505o(93288);
            }

            static {
                AppMethodBeat.m2504i(93289);
                AppMethodBeat.m2505o(93289);
            }
        }

        /* renamed from: bJ */
        public static int m7368bJ(String str) {
            AppMethodBeat.m2504i(93290);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7410d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                AppMethodBeat.m2505o(93290);
                return 0;
            } else if (C5730e.m8628ct(str)) {
                int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
                AppMethodBeat.m2505o(93290);
                return orientationInDegree;
            } else {
                C4990ab.m7411d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                AppMethodBeat.m2505o(93290);
                return 0;
            }
        }

        public static LatLongData ami(String str) {
            AppMethodBeat.m2504i(93291);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7410d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                AppMethodBeat.m2505o(93291);
                return null;
            } else if (C5730e.m8628ct(str)) {
                C1440a location = Exif.fromFile(str).getLocation();
                if (location != null) {
                    LatLongData latLongData = new LatLongData();
                    latLongData.cEB = (float) location.latitude;
                    latLongData.fFz = (float) location.longitude;
                    AppMethodBeat.m2505o(93291);
                    return latLongData;
                }
                AppMethodBeat.m2505o(93291);
                return null;
            } else {
                C4990ab.m7411d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                AppMethodBeat.m2505o(93291);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.BackwardSupportUtil$a */
    public static class C4976a {
        /* renamed from: a */
        public static void m7369a(View view, Animation animation) {
            AppMethodBeat.m2504i(93280);
            if (VERSION.SDK_INT >= 8) {
                C5032b c5032b = new C5032b();
                animation.cancel();
                AppMethodBeat.m2505o(93280);
                return;
            }
            C4987a c4987a = new C4987a();
            C4987a.m7398ez(view);
            AppMethodBeat.m2505o(93280);
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.BackwardSupportUtil$b */
    public static class C4977b {
        /* renamed from: i */
        public static Bitmap m7374i(String str, float f) {
            AppMethodBeat.m2504i(93281);
            float f2 = 160.0f * f;
            Bitmap j = C5056d.m7664j(str, f);
            if (j != null) {
                j.setDensity((int) f2);
            }
            AppMethodBeat.m2505o(93281);
            return j;
        }

        /* renamed from: b */
        public static int m7371b(Context context, float f) {
            AppMethodBeat.m2504i(93282);
            int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * f) / 160.0f);
            AppMethodBeat.m2505o(93282);
            return round;
        }

        /* renamed from: a */
        public static Bitmap m7370a(InputStream inputStream, float f) {
            AppMethodBeat.m2504i(93283);
            Bitmap b = C4977b.m7372b(inputStream, f);
            AppMethodBeat.m2505o(93283);
            return b;
        }

        /* renamed from: b */
        public static Bitmap m7372b(InputStream inputStream, float f) {
            AppMethodBeat.m2504i(93284);
            float f2 = 160.0f * f;
            Bitmap a = C5056d.m7620a(inputStream, f, 0, 0);
            if (a != null) {
                a.setDensity((int) f2);
            }
            AppMethodBeat.m2505o(93284);
            return a;
        }

        /* renamed from: gi */
        public static String m7373gi(Context context) {
            String str;
            AppMethodBeat.m2504i(93285);
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
            AppMethodBeat.m2505o(93285);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.BackwardSupportUtil$c */
    public static class C4978c {
        /* renamed from: a */
        public static void m7375a(ListView listView) {
            AppMethodBeat.m2504i(93292);
            if (listView == null) {
                AppMethodBeat.m2505o(93292);
            } else if (VERSION.SDK_INT >= 8) {
                C5037bi c5037bi = new C5037bi();
                C5037bi.m7493c(listView);
                AppMethodBeat.m2505o(93292);
            } else {
                C5036bh c5036bh = new C5036bh();
                listView.setSelection(0);
                AppMethodBeat.m2505o(93292);
            }
        }

        /* renamed from: b */
        public static void m7376b(ListView listView, int i) {
            AppMethodBeat.m2504i(93293);
            if (listView == null) {
                AppMethodBeat.m2505o(93293);
            } else if (VERSION.SDK_INT >= 8) {
                C5037bi c5037bi = new C5037bi();
                C5037bi.m7494d(listView, i);
                AppMethodBeat.m2505o(93293);
            } else {
                C5036bh c5036bh = new C5036bh();
                listView.setSelection(i);
                AppMethodBeat.m2505o(93293);
            }
        }

        /* renamed from: c */
        public static void m7377c(ListView listView, int i) {
            AppMethodBeat.m2504i(93294);
            if (listView == null) {
                AppMethodBeat.m2505o(93294);
            } else if (VERSION.SDK_INT >= 11) {
                C5037bi c5037bi = new C5037bi();
                int firstVisiblePosition = listView.getFirstVisiblePosition();
                if (firstVisiblePosition < i && firstVisiblePosition + 10 < i) {
                    listView.setSelectionFromTop(i - 10, 0);
                } else if (firstVisiblePosition > i && firstVisiblePosition - 10 > i) {
                    listView.setSelectionFromTop(i + 10, 0);
                }
                if (VERSION.SDK_INT >= 11) {
                    listView.smoothScrollToPositionFromTop(i, 0);
                }
                AppMethodBeat.m2505o(93294);
            } else {
                C5036bh c5036bh = new C5036bh();
                listView.setSelectionFromTop(i, 0);
                AppMethodBeat.m2505o(93294);
            }
        }
    }

    public static LatLongData amg(String str) {
        AppMethodBeat.m2504i(93295);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(23);
            mediaMetadataRetriever.release();
            C4990ab.m7416i("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong locationString ".concat(String.valueOf(extractMetadata)));
            if (TextUtils.isEmpty(extractMetadata)) {
                AppMethodBeat.m2505o(93295);
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
            latLongData.cEB = C5046bo.ann(extractMetadata.substring(0, lastIndexOf));
            latLongData.fFz = C5046bo.ann(extractMetadata.substring(lastIndexOf));
            AppMethodBeat.m2505o(93295);
            return latLongData;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + e.getMessage());
            AppMethodBeat.m2505o(93295);
            return null;
        }
    }

    public static String amh(String str) {
        AppMethodBeat.m2504i(93296);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(5);
            mediaMetadataRetriever.release();
            C4990ab.m7416i("MicroMsg.SDK.BackwardSupportUtil", "getVideoTakeTime timeString ".concat(String.valueOf(extractMetadata)));
            AppMethodBeat.m2505o(93296);
            return extractMetadata;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + e.getMessage());
            AppMethodBeat.m2505o(93296);
            return null;
        }
    }
}
