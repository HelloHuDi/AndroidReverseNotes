package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class h {
    private ContentResolver ghb = this.mContext.getContentResolver();
    protected Context mContext;

    public interface a {
        int getYFromBottom();
    }

    protected h(Context context) {
        AppMethodBeat.i(27948);
        this.mContext = context;
        AppMethodBeat.o(27948);
    }

    private String ajJ(String str) {
        AppMethodBeat.i(27949);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
            AppMethodBeat.o(27949);
            return null;
        }
        try {
            Cursor query = this.ghb.query(Thumbnails.EXTERNAL_CONTENT_URI, null, "image_id=\"" + str + "\"", null, null);
            if (query == null) {
                ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:".concat(String.valueOf(str)));
                AppMethodBeat.o(27949);
                return null;
            }
            String string;
            if (query.moveToFirst()) {
                do {
                    string = query.getString(query.getColumnIndexOrThrow("_data"));
                } while (query.moveToNext());
            } else {
                string = null;
            }
            query.close();
            AppMethodBeat.o(27949);
            return string;
        } catch (Exception e) {
            ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", e.toString());
            AppMethodBeat.o(27949);
            return null;
        }
    }

    public final ArrayList<g> dkI() {
        AppMethodBeat.i(27950);
        ArrayList<g> arrayList = new ArrayList();
        String str = "date_added desc limit 1";
        String[] strArr = new String[]{"_id", "_data", "date_added"};
        bo.anU();
        try {
            Cursor query = this.ghb.query(Media.EXTERNAL_CONTENT_URI, strArr, null, null, str);
            if (query == null) {
                AppMethodBeat.o(27950);
                return arrayList;
            }
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                    String string3 = query.getString(query.getColumnIndexOrThrow("date_added"));
                    String ajJ = ajJ(string);
                    if (bo.isNullOrNil(string2) || !e.ct(string2)) {
                        ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
                    } else if (string2.startsWith(com.tencent.mm.compatible.util.e.euR)) {
                        ab.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
                    } else {
                        g gVar = new g();
                        gVar.voo = bo.getLong(string, 0);
                        gVar.voq = bo.getLong(string3, 0);
                        if (!bo.isNullOrNil(ajJ) && e.ct(ajJ)) {
                            gVar.thumbPath = ajJ;
                        }
                        if (!bo.isNullOrNil(string2) && e.ct(string2)) {
                            gVar.vop = string2;
                        }
                        if (bo.isNullOrNil(gVar.vop) && bo.isNullOrNil(gVar.vop)) {
                            ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
                        } else {
                            arrayList.add(gVar);
                        }
                    }
                } while (query.moveToNext());
            }
            query.close();
            AppMethodBeat.o(27950);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", e.toString());
            AppMethodBeat.o(27950);
            return null;
        }
    }
}
