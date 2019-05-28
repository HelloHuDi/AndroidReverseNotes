package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    public LinkedList<Bankcard> eBA;
    ReentrantLock mLock = new ReentrantLock();
    ArrayList<b> tOQ = new ArrayList();
    private c tOR = new c<ad>() {
        {
            AppMethodBeat.i(47983);
            this.xxI = ad.class.getName().hashCode();
            AppMethodBeat.o(47983);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(47984);
            a.this.mLock.lock();
            while (a.this.tOQ != null && a.this.tOQ.size() > 0) {
                com.tencent.mm.platformtools.x.a aVar = (b) a.this.tOQ.remove(0);
                if (aVar == null) {
                    break;
                }
                Bankcard bankcard = aVar.thJ;
                ImageView imageView = (ImageView) aVar.tPb.get();
                if (imageView != null) {
                    String str = (String) imageView.getTag(R.id.d7);
                    if (!bo.isNullOrNil(str) && ((!r.YM() && str.equals(bankcard.field_bankcardType)) || (r.YM() && str.equals(bankcard.field_bankName)))) {
                        e eVar;
                        if (bankcard.txc != null) {
                            eVar = bankcard.txc;
                        } else if (r.YM()) {
                            eVar = com.tencent.mm.plugin.wallet_core.d.b.i(imageView.getContext(), bankcard.field_bankName, false);
                        } else {
                            eVar = com.tencent.mm.plugin.wallet_core.d.b.i(imageView.getContext(), bankcard.field_bankcardType, bankcard.cPb());
                        }
                        a aVar2 = a.this;
                        if (eVar == null || aVar == null || aVar.tPb == null || aVar.tPb.get() == null) {
                            ab.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
                        } else {
                            ab.d("MicroMsg.BankcardLogoHelper", "setLogo bankLogoUrl = " + eVar.oRi);
                            imageView = (ImageView) aVar.tPb.get();
                            if (!bo.isNullOrNil(eVar.oRi)) {
                                imageView.post(new AnonymousClass2(aVar, imageView, x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(eVar.oRi))));
                                aVar.tKb = eVar.oRi;
                                x.a(aVar);
                            } else if (eVar.txs > 0) {
                                imageView.post(new AnonymousClass3(imageView, eVar));
                            } else {
                                ab.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
                            }
                        }
                        aVar2 = a.this;
                        if (!(eVar == null || aVar == null || aVar.tPc == null || aVar.tPc.get() == null)) {
                            View view = (View) aVar.tPc.get();
                            view.post(new AnonymousClass4(view, eVar, aVar));
                        }
                        aVar2 = a.this;
                        if (!(eVar == null || aVar == null || aVar.tPc == null || aVar.tPc.get() == null)) {
                            imageView = (ImageView) aVar.tPd.get();
                            if (imageView != null) {
                                imageView.post(new AnonymousClass5(eVar, imageView, aVar));
                            }
                        }
                    }
                }
            }
            a.this.mLock.unlock();
            AppMethodBeat.o(47984);
            return true;
        }
    };
    public LinkedList<String> tOS;

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$8 */
    public class AnonymousClass8 implements com.tencent.mm.vending.c.a<Object, Object> {
        final /* synthetic */ Map tOY;
        final /* synthetic */ a tOZ;
        final /* synthetic */ List tpo;

        public AnonymousClass8(List list, Map map, a aVar) {
            this.tpo = list;
            this.tOY = map;
            this.tOZ = aVar;
        }

        public final Object call(Object obj) {
            AppMethodBeat.i(47991);
            for (Bankcard bankcard : this.tpo) {
                this.tOY.put(bankcard.field_bankcardType, com.tencent.mm.plugin.wallet_core.d.b.acM(bankcard.field_bankcardType));
            }
            if (this.tOZ != null) {
                this.tOZ.am(this.tOY);
            }
            Void voidR = zXH;
            AppMethodBeat.o(47991);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ImageView lvs;
        final /* synthetic */ b tOU;
        final /* synthetic */ Bitmap tOV;

        AnonymousClass2(b bVar, ImageView imageView, Bitmap bitmap) {
            this.tOU = bVar;
            this.lvs = imageView;
            this.tOV = bitmap;
        }

        public final void run() {
            AppMethodBeat.i(47985);
            Bankcard bankcard = this.tOU.thJ;
            String str = (String) this.lvs.getTag(R.id.d7);
            if (bo.isNullOrNil(str) || ((r.YM() || !str.equals(bankcard.field_bankcardType)) && !(r.YM() && str.equals(bankcard.field_bankName)))) {
                ab.d("MicroMsg.BankcardLogoHelper", "not match tag: %s, banktype: %s, iv: %s", str, bankcard.field_bankcardType, this.lvs);
                AppMethodBeat.o(47985);
                return;
            }
            this.lvs.setImageBitmap(this.tOV);
            AppMethodBeat.o(47985);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ImageView lvs;
        final /* synthetic */ e tOW;

        AnonymousClass3(ImageView imageView, e eVar) {
            this.lvs = imageView;
            this.tOW = eVar;
        }

        public final void run() {
            AppMethodBeat.i(47986);
            this.lvs.setImageResource(this.tOW.txs);
            AppMethodBeat.o(47986);
        }
    }

    public interface a {
        void am(Map<String, e> map);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ b tOU;
        final /* synthetic */ e tOW;
        final /* synthetic */ View tOX;

        AnonymousClass4(View view, e eVar, b bVar) {
            this.tOX = view;
            this.tOW = eVar;
            this.tOU = bVar;
        }

        public final void run() {
            AppMethodBeat.i(47987);
            this.tOX.invalidate();
            String str = this.tOW.txp;
            int i = "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png".equals(str) ? R.drawable.bkm : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png".equals(str) ? R.drawable.bkp : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png".equals(str) ? R.drawable.bkr : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png".equals(str) ? R.drawable.bkw : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png".equals(str) ? R.drawable.bkx : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png".equals(str) ? R.drawable.bl2 : -1;
            TextView textView;
            int pixel;
            if (i != -1) {
                this.tOX.setBackgroundResource(i);
                Bitmap decodeResource = BitmapFactory.decodeResource(this.tOX.getResources(), i);
                ab.d("MicroMsg.BankcardLogoHelper", "local bg color: %s", Integer.valueOf(decodeResource.getPixel(decodeResource.getWidth() / 2, decodeResource.getHeight() / 2)));
                textView = (TextView) this.tOU.tPe.get();
                if (textView != null) {
                    textView.setTextColor(pixel);
                }
                AppMethodBeat.o(47987);
            } else if (bo.isNullOrNil(this.tOW.txp)) {
                if (this.tOW.txt > 0) {
                    this.tOX.setBackgroundResource(this.tOW.txt);
                }
                AppMethodBeat.o(47987);
            } else {
                v cVar = new com.tencent.mm.plugin.wallet_core.ui.view.c(this.tOW.txp);
                Bitmap a = x.a(cVar);
                x.a(this.tOU);
                if (a != null) {
                    try {
                        byte[] ninePatchChunk = a.getNinePatchChunk();
                        if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                            com.tencent.mm.vfs.e.deleteFile(cVar.anJ());
                        }
                    } catch (Exception e) {
                    }
                }
                if (a != null) {
                    this.tOX.setBackgroundDrawable(com.tencent.mm.plugin.wallet_core.ui.view.b.b(this.tOX.getContext(), a));
                    pixel = a.getPixel(a.getWidth() / 2, a.getHeight() / 2);
                    textView = (TextView) this.tOU.tPe.get();
                    if (textView != null) {
                        ab.d("MicroMsg.BankcardLogoHelper", "server bg color: %s", Integer.valueOf(pixel));
                        textView.setTextColor(pixel);
                    }
                }
                AppMethodBeat.o(47987);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ ImageView lvs;
        final /* synthetic */ b tOU;
        final /* synthetic */ e tOW;

        AnonymousClass5(e eVar, ImageView imageView, b bVar) {
            this.tOW = eVar;
            this.lvs = imageView;
            this.tOU = bVar;
        }

        public final void run() {
            AppMethodBeat.i(47988);
            if (bo.isNullOrNil(this.tOW.txq)) {
                if (this.tOW.txu > 0) {
                    this.lvs.setImageResource(this.tOW.txu);
                }
                AppMethodBeat.o(47988);
                return;
            }
            this.lvs.setImageBitmap(x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(this.tOW.txq)));
            x.a(this.tOU);
            AppMethodBeat.o(47988);
        }
    }

    static class b implements com.tencent.mm.platformtools.x.a {
        String tKb;
        WeakReference<ImageView> tPb;
        WeakReference<View> tPc = null;
        WeakReference<ImageView> tPd = null;
        WeakReference<TextView> tPe = null;
        boolean tPf = false;
        Bankcard thJ;

        b() {
        }

        public final void m(String str, final Bitmap bitmap) {
            boolean z = true;
            AppMethodBeat.i(47997);
            ab.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish " + str + ", bitmap = " + (bitmap == null));
            if (TextUtils.isEmpty(this.tKb)) {
                ab.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
                AppMethodBeat.o(47997);
                return;
            }
            if (this.tPb != null) {
                String str2;
                final ImageView imageView = (ImageView) this.tPb.get();
                String str3 = "MicroMsg.BankcardLogoHelper";
                String str4 = "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s";
                Object[] objArr = new Object[6];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap == null);
                if (imageView != null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                if (imageView == null) {
                    str2 = "";
                } else {
                    str2 = imageView.getTag();
                }
                objArr[3] = str2;
                objArr[4] = this.tKb;
                objArr[5] = Boolean.valueOf(this.tPf);
                ab.d(str3, str4, objArr);
                if (!(imageView == null || str == null || !str.equals(this.tKb))) {
                    if (!this.tPf) {
                        imageView.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(47996);
                                imageView.setImageBitmap(bitmap);
                                AppMethodBeat.o(47996);
                            }
                        });
                        imageView.setTag(R.id.d7, null);
                    } else if (!(imageView.getTag(R.id.d7) == null || this.thJ == null || this.thJ.field_bankcardType == null)) {
                        str2 = (String) imageView.getTag(R.id.d7);
                        if (!bo.isNullOrNil(str2) && str2.equals(this.thJ.field_bankcardType)) {
                            imageView.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(47995);
                                    imageView.setImageBitmap(bitmap);
                                    AppMethodBeat.o(47995);
                                }
                            });
                            imageView.setTag(R.id.d7, null);
                        }
                        AppMethodBeat.o(47997);
                        return;
                    }
                }
            }
            AppMethodBeat.o(47997);
        }
    }

    public a() {
        AppMethodBeat.i(47998);
        com.tencent.mm.sdk.b.a.xxA.c(this.tOR);
        AppMethodBeat.o(47998);
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView) {
        AppMethodBeat.i(47999);
        a(context, bankcard, imageView, null, null, null);
        AppMethodBeat.o(47999);
    }

    public static void j(ImageView imageView) {
        AppMethodBeat.i(TXRecordCommon.AUDIO_SAMPLERATE_48000);
        if (imageView != null) {
            imageView.setTag(R.id.d7, null);
            imageView.setImageResource(R.drawable.bki);
        }
        AppMethodBeat.o(TXRecordCommon.AUDIO_SAMPLERATE_48000);
    }

    public final void a(Bankcard bankcard, ImageView imageView) {
        AppMethodBeat.i(48001);
        com.tencent.mm.platformtools.x.a bVar = new b();
        bVar.thJ = bankcard;
        if (imageView != null) {
            imageView.setTag(R.id.d7, bankcard.field_bankcardType);
            bVar.tPb = new WeakReference(imageView);
        }
        final e eVar = bankcard.txc;
        if (eVar == null || bVar.tPb == null || bVar.tPb.get() == null) {
            ab.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
            AppMethodBeat.o(48001);
            return;
        }
        ab.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + eVar.oRi);
        final ImageView imageView2 = (ImageView) bVar.tPb.get();
        if (!bo.isNullOrNil(eVar.oRi)) {
            bVar.tKb = eVar.oRi;
            bVar.tPf = true;
            Bitmap a = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(eVar.oRi));
            if (a != null) {
                imageView2.setImageBitmap(a);
            }
            x.a(bVar);
            AppMethodBeat.o(48001);
        } else if (eVar.txs > 0) {
            imageView2.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(47989);
                    imageView2.setImageResource(eVar.txs);
                    AppMethodBeat.o(47989);
                }
            });
            AppMethodBeat.o(48001);
        } else {
            ab.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
            AppMethodBeat.o(48001);
        }
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView, View view, ImageView imageView2, TextView textView) {
        AppMethodBeat.i(48002);
        b bVar = new b();
        bVar.tPf = false;
        bVar.thJ = bankcard;
        if (imageView != null) {
            imageView.setTag(R.id.d7, bankcard.field_bankcardType);
            bVar.tPb = new WeakReference(imageView);
        }
        if (view != null) {
            bVar.tPc = new WeakReference(view);
        }
        if (imageView2 != null) {
            bVar.tPd = new WeakReference(imageView2);
        }
        if (textView != null) {
            bVar.tPe = new WeakReference(textView);
        }
        this.tOQ.add(bVar);
        a(context, bankcard);
        AppMethodBeat.o(48002);
    }

    public final void destory() {
        AppMethodBeat.i(48003);
        com.tencent.mm.sdk.b.a.xxA.d(this.tOR);
        if (this.tOQ != null) {
            this.tOQ.clear();
            this.tOQ = null;
        }
        AppMethodBeat.o(48003);
    }

    private void a(Context context, Bankcard bankcard) {
        Object obj;
        AppMethodBeat.i(48004);
        if (r.YM()) {
            obj = bankcard.field_bankName;
        } else {
            obj = bankcard.field_bankcardType;
        }
        if (this.tOS == null || !this.tOS.contains(obj)) {
            if (b(context, bankcard)) {
                com.tencent.mm.sdk.b.a.xxA.m(new ad());
            } else {
                if (this.eBA == null) {
                    this.eBA = new LinkedList();
                }
                this.eBA.add(bankcard);
                if (this.tOS == null) {
                    b(context, this.eBA);
                    AppMethodBeat.o(48004);
                    return;
                }
            }
            AppMethodBeat.o(48004);
            return;
        }
        ab.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(obj)));
        AppMethodBeat.o(48004);
    }

    private static boolean b(Context context, Bankcard bankcard) {
        e i;
        AppMethodBeat.i(48005);
        if (r.YM()) {
            i = com.tencent.mm.plugin.wallet_core.d.b.i(context, bankcard.field_bankName, false);
        } else {
            i = com.tencent.mm.plugin.wallet_core.d.b.i(context, bankcard.field_bankcardType, bankcard.cPb());
        }
        if (i == null || i.bNM) {
            AppMethodBeat.o(48005);
            return false;
        }
        AppMethodBeat.o(48005);
        return true;
    }

    public final void b(final Context context, List<Bankcard> list) {
        AppMethodBeat.i(48006);
        if (list != null && list.size() > 0) {
            int size = list.size();
            this.tOS = new LinkedList();
            for (int i = 0; i < size; i++) {
                Bankcard bankcard = (Bankcard) list.get(i);
                if (bankcard.cPc()) {
                    ab.i("MicroMsg.BankcardLogoHelper", "ignore balance");
                } else if (!b(context, bankcard)) {
                    ab.i("MicroMsg.BankcardLogoHelper", bankcard.field_bankcardType + "'s url is null or need update");
                    this.tOS.add(bankcard.field_bankcardType);
                }
            }
            if (this.tOS.size() > 0) {
                ab.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
                m cVar = new com.tencent.mm.plugin.wallet_core.c.c(this.tOS);
                g.RQ();
                g.RO().eJo.a(1650, new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(47990);
                        g.RQ();
                        g.RO().eJo.b(1650, (f) this);
                        a.this.tOS = null;
                        if (a.this.eBA != null) {
                            a.this.b(context, a.this.eBA);
                            a.this.eBA = null;
                        }
                        AppMethodBeat.o(47990);
                    }
                });
                g.RQ();
                g.RO().eJo.a(cVar, 0);
                AppMethodBeat.o(48006);
                return;
            }
            ab.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
            com.tencent.mm.sdk.b.a.xxA.m(new ad());
        }
        AppMethodBeat.o(48006);
    }
}
