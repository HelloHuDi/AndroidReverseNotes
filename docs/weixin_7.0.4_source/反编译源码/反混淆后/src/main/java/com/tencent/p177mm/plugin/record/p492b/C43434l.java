package com.tencent.p177mm.plugin.record.p492b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C4770f;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C35985ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.record.b.l */
public class C43434l {
    private HashMap<String, String[]> mko = new HashMap();
    protected C1177f<String, Bitmap> mkq = new C26399b(10, getClass());
    protected C4770f pJN = new C434331();
    private HashSet<String> pJO = new HashSet();
    private HashMap<String, C1446a> pJP = new HashMap();

    /* renamed from: com.tencent.mm.plugin.record.b.l$1 */
    class C434331 extends C4770f {
        C434331() {
            super(24);
        }

        /* renamed from: h */
        public final C9791v mo9924h(String str, String str2, int i, int i2) {
            AppMethodBeat.m2504i(24168);
            C28831p c28831p = new C28831p(str, str2, i, i2);
            AppMethodBeat.m2505o(24168);
            return c28831p;
        }
    }

    public C43434l() {
        AppMethodBeat.m2504i(24169);
        AppMethodBeat.m2505o(24169);
    }

    public final void destory() {
        AppMethodBeat.m2504i(24170);
        this.pJN.destroy();
        this.mko.clear();
        this.pJO.clear();
        this.pJN = null;
        this.mko = null;
        this.pJO = null;
        AppMethodBeat.m2505o(24170);
    }

    /* renamed from: a */
    public final Bitmap mo68990a(aar aar, long j, boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(24172);
        Bitmap bitmap;
        if (C1445f.m3070Mn()) {
            String f;
            if (z) {
                f = C43436n.m77562f(aar, j);
            } else {
                f = C43436n.m77558c(aar, j);
            }
            if (C5046bo.isNullOrNil(f) || !C1173e.m2561ct(f)) {
                C4990ab.m7411d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", Boolean.valueOf(z), f);
                AppMethodBeat.m2505o(24172);
                return null;
            }
            bitmap = (Bitmap) this.mkq.get(f);
            if (bitmap != null) {
                AppMethodBeat.m2505o(24172);
                return bitmap;
            }
            int i2;
            int i3;
            C4990ab.m7411d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", f);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(f, options);
            if (bitmap != null) {
                C4990ab.m7417i("MicroMsg.RecordMsgImgService", "bitmap recycled %s", bitmap);
                bitmap.recycle();
            }
            int i4 = (!C35985ad.m59194cJ(options.outWidth, options.outHeight) || options.outWidth <= 480) ? 0 : 1;
            if (!C35985ad.m59193cI(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                i = 0;
            }
            if (i4 == 0 && i == 0) {
                i4 = VideoFilterUtil.IMAGE_HEIGHT;
                i = 960;
            } else {
                i4 = options.outHeight;
                i = options.outWidth;
            }
            int bJ = ExifHelper.m7368bJ(f);
            if (bJ == 90 || bJ == 270) {
                i2 = i;
                i3 = i4;
            } else {
                i2 = i4;
                i3 = i;
            }
            bitmap = C5056d.m7659d(f, i2, i3, false);
            if (bitmap == null) {
                C4990ab.m7412e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(f)));
                AppMethodBeat.m2505o(24172);
                return null;
            }
            bitmap = C5056d.m7648b(bitmap, (float) bJ);
            this.mkq.put(f, bitmap);
            AppMethodBeat.m2505o(24172);
            return bitmap;
        }
        bitmap = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
        AppMethodBeat.m2505o(24172);
        return bitmap;
    }

    /* renamed from: b */
    public final Bitmap mo68993b(aar aar, long j) {
        AppMethodBeat.m2504i(24173);
        Bitmap a = mo68990a(aar, j, true);
        if (a == null) {
            C4990ab.m7411d("MicroMsg.RecordMsgImgService", "get thumb fail, try download, can retry:%B", Boolean.valueOf(mo68992a(aar, j)));
            C43436n.m77559c(aar, j, r1);
        }
        AppMethodBeat.m2505o(24173);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo68991a(ImageView imageView, aar aar, long j, String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(24174);
        String str2 = C43436n.m77546LA(aar.mnd) + "@" + String.valueOf(j);
        if (aar.mnd != null) {
            String[] strArr;
            String[] strArr2 = (String[]) this.mko.get(str2);
            if (strArr2 == null || strArr2.length <= 0) {
                strArr = new String[]{C43436n.m77562f(aar, j)};
                this.mko.put(str2, strArr);
            } else {
                strArr = strArr2;
            }
            this.pJN.mo9922a(imageView, strArr, str, i, i2, i3);
            if (this.pJO.contains(str2)) {
                AppMethodBeat.m2505o(24174);
                return;
            }
            this.pJO.add(str2);
            if (!(new File(strArr[0]).exists() || (C5046bo.isNullOrNil(aar.fgE) && C5046bo.isNullOrNil(aar.fgv)))) {
                C43436n.m77559c(aar, j, mo68992a(aar, j));
            }
            AppMethodBeat.m2505o(24174);
            return;
        }
        AppMethodBeat.m2505o(24174);
    }

    /* renamed from: a */
    public final boolean mo68992a(aar aar, long j) {
        AppMethodBeat.m2504i(24171);
        String h = C43436n.m77564h(aar.mnd, j, true);
        C1446a c1446a = (C1446a) this.pJP.get(h);
        if (c1446a == null) {
            this.pJP.put(h, new C1446a());
            AppMethodBeat.m2505o(24171);
            return true;
        } else if (c1446a.mo4908Mr() > 30000) {
            c1446a.evE = SystemClock.elapsedRealtime();
            AppMethodBeat.m2505o(24171);
            return true;
        } else {
            AppMethodBeat.m2505o(24171);
            return false;
        }
    }
}
