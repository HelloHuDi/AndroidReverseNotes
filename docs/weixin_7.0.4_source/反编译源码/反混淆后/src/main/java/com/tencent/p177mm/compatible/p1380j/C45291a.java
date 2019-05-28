package com.tencent.p177mm.compatible.p1380j;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.Closeable;

/* renamed from: com.tencent.mm.compatible.j.a */
public final class C45291a {

    /* renamed from: com.tencent.mm.compatible.j.a$a */
    public static class C41941a {
        public Bitmap bitmap = null;
        public int duration = 0;
        public String filename = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(5)
    /* renamed from: i */
    public static String m83514i(Context context, Intent intent) {
        AppMethodBeat.m2504i(93113);
        if (intent == null || intent.getData() == null) {
            C4990ab.m7412e("MicroMsg.GetVideoMetadata", "input invalid");
            AppMethodBeat.m2505o(93113);
            return null;
        }
        long yz = C5046bo.m7588yz();
        String dataString = intent.getDataString();
        C4990ab.m7416i("MicroMsg.GetVideoMetadata", "get video file name, dataString ".concat(String.valueOf(dataString)));
        if (dataString == null) {
            C4990ab.m7412e("MicroMsg.GetVideoMetadata", "dataString empty");
            AppMethodBeat.m2505o(93113);
            return null;
        }
        String str;
        Cursor cursor;
        ContentResolver contentResolver = context.getContentResolver();
        if (dataString.startsWith(Media.EXTERNAL_CONTENT_URI.toString())) {
            Cursor query = contentResolver.query(intent.getData(), null, null, null, null);
            str = null;
            cursor = query;
        } else {
            String h;
            if (dataString.startsWith("content://")) {
                h = C5046bo.m7568h(context, intent.getData());
            } else if (dataString.startsWith("file://")) {
                if (intent.getExtras() != null) {
                    Uri uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM");
                    if (!(uri == null || C5046bo.isNullOrNil(uri.getPath()))) {
                        h = uri.getPath();
                        if (h == null) {
                            h = dataString.substring(7);
                        }
                    }
                }
                h = null;
                if (h == null) {
                }
            } else {
                h = null;
            }
            if (h != null) {
                r6 = h.startsWith("/storage/emulated/legacy") ? C1448h.getExternalStorageDirectory().getAbsolutePath() + h.substring(24) : h.startsWith("/sdcard") ? C1448h.getExternalStorageDirectory().getAbsolutePath() + h.substring(7) : h;
                Cursor query2 = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, "_data LIKE " + DatabaseUtils.sqlEscapeString(r6), null, null);
                str = r6;
                cursor = query2;
            } else {
                str = h;
                cursor = null;
            }
        }
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                if (str == null) {
                    str = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                }
            }
            cursor.close();
        }
        C4990ab.m7416i("MicroMsg.GetVideoMetadata", "get video filename:" + str + ", cost time: " + C5046bo.m7525az(yz));
        if (TextUtils.isEmpty(str) || !new C5728b(str).exists()) {
            String e = C45291a.m83513e(context, intent.getData());
            AppMethodBeat.m2505o(93113);
            return e;
        }
        AppMethodBeat.m2505o(93113);
        return str;
    }

    @TargetApi(5)
    /* renamed from: j */
    public static C41941a m83515j(Context context, Intent intent) {
        AppMethodBeat.m2504i(93114);
        if (intent == null || intent.getData() == null) {
            C4990ab.m7412e("MicroMsg.GetVideoMetadata", "input invalid");
            AppMethodBeat.m2505o(93114);
            return null;
        }
        long yz = C5046bo.m7588yz();
        String dataString = intent.getDataString();
        C4990ab.m7416i("MicroMsg.GetVideoMetadata", "dataString ".concat(String.valueOf(dataString)));
        if (dataString == null) {
            C4990ab.m7412e("MicroMsg.GetVideoMetadata", "dataString empty");
            AppMethodBeat.m2505o(93114);
            return null;
        }
        Cursor query;
        ContentResolver contentResolver = context.getContentResolver();
        C41941a c41941a = new C41941a();
        if (dataString.startsWith(Media.EXTERNAL_CONTENT_URI.toString())) {
            query = contentResolver.query(intent.getData(), null, null, null, null);
        } else {
            if (dataString.startsWith("content://")) {
                c41941a.filename = C5046bo.m7568h(context, intent.getData());
            } else if (dataString.startsWith("file://")) {
                if (intent.getExtras() != null) {
                    Uri uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM");
                    if (!(uri == null || C5046bo.isNullOrNil(uri.getPath()))) {
                        c41941a.filename = uri.getPath();
                    }
                }
                if (c41941a.filename == null) {
                    c41941a.filename = dataString.substring(7);
                }
            }
            if (c41941a.filename != null) {
                if (c41941a.filename.startsWith("/storage/emulated/legacy")) {
                    c41941a.filename = C1448h.getExternalStorageDirectory().getAbsolutePath() + c41941a.filename.substring(24);
                } else if (c41941a.filename.startsWith("/sdcard")) {
                    c41941a.filename = C1448h.getExternalStorageDirectory().getAbsolutePath() + c41941a.filename.substring(7);
                }
                query = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, "_data LIKE " + DatabaseUtils.sqlEscapeString(c41941a.filename), null, null);
            } else {
                query = null;
            }
        }
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                i = query.getInt(query.getColumnIndexOrThrow("_id"));
                if (c41941a.filename == null) {
                    c41941a.filename = query.getString(query.getColumnIndexOrThrow("_data"));
                }
                c41941a.duration = query.getInt(query.getColumnIndexOrThrow(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
                if (c41941a.duration == 0) {
                    MediaPlayer mediaPlayer = null;
                    try {
                        C4990ab.m7416i("MicroMsg.GetVideoMetadata", "get video duration through MediaPlayer");
                        C45289k d = C45289k.m83508d(context, Uri.parse(c41941a.filename));
                        c41941a.duration = d != null ? d.getDuration() : 0;
                        if (d != null) {
                            d.release();
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.GetVideoMetadata", e, "get duration error, %s", c41941a.filename);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    } catch (Throwable th) {
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        AppMethodBeat.m2505o(93114);
                    }
                }
                c41941a.bitmap = null;
            }
            query.close();
        }
        if (i != BaseClientBuilder.API_PRIORITY_OTHER) {
            try {
                c41941a.bitmap = Thumbnails.getThumbnail(contentResolver, (long) i, 1, null);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.GetVideoMetadata", e2, "", new Object[0]);
                c41941a.bitmap = null;
            }
        }
        if (!C5046bo.isNullOrNil(c41941a.filename) && c41941a.bitmap == null) {
            C4990ab.m7416i("MicroMsg.GetVideoMetadata", "createVideoThumbnail manual");
            c41941a.bitmap = ThumbnailUtils.createVideoThumbnail(c41941a.filename, 1);
            if (c41941a.bitmap == null) {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + c41941a.bitmap)));
            }
        }
        C4990ab.m7417i("MicroMsg.GetVideoMetadata", "get video meta data cost time: %d meta[%s, %d]", Long.valueOf(C5046bo.m7525az(yz)), c41941a.filename, Integer.valueOf(c41941a.duration));
        if (c41941a.filename != null) {
            AppMethodBeat.m2505o(93114);
            return c41941a;
        }
        AppMethodBeat.m2505o(93114);
        return null;
    }

    /* renamed from: e */
    private static String m83513e(Context context, Uri uri) {
        Throwable e;
        AppMethodBeat.m2504i(93115);
        if (uri == null) {
            AppMethodBeat.m2505o(93115);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        String type = contentResolver.getType(uri);
        C4990ab.m7416i("MicroMsg.GetVideoMetadata", "copyFileFromUri typeStr:".concat(String.valueOf(type)));
        if (TextUtils.isEmpty(type)) {
            AppMethodBeat.m2505o(93115);
            return null;
        }
        String[] split = type.split("/");
        String replaceAll = uri.getHost().replaceAll("\\.", "_");
        String replaceAll2 = uri.getPath().replaceAll("/", "_");
        String str = "." + split[1];
        type = "share_file_" + replaceAll + "_" + split[0] + "_" + replaceAll2;
        if (!type.endsWith(str)) {
            type = type + str;
        }
        C4990ab.m7416i("MicroMsg.GetVideoMetadata", "copyFileFromUri path:".concat(String.valueOf(type)));
        C5728b c5728b = new C5728b(C6457e.evs, type);
        if (!c5728b.dMC().exists()) {
            c5728b.dMC().mkdirs();
        }
        if (c5728b.exists()) {
            c5728b.delete();
        }
        Closeable q;
        Closeable openInputStream;
        try {
            c5728b.createNewFile();
            q = C5730e.m8641q(c5728b);
            try {
                openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    C5046bo.m7527b(openInputStream);
                    C5046bo.m7527b(q);
                    AppMethodBeat.m2505o(93115);
                    return null;
                }
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read > 0) {
                            q.write(bArr, 0, read);
                        } else {
                            type = C5736j.m8649w(c5728b.dMD());
                            C5046bo.m7527b(openInputStream);
                            C5046bo.m7527b(q);
                            AppMethodBeat.m2505o(93115);
                            return type;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.GetVideoMetadata", e, "copy fail", new Object[0]);
                        C5046bo.m7527b(openInputStream);
                        C5046bo.m7527b(q);
                        AppMethodBeat.m2505o(93115);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        C5046bo.m7527b(openInputStream);
                        C5046bo.m7527b(q);
                        AppMethodBeat.m2505o(93115);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                openInputStream = null;
            } catch (Throwable th2) {
                e = th2;
                openInputStream = null;
                C5046bo.m7527b(openInputStream);
                C5046bo.m7527b(q);
                AppMethodBeat.m2505o(93115);
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            openInputStream = null;
            q = null;
        } catch (Throwable th3) {
            e = th3;
            openInputStream = null;
            q = null;
            C5046bo.m7527b(openInputStream);
            C5046bo.m7527b(q);
            AppMethodBeat.m2505o(93115);
            throw e;
        }
    }
}
