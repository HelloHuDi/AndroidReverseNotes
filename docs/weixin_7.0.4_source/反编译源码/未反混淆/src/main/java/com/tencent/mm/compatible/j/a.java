package com.tencent.mm.compatible.j;

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
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.Closeable;

public final class a {

    public static class a {
        public Bitmap bitmap = null;
        public int duration = 0;
        public String filename = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(5)
    public static String i(Context context, Intent intent) {
        AppMethodBeat.i(93113);
        if (intent == null || intent.getData() == null) {
            ab.e("MicroMsg.GetVideoMetadata", "input invalid");
            AppMethodBeat.o(93113);
            return null;
        }
        long yz = bo.yz();
        String dataString = intent.getDataString();
        ab.i("MicroMsg.GetVideoMetadata", "get video file name, dataString ".concat(String.valueOf(dataString)));
        if (dataString == null) {
            ab.e("MicroMsg.GetVideoMetadata", "dataString empty");
            AppMethodBeat.o(93113);
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
                h = bo.h(context, intent.getData());
            } else if (dataString.startsWith("file://")) {
                if (intent.getExtras() != null) {
                    Uri uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM");
                    if (!(uri == null || bo.isNullOrNil(uri.getPath()))) {
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
                r6 = h.startsWith("/storage/emulated/legacy") ? h.getExternalStorageDirectory().getAbsolutePath() + h.substring(24) : h.startsWith("/sdcard") ? h.getExternalStorageDirectory().getAbsolutePath() + h.substring(7) : h;
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
        ab.i("MicroMsg.GetVideoMetadata", "get video filename:" + str + ", cost time: " + bo.az(yz));
        if (TextUtils.isEmpty(str) || !new b(str).exists()) {
            String e = e(context, intent.getData());
            AppMethodBeat.o(93113);
            return e;
        }
        AppMethodBeat.o(93113);
        return str;
    }

    @TargetApi(5)
    public static a j(Context context, Intent intent) {
        AppMethodBeat.i(93114);
        if (intent == null || intent.getData() == null) {
            ab.e("MicroMsg.GetVideoMetadata", "input invalid");
            AppMethodBeat.o(93114);
            return null;
        }
        long yz = bo.yz();
        String dataString = intent.getDataString();
        ab.i("MicroMsg.GetVideoMetadata", "dataString ".concat(String.valueOf(dataString)));
        if (dataString == null) {
            ab.e("MicroMsg.GetVideoMetadata", "dataString empty");
            AppMethodBeat.o(93114);
            return null;
        }
        Cursor query;
        ContentResolver contentResolver = context.getContentResolver();
        a aVar = new a();
        if (dataString.startsWith(Media.EXTERNAL_CONTENT_URI.toString())) {
            query = contentResolver.query(intent.getData(), null, null, null, null);
        } else {
            if (dataString.startsWith("content://")) {
                aVar.filename = bo.h(context, intent.getData());
            } else if (dataString.startsWith("file://")) {
                if (intent.getExtras() != null) {
                    Uri uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM");
                    if (!(uri == null || bo.isNullOrNil(uri.getPath()))) {
                        aVar.filename = uri.getPath();
                    }
                }
                if (aVar.filename == null) {
                    aVar.filename = dataString.substring(7);
                }
            }
            if (aVar.filename != null) {
                if (aVar.filename.startsWith("/storage/emulated/legacy")) {
                    aVar.filename = h.getExternalStorageDirectory().getAbsolutePath() + aVar.filename.substring(24);
                } else if (aVar.filename.startsWith("/sdcard")) {
                    aVar.filename = h.getExternalStorageDirectory().getAbsolutePath() + aVar.filename.substring(7);
                }
                query = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, "_data LIKE " + DatabaseUtils.sqlEscapeString(aVar.filename), null, null);
            } else {
                query = null;
            }
        }
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                i = query.getInt(query.getColumnIndexOrThrow("_id"));
                if (aVar.filename == null) {
                    aVar.filename = query.getString(query.getColumnIndexOrThrow("_data"));
                }
                aVar.duration = query.getInt(query.getColumnIndexOrThrow(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
                if (aVar.duration == 0) {
                    MediaPlayer mediaPlayer = null;
                    try {
                        ab.i("MicroMsg.GetVideoMetadata", "get video duration through MediaPlayer");
                        k d = k.d(context, Uri.parse(aVar.filename));
                        aVar.duration = d != null ? d.getDuration() : 0;
                        if (d != null) {
                            d.release();
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.GetVideoMetadata", e, "get duration error, %s", aVar.filename);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    } catch (Throwable th) {
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        AppMethodBeat.o(93114);
                    }
                }
                aVar.bitmap = null;
            }
            query.close();
        }
        if (i != BaseClientBuilder.API_PRIORITY_OTHER) {
            try {
                aVar.bitmap = Thumbnails.getThumbnail(contentResolver, (long) i, 1, null);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.GetVideoMetadata", e2, "", new Object[0]);
                aVar.bitmap = null;
            }
        }
        if (!bo.isNullOrNil(aVar.filename) && aVar.bitmap == null) {
            ab.i("MicroMsg.GetVideoMetadata", "createVideoThumbnail manual");
            aVar.bitmap = ThumbnailUtils.createVideoThumbnail(aVar.filename, 1);
            if (aVar.bitmap == null) {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + aVar.bitmap)));
            }
        }
        ab.i("MicroMsg.GetVideoMetadata", "get video meta data cost time: %d meta[%s, %d]", Long.valueOf(bo.az(yz)), aVar.filename, Integer.valueOf(aVar.duration));
        if (aVar.filename != null) {
            AppMethodBeat.o(93114);
            return aVar;
        }
        AppMethodBeat.o(93114);
        return null;
    }

    private static String e(Context context, Uri uri) {
        Throwable e;
        AppMethodBeat.i(93115);
        if (uri == null) {
            AppMethodBeat.o(93115);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        String type = contentResolver.getType(uri);
        ab.i("MicroMsg.GetVideoMetadata", "copyFileFromUri typeStr:".concat(String.valueOf(type)));
        if (TextUtils.isEmpty(type)) {
            AppMethodBeat.o(93115);
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
        ab.i("MicroMsg.GetVideoMetadata", "copyFileFromUri path:".concat(String.valueOf(type)));
        b bVar = new b(e.evs, type);
        if (!bVar.dMC().exists()) {
            bVar.dMC().mkdirs();
        }
        if (bVar.exists()) {
            bVar.delete();
        }
        Closeable q;
        Closeable openInputStream;
        try {
            bVar.createNewFile();
            q = com.tencent.mm.vfs.e.q(bVar);
            try {
                openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    bo.b(openInputStream);
                    bo.b(q);
                    AppMethodBeat.o(93115);
                    return null;
                }
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read > 0) {
                            q.write(bArr, 0, read);
                        } else {
                            type = j.w(bVar.dMD());
                            bo.b(openInputStream);
                            bo.b(q);
                            AppMethodBeat.o(93115);
                            return type;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.GetVideoMetadata", e, "copy fail", new Object[0]);
                        bo.b(openInputStream);
                        bo.b(q);
                        AppMethodBeat.o(93115);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        bo.b(openInputStream);
                        bo.b(q);
                        AppMethodBeat.o(93115);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                openInputStream = null;
            } catch (Throwable th2) {
                e = th2;
                openInputStream = null;
                bo.b(openInputStream);
                bo.b(q);
                AppMethodBeat.o(93115);
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
            bo.b(openInputStream);
            bo.b(q);
            AppMethodBeat.o(93115);
            throw e;
        }
    }
}
