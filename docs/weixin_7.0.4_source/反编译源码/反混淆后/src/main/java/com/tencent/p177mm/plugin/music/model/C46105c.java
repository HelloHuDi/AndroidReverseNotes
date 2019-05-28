package com.tencent.p177mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.music.model.c */
public final class C46105c {
    public C1177f<String, Bitmap> edn = new C26399b(5, getClass());
    public C12676a oMq = this;
    private C9014g oMr = new C433311();
    public C7306ak oMs = new C7306ak(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.music.model.c$a */
    public interface C12676a {
        /* renamed from: a */
        void mo24643a(C28575a c28575a, int[] iArr);
    }

    /* renamed from: com.tencent.mm.plugin.music.model.c$b */
    class C28573b implements Runnable {
        C28575a oMw;

        C28573b(C28575a c28575a) {
            this.oMw = c28575a;
        }

        public final void run() {
            AppMethodBeat.m2504i(104878);
            bau bau = new bau();
            bau.f17915Id = this.oMw.field_songMediaId;
            bau.wEH = this.oMw.field_songAlbumUrl;
            bau.wEI = this.oMw.field_songAlbumType;
            bau.Url = bau.wEH;
            Bitmap b = C21877n.qFx.mo37454b(bau);
            if (b != null) {
                b = C5056d.m7660e(b, 10);
                C46105c.this.mo74023a(this.oMw, b);
                int[] ao = C5222ae.m7936ao(b);
                if (!this.oMw.mo46709w(ao)) {
                    this.oMw = C39445e.bUk().mo24654ac(this.oMw.field_musicId, ao[0], ao[1]);
                }
                if (!(C46105c.this.oMq == null || this.oMw == null)) {
                    C46105c.this.oMq.mo24643a(this.oMw, ao);
                }
            }
            AppMethodBeat.m2505o(104878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.c$1 */
    class C433311 implements C9014g {
        C433311() {
        }

        /* renamed from: sH */
        public final void mo7596sH(String str) {
        }

        /* renamed from: a */
        public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
            return null;
        }

        /* renamed from: b */
        public final void mo7595b(String str, View view, C37477b c37477b) {
            AppMethodBeat.m2504i(104877);
            String str2 = "MicroMsg.Music.MusicImageLoader";
            String str3 = "onImageLoadFinish %s %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(c37477b.bitmap != null);
            C4990ab.m7417i(str2, str3, objArr);
            final C28575a c28575a = (C28575a) view.getTag();
            if (!(c37477b.bitmap == null || c28575a == null)) {
                C46105c.this.mo74023a(c28575a, c37477b.bitmap);
                final int[] ao = C5222ae.m7936ao(c37477b.bitmap);
                if (!c28575a.mo46709w(ao)) {
                    C39445e.bUk().mo24654ac(c28575a.field_musicId, ao[0], ao[1]);
                }
                if (C46105c.this.oMq != null) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(104876);
                            C46105c.this.oMq.mo24643a(c28575a, ao);
                            AppMethodBeat.m2505o(104876);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(104877);
        }
    }

    public C46105c() {
        AppMethodBeat.m2504i(104879);
        AppMethodBeat.m2505o(104879);
    }

    /* renamed from: a */
    public final void mo74024a(C28575a c28575a, CdnImageView cdnImageView, Context context, boolean z, boolean z2) {
        AppMethodBeat.m2504i(104880);
        if (z) {
            this.edn.remove(c28575a.field_musicId);
        }
        Bitmap bitmap = (Bitmap) this.edn.get(c28575a.field_musicId);
        int[] ao;
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = null;
            C4990ab.m7417i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", c28575a.field_musicId, c28575a.field_songHAlbumUrl, c28575a.field_songAlbumUrl, c28575a.field_songAlbumLocalPath);
            cdnImageView.setTag(c28575a);
            C17927a c17927a;
            if (c28575a.bUv()) {
                c17927a = new C17927a();
                c17927a.ePJ = C12673b.m20675aY(c28575a.field_musicId, true);
                c17927a.ePH = true;
                c17927a.ePF = true;
                c17927a.ePT = C25738R.drawable.b27;
                if (z2) {
                    c17927a.fHf = true;
                    c17927a.fHg = 10;
                }
                C32291o.ahp().mo43767a(c28575a.field_songHAlbumUrl, (ImageView) cdnImageView, c17927a.ahG(), this.oMr);
            } else {
                switch (c28575a.field_musicType) {
                    case 0:
                    case 5:
                    case 7:
                    case 10:
                    case 11:
                        break;
                    case 1:
                    case 8:
                    case 9:
                        bau bau = new bau();
                        bau.f17915Id = c28575a.field_songMediaId;
                        bau.wEH = c28575a.field_songAlbumUrl;
                        bau.wEI = c28575a.field_songAlbumType;
                        bau.Url = bau.wEH;
                        if (C21877n.qFx != null) {
                            bitmap = C21877n.qFx.mo37454b(bau);
                            if (bitmap == null) {
                                cdnImageView.setImageResource(C25738R.drawable.b27);
                                if (!(c28575a.bUu() || this.oMq == null)) {
                                    this.oMq.mo24643a(c28575a, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                                }
                                C21877n.qFx.mo37462dz(cdnImageView);
                                C21877n.qFx.mo37442a(bau, cdnImageView, context.hashCode(), C44222az.xYU);
                                this.oMs.removeCallbacksAndMessages(null);
                                this.oMs.postDelayed(new C28573b(c28575a), 1000);
                                break;
                            }
                            bitmap = C5056d.m7660e(bitmap, 10);
                            break;
                        }
                        break;
                    case 4:
                        c17927a = new C17927a();
                        c17927a.ePJ = C12673b.m20675aY(c28575a.field_musicId, false);
                        c17927a.ePH = true;
                        c17927a.ePF = true;
                        if (z2) {
                            c17927a.fHf = true;
                            c17927a.fHg = 10;
                        }
                        C32291o.ahp().mo43767a(c28575a.field_songAlbumUrl, (ImageView) cdnImageView, c17927a.ahG(), this.oMr);
                        break;
                    case 6:
                        bitmap = C32291o.ahl().mo73104b(c28575a.field_songAlbumLocalPath, C1338a.getDensity(context), false);
                        break;
                }
                if (bitmap == null) {
                    bitmap = C32291o.ahl().mo73087a(c28575a.field_songAlbumLocalPath, C1338a.getDensity(context), false);
                }
                if (bitmap != null) {
                    bitmap = C5056d.m7660e(bitmap, 10);
                } else {
                    cdnImageView.setImageResource(C25738R.drawable.b27);
                    if (!(c28575a.bUu() || this.oMq == null)) {
                        this.oMq.mo24643a(c28575a, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                    }
                    C4990ab.m7417i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", c28575a.field_songAlbumUrl);
                    if (!TextUtils.isEmpty(c28575a.field_songAlbumUrl)) {
                        c17927a = new C17927a();
                        c17927a.ePJ = C12673b.m20675aY(c28575a.field_musicId, true);
                        c17927a.ePH = true;
                        c17927a.ePF = true;
                        if (z2) {
                            c17927a.fHf = true;
                            c17927a.fHg = 10;
                        }
                        C32291o.ahp().mo43767a(c28575a.field_songAlbumUrl, (ImageView) cdnImageView, c17927a.ahG(), this.oMr);
                    }
                }
            }
            if (!(bitmap == null || bitmap.isRecycled())) {
                mo74023a(c28575a, bitmap);
                cdnImageView.setImageBitmap(bitmap);
                ao = C5222ae.m7936ao(bitmap);
                if (!c28575a.mo46709w(ao)) {
                    c28575a = C39445e.bUk().mo24654ac(c28575a.field_musicId, ao[0], ao[1]);
                }
                if (!(this.oMq == null || c28575a == null)) {
                    this.oMq.mo24643a(c28575a, ao);
                }
            }
            AppMethodBeat.m2505o(104880);
            return;
        }
        C4990ab.m7417i("MicroMsg.Music.MusicImageLoader", "hit cache %s", c28575a.field_musicId);
        cdnImageView.setImageBitmap(bitmap);
        ao = c28575a.bUu() ? new int[]{c28575a.field_songBgColor, c28575a.field_songLyricColor} : C5222ae.m7936ao(bitmap);
        if (this.oMq != null) {
            this.oMq.mo24643a(c28575a, ao);
        }
        AppMethodBeat.m2505o(104880);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo74023a(C28575a c28575a, Bitmap bitmap) {
        AppMethodBeat.m2504i(104881);
        C4990ab.m7417i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", c28575a.field_musicId);
        this.edn.put(c28575a.field_musicId, bitmap);
        AppMethodBeat.m2505o(104881);
    }
}
