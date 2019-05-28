package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class a {

    public interface a {
        String ZB(String str);
    }

    /* renamed from: com.tencent.mm.ui.tools.a$1 */
    public static class AnonymousClass1 extends AsyncTask<Integer, Integer, Integer> {
        private String filePath;
        private Uri uri;
        final /* synthetic */ Intent val$data;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ int val$requestCode;
        private boolean zAA;
        final /* synthetic */ MMFragment zAB;
        final /* synthetic */ String zAC;
        final /* synthetic */ a zAD = null;
        private ProgressDialog zAz;

        public AnonymousClass1(Intent intent, MMFragment mMFragment, String str, Intent intent2) {
            this.val$data = intent;
            this.zAB = mMFragment;
            this.zAC = str;
            this.val$intent = intent2;
            this.val$requestCode = 203;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(107590);
            Integer dJy = dJy();
            AppMethodBeat.o(107590);
            return dJy;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.i(107587);
            try {
                this.uri = this.val$data.getData();
                this.zAA = false;
                Context context = this.zAB.getContext();
                this.zAB.getString(R.string.tz);
                this.zAz = h.b(context, this.zAB.getString(R.string.r0), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(107586);
                        AnonymousClass1.this.zAA = true;
                        AppMethodBeat.o(107586);
                    }
                });
                AppMethodBeat.o(107587);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
                AppMethodBeat.o(107587);
            }
        }

        private Integer dJy() {
            AppMethodBeat.i(107588);
            try {
                if (this.uri == null) {
                    AppMethodBeat.o(107588);
                    return null;
                }
                this.filePath = a.v(this.zAC, d.u(this.uri));
                AppMethodBeat.o(107588);
                return null;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
            }
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(107589);
            if (!(this.zAA || bo.isNullOrNil(this.filePath))) {
                if (this.zAD != null) {
                    this.val$intent.putExtra("CropImage_OutputPath", this.zAD.ZB(this.filePath));
                }
                this.val$intent.putExtra("CropImage_ImgPath", this.filePath);
                this.zAB.startActivityForResult(this.val$intent, this.val$requestCode);
            }
            this.zAz.dismiss();
            AppMethodBeat.o(107589);
        }
    }

    public static void a(Activity activity, Intent intent, Intent intent2, String str, int i) {
        AppMethodBeat.i(107596);
        b(activity, intent, intent2, str, i, null);
        AppMethodBeat.o(107596);
    }

    public static void b(Activity activity, Intent intent, Intent intent2, String str, int i, a aVar) {
        AppMethodBeat.i(107597);
        if (intent == null || intent.getData() == null) {
            String str2 = "MicroMsg.AsyncObtainImage";
            String str3 = "param error, %b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(intent == null);
            ab.e(str2, str3, objArr);
            AppMethodBeat.o(107597);
        } else if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
            final Intent intent3 = intent;
            final Activity activity2 = activity;
            final String str4 = str;
            final a aVar2 = aVar;
            final Intent intent4 = intent2;
            final int i2 = i;
            new AsyncTask<Integer, Integer, Integer>() {
                private String filePath;
                private Uri uri;
                private boolean zAA;
                private ProgressDialog zAz;

                /* Access modifiers changed, original: protected|final|synthetic */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    AppMethodBeat.i(107595);
                    Integer dJy = dJy();
                    AppMethodBeat.o(107595);
                    return dJy;
                }

                /* Access modifiers changed, original: protected|final */
                public final void onPreExecute() {
                    AppMethodBeat.i(107592);
                    try {
                        this.uri = intent3.getData();
                        this.zAA = false;
                        Context context = activity2;
                        activity2.getString(R.string.tz);
                        this.zAz = h.b(context, activity2.getString(R.string.r0), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(107591);
                                AnonymousClass2.this.zAA = true;
                                AppMethodBeat.o(107591);
                            }
                        });
                        AppMethodBeat.o(107592);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "onPreExecute", new Object[0]);
                        AppMethodBeat.o(107592);
                    }
                }

                private Integer dJy() {
                    AppMethodBeat.i(107593);
                    try {
                        if (this.uri == null) {
                            AppMethodBeat.o(107593);
                            return null;
                        }
                        this.filePath = a.v(str4, d.u(this.uri));
                        AppMethodBeat.o(107593);
                        return null;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "doInBackground", new Object[0]);
                    }
                }

                /* Access modifiers changed, original: protected|final|synthetic */
                public final /* synthetic */ void onPostExecute(Object obj) {
                    AppMethodBeat.i(107594);
                    if (this.zAA || bo.isNullOrNil(this.filePath)) {
                        ab.e("MicroMsg.AsyncObtainImage", "onPostExecute error, filePath:%s", this.filePath);
                    } else {
                        if (aVar2 != null) {
                            intent4.putExtra("CropImage_OutputPath", aVar2.ZB(this.filePath));
                        }
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        activity2.startActivityForResult(intent4, i2);
                    }
                    this.zAz.dismiss();
                    AppMethodBeat.o(107594);
                }
            }.execute(new Integer[]{Integer.valueOf(0)});
            AppMethodBeat.o(107597);
        } else {
            String i3 = i(activity, intent, str);
            ab.i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", i3);
            if (!bo.isNullOrNil(i3)) {
                if (aVar != null) {
                    intent2.putExtra("CropImage_OutputPath", aVar.ZB(i3));
                }
                intent2.putExtra("CropImage_ImgPath", i3);
                activity.startActivityForResult(intent2, i);
            }
            AppMethodBeat.o(107597);
        }
    }

    public static String i(Context context, Intent intent, String str) {
        String str2 = null;
        AppMethodBeat.i(107598);
        if (context == null || intent == null || str == null) {
            ab.e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
            AppMethodBeat.o(107598);
        } else {
            Uri parse = Uri.parse(intent.toURI());
            Cursor query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null && query.getCount() > 0) {
                ab.i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
                try {
                    if (parse.toString().startsWith("content://com.google.android.gallery3d")) {
                        str2 = v(str, d.u(intent.getData()));
                    } else {
                        query.moveToFirst();
                        str2 = query.getString(query.getColumnIndex("_data"));
                        ab.i("MicroMsg.AsyncObtainImage", "photo from resolver, path:".concat(String.valueOf(str2)));
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "resolve photo error.", new Object[0]);
                }
            } else if (intent.getData() != null) {
                String path = intent.getData().getPath();
                if (!(bo.isNullOrNil(path) || new File(path).exists())) {
                    path = null;
                }
                ab.i("MicroMsg.AsyncObtainImage", "photo file from data, path:".concat(String.valueOf(path)));
                if (bo.isNullOrNil(path)) {
                    path = intent.getData().getHost();
                    if (bo.isNullOrNil(path) || new File(path).exists()) {
                        str2 = path;
                    }
                    ab.i("MicroMsg.AsyncObtainImage", "photo file from data, host:".concat(String.valueOf(str2)));
                } else {
                    str2 = path;
                }
            } else if (intent.getAction() == null || !intent.getAction().equals("inline-data")) {
                if (query != null) {
                    query.close();
                }
                ab.e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
                AppMethodBeat.o(107598);
            } else {
                str2 = v(str, (Bitmap) intent.getExtras().get("data"));
                ab.i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", str2);
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(107598);
        }
        return str2;
    }

    public static String v(String str, Bitmap bitmap) {
        AppMethodBeat.i(107599);
        try {
            String str2 = str + (g.x(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + FileUtils.PIC_POSTFIX_JPEG);
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            ab.i("MicroMsg.AsyncObtainImage", "photo image from data, path:".concat(String.valueOf(str2)));
            AppMethodBeat.o(107599);
            return str2;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "saveBmp Error.", new Object[0]);
            AppMethodBeat.o(107599);
            return null;
        }
    }
}
