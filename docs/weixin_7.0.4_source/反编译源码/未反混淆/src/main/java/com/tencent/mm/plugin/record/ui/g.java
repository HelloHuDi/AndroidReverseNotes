package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public final class g extends l implements a {
    public final void a(a.a aVar) {
        String str = null;
        AppMethodBeat.i(24224);
        ImageView imageView = aVar.cAw;
        aar aar = aVar.cAv;
        long j = aVar.pKv;
        int i = aVar.cAx;
        int i2 = aVar.width;
        int i3 = aVar.height;
        if (imageView == null) {
            AppMethodBeat.o(24224);
        } else if (!f.Mn()) {
            imageView.setImageResource(R.drawable.ak_);
            AppMethodBeat.o(24224);
        } else if (aar == null) {
            imageView.setImageResource(i);
            AppMethodBeat.o(24224);
        } else {
            String str2;
            abe abe;
            switch (aar.dataType) {
                case 4:
                case 15:
                    super.a(imageView, aar, j, aar.cvq, i, i2, i3);
                    AppMethodBeat.o(24224);
                    return;
                case 5:
                    abu abu;
                    if (aar.wgT != null) {
                        abu = aar.wgT.whA;
                    } else {
                        ab.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", aar.mnd);
                        abu = null;
                    }
                    if (abu != null) {
                        str = abu.thumbUrl;
                    }
                    if (bo.isNullOrNil(str)) {
                        str2 = aar.cvq;
                    } else {
                        str2 = str;
                    }
                    super.a(imageView, aar, j, str2, i, i2, i3);
                    AppMethodBeat.o(24224);
                    return;
                case 7:
                    super.a(imageView, aar, j, aar.cvq, i, i2, i3);
                    AppMethodBeat.o(24224);
                    return;
                case 10:
                    if (aar.wgT == null) {
                        ab.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", aar.mnd);
                        AppMethodBeat.o(24224);
                        return;
                    }
                    abe = aar.wgT.whC;
                    if (abe != null) {
                        this.pJN.a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.o(24224);
                        return;
                    }
                    break;
                case 11:
                    if (aar.wgT == null) {
                        ab.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", aar.mnd);
                        AppMethodBeat.o(24224);
                        return;
                    }
                    abe = aar.wgT.whC;
                    if (abe != null) {
                        this.pJN.a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.o(24224);
                        return;
                    }
                    break;
                case 14:
                    if (aar.wgT == null) {
                        ab.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", aar.mnd);
                        AppMethodBeat.o(24224);
                        return;
                    }
                    abo abo = aar.wgT.whE;
                    if (abo != null) {
                        this.pJN.a(imageView, null, abo.thumbUrl, i, i2, i3);
                        AppMethodBeat.o(24224);
                        return;
                    }
                    break;
                case 19:
                    aap aap;
                    if (aar.wgT != null) {
                        aap = aar.wgT.whN;
                    } else {
                        ab.w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", aar.mnd);
                        aap = null;
                    }
                    if (aap != null) {
                        str = aap.iconUrl;
                    }
                    if (bo.isNullOrNil(str)) {
                        str2 = aar.cvq;
                    } else {
                        str2 = str;
                    }
                    super.a(imageView, aar, j, str2, i, i2, i3);
                    AppMethodBeat.o(24224);
                    return;
                default:
                    ab.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", Integer.valueOf(aar.dataType));
                    break;
            }
            AppMethodBeat.o(24224);
        }
    }

    public final Bitmap a(c cVar) {
        AppMethodBeat.i(24225);
        Bitmap b = super.b(cVar.cAv, cVar.pKv);
        AppMethodBeat.o(24225);
        return b;
    }

    public final Bitmap a(b bVar) {
        Bitmap bitmap;
        AppMethodBeat.i(24226);
        aar aar = bVar.cAv;
        long j = bVar.pKv;
        boolean z = bVar.cAy;
        int i = bVar.maxWidth;
        if (f.Mn()) {
            String c = n.c(aar, j);
            if (bo.isNullOrNil(c) || !e.ct(c)) {
                ab.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", Boolean.FALSE, c);
                bitmap = null;
            } else {
                bitmap = (Bitmap) this.mkq.get(c);
                if (bitmap != null) {
                    ab.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", c);
                } else if (z) {
                    bitmap = null;
                } else {
                    int i2;
                    ab.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", c);
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(c, options);
                    if (bitmap != null) {
                        ab.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", bitmap);
                        bitmap.recycle();
                    }
                    int i3 = options.outHeight;
                    int i4 = options.outWidth;
                    ab.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", Integer.valueOf(i4), Integer.valueOf(i3));
                    if (i4 > i) {
                        i3 = (options.outHeight * i) / options.outWidth;
                        i4 = i;
                    }
                    i4 = Math.max(1, i4);
                    i3 = Math.max(1, i3);
                    if (i4 > i) {
                        i3 = (options.outHeight * i) / options.outWidth;
                    } else {
                        i = i4;
                    }
                    int bJ = ExifHelper.bJ(c);
                    if (bJ == 90 || bJ == 270) {
                        i4 = i;
                        i2 = i3;
                    } else {
                        i4 = i3;
                        i2 = i;
                    }
                    bitmap = d.d(c, i4, i2, false);
                    if (bitmap == null) {
                        ab.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(c)));
                        bitmap = null;
                    } else {
                        bitmap = d.b(bitmap, (float) bJ);
                        this.mkq.put(c, bitmap);
                    }
                }
            }
        } else {
            bitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
        }
        if (bitmap == null && !z) {
            ab.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", Boolean.valueOf(super.a(aar, j)));
            n.b(aar, j, r1);
        }
        AppMethodBeat.o(24226);
        return bitmap;
    }

    public final void ceH() {
        AppMethodBeat.i(24227);
        super.destory();
        AppMethodBeat.o(24227);
    }
}
