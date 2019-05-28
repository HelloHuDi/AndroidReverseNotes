package com.tencent.p177mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C28159d;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.gallery.model.n */
public final class C28160n extends C44742b {
    protected ContentResolver bpL = C4996ah.getContext().getContentResolver();
    private volatile boolean eVT = false;

    public C28160n() {
        AppMethodBeat.m2504i(21333);
        AppMethodBeat.m2505o(21333);
    }

    public final String[] getProjection() {
        return new String[]{"_id", "_data", C44742b.mNt, C44742b.mNs, "mime_type", "latitude", "longitude"};
    }

    /* renamed from: aP */
    public final String mo46077aP(String str, boolean z) {
        String str2;
        AppMethodBeat.m2504i(21334);
        StringBuilder append = new StringBuilder("bucket_display_name=\"").append(str).append("\" AND ");
        if (z) {
            str2 = "(" + C44742b.mNs + ">2147483647 OR " + C44742b.mNs + "<=0 )";
        } else {
            str2 = C44742b.mNs + "<=2147483647 AND " + C44742b.mNs + ">0";
        }
        str2 = append.append(str2).toString();
        AppMethodBeat.m2505o(21334);
        return str2;
    }

    /* renamed from: a */
    public final String mo46075a(String[] strArr, boolean z) {
        String str;
        AppMethodBeat.m2504i(21335);
        String str2;
        if (z) {
            str2 = "(" + C44742b.mNs + ">2147483647 OR " + C44742b.mNs + "<=0 ) AND (_size>10240";
            for (String str3 : strArr) {
                str2 = str2 + " or lower(_data) like '%" + str3 + "%'";
            }
            str = str2 + ")";
        } else {
            str2 = C44742b.mNs + "<=2147483647 AND " + C44742b.mNs + ">0 AND (_size>10240";
            for (String str32 : strArr) {
                str2 = str2 + " or lower(_data) like '%" + str32 + "%'";
            }
            str = str2 + ")";
        }
        C4990ab.m7411d("MicroMsg.ImageMediaQuery", "where %s", str);
        AppMethodBeat.m2505o(21335);
        return str;
    }

    /* renamed from: hB */
    public final String mo46082hB(boolean z) {
        AppMethodBeat.m2504i(21336);
        String str;
        if (z) {
            str = C44742b.mNt + " desc, _id desc";
            AppMethodBeat.m2505o(21336);
            return str;
        }
        str = C44742b.mNs + " desc, _id desc";
        AppMethodBeat.m2505o(21336);
        return str;
    }

    public final String[] bBU() {
        AppMethodBeat.m2504i(21337);
        String[] strArr = new String[]{"_id", "_data", "bucket_display_name", "count(*)", C44742b.mNt, C44742b.mNs, "mime_type", "max(" + C44742b.mNs + ") as max_time"};
        AppMethodBeat.m2505o(21337);
        return strArr;
    }

    public final LinkedList<AlbumItem> bBS() {
        Cursor query;
        AppMethodBeat.m2504i(21338);
        LinkedList<AlbumItem> linkedList = new LinkedList();
        try {
            query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, bBU(), "0==0) GROUP BY (bucket_display_name", null, "max_time desc, _id desc");
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ImageMediaQuery", "query album list failed : [%s]", e.getMessage());
            query = null;
        }
        if (query == null) {
            C4990ab.m7410d("MicroMsg.ImageMediaQuery", "no media folder now");
            AppMethodBeat.m2505o(21338);
            return linkedList;
        }
        if (query.moveToFirst()) {
            do {
                Long valueOf = Long.valueOf(C5046bo.anl(query.getString(query.getColumnIndexOrThrow("_id"))));
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                String string2 = query.getString(query.getColumnIndexOrThrow("bucket_display_name"));
                if (C5046bo.isNullOrNil(string2)) {
                    C4990ab.m7412e("MicroMsg.ImageMediaQuery", "null or nill album name, ignore this folder");
                } else if (!C5046bo.isNullOrNil(string) && C1173e.m2561ct(string)) {
                    int i = query.getInt(3);
                    if (i == 0) {
                        C4990ab.m7412e("MicroMsg.ImageMediaQuery", "query album failed, " + i + ", " + string);
                    } else {
                        C4990ab.m7417i("MicroMsg.ImageMediaQuery", "%s(%s) path:%s", string2, Integer.valueOf(i), string);
                        String string3 = query.getString(query.getColumnIndexOrThrow("mime_type"));
                        MediaItem a = MediaItem.m5515a(2, valueOf.longValue(), string, null, string3);
                        AlbumItem albumItem = new AlbumItem(string2, i);
                        albumItem.oqq = a;
                        linkedList.add(albumItem);
                    }
                }
            } while (query.moveToNext());
        }
        query.close();
        AppMethodBeat.m2505o(21338);
        return linkedList;
    }

    /* renamed from: a */
    public final LinkedList<MediaItem> mo46076a(String str, int i, C28159d c28159d, long j) {
        Cursor query;
        Cursor cursor;
        AppMethodBeat.m2504i(21339);
        this.eVT = false;
        LinkedList<MediaItem> linkedList = new LinkedList();
        Cursor query2;
        if (C5046bo.isNullOrNil(str)) {
            query2 = this.bpL.query(Media.EXTERNAL_CONTENT_URI, getProjection(), mo46075a(new String[]{this.mNr[0]}, false), null, mo46082hB(false));
            query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, getProjection(), mo46075a(new String[]{this.mNr[0]}, true), null, mo46082hB(true));
            cursor = query2;
        } else {
            query2 = this.bpL.query(Media.EXTERNAL_CONTENT_URI, getProjection(), mo46077aP(str, false), null, mo46082hB(false));
            query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, getProjection(), mo46077aP(str, true), null, mo46082hB(true));
            cursor = query2;
        }
        if (cursor != null) {
            cursor.moveToFirst();
        }
        if (query != null) {
            query.moveToFirst();
        }
        MediaItem b = C44742b.m81538b(cursor, 2);
        MediaItem b2 = C44742b.m81538b(query, 2);
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
                b = C44742b.m81538b(cursor, 2);
            }
            if (mediaItem == b) {
                b2 = C44742b.m81538b(query, 2);
            }
            if (m44748a(c28159d, linkedList, j)) {
                AppMethodBeat.m2505o(21339);
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
            mediaItem2 = C44742b.m81538b(query, 2);
            if (m44748a(c28159d, linkedList, j)) {
                AppMethodBeat.m2505o(21339);
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
            mediaItem = C44742b.m81538b(cursor, 2);
            if (m44748a(c28159d, linkedList, j)) {
                AppMethodBeat.m2505o(21339);
                return linkedList;
            }
            b = mediaItem;
        }
        if (b2 != null) {
            linkedList.add(b2);
        }
        c28159d.mo46074c(linkedList, j);
        C4990ab.m7417i("MicroMsg.ImageMediaQuery", "[queryMediaItemsInAlbum] albumName:%s type:%s result:%s ticket:%s", str, Integer.valueOf(i), Integer.valueOf(linkedList.size()), Long.valueOf(j));
        AppMethodBeat.m2505o(21339);
        return linkedList;
    }

    /* renamed from: a */
    private boolean m44748a(C28159d c28159d, LinkedList linkedList, long j) {
        AppMethodBeat.m2504i(21340);
        if (c28159d != null && linkedList.size() + (1 % this.mNq) == 0) {
            c28159d.mo46074c(linkedList, j);
        }
        boolean z = this.eVT;
        AppMethodBeat.m2505o(21340);
        return z;
    }

    public final void bBT() {
        this.eVT = true;
    }
}
