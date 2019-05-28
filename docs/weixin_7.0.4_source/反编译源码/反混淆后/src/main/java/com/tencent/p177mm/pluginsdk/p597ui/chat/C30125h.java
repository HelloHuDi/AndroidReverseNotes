package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.h */
final class C30125h {
    private ContentResolver ghb = this.mContext.getContentResolver();
    protected Context mContext;

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.h$a */
    public interface C23290a {
        int getYFromBottom();
    }

    protected C30125h(Context context) {
        AppMethodBeat.m2504i(27948);
        this.mContext = context;
        AppMethodBeat.m2505o(27948);
    }

    private String ajJ(String str) {
        AppMethodBeat.m2504i(27949);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
            AppMethodBeat.m2505o(27949);
            return null;
        }
        try {
            Cursor query = this.ghb.query(Thumbnails.EXTERNAL_CONTENT_URI, null, "image_id=\"" + str + "\"", null, null);
            if (query == null) {
                C4990ab.m7412e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(27949);
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
            AppMethodBeat.m2505o(27949);
            return string;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", e.toString());
            AppMethodBeat.m2505o(27949);
            return null;
        }
    }

    public final ArrayList<C23289g> dkI() {
        AppMethodBeat.m2504i(27950);
        ArrayList<C23289g> arrayList = new ArrayList();
        String str = "date_added desc limit 1";
        String[] strArr = new String[]{"_id", "_data", "date_added"};
        C5046bo.anU();
        try {
            Cursor query = this.ghb.query(Media.EXTERNAL_CONTENT_URI, strArr, null, null, str);
            if (query == null) {
                AppMethodBeat.m2505o(27950);
                return arrayList;
            }
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                    String string3 = query.getString(query.getColumnIndexOrThrow("date_added"));
                    String ajJ = ajJ(string);
                    if (C5046bo.isNullOrNil(string2) || !C1173e.m2561ct(string2)) {
                        C4990ab.m7412e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
                    } else if (string2.startsWith(C6457e.euR)) {
                        C4990ab.m7416i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
                    } else {
                        C23289g c23289g = new C23289g();
                        c23289g.voo = C5046bo.getLong(string, 0);
                        c23289g.voq = C5046bo.getLong(string3, 0);
                        if (!C5046bo.isNullOrNil(ajJ) && C1173e.m2561ct(ajJ)) {
                            c23289g.thumbPath = ajJ;
                        }
                        if (!C5046bo.isNullOrNil(string2) && C1173e.m2561ct(string2)) {
                            c23289g.vop = string2;
                        }
                        if (C5046bo.isNullOrNil(c23289g.vop) && C5046bo.isNullOrNil(c23289g.vop)) {
                            C4990ab.m7412e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
                        } else {
                            arrayList.add(c23289g);
                        }
                    }
                } while (query.moveToNext());
            }
            query.close();
            AppMethodBeat.m2505o(27950);
            return arrayList;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", e.toString());
            AppMethodBeat.m2505o(27950);
            return null;
        }
    }
}
