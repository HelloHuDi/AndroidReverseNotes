package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.ae;
import com.tencent.smtt.sdk.WebView;

public final class c {
    public f<String, Bitmap> edn = new com.tencent.mm.memory.a.b(5, getClass());
    public a oMq = this;
    private g oMr = new g() {
        public final void sH(String str) {
        }

        public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
            return null;
        }

        public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
            AppMethodBeat.i(104877);
            String str2 = "MicroMsg.Music.MusicImageLoader";
            String str3 = "onImageLoadFinish %s %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bVar.bitmap != null);
            ab.i(str2, str3, objArr);
            final com.tencent.mm.plugin.music.model.e.a aVar = (com.tencent.mm.plugin.music.model.e.a) view.getTag();
            if (!(bVar.bitmap == null || aVar == null)) {
                c.this.a(aVar, bVar.bitmap);
                final int[] ao = ae.ao(bVar.bitmap);
                if (!aVar.w(ao)) {
                    e.bUk().ac(aVar.field_musicId, ao[0], ao[1]);
                }
                if (c.this.oMq != null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(104876);
                            c.this.oMq.a(aVar, ao);
                            AppMethodBeat.o(104876);
                        }
                    });
                }
            }
            AppMethodBeat.o(104877);
        }
    };
    public ak oMs = new ak(Looper.getMainLooper());

    public interface a {
        void a(com.tencent.mm.plugin.music.model.e.a aVar, int[] iArr);
    }

    class b implements Runnable {
        com.tencent.mm.plugin.music.model.e.a oMw;

        b(com.tencent.mm.plugin.music.model.e.a aVar) {
            this.oMw = aVar;
        }

        public final void run() {
            AppMethodBeat.i(104878);
            bau bau = new bau();
            bau.Id = this.oMw.field_songMediaId;
            bau.wEH = this.oMw.field_songAlbumUrl;
            bau.wEI = this.oMw.field_songAlbumType;
            bau.Url = bau.wEH;
            Bitmap b = n.qFx.b(bau);
            if (b != null) {
                b = d.e(b, 10);
                c.this.a(this.oMw, b);
                int[] ao = ae.ao(b);
                if (!this.oMw.w(ao)) {
                    this.oMw = e.bUk().ac(this.oMw.field_musicId, ao[0], ao[1]);
                }
                if (!(c.this.oMq == null || this.oMw == null)) {
                    c.this.oMq.a(this.oMw, ao);
                }
            }
            AppMethodBeat.o(104878);
        }
    }

    public c() {
        AppMethodBeat.i(104879);
        AppMethodBeat.o(104879);
    }

    public final void a(com.tencent.mm.plugin.music.model.e.a aVar, CdnImageView cdnImageView, Context context, boolean z, boolean z2) {
        AppMethodBeat.i(104880);
        if (z) {
            this.edn.remove(aVar.field_musicId);
        }
        Bitmap bitmap = (Bitmap) this.edn.get(aVar.field_musicId);
        int[] ao;
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = null;
            ab.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", aVar.field_musicId, aVar.field_songHAlbumUrl, aVar.field_songAlbumUrl, aVar.field_songAlbumLocalPath);
            cdnImageView.setTag(aVar);
            com.tencent.mm.at.a.a.c.a aVar2;
            if (aVar.bUv()) {
                aVar2 = new com.tencent.mm.at.a.a.c.a();
                aVar2.ePJ = com.tencent.mm.plugin.music.h.b.aY(aVar.field_musicId, true);
                aVar2.ePH = true;
                aVar2.ePF = true;
                aVar2.ePT = R.drawable.b27;
                if (z2) {
                    aVar2.fHf = true;
                    aVar2.fHg = 10;
                }
                o.ahp().a(aVar.field_songHAlbumUrl, (ImageView) cdnImageView, aVar2.ahG(), this.oMr);
            } else {
                switch (aVar.field_musicType) {
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
                        bau.Id = aVar.field_songMediaId;
                        bau.wEH = aVar.field_songAlbumUrl;
                        bau.wEI = aVar.field_songAlbumType;
                        bau.Url = bau.wEH;
                        if (n.qFx != null) {
                            bitmap = n.qFx.b(bau);
                            if (bitmap == null) {
                                cdnImageView.setImageResource(R.drawable.b27);
                                if (!(aVar.bUu() || this.oMq == null)) {
                                    this.oMq.a(aVar, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                                }
                                n.qFx.dz(cdnImageView);
                                n.qFx.a(bau, cdnImageView, context.hashCode(), az.xYU);
                                this.oMs.removeCallbacksAndMessages(null);
                                this.oMs.postDelayed(new b(aVar), 1000);
                                break;
                            }
                            bitmap = d.e(bitmap, 10);
                            break;
                        }
                        break;
                    case 4:
                        aVar2 = new com.tencent.mm.at.a.a.c.a();
                        aVar2.ePJ = com.tencent.mm.plugin.music.h.b.aY(aVar.field_musicId, false);
                        aVar2.ePH = true;
                        aVar2.ePF = true;
                        if (z2) {
                            aVar2.fHf = true;
                            aVar2.fHg = 10;
                        }
                        o.ahp().a(aVar.field_songAlbumUrl, (ImageView) cdnImageView, aVar2.ahG(), this.oMr);
                        break;
                    case 6:
                        bitmap = o.ahl().b(aVar.field_songAlbumLocalPath, com.tencent.mm.bz.a.getDensity(context), false);
                        break;
                }
                if (bitmap == null) {
                    bitmap = o.ahl().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bz.a.getDensity(context), false);
                }
                if (bitmap != null) {
                    bitmap = d.e(bitmap, 10);
                } else {
                    cdnImageView.setImageResource(R.drawable.b27);
                    if (!(aVar.bUu() || this.oMq == null)) {
                        this.oMq.a(aVar, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                    }
                    ab.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", aVar.field_songAlbumUrl);
                    if (!TextUtils.isEmpty(aVar.field_songAlbumUrl)) {
                        aVar2 = new com.tencent.mm.at.a.a.c.a();
                        aVar2.ePJ = com.tencent.mm.plugin.music.h.b.aY(aVar.field_musicId, true);
                        aVar2.ePH = true;
                        aVar2.ePF = true;
                        if (z2) {
                            aVar2.fHf = true;
                            aVar2.fHg = 10;
                        }
                        o.ahp().a(aVar.field_songAlbumUrl, (ImageView) cdnImageView, aVar2.ahG(), this.oMr);
                    }
                }
            }
            if (!(bitmap == null || bitmap.isRecycled())) {
                a(aVar, bitmap);
                cdnImageView.setImageBitmap(bitmap);
                ao = ae.ao(bitmap);
                if (!aVar.w(ao)) {
                    aVar = e.bUk().ac(aVar.field_musicId, ao[0], ao[1]);
                }
                if (!(this.oMq == null || aVar == null)) {
                    this.oMq.a(aVar, ao);
                }
            }
            AppMethodBeat.o(104880);
            return;
        }
        ab.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", aVar.field_musicId);
        cdnImageView.setImageBitmap(bitmap);
        ao = aVar.bUu() ? new int[]{aVar.field_songBgColor, aVar.field_songLyricColor} : ae.ao(bitmap);
        if (this.oMq != null) {
            this.oMq.a(aVar, ao);
        }
        AppMethodBeat.o(104880);
    }

    /* Access modifiers changed, original: final */
    public final void a(com.tencent.mm.plugin.music.model.e.a aVar, Bitmap bitmap) {
        AppMethodBeat.i(104881);
        ab.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", aVar.field_musicId);
        this.edn.put(aVar.field_musicId, bitmap);
        AppMethodBeat.o(104881);
    }
}
