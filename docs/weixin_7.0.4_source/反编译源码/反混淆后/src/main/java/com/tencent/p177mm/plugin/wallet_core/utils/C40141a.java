package com.tencent.p177mm.plugin.wallet_core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32511ad;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C43807e;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C29684b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C4467c;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22560c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.wallet_core.utils.a */
public final class C40141a {
    public LinkedList<Bankcard> eBA;
    ReentrantLock mLock = new ReentrantLock();
    ArrayList<C40144b> tOQ = new ArrayList();
    private C4884c tOR = new C226661();
    public LinkedList<String> tOS;

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$8 */
    public class C143328 implements C5681a<Object, Object> {
        final /* synthetic */ Map tOY;
        final /* synthetic */ C40139a tOZ;
        final /* synthetic */ List tpo;

        public C143328(List list, Map map, C40139a c40139a) {
            this.tpo = list;
            this.tOY = map;
            this.tOZ = c40139a;
        }

        public final Object call(Object obj) {
            AppMethodBeat.m2504i(47991);
            for (Bankcard bankcard : this.tpo) {
                this.tOY.put(bankcard.field_bankcardType, C46362b.acM(bankcard.field_bankcardType));
            }
            if (this.tOZ != null) {
                this.tOZ.mo38177am(this.tOY);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(47991);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$1 */
    class C226661 extends C4884c<C32511ad> {
        C226661() {
            AppMethodBeat.m2504i(47983);
            this.xxI = C32511ad.class.getName().hashCode();
            AppMethodBeat.m2505o(47983);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47984);
            C40141a.this.mLock.lock();
            while (C40141a.this.tOQ != null && C40141a.this.tOQ.size() > 0) {
                C18765a c18765a = (C40144b) C40141a.this.tOQ.remove(0);
                if (c18765a == null) {
                    break;
                }
                Bankcard bankcard = c18765a.thJ;
                ImageView imageView = (ImageView) c18765a.tPb.get();
                if (imageView != null) {
                    String str = (String) imageView.getTag(2131820688);
                    if (!C5046bo.isNullOrNil(str) && ((!C1853r.m3831YM() && str.equals(bankcard.field_bankcardType)) || (C1853r.m3831YM() && str.equals(bankcard.field_bankName)))) {
                        C43807e c43807e;
                        if (bankcard.txc != null) {
                            c43807e = bankcard.txc;
                        } else if (C1853r.m3831YM()) {
                            c43807e = C46362b.m87144i(imageView.getContext(), bankcard.field_bankName, false);
                        } else {
                            c43807e = C46362b.m87144i(imageView.getContext(), bankcard.field_bankcardType, bankcard.cPb());
                        }
                        C40141a c40141a = C40141a.this;
                        if (c43807e == null || c18765a == null || c18765a.tPb == null || c18765a.tPb.get() == null) {
                            C4990ab.m7412e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
                        } else {
                            C4990ab.m7410d("MicroMsg.BankcardLogoHelper", "setLogo bankLogoUrl = " + c43807e.oRi);
                            imageView = (ImageView) c18765a.tPb.get();
                            if (!C5046bo.isNullOrNil(c43807e.oRi)) {
                                imageView.post(new C226672(c18765a, imageView, C18764x.m29325a(new C4467c(c43807e.oRi))));
                                c18765a.tKb = c43807e.oRi;
                                C18764x.m29326a(c18765a);
                            } else if (c43807e.txs > 0) {
                                imageView.post(new C226683(imageView, c43807e));
                            } else {
                                C4990ab.m7412e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
                            }
                        }
                        c40141a = C40141a.this;
                        if (!(c43807e == null || c18765a == null || c18765a.tPc == null || c18765a.tPc.get() == null)) {
                            View view = (View) c18765a.tPc.get();
                            view.post(new C401424(view, c43807e, c18765a));
                        }
                        c40141a = C40141a.this;
                        if (!(c43807e == null || c18765a == null || c18765a.tPc == null || c18765a.tPc.get() == null)) {
                            imageView = (ImageView) c18765a.tPd.get();
                            if (imageView != null) {
                                imageView.post(new C401435(c43807e, imageView, c18765a));
                            }
                        }
                    }
                }
            }
            C40141a.this.mLock.unlock();
            AppMethodBeat.m2505o(47984);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$2 */
    class C226672 implements Runnable {
        final /* synthetic */ ImageView lvs;
        final /* synthetic */ C40144b tOU;
        final /* synthetic */ Bitmap tOV;

        C226672(C40144b c40144b, ImageView imageView, Bitmap bitmap) {
            this.tOU = c40144b;
            this.lvs = imageView;
            this.tOV = bitmap;
        }

        public final void run() {
            AppMethodBeat.m2504i(47985);
            Bankcard bankcard = this.tOU.thJ;
            String str = (String) this.lvs.getTag(2131820688);
            if (C5046bo.isNullOrNil(str) || ((C1853r.m3831YM() || !str.equals(bankcard.field_bankcardType)) && !(C1853r.m3831YM() && str.equals(bankcard.field_bankName)))) {
                C4990ab.m7411d("MicroMsg.BankcardLogoHelper", "not match tag: %s, banktype: %s, iv: %s", str, bankcard.field_bankcardType, this.lvs);
                AppMethodBeat.m2505o(47985);
                return;
            }
            this.lvs.setImageBitmap(this.tOV);
            AppMethodBeat.m2505o(47985);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$3 */
    class C226683 implements Runnable {
        final /* synthetic */ ImageView lvs;
        final /* synthetic */ C43807e tOW;

        C226683(ImageView imageView, C43807e c43807e) {
            this.lvs = imageView;
            this.tOW = c43807e;
        }

        public final void run() {
            AppMethodBeat.m2504i(47986);
            this.lvs.setImageResource(this.tOW.txs);
            AppMethodBeat.m2505o(47986);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$9 */
    public class C226699 implements C5681a<Object, List<Bankcard>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(47994);
            Object dW = m34355dW((List) obj);
            AppMethodBeat.m2505o(47994);
            return dW;
        }

        /* renamed from: dW */
        private Object m34355dW(List<Bankcard> list) {
            AppMethodBeat.m2504i(47993);
            if (list != null && list.size() > 0) {
                int size = list.size();
                C40141a.this.tOS = new LinkedList();
                for (int i = 0; i < size; i++) {
                    Bankcard bankcard = (Bankcard) list.get(i);
                    if (bankcard.cPc()) {
                        C4990ab.m7416i("MicroMsg.BankcardLogoHelper", "ignore balance!!");
                    } else {
                        C40141a.this.tOS.add(bankcard.field_bankcardType);
                    }
                }
                if (C40141a.this.tOS.size() > 0) {
                    C4990ab.m7417i("MicroMsg.BankcardLogoHelper", "need fetch bank logo, %s", Integer.valueOf(C40141a.this.tOS.size()));
                    final C5688b dMj = C5698f.dMj();
                    C1207m c22560c = new C22560c(C40141a.this.tOS);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14539a(1650, new C1202f() {
                        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                            AppMethodBeat.m2504i(47992);
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14546b(1650, (C1202f) this);
                            C40141a.this.tOS = null;
                            C5698f.m8556a(dMj, new Object[0]);
                            AppMethodBeat.m2505o(47992);
                        }
                    });
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(c22560c, 0);
                    dMj.dMi();
                }
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(47993);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$a */
    public interface C40139a {
        /* renamed from: am */
        void mo38177am(Map<String, C43807e> map);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$4 */
    class C401424 implements Runnable {
        final /* synthetic */ C40144b tOU;
        final /* synthetic */ C43807e tOW;
        final /* synthetic */ View tOX;

        C401424(View view, C43807e c43807e, C40144b c40144b) {
            this.tOX = view;
            this.tOW = c43807e;
            this.tOU = c40144b;
        }

        public final void run() {
            AppMethodBeat.m2504i(47987);
            this.tOX.invalidate();
            String str = this.tOW.txp;
            int i = "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png".equals(str) ? C25738R.drawable.bkm : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png".equals(str) ? C25738R.drawable.bkp : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png".equals(str) ? C25738R.drawable.bkr : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png".equals(str) ? C25738R.drawable.bkw : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png".equals(str) ? C25738R.drawable.bkx : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png".equals(str) ? C25738R.drawable.bl2 : -1;
            TextView textView;
            int pixel;
            if (i != -1) {
                this.tOX.setBackgroundResource(i);
                Bitmap decodeResource = BitmapFactory.decodeResource(this.tOX.getResources(), i);
                C4990ab.m7411d("MicroMsg.BankcardLogoHelper", "local bg color: %s", Integer.valueOf(decodeResource.getPixel(decodeResource.getWidth() / 2, decodeResource.getHeight() / 2)));
                textView = (TextView) this.tOU.tPe.get();
                if (textView != null) {
                    textView.setTextColor(pixel);
                }
                AppMethodBeat.m2505o(47987);
            } else if (C5046bo.isNullOrNil(this.tOW.txp)) {
                if (this.tOW.txt > 0) {
                    this.tOX.setBackgroundResource(this.tOW.txt);
                }
                AppMethodBeat.m2505o(47987);
            } else {
                C9791v c4467c = new C4467c(this.tOW.txp);
                Bitmap a = C18764x.m29325a(c4467c);
                C18764x.m29326a(this.tOU);
                if (a != null) {
                    try {
                        byte[] ninePatchChunk = a.getNinePatchChunk();
                        if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                            C5730e.deleteFile(c4467c.anJ());
                        }
                    } catch (Exception e) {
                    }
                }
                if (a != null) {
                    this.tOX.setBackgroundDrawable(C29684b.m47082b(this.tOX.getContext(), a));
                    pixel = a.getPixel(a.getWidth() / 2, a.getHeight() / 2);
                    textView = (TextView) this.tOU.tPe.get();
                    if (textView != null) {
                        C4990ab.m7411d("MicroMsg.BankcardLogoHelper", "server bg color: %s", Integer.valueOf(pixel));
                        textView.setTextColor(pixel);
                    }
                }
                AppMethodBeat.m2505o(47987);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$5 */
    class C401435 implements Runnable {
        final /* synthetic */ ImageView lvs;
        final /* synthetic */ C40144b tOU;
        final /* synthetic */ C43807e tOW;

        C401435(C43807e c43807e, ImageView imageView, C40144b c40144b) {
            this.tOW = c43807e;
            this.lvs = imageView;
            this.tOU = c40144b;
        }

        public final void run() {
            AppMethodBeat.m2504i(47988);
            if (C5046bo.isNullOrNil(this.tOW.txq)) {
                if (this.tOW.txu > 0) {
                    this.lvs.setImageResource(this.tOW.txu);
                }
                AppMethodBeat.m2505o(47988);
                return;
            }
            this.lvs.setImageBitmap(C18764x.m29325a(new C4467c(this.tOW.txq)));
            C18764x.m29326a(this.tOU);
            AppMethodBeat.m2505o(47988);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$b */
    static class C40144b implements C18765a {
        String tKb;
        WeakReference<ImageView> tPb;
        WeakReference<View> tPc = null;
        WeakReference<ImageView> tPd = null;
        WeakReference<TextView> tPe = null;
        boolean tPf = false;
        Bankcard thJ;

        C40144b() {
        }

        /* renamed from: m */
        public final void mo8136m(String str, final Bitmap bitmap) {
            boolean z = true;
            AppMethodBeat.m2504i(47997);
            C4990ab.m7410d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish " + str + ", bitmap = " + (bitmap == null));
            if (TextUtils.isEmpty(this.tKb)) {
                C4990ab.m7412e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
                AppMethodBeat.m2505o(47997);
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
                C4990ab.m7411d(str3, str4, objArr);
                if (!(imageView == null || str == null || !str.equals(this.tKb))) {
                    if (!this.tPf) {
                        imageView.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(47996);
                                imageView.setImageBitmap(bitmap);
                                AppMethodBeat.m2505o(47996);
                            }
                        });
                        imageView.setTag(2131820688, null);
                    } else if (!(imageView.getTag(2131820688) == null || this.thJ == null || this.thJ.field_bankcardType == null)) {
                        str2 = (String) imageView.getTag(2131820688);
                        if (!C5046bo.isNullOrNil(str2) && str2.equals(this.thJ.field_bankcardType)) {
                            imageView.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(47995);
                                    imageView.setImageBitmap(bitmap);
                                    AppMethodBeat.m2505o(47995);
                                }
                            });
                            imageView.setTag(2131820688, null);
                        }
                        AppMethodBeat.m2505o(47997);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(47997);
        }
    }

    public C40141a() {
        AppMethodBeat.m2504i(47998);
        C4879a.xxA.mo10052c(this.tOR);
        AppMethodBeat.m2505o(47998);
    }

    /* renamed from: a */
    public final void mo63491a(Context context, Bankcard bankcard, ImageView imageView) {
        AppMethodBeat.m2504i(47999);
        mo63492a(context, bankcard, imageView, null, null, null);
        AppMethodBeat.m2505o(47999);
    }

    /* renamed from: j */
    public static void m68840j(ImageView imageView) {
        AppMethodBeat.m2504i(TXRecordCommon.AUDIO_SAMPLERATE_48000);
        if (imageView != null) {
            imageView.setTag(2131820688, null);
            imageView.setImageResource(C25738R.drawable.bki);
        }
        AppMethodBeat.m2505o(TXRecordCommon.AUDIO_SAMPLERATE_48000);
    }

    /* renamed from: a */
    public final void mo63493a(Bankcard bankcard, ImageView imageView) {
        AppMethodBeat.m2504i(48001);
        C18765a c40144b = new C40144b();
        c40144b.thJ = bankcard;
        if (imageView != null) {
            imageView.setTag(2131820688, bankcard.field_bankcardType);
            c40144b.tPb = new WeakReference(imageView);
        }
        final C43807e c43807e = bankcard.txc;
        if (c43807e == null || c40144b.tPb == null || c40144b.tPb.get() == null) {
            C4990ab.m7412e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
            AppMethodBeat.m2505o(48001);
            return;
        }
        C4990ab.m7410d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + c43807e.oRi);
        final ImageView imageView2 = (ImageView) c40144b.tPb.get();
        if (!C5046bo.isNullOrNil(c43807e.oRi)) {
            c40144b.tKb = c43807e.oRi;
            c40144b.tPf = true;
            Bitmap a = C18764x.m29325a(new C4467c(c43807e.oRi));
            if (a != null) {
                imageView2.setImageBitmap(a);
            }
            C18764x.m29326a(c40144b);
            AppMethodBeat.m2505o(48001);
        } else if (c43807e.txs > 0) {
            imageView2.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(47989);
                    imageView2.setImageResource(c43807e.txs);
                    AppMethodBeat.m2505o(47989);
                }
            });
            AppMethodBeat.m2505o(48001);
        } else {
            C4990ab.m7412e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
            AppMethodBeat.m2505o(48001);
        }
    }

    /* renamed from: a */
    public final void mo63492a(Context context, Bankcard bankcard, ImageView imageView, View view, ImageView imageView2, TextView textView) {
        AppMethodBeat.m2504i(48002);
        C40144b c40144b = new C40144b();
        c40144b.tPf = false;
        c40144b.thJ = bankcard;
        if (imageView != null) {
            imageView.setTag(2131820688, bankcard.field_bankcardType);
            c40144b.tPb = new WeakReference(imageView);
        }
        if (view != null) {
            c40144b.tPc = new WeakReference(view);
        }
        if (imageView2 != null) {
            c40144b.tPd = new WeakReference(imageView2);
        }
        if (textView != null) {
            c40144b.tPe = new WeakReference(textView);
        }
        this.tOQ.add(c40144b);
        m68838a(context, bankcard);
        AppMethodBeat.m2505o(48002);
    }

    public final void destory() {
        AppMethodBeat.m2504i(48003);
        C4879a.xxA.mo10053d(this.tOR);
        if (this.tOQ != null) {
            this.tOQ.clear();
            this.tOQ = null;
        }
        AppMethodBeat.m2505o(48003);
    }

    /* renamed from: a */
    private void m68838a(Context context, Bankcard bankcard) {
        Object obj;
        AppMethodBeat.m2504i(48004);
        if (C1853r.m3831YM()) {
            obj = bankcard.field_bankName;
        } else {
            obj = bankcard.field_bankcardType;
        }
        if (this.tOS == null || !this.tOS.contains(obj)) {
            if (C40141a.m68839b(context, bankcard)) {
                C4879a.xxA.mo10055m(new C32511ad());
            } else {
                if (this.eBA == null) {
                    this.eBA = new LinkedList();
                }
                this.eBA.add(bankcard);
                if (this.tOS == null) {
                    mo63494b(context, this.eBA);
                    AppMethodBeat.m2505o(48004);
                    return;
                }
            }
            AppMethodBeat.m2505o(48004);
            return;
        }
        C4990ab.m7416i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(obj)));
        AppMethodBeat.m2505o(48004);
    }

    /* renamed from: b */
    private static boolean m68839b(Context context, Bankcard bankcard) {
        C43807e i;
        AppMethodBeat.m2504i(48005);
        if (C1853r.m3831YM()) {
            i = C46362b.m87144i(context, bankcard.field_bankName, false);
        } else {
            i = C46362b.m87144i(context, bankcard.field_bankcardType, bankcard.cPb());
        }
        if (i == null || i.bNM) {
            AppMethodBeat.m2505o(48005);
            return false;
        }
        AppMethodBeat.m2505o(48005);
        return true;
    }

    /* renamed from: b */
    public final void mo63494b(final Context context, List<Bankcard> list) {
        AppMethodBeat.m2504i(48006);
        if (list != null && list.size() > 0) {
            int size = list.size();
            this.tOS = new LinkedList();
            for (int i = 0; i < size; i++) {
                Bankcard bankcard = (Bankcard) list.get(i);
                if (bankcard.cPc()) {
                    C4990ab.m7416i("MicroMsg.BankcardLogoHelper", "ignore balance");
                } else if (!C40141a.m68839b(context, bankcard)) {
                    C4990ab.m7416i("MicroMsg.BankcardLogoHelper", bankcard.field_bankcardType + "'s url is null or need update");
                    this.tOS.add(bankcard.field_bankcardType);
                }
            }
            if (this.tOS.size() > 0) {
                C4990ab.m7416i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
                C1207m c22560c = new C22560c(this.tOS);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(1650, new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(47990);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14546b(1650, (C1202f) this);
                        C40141a.this.tOS = null;
                        if (C40141a.this.eBA != null) {
                            C40141a.this.mo63494b(context, C40141a.this.eBA);
                            C40141a.this.eBA = null;
                        }
                        AppMethodBeat.m2505o(47990);
                    }
                });
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c22560c, 0);
                AppMethodBeat.m2505o(48006);
                return;
            }
            C4990ab.m7416i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
            C4879a.xxA.mo10055m(new C32511ad());
        }
        AppMethodBeat.m2505o(48006);
    }
}
