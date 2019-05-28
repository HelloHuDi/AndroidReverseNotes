package com.tencent.p177mm.p612ui.tools;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.ui.tools.a */
public final class C36338a {

    /* renamed from: com.tencent.mm.ui.tools.a$a */
    public interface C15946a {
        /* renamed from: ZB */
        String mo25777ZB(String str);
    }

    /* renamed from: com.tencent.mm.ui.tools.a$1 */
    public static class C363371 extends AsyncTask<Integer, Integer, Integer> {
        private String filePath;
        private Uri uri;
        final /* synthetic */ Intent val$data;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ int val$requestCode;
        private boolean zAA;
        final /* synthetic */ MMFragment zAB;
        final /* synthetic */ String zAC;
        final /* synthetic */ C15946a zAD = null;
        private ProgressDialog zAz;

        /* renamed from: com.tencent.mm.ui.tools.a$1$1 */
        class C240451 implements OnCancelListener {
            C240451() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(107586);
                C363371.this.zAA = true;
                AppMethodBeat.m2505o(107586);
            }
        }

        public C363371(Intent intent, MMFragment mMFragment, String str, Intent intent2) {
            this.val$data = intent;
            this.zAB = mMFragment;
            this.zAC = str;
            this.val$intent = intent2;
            this.val$requestCode = 203;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(107590);
            Integer dJy = dJy();
            AppMethodBeat.m2505o(107590);
            return dJy;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.m2504i(107587);
            try {
                this.uri = this.val$data.getData();
                this.zAA = false;
                Context context = this.zAB.getContext();
                this.zAB.getString(C25738R.string.f9238tz);
                this.zAz = C30379h.m48458b(context, this.zAB.getString(C25738R.string.f9149r0), true, new C240451());
                AppMethodBeat.m2505o(107587);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
                AppMethodBeat.m2505o(107587);
            }
        }

