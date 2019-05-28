package com.tencent.p177mm.plugin.record.p493ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.record.p492b.C43434l;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3710b;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3711c;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3712a;
import com.tencent.p177mm.protocal.protobuf.aap;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.record.ui.g */
public final class C36803g extends C43434l implements C3709a {
    /* renamed from: a */
    public final void mo8342a(C3712a c3712a) {
        String str = null;
        AppMethodBeat.m2504i(24224);
        ImageView imageView = c3712a.cAw;
        aar aar = c3712a.cAv;
        long j = c3712a.pKv;
        int i = c3712a.cAx;
        int i2 = c3712a.width;
        int i3 = c3712a.height;
        if (imageView == null) {
            AppMethodBeat.m2505o(24224);
        } else if (!C1445f.m3070Mn()) {
            imageView.setImageResource(C25738R.drawable.ak_);
            AppMethodBeat.m2505o(24224);
        } else if (aar == null) {
            imageView.setImageResource(i);
            AppMethodBeat.m2505o(24224);
        } else {
            String str2;
            abe abe;
            switch (aar.dataType) {
                case 4:
                case 15:
                    super.mo68991a(imageView, aar, j, aar.cvq, i, i2, i3);
                    AppMethodBeat.m2505o(24224);
                    return;
                case 5:
                    abu abu;
                    if (aar.wgT != null) {
                        abu = aar.wgT.whA;
                    } else {
                        C4990ab.m7421w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", aar.mnd);
                        abu = null;
                    }
                    if (abu != null) {
                        str = abu.thumbUrl;
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        str2 = aar.cvq;
                    } else {
                        str2 = str;
                    }
                    super.mo68991a(imageView, aar, j, str2, i, i2, i3);
                    AppMethodBeat.m2505o(24224);
                    return;
                case 7:
                    super.mo68991a(imageView, aar, j, aar.cvq, i, i2, i3);
                    AppMethodBeat.m2505o(24224);
                    return;
                case 10:
                    if (aar.wgT == null) {
                        C4990ab.m7421w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", aar.mnd);
                        AppMethodBeat.m2505o(24224);
                        return;
                    }
                    abe = aar.wgT.whC;
                    if (abe != null) {
                        this.pJN.mo9922a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.m2505o(24224);
                        return;
                    }
                    break;
                case 11:
                    if (aar.wgT == null) {
                        C4990ab.m7421w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", aar.mnd);
                        AppMethodBeat.m2505o(24224);
                        return;
                    }
                    abe = aar.wgT.whC;
                    if (abe != null) {
                        this.pJN.mo9922a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.m2505o(24224);
                        return;
                    }
                    break;
                case 14:
                    if (aar.wgT == null) {
                        C4990ab.m7421w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", aar.mnd);
                        AppMethodBeat.m2505o(24224);
                        return;
                    }
                    abo abo = aar.wgT.whE;
                    if (abo != null) {
                        this.pJN.mo9922a(imageView, null, abo.thumbUrl, i, i2, i3);
                        AppMethodBeat.m2505o(24224);
                        return;
                    }
                    break;
                case 19:
                    aap aap;
                    if (aar.wgT != null) {
                        aap = aar.wgT.whN;
                    } else {
                        C4990ab.m7421w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", aar.mnd);
                        aap = null;
                    }
                    if (aap != null) {
                        str = aap.iconUrl;
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        str2 = aar.cvq;
                    } else {
                        str2 = str;
                    }
                    super.mo68991a(imageView, aar, j, str2, i, i2, i3);
                    AppMethodBeat.m2505o(24224);
                    return;
                default:
                    C4990ab.m7421w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", Integer.valueOf(aar.dataType));
                    break;
            }
            AppMethodBeat.m2505o(24224);
        }
    }

    /* renamed from: a */
    public final Bitmap mo8341a(C3711c c3711c) {
        AppMethodBeat.m2504i(24225);
        Bitmap b = super.mo68993b(c3711c.cAv, c3711c.pKv);
        AppMethodBeat.m2505o(24225);
        return b;
    }

    /* renamed from: a */
    public final Bitmap mo8340a(C3710b c3710b) {
        Bitmap bitmap;
        AppMethodBeat.m2504i(24226);
        aar aar = c3710b.cAv;
        long j = c3710b.pKv;
        boolean z = c3710b.cAy;
        int i = c3710b.maxWidth;
        if (C1445f.m3070Mn()) {
            String c = C43436n.m77558c(aar, j);
            if (C5046bo.isNullOrNil(c) || !C1173e.m2561ct(c)) {
                C4990ab.m7411d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", Boolean.FALSE, c);
                bitmap = null;
            } else {
                bitmap = (Bitmap) this.mkq.get(c);
                if (bitmap != null) {
                    C4990ab.m7411d("MicroMsg.RecordMsgImgService", "get bm from cache %s", c);
                } else if (z) {
                    bitmap = null;
                } else {
                    int i2;
                    C4990ab.m7411d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", c);
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(c, options);
                    if (bitmap != null) {
                        C4990ab.m7417i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", bitmap);
                        bitmap.recycle();
                    }
                    int i3 = options.outHeight;
                    int i4 = options.outWidth;
                    C4990ab.m7411d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", Integer.valueOf(i4), Integer.valueOf(i3));
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
                    int bJ = ExifHelper.m7368bJ(c);
                    if (bJ == 90 || bJ == 270) {
                        i4 = i;
                        i2 = i3;
                    } else {
                        i4 = i3;
                        i2 = i;
                    }
                    bitmap = C5056d.m7659d(c, i4, i2, false);
                    if (bitmap == null) {
                        C4990ab.m7412e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(c)));
                        bitmap = null;
                    } else {
                        bitmap = C5056d.m7648b(bitmap, (float) bJ);
                        this.mkq.put(c, bitmap);
                    }
                }
            }
        } else {
            bitmap = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
        }
        if (bitmap == null && !z) {
            C4990ab.m7411d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", Boolean.valueOf(super.mo68992a(aar, j)));
            C43436n.m77557b(aar, j, r1);
        }
        AppMethodBeat.m2505o(24226);
        return bitmap;
    }

    public final void ceH() {
        AppMethodBeat.m2504i(24227);
        super.destory();
        AppMethodBeat.m2505o(24227);
    }
}
