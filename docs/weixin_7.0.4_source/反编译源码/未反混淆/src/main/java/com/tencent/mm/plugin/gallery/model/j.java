package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class j extends b {
    protected ContentResolver bpL = ah.getContext().getContentResolver();
    private volatile boolean eVT = false;

    public j() {
        AppMethodBeat.i(21303);
        AppMethodBeat.o(21303);
    }

    public final String[] getProjection() {
        return new String[]{"_id", "_data", b.mNt, b.mNs, "mime_type", "latitude", "longitude"};
    }

    public final String aP(String str, boolean z) {
        String str2;
        AppMethodBeat.i(21304);
        StringBuilder append = new StringBuilder("bucket_display_name=\"").append(str).append("\" AND ");
        if (z) {
            str2 = "(" + b.mNs + ">2147483647 OR " + b.mNs + "<=0 )";
        } else {
            str2 = b.mNs + "<=2147483647 AND " + b.mNs + ">0";
        }
        str2 = append.append(str2).toString();
        AppMethodBeat.o(21304);
        return str2;
    }

    public final String a(String[] strArr, boolean z) {
        String str;
        AppMethodBeat.i(21305);
        String str2;
        if (z) {
            str2 = "(" + b.mNs + ">2147483647 OR " + b.mNs + "<=0 ) AND (_size>10240";
            for (String str3 : strArr) {
                str2 = str2 + " or lower(_data) like '%" + str3 + "%'";
            }
            str = str2 + ")";
        } else {
            str2 = b.mNs + "<=2147483647 AND " + b.mNs + ">0 AND (_size>10240";
            for (String str32 : strArr) {
                str2 = str2 + " or lower(_data) like '%" + str32 + "%'";
            }
            str = str2 + ")";
        }
        ab.d("MicroMsg.ImageMediaQuery", "where %s", str);
        AppMethodBeat.o(21305);
        return str;
    }

    public final String hB(boolean z) {
        AppMethodBeat.i(21306);
        String str;
        if (z) {
            str = b.mNt + " desc, _id desc";
            AppMethodBeat.o(21306);
            return str;
        }
        str = b.mNs + " desc, _id desc";
        AppMethodBeat.o(21306);
        return str;
    }

    public final String[] bBU() {
        AppMethodBeat.i(21307);
        String[] strArr = new String[]{"_id", "_data", "bucket_display_name", "count(*)", b.mNt, b.mNs, "mime_type", "max(" + b.mNs + ") as max_time"};
        AppMethodBeat.o(21307);
        return strArr;
    }

    public final LinkedList<AlbumItem> bBS() {
        Cursor query;
        AppMethodBeat.i(21308);
        LinkedList<AlbumItem> linkedList = new LinkedList();
        try {
            query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, bBU(), "0==0) GROUP BY (bucket_display_name", null, "max_time desc, _id desc");
        } catch (Exception e) {
            ab.e("MicroMsg.ImageMediaQuery", "query album list failed : [%s]", e.getMessage());
            query = null;
        }
        if (query == null) {
            ab.d("MicroMsg.ImageMediaQuery", "no media folder now");
            AppMethodBeat.o(21308);
            return linkedList;
        }
        if (query.moveToFirst()) {
            do {
                Long valueOf = Long.valueOf(bo.anl(query.getString(query.getColumnIndexOrThrow("_id"))));
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                String string2 = query.getString(query.getColumnIndexOrThrow("bucket_display_name"));
                bo.isNullOrNil(string2);
                if (!bo.isNullOrNil(string) && e.ct(string)) {
                    int i = query.getInt(3);
                    if (i == 0) {
                        ab.e("MicroMsg.ImageMediaQuery", "query album failed, " + i + ", " + string);
                    } else {
                        ab.i("MicroMsg.ImageMediaQuery", "%s(%s) path:%s", string2, Integer.valueOf(i), string);
                        String string3 = query.getString(query.getColumnIndexOrThrow("mime_type"));
                        MediaItem a = MediaItem.a(1, valueOf.longValue(), string, null, string3);
                        AlbumItem albumItem = new AlbumItem(string2, i);
                        albumItem.oqq = a;
                        linkedList.add(albumItem);
                    }
                }
            } while (query.moveToNext());
        }
        query.close();
        AppMethodBeat.o(21308);
        return linkedList;
    }

    public final LinkedList<MediaItem> a(String str, int i, d dVar, long j) {
        Cursor query;
        Cursor cursor;
        AppMethodBeat.i(21309);
        this.eVT = false;
        LinkedList<MediaItem> linkedList = new LinkedList();
        Cursor query2;
        if (bo.isNullOrNil(str)) {
            query2 = this.bpL.query(Media.EXTERNAL_CONTENT_URI, getProjection(), a(this.mNr, false), null, hB(false));
            query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, getProjection(), a(this.mNr, true), null, hB(true));
            cursor = query2;
        } else {
            query2 = this.bpL.query(Media.EXTERNAL_CONTENT_URI, getProjection(), aP(str, false), null, hB(false));
            query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, getProjection(), aP(str, true), null, hB(true));
            cursor = query2;
        }
        if (cursor != null) {
            cursor.moveToFirst();
        }
        if (query != null) {
            query.moveToFirst();
        }
        MediaItem b = b.b(cursor, 1);
        MediaItem b2 = b.b(query, 1);
        MediaItem mediaItem = null;
        while (b2 != null && b != null) {
            if (b2.mOl > b.mOl) {
                linkedList.add(b2);
                query.moveToNext();
                mediaItem = b;
            } else if (b2.mOl < b.mOl) {
                linkedList.add(b);
                cursor.moveToNext();
                mediaItem = b2;
            } else {
                linkedList.add(b);
                linkedList.add(b2);
                mediaItem = null;
                query.moveToNext();
                cursor.moveToNext();
            }
            if (mediaItem == b2) {
                b = b.b(cursor, 1);
            }
            if (mediaItem == b) {
                b2 = b.b(query, 1);
            }
            if (a(dVar, linkedList, j)) {
                AppMethodBeat.o(21309);
                return linkedList;
            }
        }
        MediaItem mediaItem2 = b2;
        while (mediaItem2 != null) {
            if (mediaItem == null || mediaItem.mOl <= mediaItem2.mOl) {
                linkedList.add(mediaItem2);
                b2 = mediaItem;
            } else {
                linkedList.add(mediaItem);
                linkedList.add(mediaItem2);
                b2 = null;
            }
            query.moveToNext();
            mediaItem2 = b.b(query, 1);
            if (a(dVar, linkedList, j)) {
                AppMethodBeat.o(21309);
                return linkedList;
            }
            mediaItem = b2;
        }
        b2 = mediaItem;
        while (b != null) {
            if (b2 == null || b2.mOl <= b.mOl) {
                linkedList.add(b);
            } else {
                linkedList.add(b2);
                linkedList.add(b);
                b2 = null;
            }
            cursor.moveToNext();
            mediaItem = b.b(cursor, 1);
            if (a(dVar, linkedList, j)) {
                AppMethodBeat.o(21309);
                return linkedList;
            }
            b = mediaItem;
        }
        if (b2 != null) {
            linkedList.add(b2);
        }
        dVar.c(linkedList, j);
        ab.i("MicroMsg.ImageMediaQuery", "[queryMediaItemsInAlbum] albumName:%s type:%s result:%s ticket:%s", str, Integer.valueOf(i), Integer.valueOf(linkedList.size()), Long.valueOf(j));
        AppMethodBeat.o(21309);
        return linkedList;
    }

    private boolean a(d dVar, LinkedList linkedList, long j) {
        AppMethodBeat.i(21310);
        if (dVar != null && linkedList.size() + (1 % this.mNq) == 0) {
            dVar.c(linkedList, j);
        }
        boolean z = this.eVT;
        AppMethodBeat.o(21310);
        return z;
    }

    public final void bBT() {
        this.eVT = true;
    }
}