        private Integer dJy() {
            AppMethodBeat.m2504i(107588);
            try {
                if (this.uri == null) {
                    AppMethodBeat.m2505o(107588);
                    return null;
                }
                this.filePath = C36338a.m59825v(this.zAC, C5056d.m7667u(this.uri));
                AppMethodBeat.m2505o(107588);
                return null;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
            }
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(107589);
            if (!(this.zAA || C5046bo.isNullOrNil(this.filePath))) {
                if (this.zAD != null) {
                    this.val$intent.putExtra("CropImage_OutputPath", this.zAD.mo25777ZB(this.filePath));
                }
                this.val$intent.putExtra("CropImage_ImgPath", this.filePath);
                this.zAB.startActivityForResult(this.val$intent, this.val$requestCode);
            }
            this.zAz.dismiss();
            AppMethodBeat.m2505o(107589);
        }
    }

    /* renamed from: a */
    public static void m59822a(Activity activity, Intent intent, Intent intent2, String str, int i) {
        AppMethodBeat.m2504i(107596);
        C36338a.m59823b(activity, intent, intent2, str, i, null);
        AppMethodBeat.m2505o(107596);
    }

    /* renamed from: b */
    public static void m59823b(Activity activity, Intent intent, Intent intent2, String str, int i, C15946a c15946a) {
        AppMethodBeat.m2504i(107597);
        if (intent == null || intent.getData() == null) {
            String str2 = "MicroMsg.AsyncObtainImage";
            String str3 = "param error, %b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(intent == null);
            C4990ab.m7413e(str2, str3, objArr);
            AppMethodBeat.m2505o(107597);
        } else if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
            final Intent intent3 = intent;
            final Activity activity2 = activity;
            final String str4 = str;
            final C15946a c15946a2 = c15946a;
            final Intent intent4 = intent2;
            final int i2 = i;
            new AsyncTask<Integer, Integer, Integer>() {
                private String filePath;
                private Uri uri;
                private boolean zAA;
                private ProgressDialog zAz;

                /* renamed from: com.tencent.mm.ui.tools.a$2$1 */
                class C159451 implements OnCancelListener {
                    C159451() {
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(107591);
                        C159442.this.zAA = true;
                        AppMethodBeat.m2505o(107591);
                    }
                }

                /* Access modifiers changed, original: protected|final|synthetic */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    AppMethodBeat.m2504i(107595);
                    Integer dJy = dJy();
                    AppMethodBeat.m2505o(107595);
                    return dJy;
                }

                /* Access modifiers changed, original: protected|final */
                public final void onPreExecute() {
                    AppMethodBeat.m2504i(107592);
                    try {
                        this.uri = intent3.getData();
                        this.zAA = false;
                        Context context = activity2;
                        activity2.getString(C25738R.string.f9238tz);
                        this.zAz = C30379h.m48458b(context, activity2.getString(C25738R.string.f9149r0), true, new C159451());
                        AppMethodBeat.m2505o(107592);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "onPreExecute", new Object[0]);
                        AppMethodBeat.m2505o(107592);
                    }
                }

                private Integer dJy() {
                    AppMethodBeat.m2504i(107593);
                    try {
                        if (this.uri == null) {
                            AppMethodBeat.m2505o(107593);
                            return null;
                        }
                        this.filePath = C36338a.m59825v(str4, C5056d.m7667u(this.uri));
                        AppMethodBeat.m2505o(107593);
                        return null;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "doInBackground", new Object[0]);
                    }
                }

                /* Access modifiers changed, original: protected|final|synthetic */
                public final /* synthetic */ void onPostExecute(Object obj) {
                    AppMethodBeat.m2504i(107594);
                    if (this.zAA || C5046bo.isNullOrNil(this.filePath)) {
                        C4990ab.m7413e("MicroMsg.AsyncObtainImage", "onPostExecute error, filePath:%s", this.filePath);
                    } else {
                        if (c15946a2 != null) {
                            intent4.putExtra("CropImage_OutputPath", c15946a2.mo25777ZB(this.filePath));
                        }
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        activity2.startActivityForResult(intent4, i2);
                    }
                    this.zAz.dismiss();
                    AppMethodBeat.m2505o(107594);
                }
            }.execute(new Integer[]{Integer.valueOf(0)});
            AppMethodBeat.m2505o(107597);
        } else {
            String i3 = C36338a.m59824i(activity, intent, str);
            C4990ab.m7417i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", i3);
            if (!C5046bo.isNullOrNil(i3)) {
                if (c15946a != null) {
                    intent2.putExtra("CropImage_OutputPath", c15946a.mo25777ZB(i3));
                }
                intent2.putExtra("CropImage_ImgPath", i3);
                activity.startActivityForResult(intent2, i);
            }
            AppMethodBeat.m2505o(107597);
        }
    }

    /* renamed from: i */
    public static String m59824i(Context context, Intent intent, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(107598);
        if (context == null || intent == null || str == null) {
            C4990ab.m7412e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
            AppMethodBeat.m2505o(107598);
        } else {
            Uri parse = Uri.parse(intent.toURI());
            Cursor query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null && query.getCount() > 0) {
                C4990ab.m7416i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
                try {
                    if (parse.toString().startsWith("content://com.google.android.gallery3d")) {
                        str2 = C36338a.m59825v(str, C5056d.m7667u(intent.getData()));
                    } else {
                        query.moveToFirst();
                        str2 = query.getString(query.getColumnIndex("_data"));
                        C4990ab.m7416i("MicroMsg.AsyncObtainImage", "photo from resolver, path:".concat(String.valueOf(str2)));
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "resolve photo error.", new Object[0]);
                }
            } else if (intent.getData() != null) {
                String path = intent.getData().getPath();
                if (!(C5046bo.isNullOrNil(path) || new File(path).exists())) {
                    path = null;
                }
                C4990ab.m7416i("MicroMsg.AsyncObtainImage", "photo file from data, path:".concat(String.valueOf(path)));
                if (C5046bo.isNullOrNil(path)) {
                    path = intent.getData().getHost();
                    if (C5046bo.isNullOrNil(path) || new File(path).exists()) {
                        str2 = path;
                    }
                    C4990ab.m7416i("MicroMsg.AsyncObtainImage", "photo file from data, host:".concat(String.valueOf(str2)));
                } else {
                    str2 = path;
                }
            } else if (intent.getAction() == null || !intent.getAction().equals("inline-data")) {
                if (query != null) {
                    query.close();
                }
                C4990ab.m7412e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
                AppMethodBeat.m2505o(107598);
            } else {
                str2 = C36338a.m59825v(str, (Bitmap) intent.getExtras().get("data"));
                C4990ab.m7417i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", str2);
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(107598);
        }
        return str2;
    }

    /* renamed from: v */
    public static String m59825v(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(107599);
        try {
            String str2 = str + (C1178g.m2591x(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + FileUtils.PIC_POSTFIX_JPEG);
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            C4990ab.m7416i("MicroMsg.AsyncObtainImage", "photo image from data, path:".concat(String.valueOf(str2)));
            AppMethodBeat.m2505o(107599);
            return str2;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "saveBmp Error.", new Object[0]);
            AppMethodBeat.m2505o(107599);
            return null;
        }
    }
}
